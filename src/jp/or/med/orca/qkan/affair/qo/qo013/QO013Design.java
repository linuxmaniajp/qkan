
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
 * 作成日: 2012/01/24  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その多機能 (O)
 * プロセス 日医標準レセプトソフト連携 (013)
 * プログラム 日医標準レセプトソフト連携 (QO013)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo013;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACAffairButton;
import jp.nichicom.ac.component.ACAffairButtonBar;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACIntegerCheckBox;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.table.ACCheckBoxTableColumnPopupMenu;
import jp.nichicom.ac.component.table.ACTable;
import jp.nichicom.ac.component.table.ACTableColumn;
import jp.nichicom.ac.container.ACBackLabelContainer;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACAffairable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.text.ACBorderBlankDateFormat;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.vr.component.table.VRTableCellViewer;
import jp.nichicom.vr.component.table.VRTableColumnModel;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanAffairContainer;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * 日医標準レセプトソフト連携画面項目デザイン(QO013) 
 */
public class QO013Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton connect;

  private ACAffairButton importPatient;

  private ACGroupBox connectSettings;

  private ACTextField hostName;

  private ACLabelContainer hostNameContainer;

  private ACTextField portNo;

  private ACLabelContainer portNoContainer;

  private ACTextField dbsVersion;

  private ACLabelContainer dbsVersionContainer;

  private ACTextField userName;

  private ACLabelContainer userNameContainer;

  private ACTextField password;

  private ACLabelContainer passwordContainer;

  private ACComboBox receiptVersionCombo;

  private ACLabelContainer receiptVersionComboContainer;

  private ACComboBoxModelAdapter receiptVersionComboModel;

  private ACGroupBox findSetting;

  private ACBackLabelContainer ageContainer;

  private ACLabel ageContainerTItle;

  private ACTextField ageStartText;

  private ACLabelContainer ageStartTextContainer;

  private ACLabel ageConnectLabel;

  private ACTextField ageEndText;

  private ACLabelContainer ageEndTextContainer;

  private ACLabel ageLabel;

  private ACIntegerCheckBox deduplicationCheck;

  private ACGroupBox importSettings;

  private ACPanel importPanel;

  private ACIntegerCheckBox toHiragana;

  private ACIntegerCheckBox allPageCheck;

  private ACButton previewPage;

  private ACButton nextPage;

  private ACPanel viewRange;

  private ACLabel totalCount;

  private ACLabel totalCountUnit;

  private ACLabel viewBeginNo;

  private ACLabel viewSpan;

  private ACLabel viewEndNo;

  private ACTable patients;

  private VRTableColumnModel patientsColumnModel;

  private ACTableColumn patientNo;

  private ACTableColumn patientImport;

  private ACTableColumn patientBatting;

  private ACTableColumn patientName;

  private ACTableColumn patientKana;

  private ACTableColumn patientSex;

  private ACTableColumn patientAge;

  private ACTableColumn patientBirth;

  private ACTableColumn patientZip;

  private ACTableColumn patientAddress;

  private ACTableColumn patientTel;

  //getter

  /**
   * 業務ボタンバーを取得します。
   * @return 業務ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      addButtons();
    }
    return buttons;

  }

  /**
   * 通信を取得します。
   * @return 通信
   */
  public ACAffairButton getConnect(){
    if(connect==null){

      connect = new ACAffairButton();

      connect.setText("通信(A)");

      connect.setMnemonic('A');

      connect.setIconPath(ACConstants.ICON_PATH_OPEN_24);

      addConnect();
    }
    return connect;

  }

  /**
   * 取り込みを取得します。
   * @return 取り込み
   */
  public ACAffairButton getImportPatient(){
    if(importPatient==null){

      importPatient = new ACAffairButton();

      importPatient.setText("取り込み(I)");

      importPatient.setMnemonic('I');

      importPatient.setIconPath(ACConstants.ICON_PATH_UPDATE_24);

      addImportPatient();
    }
    return importPatient;

  }

  /**
   * 接続設定を取得します。
   * @return 接続設定
   */
  public ACGroupBox getConnectSettings(){
    if(connectSettings==null){

      connectSettings = new ACGroupBox();

      connectSettings.setText("接続設定");

      addConnectSettings();
    }
    return connectSettings;

  }

  /**
   * 接続先ホストを取得します。
   * @return 接続先ホスト
   */
  public ACTextField getHostName(){
    if(hostName==null){

      hostName = new ACTextField();

      getHostNameContainer().setText("接続先ホスト");

      hostName.setBindPath("IP_ADDRESS");

      hostName.setColumns(15);

      hostName.setCharType(ACConstants.CHAR_TYPE_IP_OR_HOSTNAME);

      hostName.setIMEMode(InputSubset.LATIN);

      hostName.setMaxLength(64);

      addHostName();
    }
    return hostName;

  }

  /**
   * 接続先ホストコンテナを取得します。
   * @return 接続先ホストコンテナ
   */
  protected ACLabelContainer getHostNameContainer(){
    if(hostNameContainer==null){
      hostNameContainer = new ACLabelContainer();
      hostNameContainer.setFollowChildEnabled(true);
      hostNameContainer.setVAlignment(VRLayout.CENTER);
      hostNameContainer.add(getHostName(), null);
    }
    return hostNameContainer;
  }

  /**
   * ポート番号を取得します。
   * @return ポート番号
   */
  public ACTextField getPortNo(){
    if(portNo==null){

      portNo = new ACTextField();

      getPortNoContainer().setText("ポート番号");

      portNo.setBindPath("PORT_NO");

      portNo.setColumns(5);

      portNo.setCharType(VRCharType.ONLY_DIGIT);

      portNo.setIMEMode(InputSubset.LATIN);

      portNo.setMaxLength(5);

      addPortNo();
    }
    return portNo;

  }

  /**
   * ポート番号コンテナを取得します。
   * @return ポート番号コンテナ
   */
  protected ACLabelContainer getPortNoContainer(){
    if(portNoContainer==null){
      portNoContainer = new ACLabelContainer();
      portNoContainer.setFollowChildEnabled(true);
      portNoContainer.setVAlignment(VRLayout.CENTER);
      portNoContainer.add(getPortNo(), null);
    }
    return portNoContainer;
  }

  /**
   * DBSバージョンを取得します。
   * @return DBSバージョン
   */
  public ACTextField getDbsVersion(){
    if(dbsVersion==null){

      dbsVersion = new ACTextField();

      getDbsVersionContainer().setText("DBSバージョン");

      dbsVersion.setBindPath("DBS_VERSION");

      dbsVersion.setColumns(10);

      dbsVersion.setIMEMode(InputSubset.LATIN);

      dbsVersion.setMaxLength(10);

      addDbsVersion();
    }
    return dbsVersion;

  }

  /**
   * DBSバージョンコンテナを取得します。
   * @return DBSバージョンコンテナ
   */
  protected ACLabelContainer getDbsVersionContainer(){
    if(dbsVersionContainer==null){
      dbsVersionContainer = new ACLabelContainer();
      dbsVersionContainer.setFollowChildEnabled(true);
      dbsVersionContainer.setVAlignment(VRLayout.CENTER);
      dbsVersionContainer.add(getDbsVersion(), null);
    }
    return dbsVersionContainer;
  }

  /**
   * ユーザー名を取得します。
   * @return ユーザー名
   */
  public ACTextField getUserName(){
    if(userName==null){

      userName = new ACTextField();

      getUserNameContainer().setText("ユーザー名");

      userName.setBindPath("USER_NAME");

      userName.setColumns(15);

      userName.setIMEMode(InputSubset.LATIN);

      userName.setMaxLength(255);

      addUserName();
    }
    return userName;

  }

  /**
   * ユーザー名コンテナを取得します。
   * @return ユーザー名コンテナ
   */
  protected ACLabelContainer getUserNameContainer(){
    if(userNameContainer==null){
      userNameContainer = new ACLabelContainer();
      userNameContainer.setFollowChildEnabled(true);
      userNameContainer.setVAlignment(VRLayout.CENTER);
      userNameContainer.add(getUserName(), null);
    }
    return userNameContainer;
  }

  /**
   * パスワードを取得します。
   * @return パスワード
   */
  public ACTextField getPassword(){
    if(password==null){

      password = new ACTextField();

      getPasswordContainer().setText("パスワード");

      password.setBindPath("PASSWORD");

      password.setColumns(15);

      password.setIMEMode(InputSubset.LATIN);

      password.setMaxLength(255);

      addPassword();
    }
    return password;

  }

  /**
   * パスワードコンテナを取得します。
   * @return パスワードコンテナ
   */
  protected ACLabelContainer getPasswordContainer(){
    if(passwordContainer==null){
      passwordContainer = new ACLabelContainer();
      passwordContainer.setFollowChildEnabled(true);
      passwordContainer.setVAlignment(VRLayout.CENTER);
      passwordContainer.add(getPassword(), null);
    }
    return passwordContainer;
  }

  /**
   * 日医標準レセプトソフトバージョンを取得します。
   * @return 日医標準レセプトソフトバージョン
   */
  public ACComboBox getReceiptVersionCombo(){
    if(receiptVersionCombo==null){

      receiptVersionCombo = new ACComboBox();

      getReceiptVersionComboContainer().setText("日医標準レセプトソフトバージョン");

      receiptVersionCombo.setBindPath("RECEIPT_VERSION_CONTENT");

      receiptVersionCombo.setVisible(true);

      receiptVersionCombo.setEnabled(true);

      receiptVersionCombo.setEditable(false);

      receiptVersionCombo.setColumns(12);

      receiptVersionCombo.setModelBindPath("RECEIPT_VERSION_CONTENT");

      receiptVersionCombo.setRenderBindPath("CONTENT");

      receiptVersionCombo.setBlankable(false);

      receiptVersionCombo.setModel(getReceiptVersionComboModel());

      addReceiptVersionCombo();
    }
    return receiptVersionCombo;

  }

  /**
   * 日医標準レセプトソフトバージョンコンテナを取得します。
   * @return 日医標準レセプトソフトバージョンコンテナ
   */
  protected ACLabelContainer getReceiptVersionComboContainer(){
    if(receiptVersionComboContainer==null){
      receiptVersionComboContainer = new ACLabelContainer();
      receiptVersionComboContainer.setFollowChildEnabled(true);
      receiptVersionComboContainer.setVAlignment(VRLayout.CENTER);
      receiptVersionComboContainer.add(getReceiptVersionCombo(), null);
    }
    return receiptVersionComboContainer;
  }

  /**
   * 日医標準レセプトソフトバージョンモデルを取得します。
   * @return 日医標準レセプトソフトバージョンモデル
   */
  protected ACComboBoxModelAdapter getReceiptVersionComboModel(){
    if(receiptVersionComboModel==null){
      receiptVersionComboModel = new ACComboBoxModelAdapter();
      addReceiptVersionComboModel();
    }
    return receiptVersionComboModel;
  }

  /**
   * 取得条件を取得します。
   * @return 取得条件
   */
  public ACGroupBox getFindSetting(){
    if(findSetting==null){

      findSetting = new ACGroupBox();

      findSetting.setText("取得条件");

      findSetting.setLabelMargin(0);

      findSetting.setVgap(0);

      addFindSetting();
    }
    return findSetting;

  }

  /**
   * 年齢コンテナを取得します。
   * @return 年齢コンテナ
   */
  public ACBackLabelContainer getAgeContainer(){
    if(ageContainer==null){

      ageContainer = new ACBackLabelContainer();

      addAgeContainer();
    }
    return ageContainer;

  }

  /**
   * 年齢タイトルを取得します。
   * @return 年齢タイトル
   */
  public ACLabel getAgeContainerTItle(){
    if(ageContainerTItle==null){

      ageContainerTItle = new ACLabel();

      ageContainerTItle.setText("年齢");

      addAgeContainerTItle();
    }
    return ageContainerTItle;

  }

  /**
   * 年齢指定テキスト（開始）を取得します。
   * @return 年齢指定テキスト（開始）
   */
  public ACTextField getAgeStartText(){
    if(ageStartText==null){

      ageStartText = new ACTextField();

      ageStartText.setBindPath("AGE_START");

      ageStartText.setColumns(3);

      ageStartText.setIMEMode(InputSubset.LATIN);

      ageStartText.setMaxLength(3);

      addAgeStartText();
    }
    return ageStartText;

  }

  /**
   * 年齢指定テキスト（開始）コンテナを取得します。
   * @return 年齢指定テキスト（開始）コンテナ
   */
  protected ACLabelContainer getAgeStartTextContainer(){
    if(ageStartTextContainer==null){
      ageStartTextContainer = new ACLabelContainer();
      ageStartTextContainer.setFollowChildEnabled(true);
      ageStartTextContainer.setVAlignment(VRLayout.CENTER);
      ageStartTextContainer.add(getAgeStartText(), null);
    }
    return ageStartTextContainer;
  }

  /**
   * 年齢ラベルを取得します。
   * @return 年齢ラベル
   */
  public ACLabel getAgeConnectLabel(){
    if(ageConnectLabel==null){

      ageConnectLabel = new ACLabel();

      ageConnectLabel.setText("～");

      addAgeConnectLabel();
    }
    return ageConnectLabel;

  }

  /**
   * 年齢指定テキスト（終了）を取得します。
   * @return 年齢指定テキスト（終了）
   */
  public ACTextField getAgeEndText(){
    if(ageEndText==null){

      ageEndText = new ACTextField();

      ageEndText.setBindPath("AGE_END");

      ageEndText.setColumns(3);

      ageEndText.setIMEMode(InputSubset.LATIN);

      ageEndText.setMaxLength(3);

      addAgeEndText();
    }
    return ageEndText;

  }

  /**
   * 年齢指定テキスト（終了）コンテナを取得します。
   * @return 年齢指定テキスト（終了）コンテナ
   */
  protected ACLabelContainer getAgeEndTextContainer(){
    if(ageEndTextContainer==null){
      ageEndTextContainer = new ACLabelContainer();
      ageEndTextContainer.setFollowChildEnabled(true);
      ageEndTextContainer.setVAlignment(VRLayout.CENTER);
      ageEndTextContainer.add(getAgeEndText(), null);
    }
    return ageEndTextContainer;
  }

  /**
   * 年齢終了ラベルを取得します。
   * @return 年齢終了ラベル
   */
  public ACLabel getAgeLabel(){
    if(ageLabel==null){

      ageLabel = new ACLabel();

      ageLabel.setText("歳");

      addAgeLabel();
    }
    return ageLabel;

  }

  /**
   * 登録済み除外チェックを取得します。
   * @return 登録済み除外チェック
   */
  public ACIntegerCheckBox getDeduplicationCheck(){
    if(deduplicationCheck==null){

      deduplicationCheck = new ACIntegerCheckBox();

      deduplicationCheck.setText("登録済みの患者を除外");

      deduplicationCheck.setBindPath("DEDUPLICATION");

      addDeduplicationCheck();
    }
    return deduplicationCheck;

  }

  /**
   * 取り込み設定を取得します。
   * @return 取り込み設定
   */
  public ACGroupBox getImportSettings(){
    if(importSettings==null){

      importSettings = new ACGroupBox();

      importSettings.setText("取り込み設定");

      importSettings.setLabelMargin(0);

      importSettings.setVgap(0);

      addImportSettings();
    }
    return importSettings;

  }

  /**
   * 取込設定パネルを取得します。
   * @return 取込設定パネル
   */
  public ACPanel getImportPanel(){
    if(importPanel==null){

      importPanel = new ACPanel();

      importPanel.setHgap(0);

      importPanel.setLabelMargin(0);

      importPanel.setVgap(0);

      addImportPanel();
    }
    return importPanel;

  }

  /**
   * カナ指名をひらがなに変換を取得します。
   * @return カナ指名をひらがなに変換
   */
  public ACIntegerCheckBox getToHiragana(){
    if(toHiragana==null){

      toHiragana = new ACIntegerCheckBox();

      toHiragana.setText("カナ氏名をひらがなに変換");

      toHiragana.setBindPath("TO_HIRAGANA");

      addToHiragana();
    }
    return toHiragana;

  }

  /**
   * 500件目以降の患者も取り込むを取得します。
   * @return 500件目以降の患者も取り込む
   */
  public ACIntegerCheckBox getAllPageCheck(){
    if(allPageCheck==null){

      allPageCheck = new ACIntegerCheckBox();

      allPageCheck.setText("500件目以降の患者も取り込む");

      allPageCheck.setBindPath("ALLPAGE");

      addAllPageCheck();
    }
    return allPageCheck;

  }

  /**
   * 前へを取得します。
   * @return 前へ
   */
  public ACButton getPreviewPage(){
    if(previewPage==null){

      previewPage = new ACButton();

      previewPage.setText("前へ");

      addPreviewPage();
    }
    return previewPage;

  }

  /**
   * 次へを取得します。
   * @return 次へ
   */
  public ACButton getNextPage(){
    if(nextPage==null){

      nextPage = new ACButton();

      nextPage.setText("次へ");

      addNextPage();
    }
    return nextPage;

  }

  /**
   * 件数表示を取得します。
   * @return 件数表示
   */
  public ACPanel getViewRange(){
    if(viewRange==null){

      viewRange = new ACPanel();

      viewRange.setAutoWrap(false);

      addViewRange();
    }
    return viewRange;

  }

  /**
   * 全体件数を取得します。
   * @return 全体件数
   */
  public ACLabel getTotalCount(){
    if(totalCount==null){

      totalCount = new ACLabel();

      totalCount.setText("0");

      addTotalCount();
    }
    return totalCount;

  }

  /**
   * 件中を取得します。
   * @return 件中
   */
  public ACLabel getTotalCountUnit(){
    if(totalCountUnit==null){

      totalCountUnit = new ACLabel();

      totalCountUnit.setText("件中");

      addTotalCountUnit();
    }
    return totalCountUnit;

  }

  /**
   * 表示開始番号を取得します。
   * @return 表示開始番号
   */
  public ACLabel getViewBeginNo(){
    if(viewBeginNo==null){

      viewBeginNo = new ACLabel();

      viewBeginNo.setText("0");

      addViewBeginNo();
    }
    return viewBeginNo;

  }

  /**
   * 表示番号範囲を取得します。
   * @return 表示番号範囲
   */
  public ACLabel getViewSpan(){
    if(viewSpan==null){

      viewSpan = new ACLabel();

      viewSpan.setText("-");

      addViewSpan();
    }
    return viewSpan;

  }

  /**
   * 表示終了番号を取得します。
   * @return 表示終了番号
   */
  public ACLabel getViewEndNo(){
    if(viewEndNo==null){

      viewEndNo = new ACLabel();

      viewEndNo.setText("0");

      addViewEndNo();
    }
    return viewEndNo;

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
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getPatientNo(){
    if(patientNo==null){

      patientNo = new ACTableColumn();

      patientNo.setHeaderValue("No.");

      patientNo.setColumnName("SERIAL_ID");

      patientNo.setColumns(3);

      addPatientNo();
    }
    return patientNo;

  }

  /**
   * 対象を取得します。
   * @return 対象
   */
  public ACTableColumn getPatientImport(){
    if(patientImport==null){

      patientImport = new ACTableColumn();

      patientImport.setColumnName("IMPORT_FLAG");

      patientImport.setEditable(true);

      patientImport.setColumns(3);

      patientImport.setHorizontalAlignment(SwingConstants.CENTER);

      patientImport.setRendererType(VRTableCellViewer.RENDERER_TYPE_CHECK_BOX);

      patientImport.setEditorType(VRTableCellViewer.EDITOR_TYPE_CHECK_BOX);

      patientImport.setHeaderPopupMenu( new ACCheckBoxTableColumnPopupMenu(getPatients(), "IMPORT_FLAG", new Boolean(true), new Boolean(false)) );

      addPatientImport();
    }
    return patientImport;

  }

  /**
   * 重複を取得します。
   * @return 重複
   */
  public ACTableColumn getPatientBatting(){
    if(patientBatting==null){

      patientBatting = new ACTableColumn();

      patientBatting.setHeaderValue("重複");

      patientBatting.setColumnName("BATTING_FLAG");

      patientBatting.setColumns(4);

      addPatientBatting();
    }
    return patientBatting;

  }

  /**
   * 氏名を取得します。
   * @return 氏名
   */
  public ACTableColumn getPatientName(){
    if(patientName==null){

      patientName = new ACTableColumn();

      patientName.setHeaderValue("氏名");

      patientName.setColumnName("PATIENT_FAMILY_NAME+'　'+PATIENT_FIRST_NAME");

      patientName.setColumns(9);

      addPatientName();
    }
    return patientName;

  }

  /**
   * ふりがなを取得します。
   * @return ふりがな
   */
  public ACTableColumn getPatientKana(){
    if(patientKana==null){

      patientKana = new ACTableColumn();

      patientKana.setHeaderValue("ふりがな");

      patientKana.setColumnName("PATIENT_FAMILY_KANA+'　'+PATIENT_FIRST_KANA");

      patientKana.setColumns(15);

      addPatientKana();
    }
    return patientKana;

  }

  /**
   * 性別を取得します。
   * @return 性別
   */
  public ACTableColumn getPatientSex(){
    if(patientSex==null){

      patientSex = new ACTableColumn();

      patientSex.setHeaderValue("性別");

      patientSex.setColumnName("PATIENT_SEX");

      patientSex.setColumns(3);

      patientSex.setHorizontalAlignment(SwingConstants.CENTER);

      patientSex.setFormat(QkanConstants.FORMAT_SEX);

      addPatientSex();
    }
    return patientSex;

  }

  /**
   * 年齢を取得します。
   * @return 年齢
   */
  public ACTableColumn getPatientAge(){
    if(patientAge==null){

      patientAge = new ACTableColumn();

      patientAge.setHeaderValue("年齢");

      patientAge.setColumnName("PATIENT_BIRTHDAY");

      patientAge.setColumns(3);

      patientAge.setHorizontalAlignment(SwingConstants.RIGHT);

      patientAge.setFormat(QkanConstants.FORMAT_NOW_AGE);

      addPatientAge();
    }
    return patientAge;

  }

  /**
   * 生年月日を取得します。
   * @return 生年月日
   */
  public ACTableColumn getPatientBirth(){
    if(patientBirth==null){

      patientBirth = new ACTableColumn();

      patientBirth.setHeaderValue("生年月日");

      patientBirth.setColumnName("PATIENT_BIRTHDAY");

      patientBirth.setColumns(10);

      patientBirth.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addPatientBirth();
    }
    return patientBirth;

  }

  /**
   * 郵便番号を取得します。
   * @return 郵便番号
   */
  public ACTableColumn getPatientZip(){
    if(patientZip==null){

      patientZip = new ACTableColumn();

      patientZip.setHeaderValue("郵便番号");

      patientZip.setColumnName("PATIENT_ZIP_FIRST+'-'+PATIENT_ZIP_SECOND");

      patientZip.setColumns(6);

      addPatientZip();
    }
    return patientZip;

  }

  /**
   * 住所を取得します。
   * @return 住所
   */
  public ACTableColumn getPatientAddress(){
    if(patientAddress==null){

      patientAddress = new ACTableColumn();

      patientAddress.setHeaderValue("住所");

      patientAddress.setColumnName("PATIENT_ADDRESS");

      patientAddress.setColumns(20);

      addPatientAddress();
    }
    return patientAddress;

  }

  /**
   * 連絡先(TEL)を取得します。
   * @return 連絡先(TEL)
   */
  public ACTableColumn getPatientTel(){
    if(patientTel==null){

      patientTel = new ACTableColumn();

      patientTel.setHeaderValue("連絡先(TEL)");

      patientTel.setColumnName("PATIENT_TEL_FIRST+'-'+PATIENT_TEL_SECOND+'-'+PATIENT_TEL_THIRD");

      patientTel.setColumns(20);

      addPatientTel();
    }
    return patientTel;

  }

  /**
   * コンストラクタです。
   */
  public QO013Design() {

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

    this.add(getConnectSettings(), VRLayout.NORTH);

    this.add(getFindSetting(), VRLayout.NORTH);

    this.add(getImportSettings(), VRLayout.NORTH);

    this.add(getPatients(), VRLayout.CLIENT);

  }

  /**
   * 業務ボタンバーに内部項目を追加します。
   */
  protected void addButtons(){

    buttons.add(getImportPatient(), VRLayout.EAST);
    buttons.add(getConnect(), VRLayout.EAST);
  }

  /**
   * 通信に内部項目を追加します。
   */
  protected void addConnect(){

  }

  /**
   * 取り込みに内部項目を追加します。
   */
  protected void addImportPatient(){

  }

  /**
   * 接続設定に内部項目を追加します。
   */
  protected void addConnectSettings(){

    connectSettings.add(getHostNameContainer(), VRLayout.FLOW_INSETLINE);

    connectSettings.add(getPortNoContainer(), VRLayout.FLOW_INSETLINE);

    connectSettings.add(getDbsVersionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    connectSettings.add(getUserNameContainer(), VRLayout.FLOW_INSETLINE);

    connectSettings.add(getPasswordContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    connectSettings.add(getReceiptVersionComboContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 接続先ホストに内部項目を追加します。
   */
  protected void addHostName(){

  }

  /**
   * ポート番号に内部項目を追加します。
   */
  protected void addPortNo(){

  }

  /**
   * DBSバージョンに内部項目を追加します。
   */
  protected void addDbsVersion(){

  }

  /**
   * ユーザー名に内部項目を追加します。
   */
  protected void addUserName(){

  }

  /**
   * パスワードに内部項目を追加します。
   */
  protected void addPassword(){

  }

  /**
   * 日医標準レセプトソフトバージョンに内部項目を追加します。
   */
  protected void addReceiptVersionCombo(){

  }

  /**
   * 日医標準レセプトソフトバージョンモデルに内部項目を追加します。
   */
  protected void addReceiptVersionComboModel(){

  }

  /**
   * 取得条件に内部項目を追加します。
   */
  protected void addFindSetting(){

    findSetting.add(getAgeContainer(), VRLayout.FLOW_INSETLINE);

    findSetting.add(getDeduplicationCheck(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 年齢コンテナに内部項目を追加します。
   */
  protected void addAgeContainer(){

    ageContainer.add(getAgeContainerTItle(), VRLayout.FLOW);

    ageContainer.add(getAgeStartTextContainer(), VRLayout.FLOW);

    ageContainer.add(getAgeConnectLabel(), VRLayout.FLOW);

    ageContainer.add(getAgeEndTextContainer(), VRLayout.FLOW);

    ageContainer.add(getAgeLabel(), VRLayout.FLOW);

  }

  /**
   * 年齢タイトルに内部項目を追加します。
   */
  protected void addAgeContainerTItle(){

  }

  /**
   * 年齢指定テキスト（開始）に内部項目を追加します。
   */
  protected void addAgeStartText(){

  }

  /**
   * 年齢ラベルに内部項目を追加します。
   */
  protected void addAgeConnectLabel(){

  }

  /**
   * 年齢指定テキスト（終了）に内部項目を追加します。
   */
  protected void addAgeEndText(){

  }

  /**
   * 年齢終了ラベルに内部項目を追加します。
   */
  protected void addAgeLabel(){

  }

  /**
   * 登録済み除外チェックに内部項目を追加します。
   */
  protected void addDeduplicationCheck(){

  }

  /**
   * 取り込み設定に内部項目を追加します。
   */
  protected void addImportSettings(){

    importSettings.add(getImportPanel(), VRLayout.FLOW);

    importSettings.add(getPreviewPage(), VRLayout.FLOW);

    importSettings.add(getNextPage(), VRLayout.FLOW);

    importSettings.add(getViewRange(), VRLayout.FLOW);

  }

  /**
   * 取込設定パネルに内部項目を追加します。
   */
  protected void addImportPanel(){

    importPanel.add(getToHiragana(), VRLayout.FLOW_INSETLINE_RETURN);

    importPanel.add(getAllPageCheck(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * カナ指名をひらがなに変換に内部項目を追加します。
   */
  protected void addToHiragana(){

  }

  /**
   * 500件目以降の患者も取り込むに内部項目を追加します。
   */
  protected void addAllPageCheck(){

  }

  /**
   * 前へに内部項目を追加します。
   */
  protected void addPreviewPage(){

  }

  /**
   * 次へに内部項目を追加します。
   */
  protected void addNextPage(){

  }

  /**
   * 件数表示に内部項目を追加します。
   */
  protected void addViewRange(){

    viewRange.add(getTotalCount(), null);

    viewRange.add(getTotalCountUnit(), null);

    viewRange.add(getViewBeginNo(), null);

    viewRange.add(getViewSpan(), null);

    viewRange.add(getViewEndNo(), null);

  }

  /**
   * 全体件数に内部項目を追加します。
   */
  protected void addTotalCount(){

  }

  /**
   * 件中に内部項目を追加します。
   */
  protected void addTotalCountUnit(){

  }

  /**
   * 表示開始番号に内部項目を追加します。
   */
  protected void addViewBeginNo(){

  }

  /**
   * 表示番号範囲に内部項目を追加します。
   */
  protected void addViewSpan(){

  }

  /**
   * 表示終了番号に内部項目を追加します。
   */
  protected void addViewEndNo(){

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

    getPatientsColumnModel().addColumn(getPatientNo());

    getPatientsColumnModel().addColumn(getPatientImport());

    getPatientsColumnModel().addColumn(getPatientBatting());

    getPatientsColumnModel().addColumn(getPatientName());

    getPatientsColumnModel().addColumn(getPatientKana());

    getPatientsColumnModel().addColumn(getPatientSex());

    getPatientsColumnModel().addColumn(getPatientAge());

    getPatientsColumnModel().addColumn(getPatientBirth());

    getPatientsColumnModel().addColumn(getPatientZip());

    getPatientsColumnModel().addColumn(getPatientAddress());

    getPatientsColumnModel().addColumn(getPatientTel());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addPatientNo(){

  }

  /**
   * 対象に内部項目を追加します。
   */
  protected void addPatientImport(){

  }

  /**
   * 重複に内部項目を追加します。
   */
  protected void addPatientBatting(){

  }

  /**
   * 氏名に内部項目を追加します。
   */
  protected void addPatientName(){

  }

  /**
   * ふりがなに内部項目を追加します。
   */
  protected void addPatientKana(){

  }

  /**
   * 性別に内部項目を追加します。
   */
  protected void addPatientSex(){

  }

  /**
   * 年齢に内部項目を追加します。
   */
  protected void addPatientAge(){

  }

  /**
   * 生年月日に内部項目を追加します。
   */
  protected void addPatientBirth(){

  }

  /**
   * 郵便番号に内部項目を追加します。
   */
  protected void addPatientZip(){

  }

  /**
   * 住所に内部項目を追加します。
   */
  protected void addPatientAddress(){

  }

  /**
   * 連絡先(TEL)に内部項目を追加します。
   */
  protected void addPatientTel(){

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

    return getConnect();

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    try {
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QO013Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO013Design getThis() {
    return this;
  }
}
