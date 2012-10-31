
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
 * 作成日: 2012/09/21  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 帳票管理 (C)
 * プロセス 訪問看護計画書 (001)
 * プログラム 訪問看護計画書 (QC001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qc.qc001;
import java.awt.Color;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;

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
import jp.nichicom.ac.component.table.ACTable;
import jp.nichicom.ac.component.table.ACTableCellViewer;
import jp.nichicom.ac.component.table.ACTableColumn;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACAffairable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.component.table.VRTableColumnModel;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanAffairContainer;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.component.QkanDateTextField;
/**
 * 訪問看護計画書画面項目デザイン(QC001) 
 */
public class QC001Design extends QkanAffairContainer implements ACAffairable {
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

  private ACRadioButtonItem yokaigodoRadioItem1;

  private ACRadioButtonItem yokaigodoRadioItem2;

  private ACRadioButtonItem yokaigodoRadioItem3;

  private ACRadioButtonItem yokaigodoRadioItem4;

  private ACRadioButtonItem yokaigodoRadioItem5;

  private ACRadioButtonItem yokaigodoRadioItem6;

  private ACRadioButtonItem yokaigodoRadioItem7;

  private ACRadioButtonItem yokaigodoRadioItem8;

  private ACRadioButtonItem yokaigodoRadioItem9;

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

  private ACPanel tabPurposes;

  private ACGroupBox planPurposes;

  private ACTextArea planPurpose;

  private ACLabelContainer planPurposeContainer;

  private ACGroupBox planComments;

  private ACTextArea planComment;

  private ACLabelContainer planCommentContainer;

  private ACPanel tabsNotes;

  private ACPanel planNoteAreas;

  private ACTable planNotes;

  private VRTableColumnModel planNotesColumnModel;

  private ACTableColumn planNotesColumn0;

  private ACTableColumn planNotesColumn1;

  private ACTableColumn planNotesColumn2;

  private ACTableColumn planNotesColumn3;

  private ACGroupBox planNoteEdits;

  private ACPanel planPanel;

  private ACPanel planNoteEditDates;

  private QkanDateTextField planNoteEditDate;

  private ACLabelContainer planNoteEditDateContainer;

  private ACGroupBox planNoteEditComments;

  private ACTextArea planNoteEditComment;

  private ACLabelContainer planNoteEditCommentContainer;

  private ACGroupBox planAssessmentEditComments;

  private ACTextArea planAssessmentEditComment;

  private ACLabelContainer planAssessmentEditCommentContainer;

  private ACPanel planNoteEditButtons;

  private ACButton planNoteEditButtonAdd;

  private ACButton planNoteEditButtonEdit;

  private ACButton planNoteEditButtonDelete;

  private ACButton planNoteEditButtonClear;

  //getter

  /**
   * ボタンバーを取得します。
   * @return ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("訪問看護計画書");

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

      print.setToolTipText("「訪問看護計画書」を印刷します。");

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

      targetDateCaption.setHorizontalAlignment(SwingConstants.RIGHT);

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

      targetDate.setHorizontalAlignment(SwingConstants.LEFT);

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

      patientAge.setBindPath("PATIENT_AGE");

      patientAge.setEditable(false);

      patientAge.setMaxLength(5);

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

      yokaigodo.setNoSelectIndex(0);

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
  public ACRadioButtonItem getYokaigodoRadioItem1(){
    if(yokaigodoRadioItem1==null){

      yokaigodoRadioItem1 = new ACRadioButtonItem();

      yokaigodoRadioItem1.setText("自立");

      yokaigodoRadioItem1.setGroup(getYokaigodo());

      yokaigodoRadioItem1.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem1();
    }
    return yokaigodoRadioItem1;

  }

  /**
   * 要支援１を取得します。
   * @return 要支援１
   */
  public ACRadioButtonItem getYokaigodoRadioItem2(){
    if(yokaigodoRadioItem2==null){

      yokaigodoRadioItem2 = new ACRadioButtonItem();

      yokaigodoRadioItem2.setText("要支援1");

      yokaigodoRadioItem2.setGroup(getYokaigodo());

      yokaigodoRadioItem2.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem2();
    }
    return yokaigodoRadioItem2;

  }

  /**
   * 要支援２を取得します。
   * @return 要支援２
   */
  public ACRadioButtonItem getYokaigodoRadioItem3(){
    if(yokaigodoRadioItem3==null){

      yokaigodoRadioItem3 = new ACRadioButtonItem();

      yokaigodoRadioItem3.setText("要支援2");

      yokaigodoRadioItem3.setGroup(getYokaigodo());

      yokaigodoRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addYokaigodoRadioItem3();
    }
    return yokaigodoRadioItem3;

  }

  /**
   * 経過的要介護を取得します。
   * @return 経過的要介護
   */
  public ACRadioButtonItem getYokaigodoRadioItem4(){
    if(yokaigodoRadioItem4==null){

      yokaigodoRadioItem4 = new ACRadioButtonItem();

      yokaigodoRadioItem4.setText("経過的要介護");

      yokaigodoRadioItem4.setGroup(getYokaigodo());

      yokaigodoRadioItem4.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem4();
    }
    return yokaigodoRadioItem4;

  }

  /**
   * 要介護1を取得します。
   * @return 要介護1
   */
  public ACRadioButtonItem getYokaigodoRadioItem5(){
    if(yokaigodoRadioItem5==null){

      yokaigodoRadioItem5 = new ACRadioButtonItem();

      yokaigodoRadioItem5.setText("要介護1");

      yokaigodoRadioItem5.setGroup(getYokaigodo());

      yokaigodoRadioItem5.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem5();
    }
    return yokaigodoRadioItem5;

  }

  /**
   * 要介護2を取得します。
   * @return 要介護2
   */
  public ACRadioButtonItem getYokaigodoRadioItem6(){
    if(yokaigodoRadioItem6==null){

      yokaigodoRadioItem6 = new ACRadioButtonItem();

      yokaigodoRadioItem6.setText("要介護2");

      yokaigodoRadioItem6.setGroup(getYokaigodo());

      yokaigodoRadioItem6.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem6();
    }
    return yokaigodoRadioItem6;

  }

  /**
   * 要介護3を取得します。
   * @return 要介護3
   */
  public ACRadioButtonItem getYokaigodoRadioItem7(){
    if(yokaigodoRadioItem7==null){

      yokaigodoRadioItem7 = new ACRadioButtonItem();

      yokaigodoRadioItem7.setText("要介護3");

      yokaigodoRadioItem7.setGroup(getYokaigodo());

      yokaigodoRadioItem7.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem7();
    }
    return yokaigodoRadioItem7;

  }

  /**
   * 要介護4を取得します。
   * @return 要介護4
   */
  public ACRadioButtonItem getYokaigodoRadioItem8(){
    if(yokaigodoRadioItem8==null){

      yokaigodoRadioItem8 = new ACRadioButtonItem();

      yokaigodoRadioItem8.setText("要介護4");

      yokaigodoRadioItem8.setGroup(getYokaigodo());

      yokaigodoRadioItem8.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem8();
    }
    return yokaigodoRadioItem8;

  }

  /**
   * 要介護5を取得します。
   * @return 要介護5
   */
  public ACRadioButtonItem getYokaigodoRadioItem9(){
    if(yokaigodoRadioItem9==null){

      yokaigodoRadioItem9 = new ACRadioButtonItem();

      yokaigodoRadioItem9.setText("要介護5");

      yokaigodoRadioItem9.setGroup(getYokaigodo());

      yokaigodoRadioItem9.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem9();
    }
    return yokaigodoRadioItem9;

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

      doctorName.setColumns(26);

      doctorName.setIMEMode(InputSubset.KANJI);

      doctorName.setMaxLength(26);

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

      providerName.setModelBindPath("PROVIDER_NAMES");

      providerName.setRenderBindPath("PROVIDER_NAME");

      providerName.setIMEMode(InputSubset.KANJI);

      providerName.setMaxLength(64);

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
   * Tab「看護・リハビリテーションの目的／備考」を取得します。
   * @return Tab「看護・リハビリテーションの目的／備考」
   */
  public ACPanel getTabPurposes(){
    if(tabPurposes==null){

      tabPurposes = new ACPanel();

      addTabPurposes();
    }
    return tabPurposes;

  }

  /**
   * 看護・リハビリテーションの目的領域を取得します。
   * @return 看護・リハビリテーションの目的領域
   */
  public ACGroupBox getPlanPurposes(){
    if(planPurposes==null){

      planPurposes = new ACGroupBox();

      planPurposes.setText("看護・リハビリテーションの目標(44x13)");

      addPlanPurposes();
    }
    return planPurposes;

  }

  /**
   * 看護・リハビリテーションの目的を取得します。
   * @return 看護・リハビリテーションの目的
   */
  public ACTextArea getPlanPurpose(){
    if(planPurpose==null){

      planPurpose = new ACTextArea();

      planPurpose.setBindPath("PLAN_PURPOSE");

      planPurpose.setColumns(88);

      planPurpose.setRows(6);

      planPurpose.setMaxRows(13);

      planPurpose.setIMEMode(InputSubset.KANJI);

      planPurpose.setMaxLength(572);

      planPurpose.setLineWrap(true);

      addPlanPurpose();
    }
    return planPurpose;

  }

  /**
   * 看護・リハビリテーションの目的コンテナを取得します。
   * @return 看護・リハビリテーションの目的コンテナ
   */
  protected ACLabelContainer getPlanPurposeContainer(){
    if(planPurposeContainer==null){
      planPurposeContainer = new ACLabelContainer();
      planPurposeContainer.setFollowChildEnabled(true);
      planPurposeContainer.setVAlignment(VRLayout.CENTER);
      planPurposeContainer.add(getPlanPurpose(), null);
    }
    return planPurposeContainer;
  }

  /**
   * 備考表示領域を取得します。
   * @return 備考表示領域
   */
  public ACGroupBox getPlanComments(){
    if(planComments==null){

      planComments = new ACGroupBox();

      planComments.setText("備考(43x4)");

      addPlanComments();
    }
    return planComments;

  }

  /**
   * 備考を取得します。
   * @return 備考
   */
  public ACTextArea getPlanComment(){
    if(planComment==null){

      planComment = new ACTextArea();

      planComment.setBindPath("PLAN_COMMENT");

      planComment.setColumns(86);

      planComment.setRows(5);

      planComment.setMaxRows(4);

      planComment.setIMEMode(InputSubset.KANJI);

      planComment.setMaxLength(172);

      planComment.setLineWrap(true);

      addPlanComment();
    }
    return planComment;

  }

  /**
   * 備考コンテナを取得します。
   * @return 備考コンテナ
   */
  protected ACLabelContainer getPlanCommentContainer(){
    if(planCommentContainer==null){
      planCommentContainer = new ACLabelContainer();
      planCommentContainer.setFollowChildEnabled(true);
      planCommentContainer.setVAlignment(VRLayout.CENTER);
      planCommentContainer.add(getPlanComment(), null);
    }
    return planCommentContainer;
  }

  /**
   * Tab1「問題点・解決策/評価」を取得します。
   * @return Tab1「問題点・解決策/評価」
   */
  public ACPanel getTabsNotes(){
    if(tabsNotes==null){

      tabsNotes = new ACPanel();

      addTabsNotes();
    }
    return tabsNotes;

  }

  /**
   * 問題点・解決策・評価領域を取得します。
   * @return 問題点・解決策・評価領域
   */
  public ACPanel getPlanNoteAreas(){
    if(planNoteAreas==null){

      planNoteAreas = new ACPanel();

      addPlanNoteAreas();
    }
    return planNoteAreas;

  }

  /**
   * 問題点・解決策・評価一覧を取得します。
   * @return 問題点・解決策・評価一覧
   */
  public ACTable getPlanNotes(){
    if(planNotes==null){

      planNotes = new ACTable();

      planNotes.setColumnModel(getPlanNotesColumnModel());

      addPlanNotes();
    }
    return planNotes;

  }

  /**
   * 問題点・解決策・評価一覧カラムモデルを取得します。
   * @return 問題点・解決策・評価一覧カラムモデル
   */
  protected VRTableColumnModel getPlanNotesColumnModel(){
    if(planNotesColumnModel==null){
      planNotesColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addPlanNotesColumnModel();
    }
    return planNotesColumnModel;
  }

  /**
   * 列：Noを取得します。
   * @return 列：No
   */
  public ACTableColumn getPlanNotesColumn0(){
    if(planNotesColumn0==null){

      planNotesColumn0 = new ACTableColumn();

      planNotesColumn0.setHeaderValue("No.");

      planNotesColumn0.setColumnName("NOTE_ID");

      planNotesColumn0.setColumns(3);

      planNotesColumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      planNotesColumn0.setSortable(false);

      addPlanNotesColumn0();
    }
    return planNotesColumn0;

  }

  /**
   * 列：年月日を取得します。
   * @return 列：年月日
   */
  public ACTableColumn getPlanNotesColumn1(){
    if(planNotesColumn1==null){

      planNotesColumn1 = new ACTableColumn();

      planNotesColumn1.setHeaderValue("年月日");

      planNotesColumn1.setColumnName("NOTE_DATE");

      planNotesColumn1.setColumns(10);

      addPlanNotesColumn1();
    }
    return planNotesColumn1;

  }

  /**
   * 列：問題点・解決策を取得します。
   * @return 列：問題点・解決策
   */
  public ACTableColumn getPlanNotesColumn2(){
    if(planNotesColumn2==null){

      planNotesColumn2 = new ACTableColumn();

      planNotesColumn2.setHeaderValue("問題点・解決策");

      planNotesColumn2.setColumnName("NOTE_COMMENT");

      planNotesColumn2.setColumns(50);

      addPlanNotesColumn2();
    }
    return planNotesColumn2;

  }

  /**
   * 列：評価を取得します。
   * @return 列：評価
   */
  public ACTableColumn getPlanNotesColumn3(){
    if(planNotesColumn3==null){

      planNotesColumn3 = new ACTableColumn();

      planNotesColumn3.setHeaderValue("評価");

      planNotesColumn3.setColumnName("NOTE_ASSESSMENT");

      planNotesColumn3.setColumns(8);

      addPlanNotesColumn3();
    }
    return planNotesColumn3;

  }

  /**
   * 問題点・解決策・評価編集領域を取得します。
   * @return 問題点・解決策・評価編集領域
   */
  public ACGroupBox getPlanNoteEdits(){
    if(planNoteEdits==null){

      planNoteEdits = new ACGroupBox();

      planNoteEdits.setText("問題点・解決策／評価");

      planNoteEdits.setHgap(0);

      planNoteEdits.setLabelMargin(0);

      planNoteEdits.setVgap(0);

      addPlanNoteEdits();
    }
    return planNoteEdits;

  }

  /**
   * パネルを取得します。
   * @return パネル
   */
  public ACPanel getPlanPanel(){
    if(planPanel==null){

      planPanel = new ACPanel();

      planPanel.setAutoWrap(false);

      planPanel.setHgap(0);

      planPanel.setLabelMargin(0);

      planPanel.setVgap(0);

      addPlanPanel();
    }
    return planPanel;

  }

  /**
   * 問題点・解決策編集/入力領域を取得します。
   * @return 問題点・解決策編集/入力領域
   */
  public ACPanel getPlanNoteEditDates(){
    if(planNoteEditDates==null){

      planNoteEditDates = new ACPanel();

      planNoteEditDates.setAutoWrap(false);

      addPlanNoteEditDates();
    }
    return planNoteEditDates;

  }

  /**
   * 問題点・解決策編集/日付を取得します。
   * @return 問題点・解決策編集/日付
   */
  public QkanDateTextField getPlanNoteEditDate(){
    if(planNoteEditDate==null){

      planNoteEditDate = new QkanDateTextField();

      getPlanNoteEditDateContainer().setText("年月日");

      planNoteEditDate.setBindPath("NOTE_DATE");

      addPlanNoteEditDate();
    }
    return planNoteEditDate;

  }

  /**
   * 問題点・解決策編集/日付コンテナを取得します。
   * @return 問題点・解決策編集/日付コンテナ
   */
  protected ACLabelContainer getPlanNoteEditDateContainer(){
    if(planNoteEditDateContainer==null){
      planNoteEditDateContainer = new ACLabelContainer();
      planNoteEditDateContainer.setFollowChildEnabled(true);
      planNoteEditDateContainer.setVAlignment(VRLayout.CENTER);
      planNoteEditDateContainer.add(getPlanNoteEditDate(), null);
    }
    return planNoteEditDateContainer;
  }

  /**
   * 問題点・解決策編集個別領域を取得します。
   * @return 問題点・解決策編集個別領域
   */
  public ACGroupBox getPlanNoteEditComments(){
    if(planNoteEditComments==null){

      planNoteEditComments = new ACGroupBox();

      planNoteEditComments.setText("問題点・解決策");

      addPlanNoteEditComments();
    }
    return planNoteEditComments;

  }

  /**
   * 問題点・解決策編集/テキストを取得します。
   * @return 問題点・解決策編集/テキスト
   */
  public ACTextArea getPlanNoteEditComment(){
    if(planNoteEditComment==null){

      planNoteEditComment = new ACTextArea();

      planNoteEditComment.setBindPath("NOTE_COMMENT");

      planNoteEditComment.setColumns(68);

      planNoteEditComment.setRows(5);

      planNoteEditComment.setMaxRows(30);

      planNoteEditComment.setIMEMode(InputSubset.KANJI);

      planNoteEditComment.setMaxLength(3000);

      planNoteEditComment.setLineWrap(true);

      addPlanNoteEditComment();
    }
    return planNoteEditComment;

  }

  /**
   * 問題点・解決策編集/テキストコンテナを取得します。
   * @return 問題点・解決策編集/テキストコンテナ
   */
  protected ACLabelContainer getPlanNoteEditCommentContainer(){
    if(planNoteEditCommentContainer==null){
      planNoteEditCommentContainer = new ACLabelContainer();
      planNoteEditCommentContainer.setFollowChildEnabled(true);
      planNoteEditCommentContainer.setVAlignment(VRLayout.CENTER);
      planNoteEditCommentContainer.add(getPlanNoteEditComment(), null);
    }
    return planNoteEditCommentContainer;
  }

  /**
   * 評価編集個別領域を取得します。
   * @return 評価編集個別領域
   */
  public ACGroupBox getPlanAssessmentEditComments(){
    if(planAssessmentEditComments==null){

      planAssessmentEditComments = new ACGroupBox();

      planAssessmentEditComments.setText("評価");

      addPlanAssessmentEditComments();
    }
    return planAssessmentEditComments;

  }

  /**
   * 評価編集/テキストを取得します。
   * @return 評価編集/テキスト
   */
  public ACTextArea getPlanAssessmentEditComment(){
    if(planAssessmentEditComment==null){

      planAssessmentEditComment = new ACTextArea();

      planAssessmentEditComment.setBindPath("NOTE_ASSESSMENT");

      planAssessmentEditComment.setColumns(20);

      planAssessmentEditComment.setRows(5);

      planAssessmentEditComment.setMaxRows(30);

      planAssessmentEditComment.setIMEMode(InputSubset.KANJI);

      planAssessmentEditComment.setMaxLength(3000);

      planAssessmentEditComment.setLineWrap(true);

      addPlanAssessmentEditComment();
    }
    return planAssessmentEditComment;

  }

  /**
   * 評価編集/テキストコンテナを取得します。
   * @return 評価編集/テキストコンテナ
   */
  protected ACLabelContainer getPlanAssessmentEditCommentContainer(){
    if(planAssessmentEditCommentContainer==null){
      planAssessmentEditCommentContainer = new ACLabelContainer();
      planAssessmentEditCommentContainer.setFollowChildEnabled(true);
      planAssessmentEditCommentContainer.setVAlignment(VRLayout.CENTER);
      planAssessmentEditCommentContainer.add(getPlanAssessmentEditComment(), null);
    }
    return planAssessmentEditCommentContainer;
  }

  /**
   * 問題点・解決策編集/ボタン領域を取得します。
   * @return 問題点・解決策編集/ボタン領域
   */
  public ACPanel getPlanNoteEditButtons(){
    if(planNoteEditButtons==null){

      planNoteEditButtons = new ACPanel();

      addPlanNoteEditButtons();
    }
    return planNoteEditButtons;

  }

  /**
   * 問題点・解決策編集/ボタン・追加を取得します。
   * @return 問題点・解決策編集/ボタン・追加
   */
  public ACButton getPlanNoteEditButtonAdd(){
    if(planNoteEditButtonAdd==null){

      planNoteEditButtonAdd = new ACButton();

      planNoteEditButtonAdd.setText("追加");

      planNoteEditButtonAdd.setToolTipText("入力された「問題点・解決策」を追加します。");

      planNoteEditButtonAdd.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addPlanNoteEditButtonAdd();
    }
    return planNoteEditButtonAdd;

  }

  /**
   * 問題点・解決策編集/ボタン・書替を取得します。
   * @return 問題点・解決策編集/ボタン・書替
   */
  public ACButton getPlanNoteEditButtonEdit(){
    if(planNoteEditButtonEdit==null){

      planNoteEditButtonEdit = new ACButton();

      planNoteEditButtonEdit.setText("書替");

      planNoteEditButtonEdit.setToolTipText("入力された「問題点・解決策」で、選択されている項目を上書します。");

      planNoteEditButtonEdit.setIconPath(ACConstants.ICON_PATH_STATE_UPDATE_16);

      addPlanNoteEditButtonEdit();
    }
    return planNoteEditButtonEdit;

  }

  /**
   * 問題点・解決策編集/ボタン・削除を取得します。
   * @return 問題点・解決策編集/ボタン・削除
   */
  public ACButton getPlanNoteEditButtonDelete(){
    if(planNoteEditButtonDelete==null){

      planNoteEditButtonDelete = new ACButton();

      planNoteEditButtonDelete.setText("削除");

      planNoteEditButtonDelete.setToolTipText("選択されている「問題点・解決策」を削除します。");

      planNoteEditButtonDelete.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addPlanNoteEditButtonDelete();
    }
    return planNoteEditButtonDelete;

  }

  /**
   * 問題点・解決策編集/ボタン・クリアを取得します。
   * @return 問題点・解決策編集/ボタン・クリア
   */
  public ACButton getPlanNoteEditButtonClear(){
    if(planNoteEditButtonClear==null){

      planNoteEditButtonClear = new ACButton();

      planNoteEditButtonClear.setText("クリア");

      planNoteEditButtonClear.setToolTipText("入力されている｢問題点・解決策｣の日付と内容をクリアします。");

      planNoteEditButtonClear.setIconPath(ACConstants.ICON_PATH_CLEAR_16);

      addPlanNoteEditButtonClear();
    }
    return planNoteEditButtonClear;

  }

  /**
   * コンストラクタです。
   */
  public QC001Design() {

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

    getYokaigodoRadioItem1().setButtonIndex(1);

    getYokaigodoModel().add(getYokaigodoRadioItem1());

    getYokaigodoRadioItem2().setButtonIndex(12);

    getYokaigodoModel().add(getYokaigodoRadioItem2());

    getYokaigodoRadioItem3().setButtonIndex(13);

    getYokaigodoModel().add(getYokaigodoRadioItem3());

    getYokaigodoRadioItem4().setButtonIndex(11);

    getYokaigodoModel().add(getYokaigodoRadioItem4());

    getYokaigodoRadioItem5().setButtonIndex(21);

    getYokaigodoModel().add(getYokaigodoRadioItem5());

    getYokaigodoRadioItem6().setButtonIndex(22);

    getYokaigodoModel().add(getYokaigodoRadioItem6());

    getYokaigodoRadioItem7().setButtonIndex(23);

    getYokaigodoModel().add(getYokaigodoRadioItem7());

    getYokaigodoRadioItem8().setButtonIndex(24);

    getYokaigodoModel().add(getYokaigodoRadioItem8());

    getYokaigodoRadioItem9().setButtonIndex(25);

    getYokaigodoModel().add(getYokaigodoRadioItem9());

  }

  /**
   * 自立に内部項目を追加します。
   */
  protected void addYokaigodoRadioItem1(){

  }

  /**
   * 要支援１に内部項目を追加します。
   */
  protected void addYokaigodoRadioItem2(){

  }

  /**
   * 要支援２に内部項目を追加します。
   */
  protected void addYokaigodoRadioItem3(){

  }

  /**
   * 経過的要介護に内部項目を追加します。
   */
  protected void addYokaigodoRadioItem4(){

  }

  /**
   * 要介護1に内部項目を追加します。
   */
  protected void addYokaigodoRadioItem5(){

  }

  /**
   * 要介護2に内部項目を追加します。
   */
  protected void addYokaigodoRadioItem6(){

  }

  /**
   * 要介護3に内部項目を追加します。
   */
  protected void addYokaigodoRadioItem7(){

  }

  /**
   * 要介護4に内部項目を追加します。
   */
  protected void addYokaigodoRadioItem8(){

  }

  /**
   * 要介護5に内部項目を追加します。
   */
  protected void addYokaigodoRadioItem9(){

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

    tabs.addTab("看護・リハビリテーションの目標／備考", getTabPurposes());

    tabs.addTab("問題点・解決策／評価", getTabsNotes());

  }

  /**
   * Tab「看護・リハビリテーションの目的／備考」に内部項目を追加します。
   */
  protected void addTabPurposes(){

    tabPurposes.add(getPlanPurposes(), VRLayout.FLOW_RETURN);

    tabPurposes.add(getPlanComments(), VRLayout.FLOW_RETURN);

  }

  /**
   * 看護・リハビリテーションの目的領域に内部項目を追加します。
   */
  protected void addPlanPurposes(){

    planPurposes.add(getPlanPurposeContainer(), VRLayout.FLOW);

  }

  /**
   * 看護・リハビリテーションの目的に内部項目を追加します。
   */
  protected void addPlanPurpose(){

  }

  /**
   * 備考表示領域に内部項目を追加します。
   */
  protected void addPlanComments(){

    planComments.add(getPlanCommentContainer(), VRLayout.FLOW);

  }

  /**
   * 備考に内部項目を追加します。
   */
  protected void addPlanComment(){

  }

  /**
   * Tab1「問題点・解決策/評価」に内部項目を追加します。
   */
  protected void addTabsNotes(){

    tabsNotes.add(getPlanNoteAreas(), VRLayout.CLIENT);

  }

  /**
   * 問題点・解決策・評価領域に内部項目を追加します。
   */
  protected void addPlanNoteAreas(){

    planNoteAreas.add(getPlanNotes(), VRLayout.NORTH);

    planNoteAreas.add(getPlanNoteEdits(), VRLayout.NORTH);

  }

  /**
   * 問題点・解決策・評価一覧に内部項目を追加します。
   */
  protected void addPlanNotes(){

  }

  /**
   * 問題点・解決策・評価一覧カラムモデルに内部項目を追加します。
   */
  protected void addPlanNotesColumnModel(){

    getPlanNotesColumnModel().addColumn(getPlanNotesColumn0());

    getPlanNotesColumnModel().addColumn(getPlanNotesColumn1());

    getPlanNotesColumnModel().addColumn(getPlanNotesColumn2());

    getPlanNotesColumnModel().addColumn(getPlanNotesColumn3());

  }

  /**
   * 列：Noに内部項目を追加します。
   */
  protected void addPlanNotesColumn0(){

  }

  /**
   * 列：年月日に内部項目を追加します。
   */
  protected void addPlanNotesColumn1(){

  }

  /**
   * 列：問題点・解決策に内部項目を追加します。
   */
  protected void addPlanNotesColumn2(){

  }

  /**
   * 列：評価に内部項目を追加します。
   */
  protected void addPlanNotesColumn3(){

  }

  /**
   * 問題点・解決策・評価編集領域に内部項目を追加します。
   */
  protected void addPlanNoteEdits(){

    planNoteEdits.add(getPlanPanel(), VRLayout.FLOW);

  }

  /**
   * パネルに内部項目を追加します。
   */
  protected void addPlanPanel(){

    planPanel.add(getPlanNoteEditDates(), VRLayout.FLOW_RETURN);

    planPanel.add(getPlanNoteEditComments(), VRLayout.FLOW);

    planPanel.add(getPlanAssessmentEditComments(), VRLayout.FLOW_RETURN);

    planPanel.add(getPlanNoteEditButtons(), VRLayout.FLOW);

  }

  /**
   * 問題点・解決策編集/入力領域に内部項目を追加します。
   */
  protected void addPlanNoteEditDates(){

    planNoteEditDates.add(getPlanNoteEditDateContainer(), VRLayout.FLOW);

  }

  /**
   * 問題点・解決策編集/日付に内部項目を追加します。
   */
  protected void addPlanNoteEditDate(){

  }

  /**
   * 問題点・解決策編集個別領域に内部項目を追加します。
   */
  protected void addPlanNoteEditComments(){

    planNoteEditComments.add(getPlanNoteEditCommentContainer(), VRLayout.FLOW);

  }

  /**
   * 問題点・解決策編集/テキストに内部項目を追加します。
   */
  protected void addPlanNoteEditComment(){

  }

  /**
   * 評価編集個別領域に内部項目を追加します。
   */
  protected void addPlanAssessmentEditComments(){

    planAssessmentEditComments.add(getPlanAssessmentEditCommentContainer(), VRLayout.FLOW);

  }

  /**
   * 評価編集/テキストに内部項目を追加します。
   */
  protected void addPlanAssessmentEditComment(){

  }

  /**
   * 問題点・解決策編集/ボタン領域に内部項目を追加します。
   */
  protected void addPlanNoteEditButtons(){

    planNoteEditButtons.add(getPlanNoteEditButtonAdd(), VRLayout.WEST);

    planNoteEditButtons.add(getPlanNoteEditButtonEdit(), VRLayout.WEST);

    planNoteEditButtons.add(getPlanNoteEditButtonDelete(), VRLayout.WEST);

    planNoteEditButtons.add(getPlanNoteEditButtonClear(), VRLayout.WEST);

  }

  /**
   * 問題点・解決策編集/ボタン・追加に内部項目を追加します。
   */
  protected void addPlanNoteEditButtonAdd(){

  }

  /**
   * 問題点・解決策編集/ボタン・書替に内部項目を追加します。
   */
  protected void addPlanNoteEditButtonEdit(){

  }

  /**
   * 問題点・解決策編集/ボタン・削除に内部項目を追加します。
   */
  protected void addPlanNoteEditButtonDelete(){

  }

  /**
   * 問題点・解決策編集/ボタン・クリアに内部項目を追加します。
   */
  protected void addPlanNoteEditButtonClear(){

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
      ACFrame.debugStart(new ACAffairInfo(QC001Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QC001Design getThis() {
    return this;
  }
}
