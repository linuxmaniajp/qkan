
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
 * プログラム サービスパターン短期入所療養介護（介護老人保健施設） (QS001110)
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
 * サービスパターン短期入所療養介護（介護老人保健施設）画面項目デザイン(QS001110) 
 */
public class QS001110Design extends QS001ServicePanel {
  //GUIコンポーネント

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthFacilityInstitutionDivisionRadio;

  private ACLabelContainer shortStayRecuperationHealthFacilityInstitutionDivisionRadioContainer;

  private ACListModelAdapter shortStayRecuperationHealthFacilityInstitutionDivisionRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3;

  private ACLabelContainer shortStayRecuperationHealthFacilityHospitalRoomDivisionContena;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthFacilityHospitalRoomDivisionRadio;

  private ACListModelAdapter shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio;

  private ACListModelAdapter shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthFacilitySickroomDivisionRadio;

  private ACLabelContainer shortStayRecuperationHealthFacilitySickroomDivisionRadioContainer;

  private ACListModelAdapter shortStayRecuperationHealthFacilitySickroomDivisionRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilitySickroomDivisionRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthFacilitySickroomDivisionRadioItem2;

  private ACRadioButtonItem shortStayRecuperationHealthFacilitySickroomDivisionRadioItem3;

  private ACRadioButtonItem shortStayRecuperationHealthFacilitySickroomDivisionRadioItem4;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthNightWorkConditionRadio;

  private ACLabelContainer shortStayRecuperationHealthNightWorkConditionRadioContainer;

  private ACListModelAdapter shortStayRecuperationHealthNightWorkConditionRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthNightWorkConditionRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthNightWorkConditionRadioItem2;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthFacilityEtcRehabilitation;

  private ACLabelContainer shortStayRecuperationHealthFacilityEtcRehabilitationContainer;

  private ACListModelAdapter shortStayRecuperationHealthFacilityEtcRehabilitationModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityEtcRehabilitationRadioItem2;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityEtcRehabilitationRadioItem1;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio;

  private ACLabelContainer shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioContainer;

  private ACListModelAdapter shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthFacilityMeetingAndSendingOff;

  private ACLabelContainer shortStayRecuperationHealthFacilityMeetingAndSendingOffContainer;

  private ACListModelAdapter shortStayRecuperationHealthFacilityMeetingAndSendingOffModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityMeetingAndSendingOffNone;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthFacilityUrgentTimeStepRadio;

  private ACLabelContainer shortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer;

  private ACListModelAdapter shortStayRecuperationHealthFacilityUrgentTimeStepRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthFacilityDieticianManageRadio;

  private ACLabelContainer shortStayRecuperationHealthFacilityDieticianManageRadioContainer;

  private ACListModelAdapter shortStayRecuperationHealthFacilityDieticianManageRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityDieticianManageRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityDieticianManageRadioItem2;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityDieticianManageRadioItem3;

  private ACPanel tab2;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio;

  private ACLabelContainer shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer;

  private ACListModelAdapter shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthFacilityPersonSubtraction;

  private ACLabelContainer shortStayRecuperationHealthFacilityPersonSubtractionContainer;

  private ACListModelAdapter shortStayRecuperationHealthFacilityPersonSubtractionModel;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityPersonSubtractionNot;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityPersonSubtractionExcess;

  private ACRadioButtonItem shortStayRecuperationHealthFacilityPersonSubtractionStaffLack;

  private ACBackLabelContainer shortStayRecuperationHealthFacilityDinnerContainer;

  private ACComboBox shortStayRecuperationHealthFacilityDinnerOffer;

  private ACLabelContainer shortStayRecuperationHealthFacilityDinnerOfferContainer;

  private ACComboBoxModelAdapter shortStayRecuperationHealthFacilityDinnerOfferModel;

  private ACTextField shortStayRecuperationHealthFacilityDinnerCost;

  private ACLabelContainer shortStayRecuperationHealthFacilityDinnerCostContainer;

  private ACIntegerCheckBox shortStayRecuperationHealthFacilityEtc30Over;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthUnitCareAddRadio;

  private ACLabelContainer shortStayRecuperationHealthUnitCareAddRadioContainer;

  private ACListModelAdapter shortStayRecuperationHealthUnitCareAddRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthUnitCareAddRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthUnitCareAddRadioItem2;

  private ACClearableRadioButtonGroup shortStayRecuperationHealthEmergencyNetworkAddRadio;

  private ACLabelContainer shortStayRecuperationHealthEmergencyNetworkAddRadioContainer;

  private ACListModelAdapter shortStayRecuperationHealthEmergencyNetworkAddRadioModel;

  private ACRadioButtonItem shortStayRecuperationHealthEmergencyNetworkAddRadioItem1;

  private ACRadioButtonItem shortStayRecuperationHealthEmergencyNetworkAddRadioItem2;

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
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthFacilityInstitutionDivisionRadio(){
    if(shortStayRecuperationHealthFacilityInstitutionDivisionRadio==null){

      shortStayRecuperationHealthFacilityInstitutionDivisionRadio = new ACClearableRadioButtonGroup();

      getShortStayRecuperationHealthFacilityInstitutionDivisionRadioContainer().setText("施設等の区分");

      shortStayRecuperationHealthFacilityInstitutionDivisionRadio.setBindPath("1220101");

      shortStayRecuperationHealthFacilityInstitutionDivisionRadio.setUseClearButton(false);

      shortStayRecuperationHealthFacilityInstitutionDivisionRadio.setModel(getShortStayRecuperationHealthFacilityInstitutionDivisionRadioModel());

      addShortStayRecuperationHealthFacilityInstitutionDivisionRadio();
    }
    return shortStayRecuperationHealthFacilityInstitutionDivisionRadio;

  }

  /**
   * 施設等の区分コンテナを取得します。
   * @return 施設等の区分コンテナ
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityInstitutionDivisionRadioContainer(){
    if(shortStayRecuperationHealthFacilityInstitutionDivisionRadioContainer==null){
      shortStayRecuperationHealthFacilityInstitutionDivisionRadioContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityInstitutionDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthFacilityInstitutionDivisionRadioContainer.add(getShortStayRecuperationHealthFacilityInstitutionDivisionRadio(), null);
    }
    return shortStayRecuperationHealthFacilityInstitutionDivisionRadioContainer;
  }

  /**
   * 施設等の区分モデルを取得します。
   * @return 施設等の区分モデル
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilityInstitutionDivisionRadioModel(){
    if(shortStayRecuperationHealthFacilityInstitutionDivisionRadioModel==null){
      shortStayRecuperationHealthFacilityInstitutionDivisionRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilityInstitutionDivisionRadioModel();
    }
    return shortStayRecuperationHealthFacilityInstitutionDivisionRadioModel;
  }

  /**
   * 介護老人保健施設を取得します。
   * @return 介護老人保健施設
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1(){
    if(shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1==null){

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1.setText("介護老人保健施設");

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1.setGroup(getShortStayRecuperationHealthFacilityInstitutionDivisionRadio());

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1();
    }
    return shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1;

  }

  /**
   * ユニット型介護老人保健施設を取得します。
   * @return ユニット型介護老人保健施設
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2(){
    if(shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2==null){

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2.setText("ユニット型介護老人保健施設");

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2.setGroup(getShortStayRecuperationHealthFacilityInstitutionDivisionRadio());

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2();
    }
    return shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2;

  }

  /**
   * 日帰りショートステイを取得します。
   * @return 日帰りショートステイ
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3(){
    if(shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3==null){

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3.setText("日帰りショートステイ");

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3.setGroup(getShortStayRecuperationHealthFacilityInstitutionDivisionRadio());

      shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3();
    }
    return shortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3;

  }

  /**
   * 病室区分コンテナを取得します。
   * @return 病室区分コンテナ
   */
  public ACLabelContainer getShortStayRecuperationHealthFacilityHospitalRoomDivisionContena(){
    if(shortStayRecuperationHealthFacilityHospitalRoomDivisionContena==null){

      shortStayRecuperationHealthFacilityHospitalRoomDivisionContena = new ACLabelContainer();

      shortStayRecuperationHealthFacilityHospitalRoomDivisionContena.setText("病室区分");

      shortStayRecuperationHealthFacilityHospitalRoomDivisionContena.setFollowChildEnabled(true);

      addShortStayRecuperationHealthFacilityHospitalRoomDivisionContena();
    }
    return shortStayRecuperationHealthFacilityHospitalRoomDivisionContena;

  }

  /**
   * 病室区分（介護老人保健施設）を取得します。
   * @return 病室区分（介護老人保健施設）
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio(){
    if(shortStayRecuperationHealthFacilityHospitalRoomDivisionRadio==null){

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadio = new ACClearableRadioButtonGroup();

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadio.setBindPath("1220102");

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadio.setUseClearButton(false);

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadio.setModel(getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel());

      addShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio();
    }
    return shortStayRecuperationHealthFacilityHospitalRoomDivisionRadio;

  }

  /**
   * 病室区分（介護老人保健施設）モデルを取得します。
   * @return 病室区分（介護老人保健施設）モデル
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel(){
    if(shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel==null){
      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel();
    }
    return shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel;
  }

  /**
   * 従来型個室を取得します。
   * @return 従来型個室
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1(){
    if(shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1==null){

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1.setText("従来型個室");

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1.setGroup(getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio());

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1();
    }
    return shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1;

  }

  /**
   * 多床室を取得します。
   * @return 多床室
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2(){
    if(shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2==null){

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2.setText("多床室");

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2.setGroup(getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio());

      shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2();
    }
    return shortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2;

  }

  /**
   * 病室区分（ユニット型介護老人保健施設）を取得します。
   * @return 病室区分（ユニット型介護老人保健施設）
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio(){
    if(shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio==null){

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio = new ACClearableRadioButtonGroup();

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio.setBindPath("1220103");

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio.setUseClearButton(false);

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio.setModel(getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel());

      addShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio();
    }
    return shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio;

  }

  /**
   * 病室区分（ユニット型介護老人保健施設）モデルを取得します。
   * @return 病室区分（ユニット型介護老人保健施設）モデル
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel(){
    if(shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel==null){
      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel();
    }
    return shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel;
  }

  /**
   * ユニット型個室を取得します。
   * @return ユニット型個室
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1(){
    if(shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1==null){

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1.setText("ユニット型個室");

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1.setGroup(getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio());

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1();
    }
    return shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1;

  }

  /**
   * ユニット型準個室を取得します。
   * @return ユニット型準個室
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2(){
    if(shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2==null){

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2.setText("ユニット型準個室");

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2.setGroup(getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio());

      shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2();
    }
    return shortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2;

  }

  /**
   * 病室区分ラジオを取得します。
   * @return 病室区分ラジオ
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthFacilitySickroomDivisionRadio(){
    if(shortStayRecuperationHealthFacilitySickroomDivisionRadio==null){

      shortStayRecuperationHealthFacilitySickroomDivisionRadio = new ACClearableRadioButtonGroup();

      getShortStayRecuperationHealthFacilitySickroomDivisionRadioContainer().setText("病室区分");

      shortStayRecuperationHealthFacilitySickroomDivisionRadio.setBindPath("1220119");

      shortStayRecuperationHealthFacilitySickroomDivisionRadio.setUseClearButton(false);

      shortStayRecuperationHealthFacilitySickroomDivisionRadio.setModel(getShortStayRecuperationHealthFacilitySickroomDivisionRadioModel());

      addShortStayRecuperationHealthFacilitySickroomDivisionRadio();
    }
    return shortStayRecuperationHealthFacilitySickroomDivisionRadio;

  }

  /**
   * 病室区分ラジオコンテナを取得します。
   * @return 病室区分ラジオコンテナ
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilitySickroomDivisionRadioContainer(){
    if(shortStayRecuperationHealthFacilitySickroomDivisionRadioContainer==null){
      shortStayRecuperationHealthFacilitySickroomDivisionRadioContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilitySickroomDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilitySickroomDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthFacilitySickroomDivisionRadioContainer.add(getShortStayRecuperationHealthFacilitySickroomDivisionRadio(), null);
    }
    return shortStayRecuperationHealthFacilitySickroomDivisionRadioContainer;
  }

  /**
   * 病室区分ラジオモデルを取得します。
   * @return 病室区分ラジオモデル
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilitySickroomDivisionRadioModel(){
    if(shortStayRecuperationHealthFacilitySickroomDivisionRadioModel==null){
      shortStayRecuperationHealthFacilitySickroomDivisionRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilitySickroomDivisionRadioModel();
    }
    return shortStayRecuperationHealthFacilitySickroomDivisionRadioModel;
  }

  /**
   * 従来型個室を取得します。
   * @return 従来型個室
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem1(){
    if(shortStayRecuperationHealthFacilitySickroomDivisionRadioItem1==null){

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem1.setText("従来型個室");

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem1.setGroup(getShortStayRecuperationHealthFacilitySickroomDivisionRadio());

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilitySickroomDivisionRadioItem1();
    }
    return shortStayRecuperationHealthFacilitySickroomDivisionRadioItem1;

  }

  /**
   * 多床室を取得します。
   * @return 多床室
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem2(){
    if(shortStayRecuperationHealthFacilitySickroomDivisionRadioItem2==null){

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem2.setText("多床室");

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem2.setGroup(getShortStayRecuperationHealthFacilitySickroomDivisionRadio());

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayRecuperationHealthFacilitySickroomDivisionRadioItem2();
    }
    return shortStayRecuperationHealthFacilitySickroomDivisionRadioItem2;

  }

  /**
   * ユニット型個室を取得します。
   * @return ユニット型個室
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem3(){
    if(shortStayRecuperationHealthFacilitySickroomDivisionRadioItem3==null){

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem3 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem3.setText("ユニット型個室");

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem3.setGroup(getShortStayRecuperationHealthFacilitySickroomDivisionRadio());

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilitySickroomDivisionRadioItem3();
    }
    return shortStayRecuperationHealthFacilitySickroomDivisionRadioItem3;

  }

  /**
   * ユニット型準個室を取得します。
   * @return ユニット型準個室
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem4(){
    if(shortStayRecuperationHealthFacilitySickroomDivisionRadioItem4==null){

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem4 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem4.setText("ユニット型準個室");

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem4.setGroup(getShortStayRecuperationHealthFacilitySickroomDivisionRadio());

      shortStayRecuperationHealthFacilitySickroomDivisionRadioItem4.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilitySickroomDivisionRadioItem4();
    }
    return shortStayRecuperationHealthFacilitySickroomDivisionRadioItem4;

  }

  /**
   * 夜間勤務条件基準を取得します。
   * @return 夜間勤務条件基準
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthNightWorkConditionRadio(){
    if(shortStayRecuperationHealthNightWorkConditionRadio==null){

      shortStayRecuperationHealthNightWorkConditionRadio = new ACClearableRadioButtonGroup();

      getShortStayRecuperationHealthNightWorkConditionRadioContainer().setText("夜間勤務条件基準");

      shortStayRecuperationHealthNightWorkConditionRadio.setBindPath("1220104");

      shortStayRecuperationHealthNightWorkConditionRadio.setUseClearButton(false);

      shortStayRecuperationHealthNightWorkConditionRadio.setModel(getShortStayRecuperationHealthNightWorkConditionRadioModel());

      addShortStayRecuperationHealthNightWorkConditionRadio();
    }
    return shortStayRecuperationHealthNightWorkConditionRadio;

  }

  /**
   * 夜間勤務条件基準コンテナを取得します。
   * @return 夜間勤務条件基準コンテナ
   */
  protected ACLabelContainer getShortStayRecuperationHealthNightWorkConditionRadioContainer(){
    if(shortStayRecuperationHealthNightWorkConditionRadioContainer==null){
      shortStayRecuperationHealthNightWorkConditionRadioContainer = new ACLabelContainer();
      shortStayRecuperationHealthNightWorkConditionRadioContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthNightWorkConditionRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthNightWorkConditionRadioContainer.add(getShortStayRecuperationHealthNightWorkConditionRadio(), null);
    }
    return shortStayRecuperationHealthNightWorkConditionRadioContainer;
  }

  /**
   * 夜間勤務条件基準モデルを取得します。
   * @return 夜間勤務条件基準モデル
   */
  protected ACListModelAdapter getShortStayRecuperationHealthNightWorkConditionRadioModel(){
    if(shortStayRecuperationHealthNightWorkConditionRadioModel==null){
      shortStayRecuperationHealthNightWorkConditionRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthNightWorkConditionRadioModel();
    }
    return shortStayRecuperationHealthNightWorkConditionRadioModel;
  }

  /**
   * 基準型を取得します。
   * @return 基準型
   */
  public ACRadioButtonItem getShortStayRecuperationHealthNightWorkConditionRadioItem1(){
    if(shortStayRecuperationHealthNightWorkConditionRadioItem1==null){

      shortStayRecuperationHealthNightWorkConditionRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthNightWorkConditionRadioItem1.setText("基準型");

      shortStayRecuperationHealthNightWorkConditionRadioItem1.setGroup(getShortStayRecuperationHealthNightWorkConditionRadio());

      shortStayRecuperationHealthNightWorkConditionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthNightWorkConditionRadioItem1();
    }
    return shortStayRecuperationHealthNightWorkConditionRadioItem1;

  }

  /**
   * 減算型を取得します。
   * @return 減算型
   */
  public ACRadioButtonItem getShortStayRecuperationHealthNightWorkConditionRadioItem2(){
    if(shortStayRecuperationHealthNightWorkConditionRadioItem2==null){

      shortStayRecuperationHealthNightWorkConditionRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthNightWorkConditionRadioItem2.setText("減算型");

      shortStayRecuperationHealthNightWorkConditionRadioItem2.setGroup(getShortStayRecuperationHealthNightWorkConditionRadio());

      shortStayRecuperationHealthNightWorkConditionRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthNightWorkConditionRadioItem2();
    }
    return shortStayRecuperationHealthNightWorkConditionRadioItem2;

  }

  /**
   * リハビリ機能強化加算を取得します。
   * @return リハビリ機能強化加算
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthFacilityEtcRehabilitation(){
    if(shortStayRecuperationHealthFacilityEtcRehabilitation==null){

      shortStayRecuperationHealthFacilityEtcRehabilitation = new ACClearableRadioButtonGroup();

      getShortStayRecuperationHealthFacilityEtcRehabilitationContainer().setText("リハビリ機能強化加算");

      shortStayRecuperationHealthFacilityEtcRehabilitation.setBindPath("1220105");

      shortStayRecuperationHealthFacilityEtcRehabilitation.setUseClearButton(false);

      shortStayRecuperationHealthFacilityEtcRehabilitation.setModel(getShortStayRecuperationHealthFacilityEtcRehabilitationModel());

      addShortStayRecuperationHealthFacilityEtcRehabilitation();
    }
    return shortStayRecuperationHealthFacilityEtcRehabilitation;

  }

  /**
   * リハビリ機能強化加算コンテナを取得します。
   * @return リハビリ機能強化加算コンテナ
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityEtcRehabilitationContainer(){
    if(shortStayRecuperationHealthFacilityEtcRehabilitationContainer==null){
      shortStayRecuperationHealthFacilityEtcRehabilitationContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityEtcRehabilitationContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityEtcRehabilitationContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthFacilityEtcRehabilitationContainer.add(getShortStayRecuperationHealthFacilityEtcRehabilitation(), null);
    }
    return shortStayRecuperationHealthFacilityEtcRehabilitationContainer;
  }

  /**
   * リハビリ機能強化加算モデルを取得します。
   * @return リハビリ機能強化加算モデル
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilityEtcRehabilitationModel(){
    if(shortStayRecuperationHealthFacilityEtcRehabilitationModel==null){
      shortStayRecuperationHealthFacilityEtcRehabilitationModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilityEtcRehabilitationModel();
    }
    return shortStayRecuperationHealthFacilityEtcRehabilitationModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityEtcRehabilitationRadioItem2(){
    if(shortStayRecuperationHealthFacilityEtcRehabilitationRadioItem2==null){

      shortStayRecuperationHealthFacilityEtcRehabilitationRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityEtcRehabilitationRadioItem2.setText("なし");

      shortStayRecuperationHealthFacilityEtcRehabilitationRadioItem2.setGroup(getShortStayRecuperationHealthFacilityEtcRehabilitation());

      shortStayRecuperationHealthFacilityEtcRehabilitationRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityEtcRehabilitationRadioItem2();
    }
    return shortStayRecuperationHealthFacilityEtcRehabilitationRadioItem2;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityEtcRehabilitationRadioItem1(){
    if(shortStayRecuperationHealthFacilityEtcRehabilitationRadioItem1==null){

      shortStayRecuperationHealthFacilityEtcRehabilitationRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityEtcRehabilitationRadioItem1.setText("あり");

      shortStayRecuperationHealthFacilityEtcRehabilitationRadioItem1.setGroup(getShortStayRecuperationHealthFacilityEtcRehabilitation());

      shortStayRecuperationHealthFacilityEtcRehabilitationRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityEtcRehabilitationRadioItem1();
    }
    return shortStayRecuperationHealthFacilityEtcRehabilitationRadioItem1;

  }

  /**
   * 認知症ケア加算を取得します。
   * @return 認知症ケア加算
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio(){
    if(shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio==null){

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio = new ACClearableRadioButtonGroup();

      getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioContainer().setText("認知症ケア加算");

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio.setBindPath("1220116");

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio.setUseClearButton(false);

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio.setModel(getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioModel());

      addShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio();
    }
    return shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio;

  }

  /**
   * 認知症ケア加算コンテナを取得します。
   * @return 認知症ケア加算コンテナ
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioContainer(){
    if(shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioContainer==null){
      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioContainer.add(getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio(), null);
    }
    return shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioContainer;
  }

  /**
   * 認知症ケア加算モデルを取得します。
   * @return 認知症ケア加算モデル
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioModel(){
    if(shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioModel==null){
      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioModel();
    }
    return shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1(){
    if(shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1==null){

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1.setText("なし");

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1.setGroup(getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio());

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1();
    }
    return shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2(){
    if(shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2==null){

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2.setText("あり");

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2.setGroup(getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio());

      shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2();
    }
    return shortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2;

  }

  /**
   * 送迎区分を取得します。
   * @return 送迎区分
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthFacilityMeetingAndSendingOff(){
    if(shortStayRecuperationHealthFacilityMeetingAndSendingOff==null){

      shortStayRecuperationHealthFacilityMeetingAndSendingOff = new ACClearableRadioButtonGroup();

      getShortStayRecuperationHealthFacilityMeetingAndSendingOffContainer().setText("送迎加算");

      shortStayRecuperationHealthFacilityMeetingAndSendingOff.setBindPath("6");

      shortStayRecuperationHealthFacilityMeetingAndSendingOff.setUseClearButton(false);

      shortStayRecuperationHealthFacilityMeetingAndSendingOff.setModel(getShortStayRecuperationHealthFacilityMeetingAndSendingOffModel());

      addShortStayRecuperationHealthFacilityMeetingAndSendingOff();
    }
    return shortStayRecuperationHealthFacilityMeetingAndSendingOff;

  }

  /**
   * 送迎区分コンテナを取得します。
   * @return 送迎区分コンテナ
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityMeetingAndSendingOffContainer(){
    if(shortStayRecuperationHealthFacilityMeetingAndSendingOffContainer==null){
      shortStayRecuperationHealthFacilityMeetingAndSendingOffContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityMeetingAndSendingOffContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityMeetingAndSendingOffContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthFacilityMeetingAndSendingOffContainer.add(getShortStayRecuperationHealthFacilityMeetingAndSendingOff(), null);
    }
    return shortStayRecuperationHealthFacilityMeetingAndSendingOffContainer;
  }

  /**
   * 送迎区分モデルを取得します。
   * @return 送迎区分モデル
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilityMeetingAndSendingOffModel(){
    if(shortStayRecuperationHealthFacilityMeetingAndSendingOffModel==null){
      shortStayRecuperationHealthFacilityMeetingAndSendingOffModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilityMeetingAndSendingOffModel();
    }
    return shortStayRecuperationHealthFacilityMeetingAndSendingOffModel;
  }

  /**
   * 送迎なしを取得します。
   * @return 送迎なし
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityMeetingAndSendingOffNone(){
    if(shortStayRecuperationHealthFacilityMeetingAndSendingOffNone==null){

      shortStayRecuperationHealthFacilityMeetingAndSendingOffNone = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityMeetingAndSendingOffNone.setText("送迎なし");

      shortStayRecuperationHealthFacilityMeetingAndSendingOffNone.setGroup(getShortStayRecuperationHealthFacilityMeetingAndSendingOff());

      shortStayRecuperationHealthFacilityMeetingAndSendingOffNone.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityMeetingAndSendingOffNone();
    }
    return shortStayRecuperationHealthFacilityMeetingAndSendingOffNone;

  }

  /**
   * 送迎片道を取得します。
   * @return 送迎片道
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay(){
    if(shortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay==null){

      shortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay.setText("送迎片道");

      shortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay.setGroup(getShortStayRecuperationHealthFacilityMeetingAndSendingOff());

      shortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay();
    }
    return shortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay;

  }

  /**
   * 送迎往復を取得します。
   * @return 送迎往復
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip(){
    if(shortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip==null){

      shortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip.setText("送迎往復");

      shortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip.setGroup(getShortStayRecuperationHealthFacilityMeetingAndSendingOff());

      shortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip();
    }
    return shortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip;

  }

  /**
   * 緊急時治療管理加算を取得します。
   * @return 緊急時治療管理加算
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthFacilityUrgentTimeStepRadio(){
    if(shortStayRecuperationHealthFacilityUrgentTimeStepRadio==null){

      shortStayRecuperationHealthFacilityUrgentTimeStepRadio = new ACClearableRadioButtonGroup();

      getShortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer().setText("緊急時治療管理加算");

      shortStayRecuperationHealthFacilityUrgentTimeStepRadio.setBindPath("1220108");

      shortStayRecuperationHealthFacilityUrgentTimeStepRadio.setUseClearButton(false);

      shortStayRecuperationHealthFacilityUrgentTimeStepRadio.setModel(getShortStayRecuperationHealthFacilityUrgentTimeStepRadioModel());

      addShortStayRecuperationHealthFacilityUrgentTimeStepRadio();
    }
    return shortStayRecuperationHealthFacilityUrgentTimeStepRadio;

  }

  /**
   * 緊急時治療管理加算コンテナを取得します。
   * @return 緊急時治療管理加算コンテナ
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer(){
    if(shortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer==null){
      shortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer.add(getShortStayRecuperationHealthFacilityUrgentTimeStepRadio(), null);
    }
    return shortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer;
  }

  /**
   * 緊急時治療管理加算モデルを取得します。
   * @return 緊急時治療管理加算モデル
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilityUrgentTimeStepRadioModel(){
    if(shortStayRecuperationHealthFacilityUrgentTimeStepRadioModel==null){
      shortStayRecuperationHealthFacilityUrgentTimeStepRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilityUrgentTimeStepRadioModel();
    }
    return shortStayRecuperationHealthFacilityUrgentTimeStepRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1(){
    if(shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1==null){

      shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1.setText("なし");

      shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1.setGroup(getShortStayRecuperationHealthFacilityUrgentTimeStepRadio());

      shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1();
    }
    return shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2(){
    if(shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2==null){

      shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2.setText("あり");

      shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2.setGroup(getShortStayRecuperationHealthFacilityUrgentTimeStepRadio());

      shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2();
    }
    return shortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2;

  }

  /**
   * 栄養管理体制加算を取得します。
   * @return 栄養管理体制加算
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthFacilityDieticianManageRadio(){
    if(shortStayRecuperationHealthFacilityDieticianManageRadio==null){

      shortStayRecuperationHealthFacilityDieticianManageRadio = new ACClearableRadioButtonGroup();

      getShortStayRecuperationHealthFacilityDieticianManageRadioContainer().setText("栄養管理体制加算");

      shortStayRecuperationHealthFacilityDieticianManageRadio.setBindPath("1220109");

      shortStayRecuperationHealthFacilityDieticianManageRadio.setUseClearButton(false);

      shortStayRecuperationHealthFacilityDieticianManageRadio.setModel(getShortStayRecuperationHealthFacilityDieticianManageRadioModel());

      addShortStayRecuperationHealthFacilityDieticianManageRadio();
    }
    return shortStayRecuperationHealthFacilityDieticianManageRadio;

  }

  /**
   * 栄養管理体制加算コンテナを取得します。
   * @return 栄養管理体制加算コンテナ
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityDieticianManageRadioContainer(){
    if(shortStayRecuperationHealthFacilityDieticianManageRadioContainer==null){
      shortStayRecuperationHealthFacilityDieticianManageRadioContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityDieticianManageRadioContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityDieticianManageRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthFacilityDieticianManageRadioContainer.add(getShortStayRecuperationHealthFacilityDieticianManageRadio(), null);
    }
    return shortStayRecuperationHealthFacilityDieticianManageRadioContainer;
  }

  /**
   * 栄養管理体制加算モデルを取得します。
   * @return 栄養管理体制加算モデル
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilityDieticianManageRadioModel(){
    if(shortStayRecuperationHealthFacilityDieticianManageRadioModel==null){
      shortStayRecuperationHealthFacilityDieticianManageRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilityDieticianManageRadioModel();
    }
    return shortStayRecuperationHealthFacilityDieticianManageRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityDieticianManageRadioItem1(){
    if(shortStayRecuperationHealthFacilityDieticianManageRadioItem1==null){

      shortStayRecuperationHealthFacilityDieticianManageRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityDieticianManageRadioItem1.setText("なし");

      shortStayRecuperationHealthFacilityDieticianManageRadioItem1.setGroup(getShortStayRecuperationHealthFacilityDieticianManageRadio());

      shortStayRecuperationHealthFacilityDieticianManageRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityDieticianManageRadioItem1();
    }
    return shortStayRecuperationHealthFacilityDieticianManageRadioItem1;

  }

  /**
   * 管理栄養士を取得します。
   * @return 管理栄養士
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityDieticianManageRadioItem2(){
    if(shortStayRecuperationHealthFacilityDieticianManageRadioItem2==null){

      shortStayRecuperationHealthFacilityDieticianManageRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityDieticianManageRadioItem2.setText("管理栄養士");

      shortStayRecuperationHealthFacilityDieticianManageRadioItem2.setGroup(getShortStayRecuperationHealthFacilityDieticianManageRadio());

      shortStayRecuperationHealthFacilityDieticianManageRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayRecuperationHealthFacilityDieticianManageRadioItem2();
    }
    return shortStayRecuperationHealthFacilityDieticianManageRadioItem2;

  }

  /**
   * 栄養士を取得します。
   * @return 栄養士
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityDieticianManageRadioItem3(){
    if(shortStayRecuperationHealthFacilityDieticianManageRadioItem3==null){

      shortStayRecuperationHealthFacilityDieticianManageRadioItem3 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityDieticianManageRadioItem3.setText("栄養士");

      shortStayRecuperationHealthFacilityDieticianManageRadioItem3.setGroup(getShortStayRecuperationHealthFacilityDieticianManageRadio());

      shortStayRecuperationHealthFacilityDieticianManageRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityDieticianManageRadioItem3();
    }
    return shortStayRecuperationHealthFacilityDieticianManageRadioItem3;

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
   * 療養食加算を取得します。
   * @return 療養食加算
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio(){
    if(shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio==null){

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio = new ACClearableRadioButtonGroup();

      getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer().setText("療養食加算");

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio.setBindPath("1220110");

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio.setUseClearButton(false);

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio.setModel(getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel());

      addShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio();
    }
    return shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio;

  }

  /**
   * 療養食加算コンテナを取得します。
   * @return 療養食加算コンテナ
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer(){
    if(shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer==null){
      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer.add(getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio(), null);
    }
    return shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer;
  }

  /**
   * 療養食加算モデルを取得します。
   * @return 療養食加算モデル
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel(){
    if(shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel==null){
      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel();
    }
    return shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1(){
    if(shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1==null){

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1.setText("なし");

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1.setGroup(getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio());

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1();
    }
    return shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2(){
    if(shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2==null){

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2.setText("あり");

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2.setGroup(getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio());

      shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2();
    }
    return shortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2;

  }

  /**
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthFacilityPersonSubtraction(){
    if(shortStayRecuperationHealthFacilityPersonSubtraction==null){

      shortStayRecuperationHealthFacilityPersonSubtraction = new ACClearableRadioButtonGroup();

      getShortStayRecuperationHealthFacilityPersonSubtractionContainer().setText("人員減算");

      shortStayRecuperationHealthFacilityPersonSubtraction.setBindPath("1220111");

      shortStayRecuperationHealthFacilityPersonSubtraction.setUseClearButton(false);

      shortStayRecuperationHealthFacilityPersonSubtraction.setModel(getShortStayRecuperationHealthFacilityPersonSubtractionModel());

      addShortStayRecuperationHealthFacilityPersonSubtraction();
    }
    return shortStayRecuperationHealthFacilityPersonSubtraction;

  }

  /**
   * 人員減算コンテナを取得します。
   * @return 人員減算コンテナ
   */
  protected ACLabelContainer getShortStayRecuperationHealthFacilityPersonSubtractionContainer(){
    if(shortStayRecuperationHealthFacilityPersonSubtractionContainer==null){
      shortStayRecuperationHealthFacilityPersonSubtractionContainer = new ACLabelContainer();
      shortStayRecuperationHealthFacilityPersonSubtractionContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthFacilityPersonSubtractionContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthFacilityPersonSubtractionContainer.add(getShortStayRecuperationHealthFacilityPersonSubtraction(), null);
    }
    return shortStayRecuperationHealthFacilityPersonSubtractionContainer;
  }

  /**
   * 人員減算モデルを取得します。
   * @return 人員減算モデル
   */
  protected ACListModelAdapter getShortStayRecuperationHealthFacilityPersonSubtractionModel(){
    if(shortStayRecuperationHealthFacilityPersonSubtractionModel==null){
      shortStayRecuperationHealthFacilityPersonSubtractionModel = new ACListModelAdapter();
      addShortStayRecuperationHealthFacilityPersonSubtractionModel();
    }
    return shortStayRecuperationHealthFacilityPersonSubtractionModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityPersonSubtractionNot(){
    if(shortStayRecuperationHealthFacilityPersonSubtractionNot==null){

      shortStayRecuperationHealthFacilityPersonSubtractionNot = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityPersonSubtractionNot.setText("なし");

      shortStayRecuperationHealthFacilityPersonSubtractionNot.setGroup(getShortStayRecuperationHealthFacilityPersonSubtraction());

      shortStayRecuperationHealthFacilityPersonSubtractionNot.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityPersonSubtractionNot();
    }
    return shortStayRecuperationHealthFacilityPersonSubtractionNot;

  }

  /**
   * 定員超過を取得します。
   * @return 定員超過
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityPersonSubtractionExcess(){
    if(shortStayRecuperationHealthFacilityPersonSubtractionExcess==null){

      shortStayRecuperationHealthFacilityPersonSubtractionExcess = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityPersonSubtractionExcess.setText("定員超過");

      shortStayRecuperationHealthFacilityPersonSubtractionExcess.setGroup(getShortStayRecuperationHealthFacilityPersonSubtraction());

      shortStayRecuperationHealthFacilityPersonSubtractionExcess.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayRecuperationHealthFacilityPersonSubtractionExcess();
    }
    return shortStayRecuperationHealthFacilityPersonSubtractionExcess;

  }

  /**
   * 看護・介護職員又は医師、PT・OTの不足を取得します。
   * @return 看護・介護職員又は医師、PT・OTの不足
   */
  public ACRadioButtonItem getShortStayRecuperationHealthFacilityPersonSubtractionStaffLack(){
    if(shortStayRecuperationHealthFacilityPersonSubtractionStaffLack==null){

      shortStayRecuperationHealthFacilityPersonSubtractionStaffLack = new ACRadioButtonItem();

      shortStayRecuperationHealthFacilityPersonSubtractionStaffLack.setText("<html>看護・介護職員又は医師、<br>PT・OTの不足</html>");

      shortStayRecuperationHealthFacilityPersonSubtractionStaffLack.setGroup(getShortStayRecuperationHealthFacilityPersonSubtraction());

      shortStayRecuperationHealthFacilityPersonSubtractionStaffLack.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthFacilityPersonSubtractionStaffLack();
    }
    return shortStayRecuperationHealthFacilityPersonSubtractionStaffLack;

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

      shortStayRecuperationHealthFacilityDinnerOffer.setBindPath("1220112");

      shortStayRecuperationHealthFacilityDinnerOffer.setEditable(false);

      shortStayRecuperationHealthFacilityDinnerOffer.setModelBindPath("1220112");

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

      shortStayRecuperationHealthFacilityDinnerCost.setBindPath("1220115");

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
  public ACIntegerCheckBox getShortStayRecuperationHealthFacilityEtc30Over(){
    if(shortStayRecuperationHealthFacilityEtc30Over==null){

      shortStayRecuperationHealthFacilityEtc30Over = new ACIntegerCheckBox();

      shortStayRecuperationHealthFacilityEtc30Over.setText("30日超");

      shortStayRecuperationHealthFacilityEtc30Over.setBindPath("5");

      shortStayRecuperationHealthFacilityEtc30Over.setSelectValue(2);

      shortStayRecuperationHealthFacilityEtc30Over.setUnSelectValue(1);

      addShortStayRecuperationHealthFacilityEtc30Over();
    }
    return shortStayRecuperationHealthFacilityEtc30Over;

  }

  /**
   * ユニットケアの整備を取得します。
   * @return ユニットケアの整備
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthUnitCareAddRadio(){
    if(shortStayRecuperationHealthUnitCareAddRadio==null){

      shortStayRecuperationHealthUnitCareAddRadio = new ACClearableRadioButtonGroup();

      getShortStayRecuperationHealthUnitCareAddRadioContainer().setText("ユニットケアの整備");

      shortStayRecuperationHealthUnitCareAddRadio.setBindPath("1220117");

      shortStayRecuperationHealthUnitCareAddRadio.setUseClearButton(false);

      shortStayRecuperationHealthUnitCareAddRadio.setModel(getShortStayRecuperationHealthUnitCareAddRadioModel());

      addShortStayRecuperationHealthUnitCareAddRadio();
    }
    return shortStayRecuperationHealthUnitCareAddRadio;

  }

  /**
   * ユニットケアの整備コンテナを取得します。
   * @return ユニットケアの整備コンテナ
   */
  protected ACLabelContainer getShortStayRecuperationHealthUnitCareAddRadioContainer(){
    if(shortStayRecuperationHealthUnitCareAddRadioContainer==null){
      shortStayRecuperationHealthUnitCareAddRadioContainer = new ACLabelContainer();
      shortStayRecuperationHealthUnitCareAddRadioContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthUnitCareAddRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthUnitCareAddRadioContainer.add(getShortStayRecuperationHealthUnitCareAddRadio(), null);
    }
    return shortStayRecuperationHealthUnitCareAddRadioContainer;
  }

  /**
   * ユニットケアの整備モデルを取得します。
   * @return ユニットケアの整備モデル
   */
  protected ACListModelAdapter getShortStayRecuperationHealthUnitCareAddRadioModel(){
    if(shortStayRecuperationHealthUnitCareAddRadioModel==null){
      shortStayRecuperationHealthUnitCareAddRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthUnitCareAddRadioModel();
    }
    return shortStayRecuperationHealthUnitCareAddRadioModel;
  }

  /**
   * 未整備を取得します。
   * @return 未整備
   */
  public ACRadioButtonItem getShortStayRecuperationHealthUnitCareAddRadioItem1(){
    if(shortStayRecuperationHealthUnitCareAddRadioItem1==null){

      shortStayRecuperationHealthUnitCareAddRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthUnitCareAddRadioItem1.setText("未整備");

      shortStayRecuperationHealthUnitCareAddRadioItem1.setGroup(getShortStayRecuperationHealthUnitCareAddRadio());

      shortStayRecuperationHealthUnitCareAddRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthUnitCareAddRadioItem1();
    }
    return shortStayRecuperationHealthUnitCareAddRadioItem1;

  }

  /**
   * 整備を取得します。
   * @return 整備
   */
  public ACRadioButtonItem getShortStayRecuperationHealthUnitCareAddRadioItem2(){
    if(shortStayRecuperationHealthUnitCareAddRadioItem2==null){

      shortStayRecuperationHealthUnitCareAddRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthUnitCareAddRadioItem2.setText("整備");

      shortStayRecuperationHealthUnitCareAddRadioItem2.setGroup(getShortStayRecuperationHealthUnitCareAddRadio());

      shortStayRecuperationHealthUnitCareAddRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthUnitCareAddRadioItem2();
    }
    return shortStayRecuperationHealthUnitCareAddRadioItem2;

  }

  /**
   * 緊急短期入所ネットワーク加算を取得します。
   * @return 緊急短期入所ネットワーク加算
   */
  public ACClearableRadioButtonGroup getShortStayRecuperationHealthEmergencyNetworkAddRadio(){
    if(shortStayRecuperationHealthEmergencyNetworkAddRadio==null){

      shortStayRecuperationHealthEmergencyNetworkAddRadio = new ACClearableRadioButtonGroup();

      getShortStayRecuperationHealthEmergencyNetworkAddRadioContainer().setText("緊急短期入所ネットワーク加算");

      shortStayRecuperationHealthEmergencyNetworkAddRadio.setBindPath("1220118");

      shortStayRecuperationHealthEmergencyNetworkAddRadio.setUseClearButton(false);

      shortStayRecuperationHealthEmergencyNetworkAddRadio.setModel(getShortStayRecuperationHealthEmergencyNetworkAddRadioModel());

      addShortStayRecuperationHealthEmergencyNetworkAddRadio();
    }
    return shortStayRecuperationHealthEmergencyNetworkAddRadio;

  }

  /**
   * 緊急短期入所ネットワーク加算コンテナを取得します。
   * @return 緊急短期入所ネットワーク加算コンテナ
   */
  protected ACLabelContainer getShortStayRecuperationHealthEmergencyNetworkAddRadioContainer(){
    if(shortStayRecuperationHealthEmergencyNetworkAddRadioContainer==null){
      shortStayRecuperationHealthEmergencyNetworkAddRadioContainer = new ACLabelContainer();
      shortStayRecuperationHealthEmergencyNetworkAddRadioContainer.setFollowChildEnabled(true);
      shortStayRecuperationHealthEmergencyNetworkAddRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayRecuperationHealthEmergencyNetworkAddRadioContainer.add(getShortStayRecuperationHealthEmergencyNetworkAddRadio(), null);
    }
    return shortStayRecuperationHealthEmergencyNetworkAddRadioContainer;
  }

  /**
   * 緊急短期入所ネットワーク加算モデルを取得します。
   * @return 緊急短期入所ネットワーク加算モデル
   */
  protected ACListModelAdapter getShortStayRecuperationHealthEmergencyNetworkAddRadioModel(){
    if(shortStayRecuperationHealthEmergencyNetworkAddRadioModel==null){
      shortStayRecuperationHealthEmergencyNetworkAddRadioModel = new ACListModelAdapter();
      addShortStayRecuperationHealthEmergencyNetworkAddRadioModel();
    }
    return shortStayRecuperationHealthEmergencyNetworkAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayRecuperationHealthEmergencyNetworkAddRadioItem1(){
    if(shortStayRecuperationHealthEmergencyNetworkAddRadioItem1==null){

      shortStayRecuperationHealthEmergencyNetworkAddRadioItem1 = new ACRadioButtonItem();

      shortStayRecuperationHealthEmergencyNetworkAddRadioItem1.setText("なし");

      shortStayRecuperationHealthEmergencyNetworkAddRadioItem1.setGroup(getShortStayRecuperationHealthEmergencyNetworkAddRadio());

      shortStayRecuperationHealthEmergencyNetworkAddRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthEmergencyNetworkAddRadioItem1();
    }
    return shortStayRecuperationHealthEmergencyNetworkAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayRecuperationHealthEmergencyNetworkAddRadioItem2(){
    if(shortStayRecuperationHealthEmergencyNetworkAddRadioItem2==null){

      shortStayRecuperationHealthEmergencyNetworkAddRadioItem2 = new ACRadioButtonItem();

      shortStayRecuperationHealthEmergencyNetworkAddRadioItem2.setText("あり");

      shortStayRecuperationHealthEmergencyNetworkAddRadioItem2.setGroup(getShortStayRecuperationHealthEmergencyNetworkAddRadio());

      shortStayRecuperationHealthEmergencyNetworkAddRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayRecuperationHealthEmergencyNetworkAddRadioItem2();
    }
    return shortStayRecuperationHealthEmergencyNetworkAddRadioItem2;

  }

  /**
   * コンストラクタです。
   */
  public QS001110Design() {

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

    tab1.add(getShortStayRecuperationHealthFacilityInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayRecuperationHealthFacilityHospitalRoomDivisionContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayRecuperationHealthFacilitySickroomDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayRecuperationHealthNightWorkConditionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayRecuperationHealthFacilityEtcRehabilitationContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayRecuperationHealthFacilityMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayRecuperationHealthFacilityUrgentTimeStepRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayRecuperationHealthFacilityDieticianManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 施設等の区分に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityInstitutionDivisionRadio(){

  }

  /**
   * 施設等の区分モデルに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityInstitutionDivisionRadioModel(){

    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1().setButtonIndex(1);
    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioModel().add(getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1());

    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2().setButtonIndex(2);
    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioModel().add(getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2());

    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3().setButtonIndex(3);
    getShortStayRecuperationHealthFacilityInstitutionDivisionRadioModel().add(getShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3());

  }

  /**
   * 介護老人保健施設に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem1(){

  }

  /**
   * ユニット型介護老人保健施設に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem2(){

  }

  /**
   * 日帰りショートステイに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityInstitutionDivisionRadioItem3(){

  }

  /**
   * 病室区分コンテナに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityHospitalRoomDivisionContena(){

    shortStayRecuperationHealthFacilityHospitalRoomDivisionContena.add(getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayRecuperationHealthFacilityHospitalRoomDivisionContena.add(getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 病室区分（介護老人保健施設）に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio(){

  }

  /**
   * 病室区分（介護老人保健施設）モデルに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel(){

    getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1().setButtonIndex(1);
    getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel().add(getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1());

    getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2().setButtonIndex(2);
    getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioModel().add(getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2());

  }

  /**
   * 従来型個室に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem1(){

  }

  /**
   * 多床室に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityHospitalRoomDivisionRadioItem2(){

  }

  /**
   * 病室区分（ユニット型介護老人保健施設）に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio(){

  }

  /**
   * 病室区分（ユニット型介護老人保健施設）モデルに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel(){

    getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1().setButtonIndex(1);
    getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel().add(getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1());

    getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2().setButtonIndex(2);
    getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioModel().add(getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2());

  }

  /**
   * ユニット型個室に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem1(){

  }

  /**
   * ユニット型準個室に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadioItem2(){

  }

  /**
   * 病室区分ラジオに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilitySickroomDivisionRadio(){

  }

  /**
   * 病室区分ラジオモデルに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilitySickroomDivisionRadioModel(){

    getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem1().setButtonIndex(1);
    getShortStayRecuperationHealthFacilitySickroomDivisionRadioModel().add(getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem1());

    getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem2().setButtonIndex(2);
    getShortStayRecuperationHealthFacilitySickroomDivisionRadioModel().add(getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem2());

    getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem3().setButtonIndex(3);
    getShortStayRecuperationHealthFacilitySickroomDivisionRadioModel().add(getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem3());

    getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem4().setButtonIndex(4);
    getShortStayRecuperationHealthFacilitySickroomDivisionRadioModel().add(getShortStayRecuperationHealthFacilitySickroomDivisionRadioItem4());

  }

  /**
   * 従来型個室に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilitySickroomDivisionRadioItem1(){

  }

  /**
   * 多床室に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilitySickroomDivisionRadioItem2(){

  }

  /**
   * ユニット型個室に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilitySickroomDivisionRadioItem3(){

  }

  /**
   * ユニット型準個室に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilitySickroomDivisionRadioItem4(){

  }

  /**
   * 夜間勤務条件基準に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthNightWorkConditionRadio(){

  }

  /**
   * 夜間勤務条件基準モデルに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthNightWorkConditionRadioModel(){

    getShortStayRecuperationHealthNightWorkConditionRadioItem1().setButtonIndex(1);
    getShortStayRecuperationHealthNightWorkConditionRadioModel().add(getShortStayRecuperationHealthNightWorkConditionRadioItem1());

    getShortStayRecuperationHealthNightWorkConditionRadioItem2().setButtonIndex(2);
    getShortStayRecuperationHealthNightWorkConditionRadioModel().add(getShortStayRecuperationHealthNightWorkConditionRadioItem2());

  }

  /**
   * 基準型に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthNightWorkConditionRadioItem1(){

  }

  /**
   * 減算型に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthNightWorkConditionRadioItem2(){

  }

  /**
   * リハビリ機能強化加算に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityEtcRehabilitation(){

  }

  /**
   * リハビリ機能強化加算モデルに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityEtcRehabilitationModel(){

    getShortStayRecuperationHealthFacilityEtcRehabilitationRadioItem2().setButtonIndex(1);
    getShortStayRecuperationHealthFacilityEtcRehabilitationModel().add(getShortStayRecuperationHealthFacilityEtcRehabilitationRadioItem2());

    getShortStayRecuperationHealthFacilityEtcRehabilitationRadioItem1().setButtonIndex(2);
    getShortStayRecuperationHealthFacilityEtcRehabilitationModel().add(getShortStayRecuperationHealthFacilityEtcRehabilitationRadioItem1());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityEtcRehabilitationRadioItem2(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityEtcRehabilitationRadioItem1(){

  }

  /**
   * 認知症ケア加算に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio(){

  }

  /**
   * 認知症ケア加算モデルに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioModel(){

    getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1().setButtonIndex(1);
    getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioModel().add(getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1());

    getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2().setButtonIndex(2);
    getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioModel().add(getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadioItem2(){

  }

  /**
   * 送迎区分に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityMeetingAndSendingOff(){

  }

  /**
   * 送迎区分モデルに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityMeetingAndSendingOffModel(){

    getShortStayRecuperationHealthFacilityMeetingAndSendingOffNone().setButtonIndex(1);
    getShortStayRecuperationHealthFacilityMeetingAndSendingOffModel().add(getShortStayRecuperationHealthFacilityMeetingAndSendingOffNone());

    getShortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay().setButtonIndex(2);
    getShortStayRecuperationHealthFacilityMeetingAndSendingOffModel().add(getShortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay());

    getShortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip().setButtonIndex(3);
    getShortStayRecuperationHealthFacilityMeetingAndSendingOffModel().add(getShortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip());

  }

  /**
   * 送迎なしに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityMeetingAndSendingOffNone(){

  }

  /**
   * 送迎片道に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityMeetingAndSendingOffOneWay(){

  }

  /**
   * 送迎往復に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityMeetingAndSendingOffRoundTrip(){

  }

  /**
   * 緊急時治療管理加算に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityUrgentTimeStepRadio(){

  }

  /**
   * 緊急時治療管理加算モデルに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityUrgentTimeStepRadioModel(){

    getShortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1().setButtonIndex(1);
    getShortStayRecuperationHealthFacilityUrgentTimeStepRadioModel().add(getShortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1());

    getShortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2().setButtonIndex(2);
    getShortStayRecuperationHealthFacilityUrgentTimeStepRadioModel().add(getShortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityUrgentTimeStepRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityUrgentTimeStepRadioItem2(){

  }

  /**
   * 栄養管理体制加算に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityDieticianManageRadio(){

  }

  /**
   * 栄養管理体制加算モデルに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityDieticianManageRadioModel(){

    getShortStayRecuperationHealthFacilityDieticianManageRadioItem1().setButtonIndex(1);
    getShortStayRecuperationHealthFacilityDieticianManageRadioModel().add(getShortStayRecuperationHealthFacilityDieticianManageRadioItem1());

    getShortStayRecuperationHealthFacilityDieticianManageRadioItem2().setButtonIndex(2);
    getShortStayRecuperationHealthFacilityDieticianManageRadioModel().add(getShortStayRecuperationHealthFacilityDieticianManageRadioItem2());

    getShortStayRecuperationHealthFacilityDieticianManageRadioItem3().setButtonIndex(3);
    getShortStayRecuperationHealthFacilityDieticianManageRadioModel().add(getShortStayRecuperationHealthFacilityDieticianManageRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityDieticianManageRadioItem1(){

  }

  /**
   * 管理栄養士に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityDieticianManageRadioItem2(){

  }

  /**
   * 栄養士に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityDieticianManageRadioItem3(){

  }

  /**
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayRecuperationHealthFacilityPersonSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayRecuperationHealthFacilityDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tab2.add(getShortStayRecuperationHealthFacilityEtc30Over(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayRecuperationHealthUnitCareAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayRecuperationHealthEmergencyNetworkAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 療養食加算に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio(){

  }

  /**
   * 療養食加算モデルに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel(){

    getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1().setButtonIndex(1);
    getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel().add(getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1());

    getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2().setButtonIndex(2);
    getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioModel().add(getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadioItem2(){

  }

  /**
   * 人員減算に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityPersonSubtraction(){

  }

  /**
   * 人員減算モデルに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityPersonSubtractionModel(){

    getShortStayRecuperationHealthFacilityPersonSubtractionNot().setButtonIndex(1);
    getShortStayRecuperationHealthFacilityPersonSubtractionModel().add(getShortStayRecuperationHealthFacilityPersonSubtractionNot());

    getShortStayRecuperationHealthFacilityPersonSubtractionExcess().setButtonIndex(2);
    getShortStayRecuperationHealthFacilityPersonSubtractionModel().add(getShortStayRecuperationHealthFacilityPersonSubtractionExcess());

    getShortStayRecuperationHealthFacilityPersonSubtractionStaffLack().setButtonIndex(3);
    getShortStayRecuperationHealthFacilityPersonSubtractionModel().add(getShortStayRecuperationHealthFacilityPersonSubtractionStaffLack());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityPersonSubtractionNot(){

  }

  /**
   * 定員超過に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityPersonSubtractionExcess(){

  }

  /**
   * 看護・介護職員又は医師、PT・OTの不足に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthFacilityPersonSubtractionStaffLack(){

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
  protected void addShortStayRecuperationHealthFacilityEtc30Over(){

  }

  /**
   * ユニットケアの整備に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthUnitCareAddRadio(){

  }

  /**
   * ユニットケアの整備モデルに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthUnitCareAddRadioModel(){

    getShortStayRecuperationHealthUnitCareAddRadioItem1().setButtonIndex(1);
    getShortStayRecuperationHealthUnitCareAddRadioModel().add(getShortStayRecuperationHealthUnitCareAddRadioItem1());

    getShortStayRecuperationHealthUnitCareAddRadioItem2().setButtonIndex(2);
    getShortStayRecuperationHealthUnitCareAddRadioModel().add(getShortStayRecuperationHealthUnitCareAddRadioItem2());

  }

  /**
   * 未整備に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthUnitCareAddRadioItem1(){

  }

  /**
   * 整備に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthUnitCareAddRadioItem2(){

  }

  /**
   * 緊急短期入所ネットワーク加算に内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthEmergencyNetworkAddRadio(){

  }

  /**
   * 緊急短期入所ネットワーク加算モデルに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthEmergencyNetworkAddRadioModel(){

    getShortStayRecuperationHealthEmergencyNetworkAddRadioItem1().setButtonIndex(1);
    getShortStayRecuperationHealthEmergencyNetworkAddRadioModel().add(getShortStayRecuperationHealthEmergencyNetworkAddRadioItem1());

    getShortStayRecuperationHealthEmergencyNetworkAddRadioItem2().setButtonIndex(2);
    getShortStayRecuperationHealthEmergencyNetworkAddRadioModel().add(getShortStayRecuperationHealthEmergencyNetworkAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthEmergencyNetworkAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayRecuperationHealthEmergencyNetworkAddRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001110Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001110Design getThis() {
    return this;
  }
}
