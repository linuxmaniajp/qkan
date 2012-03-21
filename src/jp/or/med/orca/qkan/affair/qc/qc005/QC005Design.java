
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
 * 作成日: 2009/08/27  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 帳票管理 (C)
 * プロセス 居宅療養管理指導書 (005)
 * プログラム 居宅療養管理指導書 (QC005)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qc.qc005;
import java.awt.Color;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACAffairButton;
import jp.nichicom.ac.component.ACAffairButtonBar;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACClearableRadioButtonGroup;
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
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanAffairContainer;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.component.QkanDateTextField;
import jp.or.med.orca.qkan.component.QkanYearDateTextField;
/**
 * 居宅療養管理指導書画面項目デザイン(QC005) 
 */
public class QC005Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton open;

  private ACAffairButton insert;

  private ACAffairButton update;

  private ACAffairButton print;

  private ACPanel contents;

  private ACPanel targetDates;

  private ACLabel targetDateCaption;

  private ACLabel targetDateLabel;

  private ACGroupBox patients;

  private ACPanel patients1;

  private ACTextField patientName;

  private ACLabelContainer patientNameContainer;

  private ACTextField patientSex;

  private ACLabelContainer patientSexContainer;

  private QkanDateTextField patientBirth;

  private ACLabelContainer patientBirthContainer;

  private ACValueArrayRadioButtonGroup jotaiCode;

  private ACLabelContainer jotaiCodeContainer;

  private ACListModelAdapter jotaiCodeModel;

  private ACRadioButtonItem yokaigodoRadioItem1;

  private ACRadioButtonItem yokaigodoRadioItem8;

  private ACRadioButtonItem yokaigodoRadioItem9;

  private ACRadioButtonItem yokaigodoRadioItem2;

  private ACRadioButtonItem yokaigodoRadioItem3;

  private ACRadioButtonItem yokaigodoRadioItem4;

  private ACRadioButtonItem yokaigodoRadioItem5;

  private ACRadioButtonItem yokaigodoRadioItem6;

  private ACRadioButtonItem yokaigodoRadioItem7;

  private ACPanel patients2;

  private ACClearableRadioButtonGroup shogaiJiritsudo;

  private ACLabelContainer shogaiJiritsudoContainer;

  private ACListModelAdapter shogaiJiritsudoModel;

  private ACRadioButtonItem shogaiJiritsudoRadioItem1;

  private ACRadioButtonItem shogaiJiritsudoRadioItem2;

  private ACRadioButtonItem shogaiJiritsudoRadioItem3;

  private ACRadioButtonItem shogaiJiritsudoRadioItem4;

  private ACRadioButtonItem shogaiJiritsudoRadioItem5;

  private ACClearableRadioButtonGroup ninchishoJiritsudo;

  private ACLabelContainer ninchishoJiritsudoContainer;

  private ACListModelAdapter ninchishoJiritsudoModel;

  private ACRadioButtonItem ninchishoJiritsudoRadioItem1;

  private ACRadioButtonItem ninchishoJiritsudoRadioItem2;

  private ACRadioButtonItem ninchishoJiritsudoRadioItem3;

  private ACRadioButtonItem ninchishoJiritsudoRadioItem4;

  private ACRadioButtonItem ninchishoJiritsudoRadioItem5;

  private ACRadioButtonItem ninchishoJiritsudoRadioItem6;

  private ACTextArea patientAddress;

  private ACLabelContainer patientAddressContainer;

  private ACLabelContainer patientTelContena;

  private ACTextField patientTel2;

  private ACLabel patientTel3;

  private ACTextField patientTel4;

  private ACLabel patientTel5;

  private ACTextField patientTel6;

  private JTabbedPane tabsArea;

  private ACPanel providerAndMedicaiInfoArea;

  private ACGroupBox medicalInfoGroup;

  private ACComboBox medicalInstitusion;

  private ACLabelContainer medicalInstitusionContainer;

  private ACComboBoxModelAdapter medicalInstitusionModel;

  private ACTextField medicalAddress;

  private ACLabelContainer medicalAddressContainer;

  private ACLabelContainer medicalTelContena;

  private ACTextField medicalTel2;

  private ACLabel medicalTel3;

  private ACTextField medicalTel4;

  private ACLabel medicalTel5;

  private ACTextField medicalTel6;

  private ACTextField doctorName;

  private ACLabelContainer doctorNameContainer;

  private ACPanel points;

  private ACPanel points1;

  private ACLabel yourDoctorCaption1;

  private ACLabel yourDoctor;

  private ACLabel yourDoctorCaption2;

  private QkanYearDateTextField createDateZaitaku;

  private ACLabelContainer createDateZaitakuContainer;

  private ACLabelContainer visitThisMonthContainer;

  private ACTextField visitThisMonth1;

  private ACTextField visitThisMonth2;

  private ACTextField visitThisMonth3;

  private ACTextField visitThisMonth4;

  private ACTextField visitThisMonth5;

  private ACTextField visitThisMonth6;

  private ACLabel visitThisMonthCaption;

  private ACButton resultReadButton;

  private ACLabelContainer visitNextMonthContainer;

  private ACTextField visitNextMonth1;

  private ACTextField visitNextMonth2;

  private ACTextField visitNextMonth3;

  private ACTextField visitNextMonth4;

  private ACTextField visitNextMonth5;

  private ACTextField visitNextMonth6;

  private ACLabel visitNextMonthCaption;

  private ACLabelContainer adviceContainer;

  private VRLayout adviceContainerLayout;

  private ACPanel advices;

  private ACPanel advicdHeaders;

  private ACTextField adviceMonth;

  private ACLabel adviceMonthCaption;

  private ACLabel adviceLength;

  private ACTextArea advice;

  private ACPanel points2;

  private JTabbedPane kyotakuPoints;

  private ACPanel kyotakuPointsPanel1;

  private ACGroupBox providerInfoGroup;

  private QkanDateTextField createDateKyotaku;

  private ACLabelContainer createDateKyotakuContainer;

  private ACComboBox senmonin;

  private ACLabelContainer senmoninContainer;

  private ACComboBoxModelAdapter senmoninModel;

  private ACComboBox providerName;

  private ACLabelContainer providerNameContainer;

  private ACComboBoxModelAdapter providerNameModel;

  private ACGroupBox byojoGroup;

  private ACPanel byojoPanel;

  private ACTextArea byojo;

  private ACLabelContainer byojoContainer;

  private ACGroupBox byojiKeikaGroup;

  private ACPanel byojoKeikaPanel;

  private ACTextArea byojoKeika;

  private ACLabelContainer byojoKeikaContainer;

  private ACPanel kyotakuPointsPane2;

  private ACGroupBox kaigoServiceUseCheckGroup;

  private ACPanel kaigoServicePanel;

  private ACTextArea kaigoServiceUseCheck;

  private ACLabelContainer kaigoServiceUseCheckContainer;

  private ACGroupBox ryuitenGroup;

  private ACPanel ryuitenPanel;

  private ACTextArea ryuiten;

  private ACLabelContainer ryuitenContainer;

  private ACPanel kyotakuPointsPane3;

  private ACGroupBox bikouGroup;

  private ACPanel bikouPanel;

  private ACTextArea bikou;

  private ACLabelContainer bikouContainer;

  //getter

  /**
   * ボタンバーを取得します。
   * @return ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("居宅療養管理指導書");

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

      print.setToolTipText("「居宅療養管理指導書」を印刷します。");

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
  public ACLabel getTargetDateLabel(){
    if(targetDateLabel==null){

      targetDateLabel = new ACLabel();

      targetDateLabel.setBindPath("TARGET_DATE");

      targetDateLabel.setForeground(Color.blue);

      addTargetDateLabel();
    }
    return targetDateLabel;

  }

  /**
   * 利用者情報領域を取得します。
   * @return 利用者情報領域
   */
  public ACGroupBox getPatients(){
    if(patients==null){

      patients = new ACGroupBox();

      patients.setText("利用者情報");

      addPatients();
    }
    return patients;

  }

  /**
   * 利用者情報サブ領域1を取得します。
   * @return 利用者情報サブ領域1
   */
  public ACPanel getPatients1(){
    if(patients1==null){

      patients1 = new ACPanel();

      patients1.setAutoWrap(false);

      patients1.setHgap(0);

      patients1.setHgrid(100);

      addPatients1();
    }
    return patients1;

  }

  /**
   * 利用者氏名を取得します。
   * @return 利用者氏名
   */
  public ACTextField getPatientName(){
    if(patientName==null){

      patientName = new ACTextField();

      getPatientNameContainer().setText("利用者氏名");

      patientName.setBindPath("PATIENT_NAME");

      patientName.setEditable(false);

      patientName.setColumns(26);

      patientName.setIMEMode(InputSubset.KANJI);

      patientName.setMaxLength(52);

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
   * 性別を取得します。
   * @return 性別
   */
  public ACTextField getPatientSex(){
    if(patientSex==null){

      patientSex = new ACTextField();

      getPatientSexContainer().setText("性別");

      patientSex.setBindPath("PATIENT_SEX");

      patientSex.setEditable(false);

      patientSex.setFormat(QkanConstants.FORMAT_SEX);

      patientSex.setMaxLength(4);

      addPatientSex();
    }
    return patientSex;

  }

  /**
   * 性別コンテナを取得します。
   * @return 性別コンテナ
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
   * 生年月日を取得します。
   * @return 生年月日
   */
  public QkanDateTextField getPatientBirth(){
    if(patientBirth==null){

      patientBirth = new QkanDateTextField();

      getPatientBirthContainer().setText("生年月日");

      patientBirth.setBindPath("PATIENT_BIRTHDAY");

      patientBirth.setEditable(false);

      addPatientBirth();
    }
    return patientBirth;

  }

  /**
   * 生年月日コンテナを取得します。
   * @return 生年月日コンテナ
   */
  protected ACLabelContainer getPatientBirthContainer(){
    if(patientBirthContainer==null){
      patientBirthContainer = new ACLabelContainer();
      patientBirthContainer.setFollowChildEnabled(true);
      patientBirthContainer.setVAlignment(VRLayout.CENTER);
      patientBirthContainer.add(getPatientBirth(), null);
    }
    return patientBirthContainer;
  }

  /**
   * 要介護認定を取得します。
   * @return 要介護認定
   */
  public ACValueArrayRadioButtonGroup getJotaiCode(){
    if(jotaiCode==null){

      jotaiCode = new ACValueArrayRadioButtonGroup();

      getJotaiCodeContainer().setText("要介護認定");

      jotaiCode.setBindPath("JOTAI_CODE");

      jotaiCode.setUseClearButton(false);

      jotaiCode.setModel(getJotaiCodeModel());

      jotaiCode.setValues(new int[]{1,12,13,11,21,22,23,24,25});

      addJotaiCode();
    }
    return jotaiCode;

  }

  /**
   * 要介護認定コンテナを取得します。
   * @return 要介護認定コンテナ
   */
  protected ACLabelContainer getJotaiCodeContainer(){
    if(jotaiCodeContainer==null){
      jotaiCodeContainer = new ACLabelContainer();
      jotaiCodeContainer.setFollowChildEnabled(true);
      jotaiCodeContainer.setVAlignment(VRLayout.CENTER);
      jotaiCodeContainer.add(getJotaiCode(), null);
    }
    return jotaiCodeContainer;
  }

  /**
   * 要介護認定モデルを取得します。
   * @return 要介護認定モデル
   */
  protected ACListModelAdapter getJotaiCodeModel(){
    if(jotaiCodeModel==null){
      jotaiCodeModel = new ACListModelAdapter();
      addJotaiCodeModel();
    }
    return jotaiCodeModel;
  }

  /**
   * 自立を取得します。
   * @return 自立
   */
  public ACRadioButtonItem getYokaigodoRadioItem1(){
    if(yokaigodoRadioItem1==null){

      yokaigodoRadioItem1 = new ACRadioButtonItem();

      yokaigodoRadioItem1.setText("自立");

      yokaigodoRadioItem1.setGroup(getJotaiCode());

      yokaigodoRadioItem1.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem1();
    }
    return yokaigodoRadioItem1;

  }

  /**
   * 要支援１を取得します。
   * @return 要支援１
   */
  public ACRadioButtonItem getYokaigodoRadioItem8(){
    if(yokaigodoRadioItem8==null){

      yokaigodoRadioItem8 = new ACRadioButtonItem();

      yokaigodoRadioItem8.setText("要支援１");

      yokaigodoRadioItem8.setGroup(getJotaiCode());

      yokaigodoRadioItem8.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem8();
    }
    return yokaigodoRadioItem8;

  }

  /**
   * 要支援２を取得します。
   * @return 要支援２
   */
  public ACRadioButtonItem getYokaigodoRadioItem9(){
    if(yokaigodoRadioItem9==null){

      yokaigodoRadioItem9 = new ACRadioButtonItem();

      yokaigodoRadioItem9.setText("要支援２");

      yokaigodoRadioItem9.setGroup(getJotaiCode());

      yokaigodoRadioItem9.setConstraints(VRLayout.FLOW_RETURN);

      addYokaigodoRadioItem9();
    }
    return yokaigodoRadioItem9;

  }

  /**
   * 経過的要介護を取得します。
   * @return 経過的要介護
   */
  public ACRadioButtonItem getYokaigodoRadioItem2(){
    if(yokaigodoRadioItem2==null){

      yokaigodoRadioItem2 = new ACRadioButtonItem();

      yokaigodoRadioItem2.setText("経過的要介護");

      yokaigodoRadioItem2.setGroup(getJotaiCode());

      yokaigodoRadioItem2.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem2();
    }
    return yokaigodoRadioItem2;

  }

  /**
   * 要介護1を取得します。
   * @return 要介護1
   */
  public ACRadioButtonItem getYokaigodoRadioItem3(){
    if(yokaigodoRadioItem3==null){

      yokaigodoRadioItem3 = new ACRadioButtonItem();

      yokaigodoRadioItem3.setText("要介護1");

      yokaigodoRadioItem3.setGroup(getJotaiCode());

      yokaigodoRadioItem3.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem3();
    }
    return yokaigodoRadioItem3;

  }

  /**
   * 要介護2を取得します。
   * @return 要介護2
   */
  public ACRadioButtonItem getYokaigodoRadioItem4(){
    if(yokaigodoRadioItem4==null){

      yokaigodoRadioItem4 = new ACRadioButtonItem();

      yokaigodoRadioItem4.setText("要介護2");

      yokaigodoRadioItem4.setGroup(getJotaiCode());

      yokaigodoRadioItem4.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem4();
    }
    return yokaigodoRadioItem4;

  }

  /**
   * 要介護3を取得します。
   * @return 要介護3
   */
  public ACRadioButtonItem getYokaigodoRadioItem5(){
    if(yokaigodoRadioItem5==null){

      yokaigodoRadioItem5 = new ACRadioButtonItem();

      yokaigodoRadioItem5.setText("要介護3");

      yokaigodoRadioItem5.setGroup(getJotaiCode());

      yokaigodoRadioItem5.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem5();
    }
    return yokaigodoRadioItem5;

  }

  /**
   * 要介護4を取得します。
   * @return 要介護4
   */
  public ACRadioButtonItem getYokaigodoRadioItem6(){
    if(yokaigodoRadioItem6==null){

      yokaigodoRadioItem6 = new ACRadioButtonItem();

      yokaigodoRadioItem6.setText("要介護4");

      yokaigodoRadioItem6.setGroup(getJotaiCode());

      yokaigodoRadioItem6.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem6();
    }
    return yokaigodoRadioItem6;

  }

  /**
   * 要介護5を取得します。
   * @return 要介護5
   */
  public ACRadioButtonItem getYokaigodoRadioItem7(){
    if(yokaigodoRadioItem7==null){

      yokaigodoRadioItem7 = new ACRadioButtonItem();

      yokaigodoRadioItem7.setText("要介護5");

      yokaigodoRadioItem7.setGroup(getJotaiCode());

      yokaigodoRadioItem7.setConstraints(VRLayout.FLOW);

      addYokaigodoRadioItem7();
    }
    return yokaigodoRadioItem7;

  }

  /**
   * 利用者情報サブ領域2を取得します。
   * @return 利用者情報サブ領域2
   */
  public ACPanel getPatients2(){
    if(patients2==null){

      patients2 = new ACPanel();

      addPatients2();
    }
    return patients2;

  }

  /**
   * 障害老人日常生活自立度を取得します。
   * @return 障害老人日常生活自立度
   */
  public ACClearableRadioButtonGroup getShogaiJiritsudo(){
    if(shogaiJiritsudo==null){

      shogaiJiritsudo = new ACClearableRadioButtonGroup();

      getShogaiJiritsudoContainer().setText("障害高齢者の日常生活自立度");

      shogaiJiritsudo.setBindPath("SHOGAI_JIRITSUDO");

      shogaiJiritsudo.setUseClearButton(true);

      shogaiJiritsudo.setModel(getShogaiJiritsudoModel());

      addShogaiJiritsudo();
    }
    return shogaiJiritsudo;

  }

  /**
   * 障害老人日常生活自立度コンテナを取得します。
   * @return 障害老人日常生活自立度コンテナ
   */
  protected ACLabelContainer getShogaiJiritsudoContainer(){
    if(shogaiJiritsudoContainer==null){
      shogaiJiritsudoContainer = new ACLabelContainer();
      shogaiJiritsudoContainer.setFollowChildEnabled(true);
      shogaiJiritsudoContainer.setVAlignment(VRLayout.CENTER);
      shogaiJiritsudoContainer.add(getShogaiJiritsudo(), null);
    }
    return shogaiJiritsudoContainer;
  }

  /**
   * 障害老人日常生活自立度モデルを取得します。
   * @return 障害老人日常生活自立度モデル
   */
  protected ACListModelAdapter getShogaiJiritsudoModel(){
    if(shogaiJiritsudoModel==null){
      shogaiJiritsudoModel = new ACListModelAdapter();
      addShogaiJiritsudoModel();
    }
    return shogaiJiritsudoModel;
  }

  /**
   * 障害老人日常生活自立度1を取得します。
   * @return 障害老人日常生活自立度1
   */
  public ACRadioButtonItem getShogaiJiritsudoRadioItem1(){
    if(shogaiJiritsudoRadioItem1==null){

      shogaiJiritsudoRadioItem1 = new ACRadioButtonItem();

      shogaiJiritsudoRadioItem1.setText("自立");

      shogaiJiritsudoRadioItem1.setGroup(getShogaiJiritsudo());

      addShogaiJiritsudoRadioItem1();
    }
    return shogaiJiritsudoRadioItem1;

  }

  /**
   * 障害老人日常生活自立度2を取得します。
   * @return 障害老人日常生活自立度2
   */
  public ACRadioButtonItem getShogaiJiritsudoRadioItem2(){
    if(shogaiJiritsudoRadioItem2==null){

      shogaiJiritsudoRadioItem2 = new ACRadioButtonItem();

      shogaiJiritsudoRadioItem2.setText("Ｊ");

      shogaiJiritsudoRadioItem2.setGroup(getShogaiJiritsudo());

      addShogaiJiritsudoRadioItem2();
    }
    return shogaiJiritsudoRadioItem2;

  }

  /**
   * 障害老人日常生活自立度3を取得します。
   * @return 障害老人日常生活自立度3
   */
  public ACRadioButtonItem getShogaiJiritsudoRadioItem3(){
    if(shogaiJiritsudoRadioItem3==null){

      shogaiJiritsudoRadioItem3 = new ACRadioButtonItem();

      shogaiJiritsudoRadioItem3.setText("Ａ");

      shogaiJiritsudoRadioItem3.setGroup(getShogaiJiritsudo());

      addShogaiJiritsudoRadioItem3();
    }
    return shogaiJiritsudoRadioItem3;

  }

  /**
   * 障害老人日常生活自立度4を取得します。
   * @return 障害老人日常生活自立度4
   */
  public ACRadioButtonItem getShogaiJiritsudoRadioItem4(){
    if(shogaiJiritsudoRadioItem4==null){

      shogaiJiritsudoRadioItem4 = new ACRadioButtonItem();

      shogaiJiritsudoRadioItem4.setText("Ｂ");

      shogaiJiritsudoRadioItem4.setGroup(getShogaiJiritsudo());

      addShogaiJiritsudoRadioItem4();
    }
    return shogaiJiritsudoRadioItem4;

  }

  /**
   * 障害老人日常生活自立度5を取得します。
   * @return 障害老人日常生活自立度5
   */
  public ACRadioButtonItem getShogaiJiritsudoRadioItem5(){
    if(shogaiJiritsudoRadioItem5==null){

      shogaiJiritsudoRadioItem5 = new ACRadioButtonItem();

      shogaiJiritsudoRadioItem5.setText("Ｃ");

      shogaiJiritsudoRadioItem5.setGroup(getShogaiJiritsudo());

      addShogaiJiritsudoRadioItem5();
    }
    return shogaiJiritsudoRadioItem5;

  }

  /**
   * 認知症老人日常生活自立度を取得します。
   * @return 認知症老人日常生活自立度
   */
  public ACClearableRadioButtonGroup getNinchishoJiritsudo(){
    if(ninchishoJiritsudo==null){

      ninchishoJiritsudo = new ACClearableRadioButtonGroup();

      getNinchishoJiritsudoContainer().setText("認知症高齢者の日常生活自立度");

      ninchishoJiritsudo.setBindPath("NINCHISHO_JIRITSUDO");

      ninchishoJiritsudo.setUseClearButton(true);

      ninchishoJiritsudo.setModel(getNinchishoJiritsudoModel());

      addNinchishoJiritsudo();
    }
    return ninchishoJiritsudo;

  }

  /**
   * 認知症老人日常生活自立度コンテナを取得します。
   * @return 認知症老人日常生活自立度コンテナ
   */
  protected ACLabelContainer getNinchishoJiritsudoContainer(){
    if(ninchishoJiritsudoContainer==null){
      ninchishoJiritsudoContainer = new ACLabelContainer();
      ninchishoJiritsudoContainer.setFollowChildEnabled(true);
      ninchishoJiritsudoContainer.setVAlignment(VRLayout.CENTER);
      ninchishoJiritsudoContainer.add(getNinchishoJiritsudo(), null);
    }
    return ninchishoJiritsudoContainer;
  }

  /**
   * 認知症老人日常生活自立度モデルを取得します。
   * @return 認知症老人日常生活自立度モデル
   */
  protected ACListModelAdapter getNinchishoJiritsudoModel(){
    if(ninchishoJiritsudoModel==null){
      ninchishoJiritsudoModel = new ACListModelAdapter();
      addNinchishoJiritsudoModel();
    }
    return ninchishoJiritsudoModel;
  }

  /**
   * 認知症老人日常生活自立度1を取得します。
   * @return 認知症老人日常生活自立度1
   */
  public ACRadioButtonItem getNinchishoJiritsudoRadioItem1(){
    if(ninchishoJiritsudoRadioItem1==null){

      ninchishoJiritsudoRadioItem1 = new ACRadioButtonItem();

      ninchishoJiritsudoRadioItem1.setText("自立");

      ninchishoJiritsudoRadioItem1.setGroup(getNinchishoJiritsudo());

      addNinchishoJiritsudoRadioItem1();
    }
    return ninchishoJiritsudoRadioItem1;

  }

  /**
   * 認知症老人日常生活自立度2を取得します。
   * @return 認知症老人日常生活自立度2
   */
  public ACRadioButtonItem getNinchishoJiritsudoRadioItem2(){
    if(ninchishoJiritsudoRadioItem2==null){

      ninchishoJiritsudoRadioItem2 = new ACRadioButtonItem();

      ninchishoJiritsudoRadioItem2.setText("I");

      ninchishoJiritsudoRadioItem2.setGroup(getNinchishoJiritsudo());

      addNinchishoJiritsudoRadioItem2();
    }
    return ninchishoJiritsudoRadioItem2;

  }

  /**
   * 認知症老人日常生活自立度3を取得します。
   * @return 認知症老人日常生活自立度3
   */
  public ACRadioButtonItem getNinchishoJiritsudoRadioItem3(){
    if(ninchishoJiritsudoRadioItem3==null){

      ninchishoJiritsudoRadioItem3 = new ACRadioButtonItem();

      ninchishoJiritsudoRadioItem3.setText("II");

      ninchishoJiritsudoRadioItem3.setGroup(getNinchishoJiritsudo());

      addNinchishoJiritsudoRadioItem3();
    }
    return ninchishoJiritsudoRadioItem3;

  }

  /**
   * 認知症老人日常生活自立度4を取得します。
   * @return 認知症老人日常生活自立度4
   */
  public ACRadioButtonItem getNinchishoJiritsudoRadioItem4(){
    if(ninchishoJiritsudoRadioItem4==null){

      ninchishoJiritsudoRadioItem4 = new ACRadioButtonItem();

      ninchishoJiritsudoRadioItem4.setText("III");

      ninchishoJiritsudoRadioItem4.setGroup(getNinchishoJiritsudo());

      addNinchishoJiritsudoRadioItem4();
    }
    return ninchishoJiritsudoRadioItem4;

  }

  /**
   * 認知症老人日常生活自立度5を取得します。
   * @return 認知症老人日常生活自立度5
   */
  public ACRadioButtonItem getNinchishoJiritsudoRadioItem5(){
    if(ninchishoJiritsudoRadioItem5==null){

      ninchishoJiritsudoRadioItem5 = new ACRadioButtonItem();

      ninchishoJiritsudoRadioItem5.setText("IV");

      ninchishoJiritsudoRadioItem5.setGroup(getNinchishoJiritsudo());

      addNinchishoJiritsudoRadioItem5();
    }
    return ninchishoJiritsudoRadioItem5;

  }

  /**
   * 認知症老人日常生活自立度6を取得します。
   * @return 認知症老人日常生活自立度6
   */
  public ACRadioButtonItem getNinchishoJiritsudoRadioItem6(){
    if(ninchishoJiritsudoRadioItem6==null){

      ninchishoJiritsudoRadioItem6 = new ACRadioButtonItem();

      ninchishoJiritsudoRadioItem6.setText("Ｍ");

      ninchishoJiritsudoRadioItem6.setGroup(getNinchishoJiritsudo());

      addNinchishoJiritsudoRadioItem6();
    }
    return ninchishoJiritsudoRadioItem6;

  }

  /**
   * 利用者住所を取得します。
   * @return 利用者住所
   */
  public ACTextArea getPatientAddress(){
    if(patientAddress==null){

      patientAddress = new ACTextArea();

      getPatientAddressContainer().setText("利用者住所");

      patientAddress.setBindPath("PATIENT_ADDRESS");

      patientAddress.setColumns(80);

      patientAddress.setRows(3);

      patientAddress.setMaxRows(2);

      patientAddress.setIMEMode(InputSubset.KANJI);

      patientAddress.setMaxLength(120);

      patientAddress.setLineWrap(true);

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
   * (電話番号・コンテナ)を取得します。
   * @return (電話番号・コンテナ)
   */
  public ACLabelContainer getPatientTelContena(){
    if(patientTelContena==null){

      patientTelContena = new ACLabelContainer();

      patientTelContena.setText("連絡先");

      addPatientTelContena();
    }
    return patientTelContena;

  }

  /**
   * 電話番号・テキスト1を取得します。
   * @return 電話番号・テキスト1
   */
  public ACTextField getPatientTel2(){
    if(patientTel2==null){

      patientTel2 = new ACTextField();

      patientTel2.setBindPath("PATIENT_TEL_FIRST");

      patientTel2.setColumns(4);

      patientTel2.setCharType(VRCharType.ONLY_DIGIT);

      patientTel2.setIMEMode(InputSubset.LATIN);

      patientTel2.setMaxLength(6);

      addPatientTel2();
    }
    return patientTel2;

  }

  /**
   * 電話番号・ラベル1を取得します。
   * @return 電話番号・ラベル1
   */
  public ACLabel getPatientTel3(){
    if(patientTel3==null){

      patientTel3 = new ACLabel();

      patientTel3.setText("-");

      addPatientTel3();
    }
    return patientTel3;

  }

  /**
   * 電話番号・テキスト2を取得します。
   * @return 電話番号・テキスト2
   */
  public ACTextField getPatientTel4(){
    if(patientTel4==null){

      patientTel4 = new ACTextField();

      patientTel4.setBindPath("PATIENT_TEL_SECOND");

      patientTel4.setColumns(4);

      patientTel4.setCharType(VRCharType.ONLY_DIGIT);

      patientTel4.setIMEMode(InputSubset.LATIN);

      patientTel4.setMaxLength(4);

      addPatientTel4();
    }
    return patientTel4;

  }

  /**
   * 電話番号・ラベル2を取得します。
   * @return 電話番号・ラベル2
   */
  public ACLabel getPatientTel5(){
    if(patientTel5==null){

      patientTel5 = new ACLabel();

      patientTel5.setText("-");

      addPatientTel5();
    }
    return patientTel5;

  }

  /**
   * 電話番号・テキスト3を取得します。
   * @return 電話番号・テキスト3
   */
  public ACTextField getPatientTel6(){
    if(patientTel6==null){

      patientTel6 = new ACTextField();

      patientTel6.setBindPath("PATIENT_TEL_THIRD");

      patientTel6.setColumns(4);

      patientTel6.setCharType(VRCharType.ONLY_DIGIT);

      patientTel6.setIMEMode(InputSubset.LATIN);

      patientTel6.setMaxLength(4);

      addPatientTel6();
    }
    return patientTel6;

  }

  /**
   * タブ領域を取得します。
   * @return タブ領域
   */
  public JTabbedPane getTabsArea(){
    if(tabsArea==null){

      tabsArea = new JTabbedPane();

      addTabsArea();
    }
    return tabsArea;

  }

  /**
   * 医療機関情報領域を取得します。
   * @return 医療機関情報領域
   */
  public ACPanel getProviderAndMedicaiInfoArea(){
    if(providerAndMedicaiInfoArea==null){

      providerAndMedicaiInfoArea = new ACPanel();

      addProviderAndMedicaiInfoArea();
    }
    return providerAndMedicaiInfoArea;

  }

  /**
   * 医療機関グループを取得します。
   * @return 医療機関グループ
   */
  public ACGroupBox getMedicalInfoGroup(){
    if(medicalInfoGroup==null){

      medicalInfoGroup = new ACGroupBox();

      medicalInfoGroup.setText("情報提供元医療機関の所在地及び名称");

      addMedicalInfoGroup();
    }
    return medicalInfoGroup;

  }

  /**
   * 医療機関名を取得します。
   * @return 医療機関名
   */
  public ACComboBox getMedicalInstitusion(){
    if(medicalInstitusion==null){

      medicalInstitusion = new ACComboBox();

      getMedicalInstitusionContainer().setText("医療機関名");

      medicalInstitusion.setBindPath("MEDICAL_FACILITY_NAME");

      medicalInstitusion.setEditable(true);

      medicalInstitusion.setModelBindPath("MEDICAL_INSTITUSIONS");

      medicalInstitusion.setRenderBindPath("MEDICAL_FACILITY_NAME");

      medicalInstitusion.setIMEMode(InputSubset.KANJI);

      medicalInstitusion.setMaxLength(60);

      medicalInstitusion.setMaxColumns(45);

      medicalInstitusion.setModel(getMedicalInstitusionModel());

      addMedicalInstitusion();
    }
    return medicalInstitusion;

  }

  /**
   * 医療機関名コンテナを取得します。
   * @return 医療機関名コンテナ
   */
  protected ACLabelContainer getMedicalInstitusionContainer(){
    if(medicalInstitusionContainer==null){
      medicalInstitusionContainer = new ACLabelContainer();
      medicalInstitusionContainer.setFollowChildEnabled(true);
      medicalInstitusionContainer.setVAlignment(VRLayout.CENTER);
      medicalInstitusionContainer.add(getMedicalInstitusion(), null);
    }
    return medicalInstitusionContainer;
  }

  /**
   * 医療機関名モデルを取得します。
   * @return 医療機関名モデル
   */
  protected ACComboBoxModelAdapter getMedicalInstitusionModel(){
    if(medicalInstitusionModel==null){
      medicalInstitusionModel = new ACComboBoxModelAdapter();
      addMedicalInstitusionModel();
    }
    return medicalInstitusionModel;
  }

  /**
   * 医療機関住所を取得します。
   * @return 医療機関住所
   */
  public ACTextField getMedicalAddress(){
    if(medicalAddress==null){

      medicalAddress = new ACTextField();

      getMedicalAddressContainer().setText("住所");

      medicalAddress.setBindPath("MEDICAL_FACILITY_ADDRESS");

      medicalAddress.setColumns(45);

      medicalAddress.setIMEMode(InputSubset.KANJI);

      medicalAddress.setMaxLength(100);

      addMedicalAddress();
    }
    return medicalAddress;

  }

  /**
   * 医療機関住所コンテナを取得します。
   * @return 医療機関住所コンテナ
   */
  protected ACLabelContainer getMedicalAddressContainer(){
    if(medicalAddressContainer==null){
      medicalAddressContainer = new ACLabelContainer();
      medicalAddressContainer.setFollowChildEnabled(true);
      medicalAddressContainer.setVAlignment(VRLayout.CENTER);
      medicalAddressContainer.add(getMedicalAddress(), null);
    }
    return medicalAddressContainer;
  }

  /**
   * 医療機関電話番号・コンテナを取得します。
   * @return 医療機関電話番号・コンテナ
   */
  public ACLabelContainer getMedicalTelContena(){
    if(medicalTelContena==null){

      medicalTelContena = new ACLabelContainer();

      medicalTelContena.setText("連絡先");

      addMedicalTelContena();
    }
    return medicalTelContena;

  }

  /**
   * 電話番号・テキスト1を取得します。
   * @return 電話番号・テキスト1
   */
  public ACTextField getMedicalTel2(){
    if(medicalTel2==null){

      medicalTel2 = new ACTextField();

      medicalTel2.setBindPath("MEDICAL_FACILITY_TEL_FIRST");

      medicalTel2.setColumns(4);

      medicalTel2.setCharType(VRCharType.ONLY_DIGIT);

      medicalTel2.setIMEMode(InputSubset.LATIN);

      medicalTel2.setMaxLength(6);

      addMedicalTel2();
    }
    return medicalTel2;

  }

  /**
   * 電話番号・ラベル1を取得します。
   * @return 電話番号・ラベル1
   */
  public ACLabel getMedicalTel3(){
    if(medicalTel3==null){

      medicalTel3 = new ACLabel();

      medicalTel3.setText("-");

      addMedicalTel3();
    }
    return medicalTel3;

  }

  /**
   * 電話番号・テキスト2を取得します。
   * @return 電話番号・テキスト2
   */
  public ACTextField getMedicalTel4(){
    if(medicalTel4==null){

      medicalTel4 = new ACTextField();

      medicalTel4.setBindPath("MEDICAL_FACILITY_TEL_SECOND");

      medicalTel4.setColumns(4);

      medicalTel4.setCharType(VRCharType.ONLY_DIGIT);

      medicalTel4.setIMEMode(InputSubset.LATIN);

      medicalTel4.setMaxLength(4);

      addMedicalTel4();
    }
    return medicalTel4;

  }

  /**
   * 電話番号・ラベル2を取得します。
   * @return 電話番号・ラベル2
   */
  public ACLabel getMedicalTel5(){
    if(medicalTel5==null){

      medicalTel5 = new ACLabel();

      medicalTel5.setText("-");

      addMedicalTel5();
    }
    return medicalTel5;

  }

  /**
   * 電話番号・テキスト3を取得します。
   * @return 電話番号・テキスト3
   */
  public ACTextField getMedicalTel6(){
    if(medicalTel6==null){

      medicalTel6 = new ACTextField();

      medicalTel6.setBindPath("MEDICAL_FACILITY_TEL_THIRD");

      medicalTel6.setColumns(4);

      medicalTel6.setCharType(VRCharType.ONLY_DIGIT);

      medicalTel6.setIMEMode(InputSubset.LATIN);

      medicalTel6.setMaxLength(4);

      addMedicalTel6();
    }
    return medicalTel6;

  }

  /**
   * 担当医氏名を取得します。
   * @return 担当医氏名
   */
  public ACTextField getDoctorName(){
    if(doctorName==null){

      doctorName = new ACTextField();

      getDoctorNameContainer().setText("医師氏名");

      doctorName.setBindPath("DOCTOR_NAME");

      doctorName.setColumns(30);

      doctorName.setIMEMode(InputSubset.KANJI);

      doctorName.setMaxLength(25);

      addDoctorName();
    }
    return doctorName;

  }

  /**
   * 担当医氏名コンテナを取得します。
   * @return 担当医氏名コンテナ
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
   * Tab1「在宅療養生活のポイント」を取得します。
   * @return Tab1「在宅療養生活のポイント」
   */
  public ACPanel getPoints(){
    if(points==null){

      points = new ACPanel();

      addPoints();
    }
    return points;

  }

  /**
   * Tab1・在宅療養生活のポイント・サブ領域1を取得します。
   * @return Tab1・在宅療養生活のポイント・サブ領域1
   */
  public ACPanel getPoints1(){
    if(points1==null){

      points1 = new ACPanel();

      addPoints1();
    }
    return points1;

  }

  /**
   * あなたの主治医キャプションを取得します。
   * @return あなたの主治医キャプション
   */
  public ACLabel getYourDoctorCaption1(){
    if(yourDoctorCaption1==null){

      yourDoctorCaption1 = new ACLabel();

      yourDoctorCaption1.setText("あなたの主治医は、私、");

      addYourDoctorCaption1();
    }
    return yourDoctorCaption1;

  }

  /**
   * あなたの主治医を取得します。
   * @return あなたの主治医
   */
  public ACLabel getYourDoctor(){
    if(yourDoctor==null){

      yourDoctor = new ACLabel();

      yourDoctor.setBindPath("YOUR_DOCTOR_NAME");

      addYourDoctor();
    }
    return yourDoctor;

  }

  /**
   * あなたの主治医キャプションを取得します。
   * @return あなたの主治医キャプション
   */
  public ACLabel getYourDoctorCaption2(){
    if(yourDoctorCaption2==null){

      yourDoctorCaption2 = new ACLabel();

      yourDoctorCaption2.setText("です。");

      addYourDoctorCaption2();
    }
    return yourDoctorCaption2;

  }

  /**
   * 在宅療養生活のポイント作成年月日を取得します。
   * @return 在宅療養生活のポイント作成年月日
   */
  public QkanYearDateTextField getCreateDateZaitaku(){
    if(createDateZaitaku==null){

      createDateZaitaku = new QkanYearDateTextField();

      getCreateDateZaitakuContainer().setText("作成年月日");

      createDateZaitaku.setBindPath("CREATE_DATE_ZAITAKU");

      createDateZaitaku.setVisible(false);

      createDateZaitaku.setEditable(true);

      addCreateDateZaitaku();
    }
    return createDateZaitaku;

  }

  /**
   * 在宅療養生活のポイント作成年月日コンテナを取得します。
   * @return 在宅療養生活のポイント作成年月日コンテナ
   */
  protected ACLabelContainer getCreateDateZaitakuContainer(){
    if(createDateZaitakuContainer==null){
      createDateZaitakuContainer = new ACLabelContainer();
      createDateZaitakuContainer.setFollowChildEnabled(true);
      createDateZaitakuContainer.setVAlignment(VRLayout.CENTER);
      createDateZaitakuContainer.add(getCreateDateZaitaku(), null);
    }
    return createDateZaitakuContainer;
  }

  /**
   * 今月の訪問日コンテナを取得します。
   * @return 今月の訪問日コンテナ
   */
  public ACLabelContainer getVisitThisMonthContainer(){
    if(visitThisMonthContainer==null){

      visitThisMonthContainer = new ACLabelContainer();

      visitThisMonthContainer.setText("今月の訪問日");

      addVisitThisMonthContainer();
    }
    return visitThisMonthContainer;

  }

  /**
   * 今月の訪問日1を取得します。
   * @return 今月の訪問日1
   */
  public ACTextField getVisitThisMonth1(){
    if(visitThisMonth1==null){

      visitThisMonth1 = new ACTextField();

      visitThisMonth1.setBindPath("VISIT_THIS_MONTH_NO1");

      visitThisMonth1.setColumns(2);

      visitThisMonth1.setCharType(VRCharType.ONLY_DIGIT);

      visitThisMonth1.setHorizontalAlignment(SwingConstants.RIGHT);

      visitThisMonth1.setIMEMode(InputSubset.LATIN);

      visitThisMonth1.setMaxLength(2);

      addVisitThisMonth1();
    }
    return visitThisMonth1;

  }

  /**
   * 今月の訪問日2を取得します。
   * @return 今月の訪問日2
   */
  public ACTextField getVisitThisMonth2(){
    if(visitThisMonth2==null){

      visitThisMonth2 = new ACTextField();

      visitThisMonth2.setBindPath("VISIT_THIS_MONTH_NO2");

      visitThisMonth2.setColumns(2);

      visitThisMonth2.setCharType(VRCharType.ONLY_DIGIT);

      visitThisMonth2.setHorizontalAlignment(SwingConstants.RIGHT);

      visitThisMonth2.setIMEMode(InputSubset.LATIN);

      visitThisMonth2.setMaxLength(2);

      addVisitThisMonth2();
    }
    return visitThisMonth2;

  }

  /**
   * 今月の訪問日3を取得します。
   * @return 今月の訪問日3
   */
  public ACTextField getVisitThisMonth3(){
    if(visitThisMonth3==null){

      visitThisMonth3 = new ACTextField();

      visitThisMonth3.setBindPath("VISIT_THIS_MONTH_NO3");

      visitThisMonth3.setColumns(2);

      visitThisMonth3.setCharType(VRCharType.ONLY_DIGIT);

      visitThisMonth3.setHorizontalAlignment(SwingConstants.RIGHT);

      visitThisMonth3.setIMEMode(InputSubset.LATIN);

      visitThisMonth3.setMaxLength(2);

      addVisitThisMonth3();
    }
    return visitThisMonth3;

  }

  /**
   * 今月の訪問日4を取得します。
   * @return 今月の訪問日4
   */
  public ACTextField getVisitThisMonth4(){
    if(visitThisMonth4==null){

      visitThisMonth4 = new ACTextField();

      visitThisMonth4.setBindPath("VISIT_THIS_MONTH_NO4");

      visitThisMonth4.setColumns(2);

      visitThisMonth4.setCharType(VRCharType.ONLY_DIGIT);

      visitThisMonth4.setHorizontalAlignment(SwingConstants.RIGHT);

      visitThisMonth4.setIMEMode(InputSubset.LATIN);

      visitThisMonth4.setMaxLength(2);

      addVisitThisMonth4();
    }
    return visitThisMonth4;

  }

  /**
   * 今月の訪問日5を取得します。
   * @return 今月の訪問日5
   */
  public ACTextField getVisitThisMonth5(){
    if(visitThisMonth5==null){

      visitThisMonth5 = new ACTextField();

      visitThisMonth5.setBindPath("VISIT_THIS_MONTH_NO5");

      visitThisMonth5.setColumns(2);

      visitThisMonth5.setCharType(VRCharType.ONLY_DIGIT);

      visitThisMonth5.setHorizontalAlignment(SwingConstants.RIGHT);

      visitThisMonth5.setIMEMode(InputSubset.LATIN);

      visitThisMonth5.setMaxLength(2);

      addVisitThisMonth5();
    }
    return visitThisMonth5;

  }

  /**
   * 今月の訪問日6を取得します。
   * @return 今月の訪問日6
   */
  public ACTextField getVisitThisMonth6(){
    if(visitThisMonth6==null){

      visitThisMonth6 = new ACTextField();

      visitThisMonth6.setBindPath("VISIT_THIS_MONTH_NO6");

      visitThisMonth6.setColumns(2);

      visitThisMonth6.setCharType(VRCharType.ONLY_DIGIT);

      visitThisMonth6.setHorizontalAlignment(SwingConstants.RIGHT);

      visitThisMonth6.setIMEMode(InputSubset.LATIN);

      visitThisMonth6.setMaxLength(2);

      addVisitThisMonth6();
    }
    return visitThisMonth6;

  }

  /**
   * 今月の訪問日キャプションを取得します。
   * @return 今月の訪問日キャプション
   */
  public ACLabel getVisitThisMonthCaption(){
    if(visitThisMonthCaption==null){

      visitThisMonthCaption = new ACLabel();

      visitThisMonthCaption.setText("日");

      addVisitThisMonthCaption();
    }
    return visitThisMonthCaption;

  }

  /**
   * 実績読込みボタンを取得します。
   * @return 実績読込みボタン
   */
  public ACButton getResultReadButton(){
    if(resultReadButton==null){

      resultReadButton = new ACButton();

      resultReadButton.setText("実績読込");

      addResultReadButton();
    }
    return resultReadButton;

  }

  /**
   * 来月の訪問日コンテナを取得します。
   * @return 来月の訪問日コンテナ
   */
  public ACLabelContainer getVisitNextMonthContainer(){
    if(visitNextMonthContainer==null){

      visitNextMonthContainer = new ACLabelContainer();

      visitNextMonthContainer.setText("来月の訪問予定");

      addVisitNextMonthContainer();
    }
    return visitNextMonthContainer;

  }

  /**
   * 来月の訪問予定1を取得します。
   * @return 来月の訪問予定1
   */
  public ACTextField getVisitNextMonth1(){
    if(visitNextMonth1==null){

      visitNextMonth1 = new ACTextField();

      visitNextMonth1.setBindPath("VISIT_NEXT_MONTH_NO1");

      visitNextMonth1.setColumns(2);

      visitNextMonth1.setCharType(VRCharType.ONLY_DIGIT);

      visitNextMonth1.setHorizontalAlignment(SwingConstants.RIGHT);

      visitNextMonth1.setIMEMode(InputSubset.LATIN);

      visitNextMonth1.setMaxLength(2);

      addVisitNextMonth1();
    }
    return visitNextMonth1;

  }

  /**
   * 来月の訪問予定2を取得します。
   * @return 来月の訪問予定2
   */
  public ACTextField getVisitNextMonth2(){
    if(visitNextMonth2==null){

      visitNextMonth2 = new ACTextField();

      visitNextMonth2.setBindPath("VISIT_NEXT_MONTH_NO2");

      visitNextMonth2.setColumns(2);

      visitNextMonth2.setCharType(VRCharType.ONLY_DIGIT);

      visitNextMonth2.setHorizontalAlignment(SwingConstants.RIGHT);

      visitNextMonth2.setIMEMode(InputSubset.LATIN);

      visitNextMonth2.setMaxLength(2);

      addVisitNextMonth2();
    }
    return visitNextMonth2;

  }

  /**
   * 来月の訪問予定3を取得します。
   * @return 来月の訪問予定3
   */
  public ACTextField getVisitNextMonth3(){
    if(visitNextMonth3==null){

      visitNextMonth3 = new ACTextField();

      visitNextMonth3.setBindPath("VISIT_NEXT_MONTH_NO3");

      visitNextMonth3.setColumns(2);

      visitNextMonth3.setCharType(VRCharType.ONLY_DIGIT);

      visitNextMonth3.setHorizontalAlignment(SwingConstants.RIGHT);

      visitNextMonth3.setIMEMode(InputSubset.LATIN);

      visitNextMonth3.setMaxLength(2);

      addVisitNextMonth3();
    }
    return visitNextMonth3;

  }

  /**
   * 来月の訪問予定4を取得します。
   * @return 来月の訪問予定4
   */
  public ACTextField getVisitNextMonth4(){
    if(visitNextMonth4==null){

      visitNextMonth4 = new ACTextField();

      visitNextMonth4.setBindPath("VISIT_NEXT_MONTH_NO4");

      visitNextMonth4.setColumns(2);

      visitNextMonth4.setCharType(VRCharType.ONLY_DIGIT);

      visitNextMonth4.setHorizontalAlignment(SwingConstants.RIGHT);

      visitNextMonth4.setIMEMode(InputSubset.LATIN);

      visitNextMonth4.setMaxLength(2);

      addVisitNextMonth4();
    }
    return visitNextMonth4;

  }

  /**
   * 来月の訪問予定5を取得します。
   * @return 来月の訪問予定5
   */
  public ACTextField getVisitNextMonth5(){
    if(visitNextMonth5==null){

      visitNextMonth5 = new ACTextField();

      visitNextMonth5.setBindPath("VISIT_NEXT_MONTH_NO5");

      visitNextMonth5.setColumns(2);

      visitNextMonth5.setCharType(VRCharType.ONLY_DIGIT);

      visitNextMonth5.setHorizontalAlignment(SwingConstants.RIGHT);

      visitNextMonth5.setIMEMode(InputSubset.LATIN);

      visitNextMonth5.setMaxLength(2);

      addVisitNextMonth5();
    }
    return visitNextMonth5;

  }

  /**
   * 来月の訪問予定6を取得します。
   * @return 来月の訪問予定6
   */
  public ACTextField getVisitNextMonth6(){
    if(visitNextMonth6==null){

      visitNextMonth6 = new ACTextField();

      visitNextMonth6.setBindPath("VISIT_NEXT_MONTH_NO6");

      visitNextMonth6.setColumns(2);

      visitNextMonth6.setCharType(VRCharType.ONLY_DIGIT);

      visitNextMonth6.setHorizontalAlignment(SwingConstants.RIGHT);

      visitNextMonth6.setIMEMode(InputSubset.LATIN);

      visitNextMonth6.setMaxLength(2);

      addVisitNextMonth6();
    }
    return visitNextMonth6;

  }

  /**
   * 来月の訪問予定キャプションを取得します。
   * @return 来月の訪問予定キャプション
   */
  public ACLabel getVisitNextMonthCaption(){
    if(visitNextMonthCaption==null){

      visitNextMonthCaption = new ACLabel();

      visitNextMonthCaption.setText("日");

      addVisitNextMonthCaption();
    }
    return visitNextMonthCaption;

  }

  /**
   * アドバイスコンテナを取得します。
   * @return アドバイスコンテナ
   */
  public ACLabelContainer getAdviceContainer(){
    if(adviceContainer==null){

      adviceContainer = new ACLabelContainer();

      adviceContainer.setLayout(getAdviceContainerLayout());

      addAdviceContainer();
    }
    return adviceContainer;

  }

  /**
   * アドバイスコンテナレイアウトを取得します。
   * @return アドバイスコンテナレイアウト
   */
  public VRLayout getAdviceContainerLayout(){
    if(adviceContainerLayout==null){

      adviceContainerLayout = new VRLayout();

      adviceContainerLayout.setAutoWrap(false);

      adviceContainerLayout.setHgap(0);

      addAdviceContainerLayout();
    }
    return adviceContainerLayout;

  }

  /**
   * アドバイス領域を取得します。
   * @return アドバイス領域
   */
  public ACPanel getAdvices(){
    if(advices==null){

      advices = new ACPanel();

      addAdvices();
    }
    return advices;

  }

  /**
   * アドバイス・上部を取得します。
   * @return アドバイス・上部
   */
  public ACPanel getAdvicdHeaders(){
    if(advicdHeaders==null){

      advicdHeaders = new ACPanel();

      addAdvicdHeaders();
    }
    return advicdHeaders;

  }

  /**
   * ○月のアドバイスを取得します。
   * @return ○月のアドバイス
   */
  public ACTextField getAdviceMonth(){
    if(adviceMonth==null){

      adviceMonth = new ACTextField();

      adviceMonth.setBindPath("ADVICE_MONTH");

      adviceMonth.setEditable(false);

      adviceMonth.setColumns(2);

      adviceMonth.setCharType(VRCharType.ONLY_DIGIT);

      adviceMonth.setHorizontalAlignment(SwingConstants.CENTER);

      adviceMonth.setIMEMode(InputSubset.LATIN);

      adviceMonth.setMaxLength(2);

      addAdviceMonth();
    }
    return adviceMonth;

  }

  /**
   * ○月のアドバイスキャプションを取得します。
   * @return ○月のアドバイスキャプション
   */
  public ACLabel getAdviceMonthCaption(){
    if(adviceMonthCaption==null){

      adviceMonthCaption = new ACLabel();

      adviceMonthCaption.setText("月のアドバイス");

      addAdviceMonthCaption();
    }
    return adviceMonthCaption;

  }

  /**
   * アドバイス・長さを取得します。
   * @return アドバイス・長さ
   */
  public ACLabel getAdviceLength(){
    if(adviceLength==null){

      adviceLength = new ACLabel();

      adviceLength.setText("(48x19)");

      addAdviceLength();
    }
    return adviceLength;

  }

  /**
   * アドバイス・本文を取得します。
   * @return アドバイス・本文
   */
  public ACTextArea getAdvice(){
    if(advice==null){

      advice = new ACTextArea();

      advice.setBindPath("ADVICE");

      advice.setColumns(96);

      advice.setRows(9);

      advice.setMaxRows(19);

      advice.setIMEMode(InputSubset.KANJI);

      advice.setMaxLength(912);

      advice.setLineWrap(true);

      addAdvice();
    }
    return advice;

  }

  /**
   * Tab2「居宅療養管理指導書」を取得します。
   * @return Tab2「居宅療養管理指導書」
   */
  public ACPanel getPoints2(){
    if(points2==null){

      points2 = new ACPanel();

      addPoints2();
    }
    return points2;

  }

  /**
   * 居宅療養管理指導書内部タブを取得します。
   * @return 居宅療養管理指導書内部タブ
   */
  public JTabbedPane getKyotakuPoints(){
    if(kyotakuPoints==null){

      kyotakuPoints = new JTabbedPane();

      addKyotakuPoints();
    }
    return kyotakuPoints;

  }

  /**
   * 病状タブパネルを取得します。
   * @return 病状タブパネル
   */
  public ACPanel getKyotakuPointsPanel1(){
    if(kyotakuPointsPanel1==null){

      kyotakuPointsPanel1 = new ACPanel();

      addKyotakuPointsPanel1();
    }
    return kyotakuPointsPanel1;

  }

  /**
   * 事業所グループを取得します。
   * @return 事業所グループ
   */
  public ACGroupBox getProviderInfoGroup(){
    if(providerInfoGroup==null){

      providerInfoGroup = new ACGroupBox();

      providerInfoGroup.setText("事業所情報");

      providerInfoGroup.setAutoWrap(false);

      providerInfoGroup.setHgap(0);

      addProviderInfoGroup();
    }
    return providerInfoGroup;

  }

  /**
   * 居宅療養管理指導書・作成年月日を取得します。
   * @return 居宅療養管理指導書・作成年月日
   */
  public QkanDateTextField getCreateDateKyotaku(){
    if(createDateKyotaku==null){

      createDateKyotaku = new QkanDateTextField();

      getCreateDateKyotakuContainer().setText("作成年月日");

      createDateKyotaku.setBindPath("CREATE_DATE_KYOTAKU");

      createDateKyotaku.setEditable(true);

      addCreateDateKyotaku();
    }
    return createDateKyotaku;

  }

  /**
   * 居宅療養管理指導書・作成年月日コンテナを取得します。
   * @return 居宅療養管理指導書・作成年月日コンテナ
   */
  protected ACLabelContainer getCreateDateKyotakuContainer(){
    if(createDateKyotakuContainer==null){
      createDateKyotakuContainer = new ACLabelContainer();
      createDateKyotakuContainer.setFollowChildEnabled(true);
      createDateKyotakuContainer.setVAlignment(VRLayout.CENTER);
      createDateKyotakuContainer.add(getCreateDateKyotaku(), null);
    }
    return createDateKyotakuContainer;
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

      senmonin.setEditable(true);

      senmonin.setModelBindPath("SENMONIN");

      senmonin.setRenderBindPath("STAFF_NAME");

      senmonin.setIMEMode(InputSubset.KANJI);

      senmonin.setMaxLength(32);

      senmonin.setMaxColumns(15);

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
   * 事業所名を取得します。
   * @return 事業所名
   */
  public ACComboBox getProviderName(){
    if(providerName==null){

      providerName = new ACComboBox();

      getProviderNameContainer().setText("事業所等名");

      providerName.setBindPath("PROVIDER_NAME");

      providerName.setModelBindPath("PROVIDER_NAMES");

      providerName.setRenderBindPath("PROVIDER_NAME");

      providerName.setIMEMode(InputSubset.KANJI);

      providerName.setMaxLength(60);

      providerName.setMaxColumns(23);

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
   * 病状グループを取得します。
   * @return 病状グループ
   */
  public ACGroupBox getByojoGroup(){
    if(byojoGroup==null){

      byojoGroup = new ACGroupBox();

      byojoGroup.setText("病状(45×4)");

      byojoGroup.setHgap(0);

      byojoGroup.setLabelMargin(0);

      byojoGroup.setVgap(0);

      byojoGroup.setHgrid(0);

      addByojoGroup();
    }
    return byojoGroup;

  }

  /**
   * 病状パネルを取得します。
   * @return 病状パネル
   */
  public ACPanel getByojoPanel(){
    if(byojoPanel==null){

      byojoPanel = new ACPanel();

      byojoPanel.setHgap(0);

      byojoPanel.setLabelMargin(0);

      byojoPanel.setVgap(0);

      addByojoPanel();
    }
    return byojoPanel;

  }

  /**
   * 病状を取得します。
   * @return 病状
   */
  public ACTextArea getByojo(){
    if(byojo==null){

      byojo = new ACTextArea();

      byojo.setBindPath("CONDITION");

      byojo.setColumns(90);

      byojo.setRows(5);

      byojo.setMaxRows(4);

      byojo.setIMEMode(InputSubset.KANJI);

      byojo.setMaxLength(180);

      byojo.setLineWrap(true);

      addByojo();
    }
    return byojo;

  }

  /**
   * 病状コンテナを取得します。
   * @return 病状コンテナ
   */
  protected ACLabelContainer getByojoContainer(){
    if(byojoContainer==null){
      byojoContainer = new ACLabelContainer();
      byojoContainer.setFollowChildEnabled(true);
      byojoContainer.setVAlignment(VRLayout.CENTER);
      byojoContainer.add(getByojo(), null);
    }
    return byojoContainer;
  }

  /**
   * 病状経過等グループを取得します。
   * @return 病状経過等グループ
   */
  public ACGroupBox getByojiKeikaGroup(){
    if(byojiKeikaGroup==null){

      byojiKeikaGroup = new ACGroupBox();

      byojiKeikaGroup.setText("病状経過等(45×4)");

      byojiKeikaGroup.setHgap(0);

      byojiKeikaGroup.setLabelMargin(0);

      byojiKeikaGroup.setVgap(0);

      byojiKeikaGroup.setHgrid(0);

      addByojiKeikaGroup();
    }
    return byojiKeikaGroup;

  }

  /**
   * 病状経過パネルを取得します。
   * @return 病状経過パネル
   */
  public ACPanel getByojoKeikaPanel(){
    if(byojoKeikaPanel==null){

      byojoKeikaPanel = new ACPanel();

      byojoKeikaPanel.setHgap(0);

      byojoKeikaPanel.setLabelMargin(0);

      byojoKeikaPanel.setVgap(0);

      addByojoKeikaPanel();
    }
    return byojoKeikaPanel;

  }

  /**
   * 病状経過等を取得します。
   * @return 病状経過等
   */
  public ACTextArea getByojoKeika(){
    if(byojoKeika==null){

      byojoKeika = new ACTextArea();

      byojoKeika.setBindPath("CONDITION_PASSAGE");

      byojoKeika.setColumns(90);

      byojoKeika.setRows(5);

      byojoKeika.setMaxRows(4);

      byojoKeika.setIMEMode(InputSubset.KANJI);

      byojoKeika.setMaxLength(180);

      byojoKeika.setLineWrap(true);

      addByojoKeika();
    }
    return byojoKeika;

  }

  /**
   * 病状経過等コンテナを取得します。
   * @return 病状経過等コンテナ
   */
  protected ACLabelContainer getByojoKeikaContainer(){
    if(byojoKeikaContainer==null){
      byojoKeikaContainer = new ACLabelContainer();
      byojoKeikaContainer.setFollowChildEnabled(true);
      byojoKeikaContainer.setVAlignment(VRLayout.CENTER);
      byojoKeikaContainer.add(getByojoKeika(), null);
    }
    return byojoKeikaContainer;
  }

  /**
   * 介護サービスタブパネルを取得します。
   * @return 介護サービスタブパネル
   */
  public ACPanel getKyotakuPointsPane2(){
    if(kyotakuPointsPane2==null){

      kyotakuPointsPane2 = new ACPanel();

      addKyotakuPointsPane2();
    }
    return kyotakuPointsPane2;

  }

  /**
   * 介護サービスを利用する上での留意点・介護方法等グループを取得します。
   * @return 介護サービスを利用する上での留意点・介護方法等グループ
   */
  public ACGroupBox getKaigoServiceUseCheckGroup(){
    if(kaigoServiceUseCheckGroup==null){

      kaigoServiceUseCheckGroup = new ACGroupBox();

      kaigoServiceUseCheckGroup.setText("介護サービスを利用する上での留意点・介護方法等(45×4)");

      kaigoServiceUseCheckGroup.setHgap(0);

      kaigoServiceUseCheckGroup.setLabelMargin(0);

      kaigoServiceUseCheckGroup.setVgap(0);

      kaigoServiceUseCheckGroup.setHgrid(0);

      addKaigoServiceUseCheckGroup();
    }
    return kaigoServiceUseCheckGroup;

  }

  /**
   * 介護サービスを利用する上での留意点・介護方法等パネルを取得します。
   * @return 介護サービスを利用する上での留意点・介護方法等パネル
   */
  public ACPanel getKaigoServicePanel(){
    if(kaigoServicePanel==null){

      kaigoServicePanel = new ACPanel();

      kaigoServicePanel.setHgap(0);

      kaigoServicePanel.setLabelMargin(0);

      kaigoServicePanel.setVgap(0);

      addKaigoServicePanel();
    }
    return kaigoServicePanel;

  }

  /**
   * 介護サービスを利用する上での留意点・介護方法等を取得します。
   * @return 介護サービスを利用する上での留意点・介護方法等
   */
  public ACTextArea getKaigoServiceUseCheck(){
    if(kaigoServiceUseCheck==null){

      kaigoServiceUseCheck = new ACTextArea();

      kaigoServiceUseCheck.setBindPath("NOTE_OF_KAIGO_SERVICE");

      kaigoServiceUseCheck.setColumns(90);

      kaigoServiceUseCheck.setRows(5);

      kaigoServiceUseCheck.setMaxRows(4);

      kaigoServiceUseCheck.setIMEMode(InputSubset.KANJI);

      kaigoServiceUseCheck.setMaxLength(180);

      kaigoServiceUseCheck.setLineWrap(true);

      addKaigoServiceUseCheck();
    }
    return kaigoServiceUseCheck;

  }

  /**
   * 介護サービスを利用する上での留意点・介護方法等コンテナを取得します。
   * @return 介護サービスを利用する上での留意点・介護方法等コンテナ
   */
  protected ACLabelContainer getKaigoServiceUseCheckContainer(){
    if(kaigoServiceUseCheckContainer==null){
      kaigoServiceUseCheckContainer = new ACLabelContainer();
      kaigoServiceUseCheckContainer.setFollowChildEnabled(true);
      kaigoServiceUseCheckContainer.setVAlignment(VRLayout.CENTER);
      kaigoServiceUseCheckContainer.add(getKaigoServiceUseCheck(), null);
    }
    return kaigoServiceUseCheckContainer;
  }

  /**
   * 利用者の日常生活上の留意点グループを取得します。
   * @return 利用者の日常生活上の留意点グループ
   */
  public ACGroupBox getRyuitenGroup(){
    if(ryuitenGroup==null){

      ryuitenGroup = new ACGroupBox();

      ryuitenGroup.setText("利用者の日常生活上の留意点(45×4)");

      ryuitenGroup.setHgap(0);

      ryuitenGroup.setLabelMargin(0);

      ryuitenGroup.setVgap(0);

      ryuitenGroup.setHgrid(0);

      addRyuitenGroup();
    }
    return ryuitenGroup;

  }

  /**
   * 利用者の日常生活上の留意点パネルを取得します。
   * @return 利用者の日常生活上の留意点パネル
   */
  public ACPanel getRyuitenPanel(){
    if(ryuitenPanel==null){

      ryuitenPanel = new ACPanel();

      ryuitenPanel.setHgap(0);

      ryuitenPanel.setLabelMargin(0);

      ryuitenPanel.setVgap(0);

      addRyuitenPanel();
    }
    return ryuitenPanel;

  }

  /**
   * 利用者の日常生活上の留意点を取得します。
   * @return 利用者の日常生活上の留意点
   */
  public ACTextArea getRyuiten(){
    if(ryuiten==null){

      ryuiten = new ACTextArea();

      ryuiten.setBindPath("NOTE_OF_DAILY_LIFE");

      ryuiten.setColumns(90);

      ryuiten.setRows(5);

      ryuiten.setMaxRows(4);

      ryuiten.setIMEMode(InputSubset.KANJI);

      ryuiten.setMaxLength(180);

      ryuiten.setLineWrap(true);

      addRyuiten();
    }
    return ryuiten;

  }

  /**
   * 利用者の日常生活上の留意点コンテナを取得します。
   * @return 利用者の日常生活上の留意点コンテナ
   */
  protected ACLabelContainer getRyuitenContainer(){
    if(ryuitenContainer==null){
      ryuitenContainer = new ACLabelContainer();
      ryuitenContainer.setFollowChildEnabled(true);
      ryuitenContainer.setVAlignment(VRLayout.CENTER);
      ryuitenContainer.add(getRyuiten(), null);
    }
    return ryuitenContainer;
  }

  /**
   * 備考タブパネルを取得します。
   * @return 備考タブパネル
   */
  public ACPanel getKyotakuPointsPane3(){
    if(kyotakuPointsPane3==null){

      kyotakuPointsPane3 = new ACPanel();

      addKyotakuPointsPane3();
    }
    return kyotakuPointsPane3;

  }

  /**
   * 備考グループを取得します。
   * @return 備考グループ
   */
  public ACGroupBox getBikouGroup(){
    if(bikouGroup==null){

      bikouGroup = new ACGroupBox();

      bikouGroup.setText("備考(45×2)");

      bikouGroup.setHgap(0);

      bikouGroup.setLabelMargin(0);

      bikouGroup.setVgap(0);

      bikouGroup.setHgrid(0);

      addBikouGroup();
    }
    return bikouGroup;

  }

  /**
   * 領域パネルを取得します。
   * @return 領域パネル
   */
  public ACPanel getBikouPanel(){
    if(bikouPanel==null){

      bikouPanel = new ACPanel();

      bikouPanel.setHgap(0);

      bikouPanel.setLabelMargin(0);

      bikouPanel.setVgap(0);

      addBikouPanel();
    }
    return bikouPanel;

  }

  /**
   * 備考を取得します。
   * @return 備考
   */
  public ACTextArea getBikou(){
    if(bikou==null){

      bikou = new ACTextArea();

      bikou.setBindPath("REMARKS");

      bikou.setColumns(90);

      bikou.setRows(3);

      bikou.setMaxRows(2);

      bikou.setIMEMode(InputSubset.KANJI);

      bikou.setMaxLength(90);

      bikou.setLineWrap(true);

      addBikou();
    }
    return bikou;

  }

  /**
   * 備考コンテナを取得します。
   * @return 備考コンテナ
   */
  protected ACLabelContainer getBikouContainer(){
    if(bikouContainer==null){
      bikouContainer = new ACLabelContainer();
      bikouContainer.setFollowChildEnabled(true);
      bikouContainer.setVAlignment(VRLayout.CENTER);
      bikouContainer.add(getBikou(), null);
    }
    return bikouContainer;
  }

  /**
   * コンストラクタです。
   */
  public QC005Design() {

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

    contents.add(getPatients(), VRLayout.NORTH);

    contents.add(getTabsArea(), VRLayout.CLIENT);

  }

  /**
   * 対象年月領域に内部項目を追加します。
   */
  protected void addTargetDates(){

    targetDates.add(getTargetDateCaption(), VRLayout.FLOW);

    targetDates.add(getTargetDateLabel(), VRLayout.FLOW);

  }

  /**
   * 対象年月キャプションに内部項目を追加します。
   */
  protected void addTargetDateCaption(){

  }

  /**
   * 対象年月に内部項目を追加します。
   */
  protected void addTargetDateLabel(){

  }

  /**
   * 利用者情報領域に内部項目を追加します。
   */
  protected void addPatients(){

    patients.add(getPatients1(), VRLayout.NORTH);

    patients.add(getPatients2(), VRLayout.CLIENT);

  }

  /**
   * 利用者情報サブ領域1に内部項目を追加します。
   */
  protected void addPatients1(){

    patients1.add(getPatientNameContainer(), VRLayout.FLOW_INSETLINE);

    patients1.add(getPatientSexContainer(), VRLayout.FLOW);

    patients1.add(getPatientBirthContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    patients1.add(getJotaiCodeContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 利用者氏名に内部項目を追加します。
   */
  protected void addPatientName(){

  }

  /**
   * 性別に内部項目を追加します。
   */
  protected void addPatientSex(){

  }

  /**
   * 生年月日に内部項目を追加します。
   */
  protected void addPatientBirth(){

  }

  /**
   * 要介護認定に内部項目を追加します。
   */
  protected void addJotaiCode(){

  }

  /**
   * 要介護認定モデルに内部項目を追加します。
   */
  protected void addJotaiCodeModel(){

    getYokaigodoRadioItem1().setButtonIndex(1);

    getJotaiCodeModel().add(getYokaigodoRadioItem1());

    getYokaigodoRadioItem8().setButtonIndex(12);

    getJotaiCodeModel().add(getYokaigodoRadioItem8());

    getYokaigodoRadioItem9().setButtonIndex(13);

    getJotaiCodeModel().add(getYokaigodoRadioItem9());

    getYokaigodoRadioItem2().setButtonIndex(11);

    getJotaiCodeModel().add(getYokaigodoRadioItem2());

    getYokaigodoRadioItem3().setButtonIndex(21);

    getJotaiCodeModel().add(getYokaigodoRadioItem3());

    getYokaigodoRadioItem4().setButtonIndex(22);

    getJotaiCodeModel().add(getYokaigodoRadioItem4());

    getYokaigodoRadioItem5().setButtonIndex(23);

    getJotaiCodeModel().add(getYokaigodoRadioItem5());

    getYokaigodoRadioItem6().setButtonIndex(24);

    getJotaiCodeModel().add(getYokaigodoRadioItem6());

    getYokaigodoRadioItem7().setButtonIndex(25);

    getJotaiCodeModel().add(getYokaigodoRadioItem7());

  }

  /**
   * 自立に内部項目を追加します。
   */
  protected void addYokaigodoRadioItem1(){

  }

  /**
   * 要支援１に内部項目を追加します。
   */
  protected void addYokaigodoRadioItem8(){

  }

  /**
   * 要支援２に内部項目を追加します。
   */
  protected void addYokaigodoRadioItem9(){

  }

  /**
   * 経過的要介護に内部項目を追加します。
   */
  protected void addYokaigodoRadioItem2(){

  }

  /**
   * 要介護1に内部項目を追加します。
   */
  protected void addYokaigodoRadioItem3(){

  }

  /**
   * 要介護2に内部項目を追加します。
   */
  protected void addYokaigodoRadioItem4(){

  }

  /**
   * 要介護3に内部項目を追加します。
   */
  protected void addYokaigodoRadioItem5(){

  }

  /**
   * 要介護4に内部項目を追加します。
   */
  protected void addYokaigodoRadioItem6(){

  }

  /**
   * 要介護5に内部項目を追加します。
   */
  protected void addYokaigodoRadioItem7(){

  }

  /**
   * 利用者情報サブ領域2に内部項目を追加します。
   */
  protected void addPatients2(){

    patients2.add(getShogaiJiritsudoContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    patients2.add(getNinchishoJiritsudoContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    patients2.add(getPatientAddressContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    patients2.add(getPatientTelContena(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 障害老人日常生活自立度に内部項目を追加します。
   */
  protected void addShogaiJiritsudo(){

  }

  /**
   * 障害老人日常生活自立度モデルに内部項目を追加します。
   */
  protected void addShogaiJiritsudoModel(){

    getShogaiJiritsudoRadioItem1().setButtonIndex(1);

    getShogaiJiritsudoModel().add(getShogaiJiritsudoRadioItem1());

    getShogaiJiritsudoRadioItem2().setButtonIndex(2);

    getShogaiJiritsudoModel().add(getShogaiJiritsudoRadioItem2());

    getShogaiJiritsudoRadioItem3().setButtonIndex(3);

    getShogaiJiritsudoModel().add(getShogaiJiritsudoRadioItem3());

    getShogaiJiritsudoRadioItem4().setButtonIndex(4);

    getShogaiJiritsudoModel().add(getShogaiJiritsudoRadioItem4());

    getShogaiJiritsudoRadioItem5().setButtonIndex(5);

    getShogaiJiritsudoModel().add(getShogaiJiritsudoRadioItem5());

  }

  /**
   * 障害老人日常生活自立度1に内部項目を追加します。
   */
  protected void addShogaiJiritsudoRadioItem1(){

  }

  /**
   * 障害老人日常生活自立度2に内部項目を追加します。
   */
  protected void addShogaiJiritsudoRadioItem2(){

  }

  /**
   * 障害老人日常生活自立度3に内部項目を追加します。
   */
  protected void addShogaiJiritsudoRadioItem3(){

  }

  /**
   * 障害老人日常生活自立度4に内部項目を追加します。
   */
  protected void addShogaiJiritsudoRadioItem4(){

  }

  /**
   * 障害老人日常生活自立度5に内部項目を追加します。
   */
  protected void addShogaiJiritsudoRadioItem5(){

  }

  /**
   * 認知症老人日常生活自立度に内部項目を追加します。
   */
  protected void addNinchishoJiritsudo(){

  }

  /**
   * 認知症老人日常生活自立度モデルに内部項目を追加します。
   */
  protected void addNinchishoJiritsudoModel(){

    getNinchishoJiritsudoRadioItem1().setButtonIndex(1);

    getNinchishoJiritsudoModel().add(getNinchishoJiritsudoRadioItem1());

    getNinchishoJiritsudoRadioItem2().setButtonIndex(2);

    getNinchishoJiritsudoModel().add(getNinchishoJiritsudoRadioItem2());

    getNinchishoJiritsudoRadioItem3().setButtonIndex(3);

    getNinchishoJiritsudoModel().add(getNinchishoJiritsudoRadioItem3());

    getNinchishoJiritsudoRadioItem4().setButtonIndex(4);

    getNinchishoJiritsudoModel().add(getNinchishoJiritsudoRadioItem4());

    getNinchishoJiritsudoRadioItem5().setButtonIndex(5);

    getNinchishoJiritsudoModel().add(getNinchishoJiritsudoRadioItem5());

    getNinchishoJiritsudoRadioItem6().setButtonIndex(6);

    getNinchishoJiritsudoModel().add(getNinchishoJiritsudoRadioItem6());

  }

  /**
   * 認知症老人日常生活自立度1に内部項目を追加します。
   */
  protected void addNinchishoJiritsudoRadioItem1(){

  }

  /**
   * 認知症老人日常生活自立度2に内部項目を追加します。
   */
  protected void addNinchishoJiritsudoRadioItem2(){

  }

  /**
   * 認知症老人日常生活自立度3に内部項目を追加します。
   */
  protected void addNinchishoJiritsudoRadioItem3(){

  }

  /**
   * 認知症老人日常生活自立度4に内部項目を追加します。
   */
  protected void addNinchishoJiritsudoRadioItem4(){

  }

  /**
   * 認知症老人日常生活自立度5に内部項目を追加します。
   */
  protected void addNinchishoJiritsudoRadioItem5(){

  }

  /**
   * 認知症老人日常生活自立度6に内部項目を追加します。
   */
  protected void addNinchishoJiritsudoRadioItem6(){

  }

  /**
   * 利用者住所に内部項目を追加します。
   */
  protected void addPatientAddress(){

  }

  /**
   * (電話番号・コンテナ)に内部項目を追加します。
   */
  protected void addPatientTelContena(){

    patientTelContena.add(getPatientTel2(), VRLayout.FLOW);

    patientTelContena.add(getPatientTel3(), VRLayout.FLOW);

    patientTelContena.add(getPatientTel4(), VRLayout.FLOW);

    patientTelContena.add(getPatientTel5(), VRLayout.FLOW);

    patientTelContena.add(getPatientTel6(), VRLayout.FLOW);

  }

  /**
   * 電話番号・テキスト1に内部項目を追加します。
   */
  protected void addPatientTel2(){

  }

  /**
   * 電話番号・ラベル1に内部項目を追加します。
   */
  protected void addPatientTel3(){

  }

  /**
   * 電話番号・テキスト2に内部項目を追加します。
   */
  protected void addPatientTel4(){

  }

  /**
   * 電話番号・ラベル2に内部項目を追加します。
   */
  protected void addPatientTel5(){

  }

  /**
   * 電話番号・テキスト3に内部項目を追加します。
   */
  protected void addPatientTel6(){

  }

  /**
   * タブ領域に内部項目を追加します。
   */
  protected void addTabsArea(){

    tabsArea.addTab("医療機関情報", getProviderAndMedicaiInfoArea());

    tabsArea.addTab("在宅療養生活のポイント", getPoints());

    tabsArea.addTab("居宅療養管理指導書", getPoints2());

  }

  /**
   * 医療機関情報領域に内部項目を追加します。
   */
  protected void addProviderAndMedicaiInfoArea(){

    providerAndMedicaiInfoArea.add(getMedicalInfoGroup(), VRLayout.NORTH);

  }

  /**
   * 医療機関グループに内部項目を追加します。
   */
  protected void addMedicalInfoGroup(){

    medicalInfoGroup.add(getMedicalInstitusionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalInfoGroup.add(getMedicalAddressContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalInfoGroup.add(getMedicalTelContena(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalInfoGroup.add(getDoctorNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 医療機関名に内部項目を追加します。
   */
  protected void addMedicalInstitusion(){

  }

  /**
   * 医療機関名モデルに内部項目を追加します。
   */
  protected void addMedicalInstitusionModel(){

  }

  /**
   * 医療機関住所に内部項目を追加します。
   */
  protected void addMedicalAddress(){

  }

  /**
   * 医療機関電話番号・コンテナに内部項目を追加します。
   */
  protected void addMedicalTelContena(){

    medicalTelContena.add(getMedicalTel2(), VRLayout.FLOW);

    medicalTelContena.add(getMedicalTel3(), VRLayout.FLOW);

    medicalTelContena.add(getMedicalTel4(), VRLayout.FLOW);

    medicalTelContena.add(getMedicalTel5(), VRLayout.FLOW);

    medicalTelContena.add(getMedicalTel6(), VRLayout.FLOW);

  }

  /**
   * 電話番号・テキスト1に内部項目を追加します。
   */
  protected void addMedicalTel2(){

  }

  /**
   * 電話番号・ラベル1に内部項目を追加します。
   */
  protected void addMedicalTel3(){

  }

  /**
   * 電話番号・テキスト2に内部項目を追加します。
   */
  protected void addMedicalTel4(){

  }

  /**
   * 電話番号・ラベル2に内部項目を追加します。
   */
  protected void addMedicalTel5(){

  }

  /**
   * 電話番号・テキスト3に内部項目を追加します。
   */
  protected void addMedicalTel6(){

  }

  /**
   * 担当医氏名に内部項目を追加します。
   */
  protected void addDoctorName(){

  }

  /**
   * Tab1「在宅療養生活のポイント」に内部項目を追加します。
   */
  protected void addPoints(){

    points.add(getPoints1(), VRLayout.NORTH);

  }

  /**
   * Tab1・在宅療養生活のポイント・サブ領域1に内部項目を追加します。
   */
  protected void addPoints1(){

    points1.add(getYourDoctorCaption1(), VRLayout.FLOW);

    points1.add(getYourDoctor(), VRLayout.FLOW);

    points1.add(getYourDoctorCaption2(), VRLayout.FLOW_RETURN);

    points1.add(getCreateDateZaitakuContainer(), VRLayout.FLOW_RETURN);

    points1.add(getVisitThisMonthContainer(), VRLayout.FLOW_INSETLINE);

    points1.add(getResultReadButton(), VRLayout.FLOW_INSETLINE_RETURN);

    points1.add(getVisitNextMonthContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    points1.add(getAdviceContainer(), VRLayout.FLOW_RETURN);

  }

  /**
   * あなたの主治医キャプションに内部項目を追加します。
   */
  protected void addYourDoctorCaption1(){

  }

  /**
   * あなたの主治医に内部項目を追加します。
   */
  protected void addYourDoctor(){

  }

  /**
   * あなたの主治医キャプションに内部項目を追加します。
   */
  protected void addYourDoctorCaption2(){

  }

  /**
   * 在宅療養生活のポイント作成年月日に内部項目を追加します。
   */
  protected void addCreateDateZaitaku(){

  }

  /**
   * 今月の訪問日コンテナに内部項目を追加します。
   */
  protected void addVisitThisMonthContainer(){

    visitThisMonthContainer.add(getVisitThisMonth1(), null);

    visitThisMonthContainer.add(getVisitThisMonth2(), null);

    visitThisMonthContainer.add(getVisitThisMonth3(), null);

    visitThisMonthContainer.add(getVisitThisMonth4(), null);

    visitThisMonthContainer.add(getVisitThisMonth5(), null);

    visitThisMonthContainer.add(getVisitThisMonth6(), null);

    visitThisMonthContainer.add(getVisitThisMonthCaption(), null);

  }

  /**
   * 今月の訪問日1に内部項目を追加します。
   */
  protected void addVisitThisMonth1(){

  }

  /**
   * 今月の訪問日2に内部項目を追加します。
   */
  protected void addVisitThisMonth2(){

  }

  /**
   * 今月の訪問日3に内部項目を追加します。
   */
  protected void addVisitThisMonth3(){

  }

  /**
   * 今月の訪問日4に内部項目を追加します。
   */
  protected void addVisitThisMonth4(){

  }

  /**
   * 今月の訪問日5に内部項目を追加します。
   */
  protected void addVisitThisMonth5(){

  }

  /**
   * 今月の訪問日6に内部項目を追加します。
   */
  protected void addVisitThisMonth6(){

  }

  /**
   * 今月の訪問日キャプションに内部項目を追加します。
   */
  protected void addVisitThisMonthCaption(){

  }

  /**
   * 実績読込みボタンに内部項目を追加します。
   */
  protected void addResultReadButton(){

  }

  /**
   * 来月の訪問日コンテナに内部項目を追加します。
   */
  protected void addVisitNextMonthContainer(){

    visitNextMonthContainer.add(getVisitNextMonth1(), null);

    visitNextMonthContainer.add(getVisitNextMonth2(), null);

    visitNextMonthContainer.add(getVisitNextMonth3(), null);

    visitNextMonthContainer.add(getVisitNextMonth4(), null);

    visitNextMonthContainer.add(getVisitNextMonth5(), null);

    visitNextMonthContainer.add(getVisitNextMonth6(), null);

    visitNextMonthContainer.add(getVisitNextMonthCaption(), null);

  }

  /**
   * 来月の訪問予定1に内部項目を追加します。
   */
  protected void addVisitNextMonth1(){

  }

  /**
   * 来月の訪問予定2に内部項目を追加します。
   */
  protected void addVisitNextMonth2(){

  }

  /**
   * 来月の訪問予定3に内部項目を追加します。
   */
  protected void addVisitNextMonth3(){

  }

  /**
   * 来月の訪問予定4に内部項目を追加します。
   */
  protected void addVisitNextMonth4(){

  }

  /**
   * 来月の訪問予定5に内部項目を追加します。
   */
  protected void addVisitNextMonth5(){

  }

  /**
   * 来月の訪問予定6に内部項目を追加します。
   */
  protected void addVisitNextMonth6(){

  }

  /**
   * 来月の訪問予定キャプションに内部項目を追加します。
   */
  protected void addVisitNextMonthCaption(){

  }

  /**
   * アドバイスコンテナに内部項目を追加します。
   */
  protected void addAdviceContainer(){

    adviceContainer.add(getAdvices(), null);

  }

  /**
   * アドバイスコンテナレイアウトに内部項目を追加します。
   */
  protected void addAdviceContainerLayout(){

  }

  /**
   * アドバイス領域に内部項目を追加します。
   */
  protected void addAdvices(){

    advices.add(getAdvicdHeaders(), VRLayout.NORTH);

    advices.add(getAdvice(), VRLayout.FLOW);

  }

  /**
   * アドバイス・上部に内部項目を追加します。
   */
  protected void addAdvicdHeaders(){

    advicdHeaders.add(getAdviceMonth(), VRLayout.WEST);

    advicdHeaders.add(getAdviceMonthCaption(), VRLayout.WEST);

    advicdHeaders.add(getAdviceLength(), VRLayout.EAST);
  }

  /**
   * ○月のアドバイスに内部項目を追加します。
   */
  protected void addAdviceMonth(){

  }

  /**
   * ○月のアドバイスキャプションに内部項目を追加します。
   */
  protected void addAdviceMonthCaption(){

  }

  /**
   * アドバイス・長さに内部項目を追加します。
   */
  protected void addAdviceLength(){

  }

  /**
   * アドバイス・本文に内部項目を追加します。
   */
  protected void addAdvice(){

  }

  /**
   * Tab2「居宅療養管理指導書」に内部項目を追加します。
   */
  protected void addPoints2(){

    points2.add(getKyotakuPoints(), VRLayout.CLIENT);

  }

  /**
   * 居宅療養管理指導書内部タブに内部項目を追加します。
   */
  protected void addKyotakuPoints(){

    kyotakuPoints.addTab("病状・病状経過等", getKyotakuPointsPanel1());

    kyotakuPoints.addTab("介護留意点・介護方法・日常生活上の留意点", getKyotakuPointsPane2());

    kyotakuPoints.addTab("備考", getKyotakuPointsPane3());

  }

  /**
   * 病状タブパネルに内部項目を追加します。
   */
  protected void addKyotakuPointsPanel1(){

    kyotakuPointsPanel1.add(getProviderInfoGroup(), VRLayout.NORTH);

    kyotakuPointsPanel1.add(getByojoGroup(), VRLayout.NORTH);

    kyotakuPointsPanel1.add(getByojiKeikaGroup(), VRLayout.NORTH);

  }

  /**
   * 事業所グループに内部項目を追加します。
   */
  protected void addProviderInfoGroup(){

    providerInfoGroup.add(getCreateDateKyotakuContainer(), VRLayout.FLOW_RETURN);

    providerInfoGroup.add(getSenmoninContainer(), VRLayout.FLOW);

    providerInfoGroup.add(getProviderNameContainer(), VRLayout.FLOW);

  }

  /**
   * 居宅療養管理指導書・作成年月日に内部項目を追加します。
   */
  protected void addCreateDateKyotaku(){

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
   * 病状グループに内部項目を追加します。
   */
  protected void addByojoGroup(){

    byojoGroup.add(getByojoPanel(), VRLayout.FLOW);

  }

  /**
   * 病状パネルに内部項目を追加します。
   */
  protected void addByojoPanel(){

    byojoPanel.add(getByojoContainer(), VRLayout.FLOW);

  }

  /**
   * 病状に内部項目を追加します。
   */
  protected void addByojo(){

  }

  /**
   * 病状経過等グループに内部項目を追加します。
   */
  protected void addByojiKeikaGroup(){

    byojiKeikaGroup.add(getByojoKeikaPanel(), VRLayout.FLOW);

  }

  /**
   * 病状経過パネルに内部項目を追加します。
   */
  protected void addByojoKeikaPanel(){

    byojoKeikaPanel.add(getByojoKeikaContainer(), VRLayout.FLOW);

  }

  /**
   * 病状経過等に内部項目を追加します。
   */
  protected void addByojoKeika(){

  }

  /**
   * 介護サービスタブパネルに内部項目を追加します。
   */
  protected void addKyotakuPointsPane2(){

    kyotakuPointsPane2.add(getKaigoServiceUseCheckGroup(), VRLayout.NORTH);

    kyotakuPointsPane2.add(getRyuitenGroup(), VRLayout.NORTH);

  }

  /**
   * 介護サービスを利用する上での留意点・介護方法等グループに内部項目を追加します。
   */
  protected void addKaigoServiceUseCheckGroup(){

    kaigoServiceUseCheckGroup.add(getKaigoServicePanel(), VRLayout.FLOW);

  }

  /**
   * 介護サービスを利用する上での留意点・介護方法等パネルに内部項目を追加します。
   */
  protected void addKaigoServicePanel(){

    kaigoServicePanel.add(getKaigoServiceUseCheckContainer(), VRLayout.FLOW);

  }

  /**
   * 介護サービスを利用する上での留意点・介護方法等に内部項目を追加します。
   */
  protected void addKaigoServiceUseCheck(){

  }

  /**
   * 利用者の日常生活上の留意点グループに内部項目を追加します。
   */
  protected void addRyuitenGroup(){

    ryuitenGroup.add(getRyuitenPanel(), VRLayout.FLOW);

  }

  /**
   * 利用者の日常生活上の留意点パネルに内部項目を追加します。
   */
  protected void addRyuitenPanel(){

    ryuitenPanel.add(getRyuitenContainer(), VRLayout.FLOW);

  }

  /**
   * 利用者の日常生活上の留意点に内部項目を追加します。
   */
  protected void addRyuiten(){

  }

  /**
   * 備考タブパネルに内部項目を追加します。
   */
  protected void addKyotakuPointsPane3(){

    kyotakuPointsPane3.add(getBikouGroup(), VRLayout.NORTH);

  }

  /**
   * 備考グループに内部項目を追加します。
   */
  protected void addBikouGroup(){

    bikouGroup.add(getBikouPanel(), VRLayout.FLOW);

  }

  /**
   * 領域パネルに内部項目を追加します。
   */
  protected void addBikouPanel(){

    bikouPanel.add(getBikouContainer(), VRLayout.FLOW);

  }

  /**
   * 備考に内部項目を追加します。
   */
  protected void addBikou(){

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
      ACFrame.debugStart(new ACAffairInfo(QC005Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QC005Design getThis() {
    return this;
  }
}
