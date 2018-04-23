
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
 * 作成日: 2018/03/14  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス システム設定 (005)
 * プログラム 設定変更・メンテナンス (QO005)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo005;
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
 * 設定変更・メンテナンス画面項目デザイン(QO005) 
 */
public class QO005Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton update;

  private ACPanel contents;

  private ACGroupBox dbs;

  private ACPanel serverSelects;

  private ACClearableRadioButtonGroup serverSelectRadios;

  private ACLabelContainer serverSelectRadiosContainer;

  private ACListModelAdapter serverSelectRadiosModel;

  private ACRadioButtonItem serverSelectRadioItem1;

  private ACRadioButtonItem serverSelectRadioItem2;

  private ACTextField serverSelectIpText;

  private ACLabelContainer serverSelectIpTextContainer;

  private ACPanel dbFileSelects;

  private ACTextField dbFileSelectFileName;

  private ACLabelContainer dbFileSelectFileNameContainer;

  private ACButton dbFileSelectFileCompareButton;

  private ACPanel dbComment;

  private ACLabel comment1;

  private ACLabel dbSettingComments;

  private ACGroupBox pdfFileSelects;

  private ACTextField pdfFileSelectFileName;

  private ACLabelContainer pdfFileSelectFileNameContainer;

  private ACButton pdfFileSelectFileCompareButton;

  private ACPanel pdfComment;

  private ACLabel comment2;

  private ACPanel affairSettings;

  private ACGroupBox chohyos;

  private ACIntegerCheckBox yoshikiBango;

  private ACGroupBox riyohyos;

  private ACIntegerCheckBox printHomeMedicalAdvice;

  private ACIntegerCheckBox ninchishoTokuteiShisetsu;

  private ACIntegerCheckBox shisetsuService;

  private ACIntegerCheckBox printSyoguKaizen;

  private ACIntegerCheckBox printSpecialArea;

  private ACIntegerCheckBox printChusankanArea;

  private ACIntegerCheckBox printSameBuilding;

  private ACIntegerCheckBox privateExpenses;

  private ACIntegerCheckBox printNursingZero;

  private ACIntegerCheckBox printNursingLimitZero;

  private ACGroupBox others;

  private ACIntegerCheckBox oncePerMonth;

  private ACLabelContainer taxContainer;

  private ACTextField tax;

  private ACLabel taxUnit;

  private ACButton taxChange;

  private ACIntegerCheckBox showOldLowProviderElements;

  private ACIntegerCheckBox kaigoHoken;

  private ACGroupBox backupResotres;

  private ACButton backup;

  private ACButton restore;

  //getter

  /**
   * ボタンバーを取得します。
   * @return ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("設定変更・メンテナンス");

      addButtons();
    }
    return buttons;

  }

  /**
   * 更新ボタンを取得します。
   * @return 更新ボタン
   */
  public ACAffairButton getUpdate(){
    if(update==null){

      update = new ACAffairButton();

      update.setText("更新(S)");

      update.setToolTipText("現在の設定内容を保存します。");

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

      contents.setAutoWrap(false);

      addContents();
    }
    return contents;

  }

  /**
   * DB設定領域を取得します。
   * @return DB設定領域
   */
  public ACGroupBox getDbs(){
    if(dbs==null){

      dbs = new ACGroupBox();

      dbs.setText("データベースの設定");

      addDbs();
    }
    return dbs;

  }

  /**
   * サーバー選択領域を取得します。
   * @return サーバー選択領域
   */
  public ACPanel getServerSelects(){
    if(serverSelects==null){

      serverSelects = new ACPanel();

      serverSelects.setAutoWrap(false);

      addServerSelects();
    }
    return serverSelects;

  }

  /**
   * サーバー選択・ラジオグループを取得します。
   * @return サーバー選択・ラジオグループ
   */
  public ACClearableRadioButtonGroup getServerSelectRadios(){
    if(serverSelectRadios==null){

      serverSelectRadios = new ACClearableRadioButtonGroup();

      getServerSelectRadiosContainer().setText("サーバー");

      serverSelectRadios.setBindPath("SERVER_SELECT_RADIOS");

      serverSelectRadios.setUseClearButton(false);

      serverSelectRadios.setModel(getServerSelectRadiosModel());

      addServerSelectRadios();
    }
    return serverSelectRadios;

  }

  /**
   * サーバー選択・ラジオグループコンテナを取得します。
   * @return サーバー選択・ラジオグループコンテナ
   */
  protected ACLabelContainer getServerSelectRadiosContainer(){
    if(serverSelectRadiosContainer==null){
      serverSelectRadiosContainer = new ACLabelContainer();
      serverSelectRadiosContainer.setFollowChildEnabled(true);
      serverSelectRadiosContainer.setVAlignment(VRLayout.CENTER);
      serverSelectRadiosContainer.add(getServerSelectRadios(), null);
    }
    return serverSelectRadiosContainer;
  }

  /**
   * サーバー選択・ラジオグループモデルを取得します。
   * @return サーバー選択・ラジオグループモデル
   */
  protected ACListModelAdapter getServerSelectRadiosModel(){
    if(serverSelectRadiosModel==null){
      serverSelectRadiosModel = new ACListModelAdapter();
      addServerSelectRadiosModel();
    }
    return serverSelectRadiosModel;
  }

  /**
   * サーバー選択・ラジオ(ローカル)を取得します。
   * @return サーバー選択・ラジオ(ローカル)
   */
  public ACRadioButtonItem getServerSelectRadioItem1(){
    if(serverSelectRadioItem1==null){

      serverSelectRadioItem1 = new ACRadioButtonItem();

      serverSelectRadioItem1.setText("ローカル");

      serverSelectRadioItem1.setGroup(getServerSelectRadios());

      serverSelectRadioItem1.setConstraints(VRLayout.FLOW);

      addServerSelectRadioItem1();
    }
    return serverSelectRadioItem1;

  }

  /**
   * サーバー選択・ラジオ(他のコンピューター)を取得します。
   * @return サーバー選択・ラジオ(他のコンピューター)
   */
  public ACRadioButtonItem getServerSelectRadioItem2(){
    if(serverSelectRadioItem2==null){

      serverSelectRadioItem2 = new ACRadioButtonItem();

      serverSelectRadioItem2.setText("他のコンピューター");

      serverSelectRadioItem2.setGroup(getServerSelectRadios());

      serverSelectRadioItem2.setConstraints(VRLayout.FLOW);

      addServerSelectRadioItem2();
    }
    return serverSelectRadioItem2;

  }

  /**
   * IP領域を取得します。
   * @return IP領域
   */
  public ACTextField getServerSelectIpText(){
    if(serverSelectIpText==null){

      serverSelectIpText = new ACTextField();

      getServerSelectIpTextContainer().setText("IP");

      serverSelectIpText.setBindPath("SERVER_SELECT_IP_TEXT");

      serverSelectIpText.setColumns(20);

      serverSelectIpText.setCharType(ACConstants.CHAR_TYPE_IP_OR_HOSTNAME);

      serverSelectIpText.setIMEMode(InputSubset.LATIN);

      serverSelectIpText.setMaxLength(30);

      addServerSelectIpText();
    }
    return serverSelectIpText;

  }

  /**
   * IP領域コンテナを取得します。
   * @return IP領域コンテナ
   */
  protected ACLabelContainer getServerSelectIpTextContainer(){
    if(serverSelectIpTextContainer==null){
      serverSelectIpTextContainer = new ACLabelContainer();
      serverSelectIpTextContainer.setFollowChildEnabled(true);
      serverSelectIpTextContainer.setVAlignment(VRLayout.CENTER);
      serverSelectIpTextContainer.add(getServerSelectIpText(), null);
    }
    return serverSelectIpTextContainer;
  }

  /**
   * ファイル選択領域を取得します。
   * @return ファイル選択領域
   */
  public ACPanel getDbFileSelects(){
    if(dbFileSelects==null){

      dbFileSelects = new ACPanel();

      addDbFileSelects();
    }
    return dbFileSelects;

  }

  /**
   * ファイル名入力領域を取得します。
   * @return ファイル名入力領域
   */
  public ACTextField getDbFileSelectFileName(){
    if(dbFileSelectFileName==null){

      dbFileSelectFileName = new ACTextField();

      getDbFileSelectFileNameContainer().setText("データベースの場所");

      dbFileSelectFileName.setBindPath("DB_FILE_SELECT_FILE_NAME");

      dbFileSelectFileName.setColumns(37);

      dbFileSelectFileName.setIMEMode(InputSubset.LATIN);

      dbFileSelectFileName.setMaxLength(320);

      addDbFileSelectFileName();
    }
    return dbFileSelectFileName;

  }

  /**
   * ファイル名入力領域コンテナを取得します。
   * @return ファイル名入力領域コンテナ
   */
  protected ACLabelContainer getDbFileSelectFileNameContainer(){
    if(dbFileSelectFileNameContainer==null){
      dbFileSelectFileNameContainer = new ACLabelContainer();
      dbFileSelectFileNameContainer.setFollowChildEnabled(true);
      dbFileSelectFileNameContainer.setVAlignment(VRLayout.CENTER);
      dbFileSelectFileNameContainer.add(getDbFileSelectFileName(), null);
    }
    return dbFileSelectFileNameContainer;
  }

  /**
   * ファイル参照ボタンを取得します。
   * @return ファイル参照ボタン
   */
  public ACButton getDbFileSelectFileCompareButton(){
    if(dbFileSelectFileCompareButton==null){

      dbFileSelectFileCompareButton = new ACButton();

      dbFileSelectFileCompareButton.setText("参照(L)");

      dbFileSelectFileCompareButton.setToolTipText("FDBファイル選択画面を表示します。");

      dbFileSelectFileCompareButton.setMnemonic('L');

      addDbFileSelectFileCompareButton();
    }
    return dbFileSelectFileCompareButton;

  }

  /**
   * コメント領域1を取得します。
   * @return コメント領域1
   */
  public ACPanel getDbComment(){
    if(dbComment==null){

      dbComment = new ACPanel();

      addDbComment();
    }
    return dbComment;

  }

  /**
   * コメント1を取得します。
   * @return コメント1
   */
  public ACLabel getComment1(){
    if(comment1==null){

      comment1 = new ACLabel();

      comment1.setText("データベースの場所の設定にあたっては、以下の点に留意ください。");

      comment1.setForeground(Color.blue);

      comment1.setAutoWrap(true);

      addComment1();
    }
    return comment1;

  }

  /**
   * DB設定コメントを取得します。
   * @return DB設定コメント
   */
  public ACLabel getDbSettingComments(){
    if(dbSettingComments==null){

      dbSettingComments = new ACLabel();

      dbSettingComments.setText("・他のコンピューターを選択した場合は、接続先のコンピューターにFirebirdをインストールする必要があります。" + ACConstants.LINE_SEPARATOR + "　※NAS/SAN等の外部ストレージは利用できません。" + ACConstants.LINE_SEPARATOR + "・他のコンピューターを選択した場合は、他のコンピューターでのデータベースのファイルパスを手入力してください。" + ACConstants.LINE_SEPARATOR + "・他のコンピューターを選択した場合は、データの退避と復元を実行する事はできません。" + ACConstants.LINE_SEPARATOR + "　※他のコンピューター上で給管鳥を起動し、データの退避と復元を実行してください。" + ACConstants.LINE_SEPARATOR + "・データベースの場所に日本語を含める事はできません。使用するデータベースは、日本語を含まない場所に移動してください。" + ACConstants.LINE_SEPARATOR + "　例 ○： C:\\qkan\\Data\\QKAN.FDB" + ACConstants.LINE_SEPARATOR + "　例 ×： C:\\給管鳥\\Data\\QKAN.FDB");

      dbSettingComments.setForeground(Color.blue);

      dbSettingComments.setAutoWrap(true);

      addDbSettingComments();
    }
    return dbSettingComments;

  }

  /**
   * PDF設定領域を取得します。
   * @return PDF設定領域
   */
  public ACGroupBox getPdfFileSelects(){
    if(pdfFileSelects==null){

      pdfFileSelects = new ACGroupBox();

      pdfFileSelects.setText("PDFの設定");

      addPdfFileSelects();
    }
    return pdfFileSelects;

  }

  /**
   * PDFファイル名入力領域を取得します。
   * @return PDFファイル名入力領域
   */
  public ACTextField getPdfFileSelectFileName(){
    if(pdfFileSelectFileName==null){

      pdfFileSelectFileName = new ACTextField();

      getPdfFileSelectFileNameContainer().setText("ファイル名");

      pdfFileSelectFileName.setBindPath("PDF_FILE_SELECT_FILE_NAME");

      pdfFileSelectFileName.setColumns(37);

      pdfFileSelectFileName.setIMEMode(InputSubset.LATIN);

      pdfFileSelectFileName.setMaxLength(320);

      addPdfFileSelectFileName();
    }
    return pdfFileSelectFileName;

  }

  /**
   * PDFファイル名入力領域コンテナを取得します。
   * @return PDFファイル名入力領域コンテナ
   */
  protected ACLabelContainer getPdfFileSelectFileNameContainer(){
    if(pdfFileSelectFileNameContainer==null){
      pdfFileSelectFileNameContainer = new ACLabelContainer();
      pdfFileSelectFileNameContainer.setFollowChildEnabled(true);
      pdfFileSelectFileNameContainer.setVAlignment(VRLayout.CENTER);
      pdfFileSelectFileNameContainer.add(getPdfFileSelectFileName(), null);
    }
    return pdfFileSelectFileNameContainer;
  }

  /**
   * PDFファイル参照ボタンを取得します。
   * @return PDFファイル参照ボタン
   */
  public ACButton getPdfFileSelectFileCompareButton(){
    if(pdfFileSelectFileCompareButton==null){

      pdfFileSelectFileCompareButton = new ACButton();

      pdfFileSelectFileCompareButton.setText("参照（P)");

      pdfFileSelectFileCompareButton.setToolTipText("AcrobatReader選択画面を表示します。");

      pdfFileSelectFileCompareButton.setMnemonic('P');

      addPdfFileSelectFileCompareButton();
    }
    return pdfFileSelectFileCompareButton;

  }

  /**
   * コメント領域4を取得します。
   * @return コメント領域4
   */
  public ACPanel getPdfComment(){
    if(pdfComment==null){

      pdfComment = new ACPanel();

      addPdfComment();
    }
    return pdfComment;

  }

  /**
   * コメント4を取得します。
   * @return コメント4
   */
  public ACLabel getComment2(){
    if(comment2==null){

      comment2 = new ACLabel();

      comment2.setText("ファイル名には、印刷に用いるPDFファイルビュアー(Adobe Reader /Adobe Acrobat Reader ）等の場所を入力してください。" + ACConstants.LINE_SEPARATOR + "Adobe Reader 10の場合、標準では C:\\Program Files\\Adobe\\Reader 10.0\\Reader\\AcroRd32.exe となります。");

      comment2.setForeground(Color.blue);

      comment2.setAutoWrap(true);

      addComment2();
    }
    return comment2;

  }

  /**
   * 仕様設定を取得します。
   * @return 仕様設定
   */
  public ACPanel getAffairSettings(){
    if(affairSettings==null){

      affairSettings = new ACPanel();

      addAffairSettings();
    }
    return affairSettings;

  }

  /**
   * 帳票設定領域を取得します。
   * @return 帳票設定領域
   */
  public ACGroupBox getChohyos(){
    if(chohyos==null){

      chohyos = new ACGroupBox();

      chohyos.setText("帳票");

      addChohyos();
    }
    return chohyos;

  }

  /**
   * 様式番号印刷を取得します。
   * @return 様式番号印刷
   */
  public ACIntegerCheckBox getYoshikiBango(){
    if(yoshikiBango==null){

      yoshikiBango = new ACIntegerCheckBox();

      yoshikiBango.setText("様式番号印刷");

      yoshikiBango.setBindPath("YOSHIKI_BANGO");

      yoshikiBango.setMnemonic('F');

      addYoshikiBango();
    }
    return yoshikiBango;

  }

  /**
   * 利用票本表への表示を取得します。
   * @return 利用票本表への表示
   */
  public ACGroupBox getRiyohyos(){
    if(riyohyos==null){

      riyohyos = new ACGroupBox();

      riyohyos.setText("利用票本表への表示");

      riyohyos.setAutoWrap(false);

      addRiyohyos();
    }
    return riyohyos;

  }

  /**
   * 31居宅療養管理指導を取得します。
   * @return 31居宅療養管理指導
   */
  public ACIntegerCheckBox getPrintHomeMedicalAdvice(){
    if(printHomeMedicalAdvice==null){

      printHomeMedicalAdvice = new ACIntegerCheckBox();

      printHomeMedicalAdvice.setText("31,34居宅療養管理指導");

      printHomeMedicalAdvice.setBindPath("PRINT_HOME_MEDICAL_ADVICE");

      addPrintHomeMedicalAdvice();
    }
    return printHomeMedicalAdvice;

  }

  /**
   * 32,37認知症対応型・33,35,36特定施設入居者を取得します。
   * @return 32,37認知症対応型・33,35,36特定施設入居者
   */
  public ACIntegerCheckBox getNinchishoTokuteiShisetsu(){
    if(ninchishoTokuteiShisetsu==null){

      ninchishoTokuteiShisetsu = new ACIntegerCheckBox();

      ninchishoTokuteiShisetsu.setText("32,37認知症対応型・33,35,36特定施設入居者");

      ninchishoTokuteiShisetsu.setBindPath("NINCHISHO_TOKUTEI_SHISETSU");

      addNinchishoTokuteiShisetsu();
    }
    return ninchishoTokuteiShisetsu;

  }

  /**
   * 51～55施設サービスを取得します。
   * @return 51～55施設サービス
   */
  public ACIntegerCheckBox getShisetsuService(){
    if(shisetsuService==null){

      shisetsuService = new ACIntegerCheckBox();

      shisetsuService.setText("51,52,53,54,55施設サービス");

      shisetsuService.setBindPath("SHISETSU_SERVICE");

      addShisetsuService();
    }
    return shisetsuService;

  }

  /**
   * 介護職員処遇改善加算を取得します。
   * @return 介護職員処遇改善加算
   */
  public ACIntegerCheckBox getPrintSyoguKaizen(){
    if(printSyoguKaizen==null){

      printSyoguKaizen = new ACIntegerCheckBox();

      printSyoguKaizen.setText("介護職員処遇改善加算");

      printSyoguKaizen.setBindPath("PRINT_SYOGU_KAIZEN");

      addPrintSyoguKaizen();
    }
    return printSyoguKaizen;

  }

  /**
   * 特別地域加算・小規模事業所加算を取得します。
   * @return 特別地域加算・小規模事業所加算
   */
  public ACIntegerCheckBox getPrintSpecialArea(){
    if(printSpecialArea==null){

      printSpecialArea = new ACIntegerCheckBox();

      printSpecialArea.setText("特別地域加算・小規模事業所加算");

      printSpecialArea.setBindPath("PRINT_SPECIAL_AREA");

      addPrintSpecialArea();
    }
    return printSpecialArea;

  }

  /**
   * 中山間地域等提供加算を取得します。
   * @return 中山間地域等提供加算
   */
  public ACIntegerCheckBox getPrintChusankanArea(){
    if(printChusankanArea==null){

      printChusankanArea = new ACIntegerCheckBox();

      printChusankanArea.setText("中山間地域等提供加算");

      printChusankanArea.setBindPath("PRINT_CHUSANKAN_AREA");

      addPrintChusankanArea();
    }
    return printChusankanArea;

  }

  /**
   * 同一建物減算を取得します。
   * @return 同一建物減算
   */
  public ACIntegerCheckBox getPrintSameBuilding(){
    if(printSameBuilding==null){

      printSameBuilding = new ACIntegerCheckBox();

      printSameBuilding.setText("同一建物減算");

      printSameBuilding.setBindPath("PRINT_SAME_BUILDING");

      addPrintSameBuilding();
    }
    return printSameBuilding;

  }

  /**
   * 自費項目に△をつけるを取得します。
   * @return 自費項目に△をつける
   */
  public ACIntegerCheckBox getPrivateExpenses(){
    if(privateExpenses==null){

      privateExpenses = new ACIntegerCheckBox();

      privateExpenses.setText("自費項目に△をつける");

      privateExpenses.setBindPath("PRIVATE_EXPENSES");

      addPrivateExpenses();
    }
    return privateExpenses;

  }

  /**
   * 特定入所者の利用者負担額が0円の場合に明細書に印字するを取得します。
   * @return 特定入所者の利用者負担額が0円の場合に明細書に印字する
   */
  public ACIntegerCheckBox getPrintNursingZero(){
    if(printNursingZero==null){

      printNursingZero = new ACIntegerCheckBox();

      printNursingZero.setText("特定入所者の利用者負担額が0円の場合に明細書に印字する");

      printNursingZero.setBindPath("PRINT_NURSING_ZERO");

      addPrintNursingZero();
    }
    return printNursingZero;

  }

  /**
   * 特定入所者の負担限度額が0円の場合に明細書に印字するを取得します。
   * @return 特定入所者の負担限度額が0円の場合に明細書に印字する
   */
  public ACIntegerCheckBox getPrintNursingLimitZero(){
    if(printNursingLimitZero==null){

      printNursingLimitZero = new ACIntegerCheckBox();

      printNursingLimitZero.setText("特定入所者の負担限度額が0円の場合に明細書に印字する");

      printNursingLimitZero.setBindPath("PRINT_NURSING_LIMIT_ZERO");

      addPrintNursingLimitZero();
    }
    return printNursingLimitZero;

  }

  /**
   * その他の設定領域を取得します。
   * @return その他の設定領域
   */
  public ACGroupBox getOthers(){
    if(others==null){

      others = new ACGroupBox();

      others.setText("その他の設定");

      addOthers();
    }
    return others;

  }

  /**
   * 緊急時訪問看護加算・特別管理加算を月1回算定に設定するを取得します。
   * @return 緊急時訪問看護加算・特別管理加算を月1回算定に設定する
   */
  public ACIntegerCheckBox getOncePerMonth(){
    if(oncePerMonth==null){

      oncePerMonth = new ACIntegerCheckBox();

      oncePerMonth.setText("<html>緊急時訪問看護加算・特別管理加算を月1回算定に設定する</html>");

      oncePerMonth.setBindPath("ONCE_PER_MONTH");

      addOncePerMonth();
    }
    return oncePerMonth;

  }

  /**
   * 税率コンテナを取得します。
   * @return 税率コンテナ
   */
  public ACLabelContainer getTaxContainer(){
    if(taxContainer==null){

      taxContainer = new ACLabelContainer();

      taxContainer.setText("消費税率");

      taxContainer.setVisible(false);

      addTaxContainer();
    }
    return taxContainer;

  }

  /**
   * 税率を取得します。
   * @return 税率
   */
  public ACTextField getTax(){
    if(tax==null){

      tax = new ACTextField();

      tax.setEditable(false);

      tax.setColumns(3);

      tax.setCharType(VRCharType.ONLY_FLOAT);

      tax.setHorizontalAlignment(SwingConstants.RIGHT);

      tax.setIMEMode(InputSubset.LATIN);

      tax.setMaxLength(3);

      addTax();
    }
    return tax;

  }

  /**
   * 税率単位を取得します。
   * @return 税率単位
   */
  public ACLabel getTaxUnit(){
    if(taxUnit==null){

      taxUnit = new ACLabel();

      taxUnit.setText("%");

      addTaxUnit();
    }
    return taxUnit;

  }

  /**
   * 税率編集を取得します。
   * @return 税率編集
   */
  public ACButton getTaxChange(){
    if(taxChange==null){

      taxChange = new ACButton();

      taxChange.setText("編集");

      addTaxChange();
    }
    return taxChange;

  }

  /**
   * 過去の事業所体制情報も表示するを取得します。
   * @return 過去の事業所体制情報も表示する
   */
  public ACIntegerCheckBox getShowOldLowProviderElements(){
    if(showOldLowProviderElements==null){

      showOldLowProviderElements = new ACIntegerCheckBox();

      showOldLowProviderElements.setText("過去の事業所体制情報も表示する");

      showOldLowProviderElements.setBindPath("SHOW_OLD_LOW_PROVIDER_ELEMENTS");

      addShowOldLowProviderElements();
    }
    return showOldLowProviderElements;

  }

  /**
   * 介護保険・介護認定情報も取り込む（最新1件のみ）を取得します。
   * @return 介護保険・介護認定情報も取り込む（最新1件のみ）
   */
  public ACIntegerCheckBox getKaigoHoken(){
    if(kaigoHoken==null){

      kaigoHoken = new ACIntegerCheckBox();

      kaigoHoken.setText("<html>日レセ連携時に介護保険・介護認定情報を取り込む（最新1件分）<br>※dbsパッケージ（jma-receipt-dbs）を最新にしてご利用ください。</html>");

      kaigoHoken.setBindPath("KAIGO_HOKEN");

      addKaigoHoken();
    }
    return kaigoHoken;

  }

  /**
   * データの退避・復元領域を取得します。
   * @return データの退避・復元領域
   */
  public ACGroupBox getBackupResotres(){
    if(backupResotres==null){

      backupResotres = new ACGroupBox();

      backupResotres.setText("データの退避・復元");

      backupResotres.setAutoWrap(false);

      addBackupResotres();
    }
    return backupResotres;

  }

  /**
   * 退避を取得します。
   * @return 退避
   */
  public ACButton getBackup(){
    if(backup==null){

      backup = new ACButton();

      backup.setText("データの退避");

      addBackup();
    }
    return backup;

  }

  /**
   * 復元を取得します。
   * @return 復元
   */
  public ACButton getRestore(){
    if(restore==null){

      restore = new ACButton();

      restore.setText("データの復元");

      addRestore();
    }
    return restore;

  }

  /**
   * コンストラクタです。
   */
  public QO005Design() {

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

    buttons.add(getUpdate(), VRLayout.EAST);
  }

  /**
   * 更新ボタンに内部項目を追加します。
   */
  protected void addUpdate(){

  }

  /**
   * クライアント領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getDbs(), VRLayout.NORTH);

    contents.add(getPdfFileSelects(), VRLayout.NORTH);

    contents.add(getAffairSettings(), VRLayout.NORTH);

    contents.add(getBackupResotres(), VRLayout.NORTH);

  }

  /**
   * DB設定領域に内部項目を追加します。
   */
  protected void addDbs(){

    dbs.add(getServerSelects(), VRLayout.NORTH);

    dbs.add(getDbFileSelects(), VRLayout.NORTH);

    dbs.add(getDbComment(), VRLayout.NORTH);

  }

  /**
   * サーバー選択領域に内部項目を追加します。
   */
  protected void addServerSelects(){

    serverSelects.add(getServerSelectRadiosContainer(), VRLayout.FLOW);

    serverSelects.add(getServerSelectIpTextContainer(), VRLayout.FLOW);

  }

  /**
   * サーバー選択・ラジオグループに内部項目を追加します。
   */
  protected void addServerSelectRadios(){

  }

  /**
   * サーバー選択・ラジオグループモデルに内部項目を追加します。
   */
  protected void addServerSelectRadiosModel(){

    getServerSelectRadioItem1().setButtonIndex(1);

    getServerSelectRadiosModel().add(getServerSelectRadioItem1());

    getServerSelectRadioItem2().setButtonIndex(2);

    getServerSelectRadiosModel().add(getServerSelectRadioItem2());

  }

  /**
   * サーバー選択・ラジオ(ローカル)に内部項目を追加します。
   */
  protected void addServerSelectRadioItem1(){

  }

  /**
   * サーバー選択・ラジオ(他のコンピューター)に内部項目を追加します。
   */
  protected void addServerSelectRadioItem2(){

  }

  /**
   * IP領域に内部項目を追加します。
   */
  protected void addServerSelectIpText(){

  }

  /**
   * ファイル選択領域に内部項目を追加します。
   */
  protected void addDbFileSelects(){

    dbFileSelects.add(getDbFileSelectFileNameContainer(), VRLayout.FLOW);

    dbFileSelects.add(getDbFileSelectFileCompareButton(), VRLayout.FLOW);

  }

  /**
   * ファイル名入力領域に内部項目を追加します。
   */
  protected void addDbFileSelectFileName(){

  }

  /**
   * ファイル参照ボタンに内部項目を追加します。
   */
  protected void addDbFileSelectFileCompareButton(){

  }

  /**
   * コメント領域1に内部項目を追加します。
   */
  protected void addDbComment(){

    dbComment.add(getComment1(), VRLayout.NORTH);

    dbComment.add(getDbSettingComments(), VRLayout.NORTH);

  }

  /**
   * コメント1に内部項目を追加します。
   */
  protected void addComment1(){

  }

  /**
   * DB設定コメントに内部項目を追加します。
   */
  protected void addDbSettingComments(){

  }

  /**
   * PDF設定領域に内部項目を追加します。
   */
  protected void addPdfFileSelects(){

    pdfFileSelects.add(getPdfFileSelectFileNameContainer(), VRLayout.FLOW);

    pdfFileSelects.add(getPdfFileSelectFileCompareButton(), VRLayout.FLOW);

    pdfFileSelects.add(getPdfComment(), VRLayout.NORTH);

  }

  /**
   * PDFファイル名入力領域に内部項目を追加します。
   */
  protected void addPdfFileSelectFileName(){

  }

  /**
   * PDFファイル参照ボタンに内部項目を追加します。
   */
  protected void addPdfFileSelectFileCompareButton(){

  }

  /**
   * コメント領域4に内部項目を追加します。
   */
  protected void addPdfComment(){

    pdfComment.add(getComment2(), VRLayout.NORTH);

  }

  /**
   * コメント4に内部項目を追加します。
   */
  protected void addComment2(){

  }

  /**
   * 仕様設定に内部項目を追加します。
   */
  protected void addAffairSettings(){

    affairSettings.add(getChohyos(), VRLayout.WEST);

    affairSettings.add(getOthers(), VRLayout.CLIENT);

  }

  /**
   * 帳票設定領域に内部項目を追加します。
   */
  protected void addChohyos(){

    chohyos.add(getYoshikiBango(), VRLayout.FLOW_RETURN);

    chohyos.add(getRiyohyos(), VRLayout.FLOW_RETURN);

    chohyos.add(getPrintNursingZero(), VRLayout.FLOW_RETURN);

    chohyos.add(getPrintNursingLimitZero(), VRLayout.FLOW_RETURN);

  }

  /**
   * 様式番号印刷に内部項目を追加します。
   */
  protected void addYoshikiBango(){

  }

  /**
   * 利用票本表への表示に内部項目を追加します。
   */
  protected void addRiyohyos(){

    riyohyos.add(getPrintHomeMedicalAdvice(), VRLayout.FLOW);

    riyohyos.add(getNinchishoTokuteiShisetsu(), VRLayout.FLOW_RETURN);

    riyohyos.add(getShisetsuService(), VRLayout.FLOW);

    riyohyos.add(getPrintSyoguKaizen(), VRLayout.FLOW_RETURN);

    riyohyos.add(getPrintSpecialArea(), VRLayout.FLOW);

    riyohyos.add(getPrintChusankanArea(), VRLayout.FLOW_RETURN);

    riyohyos.add(getPrintSameBuilding(), VRLayout.FLOW);

    riyohyos.add(getPrivateExpenses(), VRLayout.FLOW_RETURN);

  }

  /**
   * 31居宅療養管理指導に内部項目を追加します。
   */
  protected void addPrintHomeMedicalAdvice(){

  }

  /**
   * 32,37認知症対応型・33,35,36特定施設入居者に内部項目を追加します。
   */
  protected void addNinchishoTokuteiShisetsu(){

  }

  /**
   * 51～55施設サービスに内部項目を追加します。
   */
  protected void addShisetsuService(){

  }

  /**
   * 介護職員処遇改善加算に内部項目を追加します。
   */
  protected void addPrintSyoguKaizen(){

  }

  /**
   * 特別地域加算・小規模事業所加算に内部項目を追加します。
   */
  protected void addPrintSpecialArea(){

  }

  /**
   * 中山間地域等提供加算に内部項目を追加します。
   */
  protected void addPrintChusankanArea(){

  }

  /**
   * 同一建物減算に内部項目を追加します。
   */
  protected void addPrintSameBuilding(){

  }

  /**
   * 自費項目に△をつけるに内部項目を追加します。
   */
  protected void addPrivateExpenses(){

  }

  /**
   * 特定入所者の利用者負担額が0円の場合に明細書に印字するに内部項目を追加します。
   */
  protected void addPrintNursingZero(){

  }

  /**
   * 特定入所者の負担限度額が0円の場合に明細書に印字するに内部項目を追加します。
   */
  protected void addPrintNursingLimitZero(){

  }

  /**
   * その他の設定領域に内部項目を追加します。
   */
  protected void addOthers(){

    others.add(getOncePerMonth(), VRLayout.FLOW_RETURN);

    others.add(getTaxContainer(), VRLayout.FLOW_RETURN);

    others.add(getShowOldLowProviderElements(), VRLayout.FLOW_RETURN);

    others.add(getKaigoHoken(), VRLayout.FLOW_RETURN);

  }

  /**
   * 緊急時訪問看護加算・特別管理加算を月1回算定に設定するに内部項目を追加します。
   */
  protected void addOncePerMonth(){

  }

  /**
   * 税率コンテナに内部項目を追加します。
   */
  protected void addTaxContainer(){

    taxContainer.add(getTax(), VRLayout.FLOW);

    taxContainer.add(getTaxUnit(), VRLayout.FLOW);

    taxContainer.add(getTaxChange(), VRLayout.FLOW);

  }

  /**
   * 税率に内部項目を追加します。
   */
  protected void addTax(){

  }

  /**
   * 税率単位に内部項目を追加します。
   */
  protected void addTaxUnit(){

  }

  /**
   * 税率編集に内部項目を追加します。
   */
  protected void addTaxChange(){

  }

  /**
   * 過去の事業所体制情報も表示するに内部項目を追加します。
   */
  protected void addShowOldLowProviderElements(){

  }

  /**
   * 介護保険・介護認定情報も取り込む（最新1件のみ）に内部項目を追加します。
   */
  protected void addKaigoHoken(){

  }

  /**
   * データの退避・復元領域に内部項目を追加します。
   */
  protected void addBackupResotres(){

    backupResotres.add(getBackup(), VRLayout.FLOW);

    backupResotres.add(getRestore(), VRLayout.FLOW);

  }

  /**
   * 退避に内部項目を追加します。
   */
  protected void addBackup(){

  }

  /**
   * 復元に内部項目を追加します。
   */
  protected void addRestore(){

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
      ACFrame.debugStart(new ACAffairInfo(QO005Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO005Design getThis() {
    return this;
  }
}
