
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
 * 開発者: 日高　しのぶ
 * 作成日: 2018/02/07  日本コンピューター株式会社 日高　しのぶ 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン地域密着型通所介護 (QS001_17811_201804)
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
 * サービスパターン地域密着型通所介護画面項目デザイン(QS001_17811_201804) 
 */
public class QS001_17811_201804Design extends QS001ServicePanel {
  //GUIコンポーネント

  private JTabbedPane tsuusyoKaigoPatterns;

  private ACPanel tab1;

  private ACLabelContainer tsuusyoKaigoFacilitiesDivisionContainer;

  private ACValueArrayRadioButtonGroup tsuusyoKaigoTimeContenaFacilityDivision;

  private ACListModelAdapter tsuusyoKaigoTimeContenaFacilityDivisionModel;

  private ACRadioButtonItem tsuusyoKaigoTimeContenaFacilityDivisionItem1;

  private ACRadioButtonItem tsuusyoKaigoTimeContenaFacilityDivisionItem2;

  private ACComboBox tsuusyoKaigoTimeDivision;

  private ACLabelContainer tsuusyoKaigoTimeDivisionContainer;

  private ACComboBoxModelAdapter tsuusyoKaigoTimeDivisionModel;

  private ACValueArrayRadioButtonGroup tsuusyoKaigoSubtraction;

  private ACLabelContainer tsuusyoKaigoSubtractionContainer;

  private ACListModelAdapter tsuusyoKaigoSubtractionModel;

  private ACRadioButtonItem tsuusyoKaigoSubtractionNot;

  private ACRadioButtonItem tsuusyoKaigoSubtractionExcess;

  private ACRadioButtonItem tsuusyoKaigoSubtractionLack;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaRadioItem1;

  private ACRadioButtonItem providerAddMountainousAreaRadioItem2;

  private ACValueArrayRadioButtonGroup tsuusyoKaigoAdditionFunctionBathRadio;

  private ACLabelContainer tsuusyoKaigoAdditionFunctionBathRadioContainer;

  private ACListModelAdapter tsuusyoKaigoAdditionFunctionBathRadioModel;

  private ACRadioButtonItem tsuusyoKaigoAdditionFunctionBathRadioItem1;

  private ACRadioButtonItem tsuusyoKaigoAdditionFunctionBathRadioItem2;

  private ACValueArrayRadioButtonGroup severeCareRecipientsAccepted;

  private ACLabelContainer severeCareRecipientsAcceptedContainer;

  private ACListModelAdapter severeCareRecipientsAcceptedModel;

  private ACRadioButtonItem severeCareRecipientsAcceptedItem1;

  private ACRadioButtonItem severeCareRecipientsAcceptedItem2;

  private ACLabelContainer tsuusyoKaigoAdditionFunctionTrainingRadio;

  private ACIntegerCheckBox tsuusyoKaigoAdditionFunctionTrainingRadioItem1;

  private ACIntegerCheckBox tsuusyoKaigoAdditionFunctionTrainingRadioItem2;

  private ACValueArrayRadioButtonGroup dementiaElderlyAccepted;

  private ACLabelContainer dementiaElderlyAcceptedContainer;

  private ACListModelAdapter dementiaElderlyAcceptedModel;

  private ACRadioButtonItem dementiaElderlyAcceptedItem1;

  private ACRadioButtonItem dementiaElderlyAcceptedItem2;

  private ACBackLabelContainer tsuusyoKaigoTimeContena;

  private ACTimeComboBox tsuusyoKaigoTimeBeginTime;

  private ACLabelContainer tsuusyoKaigoTimeBeginTimeContainer;

  private ACComboBoxModelAdapter tsuusyoKaigoTimeBeginTimeModel;

  private ACTimeComboBox tsuusyoKaigoTimeEndTime;

  private ACLabelContainer tsuusyoKaigoTimeEndTimeContainer;

  private ACComboBoxModelAdapter tsuusyoKaigoTimeEndTimeModel;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACValueArrayRadioButtonGroup tsuusyoKaigoNourishmentManagementAddRadio;

  private ACLabelContainer tsuusyoKaigoNourishmentManagementAddRadioContainer;

  private ACListModelAdapter tsuusyoKaigoNourishmentManagementAddRadioModel;

  private ACRadioButtonItem tsuusyoKaigoNourishmentManagementAddRadioItem1;

  private ACRadioButtonItem tsuusyoKaigoNourishmentManagementAddRadioItem2;

  private ACValueArrayRadioButtonGroup tsuusyoKaigoMouthFunctionAddRadio;

  private ACLabelContainer tsuusyoKaigoMouthFunctionAddRadioContainer;

  private ACListModelAdapter tsuusyoKaigoMouthFunctionAddRadioModel;

  private ACRadioButtonItem tsuusyoKaigoMouthFunctionAddRadioItem1;

  private ACRadioButtonItem tsuusyoKaigoMouthFunctionAddRadioItem2;

  private ACValueArrayRadioButtonGroup individualPickupSystem;

  private ACLabelContainer individualPickupSystemContainer;

  private ACListModelAdapter individualPickupSystemModel;

  private ACRadioButtonItem individualPickupSystemItem1;

  private ACRadioButtonItem individualPickupSystemItem2;

  private ACValueArrayRadioButtonGroup bathingAssistanceSystem;

  private ACLabelContainer bathingAssistanceSystemContainer;

  private ACListModelAdapter bathingAssistanceSystemModel;

  private ACRadioButtonItem bathingAssistanceSystemItem1;

  private ACRadioButtonItem bathingAssistanceSystemItem2;

  private ACValueArrayRadioButtonGroup transportationCallRadioGroup;

  private ACLabelContainer transportationCallRadioGroupContainer;

  private ACListModelAdapter transportationCallRadioGroupModel;

  private ACRadioButtonItem transportationCallRadioItem1;

  private ACRadioButtonItem transportationCallRadioItem2;

  private ACValueArrayRadioButtonGroup MeetingAndSendingOff;

  private ACLabelContainer MeetingAndSendingOffContainer;

  private ACListModelAdapter MeetingAndSendingOffModel;

  private ACRadioButtonItem MeetingAndSendingOffRoundTrip;

  private ACRadioButtonItem MeetingAndSendingOffOneWay;

  private ACRadioButtonItem MeetingAndSendingOffNone;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACValueArrayRadioButtonGroup improvementCollaboration;

  private ACLabelContainer improvementCollaborationContainer;

  private ACListModelAdapter improvementCollaborationModel;

  private ACRadioButtonItem improvementCollaborationItem1;

  private ACRadioButtonItem improvementCollaborationItem2;

  private ACValueArrayRadioButtonGroup adlMaintenanceRadioGroup;

  private ACLabelContainer adlMaintenanceRadioGroupContainer;

  private ACListModelAdapter adlMaintenanceRadioGroupModel;

  private ACRadioButtonItem adlMaintenanceItem1;

  private ACRadioButtonItem adlMaintenanceItem2;

  private ACRadioButtonItem adlMaintenanceItem3;

  private ACPanel tab3;

  private ACValueArrayRadioButtonGroup nutritionScreening;

  private ACLabelContainer nutritionScreeningContainer;

  private ACListModelAdapter nutritionScreeningModel;

  private ACRadioButtonItem nutritionScreeningItem1;

  private ACRadioButtonItem nutritionScreeningItem2;

  private ACValueArrayRadioButtonGroup symbiosisTypeRadio;

  private ACLabelContainer symbiosisTypeRadioContainer;

  private ACListModelAdapter symbiosisTypeRadioModel;

  private ACRadioButtonItem symbiosisTypeRadioItem1;

  private ACRadioButtonItem symbiosisTypeRadioItem2;

  private ACRadioButtonItem symbiosisTypeRadioItem3;

  private ACRadioButtonItem symbiosisTypeRadioItem4;

  private ACRadioButtonItem symbiosisTypeRadioItem5;

  private ACValueArrayRadioButtonGroup deploymentLifeCounselor;

  private ACLabelContainer deploymentLifeCounselorContainer;

  private ACListModelAdapter deploymentLifeCounselorModel;

  private ACRadioButtonItem deploymentLifeCounselorItem1;

  private ACRadioButtonItem deploymentLifeCounselorItem2;

  //getter

  /**
   * 地域密着型通所介護パターン領域を取得します。
   * @return 地域密着型通所介護パターン領域
   */
  public JTabbedPane getTsuusyoKaigoPatterns(){
    if(tsuusyoKaigoPatterns==null){

      tsuusyoKaigoPatterns = new JTabbedPane();

      addTsuusyoKaigoPatterns();
    }
    return tsuusyoKaigoPatterns;

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

      tab1.setLabelMargin(0);

      tab1.setVgap(0);

      addTab1();
    }
    return tab1;

  }

  /**
   * 施設等の区分コンテナを取得します。
   * @return 施設等の区分コンテナ
   */
  public ACLabelContainer getTsuusyoKaigoFacilitiesDivisionContainer(){
    if(tsuusyoKaigoFacilitiesDivisionContainer==null){

      tsuusyoKaigoFacilitiesDivisionContainer = new ACLabelContainer();

      tsuusyoKaigoFacilitiesDivisionContainer.setText("施設等の区分");

      tsuusyoKaigoFacilitiesDivisionContainer.setFollowChildEnabled(true);

      tsuusyoKaigoFacilitiesDivisionContainer.setHgap(0);

      tsuusyoKaigoFacilitiesDivisionContainer.setLabelMargin(0);

      tsuusyoKaigoFacilitiesDivisionContainer.setVgap(0);

      addTsuusyoKaigoFacilitiesDivisionContainer();
    }
    return tsuusyoKaigoFacilitiesDivisionContainer;

  }

  /**
   * 施設等の区分ラジオグループ1を取得します。
   * @return 施設等の区分ラジオグループ1
   */
  public ACValueArrayRadioButtonGroup getTsuusyoKaigoTimeContenaFacilityDivision(){
    if(tsuusyoKaigoTimeContenaFacilityDivision==null){

      tsuusyoKaigoTimeContenaFacilityDivision = new ACValueArrayRadioButtonGroup();

      tsuusyoKaigoTimeContenaFacilityDivision.setBindPath("1780101");

      tsuusyoKaigoTimeContenaFacilityDivision.setNoSelectIndex(0);

      tsuusyoKaigoTimeContenaFacilityDivision.setUseClearButton(false);

      tsuusyoKaigoTimeContenaFacilityDivision.setModel(getTsuusyoKaigoTimeContenaFacilityDivisionModel());

      tsuusyoKaigoTimeContenaFacilityDivision.setValues(new int[]{1,2});

      addTsuusyoKaigoTimeContenaFacilityDivision();
    }
    return tsuusyoKaigoTimeContenaFacilityDivision;

  }

  /**
   * 施設等の区分ラジオグループ1モデルを取得します。
   * @return 施設等の区分ラジオグループ1モデル
   */
  protected ACListModelAdapter getTsuusyoKaigoTimeContenaFacilityDivisionModel(){
    if(tsuusyoKaigoTimeContenaFacilityDivisionModel==null){
      tsuusyoKaigoTimeContenaFacilityDivisionModel = new ACListModelAdapter();
      addTsuusyoKaigoTimeContenaFacilityDivisionModel();
    }
    return tsuusyoKaigoTimeContenaFacilityDivisionModel;
  }

  /**
   * 地域密着型通所介護を取得します。
   * @return 地域密着型通所介護
   */
  public ACRadioButtonItem getTsuusyoKaigoTimeContenaFacilityDivisionItem1(){
    if(tsuusyoKaigoTimeContenaFacilityDivisionItem1==null){

      tsuusyoKaigoTimeContenaFacilityDivisionItem1 = new ACRadioButtonItem();

      tsuusyoKaigoTimeContenaFacilityDivisionItem1.setText("地域密着型通所介護");

      tsuusyoKaigoTimeContenaFacilityDivisionItem1.setGroup(getTsuusyoKaigoTimeContenaFacilityDivision());

      tsuusyoKaigoTimeContenaFacilityDivisionItem1.setConstraints(VRLayout.FLOW_RETURN);

      addTsuusyoKaigoTimeContenaFacilityDivisionItem1();
    }
    return tsuusyoKaigoTimeContenaFacilityDivisionItem1;

  }

  /**
   * 療養通所介護を取得します。
   * @return 療養通所介護
   */
  public ACRadioButtonItem getTsuusyoKaigoTimeContenaFacilityDivisionItem2(){
    if(tsuusyoKaigoTimeContenaFacilityDivisionItem2==null){

      tsuusyoKaigoTimeContenaFacilityDivisionItem2 = new ACRadioButtonItem();

      tsuusyoKaigoTimeContenaFacilityDivisionItem2.setText("療養通所介護");

      tsuusyoKaigoTimeContenaFacilityDivisionItem2.setGroup(getTsuusyoKaigoTimeContenaFacilityDivision());

      tsuusyoKaigoTimeContenaFacilityDivisionItem2.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoTimeContenaFacilityDivisionItem2();
    }
    return tsuusyoKaigoTimeContenaFacilityDivisionItem2;

  }

  /**
   * 時間区分を取得します。
   * @return 時間区分
   */
  public ACComboBox getTsuusyoKaigoTimeDivision(){
    if(tsuusyoKaigoTimeDivision==null){

      tsuusyoKaigoTimeDivision = new ACComboBox();

      getTsuusyoKaigoTimeDivisionContainer().setText("時間区分");

      tsuusyoKaigoTimeDivision.setBindPath("1780102");

      tsuusyoKaigoTimeDivision.setEditable(false);

      tsuusyoKaigoTimeDivision.setModelBindPath("1780102");

      tsuusyoKaigoTimeDivision.setRenderBindPath("CONTENT");

      tsuusyoKaigoTimeDivision.setModel(getTsuusyoKaigoTimeDivisionModel());

      addTsuusyoKaigoTimeDivision();
    }
    return tsuusyoKaigoTimeDivision;

  }

  /**
   * 時間区分コンテナを取得します。
   * @return 時間区分コンテナ
   */
  protected ACLabelContainer getTsuusyoKaigoTimeDivisionContainer(){
    if(tsuusyoKaigoTimeDivisionContainer==null){
      tsuusyoKaigoTimeDivisionContainer = new ACLabelContainer();
      tsuusyoKaigoTimeDivisionContainer.setFollowChildEnabled(true);
      tsuusyoKaigoTimeDivisionContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoTimeDivisionContainer.add(getTsuusyoKaigoTimeDivision(), null);
    }
    return tsuusyoKaigoTimeDivisionContainer;
  }

  /**
   * 時間区分モデルを取得します。
   * @return 時間区分モデル
   */
  protected ACComboBoxModelAdapter getTsuusyoKaigoTimeDivisionModel(){
    if(tsuusyoKaigoTimeDivisionModel==null){
      tsuusyoKaigoTimeDivisionModel = new ACComboBoxModelAdapter();
      addTsuusyoKaigoTimeDivisionModel();
    }
    return tsuusyoKaigoTimeDivisionModel;
  }

  /**
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACValueArrayRadioButtonGroup getTsuusyoKaigoSubtraction(){
    if(tsuusyoKaigoSubtraction==null){

      tsuusyoKaigoSubtraction = new ACValueArrayRadioButtonGroup();

      getTsuusyoKaigoSubtractionContainer().setText("人員減算");

      tsuusyoKaigoSubtraction.setBindPath("1780103");

      tsuusyoKaigoSubtraction.setUseClearButton(false);

      tsuusyoKaigoSubtraction.setModel(getTsuusyoKaigoSubtractionModel());

      tsuusyoKaigoSubtraction.setValues(new int[]{1,2,3});

      addTsuusyoKaigoSubtraction();
    }
    return tsuusyoKaigoSubtraction;

  }

  /**
   * 人員減算コンテナを取得します。
   * @return 人員減算コンテナ
   */
  protected ACLabelContainer getTsuusyoKaigoSubtractionContainer(){
    if(tsuusyoKaigoSubtractionContainer==null){
      tsuusyoKaigoSubtractionContainer = new ACLabelContainer();
      tsuusyoKaigoSubtractionContainer.setFollowChildEnabled(true);
      tsuusyoKaigoSubtractionContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoSubtractionContainer.add(getTsuusyoKaigoSubtraction(), null);
    }
    return tsuusyoKaigoSubtractionContainer;
  }

  /**
   * 人員減算モデルを取得します。
   * @return 人員減算モデル
   */
  protected ACListModelAdapter getTsuusyoKaigoSubtractionModel(){
    if(tsuusyoKaigoSubtractionModel==null){
      tsuusyoKaigoSubtractionModel = new ACListModelAdapter();
      addTsuusyoKaigoSubtractionModel();
    }
    return tsuusyoKaigoSubtractionModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTsuusyoKaigoSubtractionNot(){
    if(tsuusyoKaigoSubtractionNot==null){

      tsuusyoKaigoSubtractionNot = new ACRadioButtonItem();

      tsuusyoKaigoSubtractionNot.setText("なし");

      tsuusyoKaigoSubtractionNot.setGroup(getTsuusyoKaigoSubtraction());

      tsuusyoKaigoSubtractionNot.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoSubtractionNot();
    }
    return tsuusyoKaigoSubtractionNot;

  }

  /**
   * 定員超過を取得します。
   * @return 定員超過
   */
  public ACRadioButtonItem getTsuusyoKaigoSubtractionExcess(){
    if(tsuusyoKaigoSubtractionExcess==null){

      tsuusyoKaigoSubtractionExcess = new ACRadioButtonItem();

      tsuusyoKaigoSubtractionExcess.setText("定員超過");

      tsuusyoKaigoSubtractionExcess.setGroup(getTsuusyoKaigoSubtraction());

      tsuusyoKaigoSubtractionExcess.setConstraints(VRLayout.FLOW_RETURN);

      addTsuusyoKaigoSubtractionExcess();
    }
    return tsuusyoKaigoSubtractionExcess;

  }

  /**
   * 看護・介護職員の不足を取得します。
   * @return 看護・介護職員の不足
   */
  public ACRadioButtonItem getTsuusyoKaigoSubtractionLack(){
    if(tsuusyoKaigoSubtractionLack==null){

      tsuusyoKaigoSubtractionLack = new ACRadioButtonItem();

      tsuusyoKaigoSubtractionLack.setText("看護・介護職員の不足");

      tsuusyoKaigoSubtractionLack.setGroup(getTsuusyoKaigoSubtraction());

      tsuusyoKaigoSubtractionLack.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoSubtractionLack();
    }
    return tsuusyoKaigoSubtractionLack;

  }

  /**
   * 中山間地域等でのサービス提供加算を取得します。
   * @return 中山間地域等でのサービス提供加算
   */
  public ACValueArrayRadioButtonGroup getProviderAddMountainousAreaRadioGroup(){
    if(providerAddMountainousAreaRadioGroup==null){

      providerAddMountainousAreaRadioGroup = new ACValueArrayRadioButtonGroup();

      getProviderAddMountainousAreaRadioGroupContainer().setText("中山間地域等でのサービス提供加算");

      providerAddMountainousAreaRadioGroup.setBindPath("12");

      providerAddMountainousAreaRadioGroup.setNoSelectIndex(0);

      providerAddMountainousAreaRadioGroup.setUseClearButton(false);

      providerAddMountainousAreaRadioGroup.setModel(getProviderAddMountainousAreaRadioGroupModel());

      providerAddMountainousAreaRadioGroup.setValues(new int[]{1,2});

      addProviderAddMountainousAreaRadioGroup();
    }
    return providerAddMountainousAreaRadioGroup;

  }

  /**
   * 中山間地域等でのサービス提供加算コンテナを取得します。
   * @return 中山間地域等でのサービス提供加算コンテナ
   */
  protected ACLabelContainer getProviderAddMountainousAreaRadioGroupContainer(){
    if(providerAddMountainousAreaRadioGroupContainer==null){
      providerAddMountainousAreaRadioGroupContainer = new ACLabelContainer();
      providerAddMountainousAreaRadioGroupContainer.setFollowChildEnabled(true);
      providerAddMountainousAreaRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      providerAddMountainousAreaRadioGroupContainer.add(getProviderAddMountainousAreaRadioGroup(), null);
    }
    return providerAddMountainousAreaRadioGroupContainer;
  }

  /**
   * 中山間地域等でのサービス提供加算モデルを取得します。
   * @return 中山間地域等でのサービス提供加算モデル
   */
  protected ACListModelAdapter getProviderAddMountainousAreaRadioGroupModel(){
    if(providerAddMountainousAreaRadioGroupModel==null){
      providerAddMountainousAreaRadioGroupModel = new ACListModelAdapter();
      addProviderAddMountainousAreaRadioGroupModel();
    }
    return providerAddMountainousAreaRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getProviderAddMountainousAreaRadioItem1(){
    if(providerAddMountainousAreaRadioItem1==null){

      providerAddMountainousAreaRadioItem1 = new ACRadioButtonItem();

      providerAddMountainousAreaRadioItem1.setText("なし");

      providerAddMountainousAreaRadioItem1.setGroup(getProviderAddMountainousAreaRadioGroup());

      providerAddMountainousAreaRadioItem1.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaRadioItem1();
    }
    return providerAddMountainousAreaRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getProviderAddMountainousAreaRadioItem2(){
    if(providerAddMountainousAreaRadioItem2==null){

      providerAddMountainousAreaRadioItem2 = new ACRadioButtonItem();

      providerAddMountainousAreaRadioItem2.setText("あり");

      providerAddMountainousAreaRadioItem2.setGroup(getProviderAddMountainousAreaRadioGroup());

      providerAddMountainousAreaRadioItem2.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaRadioItem2();
    }
    return providerAddMountainousAreaRadioItem2;

  }

  /**
   * 入浴加算を取得します。
   * @return 入浴加算
   */
  public ACValueArrayRadioButtonGroup getTsuusyoKaigoAdditionFunctionBathRadio(){
    if(tsuusyoKaigoAdditionFunctionBathRadio==null){

      tsuusyoKaigoAdditionFunctionBathRadio = new ACValueArrayRadioButtonGroup();

      getTsuusyoKaigoAdditionFunctionBathRadioContainer().setText("入浴加算");

      tsuusyoKaigoAdditionFunctionBathRadio.setBindPath("1780104");

      tsuusyoKaigoAdditionFunctionBathRadio.setUseClearButton(false);

      tsuusyoKaigoAdditionFunctionBathRadio.setModel(getTsuusyoKaigoAdditionFunctionBathRadioModel());

      tsuusyoKaigoAdditionFunctionBathRadio.setValues(new int[]{1,2});

      addTsuusyoKaigoAdditionFunctionBathRadio();
    }
    return tsuusyoKaigoAdditionFunctionBathRadio;

  }

  /**
   * 入浴加算コンテナを取得します。
   * @return 入浴加算コンテナ
   */
  protected ACLabelContainer getTsuusyoKaigoAdditionFunctionBathRadioContainer(){
    if(tsuusyoKaigoAdditionFunctionBathRadioContainer==null){
      tsuusyoKaigoAdditionFunctionBathRadioContainer = new ACLabelContainer();
      tsuusyoKaigoAdditionFunctionBathRadioContainer.setFollowChildEnabled(true);
      tsuusyoKaigoAdditionFunctionBathRadioContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoAdditionFunctionBathRadioContainer.add(getTsuusyoKaigoAdditionFunctionBathRadio(), null);
    }
    return tsuusyoKaigoAdditionFunctionBathRadioContainer;
  }

  /**
   * 入浴加算モデルを取得します。
   * @return 入浴加算モデル
   */
  protected ACListModelAdapter getTsuusyoKaigoAdditionFunctionBathRadioModel(){
    if(tsuusyoKaigoAdditionFunctionBathRadioModel==null){
      tsuusyoKaigoAdditionFunctionBathRadioModel = new ACListModelAdapter();
      addTsuusyoKaigoAdditionFunctionBathRadioModel();
    }
    return tsuusyoKaigoAdditionFunctionBathRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTsuusyoKaigoAdditionFunctionBathRadioItem1(){
    if(tsuusyoKaigoAdditionFunctionBathRadioItem1==null){

      tsuusyoKaigoAdditionFunctionBathRadioItem1 = new ACRadioButtonItem();

      tsuusyoKaigoAdditionFunctionBathRadioItem1.setText("なし");

      tsuusyoKaigoAdditionFunctionBathRadioItem1.setGroup(getTsuusyoKaigoAdditionFunctionBathRadio());

      tsuusyoKaigoAdditionFunctionBathRadioItem1.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoAdditionFunctionBathRadioItem1();
    }
    return tsuusyoKaigoAdditionFunctionBathRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getTsuusyoKaigoAdditionFunctionBathRadioItem2(){
    if(tsuusyoKaigoAdditionFunctionBathRadioItem2==null){

      tsuusyoKaigoAdditionFunctionBathRadioItem2 = new ACRadioButtonItem();

      tsuusyoKaigoAdditionFunctionBathRadioItem2.setText("あり");

      tsuusyoKaigoAdditionFunctionBathRadioItem2.setGroup(getTsuusyoKaigoAdditionFunctionBathRadio());

      tsuusyoKaigoAdditionFunctionBathRadioItem2.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoAdditionFunctionBathRadioItem2();
    }
    return tsuusyoKaigoAdditionFunctionBathRadioItem2;

  }

  /**
   * 中重度者ケア体制加算ラジオグループを取得します。
   * @return 中重度者ケア体制加算ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getSevereCareRecipientsAccepted(){
    if(severeCareRecipientsAccepted==null){

      severeCareRecipientsAccepted = new ACValueArrayRadioButtonGroup();

      getSevereCareRecipientsAcceptedContainer().setText("中重度者ケア体制加算");

      severeCareRecipientsAccepted.setBindPath("1780105");

      severeCareRecipientsAccepted.setUseClearButton(false);

      severeCareRecipientsAccepted.setModel(getSevereCareRecipientsAcceptedModel());

      severeCareRecipientsAccepted.setValues(new int[]{1,2});

      addSevereCareRecipientsAccepted();
    }
    return severeCareRecipientsAccepted;

  }

  /**
   * 中重度者ケア体制加算ラジオグループコンテナを取得します。
   * @return 中重度者ケア体制加算ラジオグループコンテナ
   */
  protected ACLabelContainer getSevereCareRecipientsAcceptedContainer(){
    if(severeCareRecipientsAcceptedContainer==null){
      severeCareRecipientsAcceptedContainer = new ACLabelContainer();
      severeCareRecipientsAcceptedContainer.setFollowChildEnabled(true);
      severeCareRecipientsAcceptedContainer.setVAlignment(VRLayout.CENTER);
      severeCareRecipientsAcceptedContainer.add(getSevereCareRecipientsAccepted(), null);
    }
    return severeCareRecipientsAcceptedContainer;
  }

  /**
   * 中重度者ケア体制加算ラジオグループモデルを取得します。
   * @return 中重度者ケア体制加算ラジオグループモデル
   */
  protected ACListModelAdapter getSevereCareRecipientsAcceptedModel(){
    if(severeCareRecipientsAcceptedModel==null){
      severeCareRecipientsAcceptedModel = new ACListModelAdapter();
      addSevereCareRecipientsAcceptedModel();
    }
    return severeCareRecipientsAcceptedModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSevereCareRecipientsAcceptedItem1(){
    if(severeCareRecipientsAcceptedItem1==null){

      severeCareRecipientsAcceptedItem1 = new ACRadioButtonItem();

      severeCareRecipientsAcceptedItem1.setText("なし");

      severeCareRecipientsAcceptedItem1.setGroup(getSevereCareRecipientsAccepted());

      severeCareRecipientsAcceptedItem1.setConstraints(VRLayout.FLOW);

      addSevereCareRecipientsAcceptedItem1();
    }
    return severeCareRecipientsAcceptedItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getSevereCareRecipientsAcceptedItem2(){
    if(severeCareRecipientsAcceptedItem2==null){

      severeCareRecipientsAcceptedItem2 = new ACRadioButtonItem();

      severeCareRecipientsAcceptedItem2.setText("あり");

      severeCareRecipientsAcceptedItem2.setGroup(getSevereCareRecipientsAccepted());

      severeCareRecipientsAcceptedItem2.setConstraints(VRLayout.FLOW);

      addSevereCareRecipientsAcceptedItem2();
    }
    return severeCareRecipientsAcceptedItem2;

  }

  /**
   * 個別機能訓練指導加算を取得します。
   * @return 個別機能訓練指導加算
   */
  public ACLabelContainer getTsuusyoKaigoAdditionFunctionTrainingRadio(){
    if(tsuusyoKaigoAdditionFunctionTrainingRadio==null){

      tsuusyoKaigoAdditionFunctionTrainingRadio = new ACLabelContainer();

      tsuusyoKaigoAdditionFunctionTrainingRadio.setText("個別機能訓練指導加算");

      tsuusyoKaigoAdditionFunctionTrainingRadio.setFollowChildEnabled(true);

      addTsuusyoKaigoAdditionFunctionTrainingRadio();
    }
    return tsuusyoKaigoAdditionFunctionTrainingRadio;

  }

  /**
   * 加算型Iを取得します。
   * @return 加算型I
   */
  public ACIntegerCheckBox getTsuusyoKaigoAdditionFunctionTrainingRadioItem1(){
    if(tsuusyoKaigoAdditionFunctionTrainingRadioItem1==null){

      tsuusyoKaigoAdditionFunctionTrainingRadioItem1 = new ACIntegerCheckBox();

      tsuusyoKaigoAdditionFunctionTrainingRadioItem1.setText("加算型I");

      tsuusyoKaigoAdditionFunctionTrainingRadioItem1.setBindPath("1780106");

      tsuusyoKaigoAdditionFunctionTrainingRadioItem1.setSelectValue(2);

      tsuusyoKaigoAdditionFunctionTrainingRadioItem1.setUnSelectValue(1);

      addTsuusyoKaigoAdditionFunctionTrainingRadioItem1();
    }
    return tsuusyoKaigoAdditionFunctionTrainingRadioItem1;

  }

  /**
   * 加算型IIを取得します。
   * @return 加算型II
   */
  public ACIntegerCheckBox getTsuusyoKaigoAdditionFunctionTrainingRadioItem2(){
    if(tsuusyoKaigoAdditionFunctionTrainingRadioItem2==null){

      tsuusyoKaigoAdditionFunctionTrainingRadioItem2 = new ACIntegerCheckBox();

      tsuusyoKaigoAdditionFunctionTrainingRadioItem2.setText("加算型II");

      tsuusyoKaigoAdditionFunctionTrainingRadioItem2.setBindPath("1780107");

      tsuusyoKaigoAdditionFunctionTrainingRadioItem2.setSelectValue(2);

      tsuusyoKaigoAdditionFunctionTrainingRadioItem2.setUnSelectValue(1);

      addTsuusyoKaigoAdditionFunctionTrainingRadioItem2();
    }
    return tsuusyoKaigoAdditionFunctionTrainingRadioItem2;

  }

  /**
   * 認知症加算ラジオグループを取得します。
   * @return 認知症加算ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getDementiaElderlyAccepted(){
    if(dementiaElderlyAccepted==null){

      dementiaElderlyAccepted = new ACValueArrayRadioButtonGroup();

      getDementiaElderlyAcceptedContainer().setText("認知症加算");

      dementiaElderlyAccepted.setBindPath("1780108");

      dementiaElderlyAccepted.setUseClearButton(false);

      dementiaElderlyAccepted.setModel(getDementiaElderlyAcceptedModel());

      dementiaElderlyAccepted.setValues(new int[]{1,2});

      addDementiaElderlyAccepted();
    }
    return dementiaElderlyAccepted;

  }

  /**
   * 認知症加算ラジオグループコンテナを取得します。
   * @return 認知症加算ラジオグループコンテナ
   */
  protected ACLabelContainer getDementiaElderlyAcceptedContainer(){
    if(dementiaElderlyAcceptedContainer==null){
      dementiaElderlyAcceptedContainer = new ACLabelContainer();
      dementiaElderlyAcceptedContainer.setFollowChildEnabled(true);
      dementiaElderlyAcceptedContainer.setVAlignment(VRLayout.CENTER);
      dementiaElderlyAcceptedContainer.add(getDementiaElderlyAccepted(), null);
    }
    return dementiaElderlyAcceptedContainer;
  }

  /**
   * 認知症加算ラジオグループモデルを取得します。
   * @return 認知症加算ラジオグループモデル
   */
  protected ACListModelAdapter getDementiaElderlyAcceptedModel(){
    if(dementiaElderlyAcceptedModel==null){
      dementiaElderlyAcceptedModel = new ACListModelAdapter();
      addDementiaElderlyAcceptedModel();
    }
    return dementiaElderlyAcceptedModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getDementiaElderlyAcceptedItem1(){
    if(dementiaElderlyAcceptedItem1==null){

      dementiaElderlyAcceptedItem1 = new ACRadioButtonItem();

      dementiaElderlyAcceptedItem1.setText("なし");

      dementiaElderlyAcceptedItem1.setGroup(getDementiaElderlyAccepted());

      dementiaElderlyAcceptedItem1.setConstraints(VRLayout.FLOW);

      addDementiaElderlyAcceptedItem1();
    }
    return dementiaElderlyAcceptedItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getDementiaElderlyAcceptedItem2(){
    if(dementiaElderlyAcceptedItem2==null){

      dementiaElderlyAcceptedItem2 = new ACRadioButtonItem();

      dementiaElderlyAcceptedItem2.setText("あり");

      dementiaElderlyAcceptedItem2.setGroup(getDementiaElderlyAccepted());

      dementiaElderlyAcceptedItem2.setConstraints(VRLayout.FLOW);

      addDementiaElderlyAcceptedItem2();
    }
    return dementiaElderlyAcceptedItem2;

  }

  /**
   * 提供時間コンテナを取得します。
   * @return 提供時間コンテナ
   */
  public ACBackLabelContainer getTsuusyoKaigoTimeContena(){
    if(tsuusyoKaigoTimeContena==null){

      tsuusyoKaigoTimeContena = new ACBackLabelContainer();

      tsuusyoKaigoTimeContena.setFollowChildEnabled(true);

      addTsuusyoKaigoTimeContena();
    }
    return tsuusyoKaigoTimeContena;

  }

  /**
   * 開始時刻コンボを取得します。
   * @return 開始時刻コンボ
   */
  public ACTimeComboBox getTsuusyoKaigoTimeBeginTime(){
    if(tsuusyoKaigoTimeBeginTime==null){

      tsuusyoKaigoTimeBeginTime = new ACTimeComboBox();

      getTsuusyoKaigoTimeBeginTimeContainer().setText("開始時刻");

      tsuusyoKaigoTimeBeginTime.setBindPath("3");

      tsuusyoKaigoTimeBeginTime.setModelBindPath("3");

      tsuusyoKaigoTimeBeginTime.setRenderBindPath("CONTENT");

      tsuusyoKaigoTimeBeginTime.setModel(getTsuusyoKaigoTimeBeginTimeModel());

      addTsuusyoKaigoTimeBeginTime();
    }
    return tsuusyoKaigoTimeBeginTime;

  }

  /**
   * 開始時刻コンボコンテナを取得します。
   * @return 開始時刻コンボコンテナ
   */
  protected ACLabelContainer getTsuusyoKaigoTimeBeginTimeContainer(){
    if(tsuusyoKaigoTimeBeginTimeContainer==null){
      tsuusyoKaigoTimeBeginTimeContainer = new ACLabelContainer();
      tsuusyoKaigoTimeBeginTimeContainer.setFollowChildEnabled(true);
      tsuusyoKaigoTimeBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoTimeBeginTimeContainer.add(getTsuusyoKaigoTimeBeginTime(), null);
    }
    return tsuusyoKaigoTimeBeginTimeContainer;
  }

  /**
   * 開始時刻コンボモデルを取得します。
   * @return 開始時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getTsuusyoKaigoTimeBeginTimeModel(){
    if(tsuusyoKaigoTimeBeginTimeModel==null){
      tsuusyoKaigoTimeBeginTimeModel = new ACComboBoxModelAdapter();
      addTsuusyoKaigoTimeBeginTimeModel();
    }
    return tsuusyoKaigoTimeBeginTimeModel;
  }

  /**
   * 終了時刻コンボを取得します。
   * @return 終了時刻コンボ
   */
  public ACTimeComboBox getTsuusyoKaigoTimeEndTime(){
    if(tsuusyoKaigoTimeEndTime==null){

      tsuusyoKaigoTimeEndTime = new ACTimeComboBox();

      getTsuusyoKaigoTimeEndTimeContainer().setText("終了時刻");

      tsuusyoKaigoTimeEndTime.setBindPath("4");

      tsuusyoKaigoTimeEndTime.setModelBindPath("4");

      tsuusyoKaigoTimeEndTime.setRenderBindPath("CONTENT");

      tsuusyoKaigoTimeEndTime.setModel(getTsuusyoKaigoTimeEndTimeModel());

      addTsuusyoKaigoTimeEndTime();
    }
    return tsuusyoKaigoTimeEndTime;

  }

  /**
   * 終了時刻コンボコンテナを取得します。
   * @return 終了時刻コンボコンテナ
   */
  protected ACLabelContainer getTsuusyoKaigoTimeEndTimeContainer(){
    if(tsuusyoKaigoTimeEndTimeContainer==null){
      tsuusyoKaigoTimeEndTimeContainer = new ACLabelContainer();
      tsuusyoKaigoTimeEndTimeContainer.setFollowChildEnabled(true);
      tsuusyoKaigoTimeEndTimeContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoTimeEndTimeContainer.add(getTsuusyoKaigoTimeEndTime(), null);
    }
    return tsuusyoKaigoTimeEndTimeContainer;
  }

  /**
   * 終了時刻コンボモデルを取得します。
   * @return 終了時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getTsuusyoKaigoTimeEndTimeModel(){
    if(tsuusyoKaigoTimeEndTimeModel==null){
      tsuusyoKaigoTimeEndTimeModel = new ACComboBoxModelAdapter();
      addTsuusyoKaigoTimeEndTimeModel();
    }
    return tsuusyoKaigoTimeEndTimeModel;
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

      tab2.setLabelMargin(0);

      tab2.setVgap(0);

      addTab2();
    }
    return tab2;

  }

  /**
   * 若年性認知症利用者受入加算を取得します。
   * @return 若年性認知症利用者受入加算
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("若年性認知症利用者受入加算");

      youngDementiaPatinetAddRadioGroup.setBindPath("1780109");

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
   * 栄養改善加算を取得します。
   * @return 栄養改善加算
   */
  public ACValueArrayRadioButtonGroup getTsuusyoKaigoNourishmentManagementAddRadio(){
    if(tsuusyoKaigoNourishmentManagementAddRadio==null){

      tsuusyoKaigoNourishmentManagementAddRadio = new ACValueArrayRadioButtonGroup();

      getTsuusyoKaigoNourishmentManagementAddRadioContainer().setText("栄養改善加算");

      tsuusyoKaigoNourishmentManagementAddRadio.setBindPath("1780110");

      tsuusyoKaigoNourishmentManagementAddRadio.setUseClearButton(false);

      tsuusyoKaigoNourishmentManagementAddRadio.setModel(getTsuusyoKaigoNourishmentManagementAddRadioModel());

      tsuusyoKaigoNourishmentManagementAddRadio.setValues(new int[]{1,2});

      addTsuusyoKaigoNourishmentManagementAddRadio();
    }
    return tsuusyoKaigoNourishmentManagementAddRadio;

  }

  /**
   * 栄養改善加算コンテナを取得します。
   * @return 栄養改善加算コンテナ
   */
  protected ACLabelContainer getTsuusyoKaigoNourishmentManagementAddRadioContainer(){
    if(tsuusyoKaigoNourishmentManagementAddRadioContainer==null){
      tsuusyoKaigoNourishmentManagementAddRadioContainer = new ACLabelContainer();
      tsuusyoKaigoNourishmentManagementAddRadioContainer.setFollowChildEnabled(true);
      tsuusyoKaigoNourishmentManagementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoNourishmentManagementAddRadioContainer.add(getTsuusyoKaigoNourishmentManagementAddRadio(), null);
    }
    return tsuusyoKaigoNourishmentManagementAddRadioContainer;
  }

  /**
   * 栄養改善加算モデルを取得します。
   * @return 栄養改善加算モデル
   */
  protected ACListModelAdapter getTsuusyoKaigoNourishmentManagementAddRadioModel(){
    if(tsuusyoKaigoNourishmentManagementAddRadioModel==null){
      tsuusyoKaigoNourishmentManagementAddRadioModel = new ACListModelAdapter();
      addTsuusyoKaigoNourishmentManagementAddRadioModel();
    }
    return tsuusyoKaigoNourishmentManagementAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTsuusyoKaigoNourishmentManagementAddRadioItem1(){
    if(tsuusyoKaigoNourishmentManagementAddRadioItem1==null){

      tsuusyoKaigoNourishmentManagementAddRadioItem1 = new ACRadioButtonItem();

      tsuusyoKaigoNourishmentManagementAddRadioItem1.setText("なし");

      tsuusyoKaigoNourishmentManagementAddRadioItem1.setGroup(getTsuusyoKaigoNourishmentManagementAddRadio());

      tsuusyoKaigoNourishmentManagementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoNourishmentManagementAddRadioItem1();
    }
    return tsuusyoKaigoNourishmentManagementAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getTsuusyoKaigoNourishmentManagementAddRadioItem2(){
    if(tsuusyoKaigoNourishmentManagementAddRadioItem2==null){

      tsuusyoKaigoNourishmentManagementAddRadioItem2 = new ACRadioButtonItem();

      tsuusyoKaigoNourishmentManagementAddRadioItem2.setText("あり");

      tsuusyoKaigoNourishmentManagementAddRadioItem2.setGroup(getTsuusyoKaigoNourishmentManagementAddRadio());

      tsuusyoKaigoNourishmentManagementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoNourishmentManagementAddRadioItem2();
    }
    return tsuusyoKaigoNourishmentManagementAddRadioItem2;

  }

  /**
   * 口腔機能向上加算を取得します。
   * @return 口腔機能向上加算
   */
  public ACValueArrayRadioButtonGroup getTsuusyoKaigoMouthFunctionAddRadio(){
    if(tsuusyoKaigoMouthFunctionAddRadio==null){

      tsuusyoKaigoMouthFunctionAddRadio = new ACValueArrayRadioButtonGroup();

      getTsuusyoKaigoMouthFunctionAddRadioContainer().setText("口腔機能向上加算");

      tsuusyoKaigoMouthFunctionAddRadio.setBindPath("1780111");

      tsuusyoKaigoMouthFunctionAddRadio.setUseClearButton(false);

      tsuusyoKaigoMouthFunctionAddRadio.setModel(getTsuusyoKaigoMouthFunctionAddRadioModel());

      tsuusyoKaigoMouthFunctionAddRadio.setValues(new int[]{1,2});

      addTsuusyoKaigoMouthFunctionAddRadio();
    }
    return tsuusyoKaigoMouthFunctionAddRadio;

  }

  /**
   * 口腔機能向上加算コンテナを取得します。
   * @return 口腔機能向上加算コンテナ
   */
  protected ACLabelContainer getTsuusyoKaigoMouthFunctionAddRadioContainer(){
    if(tsuusyoKaigoMouthFunctionAddRadioContainer==null){
      tsuusyoKaigoMouthFunctionAddRadioContainer = new ACLabelContainer();
      tsuusyoKaigoMouthFunctionAddRadioContainer.setFollowChildEnabled(true);
      tsuusyoKaigoMouthFunctionAddRadioContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoMouthFunctionAddRadioContainer.add(getTsuusyoKaigoMouthFunctionAddRadio(), null);
    }
    return tsuusyoKaigoMouthFunctionAddRadioContainer;
  }

  /**
   * 口腔機能向上加算モデルを取得します。
   * @return 口腔機能向上加算モデル
   */
  protected ACListModelAdapter getTsuusyoKaigoMouthFunctionAddRadioModel(){
    if(tsuusyoKaigoMouthFunctionAddRadioModel==null){
      tsuusyoKaigoMouthFunctionAddRadioModel = new ACListModelAdapter();
      addTsuusyoKaigoMouthFunctionAddRadioModel();
    }
    return tsuusyoKaigoMouthFunctionAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTsuusyoKaigoMouthFunctionAddRadioItem1(){
    if(tsuusyoKaigoMouthFunctionAddRadioItem1==null){

      tsuusyoKaigoMouthFunctionAddRadioItem1 = new ACRadioButtonItem();

      tsuusyoKaigoMouthFunctionAddRadioItem1.setText("なし");

      tsuusyoKaigoMouthFunctionAddRadioItem1.setGroup(getTsuusyoKaigoMouthFunctionAddRadio());

      tsuusyoKaigoMouthFunctionAddRadioItem1.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoMouthFunctionAddRadioItem1();
    }
    return tsuusyoKaigoMouthFunctionAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getTsuusyoKaigoMouthFunctionAddRadioItem2(){
    if(tsuusyoKaigoMouthFunctionAddRadioItem2==null){

      tsuusyoKaigoMouthFunctionAddRadioItem2 = new ACRadioButtonItem();

      tsuusyoKaigoMouthFunctionAddRadioItem2.setText("あり");

      tsuusyoKaigoMouthFunctionAddRadioItem2.setGroup(getTsuusyoKaigoMouthFunctionAddRadio());

      tsuusyoKaigoMouthFunctionAddRadioItem2.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoMouthFunctionAddRadioItem2();
    }
    return tsuusyoKaigoMouthFunctionAddRadioItem2;

  }

  /**
   * 個別送迎体制強化加算を取得します。
   * @return 個別送迎体制強化加算
   */
  public ACValueArrayRadioButtonGroup getIndividualPickupSystem(){
    if(individualPickupSystem==null){

      individualPickupSystem = new ACValueArrayRadioButtonGroup();

      getIndividualPickupSystemContainer().setText("個別送迎体制強化加算");

      individualPickupSystem.setBindPath("1780112");

      individualPickupSystem.setUseClearButton(false);

      individualPickupSystem.setModel(getIndividualPickupSystemModel());

      individualPickupSystem.setValues(new int[]{1,2});

      addIndividualPickupSystem();
    }
    return individualPickupSystem;

  }

  /**
   * 個別送迎体制強化加算コンテナを取得します。
   * @return 個別送迎体制強化加算コンテナ
   */
  protected ACLabelContainer getIndividualPickupSystemContainer(){
    if(individualPickupSystemContainer==null){
      individualPickupSystemContainer = new ACLabelContainer();
      individualPickupSystemContainer.setFollowChildEnabled(true);
      individualPickupSystemContainer.setVAlignment(VRLayout.CENTER);
      individualPickupSystemContainer.add(getIndividualPickupSystem(), null);
    }
    return individualPickupSystemContainer;
  }

  /**
   * 個別送迎体制強化加算モデルを取得します。
   * @return 個別送迎体制強化加算モデル
   */
  protected ACListModelAdapter getIndividualPickupSystemModel(){
    if(individualPickupSystemModel==null){
      individualPickupSystemModel = new ACListModelAdapter();
      addIndividualPickupSystemModel();
    }
    return individualPickupSystemModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getIndividualPickupSystemItem1(){
    if(individualPickupSystemItem1==null){

      individualPickupSystemItem1 = new ACRadioButtonItem();

      individualPickupSystemItem1.setText("なし");

      individualPickupSystemItem1.setGroup(getIndividualPickupSystem());

      addIndividualPickupSystemItem1();
    }
    return individualPickupSystemItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getIndividualPickupSystemItem2(){
    if(individualPickupSystemItem2==null){

      individualPickupSystemItem2 = new ACRadioButtonItem();

      individualPickupSystemItem2.setText("あり");

      individualPickupSystemItem2.setGroup(getIndividualPickupSystem());

      addIndividualPickupSystemItem2();
    }
    return individualPickupSystemItem2;

  }

  /**
   * 入浴介助体制強化加算を取得します。
   * @return 入浴介助体制強化加算
   */
  public ACValueArrayRadioButtonGroup getBathingAssistanceSystem(){
    if(bathingAssistanceSystem==null){

      bathingAssistanceSystem = new ACValueArrayRadioButtonGroup();

      getBathingAssistanceSystemContainer().setText("入浴介助体制強化加算");

      bathingAssistanceSystem.setBindPath("1780113");

      bathingAssistanceSystem.setUseClearButton(false);

      bathingAssistanceSystem.setModel(getBathingAssistanceSystemModel());

      bathingAssistanceSystem.setValues(new int[]{1,2});

      addBathingAssistanceSystem();
    }
    return bathingAssistanceSystem;

  }

  /**
   * 入浴介助体制強化加算コンテナを取得します。
   * @return 入浴介助体制強化加算コンテナ
   */
  protected ACLabelContainer getBathingAssistanceSystemContainer(){
    if(bathingAssistanceSystemContainer==null){
      bathingAssistanceSystemContainer = new ACLabelContainer();
      bathingAssistanceSystemContainer.setFollowChildEnabled(true);
      bathingAssistanceSystemContainer.setVAlignment(VRLayout.CENTER);
      bathingAssistanceSystemContainer.add(getBathingAssistanceSystem(), null);
    }
    return bathingAssistanceSystemContainer;
  }

  /**
   * 入浴介助体制強化加算モデルを取得します。
   * @return 入浴介助体制強化加算モデル
   */
  protected ACListModelAdapter getBathingAssistanceSystemModel(){
    if(bathingAssistanceSystemModel==null){
      bathingAssistanceSystemModel = new ACListModelAdapter();
      addBathingAssistanceSystemModel();
    }
    return bathingAssistanceSystemModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getBathingAssistanceSystemItem1(){
    if(bathingAssistanceSystemItem1==null){

      bathingAssistanceSystemItem1 = new ACRadioButtonItem();

      bathingAssistanceSystemItem1.setText("なし");

      bathingAssistanceSystemItem1.setGroup(getBathingAssistanceSystem());

      bathingAssistanceSystemItem1.setConstraints(VRLayout.FLOW);

      addBathingAssistanceSystemItem1();
    }
    return bathingAssistanceSystemItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getBathingAssistanceSystemItem2(){
    if(bathingAssistanceSystemItem2==null){

      bathingAssistanceSystemItem2 = new ACRadioButtonItem();

      bathingAssistanceSystemItem2.setText("あり");

      bathingAssistanceSystemItem2.setGroup(getBathingAssistanceSystem());

      bathingAssistanceSystemItem2.setConstraints(VRLayout.FLOW);

      addBathingAssistanceSystemItem2();
    }
    return bathingAssistanceSystemItem2;

  }

  /**
   * 同一建物居住者へのサービス提供を取得します。
   * @return 同一建物居住者へのサービス提供
   */
  public ACValueArrayRadioButtonGroup getTransportationCallRadioGroup(){
    if(transportationCallRadioGroup==null){

      transportationCallRadioGroup = new ACValueArrayRadioButtonGroup();

      getTransportationCallRadioGroupContainer().setText("同一建物居住者へのサービス提供");

      transportationCallRadioGroup.setBindPath("16");

      transportationCallRadioGroup.setNoSelectIndex(0);

      transportationCallRadioGroup.setUseClearButton(false);

      transportationCallRadioGroup.setModel(getTransportationCallRadioGroupModel());

      transportationCallRadioGroup.setValues(new int[]{1,2});

      addTransportationCallRadioGroup();
    }
    return transportationCallRadioGroup;

  }

  /**
   * 同一建物居住者へのサービス提供コンテナを取得します。
   * @return 同一建物居住者へのサービス提供コンテナ
   */
  protected ACLabelContainer getTransportationCallRadioGroupContainer(){
    if(transportationCallRadioGroupContainer==null){
      transportationCallRadioGroupContainer = new ACLabelContainer();
      transportationCallRadioGroupContainer.setFollowChildEnabled(true);
      transportationCallRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      transportationCallRadioGroupContainer.add(getTransportationCallRadioGroup(), null);
    }
    return transportationCallRadioGroupContainer;
  }

  /**
   * 同一建物居住者へのサービス提供モデルを取得します。
   * @return 同一建物居住者へのサービス提供モデル
   */
  protected ACListModelAdapter getTransportationCallRadioGroupModel(){
    if(transportationCallRadioGroupModel==null){
      transportationCallRadioGroupModel = new ACListModelAdapter();
      addTransportationCallRadioGroupModel();
    }
    return transportationCallRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTransportationCallRadioItem1(){
    if(transportationCallRadioItem1==null){

      transportationCallRadioItem1 = new ACRadioButtonItem();

      transportationCallRadioItem1.setText("なし");

      transportationCallRadioItem1.setGroup(getTransportationCallRadioGroup());

      transportationCallRadioItem1.setConstraints(VRLayout.FLOW);

      addTransportationCallRadioItem1();
    }
    return transportationCallRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getTransportationCallRadioItem2(){
    if(transportationCallRadioItem2==null){

      transportationCallRadioItem2 = new ACRadioButtonItem();

      transportationCallRadioItem2.setText("あり");

      transportationCallRadioItem2.setGroup(getTransportationCallRadioGroup());

      transportationCallRadioItem2.setConstraints(VRLayout.FLOW);

      addTransportationCallRadioItem2();
    }
    return transportationCallRadioItem2;

  }

  /**
   * 送迎区分を取得します。
   * @return 送迎区分
   */
  public ACValueArrayRadioButtonGroup getMeetingAndSendingOff(){
    if(MeetingAndSendingOff==null){

      MeetingAndSendingOff = new ACValueArrayRadioButtonGroup();

      getMeetingAndSendingOffContainer().setText("送迎減算");

      MeetingAndSendingOff.setBindPath("18");

      MeetingAndSendingOff.setUseClearButton(false);

      MeetingAndSendingOff.setModel(getMeetingAndSendingOffModel());

      MeetingAndSendingOff.setValues(new int[]{1,2,3});

      addMeetingAndSendingOff();
    }
    return MeetingAndSendingOff;

  }

  /**
   * 送迎区分コンテナを取得します。
   * @return 送迎区分コンテナ
   */
  protected ACLabelContainer getMeetingAndSendingOffContainer(){
    if(MeetingAndSendingOffContainer==null){
      MeetingAndSendingOffContainer = new ACLabelContainer();
      MeetingAndSendingOffContainer.setFollowChildEnabled(true);
      MeetingAndSendingOffContainer.setVAlignment(VRLayout.CENTER);
      MeetingAndSendingOffContainer.add(getMeetingAndSendingOff(), null);
    }
    return MeetingAndSendingOffContainer;
  }

  /**
   * 送迎区分モデルを取得します。
   * @return 送迎区分モデル
   */
  protected ACListModelAdapter getMeetingAndSendingOffModel(){
    if(MeetingAndSendingOffModel==null){
      MeetingAndSendingOffModel = new ACListModelAdapter();
      addMeetingAndSendingOffModel();
    }
    return MeetingAndSendingOffModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMeetingAndSendingOffRoundTrip(){
    if(MeetingAndSendingOffRoundTrip==null){

      MeetingAndSendingOffRoundTrip = new ACRadioButtonItem();

      MeetingAndSendingOffRoundTrip.setText("なし");

      MeetingAndSendingOffRoundTrip.setGroup(getMeetingAndSendingOff());

      MeetingAndSendingOffRoundTrip.setConstraints(VRLayout.FLOW);

      addMeetingAndSendingOffRoundTrip();
    }
    return MeetingAndSendingOffRoundTrip;

  }

  /**
   * 片道減算を取得します。
   * @return 片道減算
   */
  public ACRadioButtonItem getMeetingAndSendingOffOneWay(){
    if(MeetingAndSendingOffOneWay==null){

      MeetingAndSendingOffOneWay = new ACRadioButtonItem();

      MeetingAndSendingOffOneWay.setText("片道減算");

      MeetingAndSendingOffOneWay.setGroup(getMeetingAndSendingOff());

      MeetingAndSendingOffOneWay.setConstraints(VRLayout.FLOW);

      addMeetingAndSendingOffOneWay();
    }
    return MeetingAndSendingOffOneWay;

  }

  /**
   * 往復減算を取得します。
   * @return 往復減算
   */
  public ACRadioButtonItem getMeetingAndSendingOffNone(){
    if(MeetingAndSendingOffNone==null){

      MeetingAndSendingOffNone = new ACRadioButtonItem();

      MeetingAndSendingOffNone.setText("往復減算");

      MeetingAndSendingOffNone.setGroup(getMeetingAndSendingOff());

      MeetingAndSendingOffNone.setConstraints(VRLayout.FLOW);

      addMeetingAndSendingOffNone();
    }
    return MeetingAndSendingOffNone;

  }

  /**
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1780114");

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,2,3,4,5});

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
   * 生活機能向上連携加算を取得します。
   * @return 生活機能向上連携加算
   */
  public ACValueArrayRadioButtonGroup getImprovementCollaboration(){
    if(improvementCollaboration==null){

      improvementCollaboration = new ACValueArrayRadioButtonGroup();

      getImprovementCollaborationContainer().setText("生活機能向上連携加算");

      improvementCollaboration.setBindPath("1780116");

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
   * ADL維持等加算を取得します。
   * @return ADL維持等加算
   */
  public ACValueArrayRadioButtonGroup getAdlMaintenanceRadioGroup(){
    if(adlMaintenanceRadioGroup==null){

      adlMaintenanceRadioGroup = new ACValueArrayRadioButtonGroup();

      getAdlMaintenanceRadioGroupContainer().setText("ADL維持等加算");

      adlMaintenanceRadioGroup.setBindPath("1780117");

      adlMaintenanceRadioGroup.setNoSelectIndex(0);

      adlMaintenanceRadioGroup.setUseClearButton(false);

      adlMaintenanceRadioGroup.setModel(getAdlMaintenanceRadioGroupModel());

      adlMaintenanceRadioGroup.setValues(new int[]{1,2,3});

      addAdlMaintenanceRadioGroup();
    }
    return adlMaintenanceRadioGroup;

  }

  /**
   * ADL維持等加算コンテナを取得します。
   * @return ADL維持等加算コンテナ
   */
  protected ACLabelContainer getAdlMaintenanceRadioGroupContainer(){
    if(adlMaintenanceRadioGroupContainer==null){
      adlMaintenanceRadioGroupContainer = new ACLabelContainer();
      adlMaintenanceRadioGroupContainer.setFollowChildEnabled(true);
      adlMaintenanceRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      adlMaintenanceRadioGroupContainer.add(getAdlMaintenanceRadioGroup(), null);
    }
    return adlMaintenanceRadioGroupContainer;
  }

  /**
   * ADL維持等加算モデルを取得します。
   * @return ADL維持等加算モデル
   */
  protected ACListModelAdapter getAdlMaintenanceRadioGroupModel(){
    if(adlMaintenanceRadioGroupModel==null){
      adlMaintenanceRadioGroupModel = new ACListModelAdapter();
      addAdlMaintenanceRadioGroupModel();
    }
    return adlMaintenanceRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getAdlMaintenanceItem1(){
    if(adlMaintenanceItem1==null){

      adlMaintenanceItem1 = new ACRadioButtonItem();

      adlMaintenanceItem1.setText("なし");

      adlMaintenanceItem1.setGroup(getAdlMaintenanceRadioGroup());

      adlMaintenanceItem1.setConstraints(VRLayout.FLOW);

      addAdlMaintenanceItem1();
    }
    return adlMaintenanceItem1;

  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getAdlMaintenanceItem2(){
    if(adlMaintenanceItem2==null){

      adlMaintenanceItem2 = new ACRadioButtonItem();

      adlMaintenanceItem2.setText("I型");

      adlMaintenanceItem2.setGroup(getAdlMaintenanceRadioGroup());

      adlMaintenanceItem2.setConstraints(VRLayout.FLOW);

      addAdlMaintenanceItem2();
    }
    return adlMaintenanceItem2;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getAdlMaintenanceItem3(){
    if(adlMaintenanceItem3==null){

      adlMaintenanceItem3 = new ACRadioButtonItem();

      adlMaintenanceItem3.setText("II型");

      adlMaintenanceItem3.setGroup(getAdlMaintenanceRadioGroup());

      adlMaintenanceItem3.setConstraints(VRLayout.FLOW);

      addAdlMaintenanceItem3();
    }
    return adlMaintenanceItem3;

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

      tab3.setLabelMargin(0);

      tab3.setVgap(0);

      addTab3();
    }
    return tab3;

  }

  /**
   * 栄養スクリーニング加算を取得します。
   * @return 栄養スクリーニング加算
   */
  public ACValueArrayRadioButtonGroup getNutritionScreening(){
    if(nutritionScreening==null){

      nutritionScreening = new ACValueArrayRadioButtonGroup();

      getNutritionScreeningContainer().setText("栄養スクリーニング加算");

      nutritionScreening.setBindPath("1780118");

      nutritionScreening.setUseClearButton(false);

      nutritionScreening.setModel(getNutritionScreeningModel());

      nutritionScreening.setValues(new int[]{1,2});

      addNutritionScreening();
    }
    return nutritionScreening;

  }

  /**
   * 栄養スクリーニング加算コンテナを取得します。
   * @return 栄養スクリーニング加算コンテナ
   */
  protected ACLabelContainer getNutritionScreeningContainer(){
    if(nutritionScreeningContainer==null){
      nutritionScreeningContainer = new ACLabelContainer();
      nutritionScreeningContainer.setFollowChildEnabled(true);
      nutritionScreeningContainer.setVAlignment(VRLayout.CENTER);
      nutritionScreeningContainer.add(getNutritionScreening(), null);
    }
    return nutritionScreeningContainer;
  }

  /**
   * 栄養スクリーニング加算モデルを取得します。
   * @return 栄養スクリーニング加算モデル
   */
  protected ACListModelAdapter getNutritionScreeningModel(){
    if(nutritionScreeningModel==null){
      nutritionScreeningModel = new ACListModelAdapter();
      addNutritionScreeningModel();
    }
    return nutritionScreeningModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNutritionScreeningItem1(){
    if(nutritionScreeningItem1==null){

      nutritionScreeningItem1 = new ACRadioButtonItem();

      nutritionScreeningItem1.setText("なし");

      nutritionScreeningItem1.setGroup(getNutritionScreening());

      addNutritionScreeningItem1();
    }
    return nutritionScreeningItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getNutritionScreeningItem2(){
    if(nutritionScreeningItem2==null){

      nutritionScreeningItem2 = new ACRadioButtonItem();

      nutritionScreeningItem2.setText("あり");

      nutritionScreeningItem2.setGroup(getNutritionScreening());

      addNutritionScreeningItem2();
    }
    return nutritionScreeningItem2;

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

      symbiosisTypeRadio.setValues(new int[]{1,5,6,7,8});

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
   * 生活介護を取得します。
   * @return 生活介護
   */
  public ACRadioButtonItem getSymbiosisTypeRadioItem2(){
    if(symbiosisTypeRadioItem2==null){

      symbiosisTypeRadioItem2 = new ACRadioButtonItem();

      symbiosisTypeRadioItem2.setText("生活介護");

      symbiosisTypeRadioItem2.setGroup(getSymbiosisTypeRadio());

      symbiosisTypeRadioItem2.setConstraints(VRLayout.FLOW);

      addSymbiosisTypeRadioItem2();
    }
    return symbiosisTypeRadioItem2;

  }

  /**
   * 自立訓練を取得します。
   * @return 自立訓練
   */
  public ACRadioButtonItem getSymbiosisTypeRadioItem3(){
    if(symbiosisTypeRadioItem3==null){

      symbiosisTypeRadioItem3 = new ACRadioButtonItem();

      symbiosisTypeRadioItem3.setText("自立訓練");

      symbiosisTypeRadioItem3.setGroup(getSymbiosisTypeRadio());

      symbiosisTypeRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addSymbiosisTypeRadioItem3();
    }
    return symbiosisTypeRadioItem3;

  }

  /**
   * 児童発達支援を取得します。
   * @return 児童発達支援
   */
  public ACRadioButtonItem getSymbiosisTypeRadioItem4(){
    if(symbiosisTypeRadioItem4==null){

      symbiosisTypeRadioItem4 = new ACRadioButtonItem();

      symbiosisTypeRadioItem4.setText("児童発達支援");

      symbiosisTypeRadioItem4.setGroup(getSymbiosisTypeRadio());

      symbiosisTypeRadioItem4.setConstraints(VRLayout.FLOW);

      addSymbiosisTypeRadioItem4();
    }
    return symbiosisTypeRadioItem4;

  }

  /**
   * 放課後等デイを取得します。
   * @return 放課後等デイ
   */
  public ACRadioButtonItem getSymbiosisTypeRadioItem5(){
    if(symbiosisTypeRadioItem5==null){

      symbiosisTypeRadioItem5 = new ACRadioButtonItem();

      symbiosisTypeRadioItem5.setText("放課後等デイ");

      symbiosisTypeRadioItem5.setGroup(getSymbiosisTypeRadio());

      symbiosisTypeRadioItem5.setConstraints(VRLayout.FLOW);

      addSymbiosisTypeRadioItem5();
    }
    return symbiosisTypeRadioItem5;

  }

  /**
   * 生活相談員配置等加算を取得します。
   * @return 生活相談員配置等加算
   */
  public ACValueArrayRadioButtonGroup getDeploymentLifeCounselor(){
    if(deploymentLifeCounselor==null){

      deploymentLifeCounselor = new ACValueArrayRadioButtonGroup();

      getDeploymentLifeCounselorContainer().setText("生活相談員配置等加算");

      deploymentLifeCounselor.setBindPath("1780115");

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
   * コンストラクタです。
   */
  public QS001_17811_201804Design() {

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

    this.add(getTsuusyoKaigoPatterns(), VRLayout.CLIENT);

  }

  /**
   * 地域密着型通所介護パターン領域に内部項目を追加します。
   */
  protected void addTsuusyoKaigoPatterns(){

    tsuusyoKaigoPatterns.addTab("1", getTab1());

    tsuusyoKaigoPatterns.addTab("2", getTab2());

    tsuusyoKaigoPatterns.addTab("3", getTab3());

  }

  /**
   * タブ1に内部項目を追加します。
   */
  protected void addTab1(){

    tab1.add(getTsuusyoKaigoFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTsuusyoKaigoTimeDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTsuusyoKaigoSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getProviderAddMountainousAreaRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTsuusyoKaigoAdditionFunctionBathRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getSevereCareRecipientsAcceptedContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTsuusyoKaigoAdditionFunctionTrainingRadio(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getDementiaElderlyAcceptedContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTsuusyoKaigoTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * 施設等の区分コンテナに内部項目を追加します。
   */
  protected void addTsuusyoKaigoFacilitiesDivisionContainer(){

    tsuusyoKaigoFacilitiesDivisionContainer.add(getTsuusyoKaigoTimeContenaFacilityDivision(), VRLayout.FLOW_RETURN);

  }

  /**
   * 施設等の区分ラジオグループ1に内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeContenaFacilityDivision(){

  }

  /**
   * 施設等の区分ラジオグループ1モデルに内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeContenaFacilityDivisionModel(){

    getTsuusyoKaigoTimeContenaFacilityDivisionItem1().setButtonIndex(1);

    getTsuusyoKaigoTimeContenaFacilityDivisionModel().add(getTsuusyoKaigoTimeContenaFacilityDivisionItem1());

    getTsuusyoKaigoTimeContenaFacilityDivisionItem2().setButtonIndex(2);

    getTsuusyoKaigoTimeContenaFacilityDivisionModel().add(getTsuusyoKaigoTimeContenaFacilityDivisionItem2());

  }

  /**
   * 地域密着型通所介護に内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeContenaFacilityDivisionItem1(){

  }

  /**
   * 療養通所介護に内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeContenaFacilityDivisionItem2(){

  }

  /**
   * 時間区分に内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeDivision(){

  }

  /**
   * 時間区分モデルに内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeDivisionModel(){

  }

  /**
   * 人員減算に内部項目を追加します。
   */
  protected void addTsuusyoKaigoSubtraction(){

  }

  /**
   * 人員減算モデルに内部項目を追加します。
   */
  protected void addTsuusyoKaigoSubtractionModel(){

    getTsuusyoKaigoSubtractionNot().setButtonIndex(1);

    getTsuusyoKaigoSubtractionModel().add(getTsuusyoKaigoSubtractionNot());

    getTsuusyoKaigoSubtractionExcess().setButtonIndex(2);

    getTsuusyoKaigoSubtractionModel().add(getTsuusyoKaigoSubtractionExcess());

    getTsuusyoKaigoSubtractionLack().setButtonIndex(3);

    getTsuusyoKaigoSubtractionModel().add(getTsuusyoKaigoSubtractionLack());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTsuusyoKaigoSubtractionNot(){

  }

  /**
   * 定員超過に内部項目を追加します。
   */
  protected void addTsuusyoKaigoSubtractionExcess(){

  }

  /**
   * 看護・介護職員の不足に内部項目を追加します。
   */
  protected void addTsuusyoKaigoSubtractionLack(){

  }

  /**
   * 中山間地域等でのサービス提供加算に内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRadioGroup(){

  }

  /**
   * 中山間地域等でのサービス提供加算モデルに内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRadioGroupModel(){

    getProviderAddMountainousAreaRadioItem1().setButtonIndex(1);

    getProviderAddMountainousAreaRadioGroupModel().add(getProviderAddMountainousAreaRadioItem1());

    getProviderAddMountainousAreaRadioItem2().setButtonIndex(2);

    getProviderAddMountainousAreaRadioGroupModel().add(getProviderAddMountainousAreaRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRadioItem2(){

  }

  /**
   * 入浴加算に内部項目を追加します。
   */
  protected void addTsuusyoKaigoAdditionFunctionBathRadio(){

  }

  /**
   * 入浴加算モデルに内部項目を追加します。
   */
  protected void addTsuusyoKaigoAdditionFunctionBathRadioModel(){

    getTsuusyoKaigoAdditionFunctionBathRadioItem1().setButtonIndex(1);

    getTsuusyoKaigoAdditionFunctionBathRadioModel().add(getTsuusyoKaigoAdditionFunctionBathRadioItem1());

    getTsuusyoKaigoAdditionFunctionBathRadioItem2().setButtonIndex(2);

    getTsuusyoKaigoAdditionFunctionBathRadioModel().add(getTsuusyoKaigoAdditionFunctionBathRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTsuusyoKaigoAdditionFunctionBathRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addTsuusyoKaigoAdditionFunctionBathRadioItem2(){

  }

  /**
   * 中重度者ケア体制加算ラジオグループに内部項目を追加します。
   */
  protected void addSevereCareRecipientsAccepted(){

  }

  /**
   * 中重度者ケア体制加算ラジオグループモデルに内部項目を追加します。
   */
  protected void addSevereCareRecipientsAcceptedModel(){

    getSevereCareRecipientsAcceptedItem1().setButtonIndex(1);

    getSevereCareRecipientsAcceptedModel().add(getSevereCareRecipientsAcceptedItem1());

    getSevereCareRecipientsAcceptedItem2().setButtonIndex(2);

    getSevereCareRecipientsAcceptedModel().add(getSevereCareRecipientsAcceptedItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSevereCareRecipientsAcceptedItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addSevereCareRecipientsAcceptedItem2(){

  }

  /**
   * 個別機能訓練指導加算に内部項目を追加します。
   */
  protected void addTsuusyoKaigoAdditionFunctionTrainingRadio(){

    tsuusyoKaigoAdditionFunctionTrainingRadio.add(getTsuusyoKaigoAdditionFunctionTrainingRadioItem1(), VRLayout.FLOW);

    tsuusyoKaigoAdditionFunctionTrainingRadio.add(getTsuusyoKaigoAdditionFunctionTrainingRadioItem2(), VRLayout.FLOW);

  }

  /**
   * 加算型Iに内部項目を追加します。
   */
  protected void addTsuusyoKaigoAdditionFunctionTrainingRadioItem1(){

  }

  /**
   * 加算型IIに内部項目を追加します。
   */
  protected void addTsuusyoKaigoAdditionFunctionTrainingRadioItem2(){

  }

  /**
   * 認知症加算ラジオグループに内部項目を追加します。
   */
  protected void addDementiaElderlyAccepted(){

  }

  /**
   * 認知症加算ラジオグループモデルに内部項目を追加します。
   */
  protected void addDementiaElderlyAcceptedModel(){

    getDementiaElderlyAcceptedItem1().setButtonIndex(1);

    getDementiaElderlyAcceptedModel().add(getDementiaElderlyAcceptedItem1());

    getDementiaElderlyAcceptedItem2().setButtonIndex(2);

    getDementiaElderlyAcceptedModel().add(getDementiaElderlyAcceptedItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addDementiaElderlyAcceptedItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addDementiaElderlyAcceptedItem2(){

  }

  /**
   * 提供時間コンテナに内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeContena(){

    tsuusyoKaigoTimeContena.add(getTsuusyoKaigoTimeBeginTimeContainer(), VRLayout.FLOW);

    tsuusyoKaigoTimeContena.add(getTsuusyoKaigoTimeEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * 開始時刻コンボに内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeBeginTime(){

  }

  /**
   * 開始時刻コンボモデルに内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeBeginTimeModel(){

  }

  /**
   * 終了時刻コンボに内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeEndTime(){

  }

  /**
   * 終了時刻コンボモデルに内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeEndTimeModel(){

  }

  /**
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getTsuusyoKaigoNourishmentManagementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getTsuusyoKaigoMouthFunctionAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getIndividualPickupSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getBathingAssistanceSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getTransportationCallRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getImprovementCollaborationContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getAdlMaintenanceRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * 栄養改善加算に内部項目を追加します。
   */
  protected void addTsuusyoKaigoNourishmentManagementAddRadio(){

  }

  /**
   * 栄養改善加算モデルに内部項目を追加します。
   */
  protected void addTsuusyoKaigoNourishmentManagementAddRadioModel(){

    getTsuusyoKaigoNourishmentManagementAddRadioItem1().setButtonIndex(1);

    getTsuusyoKaigoNourishmentManagementAddRadioModel().add(getTsuusyoKaigoNourishmentManagementAddRadioItem1());

    getTsuusyoKaigoNourishmentManagementAddRadioItem2().setButtonIndex(2);

    getTsuusyoKaigoNourishmentManagementAddRadioModel().add(getTsuusyoKaigoNourishmentManagementAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTsuusyoKaigoNourishmentManagementAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addTsuusyoKaigoNourishmentManagementAddRadioItem2(){

  }

  /**
   * 口腔機能向上加算に内部項目を追加します。
   */
  protected void addTsuusyoKaigoMouthFunctionAddRadio(){

  }

  /**
   * 口腔機能向上加算モデルに内部項目を追加します。
   */
  protected void addTsuusyoKaigoMouthFunctionAddRadioModel(){

    getTsuusyoKaigoMouthFunctionAddRadioItem1().setButtonIndex(1);

    getTsuusyoKaigoMouthFunctionAddRadioModel().add(getTsuusyoKaigoMouthFunctionAddRadioItem1());

    getTsuusyoKaigoMouthFunctionAddRadioItem2().setButtonIndex(2);

    getTsuusyoKaigoMouthFunctionAddRadioModel().add(getTsuusyoKaigoMouthFunctionAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTsuusyoKaigoMouthFunctionAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addTsuusyoKaigoMouthFunctionAddRadioItem2(){

  }

  /**
   * 個別送迎体制強化加算に内部項目を追加します。
   */
  protected void addIndividualPickupSystem(){

  }

  /**
   * 個別送迎体制強化加算モデルに内部項目を追加します。
   */
  protected void addIndividualPickupSystemModel(){

    getIndividualPickupSystemItem1().setButtonIndex(1);

    getIndividualPickupSystemModel().add(getIndividualPickupSystemItem1());

    getIndividualPickupSystemItem2().setButtonIndex(2);

    getIndividualPickupSystemModel().add(getIndividualPickupSystemItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addIndividualPickupSystemItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addIndividualPickupSystemItem2(){

  }

  /**
   * 入浴介助体制強化加算に内部項目を追加します。
   */
  protected void addBathingAssistanceSystem(){

  }

  /**
   * 入浴介助体制強化加算モデルに内部項目を追加します。
   */
  protected void addBathingAssistanceSystemModel(){

    getBathingAssistanceSystemItem1().setButtonIndex(1);

    getBathingAssistanceSystemModel().add(getBathingAssistanceSystemItem1());

    getBathingAssistanceSystemItem2().setButtonIndex(2);

    getBathingAssistanceSystemModel().add(getBathingAssistanceSystemItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addBathingAssistanceSystemItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addBathingAssistanceSystemItem2(){

  }

  /**
   * 同一建物居住者へのサービス提供に内部項目を追加します。
   */
  protected void addTransportationCallRadioGroup(){

  }

  /**
   * 同一建物居住者へのサービス提供モデルに内部項目を追加します。
   */
  protected void addTransportationCallRadioGroupModel(){

    getTransportationCallRadioItem1().setButtonIndex(1);

    getTransportationCallRadioGroupModel().add(getTransportationCallRadioItem1());

    getTransportationCallRadioItem2().setButtonIndex(2);

    getTransportationCallRadioGroupModel().add(getTransportationCallRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTransportationCallRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addTransportationCallRadioItem2(){

  }

  /**
   * 送迎区分に内部項目を追加します。
   */
  protected void addMeetingAndSendingOff(){

  }

  /**
   * 送迎区分モデルに内部項目を追加します。
   */
  protected void addMeetingAndSendingOffModel(){

    getMeetingAndSendingOffRoundTrip().setButtonIndex(1);

    getMeetingAndSendingOffModel().add(getMeetingAndSendingOffRoundTrip());

    getMeetingAndSendingOffOneWay().setButtonIndex(2);

    getMeetingAndSendingOffModel().add(getMeetingAndSendingOffOneWay());

    getMeetingAndSendingOffNone().setButtonIndex(3);

    getMeetingAndSendingOffModel().add(getMeetingAndSendingOffNone());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMeetingAndSendingOffRoundTrip(){

  }

  /**
   * 片道減算に内部項目を追加します。
   */
  protected void addMeetingAndSendingOffOneWay(){

  }

  /**
   * 往復減算に内部項目を追加します。
   */
  protected void addMeetingAndSendingOffNone(){

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

    getServiceAddProvisionStructuralRadioItem5().setButtonIndex(2);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem5());

    getServiceAddProvisionStructuralRadioItem2().setButtonIndex(3);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem2());

    getServiceAddProvisionStructuralRadioItem3().setButtonIndex(4);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem3());

    getServiceAddProvisionStructuralRadioItem4().setButtonIndex(5);

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
   * ADL維持等加算に内部項目を追加します。
   */
  protected void addAdlMaintenanceRadioGroup(){

  }

  /**
   * ADL維持等加算モデルに内部項目を追加します。
   */
  protected void addAdlMaintenanceRadioGroupModel(){

    getAdlMaintenanceItem1().setButtonIndex(1);

    getAdlMaintenanceRadioGroupModel().add(getAdlMaintenanceItem1());

    getAdlMaintenanceItem2().setButtonIndex(2);

    getAdlMaintenanceRadioGroupModel().add(getAdlMaintenanceItem2());

    getAdlMaintenanceItem3().setButtonIndex(3);

    getAdlMaintenanceRadioGroupModel().add(getAdlMaintenanceItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addAdlMaintenanceItem1(){

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addAdlMaintenanceItem2(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addAdlMaintenanceItem3(){

  }

  /**
   * タブ3に内部項目を追加します。
   */
  protected void addTab3(){

    tab3.add(getNutritionScreeningContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getSymbiosisTypeRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getDeploymentLifeCounselorContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 栄養スクリーニング加算に内部項目を追加します。
   */
  protected void addNutritionScreening(){

  }

  /**
   * 栄養スクリーニング加算モデルに内部項目を追加します。
   */
  protected void addNutritionScreeningModel(){

    getNutritionScreeningItem1().setButtonIndex(1);

    getNutritionScreeningModel().add(getNutritionScreeningItem1());

    getNutritionScreeningItem2().setButtonIndex(2);

    getNutritionScreeningModel().add(getNutritionScreeningItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNutritionScreeningItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addNutritionScreeningItem2(){

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

    getSymbiosisTypeRadioItem2().setButtonIndex(5);

    getSymbiosisTypeRadioModel().add(getSymbiosisTypeRadioItem2());

    getSymbiosisTypeRadioItem3().setButtonIndex(6);

    getSymbiosisTypeRadioModel().add(getSymbiosisTypeRadioItem3());

    getSymbiosisTypeRadioItem4().setButtonIndex(7);

    getSymbiosisTypeRadioModel().add(getSymbiosisTypeRadioItem4());

    getSymbiosisTypeRadioItem5().setButtonIndex(8);

    getSymbiosisTypeRadioModel().add(getSymbiosisTypeRadioItem5());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSymbiosisTypeRadioItem1(){

  }

  /**
   * 生活介護に内部項目を追加します。
   */
  protected void addSymbiosisTypeRadioItem2(){

  }

  /**
   * 自立訓練に内部項目を追加します。
   */
  protected void addSymbiosisTypeRadioItem3(){

  }

  /**
   * 児童発達支援に内部項目を追加します。
   */
  protected void addSymbiosisTypeRadioItem4(){

  }

  /**
   * 放課後等デイに内部項目を追加します。
   */
  protected void addSymbiosisTypeRadioItem5(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_17811_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_17811_201804Design getThis() {
    return this;
  }
}
