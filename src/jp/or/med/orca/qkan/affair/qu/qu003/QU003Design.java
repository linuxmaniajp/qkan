
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
 * 作成日: 2006/10/02  日本コンピューター株式会社 樋口雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 利用者登録/修正 (U)
 * プロセス 利用者登録 (003)
 * プログラム 医療看護情報 (QU003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu003;
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
 * 医療看護情報画面項目デザイン(QU003) 
 */
public class QU003Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton insert;

  private ACAffairButton update;

  private ACPanel contents;

  private ACPanel patientInfo;

  private ACLabel patientNameCaption;

  private ACLabel patientName;

  private JTabbedPane tabs;

  private ACPanel point1;

  private ACPanel medicalInfos;

  private ACClearableRadioButtonGroup medicalInfoInsuranceVarietyRadio1;

  private ACLabelContainer medicalInfoInsuranceVarietyRadio1Container;

  private ACListModelAdapter medicalInfoInsuranceVarietyRadio1Model;

  private ACRadioButtonItem medicalInfoInsuranceVarietyRadio1Item1;

  private ACRadioButtonItem medicalInfoInsuranceVarietyRadio1Item2;

  private ACRadioButtonItem medicalInfoInsuranceVarietyRadio1Item3;

  private ACClearableRadioButtonGroup medicalInfoInsuranceVarietyRadio2;

  private ACLabelContainer medicalInfoInsuranceVarietyRadio2Container;

  private ACListModelAdapter medicalInfoInsuranceVarietyRadio2Model;

  private ACRadioButtonItem medicalInfoInsuranceVarietyRadio2Item1;

  private ACRadioButtonItem medicalInfoInsuranceVarietyRadio2Item2;

  private ACClearableRadioButtonGroup medicalInfoPersonAndFamilyRadio;

  private ACLabelContainer medicalInfoPersonAndFamilyRadioContainer;

  private ACListModelAdapter medicalInfoPersonAndFamilyRadioModel;

  private ACRadioButtonItem medicalInfoPersonAndFamilyRadioItem1;

  private ACRadioButtonItem medicalInfoPersonAndFamilyRadioItem2;

  private ACRadioButtonItem medicalInfoPersonAndFamilyRadioItem3;

  private ACClearableRadioButtonGroup medicalInfoOld9AndOld8Radio;

  private ACLabelContainer medicalInfoOld9AndOld8RadioContainer;

  private ACListModelAdapter medicalInfoOld9AndOld8RadioModel;

  private ACRadioButtonItem medicalInfoOld9AndOld8RadioItem1;

  private ACRadioButtonItem medicalInfoOld9AndOld8RadioItem2;

  private ACRadioButtonItem medicalInfoOld9AndOld8RadioItem3;

  private ACLabelContainer medicalInfoInsurerNoContena;

  private ACTextField medicalInfoInsurerLawNo;

  private ACTextField medicalInfoInsurerNo;

  private ACComboBox medicalInfoInsurerName;

  private ACLabelContainer medicalInfoInsurerNameContainer;

  private ACComboBoxModelAdapter medicalInfoInsurerNameModel;

  private ACTextField medicalInfoMark;

  private ACLabelContainer medicalInfoMarkContainer;

  private ACLabelContainer medicalInfoValidLimitContena;

  private QkanDateTextField medicalInfoValidLimit1;

  private ACLabel medicalInfoValidLimitLabel;

  private QkanDateTextField medicalInfoValidLimit2;

  private ACLabelContainer medicalInfoProvideContena;

  private ACLabel medicalInfoProvideLabel1;

  private ACComboBox medicalInfoProvide;

  private ACComboBoxModelAdapter medicalInfoProvideModel;

  private ACLabel medicalInfoProvideLabel2;

  private ACLabelContainer medicalInfoCitiesNoContena;

  private ACTextField medicalInfoCitiesLawNo;

  private ACTextField medicalInfoCitiesNo;

  private ACComboBox medicalInfoCitiesName;

  private ACLabelContainer medicalInfoCitiesNameContainer;

  private ACComboBoxModelAdapter medicalInfoCitiesNameModel;

  private ACTextField medicalInfoOldPersonReceiptNo;

  private ACLabelContainer medicalInfoOldPersonReceiptNoContainer;

  private ACPanel medicalInfoButtons;

  private ACButton medicalInfoButtonClear;

  private ACButton medicalInfoButtonInsert;

  private ACButton medicalInfoButtonConpile;

  private ACButton medicalInfoButtonDelete;

  private ACTable medicalInfoTable;

  private VRTableColumnModel medicalInfoTableColumnModel;

  private ACTableColumn medicalInfoTableColumn0;

  private ACTableColumn medicalInfoTableColumn1;

  private ACTableColumn medicalInfoTableColumn2;

  private ACTableColumn medicalInfoTableColumn3;

  private ACTableColumn medicalInfoTableColumn4;

  private ACTableColumn medicalInfoTableColumn5;

  private ACTableColumn medicalInfoTableColumn6;

  private ACTableColumn medicalInfoTableColumn7;

  private ACTableColumn medicalInfoTableColumn8;

  private ACTableColumn medicalInfoTableColumn9;

  private ACTableColumn medicalInfoTableColumn10;

  private ACTableColumn medicalInfoTableColumn11;

  private ACPanel point2;

  private ACGroupBox callNursePatients;

  private ACTextArea callNurseMindState;

  private ACLabelContainer callNurseMindStateContainer;

  private ACTextArea callNurseMainDiseaseName;

  private ACLabelContainer callNurseMainDiseaseNameContainer;

  private ACClearableRadioButtonGroup callNurseInsuranceRadio;

  private ACLabelContainer callNurseInsuranceRadioContainer;

  private ACListModelAdapter callNurseInsuranceRadioModel;

  private ACRadioButtonItem callNurseInsuranceRadioItem1;

  private ACRadioButtonItem callNurseInsuranceRadioItem2;

  private ACLabel callNurseOfficialSpace1;

  private ACClearableRadioButtonGroup callNurseOfficialRadio;

  private ACLabelContainer callNurseOfficialRadioContainer;

  private ACListModelAdapter callNurseOfficialRadioModel;

  private ACRadioButtonItem callNurseOfficialRadioItem1;

  private ACRadioButtonItem callNurseOfficialRadioItem2;

  private ACRadioButtonItem callNurseOfficialRadioItem3;

  private ACLabel callNurseOfficialSpace2;

  private ACClearableRadioButtonGroup callNurseAddParticularRadio;

  private ACLabelContainer callNurseAddParticularRadioContainer;

  private ACListModelAdapter callNurseAddParticularRadioModel;

  private ACRadioButtonItem callNurseAddParticularRadioItem1;

  private ACRadioButtonItem callNurseAddParticularRadioItem2;

  private ACTextField callNurseCallTime;

  private ACLabelContainer callNurseCallTimeContainer;

  private ACGroupBox instructInfos;

  private ACLabelContainer instructInfoValidLimitContena;

  private ACPanel instructInfoValidLimitPanel1;

  private QkanDateTextField instructInfoValidLimit1;

  private ACLabel instructInfoValidLimitLabel;

  private QkanDateTextField instructInfoValidLimit2;

  private ACLabelContainer specialInstructContena;

  private ACPanel specialInstructPanel1;

  private QkanDateTextField specialInstruct1;

  private ACLabel specialInstructLabel1;

  private QkanDateTextField specialInstruct2;

  private ACPanel specialInstructPanel2;

  private ACButton specialInstructButton2;

  private ACLabel specialInstructCommentSpace1;

  private ACLabel specialInstructComment1;

  private ACLabel specialInstructCommentSpace2;

  private ACLabel specialInstructComment2;

  private ACGroupBox medicalTreatmentInfos;

  private ACPanel medicalTreatmentBasicInfos;

  private ACComboBox medicalTreatmentInfoOrgan;

  private ACLabelContainer medicalTreatmentInfoOrganContainer;

  private ACComboBoxModelAdapter medicalTreatmentInfoOrganModel;

  private ACTextField medicalTreatmentInfoZip;

  private ACLabelContainer medicalTreatmentInfoZipContainer;

  private ACTextField medicalTreatmentInfoAddress;

  private ACLabelContainer medicalTreatmentInfoAddressContainer;

  private ACTextField medicalTreatmentInfoTel;

  private ACLabelContainer medicalTreatmentInfoTelContainer;

  private ACTextField medicalTreatmentInfoFax;

  private ACLabelContainer medicalTreatmentInfoFaxContainer;

  private ACTextField medicalTreatmentInfoMainDoctorName;

  private ACLabelContainer medicalTreatmentInfoMainDoctorNameContainer;

  //getter

  /**
   * 業務ボタンバーを取得します。
   * @return 業務ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("医療看護情報");

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
   * 医療保険領域を取得します。
   * @return 医療保険領域
   */
  public ACPanel getPoint1(){
    if(point1==null){

      point1 = new ACPanel();

      addPoint1();
    }
    return point1;

  }

  /**
   * 医療保険領域・情報を取得します。
   * @return 医療保険領域・情報
   */
  public ACPanel getMedicalInfos(){
    if(medicalInfos==null){

      medicalInfos = new ACPanel();

      medicalInfos.setAutoWrap(false);

      addMedicalInfos();
    }
    return medicalInfos;

  }

  /**
   * 保険種類・上を取得します。
   * @return 保険種類・上
   */
  public ACClearableRadioButtonGroup getMedicalInfoInsuranceVarietyRadio1(){
    if(medicalInfoInsuranceVarietyRadio1==null){

      medicalInfoInsuranceVarietyRadio1 = new ACClearableRadioButtonGroup();

      getMedicalInfoInsuranceVarietyRadio1Container().setText("保険種類");

      medicalInfoInsuranceVarietyRadio1.setBindPath("INSURE_TYPE");

      medicalInfoInsuranceVarietyRadio1.setUseClearButton(false);

      medicalInfoInsuranceVarietyRadio1.setModel(getMedicalInfoInsuranceVarietyRadio1Model());

      addMedicalInfoInsuranceVarietyRadio1();
    }
    return medicalInfoInsuranceVarietyRadio1;

  }

  /**
   * 保険種類・上コンテナを取得します。
   * @return 保険種類・上コンテナ
   */
  protected ACLabelContainer getMedicalInfoInsuranceVarietyRadio1Container(){
    if(medicalInfoInsuranceVarietyRadio1Container==null){
      medicalInfoInsuranceVarietyRadio1Container = new ACLabelContainer();
      medicalInfoInsuranceVarietyRadio1Container.setFollowChildEnabled(true);
      medicalInfoInsuranceVarietyRadio1Container.setVAlignment(VRLayout.CENTER);
      medicalInfoInsuranceVarietyRadio1Container.add(getMedicalInfoInsuranceVarietyRadio1(), null);
    }
    return medicalInfoInsuranceVarietyRadio1Container;
  }

  /**
   * 保険種類・上モデルを取得します。
   * @return 保険種類・上モデル
   */
  protected ACListModelAdapter getMedicalInfoInsuranceVarietyRadio1Model(){
    if(medicalInfoInsuranceVarietyRadio1Model==null){
      medicalInfoInsuranceVarietyRadio1Model = new ACListModelAdapter();
      addMedicalInfoInsuranceVarietyRadio1Model();
    }
    return medicalInfoInsuranceVarietyRadio1Model;
  }

  /**
   * 社保を取得します。
   * @return 社保
   */
  public ACRadioButtonItem getMedicalInfoInsuranceVarietyRadio1Item1(){
    if(medicalInfoInsuranceVarietyRadio1Item1==null){

      medicalInfoInsuranceVarietyRadio1Item1 = new ACRadioButtonItem();

      medicalInfoInsuranceVarietyRadio1Item1.setText("社保");

      medicalInfoInsuranceVarietyRadio1Item1.setGroup(getMedicalInfoInsuranceVarietyRadio1());

      medicalInfoInsuranceVarietyRadio1Item1.setConstraints(VRLayout.FLOW);

      addMedicalInfoInsuranceVarietyRadio1Item1();
    }
    return medicalInfoInsuranceVarietyRadio1Item1;

  }

  /**
   * 国保を取得します。
   * @return 国保
   */
  public ACRadioButtonItem getMedicalInfoInsuranceVarietyRadio1Item2(){
    if(medicalInfoInsuranceVarietyRadio1Item2==null){

      medicalInfoInsuranceVarietyRadio1Item2 = new ACRadioButtonItem();

      medicalInfoInsuranceVarietyRadio1Item2.setText("国保");

      medicalInfoInsuranceVarietyRadio1Item2.setGroup(getMedicalInfoInsuranceVarietyRadio1());

      medicalInfoInsuranceVarietyRadio1Item2.setConstraints(VRLayout.FLOW);

      addMedicalInfoInsuranceVarietyRadio1Item2();
    }
    return medicalInfoInsuranceVarietyRadio1Item2;

  }

  /**
   * 公費を取得します。
   * @return 公費
   */
  public ACRadioButtonItem getMedicalInfoInsuranceVarietyRadio1Item3(){
    if(medicalInfoInsuranceVarietyRadio1Item3==null){

      medicalInfoInsuranceVarietyRadio1Item3 = new ACRadioButtonItem();

      medicalInfoInsuranceVarietyRadio1Item3.setText("公費");

      medicalInfoInsuranceVarietyRadio1Item3.setGroup(getMedicalInfoInsuranceVarietyRadio1());

      medicalInfoInsuranceVarietyRadio1Item3.setConstraints(VRLayout.FLOW);

      addMedicalInfoInsuranceVarietyRadio1Item3();
    }
    return medicalInfoInsuranceVarietyRadio1Item3;

  }

  /**
   * 保険種類・下を取得します。
   * @return 保険種類・下
   */
  public ACClearableRadioButtonGroup getMedicalInfoInsuranceVarietyRadio2(){
    if(medicalInfoInsuranceVarietyRadio2==null){

      medicalInfoInsuranceVarietyRadio2 = new ACClearableRadioButtonGroup();

      medicalInfoInsuranceVarietyRadio2.setBindPath("OLD_FLAG");

      medicalInfoInsuranceVarietyRadio2.setModel(getMedicalInfoInsuranceVarietyRadio2Model());

      addMedicalInfoInsuranceVarietyRadio2();
    }
    return medicalInfoInsuranceVarietyRadio2;

  }

  /**
   * 保険種類・下コンテナを取得します。
   * @return 保険種類・下コンテナ
   */
  protected ACLabelContainer getMedicalInfoInsuranceVarietyRadio2Container(){
    if(medicalInfoInsuranceVarietyRadio2Container==null){
      medicalInfoInsuranceVarietyRadio2Container = new ACLabelContainer();
      medicalInfoInsuranceVarietyRadio2Container.setFollowChildEnabled(true);
      medicalInfoInsuranceVarietyRadio2Container.setVAlignment(VRLayout.CENTER);
      medicalInfoInsuranceVarietyRadio2Container.add(getMedicalInfoInsuranceVarietyRadio2(), null);
    }
    return medicalInfoInsuranceVarietyRadio2Container;
  }

  /**
   * 保険種類・下モデルを取得します。
   * @return 保険種類・下モデル
   */
  protected ACListModelAdapter getMedicalInfoInsuranceVarietyRadio2Model(){
    if(medicalInfoInsuranceVarietyRadio2Model==null){
      medicalInfoInsuranceVarietyRadio2Model = new ACListModelAdapter();
      addMedicalInfoInsuranceVarietyRadio2Model();
    }
    return medicalInfoInsuranceVarietyRadio2Model;
  }

  /**
   * 老人を取得します。
   * @return 老人
   */
  public ACRadioButtonItem getMedicalInfoInsuranceVarietyRadio2Item1(){
    if(medicalInfoInsuranceVarietyRadio2Item1==null){

      medicalInfoInsuranceVarietyRadio2Item1 = new ACRadioButtonItem();

      medicalInfoInsuranceVarietyRadio2Item1.setText("老人");

      medicalInfoInsuranceVarietyRadio2Item1.setGroup(getMedicalInfoInsuranceVarietyRadio2());

      medicalInfoInsuranceVarietyRadio2Item1.setConstraints(VRLayout.FLOW);

      addMedicalInfoInsuranceVarietyRadio2Item1();
    }
    return medicalInfoInsuranceVarietyRadio2Item1;

  }

  /**
   * 退職者を取得します。
   * @return 退職者
   */
  public ACRadioButtonItem getMedicalInfoInsuranceVarietyRadio2Item2(){
    if(medicalInfoInsuranceVarietyRadio2Item2==null){

      medicalInfoInsuranceVarietyRadio2Item2 = new ACRadioButtonItem();

      medicalInfoInsuranceVarietyRadio2Item2.setText("退職者");

      medicalInfoInsuranceVarietyRadio2Item2.setGroup(getMedicalInfoInsuranceVarietyRadio2());

      medicalInfoInsuranceVarietyRadio2Item2.setConstraints(VRLayout.FLOW);

      addMedicalInfoInsuranceVarietyRadio2Item2();
    }
    return medicalInfoInsuranceVarietyRadio2Item2;

  }

  /**
   * 本人/家族を取得します。
   * @return 本人/家族
   */
  public ACClearableRadioButtonGroup getMedicalInfoPersonAndFamilyRadio(){
    if(medicalInfoPersonAndFamilyRadio==null){

      medicalInfoPersonAndFamilyRadio = new ACClearableRadioButtonGroup();

      getMedicalInfoPersonAndFamilyRadioContainer().setText("本人/家族");

      medicalInfoPersonAndFamilyRadio.setBindPath("SELF_FLAG");

      medicalInfoPersonAndFamilyRadio.setUseClearButton(true);

      medicalInfoPersonAndFamilyRadio.setModel(getMedicalInfoPersonAndFamilyRadioModel());

      addMedicalInfoPersonAndFamilyRadio();
    }
    return medicalInfoPersonAndFamilyRadio;

  }

  /**
   * 本人/家族コンテナを取得します。
   * @return 本人/家族コンテナ
   */
  protected ACLabelContainer getMedicalInfoPersonAndFamilyRadioContainer(){
    if(medicalInfoPersonAndFamilyRadioContainer==null){
      medicalInfoPersonAndFamilyRadioContainer = new ACLabelContainer();
      medicalInfoPersonAndFamilyRadioContainer.setFollowChildEnabled(true);
      medicalInfoPersonAndFamilyRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalInfoPersonAndFamilyRadioContainer.add(getMedicalInfoPersonAndFamilyRadio(), null);
    }
    return medicalInfoPersonAndFamilyRadioContainer;
  }

  /**
   * 本人/家族モデルを取得します。
   * @return 本人/家族モデル
   */
  protected ACListModelAdapter getMedicalInfoPersonAndFamilyRadioModel(){
    if(medicalInfoPersonAndFamilyRadioModel==null){
      medicalInfoPersonAndFamilyRadioModel = new ACListModelAdapter();
      addMedicalInfoPersonAndFamilyRadioModel();
    }
    return medicalInfoPersonAndFamilyRadioModel;
  }

  /**
   * 本人を取得します。
   * @return 本人
   */
  public ACRadioButtonItem getMedicalInfoPersonAndFamilyRadioItem1(){
    if(medicalInfoPersonAndFamilyRadioItem1==null){

      medicalInfoPersonAndFamilyRadioItem1 = new ACRadioButtonItem();

      medicalInfoPersonAndFamilyRadioItem1.setText("本人");

      medicalInfoPersonAndFamilyRadioItem1.setGroup(getMedicalInfoPersonAndFamilyRadio());

      medicalInfoPersonAndFamilyRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalInfoPersonAndFamilyRadioItem1();
    }
    return medicalInfoPersonAndFamilyRadioItem1;

  }

  /**
   * 3歳を取得します。
   * @return 3歳
   */
  public ACRadioButtonItem getMedicalInfoPersonAndFamilyRadioItem2(){
    if(medicalInfoPersonAndFamilyRadioItem2==null){

      medicalInfoPersonAndFamilyRadioItem2 = new ACRadioButtonItem();

      medicalInfoPersonAndFamilyRadioItem2.setText("3歳");

      medicalInfoPersonAndFamilyRadioItem2.setGroup(getMedicalInfoPersonAndFamilyRadio());

      medicalInfoPersonAndFamilyRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalInfoPersonAndFamilyRadioItem2();
    }
    return medicalInfoPersonAndFamilyRadioItem2;

  }

  /**
   * 家族を取得します。
   * @return 家族
   */
  public ACRadioButtonItem getMedicalInfoPersonAndFamilyRadioItem3(){
    if(medicalInfoPersonAndFamilyRadioItem3==null){

      medicalInfoPersonAndFamilyRadioItem3 = new ACRadioButtonItem();

      medicalInfoPersonAndFamilyRadioItem3.setText("家族");

      medicalInfoPersonAndFamilyRadioItem3.setGroup(getMedicalInfoPersonAndFamilyRadio());

      medicalInfoPersonAndFamilyRadioItem3.setConstraints(VRLayout.FLOW);

      addMedicalInfoPersonAndFamilyRadioItem3();
    }
    return medicalInfoPersonAndFamilyRadioItem3;

  }

  /**
   * 高齢割合を取得します。
   * @return 高齢割合
   */
  public ACClearableRadioButtonGroup getMedicalInfoOld9AndOld8Radio(){
    if(medicalInfoOld9AndOld8Radio==null){

      medicalInfoOld9AndOld8Radio = new ACClearableRadioButtonGroup();

      medicalInfoOld9AndOld8Radio.setBindPath("OLD_RATE_FLAG");

      medicalInfoOld9AndOld8Radio.setUseClearButton(true);

      medicalInfoOld9AndOld8Radio.setModel(getMedicalInfoOld9AndOld8RadioModel());

      addMedicalInfoOld9AndOld8Radio();
    }
    return medicalInfoOld9AndOld8Radio;

  }

  /**
   * 高齢割合コンテナを取得します。
   * @return 高齢割合コンテナ
   */
  protected ACLabelContainer getMedicalInfoOld9AndOld8RadioContainer(){
    if(medicalInfoOld9AndOld8RadioContainer==null){
      medicalInfoOld9AndOld8RadioContainer = new ACLabelContainer();
      medicalInfoOld9AndOld8RadioContainer.setFollowChildEnabled(true);
      medicalInfoOld9AndOld8RadioContainer.setVAlignment(VRLayout.CENTER);
      medicalInfoOld9AndOld8RadioContainer.add(getMedicalInfoOld9AndOld8Radio(), null);
    }
    return medicalInfoOld9AndOld8RadioContainer;
  }

  /**
   * 高齢割合モデルを取得します。
   * @return 高齢割合モデル
   */
  protected ACListModelAdapter getMedicalInfoOld9AndOld8RadioModel(){
    if(medicalInfoOld9AndOld8RadioModel==null){
      medicalInfoOld9AndOld8RadioModel = new ACListModelAdapter();
      addMedicalInfoOld9AndOld8RadioModel();
    }
    return medicalInfoOld9AndOld8RadioModel;
  }

  /**
   * 高齢9を取得します。
   * @return 高齢9
   */
  public ACRadioButtonItem getMedicalInfoOld9AndOld8RadioItem1(){
    if(medicalInfoOld9AndOld8RadioItem1==null){

      medicalInfoOld9AndOld8RadioItem1 = new ACRadioButtonItem();

      medicalInfoOld9AndOld8RadioItem1.setText("高齢9");

      medicalInfoOld9AndOld8RadioItem1.setGroup(getMedicalInfoOld9AndOld8Radio());

      medicalInfoOld9AndOld8RadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalInfoOld9AndOld8RadioItem1();
    }
    return medicalInfoOld9AndOld8RadioItem1;

  }

  /**
   * 高齢8を取得します。
   * @return 高齢8
   */
  public ACRadioButtonItem getMedicalInfoOld9AndOld8RadioItem2(){
    if(medicalInfoOld9AndOld8RadioItem2==null){

      medicalInfoOld9AndOld8RadioItem2 = new ACRadioButtonItem();

      medicalInfoOld9AndOld8RadioItem2.setText("高齢8");

      medicalInfoOld9AndOld8RadioItem2.setGroup(getMedicalInfoOld9AndOld8Radio());

      medicalInfoOld9AndOld8RadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalInfoOld9AndOld8RadioItem2();
    }
    return medicalInfoOld9AndOld8RadioItem2;

  }

  /**
   * 高齢7を取得します。
   * @return 高齢7
   */
  public ACRadioButtonItem getMedicalInfoOld9AndOld8RadioItem3(){
    if(medicalInfoOld9AndOld8RadioItem3==null){

      medicalInfoOld9AndOld8RadioItem3 = new ACRadioButtonItem();

      medicalInfoOld9AndOld8RadioItem3.setText("高齢7");

      medicalInfoOld9AndOld8RadioItem3.setGroup(getMedicalInfoOld9AndOld8Radio());

      medicalInfoOld9AndOld8RadioItem3.setConstraints(VRLayout.FLOW);

      addMedicalInfoOld9AndOld8RadioItem3();
    }
    return medicalInfoOld9AndOld8RadioItem3;

  }

  /**
   * (保険者番号・コンテナ)を取得します。
   * @return (保険者番号・コンテナ)
   */
  public ACLabelContainer getMedicalInfoInsurerNoContena(){
    if(medicalInfoInsurerNoContena==null){

      medicalInfoInsurerNoContena = new ACLabelContainer();

      medicalInfoInsurerNoContena.setText("保険者番号");

      medicalInfoInsurerNoContena.setFollowChildEnabled(true);

      addMedicalInfoInsurerNoContena();
    }
    return medicalInfoInsurerNoContena;

  }

  /**
   * (医療保険者番号)法別番号を取得します。
   * @return (医療保険者番号)法別番号
   */
  public ACTextField getMedicalInfoInsurerLawNo(){
    if(medicalInfoInsurerLawNo==null){

      medicalInfoInsurerLawNo = new ACTextField();

      medicalInfoInsurerLawNo.setBindPath("MEDICAL_LAW_NO");

      medicalInfoInsurerLawNo.setColumns(2);

      medicalInfoInsurerLawNo.setCharType(VRCharType.ONLY_DIGIT);

      medicalInfoInsurerLawNo.setIMEMode(InputSubset.LATIN);

      medicalInfoInsurerLawNo.setMaxLength(2);

      addMedicalInfoInsurerLawNo();
    }
    return medicalInfoInsurerLawNo;

  }

  /**
   * (医療保険者番号)保険者番号を取得します。
   * @return (医療保険者番号)保険者番号
   */
  public ACTextField getMedicalInfoInsurerNo(){
    if(medicalInfoInsurerNo==null){

      medicalInfoInsurerNo = new ACTextField();

      medicalInfoInsurerNo.setBindPath("MEDICAL_INSURER_ID");

      medicalInfoInsurerNo.setColumns(6);

      medicalInfoInsurerNo.setCharType(VRCharType.ONLY_DIGIT);

      medicalInfoInsurerNo.setIMEMode(InputSubset.LATIN);

      medicalInfoInsurerNo.setMaxLength(6);

      addMedicalInfoInsurerNo();
    }
    return medicalInfoInsurerNo;

  }

  /**
   * 保険者名を取得します。
   * @return 保険者名
   */
  public ACComboBox getMedicalInfoInsurerName(){
    if(medicalInfoInsurerName==null){

      medicalInfoInsurerName = new ACComboBox();

      getMedicalInfoInsurerNameContainer().setText("保険者名");

      medicalInfoInsurerName.setEditable(false);

      medicalInfoInsurerName.setColumns(10);

      medicalInfoInsurerName.setModelBindPath("MEDICAL_INSURER");

      medicalInfoInsurerName.setRenderBindPath("INSURER_NAME");

      medicalInfoInsurerName.setModel(getMedicalInfoInsurerNameModel());

      addMedicalInfoInsurerName();
    }
    return medicalInfoInsurerName;

  }

  /**
   * 保険者名コンテナを取得します。
   * @return 保険者名コンテナ
   */
  protected ACLabelContainer getMedicalInfoInsurerNameContainer(){
    if(medicalInfoInsurerNameContainer==null){
      medicalInfoInsurerNameContainer = new ACLabelContainer();
      medicalInfoInsurerNameContainer.setFollowChildEnabled(true);
      medicalInfoInsurerNameContainer.setVAlignment(VRLayout.CENTER);
      medicalInfoInsurerNameContainer.add(getMedicalInfoInsurerName(), null);
    }
    return medicalInfoInsurerNameContainer;
  }

  /**
   * 保険者名モデルを取得します。
   * @return 保険者名モデル
   */
  protected ACComboBoxModelAdapter getMedicalInfoInsurerNameModel(){
    if(medicalInfoInsurerNameModel==null){
      medicalInfoInsurerNameModel = new ACComboBoxModelAdapter();
      addMedicalInfoInsurerNameModel();
    }
    return medicalInfoInsurerNameModel;
  }

  /**
   * 記号・番号を取得します。
   * @return 記号・番号
   */
  public ACTextField getMedicalInfoMark(){
    if(medicalInfoMark==null){

      medicalInfoMark = new ACTextField();

      getMedicalInfoMarkContainer().setText("記号・番号");

      medicalInfoMark.setBindPath("MEDICAL_INSURE_ID");

      medicalInfoMark.setColumns(12);

      medicalInfoMark.setIMEMode(InputSubset.KANJI);

      medicalInfoMark.setMaxLength(16);

      addMedicalInfoMark();
    }
    return medicalInfoMark;

  }

  /**
   * 記号・番号コンテナを取得します。
   * @return 記号・番号コンテナ
   */
  protected ACLabelContainer getMedicalInfoMarkContainer(){
    if(medicalInfoMarkContainer==null){
      medicalInfoMarkContainer = new ACLabelContainer();
      medicalInfoMarkContainer.setFollowChildEnabled(true);
      medicalInfoMarkContainer.setVAlignment(VRLayout.CENTER);
      medicalInfoMarkContainer.add(getMedicalInfoMark(), null);
    }
    return medicalInfoMarkContainer;
  }

  /**
   * 有効期間・コンテナを取得します。
   * @return 有効期間・コンテナ
   */
  public ACLabelContainer getMedicalInfoValidLimitContena(){
    if(medicalInfoValidLimitContena==null){

      medicalInfoValidLimitContena = new ACLabelContainer();

      medicalInfoValidLimitContena.setText("有効期間");

      medicalInfoValidLimitContena.setFollowChildEnabled(true);

      addMedicalInfoValidLimitContena();
    }
    return medicalInfoValidLimitContena;

  }

  /**
   * 有効期間・テキスト1を取得します。
   * @return 有効期間・テキスト1
   */
  public QkanDateTextField getMedicalInfoValidLimit1(){
    if(medicalInfoValidLimit1==null){

      medicalInfoValidLimit1 = new QkanDateTextField();

      medicalInfoValidLimit1.setBindPath("MEDICAL_VALID_START");

      addMedicalInfoValidLimit1();
    }
    return medicalInfoValidLimit1;

  }

  /**
   * 有効期間・ラベルを取得します。
   * @return 有効期間・ラベル
   */
  public ACLabel getMedicalInfoValidLimitLabel(){
    if(medicalInfoValidLimitLabel==null){

      medicalInfoValidLimitLabel = new ACLabel();

      medicalInfoValidLimitLabel.setText(" から ");

      addMedicalInfoValidLimitLabel();
    }
    return medicalInfoValidLimitLabel;

  }

  /**
   * 有効期間・テキスト2を取得します。
   * @return 有効期間・テキスト2
   */
  public QkanDateTextField getMedicalInfoValidLimit2(){
    if(medicalInfoValidLimit2==null){

      medicalInfoValidLimit2 = new QkanDateTextField();

      medicalInfoValidLimit2.setBindPath("MEDICAL_VALID_END");

      medicalInfoValidLimit2.setColumns(10);

      medicalInfoValidLimit2.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      medicalInfoValidLimit2.setMaxLength(11);

      addMedicalInfoValidLimit2();
    }
    return medicalInfoValidLimit2;

  }

  /**
   * 給付割合・コンテナを取得します。
   * @return 給付割合・コンテナ
   */
  public ACLabelContainer getMedicalInfoProvideContena(){
    if(medicalInfoProvideContena==null){

      medicalInfoProvideContena = new ACLabelContainer();

      medicalInfoProvideContena.setText("給付割合");

      medicalInfoProvideContena.setFollowChildEnabled(true);

      addMedicalInfoProvideContena();
    }
    return medicalInfoProvideContena;

  }

  /**
   * 給付割合・ラベル1を取得します。
   * @return 給付割合・ラベル1
   */
  public ACLabel getMedicalInfoProvideLabel1(){
    if(medicalInfoProvideLabel1==null){

      medicalInfoProvideLabel1 = new ACLabel();

      addMedicalInfoProvideLabel1();
    }
    return medicalInfoProvideLabel1;

  }

  /**
   * 給付割合を取得します。
   * @return 給付割合
   */
  public ACComboBox getMedicalInfoProvide(){
    if(medicalInfoProvide==null){

      medicalInfoProvide = new ACComboBox();

      medicalInfoProvide.setBindPath("BENEFIT_RATE");

      medicalInfoProvide.setEditable(false);

      medicalInfoProvide.setColumns(3);

      medicalInfoProvide.setModelBindPath("BENEFIT_RATE");

      medicalInfoProvide.setRenderBindPath("CONTENT");

      medicalInfoProvide.setModel(getMedicalInfoProvideModel());

      addMedicalInfoProvide();
    }
    return medicalInfoProvide;

  }

  /**
   * 給付割合モデルを取得します。
   * @return 給付割合モデル
   */
  protected ACComboBoxModelAdapter getMedicalInfoProvideModel(){
    if(medicalInfoProvideModel==null){
      medicalInfoProvideModel = new ACComboBoxModelAdapter();
      addMedicalInfoProvideModel();
    }
    return medicalInfoProvideModel;
  }

  /**
   * 給付割合・ラベル2を取得します。
   * @return 給付割合・ラベル2
   */
  public ACLabel getMedicalInfoProvideLabel2(){
    if(medicalInfoProvideLabel2==null){

      medicalInfoProvideLabel2 = new ACLabel();

      medicalInfoProvideLabel2.setText(" 割");

      addMedicalInfoProvideLabel2();
    }
    return medicalInfoProvideLabel2;

  }

  /**
   * (市町村番号・コンテナ)を取得します。
   * @return (市町村番号・コンテナ)
   */
  public ACLabelContainer getMedicalInfoCitiesNoContena(){
    if(medicalInfoCitiesNoContena==null){

      medicalInfoCitiesNoContena = new ACLabelContainer();

      medicalInfoCitiesNoContena.setText("市町村番号");

      medicalInfoCitiesNoContena.setFollowChildEnabled(true);

      addMedicalInfoCitiesNoContena();
    }
    return medicalInfoCitiesNoContena;

  }

  /**
   * (市町村番号)法別番号を取得します。
   * @return (市町村番号)法別番号
   */
  public ACTextField getMedicalInfoCitiesLawNo(){
    if(medicalInfoCitiesLawNo==null){

      medicalInfoCitiesLawNo = new ACTextField();

      medicalInfoCitiesLawNo.setBindPath("CITY_LAW_NO");

      medicalInfoCitiesLawNo.setColumns(2);

      medicalInfoCitiesLawNo.setCharType(VRCharType.ONLY_DIGIT);

      medicalInfoCitiesLawNo.setIMEMode(InputSubset.LATIN);

      medicalInfoCitiesLawNo.setMaxLength(2);

      addMedicalInfoCitiesLawNo();
    }
    return medicalInfoCitiesLawNo;

  }

  /**
   * (市町村番号)保険者番号を取得します。
   * @return (市町村番号)保険者番号
   */
  public ACTextField getMedicalInfoCitiesNo(){
    if(medicalInfoCitiesNo==null){

      medicalInfoCitiesNo = new ACTextField();

      medicalInfoCitiesNo.setBindPath("CITY_INSURER_ID");

      medicalInfoCitiesNo.setColumns(6);

      medicalInfoCitiesNo.setCharType(VRCharType.ONLY_DIGIT);

      medicalInfoCitiesNo.setIMEMode(InputSubset.LATIN);

      medicalInfoCitiesNo.setMaxLength(6);

      addMedicalInfoCitiesNo();
    }
    return medicalInfoCitiesNo;

  }

  /**
   * 市町村名を取得します。
   * @return 市町村名
   */
  public ACComboBox getMedicalInfoCitiesName(){
    if(medicalInfoCitiesName==null){

      medicalInfoCitiesName = new ACComboBox();

      getMedicalInfoCitiesNameContainer().setText("市町村名");

      medicalInfoCitiesName.setEditable(false);

      medicalInfoCitiesName.setColumns(10);

      medicalInfoCitiesName.setModelBindPath("CITY_INSURER");

      medicalInfoCitiesName.setRenderBindPath("INSURER_NAME");

      medicalInfoCitiesName.setModel(getMedicalInfoCitiesNameModel());

      addMedicalInfoCitiesName();
    }
    return medicalInfoCitiesName;

  }

  /**
   * 市町村名コンテナを取得します。
   * @return 市町村名コンテナ
   */
  protected ACLabelContainer getMedicalInfoCitiesNameContainer(){
    if(medicalInfoCitiesNameContainer==null){
      medicalInfoCitiesNameContainer = new ACLabelContainer();
      medicalInfoCitiesNameContainer.setFollowChildEnabled(true);
      medicalInfoCitiesNameContainer.setVAlignment(VRLayout.CENTER);
      medicalInfoCitiesNameContainer.add(getMedicalInfoCitiesName(), null);
    }
    return medicalInfoCitiesNameContainer;
  }

  /**
   * 市町村名モデルを取得します。
   * @return 市町村名モデル
   */
  protected ACComboBoxModelAdapter getMedicalInfoCitiesNameModel(){
    if(medicalInfoCitiesNameModel==null){
      medicalInfoCitiesNameModel = new ACComboBoxModelAdapter();
      addMedicalInfoCitiesNameModel();
    }
    return medicalInfoCitiesNameModel;
  }

  /**
   * 老人受給者番号を取得します。
   * @return 老人受給者番号
   */
  public ACTextField getMedicalInfoOldPersonReceiptNo(){
    if(medicalInfoOldPersonReceiptNo==null){

      medicalInfoOldPersonReceiptNo = new ACTextField();

      getMedicalInfoOldPersonReceiptNoContainer().setText("老人受給者番号");

      medicalInfoOldPersonReceiptNo.setBindPath("OLD_RECIPIENT_ID");

      medicalInfoOldPersonReceiptNo.setColumns(10);

      medicalInfoOldPersonReceiptNo.setCharType(VRCharType.ONLY_DIGIT);

      medicalInfoOldPersonReceiptNo.setIMEMode(InputSubset.LATIN);

      medicalInfoOldPersonReceiptNo.setMaxLength(7);

      addMedicalInfoOldPersonReceiptNo();
    }
    return medicalInfoOldPersonReceiptNo;

  }

  /**
   * 老人受給者番号コンテナを取得します。
   * @return 老人受給者番号コンテナ
   */
  protected ACLabelContainer getMedicalInfoOldPersonReceiptNoContainer(){
    if(medicalInfoOldPersonReceiptNoContainer==null){
      medicalInfoOldPersonReceiptNoContainer = new ACLabelContainer();
      medicalInfoOldPersonReceiptNoContainer.setFollowChildEnabled(true);
      medicalInfoOldPersonReceiptNoContainer.setVAlignment(VRLayout.CENTER);
      medicalInfoOldPersonReceiptNoContainer.add(getMedicalInfoOldPersonReceiptNo(), null);
    }
    return medicalInfoOldPersonReceiptNoContainer;
  }

  /**
   * ボタン領域を取得します。
   * @return ボタン領域
   */
  public ACPanel getMedicalInfoButtons(){
    if(medicalInfoButtons==null){

      medicalInfoButtons = new ACPanel();

      addMedicalInfoButtons();
    }
    return medicalInfoButtons;

  }

  /**
   * クリアを取得します。
   * @return クリア
   */
  public ACButton getMedicalInfoButtonClear(){
    if(medicalInfoButtonClear==null){

      medicalInfoButtonClear = new ACButton();

      medicalInfoButtonClear.setText("クリア");

      medicalInfoButtonClear.setToolTipText("医療保険情報をクリアします。");

      medicalInfoButtonClear.setIconPath(ACConstants.ICON_PATH_CLEAR_16);

      addMedicalInfoButtonClear();
    }
    return medicalInfoButtonClear;

  }

  /**
   * 追加を取得します。
   * @return 追加
   */
  public ACButton getMedicalInfoButtonInsert(){
    if(medicalInfoButtonInsert==null){

      medicalInfoButtonInsert = new ACButton();

      medicalInfoButtonInsert.setText("追加");

      medicalInfoButtonInsert.setToolTipText("医療保険情報を追加します。");

      medicalInfoButtonInsert.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addMedicalInfoButtonInsert();
    }
    return medicalInfoButtonInsert;

  }

  /**
   * 書替を取得します。
   * @return 書替
   */
  public ACButton getMedicalInfoButtonConpile(){
    if(medicalInfoButtonConpile==null){

      medicalInfoButtonConpile = new ACButton();

      medicalInfoButtonConpile.setText("書替");

      medicalInfoButtonConpile.setToolTipText("医療保険情報を編集します。");

      medicalInfoButtonConpile.setIconPath(ACConstants.ICON_PATH_STATE_UPDATE_16);

      addMedicalInfoButtonConpile();
    }
    return medicalInfoButtonConpile;

  }

  /**
   * 削除を取得します。
   * @return 削除
   */
  public ACButton getMedicalInfoButtonDelete(){
    if(medicalInfoButtonDelete==null){

      medicalInfoButtonDelete = new ACButton();

      medicalInfoButtonDelete.setText("削除");

      medicalInfoButtonDelete.setToolTipText("医療保険情報を削除します。");

      medicalInfoButtonDelete.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addMedicalInfoButtonDelete();
    }
    return medicalInfoButtonDelete;

  }

  /**
   * 医療保険領域・テーブルを取得します。
   * @return 医療保険領域・テーブル
   */
  public ACTable getMedicalInfoTable(){
    if(medicalInfoTable==null){

      medicalInfoTable = new ACTable();

      medicalInfoTable.setColumnModel(getMedicalInfoTableColumnModel());

      addMedicalInfoTable();
    }
    return medicalInfoTable;

  }

  /**
   * 医療保険領域・テーブルカラムモデルを取得します。
   * @return 医療保険領域・テーブルカラムモデル
   */
  protected VRTableColumnModel getMedicalInfoTableColumnModel(){
    if(medicalInfoTableColumnModel==null){
      medicalInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addMedicalInfoTableColumnModel();
    }
    return medicalInfoTableColumnModel;
  }

  /**
   * Noを取得します。
   * @return No
   */
  public ACTableColumn getMedicalInfoTableColumn0(){
    if(medicalInfoTableColumn0==null){

      medicalInfoTableColumn0 = new ACTableColumn(0);

      medicalInfoTableColumn0.setHeaderValue("No.");

      medicalInfoTableColumn0.setColumns(3);

      medicalInfoTableColumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      medicalInfoTableColumn0.setSortable(false);

      addMedicalInfoTableColumn0();
    }
    return medicalInfoTableColumn0;

  }

  /**
   * 保険種類カラムを取得します。
   * @return 保険種類カラム
   */
  public ACTableColumn getMedicalInfoTableColumn1(){
    if(medicalInfoTableColumn1==null){

      medicalInfoTableColumn1 = new ACTableColumn(0);

      medicalInfoTableColumn1.setHeaderValue("保険種類");

      medicalInfoTableColumn1.setColumns(6);

      addMedicalInfoTableColumn1();
    }
    return medicalInfoTableColumn1;

  }

  /**
   * 本人/家族カラムを取得します。
   * @return 本人/家族カラム
   */
  public ACTableColumn getMedicalInfoTableColumn2(){
    if(medicalInfoTableColumn2==null){

      medicalInfoTableColumn2 = new ACTableColumn(1);

      medicalInfoTableColumn2.setHeaderValue("本人/家族");

      medicalInfoTableColumn2.setColumns(7);

      addMedicalInfoTableColumn2();
    }
    return medicalInfoTableColumn2;

  }

  /**
   * 保険者番号カラムを取得します。
   * @return 保険者番号カラム
   */
  public ACTableColumn getMedicalInfoTableColumn3(){
    if(medicalInfoTableColumn3==null){

      medicalInfoTableColumn3 = new ACTableColumn(2);

      medicalInfoTableColumn3.setHeaderValue("保険者番号");

      medicalInfoTableColumn3.setColumns(7);

      addMedicalInfoTableColumn3();
    }
    return medicalInfoTableColumn3;

  }

  /**
   * 保険者名カラムを取得します。
   * @return 保険者名カラム
   */
  public ACTableColumn getMedicalInfoTableColumn4(){
    if(medicalInfoTableColumn4==null){

      medicalInfoTableColumn4 = new ACTableColumn(3);

      medicalInfoTableColumn4.setHeaderValue("保険者名");

      medicalInfoTableColumn4.setColumns(10);

      addMedicalInfoTableColumn4();
    }
    return medicalInfoTableColumn4;

  }

  /**
   * 記号・番号カラムを取得します。
   * @return 記号・番号カラム
   */
  public ACTableColumn getMedicalInfoTableColumn5(){
    if(medicalInfoTableColumn5==null){

      medicalInfoTableColumn5 = new ACTableColumn(4);

      medicalInfoTableColumn5.setHeaderValue("記号・番号");

      medicalInfoTableColumn5.setColumns(7);

      addMedicalInfoTableColumn5();
    }
    return medicalInfoTableColumn5;

  }

  /**
   * 有効期間開始カラムを取得します。
   * @return 有効期間開始カラム
   */
  public ACTableColumn getMedicalInfoTableColumn6(){
    if(medicalInfoTableColumn6==null){

      medicalInfoTableColumn6 = new ACTableColumn(5);

      medicalInfoTableColumn6.setHeaderValue("有効期間開始日");

      medicalInfoTableColumn6.setColumns(10);

      medicalInfoTableColumn6.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addMedicalInfoTableColumn6();
    }
    return medicalInfoTableColumn6;

  }

  /**
   * 有効期間終了カラムを取得します。
   * @return 有効期間終了カラム
   */
  public ACTableColumn getMedicalInfoTableColumn7(){
    if(medicalInfoTableColumn7==null){

      medicalInfoTableColumn7 = new ACTableColumn(6);

      medicalInfoTableColumn7.setHeaderValue("有効期間終了日");

      medicalInfoTableColumn7.setColumns(10);

      medicalInfoTableColumn7.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addMedicalInfoTableColumn7();
    }
    return medicalInfoTableColumn7;

  }

  /**
   * 給付割合カラムを取得します。
   * @return 給付割合カラム
   */
  public ACTableColumn getMedicalInfoTableColumn8(){
    if(medicalInfoTableColumn8==null){

      medicalInfoTableColumn8 = new ACTableColumn(7);

      medicalInfoTableColumn8.setHeaderValue("給付割合");

      medicalInfoTableColumn8.setColumns(6);

      medicalInfoTableColumn8.setHorizontalAlignment(SwingConstants.RIGHT);

      addMedicalInfoTableColumn8();
    }
    return medicalInfoTableColumn8;

  }

  /**
   * 市町村番号カラムを取得します。
   * @return 市町村番号カラム
   */
  public ACTableColumn getMedicalInfoTableColumn9(){
    if(medicalInfoTableColumn9==null){

      medicalInfoTableColumn9 = new ACTableColumn(8);

      medicalInfoTableColumn9.setHeaderValue("市町村番号");

      medicalInfoTableColumn9.setColumns(7);

      addMedicalInfoTableColumn9();
    }
    return medicalInfoTableColumn9;

  }

  /**
   * 市町村名カラムを取得します。
   * @return 市町村名カラム
   */
  public ACTableColumn getMedicalInfoTableColumn10(){
    if(medicalInfoTableColumn10==null){

      medicalInfoTableColumn10 = new ACTableColumn(9);

      medicalInfoTableColumn10.setHeaderValue("市町村名");

      medicalInfoTableColumn10.setColumns(10);

      addMedicalInfoTableColumn10();
    }
    return medicalInfoTableColumn10;

  }

  /**
   * 老人受給者番号カラムを取得します。
   * @return 老人受給者番号カラム
   */
  public ACTableColumn getMedicalInfoTableColumn11(){
    if(medicalInfoTableColumn11==null){

      medicalInfoTableColumn11 = new ACTableColumn(10);

      medicalInfoTableColumn11.setHeaderValue("老人受給者番号");

      medicalInfoTableColumn11.setColumns(8);

      addMedicalInfoTableColumn11();
    }
    return medicalInfoTableColumn11;

  }

  /**
   * 訪問看護療養費明細書情報登録領域を取得します。
   * @return 訪問看護療養費明細書情報登録領域
   */
  public ACPanel getPoint2(){
    if(point2==null){

      point2 = new ACPanel();

      addPoint2();
    }
    return point2;

  }

  /**
   * 利用者の状況領域を取得します。
   * @return 利用者の状況領域
   */
  public ACGroupBox getCallNursePatients(){
    if(callNursePatients==null){

      callNursePatients = new ACGroupBox();

      callNursePatients.setText("利用者の状況");

      callNursePatients.setAutoWrap(false);

      addCallNursePatients();
    }
    return callNursePatients;

  }

  /**
   * 心身の状態を取得します。
   * @return 心身の状態
   */
  public ACTextArea getCallNurseMindState(){
    if(callNurseMindState==null){

      callNurseMindState = new ACTextArea();

      getCallNurseMindStateContainer().setText("心身の状態");

      callNurseMindState.setBindPath("BODY_STATE");

      callNurseMindState.setColumns(50);

      callNurseMindState.setRows(6);

      callNurseMindState.setMaxRows(6);

      callNurseMindState.setIMEMode(InputSubset.KANJI);

      callNurseMindState.setMaxLength(300);

      callNurseMindState.setLineWrap(true);

      addCallNurseMindState();
    }
    return callNurseMindState;

  }

  /**
   * 心身の状態コンテナを取得します。
   * @return 心身の状態コンテナ
   */
  protected ACLabelContainer getCallNurseMindStateContainer(){
    if(callNurseMindStateContainer==null){
      callNurseMindStateContainer = new ACLabelContainer();
      callNurseMindStateContainer.setFollowChildEnabled(true);
      callNurseMindStateContainer.setVAlignment(VRLayout.CENTER);
      callNurseMindStateContainer.add(getCallNurseMindState(), null);
    }
    return callNurseMindStateContainer;
  }

  /**
   * 主たる傷病名を取得します。
   * @return 主たる傷病名
   */
  public ACTextArea getCallNurseMainDiseaseName(){
    if(callNurseMainDiseaseName==null){

      callNurseMainDiseaseName = new ACTextArea();

      getCallNurseMainDiseaseNameContainer().setText("主たる傷病名");

      callNurseMainDiseaseName.setBindPath("DISEASE");

      callNurseMainDiseaseName.setColumns(50);

      callNurseMainDiseaseName.setRows(5);

      callNurseMainDiseaseName.setMaxRows(5);

      callNurseMainDiseaseName.setIMEMode(InputSubset.KANJI);

      callNurseMainDiseaseName.setMaxLength(250);

      callNurseMainDiseaseName.setLineWrap(true);

      addCallNurseMainDiseaseName();
    }
    return callNurseMainDiseaseName;

  }

  /**
   * 主たる傷病名コンテナを取得します。
   * @return 主たる傷病名コンテナ
   */
  protected ACLabelContainer getCallNurseMainDiseaseNameContainer(){
    if(callNurseMainDiseaseNameContainer==null){
      callNurseMainDiseaseNameContainer = new ACLabelContainer();
      callNurseMainDiseaseNameContainer.setFollowChildEnabled(true);
      callNurseMainDiseaseNameContainer.setVAlignment(VRLayout.CENTER);
      callNurseMainDiseaseNameContainer.add(getCallNurseMainDiseaseName(), null);
    }
    return callNurseMainDiseaseNameContainer;
  }

  /**
   * 厚生大臣の定める疾病を取得します。
   * @return 厚生大臣の定める疾病
   */
  public ACClearableRadioButtonGroup getCallNurseInsuranceRadio(){
    if(callNurseInsuranceRadio==null){

      callNurseInsuranceRadio = new ACClearableRadioButtonGroup();

      getCallNurseInsuranceRadioContainer().setText("厚生労働大臣の定める疾病");

      callNurseInsuranceRadio.setBindPath("SPECIAL_SHIPPEI");

      callNurseInsuranceRadio.setUseClearButton(false);

      callNurseInsuranceRadio.setModel(getCallNurseInsuranceRadioModel());

      addCallNurseInsuranceRadio();
    }
    return callNurseInsuranceRadio;

  }

  /**
   * 厚生大臣の定める疾病コンテナを取得します。
   * @return 厚生大臣の定める疾病コンテナ
   */
  protected ACLabelContainer getCallNurseInsuranceRadioContainer(){
    if(callNurseInsuranceRadioContainer==null){
      callNurseInsuranceRadioContainer = new ACLabelContainer();
      callNurseInsuranceRadioContainer.setFollowChildEnabled(true);
      callNurseInsuranceRadioContainer.setVAlignment(VRLayout.CENTER);
      callNurseInsuranceRadioContainer.add(getCallNurseInsuranceRadio(), null);
    }
    return callNurseInsuranceRadioContainer;
  }

  /**
   * 厚生大臣の定める疾病モデルを取得します。
   * @return 厚生大臣の定める疾病モデル
   */
  protected ACListModelAdapter getCallNurseInsuranceRadioModel(){
    if(callNurseInsuranceRadioModel==null){
      callNurseInsuranceRadioModel = new ACListModelAdapter();
      addCallNurseInsuranceRadioModel();
    }
    return callNurseInsuranceRadioModel;
  }

  /**
   * 非該当を取得します。
   * @return 非該当
   */
  public ACRadioButtonItem getCallNurseInsuranceRadioItem1(){
    if(callNurseInsuranceRadioItem1==null){

      callNurseInsuranceRadioItem1 = new ACRadioButtonItem();

      callNurseInsuranceRadioItem1.setText("非該当");

      callNurseInsuranceRadioItem1.setGroup(getCallNurseInsuranceRadio());

      callNurseInsuranceRadioItem1.setConstraints(VRLayout.FLOW);

      addCallNurseInsuranceRadioItem1();
    }
    return callNurseInsuranceRadioItem1;

  }

  /**
   * 該当を取得します。
   * @return 該当
   */
  public ACRadioButtonItem getCallNurseInsuranceRadioItem2(){
    if(callNurseInsuranceRadioItem2==null){

      callNurseInsuranceRadioItem2 = new ACRadioButtonItem();

      callNurseInsuranceRadioItem2.setText("該当");

      callNurseInsuranceRadioItem2.setGroup(getCallNurseInsuranceRadio());

      callNurseInsuranceRadioItem2.setConstraints(VRLayout.FLOW);

      addCallNurseInsuranceRadioItem2();
    }
    return callNurseInsuranceRadioItem2;

  }

  /**
   * スペース1を取得します。
   * @return スペース1
   */
  public ACLabel getCallNurseOfficialSpace1(){
    if(callNurseOfficialSpace1==null){

      callNurseOfficialSpace1 = new ACLabel();

      callNurseOfficialSpace1.setText("　　　　　　　");

      addCallNurseOfficialSpace1();
    }
    return callNurseOfficialSpace1;

  }

  /**
   * 職務上の事由を取得します。
   * @return 職務上の事由
   */
  public ACClearableRadioButtonGroup getCallNurseOfficialRadio(){
    if(callNurseOfficialRadio==null){

      callNurseOfficialRadio = new ACClearableRadioButtonGroup();

      getCallNurseOfficialRadioContainer().setText("職務上の事由");

      callNurseOfficialRadio.setBindPath("SHOKUMU_JIYU");

      callNurseOfficialRadio.setUseClearButton(true);

      callNurseOfficialRadio.setModel(getCallNurseOfficialRadioModel());

      addCallNurseOfficialRadio();
    }
    return callNurseOfficialRadio;

  }

  /**
   * 職務上の事由コンテナを取得します。
   * @return 職務上の事由コンテナ
   */
  protected ACLabelContainer getCallNurseOfficialRadioContainer(){
    if(callNurseOfficialRadioContainer==null){
      callNurseOfficialRadioContainer = new ACLabelContainer();
      callNurseOfficialRadioContainer.setFollowChildEnabled(true);
      callNurseOfficialRadioContainer.setVAlignment(VRLayout.CENTER);
      callNurseOfficialRadioContainer.add(getCallNurseOfficialRadio(), null);
    }
    return callNurseOfficialRadioContainer;
  }

  /**
   * 職務上の事由モデルを取得します。
   * @return 職務上の事由モデル
   */
  protected ACListModelAdapter getCallNurseOfficialRadioModel(){
    if(callNurseOfficialRadioModel==null){
      callNurseOfficialRadioModel = new ACListModelAdapter();
      addCallNurseOfficialRadioModel();
    }
    return callNurseOfficialRadioModel;
  }

  /**
   * 1.職務上を取得します。
   * @return 1.職務上
   */
  public ACRadioButtonItem getCallNurseOfficialRadioItem1(){
    if(callNurseOfficialRadioItem1==null){

      callNurseOfficialRadioItem1 = new ACRadioButtonItem();

      callNurseOfficialRadioItem1.setText("1.職務上");

      callNurseOfficialRadioItem1.setGroup(getCallNurseOfficialRadio());

      callNurseOfficialRadioItem1.setConstraints(VRLayout.FLOW);

      addCallNurseOfficialRadioItem1();
    }
    return callNurseOfficialRadioItem1;

  }

  /**
   * 2.下船後3月以内を取得します。
   * @return 2.下船後3月以内
   */
  public ACRadioButtonItem getCallNurseOfficialRadioItem2(){
    if(callNurseOfficialRadioItem2==null){

      callNurseOfficialRadioItem2 = new ACRadioButtonItem();

      callNurseOfficialRadioItem2.setText("2.下船後3月以内");

      callNurseOfficialRadioItem2.setGroup(getCallNurseOfficialRadio());

      callNurseOfficialRadioItem2.setConstraints(VRLayout.FLOW);

      addCallNurseOfficialRadioItem2();
    }
    return callNurseOfficialRadioItem2;

  }

  /**
   * 3.通勤災害を取得します。
   * @return 3.通勤災害
   */
  public ACRadioButtonItem getCallNurseOfficialRadioItem3(){
    if(callNurseOfficialRadioItem3==null){

      callNurseOfficialRadioItem3 = new ACRadioButtonItem();

      callNurseOfficialRadioItem3.setText("3.通勤災害");

      callNurseOfficialRadioItem3.setGroup(getCallNurseOfficialRadio());

      callNurseOfficialRadioItem3.setConstraints(VRLayout.FLOW);

      addCallNurseOfficialRadioItem3();
    }
    return callNurseOfficialRadioItem3;

  }

  /**
   * スペース2を取得します。
   * @return スペース2
   */
  public ACLabel getCallNurseOfficialSpace2(){
    if(callNurseOfficialSpace2==null){

      callNurseOfficialSpace2 = new ACLabel();

      callNurseOfficialSpace2.setText("　　　　　　　");

      addCallNurseOfficialSpace2();
    }
    return callNurseOfficialSpace2;

  }

  /**
   * 特地加算の有無を取得します。
   * @return 特地加算の有無
   */
  public ACClearableRadioButtonGroup getCallNurseAddParticularRadio(){
    if(callNurseAddParticularRadio==null){

      callNurseAddParticularRadio = new ACClearableRadioButtonGroup();

      getCallNurseAddParticularRadioContainer().setText("特地加算の有無");

      callNurseAddParticularRadio.setBindPath("SPECIAL_AREA_ADD");

      callNurseAddParticularRadio.setUseClearButton(false);

      callNurseAddParticularRadio.setModel(getCallNurseAddParticularRadioModel());

      addCallNurseAddParticularRadio();
    }
    return callNurseAddParticularRadio;

  }

  /**
   * 特地加算の有無コンテナを取得します。
   * @return 特地加算の有無コンテナ
   */
  protected ACLabelContainer getCallNurseAddParticularRadioContainer(){
    if(callNurseAddParticularRadioContainer==null){
      callNurseAddParticularRadioContainer = new ACLabelContainer();
      callNurseAddParticularRadioContainer.setFollowChildEnabled(true);
      callNurseAddParticularRadioContainer.setVAlignment(VRLayout.CENTER);
      callNurseAddParticularRadioContainer.add(getCallNurseAddParticularRadio(), null);
    }
    return callNurseAddParticularRadioContainer;
  }

  /**
   * 特地加算の有無モデルを取得します。
   * @return 特地加算の有無モデル
   */
  protected ACListModelAdapter getCallNurseAddParticularRadioModel(){
    if(callNurseAddParticularRadioModel==null){
      callNurseAddParticularRadioModel = new ACListModelAdapter();
      addCallNurseAddParticularRadioModel();
    }
    return callNurseAddParticularRadioModel;
  }

  /**
   * 無を取得します。
   * @return 無
   */
  public ACRadioButtonItem getCallNurseAddParticularRadioItem1(){
    if(callNurseAddParticularRadioItem1==null){

      callNurseAddParticularRadioItem1 = new ACRadioButtonItem();

      callNurseAddParticularRadioItem1.setText("無");

      callNurseAddParticularRadioItem1.setGroup(getCallNurseAddParticularRadio());

      callNurseAddParticularRadioItem1.setConstraints(VRLayout.FLOW);

      addCallNurseAddParticularRadioItem1();
    }
    return callNurseAddParticularRadioItem1;

  }

  /**
   * 有を取得します。
   * @return 有
   */
  public ACRadioButtonItem getCallNurseAddParticularRadioItem2(){
    if(callNurseAddParticularRadioItem2==null){

      callNurseAddParticularRadioItem2 = new ACRadioButtonItem();

      callNurseAddParticularRadioItem2.setText("有");

      callNurseAddParticularRadioItem2.setGroup(getCallNurseAddParticularRadio());

      callNurseAddParticularRadioItem2.setConstraints(VRLayout.FLOW);

      addCallNurseAddParticularRadioItem2();
    }
    return callNurseAddParticularRadioItem2;

  }

  /**
   * 訪問に要する時間を取得します。
   * @return 訪問に要する時間
   */
  public ACTextField getCallNurseCallTime(){
    if(callNurseCallTime==null){

      callNurseCallTime = new ACTextField();

      getCallNurseCallTimeContainer().setText("訪問に要する時間");

      callNurseCallTime.setBindPath("HOMON_TIME");

      callNurseCallTime.setColumns(10);

      callNurseCallTime.setIMEMode(InputSubset.KANJI);

      callNurseCallTime.setMaxLength(32);

      addCallNurseCallTime();
    }
    return callNurseCallTime;

  }

  /**
   * 訪問に要する時間コンテナを取得します。
   * @return 訪問に要する時間コンテナ
   */
  protected ACLabelContainer getCallNurseCallTimeContainer(){
    if(callNurseCallTimeContainer==null){
      callNurseCallTimeContainer = new ACLabelContainer();
      callNurseCallTimeContainer.setFollowChildEnabled(true);
      callNurseCallTimeContainer.setVAlignment(VRLayout.CENTER);
      callNurseCallTimeContainer.add(getCallNurseCallTime(), null);
    }
    return callNurseCallTimeContainer;
  }

  /**
   * 指示書情報領域を取得します。
   * @return 指示書情報領域
   */
  public ACGroupBox getInstructInfos(){
    if(instructInfos==null){

      instructInfos = new ACGroupBox();

      instructInfos.setText("指示書情報");

      instructInfos.setAutoWrap(false);

      addInstructInfos();
    }
    return instructInfos;

  }

  /**
   * 指示書有効期間・コンテナを取得します。
   * @return 指示書有効期間・コンテナ
   */
  public ACLabelContainer getInstructInfoValidLimitContena(){
    if(instructInfoValidLimitContena==null){

      instructInfoValidLimitContena = new ACLabelContainer();

      instructInfoValidLimitContena.setText("指示書有効期間");

      addInstructInfoValidLimitContena();
    }
    return instructInfoValidLimitContena;

  }

  /**
   * 指示有効期間・パネル1を取得します。
   * @return 指示有効期間・パネル1
   */
  public ACPanel getInstructInfoValidLimitPanel1(){
    if(instructInfoValidLimitPanel1==null){

      instructInfoValidLimitPanel1 = new ACPanel();

      instructInfoValidLimitPanel1.setAutoWrap(false);

      instructInfoValidLimitPanel1.setHgap(2);

      addInstructInfoValidLimitPanel1();
    }
    return instructInfoValidLimitPanel1;

  }

  /**
   * 指示書有効期間・テキスト1を取得します。
   * @return 指示書有効期間・テキスト1
   */
  public QkanDateTextField getInstructInfoValidLimit1(){
    if(instructInfoValidLimit1==null){

      instructInfoValidLimit1 = new QkanDateTextField();

      instructInfoValidLimit1.setBindPath("SHIJISHO_VALID_START");

      instructInfoValidLimit1.setColumns(11);

      instructInfoValidLimit1.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      instructInfoValidLimit1.setMaxLength(11);

      addInstructInfoValidLimit1();
    }
    return instructInfoValidLimit1;

  }

  /**
   * 指示書有効期間・ラベルを取得します。
   * @return 指示書有効期間・ラベル
   */
  public ACLabel getInstructInfoValidLimitLabel(){
    if(instructInfoValidLimitLabel==null){

      instructInfoValidLimitLabel = new ACLabel();

      instructInfoValidLimitLabel.setText(" から ");

      addInstructInfoValidLimitLabel();
    }
    return instructInfoValidLimitLabel;

  }

  /**
   * 指示書有効期間・テキスト2を取得します。
   * @return 指示書有効期間・テキスト2
   */
  public QkanDateTextField getInstructInfoValidLimit2(){
    if(instructInfoValidLimit2==null){

      instructInfoValidLimit2 = new QkanDateTextField();

      instructInfoValidLimit2.setBindPath("SHIJISHO_VALID_END");

      instructInfoValidLimit2.setColumns(11);

      instructInfoValidLimit2.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      instructInfoValidLimit2.setMaxLength(11);

      addInstructInfoValidLimit2();
    }
    return instructInfoValidLimit2;

  }

  /**
   * 特別指示書・コンテナを取得します。
   * @return 特別指示書・コンテナ
   */
  public ACLabelContainer getSpecialInstructContena(){
    if(specialInstructContena==null){

      specialInstructContena = new ACLabelContainer();

      specialInstructContena.setText("特別指示書");

      addSpecialInstructContena();
    }
    return specialInstructContena;

  }

  /**
   * 特別指示書・パネル1を取得します。
   * @return 特別指示書・パネル1
   */
  public ACPanel getSpecialInstructPanel1(){
    if(specialInstructPanel1==null){

      specialInstructPanel1 = new ACPanel();

      specialInstructPanel1.setAutoWrap(false);

      specialInstructPanel1.setHgap(2);

      addSpecialInstructPanel1();
    }
    return specialInstructPanel1;

  }

  /**
   * 特別指示書・テキスト1を取得します。
   * @return 特別指示書・テキスト1
   */
  public QkanDateTextField getSpecialInstruct1(){
    if(specialInstruct1==null){

      specialInstruct1 = new QkanDateTextField();

      specialInstruct1.setBindPath("SPECIAL_SHIJISHO_VALID_START");

      specialInstruct1.setColumns(11);

      specialInstruct1.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      specialInstruct1.setMaxLength(11);

      addSpecialInstruct1();
    }
    return specialInstruct1;

  }

  /**
   * 特別指示書・ラベルを取得します。
   * @return 特別指示書・ラベル
   */
  public ACLabel getSpecialInstructLabel1(){
    if(specialInstructLabel1==null){

      specialInstructLabel1 = new ACLabel();

      specialInstructLabel1.setText(" から ");

      addSpecialInstructLabel1();
    }
    return specialInstructLabel1;

  }

  /**
   * 特別指示書・テキスト2を取得します。
   * @return 特別指示書・テキスト2
   */
  public QkanDateTextField getSpecialInstruct2(){
    if(specialInstruct2==null){

      specialInstruct2 = new QkanDateTextField();

      specialInstruct2.setBindPath("SPECIAL_SHIJISHO_VALID_END");

      specialInstruct2.setColumns(11);

      specialInstruct2.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      specialInstruct2.setMaxLength(11);

      addSpecialInstruct2();
    }
    return specialInstruct2;

  }

  /**
   * 特別指示書・パネル2を取得します。
   * @return 特別指示書・パネル2
   */
  public ACPanel getSpecialInstructPanel2(){
    if(specialInstructPanel2==null){

      specialInstructPanel2 = new ACPanel();

      specialInstructPanel2.setAutoWrap(false);

      specialInstructPanel2.setHgap(2);

      addSpecialInstructPanel2();
    }
    return specialInstructPanel2;

  }

  /**
   * クリアを取得します。
   * @return クリア
   */
  public ACButton getSpecialInstructButton2(){
    if(specialInstructButton2==null){

      specialInstructButton2 = new ACButton();

      specialInstructButton2.setText("クリア");

      specialInstructButton2.setToolTipText("特別指示書期間をクリアします。");

      addSpecialInstructButton2();
    }
    return specialInstructButton2;

  }

  /**
   * コメントスペース1を取得します。
   * @return コメントスペース1
   */
  public ACLabel getSpecialInstructCommentSpace1(){
    if(specialInstructCommentSpace1==null){

      specialInstructCommentSpace1 = new ACLabel();

      specialInstructCommentSpace1.setText("　　　　　");

      addSpecialInstructCommentSpace1();
    }
    return specialInstructCommentSpace1;

  }

  /**
   * コメント1を取得します。
   * @return コメント1
   */
  public ACLabel getSpecialInstructComment1(){
    if(specialInstructComment1==null){

      specialInstructComment1 = new ACLabel();

      specialInstructComment1.setText("特別指示書期間中に行う訪問看護は、医療保険の対象となります。");

      addSpecialInstructComment1();
    }
    return specialInstructComment1;

  }

  /**
   * コメントスペース2を取得します。
   * @return コメントスペース2
   */
  public ACLabel getSpecialInstructCommentSpace2(){
    if(specialInstructCommentSpace2==null){

      specialInstructCommentSpace2 = new ACLabel();

      specialInstructCommentSpace2.setText("　　　　　");

      addSpecialInstructCommentSpace2();
    }
    return specialInstructCommentSpace2;

  }

  /**
   * コメント2を取得します。
   * @return コメント2
   */
  public ACLabel getSpecialInstructComment2(){
    if(specialInstructComment2==null){

      specialInstructComment2 = new ACLabel();

      specialInstructComment2.setText("サービス入力時は訪問看護(医)を選んでください。");

      addSpecialInstructComment2();
    }
    return specialInstructComment2;

  }

  /**
   * 医療機関情報を取得します。
   * @return 医療機関情報
   */
  public ACGroupBox getMedicalTreatmentInfos(){
    if(medicalTreatmentInfos==null){

      medicalTreatmentInfos = new ACGroupBox();

      medicalTreatmentInfos.setText("医療機関情報");

      addMedicalTreatmentInfos();
    }
    return medicalTreatmentInfos;

  }

  /**
   * 医療機関基本情報パネルを取得します。
   * @return 医療機関基本情報パネル
   */
  public ACPanel getMedicalTreatmentBasicInfos(){
    if(medicalTreatmentBasicInfos==null){

      medicalTreatmentBasicInfos = new ACPanel();

      medicalTreatmentBasicInfos.setHgrid(150);

      addMedicalTreatmentBasicInfos();
    }
    return medicalTreatmentBasicInfos;

  }

  /**
   * 主治医の属する医療機関の名称を取得します。
   * @return 主治医の属する医療機関の名称
   */
  public ACComboBox getMedicalTreatmentInfoOrgan(){
    if(medicalTreatmentInfoOrgan==null){

      medicalTreatmentInfoOrgan = new ACComboBox();

      getMedicalTreatmentInfoOrganContainer().setText("主治医の属する医療機関の名称");

      medicalTreatmentInfoOrgan.setBindPath("MEDICAL_FACILITY_ID");

      medicalTreatmentInfoOrgan.setEditable(false);

      medicalTreatmentInfoOrgan.setColumns(15);

      medicalTreatmentInfoOrgan.setModelBindPath("MEDICAL_FACILITY");

      medicalTreatmentInfoOrgan.setRenderBindPath("MEDICAL_FACILITY_NAME");

      medicalTreatmentInfoOrgan.setBlankable(true);

      medicalTreatmentInfoOrgan.setMaxColumns(43);

      medicalTreatmentInfoOrgan.setModel(getMedicalTreatmentInfoOrganModel());

      addMedicalTreatmentInfoOrgan();
    }
    return medicalTreatmentInfoOrgan;

  }

  /**
   * 主治医の属する医療機関の名称コンテナを取得します。
   * @return 主治医の属する医療機関の名称コンテナ
   */
  protected ACLabelContainer getMedicalTreatmentInfoOrganContainer(){
    if(medicalTreatmentInfoOrganContainer==null){
      medicalTreatmentInfoOrganContainer = new ACLabelContainer();
      medicalTreatmentInfoOrganContainer.setFollowChildEnabled(true);
      medicalTreatmentInfoOrganContainer.setVAlignment(VRLayout.CENTER);
      medicalTreatmentInfoOrganContainer.add(getMedicalTreatmentInfoOrgan(), null);
    }
    return medicalTreatmentInfoOrganContainer;
  }

  /**
   * 主治医の属する医療機関の名称モデルを取得します。
   * @return 主治医の属する医療機関の名称モデル
   */
  protected ACComboBoxModelAdapter getMedicalTreatmentInfoOrganModel(){
    if(medicalTreatmentInfoOrganModel==null){
      medicalTreatmentInfoOrganModel = new ACComboBoxModelAdapter();
      addMedicalTreatmentInfoOrganModel();
    }
    return medicalTreatmentInfoOrganModel;
  }

  /**
   * 医療機関の郵便番号を取得します。
   * @return 医療機関の郵便番号
   */
  public ACTextField getMedicalTreatmentInfoZip(){
    if(medicalTreatmentInfoZip==null){

      medicalTreatmentInfoZip = new ACTextField();

      getMedicalTreatmentInfoZipContainer().setText("郵便番号");

      medicalTreatmentInfoZip.setBindPath("MEDICAL_FACILITY_ZIP");

      medicalTreatmentInfoZip.setEditable(false);

      medicalTreatmentInfoZip.setColumns(8);

      addMedicalTreatmentInfoZip();
    }
    return medicalTreatmentInfoZip;

  }

  /**
   * 医療機関の郵便番号コンテナを取得します。
   * @return 医療機関の郵便番号コンテナ
   */
  protected ACLabelContainer getMedicalTreatmentInfoZipContainer(){
    if(medicalTreatmentInfoZipContainer==null){
      medicalTreatmentInfoZipContainer = new ACLabelContainer();
      medicalTreatmentInfoZipContainer.setFollowChildEnabled(true);
      medicalTreatmentInfoZipContainer.setVAlignment(VRLayout.CENTER);
      medicalTreatmentInfoZipContainer.add(getMedicalTreatmentInfoZip(), null);
    }
    return medicalTreatmentInfoZipContainer;
  }

  /**
   * 医療機関の住所を取得します。
   * @return 医療機関の住所
   */
  public ACTextField getMedicalTreatmentInfoAddress(){
    if(medicalTreatmentInfoAddress==null){

      medicalTreatmentInfoAddress = new ACTextField();

      getMedicalTreatmentInfoAddressContainer().setText("住所");

      medicalTreatmentInfoAddress.setBindPath("MEDICAL_FACILITY_ADDRESS");

      medicalTreatmentInfoAddress.setEditable(false);

      medicalTreatmentInfoAddress.setColumns(43);

      addMedicalTreatmentInfoAddress();
    }
    return medicalTreatmentInfoAddress;

  }

  /**
   * 医療機関の住所コンテナを取得します。
   * @return 医療機関の住所コンテナ
   */
  protected ACLabelContainer getMedicalTreatmentInfoAddressContainer(){
    if(medicalTreatmentInfoAddressContainer==null){
      medicalTreatmentInfoAddressContainer = new ACLabelContainer();
      medicalTreatmentInfoAddressContainer.setFollowChildEnabled(true);
      medicalTreatmentInfoAddressContainer.setVAlignment(VRLayout.CENTER);
      medicalTreatmentInfoAddressContainer.add(getMedicalTreatmentInfoAddress(), null);
    }
    return medicalTreatmentInfoAddressContainer;
  }

  /**
   * 医療機関の電話番号を取得します。
   * @return 医療機関の電話番号
   */
  public ACTextField getMedicalTreatmentInfoTel(){
    if(medicalTreatmentInfoTel==null){

      medicalTreatmentInfoTel = new ACTextField();

      getMedicalTreatmentInfoTelContainer().setText("電話番号");

      medicalTreatmentInfoTel.setBindPath("MEDICAL_FACILITY_TEL");

      medicalTreatmentInfoTel.setEditable(false);

      medicalTreatmentInfoTel.setColumns(15);

      addMedicalTreatmentInfoTel();
    }
    return medicalTreatmentInfoTel;

  }

  /**
   * 医療機関の電話番号コンテナを取得します。
   * @return 医療機関の電話番号コンテナ
   */
  protected ACLabelContainer getMedicalTreatmentInfoTelContainer(){
    if(medicalTreatmentInfoTelContainer==null){
      medicalTreatmentInfoTelContainer = new ACLabelContainer();
      medicalTreatmentInfoTelContainer.setFollowChildEnabled(true);
      medicalTreatmentInfoTelContainer.setVAlignment(VRLayout.CENTER);
      medicalTreatmentInfoTelContainer.add(getMedicalTreatmentInfoTel(), null);
    }
    return medicalTreatmentInfoTelContainer;
  }

  /**
   * 医療機関のFAX番号を取得します。
   * @return 医療機関のFAX番号
   */
  public ACTextField getMedicalTreatmentInfoFax(){
    if(medicalTreatmentInfoFax==null){

      medicalTreatmentInfoFax = new ACTextField();

      getMedicalTreatmentInfoFaxContainer().setText("FAX番号");

      medicalTreatmentInfoFax.setBindPath("MEDICAL_FACILITY_FAX");

      medicalTreatmentInfoFax.setEditable(false);

      medicalTreatmentInfoFax.setColumns(15);

      addMedicalTreatmentInfoFax();
    }
    return medicalTreatmentInfoFax;

  }

  /**
   * 医療機関のFAX番号コンテナを取得します。
   * @return 医療機関のFAX番号コンテナ
   */
  protected ACLabelContainer getMedicalTreatmentInfoFaxContainer(){
    if(medicalTreatmentInfoFaxContainer==null){
      medicalTreatmentInfoFaxContainer = new ACLabelContainer();
      medicalTreatmentInfoFaxContainer.setFollowChildEnabled(true);
      medicalTreatmentInfoFaxContainer.setVAlignment(VRLayout.CENTER);
      medicalTreatmentInfoFaxContainer.add(getMedicalTreatmentInfoFax(), null);
    }
    return medicalTreatmentInfoFaxContainer;
  }

  /**
   * 主治医の氏名を取得します。
   * @return 主治医の氏名
   */
  public ACTextField getMedicalTreatmentInfoMainDoctorName(){
    if(medicalTreatmentInfoMainDoctorName==null){

      medicalTreatmentInfoMainDoctorName = new ACTextField();

      getMedicalTreatmentInfoMainDoctorNameContainer().setText("主治医の氏名");

      medicalTreatmentInfoMainDoctorName.setBindPath("DOCTOR_NAME");

      medicalTreatmentInfoMainDoctorName.setColumns(10);

      medicalTreatmentInfoMainDoctorName.setIMEMode(InputSubset.KANJI);

      medicalTreatmentInfoMainDoctorName.setMaxLength(32);

      addMedicalTreatmentInfoMainDoctorName();
    }
    return medicalTreatmentInfoMainDoctorName;

  }

  /**
   * 主治医の氏名コンテナを取得します。
   * @return 主治医の氏名コンテナ
   */
  protected ACLabelContainer getMedicalTreatmentInfoMainDoctorNameContainer(){
    if(medicalTreatmentInfoMainDoctorNameContainer==null){
      medicalTreatmentInfoMainDoctorNameContainer = new ACLabelContainer();
      medicalTreatmentInfoMainDoctorNameContainer.setFollowChildEnabled(true);
      medicalTreatmentInfoMainDoctorNameContainer.setVAlignment(VRLayout.CENTER);
      medicalTreatmentInfoMainDoctorNameContainer.add(getMedicalTreatmentInfoMainDoctorName(), null);
    }
    return medicalTreatmentInfoMainDoctorNameContainer;
  }

  /**
   * コンストラクタです。
   */
  public QU003Design() {

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

    tabs.addTab("医療保険", getPoint1());

    tabs.addTab("訪問看護療養費明細書情報登録", getPoint2());

  }

  /**
   * 医療保険領域に内部項目を追加します。
   */
  protected void addPoint1(){

    point1.add(getMedicalInfos(), VRLayout.NORTH);

    point1.add(getMedicalInfoButtons(), VRLayout.NORTH);

    point1.add(getMedicalInfoTable(), VRLayout.CLIENT);

  }

  /**
   * 医療保険領域・情報に内部項目を追加します。
   */
  protected void addMedicalInfos(){

    medicalInfos.add(getMedicalInfoInsuranceVarietyRadio1Container(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalInfos.add(getMedicalInfoInsuranceVarietyRadio2Container(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalInfos.add(getMedicalInfoPersonAndFamilyRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalInfos.add(getMedicalInfoOld9AndOld8RadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalInfos.add(getMedicalInfoInsurerNoContena(), VRLayout.FLOW_INSETLINE);

    medicalInfos.add(getMedicalInfoInsurerNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalInfos.add(getMedicalInfoMarkContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalInfos.add(getMedicalInfoValidLimitContena(), VRLayout.FLOW_INSETLINE);

    medicalInfos.add(getMedicalInfoProvideContena(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalInfos.add(getMedicalInfoCitiesNoContena(), VRLayout.FLOW_INSETLINE);

    medicalInfos.add(getMedicalInfoCitiesNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalInfos.add(getMedicalInfoOldPersonReceiptNoContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 保険種類・上に内部項目を追加します。
   */
  protected void addMedicalInfoInsuranceVarietyRadio1(){

  }

  /**
   * 保険種類・上モデルに内部項目を追加します。
   */
  protected void addMedicalInfoInsuranceVarietyRadio1Model(){

    getMedicalInfoInsuranceVarietyRadio1Item1().setButtonIndex(1);

    getMedicalInfoInsuranceVarietyRadio1Model().add(getMedicalInfoInsuranceVarietyRadio1Item1());

    getMedicalInfoInsuranceVarietyRadio1Item2().setButtonIndex(2);

    getMedicalInfoInsuranceVarietyRadio1Model().add(getMedicalInfoInsuranceVarietyRadio1Item2());

    getMedicalInfoInsuranceVarietyRadio1Item3().setButtonIndex(3);

    getMedicalInfoInsuranceVarietyRadio1Model().add(getMedicalInfoInsuranceVarietyRadio1Item3());

  }

  /**
   * 社保に内部項目を追加します。
   */
  protected void addMedicalInfoInsuranceVarietyRadio1Item1(){

  }

  /**
   * 国保に内部項目を追加します。
   */
  protected void addMedicalInfoInsuranceVarietyRadio1Item2(){

  }

  /**
   * 公費に内部項目を追加します。
   */
  protected void addMedicalInfoInsuranceVarietyRadio1Item3(){

  }

  /**
   * 保険種類・下に内部項目を追加します。
   */
  protected void addMedicalInfoInsuranceVarietyRadio2(){

  }

  /**
   * 保険種類・下モデルに内部項目を追加します。
   */
  protected void addMedicalInfoInsuranceVarietyRadio2Model(){

    getMedicalInfoInsuranceVarietyRadio2Item1().setButtonIndex(1);

    getMedicalInfoInsuranceVarietyRadio2Model().add(getMedicalInfoInsuranceVarietyRadio2Item1());

    getMedicalInfoInsuranceVarietyRadio2Item2().setButtonIndex(2);

    getMedicalInfoInsuranceVarietyRadio2Model().add(getMedicalInfoInsuranceVarietyRadio2Item2());

  }

  /**
   * 老人に内部項目を追加します。
   */
  protected void addMedicalInfoInsuranceVarietyRadio2Item1(){

  }

  /**
   * 退職者に内部項目を追加します。
   */
  protected void addMedicalInfoInsuranceVarietyRadio2Item2(){

  }

  /**
   * 本人/家族に内部項目を追加します。
   */
  protected void addMedicalInfoPersonAndFamilyRadio(){

  }

  /**
   * 本人/家族モデルに内部項目を追加します。
   */
  protected void addMedicalInfoPersonAndFamilyRadioModel(){

    getMedicalInfoPersonAndFamilyRadioItem1().setButtonIndex(1);

    getMedicalInfoPersonAndFamilyRadioModel().add(getMedicalInfoPersonAndFamilyRadioItem1());

    getMedicalInfoPersonAndFamilyRadioItem2().setButtonIndex(2);

    getMedicalInfoPersonAndFamilyRadioModel().add(getMedicalInfoPersonAndFamilyRadioItem2());

    getMedicalInfoPersonAndFamilyRadioItem3().setButtonIndex(3);

    getMedicalInfoPersonAndFamilyRadioModel().add(getMedicalInfoPersonAndFamilyRadioItem3());

  }

  /**
   * 本人に内部項目を追加します。
   */
  protected void addMedicalInfoPersonAndFamilyRadioItem1(){

  }

  /**
   * 3歳に内部項目を追加します。
   */
  protected void addMedicalInfoPersonAndFamilyRadioItem2(){

  }

  /**
   * 家族に内部項目を追加します。
   */
  protected void addMedicalInfoPersonAndFamilyRadioItem3(){

  }

  /**
   * 高齢割合に内部項目を追加します。
   */
  protected void addMedicalInfoOld9AndOld8Radio(){

  }

  /**
   * 高齢割合モデルに内部項目を追加します。
   */
  protected void addMedicalInfoOld9AndOld8RadioModel(){

    getMedicalInfoOld9AndOld8RadioItem1().setButtonIndex(1);

    getMedicalInfoOld9AndOld8RadioModel().add(getMedicalInfoOld9AndOld8RadioItem1());

    getMedicalInfoOld9AndOld8RadioItem2().setButtonIndex(2);

    getMedicalInfoOld9AndOld8RadioModel().add(getMedicalInfoOld9AndOld8RadioItem2());

    getMedicalInfoOld9AndOld8RadioItem3().setButtonIndex(3);

    getMedicalInfoOld9AndOld8RadioModel().add(getMedicalInfoOld9AndOld8RadioItem3());

  }

  /**
   * 高齢9に内部項目を追加します。
   */
  protected void addMedicalInfoOld9AndOld8RadioItem1(){

  }

  /**
   * 高齢8に内部項目を追加します。
   */
  protected void addMedicalInfoOld9AndOld8RadioItem2(){

  }

  /**
   * 高齢7に内部項目を追加します。
   */
  protected void addMedicalInfoOld9AndOld8RadioItem3(){

  }

  /**
   * (保険者番号・コンテナ)に内部項目を追加します。
   */
  protected void addMedicalInfoInsurerNoContena(){

    medicalInfoInsurerNoContena.add(getMedicalInfoInsurerLawNo(), VRLayout.FLOW);

    medicalInfoInsurerNoContena.add(getMedicalInfoInsurerNo(), VRLayout.FLOW);

  }

  /**
   * (医療保険者番号)法別番号に内部項目を追加します。
   */
  protected void addMedicalInfoInsurerLawNo(){

  }

  /**
   * (医療保険者番号)保険者番号に内部項目を追加します。
   */
  protected void addMedicalInfoInsurerNo(){

  }

  /**
   * 保険者名に内部項目を追加します。
   */
  protected void addMedicalInfoInsurerName(){

  }

  /**
   * 保険者名モデルに内部項目を追加します。
   */
  protected void addMedicalInfoInsurerNameModel(){

  }

  /**
   * 記号・番号に内部項目を追加します。
   */
  protected void addMedicalInfoMark(){

  }

  /**
   * 有効期間・コンテナに内部項目を追加します。
   */
  protected void addMedicalInfoValidLimitContena(){

    medicalInfoValidLimitContena.add(getMedicalInfoValidLimit1(), VRLayout.FLOW);

    medicalInfoValidLimitContena.add(getMedicalInfoValidLimitLabel(), VRLayout.FLOW);

    medicalInfoValidLimitContena.add(getMedicalInfoValidLimit2(), VRLayout.FLOW);

  }

  /**
   * 有効期間・テキスト1に内部項目を追加します。
   */
  protected void addMedicalInfoValidLimit1(){

  }

  /**
   * 有効期間・ラベルに内部項目を追加します。
   */
  protected void addMedicalInfoValidLimitLabel(){

  }

  /**
   * 有効期間・テキスト2に内部項目を追加します。
   */
  protected void addMedicalInfoValidLimit2(){

  }

  /**
   * 給付割合・コンテナに内部項目を追加します。
   */
  protected void addMedicalInfoProvideContena(){

    medicalInfoProvideContena.add(getMedicalInfoProvideLabel1(), VRLayout.FLOW);

    medicalInfoProvideContena.add(getMedicalInfoProvide(), VRLayout.FLOW);

    medicalInfoProvideContena.add(getMedicalInfoProvideLabel2(), VRLayout.FLOW);

  }

  /**
   * 給付割合・ラベル1に内部項目を追加します。
   */
  protected void addMedicalInfoProvideLabel1(){

  }

  /**
   * 給付割合に内部項目を追加します。
   */
  protected void addMedicalInfoProvide(){

  }

  /**
   * 給付割合モデルに内部項目を追加します。
   */
  protected void addMedicalInfoProvideModel(){

  }

  /**
   * 給付割合・ラベル2に内部項目を追加します。
   */
  protected void addMedicalInfoProvideLabel2(){

  }

  /**
   * (市町村番号・コンテナ)に内部項目を追加します。
   */
  protected void addMedicalInfoCitiesNoContena(){

    medicalInfoCitiesNoContena.add(getMedicalInfoCitiesLawNo(), VRLayout.FLOW);

    medicalInfoCitiesNoContena.add(getMedicalInfoCitiesNo(), VRLayout.FLOW);

  }

  /**
   * (市町村番号)法別番号に内部項目を追加します。
   */
  protected void addMedicalInfoCitiesLawNo(){

  }

  /**
   * (市町村番号)保険者番号に内部項目を追加します。
   */
  protected void addMedicalInfoCitiesNo(){

  }

  /**
   * 市町村名に内部項目を追加します。
   */
  protected void addMedicalInfoCitiesName(){

  }

  /**
   * 市町村名モデルに内部項目を追加します。
   */
  protected void addMedicalInfoCitiesNameModel(){

  }

  /**
   * 老人受給者番号に内部項目を追加します。
   */
  protected void addMedicalInfoOldPersonReceiptNo(){

  }

  /**
   * ボタン領域に内部項目を追加します。
   */
  protected void addMedicalInfoButtons(){

    medicalInfoButtons.add(getMedicalInfoButtonDelete(), VRLayout.EAST);
    medicalInfoButtons.add(getMedicalInfoButtonConpile(), VRLayout.EAST);
    medicalInfoButtons.add(getMedicalInfoButtonInsert(), VRLayout.EAST);
    medicalInfoButtons.add(getMedicalInfoButtonClear(), VRLayout.EAST);
  }

  /**
   * クリアに内部項目を追加します。
   */
  protected void addMedicalInfoButtonClear(){

  }

  /**
   * 追加に内部項目を追加します。
   */
  protected void addMedicalInfoButtonInsert(){

  }

  /**
   * 書替に内部項目を追加します。
   */
  protected void addMedicalInfoButtonConpile(){

  }

  /**
   * 削除に内部項目を追加します。
   */
  protected void addMedicalInfoButtonDelete(){

  }

  /**
   * 医療保険領域・テーブルに内部項目を追加します。
   */
  protected void addMedicalInfoTable(){

  }

  /**
   * 医療保険領域・テーブルカラムモデルに内部項目を追加します。
   */
  protected void addMedicalInfoTableColumnModel(){

    getMedicalInfoTableColumnModel().addColumn(getMedicalInfoTableColumn0());

    getMedicalInfoTableColumnModel().addColumn(getMedicalInfoTableColumn1());

    getMedicalInfoTableColumnModel().addColumn(getMedicalInfoTableColumn2());

    getMedicalInfoTableColumnModel().addColumn(getMedicalInfoTableColumn3());

    getMedicalInfoTableColumnModel().addColumn(getMedicalInfoTableColumn4());

    getMedicalInfoTableColumnModel().addColumn(getMedicalInfoTableColumn5());

    getMedicalInfoTableColumnModel().addColumn(getMedicalInfoTableColumn6());

    getMedicalInfoTableColumnModel().addColumn(getMedicalInfoTableColumn7());

    getMedicalInfoTableColumnModel().addColumn(getMedicalInfoTableColumn8());

    getMedicalInfoTableColumnModel().addColumn(getMedicalInfoTableColumn9());

    getMedicalInfoTableColumnModel().addColumn(getMedicalInfoTableColumn10());

    getMedicalInfoTableColumnModel().addColumn(getMedicalInfoTableColumn11());

  }

  /**
   * Noに内部項目を追加します。
   */
  protected void addMedicalInfoTableColumn0(){

  }

  /**
   * 保険種類カラムに内部項目を追加します。
   */
  protected void addMedicalInfoTableColumn1(){

  }

  /**
   * 本人/家族カラムに内部項目を追加します。
   */
  protected void addMedicalInfoTableColumn2(){

  }

  /**
   * 保険者番号カラムに内部項目を追加します。
   */
  protected void addMedicalInfoTableColumn3(){

  }

  /**
   * 保険者名カラムに内部項目を追加します。
   */
  protected void addMedicalInfoTableColumn4(){

  }

  /**
   * 記号・番号カラムに内部項目を追加します。
   */
  protected void addMedicalInfoTableColumn5(){

  }

  /**
   * 有効期間開始カラムに内部項目を追加します。
   */
  protected void addMedicalInfoTableColumn6(){

  }

  /**
   * 有効期間終了カラムに内部項目を追加します。
   */
  protected void addMedicalInfoTableColumn7(){

  }

  /**
   * 給付割合カラムに内部項目を追加します。
   */
  protected void addMedicalInfoTableColumn8(){

  }

  /**
   * 市町村番号カラムに内部項目を追加します。
   */
  protected void addMedicalInfoTableColumn9(){

  }

  /**
   * 市町村名カラムに内部項目を追加します。
   */
  protected void addMedicalInfoTableColumn10(){

  }

  /**
   * 老人受給者番号カラムに内部項目を追加します。
   */
  protected void addMedicalInfoTableColumn11(){

  }

  /**
   * 訪問看護療養費明細書情報登録領域に内部項目を追加します。
   */
  protected void addPoint2(){

    point2.add(getCallNursePatients(), VRLayout.NORTH);

    point2.add(getInstructInfos(), VRLayout.NORTH);

    point2.add(getMedicalTreatmentInfos(), VRLayout.NORTH);

  }

  /**
   * 利用者の状況領域に内部項目を追加します。
   */
  protected void addCallNursePatients(){

    callNursePatients.add(getCallNurseMindStateContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    callNursePatients.add(getCallNurseMainDiseaseNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    callNursePatients.add(getCallNurseInsuranceRadioContainer(), VRLayout.FLOW_RETURN);

    callNursePatients.add(getCallNurseOfficialSpace1(), VRLayout.FLOW);

    callNursePatients.add(getCallNurseOfficialRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    callNursePatients.add(getCallNurseOfficialSpace2(), VRLayout.FLOW_INSETLINE);

    callNursePatients.add(getCallNurseAddParticularRadioContainer(), VRLayout.FLOW_INSETLINE);

    callNursePatients.add(getCallNurseCallTimeContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 心身の状態に内部項目を追加します。
   */
  protected void addCallNurseMindState(){

  }

  /**
   * 主たる傷病名に内部項目を追加します。
   */
  protected void addCallNurseMainDiseaseName(){

  }

  /**
   * 厚生大臣の定める疾病に内部項目を追加します。
   */
  protected void addCallNurseInsuranceRadio(){

  }

  /**
   * 厚生大臣の定める疾病モデルに内部項目を追加します。
   */
  protected void addCallNurseInsuranceRadioModel(){

    getCallNurseInsuranceRadioItem1().setButtonIndex(1);

    getCallNurseInsuranceRadioModel().add(getCallNurseInsuranceRadioItem1());

    getCallNurseInsuranceRadioItem2().setButtonIndex(2);

    getCallNurseInsuranceRadioModel().add(getCallNurseInsuranceRadioItem2());

  }

  /**
   * 非該当に内部項目を追加します。
   */
  protected void addCallNurseInsuranceRadioItem1(){

  }

  /**
   * 該当に内部項目を追加します。
   */
  protected void addCallNurseInsuranceRadioItem2(){

  }

  /**
   * スペース1に内部項目を追加します。
   */
  protected void addCallNurseOfficialSpace1(){

  }

  /**
   * 職務上の事由に内部項目を追加します。
   */
  protected void addCallNurseOfficialRadio(){

  }

  /**
   * 職務上の事由モデルに内部項目を追加します。
   */
  protected void addCallNurseOfficialRadioModel(){

    getCallNurseOfficialRadioItem1().setButtonIndex(1);

    getCallNurseOfficialRadioModel().add(getCallNurseOfficialRadioItem1());

    getCallNurseOfficialRadioItem2().setButtonIndex(2);

    getCallNurseOfficialRadioModel().add(getCallNurseOfficialRadioItem2());

    getCallNurseOfficialRadioItem3().setButtonIndex(3);

    getCallNurseOfficialRadioModel().add(getCallNurseOfficialRadioItem3());

  }

  /**
   * 1.職務上に内部項目を追加します。
   */
  protected void addCallNurseOfficialRadioItem1(){

  }

  /**
   * 2.下船後3月以内に内部項目を追加します。
   */
  protected void addCallNurseOfficialRadioItem2(){

  }

  /**
   * 3.通勤災害に内部項目を追加します。
   */
  protected void addCallNurseOfficialRadioItem3(){

  }

  /**
   * スペース2に内部項目を追加します。
   */
  protected void addCallNurseOfficialSpace2(){

  }

  /**
   * 特地加算の有無に内部項目を追加します。
   */
  protected void addCallNurseAddParticularRadio(){

  }

  /**
   * 特地加算の有無モデルに内部項目を追加します。
   */
  protected void addCallNurseAddParticularRadioModel(){

    getCallNurseAddParticularRadioItem1().setButtonIndex(1);

    getCallNurseAddParticularRadioModel().add(getCallNurseAddParticularRadioItem1());

    getCallNurseAddParticularRadioItem2().setButtonIndex(2);

    getCallNurseAddParticularRadioModel().add(getCallNurseAddParticularRadioItem2());

  }

  /**
   * 無に内部項目を追加します。
   */
  protected void addCallNurseAddParticularRadioItem1(){

  }

  /**
   * 有に内部項目を追加します。
   */
  protected void addCallNurseAddParticularRadioItem2(){

  }

  /**
   * 訪問に要する時間に内部項目を追加します。
   */
  protected void addCallNurseCallTime(){

  }

  /**
   * 指示書情報領域に内部項目を追加します。
   */
  protected void addInstructInfos(){

    instructInfos.add(getInstructInfoValidLimitContena(), VRLayout.FLOW_INSETLINE_RETURN);

    instructInfos.add(getSpecialInstructContena(), VRLayout.FLOW_INSETLINE_RETURN);

    instructInfos.add(getSpecialInstructCommentSpace1(), VRLayout.FLOW_INSETLINE);

    instructInfos.add(getSpecialInstructComment1(), VRLayout.FLOW_INSETLINE_RETURN);

    instructInfos.add(getSpecialInstructCommentSpace2(), VRLayout.FLOW_INSETLINE);

    instructInfos.add(getSpecialInstructComment2(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 指示書有効期間・コンテナに内部項目を追加します。
   */
  protected void addInstructInfoValidLimitContena(){

    instructInfoValidLimitContena.add(getInstructInfoValidLimitPanel1(), VRLayout.FLOW);

  }

  /**
   * 指示有効期間・パネル1に内部項目を追加します。
   */
  protected void addInstructInfoValidLimitPanel1(){

    instructInfoValidLimitPanel1.add(getInstructInfoValidLimit1(), VRLayout.FLOW);

    instructInfoValidLimitPanel1.add(getInstructInfoValidLimitLabel(), VRLayout.FLOW);

    instructInfoValidLimitPanel1.add(getInstructInfoValidLimit2(), VRLayout.FLOW);

  }

  /**
   * 指示書有効期間・テキスト1に内部項目を追加します。
   */
  protected void addInstructInfoValidLimit1(){

  }

  /**
   * 指示書有効期間・ラベルに内部項目を追加します。
   */
  protected void addInstructInfoValidLimitLabel(){

  }

  /**
   * 指示書有効期間・テキスト2に内部項目を追加します。
   */
  protected void addInstructInfoValidLimit2(){

  }

  /**
   * 特別指示書・コンテナに内部項目を追加します。
   */
  protected void addSpecialInstructContena(){

    specialInstructContena.add(getSpecialInstructPanel1(), VRLayout.FLOW);

    specialInstructContena.add(getSpecialInstructPanel2(), VRLayout.FLOW);

  }

  /**
   * 特別指示書・パネル1に内部項目を追加します。
   */
  protected void addSpecialInstructPanel1(){

    specialInstructPanel1.add(getSpecialInstruct1(), VRLayout.FLOW);

    specialInstructPanel1.add(getSpecialInstructLabel1(), VRLayout.FLOW);

    specialInstructPanel1.add(getSpecialInstruct2(), VRLayout.FLOW);

  }

  /**
   * 特別指示書・テキスト1に内部項目を追加します。
   */
  protected void addSpecialInstruct1(){

  }

  /**
   * 特別指示書・ラベルに内部項目を追加します。
   */
  protected void addSpecialInstructLabel1(){

  }

  /**
   * 特別指示書・テキスト2に内部項目を追加します。
   */
  protected void addSpecialInstruct2(){

  }

  /**
   * 特別指示書・パネル2に内部項目を追加します。
   */
  protected void addSpecialInstructPanel2(){

    specialInstructPanel2.add(getSpecialInstructButton2(), VRLayout.FLOW);

  }

  /**
   * クリアに内部項目を追加します。
   */
  protected void addSpecialInstructButton2(){

  }

  /**
   * コメントスペース1に内部項目を追加します。
   */
  protected void addSpecialInstructCommentSpace1(){

  }

  /**
   * コメント1に内部項目を追加します。
   */
  protected void addSpecialInstructComment1(){

  }

  /**
   * コメントスペース2に内部項目を追加します。
   */
  protected void addSpecialInstructCommentSpace2(){

  }

  /**
   * コメント2に内部項目を追加します。
   */
  protected void addSpecialInstructComment2(){

  }

  /**
   * 医療機関情報に内部項目を追加します。
   */
  protected void addMedicalTreatmentInfos(){

    medicalTreatmentInfos.add(getMedicalTreatmentBasicInfos(), VRLayout.NORTH);

  }

  /**
   * 医療機関基本情報パネルに内部項目を追加します。
   */
  protected void addMedicalTreatmentBasicInfos(){

    medicalTreatmentBasicInfos.add(getMedicalTreatmentInfoOrganContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalTreatmentBasicInfos.add(getMedicalTreatmentInfoZipContainer(), VRLayout.FLOW_INSETLINE);

    medicalTreatmentBasicInfos.add(getMedicalTreatmentInfoAddressContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalTreatmentBasicInfos.add(getMedicalTreatmentInfoTelContainer(), VRLayout.FLOW_INSETLINE);

    medicalTreatmentBasicInfos.add(getMedicalTreatmentInfoFaxContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalTreatmentBasicInfos.add(getMedicalTreatmentInfoMainDoctorNameContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 主治医の属する医療機関の名称に内部項目を追加します。
   */
  protected void addMedicalTreatmentInfoOrgan(){

  }

  /**
   * 主治医の属する医療機関の名称モデルに内部項目を追加します。
   */
  protected void addMedicalTreatmentInfoOrganModel(){

  }

  /**
   * 医療機関の郵便番号に内部項目を追加します。
   */
  protected void addMedicalTreatmentInfoZip(){

  }

  /**
   * 医療機関の住所に内部項目を追加します。
   */
  protected void addMedicalTreatmentInfoAddress(){

  }

  /**
   * 医療機関の電話番号に内部項目を追加します。
   */
  protected void addMedicalTreatmentInfoTel(){

  }

  /**
   * 医療機関のFAX番号に内部項目を追加します。
   */
  protected void addMedicalTreatmentInfoFax(){

  }

  /**
   * 主治医の氏名に内部項目を追加します。
   */
  protected void addMedicalTreatmentInfoMainDoctorName(){

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
      ACFrame.debugStart(new ACAffairInfo(QU003Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QU003Design getThis() {
    return this;
  }
}
