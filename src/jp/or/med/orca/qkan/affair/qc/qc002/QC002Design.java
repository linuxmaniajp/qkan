
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
 * 作成日: 2006/09/01  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 帳票管理 (C)
 * プロセス 訪問看護報告書 (002)
 * プログラム 訪問看護報告書 (QC002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qc.qc002;
import java.awt.Color;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACAffairButton;
import jp.nichicom.ac.component.ACAffairButtonBar;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACTextArea;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.ACValueArrayRadioButtonGroup;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACAffairable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanAffairContainer;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.component.QkanDateTextField;
/**
 * 訪問看護報告書画面項目デザイン(QC002) 
 */
@SuppressWarnings("serial")
public class QC002Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton open;

  private ACAffairButton insert;

  private ACAffairButton update;

  private ACAffairButton print;

  private ACPanel contents;

  private ACPanel targetDates;

  private ACLabel targetDateCaption;

  private ACLabel targetDate;

  private ACPanel infos;

  private ACGroupBox patients;

  private ACTextField patientName;

  private ACLabelContainer patientNameContainer;

  private ACLabelContainer patientBirthContainer;

  private QkanDateTextField patientBirth;

  private ACTextField patientAge;

  private ACLabel patientAgeLabel;

  private ACValueArrayRadioButtonGroup yokaigodo;

  private ACLabelContainer yokaigodoContainer;

  private ACListModelAdapter yokaigodoModel;

  private ACRadioButtonItem yokaigodoRadio1;

  private ACRadioButtonItem yokaigodoRadio2;

  private ACRadioButtonItem yokaigodoRadio3;

  private ACRadioButtonItem yokaigodoRadio4;

  private ACRadioButtonItem yokaigodoRadio5;

  private ACRadioButtonItem yokaigodoRadio6;

  private ACRadioButtonItem yokaigodoRadio7;

  private ACRadioButtonItem yokaigodoRadio8;

  private ACRadioButtonItem yokaigodoRadio9;

  private ACTextField patientAddress;

  private ACLabelContainer patientAddressContainer;

  private ACTextField doctorName;

  private ACLabelContainer doctorNameContainer;

  private ACGroupBox stations;

  private QkanDateTextField createDate;

  private ACLabelContainer createDateContainer;

  private ACComboBox providerName;

  private ACLabelContainer providerNameContainer;

  private ACComboBoxModelAdapter providerNameModel;

  private ACTextField administratorName;

  private ACLabelContainer administratorNameContainer;

  private JTabbedPane tabs;

  private ACPanel tabVisitDate;

  private ACGroupBox visitDates;

  private ACPanel calendars;

  private ACLabelContainer calendarLefts;

  private ACPanel calendarLeftYearMonths;

  private VRLayout calendarLeftYearMonthsLayout;

  private ACLabel calendarLeftCaption;

  private ACLabel calendarLeftYear;

  private ACLabel calendarLeftYearCaption;

  private ACLabel calendarLeftMonth;

  private ACLabel calendarLeftMonthCaption;

  private ACPanel calendarLeftDayContainer;

  private ACComboBox calendarLeftDay01;

  private ACComboBoxModelAdapter calendarLeftDay01Model;

  private ACComboBox calendarLeftDay02;

  private ACComboBoxModelAdapter calendarLeftDay02Model;

  private ACComboBox calendarLeftDay03;

  private ACComboBoxModelAdapter calendarLeftDay03Model;

  private ACComboBox calendarLeftDay04;

  private ACComboBoxModelAdapter calendarLeftDay04Model;

  private ACComboBox calendarLeftDay05;

  private ACComboBoxModelAdapter calendarLeftDay05Model;

  private ACComboBox calendarLeftDay06;

  private ACComboBoxModelAdapter calendarLeftDay06Model;

  private ACComboBox calendarLeftDay07;

  private ACComboBoxModelAdapter calendarLeftDay07Model;

  private ACComboBox calendarLeftDay08;

  private ACComboBoxModelAdapter calendarLeftDay08Model;

  private ACComboBox calendarLeftDay09;

  private ACComboBoxModelAdapter calendarLeftDay09Model;

  private ACComboBox calendarLeftDay10;

  private ACComboBoxModelAdapter calendarLeftDay10Model;

  private ACComboBox calendarLeftDay11;

  private ACComboBoxModelAdapter calendarLeftDay11Model;

  private ACComboBox calendarLeftDay12;

  private ACComboBoxModelAdapter calendarLeftDay12Model;

  private ACComboBox calendarLeftDay13;

  private ACComboBoxModelAdapter calendarLeftDay13Model;

  private ACComboBox calendarLeftDay14;

  private ACComboBoxModelAdapter calendarLeftDay14Model;

  private ACComboBox calendarLeftDay15;

  private ACComboBoxModelAdapter calendarLeftDay15Model;

  private ACComboBox calendarLeftDay16;

  private ACComboBoxModelAdapter calendarLeftDay16Model;

  private ACComboBox calendarLeftDay17;

  private ACComboBoxModelAdapter calendarLeftDay17Model;

  private ACComboBox calendarLeftDay18;

  private ACComboBoxModelAdapter calendarLeftDay18Model;

  private ACComboBox calendarLeftDay19;

  private ACComboBoxModelAdapter calendarLeftDay19Model;

  private ACComboBox calendarLeftDay20;

  private ACComboBoxModelAdapter calendarLeftDay20Model;

  private ACComboBox calendarLeftDay21;

  private ACComboBoxModelAdapter calendarLeftDay21Model;

  private ACComboBox calendarLeftDay22;

  private ACComboBoxModelAdapter calendarLeftDay22Model;

  private ACComboBox calendarLeftDay23;

  private ACComboBoxModelAdapter calendarLeftDay23Model;

  private ACComboBox calendarLeftDay24;

  private ACComboBoxModelAdapter calendarLeftDay24Model;

  private ACComboBox calendarLeftDay25;

  private ACComboBoxModelAdapter calendarLeftDay25Model;

  private ACComboBox calendarLeftDay26;

  private ACComboBoxModelAdapter calendarLeftDay26Model;

  private ACComboBox calendarLeftDay27;

  private ACComboBoxModelAdapter calendarLeftDay27Model;

  private ACComboBox calendarLeftDay28;

  private ACComboBoxModelAdapter calendarLeftDay28Model;

  private ACPanel calendarLeftDay29Panel;

  private ACLabel calendarLeftDay29Label;

  private ACComboBox calendarLeftDay29;

  private ACComboBoxModelAdapter calendarLeftDay29Model;

  private ACPanel calendarLeftDay30Panel;

  private ACLabel calendarLeftDay30Label;

  private ACComboBox calendarLeftDay30;

  private ACComboBoxModelAdapter calendarLeftDay30Model;

  private ACPanel calendarLeftDay31Panel;

  private ACLabel calendarLeftDay31Label;

  private ACComboBox calendarLeftDay31;

  private ACComboBoxModelAdapter calendarLeftDay31Model;

  private ACLabelContainer calendarRights;

  private ACPanel calendarRightYearMonths;

  private VRLayout calendarRightYearMonthsLayout;

  private ACLabel calendarRightCaption;

  private ACLabel calendarRightYear;

  private ACLabel calendarRightYearCaption;

  private ACLabel calendarRightMonth;

  private ACLabel calendarRightMonthCaption;

  private ACPanel calendarRightDayContainer;

  private ACComboBox calendarRightDay01;

  private ACComboBoxModelAdapter calendarRightDay01Model;

  private ACComboBox calendarRightDay02;

  private ACComboBoxModelAdapter calendarRightDay02Model;

  private ACComboBox calendarRightDay03;

  private ACComboBoxModelAdapter calendarRightDay03Model;

  private ACComboBox calendarRightDay04;

  private ACComboBoxModelAdapter calendarRightDay04Model;

  private ACComboBox calendarRightDay05;

  private ACComboBoxModelAdapter calendarRightDay05Model;

  private ACComboBox calendarRightDay06;

  private ACComboBoxModelAdapter calendarRightDay06Model;

  private ACComboBox calendarRightDay07;

  private ACComboBoxModelAdapter calendarRightDay07Model;

  private ACComboBox calendarRightDay08;

  private ACComboBoxModelAdapter calendarRightDay08Model;

  private ACComboBox calendarRightDay09;

  private ACComboBoxModelAdapter calendarRightDay09Model;

  private ACComboBox calendarRightDay10;

  private ACComboBoxModelAdapter calendarRightDay10Model;

  private ACComboBox calendarRightDay11;

  private ACComboBoxModelAdapter calendarRightDay11Model;

  private ACComboBox calendarRightDay12;

  private ACComboBoxModelAdapter calendarRightDay12Model;

  private ACComboBox calendarRightDay13;

  private ACComboBoxModelAdapter calendarRightDay13Model;

  private ACComboBox calendarRightDay14;

  private ACComboBoxModelAdapter calendarRightDay14Model;

  private ACComboBox calendarRightDay15;

  private ACComboBoxModelAdapter calendarRightDay15Model;

  private ACComboBox calendarRightDay16;

  private ACComboBoxModelAdapter calendarRightDay16Model;

  private ACComboBox calendarRightDay17;

  private ACComboBoxModelAdapter calendarRightDay17Model;

  private ACComboBox calendarRightDay18;

  private ACComboBoxModelAdapter calendarRightDay18Model;

  private ACComboBox calendarRightDay19;

  private ACComboBoxModelAdapter calendarRightDay19Model;

  private ACComboBox calendarRightDay20;

  private ACComboBoxModelAdapter calendarRightDay20Model;

  private ACComboBox calendarRightDay21;

  private ACComboBoxModelAdapter calendarRightDay21Model;

  private ACComboBox calendarRightDay22;

  private ACComboBoxModelAdapter calendarRightDay22Model;

  private ACComboBox calendarRightDay23;

  private ACComboBoxModelAdapter calendarRightDay23Model;

  private ACComboBox calendarRightDay24;

  private ACComboBoxModelAdapter calendarRightDay24Model;

  private ACComboBox calendarRightDay25;

  private ACComboBoxModelAdapter calendarRightDay25Model;

  private ACComboBox calendarRightDay26;

  private ACComboBoxModelAdapter calendarRightDay26Model;

  private ACComboBox calendarRightDay27;

  private ACComboBoxModelAdapter calendarRightDay27Model;

  private ACComboBox calendarRightDay28;

  private ACComboBoxModelAdapter calendarRightDay28Model;

  private ACPanel calendarRightDay29Panel;

  private ACLabel calendarRightDay29Label;

  private ACComboBox calendarRightDay29;

  private ACComboBoxModelAdapter calendarRightDay29Model;

  private ACPanel calendarRightDay30Panel;

  private ACLabel calendarRightDay30Label;

  private ACComboBox calendarRightDay30;

  private ACComboBoxModelAdapter calendarRightDay30Model;

  private ACPanel calendarRightDay31Panel;

  private ACLabel calendarRightDay31Label;

  private ACComboBox calendarRightDay31;

  private ACComboBoxModelAdapter calendarRightDay31Model;

  private ACPanel resultButtonPanel;

  private ACPanel resultButtonPanelLeft;

  private ACButton resultReadButtonLeft;

  private ACPanel resultButtonPanelRight;

  private ACButton resultReadButtonRight;

  private ACPanel memos;

  private ACLabel memo1;

  private ACLabel memo6;

  private ACLabel memo2;

  private ACLabel memo3;

  private ACLabel memo4;

  private ACLabel memo5;

  private ACPanel tabsComments1;

  private ACGroupBox byojos;

  private ACPanel byojoPnls;

  private ACTextArea byojoComments;

  private ACLabelContainer byojoCommentsContainer;

  private ACGroupBox kangoRehas;

  private ACPanel kangoRehaPnls;

  private ACTextArea kangoRehaComments;

  private ACLabelContainer kangoRehaCommentsContainer;

  private ACPanel tabsComments2;

  private ACGroupBox ryoyoStates;

  private ACPanel ryoyoStatePnls;

  private ACTextArea ryoyoStateComments;

  private ACLabelContainer ryoyoStateCommentsContainer;

  private ACGroupBox specials;

  private ACPanel specialPnls;

  private ACTextArea specialComments;

  private ACLabelContainer specialCommentsContainer;

  //getter

  /**
   * ボタンバーを取得します。
   * @return ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("訪問看護報告書");

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

      open.setToolTipText("過去のデータの中で、最新のデータを引き継ぎます。");

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

      print.setToolTipText("「訪問看護報告書」を印刷します。");

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
   * 対象年月領域を取得します。
   * @return 対象年月領域
   */
  public ACPanel getTargetDates(){
    if(targetDates==null){

      targetDates = new ACPanel();

      addTargetDates();
    }
    return targetDates;

  }

  /**
   * 対象年月キャプションを取得します。
   * @return 対象年月キャプション
   */
  public ACLabel getTargetDateCaption(){
    if(targetDateCaption==null){

      targetDateCaption = new ACLabel();

      targetDateCaption.setText("対象年月：");

      targetDateCaption.setForeground(Color.blue);

      addTargetDateCaption();
    }
    return targetDateCaption;

  }

  /**
   * 対象年月を取得します。
   * @return 対象年月
   */
  public ACLabel getTargetDate(){
    if(targetDate==null){

      targetDate = new ACLabel();

      targetDate.setForeground(Color.blue);

      addTargetDate();
    }
    return targetDate;

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
   * 利用者情報領域を取得します。
   * @return 利用者情報領域
   */
  public ACGroupBox getPatients(){
    if(patients==null){

      patients = new ACGroupBox();

      patients.setText("利用者");

      addPatients();
    }
    return patients;

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

      patientName.setColumns(26);

      patientName.setIMEMode(InputSubset.KANJI);

      patientName.setMaxLength(26);

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
   * 生年月日コンテナを取得します。
   * @return 生年月日コンテナ
   */
  public ACLabelContainer getPatientBirthContainer(){
    if(patientBirthContainer==null){

      patientBirthContainer = new ACLabelContainer();

      patientBirthContainer.setText("生年月日");

      addPatientBirthContainer();
    }
    return patientBirthContainer;

  }

  /**
   * 生年月日を取得します。
   * @return 生年月日
   */
  public QkanDateTextField getPatientBirth(){
    if(patientBirth==null){

      patientBirth = new QkanDateTextField();

      patientBirth.setBindPath("PATIENT_BIRTHDAY");

      patientBirth.setEditable(false);

      patientBirth.setColumns(9);

      addPatientBirth();
    }
    return patientBirth;

  }

  /**
   * 年齢を取得します。
   * @return 年齢
   */
  public ACTextField getPatientAge(){
    if(patientAge==null){

      patientAge = new ACTextField();

      patientAge.setBindPath("PATIENT_BIRTHDAY");

      patientAge.setEditable(false);

      patientAge.setFormat(QkanConstants.FORMAT_NOW_AGE);

      patientAge.setMaxLength(3);

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
   * 要介護認定を取得します。
   * @return 要介護認定
   */
  public ACValueArrayRadioButtonGroup getYokaigodo(){
    if(yokaigodo==null){

      yokaigodo = new ACValueArrayRadioButtonGroup();

      getYokaigodoContainer().setText("要介護認定");

      yokaigodo.setBindPath("JOTAI_CODE");

      yokaigodo.setUseClearButton(false);

      yokaigodo.setModel(getYokaigodoModel());

      yokaigodo.setValues(new int[]{1,12,13,11,21,22,23,24,25});

      addYokaigodo();
    }
    return yokaigodo;

  }

  /**
   * 要介護認定コンテナを取得します。
   * @return 要介護認定コンテナ
   */
  protected ACLabelContainer getYokaigodoContainer(){
    if(yokaigodoContainer==null){
      yokaigodoContainer = new ACLabelContainer();
      yokaigodoContainer.setFollowChildEnabled(true);
      yokaigodoContainer.setVAlignment(VRLayout.CENTER);
      yokaigodoContainer.add(getYokaigodo(), null);
    }
    return yokaigodoContainer;
  }

  /**
   * 要介護認定モデルを取得します。
   * @return 要介護認定モデル
   */
  protected ACListModelAdapter getYokaigodoModel(){
    if(yokaigodoModel==null){
      yokaigodoModel = new ACListModelAdapter();
      addYokaigodoModel();
    }
    return yokaigodoModel;
  }

  /**
   * 自立を取得します。
   * @return 自立
   */
  public ACRadioButtonItem getYokaigodoRadio1(){
    if(yokaigodoRadio1==null){

      yokaigodoRadio1 = new ACRadioButtonItem();

      yokaigodoRadio1.setText("自立");

      yokaigodoRadio1.setGroup(getYokaigodo());

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

      yokaigodoRadio2.setGroup(getYokaigodo());

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

      yokaigodoRadio3.setGroup(getYokaigodo());

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

      yokaigodoRadio4.setGroup(getYokaigodo());

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

      yokaigodoRadio5.setGroup(getYokaigodo());

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

      yokaigodoRadio6.setGroup(getYokaigodo());

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

      yokaigodoRadio7.setGroup(getYokaigodo());

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

      yokaigodoRadio8.setGroup(getYokaigodo());

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

      yokaigodoRadio9.setGroup(getYokaigodo());

      yokaigodoRadio9.setConstraints(VRLayout.FLOW);

      addYokaigodoRadio9();
    }
    return yokaigodoRadio9;

  }

  /**
   * 住所を取得します。
   * @return 住所
   */
  public ACTextField getPatientAddress(){
    if(patientAddress==null){

      patientAddress = new ACTextField();

      getPatientAddressContainer().setText("住所");

      patientAddress.setBindPath("PATIENT_ADDRESS");

      patientAddress.setEditable(false);

      patientAddress.setColumns(40);

      patientAddress.setIMEMode(InputSubset.KANJI);

      patientAddress.setMaxLength(40);

      addPatientAddress();
    }
    return patientAddress;

  }

  /**
   * 住所コンテナを取得します。
   * @return 住所コンテナ
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
   * 主治医氏名を取得します。
   * @return 主治医氏名
   */
  public ACTextField getDoctorName(){
    if(doctorName==null){

      doctorName = new ACTextField();

      getDoctorNameContainer().setText("主治医氏名");

      doctorName.setBindPath("DOCTOR_NAME");

      doctorName.setColumns(22);

      doctorName.setIMEMode(InputSubset.KANJI);

      doctorName.setMaxLength(22);

      addDoctorName();
    }
    return doctorName;

  }

  /**
   * 主治医氏名コンテナを取得します。
   * @return 主治医氏名コンテナ
   */
  protected ACLabelContainer getDoctorNameContainer(){
    if(doctorNameContainer==null){
      doctorNameContainer = new ACLabelContainer();
      doctorNameContainer.setFollowChildEnabled(true);
      doctorNameContainer.setVAlignment(VRLayout.CENTER);
      doctorNameContainer.add(getDoctorName(), null);
    }
    return doctorNameContainer;
  }

  /**
   * ステーション情報領域を取得します。
   * @return ステーション情報領域
   */
  public ACGroupBox getStations(){
    if(stations==null){

      stations = new ACGroupBox();

      stations.setText("ステーション名等");

      stations.setHgrid(300);

      addStations();
    }
    return stations;

  }

  /**
   * 作成年月日を取得します。
   * @return 作成年月日
   */
  public QkanDateTextField getCreateDate(){
    if(createDate==null){

      createDate = new QkanDateTextField();

      getCreateDateContainer().setText("作成年月日");

      createDate.setBindPath("CREATE_DATE");

      addCreateDate();
    }
    return createDate;

  }

  /**
   * 作成年月日コンテナを取得します。
   * @return 作成年月日コンテナ
   */
  protected ACLabelContainer getCreateDateContainer(){
    if(createDateContainer==null){
      createDateContainer = new ACLabelContainer();
      createDateContainer.setFollowChildEnabled(true);
      createDateContainer.setVAlignment(VRLayout.CENTER);
      createDateContainer.add(getCreateDate(), null);
    }
    return createDateContainer;
  }

  /**
   * ステーション名を取得します。
   * @return ステーション名
   */
  public ACComboBox getProviderName(){
    if(providerName==null){

      providerName = new ACComboBox();

      getProviderNameContainer().setText("ステーション名");

      providerName.setBindPath("PROVIDER_NAME");

      providerName.setEditable(true);

      providerName.setColumns(22);

      providerName.setModelBindPath("PROVIDER_NAMES");

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
   * ステーション名コンテナを取得します。
   * @return ステーション名コンテナ
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
   * ステーション名モデルを取得します。
   * @return ステーション名モデル
   */
  protected ACComboBoxModelAdapter getProviderNameModel(){
    if(providerNameModel==null){
      providerNameModel = new ACComboBoxModelAdapter();
      addProviderNameModel();
    }
    return providerNameModel;
  }

  /**
   * 管理者氏名を取得します。
   * @return 管理者氏名
   */
  public ACTextField getAdministratorName(){
    if(administratorName==null){

      administratorName = new ACTextField();

      getAdministratorNameContainer().setText("管理者氏名");

      administratorName.setBindPath("ADMINISTRATOR_NAME");

      administratorName.setEditable(true);

      administratorName.setColumns(22);

      administratorName.setIMEMode(InputSubset.KANJI);

      administratorName.setMaxLength(22);

      addAdministratorName();
    }
    return administratorName;

  }

  /**
   * 管理者氏名コンテナを取得します。
   * @return 管理者氏名コンテナ
   */
  protected ACLabelContainer getAdministratorNameContainer(){
    if(administratorNameContainer==null){
      administratorNameContainer = new ACLabelContainer();
      administratorNameContainer.setFollowChildEnabled(true);
      administratorNameContainer.setVAlignment(VRLayout.CENTER);
      administratorNameContainer.add(getAdministratorName(), null);
    }
    return administratorNameContainer;
  }

  /**
   * Tabを取得します。
   * @return Tab
   */
  public JTabbedPane getTabs(){
    if(tabs==null){

      tabs = new JTabbedPane();

      addTabs();
    }
    return tabs;

  }

  /**
   * Tab「訪問日」を取得します。
   * @return Tab「訪問日」
   */
  public ACPanel getTabVisitDate(){
    if(tabVisitDate==null){

      tabVisitDate = new ACPanel();

      tabVisitDate.setHgap(0);

      addTabVisitDate();
    }
    return tabVisitDate;

  }

  /**
   * 訪問日領域を取得します。
   * @return 訪問日領域
   */
  public ACGroupBox getVisitDates(){
    if(visitDates==null){

      visitDates = new ACGroupBox();

      visitDates.setText("訪問日");

      visitDates.setHgap(0);

      addVisitDates();
    }
    return visitDates;

  }

  /**
   * カレンダー領域を取得します。
   * @return カレンダー領域
   */
  public ACPanel getCalendars(){
    if(calendars==null){

      calendars = new ACPanel();

      calendars.setHgap(0);

      addCalendars();
    }
    return calendars;

  }

  /**
   * カレンダー(左領域)を取得します。
   * @return カレンダー(左領域)
   */
  public ACLabelContainer getCalendarLefts(){
    if(calendarLefts==null){

      calendarLefts = new ACLabelContainer();

      calendarLefts.setHgap(0);

      addCalendarLefts();
    }
    return calendarLefts;

  }

  /**
   * カレンダー(左)年月領域を取得します。
   * @return カレンダー(左)年月領域
   */
  public ACPanel getCalendarLeftYearMonths(){
    if(calendarLeftYearMonths==null){

      calendarLeftYearMonths = new ACPanel();

      calendarLeftYearMonths.setLayout(getCalendarLeftYearMonthsLayout());

      addCalendarLeftYearMonths();
    }
    return calendarLeftYearMonths;

  }

  /**
   * カレンダー(左)年月領域レイアウトを取得します。
   * @return カレンダー(左)年月領域レイアウト
   */
  public VRLayout getCalendarLeftYearMonthsLayout(){
    if(calendarLeftYearMonthsLayout==null){

      calendarLeftYearMonthsLayout = new VRLayout();

      calendarLeftYearMonthsLayout.setAlignment(SwingConstants.CENTER);

      calendarLeftYearMonthsLayout.setAutoWrap(false);

      addCalendarLeftYearMonthsLayout();
    }
    return calendarLeftYearMonthsLayout;

  }

  /**
   * 平成を取得します。
   * @return 平成
   */
  public ACLabel getCalendarLeftCaption(){
    if(calendarLeftCaption==null){

      calendarLeftCaption = new ACLabel();

      calendarLeftCaption.setText("平成");

      addCalendarLeftCaption();
    }
    return calendarLeftCaption;

  }

  /**
   * 年を取得します。
   * @return 年
   */
  public ACLabel getCalendarLeftYear(){
    if(calendarLeftYear==null){

      calendarLeftYear = new ACLabel();

      calendarLeftYear.setBindPath("CALENDAR_LEFT_YEAR");

      addCalendarLeftYear();
    }
    return calendarLeftYear;

  }

  /**
   * 年キャプションを取得します。
   * @return 年キャプション
   */
  public ACLabel getCalendarLeftYearCaption(){
    if(calendarLeftYearCaption==null){

      calendarLeftYearCaption = new ACLabel();

      calendarLeftYearCaption.setText("年");

      addCalendarLeftYearCaption();
    }
    return calendarLeftYearCaption;

  }

  /**
   * 月を取得します。
   * @return 月
   */
  public ACLabel getCalendarLeftMonth(){
    if(calendarLeftMonth==null){

      calendarLeftMonth = new ACLabel();

      calendarLeftMonth.setBindPath("CALENDAR_LEFT_MONTH");

      addCalendarLeftMonth();
    }
    return calendarLeftMonth;

  }

  /**
   * 月キャプションを取得します。
   * @return 月キャプション
   */
  public ACLabel getCalendarLeftMonthCaption(){
    if(calendarLeftMonthCaption==null){

      calendarLeftMonthCaption = new ACLabel();

      calendarLeftMonthCaption.setText("月");

      addCalendarLeftMonthCaption();
    }
    return calendarLeftMonthCaption;

  }

  /**
   * カレンダー(左日付領域)を取得します。
   * @return カレンダー(左日付領域)
   */
  public ACPanel getCalendarLeftDayContainer(){
    if(calendarLeftDayContainer==null){

      calendarLeftDayContainer = new ACPanel();

      calendarLeftDayContainer.setAutoWrap(false);

      calendarLeftDayContainer.setHgap(0);

      calendarLeftDayContainer.setVgap(0);

      addCalendarLeftDayContainer();
    }
    return calendarLeftDayContainer;

  }

  /**
   * 1日を取得します。
   * @return 1日
   */
  public ACComboBox getCalendarLeftDay01(){
    if(calendarLeftDay01==null){

      calendarLeftDay01 = new ACComboBox();

      calendarLeftDay01.setBindPath("CALENDAR_LEFT_DAY1");

      calendarLeftDay01.setEditable(false);

      calendarLeftDay01.setColumns(3);

      calendarLeftDay01.setModelBindPath("CALENDAR_LEFT1");

      calendarLeftDay01.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay01.setBlankable(false);

      calendarLeftDay01.setMaxColumns(3);

      calendarLeftDay01.setModel(getCalendarLeftDay01Model());

      addCalendarLeftDay01();
    }
    return calendarLeftDay01;

  }

  /**
   * 1日モデルを取得します。
   * @return 1日モデル
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay01Model(){
    if(calendarLeftDay01Model==null){
      calendarLeftDay01Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay01Model();
    }
    return calendarLeftDay01Model;
  }

  /**
   * 2日を取得します。
   * @return 2日
   */
  public ACComboBox getCalendarLeftDay02(){
    if(calendarLeftDay02==null){

      calendarLeftDay02 = new ACComboBox();

      calendarLeftDay02.setBindPath("CALENDAR_LEFT_DAY2");

      calendarLeftDay02.setEditable(false);

      calendarLeftDay02.setColumns(3);

      calendarLeftDay02.setModelBindPath("CALENDAR_LEFT2");

      calendarLeftDay02.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay02.setBlankable(false);

      calendarLeftDay02.setMaxColumns(3);

      calendarLeftDay02.setModel(getCalendarLeftDay02Model());

      addCalendarLeftDay02();
    }
    return calendarLeftDay02;

  }

  /**
   * 2日モデルを取得します。
   * @return 2日モデル
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay02Model(){
    if(calendarLeftDay02Model==null){
      calendarLeftDay02Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay02Model();
    }
    return calendarLeftDay02Model;
  }

  /**
   * 3日を取得します。
   * @return 3日
   */
  public ACComboBox getCalendarLeftDay03(){
    if(calendarLeftDay03==null){

      calendarLeftDay03 = new ACComboBox();

      calendarLeftDay03.setBindPath("CALENDAR_LEFT_DAY3");

      calendarLeftDay03.setEditable(false);

      calendarLeftDay03.setColumns(3);

      calendarLeftDay03.setModelBindPath("CALENDAR_LEFT3");

      calendarLeftDay03.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay03.setBlankable(false);

      calendarLeftDay03.setMaxColumns(3);

      calendarLeftDay03.setModel(getCalendarLeftDay03Model());

      addCalendarLeftDay03();
    }
    return calendarLeftDay03;

  }

  /**
   * 3日モデルを取得します。
   * @return 3日モデル
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay03Model(){
    if(calendarLeftDay03Model==null){
      calendarLeftDay03Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay03Model();
    }
    return calendarLeftDay03Model;
  }

  /**
   * 4日を取得します。
   * @return 4日
   */
  public ACComboBox getCalendarLeftDay04(){
    if(calendarLeftDay04==null){

      calendarLeftDay04 = new ACComboBox();

      calendarLeftDay04.setBindPath("CALENDAR_LEFT_DAY4");

      calendarLeftDay04.setEditable(false);

      calendarLeftDay04.setColumns(3);

      calendarLeftDay04.setModelBindPath("CALENDAR_LEFT4");

      calendarLeftDay04.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay04.setBlankable(false);

      calendarLeftDay04.setMaxColumns(3);

      calendarLeftDay04.setModel(getCalendarLeftDay04Model());

      addCalendarLeftDay04();
    }
    return calendarLeftDay04;

  }

  /**
   * 4日モデルを取得します。
   * @return 4日モデル
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay04Model(){
    if(calendarLeftDay04Model==null){
      calendarLeftDay04Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay04Model();
    }
    return calendarLeftDay04Model;
  }

  /**
   * 5日を取得します。
   * @return 5日
   */
  public ACComboBox getCalendarLeftDay05(){
    if(calendarLeftDay05==null){

      calendarLeftDay05 = new ACComboBox();

      calendarLeftDay05.setBindPath("CALENDAR_LEFT_DAY5");

      calendarLeftDay05.setEditable(false);

      calendarLeftDay05.setColumns(3);

      calendarLeftDay05.setModelBindPath("CALENDAR_LEFT5");

      calendarLeftDay05.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay05.setBlankable(false);

      calendarLeftDay05.setMaxColumns(3);

      calendarLeftDay05.setModel(getCalendarLeftDay05Model());

      addCalendarLeftDay05();
    }
    return calendarLeftDay05;

  }

  /**
   * 5日モデルを取得します。
   * @return 5日モデル
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay05Model(){
    if(calendarLeftDay05Model==null){
      calendarLeftDay05Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay05Model();
    }
    return calendarLeftDay05Model;
  }

  /**
   * 6日を取得します。
   * @return 6日
   */
  public ACComboBox getCalendarLeftDay06(){
    if(calendarLeftDay06==null){

      calendarLeftDay06 = new ACComboBox();

      calendarLeftDay06.setBindPath("CALENDAR_LEFT_DAY6");

      calendarLeftDay06.setEditable(false);

      calendarLeftDay06.setColumns(3);

      calendarLeftDay06.setModelBindPath("CALENDAR_LEFT6");

      calendarLeftDay06.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay06.setBlankable(false);

      calendarLeftDay06.setMaxColumns(3);

      calendarLeftDay06.setModel(getCalendarLeftDay06Model());

      addCalendarLeftDay06();
    }
    return calendarLeftDay06;

  }

  /**
   * 6日モデルを取得します。
   * @return 6日モデル
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay06Model(){
    if(calendarLeftDay06Model==null){
      calendarLeftDay06Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay06Model();
    }
    return calendarLeftDay06Model;
  }

  /**
   * 7日を取得します。
   * @return 7日
   */
  public ACComboBox getCalendarLeftDay07(){
    if(calendarLeftDay07==null){

      calendarLeftDay07 = new ACComboBox();

      calendarLeftDay07.setBindPath("CALENDAR_LEFT_DAY7");

      calendarLeftDay07.setEditable(false);

      calendarLeftDay07.setColumns(3);

      calendarLeftDay07.setModelBindPath("CALENDAR_LEFT7");

      calendarLeftDay07.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay07.setBlankable(false);

      calendarLeftDay07.setMaxColumns(3);

      calendarLeftDay07.setModel(getCalendarLeftDay07Model());

      addCalendarLeftDay07();
    }
    return calendarLeftDay07;

  }

  /**
   * 7日モデルを取得します。
   * @return 7日モデル
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay07Model(){
    if(calendarLeftDay07Model==null){
      calendarLeftDay07Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay07Model();
    }
    return calendarLeftDay07Model;
  }

  /**
   * 8日を取得します。
   * @return 8日
   */
  public ACComboBox getCalendarLeftDay08(){
    if(calendarLeftDay08==null){

      calendarLeftDay08 = new ACComboBox();

      calendarLeftDay08.setBindPath("CALENDAR_LEFT_DAY8");

      calendarLeftDay08.setEditable(false);

      calendarLeftDay08.setColumns(3);

      calendarLeftDay08.setModelBindPath("CALENDAR_LEFT8");

      calendarLeftDay08.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay08.setBlankable(false);

      calendarLeftDay08.setMaxColumns(3);

      calendarLeftDay08.setModel(getCalendarLeftDay08Model());

      addCalendarLeftDay08();
    }
    return calendarLeftDay08;

  }

  /**
   * 8日モデルを取得します。
   * @return 8日モデル
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay08Model(){
    if(calendarLeftDay08Model==null){
      calendarLeftDay08Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay08Model();
    }
    return calendarLeftDay08Model;
  }

  /**
   * 9日を取得します。
   * @return 9日
   */
  public ACComboBox getCalendarLeftDay09(){
    if(calendarLeftDay09==null){

      calendarLeftDay09 = new ACComboBox();

      calendarLeftDay09.setBindPath("CALENDAR_LEFT_DAY9");

      calendarLeftDay09.setEditable(false);

      calendarLeftDay09.setColumns(3);

      calendarLeftDay09.setModelBindPath("CALENDAR_LEFT9");

      calendarLeftDay09.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay09.setBlankable(false);

      calendarLeftDay09.setMaxColumns(3);

      calendarLeftDay09.setModel(getCalendarLeftDay09Model());

      addCalendarLeftDay09();
    }
    return calendarLeftDay09;

  }

  /**
   * 9日モデルを取得します。
   * @return 9日モデル
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay09Model(){
    if(calendarLeftDay09Model==null){
      calendarLeftDay09Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay09Model();
    }
    return calendarLeftDay09Model;
  }

  /**
   * 10日を取得します。
   * @return 10日
   */
  public ACComboBox getCalendarLeftDay10(){
    if(calendarLeftDay10==null){

      calendarLeftDay10 = new ACComboBox();

      calendarLeftDay10.setBindPath("CALENDAR_LEFT_DAY10");

      calendarLeftDay10.setEditable(false);

      calendarLeftDay10.setColumns(3);

      calendarLeftDay10.setModelBindPath("CALENDAR_LEFT10");

      calendarLeftDay10.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay10.setBlankable(false);

      calendarLeftDay10.setMaxColumns(3);

      calendarLeftDay10.setModel(getCalendarLeftDay10Model());

      addCalendarLeftDay10();
    }
    return calendarLeftDay10;

  }

  /**
   * 10日モデルを取得します。
   * @return 10日モデル
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay10Model(){
    if(calendarLeftDay10Model==null){
      calendarLeftDay10Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay10Model();
    }
    return calendarLeftDay10Model;
  }

  /**
   * 11日を取得します。
   * @return 11日
   */
  public ACComboBox getCalendarLeftDay11(){
    if(calendarLeftDay11==null){

      calendarLeftDay11 = new ACComboBox();

      calendarLeftDay11.setBindPath("CALENDAR_LEFT_DAY11");

      calendarLeftDay11.setEditable(false);

      calendarLeftDay11.setColumns(3);

      calendarLeftDay11.setModelBindPath("CALENDAR_LEFT11");

      calendarLeftDay11.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay11.setBlankable(false);

      calendarLeftDay11.setMaxColumns(3);

      calendarLeftDay11.setModel(getCalendarLeftDay11Model());

      addCalendarLeftDay11();
    }
    return calendarLeftDay11;

  }

  /**
   * 11日モデルを取得します。
   * @return 11日モデル
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay11Model(){
    if(calendarLeftDay11Model==null){
      calendarLeftDay11Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay11Model();
    }
    return calendarLeftDay11Model;
  }

  /**
   * 12日を取得します。
   * @return 12日
   */
  public ACComboBox getCalendarLeftDay12(){
    if(calendarLeftDay12==null){

      calendarLeftDay12 = new ACComboBox();

      calendarLeftDay12.setBindPath("CALENDAR_LEFT_DAY12");

      calendarLeftDay12.setEditable(false);

      calendarLeftDay12.setColumns(3);

      calendarLeftDay12.setModelBindPath("CALENDAR_LEFT12");

      calendarLeftDay12.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay12.setBlankable(false);

      calendarLeftDay12.setMaxColumns(3);

      calendarLeftDay12.setModel(getCalendarLeftDay12Model());

      addCalendarLeftDay12();
    }
    return calendarLeftDay12;

  }

  /**
   * 12日モデルを取得します。
   * @return 12日モデル
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay12Model(){
    if(calendarLeftDay12Model==null){
      calendarLeftDay12Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay12Model();
    }
    return calendarLeftDay12Model;
  }

  /**
   * 13日を取得します。
   * @return 13日
   */
  public ACComboBox getCalendarLeftDay13(){
    if(calendarLeftDay13==null){

      calendarLeftDay13 = new ACComboBox();

      calendarLeftDay13.setBindPath("CALENDAR_LEFT_DAY13");

      calendarLeftDay13.setEditable(false);

      calendarLeftDay13.setColumns(3);

      calendarLeftDay13.setModelBindPath("CALENDAR_LEFT13");

      calendarLeftDay13.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay13.setBlankable(false);

      calendarLeftDay13.setMaxColumns(3);

      calendarLeftDay13.setModel(getCalendarLeftDay13Model());

      addCalendarLeftDay13();
    }
    return calendarLeftDay13;

  }

  /**
   * 13日モデルを取得します。
   * @return 13日モデル
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay13Model(){
    if(calendarLeftDay13Model==null){
      calendarLeftDay13Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay13Model();
    }
    return calendarLeftDay13Model;
  }

  /**
   * 14日を取得します。
   * @return 14日
   */
  public ACComboBox getCalendarLeftDay14(){
    if(calendarLeftDay14==null){

      calendarLeftDay14 = new ACComboBox();

      calendarLeftDay14.setBindPath("CALENDAR_LEFT_DAY14");

      calendarLeftDay14.setEditable(false);

      calendarLeftDay14.setColumns(3);

      calendarLeftDay14.setModelBindPath("CALENDAR_LEFT14");

      calendarLeftDay14.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay14.setBlankable(false);

      calendarLeftDay14.setMaxColumns(3);

      calendarLeftDay14.setModel(getCalendarLeftDay14Model());

      addCalendarLeftDay14();
    }
    return calendarLeftDay14;

  }

  /**
   * 14日モデルを取得します。
   * @return 14日モデル
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay14Model(){
    if(calendarLeftDay14Model==null){
      calendarLeftDay14Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay14Model();
    }
    return calendarLeftDay14Model;
  }

  /**
   * 15日を取得します。
   * @return 15日
   */
  public ACComboBox getCalendarLeftDay15(){
    if(calendarLeftDay15==null){

      calendarLeftDay15 = new ACComboBox();

      calendarLeftDay15.setBindPath("CALENDAR_LEFT_DAY15");

      calendarLeftDay15.setEditable(false);

      calendarLeftDay15.setColumns(3);

      calendarLeftDay15.setModelBindPath("CALENDAR_LEFT15");

      calendarLeftDay15.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay15.setBlankable(false);

      calendarLeftDay15.setMaxColumns(3);

      calendarLeftDay15.setModel(getCalendarLeftDay15Model());

      addCalendarLeftDay15();
    }
    return calendarLeftDay15;

  }

  /**
   * 15日モデルを取得します。
   * @return 15日モデル
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay15Model(){
    if(calendarLeftDay15Model==null){
      calendarLeftDay15Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay15Model();
    }
    return calendarLeftDay15Model;
  }

  /**
   * 16日を取得します。
   * @return 16日
   */
  public ACComboBox getCalendarLeftDay16(){
    if(calendarLeftDay16==null){

      calendarLeftDay16 = new ACComboBox();

      calendarLeftDay16.setBindPath("CALENDAR_LEFT_DAY16");

      calendarLeftDay16.setEditable(false);

      calendarLeftDay16.setColumns(3);

      calendarLeftDay16.setModelBindPath("CALENDAR_LEFT16");

      calendarLeftDay16.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay16.setBlankable(false);

      calendarLeftDay16.setMaxColumns(3);

      calendarLeftDay16.setModel(getCalendarLeftDay16Model());

      addCalendarLeftDay16();
    }
    return calendarLeftDay16;

  }

  /**
   * 16日モデルを取得します。
   * @return 16日モデル
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay16Model(){
    if(calendarLeftDay16Model==null){
      calendarLeftDay16Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay16Model();
    }
    return calendarLeftDay16Model;
  }

  /**
   * 17日を取得します。
   * @return 17日
   */
  public ACComboBox getCalendarLeftDay17(){
    if(calendarLeftDay17==null){

      calendarLeftDay17 = new ACComboBox();

      calendarLeftDay17.setBindPath("CALENDAR_LEFT_DAY17");

      calendarLeftDay17.setEditable(false);

      calendarLeftDay17.setColumns(3);

      calendarLeftDay17.setModelBindPath("CALENDAR_LEFT17");

      calendarLeftDay17.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay17.setBlankable(false);

      calendarLeftDay17.setMaxColumns(3);

      calendarLeftDay17.setModel(getCalendarLeftDay17Model());

      addCalendarLeftDay17();
    }
    return calendarLeftDay17;

  }

  /**
   * 17日モデルを取得します。
   * @return 17日モデル
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay17Model(){
    if(calendarLeftDay17Model==null){
      calendarLeftDay17Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay17Model();
    }
    return calendarLeftDay17Model;
  }

  /**
   * 18日を取得します。
   * @return 18日
   */
  public ACComboBox getCalendarLeftDay18(){
    if(calendarLeftDay18==null){

      calendarLeftDay18 = new ACComboBox();

      calendarLeftDay18.setBindPath("CALENDAR_LEFT_DAY18");

      calendarLeftDay18.setEditable(false);

      calendarLeftDay18.setColumns(3);

      calendarLeftDay18.setModelBindPath("CALENDAR_LEFT18");

      calendarLeftDay18.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay18.setBlankable(false);

      calendarLeftDay18.setMaxColumns(3);

      calendarLeftDay18.setModel(getCalendarLeftDay18Model());

      addCalendarLeftDay18();
    }
    return calendarLeftDay18;

  }

  /**
   * 18日モデルを取得します。
   * @return 18日モデル
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay18Model(){
    if(calendarLeftDay18Model==null){
      calendarLeftDay18Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay18Model();
    }
    return calendarLeftDay18Model;
  }

  /**
   * 19日を取得します。
   * @return 19日
   */
  public ACComboBox getCalendarLeftDay19(){
    if(calendarLeftDay19==null){

      calendarLeftDay19 = new ACComboBox();

      calendarLeftDay19.setBindPath("CALENDAR_LEFT_DAY19");

      calendarLeftDay19.setEditable(false);

      calendarLeftDay19.setColumns(3);

      calendarLeftDay19.setModelBindPath("CALENDAR_LEFT19");

      calendarLeftDay19.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay19.setBlankable(false);

      calendarLeftDay19.setMaxColumns(3);

      calendarLeftDay19.setModel(getCalendarLeftDay19Model());

      addCalendarLeftDay19();
    }
    return calendarLeftDay19;

  }

  /**
   * 19日モデルを取得します。
   * @return 19日モデル
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay19Model(){
    if(calendarLeftDay19Model==null){
      calendarLeftDay19Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay19Model();
    }
    return calendarLeftDay19Model;
  }

  /**
   * 20日を取得します。
   * @return 20日
   */
  public ACComboBox getCalendarLeftDay20(){
    if(calendarLeftDay20==null){

      calendarLeftDay20 = new ACComboBox();

      calendarLeftDay20.setBindPath("CALENDAR_LEFT_DAY20");

      calendarLeftDay20.setEditable(false);

      calendarLeftDay20.setColumns(3);

      calendarLeftDay20.setModelBindPath("CALENDAR_LEFT20");

      calendarLeftDay20.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay20.setBlankable(false);

      calendarLeftDay20.setMaxColumns(3);

      calendarLeftDay20.setModel(getCalendarLeftDay20Model());

      addCalendarLeftDay20();
    }
    return calendarLeftDay20;

  }

  /**
   * 20日モデルを取得します。
   * @return 20日モデル
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay20Model(){
    if(calendarLeftDay20Model==null){
      calendarLeftDay20Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay20Model();
    }
    return calendarLeftDay20Model;
  }

  /**
   * 21日を取得します。
   * @return 21日
   */
  public ACComboBox getCalendarLeftDay21(){
    if(calendarLeftDay21==null){

      calendarLeftDay21 = new ACComboBox();

      calendarLeftDay21.setBindPath("CALENDAR_LEFT_DAY21");

      calendarLeftDay21.setEditable(false);

      calendarLeftDay21.setColumns(3);

      calendarLeftDay21.setModelBindPath("CALENDAR_LEFT21");

      calendarLeftDay21.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay21.setBlankable(false);

      calendarLeftDay21.setMaxColumns(3);

      calendarLeftDay21.setModel(getCalendarLeftDay21Model());

      addCalendarLeftDay21();
    }
    return calendarLeftDay21;

  }

  /**
   * 21日モデルを取得します。
   * @return 21日モデル
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay21Model(){
    if(calendarLeftDay21Model==null){
      calendarLeftDay21Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay21Model();
    }
    return calendarLeftDay21Model;
  }

  /**
   * 22日を取得します。
   * @return 22日
   */
  public ACComboBox getCalendarLeftDay22(){
    if(calendarLeftDay22==null){

      calendarLeftDay22 = new ACComboBox();

      calendarLeftDay22.setBindPath("CALENDAR_LEFT_DAY22");

      calendarLeftDay22.setEditable(false);

      calendarLeftDay22.setColumns(3);

      calendarLeftDay22.setModelBindPath("CALENDAR_LEFT22");

      calendarLeftDay22.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay22.setBlankable(false);

      calendarLeftDay22.setMaxColumns(3);

      calendarLeftDay22.setModel(getCalendarLeftDay22Model());

      addCalendarLeftDay22();
    }
    return calendarLeftDay22;

  }

  /**
   * 22日モデルを取得します。
   * @return 22日モデル
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay22Model(){
    if(calendarLeftDay22Model==null){
      calendarLeftDay22Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay22Model();
    }
    return calendarLeftDay22Model;
  }

  /**
   * 23日を取得します。
   * @return 23日
   */
  public ACComboBox getCalendarLeftDay23(){
    if(calendarLeftDay23==null){

      calendarLeftDay23 = new ACComboBox();

      calendarLeftDay23.setBindPath("CALENDAR_LEFT_DAY23");

      calendarLeftDay23.setEditable(false);

      calendarLeftDay23.setColumns(3);

      calendarLeftDay23.setModelBindPath("CALENDAR_LEFT23");

      calendarLeftDay23.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay23.setBlankable(false);

      calendarLeftDay23.setMaxColumns(3);

      calendarLeftDay23.setModel(getCalendarLeftDay23Model());

      addCalendarLeftDay23();
    }
    return calendarLeftDay23;

  }

  /**
   * 23日モデルを取得します。
   * @return 23日モデル
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay23Model(){
    if(calendarLeftDay23Model==null){
      calendarLeftDay23Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay23Model();
    }
    return calendarLeftDay23Model;
  }

  /**
   * 24日を取得します。
   * @return 24日
   */
  public ACComboBox getCalendarLeftDay24(){
    if(calendarLeftDay24==null){

      calendarLeftDay24 = new ACComboBox();

      calendarLeftDay24.setBindPath("CALENDAR_LEFT_DAY24");

      calendarLeftDay24.setEditable(false);

      calendarLeftDay24.setColumns(3);

      calendarLeftDay24.setModelBindPath("CALENDAR_LEFT24");

      calendarLeftDay24.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay24.setBlankable(false);

      calendarLeftDay24.setMaxColumns(3);

      calendarLeftDay24.setModel(getCalendarLeftDay24Model());

      addCalendarLeftDay24();
    }
    return calendarLeftDay24;

  }

  /**
   * 24日モデルを取得します。
   * @return 24日モデル
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay24Model(){
    if(calendarLeftDay24Model==null){
      calendarLeftDay24Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay24Model();
    }
    return calendarLeftDay24Model;
  }

  /**
   * 25日を取得します。
   * @return 25日
   */
  public ACComboBox getCalendarLeftDay25(){
    if(calendarLeftDay25==null){

      calendarLeftDay25 = new ACComboBox();

      calendarLeftDay25.setBindPath("CALENDAR_LEFT_DAY25");

      calendarLeftDay25.setEditable(false);

      calendarLeftDay25.setColumns(3);

      calendarLeftDay25.setModelBindPath("CALENDAR_LEFT25");

      calendarLeftDay25.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay25.setBlankable(false);

      calendarLeftDay25.setMaxColumns(3);

      calendarLeftDay25.setModel(getCalendarLeftDay25Model());

      addCalendarLeftDay25();
    }
    return calendarLeftDay25;

  }

  /**
   * 25日モデルを取得します。
   * @return 25日モデル
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay25Model(){
    if(calendarLeftDay25Model==null){
      calendarLeftDay25Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay25Model();
    }
    return calendarLeftDay25Model;
  }

  /**
   * 26日を取得します。
   * @return 26日
   */
  public ACComboBox getCalendarLeftDay26(){
    if(calendarLeftDay26==null){

      calendarLeftDay26 = new ACComboBox();

      calendarLeftDay26.setBindPath("CALENDAR_LEFT_DAY26");

      calendarLeftDay26.setEditable(false);

      calendarLeftDay26.setColumns(3);

      calendarLeftDay26.setModelBindPath("CALENDAR_LEFT26");

      calendarLeftDay26.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay26.setBlankable(false);

      calendarLeftDay26.setMaxColumns(3);

      calendarLeftDay26.setModel(getCalendarLeftDay26Model());

      addCalendarLeftDay26();
    }
    return calendarLeftDay26;

  }

  /**
   * 26日モデルを取得します。
   * @return 26日モデル
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay26Model(){
    if(calendarLeftDay26Model==null){
      calendarLeftDay26Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay26Model();
    }
    return calendarLeftDay26Model;
  }

  /**
   * 27日を取得します。
   * @return 27日
   */
  public ACComboBox getCalendarLeftDay27(){
    if(calendarLeftDay27==null){

      calendarLeftDay27 = new ACComboBox();

      calendarLeftDay27.setBindPath("CALENDAR_LEFT_DAY27");

      calendarLeftDay27.setEditable(false);

      calendarLeftDay27.setColumns(3);

      calendarLeftDay27.setModelBindPath("CALENDAR_LEFT27");

      calendarLeftDay27.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay27.setBlankable(false);

      calendarLeftDay27.setMaxColumns(3);

      calendarLeftDay27.setModel(getCalendarLeftDay27Model());

      addCalendarLeftDay27();
    }
    return calendarLeftDay27;

  }

  /**
   * 27日モデルを取得します。
   * @return 27日モデル
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay27Model(){
    if(calendarLeftDay27Model==null){
      calendarLeftDay27Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay27Model();
    }
    return calendarLeftDay27Model;
  }

  /**
   * 28日を取得します。
   * @return 28日
   */
  public ACComboBox getCalendarLeftDay28(){
    if(calendarLeftDay28==null){

      calendarLeftDay28 = new ACComboBox();

      calendarLeftDay28.setBindPath("CALENDAR_LEFT_DAY28");

      calendarLeftDay28.setEditable(false);

      calendarLeftDay28.setColumns(3);

      calendarLeftDay28.setModelBindPath("CALENDAR_LEFT28");

      calendarLeftDay28.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay28.setBlankable(false);

      calendarLeftDay28.setMaxColumns(3);

      calendarLeftDay28.setModel(getCalendarLeftDay28Model());

      addCalendarLeftDay28();
    }
    return calendarLeftDay28;

  }

  /**
   * 28日モデルを取得します。
   * @return 28日モデル
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay28Model(){
    if(calendarLeftDay28Model==null){
      calendarLeftDay28Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay28Model();
    }
    return calendarLeftDay28Model;
  }

  /**
   * 29日パネルを取得します。
   * @return 29日パネル
   */
  public ACPanel getCalendarLeftDay29Panel(){
    if(calendarLeftDay29Panel==null){

      calendarLeftDay29Panel = new ACPanel();

      calendarLeftDay29Panel.setHgap(0);

      calendarLeftDay29Panel.setLabelMargin(0);

      calendarLeftDay29Panel.setVgap(0);

      addCalendarLeftDay29Panel();
    }
    return calendarLeftDay29Panel;

  }

  /**
   * 29ラベルを取得します。
   * @return 29ラベル
   */
  public ACLabel getCalendarLeftDay29Label(){
    if(calendarLeftDay29Label==null){

      calendarLeftDay29Label = new ACLabel();

      calendarLeftDay29Label.setVisible(false);

      addCalendarLeftDay29Label();
    }
    return calendarLeftDay29Label;

  }

  /**
   * 29日を取得します。
   * @return 29日
   */
  public ACComboBox getCalendarLeftDay29(){
    if(calendarLeftDay29==null){

      calendarLeftDay29 = new ACComboBox();

      calendarLeftDay29.setBindPath("CALENDAR_LEFT_DAY29");

      calendarLeftDay29.setEditable(false);

      calendarLeftDay29.setColumns(3);

      calendarLeftDay29.setModelBindPath("CALENDAR_LEFT29");

      calendarLeftDay29.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay29.setBlankable(false);

      calendarLeftDay29.setMaxColumns(3);

      calendarLeftDay29.setModel(getCalendarLeftDay29Model());

      addCalendarLeftDay29();
    }
    return calendarLeftDay29;

  }

  /**
   * 29日モデルを取得します。
   * @return 29日モデル
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay29Model(){
    if(calendarLeftDay29Model==null){
      calendarLeftDay29Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay29Model();
    }
    return calendarLeftDay29Model;
  }

  /**
   * 30日パネルを取得します。
   * @return 30日パネル
   */
  public ACPanel getCalendarLeftDay30Panel(){
    if(calendarLeftDay30Panel==null){

      calendarLeftDay30Panel = new ACPanel();

      calendarLeftDay30Panel.setHgap(0);

      calendarLeftDay30Panel.setLabelMargin(0);

      calendarLeftDay30Panel.setVgap(0);

      addCalendarLeftDay30Panel();
    }
    return calendarLeftDay30Panel;

  }

  /**
   * 30ラベルを取得します。
   * @return 30ラベル
   */
  public ACLabel getCalendarLeftDay30Label(){
    if(calendarLeftDay30Label==null){

      calendarLeftDay30Label = new ACLabel();

      calendarLeftDay30Label.setVisible(false);

      addCalendarLeftDay30Label();
    }
    return calendarLeftDay30Label;

  }

  /**
   * 30日を取得します。
   * @return 30日
   */
  public ACComboBox getCalendarLeftDay30(){
    if(calendarLeftDay30==null){

      calendarLeftDay30 = new ACComboBox();

      calendarLeftDay30.setBindPath("CALENDAR_LEFT_DAY30");

      calendarLeftDay30.setEditable(false);

      calendarLeftDay30.setColumns(3);

      calendarLeftDay30.setModelBindPath("CALENDAR_LEFT30");

      calendarLeftDay30.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay30.setBlankable(false);

      calendarLeftDay30.setMaxColumns(3);

      calendarLeftDay30.setModel(getCalendarLeftDay30Model());

      addCalendarLeftDay30();
    }
    return calendarLeftDay30;

  }

  /**
   * 30日モデルを取得します。
   * @return 30日モデル
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay30Model(){
    if(calendarLeftDay30Model==null){
      calendarLeftDay30Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay30Model();
    }
    return calendarLeftDay30Model;
  }

  /**
   * 31日パネルを取得します。
   * @return 31日パネル
   */
  public ACPanel getCalendarLeftDay31Panel(){
    if(calendarLeftDay31Panel==null){

      calendarLeftDay31Panel = new ACPanel();

      calendarLeftDay31Panel.setHgap(0);

      calendarLeftDay31Panel.setLabelMargin(0);

      calendarLeftDay31Panel.setVgap(0);

      addCalendarLeftDay31Panel();
    }
    return calendarLeftDay31Panel;

  }

  /**
   * 31ラベルを取得します。
   * @return 31ラベル
   */
  public ACLabel getCalendarLeftDay31Label(){
    if(calendarLeftDay31Label==null){

      calendarLeftDay31Label = new ACLabel();

      calendarLeftDay31Label.setVisible(false);

      addCalendarLeftDay31Label();
    }
    return calendarLeftDay31Label;

  }

  /**
   * 31日を取得します。
   * @return 31日
   */
  public ACComboBox getCalendarLeftDay31(){
    if(calendarLeftDay31==null){

      calendarLeftDay31 = new ACComboBox();

      calendarLeftDay31.setBindPath("CALENDAR_LEFT_DAY31");

      calendarLeftDay31.setEditable(false);

      calendarLeftDay31.setColumns(3);

      calendarLeftDay31.setModelBindPath("CALENDAR_LEFT31");

      calendarLeftDay31.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarLeftDay31.setBlankable(false);

      calendarLeftDay31.setMaxColumns(3);

      calendarLeftDay31.setModel(getCalendarLeftDay31Model());

      addCalendarLeftDay31();
    }
    return calendarLeftDay31;

  }

  /**
   * 31日モデルを取得します。
   * @return 31日モデル
   */
  protected ACComboBoxModelAdapter getCalendarLeftDay31Model(){
    if(calendarLeftDay31Model==null){
      calendarLeftDay31Model = new ACComboBoxModelAdapter();
      addCalendarLeftDay31Model();
    }
    return calendarLeftDay31Model;
  }

  /**
   * カレンダー(右領域)を取得します。
   * @return カレンダー(右領域)
   */
  public ACLabelContainer getCalendarRights(){
    if(calendarRights==null){

      calendarRights = new ACLabelContainer();

      calendarRights.setHgap(0);

      addCalendarRights();
    }
    return calendarRights;

  }

  /**
   * カレンダー(右)年月領域を取得します。
   * @return カレンダー(右)年月領域
   */
  public ACPanel getCalendarRightYearMonths(){
    if(calendarRightYearMonths==null){

      calendarRightYearMonths = new ACPanel();

      calendarRightYearMonths.setLayout(getCalendarRightYearMonthsLayout());

      addCalendarRightYearMonths();
    }
    return calendarRightYearMonths;

  }

  /**
   * カレンダー(右)年月領域レイアウトを取得します。
   * @return カレンダー(右)年月領域レイアウト
   */
  public VRLayout getCalendarRightYearMonthsLayout(){
    if(calendarRightYearMonthsLayout==null){

      calendarRightYearMonthsLayout = new VRLayout();

      calendarRightYearMonthsLayout.setAlignment(SwingConstants.CENTER);

      calendarRightYearMonthsLayout.setAutoWrap(false);

      addCalendarRightYearMonthsLayout();
    }
    return calendarRightYearMonthsLayout;

  }

  /**
   * 平成キャプションを取得します。
   * @return 平成キャプション
   */
  public ACLabel getCalendarRightCaption(){
    if(calendarRightCaption==null){

      calendarRightCaption = new ACLabel();

      calendarRightCaption.setText("平成");

      addCalendarRightCaption();
    }
    return calendarRightCaption;

  }

  /**
   * 年を取得します。
   * @return 年
   */
  public ACLabel getCalendarRightYear(){
    if(calendarRightYear==null){

      calendarRightYear = new ACLabel();

      calendarRightYear.setBindPath("CALENDAR_RIGHT_YEAR");

      addCalendarRightYear();
    }
    return calendarRightYear;

  }

  /**
   * 年キャプションを取得します。
   * @return 年キャプション
   */
  public ACLabel getCalendarRightYearCaption(){
    if(calendarRightYearCaption==null){

      calendarRightYearCaption = new ACLabel();

      calendarRightYearCaption.setText("年");

      addCalendarRightYearCaption();
    }
    return calendarRightYearCaption;

  }

  /**
   * 月を取得します。
   * @return 月
   */
  public ACLabel getCalendarRightMonth(){
    if(calendarRightMonth==null){

      calendarRightMonth = new ACLabel();

      calendarRightMonth.setBindPath("CALENDAR_RIGHT_MONTH");

      addCalendarRightMonth();
    }
    return calendarRightMonth;

  }

  /**
   * 月キャプションを取得します。
   * @return 月キャプション
   */
  public ACLabel getCalendarRightMonthCaption(){
    if(calendarRightMonthCaption==null){

      calendarRightMonthCaption = new ACLabel();

      calendarRightMonthCaption.setText("月");

      addCalendarRightMonthCaption();
    }
    return calendarRightMonthCaption;

  }

  /**
   * カレンダー(右日付領域)を取得します。
   * @return カレンダー(右日付領域)
   */
  public ACPanel getCalendarRightDayContainer(){
    if(calendarRightDayContainer==null){

      calendarRightDayContainer = new ACPanel();

      calendarRightDayContainer.setAutoWrap(false);

      calendarRightDayContainer.setHgap(0);

      calendarRightDayContainer.setVgap(0);

      addCalendarRightDayContainer();
    }
    return calendarRightDayContainer;

  }

  /**
   * 1日を取得します。
   * @return 1日
   */
  public ACComboBox getCalendarRightDay01(){
    if(calendarRightDay01==null){

      calendarRightDay01 = new ACComboBox();

      calendarRightDay01.setBindPath("CALENDAR_RIGHT_DAY1");

      calendarRightDay01.setEditable(false);

      calendarRightDay01.setColumns(3);

      calendarRightDay01.setModelBindPath("CALENDAR_RIGHT1");

      calendarRightDay01.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay01.setBlankable(false);

      calendarRightDay01.setMaxColumns(3);

      calendarRightDay01.setModel(getCalendarRightDay01Model());

      addCalendarRightDay01();
    }
    return calendarRightDay01;

  }

  /**
   * 1日モデルを取得します。
   * @return 1日モデル
   */
  protected ACComboBoxModelAdapter getCalendarRightDay01Model(){
    if(calendarRightDay01Model==null){
      calendarRightDay01Model = new ACComboBoxModelAdapter();
      addCalendarRightDay01Model();
    }
    return calendarRightDay01Model;
  }

  /**
   * 2日を取得します。
   * @return 2日
   */
  public ACComboBox getCalendarRightDay02(){
    if(calendarRightDay02==null){

      calendarRightDay02 = new ACComboBox();

      calendarRightDay02.setBindPath("CALENDAR_RIGHT_DAY2");

      calendarRightDay02.setEditable(false);

      calendarRightDay02.setColumns(3);

      calendarRightDay02.setModelBindPath("CALENDAR_RIGHT2");

      calendarRightDay02.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay02.setBlankable(false);

      calendarRightDay02.setMaxColumns(3);

      calendarRightDay02.setModel(getCalendarRightDay02Model());

      addCalendarRightDay02();
    }
    return calendarRightDay02;

  }

  /**
   * 2日モデルを取得します。
   * @return 2日モデル
   */
  protected ACComboBoxModelAdapter getCalendarRightDay02Model(){
    if(calendarRightDay02Model==null){
      calendarRightDay02Model = new ACComboBoxModelAdapter();
      addCalendarRightDay02Model();
    }
    return calendarRightDay02Model;
  }

  /**
   * 3日を取得します。
   * @return 3日
   */
  public ACComboBox getCalendarRightDay03(){
    if(calendarRightDay03==null){

      calendarRightDay03 = new ACComboBox();

      calendarRightDay03.setBindPath("CALENDAR_RIGHT_DAY3");

      calendarRightDay03.setEditable(false);

      calendarRightDay03.setColumns(3);

      calendarRightDay03.setModelBindPath("CALENDAR_RIGHT3");

      calendarRightDay03.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay03.setBlankable(false);

      calendarRightDay03.setMaxColumns(3);

      calendarRightDay03.setModel(getCalendarRightDay03Model());

      addCalendarRightDay03();
    }
    return calendarRightDay03;

  }

  /**
   * 3日モデルを取得します。
   * @return 3日モデル
   */
  protected ACComboBoxModelAdapter getCalendarRightDay03Model(){
    if(calendarRightDay03Model==null){
      calendarRightDay03Model = new ACComboBoxModelAdapter();
      addCalendarRightDay03Model();
    }
    return calendarRightDay03Model;
  }

  /**
   * 4日を取得します。
   * @return 4日
   */
  public ACComboBox getCalendarRightDay04(){
    if(calendarRightDay04==null){

      calendarRightDay04 = new ACComboBox();

      calendarRightDay04.setBindPath("CALENDAR_RIGHT_DAY4");

      calendarRightDay04.setEditable(false);

      calendarRightDay04.setColumns(3);

      calendarRightDay04.setModelBindPath("CALENDAR_RIGHT4");

      calendarRightDay04.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay04.setBlankable(false);

      calendarRightDay04.setMaxColumns(3);

      calendarRightDay04.setModel(getCalendarRightDay04Model());

      addCalendarRightDay04();
    }
    return calendarRightDay04;

  }

  /**
   * 4日モデルを取得します。
   * @return 4日モデル
   */
  protected ACComboBoxModelAdapter getCalendarRightDay04Model(){
    if(calendarRightDay04Model==null){
      calendarRightDay04Model = new ACComboBoxModelAdapter();
      addCalendarRightDay04Model();
    }
    return calendarRightDay04Model;
  }

  /**
   * 5日を取得します。
   * @return 5日
   */
  public ACComboBox getCalendarRightDay05(){
    if(calendarRightDay05==null){

      calendarRightDay05 = new ACComboBox();

      calendarRightDay05.setBindPath("CALENDAR_RIGHT_DAY5");

      calendarRightDay05.setEditable(false);

      calendarRightDay05.setColumns(3);

      calendarRightDay05.setModelBindPath("CALENDAR_RIGHT5");

      calendarRightDay05.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay05.setBlankable(false);

      calendarRightDay05.setMaxColumns(3);

      calendarRightDay05.setModel(getCalendarRightDay05Model());

      addCalendarRightDay05();
    }
    return calendarRightDay05;

  }

  /**
   * 5日モデルを取得します。
   * @return 5日モデル
   */
  protected ACComboBoxModelAdapter getCalendarRightDay05Model(){
    if(calendarRightDay05Model==null){
      calendarRightDay05Model = new ACComboBoxModelAdapter();
      addCalendarRightDay05Model();
    }
    return calendarRightDay05Model;
  }

  /**
   * 6日を取得します。
   * @return 6日
   */
  public ACComboBox getCalendarRightDay06(){
    if(calendarRightDay06==null){

      calendarRightDay06 = new ACComboBox();

      calendarRightDay06.setBindPath("CALENDAR_RIGHT_DAY6");

      calendarRightDay06.setEditable(false);

      calendarRightDay06.setColumns(3);

      calendarRightDay06.setModelBindPath("CALENDAR_RIGHT6");

      calendarRightDay06.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay06.setBlankable(false);

      calendarRightDay06.setMaxColumns(3);

      calendarRightDay06.setModel(getCalendarRightDay06Model());

      addCalendarRightDay06();
    }
    return calendarRightDay06;

  }

  /**
   * 6日モデルを取得します。
   * @return 6日モデル
   */
  protected ACComboBoxModelAdapter getCalendarRightDay06Model(){
    if(calendarRightDay06Model==null){
      calendarRightDay06Model = new ACComboBoxModelAdapter();
      addCalendarRightDay06Model();
    }
    return calendarRightDay06Model;
  }

  /**
   * 7日を取得します。
   * @return 7日
   */
  public ACComboBox getCalendarRightDay07(){
    if(calendarRightDay07==null){

      calendarRightDay07 = new ACComboBox();

      calendarRightDay07.setBindPath("CALENDAR_RIGHT_DAY7");

      calendarRightDay07.setEditable(false);

      calendarRightDay07.setColumns(3);

      calendarRightDay07.setModelBindPath("CALENDAR_RIGHT7");

      calendarRightDay07.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay07.setBlankable(false);

      calendarRightDay07.setMaxColumns(3);

      calendarRightDay07.setModel(getCalendarRightDay07Model());

      addCalendarRightDay07();
    }
    return calendarRightDay07;

  }

  /**
   * 7日モデルを取得します。
   * @return 7日モデル
   */
  protected ACComboBoxModelAdapter getCalendarRightDay07Model(){
    if(calendarRightDay07Model==null){
      calendarRightDay07Model = new ACComboBoxModelAdapter();
      addCalendarRightDay07Model();
    }
    return calendarRightDay07Model;
  }

  /**
   * 8日を取得します。
   * @return 8日
   */
  public ACComboBox getCalendarRightDay08(){
    if(calendarRightDay08==null){

      calendarRightDay08 = new ACComboBox();

      calendarRightDay08.setBindPath("CALENDAR_RIGHT_DAY8");

      calendarRightDay08.setEditable(false);

      calendarRightDay08.setColumns(3);

      calendarRightDay08.setModelBindPath("CALENDAR_RIGHT8");

      calendarRightDay08.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay08.setBlankable(false);

      calendarRightDay08.setMaxColumns(3);

      calendarRightDay08.setModel(getCalendarRightDay08Model());

      addCalendarRightDay08();
    }
    return calendarRightDay08;

  }

  /**
   * 8日モデルを取得します。
   * @return 8日モデル
   */
  protected ACComboBoxModelAdapter getCalendarRightDay08Model(){
    if(calendarRightDay08Model==null){
      calendarRightDay08Model = new ACComboBoxModelAdapter();
      addCalendarRightDay08Model();
    }
    return calendarRightDay08Model;
  }

  /**
   * 9日を取得します。
   * @return 9日
   */
  public ACComboBox getCalendarRightDay09(){
    if(calendarRightDay09==null){

      calendarRightDay09 = new ACComboBox();

      calendarRightDay09.setBindPath("CALENDAR_RIGHT_DAY9");

      calendarRightDay09.setEditable(false);

      calendarRightDay09.setColumns(3);

      calendarRightDay09.setModelBindPath("CALENDAR_RIGHT9");

      calendarRightDay09.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay09.setBlankable(false);

      calendarRightDay09.setMaxColumns(3);

      calendarRightDay09.setModel(getCalendarRightDay09Model());

      addCalendarRightDay09();
    }
    return calendarRightDay09;

  }

  /**
   * 9日モデルを取得します。
   * @return 9日モデル
   */
  protected ACComboBoxModelAdapter getCalendarRightDay09Model(){
    if(calendarRightDay09Model==null){
      calendarRightDay09Model = new ACComboBoxModelAdapter();
      addCalendarRightDay09Model();
    }
    return calendarRightDay09Model;
  }

  /**
   * 10日を取得します。
   * @return 10日
   */
  public ACComboBox getCalendarRightDay10(){
    if(calendarRightDay10==null){

      calendarRightDay10 = new ACComboBox();

      calendarRightDay10.setBindPath("CALENDAR_RIGHT_DAY10");

      calendarRightDay10.setEditable(false);

      calendarRightDay10.setColumns(3);

      calendarRightDay10.setModelBindPath("CALENDAR_RIGHT10");

      calendarRightDay10.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay10.setBlankable(false);

      calendarRightDay10.setMaxColumns(3);

      calendarRightDay10.setModel(getCalendarRightDay10Model());

      addCalendarRightDay10();
    }
    return calendarRightDay10;

  }

  /**
   * 10日モデルを取得します。
   * @return 10日モデル
   */
  protected ACComboBoxModelAdapter getCalendarRightDay10Model(){
    if(calendarRightDay10Model==null){
      calendarRightDay10Model = new ACComboBoxModelAdapter();
      addCalendarRightDay10Model();
    }
    return calendarRightDay10Model;
  }

  /**
   * 11日を取得します。
   * @return 11日
   */
  public ACComboBox getCalendarRightDay11(){
    if(calendarRightDay11==null){

      calendarRightDay11 = new ACComboBox();

      calendarRightDay11.setBindPath("CALENDAR_RIGHT_DAY11");

      calendarRightDay11.setEditable(false);

      calendarRightDay11.setColumns(3);

      calendarRightDay11.setModelBindPath("CALENDAR_RIGHT11");

      calendarRightDay11.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay11.setBlankable(false);

      calendarRightDay11.setMaxColumns(3);

      calendarRightDay11.setModel(getCalendarRightDay11Model());

      addCalendarRightDay11();
    }
    return calendarRightDay11;

  }

  /**
   * 11日モデルを取得します。
   * @return 11日モデル
   */
  protected ACComboBoxModelAdapter getCalendarRightDay11Model(){
    if(calendarRightDay11Model==null){
      calendarRightDay11Model = new ACComboBoxModelAdapter();
      addCalendarRightDay11Model();
    }
    return calendarRightDay11Model;
  }

  /**
   * 12日を取得します。
   * @return 12日
   */
  public ACComboBox getCalendarRightDay12(){
    if(calendarRightDay12==null){

      calendarRightDay12 = new ACComboBox();

      calendarRightDay12.setBindPath("CALENDAR_RIGHT_DAY12");

      calendarRightDay12.setEditable(false);

      calendarRightDay12.setColumns(3);

      calendarRightDay12.setModelBindPath("CALENDAR_RIGHT12");

      calendarRightDay12.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay12.setBlankable(false);

      calendarRightDay12.setMaxColumns(3);

      calendarRightDay12.setModel(getCalendarRightDay12Model());

      addCalendarRightDay12();
    }
    return calendarRightDay12;

  }

  /**
   * 12日モデルを取得します。
   * @return 12日モデル
   */
  protected ACComboBoxModelAdapter getCalendarRightDay12Model(){
    if(calendarRightDay12Model==null){
      calendarRightDay12Model = new ACComboBoxModelAdapter();
      addCalendarRightDay12Model();
    }
    return calendarRightDay12Model;
  }

  /**
   * 13日を取得します。
   * @return 13日
   */
  public ACComboBox getCalendarRightDay13(){
    if(calendarRightDay13==null){

      calendarRightDay13 = new ACComboBox();

      calendarRightDay13.setBindPath("CALENDAR_RIGHT_DAY13");

      calendarRightDay13.setEditable(false);

      calendarRightDay13.setColumns(3);

      calendarRightDay13.setModelBindPath("CALENDAR_RIGHT13");

      calendarRightDay13.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay13.setBlankable(false);

      calendarRightDay13.setMaxColumns(3);

      calendarRightDay13.setModel(getCalendarRightDay13Model());

      addCalendarRightDay13();
    }
    return calendarRightDay13;

  }

  /**
   * 13日モデルを取得します。
   * @return 13日モデル
   */
  protected ACComboBoxModelAdapter getCalendarRightDay13Model(){
    if(calendarRightDay13Model==null){
      calendarRightDay13Model = new ACComboBoxModelAdapter();
      addCalendarRightDay13Model();
    }
    return calendarRightDay13Model;
  }

  /**
   * 14日を取得します。
   * @return 14日
   */
  public ACComboBox getCalendarRightDay14(){
    if(calendarRightDay14==null){

      calendarRightDay14 = new ACComboBox();

      calendarRightDay14.setBindPath("CALENDAR_RIGHT_DAY14");

      calendarRightDay14.setEditable(false);

      calendarRightDay14.setColumns(3);

      calendarRightDay14.setModelBindPath("CALENDAR_RIGHT14");

      calendarRightDay14.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay14.setBlankable(false);

      calendarRightDay14.setMaxColumns(3);

      calendarRightDay14.setModel(getCalendarRightDay14Model());

      addCalendarRightDay14();
    }
    return calendarRightDay14;

  }

  /**
   * 14日モデルを取得します。
   * @return 14日モデル
   */
  protected ACComboBoxModelAdapter getCalendarRightDay14Model(){
    if(calendarRightDay14Model==null){
      calendarRightDay14Model = new ACComboBoxModelAdapter();
      addCalendarRightDay14Model();
    }
    return calendarRightDay14Model;
  }

  /**
   * 15日を取得します。
   * @return 15日
   */
  public ACComboBox getCalendarRightDay15(){
    if(calendarRightDay15==null){

      calendarRightDay15 = new ACComboBox();

      calendarRightDay15.setBindPath("CALENDAR_RIGHT_DAY15");

      calendarRightDay15.setEditable(false);

      calendarRightDay15.setColumns(3);

      calendarRightDay15.setModelBindPath("CALENDAR_RIGHT15");

      calendarRightDay15.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay15.setBlankable(false);

      calendarRightDay15.setMaxColumns(3);

      calendarRightDay15.setModel(getCalendarRightDay15Model());

      addCalendarRightDay15();
    }
    return calendarRightDay15;

  }

  /**
   * 15日モデルを取得します。
   * @return 15日モデル
   */
  protected ACComboBoxModelAdapter getCalendarRightDay15Model(){
    if(calendarRightDay15Model==null){
      calendarRightDay15Model = new ACComboBoxModelAdapter();
      addCalendarRightDay15Model();
    }
    return calendarRightDay15Model;
  }

  /**
   * 16日を取得します。
   * @return 16日
   */
  public ACComboBox getCalendarRightDay16(){
    if(calendarRightDay16==null){

      calendarRightDay16 = new ACComboBox();

      calendarRightDay16.setBindPath("CALENDAR_RIGHT_DAY16");

      calendarRightDay16.setEditable(false);

      calendarRightDay16.setColumns(3);

      calendarRightDay16.setModelBindPath("CALENDAR_RIGHT16");

      calendarRightDay16.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay16.setBlankable(false);

      calendarRightDay16.setMaxColumns(3);

      calendarRightDay16.setModel(getCalendarRightDay16Model());

      addCalendarRightDay16();
    }
    return calendarRightDay16;

  }

  /**
   * 16日モデルを取得します。
   * @return 16日モデル
   */
  protected ACComboBoxModelAdapter getCalendarRightDay16Model(){
    if(calendarRightDay16Model==null){
      calendarRightDay16Model = new ACComboBoxModelAdapter();
      addCalendarRightDay16Model();
    }
    return calendarRightDay16Model;
  }

  /**
   * 17日を取得します。
   * @return 17日
   */
  public ACComboBox getCalendarRightDay17(){
    if(calendarRightDay17==null){

      calendarRightDay17 = new ACComboBox();

      calendarRightDay17.setBindPath("CALENDAR_RIGHT_DAY17");

      calendarRightDay17.setEditable(false);

      calendarRightDay17.setColumns(3);

      calendarRightDay17.setModelBindPath("CALENDAR_RIGHT17");

      calendarRightDay17.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay17.setBlankable(false);

      calendarRightDay17.setMaxColumns(3);

      calendarRightDay17.setModel(getCalendarRightDay17Model());

      addCalendarRightDay17();
    }
    return calendarRightDay17;

  }

  /**
   * 17日モデルを取得します。
   * @return 17日モデル
   */
  protected ACComboBoxModelAdapter getCalendarRightDay17Model(){
    if(calendarRightDay17Model==null){
      calendarRightDay17Model = new ACComboBoxModelAdapter();
      addCalendarRightDay17Model();
    }
    return calendarRightDay17Model;
  }

  /**
   * 18日を取得します。
   * @return 18日
   */
  public ACComboBox getCalendarRightDay18(){
    if(calendarRightDay18==null){

      calendarRightDay18 = new ACComboBox();

      calendarRightDay18.setBindPath("CALENDAR_RIGHT_DAY18");

      calendarRightDay18.setEditable(false);

      calendarRightDay18.setColumns(3);

      calendarRightDay18.setModelBindPath("CALENDAR_RIGHT18");

      calendarRightDay18.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay18.setBlankable(false);

      calendarRightDay18.setMaxColumns(3);

      calendarRightDay18.setModel(getCalendarRightDay18Model());

      addCalendarRightDay18();
    }
    return calendarRightDay18;

  }

  /**
   * 18日モデルを取得します。
   * @return 18日モデル
   */
  protected ACComboBoxModelAdapter getCalendarRightDay18Model(){
    if(calendarRightDay18Model==null){
      calendarRightDay18Model = new ACComboBoxModelAdapter();
      addCalendarRightDay18Model();
    }
    return calendarRightDay18Model;
  }

  /**
   * 19日を取得します。
   * @return 19日
   */
  public ACComboBox getCalendarRightDay19(){
    if(calendarRightDay19==null){

      calendarRightDay19 = new ACComboBox();

      calendarRightDay19.setBindPath("CALENDAR_RIGHT_DAY19");

      calendarRightDay19.setEditable(false);

      calendarRightDay19.setColumns(3);

      calendarRightDay19.setModelBindPath("CALENDAR_RIGHT19");

      calendarRightDay19.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay19.setBlankable(false);

      calendarRightDay19.setMaxColumns(3);

      calendarRightDay19.setModel(getCalendarRightDay19Model());

      addCalendarRightDay19();
    }
    return calendarRightDay19;

  }

  /**
   * 19日モデルを取得します。
   * @return 19日モデル
   */
  protected ACComboBoxModelAdapter getCalendarRightDay19Model(){
    if(calendarRightDay19Model==null){
      calendarRightDay19Model = new ACComboBoxModelAdapter();
      addCalendarRightDay19Model();
    }
    return calendarRightDay19Model;
  }

  /**
   * 20日を取得します。
   * @return 20日
   */
  public ACComboBox getCalendarRightDay20(){
    if(calendarRightDay20==null){

      calendarRightDay20 = new ACComboBox();

      calendarRightDay20.setBindPath("CALENDAR_RIGHT_DAY20");

      calendarRightDay20.setEditable(false);

      calendarRightDay20.setColumns(3);

      calendarRightDay20.setModelBindPath("CALENDAR_RIGHT20");

      calendarRightDay20.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay20.setBlankable(false);

      calendarRightDay20.setMaxColumns(3);

      calendarRightDay20.setModel(getCalendarRightDay20Model());

      addCalendarRightDay20();
    }
    return calendarRightDay20;

  }

  /**
   * 20日モデルを取得します。
   * @return 20日モデル
   */
  protected ACComboBoxModelAdapter getCalendarRightDay20Model(){
    if(calendarRightDay20Model==null){
      calendarRightDay20Model = new ACComboBoxModelAdapter();
      addCalendarRightDay20Model();
    }
    return calendarRightDay20Model;
  }

  /**
   * 21日を取得します。
   * @return 21日
   */
  public ACComboBox getCalendarRightDay21(){
    if(calendarRightDay21==null){

      calendarRightDay21 = new ACComboBox();

      calendarRightDay21.setBindPath("CALENDAR_RIGHT_DAY21");

      calendarRightDay21.setEditable(false);

      calendarRightDay21.setColumns(3);

      calendarRightDay21.setModelBindPath("CALENDAR_RIGHT21");

      calendarRightDay21.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay21.setBlankable(false);

      calendarRightDay21.setMaxColumns(3);

      calendarRightDay21.setModel(getCalendarRightDay21Model());

      addCalendarRightDay21();
    }
    return calendarRightDay21;

  }

  /**
   * 21日モデルを取得します。
   * @return 21日モデル
   */
  protected ACComboBoxModelAdapter getCalendarRightDay21Model(){
    if(calendarRightDay21Model==null){
      calendarRightDay21Model = new ACComboBoxModelAdapter();
      addCalendarRightDay21Model();
    }
    return calendarRightDay21Model;
  }

  /**
   * 22日を取得します。
   * @return 22日
   */
  public ACComboBox getCalendarRightDay22(){
    if(calendarRightDay22==null){

      calendarRightDay22 = new ACComboBox();

      calendarRightDay22.setBindPath("CALENDAR_RIGHT_DAY22");

      calendarRightDay22.setEditable(false);

      calendarRightDay22.setColumns(3);

      calendarRightDay22.setModelBindPath("CALENDAR_RIGHT22");

      calendarRightDay22.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay22.setBlankable(false);

      calendarRightDay22.setMaxColumns(3);

      calendarRightDay22.setModel(getCalendarRightDay22Model());

      addCalendarRightDay22();
    }
    return calendarRightDay22;

  }

  /**
   * 22日モデルを取得します。
   * @return 22日モデル
   */
  protected ACComboBoxModelAdapter getCalendarRightDay22Model(){
    if(calendarRightDay22Model==null){
      calendarRightDay22Model = new ACComboBoxModelAdapter();
      addCalendarRightDay22Model();
    }
    return calendarRightDay22Model;
  }

  /**
   * 23日を取得します。
   * @return 23日
   */
  public ACComboBox getCalendarRightDay23(){
    if(calendarRightDay23==null){

      calendarRightDay23 = new ACComboBox();

      calendarRightDay23.setBindPath("CALENDAR_RIGHT_DAY23");

      calendarRightDay23.setEditable(false);

      calendarRightDay23.setColumns(3);

      calendarRightDay23.setModelBindPath("CALENDAR_RIGHT23");

      calendarRightDay23.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay23.setBlankable(false);

      calendarRightDay23.setMaxColumns(3);

      calendarRightDay23.setModel(getCalendarRightDay23Model());

      addCalendarRightDay23();
    }
    return calendarRightDay23;

  }

  /**
   * 23日モデルを取得します。
   * @return 23日モデル
   */
  protected ACComboBoxModelAdapter getCalendarRightDay23Model(){
    if(calendarRightDay23Model==null){
      calendarRightDay23Model = new ACComboBoxModelAdapter();
      addCalendarRightDay23Model();
    }
    return calendarRightDay23Model;
  }

  /**
   * 24日を取得します。
   * @return 24日
   */
  public ACComboBox getCalendarRightDay24(){
    if(calendarRightDay24==null){

      calendarRightDay24 = new ACComboBox();

      calendarRightDay24.setBindPath("CALENDAR_RIGHT_DAY24");

      calendarRightDay24.setEditable(false);

      calendarRightDay24.setColumns(3);

      calendarRightDay24.setModelBindPath("CALENDAR_RIGHT24");

      calendarRightDay24.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay24.setBlankable(false);

      calendarRightDay24.setMaxColumns(3);

      calendarRightDay24.setModel(getCalendarRightDay24Model());

      addCalendarRightDay24();
    }
    return calendarRightDay24;

  }

  /**
   * 24日モデルを取得します。
   * @return 24日モデル
   */
  protected ACComboBoxModelAdapter getCalendarRightDay24Model(){
    if(calendarRightDay24Model==null){
      calendarRightDay24Model = new ACComboBoxModelAdapter();
      addCalendarRightDay24Model();
    }
    return calendarRightDay24Model;
  }

  /**
   * 25日を取得します。
   * @return 25日
   */
  public ACComboBox getCalendarRightDay25(){
    if(calendarRightDay25==null){

      calendarRightDay25 = new ACComboBox();

      calendarRightDay25.setBindPath("CALENDAR_RIGHT_DAY25");

      calendarRightDay25.setEditable(false);

      calendarRightDay25.setColumns(3);

      calendarRightDay25.setModelBindPath("CALENDAR_RIGHT25");

      calendarRightDay25.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay25.setBlankable(false);

      calendarRightDay25.setMaxColumns(3);

      calendarRightDay25.setModel(getCalendarRightDay25Model());

      addCalendarRightDay25();
    }
    return calendarRightDay25;

  }

  /**
   * 25日モデルを取得します。
   * @return 25日モデル
   */
  protected ACComboBoxModelAdapter getCalendarRightDay25Model(){
    if(calendarRightDay25Model==null){
      calendarRightDay25Model = new ACComboBoxModelAdapter();
      addCalendarRightDay25Model();
    }
    return calendarRightDay25Model;
  }

  /**
   * 26日を取得します。
   * @return 26日
   */
  public ACComboBox getCalendarRightDay26(){
    if(calendarRightDay26==null){

      calendarRightDay26 = new ACComboBox();

      calendarRightDay26.setBindPath("CALENDAR_RIGHT_DAY26");

      calendarRightDay26.setEditable(false);

      calendarRightDay26.setColumns(3);

      calendarRightDay26.setModelBindPath("CALENDAR_RIGHT26");

      calendarRightDay26.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay26.setBlankable(false);

      calendarRightDay26.setMaxColumns(3);

      calendarRightDay26.setModel(getCalendarRightDay26Model());

      addCalendarRightDay26();
    }
    return calendarRightDay26;

  }

  /**
   * 26日モデルを取得します。
   * @return 26日モデル
   */
  protected ACComboBoxModelAdapter getCalendarRightDay26Model(){
    if(calendarRightDay26Model==null){
      calendarRightDay26Model = new ACComboBoxModelAdapter();
      addCalendarRightDay26Model();
    }
    return calendarRightDay26Model;
  }

  /**
   * 27日を取得します。
   * @return 27日
   */
  public ACComboBox getCalendarRightDay27(){
    if(calendarRightDay27==null){

      calendarRightDay27 = new ACComboBox();

      calendarRightDay27.setBindPath("CALENDAR_RIGHT_DAY27");

      calendarRightDay27.setEditable(false);

      calendarRightDay27.setColumns(3);

      calendarRightDay27.setModelBindPath("CALENDAR_RIGHT27");

      calendarRightDay27.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay27.setBlankable(false);

      calendarRightDay27.setMaxColumns(3);

      calendarRightDay27.setModel(getCalendarRightDay27Model());

      addCalendarRightDay27();
    }
    return calendarRightDay27;

  }

  /**
   * 27日モデルを取得します。
   * @return 27日モデル
   */
  protected ACComboBoxModelAdapter getCalendarRightDay27Model(){
    if(calendarRightDay27Model==null){
      calendarRightDay27Model = new ACComboBoxModelAdapter();
      addCalendarRightDay27Model();
    }
    return calendarRightDay27Model;
  }

  /**
   * 28日を取得します。
   * @return 28日
   */
  public ACComboBox getCalendarRightDay28(){
    if(calendarRightDay28==null){

      calendarRightDay28 = new ACComboBox();

      calendarRightDay28.setBindPath("CALENDAR_RIGHT_DAY28");

      calendarRightDay28.setEditable(false);

      calendarRightDay28.setColumns(3);

      calendarRightDay28.setModelBindPath("CALENDAR_RIGHT28");

      calendarRightDay28.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay28.setBlankable(false);

      calendarRightDay28.setMaxColumns(3);

      calendarRightDay28.setModel(getCalendarRightDay28Model());

      addCalendarRightDay28();
    }
    return calendarRightDay28;

  }

  /**
   * 28日モデルを取得します。
   * @return 28日モデル
   */
  protected ACComboBoxModelAdapter getCalendarRightDay28Model(){
    if(calendarRightDay28Model==null){
      calendarRightDay28Model = new ACComboBoxModelAdapter();
      addCalendarRightDay28Model();
    }
    return calendarRightDay28Model;
  }

  /**
   * 29日パネルを取得します。
   * @return 29日パネル
   */
  public ACPanel getCalendarRightDay29Panel(){
    if(calendarRightDay29Panel==null){

      calendarRightDay29Panel = new ACPanel();

      addCalendarRightDay29Panel();
    }
    return calendarRightDay29Panel;

  }

  /**
   * 29ラベルを取得します。
   * @return 29ラベル
   */
  public ACLabel getCalendarRightDay29Label(){
    if(calendarRightDay29Label==null){

      calendarRightDay29Label = new ACLabel();

      calendarRightDay29Label.setVisible(false);

      addCalendarRightDay29Label();
    }
    return calendarRightDay29Label;

  }

  /**
   * 29日を取得します。
   * @return 29日
   */
  public ACComboBox getCalendarRightDay29(){
    if(calendarRightDay29==null){

      calendarRightDay29 = new ACComboBox();

      calendarRightDay29.setBindPath("CALENDAR_RIGHT_DAY29");

      calendarRightDay29.setEditable(false);

      calendarRightDay29.setColumns(3);

      calendarRightDay29.setModelBindPath("CALENDAR_RIGHT29");

      calendarRightDay29.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay29.setBlankable(false);

      calendarRightDay29.setMaxColumns(3);

      calendarRightDay29.setModel(getCalendarRightDay29Model());

      addCalendarRightDay29();
    }
    return calendarRightDay29;

  }

  /**
   * 29日モデルを取得します。
   * @return 29日モデル
   */
  protected ACComboBoxModelAdapter getCalendarRightDay29Model(){
    if(calendarRightDay29Model==null){
      calendarRightDay29Model = new ACComboBoxModelAdapter();
      addCalendarRightDay29Model();
    }
    return calendarRightDay29Model;
  }

  /**
   * 30日パネルを取得します。
   * @return 30日パネル
   */
  public ACPanel getCalendarRightDay30Panel(){
    if(calendarRightDay30Panel==null){

      calendarRightDay30Panel = new ACPanel();

      addCalendarRightDay30Panel();
    }
    return calendarRightDay30Panel;

  }

  /**
   * 30ラベルを取得します。
   * @return 30ラベル
   */
  public ACLabel getCalendarRightDay30Label(){
    if(calendarRightDay30Label==null){

      calendarRightDay30Label = new ACLabel();

      calendarRightDay30Label.setVisible(false);

      addCalendarRightDay30Label();
    }
    return calendarRightDay30Label;

  }

  /**
   * 30日を取得します。
   * @return 30日
   */
  public ACComboBox getCalendarRightDay30(){
    if(calendarRightDay30==null){

      calendarRightDay30 = new ACComboBox();

      calendarRightDay30.setBindPath("CALENDAR_RIGHT_DAY30");

      calendarRightDay30.setEditable(false);

      calendarRightDay30.setColumns(3);

      calendarRightDay30.setModelBindPath("CALENDAR_RIGHT30");

      calendarRightDay30.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay30.setBlankable(false);

      calendarRightDay30.setMaxColumns(3);

      calendarRightDay30.setModel(getCalendarRightDay30Model());

      addCalendarRightDay30();
    }
    return calendarRightDay30;

  }

  /**
   * 30日モデルを取得します。
   * @return 30日モデル
   */
  protected ACComboBoxModelAdapter getCalendarRightDay30Model(){
    if(calendarRightDay30Model==null){
      calendarRightDay30Model = new ACComboBoxModelAdapter();
      addCalendarRightDay30Model();
    }
    return calendarRightDay30Model;
  }

  /**
   * 31日パネルを取得します。
   * @return 31日パネル
   */
  public ACPanel getCalendarRightDay31Panel(){
    if(calendarRightDay31Panel==null){

      calendarRightDay31Panel = new ACPanel();

      addCalendarRightDay31Panel();
    }
    return calendarRightDay31Panel;

  }

  /**
   * 31ラベルを取得します。
   * @return 31ラベル
   */
  public ACLabel getCalendarRightDay31Label(){
    if(calendarRightDay31Label==null){

      calendarRightDay31Label = new ACLabel();

      calendarRightDay31Label.setVisible(false);

      addCalendarRightDay31Label();
    }
    return calendarRightDay31Label;

  }

  /**
   * 31日を取得します。
   * @return 31日
   */
  public ACComboBox getCalendarRightDay31(){
    if(calendarRightDay31==null){

      calendarRightDay31 = new ACComboBox();

      calendarRightDay31.setBindPath("CALENDAR_RIGHT_DAY31");

      calendarRightDay31.setEditable(false);

      calendarRightDay31.setColumns(3);

      calendarRightDay31.setModelBindPath("CALENDAR_RIGHT31");

      calendarRightDay31.setRenderBindPath("CALENDAR_DATA_STRING");

      calendarRightDay31.setBlankable(false);

      calendarRightDay31.setMaxColumns(3);

      calendarRightDay31.setModel(getCalendarRightDay31Model());

      addCalendarRightDay31();
    }
    return calendarRightDay31;

  }

  /**
   * 31日モデルを取得します。
   * @return 31日モデル
   */
  protected ACComboBoxModelAdapter getCalendarRightDay31Model(){
    if(calendarRightDay31Model==null){
      calendarRightDay31Model = new ACComboBoxModelAdapter();
      addCalendarRightDay31Model();
    }
    return calendarRightDay31Model;
  }

  /**
   * ボタン領域を取得します。
   * @return ボタン領域
   */
  public ACPanel getResultButtonPanel(){
    if(resultButtonPanel==null){

      resultButtonPanel = new ACPanel();

      addResultButtonPanel();
    }
    return resultButtonPanel;

  }

  /**
   * パネルを取得します。
   * @return パネル
   */
  public ACPanel getResultButtonPanelLeft(){
    if(resultButtonPanelLeft==null){

      resultButtonPanelLeft = new ACPanel();

      addResultButtonPanelLeft();
    }
    return resultButtonPanelLeft;

  }

  /**
   * ボタンを取得します。
   * @return ボタン
   */
  public ACButton getResultReadButtonLeft(){
    if(resultReadButtonLeft==null){

      resultReadButtonLeft = new ACButton();

      resultReadButtonLeft.setText("実績読込");

      addResultReadButtonLeft();
    }
    return resultReadButtonLeft;

  }

  /**
   * パネルを取得します。
   * @return パネル
   */
  public ACPanel getResultButtonPanelRight(){
    if(resultButtonPanelRight==null){

      resultButtonPanelRight = new ACPanel();

      addResultButtonPanelRight();
    }
    return resultButtonPanelRight;

  }

  /**
   * ボタンを取得します。
   * @return ボタン
   */
  public ACButton getResultReadButtonRight(){
    if(resultReadButtonRight==null){

      resultReadButtonRight = new ACButton();

      resultReadButtonRight.setText("実績読込");

      addResultReadButtonRight();
    }
    return resultReadButtonRight;

  }

  /**
   * 説明文領域を取得します。
   * @return 説明文領域
   */
  public ACPanel getMemos(){
    if(memos==null){

      memos = new ACPanel();

      addMemos();
    }
    return memos;

  }

  /**
   * 説明文1を取得します。
   * @return 説明文1
   */
  public ACLabel getMemo1(){
    if(memo1==null){

      memo1 = new ACLabel();

      memo1.setText("訪問日を○で囲むこと。１日に２回訪問した日は◎で囲むこと。");

      addMemo1();
    }
    return memo1;

  }

  /**
   * 説明文6(追加）を取得します。
   * @return 説明文6(追加）
   */
  public ACLabel getMemo6(){
    if(memo6==null){

      memo6 = new ACLabel();

      memo6.setText("１日に３回以上訪問した日は◇で囲むこと。");

      addMemo6();
    }
    return memo6;

  }

  /**
   * 説明文2を取得します。
   * @return 説明文2
   */
  public ACLabel getMemo2(){
    if(memo2==null){

      memo2 = new ACLabel();

      memo2.setText("特別訪問看護指示書に基づく訪問看護を実施した日は△で囲むこと。");

      addMemo2();
    }
    return memo2;

  }

  /**
   * 説明文3を取得します。
   * @return 説明文3
   */
  public ACLabel getMemo3(){
    if(memo3==null){

      memo3 = new ACLabel();

      memo3.setText("緊急時訪問を行った日は×印とすること。");

      addMemo3();
    }
    return memo3;

  }

  /**
   * 説明文4を取得します。
   * @return 説明文4
   */
  public ACLabel getMemo4(){
    if(memo4==null){

      memo4 = new ACLabel();

      memo4.setText("なお、右表は訪問日が２月にわたる場合使用すること。");

      addMemo4();
    }
    return memo4;

  }

  /**
   * 説明文5を取得します。
   * @return 説明文5
   */
  public ACLabel getMemo5(){
    if(memo5==null){

      memo5 = new ACLabel();

      memo5.setText("　");

      addMemo5();
    }
    return memo5;

  }

  /**
   * Tab「経過・内容」を取得します。
   * @return Tab「経過・内容」
   */
  public ACPanel getTabsComments1(){
    if(tabsComments1==null){

      tabsComments1 = new ACPanel();

      addTabsComments1();
    }
    return tabsComments1;

  }

  /**
   * 病状の経過領域を取得します。
   * @return 病状の経過領域
   */
  public ACGroupBox getByojos(){
    if(byojos==null){

      byojos = new ACGroupBox();

      byojos.setText("病状の経過(42x7)");

      addByojos();
    }
    return byojos;

  }

  /**
   * 病状の経過小領域を取得します。
   * @return 病状の経過小領域
   */
  public ACPanel getByojoPnls(){
    if(byojoPnls==null){

      byojoPnls = new ACPanel();

      addByojoPnls();
    }
    return byojoPnls;

  }

  /**
   * 病状の経過を取得します。
   * @return 病状の経過
   */
  public ACTextArea getByojoComments(){
    if(byojoComments==null){

      byojoComments = new ACTextArea();

      byojoComments.setBindPath("BYOJO_STATE");

      byojoComments.setColumns(84);

      byojoComments.setRows(8);

      byojoComments.setMaxRows(7);

      byojoComments.setIMEMode(InputSubset.KANJI);

      byojoComments.setMaxLength(294);

      byojoComments.setLineWrap(true);

      addByojoComments();
    }
    return byojoComments;

  }

  /**
   * 病状の経過コンテナを取得します。
   * @return 病状の経過コンテナ
   */
  protected ACLabelContainer getByojoCommentsContainer(){
    if(byojoCommentsContainer==null){
      byojoCommentsContainer = new ACLabelContainer();
      byojoCommentsContainer.setFollowChildEnabled(true);
      byojoCommentsContainer.setVAlignment(VRLayout.CENTER);
      byojoCommentsContainer.add(getByojoComments(), VRLayout.CLIENT);
    }
    return byojoCommentsContainer;
  }

  /**
   * 看護・リハビリテーションの内容領域を取得します。
   * @return 看護・リハビリテーションの内容領域
   */
  public ACGroupBox getKangoRehas(){
    if(kangoRehas==null){

      kangoRehas = new ACGroupBox();

      kangoRehas.setText("看護・リハビリテーションの内容(42x9)");

      addKangoRehas();
    }
    return kangoRehas;

  }

  /**
   * 看護・リハビリテーションの内容小領域を取得します。
   * @return 看護・リハビリテーションの内容小領域
   */
  public ACPanel getKangoRehaPnls(){
    if(kangoRehaPnls==null){

      kangoRehaPnls = new ACPanel();

      addKangoRehaPnls();
    }
    return kangoRehaPnls;

  }

  /**
   * 看護・リハビリテーションの内容を取得します。
   * @return 看護・リハビリテーションの内容
   */
  public ACTextArea getKangoRehaComments(){
    if(kangoRehaComments==null){

      kangoRehaComments = new ACTextArea();

      kangoRehaComments.setBindPath("KANGO_REHA_NAIYO");

      kangoRehaComments.setColumns(84);

      kangoRehaComments.setRows(10);

      kangoRehaComments.setMaxRows(9);

      kangoRehaComments.setIMEMode(InputSubset.KANJI);

      kangoRehaComments.setMaxLength(378);

      kangoRehaComments.setLineWrap(true);

      addKangoRehaComments();
    }
    return kangoRehaComments;

  }

  /**
   * 看護・リハビリテーションの内容コンテナを取得します。
   * @return 看護・リハビリテーションの内容コンテナ
   */
  protected ACLabelContainer getKangoRehaCommentsContainer(){
    if(kangoRehaCommentsContainer==null){
      kangoRehaCommentsContainer = new ACLabelContainer();
      kangoRehaCommentsContainer.setFollowChildEnabled(true);
      kangoRehaCommentsContainer.setVAlignment(VRLayout.CENTER);
      kangoRehaCommentsContainer.add(getKangoRehaComments(), VRLayout.CLIENT);
    }
    return kangoRehaCommentsContainer;
  }

  /**
   * Tab「状況・特記事項」を取得します。
   * @return Tab「状況・特記事項」
   */
  public ACPanel getTabsComments2(){
    if(tabsComments2==null){

      tabsComments2 = new ACPanel();

      addTabsComments2();
    }
    return tabsComments2;

  }

  /**
   * 家庭での療養・介護の状況領域を取得します。
   * @return 家庭での療養・介護の状況領域
   */
  public ACGroupBox getRyoyoStates(){
    if(ryoyoStates==null){

      ryoyoStates = new ACGroupBox();

      ryoyoStates.setText("家庭での療養・介護の状況(42x8)");

      addRyoyoStates();
    }
    return ryoyoStates;

  }

  /**
   * 家庭での療養・介護の状況小領域を取得します。
   * @return 家庭での療養・介護の状況小領域
   */
  public ACPanel getRyoyoStatePnls(){
    if(ryoyoStatePnls==null){

      ryoyoStatePnls = new ACPanel();

      addRyoyoStatePnls();
    }
    return ryoyoStatePnls;

  }

  /**
   * 家庭での療養・介護の状況を取得します。
   * @return 家庭での療養・介護の状況
   */
  public ACTextArea getRyoyoStateComments(){
    if(ryoyoStateComments==null){

      ryoyoStateComments = new ACTextArea();

      ryoyoStateComments.setBindPath("RYOYO_KAIGO_STATE");

      ryoyoStateComments.setColumns(84);

      ryoyoStateComments.setRows(9);

      ryoyoStateComments.setMaxRows(8);

      ryoyoStateComments.setIMEMode(InputSubset.KANJI);

      ryoyoStateComments.setMaxLength(336);

      ryoyoStateComments.setLineWrap(true);

      addRyoyoStateComments();
    }
    return ryoyoStateComments;

  }

  /**
   * 家庭での療養・介護の状況コンテナを取得します。
   * @return 家庭での療養・介護の状況コンテナ
   */
  protected ACLabelContainer getRyoyoStateCommentsContainer(){
    if(ryoyoStateCommentsContainer==null){
      ryoyoStateCommentsContainer = new ACLabelContainer();
      ryoyoStateCommentsContainer.setFollowChildEnabled(true);
      ryoyoStateCommentsContainer.setVAlignment(VRLayout.CENTER);
      ryoyoStateCommentsContainer.add(getRyoyoStateComments(), VRLayout.CLIENT);
    }
    return ryoyoStateCommentsContainer;
  }

  /**
   * 特記すべき事項・介護の状況領域を取得します。
   * @return 特記すべき事項・介護の状況領域
   */
  public ACGroupBox getSpecials(){
    if(specials==null){

      specials = new ACGroupBox();

      specials.setText("特記すべき事項(48x5)");

      addSpecials();
    }
    return specials;

  }

  /**
   * 特記すべき事項・介護の状況小領域を取得します。
   * @return 特記すべき事項・介護の状況小領域
   */
  public ACPanel getSpecialPnls(){
    if(specialPnls==null){

      specialPnls = new ACPanel();

      addSpecialPnls();
    }
    return specialPnls;

  }

  /**
   * 特記すべき事項・介護の状況を取得します。
   * @return 特記すべき事項・介護の状況
   */
  public ACTextArea getSpecialComments(){
    if(specialComments==null){

      specialComments = new ACTextArea();

      specialComments.setBindPath("REPORT_COMMENT");

      specialComments.setColumns(96);

      specialComments.setRows(6);

      specialComments.setMaxRows(5);

      specialComments.setIMEMode(InputSubset.KANJI);

      specialComments.setMaxLength(240);

      specialComments.setLineWrap(true);

      addSpecialComments();
    }
    return specialComments;

  }

  /**
   * 特記すべき事項・介護の状況コンテナを取得します。
   * @return 特記すべき事項・介護の状況コンテナ
   */
  protected ACLabelContainer getSpecialCommentsContainer(){
    if(specialCommentsContainer==null){
      specialCommentsContainer = new ACLabelContainer();
      specialCommentsContainer.setFollowChildEnabled(true);
      specialCommentsContainer.setVAlignment(VRLayout.CENTER);
      specialCommentsContainer.add(getSpecialComments(), VRLayout.CLIENT);
    }
    return specialCommentsContainer;
  }

  /**
   * コンストラクタです。
   */
  public QC002Design() {

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

    contents.add(getTargetDates(), VRLayout.NORTH);

    contents.add(getInfos(), VRLayout.NORTH);

    contents.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * 対象年月領域に内部項目を追加します。
   */
  protected void addTargetDates(){

    targetDates.add(getTargetDateCaption(), VRLayout.FLOW);

    targetDates.add(getTargetDate(), VRLayout.FLOW);

  }

  /**
   * 対象年月キャプションに内部項目を追加します。
   */
  protected void addTargetDateCaption(){

  }

  /**
   * 対象年月に内部項目を追加します。
   */
  protected void addTargetDate(){

  }

  /**
   * 情報領域に内部項目を追加します。
   */
  protected void addInfos(){

    infos.add(getPatients(), VRLayout.NORTH);

    infos.add(getStations(), VRLayout.NORTH);

  }

  /**
   * 利用者情報領域に内部項目を追加します。
   */
  protected void addPatients(){

    patients.add(getPatientNameContainer(), VRLayout.FLOW_INSETLINE);

    patients.add(getPatientBirthContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    patients.add(getYokaigodoContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    patients.add(getPatientAddressContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    patients.add(getDoctorNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 氏名に内部項目を追加します。
   */
  protected void addPatientName(){

  }

  /**
   * 生年月日コンテナに内部項目を追加します。
   */
  protected void addPatientBirthContainer(){

    patientBirthContainer.add(getPatientBirth(), null);

    patientBirthContainer.add(getPatientAge(), null);

    patientBirthContainer.add(getPatientAgeLabel(), null);

  }

  /**
   * 生年月日に内部項目を追加します。
   */
  protected void addPatientBirth(){

  }

  /**
   * 年齢に内部項目を追加します。
   */
  protected void addPatientAge(){

  }

  /**
   * 歳に内部項目を追加します。
   */
  protected void addPatientAgeLabel(){

  }

  /**
   * 要介護認定に内部項目を追加します。
   */
  protected void addYokaigodo(){

  }

  /**
   * 要介護認定モデルに内部項目を追加します。
   */
  protected void addYokaigodoModel(){

    getYokaigodoRadio1().setButtonIndex(1);

    getYokaigodoModel().add(getYokaigodoRadio1());

    getYokaigodoRadio2().setButtonIndex(12);

    getYokaigodoModel().add(getYokaigodoRadio2());

    getYokaigodoRadio3().setButtonIndex(13);

    getYokaigodoModel().add(getYokaigodoRadio3());

    getYokaigodoRadio4().setButtonIndex(11);

    getYokaigodoModel().add(getYokaigodoRadio4());

    getYokaigodoRadio5().setButtonIndex(21);

    getYokaigodoModel().add(getYokaigodoRadio5());

    getYokaigodoRadio6().setButtonIndex(22);

    getYokaigodoModel().add(getYokaigodoRadio6());

    getYokaigodoRadio7().setButtonIndex(23);

    getYokaigodoModel().add(getYokaigodoRadio7());

    getYokaigodoRadio8().setButtonIndex(24);

    getYokaigodoModel().add(getYokaigodoRadio8());

    getYokaigodoRadio9().setButtonIndex(25);

    getYokaigodoModel().add(getYokaigodoRadio9());

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
   * 住所に内部項目を追加します。
   */
  protected void addPatientAddress(){

  }

  /**
   * 主治医氏名に内部項目を追加します。
   */
  protected void addDoctorName(){

  }

  /**
   * ステーション情報領域に内部項目を追加します。
   */
  protected void addStations(){

    stations.add(getCreateDateContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    stations.add(getProviderNameContainer(), VRLayout.FLOW_INSETLINE);

    stations.add(getAdministratorNameContainer(), VRLayout.FLOW_RETURN);

  }

  /**
   * 作成年月日に内部項目を追加します。
   */
  protected void addCreateDate(){

  }

  /**
   * ステーション名に内部項目を追加します。
   */
  protected void addProviderName(){

  }

  /**
   * ステーション名モデルに内部項目を追加します。
   */
  protected void addProviderNameModel(){

  }

  /**
   * 管理者氏名に内部項目を追加します。
   */
  protected void addAdministratorName(){

  }

  /**
   * Tabに内部項目を追加します。
   */
  protected void addTabs(){

    tabs.addTab("訪問日", getTabVisitDate());

    tabs.addTab("経過・内容", getTabsComments1());

    tabs.addTab("状況・特記事項", getTabsComments2());

  }

  /**
   * Tab「訪問日」に内部項目を追加します。
   */
  protected void addTabVisitDate(){

    tabVisitDate.add(getVisitDates(), VRLayout.NORTH);

  }

  /**
   * 訪問日領域に内部項目を追加します。
   */
  protected void addVisitDates(){

    visitDates.add(getCalendars(), VRLayout.NORTH);

    visitDates.add(getResultButtonPanel(), VRLayout.NORTH);

    visitDates.add(getMemos(), VRLayout.NORTH);

  }

  /**
   * カレンダー領域に内部項目を追加します。
   */
  protected void addCalendars(){

    calendars.add(getCalendarLefts(), VRLayout.CLIENT);

    calendars.add(getCalendarRights(), VRLayout.CLIENT);

  }

  /**
   * カレンダー(左領域)に内部項目を追加します。
   */
  protected void addCalendarLefts(){

    calendarLefts.add(getCalendarLeftYearMonths(), VRLayout.NORTH);

    calendarLefts.add(getCalendarLeftDayContainer(), VRLayout.CLIENT);

  }

  /**
   * カレンダー(左)年月領域に内部項目を追加します。
   */
  protected void addCalendarLeftYearMonths(){

    calendarLeftYearMonths.add(getCalendarLeftCaption(), VRLayout.FLOW);

    calendarLeftYearMonths.add(getCalendarLeftYear(), VRLayout.FLOW);

    calendarLeftYearMonths.add(getCalendarLeftYearCaption(), VRLayout.FLOW);

    calendarLeftYearMonths.add(getCalendarLeftMonth(), VRLayout.FLOW);

    calendarLeftYearMonths.add(getCalendarLeftMonthCaption(), VRLayout.FLOW);

  }

  /**
   * カレンダー(左)年月領域レイアウトに内部項目を追加します。
   */
  protected void addCalendarLeftYearMonthsLayout(){

  }

  /**
   * 平成に内部項目を追加します。
   */
  protected void addCalendarLeftCaption(){

  }

  /**
   * 年に内部項目を追加します。
   */
  protected void addCalendarLeftYear(){

  }

  /**
   * 年キャプションに内部項目を追加します。
   */
  protected void addCalendarLeftYearCaption(){

  }

  /**
   * 月に内部項目を追加します。
   */
  protected void addCalendarLeftMonth(){

  }

  /**
   * 月キャプションに内部項目を追加します。
   */
  protected void addCalendarLeftMonthCaption(){

  }

  /**
   * カレンダー(左日付領域)に内部項目を追加します。
   */
  protected void addCalendarLeftDayContainer(){

    calendarLeftDayContainer.add(getCalendarLeftDay01(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay02(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay03(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay04(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay05(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay06(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay07(), VRLayout.FLOW_RETURN);

    calendarLeftDayContainer.add(getCalendarLeftDay08(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay09(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay10(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay11(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay12(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay13(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay14(), VRLayout.FLOW_RETURN);

    calendarLeftDayContainer.add(getCalendarLeftDay15(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay16(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay17(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay18(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay19(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay20(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay21(), VRLayout.FLOW_RETURN);

    calendarLeftDayContainer.add(getCalendarLeftDay22(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay23(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay24(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay25(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay26(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay27(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay28(), VRLayout.FLOW_RETURN);

    calendarLeftDayContainer.add(getCalendarLeftDay29Panel(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay30Panel(), VRLayout.FLOW);

    calendarLeftDayContainer.add(getCalendarLeftDay31Panel(), VRLayout.FLOW);

  }

  /**
   * 1日に内部項目を追加します。
   */
  protected void addCalendarLeftDay01(){

  }

  /**
   * 1日モデルに内部項目を追加します。
   */
  protected void addCalendarLeftDay01Model(){

  }

  /**
   * 2日に内部項目を追加します。
   */
  protected void addCalendarLeftDay02(){

  }

  /**
   * 2日モデルに内部項目を追加します。
   */
  protected void addCalendarLeftDay02Model(){

  }

  /**
   * 3日に内部項目を追加します。
   */
  protected void addCalendarLeftDay03(){

  }

  /**
   * 3日モデルに内部項目を追加します。
   */
  protected void addCalendarLeftDay03Model(){

  }

  /**
   * 4日に内部項目を追加します。
   */
  protected void addCalendarLeftDay04(){

  }

  /**
   * 4日モデルに内部項目を追加します。
   */
  protected void addCalendarLeftDay04Model(){

  }

  /**
   * 5日に内部項目を追加します。
   */
  protected void addCalendarLeftDay05(){

  }

  /**
   * 5日モデルに内部項目を追加します。
   */
  protected void addCalendarLeftDay05Model(){

  }

  /**
   * 6日に内部項目を追加します。
   */
  protected void addCalendarLeftDay06(){

  }

  /**
   * 6日モデルに内部項目を追加します。
   */
  protected void addCalendarLeftDay06Model(){

  }

  /**
   * 7日に内部項目を追加します。
   */
  protected void addCalendarLeftDay07(){

  }

  /**
   * 7日モデルに内部項目を追加します。
   */
  protected void addCalendarLeftDay07Model(){

  }

  /**
   * 8日に内部項目を追加します。
   */
  protected void addCalendarLeftDay08(){

  }

  /**
   * 8日モデルに内部項目を追加します。
   */
  protected void addCalendarLeftDay08Model(){

  }

  /**
   * 9日に内部項目を追加します。
   */
  protected void addCalendarLeftDay09(){

  }

  /**
   * 9日モデルに内部項目を追加します。
   */
  protected void addCalendarLeftDay09Model(){

  }

  /**
   * 10日に内部項目を追加します。
   */
  protected void addCalendarLeftDay10(){

  }

  /**
   * 10日モデルに内部項目を追加します。
   */
  protected void addCalendarLeftDay10Model(){

  }

  /**
   * 11日に内部項目を追加します。
   */
  protected void addCalendarLeftDay11(){

  }

  /**
   * 11日モデルに内部項目を追加します。
   */
  protected void addCalendarLeftDay11Model(){

  }

  /**
   * 12日に内部項目を追加します。
   */
  protected void addCalendarLeftDay12(){

  }

  /**
   * 12日モデルに内部項目を追加します。
   */
  protected void addCalendarLeftDay12Model(){

  }

  /**
   * 13日に内部項目を追加します。
   */
  protected void addCalendarLeftDay13(){

  }

  /**
   * 13日モデルに内部項目を追加します。
   */
  protected void addCalendarLeftDay13Model(){

  }

  /**
   * 14日に内部項目を追加します。
   */
  protected void addCalendarLeftDay14(){

  }

  /**
   * 14日モデルに内部項目を追加します。
   */
  protected void addCalendarLeftDay14Model(){

  }

  /**
   * 15日に内部項目を追加します。
   */
  protected void addCalendarLeftDay15(){

  }

  /**
   * 15日モデルに内部項目を追加します。
   */
  protected void addCalendarLeftDay15Model(){

  }

  /**
   * 16日に内部項目を追加します。
   */
  protected void addCalendarLeftDay16(){

  }

  /**
   * 16日モデルに内部項目を追加します。
   */
  protected void addCalendarLeftDay16Model(){

  }

  /**
   * 17日に内部項目を追加します。
   */
  protected void addCalendarLeftDay17(){

  }

  /**
   * 17日モデルに内部項目を追加します。
   */
  protected void addCalendarLeftDay17Model(){

  }

  /**
   * 18日に内部項目を追加します。
   */
  protected void addCalendarLeftDay18(){

  }

  /**
   * 18日モデルに内部項目を追加します。
   */
  protected void addCalendarLeftDay18Model(){

  }

  /**
   * 19日に内部項目を追加します。
   */
  protected void addCalendarLeftDay19(){

  }

  /**
   * 19日モデルに内部項目を追加します。
   */
  protected void addCalendarLeftDay19Model(){

  }

  /**
   * 20日に内部項目を追加します。
   */
  protected void addCalendarLeftDay20(){

  }

  /**
   * 20日モデルに内部項目を追加します。
   */
  protected void addCalendarLeftDay20Model(){

  }

  /**
   * 21日に内部項目を追加します。
   */
  protected void addCalendarLeftDay21(){

  }

  /**
   * 21日モデルに内部項目を追加します。
   */
  protected void addCalendarLeftDay21Model(){

  }

  /**
   * 22日に内部項目を追加します。
   */
  protected void addCalendarLeftDay22(){

  }

  /**
   * 22日モデルに内部項目を追加します。
   */
  protected void addCalendarLeftDay22Model(){

  }

  /**
   * 23日に内部項目を追加します。
   */
  protected void addCalendarLeftDay23(){

  }

  /**
   * 23日モデルに内部項目を追加します。
   */
  protected void addCalendarLeftDay23Model(){

  }

  /**
   * 24日に内部項目を追加します。
   */
  protected void addCalendarLeftDay24(){

  }

  /**
   * 24日モデルに内部項目を追加します。
   */
  protected void addCalendarLeftDay24Model(){

  }

  /**
   * 25日に内部項目を追加します。
   */
  protected void addCalendarLeftDay25(){

  }

  /**
   * 25日モデルに内部項目を追加します。
   */
  protected void addCalendarLeftDay25Model(){

  }

  /**
   * 26日に内部項目を追加します。
   */
  protected void addCalendarLeftDay26(){

  }

  /**
   * 26日モデルに内部項目を追加します。
   */
  protected void addCalendarLeftDay26Model(){

  }

  /**
   * 27日に内部項目を追加します。
   */
  protected void addCalendarLeftDay27(){

  }

  /**
   * 27日モデルに内部項目を追加します。
   */
  protected void addCalendarLeftDay27Model(){

  }

  /**
   * 28日に内部項目を追加します。
   */
  protected void addCalendarLeftDay28(){

  }

  /**
   * 28日モデルに内部項目を追加します。
   */
  protected void addCalendarLeftDay28Model(){

  }

  /**
   * 29日パネルに内部項目を追加します。
   */
  protected void addCalendarLeftDay29Panel(){

    calendarLeftDay29Panel.add(getCalendarLeftDay29Label(), VRLayout.CLIENT);

    calendarLeftDay29Panel.add(getCalendarLeftDay29(), VRLayout.CLIENT);

  }

  /**
   * 29ラベルに内部項目を追加します。
   */
  protected void addCalendarLeftDay29Label(){

  }

  /**
   * 29日に内部項目を追加します。
   */
  protected void addCalendarLeftDay29(){

  }

  /**
   * 29日モデルに内部項目を追加します。
   */
  protected void addCalendarLeftDay29Model(){

  }

  /**
   * 30日パネルに内部項目を追加します。
   */
  protected void addCalendarLeftDay30Panel(){

    calendarLeftDay30Panel.add(getCalendarLeftDay30Label(), VRLayout.CLIENT);

    calendarLeftDay30Panel.add(getCalendarLeftDay30(), VRLayout.CLIENT);

  }

  /**
   * 30ラベルに内部項目を追加します。
   */
  protected void addCalendarLeftDay30Label(){

  }

  /**
   * 30日に内部項目を追加します。
   */
  protected void addCalendarLeftDay30(){

  }

  /**
   * 30日モデルに内部項目を追加します。
   */
  protected void addCalendarLeftDay30Model(){

  }

  /**
   * 31日パネルに内部項目を追加します。
   */
  protected void addCalendarLeftDay31Panel(){

    calendarLeftDay31Panel.add(getCalendarLeftDay31Label(), VRLayout.CLIENT);

    calendarLeftDay31Panel.add(getCalendarLeftDay31(), VRLayout.CLIENT);

  }

  /**
   * 31ラベルに内部項目を追加します。
   */
  protected void addCalendarLeftDay31Label(){

  }

  /**
   * 31日に内部項目を追加します。
   */
  protected void addCalendarLeftDay31(){

  }

  /**
   * 31日モデルに内部項目を追加します。
   */
  protected void addCalendarLeftDay31Model(){

  }

  /**
   * カレンダー(右領域)に内部項目を追加します。
   */
  protected void addCalendarRights(){

    calendarRights.add(getCalendarRightYearMonths(), VRLayout.NORTH);

    calendarRights.add(getCalendarRightDayContainer(), VRLayout.CLIENT);

  }

  /**
   * カレンダー(右)年月領域に内部項目を追加します。
   */
  protected void addCalendarRightYearMonths(){

    calendarRightYearMonths.add(getCalendarRightCaption(), VRLayout.FLOW);

    calendarRightYearMonths.add(getCalendarRightYear(), VRLayout.FLOW);

    calendarRightYearMonths.add(getCalendarRightYearCaption(), VRLayout.FLOW);

    calendarRightYearMonths.add(getCalendarRightMonth(), VRLayout.FLOW);

    calendarRightYearMonths.add(getCalendarRightMonthCaption(), VRLayout.FLOW);

  }

  /**
   * カレンダー(右)年月領域レイアウトに内部項目を追加します。
   */
  protected void addCalendarRightYearMonthsLayout(){

  }

  /**
   * 平成キャプションに内部項目を追加します。
   */
  protected void addCalendarRightCaption(){

  }

  /**
   * 年に内部項目を追加します。
   */
  protected void addCalendarRightYear(){

  }

  /**
   * 年キャプションに内部項目を追加します。
   */
  protected void addCalendarRightYearCaption(){

  }

  /**
   * 月に内部項目を追加します。
   */
  protected void addCalendarRightMonth(){

  }

  /**
   * 月キャプションに内部項目を追加します。
   */
  protected void addCalendarRightMonthCaption(){

  }

  /**
   * カレンダー(右日付領域)に内部項目を追加します。
   */
  protected void addCalendarRightDayContainer(){

    calendarRightDayContainer.add(getCalendarRightDay01(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay02(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay03(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay04(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay05(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay06(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay07(), VRLayout.FLOW_RETURN);

    calendarRightDayContainer.add(getCalendarRightDay08(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay09(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay10(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay11(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay12(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay13(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay14(), VRLayout.FLOW_RETURN);

    calendarRightDayContainer.add(getCalendarRightDay15(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay16(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay17(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay18(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay19(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay20(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay21(), VRLayout.FLOW_RETURN);

    calendarRightDayContainer.add(getCalendarRightDay22(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay23(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay24(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay25(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay26(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay27(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay28(), VRLayout.FLOW_RETURN);

    calendarRightDayContainer.add(getCalendarRightDay29Panel(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay30Panel(), VRLayout.FLOW);

    calendarRightDayContainer.add(getCalendarRightDay31Panel(), VRLayout.FLOW);

  }

  /**
   * 1日に内部項目を追加します。
   */
  protected void addCalendarRightDay01(){

  }

  /**
   * 1日モデルに内部項目を追加します。
   */
  protected void addCalendarRightDay01Model(){

  }

  /**
   * 2日に内部項目を追加します。
   */
  protected void addCalendarRightDay02(){

  }

  /**
   * 2日モデルに内部項目を追加します。
   */
  protected void addCalendarRightDay02Model(){

  }

  /**
   * 3日に内部項目を追加します。
   */
  protected void addCalendarRightDay03(){

  }

  /**
   * 3日モデルに内部項目を追加します。
   */
  protected void addCalendarRightDay03Model(){

  }

  /**
   * 4日に内部項目を追加します。
   */
  protected void addCalendarRightDay04(){

  }

  /**
   * 4日モデルに内部項目を追加します。
   */
  protected void addCalendarRightDay04Model(){

  }

  /**
   * 5日に内部項目を追加します。
   */
  protected void addCalendarRightDay05(){

  }

  /**
   * 5日モデルに内部項目を追加します。
   */
  protected void addCalendarRightDay05Model(){

  }

  /**
   * 6日に内部項目を追加します。
   */
  protected void addCalendarRightDay06(){

  }

  /**
   * 6日モデルに内部項目を追加します。
   */
  protected void addCalendarRightDay06Model(){

  }

  /**
   * 7日に内部項目を追加します。
   */
  protected void addCalendarRightDay07(){

  }

  /**
   * 7日モデルに内部項目を追加します。
   */
  protected void addCalendarRightDay07Model(){

  }

  /**
   * 8日に内部項目を追加します。
   */
  protected void addCalendarRightDay08(){

  }

  /**
   * 8日モデルに内部項目を追加します。
   */
  protected void addCalendarRightDay08Model(){

  }

  /**
   * 9日に内部項目を追加します。
   */
  protected void addCalendarRightDay09(){

  }

  /**
   * 9日モデルに内部項目を追加します。
   */
  protected void addCalendarRightDay09Model(){

  }

  /**
   * 10日に内部項目を追加します。
   */
  protected void addCalendarRightDay10(){

  }

  /**
   * 10日モデルに内部項目を追加します。
   */
  protected void addCalendarRightDay10Model(){

  }

  /**
   * 11日に内部項目を追加します。
   */
  protected void addCalendarRightDay11(){

  }

  /**
   * 11日モデルに内部項目を追加します。
   */
  protected void addCalendarRightDay11Model(){

  }

  /**
   * 12日に内部項目を追加します。
   */
  protected void addCalendarRightDay12(){

  }

  /**
   * 12日モデルに内部項目を追加します。
   */
  protected void addCalendarRightDay12Model(){

  }

  /**
   * 13日に内部項目を追加します。
   */
  protected void addCalendarRightDay13(){

  }

  /**
   * 13日モデルに内部項目を追加します。
   */
  protected void addCalendarRightDay13Model(){

  }

  /**
   * 14日に内部項目を追加します。
   */
  protected void addCalendarRightDay14(){

  }

  /**
   * 14日モデルに内部項目を追加します。
   */
  protected void addCalendarRightDay14Model(){

  }

  /**
   * 15日に内部項目を追加します。
   */
  protected void addCalendarRightDay15(){

  }

  /**
   * 15日モデルに内部項目を追加します。
   */
  protected void addCalendarRightDay15Model(){

  }

  /**
   * 16日に内部項目を追加します。
   */
  protected void addCalendarRightDay16(){

  }

  /**
   * 16日モデルに内部項目を追加します。
   */
  protected void addCalendarRightDay16Model(){

  }

  /**
   * 17日に内部項目を追加します。
   */
  protected void addCalendarRightDay17(){

  }

  /**
   * 17日モデルに内部項目を追加します。
   */
  protected void addCalendarRightDay17Model(){

  }

  /**
   * 18日に内部項目を追加します。
   */
  protected void addCalendarRightDay18(){

  }

  /**
   * 18日モデルに内部項目を追加します。
   */
  protected void addCalendarRightDay18Model(){

  }

  /**
   * 19日に内部項目を追加します。
   */
  protected void addCalendarRightDay19(){

  }

  /**
   * 19日モデルに内部項目を追加します。
   */
  protected void addCalendarRightDay19Model(){

  }

  /**
   * 20日に内部項目を追加します。
   */
  protected void addCalendarRightDay20(){

  }

  /**
   * 20日モデルに内部項目を追加します。
   */
  protected void addCalendarRightDay20Model(){

  }

  /**
   * 21日に内部項目を追加します。
   */
  protected void addCalendarRightDay21(){

  }

  /**
   * 21日モデルに内部項目を追加します。
   */
  protected void addCalendarRightDay21Model(){

  }

  /**
   * 22日に内部項目を追加します。
   */
  protected void addCalendarRightDay22(){

  }

  /**
   * 22日モデルに内部項目を追加します。
   */
  protected void addCalendarRightDay22Model(){

  }

  /**
   * 23日に内部項目を追加します。
   */
  protected void addCalendarRightDay23(){

  }

  /**
   * 23日モデルに内部項目を追加します。
   */
  protected void addCalendarRightDay23Model(){

  }

  /**
   * 24日に内部項目を追加します。
   */
  protected void addCalendarRightDay24(){

  }

  /**
   * 24日モデルに内部項目を追加します。
   */
  protected void addCalendarRightDay24Model(){

  }

  /**
   * 25日に内部項目を追加します。
   */
  protected void addCalendarRightDay25(){

  }

  /**
   * 25日モデルに内部項目を追加します。
   */
  protected void addCalendarRightDay25Model(){

  }

  /**
   * 26日に内部項目を追加します。
   */
  protected void addCalendarRightDay26(){

  }

  /**
   * 26日モデルに内部項目を追加します。
   */
  protected void addCalendarRightDay26Model(){

  }

  /**
   * 27日に内部項目を追加します。
   */
  protected void addCalendarRightDay27(){

  }

  /**
   * 27日モデルに内部項目を追加します。
   */
  protected void addCalendarRightDay27Model(){

  }

  /**
   * 28日に内部項目を追加します。
   */
  protected void addCalendarRightDay28(){

  }

  /**
   * 28日モデルに内部項目を追加します。
   */
  protected void addCalendarRightDay28Model(){

  }

  /**
   * 29日パネルに内部項目を追加します。
   */
  protected void addCalendarRightDay29Panel(){

    calendarRightDay29Panel.add(getCalendarRightDay29Label(), VRLayout.CLIENT);

    calendarRightDay29Panel.add(getCalendarRightDay29(), VRLayout.CLIENT);

  }

  /**
   * 29ラベルに内部項目を追加します。
   */
  protected void addCalendarRightDay29Label(){

  }

  /**
   * 29日に内部項目を追加します。
   */
  protected void addCalendarRightDay29(){

  }

  /**
   * 29日モデルに内部項目を追加します。
   */
  protected void addCalendarRightDay29Model(){

  }

  /**
   * 30日パネルに内部項目を追加します。
   */
  protected void addCalendarRightDay30Panel(){

    calendarRightDay30Panel.add(getCalendarRightDay30Label(), VRLayout.CLIENT);

    calendarRightDay30Panel.add(getCalendarRightDay30(), VRLayout.CLIENT);

  }

  /**
   * 30ラベルに内部項目を追加します。
   */
  protected void addCalendarRightDay30Label(){

  }

  /**
   * 30日に内部項目を追加します。
   */
  protected void addCalendarRightDay30(){

  }

  /**
   * 30日モデルに内部項目を追加します。
   */
  protected void addCalendarRightDay30Model(){

  }

  /**
   * 31日パネルに内部項目を追加します。
   */
  protected void addCalendarRightDay31Panel(){

    calendarRightDay31Panel.add(getCalendarRightDay31Label(), VRLayout.CLIENT);

    calendarRightDay31Panel.add(getCalendarRightDay31(), VRLayout.CLIENT);

  }

  /**
   * 31ラベルに内部項目を追加します。
   */
  protected void addCalendarRightDay31Label(){

  }

  /**
   * 31日に内部項目を追加します。
   */
  protected void addCalendarRightDay31(){

  }

  /**
   * 31日モデルに内部項目を追加します。
   */
  protected void addCalendarRightDay31Model(){

  }

  /**
   * ボタン領域に内部項目を追加します。
   */
  protected void addResultButtonPanel(){

    resultButtonPanel.add(getResultButtonPanelLeft(), VRLayout.CLIENT);

    resultButtonPanel.add(getResultButtonPanelRight(), VRLayout.CLIENT);

  }

  /**
   * パネルに内部項目を追加します。
   */
  protected void addResultButtonPanelLeft(){

    resultButtonPanelLeft.add(getResultReadButtonLeft(), VRLayout.FLOW);

  }

  /**
   * ボタンに内部項目を追加します。
   */
  protected void addResultReadButtonLeft(){

  }

  /**
   * パネルに内部項目を追加します。
   */
  protected void addResultButtonPanelRight(){

    resultButtonPanelRight.add(getResultReadButtonRight(), VRLayout.FLOW);

  }

  /**
   * ボタンに内部項目を追加します。
   */
  protected void addResultReadButtonRight(){

  }

  /**
   * 説明文領域に内部項目を追加します。
   */
  protected void addMemos(){

    memos.add(getMemo1(), VRLayout.NORTH);

    memos.add(getMemo6(), VRLayout.NORTH);

    memos.add(getMemo2(), VRLayout.NORTH);

    memos.add(getMemo3(), VRLayout.NORTH);

    memos.add(getMemo4(), VRLayout.NORTH);

    memos.add(getMemo5(), VRLayout.NORTH);

  }

  /**
   * 説明文1に内部項目を追加します。
   */
  protected void addMemo1(){

  }

  /**
   * 説明文6(追加）に内部項目を追加します。
   */
  protected void addMemo6(){

  }

  /**
   * 説明文2に内部項目を追加します。
   */
  protected void addMemo2(){

  }

  /**
   * 説明文3に内部項目を追加します。
   */
  protected void addMemo3(){

  }

  /**
   * 説明文4に内部項目を追加します。
   */
  protected void addMemo4(){

  }

  /**
   * 説明文5に内部項目を追加します。
   */
  protected void addMemo5(){

  }

  /**
   * Tab「経過・内容」に内部項目を追加します。
   */
  protected void addTabsComments1(){

    tabsComments1.add(getByojos(), VRLayout.NORTH);

    tabsComments1.add(getKangoRehas(), VRLayout.NORTH);

  }

  /**
   * 病状の経過領域に内部項目を追加します。
   */
  protected void addByojos(){

    byojos.add(getByojoPnls(), VRLayout.FLOW);

  }

  /**
   * 病状の経過小領域に内部項目を追加します。
   */
  protected void addByojoPnls(){

    byojoPnls.add(getByojoCommentsContainer(), VRLayout.CLIENT);

  }

  /**
   * 病状の経過に内部項目を追加します。
   */
  protected void addByojoComments(){

  }

  /**
   * 看護・リハビリテーションの内容領域に内部項目を追加します。
   */
  protected void addKangoRehas(){

    kangoRehas.add(getKangoRehaPnls(), VRLayout.FLOW);

  }

  /**
   * 看護・リハビリテーションの内容小領域に内部項目を追加します。
   */
  protected void addKangoRehaPnls(){

    kangoRehaPnls.add(getKangoRehaCommentsContainer(), VRLayout.CLIENT);

  }

  /**
   * 看護・リハビリテーションの内容に内部項目を追加します。
   */
  protected void addKangoRehaComments(){

  }

  /**
   * Tab「状況・特記事項」に内部項目を追加します。
   */
  protected void addTabsComments2(){

    tabsComments2.add(getRyoyoStates(), VRLayout.NORTH);

    tabsComments2.add(getSpecials(), VRLayout.NORTH);

  }

  /**
   * 家庭での療養・介護の状況領域に内部項目を追加します。
   */
  protected void addRyoyoStates(){

    ryoyoStates.add(getRyoyoStatePnls(), VRLayout.FLOW);

  }

  /**
   * 家庭での療養・介護の状況小領域に内部項目を追加します。
   */
  protected void addRyoyoStatePnls(){

    ryoyoStatePnls.add(getRyoyoStateCommentsContainer(), VRLayout.CLIENT);

  }

  /**
   * 家庭での療養・介護の状況に内部項目を追加します。
   */
  protected void addRyoyoStateComments(){

  }

  /**
   * 特記すべき事項・介護の状況領域に内部項目を追加します。
   */
  protected void addSpecials(){

    specials.add(getSpecialPnls(), VRLayout.FLOW);

  }

  /**
   * 特記すべき事項・介護の状況小領域に内部項目を追加します。
   */
  protected void addSpecialPnls(){

    specialPnls.add(getSpecialCommentsContainer(), VRLayout.CLIENT);

  }

  /**
   * 特記すべき事項・介護の状況に内部項目を追加します。
   */
  protected void addSpecialComments(){

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
      ACFrame.debugStart(new ACAffairInfo(QC002Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QC002Design getThis() {
    return this;
  }
}
