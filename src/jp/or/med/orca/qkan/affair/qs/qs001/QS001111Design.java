
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
 * 開発者: 松本　幸一
 * 作成日: 2006/07/03  日本コンピューター株式会社 松本　幸一 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン短期入所療養介護（病院療養） (QS001111)
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
 * サービスパターン短期入所療養介護（病院療養）画面項目デザイン(QS001111) 
 */
public class QS001111Design extends QS001ServicePanel {
  //GUIコンポーネント

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationInstitutionDivisionRadio;

  private ACLabelContainer shortStayHospitalRecuperationInstitutionDivisionRadioContainer;

  private ACListModelAdapter shortStayHospitalRecuperationInstitutionDivisionRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationInstitutionDivisionRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationInstitutionDivisionRadioItem2;

  private ACRadioButtonItem shortStayHospitalRecuperationInstitutionDivisionRadioItem3;

  private ACRadioButtonItem shortStayHospitalRecuperationInstitutionDivisionRadioItem4;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationDivision;

  private ACLabelContainer shortStayHospitalRecuperationDivisionContainer;

  private ACListModelAdapter shortStayHospitalRecuperationDivisionModel;

  private ACRadioButtonItem shortStayHospitalRecuperationType1;

  private ACRadioButtonItem shortStayHospitalRecuperationType2;

  private ACRadioButtonItem shortStayHospitalRecuperationType3;

  private ACLabelContainer shortStayHospitalRecuperationHospitalRoomContena;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationHospitalRoomRadio;

  private ACListModelAdapter shortStayHospitalRecuperationHospitalRoomRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationHospitalRoomRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationHospitalRoomRadioItem2;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationUnitHospitalRoomRadio;

  private ACListModelAdapter shortStayHospitalRecuperationUnitHospitalRoomRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationUnitHospitalRoomRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationUnitHospitalRoomRadioItem2;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationSickroomDivisionRadio;

  private ACLabelContainer shortStayHospitalRecuperationSickroomDivisionRadioContainer;

  private ACListModelAdapter shortStayHospitalRecuperationSickroomDivisionRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationSickroomDivisionRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationSickroomDivisionRadioItem2;

  private ACRadioButtonItem shortStayHospitalRecuperationSickroomDivisionRadioItem3;

  private ACRadioButtonItem shortStayHospitalRecuperationSickroomDivisionRadioItem4;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationAdditionType;

  private ACLabelContainer shortStayHospitalRecuperationAdditionTypeContainer;

  private ACListModelAdapter shortStayHospitalRecuperationAdditionTypeModel;

  private ACRadioButtonItem shortStayHospitalRecuperationAdditionTypeNormal;

  private ACRadioButtonItem shortStayHospitalRecuperationAdditionType1;

  private ACRadioButtonItem shortStayHospitalRecuperationAdditionType2;

  private ACRadioButtonItem shortStayHospitalRecuperationAdditionType3;

  private ACRadioButtonItem shortStayHospitalRecuperationAdditionTypeNone;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationSubtractionType;

  private ACLabelContainer shortStayHospitalRecuperationSubtractionTypeContainer;

  private ACListModelAdapter shortStayHospitalRecuperationSubtractionTypeModel;

  private ACRadioButtonItem shortStayHospitalRecuperationSubtractionTypeNormal;

  private ACRadioButtonItem shortStayHospitalRecuperationSubtractionType1;

  private ACRadioButtonItem shortStayHospitalRecuperationSubtractionType2;

  private ACRadioButtonItem shortStayHospitalRecuperationSubtractionType3;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationApplicationType;

  private ACLabelContainer shortStayHospitalRecuperationApplicationTypeContainer;

  private ACListModelAdapter shortStayHospitalRecuperationApplicationTypeModel;

  private ACRadioButtonItem shortStayHospitalRecuperationApplicationTypeNormal;

  private ACRadioButtonItem shortStayHospitalRecuperationApplicationType49;

  private ACPanel tab2;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationMeetingAndSendingOff;

  private ACLabelContainer shortStayHospitalRecuperationMeetingAndSendingOffContainer;

  private ACListModelAdapter shortStayHospitalRecuperationMeetingAndSendingOffModel;

  private ACRadioButtonItem shortStayHospitalRecuperationMeetingAndSendingOffNone;

  private ACRadioButtonItem shortStayHospitalRecuperationMeetingAndSendingOffOneWay;

  private ACRadioButtonItem shortStayHospitalRecuperationMeetingAndSendingOffRoundTrip;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationDieticianManageRadio;

  private ACLabelContainer shortStayHospitalRecuperationDieticianManageRadioContainer;

  private ACListModelAdapter shortStayHospitalRecuperationDieticianManageRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationDieticianManageRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationDieticianManageRadioItem2;

  private ACRadioButtonItem shortStayHospitalRecuperationDieticianManageRadioItem3;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationMedicalExpensesRadio;

  private ACLabelContainer shortStayHospitalRecuperationMedicalExpensesRadioContainer;

  private ACListModelAdapter shortStayHospitalRecuperationMedicalExpensesRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationMedicalExpensesRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationMedicalExpensesRadioItem2;

  private ACMapBindButton shortStayHospitalRecuperationSpecificConsultationFee;

  private ACLabel shortStayHospitalRecuperationSpecificConsultationFeeOutline;

  private ACComboBox shortStayHospitalRecuperationPersonSubtraction;

  private ACLabelContainer shortStayHospitalRecuperationPersonSubtractionContainer;

  private ACComboBoxModelAdapter shortStayHospitalRecuperationPersonSubtractionModel;

  private ACBackLabelContainer shortStayRecuperationHealthFacilityDinnerContainer;

  private ACComboBox shortStayRecuperationHealthFacilityDinnerOffer;

  private ACLabelContainer shortStayRecuperationHealthFacilityDinnerOfferContainer;

  private ACComboBoxModelAdapter shortStayRecuperationHealthFacilityDinnerOfferModel;

  private ACTextField shortStayRecuperationHealthFacilityDinnerCost;

  private ACLabelContainer shortStayRecuperationHealthFacilityDinnerCostContainer;

  private ACIntegerCheckBox shortStayHospitalRecuperationEtc30Over;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationUnitCareMaintenanceRadio;

  private ACLabelContainer shortStayHospitalRecuperationUnitCareMaintenanceRadioContainer;

  private ACListModelAdapter shortStayHospitalRecuperationUnitCareMaintenanceRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationUnitCareMaintenanceRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationUnitCareMaintenanceRadioItem2;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationEmergencyNetworkAddRadio;

  private ACLabelContainer shortStayHospitalRecuperationEmergencyNetworkAddRadioContainer;

  private ACListModelAdapter shortStayHospitalRecuperationEmergencyNetworkAddRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationEmergencyNetworkAddRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationEmergencyNetworkAddRadioItem2;

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

      tab1.setHgap(0);

      addTab1();
    }
    return tab1;

  }

  /**
   * 施設等の区分を取得します。
   * @return 施設等の区分
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationInstitutionDivisionRadio(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadio==null){

      shortStayHospitalRecuperationInstitutionDivisionRadio = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationInstitutionDivisionRadioContainer().setText("施設等の区分");

      shortStayHospitalRecuperationInstitutionDivisionRadio.setBindPath("1230101");

      shortStayHospitalRecuperationInstitutionDivisionRadio.setUseClearButton(false);

      shortStayHospitalRecuperationInstitutionDivisionRadio.setModel(getShortStayHospitalRecuperationInstitutionDivisionRadioModel());

      addShortStayHospitalRecuperationInstitutionDivisionRadio();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadio;

  }

  /**
   * 施設等の区分コンテナを取得します。
   * @return 施設等の区分コンテナ
   */
  protected ACLabelContainer getShortStayHospitalRecuperationInstitutionDivisionRadioContainer(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioContainer==null){
      shortStayHospitalRecuperationInstitutionDivisionRadioContainer = new ACLabelContainer();
      shortStayHospitalRecuperationInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationInstitutionDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayHospitalRecuperationInstitutionDivisionRadioContainer.add(getShortStayHospitalRecuperationInstitutionDivisionRadio(), null);
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioContainer;
  }

  /**
   * 施設等の区分モデルを取得します。
   * @return 施設等の区分モデル
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationInstitutionDivisionRadioModel(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioModel==null){
      shortStayHospitalRecuperationInstitutionDivisionRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationInstitutionDivisionRadioModel();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioModel;
  }

  /**
   * 病院を取得します。
   * @return 病院
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationInstitutionDivisionRadioItem1(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioItem1==null){

      shortStayHospitalRecuperationInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationInstitutionDivisionRadioItem1.setText("病院");

      shortStayHospitalRecuperationInstitutionDivisionRadioItem1.setGroup(getShortStayHospitalRecuperationInstitutionDivisionRadio());

      shortStayHospitalRecuperationInstitutionDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationInstitutionDivisionRadioItem1();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioItem1;

  }

  /**
   * ユニット型病院を取得します。
   * @return ユニット型病院
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationInstitutionDivisionRadioItem2(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioItem2==null){

      shortStayHospitalRecuperationInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationInstitutionDivisionRadioItem2.setText("ユニット型病院");

      shortStayHospitalRecuperationInstitutionDivisionRadioItem2.setGroup(getShortStayHospitalRecuperationInstitutionDivisionRadio());

      shortStayHospitalRecuperationInstitutionDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationInstitutionDivisionRadioItem2();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioItem2;

  }

  /**
   * 日帰りショートステイを取得します。
   * @return 日帰りショートステイ
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationInstitutionDivisionRadioItem3(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioItem3==null){

      shortStayHospitalRecuperationInstitutionDivisionRadioItem3 = new ACRadioButtonItem();

      shortStayHospitalRecuperationInstitutionDivisionRadioItem3.setText("日帰りショートステイ");

      shortStayHospitalRecuperationInstitutionDivisionRadioItem3.setGroup(getShortStayHospitalRecuperationInstitutionDivisionRadio());

      shortStayHospitalRecuperationInstitutionDivisionRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationInstitutionDivisionRadioItem3();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioItem3;

  }

  /**
   * 経過型を取得します。
   * @return 経過型
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationInstitutionDivisionRadioItem4(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioItem4==null){

      shortStayHospitalRecuperationInstitutionDivisionRadioItem4 = new ACRadioButtonItem();

      shortStayHospitalRecuperationInstitutionDivisionRadioItem4.setText("経過型");

      shortStayHospitalRecuperationInstitutionDivisionRadioItem4.setGroup(getShortStayHospitalRecuperationInstitutionDivisionRadio());

      shortStayHospitalRecuperationInstitutionDivisionRadioItem4.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationInstitutionDivisionRadioItem4();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioItem4;

  }

  /**
   * 人員配置区分を取得します。
   * @return 人員配置区分
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationDivision(){
    if(shortStayHospitalRecuperationDivision==null){

      shortStayHospitalRecuperationDivision = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationDivisionContainer().setText("人員配置区分");

      shortStayHospitalRecuperationDivision.setBindPath("1230102");

      shortStayHospitalRecuperationDivision.setUseClearButton(false);

      shortStayHospitalRecuperationDivision.setModel(getShortStayHospitalRecuperationDivisionModel());

      addShortStayHospitalRecuperationDivision();
    }
    return shortStayHospitalRecuperationDivision;

  }

  /**
   * 人員配置区分コンテナを取得します。
   * @return 人員配置区分コンテナ
   */
  protected ACLabelContainer getShortStayHospitalRecuperationDivisionContainer(){
    if(shortStayHospitalRecuperationDivisionContainer==null){
      shortStayHospitalRecuperationDivisionContainer = new ACLabelContainer();
      shortStayHospitalRecuperationDivisionContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationDivisionContainer.setVAlignment(VRLayout.CENTER);
      shortStayHospitalRecuperationDivisionContainer.add(getShortStayHospitalRecuperationDivision(), null);
    }
    return shortStayHospitalRecuperationDivisionContainer;
  }

  /**
   * 人員配置区分モデルを取得します。
   * @return 人員配置区分モデル
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationDivisionModel(){
    if(shortStayHospitalRecuperationDivisionModel==null){
      shortStayHospitalRecuperationDivisionModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationDivisionModel();
    }
    return shortStayHospitalRecuperationDivisionModel;
  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationType1(){
    if(shortStayHospitalRecuperationType1==null){

      shortStayHospitalRecuperationType1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationType1.setText("I型");

      shortStayHospitalRecuperationType1.setGroup(getShortStayHospitalRecuperationDivision());

      shortStayHospitalRecuperationType1.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationType1();
    }
    return shortStayHospitalRecuperationType1;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationType2(){
    if(shortStayHospitalRecuperationType2==null){

      shortStayHospitalRecuperationType2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationType2.setText("II型");

      shortStayHospitalRecuperationType2.setGroup(getShortStayHospitalRecuperationDivision());

      shortStayHospitalRecuperationType2.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationType2();
    }
    return shortStayHospitalRecuperationType2;

  }

  /**
   * III型を取得します。
   * @return III型
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationType3(){
    if(shortStayHospitalRecuperationType3==null){

      shortStayHospitalRecuperationType3 = new ACRadioButtonItem();

      shortStayHospitalRecuperationType3.setText("III型");

      shortStayHospitalRecuperationType3.setGroup(getShortStayHospitalRecuperationDivision());

      shortStayHospitalRecuperationType3.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationType3();
    }
    return shortStayHospitalRecuperationType3;

  }

  /**
   * 病室区分・コンテナを取得します。
   * @return 病室区分・コンテナ
   */
  public ACLabelContainer getShortStayHospitalRecuperationHospitalRoomContena(){
    if(shortStayHospitalRecuperationHospitalRoomContena==null){

      shortStayHospitalRecuperationHospitalRoomContena = new ACLabelContainer();

      shortStayHospitalRecuperationHospitalRoomContena.setText("病室区分");

      addShortStayHospitalRecuperationHospitalRoomContena();
    }
    return shortStayHospitalRecuperationHospitalRoomContena;

  }

  /**
   * 病室区分（病室）を取得します。
   * @return 病室区分（病室）
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationHospitalRoomRadio(){
    if(shortStayHospitalRecuperationHospitalRoomRadio==null){

      shortStayHospitalRecuperationHospitalRoomRadio = new ACClearableRadioButtonGroup();

      shortStayHospitalRecuperationHospitalRoomRadio.setBindPath("1230103");

      shortStayHospitalRecuperationHospitalRoomRadio.setUseClearButton(false);

      shortStayHospitalRecuperationHospitalRoomRadio.setModel(getShortStayHospitalRecuperationHospitalRoomRadioModel());

      addShortStayHospitalRecuperationHospitalRoomRadio();
    }
    return shortStayHospitalRecuperationHospitalRoomRadio;

  }

  /**
   * 病室区分（病室）モデルを取得します。
   * @return 病室区分（病室）モデル
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationHospitalRoomRadioModel(){
    if(shortStayHospitalRecuperationHospitalRoomRadioModel==null){
      shortStayHospitalRecuperationHospitalRoomRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationHospitalRoomRadioModel();
    }
    return shortStayHospitalRecuperationHospitalRoomRadioModel;
  }

  /**
   * 従来型個室を取得します。
   * @return 従来型個室
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationHospitalRoomRadioItem1(){
    if(shortStayHospitalRecuperationHospitalRoomRadioItem1==null){

      shortStayHospitalRecuperationHospitalRoomRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationHospitalRoomRadioItem1.setText("従来型個室");

      shortStayHospitalRecuperationHospitalRoomRadioItem1.setGroup(getShortStayHospitalRecuperationHospitalRoomRadio());

      shortStayHospitalRecuperationHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationHospitalRoomRadioItem1();
    }
    return shortStayHospitalRecuperationHospitalRoomRadioItem1;

  }

  /**
   * 多床室を取得します。
   * @return 多床室
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationHospitalRoomRadioItem2(){
    if(shortStayHospitalRecuperationHospitalRoomRadioItem2==null){

      shortStayHospitalRecuperationHospitalRoomRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationHospitalRoomRadioItem2.setText("多床室");

      shortStayHospitalRecuperationHospitalRoomRadioItem2.setGroup(getShortStayHospitalRecuperationHospitalRoomRadio());

      shortStayHospitalRecuperationHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationHospitalRoomRadioItem2();
    }
    return shortStayHospitalRecuperationHospitalRoomRadioItem2;

  }

  /**
   * 病室区分（ユニット型病院）を取得します。
   * @return 病室区分（ユニット型病院）
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationUnitHospitalRoomRadio(){
    if(shortStayHospitalRecuperationUnitHospitalRoomRadio==null){

      shortStayHospitalRecuperationUnitHospitalRoomRadio = new ACClearableRadioButtonGroup();

      shortStayHospitalRecuperationUnitHospitalRoomRadio.setBindPath("1230104");

      shortStayHospitalRecuperationUnitHospitalRoomRadio.setUseClearButton(false);

      shortStayHospitalRecuperationUnitHospitalRoomRadio.setModel(getShortStayHospitalRecuperationUnitHospitalRoomRadioModel());

      addShortStayHospitalRecuperationUnitHospitalRoomRadio();
    }
    return shortStayHospitalRecuperationUnitHospitalRoomRadio;

  }

  /**
   * 病室区分（ユニット型病院）モデルを取得します。
   * @return 病室区分（ユニット型病院）モデル
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationUnitHospitalRoomRadioModel(){
    if(shortStayHospitalRecuperationUnitHospitalRoomRadioModel==null){
      shortStayHospitalRecuperationUnitHospitalRoomRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationUnitHospitalRoomRadioModel();
    }
    return shortStayHospitalRecuperationUnitHospitalRoomRadioModel;
  }

  /**
   * ユニット型個室を取得します。
   * @return ユニット型個室
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationUnitHospitalRoomRadioItem1(){
    if(shortStayHospitalRecuperationUnitHospitalRoomRadioItem1==null){

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem1.setText("ユニット型個室");

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem1.setGroup(getShortStayHospitalRecuperationUnitHospitalRoomRadio());

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationUnitHospitalRoomRadioItem1();
    }
    return shortStayHospitalRecuperationUnitHospitalRoomRadioItem1;

  }

  /**
   * ユニット型準個室を取得します。
   * @return ユニット型準個室
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationUnitHospitalRoomRadioItem2(){
    if(shortStayHospitalRecuperationUnitHospitalRoomRadioItem2==null){

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem2.setText("ユニット型準個室");

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem2.setGroup(getShortStayHospitalRecuperationUnitHospitalRoomRadio());

      shortStayHospitalRecuperationUnitHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationUnitHospitalRoomRadioItem2();
    }
    return shortStayHospitalRecuperationUnitHospitalRoomRadioItem2;

  }

  /**
   * 病室区分ラジオを取得します。
   * @return 病室区分ラジオ
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationSickroomDivisionRadio(){
    if(shortStayHospitalRecuperationSickroomDivisionRadio==null){

      shortStayHospitalRecuperationSickroomDivisionRadio = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationSickroomDivisionRadioContainer().setText("病室区分");

      shortStayHospitalRecuperationSickroomDivisionRadio.setBindPath("1230113");

      shortStayHospitalRecuperationSickroomDivisionRadio.setUseClearButton(false);

      shortStayHospitalRecuperationSickroomDivisionRadio.setModel(getShortStayHospitalRecuperationSickroomDivisionRadioModel());

      addShortStayHospitalRecuperationSickroomDivisionRadio();
    }
    return shortStayHospitalRecuperationSickroomDivisionRadio;

  }

  /**
   * 病室区分ラジオコンテナを取得します。
   * @return 病室区分ラジオコンテナ
   */
  protected ACLabelContainer getShortStayHospitalRecuperationSickroomDivisionRadioContainer(){
    if(shortStayHospitalRecuperationSickroomDivisionRadioContainer==null){
      shortStayHospitalRecuperationSickroomDivisionRadioContainer = new ACLabelContainer();
      shortStayHospitalRecuperationSickroomDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationSickroomDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayHospitalRecuperationSickroomDivisionRadioContainer.add(getShortStayHospitalRecuperationSickroomDivisionRadio(), null);
    }
    return shortStayHospitalRecuperationSickroomDivisionRadioContainer;
  }

  /**
   * 病室区分ラジオモデルを取得します。
   * @return 病室区分ラジオモデル
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationSickroomDivisionRadioModel(){
    if(shortStayHospitalRecuperationSickroomDivisionRadioModel==null){
      shortStayHospitalRecuperationSickroomDivisionRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationSickroomDivisionRadioModel();
    }
    return shortStayHospitalRecuperationSickroomDivisionRadioModel;
  }

  /**
   * 従来型個室を取得します。
   * @return 従来型個室
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationSickroomDivisionRadioItem1(){
    if(shortStayHospitalRecuperationSickroomDivisionRadioItem1==null){

      shortStayHospitalRecuperationSickroomDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationSickroomDivisionRadioItem1.setText("従来型個室");

      shortStayHospitalRecuperationSickroomDivisionRadioItem1.setGroup(getShortStayHospitalRecuperationSickroomDivisionRadio());

      shortStayHospitalRecuperationSickroomDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationSickroomDivisionRadioItem1();
    }
    return shortStayHospitalRecuperationSickroomDivisionRadioItem1;

  }

  /**
   * 多床室を取得します。
   * @return 多床室
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationSickroomDivisionRadioItem2(){
    if(shortStayHospitalRecuperationSickroomDivisionRadioItem2==null){

      shortStayHospitalRecuperationSickroomDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationSickroomDivisionRadioItem2.setText("多床室");

      shortStayHospitalRecuperationSickroomDivisionRadioItem2.setGroup(getShortStayHospitalRecuperationSickroomDivisionRadio());

      shortStayHospitalRecuperationSickroomDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationSickroomDivisionRadioItem2();
    }
    return shortStayHospitalRecuperationSickroomDivisionRadioItem2;

  }

  /**
   * ユニット型個室を取得します。
   * @return ユニット型個室
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationSickroomDivisionRadioItem3(){
    if(shortStayHospitalRecuperationSickroomDivisionRadioItem3==null){

      shortStayHospitalRecuperationSickroomDivisionRadioItem3 = new ACRadioButtonItem();

      shortStayHospitalRecuperationSickroomDivisionRadioItem3.setText("ユニット型個室");

      shortStayHospitalRecuperationSickroomDivisionRadioItem3.setGroup(getShortStayHospitalRecuperationSickroomDivisionRadio());

      shortStayHospitalRecuperationSickroomDivisionRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationSickroomDivisionRadioItem3();
    }
    return shortStayHospitalRecuperationSickroomDivisionRadioItem3;

  }

  /**
   * ユニット型準個室を取得します。
   * @return ユニット型準個室
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationSickroomDivisionRadioItem4(){
    if(shortStayHospitalRecuperationSickroomDivisionRadioItem4==null){

      shortStayHospitalRecuperationSickroomDivisionRadioItem4 = new ACRadioButtonItem();

      shortStayHospitalRecuperationSickroomDivisionRadioItem4.setText("ユニット型準個室");

      shortStayHospitalRecuperationSickroomDivisionRadioItem4.setGroup(getShortStayHospitalRecuperationSickroomDivisionRadio());

      shortStayHospitalRecuperationSickroomDivisionRadioItem4.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationSickroomDivisionRadioItem4();
    }
    return shortStayHospitalRecuperationSickroomDivisionRadioItem4;

  }

  /**
   * 夜間勤務条件基準を取得します。
   * @return 夜間勤務条件基準
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationAdditionType(){
    if(shortStayHospitalRecuperationAdditionType==null){

      shortStayHospitalRecuperationAdditionType = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationAdditionTypeContainer().setText("夜間勤務条件基準");

      shortStayHospitalRecuperationAdditionType.setBindPath("1230105");

      shortStayHospitalRecuperationAdditionType.setUseClearButton(false);

      shortStayHospitalRecuperationAdditionType.setModel(getShortStayHospitalRecuperationAdditionTypeModel());

      addShortStayHospitalRecuperationAdditionType();
    }
    return shortStayHospitalRecuperationAdditionType;

  }

  /**
   * 夜間勤務条件基準コンテナを取得します。
   * @return 夜間勤務条件基準コンテナ
   */
  protected ACLabelContainer getShortStayHospitalRecuperationAdditionTypeContainer(){
    if(shortStayHospitalRecuperationAdditionTypeContainer==null){
      shortStayHospitalRecuperationAdditionTypeContainer = new ACLabelContainer();
      shortStayHospitalRecuperationAdditionTypeContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationAdditionTypeContainer.setVAlignment(VRLayout.CENTER);
      shortStayHospitalRecuperationAdditionTypeContainer.add(getShortStayHospitalRecuperationAdditionType(), null);
    }
    return shortStayHospitalRecuperationAdditionTypeContainer;
  }

  /**
   * 夜間勤務条件基準モデルを取得します。
   * @return 夜間勤務条件基準モデル
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationAdditionTypeModel(){
    if(shortStayHospitalRecuperationAdditionTypeModel==null){
      shortStayHospitalRecuperationAdditionTypeModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationAdditionTypeModel();
    }
    return shortStayHospitalRecuperationAdditionTypeModel;
  }

  /**
   * 通常を取得します。
   * @return 通常
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationAdditionTypeNormal(){
    if(shortStayHospitalRecuperationAdditionTypeNormal==null){

      shortStayHospitalRecuperationAdditionTypeNormal = new ACRadioButtonItem();

      shortStayHospitalRecuperationAdditionTypeNormal.setText("基準型");

      shortStayHospitalRecuperationAdditionTypeNormal.setGroup(getShortStayHospitalRecuperationAdditionType());

      shortStayHospitalRecuperationAdditionTypeNormal.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationAdditionTypeNormal();
    }
    return shortStayHospitalRecuperationAdditionTypeNormal;

  }

  /**
   * 加算型Iを取得します。
   * @return 加算型I
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationAdditionType1(){
    if(shortStayHospitalRecuperationAdditionType1==null){

      shortStayHospitalRecuperationAdditionType1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationAdditionType1.setText("加算型I");

      shortStayHospitalRecuperationAdditionType1.setGroup(getShortStayHospitalRecuperationAdditionType());

      shortStayHospitalRecuperationAdditionType1.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationAdditionType1();
    }
    return shortStayHospitalRecuperationAdditionType1;

  }

  /**
   * 加算型IIを取得します。
   * @return 加算型II
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationAdditionType2(){
    if(shortStayHospitalRecuperationAdditionType2==null){

      shortStayHospitalRecuperationAdditionType2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationAdditionType2.setText("加算型II");

      shortStayHospitalRecuperationAdditionType2.setGroup(getShortStayHospitalRecuperationAdditionType());

      shortStayHospitalRecuperationAdditionType2.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationAdditionType2();
    }
    return shortStayHospitalRecuperationAdditionType2;

  }

  /**
   * 加算型IIIを取得します。
   * @return 加算型III
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationAdditionType3(){
    if(shortStayHospitalRecuperationAdditionType3==null){

      shortStayHospitalRecuperationAdditionType3 = new ACRadioButtonItem();

      shortStayHospitalRecuperationAdditionType3.setText("加算型III");

      shortStayHospitalRecuperationAdditionType3.setGroup(getShortStayHospitalRecuperationAdditionType());

      shortStayHospitalRecuperationAdditionType3.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationAdditionType3();
    }
    return shortStayHospitalRecuperationAdditionType3;

  }

  /**
   * 減算型を取得します。
   * @return 減算型
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationAdditionTypeNone(){
    if(shortStayHospitalRecuperationAdditionTypeNone==null){

      shortStayHospitalRecuperationAdditionTypeNone = new ACRadioButtonItem();

      shortStayHospitalRecuperationAdditionTypeNone.setText("減算型");

      shortStayHospitalRecuperationAdditionTypeNone.setGroup(getShortStayHospitalRecuperationAdditionType());

      shortStayHospitalRecuperationAdditionTypeNone.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationAdditionTypeNone();
    }
    return shortStayHospitalRecuperationAdditionTypeNone;

  }

  /**
   * 療養環境減算型を取得します。
   * @return 療養環境減算型
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationSubtractionType(){
    if(shortStayHospitalRecuperationSubtractionType==null){

      shortStayHospitalRecuperationSubtractionType = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationSubtractionTypeContainer().setText("療養環境減算");

      shortStayHospitalRecuperationSubtractionType.setBindPath("1230106");

      shortStayHospitalRecuperationSubtractionType.setUseClearButton(false);

      shortStayHospitalRecuperationSubtractionType.setModel(getShortStayHospitalRecuperationSubtractionTypeModel());

      addShortStayHospitalRecuperationSubtractionType();
    }
    return shortStayHospitalRecuperationSubtractionType;

  }

  /**
   * 療養環境減算型コンテナを取得します。
   * @return 療養環境減算型コンテナ
   */
  protected ACLabelContainer getShortStayHospitalRecuperationSubtractionTypeContainer(){
    if(shortStayHospitalRecuperationSubtractionTypeContainer==null){
      shortStayHospitalRecuperationSubtractionTypeContainer = new ACLabelContainer();
      shortStayHospitalRecuperationSubtractionTypeContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationSubtractionTypeContainer.setVAlignment(VRLayout.CENTER);
      shortStayHospitalRecuperationSubtractionTypeContainer.add(getShortStayHospitalRecuperationSubtractionType(), null);
    }
    return shortStayHospitalRecuperationSubtractionTypeContainer;
  }

  /**
   * 療養環境減算型モデルを取得します。
   * @return 療養環境減算型モデル
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationSubtractionTypeModel(){
    if(shortStayHospitalRecuperationSubtractionTypeModel==null){
      shortStayHospitalRecuperationSubtractionTypeModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationSubtractionTypeModel();
    }
    return shortStayHospitalRecuperationSubtractionTypeModel;
  }

  /**
   * 基準を取得します。
   * @return 基準
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationSubtractionTypeNormal(){
    if(shortStayHospitalRecuperationSubtractionTypeNormal==null){

      shortStayHospitalRecuperationSubtractionTypeNormal = new ACRadioButtonItem();

      shortStayHospitalRecuperationSubtractionTypeNormal.setText("基準型");

      shortStayHospitalRecuperationSubtractionTypeNormal.setGroup(getShortStayHospitalRecuperationSubtractionType());

      shortStayHospitalRecuperationSubtractionTypeNormal.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationSubtractionTypeNormal();
    }
    return shortStayHospitalRecuperationSubtractionTypeNormal;

  }

  /**
   * 減Iを取得します。
   * @return 減I
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationSubtractionType1(){
    if(shortStayHospitalRecuperationSubtractionType1==null){

      shortStayHospitalRecuperationSubtractionType1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationSubtractionType1.setText("減算型I");

      shortStayHospitalRecuperationSubtractionType1.setGroup(getShortStayHospitalRecuperationSubtractionType());

      shortStayHospitalRecuperationSubtractionType1.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationSubtractionType1();
    }
    return shortStayHospitalRecuperationSubtractionType1;

  }

  /**
   * 減IIを取得します。
   * @return 減II
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationSubtractionType2(){
    if(shortStayHospitalRecuperationSubtractionType2==null){

      shortStayHospitalRecuperationSubtractionType2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationSubtractionType2.setText("減算型II");

      shortStayHospitalRecuperationSubtractionType2.setGroup(getShortStayHospitalRecuperationSubtractionType());

      shortStayHospitalRecuperationSubtractionType2.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationSubtractionType2();
    }
    return shortStayHospitalRecuperationSubtractionType2;

  }

  /**
   * 減IIIを取得します。
   * @return 減III
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationSubtractionType3(){
    if(shortStayHospitalRecuperationSubtractionType3==null){

      shortStayHospitalRecuperationSubtractionType3 = new ACRadioButtonItem();

      shortStayHospitalRecuperationSubtractionType3.setText("減算型III");

      shortStayHospitalRecuperationSubtractionType3.setGroup(getShortStayHospitalRecuperationSubtractionType());

      shortStayHospitalRecuperationSubtractionType3.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationSubtractionType3();
    }
    return shortStayHospitalRecuperationSubtractionType3;

  }

  /**
   * 医師の配置基準を取得します。
   * @return 医師の配置基準
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationApplicationType(){
    if(shortStayHospitalRecuperationApplicationType==null){

      shortStayHospitalRecuperationApplicationType = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationApplicationTypeContainer().setText("医師の配置基準");

      shortStayHospitalRecuperationApplicationType.setBindPath("1230107");

      shortStayHospitalRecuperationApplicationType.setUseClearButton(false);

      shortStayHospitalRecuperationApplicationType.setModel(getShortStayHospitalRecuperationApplicationTypeModel());

      addShortStayHospitalRecuperationApplicationType();
    }
    return shortStayHospitalRecuperationApplicationType;

  }

  /**
   * 医師の配置基準コンテナを取得します。
   * @return 医師の配置基準コンテナ
   */
  protected ACLabelContainer getShortStayHospitalRecuperationApplicationTypeContainer(){
    if(shortStayHospitalRecuperationApplicationTypeContainer==null){
      shortStayHospitalRecuperationApplicationTypeContainer = new ACLabelContainer();
      shortStayHospitalRecuperationApplicationTypeContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationApplicationTypeContainer.setVAlignment(VRLayout.CENTER);
      shortStayHospitalRecuperationApplicationTypeContainer.add(getShortStayHospitalRecuperationApplicationType(), null);
    }
    return shortStayHospitalRecuperationApplicationTypeContainer;
  }

  /**
   * 医師の配置基準モデルを取得します。
   * @return 医師の配置基準モデル
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationApplicationTypeModel(){
    if(shortStayHospitalRecuperationApplicationTypeModel==null){
      shortStayHospitalRecuperationApplicationTypeModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationApplicationTypeModel();
    }
    return shortStayHospitalRecuperationApplicationTypeModel;
  }

  /**
   * 基準を取得します。
   * @return 基準
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationApplicationTypeNormal(){
    if(shortStayHospitalRecuperationApplicationTypeNormal==null){

      shortStayHospitalRecuperationApplicationTypeNormal = new ACRadioButtonItem();

      shortStayHospitalRecuperationApplicationTypeNormal.setText("基準");

      shortStayHospitalRecuperationApplicationTypeNormal.setGroup(getShortStayHospitalRecuperationApplicationType());

      shortStayHospitalRecuperationApplicationTypeNormal.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationApplicationTypeNormal();
    }
    return shortStayHospitalRecuperationApplicationTypeNormal;

  }

  /**
   * 医療法施行規則第49条適用を取得します。
   * @return 医療法施行規則第49条適用
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationApplicationType49(){
    if(shortStayHospitalRecuperationApplicationType49==null){

      shortStayHospitalRecuperationApplicationType49 = new ACRadioButtonItem();

      shortStayHospitalRecuperationApplicationType49.setText("医療法施行規則第49条適用");

      shortStayHospitalRecuperationApplicationType49.setGroup(getShortStayHospitalRecuperationApplicationType());

      shortStayHospitalRecuperationApplicationType49.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationApplicationType49();
    }
    return shortStayHospitalRecuperationApplicationType49;

  }

  /**
   * タブ2を取得します。
   * @return タブ2
   */
  public ACPanel getTab2(){
    if(tab2==null){

      tab2 = new ACPanel();

      tab2.setHgap(0);

      addTab2();
    }
    return tab2;

  }

  /**
   * 送迎加算を取得します。
   * @return 送迎加算
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationMeetingAndSendingOff(){
    if(shortStayHospitalRecuperationMeetingAndSendingOff==null){

      shortStayHospitalRecuperationMeetingAndSendingOff = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationMeetingAndSendingOffContainer().setText("送迎加算");

      shortStayHospitalRecuperationMeetingAndSendingOff.setBindPath("6");

      shortStayHospitalRecuperationMeetingAndSendingOff.setUseClearButton(false);

      shortStayHospitalRecuperationMeetingAndSendingOff.setModel(getShortStayHospitalRecuperationMeetingAndSendingOffModel());

      addShortStayHospitalRecuperationMeetingAndSendingOff();
    }
    return shortStayHospitalRecuperationMeetingAndSendingOff;

  }

  /**
   * 送迎加算コンテナを取得します。
   * @return 送迎加算コンテナ
   */
  protected ACLabelContainer getShortStayHospitalRecuperationMeetingAndSendingOffContainer(){
    if(shortStayHospitalRecuperationMeetingAndSendingOffContainer==null){
      shortStayHospitalRecuperationMeetingAndSendingOffContainer = new ACLabelContainer();
      shortStayHospitalRecuperationMeetingAndSendingOffContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationMeetingAndSendingOffContainer.setVAlignment(VRLayout.CENTER);
      shortStayHospitalRecuperationMeetingAndSendingOffContainer.add(getShortStayHospitalRecuperationMeetingAndSendingOff(), null);
    }
    return shortStayHospitalRecuperationMeetingAndSendingOffContainer;
  }

  /**
   * 送迎加算モデルを取得します。
   * @return 送迎加算モデル
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationMeetingAndSendingOffModel(){
    if(shortStayHospitalRecuperationMeetingAndSendingOffModel==null){
      shortStayHospitalRecuperationMeetingAndSendingOffModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationMeetingAndSendingOffModel();
    }
    return shortStayHospitalRecuperationMeetingAndSendingOffModel;
  }

  /**
   * 送迎なしを取得します。
   * @return 送迎なし
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationMeetingAndSendingOffNone(){
    if(shortStayHospitalRecuperationMeetingAndSendingOffNone==null){

      shortStayHospitalRecuperationMeetingAndSendingOffNone = new ACRadioButtonItem();

      shortStayHospitalRecuperationMeetingAndSendingOffNone.setText("送迎なし");

      shortStayHospitalRecuperationMeetingAndSendingOffNone.setGroup(getShortStayHospitalRecuperationMeetingAndSendingOff());

      shortStayHospitalRecuperationMeetingAndSendingOffNone.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationMeetingAndSendingOffNone();
    }
    return shortStayHospitalRecuperationMeetingAndSendingOffNone;

  }

  /**
   * 送迎片道を取得します。
   * @return 送迎片道
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationMeetingAndSendingOffOneWay(){
    if(shortStayHospitalRecuperationMeetingAndSendingOffOneWay==null){

      shortStayHospitalRecuperationMeetingAndSendingOffOneWay = new ACRadioButtonItem();

      shortStayHospitalRecuperationMeetingAndSendingOffOneWay.setText("送迎片道");

      shortStayHospitalRecuperationMeetingAndSendingOffOneWay.setGroup(getShortStayHospitalRecuperationMeetingAndSendingOff());

      shortStayHospitalRecuperationMeetingAndSendingOffOneWay.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationMeetingAndSendingOffOneWay();
    }
    return shortStayHospitalRecuperationMeetingAndSendingOffOneWay;

  }

  /**
   * 送迎往復を取得します。
   * @return 送迎往復
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationMeetingAndSendingOffRoundTrip(){
    if(shortStayHospitalRecuperationMeetingAndSendingOffRoundTrip==null){

      shortStayHospitalRecuperationMeetingAndSendingOffRoundTrip = new ACRadioButtonItem();

      shortStayHospitalRecuperationMeetingAndSendingOffRoundTrip.setText("送迎往復");

      shortStayHospitalRecuperationMeetingAndSendingOffRoundTrip.setGroup(getShortStayHospitalRecuperationMeetingAndSendingOff());

      shortStayHospitalRecuperationMeetingAndSendingOffRoundTrip.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationMeetingAndSendingOffRoundTrip();
    }
    return shortStayHospitalRecuperationMeetingAndSendingOffRoundTrip;

  }

  /**
   * 栄養管理体制加算を取得します。
   * @return 栄養管理体制加算
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationDieticianManageRadio(){
    if(shortStayHospitalRecuperationDieticianManageRadio==null){

      shortStayHospitalRecuperationDieticianManageRadio = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationDieticianManageRadioContainer().setText("栄養管理体制加算");

      shortStayHospitalRecuperationDieticianManageRadio.setBindPath("1230109");

      shortStayHospitalRecuperationDieticianManageRadio.setUseClearButton(false);

      shortStayHospitalRecuperationDieticianManageRadio.setModel(getShortStayHospitalRecuperationDieticianManageRadioModel());

      addShortStayHospitalRecuperationDieticianManageRadio();
    }
    return shortStayHospitalRecuperationDieticianManageRadio;

  }

  /**
   * 栄養管理体制加算コンテナを取得します。
   * @return 栄養管理体制加算コンテナ
   */
  protected ACLabelContainer getShortStayHospitalRecuperationDieticianManageRadioContainer(){
    if(shortStayHospitalRecuperationDieticianManageRadioContainer==null){
      shortStayHospitalRecuperationDieticianManageRadioContainer = new ACLabelContainer();
      shortStayHospitalRecuperationDieticianManageRadioContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationDieticianManageRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayHospitalRecuperationDieticianManageRadioContainer.add(getShortStayHospitalRecuperationDieticianManageRadio(), null);
    }
    return shortStayHospitalRecuperationDieticianManageRadioContainer;
  }

  /**
   * 栄養管理体制加算モデルを取得します。
   * @return 栄養管理体制加算モデル
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationDieticianManageRadioModel(){
    if(shortStayHospitalRecuperationDieticianManageRadioModel==null){
      shortStayHospitalRecuperationDieticianManageRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationDieticianManageRadioModel();
    }
    return shortStayHospitalRecuperationDieticianManageRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationDieticianManageRadioItem1(){
    if(shortStayHospitalRecuperationDieticianManageRadioItem1==null){

      shortStayHospitalRecuperationDieticianManageRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationDieticianManageRadioItem1.setText("なし");

      shortStayHospitalRecuperationDieticianManageRadioItem1.setGroup(getShortStayHospitalRecuperationDieticianManageRadio());

      shortStayHospitalRecuperationDieticianManageRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationDieticianManageRadioItem1();
    }
    return shortStayHospitalRecuperationDieticianManageRadioItem1;

  }

  /**
   * 管理栄養士を取得します。
   * @return 管理栄養士
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationDieticianManageRadioItem2(){
    if(shortStayHospitalRecuperationDieticianManageRadioItem2==null){

      shortStayHospitalRecuperationDieticianManageRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationDieticianManageRadioItem2.setText("管理栄養士");

      shortStayHospitalRecuperationDieticianManageRadioItem2.setGroup(getShortStayHospitalRecuperationDieticianManageRadio());

      shortStayHospitalRecuperationDieticianManageRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayHospitalRecuperationDieticianManageRadioItem2();
    }
    return shortStayHospitalRecuperationDieticianManageRadioItem2;

  }

  /**
   * 栄養士を取得します。
   * @return 栄養士
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationDieticianManageRadioItem3(){
    if(shortStayHospitalRecuperationDieticianManageRadioItem3==null){

      shortStayHospitalRecuperationDieticianManageRadioItem3 = new ACRadioButtonItem();

      shortStayHospitalRecuperationDieticianManageRadioItem3.setText("栄養士");

      shortStayHospitalRecuperationDieticianManageRadioItem3.setGroup(getShortStayHospitalRecuperationDieticianManageRadio());

      shortStayHospitalRecuperationDieticianManageRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationDieticianManageRadioItem3();
    }
    return shortStayHospitalRecuperationDieticianManageRadioItem3;

  }

  /**
   * 療養食加算を取得します。
   * @return 療養食加算
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationMedicalExpensesRadio(){
    if(shortStayHospitalRecuperationMedicalExpensesRadio==null){

      shortStayHospitalRecuperationMedicalExpensesRadio = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationMedicalExpensesRadioContainer().setText("療養食加算");

      shortStayHospitalRecuperationMedicalExpensesRadio.setBindPath("1230110");

      shortStayHospitalRecuperationMedicalExpensesRadio.setUseClearButton(false);

      shortStayHospitalRecuperationMedicalExpensesRadio.setModel(getShortStayHospitalRecuperationMedicalExpensesRadioModel());

      addShortStayHospitalRecuperationMedicalExpensesRadio();
    }
    return shortStayHospitalRecuperationMedicalExpensesRadio;

  }

  /**
   * 療養食加算コンテナを取得します。
   * @return 療養食加算コンテナ
   */
  protected ACLabelContainer getShortStayHospitalRecuperationMedicalExpensesRadioContainer(){
    if(shortStayHospitalRecuperationMedicalExpensesRadioContainer==null){
      shortStayHospitalRecuperationMedicalExpensesRadioContainer = new ACLabelContainer();
      shortStayHospitalRecuperationMedicalExpensesRadioContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationMedicalExpensesRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayHospitalRecuperationMedicalExpensesRadioContainer.add(getShortStayHospitalRecuperationMedicalExpensesRadio(), null);
    }
    return shortStayHospitalRecuperationMedicalExpensesRadioContainer;
  }

  /**
   * 療養食加算モデルを取得します。
   * @return 療養食加算モデル
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationMedicalExpensesRadioModel(){
    if(shortStayHospitalRecuperationMedicalExpensesRadioModel==null){
      shortStayHospitalRecuperationMedicalExpensesRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationMedicalExpensesRadioModel();
    }
    return shortStayHospitalRecuperationMedicalExpensesRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationMedicalExpensesRadioItem1(){
    if(shortStayHospitalRecuperationMedicalExpensesRadioItem1==null){

      shortStayHospitalRecuperationMedicalExpensesRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationMedicalExpensesRadioItem1.setText("なし");

      shortStayHospitalRecuperationMedicalExpensesRadioItem1.setGroup(getShortStayHospitalRecuperationMedicalExpensesRadio());

      shortStayHospitalRecuperationMedicalExpensesRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationMedicalExpensesRadioItem1();
    }
    return shortStayHospitalRecuperationMedicalExpensesRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationMedicalExpensesRadioItem2(){
    if(shortStayHospitalRecuperationMedicalExpensesRadioItem2==null){

      shortStayHospitalRecuperationMedicalExpensesRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationMedicalExpensesRadioItem2.setText("あり");

      shortStayHospitalRecuperationMedicalExpensesRadioItem2.setGroup(getShortStayHospitalRecuperationMedicalExpensesRadio());

      shortStayHospitalRecuperationMedicalExpensesRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationMedicalExpensesRadioItem2();
    }
    return shortStayHospitalRecuperationMedicalExpensesRadioItem2;

  }

  /**
   * 特定診療費ボタンを取得します。
   * @return 特定診療費ボタン
   */
  public ACMapBindButton getShortStayHospitalRecuperationSpecificConsultationFee(){
    if(shortStayHospitalRecuperationSpecificConsultationFee==null){

      shortStayHospitalRecuperationSpecificConsultationFee = new ACMapBindButton();

      shortStayHospitalRecuperationSpecificConsultationFee.setText("特定診療費");

      shortStayHospitalRecuperationSpecificConsultationFee.setToolTipText("特定診療費を設定します。");

      addShortStayHospitalRecuperationSpecificConsultationFee();
    }
    return shortStayHospitalRecuperationSpecificConsultationFee;

  }

  /**
   * 設定ラベルを取得します。
   * @return 設定ラベル
   */
  public ACLabel getShortStayHospitalRecuperationSpecificConsultationFeeOutline(){
    if(shortStayHospitalRecuperationSpecificConsultationFeeOutline==null){

      shortStayHospitalRecuperationSpecificConsultationFeeOutline = new ACLabel();

      shortStayHospitalRecuperationSpecificConsultationFeeOutline.setText("設定なし");

      shortStayHospitalRecuperationSpecificConsultationFeeOutline.setOpaque(true);
      shortStayHospitalRecuperationSpecificConsultationFeeOutline.setBackground(new Color(255,255,172));

      addShortStayHospitalRecuperationSpecificConsultationFeeOutline();
    }
    return shortStayHospitalRecuperationSpecificConsultationFeeOutline;

  }

  /**
   * 人員減算コンボを取得します。
   * @return 人員減算コンボ
   */
  public ACComboBox getShortStayHospitalRecuperationPersonSubtraction(){
    if(shortStayHospitalRecuperationPersonSubtraction==null){

      shortStayHospitalRecuperationPersonSubtraction = new ACComboBox();

      getShortStayHospitalRecuperationPersonSubtractionContainer().setText("人員減算");

      shortStayHospitalRecuperationPersonSubtraction.setBindPath("1230149");

      shortStayHospitalRecuperationPersonSubtraction.setEditable(false);

      shortStayHospitalRecuperationPersonSubtraction.setModelBindPath("1230149");

      shortStayHospitalRecuperationPersonSubtraction.setRenderBindPath("CONTENT");

      shortStayHospitalRecuperationPersonSubtraction.setModel(getShortStayHospitalRecuperationPersonSubtractionModel());

      addShortStayHospitalRecuperationPersonSubtraction();
    }
    return shortStayHospitalRecuperationPersonSubtraction;

  }

  /**
   * 人員減算コンボコンテナを取得します。
   * @return 人員減算コンボコンテナ
   */
  protected ACLabelContainer getShortStayHospitalRecuperationPersonSubtractionContainer(){
    if(shortStayHospitalRecuperationPersonSubtractionContainer==null){
      shortStayHospitalRecuperationPersonSubtractionContainer = new ACLabelContainer();
      shortStayHospitalRecuperationPersonSubtractionContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationPersonSubtractionContainer.setVAlignment(VRLayout.CENTER);
      shortStayHospitalRecuperationPersonSubtractionContainer.add(getShortStayHospitalRecuperationPersonSubtraction(), null);
    }
    return shortStayHospitalRecuperationPersonSubtractionContainer;
  }

  /**
   * 人員減算コンボモデルを取得します。
   * @return 人員減算コンボモデル
   */
  protected ACComboBoxModelAdapter getShortStayHospitalRecuperationPersonSubtractionModel(){
    if(shortStayHospitalRecuperationPersonSubtractionModel==null){
      shortStayHospitalRecuperationPersonSubtractionModel = new ACComboBoxModelAdapter();
      addShortStayHospitalRecuperationPersonSubtractionModel();
    }
    return shortStayHospitalRecuperationPersonSubtractionModel;
  }

  /**
   * 食事コンテナを取得します。
   * @return 食事コンテナ
   */
  public ACBackLabelContainer getShortStayRecuperationHealthFacilityDinnerContainer(){
    if(shortStayRecuperationHealthFacilityDinnerContainer==null){

      shortStayRecuperationHealthFacilityDinnerContainer = new ACBackLabelContainer();

      addShortStayRecuperationHealthFacilityDinnerContainer();
    }
    return shortStayRecuperationHealthFacilityDinnerContainer;

  }

  /**
   * 食事提供を取得します。
   * @return 食事提供
   */
  public ACComboBox getShortStayRecuperationHealthFacilityDinnerOffer(){
    if(shortStayRecuperationHealthFacilityDinnerOffer==null){

      shortStayRecuperationHealthFacilityDinnerOffer = new ACComboBox();

      getShortStayRecuperationHealthFacilityDinnerOfferContainer().setText("食事提供");

      shortStayRecuperationHealthFacilityDinnerOffer.setBindPath("1230150");

      shortStayRecuperationHealthFacilityDinnerOffer.setEditable(false);

      shortStayRecuperationHealthFacilityDinnerOffer.setModelBindPath("1230150");

      shortStayRecuperationHealthFacilityDinnerOffer.setRenderBindPath("CONTENT");

      shortStayRecuperationHealthFacilityDinnerOffer.setModel(getShortStayRecuperationHealthFacilityDinnerOfferModel());

      addShortStayRecuperationHealthFacilityDinnerOffer();
    }
    return shortStayRecuperationHealthFacilityDinnerOffer;

  }

  /**
   * 食事提供コンテナを取得します。
   * @return 食事提供コンテナ
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityDinnerOfferContainer(){
    if(shortStayRecuperationHealthFacilityDinnerOfferContainer==null){
      shortStayRecuperationHealthFacilityDinnerOfferContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityDinnerOfferContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityDinnerOfferContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthFacilityDinnerOfferContainer.add(getShortStayRecuperationHealthFacilityDinnerOffer(), null);
    }
    return shortStayRecuperationHealthFacilityDinnerOfferContainer;
  }

  /**
   * 食事提供モデルを取得します。
   * @return 食事提供モデル
   */
  protected ACComboBoxModelAdapter getShortStayRecuperationHealthFacilityDinnerOfferModel(){
    if(shortStayRecuperationHealthFacilityDinnerOfferModel==null){
      shortStayRecuperationHealthFacilityDinnerOfferModel = new ACComboBoxModelAdapter();
      addShortStayRecuperationHealthFacilityDinnerOfferModel();
    }
    return shortStayRecuperationHealthFacilityDinnerOfferModel;
  }

  /**
   * 食事費用を取得します。
   * @return 食事費用
   */
  public ACTextField getShortStayRecuperationHealthFacilityDinnerCost(){
    if(shortStayRecuperationHealthFacilityDinnerCost==null){

      shortStayRecuperationHealthFacilityDinnerCost = new ACTextField();

      getShortStayRecuperationHealthFacilityDinnerCostContainer().setText("食事費用");

      shortStayRecuperationHealthFacilityDinnerCost.setBindPath("1230153");

      shortStayRecuperationHealthFacilityDinnerCost.setColumns(4);

      shortStayRecuperationHealthFacilityDinnerCost.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperationHealthFacilityDinnerCost.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperationHealthFacilityDinnerCost.setIMEMode(InputSubset.LATIN);

      shortStayRecuperationHealthFacilityDinnerCost.setMaxLength(5);

      addShortStayRecuperationHealthFacilityDinnerCost();
    }
    return shortStayRecuperationHealthFacilityDinnerCost;

  }

  /**
   * 食事費用コンテナを取得します。
   * @return 食事費用コンテナ
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityDinnerCostContainer(){
    if(shortStayRecuperationHealthFacilityDinnerCostContainer==null){
      shortStayRecuperationHealthFacilityDinnerCostContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityDinnerCostContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityDinnerCostContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthFacilityDinnerCostContainer.add(getShortStayRecuperationHealthFacilityDinnerCost(), null);
    }
    return shortStayRecuperationHealthFacilityDinnerCostContainer;
  }

  /**
   * 30日超を取得します。
   * @return 30日超
   */
  public ACIntegerCheckBox getShortStayHospitalRecuperationEtc30Over(){
    if(shortStayHospitalRecuperationEtc30Over==null){

      shortStayHospitalRecuperationEtc30Over = new ACIntegerCheckBox();

      shortStayHospitalRecuperationEtc30Over.setText("30日超");

      shortStayHospitalRecuperationEtc30Over.setBindPath("5");

      shortStayHospitalRecuperationEtc30Over.setSelectValue(2);

      shortStayHospitalRecuperationEtc30Over.setUnSelectValue(1);

      addShortStayHospitalRecuperationEtc30Over();
    }
    return shortStayHospitalRecuperationEtc30Over;

  }

  /**
   * ユニットケアの整備を取得します。
   * @return ユニットケアの整備
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationUnitCareMaintenanceRadio(){
    if(shortStayHospitalRecuperationUnitCareMaintenanceRadio==null){

      shortStayHospitalRecuperationUnitCareMaintenanceRadio = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationUnitCareMaintenanceRadioContainer().setText("ユニットケアの整備");

      shortStayHospitalRecuperationUnitCareMaintenanceRadio.setBindPath("1230111");

      shortStayHospitalRecuperationUnitCareMaintenanceRadio.setUseClearButton(false);

      shortStayHospitalRecuperationUnitCareMaintenanceRadio.setModel(getShortStayHospitalRecuperationUnitCareMaintenanceRadioModel());

      addShortStayHospitalRecuperationUnitCareMaintenanceRadio();
    }
    return shortStayHospitalRecuperationUnitCareMaintenanceRadio;

  }

  /**
   * ユニットケアの整備コンテナを取得します。
   * @return ユニットケアの整備コンテナ
   */
  protected ACLabelContainer getShortStayHospitalRecuperationUnitCareMaintenanceRadioContainer(){
    if(shortStayHospitalRecuperationUnitCareMaintenanceRadioContainer==null){
      shortStayHospitalRecuperationUnitCareMaintenanceRadioContainer = new ACLabelContainer();
      shortStayHospitalRecuperationUnitCareMaintenanceRadioContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationUnitCareMaintenanceRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayHospitalRecuperationUnitCareMaintenanceRadioContainer.add(getShortStayHospitalRecuperationUnitCareMaintenanceRadio(), null);
    }
    return shortStayHospitalRecuperationUnitCareMaintenanceRadioContainer;
  }

  /**
   * ユニットケアの整備モデルを取得します。
   * @return ユニットケアの整備モデル
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationUnitCareMaintenanceRadioModel(){
    if(shortStayHospitalRecuperationUnitCareMaintenanceRadioModel==null){
      shortStayHospitalRecuperationUnitCareMaintenanceRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationUnitCareMaintenanceRadioModel();
    }
    return shortStayHospitalRecuperationUnitCareMaintenanceRadioModel;
  }

  /**
   * 未整備を取得します。
   * @return 未整備
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationUnitCareMaintenanceRadioItem1(){
    if(shortStayHospitalRecuperationUnitCareMaintenanceRadioItem1==null){

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem1.setText("未整備");

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem1.setGroup(getShortStayHospitalRecuperationUnitCareMaintenanceRadio());

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationUnitCareMaintenanceRadioItem1();
    }
    return shortStayHospitalRecuperationUnitCareMaintenanceRadioItem1;

  }

  /**
   * 整備を取得します。
   * @return 整備
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationUnitCareMaintenanceRadioItem2(){
    if(shortStayHospitalRecuperationUnitCareMaintenanceRadioItem2==null){

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem2.setText("整備");

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem2.setGroup(getShortStayHospitalRecuperationUnitCareMaintenanceRadio());

      shortStayHospitalRecuperationUnitCareMaintenanceRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationUnitCareMaintenanceRadioItem2();
    }
    return shortStayHospitalRecuperationUnitCareMaintenanceRadioItem2;

  }

  /**
   * 緊急短期入所ネットワーク加算を取得します。
   * @return 緊急短期入所ネットワーク加算
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationEmergencyNetworkAddRadio(){
    if(shortStayHospitalRecuperationEmergencyNetworkAddRadio==null){

      shortStayHospitalRecuperationEmergencyNetworkAddRadio = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationEmergencyNetworkAddRadioContainer().setText("緊急短期入所ネットワーク加算");

      shortStayHospitalRecuperationEmergencyNetworkAddRadio.setBindPath("1230112");

      shortStayHospitalRecuperationEmergencyNetworkAddRadio.setUseClearButton(false);

      shortStayHospitalRecuperationEmergencyNetworkAddRadio.setModel(getShortStayHospitalRecuperationEmergencyNetworkAddRadioModel());

      addShortStayHospitalRecuperationEmergencyNetworkAddRadio();
    }
    return shortStayHospitalRecuperationEmergencyNetworkAddRadio;

  }

  /**
   * 緊急短期入所ネットワーク加算コンテナを取得します。
   * @return 緊急短期入所ネットワーク加算コンテナ
   */
  protected ACLabelContainer getShortStayHospitalRecuperationEmergencyNetworkAddRadioContainer(){
    if(shortStayHospitalRecuperationEmergencyNetworkAddRadioContainer==null){
      shortStayHospitalRecuperationEmergencyNetworkAddRadioContainer = new ACLabelContainer();
      shortStayHospitalRecuperationEmergencyNetworkAddRadioContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationEmergencyNetworkAddRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayHospitalRecuperationEmergencyNetworkAddRadioContainer.add(getShortStayHospitalRecuperationEmergencyNetworkAddRadio(), null);
    }
    return shortStayHospitalRecuperationEmergencyNetworkAddRadioContainer;
  }

  /**
   * 緊急短期入所ネットワーク加算モデルを取得します。
   * @return 緊急短期入所ネットワーク加算モデル
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationEmergencyNetworkAddRadioModel(){
    if(shortStayHospitalRecuperationEmergencyNetworkAddRadioModel==null){
      shortStayHospitalRecuperationEmergencyNetworkAddRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationEmergencyNetworkAddRadioModel();
    }
    return shortStayHospitalRecuperationEmergencyNetworkAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationEmergencyNetworkAddRadioItem1(){
    if(shortStayHospitalRecuperationEmergencyNetworkAddRadioItem1==null){

      shortStayHospitalRecuperationEmergencyNetworkAddRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationEmergencyNetworkAddRadioItem1.setText("なし");

      shortStayHospitalRecuperationEmergencyNetworkAddRadioItem1.setGroup(getShortStayHospitalRecuperationEmergencyNetworkAddRadio());

      shortStayHospitalRecuperationEmergencyNetworkAddRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationEmergencyNetworkAddRadioItem1();
    }
    return shortStayHospitalRecuperationEmergencyNetworkAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationEmergencyNetworkAddRadioItem2(){
    if(shortStayHospitalRecuperationEmergencyNetworkAddRadioItem2==null){

      shortStayHospitalRecuperationEmergencyNetworkAddRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationEmergencyNetworkAddRadioItem2.setText("あり");

      shortStayHospitalRecuperationEmergencyNetworkAddRadioItem2.setGroup(getShortStayHospitalRecuperationEmergencyNetworkAddRadio());

      shortStayHospitalRecuperationEmergencyNetworkAddRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayHospitalRecuperationEmergencyNetworkAddRadioItem2();
    }
    return shortStayHospitalRecuperationEmergencyNetworkAddRadioItem2;

  }

  /**
   * コンストラクタです。
   */
  public QS001111Design() {

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

    tab1.add(getShortStayHospitalRecuperationInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayHospitalRecuperationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayHospitalRecuperationHospitalRoomContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayHospitalRecuperationSickroomDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayHospitalRecuperationAdditionTypeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayHospitalRecuperationSubtractionTypeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayHospitalRecuperationApplicationTypeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 施設等の区分に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadio(){

  }

  /**
   * 施設等の区分モデルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioModel(){

    getShortStayHospitalRecuperationInstitutionDivisionRadioItem1().setButtonIndex(1);

    getShortStayHospitalRecuperationInstitutionDivisionRadioModel().add(getShortStayHospitalRecuperationInstitutionDivisionRadioItem1());

    getShortStayHospitalRecuperationInstitutionDivisionRadioItem2().setButtonIndex(2);

    getShortStayHospitalRecuperationInstitutionDivisionRadioModel().add(getShortStayHospitalRecuperationInstitutionDivisionRadioItem2());

    getShortStayHospitalRecuperationInstitutionDivisionRadioItem3().setButtonIndex(3);

    getShortStayHospitalRecuperationInstitutionDivisionRadioModel().add(getShortStayHospitalRecuperationInstitutionDivisionRadioItem3());

    getShortStayHospitalRecuperationInstitutionDivisionRadioItem4().setButtonIndex(4);

    getShortStayHospitalRecuperationInstitutionDivisionRadioModel().add(getShortStayHospitalRecuperationInstitutionDivisionRadioItem4());

  }

  /**
   * 病院に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioItem1(){

  }

  /**
   * ユニット型病院に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioItem2(){

  }

  /**
   * 日帰りショートステイに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioItem3(){

  }

  /**
   * 経過型に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioItem4(){

  }

  /**
   * 人員配置区分に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationDivision(){

  }

  /**
   * 人員配置区分モデルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationDivisionModel(){

    getShortStayHospitalRecuperationType1().setButtonIndex(1);

    getShortStayHospitalRecuperationDivisionModel().add(getShortStayHospitalRecuperationType1());

    getShortStayHospitalRecuperationType2().setButtonIndex(2);

    getShortStayHospitalRecuperationDivisionModel().add(getShortStayHospitalRecuperationType2());

    getShortStayHospitalRecuperationType3().setButtonIndex(3);

    getShortStayHospitalRecuperationDivisionModel().add(getShortStayHospitalRecuperationType3());

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationType1(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationType2(){

  }

  /**
   * III型に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationType3(){

  }

  /**
   * 病室区分・コンテナに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationHospitalRoomContena(){

    shortStayHospitalRecuperationHospitalRoomContena.add(getShortStayHospitalRecuperationHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationHospitalRoomContena.add(getShortStayHospitalRecuperationUnitHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 病室区分（病室）に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationHospitalRoomRadio(){

  }

  /**
   * 病室区分（病室）モデルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationHospitalRoomRadioModel(){

    getShortStayHospitalRecuperationHospitalRoomRadioItem1().setButtonIndex(1);

    getShortStayHospitalRecuperationHospitalRoomRadioModel().add(getShortStayHospitalRecuperationHospitalRoomRadioItem1());

    getShortStayHospitalRecuperationHospitalRoomRadioItem2().setButtonIndex(2);

    getShortStayHospitalRecuperationHospitalRoomRadioModel().add(getShortStayHospitalRecuperationHospitalRoomRadioItem2());

  }

  /**
   * 従来型個室に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationHospitalRoomRadioItem1(){

  }

  /**
   * 多床室に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationHospitalRoomRadioItem2(){

  }

  /**
   * 病室区分（ユニット型病院）に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationUnitHospitalRoomRadio(){

  }

  /**
   * 病室区分（ユニット型病院）モデルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationUnitHospitalRoomRadioModel(){

    getShortStayHospitalRecuperationUnitHospitalRoomRadioItem1().setButtonIndex(1);

    getShortStayHospitalRecuperationUnitHospitalRoomRadioModel().add(getShortStayHospitalRecuperationUnitHospitalRoomRadioItem1());

    getShortStayHospitalRecuperationUnitHospitalRoomRadioItem2().setButtonIndex(2);

    getShortStayHospitalRecuperationUnitHospitalRoomRadioModel().add(getShortStayHospitalRecuperationUnitHospitalRoomRadioItem2());

  }

  /**
   * ユニット型個室に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationUnitHospitalRoomRadioItem1(){

  }

  /**
   * ユニット型準個室に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationUnitHospitalRoomRadioItem2(){

  }

  /**
   * 病室区分ラジオに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationSickroomDivisionRadio(){

  }

  /**
   * 病室区分ラジオモデルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationSickroomDivisionRadioModel(){

    getShortStayHospitalRecuperationSickroomDivisionRadioItem1().setButtonIndex(1);

    getShortStayHospitalRecuperationSickroomDivisionRadioModel().add(getShortStayHospitalRecuperationSickroomDivisionRadioItem1());

    getShortStayHospitalRecuperationSickroomDivisionRadioItem2().setButtonIndex(2);

    getShortStayHospitalRecuperationSickroomDivisionRadioModel().add(getShortStayHospitalRecuperationSickroomDivisionRadioItem2());

    getShortStayHospitalRecuperationSickroomDivisionRadioItem3().setButtonIndex(3);

    getShortStayHospitalRecuperationSickroomDivisionRadioModel().add(getShortStayHospitalRecuperationSickroomDivisionRadioItem3());

    getShortStayHospitalRecuperationSickroomDivisionRadioItem4().setButtonIndex(4);

    getShortStayHospitalRecuperationSickroomDivisionRadioModel().add(getShortStayHospitalRecuperationSickroomDivisionRadioItem4());

  }

  /**
   * 従来型個室に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationSickroomDivisionRadioItem1(){

  }

  /**
   * 多床室に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationSickroomDivisionRadioItem2(){

  }

  /**
   * ユニット型個室に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationSickroomDivisionRadioItem3(){

  }

  /**
   * ユニット型準個室に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationSickroomDivisionRadioItem4(){

  }

  /**
   * 夜間勤務条件基準に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationAdditionType(){

  }

  /**
   * 夜間勤務条件基準モデルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationAdditionTypeModel(){

    getShortStayHospitalRecuperationAdditionTypeNormal().setButtonIndex(1);

    getShortStayHospitalRecuperationAdditionTypeModel().add(getShortStayHospitalRecuperationAdditionTypeNormal());

    getShortStayHospitalRecuperationAdditionType1().setButtonIndex(2);

    getShortStayHospitalRecuperationAdditionTypeModel().add(getShortStayHospitalRecuperationAdditionType1());

    getShortStayHospitalRecuperationAdditionType2().setButtonIndex(3);

    getShortStayHospitalRecuperationAdditionTypeModel().add(getShortStayHospitalRecuperationAdditionType2());

    getShortStayHospitalRecuperationAdditionType3().setButtonIndex(4);

    getShortStayHospitalRecuperationAdditionTypeModel().add(getShortStayHospitalRecuperationAdditionType3());

    getShortStayHospitalRecuperationAdditionTypeNone().setButtonIndex(5);

    getShortStayHospitalRecuperationAdditionTypeModel().add(getShortStayHospitalRecuperationAdditionTypeNone());

  }

  /**
   * 通常に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationAdditionTypeNormal(){

  }

  /**
   * 加算型Iに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationAdditionType1(){

  }

  /**
   * 加算型IIに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationAdditionType2(){

  }

  /**
   * 加算型IIIに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationAdditionType3(){

  }

  /**
   * 減算型に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationAdditionTypeNone(){

  }

  /**
   * 療養環境減算型に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationSubtractionType(){

  }

  /**
   * 療養環境減算型モデルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationSubtractionTypeModel(){

    getShortStayHospitalRecuperationSubtractionTypeNormal().setButtonIndex(1);

    getShortStayHospitalRecuperationSubtractionTypeModel().add(getShortStayHospitalRecuperationSubtractionTypeNormal());

    getShortStayHospitalRecuperationSubtractionType1().setButtonIndex(2);

    getShortStayHospitalRecuperationSubtractionTypeModel().add(getShortStayHospitalRecuperationSubtractionType1());

    getShortStayHospitalRecuperationSubtractionType2().setButtonIndex(3);

    getShortStayHospitalRecuperationSubtractionTypeModel().add(getShortStayHospitalRecuperationSubtractionType2());

    getShortStayHospitalRecuperationSubtractionType3().setButtonIndex(4);

    getShortStayHospitalRecuperationSubtractionTypeModel().add(getShortStayHospitalRecuperationSubtractionType3());

  }

  /**
   * 基準に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationSubtractionTypeNormal(){

  }

  /**
   * 減Iに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationSubtractionType1(){

  }

  /**
   * 減IIに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationSubtractionType2(){

  }

  /**
   * 減IIIに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationSubtractionType3(){

  }

  /**
   * 医師の配置基準に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationApplicationType(){

  }

  /**
   * 医師の配置基準モデルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationApplicationTypeModel(){

    getShortStayHospitalRecuperationApplicationTypeNormal().setButtonIndex(1);

    getShortStayHospitalRecuperationApplicationTypeModel().add(getShortStayHospitalRecuperationApplicationTypeNormal());

    getShortStayHospitalRecuperationApplicationType49().setButtonIndex(2);

    getShortStayHospitalRecuperationApplicationTypeModel().add(getShortStayHospitalRecuperationApplicationType49());

  }

  /**
   * 基準に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationApplicationTypeNormal(){

  }

  /**
   * 医療法施行規則第49条適用に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationApplicationType49(){

  }

  /**
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getShortStayHospitalRecuperationMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayHospitalRecuperationDieticianManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayHospitalRecuperationMedicalExpensesRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayHospitalRecuperationSpecificConsultationFee(), VRLayout.FLOW);

    tab2.add(getShortStayHospitalRecuperationSpecificConsultationFeeOutline(), VRLayout.FLOW_RETURN);

    tab2.add(getShortStayHospitalRecuperationPersonSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayRecuperationHealthFacilityDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tab2.add(getShortStayHospitalRecuperationEtc30Over(), VRLayout.FLOW_INSETLINE);

    tab2.add(getShortStayHospitalRecuperationUnitCareMaintenanceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayHospitalRecuperationEmergencyNetworkAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 送迎加算に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationMeetingAndSendingOff(){

  }

  /**
   * 送迎加算モデルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationMeetingAndSendingOffModel(){

    getShortStayHospitalRecuperationMeetingAndSendingOffNone().setButtonIndex(1);

    getShortStayHospitalRecuperationMeetingAndSendingOffModel().add(getShortStayHospitalRecuperationMeetingAndSendingOffNone());

    getShortStayHospitalRecuperationMeetingAndSendingOffOneWay().setButtonIndex(2);

    getShortStayHospitalRecuperationMeetingAndSendingOffModel().add(getShortStayHospitalRecuperationMeetingAndSendingOffOneWay());

    getShortStayHospitalRecuperationMeetingAndSendingOffRoundTrip().setButtonIndex(3);

    getShortStayHospitalRecuperationMeetingAndSendingOffModel().add(getShortStayHospitalRecuperationMeetingAndSendingOffRoundTrip());

  }

  /**
   * 送迎なしに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationMeetingAndSendingOffNone(){

  }

  /**
   * 送迎片道に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationMeetingAndSendingOffOneWay(){

  }

  /**
   * 送迎往復に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationMeetingAndSendingOffRoundTrip(){

  }

  /**
   * 栄養管理体制加算に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationDieticianManageRadio(){

  }

  /**
   * 栄養管理体制加算モデルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationDieticianManageRadioModel(){

    getShortStayHospitalRecuperationDieticianManageRadioItem1().setButtonIndex(1);

    getShortStayHospitalRecuperationDieticianManageRadioModel().add(getShortStayHospitalRecuperationDieticianManageRadioItem1());

    getShortStayHospitalRecuperationDieticianManageRadioItem2().setButtonIndex(2);

    getShortStayHospitalRecuperationDieticianManageRadioModel().add(getShortStayHospitalRecuperationDieticianManageRadioItem2());

    getShortStayHospitalRecuperationDieticianManageRadioItem3().setButtonIndex(3);

    getShortStayHospitalRecuperationDieticianManageRadioModel().add(getShortStayHospitalRecuperationDieticianManageRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationDieticianManageRadioItem1(){

  }

  /**
   * 管理栄養士に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationDieticianManageRadioItem2(){

  }

  /**
   * 栄養士に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationDieticianManageRadioItem3(){

  }

  /**
   * 療養食加算に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationMedicalExpensesRadio(){

  }

  /**
   * 療養食加算モデルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationMedicalExpensesRadioModel(){

    getShortStayHospitalRecuperationMedicalExpensesRadioItem1().setButtonIndex(1);

    getShortStayHospitalRecuperationMedicalExpensesRadioModel().add(getShortStayHospitalRecuperationMedicalExpensesRadioItem1());

    getShortStayHospitalRecuperationMedicalExpensesRadioItem2().setButtonIndex(2);

    getShortStayHospitalRecuperationMedicalExpensesRadioModel().add(getShortStayHospitalRecuperationMedicalExpensesRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationMedicalExpensesRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationMedicalExpensesRadioItem2(){

  }

  /**
   * 特定診療費ボタンに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationSpecificConsultationFee(){

  }

  /**
   * 設定ラベルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationSpecificConsultationFeeOutline(){

  }

  /**
   * 人員減算コンボに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationPersonSubtraction(){

  }

  /**
   * 人員減算コンボモデルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationPersonSubtractionModel(){

  }

  /**
   * 食事コンテナに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityDinnerContainer(){

    shortStayRecuperationHealthFacilityDinnerContainer.add(getShortStayRecuperationHealthFacilityDinnerOfferContainer(), VRLayout.FLOW);

    shortStayRecuperationHealthFacilityDinnerContainer.add(getShortStayRecuperationHealthFacilityDinnerCostContainer(), VRLayout.FLOW);

  }

  /**
   * 食事提供に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityDinnerOffer(){

  }

  /**
   * 食事提供モデルに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityDinnerOfferModel(){

  }

  /**
   * 食事費用に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityDinnerCost(){

  }

  /**
   * 30日超に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationEtc30Over(){

  }

  /**
   * ユニットケアの整備に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationUnitCareMaintenanceRadio(){

  }

  /**
   * ユニットケアの整備モデルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationUnitCareMaintenanceRadioModel(){

    getShortStayHospitalRecuperationUnitCareMaintenanceRadioItem1().setButtonIndex(1);

    getShortStayHospitalRecuperationUnitCareMaintenanceRadioModel().add(getShortStayHospitalRecuperationUnitCareMaintenanceRadioItem1());

    getShortStayHospitalRecuperationUnitCareMaintenanceRadioItem2().setButtonIndex(2);

    getShortStayHospitalRecuperationUnitCareMaintenanceRadioModel().add(getShortStayHospitalRecuperationUnitCareMaintenanceRadioItem2());

  }

  /**
   * 未整備に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationUnitCareMaintenanceRadioItem1(){

  }

  /**
   * 整備に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationUnitCareMaintenanceRadioItem2(){

  }

  /**
   * 緊急短期入所ネットワーク加算に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationEmergencyNetworkAddRadio(){

  }

  /**
   * 緊急短期入所ネットワーク加算モデルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationEmergencyNetworkAddRadioModel(){

    getShortStayHospitalRecuperationEmergencyNetworkAddRadioItem1().setButtonIndex(1);

    getShortStayHospitalRecuperationEmergencyNetworkAddRadioModel().add(getShortStayHospitalRecuperationEmergencyNetworkAddRadioItem1());

    getShortStayHospitalRecuperationEmergencyNetworkAddRadioItem2().setButtonIndex(2);

    getShortStayHospitalRecuperationEmergencyNetworkAddRadioModel().add(getShortStayHospitalRecuperationEmergencyNetworkAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationEmergencyNetworkAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationEmergencyNetworkAddRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001111Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001111Design getThis() {
    return this;
  }
}
