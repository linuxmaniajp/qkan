
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
 * 作成日: 2018/02/20  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン短期入所生活介護 (QS001_12111_201804)
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
 * サービスパターン短期入所生活介護画面項目デザイン(QS001_12111_201804) 
 */
public class QS001_12111_201804Design extends QS001ServicePanel {
  //GUIコンポーネント

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup shortStayLifeTimeContenaFacilityDivision;

  private ACLabelContainer shortStayLifeTimeContenaFacilityDivisionContainer;

  private ACListModelAdapter shortStayLifeTimeContenaFacilityDivisionModel;

  private ACRadioButtonItem shortStayLifeSingle;

  private ACRadioButtonItem shortStayLifeDouble;

  private ACRadioButtonItem shortStayLifeSingleUnit;

  private ACRadioButtonItem shortStayLifeDoubleUnit;

  private ACLabelContainer shortStayLifeHospitalRoomDivisionContena;

  private ACValueArrayRadioButtonGroup shortStayLifeHospitalRoomDivisionRadio;

  private ACListModelAdapter shortStayLifeHospitalRoomDivisionRadioModel;

  private ACRadioButtonItem shortStayLifeHospitalRoomDivisionRadioItem1;

  private ACRadioButtonItem shortStayLifeHospitalRoomDivisionRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayLifeUnitHospitalRoomDivisionRadio;

  private ACListModelAdapter shortStayLifeUnitHospitalRoomDivisionRadioModel;

  private ACRadioButtonItem shortStayLifeUnitHospitalRoomDivisionRadioItem1;

  private ACRadioButtonItem shortStayLifeUnitHospitalRoomDivisionRadioItem2;

  private ACValueArrayRadioButtonGroup nightWorkConditionRadio;

  private ACLabelContainer nightWorkConditionRadioContainer;

  private ACListModelAdapter nightWorkConditionRadioModel;

  private ACRadioButtonItem nightWorkConditionRadioItem1;

  private ACRadioButtonItem nightWorkConditionRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayLifeAdditionFunctionTrainingRadio;

  private ACLabelContainer shortStayLifeAdditionFunctionTrainingRadioContainer;

  private ACListModelAdapter shortStayLifeAdditionFunctionTrainingRadioModel;

  private ACRadioButtonItem shortStayLifeAdditionFunctionTrainingRadioItem2;

  private ACRadioButtonItem shortStayLifeAdditionFunctionTrainingRadioItem1;

  private ACValueArrayRadioButtonGroup shortStayLifeMeetingAndSendingOff;

  private ACLabelContainer shortStayLifeMeetingAndSendingOffContainer;

  private ACListModelAdapter shortStayLifeMeetingAndSendingOffModel;

  private ACRadioButtonItem shortStayLifeMeetingAndSendingOffNone;

  private ACRadioButtonItem shortStayLifeMeetingAndSendingOffOneWay;

  private ACRadioButtonItem shortStayLifeMeetingAndSendingOffRoundTrip;

  private ACValueArrayRadioButtonGroup shortStayLifeMedicalExpensesRadio;

  private ACLabelContainer shortStayLifeMedicalExpensesRadioContainer;

  private ACListModelAdapter shortStayLifeMedicalExpensesRadioModel;

  private ACRadioButtonItem shortStayLifeMedicalExpensesRadioItem1;

  private ACRadioButtonItem shortStayLifeMedicalExpensesRadioItem2;

  private ACRadioButtonItem shortStayLifeMedicalExpensesRadioItem3;

  private ACRadioButtonItem shortStayLifeMedicalExpensesRadioItem4;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup shortStayLifeSubtraction;

  private ACLabelContainer shortStayLifeSubtractionContainer;

  private ACListModelAdapter shortStayLifeSubtractionModel;

  private ACRadioButtonItem shortStayLifeSubtractionNot;

  private ACRadioButtonItem shortStayLifeSubtractionExcess;

  private ACRadioButtonItem shortStayLifeSubtractionLack;

  private ACBackLabelContainer shortStayLifeDinnerContainer;

  private ACComboBox shortStayLifeDinnerOffer;

  private ACLabelContainer shortStayLifeDinnerOfferContainer;

  private ACComboBoxModelAdapter shortStayLifeDinnerOfferModel;

  private ACTextField shortStayLifeDinnerCost;

  private ACLabelContainer shortStayLifeDinnerCostContainer;

  private ACIntegerCheckBox shortStayLifeAddition30Orver;

  private ACValueArrayRadioButtonGroup shortStayLifeUnitCareAddRadio;

  private ACLabelContainer shortStayLifeUnitCareAddRadioContainer;

  private ACListModelAdapter shortStayLifeUnitCareAddRadioModel;

  private ACRadioButtonItem shortStayLifeUnitCareAddRadioItem1;

  private ACRadioButtonItem shortStayLifeUnitCareAddRadioItem2;

  private ACValueArrayRadioButtonGroup dementiaActionAddRadioGroup;

  private ACLabelContainer dementiaActionAddRadioGroupContainer;

  private ACListModelAdapter dementiaActionAddRadioGroupModel;

  private ACRadioButtonItem dementiaActionAddRadioItem1;

  private ACRadioButtonItem dementiaActionAddRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayLifeEmergencyAcceptanceRadioGroup;

  private ACLabelContainer shortStayLifeEmergencyAcceptanceRadioGroupContainer;

  private ACListModelAdapter shortStayLifeEmergencyAcceptanceRadioGroupModel;

  private ACRadioButtonItem shortStayLifeEmergencyAcceptanceRadioItem1;

  private ACRadioButtonItem shortStayLifeEmergencyAcceptanceRadioItem2;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACPanel tab3;

  private ACValueArrayRadioButtonGroup nightStaffDispositionAddRadioGroup;

  private ACLabelContainer nightStaffDispositionAddRadioGroupContainer;

  private ACListModelAdapter nightStaffDispositionAddRadioGroupModel;

  private ACRadioButtonItem nightStaffDispositionAddRadioItem1;

  private ACRadioButtonItem nightStaffDispositionAddRadioItem2;

  private ACRadioButtonItem nightStaffDispositionAddRadioItem3;

  private ACLabelContainer nurseStructuralAddRadioGroup;

  private ACIntegerCheckBox nurseStructuralAddRadioItem1;

  private ACIntegerCheckBox nurseStructuralAddRadioItem2;

  private ACIntegerCheckBox nurseStructuralAddRadioItem3;

  private ACIntegerCheckBox nurseStructuralAddRadioItem4;

  private ACValueArrayRadioButtonGroup stayPeopleCountRadioGroup;

  private ACLabelContainer stayPeopleCountRadioGroupContainer;

  private ACListModelAdapter stayPeopleCountRadioGroupModel;

  private ACRadioButtonItem stayPeopleCountRadioItem1;

  private ACRadioButtonItem stayPeopleCountRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayLifeStayheavyAddRadio;

  private ACLabelContainer shortStayLifeStayheavyAddRadioContainer;

  private ACListModelAdapter shortStayLifeStayheavyAddRadioModel;

  private ACRadioButtonItem shortStayLifeStayheavyAddRadioItem1;

  private ACRadioButtonItem shortStayLifeStayheavyAddRadioItem2;

  private ACValueArrayRadioButtonGroup individualfunctionTrainingSystem;

  private ACLabelContainer individualfunctionTrainingSystemContainer;

  private ACListModelAdapter individualfunctionTrainingSystemModel;

  private ACRadioButtonItem individualfunctionTrainingSystemItem1;

  private ACRadioButtonItem individualfunctionTrainingSystemItem2;

  private ACValueArrayRadioButtonGroup medicalStrengthenCooperation;

  private ACLabelContainer medicalStrengthenCooperationContainer;

  private ACListModelAdapter medicalStrengthenCooperationModel;

  private ACRadioButtonItem medicalStrengthenCooperationItem1;

  private ACRadioButtonItem medicalStrengthenCooperationItem2;

  private ACValueArrayRadioButtonGroup longTermUseSubtraction;

  private ACLabelContainer longTermUseSubtractionContainer;

  private ACListModelAdapter longTermUseSubtractionModel;

  private ACRadioButtonItem longTermUseSubtractionItem1;

  private ACRadioButtonItem longTermUseSubtractionItem2;

  private ACPanel tab4;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACValueArrayRadioButtonGroup symbiosisTypeRadio;

  private ACLabelContainer symbiosisTypeRadioContainer;

  private ACListModelAdapter symbiosisTypeRadioModel;

  private ACRadioButtonItem symbiosisTypeRadioItem1;

  private ACRadioButtonItem symbiosisTypeRadioItem2;

  private ACValueArrayRadioButtonGroup deploymentLifeCounselor;

  private ACLabelContainer deploymentLifeCounselorContainer;

  private ACListModelAdapter deploymentLifeCounselorModel;

  private ACRadioButtonItem deploymentLifeCounselorItem1;

  private ACRadioButtonItem deploymentLifeCounselorItem2;

  private ACValueArrayRadioButtonGroup improvementCollaboration;

  private ACLabelContainer improvementCollaborationContainer;

  private ACListModelAdapter improvementCollaborationModel;

  private ACRadioButtonItem improvementCollaborationItem1;

  private ACRadioButtonItem improvementCollaborationItem2;

  private ACValueArrayRadioButtonGroup dementiaProfessionalCareAddRadioGroup;

  private ACLabelContainer dementiaProfessionalCareAddRadioGroupContainer;

  private ACListModelAdapter dementiaProfessionalCareAddRadioGroupModel;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem1;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem2;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem3;

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
  public ACValueArrayRadioButtonGroup getShortStayLifeTimeContenaFacilityDivision(){
    if(shortStayLifeTimeContenaFacilityDivision==null){

      shortStayLifeTimeContenaFacilityDivision = new ACValueArrayRadioButtonGroup();

      getShortStayLifeTimeContenaFacilityDivisionContainer().setText("施設等の区分");

      shortStayLifeTimeContenaFacilityDivision.setBindPath("1210101");

      shortStayLifeTimeContenaFacilityDivision.setUseClearButton(false);

      shortStayLifeTimeContenaFacilityDivision.setModel(getShortStayLifeTimeContenaFacilityDivisionModel());

      shortStayLifeTimeContenaFacilityDivision.setValues(new int[]{1,2,3,4});

      addShortStayLifeTimeContenaFacilityDivision();
    }
    return shortStayLifeTimeContenaFacilityDivision;

  }

  /**
   * 施設等の区分コンテナを取得します。
   * @return 施設等の区分コンテナ
   */
  protected ACLabelContainer getShortStayLifeTimeContenaFacilityDivisionContainer(){
    if(shortStayLifeTimeContenaFacilityDivisionContainer==null){
      shortStayLifeTimeContenaFacilityDivisionContainer = new ACLabelContainer();
      shortStayLifeTimeContenaFacilityDivisionContainer.setFollowChildEnabled(true);
      shortStayLifeTimeContenaFacilityDivisionContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeTimeContenaFacilityDivisionContainer.add(getShortStayLifeTimeContenaFacilityDivision(), null);
    }
    return shortStayLifeTimeContenaFacilityDivisionContainer;
  }

  /**
   * 施設等の区分モデルを取得します。
   * @return 施設等の区分モデル
   */
  protected ACListModelAdapter getShortStayLifeTimeContenaFacilityDivisionModel(){
    if(shortStayLifeTimeContenaFacilityDivisionModel==null){
      shortStayLifeTimeContenaFacilityDivisionModel = new ACListModelAdapter();
      addShortStayLifeTimeContenaFacilityDivisionModel();
    }
    return shortStayLifeTimeContenaFacilityDivisionModel;
  }

  /**
   * 単独型を取得します。
   * @return 単独型
   */
  public ACRadioButtonItem getShortStayLifeSingle(){
    if(shortStayLifeSingle==null){

      shortStayLifeSingle = new ACRadioButtonItem();

      shortStayLifeSingle.setText("単独型");

      shortStayLifeSingle.setGroup(getShortStayLifeTimeContenaFacilityDivision());

      shortStayLifeSingle.setConstraints(VRLayout.FLOW);

      addShortStayLifeSingle();
    }
    return shortStayLifeSingle;

  }

  /**
   * 併設型を取得します。
   * @return 併設型
   */
  public ACRadioButtonItem getShortStayLifeDouble(){
    if(shortStayLifeDouble==null){

      shortStayLifeDouble = new ACRadioButtonItem();

      shortStayLifeDouble.setText("併設型");

      shortStayLifeDouble.setGroup(getShortStayLifeTimeContenaFacilityDivision());

      shortStayLifeDouble.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayLifeDouble();
    }
    return shortStayLifeDouble;

  }

  /**
   * 単独型ユニット型を取得します。
   * @return 単独型ユニット型
   */
  public ACRadioButtonItem getShortStayLifeSingleUnit(){
    if(shortStayLifeSingleUnit==null){

      shortStayLifeSingleUnit = new ACRadioButtonItem();

      shortStayLifeSingleUnit.setText("単独型ユニット型");

      shortStayLifeSingleUnit.setGroup(getShortStayLifeTimeContenaFacilityDivision());

      shortStayLifeSingleUnit.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayLifeSingleUnit();
    }
    return shortStayLifeSingleUnit;

  }

  /**
   * 併設型ユニット型を取得します。
   * @return 併設型ユニット型
   */
  public ACRadioButtonItem getShortStayLifeDoubleUnit(){
    if(shortStayLifeDoubleUnit==null){

      shortStayLifeDoubleUnit = new ACRadioButtonItem();

      shortStayLifeDoubleUnit.setText("併設型ユニット型");

      shortStayLifeDoubleUnit.setGroup(getShortStayLifeTimeContenaFacilityDivision());

      shortStayLifeDoubleUnit.setConstraints(VRLayout.FLOW);

      addShortStayLifeDoubleUnit();
    }
    return shortStayLifeDoubleUnit;

  }

  /**
   * 病室区分コンテナを取得します。
   * @return 病室区分コンテナ
   */
  public ACLabelContainer getShortStayLifeHospitalRoomDivisionContena(){
    if(shortStayLifeHospitalRoomDivisionContena==null){

      shortStayLifeHospitalRoomDivisionContena = new ACLabelContainer();

      shortStayLifeHospitalRoomDivisionContena.setText("病室区分");

      shortStayLifeHospitalRoomDivisionContena.setFollowChildEnabled(true);

      addShortStayLifeHospitalRoomDivisionContena();
    }
    return shortStayLifeHospitalRoomDivisionContena;

  }

  /**
   * 病室区分（通常）を取得します。
   * @return 病室区分（通常）
   */
  public ACValueArrayRadioButtonGroup getShortStayLifeHospitalRoomDivisionRadio(){
    if(shortStayLifeHospitalRoomDivisionRadio==null){

      shortStayLifeHospitalRoomDivisionRadio = new ACValueArrayRadioButtonGroup();

      shortStayLifeHospitalRoomDivisionRadio.setBindPath("1210103");

      shortStayLifeHospitalRoomDivisionRadio.setUseClearButton(false);

      shortStayLifeHospitalRoomDivisionRadio.setModel(getShortStayLifeHospitalRoomDivisionRadioModel());

      shortStayLifeHospitalRoomDivisionRadio.setValues(new int[]{1,2});

      addShortStayLifeHospitalRoomDivisionRadio();
    }
    return shortStayLifeHospitalRoomDivisionRadio;

  }

  /**
   * 病室区分（通常）モデルを取得します。
   * @return 病室区分（通常）モデル
   */
  protected ACListModelAdapter getShortStayLifeHospitalRoomDivisionRadioModel(){
    if(shortStayLifeHospitalRoomDivisionRadioModel==null){
      shortStayLifeHospitalRoomDivisionRadioModel = new ACListModelAdapter();
      addShortStayLifeHospitalRoomDivisionRadioModel();
    }
    return shortStayLifeHospitalRoomDivisionRadioModel;
  }

  /**
   * 従来型個室を取得します。
   * @return 従来型個室
   */
  public ACRadioButtonItem getShortStayLifeHospitalRoomDivisionRadioItem1(){
    if(shortStayLifeHospitalRoomDivisionRadioItem1==null){

      shortStayLifeHospitalRoomDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayLifeHospitalRoomDivisionRadioItem1.setText("従来型個室");

      shortStayLifeHospitalRoomDivisionRadioItem1.setGroup(getShortStayLifeHospitalRoomDivisionRadio());

      shortStayLifeHospitalRoomDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayLifeHospitalRoomDivisionRadioItem1();
    }
    return shortStayLifeHospitalRoomDivisionRadioItem1;

  }

  /**
   * 多床室を取得します。
   * @return 多床室
   */
  public ACRadioButtonItem getShortStayLifeHospitalRoomDivisionRadioItem2(){
    if(shortStayLifeHospitalRoomDivisionRadioItem2==null){

      shortStayLifeHospitalRoomDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayLifeHospitalRoomDivisionRadioItem2.setText("多床室");

      shortStayLifeHospitalRoomDivisionRadioItem2.setGroup(getShortStayLifeHospitalRoomDivisionRadio());

      shortStayLifeHospitalRoomDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayLifeHospitalRoomDivisionRadioItem2();
    }
    return shortStayLifeHospitalRoomDivisionRadioItem2;

  }

  /**
   * 病室区分（ユニット）を取得します。
   * @return 病室区分（ユニット）
   */
  public ACValueArrayRadioButtonGroup getShortStayLifeUnitHospitalRoomDivisionRadio(){
    if(shortStayLifeUnitHospitalRoomDivisionRadio==null){

      shortStayLifeUnitHospitalRoomDivisionRadio = new ACValueArrayRadioButtonGroup();

      shortStayLifeUnitHospitalRoomDivisionRadio.setBindPath("1210104");

      shortStayLifeUnitHospitalRoomDivisionRadio.setUseClearButton(false);

      shortStayLifeUnitHospitalRoomDivisionRadio.setModel(getShortStayLifeUnitHospitalRoomDivisionRadioModel());

      shortStayLifeUnitHospitalRoomDivisionRadio.setValues(new int[]{1,2});

      addShortStayLifeUnitHospitalRoomDivisionRadio();
    }
    return shortStayLifeUnitHospitalRoomDivisionRadio;

  }

  /**
   * 病室区分（ユニット）モデルを取得します。
   * @return 病室区分（ユニット）モデル
   */
  protected ACListModelAdapter getShortStayLifeUnitHospitalRoomDivisionRadioModel(){
    if(shortStayLifeUnitHospitalRoomDivisionRadioModel==null){
      shortStayLifeUnitHospitalRoomDivisionRadioModel = new ACListModelAdapter();
      addShortStayLifeUnitHospitalRoomDivisionRadioModel();
    }
    return shortStayLifeUnitHospitalRoomDivisionRadioModel;
  }

  /**
   * ユニット型個室を取得します。
   * @return ユニット型個室
   */
  public ACRadioButtonItem getShortStayLifeUnitHospitalRoomDivisionRadioItem1(){
    if(shortStayLifeUnitHospitalRoomDivisionRadioItem1==null){

      shortStayLifeUnitHospitalRoomDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayLifeUnitHospitalRoomDivisionRadioItem1.setText("ユニット型個室");

      shortStayLifeUnitHospitalRoomDivisionRadioItem1.setGroup(getShortStayLifeUnitHospitalRoomDivisionRadio());

      shortStayLifeUnitHospitalRoomDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayLifeUnitHospitalRoomDivisionRadioItem1();
    }
    return shortStayLifeUnitHospitalRoomDivisionRadioItem1;

  }

  /**
   * ユニット型個室的多床室を取得します。
   * @return ユニット型個室的多床室
   */
  public ACRadioButtonItem getShortStayLifeUnitHospitalRoomDivisionRadioItem2(){
    if(shortStayLifeUnitHospitalRoomDivisionRadioItem2==null){

      shortStayLifeUnitHospitalRoomDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayLifeUnitHospitalRoomDivisionRadioItem2.setText("ユニット型個室的多床室");

      shortStayLifeUnitHospitalRoomDivisionRadioItem2.setGroup(getShortStayLifeUnitHospitalRoomDivisionRadio());

      shortStayLifeUnitHospitalRoomDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayLifeUnitHospitalRoomDivisionRadioItem2();
    }
    return shortStayLifeUnitHospitalRoomDivisionRadioItem2;

  }

  /**
   * 夜間勤務条件基準を取得します。
   * @return 夜間勤務条件基準
   */
  public ACValueArrayRadioButtonGroup getNightWorkConditionRadio(){
    if(nightWorkConditionRadio==null){

      nightWorkConditionRadio = new ACValueArrayRadioButtonGroup();

      getNightWorkConditionRadioContainer().setText("夜間勤務条件基準");

      nightWorkConditionRadio.setBindPath("1210105");

      nightWorkConditionRadio.setUseClearButton(false);

      nightWorkConditionRadio.setModel(getNightWorkConditionRadioModel());

      nightWorkConditionRadio.setValues(new int[]{1,2});

      addNightWorkConditionRadio();
    }
    return nightWorkConditionRadio;

  }

  /**
   * 夜間勤務条件基準コンテナを取得します。
   * @return 夜間勤務条件基準コンテナ
   */
  protected ACLabelContainer getNightWorkConditionRadioContainer(){
    if(nightWorkConditionRadioContainer==null){
      nightWorkConditionRadioContainer = new ACLabelContainer();
      nightWorkConditionRadioContainer.setFollowChildEnabled(true);
      nightWorkConditionRadioContainer.setVAlignment(VRLayout.CENTER);
      nightWorkConditionRadioContainer.add(getNightWorkConditionRadio(), null);
    }
    return nightWorkConditionRadioContainer;
  }

  /**
   * 夜間勤務条件基準モデルを取得します。
   * @return 夜間勤務条件基準モデル
   */
  protected ACListModelAdapter getNightWorkConditionRadioModel(){
    if(nightWorkConditionRadioModel==null){
      nightWorkConditionRadioModel = new ACListModelAdapter();
      addNightWorkConditionRadioModel();
    }
    return nightWorkConditionRadioModel;
  }

  /**
   * 基準型を取得します。
   * @return 基準型
   */
  public ACRadioButtonItem getNightWorkConditionRadioItem1(){
    if(nightWorkConditionRadioItem1==null){

      nightWorkConditionRadioItem1 = new ACRadioButtonItem();

      nightWorkConditionRadioItem1.setText("基準型");

      nightWorkConditionRadioItem1.setGroup(getNightWorkConditionRadio());

      nightWorkConditionRadioItem1.setConstraints(VRLayout.FLOW);

      addNightWorkConditionRadioItem1();
    }
    return nightWorkConditionRadioItem1;

  }

  /**
   * 減算型を取得します。
   * @return 減算型
   */
  public ACRadioButtonItem getNightWorkConditionRadioItem2(){
    if(nightWorkConditionRadioItem2==null){

      nightWorkConditionRadioItem2 = new ACRadioButtonItem();

      nightWorkConditionRadioItem2.setText("減算型");

      nightWorkConditionRadioItem2.setGroup(getNightWorkConditionRadio());

      nightWorkConditionRadioItem2.setConstraints(VRLayout.FLOW);

      addNightWorkConditionRadioItem2();
    }
    return nightWorkConditionRadioItem2;

  }

  /**
   * 機能訓練指導体制加算を取得します。
   * @return 機能訓練指導体制加算
   */
  public ACValueArrayRadioButtonGroup getShortStayLifeAdditionFunctionTrainingRadio(){
    if(shortStayLifeAdditionFunctionTrainingRadio==null){

      shortStayLifeAdditionFunctionTrainingRadio = new ACValueArrayRadioButtonGroup();

      getShortStayLifeAdditionFunctionTrainingRadioContainer().setText("機能訓練指導加算");

      shortStayLifeAdditionFunctionTrainingRadio.setBindPath("1210106");

      shortStayLifeAdditionFunctionTrainingRadio.setUseClearButton(false);

      shortStayLifeAdditionFunctionTrainingRadio.setModel(getShortStayLifeAdditionFunctionTrainingRadioModel());

      shortStayLifeAdditionFunctionTrainingRadio.setValues(new int[]{1,2});

      addShortStayLifeAdditionFunctionTrainingRadio();
    }
    return shortStayLifeAdditionFunctionTrainingRadio;

  }

  /**
   * 機能訓練指導体制加算コンテナを取得します。
   * @return 機能訓練指導体制加算コンテナ
   */
  protected ACLabelContainer getShortStayLifeAdditionFunctionTrainingRadioContainer(){
    if(shortStayLifeAdditionFunctionTrainingRadioContainer==null){
      shortStayLifeAdditionFunctionTrainingRadioContainer = new ACLabelContainer();
      shortStayLifeAdditionFunctionTrainingRadioContainer.setFollowChildEnabled(true);
      shortStayLifeAdditionFunctionTrainingRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeAdditionFunctionTrainingRadioContainer.add(getShortStayLifeAdditionFunctionTrainingRadio(), null);
    }
    return shortStayLifeAdditionFunctionTrainingRadioContainer;
  }

  /**
   * 機能訓練指導体制加算モデルを取得します。
   * @return 機能訓練指導体制加算モデル
   */
  protected ACListModelAdapter getShortStayLifeAdditionFunctionTrainingRadioModel(){
    if(shortStayLifeAdditionFunctionTrainingRadioModel==null){
      shortStayLifeAdditionFunctionTrainingRadioModel = new ACListModelAdapter();
      addShortStayLifeAdditionFunctionTrainingRadioModel();
    }
    return shortStayLifeAdditionFunctionTrainingRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayLifeAdditionFunctionTrainingRadioItem2(){
    if(shortStayLifeAdditionFunctionTrainingRadioItem2==null){

      shortStayLifeAdditionFunctionTrainingRadioItem2 = new ACRadioButtonItem();

      shortStayLifeAdditionFunctionTrainingRadioItem2.setText("なし");

      shortStayLifeAdditionFunctionTrainingRadioItem2.setGroup(getShortStayLifeAdditionFunctionTrainingRadio());

      shortStayLifeAdditionFunctionTrainingRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayLifeAdditionFunctionTrainingRadioItem2();
    }
    return shortStayLifeAdditionFunctionTrainingRadioItem2;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayLifeAdditionFunctionTrainingRadioItem1(){
    if(shortStayLifeAdditionFunctionTrainingRadioItem1==null){

      shortStayLifeAdditionFunctionTrainingRadioItem1 = new ACRadioButtonItem();

      shortStayLifeAdditionFunctionTrainingRadioItem1.setText("あり");

      shortStayLifeAdditionFunctionTrainingRadioItem1.setGroup(getShortStayLifeAdditionFunctionTrainingRadio());

      shortStayLifeAdditionFunctionTrainingRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayLifeAdditionFunctionTrainingRadioItem1();
    }
    return shortStayLifeAdditionFunctionTrainingRadioItem1;

  }

  /**
   * 送迎区分を取得します。
   * @return 送迎区分
   */
  public ACValueArrayRadioButtonGroup getShortStayLifeMeetingAndSendingOff(){
    if(shortStayLifeMeetingAndSendingOff==null){

      shortStayLifeMeetingAndSendingOff = new ACValueArrayRadioButtonGroup();

      getShortStayLifeMeetingAndSendingOffContainer().setText("送迎加算");

      shortStayLifeMeetingAndSendingOff.setBindPath("6");

      shortStayLifeMeetingAndSendingOff.setUseClearButton(false);

      shortStayLifeMeetingAndSendingOff.setModel(getShortStayLifeMeetingAndSendingOffModel());

      shortStayLifeMeetingAndSendingOff.setValues(new int[]{1,2,3});

      addShortStayLifeMeetingAndSendingOff();
    }
    return shortStayLifeMeetingAndSendingOff;

  }

  /**
   * 送迎区分コンテナを取得します。
   * @return 送迎区分コンテナ
   */
  protected ACLabelContainer getShortStayLifeMeetingAndSendingOffContainer(){
    if(shortStayLifeMeetingAndSendingOffContainer==null){
      shortStayLifeMeetingAndSendingOffContainer = new ACLabelContainer();
      shortStayLifeMeetingAndSendingOffContainer.setFollowChildEnabled(true);
      shortStayLifeMeetingAndSendingOffContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeMeetingAndSendingOffContainer.add(getShortStayLifeMeetingAndSendingOff(), null);
    }
    return shortStayLifeMeetingAndSendingOffContainer;
  }

  /**
   * 送迎区分モデルを取得します。
   * @return 送迎区分モデル
   */
  protected ACListModelAdapter getShortStayLifeMeetingAndSendingOffModel(){
    if(shortStayLifeMeetingAndSendingOffModel==null){
      shortStayLifeMeetingAndSendingOffModel = new ACListModelAdapter();
      addShortStayLifeMeetingAndSendingOffModel();
    }
    return shortStayLifeMeetingAndSendingOffModel;
  }

  /**
   * 送迎なしを取得します。
   * @return 送迎なし
   */
  public ACRadioButtonItem getShortStayLifeMeetingAndSendingOffNone(){
    if(shortStayLifeMeetingAndSendingOffNone==null){

      shortStayLifeMeetingAndSendingOffNone = new ACRadioButtonItem();

      shortStayLifeMeetingAndSendingOffNone.setText("送迎なし");

      shortStayLifeMeetingAndSendingOffNone.setGroup(getShortStayLifeMeetingAndSendingOff());

      shortStayLifeMeetingAndSendingOffNone.setConstraints(VRLayout.FLOW);

      addShortStayLifeMeetingAndSendingOffNone();
    }
    return shortStayLifeMeetingAndSendingOffNone;

  }

  /**
   * 送迎片道を取得します。
   * @return 送迎片道
   */
  public ACRadioButtonItem getShortStayLifeMeetingAndSendingOffOneWay(){
    if(shortStayLifeMeetingAndSendingOffOneWay==null){

      shortStayLifeMeetingAndSendingOffOneWay = new ACRadioButtonItem();

      shortStayLifeMeetingAndSendingOffOneWay.setText("送迎片道");

      shortStayLifeMeetingAndSendingOffOneWay.setGroup(getShortStayLifeMeetingAndSendingOff());

      shortStayLifeMeetingAndSendingOffOneWay.setConstraints(VRLayout.FLOW);

      addShortStayLifeMeetingAndSendingOffOneWay();
    }
    return shortStayLifeMeetingAndSendingOffOneWay;

  }

  /**
   * 送迎往復を取得します。
   * @return 送迎往復
   */
  public ACRadioButtonItem getShortStayLifeMeetingAndSendingOffRoundTrip(){
    if(shortStayLifeMeetingAndSendingOffRoundTrip==null){

      shortStayLifeMeetingAndSendingOffRoundTrip = new ACRadioButtonItem();

      shortStayLifeMeetingAndSendingOffRoundTrip.setText("送迎往復");

      shortStayLifeMeetingAndSendingOffRoundTrip.setGroup(getShortStayLifeMeetingAndSendingOff());

      shortStayLifeMeetingAndSendingOffRoundTrip.setConstraints(VRLayout.FLOW);

      addShortStayLifeMeetingAndSendingOffRoundTrip();
    }
    return shortStayLifeMeetingAndSendingOffRoundTrip;

  }

  /**
   * 療養食加算を取得します。
   * @return 療養食加算
   */
  public ACValueArrayRadioButtonGroup getShortStayLifeMedicalExpensesRadio(){
    if(shortStayLifeMedicalExpensesRadio==null){

      shortStayLifeMedicalExpensesRadio = new ACValueArrayRadioButtonGroup();

      getShortStayLifeMedicalExpensesRadioContainer().setText("療養食加算");

      shortStayLifeMedicalExpensesRadio.setBindPath("1210109");

      shortStayLifeMedicalExpensesRadio.setUseClearButton(false);

      shortStayLifeMedicalExpensesRadio.setModel(getShortStayLifeMedicalExpensesRadioModel());

      shortStayLifeMedicalExpensesRadio.setValues(new int[]{1,2,3,4});

      addShortStayLifeMedicalExpensesRadio();
    }
    return shortStayLifeMedicalExpensesRadio;

  }

  /**
   * 療養食加算コンテナを取得します。
   * @return 療養食加算コンテナ
   */
  protected ACLabelContainer getShortStayLifeMedicalExpensesRadioContainer(){
    if(shortStayLifeMedicalExpensesRadioContainer==null){
      shortStayLifeMedicalExpensesRadioContainer = new ACLabelContainer();
      shortStayLifeMedicalExpensesRadioContainer.setFollowChildEnabled(true);
      shortStayLifeMedicalExpensesRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeMedicalExpensesRadioContainer.add(getShortStayLifeMedicalExpensesRadio(), null);
    }
    return shortStayLifeMedicalExpensesRadioContainer;
  }

  /**
   * 療養食加算モデルを取得します。
   * @return 療養食加算モデル
   */
  protected ACListModelAdapter getShortStayLifeMedicalExpensesRadioModel(){
    if(shortStayLifeMedicalExpensesRadioModel==null){
      shortStayLifeMedicalExpensesRadioModel = new ACListModelAdapter();
      addShortStayLifeMedicalExpensesRadioModel();
    }
    return shortStayLifeMedicalExpensesRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayLifeMedicalExpensesRadioItem1(){
    if(shortStayLifeMedicalExpensesRadioItem1==null){

      shortStayLifeMedicalExpensesRadioItem1 = new ACRadioButtonItem();

      shortStayLifeMedicalExpensesRadioItem1.setText("なし");

      shortStayLifeMedicalExpensesRadioItem1.setGroup(getShortStayLifeMedicalExpensesRadio());

      shortStayLifeMedicalExpensesRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayLifeMedicalExpensesRadioItem1();
    }
    return shortStayLifeMedicalExpensesRadioItem1;

  }

  /**
   * 3回を取得します。
   * @return 3回
   */
  public ACRadioButtonItem getShortStayLifeMedicalExpensesRadioItem2(){
    if(shortStayLifeMedicalExpensesRadioItem2==null){

      shortStayLifeMedicalExpensesRadioItem2 = new ACRadioButtonItem();

      shortStayLifeMedicalExpensesRadioItem2.setText("3回");

      shortStayLifeMedicalExpensesRadioItem2.setGroup(getShortStayLifeMedicalExpensesRadio());

      shortStayLifeMedicalExpensesRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayLifeMedicalExpensesRadioItem2();
    }
    return shortStayLifeMedicalExpensesRadioItem2;

  }

  /**
   * 2回を取得します。
   * @return 2回
   */
  public ACRadioButtonItem getShortStayLifeMedicalExpensesRadioItem3(){
    if(shortStayLifeMedicalExpensesRadioItem3==null){

      shortStayLifeMedicalExpensesRadioItem3 = new ACRadioButtonItem();

      shortStayLifeMedicalExpensesRadioItem3.setText("2回");

      shortStayLifeMedicalExpensesRadioItem3.setGroup(getShortStayLifeMedicalExpensesRadio());

      shortStayLifeMedicalExpensesRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayLifeMedicalExpensesRadioItem3();
    }
    return shortStayLifeMedicalExpensesRadioItem3;

  }

  /**
   * 1回を取得します。
   * @return 1回
   */
  public ACRadioButtonItem getShortStayLifeMedicalExpensesRadioItem4(){
    if(shortStayLifeMedicalExpensesRadioItem4==null){

      shortStayLifeMedicalExpensesRadioItem4 = new ACRadioButtonItem();

      shortStayLifeMedicalExpensesRadioItem4.setText("1回");

      shortStayLifeMedicalExpensesRadioItem4.setGroup(getShortStayLifeMedicalExpensesRadio());

      shortStayLifeMedicalExpensesRadioItem4.setConstraints(VRLayout.FLOW);

      addShortStayLifeMedicalExpensesRadioItem4();
    }
    return shortStayLifeMedicalExpensesRadioItem4;

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
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACValueArrayRadioButtonGroup getShortStayLifeSubtraction(){
    if(shortStayLifeSubtraction==null){

      shortStayLifeSubtraction = new ACValueArrayRadioButtonGroup();

      getShortStayLifeSubtractionContainer().setText("人員減算");

      shortStayLifeSubtraction.setBindPath("1210110");

      shortStayLifeSubtraction.setUseClearButton(false);

      shortStayLifeSubtraction.setModel(getShortStayLifeSubtractionModel());

      shortStayLifeSubtraction.setValues(new int[]{1,2,3});

      addShortStayLifeSubtraction();
    }
    return shortStayLifeSubtraction;

  }

  /**
   * 人員減算コンテナを取得します。
   * @return 人員減算コンテナ
   */
  protected ACLabelContainer getShortStayLifeSubtractionContainer(){
    if(shortStayLifeSubtractionContainer==null){
      shortStayLifeSubtractionContainer = new ACLabelContainer();
      shortStayLifeSubtractionContainer.setFollowChildEnabled(true);
      shortStayLifeSubtractionContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeSubtractionContainer.add(getShortStayLifeSubtraction(), null);
    }
    return shortStayLifeSubtractionContainer;
  }

  /**
   * 人員減算モデルを取得します。
   * @return 人員減算モデル
   */
  protected ACListModelAdapter getShortStayLifeSubtractionModel(){
    if(shortStayLifeSubtractionModel==null){
      shortStayLifeSubtractionModel = new ACListModelAdapter();
      addShortStayLifeSubtractionModel();
    }
    return shortStayLifeSubtractionModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayLifeSubtractionNot(){
    if(shortStayLifeSubtractionNot==null){

      shortStayLifeSubtractionNot = new ACRadioButtonItem();

      shortStayLifeSubtractionNot.setText("なし");

      shortStayLifeSubtractionNot.setGroup(getShortStayLifeSubtraction());

      shortStayLifeSubtractionNot.setConstraints(VRLayout.FLOW);

      addShortStayLifeSubtractionNot();
    }
    return shortStayLifeSubtractionNot;

  }

  /**
   * 定員超過を取得します。
   * @return 定員超過
   */
  public ACRadioButtonItem getShortStayLifeSubtractionExcess(){
    if(shortStayLifeSubtractionExcess==null){

      shortStayLifeSubtractionExcess = new ACRadioButtonItem();

      shortStayLifeSubtractionExcess.setText("定員超過");

      shortStayLifeSubtractionExcess.setGroup(getShortStayLifeSubtraction());

      shortStayLifeSubtractionExcess.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayLifeSubtractionExcess();
    }
    return shortStayLifeSubtractionExcess;

  }

  /**
   * 看護・介護職員の不足を取得します。
   * @return 看護・介護職員の不足
   */
  public ACRadioButtonItem getShortStayLifeSubtractionLack(){
    if(shortStayLifeSubtractionLack==null){

      shortStayLifeSubtractionLack = new ACRadioButtonItem();

      shortStayLifeSubtractionLack.setText("看護・介護職員の不足");

      shortStayLifeSubtractionLack.setGroup(getShortStayLifeSubtraction());

      shortStayLifeSubtractionLack.setConstraints(VRLayout.FLOW);

      addShortStayLifeSubtractionLack();
    }
    return shortStayLifeSubtractionLack;

  }

  /**
   * 食事コンテナを取得します。
   * @return 食事コンテナ
   */
  public ACBackLabelContainer getShortStayLifeDinnerContainer(){
    if(shortStayLifeDinnerContainer==null){

      shortStayLifeDinnerContainer = new ACBackLabelContainer();

      shortStayLifeDinnerContainer.setFollowChildEnabled(true);

      addShortStayLifeDinnerContainer();
    }
    return shortStayLifeDinnerContainer;

  }

  /**
   * 食事提供を取得します。
   * @return 食事提供
   */
  public ACComboBox getShortStayLifeDinnerOffer(){
    if(shortStayLifeDinnerOffer==null){

      shortStayLifeDinnerOffer = new ACComboBox();

      getShortStayLifeDinnerOfferContainer().setText("食事提供");

      shortStayLifeDinnerOffer.setBindPath("1210111");

      shortStayLifeDinnerOffer.setEditable(false);

      shortStayLifeDinnerOffer.setModelBindPath("1210111");

      shortStayLifeDinnerOffer.setRenderBindPath("CONTENT");

      shortStayLifeDinnerOffer.setModel(getShortStayLifeDinnerOfferModel());

      addShortStayLifeDinnerOffer();
    }
    return shortStayLifeDinnerOffer;

  }

  /**
   * 食事提供コンテナを取得します。
   * @return 食事提供コンテナ
   */
  protected ACLabelContainer getShortStayLifeDinnerOfferContainer(){
    if(shortStayLifeDinnerOfferContainer==null){
      shortStayLifeDinnerOfferContainer = new ACLabelContainer();
      shortStayLifeDinnerOfferContainer.setFollowChildEnabled(true);
      shortStayLifeDinnerOfferContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeDinnerOfferContainer.add(getShortStayLifeDinnerOffer(), null);
    }
    return shortStayLifeDinnerOfferContainer;
  }

  /**
   * 食事提供モデルを取得します。
   * @return 食事提供モデル
   */
  protected ACComboBoxModelAdapter getShortStayLifeDinnerOfferModel(){
    if(shortStayLifeDinnerOfferModel==null){
      shortStayLifeDinnerOfferModel = new ACComboBoxModelAdapter();
      addShortStayLifeDinnerOfferModel();
    }
    return shortStayLifeDinnerOfferModel;
  }

  /**
   * 食事費用を取得します。
   * @return 食事費用
   */
  public ACTextField getShortStayLifeDinnerCost(){
    if(shortStayLifeDinnerCost==null){

      shortStayLifeDinnerCost = new ACTextField();

      getShortStayLifeDinnerCostContainer().setText("食事費用");

      shortStayLifeDinnerCost.setBindPath("1210114");

      shortStayLifeDinnerCost.setColumns(4);

      shortStayLifeDinnerCost.setCharType(VRCharType.ONLY_DIGIT);

      shortStayLifeDinnerCost.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayLifeDinnerCost.setIMEMode(InputSubset.LATIN);

      shortStayLifeDinnerCost.setMaxLength(5);

      addShortStayLifeDinnerCost();
    }
    return shortStayLifeDinnerCost;

  }

  /**
   * 食事費用コンテナを取得します。
   * @return 食事費用コンテナ
   */
  protected ACLabelContainer getShortStayLifeDinnerCostContainer(){
    if(shortStayLifeDinnerCostContainer==null){
      shortStayLifeDinnerCostContainer = new ACLabelContainer();
      shortStayLifeDinnerCostContainer.setFollowChildEnabled(true);
      shortStayLifeDinnerCostContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeDinnerCostContainer.add(getShortStayLifeDinnerCost(), null);
    }
    return shortStayLifeDinnerCostContainer;
  }

  /**
   * 30日超を取得します。
   * @return 30日超
   */
  public ACIntegerCheckBox getShortStayLifeAddition30Orver(){
    if(shortStayLifeAddition30Orver==null){

      shortStayLifeAddition30Orver = new ACIntegerCheckBox();

      shortStayLifeAddition30Orver.setText("30日超");

      shortStayLifeAddition30Orver.setBindPath("5");

      shortStayLifeAddition30Orver.setSelectValue(2);

      shortStayLifeAddition30Orver.setUnSelectValue(1);

      addShortStayLifeAddition30Orver();
    }
    return shortStayLifeAddition30Orver;

  }

  /**
   * ユニットケアの整備を取得します。
   * @return ユニットケアの整備
   */
  public ACValueArrayRadioButtonGroup getShortStayLifeUnitCareAddRadio(){
    if(shortStayLifeUnitCareAddRadio==null){

      shortStayLifeUnitCareAddRadio = new ACValueArrayRadioButtonGroup();

      getShortStayLifeUnitCareAddRadioContainer().setText("ユニットケアの整備");

      shortStayLifeUnitCareAddRadio.setBindPath("1210115");

      shortStayLifeUnitCareAddRadio.setUseClearButton(false);

      shortStayLifeUnitCareAddRadio.setModel(getShortStayLifeUnitCareAddRadioModel());

      shortStayLifeUnitCareAddRadio.setValues(new int[]{1,2});

      addShortStayLifeUnitCareAddRadio();
    }
    return shortStayLifeUnitCareAddRadio;

  }

  /**
   * ユニットケアの整備コンテナを取得します。
   * @return ユニットケアの整備コンテナ
   */
  protected ACLabelContainer getShortStayLifeUnitCareAddRadioContainer(){
    if(shortStayLifeUnitCareAddRadioContainer==null){
      shortStayLifeUnitCareAddRadioContainer = new ACLabelContainer();
      shortStayLifeUnitCareAddRadioContainer.setFollowChildEnabled(true);
      shortStayLifeUnitCareAddRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeUnitCareAddRadioContainer.add(getShortStayLifeUnitCareAddRadio(), null);
    }
    return shortStayLifeUnitCareAddRadioContainer;
  }

  /**
   * ユニットケアの整備モデルを取得します。
   * @return ユニットケアの整備モデル
   */
  protected ACListModelAdapter getShortStayLifeUnitCareAddRadioModel(){
    if(shortStayLifeUnitCareAddRadioModel==null){
      shortStayLifeUnitCareAddRadioModel = new ACListModelAdapter();
      addShortStayLifeUnitCareAddRadioModel();
    }
    return shortStayLifeUnitCareAddRadioModel;
  }

  /**
   * 未整備を取得します。
   * @return 未整備
   */
  public ACRadioButtonItem getShortStayLifeUnitCareAddRadioItem1(){
    if(shortStayLifeUnitCareAddRadioItem1==null){

      shortStayLifeUnitCareAddRadioItem1 = new ACRadioButtonItem();

      shortStayLifeUnitCareAddRadioItem1.setText("未整備");

      shortStayLifeUnitCareAddRadioItem1.setGroup(getShortStayLifeUnitCareAddRadio());

      shortStayLifeUnitCareAddRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayLifeUnitCareAddRadioItem1();
    }
    return shortStayLifeUnitCareAddRadioItem1;

  }

  /**
   * 整備を取得します。
   * @return 整備
   */
  public ACRadioButtonItem getShortStayLifeUnitCareAddRadioItem2(){
    if(shortStayLifeUnitCareAddRadioItem2==null){

      shortStayLifeUnitCareAddRadioItem2 = new ACRadioButtonItem();

      shortStayLifeUnitCareAddRadioItem2.setText("整備");

      shortStayLifeUnitCareAddRadioItem2.setGroup(getShortStayLifeUnitCareAddRadio());

      shortStayLifeUnitCareAddRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayLifeUnitCareAddRadioItem2();
    }
    return shortStayLifeUnitCareAddRadioItem2;

  }

  /**
   * 認知症行動・心理症状緊急対応加算を取得します。
   * @return 認知症行動・心理症状緊急対応加算
   */
  public ACValueArrayRadioButtonGroup getDementiaActionAddRadioGroup(){
    if(dementiaActionAddRadioGroup==null){

      dementiaActionAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaActionAddRadioGroupContainer().setText("認知症行動・" + ACConstants.LINE_SEPARATOR + "心理症状緊急対応加算" + ACConstants.LINE_SEPARATOR + "（1月に7日を限度）");

      dementiaActionAddRadioGroup.setBindPath("1210124");

      dementiaActionAddRadioGroup.setNoSelectIndex(0);

      dementiaActionAddRadioGroup.setUseClearButton(false);

      dementiaActionAddRadioGroup.setModel(getDementiaActionAddRadioGroupModel());

      dementiaActionAddRadioGroup.setValues(new int[]{1,2});

      addDementiaActionAddRadioGroup();
    }
    return dementiaActionAddRadioGroup;

  }

  /**
   * 認知症行動・心理症状緊急対応加算コンテナを取得します。
   * @return 認知症行動・心理症状緊急対応加算コンテナ
   */
  protected ACLabelContainer getDementiaActionAddRadioGroupContainer(){
    if(dementiaActionAddRadioGroupContainer==null){
      dementiaActionAddRadioGroupContainer = new ACLabelContainer();
      dementiaActionAddRadioGroupContainer.setFollowChildEnabled(true);
      dementiaActionAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      dementiaActionAddRadioGroupContainer.add(getDementiaActionAddRadioGroup(), null);
    }
    return dementiaActionAddRadioGroupContainer;
  }

  /**
   * 認知症行動・心理症状緊急対応加算モデルを取得します。
   * @return 認知症行動・心理症状緊急対応加算モデル
   */
  protected ACListModelAdapter getDementiaActionAddRadioGroupModel(){
    if(dementiaActionAddRadioGroupModel==null){
      dementiaActionAddRadioGroupModel = new ACListModelAdapter();
      addDementiaActionAddRadioGroupModel();
    }
    return dementiaActionAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getDementiaActionAddRadioItem1(){
    if(dementiaActionAddRadioItem1==null){

      dementiaActionAddRadioItem1 = new ACRadioButtonItem();

      dementiaActionAddRadioItem1.setText("なし");

      dementiaActionAddRadioItem1.setGroup(getDementiaActionAddRadioGroup());

      dementiaActionAddRadioItem1.setConstraints(VRLayout.FLOW);

      addDementiaActionAddRadioItem1();
    }
    return dementiaActionAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getDementiaActionAddRadioItem2(){
    if(dementiaActionAddRadioItem2==null){

      dementiaActionAddRadioItem2 = new ACRadioButtonItem();

      dementiaActionAddRadioItem2.setText("あり");

      dementiaActionAddRadioItem2.setGroup(getDementiaActionAddRadioGroup());

      dementiaActionAddRadioItem2.setConstraints(VRLayout.FLOW);

      addDementiaActionAddRadioItem2();
    }
    return dementiaActionAddRadioItem2;

  }

  /**
   * 緊急短期入所受入加算を取得します。
   * @return 緊急短期入所受入加算
   */
  public ACValueArrayRadioButtonGroup getShortStayLifeEmergencyAcceptanceRadioGroup(){
    if(shortStayLifeEmergencyAcceptanceRadioGroup==null){

      shortStayLifeEmergencyAcceptanceRadioGroup = new ACValueArrayRadioButtonGroup();

      getShortStayLifeEmergencyAcceptanceRadioGroupContainer().setText("緊急短期入所受入加算" + ACConstants.LINE_SEPARATOR + "（1月に7日を限度）");

      shortStayLifeEmergencyAcceptanceRadioGroup.setBindPath("1210126");

      shortStayLifeEmergencyAcceptanceRadioGroup.setUseClearButton(false);

      shortStayLifeEmergencyAcceptanceRadioGroup.setModel(getShortStayLifeEmergencyAcceptanceRadioGroupModel());

      shortStayLifeEmergencyAcceptanceRadioGroup.setValues(new int[]{1,2});

      addShortStayLifeEmergencyAcceptanceRadioGroup();
    }
    return shortStayLifeEmergencyAcceptanceRadioGroup;

  }

  /**
   * 緊急短期入所受入加算コンテナを取得します。
   * @return 緊急短期入所受入加算コンテナ
   */
  protected ACLabelContainer getShortStayLifeEmergencyAcceptanceRadioGroupContainer(){
    if(shortStayLifeEmergencyAcceptanceRadioGroupContainer==null){
      shortStayLifeEmergencyAcceptanceRadioGroupContainer = new ACLabelContainer();
      shortStayLifeEmergencyAcceptanceRadioGroupContainer.setFollowChildEnabled(true);
      shortStayLifeEmergencyAcceptanceRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeEmergencyAcceptanceRadioGroupContainer.add(getShortStayLifeEmergencyAcceptanceRadioGroup(), null);
    }
    return shortStayLifeEmergencyAcceptanceRadioGroupContainer;
  }

  /**
   * 緊急短期入所受入加算モデルを取得します。
   * @return 緊急短期入所受入加算モデル
   */
  protected ACListModelAdapter getShortStayLifeEmergencyAcceptanceRadioGroupModel(){
    if(shortStayLifeEmergencyAcceptanceRadioGroupModel==null){
      shortStayLifeEmergencyAcceptanceRadioGroupModel = new ACListModelAdapter();
      addShortStayLifeEmergencyAcceptanceRadioGroupModel();
    }
    return shortStayLifeEmergencyAcceptanceRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayLifeEmergencyAcceptanceRadioItem1(){
    if(shortStayLifeEmergencyAcceptanceRadioItem1==null){

      shortStayLifeEmergencyAcceptanceRadioItem1 = new ACRadioButtonItem();

      shortStayLifeEmergencyAcceptanceRadioItem1.setText("なし");

      shortStayLifeEmergencyAcceptanceRadioItem1.setGroup(getShortStayLifeEmergencyAcceptanceRadioGroup());

      shortStayLifeEmergencyAcceptanceRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayLifeEmergencyAcceptanceRadioItem1();
    }
    return shortStayLifeEmergencyAcceptanceRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayLifeEmergencyAcceptanceRadioItem2(){
    if(shortStayLifeEmergencyAcceptanceRadioItem2==null){

      shortStayLifeEmergencyAcceptanceRadioItem2 = new ACRadioButtonItem();

      shortStayLifeEmergencyAcceptanceRadioItem2.setText("あり");

      shortStayLifeEmergencyAcceptanceRadioItem2.setGroup(getShortStayLifeEmergencyAcceptanceRadioGroup());

      shortStayLifeEmergencyAcceptanceRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayLifeEmergencyAcceptanceRadioItem2();
    }
    return shortStayLifeEmergencyAcceptanceRadioItem2;

  }

  /**
   * 若年性認知症利用者受入加算を取得します。
   * @return 若年性認知症利用者受入加算
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("若年性認知症利用者受入加算");

      youngDementiaPatinetAddRadioGroup.setBindPath("1210122");

      youngDementiaPatinetAddRadioGroup.setNoSelectIndex(0);

      youngDementiaPatinetAddRadioGroup.setUseClearButton(false);

      youngDementiaPatinetAddRadioGroup.setModel(getYoungDementiaPatinetAddRadioGroupModel());

      youngDementiaPatinetAddRadioGroup.setValues(new int[]{1,2});

      addYoungDementiaPatinetAddRadioGroup();
    }
    return youngDementiaPatinetAddRadioGroup;

  }

  /**
   * 若年性認知症利用者受入加算コンテナを取得します。
   * @return 若年性認知症利用者受入加算コンテナ
   */
  protected ACLabelContainer getYoungDementiaPatinetAddRadioGroupContainer(){
    if(youngDementiaPatinetAddRadioGroupContainer==null){
      youngDementiaPatinetAddRadioGroupContainer = new ACLabelContainer();
      youngDementiaPatinetAddRadioGroupContainer.setFollowChildEnabled(true);
      youngDementiaPatinetAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      youngDementiaPatinetAddRadioGroupContainer.add(getYoungDementiaPatinetAddRadioGroup(), null);
    }
    return youngDementiaPatinetAddRadioGroupContainer;
  }

  /**
   * 若年性認知症利用者受入加算モデルを取得します。
   * @return 若年性認知症利用者受入加算モデル
   */
  protected ACListModelAdapter getYoungDementiaPatinetAddRadioGroupModel(){
    if(youngDementiaPatinetAddRadioGroupModel==null){
      youngDementiaPatinetAddRadioGroupModel = new ACListModelAdapter();
      addYoungDementiaPatinetAddRadioGroupModel();
    }
    return youngDementiaPatinetAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getYoungDementiaPatinetAddRadioItem1(){
    if(youngDementiaPatinetAddRadioItem1==null){

      youngDementiaPatinetAddRadioItem1 = new ACRadioButtonItem();

      youngDementiaPatinetAddRadioItem1.setText("なし");

      youngDementiaPatinetAddRadioItem1.setGroup(getYoungDementiaPatinetAddRadioGroup());

      youngDementiaPatinetAddRadioItem1.setConstraints(VRLayout.FLOW);

      addYoungDementiaPatinetAddRadioItem1();
    }
    return youngDementiaPatinetAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getYoungDementiaPatinetAddRadioItem2(){
    if(youngDementiaPatinetAddRadioItem2==null){

      youngDementiaPatinetAddRadioItem2 = new ACRadioButtonItem();

      youngDementiaPatinetAddRadioItem2.setText("あり");

      youngDementiaPatinetAddRadioItem2.setGroup(getYoungDementiaPatinetAddRadioGroup());

      youngDementiaPatinetAddRadioItem2.setConstraints(VRLayout.FLOW);

      addYoungDementiaPatinetAddRadioItem2();
    }
    return youngDementiaPatinetAddRadioItem2;

  }

  /**
   * タブ3を取得します。
   * @return タブ3
   */
  public ACPanel getTab3(){
    if(tab3==null){

      tab3 = new ACPanel();

      tab3.setFollowChildEnabled(true);

      tab3.setHgap(0);

      addTab3();
    }
    return tab3;

  }

  /**
   * 夜勤職員配置加算を取得します。
   * @return 夜勤職員配置加算
   */
  public ACValueArrayRadioButtonGroup getNightStaffDispositionAddRadioGroup(){
    if(nightStaffDispositionAddRadioGroup==null){

      nightStaffDispositionAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getNightStaffDispositionAddRadioGroupContainer().setText("夜勤職員配置加算");

      nightStaffDispositionAddRadioGroup.setBindPath("1210121");

      nightStaffDispositionAddRadioGroup.setNoSelectIndex(0);

      nightStaffDispositionAddRadioGroup.setUseClearButton(false);

      nightStaffDispositionAddRadioGroup.setModel(getNightStaffDispositionAddRadioGroupModel());

      nightStaffDispositionAddRadioGroup.setValues(new int[]{1,2,3});

      addNightStaffDispositionAddRadioGroup();
    }
    return nightStaffDispositionAddRadioGroup;

  }

  /**
   * 夜勤職員配置加算コンテナを取得します。
   * @return 夜勤職員配置加算コンテナ
   */
  protected ACLabelContainer getNightStaffDispositionAddRadioGroupContainer(){
    if(nightStaffDispositionAddRadioGroupContainer==null){
      nightStaffDispositionAddRadioGroupContainer = new ACLabelContainer();
      nightStaffDispositionAddRadioGroupContainer.setFollowChildEnabled(true);
      nightStaffDispositionAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      nightStaffDispositionAddRadioGroupContainer.add(getNightStaffDispositionAddRadioGroup(), null);
    }
    return nightStaffDispositionAddRadioGroupContainer;
  }

  /**
   * 夜勤職員配置加算モデルを取得します。
   * @return 夜勤職員配置加算モデル
   */
  protected ACListModelAdapter getNightStaffDispositionAddRadioGroupModel(){
    if(nightStaffDispositionAddRadioGroupModel==null){
      nightStaffDispositionAddRadioGroupModel = new ACListModelAdapter();
      addNightStaffDispositionAddRadioGroupModel();
    }
    return nightStaffDispositionAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNightStaffDispositionAddRadioItem1(){
    if(nightStaffDispositionAddRadioItem1==null){

      nightStaffDispositionAddRadioItem1 = new ACRadioButtonItem();

      nightStaffDispositionAddRadioItem1.setText("なし");

      nightStaffDispositionAddRadioItem1.setGroup(getNightStaffDispositionAddRadioGroup());

      nightStaffDispositionAddRadioItem1.setConstraints(VRLayout.FLOW);

      addNightStaffDispositionAddRadioItem1();
    }
    return nightStaffDispositionAddRadioItem1;

  }

  /**
   * I・II型を取得します。
   * @return I・II型
   */
  public ACRadioButtonItem getNightStaffDispositionAddRadioItem2(){
    if(nightStaffDispositionAddRadioItem2==null){

      nightStaffDispositionAddRadioItem2 = new ACRadioButtonItem();

      nightStaffDispositionAddRadioItem2.setText("I・II型");

      nightStaffDispositionAddRadioItem2.setGroup(getNightStaffDispositionAddRadioGroup());

      nightStaffDispositionAddRadioItem2.setConstraints(VRLayout.FLOW);

      addNightStaffDispositionAddRadioItem2();
    }
    return nightStaffDispositionAddRadioItem2;

  }

  /**
   * III・IV型を取得します。
   * @return III・IV型
   */
  public ACRadioButtonItem getNightStaffDispositionAddRadioItem3(){
    if(nightStaffDispositionAddRadioItem3==null){

      nightStaffDispositionAddRadioItem3 = new ACRadioButtonItem();

      nightStaffDispositionAddRadioItem3.setText("III・IV型");

      nightStaffDispositionAddRadioItem3.setGroup(getNightStaffDispositionAddRadioGroup());

      nightStaffDispositionAddRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addNightStaffDispositionAddRadioItem3();
    }
    return nightStaffDispositionAddRadioItem3;

  }

  /**
   * 看護体制加算コンテナを取得します。
   * @return 看護体制加算コンテナ
   */
  public ACLabelContainer getNurseStructuralAddRadioGroup(){
    if(nurseStructuralAddRadioGroup==null){

      nurseStructuralAddRadioGroup = new ACLabelContainer();

      nurseStructuralAddRadioGroup.setText("看護体制加算");

      nurseStructuralAddRadioGroup.setFollowChildEnabled(true);

      nurseStructuralAddRadioGroup.setHgap(0);

      nurseStructuralAddRadioGroup.setLabelMargin(0);

      nurseStructuralAddRadioGroup.setVgap(0);

      addNurseStructuralAddRadioGroup();
    }
    return nurseStructuralAddRadioGroup;

  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACIntegerCheckBox getNurseStructuralAddRadioItem1(){
    if(nurseStructuralAddRadioItem1==null){

      nurseStructuralAddRadioItem1 = new ACIntegerCheckBox();

      nurseStructuralAddRadioItem1.setText("I型");

      nurseStructuralAddRadioItem1.setBindPath("1210119");

      nurseStructuralAddRadioItem1.setSelectValue(2);

      nurseStructuralAddRadioItem1.setUnSelectValue(1);

      addNurseStructuralAddRadioItem1();
    }
    return nurseStructuralAddRadioItem1;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACIntegerCheckBox getNurseStructuralAddRadioItem2(){
    if(nurseStructuralAddRadioItem2==null){

      nurseStructuralAddRadioItem2 = new ACIntegerCheckBox();

      nurseStructuralAddRadioItem2.setText("II型");

      nurseStructuralAddRadioItem2.setBindPath("1210120");

      nurseStructuralAddRadioItem2.setSelectValue(2);

      nurseStructuralAddRadioItem2.setUnSelectValue(1);

      addNurseStructuralAddRadioItem2();
    }
    return nurseStructuralAddRadioItem2;

  }

  /**
   * III型を取得します。
   * @return III型
   */
  public ACIntegerCheckBox getNurseStructuralAddRadioItem3(){
    if(nurseStructuralAddRadioItem3==null){

      nurseStructuralAddRadioItem3 = new ACIntegerCheckBox();

      nurseStructuralAddRadioItem3.setText("III型");

      nurseStructuralAddRadioItem3.setBindPath("1210133");

      nurseStructuralAddRadioItem3.setSelectValue(2);

      nurseStructuralAddRadioItem3.setUnSelectValue(1);

      addNurseStructuralAddRadioItem3();
    }
    return nurseStructuralAddRadioItem3;

  }

  /**
   * IV型を取得します。
   * @return IV型
   */
  public ACIntegerCheckBox getNurseStructuralAddRadioItem4(){
    if(nurseStructuralAddRadioItem4==null){

      nurseStructuralAddRadioItem4 = new ACIntegerCheckBox();

      nurseStructuralAddRadioItem4.setText("IV型");

      nurseStructuralAddRadioItem4.setBindPath("1210134");

      nurseStructuralAddRadioItem4.setSelectValue(2);

      nurseStructuralAddRadioItem4.setUnSelectValue(1);

      addNurseStructuralAddRadioItem4();
    }
    return nurseStructuralAddRadioItem4;

  }

  /**
   * 定員要件を取得します。
   * @return 定員要件
   */
  public ACValueArrayRadioButtonGroup getStayPeopleCountRadioGroup(){
    if(stayPeopleCountRadioGroup==null){

      stayPeopleCountRadioGroup = new ACValueArrayRadioButtonGroup();

      getStayPeopleCountRadioGroupContainer().setText("定員要件");

      stayPeopleCountRadioGroup.setBindPath("1210135");

      stayPeopleCountRadioGroup.setNoSelectIndex(0);

      stayPeopleCountRadioGroup.setUseClearButton(false);

      stayPeopleCountRadioGroup.setModel(getStayPeopleCountRadioGroupModel());

      stayPeopleCountRadioGroup.setValues(new int[]{1,2});

      addStayPeopleCountRadioGroup();
    }
    return stayPeopleCountRadioGroup;

  }

  /**
   * 定員要件コンテナを取得します。
   * @return 定員要件コンテナ
   */
  protected ACLabelContainer getStayPeopleCountRadioGroupContainer(){
    if(stayPeopleCountRadioGroupContainer==null){
      stayPeopleCountRadioGroupContainer = new ACLabelContainer();
      stayPeopleCountRadioGroupContainer.setFollowChildEnabled(true);
      stayPeopleCountRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      stayPeopleCountRadioGroupContainer.add(getStayPeopleCountRadioGroup(), null);
    }
    return stayPeopleCountRadioGroupContainer;
  }

  /**
   * 定員要件モデルを取得します。
   * @return 定員要件モデル
   */
  protected ACListModelAdapter getStayPeopleCountRadioGroupModel(){
    if(stayPeopleCountRadioGroupModel==null){
      stayPeopleCountRadioGroupModel = new ACListModelAdapter();
      addStayPeopleCountRadioGroupModel();
    }
    return stayPeopleCountRadioGroupModel;
  }

  /**
   * 29人以下を取得します。
   * @return 29人以下
   */
  public ACRadioButtonItem getStayPeopleCountRadioItem1(){
    if(stayPeopleCountRadioItem1==null){

      stayPeopleCountRadioItem1 = new ACRadioButtonItem();

      stayPeopleCountRadioItem1.setText("29人以下");

      stayPeopleCountRadioItem1.setGroup(getStayPeopleCountRadioGroup());

      stayPeopleCountRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addStayPeopleCountRadioItem1();
    }
    return stayPeopleCountRadioItem1;

  }

  /**
   * 30人以上50人以下を取得します。
   * @return 30人以上50人以下
   */
  public ACRadioButtonItem getStayPeopleCountRadioItem2(){
    if(stayPeopleCountRadioItem2==null){

      stayPeopleCountRadioItem2 = new ACRadioButtonItem();

      stayPeopleCountRadioItem2.setText("30人以上50人以下");

      stayPeopleCountRadioItem2.setGroup(getStayPeopleCountRadioGroup());

      stayPeopleCountRadioItem2.setConstraints(VRLayout.FLOW);

      addStayPeopleCountRadioItem2();
    }
    return stayPeopleCountRadioItem2;

  }

  /**
   * 在宅中重度加算を取得します。
   * @return 在宅中重度加算
   */
  public ACValueArrayRadioButtonGroup getShortStayLifeStayheavyAddRadio(){
    if(shortStayLifeStayheavyAddRadio==null){

      shortStayLifeStayheavyAddRadio = new ACValueArrayRadioButtonGroup();

      getShortStayLifeStayheavyAddRadioContainer().setText("在宅中重度加算");

      shortStayLifeStayheavyAddRadio.setBindPath("1210118");

      shortStayLifeStayheavyAddRadio.setNoSelectIndex(0);

      shortStayLifeStayheavyAddRadio.setUseClearButton(false);

      shortStayLifeStayheavyAddRadio.setModel(getShortStayLifeStayheavyAddRadioModel());

      shortStayLifeStayheavyAddRadio.setValues(new int[]{1,2});

      addShortStayLifeStayheavyAddRadio();
    }
    return shortStayLifeStayheavyAddRadio;

  }

  /**
   * 在宅中重度加算コンテナを取得します。
   * @return 在宅中重度加算コンテナ
   */
  protected ACLabelContainer getShortStayLifeStayheavyAddRadioContainer(){
    if(shortStayLifeStayheavyAddRadioContainer==null){
      shortStayLifeStayheavyAddRadioContainer = new ACLabelContainer();
      shortStayLifeStayheavyAddRadioContainer.setFollowChildEnabled(true);
      shortStayLifeStayheavyAddRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeStayheavyAddRadioContainer.add(getShortStayLifeStayheavyAddRadio(), null);
    }
    return shortStayLifeStayheavyAddRadioContainer;
  }

  /**
   * 在宅中重度加算モデルを取得します。
   * @return 在宅中重度加算モデル
   */
  protected ACListModelAdapter getShortStayLifeStayheavyAddRadioModel(){
    if(shortStayLifeStayheavyAddRadioModel==null){
      shortStayLifeStayheavyAddRadioModel = new ACListModelAdapter();
      addShortStayLifeStayheavyAddRadioModel();
    }
    return shortStayLifeStayheavyAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayLifeStayheavyAddRadioItem1(){
    if(shortStayLifeStayheavyAddRadioItem1==null){

      shortStayLifeStayheavyAddRadioItem1 = new ACRadioButtonItem();

      shortStayLifeStayheavyAddRadioItem1.setText("なし");

      shortStayLifeStayheavyAddRadioItem1.setGroup(getShortStayLifeStayheavyAddRadio());

      shortStayLifeStayheavyAddRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayLifeStayheavyAddRadioItem1();
    }
    return shortStayLifeStayheavyAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayLifeStayheavyAddRadioItem2(){
    if(shortStayLifeStayheavyAddRadioItem2==null){

      shortStayLifeStayheavyAddRadioItem2 = new ACRadioButtonItem();

      shortStayLifeStayheavyAddRadioItem2.setText("あり");

      shortStayLifeStayheavyAddRadioItem2.setGroup(getShortStayLifeStayheavyAddRadio());

      shortStayLifeStayheavyAddRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayLifeStayheavyAddRadioItem2();
    }
    return shortStayLifeStayheavyAddRadioItem2;

  }

  /**
   * 個別機能訓練加算を取得します。
   * @return 個別機能訓練加算
   */
  public ACValueArrayRadioButtonGroup getIndividualfunctionTrainingSystem(){
    if(individualfunctionTrainingSystem==null){

      individualfunctionTrainingSystem = new ACValueArrayRadioButtonGroup();

      getIndividualfunctionTrainingSystemContainer().setText("個別機能訓練加算");

      individualfunctionTrainingSystem.setBindPath("1210127");

      individualfunctionTrainingSystem.setNoSelectIndex(0);

      individualfunctionTrainingSystem.setUseClearButton(false);

      individualfunctionTrainingSystem.setModel(getIndividualfunctionTrainingSystemModel());

      individualfunctionTrainingSystem.setValues(new int[]{1,2});

      addIndividualfunctionTrainingSystem();
    }
    return individualfunctionTrainingSystem;

  }

  /**
   * 個別機能訓練加算コンテナを取得します。
   * @return 個別機能訓練加算コンテナ
   */
  protected ACLabelContainer getIndividualfunctionTrainingSystemContainer(){
    if(individualfunctionTrainingSystemContainer==null){
      individualfunctionTrainingSystemContainer = new ACLabelContainer();
      individualfunctionTrainingSystemContainer.setFollowChildEnabled(true);
      individualfunctionTrainingSystemContainer.setVAlignment(VRLayout.CENTER);
      individualfunctionTrainingSystemContainer.add(getIndividualfunctionTrainingSystem(), null);
    }
    return individualfunctionTrainingSystemContainer;
  }

  /**
   * 個別機能訓練加算モデルを取得します。
   * @return 個別機能訓練加算モデル
   */
  protected ACListModelAdapter getIndividualfunctionTrainingSystemModel(){
    if(individualfunctionTrainingSystemModel==null){
      individualfunctionTrainingSystemModel = new ACListModelAdapter();
      addIndividualfunctionTrainingSystemModel();
    }
    return individualfunctionTrainingSystemModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getIndividualfunctionTrainingSystemItem1(){
    if(individualfunctionTrainingSystemItem1==null){

      individualfunctionTrainingSystemItem1 = new ACRadioButtonItem();

      individualfunctionTrainingSystemItem1.setText("なし");

      individualfunctionTrainingSystemItem1.setGroup(getIndividualfunctionTrainingSystem());

      individualfunctionTrainingSystemItem1.setConstraints(VRLayout.FLOW);

      addIndividualfunctionTrainingSystemItem1();
    }
    return individualfunctionTrainingSystemItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getIndividualfunctionTrainingSystemItem2(){
    if(individualfunctionTrainingSystemItem2==null){

      individualfunctionTrainingSystemItem2 = new ACRadioButtonItem();

      individualfunctionTrainingSystemItem2.setText("あり");

      individualfunctionTrainingSystemItem2.setGroup(getIndividualfunctionTrainingSystem());

      individualfunctionTrainingSystemItem2.setConstraints(VRLayout.FLOW);

      addIndividualfunctionTrainingSystemItem2();
    }
    return individualfunctionTrainingSystemItem2;

  }

  /**
   * 医療連携強化加算を取得します。
   * @return 医療連携強化加算
   */
  public ACValueArrayRadioButtonGroup getMedicalStrengthenCooperation(){
    if(medicalStrengthenCooperation==null){

      medicalStrengthenCooperation = new ACValueArrayRadioButtonGroup();

      getMedicalStrengthenCooperationContainer().setText("医療連携強化加算");

      medicalStrengthenCooperation.setBindPath("1210128");

      medicalStrengthenCooperation.setNoSelectIndex(0);

      medicalStrengthenCooperation.setUseClearButton(false);

      medicalStrengthenCooperation.setModel(getMedicalStrengthenCooperationModel());

      medicalStrengthenCooperation.setValues(new int[]{1,2});

      addMedicalStrengthenCooperation();
    }
    return medicalStrengthenCooperation;

  }

  /**
   * 医療連携強化加算コンテナを取得します。
   * @return 医療連携強化加算コンテナ
   */
  protected ACLabelContainer getMedicalStrengthenCooperationContainer(){
    if(medicalStrengthenCooperationContainer==null){
      medicalStrengthenCooperationContainer = new ACLabelContainer();
      medicalStrengthenCooperationContainer.setFollowChildEnabled(true);
      medicalStrengthenCooperationContainer.setVAlignment(VRLayout.CENTER);
      medicalStrengthenCooperationContainer.add(getMedicalStrengthenCooperation(), null);
    }
    return medicalStrengthenCooperationContainer;
  }

  /**
   * 医療連携強化加算モデルを取得します。
   * @return 医療連携強化加算モデル
   */
  protected ACListModelAdapter getMedicalStrengthenCooperationModel(){
    if(medicalStrengthenCooperationModel==null){
      medicalStrengthenCooperationModel = new ACListModelAdapter();
      addMedicalStrengthenCooperationModel();
    }
    return medicalStrengthenCooperationModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalStrengthenCooperationItem1(){
    if(medicalStrengthenCooperationItem1==null){

      medicalStrengthenCooperationItem1 = new ACRadioButtonItem();

      medicalStrengthenCooperationItem1.setText("なし");

      medicalStrengthenCooperationItem1.setGroup(getMedicalStrengthenCooperation());

      medicalStrengthenCooperationItem1.setConstraints(VRLayout.FLOW);

      addMedicalStrengthenCooperationItem1();
    }
    return medicalStrengthenCooperationItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalStrengthenCooperationItem2(){
    if(medicalStrengthenCooperationItem2==null){

      medicalStrengthenCooperationItem2 = new ACRadioButtonItem();

      medicalStrengthenCooperationItem2.setText("あり");

      medicalStrengthenCooperationItem2.setGroup(getMedicalStrengthenCooperation());

      medicalStrengthenCooperationItem2.setConstraints(VRLayout.FLOW);

      addMedicalStrengthenCooperationItem2();
    }
    return medicalStrengthenCooperationItem2;

  }

  /**
   * 長期利用者提供減算を取得します。
   * @return 長期利用者提供減算
   */
  public ACValueArrayRadioButtonGroup getLongTermUseSubtraction(){
    if(longTermUseSubtraction==null){

      longTermUseSubtraction = new ACValueArrayRadioButtonGroup();

      getLongTermUseSubtractionContainer().setText("長期利用者提供減算");

      longTermUseSubtraction.setBindPath("1210129");

      longTermUseSubtraction.setNoSelectIndex(0);

      longTermUseSubtraction.setUseClearButton(false);

      longTermUseSubtraction.setModel(getLongTermUseSubtractionModel());

      longTermUseSubtraction.setValues(new int[]{1,2});

      addLongTermUseSubtraction();
    }
    return longTermUseSubtraction;

  }

  /**
   * 長期利用者提供減算コンテナを取得します。
   * @return 長期利用者提供減算コンテナ
   */
  protected ACLabelContainer getLongTermUseSubtractionContainer(){
    if(longTermUseSubtractionContainer==null){
      longTermUseSubtractionContainer = new ACLabelContainer();
      longTermUseSubtractionContainer.setFollowChildEnabled(true);
      longTermUseSubtractionContainer.setVAlignment(VRLayout.CENTER);
      longTermUseSubtractionContainer.add(getLongTermUseSubtraction(), null);
    }
    return longTermUseSubtractionContainer;
  }

  /**
   * 長期利用者提供減算モデルを取得します。
   * @return 長期利用者提供減算モデル
   */
  protected ACListModelAdapter getLongTermUseSubtractionModel(){
    if(longTermUseSubtractionModel==null){
      longTermUseSubtractionModel = new ACListModelAdapter();
      addLongTermUseSubtractionModel();
    }
    return longTermUseSubtractionModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getLongTermUseSubtractionItem1(){
    if(longTermUseSubtractionItem1==null){

      longTermUseSubtractionItem1 = new ACRadioButtonItem();

      longTermUseSubtractionItem1.setText("なし");

      longTermUseSubtractionItem1.setGroup(getLongTermUseSubtraction());

      longTermUseSubtractionItem1.setConstraints(VRLayout.FLOW);

      addLongTermUseSubtractionItem1();
    }
    return longTermUseSubtractionItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getLongTermUseSubtractionItem2(){
    if(longTermUseSubtractionItem2==null){

      longTermUseSubtractionItem2 = new ACRadioButtonItem();

      longTermUseSubtractionItem2.setText("あり");

      longTermUseSubtractionItem2.setGroup(getLongTermUseSubtraction());

      longTermUseSubtractionItem2.setConstraints(VRLayout.FLOW);

      addLongTermUseSubtractionItem2();
    }
    return longTermUseSubtractionItem2;

  }

  /**
   * タブ4を取得します。
   * @return タブ4
   */
  public ACPanel getTab4(){
    if(tab4==null){

      tab4 = new ACPanel();

      tab4.setFollowChildEnabled(true);

      tab4.setHgap(0);

      addTab4();
    }
    return tab4;

  }

  /**
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1210123");

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
   * 共生型を取得します。
   * @return 共生型
   */
  public ACValueArrayRadioButtonGroup getSymbiosisTypeRadio(){
    if(symbiosisTypeRadio==null){

      symbiosisTypeRadio = new ACValueArrayRadioButtonGroup();

      getSymbiosisTypeRadioContainer().setText("共生型");

      symbiosisTypeRadio.setBindPath("22");

      symbiosisTypeRadio.setNoSelectIndex(0);

      symbiosisTypeRadio.setUseClearButton(false);

      symbiosisTypeRadio.setModel(getSymbiosisTypeRadioModel());

      symbiosisTypeRadio.setValues(new int[]{1,9});

      addSymbiosisTypeRadio();
    }
    return symbiosisTypeRadio;

  }

  /**
   * 共生型コンテナを取得します。
   * @return 共生型コンテナ
   */
  protected ACLabelContainer getSymbiosisTypeRadioContainer(){
    if(symbiosisTypeRadioContainer==null){
      symbiosisTypeRadioContainer = new ACLabelContainer();
      symbiosisTypeRadioContainer.setFollowChildEnabled(true);
      symbiosisTypeRadioContainer.setVAlignment(VRLayout.CENTER);
      symbiosisTypeRadioContainer.add(getSymbiosisTypeRadio(), null);
    }
    return symbiosisTypeRadioContainer;
  }

  /**
   * 共生型モデルを取得します。
   * @return 共生型モデル
   */
  protected ACListModelAdapter getSymbiosisTypeRadioModel(){
    if(symbiosisTypeRadioModel==null){
      symbiosisTypeRadioModel = new ACListModelAdapter();
      addSymbiosisTypeRadioModel();
    }
    return symbiosisTypeRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSymbiosisTypeRadioItem1(){
    if(symbiosisTypeRadioItem1==null){

      symbiosisTypeRadioItem1 = new ACRadioButtonItem();

      symbiosisTypeRadioItem1.setText("なし");

      symbiosisTypeRadioItem1.setGroup(getSymbiosisTypeRadio());

      symbiosisTypeRadioItem1.setConstraints(VRLayout.FLOW);

      addSymbiosisTypeRadioItem1();
    }
    return symbiosisTypeRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getSymbiosisTypeRadioItem2(){
    if(symbiosisTypeRadioItem2==null){

      symbiosisTypeRadioItem2 = new ACRadioButtonItem();

      symbiosisTypeRadioItem2.setText("あり");

      symbiosisTypeRadioItem2.setGroup(getSymbiosisTypeRadio());

      symbiosisTypeRadioItem2.setConstraints(VRLayout.FLOW);

      addSymbiosisTypeRadioItem2();
    }
    return symbiosisTypeRadioItem2;

  }

  /**
   * 生活相談員配置等加算を取得します。
   * @return 生活相談員配置等加算
   */
  public ACValueArrayRadioButtonGroup getDeploymentLifeCounselor(){
    if(deploymentLifeCounselor==null){

      deploymentLifeCounselor = new ACValueArrayRadioButtonGroup();

      getDeploymentLifeCounselorContainer().setText("生活相談員配置等加算");

      deploymentLifeCounselor.setBindPath("1210130");

      deploymentLifeCounselor.setUseClearButton(false);

      deploymentLifeCounselor.setModel(getDeploymentLifeCounselorModel());

      deploymentLifeCounselor.setValues(new int[]{1,2});

      addDeploymentLifeCounselor();
    }
    return deploymentLifeCounselor;

  }

  /**
   * 生活相談員配置等加算コンテナを取得します。
   * @return 生活相談員配置等加算コンテナ
   */
  protected ACLabelContainer getDeploymentLifeCounselorContainer(){
    if(deploymentLifeCounselorContainer==null){
      deploymentLifeCounselorContainer = new ACLabelContainer();
      deploymentLifeCounselorContainer.setFollowChildEnabled(true);
      deploymentLifeCounselorContainer.setVAlignment(VRLayout.CENTER);
      deploymentLifeCounselorContainer.add(getDeploymentLifeCounselor(), null);
    }
    return deploymentLifeCounselorContainer;
  }

  /**
   * 生活相談員配置等加算モデルを取得します。
   * @return 生活相談員配置等加算モデル
   */
  protected ACListModelAdapter getDeploymentLifeCounselorModel(){
    if(deploymentLifeCounselorModel==null){
      deploymentLifeCounselorModel = new ACListModelAdapter();
      addDeploymentLifeCounselorModel();
    }
    return deploymentLifeCounselorModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getDeploymentLifeCounselorItem1(){
    if(deploymentLifeCounselorItem1==null){

      deploymentLifeCounselorItem1 = new ACRadioButtonItem();

      deploymentLifeCounselorItem1.setText("なし");

      deploymentLifeCounselorItem1.setGroup(getDeploymentLifeCounselor());

      addDeploymentLifeCounselorItem1();
    }
    return deploymentLifeCounselorItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getDeploymentLifeCounselorItem2(){
    if(deploymentLifeCounselorItem2==null){

      deploymentLifeCounselorItem2 = new ACRadioButtonItem();

      deploymentLifeCounselorItem2.setText("あり");

      deploymentLifeCounselorItem2.setGroup(getDeploymentLifeCounselor());

      addDeploymentLifeCounselorItem2();
    }
    return deploymentLifeCounselorItem2;

  }

  /**
   * 生活機能向上連携加算を取得します。
   * @return 生活機能向上連携加算
   */
  public ACValueArrayRadioButtonGroup getImprovementCollaboration(){
    if(improvementCollaboration==null){

      improvementCollaboration = new ACValueArrayRadioButtonGroup();

      getImprovementCollaborationContainer().setText("生活機能向上連携加算");

      improvementCollaboration.setBindPath("1210131");

      improvementCollaboration.setUseClearButton(false);

      improvementCollaboration.setModel(getImprovementCollaborationModel());

      improvementCollaboration.setValues(new int[]{1,2});

      addImprovementCollaboration();
    }
    return improvementCollaboration;

  }

  /**
   * 生活機能向上連携加算コンテナを取得します。
   * @return 生活機能向上連携加算コンテナ
   */
  protected ACLabelContainer getImprovementCollaborationContainer(){
    if(improvementCollaborationContainer==null){
      improvementCollaborationContainer = new ACLabelContainer();
      improvementCollaborationContainer.setFollowChildEnabled(true);
      improvementCollaborationContainer.setVAlignment(VRLayout.CENTER);
      improvementCollaborationContainer.add(getImprovementCollaboration(), null);
    }
    return improvementCollaborationContainer;
  }

  /**
   * 生活機能向上連携加算モデルを取得します。
   * @return 生活機能向上連携加算モデル
   */
  protected ACListModelAdapter getImprovementCollaborationModel(){
    if(improvementCollaborationModel==null){
      improvementCollaborationModel = new ACListModelAdapter();
      addImprovementCollaborationModel();
    }
    return improvementCollaborationModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getImprovementCollaborationItem1(){
    if(improvementCollaborationItem1==null){

      improvementCollaborationItem1 = new ACRadioButtonItem();

      improvementCollaborationItem1.setText("なし");

      improvementCollaborationItem1.setGroup(getImprovementCollaboration());

      addImprovementCollaborationItem1();
    }
    return improvementCollaborationItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getImprovementCollaborationItem2(){
    if(improvementCollaborationItem2==null){

      improvementCollaborationItem2 = new ACRadioButtonItem();

      improvementCollaborationItem2.setText("あり");

      improvementCollaborationItem2.setGroup(getImprovementCollaboration());

      addImprovementCollaborationItem2();
    }
    return improvementCollaborationItem2;

  }

  /**
   * 認知症専門ケア加算を取得します。
   * @return 認知症専門ケア加算
   */
  public ACValueArrayRadioButtonGroup getDementiaProfessionalCareAddRadioGroup(){
    if(dementiaProfessionalCareAddRadioGroup==null){

      dementiaProfessionalCareAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaProfessionalCareAddRadioGroupContainer().setText("認知症専門ケア加算");

      dementiaProfessionalCareAddRadioGroup.setBindPath("1210132");

      dementiaProfessionalCareAddRadioGroup.setVisible(true);

      dementiaProfessionalCareAddRadioGroup.setEnabled(true);

      dementiaProfessionalCareAddRadioGroup.setNoSelectIndex(0);

      dementiaProfessionalCareAddRadioGroup.setUseClearButton(false);

      dementiaProfessionalCareAddRadioGroup.setModel(getDementiaProfessionalCareAddRadioGroupModel());

      dementiaProfessionalCareAddRadioGroup.setValues(new int[]{1,2,3});

      addDementiaProfessionalCareAddRadioGroup();
    }
    return dementiaProfessionalCareAddRadioGroup;

  }

  /**
   * 認知症専門ケア加算コンテナを取得します。
   * @return 認知症専門ケア加算コンテナ
   */
  protected ACLabelContainer getDementiaProfessionalCareAddRadioGroupContainer(){
    if(dementiaProfessionalCareAddRadioGroupContainer==null){
      dementiaProfessionalCareAddRadioGroupContainer = new ACLabelContainer();
      dementiaProfessionalCareAddRadioGroupContainer.setFollowChildEnabled(true);
      dementiaProfessionalCareAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      dementiaProfessionalCareAddRadioGroupContainer.add(getDementiaProfessionalCareAddRadioGroup(), null);
    }
    return dementiaProfessionalCareAddRadioGroupContainer;
  }

  /**
   * 認知症専門ケア加算モデルを取得します。
   * @return 認知症専門ケア加算モデル
   */
  protected ACListModelAdapter getDementiaProfessionalCareAddRadioGroupModel(){
    if(dementiaProfessionalCareAddRadioGroupModel==null){
      dementiaProfessionalCareAddRadioGroupModel = new ACListModelAdapter();
      addDementiaProfessionalCareAddRadioGroupModel();
    }
    return dementiaProfessionalCareAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getDementiaProfessionalCareAddRadioItem1(){
    if(dementiaProfessionalCareAddRadioItem1==null){

      dementiaProfessionalCareAddRadioItem1 = new ACRadioButtonItem();

      dementiaProfessionalCareAddRadioItem1.setText("なし");

      dementiaProfessionalCareAddRadioItem1.setGroup(getDementiaProfessionalCareAddRadioGroup());

      dementiaProfessionalCareAddRadioItem1.setConstraints(VRLayout.FLOW);

      addDementiaProfessionalCareAddRadioItem1();
    }
    return dementiaProfessionalCareAddRadioItem1;

  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getDementiaProfessionalCareAddRadioItem2(){
    if(dementiaProfessionalCareAddRadioItem2==null){

      dementiaProfessionalCareAddRadioItem2 = new ACRadioButtonItem();

      dementiaProfessionalCareAddRadioItem2.setText("I型");

      dementiaProfessionalCareAddRadioItem2.setGroup(getDementiaProfessionalCareAddRadioGroup());

      dementiaProfessionalCareAddRadioItem2.setConstraints(VRLayout.FLOW);

      addDementiaProfessionalCareAddRadioItem2();
    }
    return dementiaProfessionalCareAddRadioItem2;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getDementiaProfessionalCareAddRadioItem3(){
    if(dementiaProfessionalCareAddRadioItem3==null){

      dementiaProfessionalCareAddRadioItem3 = new ACRadioButtonItem();

      dementiaProfessionalCareAddRadioItem3.setText("II型");

      dementiaProfessionalCareAddRadioItem3.setGroup(getDementiaProfessionalCareAddRadioGroup());

      dementiaProfessionalCareAddRadioItem3.setConstraints(VRLayout.FLOW);

      addDementiaProfessionalCareAddRadioItem3();
    }
    return dementiaProfessionalCareAddRadioItem3;

  }

  /**
   * コンストラクタです。
   */
  public QS001_12111_201804Design() {

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

    tabs.addTab("3", getTab3());

    tabs.addTab("4", getTab4());

  }

  /**
   * タブ1に内部項目を追加します。
   */
  protected void addTab1(){

    tab1.add(getShortStayLifeTimeContenaFacilityDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayLifeHospitalRoomDivisionContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getNightWorkConditionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayLifeAdditionFunctionTrainingRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayLifeMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayLifeMedicalExpensesRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 施設等の区分に内部項目を追加します。
   */
  protected void addShortStayLifeTimeContenaFacilityDivision(){

  }

  /**
   * 施設等の区分モデルに内部項目を追加します。
   */
  protected void addShortStayLifeTimeContenaFacilityDivisionModel(){

    getShortStayLifeSingle().setButtonIndex(1);

    getShortStayLifeTimeContenaFacilityDivisionModel().add(getShortStayLifeSingle());

    getShortStayLifeDouble().setButtonIndex(2);

    getShortStayLifeTimeContenaFacilityDivisionModel().add(getShortStayLifeDouble());

    getShortStayLifeSingleUnit().setButtonIndex(3);

    getShortStayLifeTimeContenaFacilityDivisionModel().add(getShortStayLifeSingleUnit());

    getShortStayLifeDoubleUnit().setButtonIndex(4);

    getShortStayLifeTimeContenaFacilityDivisionModel().add(getShortStayLifeDoubleUnit());

  }

  /**
   * 単独型に内部項目を追加します。
   */
  protected void addShortStayLifeSingle(){

  }

  /**
   * 併設型に内部項目を追加します。
   */
  protected void addShortStayLifeDouble(){

  }

  /**
   * 単独型ユニット型に内部項目を追加します。
   */
  protected void addShortStayLifeSingleUnit(){

  }

  /**
   * 併設型ユニット型に内部項目を追加します。
   */
  protected void addShortStayLifeDoubleUnit(){

  }

  /**
   * 病室区分コンテナに内部項目を追加します。
   */
  protected void addShortStayLifeHospitalRoomDivisionContena(){

    shortStayLifeHospitalRoomDivisionContena.add(getShortStayLifeHospitalRoomDivisionRadio(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayLifeHospitalRoomDivisionContena.add(getShortStayLifeUnitHospitalRoomDivisionRadio(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 病室区分（通常）に内部項目を追加します。
   */
  protected void addShortStayLifeHospitalRoomDivisionRadio(){

  }

  /**
   * 病室区分（通常）モデルに内部項目を追加します。
   */
  protected void addShortStayLifeHospitalRoomDivisionRadioModel(){

    getShortStayLifeHospitalRoomDivisionRadioItem1().setButtonIndex(1);

    getShortStayLifeHospitalRoomDivisionRadioModel().add(getShortStayLifeHospitalRoomDivisionRadioItem1());

    getShortStayLifeHospitalRoomDivisionRadioItem2().setButtonIndex(2);

    getShortStayLifeHospitalRoomDivisionRadioModel().add(getShortStayLifeHospitalRoomDivisionRadioItem2());

  }

  /**
   * 従来型個室に内部項目を追加します。
   */
  protected void addShortStayLifeHospitalRoomDivisionRadioItem1(){

  }

  /**
   * 多床室に内部項目を追加します。
   */
  protected void addShortStayLifeHospitalRoomDivisionRadioItem2(){

  }

  /**
   * 病室区分（ユニット）に内部項目を追加します。
   */
  protected void addShortStayLifeUnitHospitalRoomDivisionRadio(){

  }

  /**
   * 病室区分（ユニット）モデルに内部項目を追加します。
   */
  protected void addShortStayLifeUnitHospitalRoomDivisionRadioModel(){

    getShortStayLifeUnitHospitalRoomDivisionRadioItem1().setButtonIndex(1);

    getShortStayLifeUnitHospitalRoomDivisionRadioModel().add(getShortStayLifeUnitHospitalRoomDivisionRadioItem1());

    getShortStayLifeUnitHospitalRoomDivisionRadioItem2().setButtonIndex(2);

    getShortStayLifeUnitHospitalRoomDivisionRadioModel().add(getShortStayLifeUnitHospitalRoomDivisionRadioItem2());

  }

  /**
   * ユニット型個室に内部項目を追加します。
   */
  protected void addShortStayLifeUnitHospitalRoomDivisionRadioItem1(){

  }

  /**
   * ユニット型個室的多床室に内部項目を追加します。
   */
  protected void addShortStayLifeUnitHospitalRoomDivisionRadioItem2(){

  }

  /**
   * 夜間勤務条件基準に内部項目を追加します。
   */
  protected void addNightWorkConditionRadio(){

  }

  /**
   * 夜間勤務条件基準モデルに内部項目を追加します。
   */
  protected void addNightWorkConditionRadioModel(){

    getNightWorkConditionRadioItem1().setButtonIndex(1);

    getNightWorkConditionRadioModel().add(getNightWorkConditionRadioItem1());

    getNightWorkConditionRadioItem2().setButtonIndex(2);

    getNightWorkConditionRadioModel().add(getNightWorkConditionRadioItem2());

  }

  /**
   * 基準型に内部項目を追加します。
   */
  protected void addNightWorkConditionRadioItem1(){

  }

  /**
   * 減算型に内部項目を追加します。
   */
  protected void addNightWorkConditionRadioItem2(){

  }

  /**
   * 機能訓練指導体制加算に内部項目を追加します。
   */
  protected void addShortStayLifeAdditionFunctionTrainingRadio(){

  }

  /**
   * 機能訓練指導体制加算モデルに内部項目を追加します。
   */
  protected void addShortStayLifeAdditionFunctionTrainingRadioModel(){

    getShortStayLifeAdditionFunctionTrainingRadioItem2().setButtonIndex(1);

    getShortStayLifeAdditionFunctionTrainingRadioModel().add(getShortStayLifeAdditionFunctionTrainingRadioItem2());

    getShortStayLifeAdditionFunctionTrainingRadioItem1().setButtonIndex(2);

    getShortStayLifeAdditionFunctionTrainingRadioModel().add(getShortStayLifeAdditionFunctionTrainingRadioItem1());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayLifeAdditionFunctionTrainingRadioItem2(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayLifeAdditionFunctionTrainingRadioItem1(){

  }

  /**
   * 送迎区分に内部項目を追加します。
   */
  protected void addShortStayLifeMeetingAndSendingOff(){

  }

  /**
   * 送迎区分モデルに内部項目を追加します。
   */
  protected void addShortStayLifeMeetingAndSendingOffModel(){

    getShortStayLifeMeetingAndSendingOffNone().setButtonIndex(1);

    getShortStayLifeMeetingAndSendingOffModel().add(getShortStayLifeMeetingAndSendingOffNone());

    getShortStayLifeMeetingAndSendingOffOneWay().setButtonIndex(2);

    getShortStayLifeMeetingAndSendingOffModel().add(getShortStayLifeMeetingAndSendingOffOneWay());

    getShortStayLifeMeetingAndSendingOffRoundTrip().setButtonIndex(3);

    getShortStayLifeMeetingAndSendingOffModel().add(getShortStayLifeMeetingAndSendingOffRoundTrip());

  }

  /**
   * 送迎なしに内部項目を追加します。
   */
  protected void addShortStayLifeMeetingAndSendingOffNone(){

  }

  /**
   * 送迎片道に内部項目を追加します。
   */
  protected void addShortStayLifeMeetingAndSendingOffOneWay(){

  }

  /**
   * 送迎往復に内部項目を追加します。
   */
  protected void addShortStayLifeMeetingAndSendingOffRoundTrip(){

  }

  /**
   * 療養食加算に内部項目を追加します。
   */
  protected void addShortStayLifeMedicalExpensesRadio(){

  }

  /**
   * 療養食加算モデルに内部項目を追加します。
   */
  protected void addShortStayLifeMedicalExpensesRadioModel(){

    getShortStayLifeMedicalExpensesRadioItem1().setButtonIndex(1);

    getShortStayLifeMedicalExpensesRadioModel().add(getShortStayLifeMedicalExpensesRadioItem1());

    getShortStayLifeMedicalExpensesRadioItem2().setButtonIndex(2);

    getShortStayLifeMedicalExpensesRadioModel().add(getShortStayLifeMedicalExpensesRadioItem2());

    getShortStayLifeMedicalExpensesRadioItem3().setButtonIndex(3);

    getShortStayLifeMedicalExpensesRadioModel().add(getShortStayLifeMedicalExpensesRadioItem3());

    getShortStayLifeMedicalExpensesRadioItem4().setButtonIndex(4);

    getShortStayLifeMedicalExpensesRadioModel().add(getShortStayLifeMedicalExpensesRadioItem4());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayLifeMedicalExpensesRadioItem1(){

  }

  /**
   * 3回に内部項目を追加します。
   */
  protected void addShortStayLifeMedicalExpensesRadioItem2(){

  }

  /**
   * 2回に内部項目を追加します。
   */
  protected void addShortStayLifeMedicalExpensesRadioItem3(){

  }

  /**
   * 1回に内部項目を追加します。
   */
  protected void addShortStayLifeMedicalExpensesRadioItem4(){

  }

  /**
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getShortStayLifeSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayLifeDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tab2.add(getShortStayLifeAddition30Orver(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayLifeUnitCareAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getDementiaActionAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayLifeEmergencyAcceptanceRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 人員減算に内部項目を追加します。
   */
  protected void addShortStayLifeSubtraction(){

  }

  /**
   * 人員減算モデルに内部項目を追加します。
   */
  protected void addShortStayLifeSubtractionModel(){

    getShortStayLifeSubtractionNot().setButtonIndex(1);

    getShortStayLifeSubtractionModel().add(getShortStayLifeSubtractionNot());

    getShortStayLifeSubtractionExcess().setButtonIndex(2);

    getShortStayLifeSubtractionModel().add(getShortStayLifeSubtractionExcess());

    getShortStayLifeSubtractionLack().setButtonIndex(3);

    getShortStayLifeSubtractionModel().add(getShortStayLifeSubtractionLack());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayLifeSubtractionNot(){

  }

  /**
   * 定員超過に内部項目を追加します。
   */
  protected void addShortStayLifeSubtractionExcess(){

  }

  /**
   * 看護・介護職員の不足に内部項目を追加します。
   */
  protected void addShortStayLifeSubtractionLack(){

  }

  /**
   * 食事コンテナに内部項目を追加します。
   */
  protected void addShortStayLifeDinnerContainer(){

    shortStayLifeDinnerContainer.add(getShortStayLifeDinnerOfferContainer(), VRLayout.FLOW);

    shortStayLifeDinnerContainer.add(getShortStayLifeDinnerCostContainer(), VRLayout.FLOW);

  }

  /**
   * 食事提供に内部項目を追加します。
   */
  protected void addShortStayLifeDinnerOffer(){

  }

  /**
   * 食事提供モデルに内部項目を追加します。
   */
  protected void addShortStayLifeDinnerOfferModel(){

  }

  /**
   * 食事費用に内部項目を追加します。
   */
  protected void addShortStayLifeDinnerCost(){

  }

  /**
   * 30日超に内部項目を追加します。
   */
  protected void addShortStayLifeAddition30Orver(){

  }

  /**
   * ユニットケアの整備に内部項目を追加します。
   */
  protected void addShortStayLifeUnitCareAddRadio(){

  }

  /**
   * ユニットケアの整備モデルに内部項目を追加します。
   */
  protected void addShortStayLifeUnitCareAddRadioModel(){

    getShortStayLifeUnitCareAddRadioItem1().setButtonIndex(1);

    getShortStayLifeUnitCareAddRadioModel().add(getShortStayLifeUnitCareAddRadioItem1());

    getShortStayLifeUnitCareAddRadioItem2().setButtonIndex(2);

    getShortStayLifeUnitCareAddRadioModel().add(getShortStayLifeUnitCareAddRadioItem2());

  }

  /**
   * 未整備に内部項目を追加します。
   */
  protected void addShortStayLifeUnitCareAddRadioItem1(){

  }

  /**
   * 整備に内部項目を追加します。
   */
  protected void addShortStayLifeUnitCareAddRadioItem2(){

  }

  /**
   * 認知症行動・心理症状緊急対応加算に内部項目を追加します。
   */
  protected void addDementiaActionAddRadioGroup(){

  }

  /**
   * 認知症行動・心理症状緊急対応加算モデルに内部項目を追加します。
   */
  protected void addDementiaActionAddRadioGroupModel(){

    getDementiaActionAddRadioItem1().setButtonIndex(1);

    getDementiaActionAddRadioGroupModel().add(getDementiaActionAddRadioItem1());

    getDementiaActionAddRadioItem2().setButtonIndex(2);

    getDementiaActionAddRadioGroupModel().add(getDementiaActionAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addDementiaActionAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addDementiaActionAddRadioItem2(){

  }

  /**
   * 緊急短期入所受入加算に内部項目を追加します。
   */
  protected void addShortStayLifeEmergencyAcceptanceRadioGroup(){

  }

  /**
   * 緊急短期入所受入加算モデルに内部項目を追加します。
   */
  protected void addShortStayLifeEmergencyAcceptanceRadioGroupModel(){

    getShortStayLifeEmergencyAcceptanceRadioItem1().setButtonIndex(1);

    getShortStayLifeEmergencyAcceptanceRadioGroupModel().add(getShortStayLifeEmergencyAcceptanceRadioItem1());

    getShortStayLifeEmergencyAcceptanceRadioItem2().setButtonIndex(2);

    getShortStayLifeEmergencyAcceptanceRadioGroupModel().add(getShortStayLifeEmergencyAcceptanceRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayLifeEmergencyAcceptanceRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayLifeEmergencyAcceptanceRadioItem2(){

  }

  /**
   * 若年性認知症利用者受入加算に内部項目を追加します。
   */
  protected void addYoungDementiaPatinetAddRadioGroup(){

  }

  /**
   * 若年性認知症利用者受入加算モデルに内部項目を追加します。
   */
  protected void addYoungDementiaPatinetAddRadioGroupModel(){

    getYoungDementiaPatinetAddRadioItem1().setButtonIndex(1);

    getYoungDementiaPatinetAddRadioGroupModel().add(getYoungDementiaPatinetAddRadioItem1());

    getYoungDementiaPatinetAddRadioItem2().setButtonIndex(2);

    getYoungDementiaPatinetAddRadioGroupModel().add(getYoungDementiaPatinetAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addYoungDementiaPatinetAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addYoungDementiaPatinetAddRadioItem2(){

  }

  /**
   * タブ3に内部項目を追加します。
   */
  protected void addTab3(){

    tab3.add(getNightStaffDispositionAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getNurseStructuralAddRadioGroup(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getStayPeopleCountRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getShortStayLifeStayheavyAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getIndividualfunctionTrainingSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getMedicalStrengthenCooperationContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getLongTermUseSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 夜勤職員配置加算に内部項目を追加します。
   */
  protected void addNightStaffDispositionAddRadioGroup(){

  }

  /**
   * 夜勤職員配置加算モデルに内部項目を追加します。
   */
  protected void addNightStaffDispositionAddRadioGroupModel(){

    getNightStaffDispositionAddRadioItem1().setButtonIndex(1);

    getNightStaffDispositionAddRadioGroupModel().add(getNightStaffDispositionAddRadioItem1());

    getNightStaffDispositionAddRadioItem2().setButtonIndex(2);

    getNightStaffDispositionAddRadioGroupModel().add(getNightStaffDispositionAddRadioItem2());

    getNightStaffDispositionAddRadioItem3().setButtonIndex(3);

    getNightStaffDispositionAddRadioGroupModel().add(getNightStaffDispositionAddRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNightStaffDispositionAddRadioItem1(){

  }

  /**
   * I・II型に内部項目を追加します。
   */
  protected void addNightStaffDispositionAddRadioItem2(){

  }

  /**
   * III・IV型に内部項目を追加します。
   */
  protected void addNightStaffDispositionAddRadioItem3(){

  }

  /**
   * 看護体制加算コンテナに内部項目を追加します。
   */
  protected void addNurseStructuralAddRadioGroup(){

    nurseStructuralAddRadioGroup.add(getNurseStructuralAddRadioItem1(), VRLayout.FLOW);

    nurseStructuralAddRadioGroup.add(getNurseStructuralAddRadioItem2(), VRLayout.FLOW_RETURN);

    nurseStructuralAddRadioGroup.add(getNurseStructuralAddRadioItem3(), VRLayout.FLOW);

    nurseStructuralAddRadioGroup.add(getNurseStructuralAddRadioItem4(), VRLayout.FLOW);

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addNurseStructuralAddRadioItem1(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addNurseStructuralAddRadioItem2(){

  }

  /**
   * III型に内部項目を追加します。
   */
  protected void addNurseStructuralAddRadioItem3(){

  }

  /**
   * IV型に内部項目を追加します。
   */
  protected void addNurseStructuralAddRadioItem4(){

  }

  /**
   * 定員要件に内部項目を追加します。
   */
  protected void addStayPeopleCountRadioGroup(){

  }

  /**
   * 定員要件モデルに内部項目を追加します。
   */
  protected void addStayPeopleCountRadioGroupModel(){

    getStayPeopleCountRadioItem1().setButtonIndex(1);

    getStayPeopleCountRadioGroupModel().add(getStayPeopleCountRadioItem1());

    getStayPeopleCountRadioItem2().setButtonIndex(2);

    getStayPeopleCountRadioGroupModel().add(getStayPeopleCountRadioItem2());

  }

  /**
   * 29人以下に内部項目を追加します。
   */
  protected void addStayPeopleCountRadioItem1(){

  }

  /**
   * 30人以上50人以下に内部項目を追加します。
   */
  protected void addStayPeopleCountRadioItem2(){

  }

  /**
   * 在宅中重度加算に内部項目を追加します。
   */
  protected void addShortStayLifeStayheavyAddRadio(){

  }

  /**
   * 在宅中重度加算モデルに内部項目を追加します。
   */
  protected void addShortStayLifeStayheavyAddRadioModel(){

    getShortStayLifeStayheavyAddRadioItem1().setButtonIndex(1);

    getShortStayLifeStayheavyAddRadioModel().add(getShortStayLifeStayheavyAddRadioItem1());

    getShortStayLifeStayheavyAddRadioItem2().setButtonIndex(2);

    getShortStayLifeStayheavyAddRadioModel().add(getShortStayLifeStayheavyAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayLifeStayheavyAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayLifeStayheavyAddRadioItem2(){

  }

  /**
   * 個別機能訓練加算に内部項目を追加します。
   */
  protected void addIndividualfunctionTrainingSystem(){

  }

  /**
   * 個別機能訓練加算モデルに内部項目を追加します。
   */
  protected void addIndividualfunctionTrainingSystemModel(){

    getIndividualfunctionTrainingSystemItem1().setButtonIndex(1);

    getIndividualfunctionTrainingSystemModel().add(getIndividualfunctionTrainingSystemItem1());

    getIndividualfunctionTrainingSystemItem2().setButtonIndex(2);

    getIndividualfunctionTrainingSystemModel().add(getIndividualfunctionTrainingSystemItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addIndividualfunctionTrainingSystemItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addIndividualfunctionTrainingSystemItem2(){

  }

  /**
   * 医療連携強化加算に内部項目を追加します。
   */
  protected void addMedicalStrengthenCooperation(){

  }

  /**
   * 医療連携強化加算モデルに内部項目を追加します。
   */
  protected void addMedicalStrengthenCooperationModel(){

    getMedicalStrengthenCooperationItem1().setButtonIndex(1);

    getMedicalStrengthenCooperationModel().add(getMedicalStrengthenCooperationItem1());

    getMedicalStrengthenCooperationItem2().setButtonIndex(2);

    getMedicalStrengthenCooperationModel().add(getMedicalStrengthenCooperationItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalStrengthenCooperationItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalStrengthenCooperationItem2(){

  }

  /**
   * 長期利用者提供減算に内部項目を追加します。
   */
  protected void addLongTermUseSubtraction(){

  }

  /**
   * 長期利用者提供減算モデルに内部項目を追加します。
   */
  protected void addLongTermUseSubtractionModel(){

    getLongTermUseSubtractionItem1().setButtonIndex(1);

    getLongTermUseSubtractionModel().add(getLongTermUseSubtractionItem1());

    getLongTermUseSubtractionItem2().setButtonIndex(2);

    getLongTermUseSubtractionModel().add(getLongTermUseSubtractionItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addLongTermUseSubtractionItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addLongTermUseSubtractionItem2(){

  }

  /**
   * タブ4に内部項目を追加します。
   */
  protected void addTab4(){

    tab4.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getSymbiosisTypeRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getDeploymentLifeCounselorContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getImprovementCollaborationContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab4.add(getDementiaProfessionalCareAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * 共生型に内部項目を追加します。
   */
  protected void addSymbiosisTypeRadio(){

  }

  /**
   * 共生型モデルに内部項目を追加します。
   */
  protected void addSymbiosisTypeRadioModel(){

    getSymbiosisTypeRadioItem1().setButtonIndex(1);

    getSymbiosisTypeRadioModel().add(getSymbiosisTypeRadioItem1());

    getSymbiosisTypeRadioItem2().setButtonIndex(9);

    getSymbiosisTypeRadioModel().add(getSymbiosisTypeRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSymbiosisTypeRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addSymbiosisTypeRadioItem2(){

  }

  /**
   * 生活相談員配置等加算に内部項目を追加します。
   */
  protected void addDeploymentLifeCounselor(){

  }

  /**
   * 生活相談員配置等加算モデルに内部項目を追加します。
   */
  protected void addDeploymentLifeCounselorModel(){

    getDeploymentLifeCounselorItem1().setButtonIndex(1);

    getDeploymentLifeCounselorModel().add(getDeploymentLifeCounselorItem1());

    getDeploymentLifeCounselorItem2().setButtonIndex(2);

    getDeploymentLifeCounselorModel().add(getDeploymentLifeCounselorItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addDeploymentLifeCounselorItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addDeploymentLifeCounselorItem2(){

  }

  /**
   * 生活機能向上連携加算に内部項目を追加します。
   */
  protected void addImprovementCollaboration(){

  }

  /**
   * 生活機能向上連携加算モデルに内部項目を追加します。
   */
  protected void addImprovementCollaborationModel(){

    getImprovementCollaborationItem1().setButtonIndex(1);

    getImprovementCollaborationModel().add(getImprovementCollaborationItem1());

    getImprovementCollaborationItem2().setButtonIndex(2);

    getImprovementCollaborationModel().add(getImprovementCollaborationItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addImprovementCollaborationItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addImprovementCollaborationItem2(){

  }

  /**
   * 認知症専門ケア加算に内部項目を追加します。
   */
  protected void addDementiaProfessionalCareAddRadioGroup(){

  }

  /**
   * 認知症専門ケア加算モデルに内部項目を追加します。
   */
  protected void addDementiaProfessionalCareAddRadioGroupModel(){

    getDementiaProfessionalCareAddRadioItem1().setButtonIndex(1);

    getDementiaProfessionalCareAddRadioGroupModel().add(getDementiaProfessionalCareAddRadioItem1());

    getDementiaProfessionalCareAddRadioItem2().setButtonIndex(2);

    getDementiaProfessionalCareAddRadioGroupModel().add(getDementiaProfessionalCareAddRadioItem2());

    getDementiaProfessionalCareAddRadioItem3().setButtonIndex(3);

    getDementiaProfessionalCareAddRadioGroupModel().add(getDementiaProfessionalCareAddRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addDementiaProfessionalCareAddRadioItem1(){

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addDementiaProfessionalCareAddRadioItem2(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addDementiaProfessionalCareAddRadioItem3(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_12111_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_12111_201804Design getThis() {
    return this;
  }
}
