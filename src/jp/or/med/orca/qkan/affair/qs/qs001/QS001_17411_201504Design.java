
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
 * 作成日: 2015/02/18  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン介護予防認知症対応型通所介護 (QS001_17411_201504)
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
 * サービスパターン介護予防認知症対応型通所介護画面項目デザイン(QS001_17411_201504) 
 */
public class QS001_17411_201504Design extends QS001ServicePanel {
  //GUIコンポーネント

  private JTabbedPane ninchisyoTaioTusyoPatterns;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup providerDivisionRadio;

  private ACLabelContainer providerDivisionRadioContainer;

  private ACListModelAdapter providerDivisionRadioModel;

  private ACRadioButtonItem providerDivisionRadioItem1;

  private ACRadioButtonItem providerDivisionRadioItem2;

  private ACValueArrayRadioButtonGroup divisionRadion;

  private ACLabelContainer divisionRadionContainer;

  private ACListModelAdapter divisionRadionModel;

  private ACRadioButtonItem divisionRadionitem1;

  private ACRadioButtonItem divisionRadionitem2;

  private ACValueArrayRadioButtonGroup timeDivisionRadio;

  private ACLabelContainer timeDivisionRadioContainer;

  private ACListModelAdapter timeDivisionRadioModel;

  private ACRadioButtonItem timeDivisionRadioItem1;

  private ACRadioButtonItem timeDivisionRadioItem2;

  private ACRadioButtonItem timeDivisionRadioItem3;

  private ACRadioButtonItem timeDivisionRadioItem4;

  private ACRadioButtonItem timeDivisionRadioItem5;

  private ACRadioButtonItem timeDivisionRadioItem6;

  private ACRadioButtonItem timeDivisionRadioItem7;

  private ACRadioButtonItem timeDivisionRadioItem8;

  private ACRadioButtonItem timeDivisionRadioItem9;

  private ACValueArrayRadioButtonGroup staffSubtractionRadio;

  private ACLabelContainer staffSubtractionRadioContainer;

  private ACListModelAdapter staffSubtractionRadioModel;

  private ACRadioButtonItem staffSubtractionRadioItem1;

  private ACRadioButtonItem staffSubtractionRadioItem2;

  private ACRadioButtonItem staffSubtractionRadioItem3;

  private ACBackLabelContainer timeContena;

  private ACTimeComboBox beginTime;

  private ACLabelContainer beginTimeContainer;

  private ACComboBoxModelAdapter beginTimeModel;

  private ACTimeComboBox endTime;

  private ACLabelContainer endTimeContainer;

  private ACComboBoxModelAdapter endTimeModel;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup bathCareAddRadio;

  private ACLabelContainer bathCareAddRadioContainer;

  private ACListModelAdapter bathCareAddRadioModel;

  private ACRadioButtonItem bathCareAddRadioItem1;

  private ACRadioButtonItem bathCareAddRadioItem2;

  private ACValueArrayRadioButtonGroup functionTrainingAddRadio;

  private ACLabelContainer functionTrainingAddRadioContainer;

  private ACListModelAdapter functionTrainingAddRadioModel;

  private ACRadioButtonItem functionTrainingAddRadioItem1;

  private ACRadioButtonItem functionTrainingAddRadioItem2;

  private ACValueArrayRadioButtonGroup nourishmentManagementAddRadio;

  private ACLabelContainer nourishmentManagementAddRadioContainer;

  private ACListModelAdapter nourishmentManagementAddRadioModel;

  private ACRadioButtonItem nourishmentManagementAddRadioItem1;

  private ACRadioButtonItem nourishmentManagementAddRadioItem2;

  private ACValueArrayRadioButtonGroup oralFunctionAddRadio;

  private ACLabelContainer oralFunctionAddRadioContainer;

  private ACListModelAdapter oralFunctionAddRadioModel;

  private ACRadioButtonItem oralFunctionAddRadioItem1;

  private ACRadioButtonItem oralFunctionAddRadioItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

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

  //getter

  /**
   * 認知症対応型通所介護パターン領域を取得します。
   * @return 認知症対応型通所介護パターン領域
   */
  public JTabbedPane getNinchisyoTaioTusyoPatterns(){
    if(ninchisyoTaioTusyoPatterns==null){

      ninchisyoTaioTusyoPatterns = new JTabbedPane();

      addNinchisyoTaioTusyoPatterns();
    }
    return ninchisyoTaioTusyoPatterns;

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
   * 施設等の区分1を取得します。
   * @return 施設等の区分1
   */
  public ACValueArrayRadioButtonGroup getProviderDivisionRadio(){
    if(providerDivisionRadio==null){

      providerDivisionRadio = new ACValueArrayRadioButtonGroup();

      getProviderDivisionRadioContainer().setText("施設等の区分1");

      providerDivisionRadio.setBindPath("1740101");

      providerDivisionRadio.setUseClearButton(false);

      providerDivisionRadio.setModel(getProviderDivisionRadioModel());

      providerDivisionRadio.setValues(new int[]{1,2});

      addProviderDivisionRadio();
    }
    return providerDivisionRadio;

  }

  /**
   * 施設等の区分1コンテナを取得します。
   * @return 施設等の区分1コンテナ
   */
  protected ACLabelContainer getProviderDivisionRadioContainer(){
    if(providerDivisionRadioContainer==null){
      providerDivisionRadioContainer = new ACLabelContainer();
      providerDivisionRadioContainer.setFollowChildEnabled(true);
      providerDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      providerDivisionRadioContainer.add(getProviderDivisionRadio(), null);
    }
    return providerDivisionRadioContainer;
  }

  /**
   * 施設等の区分1モデルを取得します。
   * @return 施設等の区分1モデル
   */
  protected ACListModelAdapter getProviderDivisionRadioModel(){
    if(providerDivisionRadioModel==null){
      providerDivisionRadioModel = new ACListModelAdapter();
      addProviderDivisionRadioModel();
    }
    return providerDivisionRadioModel;
  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getProviderDivisionRadioItem1(){
    if(providerDivisionRadioItem1==null){

      providerDivisionRadioItem1 = new ACRadioButtonItem();

      providerDivisionRadioItem1.setText("I型");

      providerDivisionRadioItem1.setGroup(getProviderDivisionRadio());

      providerDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addProviderDivisionRadioItem1();
    }
    return providerDivisionRadioItem1;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getProviderDivisionRadioItem2(){
    if(providerDivisionRadioItem2==null){

      providerDivisionRadioItem2 = new ACRadioButtonItem();

      providerDivisionRadioItem2.setText("II型");

      providerDivisionRadioItem2.setGroup(getProviderDivisionRadio());

      providerDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addProviderDivisionRadioItem2();
    }
    return providerDivisionRadioItem2;

  }

  /**
   * 施設等の区分2を取得します。
   * @return 施設等の区分2
   */
  public ACValueArrayRadioButtonGroup getDivisionRadion(){
    if(divisionRadion==null){

      divisionRadion = new ACValueArrayRadioButtonGroup();

      getDivisionRadionContainer().setText("施設等の区分2");

      divisionRadion.setBindPath("1740102");

      divisionRadion.setUseClearButton(false);

      divisionRadion.setModel(getDivisionRadionModel());

      divisionRadion.setValues(new int[]{1,2});

      addDivisionRadion();
    }
    return divisionRadion;

  }

  /**
   * 施設等の区分2コンテナを取得します。
   * @return 施設等の区分2コンテナ
   */
  protected ACLabelContainer getDivisionRadionContainer(){
    if(divisionRadionContainer==null){
      divisionRadionContainer = new ACLabelContainer();
      divisionRadionContainer.setFollowChildEnabled(true);
      divisionRadionContainer.setVAlignment(VRLayout.CENTER);
      divisionRadionContainer.add(getDivisionRadion(), null);
    }
    return divisionRadionContainer;
  }

  /**
   * 施設等の区分2モデルを取得します。
   * @return 施設等の区分2モデル
   */
  protected ACListModelAdapter getDivisionRadionModel(){
    if(divisionRadionModel==null){
      divisionRadionModel = new ACListModelAdapter();
      addDivisionRadionModel();
    }
    return divisionRadionModel;
  }

  /**
   * 単独型を取得します。
   * @return 単独型
   */
  public ACRadioButtonItem getDivisionRadionitem1(){
    if(divisionRadionitem1==null){

      divisionRadionitem1 = new ACRadioButtonItem();

      divisionRadionitem1.setText("単独型");

      divisionRadionitem1.setGroup(getDivisionRadion());

      divisionRadionitem1.setConstraints(VRLayout.FLOW);

      addDivisionRadionitem1();
    }
    return divisionRadionitem1;

  }

  /**
   * 併設型を取得します。
   * @return 併設型
   */
  public ACRadioButtonItem getDivisionRadionitem2(){
    if(divisionRadionitem2==null){

      divisionRadionitem2 = new ACRadioButtonItem();

      divisionRadionitem2.setText("併設型");

      divisionRadionitem2.setGroup(getDivisionRadion());

      divisionRadionitem2.setConstraints(VRLayout.FLOW);

      addDivisionRadionitem2();
    }
    return divisionRadionitem2;

  }

  /**
   * 時間区分を取得します。
   * @return 時間区分
   */
  public ACValueArrayRadioButtonGroup getTimeDivisionRadio(){
    if(timeDivisionRadio==null){

      timeDivisionRadio = new ACValueArrayRadioButtonGroup();

      getTimeDivisionRadioContainer().setText("時間区分");

      timeDivisionRadio.setBindPath("1740103");

      timeDivisionRadio.setUseClearButton(false);

      timeDivisionRadio.setModel(getTimeDivisionRadioModel());

      timeDivisionRadio.setValues(new int[]{1,2,3,4,5,6,7,8,9});

      addTimeDivisionRadio();
    }
    return timeDivisionRadio;

  }

  /**
   * 時間区分コンテナを取得します。
   * @return 時間区分コンテナ
   */
  protected ACLabelContainer getTimeDivisionRadioContainer(){
    if(timeDivisionRadioContainer==null){
      timeDivisionRadioContainer = new ACLabelContainer();
      timeDivisionRadioContainer.setFollowChildEnabled(true);
      timeDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      timeDivisionRadioContainer.add(getTimeDivisionRadio(), null);
    }
    return timeDivisionRadioContainer;
  }

  /**
   * 時間区分モデルを取得します。
   * @return 時間区分モデル
   */
  protected ACListModelAdapter getTimeDivisionRadioModel(){
    if(timeDivisionRadioModel==null){
      timeDivisionRadioModel = new ACListModelAdapter();
      addTimeDivisionRadioModel();
    }
    return timeDivisionRadioModel;
  }

  /**
   * 2から3時間を取得します。
   * @return 2から3時間
   */
  public ACRadioButtonItem getTimeDivisionRadioItem1(){
    if(timeDivisionRadioItem1==null){

      timeDivisionRadioItem1 = new ACRadioButtonItem();

      timeDivisionRadioItem1.setText("2から3時間");

      timeDivisionRadioItem1.setGroup(getTimeDivisionRadio());

      timeDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addTimeDivisionRadioItem1();
    }
    return timeDivisionRadioItem1;

  }

  /**
   * 3から5時間を取得します。
   * @return 3から5時間
   */
  public ACRadioButtonItem getTimeDivisionRadioItem2(){
    if(timeDivisionRadioItem2==null){

      timeDivisionRadioItem2 = new ACRadioButtonItem();

      timeDivisionRadioItem2.setText("3から5時間");

      timeDivisionRadioItem2.setGroup(getTimeDivisionRadio());

      timeDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addTimeDivisionRadioItem2();
    }
    return timeDivisionRadioItem2;

  }

  /**
   * 5から7時間を取得します。
   * @return 5から7時間
   */
  public ACRadioButtonItem getTimeDivisionRadioItem3(){
    if(timeDivisionRadioItem3==null){

      timeDivisionRadioItem3 = new ACRadioButtonItem();

      timeDivisionRadioItem3.setText("5から7時間");

      timeDivisionRadioItem3.setGroup(getTimeDivisionRadio());

      timeDivisionRadioItem3.setConstraints(VRLayout.FLOW);

      addTimeDivisionRadioItem3();
    }
    return timeDivisionRadioItem3;

  }

  /**
   * 7から9時間を取得します。
   * @return 7から9時間
   */
  public ACRadioButtonItem getTimeDivisionRadioItem4(){
    if(timeDivisionRadioItem4==null){

      timeDivisionRadioItem4 = new ACRadioButtonItem();

      timeDivisionRadioItem4.setText("7から9時間");

      timeDivisionRadioItem4.setGroup(getTimeDivisionRadio());

      timeDivisionRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addTimeDivisionRadioItem4();
    }
    return timeDivisionRadioItem4;

  }

  /**
   * 9から10時間を取得します。
   * @return 9から10時間
   */
  public ACRadioButtonItem getTimeDivisionRadioItem5(){
    if(timeDivisionRadioItem5==null){

      timeDivisionRadioItem5 = new ACRadioButtonItem();

      timeDivisionRadioItem5.setText("9から10時間");

      timeDivisionRadioItem5.setGroup(getTimeDivisionRadio());

      timeDivisionRadioItem5.setConstraints(VRLayout.FLOW);

      addTimeDivisionRadioItem5();
    }
    return timeDivisionRadioItem5;

  }

  /**
   * 10から11時間を取得します。
   * @return 10から11時間
   */
  public ACRadioButtonItem getTimeDivisionRadioItem6(){
    if(timeDivisionRadioItem6==null){

      timeDivisionRadioItem6 = new ACRadioButtonItem();

      timeDivisionRadioItem6.setText("10から11時間");

      timeDivisionRadioItem6.setGroup(getTimeDivisionRadio());

      timeDivisionRadioItem6.setConstraints(VRLayout.FLOW_RETURN);

      addTimeDivisionRadioItem6();
    }
    return timeDivisionRadioItem6;

  }

  /**
   * 11から12時間を取得します。
   * @return 11から12時間
   */
  public ACRadioButtonItem getTimeDivisionRadioItem7(){
    if(timeDivisionRadioItem7==null){

      timeDivisionRadioItem7 = new ACRadioButtonItem();

      timeDivisionRadioItem7.setText("11から12時間");

      timeDivisionRadioItem7.setGroup(getTimeDivisionRadio());

      timeDivisionRadioItem7.setConstraints(VRLayout.FLOW);

      addTimeDivisionRadioItem7();
    }
    return timeDivisionRadioItem7;

  }

  /**
   * 12から13時間を取得します。
   * @return 12から13時間
   */
  public ACRadioButtonItem getTimeDivisionRadioItem8(){
    if(timeDivisionRadioItem8==null){

      timeDivisionRadioItem8 = new ACRadioButtonItem();

      timeDivisionRadioItem8.setText("12から13時間");

      timeDivisionRadioItem8.setGroup(getTimeDivisionRadio());

      timeDivisionRadioItem8.setConstraints(VRLayout.FLOW_RETURN);

      addTimeDivisionRadioItem8();
    }
    return timeDivisionRadioItem8;

  }

  /**
   * 13から14時間を取得します。
   * @return 13から14時間
   */
  public ACRadioButtonItem getTimeDivisionRadioItem9(){
    if(timeDivisionRadioItem9==null){

      timeDivisionRadioItem9 = new ACRadioButtonItem();

      timeDivisionRadioItem9.setText("13から14時間");

      timeDivisionRadioItem9.setGroup(getTimeDivisionRadio());

      timeDivisionRadioItem9.setConstraints(VRLayout.FLOW);

      addTimeDivisionRadioItem9();
    }
    return timeDivisionRadioItem9;

  }

  /**
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACValueArrayRadioButtonGroup getStaffSubtractionRadio(){
    if(staffSubtractionRadio==null){

      staffSubtractionRadio = new ACValueArrayRadioButtonGroup();

      getStaffSubtractionRadioContainer().setText("人員減算");

      staffSubtractionRadio.setBindPath("1740104");

      staffSubtractionRadio.setUseClearButton(false);

      staffSubtractionRadio.setModel(getStaffSubtractionRadioModel());

      staffSubtractionRadio.setValues(new int[]{1,2,3});

      addStaffSubtractionRadio();
    }
    return staffSubtractionRadio;

  }

  /**
   * 人員減算コンテナを取得します。
   * @return 人員減算コンテナ
   */
  protected ACLabelContainer getStaffSubtractionRadioContainer(){
    if(staffSubtractionRadioContainer==null){
      staffSubtractionRadioContainer = new ACLabelContainer();
      staffSubtractionRadioContainer.setFollowChildEnabled(true);
      staffSubtractionRadioContainer.setVAlignment(VRLayout.CENTER);
      staffSubtractionRadioContainer.add(getStaffSubtractionRadio(), null);
    }
    return staffSubtractionRadioContainer;
  }

  /**
   * 人員減算モデルを取得します。
   * @return 人員減算モデル
   */
  protected ACListModelAdapter getStaffSubtractionRadioModel(){
    if(staffSubtractionRadioModel==null){
      staffSubtractionRadioModel = new ACListModelAdapter();
      addStaffSubtractionRadioModel();
    }
    return staffSubtractionRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getStaffSubtractionRadioItem1(){
    if(staffSubtractionRadioItem1==null){

      staffSubtractionRadioItem1 = new ACRadioButtonItem();

      staffSubtractionRadioItem1.setText("なし");

      staffSubtractionRadioItem1.setGroup(getStaffSubtractionRadio());

      staffSubtractionRadioItem1.setConstraints(VRLayout.FLOW);

      addStaffSubtractionRadioItem1();
    }
    return staffSubtractionRadioItem1;

  }

  /**
   * 定員超過を取得します。
   * @return 定員超過
   */
  public ACRadioButtonItem getStaffSubtractionRadioItem2(){
    if(staffSubtractionRadioItem2==null){

      staffSubtractionRadioItem2 = new ACRadioButtonItem();

      staffSubtractionRadioItem2.setText("定員超過");

      staffSubtractionRadioItem2.setGroup(getStaffSubtractionRadio());

      staffSubtractionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addStaffSubtractionRadioItem2();
    }
    return staffSubtractionRadioItem2;

  }

  /**
   * 看護･介護職員が欠員を取得します。
   * @return 看護･介護職員が欠員
   */
  public ACRadioButtonItem getStaffSubtractionRadioItem3(){
    if(staffSubtractionRadioItem3==null){

      staffSubtractionRadioItem3 = new ACRadioButtonItem();

      staffSubtractionRadioItem3.setText("看護・介護職員が欠員");

      staffSubtractionRadioItem3.setGroup(getStaffSubtractionRadio());

      staffSubtractionRadioItem3.setConstraints(VRLayout.FLOW);

      addStaffSubtractionRadioItem3();
    }
    return staffSubtractionRadioItem3;

  }

  /**
   * 提供時間コンテナを取得します。
   * @return 提供時間コンテナ
   */
  public ACBackLabelContainer getTimeContena(){
    if(timeContena==null){

      timeContena = new ACBackLabelContainer();

      timeContena.setFollowChildEnabled(true);

      addTimeContena();
    }
    return timeContena;

  }

  /**
   * 開始時刻コンボを取得します。
   * @return 開始時刻コンボ
   */
  public ACTimeComboBox getBeginTime(){
    if(beginTime==null){

      beginTime = new ACTimeComboBox();

      getBeginTimeContainer().setText("開始時刻");

      beginTime.setBindPath("3");

      beginTime.setModelBindPath("3");

      beginTime.setRenderBindPath("CONTENT");

      beginTime.setModel(getBeginTimeModel());

      addBeginTime();
    }
    return beginTime;

  }

  /**
   * 開始時刻コンボコンテナを取得します。
   * @return 開始時刻コンボコンテナ
   */
  protected ACLabelContainer getBeginTimeContainer(){
    if(beginTimeContainer==null){
      beginTimeContainer = new ACLabelContainer();
      beginTimeContainer.setFollowChildEnabled(true);
      beginTimeContainer.setVAlignment(VRLayout.CENTER);
      beginTimeContainer.add(getBeginTime(), null);
    }
    return beginTimeContainer;
  }

  /**
   * 開始時刻コンボモデルを取得します。
   * @return 開始時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getBeginTimeModel(){
    if(beginTimeModel==null){
      beginTimeModel = new ACComboBoxModelAdapter();
      addBeginTimeModel();
    }
    return beginTimeModel;
  }

  /**
   * 終了時刻コンボを取得します。
   * @return 終了時刻コンボ
   */
  public ACTimeComboBox getEndTime(){
    if(endTime==null){

      endTime = new ACTimeComboBox();

      getEndTimeContainer().setText("終了時刻");

      endTime.setBindPath("4");

      endTime.setModelBindPath("4");

      endTime.setRenderBindPath("CONTENT");

      endTime.setModel(getEndTimeModel());

      addEndTime();
    }
    return endTime;

  }

  /**
   * 終了時刻コンボコンテナを取得します。
   * @return 終了時刻コンボコンテナ
   */
  protected ACLabelContainer getEndTimeContainer(){
    if(endTimeContainer==null){
      endTimeContainer = new ACLabelContainer();
      endTimeContainer.setFollowChildEnabled(true);
      endTimeContainer.setVAlignment(VRLayout.CENTER);
      endTimeContainer.add(getEndTime(), null);
    }
    return endTimeContainer;
  }

  /**
   * 終了時刻コンボモデルを取得します。
   * @return 終了時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getEndTimeModel(){
    if(endTimeModel==null){
      endTimeModel = new ACComboBoxModelAdapter();
      addEndTimeModel();
    }
    return endTimeModel;
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
   * 入浴介助加算を取得します。
   * @return 入浴介助加算
   */
  public ACValueArrayRadioButtonGroup getBathCareAddRadio(){
    if(bathCareAddRadio==null){

      bathCareAddRadio = new ACValueArrayRadioButtonGroup();

      getBathCareAddRadioContainer().setText("入浴介助加算");

      bathCareAddRadio.setBindPath("1740105");

      bathCareAddRadio.setUseClearButton(false);

      bathCareAddRadio.setModel(getBathCareAddRadioModel());

      bathCareAddRadio.setValues(new int[]{1,2});

      addBathCareAddRadio();
    }
    return bathCareAddRadio;

  }

  /**
   * 入浴介助加算コンテナを取得します。
   * @return 入浴介助加算コンテナ
   */
  protected ACLabelContainer getBathCareAddRadioContainer(){
    if(bathCareAddRadioContainer==null){
      bathCareAddRadioContainer = new ACLabelContainer();
      bathCareAddRadioContainer.setFollowChildEnabled(true);
      bathCareAddRadioContainer.setVAlignment(VRLayout.CENTER);
      bathCareAddRadioContainer.add(getBathCareAddRadio(), null);
    }
    return bathCareAddRadioContainer;
  }

  /**
   * 入浴介助加算モデルを取得します。
   * @return 入浴介助加算モデル
   */
  protected ACListModelAdapter getBathCareAddRadioModel(){
    if(bathCareAddRadioModel==null){
      bathCareAddRadioModel = new ACListModelAdapter();
      addBathCareAddRadioModel();
    }
    return bathCareAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getBathCareAddRadioItem1(){
    if(bathCareAddRadioItem1==null){

      bathCareAddRadioItem1 = new ACRadioButtonItem();

      bathCareAddRadioItem1.setText("なし");

      bathCareAddRadioItem1.setGroup(getBathCareAddRadio());

      bathCareAddRadioItem1.setConstraints(VRLayout.FLOW);

      addBathCareAddRadioItem1();
    }
    return bathCareAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getBathCareAddRadioItem2(){
    if(bathCareAddRadioItem2==null){

      bathCareAddRadioItem2 = new ACRadioButtonItem();

      bathCareAddRadioItem2.setText("あり");

      bathCareAddRadioItem2.setGroup(getBathCareAddRadio());

      bathCareAddRadioItem2.setConstraints(VRLayout.FLOW);

      addBathCareAddRadioItem2();
    }
    return bathCareAddRadioItem2;

  }

  /**
   * 個別機能訓練加算を取得します。
   * @return 個別機能訓練加算
   */
  public ACValueArrayRadioButtonGroup getFunctionTrainingAddRadio(){
    if(functionTrainingAddRadio==null){

      functionTrainingAddRadio = new ACValueArrayRadioButtonGroup();

      getFunctionTrainingAddRadioContainer().setText("個別機能訓練加算");

      functionTrainingAddRadio.setBindPath("1740106");

      functionTrainingAddRadio.setUseClearButton(false);

      functionTrainingAddRadio.setModel(getFunctionTrainingAddRadioModel());

      functionTrainingAddRadio.setValues(new int[]{1,2});

      addFunctionTrainingAddRadio();
    }
    return functionTrainingAddRadio;

  }

  /**
   * 個別機能訓練加算コンテナを取得します。
   * @return 個別機能訓練加算コンテナ
   */
  protected ACLabelContainer getFunctionTrainingAddRadioContainer(){
    if(functionTrainingAddRadioContainer==null){
      functionTrainingAddRadioContainer = new ACLabelContainer();
      functionTrainingAddRadioContainer.setFollowChildEnabled(true);
      functionTrainingAddRadioContainer.setVAlignment(VRLayout.CENTER);
      functionTrainingAddRadioContainer.add(getFunctionTrainingAddRadio(), null);
    }
    return functionTrainingAddRadioContainer;
  }

  /**
   * 個別機能訓練加算モデルを取得します。
   * @return 個別機能訓練加算モデル
   */
  protected ACListModelAdapter getFunctionTrainingAddRadioModel(){
    if(functionTrainingAddRadioModel==null){
      functionTrainingAddRadioModel = new ACListModelAdapter();
      addFunctionTrainingAddRadioModel();
    }
    return functionTrainingAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getFunctionTrainingAddRadioItem1(){
    if(functionTrainingAddRadioItem1==null){

      functionTrainingAddRadioItem1 = new ACRadioButtonItem();

      functionTrainingAddRadioItem1.setText("なし");

      functionTrainingAddRadioItem1.setGroup(getFunctionTrainingAddRadio());

      functionTrainingAddRadioItem1.setConstraints(VRLayout.FLOW);

      addFunctionTrainingAddRadioItem1();
    }
    return functionTrainingAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getFunctionTrainingAddRadioItem2(){
    if(functionTrainingAddRadioItem2==null){

      functionTrainingAddRadioItem2 = new ACRadioButtonItem();

      functionTrainingAddRadioItem2.setText("あり");

      functionTrainingAddRadioItem2.setGroup(getFunctionTrainingAddRadio());

      functionTrainingAddRadioItem2.setConstraints(VRLayout.FLOW);

      addFunctionTrainingAddRadioItem2();
    }
    return functionTrainingAddRadioItem2;

  }

  /**
   * 栄養改善加算を取得します。
   * @return 栄養改善加算
   */
  public ACValueArrayRadioButtonGroup getNourishmentManagementAddRadio(){
    if(nourishmentManagementAddRadio==null){

      nourishmentManagementAddRadio = new ACValueArrayRadioButtonGroup();

      getNourishmentManagementAddRadioContainer().setText("栄養改善加算");

      nourishmentManagementAddRadio.setBindPath("1740107");

      nourishmentManagementAddRadio.setUseClearButton(false);

      nourishmentManagementAddRadio.setModel(getNourishmentManagementAddRadioModel());

      nourishmentManagementAddRadio.setValues(new int[]{1,2});

      addNourishmentManagementAddRadio();
    }
    return nourishmentManagementAddRadio;

  }

  /**
   * 栄養改善加算コンテナを取得します。
   * @return 栄養改善加算コンテナ
   */
  protected ACLabelContainer getNourishmentManagementAddRadioContainer(){
    if(nourishmentManagementAddRadioContainer==null){
      nourishmentManagementAddRadioContainer = new ACLabelContainer();
      nourishmentManagementAddRadioContainer.setFollowChildEnabled(true);
      nourishmentManagementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      nourishmentManagementAddRadioContainer.add(getNourishmentManagementAddRadio(), null);
    }
    return nourishmentManagementAddRadioContainer;
  }

  /**
   * 栄養改善加算モデルを取得します。
   * @return 栄養改善加算モデル
   */
  protected ACListModelAdapter getNourishmentManagementAddRadioModel(){
    if(nourishmentManagementAddRadioModel==null){
      nourishmentManagementAddRadioModel = new ACListModelAdapter();
      addNourishmentManagementAddRadioModel();
    }
    return nourishmentManagementAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNourishmentManagementAddRadioItem1(){
    if(nourishmentManagementAddRadioItem1==null){

      nourishmentManagementAddRadioItem1 = new ACRadioButtonItem();

      nourishmentManagementAddRadioItem1.setText("なし");

      nourishmentManagementAddRadioItem1.setGroup(getNourishmentManagementAddRadio());

      nourishmentManagementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addNourishmentManagementAddRadioItem1();
    }
    return nourishmentManagementAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getNourishmentManagementAddRadioItem2(){
    if(nourishmentManagementAddRadioItem2==null){

      nourishmentManagementAddRadioItem2 = new ACRadioButtonItem();

      nourishmentManagementAddRadioItem2.setText("あり");

      nourishmentManagementAddRadioItem2.setGroup(getNourishmentManagementAddRadio());

      nourishmentManagementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addNourishmentManagementAddRadioItem2();
    }
    return nourishmentManagementAddRadioItem2;

  }

  /**
   * 口腔機能向上加算を取得します。
   * @return 口腔機能向上加算
   */
  public ACValueArrayRadioButtonGroup getOralFunctionAddRadio(){
    if(oralFunctionAddRadio==null){

      oralFunctionAddRadio = new ACValueArrayRadioButtonGroup();

      getOralFunctionAddRadioContainer().setText("口腔機能向上加算");

      oralFunctionAddRadio.setBindPath("1740108");

      oralFunctionAddRadio.setUseClearButton(false);

      oralFunctionAddRadio.setModel(getOralFunctionAddRadioModel());

      oralFunctionAddRadio.setValues(new int[]{1,2});

      addOralFunctionAddRadio();
    }
    return oralFunctionAddRadio;

  }

  /**
   * 口腔機能向上加算コンテナを取得します。
   * @return 口腔機能向上加算コンテナ
   */
  protected ACLabelContainer getOralFunctionAddRadioContainer(){
    if(oralFunctionAddRadioContainer==null){
      oralFunctionAddRadioContainer = new ACLabelContainer();
      oralFunctionAddRadioContainer.setFollowChildEnabled(true);
      oralFunctionAddRadioContainer.setVAlignment(VRLayout.CENTER);
      oralFunctionAddRadioContainer.add(getOralFunctionAddRadio(), null);
    }
    return oralFunctionAddRadioContainer;
  }

  /**
   * 口腔機能向上加算モデルを取得します。
   * @return 口腔機能向上加算モデル
   */
  protected ACListModelAdapter getOralFunctionAddRadioModel(){
    if(oralFunctionAddRadioModel==null){
      oralFunctionAddRadioModel = new ACListModelAdapter();
      addOralFunctionAddRadioModel();
    }
    return oralFunctionAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getOralFunctionAddRadioItem1(){
    if(oralFunctionAddRadioItem1==null){

      oralFunctionAddRadioItem1 = new ACRadioButtonItem();

      oralFunctionAddRadioItem1.setText("なし");

      oralFunctionAddRadioItem1.setGroup(getOralFunctionAddRadio());

      oralFunctionAddRadioItem1.setConstraints(VRLayout.FLOW);

      addOralFunctionAddRadioItem1();
    }
    return oralFunctionAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getOralFunctionAddRadioItem2(){
    if(oralFunctionAddRadioItem2==null){

      oralFunctionAddRadioItem2 = new ACRadioButtonItem();

      oralFunctionAddRadioItem2.setText("あり");

      oralFunctionAddRadioItem2.setGroup(getOralFunctionAddRadio());

      oralFunctionAddRadioItem2.setConstraints(VRLayout.FLOW);

      addOralFunctionAddRadioItem2();
    }
    return oralFunctionAddRadioItem2;

  }

  /**
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1740110");

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,4,2,3});

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
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem4(){
    if(serviceAddProvisionStructuralRadioItem4==null){

      serviceAddProvisionStructuralRadioItem4 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem4.setText("Iイ型");

      serviceAddProvisionStructuralRadioItem4.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addServiceAddProvisionStructuralRadioItem4();
    }
    return serviceAddProvisionStructuralRadioItem4;

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
   * 若年性認知症利用者受入加算を取得します。
   * @return 若年性認知症利用者受入加算
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("若年性認知症利用者受入加算");

      youngDementiaPatinetAddRadioGroup.setBindPath("1740109");

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
   * コンストラクタです。
   */
  public QS001_17411_201504Design() {

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

    this.add(getNinchisyoTaioTusyoPatterns(), VRLayout.CLIENT);

  }

  /**
   * 認知症対応型通所介護パターン領域に内部項目を追加します。
   */
  protected void addNinchisyoTaioTusyoPatterns(){

    ninchisyoTaioTusyoPatterns.addTab("1", getTab1());

    ninchisyoTaioTusyoPatterns.addTab("2", getTab2());

  }

  /**
   * タブ1に内部項目を追加します。
   */
  protected void addTab1(){

    tab1.add(getProviderDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getDivisionRadionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTimeDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getStaffSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * 施設等の区分1に内部項目を追加します。
   */
  protected void addProviderDivisionRadio(){

  }

  /**
   * 施設等の区分1モデルに内部項目を追加します。
   */
  protected void addProviderDivisionRadioModel(){

    getProviderDivisionRadioItem1().setButtonIndex(1);

    getProviderDivisionRadioModel().add(getProviderDivisionRadioItem1());

    getProviderDivisionRadioItem2().setButtonIndex(2);

    getProviderDivisionRadioModel().add(getProviderDivisionRadioItem2());

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addProviderDivisionRadioItem1(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addProviderDivisionRadioItem2(){

  }

  /**
   * 施設等の区分2に内部項目を追加します。
   */
  protected void addDivisionRadion(){

  }

  /**
   * 施設等の区分2モデルに内部項目を追加します。
   */
  protected void addDivisionRadionModel(){

    getDivisionRadionitem1().setButtonIndex(1);

    getDivisionRadionModel().add(getDivisionRadionitem1());

    getDivisionRadionitem2().setButtonIndex(2);

    getDivisionRadionModel().add(getDivisionRadionitem2());

  }

  /**
   * 単独型に内部項目を追加します。
   */
  protected void addDivisionRadionitem1(){

  }

  /**
   * 併設型に内部項目を追加します。
   */
  protected void addDivisionRadionitem2(){

  }

  /**
   * 時間区分に内部項目を追加します。
   */
  protected void addTimeDivisionRadio(){

  }

  /**
   * 時間区分モデルに内部項目を追加します。
   */
  protected void addTimeDivisionRadioModel(){

    getTimeDivisionRadioItem1().setButtonIndex(1);

    getTimeDivisionRadioModel().add(getTimeDivisionRadioItem1());

    getTimeDivisionRadioItem2().setButtonIndex(2);

    getTimeDivisionRadioModel().add(getTimeDivisionRadioItem2());

    getTimeDivisionRadioItem3().setButtonIndex(3);

    getTimeDivisionRadioModel().add(getTimeDivisionRadioItem3());

    getTimeDivisionRadioItem4().setButtonIndex(4);

    getTimeDivisionRadioModel().add(getTimeDivisionRadioItem4());

    getTimeDivisionRadioItem5().setButtonIndex(5);

    getTimeDivisionRadioModel().add(getTimeDivisionRadioItem5());

    getTimeDivisionRadioItem6().setButtonIndex(6);

    getTimeDivisionRadioModel().add(getTimeDivisionRadioItem6());

    getTimeDivisionRadioItem7().setButtonIndex(7);

    getTimeDivisionRadioModel().add(getTimeDivisionRadioItem7());

    getTimeDivisionRadioItem8().setButtonIndex(8);

    getTimeDivisionRadioModel().add(getTimeDivisionRadioItem8());

    getTimeDivisionRadioItem9().setButtonIndex(9);

    getTimeDivisionRadioModel().add(getTimeDivisionRadioItem9());

  }

  /**
   * 2から3時間に内部項目を追加します。
   */
  protected void addTimeDivisionRadioItem1(){

  }

  /**
   * 3から5時間に内部項目を追加します。
   */
  protected void addTimeDivisionRadioItem2(){

  }

  /**
   * 5から7時間に内部項目を追加します。
   */
  protected void addTimeDivisionRadioItem3(){

  }

  /**
   * 7から9時間に内部項目を追加します。
   */
  protected void addTimeDivisionRadioItem4(){

  }

  /**
   * 9から10時間に内部項目を追加します。
   */
  protected void addTimeDivisionRadioItem5(){

  }

  /**
   * 10から11時間に内部項目を追加します。
   */
  protected void addTimeDivisionRadioItem6(){

  }

  /**
   * 11から12時間に内部項目を追加します。
   */
  protected void addTimeDivisionRadioItem7(){

  }

  /**
   * 12から13時間に内部項目を追加します。
   */
  protected void addTimeDivisionRadioItem8(){

  }

  /**
   * 13から14時間に内部項目を追加します。
   */
  protected void addTimeDivisionRadioItem9(){

  }

  /**
   * 人員減算に内部項目を追加します。
   */
  protected void addStaffSubtractionRadio(){

  }

  /**
   * 人員減算モデルに内部項目を追加します。
   */
  protected void addStaffSubtractionRadioModel(){

    getStaffSubtractionRadioItem1().setButtonIndex(1);

    getStaffSubtractionRadioModel().add(getStaffSubtractionRadioItem1());

    getStaffSubtractionRadioItem2().setButtonIndex(2);

    getStaffSubtractionRadioModel().add(getStaffSubtractionRadioItem2());

    getStaffSubtractionRadioItem3().setButtonIndex(3);

    getStaffSubtractionRadioModel().add(getStaffSubtractionRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addStaffSubtractionRadioItem1(){

  }

  /**
   * 定員超過に内部項目を追加します。
   */
  protected void addStaffSubtractionRadioItem2(){

  }

  /**
   * 看護･介護職員が欠員に内部項目を追加します。
   */
  protected void addStaffSubtractionRadioItem3(){

  }

  /**
   * 提供時間コンテナに内部項目を追加します。
   */
  protected void addTimeContena(){

    timeContena.add(getBeginTimeContainer(), VRLayout.FLOW);

    timeContena.add(getEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * 開始時刻コンボに内部項目を追加します。
   */
  protected void addBeginTime(){

  }

  /**
   * 開始時刻コンボモデルに内部項目を追加します。
   */
  protected void addBeginTimeModel(){

  }

  /**
   * 終了時刻コンボに内部項目を追加します。
   */
  protected void addEndTime(){

  }

  /**
   * 終了時刻コンボモデルに内部項目を追加します。
   */
  protected void addEndTimeModel(){

  }

  /**
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getBathCareAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getFunctionTrainingAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getNourishmentManagementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getOralFunctionAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getTransportationCallRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 入浴介助加算に内部項目を追加します。
   */
  protected void addBathCareAddRadio(){

  }

  /**
   * 入浴介助加算モデルに内部項目を追加します。
   */
  protected void addBathCareAddRadioModel(){

    getBathCareAddRadioItem1().setButtonIndex(1);

    getBathCareAddRadioModel().add(getBathCareAddRadioItem1());

    getBathCareAddRadioItem2().setButtonIndex(2);

    getBathCareAddRadioModel().add(getBathCareAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addBathCareAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addBathCareAddRadioItem2(){

  }

  /**
   * 個別機能訓練加算に内部項目を追加します。
   */
  protected void addFunctionTrainingAddRadio(){

  }

  /**
   * 個別機能訓練加算モデルに内部項目を追加します。
   */
  protected void addFunctionTrainingAddRadioModel(){

    getFunctionTrainingAddRadioItem1().setButtonIndex(1);

    getFunctionTrainingAddRadioModel().add(getFunctionTrainingAddRadioItem1());

    getFunctionTrainingAddRadioItem2().setButtonIndex(2);

    getFunctionTrainingAddRadioModel().add(getFunctionTrainingAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addFunctionTrainingAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addFunctionTrainingAddRadioItem2(){

  }

  /**
   * 栄養改善加算に内部項目を追加します。
   */
  protected void addNourishmentManagementAddRadio(){

  }

  /**
   * 栄養改善加算モデルに内部項目を追加します。
   */
  protected void addNourishmentManagementAddRadioModel(){

    getNourishmentManagementAddRadioItem1().setButtonIndex(1);

    getNourishmentManagementAddRadioModel().add(getNourishmentManagementAddRadioItem1());

    getNourishmentManagementAddRadioItem2().setButtonIndex(2);

    getNourishmentManagementAddRadioModel().add(getNourishmentManagementAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNourishmentManagementAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addNourishmentManagementAddRadioItem2(){

  }

  /**
   * 口腔機能向上加算に内部項目を追加します。
   */
  protected void addOralFunctionAddRadio(){

  }

  /**
   * 口腔機能向上加算モデルに内部項目を追加します。
   */
  protected void addOralFunctionAddRadioModel(){

    getOralFunctionAddRadioItem1().setButtonIndex(1);

    getOralFunctionAddRadioModel().add(getOralFunctionAddRadioItem1());

    getOralFunctionAddRadioItem2().setButtonIndex(2);

    getOralFunctionAddRadioModel().add(getOralFunctionAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addOralFunctionAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addOralFunctionAddRadioItem2(){

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

    getServiceAddProvisionStructuralRadioItem4().setButtonIndex(4);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem4());

    getServiceAddProvisionStructuralRadioItem2().setButtonIndex(2);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem2());

    getServiceAddProvisionStructuralRadioItem3().setButtonIndex(3);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * Iイ型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem4(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_17411_201504Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_17411_201504Design getThis() {
    return this;
  }
}
