
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
 * 開発者: 樋口　雅彦
 * 作成日: 2012/04/12  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 実績確定/請求書出力 (P)
 * プロセス 請求処理 (001)
 * プログラム 利用者一覧（請求） (QP001)
 *
 *****************************************************************
 */
package jp.nichicom.ac.lib.care.claim.calculation;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACAffairButton;
import jp.nichicom.ac.component.ACAffairButtonBar;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACIntegerCheckBox;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.table.ACCheckBoxTableColumnPopupMenu;
import jp.nichicom.ac.component.table.ACTable;
import jp.nichicom.ac.component.table.ACTableCellViewer;
import jp.nichicom.ac.component.table.ACTableColumn;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACAffairable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
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
import jp.or.med.orca.qkan.component.QkanDateTextField;
import jp.or.med.orca.qkan.component.QkanYearDateTextField;
/**
 * 利用者一覧（請求）画面項目デザイン(QP001) 
 */
public class QP001Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton entry;

  private ACAffairButton find;

  private ACAffairButton delete;

  private ACAffairButton printList;

  private ACAffairButton print;

  private ACAffairButton csvOut;

  private ACAffairButton commit;

  private ACPanel contents;

  private ACPanel extractConditions;

  private ACLabel loginProviderInfo;

  private ACGroupBox extractCondition;

  private ACLabelContainer targetDateContena;

  private QkanYearDateTextField targetDate;

  private ACLabel targetDateLabel4;

  private QkanYearDateTextField claimDate;

  private ACLabelContainer claimDateContainer;

  private ACIntegerCheckBox notOutputDistinction;

  private ACLabelContainer insurerContena;

  private ACTextField insurerNoText;

  private ACComboBox insurerNoConbo;

  private ACComboBoxModelAdapter insurerNoConboModel;

  private ACTextField patientCodeText;

  private ACLabelContainer patientCodeTextContainer;

  private ACTextField patientFuriganaText;

  private ACLabelContainer patientFuriganaTextContainer;

  private ACTextField insuredNoText;

  private ACLabelContainer insuredNoTextContainer;

  private ACPanel updateConditions;

  private ACGroupBox updateCondition;

  private QkanYearDateTextField claimDateUpdate;

  private ACLabelContainer claimDateUpdateContainer;

  private ACIntegerCheckBox claimDateUpdateChangePermit;

  private ACPanel printConditions;

  private ACGroupBox printCondition;

  private QkanDateTextField claimDatePrint;

  private ACLabelContainer claimDatePrintContainer;

  private ACPanel typeCountInfomations;

  private ACGroupBox typeCountInfomation;

  private ACTextField supplyCount;

  private ACLabelContainer supplyCountContainer;

  private ACTextField nursingCount;

  private ACLabelContainer nursingCountContainer;

  private ACTextField type7Count;

  private ACLabelContainer type7CountContainer;

  private ACTextField type2Count;

  private ACLabelContainer type2CountContainer;

  private ACTextField type3Count;

  private ACLabelContainer type3CountContainer;

  private ACTextField type4Count;

  private ACLabelContainer type4CountContainer;

  private ACTextField type5Count;

  private ACLabelContainer type5CountContainer;

  private ACTextField type6Count;

  private ACLabelContainer type6CountContainer;

  private ACTextField type8Count;

  private ACLabelContainer type8CountContainer;

  private ACTextField type9Count;

  private ACLabelContainer type9CountContainer;

  private ACTextField type10Count;

  private ACLabelContainer type10CountContainer;

  private ACTextField visitCount;

  private ACLabelContainer visitCountContainer;

  private ACTextField syahoCount;

  private ACLabelContainer syahoCountContainer;

  private ACTextField kokuhoCount;

  private ACLabelContainer kokuhoCountContainer;

  private ACTextField serviceCount;

  private ACLabelContainer serviceCountContainer;

  private ACPanel demandMoneyAndTotalDenominations;

  private ACGroupBox demandMoneyAndTotalDenomination;

  private ACTextField totalDenominationText;

  private ACLabelContainer totalDenominationTextContainer;

  private ACTextField totalMoneyText;

  private ACLabelContainer totalMoneyTextContainer;

  private ACTextField demandMoneyInsuranceMoneyText;

  private ACLabelContainer demandMoneyInsuranceMoneyTextContainer;

  private ACTextField demandMoneyPatientMoneyText;

  private ACLabelContainer demandMoneyPatientMoneyTextContainer;

  private ACTextField totalDenominationPublicExpenseMoneyText;

  private ACLabelContainer totalDenominationPublicExpenseMoneyTextContainer;

  private ACPanel infos;

  private ACTable infoTable;

  private VRTableColumnModel infoTableColumnModel;

  private ACTableColumn infoTableColumn1;

  private ACTableColumn infoTableColumn2;

  private ACTableColumn infoTableColumn3;

  private ACTableColumn infoTableColumn4;

  private ACTableColumn infoTableColumn23;

  private ACTableColumn infoTableColumn5;

  private ACTableColumn infoTableColumn14;

  private ACTableColumn infoTableColumn6;

  private ACTableColumn infoTableColumn7;

  private ACTableColumn infoTableColumn8;

  private ACTableColumn infoTableColumn9;

  private ACTableColumn infoTableColumn10;

  private ACTableColumn infoTableColumn11;

  private ACTableColumn infoTableColumn12;

  private ACTableColumn infoTableColumn13;

  private ACTableColumn infoTableColumn15;

  private ACTableColumn infoTableColumn16;

  private ACTableColumn infoTableColumn17;

  private ACTableColumn infoTableColumn18;

  private ACTableColumn infoTableColumn19;

  private ACTableColumn infoTableColumn20;

  private ACTableColumn infoTableColumn21;

  private ACTableColumn infoTableColumn22;

  //getter

  /**
   * 業務ボタンバーを取得します。
   * @return 業務ボタンバー
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
   * 詳細を取得します。
   * @return 詳細
   */
  public ACAffairButton getEntry(){
    if(entry==null){

      entry = new ACAffairButton();

      entry.setText("詳細(E)");

      entry.setToolTipText("確認・修正画面を表示します。");

      entry.setMnemonic('E');

      entry.setIconPath(ACConstants.ICON_PATH_DETAIL_24);

      addEntry();
    }
    return entry;

  }

  /**
   * 検索ボタンを取得します。
   * @return 検索ボタン
   */
  public ACAffairButton getFind(){
    if(find==null){

      find = new ACAffairButton();

      find.setText("検索(F)");

      find.setToolTipText("利用者を検索します。");

      find.setMnemonic('F');

      find.setIconPath(ACConstants.ICON_PATH_FIND_24);

      addFind();
    }
    return find;

  }

  /**
   * 削除ボタンを取得します。
   * @return 削除ボタン
   */
  public ACAffairButton getDelete(){
    if(delete==null){

      delete = new ACAffairButton();

      delete.setText("削除(D)");

      delete.setToolTipText("請求情報を削除します。");

      delete.setMnemonic('D');

      delete.setIconPath(ACConstants.ICON_PATH_DELETE_24);

      addDelete();
    }
    return delete;

  }

  /**
   * 一覧印刷を取得します。
   * @return 一覧印刷
   */
  public ACAffairButton getPrintList(){
    if(printList==null){

      printList = new ACAffairButton();

      printList.setText("一覧印刷(L)");

      printList.setToolTipText("利用者一覧表を印刷します。");

      printList.setMnemonic('L');

      printList.setIconPath(ACConstants.ICON_PATH_TABLE_PRINT_24);

      addPrintList();
    }
    return printList;

  }

  /**
   * 印刷ボタンを取得します。
   * @return 印刷ボタン
   */
  public ACAffairButton getPrint(){
    if(print==null){

      print = new ACAffairButton();

      print.setText("印刷(P)");

      print.setToolTipText("印刷を実行します。");

      print.setMnemonic('P');

      print.setIconPath(ACConstants.ICON_PATH_PRINT_24);

      addPrint();
    }
    return print;

  }

  /**
   * CSV出力ボタンを取得します。
   * @return CSV出力ボタン
   */
  public ACAffairButton getCsvOut(){
    if(csvOut==null){

      csvOut = new ACAffairButton();

      csvOut.setText("CSV作成(M)");

      csvOut.setToolTipText("CSV出力を行います。");

      csvOut.setMnemonic('M');

      csvOut.setIconPath(ACConstants.ICON_PATH_EXPORT_24);

      addCsvOut();
    }
    return csvOut;

  }

  /**
   * 実績確定を取得します。
   * @return 実績確定
   */
  public ACAffairButton getCommit(){
    if(commit==null){

      commit = new ACAffairButton();

      commit.setText("実績確定(T)");

      commit.setToolTipText("実績集計を行います。");

      commit.setMnemonic('T');

      commit.setIconPath(ACConstants.ICON_PATH_CALC_24);

      addCommit();
    }
    return commit;

  }

  /**
   * 情報領域を取得します。
   * @return 情報領域
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      addContents();
    }
    return contents;

  }

  /**
   * 抽出条件領域を取得します。
   * @return 抽出条件領域
   */
  public ACPanel getExtractConditions(){
    if(extractConditions==null){

      extractConditions = new ACPanel();

      addExtractConditions();
    }
    return extractConditions;

  }

  /**
   * ログイン事業所を取得します。
   * @return ログイン事業所
   */
  public ACLabel getLoginProviderInfo(){
    if(loginProviderInfo==null){

      loginProviderInfo = new ACLabel();

      loginProviderInfo.setText("ログイン事業所 に関する集計・請求処理を行ないます。他の事業所を対象とする場合は、ログアウトを行い事業所を選択しなおしてください。");

      loginProviderInfo.setIconPath(ACConstants.ICON_PATH_INFORMATION_16);

      loginProviderInfo.setAutoWrap(true);

      addLoginProviderInfo();
    }
    return loginProviderInfo;

  }

  /**
   * 抽出条件領域・フレームを取得します。
   * @return 抽出条件領域・フレーム
   */
  public ACGroupBox getExtractCondition(){
    if(extractCondition==null){

      extractCondition = new ACGroupBox();

      extractCondition.setText("抽出条件");

      extractCondition.setAutoWrap(false);

      extractCondition.setHgap(0);

      addExtractCondition();
    }
    return extractCondition;

  }

  /**
   * 対象年月・コンテナを取得します。
   * @return 対象年月・コンテナ
   */
  public ACLabelContainer getTargetDateContena(){
    if(targetDateContena==null){

      targetDateContena = new ACLabelContainer();

      targetDateContena.setText("対象年月");

      addTargetDateContena();
    }
    return targetDateContena;

  }

  /**
   * 対象年月を取得します。
   * @return 対象年月
   */
  public QkanYearDateTextField getTargetDate(){
    if(targetDate==null){

      targetDate = new QkanYearDateTextField();

      targetDate.setBindPath("REST_TARGET_DATE");

      try{
        targetDate.setMinimumDate(ACCastUtilities.toDate("2012/04/01"));
      }catch(Throwable ex){
        ACCommon.getInstance().showExceptionMessage(new IllegalArgumentException("targetDate の最小年月日に不正な日付が指定されています。"));
      }

      addTargetDate();
    }
    return targetDate;

  }

  /**
   * 対象年月・ラベル(度を取得します。
   * @return 対象年月・ラベル(度
   */
  public ACLabel getTargetDateLabel4(){
    if(targetDateLabel4==null){

      targetDateLabel4 = new ACLabel();

      targetDateLabel4.setText("度");

      addTargetDateLabel4();
    }
    return targetDateLabel4;

  }

  /**
   * 請求年月・テキストを取得します。
   * @return 請求年月・テキスト
   */
  public QkanYearDateTextField getClaimDate(){
    if(claimDate==null){

      claimDate = new QkanYearDateTextField();

      getClaimDateContainer().setText("請求年月");

      claimDate.setBindPath("CLAIM_TARGET_DATE");

      addClaimDate();
    }
    return claimDate;

  }

  /**
   * 請求年月・テキストコンテナを取得します。
   * @return 請求年月・テキストコンテナ
   */
  protected ACLabelContainer getClaimDateContainer(){
    if(claimDateContainer==null){
      claimDateContainer = new ACLabelContainer();
      claimDateContainer.setFollowChildEnabled(true);
      claimDateContainer.setVAlignment(VRLayout.CENTER);
      claimDateContainer.add(getClaimDate(), null);
    }
    return claimDateContainer;
  }

  /**
   * 未出力判別チェックボックスを取得します。
   * @return 未出力判別チェックボックス
   */
  public ACIntegerCheckBox getNotOutputDistinction(){
    if(notOutputDistinction==null){

      notOutputDistinction = new ACIntegerCheckBox();

      notOutputDistinction.setText("未出力の利用者だけを表示(V)");

      notOutputDistinction.setBindPath("NOT_OUTPUT");

      notOutputDistinction.setMnemonic('V');

      addNotOutputDistinction();
    }
    return notOutputDistinction;

  }

  /**
   * 保険者番号・コンテナを取得します。
   * @return 保険者番号・コンテナ
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
   * 保険者番号・テキストを取得します。
   * @return 保険者番号・テキスト
   */
  public ACTextField getInsurerNoText(){
    if(insurerNoText==null){

      insurerNoText = new ACTextField();

      insurerNoText.setBindPath("INSURER_TEXT");

      insurerNoText.setColumns(6);

      insurerNoText.setCharType(VRCharType.ONLY_DIGIT);

      insurerNoText.setIMEMode(InputSubset.LATIN);

      insurerNoText.setMaxLength(6);

      addInsurerNoText();
    }
    return insurerNoText;

  }

  /**
   * 保険者番号・コンボを取得します。
   * @return 保険者番号・コンボ
   */
  public ACComboBox getInsurerNoConbo(){
    if(insurerNoConbo==null){

      insurerNoConbo = new ACComboBox();

      insurerNoConbo.setBindPath("INSURER_COMBO");

      insurerNoConbo.setEditable(false);

      insurerNoConbo.setModel(getInsurerNoConboModel());

      addInsurerNoConbo();
    }
    return insurerNoConbo;

  }

  /**
   * 保険者番号・コンボモデルを取得します。
   * @return 保険者番号・コンボモデル
   */
  protected ACComboBoxModelAdapter getInsurerNoConboModel(){
    if(insurerNoConboModel==null){
      insurerNoConboModel = new ACComboBoxModelAdapter();
      addInsurerNoConboModel();
    }
    return insurerNoConboModel;
  }

  /**
   * 利用者コード・テキストを取得します。
   * @return 利用者コード・テキスト
   */
  public ACTextField getPatientCodeText(){
    if(patientCodeText==null){

      patientCodeText = new ACTextField();

      getPatientCodeTextContainer().setText("利用者コード");

      patientCodeText.setBindPath("PATIENT_CODE_TEXT");

      patientCodeText.setColumns(15);

      patientCodeText.setCharType(VRCharType.ONLY_HALF_CHAR);

      patientCodeText.setIMEMode(InputSubset.LATIN);

      patientCodeText.setMaxLength(15);

      addPatientCodeText();
    }
    return patientCodeText;

  }

  /**
   * 利用者コード・テキストコンテナを取得します。
   * @return 利用者コード・テキストコンテナ
   */
  protected ACLabelContainer getPatientCodeTextContainer(){
    if(patientCodeTextContainer==null){
      patientCodeTextContainer = new ACLabelContainer();
      patientCodeTextContainer.setFollowChildEnabled(true);
      patientCodeTextContainer.setVAlignment(VRLayout.CENTER);
      patientCodeTextContainer.add(getPatientCodeText(), null);
    }
    return patientCodeTextContainer;
  }

  /**
   * 利用者ふりがな・テキストを取得します。
   * @return 利用者ふりがな・テキスト
   */
  public ACTextField getPatientFuriganaText(){
    if(patientFuriganaText==null){

      patientFuriganaText = new ACTextField();

      getPatientFuriganaTextContainer().setText("利用者ふりがな");

      patientFuriganaText.setBindPath("PATIENT_NAME_KN");

      patientFuriganaText.setColumns(40);

      patientFuriganaText.setIMEMode(InputSubset.KANJI);

      patientFuriganaText.setMaxLength(40);

      addPatientFuriganaText();
    }
    return patientFuriganaText;

  }

  /**
   * 利用者ふりがな・テキストコンテナを取得します。
   * @return 利用者ふりがな・テキストコンテナ
   */
  protected ACLabelContainer getPatientFuriganaTextContainer(){
    if(patientFuriganaTextContainer==null){
      patientFuriganaTextContainer = new ACLabelContainer();
      patientFuriganaTextContainer.setFollowChildEnabled(true);
      patientFuriganaTextContainer.setVAlignment(VRLayout.CENTER);
      patientFuriganaTextContainer.add(getPatientFuriganaText(), null);
    }
    return patientFuriganaTextContainer;
  }

  /**
   * 被保険者番号・テキストを取得します。
   * @return 被保険者番号・テキスト
   */
  public ACTextField getInsuredNoText(){
    if(insuredNoText==null){

      insuredNoText = new ACTextField();

      getInsuredNoTextContainer().setText("被保険者番号");

      insuredNoText.setBindPath("INSURED_ID_TEXT");

      insuredNoText.setColumns(10);

      insuredNoText.setCharType(VRCharType.ONLY_DIGIT);

      insuredNoText.setIMEMode(InputSubset.LATIN);

      insuredNoText.setMaxLength(10);

      addInsuredNoText();
    }
    return insuredNoText;

  }

  /**
   * 被保険者番号・テキストコンテナを取得します。
   * @return 被保険者番号・テキストコンテナ
   */
  protected ACLabelContainer getInsuredNoTextContainer(){
    if(insuredNoTextContainer==null){
      insuredNoTextContainer = new ACLabelContainer();
      insuredNoTextContainer.setFollowChildEnabled(true);
      insuredNoTextContainer.setVAlignment(VRLayout.CENTER);
      insuredNoTextContainer.add(getInsuredNoText(), null);
    }
    return insuredNoTextContainer;
  }

  /**
   * 登録条件領域を取得します。
   * @return 登録条件領域
   */
  public ACPanel getUpdateConditions(){
    if(updateConditions==null){

      updateConditions = new ACPanel();

      addUpdateConditions();
    }
    return updateConditions;

  }

  /**
   * 登録条件領域・フレームを取得します。
   * @return 登録条件領域・フレーム
   */
  public ACGroupBox getUpdateCondition(){
    if(updateCondition==null){

      updateCondition = new ACGroupBox();

      updateCondition.setText("登録条件");

      addUpdateCondition();
    }
    return updateCondition;

  }

  /**
   * 請求年月・テキスト(登録用)を取得します。
   * @return 請求年月・テキスト(登録用)
   */
  public QkanYearDateTextField getClaimDateUpdate(){
    if(claimDateUpdate==null){

      claimDateUpdate = new QkanYearDateTextField();

      getClaimDateUpdateContainer().setText("請求年月");

      claimDateUpdate.setBindPath("CLAIM_UPDATE_DATE");

      try{
        claimDateUpdate.setMinimumDate(ACCastUtilities.toDate("2012/04/01"));
      }catch(Throwable ex){
        ACCommon.getInstance().showExceptionMessage(new IllegalArgumentException("claimDateUpdate の最小年月日に不正な日付が指定されています。"));
      }

      addClaimDateUpdate();
    }
    return claimDateUpdate;

  }

  /**
   * 請求年月・テキスト(登録用)コンテナを取得します。
   * @return 請求年月・テキスト(登録用)コンテナ
   */
  protected ACLabelContainer getClaimDateUpdateContainer(){
    if(claimDateUpdateContainer==null){
      claimDateUpdateContainer = new ACLabelContainer();
      claimDateUpdateContainer.setFollowChildEnabled(true);
      claimDateUpdateContainer.setVAlignment(VRLayout.CENTER);
      claimDateUpdateContainer.add(getClaimDateUpdate(), null);
    }
    return claimDateUpdateContainer;
  }

  /**
   * 請求年月変更許可チェックボックスを取得します。
   * @return 請求年月変更許可チェックボックス
   */
  public ACIntegerCheckBox getClaimDateUpdateChangePermit(){
    if(claimDateUpdateChangePermit==null){

      claimDateUpdateChangePermit = new ACIntegerCheckBox();

      claimDateUpdateChangePermit.setText("請求年月を変更する(C)");

      claimDateUpdateChangePermit.setMnemonic('C');

      addClaimDateUpdateChangePermit();
    }
    return claimDateUpdateChangePermit;

  }

  /**
   * 印刷条件領域を取得します。
   * @return 印刷条件領域
   */
  public ACPanel getPrintConditions(){
    if(printConditions==null){

      printConditions = new ACPanel();

      addPrintConditions();
    }
    return printConditions;

  }

  /**
   * 印刷条件領域・フレームを取得します。
   * @return 印刷条件領域・フレーム
   */
  public ACGroupBox getPrintCondition(){
    if(printCondition==null){

      printCondition = new ACGroupBox();

      printCondition.setText("印刷条件");

      addPrintCondition();
    }
    return printCondition;

  }

  /**
   * 請求書日付を取得します。
   * @return 請求書日付
   */
  public QkanDateTextField getClaimDatePrint(){
    if(claimDatePrint==null){

      claimDatePrint = new QkanDateTextField();

      getClaimDatePrintContainer().setText("請求書日付");

      claimDatePrint.setBindPath("CLAIM_PRINT_DATE");

      claimDatePrint.setColumns(10);

      addClaimDatePrint();
    }
    return claimDatePrint;

  }

  /**
   * 請求書日付コンテナを取得します。
   * @return 請求書日付コンテナ
   */
  protected ACLabelContainer getClaimDatePrintContainer(){
    if(claimDatePrintContainer==null){
      claimDatePrintContainer = new ACLabelContainer();
      claimDatePrintContainer.setFollowChildEnabled(true);
      claimDatePrintContainer.setVAlignment(VRLayout.CENTER);
      claimDatePrintContainer.add(getClaimDatePrint(), null);
    }
    return claimDatePrintContainer;
  }

  /**
   * 様式枚数情報領域を取得します。
   * @return 様式枚数情報領域
   */
  public ACPanel getTypeCountInfomations(){
    if(typeCountInfomations==null){

      typeCountInfomations = new ACPanel();

      addTypeCountInfomations();
    }
    return typeCountInfomations;

  }

  /**
   * 様式枚数情報領域・フレームを取得します。
   * @return 様式枚数情報領域・フレーム
   */
  public ACGroupBox getTypeCountInfomation(){
    if(typeCountInfomation==null){

      typeCountInfomation = new ACGroupBox();

      typeCountInfomation.setText("様式");

      addTypeCountInfomation();
    }
    return typeCountInfomation;

  }

  /**
   * 給付管理票・テキストを取得します。
   * @return 給付管理票・テキスト
   */
  public ACTextField getSupplyCount(){
    if(supplyCount==null){

      supplyCount = new ACTextField();

      getSupplyCountContainer().setText("給付管理票件数");

      supplyCount.setColumns(3);

      supplyCount.setEditable(false);

      addSupplyCount();
    }
    return supplyCount;

  }

  /**
   * 給付管理票・テキストコンテナを取得します。
   * @return 給付管理票・テキストコンテナ
   */
  protected ACLabelContainer getSupplyCountContainer(){
    if(supplyCountContainer==null){
      supplyCountContainer = new ACLabelContainer();
      supplyCountContainer.setFollowChildEnabled(true);
      supplyCountContainer.setVAlignment(VRLayout.CENTER);
      supplyCountContainer.add(getSupplyCount(), null);
    }
    return supplyCountContainer;
  }

  /**
   * 介護給付費請求書・テキストを取得します。
   * @return 介護給付費請求書・テキスト
   */
  public ACTextField getNursingCount(){
    if(nursingCount==null){

      nursingCount = new ACTextField();

      getNursingCountContainer().setText("介護給付費請求書件数");

      nursingCount.setColumns(3);

      nursingCount.setEditable(false);

      addNursingCount();
    }
    return nursingCount;

  }

  /**
   * 介護給付費請求書・テキストコンテナを取得します。
   * @return 介護給付費請求書・テキストコンテナ
   */
  protected ACLabelContainer getNursingCountContainer(){
    if(nursingCountContainer==null){
      nursingCountContainer = new ACLabelContainer();
      nursingCountContainer.setFollowChildEnabled(true);
      nursingCountContainer.setVAlignment(VRLayout.CENTER);
      nursingCountContainer.add(getNursingCount(), null);
    }
    return nursingCountContainer;
  }

  /**
   * 様式第七・テキストを取得します。
   * @return 様式第七・テキスト
   */
  public ACTextField getType7Count(){
    if(type7Count==null){

      type7Count = new ACTextField();

      getType7CountContainer().setText("様式第七件数");

      type7Count.setBindPath("STYLE_7");

      type7Count.setColumns(3);

      type7Count.setEditable(false);

      addType7Count();
    }
    return type7Count;

  }

  /**
   * 様式第七・テキストコンテナを取得します。
   * @return 様式第七・テキストコンテナ
   */
  protected ACLabelContainer getType7CountContainer(){
    if(type7CountContainer==null){
      type7CountContainer = new ACLabelContainer();
      type7CountContainer.setFollowChildEnabled(true);
      type7CountContainer.setVAlignment(VRLayout.CENTER);
      type7CountContainer.add(getType7Count(), null);
    }
    return type7CountContainer;
  }

  /**
   * 様式第二・テキストを取得します。
   * @return 様式第二・テキスト
   */
  public ACTextField getType2Count(){
    if(type2Count==null){

      type2Count = new ACTextField();

      getType2CountContainer().setText("様式第二件数");

      type2Count.setBindPath("STYLE_2");

      type2Count.setColumns(3);

      type2Count.setEditable(false);

      addType2Count();
    }
    return type2Count;

  }

  /**
   * 様式第二・テキストコンテナを取得します。
   * @return 様式第二・テキストコンテナ
   */
  protected ACLabelContainer getType2CountContainer(){
    if(type2CountContainer==null){
      type2CountContainer = new ACLabelContainer();
      type2CountContainer.setFollowChildEnabled(true);
      type2CountContainer.setVAlignment(VRLayout.CENTER);
      type2CountContainer.add(getType2Count(), null);
    }
    return type2CountContainer;
  }

  /**
   * 様式第三・テキストを取得します。
   * @return 様式第三・テキスト
   */
  public ACTextField getType3Count(){
    if(type3Count==null){

      type3Count = new ACTextField();

      getType3CountContainer().setText("様式第三件数");

      type3Count.setBindPath("STYLE_3");

      type3Count.setColumns(3);

      type3Count.setEditable(false);

      addType3Count();
    }
    return type3Count;

  }

  /**
   * 様式第三・テキストコンテナを取得します。
   * @return 様式第三・テキストコンテナ
   */
  protected ACLabelContainer getType3CountContainer(){
    if(type3CountContainer==null){
      type3CountContainer = new ACLabelContainer();
      type3CountContainer.setFollowChildEnabled(true);
      type3CountContainer.setVAlignment(VRLayout.CENTER);
      type3CountContainer.add(getType3Count(), null);
    }
    return type3CountContainer;
  }

  /**
   * 様式第四・テキストを取得します。
   * @return 様式第四・テキスト
   */
  public ACTextField getType4Count(){
    if(type4Count==null){

      type4Count = new ACTextField();

      getType4CountContainer().setText("様式第四件数");

      type4Count.setBindPath("STYLE_4");

      type4Count.setColumns(3);

      type4Count.setEditable(false);

      addType4Count();
    }
    return type4Count;

  }

  /**
   * 様式第四・テキストコンテナを取得します。
   * @return 様式第四・テキストコンテナ
   */
  protected ACLabelContainer getType4CountContainer(){
    if(type4CountContainer==null){
      type4CountContainer = new ACLabelContainer();
      type4CountContainer.setFollowChildEnabled(true);
      type4CountContainer.setVAlignment(VRLayout.CENTER);
      type4CountContainer.add(getType4Count(), null);
    }
    return type4CountContainer;
  }

  /**
   * 様式第五・テキストを取得します。
   * @return 様式第五・テキスト
   */
  public ACTextField getType5Count(){
    if(type5Count==null){

      type5Count = new ACTextField();

      getType5CountContainer().setText("様式第五件数");

      type5Count.setBindPath("STYLE_5");

      type5Count.setColumns(3);

      type5Count.setEditable(false);

      addType5Count();
    }
    return type5Count;

  }

  /**
   * 様式第五・テキストコンテナを取得します。
   * @return 様式第五・テキストコンテナ
   */
  protected ACLabelContainer getType5CountContainer(){
    if(type5CountContainer==null){
      type5CountContainer = new ACLabelContainer();
      type5CountContainer.setFollowChildEnabled(true);
      type5CountContainer.setVAlignment(VRLayout.CENTER);
      type5CountContainer.add(getType5Count(), null);
    }
    return type5CountContainer;
  }

  /**
   * 様式第六・テキストを取得します。
   * @return 様式第六・テキスト
   */
  public ACTextField getType6Count(){
    if(type6Count==null){

      type6Count = new ACTextField();

      getType6CountContainer().setText("様式第六件数");

      type6Count.setBindPath("STYLE_6");

      type6Count.setColumns(3);

      type6Count.setEditable(false);

      addType6Count();
    }
    return type6Count;

  }

  /**
   * 様式第六・テキストコンテナを取得します。
   * @return 様式第六・テキストコンテナ
   */
  protected ACLabelContainer getType6CountContainer(){
    if(type6CountContainer==null){
      type6CountContainer = new ACLabelContainer();
      type6CountContainer.setFollowChildEnabled(true);
      type6CountContainer.setVAlignment(VRLayout.CENTER);
      type6CountContainer.add(getType6Count(), null);
    }
    return type6CountContainer;
  }

  /**
   * 様式第八・テキストを取得します。
   * @return 様式第八・テキスト
   */
  public ACTextField getType8Count(){
    if(type8Count==null){

      type8Count = new ACTextField();

      getType8CountContainer().setText("様式第八件数");

      type8Count.setBindPath("STYLE_8");

      type8Count.setColumns(3);

      type8Count.setEditable(false);

      addType8Count();
    }
    return type8Count;

  }

  /**
   * 様式第八・テキストコンテナを取得します。
   * @return 様式第八・テキストコンテナ
   */
  protected ACLabelContainer getType8CountContainer(){
    if(type8CountContainer==null){
      type8CountContainer = new ACLabelContainer();
      type8CountContainer.setFollowChildEnabled(true);
      type8CountContainer.setVAlignment(VRLayout.CENTER);
      type8CountContainer.add(getType8Count(), null);
    }
    return type8CountContainer;
  }

  /**
   * 様式第九・テキストを取得します。
   * @return 様式第九・テキスト
   */
  public ACTextField getType9Count(){
    if(type9Count==null){

      type9Count = new ACTextField();

      getType9CountContainer().setText("様式第九件数");

      type9Count.setBindPath("STYLE_9");

      type9Count.setColumns(3);

      type9Count.setEditable(false);

      addType9Count();
    }
    return type9Count;

  }

  /**
   * 様式第九・テキストコンテナを取得します。
   * @return 様式第九・テキストコンテナ
   */
  protected ACLabelContainer getType9CountContainer(){
    if(type9CountContainer==null){
      type9CountContainer = new ACLabelContainer();
      type9CountContainer.setFollowChildEnabled(true);
      type9CountContainer.setVAlignment(VRLayout.CENTER);
      type9CountContainer.add(getType9Count(), null);
    }
    return type9CountContainer;
  }

  /**
   * 様式第十・テキストを取得します。
   * @return 様式第十・テキスト
   */
  public ACTextField getType10Count(){
    if(type10Count==null){

      type10Count = new ACTextField();

      getType10CountContainer().setText("様式第十件数");

      type10Count.setBindPath("STYLE_10");

      type10Count.setColumns(3);

      type10Count.setEditable(false);

      addType10Count();
    }
    return type10Count;

  }

  /**
   * 様式第十・テキストコンテナを取得します。
   * @return 様式第十・テキストコンテナ
   */
  protected ACLabelContainer getType10CountContainer(){
    if(type10CountContainer==null){
      type10CountContainer = new ACLabelContainer();
      type10CountContainer.setFollowChildEnabled(true);
      type10CountContainer.setVAlignment(VRLayout.CENTER);
      type10CountContainer.add(getType10Count(), null);
    }
    return type10CountContainer;
  }

  /**
   * 訪問看護療養費明細書・テキストを取得します。
   * @return 訪問看護療養費明細書・テキスト
   */
  public ACTextField getVisitCount(){
    if(visitCount==null){

      visitCount = new ACTextField();

      getVisitCountContainer().setText("訪問看護療養費明細書件数");

      visitCount.setColumns(3);

      visitCount.setEditable(false);

      addVisitCount();
    }
    return visitCount;

  }

  /**
   * 訪問看護療養費明細書・テキストコンテナを取得します。
   * @return 訪問看護療養費明細書・テキストコンテナ
   */
  protected ACLabelContainer getVisitCountContainer(){
    if(visitCountContainer==null){
      visitCountContainer = new ACLabelContainer();
      visitCountContainer.setFollowChildEnabled(true);
      visitCountContainer.setVAlignment(VRLayout.CENTER);
      visitCountContainer.add(getVisitCount(), null);
    }
    return visitCountContainer;
  }

  /**
   * 訪問看護療養費請求書(社保請求)・テキストを取得します。
   * @return 訪問看護療養費請求書(社保請求)・テキスト
   */
  public ACTextField getSyahoCount(){
    if(syahoCount==null){

      syahoCount = new ACTextField();

      getSyahoCountContainer().setText("訪問看護療養費請求書(社保請求)件数");

      syahoCount.setColumns(3);

      syahoCount.setEditable(false);

      addSyahoCount();
    }
    return syahoCount;

  }

  /**
   * 訪問看護療養費請求書(社保請求)・テキストコンテナを取得します。
   * @return 訪問看護療養費請求書(社保請求)・テキストコンテナ
   */
  protected ACLabelContainer getSyahoCountContainer(){
    if(syahoCountContainer==null){
      syahoCountContainer = new ACLabelContainer();
      syahoCountContainer.setFollowChildEnabled(true);
      syahoCountContainer.setVAlignment(VRLayout.CENTER);
      syahoCountContainer.add(getSyahoCount(), null);
    }
    return syahoCountContainer;
  }

  /**
   * 訪問看護療養費請求書(国保請求)・テキストを取得します。
   * @return 訪問看護療養費請求書(国保請求)・テキスト
   */
  public ACTextField getKokuhoCount(){
    if(kokuhoCount==null){

      kokuhoCount = new ACTextField();

      getKokuhoCountContainer().setText("訪問看護療養費請求書(国保請求)件数");

      kokuhoCount.setColumns(3);

      kokuhoCount.setEditable(false);

      addKokuhoCount();
    }
    return kokuhoCount;

  }

  /**
   * 訪問看護療養費請求書(国保請求)・テキストコンテナを取得します。
   * @return 訪問看護療養費請求書(国保請求)・テキストコンテナ
   */
  protected ACLabelContainer getKokuhoCountContainer(){
    if(kokuhoCountContainer==null){
      kokuhoCountContainer = new ACLabelContainer();
      kokuhoCountContainer.setFollowChildEnabled(true);
      kokuhoCountContainer.setVAlignment(VRLayout.CENTER);
      kokuhoCountContainer.add(getKokuhoCount(), null);
    }
    return kokuhoCountContainer;
  }

  /**
   * 介護サービス利用請求書・テキストを取得します。
   * @return 介護サービス利用請求書・テキスト
   */
  public ACTextField getServiceCount(){
    if(serviceCount==null){

      serviceCount = new ACTextField();

      getServiceCountContainer().setText("介護サービス利用請求書件数");

      serviceCount.setColumns(3);

      serviceCount.setEditable(false);

      addServiceCount();
    }
    return serviceCount;

  }

  /**
   * 介護サービス利用請求書・テキストコンテナを取得します。
   * @return 介護サービス利用請求書・テキストコンテナ
   */
  protected ACLabelContainer getServiceCountContainer(){
    if(serviceCountContainer==null){
      serviceCountContainer = new ACLabelContainer();
      serviceCountContainer.setFollowChildEnabled(true);
      serviceCountContainer.setVAlignment(VRLayout.CENTER);
      serviceCountContainer.add(getServiceCount(), null);
    }
    return serviceCountContainer;
  }

  /**
   * 請求額・合計単位領域を取得します。
   * @return 請求額・合計単位領域
   */
  public ACPanel getDemandMoneyAndTotalDenominations(){
    if(demandMoneyAndTotalDenominations==null){

      demandMoneyAndTotalDenominations = new ACPanel();

      addDemandMoneyAndTotalDenominations();
    }
    return demandMoneyAndTotalDenominations;

  }

  /**
   * 請求額・合計単位領域・フレームを取得します。
   * @return 請求額・合計単位領域・フレーム
   */
  public ACGroupBox getDemandMoneyAndTotalDenomination(){
    if(demandMoneyAndTotalDenomination==null){

      demandMoneyAndTotalDenomination = new ACGroupBox();

      demandMoneyAndTotalDenomination.setText("合計");

      demandMoneyAndTotalDenomination.setAutoWrap(false);

      demandMoneyAndTotalDenomination.setHgrid(100);

      addDemandMoneyAndTotalDenomination();
    }
    return demandMoneyAndTotalDenomination;

  }

  /**
   * 合計単位数・テキストを取得します。
   * @return 合計単位数・テキスト
   */
  public ACTextField getTotalDenominationText(){
    if(totalDenominationText==null){

      totalDenominationText = new ACTextField();

      getTotalDenominationTextContainer().setText("合計単位数");

      totalDenominationText.setColumns(10);

      totalDenominationText.setHorizontalAlignment(SwingConstants.RIGHT);

      totalDenominationText.setIMEMode(InputSubset.LATIN);

      totalDenominationText.setMaxLength(10);

      totalDenominationText.setEditable(false);

      addTotalDenominationText();
    }
    return totalDenominationText;

  }

  /**
   * 合計単位数・テキストコンテナを取得します。
   * @return 合計単位数・テキストコンテナ
   */
  protected ACLabelContainer getTotalDenominationTextContainer(){
    if(totalDenominationTextContainer==null){
      totalDenominationTextContainer = new ACLabelContainer();
      totalDenominationTextContainer.setFollowChildEnabled(true);
      totalDenominationTextContainer.setVAlignment(VRLayout.CENTER);
      totalDenominationTextContainer.add(getTotalDenominationText(), null);
    }
    return totalDenominationTextContainer;
  }

  /**
   * 合計金額・テキストを取得します。
   * @return 合計金額・テキスト
   */
  public ACTextField getTotalMoneyText(){
    if(totalMoneyText==null){

      totalMoneyText = new ACTextField();

      getTotalMoneyTextContainer().setText("合計金額");

      totalMoneyText.setColumns(10);

      totalMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      totalMoneyText.setIMEMode(InputSubset.LATIN);

      totalMoneyText.setMaxLength(10);

      totalMoneyText.setEditable(false);

      addTotalMoneyText();
    }
    return totalMoneyText;

  }

  /**
   * 合計金額・テキストコンテナを取得します。
   * @return 合計金額・テキストコンテナ
   */
  protected ACLabelContainer getTotalMoneyTextContainer(){
    if(totalMoneyTextContainer==null){
      totalMoneyTextContainer = new ACLabelContainer();
      totalMoneyTextContainer.setFollowChildEnabled(true);
      totalMoneyTextContainer.setVAlignment(VRLayout.CENTER);
      totalMoneyTextContainer.add(getTotalMoneyText(), null);
    }
    return totalMoneyTextContainer;
  }

  /**
   * 保険請求額・テキストを取得します。
   * @return 保険請求額・テキスト
   */
  public ACTextField getDemandMoneyInsuranceMoneyText(){
    if(demandMoneyInsuranceMoneyText==null){

      demandMoneyInsuranceMoneyText = new ACTextField();

      getDemandMoneyInsuranceMoneyTextContainer().setText("保険請求額");

      demandMoneyInsuranceMoneyText.setColumns(10);

      demandMoneyInsuranceMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      demandMoneyInsuranceMoneyText.setIMEMode(InputSubset.LATIN);

      demandMoneyInsuranceMoneyText.setMaxLength(10);

      demandMoneyInsuranceMoneyText.setEditable(false);

      addDemandMoneyInsuranceMoneyText();
    }
    return demandMoneyInsuranceMoneyText;

  }

  /**
   * 保険請求額・テキストコンテナを取得します。
   * @return 保険請求額・テキストコンテナ
   */
  protected ACLabelContainer getDemandMoneyInsuranceMoneyTextContainer(){
    if(demandMoneyInsuranceMoneyTextContainer==null){
      demandMoneyInsuranceMoneyTextContainer = new ACLabelContainer();
      demandMoneyInsuranceMoneyTextContainer.setFollowChildEnabled(true);
      demandMoneyInsuranceMoneyTextContainer.setVAlignment(VRLayout.CENTER);
      demandMoneyInsuranceMoneyTextContainer.add(getDemandMoneyInsuranceMoneyText(), null);
    }
    return demandMoneyInsuranceMoneyTextContainer;
  }

  /**
   * 利用者負担額・テキストを取得します。
   * @return 利用者負担額・テキスト
   */
  public ACTextField getDemandMoneyPatientMoneyText(){
    if(demandMoneyPatientMoneyText==null){

      demandMoneyPatientMoneyText = new ACTextField();

      getDemandMoneyPatientMoneyTextContainer().setText("利用者請求額");

      demandMoneyPatientMoneyText.setColumns(10);

      demandMoneyPatientMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      demandMoneyPatientMoneyText.setIMEMode(InputSubset.LATIN);

      demandMoneyPatientMoneyText.setMaxLength(10);

      demandMoneyPatientMoneyText.setEditable(false);

      addDemandMoneyPatientMoneyText();
    }
    return demandMoneyPatientMoneyText;

  }

  /**
   * 利用者負担額・テキストコンテナを取得します。
   * @return 利用者負担額・テキストコンテナ
   */
  protected ACLabelContainer getDemandMoneyPatientMoneyTextContainer(){
    if(demandMoneyPatientMoneyTextContainer==null){
      demandMoneyPatientMoneyTextContainer = new ACLabelContainer();
      demandMoneyPatientMoneyTextContainer.setFollowChildEnabled(true);
      demandMoneyPatientMoneyTextContainer.setVAlignment(VRLayout.CENTER);
      demandMoneyPatientMoneyTextContainer.add(getDemandMoneyPatientMoneyText(), null);
    }
    return demandMoneyPatientMoneyTextContainer;
  }

  /**
   * 公費請求額・テキストを取得します。
   * @return 公費請求額・テキスト
   */
  public ACTextField getTotalDenominationPublicExpenseMoneyText(){
    if(totalDenominationPublicExpenseMoneyText==null){

      totalDenominationPublicExpenseMoneyText = new ACTextField();

      getTotalDenominationPublicExpenseMoneyTextContainer().setText("公費請求額");

      totalDenominationPublicExpenseMoneyText.setColumns(10);

      totalDenominationPublicExpenseMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      totalDenominationPublicExpenseMoneyText.setIMEMode(InputSubset.LATIN);

      totalDenominationPublicExpenseMoneyText.setMaxLength(10);

      totalDenominationPublicExpenseMoneyText.setEditable(false);

      addTotalDenominationPublicExpenseMoneyText();
    }
    return totalDenominationPublicExpenseMoneyText;

  }

  /**
   * 公費請求額・テキストコンテナを取得します。
   * @return 公費請求額・テキストコンテナ
   */
  protected ACLabelContainer getTotalDenominationPublicExpenseMoneyTextContainer(){
    if(totalDenominationPublicExpenseMoneyTextContainer==null){
      totalDenominationPublicExpenseMoneyTextContainer = new ACLabelContainer();
      totalDenominationPublicExpenseMoneyTextContainer.setFollowChildEnabled(true);
      totalDenominationPublicExpenseMoneyTextContainer.setVAlignment(VRLayout.CENTER);
      totalDenominationPublicExpenseMoneyTextContainer.add(getTotalDenominationPublicExpenseMoneyText(), null);
    }
    return totalDenominationPublicExpenseMoneyTextContainer;
  }

  /**
   * 情報テーブル領域を取得します。
   * @return 情報テーブル領域
   */
  public ACPanel getInfos(){
    if(infos==null){

      infos = new ACPanel();

      addInfos();
    }
    return infos;

  }

  /**
   * 情報テーブルを取得します。
   * @return 情報テーブル
   */
  public ACTable getInfoTable(){
    if(infoTable==null){

      infoTable = new ACTable();

      infoTable.setColumnModel(getInfoTableColumnModel());

      addInfoTable();
    }
    return infoTable;

  }

  /**
   * 情報テーブルカラムモデルを取得します。
   * @return 情報テーブルカラムモデル
   */
  protected VRTableColumnModel getInfoTableColumnModel(){
    if(infoTableColumnModel==null){
      infoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addInfoTableColumnModel();
    }
    return infoTableColumnModel;
  }

  /**
   * Ｎｏを取得します。
   * @return Ｎｏ
   */
  public ACTableColumn getInfoTableColumn1(){
    if(infoTableColumn1==null){

      infoTableColumn1 = new ACTableColumn();

      infoTableColumn1.setHeaderValue("No");

      infoTableColumn1.setColumnName("NO");

      infoTableColumn1.setColumns(3);

      infoTableColumn1.setHorizontalAlignment(SwingConstants.CENTER);

      infoTableColumn1.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      infoTableColumn1.setSortable(false);

      addInfoTableColumn1();
    }
    return infoTableColumn1;

  }

  /**
   * 印刷済みフラグ(列を取得します。
   * @return 印刷済みフラグ(列
   */
  public ACTableColumn getInfoTableColumn2(){
    if(infoTableColumn2==null){

      infoTableColumn2 = new ACTableColumn();

      infoTableColumn2.setHeaderValue("印刷");

      infoTableColumn2.setColumnName("PRINT");

      infoTableColumn2.setColumns(4);

      addInfoTableColumn2();
    }
    return infoTableColumn2;

  }

  /**
   * 選択(列を取得します。
   * @return 選択(列
   */
  public ACTableColumn getInfoTableColumn3(){
    if(infoTableColumn3==null){

      infoTableColumn3 = new ACTableColumn();

      infoTableColumn3.setHeaderValue("選択");

      infoTableColumn3.setColumnName("CHOISE");

      infoTableColumn3.setEditable(true);

      infoTableColumn3.setColumns(4);

      infoTableColumn3.setHorizontalAlignment(SwingConstants.CENTER);

      infoTableColumn3.setRendererType(VRTableCellViewer.RENDERER_TYPE_CHECK_BOX);

      infoTableColumn3.setEditorType(VRTableCellViewer.EDITOR_TYPE_CHECK_BOX);

      infoTableColumn3.setHeaderPopupMenu( new ACCheckBoxTableColumnPopupMenu(getInfoTable(), "CHOISE", new Boolean(true), new Boolean(false)) );

      addInfoTableColumn3();
    }
    return infoTableColumn3;

  }

  /**
   * 削除(列を取得します。
   * @return 削除(列
   */
  public ACTableColumn getInfoTableColumn4(){
    if(infoTableColumn4==null){

      infoTableColumn4 = new ACTableColumn();

      infoTableColumn4.setHeaderValue("削除");

      infoTableColumn4.setColumnName("DELETE");

      infoTableColumn4.setEditable(true);

      infoTableColumn4.setColumns(4);

      infoTableColumn4.setHorizontalAlignment(SwingConstants.CENTER);

      infoTableColumn4.setRendererType(VRTableCellViewer.RENDERER_TYPE_CHECK_BOX);

      infoTableColumn4.setEditorType(VRTableCellViewer.EDITOR_TYPE_CHECK_BOX);

      infoTableColumn4.setHeaderPopupMenu( new ACCheckBoxTableColumnPopupMenu(getInfoTable(), "DELETE", new Boolean(true), new Boolean(false)) );

      addInfoTableColumn4();
    }
    return infoTableColumn4;

  }

  /**
   * 区分(列を取得します。
   * @return 区分(列
   */
  public ACTableColumn getInfoTableColumn23(){
    if(infoTableColumn23==null){

      infoTableColumn23 = new ACTableColumn();

      infoTableColumn23.setHeaderValue("区分");

      infoTableColumn23.setColumnName("KUBUN");

      infoTableColumn23.setEditable(true);

      infoTableColumn23.setColumns(4);

      infoTableColumn23.setEditorType(VRTableCellViewer.EDITOR_TYPE_COMBO_BOX);

      infoTableColumn23.setComponentEditable(false);

      addInfoTableColumn23();
    }
    return infoTableColumn23;

  }

  /**
   * 年月度(列を取得します。
   * @return 年月度(列
   */
  public ACTableColumn getInfoTableColumn5(){
    if(infoTableColumn5==null){

      infoTableColumn5 = new ACTableColumn();

      infoTableColumn5.setHeaderValue("年月度");

      infoTableColumn5.setColumnName("TARGET_DATE");

      infoTableColumn5.setColumns(8);

      infoTableColumn5.setFormat(new ACBorderBlankDateFormat("gggee年MM月"));

      addInfoTableColumn5();
    }
    return infoTableColumn5;

  }

  /**
   * 様式(列を取得します。
   * @return 様式(列
   */
  public ACTableColumn getInfoTableColumn14(){
    if(infoTableColumn14==null){

      infoTableColumn14 = new ACTableColumn();

      infoTableColumn14.setHeaderValue("様式");

      infoTableColumn14.setColumnName("CLAIM_STYLE_TYPE");

      infoTableColumn14.setColumns(8);

      addInfoTableColumn14();
    }
    return infoTableColumn14;

  }

  /**
   * 保険者番号(列を取得します。
   * @return 保険者番号(列
   */
  public ACTableColumn getInfoTableColumn6(){
    if(infoTableColumn6==null){

      infoTableColumn6 = new ACTableColumn();

      infoTableColumn6.setHeaderValue("保険者番号");

      infoTableColumn6.setColumnName("INSURER_ID");

      infoTableColumn6.setColumns(8);

      addInfoTableColumn6();
    }
    return infoTableColumn6;

  }

  /**
   * 保険者名称(列を取得します。
   * @return 保険者名称(列
   */
  public ACTableColumn getInfoTableColumn7(){
    if(infoTableColumn7==null){

      infoTableColumn7 = new ACTableColumn();

      infoTableColumn7.setHeaderValue("保険者名称");

      infoTableColumn7.setColumnName("INSURER_NAME");

      infoTableColumn7.setColumns(10);

      addInfoTableColumn7();
    }
    return infoTableColumn7;

  }

  /**
   * 利用者コード(列を取得します。
   * @return 利用者コード(列
   */
  public ACTableColumn getInfoTableColumn8(){
    if(infoTableColumn8==null){

      infoTableColumn8 = new ACTableColumn();

      infoTableColumn8.setHeaderValue("利用者コード");

      infoTableColumn8.setColumnName("PATIENT_CODE");

      infoTableColumn8.setColumns(10);

      addInfoTableColumn8();
    }
    return infoTableColumn8;

  }

  /**
   * 被保険者番号(列を取得します。
   * @return 被保険者番号(列
   */
  public ACTableColumn getInfoTableColumn9(){
    if(infoTableColumn9==null){

      infoTableColumn9 = new ACTableColumn();

      infoTableColumn9.setHeaderValue("被保険者番号");

      infoTableColumn9.setColumnName("INSURED_ID");

      infoTableColumn9.setColumns(10);

      addInfoTableColumn9();
    }
    return infoTableColumn9;

  }

  /**
   * 利用者氏名(列を取得します。
   * @return 利用者氏名(列
   */
  public ACTableColumn getInfoTableColumn10(){
    if(infoTableColumn10==null){

      infoTableColumn10 = new ACTableColumn();

      infoTableColumn10.setHeaderValue("利用者氏名");

      infoTableColumn10.setColumnName("PATIENT_NAME");

      infoTableColumn10.setColumns(10);

      addInfoTableColumn10();
    }
    return infoTableColumn10;

  }

  /**
   * ふりがな(列を取得します。
   * @return ふりがな(列
   */
  public ACTableColumn getInfoTableColumn11(){
    if(infoTableColumn11==null){

      infoTableColumn11 = new ACTableColumn();

      infoTableColumn11.setHeaderValue("ふりがな");

      infoTableColumn11.setColumnName("PATIENT_KANA");

      infoTableColumn11.setColumns(10);

      addInfoTableColumn11();
    }
    return infoTableColumn11;

  }

  /**
   * 性別(列を取得します。
   * @return 性別(列
   */
  public ACTableColumn getInfoTableColumn12(){
    if(infoTableColumn12==null){

      infoTableColumn12 = new ACTableColumn();

      infoTableColumn12.setHeaderValue("性別");

      infoTableColumn12.setColumnName("PATIENT_SEX");

      infoTableColumn12.setColumns(3);

      infoTableColumn12.setFormat(QkanConstants.FORMAT_SEX);

      addInfoTableColumn12();
    }
    return infoTableColumn12;

  }

  /**
   * 年齢(列を取得します。
   * @return 年齢(列
   */
  public ACTableColumn getInfoTableColumn13(){
    if(infoTableColumn13==null){

      infoTableColumn13 = new ACTableColumn();

      infoTableColumn13.setHeaderValue("年齢");

      infoTableColumn13.setColumnName("PATIENT_BIRTHDAY");

      infoTableColumn13.setColumns(4);

      infoTableColumn13.setFormat(QkanConstants.FORMAT_NOW_AGE);

      addInfoTableColumn13();
    }
    return infoTableColumn13;

  }

  /**
   * 要介護度(列を取得します。
   * @return 要介護度(列
   */
  public ACTableColumn getInfoTableColumn15(){
    if(infoTableColumn15==null){

      infoTableColumn15 = new ACTableColumn();

      infoTableColumn15.setHeaderValue("要介護度");

      infoTableColumn15.setColumnName("JOTAI_CODE");

      infoTableColumn15.setColumns(5);

      addInfoTableColumn15();
    }
    return infoTableColumn15;

  }

  /**
   * 保険区分(列を取得します。
   * @return 保険区分(列
   */
  public ACTableColumn getInfoTableColumn16(){
    if(infoTableColumn16==null){

      infoTableColumn16 = new ACTableColumn();

      infoTableColumn16.setHeaderValue("保険区分");

      infoTableColumn16.setColumnName("INSURE_TYPE");

      infoTableColumn16.setColumns(5);

      addInfoTableColumn16();
    }
    return infoTableColumn16;

  }

  /**
   * 計画単位(列を取得します。
   * @return 計画単位(列
   */
  public ACTableColumn getInfoTableColumn17(){
    if(infoTableColumn17==null){

      infoTableColumn17 = new ACTableColumn();

      infoTableColumn17.setHeaderValue("計画単位");

      infoTableColumn17.setColumnName("PLAN_RATE");

      infoTableColumn17.setColumns(6);

      infoTableColumn17.setHorizontalAlignment(SwingConstants.RIGHT);

      addInfoTableColumn17();
    }
    return infoTableColumn17;

  }

  /**
   * サービス単位(列を取得します。
   * @return サービス単位(列
   */
  public ACTableColumn getInfoTableColumn18(){
    if(infoTableColumn18==null){

      infoTableColumn18 = new ACTableColumn();

      infoTableColumn18.setHeaderValue("サービス単位");

      infoTableColumn18.setColumnName("SERVICE_UNIT");

      infoTableColumn18.setColumns(8);

      infoTableColumn18.setHorizontalAlignment(SwingConstants.RIGHT);

      addInfoTableColumn18();
    }
    return infoTableColumn18;

  }

  /**
   * サービス合計金額(列を取得します。
   * @return サービス合計金額(列
   */
  public ACTableColumn getInfoTableColumn19(){
    if(infoTableColumn19==null){

      infoTableColumn19 = new ACTableColumn();

      infoTableColumn19.setHeaderValue("サービス合計金額");

      infoTableColumn19.setColumnName("SERVICE_TOTAL");

      infoTableColumn19.setColumns(9);

      infoTableColumn19.setHorizontalAlignment(SwingConstants.RIGHT);

      addInfoTableColumn19();
    }
    return infoTableColumn19;

  }

  /**
   * 保険請求額(列を取得します。
   * @return 保険請求額(列
   */
  public ACTableColumn getInfoTableColumn20(){
    if(infoTableColumn20==null){

      infoTableColumn20 = new ACTableColumn();

      infoTableColumn20.setHeaderValue("保険請求額");

      infoTableColumn20.setColumnName("HOKEN");

      infoTableColumn20.setColumns(6);

      infoTableColumn20.setHorizontalAlignment(SwingConstants.RIGHT);

      addInfoTableColumn20();
    }
    return infoTableColumn20;

  }

  /**
   * 公費負担額(列を取得します。
   * @return 公費負担額(列
   */
  public ACTableColumn getInfoTableColumn21(){
    if(infoTableColumn21==null){

      infoTableColumn21 = new ACTableColumn();

      infoTableColumn21.setHeaderValue("公費負担額");

      infoTableColumn21.setColumnName("KOUHI");

      infoTableColumn21.setColumns(6);

      infoTableColumn21.setHorizontalAlignment(SwingConstants.RIGHT);

      addInfoTableColumn21();
    }
    return infoTableColumn21;

  }

  /**
   * 利用者負担額(列を取得します。
   * @return 利用者負担額(列
   */
  public ACTableColumn getInfoTableColumn22(){
    if(infoTableColumn22==null){

      infoTableColumn22 = new ACTableColumn();

      infoTableColumn22.setHeaderValue("利用者負担額");

      infoTableColumn22.setColumnName("RIYOUSYA");

      infoTableColumn22.setColumns(8);

      infoTableColumn22.setHorizontalAlignment(SwingConstants.RIGHT);

      addInfoTableColumn22();
    }
    return infoTableColumn22;

  }

  /**
   * コンストラクタです。
   */
  public QP001Design() {

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

    buttons.add(getCommit(), VRLayout.EAST);
    buttons.add(getCsvOut(), VRLayout.EAST);
    buttons.add(getPrint(), VRLayout.EAST);
    buttons.add(getPrintList(), VRLayout.EAST);
    buttons.add(getDelete(), VRLayout.EAST);
    buttons.add(getFind(), VRLayout.EAST);
    buttons.add(getEntry(), VRLayout.EAST);
  }

  /**
   * 詳細に内部項目を追加します。
   */
  protected void addEntry(){

  }

  /**
   * 検索ボタンに内部項目を追加します。
   */
  protected void addFind(){

  }

  /**
   * 削除ボタンに内部項目を追加します。
   */
  protected void addDelete(){

  }

  /**
   * 一覧印刷に内部項目を追加します。
   */
  protected void addPrintList(){

  }

  /**
   * 印刷ボタンに内部項目を追加します。
   */
  protected void addPrint(){

  }

  /**
   * CSV出力ボタンに内部項目を追加します。
   */
  protected void addCsvOut(){

  }

  /**
   * 実績確定に内部項目を追加します。
   */
  protected void addCommit(){

  }

  /**
   * 情報領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getExtractConditions(), VRLayout.NORTH);

    contents.add(getUpdateConditions(), VRLayout.NORTH);

    contents.add(getPrintConditions(), VRLayout.NORTH);

    contents.add(getTypeCountInfomations(), VRLayout.NORTH);

    contents.add(getDemandMoneyAndTotalDenominations(), VRLayout.NORTH);

    contents.add(getInfos(), VRLayout.CLIENT);

  }

  /**
   * 抽出条件領域に内部項目を追加します。
   */
  protected void addExtractConditions(){

    extractConditions.add(getLoginProviderInfo(), VRLayout.NORTH);

    extractConditions.add(getExtractCondition(), VRLayout.NORTH);

  }

  /**
   * ログイン事業所に内部項目を追加します。
   */
  protected void addLoginProviderInfo(){

  }

  /**
   * 抽出条件領域・フレームに内部項目を追加します。
   */
  protected void addExtractCondition(){

    extractCondition.add(getTargetDateContena(), VRLayout.FLOW);

    extractCondition.add(getClaimDateContainer(), VRLayout.FLOW);

    extractCondition.add(getNotOutputDistinction(), VRLayout.FLOW_RETURN);

    extractCondition.add(getInsurerContena(), VRLayout.FLOW_INSETLINE_RETURN);

    extractCondition.add(getPatientCodeTextContainer(), VRLayout.FLOW_INSETLINE);

    extractCondition.add(getPatientFuriganaTextContainer(), VRLayout.FLOW_INSETLINE);

    extractCondition.add(getInsuredNoTextContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 対象年月・コンテナに内部項目を追加します。
   */
  protected void addTargetDateContena(){

    targetDateContena.add(getTargetDate(), null);

    targetDateContena.add(getTargetDateLabel4(), VRLayout.FLOW);

  }

  /**
   * 対象年月に内部項目を追加します。
   */
  protected void addTargetDate(){

  }

  /**
   * 対象年月・ラベル(度に内部項目を追加します。
   */
  protected void addTargetDateLabel4(){

  }

  /**
   * 請求年月・テキストに内部項目を追加します。
   */
  protected void addClaimDate(){

  }

  /**
   * 未出力判別チェックボックスに内部項目を追加します。
   */
  protected void addNotOutputDistinction(){

  }

  /**
   * 保険者番号・コンテナに内部項目を追加します。
   */
  protected void addInsurerContena(){

    insurerContena.add(getInsurerNoText(), VRLayout.FLOW);

    insurerContena.add(getInsurerNoConbo(), VRLayout.FLOW);

  }

  /**
   * 保険者番号・テキストに内部項目を追加します。
   */
  protected void addInsurerNoText(){

  }

  /**
   * 保険者番号・コンボに内部項目を追加します。
   */
  protected void addInsurerNoConbo(){

  }

  /**
   * 保険者番号・コンボモデルに内部項目を追加します。
   */
  protected void addInsurerNoConboModel(){

  }

  /**
   * 利用者コード・テキストに内部項目を追加します。
   */
  protected void addPatientCodeText(){

  }

  /**
   * 利用者ふりがな・テキストに内部項目を追加します。
   */
  protected void addPatientFuriganaText(){

  }

  /**
   * 被保険者番号・テキストに内部項目を追加します。
   */
  protected void addInsuredNoText(){

  }

  /**
   * 登録条件領域に内部項目を追加します。
   */
  protected void addUpdateConditions(){

    updateConditions.add(getUpdateCondition(), VRLayout.NORTH);

  }

  /**
   * 登録条件領域・フレームに内部項目を追加します。
   */
  protected void addUpdateCondition(){

    updateCondition.add(getClaimDateUpdateContainer(), VRLayout.FLOW);

    updateCondition.add(getClaimDateUpdateChangePermit(), VRLayout.FLOW);

  }

  /**
   * 請求年月・テキスト(登録用)に内部項目を追加します。
   */
  protected void addClaimDateUpdate(){

  }

  /**
   * 請求年月変更許可チェックボックスに内部項目を追加します。
   */
  protected void addClaimDateUpdateChangePermit(){

  }

  /**
   * 印刷条件領域に内部項目を追加します。
   */
  protected void addPrintConditions(){

    printConditions.add(getPrintCondition(), VRLayout.NORTH);

  }

  /**
   * 印刷条件領域・フレームに内部項目を追加します。
   */
  protected void addPrintCondition(){

    printCondition.add(getClaimDatePrintContainer(), VRLayout.FLOW);

  }

  /**
   * 請求書日付に内部項目を追加します。
   */
  protected void addClaimDatePrint(){

  }

  /**
   * 様式枚数情報領域に内部項目を追加します。
   */
  protected void addTypeCountInfomations(){

    typeCountInfomations.add(getTypeCountInfomation(), VRLayout.NORTH);

  }

  /**
   * 様式枚数情報領域・フレームに内部項目を追加します。
   */
  protected void addTypeCountInfomation(){

    typeCountInfomation.add(getSupplyCountContainer(), VRLayout.FLOW_INSETLINE);

    typeCountInfomation.add(getNursingCountContainer(), VRLayout.FLOW_INSETLINE);

    typeCountInfomation.add(getType7CountContainer(), VRLayout.FLOW_INSETLINE);

    typeCountInfomation.add(getType2CountContainer(), VRLayout.FLOW_INSETLINE);

    typeCountInfomation.add(getType3CountContainer(), VRLayout.FLOW_INSETLINE);

    typeCountInfomation.add(getType4CountContainer(), VRLayout.FLOW_INSETLINE);

    typeCountInfomation.add(getType5CountContainer(), VRLayout.FLOW_INSETLINE);

    typeCountInfomation.add(getType6CountContainer(), VRLayout.FLOW_INSETLINE);

    typeCountInfomation.add(getType8CountContainer(), VRLayout.FLOW_INSETLINE);

    typeCountInfomation.add(getType9CountContainer(), VRLayout.FLOW_INSETLINE);

    typeCountInfomation.add(getType10CountContainer(), VRLayout.FLOW_INSETLINE);

    typeCountInfomation.add(getVisitCountContainer(), VRLayout.FLOW_INSETLINE);

    typeCountInfomation.add(getSyahoCountContainer(), VRLayout.FLOW_INSETLINE);

    typeCountInfomation.add(getKokuhoCountContainer(), VRLayout.FLOW_INSETLINE);

    typeCountInfomation.add(getServiceCountContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 給付管理票・テキストに内部項目を追加します。
   */
  protected void addSupplyCount(){

  }

  /**
   * 介護給付費請求書・テキストに内部項目を追加します。
   */
  protected void addNursingCount(){

  }

  /**
   * 様式第七・テキストに内部項目を追加します。
   */
  protected void addType7Count(){

  }

  /**
   * 様式第二・テキストに内部項目を追加します。
   */
  protected void addType2Count(){

  }

  /**
   * 様式第三・テキストに内部項目を追加します。
   */
  protected void addType3Count(){

  }

  /**
   * 様式第四・テキストに内部項目を追加します。
   */
  protected void addType4Count(){

  }

  /**
   * 様式第五・テキストに内部項目を追加します。
   */
  protected void addType5Count(){

  }

  /**
   * 様式第六・テキストに内部項目を追加します。
   */
  protected void addType6Count(){

  }

  /**
   * 様式第八・テキストに内部項目を追加します。
   */
  protected void addType8Count(){

  }

  /**
   * 様式第九・テキストに内部項目を追加します。
   */
  protected void addType9Count(){

  }

  /**
   * 様式第十・テキストに内部項目を追加します。
   */
  protected void addType10Count(){

  }

  /**
   * 訪問看護療養費明細書・テキストに内部項目を追加します。
   */
  protected void addVisitCount(){

  }

  /**
   * 訪問看護療養費請求書(社保請求)・テキストに内部項目を追加します。
   */
  protected void addSyahoCount(){

  }

  /**
   * 訪問看護療養費請求書(国保請求)・テキストに内部項目を追加します。
   */
  protected void addKokuhoCount(){

  }

  /**
   * 介護サービス利用請求書・テキストに内部項目を追加します。
   */
  protected void addServiceCount(){

  }

  /**
   * 請求額・合計単位領域に内部項目を追加します。
   */
  protected void addDemandMoneyAndTotalDenominations(){

    demandMoneyAndTotalDenominations.add(getDemandMoneyAndTotalDenomination(), VRLayout.NORTH);

  }

  /**
   * 請求額・合計単位領域・フレームに内部項目を追加します。
   */
  protected void addDemandMoneyAndTotalDenomination(){

    demandMoneyAndTotalDenomination.add(getTotalDenominationTextContainer(), VRLayout.FLOW_INSETLINE);

    demandMoneyAndTotalDenomination.add(getTotalMoneyTextContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    demandMoneyAndTotalDenomination.add(getDemandMoneyInsuranceMoneyTextContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    demandMoneyAndTotalDenomination.add(getDemandMoneyPatientMoneyTextContainer(), VRLayout.FLOW_INSETLINE);

    demandMoneyAndTotalDenomination.add(getTotalDenominationPublicExpenseMoneyTextContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 合計単位数・テキストに内部項目を追加します。
   */
  protected void addTotalDenominationText(){

  }

  /**
   * 合計金額・テキストに内部項目を追加します。
   */
  protected void addTotalMoneyText(){

  }

  /**
   * 保険請求額・テキストに内部項目を追加します。
   */
  protected void addDemandMoneyInsuranceMoneyText(){

  }

  /**
   * 利用者負担額・テキストに内部項目を追加します。
   */
  protected void addDemandMoneyPatientMoneyText(){

  }

  /**
   * 公費請求額・テキストに内部項目を追加します。
   */
  protected void addTotalDenominationPublicExpenseMoneyText(){

  }

  /**
   * 情報テーブル領域に内部項目を追加します。
   */
  protected void addInfos(){

    infos.add(getInfoTable(), VRLayout.CLIENT);

  }

  /**
   * 情報テーブルに内部項目を追加します。
   */
  protected void addInfoTable(){

  }

  /**
   * 情報テーブルカラムモデルに内部項目を追加します。
   */
  protected void addInfoTableColumnModel(){

    getInfoTableColumnModel().addColumn(getInfoTableColumn1());

    getInfoTableColumnModel().addColumn(getInfoTableColumn2());

    getInfoTableColumnModel().addColumn(getInfoTableColumn3());

    getInfoTableColumnModel().addColumn(getInfoTableColumn4());

    getInfoTableColumnModel().addColumn(getInfoTableColumn23());

    getInfoTableColumnModel().addColumn(getInfoTableColumn5());

    getInfoTableColumnModel().addColumn(getInfoTableColumn14());

    getInfoTableColumnModel().addColumn(getInfoTableColumn6());

    getInfoTableColumnModel().addColumn(getInfoTableColumn7());

    getInfoTableColumnModel().addColumn(getInfoTableColumn8());

    getInfoTableColumnModel().addColumn(getInfoTableColumn9());

    getInfoTableColumnModel().addColumn(getInfoTableColumn10());

    getInfoTableColumnModel().addColumn(getInfoTableColumn11());

    getInfoTableColumnModel().addColumn(getInfoTableColumn12());

    getInfoTableColumnModel().addColumn(getInfoTableColumn13());

    getInfoTableColumnModel().addColumn(getInfoTableColumn15());

    getInfoTableColumnModel().addColumn(getInfoTableColumn16());

    getInfoTableColumnModel().addColumn(getInfoTableColumn17());

    getInfoTableColumnModel().addColumn(getInfoTableColumn18());

    getInfoTableColumnModel().addColumn(getInfoTableColumn19());

    getInfoTableColumnModel().addColumn(getInfoTableColumn20());

    getInfoTableColumnModel().addColumn(getInfoTableColumn21());

    getInfoTableColumnModel().addColumn(getInfoTableColumn22());

  }

  /**
   * Ｎｏに内部項目を追加します。
   */
  protected void addInfoTableColumn1(){

  }

  /**
   * 印刷済みフラグ(列に内部項目を追加します。
   */
  protected void addInfoTableColumn2(){

  }

  /**
   * 選択(列に内部項目を追加します。
   */
  protected void addInfoTableColumn3(){

  }

  /**
   * 削除(列に内部項目を追加します。
   */
  protected void addInfoTableColumn4(){

  }

  /**
   * 区分(列に内部項目を追加します。
   */
  protected void addInfoTableColumn23(){

  }

  /**
   * 年月度(列に内部項目を追加します。
   */
  protected void addInfoTableColumn5(){

  }

  /**
   * 様式(列に内部項目を追加します。
   */
  protected void addInfoTableColumn14(){

  }

  /**
   * 保険者番号(列に内部項目を追加します。
   */
  protected void addInfoTableColumn6(){

  }

  /**
   * 保険者名称(列に内部項目を追加します。
   */
  protected void addInfoTableColumn7(){

  }

  /**
   * 利用者コード(列に内部項目を追加します。
   */
  protected void addInfoTableColumn8(){

  }

  /**
   * 被保険者番号(列に内部項目を追加します。
   */
  protected void addInfoTableColumn9(){

  }

  /**
   * 利用者氏名(列に内部項目を追加します。
   */
  protected void addInfoTableColumn10(){

  }

  /**
   * ふりがな(列に内部項目を追加します。
   */
  protected void addInfoTableColumn11(){

  }

  /**
   * 性別(列に内部項目を追加します。
   */
  protected void addInfoTableColumn12(){

  }

  /**
   * 年齢(列に内部項目を追加します。
   */
  protected void addInfoTableColumn13(){

  }

  /**
   * 要介護度(列に内部項目を追加します。
   */
  protected void addInfoTableColumn15(){

  }

  /**
   * 保険区分(列に内部項目を追加します。
   */
  protected void addInfoTableColumn16(){

  }

  /**
   * 計画単位(列に内部項目を追加します。
   */
  protected void addInfoTableColumn17(){

  }

  /**
   * サービス単位(列に内部項目を追加します。
   */
  protected void addInfoTableColumn18(){

  }

  /**
   * サービス合計金額(列に内部項目を追加します。
   */
  protected void addInfoTableColumn19(){

  }

  /**
   * 保険請求額(列に内部項目を追加します。
   */
  protected void addInfoTableColumn20(){

  }

  /**
   * 公費負担額(列に内部項目を追加します。
   */
  protected void addInfoTableColumn21(){

  }

  /**
   * 利用者負担額(列に内部項目を追加します。
   */
  protected void addInfoTableColumn22(){

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
      ACFrame.debugStart(new ACAffairInfo(QP001Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QP001Design getThis() {
    return this;
  }
}
