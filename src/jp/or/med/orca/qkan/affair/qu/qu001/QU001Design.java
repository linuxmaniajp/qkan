
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
 * 開発者: 安武　徳夫
 * 作成日: 2011/12/13  日本コンピューター株式会社 安武　徳夫 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 利用者管理 (U)
 * プロセス 利用者一覧 (001)
 * プログラム 利用者一覧 (QU001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu001;
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
 * 利用者一覧画面項目デザイン(QU001) 
 */
public class QU001Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton find;

  private ACAffairButton detail;

  private ACAffairButton insert;

  private ACAffairButton delete;

  private ACAffairButton print;

  private ACAffairButton printReport;

  private ACAffairButton planInsert;

  private ACAffairButton resultInsert;

  private ACPanel contents;

  private ACPanel findConditions;

  private QkanYearDateTextField targetDate;

  private ACLabelContainer targetDateContainer;

  private ACTextField patientCode;

  private ACLabelContainer patientCodeContainer;

  private ACLabelContainer nowNotEnabledPatientIncludeFindContainer;

  private ACIntegerCheckBox nowNotEnabledPatientIncludeFind;

  private ACTextField patientKana;

  private ACLabelContainer patientKanaContainer;

  private QkanDateTextField birthday;

  private ACLabelContainer birthdayContainer;

  private ACGroupBox providerFindContents;

  private ACComboBox providerName;

  private ACLabelContainer providerNameContainer;

  private ACComboBoxModelAdapter providerNameModel;

  private ACComboBox senmonin;

  private ACLabelContainer senmoninContainer;

  private ACComboBoxModelAdapter senmoninModel;

  private ACTable patients;

  private VRTableColumnModel patientsColumnModel;

  private ACTableColumn patientNoColumn;

  private ACTableColumn patientEnabledColumn;

  private ACTableColumn patientReportColumn;

  private ACTableColumn patientFinishFlagColumn;

  private ACTableColumn patientChoiseColumn;

  private ACTableColumn patientCodeColumn;

  private ACTableColumn patientNameColumn;

  private ACTableColumn patientKanaColumn;

  private ACTableColumn patientSexColumn;

  private ACTableColumn patientBirthColumn;

  private ACTableColumn patientJotaiCodeColumn;

  private ACTableColumn patientInsuredIdColumn;

  private ACTableColumn patientInsureValidStartColumn;

  private ACTableColumn patientInsureValidEndColumn;

  private ACTableColumn patientInsurerIdColumn;

  private ACTableColumn patientZipColumn;

  private ACTableColumn patientAddressColumn;

  private ACTableColumn patientTelColumn;

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
   * 検索(F)を取得します。
   * @return 検索(F)
   */
  public ACAffairButton getFind(){
    if(find==null){

      find = new ACAffairButton();

      find.setText("検索(F)");

      find.setToolTipText("現在入力されている条件により、一覧を表示します。");

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

      detail.setToolTipText("選択された利用者の編集画面に移ります。");

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

      insert.setToolTipText("利用者情報を新規に作成します。");

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

      delete.setToolTipText("選択された利用者の情報を削除します。");

      delete.setMnemonic('D');

      delete.setIconPath(ACConstants.ICON_PATH_DELETE_24);

      addDelete();
    }
    return delete;

  }

  /**
   * 一覧印刷(P)を取得します。
   * @return 一覧印刷(P)
   */
  public ACAffairButton getPrint(){
    if(print==null){

      print = new ACAffairButton();

      print.setText("一覧印刷(P)");

      print.setToolTipText("登録利用者一覧表を印刷します。");

      print.setMnemonic('P');

      print.setIconPath(ACConstants.ICON_PATH_TABLE_PRINT_24);

      addPrint();
    }
    return print;

  }

  /**
   * 印刷(P)を取得します。
   * @return 印刷(P)
   */
  public ACAffairButton getPrintReport(){
    if(printReport==null){

      printReport = new ACAffairButton();

      printReport.setText("印刷(P)");

      printReport.setToolTipText("選択された帳票の印刷を行います。");

      printReport.setMnemonic('P');

      printReport.setIconPath(ACConstants.ICON_PATH_PRINT_24);

      addPrintReport();
    }
    return printReport;

  }

  /**
   * 予定登録(E)を取得します。
   * @return 予定登録(E)
   */
  public ACAffairButton getPlanInsert(){
    if(planInsert==null){

      planInsert = new ACAffairButton();

      planInsert.setText("予定登録(E)");

      planInsert.setToolTipText("選択された利用者のサービス予定登録画面に移ります。");

      planInsert.setMnemonic('E');

      planInsert.setIconPath(ACConstants.ICON_PATH_DETAIL_24);

      addPlanInsert();
    }
    return planInsert;

  }

  /**
   * 実績登録(E)を取得します。
   * @return 実績登録(E)
   */
  public ACAffairButton getResultInsert(){
    if(resultInsert==null){

      resultInsert = new ACAffairButton();

      resultInsert.setText("実績登録(E)");

      resultInsert.setToolTipText("選択された利用者のサービス実績登録画面に移ります。");

      resultInsert.setMnemonic('E');

      resultInsert.setIconPath(ACConstants.ICON_PATH_DETAIL_24);

      addResultInsert();
    }
    return resultInsert;

  }

  /**
   * 入力領域を取得します。
   * @return 入力領域
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      addContents();
    }
    return contents;

  }

  /**
   * 検索条件領域を取得します。
   * @return 検索条件領域
   */
  public ACPanel getFindConditions(){
    if(findConditions==null){

      findConditions = new ACPanel();

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
        targetDate.setMinimumDate(QkanConstants.H2704);
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
   * 利用者Cdを取得します。
   * @return 利用者Cd
   */
  public ACTextField getPatientCode(){
    if(patientCode==null){

      patientCode = new ACTextField();

      getPatientCodeContainer().setText("利用者コード");

      patientCode.setBindPath("PATIENT_CODE");

      patientCode.setColumns(16);

      patientCode.setCharType(VRCharType.ONLY_HALF_CHAR);

      patientCode.setHorizontalAlignment(SwingConstants.LEFT);

      patientCode.setIMEMode(InputSubset.LATIN);

      patientCode.setMaxLength(16);

      addPatientCode();
    }
    return patientCode;

  }

  /**
   * 利用者Cdコンテナを取得します。
   * @return 利用者Cdコンテナ
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
   * 現在有効でない利用者も含めて検索コンテナを取得します。
   * @return 現在有効でない利用者も含めて検索コンテナ
   */
  public ACLabelContainer getNowNotEnabledPatientIncludeFindContainer(){
    if(nowNotEnabledPatientIncludeFindContainer==null){

      nowNotEnabledPatientIncludeFindContainer = new ACLabelContainer();

      addNowNotEnabledPatientIncludeFindContainer();
    }
    return nowNotEnabledPatientIncludeFindContainer;

  }

  /**
   * 現在有効でない利用者も含めて検索を取得します。
   * @return 現在有効でない利用者も含めて検索
   */
  public ACIntegerCheckBox getNowNotEnabledPatientIncludeFind(){
    if(nowNotEnabledPatientIncludeFind==null){

      nowNotEnabledPatientIncludeFind = new ACIntegerCheckBox();

      nowNotEnabledPatientIncludeFind.setText("現在有効でない利用者も含めて検索する(A)");

      nowNotEnabledPatientIncludeFind.setBindPath("HIDE_FLAG");

      nowNotEnabledPatientIncludeFind.setMnemonic('A');

      addNowNotEnabledPatientIncludeFind();
    }
    return nowNotEnabledPatientIncludeFind;

  }

  /**
   * ふりがなを取得します。
   * @return ふりがな
   */
  public ACTextField getPatientKana(){
    if(patientKana==null){

      patientKana = new ACTextField();

      getPatientKanaContainer().setText("ふりがな");

      patientKana.setBindPath("PATIENT_KANA");

      patientKana.setColumns(16);

      patientKana.setHorizontalAlignment(SwingConstants.LEFT);

      patientKana.setIMEMode(InputSubset.KANJI);

      patientKana.setMaxLength(32);

      addPatientKana();
    }
    return patientKana;

  }

  /**
   * ふりがなコンテナを取得します。
   * @return ふりがなコンテナ
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
   * 生年月日を取得します。
   * @return 生年月日
   */
  public QkanDateTextField getBirthday(){
    if(birthday==null){

      birthday = new QkanDateTextField();

      getBirthdayContainer().setText("生年月日");

      birthday.setBindPath("PATIENT_BIRTHDAY");

      addBirthday();
    }
    return birthday;

  }

  /**
   * 生年月日コンテナを取得します。
   * @return 生年月日コンテナ
   */
  protected ACLabelContainer getBirthdayContainer(){
    if(birthdayContainer==null){
      birthdayContainer = new ACLabelContainer();
      birthdayContainer.setFollowChildEnabled(true);
      birthdayContainer.setVAlignment(VRLayout.CENTER);
      birthdayContainer.add(getBirthday(), null);
    }
    return birthdayContainer;
  }

  /**
   * 事業所情報検索領域を取得します。
   * @return 事業所情報検索領域
   */
  public ACGroupBox getProviderFindContents(){
    if(providerFindContents==null){

      providerFindContents = new ACGroupBox();

      providerFindContents.setText("事業所情報");

      addProviderFindContents();
    }
    return providerFindContents;

  }

  /**
   * 事業所名を取得します。
   * @return 事業所名
   */
  public ACComboBox getProviderName(){
    if(providerName==null){

      providerName = new ACComboBox();

      getProviderNameContainer().setText("事業所等名");

      providerName.setBindPath("PROVIDER_NAME");

      providerName.setEditable(false);

      providerName.setColumns(18);

      providerName.setModelBindPath("PROVIDER_NAMES");

      providerName.setRenderBindPath("PROVIDER_NAME");

      providerName.setBlankable(true);

      providerName.setIMEMode(InputSubset.KANJI);

      providerName.setMaxLength(60);

      providerName.setMaxColumns(30);

      providerName.setModel(getProviderNameModel());

      addProviderName();
    }
    return providerName;

  }

  /**
   * 事業所名コンテナを取得します。
   * @return 事業所名コンテナ
   */
  protected ACLabelContainer getProviderNameContainer(){
    if(providerNameContainer==null){
      providerNameContainer = new ACLabelContainer();
      providerNameContainer.setFollowChildEnabled(true);
      providerNameContainer.setVAlignment(VRLayout.CENTER);
      providerNameContainer.add(getProviderName(), null);
    }
    return providerNameContainer;
  }

  /**
   * 事業所名モデルを取得します。
   * @return 事業所名モデル
   */
  protected ACComboBoxModelAdapter getProviderNameModel(){
    if(providerNameModel==null){
      providerNameModel = new ACComboBoxModelAdapter();
      addProviderNameModel();
    }
    return providerNameModel;
  }

  /**
   * 介護支援専門員を取得します。
   * @return 介護支援専門員
   */
  public ACComboBox getSenmonin(){
    if(senmonin==null){

      senmonin = new ACComboBox();

      getSenmoninContainer().setText("介護支援専門員等氏名");

      senmonin.setBindPath("SENMONIN");

      senmonin.setEditable(false);

      senmonin.setColumns(8);

      senmonin.setModelBindPath("SENMONIN");

      senmonin.setRenderBindPath("STAFF_NAME");

      senmonin.setBlankable(true);

      senmonin.setIMEMode(InputSubset.KANJI);

      senmonin.setMaxLength(32);

      senmonin.setMaxColumns(20);

      senmonin.setModel(getSenmoninModel());

      addSenmonin();
    }
    return senmonin;

  }

  /**
   * 介護支援専門員コンテナを取得します。
   * @return 介護支援専門員コンテナ
   */
  protected ACLabelContainer getSenmoninContainer(){
    if(senmoninContainer==null){
      senmoninContainer = new ACLabelContainer();
      senmoninContainer.setFollowChildEnabled(true);
      senmoninContainer.setVAlignment(VRLayout.CENTER);
      senmoninContainer.add(getSenmonin(), null);
    }
    return senmoninContainer;
  }

  /**
   * 介護支援専門員モデルを取得します。
   * @return 介護支援専門員モデル
   */
  protected ACComboBoxModelAdapter getSenmoninModel(){
    if(senmoninModel==null){
      senmoninModel = new ACComboBoxModelAdapter();
      addSenmoninModel();
    }
    return senmoninModel;
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
  public ACTableColumn getPatientNoColumn(){
    if(patientNoColumn==null){

      patientNoColumn = new ACTableColumn();

      patientNoColumn.setHeaderValue("No.");

      patientNoColumn.setColumnName("SHOW_FLAG");

      patientNoColumn.setColumns(3);

      patientNoColumn.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      patientNoColumn.setSortable(false);

      addPatientNoColumn();
    }
    return patientNoColumn;

  }

  /**
   * 利用者一覧：有効を取得します。
   * @return 利用者一覧：有効
   */
  public ACTableColumn getPatientEnabledColumn(){
    if(patientEnabledColumn==null){

      patientEnabledColumn = new ACTableColumn();

      patientEnabledColumn.setHeaderValue("有効");

      patientEnabledColumn.setColumnName("SHOW_FLAG");

      patientEnabledColumn.setColumns(3);

      patientEnabledColumn.setHorizontalAlignment(SwingConstants.CENTER);

      patientEnabledColumn.setRendererType(ACTableCellViewer.RENDERER_TYPE_ICON);

      patientEnabledColumn.setSortable(false);

      addPatientEnabledColumn();
    }
    return patientEnabledColumn;

  }

  /**
   * 利用者一覧：有無を取得します。
   * @return 利用者一覧：有無
   */
  public ACTableColumn getPatientReportColumn(){
    if(patientReportColumn==null){

      patientReportColumn = new ACTableColumn();

      patientReportColumn.setHeaderValue("有無");

      patientReportColumn.setColumnName("REPORT");

      patientReportColumn.setColumns(3);

      patientReportColumn.setHorizontalAlignment(SwingConstants.CENTER);

      patientReportColumn.setRendererType(ACTableCellViewer.RENDERER_TYPE_ICON);

      patientReportColumn.setSortable(false);

      addPatientReportColumn();
    }
    return patientReportColumn;

  }

  /**
   * 利用者一覧：印刷を取得します。
   * @return 利用者一覧：印刷
   */
  public ACTableColumn getPatientFinishFlagColumn(){
    if(patientFinishFlagColumn==null){

      patientFinishFlagColumn = new ACTableColumn();

      patientFinishFlagColumn.setHeaderValue("印刷");

      patientFinishFlagColumn.setColumnName("FINISH_FLAG");

      patientFinishFlagColumn.setColumns(3);

      patientFinishFlagColumn.setHorizontalAlignment(SwingConstants.LEFT);

      patientFinishFlagColumn.setSortable(true);

      addPatientFinishFlagColumn();
    }
    return patientFinishFlagColumn;

  }

  /**
   * 利用者一覧：選択を取得します。
   * @return 利用者一覧：選択
   */
  public ACTableColumn getPatientChoiseColumn(){
    if(patientChoiseColumn==null){

      patientChoiseColumn = new ACTableColumn();

      patientChoiseColumn.setHeaderValue("選択");

      patientChoiseColumn.setColumnName("CHOISE");

      patientChoiseColumn.setEditable(true);

      patientChoiseColumn.setColumns(3);

      patientChoiseColumn.setHorizontalAlignment(SwingConstants.CENTER);

      patientChoiseColumn.setRendererType(VRTableCellViewer.RENDERER_TYPE_CHECK_BOX);

      patientChoiseColumn.setEditorType(VRTableCellViewer.EDITOR_TYPE_CHECK_BOX);

      patientChoiseColumn.setHeaderPopupMenu( new ACCheckBoxTableColumnPopupMenu(getPatients(), "CHOISE", new Boolean(true), new Boolean(false)) );

      addPatientChoiseColumn();
    }
    return patientChoiseColumn;

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

      patientCodeColumn.setColumns(7);

      addPatientCodeColumn();
    }
    return patientCodeColumn;

  }

  /**
   * 利用者一覧：氏名を取得します。
   * @return 利用者一覧：氏名
   */
  public ACTableColumn getPatientNameColumn(){
    if(patientNameColumn==null){

      patientNameColumn = new ACTableColumn();

      patientNameColumn.setHeaderValue("氏名");

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

      patientKanaColumn.setColumns(15);

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

      patientSexColumn.setColumns(3);

      patientSexColumn.setFormat(QkanConstants.FORMAT_SEX);

      addPatientSexColumn();
    }
    return patientSexColumn;

  }

  /**
   * 利用者一覧：生年月日を取得します。
   * @return 利用者一覧：生年月日
   */
  public ACTableColumn getPatientBirthColumn(){
    if(patientBirthColumn==null){

      patientBirthColumn = new ACTableColumn();

      patientBirthColumn.setHeaderValue("生年月日");

      patientBirthColumn.setColumnName("PATIENT_BIRTHDAY");

      patientBirthColumn.setColumns(10);

      patientBirthColumn.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addPatientBirthColumn();
    }
    return patientBirthColumn;

  }

  /**
   * 利用者一覧：要介護度を取得します。
   * @return 利用者一覧：要介護度
   */
  public ACTableColumn getPatientJotaiCodeColumn(){
    if(patientJotaiCodeColumn==null){

      patientJotaiCodeColumn = new ACTableColumn();

      patientJotaiCodeColumn.setHeaderValue("要介護度");

      patientJotaiCodeColumn.setColumnName("JOTAI_CODE");

      patientJotaiCodeColumn.setColumns(6);

      patientJotaiCodeColumn.setFormat(QkanJotaiCodeFormat.getInstance());

      addPatientJotaiCodeColumn();
    }
    return patientJotaiCodeColumn;

  }

  /**
   * 利用者一覧：被保険者番号を取得します。
   * @return 利用者一覧：被保険者番号
   */
  public ACTableColumn getPatientInsuredIdColumn(){
    if(patientInsuredIdColumn==null){

      patientInsuredIdColumn = new ACTableColumn();

      patientInsuredIdColumn.setHeaderValue("被保険者番号");

      patientInsuredIdColumn.setColumnName("INSURED_ID");

      patientInsuredIdColumn.setColumns(8);

      addPatientInsuredIdColumn();
    }
    return patientInsuredIdColumn;

  }

  /**
   * 利用者一覧：有効期限開始を取得します。
   * @return 利用者一覧：有効期限開始
   */
  public ACTableColumn getPatientInsureValidStartColumn(){
    if(patientInsureValidStartColumn==null){

      patientInsureValidStartColumn = new ACTableColumn();

      patientInsureValidStartColumn.setHeaderValue("有効期限開始");

      patientInsureValidStartColumn.setColumnName("INSURE_VALID_START");

      patientInsureValidStartColumn.setColumns(10);

      patientInsureValidStartColumn.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addPatientInsureValidStartColumn();
    }
    return patientInsureValidStartColumn;

  }

  /**
   * 利用者一覧：有効期限終了を取得します。
   * @return 利用者一覧：有効期限終了
   */
  public ACTableColumn getPatientInsureValidEndColumn(){
    if(patientInsureValidEndColumn==null){

      patientInsureValidEndColumn = new ACTableColumn();

      patientInsureValidEndColumn.setHeaderValue("有効期限終了");

      patientInsureValidEndColumn.setColumnName("INSURE_VALID_END");

      patientInsureValidEndColumn.setColumns(10);

      patientInsureValidEndColumn.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addPatientInsureValidEndColumn();
    }
    return patientInsureValidEndColumn;

  }

  /**
   * 利用者一覧：保険者番号を取得します。
   * @return 利用者一覧：保険者番号
   */
  public ACTableColumn getPatientInsurerIdColumn(){
    if(patientInsurerIdColumn==null){

      patientInsurerIdColumn = new ACTableColumn();

      patientInsurerIdColumn.setHeaderValue("保険者番号");

      patientInsurerIdColumn.setColumnName("INSURER_ID");

      patientInsurerIdColumn.setColumns(6);

      addPatientInsurerIdColumn();
    }
    return patientInsurerIdColumn;

  }

  /**
   * 利用者一覧：郵便番号を取得します。
   * @return 利用者一覧：郵便番号
   */
  public ACTableColumn getPatientZipColumn(){
    if(patientZipColumn==null){

      patientZipColumn = new ACTableColumn();

      patientZipColumn.setHeaderValue("郵便番号");

      patientZipColumn.setColumnName("PATIENT_ZIP_FIRST+'-'+PATIENT_ZIP_SECOND");

      patientZipColumn.setColumns(6);

      addPatientZipColumn();
    }
    return patientZipColumn;

  }

  /**
   * 利用者一覧：住所を取得します。
   * @return 利用者一覧：住所
   */
  public ACTableColumn getPatientAddressColumn(){
    if(patientAddressColumn==null){

      patientAddressColumn = new ACTableColumn();

      patientAddressColumn.setHeaderValue("住所");

      patientAddressColumn.setColumnName("PATIENT_ADDRESS");

      patientAddressColumn.setColumns(20);

      addPatientAddressColumn();
    }
    return patientAddressColumn;

  }

  /**
   * 利用者一覧：電話番号を取得します。
   * @return 利用者一覧：電話番号
   */
  public ACTableColumn getPatientTelColumn(){
    if(patientTelColumn==null){

      patientTelColumn = new ACTableColumn();

      patientTelColumn.setHeaderValue("電話番号");

      patientTelColumn.setColumnName("PATIENT_TEL_FIRST+'-'+PATIENT_TEL_SECOND+'-'+PATIENT_TEL_THIRD");

      patientTelColumn.setColumns(20);

      addPatientTelColumn();
    }
    return patientTelColumn;

  }

  /**
   * コンストラクタです。
   */
  public QU001Design() {

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

    buttons.add(getResultInsert(), VRLayout.EAST);
    buttons.add(getPlanInsert(), VRLayout.EAST);
    buttons.add(getPrintReport(), VRLayout.EAST);
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
   * 一覧印刷(P)に内部項目を追加します。
   */
  protected void addPrint(){

  }

  /**
   * 印刷(P)に内部項目を追加します。
   */
  protected void addPrintReport(){

  }

  /**
   * 予定登録(E)に内部項目を追加します。
   */
  protected void addPlanInsert(){

  }

  /**
   * 実績登録(E)に内部項目を追加します。
   */
  protected void addResultInsert(){

  }

  /**
   * 入力領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getFindConditions(), VRLayout.NORTH);

    contents.add(getProviderFindContents(), VRLayout.NORTH);

    contents.add(getPatients(), VRLayout.CLIENT);

  }

  /**
   * 検索条件領域に内部項目を追加します。
   */
  protected void addFindConditions(){

    findConditions.add(getTargetDateContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    findConditions.add(getPatientCodeContainer(), VRLayout.FLOW_INSETLINE);

    findConditions.add(getNowNotEnabledPatientIncludeFindContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    findConditions.add(getPatientKanaContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    findConditions.add(getBirthdayContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 対象年月に内部項目を追加します。
   */
  protected void addTargetDate(){

  }

  /**
   * 利用者Cdに内部項目を追加します。
   */
  protected void addPatientCode(){

  }

  /**
   * 現在有効でない利用者も含めて検索コンテナに内部項目を追加します。
   */
  protected void addNowNotEnabledPatientIncludeFindContainer(){

    nowNotEnabledPatientIncludeFindContainer.add(getNowNotEnabledPatientIncludeFind(), null);

  }

  /**
   * 現在有効でない利用者も含めて検索に内部項目を追加します。
   */
  protected void addNowNotEnabledPatientIncludeFind(){

  }

  /**
   * ふりがなに内部項目を追加します。
   */
  protected void addPatientKana(){

  }

  /**
   * 生年月日に内部項目を追加します。
   */
  protected void addBirthday(){

  }

  /**
   * 事業所情報検索領域に内部項目を追加します。
   */
  protected void addProviderFindContents(){

    providerFindContents.add(getProviderNameContainer(), VRLayout.FLOW);

    providerFindContents.add(getSenmoninContainer(), VRLayout.FLOW);

  }

  /**
   * 事業所名に内部項目を追加します。
   */
  protected void addProviderName(){

  }

  /**
   * 事業所名モデルに内部項目を追加します。
   */
  protected void addProviderNameModel(){

  }

  /**
   * 介護支援専門員に内部項目を追加します。
   */
  protected void addSenmonin(){

  }

  /**
   * 介護支援専門員モデルに内部項目を追加します。
   */
  protected void addSenmoninModel(){

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

    getPatientsColumnModel().addColumn(getPatientNoColumn());

    getPatientsColumnModel().addColumn(getPatientEnabledColumn());

    getPatientsColumnModel().addColumn(getPatientReportColumn());

    getPatientsColumnModel().addColumn(getPatientFinishFlagColumn());

    getPatientsColumnModel().addColumn(getPatientChoiseColumn());

    getPatientsColumnModel().addColumn(getPatientCodeColumn());

    getPatientsColumnModel().addColumn(getPatientNameColumn());

    getPatientsColumnModel().addColumn(getPatientKanaColumn());

    getPatientsColumnModel().addColumn(getPatientSexColumn());

    getPatientsColumnModel().addColumn(getPatientBirthColumn());

    getPatientsColumnModel().addColumn(getPatientJotaiCodeColumn());

    getPatientsColumnModel().addColumn(getPatientInsuredIdColumn());

    getPatientsColumnModel().addColumn(getPatientInsureValidStartColumn());

    getPatientsColumnModel().addColumn(getPatientInsureValidEndColumn());

    getPatientsColumnModel().addColumn(getPatientInsurerIdColumn());

    getPatientsColumnModel().addColumn(getPatientZipColumn());

    getPatientsColumnModel().addColumn(getPatientAddressColumn());

    getPatientsColumnModel().addColumn(getPatientTelColumn());

  }

  /**
   * 利用者一覧：No.に内部項目を追加します。
   */
  protected void addPatientNoColumn(){

  }

  /**
   * 利用者一覧：有効に内部項目を追加します。
   */
  protected void addPatientEnabledColumn(){

  }

  /**
   * 利用者一覧：有無に内部項目を追加します。
   */
  protected void addPatientReportColumn(){

  }

  /**
   * 利用者一覧：印刷に内部項目を追加します。
   */
  protected void addPatientFinishFlagColumn(){

  }

  /**
   * 利用者一覧：選択に内部項目を追加します。
   */
  protected void addPatientChoiseColumn(){

  }

  /**
   * 利用者一覧：利用者コードに内部項目を追加します。
   */
  protected void addPatientCodeColumn(){

  }

  /**
   * 利用者一覧：氏名に内部項目を追加します。
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
   * 利用者一覧：生年月日に内部項目を追加します。
   */
  protected void addPatientBirthColumn(){

  }

  /**
   * 利用者一覧：要介護度に内部項目を追加します。
   */
  protected void addPatientJotaiCodeColumn(){

  }

  /**
   * 利用者一覧：被保険者番号に内部項目を追加します。
   */
  protected void addPatientInsuredIdColumn(){

  }

  /**
   * 利用者一覧：有効期限開始に内部項目を追加します。
   */
  protected void addPatientInsureValidStartColumn(){

  }

  /**
   * 利用者一覧：有効期限終了に内部項目を追加します。
   */
  protected void addPatientInsureValidEndColumn(){

  }

  /**
   * 利用者一覧：保険者番号に内部項目を追加します。
   */
  protected void addPatientInsurerIdColumn(){

  }

  /**
   * 利用者一覧：郵便番号に内部項目を追加します。
   */
  protected void addPatientZipColumn(){

  }

  /**
   * 利用者一覧：住所に内部項目を追加します。
   */
  protected void addPatientAddressColumn(){

  }

  /**
   * 利用者一覧：電話番号に内部項目を追加します。
   */
  protected void addPatientTelColumn(){

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
      ACFrame.debugStart(new ACAffairInfo(QU001Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QU001Design getThis() {
    return this;
  }
}
