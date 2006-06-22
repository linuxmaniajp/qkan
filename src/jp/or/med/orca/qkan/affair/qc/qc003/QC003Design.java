
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
 * 開発者: 樋口 雅彦
 * 作成日: 2006/04/04  日本コンピューター株式会社 樋口 雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 帳票管理 (C)
 * プロセス 訪問看護の情報提供書 (003)
 * プログラム 訪問看護の情報提供書 (QC003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qc.qc003;
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
 * 訪問看護の情報提供書画面項目デザイン(QC003) 
 */
public class QC003Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton open;

  private ACAffairButton insert;

  private ACAffairButton update;

  private ACAffairButton print;

  private ACPanel contents;

  private ACPanel infos;

  private ACTextField infoTheOffer;

  private ACLabelContainer infoTheOfferContainer;

  private QkanDateTextField resultDay;

  private ACLabelContainer resultDayContainer;

  private ACPanel patients;

  private ACGroupBox patient;

  private ACTextField patientName;

  private ACLabelContainer patientNameContainer;

  private ACTextField patientSex;

  private ACLabelContainer patientSexContainer;

  private ACLabelContainer patientBirths;

  private QkanDateTextField patientBirth;

  private ACTextField patientAge;

  private ACLabel patientAgeLabel;

  private ACTextField patientJob;

  private ACLabelContainer patientJobContainer;

  private ACTextField patientAddress;

  private ACLabelContainer patientAddressContainer;

  private ACLabelContainer patientTels;

  private ACTextField patientTel1;

  private ACLabel patientTelLabel1;

  private ACTextField patientTel2;

  private ACLabel patientTelLabel2;

  private ACTextField patientTel3;

  private ACValueArrayRadioButtonGroup patientYokaigodo;

  private ACLabelContainer patientYokaigodoContainer;

  private ACListModelAdapter patientYokaigodoModel;

  private ACRadioButtonItem yokaigodoRadio1;

  private ACRadioButtonItem yokaigodoRadio2;

  private ACRadioButtonItem yokaigodoRadio3;

  private ACRadioButtonItem yokaigodoRadio4;

  private ACRadioButtonItem yokaigodoRadio5;

  private ACRadioButtonItem yokaigodoRadio6;

  private ACRadioButtonItem yokaigodoRadio7;

  private ACRadioButtonItem yokaigodoRadio8;

  private ACRadioButtonItem yokaigodoRadio9;

  private ACTextField patientDiseaseName;

  private ACLabelContainer patientDiseaseNameContainer;

  private ACPanel providers;

  private ACGroupBox provider;

  private ACComboBox providerName;

  private ACLabelContainer providerNameContainer;

  private ACComboBoxModelAdapter providerNameModel;

  private ACTextField providerAdderess;

  private ACLabelContainer providerAdderessContainer;

  private ACLabelContainer providerTels;

  private ACTextField providerTel1;

  private ACLabel providerLabel1;

  private ACTextField providerTel2;

  private ACLabel providerLabel2;

  private ACTextField providerTel3;

  private ACTextField providarAdministrator;

  private ACLabelContainer providarAdministratorContainer;

  private JTabbedPane tabs;

  private ACPanel points1;

  private ACGroupBox syujis;

  private ACTextField syujiName;

  private ACLabelContainer syujiNameContainer;

  private ACTextField syujiAddress;

  private ACLabelContainer syujiAddressContainer;

  private ACGroupBox nichijokatsudoStates;

  private ACPanel nichijokatsudoStateLeft;

  private ACValueArrayRadioButtonGroup moves;

  private ACLabelContainer movesContainer;

  private ACListModelAdapter movesModel;

  private ACRadioButtonItem moveRadioItem1;

  private ACRadioButtonItem moveRadioItem2;

  private ACRadioButtonItem moveRadioItem3;

  private ACValueArrayRadioButtonGroup excretes;

  private ACLabelContainer excretesContainer;

  private ACListModelAdapter excretesModel;

  private ACRadioButtonItem excreteRadioItem1;

  private ACRadioButtonItem excreteRadioItem2;

  private ACRadioButtonItem excreteRadioItem3;

  private ACValueArrayRadioButtonGroup changeClothes;

  private ACLabelContainer changeClothesContainer;

  private ACListModelAdapter changeClothesModel;

  private ACRadioButtonItem changeClothesRadioItem1;

  private ACRadioButtonItem changeClothesRadioItem2;

  private ACRadioButtonItem changeClothesRadioItem3;

  private ACPanel nichijokatsudoStateRight;

  private ACValueArrayRadioButtonGroup meal;

  private ACLabelContainer mealContainer;

  private ACListModelAdapter mealModel;

  private ACRadioButtonItem mealRadioItem1;

  private ACRadioButtonItem mealRadioItem2;

  private ACRadioButtonItem mealRadioItem3;

  private ACValueArrayRadioButtonGroup bath;

  private ACLabelContainer bathContainer;

  private ACListModelAdapter bathModel;

  private ACRadioButtonItem bathRadioItem1;

  private ACRadioButtonItem bathRadioItem2;

  private ACRadioButtonItem bathRadioItem3;

  private ACValueArrayRadioButtonGroup seiyo;

  private ACLabelContainer seiyoContainer;

  private ACListModelAdapter seiyoModel;

  private ACRadioButtonItem seiyoRadioItem1;

  private ACRadioButtonItem seiyoRadioItem2;

  private ACRadioButtonItem seiyoRadioItem3;

  private ACPanel points2;

  private ACGroupBox byojoAndShogais;

  private ACTextArea byojoAndShogai;

  private ACLabelContainer byojoAndShogaiContainer;

  private ACGroupBox homonkaisus;

  private ACTextField homonkaisuDay;

  private ACLabelContainer homonkaisuDayContainer;

  private ACTextField homonkaisuCount;

  private ACLabelContainer homonkaisuCountContainer;

  private ACLabel homonkaisuCaption;

  private ACGroupBox kangoContents;

  private ACTextArea kangoContent;

  private ACLabelContainer kangoContentContainer;

  private ACPanel points3;

  private ACGroupBox needHokenfukushiServices;

  private ACTextArea needHokenfukushiService;

  private ACLabelContainer needHokenfukushiServiceContainer;

  private ACGroupBox extraTokijikos;

  private ACTextArea extraTokijiko;

  private ACLabelContainer extraTokijikoContainer;

  //getter

  /**
   * ボタンバーを取得します。
   * @return ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("訪問看護の情報提供書");

      addButtons();
    }
    return buttons;

  }

  /**
   * 前回読込を取得します。
   * @return 前回読込
   */
  public ACAffairButton getOpen(){
    if(open==null){

      open = new ACAffairButton();

      open.setText("前回読込(O)");

      open.setToolTipText("過去のデータの中で、最新のデータを読み込みます。");

      open.setMnemonic('O');

      open.setIconPath(ACConstants.ICON_PATH_OPEN_24);

      addOpen();
    }
    return open;

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
   * 印刷を取得します。
   * @return 印刷
   */
  public ACAffairButton getPrint(){
    if(print==null){

      print = new ACAffairButton();

      print.setText("印刷(P)");

      print.setToolTipText("「訪問看護の情報提供所」を印刷します。");

      print.setMnemonic('P');

      print.setIconPath(ACConstants.ICON_PATH_PRINT_24);

      addPrint();
    }
    return print;

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
   * 情報領域を取得します。
   * @return 情報領域
   */
  public ACPanel getInfos(){
    if(infos==null){

      infos = new ACPanel();

      addInfos();
    }
    return infos;

  }

  /**
   * 情報提供先を取得します。
   * @return 情報提供先
   */
  public ACTextField getInfoTheOffer(){
    if(infoTheOffer==null){

      infoTheOffer = new ACTextField();

      getInfoTheOfferContainer().setText("情報提供先");

      infoTheOffer.setBindPath("JOHO_TEIKYO_SAKI");

      infoTheOffer.setColumns(12);

      infoTheOffer.setIMEMode(InputSubset.KANJI);

      infoTheOffer.setMaxLength(12);

      addInfoTheOffer();
    }
    return infoTheOffer;

  }

  /**
   * 情報提供先コンテナを取得します。
   * @return 情報提供先コンテナ
   */
  protected ACLabelContainer getInfoTheOfferContainer(){
    if(infoTheOfferContainer==null){
      infoTheOfferContainer = new ACLabelContainer();
      infoTheOfferContainer.setFollowChildEnabled(true);
      infoTheOfferContainer.setVAlignment(VRLayout.CENTER);
      infoTheOfferContainer.add(getInfoTheOffer(), null);
    }
    return infoTheOfferContainer;
  }

  /**
   * 実施日を取得します。
   * @return 実施日
   */
  public QkanDateTextField getResultDay(){
    if(resultDay==null){

      resultDay = new QkanDateTextField();

      getResultDayContainer().setText("実施日");

      resultDay.setBindPath("CREATE_DATE");

      addResultDay();
    }
    return resultDay;

  }

  /**
   * 実施日コンテナを取得します。
   * @return 実施日コンテナ
   */
  protected ACLabelContainer getResultDayContainer(){
    if(resultDayContainer==null){
      resultDayContainer = new ACLabelContainer();
      resultDayContainer.setFollowChildEnabled(true);
      resultDayContainer.setVAlignment(VRLayout.CENTER);
      resultDayContainer.add(getResultDay(), null);
    }
    return resultDayContainer;
  }

  /**
   * 利用者領域を取得します。
   * @return 利用者領域
   */
  public ACPanel getPatients(){
    if(patients==null){

      patients = new ACPanel();

      addPatients();
    }
    return patients;

  }

  /**
   * 利用者領域を取得します。
   * @return 利用者領域
   */
  public ACGroupBox getPatient(){
    if(patient==null){

      patient = new ACGroupBox();

      patient.setText("利用者");

      patient.setAutoWrap(false);

      patient.setHgap(1);

      patient.setLabelMargin(1);

      addPatient();
    }
    return patient;

  }

  /**
   * 利用者氏名を取得します。
   * @return 利用者氏名
   */
  public ACTextField getPatientName(){
    if(patientName==null){

      patientName = new ACTextField();

      getPatientNameContainer().setText("氏名");

      patientName.setBindPath("PATIENT_FULL_NAME");

      patientName.setEditable(false);

      patientName.setColumns(25);

      patientName.setMaxLength(24);

      addPatientName();
    }
    return patientName;

  }

  /**
   * 利用者氏名コンテナを取得します。
   * @return 利用者氏名コンテナ
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
   * 利用者性別を取得します。
   * @return 利用者性別
   */
  public ACTextField getPatientSex(){
    if(patientSex==null){

      patientSex = new ACTextField();

      getPatientSexContainer().setText("性別");

      patientSex.setBindPath("PATIENT_SEX");

      patientSex.setEditable(false);

      patientSex.setColumns(2);

      patientSex.setFormat(QkanConstants.FORMAT_SEX);

      patientSex.setMaxLength(2);

      addPatientSex();
    }
    return patientSex;

  }

  /**
   * 利用者性別コンテナを取得します。
   * @return 利用者性別コンテナ
   */
  protected ACLabelContainer getPatientSexContainer(){
    if(patientSexContainer==null){
      patientSexContainer = new ACLabelContainer();
      patientSexContainer.setFollowChildEnabled(true);
      patientSexContainer.setVAlignment(VRLayout.CENTER);
      patientSexContainer.add(getPatientSex(), null);
    }
    return patientSexContainer;
  }

  /**
   * 利用者生年月日・コンテナを取得します。
   * @return 利用者生年月日・コンテナ
   */
  public ACLabelContainer getPatientBirths(){
    if(patientBirths==null){

      patientBirths = new ACLabelContainer();

      patientBirths.setText("生年月日");

      addPatientBirths();
    }
    return patientBirths;

  }

  /**
   * 利用者生年月日を取得します。
   * @return 利用者生年月日
   */
  public QkanDateTextField getPatientBirth(){
    if(patientBirth==null){

      patientBirth = new QkanDateTextField();

      patientBirth.setBindPath("PATIENT_BIRTHDAY");

      patientBirth.setEditable(false);

      addPatientBirth();
    }
    return patientBirth;

  }

  /**
   * 利用者年齢を取得します。
   * @return 利用者年齢
   */
  public ACTextField getPatientAge(){
    if(patientAge==null){

      patientAge = new ACTextField();

      patientAge.setBindPath("PATIENT_BIRTHDAY");

      patientAge.setEditable(false);

      patientAge.setFormat(QkanConstants.FORMAT_NOW_AGE);

      patientAge.setMaxLength(4);

      addPatientAge();
    }
    return patientAge;

  }

  /**
   * 歳を取得します。
   * @return 歳
   */
  public ACLabel getPatientAgeLabel(){
    if(patientAgeLabel==null){

      patientAgeLabel = new ACLabel();

      patientAgeLabel.setText("歳");

      addPatientAgeLabel();
    }
    return patientAgeLabel;

  }

  /**
   * 利用者職業を取得します。
   * @return 利用者職業
   */
  public ACTextField getPatientJob(){
    if(patientJob==null){

      patientJob = new ACTextField();

      getPatientJobContainer().setText("職業");

      patientJob.setBindPath("PATIENT_JOB");

      patientJob.setColumns(10);

      patientJob.setIMEMode(InputSubset.KANJI);

      patientJob.setMaxLength(10);

      addPatientJob();
    }
    return patientJob;

  }

  /**
   * 利用者職業コンテナを取得します。
   * @return 利用者職業コンテナ
   */
  protected ACLabelContainer getPatientJobContainer(){
    if(patientJobContainer==null){
      patientJobContainer = new ACLabelContainer();
      patientJobContainer.setFollowChildEnabled(true);
      patientJobContainer.setVAlignment(VRLayout.CENTER);
      patientJobContainer.add(getPatientJob(), null);
    }
    return patientJobContainer;
  }

  /**
   * 利用者住所を取得します。
   * @return 利用者住所
   */
  public ACTextField getPatientAddress(){
    if(patientAddress==null){

      patientAddress = new ACTextField();

      getPatientAddressContainer().setText("住所");

      patientAddress.setBindPath("PATIENT_ADDRESS");

      patientAddress.setEditable(false);

      patientAddress.setColumns(40);

      patientAddress.setMaxLength(40);

      addPatientAddress();
    }
    return patientAddress;

  }

  /**
   * 利用者住所コンテナを取得します。
   * @return 利用者住所コンテナ
   */
  protected ACLabelContainer getPatientAddressContainer(){
    if(patientAddressContainer==null){
      patientAddressContainer = new ACLabelContainer();
      patientAddressContainer.setFollowChildEnabled(true);
      patientAddressContainer.setVAlignment(VRLayout.CENTER);
      patientAddressContainer.add(getPatientAddress(), null);
    }
    return patientAddressContainer;
  }

  /**
   * 利用者電話番号・コンテナを取得します。
   * @return 利用者電話番号・コンテナ
   */
  public ACLabelContainer getPatientTels(){
    if(patientTels==null){

      patientTels = new ACLabelContainer();

      patientTels.setText("電話番号");

      addPatientTels();
    }
    return patientTels;

  }

  /**
   * 利用者電話番号1を取得します。
   * @return 利用者電話番号1
   */
  public ACTextField getPatientTel1(){
    if(patientTel1==null){

      patientTel1 = new ACTextField();

      patientTel1.setBindPath("PATIENT_TEL_FIRST");

      patientTel1.setEditable(false);

      patientTel1.setColumns(4);

      patientTel1.setMaxLength(6);

      addPatientTel1();
    }
    return patientTel1;

  }

  /**
   * 利用ラベル1を取得します。
   * @return 利用ラベル1
   */
  public ACLabel getPatientTelLabel1(){
    if(patientTelLabel1==null){

      patientTelLabel1 = new ACLabel();

      patientTelLabel1.setText("-");

      addPatientTelLabel1();
    }
    return patientTelLabel1;

  }

  /**
   * 利用者電話番号2を取得します。
   * @return 利用者電話番号2
   */
  public ACTextField getPatientTel2(){
    if(patientTel2==null){

      patientTel2 = new ACTextField();

      patientTel2.setBindPath("PATIENT_TEL_SECOND");

      patientTel2.setEditable(false);

      patientTel2.setColumns(4);

      patientTel2.setMaxLength(4);

      addPatientTel2();
    }
    return patientTel2;

  }

  /**
   * 利用者ラベル2を取得します。
   * @return 利用者ラベル2
   */
  public ACLabel getPatientTelLabel2(){
    if(patientTelLabel2==null){

      patientTelLabel2 = new ACLabel();

      patientTelLabel2.setText("-");

      addPatientTelLabel2();
    }
    return patientTelLabel2;

  }

  /**
   * 利用者電話番号3を取得します。
   * @return 利用者電話番号3
   */
  public ACTextField getPatientTel3(){
    if(patientTel3==null){

      patientTel3 = new ACTextField();

      patientTel3.setBindPath("PATIENT_TEL_THIRD");

      patientTel3.setEditable(false);

      patientTel3.setColumns(4);

      patientTel3.setMaxLength(4);

      addPatientTel3();
    }
    return patientTel3;

  }

  /**
   * 利用者要介護認定を取得します。
   * @return 利用者要介護認定
   */
  public ACValueArrayRadioButtonGroup getPatientYokaigodo(){
    if(patientYokaigodo==null){

      patientYokaigodo = new ACValueArrayRadioButtonGroup();

      getPatientYokaigodoContainer().setText("要介護認定");

      patientYokaigodo.setBindPath("JOTAI_CODE");

      patientYokaigodo.setNoSelectIndex(0);

      patientYokaigodo.setUseClearButton(false);

      patientYokaigodo.setModel(getPatientYokaigodoModel());

      patientYokaigodo.setValues(new int[]{1,12,13,11,21,22,23,24,25});

      addPatientYokaigodo();
    }
    return patientYokaigodo;

  }

  /**
   * 利用者要介護認定コンテナを取得します。
   * @return 利用者要介護認定コンテナ
   */
  protected ACLabelContainer getPatientYokaigodoContainer(){
    if(patientYokaigodoContainer==null){
      patientYokaigodoContainer = new ACLabelContainer();
      patientYokaigodoContainer.setFollowChildEnabled(true);
      patientYokaigodoContainer.setVAlignment(VRLayout.CENTER);
      patientYokaigodoContainer.add(getPatientYokaigodo(), null);
    }
    return patientYokaigodoContainer;
  }

  /**
   * 利用者要介護認定モデルを取得します。
   * @return 利用者要介護認定モデル
   */
  protected ACListModelAdapter getPatientYokaigodoModel(){
    if(patientYokaigodoModel==null){
      patientYokaigodoModel = new ACListModelAdapter();
      addPatientYokaigodoModel();
    }
    return patientYokaigodoModel;
  }

  /**
   * 自立を取得します。
   * @return 自立
   */
  public ACRadioButtonItem getYokaigodoRadio1(){
    if(yokaigodoRadio1==null){

      yokaigodoRadio1 = new ACRadioButtonItem();

      yokaigodoRadio1.setText("自立");

      yokaigodoRadio1.setGroup(getPatientYokaigodo());

      yokaigodoRadio1.setConstraints(VRLayout.FLOW);

      addYokaigodoRadio1();
    }
    return yokaigodoRadio1;

  }

  /**
   * 要支援1を取得します。
   * @return 要支援1
   */
  public ACRadioButtonItem getYokaigodoRadio2(){
    if(yokaigodoRadio2==null){

      yokaigodoRadio2 = new ACRadioButtonItem();

      yokaigodoRadio2.setText("要支援1");

      yokaigodoRadio2.setGroup(getPatientYokaigodo());

      yokaigodoRadio2.setConstraints(VRLayout.FLOW);

      addYokaigodoRadio2();
    }
    return yokaigodoRadio2;

  }

  /**
   * 要支援2を取得します。
   * @return 要支援2
   */
  public ACRadioButtonItem getYokaigodoRadio3(){
    if(yokaigodoRadio3==null){

      yokaigodoRadio3 = new ACRadioButtonItem();

      yokaigodoRadio3.setText("要支援2");

      yokaigodoRadio3.setGroup(getPatientYokaigodo());

      yokaigodoRadio3.setConstraints(VRLayout.FLOW_RETURN);

      addYokaigodoRadio3();
    }
    return yokaigodoRadio3;

  }

  /**
   * 経過的要介護を取得します。
   * @return 経過的要介護
   */
  public ACRadioButtonItem getYokaigodoRadio4(){
    if(yokaigodoRadio4==null){

      yokaigodoRadio4 = new ACRadioButtonItem();

      yokaigodoRadio4.setText("経過的要介護");

      yokaigodoRadio4.setGroup(getPatientYokaigodo());

      yokaigodoRadio4.setConstraints(VRLayout.FLOW);

      addYokaigodoRadio4();
    }
    return yokaigodoRadio4;

  }

  /**
   * 要介護1を取得します。
   * @return 要介護1
   */
  public ACRadioButtonItem getYokaigodoRadio5(){
    if(yokaigodoRadio5==null){

      yokaigodoRadio5 = new ACRadioButtonItem();

      yokaigodoRadio5.setText("要介護1");

      yokaigodoRadio5.setGroup(getPatientYokaigodo());

      yokaigodoRadio5.setConstraints(VRLayout.FLOW);

      addYokaigodoRadio5();
    }
    return yokaigodoRadio5;

  }

  /**
   * 要介護2を取得します。
   * @return 要介護2
   */
  public ACRadioButtonItem getYokaigodoRadio6(){
    if(yokaigodoRadio6==null){

      yokaigodoRadio6 = new ACRadioButtonItem();

      yokaigodoRadio6.setText("要介護2");

      yokaigodoRadio6.setGroup(getPatientYokaigodo());

      yokaigodoRadio6.setConstraints(VRLayout.FLOW);

      addYokaigodoRadio6();
    }
    return yokaigodoRadio6;

  }

  /**
   * 要介護3を取得します。
   * @return 要介護3
   */
  public ACRadioButtonItem getYokaigodoRadio7(){
    if(yokaigodoRadio7==null){

      yokaigodoRadio7 = new ACRadioButtonItem();

      yokaigodoRadio7.setText("要介護3");

      yokaigodoRadio7.setGroup(getPatientYokaigodo());

      yokaigodoRadio7.setConstraints(VRLayout.FLOW);

      addYokaigodoRadio7();
    }
    return yokaigodoRadio7;

  }

  /**
   * 要介護4を取得します。
   * @return 要介護4
   */
  public ACRadioButtonItem getYokaigodoRadio8(){
    if(yokaigodoRadio8==null){

      yokaigodoRadio8 = new ACRadioButtonItem();

      yokaigodoRadio8.setText("要介護4");

      yokaigodoRadio8.setGroup(getPatientYokaigodo());

      yokaigodoRadio8.setConstraints(VRLayout.FLOW);

      addYokaigodoRadio8();
    }
    return yokaigodoRadio8;

  }

  /**
   * 要介護5を取得します。
   * @return 要介護5
   */
  public ACRadioButtonItem getYokaigodoRadio9(){
    if(yokaigodoRadio9==null){

      yokaigodoRadio9 = new ACRadioButtonItem();

      yokaigodoRadio9.setText("要介護5");

      yokaigodoRadio9.setGroup(getPatientYokaigodo());

      yokaigodoRadio9.setConstraints(VRLayout.FLOW);

      addYokaigodoRadio9();
    }
    return yokaigodoRadio9;

  }

  /**
   * 利用者主傷病名を取得します。
   * @return 利用者主傷病名
   */
  public ACTextField getPatientDiseaseName(){
    if(patientDiseaseName==null){

      patientDiseaseName = new ACTextField();

      getPatientDiseaseNameContainer().setText("主傷病名");

      patientDiseaseName.setBindPath("DISEASE");

      patientDiseaseName.setColumns(35);

      patientDiseaseName.setIMEMode(InputSubset.KANJI);

      patientDiseaseName.setMaxLength(35);

      addPatientDiseaseName();
    }
    return patientDiseaseName;

  }

  /**
   * 利用者主傷病名コンテナを取得します。
   * @return 利用者主傷病名コンテナ
   */
  protected ACLabelContainer getPatientDiseaseNameContainer(){
    if(patientDiseaseNameContainer==null){
      patientDiseaseNameContainer = new ACLabelContainer();
      patientDiseaseNameContainer.setFollowChildEnabled(true);
      patientDiseaseNameContainer.setVAlignment(VRLayout.CENTER);
      patientDiseaseNameContainer.add(getPatientDiseaseName(), null);
    }
    return patientDiseaseNameContainer;
  }

  /**
   * 事業所領域を取得します。
   * @return 事業所領域
   */
  public ACPanel getProviders(){
    if(providers==null){

      providers = new ACPanel();

      addProviders();
    }
    return providers;

  }

  /**
   * 事業所領域を取得します。
   * @return 事業所領域
   */
  public ACGroupBox getProvider(){
    if(provider==null){

      provider = new ACGroupBox();

      provider.setText("訪問看護ステーション");

      provider.setHgap(1);

      provider.setLabelMargin(1);

      addProvider();
    }
    return provider;

  }

  /**
   * 事業所名称を取得します。
   * @return 事業所名称
   */
  public ACComboBox getProviderName(){
    if(providerName==null){

      providerName = new ACComboBox();

      getProviderNameContainer().setText("名称");

      providerName.setBindPath("PROVIDER_NAME");

      providerName.setEditable(true);

      providerName.setColumns(18);

      providerName.setRenderBindPath("PROVIDER_NAME");

      providerName.setBlankable(false);

      providerName.setIMEMode(InputSubset.KANJI);

      providerName.setMaxLength(63);

      providerName.setModel(getProviderNameModel());

      addProviderName();
    }
    return providerName;

  }

  /**
   * 事業所名称コンテナを取得します。
   * @return 事業所名称コンテナ
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
   * 事業所名称モデルを取得します。
   * @return 事業所名称モデル
   */
  protected ACComboBoxModelAdapter getProviderNameModel(){
    if(providerNameModel==null){
      providerNameModel = new ACComboBoxModelAdapter();
      addProviderNameModel();
    }
    return providerNameModel;
  }

  /**
   * 事業所所在地を取得します。
   * @return 事業所所在地
   */
  public ACTextField getProviderAdderess(){
    if(providerAdderess==null){

      providerAdderess = new ACTextField();

      getProviderAdderessContainer().setText("所在地");

      providerAdderess.setBindPath("PROVIDER_ADDRESS");

      providerAdderess.setColumns(40);

      providerAdderess.setIMEMode(InputSubset.KANJI);

      providerAdderess.setMaxLength(40);

      addProviderAdderess();
    }
    return providerAdderess;

  }

  /**
   * 事業所所在地コンテナを取得します。
   * @return 事業所所在地コンテナ
   */
  protected ACLabelContainer getProviderAdderessContainer(){
    if(providerAdderessContainer==null){
      providerAdderessContainer = new ACLabelContainer();
      providerAdderessContainer.setFollowChildEnabled(true);
      providerAdderessContainer.setVAlignment(VRLayout.CENTER);
      providerAdderessContainer.add(getProviderAdderess(), null);
    }
    return providerAdderessContainer;
  }

  /**
   * 事業所電話番号を取得します。
   * @return 事業所電話番号
   */
  public ACLabelContainer getProviderTels(){
    if(providerTels==null){

      providerTels = new ACLabelContainer();

      providerTels.setText("電話番号");

      addProviderTels();
    }
    return providerTels;

  }

  /**
   * 事業所電話番号1を取得します。
   * @return 事業所電話番号1
   */
  public ACTextField getProviderTel1(){
    if(providerTel1==null){

      providerTel1 = new ACTextField();

      providerTel1.setBindPath("PROVIDER_TEL_FIRST");

      providerTel1.setColumns(4);

      providerTel1.setCharType(VRCharType.ONLY_DIGIT);

      providerTel1.setIMEMode(InputSubset.LATIN);

      providerTel1.setMaxLength(6);

      addProviderTel1();
    }
    return providerTel1;

  }

  /**
   * 事業所ラベル1を取得します。
   * @return 事業所ラベル1
   */
  public ACLabel getProviderLabel1(){
    if(providerLabel1==null){

      providerLabel1 = new ACLabel();

      providerLabel1.setText("-");

      addProviderLabel1();
    }
    return providerLabel1;

  }

  /**
   * 事業所電話番号2を取得します。
   * @return 事業所電話番号2
   */
  public ACTextField getProviderTel2(){
    if(providerTel2==null){

      providerTel2 = new ACTextField();

      providerTel2.setBindPath("PROVIDER_TEL_SECOND");

      providerTel2.setColumns(4);

      providerTel2.setCharType(VRCharType.ONLY_DIGIT);

      providerTel2.setIMEMode(InputSubset.LATIN);

      providerTel2.setMaxLength(4);

      addProviderTel2();
    }
    return providerTel2;

  }

  /**
   * 事業所ラベル2を取得します。
   * @return 事業所ラベル2
   */
  public ACLabel getProviderLabel2(){
    if(providerLabel2==null){

      providerLabel2 = new ACLabel();

      providerLabel2.setText("-");

      addProviderLabel2();
    }
    return providerLabel2;

  }

  /**
   * 事業所電話番号3を取得します。
   * @return 事業所電話番号3
   */
  public ACTextField getProviderTel3(){
    if(providerTel3==null){

      providerTel3 = new ACTextField();

      providerTel3.setBindPath("PROVIDER_TEL_THIRD");

      providerTel3.setColumns(4);

      providerTel3.setCharType(VRCharType.ONLY_DIGIT);

      providerTel3.setIMEMode(InputSubset.LATIN);

      providerTel3.setMaxLength(4);

      addProviderTel3();
    }
    return providerTel3;

  }

  /**
   * 事業所管理者を取得します。
   * @return 事業所管理者
   */
  public ACTextField getProvidarAdministrator(){
    if(providarAdministrator==null){

      providarAdministrator = new ACTextField();

      getProvidarAdministratorContainer().setText("管理者");

      providarAdministrator.setBindPath("PROVIDER_ADMINISTRATOR");

      providarAdministrator.setColumns(20);

      providarAdministrator.setIMEMode(InputSubset.KANJI);

      providarAdministrator.setMaxLength(20);

      addProvidarAdministrator();
    }
    return providarAdministrator;

  }

  /**
   * 事業所管理者コンテナを取得します。
   * @return 事業所管理者コンテナ
   */
  protected ACLabelContainer getProvidarAdministratorContainer(){
    if(providarAdministratorContainer==null){
      providarAdministratorContainer = new ACLabelContainer();
      providarAdministratorContainer.setFollowChildEnabled(true);
      providarAdministratorContainer.setVAlignment(VRLayout.CENTER);
      providarAdministratorContainer.add(getProvidarAdministrator(), null);
    }
    return providarAdministratorContainer;
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
   * 主治医・要介護認定状況・ADL領域を取得します。
   * @return 主治医・要介護認定状況・ADL領域
   */
  public ACPanel getPoints1(){
    if(points1==null){

      points1 = new ACPanel();

      addPoints1();
    }
    return points1;

  }

  /**
   * 主治医領域を取得します。
   * @return 主治医領域
   */
  public ACGroupBox getSyujis(){
    if(syujis==null){

      syujis = new ACGroupBox();

      syujis.setText("主治医");

      syujis.setAutoWrap(false);

      syujis.setHgap(0);

      syujis.setLabelMargin(0);

      addSyujis();
    }
    return syujis;

  }

  /**
   * 主治医氏名を取得します。
   * @return 主治医氏名
   */
  public ACTextField getSyujiName(){
    if(syujiName==null){

      syujiName = new ACTextField();

      getSyujiNameContainer().setText("氏名");

      syujiName.setBindPath("DOCTOR_NAME");

      syujiName.setColumns(25);

      syujiName.setIMEMode(InputSubset.KANJI);

      syujiName.setMaxLength(25);

      addSyujiName();
    }
    return syujiName;

  }

  /**
   * 主治医氏名コンテナを取得します。
   * @return 主治医氏名コンテナ
   */
  protected ACLabelContainer getSyujiNameContainer(){
    if(syujiNameContainer==null){
      syujiNameContainer = new ACLabelContainer();
      syujiNameContainer.setFollowChildEnabled(true);
      syujiNameContainer.setVAlignment(VRLayout.CENTER);
      syujiNameContainer.add(getSyujiName(), null);
    }
    return syujiNameContainer;
  }

  /**
   * 主治医住所を取得します。
   * @return 主治医住所
   */
  public ACTextField getSyujiAddress(){
    if(syujiAddress==null){

      syujiAddress = new ACTextField();

      getSyujiAddressContainer().setText("住所");

      syujiAddress.setBindPath("DOCTOR_ADDRESS");

      syujiAddress.setColumns(40);

      syujiAddress.setIMEMode(InputSubset.KANJI);

      syujiAddress.setMaxLength(40);

      addSyujiAddress();
    }
    return syujiAddress;

  }

  /**
   * 主治医住所コンテナを取得します。
   * @return 主治医住所コンテナ
   */
  protected ACLabelContainer getSyujiAddressContainer(){
    if(syujiAddressContainer==null){
      syujiAddressContainer = new ACLabelContainer();
      syujiAddressContainer.setFollowChildEnabled(true);
      syujiAddressContainer.setVAlignment(VRLayout.CENTER);
      syujiAddressContainer.add(getSyujiAddress(), null);
    }
    return syujiAddressContainer;
  }

  /**
   * 日常生活活動の状況領域を取得します。
   * @return 日常生活活動の状況領域
   */
  public ACGroupBox getNichijokatsudoStates(){
    if(nichijokatsudoStates==null){

      nichijokatsudoStates = new ACGroupBox();

      nichijokatsudoStates.setText("日常生活活動(ADL)の状況");

      addNichijokatsudoStates();
    }
    return nichijokatsudoStates;

  }

  /**
   * 日常生活活動の状況(左領域)を取得します。
   * @return 日常生活活動の状況(左領域)
   */
  public ACPanel getNichijokatsudoStateLeft(){
    if(nichijokatsudoStateLeft==null){

      nichijokatsudoStateLeft = new ACPanel();

      addNichijokatsudoStateLeft();
    }
    return nichijokatsudoStateLeft;

  }

  /**
   * 移動を取得します。
   * @return 移動
   */
  public ACValueArrayRadioButtonGroup getMoves(){
    if(moves==null){

      moves = new ACValueArrayRadioButtonGroup();

      getMovesContainer().setText("移動");

      moves.setBindPath("ADL_MOVE");

      moves.setNoSelectIndex(0);

      moves.setUseClearButton(true);

      moves.setModel(getMovesModel());

      moves.setValues(new int[]{1,2,3});

      addMoves();
    }
    return moves;

  }

  /**
   * 移動コンテナを取得します。
   * @return 移動コンテナ
   */
  protected ACLabelContainer getMovesContainer(){
    if(movesContainer==null){
      movesContainer = new ACLabelContainer();
      movesContainer.setFollowChildEnabled(true);
      movesContainer.setVAlignment(VRLayout.CENTER);
      movesContainer.add(getMoves(), null);
    }
    return movesContainer;
  }

  /**
   * 移動モデルを取得します。
   * @return 移動モデル
   */
  protected ACListModelAdapter getMovesModel(){
    if(movesModel==null){
      movesModel = new ACListModelAdapter();
      addMovesModel();
    }
    return movesModel;
  }

  /**
   * 自立を取得します。
   * @return 自立
   */
  public ACRadioButtonItem getMoveRadioItem1(){
    if(moveRadioItem1==null){

      moveRadioItem1 = new ACRadioButtonItem();

      moveRadioItem1.setText("自立");

      moveRadioItem1.setGroup(getMoves());

      moveRadioItem1.setConstraints(VRLayout.FLOW);

      addMoveRadioItem1();
    }
    return moveRadioItem1;

  }

  /**
   * 一部介助を取得します。
   * @return 一部介助
   */
  public ACRadioButtonItem getMoveRadioItem2(){
    if(moveRadioItem2==null){

      moveRadioItem2 = new ACRadioButtonItem();

      moveRadioItem2.setText("一部介助");

      moveRadioItem2.setGroup(getMoves());

      moveRadioItem2.setConstraints(VRLayout.FLOW);

      addMoveRadioItem2();
    }
    return moveRadioItem2;

  }

  /**
   * 全面介助を取得します。
   * @return 全面介助
   */
  public ACRadioButtonItem getMoveRadioItem3(){
    if(moveRadioItem3==null){

      moveRadioItem3 = new ACRadioButtonItem();

      moveRadioItem3.setText("全面介助");

      moveRadioItem3.setGroup(getMoves());

      moveRadioItem3.setConstraints(VRLayout.FLOW);

      addMoveRadioItem3();
    }
    return moveRadioItem3;

  }

  /**
   * 排泄を取得します。
   * @return 排泄
   */
  public ACValueArrayRadioButtonGroup getExcretes(){
    if(excretes==null){

      excretes = new ACValueArrayRadioButtonGroup();

      getExcretesContainer().setText("排泄");

      excretes.setBindPath("ADL_EXCRETION");

      excretes.setNoSelectIndex(0);

      excretes.setUseClearButton(true);

      excretes.setModel(getExcretesModel());

      excretes.setValues(new int[]{1,2,3});

      addExcretes();
    }
    return excretes;

  }

  /**
   * 排泄コンテナを取得します。
   * @return 排泄コンテナ
   */
  protected ACLabelContainer getExcretesContainer(){
    if(excretesContainer==null){
      excretesContainer = new ACLabelContainer();
      excretesContainer.setFollowChildEnabled(true);
      excretesContainer.setVAlignment(VRLayout.CENTER);
      excretesContainer.add(getExcretes(), null);
    }
    return excretesContainer;
  }

  /**
   * 排泄モデルを取得します。
   * @return 排泄モデル
   */
  protected ACListModelAdapter getExcretesModel(){
    if(excretesModel==null){
      excretesModel = new ACListModelAdapter();
      addExcretesModel();
    }
    return excretesModel;
  }

  /**
   * 自立を取得します。
   * @return 自立
   */
  public ACRadioButtonItem getExcreteRadioItem1(){
    if(excreteRadioItem1==null){

      excreteRadioItem1 = new ACRadioButtonItem();

      excreteRadioItem1.setText("自立");

      excreteRadioItem1.setGroup(getExcretes());

      excreteRadioItem1.setConstraints(VRLayout.FLOW);

      addExcreteRadioItem1();
    }
    return excreteRadioItem1;

  }

  /**
   * 一部介助を取得します。
   * @return 一部介助
   */
  public ACRadioButtonItem getExcreteRadioItem2(){
    if(excreteRadioItem2==null){

      excreteRadioItem2 = new ACRadioButtonItem();

      excreteRadioItem2.setText("一部介助");

      excreteRadioItem2.setGroup(getExcretes());

      excreteRadioItem2.setConstraints(VRLayout.FLOW);

      addExcreteRadioItem2();
    }
    return excreteRadioItem2;

  }

  /**
   * 全面介助を取得します。
   * @return 全面介助
   */
  public ACRadioButtonItem getExcreteRadioItem3(){
    if(excreteRadioItem3==null){

      excreteRadioItem3 = new ACRadioButtonItem();

      excreteRadioItem3.setText("全面介助");

      excreteRadioItem3.setGroup(getExcretes());

      excreteRadioItem3.setConstraints(VRLayout.FLOW);

      addExcreteRadioItem3();
    }
    return excreteRadioItem3;

  }

  /**
   * 着替を取得します。
   * @return 着替
   */
  public ACValueArrayRadioButtonGroup getChangeClothes(){
    if(changeClothes==null){

      changeClothes = new ACValueArrayRadioButtonGroup();

      getChangeClothesContainer().setText("着替");

      changeClothes.setBindPath("ADL_CHANGE_CLOTH");

      changeClothes.setNoSelectIndex(0);

      changeClothes.setUseClearButton(true);

      changeClothes.setModel(getChangeClothesModel());

      changeClothes.setValues(new int[]{1,2,3});

      addChangeClothes();
    }
    return changeClothes;

  }

  /**
   * 着替コンテナを取得します。
   * @return 着替コンテナ
   */
  protected ACLabelContainer getChangeClothesContainer(){
    if(changeClothesContainer==null){
      changeClothesContainer = new ACLabelContainer();
      changeClothesContainer.setFollowChildEnabled(true);
      changeClothesContainer.setVAlignment(VRLayout.CENTER);
      changeClothesContainer.add(getChangeClothes(), null);
    }
    return changeClothesContainer;
  }

  /**
   * 着替モデルを取得します。
   * @return 着替モデル
   */
  protected ACListModelAdapter getChangeClothesModel(){
    if(changeClothesModel==null){
      changeClothesModel = new ACListModelAdapter();
      addChangeClothesModel();
    }
    return changeClothesModel;
  }

  /**
   * 自立を取得します。
   * @return 自立
   */
  public ACRadioButtonItem getChangeClothesRadioItem1(){
    if(changeClothesRadioItem1==null){

      changeClothesRadioItem1 = new ACRadioButtonItem();

      changeClothesRadioItem1.setText("自立");

      changeClothesRadioItem1.setGroup(getChangeClothes());

      changeClothesRadioItem1.setConstraints(VRLayout.FLOW);

      addChangeClothesRadioItem1();
    }
    return changeClothesRadioItem1;

  }

  /**
   * 一部介助を取得します。
   * @return 一部介助
   */
  public ACRadioButtonItem getChangeClothesRadioItem2(){
    if(changeClothesRadioItem2==null){

      changeClothesRadioItem2 = new ACRadioButtonItem();

      changeClothesRadioItem2.setText("一部介助");

      changeClothesRadioItem2.setGroup(getChangeClothes());

      changeClothesRadioItem2.setConstraints(VRLayout.FLOW);

      addChangeClothesRadioItem2();
    }
    return changeClothesRadioItem2;

  }

  /**
   * 全面介助を取得します。
   * @return 全面介助
   */
  public ACRadioButtonItem getChangeClothesRadioItem3(){
    if(changeClothesRadioItem3==null){

      changeClothesRadioItem3 = new ACRadioButtonItem();

      changeClothesRadioItem3.setText("全面介助");

      changeClothesRadioItem3.setGroup(getChangeClothes());

      changeClothesRadioItem3.setConstraints(VRLayout.FLOW);

      addChangeClothesRadioItem3();
    }
    return changeClothesRadioItem3;

  }

  /**
   * 日常生活活動の状況(右領域)を取得します。
   * @return 日常生活活動の状況(右領域)
   */
  public ACPanel getNichijokatsudoStateRight(){
    if(nichijokatsudoStateRight==null){

      nichijokatsudoStateRight = new ACPanel();

      addNichijokatsudoStateRight();
    }
    return nichijokatsudoStateRight;

  }

  /**
   * 食事を取得します。
   * @return 食事
   */
  public ACValueArrayRadioButtonGroup getMeal(){
    if(meal==null){

      meal = new ACValueArrayRadioButtonGroup();

      getMealContainer().setText("食事");

      meal.setBindPath("ADL_FOOD");

      meal.setNoSelectIndex(0);

      meal.setUseClearButton(true);

      meal.setModel(getMealModel());

      meal.setValues(new int[]{1,2,3});

      addMeal();
    }
    return meal;

  }

  /**
   * 食事コンテナを取得します。
   * @return 食事コンテナ
   */
  protected ACLabelContainer getMealContainer(){
    if(mealContainer==null){
      mealContainer = new ACLabelContainer();
      mealContainer.setFollowChildEnabled(true);
      mealContainer.setVAlignment(VRLayout.CENTER);
      mealContainer.add(getMeal(), null);
    }
    return mealContainer;
  }

  /**
   * 食事モデルを取得します。
   * @return 食事モデル
   */
  protected ACListModelAdapter getMealModel(){
    if(mealModel==null){
      mealModel = new ACListModelAdapter();
      addMealModel();
    }
    return mealModel;
  }

  /**
   * 自立を取得します。
   * @return 自立
   */
  public ACRadioButtonItem getMealRadioItem1(){
    if(mealRadioItem1==null){

      mealRadioItem1 = new ACRadioButtonItem();

      mealRadioItem1.setText("自立");

      mealRadioItem1.setGroup(getMeal());

      mealRadioItem1.setConstraints(VRLayout.FLOW);

      addMealRadioItem1();
    }
    return mealRadioItem1;

  }

  /**
   * 一部介助を取得します。
   * @return 一部介助
   */
  public ACRadioButtonItem getMealRadioItem2(){
    if(mealRadioItem2==null){

      mealRadioItem2 = new ACRadioButtonItem();

      mealRadioItem2.setText("一部介助");

      mealRadioItem2.setGroup(getMeal());

      mealRadioItem2.setConstraints(VRLayout.FLOW);

      addMealRadioItem2();
    }
    return mealRadioItem2;

  }

  /**
   * 全面介助を取得します。
   * @return 全面介助
   */
  public ACRadioButtonItem getMealRadioItem3(){
    if(mealRadioItem3==null){

      mealRadioItem3 = new ACRadioButtonItem();

      mealRadioItem3.setText("全面介助");

      mealRadioItem3.setGroup(getMeal());

      mealRadioItem3.setConstraints(VRLayout.FLOW);

      addMealRadioItem3();
    }
    return mealRadioItem3;

  }

  /**
   * 入浴を取得します。
   * @return 入浴
   */
  public ACValueArrayRadioButtonGroup getBath(){
    if(bath==null){

      bath = new ACValueArrayRadioButtonGroup();

      getBathContainer().setText("入浴");

      bath.setBindPath("ADL_BATH");

      bath.setNoSelectIndex(0);

      bath.setUseClearButton(true);

      bath.setModel(getBathModel());

      bath.setValues(new int[]{1,2,3});

      addBath();
    }
    return bath;

  }

  /**
   * 入浴コンテナを取得します。
   * @return 入浴コンテナ
   */
  protected ACLabelContainer getBathContainer(){
    if(bathContainer==null){
      bathContainer = new ACLabelContainer();
      bathContainer.setFollowChildEnabled(true);
      bathContainer.setVAlignment(VRLayout.CENTER);
      bathContainer.add(getBath(), null);
    }
    return bathContainer;
  }

  /**
   * 入浴モデルを取得します。
   * @return 入浴モデル
   */
  protected ACListModelAdapter getBathModel(){
    if(bathModel==null){
      bathModel = new ACListModelAdapter();
      addBathModel();
    }
    return bathModel;
  }

  /**
   * 自立を取得します。
   * @return 自立
   */
  public ACRadioButtonItem getBathRadioItem1(){
    if(bathRadioItem1==null){

      bathRadioItem1 = new ACRadioButtonItem();

      bathRadioItem1.setText("自立");

      bathRadioItem1.setGroup(getBath());

      bathRadioItem1.setConstraints(VRLayout.FLOW);

      addBathRadioItem1();
    }
    return bathRadioItem1;

  }

  /**
   * 一部介助を取得します。
   * @return 一部介助
   */
  public ACRadioButtonItem getBathRadioItem2(){
    if(bathRadioItem2==null){

      bathRadioItem2 = new ACRadioButtonItem();

      bathRadioItem2.setText("一部介助");

      bathRadioItem2.setGroup(getBath());

      bathRadioItem2.setConstraints(VRLayout.FLOW);

      addBathRadioItem2();
    }
    return bathRadioItem2;

  }

  /**
   * 全面介助を取得します。
   * @return 全面介助
   */
  public ACRadioButtonItem getBathRadioItem3(){
    if(bathRadioItem3==null){

      bathRadioItem3 = new ACRadioButtonItem();

      bathRadioItem3.setText("全面介助");

      bathRadioItem3.setGroup(getBath());

      bathRadioItem3.setConstraints(VRLayout.FLOW);

      addBathRadioItem3();
    }
    return bathRadioItem3;

  }

  /**
   * 整容を取得します。
   * @return 整容
   */
  public ACValueArrayRadioButtonGroup getSeiyo(){
    if(seiyo==null){

      seiyo = new ACValueArrayRadioButtonGroup();

      getSeiyoContainer().setText("整容");

      seiyo.setBindPath("ADL_COSMETIC");

      seiyo.setNoSelectIndex(0);

      seiyo.setUseClearButton(true);

      seiyo.setModel(getSeiyoModel());

      seiyo.setValues(new int[]{1,2,3});

      addSeiyo();
    }
    return seiyo;

  }

  /**
   * 整容コンテナを取得します。
   * @return 整容コンテナ
   */
  protected ACLabelContainer getSeiyoContainer(){
    if(seiyoContainer==null){
      seiyoContainer = new ACLabelContainer();
      seiyoContainer.setFollowChildEnabled(true);
      seiyoContainer.setVAlignment(VRLayout.CENTER);
      seiyoContainer.add(getSeiyo(), null);
    }
    return seiyoContainer;
  }

  /**
   * 整容モデルを取得します。
   * @return 整容モデル
   */
  protected ACListModelAdapter getSeiyoModel(){
    if(seiyoModel==null){
      seiyoModel = new ACListModelAdapter();
      addSeiyoModel();
    }
    return seiyoModel;
  }

  /**
   * 自立を取得します。
   * @return 自立
   */
  public ACRadioButtonItem getSeiyoRadioItem1(){
    if(seiyoRadioItem1==null){

      seiyoRadioItem1 = new ACRadioButtonItem();

      seiyoRadioItem1.setText("自立");

      seiyoRadioItem1.setGroup(getSeiyo());

      seiyoRadioItem1.setConstraints(VRLayout.FLOW);

      addSeiyoRadioItem1();
    }
    return seiyoRadioItem1;

  }

  /**
   * 一部介助を取得します。
   * @return 一部介助
   */
  public ACRadioButtonItem getSeiyoRadioItem2(){
    if(seiyoRadioItem2==null){

      seiyoRadioItem2 = new ACRadioButtonItem();

      seiyoRadioItem2.setText("一部介助");

      seiyoRadioItem2.setGroup(getSeiyo());

      seiyoRadioItem2.setConstraints(VRLayout.FLOW);

      addSeiyoRadioItem2();
    }
    return seiyoRadioItem2;

  }

  /**
   * 全面介助を取得します。
   * @return 全面介助
   */
  public ACRadioButtonItem getSeiyoRadioItem3(){
    if(seiyoRadioItem3==null){

      seiyoRadioItem3 = new ACRadioButtonItem();

      seiyoRadioItem3.setText("全面介助");

      seiyoRadioItem3.setGroup(getSeiyo());

      seiyoRadioItem3.setConstraints(VRLayout.FLOW);

      addSeiyoRadioItem3();
    }
    return seiyoRadioItem3;

  }

  /**
   * 病状・障害等の状態領域を取得します。
   * @return 病状・障害等の状態領域
   */
  public ACPanel getPoints2(){
    if(points2==null){

      points2 = new ACPanel();

      addPoints2();
    }
    return points2;

  }

  /**
   * 病状・障害等の状況領域を取得します。
   * @return 病状・障害等の状況領域
   */
  public ACGroupBox getByojoAndShogais(){
    if(byojoAndShogais==null){

      byojoAndShogais = new ACGroupBox();

      byojoAndShogais.setText("病状・障害等の状態(45x2)");

      addByojoAndShogais();
    }
    return byojoAndShogais;

  }

  /**
   * 病状・障害等の状態を取得します。
   * @return 病状・障害等の状態
   */
  public ACTextArea getByojoAndShogai(){
    if(byojoAndShogai==null){

      byojoAndShogai = new ACTextArea();

      byojoAndShogai.setBindPath("BYOJO_SHOGAI_STATE");

      byojoAndShogai.setColumns(90);

      byojoAndShogai.setRows(3);

      byojoAndShogai.setMaxRows(2);

      byojoAndShogai.setIMEMode(InputSubset.KANJI);

      byojoAndShogai.setMaxLength(90);

      byojoAndShogai.setLineWrap(true);

      addByojoAndShogai();
    }
    return byojoAndShogai;

  }

  /**
   * 病状・障害等の状態コンテナを取得します。
   * @return 病状・障害等の状態コンテナ
   */
  protected ACLabelContainer getByojoAndShogaiContainer(){
    if(byojoAndShogaiContainer==null){
      byojoAndShogaiContainer = new ACLabelContainer();
      byojoAndShogaiContainer.setFollowChildEnabled(true);
      byojoAndShogaiContainer.setVAlignment(VRLayout.CENTER);
      byojoAndShogaiContainer.add(getByojoAndShogai(), VRLayout.CLIENT);
    }
    return byojoAndShogaiContainer;
  }

  /**
   * 1月当たりの訪問回数領域を取得します。
   * @return 1月当たりの訪問回数領域
   */
  public ACGroupBox getHomonkaisus(){
    if(homonkaisus==null){

      homonkaisus = new ACGroupBox();

      homonkaisus.setText("1月当たりの訪問回数");

      homonkaisus.setAutoWrap(false);

      homonkaisus.setHgap(1);

      addHomonkaisus();
    }
    return homonkaisus;

  }

  /**
   * 日を取得します。
   * @return 日
   */
  public ACTextField getHomonkaisuDay(){
    if(homonkaisuDay==null){

      homonkaisuDay = new ACTextField();

      homonkaisuDay.setBindPath("HOMON_KAISU_DAY");

      homonkaisuDay.setColumns(4);

      homonkaisuDay.setCharType(VRCharType.ONLY_DIGIT);

      homonkaisuDay.setHorizontalAlignment(SwingConstants.RIGHT);

      homonkaisuDay.setIMEMode(InputSubset.LATIN);

      homonkaisuDay.setMaxLength(3);

      addHomonkaisuDay();
    }
    return homonkaisuDay;

  }

  /**
   * 日コンテナを取得します。
   * @return 日コンテナ
   */
  protected ACLabelContainer getHomonkaisuDayContainer(){
    if(homonkaisuDayContainer==null){
      homonkaisuDayContainer = new ACLabelContainer();
      homonkaisuDayContainer.setFollowChildEnabled(true);
      homonkaisuDayContainer.setVAlignment(VRLayout.CENTER);
      homonkaisuDayContainer.add(getHomonkaisuDay(), null);
    }
    return homonkaisuDayContainer;
  }

  /**
   * 回数を取得します。
   * @return 回数
   */
  public ACTextField getHomonkaisuCount(){
    if(homonkaisuCount==null){

      homonkaisuCount = new ACTextField();

      getHomonkaisuCountContainer().setText("日");

      homonkaisuCount.setBindPath("HOMON_KAISU_COUNT");

      homonkaisuCount.setColumns(4);

      homonkaisuCount.setCharType(VRCharType.ONLY_DIGIT);

      homonkaisuCount.setHorizontalAlignment(SwingConstants.RIGHT);

      homonkaisuCount.setIMEMode(InputSubset.LATIN);

      homonkaisuCount.setMaxLength(3);

      addHomonkaisuCount();
    }
    return homonkaisuCount;

  }

  /**
   * 回数コンテナを取得します。
   * @return 回数コンテナ
   */
  protected ACLabelContainer getHomonkaisuCountContainer(){
    if(homonkaisuCountContainer==null){
      homonkaisuCountContainer = new ACLabelContainer();
      homonkaisuCountContainer.setFollowChildEnabled(true);
      homonkaisuCountContainer.setVAlignment(VRLayout.CENTER);
      homonkaisuCountContainer.add(getHomonkaisuCount(), null);
    }
    return homonkaisuCountContainer;
  }

  /**
   * 1月当たりの訪問回数・キャプションを取得します。
   * @return 1月当たりの訪問回数・キャプション
   */
  public ACLabel getHomonkaisuCaption(){
    if(homonkaisuCaption==null){

      homonkaisuCaption = new ACLabel();

      homonkaisuCaption.setText("回");

      addHomonkaisuCaption();
    }
    return homonkaisuCaption;

  }

  /**
   * 看護の内容領域を取得します。
   * @return 看護の内容領域
   */
  public ACGroupBox getKangoContents(){
    if(kangoContents==null){

      kangoContents = new ACGroupBox();

      kangoContents.setText("看護の内容(45x2)");

      addKangoContents();
    }
    return kangoContents;

  }

  /**
   * 看護の内容を取得します。
   * @return 看護の内容
   */
  public ACTextArea getKangoContent(){
    if(kangoContent==null){

      kangoContent = new ACTextArea();

      kangoContent.setBindPath("KANGO_NAIYO");

      kangoContent.setColumns(90);

      kangoContent.setRows(3);

      kangoContent.setMaxRows(2);

      kangoContent.setIMEMode(InputSubset.KANJI);

      kangoContent.setMaxLength(90);

      kangoContent.setLineWrap(true);

      addKangoContent();
    }
    return kangoContent;

  }

  /**
   * 看護の内容コンテナを取得します。
   * @return 看護の内容コンテナ
   */
  protected ACLabelContainer getKangoContentContainer(){
    if(kangoContentContainer==null){
      kangoContentContainer = new ACLabelContainer();
      kangoContentContainer.setFollowChildEnabled(true);
      kangoContentContainer.setVAlignment(VRLayout.CENTER);
      kangoContentContainer.add(getKangoContent(), VRLayout.CLIENT);
    }
    return kangoContentContainer;
  }

  /**
   * 保健福祉サービス・特記事項領域を取得します。
   * @return 保健福祉サービス・特記事項領域
   */
  public ACPanel getPoints3(){
    if(points3==null){

      points3 = new ACPanel();

      addPoints3();
    }
    return points3;

  }

  /**
   * 必要と考えられる保健福祉サービス領域を取得します。
   * @return 必要と考えられる保健福祉サービス領域
   */
  public ACGroupBox getNeedHokenfukushiServices(){
    if(needHokenfukushiServices==null){

      needHokenfukushiServices = new ACGroupBox();

      needHokenfukushiServices.setText("必要と考えられる保健福祉サービス(45x2)");

      addNeedHokenfukushiServices();
    }
    return needHokenfukushiServices;

  }

  /**
   * 必要と考えられる保健福祉サービスを取得します。
   * @return 必要と考えられる保健福祉サービス
   */
  public ACTextArea getNeedHokenfukushiService(){
    if(needHokenfukushiService==null){

      needHokenfukushiService = new ACTextArea();

      needHokenfukushiService.setBindPath("HOKEN_FUKUSHI_SERVICE");

      needHokenfukushiService.setColumns(90);

      needHokenfukushiService.setRows(3);

      needHokenfukushiService.setMaxRows(2);

      needHokenfukushiService.setIMEMode(InputSubset.KANJI);

      needHokenfukushiService.setMaxLength(90);

      needHokenfukushiService.setLineWrap(true);

      addNeedHokenfukushiService();
    }
    return needHokenfukushiService;

  }

  /**
   * 必要と考えられる保健福祉サービスコンテナを取得します。
   * @return 必要と考えられる保健福祉サービスコンテナ
   */
  protected ACLabelContainer getNeedHokenfukushiServiceContainer(){
    if(needHokenfukushiServiceContainer==null){
      needHokenfukushiServiceContainer = new ACLabelContainer();
      needHokenfukushiServiceContainer.setFollowChildEnabled(true);
      needHokenfukushiServiceContainer.setVAlignment(VRLayout.CENTER);
      needHokenfukushiServiceContainer.add(getNeedHokenfukushiService(), VRLayout.CLIENT);
    }
    return needHokenfukushiServiceContainer;
  }

  /**
   * その他特記すべき留意事項領域を取得します。
   * @return その他特記すべき留意事項領域
   */
  public ACGroupBox getExtraTokijikos(){
    if(extraTokijikos==null){

      extraTokijikos = new ACGroupBox();

      extraTokijikos.setText("その他特記すべき留意事項(45x2)");

      addExtraTokijikos();
    }
    return extraTokijikos;

  }

  /**
   * その他特記すべき留意事項を取得します。
   * @return その他特記すべき留意事項
   */
  public ACTextArea getExtraTokijiko(){
    if(extraTokijiko==null){

      extraTokijiko = new ACTextArea();

      extraTokijiko.setBindPath("RYUIJIKO");

      extraTokijiko.setColumns(90);

      extraTokijiko.setRows(3);

      extraTokijiko.setMaxRows(2);

      extraTokijiko.setIMEMode(InputSubset.KANJI);

      extraTokijiko.setMaxLength(90);

      extraTokijiko.setLineWrap(true);

      addExtraTokijiko();
    }
    return extraTokijiko;

  }

  /**
   * その他特記すべき留意事項コンテナを取得します。
   * @return その他特記すべき留意事項コンテナ
   */
  protected ACLabelContainer getExtraTokijikoContainer(){
    if(extraTokijikoContainer==null){
      extraTokijikoContainer = new ACLabelContainer();
      extraTokijikoContainer.setFollowChildEnabled(true);
      extraTokijikoContainer.setVAlignment(VRLayout.CENTER);
      extraTokijikoContainer.add(getExtraTokijiko(), VRLayout.CLIENT);
    }
    return extraTokijikoContainer;
  }

  /**
   * コンストラクタです。
   */
  public QC003Design() {

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

    buttons.add(getPrint(), VRLayout.EAST);
    buttons.add(getUpdate(), VRLayout.EAST);
    buttons.add(getInsert(), VRLayout.EAST);
    buttons.add(getOpen(), VRLayout.EAST);
  }

  /**
   * 前回読込に内部項目を追加します。
   */
  protected void addOpen(){

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
   * 印刷に内部項目を追加します。
   */
  protected void addPrint(){

  }

  /**
   * クライアント領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getInfos(), VRLayout.NORTH);

    contents.add(getPatients(), VRLayout.NORTH);

    contents.add(getProviders(), VRLayout.NORTH);

    contents.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * 情報領域に内部項目を追加します。
   */
  protected void addInfos(){

    infos.add(getInfoTheOfferContainer(), VRLayout.FLOW);

    infos.add(getResultDayContainer(), VRLayout.FLOW);

  }

  /**
   * 情報提供先に内部項目を追加します。
   */
  protected void addInfoTheOffer(){

  }

  /**
   * 実施日に内部項目を追加します。
   */
  protected void addResultDay(){

  }

  /**
   * 利用者領域に内部項目を追加します。
   */
  protected void addPatients(){

    patients.add(getPatient(), VRLayout.CLIENT);

  }

  /**
   * 利用者領域に内部項目を追加します。
   */
  protected void addPatient(){

    patient.add(getPatientNameContainer(), VRLayout.FLOW_INSETLINE);

    patient.add(getPatientSexContainer(), VRLayout.FLOW);

    patient.add(getPatientBirths(), VRLayout.FLOW);

    patient.add(getPatientJobContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    patient.add(getPatientAddressContainer(), VRLayout.FLOW_INSETLINE);

    patient.add(getPatientTels(), VRLayout.FLOW_INSETLINE_RETURN);

    patient.add(getPatientYokaigodoContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    patient.add(getPatientDiseaseNameContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 利用者氏名に内部項目を追加します。
   */
  protected void addPatientName(){

  }

  /**
   * 利用者性別に内部項目を追加します。
   */
  protected void addPatientSex(){

  }

  /**
   * 利用者生年月日・コンテナに内部項目を追加します。
   */
  protected void addPatientBirths(){

    patientBirths.add(getPatientBirth(), VRLayout.FLOW);

    patientBirths.add(getPatientAge(), VRLayout.FLOW);

    patientBirths.add(getPatientAgeLabel(), VRLayout.FLOW);

  }

  /**
   * 利用者生年月日に内部項目を追加します。
   */
  protected void addPatientBirth(){

  }

  /**
   * 利用者年齢に内部項目を追加します。
   */
  protected void addPatientAge(){

  }

  /**
   * 歳に内部項目を追加します。
   */
  protected void addPatientAgeLabel(){

  }

  /**
   * 利用者職業に内部項目を追加します。
   */
  protected void addPatientJob(){

  }

  /**
   * 利用者住所に内部項目を追加します。
   */
  protected void addPatientAddress(){

  }

  /**
   * 利用者電話番号・コンテナに内部項目を追加します。
   */
  protected void addPatientTels(){

    patientTels.add(getPatientTel1(), VRLayout.FLOW);

    patientTels.add(getPatientTelLabel1(), VRLayout.FLOW);

    patientTels.add(getPatientTel2(), VRLayout.FLOW);

    patientTels.add(getPatientTelLabel2(), VRLayout.FLOW);

    patientTels.add(getPatientTel3(), VRLayout.FLOW);

  }

  /**
   * 利用者電話番号1に内部項目を追加します。
   */
  protected void addPatientTel1(){

  }

  /**
   * 利用ラベル1に内部項目を追加します。
   */
  protected void addPatientTelLabel1(){

  }

  /**
   * 利用者電話番号2に内部項目を追加します。
   */
  protected void addPatientTel2(){

  }

  /**
   * 利用者ラベル2に内部項目を追加します。
   */
  protected void addPatientTelLabel2(){

  }

  /**
   * 利用者電話番号3に内部項目を追加します。
   */
  protected void addPatientTel3(){

  }

  /**
   * 利用者要介護認定に内部項目を追加します。
   */
  protected void addPatientYokaigodo(){

  }

  /**
   * 利用者要介護認定モデルに内部項目を追加します。
   */
  protected void addPatientYokaigodoModel(){

    getYokaigodoRadio1().setButtonIndex(1);
    getPatientYokaigodoModel().add(getYokaigodoRadio1());

    getYokaigodoRadio2().setButtonIndex(2);
    getPatientYokaigodoModel().add(getYokaigodoRadio2());

    getYokaigodoRadio3().setButtonIndex(3);
    getPatientYokaigodoModel().add(getYokaigodoRadio3());

    getYokaigodoRadio4().setButtonIndex(4);
    getPatientYokaigodoModel().add(getYokaigodoRadio4());

    getYokaigodoRadio5().setButtonIndex(5);
    getPatientYokaigodoModel().add(getYokaigodoRadio5());

    getYokaigodoRadio6().setButtonIndex(6);
    getPatientYokaigodoModel().add(getYokaigodoRadio6());

    getYokaigodoRadio7().setButtonIndex(7);
    getPatientYokaigodoModel().add(getYokaigodoRadio7());

    getYokaigodoRadio8().setButtonIndex(8);
    getPatientYokaigodoModel().add(getYokaigodoRadio8());

    getYokaigodoRadio9().setButtonIndex(9);
    getPatientYokaigodoModel().add(getYokaigodoRadio9());

  }

  /**
   * 自立に内部項目を追加します。
   */
  protected void addYokaigodoRadio1(){

  }

  /**
   * 要支援1に内部項目を追加します。
   */
  protected void addYokaigodoRadio2(){

  }

  /**
   * 要支援2に内部項目を追加します。
   */
  protected void addYokaigodoRadio3(){

  }

  /**
   * 経過的要介護に内部項目を追加します。
   */
  protected void addYokaigodoRadio4(){

  }

  /**
   * 要介護1に内部項目を追加します。
   */
  protected void addYokaigodoRadio5(){

  }

  /**
   * 要介護2に内部項目を追加します。
   */
  protected void addYokaigodoRadio6(){

  }

  /**
   * 要介護3に内部項目を追加します。
   */
  protected void addYokaigodoRadio7(){

  }

  /**
   * 要介護4に内部項目を追加します。
   */
  protected void addYokaigodoRadio8(){

  }

  /**
   * 要介護5に内部項目を追加します。
   */
  protected void addYokaigodoRadio9(){

  }

  /**
   * 利用者主傷病名に内部項目を追加します。
   */
  protected void addPatientDiseaseName(){

  }

  /**
   * 事業所領域に内部項目を追加します。
   */
  protected void addProviders(){

    providers.add(getProvider(), VRLayout.CLIENT);

  }

  /**
   * 事業所領域に内部項目を追加します。
   */
  protected void addProvider(){

    provider.add(getProviderNameContainer(), VRLayout.FLOW_INSETLINE);

    provider.add(getProviderAdderessContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    provider.add(getProviderTels(), VRLayout.FLOW_INSETLINE);

    provider.add(getProvidarAdministratorContainer(), VRLayout.FLOW);

  }

  /**
   * 事業所名称に内部項目を追加します。
   */
  protected void addProviderName(){

  }

  /**
   * 事業所名称モデルに内部項目を追加します。
   */
  protected void addProviderNameModel(){

  }

  /**
   * 事業所所在地に内部項目を追加します。
   */
  protected void addProviderAdderess(){

  }

  /**
   * 事業所電話番号に内部項目を追加します。
   */
  protected void addProviderTels(){

    providerTels.add(getProviderTel1(), VRLayout.FLOW);

    providerTels.add(getProviderLabel1(), VRLayout.FLOW);

    providerTels.add(getProviderTel2(), VRLayout.FLOW);

    providerTels.add(getProviderLabel2(), VRLayout.FLOW);

    providerTels.add(getProviderTel3(), VRLayout.FLOW);

  }

  /**
   * 事業所電話番号1に内部項目を追加します。
   */
  protected void addProviderTel1(){

  }

  /**
   * 事業所ラベル1に内部項目を追加します。
   */
  protected void addProviderLabel1(){

  }

  /**
   * 事業所電話番号2に内部項目を追加します。
   */
  protected void addProviderTel2(){

  }

  /**
   * 事業所ラベル2に内部項目を追加します。
   */
  protected void addProviderLabel2(){

  }

  /**
   * 事業所電話番号3に内部項目を追加します。
   */
  protected void addProviderTel3(){

  }

  /**
   * 事業所管理者に内部項目を追加します。
   */
  protected void addProvidarAdministrator(){

  }

  /**
   * タブに内部項目を追加します。
   */
  protected void addTabs(){

    tabs.addTab("日常生活活動(ADL)の状況", getPoints1());

    tabs.addTab("病状・障害等の状態", getPoints2());

    tabs.addTab("保健福祉サービス・特記事項", getPoints3());

  }

  /**
   * 主治医・要介護認定状況・ADL領域に内部項目を追加します。
   */
  protected void addPoints1(){

    points1.add(getSyujis(), VRLayout.NORTH);

    points1.add(getNichijokatsudoStates(), VRLayout.NORTH);

  }

  /**
   * 主治医領域に内部項目を追加します。
   */
  protected void addSyujis(){

    syujis.add(getSyujiNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    syujis.add(getSyujiAddressContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 主治医氏名に内部項目を追加します。
   */
  protected void addSyujiName(){

  }

  /**
   * 主治医住所に内部項目を追加します。
   */
  protected void addSyujiAddress(){

  }

  /**
   * 日常生活活動の状況領域に内部項目を追加します。
   */
  protected void addNichijokatsudoStates(){

    nichijokatsudoStates.add(getNichijokatsudoStateLeft(), VRLayout.CLIENT);

    nichijokatsudoStates.add(getNichijokatsudoStateRight(), VRLayout.CLIENT);

  }

  /**
   * 日常生活活動の状況(左領域)に内部項目を追加します。
   */
  protected void addNichijokatsudoStateLeft(){

    nichijokatsudoStateLeft.add(getMovesContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nichijokatsudoStateLeft.add(getExcretesContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nichijokatsudoStateLeft.add(getChangeClothesContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 移動に内部項目を追加します。
   */
  protected void addMoves(){

  }

  /**
   * 移動モデルに内部項目を追加します。
   */
  protected void addMovesModel(){

    getMoveRadioItem1().setButtonIndex(1);
    getMovesModel().add(getMoveRadioItem1());

    getMoveRadioItem2().setButtonIndex(2);
    getMovesModel().add(getMoveRadioItem2());

    getMoveRadioItem3().setButtonIndex(3);
    getMovesModel().add(getMoveRadioItem3());

  }

  /**
   * 自立に内部項目を追加します。
   */
  protected void addMoveRadioItem1(){

  }

  /**
   * 一部介助に内部項目を追加します。
   */
  protected void addMoveRadioItem2(){

  }

  /**
   * 全面介助に内部項目を追加します。
   */
  protected void addMoveRadioItem3(){

  }

  /**
   * 排泄に内部項目を追加します。
   */
  protected void addExcretes(){

  }

  /**
   * 排泄モデルに内部項目を追加します。
   */
  protected void addExcretesModel(){

    getExcreteRadioItem1().setButtonIndex(1);
    getExcretesModel().add(getExcreteRadioItem1());

    getExcreteRadioItem2().setButtonIndex(2);
    getExcretesModel().add(getExcreteRadioItem2());

    getExcreteRadioItem3().setButtonIndex(3);
    getExcretesModel().add(getExcreteRadioItem3());

  }

  /**
   * 自立に内部項目を追加します。
   */
  protected void addExcreteRadioItem1(){

  }

  /**
   * 一部介助に内部項目を追加します。
   */
  protected void addExcreteRadioItem2(){

  }

  /**
   * 全面介助に内部項目を追加します。
   */
  protected void addExcreteRadioItem3(){

  }

  /**
   * 着替に内部項目を追加します。
   */
  protected void addChangeClothes(){

  }

  /**
   * 着替モデルに内部項目を追加します。
   */
  protected void addChangeClothesModel(){

    getChangeClothesRadioItem1().setButtonIndex(1);
    getChangeClothesModel().add(getChangeClothesRadioItem1());

    getChangeClothesRadioItem2().setButtonIndex(2);
    getChangeClothesModel().add(getChangeClothesRadioItem2());

    getChangeClothesRadioItem3().setButtonIndex(3);
    getChangeClothesModel().add(getChangeClothesRadioItem3());

  }

  /**
   * 自立に内部項目を追加します。
   */
  protected void addChangeClothesRadioItem1(){

  }

  /**
   * 一部介助に内部項目を追加します。
   */
  protected void addChangeClothesRadioItem2(){

  }

  /**
   * 全面介助に内部項目を追加します。
   */
  protected void addChangeClothesRadioItem3(){

  }

  /**
   * 日常生活活動の状況(右領域)に内部項目を追加します。
   */
  protected void addNichijokatsudoStateRight(){

    nichijokatsudoStateRight.add(getMealContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nichijokatsudoStateRight.add(getBathContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nichijokatsudoStateRight.add(getSeiyoContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 食事に内部項目を追加します。
   */
  protected void addMeal(){

  }

  /**
   * 食事モデルに内部項目を追加します。
   */
  protected void addMealModel(){

    getMealRadioItem1().setButtonIndex(1);
    getMealModel().add(getMealRadioItem1());

    getMealRadioItem2().setButtonIndex(2);
    getMealModel().add(getMealRadioItem2());

    getMealRadioItem3().setButtonIndex(3);
    getMealModel().add(getMealRadioItem3());

  }

  /**
   * 自立に内部項目を追加します。
   */
  protected void addMealRadioItem1(){

  }

  /**
   * 一部介助に内部項目を追加します。
   */
  protected void addMealRadioItem2(){

  }

  /**
   * 全面介助に内部項目を追加します。
   */
  protected void addMealRadioItem3(){

  }

  /**
   * 入浴に内部項目を追加します。
   */
  protected void addBath(){

  }

  /**
   * 入浴モデルに内部項目を追加します。
   */
  protected void addBathModel(){

    getBathRadioItem1().setButtonIndex(1);
    getBathModel().add(getBathRadioItem1());

    getBathRadioItem2().setButtonIndex(2);
    getBathModel().add(getBathRadioItem2());

    getBathRadioItem3().setButtonIndex(3);
    getBathModel().add(getBathRadioItem3());

  }

  /**
   * 自立に内部項目を追加します。
   */
  protected void addBathRadioItem1(){

  }

  /**
   * 一部介助に内部項目を追加します。
   */
  protected void addBathRadioItem2(){

  }

  /**
   * 全面介助に内部項目を追加します。
   */
  protected void addBathRadioItem3(){

  }

  /**
   * 整容に内部項目を追加します。
   */
  protected void addSeiyo(){

  }

  /**
   * 整容モデルに内部項目を追加します。
   */
  protected void addSeiyoModel(){

    getSeiyoRadioItem1().setButtonIndex(1);
    getSeiyoModel().add(getSeiyoRadioItem1());

    getSeiyoRadioItem2().setButtonIndex(2);
    getSeiyoModel().add(getSeiyoRadioItem2());

    getSeiyoRadioItem3().setButtonIndex(3);
    getSeiyoModel().add(getSeiyoRadioItem3());

  }

  /**
   * 自立に内部項目を追加します。
   */
  protected void addSeiyoRadioItem1(){

  }

  /**
   * 一部介助に内部項目を追加します。
   */
  protected void addSeiyoRadioItem2(){

  }

  /**
   * 全面介助に内部項目を追加します。
   */
  protected void addSeiyoRadioItem3(){

  }

  /**
   * 病状・障害等の状態領域に内部項目を追加します。
   */
  protected void addPoints2(){

    points2.add(getByojoAndShogais(), VRLayout.FLOW_INSETLINE_RETURN);

    points2.add(getHomonkaisus(), VRLayout.FLOW_INSETLINE_RETURN);

    points2.add(getKangoContents(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 病状・障害等の状況領域に内部項目を追加します。
   */
  protected void addByojoAndShogais(){

    byojoAndShogais.add(getByojoAndShogaiContainer(), VRLayout.CLIENT);

  }

  /**
   * 病状・障害等の状態に内部項目を追加します。
   */
  protected void addByojoAndShogai(){

  }

  /**
   * 1月当たりの訪問回数領域に内部項目を追加します。
   */
  protected void addHomonkaisus(){

    homonkaisus.add(getHomonkaisuDayContainer(), VRLayout.FLOW);

    homonkaisus.add(getHomonkaisuCountContainer(), VRLayout.FLOW);

    homonkaisus.add(getHomonkaisuCaption(), VRLayout.FLOW);

  }

  /**
   * 日に内部項目を追加します。
   */
  protected void addHomonkaisuDay(){

  }

  /**
   * 回数に内部項目を追加します。
   */
  protected void addHomonkaisuCount(){

  }

  /**
   * 1月当たりの訪問回数・キャプションに内部項目を追加します。
   */
  protected void addHomonkaisuCaption(){

  }

  /**
   * 看護の内容領域に内部項目を追加します。
   */
  protected void addKangoContents(){

    kangoContents.add(getKangoContentContainer(), VRLayout.CLIENT);

  }

  /**
   * 看護の内容に内部項目を追加します。
   */
  protected void addKangoContent(){

  }

  /**
   * 保健福祉サービス・特記事項領域に内部項目を追加します。
   */
  protected void addPoints3(){

    points3.add(getNeedHokenfukushiServices(), VRLayout.FLOW_INSETLINE_RETURN);

    points3.add(getExtraTokijikos(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 必要と考えられる保健福祉サービス領域に内部項目を追加します。
   */
  protected void addNeedHokenfukushiServices(){

    needHokenfukushiServices.add(getNeedHokenfukushiServiceContainer(), VRLayout.CLIENT);

  }

  /**
   * 必要と考えられる保健福祉サービスに内部項目を追加します。
   */
  protected void addNeedHokenfukushiService(){

  }

  /**
   * その他特記すべき留意事項領域に内部項目を追加します。
   */
  protected void addExtraTokijikos(){

    extraTokijikos.add(getExtraTokijikoContainer(), VRLayout.CLIENT);

  }

  /**
   * その他特記すべき留意事項に内部項目を追加します。
   */
  protected void addExtraTokijiko(){

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
      ACFrame.setVRLookAndFeel();
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QC003Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QC003Design getThis() {
    return this;
  }
}
