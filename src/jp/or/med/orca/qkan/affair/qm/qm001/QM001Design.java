
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
 * 開発者: 堤 瑞樹
 * 作成日: 2006/05/25  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム メニュー (M)
 * プロセス ログイン画面 (001)
 * プログラム ログイン画面 (QM001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qm.qm001;
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
 * ログイン画面画面項目デザイン(QM001) 
 */
public class QM001Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACPanel contents;

  private ACPanel titles;

  private ACLabel affairTitle;

  private ACLabel systemVersion;

  private ACPanel clients;

  private VRLayout clientsLayout;

  private ACLabel dummyNorth;

  private ACLabel dummyWest;

  private ACLabel dummyEast;

  private ACLabel dummySouth;

  private ACPanel mains;

  private ACPanel controls;

  private ACLabel subTitle;

  private ACLabel dummyMargin;

  private ACPanel combos;

  private ACComboBox providerList;

  private ACLabelContainer providerListContainer;

  private ACComboBoxModelAdapter providerListModel;

  private QkanDateTextField systemDate;

  private ACLabelContainer systemDateContainer;

  private ACPanel informations;

  private ACPanel versionErros;

  private ACLabel versionError;

  private ACPanel dbErros;

  private ACLabel dbConnectionError;

  private ACLabel dbmsError;

  private ACLabel dbVersionError;

  private ACPanel goSettingButtons1;

  private ACButton goSetting1;

  private ACPanel noProviders;

  private ACLabel noPropvider;

  private ACPanel goProviderButtons;

  private ACButton goProvider;

  private ACPanel shareDBs;

  private ACLabel shareDB;

  private ACPanel goSettingButtons3;

  private ACButton goSetting3;

  private ACPanel noInsurers;

  private ACLabel noInsurer;

  private ACPanel goInsurerButtons;

  private ACButton goInsurer;

  private ACPanel noPatients;

  private ACLabel noPatient;

  private ACPanel goPatientButtons;

  private ACButton goPatient;

  private ACPanel noPDFViewers;

  private ACLabel noPDFViewer;

  private ACPanel goSettingButtons2;

  private ACButton goSetting2;

  private ACPanel noErrors;

  private ACLabel noError;

  private ACGroupBox environments;

  private ACLabel environment;

  private ACPanel bottoms;

  private ACButton showVersion;

  private ACButton start;

  private ACButton end;

  private ACPanel copyrights;

  private ACLabel copyright;

  //getter

  /**
   * クライアント領域を取得します。
   * @return クライアント領域
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      contents.setBackground(new Color(0,51,153));

      addContents();
    }
    return contents;

  }

  /**
   * タイトル領域を取得します。
   * @return タイトル領域
   */
  public ACPanel getTitles(){
    if(titles==null){

      titles = new ACPanel();

      titles.setBackground(new Color(0,51,153));

      addTitles();
    }
    return titles;

  }

  /**
   * タイトルを取得します。
   * @return タイトル
   */
  public ACLabel getAffairTitle(){
    if(affairTitle==null){

      affairTitle = new ACLabel();

      affairTitle.setText("給付管理／介護報酬請求支援ソフト　Ver.");

      affairTitle.setForeground(Color.white);

      Font font = affairTitle.getFont();
      if(font!=null){
        affairTitle.setFont(new Font(font.getName(), font.getStyle(), 18));
      }

      addAffairTitle();
    }
    return affairTitle;

  }

  /**
   * システムバージョンを取得します。
   * @return システムバージョン
   */
  public ACLabel getSystemVersion(){
    if(systemVersion==null){

      systemVersion = new ACLabel();

      systemVersion.setForeground(Color.white);

      Font font = systemVersion.getFont();
      if(font!=null){
        systemVersion.setFont(new Font(font.getName(), font.getStyle(), 18));
      }

      addSystemVersion();
    }
    return systemVersion;

  }

  /**
   * 中央領域を取得します。
   * @return 中央領域
   */
  public ACPanel getClients(){
    if(clients==null){

      clients = new ACPanel();

      clients.setLayout(getClientsLayout());

      clients.setBackground(new Color(0,51,153));

      addClients();
    }
    return clients;

  }

  /**
   * 中央量領域レイアウトを取得します。
   * @return 中央量領域レイアウト
   */
  public VRLayout getClientsLayout(){
    if(clientsLayout==null){

      clientsLayout = new VRLayout();

      clientsLayout.setHgap(0);

      clientsLayout.setLabelMargin(0);

      clientsLayout.setVAlignment(VRLayout.CENTER);

      clientsLayout.setAlignment(VRLayout.CENTER);

      addClientsLayout();
    }
    return clientsLayout;

  }

  /**
   * ダミー上を取得します。
   * @return ダミー上
   */
  public ACLabel getDummyNorth(){
    if(dummyNorth==null){

      dummyNorth = new ACLabel();

      dummyNorth.setText(" ");

      dummyNorth.setRows(4);

      addDummyNorth();
    }
    return dummyNorth;

  }

  /**
   * ダミー左を取得します。
   * @return ダミー左
   */
  public ACLabel getDummyWest(){
    if(dummyWest==null){

      dummyWest = new ACLabel();

      dummyWest.setText("　");

      dummyWest.setColumns(4);

      addDummyWest();
    }
    return dummyWest;

  }

  /**
   * ダミー右を取得します。
   * @return ダミー右
   */
  public ACLabel getDummyEast(){
    if(dummyEast==null){

      dummyEast = new ACLabel();

      dummyEast.setText("　");

      dummyEast.setColumns(4);

      addDummyEast();
    }
    return dummyEast;

  }

  /**
   * ダミー下を取得します。
   * @return ダミー下
   */
  public ACLabel getDummySouth(){
    if(dummySouth==null){

      dummySouth = new ACLabel();

      dummySouth.setText(" ");

      dummySouth.setRows(4);

      addDummySouth();
    }
    return dummySouth;

  }

  /**
   * メイン領域を取得します。
   * @return メイン領域
   */
  public ACPanel getMains(){
    if(mains==null){

      mains = new ACPanel();

      mains.setBackground(new Color(0,51,153));

      addMains();
    }
    return mains;

  }

  /**
   * コントロール領域を取得します。
   * @return コントロール領域
   */
  public ACPanel getControls(){
    if(controls==null){

      controls = new ACPanel();

      addControls();
    }
    return controls;

  }

  /**
   * サブタイトルを取得します。
   * @return サブタイトル
   */
  public ACLabel getSubTitle(){
    if(subTitle==null){

      subTitle = new ACLabel();

      subTitle.setText("　ログイン画面");

      subTitle.setOpaque(true);
      subTitle.setBackground(new Color(20,80,20));

      subTitle.setForeground(Color.white);

      addSubTitle();
    }
    return subTitle;

  }

  /**
   * マージンを取得します。
   * @return マージン
   */
  public ACLabel getDummyMargin(){
    if(dummyMargin==null){

      dummyMargin = new ACLabel();

      dummyMargin.setText("　");

      addDummyMargin();
    }
    return dummyMargin;

  }

  /**
   * コンボ領域を取得します。
   * @return コンボ領域
   */
  public ACPanel getCombos(){
    if(combos==null){

      combos = new ACPanel();

      combos.setAutoWrap(false);

      addCombos();
    }
    return combos;

  }

  /**
   * 自事業所一覧を取得します。
   * @return 自事業所一覧
   */
  public ACComboBox getProviderList(){
    if(providerList==null){

      providerList = new ACComboBox();

      getProviderListContainer().setText("自事業所選択");

      providerList.setBindPath("PROVIDER_ID");

      providerList.setEditable(false);

      providerList.setModelBindPath("PROVIDER_LISTS");

      providerList.setRenderBindPath("SHOW_PROVIDER_NAME");

      providerList.setMaxColumns(24);

      providerList.setModel(getProviderListModel());

      addProviderList();
    }
    return providerList;

  }

  /**
   * 自事業所一覧コンテナを取得します。
   * @return 自事業所一覧コンテナ
   */
  protected ACLabelContainer getProviderListContainer(){
    if(providerListContainer==null){
      providerListContainer = new ACLabelContainer();
      providerListContainer.setFollowChildEnabled(true);
      providerListContainer.setVAlignment(VRLayout.CENTER);
      providerListContainer.add(getProviderList(), null);
    }
    return providerListContainer;
  }

  /**
   * 自事業所一覧モデルを取得します。
   * @return 自事業所一覧モデル
   */
  protected ACComboBoxModelAdapter getProviderListModel(){
    if(providerListModel==null){
      providerListModel = new ACComboBoxModelAdapter();
      addProviderListModel();
    }
    return providerListModel;
  }

  /**
   * システム日付を取得します。
   * @return システム日付
   */
  public QkanDateTextField getSystemDate(){
    if(systemDate==null){

      systemDate = new QkanDateTextField();

      getSystemDateContainer().setText("システム日付");

      systemDate.setBindPath("SYSTEM_DATE");

      addSystemDate();
    }
    return systemDate;

  }

  /**
   * システム日付コンテナを取得します。
   * @return システム日付コンテナ
   */
  protected ACLabelContainer getSystemDateContainer(){
    if(systemDateContainer==null){
      systemDateContainer = new ACLabelContainer();
      systemDateContainer.setFollowChildEnabled(true);
      systemDateContainer.setVAlignment(VRLayout.CENTER);
      systemDateContainer.add(getSystemDate(), null);
    }
    return systemDateContainer;
  }

  /**
   * 情報領域を取得します。
   * @return 情報領域
   */
  public ACPanel getInformations(){
    if(informations==null){

      informations = new ACPanel();

      addInformations();
    }
    return informations;

  }

  /**
   * システムバージョンエラーを取得します。
   * @return システムバージョンエラー
   */
  public ACPanel getVersionErros(){
    if(versionErros==null){

      versionErros = new ACPanel();

      addVersionErros();
    }
    return versionErros;

  }

  /**
   * システムバージョンエラーメッセージを取得します。
   * @return システムバージョンエラーメッセージ
   */
  public ACLabel getVersionError(){
    if(versionError==null){

      versionError = new ACLabel();

      versionError.setText("システムのバージョン情報取得に失敗しました。設定ファイルが不正か破損している可能性があります。再インストールを行ってください。");

      versionError.setIconPath(ACConstants.ICON_PATH_STOP_16);

      versionError.setAutoWrap(true);

      addVersionError();
    }
    return versionError;

  }

  /**
   * DBエラーを取得します。
   * @return DBエラー
   */
  public ACPanel getDbErros(){
    if(dbErros==null){

      dbErros = new ACPanel();

      addDbErros();
    }
    return dbErros;

  }

  /**
   * DB接続エラーメッセージを取得します。
   * @return DB接続エラーメッセージ
   */
  public ACLabel getDbConnectionError(){
    if(dbConnectionError==null){

      dbConnectionError = new ACLabel();

      dbConnectionError.setText("データベースへの接続に失敗しました。「設定変更」画面でデータベースの設定を行ってください。");

      dbConnectionError.setIconPath(ACConstants.ICON_PATH_STOP_16);

      dbConnectionError.setAutoWrap(true);

      addDbConnectionError();
    }
    return dbConnectionError;

  }

  /**
   * DBMS非対応エラーメッセージを取得します。
   * @return DBMS非対応エラーメッセージ
   */
  public ACLabel getDbmsError(){
    if(dbmsError==null){

      dbmsError = new ACLabel();

      dbmsError.setText("データベースのバージョン情報が不正です。Firebirdの再インストールを行ってください。");

      dbmsError.setIconPath(ACConstants.ICON_PATH_STOP_16);

      dbmsError.setAutoWrap(true);

      addDbmsError();
    }
    return dbmsError;

  }

  /**
   * DBバージョンエラーメッセージを取得します。
   * @return DBバージョンエラーメッセージ
   */
  public ACLabel getDbVersionError(){
    if(dbVersionError==null){

      dbVersionError = new ACLabel();

      dbVersionError.setText("データベース構成のバージョン情報取得に失敗しました。データベースが不正か破損している可能性があります。再インストールを行ってください。");

      dbVersionError.setIconPath(ACConstants.ICON_PATH_STOP_16);

      dbVersionError.setAutoWrap(true);

      addDbVersionError();
    }
    return dbVersionError;

  }

  /**
   * 遷移ボタン領域を取得します。
   * @return 遷移ボタン領域
   */
  public ACPanel getGoSettingButtons1(){
    if(goSettingButtons1==null){

      goSettingButtons1 = new ACPanel();

      addGoSettingButtons1();
    }
    return goSettingButtons1;

  }

  /**
   * 設定変更遷移ボタンを取得します。
   * @return 設定変更遷移ボタン
   */
  public ACButton getGoSetting1(){
    if(goSetting1==null){

      goSetting1 = new ACButton();

      goSetting1.setText("設定変更画面へ");

      addGoSetting1();
    }
    return goSetting1;

  }

  /**
   * 自事業所なしを取得します。
   * @return 自事業所なし
   */
  public ACPanel getNoProviders(){
    if(noProviders==null){

      noProviders = new ACPanel();

      addNoProviders();
    }
    return noProviders;

  }

  /**
   * 自事業所なしメッセージを取得します。
   * @return 自事業所なしメッセージ
   */
  public ACLabel getNoPropvider(){
    if(noPropvider==null){

      noPropvider = new ACLabel();

      noPropvider.setText("自事業所が存在しません。「事業所登録」画面で自事業所を1件以上作成してください。");

      noPropvider.setIconPath(ACConstants.ICON_PATH_EXCLAMATION_16);

      noPropvider.setAutoWrap(true);

      addNoPropvider();
    }
    return noPropvider;

  }

  /**
   * 遷移ボタン領域を取得します。
   * @return 遷移ボタン領域
   */
  public ACPanel getGoProviderButtons(){
    if(goProviderButtons==null){

      goProviderButtons = new ACPanel();

      addGoProviderButtons();
    }
    return goProviderButtons;

  }

  /**
   * 事業所登録遷移ボタンを取得します。
   * @return 事業所登録遷移ボタン
   */
  public ACButton getGoProvider(){
    if(goProvider==null){

      goProvider = new ACButton();

      goProvider.setText("事業所登録画面へ");

      addGoProvider();
    }
    return goProvider;

  }

  /**
   * DB共有確認を取得します。
   * @return DB共有確認
   */
  public ACPanel getShareDBs(){
    if(shareDBs==null){

      shareDBs = new ACPanel();

      addShareDBs();
    }
    return shareDBs;

  }

  /**
   * DB共有確認メッセージを取得します。
   * @return DB共有確認メッセージ
   */
  public ACLabel getShareDB(){
    if(shareDB==null){

      shareDB = new ACLabel();

      shareDB.setText("このコンピューターにはデータを作成せず、他のコンピューターにあるデータベースを共有する場合は「設定変更」画面でデータベースの設定を行ってください。");

      shareDB.setIconPath(ACConstants.ICON_PATH_QUESTION_16);

      shareDB.setAutoWrap(true);

      addShareDB();
    }
    return shareDB;

  }

  /**
   * 遷移ボタン領域を取得します。
   * @return 遷移ボタン領域
   */
  public ACPanel getGoSettingButtons3(){
    if(goSettingButtons3==null){

      goSettingButtons3 = new ACPanel();

      addGoSettingButtons3();
    }
    return goSettingButtons3;

  }

  /**
   * 設定変更遷移ボタンを取得します。
   * @return 設定変更遷移ボタン
   */
  public ACButton getGoSetting3(){
    if(goSetting3==null){

      goSetting3 = new ACButton();

      goSetting3.setText("設定変更画面へ");

      addGoSetting3();
    }
    return goSetting3;

  }

  /**
   * 保険者なしを取得します。
   * @return 保険者なし
   */
  public ACPanel getNoInsurers(){
    if(noInsurers==null){

      noInsurers = new ACPanel();

      addNoInsurers();
    }
    return noInsurers;

  }

  /**
   * 保険者なしメッセージを取得します。
   * @return 保険者なしメッセージ
   */
  public ACLabel getNoInsurer(){
    if(noInsurer==null){

      noInsurer = new ACLabel();

      noInsurer.setText("保険者が登録されていません。「保険者登録」画面で保険者を登録してください。");

      noInsurer.setIconPath(ACConstants.ICON_PATH_EXCLAMATION_16);

      noInsurer.setAutoWrap(true);

      addNoInsurer();
    }
    return noInsurer;

  }

  /**
   * 遷移ボタン領域を取得します。
   * @return 遷移ボタン領域
   */
  public ACPanel getGoInsurerButtons(){
    if(goInsurerButtons==null){

      goInsurerButtons = new ACPanel();

      addGoInsurerButtons();
    }
    return goInsurerButtons;

  }

  /**
   * 保険者登録遷移ボタンを取得します。
   * @return 保険者登録遷移ボタン
   */
  public ACButton getGoInsurer(){
    if(goInsurer==null){

      goInsurer = new ACButton();

      goInsurer.setText("保険者登録画面へ");

      addGoInsurer();
    }
    return goInsurer;

  }

  /**
   * 利用者なしを取得します。
   * @return 利用者なし
   */
  public ACPanel getNoPatients(){
    if(noPatients==null){

      noPatients = new ACPanel();

      addNoPatients();
    }
    return noPatients;

  }

  /**
   * 利用者なしメッセージを取得します。
   * @return 利用者なしメッセージ
   */
  public ACLabel getNoPatient(){
    if(noPatient==null){

      noPatient = new ACLabel();

      noPatient.setText("利用者が登録されていません。「利用者登録」画面で利用者を登録してください。");

      noPatient.setIconPath(ACConstants.ICON_PATH_EXCLAMATION_16);

      noPatient.setAutoWrap(true);

      addNoPatient();
    }
    return noPatient;

  }

  /**
   * 遷移ボタン領域を取得します。
   * @return 遷移ボタン領域
   */
  public ACPanel getGoPatientButtons(){
    if(goPatientButtons==null){

      goPatientButtons = new ACPanel();

      addGoPatientButtons();
    }
    return goPatientButtons;

  }

  /**
   * 利用者登録遷移ボタンを取得します。
   * @return 利用者登録遷移ボタン
   */
  public ACButton getGoPatient(){
    if(goPatient==null){

      goPatient = new ACButton();

      goPatient.setText("利用者登録画面へ");

      addGoPatient();
    }
    return goPatient;

  }

  /**
   * PDFビューワなしを取得します。
   * @return PDFビューワなし
   */
  public ACPanel getNoPDFViewers(){
    if(noPDFViewers==null){

      noPDFViewers = new ACPanel();

      addNoPDFViewers();
    }
    return noPDFViewers;

  }

  /**
   * PDFビューワなしメッセージを取得します。
   * @return PDFビューワなしメッセージ
   */
  public ACLabel getNoPDFViewer(){
    if(noPDFViewer==null){

      noPDFViewer = new ACLabel();

      noPDFViewer.setText("印刷結果を表示するPDFビューワが指定されていません。「設定変更」画面でPDFビューワを設定してください。");

      noPDFViewer.setIconPath(ACConstants.ICON_PATH_EXCLAMATION_16);

      noPDFViewer.setAutoWrap(true);

      addNoPDFViewer();
    }
    return noPDFViewer;

  }

  /**
   * 遷移ボタン領域を取得します。
   * @return 遷移ボタン領域
   */
  public ACPanel getGoSettingButtons2(){
    if(goSettingButtons2==null){

      goSettingButtons2 = new ACPanel();

      addGoSettingButtons2();
    }
    return goSettingButtons2;

  }

  /**
   * 設定変更遷移ボタンを取得します。
   * @return 設定変更遷移ボタン
   */
  public ACButton getGoSetting2(){
    if(goSetting2==null){

      goSetting2 = new ACButton();

      goSetting2.setText("設定変更画面へ");

      addGoSetting2();
    }
    return goSetting2;

  }

  /**
   * 正常起動を取得します。
   * @return 正常起動
   */
  public ACPanel getNoErrors(){
    if(noErrors==null){

      noErrors = new ACPanel();

      addNoErrors();
    }
    return noErrors;

  }

  /**
   * 正常起動メッセージを取得します。
   * @return 正常起動メッセージ
   */
  public ACLabel getNoError(){
    if(noError==null){

      noError = new ACLabel();

      noError.setText("システムが正常起動しました。自事業所を選択し、開始ボタンを押下してください。");

      noError.setIconPath(ACConstants.ICON_PATH_INFORMATION_16);

      noError.setAutoWrap(true);

      addNoError();
    }
    return noError;

  }

  /**
   * 環境情報を取得します。
   * @return 環境情報
   */
  public ACGroupBox getEnvironments(){
    if(environments==null){

      environments = new ACGroupBox();

      environments.setText("環境情報");

      addEnvironments();
    }
    return environments;

  }

  /**
   * 環境情報詳細を取得します。
   * @return 環境情報詳細
   */
  public ACLabel getEnvironment(){
    if(environment==null){

      environment = new ACLabel();

      environment.setText("環境情報を取得できません。");

      addEnvironment();
    }
    return environment;

  }

  /**
   * ボタン領域を取得します。
   * @return ボタン領域
   */
  public ACPanel getBottoms(){
    if(bottoms==null){

      bottoms = new ACPanel();

      addBottoms();
    }
    return bottoms;

  }

  /**
   * バージョン情報表示ボタンを取得します。
   * @return バージョン情報表示ボタン
   */
  public ACButton getShowVersion(){
    if(showVersion==null){

      showVersion = new ACButton();

      showVersion.setText("バージョン情報");

      showVersion.setToolTipText("バージョン情報を表示します。");

      addShowVersion();
    }
    return showVersion;

  }

  /**
   * 開始を取得します。
   * @return 開始
   */
  public ACButton getStart(){
    if(start==null){

      start = new ACButton();

      start.setText("開始(S)");

      start.setToolTipText("選択した自事業所で開始します。");

      start.setMnemonic('S');

      start.setIconPath(ACConstants.ICON_PATH_START_16);

      addStart();
    }
    return start;

  }

  /**
   * 終了を取得します。
   * @return 終了
   */
  public ACButton getEnd(){
    if(end==null){

      end = new ACButton();

      end.setText("終了(E)");

      end.setToolTipText("プログラムを終了します。");

      end.setMnemonic('E');

      end.setIconPath(ACConstants.ICON_PATH_EXIT_16);

      addEnd();
    }
    return end;

  }

  /**
   * コピーライト領域を取得します。
   * @return コピーライト領域
   */
  public ACPanel getCopyrights(){
    if(copyrights==null){

      copyrights = new ACPanel();

      copyrights.setBackground(new Color(0,51,153));

      addCopyrights();
    }
    return copyrights;

  }

  /**
   * コピーライトを取得します。
   * @return コピーライト
   */
  public ACLabel getCopyright(){
    if(copyright==null){

      copyright = new ACLabel();

      copyright.setText("Copyright （社）日本医師会 2006");

      copyright.setForeground(Color.white);

      addCopyright();
    }
    return copyright;

  }

  /**
   * コンストラクタです。
   */
  public QM001Design() {

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

    contents.add(getTitles(), VRLayout.NORTH);

    contents.add(getClients(), VRLayout.CLIENT);

    contents.add(getCopyrights(), VRLayout.SOUTH);
  }

  /**
   * タイトル領域に内部項目を追加します。
   */
  protected void addTitles(){

    titles.add(getAffairTitle(), VRLayout.FLOW);

    titles.add(getSystemVersion(), VRLayout.FLOW);

  }

  /**
   * タイトルに内部項目を追加します。
   */
  protected void addAffairTitle(){

  }

  /**
   * システムバージョンに内部項目を追加します。
   */
  protected void addSystemVersion(){

  }

  /**
   * 中央領域に内部項目を追加します。
   */
  protected void addClients(){

    clients.add(getDummyNorth(), VRLayout.NORTH);

    clients.add(getDummyWest(), VRLayout.WEST);

    clients.add(getMains(), VRLayout.FLOW);

    clients.add(getDummyEast(), VRLayout.EAST);
    clients.add(getDummySouth(), VRLayout.SOUTH);
  }

  /**
   * 中央量領域レイアウトに内部項目を追加します。
   */
  protected void addClientsLayout(){

  }

  /**
   * ダミー上に内部項目を追加します。
   */
  protected void addDummyNorth(){

  }

  /**
   * ダミー左に内部項目を追加します。
   */
  protected void addDummyWest(){

  }

  /**
   * ダミー右に内部項目を追加します。
   */
  protected void addDummyEast(){

  }

  /**
   * ダミー下に内部項目を追加します。
   */
  protected void addDummySouth(){

  }

  /**
   * メイン領域に内部項目を追加します。
   */
  protected void addMains(){

    mains.add(getControls(), VRLayout.CLIENT);

  }

  /**
   * コントロール領域に内部項目を追加します。
   */
  protected void addControls(){

    controls.add(getSubTitle(), VRLayout.NORTH);

    controls.add(getDummyMargin(), VRLayout.NORTH);

    controls.add(getCombos(), VRLayout.NORTH);

    controls.add(getBottoms(), VRLayout.SOUTH);
    controls.add(getInformations(), VRLayout.SOUTH);
  }

  /**
   * サブタイトルに内部項目を追加します。
   */
  protected void addSubTitle(){

  }

  /**
   * マージンに内部項目を追加します。
   */
  protected void addDummyMargin(){

  }

  /**
   * コンボ領域に内部項目を追加します。
   */
  protected void addCombos(){

    combos.add(getProviderListContainer(), VRLayout.FLOW);

    combos.add(getSystemDateContainer(), VRLayout.FLOW_RETURN);

  }

  /**
   * 自事業所一覧に内部項目を追加します。
   */
  protected void addProviderList(){

  }

  /**
   * 自事業所一覧モデルに内部項目を追加します。
   */
  protected void addProviderListModel(){

  }

  /**
   * システム日付に内部項目を追加します。
   */
  protected void addSystemDate(){

  }

  /**
   * 情報領域に内部項目を追加します。
   */
  protected void addInformations(){

    informations.add(getVersionErros(), VRLayout.NORTH);

    informations.add(getDbErros(), VRLayout.NORTH);

    informations.add(getNoProviders(), VRLayout.NORTH);

    informations.add(getShareDBs(), VRLayout.NORTH);

    informations.add(getNoInsurers(), VRLayout.NORTH);

    informations.add(getNoPatients(), VRLayout.NORTH);

    informations.add(getNoPDFViewers(), VRLayout.NORTH);

    informations.add(getNoErrors(), VRLayout.NORTH);

    informations.add(getEnvironments(), VRLayout.CLIENT);

  }

  /**
   * システムバージョンエラーに内部項目を追加します。
   */
  protected void addVersionErros(){

    versionErros.add(getVersionError(), VRLayout.CLIENT);

  }

  /**
   * システムバージョンエラーメッセージに内部項目を追加します。
   */
  protected void addVersionError(){

  }

  /**
   * DBエラーに内部項目を追加します。
   */
  protected void addDbErros(){

    dbErros.add(getDbConnectionError(), VRLayout.CLIENT);

    dbErros.add(getDbmsError(), VRLayout.CLIENT);

    dbErros.add(getDbVersionError(), VRLayout.CLIENT);

    dbErros.add(getGoSettingButtons1(), VRLayout.EAST);
  }

  /**
   * DB接続エラーメッセージに内部項目を追加します。
   */
  protected void addDbConnectionError(){

  }

  /**
   * DBMS非対応エラーメッセージに内部項目を追加します。
   */
  protected void addDbmsError(){

  }

  /**
   * DBバージョンエラーメッセージに内部項目を追加します。
   */
  protected void addDbVersionError(){

  }

  /**
   * 遷移ボタン領域に内部項目を追加します。
   */
  protected void addGoSettingButtons1(){

    goSettingButtons1.add(getGoSetting1(), VRLayout.FLOW);

  }

  /**
   * 設定変更遷移ボタンに内部項目を追加します。
   */
  protected void addGoSetting1(){

  }

  /**
   * 自事業所なしに内部項目を追加します。
   */
  protected void addNoProviders(){

    noProviders.add(getNoPropvider(), VRLayout.CLIENT);

    noProviders.add(getGoProviderButtons(), VRLayout.EAST);
  }

  /**
   * 自事業所なしメッセージに内部項目を追加します。
   */
  protected void addNoPropvider(){

  }

  /**
   * 遷移ボタン領域に内部項目を追加します。
   */
  protected void addGoProviderButtons(){

    goProviderButtons.add(getGoProvider(), VRLayout.FLOW);

  }

  /**
   * 事業所登録遷移ボタンに内部項目を追加します。
   */
  protected void addGoProvider(){

  }

  /**
   * DB共有確認に内部項目を追加します。
   */
  protected void addShareDBs(){

    shareDBs.add(getShareDB(), VRLayout.CLIENT);

    shareDBs.add(getGoSettingButtons3(), VRLayout.EAST);
  }

  /**
   * DB共有確認メッセージに内部項目を追加します。
   */
  protected void addShareDB(){

  }

  /**
   * 遷移ボタン領域に内部項目を追加します。
   */
  protected void addGoSettingButtons3(){

    goSettingButtons3.add(getGoSetting3(), VRLayout.FLOW);

  }

  /**
   * 設定変更遷移ボタンに内部項目を追加します。
   */
  protected void addGoSetting3(){

  }

  /**
   * 保険者なしに内部項目を追加します。
   */
  protected void addNoInsurers(){

    noInsurers.add(getNoInsurer(), VRLayout.CLIENT);

    noInsurers.add(getGoInsurerButtons(), VRLayout.EAST);
  }

  /**
   * 保険者なしメッセージに内部項目を追加します。
   */
  protected void addNoInsurer(){

  }

  /**
   * 遷移ボタン領域に内部項目を追加します。
   */
  protected void addGoInsurerButtons(){

    goInsurerButtons.add(getGoInsurer(), VRLayout.FLOW);

  }

  /**
   * 保険者登録遷移ボタンに内部項目を追加します。
   */
  protected void addGoInsurer(){

  }

  /**
   * 利用者なしに内部項目を追加します。
   */
  protected void addNoPatients(){

    noPatients.add(getNoPatient(), VRLayout.CLIENT);

    noPatients.add(getGoPatientButtons(), VRLayout.EAST);
  }

  /**
   * 利用者なしメッセージに内部項目を追加します。
   */
  protected void addNoPatient(){

  }

  /**
   * 遷移ボタン領域に内部項目を追加します。
   */
  protected void addGoPatientButtons(){

    goPatientButtons.add(getGoPatient(), VRLayout.FLOW);

  }

  /**
   * 利用者登録遷移ボタンに内部項目を追加します。
   */
  protected void addGoPatient(){

  }

  /**
   * PDFビューワなしに内部項目を追加します。
   */
  protected void addNoPDFViewers(){

    noPDFViewers.add(getNoPDFViewer(), VRLayout.CLIENT);

    noPDFViewers.add(getGoSettingButtons2(), VRLayout.EAST);
  }

  /**
   * PDFビューワなしメッセージに内部項目を追加します。
   */
  protected void addNoPDFViewer(){

  }

  /**
   * 遷移ボタン領域に内部項目を追加します。
   */
  protected void addGoSettingButtons2(){

    goSettingButtons2.add(getGoSetting2(), VRLayout.FLOW);

  }

  /**
   * 設定変更遷移ボタンに内部項目を追加します。
   */
  protected void addGoSetting2(){

  }

  /**
   * 正常起動に内部項目を追加します。
   */
  protected void addNoErrors(){

    noErrors.add(getNoError(), VRLayout.CLIENT);

  }

  /**
   * 正常起動メッセージに内部項目を追加します。
   */
  protected void addNoError(){

  }

  /**
   * 環境情報に内部項目を追加します。
   */
  protected void addEnvironments(){

    environments.add(getEnvironment(), VRLayout.CLIENT);

  }

  /**
   * 環境情報詳細に内部項目を追加します。
   */
  protected void addEnvironment(){

  }

  /**
   * ボタン領域に内部項目を追加します。
   */
  protected void addBottoms(){

    bottoms.add(getShowVersion(), VRLayout.WEST);

    bottoms.add(getEnd(), VRLayout.EAST);
    bottoms.add(getStart(), VRLayout.EAST);
  }

  /**
   * バージョン情報表示ボタンに内部項目を追加します。
   */
  protected void addShowVersion(){

  }

  /**
   * 開始に内部項目を追加します。
   */
  protected void addStart(){

  }

  /**
   * 終了に内部項目を追加します。
   */
  protected void addEnd(){

  }

  /**
   * コピーライト領域に内部項目を追加します。
   */
  protected void addCopyrights(){

    copyrights.add(getCopyright(), VRLayout.EAST);
  }

  /**
   * コピーライトに内部項目を追加します。
   */
  protected void addCopyright(){

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

    return getProviderList();

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    try {
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QM001Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QM001Design getThis() {
    return this;
  }
}
