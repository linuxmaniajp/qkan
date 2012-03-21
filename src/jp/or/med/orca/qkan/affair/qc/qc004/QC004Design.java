
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
 * 作成日: 2006/04/04  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 帳票管理 (C)
 * プロセス 訪問看護の記録書I (004)
 * プログラム 訪問看護の記録書I (QC004)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qc.qc004;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.im.InputSubset;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACAffairButton;
import jp.nichicom.ac.component.ACAffairButtonBar;
import jp.nichicom.ac.component.ACClearableRadioButtonGroup;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACTextArea;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.ACTimeTextField;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACAffairable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanAffairContainer;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.component.QkanDateTextField;
/**
 * 訪問看護の記録書I画面項目デザイン(QC004) 
 */
public class QC004Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton open;

  private ACAffairButton insert;

  private ACAffairButton update;

  private ACAffairButton print;

  private ACPanel contents;

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

  private ACTextField patientAddress;

  private ACLabelContainer patientAddressContainer;

  private ACLabelContainer patientTels;

  private ACTextField patientTel1;

  private ACLabel patientLabel1;

  private ACTextField patientTel2;

  private ACLabel patientLabel2;

  private ACTextField patientTel3;

  private ACPanel nurses;

  private ACGroupBox nurse;

  private ACTextField nurseName;

  private ACLabelContainer nurseNameContainer;

  private ACLabelContainer firstVisitDates;

  private QkanDateTextField firstVisitDateStart;

  private ACLabel firstVisitDateTimeLabel;

  private ACTimeTextField firstVisitDateStartHour;

  private ACLabel firstVisitDateLabel;

  private ACTimeTextField firstVisitDateEndHour;

  private JTabbedPane tabs;

  private ACPanel points1;

  private ACGroupBox mainDiseases;

  private ACTextArea mainDisease;

  private ACLabelContainer mainDiseaseContainer;

  private ACGroupBox diseaseConditionAndTreatments;

  private ACTextArea diseaseConditionAndTreatment;

  private ACLabelContainer diseaseConditionAndTreatmentContainer;

  private ACPanel points2;

  private ACGroupBox genbyorekis;

  private ACTextArea genbyoreki;

  private ACLabelContainer genbyorekiContainer;

  private ACGroupBox existingAddressHistorys;

  private ACTextArea existingAddressHistory;

  private ACLabelContainer existingAddressHistoryContainer;

  private ACPanel points3;

  private ACGroupBox lifeHistorys;

  private ACTextArea lifeHistory;

  private ACLabelContainer lifeHistoryContainer;

  private ACGroupBox familyStructureas;

  private GridBagLayout familyStructre;

  private ACLabel familyStructreNameHeader;

  private ACLabel familyStructreAgeHeader;

  private ACLabel familyStructreRelationHeader;

  private ACLabel familyStructreJobHeader;

  private ACLabel familyStructreCommentHeader;

  private ACTextField familyStructreName1;

  private ACTextField familyStructreAge1;

  private ACTextField familyStructreRelation1;

  private ACTextField familyStructreJob1;

  private ACTextField familyStructreComment1;

  private ACTextField familyStructreName2;

  private ACTextField familyStructreAge2;

  private ACTextField familyStructreRelation2;

  private ACTextField familyStructreJob2;

  private ACTextField familyStructreComment2;

  private ACTextField familyStructreName3;

  private ACTextField familyStructreAge3;

  private ACTextField familyStructreRelation3;

  private ACTextField familyStructreJob3;

  private ACTextField familyStructreComment3;

  private ACTextField familyStructreName4;

  private ACTextField familyStructreAge4;

  private ACTextField familyStructreRelation4;

  private ACTextField familyStructreJob4;

  private ACTextField familyStructreComment4;

  private ACTextField familyStructreName5;

  private ACTextField familyStructreAge5;

  private ACTextField familyStructreRelation5;

  private ACTextField familyStructreJob5;

  private ACTextField familyStructreComment5;

  private ACTextField familyStructreName6;

  private ACTextField familyStructreAge6;

  private ACTextField familyStructreRelation6;

  private ACTextField familyStructreJob6;

  private ACTextField familyStructreComment6;

  private ACPanel points4;

  private ACGroupBox mainCaares;

  private ACTextArea mainCare;

  private ACLabelContainer mainCareContainer;

  private ACGroupBox jyukankyos;

  private ACTextArea jyukankyo;

  private ACLabelContainer jyukankyoContainer;

  private ACPanel points5;

  private ACGroupBox patientAndFamilyRequests;

  private ACTextArea patientAndFamilyRequest;

  private ACLabelContainer patientAndFamilyRequestContainer;

  private ACGroupBox syujis;

  private ACTextField syujiName;

  private ACLabelContainer syujiNameContainer;

  private ACComboBox syujiMedicalName;

  private ACLabelContainer syujiMedicalNameContainer;

  private ACComboBoxModelAdapter syujiMedicalNameModel;

  private ACTextArea syujiAddress;

  private ACLabelContainer syujiAddressContainer;

  private ACLabelContainer suijiTels;

  private ACTextField syujiTel1;

  private ACLabel syujiLabel1;

  private ACTextField syujiTel2;

  private ACLabel syujiLabel2;

  private ACTextField syujiTel3;

  private ACPanel points6;

  private ACGroupBox RequestObjects;

  private ACClearableRadioButtonGroup RequestObjectMove;

  private ACLabelContainer RequestObjectMoveContainer;

  private ACListModelAdapter RequestObjectMoveModel;

  private ACRadioButtonItem RequestObjectMoveRadioItem1;

  private ACRadioButtonItem RequestObjectMoveRadioItem2;

  private ACRadioButtonItem RequestObjectMoveRadioItem3;

  private ACRadioButtonItem RequestObjectMoveRadioItem4;

  private ACClearableRadioButtonGroup RequestObjectDinner;

  private ACLabelContainer RequestObjectDinnerContainer;

  private ACListModelAdapter RequestObjectDinnerModel;

  private ACRadioButtonItem RequestObjectDinnerRadioItem1;

  private ACRadioButtonItem RequestObjectDinnerRadioItem2;

  private ACRadioButtonItem RequestObjectDinnerRadioItem3;

  private ACRadioButtonItem RequestObjectDinnerRadioItem4;

  private ACClearableRadioButtonGroup RequestObjectExcrete;

  private ACLabelContainer RequestObjectExcreteContainer;

  private ACListModelAdapter RequestObjectExcreteModel;

  private ACRadioButtonItem RequestObjectExcreteRadioItem1;

  private ACRadioButtonItem RequestObjectExcreteRadioItem2;

  private ACRadioButtonItem RequestObjectExcreteRadioItem3;

  private ACRadioButtonItem RequestObjectExcreteRadioItem4;

  private ACClearableRadioButtonGroup RequestObjectBath;

  private ACLabelContainer RequestObjectBathContainer;

  private ACListModelAdapter RequestObjectBathModel;

  private ACRadioButtonItem RequestObjectBathRadioItem1;

  private ACRadioButtonItem RequestObjectBathRadioItem2;

  private ACRadioButtonItem RequestObjectBathRadioItem3;

  private ACRadioButtonItem RequestObjectBathRadioItem4;

  private ACClearableRadioButtonGroup RequestObjectChangeClothes;

  private ACLabelContainer RequestObjectChangeClothesContainer;

  private ACListModelAdapter RequestObjectChangeClothesModel;

  private ACRadioButtonItem RequestObjectChangeClothesRadioItem1;

  private ACRadioButtonItem RequestObjectChangeClothesRadioItem2;

  private ACRadioButtonItem RequestObjectChangeClothesRadioItem3;

  private ACRadioButtonItem RequestObjectChangeClothesRadioItem4;

  private ACClearableRadioButtonGroup RequestObjectSeiyo;

  private ACLabelContainer RequestObjectSeiyoContainer;

  private ACListModelAdapter RequestObjectSeiyoModel;

  private ACRadioButtonItem RequestObjectSeiyoRadioItem1;

  private ACRadioButtonItem RequestObjectSeiyoRadioItem2;

  private ACRadioButtonItem RequestObjectSeiyoRadioItem3;

  private ACRadioButtonItem RequestObjectSeiyoRadioItem4;

  private ACClearableRadioButtonGroup RequestObjectIsisotu;

  private ACLabelContainer RequestObjectIsisotuContainer;

  private ACListModelAdapter RequestObjectIsisotuModel;

  private ACRadioButtonItem RequestObjectIsisotuRadioItem1;

  private ACRadioButtonItem RequestObjectIsisotuRadioItem2;

  private ACRadioButtonItem RequestObjectIsisotuRadioItem3;

  private ACRadioButtonItem RequestObjectIsisotuRadioItem4;

  private ACGroupBox emergencyContacts;

  private ACTextArea emergencyContact;

  private ACLabelContainer emergencyContactContainer;

  private ACPanel points7;

  private ACGroupBox kankeikikans;

  private GridBagLayout kankeikikanLayout;

  private ACLabel contactAddressHeader;

  private ACLabel chargeHeader;

  private ACLabel remarkHeader;

  private ACTextField contact1;

  private ACTextField charge1;

  private ACTextField remark1;

  private ACTextField contact2;

  private ACTextField charge2;

  private ACTextField remark2;

  private ACTextField contact3;

  private ACTextField charge3;

  private ACTextField remark3;

  private ACTextField contact4;

  private ACTextField charge4;

  private ACTextField remark4;

  private ACGroupBox hokenfukusis;

  private ACTextArea hokenfukusi;

  private ACLabelContainer hokenfukusiContainer;

  //getter

  /**
   * ボタンバーを取得します。
   * @return ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("訪問看護記録書I");

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
   * 保存を取得します。
   * @return 保存
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

      update.setToolTipText("現在の内容を更新します");

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

      print.setToolTipText("「訪問看護の記録書I」を印刷します。");

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
   * 患者領域を取得します。
   * @return 患者領域
   */
  public ACPanel getPatients(){
    if(patients==null){

      patients = new ACPanel();

      addPatients();
    }
    return patients;

  }

  /**
   * 患者領域・グループを取得します。
   * @return 患者領域・グループ
   */
  public ACGroupBox getPatient(){
    if(patient==null){

      patient = new ACGroupBox();

      patient.setText("患者");

      patient.setHgap(1);

      patient.setLabelMargin(1);

      addPatient();
    }
    return patient;

  }

  /**
   * 患者氏名を取得します。
   * @return 患者氏名
   */
  public ACTextField getPatientName(){
    if(patientName==null){

      patientName = new ACTextField();

      getPatientNameContainer().setText("氏名");

      patientName.setBindPath("PATIENT_NAME");

      patientName.setEditable(false);

      patientName.setColumns(20);

      patientName.setIMEMode(InputSubset.KANJI);

      patientName.setMaxLength(50);

      addPatientName();
    }
    return patientName;

  }

  /**
   * 患者氏名コンテナを取得します。
   * @return 患者氏名コンテナ
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
   * 患者性別を取得します。
   * @return 患者性別
   */
  public ACTextField getPatientSex(){
    if(patientSex==null){

      patientSex = new ACTextField();

      getPatientSexContainer().setText("性別");

      patientSex.setBindPath("PATIENT_SEX");

      patientSex.setEditable(false);

      patientSex.setColumns(2);

      patientSex.setFormat(QkanConstants.FORMAT_SEX);

      patientSex.setIMEMode(InputSubset.KANJI);

      patientSex.setMaxLength(2);

      addPatientSex();
    }
    return patientSex;

  }

  /**
   * 患者性別コンテナを取得します。
   * @return 患者性別コンテナ
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
   * 患者生年月日・コンテナを取得します。
   * @return 患者生年月日・コンテナ
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
   * 患者生年月日を取得します。
   * @return 患者生年月日
   */
  public QkanDateTextField getPatientBirth(){
    if(patientBirth==null){

      patientBirth = new QkanDateTextField();

      patientBirth.setBindPath("PATIENT_BIRTHDAY");

      patientBirth.setEditable(false);

      patientBirth.setColumns(10);

      addPatientBirth();
    }
    return patientBirth;

  }

  /**
   * 患者年齢を取得します。
   * @return 患者年齢
   */
  public ACTextField getPatientAge(){
    if(patientAge==null){

      patientAge = new ACTextField();

      patientAge.setBindPath("PATIENT_AGE");

      patientAge.setEditable(false);

      patientAge.setMaxLength(4);

      addPatientAge();
    }
    return patientAge;

  }

  /**
   * 歳ラベルを取得します。
   * @return 歳ラベル
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
   * 患者住所を取得します。
   * @return 患者住所
   */
  public ACTextField getPatientAddress(){
    if(patientAddress==null){

      patientAddress = new ACTextField();

      getPatientAddressContainer().setText("住所");

      patientAddress.setBindPath("PATIENT_ADDRESS");

      patientAddress.setEditable(false);

      patientAddress.setColumns(25);

      patientAddress.setIMEMode(InputSubset.KANJI);

      patientAddress.setMaxLength(50);

      addPatientAddress();
    }
    return patientAddress;

  }

  /**
   * 患者住所コンテナを取得します。
   * @return 患者住所コンテナ
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
   * 患者電話番号を取得します。
   * @return 患者電話番号
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
   * 患者電話番号1を取得します。
   * @return 患者電話番号1
   */
  public ACTextField getPatientTel1(){
    if(patientTel1==null){

      patientTel1 = new ACTextField();

      patientTel1.setBindPath("PATIENT_TEL_FIRST");

      patientTel1.setEditable(false);

      patientTel1.setColumns(4);

      patientTel1.setCharType(VRCharType.ONLY_DIGIT);

      patientTel1.setIMEMode(InputSubset.LATIN);

      patientTel1.setMaxLength(6);

      addPatientTel1();
    }
    return patientTel1;

  }

  /**
   * 患者電話番号ラベル1を取得します。
   * @return 患者電話番号ラベル1
   */
  public ACLabel getPatientLabel1(){
    if(patientLabel1==null){

      patientLabel1 = new ACLabel();

      patientLabel1.setText("-");

      addPatientLabel1();
    }
    return patientLabel1;

  }

  /**
   * 患者電話番号2を取得します。
   * @return 患者電話番号2
   */
  public ACTextField getPatientTel2(){
    if(patientTel2==null){

      patientTel2 = new ACTextField();

      patientTel2.setBindPath("PATIENT_TEL_SECOND");

      patientTel2.setEditable(false);

      patientTel2.setColumns(4);

      patientTel2.setCharType(VRCharType.ONLY_DIGIT);

      patientTel2.setIMEMode(InputSubset.LATIN);

      patientTel2.setMaxLength(4);

      addPatientTel2();
    }
    return patientTel2;

  }

  /**
   * 患者電話番号ラベル1を取得します。
   * @return 患者電話番号ラベル1
   */
  public ACLabel getPatientLabel2(){
    if(patientLabel2==null){

      patientLabel2 = new ACLabel();

      patientLabel2.setText("-");

      addPatientLabel2();
    }
    return patientLabel2;

  }

  /**
   * 患者電話番号3を取得します。
   * @return 患者電話番号3
   */
  public ACTextField getPatientTel3(){
    if(patientTel3==null){

      patientTel3 = new ACTextField();

      patientTel3.setBindPath("PATIENT_TEL_THIRD");

      patientTel3.setEditable(false);

      patientTel3.setColumns(4);

      patientTel3.setCharType(VRCharType.ONLY_DIGIT);

      patientTel3.setIMEMode(InputSubset.LATIN);

      patientTel3.setMaxLength(4);

      addPatientTel3();
    }
    return patientTel3;

  }

  /**
   * 看護師領域を取得します。
   * @return 看護師領域
   */
  public ACPanel getNurses(){
    if(nurses==null){

      nurses = new ACPanel();

      addNurses();
    }
    return nurses;

  }

  /**
   * 看護師領域・グループを取得します。
   * @return 看護師領域・グループ
   */
  public ACGroupBox getNurse(){
    if(nurse==null){

      nurse = new ACGroupBox();

      nurse.setText("看護師等");

      nurse.setHgap(4);

      nurse.setLabelMargin(3);

      addNurse();
    }
    return nurse;

  }

  /**
   * 看護師氏名を取得します。
   * @return 看護師氏名
   */
  public ACTextField getNurseName(){
    if(nurseName==null){

      nurseName = new ACTextField();

      getNurseNameContainer().setText("氏名");

      nurseName.setBindPath("NURSE_NAME");

      nurseName.setColumns(25);

      nurseName.setIMEMode(InputSubset.KANJI);

      nurseName.setMaxLength(32);

      addNurseName();
    }
    return nurseName;

  }

  /**
   * 看護師氏名コンテナを取得します。
   * @return 看護師氏名コンテナ
   */
  protected ACLabelContainer getNurseNameContainer(){
    if(nurseNameContainer==null){
      nurseNameContainer = new ACLabelContainer();
      nurseNameContainer.setFollowChildEnabled(true);
      nurseNameContainer.setVAlignment(VRLayout.CENTER);
      nurseNameContainer.add(getNurseName(), null);
    }
    return nurseNameContainer;
  }

  /**
   * 看護師初回訪問年月日を取得します。
   * @return 看護師初回訪問年月日
   */
  public ACLabelContainer getFirstVisitDates(){
    if(firstVisitDates==null){

      firstVisitDates = new ACLabelContainer();

      firstVisitDates.setText("初回訪問年月日");

      addFirstVisitDates();
    }
    return firstVisitDates;

  }

  /**
   * 看護師初回訪問年月日(開始時間）を取得します。
   * @return 看護師初回訪問年月日(開始時間）
   */
  public QkanDateTextField getFirstVisitDateStart(){
    if(firstVisitDateStart==null){

      firstVisitDateStart = new QkanDateTextField();

      firstVisitDateStart.setBindPath("FIRST_VISIT_DATE");

      addFirstVisitDateStart();
    }
    return firstVisitDateStart;

  }

  /**
   * 看護師初回訪問年月日・時刻を取得します。
   * @return 看護師初回訪問年月日・時刻
   */
  public ACLabel getFirstVisitDateTimeLabel(){
    if(firstVisitDateTimeLabel==null){

      firstVisitDateTimeLabel = new ACLabel();

      firstVisitDateTimeLabel.setText("時刻");

      firstVisitDateTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);

      addFirstVisitDateTimeLabel();
    }
    return firstVisitDateTimeLabel;

  }

  /**
   * 看護師初回訪問年月日(時を取得します。
   * @return 看護師初回訪問年月日(時
   */
  public ACTimeTextField getFirstVisitDateStartHour(){
    if(firstVisitDateStartHour==null){

      firstVisitDateStartHour = new ACTimeTextField();

      firstVisitDateStartHour.setBindPath("FIRST_VISIT_DATE_START");

      firstVisitDateStartHour.setColumns(3);

      firstVisitDateStartHour.setIMEMode(InputSubset.LATIN);

      firstVisitDateStartHour.setMaxLength(5);

      addFirstVisitDateStartHour();
    }
    return firstVisitDateStartHour;

  }

  /**
   * 看護師初回訪問年月日・ラベルを取得します。
   * @return 看護師初回訪問年月日・ラベル
   */
  public ACLabel getFirstVisitDateLabel(){
    if(firstVisitDateLabel==null){

      firstVisitDateLabel = new ACLabel();

      firstVisitDateLabel.setText("から");

      firstVisitDateLabel.setHorizontalAlignment(SwingConstants.CENTER);

      addFirstVisitDateLabel();
    }
    return firstVisitDateLabel;

  }

  /**
   * 看護師初回訪問年月日(終了時間）を取得します。
   * @return 看護師初回訪問年月日(終了時間）
   */
  public ACTimeTextField getFirstVisitDateEndHour(){
    if(firstVisitDateEndHour==null){

      firstVisitDateEndHour = new ACTimeTextField();

      firstVisitDateEndHour.setBindPath("FIRST_VISIT_DATE_END");

      firstVisitDateEndHour.setColumns(3);

      firstVisitDateEndHour.setIMEMode(InputSubset.LATIN);

      firstVisitDateEndHour.setMaxLength(5);

      addFirstVisitDateEndHour();
    }
    return firstVisitDateEndHour;

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
   * NO.1 傷病名・病状・歴領域を取得します。
   * @return NO.1 傷病名・病状・歴領域
   */
  public ACPanel getPoints1(){
    if(points1==null){

      points1 = new ACPanel();

      addPoints1();
    }
    return points1;

  }

  /**
   * 主たる傷病名・グループを取得します。
   * @return 主たる傷病名・グループ
   */
  public ACGroupBox getMainDiseases(){
    if(mainDiseases==null){

      mainDiseases = new ACGroupBox();

      mainDiseases.setText("主たる傷病名(37x4)");

      mainDiseases.setAutoWrap(false);

      mainDiseases.setHgap(0);

      mainDiseases.setLabelMargin(0);

      addMainDiseases();
    }
    return mainDiseases;

  }

  /**
   * 主な傷病名を取得します。
   * @return 主な傷病名
   */
  public ACTextArea getMainDisease(){
    if(mainDisease==null){

      mainDisease = new ACTextArea();

      mainDisease.setBindPath("DISEASE");

      mainDisease.setColumns(74);

      mainDisease.setRows(5);

      mainDisease.setMaxRows(4);

      mainDisease.setIMEMode(InputSubset.KANJI);

      mainDisease.setMaxLength(148);

      mainDisease.setLineWrap(true);

      addMainDisease();
    }
    return mainDisease;

  }

  /**
   * 主な傷病名コンテナを取得します。
   * @return 主な傷病名コンテナ
   */
  protected ACLabelContainer getMainDiseaseContainer(){
    if(mainDiseaseContainer==null){
      mainDiseaseContainer = new ACLabelContainer();
      mainDiseaseContainer.setFollowChildEnabled(true);
      mainDiseaseContainer.setVAlignment(VRLayout.CENTER);
      mainDiseaseContainer.add(getMainDisease(), null);
    }
    return mainDiseaseContainer;
  }

  /**
   * 病状・治療状態等・グループを取得します。
   * @return 病状・治療状態等・グループ
   */
  public ACGroupBox getDiseaseConditionAndTreatments(){
    if(diseaseConditionAndTreatments==null){

      diseaseConditionAndTreatments = new ACGroupBox();

      diseaseConditionAndTreatments.setText("病状・治療状態等(37x8)");

      diseaseConditionAndTreatments.setAutoWrap(false);

      diseaseConditionAndTreatments.setHgap(0);

      diseaseConditionAndTreatments.setLabelMargin(0);

      addDiseaseConditionAndTreatments();
    }
    return diseaseConditionAndTreatments;

  }

  /**
   * 病状･治療状態等を取得します。
   * @return 病状･治療状態等
   */
  public ACTextArea getDiseaseConditionAndTreatment(){
    if(diseaseConditionAndTreatment==null){

      diseaseConditionAndTreatment = new ACTextArea();

      diseaseConditionAndTreatment.setBindPath("BYOJO_CHIYU_JOTAI");

      diseaseConditionAndTreatment.setColumns(74);

      diseaseConditionAndTreatment.setRows(9);

      diseaseConditionAndTreatment.setMaxRows(8);

      diseaseConditionAndTreatment.setIMEMode(InputSubset.KANJI);

      diseaseConditionAndTreatment.setMaxLength(296);

      diseaseConditionAndTreatment.setLineWrap(true);

      addDiseaseConditionAndTreatment();
    }
    return diseaseConditionAndTreatment;

  }

  /**
   * 病状･治療状態等コンテナを取得します。
   * @return 病状･治療状態等コンテナ
   */
  protected ACLabelContainer getDiseaseConditionAndTreatmentContainer(){
    if(diseaseConditionAndTreatmentContainer==null){
      diseaseConditionAndTreatmentContainer = new ACLabelContainer();
      diseaseConditionAndTreatmentContainer.setFollowChildEnabled(true);
      diseaseConditionAndTreatmentContainer.setVAlignment(VRLayout.CENTER);
      diseaseConditionAndTreatmentContainer.add(getDiseaseConditionAndTreatment(), null);
    }
    return diseaseConditionAndTreatmentContainer;
  }

  /**
   * NO.1 現病歴・既往歴・生活歴を取得します。
   * @return NO.1 現病歴・既往歴・生活歴
   */
  public ACPanel getPoints2(){
    if(points2==null){

      points2 = new ACPanel();

      addPoints2();
    }
    return points2;

  }

  /**
   * 現病歴・グループを取得します。
   * @return 現病歴・グループ
   */
  public ACGroupBox getGenbyorekis(){
    if(genbyorekis==null){

      genbyorekis = new ACGroupBox();

      genbyorekis.setText("現病歴(37x7)");

      genbyorekis.setAutoWrap(false);

      genbyorekis.setHgap(0);

      genbyorekis.setLabelMargin(0);

      addGenbyorekis();
    }
    return genbyorekis;

  }

  /**
   * 現病歴を取得します。
   * @return 現病歴
   */
  public ACTextArea getGenbyoreki(){
    if(genbyoreki==null){

      genbyoreki = new ACTextArea();

      genbyoreki.setBindPath("GENBYOREKI");

      genbyoreki.setColumns(74);

      genbyoreki.setRows(8);

      genbyoreki.setMaxRows(7);

      genbyoreki.setIMEMode(InputSubset.KANJI);

      genbyoreki.setMaxLength(259);

      genbyoreki.setLineWrap(true);

      addGenbyoreki();
    }
    return genbyoreki;

  }

  /**
   * 現病歴コンテナを取得します。
   * @return 現病歴コンテナ
   */
  protected ACLabelContainer getGenbyorekiContainer(){
    if(genbyorekiContainer==null){
      genbyorekiContainer = new ACLabelContainer();
      genbyorekiContainer.setFollowChildEnabled(true);
      genbyorekiContainer.setVAlignment(VRLayout.CENTER);
      genbyorekiContainer.add(getGenbyoreki(), null);
    }
    return genbyorekiContainer;
  }

  /**
   * 既往歴・グループを取得します。
   * @return 既往歴・グループ
   */
  public ACGroupBox getExistingAddressHistorys(){
    if(existingAddressHistorys==null){

      existingAddressHistorys = new ACGroupBox();

      existingAddressHistorys.setText("既往歴(37x7)");

      existingAddressHistorys.setAutoWrap(false);

      existingAddressHistorys.setHgap(0);

      existingAddressHistorys.setLabelMargin(0);

      addExistingAddressHistorys();
    }
    return existingAddressHistorys;

  }

  /**
   * 既往歴を取得します。
   * @return 既往歴
   */
  public ACTextArea getExistingAddressHistory(){
    if(existingAddressHistory==null){

      existingAddressHistory = new ACTextArea();

      existingAddressHistory.setBindPath("KIOREKI");

      existingAddressHistory.setColumns(74);

      existingAddressHistory.setRows(8);

      existingAddressHistory.setMaxRows(7);

      existingAddressHistory.setIMEMode(InputSubset.KANJI);

      existingAddressHistory.setMaxLength(259);

      existingAddressHistory.setLineWrap(true);

      addExistingAddressHistory();
    }
    return existingAddressHistory;

  }

  /**
   * 既往歴コンテナを取得します。
   * @return 既往歴コンテナ
   */
  protected ACLabelContainer getExistingAddressHistoryContainer(){
    if(existingAddressHistoryContainer==null){
      existingAddressHistoryContainer = new ACLabelContainer();
      existingAddressHistoryContainer.setFollowChildEnabled(true);
      existingAddressHistoryContainer.setVAlignment(VRLayout.CENTER);
      existingAddressHistoryContainer.add(getExistingAddressHistory(), null);
    }
    return existingAddressHistoryContainer;
  }

  /**
   * NO.1 生活歴を取得します。
   * @return NO.1 生活歴
   */
  public ACPanel getPoints3(){
    if(points3==null){

      points3 = new ACPanel();

      addPoints3();
    }
    return points3;

  }

  /**
   * 生活歴・グループを取得します。
   * @return 生活歴・グループ
   */
  public ACGroupBox getLifeHistorys(){
    if(lifeHistorys==null){

      lifeHistorys = new ACGroupBox();

      lifeHistorys.setText("生活歴(37x7)");

      lifeHistorys.setAutoWrap(false);

      lifeHistorys.setHgap(0);

      lifeHistorys.setLabelMargin(0);

      addLifeHistorys();
    }
    return lifeHistorys;

  }

  /**
   * 生活歴を取得します。
   * @return 生活歴
   */
  public ACTextArea getLifeHistory(){
    if(lifeHistory==null){

      lifeHistory = new ACTextArea();

      lifeHistory.setBindPath("SEIKATSUREKI");

      lifeHistory.setColumns(74);

      lifeHistory.setRows(8);

      lifeHistory.setMaxRows(7);

      lifeHistory.setIMEMode(InputSubset.KANJI);

      lifeHistory.setMaxLength(259);

      lifeHistory.setLineWrap(true);

      addLifeHistory();
    }
    return lifeHistory;

  }

  /**
   * 生活歴コンテナを取得します。
   * @return 生活歴コンテナ
   */
  protected ACLabelContainer getLifeHistoryContainer(){
    if(lifeHistoryContainer==null){
      lifeHistoryContainer = new ACLabelContainer();
      lifeHistoryContainer.setFollowChildEnabled(true);
      lifeHistoryContainer.setVAlignment(VRLayout.CENTER);
      lifeHistoryContainer.add(getLifeHistory(), null);
    }
    return lifeHistoryContainer;
  }

  /**
   * 家族構成・グループを取得します。
   * @return 家族構成・グループ
   */
  public ACGroupBox getFamilyStructureas(){
    if(familyStructureas==null){

      familyStructureas = new ACGroupBox();

      familyStructureas.setText("家族構成");

      familyStructureas.setLayout(getFamilyStructre());

      addFamilyStructureas();
    }
    return familyStructureas;

  }

  /**
   * 家族構成・レイアウトを取得します。
   * @return 家族構成・レイアウト
   */
  public GridBagLayout getFamilyStructre(){
    if(familyStructre==null){

      familyStructre = new GridBagLayout();

      addFamilyStructre();
    }
    return familyStructre;

  }

  /**
   * 氏名(ヘッダを取得します。
   * @return 氏名(ヘッダ
   */
  public ACLabel getFamilyStructreNameHeader(){
    if(familyStructreNameHeader==null){

      familyStructreNameHeader = new ACLabel();

      familyStructreNameHeader.setText("氏名");

      addFamilyStructreNameHeader();
    }
    return familyStructreNameHeader;

  }

  /**
   * 年齢(ヘッダを取得します。
   * @return 年齢(ヘッダ
   */
  public ACLabel getFamilyStructreAgeHeader(){
    if(familyStructreAgeHeader==null){

      familyStructreAgeHeader = new ACLabel();

      familyStructreAgeHeader.setText("年齢");

      addFamilyStructreAgeHeader();
    }
    return familyStructreAgeHeader;

  }

  /**
   * 続柄(ヘッダを取得します。
   * @return 続柄(ヘッダ
   */
  public ACLabel getFamilyStructreRelationHeader(){
    if(familyStructreRelationHeader==null){

      familyStructreRelationHeader = new ACLabel();

      familyStructreRelationHeader.setText("続柄");

      addFamilyStructreRelationHeader();
    }
    return familyStructreRelationHeader;

  }

  /**
   * 職業(ヘッダを取得します。
   * @return 職業(ヘッダ
   */
  public ACLabel getFamilyStructreJobHeader(){
    if(familyStructreJobHeader==null){

      familyStructreJobHeader = new ACLabel();

      familyStructreJobHeader.setText("職業");

      addFamilyStructreJobHeader();
    }
    return familyStructreJobHeader;

  }

  /**
   * 特記すべき事項(ヘッダを取得します。
   * @return 特記すべき事項(ヘッダ
   */
  public ACLabel getFamilyStructreCommentHeader(){
    if(familyStructreCommentHeader==null){

      familyStructreCommentHeader = new ACLabel();

      familyStructreCommentHeader.setText("特記すべき事項");

      addFamilyStructreCommentHeader();
    }
    return familyStructreCommentHeader;

  }

  /**
   * 氏名1を取得します。
   * @return 氏名1
   */
  public ACTextField getFamilyStructreName1(){
    if(familyStructreName1==null){

      familyStructreName1 = new ACTextField();

      familyStructreName1.setBindPath("FAMILY_NAME1");

      familyStructreName1.setColumns(20);

      familyStructreName1.setIMEMode(InputSubset.KANJI);

      familyStructreName1.setMaxLength(22);

      addFamilyStructreName1();
    }
    return familyStructreName1;

  }

  /**
   * 年齢1を取得します。
   * @return 年齢1
   */
  public ACTextField getFamilyStructreAge1(){
    if(familyStructreAge1==null){

      familyStructreAge1 = new ACTextField();

      familyStructreAge1.setBindPath("FAMILY_AGE1");

      familyStructreAge1.setColumns(3);

      familyStructreAge1.setCharType(VRCharType.ONLY_DIGIT);

      familyStructreAge1.setHorizontalAlignment(SwingConstants.RIGHT);

      familyStructreAge1.setIMEMode(InputSubset.LATIN);

      familyStructreAge1.setMaxLength(3);

      addFamilyStructreAge1();
    }
    return familyStructreAge1;

  }

  /**
   * 続柄1を取得します。
   * @return 続柄1
   */
  public ACTextField getFamilyStructreRelation1(){
    if(familyStructreRelation1==null){

      familyStructreRelation1 = new ACTextField();

      familyStructreRelation1.setBindPath("FAMILY_RELATION1");

      familyStructreRelation1.setColumns(6);

      familyStructreRelation1.setIMEMode(InputSubset.KANJI);

      familyStructreRelation1.setMaxLength(6);

      addFamilyStructreRelation1();
    }
    return familyStructreRelation1;

  }

  /**
   * 職業1を取得します。
   * @return 職業1
   */
  public ACTextField getFamilyStructreJob1(){
    if(familyStructreJob1==null){

      familyStructreJob1 = new ACTextField();

      familyStructreJob1.setBindPath("FAMILY_JOB1");

      familyStructreJob1.setColumns(10);

      familyStructreJob1.setIMEMode(InputSubset.KANJI);

      familyStructreJob1.setMaxLength(12);

      addFamilyStructreJob1();
    }
    return familyStructreJob1;

  }

  /**
   * 特記すべき事項1を取得します。
   * @return 特記すべき事項1
   */
  public ACTextField getFamilyStructreComment1(){
    if(familyStructreComment1==null){

      familyStructreComment1 = new ACTextField();

      familyStructreComment1.setBindPath("FAMILY_COMMENT1");

      familyStructreComment1.setColumns(26);

      familyStructreComment1.setIMEMode(InputSubset.KANJI);

      familyStructreComment1.setMaxLength(30);

      addFamilyStructreComment1();
    }
    return familyStructreComment1;

  }

  /**
   * 氏名2を取得します。
   * @return 氏名2
   */
  public ACTextField getFamilyStructreName2(){
    if(familyStructreName2==null){

      familyStructreName2 = new ACTextField();

      familyStructreName2.setBindPath("FAMILY_NAME2");

      familyStructreName2.setColumns(20);

      familyStructreName2.setIMEMode(InputSubset.KANJI);

      familyStructreName2.setMaxLength(22);

      addFamilyStructreName2();
    }
    return familyStructreName2;

  }

  /**
   * 年齢2を取得します。
   * @return 年齢2
   */
  public ACTextField getFamilyStructreAge2(){
    if(familyStructreAge2==null){

      familyStructreAge2 = new ACTextField();

      familyStructreAge2.setBindPath("FAMILY_AGE2");

      familyStructreAge2.setColumns(3);

      familyStructreAge2.setCharType(VRCharType.ONLY_DIGIT);

      familyStructreAge2.setHorizontalAlignment(SwingConstants.RIGHT);

      familyStructreAge2.setIMEMode(InputSubset.LATIN);

      familyStructreAge2.setMaxLength(3);

      addFamilyStructreAge2();
    }
    return familyStructreAge2;

  }

  /**
   * 続柄2を取得します。
   * @return 続柄2
   */
  public ACTextField getFamilyStructreRelation2(){
    if(familyStructreRelation2==null){

      familyStructreRelation2 = new ACTextField();

      familyStructreRelation2.setBindPath("FAMILY_RELATION2");

      familyStructreRelation2.setColumns(6);

      familyStructreRelation2.setIMEMode(InputSubset.KANJI);

      familyStructreRelation2.setMaxLength(6);

      addFamilyStructreRelation2();
    }
    return familyStructreRelation2;

  }

  /**
   * 職業2を取得します。
   * @return 職業2
   */
  public ACTextField getFamilyStructreJob2(){
    if(familyStructreJob2==null){

      familyStructreJob2 = new ACTextField();

      familyStructreJob2.setBindPath("FAMILY_JOB2");

      familyStructreJob2.setColumns(10);

      familyStructreJob2.setIMEMode(InputSubset.KANJI);

      familyStructreJob2.setMaxLength(12);

      addFamilyStructreJob2();
    }
    return familyStructreJob2;

  }

  /**
   * 特記すべき事項2を取得します。
   * @return 特記すべき事項2
   */
  public ACTextField getFamilyStructreComment2(){
    if(familyStructreComment2==null){

      familyStructreComment2 = new ACTextField();

      familyStructreComment2.setBindPath("FAMILY_COMMENT2");

      familyStructreComment2.setColumns(26);

      familyStructreComment2.setIMEMode(InputSubset.KANJI);

      familyStructreComment2.setMaxLength(30);

      addFamilyStructreComment2();
    }
    return familyStructreComment2;

  }

  /**
   * 氏名3を取得します。
   * @return 氏名3
   */
  public ACTextField getFamilyStructreName3(){
    if(familyStructreName3==null){

      familyStructreName3 = new ACTextField();

      familyStructreName3.setBindPath("FAMILY_NAME3");

      familyStructreName3.setColumns(20);

      familyStructreName3.setIMEMode(InputSubset.KANJI);

      familyStructreName3.setMaxLength(22);

      addFamilyStructreName3();
    }
    return familyStructreName3;

  }

  /**
   * 年齢3を取得します。
   * @return 年齢3
   */
  public ACTextField getFamilyStructreAge3(){
    if(familyStructreAge3==null){

      familyStructreAge3 = new ACTextField();

      familyStructreAge3.setBindPath("FAMILY_AGE3");

      familyStructreAge3.setColumns(3);

      familyStructreAge3.setCharType(VRCharType.ONLY_DIGIT);

      familyStructreAge3.setHorizontalAlignment(SwingConstants.RIGHT);

      familyStructreAge3.setIMEMode(InputSubset.LATIN);

      familyStructreAge3.setMaxLength(3);

      addFamilyStructreAge3();
    }
    return familyStructreAge3;

  }

  /**
   * 続柄3を取得します。
   * @return 続柄3
   */
  public ACTextField getFamilyStructreRelation3(){
    if(familyStructreRelation3==null){

      familyStructreRelation3 = new ACTextField();

      familyStructreRelation3.setBindPath("FAMILY_RELATION3");

      familyStructreRelation3.setColumns(6);

      familyStructreRelation3.setIMEMode(InputSubset.KANJI);

      familyStructreRelation3.setMaxLength(6);

      addFamilyStructreRelation3();
    }
    return familyStructreRelation3;

  }

  /**
   * 職業3を取得します。
   * @return 職業3
   */
  public ACTextField getFamilyStructreJob3(){
    if(familyStructreJob3==null){

      familyStructreJob3 = new ACTextField();

      familyStructreJob3.setBindPath("FAMILY_JOB3");

      familyStructreJob3.setColumns(10);

      familyStructreJob3.setIMEMode(InputSubset.KANJI);

      familyStructreJob3.setMaxLength(12);

      addFamilyStructreJob3();
    }
    return familyStructreJob3;

  }

  /**
   * 特記すべき事項3を取得します。
   * @return 特記すべき事項3
   */
  public ACTextField getFamilyStructreComment3(){
    if(familyStructreComment3==null){

      familyStructreComment3 = new ACTextField();

      familyStructreComment3.setBindPath("FAMILY_COMMENT3");

      familyStructreComment3.setColumns(26);

      familyStructreComment3.setIMEMode(InputSubset.KANJI);

      familyStructreComment3.setMaxLength(30);

      addFamilyStructreComment3();
    }
    return familyStructreComment3;

  }

  /**
   * 氏名4を取得します。
   * @return 氏名4
   */
  public ACTextField getFamilyStructreName4(){
    if(familyStructreName4==null){

      familyStructreName4 = new ACTextField();

      familyStructreName4.setBindPath("FAMILY_NAME4");

      familyStructreName4.setColumns(20);

      familyStructreName4.setIMEMode(InputSubset.KANJI);

      familyStructreName4.setMaxLength(22);

      addFamilyStructreName4();
    }
    return familyStructreName4;

  }

  /**
   * 年齢4を取得します。
   * @return 年齢4
   */
  public ACTextField getFamilyStructreAge4(){
    if(familyStructreAge4==null){

      familyStructreAge4 = new ACTextField();

      familyStructreAge4.setBindPath("FAMILY_AGE4");

      familyStructreAge4.setColumns(3);

      familyStructreAge4.setCharType(VRCharType.ONLY_DIGIT);

      familyStructreAge4.setHorizontalAlignment(SwingConstants.RIGHT);

      familyStructreAge4.setIMEMode(InputSubset.LATIN);

      familyStructreAge4.setMaxLength(3);

      addFamilyStructreAge4();
    }
    return familyStructreAge4;

  }

  /**
   * 続柄4を取得します。
   * @return 続柄4
   */
  public ACTextField getFamilyStructreRelation4(){
    if(familyStructreRelation4==null){

      familyStructreRelation4 = new ACTextField();

      familyStructreRelation4.setBindPath("FAMILY_RELATION4");

      familyStructreRelation4.setColumns(6);

      familyStructreRelation4.setIMEMode(InputSubset.KANJI);

      familyStructreRelation4.setMaxLength(6);

      addFamilyStructreRelation4();
    }
    return familyStructreRelation4;

  }

  /**
   * 職業4を取得します。
   * @return 職業4
   */
  public ACTextField getFamilyStructreJob4(){
    if(familyStructreJob4==null){

      familyStructreJob4 = new ACTextField();

      familyStructreJob4.setBindPath("FAMILY_JOB4");

      familyStructreJob4.setColumns(10);

      familyStructreJob4.setIMEMode(InputSubset.KANJI);

      familyStructreJob4.setMaxLength(12);

      addFamilyStructreJob4();
    }
    return familyStructreJob4;

  }

  /**
   * 特記すべき事項4を取得します。
   * @return 特記すべき事項4
   */
  public ACTextField getFamilyStructreComment4(){
    if(familyStructreComment4==null){

      familyStructreComment4 = new ACTextField();

      familyStructreComment4.setBindPath("FAMILY_COMMENT4");

      familyStructreComment4.setColumns(26);

      familyStructreComment4.setIMEMode(InputSubset.KANJI);

      familyStructreComment4.setMaxLength(30);

      addFamilyStructreComment4();
    }
    return familyStructreComment4;

  }

  /**
   * 氏名5を取得します。
   * @return 氏名5
   */
  public ACTextField getFamilyStructreName5(){
    if(familyStructreName5==null){

      familyStructreName5 = new ACTextField();

      familyStructreName5.setBindPath("FAMILY_NAME5");

      familyStructreName5.setColumns(20);

      familyStructreName5.setIMEMode(InputSubset.KANJI);

      familyStructreName5.setMaxLength(22);

      addFamilyStructreName5();
    }
    return familyStructreName5;

  }

  /**
   * 年齢5を取得します。
   * @return 年齢5
   */
  public ACTextField getFamilyStructreAge5(){
    if(familyStructreAge5==null){

      familyStructreAge5 = new ACTextField();

      familyStructreAge5.setBindPath("FAMILY_AGE5");

      familyStructreAge5.setColumns(3);

      familyStructreAge5.setCharType(VRCharType.ONLY_DIGIT);

      familyStructreAge5.setHorizontalAlignment(SwingConstants.RIGHT);

      familyStructreAge5.setIMEMode(InputSubset.LATIN);

      familyStructreAge5.setMaxLength(3);

      addFamilyStructreAge5();
    }
    return familyStructreAge5;

  }

  /**
   * 続柄5を取得します。
   * @return 続柄5
   */
  public ACTextField getFamilyStructreRelation5(){
    if(familyStructreRelation5==null){

      familyStructreRelation5 = new ACTextField();

      familyStructreRelation5.setBindPath("FAMILY_RELATION5");

      familyStructreRelation5.setColumns(6);

      familyStructreRelation5.setIMEMode(InputSubset.KANJI);

      familyStructreRelation5.setMaxLength(6);

      addFamilyStructreRelation5();
    }
    return familyStructreRelation5;

  }

  /**
   * 職業5を取得します。
   * @return 職業5
   */
  public ACTextField getFamilyStructreJob5(){
    if(familyStructreJob5==null){

      familyStructreJob5 = new ACTextField();

      familyStructreJob5.setBindPath("FAMILY_JOB5");

      familyStructreJob5.setColumns(10);

      familyStructreJob5.setIMEMode(InputSubset.KANJI);

      familyStructreJob5.setMaxLength(12);

      addFamilyStructreJob5();
    }
    return familyStructreJob5;

  }

  /**
   * 特記すべき事項5を取得します。
   * @return 特記すべき事項5
   */
  public ACTextField getFamilyStructreComment5(){
    if(familyStructreComment5==null){

      familyStructreComment5 = new ACTextField();

      familyStructreComment5.setBindPath("FAMILY_COMMENT5");

      familyStructreComment5.setColumns(26);

      familyStructreComment5.setIMEMode(InputSubset.KANJI);

      familyStructreComment5.setMaxLength(30);

      addFamilyStructreComment5();
    }
    return familyStructreComment5;

  }

  /**
   * 氏名6を取得します。
   * @return 氏名6
   */
  public ACTextField getFamilyStructreName6(){
    if(familyStructreName6==null){

      familyStructreName6 = new ACTextField();

      familyStructreName6.setBindPath("FAMILY_NAME6");

      familyStructreName6.setColumns(20);

      familyStructreName6.setIMEMode(InputSubset.KANJI);

      familyStructreName6.setMaxLength(22);

      addFamilyStructreName6();
    }
    return familyStructreName6;

  }

  /**
   * 年齢6を取得します。
   * @return 年齢6
   */
  public ACTextField getFamilyStructreAge6(){
    if(familyStructreAge6==null){

      familyStructreAge6 = new ACTextField();

      familyStructreAge6.setBindPath("FAMILY_AGE6");

      familyStructreAge6.setColumns(3);

      familyStructreAge6.setCharType(VRCharType.ONLY_DIGIT);

      familyStructreAge6.setHorizontalAlignment(SwingConstants.RIGHT);

      familyStructreAge6.setIMEMode(InputSubset.LATIN);

      familyStructreAge6.setMaxLength(3);

      addFamilyStructreAge6();
    }
    return familyStructreAge6;

  }

  /**
   * 続柄6を取得します。
   * @return 続柄6
   */
  public ACTextField getFamilyStructreRelation6(){
    if(familyStructreRelation6==null){

      familyStructreRelation6 = new ACTextField();

      familyStructreRelation6.setBindPath("FAMILY_RELATION6");

      familyStructreRelation6.setColumns(6);

      familyStructreRelation6.setIMEMode(InputSubset.KANJI);

      familyStructreRelation6.setMaxLength(6);

      addFamilyStructreRelation6();
    }
    return familyStructreRelation6;

  }

  /**
   * 職業6を取得します。
   * @return 職業6
   */
  public ACTextField getFamilyStructreJob6(){
    if(familyStructreJob6==null){

      familyStructreJob6 = new ACTextField();

      familyStructreJob6.setBindPath("FAMILY_JOB6");

      familyStructreJob6.setColumns(10);

      familyStructreJob6.setIMEMode(InputSubset.KANJI);

      familyStructreJob6.setMaxLength(12);

      addFamilyStructreJob6();
    }
    return familyStructreJob6;

  }

  /**
   * 特記すべき事項6を取得します。
   * @return 特記すべき事項6
   */
  public ACTextField getFamilyStructreComment6(){
    if(familyStructreComment6==null){

      familyStructreComment6 = new ACTextField();

      familyStructreComment6.setBindPath("FAMILY_COMMENT6");

      familyStructreComment6.setColumns(26);

      familyStructreComment6.setIMEMode(InputSubset.KANJI);

      familyStructreComment6.setMaxLength(30);

      addFamilyStructreComment6();
    }
    return familyStructreComment6;

  }

  /**
   * NO.1 主な介護者・住環境を取得します。
   * @return NO.1 主な介護者・住環境
   */
  public ACPanel getPoints4(){
    if(points4==null){

      points4 = new ACPanel();

      addPoints4();
    }
    return points4;

  }

  /**
   * 主な介護者・グループを取得します。
   * @return 主な介護者・グループ
   */
  public ACGroupBox getMainCaares(){
    if(mainCaares==null){

      mainCaares = new ACGroupBox();

      mainCaares.setText("主な介護者(37x3)");

      mainCaares.setAutoWrap(false);

      mainCaares.setHgap(0);

      mainCaares.setLabelMargin(0);

      addMainCaares();
    }
    return mainCaares;

  }

  /**
   * 主な介護者を取得します。
   * @return 主な介護者
   */
  public ACTextArea getMainCare(){
    if(mainCare==null){

      mainCare = new ACTextArea();

      mainCare.setBindPath("CAREGIVER");

      mainCare.setColumns(74);

      mainCare.setRows(4);

      mainCare.setMaxRows(3);

      mainCare.setIMEMode(InputSubset.KANJI);

      mainCare.setMaxLength(111);

      mainCare.setLineWrap(true);

      addMainCare();
    }
    return mainCare;

  }

  /**
   * 主な介護者コンテナを取得します。
   * @return 主な介護者コンテナ
   */
  protected ACLabelContainer getMainCareContainer(){
    if(mainCareContainer==null){
      mainCareContainer = new ACLabelContainer();
      mainCareContainer.setFollowChildEnabled(true);
      mainCareContainer.setVAlignment(VRLayout.CENTER);
      mainCareContainer.add(getMainCare(), null);
    }
    return mainCareContainer;
  }

  /**
   * 住環境・グループを取得します。
   * @return 住環境・グループ
   */
  public ACGroupBox getJyukankyos(){
    if(jyukankyos==null){

      jyukankyos = new ACGroupBox();

      jyukankyos.setText("住環境(37x4)");

      jyukankyos.setAutoWrap(false);

      jyukankyos.setHgap(0);

      jyukankyos.setLabelMargin(0);

      addJyukankyos();
    }
    return jyukankyos;

  }

  /**
   * 住環境を取得します。
   * @return 住環境
   */
  public ACTextArea getJyukankyo(){
    if(jyukankyo==null){

      jyukankyo = new ACTextArea();

      jyukankyo.setBindPath("HOUSE");

      jyukankyo.setColumns(74);

      jyukankyo.setRows(5);

      jyukankyo.setMaxRows(4);

      jyukankyo.setIMEMode(InputSubset.KANJI);

      jyukankyo.setMaxLength(148);

      jyukankyo.setLineWrap(true);

      addJyukankyo();
    }
    return jyukankyo;

  }

  /**
   * 住環境コンテナを取得します。
   * @return 住環境コンテナ
   */
  protected ACLabelContainer getJyukankyoContainer(){
    if(jyukankyoContainer==null){
      jyukankyoContainer = new ACLabelContainer();
      jyukankyoContainer.setFollowChildEnabled(true);
      jyukankyoContainer.setVAlignment(VRLayout.CENTER);
      jyukankyoContainer.add(getJyukankyo(), null);
    }
    return jyukankyoContainer;
  }

  /**
   * NO.2 依頼目的を取得します。
   * @return NO.2 依頼目的
   */
  public ACPanel getPoints5(){
    if(points5==null){

      points5 = new ACPanel();

      addPoints5();
    }
    return points5;

  }

  /**
   * 利用者・家族の依頼目的領域・グループを取得します。
   * @return 利用者・家族の依頼目的領域・グループ
   */
  public ACGroupBox getPatientAndFamilyRequests(){
    if(patientAndFamilyRequests==null){

      patientAndFamilyRequests = new ACGroupBox();

      patientAndFamilyRequests.setText("利用者・家族の依頼目的(37x6)");

      patientAndFamilyRequests.setAutoWrap(false);

      patientAndFamilyRequests.setHgap(0);

      patientAndFamilyRequests.setLabelMargin(0);

      addPatientAndFamilyRequests();
    }
    return patientAndFamilyRequests;

  }

  /**
   * 利用者・家族の依頼目的を取得します。
   * @return 利用者・家族の依頼目的
   */
  public ACTextArea getPatientAndFamilyRequest(){
    if(patientAndFamilyRequest==null){

      patientAndFamilyRequest = new ACTextArea();

      patientAndFamilyRequest.setBindPath("PURPOSE");

      patientAndFamilyRequest.setColumns(74);

      patientAndFamilyRequest.setRows(7);

      patientAndFamilyRequest.setMaxRows(6);

      patientAndFamilyRequest.setIMEMode(InputSubset.KANJI);

      patientAndFamilyRequest.setMaxLength(222);

      patientAndFamilyRequest.setLineWrap(true);

      addPatientAndFamilyRequest();
    }
    return patientAndFamilyRequest;

  }

  /**
   * 利用者・家族の依頼目的コンテナを取得します。
   * @return 利用者・家族の依頼目的コンテナ
   */
  protected ACLabelContainer getPatientAndFamilyRequestContainer(){
    if(patientAndFamilyRequestContainer==null){
      patientAndFamilyRequestContainer = new ACLabelContainer();
      patientAndFamilyRequestContainer.setFollowChildEnabled(true);
      patientAndFamilyRequestContainer.setVAlignment(VRLayout.CENTER);
      patientAndFamilyRequestContainer.add(getPatientAndFamilyRequest(), null);
    }
    return patientAndFamilyRequestContainer;
  }

  /**
   * 主治医等領域・グループを取得します。
   * @return 主治医等領域・グループ
   */
  public ACGroupBox getSyujis(){
    if(syujis==null){

      syujis = new ACGroupBox();

      syujis.setText("主治医等");

      syujis.setAutoWrap(false);

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
   * 主治医医療機関を取得します。
   * @return 主治医医療機関
   */
  public ACComboBox getSyujiMedicalName(){
    if(syujiMedicalName==null){

      syujiMedicalName = new ACComboBox();

      getSyujiMedicalNameContainer().setText("医療機関");

      syujiMedicalName.setBindPath("MEDICAL_FACILITY_NAME");

      syujiMedicalName.setColumns(22);

      syujiMedicalName.setModelBindPath("MEDICAL_FACILITY_ID");

      syujiMedicalName.setRenderBindPath("MEDICAL_FACILITY_NAME");

      syujiMedicalName.setIMEMode(InputSubset.KANJI);

      syujiMedicalName.setMaxLength(63);

      syujiMedicalName.setModel(getSyujiMedicalNameModel());

      addSyujiMedicalName();
    }
    return syujiMedicalName;

  }

  /**
   * 主治医医療機関コンテナを取得します。
   * @return 主治医医療機関コンテナ
   */
  protected ACLabelContainer getSyujiMedicalNameContainer(){
    if(syujiMedicalNameContainer==null){
      syujiMedicalNameContainer = new ACLabelContainer();
      syujiMedicalNameContainer.setFollowChildEnabled(true);
      syujiMedicalNameContainer.setVAlignment(VRLayout.CENTER);
      syujiMedicalNameContainer.add(getSyujiMedicalName(), null);
    }
    return syujiMedicalNameContainer;
  }

  /**
   * 主治医医療機関モデルを取得します。
   * @return 主治医医療機関モデル
   */
  protected ACComboBoxModelAdapter getSyujiMedicalNameModel(){
    if(syujiMedicalNameModel==null){
      syujiMedicalNameModel = new ACComboBoxModelAdapter();
      addSyujiMedicalNameModel();
    }
    return syujiMedicalNameModel;
  }

  /**
   * 主治医所在地を取得します。
   * @return 主治医所在地
   */
  public ACTextArea getSyujiAddress(){
    if(syujiAddress==null){

      syujiAddress = new ACTextArea();

      getSyujiAddressContainer().setText("所在地");

      syujiAddress.setBindPath("MEDICAL_FACILITY_ADDRESS");

      syujiAddress.setColumns(46);

      syujiAddress.setRows(3);

      syujiAddress.setMaxRows(3);

      syujiAddress.setIMEMode(InputSubset.KANJI);

      syujiAddress.setMaxLength(80);

      syujiAddress.setLineWrap(true);

      addSyujiAddress();
    }
    return syujiAddress;

  }

  /**
   * 主治医所在地コンテナを取得します。
   * @return 主治医所在地コンテナ
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
   * 主治医電話番号を取得します。
   * @return 主治医電話番号
   */
  public ACLabelContainer getSuijiTels(){
    if(suijiTels==null){

      suijiTels = new ACLabelContainer();

      suijiTels.setText("電話番号");

      addSuijiTels();
    }
    return suijiTels;

  }

  /**
   * 主治医電話番号1を取得します。
   * @return 主治医電話番号1
   */
  public ACTextField getSyujiTel1(){
    if(syujiTel1==null){

      syujiTel1 = new ACTextField();

      syujiTel1.setBindPath("MEDICAL_FACILITY_TEL_FIRST");

      syujiTel1.setColumns(4);

      syujiTel1.setCharType(VRCharType.ONLY_DIGIT);

      syujiTel1.setIMEMode(InputSubset.LATIN);

      syujiTel1.setMaxLength(6);

      addSyujiTel1();
    }
    return syujiTel1;

  }

  /**
   * 主治医電話番号ラベル1を取得します。
   * @return 主治医電話番号ラベル1
   */
  public ACLabel getSyujiLabel1(){
    if(syujiLabel1==null){

      syujiLabel1 = new ACLabel();

      syujiLabel1.setText("-");

      addSyujiLabel1();
    }
    return syujiLabel1;

  }

  /**
   * 主治医電話番号2を取得します。
   * @return 主治医電話番号2
   */
  public ACTextField getSyujiTel2(){
    if(syujiTel2==null){

      syujiTel2 = new ACTextField();

      syujiTel2.setBindPath("MEDICAL_FACILITY_TEL_SECOND");

      syujiTel2.setColumns(4);

      syujiTel2.setCharType(VRCharType.ONLY_DIGIT);

      syujiTel2.setIMEMode(InputSubset.LATIN);

      syujiTel2.setMaxLength(4);

      addSyujiTel2();
    }
    return syujiTel2;

  }

  /**
   * 主治医電話番号ラベル2を取得します。
   * @return 主治医電話番号ラベル2
   */
  public ACLabel getSyujiLabel2(){
    if(syujiLabel2==null){

      syujiLabel2 = new ACLabel();

      syujiLabel2.setText("-");

      addSyujiLabel2();
    }
    return syujiLabel2;

  }

  /**
   * 主治医電話番号3を取得します。
   * @return 主治医電話番号3
   */
  public ACTextField getSyujiTel3(){
    if(syujiTel3==null){

      syujiTel3 = new ACTextField();

      syujiTel3.setBindPath("MEDICAL_FACILITY_TEL_THIRD");

      syujiTel3.setColumns(4);

      syujiTel3.setCharType(VRCharType.ONLY_DIGIT);

      syujiTel3.setIMEMode(InputSubset.LATIN);

      syujiTel3.setMaxLength(4);

      addSyujiTel3();
    }
    return syujiTel3;

  }

  /**
   * NO.2 ADLを取得します。
   * @return NO.2 ADL
   */
  public ACPanel getPoints6(){
    if(points6==null){

      points6 = new ACPanel();

      addPoints6();
    }
    return points6;

  }

  /**
   * ADLの状況領域・グループを取得します。
   * @return ADLの状況領域・グループ
   */
  public ACGroupBox getRequestObjects(){
    if(RequestObjects==null){

      RequestObjects = new ACGroupBox();

      RequestObjects.setText("ADLの状況");

      RequestObjects.setAutoWrap(false);

      RequestObjects.setVgap(6);

      addRequestObjects();
    }
    return RequestObjects;

  }

  /**
   * 移動を取得します。
   * @return 移動
   */
  public ACClearableRadioButtonGroup getRequestObjectMove(){
    if(RequestObjectMove==null){

      RequestObjectMove = new ACClearableRadioButtonGroup();

      getRequestObjectMoveContainer().setText("移動");

      RequestObjectMove.setBindPath("ADL_MOVE");

      RequestObjectMove.setNoSelectIndex(0);

      RequestObjectMove.setUseClearButton(true);

      RequestObjectMove.setModel(getRequestObjectMoveModel());

      addRequestObjectMove();
    }
    return RequestObjectMove;

  }

  /**
   * 移動コンテナを取得します。
   * @return 移動コンテナ
   */
  protected ACLabelContainer getRequestObjectMoveContainer(){
    if(RequestObjectMoveContainer==null){
      RequestObjectMoveContainer = new ACLabelContainer();
      RequestObjectMoveContainer.setFollowChildEnabled(true);
      RequestObjectMoveContainer.setVAlignment(VRLayout.CENTER);
      RequestObjectMoveContainer.add(getRequestObjectMove(), null);
    }
    return RequestObjectMoveContainer;
  }

  /**
   * 移動モデルを取得します。
   * @return 移動モデル
   */
  protected ACListModelAdapter getRequestObjectMoveModel(){
    if(RequestObjectMoveModel==null){
      RequestObjectMoveModel = new ACListModelAdapter();
      addRequestObjectMoveModel();
    }
    return RequestObjectMoveModel;
  }

  /**
   * 自立を取得します。
   * @return 自立
   */
  public ACRadioButtonItem getRequestObjectMoveRadioItem1(){
    if(RequestObjectMoveRadioItem1==null){

      RequestObjectMoveRadioItem1 = new ACRadioButtonItem();

      RequestObjectMoveRadioItem1.setText("自立");

      RequestObjectMoveRadioItem1.setGroup(getRequestObjectMove());

      addRequestObjectMoveRadioItem1();
    }
    return RequestObjectMoveRadioItem1;

  }

  /**
   * 一部介助を取得します。
   * @return 一部介助
   */
  public ACRadioButtonItem getRequestObjectMoveRadioItem2(){
    if(RequestObjectMoveRadioItem2==null){

      RequestObjectMoveRadioItem2 = new ACRadioButtonItem();

      RequestObjectMoveRadioItem2.setText("一部介助");

      RequestObjectMoveRadioItem2.setGroup(getRequestObjectMove());

      addRequestObjectMoveRadioItem2();
    }
    return RequestObjectMoveRadioItem2;

  }

  /**
   * 全面介助を取得します。
   * @return 全面介助
   */
  public ACRadioButtonItem getRequestObjectMoveRadioItem3(){
    if(RequestObjectMoveRadioItem3==null){

      RequestObjectMoveRadioItem3 = new ACRadioButtonItem();

      RequestObjectMoveRadioItem3.setText("全面介助");

      RequestObjectMoveRadioItem3.setGroup(getRequestObjectMove());

      addRequestObjectMoveRadioItem3();
    }
    return RequestObjectMoveRadioItem3;

  }

  /**
   * その他を取得します。
   * @return その他
   */
  public ACRadioButtonItem getRequestObjectMoveRadioItem4(){
    if(RequestObjectMoveRadioItem4==null){

      RequestObjectMoveRadioItem4 = new ACRadioButtonItem();

      RequestObjectMoveRadioItem4.setText("その他");

      RequestObjectMoveRadioItem4.setGroup(getRequestObjectMove());

      addRequestObjectMoveRadioItem4();
    }
    return RequestObjectMoveRadioItem4;

  }

  /**
   * 食事を取得します。
   * @return 食事
   */
  public ACClearableRadioButtonGroup getRequestObjectDinner(){
    if(RequestObjectDinner==null){

      RequestObjectDinner = new ACClearableRadioButtonGroup();

      getRequestObjectDinnerContainer().setText("食事");

      RequestObjectDinner.setBindPath("ADL_FOOD");

      RequestObjectDinner.setNoSelectIndex(0);

      RequestObjectDinner.setUseClearButton(true);

      RequestObjectDinner.setModel(getRequestObjectDinnerModel());

      addRequestObjectDinner();
    }
    return RequestObjectDinner;

  }

  /**
   * 食事コンテナを取得します。
   * @return 食事コンテナ
   */
  protected ACLabelContainer getRequestObjectDinnerContainer(){
    if(RequestObjectDinnerContainer==null){
      RequestObjectDinnerContainer = new ACLabelContainer();
      RequestObjectDinnerContainer.setFollowChildEnabled(true);
      RequestObjectDinnerContainer.setVAlignment(VRLayout.CENTER);
      RequestObjectDinnerContainer.add(getRequestObjectDinner(), null);
    }
    return RequestObjectDinnerContainer;
  }

  /**
   * 食事モデルを取得します。
   * @return 食事モデル
   */
  protected ACListModelAdapter getRequestObjectDinnerModel(){
    if(RequestObjectDinnerModel==null){
      RequestObjectDinnerModel = new ACListModelAdapter();
      addRequestObjectDinnerModel();
    }
    return RequestObjectDinnerModel;
  }

  /**
   * 自立を取得します。
   * @return 自立
   */
  public ACRadioButtonItem getRequestObjectDinnerRadioItem1(){
    if(RequestObjectDinnerRadioItem1==null){

      RequestObjectDinnerRadioItem1 = new ACRadioButtonItem();

      RequestObjectDinnerRadioItem1.setText("自立");

      RequestObjectDinnerRadioItem1.setGroup(getRequestObjectDinner());

      addRequestObjectDinnerRadioItem1();
    }
    return RequestObjectDinnerRadioItem1;

  }

  /**
   * 一部介助を取得します。
   * @return 一部介助
   */
  public ACRadioButtonItem getRequestObjectDinnerRadioItem2(){
    if(RequestObjectDinnerRadioItem2==null){

      RequestObjectDinnerRadioItem2 = new ACRadioButtonItem();

      RequestObjectDinnerRadioItem2.setText("一部介助");

      RequestObjectDinnerRadioItem2.setGroup(getRequestObjectDinner());

      addRequestObjectDinnerRadioItem2();
    }
    return RequestObjectDinnerRadioItem2;

  }

  /**
   * 全面介助を取得します。
   * @return 全面介助
   */
  public ACRadioButtonItem getRequestObjectDinnerRadioItem3(){
    if(RequestObjectDinnerRadioItem3==null){

      RequestObjectDinnerRadioItem3 = new ACRadioButtonItem();

      RequestObjectDinnerRadioItem3.setText("全面介助");

      RequestObjectDinnerRadioItem3.setGroup(getRequestObjectDinner());

      addRequestObjectDinnerRadioItem3();
    }
    return RequestObjectDinnerRadioItem3;

  }

  /**
   * その他を取得します。
   * @return その他
   */
  public ACRadioButtonItem getRequestObjectDinnerRadioItem4(){
    if(RequestObjectDinnerRadioItem4==null){

      RequestObjectDinnerRadioItem4 = new ACRadioButtonItem();

      RequestObjectDinnerRadioItem4.setText("その他");

      RequestObjectDinnerRadioItem4.setGroup(getRequestObjectDinner());

      addRequestObjectDinnerRadioItem4();
    }
    return RequestObjectDinnerRadioItem4;

  }

  /**
   * 排泄を取得します。
   * @return 排泄
   */
  public ACClearableRadioButtonGroup getRequestObjectExcrete(){
    if(RequestObjectExcrete==null){

      RequestObjectExcrete = new ACClearableRadioButtonGroup();

      getRequestObjectExcreteContainer().setText("排泄");

      RequestObjectExcrete.setBindPath("ADL_EXCRETION");

      RequestObjectExcrete.setNoSelectIndex(0);

      RequestObjectExcrete.setUseClearButton(true);

      RequestObjectExcrete.setModel(getRequestObjectExcreteModel());

      addRequestObjectExcrete();
    }
    return RequestObjectExcrete;

  }

  /**
   * 排泄コンテナを取得します。
   * @return 排泄コンテナ
   */
  protected ACLabelContainer getRequestObjectExcreteContainer(){
    if(RequestObjectExcreteContainer==null){
      RequestObjectExcreteContainer = new ACLabelContainer();
      RequestObjectExcreteContainer.setFollowChildEnabled(true);
      RequestObjectExcreteContainer.setVAlignment(VRLayout.CENTER);
      RequestObjectExcreteContainer.add(getRequestObjectExcrete(), null);
    }
    return RequestObjectExcreteContainer;
  }

  /**
   * 排泄モデルを取得します。
   * @return 排泄モデル
   */
  protected ACListModelAdapter getRequestObjectExcreteModel(){
    if(RequestObjectExcreteModel==null){
      RequestObjectExcreteModel = new ACListModelAdapter();
      addRequestObjectExcreteModel();
    }
    return RequestObjectExcreteModel;
  }

  /**
   * 自立を取得します。
   * @return 自立
   */
  public ACRadioButtonItem getRequestObjectExcreteRadioItem1(){
    if(RequestObjectExcreteRadioItem1==null){

      RequestObjectExcreteRadioItem1 = new ACRadioButtonItem();

      RequestObjectExcreteRadioItem1.setText("自立");

      RequestObjectExcreteRadioItem1.setGroup(getRequestObjectExcrete());

      addRequestObjectExcreteRadioItem1();
    }
    return RequestObjectExcreteRadioItem1;

  }

  /**
   * 一部介助を取得します。
   * @return 一部介助
   */
  public ACRadioButtonItem getRequestObjectExcreteRadioItem2(){
    if(RequestObjectExcreteRadioItem2==null){

      RequestObjectExcreteRadioItem2 = new ACRadioButtonItem();

      RequestObjectExcreteRadioItem2.setText("一部介助");

      RequestObjectExcreteRadioItem2.setGroup(getRequestObjectExcrete());

      addRequestObjectExcreteRadioItem2();
    }
    return RequestObjectExcreteRadioItem2;

  }

  /**
   * 全面介助を取得します。
   * @return 全面介助
   */
  public ACRadioButtonItem getRequestObjectExcreteRadioItem3(){
    if(RequestObjectExcreteRadioItem3==null){

      RequestObjectExcreteRadioItem3 = new ACRadioButtonItem();

      RequestObjectExcreteRadioItem3.setText("全面介助");

      RequestObjectExcreteRadioItem3.setGroup(getRequestObjectExcrete());

      addRequestObjectExcreteRadioItem3();
    }
    return RequestObjectExcreteRadioItem3;

  }

  /**
   * その他を取得します。
   * @return その他
   */
  public ACRadioButtonItem getRequestObjectExcreteRadioItem4(){
    if(RequestObjectExcreteRadioItem4==null){

      RequestObjectExcreteRadioItem4 = new ACRadioButtonItem();

      RequestObjectExcreteRadioItem4.setText("その他");

      RequestObjectExcreteRadioItem4.setGroup(getRequestObjectExcrete());

      addRequestObjectExcreteRadioItem4();
    }
    return RequestObjectExcreteRadioItem4;

  }

  /**
   * 入浴を取得します。
   * @return 入浴
   */
  public ACClearableRadioButtonGroup getRequestObjectBath(){
    if(RequestObjectBath==null){

      RequestObjectBath = new ACClearableRadioButtonGroup();

      getRequestObjectBathContainer().setText("入浴");

      RequestObjectBath.setBindPath("ADL_BATH");

      RequestObjectBath.setNoSelectIndex(0);

      RequestObjectBath.setUseClearButton(true);

      RequestObjectBath.setModel(getRequestObjectBathModel());

      addRequestObjectBath();
    }
    return RequestObjectBath;

  }

  /**
   * 入浴コンテナを取得します。
   * @return 入浴コンテナ
   */
  protected ACLabelContainer getRequestObjectBathContainer(){
    if(RequestObjectBathContainer==null){
      RequestObjectBathContainer = new ACLabelContainer();
      RequestObjectBathContainer.setFollowChildEnabled(true);
      RequestObjectBathContainer.setVAlignment(VRLayout.CENTER);
      RequestObjectBathContainer.add(getRequestObjectBath(), null);
    }
    return RequestObjectBathContainer;
  }

  /**
   * 入浴モデルを取得します。
   * @return 入浴モデル
   */
  protected ACListModelAdapter getRequestObjectBathModel(){
    if(RequestObjectBathModel==null){
      RequestObjectBathModel = new ACListModelAdapter();
      addRequestObjectBathModel();
    }
    return RequestObjectBathModel;
  }

  /**
   * 自立を取得します。
   * @return 自立
   */
  public ACRadioButtonItem getRequestObjectBathRadioItem1(){
    if(RequestObjectBathRadioItem1==null){

      RequestObjectBathRadioItem1 = new ACRadioButtonItem();

      RequestObjectBathRadioItem1.setText("自立");

      RequestObjectBathRadioItem1.setGroup(getRequestObjectBath());

      addRequestObjectBathRadioItem1();
    }
    return RequestObjectBathRadioItem1;

  }

  /**
   * 一部介助を取得します。
   * @return 一部介助
   */
  public ACRadioButtonItem getRequestObjectBathRadioItem2(){
    if(RequestObjectBathRadioItem2==null){

      RequestObjectBathRadioItem2 = new ACRadioButtonItem();

      RequestObjectBathRadioItem2.setText("一部介助");

      RequestObjectBathRadioItem2.setGroup(getRequestObjectBath());

      addRequestObjectBathRadioItem2();
    }
    return RequestObjectBathRadioItem2;

  }

  /**
   * 全面介助を取得します。
   * @return 全面介助
   */
  public ACRadioButtonItem getRequestObjectBathRadioItem3(){
    if(RequestObjectBathRadioItem3==null){

      RequestObjectBathRadioItem3 = new ACRadioButtonItem();

      RequestObjectBathRadioItem3.setText("全面介助");

      RequestObjectBathRadioItem3.setGroup(getRequestObjectBath());

      addRequestObjectBathRadioItem3();
    }
    return RequestObjectBathRadioItem3;

  }

  /**
   * その他を取得します。
   * @return その他
   */
  public ACRadioButtonItem getRequestObjectBathRadioItem4(){
    if(RequestObjectBathRadioItem4==null){

      RequestObjectBathRadioItem4 = new ACRadioButtonItem();

      RequestObjectBathRadioItem4.setText("その他");

      RequestObjectBathRadioItem4.setGroup(getRequestObjectBath());

      addRequestObjectBathRadioItem4();
    }
    return RequestObjectBathRadioItem4;

  }

  /**
   * 着替を取得します。
   * @return 着替
   */
  public ACClearableRadioButtonGroup getRequestObjectChangeClothes(){
    if(RequestObjectChangeClothes==null){

      RequestObjectChangeClothes = new ACClearableRadioButtonGroup();

      getRequestObjectChangeClothesContainer().setText("着替");

      RequestObjectChangeClothes.setBindPath("ADL_CHANGE_CLOTH");

      RequestObjectChangeClothes.setNoSelectIndex(0);

      RequestObjectChangeClothes.setUseClearButton(true);

      RequestObjectChangeClothes.setModel(getRequestObjectChangeClothesModel());

      addRequestObjectChangeClothes();
    }
    return RequestObjectChangeClothes;

  }

  /**
   * 着替コンテナを取得します。
   * @return 着替コンテナ
   */
  protected ACLabelContainer getRequestObjectChangeClothesContainer(){
    if(RequestObjectChangeClothesContainer==null){
      RequestObjectChangeClothesContainer = new ACLabelContainer();
      RequestObjectChangeClothesContainer.setFollowChildEnabled(true);
      RequestObjectChangeClothesContainer.setVAlignment(VRLayout.CENTER);
      RequestObjectChangeClothesContainer.add(getRequestObjectChangeClothes(), null);
    }
    return RequestObjectChangeClothesContainer;
  }

  /**
   * 着替モデルを取得します。
   * @return 着替モデル
   */
  protected ACListModelAdapter getRequestObjectChangeClothesModel(){
    if(RequestObjectChangeClothesModel==null){
      RequestObjectChangeClothesModel = new ACListModelAdapter();
      addRequestObjectChangeClothesModel();
    }
    return RequestObjectChangeClothesModel;
  }

  /**
   * 自立を取得します。
   * @return 自立
   */
  public ACRadioButtonItem getRequestObjectChangeClothesRadioItem1(){
    if(RequestObjectChangeClothesRadioItem1==null){

      RequestObjectChangeClothesRadioItem1 = new ACRadioButtonItem();

      RequestObjectChangeClothesRadioItem1.setText("自立");

      RequestObjectChangeClothesRadioItem1.setGroup(getRequestObjectChangeClothes());

      addRequestObjectChangeClothesRadioItem1();
    }
    return RequestObjectChangeClothesRadioItem1;

  }

  /**
   * 一部介助を取得します。
   * @return 一部介助
   */
  public ACRadioButtonItem getRequestObjectChangeClothesRadioItem2(){
    if(RequestObjectChangeClothesRadioItem2==null){

      RequestObjectChangeClothesRadioItem2 = new ACRadioButtonItem();

      RequestObjectChangeClothesRadioItem2.setText("一部介助");

      RequestObjectChangeClothesRadioItem2.setGroup(getRequestObjectChangeClothes());

      addRequestObjectChangeClothesRadioItem2();
    }
    return RequestObjectChangeClothesRadioItem2;

  }

  /**
   * 全面介助を取得します。
   * @return 全面介助
   */
  public ACRadioButtonItem getRequestObjectChangeClothesRadioItem3(){
    if(RequestObjectChangeClothesRadioItem3==null){

      RequestObjectChangeClothesRadioItem3 = new ACRadioButtonItem();

      RequestObjectChangeClothesRadioItem3.setText("全面介助");

      RequestObjectChangeClothesRadioItem3.setGroup(getRequestObjectChangeClothes());

      addRequestObjectChangeClothesRadioItem3();
    }
    return RequestObjectChangeClothesRadioItem3;

  }

  /**
   * その他を取得します。
   * @return その他
   */
  public ACRadioButtonItem getRequestObjectChangeClothesRadioItem4(){
    if(RequestObjectChangeClothesRadioItem4==null){

      RequestObjectChangeClothesRadioItem4 = new ACRadioButtonItem();

      RequestObjectChangeClothesRadioItem4.setText("その他");

      RequestObjectChangeClothesRadioItem4.setGroup(getRequestObjectChangeClothes());

      addRequestObjectChangeClothesRadioItem4();
    }
    return RequestObjectChangeClothesRadioItem4;

  }

  /**
   * 整容を取得します。
   * @return 整容
   */
  public ACClearableRadioButtonGroup getRequestObjectSeiyo(){
    if(RequestObjectSeiyo==null){

      RequestObjectSeiyo = new ACClearableRadioButtonGroup();

      getRequestObjectSeiyoContainer().setText("整容");

      RequestObjectSeiyo.setBindPath("ADL_COSMETIC");

      RequestObjectSeiyo.setNoSelectIndex(0);

      RequestObjectSeiyo.setUseClearButton(true);

      RequestObjectSeiyo.setModel(getRequestObjectSeiyoModel());

      addRequestObjectSeiyo();
    }
    return RequestObjectSeiyo;

  }

  /**
   * 整容コンテナを取得します。
   * @return 整容コンテナ
   */
  protected ACLabelContainer getRequestObjectSeiyoContainer(){
    if(RequestObjectSeiyoContainer==null){
      RequestObjectSeiyoContainer = new ACLabelContainer();
      RequestObjectSeiyoContainer.setFollowChildEnabled(true);
      RequestObjectSeiyoContainer.setVAlignment(VRLayout.CENTER);
      RequestObjectSeiyoContainer.add(getRequestObjectSeiyo(), null);
    }
    return RequestObjectSeiyoContainer;
  }

  /**
   * 整容モデルを取得します。
   * @return 整容モデル
   */
  protected ACListModelAdapter getRequestObjectSeiyoModel(){
    if(RequestObjectSeiyoModel==null){
      RequestObjectSeiyoModel = new ACListModelAdapter();
      addRequestObjectSeiyoModel();
    }
    return RequestObjectSeiyoModel;
  }

  /**
   * 自立を取得します。
   * @return 自立
   */
  public ACRadioButtonItem getRequestObjectSeiyoRadioItem1(){
    if(RequestObjectSeiyoRadioItem1==null){

      RequestObjectSeiyoRadioItem1 = new ACRadioButtonItem();

      RequestObjectSeiyoRadioItem1.setText("自立");

      RequestObjectSeiyoRadioItem1.setGroup(getRequestObjectSeiyo());

      addRequestObjectSeiyoRadioItem1();
    }
    return RequestObjectSeiyoRadioItem1;

  }

  /**
   * 一部介助を取得します。
   * @return 一部介助
   */
  public ACRadioButtonItem getRequestObjectSeiyoRadioItem2(){
    if(RequestObjectSeiyoRadioItem2==null){

      RequestObjectSeiyoRadioItem2 = new ACRadioButtonItem();

      RequestObjectSeiyoRadioItem2.setText("一部介助");

      RequestObjectSeiyoRadioItem2.setGroup(getRequestObjectSeiyo());

      addRequestObjectSeiyoRadioItem2();
    }
    return RequestObjectSeiyoRadioItem2;

  }

  /**
   * 全面介助を取得します。
   * @return 全面介助
   */
  public ACRadioButtonItem getRequestObjectSeiyoRadioItem3(){
    if(RequestObjectSeiyoRadioItem3==null){

      RequestObjectSeiyoRadioItem3 = new ACRadioButtonItem();

      RequestObjectSeiyoRadioItem3.setText("全面介助");

      RequestObjectSeiyoRadioItem3.setGroup(getRequestObjectSeiyo());

      addRequestObjectSeiyoRadioItem3();
    }
    return RequestObjectSeiyoRadioItem3;

  }

  /**
   * その他を取得します。
   * @return その他
   */
  public ACRadioButtonItem getRequestObjectSeiyoRadioItem4(){
    if(RequestObjectSeiyoRadioItem4==null){

      RequestObjectSeiyoRadioItem4 = new ACRadioButtonItem();

      RequestObjectSeiyoRadioItem4.setText("その他");

      RequestObjectSeiyoRadioItem4.setGroup(getRequestObjectSeiyo());

      addRequestObjectSeiyoRadioItem4();
    }
    return RequestObjectSeiyoRadioItem4;

  }

  /**
   * 意思疎通を取得します。
   * @return 意思疎通
   */
  public ACClearableRadioButtonGroup getRequestObjectIsisotu(){
    if(RequestObjectIsisotu==null){

      RequestObjectIsisotu = new ACClearableRadioButtonGroup();

      getRequestObjectIsisotuContainer().setText("意思疎通");

      RequestObjectIsisotu.setBindPath("ADL_COMMUNICATION");

      RequestObjectIsisotu.setNoSelectIndex(0);

      RequestObjectIsisotu.setUseClearButton(true);

      RequestObjectIsisotu.setModel(getRequestObjectIsisotuModel());

      addRequestObjectIsisotu();
    }
    return RequestObjectIsisotu;

  }

  /**
   * 意思疎通コンテナを取得します。
   * @return 意思疎通コンテナ
   */
  protected ACLabelContainer getRequestObjectIsisotuContainer(){
    if(RequestObjectIsisotuContainer==null){
      RequestObjectIsisotuContainer = new ACLabelContainer();
      RequestObjectIsisotuContainer.setFollowChildEnabled(true);
      RequestObjectIsisotuContainer.setVAlignment(VRLayout.CENTER);
      RequestObjectIsisotuContainer.add(getRequestObjectIsisotu(), null);
    }
    return RequestObjectIsisotuContainer;
  }

  /**
   * 意思疎通モデルを取得します。
   * @return 意思疎通モデル
   */
  protected ACListModelAdapter getRequestObjectIsisotuModel(){
    if(RequestObjectIsisotuModel==null){
      RequestObjectIsisotuModel = new ACListModelAdapter();
      addRequestObjectIsisotuModel();
    }
    return RequestObjectIsisotuModel;
  }

  /**
   * 自立を取得します。
   * @return 自立
   */
  public ACRadioButtonItem getRequestObjectIsisotuRadioItem1(){
    if(RequestObjectIsisotuRadioItem1==null){

      RequestObjectIsisotuRadioItem1 = new ACRadioButtonItem();

      RequestObjectIsisotuRadioItem1.setText("自立");

      RequestObjectIsisotuRadioItem1.setGroup(getRequestObjectIsisotu());

      addRequestObjectIsisotuRadioItem1();
    }
    return RequestObjectIsisotuRadioItem1;

  }

  /**
   * 一部介助を取得します。
   * @return 一部介助
   */
  public ACRadioButtonItem getRequestObjectIsisotuRadioItem2(){
    if(RequestObjectIsisotuRadioItem2==null){

      RequestObjectIsisotuRadioItem2 = new ACRadioButtonItem();

      RequestObjectIsisotuRadioItem2.setText("一部介助");

      RequestObjectIsisotuRadioItem2.setGroup(getRequestObjectIsisotu());

      addRequestObjectIsisotuRadioItem2();
    }
    return RequestObjectIsisotuRadioItem2;

  }

  /**
   * 全面介助を取得します。
   * @return 全面介助
   */
  public ACRadioButtonItem getRequestObjectIsisotuRadioItem3(){
    if(RequestObjectIsisotuRadioItem3==null){

      RequestObjectIsisotuRadioItem3 = new ACRadioButtonItem();

      RequestObjectIsisotuRadioItem3.setText("全面介助");

      RequestObjectIsisotuRadioItem3.setGroup(getRequestObjectIsisotu());

      addRequestObjectIsisotuRadioItem3();
    }
    return RequestObjectIsisotuRadioItem3;

  }

  /**
   * その他を取得します。
   * @return その他
   */
  public ACRadioButtonItem getRequestObjectIsisotuRadioItem4(){
    if(RequestObjectIsisotuRadioItem4==null){

      RequestObjectIsisotuRadioItem4 = new ACRadioButtonItem();

      RequestObjectIsisotuRadioItem4.setText("その他");

      RequestObjectIsisotuRadioItem4.setGroup(getRequestObjectIsisotu());

      addRequestObjectIsisotuRadioItem4();
    }
    return RequestObjectIsisotuRadioItem4;

  }

  /**
   * 緊急時の連絡方法領域・グループを取得します。
   * @return 緊急時の連絡方法領域・グループ
   */
  public ACGroupBox getEmergencyContacts(){
    if(emergencyContacts==null){

      emergencyContacts = new ACGroupBox();

      emergencyContacts.setText("緊急時の連絡方法(46x8)");

      emergencyContacts.setAutoWrap(false);

      emergencyContacts.setHgap(0);

      emergencyContacts.setLabelMargin(0);

      addEmergencyContacts();
    }
    return emergencyContacts;

  }

  /**
   * 緊急時の連絡方法領域を取得します。
   * @return 緊急時の連絡方法領域
   */
  public ACTextArea getEmergencyContact(){
    if(emergencyContact==null){

      emergencyContact = new ACTextArea();

      emergencyContact.setBindPath("DOCTOR_RENRAKUSAKI");

      emergencyContact.setColumns(92);

      emergencyContact.setRows(9);

      emergencyContact.setMaxRows(8);

      emergencyContact.setIMEMode(InputSubset.KANJI);

      emergencyContact.setMaxLength(368);

      emergencyContact.setLineWrap(true);

      addEmergencyContact();
    }
    return emergencyContact;

  }

  /**
   * 緊急時の連絡方法領域コンテナを取得します。
   * @return 緊急時の連絡方法領域コンテナ
   */
  protected ACLabelContainer getEmergencyContactContainer(){
    if(emergencyContactContainer==null){
      emergencyContactContainer = new ACLabelContainer();
      emergencyContactContainer.setFollowChildEnabled(true);
      emergencyContactContainer.setVAlignment(VRLayout.CENTER);
      emergencyContactContainer.add(getEmergencyContact(), null);
    }
    return emergencyContactContainer;
  }

  /**
   * 関係機関・利用状況領域を取得します。
   * @return 関係機関・利用状況領域
   */
  public ACPanel getPoints7(){
    if(points7==null){

      points7 = new ACPanel();

      addPoints7();
    }
    return points7;

  }

  /**
   * 関係機関領域・グループを取得します。
   * @return 関係機関領域・グループ
   */
  public ACGroupBox getKankeikikans(){
    if(kankeikikans==null){

      kankeikikans = new ACGroupBox();

      kankeikikans.setText("関係機関");

      kankeikikans.setLayout(getKankeikikanLayout());

      addKankeikikans();
    }
    return kankeikikans;

  }

  /**
   * 関係機関領域・レイアウトを取得します。
   * @return 関係機関領域・レイアウト
   */
  public GridBagLayout getKankeikikanLayout(){
    if(kankeikikanLayout==null){

      kankeikikanLayout = new GridBagLayout();

      addKankeikikanLayout();
    }
    return kankeikikanLayout;

  }

  /**
   * 連絡先(ヘッダを取得します。
   * @return 連絡先(ヘッダ
   */
  public ACLabel getContactAddressHeader(){
    if(contactAddressHeader==null){

      contactAddressHeader = new ACLabel();

      contactAddressHeader.setText("連絡先");

      addContactAddressHeader();
    }
    return contactAddressHeader;

  }

  /**
   * 担当者(ヘッダを取得します。
   * @return 担当者(ヘッダ
   */
  public ACLabel getChargeHeader(){
    if(chargeHeader==null){

      chargeHeader = new ACLabel();

      chargeHeader.setText("担当者");

      addChargeHeader();
    }
    return chargeHeader;

  }

  /**
   * 備考(ヘッダを取得します。
   * @return 備考(ヘッダ
   */
  public ACLabel getRemarkHeader(){
    if(remarkHeader==null){

      remarkHeader = new ACLabel();

      remarkHeader.setText("備考");

      addRemarkHeader();
    }
    return remarkHeader;

  }

  /**
   * 連絡先1を取得します。
   * @return 連絡先1
   */
  public ACTextField getContact1(){
    if(contact1==null){

      contact1 = new ACTextField();

      contact1.setBindPath("MEDICAL_RENRAKUSAKI1");

      contact1.setColumns(15);

      contact1.setIMEMode(InputSubset.KANJI);

      contact1.setMaxLength(20);

      addContact1();
    }
    return contact1;

  }

  /**
   * 担当者1を取得します。
   * @return 担当者1
   */
  public ACTextField getCharge1(){
    if(charge1==null){

      charge1 = new ACTextField();

      charge1.setBindPath("MEDICAL_PREPARED1");

      charge1.setColumns(12);

      charge1.setIMEMode(InputSubset.KANJI);

      charge1.setMaxLength(12);

      addCharge1();
    }
    return charge1;

  }

  /**
   * 備考1を取得します。
   * @return 備考1
   */
  public ACTextField getRemark1(){
    if(remark1==null){

      remark1 = new ACTextField();

      remark1.setBindPath("MEDICAL_NOTE1");

      remark1.setColumns(38);

      remark1.setIMEMode(InputSubset.KANJI);

      remark1.setMaxLength(38);

      addRemark1();
    }
    return remark1;

  }

  /**
   * 連絡先2を取得します。
   * @return 連絡先2
   */
  public ACTextField getContact2(){
    if(contact2==null){

      contact2 = new ACTextField();

      contact2.setBindPath("MEDICAL_RENRAKUSAKI2");

      contact2.setColumns(15);

      contact2.setIMEMode(InputSubset.KANJI);

      contact2.setMaxLength(20);

      addContact2();
    }
    return contact2;

  }

  /**
   * 担当者2を取得します。
   * @return 担当者2
   */
  public ACTextField getCharge2(){
    if(charge2==null){

      charge2 = new ACTextField();

      charge2.setBindPath("MEDICAL_PREPARED2");

      charge2.setColumns(12);

      charge2.setIMEMode(InputSubset.KANJI);

      charge2.setMaxLength(12);

      addCharge2();
    }
    return charge2;

  }

  /**
   * 備考2を取得します。
   * @return 備考2
   */
  public ACTextField getRemark2(){
    if(remark2==null){

      remark2 = new ACTextField();

      remark2.setBindPath("MEDICAL_NOTE2");

      remark2.setColumns(38);

      remark2.setIMEMode(InputSubset.KANJI);

      remark2.setMaxLength(38);

      addRemark2();
    }
    return remark2;

  }

  /**
   * 連絡先3を取得します。
   * @return 連絡先3
   */
  public ACTextField getContact3(){
    if(contact3==null){

      contact3 = new ACTextField();

      contact3.setBindPath("MEDICAL_RENRAKUSAKI3");

      contact3.setColumns(15);

      contact3.setIMEMode(InputSubset.KANJI);

      contact3.setMaxLength(20);

      addContact3();
    }
    return contact3;

  }

  /**
   * 担当者3を取得します。
   * @return 担当者3
   */
  public ACTextField getCharge3(){
    if(charge3==null){

      charge3 = new ACTextField();

      charge3.setBindPath("MEDICAL_PREPARED3");

      charge3.setColumns(12);

      charge3.setIMEMode(InputSubset.KANJI);

      charge3.setMaxLength(12);

      addCharge3();
    }
    return charge3;

  }

  /**
   * 備考3を取得します。
   * @return 備考3
   */
  public ACTextField getRemark3(){
    if(remark3==null){

      remark3 = new ACTextField();

      remark3.setBindPath("MEDICAL_NOTE3");

      remark3.setColumns(38);

      remark3.setIMEMode(InputSubset.KANJI);

      remark3.setMaxLength(38);

      addRemark3();
    }
    return remark3;

  }

  /**
   * 連絡先4を取得します。
   * @return 連絡先4
   */
  public ACTextField getContact4(){
    if(contact4==null){

      contact4 = new ACTextField();

      contact4.setBindPath("MEDICAL_RENRAKUSAKI4");

      contact4.setColumns(15);

      contact4.setIMEMode(InputSubset.KANJI);

      contact4.setMaxLength(20);

      addContact4();
    }
    return contact4;

  }

  /**
   * 担当者4を取得します。
   * @return 担当者4
   */
  public ACTextField getCharge4(){
    if(charge4==null){

      charge4 = new ACTextField();

      charge4.setBindPath("MEDICAL_PREPARED4");

      charge4.setColumns(12);

      charge4.setIMEMode(InputSubset.KANJI);

      charge4.setMaxLength(12);

      addCharge4();
    }
    return charge4;

  }

  /**
   * 備考4を取得します。
   * @return 備考4
   */
  public ACTextField getRemark4(){
    if(remark4==null){

      remark4 = new ACTextField();

      remark4.setBindPath("MEDICAL_NOTE4");

      remark4.setColumns(38);

      remark4.setIMEMode(InputSubset.KANJI);

      remark4.setMaxLength(38);

      addRemark4();
    }
    return remark4;

  }

  /**
   * 保健・福祉サービス等の利用状況・グループを取得します。
   * @return 保健・福祉サービス等の利用状況・グループ
   */
  public ACGroupBox getHokenfukusis(){
    if(hokenfukusis==null){

      hokenfukusis = new ACGroupBox();

      hokenfukusis.setText("保健・福祉サービス等の利用状況(46x6)");

      hokenfukusis.setAutoWrap(false);

      hokenfukusis.setHgap(0);

      hokenfukusis.setLabelMargin(0);

      addHokenfukusis();
    }
    return hokenfukusis;

  }

  /**
   * 保健･福祉サービス等の利用状況を取得します。
   * @return 保健･福祉サービス等の利用状況
   */
  public ACTextArea getHokenfukusi(){
    if(hokenfukusi==null){

      hokenfukusi = new ACTextArea();

      hokenfukusi.setBindPath("USED_STATE");

      hokenfukusi.setColumns(92);

      hokenfukusi.setRows(7);

      hokenfukusi.setMaxRows(6);

      hokenfukusi.setIMEMode(InputSubset.KANJI);

      hokenfukusi.setMaxLength(276);

      hokenfukusi.setLineWrap(true);

      addHokenfukusi();
    }
    return hokenfukusi;

  }

  /**
   * 保健･福祉サービス等の利用状況コンテナを取得します。
   * @return 保健･福祉サービス等の利用状況コンテナ
   */
  protected ACLabelContainer getHokenfukusiContainer(){
    if(hokenfukusiContainer==null){
      hokenfukusiContainer = new ACLabelContainer();
      hokenfukusiContainer.setFollowChildEnabled(true);
      hokenfukusiContainer.setVAlignment(VRLayout.CENTER);
      hokenfukusiContainer.add(getHokenfukusi(), null);
    }
    return hokenfukusiContainer;
  }

  /**
   * コンストラクタです。
   */
  public QC004Design() {

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
   * 保存に内部項目を追加します。
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

    contents.add(getPatients(), VRLayout.NORTH);

    contents.add(getNurses(), VRLayout.NORTH);

    contents.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * 患者領域に内部項目を追加します。
   */
  protected void addPatients(){

    patients.add(getPatient(), VRLayout.CLIENT);

  }

  /**
   * 患者領域・グループに内部項目を追加します。
   */
  protected void addPatient(){

    patient.add(getPatientNameContainer(), VRLayout.FLOW_INSETLINE);

    patient.add(getPatientSexContainer(), VRLayout.FLOW);

    patient.add(getPatientBirths(), VRLayout.FLOW_INSETLINE_RETURN);

    patient.add(getPatientAddressContainer(), VRLayout.FLOW_INSETLINE);

    patient.add(getPatientTels(), VRLayout.FLOW);

  }

  /**
   * 患者氏名に内部項目を追加します。
   */
  protected void addPatientName(){

  }

  /**
   * 患者性別に内部項目を追加します。
   */
  protected void addPatientSex(){

  }

  /**
   * 患者生年月日・コンテナに内部項目を追加します。
   */
  protected void addPatientBirths(){

    patientBirths.add(getPatientBirth(), VRLayout.FLOW);

    patientBirths.add(getPatientAge(), VRLayout.FLOW);

    patientBirths.add(getPatientAgeLabel(), VRLayout.FLOW);

  }

  /**
   * 患者生年月日に内部項目を追加します。
   */
  protected void addPatientBirth(){

  }

  /**
   * 患者年齢に内部項目を追加します。
   */
  protected void addPatientAge(){

  }

  /**
   * 歳ラベルに内部項目を追加します。
   */
  protected void addPatientAgeLabel(){

  }

  /**
   * 患者住所に内部項目を追加します。
   */
  protected void addPatientAddress(){

  }

  /**
   * 患者電話番号に内部項目を追加します。
   */
  protected void addPatientTels(){

    patientTels.add(getPatientTel1(), VRLayout.FLOW);

    patientTels.add(getPatientLabel1(), VRLayout.FLOW);

    patientTels.add(getPatientTel2(), VRLayout.FLOW);

    patientTels.add(getPatientLabel2(), VRLayout.FLOW);

    patientTels.add(getPatientTel3(), VRLayout.FLOW);

  }

  /**
   * 患者電話番号1に内部項目を追加します。
   */
  protected void addPatientTel1(){

  }

  /**
   * 患者電話番号ラベル1に内部項目を追加します。
   */
  protected void addPatientLabel1(){

  }

  /**
   * 患者電話番号2に内部項目を追加します。
   */
  protected void addPatientTel2(){

  }

  /**
   * 患者電話番号ラベル1に内部項目を追加します。
   */
  protected void addPatientLabel2(){

  }

  /**
   * 患者電話番号3に内部項目を追加します。
   */
  protected void addPatientTel3(){

  }

  /**
   * 看護師領域に内部項目を追加します。
   */
  protected void addNurses(){

    nurses.add(getNurse(), VRLayout.CLIENT);

  }

  /**
   * 看護師領域・グループに内部項目を追加します。
   */
  protected void addNurse(){

    nurse.add(getNurseNameContainer(), VRLayout.FLOW_RETURN);

    nurse.add(getFirstVisitDates(), VRLayout.FLOW);

  }

  /**
   * 看護師氏名に内部項目を追加します。
   */
  protected void addNurseName(){

  }

  /**
   * 看護師初回訪問年月日に内部項目を追加します。
   */
  protected void addFirstVisitDates(){

    firstVisitDates.add(getFirstVisitDateStart(), VRLayout.FLOW);

    firstVisitDates.add(getFirstVisitDateTimeLabel(), VRLayout.FLOW);

    firstVisitDates.add(getFirstVisitDateStartHour(), VRLayout.FLOW);

    firstVisitDates.add(getFirstVisitDateLabel(), VRLayout.FLOW);

    firstVisitDates.add(getFirstVisitDateEndHour(), VRLayout.FLOW);

  }

  /**
   * 看護師初回訪問年月日(開始時間）に内部項目を追加します。
   */
  protected void addFirstVisitDateStart(){

  }

  /**
   * 看護師初回訪問年月日・時刻に内部項目を追加します。
   */
  protected void addFirstVisitDateTimeLabel(){

  }

  /**
   * 看護師初回訪問年月日(時に内部項目を追加します。
   */
  protected void addFirstVisitDateStartHour(){

  }

  /**
   * 看護師初回訪問年月日・ラベルに内部項目を追加します。
   */
  protected void addFirstVisitDateLabel(){

  }

  /**
   * 看護師初回訪問年月日(終了時間）に内部項目を追加します。
   */
  protected void addFirstVisitDateEndHour(){

  }

  /**
   * タブに内部項目を追加します。
   */
  protected void addTabs(){

    tabs.addTab("NO.1 傷病名・病状", getPoints1());

    tabs.addTab("NO.1 現病歴・既往歴", getPoints2());

    tabs.addTab("NO.1 生活歴", getPoints3());

    tabs.addTab("NO.1 主な介護者・住環境", getPoints4());

    tabs.addTab("NO.2 依頼目的", getPoints5());

    tabs.addTab("NO.2 ADL", getPoints6());

    tabs.addTab("関係機関・利用状況", getPoints7());

  }

  /**
   * NO.1 傷病名・病状・歴領域に内部項目を追加します。
   */
  protected void addPoints1(){

    points1.add(getMainDiseases(), VRLayout.FLOW_RETURN);

    points1.add(getDiseaseConditionAndTreatments(), VRLayout.FLOW_RETURN);

  }

  /**
   * 主たる傷病名・グループに内部項目を追加します。
   */
  protected void addMainDiseases(){

    mainDiseases.add(getMainDiseaseContainer(), VRLayout.FLOW);

  }

  /**
   * 主な傷病名に内部項目を追加します。
   */
  protected void addMainDisease(){

  }

  /**
   * 病状・治療状態等・グループに内部項目を追加します。
   */
  protected void addDiseaseConditionAndTreatments(){

    diseaseConditionAndTreatments.add(getDiseaseConditionAndTreatmentContainer(), VRLayout.FLOW);

  }

  /**
   * 病状･治療状態等に内部項目を追加します。
   */
  protected void addDiseaseConditionAndTreatment(){

  }

  /**
   * NO.1 現病歴・既往歴・生活歴に内部項目を追加します。
   */
  protected void addPoints2(){

    points2.add(getGenbyorekis(), VRLayout.FLOW_RETURN);

    points2.add(getExistingAddressHistorys(), VRLayout.FLOW);

  }

  /**
   * 現病歴・グループに内部項目を追加します。
   */
  protected void addGenbyorekis(){

    genbyorekis.add(getGenbyorekiContainer(), VRLayout.FLOW);

  }

  /**
   * 現病歴に内部項目を追加します。
   */
  protected void addGenbyoreki(){

  }

  /**
   * 既往歴・グループに内部項目を追加します。
   */
  protected void addExistingAddressHistorys(){

    existingAddressHistorys.add(getExistingAddressHistoryContainer(), VRLayout.FLOW);

  }

  /**
   * 既往歴に内部項目を追加します。
   */
  protected void addExistingAddressHistory(){

  }

  /**
   * NO.1 生活歴に内部項目を追加します。
   */
  protected void addPoints3(){

    points3.add(getLifeHistorys(), VRLayout.FLOW);

    points3.add(getFamilyStructureas(), VRLayout.FLOW_RETURN);

  }

  /**
   * 生活歴・グループに内部項目を追加します。
   */
  protected void addLifeHistorys(){

    lifeHistorys.add(getLifeHistoryContainer(), VRLayout.FLOW);

  }

  /**
   * 生活歴に内部項目を追加します。
   */
  protected void addLifeHistory(){

  }

  /**
   * 家族構成・グループに内部項目を追加します。
   */
  protected void addFamilyStructureas(){

    familyStructureas.add(getFamilyStructreNameHeader(), new GridBagConstraints(0, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreAgeHeader(), new GridBagConstraints(1, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreRelationHeader(), new GridBagConstraints(2, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreJobHeader(), new GridBagConstraints(3, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreCommentHeader(), new GridBagConstraints(4, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreName1(), new GridBagConstraints(0, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreAge1(), new GridBagConstraints(1, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreRelation1(), new GridBagConstraints(2, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreJob1(), new GridBagConstraints(3, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreComment1(), new GridBagConstraints(4, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreName2(), new GridBagConstraints(0, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreAge2(), new GridBagConstraints(1, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreRelation2(), new GridBagConstraints(2, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreJob2(), new GridBagConstraints(3, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreComment2(), new GridBagConstraints(4, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreName3(), new GridBagConstraints(0, 3, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreAge3(), new GridBagConstraints(1, 3, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreRelation3(), new GridBagConstraints(2, 3, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreJob3(), new GridBagConstraints(3, 3, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreComment3(), new GridBagConstraints(4, 3, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreName4(), new GridBagConstraints(0, 4, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreAge4(), new GridBagConstraints(1, 4, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreRelation4(), new GridBagConstraints(2, 4, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreJob4(), new GridBagConstraints(3, 4, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreComment4(), new GridBagConstraints(4, 4, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreName5(), new GridBagConstraints(0, 5, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreAge5(), new GridBagConstraints(1, 5, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreRelation5(), new GridBagConstraints(2, 5, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreJob5(), new GridBagConstraints(3, 5, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreComment5(), new GridBagConstraints(4, 5, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreName6(), new GridBagConstraints(0, 6, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreAge6(), new GridBagConstraints(1, 6, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreRelation6(), new GridBagConstraints(2, 6, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreJob6(), new GridBagConstraints(3, 6, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    familyStructureas.add(getFamilyStructreComment6(), new GridBagConstraints(4, 6, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

  }

  /**
   * 家族構成・レイアウトに内部項目を追加します。
   */
  protected void addFamilyStructre(){

  }

  /**
   * 氏名(ヘッダに内部項目を追加します。
   */
  protected void addFamilyStructreNameHeader(){

  }

  /**
   * 年齢(ヘッダに内部項目を追加します。
   */
  protected void addFamilyStructreAgeHeader(){

  }

  /**
   * 続柄(ヘッダに内部項目を追加します。
   */
  protected void addFamilyStructreRelationHeader(){

  }

  /**
   * 職業(ヘッダに内部項目を追加します。
   */
  protected void addFamilyStructreJobHeader(){

  }

  /**
   * 特記すべき事項(ヘッダに内部項目を追加します。
   */
  protected void addFamilyStructreCommentHeader(){

  }

  /**
   * 氏名1に内部項目を追加します。
   */
  protected void addFamilyStructreName1(){

  }

  /**
   * 年齢1に内部項目を追加します。
   */
  protected void addFamilyStructreAge1(){

  }

  /**
   * 続柄1に内部項目を追加します。
   */
  protected void addFamilyStructreRelation1(){

  }

  /**
   * 職業1に内部項目を追加します。
   */
  protected void addFamilyStructreJob1(){

  }

  /**
   * 特記すべき事項1に内部項目を追加します。
   */
  protected void addFamilyStructreComment1(){

  }

  /**
   * 氏名2に内部項目を追加します。
   */
  protected void addFamilyStructreName2(){

  }

  /**
   * 年齢2に内部項目を追加します。
   */
  protected void addFamilyStructreAge2(){

  }

  /**
   * 続柄2に内部項目を追加します。
   */
  protected void addFamilyStructreRelation2(){

  }

  /**
   * 職業2に内部項目を追加します。
   */
  protected void addFamilyStructreJob2(){

  }

  /**
   * 特記すべき事項2に内部項目を追加します。
   */
  protected void addFamilyStructreComment2(){

  }

  /**
   * 氏名3に内部項目を追加します。
   */
  protected void addFamilyStructreName3(){

  }

  /**
   * 年齢3に内部項目を追加します。
   */
  protected void addFamilyStructreAge3(){

  }

  /**
   * 続柄3に内部項目を追加します。
   */
  protected void addFamilyStructreRelation3(){

  }

  /**
   * 職業3に内部項目を追加します。
   */
  protected void addFamilyStructreJob3(){

  }

  /**
   * 特記すべき事項3に内部項目を追加します。
   */
  protected void addFamilyStructreComment3(){

  }

  /**
   * 氏名4に内部項目を追加します。
   */
  protected void addFamilyStructreName4(){

  }

  /**
   * 年齢4に内部項目を追加します。
   */
  protected void addFamilyStructreAge4(){

  }

  /**
   * 続柄4に内部項目を追加します。
   */
  protected void addFamilyStructreRelation4(){

  }

  /**
   * 職業4に内部項目を追加します。
   */
  protected void addFamilyStructreJob4(){

  }

  /**
   * 特記すべき事項4に内部項目を追加します。
   */
  protected void addFamilyStructreComment4(){

  }

  /**
   * 氏名5に内部項目を追加します。
   */
  protected void addFamilyStructreName5(){

  }

  /**
   * 年齢5に内部項目を追加します。
   */
  protected void addFamilyStructreAge5(){

  }

  /**
   * 続柄5に内部項目を追加します。
   */
  protected void addFamilyStructreRelation5(){

  }

  /**
   * 職業5に内部項目を追加します。
   */
  protected void addFamilyStructreJob5(){

  }

  /**
   * 特記すべき事項5に内部項目を追加します。
   */
  protected void addFamilyStructreComment5(){

  }

  /**
   * 氏名6に内部項目を追加します。
   */
  protected void addFamilyStructreName6(){

  }

  /**
   * 年齢6に内部項目を追加します。
   */
  protected void addFamilyStructreAge6(){

  }

  /**
   * 続柄6に内部項目を追加します。
   */
  protected void addFamilyStructreRelation6(){

  }

  /**
   * 職業6に内部項目を追加します。
   */
  protected void addFamilyStructreJob6(){

  }

  /**
   * 特記すべき事項6に内部項目を追加します。
   */
  protected void addFamilyStructreComment6(){

  }

  /**
   * NO.1 主な介護者・住環境に内部項目を追加します。
   */
  protected void addPoints4(){

    points4.add(getMainCaares(), VRLayout.FLOW_RETURN);

    points4.add(getJyukankyos(), VRLayout.FLOW);

  }

  /**
   * 主な介護者・グループに内部項目を追加します。
   */
  protected void addMainCaares(){

    mainCaares.add(getMainCareContainer(), VRLayout.FLOW);

  }

  /**
   * 主な介護者に内部項目を追加します。
   */
  protected void addMainCare(){

  }

  /**
   * 住環境・グループに内部項目を追加します。
   */
  protected void addJyukankyos(){

    jyukankyos.add(getJyukankyoContainer(), VRLayout.FLOW);

  }

  /**
   * 住環境に内部項目を追加します。
   */
  protected void addJyukankyo(){

  }

  /**
   * NO.2 依頼目的に内部項目を追加します。
   */
  protected void addPoints5(){

    points5.add(getPatientAndFamilyRequests(), VRLayout.FLOW_RETURN);

    points5.add(getSyujis(), VRLayout.FLOW);

  }

  /**
   * 利用者・家族の依頼目的領域・グループに内部項目を追加します。
   */
  protected void addPatientAndFamilyRequests(){

    patientAndFamilyRequests.add(getPatientAndFamilyRequestContainer(), VRLayout.FLOW);

  }

  /**
   * 利用者・家族の依頼目的に内部項目を追加します。
   */
  protected void addPatientAndFamilyRequest(){

  }

  /**
   * 主治医等領域・グループに内部項目を追加します。
   */
  protected void addSyujis(){

    syujis.add(getSyujiNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    syujis.add(getSyujiMedicalNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    syujis.add(getSyujiAddressContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    syujis.add(getSuijiTels(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 主治医氏名に内部項目を追加します。
   */
  protected void addSyujiName(){

  }

  /**
   * 主治医医療機関に内部項目を追加します。
   */
  protected void addSyujiMedicalName(){

  }

  /**
   * 主治医医療機関モデルに内部項目を追加します。
   */
  protected void addSyujiMedicalNameModel(){

  }

  /**
   * 主治医所在地に内部項目を追加します。
   */
  protected void addSyujiAddress(){

  }

  /**
   * 主治医電話番号に内部項目を追加します。
   */
  protected void addSuijiTels(){

    suijiTels.add(getSyujiTel1(), VRLayout.FLOW);

    suijiTels.add(getSyujiLabel1(), VRLayout.FLOW);

    suijiTels.add(getSyujiTel2(), VRLayout.FLOW);

    suijiTels.add(getSyujiLabel2(), VRLayout.FLOW);

    suijiTels.add(getSyujiTel3(), VRLayout.FLOW);

  }

  /**
   * 主治医電話番号1に内部項目を追加します。
   */
  protected void addSyujiTel1(){

  }

  /**
   * 主治医電話番号ラベル1に内部項目を追加します。
   */
  protected void addSyujiLabel1(){

  }

  /**
   * 主治医電話番号2に内部項目を追加します。
   */
  protected void addSyujiTel2(){

  }

  /**
   * 主治医電話番号ラベル2に内部項目を追加します。
   */
  protected void addSyujiLabel2(){

  }

  /**
   * 主治医電話番号3に内部項目を追加します。
   */
  protected void addSyujiTel3(){

  }

  /**
   * NO.2 ADLに内部項目を追加します。
   */
  protected void addPoints6(){

    points6.add(getRequestObjects(), VRLayout.FLOW_RETURN);

    points6.add(getEmergencyContacts(), VRLayout.FLOW);

  }

  /**
   * ADLの状況領域・グループに内部項目を追加します。
   */
  protected void addRequestObjects(){

    RequestObjects.add(getRequestObjectMoveContainer(), VRLayout.FLOW_INSETLINE);

    RequestObjects.add(getRequestObjectDinnerContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    RequestObjects.add(getRequestObjectExcreteContainer(), VRLayout.FLOW_INSETLINE);

    RequestObjects.add(getRequestObjectBathContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    RequestObjects.add(getRequestObjectChangeClothesContainer(), VRLayout.FLOW_INSETLINE);

    RequestObjects.add(getRequestObjectSeiyoContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    RequestObjects.add(getRequestObjectIsisotuContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 移動に内部項目を追加します。
   */
  protected void addRequestObjectMove(){

  }

  /**
   * 移動モデルに内部項目を追加します。
   */
  protected void addRequestObjectMoveModel(){

    getRequestObjectMoveRadioItem1().setButtonIndex(1);
    getRequestObjectMoveModel().add(getRequestObjectMoveRadioItem1());

    getRequestObjectMoveRadioItem2().setButtonIndex(2);
    getRequestObjectMoveModel().add(getRequestObjectMoveRadioItem2());

    getRequestObjectMoveRadioItem3().setButtonIndex(3);
    getRequestObjectMoveModel().add(getRequestObjectMoveRadioItem3());

    getRequestObjectMoveRadioItem4().setButtonIndex(4);
    getRequestObjectMoveModel().add(getRequestObjectMoveRadioItem4());

  }

  /**
   * 自立に内部項目を追加します。
   */
  protected void addRequestObjectMoveRadioItem1(){

  }

  /**
   * 一部介助に内部項目を追加します。
   */
  protected void addRequestObjectMoveRadioItem2(){

  }

  /**
   * 全面介助に内部項目を追加します。
   */
  protected void addRequestObjectMoveRadioItem3(){

  }

  /**
   * その他に内部項目を追加します。
   */
  protected void addRequestObjectMoveRadioItem4(){

  }

  /**
   * 食事に内部項目を追加します。
   */
  protected void addRequestObjectDinner(){

  }

  /**
   * 食事モデルに内部項目を追加します。
   */
  protected void addRequestObjectDinnerModel(){

    getRequestObjectDinnerRadioItem1().setButtonIndex(1);
    getRequestObjectDinnerModel().add(getRequestObjectDinnerRadioItem1());

    getRequestObjectDinnerRadioItem2().setButtonIndex(2);
    getRequestObjectDinnerModel().add(getRequestObjectDinnerRadioItem2());

    getRequestObjectDinnerRadioItem3().setButtonIndex(3);
    getRequestObjectDinnerModel().add(getRequestObjectDinnerRadioItem3());

    getRequestObjectDinnerRadioItem4().setButtonIndex(4);
    getRequestObjectDinnerModel().add(getRequestObjectDinnerRadioItem4());

  }

  /**
   * 自立に内部項目を追加します。
   */
  protected void addRequestObjectDinnerRadioItem1(){

  }

  /**
   * 一部介助に内部項目を追加します。
   */
  protected void addRequestObjectDinnerRadioItem2(){

  }

  /**
   * 全面介助に内部項目を追加します。
   */
  protected void addRequestObjectDinnerRadioItem3(){

  }

  /**
   * その他に内部項目を追加します。
   */
  protected void addRequestObjectDinnerRadioItem4(){

  }

  /**
   * 排泄に内部項目を追加します。
   */
  protected void addRequestObjectExcrete(){

  }

  /**
   * 排泄モデルに内部項目を追加します。
   */
  protected void addRequestObjectExcreteModel(){

    getRequestObjectExcreteRadioItem1().setButtonIndex(1);
    getRequestObjectExcreteModel().add(getRequestObjectExcreteRadioItem1());

    getRequestObjectExcreteRadioItem2().setButtonIndex(2);
    getRequestObjectExcreteModel().add(getRequestObjectExcreteRadioItem2());

    getRequestObjectExcreteRadioItem3().setButtonIndex(3);
    getRequestObjectExcreteModel().add(getRequestObjectExcreteRadioItem3());

    getRequestObjectExcreteRadioItem4().setButtonIndex(4);
    getRequestObjectExcreteModel().add(getRequestObjectExcreteRadioItem4());

  }

  /**
   * 自立に内部項目を追加します。
   */
  protected void addRequestObjectExcreteRadioItem1(){

  }

  /**
   * 一部介助に内部項目を追加します。
   */
  protected void addRequestObjectExcreteRadioItem2(){

  }

  /**
   * 全面介助に内部項目を追加します。
   */
  protected void addRequestObjectExcreteRadioItem3(){

  }

  /**
   * その他に内部項目を追加します。
   */
  protected void addRequestObjectExcreteRadioItem4(){

  }

  /**
   * 入浴に内部項目を追加します。
   */
  protected void addRequestObjectBath(){

  }

  /**
   * 入浴モデルに内部項目を追加します。
   */
  protected void addRequestObjectBathModel(){

    getRequestObjectBathRadioItem1().setButtonIndex(1);
    getRequestObjectBathModel().add(getRequestObjectBathRadioItem1());

    getRequestObjectBathRadioItem2().setButtonIndex(2);
    getRequestObjectBathModel().add(getRequestObjectBathRadioItem2());

    getRequestObjectBathRadioItem3().setButtonIndex(3);
    getRequestObjectBathModel().add(getRequestObjectBathRadioItem3());

    getRequestObjectBathRadioItem4().setButtonIndex(4);
    getRequestObjectBathModel().add(getRequestObjectBathRadioItem4());

  }

  /**
   * 自立に内部項目を追加します。
   */
  protected void addRequestObjectBathRadioItem1(){

  }

  /**
   * 一部介助に内部項目を追加します。
   */
  protected void addRequestObjectBathRadioItem2(){

  }

  /**
   * 全面介助に内部項目を追加します。
   */
  protected void addRequestObjectBathRadioItem3(){

  }

  /**
   * その他に内部項目を追加します。
   */
  protected void addRequestObjectBathRadioItem4(){

  }

  /**
   * 着替に内部項目を追加します。
   */
  protected void addRequestObjectChangeClothes(){

  }

  /**
   * 着替モデルに内部項目を追加します。
   */
  protected void addRequestObjectChangeClothesModel(){

    getRequestObjectChangeClothesRadioItem1().setButtonIndex(1);
    getRequestObjectChangeClothesModel().add(getRequestObjectChangeClothesRadioItem1());

    getRequestObjectChangeClothesRadioItem2().setButtonIndex(2);
    getRequestObjectChangeClothesModel().add(getRequestObjectChangeClothesRadioItem2());

    getRequestObjectChangeClothesRadioItem3().setButtonIndex(3);
    getRequestObjectChangeClothesModel().add(getRequestObjectChangeClothesRadioItem3());

    getRequestObjectChangeClothesRadioItem4().setButtonIndex(4);
    getRequestObjectChangeClothesModel().add(getRequestObjectChangeClothesRadioItem4());

  }

  /**
   * 自立に内部項目を追加します。
   */
  protected void addRequestObjectChangeClothesRadioItem1(){

  }

  /**
   * 一部介助に内部項目を追加します。
   */
  protected void addRequestObjectChangeClothesRadioItem2(){

  }

  /**
   * 全面介助に内部項目を追加します。
   */
  protected void addRequestObjectChangeClothesRadioItem3(){

  }

  /**
   * その他に内部項目を追加します。
   */
  protected void addRequestObjectChangeClothesRadioItem4(){

  }

  /**
   * 整容に内部項目を追加します。
   */
  protected void addRequestObjectSeiyo(){

  }

  /**
   * 整容モデルに内部項目を追加します。
   */
  protected void addRequestObjectSeiyoModel(){

    getRequestObjectSeiyoRadioItem1().setButtonIndex(1);
    getRequestObjectSeiyoModel().add(getRequestObjectSeiyoRadioItem1());

    getRequestObjectSeiyoRadioItem2().setButtonIndex(2);
    getRequestObjectSeiyoModel().add(getRequestObjectSeiyoRadioItem2());

    getRequestObjectSeiyoRadioItem3().setButtonIndex(3);
    getRequestObjectSeiyoModel().add(getRequestObjectSeiyoRadioItem3());

    getRequestObjectSeiyoRadioItem4().setButtonIndex(4);
    getRequestObjectSeiyoModel().add(getRequestObjectSeiyoRadioItem4());

  }

  /**
   * 自立に内部項目を追加します。
   */
  protected void addRequestObjectSeiyoRadioItem1(){

  }

  /**
   * 一部介助に内部項目を追加します。
   */
  protected void addRequestObjectSeiyoRadioItem2(){

  }

  /**
   * 全面介助に内部項目を追加します。
   */
  protected void addRequestObjectSeiyoRadioItem3(){

  }

  /**
   * その他に内部項目を追加します。
   */
  protected void addRequestObjectSeiyoRadioItem4(){

  }

  /**
   * 意思疎通に内部項目を追加します。
   */
  protected void addRequestObjectIsisotu(){

  }

  /**
   * 意思疎通モデルに内部項目を追加します。
   */
  protected void addRequestObjectIsisotuModel(){

    getRequestObjectIsisotuRadioItem1().setButtonIndex(1);
    getRequestObjectIsisotuModel().add(getRequestObjectIsisotuRadioItem1());

    getRequestObjectIsisotuRadioItem2().setButtonIndex(2);
    getRequestObjectIsisotuModel().add(getRequestObjectIsisotuRadioItem2());

    getRequestObjectIsisotuRadioItem3().setButtonIndex(3);
    getRequestObjectIsisotuModel().add(getRequestObjectIsisotuRadioItem3());

    getRequestObjectIsisotuRadioItem4().setButtonIndex(4);
    getRequestObjectIsisotuModel().add(getRequestObjectIsisotuRadioItem4());

  }

  /**
   * 自立に内部項目を追加します。
   */
  protected void addRequestObjectIsisotuRadioItem1(){

  }

  /**
   * 一部介助に内部項目を追加します。
   */
  protected void addRequestObjectIsisotuRadioItem2(){

  }

  /**
   * 全面介助に内部項目を追加します。
   */
  protected void addRequestObjectIsisotuRadioItem3(){

  }

  /**
   * その他に内部項目を追加します。
   */
  protected void addRequestObjectIsisotuRadioItem4(){

  }

  /**
   * 緊急時の連絡方法領域・グループに内部項目を追加します。
   */
  protected void addEmergencyContacts(){

    emergencyContacts.add(getEmergencyContactContainer(), VRLayout.FLOW);

  }

  /**
   * 緊急時の連絡方法領域に内部項目を追加します。
   */
  protected void addEmergencyContact(){

  }

  /**
   * 関係機関・利用状況領域に内部項目を追加します。
   */
  protected void addPoints7(){

    points7.add(getKankeikikans(), VRLayout.FLOW_RETURN);

    points7.add(getHokenfukusis(), VRLayout.FLOW);

  }

  /**
   * 関係機関領域・グループに内部項目を追加します。
   */
  protected void addKankeikikans(){

    kankeikikans.add(getContactAddressHeader(), new GridBagConstraints(0, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    kankeikikans.add(getChargeHeader(), new GridBagConstraints(1, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 1));

    kankeikikans.add(getRemarkHeader(), new GridBagConstraints(2, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 2));

    kankeikikans.add(getContact1(), new GridBagConstraints(0, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    kankeikikans.add(getCharge1(), new GridBagConstraints(1, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 1));

    kankeikikans.add(getRemark1(), new GridBagConstraints(2, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 2));

    kankeikikans.add(getContact2(), new GridBagConstraints(0, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    kankeikikans.add(getCharge2(), new GridBagConstraints(1, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 1));

    kankeikikans.add(getRemark2(), new GridBagConstraints(2, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 2));

    kankeikikans.add(getContact3(), new GridBagConstraints(0, 3, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    kankeikikans.add(getCharge3(), new GridBagConstraints(1, 3, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 1));

    kankeikikans.add(getRemark3(), new GridBagConstraints(2, 3, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 2));

    kankeikikans.add(getContact4(), new GridBagConstraints(0, 4, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    kankeikikans.add(getCharge4(), new GridBagConstraints(1, 4, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 1));

    kankeikikans.add(getRemark4(), new GridBagConstraints(2, 4, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 2));

  }

  /**
   * 関係機関領域・レイアウトに内部項目を追加します。
   */
  protected void addKankeikikanLayout(){

  }

  /**
   * 連絡先(ヘッダに内部項目を追加します。
   */
  protected void addContactAddressHeader(){

  }

  /**
   * 担当者(ヘッダに内部項目を追加します。
   */
  protected void addChargeHeader(){

  }

  /**
   * 備考(ヘッダに内部項目を追加します。
   */
  protected void addRemarkHeader(){

  }

  /**
   * 連絡先1に内部項目を追加します。
   */
  protected void addContact1(){

  }

  /**
   * 担当者1に内部項目を追加します。
   */
  protected void addCharge1(){

  }

  /**
   * 備考1に内部項目を追加します。
   */
  protected void addRemark1(){

  }

  /**
   * 連絡先2に内部項目を追加します。
   */
  protected void addContact2(){

  }

  /**
   * 担当者2に内部項目を追加します。
   */
  protected void addCharge2(){

  }

  /**
   * 備考2に内部項目を追加します。
   */
  protected void addRemark2(){

  }

  /**
   * 連絡先3に内部項目を追加します。
   */
  protected void addContact3(){

  }

  /**
   * 担当者3に内部項目を追加します。
   */
  protected void addCharge3(){

  }

  /**
   * 備考3に内部項目を追加します。
   */
  protected void addRemark3(){

  }

  /**
   * 連絡先4に内部項目を追加します。
   */
  protected void addContact4(){

  }

  /**
   * 担当者4に内部項目を追加します。
   */
  protected void addCharge4(){

  }

  /**
   * 備考4に内部項目を追加します。
   */
  protected void addRemark4(){

  }

  /**
   * 保健・福祉サービス等の利用状況・グループに内部項目を追加します。
   */
  protected void addHokenfukusis(){

    hokenfukusis.add(getHokenfukusiContainer(), VRLayout.FLOW);

  }

  /**
   * 保健･福祉サービス等の利用状況に内部項目を追加します。
   */
  protected void addHokenfukusi(){

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

    return getNurseName();

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    try {
      ACFrame.setVRLookAndFeel();
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QC004Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QC004Design getThis() {
    return this;
  }
}
