
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
 * 作成日: 2006/04/11  日本コンピューター株式会社 松本　幸一 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン短期入所療養介護（診療所療養） (QS001112)
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
 * サービスパターン短期入所療養介護（診療所療養）画面項目デザイン(QS001112) 
 */
public class QS001112Design extends QS001ServicePanel {
  //GUIコンポーネント

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACClearableRadioButtonGroup shortStayClinicRecuperationInstitutionDivisionRadio;

  private ACLabelContainer shortStayClinicRecuperationInstitutionDivisionRadioContainer;

  private ACListModelAdapter shortStayClinicRecuperationInstitutionDivisionRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationInstitutionDivisionRadioItem1;

  private ACRadioButtonItem shortStayClinicRecuperationInstitutionDivisionRadioItem2;

  private ACRadioButtonItem shortStayClinicRecuperationInstitutionDivisionRadioItem3;

  private ACClearableRadioButtonGroup shortStayClinicRecuperationDivision;

  private ACLabelContainer shortStayClinicRecuperationDivisionContainer;

  private ACListModelAdapter shortStayClinicRecuperationDivisionModel;

  private ACRadioButtonItem shortStayClinicRecuperationType1;

  private ACRadioButtonItem shortStayClinicRecuperationType2;

  private ACLabelContainer shortStayClinicRecuperationHospitalRoomContena;

  private ACClearableRadioButtonGroup shortStayClinicRecuperationHospitalRoomRadio;

  private ACListModelAdapter shortStayClinicRecuperationHospitalRoomRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationHospitalRoomRadioItem1;

  private ACRadioButtonItem shortStayClinicRecuperationHospitalRoomRadioItem2;

  private ACClearableRadioButtonGroup shortStayClinicRecuperationUnitHospitalRoomRadio;

  private ACListModelAdapter shortStayClinicRecuperationUnitHospitalRoomRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationUnitHospitalRoomRadioItem1;

  private ACRadioButtonItem shortStayClinicRecuperationUnitHospitalRoomRadioItem2;

  private ACClearableRadioButtonGroup shortStayClinicRecuperationSickroomDivisionRadio;

  private ACLabelContainer shortStayClinicRecuperationSickroomDivisionRadioContainer;

  private ACListModelAdapter shortStayClinicRecuperationSickroomDivisionRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationSickroomDivisionRadioItem1;

  private ACRadioButtonItem shortStayClinicRecuperationSickroomDivisionRadioItem2;

  private ACRadioButtonItem shortStayClinicRecuperationSickroomDivisionRadioItem3;

  private ACRadioButtonItem shortStayClinicRecuperationSickroomDivisionRadioItem4;

  private ACClearableRadioButtonGroup shortStayClinicRecuperationSubtractionType;

  private ACLabelContainer shortStayClinicRecuperationSubtractionTypeContainer;

  private ACListModelAdapter shortStayClinicRecuperationSubtractionTypeModel;

  private ACRadioButtonItem shortStayClinicRecuperationSubtractionTypeNormal;

  private ACRadioButtonItem shortStayClinicRecuperationSubtractionType1;

  private ACRadioButtonItem shortStayClinicRecuperationSubtractionType2;

  private ACClearableRadioButtonGroup shortStayClinicRecuperationMeetingAndSendingOff;

  private ACLabelContainer shortStayClinicRecuperationMeetingAndSendingOffContainer;

  private ACListModelAdapter shortStayClinicRecuperationMeetingAndSendingOffModel;

  private ACRadioButtonItem shortStayClinicRecuperationMeetingAndSendingOffNone;

  private ACRadioButtonItem shortStayClinicRecuperationMeetingAndSendingOffOneWay;

  private ACRadioButtonItem shortStayClinicRecuperationMeetingAndSendingOffRoundTrip;

  private ACClearableRadioButtonGroup shortStayClinicRecuperationDieticianManageRadio;

  private ACLabelContainer shortStayClinicRecuperationDieticianManageRadioContainer;

  private ACListModelAdapter shortStayClinicRecuperationDieticianManageRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationDieticianManageRadioItem1;

  private ACRadioButtonItem shortStayClinicRecuperationDieticianManageRadioItem2;

  private ACRadioButtonItem shortStayClinicRecuperationDieticianManageRadioItem3;

  private ACClearableRadioButtonGroup shortStayClinicRecuperationMedicalExpensesRadio;

  private ACLabelContainer shortStayClinicRecuperationMedicalExpensesRadioContainer;

  private ACListModelAdapter shortStayClinicRecuperationMedicalExpensesRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationMedicalExpensesRadioItem1;

  private ACRadioButtonItem shortStayClinicRecuperationMedicalExpensesRadioItem2;

  private ACClearableRadioButtonGroup shortStayClinicRecuperationStaffReduceRadio;

  private ACLabelContainer shortStayClinicRecuperationStaffReduceRadioContainer;

  private ACListModelAdapter shortStayClinicRecuperationStaffReduceRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationStaffReduceRadioItem1;

  private ACRadioButtonItem shortStayClinicRecuperationStaffReduceRadioItem2;

  private ACPanel tab2;

  private ACMapBindButton shortStayClinicRecuperationSpecificConsultationFee;

  private ACLabel shortStayClinicRecuperationSpecificConsultationFeeOutline;

  private ACBackLabelContainer shortStayClinicRecuperationDinnerContainer;

  private ACComboBox shortStayClinicRecuperationDinnerOffer;

  private ACLabelContainer shortStayClinicRecuperationDinnerOfferContainer;

  private ACComboBoxModelAdapter shortStayClinicRecuperationDinnerOfferModel;

  private ACTextField shortStayClinicRecuperationDinnerCost;

  private ACLabelContainer shortStayClinicRecuperationDinnerCostContainer;

  private ACIntegerCheckBox shortStayClinicRecuperationEtc30Over;

  private ACClearableRadioButtonGroup shortStayClinicRecuperationUnitCareMaintenanceRadio;

  private ACLabelContainer shortStayClinicRecuperationUnitCareMaintenanceRadioContainer;

  private ACListModelAdapter shortStayClinicRecuperationUnitCareMaintenanceRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationUnitCareMaintenanceRadioitem1;

  private ACRadioButtonItem shortStayClinicRecuperationUnitCareMaintenanceRadioitem2;

  private ACClearableRadioButtonGroup shortStayClinicRecuperationEmergencyNetworkAddRadio;

  private ACLabelContainer shortStayClinicRecuperationEmergencyNetworkAddRadioContainer;

  private ACListModelAdapter shortStayClinicRecuperationEmergencyNetworkAddRadioModel;

  private ACRadioButtonItem shortStayClinicRecuperationEmergencyNetworkAddRadioItem1;

  private ACRadioButtonItem shortStayClinicRecuperationEmergencyNetworkAddRadioItem2;

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
  public ACClearableRadioButtonGroup getShortStayClinicRecuperationInstitutionDivisionRadio(){
    if(shortStayClinicRecuperationInstitutionDivisionRadio==null){

      shortStayClinicRecuperationInstitutionDivisionRadio = new ACClearableRadioButtonGroup();

      getShortStayClinicRecuperationInstitutionDivisionRadioContainer().setText("施設等の区分");

      shortStayClinicRecuperationInstitutionDivisionRadio.setBindPath("1230201");

      shortStayClinicRecuperationInstitutionDivisionRadio.setUseClearButton(false);

      shortStayClinicRecuperationInstitutionDivisionRadio.setModel(getShortStayClinicRecuperationInstitutionDivisionRadioModel());

      addShortStayClinicRecuperationInstitutionDivisionRadio();
    }
    return shortStayClinicRecuperationInstitutionDivisionRadio;

  }

  /**
   * 施設等の区分コンテナを取得します。
   * @return 施設等の区分コンテナ
   */
  protected ACLabelContainer getShortStayClinicRecuperationInstitutionDivisionRadioContainer(){
    if(shortStayClinicRecuperationInstitutionDivisionRadioContainer==null){
      shortStayClinicRecuperationInstitutionDivisionRadioContainer = new ACLabelContainer();
      shortStayClinicRecuperationInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationInstitutionDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationInstitutionDivisionRadioContainer.add(getShortStayClinicRecuperationInstitutionDivisionRadio(), null);
    }
    return shortStayClinicRecuperationInstitutionDivisionRadioContainer;
  }

  /**
   * 施設等の区分モデルを取得します。
   * @return 施設等の区分モデル
   */
  protected ACListModelAdapter getShortStayClinicRecuperationInstitutionDivisionRadioModel(){
    if(shortStayClinicRecuperationInstitutionDivisionRadioModel==null){
      shortStayClinicRecuperationInstitutionDivisionRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationInstitutionDivisionRadioModel();
    }
    return shortStayClinicRecuperationInstitutionDivisionRadioModel;
  }

  /**
   * 診療所を取得します。
   * @return 診療所
   */
  public ACRadioButtonItem getShortStayClinicRecuperationInstitutionDivisionRadioItem1(){
    if(shortStayClinicRecuperationInstitutionDivisionRadioItem1==null){

      shortStayClinicRecuperationInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationInstitutionDivisionRadioItem1.setText("診療所");

      shortStayClinicRecuperationInstitutionDivisionRadioItem1.setGroup(getShortStayClinicRecuperationInstitutionDivisionRadio());

      shortStayClinicRecuperationInstitutionDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationInstitutionDivisionRadioItem1();
    }
    return shortStayClinicRecuperationInstitutionDivisionRadioItem1;

  }

  /**
   * ユニット型診療所を取得します。
   * @return ユニット型診療所
   */
  public ACRadioButtonItem getShortStayClinicRecuperationInstitutionDivisionRadioItem2(){
    if(shortStayClinicRecuperationInstitutionDivisionRadioItem2==null){

      shortStayClinicRecuperationInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationInstitutionDivisionRadioItem2.setText("ユニット型診療所");

      shortStayClinicRecuperationInstitutionDivisionRadioItem2.setGroup(getShortStayClinicRecuperationInstitutionDivisionRadio());

      shortStayClinicRecuperationInstitutionDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayClinicRecuperationInstitutionDivisionRadioItem2();
    }
    return shortStayClinicRecuperationInstitutionDivisionRadioItem2;

  }

  /**
   * 日帰りショートステイを取得します。
   * @return 日帰りショートステイ
   */
  public ACRadioButtonItem getShortStayClinicRecuperationInstitutionDivisionRadioItem3(){
    if(shortStayClinicRecuperationInstitutionDivisionRadioItem3==null){

      shortStayClinicRecuperationInstitutionDivisionRadioItem3 = new ACRadioButtonItem();

      shortStayClinicRecuperationInstitutionDivisionRadioItem3.setText("日帰りショートステイ");

      shortStayClinicRecuperationInstitutionDivisionRadioItem3.setGroup(getShortStayClinicRecuperationInstitutionDivisionRadio());

      shortStayClinicRecuperationInstitutionDivisionRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationInstitutionDivisionRadioItem3();
    }
    return shortStayClinicRecuperationInstitutionDivisionRadioItem3;

  }

  /**
   * 人員配置区分を取得します。
   * @return 人員配置区分
   */
  public ACClearableRadioButtonGroup getShortStayClinicRecuperationDivision(){
    if(shortStayClinicRecuperationDivision==null){

      shortStayClinicRecuperationDivision = new ACClearableRadioButtonGroup();

      getShortStayClinicRecuperationDivisionContainer().setText("人員配置区分");

      shortStayClinicRecuperationDivision.setBindPath("1230202");

      shortStayClinicRecuperationDivision.setUseClearButton(false);

      shortStayClinicRecuperationDivision.setModel(getShortStayClinicRecuperationDivisionModel());

      addShortStayClinicRecuperationDivision();
    }
    return shortStayClinicRecuperationDivision;

  }

  /**
   * 人員配置区分コンテナを取得します。
   * @return 人員配置区分コンテナ
   */
  protected ACLabelContainer getShortStayClinicRecuperationDivisionContainer(){
    if(shortStayClinicRecuperationDivisionContainer==null){
      shortStayClinicRecuperationDivisionContainer = new ACLabelContainer();
      shortStayClinicRecuperationDivisionContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationDivisionContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationDivisionContainer.add(getShortStayClinicRecuperationDivision(), null);
    }
    return shortStayClinicRecuperationDivisionContainer;
  }

  /**
   * 人員配置区分モデルを取得します。
   * @return 人員配置区分モデル
   */
  protected ACListModelAdapter getShortStayClinicRecuperationDivisionModel(){
    if(shortStayClinicRecuperationDivisionModel==null){
      shortStayClinicRecuperationDivisionModel = new ACListModelAdapter();
      addShortStayClinicRecuperationDivisionModel();
    }
    return shortStayClinicRecuperationDivisionModel;
  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getShortStayClinicRecuperationType1(){
    if(shortStayClinicRecuperationType1==null){

      shortStayClinicRecuperationType1 = new ACRadioButtonItem();

      shortStayClinicRecuperationType1.setText("I型");

      shortStayClinicRecuperationType1.setGroup(getShortStayClinicRecuperationDivision());

      shortStayClinicRecuperationType1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationType1();
    }
    return shortStayClinicRecuperationType1;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getShortStayClinicRecuperationType2(){
    if(shortStayClinicRecuperationType2==null){

      shortStayClinicRecuperationType2 = new ACRadioButtonItem();

      shortStayClinicRecuperationType2.setText("II型");

      shortStayClinicRecuperationType2.setGroup(getShortStayClinicRecuperationDivision());

      shortStayClinicRecuperationType2.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationType2();
    }
    return shortStayClinicRecuperationType2;

  }

  /**
   * 病室区分コンテナを取得します。
   * @return 病室区分コンテナ
   */
  public ACLabelContainer getShortStayClinicRecuperationHospitalRoomContena(){
    if(shortStayClinicRecuperationHospitalRoomContena==null){

      shortStayClinicRecuperationHospitalRoomContena = new ACLabelContainer();

      shortStayClinicRecuperationHospitalRoomContena.setText("病室区分");

      addShortStayClinicRecuperationHospitalRoomContena();
    }
    return shortStayClinicRecuperationHospitalRoomContena;

  }

  /**
   * 病室（診療所）を取得します。
   * @return 病室（診療所）
   */
  public ACClearableRadioButtonGroup getShortStayClinicRecuperationHospitalRoomRadio(){
    if(shortStayClinicRecuperationHospitalRoomRadio==null){

      shortStayClinicRecuperationHospitalRoomRadio = new ACClearableRadioButtonGroup();

      shortStayClinicRecuperationHospitalRoomRadio.setBindPath("1230203");

      shortStayClinicRecuperationHospitalRoomRadio.setUseClearButton(false);

      shortStayClinicRecuperationHospitalRoomRadio.setModel(getShortStayClinicRecuperationHospitalRoomRadioModel());

      addShortStayClinicRecuperationHospitalRoomRadio();
    }
    return shortStayClinicRecuperationHospitalRoomRadio;

  }

  /**
   * 病室（診療所）モデルを取得します。
   * @return 病室（診療所）モデル
   */
  protected ACListModelAdapter getShortStayClinicRecuperationHospitalRoomRadioModel(){
    if(shortStayClinicRecuperationHospitalRoomRadioModel==null){
      shortStayClinicRecuperationHospitalRoomRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationHospitalRoomRadioModel();
    }
    return shortStayClinicRecuperationHospitalRoomRadioModel;
  }

  /**
   * 従来型個室を取得します。
   * @return 従来型個室
   */
  public ACRadioButtonItem getShortStayClinicRecuperationHospitalRoomRadioItem1(){
    if(shortStayClinicRecuperationHospitalRoomRadioItem1==null){

      shortStayClinicRecuperationHospitalRoomRadioItem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationHospitalRoomRadioItem1.setText("従来型個室");

      shortStayClinicRecuperationHospitalRoomRadioItem1.setGroup(getShortStayClinicRecuperationHospitalRoomRadio());

      shortStayClinicRecuperationHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationHospitalRoomRadioItem1();
    }
    return shortStayClinicRecuperationHospitalRoomRadioItem1;

  }

  /**
   * 多床室を取得します。
   * @return 多床室
   */
  public ACRadioButtonItem getShortStayClinicRecuperationHospitalRoomRadioItem2(){
    if(shortStayClinicRecuperationHospitalRoomRadioItem2==null){

      shortStayClinicRecuperationHospitalRoomRadioItem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationHospitalRoomRadioItem2.setText("多床室");

      shortStayClinicRecuperationHospitalRoomRadioItem2.setGroup(getShortStayClinicRecuperationHospitalRoomRadio());

      shortStayClinicRecuperationHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationHospitalRoomRadioItem2();
    }
    return shortStayClinicRecuperationHospitalRoomRadioItem2;

  }

  /**
   * 病室（ユニット型）を取得します。
   * @return 病室（ユニット型）
   */
  public ACClearableRadioButtonGroup getShortStayClinicRecuperationUnitHospitalRoomRadio(){
    if(shortStayClinicRecuperationUnitHospitalRoomRadio==null){

      shortStayClinicRecuperationUnitHospitalRoomRadio = new ACClearableRadioButtonGroup();

      shortStayClinicRecuperationUnitHospitalRoomRadio.setBindPath("1230204");

      shortStayClinicRecuperationUnitHospitalRoomRadio.setUseClearButton(false);

      shortStayClinicRecuperationUnitHospitalRoomRadio.setModel(getShortStayClinicRecuperationUnitHospitalRoomRadioModel());

      addShortStayClinicRecuperationUnitHospitalRoomRadio();
    }
    return shortStayClinicRecuperationUnitHospitalRoomRadio;

  }

  /**
   * 病室（ユニット型）モデルを取得します。
   * @return 病室（ユニット型）モデル
   */
  protected ACListModelAdapter getShortStayClinicRecuperationUnitHospitalRoomRadioModel(){
    if(shortStayClinicRecuperationUnitHospitalRoomRadioModel==null){
      shortStayClinicRecuperationUnitHospitalRoomRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationUnitHospitalRoomRadioModel();
    }
    return shortStayClinicRecuperationUnitHospitalRoomRadioModel;
  }

  /**
   * ユニット型個室を取得します。
   * @return ユニット型個室
   */
  public ACRadioButtonItem getShortStayClinicRecuperationUnitHospitalRoomRadioItem1(){
    if(shortStayClinicRecuperationUnitHospitalRoomRadioItem1==null){

      shortStayClinicRecuperationUnitHospitalRoomRadioItem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationUnitHospitalRoomRadioItem1.setText("ユニット型個室");

      shortStayClinicRecuperationUnitHospitalRoomRadioItem1.setGroup(getShortStayClinicRecuperationUnitHospitalRoomRadio());

      shortStayClinicRecuperationUnitHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationUnitHospitalRoomRadioItem1();
    }
    return shortStayClinicRecuperationUnitHospitalRoomRadioItem1;

  }

  /**
   * ユニット型準個室を取得します。
   * @return ユニット型準個室
   */
  public ACRadioButtonItem getShortStayClinicRecuperationUnitHospitalRoomRadioItem2(){
    if(shortStayClinicRecuperationUnitHospitalRoomRadioItem2==null){

      shortStayClinicRecuperationUnitHospitalRoomRadioItem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationUnitHospitalRoomRadioItem2.setText("ユニット型準個室");

      shortStayClinicRecuperationUnitHospitalRoomRadioItem2.setGroup(getShortStayClinicRecuperationUnitHospitalRoomRadio());

      shortStayClinicRecuperationUnitHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationUnitHospitalRoomRadioItem2();
    }
    return shortStayClinicRecuperationUnitHospitalRoomRadioItem2;

  }

  /**
   * 病室区分ラジオを取得します。
   * @return 病室区分ラジオ
   */
  public ACClearableRadioButtonGroup getShortStayClinicRecuperationSickroomDivisionRadio(){
    if(shortStayClinicRecuperationSickroomDivisionRadio==null){

      shortStayClinicRecuperationSickroomDivisionRadio = new ACClearableRadioButtonGroup();

      getShortStayClinicRecuperationSickroomDivisionRadioContainer().setText("病室区分");

      shortStayClinicRecuperationSickroomDivisionRadio.setBindPath("1230212");

      shortStayClinicRecuperationSickroomDivisionRadio.setUseClearButton(false);

      shortStayClinicRecuperationSickroomDivisionRadio.setModel(getShortStayClinicRecuperationSickroomDivisionRadioModel());

      addShortStayClinicRecuperationSickroomDivisionRadio();
    }
    return shortStayClinicRecuperationSickroomDivisionRadio;

  }

  /**
   * 病室区分ラジオコンテナを取得します。
   * @return 病室区分ラジオコンテナ
   */
  protected ACLabelContainer getShortStayClinicRecuperationSickroomDivisionRadioContainer(){
    if(shortStayClinicRecuperationSickroomDivisionRadioContainer==null){
      shortStayClinicRecuperationSickroomDivisionRadioContainer = new ACLabelContainer();
      shortStayClinicRecuperationSickroomDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationSickroomDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationSickroomDivisionRadioContainer.add(getShortStayClinicRecuperationSickroomDivisionRadio(), null);
    }
    return shortStayClinicRecuperationSickroomDivisionRadioContainer;
  }

  /**
   * 病室区分ラジオモデルを取得します。
   * @return 病室区分ラジオモデル
   */
  protected ACListModelAdapter getShortStayClinicRecuperationSickroomDivisionRadioModel(){
    if(shortStayClinicRecuperationSickroomDivisionRadioModel==null){
      shortStayClinicRecuperationSickroomDivisionRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationSickroomDivisionRadioModel();
    }
    return shortStayClinicRecuperationSickroomDivisionRadioModel;
  }

  /**
   * 従来型個室を取得します。
   * @return 従来型個室
   */
  public ACRadioButtonItem getShortStayClinicRecuperationSickroomDivisionRadioItem1(){
    if(shortStayClinicRecuperationSickroomDivisionRadioItem1==null){

      shortStayClinicRecuperationSickroomDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationSickroomDivisionRadioItem1.setText("従来型個室");

      shortStayClinicRecuperationSickroomDivisionRadioItem1.setGroup(getShortStayClinicRecuperationSickroomDivisionRadio());

      shortStayClinicRecuperationSickroomDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationSickroomDivisionRadioItem1();
    }
    return shortStayClinicRecuperationSickroomDivisionRadioItem1;

  }

  /**
   * 多床室を取得します。
   * @return 多床室
   */
  public ACRadioButtonItem getShortStayClinicRecuperationSickroomDivisionRadioItem2(){
    if(shortStayClinicRecuperationSickroomDivisionRadioItem2==null){

      shortStayClinicRecuperationSickroomDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationSickroomDivisionRadioItem2.setText("多床室");

      shortStayClinicRecuperationSickroomDivisionRadioItem2.setGroup(getShortStayClinicRecuperationSickroomDivisionRadio());

      shortStayClinicRecuperationSickroomDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayClinicRecuperationSickroomDivisionRadioItem2();
    }
    return shortStayClinicRecuperationSickroomDivisionRadioItem2;

  }

  /**
   * ユニット型個室を取得します。
   * @return ユニット型個室
   */
  public ACRadioButtonItem getShortStayClinicRecuperationSickroomDivisionRadioItem3(){
    if(shortStayClinicRecuperationSickroomDivisionRadioItem3==null){

      shortStayClinicRecuperationSickroomDivisionRadioItem3 = new ACRadioButtonItem();

      shortStayClinicRecuperationSickroomDivisionRadioItem3.setText("ユニット型個室");

      shortStayClinicRecuperationSickroomDivisionRadioItem3.setGroup(getShortStayClinicRecuperationSickroomDivisionRadio());

      shortStayClinicRecuperationSickroomDivisionRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationSickroomDivisionRadioItem3();
    }
    return shortStayClinicRecuperationSickroomDivisionRadioItem3;

  }

  /**
   * ユニット型準個室を取得します。
   * @return ユニット型準個室
   */
  public ACRadioButtonItem getShortStayClinicRecuperationSickroomDivisionRadioItem4(){
    if(shortStayClinicRecuperationSickroomDivisionRadioItem4==null){

      shortStayClinicRecuperationSickroomDivisionRadioItem4 = new ACRadioButtonItem();

      shortStayClinicRecuperationSickroomDivisionRadioItem4.setText("ユニット型準個室");

      shortStayClinicRecuperationSickroomDivisionRadioItem4.setGroup(getShortStayClinicRecuperationSickroomDivisionRadio());

      shortStayClinicRecuperationSickroomDivisionRadioItem4.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationSickroomDivisionRadioItem4();
    }
    return shortStayClinicRecuperationSickroomDivisionRadioItem4;

  }

  /**
   * 療養環境減算を取得します。
   * @return 療養環境減算
   */
  public ACClearableRadioButtonGroup getShortStayClinicRecuperationSubtractionType(){
    if(shortStayClinicRecuperationSubtractionType==null){

      shortStayClinicRecuperationSubtractionType = new ACClearableRadioButtonGroup();

      getShortStayClinicRecuperationSubtractionTypeContainer().setText("療養環境減算");

      shortStayClinicRecuperationSubtractionType.setBindPath("1230205");

      shortStayClinicRecuperationSubtractionType.setUseClearButton(false);

      shortStayClinicRecuperationSubtractionType.setModel(getShortStayClinicRecuperationSubtractionTypeModel());

      addShortStayClinicRecuperationSubtractionType();
    }
    return shortStayClinicRecuperationSubtractionType;

  }

  /**
   * 療養環境減算コンテナを取得します。
   * @return 療養環境減算コンテナ
   */
  protected ACLabelContainer getShortStayClinicRecuperationSubtractionTypeContainer(){
    if(shortStayClinicRecuperationSubtractionTypeContainer==null){
      shortStayClinicRecuperationSubtractionTypeContainer = new ACLabelContainer();
      shortStayClinicRecuperationSubtractionTypeContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationSubtractionTypeContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationSubtractionTypeContainer.add(getShortStayClinicRecuperationSubtractionType(), null);
    }
    return shortStayClinicRecuperationSubtractionTypeContainer;
  }

  /**
   * 療養環境減算モデルを取得します。
   * @return 療養環境減算モデル
   */
  protected ACListModelAdapter getShortStayClinicRecuperationSubtractionTypeModel(){
    if(shortStayClinicRecuperationSubtractionTypeModel==null){
      shortStayClinicRecuperationSubtractionTypeModel = new ACListModelAdapter();
      addShortStayClinicRecuperationSubtractionTypeModel();
    }
    return shortStayClinicRecuperationSubtractionTypeModel;
  }

  /**
   * 基準を取得します。
   * @return 基準
   */
  public ACRadioButtonItem getShortStayClinicRecuperationSubtractionTypeNormal(){
    if(shortStayClinicRecuperationSubtractionTypeNormal==null){

      shortStayClinicRecuperationSubtractionTypeNormal = new ACRadioButtonItem();

      shortStayClinicRecuperationSubtractionTypeNormal.setText("基準型");

      shortStayClinicRecuperationSubtractionTypeNormal.setGroup(getShortStayClinicRecuperationSubtractionType());

      shortStayClinicRecuperationSubtractionTypeNormal.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationSubtractionTypeNormal();
    }
    return shortStayClinicRecuperationSubtractionTypeNormal;

  }

  /**
   * 減Iを取得します。
   * @return 減I
   */
  public ACRadioButtonItem getShortStayClinicRecuperationSubtractionType1(){
    if(shortStayClinicRecuperationSubtractionType1==null){

      shortStayClinicRecuperationSubtractionType1 = new ACRadioButtonItem();

      shortStayClinicRecuperationSubtractionType1.setText("減算型I");

      shortStayClinicRecuperationSubtractionType1.setGroup(getShortStayClinicRecuperationSubtractionType());

      shortStayClinicRecuperationSubtractionType1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationSubtractionType1();
    }
    return shortStayClinicRecuperationSubtractionType1;

  }

  /**
   * 減IIを取得します。
   * @return 減II
   */
  public ACRadioButtonItem getShortStayClinicRecuperationSubtractionType2(){
    if(shortStayClinicRecuperationSubtractionType2==null){

      shortStayClinicRecuperationSubtractionType2 = new ACRadioButtonItem();

      shortStayClinicRecuperationSubtractionType2.setText("減算型II");

      shortStayClinicRecuperationSubtractionType2.setGroup(getShortStayClinicRecuperationSubtractionType());

      shortStayClinicRecuperationSubtractionType2.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationSubtractionType2();
    }
    return shortStayClinicRecuperationSubtractionType2;

  }

  /**
   * 送迎加算を取得します。
   * @return 送迎加算
   */
  public ACClearableRadioButtonGroup getShortStayClinicRecuperationMeetingAndSendingOff(){
    if(shortStayClinicRecuperationMeetingAndSendingOff==null){

      shortStayClinicRecuperationMeetingAndSendingOff = new ACClearableRadioButtonGroup();

      getShortStayClinicRecuperationMeetingAndSendingOffContainer().setText("送迎加算");

      shortStayClinicRecuperationMeetingAndSendingOff.setBindPath("6");

      shortStayClinicRecuperationMeetingAndSendingOff.setUseClearButton(false);

      shortStayClinicRecuperationMeetingAndSendingOff.setModel(getShortStayClinicRecuperationMeetingAndSendingOffModel());

      addShortStayClinicRecuperationMeetingAndSendingOff();
    }
    return shortStayClinicRecuperationMeetingAndSendingOff;

  }

  /**
   * 送迎加算コンテナを取得します。
   * @return 送迎加算コンテナ
   */
  protected ACLabelContainer getShortStayClinicRecuperationMeetingAndSendingOffContainer(){
    if(shortStayClinicRecuperationMeetingAndSendingOffContainer==null){
      shortStayClinicRecuperationMeetingAndSendingOffContainer = new ACLabelContainer();
      shortStayClinicRecuperationMeetingAndSendingOffContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationMeetingAndSendingOffContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationMeetingAndSendingOffContainer.add(getShortStayClinicRecuperationMeetingAndSendingOff(), null);
    }
    return shortStayClinicRecuperationMeetingAndSendingOffContainer;
  }

  /**
   * 送迎加算モデルを取得します。
   * @return 送迎加算モデル
   */
  protected ACListModelAdapter getShortStayClinicRecuperationMeetingAndSendingOffModel(){
    if(shortStayClinicRecuperationMeetingAndSendingOffModel==null){
      shortStayClinicRecuperationMeetingAndSendingOffModel = new ACListModelAdapter();
      addShortStayClinicRecuperationMeetingAndSendingOffModel();
    }
    return shortStayClinicRecuperationMeetingAndSendingOffModel;
  }

  /**
   * 送迎なしを取得します。
   * @return 送迎なし
   */
  public ACRadioButtonItem getShortStayClinicRecuperationMeetingAndSendingOffNone(){
    if(shortStayClinicRecuperationMeetingAndSendingOffNone==null){

      shortStayClinicRecuperationMeetingAndSendingOffNone = new ACRadioButtonItem();

      shortStayClinicRecuperationMeetingAndSendingOffNone.setText("送迎なし");

      shortStayClinicRecuperationMeetingAndSendingOffNone.setGroup(getShortStayClinicRecuperationMeetingAndSendingOff());

      shortStayClinicRecuperationMeetingAndSendingOffNone.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationMeetingAndSendingOffNone();
    }
    return shortStayClinicRecuperationMeetingAndSendingOffNone;

  }

  /**
   * 送迎片道を取得します。
   * @return 送迎片道
   */
  public ACRadioButtonItem getShortStayClinicRecuperationMeetingAndSendingOffOneWay(){
    if(shortStayClinicRecuperationMeetingAndSendingOffOneWay==null){

      shortStayClinicRecuperationMeetingAndSendingOffOneWay = new ACRadioButtonItem();

      shortStayClinicRecuperationMeetingAndSendingOffOneWay.setText("送迎片道");

      shortStayClinicRecuperationMeetingAndSendingOffOneWay.setGroup(getShortStayClinicRecuperationMeetingAndSendingOff());

      shortStayClinicRecuperationMeetingAndSendingOffOneWay.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationMeetingAndSendingOffOneWay();
    }
    return shortStayClinicRecuperationMeetingAndSendingOffOneWay;

  }

  /**
   * 送迎往復を取得します。
   * @return 送迎往復
   */
  public ACRadioButtonItem getShortStayClinicRecuperationMeetingAndSendingOffRoundTrip(){
    if(shortStayClinicRecuperationMeetingAndSendingOffRoundTrip==null){

      shortStayClinicRecuperationMeetingAndSendingOffRoundTrip = new ACRadioButtonItem();

      shortStayClinicRecuperationMeetingAndSendingOffRoundTrip.setText("送迎往復");

      shortStayClinicRecuperationMeetingAndSendingOffRoundTrip.setGroup(getShortStayClinicRecuperationMeetingAndSendingOff());

      shortStayClinicRecuperationMeetingAndSendingOffRoundTrip.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationMeetingAndSendingOffRoundTrip();
    }
    return shortStayClinicRecuperationMeetingAndSendingOffRoundTrip;

  }

  /**
   * 栄養管理体制加算を取得します。
   * @return 栄養管理体制加算
   */
  public ACClearableRadioButtonGroup getShortStayClinicRecuperationDieticianManageRadio(){
    if(shortStayClinicRecuperationDieticianManageRadio==null){

      shortStayClinicRecuperationDieticianManageRadio = new ACClearableRadioButtonGroup();

      getShortStayClinicRecuperationDieticianManageRadioContainer().setText("栄養管理体制加算");

      shortStayClinicRecuperationDieticianManageRadio.setBindPath("1230207");

      shortStayClinicRecuperationDieticianManageRadio.setUseClearButton(false);

      shortStayClinicRecuperationDieticianManageRadio.setModel(getShortStayClinicRecuperationDieticianManageRadioModel());

      addShortStayClinicRecuperationDieticianManageRadio();
    }
    return shortStayClinicRecuperationDieticianManageRadio;

  }

  /**
   * 栄養管理体制加算コンテナを取得します。
   * @return 栄養管理体制加算コンテナ
   */
  protected ACLabelContainer getShortStayClinicRecuperationDieticianManageRadioContainer(){
    if(shortStayClinicRecuperationDieticianManageRadioContainer==null){
      shortStayClinicRecuperationDieticianManageRadioContainer = new ACLabelContainer();
      shortStayClinicRecuperationDieticianManageRadioContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationDieticianManageRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationDieticianManageRadioContainer.add(getShortStayClinicRecuperationDieticianManageRadio(), null);
    }
    return shortStayClinicRecuperationDieticianManageRadioContainer;
  }

  /**
   * 栄養管理体制加算モデルを取得します。
   * @return 栄養管理体制加算モデル
   */
  protected ACListModelAdapter getShortStayClinicRecuperationDieticianManageRadioModel(){
    if(shortStayClinicRecuperationDieticianManageRadioModel==null){
      shortStayClinicRecuperationDieticianManageRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationDieticianManageRadioModel();
    }
    return shortStayClinicRecuperationDieticianManageRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayClinicRecuperationDieticianManageRadioItem1(){
    if(shortStayClinicRecuperationDieticianManageRadioItem1==null){

      shortStayClinicRecuperationDieticianManageRadioItem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationDieticianManageRadioItem1.setText("なし");

      shortStayClinicRecuperationDieticianManageRadioItem1.setGroup(getShortStayClinicRecuperationDieticianManageRadio());

      shortStayClinicRecuperationDieticianManageRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationDieticianManageRadioItem1();
    }
    return shortStayClinicRecuperationDieticianManageRadioItem1;

  }

  /**
   * 管理栄養士を取得します。
   * @return 管理栄養士
   */
  public ACRadioButtonItem getShortStayClinicRecuperationDieticianManageRadioItem2(){
    if(shortStayClinicRecuperationDieticianManageRadioItem2==null){

      shortStayClinicRecuperationDieticianManageRadioItem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationDieticianManageRadioItem2.setText("管理栄養士");

      shortStayClinicRecuperationDieticianManageRadioItem2.setGroup(getShortStayClinicRecuperationDieticianManageRadio());

      shortStayClinicRecuperationDieticianManageRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayClinicRecuperationDieticianManageRadioItem2();
    }
    return shortStayClinicRecuperationDieticianManageRadioItem2;

  }

  /**
   * 栄養士を取得します。
   * @return 栄養士
   */
  public ACRadioButtonItem getShortStayClinicRecuperationDieticianManageRadioItem3(){
    if(shortStayClinicRecuperationDieticianManageRadioItem3==null){

      shortStayClinicRecuperationDieticianManageRadioItem3 = new ACRadioButtonItem();

      shortStayClinicRecuperationDieticianManageRadioItem3.setText("栄養士");

      shortStayClinicRecuperationDieticianManageRadioItem3.setGroup(getShortStayClinicRecuperationDieticianManageRadio());

      shortStayClinicRecuperationDieticianManageRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationDieticianManageRadioItem3();
    }
    return shortStayClinicRecuperationDieticianManageRadioItem3;

  }

  /**
   * 療養食加算を取得します。
   * @return 療養食加算
   */
  public ACClearableRadioButtonGroup getShortStayClinicRecuperationMedicalExpensesRadio(){
    if(shortStayClinicRecuperationMedicalExpensesRadio==null){

      shortStayClinicRecuperationMedicalExpensesRadio = new ACClearableRadioButtonGroup();

      getShortStayClinicRecuperationMedicalExpensesRadioContainer().setText("療養食加算");

      shortStayClinicRecuperationMedicalExpensesRadio.setBindPath("1230208");

      shortStayClinicRecuperationMedicalExpensesRadio.setUseClearButton(false);

      shortStayClinicRecuperationMedicalExpensesRadio.setModel(getShortStayClinicRecuperationMedicalExpensesRadioModel());

      addShortStayClinicRecuperationMedicalExpensesRadio();
    }
    return shortStayClinicRecuperationMedicalExpensesRadio;

  }

  /**
   * 療養食加算コンテナを取得します。
   * @return 療養食加算コンテナ
   */
  protected ACLabelContainer getShortStayClinicRecuperationMedicalExpensesRadioContainer(){
    if(shortStayClinicRecuperationMedicalExpensesRadioContainer==null){
      shortStayClinicRecuperationMedicalExpensesRadioContainer = new ACLabelContainer();
      shortStayClinicRecuperationMedicalExpensesRadioContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationMedicalExpensesRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationMedicalExpensesRadioContainer.add(getShortStayClinicRecuperationMedicalExpensesRadio(), null);
    }
    return shortStayClinicRecuperationMedicalExpensesRadioContainer;
  }

  /**
   * 療養食加算モデルを取得します。
   * @return 療養食加算モデル
   */
  protected ACListModelAdapter getShortStayClinicRecuperationMedicalExpensesRadioModel(){
    if(shortStayClinicRecuperationMedicalExpensesRadioModel==null){
      shortStayClinicRecuperationMedicalExpensesRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationMedicalExpensesRadioModel();
    }
    return shortStayClinicRecuperationMedicalExpensesRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayClinicRecuperationMedicalExpensesRadioItem1(){
    if(shortStayClinicRecuperationMedicalExpensesRadioItem1==null){

      shortStayClinicRecuperationMedicalExpensesRadioItem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationMedicalExpensesRadioItem1.setText("なし");

      shortStayClinicRecuperationMedicalExpensesRadioItem1.setGroup(getShortStayClinicRecuperationMedicalExpensesRadio());

      shortStayClinicRecuperationMedicalExpensesRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationMedicalExpensesRadioItem1();
    }
    return shortStayClinicRecuperationMedicalExpensesRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayClinicRecuperationMedicalExpensesRadioItem2(){
    if(shortStayClinicRecuperationMedicalExpensesRadioItem2==null){

      shortStayClinicRecuperationMedicalExpensesRadioItem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationMedicalExpensesRadioItem2.setText("あり");

      shortStayClinicRecuperationMedicalExpensesRadioItem2.setGroup(getShortStayClinicRecuperationMedicalExpensesRadio());

      shortStayClinicRecuperationMedicalExpensesRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationMedicalExpensesRadioItem2();
    }
    return shortStayClinicRecuperationMedicalExpensesRadioItem2;

  }

  /**
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACClearableRadioButtonGroup getShortStayClinicRecuperationStaffReduceRadio(){
    if(shortStayClinicRecuperationStaffReduceRadio==null){

      shortStayClinicRecuperationStaffReduceRadio = new ACClearableRadioButtonGroup();

      getShortStayClinicRecuperationStaffReduceRadioContainer().setText("人員減算");

      shortStayClinicRecuperationStaffReduceRadio.setBindPath("1230209");

      shortStayClinicRecuperationStaffReduceRadio.setUseClearButton(false);

      shortStayClinicRecuperationStaffReduceRadio.setModel(getShortStayClinicRecuperationStaffReduceRadioModel());

      addShortStayClinicRecuperationStaffReduceRadio();
    }
    return shortStayClinicRecuperationStaffReduceRadio;

  }

  /**
   * 人員減算コンテナを取得します。
   * @return 人員減算コンテナ
   */
  protected ACLabelContainer getShortStayClinicRecuperationStaffReduceRadioContainer(){
    if(shortStayClinicRecuperationStaffReduceRadioContainer==null){
      shortStayClinicRecuperationStaffReduceRadioContainer = new ACLabelContainer();
      shortStayClinicRecuperationStaffReduceRadioContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationStaffReduceRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationStaffReduceRadioContainer.add(getShortStayClinicRecuperationStaffReduceRadio(), null);
    }
    return shortStayClinicRecuperationStaffReduceRadioContainer;
  }

  /**
   * 人員減算モデルを取得します。
   * @return 人員減算モデル
   */
  protected ACListModelAdapter getShortStayClinicRecuperationStaffReduceRadioModel(){
    if(shortStayClinicRecuperationStaffReduceRadioModel==null){
      shortStayClinicRecuperationStaffReduceRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationStaffReduceRadioModel();
    }
    return shortStayClinicRecuperationStaffReduceRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayClinicRecuperationStaffReduceRadioItem1(){
    if(shortStayClinicRecuperationStaffReduceRadioItem1==null){

      shortStayClinicRecuperationStaffReduceRadioItem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationStaffReduceRadioItem1.setText("なし");

      shortStayClinicRecuperationStaffReduceRadioItem1.setGroup(getShortStayClinicRecuperationStaffReduceRadio());

      shortStayClinicRecuperationStaffReduceRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationStaffReduceRadioItem1();
    }
    return shortStayClinicRecuperationStaffReduceRadioItem1;

  }

  /**
   * 定員超過を取得します。
   * @return 定員超過
   */
  public ACRadioButtonItem getShortStayClinicRecuperationStaffReduceRadioItem2(){
    if(shortStayClinicRecuperationStaffReduceRadioItem2==null){

      shortStayClinicRecuperationStaffReduceRadioItem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationStaffReduceRadioItem2.setText("定員超過");

      shortStayClinicRecuperationStaffReduceRadioItem2.setGroup(getShortStayClinicRecuperationStaffReduceRadio());

      shortStayClinicRecuperationStaffReduceRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationStaffReduceRadioItem2();
    }
    return shortStayClinicRecuperationStaffReduceRadioItem2;

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
   * 特定診療費ボタンを取得します。
   * @return 特定診療費ボタン
   */
  public ACMapBindButton getShortStayClinicRecuperationSpecificConsultationFee(){
    if(shortStayClinicRecuperationSpecificConsultationFee==null){

      shortStayClinicRecuperationSpecificConsultationFee = new ACMapBindButton();

      shortStayClinicRecuperationSpecificConsultationFee.setText("特定診療費");

      shortStayClinicRecuperationSpecificConsultationFee.setToolTipText("特定診療費を設定します。");

      addShortStayClinicRecuperationSpecificConsultationFee();
    }
    return shortStayClinicRecuperationSpecificConsultationFee;

  }

  /**
   * 設定ラベルを取得します。
   * @return 設定ラベル
   */
  public ACLabel getShortStayClinicRecuperationSpecificConsultationFeeOutline(){
    if(shortStayClinicRecuperationSpecificConsultationFeeOutline==null){

      shortStayClinicRecuperationSpecificConsultationFeeOutline = new ACLabel();

      shortStayClinicRecuperationSpecificConsultationFeeOutline.setText("設定なし");

      shortStayClinicRecuperationSpecificConsultationFeeOutline.setOpaque(true);
      shortStayClinicRecuperationSpecificConsultationFeeOutline.setBackground(new Color(255,255,172));

      addShortStayClinicRecuperationSpecificConsultationFeeOutline();
    }
    return shortStayClinicRecuperationSpecificConsultationFeeOutline;

  }

  /**
   * 食事コンテナを取得します。
   * @return 食事コンテナ
   */
  public ACBackLabelContainer getShortStayClinicRecuperationDinnerContainer(){
    if(shortStayClinicRecuperationDinnerContainer==null){

      shortStayClinicRecuperationDinnerContainer = new ACBackLabelContainer();

      addShortStayClinicRecuperationDinnerContainer();
    }
    return shortStayClinicRecuperationDinnerContainer;

  }

  /**
   * 食事提供を取得します。
   * @return 食事提供
   */
  public ACComboBox getShortStayClinicRecuperationDinnerOffer(){
    if(shortStayClinicRecuperationDinnerOffer==null){

      shortStayClinicRecuperationDinnerOffer = new ACComboBox();

      getShortStayClinicRecuperationDinnerOfferContainer().setText("食事提供");

      shortStayClinicRecuperationDinnerOffer.setBindPath("1230249");

      shortStayClinicRecuperationDinnerOffer.setEditable(false);

      shortStayClinicRecuperationDinnerOffer.setModelBindPath("1230249");

      shortStayClinicRecuperationDinnerOffer.setRenderBindPath("CONTENT");

      shortStayClinicRecuperationDinnerOffer.setModel(getShortStayClinicRecuperationDinnerOfferModel());

      addShortStayClinicRecuperationDinnerOffer();
    }
    return shortStayClinicRecuperationDinnerOffer;

  }

  /**
   * 食事提供コンテナを取得します。
   * @return 食事提供コンテナ
   */
  protected ACLabelContainer getShortStayClinicRecuperationDinnerOfferContainer(){
    if(shortStayClinicRecuperationDinnerOfferContainer==null){
      shortStayClinicRecuperationDinnerOfferContainer = new ACLabelContainer();
      shortStayClinicRecuperationDinnerOfferContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationDinnerOfferContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationDinnerOfferContainer.add(getShortStayClinicRecuperationDinnerOffer(), null);
    }
    return shortStayClinicRecuperationDinnerOfferContainer;
  }

  /**
   * 食事提供モデルを取得します。
   * @return 食事提供モデル
   */
  protected ACComboBoxModelAdapter getShortStayClinicRecuperationDinnerOfferModel(){
    if(shortStayClinicRecuperationDinnerOfferModel==null){
      shortStayClinicRecuperationDinnerOfferModel = new ACComboBoxModelAdapter();
      addShortStayClinicRecuperationDinnerOfferModel();
    }
    return shortStayClinicRecuperationDinnerOfferModel;
  }

  /**
   * 食事費用を取得します。
   * @return 食事費用
   */
  public ACTextField getShortStayClinicRecuperationDinnerCost(){
    if(shortStayClinicRecuperationDinnerCost==null){

      shortStayClinicRecuperationDinnerCost = new ACTextField();

      getShortStayClinicRecuperationDinnerCostContainer().setText("食事費用");

      shortStayClinicRecuperationDinnerCost.setBindPath("1230251");

      shortStayClinicRecuperationDinnerCost.setColumns(4);

      shortStayClinicRecuperationDinnerCost.setCharType(VRCharType.ONLY_DIGIT);

      shortStayClinicRecuperationDinnerCost.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayClinicRecuperationDinnerCost.setIMEMode(InputSubset.LATIN);

      shortStayClinicRecuperationDinnerCost.setMaxLength(5);

      addShortStayClinicRecuperationDinnerCost();
    }
    return shortStayClinicRecuperationDinnerCost;

  }

  /**
   * 食事費用コンテナを取得します。
   * @return 食事費用コンテナ
   */
  protected ACLabelContainer getShortStayClinicRecuperationDinnerCostContainer(){
    if(shortStayClinicRecuperationDinnerCostContainer==null){
      shortStayClinicRecuperationDinnerCostContainer = new ACLabelContainer();
      shortStayClinicRecuperationDinnerCostContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationDinnerCostContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationDinnerCostContainer.add(getShortStayClinicRecuperationDinnerCost(), null);
    }
    return shortStayClinicRecuperationDinnerCostContainer;
  }

  /**
   * 30日超を取得します。
   * @return 30日超
   */
  public ACIntegerCheckBox getShortStayClinicRecuperationEtc30Over(){
    if(shortStayClinicRecuperationEtc30Over==null){

      shortStayClinicRecuperationEtc30Over = new ACIntegerCheckBox();

      shortStayClinicRecuperationEtc30Over.setText("30日超");

      shortStayClinicRecuperationEtc30Over.setBindPath("5");

      shortStayClinicRecuperationEtc30Over.setSelectValue(2);

      shortStayClinicRecuperationEtc30Over.setUnSelectValue(1);

      addShortStayClinicRecuperationEtc30Over();
    }
    return shortStayClinicRecuperationEtc30Over;

  }

  /**
   * ユニットケアの整備を取得します。
   * @return ユニットケアの整備
   */
  public ACClearableRadioButtonGroup getShortStayClinicRecuperationUnitCareMaintenanceRadio(){
    if(shortStayClinicRecuperationUnitCareMaintenanceRadio==null){

      shortStayClinicRecuperationUnitCareMaintenanceRadio = new ACClearableRadioButtonGroup();

      getShortStayClinicRecuperationUnitCareMaintenanceRadioContainer().setText("ユニットケアの整備");

      shortStayClinicRecuperationUnitCareMaintenanceRadio.setBindPath("1230210");

      shortStayClinicRecuperationUnitCareMaintenanceRadio.setUseClearButton(false);

      shortStayClinicRecuperationUnitCareMaintenanceRadio.setModel(getShortStayClinicRecuperationUnitCareMaintenanceRadioModel());

      addShortStayClinicRecuperationUnitCareMaintenanceRadio();
    }
    return shortStayClinicRecuperationUnitCareMaintenanceRadio;

  }

  /**
   * ユニットケアの整備コンテナを取得します。
   * @return ユニットケアの整備コンテナ
   */
  protected ACLabelContainer getShortStayClinicRecuperationUnitCareMaintenanceRadioContainer(){
    if(shortStayClinicRecuperationUnitCareMaintenanceRadioContainer==null){
      shortStayClinicRecuperationUnitCareMaintenanceRadioContainer = new ACLabelContainer();
      shortStayClinicRecuperationUnitCareMaintenanceRadioContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationUnitCareMaintenanceRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationUnitCareMaintenanceRadioContainer.add(getShortStayClinicRecuperationUnitCareMaintenanceRadio(), null);
    }
    return shortStayClinicRecuperationUnitCareMaintenanceRadioContainer;
  }

  /**
   * ユニットケアの整備モデルを取得します。
   * @return ユニットケアの整備モデル
   */
  protected ACListModelAdapter getShortStayClinicRecuperationUnitCareMaintenanceRadioModel(){
    if(shortStayClinicRecuperationUnitCareMaintenanceRadioModel==null){
      shortStayClinicRecuperationUnitCareMaintenanceRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationUnitCareMaintenanceRadioModel();
    }
    return shortStayClinicRecuperationUnitCareMaintenanceRadioModel;
  }

  /**
   * 未整備を取得します。
   * @return 未整備
   */
  public ACRadioButtonItem getShortStayClinicRecuperationUnitCareMaintenanceRadioitem1(){
    if(shortStayClinicRecuperationUnitCareMaintenanceRadioitem1==null){

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem1.setText("未整備");

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem1.setGroup(getShortStayClinicRecuperationUnitCareMaintenanceRadio());

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationUnitCareMaintenanceRadioitem1();
    }
    return shortStayClinicRecuperationUnitCareMaintenanceRadioitem1;

  }

  /**
   * 整備を取得します。
   * @return 整備
   */
  public ACRadioButtonItem getShortStayClinicRecuperationUnitCareMaintenanceRadioitem2(){
    if(shortStayClinicRecuperationUnitCareMaintenanceRadioitem2==null){

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem2.setText("整備");

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem2.setGroup(getShortStayClinicRecuperationUnitCareMaintenanceRadio());

      shortStayClinicRecuperationUnitCareMaintenanceRadioitem2.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationUnitCareMaintenanceRadioitem2();
    }
    return shortStayClinicRecuperationUnitCareMaintenanceRadioitem2;

  }

  /**
   * 緊急短期入所ネットワーク加算を取得します。
   * @return 緊急短期入所ネットワーク加算
   */
  public ACClearableRadioButtonGroup getShortStayClinicRecuperationEmergencyNetworkAddRadio(){
    if(shortStayClinicRecuperationEmergencyNetworkAddRadio==null){

      shortStayClinicRecuperationEmergencyNetworkAddRadio = new ACClearableRadioButtonGroup();

      getShortStayClinicRecuperationEmergencyNetworkAddRadioContainer().setText("緊急短期入所ネットワーク加算");

      shortStayClinicRecuperationEmergencyNetworkAddRadio.setBindPath("1230211");

      shortStayClinicRecuperationEmergencyNetworkAddRadio.setUseClearButton(false);

      shortStayClinicRecuperationEmergencyNetworkAddRadio.setModel(getShortStayClinicRecuperationEmergencyNetworkAddRadioModel());

      addShortStayClinicRecuperationEmergencyNetworkAddRadio();
    }
    return shortStayClinicRecuperationEmergencyNetworkAddRadio;

  }

  /**
   * 緊急短期入所ネットワーク加算コンテナを取得します。
   * @return 緊急短期入所ネットワーク加算コンテナ
   */
  protected ACLabelContainer getShortStayClinicRecuperationEmergencyNetworkAddRadioContainer(){
    if(shortStayClinicRecuperationEmergencyNetworkAddRadioContainer==null){
      shortStayClinicRecuperationEmergencyNetworkAddRadioContainer = new ACLabelContainer();
      shortStayClinicRecuperationEmergencyNetworkAddRadioContainer.setFollowChildEnabled(true);
      shortStayClinicRecuperationEmergencyNetworkAddRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayClinicRecuperationEmergencyNetworkAddRadioContainer.add(getShortStayClinicRecuperationEmergencyNetworkAddRadio(), null);
    }
    return shortStayClinicRecuperationEmergencyNetworkAddRadioContainer;
  }

  /**
   * 緊急短期入所ネットワーク加算モデルを取得します。
   * @return 緊急短期入所ネットワーク加算モデル
   */
  protected ACListModelAdapter getShortStayClinicRecuperationEmergencyNetworkAddRadioModel(){
    if(shortStayClinicRecuperationEmergencyNetworkAddRadioModel==null){
      shortStayClinicRecuperationEmergencyNetworkAddRadioModel = new ACListModelAdapter();
      addShortStayClinicRecuperationEmergencyNetworkAddRadioModel();
    }
    return shortStayClinicRecuperationEmergencyNetworkAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayClinicRecuperationEmergencyNetworkAddRadioItem1(){
    if(shortStayClinicRecuperationEmergencyNetworkAddRadioItem1==null){

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem1 = new ACRadioButtonItem();

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem1.setText("なし");

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem1.setGroup(getShortStayClinicRecuperationEmergencyNetworkAddRadio());

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationEmergencyNetworkAddRadioItem1();
    }
    return shortStayClinicRecuperationEmergencyNetworkAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayClinicRecuperationEmergencyNetworkAddRadioItem2(){
    if(shortStayClinicRecuperationEmergencyNetworkAddRadioItem2==null){

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem2 = new ACRadioButtonItem();

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem2.setText("あり");

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem2.setGroup(getShortStayClinicRecuperationEmergencyNetworkAddRadio());

      shortStayClinicRecuperationEmergencyNetworkAddRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayClinicRecuperationEmergencyNetworkAddRadioItem2();
    }
    return shortStayClinicRecuperationEmergencyNetworkAddRadioItem2;

  }

  /**
   * コンストラクタです。
   */
  public QS001112Design() {

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

    tab1.add(getShortStayClinicRecuperationInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayClinicRecuperationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayClinicRecuperationHospitalRoomContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayClinicRecuperationSickroomDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayClinicRecuperationSubtractionTypeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayClinicRecuperationMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayClinicRecuperationDieticianManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayClinicRecuperationMedicalExpensesRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayClinicRecuperationStaffReduceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 施設等の区分に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationInstitutionDivisionRadio(){

  }

  /**
   * 施設等の区分モデルに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationInstitutionDivisionRadioModel(){

    getShortStayClinicRecuperationInstitutionDivisionRadioItem1().setButtonIndex(1);
    getShortStayClinicRecuperationInstitutionDivisionRadioModel().add(getShortStayClinicRecuperationInstitutionDivisionRadioItem1());

    getShortStayClinicRecuperationInstitutionDivisionRadioItem2().setButtonIndex(2);
    getShortStayClinicRecuperationInstitutionDivisionRadioModel().add(getShortStayClinicRecuperationInstitutionDivisionRadioItem2());

    getShortStayClinicRecuperationInstitutionDivisionRadioItem3().setButtonIndex(3);
    getShortStayClinicRecuperationInstitutionDivisionRadioModel().add(getShortStayClinicRecuperationInstitutionDivisionRadioItem3());

  }

  /**
   * 診療所に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationInstitutionDivisionRadioItem1(){

  }

  /**
   * ユニット型診療所に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationInstitutionDivisionRadioItem2(){

  }

  /**
   * 日帰りショートステイに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationInstitutionDivisionRadioItem3(){

  }

  /**
   * 人員配置区分に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationDivision(){

  }

  /**
   * 人員配置区分モデルに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationDivisionModel(){

    getShortStayClinicRecuperationType1().setButtonIndex(1);
    getShortStayClinicRecuperationDivisionModel().add(getShortStayClinicRecuperationType1());

    getShortStayClinicRecuperationType2().setButtonIndex(2);
    getShortStayClinicRecuperationDivisionModel().add(getShortStayClinicRecuperationType2());

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationType1(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationType2(){

  }

  /**
   * 病室区分コンテナに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationHospitalRoomContena(){

    shortStayClinicRecuperationHospitalRoomContena.add(getShortStayClinicRecuperationHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayClinicRecuperationHospitalRoomContena.add(getShortStayClinicRecuperationUnitHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 病室（診療所）に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationHospitalRoomRadio(){

  }

  /**
   * 病室（診療所）モデルに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationHospitalRoomRadioModel(){

    getShortStayClinicRecuperationHospitalRoomRadioItem1().setButtonIndex(1);
    getShortStayClinicRecuperationHospitalRoomRadioModel().add(getShortStayClinicRecuperationHospitalRoomRadioItem1());

    getShortStayClinicRecuperationHospitalRoomRadioItem2().setButtonIndex(2);
    getShortStayClinicRecuperationHospitalRoomRadioModel().add(getShortStayClinicRecuperationHospitalRoomRadioItem2());

  }

  /**
   * 従来型個室に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationHospitalRoomRadioItem1(){

  }

  /**
   * 多床室に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationHospitalRoomRadioItem2(){

  }

  /**
   * 病室（ユニット型）に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationUnitHospitalRoomRadio(){

  }

  /**
   * 病室（ユニット型）モデルに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationUnitHospitalRoomRadioModel(){

    getShortStayClinicRecuperationUnitHospitalRoomRadioItem1().setButtonIndex(1);
    getShortStayClinicRecuperationUnitHospitalRoomRadioModel().add(getShortStayClinicRecuperationUnitHospitalRoomRadioItem1());

    getShortStayClinicRecuperationUnitHospitalRoomRadioItem2().setButtonIndex(2);
    getShortStayClinicRecuperationUnitHospitalRoomRadioModel().add(getShortStayClinicRecuperationUnitHospitalRoomRadioItem2());

  }

  /**
   * ユニット型個室に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationUnitHospitalRoomRadioItem1(){

  }

  /**
   * ユニット型準個室に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationUnitHospitalRoomRadioItem2(){

  }

  /**
   * 病室区分ラジオに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationSickroomDivisionRadio(){

  }

  /**
   * 病室区分ラジオモデルに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationSickroomDivisionRadioModel(){

    getShortStayClinicRecuperationSickroomDivisionRadioItem1().setButtonIndex(1);
    getShortStayClinicRecuperationSickroomDivisionRadioModel().add(getShortStayClinicRecuperationSickroomDivisionRadioItem1());

    getShortStayClinicRecuperationSickroomDivisionRadioItem2().setButtonIndex(2);
    getShortStayClinicRecuperationSickroomDivisionRadioModel().add(getShortStayClinicRecuperationSickroomDivisionRadioItem2());

    getShortStayClinicRecuperationSickroomDivisionRadioItem3().setButtonIndex(3);
    getShortStayClinicRecuperationSickroomDivisionRadioModel().add(getShortStayClinicRecuperationSickroomDivisionRadioItem3());

    getShortStayClinicRecuperationSickroomDivisionRadioItem4().setButtonIndex(4);
    getShortStayClinicRecuperationSickroomDivisionRadioModel().add(getShortStayClinicRecuperationSickroomDivisionRadioItem4());

  }

  /**
   * 従来型個室に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationSickroomDivisionRadioItem1(){

  }

  /**
   * 多床室に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationSickroomDivisionRadioItem2(){

  }

  /**
   * ユニット型個室に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationSickroomDivisionRadioItem3(){

  }

  /**
   * ユニット型準個室に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationSickroomDivisionRadioItem4(){

  }

  /**
   * 療養環境減算に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationSubtractionType(){

  }

  /**
   * 療養環境減算モデルに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationSubtractionTypeModel(){

    getShortStayClinicRecuperationSubtractionTypeNormal().setButtonIndex(1);
    getShortStayClinicRecuperationSubtractionTypeModel().add(getShortStayClinicRecuperationSubtractionTypeNormal());

    getShortStayClinicRecuperationSubtractionType1().setButtonIndex(2);
    getShortStayClinicRecuperationSubtractionTypeModel().add(getShortStayClinicRecuperationSubtractionType1());

    getShortStayClinicRecuperationSubtractionType2().setButtonIndex(3);
    getShortStayClinicRecuperationSubtractionTypeModel().add(getShortStayClinicRecuperationSubtractionType2());

  }

  /**
   * 基準に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationSubtractionTypeNormal(){

  }

  /**
   * 減Iに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationSubtractionType1(){

  }

  /**
   * 減IIに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationSubtractionType2(){

  }

  /**
   * 送迎加算に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationMeetingAndSendingOff(){

  }

  /**
   * 送迎加算モデルに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationMeetingAndSendingOffModel(){

    getShortStayClinicRecuperationMeetingAndSendingOffNone().setButtonIndex(1);
    getShortStayClinicRecuperationMeetingAndSendingOffModel().add(getShortStayClinicRecuperationMeetingAndSendingOffNone());

    getShortStayClinicRecuperationMeetingAndSendingOffOneWay().setButtonIndex(2);
    getShortStayClinicRecuperationMeetingAndSendingOffModel().add(getShortStayClinicRecuperationMeetingAndSendingOffOneWay());

    getShortStayClinicRecuperationMeetingAndSendingOffRoundTrip().setButtonIndex(3);
    getShortStayClinicRecuperationMeetingAndSendingOffModel().add(getShortStayClinicRecuperationMeetingAndSendingOffRoundTrip());

  }

  /**
   * 送迎なしに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationMeetingAndSendingOffNone(){

  }

  /**
   * 送迎片道に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationMeetingAndSendingOffOneWay(){

  }

  /**
   * 送迎往復に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationMeetingAndSendingOffRoundTrip(){

  }

  /**
   * 栄養管理体制加算に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationDieticianManageRadio(){

  }

  /**
   * 栄養管理体制加算モデルに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationDieticianManageRadioModel(){

    getShortStayClinicRecuperationDieticianManageRadioItem1().setButtonIndex(1);
    getShortStayClinicRecuperationDieticianManageRadioModel().add(getShortStayClinicRecuperationDieticianManageRadioItem1());

    getShortStayClinicRecuperationDieticianManageRadioItem2().setButtonIndex(2);
    getShortStayClinicRecuperationDieticianManageRadioModel().add(getShortStayClinicRecuperationDieticianManageRadioItem2());

    getShortStayClinicRecuperationDieticianManageRadioItem3().setButtonIndex(3);
    getShortStayClinicRecuperationDieticianManageRadioModel().add(getShortStayClinicRecuperationDieticianManageRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationDieticianManageRadioItem1(){

  }

  /**
   * 管理栄養士に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationDieticianManageRadioItem2(){

  }

  /**
   * 栄養士に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationDieticianManageRadioItem3(){

  }

  /**
   * 療養食加算に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationMedicalExpensesRadio(){

  }

  /**
   * 療養食加算モデルに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationMedicalExpensesRadioModel(){

    getShortStayClinicRecuperationMedicalExpensesRadioItem1().setButtonIndex(1);
    getShortStayClinicRecuperationMedicalExpensesRadioModel().add(getShortStayClinicRecuperationMedicalExpensesRadioItem1());

    getShortStayClinicRecuperationMedicalExpensesRadioItem2().setButtonIndex(2);
    getShortStayClinicRecuperationMedicalExpensesRadioModel().add(getShortStayClinicRecuperationMedicalExpensesRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationMedicalExpensesRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationMedicalExpensesRadioItem2(){

  }

  /**
   * 人員減算に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationStaffReduceRadio(){

  }

  /**
   * 人員減算モデルに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationStaffReduceRadioModel(){

    getShortStayClinicRecuperationStaffReduceRadioItem1().setButtonIndex(1);
    getShortStayClinicRecuperationStaffReduceRadioModel().add(getShortStayClinicRecuperationStaffReduceRadioItem1());

    getShortStayClinicRecuperationStaffReduceRadioItem2().setButtonIndex(2);
    getShortStayClinicRecuperationStaffReduceRadioModel().add(getShortStayClinicRecuperationStaffReduceRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationStaffReduceRadioItem1(){

  }

  /**
   * 定員超過に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationStaffReduceRadioItem2(){

  }

  /**
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getShortStayClinicRecuperationSpecificConsultationFee(), VRLayout.FLOW);

    tab2.add(getShortStayClinicRecuperationSpecificConsultationFeeOutline(), VRLayout.FLOW_RETURN);

    tab2.add(getShortStayClinicRecuperationDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tab2.add(getShortStayClinicRecuperationEtc30Over(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayClinicRecuperationUnitCareMaintenanceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayClinicRecuperationEmergencyNetworkAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 特定診療費ボタンに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationSpecificConsultationFee(){

  }

  /**
   * 設定ラベルに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationSpecificConsultationFeeOutline(){

  }

  /**
   * 食事コンテナに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationDinnerContainer(){

    shortStayClinicRecuperationDinnerContainer.add(getShortStayClinicRecuperationDinnerOfferContainer(), VRLayout.FLOW);

    shortStayClinicRecuperationDinnerContainer.add(getShortStayClinicRecuperationDinnerCostContainer(), VRLayout.FLOW);

  }

  /**
   * 食事提供に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationDinnerOffer(){

  }

  /**
   * 食事提供モデルに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationDinnerOfferModel(){

  }

  /**
   * 食事費用に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationDinnerCost(){

  }

  /**
   * 30日超に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationEtc30Over(){

  }

  /**
   * ユニットケアの整備に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationUnitCareMaintenanceRadio(){

  }

  /**
   * ユニットケアの整備モデルに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationUnitCareMaintenanceRadioModel(){

    getShortStayClinicRecuperationUnitCareMaintenanceRadioitem1().setButtonIndex(1);
    getShortStayClinicRecuperationUnitCareMaintenanceRadioModel().add(getShortStayClinicRecuperationUnitCareMaintenanceRadioitem1());

    getShortStayClinicRecuperationUnitCareMaintenanceRadioitem2().setButtonIndex(2);
    getShortStayClinicRecuperationUnitCareMaintenanceRadioModel().add(getShortStayClinicRecuperationUnitCareMaintenanceRadioitem2());

  }

  /**
   * 未整備に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationUnitCareMaintenanceRadioitem1(){

  }

  /**
   * 整備に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationUnitCareMaintenanceRadioitem2(){

  }

  /**
   * 緊急短期入所ネットワーク加算に内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationEmergencyNetworkAddRadio(){

  }

  /**
   * 緊急短期入所ネットワーク加算モデルに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationEmergencyNetworkAddRadioModel(){

    getShortStayClinicRecuperationEmergencyNetworkAddRadioItem1().setButtonIndex(1);
    getShortStayClinicRecuperationEmergencyNetworkAddRadioModel().add(getShortStayClinicRecuperationEmergencyNetworkAddRadioItem1());

    getShortStayClinicRecuperationEmergencyNetworkAddRadioItem2().setButtonIndex(2);
    getShortStayClinicRecuperationEmergencyNetworkAddRadioModel().add(getShortStayClinicRecuperationEmergencyNetworkAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationEmergencyNetworkAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayClinicRecuperationEmergencyNetworkAddRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001112Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001112Design getThis() {
    return this;
  }
}
