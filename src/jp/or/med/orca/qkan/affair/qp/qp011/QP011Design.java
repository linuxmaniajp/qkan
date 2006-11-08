
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
 * 作成日: 2006/09/05  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 訪問看護療養費領収書一覧 (011)
 * プログラム 訪問看護療養費領収書一覧 (QP011)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp011;
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
 * 訪問看護療養費領収書一覧画面項目デザイン(QP011) 
 */
public class QP011Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton find;

  private ACAffairButton detail;

  private ACAffairButton insert;

  private ACAffairButton delete;

  private ACPanel contents;

  private ACGroupBox patientInfomationContents;

  private ACTextField patientCode;

  private ACLabelContainer patientCodeContainer;

  private ACTextField patientName;

  private ACLabelContainer patientNameContainer;

  private ACGroupBox findConditions;

  private QkanYearDateTextField targetDate;

  private ACLabelContainer targetDateContainer;

  private ACGroupBox createConditions;

  private ACLabelContainer billSpanContainer;

  private ACLabel billSpanStartYearMonth;

  private ACTextField billSpanStartDay;

  private ACLabel billSpanStartDayUnit;

  private ACLabel billSpan;

  private ACLabel billSpanEndYearMonth;

  private ACTextField billSpanEndDay;

  private ACLabel billSpanEndDayUnit;

  private ACIntegerCheckBox copyCreate;

  private ACGroupBox infomationContents;

  private ACLabel infomation1;

  private ACLabel infomation2;

  private ACLabel infomation3;

  private ACTable bills;

  private VRTableColumnModel billsColumnModel;

  private ACTableColumn billNoColumn;

  private ACTableColumn billPrintedColumn;

  private ACTableColumn billSpanStartColumn;

  private ACTableColumn billSpanEndColumn;

  private ACTableColumn billPrintDateColumn;

  private ACTableColumn billFullCostColumn;

  private ACTableColumn billInsureTypeColumn;

  //getter

  /**
   * ボタンバーを取得します。
   * @return ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("訪問看護療養費領収書一覧");

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

      find.setToolTipText("対象年月の領収書を検索します。");

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

      detail.setToolTipText("選択した領収書を閲覧・編集します。");

      detail.setMnemonic('E');

      detail.setIconPath(ACConstants.ICON_PATH_DETAIL_24);

      addDetail();
    }
    return detail;

  }

  /**
   * 新規を取得します。
   * @return 新規
   */
  public ACAffairButton getInsert(){
    if(insert==null){

      insert = new ACAffairButton();

      insert.setText("新規(N)");

      insert.setToolTipText("新規に領収書を作成します。");

      insert.setMnemonic('N');

      insert.setIconPath(ACConstants.ICON_PATH_NEW_24);

      addInsert();
    }
    return insert;

  }

  /**
   * 削除を取得します。
   * @return 削除
   */
  public ACAffairButton getDelete(){
    if(delete==null){

      delete = new ACAffairButton();

      delete.setText("削除(D)");

      delete.setToolTipText("選択した領収書を削除します。");

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
   * 利用者情報を取得します。
   * @return 利用者情報
   */
  public ACGroupBox getPatientInfomationContents(){
    if(patientInfomationContents==null){

      patientInfomationContents = new ACGroupBox();

      patientInfomationContents.setText("利用者情報");

      addPatientInfomationContents();
    }
    return patientInfomationContents;

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

      patientCode.setEditable(false);

      patientCode.setColumns(15);

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
   * 氏名を取得します。
   * @return 氏名
   */
  public ACTextField getPatientName(){
    if(patientName==null){

      patientName = new ACTextField();

      getPatientNameContainer().setText("氏名");

      patientName.setBindPath("PATIENT_NAME");

      patientName.setEditable(false);

      patientName.setColumns(33);

      addPatientName();
    }
    return patientName;

  }

  /**
   * 氏名コンテナを取得します。
   * @return 氏名コンテナ
   */
  protected ACLabelContainer getPatientNameContainer(){
    if(patientNameContainer==null){
      patientNameContainer = new ACLabelContainer();
      patientNameContainer.setFollowChildEnabled(true);
      patientNameContainer.setVAlignment(VRLayout.CENTER);
      patientNameContainer.add(getPatientName(), null);
    }
    return patientNameContainer;
  }

  /**
   * 検索条件を取得します。
   * @return 検索条件
   */
  public ACGroupBox getFindConditions(){
    if(findConditions==null){

      findConditions = new ACGroupBox();

      findConditions.setText("検索条件");

      addFindConditions();
    }
    return findConditions;

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
   * 作成条件を取得します。
   * @return 作成条件
   */
  public ACGroupBox getCreateConditions(){
    if(createConditions==null){

      createConditions = new ACGroupBox();

      createConditions.setText("作成条件");

      addCreateConditions();
    }
    return createConditions;

  }

  /**
   * 請求期間を取得します。
   * @return 請求期間
   */
  public ACLabelContainer getBillSpanContainer(){
    if(billSpanContainer==null){

      billSpanContainer = new ACLabelContainer();

      billSpanContainer.setText("請求期間");

      addBillSpanContainer();
    }
    return billSpanContainer;

  }

  /**
   * 請求期間開始年月を取得します。
   * @return 請求期間開始年月
   */
  public ACLabel getBillSpanStartYearMonth(){
    if(billSpanStartYearMonth==null){

      billSpanStartYearMonth = new ACLabel();

      billSpanStartYearMonth.setText("平成18年09月");

      billSpanStartYearMonth.setBindPath("BILL_DATE");

      billSpanStartYearMonth.setFormat(new ACBorderBlankDateFormat("gggee年MM月"));

      addBillSpanStartYearMonth();
    }
    return billSpanStartYearMonth;

  }

  /**
   * 請求期間開始日を取得します。
   * @return 請求期間開始日
   */
  public ACTextField getBillSpanStartDay(){
    if(billSpanStartDay==null){

      billSpanStartDay = new ACTextField();

      billSpanStartDay.setText("1");

      billSpanStartDay.setBindPath("BILL_SPAN_START_DAY");

      billSpanStartDay.setColumns(2);

      billSpanStartDay.setCharType(VRCharType.ONLY_DIGIT);

      billSpanStartDay.setIMEMode(InputSubset.LATIN);

      billSpanStartDay.setMaxLength(2);

      addBillSpanStartDay();
    }
    return billSpanStartDay;

  }

  /**
   * 請求期間開始日単位を取得します。
   * @return 請求期間開始日単位
   */
  public ACLabel getBillSpanStartDayUnit(){
    if(billSpanStartDayUnit==null){

      billSpanStartDayUnit = new ACLabel();

      billSpanStartDayUnit.setText("日");

      addBillSpanStartDayUnit();
    }
    return billSpanStartDayUnit;

  }

  /**
   * からを取得します。
   * @return から
   */
  public ACLabel getBillSpan(){
    if(billSpan==null){

      billSpan = new ACLabel();

      billSpan.setText(" から ");

      addBillSpan();
    }
    return billSpan;

  }

  /**
   * 請求期間終了年月を取得します。
   * @return 請求期間終了年月
   */
  public ACLabel getBillSpanEndYearMonth(){
    if(billSpanEndYearMonth==null){

      billSpanEndYearMonth = new ACLabel();

      billSpanEndYearMonth.setText("平成18年09月");

      billSpanEndYearMonth.setBindPath("BILL_DATE");

      billSpanEndYearMonth.setFormat(new ACBorderBlankDateFormat("gggee年MM月"));

      addBillSpanEndYearMonth();
    }
    return billSpanEndYearMonth;

  }

  /**
   * 請求期間終了日を取得します。
   * @return 請求期間終了日
   */
  public ACTextField getBillSpanEndDay(){
    if(billSpanEndDay==null){

      billSpanEndDay = new ACTextField();

      billSpanEndDay.setBindPath("BILL_SPAN_END_DAY");

      billSpanEndDay.setColumns(2);

      billSpanEndDay.setCharType(VRCharType.ONLY_DIGIT);

      billSpanEndDay.setIMEMode(InputSubset.LATIN);

      billSpanEndDay.setMaxLength(2);

      addBillSpanEndDay();
    }
    return billSpanEndDay;

  }

  /**
   * 請求期間終了日単位を取得します。
   * @return 請求期間終了日単位
   */
  public ACLabel getBillSpanEndDayUnit(){
    if(billSpanEndDayUnit==null){

      billSpanEndDayUnit = new ACLabel();

      billSpanEndDayUnit.setText("日");

      addBillSpanEndDayUnit();
    }
    return billSpanEndDayUnit;

  }

  /**
   * 複製可否を取得します。
   * @return 複製可否
   */
  public ACIntegerCheckBox getCopyCreate(){
    if(copyCreate==null){

      copyCreate = new ACIntegerCheckBox();

      copyCreate.setText("選択した領収書を複製して新規作成(C)");

      copyCreate.setBindPath("COPY_CREATE");

      copyCreate.setMnemonic('C');

      addCopyCreate();
    }
    return copyCreate;

  }

  /**
   * 操作説明領域を取得します。
   * @return 操作説明領域
   */
  public ACGroupBox getInfomationContents(){
    if(infomationContents==null){

      infomationContents = new ACGroupBox();

      infomationContents.setText("操作説明");

      addInfomationContents();
    }
    return infomationContents;

  }

  /**
   * 操作説明1を取得します。
   * @return 操作説明1
   */
  public ACLabel getInfomation1(){
    if(infomation1==null){

      infomation1 = new ACLabel();

      infomation1.setText("(1)【過去に作成した領収書を閲覧・編集する場合】対象年月を指定して検索。一覧から目的の領収書を選択。詳細ボタンを押下。");

      infomation1.setAutoWrap(true);

      addInfomation1();
    }
    return infomation1;

  }

  /**
   * 操作説明2を取得します。
   * @return 操作説明2
   */
  public ACLabel getInfomation2(){
    if(infomation2==null){

      infomation2 = new ACLabel();

      infomation2.setText("(2)【新規に領収書を作成する場合】新規に作成する領収書の請求期間を入力。「選択した領収書を複製して新規作成」のチェックをはずす。新規ボタンを押下。");

      infomation2.setAutoWrap(true);

      addInfomation2();
    }
    return infomation2;

  }

  /**
   * 操作説明3を取得します。
   * @return 操作説明3
   */
  public ACLabel getInfomation3(){
    if(infomation3==null){

      infomation3 = new ACLabel();

      infomation3.setText("(3)【過去に作成した領収書を複製して新規に領収書を作成する場合】(1)の手順で複製元の請求書を選択。新規に作成する領収書の請求期間を入力。「選択した領収書を複製して新規作成」にチェックをつける。新規ボタンを押下。");

      infomation3.setAutoWrap(true);

      addInfomation3();
    }
    return infomation3;

  }

  /**
   * 領収書一覧を取得します。
   * @return 領収書一覧
   */
  public ACTable getBills(){
    if(bills==null){

      bills = new ACTable();

      bills.setColumnModel(getBillsColumnModel());

      addBills();
    }
    return bills;

  }

  /**
   * 領収書一覧カラムモデルを取得します。
   * @return 領収書一覧カラムモデル
   */
  protected VRTableColumnModel getBillsColumnModel(){
    if(billsColumnModel==null){
      billsColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addBillsColumnModel();
    }
    return billsColumnModel;
  }

  /**
   * 領収書一覧：No.を取得します。
   * @return 領収書一覧：No.
   */
  public ACTableColumn getBillNoColumn(){
    if(billNoColumn==null){

      billNoColumn = new ACTableColumn();

      billNoColumn.setHeaderValue("No.");

      billNoColumn.setColumnName("BILL_PRINTED");

      billNoColumn.setColumns(3);

      billNoColumn.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      billNoColumn.setSortable(false);

      addBillNoColumn();
    }
    return billNoColumn;

  }

  /**
   * 領収書一覧：印刷を取得します。
   * @return 領収書一覧：印刷
   */
  public ACTableColumn getBillPrintedColumn(){
    if(billPrintedColumn==null){

      billPrintedColumn = new ACTableColumn();

      billPrintedColumn.setHeaderValue("印刷");

      billPrintedColumn.setColumnName("BILL_PRINTED");

      billPrintedColumn.setColumns(4);

      billPrintedColumn.setFormat(QkanClaimMedicalPrintedFormat.getInstance());

      addBillPrintedColumn();
    }
    return billPrintedColumn;

  }

  /**
   * 領収書一覧：請求期間開始を取得します。
   * @return 領収書一覧：請求期間開始
   */
  public ACTableColumn getBillSpanStartColumn(){
    if(billSpanStartColumn==null){

      billSpanStartColumn = new ACTableColumn();

      billSpanStartColumn.setHeaderValue("請求期間開始");

      billSpanStartColumn.setColumnName("BILL_SPAN_START");

      billSpanStartColumn.setColumns(10);

      billSpanStartColumn.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addBillSpanStartColumn();
    }
    return billSpanStartColumn;

  }

  /**
   * 領収書一覧：請求期間終了を取得します。
   * @return 領収書一覧：請求期間終了
   */
  public ACTableColumn getBillSpanEndColumn(){
    if(billSpanEndColumn==null){

      billSpanEndColumn = new ACTableColumn();

      billSpanEndColumn.setHeaderValue("請求期間終了");

      billSpanEndColumn.setColumnName("BILL_SPAN_END");

      billSpanEndColumn.setColumns(10);

      billSpanEndColumn.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addBillSpanEndColumn();
    }
    return billSpanEndColumn;

  }

  /**
   * 領収書一覧：発行日を取得します。
   * @return 領収書一覧：発行日
   */
  public ACTableColumn getBillPrintDateColumn(){
    if(billPrintDateColumn==null){

      billPrintDateColumn = new ACTableColumn();

      billPrintDateColumn.setHeaderValue("発行日");

      billPrintDateColumn.setColumnName("BILL_PRINT_DATE");

      billPrintDateColumn.setColumns(10);

      billPrintDateColumn.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addBillPrintDateColumn();
    }
    return billPrintDateColumn;

  }

  /**
   * 領収書一覧：領収額合計を取得します。
   * @return 領収書一覧：領収額合計
   */
  public ACTableColumn getBillFullCostColumn(){
    if(billFullCostColumn==null){

      billFullCostColumn = new ACTableColumn();

      billFullCostColumn.setHeaderValue("領収額合計");

      billFullCostColumn.setColumnName("BILL_FULL_TOTAL");

      billFullCostColumn.setColumns(7);

      billFullCostColumn.setHorizontalAlignment(SwingConstants.RIGHT);

      billFullCostColumn.setFormat(NumberFormat.getIntegerInstance());

      addBillFullCostColumn();
    }
    return billFullCostColumn;

  }

  /**
   * 領収書一覧：保険区分を取得します。
   * @return 領収書一覧：保険区分
   */
  public ACTableColumn getBillInsureTypeColumn(){
    if(billInsureTypeColumn==null){

      billInsureTypeColumn = new ACTableColumn();

      billInsureTypeColumn.setHeaderValue("保険区分");

      billInsureTypeColumn.setColumnName("BILL_INSURE_TYPE");

      billInsureTypeColumn.setColumns(10);

      addBillInsureTypeColumn();
    }
    return billInsureTypeColumn;

  }

  /**
   * コンストラクタです。
   */
  public QP011Design() {

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
   * 新規に内部項目を追加します。
   */
  protected void addInsert(){

  }

  /**
   * 削除に内部項目を追加します。
   */
  protected void addDelete(){

  }

  /**
   * クライアント領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getPatientInfomationContents(), VRLayout.NORTH);

    contents.add(getFindConditions(), VRLayout.NORTH);

    contents.add(getCreateConditions(), VRLayout.NORTH);

    contents.add(getInfomationContents(), VRLayout.NORTH);

    contents.add(getBills(), VRLayout.CLIENT);

  }

  /**
   * 利用者情報に内部項目を追加します。
   */
  protected void addPatientInfomationContents(){

    patientInfomationContents.add(getPatientCodeContainer(), VRLayout.FLOW_INSETLINE);

    patientInfomationContents.add(getPatientNameContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 利用者コードに内部項目を追加します。
   */
  protected void addPatientCode(){

  }

  /**
   * 氏名に内部項目を追加します。
   */
  protected void addPatientName(){

  }

  /**
   * 検索条件に内部項目を追加します。
   */
  protected void addFindConditions(){

    findConditions.add(getTargetDateContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 対象年月に内部項目を追加します。
   */
  protected void addTargetDate(){

  }

  /**
   * 作成条件に内部項目を追加します。
   */
  protected void addCreateConditions(){

    createConditions.add(getBillSpanContainer(), VRLayout.FLOW_INSETLINE);

    createConditions.add(getCopyCreate(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 請求期間に内部項目を追加します。
   */
  protected void addBillSpanContainer(){

    billSpanContainer.add(getBillSpanStartYearMonth(), VRLayout.FLOW);

    billSpanContainer.add(getBillSpanStartDay(), VRLayout.FLOW);

    billSpanContainer.add(getBillSpanStartDayUnit(), VRLayout.FLOW);

    billSpanContainer.add(getBillSpan(), VRLayout.FLOW);

    billSpanContainer.add(getBillSpanEndYearMonth(), VRLayout.FLOW);

    billSpanContainer.add(getBillSpanEndDay(), VRLayout.FLOW);

    billSpanContainer.add(getBillSpanEndDayUnit(), VRLayout.FLOW);

  }

  /**
   * 請求期間開始年月に内部項目を追加します。
   */
  protected void addBillSpanStartYearMonth(){

  }

  /**
   * 請求期間開始日に内部項目を追加します。
   */
  protected void addBillSpanStartDay(){

  }

  /**
   * 請求期間開始日単位に内部項目を追加します。
   */
  protected void addBillSpanStartDayUnit(){

  }

  /**
   * からに内部項目を追加します。
   */
  protected void addBillSpan(){

  }

  /**
   * 請求期間終了年月に内部項目を追加します。
   */
  protected void addBillSpanEndYearMonth(){

  }

  /**
   * 請求期間終了日に内部項目を追加します。
   */
  protected void addBillSpanEndDay(){

  }

  /**
   * 請求期間終了日単位に内部項目を追加します。
   */
  protected void addBillSpanEndDayUnit(){

  }

  /**
   * 複製可否に内部項目を追加します。
   */
  protected void addCopyCreate(){

  }

  /**
   * 操作説明領域に内部項目を追加します。
   */
  protected void addInfomationContents(){

    infomationContents.add(getInfomation1(), VRLayout.NORTH);

    infomationContents.add(getInfomation2(), VRLayout.NORTH);

    infomationContents.add(getInfomation3(), VRLayout.NORTH);

  }

  /**
   * 操作説明1に内部項目を追加します。
   */
  protected void addInfomation1(){

  }

  /**
   * 操作説明2に内部項目を追加します。
   */
  protected void addInfomation2(){

  }

  /**
   * 操作説明3に内部項目を追加します。
   */
  protected void addInfomation3(){

  }

  /**
   * 領収書一覧に内部項目を追加します。
   */
  protected void addBills(){

  }

  /**
   * 領収書一覧カラムモデルに内部項目を追加します。
   */
  protected void addBillsColumnModel(){

    getBillsColumnModel().addColumn(getBillNoColumn());

    getBillsColumnModel().addColumn(getBillPrintedColumn());

    getBillsColumnModel().addColumn(getBillSpanStartColumn());

    getBillsColumnModel().addColumn(getBillSpanEndColumn());

    getBillsColumnModel().addColumn(getBillPrintDateColumn());

    getBillsColumnModel().addColumn(getBillFullCostColumn());

    getBillsColumnModel().addColumn(getBillInsureTypeColumn());

  }

  /**
   * 領収書一覧：No.に内部項目を追加します。
   */
  protected void addBillNoColumn(){

  }

  /**
   * 領収書一覧：印刷に内部項目を追加します。
   */
  protected void addBillPrintedColumn(){

  }

  /**
   * 領収書一覧：請求期間開始に内部項目を追加します。
   */
  protected void addBillSpanStartColumn(){

  }

  /**
   * 領収書一覧：請求期間終了に内部項目を追加します。
   */
  protected void addBillSpanEndColumn(){

  }

  /**
   * 領収書一覧：発行日に内部項目を追加します。
   */
  protected void addBillPrintDateColumn(){

  }

  /**
   * 領収書一覧：領収額合計に内部項目を追加します。
   */
  protected void addBillFullCostColumn(){

  }

  /**
   * 領収書一覧：保険区分に内部項目を追加します。
   */
  protected void addBillInsureTypeColumn(){

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

    return getBillSpanStartDay();

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    try {
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QP011Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QP011Design getThis() {
    return this;
  }
}
