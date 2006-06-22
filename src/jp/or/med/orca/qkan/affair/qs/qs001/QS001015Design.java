
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
 * 開発者: 小笠　貴志
 * 作成日: 2006/02/14  日本コンピューター株式会社 小笠　貴志 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン短期入所療養介護（痴呆療養） (QS001015)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Color;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import jp.nichicom.ac.component.ACClearableRadioButtonGroup;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACIntegerCheckBox;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACMapBindButton;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.container.ACBackLabelContainer;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * サービスパターン短期入所療養介護（痴呆療養）画面項目デザイン(QS001015) 
 */
public class QS001015Design extends QS001ServicePanel {
  //GUIコンポーネント

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACClearableRadioButtonGroup shortStayDementiaRecuperationInstitutionDivisionRadio;

  private ACLabelContainer shortStayDementiaRecuperationInstitutionDivisionRadioContainer;

  private ACListModelAdapter shortStayDementiaRecuperationInstitutionDivisionRadioModel;

  private ACRadioButtonItem shortStayDementiaRecuperationInstitutionDivisionRadioItem1;

  private ACRadioButtonItem shortStayDementiaRecuperationInstitutionDivisionRadioItem2;

  private ACClearableRadioButtonGroup shortStayDementiaRecuperationDivision;

  private ACLabelContainer shortStayDementiaRecuperationDivisionContainer;

  private ACListModelAdapter shortStayDementiaRecuperationDivisionModel;

  private ACRadioButtonItem shortStayDementiaRecuperationType1;

  private ACRadioButtonItem shortStayDementiaRecuperationType2;

  private ACRadioButtonItem shortStayDementiaRecuperationType3;

  private ACLabelContainer shortStayDementiaRecuperationHospitalRoomDivisionContena;

  private ACClearableRadioButtonGroup shortStayDementiaRecuperationHospitalRoomRadio;

  private ACListModelAdapter shortStayDementiaRecuperationHospitalRoomRadioModel;

  private ACRadioButtonItem shortStayDementiaRecuperationHospitalRoomRadioItem1;

  private ACRadioButtonItem shortStayDementiaRecuperationHospitalRoomRadioItem2;

  private ACClearableRadioButtonGroup shortStayDementiaRecuperationUnitHospitalRoomRadio;

  private ACListModelAdapter shortStayDementiaRecuperationUnitHospitalRoomRadioModel;

  private ACRadioButtonItem shortStayDementiaRecuperationUnitHospitalRoomRadioItem1;

  private ACRadioButtonItem shortStayDementiaRecuperationUnitHospitalRoomRadioItem2;

  private ACClearableRadioButtonGroup shortStayDementiaRecuperationMeetingAndSendingOff;

  private ACLabelContainer shortStayDementiaRecuperationMeetingAndSendingOffContainer;

  private ACListModelAdapter shortStayDementiaRecuperationMeetingAndSendingOffModel;

  private ACRadioButtonItem shortStayDementiaRecuperationMeetingAndSendingOffNone;

  private ACRadioButtonItem shortStayDementiaRecuperationMeetingAndSendingOffOneWay;

  private ACRadioButtonItem shortStayDementiaRecuperationMeetingAndSendingOffRoundTrip;

  private ACClearableRadioButtonGroup shortStayDementiaRecuperationDieticianManageRadio;

  private ACLabelContainer shortStayDementiaRecuperationDieticianManageRadioContainer;

  private ACListModelAdapter shortStayDementiaRecuperationDieticianManageRadioModel;

  private ACRadioButtonItem shortStayDementiaRecuperationDieticianManageRadioItem1;

  private ACRadioButtonItem shortStayDementiaRecuperationDieticianManageRadioItem2;

  private ACRadioButtonItem shortStayDementiaRecuperationDieticianManageRadioItem3;

  private ACClearableRadioButtonGroup shortStayDementiaRecuperationMedicalExpensesRadio;

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
   * 施設区分を取得します。
   * @return 施設区分
   */
  public ACClearableRadioButtonGroup getShortStayDementiaRecuperationInstitutionDivisionRadio(){
    if(shortStayDementiaRecuperationInstitutionDivisionRadio==null){

      shortStayDementiaRecuperationInstitutionDivisionRadio = new ACClearableRadioButtonGroup();

      getShortStayDementiaRecuperationInstitutionDivisionRadioContainer().setText("施設区分");

      shortStayDementiaRecuperationInstitutionDivisionRadio.setBindPath("1230301");

      shortStayDementiaRecuperationInstitutionDivisionRadio.setModel(getShortStayDementiaRecuperationInstitutionDivisionRadioModel());

      shortStayDementiaRecuperationInstitutionDivisionRadio.setUseClearButton(false);

      addShortStayDementiaRecuperationInstitutionDivisionRadio();
    }
    return shortStayDementiaRecuperationInstitutionDivisionRadio;

  }

  /**
   * 施設区分コンテナを取得します。
   * @return 施設区分コンテナ
   */
  protected ACLabelContainer getShortStayDementiaRecuperationInstitutionDivisionRadioContainer(){
    if(shortStayDementiaRecuperationInstitutionDivisionRadioContainer==null){
      shortStayDementiaRecuperationInstitutionDivisionRadioContainer = new ACLabelContainer();
      shortStayDementiaRecuperationInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayDementiaRecuperationInstitutionDivisionRadioContainer.add(getShortStayDementiaRecuperationInstitutionDivisionRadio(), null);
    }
    return shortStayDementiaRecuperationInstitutionDivisionRadioContainer;
  }

  /**
   * 施設区分モデルを取得します。
   * @return 施設区分モデル
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

      shortStayDementiaRecuperationInstitutionDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationInstitutionDivisionRadioItem2();
    }
    return shortStayDementiaRecuperationInstitutionDivisionRadioItem2;

  }

  /**
   * 人員配置区分を取得します。
   * @return 人員配置区分
   */
  public ACClearableRadioButtonGroup getShortStayDementiaRecuperationDivision(){
    if(shortStayDementiaRecuperationDivision==null){

      shortStayDementiaRecuperationDivision = new ACClearableRadioButtonGroup();

      getShortStayDementiaRecuperationDivisionContainer().setText("人員配置区分");

      shortStayDementiaRecuperationDivision.setBindPath("1230302");

      shortStayDementiaRecuperationDivision.setModel(getShortStayDementiaRecuperationDivisionModel());

      shortStayDementiaRecuperationDivision.setUseClearButton(false);

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

      shortStayDementiaRecuperationType3.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationType3();
    }
    return shortStayDementiaRecuperationType3;

  }

  /**
   * 病室区分コンテナを取得します。
   * @return 病室区分コンテナ
   */
  public ACLabelContainer getShortStayDementiaRecuperationHospitalRoomDivisionContena(){
    if(shortStayDementiaRecuperationHospitalRoomDivisionContena==null){

      shortStayDementiaRecuperationHospitalRoomDivisionContena = new ACLabelContainer();

      shortStayDementiaRecuperationHospitalRoomDivisionContena.setText("病室区分");

      addShortStayDementiaRecuperationHospitalRoomDivisionContena();
    }
    return shortStayDementiaRecuperationHospitalRoomDivisionContena;

  }

  /**
   * 病室区分（介護老人保健施設）を取得します。
   * @return 病室区分（介護老人保健施設）
   */
  public ACClearableRadioButtonGroup getShortStayDementiaRecuperationHospitalRoomRadio(){
    if(shortStayDementiaRecuperationHospitalRoomRadio==null){

      shortStayDementiaRecuperationHospitalRoomRadio = new ACClearableRadioButtonGroup();

      shortStayDementiaRecuperationHospitalRoomRadio.setBindPath("1230303");

      shortStayDementiaRecuperationHospitalRoomRadio.setModel(getShortStayDementiaRecuperationHospitalRoomRadioModel());

      shortStayDementiaRecuperationHospitalRoomRadio.setUseClearButton(false);

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
  public ACClearableRadioButtonGroup getShortStayDementiaRecuperationUnitHospitalRoomRadio(){
    if(shortStayDementiaRecuperationUnitHospitalRoomRadio==null){

      shortStayDementiaRecuperationUnitHospitalRoomRadio = new ACClearableRadioButtonGroup();

      shortStayDementiaRecuperationUnitHospitalRoomRadio.setBindPath("1230304");

      shortStayDementiaRecuperationUnitHospitalRoomRadio.setModel(getShortStayDementiaRecuperationUnitHospitalRoomRadioModel());

      shortStayDementiaRecuperationUnitHospitalRoomRadio.setUseClearButton(false);

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
  public ACClearableRadioButtonGroup getShortStayDementiaRecuperationMeetingAndSendingOff(){
    if(shortStayDementiaRecuperationMeetingAndSendingOff==null){

      shortStayDementiaRecuperationMeetingAndSendingOff = new ACClearableRadioButtonGroup();

      getShortStayDementiaRecuperationMeetingAndSendingOffContainer().setText("送迎加算");

      shortStayDementiaRecuperationMeetingAndSendingOff.setBindPath("6");

      shortStayDementiaRecuperationMeetingAndSendingOff.setModel(getShortStayDementiaRecuperationMeetingAndSendingOffModel());

      shortStayDementiaRecuperationMeetingAndSendingOff.setUseClearButton(false);

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
   * 栄養管理体制加算を取得します。
   * @return 栄養管理体制加算
   */
  public ACClearableRadioButtonGroup getShortStayDementiaRecuperationDieticianManageRadio(){
    if(shortStayDementiaRecuperationDieticianManageRadio==null){

      shortStayDementiaRecuperationDieticianManageRadio = new ACClearableRadioButtonGroup();

      getShortStayDementiaRecuperationDieticianManageRadioContainer().setText("栄養管理体制加算");

      shortStayDementiaRecuperationDieticianManageRadio.setBindPath("1230306");

      shortStayDementiaRecuperationDieticianManageRadio.setModel(getShortStayDementiaRecuperationDieticianManageRadioModel());

      shortStayDementiaRecuperationDieticianManageRadio.setUseClearButton(false);

      addShortStayDementiaRecuperationDieticianManageRadio();
    }
    return shortStayDementiaRecuperationDieticianManageRadio;

  }

  /**
   * 栄養管理体制加算コンテナを取得します。
   * @return 栄養管理体制加算コンテナ
   */
  protected ACLabelContainer getShortStayDementiaRecuperationDieticianManageRadioContainer(){
    if(shortStayDementiaRecuperationDieticianManageRadioContainer==null){
      shortStayDementiaRecuperationDieticianManageRadioContainer = new ACLabelContainer();
      shortStayDementiaRecuperationDieticianManageRadioContainer.setFollowChildEnabled(true);
      shortStayDementiaRecuperationDieticianManageRadioContainer.add(getShortStayDementiaRecuperationDieticianManageRadio(), null);
    }
    return shortStayDementiaRecuperationDieticianManageRadioContainer;
  }

  /**
   * 栄養管理体制加算モデルを取得します。
   * @return 栄養管理体制加算モデル
   */
  protected ACListModelAdapter getShortStayDementiaRecuperationDieticianManageRadioModel(){
    if(shortStayDementiaRecuperationDieticianManageRadioModel==null){
      shortStayDementiaRecuperationDieticianManageRadioModel = new ACListModelAdapter();
      addShortStayDementiaRecuperationDieticianManageRadioModel();
    }
    return shortStayDementiaRecuperationDieticianManageRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationDieticianManageRadioItem1(){
    if(shortStayDementiaRecuperationDieticianManageRadioItem1==null){

      shortStayDementiaRecuperationDieticianManageRadioItem1 = new ACRadioButtonItem();

      shortStayDementiaRecuperationDieticianManageRadioItem1.setText("なし");

      shortStayDementiaRecuperationDieticianManageRadioItem1.setGroup(getShortStayDementiaRecuperationDieticianManageRadio());

      shortStayDementiaRecuperationDieticianManageRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationDieticianManageRadioItem1();
    }
    return shortStayDementiaRecuperationDieticianManageRadioItem1;

  }

  /**
   * 管理栄養士配置加算を取得します。
   * @return 管理栄養士配置加算
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationDieticianManageRadioItem2(){
    if(shortStayDementiaRecuperationDieticianManageRadioItem2==null){

      shortStayDementiaRecuperationDieticianManageRadioItem2 = new ACRadioButtonItem();

      shortStayDementiaRecuperationDieticianManageRadioItem2.setText("管理栄養士配置加算");

      shortStayDementiaRecuperationDieticianManageRadioItem2.setGroup(getShortStayDementiaRecuperationDieticianManageRadio());

      shortStayDementiaRecuperationDieticianManageRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayDementiaRecuperationDieticianManageRadioItem2();
    }
    return shortStayDementiaRecuperationDieticianManageRadioItem2;

  }

  /**
   * 栄養士配置加算を取得します。
   * @return 栄養士配置加算
   */
  public ACRadioButtonItem getShortStayDementiaRecuperationDieticianManageRadioItem3(){
    if(shortStayDementiaRecuperationDieticianManageRadioItem3==null){

      shortStayDementiaRecuperationDieticianManageRadioItem3 = new ACRadioButtonItem();

      shortStayDementiaRecuperationDieticianManageRadioItem3.setText("栄養士配置加算");

      shortStayDementiaRecuperationDieticianManageRadioItem3.setGroup(getShortStayDementiaRecuperationDieticianManageRadio());

      shortStayDementiaRecuperationDieticianManageRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayDementiaRecuperationDieticianManageRadioItem3();
    }
    return shortStayDementiaRecuperationDieticianManageRadioItem3;

  }

  /**
   * 療養食加算を取得します。
   * @return 療養食加算
   */
  public ACClearableRadioButtonGroup getShortStayDementiaRecuperationMedicalExpensesRadio(){
    if(shortStayDementiaRecuperationMedicalExpensesRadio==null){

      shortStayDementiaRecuperationMedicalExpensesRadio = new ACClearableRadioButtonGroup();

      getShortStayDementiaRecuperationMedicalExpensesRadioContainer().setText("療養食加算");

      shortStayDementiaRecuperationMedicalExpensesRadio.setBindPath("1230307");

      shortStayDementiaRecuperationMedicalExpensesRadio.setModel(getShortStayDementiaRecuperationMedicalExpensesRadioModel());

      shortStayDementiaRecuperationMedicalExpensesRadio.setUseClearButton(false);

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

      shortStayDementiaRecuperationPersonSubtraction.setBindPath("1230346");

      shortStayDementiaRecuperationPersonSubtraction.setEditable(false);

      shortStayDementiaRecuperationPersonSubtraction.setModelBindPath("1230346");

      shortStayDementiaRecuperationPersonSubtraction.setModel(getShortStayDementiaRecuperationPersonSubtractionModel());

      shortStayDementiaRecuperationPersonSubtraction.setRenderBindPath("CONTENT");

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

      shortStayDementiaRecuperationDinnerOffer.setBindPath("1230347");

      shortStayDementiaRecuperationDinnerOffer.setEditable(false);

      shortStayDementiaRecuperationDinnerOffer.setModelBindPath("1230347");

      shortStayDementiaRecuperationDinnerOffer.setModel(getShortStayDementiaRecuperationDinnerOfferModel());

      shortStayDementiaRecuperationDinnerOffer.setRenderBindPath("CONTENT");

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

      shortStayDementiaRecuperationDinnerCost.setBindPath("1230350");

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

      addShortStayDementiaRecuperationEtc30Over();
    }
    return shortStayDementiaRecuperationEtc30Over;

  }

  /**
   * コンストラクタです。
   */
  public QS001015Design() {

    try {
      initialize();

      initAffair(null);

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

    this.add(getTabs(), VRLayout.WEST);

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

    tab1.add(getShortStayDementiaRecuperationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayDementiaRecuperationHospitalRoomDivisionContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayDementiaRecuperationMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayDementiaRecuperationDieticianManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayDementiaRecuperationMedicalExpensesRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 施設区分に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationInstitutionDivisionRadio(){

  }

  /**
   * 施設区分モデルに内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationInstitutionDivisionRadioModel(){

    getShortStayDementiaRecuperationInstitutionDivisionRadioItem1().setButtonIndex(1);
    getShortStayDementiaRecuperationInstitutionDivisionRadioModel().add(getShortStayDementiaRecuperationInstitutionDivisionRadioItem1());

    getShortStayDementiaRecuperationInstitutionDivisionRadioItem2().setButtonIndex(2);
    getShortStayDementiaRecuperationInstitutionDivisionRadioModel().add(getShortStayDementiaRecuperationInstitutionDivisionRadioItem2());

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
   * 栄養管理体制加算に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationDieticianManageRadio(){

  }

  /**
   * 栄養管理体制加算モデルに内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationDieticianManageRadioModel(){

    getShortStayDementiaRecuperationDieticianManageRadioItem1().setButtonIndex(1);
    getShortStayDementiaRecuperationDieticianManageRadioModel().add(getShortStayDementiaRecuperationDieticianManageRadioItem1());

    getShortStayDementiaRecuperationDieticianManageRadioItem2().setButtonIndex(2);
    getShortStayDementiaRecuperationDieticianManageRadioModel().add(getShortStayDementiaRecuperationDieticianManageRadioItem2());

    getShortStayDementiaRecuperationDieticianManageRadioItem3().setButtonIndex(3);
    getShortStayDementiaRecuperationDieticianManageRadioModel().add(getShortStayDementiaRecuperationDieticianManageRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationDieticianManageRadioItem1(){

  }

  /**
   * 管理栄養士配置加算に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationDieticianManageRadioItem2(){

  }

  /**
   * 栄養士配置加算に内部項目を追加します。
   */
  protected void addShortStayDementiaRecuperationDieticianManageRadioItem3(){

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
      ACFrame.getInstance().getContentPane().add(new QS001015Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001015Design getThis() {
    return this;
  }
}
