
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
 * 作成日: 2006/06/08  日本コンピューター株式会社 樋口雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 利用者管理 (U)
 * プロセス 利用者登録 (004)
 * プログラム 公費・社福軽減情報 (QU004)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu004;
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
 * 公費・社福軽減情報画面項目デザイン(QU004) 
 */
public class QU004Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton insert;

  private ACAffairButton update;

  private ACPanel contents;

  private ACPanel patientInfo;

  private ACLabel patientNameCaption;

  private ACLabel patientName;

  private JTabbedPane tabs;

  private ACPanel points1;

  private VRLayout kaigoLayout;

  private ACPanel kaigoInfos;

  private ACPanel kaigoInfo;

  private ACComboBox kaigoInfoPublicExpense;

  private ACLabelContainer kaigoInfoPublicExpenseContainer;

  private ACComboBoxModelAdapter kaigoInfoPublicExpenseModel;

  private ACLabelContainer kaigoInfoBenefitRateContena;

  private ACTextField kaigoInfoBenefitRate;

  private ACLabel kaigoInfoPercentLabel;

  private ACLabelContainer kaigoInfoBearNoContena;

  private ACTextField kaigoInfoKohiNo;

  private ACTextField kaigoInfoInsurerNo;

  private ACComboBox kaigoInfoBearName;

  private ACLabelContainer kaigoInfoBearNameContainer;

  private ACComboBoxModelAdapter kaigoInfoBearNameModel;

  private ACTextField kaigoInfoReceiptNo;

  private ACLabelContainer kaigoInfoReceiptNoContainer;

  private ACLabelContainer kaigoInfoValidLimitContena;

  private QkanDateTextField kaigoInfoValidLimit1;

  private ACLabel kaigoInfoValidLimitLabel;

  private QkanDateTextField kaigoInfoValidLimit2;

  private ACLabelContainer kaigoInfoSelfPaymentContents;

  private ACTextField kaigoInfoSelfPayment;

  private ACLabel kaigoInfoSelfPaymentYen;

  private ACPanel kaigoInfoButtons;

  private ACButton kaigoInfoButtonClear;

  private ACButton kaigoInfoButtonInsert;

  private ACButton kaigoInfoButtonConpile;

  private ACButton kaigoInfoButtonDelete;

  private ACPanel kaigoInfoTables;

  private ACTable kaigoInfoTable;

  private VRTableColumnModel kaigoInfoTableColumnModel;

  private ACTableColumn kaigoInfoTableColumn0;

  private ACTableColumn kaigoInfoTableColumn1;

  private ACTableColumn kaigoInfoTableColumn2;

  private ACTableColumn kaigoInfoTableColumn3;

  private ACTableColumn kaigoInfoTableColumn5;

  private ACTableColumn kaigoInfoTableColumn6;

  private ACTableColumn kaigoInfoTableColumn7;

  private ACPanel kaigoInfoServices;

  private ACGroupBox kaigoInfoService;

  private ACLabel kaigoInfoServiceComment;

  private ACTable kaigoInfoServiceTable;

  private VRTableColumnModel kaigoInfoServiceTableColumnModel;

  private ACTableColumn kaigoInfoServiceTableColumn1;

  private ACTableColumn kaigoInfoServiceTableColumn2;

  private ACTableColumn kaigoInfoServiceTableColumn3;

  private ACPanel points2;

  private VRLayout iryoLayout;

  private ACPanel iryoInfos;

  private ACPanel iryoInfo;

  private ACComboBox iryoInfoPublicExpense;

  private ACLabelContainer iryoInfoPublicExpenseContainer;

  private ACComboBoxModelAdapter iryoInfoPublicExpenseModel;

  private ACLabelContainer iryoInfoBenefitRateContena;

  private ACTextField iryoInfoBenefitRate;

  private ACLabel iryoInfoPercentLabel;

  private ACLabelContainer iryoInfoBearNoContena;

  private ACTextField iryoInfoKohiNo;

  private ACTextField iryoInfoInsurerNo;

  private ACComboBox iryoInfoBearName;

  private ACLabelContainer iryoInfoBearNameContainer;

  private ACComboBoxModelAdapter iryoInfoBearNameModel;

  private ACTextField iryoInfoReceiptNo;

  private ACLabelContainer iryoInfoReceiptNoContainer;

  private ACLabelContainer iryoInfoValidLimitContena;

  private QkanDateTextField iryoInfoValidLimit1;

  private ACLabel iryoInfoValidLimitLabel;

  private QkanDateTextField iryoInfoValidLimit2;

  private ACPanel iryoInfoButtons;

  private ACButton iryoInfoButtonClear;

  private ACButton iryoInfoButtonInsert;

  private ACButton iryoInfoButtonConpile;

  private ACButton iryoInfoButtonDelete;

  private ACPanel iryoInfoTables;

  private ACTable iryoInfoTable;

  private VRTableColumnModel iryoInfoTableColumnModel;

  private ACTableColumn iryoInfoTableColumn0;

  private ACTableColumn iryoInfoTableColumn1;

  private ACTableColumn iryoInfoTableColumn2;

  private ACTableColumn iryoInfoTableColumn3;

  private ACTableColumn iryoInfoTableColumn5;

  private ACTableColumn iryoInfoTableColumn6;

  private ACTableColumn iryoInfoTableColumn7;

  private ACPanel iryoInfoServices;

  private ACGroupBox iryoInfoService;

  private ACLabel iryoInfoServiceComment;

  private ACTable iryoInfoServiceTable;

  private VRTableColumnModel iryoInfoServiceTableColumnModel;

  private ACTableColumn iryoInfoServiceTableColumn1;

  private ACTableColumn iryoInfoServiceTableColumn2;

  private ACTableColumn iryoInfoServiceTableColumn3;

  private ACPanel points3;

  private VRLayout shahukuLayout;

  private ACPanel shahukuInfos;

  private ACPanel shahukuInfo;

  private ACLabelContainer shahukuInfoBenefitRateContena;

  private ACTextField shahukuInfoBenefitRate;

  private ACLabel shahukuInfoPercentLabel;

  private ACLabelContainer shahukuInfoValidLimitContena;

  private QkanDateTextField shahukuInfoValidLimit1;

  private ACLabel shahukuInfoValidLimitLabel;

  private QkanDateTextField shahukuInfoValidLimit2;

  private ACPanel shahukuInfoButtons;

  private ACButton shahukuInfoButtonClear;

  private ACButton shahukuInfoButtonInsert;

  private ACButton shahukuInfoButtonConpile;

  private ACButton shahukuInfoButtonDelete;

  private ACPanel shahukuInfoTables;

  private ACTable shahukuInfoTable;

  private VRTableColumnModel shahukuInfoTableColumnModel;

  private ACTableColumn shahukuInfoTableColumn0;

  private ACTableColumn shahukuInfoTableColumn1;

  private ACTableColumn shahukuInfoTableColumn2;

  private ACTableColumn shahukuInfoTableColumn3;

  //getter

  /**
   * 業務ボタンバーを取得します。
   * @return 業務ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("公費・社福軽減情報");

      addButtons();
    }
    return buttons;

  }

  /**
   * 登録を取得します。
   * @return 登録
   */
  public ACAffairButton getInsert(){
    if(insert==null){

      insert = new ACAffairButton();

      insert.setText("登録(S)");

      insert.setToolTipText("現在の内容を登録します。");

      insert.setMnemonic('S');

      insert.setIconPath(ACConstants.ICON_PATH_UPDATE_24);

      addInsert();
    }
    return insert;

  }

  /**
   * 更新を取得します。
   * @return 更新
   */
  public ACAffairButton getUpdate(){
    if(update==null){

      update = new ACAffairButton();

      update.setText("更新(S)");

      update.setToolTipText("現在の内容を更新します。");

      update.setMnemonic('S');

      update.setIconPath(ACConstants.ICON_PATH_UPDATE_24);

      addUpdate();
    }
    return update;

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
  public ACPanel getPatientInfo(){
    if(patientInfo==null){

      patientInfo = new ACPanel();

      addPatientInfo();
    }
    return patientInfo;

  }

  /**
   * 利用者名キャプションを取得します。
   * @return 利用者名キャプション
   */
  public ACLabel getPatientNameCaption(){
    if(patientNameCaption==null){

      patientNameCaption = new ACLabel();

      patientNameCaption.setText("利用者名");

      addPatientNameCaption();
    }
    return patientNameCaption;

  }

  /**
   * 利用者名を取得します。
   * @return 利用者名
   */
  public ACLabel getPatientName(){
    if(patientName==null){

      patientName = new ACLabel();

      patientName.setText("サンプル利用者");

      patientName.setBindPath("PATIENT_NAME");

      patientName.setColumns(35);

      addPatientName();
    }
    return patientName;

  }

  /**
   * タブを取得します。
   * @return タブ
   */
  public JTabbedPane getTabs(){
    if(tabs==null){

      tabs = new JTabbedPane();

      addTabs();
    }
    return tabs;

  }

  /**
   * 介護公費領域を取得します。
   * @return 介護公費領域
   */
  public ACPanel getPoints1(){
    if(points1==null){

      points1 = new ACPanel();

      points1.setLayout(getKaigoLayout());

      addPoints1();
    }
    return points1;

  }

  /**
   * 介護公費領域・レイアウトを取得します。
   * @return 介護公費領域・レイアウト
   */
  public VRLayout getKaigoLayout(){
    if(kaigoLayout==null){

      kaigoLayout = new VRLayout();

      kaigoLayout.setAutoWrap(false);

      addKaigoLayout();
    }
    return kaigoLayout;

  }

  /**
   * 介護公費領域・情報を取得します。
   * @return 介護公費領域・情報
   */
  public ACPanel getKaigoInfos(){
    if(kaigoInfos==null){

      kaigoInfos = new ACPanel();

      addKaigoInfos();
    }
    return kaigoInfos;

  }

  /**
   * 介護公費領域・情報2を取得します。
   * @return 介護公費領域・情報2
   */
  public ACPanel getKaigoInfo(){
    if(kaigoInfo==null){

      kaigoInfo = new ACPanel();

      addKaigoInfo();
    }
    return kaigoInfo;

  }

  /**
   * 公費情報を取得します。
   * @return 公費情報
   */
  public ACComboBox getKaigoInfoPublicExpense(){
    if(kaigoInfoPublicExpense==null){

      kaigoInfoPublicExpense = new ACComboBox();

      getKaigoInfoPublicExpenseContainer().setText("公費情報");

      kaigoInfoPublicExpense.setBindPath("KOHI_TYPE");

      kaigoInfoPublicExpense.setEditable(false);

      kaigoInfoPublicExpense.setColumns(10);

      kaigoInfoPublicExpense.setModelBindPath("KAIGO_KOHI");

      kaigoInfoPublicExpense.setRenderBindPath("KOHI_NAME");

      kaigoInfoPublicExpense.setModel(getKaigoInfoPublicExpenseModel());

      addKaigoInfoPublicExpense();
    }
    return kaigoInfoPublicExpense;

  }

  /**
   * 公費情報コンテナを取得します。
   * @return 公費情報コンテナ
   */
  protected ACLabelContainer getKaigoInfoPublicExpenseContainer(){
    if(kaigoInfoPublicExpenseContainer==null){
      kaigoInfoPublicExpenseContainer = new ACLabelContainer();
      kaigoInfoPublicExpenseContainer.setFollowChildEnabled(true);
      kaigoInfoPublicExpenseContainer.setVAlignment(VRLayout.CENTER);
      kaigoInfoPublicExpenseContainer.add(getKaigoInfoPublicExpense(), null);
    }
    return kaigoInfoPublicExpenseContainer;
  }

  /**
   * 公費情報モデルを取得します。
   * @return 公費情報モデル
   */
  protected ACComboBoxModelAdapter getKaigoInfoPublicExpenseModel(){
    if(kaigoInfoPublicExpenseModel==null){
      kaigoInfoPublicExpenseModel = new ACComboBoxModelAdapter();
      addKaigoInfoPublicExpenseModel();
    }
    return kaigoInfoPublicExpenseModel;
  }

  /**
   * (給付率・コンテナ)を取得します。
   * @return (給付率・コンテナ)
   */
  public ACLabelContainer getKaigoInfoBenefitRateContena(){
    if(kaigoInfoBenefitRateContena==null){

      kaigoInfoBenefitRateContena = new ACLabelContainer();

      kaigoInfoBenefitRateContena.setText("給付率");

      addKaigoInfoBenefitRateContena();
    }
    return kaigoInfoBenefitRateContena;

  }

  /**
   * 給付率を取得します。
   * @return 給付率
   */
  public ACTextField getKaigoInfoBenefitRate(){
    if(kaigoInfoBenefitRate==null){

      kaigoInfoBenefitRate = new ACTextField();

      kaigoInfoBenefitRate.setBindPath("BENEFIT_RATE");

      kaigoInfoBenefitRate.setColumns(3);

      kaigoInfoBenefitRate.setCharType(VRCharType.ONLY_DIGIT);

      kaigoInfoBenefitRate.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoInfoBenefitRate.setIMEMode(InputSubset.LATIN);

      kaigoInfoBenefitRate.setMaxLength(3);

      addKaigoInfoBenefitRate();
    }
    return kaigoInfoBenefitRate;

  }

  /**
   * %ラベルを取得します。
   * @return %ラベル
   */
  public ACLabel getKaigoInfoPercentLabel(){
    if(kaigoInfoPercentLabel==null){

      kaigoInfoPercentLabel = new ACLabel();

      kaigoInfoPercentLabel.setText(" ％");

      addKaigoInfoPercentLabel();
    }
    return kaigoInfoPercentLabel;

  }

  /**
   * (負担者番号・コンテナ)を取得します。
   * @return (負担者番号・コンテナ)
   */
  public ACLabelContainer getKaigoInfoBearNoContena(){
    if(kaigoInfoBearNoContena==null){

      kaigoInfoBearNoContena = new ACLabelContainer();

      kaigoInfoBearNoContena.setText("負担者番号");

      addKaigoInfoBearNoContena();
    }
    return kaigoInfoBearNoContena;

  }

  /**
   * 公費法別番号を取得します。
   * @return 公費法別番号
   */
  public ACTextField getKaigoInfoKohiNo(){
    if(kaigoInfoKohiNo==null){

      kaigoInfoKohiNo = new ACTextField();

      kaigoInfoKohiNo.setBindPath("KOHI_LAW_NO");

      kaigoInfoKohiNo.setEditable(false);

      kaigoInfoKohiNo.setColumns(2);

      kaigoInfoKohiNo.setCharType(VRCharType.ONLY_DIGIT);

      kaigoInfoKohiNo.setIMEMode(InputSubset.LATIN);

      kaigoInfoKohiNo.setMaxLength(2);

      addKaigoInfoKohiNo();
    }
    return kaigoInfoKohiNo;

  }

  /**
   * 保険者番号を取得します。
   * @return 保険者番号
   */
  public ACTextField getKaigoInfoInsurerNo(){
    if(kaigoInfoInsurerNo==null){

      kaigoInfoInsurerNo = new ACTextField();

      kaigoInfoInsurerNo.setBindPath("INSURER_ID");

      kaigoInfoInsurerNo.setColumns(6);

      kaigoInfoInsurerNo.setCharType(VRCharType.ONLY_DIGIT);

      kaigoInfoInsurerNo.setMaxLength(6);

      addKaigoInfoInsurerNo();
    }
    return kaigoInfoInsurerNo;

  }

  /**
   * 負担者名を取得します。
   * @return 負担者名
   */
  public ACComboBox getKaigoInfoBearName(){
    if(kaigoInfoBearName==null){

      kaigoInfoBearName = new ACComboBox();

      kaigoInfoBearName.setVisible(false);

      kaigoInfoBearName.setEditable(false);

      kaigoInfoBearName.setColumns(10);

      kaigoInfoBearName.setModelBindPath("KOHI_PAYER_NAME");

      kaigoInfoBearName.setRenderBindPath("INSURER_NAME");

      kaigoInfoBearName.setModel(getKaigoInfoBearNameModel());

      addKaigoInfoBearName();
    }
    return kaigoInfoBearName;

  }

  /**
   * 負担者名コンテナを取得します。
   * @return 負担者名コンテナ
   */
  protected ACLabelContainer getKaigoInfoBearNameContainer(){
    if(kaigoInfoBearNameContainer==null){
      kaigoInfoBearNameContainer = new ACLabelContainer();
      kaigoInfoBearNameContainer.setFollowChildEnabled(true);
      kaigoInfoBearNameContainer.setVAlignment(VRLayout.CENTER);
      kaigoInfoBearNameContainer.add(getKaigoInfoBearName(), null);
    }
    return kaigoInfoBearNameContainer;
  }

  /**
   * 負担者名モデルを取得します。
   * @return 負担者名モデル
   */
  protected ACComboBoxModelAdapter getKaigoInfoBearNameModel(){
    if(kaigoInfoBearNameModel==null){
      kaigoInfoBearNameModel = new ACComboBoxModelAdapter();
      addKaigoInfoBearNameModel();
    }
    return kaigoInfoBearNameModel;
  }

  /**
   * 受給者番号を取得します。
   * @return 受給者番号
   */
  public ACTextField getKaigoInfoReceiptNo(){
    if(kaigoInfoReceiptNo==null){

      kaigoInfoReceiptNo = new ACTextField();

      getKaigoInfoReceiptNoContainer().setText("受給者番号");

      kaigoInfoReceiptNo.setBindPath("KOHI_RECIPIENT_NO");

      kaigoInfoReceiptNo.setCharType(VRCharType.ONLY_ALNUM);

      kaigoInfoReceiptNo.setColumns(10);

      kaigoInfoReceiptNo.setMaxLength(7);

      addKaigoInfoReceiptNo();
    }
    return kaigoInfoReceiptNo;

  }

  /**
   * 受給者番号コンテナを取得します。
   * @return 受給者番号コンテナ
   */
  protected ACLabelContainer getKaigoInfoReceiptNoContainer(){
    if(kaigoInfoReceiptNoContainer==null){
      kaigoInfoReceiptNoContainer = new ACLabelContainer();
      kaigoInfoReceiptNoContainer.setFollowChildEnabled(true);
      kaigoInfoReceiptNoContainer.setVAlignment(VRLayout.CENTER);
      kaigoInfoReceiptNoContainer.add(getKaigoInfoReceiptNo(), null);
    }
    return kaigoInfoReceiptNoContainer;
  }

  /**
   * 有効期間・コンテナを取得します。
   * @return 有効期間・コンテナ
   */
  public ACLabelContainer getKaigoInfoValidLimitContena(){
    if(kaigoInfoValidLimitContena==null){

      kaigoInfoValidLimitContena = new ACLabelContainer();

      kaigoInfoValidLimitContena.setText("有効期間");

      addKaigoInfoValidLimitContena();
    }
    return kaigoInfoValidLimitContena;

  }

  /**
   * 有効期間・テキスト1を取得します。
   * @return 有効期間・テキスト1
   */
  public QkanDateTextField getKaigoInfoValidLimit1(){
    if(kaigoInfoValidLimit1==null){

      kaigoInfoValidLimit1 = new QkanDateTextField();

      kaigoInfoValidLimit1.setBindPath("KOHI_VALID_START");

      kaigoInfoValidLimit1.setColumns(10);

      kaigoInfoValidLimit1.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      kaigoInfoValidLimit1.setMaxLength(11);

      addKaigoInfoValidLimit1();
    }
    return kaigoInfoValidLimit1;

  }

  /**
   * 有効期間・ラベルを取得します。
   * @return 有効期間・ラベル
   */
  public ACLabel getKaigoInfoValidLimitLabel(){
    if(kaigoInfoValidLimitLabel==null){

      kaigoInfoValidLimitLabel = new ACLabel();

      kaigoInfoValidLimitLabel.setText(" から ");

      addKaigoInfoValidLimitLabel();
    }
    return kaigoInfoValidLimitLabel;

  }

  /**
   * 有効期間・テキスト2を取得します。
   * @return 有効期間・テキスト2
   */
  public QkanDateTextField getKaigoInfoValidLimit2(){
    if(kaigoInfoValidLimit2==null){

      kaigoInfoValidLimit2 = new QkanDateTextField();

      kaigoInfoValidLimit2.setBindPath("KOHI_VALID_END");

      kaigoInfoValidLimit2.setColumns(10);

      kaigoInfoValidLimit2.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      kaigoInfoValidLimit2.setMaxLength(11);

      addKaigoInfoValidLimit2();
    }
    return kaigoInfoValidLimit2;

  }

  /**
   * (自己負担額・コンテナ)を取得します。
   * @return (自己負担額・コンテナ)
   */
  public ACLabelContainer getKaigoInfoSelfPaymentContents(){
    if(kaigoInfoSelfPaymentContents==null){

      kaigoInfoSelfPaymentContents = new ACLabelContainer();

      kaigoInfoSelfPaymentContents.setText("自己負担額");

      addKaigoInfoSelfPaymentContents();
    }
    return kaigoInfoSelfPaymentContents;

  }

  /**
   * 自己負担額を取得します。
   * @return 自己負担額
   */
  public ACTextField getKaigoInfoSelfPayment(){
    if(kaigoInfoSelfPayment==null){

      kaigoInfoSelfPayment = new ACTextField();

      kaigoInfoSelfPayment.setBindPath("SELF_PAY");

      kaigoInfoSelfPayment.setColumns(5);

      kaigoInfoSelfPayment.setCharType(VRCharType.ONLY_DIGIT);

      kaigoInfoSelfPayment.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoInfoSelfPayment.setMaxLength(6);

      addKaigoInfoSelfPayment();
    }
    return kaigoInfoSelfPayment;

  }

  /**
   * 自己負担額ラベルを取得します。
   * @return 自己負担額ラベル
   */
  public ACLabel getKaigoInfoSelfPaymentYen(){
    if(kaigoInfoSelfPaymentYen==null){

      kaigoInfoSelfPaymentYen = new ACLabel();

      kaigoInfoSelfPaymentYen.setText(" 円");

      addKaigoInfoSelfPaymentYen();
    }
    return kaigoInfoSelfPaymentYen;

  }

  /**
   * 介護公費領域・ボタンを取得します。
   * @return 介護公費領域・ボタン
   */
  public ACPanel getKaigoInfoButtons(){
    if(kaigoInfoButtons==null){

      kaigoInfoButtons = new ACPanel();

      addKaigoInfoButtons();
    }
    return kaigoInfoButtons;

  }

  /**
   * クリアを取得します。
   * @return クリア
   */
  public ACButton getKaigoInfoButtonClear(){
    if(kaigoInfoButtonClear==null){

      kaigoInfoButtonClear = new ACButton();

      kaigoInfoButtonClear.setText("クリア");

      kaigoInfoButtonClear.setToolTipText("介護公費情報をクリアします。");

      kaigoInfoButtonClear.setIconPath(ACConstants.ICON_PATH_CLEAR_16);

      addKaigoInfoButtonClear();
    }
    return kaigoInfoButtonClear;

  }

  /**
   * 追加を取得します。
   * @return 追加
   */
  public ACButton getKaigoInfoButtonInsert(){
    if(kaigoInfoButtonInsert==null){

      kaigoInfoButtonInsert = new ACButton();

      kaigoInfoButtonInsert.setText("追加");

      kaigoInfoButtonInsert.setToolTipText("介護公費情報を追加します。");

      kaigoInfoButtonInsert.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addKaigoInfoButtonInsert();
    }
    return kaigoInfoButtonInsert;

  }

  /**
   * 書替を取得します。
   * @return 書替
   */
  public ACButton getKaigoInfoButtonConpile(){
    if(kaigoInfoButtonConpile==null){

      kaigoInfoButtonConpile = new ACButton();

      kaigoInfoButtonConpile.setText("書替");

      kaigoInfoButtonConpile.setToolTipText("介護公費情報を編集します。");

      kaigoInfoButtonConpile.setIconPath(ACConstants.ICON_PATH_STATE_UPDATE_16);

      addKaigoInfoButtonConpile();
    }
    return kaigoInfoButtonConpile;

  }

  /**
   * 削除を取得します。
   * @return 削除
   */
  public ACButton getKaigoInfoButtonDelete(){
    if(kaigoInfoButtonDelete==null){

      kaigoInfoButtonDelete = new ACButton();

      kaigoInfoButtonDelete.setText("削除");

      kaigoInfoButtonDelete.setToolTipText("介護公費情報を削除します。");

      kaigoInfoButtonDelete.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addKaigoInfoButtonDelete();
    }
    return kaigoInfoButtonDelete;

  }

  /**
   * 介護公費領域・パネルを取得します。
   * @return 介護公費領域・パネル
   */
  public ACPanel getKaigoInfoTables(){
    if(kaigoInfoTables==null){

      kaigoInfoTables = new ACPanel();

      addKaigoInfoTables();
    }
    return kaigoInfoTables;

  }

  /**
   * 介護公費・テーブルを取得します。
   * @return 介護公費・テーブル
   */
  public ACTable getKaigoInfoTable(){
    if(kaigoInfoTable==null){

      kaigoInfoTable = new ACTable();

      kaigoInfoTable.setColumnModel(getKaigoInfoTableColumnModel());

      addKaigoInfoTable();
    }
    return kaigoInfoTable;

  }

  /**
   * 介護公費・テーブルカラムモデルを取得します。
   * @return 介護公費・テーブルカラムモデル
   */
  protected VRTableColumnModel getKaigoInfoTableColumnModel(){
    if(kaigoInfoTableColumnModel==null){
      kaigoInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addKaigoInfoTableColumnModel();
    }
    return kaigoInfoTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getKaigoInfoTableColumn0(){
    if(kaigoInfoTableColumn0==null){

      kaigoInfoTableColumn0 = new ACTableColumn(0);

      kaigoInfoTableColumn0.setHeaderValue("No.");

      kaigoInfoTableColumn0.setColumns(3);

      kaigoInfoTableColumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      kaigoInfoTableColumn0.setSortable(false);

      addKaigoInfoTableColumn0();
    }
    return kaigoInfoTableColumn0;

  }

  /**
   * 公費情報を取得します。
   * @return 公費情報
   */
  public ACTableColumn getKaigoInfoTableColumn1(){
    if(kaigoInfoTableColumn1==null){

      kaigoInfoTableColumn1 = new ACTableColumn(0);

      kaigoInfoTableColumn1.setHeaderValue("公費情報");

      kaigoInfoTableColumn1.setColumns(22);

      addKaigoInfoTableColumn1();
    }
    return kaigoInfoTableColumn1;

  }

  /**
   * 給付率を取得します。
   * @return 給付率
   */
  public ACTableColumn getKaigoInfoTableColumn2(){
    if(kaigoInfoTableColumn2==null){

      kaigoInfoTableColumn2 = new ACTableColumn(1);

      kaigoInfoTableColumn2.setHeaderValue("給付率");

      kaigoInfoTableColumn2.setColumns(7);

      kaigoInfoTableColumn2.setHorizontalAlignment(SwingConstants.RIGHT);

      addKaigoInfoTableColumn2();
    }
    return kaigoInfoTableColumn2;

  }

  /**
   * 負担者番号を取得します。
   * @return 負担者番号
   */
  public ACTableColumn getKaigoInfoTableColumn3(){
    if(kaigoInfoTableColumn3==null){

      kaigoInfoTableColumn3 = new ACTableColumn(2);

      kaigoInfoTableColumn3.setHeaderValue("負担者番号");

      kaigoInfoTableColumn3.setColumns(8);

      addKaigoInfoTableColumn3();
    }
    return kaigoInfoTableColumn3;

  }

  /**
   * 受給者番号を取得します。
   * @return 受給者番号
   */
  public ACTableColumn getKaigoInfoTableColumn5(){
    if(kaigoInfoTableColumn5==null){

      kaigoInfoTableColumn5 = new ACTableColumn(4);

      kaigoInfoTableColumn5.setHeaderValue("受給者番号");

      kaigoInfoTableColumn5.setColumns(7);

      addKaigoInfoTableColumn5();
    }
    return kaigoInfoTableColumn5;

  }

  /**
   * 有効期間開始を取得します。
   * @return 有効期間開始
   */
  public ACTableColumn getKaigoInfoTableColumn6(){
    if(kaigoInfoTableColumn6==null){

      kaigoInfoTableColumn6 = new ACTableColumn(5);

      kaigoInfoTableColumn6.setHeaderValue("有効期間開始日");

      kaigoInfoTableColumn6.setColumns(12);

      kaigoInfoTableColumn6.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addKaigoInfoTableColumn6();
    }
    return kaigoInfoTableColumn6;

  }

  /**
   * 有効期間終了を取得します。
   * @return 有効期間終了
   */
  public ACTableColumn getKaigoInfoTableColumn7(){
    if(kaigoInfoTableColumn7==null){

      kaigoInfoTableColumn7 = new ACTableColumn(6);

      kaigoInfoTableColumn7.setHeaderValue("有効期間終了日");

      kaigoInfoTableColumn7.setColumns(12);

      kaigoInfoTableColumn7.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addKaigoInfoTableColumn7();
    }
    return kaigoInfoTableColumn7;

  }

  /**
   * 介護公費領域・サービスを取得します。
   * @return 介護公費領域・サービス
   */
  public ACPanel getKaigoInfoServices(){
    if(kaigoInfoServices==null){

      kaigoInfoServices = new ACPanel();

      kaigoInfoServices.setVisible(false);

      addKaigoInfoServices();
    }
    return kaigoInfoServices;

  }

  /**
   * サービス・グループを取得します。
   * @return サービス・グループ
   */
  public ACGroupBox getKaigoInfoService(){
    if(kaigoInfoService==null){

      kaigoInfoService = new ACGroupBox();

      kaigoInfoService.setText("給付対象サービス");

      kaigoInfoService.setAutoWrap(false);

      addKaigoInfoService();
    }
    return kaigoInfoService;

  }

  /**
   * 説明文ラベル・介護を取得します。
   * @return 説明文ラベル・介護
   */
  public ACLabel getKaigoInfoServiceComment(){
    if(kaigoInfoServiceComment==null){

      kaigoInfoServiceComment = new ACLabel();

      kaigoInfoServiceComment.setText("公費の対象となるサービスにチェックをつけてください。");

      kaigoInfoServiceComment.setIconPath(ACConstants.ICON_PATH_INFORMATION_16);

      addKaigoInfoServiceComment();
    }
    return kaigoInfoServiceComment;

  }

  /**
   * 公費・使用サービステーブルを取得します。
   * @return 公費・使用サービステーブル
   */
  public ACTable getKaigoInfoServiceTable(){
    if(kaigoInfoServiceTable==null){

      kaigoInfoServiceTable = new ACTable();

      kaigoInfoServiceTable.setColumns(36);

      kaigoInfoServiceTable.setColumnModel(getKaigoInfoServiceTableColumnModel());

      kaigoInfoServiceTable.setColumnSort(false);

      addKaigoInfoServiceTable();
    }
    return kaigoInfoServiceTable;

  }

  /**
   * 公費・使用サービステーブルカラムモデルを取得します。
   * @return 公費・使用サービステーブルカラムモデル
   */
  protected VRTableColumnModel getKaigoInfoServiceTableColumnModel(){
    if(kaigoInfoServiceTableColumnModel==null){
      kaigoInfoServiceTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addKaigoInfoServiceTableColumnModel();
    }
    return kaigoInfoServiceTableColumnModel;
  }

  /**
   * 列：提供を取得します。
   * @return 列：提供
   */
  public ACTableColumn getKaigoInfoServiceTableColumn1(){
    if(kaigoInfoServiceTableColumn1==null){

      kaigoInfoServiceTableColumn1 = new ACTableColumn(0);

      kaigoInfoServiceTableColumn1.setHeaderValue("提供");

      kaigoInfoServiceTableColumn1.setEditable(true);

      kaigoInfoServiceTableColumn1.setColumns(3);

      kaigoInfoServiceTableColumn1.setRendererType(VRTableCellViewer.RENDERER_TYPE_CHECK_BOX);

      kaigoInfoServiceTableColumn1.setEditorType(VRTableCellViewer.EDITOR_TYPE_CHECK_BOX);

      addKaigoInfoServiceTableColumn1();
    }
    return kaigoInfoServiceTableColumn1;

  }

  /**
   * 列：サービス種類を取得します。
   * @return 列：サービス種類
   */
  public ACTableColumn getKaigoInfoServiceTableColumn2(){
    if(kaigoInfoServiceTableColumn2==null){

      kaigoInfoServiceTableColumn2 = new ACTableColumn(1);

      kaigoInfoServiceTableColumn2.setHeaderValue("サービス種類");

      kaigoInfoServiceTableColumn2.setColumns(25);

      addKaigoInfoServiceTableColumn2();
    }
    return kaigoInfoServiceTableColumn2;

  }

  /**
   * 列：帳票種類を取得します。
   * @return 列：帳票種類
   */
  public ACTableColumn getKaigoInfoServiceTableColumn3(){
    if(kaigoInfoServiceTableColumn3==null){

      kaigoInfoServiceTableColumn3 = new ACTableColumn(2);

      kaigoInfoServiceTableColumn3.setHeaderValue("帳票種類");

      kaigoInfoServiceTableColumn3.setColumns(8);

      addKaigoInfoServiceTableColumn3();
    }
    return kaigoInfoServiceTableColumn3;

  }

  /**
   * 医療公費領域を取得します。
   * @return 医療公費領域
   */
  public ACPanel getPoints2(){
    if(points2==null){

      points2 = new ACPanel();

      points2.setLayout(getIryoLayout());

      addPoints2();
    }
    return points2;

  }

  /**
   * 医療公費領域・レイアウトを取得します。
   * @return 医療公費領域・レイアウト
   */
  public VRLayout getIryoLayout(){
    if(iryoLayout==null){

      iryoLayout = new VRLayout();

      iryoLayout.setAutoWrap(false);

      addIryoLayout();
    }
    return iryoLayout;

  }

  /**
   * 医療公費領域・情報を取得します。
   * @return 医療公費領域・情報
   */
  public ACPanel getIryoInfos(){
    if(iryoInfos==null){

      iryoInfos = new ACPanel();

      addIryoInfos();
    }
    return iryoInfos;

  }

  /**
   * 医療公費領域・情報2を取得します。
   * @return 医療公費領域・情報2
   */
  public ACPanel getIryoInfo(){
    if(iryoInfo==null){

      iryoInfo = new ACPanel();

      addIryoInfo();
    }
    return iryoInfo;

  }

  /**
   * 公費情報を取得します。
   * @return 公費情報
   */
  public ACComboBox getIryoInfoPublicExpense(){
    if(iryoInfoPublicExpense==null){

      iryoInfoPublicExpense = new ACComboBox();

      getIryoInfoPublicExpenseContainer().setText("公費情報");

      iryoInfoPublicExpense.setBindPath("KOHI_TYPE");

      iryoInfoPublicExpense.setEditable(false);

      iryoInfoPublicExpense.setColumns(10);

      iryoInfoPublicExpense.setModelBindPath("IRYO_KOHI");

      iryoInfoPublicExpense.setRenderBindPath("KOHI_NAME");

      iryoInfoPublicExpense.setModel(getIryoInfoPublicExpenseModel());

      addIryoInfoPublicExpense();
    }
    return iryoInfoPublicExpense;

  }

  /**
   * 公費情報コンテナを取得します。
   * @return 公費情報コンテナ
   */
  protected ACLabelContainer getIryoInfoPublicExpenseContainer(){
    if(iryoInfoPublicExpenseContainer==null){
      iryoInfoPublicExpenseContainer = new ACLabelContainer();
      iryoInfoPublicExpenseContainer.setFollowChildEnabled(true);
      iryoInfoPublicExpenseContainer.setVAlignment(VRLayout.CENTER);
      iryoInfoPublicExpenseContainer.add(getIryoInfoPublicExpense(), null);
    }
    return iryoInfoPublicExpenseContainer;
  }

  /**
   * 公費情報モデルを取得します。
   * @return 公費情報モデル
   */
  protected ACComboBoxModelAdapter getIryoInfoPublicExpenseModel(){
    if(iryoInfoPublicExpenseModel==null){
      iryoInfoPublicExpenseModel = new ACComboBoxModelAdapter();
      addIryoInfoPublicExpenseModel();
    }
    return iryoInfoPublicExpenseModel;
  }

  /**
   * (給付率・コンテナ)を取得します。
   * @return (給付率・コンテナ)
   */
  public ACLabelContainer getIryoInfoBenefitRateContena(){
    if(iryoInfoBenefitRateContena==null){

      iryoInfoBenefitRateContena = new ACLabelContainer();

      iryoInfoBenefitRateContena.setText("給付率");

      addIryoInfoBenefitRateContena();
    }
    return iryoInfoBenefitRateContena;

  }

  /**
   * 給付率を取得します。
   * @return 給付率
   */
  public ACTextField getIryoInfoBenefitRate(){
    if(iryoInfoBenefitRate==null){

      iryoInfoBenefitRate = new ACTextField();

      iryoInfoBenefitRate.setBindPath("BENEFIT_RATE");

      iryoInfoBenefitRate.setColumns(3);

      iryoInfoBenefitRate.setCharType(VRCharType.ONLY_DIGIT);

      iryoInfoBenefitRate.setHorizontalAlignment(SwingConstants.RIGHT);

      iryoInfoBenefitRate.setIMEMode(InputSubset.LATIN);

      iryoInfoBenefitRate.setMaxLength(3);

      addIryoInfoBenefitRate();
    }
    return iryoInfoBenefitRate;

  }

  /**
   * %ラベルを取得します。
   * @return %ラベル
   */
  public ACLabel getIryoInfoPercentLabel(){
    if(iryoInfoPercentLabel==null){

      iryoInfoPercentLabel = new ACLabel();

      iryoInfoPercentLabel.setText(" ％");

      addIryoInfoPercentLabel();
    }
    return iryoInfoPercentLabel;

  }

  /**
   * (負担者番号・コンテナ)を取得します。
   * @return (負担者番号・コンテナ)
   */
  public ACLabelContainer getIryoInfoBearNoContena(){
    if(iryoInfoBearNoContena==null){

      iryoInfoBearNoContena = new ACLabelContainer();

      iryoInfoBearNoContena.setText("負担者番号");

      addIryoInfoBearNoContena();
    }
    return iryoInfoBearNoContena;

  }

  /**
   * 公費法別番号を取得します。
   * @return 公費法別番号
   */
  public ACTextField getIryoInfoKohiNo(){
    if(iryoInfoKohiNo==null){

      iryoInfoKohiNo = new ACTextField();

      iryoInfoKohiNo.setBindPath("KOHI_LAW_NO");

      iryoInfoKohiNo.setEditable(false);

      iryoInfoKohiNo.setColumns(2);

      iryoInfoKohiNo.setCharType(VRCharType.ONLY_DIGIT);

      iryoInfoKohiNo.setIMEMode(InputSubset.LATIN);

      iryoInfoKohiNo.setMaxLength(2);

      addIryoInfoKohiNo();
    }
    return iryoInfoKohiNo;

  }

  /**
   * 保険者番号を取得します。
   * @return 保険者番号
   */
  public ACTextField getIryoInfoInsurerNo(){
    if(iryoInfoInsurerNo==null){

      iryoInfoInsurerNo = new ACTextField();

      iryoInfoInsurerNo.setBindPath("INSURER_ID");

      iryoInfoInsurerNo.setColumns(6);

      iryoInfoInsurerNo.setCharType(VRCharType.ONLY_DIGIT);

      iryoInfoInsurerNo.setMaxLength(6);

      addIryoInfoInsurerNo();
    }
    return iryoInfoInsurerNo;

  }

  /**
   * 負担者名を取得します。
   * @return 負担者名
   */
  public ACComboBox getIryoInfoBearName(){
    if(iryoInfoBearName==null){

      iryoInfoBearName = new ACComboBox();

      iryoInfoBearName.setVisible(false);

      iryoInfoBearName.setEditable(false);

      iryoInfoBearName.setColumns(10);

      iryoInfoBearName.setModelBindPath("KOHI_PAYER_NAME");

      iryoInfoBearName.setRenderBindPath("INSURER_NAME");

      iryoInfoBearName.setModel(getIryoInfoBearNameModel());

      addIryoInfoBearName();
    }
    return iryoInfoBearName;

  }

  /**
   * 負担者名コンテナを取得します。
   * @return 負担者名コンテナ
   */
  protected ACLabelContainer getIryoInfoBearNameContainer(){
    if(iryoInfoBearNameContainer==null){
      iryoInfoBearNameContainer = new ACLabelContainer();
      iryoInfoBearNameContainer.setFollowChildEnabled(true);
      iryoInfoBearNameContainer.setVAlignment(VRLayout.CENTER);
      iryoInfoBearNameContainer.add(getIryoInfoBearName(), null);
    }
    return iryoInfoBearNameContainer;
  }

  /**
   * 負担者名モデルを取得します。
   * @return 負担者名モデル
   */
  protected ACComboBoxModelAdapter getIryoInfoBearNameModel(){
    if(iryoInfoBearNameModel==null){
      iryoInfoBearNameModel = new ACComboBoxModelAdapter();
      addIryoInfoBearNameModel();
    }
    return iryoInfoBearNameModel;
  }

  /**
   * 受給者番号を取得します。
   * @return 受給者番号
   */
  public ACTextField getIryoInfoReceiptNo(){
    if(iryoInfoReceiptNo==null){

      iryoInfoReceiptNo = new ACTextField();

      getIryoInfoReceiptNoContainer().setText("受給者番号");

      iryoInfoReceiptNo.setBindPath("KOHI_RECIPIENT_NO");

      iryoInfoReceiptNo.setCharType(VRCharType.ONLY_ALNUM);

      iryoInfoReceiptNo.setColumns(10);

      iryoInfoReceiptNo.setMaxLength(7);

      addIryoInfoReceiptNo();
    }
    return iryoInfoReceiptNo;

  }

  /**
   * 受給者番号コンテナを取得します。
   * @return 受給者番号コンテナ
   */
  protected ACLabelContainer getIryoInfoReceiptNoContainer(){
    if(iryoInfoReceiptNoContainer==null){
      iryoInfoReceiptNoContainer = new ACLabelContainer();
      iryoInfoReceiptNoContainer.setFollowChildEnabled(true);
      iryoInfoReceiptNoContainer.setVAlignment(VRLayout.CENTER);
      iryoInfoReceiptNoContainer.add(getIryoInfoReceiptNo(), null);
    }
    return iryoInfoReceiptNoContainer;
  }

  /**
   * 有効期間・コンテナを取得します。
   * @return 有効期間・コンテナ
   */
  public ACLabelContainer getIryoInfoValidLimitContena(){
    if(iryoInfoValidLimitContena==null){

      iryoInfoValidLimitContena = new ACLabelContainer();

      iryoInfoValidLimitContena.setText("有効期間");

      addIryoInfoValidLimitContena();
    }
    return iryoInfoValidLimitContena;

  }

  /**
   * 有効期間・テキスト1を取得します。
   * @return 有効期間・テキスト1
   */
  public QkanDateTextField getIryoInfoValidLimit1(){
    if(iryoInfoValidLimit1==null){

      iryoInfoValidLimit1 = new QkanDateTextField();

      iryoInfoValidLimit1.setBindPath("KOHI_VALID_START");

      iryoInfoValidLimit1.setColumns(10);

      iryoInfoValidLimit1.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      iryoInfoValidLimit1.setMaxLength(11);

      addIryoInfoValidLimit1();
    }
    return iryoInfoValidLimit1;

  }

  /**
   * 有効期間・ラベルを取得します。
   * @return 有効期間・ラベル
   */
  public ACLabel getIryoInfoValidLimitLabel(){
    if(iryoInfoValidLimitLabel==null){

      iryoInfoValidLimitLabel = new ACLabel();

      iryoInfoValidLimitLabel.setText(" から ");

      addIryoInfoValidLimitLabel();
    }
    return iryoInfoValidLimitLabel;

  }

  /**
   * 有効期間・テキスト2を取得します。
   * @return 有効期間・テキスト2
   */
  public QkanDateTextField getIryoInfoValidLimit2(){
    if(iryoInfoValidLimit2==null){

      iryoInfoValidLimit2 = new QkanDateTextField();

      iryoInfoValidLimit2.setBindPath("KOHI_VALID_END");

      iryoInfoValidLimit2.setColumns(10);

      iryoInfoValidLimit2.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      iryoInfoValidLimit2.setMaxLength(11);

      addIryoInfoValidLimit2();
    }
    return iryoInfoValidLimit2;

  }

  /**
   * 医療公費領域・ボタンを取得します。
   * @return 医療公費領域・ボタン
   */
  public ACPanel getIryoInfoButtons(){
    if(iryoInfoButtons==null){

      iryoInfoButtons = new ACPanel();

      addIryoInfoButtons();
    }
    return iryoInfoButtons;

  }

  /**
   * クリアを取得します。
   * @return クリア
   */
  public ACButton getIryoInfoButtonClear(){
    if(iryoInfoButtonClear==null){

      iryoInfoButtonClear = new ACButton();

      iryoInfoButtonClear.setText("クリア");

      iryoInfoButtonClear.setToolTipText("医療公費情報をクリアします。");

      iryoInfoButtonClear.setIconPath(ACConstants.ICON_PATH_CLEAR_16);

      addIryoInfoButtonClear();
    }
    return iryoInfoButtonClear;

  }

  /**
   * 追加を取得します。
   * @return 追加
   */
  public ACButton getIryoInfoButtonInsert(){
    if(iryoInfoButtonInsert==null){

      iryoInfoButtonInsert = new ACButton();

      iryoInfoButtonInsert.setText("追加");

      iryoInfoButtonInsert.setToolTipText("医療公費情報を追加します。");

      iryoInfoButtonInsert.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addIryoInfoButtonInsert();
    }
    return iryoInfoButtonInsert;

  }

  /**
   * 書替を取得します。
   * @return 書替
   */
  public ACButton getIryoInfoButtonConpile(){
    if(iryoInfoButtonConpile==null){

      iryoInfoButtonConpile = new ACButton();

      iryoInfoButtonConpile.setText("書替");

      iryoInfoButtonConpile.setToolTipText("医療公費情報を編集します。");

      iryoInfoButtonConpile.setIconPath(ACConstants.ICON_PATH_STATE_UPDATE_16);

      addIryoInfoButtonConpile();
    }
    return iryoInfoButtonConpile;

  }

  /**
   * 削除を取得します。
   * @return 削除
   */
  public ACButton getIryoInfoButtonDelete(){
    if(iryoInfoButtonDelete==null){

      iryoInfoButtonDelete = new ACButton();

      iryoInfoButtonDelete.setText("削除");

      iryoInfoButtonDelete.setToolTipText("医療公費情報を削除します。");

      iryoInfoButtonDelete.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addIryoInfoButtonDelete();
    }
    return iryoInfoButtonDelete;

  }

  /**
   * 医療公費領域・テーブルを取得します。
   * @return 医療公費領域・テーブル
   */
  public ACPanel getIryoInfoTables(){
    if(iryoInfoTables==null){

      iryoInfoTables = new ACPanel();

      addIryoInfoTables();
    }
    return iryoInfoTables;

  }

  /**
   * 医療公費・テーブルを取得します。
   * @return 医療公費・テーブル
   */
  public ACTable getIryoInfoTable(){
    if(iryoInfoTable==null){

      iryoInfoTable = new ACTable();

      iryoInfoTable.setColumnModel(getIryoInfoTableColumnModel());

      addIryoInfoTable();
    }
    return iryoInfoTable;

  }

  /**
   * 医療公費・テーブルカラムモデルを取得します。
   * @return 医療公費・テーブルカラムモデル
   */
  protected VRTableColumnModel getIryoInfoTableColumnModel(){
    if(iryoInfoTableColumnModel==null){
      iryoInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addIryoInfoTableColumnModel();
    }
    return iryoInfoTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getIryoInfoTableColumn0(){
    if(iryoInfoTableColumn0==null){

      iryoInfoTableColumn0 = new ACTableColumn(0);

      iryoInfoTableColumn0.setHeaderValue("No.");

      iryoInfoTableColumn0.setColumns(3);

      iryoInfoTableColumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      iryoInfoTableColumn0.setSortable(false);

      addIryoInfoTableColumn0();
    }
    return iryoInfoTableColumn0;

  }

  /**
   * 公費情報を取得します。
   * @return 公費情報
   */
  public ACTableColumn getIryoInfoTableColumn1(){
    if(iryoInfoTableColumn1==null){

      iryoInfoTableColumn1 = new ACTableColumn(0);

      iryoInfoTableColumn1.setHeaderValue("公費情報");

      iryoInfoTableColumn1.setColumns(22);

      addIryoInfoTableColumn1();
    }
    return iryoInfoTableColumn1;

  }

  /**
   * 給付率を取得します。
   * @return 給付率
   */
  public ACTableColumn getIryoInfoTableColumn2(){
    if(iryoInfoTableColumn2==null){

      iryoInfoTableColumn2 = new ACTableColumn(1);

      iryoInfoTableColumn2.setHeaderValue("給付率");

      iryoInfoTableColumn2.setColumns(7);

      iryoInfoTableColumn2.setHorizontalAlignment(SwingConstants.RIGHT);

      addIryoInfoTableColumn2();
    }
    return iryoInfoTableColumn2;

  }

  /**
   * 負担者番号を取得します。
   * @return 負担者番号
   */
  public ACTableColumn getIryoInfoTableColumn3(){
    if(iryoInfoTableColumn3==null){

      iryoInfoTableColumn3 = new ACTableColumn(2);

      iryoInfoTableColumn3.setHeaderValue("負担者番号");

      iryoInfoTableColumn3.setColumns(8);

      addIryoInfoTableColumn3();
    }
    return iryoInfoTableColumn3;

  }

  /**
   * 受給者番号を取得します。
   * @return 受給者番号
   */
  public ACTableColumn getIryoInfoTableColumn5(){
    if(iryoInfoTableColumn5==null){

      iryoInfoTableColumn5 = new ACTableColumn(4);

      iryoInfoTableColumn5.setHeaderValue("受給者番号");

      iryoInfoTableColumn5.setColumns(7);

      addIryoInfoTableColumn5();
    }
    return iryoInfoTableColumn5;

  }

  /**
   * 有効期間開始を取得します。
   * @return 有効期間開始
   */
  public ACTableColumn getIryoInfoTableColumn6(){
    if(iryoInfoTableColumn6==null){

      iryoInfoTableColumn6 = new ACTableColumn(5);

      iryoInfoTableColumn6.setHeaderValue("有効期間開始日");

      iryoInfoTableColumn6.setColumns(12);

      iryoInfoTableColumn6.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addIryoInfoTableColumn6();
    }
    return iryoInfoTableColumn6;

  }

  /**
   * 有効期間終了を取得します。
   * @return 有効期間終了
   */
  public ACTableColumn getIryoInfoTableColumn7(){
    if(iryoInfoTableColumn7==null){

      iryoInfoTableColumn7 = new ACTableColumn(6);

      iryoInfoTableColumn7.setHeaderValue("有効期間終了日");

      iryoInfoTableColumn7.setColumns(12);

      iryoInfoTableColumn7.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addIryoInfoTableColumn7();
    }
    return iryoInfoTableColumn7;

  }

  /**
   * 医療公費領域・サービスを取得します。
   * @return 医療公費領域・サービス
   */
  public ACPanel getIryoInfoServices(){
    if(iryoInfoServices==null){

      iryoInfoServices = new ACPanel();

      iryoInfoServices.setVisible(false);

      addIryoInfoServices();
    }
    return iryoInfoServices;

  }

  /**
   * サービス・グループを取得します。
   * @return サービス・グループ
   */
  public ACGroupBox getIryoInfoService(){
    if(iryoInfoService==null){

      iryoInfoService = new ACGroupBox();

      iryoInfoService.setText("給付対象サービス");

      addIryoInfoService();
    }
    return iryoInfoService;

  }

  /**
   * 説明文ラベル・医療を取得します。
   * @return 説明文ラベル・医療
   */
  public ACLabel getIryoInfoServiceComment(){
    if(iryoInfoServiceComment==null){

      iryoInfoServiceComment = new ACLabel();

      iryoInfoServiceComment.setText("公費の対象となるサービスにチェックをつけてください。");

      iryoInfoServiceComment.setIconPath(ACConstants.ICON_PATH_INFORMATION_16);

      addIryoInfoServiceComment();
    }
    return iryoInfoServiceComment;

  }

  /**
   * 医療公費・使用サービステーブルを取得します。
   * @return 医療公費・使用サービステーブル
   */
  public ACTable getIryoInfoServiceTable(){
    if(iryoInfoServiceTable==null){

      iryoInfoServiceTable = new ACTable();

      iryoInfoServiceTable.setColumns(25);

      iryoInfoServiceTable.setColumnModel(getIryoInfoServiceTableColumnModel());

      iryoInfoServiceTable.setColumnSort(false);

      addIryoInfoServiceTable();
    }
    return iryoInfoServiceTable;

  }

  /**
   * 医療公費・使用サービステーブルカラムモデルを取得します。
   * @return 医療公費・使用サービステーブルカラムモデル
   */
  protected VRTableColumnModel getIryoInfoServiceTableColumnModel(){
    if(iryoInfoServiceTableColumnModel==null){
      iryoInfoServiceTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addIryoInfoServiceTableColumnModel();
    }
    return iryoInfoServiceTableColumnModel;
  }

  /**
   * 列：提供を取得します。
   * @return 列：提供
   */
  public ACTableColumn getIryoInfoServiceTableColumn1(){
    if(iryoInfoServiceTableColumn1==null){

      iryoInfoServiceTableColumn1 = new ACTableColumn(0);

      iryoInfoServiceTableColumn1.setHeaderValue("提供");

      iryoInfoServiceTableColumn1.setEditable(true);

      iryoInfoServiceTableColumn1.setColumns(3);

      iryoInfoServiceTableColumn1.setRendererType(VRTableCellViewer.RENDERER_TYPE_CHECK_BOX);

      iryoInfoServiceTableColumn1.setEditorType(VRTableCellViewer.EDITOR_TYPE_CHECK_BOX);

      addIryoInfoServiceTableColumn1();
    }
    return iryoInfoServiceTableColumn1;

  }

  /**
   * 列：サービス種類を取得します。
   * @return 列：サービス種類
   */
  public ACTableColumn getIryoInfoServiceTableColumn2(){
    if(iryoInfoServiceTableColumn2==null){

      iryoInfoServiceTableColumn2 = new ACTableColumn(1);

      iryoInfoServiceTableColumn2.setHeaderValue("サービス種類");

      iryoInfoServiceTableColumn2.setColumns(10);

      addIryoInfoServiceTableColumn2();
    }
    return iryoInfoServiceTableColumn2;

  }

  /**
   * 列：帳票種類を取得します。
   * @return 列：帳票種類
   */
  public ACTableColumn getIryoInfoServiceTableColumn3(){
    if(iryoInfoServiceTableColumn3==null){

      iryoInfoServiceTableColumn3 = new ACTableColumn(2);

      iryoInfoServiceTableColumn3.setHeaderValue("帳票種類");

      iryoInfoServiceTableColumn3.setColumns(12);

      addIryoInfoServiceTableColumn3();
    }
    return iryoInfoServiceTableColumn3;

  }

  /**
   * 社会福祉軽減領域を取得します。
   * @return 社会福祉軽減領域
   */
  public ACPanel getPoints3(){
    if(points3==null){

      points3 = new ACPanel();

      points3.setLayout(getShahukuLayout());

      addPoints3();
    }
    return points3;

  }

  /**
   * 社会福祉軽減領域・レイアウトを取得します。
   * @return 社会福祉軽減領域・レイアウト
   */
  public VRLayout getShahukuLayout(){
    if(shahukuLayout==null){

      shahukuLayout = new VRLayout();

      shahukuLayout.setAutoWrap(false);

      addShahukuLayout();
    }
    return shahukuLayout;

  }

  /**
   * 社会福祉軽減領域・情報を取得します。
   * @return 社会福祉軽減領域・情報
   */
  public ACPanel getShahukuInfos(){
    if(shahukuInfos==null){

      shahukuInfos = new ACPanel();

      addShahukuInfos();
    }
    return shahukuInfos;

  }

  /**
   * 社会福祉軽減領域・情報2を取得します。
   * @return 社会福祉軽減領域・情報2
   */
  public ACPanel getShahukuInfo(){
    if(shahukuInfo==null){

      shahukuInfo = new ACPanel();

      addShahukuInfo();
    }
    return shahukuInfo;

  }

  /**
   * (減額割合・コンテナ)を取得します。
   * @return (減額割合・コンテナ)
   */
  public ACLabelContainer getShahukuInfoBenefitRateContena(){
    if(shahukuInfoBenefitRateContena==null){

      shahukuInfoBenefitRateContena = new ACLabelContainer();

      shahukuInfoBenefitRateContena.setText("減額割合");

      addShahukuInfoBenefitRateContena();
    }
    return shahukuInfoBenefitRateContena;

  }

  /**
   * 減額割合を取得します。
   * @return 減額割合
   */
  public ACTextField getShahukuInfoBenefitRate(){
    if(shahukuInfoBenefitRate==null){

      shahukuInfoBenefitRate = new ACTextField();

      shahukuInfoBenefitRate.setBindPath("LOOK");

      shahukuInfoBenefitRate.setColumns(3);

      shahukuInfoBenefitRate.setCharType(VRCharType.ONLY_FLOAT);

      shahukuInfoBenefitRate.setHorizontalAlignment(SwingConstants.RIGHT);

      shahukuInfoBenefitRate.setIMEMode(InputSubset.LATIN);

      shahukuInfoBenefitRate.setMaxLength(4);

      addShahukuInfoBenefitRate();
    }
    return shahukuInfoBenefitRate;

  }

  /**
   * 単位ラベルを取得します。
   * @return 単位ラベル
   */
  public ACLabel getShahukuInfoPercentLabel(){
    if(shahukuInfoPercentLabel==null){

      shahukuInfoPercentLabel = new ACLabel();

      shahukuInfoPercentLabel.setText(" ／100 ");

      addShahukuInfoPercentLabel();
    }
    return shahukuInfoPercentLabel;

  }

  /**
   * 有効期間・コンテナを取得します。
   * @return 有効期間・コンテナ
   */
  public ACLabelContainer getShahukuInfoValidLimitContena(){
    if(shahukuInfoValidLimitContena==null){

      shahukuInfoValidLimitContena = new ACLabelContainer();

      shahukuInfoValidLimitContena.setText("有効期間");

      addShahukuInfoValidLimitContena();
    }
    return shahukuInfoValidLimitContena;

  }

  /**
   * 有効期間・テキスト1を取得します。
   * @return 有効期間・テキスト1
   */
  public QkanDateTextField getShahukuInfoValidLimit1(){
    if(shahukuInfoValidLimit1==null){

      shahukuInfoValidLimit1 = new QkanDateTextField();

      shahukuInfoValidLimit1.setBindPath("KOHI_VALID_START");

      shahukuInfoValidLimit1.setColumns(10);

      shahukuInfoValidLimit1.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      shahukuInfoValidLimit1.setMaxLength(11);

      addShahukuInfoValidLimit1();
    }
    return shahukuInfoValidLimit1;

  }

  /**
   * 有効期間・ラベルを取得します。
   * @return 有効期間・ラベル
   */
  public ACLabel getShahukuInfoValidLimitLabel(){
    if(shahukuInfoValidLimitLabel==null){

      shahukuInfoValidLimitLabel = new ACLabel();

      shahukuInfoValidLimitLabel.setText(" から ");

      addShahukuInfoValidLimitLabel();
    }
    return shahukuInfoValidLimitLabel;

  }

  /**
   * 有効期間・テキスト2を取得します。
   * @return 有効期間・テキスト2
   */
  public QkanDateTextField getShahukuInfoValidLimit2(){
    if(shahukuInfoValidLimit2==null){

      shahukuInfoValidLimit2 = new QkanDateTextField();

      shahukuInfoValidLimit2.setBindPath("KOHI_VALID_END");

      shahukuInfoValidLimit2.setColumns(10);

      shahukuInfoValidLimit2.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      shahukuInfoValidLimit2.setMaxLength(11);

      addShahukuInfoValidLimit2();
    }
    return shahukuInfoValidLimit2;

  }

  /**
   * 社会福祉軽減領域・ボタンを取得します。
   * @return 社会福祉軽減領域・ボタン
   */
  public ACPanel getShahukuInfoButtons(){
    if(shahukuInfoButtons==null){

      shahukuInfoButtons = new ACPanel();

      addShahukuInfoButtons();
    }
    return shahukuInfoButtons;

  }

  /**
   * クリアを取得します。
   * @return クリア
   */
  public ACButton getShahukuInfoButtonClear(){
    if(shahukuInfoButtonClear==null){

      shahukuInfoButtonClear = new ACButton();

      shahukuInfoButtonClear.setText("クリア");

      shahukuInfoButtonClear.setToolTipText("社会福祉軽減情報をクリアします。");

      shahukuInfoButtonClear.setIconPath(ACConstants.ICON_PATH_CLEAR_16);

      addShahukuInfoButtonClear();
    }
    return shahukuInfoButtonClear;

  }

  /**
   * 追加を取得します。
   * @return 追加
   */
  public ACButton getShahukuInfoButtonInsert(){
    if(shahukuInfoButtonInsert==null){

      shahukuInfoButtonInsert = new ACButton();

      shahukuInfoButtonInsert.setText("追加");

      shahukuInfoButtonInsert.setToolTipText("社会福祉軽減情報を追加します。");

      shahukuInfoButtonInsert.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addShahukuInfoButtonInsert();
    }
    return shahukuInfoButtonInsert;

  }

  /**
   * 書替を取得します。
   * @return 書替
   */
  public ACButton getShahukuInfoButtonConpile(){
    if(shahukuInfoButtonConpile==null){

      shahukuInfoButtonConpile = new ACButton();

      shahukuInfoButtonConpile.setText("書替");

      shahukuInfoButtonConpile.setToolTipText("社会福祉軽減情報を編集します。");

      shahukuInfoButtonConpile.setIconPath(ACConstants.ICON_PATH_STATE_UPDATE_16);

      addShahukuInfoButtonConpile();
    }
    return shahukuInfoButtonConpile;

  }

  /**
   * 削除を取得します。
   * @return 削除
   */
  public ACButton getShahukuInfoButtonDelete(){
    if(shahukuInfoButtonDelete==null){

      shahukuInfoButtonDelete = new ACButton();

      shahukuInfoButtonDelete.setText("削除");

      shahukuInfoButtonDelete.setToolTipText("社会福祉軽減情報を削除します。");

      shahukuInfoButtonDelete.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addShahukuInfoButtonDelete();
    }
    return shahukuInfoButtonDelete;

  }

  /**
   * 社会福祉軽減領域・テーブルを取得します。
   * @return 社会福祉軽減領域・テーブル
   */
  public ACPanel getShahukuInfoTables(){
    if(shahukuInfoTables==null){

      shahukuInfoTables = new ACPanel();

      addShahukuInfoTables();
    }
    return shahukuInfoTables;

  }

  /**
   * 社会福祉軽減領域・テーブルを取得します。
   * @return 社会福祉軽減領域・テーブル
   */
  public ACTable getShahukuInfoTable(){
    if(shahukuInfoTable==null){

      shahukuInfoTable = new ACTable();

      shahukuInfoTable.setColumnModel(getShahukuInfoTableColumnModel());

      addShahukuInfoTable();
    }
    return shahukuInfoTable;

  }

  /**
   * 社会福祉軽減領域・テーブルカラムモデルを取得します。
   * @return 社会福祉軽減領域・テーブルカラムモデル
   */
  protected VRTableColumnModel getShahukuInfoTableColumnModel(){
    if(shahukuInfoTableColumnModel==null){
      shahukuInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addShahukuInfoTableColumnModel();
    }
    return shahukuInfoTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getShahukuInfoTableColumn0(){
    if(shahukuInfoTableColumn0==null){

      shahukuInfoTableColumn0 = new ACTableColumn(0);

      shahukuInfoTableColumn0.setHeaderValue("No.");

      shahukuInfoTableColumn0.setColumns(3);

      shahukuInfoTableColumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      shahukuInfoTableColumn0.setSortable(false);

      addShahukuInfoTableColumn0();
    }
    return shahukuInfoTableColumn0;

  }

  /**
   * 給付率を取得します。
   * @return 給付率
   */
  public ACTableColumn getShahukuInfoTableColumn1(){
    if(shahukuInfoTableColumn1==null){

      shahukuInfoTableColumn1 = new ACTableColumn(0);

      shahukuInfoTableColumn1.setHeaderValue("減額割合");

      shahukuInfoTableColumn1.setColumns(7);

      shahukuInfoTableColumn1.setHorizontalAlignment(SwingConstants.RIGHT);

      addShahukuInfoTableColumn1();
    }
    return shahukuInfoTableColumn1;

  }

  /**
   * 有効期間開始を取得します。
   * @return 有効期間開始
   */
  public ACTableColumn getShahukuInfoTableColumn2(){
    if(shahukuInfoTableColumn2==null){

      shahukuInfoTableColumn2 = new ACTableColumn(1);

      shahukuInfoTableColumn2.setHeaderValue("有効期間開始日");

      shahukuInfoTableColumn2.setColumns(12);

      shahukuInfoTableColumn2.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addShahukuInfoTableColumn2();
    }
    return shahukuInfoTableColumn2;

  }

  /**
   * 有効期間終了を取得します。
   * @return 有効期間終了
   */
  public ACTableColumn getShahukuInfoTableColumn3(){
    if(shahukuInfoTableColumn3==null){

      shahukuInfoTableColumn3 = new ACTableColumn(2);

      shahukuInfoTableColumn3.setHeaderValue("有効期間終了日");

      shahukuInfoTableColumn3.setColumns(12);

      shahukuInfoTableColumn3.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addShahukuInfoTableColumn3();
    }
    return shahukuInfoTableColumn3;

  }

  /**
   * コンストラクタです。
   */
  public QU004Design() {

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
   * 業務ボタンバーに内部項目を追加します。
   */
  protected void addButtons(){

    buttons.add(getUpdate(), VRLayout.EAST);
    buttons.add(getInsert(), VRLayout.EAST);
  }

  /**
   * 登録に内部項目を追加します。
   */
  protected void addInsert(){

  }

  /**
   * 更新に内部項目を追加します。
   */
  protected void addUpdate(){

  }

  /**
   * クライアント領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getPatientInfo(), VRLayout.NORTH);

    contents.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * 利用者名領域に内部項目を追加します。
   */
  protected void addPatientInfo(){

    patientInfo.add(getPatientNameCaption(), VRLayout.FLOW);

    patientInfo.add(getPatientName(), VRLayout.FLOW);

  }

  /**
   * 利用者名キャプションに内部項目を追加します。
   */
  protected void addPatientNameCaption(){

  }

  /**
   * 利用者名に内部項目を追加します。
   */
  protected void addPatientName(){

  }

  /**
   * タブに内部項目を追加します。
   */
  protected void addTabs(){

    tabs.addTab("介護公費", getPoints1());

    tabs.addTab("医療公費", getPoints2());

    tabs.addTab("社福軽減", getPoints3());

  }

  /**
   * 介護公費領域に内部項目を追加します。
   */
  protected void addPoints1(){

    points1.add(getKaigoInfos(), VRLayout.CLIENT);

    points1.add(getKaigoInfoServices(), VRLayout.EAST);
  }

  /**
   * 介護公費領域・レイアウトに内部項目を追加します。
   */
  protected void addKaigoLayout(){

  }

  /**
   * 介護公費領域・情報に内部項目を追加します。
   */
  protected void addKaigoInfos(){

    kaigoInfos.add(getKaigoInfo(), VRLayout.NORTH);

    kaigoInfos.add(getKaigoInfoButtons(), VRLayout.NORTH);

    kaigoInfos.add(getKaigoInfoTables(), VRLayout.CLIENT);

  }

  /**
   * 介護公費領域・情報2に内部項目を追加します。
   */
  protected void addKaigoInfo(){

    kaigoInfo.add(getKaigoInfoPublicExpenseContainer(), VRLayout.FLOW_INSETLINE);

    kaigoInfo.add(getKaigoInfoBenefitRateContena(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoInfo.add(getKaigoInfoBearNoContena(), VRLayout.FLOW_INSETLINE);

    kaigoInfo.add(getKaigoInfoBearNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoInfo.add(getKaigoInfoReceiptNoContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoInfo.add(getKaigoInfoValidLimitContena(), VRLayout.FLOW_INSETLINE);

    kaigoInfo.add(getKaigoInfoSelfPaymentContents(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 公費情報に内部項目を追加します。
   */
  protected void addKaigoInfoPublicExpense(){

  }

  /**
   * 公費情報モデルに内部項目を追加します。
   */
  protected void addKaigoInfoPublicExpenseModel(){

  }

  /**
   * (給付率・コンテナ)に内部項目を追加します。
   */
  protected void addKaigoInfoBenefitRateContena(){

    kaigoInfoBenefitRateContena.add(getKaigoInfoBenefitRate(), VRLayout.FLOW);

    kaigoInfoBenefitRateContena.add(getKaigoInfoPercentLabel(), VRLayout.FLOW);

  }

  /**
   * 給付率に内部項目を追加します。
   */
  protected void addKaigoInfoBenefitRate(){

  }

  /**
   * %ラベルに内部項目を追加します。
   */
  protected void addKaigoInfoPercentLabel(){

  }

  /**
   * (負担者番号・コンテナ)に内部項目を追加します。
   */
  protected void addKaigoInfoBearNoContena(){

    kaigoInfoBearNoContena.add(getKaigoInfoKohiNo(), VRLayout.FLOW);

    kaigoInfoBearNoContena.add(getKaigoInfoInsurerNo(), VRLayout.FLOW);

  }

  /**
   * 公費法別番号に内部項目を追加します。
   */
  protected void addKaigoInfoKohiNo(){

  }

  /**
   * 保険者番号に内部項目を追加します。
   */
  protected void addKaigoInfoInsurerNo(){

  }

  /**
   * 負担者名に内部項目を追加します。
   */
  protected void addKaigoInfoBearName(){

  }

  /**
   * 負担者名モデルに内部項目を追加します。
   */
  protected void addKaigoInfoBearNameModel(){

  }

  /**
   * 受給者番号に内部項目を追加します。
   */
  protected void addKaigoInfoReceiptNo(){

  }

  /**
   * 有効期間・コンテナに内部項目を追加します。
   */
  protected void addKaigoInfoValidLimitContena(){

    kaigoInfoValidLimitContena.add(getKaigoInfoValidLimit1(), VRLayout.FLOW);

    kaigoInfoValidLimitContena.add(getKaigoInfoValidLimitLabel(), VRLayout.FLOW);

    kaigoInfoValidLimitContena.add(getKaigoInfoValidLimit2(), VRLayout.FLOW);

  }

  /**
   * 有効期間・テキスト1に内部項目を追加します。
   */
  protected void addKaigoInfoValidLimit1(){

  }

  /**
   * 有効期間・ラベルに内部項目を追加します。
   */
  protected void addKaigoInfoValidLimitLabel(){

  }

  /**
   * 有効期間・テキスト2に内部項目を追加します。
   */
  protected void addKaigoInfoValidLimit2(){

  }

  /**
   * (自己負担額・コンテナ)に内部項目を追加します。
   */
  protected void addKaigoInfoSelfPaymentContents(){

    kaigoInfoSelfPaymentContents.add(getKaigoInfoSelfPayment(), VRLayout.FLOW);

    kaigoInfoSelfPaymentContents.add(getKaigoInfoSelfPaymentYen(), VRLayout.FLOW);

  }

  /**
   * 自己負担額に内部項目を追加します。
   */
  protected void addKaigoInfoSelfPayment(){

  }

  /**
   * 自己負担額ラベルに内部項目を追加します。
   */
  protected void addKaigoInfoSelfPaymentYen(){

  }

  /**
   * 介護公費領域・ボタンに内部項目を追加します。
   */
  protected void addKaigoInfoButtons(){

    kaigoInfoButtons.add(getKaigoInfoButtonDelete(), VRLayout.EAST);
    kaigoInfoButtons.add(getKaigoInfoButtonConpile(), VRLayout.EAST);
    kaigoInfoButtons.add(getKaigoInfoButtonInsert(), VRLayout.EAST);
    kaigoInfoButtons.add(getKaigoInfoButtonClear(), VRLayout.EAST);
  }

  /**
   * クリアに内部項目を追加します。
   */
  protected void addKaigoInfoButtonClear(){

  }

  /**
   * 追加に内部項目を追加します。
   */
  protected void addKaigoInfoButtonInsert(){

  }

  /**
   * 書替に内部項目を追加します。
   */
  protected void addKaigoInfoButtonConpile(){

  }

  /**
   * 削除に内部項目を追加します。
   */
  protected void addKaigoInfoButtonDelete(){

  }

  /**
   * 介護公費領域・パネルに内部項目を追加します。
   */
  protected void addKaigoInfoTables(){

    kaigoInfoTables.add(getKaigoInfoTable(), VRLayout.CLIENT);

  }

  /**
   * 介護公費・テーブルに内部項目を追加します。
   */
  protected void addKaigoInfoTable(){

  }

  /**
   * 介護公費・テーブルカラムモデルに内部項目を追加します。
   */
  protected void addKaigoInfoTableColumnModel(){

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn0());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn1());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn2());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn3());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn5());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn6());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn7());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn0(){

  }

  /**
   * 公費情報に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn1(){

  }

  /**
   * 給付率に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn2(){

  }

  /**
   * 負担者番号に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn3(){

  }

  /**
   * 受給者番号に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn5(){

  }

  /**
   * 有効期間開始に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn6(){

  }

  /**
   * 有効期間終了に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn7(){

  }

  /**
   * 介護公費領域・サービスに内部項目を追加します。
   */
  protected void addKaigoInfoServices(){

    kaigoInfoServices.add(getKaigoInfoService(), VRLayout.CLIENT);

  }

  /**
   * サービス・グループに内部項目を追加します。
   */
  protected void addKaigoInfoService(){

    kaigoInfoService.add(getKaigoInfoServiceComment(), VRLayout.NORTH);

    kaigoInfoService.add(getKaigoInfoServiceTable(), VRLayout.CLIENT);

  }

  /**
   * 説明文ラベル・介護に内部項目を追加します。
   */
  protected void addKaigoInfoServiceComment(){

  }

  /**
   * 公費・使用サービステーブルに内部項目を追加します。
   */
  protected void addKaigoInfoServiceTable(){

  }

  /**
   * 公費・使用サービステーブルカラムモデルに内部項目を追加します。
   */
  protected void addKaigoInfoServiceTableColumnModel(){

    getKaigoInfoServiceTableColumnModel().addColumn(getKaigoInfoServiceTableColumn1());

    getKaigoInfoServiceTableColumnModel().addColumn(getKaigoInfoServiceTableColumn2());

    getKaigoInfoServiceTableColumnModel().addColumn(getKaigoInfoServiceTableColumn3());

  }

  /**
   * 列：提供に内部項目を追加します。
   */
  protected void addKaigoInfoServiceTableColumn1(){

  }

  /**
   * 列：サービス種類に内部項目を追加します。
   */
  protected void addKaigoInfoServiceTableColumn2(){

  }

  /**
   * 列：帳票種類に内部項目を追加します。
   */
  protected void addKaigoInfoServiceTableColumn3(){

  }

  /**
   * 医療公費領域に内部項目を追加します。
   */
  protected void addPoints2(){

    points2.add(getIryoInfos(), VRLayout.CLIENT);

    points2.add(getIryoInfoServices(), VRLayout.EAST);
  }

  /**
   * 医療公費領域・レイアウトに内部項目を追加します。
   */
  protected void addIryoLayout(){

  }

  /**
   * 医療公費領域・情報に内部項目を追加します。
   */
  protected void addIryoInfos(){

    iryoInfos.add(getIryoInfo(), VRLayout.NORTH);

    iryoInfos.add(getIryoInfoButtons(), VRLayout.NORTH);

    iryoInfos.add(getIryoInfoTables(), VRLayout.CLIENT);

  }

  /**
   * 医療公費領域・情報2に内部項目を追加します。
   */
  protected void addIryoInfo(){

    iryoInfo.add(getIryoInfoPublicExpenseContainer(), VRLayout.FLOW_INSETLINE);

    iryoInfo.add(getIryoInfoBenefitRateContena(), VRLayout.FLOW_INSETLINE_RETURN);

    iryoInfo.add(getIryoInfoBearNoContena(), VRLayout.FLOW_INSETLINE);

    iryoInfo.add(getIryoInfoBearNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    iryoInfo.add(getIryoInfoReceiptNoContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    iryoInfo.add(getIryoInfoValidLimitContena(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 公費情報に内部項目を追加します。
   */
  protected void addIryoInfoPublicExpense(){

  }

  /**
   * 公費情報モデルに内部項目を追加します。
   */
  protected void addIryoInfoPublicExpenseModel(){

  }

  /**
   * (給付率・コンテナ)に内部項目を追加します。
   */
  protected void addIryoInfoBenefitRateContena(){

    iryoInfoBenefitRateContena.add(getIryoInfoBenefitRate(), VRLayout.FLOW);

    iryoInfoBenefitRateContena.add(getIryoInfoPercentLabel(), VRLayout.FLOW);

  }

  /**
   * 給付率に内部項目を追加します。
   */
  protected void addIryoInfoBenefitRate(){

  }

  /**
   * %ラベルに内部項目を追加します。
   */
  protected void addIryoInfoPercentLabel(){

  }

  /**
   * (負担者番号・コンテナ)に内部項目を追加します。
   */
  protected void addIryoInfoBearNoContena(){

    iryoInfoBearNoContena.add(getIryoInfoKohiNo(), VRLayout.FLOW);

    iryoInfoBearNoContena.add(getIryoInfoInsurerNo(), VRLayout.FLOW);

  }

  /**
   * 公費法別番号に内部項目を追加します。
   */
  protected void addIryoInfoKohiNo(){

  }

  /**
   * 保険者番号に内部項目を追加します。
   */
  protected void addIryoInfoInsurerNo(){

  }

  /**
   * 負担者名に内部項目を追加します。
   */
  protected void addIryoInfoBearName(){

  }

  /**
   * 負担者名モデルに内部項目を追加します。
   */
  protected void addIryoInfoBearNameModel(){

  }

  /**
   * 受給者番号に内部項目を追加します。
   */
  protected void addIryoInfoReceiptNo(){

  }

  /**
   * 有効期間・コンテナに内部項目を追加します。
   */
  protected void addIryoInfoValidLimitContena(){

    iryoInfoValidLimitContena.add(getIryoInfoValidLimit1(), VRLayout.FLOW);

    iryoInfoValidLimitContena.add(getIryoInfoValidLimitLabel(), VRLayout.FLOW);

    iryoInfoValidLimitContena.add(getIryoInfoValidLimit2(), VRLayout.FLOW);

  }

  /**
   * 有効期間・テキスト1に内部項目を追加します。
   */
  protected void addIryoInfoValidLimit1(){

  }

  /**
   * 有効期間・ラベルに内部項目を追加します。
   */
  protected void addIryoInfoValidLimitLabel(){

  }

  /**
   * 有効期間・テキスト2に内部項目を追加します。
   */
  protected void addIryoInfoValidLimit2(){

  }

  /**
   * 医療公費領域・ボタンに内部項目を追加します。
   */
  protected void addIryoInfoButtons(){

    iryoInfoButtons.add(getIryoInfoButtonDelete(), VRLayout.EAST);
    iryoInfoButtons.add(getIryoInfoButtonConpile(), VRLayout.EAST);
    iryoInfoButtons.add(getIryoInfoButtonInsert(), VRLayout.EAST);
    iryoInfoButtons.add(getIryoInfoButtonClear(), VRLayout.EAST);
  }

  /**
   * クリアに内部項目を追加します。
   */
  protected void addIryoInfoButtonClear(){

  }

  /**
   * 追加に内部項目を追加します。
   */
  protected void addIryoInfoButtonInsert(){

  }

  /**
   * 書替に内部項目を追加します。
   */
  protected void addIryoInfoButtonConpile(){

  }

  /**
   * 削除に内部項目を追加します。
   */
  protected void addIryoInfoButtonDelete(){

  }

  /**
   * 医療公費領域・テーブルに内部項目を追加します。
   */
  protected void addIryoInfoTables(){

    iryoInfoTables.add(getIryoInfoTable(), VRLayout.CLIENT);

  }

  /**
   * 医療公費・テーブルに内部項目を追加します。
   */
  protected void addIryoInfoTable(){

  }

  /**
   * 医療公費・テーブルカラムモデルに内部項目を追加します。
   */
  protected void addIryoInfoTableColumnModel(){

    getIryoInfoTableColumnModel().addColumn(getIryoInfoTableColumn0());

    getIryoInfoTableColumnModel().addColumn(getIryoInfoTableColumn1());

    getIryoInfoTableColumnModel().addColumn(getIryoInfoTableColumn2());

    getIryoInfoTableColumnModel().addColumn(getIryoInfoTableColumn3());

    getIryoInfoTableColumnModel().addColumn(getIryoInfoTableColumn5());

    getIryoInfoTableColumnModel().addColumn(getIryoInfoTableColumn6());

    getIryoInfoTableColumnModel().addColumn(getIryoInfoTableColumn7());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addIryoInfoTableColumn0(){

  }

  /**
   * 公費情報に内部項目を追加します。
   */
  protected void addIryoInfoTableColumn1(){

  }

  /**
   * 給付率に内部項目を追加します。
   */
  protected void addIryoInfoTableColumn2(){

  }

  /**
   * 負担者番号に内部項目を追加します。
   */
  protected void addIryoInfoTableColumn3(){

  }

  /**
   * 受給者番号に内部項目を追加します。
   */
  protected void addIryoInfoTableColumn5(){

  }

  /**
   * 有効期間開始に内部項目を追加します。
   */
  protected void addIryoInfoTableColumn6(){

  }

  /**
   * 有効期間終了に内部項目を追加します。
   */
  protected void addIryoInfoTableColumn7(){

  }

  /**
   * 医療公費領域・サービスに内部項目を追加します。
   */
  protected void addIryoInfoServices(){

    iryoInfoServices.add(getIryoInfoService(), VRLayout.CLIENT);

  }

  /**
   * サービス・グループに内部項目を追加します。
   */
  protected void addIryoInfoService(){

    iryoInfoService.add(getIryoInfoServiceComment(), VRLayout.NORTH);

    iryoInfoService.add(getIryoInfoServiceTable(), VRLayout.CLIENT);

  }

  /**
   * 説明文ラベル・医療に内部項目を追加します。
   */
  protected void addIryoInfoServiceComment(){

  }

  /**
   * 医療公費・使用サービステーブルに内部項目を追加します。
   */
  protected void addIryoInfoServiceTable(){

  }

  /**
   * 医療公費・使用サービステーブルカラムモデルに内部項目を追加します。
   */
  protected void addIryoInfoServiceTableColumnModel(){

    getIryoInfoServiceTableColumnModel().addColumn(getIryoInfoServiceTableColumn1());

    getIryoInfoServiceTableColumnModel().addColumn(getIryoInfoServiceTableColumn2());

    getIryoInfoServiceTableColumnModel().addColumn(getIryoInfoServiceTableColumn3());

  }

  /**
   * 列：提供に内部項目を追加します。
   */
  protected void addIryoInfoServiceTableColumn1(){

  }

  /**
   * 列：サービス種類に内部項目を追加します。
   */
  protected void addIryoInfoServiceTableColumn2(){

  }

  /**
   * 列：帳票種類に内部項目を追加します。
   */
  protected void addIryoInfoServiceTableColumn3(){

  }

  /**
   * 社会福祉軽減領域に内部項目を追加します。
   */
  protected void addPoints3(){

    points3.add(getShahukuInfos(), VRLayout.CLIENT);

  }

  /**
   * 社会福祉軽減領域・レイアウトに内部項目を追加します。
   */
  protected void addShahukuLayout(){

  }

  /**
   * 社会福祉軽減領域・情報に内部項目を追加します。
   */
  protected void addShahukuInfos(){

    shahukuInfos.add(getShahukuInfo(), VRLayout.NORTH);

    shahukuInfos.add(getShahukuInfoButtons(), VRLayout.NORTH);

    shahukuInfos.add(getShahukuInfoTables(), VRLayout.CLIENT);

  }

  /**
   * 社会福祉軽減領域・情報2に内部項目を追加します。
   */
  protected void addShahukuInfo(){

    shahukuInfo.add(getShahukuInfoBenefitRateContena(), VRLayout.FLOW_INSETLINE_RETURN);

    shahukuInfo.add(getShahukuInfoValidLimitContena(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * (減額割合・コンテナ)に内部項目を追加します。
   */
  protected void addShahukuInfoBenefitRateContena(){

    shahukuInfoBenefitRateContena.add(getShahukuInfoBenefitRate(), VRLayout.FLOW);

    shahukuInfoBenefitRateContena.add(getShahukuInfoPercentLabel(), VRLayout.FLOW);

  }

  /**
   * 減額割合に内部項目を追加します。
   */
  protected void addShahukuInfoBenefitRate(){

  }

  /**
   * 単位ラベルに内部項目を追加します。
   */
  protected void addShahukuInfoPercentLabel(){

  }

  /**
   * 有効期間・コンテナに内部項目を追加します。
   */
  protected void addShahukuInfoValidLimitContena(){

    shahukuInfoValidLimitContena.add(getShahukuInfoValidLimit1(), VRLayout.FLOW);

    shahukuInfoValidLimitContena.add(getShahukuInfoValidLimitLabel(), VRLayout.FLOW);

    shahukuInfoValidLimitContena.add(getShahukuInfoValidLimit2(), VRLayout.FLOW);

  }

  /**
   * 有効期間・テキスト1に内部項目を追加します。
   */
  protected void addShahukuInfoValidLimit1(){

  }

  /**
   * 有効期間・ラベルに内部項目を追加します。
   */
  protected void addShahukuInfoValidLimitLabel(){

  }

  /**
   * 有効期間・テキスト2に内部項目を追加します。
   */
  protected void addShahukuInfoValidLimit2(){

  }

  /**
   * 社会福祉軽減領域・ボタンに内部項目を追加します。
   */
  protected void addShahukuInfoButtons(){

    shahukuInfoButtons.add(getShahukuInfoButtonDelete(), VRLayout.EAST);
    shahukuInfoButtons.add(getShahukuInfoButtonConpile(), VRLayout.EAST);
    shahukuInfoButtons.add(getShahukuInfoButtonInsert(), VRLayout.EAST);
    shahukuInfoButtons.add(getShahukuInfoButtonClear(), VRLayout.EAST);
  }

  /**
   * クリアに内部項目を追加します。
   */
  protected void addShahukuInfoButtonClear(){

  }

  /**
   * 追加に内部項目を追加します。
   */
  protected void addShahukuInfoButtonInsert(){

  }

  /**
   * 書替に内部項目を追加します。
   */
  protected void addShahukuInfoButtonConpile(){

  }

  /**
   * 削除に内部項目を追加します。
   */
  protected void addShahukuInfoButtonDelete(){

  }

  /**
   * 社会福祉軽減領域・テーブルに内部項目を追加します。
   */
  protected void addShahukuInfoTables(){

    shahukuInfoTables.add(getShahukuInfoTable(), VRLayout.CLIENT);

  }

  /**
   * 社会福祉軽減領域・テーブルに内部項目を追加します。
   */
  protected void addShahukuInfoTable(){

  }

  /**
   * 社会福祉軽減領域・テーブルカラムモデルに内部項目を追加します。
   */
  protected void addShahukuInfoTableColumnModel(){

    getShahukuInfoTableColumnModel().addColumn(getShahukuInfoTableColumn0());

    getShahukuInfoTableColumnModel().addColumn(getShahukuInfoTableColumn1());

    getShahukuInfoTableColumnModel().addColumn(getShahukuInfoTableColumn2());

    getShahukuInfoTableColumnModel().addColumn(getShahukuInfoTableColumn3());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addShahukuInfoTableColumn0(){

  }

  /**
   * 給付率に内部項目を追加します。
   */
  protected void addShahukuInfoTableColumn1(){

  }

  /**
   * 有効期間開始に内部項目を追加します。
   */
  protected void addShahukuInfoTableColumn2(){

  }

  /**
   * 有効期間終了に内部項目を追加します。
   */
  protected void addShahukuInfoTableColumn3(){

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
      ACFrame.debugStart(new ACAffairInfo(QU004Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QU004Design getThis() {
    return this;
  }
}
