
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
 * 作成日: 2015/02/19  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン介護予防短期入所療養介護（認知症） (QS001_12613_201504)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
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
 * サービスパターン介護予防短期入所療養介護（認知症）画面項目デザイン(QS001_12613_201504) 
 */
public class QS001_12613_201504Design extends QS001ServicePanel {
  //GUIコンポーネント

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup shortStayDementiaRecuperationInstitutionDivisionRadio;

  private ACLabelContainer shortStayDementiaRecuperationInstitutionDivisionRadioContainer;

  private ACListModelAdapter shortStayDementiaRecuperationInstitutionDivisionRadioModel;

  private ACRadioButtonItem shortStayDementiaRecuperationInstitutionDivisionRadioItem1;

  private ACRadioButtonItem shortStayDementiaRecuperationInstitutionDivisionRadioItem2;

  private ACRadioButtonItem shortStayDementiaRecuperationInstitutionDivisionRadioItem3;

  private ACValueArrayRadioButtonGroup shortStayDementiaRecuperationHospitalDivisionRadio;

  private ACLabelContainer shortStayDementiaRecuperationHospitalDivisionRadioContainer;

  private ACListModelAdapter shortStayDementiaRecuperationHospitalDivisionRadioModel;

  private ACRadioButtonItem shortStayDementiaRecuperationHospitalDivisionRadioItem1;

  private ACRadioButtonItem shortStayDementiaRecuperationHospitalDivisionRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayDementiaRecuperationDivision;

  private ACLabelContainer shortStayDementiaRecuperationDivisionContainer;

  private ACListModelAdapter shortStayDementiaRecuperationDivisionModel;

  private ACRadioButtonItem shortStayDementiaRecuperationType1;

  private ACRadioButtonItem shortStayDementiaRecuperationType2;

  private ACRadioButtonItem shortStayDementiaRecuperationType3;

  private ACRadioButtonItem shortStayDementiaRecuperationType4;

  private ACRadioButtonItem shortStayDementiaRecuperationType5;

  private ACLabelContainer shortStayDementiaRecuperationHospitalRoomDivisionContena;

  private ACValueArrayRadioButtonGroup shortStayDementiaRecuperationHospitalRoomRadio;

  private ACListModelAdapter shortStayDementiaRecuperationHospitalRoomRadioModel;

  private ACRadioButtonItem shortStayDementiaRecuperationHospitalRoomRadioItem1;

  private ACRadioButtonItem shortStayDementiaRecuperationHospitalRoomRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayDementiaRecuperationUnitHospitalRoomRadio;

  private ACListModelAdapter shortStayDementiaRecuperationUnitHospitalRoomRadioModel;

  private ACRadioButtonItem shortStayDementiaRecuperationUnitHospitalRoomRadioItem1;

  private ACRadioButtonItem shortStayDementiaRecuperationUnitHospitalRoomRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayDementiaRecuperationMeetingAndSendingOff;

  private ACLabelContainer shortStayDementiaRecuperationMeetingAndSendingOffContainer;

  private ACListModelAdapter shortStayDementiaRecuperationMeetingAndSendingOffModel;

  private ACRadioButtonItem shortStayDementiaRecuperationMeetingAndSendingOffNone;

  private ACRadioButtonItem shortStayDementiaRecuperationMeetingAndSendingOffOneWay;

  private ACRadioButtonItem shortStayDementiaRecuperationMeetingAndSendingOffRoundTrip;

  private ACValueArrayRadioButtonGroup shortStayDementiaRecuperationMedicalExpensesRadio;

  private ACLabelContainer shortStayDementiaRecuperationMedicalExpensesRadioContainer;

  private ACListModelAdapter shortStayDementiaRecuperationMedicalExpensesRadioModel;

  private ACRadioButtonItem shortStayDementiaRecuperationMedicalExpensesRadioItem1;

  private ACRadioButtonItem shortStayDementiaRecuperationMedicalExpensesRadioItem2;

  private ACPanel tab2;

  private ACMapBindButton shortStayDementiaRecuperationSpecificConsultationFee;

  private ACLabel shortStayDementiaRecuperationSpecificConsultationFeeOutline;

  private ACComboBox shortStayDementiaRecuperationPersonSubtraction;

  private ACLabelContainer shortStayDementiaRecuperationPersonSubtractionContainer;

  private ACComboBoxModelAdapter shortStayDementiaRecuperationPersonSubtractionModel;

  private ACBackLabelContainer shortStayDementiaRecuperationDinnerContainer;

  private ACComboBox shortStayDementiaRecuperationDinnerOffer;

  private ACLabelContainer shortStayDementiaRecuperationDinnerOfferContainer;

  private ACComboBoxModelAdapter shortStayDementiaRecuperationDinnerOfferModel;

  private ACTextField shortStayDementiaRecuperationDinnerCost;

  private ACLabelContainer shortStayDementiaRecuperationDinnerCostContainer;

  private ACIntegerCheckBox shortStayDementiaRecuperationEtc30Over;

  private ACValueArrayRadioButtonGroup shortStayDementiaRecuperationUnitCareMaintenanceRadio;

  private ACLabelContainer shortStayDementiaRecuperationUnitCareMaintenanceRadioContainer;

  private ACListModelAdapter shortStayDementiaRecuperationUnitCareMaintenanceRadioModel;

  private ACRadioButtonItem shortStayDementiaRecuperationUnitCareMaintenanceRadioItem1;

  private ACRadioButtonItem shortStayDementiaRecuperationUnitCareMaintenanceRadioItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  //getter

  /**
   * タブペインを取得します。
   * @return タブペイン
   */
  public JTabbedPane getTabs(){
    if(tabs==null){

      tabs = new JTabbedPane();

      addTabs();
    }
    return tabs;

  }

  /**
   * タブ1を取得します。
   * @return タブ1
   */
  public ACPanel getTab1(){
    if(tab1==null){

      tab1 = new ACPanel();

      tab1.setFollowChildEnabled(true);

      tab1.setHgap(0);

      addTab1();
    }
    return tab1;

  }

  /**
   * 施設等の区分を取得します。
   * @return 施設等の区分
   */
  public ACValueArrayRadioButtonGroup getShortStayDementiaRecuperationInstitutionDivisionRadio(){
    if(shortStayDementiaRecuperationInstitutionDivisionRadio==null){

      shortStayDementiaRecuperationInstitutionDivisionRadio = new ACValueArrayRadioButtonGroup();

      getShortStayDementiaRecuperationInstitutionDivisionRadioContainer().setText("施設等の区分");

      shortStayDementiaRecuperationInstitutionDivisionRadio.setBindPath("1260301");

      shortStayDementiaRecuperationInstitutionDivisionRadio.setUseClearButton(false);

      shortStayDementiaRecuperationInstitutionDivisionRadio.setModel(getShortStayDementiaRecuperationInstitutionDivisionRadioModel());

      shortStayDementiaRecuperationInstitutionDivisionRadio.setValues(new int[]{1,2,3});

      addShortStayDementiaRecuperationInstitutionDivisionRadio();
    }
    return shortStayDementiaRecuperationInstitutionDivisionRadio;

  }

  /**
   * 施設等の区分コンテナを取得します。
   * @return 施設等の区分コンテナ
   */
  protected ACLabelContainer getShortStayDementiaRecuperationInstitutionDivisionRadioContainer(){
    if(shortStayDementiaRecuperationInstitutionDivisionRadioContainer==null){
      shortStayDementiaRecuperationInstitutionDivisionRadioContainer = new ACLabelContainer();
      shortStayDementiaRecuperationInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayDementiaRecuperationInstitutionDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayDementiaRecuperationInstitutionDivisionRadioContainer.add(getShortStayDementiaRecuperationInstitutionDivisionRadio(), null);
    }
    return shortStayDementiaRecuperationInstitutionDivisionRadioContainer;
  }

  /**
   * 施設等の区分モデルを取得します。
   * @return 施設等の区分モデル
   */
  protected ACListModelAdapter getShortStayDementiaRecuperationInstitutionDivisionRadioModel(){
    if(shortStayDementiaRecuperationInstitutionDivisionRadioModel==null){
      shortStayDementiaRecuperationInstitutionDivisionRadioModel = new ACListModelAdapter();
      addShortStayDementiaRecuperationInstitutionDivisionRadioModel();
    }
    return shortStayDementiaRecuperationInstitutionDivisionRadioModel;
  }

  /**
   * 認知症疾患型を取得します。
   * @return 認知症疾患型
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationInstitutionDivisionRadioItem1(){
    if(shortStayDementiaRecuperationInstitutionDivisionRadioItem1==null){

      shortStayDementiaRecuperationInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayDementiaRecuperationInstitutionDivisionRadioItem1.setText("認知症疾患型");

      shortStayDementiaRecuperationInstitutionDivisionRadioItem1.setGroup(getShortStayDementiaRecuperationInstitutionDivisionRadio());

      shortStayDementiaRecuperationInstitutionDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayDementiaRecuperationInstitutionDivisionRadioItem1();
    }
    return shortStayDementiaRecuperationInstitutionDivisionRadioItem1;

  }

  /**
   * ユニット型認知症疾患型を取得します。
   * @return ユニット型認知症疾患型
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationInstitutionDivisionRadioItem2(){
    if(shortStayDementiaRecuperationInstitutionDivisionRadioItem2==null){

      shortStayDementiaRecuperationInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayDementiaRecuperationInstitutionDivisionRadioItem2.setText("ユニット型認知症疾患型");

      shortStayDementiaRecuperationInstitutionDivisionRadioItem2.setGroup(getShortStayDementiaRecuperationInstitutionDivisionRadio());

      shortStayDementiaRecuperationInstitutionDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayDementiaRecuperationInstitutionDivisionRadioItem2();
    }
    return shortStayDementiaRecuperationInstitutionDivisionRadioItem2;

  }

  /**
   * 経過型を取得します。
   * @return 経過型
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationInstitutionDivisionRadioItem3(){
    if(shortStayDementiaRecuperationInstitutionDivisionRadioItem3==null){

      shortStayDementiaRecuperationInstitutionDivisionRadioItem3 = new ACRadioButtonItem();

      shortStayDementiaRecuperationInstitutionDivisionRadioItem3.setText("経過型");

      shortStayDementiaRecuperationInstitutionDivisionRadioItem3.setGroup(getShortStayDementiaRecuperationInstitutionDivisionRadio());

      shortStayDementiaRecuperationInstitutionDivisionRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationInstitutionDivisionRadioItem3();
    }
    return shortStayDementiaRecuperationInstitutionDivisionRadioItem3;

  }

  /**
   * 病院区分を取得します。
   * @return 病院区分
   */
  public ACValueArrayRadioButtonGroup getShortStayDementiaRecuperationHospitalDivisionRadio(){
    if(shortStayDementiaRecuperationHospitalDivisionRadio==null){

      shortStayDementiaRecuperationHospitalDivisionRadio = new ACValueArrayRadioButtonGroup();

      getShortStayDementiaRecuperationHospitalDivisionRadioContainer().setText("病院区分");

      shortStayDementiaRecuperationHospitalDivisionRadio.setBindPath("1260302");

      shortStayDementiaRecuperationHospitalDivisionRadio.setUseClearButton(false);

      shortStayDementiaRecuperationHospitalDivisionRadio.setModel(getShortStayDementiaRecuperationHospitalDivisionRadioModel());

      shortStayDementiaRecuperationHospitalDivisionRadio.setValues(new int[]{1,2});

      addShortStayDementiaRecuperationHospitalDivisionRadio();
    }
    return shortStayDementiaRecuperationHospitalDivisionRadio;

  }

  /**
   * 病院区分コンテナを取得します。
   * @return 病院区分コンテナ
   */
  protected ACLabelContainer getShortStayDementiaRecuperationHospitalDivisionRadioContainer(){
    if(shortStayDementiaRecuperationHospitalDivisionRadioContainer==null){
      shortStayDementiaRecuperationHospitalDivisionRadioContainer = new ACLabelContainer();
      shortStayDementiaRecuperationHospitalDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayDementiaRecuperationHospitalDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayDementiaRecuperationHospitalDivisionRadioContainer.add(getShortStayDementiaRecuperationHospitalDivisionRadio(), null);
    }
    return shortStayDementiaRecuperationHospitalDivisionRadioContainer;
  }

  /**
   * 病院区分モデルを取得します。
   * @return 病院区分モデル
   */
  protected ACListModelAdapter getShortStayDementiaRecuperationHospitalDivisionRadioModel(){
    if(shortStayDementiaRecuperationHospitalDivisionRadioModel==null){
      shortStayDementiaRecuperationHospitalDivisionRadioModel = new ACListModelAdapter();
      addShortStayDementiaRecuperationHospitalDivisionRadioModel();
    }
    return shortStayDementiaRecuperationHospitalDivisionRadioModel;
  }

  /**
   * 大学病院を取得します。
   * @return 大学病院
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationHospitalDivisionRadioItem1(){
    if(shortStayDementiaRecuperationHospitalDivisionRadioItem1==null){

      shortStayDementiaRecuperationHospitalDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayDementiaRecuperationHospitalDivisionRadioItem1.setText("大学病院");

      shortStayDementiaRecuperationHospitalDivisionRadioItem1.setGroup(getShortStayDementiaRecuperationHospitalDivisionRadio());

      shortStayDementiaRecuperationHospitalDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationHospitalDivisionRadioItem1();
    }
    return shortStayDementiaRecuperationHospitalDivisionRadioItem1;

  }

  /**
   * 一般病院を取得します。
   * @return 一般病院
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationHospitalDivisionRadioItem2(){
    if(shortStayDementiaRecuperationHospitalDivisionRadioItem2==null){

      shortStayDementiaRecuperationHospitalDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayDementiaRecuperationHospitalDivisionRadioItem2.setText("一般病院");

      shortStayDementiaRecuperationHospitalDivisionRadioItem2.setGroup(getShortStayDementiaRecuperationHospitalDivisionRadio());

      shortStayDementiaRecuperationHospitalDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationHospitalDivisionRadioItem2();
    }
    return shortStayDementiaRecuperationHospitalDivisionRadioItem2;

  }

  /**
   * 人員配置区分を取得します。
   * @return 人員配置区分
   */
  public ACValueArrayRadioButtonGroup getShortStayDementiaRecuperationDivision(){
    if(shortStayDementiaRecuperationDivision==null){

      shortStayDementiaRecuperationDivision = new ACValueArrayRadioButtonGroup();

      getShortStayDementiaRecuperationDivisionContainer().setText("人員配置区分");

      shortStayDementiaRecuperationDivision.setBindPath("1260303");

      shortStayDementiaRecuperationDivision.setUseClearButton(false);

      shortStayDementiaRecuperationDivision.setModel(getShortStayDementiaRecuperationDivisionModel());

      shortStayDementiaRecuperationDivision.setValues(new int[]{1,2,3,4,5});

      addShortStayDementiaRecuperationDivision();
    }
    return shortStayDementiaRecuperationDivision;

  }

  /**
   * 人員配置区分コンテナを取得します。
   * @return 人員配置区分コンテナ
   */
  protected ACLabelContainer getShortStayDementiaRecuperationDivisionContainer(){
    if(shortStayDementiaRecuperationDivisionContainer==null){
      shortStayDementiaRecuperationDivisionContainer = new ACLabelContainer();
      shortStayDementiaRecuperationDivisionContainer.setFollowChildEnabled(true);
      shortStayDementiaRecuperationDivisionContainer.setVAlignment(VRLayout.CENTER);
      shortStayDementiaRecuperationDivisionContainer.add(getShortStayDementiaRecuperationDivision(), null);
    }
    return shortStayDementiaRecuperationDivisionContainer;
  }

  /**
   * 人員配置区分モデルを取得します。
   * @return 人員配置区分モデル
   */
  protected ACListModelAdapter getShortStayDementiaRecuperationDivisionModel(){
    if(shortStayDementiaRecuperationDivisionModel==null){
      shortStayDementiaRecuperationDivisionModel = new ACListModelAdapter();
      addShortStayDementiaRecuperationDivisionModel();
    }
    return shortStayDementiaRecuperationDivisionModel;
  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationType1(){
    if(shortStayDementiaRecuperationType1==null){

      shortStayDementiaRecuperationType1 = new ACRadioButtonItem();

      shortStayDementiaRecuperationType1.setText("I型");

      shortStayDementiaRecuperationType1.setGroup(getShortStayDementiaRecuperationDivision());

      shortStayDementiaRecuperationType1.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationType1();
    }
    return shortStayDementiaRecuperationType1;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationType2(){
    if(shortStayDementiaRecuperationType2==null){

      shortStayDementiaRecuperationType2 = new ACRadioButtonItem();

      shortStayDementiaRecuperationType2.setText("II型");

      shortStayDementiaRecuperationType2.setGroup(getShortStayDementiaRecuperationDivision());

      shortStayDementiaRecuperationType2.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationType2();
    }
    return shortStayDementiaRecuperationType2;

  }

  /**
   * III型を取得します。
   * @return III型
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationType3(){
    if(shortStayDementiaRecuperationType3==null){

      shortStayDementiaRecuperationType3 = new ACRadioButtonItem();

      shortStayDementiaRecuperationType3.setText("III型");

      shortStayDementiaRecuperationType3.setGroup(getShortStayDementiaRecuperationDivision());

      shortStayDementiaRecuperationType3.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayDementiaRecuperationType3();
    }
    return shortStayDementiaRecuperationType3;

  }

  /**
   * IV型を取得します。
   * @return IV型
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationType4(){
    if(shortStayDementiaRecuperationType4==null){

      shortStayDementiaRecuperationType4 = new ACRadioButtonItem();

      shortStayDementiaRecuperationType4.setText("IV型");

      shortStayDementiaRecuperationType4.setGroup(getShortStayDementiaRecuperationDivision());

      shortStayDementiaRecuperationType4.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationType4();
    }
    return shortStayDementiaRecuperationType4;

  }

  /**
   * V型を取得します。
   * @return V型
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationType5(){
    if(shortStayDementiaRecuperationType5==null){

      shortStayDementiaRecuperationType5 = new ACRadioButtonItem();

      shortStayDementiaRecuperationType5.setText("V型");

      shortStayDementiaRecuperationType5.setGroup(getShortStayDementiaRecuperationDivision());

      shortStayDementiaRecuperationType5.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationType5();
    }
    return shortStayDementiaRecuperationType5;

  }

  /**
   * 病室区分コンテナを取得します。
   * @return 病室区分コンテナ
   */
  public ACLabelContainer getShortStayDementiaRecuperationHospitalRoomDivisionContena(){
    if(shortStayDementiaRecuperationHospitalRoomDivisionContena==null){

      shortStayDementiaRecuperationHospitalRoomDivisionContena = new ACLabelContainer();

      shortStayDementiaRecuperationHospitalRoomDivisionContena.setText("病室区分");

      shortStayDementiaRecuperationHospitalRoomDivisionContena.setFollowChildEnabled(true);

      addShortStayDementiaRecuperationHospitalRoomDivisionContena();
    }
    return shortStayDementiaRecuperationHospitalRoomDivisionContena;

  }

  /**
   * 病室区分（介護老人保健施設）を取得します。
   * @return 病室区分（介護老人保健施設）
   */
  public ACValueArrayRadioButtonGroup getShortStayDementiaRecuperationHospitalRoomRadio(){
    if(shortStayDementiaRecuperationHospitalRoomRadio==null){

      shortStayDementiaRecuperationHospitalRoomRadio = new ACValueArrayRadioButtonGroup();

      shortStayDementiaRecuperationHospitalRoomRadio.setBindPath("1260304");

      shortStayDementiaRecuperationHospitalRoomRadio.setUseClearButton(false);

      shortStayDementiaRecuperationHospitalRoomRadio.setModel(getShortStayDementiaRecuperationHospitalRoomRadioModel());

      shortStayDementiaRecuperationHospitalRoomRadio.setValues(new int[]{1,2});

      addShortStayDementiaRecuperationHospitalRoomRadio();
    }
    return shortStayDementiaRecuperationHospitalRoomRadio;

  }

  /**
   * 病室区分（介護老人保健施設）モデルを取得します。
   * @return 病室区分（介護老人保健施設）モデル
   */
  protected ACListModelAdapter getShortStayDementiaRecuperationHospitalRoomRadioModel(){
    if(shortStayDementiaRecuperationHospitalRoomRadioModel==null){
      shortStayDementiaRecuperationHospitalRoomRadioModel = new ACListModelAdapter();
      addShortStayDementiaRecuperationHospitalRoomRadioModel();
    }
    return shortStayDementiaRecuperationHospitalRoomRadioModel;
  }

  /**
   * 従来型個室を取得します。
   * @return 従来型個室
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationHospitalRoomRadioItem1(){
    if(shortStayDementiaRecuperationHospitalRoomRadioItem1==null){

      shortStayDementiaRecuperationHospitalRoomRadioItem1 = new ACRadioButtonItem();

      shortStayDementiaRecuperationHospitalRoomRadioItem1.setText("従来型個室");

      shortStayDementiaRecuperationHospitalRoomRadioItem1.setGroup(getShortStayDementiaRecuperationHospitalRoomRadio());

      shortStayDementiaRecuperationHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationHospitalRoomRadioItem1();
    }
    return shortStayDementiaRecuperationHospitalRoomRadioItem1;

  }

  /**
   * 多床室を取得します。
   * @return 多床室
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationHospitalRoomRadioItem2(){
    if(shortStayDementiaRecuperationHospitalRoomRadioItem2==null){

      shortStayDementiaRecuperationHospitalRoomRadioItem2 = new ACRadioButtonItem();

      shortStayDementiaRecuperationHospitalRoomRadioItem2.setText("多床室");

      shortStayDementiaRecuperationHospitalRoomRadioItem2.setGroup(getShortStayDementiaRecuperationHospitalRoomRadio());

      shortStayDementiaRecuperationHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationHospitalRoomRadioItem2();
    }
    return shortStayDementiaRecuperationHospitalRoomRadioItem2;

  }

  /**
   * 病室区分（ユニット型）を取得します。
   * @return 病室区分（ユニット型）
   */
  public ACValueArrayRadioButtonGroup getShortStayDementiaRecuperationUnitHospitalRoomRadio(){
    if(shortStayDementiaRecuperationUnitHospitalRoomRadio==null){

      shortStayDementiaRecuperationUnitHospitalRoomRadio = new ACValueArrayRadioButtonGroup();

      shortStayDementiaRecuperationUnitHospitalRoomRadio.setBindPath("1260305");

      shortStayDementiaRecuperationUnitHospitalRoomRadio.setUseClearButton(false);

      shortStayDementiaRecuperationUnitHospitalRoomRadio.setModel(getShortStayDementiaRecuperationUnitHospitalRoomRadioModel());

      shortStayDementiaRecuperationUnitHospitalRoomRadio.setValues(new int[]{1,2});

      addShortStayDementiaRecuperationUnitHospitalRoomRadio();
    }
    return shortStayDementiaRecuperationUnitHospitalRoomRadio;

  }

  /**
   * 病室区分（ユニット型）モデルを取得します。
   * @return 病室区分（ユニット型）モデル
   */
  protected ACListModelAdapter getShortStayDementiaRecuperationUnitHospitalRoomRadioModel(){
    if(shortStayDementiaRecuperationUnitHospitalRoomRadioModel==null){
      shortStayDementiaRecuperationUnitHospitalRoomRadioModel = new ACListModelAdapter();
      addShortStayDementiaRecuperationUnitHospitalRoomRadioModel();
    }
    return shortStayDementiaRecuperationUnitHospitalRoomRadioModel;
  }

  /**
   * ユニット型個室を取得します。
   * @return ユニット型個室
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationUnitHospitalRoomRadioItem1(){
    if(shortStayDementiaRecuperationUnitHospitalRoomRadioItem1==null){

      shortStayDementiaRecuperationUnitHospitalRoomRadioItem1 = new ACRadioButtonItem();

      shortStayDementiaRecuperationUnitHospitalRoomRadioItem1.setText("ユニット型個室");

      shortStayDementiaRecuperationUnitHospitalRoomRadioItem1.setGroup(getShortStayDementiaRecuperationUnitHospitalRoomRadio());

      shortStayDementiaRecuperationUnitHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationUnitHospitalRoomRadioItem1();
    }
    return shortStayDementiaRecuperationUnitHospitalRoomRadioItem1;

  }

  /**
   * ユニット型準個室を取得します。
   * @return ユニット型準個室
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationUnitHospitalRoomRadioItem2(){
    if(shortStayDementiaRecuperationUnitHospitalRoomRadioItem2==null){

      shortStayDementiaRecuperationUnitHospitalRoomRadioItem2 = new ACRadioButtonItem();

      shortStayDementiaRecuperationUnitHospitalRoomRadioItem2.setText("ユニット型準個室");

      shortStayDementiaRecuperationUnitHospitalRoomRadioItem2.setGroup(getShortStayDementiaRecuperationUnitHospitalRoomRadio());

      shortStayDementiaRecuperationUnitHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationUnitHospitalRoomRadioItem2();
    }
    return shortStayDementiaRecuperationUnitHospitalRoomRadioItem2;

  }

  /**
   * 送迎区分を取得します。
   * @return 送迎区分
   */
  public ACValueArrayRadioButtonGroup getShortStayDementiaRecuperationMeetingAndSendingOff(){
    if(shortStayDementiaRecuperationMeetingAndSendingOff==null){

      shortStayDementiaRecuperationMeetingAndSendingOff = new ACValueArrayRadioButtonGroup();

      getShortStayDementiaRecuperationMeetingAndSendingOffContainer().setText("送迎加算");

      shortStayDementiaRecuperationMeetingAndSendingOff.setBindPath("6");

      shortStayDementiaRecuperationMeetingAndSendingOff.setUseClearButton(false);

      shortStayDementiaRecuperationMeetingAndSendingOff.setModel(getShortStayDementiaRecuperationMeetingAndSendingOffModel());

      shortStayDementiaRecuperationMeetingAndSendingOff.setValues(new int[]{1,2,3});

      addShortStayDementiaRecuperationMeetingAndSendingOff();
    }
    return shortStayDementiaRecuperationMeetingAndSendingOff;

  }

  /**
   * 送迎区分コンテナを取得します。
   * @return 送迎区分コンテナ
   */
  protected ACLabelContainer getShortStayDementiaRecuperationMeetingAndSendingOffContainer(){
    if(shortStayDementiaRecuperationMeetingAndSendingOffContainer==null){
      shortStayDementiaRecuperationMeetingAndSendingOffContainer = new ACLabelContainer();
      shortStayDementiaRecuperationMeetingAndSendingOffContainer.setFollowChildEnabled(true);
      shortStayDementiaRecuperationMeetingAndSendingOffContainer.setVAlignment(VRLayout.CENTER);
      shortStayDementiaRecuperationMeetingAndSendingOffContainer.add(getShortStayDementiaRecuperationMeetingAndSendingOff(), null);
    }
    return shortStayDementiaRecuperationMeetingAndSendingOffContainer;
  }

  /**
   * 送迎区分モデルを取得します。
   * @return 送迎区分モデル
   */
  protected ACListModelAdapter getShortStayDementiaRecuperationMeetingAndSendingOffModel(){
    if(shortStayDementiaRecuperationMeetingAndSendingOffModel==null){
      shortStayDementiaRecuperationMeetingAndSendingOffModel = new ACListModelAdapter();
      addShortStayDementiaRecuperationMeetingAndSendingOffModel();
    }
    return shortStayDementiaRecuperationMeetingAndSendingOffModel;
  }

  /**
   * 送迎なしを取得します。
   * @return 送迎なし
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationMeetingAndSendingOffNone(){
    if(shortStayDementiaRecuperationMeetingAndSendingOffNone==null){

      shortStayDementiaRecuperationMeetingAndSendingOffNone = new ACRadioButtonItem();

      shortStayDementiaRecuperationMeetingAndSendingOffNone.setText("送迎なし");

      shortStayDementiaRecuperationMeetingAndSendingOffNone.setGroup(getShortStayDementiaRecuperationMeetingAndSendingOff());

      shortStayDementiaRecuperationMeetingAndSendingOffNone.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationMeetingAndSendingOffNone();
    }
    return shortStayDementiaRecuperationMeetingAndSendingOffNone;

  }

  /**
   * 送迎片道を取得します。
   * @return 送迎片道
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationMeetingAndSendingOffOneWay(){
    if(shortStayDementiaRecuperationMeetingAndSendingOffOneWay==null){

      shortStayDementiaRecuperationMeetingAndSendingOffOneWay = new ACRadioButtonItem();

      shortStayDementiaRecuperationMeetingAndSendingOffOneWay.setText("送迎片道");

      shortStayDementiaRecuperationMeetingAndSendingOffOneWay.setGroup(getShortStayDementiaRecuperationMeetingAndSendingOff());

      shortStayDementiaRecuperationMeetingAndSendingOffOneWay.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationMeetingAndSendingOffOneWay();
    }
    return shortStayDementiaRecuperationMeetingAndSendingOffOneWay;

  }

  /**
   * 送迎往復を取得します。
   * @return 送迎往復
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationMeetingAndSendingOffRoundTrip(){
    if(shortStayDementiaRecuperationMeetingAndSendingOffRoundTrip==null){

      shortStayDementiaRecuperationMeetingAndSendingOffRoundTrip = new ACRadioButtonItem();

      shortStayDementiaRecuperationMeetingAndSendingOffRoundTrip.setText("送迎往復");

      shortStayDementiaRecuperationMeetingAndSendingOffRoundTrip.setGroup(getShortStayDementiaRecuperationMeetingAndSendingOff());

      shortStayDementiaRecuperationMeetingAndSendingOffRoundTrip.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationMeetingAndSendingOffRoundTrip();
    }
    return shortStayDementiaRecuperationMeetingAndSendingOffRoundTrip;

  }

  /**
   * 療養食加算を取得します。
   * @return 療養食加算
   */
  public ACValueArrayRadioButtonGroup getShortStayDementiaRecuperationMedicalExpensesRadio(){
    if(shortStayDementiaRecuperationMedicalExpensesRadio==null){

      shortStayDementiaRecuperationMedicalExpensesRadio = new ACValueArrayRadioButtonGroup();

      getShortStayDementiaRecuperationMedicalExpensesRadioContainer().setText("療養食加算");

      shortStayDementiaRecuperationMedicalExpensesRadio.setBindPath("1260307");

      shortStayDementiaRecuperationMedicalExpensesRadio.setUseClearButton(false);

      shortStayDementiaRecuperationMedicalExpensesRadio.setModel(getShortStayDementiaRecuperationMedicalExpensesRadioModel());

      shortStayDementiaRecuperationMedicalExpensesRadio.setValues(new int[]{1,2});

      addShortStayDementiaRecuperationMedicalExpensesRadio();
    }
    return shortStayDementiaRecuperationMedicalExpensesRadio;

  }

  /**
   * 療養食加算コンテナを取得します。
   * @return 療養食加算コンテナ
   */
  protected ACLabelContainer getShortStayDementiaRecuperationMedicalExpensesRadioContainer(){
    if(shortStayDementiaRecuperationMedicalExpensesRadioContainer==null){
      shortStayDementiaRecuperationMedicalExpensesRadioContainer = new ACLabelContainer();
      shortStayDementiaRecuperationMedicalExpensesRadioContainer.setFollowChildEnabled(true);
      shortStayDementiaRecuperationMedicalExpensesRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayDementiaRecuperationMedicalExpensesRadioContainer.add(getShortStayDementiaRecuperationMedicalExpensesRadio(), null);
    }
    return shortStayDementiaRecuperationMedicalExpensesRadioContainer;
  }

  /**
   * 療養食加算モデルを取得します。
   * @return 療養食加算モデル
   */
  protected ACListModelAdapter getShortStayDementiaRecuperationMedicalExpensesRadioModel(){
    if(shortStayDementiaRecuperationMedicalExpensesRadioModel==null){
      shortStayDementiaRecuperationMedicalExpensesRadioModel = new ACListModelAdapter();
      addShortStayDementiaRecuperationMedicalExpensesRadioModel();
    }
    return shortStayDementiaRecuperationMedicalExpensesRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationMedicalExpensesRadioItem1(){
    if(shortStayDementiaRecuperationMedicalExpensesRadioItem1==null){

      shortStayDementiaRecuperationMedicalExpensesRadioItem1 = new ACRadioButtonItem();

      shortStayDementiaRecuperationMedicalExpensesRadioItem1.setText("なし");

      shortStayDementiaRecuperationMedicalExpensesRadioItem1.setGroup(getShortStayDementiaRecuperationMedicalExpensesRadio());

      shortStayDementiaRecuperationMedicalExpensesRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationMedicalExpensesRadioItem1();
    }
    return shortStayDementiaRecuperationMedicalExpensesRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationMedicalExpensesRadioItem2(){
    if(shortStayDementiaRecuperationMedicalExpensesRadioItem2==null){

      shortStayDementiaRecuperationMedicalExpensesRadioItem2 = new ACRadioButtonItem();

      shortStayDementiaRecuperationMedicalExpensesRadioItem2.setText("あり");

      shortStayDementiaRecuperationMedicalExpensesRadioItem2.setGroup(getShortStayDementiaRecuperationMedicalExpensesRadio());

      shortStayDementiaRecuperationMedicalExpensesRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationMedicalExpensesRadioItem2();
    }
    return shortStayDementiaRecuperationMedicalExpensesRadioItem2;

  }

  /**
   * タブ2を取得します。
   * @return タブ2
   */
  public ACPanel getTab2(){
    if(tab2==null){

      tab2 = new ACPanel();

      tab2.setFollowChildEnabled(true);

      tab2.setHgap(0);

      addTab2();
    }
    return tab2;

  }

  /**
   * 特定診療費ボタンを取得します。
   * @return 特定診療費ボタン
   */
  public ACMapBindButton getShortStayDementiaRecuperationSpecificConsultationFee(){
    if(shortStayDementiaRecuperationSpecificConsultationFee==null){

      shortStayDementiaRecuperationSpecificConsultationFee = new ACMapBindButton();

      shortStayDementiaRecuperationSpecificConsultationFee.setText("特定診療費");

      shortStayDementiaRecuperationSpecificConsultationFee.setToolTipText("特定診療費を設定します。");

      addShortStayDementiaRecuperationSpecificConsultationFee();
    }
    return shortStayDementiaRecuperationSpecificConsultationFee;

  }

  /**
   * 設定ラベルを取得します。
   * @return 設定ラベル
   */
  public ACLabel getShortStayDementiaRecuperationSpecificConsultationFeeOutline(){
    if(shortStayDementiaRecuperationSpecificConsultationFeeOutline==null){

      shortStayDementiaRecuperationSpecificConsultationFeeOutline = new ACLabel();

      shortStayDementiaRecuperationSpecificConsultationFeeOutline.setText("設定なし");

      shortStayDementiaRecuperationSpecificConsultationFeeOutline.setOpaque(true);
      shortStayDementiaRecuperationSpecificConsultationFeeOutline.setBackground(new Color(255,255,172));

      addShortStayDementiaRecuperationSpecificConsultationFeeOutline();
    }
    return shortStayDementiaRecuperationSpecificConsultationFeeOutline;

  }

  /**
   * 人員減算コンボを取得します。
   * @return 人員減算コンボ
   */
  public ACComboBox getShortStayDementiaRecuperationPersonSubtraction(){
    if(shortStayDementiaRecuperationPersonSubtraction==null){

      shortStayDementiaRecuperationPersonSubtraction = new ACComboBox();

      getShortStayDementiaRecuperationPersonSubtractionContainer().setText("人員減算");

      shortStayDementiaRecuperationPersonSubtraction.setBindPath("1260308");

      shortStayDementiaRecuperationPersonSubtraction.setEditable(false);

      shortStayDementiaRecuperationPersonSubtraction.setModelBindPath("1260308");

      shortStayDementiaRecuperationPersonSubtraction.setRenderBindPath("CONTENT");

      shortStayDementiaRecuperationPersonSubtraction.setModel(getShortStayDementiaRecuperationPersonSubtractionModel());

      addShortStayDementiaRecuperationPersonSubtraction();
    }
    return shortStayDementiaRecuperationPersonSubtraction;

  }

  /**
   * 人員減算コンボコンテナを取得します。
   * @return 人員減算コンボコンテナ
   */
  protected ACLabelContainer getShortStayDementiaRecuperationPersonSubtractionContainer(){
    if(shortStayDementiaRecuperationPersonSubtractionContainer==null){
      shortStayDementiaRecuperationPersonSubtractionContainer = new ACLabelContainer();
      shortStayDementiaRecuperationPersonSubtractionContainer.setFollowChildEnabled(true);
      shortStayDementiaRecuperationPersonSubtractionContainer.setVAlignment(VRLayout.CENTER);
      shortStayDementiaRecuperationPersonSubtractionContainer.add(getShortStayDementiaRecuperationPersonSubtraction(), null);
    }
    return shortStayDementiaRecuperationPersonSubtractionContainer;
  }

  /**
   * 人員減算コンボモデルを取得します。
   * @return 人員減算コンボモデル
   */
  protected ACComboBoxModelAdapter getShortStayDementiaRecuperationPersonSubtractionModel(){
    if(shortStayDementiaRecuperationPersonSubtractionModel==null){
      shortStayDementiaRecuperationPersonSubtractionModel = new ACComboBoxModelAdapter();
      addShortStayDementiaRecuperationPersonSubtractionModel();
    }
    return shortStayDementiaRecuperationPersonSubtractionModel;
  }

  /**
   * 食事コンテナを取得します。
   * @return 食事コンテナ
   */
  public ACBackLabelContainer getShortStayDementiaRecuperationDinnerContainer(){
    if(shortStayDementiaRecuperationDinnerContainer==null){

      shortStayDementiaRecuperationDinnerContainer = new ACBackLabelContainer();

      shortStayDementiaRecuperationDinnerContainer.setFollowChildEnabled(true);

      addShortStayDementiaRecuperationDinnerContainer();
    }
    return shortStayDementiaRecuperationDinnerContainer;

  }

  /**
   * 食事提供を取得します。
   * @return 食事提供
   */
  public ACComboBox getShortStayDementiaRecuperationDinnerOffer(){
    if(shortStayDementiaRecuperationDinnerOffer==null){

      shortStayDementiaRecuperationDinnerOffer = new ACComboBox();

      getShortStayDementiaRecuperationDinnerOfferContainer().setText("食事提供");

      shortStayDementiaRecuperationDinnerOffer.setBindPath("1260309");

      shortStayDementiaRecuperationDinnerOffer.setEditable(false);

      shortStayDementiaRecuperationDinnerOffer.setModelBindPath("1260309");

      shortStayDementiaRecuperationDinnerOffer.setRenderBindPath("CONTENT");

      shortStayDementiaRecuperationDinnerOffer.setModel(getShortStayDementiaRecuperationDinnerOfferModel());

      addShortStayDementiaRecuperationDinnerOffer();
    }
    return shortStayDementiaRecuperationDinnerOffer;

  }

  /**
   * 食事提供コンテナを取得します。
   * @return 食事提供コンテナ
   */
  protected ACLabelContainer getShortStayDementiaRecuperationDinnerOfferContainer(){
    if(shortStayDementiaRecuperationDinnerOfferContainer==null){
      shortStayDementiaRecuperationDinnerOfferContainer = new ACLabelContainer();
      shortStayDementiaRecuperationDinnerOfferContainer.setFollowChildEnabled(true);
      shortStayDementiaRecuperationDinnerOfferContainer.setVAlignment(VRLayout.CENTER);
      shortStayDementiaRecuperationDinnerOfferContainer.add(getShortStayDementiaRecuperationDinnerOffer(), null);
    }
    return shortStayDementiaRecuperationDinnerOfferContainer;
  }

  /**
   * 食事提供モデルを取得します。
   * @return 食事提供モデル
   */
  protected ACComboBoxModelAdapter getShortStayDementiaRecuperationDinnerOfferModel(){
    if(shortStayDementiaRecuperationDinnerOfferModel==null){
      shortStayDementiaRecuperationDinnerOfferModel = new ACComboBoxModelAdapter();
      addShortStayDementiaRecuperationDinnerOfferModel();
    }
    return shortStayDementiaRecuperationDinnerOfferModel;
  }

  /**
   * 食事費用を取得します。
   * @return 食事費用
   */
  public ACTextField getShortStayDementiaRecuperationDinnerCost(){
    if(shortStayDementiaRecuperationDinnerCost==null){

      shortStayDementiaRecuperationDinnerCost = new ACTextField();

      getShortStayDementiaRecuperationDinnerCostContainer().setText("食事費用");

      shortStayDementiaRecuperationDinnerCost.setBindPath("1260310");

      shortStayDementiaRecuperationDinnerCost.setColumns(4);

      shortStayDementiaRecuperationDinnerCost.setCharType(VRCharType.ONLY_DIGIT);

      shortStayDementiaRecuperationDinnerCost.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayDementiaRecuperationDinnerCost.setIMEMode(InputSubset.LATIN);

      shortStayDementiaRecuperationDinnerCost.setMaxLength(5);

      addShortStayDementiaRecuperationDinnerCost();
    }
    return shortStayDementiaRecuperationDinnerCost;

  }

  /**
   * 食事費用コンテナを取得します。
   * @return 食事費用コンテナ
   */
  protected ACLabelContainer getShortStayDementiaRecuperationDinnerCostContainer(){
    if(shortStayDementiaRecuperationDinnerCostContainer==null){
      shortStayDementiaRecuperationDinnerCostContainer = new ACLabelContainer();
      shortStayDementiaRecuperationDinnerCostContainer.setFollowChildEnabled(true);
      shortStayDementiaRecuperationDinnerCostContainer.setVAlignment(VRLayout.CENTER);
      shortStayDementiaRecuperationDinnerCostContainer.add(getShortStayDementiaRecuperationDinnerCost(), null);
    }
    return shortStayDementiaRecuperationDinnerCostContainer;
  }

  /**
   * 30日超を取得します。
   * @return 30日超
   */
  public ACIntegerCheckBox getShortStayDementiaRecuperationEtc30Over(){
    if(shortStayDementiaRecuperationEtc30Over==null){

      shortStayDementiaRecuperationEtc30Over = new ACIntegerCheckBox();

      shortStayDementiaRecuperationEtc30Over.setText("30日超");

      shortStayDementiaRecuperationEtc30Over.setBindPath("5");

      shortStayDementiaRecuperationEtc30Over.setSelectValue(2);

      shortStayDementiaRecuperationEtc30Over.setUnSelectValue(1);

      addShortStayDementiaRecuperationEtc30Over();
    }
    return shortStayDementiaRecuperationEtc30Over;

  }

  /**
   * ユニットケアの整備を取得します。
   * @return ユニットケアの整備
   */
  public ACValueArrayRadioButtonGroup getShortStayDementiaRecuperationUnitCareMaintenanceRadio(){
    if(shortStayDementiaRecuperationUnitCareMaintenanceRadio==null){

      shortStayDementiaRecuperationUnitCareMaintenanceRadio = new ACValueArrayRadioButtonGroup();

      getShortStayDementiaRecuperationUnitCareMaintenanceRadioContainer().setText("ユニットケアの整備");

      shortStayDementiaRecuperationUnitCareMaintenanceRadio.setBindPath("1260311");

      shortStayDementiaRecuperationUnitCareMaintenanceRadio.setUseClearButton(false);

      shortStayDementiaRecuperationUnitCareMaintenanceRadio.setModel(getShortStayDementiaRecuperationUnitCareMaintenanceRadioModel());

      shortStayDementiaRecuperationUnitCareMaintenanceRadio.setValues(new int[]{1,2});

      addShortStayDementiaRecuperationUnitCareMaintenanceRadio();
    }
    return shortStayDementiaRecuperationUnitCareMaintenanceRadio;

  }

  /**
   * ユニットケアの整備コンテナを取得します。
   * @return ユニットケアの整備コンテナ
   */
  protected ACLabelContainer getShortStayDementiaRecuperationUnitCareMaintenanceRadioContainer(){
    if(shortStayDementiaRecuperationUnitCareMaintenanceRadioContainer==null){
      shortStayDementiaRecuperationUnitCareMaintenanceRadioContainer = new ACLabelContainer();
      shortStayDementiaRecuperationUnitCareMaintenanceRadioContainer.setFollowChildEnabled(true);
      shortStayDementiaRecuperationUnitCareMaintenanceRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayDementiaRecuperationUnitCareMaintenanceRadioContainer.add(getShortStayDementiaRecuperationUnitCareMaintenanceRadio(), null);
    }
    return shortStayDementiaRecuperationUnitCareMaintenanceRadioContainer;
  }

  /**
   * ユニットケアの整備モデルを取得します。
   * @return ユニットケアの整備モデル
   */
  protected ACListModelAdapter getShortStayDementiaRecuperationUnitCareMaintenanceRadioModel(){
    if(shortStayDementiaRecuperationUnitCareMaintenanceRadioModel==null){
      shortStayDementiaRecuperationUnitCareMaintenanceRadioModel = new ACListModelAdapter();
      addShortStayDementiaRecuperationUnitCareMaintenanceRadioModel();
    }
    return shortStayDementiaRecuperationUnitCareMaintenanceRadioModel;
  }

  /**
   * 未整備を取得します。
   * @return 未整備
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationUnitCareMaintenanceRadioItem1(){
    if(shortStayDementiaRecuperationUnitCareMaintenanceRadioItem1==null){

      shortStayDementiaRecuperationUnitCareMaintenanceRadioItem1 = new ACRadioButtonItem();

      shortStayDementiaRecuperationUnitCareMaintenanceRadioItem1.setText("未整備");

      shortStayDementiaRecuperationUnitCareMaintenanceRadioItem1.setGroup(getShortStayDementiaRecuperationUnitCareMaintenanceRadio());

      shortStayDementiaRecuperationUnitCareMaintenanceRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationUnitCareMaintenanceRadioItem1();
    }
    return shortStayDementiaRecuperationUnitCareMaintenanceRadioItem1;

  }

  /**
   * 整備を取得します。
   * @return 整備
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationUnitCareMaintenanceRadioItem2(){
    if(shortStayDementiaRecuperationUnitCareMaintenanceRadioItem2==null){

      shortStayDementiaRecuperationUnitCareMaintenanceRadioItem2 = new ACRadioButtonItem();

      shortStayDementiaRecuperationUnitCareMaintenanceRadioItem2.setText("整備");

      shortStayDementiaRecuperationUnitCareMaintenanceRadioItem2.setGroup(getShortStayDementiaRecuperationUnitCareMaintenanceRadio());

      shortStayDementiaRecuperationUnitCareMaintenanceRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationUnitCareMaintenanceRadioItem2();
    }
    return shortStayDementiaRecuperationUnitCareMaintenanceRadioItem2;

  }

  /**
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1260312");

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,5,2,3,4});

      addServiceAddProvisionStructuralRadioGroup();
    }
    return serviceAddProvisionStructuralRadioGroup;

  }

  /**
   * サービス提供体制強化加算コンテナを取得します。
   * @return サービス提供体制強化加算コンテナ
   */
  protected ACLabelContainer getServiceAddProvisionStructuralRadioGroupContainer(){
    if(serviceAddProvisionStructuralRadioGroupContainer==null){
      serviceAddProvisionStructuralRadioGroupContainer = new ACLabelContainer();
      serviceAddProvisionStructuralRadioGroupContainer.setFollowChildEnabled(true);
      serviceAddProvisionStructuralRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      serviceAddProvisionStructuralRadioGroupContainer.add(getServiceAddProvisionStructuralRadioGroup(), null);
    }
    return serviceAddProvisionStructuralRadioGroupContainer;
  }

  /**
   * サービス提供体制強化加算モデルを取得します。
   * @return サービス提供体制強化加算モデル
   */
  protected ACListModelAdapter getServiceAddProvisionStructuralRadioGroupModel(){
    if(serviceAddProvisionStructuralRadioGroupModel==null){
      serviceAddProvisionStructuralRadioGroupModel = new ACListModelAdapter();
      addServiceAddProvisionStructuralRadioGroupModel();
    }
    return serviceAddProvisionStructuralRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem1(){
    if(serviceAddProvisionStructuralRadioItem1==null){

      serviceAddProvisionStructuralRadioItem1 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem1.setText("なし");

      serviceAddProvisionStructuralRadioItem1.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem1.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem1();
    }
    return serviceAddProvisionStructuralRadioItem1;

  }

  /**
   * Iイ型を取得します。
   * @return Iイ型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem5(){
    if(serviceAddProvisionStructuralRadioItem5==null){

      serviceAddProvisionStructuralRadioItem5 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem5.setText("Iイ型");

      serviceAddProvisionStructuralRadioItem5.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem5.setConstraints(VRLayout.FLOW_RETURN);

      addServiceAddProvisionStructuralRadioItem5();
    }
    return serviceAddProvisionStructuralRadioItem5;

  }

  /**
   * Iロ型を取得します。
   * @return Iロ型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("Iロ型");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem2();
    }
    return serviceAddProvisionStructuralRadioItem2;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem3(){
    if(serviceAddProvisionStructuralRadioItem3==null){

      serviceAddProvisionStructuralRadioItem3 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem3.setText("II型");

      serviceAddProvisionStructuralRadioItem3.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem3();
    }
    return serviceAddProvisionStructuralRadioItem3;

  }

  /**
   * III型を取得します。
   * @return III型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem4(){
    if(serviceAddProvisionStructuralRadioItem4==null){

      serviceAddProvisionStructuralRadioItem4 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem4.setText("III型");

      serviceAddProvisionStructuralRadioItem4.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem4.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem4();
    }
    return serviceAddProvisionStructuralRadioItem4;

  }

  /**
   * コンストラクタです。
   */
  public QS001_12613_201504Design() {

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

    this.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * タブペインに内部項目を追加します。
   */
  protected void addTabs(){

    tabs.addTab("1", getTab1());

    tabs.addTab("2", getTab2());

  }

  /**
   * タブ1に内部項目を追加します。
   */
  protected void addTab1(){

    tab1.add(getShortStayDementiaRecuperationInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayDementiaRecuperationHospitalDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayDementiaRecuperationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayDementiaRecuperationHospitalRoomDivisionContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayDementiaRecuperationMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayDementiaRecuperationMedicalExpensesRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 施設等の区分に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationInstitutionDivisionRadio(){

  }

  /**
   * 施設等の区分モデルに内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationInstitutionDivisionRadioModel(){

    getShortStayDementiaRecuperationInstitutionDivisionRadioItem1().setButtonIndex(1);

    getShortStayDementiaRecuperationInstitutionDivisionRadioModel().add(getShortStayDementiaRecuperationInstitutionDivisionRadioItem1());

    getShortStayDementiaRecuperationInstitutionDivisionRadioItem2().setButtonIndex(2);

    getShortStayDementiaRecuperationInstitutionDivisionRadioModel().add(getShortStayDementiaRecuperationInstitutionDivisionRadioItem2());

    getShortStayDementiaRecuperationInstitutionDivisionRadioItem3().setButtonIndex(3);

    getShortStayDementiaRecuperationInstitutionDivisionRadioModel().add(getShortStayDementiaRecuperationInstitutionDivisionRadioItem3());

  }

  /**
   * 認知症疾患型に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationInstitutionDivisionRadioItem1(){

  }

  /**
   * ユニット型認知症疾患型に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationInstitutionDivisionRadioItem2(){

  }

  /**
   * 経過型に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationInstitutionDivisionRadioItem3(){

  }

  /**
   * 病院区分に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationHospitalDivisionRadio(){

  }

  /**
   * 病院区分モデルに内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationHospitalDivisionRadioModel(){

    getShortStayDementiaRecuperationHospitalDivisionRadioItem1().setButtonIndex(1);

    getShortStayDementiaRecuperationHospitalDivisionRadioModel().add(getShortStayDementiaRecuperationHospitalDivisionRadioItem1());

    getShortStayDementiaRecuperationHospitalDivisionRadioItem2().setButtonIndex(2);

    getShortStayDementiaRecuperationHospitalDivisionRadioModel().add(getShortStayDementiaRecuperationHospitalDivisionRadioItem2());

  }

  /**
   * 大学病院に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationHospitalDivisionRadioItem1(){

  }

  /**
   * 一般病院に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationHospitalDivisionRadioItem2(){

  }

  /**
   * 人員配置区分に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationDivision(){

  }

  /**
   * 人員配置区分モデルに内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationDivisionModel(){

    getShortStayDementiaRecuperationType1().setButtonIndex(1);

    getShortStayDementiaRecuperationDivisionModel().add(getShortStayDementiaRecuperationType1());

    getShortStayDementiaRecuperationType2().setButtonIndex(2);

    getShortStayDementiaRecuperationDivisionModel().add(getShortStayDementiaRecuperationType2());

    getShortStayDementiaRecuperationType3().setButtonIndex(3);

    getShortStayDementiaRecuperationDivisionModel().add(getShortStayDementiaRecuperationType3());

    getShortStayDementiaRecuperationType4().setButtonIndex(4);

    getShortStayDementiaRecuperationDivisionModel().add(getShortStayDementiaRecuperationType4());

    getShortStayDementiaRecuperationType5().setButtonIndex(5);

    getShortStayDementiaRecuperationDivisionModel().add(getShortStayDementiaRecuperationType5());

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationType1(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationType2(){

  }

  /**
   * III型に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationType3(){

  }

  /**
   * IV型に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationType4(){

  }

  /**
   * V型に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationType5(){

  }

  /**
   * 病室区分コンテナに内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationHospitalRoomDivisionContena(){

    shortStayDementiaRecuperationHospitalRoomDivisionContena.add(getShortStayDementiaRecuperationHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayDementiaRecuperationHospitalRoomDivisionContena.add(getShortStayDementiaRecuperationUnitHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 病室区分（介護老人保健施設）に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationHospitalRoomRadio(){

  }

  /**
   * 病室区分（介護老人保健施設）モデルに内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationHospitalRoomRadioModel(){

    getShortStayDementiaRecuperationHospitalRoomRadioItem1().setButtonIndex(1);

    getShortStayDementiaRecuperationHospitalRoomRadioModel().add(getShortStayDementiaRecuperationHospitalRoomRadioItem1());

    getShortStayDementiaRecuperationHospitalRoomRadioItem2().setButtonIndex(2);

    getShortStayDementiaRecuperationHospitalRoomRadioModel().add(getShortStayDementiaRecuperationHospitalRoomRadioItem2());

  }

  /**
   * 従来型個室に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationHospitalRoomRadioItem1(){

  }

  /**
   * 多床室に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationHospitalRoomRadioItem2(){

  }

  /**
   * 病室区分（ユニット型）に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationUnitHospitalRoomRadio(){

  }

  /**
   * 病室区分（ユニット型）モデルに内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationUnitHospitalRoomRadioModel(){

    getShortStayDementiaRecuperationUnitHospitalRoomRadioItem1().setButtonIndex(1);

    getShortStayDementiaRecuperationUnitHospitalRoomRadioModel().add(getShortStayDementiaRecuperationUnitHospitalRoomRadioItem1());

    getShortStayDementiaRecuperationUnitHospitalRoomRadioItem2().setButtonIndex(2);

    getShortStayDementiaRecuperationUnitHospitalRoomRadioModel().add(getShortStayDementiaRecuperationUnitHospitalRoomRadioItem2());

  }

  /**
   * ユニット型個室に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationUnitHospitalRoomRadioItem1(){

  }

  /**
   * ユニット型準個室に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationUnitHospitalRoomRadioItem2(){

  }

  /**
   * 送迎区分に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationMeetingAndSendingOff(){

  }

  /**
   * 送迎区分モデルに内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationMeetingAndSendingOffModel(){

    getShortStayDementiaRecuperationMeetingAndSendingOffNone().setButtonIndex(1);

    getShortStayDementiaRecuperationMeetingAndSendingOffModel().add(getShortStayDementiaRecuperationMeetingAndSendingOffNone());

    getShortStayDementiaRecuperationMeetingAndSendingOffOneWay().setButtonIndex(2);

    getShortStayDementiaRecuperationMeetingAndSendingOffModel().add(getShortStayDementiaRecuperationMeetingAndSendingOffOneWay());

    getShortStayDementiaRecuperationMeetingAndSendingOffRoundTrip().setButtonIndex(3);

    getShortStayDementiaRecuperationMeetingAndSendingOffModel().add(getShortStayDementiaRecuperationMeetingAndSendingOffRoundTrip());

  }

  /**
   * 送迎なしに内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationMeetingAndSendingOffNone(){

  }

  /**
   * 送迎片道に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationMeetingAndSendingOffOneWay(){

  }

  /**
   * 送迎往復に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationMeetingAndSendingOffRoundTrip(){

  }

  /**
   * 療養食加算に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationMedicalExpensesRadio(){

  }

  /**
   * 療養食加算モデルに内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationMedicalExpensesRadioModel(){

    getShortStayDementiaRecuperationMedicalExpensesRadioItem1().setButtonIndex(1);

    getShortStayDementiaRecuperationMedicalExpensesRadioModel().add(getShortStayDementiaRecuperationMedicalExpensesRadioItem1());

    getShortStayDementiaRecuperationMedicalExpensesRadioItem2().setButtonIndex(2);

    getShortStayDementiaRecuperationMedicalExpensesRadioModel().add(getShortStayDementiaRecuperationMedicalExpensesRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationMedicalExpensesRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationMedicalExpensesRadioItem2(){

  }

  /**
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getShortStayDementiaRecuperationSpecificConsultationFee(), VRLayout.FLOW);

    tab2.add(getShortStayDementiaRecuperationSpecificConsultationFeeOutline(), VRLayout.FLOW_RETURN);

    tab2.add(getShortStayDementiaRecuperationPersonSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayDementiaRecuperationDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tab2.add(getShortStayDementiaRecuperationEtc30Over(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayDementiaRecuperationUnitCareMaintenanceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 特定診療費ボタンに内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationSpecificConsultationFee(){

  }

  /**
   * 設定ラベルに内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationSpecificConsultationFeeOutline(){

  }

  /**
   * 人員減算コンボに内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationPersonSubtraction(){

  }

  /**
   * 人員減算コンボモデルに内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationPersonSubtractionModel(){

  }

  /**
   * 食事コンテナに内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationDinnerContainer(){

    shortStayDementiaRecuperationDinnerContainer.add(getShortStayDementiaRecuperationDinnerOfferContainer(), VRLayout.FLOW);

    shortStayDementiaRecuperationDinnerContainer.add(getShortStayDementiaRecuperationDinnerCostContainer(), VRLayout.FLOW);

  }

  /**
   * 食事提供に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationDinnerOffer(){

  }

  /**
   * 食事提供モデルに内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationDinnerOfferModel(){

  }

  /**
   * 食事費用に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationDinnerCost(){

  }

  /**
   * 30日超に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationEtc30Over(){

  }

  /**
   * ユニットケアの整備に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationUnitCareMaintenanceRadio(){

  }

  /**
   * ユニットケアの整備モデルに内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationUnitCareMaintenanceRadioModel(){

    getShortStayDementiaRecuperationUnitCareMaintenanceRadioItem1().setButtonIndex(1);

    getShortStayDementiaRecuperationUnitCareMaintenanceRadioModel().add(getShortStayDementiaRecuperationUnitCareMaintenanceRadioItem1());

    getShortStayDementiaRecuperationUnitCareMaintenanceRadioItem2().setButtonIndex(2);

    getShortStayDementiaRecuperationUnitCareMaintenanceRadioModel().add(getShortStayDementiaRecuperationUnitCareMaintenanceRadioItem2());

  }

  /**
   * 未整備に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationUnitCareMaintenanceRadioItem1(){

  }

  /**
   * 整備に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationUnitCareMaintenanceRadioItem2(){

  }

  /**
   * サービス提供体制強化加算に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioGroup(){

  }

  /**
   * サービス提供体制強化加算モデルに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioGroupModel(){

    getServiceAddProvisionStructuralRadioItem1().setButtonIndex(1);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem1());

    getServiceAddProvisionStructuralRadioItem5().setButtonIndex(5);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem5());

    getServiceAddProvisionStructuralRadioItem2().setButtonIndex(2);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem2());

    getServiceAddProvisionStructuralRadioItem3().setButtonIndex(3);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem3());

    getServiceAddProvisionStructuralRadioItem4().setButtonIndex(4);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem4());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * Iイ型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem5(){

  }

  /**
   * Iロ型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem3(){

  }

  /**
   * III型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem4(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_12613_201504Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_12613_201504Design getThis() {
    return this;
  }
}
