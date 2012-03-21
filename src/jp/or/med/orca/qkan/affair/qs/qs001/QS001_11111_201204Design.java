
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
 * 作成日: 2012/03/05  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン訪問介護 (QS001_11111_201204)
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
 * サービスパターン訪問介護画面項目デザイン(QS001_11111_201204) 
 */
public class QS001_11111_201204Design extends QS001ServicePanel {
  //GUIコンポーネント

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACComboBox houmonKaigoServicePattern;

  private ACLabelContainer houmonKaigoServicePatternContainer;

  private ACComboBoxModelAdapter houmonKaigoServicePatternModel;

  private ACComboBox homonkaigoTeikyoTime;

  private ACLabelContainer homonkaigoTeikyoTimeContainer;

  private ACComboBoxModelAdapter homonkaigoTeikyoTimeModel;

  private ACComboBox houmonKaigoInTime;

  private ACLabelContainer houmonKaigoInTimeContainer;

  private ACComboBoxModelAdapter houmonKaigoInTimeModel;

  private ACValueArrayRadioButtonGroup houmonKaigoClass;

  private ACLabelContainer houmonKaigoClassContainer;

  private ACListModelAdapter houmonKaigoClassModel;

  private ACRadioButtonItem houmonKaigoClassOther;

  private ACRadioButtonItem houmonKaigoClass3;

  private ACValueArrayRadioButtonGroup houmonKaigoNumberOfPeople;

  private ACLabelContainer houmonKaigoNumberOfPeopleContainer;

  private ACListModelAdapter houmonKaigoNumberOfPeopleModel;

  private ACRadioButtonItem houmonKaigoNumberOfPeople1;

  private ACRadioButtonItem houmonKaigoNumberOfPeople2;

  private ACValueArrayRadioButtonGroup houmonKaigoTimeZone;

  private ACLabelContainer houmonKaigoTimeZoneContainer;

  private ACListModelAdapter houmonKaigoTimeZoneModel;

  private ACRadioButtonItem houmonKaigoTimeZoneNormal;

  private ACRadioButtonItem houmonKaigoTimeZoneEarlyMorning;

  private ACRadioButtonItem houmonKaigoTimeZoneNighttime;

  private ACRadioButtonItem houmonKaigoTimeZoneMidnight;

  private ACValueArrayRadioButtonGroup specificProviderAddRadio;

  private ACLabelContainer specificProviderAddRadioContainer;

  private ACListModelAdapter specificProviderAddRadioModel;

  private ACRadioButtonItem specificProviderAddRadioItem1;

  private ACRadioButtonItem specificProviderAddRadioItem2;

  private ACRadioButtonItem specificProviderAddRadioItem3;

  private ACRadioButtonItem specificProviderAddRadioItem4;

  private ACValueArrayRadioButtonGroup houmonKaigoFirstAddRadioGroup;

  private ACLabelContainer houmonKaigoFirstAddRadioGroupContainer;

  private ACListModelAdapter houmonKaigoFirstAddRadioGroupModel;

  private ACRadioButtonItem houmonKaigoFirstAddRadioItem1;

  private ACRadioButtonItem houmonKaigoFirstAddRadioItem2;

  private ACValueArrayRadioButtonGroup rehabilitationSpecialistPersonnelCooperationRadioGroup;

  private ACLabelContainer rehabilitationSpecialistPersonnelCooperationRadioGroupContainer;

  private ACListModelAdapter rehabilitationSpecialistPersonnelCooperationRadioGroupModel;

  private ACRadioButtonItem rehabilitationSpecialistPersonnelCooperationItem1;

  private ACRadioButtonItem rehabilitationSpecialistPersonnelCooperationItem2;

  private ACValueArrayRadioButtonGroup houmonKaigoEmergencyAddRadioGroup;

  private ACLabelContainer houmonKaigoEmergencyAddRadioGroupContainer;

  private ACListModelAdapter houmonKaigoEmergencyAddRadioGroupModel;

  private ACRadioButtonItem houmonKaigoEmergencyAddRadioItem1;

  private ACRadioButtonItem houmonKaigoEmergencyAddRadioItem2;

  private ACBackLabelContainer houmonKaigoTimeContainer;

  private ACTimeComboBox houmonKaigoBeginTime;

  private ACLabelContainer houmonKaigoBeginTimeContainer;

  private ACComboBoxModelAdapter houmonKaigoBeginTimeModel;

  private ACTimeComboBox houmonKaigoEndTime;

  private ACLabelContainer houmonKaigoEndTimeContainer;

  private ACComboBoxModelAdapter houmonKaigoEndTimeModel;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRafioRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRafioRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRafioRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaRafioItem1;

  private ACRadioButtonItem providerAddMountainousAreaRafioRadioItem2;

  private ACValueArrayRadioButtonGroup houmonNeededRadio;

  private ACLabelContainer houmonNeededRadioContainer;

  private ACListModelAdapter houmonNeededRadioModel;

  private ACRadioButtonItem houmonNeededRadioItem1;

  private ACRadioButtonItem houmonNeededRadioItem2;

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
   * サービスコンボを取得します。
   * @return サービスコンボ
   */
  public ACComboBox getHoumonKaigoServicePattern(){
    if(houmonKaigoServicePattern==null){

      houmonKaigoServicePattern = new ACComboBox();

      getHoumonKaigoServicePatternContainer().setText("訪問種別");

      houmonKaigoServicePattern.setBindPath("1110101");

      houmonKaigoServicePattern.setEditable(false);

      houmonKaigoServicePattern.setModelBindPath("1110101");

      houmonKaigoServicePattern.setRenderBindPath("CONTENT");

      houmonKaigoServicePattern.setModel(getHoumonKaigoServicePatternModel());

      addHoumonKaigoServicePattern();
    }
    return houmonKaigoServicePattern;

  }

  /**
   * サービスコンボコンテナを取得します。
   * @return サービスコンボコンテナ
   */
  protected ACLabelContainer getHoumonKaigoServicePatternContainer(){
    if(houmonKaigoServicePatternContainer==null){
      houmonKaigoServicePatternContainer = new ACLabelContainer();
      houmonKaigoServicePatternContainer.setFollowChildEnabled(true);
      houmonKaigoServicePatternContainer.setVAlignment(VRLayout.CENTER);
      houmonKaigoServicePatternContainer.add(getHoumonKaigoServicePattern(), null);
    }
    return houmonKaigoServicePatternContainer;
  }

  /**
   * サービスコンボモデルを取得します。
   * @return サービスコンボモデル
   */
  protected ACComboBoxModelAdapter getHoumonKaigoServicePatternModel(){
    if(houmonKaigoServicePatternModel==null){
      houmonKaigoServicePatternModel = new ACComboBoxModelAdapter();
      addHoumonKaigoServicePatternModel();
    }
    return houmonKaigoServicePatternModel;
  }

  /**
   * 身体介護を取得します。
   * @return 身体介護
   */
  public ACComboBox getHomonkaigoTeikyoTime(){
    if(homonkaigoTeikyoTime==null){

      homonkaigoTeikyoTime = new ACComboBox();

      getHomonkaigoTeikyoTimeContainer().setText("身体介護");

      homonkaigoTeikyoTime.setBindPath("1110104");

      homonkaigoTeikyoTime.setEditable(false);

      homonkaigoTeikyoTime.setModelBindPath("1110104");

      homonkaigoTeikyoTime.setRenderBindPath("CONTENT");

      homonkaigoTeikyoTime.setBlankable(false);

      homonkaigoTeikyoTime.setModel(getHomonkaigoTeikyoTimeModel());

      addHomonkaigoTeikyoTime();
    }
    return homonkaigoTeikyoTime;

  }

  /**
   * 身体介護コンテナを取得します。
   * @return 身体介護コンテナ
   */
  protected ACLabelContainer getHomonkaigoTeikyoTimeContainer(){
    if(homonkaigoTeikyoTimeContainer==null){
      homonkaigoTeikyoTimeContainer = new ACLabelContainer();
      homonkaigoTeikyoTimeContainer.setFollowChildEnabled(true);
      homonkaigoTeikyoTimeContainer.setVAlignment(VRLayout.CENTER);
      homonkaigoTeikyoTimeContainer.add(getHomonkaigoTeikyoTime(), null);
    }
    return homonkaigoTeikyoTimeContainer;
  }

  /**
   * 身体介護モデルを取得します。
   * @return 身体介護モデル
   */
  protected ACComboBoxModelAdapter getHomonkaigoTeikyoTimeModel(){
    if(homonkaigoTeikyoTimeModel==null){
      homonkaigoTeikyoTimeModel = new ACComboBoxModelAdapter();
      addHomonkaigoTeikyoTimeModel();
    }
    return homonkaigoTeikyoTimeModel;
  }

  /**
   * 生活援助を取得します。
   * @return 生活援助
   */
  public ACComboBox getHoumonKaigoInTime(){
    if(houmonKaigoInTime==null){

      houmonKaigoInTime = new ACComboBox();

      getHoumonKaigoInTimeContainer().setText("生活援助");

      houmonKaigoInTime.setBindPath("1110105");

      houmonKaigoInTime.setEditable(false);

      houmonKaigoInTime.setModelBindPath("1110105");

      houmonKaigoInTime.setRenderBindPath("CONTENT");

      houmonKaigoInTime.setModel(getHoumonKaigoInTimeModel());

      addHoumonKaigoInTime();
    }
    return houmonKaigoInTime;

  }

  /**
   * 生活援助コンテナを取得します。
   * @return 生活援助コンテナ
   */
  protected ACLabelContainer getHoumonKaigoInTimeContainer(){
    if(houmonKaigoInTimeContainer==null){
      houmonKaigoInTimeContainer = new ACLabelContainer();
      houmonKaigoInTimeContainer.setFollowChildEnabled(true);
      houmonKaigoInTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonKaigoInTimeContainer.add(getHoumonKaigoInTime(), null);
    }
    return houmonKaigoInTimeContainer;
  }

  /**
   * 生活援助モデルを取得します。
   * @return 生活援助モデル
   */
  protected ACComboBoxModelAdapter getHoumonKaigoInTimeModel(){
    if(houmonKaigoInTimeModel==null){
      houmonKaigoInTimeModel = new ACComboBoxModelAdapter();
      addHoumonKaigoInTimeModel();
    }
    return houmonKaigoInTimeModel;
  }

  /**
   * サービス提供責任者の級職を取得します。
   * @return サービス提供責任者の級職
   */
  public ACValueArrayRadioButtonGroup getHoumonKaigoClass(){
    if(houmonKaigoClass==null){

      houmonKaigoClass = new ACValueArrayRadioButtonGroup();

      getHoumonKaigoClassContainer().setText("サービス提供責任者の級職");

      houmonKaigoClass.setBindPath("1110113");

      houmonKaigoClass.setUseClearButton(false);

      houmonKaigoClass.setModel(getHoumonKaigoClassModel());

      houmonKaigoClass.setValues(new int[]{1,2});

      addHoumonKaigoClass();
    }
    return houmonKaigoClass;

  }

  /**
   * サービス提供責任者の級職コンテナを取得します。
   * @return サービス提供責任者の級職コンテナ
   */
  protected ACLabelContainer getHoumonKaigoClassContainer(){
    if(houmonKaigoClassContainer==null){
      houmonKaigoClassContainer = new ACLabelContainer();
      houmonKaigoClassContainer.setFollowChildEnabled(true);
      houmonKaigoClassContainer.setVAlignment(VRLayout.CENTER);
      houmonKaigoClassContainer.add(getHoumonKaigoClass(), null);
    }
    return houmonKaigoClassContainer;
  }

  /**
   * サービス提供責任者の級職モデルを取得します。
   * @return サービス提供責任者の級職モデル
   */
  protected ACListModelAdapter getHoumonKaigoClassModel(){
    if(houmonKaigoClassModel==null){
      houmonKaigoClassModel = new ACListModelAdapter();
      addHoumonKaigoClassModel();
    }
    return houmonKaigoClassModel;
  }

  /**
   * 2級以外を取得します。
   * @return 2級以外
   */
  public ACRadioButtonItem getHoumonKaigoClassOther(){
    if(houmonKaigoClassOther==null){

      houmonKaigoClassOther = new ACRadioButtonItem();

      houmonKaigoClassOther.setText("2級以外");

      houmonKaigoClassOther.setGroup(getHoumonKaigoClass());

      addHoumonKaigoClassOther();
    }
    return houmonKaigoClassOther;

  }

  /**
   * 2級を取得します。
   * @return 2級
   */
  public ACRadioButtonItem getHoumonKaigoClass3(){
    if(houmonKaigoClass3==null){

      houmonKaigoClass3 = new ACRadioButtonItem();

      houmonKaigoClass3.setText("2級");

      houmonKaigoClass3.setGroup(getHoumonKaigoClass());

      addHoumonKaigoClass3();
    }
    return houmonKaigoClass3;

  }

  /**
   * 訪問人数を取得します。
   * @return 訪問人数
   */
  public ACValueArrayRadioButtonGroup getHoumonKaigoNumberOfPeople(){
    if(houmonKaigoNumberOfPeople==null){

      houmonKaigoNumberOfPeople = new ACValueArrayRadioButtonGroup();

      getHoumonKaigoNumberOfPeopleContainer().setText("訪問人数");

      houmonKaigoNumberOfPeople.setBindPath("1110107");

      houmonKaigoNumberOfPeople.setUseClearButton(false);

      houmonKaigoNumberOfPeople.setModel(getHoumonKaigoNumberOfPeopleModel());

      houmonKaigoNumberOfPeople.setValues(new int[]{1,2});

      addHoumonKaigoNumberOfPeople();
    }
    return houmonKaigoNumberOfPeople;

  }

  /**
   * 訪問人数コンテナを取得します。
   * @return 訪問人数コンテナ
   */
  protected ACLabelContainer getHoumonKaigoNumberOfPeopleContainer(){
    if(houmonKaigoNumberOfPeopleContainer==null){
      houmonKaigoNumberOfPeopleContainer = new ACLabelContainer();
      houmonKaigoNumberOfPeopleContainer.setFollowChildEnabled(true);
      houmonKaigoNumberOfPeopleContainer.setVAlignment(VRLayout.CENTER);
      houmonKaigoNumberOfPeopleContainer.add(getHoumonKaigoNumberOfPeople(), null);
    }
    return houmonKaigoNumberOfPeopleContainer;
  }

  /**
   * 訪問人数モデルを取得します。
   * @return 訪問人数モデル
   */
  protected ACListModelAdapter getHoumonKaigoNumberOfPeopleModel(){
    if(houmonKaigoNumberOfPeopleModel==null){
      houmonKaigoNumberOfPeopleModel = new ACListModelAdapter();
      addHoumonKaigoNumberOfPeopleModel();
    }
    return houmonKaigoNumberOfPeopleModel;
  }

  /**
   * 1人を取得します。
   * @return 1人
   */
  public ACRadioButtonItem getHoumonKaigoNumberOfPeople1(){
    if(houmonKaigoNumberOfPeople1==null){

      houmonKaigoNumberOfPeople1 = new ACRadioButtonItem();

      houmonKaigoNumberOfPeople1.setText("1人");

      houmonKaigoNumberOfPeople1.setGroup(getHoumonKaigoNumberOfPeople());

      addHoumonKaigoNumberOfPeople1();
    }
    return houmonKaigoNumberOfPeople1;

  }

  /**
   * 2人を取得します。
   * @return 2人
   */
  public ACRadioButtonItem getHoumonKaigoNumberOfPeople2(){
    if(houmonKaigoNumberOfPeople2==null){

      houmonKaigoNumberOfPeople2 = new ACRadioButtonItem();

      houmonKaigoNumberOfPeople2.setText("2人");

      houmonKaigoNumberOfPeople2.setGroup(getHoumonKaigoNumberOfPeople());

      addHoumonKaigoNumberOfPeople2();
    }
    return houmonKaigoNumberOfPeople2;

  }

  /**
   * 時間帯を取得します。
   * @return 時間帯
   */
  public ACValueArrayRadioButtonGroup getHoumonKaigoTimeZone(){
    if(houmonKaigoTimeZone==null){

      houmonKaigoTimeZone = new ACValueArrayRadioButtonGroup();

      getHoumonKaigoTimeZoneContainer().setText("時間帯");

      houmonKaigoTimeZone.setBindPath("1110108");

      houmonKaigoTimeZone.setUseClearButton(false);

      houmonKaigoTimeZone.setModel(getHoumonKaigoTimeZoneModel());

      houmonKaigoTimeZone.setValues(new int[]{1,2,3,4});

      addHoumonKaigoTimeZone();
    }
    return houmonKaigoTimeZone;

  }

  /**
   * 時間帯コンテナを取得します。
   * @return 時間帯コンテナ
   */
  protected ACLabelContainer getHoumonKaigoTimeZoneContainer(){
    if(houmonKaigoTimeZoneContainer==null){
      houmonKaigoTimeZoneContainer = new ACLabelContainer();
      houmonKaigoTimeZoneContainer.setFollowChildEnabled(true);
      houmonKaigoTimeZoneContainer.setVAlignment(VRLayout.CENTER);
      houmonKaigoTimeZoneContainer.add(getHoumonKaigoTimeZone(), null);
    }
    return houmonKaigoTimeZoneContainer;
  }

  /**
   * 時間帯モデルを取得します。
   * @return 時間帯モデル
   */
  protected ACListModelAdapter getHoumonKaigoTimeZoneModel(){
    if(houmonKaigoTimeZoneModel==null){
      houmonKaigoTimeZoneModel = new ACListModelAdapter();
      addHoumonKaigoTimeZoneModel();
    }
    return houmonKaigoTimeZoneModel;
  }

  /**
   * 通常を取得します。
   * @return 通常
   */
  public ACRadioButtonItem getHoumonKaigoTimeZoneNormal(){
    if(houmonKaigoTimeZoneNormal==null){

      houmonKaigoTimeZoneNormal = new ACRadioButtonItem();

      houmonKaigoTimeZoneNormal.setText("通常");

      houmonKaigoTimeZoneNormal.setGroup(getHoumonKaigoTimeZone());

      addHoumonKaigoTimeZoneNormal();
    }
    return houmonKaigoTimeZoneNormal;

  }

  /**
   * 早朝を取得します。
   * @return 早朝
   */
  public ACRadioButtonItem getHoumonKaigoTimeZoneEarlyMorning(){
    if(houmonKaigoTimeZoneEarlyMorning==null){

      houmonKaigoTimeZoneEarlyMorning = new ACRadioButtonItem();

      houmonKaigoTimeZoneEarlyMorning.setText("早朝");

      houmonKaigoTimeZoneEarlyMorning.setGroup(getHoumonKaigoTimeZone());

      addHoumonKaigoTimeZoneEarlyMorning();
    }
    return houmonKaigoTimeZoneEarlyMorning;

  }

  /**
   * 夜間を取得します。
   * @return 夜間
   */
  public ACRadioButtonItem getHoumonKaigoTimeZoneNighttime(){
    if(houmonKaigoTimeZoneNighttime==null){

      houmonKaigoTimeZoneNighttime = new ACRadioButtonItem();

      houmonKaigoTimeZoneNighttime.setText("夜間");

      houmonKaigoTimeZoneNighttime.setGroup(getHoumonKaigoTimeZone());

      addHoumonKaigoTimeZoneNighttime();
    }
    return houmonKaigoTimeZoneNighttime;

  }

  /**
   * 深夜を取得します。
   * @return 深夜
   */
  public ACRadioButtonItem getHoumonKaigoTimeZoneMidnight(){
    if(houmonKaigoTimeZoneMidnight==null){

      houmonKaigoTimeZoneMidnight = new ACRadioButtonItem();

      houmonKaigoTimeZoneMidnight.setText("深夜");

      houmonKaigoTimeZoneMidnight.setGroup(getHoumonKaigoTimeZone());

      addHoumonKaigoTimeZoneMidnight();
    }
    return houmonKaigoTimeZoneMidnight;

  }

  /**
   * 特定事業所加算を取得します。
   * @return 特定事業所加算
   */
  public ACValueArrayRadioButtonGroup getSpecificProviderAddRadio(){
    if(specificProviderAddRadio==null){

      specificProviderAddRadio = new ACValueArrayRadioButtonGroup();

      getSpecificProviderAddRadioContainer().setText("特定事業所加算");

      specificProviderAddRadio.setBindPath("1110109");

      specificProviderAddRadio.setUseClearButton(false);

      specificProviderAddRadio.setModel(getSpecificProviderAddRadioModel());

      specificProviderAddRadio.setValues(new int[]{1,2,3,4});

      addSpecificProviderAddRadio();
    }
    return specificProviderAddRadio;

  }

  /**
   * 特定事業所加算コンテナを取得します。
   * @return 特定事業所加算コンテナ
   */
  protected ACLabelContainer getSpecificProviderAddRadioContainer(){
    if(specificProviderAddRadioContainer==null){
      specificProviderAddRadioContainer = new ACLabelContainer();
      specificProviderAddRadioContainer.setFollowChildEnabled(true);
      specificProviderAddRadioContainer.setVAlignment(VRLayout.CENTER);
      specificProviderAddRadioContainer.add(getSpecificProviderAddRadio(), null);
    }
    return specificProviderAddRadioContainer;
  }

  /**
   * 特定事業所加算モデルを取得します。
   * @return 特定事業所加算モデル
   */
  protected ACListModelAdapter getSpecificProviderAddRadioModel(){
    if(specificProviderAddRadioModel==null){
      specificProviderAddRadioModel = new ACListModelAdapter();
      addSpecificProviderAddRadioModel();
    }
    return specificProviderAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSpecificProviderAddRadioItem1(){
    if(specificProviderAddRadioItem1==null){

      specificProviderAddRadioItem1 = new ACRadioButtonItem();

      specificProviderAddRadioItem1.setText("なし");

      specificProviderAddRadioItem1.setGroup(getSpecificProviderAddRadio());

      specificProviderAddRadioItem1.setConstraints(VRLayout.FLOW);

      addSpecificProviderAddRadioItem1();
    }
    return specificProviderAddRadioItem1;

  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getSpecificProviderAddRadioItem2(){
    if(specificProviderAddRadioItem2==null){

      specificProviderAddRadioItem2 = new ACRadioButtonItem();

      specificProviderAddRadioItem2.setText("I型");

      specificProviderAddRadioItem2.setGroup(getSpecificProviderAddRadio());

      specificProviderAddRadioItem2.setConstraints(VRLayout.FLOW);

      addSpecificProviderAddRadioItem2();
    }
    return specificProviderAddRadioItem2;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getSpecificProviderAddRadioItem3(){
    if(specificProviderAddRadioItem3==null){

      specificProviderAddRadioItem3 = new ACRadioButtonItem();

      specificProviderAddRadioItem3.setText("II型");

      specificProviderAddRadioItem3.setGroup(getSpecificProviderAddRadio());

      specificProviderAddRadioItem3.setConstraints(VRLayout.FLOW);

      addSpecificProviderAddRadioItem3();
    }
    return specificProviderAddRadioItem3;

  }

  /**
   * III型を取得します。
   * @return III型
   */
  public ACRadioButtonItem getSpecificProviderAddRadioItem4(){
    if(specificProviderAddRadioItem4==null){

      specificProviderAddRadioItem4 = new ACRadioButtonItem();

      specificProviderAddRadioItem4.setText("III型");

      specificProviderAddRadioItem4.setGroup(getSpecificProviderAddRadio());

      specificProviderAddRadioItem4.setConstraints(VRLayout.FLOW);

      addSpecificProviderAddRadioItem4();
    }
    return specificProviderAddRadioItem4;

  }

  /**
   * 初回加算を取得します。
   * @return 初回加算
   */
  public ACValueArrayRadioButtonGroup getHoumonKaigoFirstAddRadioGroup(){
    if(houmonKaigoFirstAddRadioGroup==null){

      houmonKaigoFirstAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getHoumonKaigoFirstAddRadioGroupContainer().setText("初回加算");

      houmonKaigoFirstAddRadioGroup.setBindPath("1110110");

      houmonKaigoFirstAddRadioGroup.setNoSelectIndex(0);

      houmonKaigoFirstAddRadioGroup.setUseClearButton(false);

      houmonKaigoFirstAddRadioGroup.setModel(getHoumonKaigoFirstAddRadioGroupModel());

      houmonKaigoFirstAddRadioGroup.setValues(new int[]{1,2});

      addHoumonKaigoFirstAddRadioGroup();
    }
    return houmonKaigoFirstAddRadioGroup;

  }

  /**
   * 初回加算コンテナを取得します。
   * @return 初回加算コンテナ
   */
  protected ACLabelContainer getHoumonKaigoFirstAddRadioGroupContainer(){
    if(houmonKaigoFirstAddRadioGroupContainer==null){
      houmonKaigoFirstAddRadioGroupContainer = new ACLabelContainer();
      houmonKaigoFirstAddRadioGroupContainer.setFollowChildEnabled(true);
      houmonKaigoFirstAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      houmonKaigoFirstAddRadioGroupContainer.add(getHoumonKaigoFirstAddRadioGroup(), null);
    }
    return houmonKaigoFirstAddRadioGroupContainer;
  }

  /**
   * 初回加算モデルを取得します。
   * @return 初回加算モデル
   */
  protected ACListModelAdapter getHoumonKaigoFirstAddRadioGroupModel(){
    if(houmonKaigoFirstAddRadioGroupModel==null){
      houmonKaigoFirstAddRadioGroupModel = new ACListModelAdapter();
      addHoumonKaigoFirstAddRadioGroupModel();
    }
    return houmonKaigoFirstAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonKaigoFirstAddRadioItem1(){
    if(houmonKaigoFirstAddRadioItem1==null){

      houmonKaigoFirstAddRadioItem1 = new ACRadioButtonItem();

      houmonKaigoFirstAddRadioItem1.setText("なし");

      houmonKaigoFirstAddRadioItem1.setGroup(getHoumonKaigoFirstAddRadioGroup());

      houmonKaigoFirstAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonKaigoFirstAddRadioItem1();
    }
    return houmonKaigoFirstAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonKaigoFirstAddRadioItem2(){
    if(houmonKaigoFirstAddRadioItem2==null){

      houmonKaigoFirstAddRadioItem2 = new ACRadioButtonItem();

      houmonKaigoFirstAddRadioItem2.setText("あり");

      houmonKaigoFirstAddRadioItem2.setGroup(getHoumonKaigoFirstAddRadioGroup());

      houmonKaigoFirstAddRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonKaigoFirstAddRadioItem2();
    }
    return houmonKaigoFirstAddRadioItem2;

  }

  /**
   * 生活機能向上連携加算を取得します。
   * @return 生活機能向上連携加算
   */
  public ACValueArrayRadioButtonGroup getRehabilitationSpecialistPersonnelCooperationRadioGroup(){
    if(rehabilitationSpecialistPersonnelCooperationRadioGroup==null){

      rehabilitationSpecialistPersonnelCooperationRadioGroup = new ACValueArrayRadioButtonGroup();

      getRehabilitationSpecialistPersonnelCooperationRadioGroupContainer().setText("生活機能向上連携加算");

      rehabilitationSpecialistPersonnelCooperationRadioGroup.setBindPath("1110112");

      rehabilitationSpecialistPersonnelCooperationRadioGroup.setNoSelectIndex(0);

      rehabilitationSpecialistPersonnelCooperationRadioGroup.setUseClearButton(false);

      rehabilitationSpecialistPersonnelCooperationRadioGroup.setModel(getRehabilitationSpecialistPersonnelCooperationRadioGroupModel());

      rehabilitationSpecialistPersonnelCooperationRadioGroup.setValues(new int[]{1,2});

      addRehabilitationSpecialistPersonnelCooperationRadioGroup();
    }
    return rehabilitationSpecialistPersonnelCooperationRadioGroup;

  }

  /**
   * 生活機能向上連携加算コンテナを取得します。
   * @return 生活機能向上連携加算コンテナ
   */
  protected ACLabelContainer getRehabilitationSpecialistPersonnelCooperationRadioGroupContainer(){
    if(rehabilitationSpecialistPersonnelCooperationRadioGroupContainer==null){
      rehabilitationSpecialistPersonnelCooperationRadioGroupContainer = new ACLabelContainer();
      rehabilitationSpecialistPersonnelCooperationRadioGroupContainer.setFollowChildEnabled(true);
      rehabilitationSpecialistPersonnelCooperationRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      rehabilitationSpecialistPersonnelCooperationRadioGroupContainer.add(getRehabilitationSpecialistPersonnelCooperationRadioGroup(), null);
    }
    return rehabilitationSpecialistPersonnelCooperationRadioGroupContainer;
  }

  /**
   * 生活機能向上連携加算モデルを取得します。
   * @return 生活機能向上連携加算モデル
   */
  protected ACListModelAdapter getRehabilitationSpecialistPersonnelCooperationRadioGroupModel(){
    if(rehabilitationSpecialistPersonnelCooperationRadioGroupModel==null){
      rehabilitationSpecialistPersonnelCooperationRadioGroupModel = new ACListModelAdapter();
      addRehabilitationSpecialistPersonnelCooperationRadioGroupModel();
    }
    return rehabilitationSpecialistPersonnelCooperationRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getRehabilitationSpecialistPersonnelCooperationItem1(){
    if(rehabilitationSpecialistPersonnelCooperationItem1==null){

      rehabilitationSpecialistPersonnelCooperationItem1 = new ACRadioButtonItem();

      rehabilitationSpecialistPersonnelCooperationItem1.setText("なし");

      rehabilitationSpecialistPersonnelCooperationItem1.setGroup(getRehabilitationSpecialistPersonnelCooperationRadioGroup());

      rehabilitationSpecialistPersonnelCooperationItem1.setConstraints(VRLayout.FLOW);

      addRehabilitationSpecialistPersonnelCooperationItem1();
    }
    return rehabilitationSpecialistPersonnelCooperationItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getRehabilitationSpecialistPersonnelCooperationItem2(){
    if(rehabilitationSpecialistPersonnelCooperationItem2==null){

      rehabilitationSpecialistPersonnelCooperationItem2 = new ACRadioButtonItem();

      rehabilitationSpecialistPersonnelCooperationItem2.setText("あり");

      rehabilitationSpecialistPersonnelCooperationItem2.setGroup(getRehabilitationSpecialistPersonnelCooperationRadioGroup());

      rehabilitationSpecialistPersonnelCooperationItem2.setConstraints(VRLayout.FLOW);

      addRehabilitationSpecialistPersonnelCooperationItem2();
    }
    return rehabilitationSpecialistPersonnelCooperationItem2;

  }

  /**
   * 緊急時訪問介護加算を取得します。
   * @return 緊急時訪問介護加算
   */
  public ACValueArrayRadioButtonGroup getHoumonKaigoEmergencyAddRadioGroup(){
    if(houmonKaigoEmergencyAddRadioGroup==null){

      houmonKaigoEmergencyAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getHoumonKaigoEmergencyAddRadioGroupContainer().setText("緊急時訪問介護加算");

      houmonKaigoEmergencyAddRadioGroup.setBindPath("1110111");

      houmonKaigoEmergencyAddRadioGroup.setNoSelectIndex(0);

      houmonKaigoEmergencyAddRadioGroup.setUseClearButton(false);

      houmonKaigoEmergencyAddRadioGroup.setModel(getHoumonKaigoEmergencyAddRadioGroupModel());

      houmonKaigoEmergencyAddRadioGroup.setValues(new int[]{1,2});

      addHoumonKaigoEmergencyAddRadioGroup();
    }
    return houmonKaigoEmergencyAddRadioGroup;

  }

  /**
   * 緊急時訪問介護加算コンテナを取得します。
   * @return 緊急時訪問介護加算コンテナ
   */
  protected ACLabelContainer getHoumonKaigoEmergencyAddRadioGroupContainer(){
    if(houmonKaigoEmergencyAddRadioGroupContainer==null){
      houmonKaigoEmergencyAddRadioGroupContainer = new ACLabelContainer();
      houmonKaigoEmergencyAddRadioGroupContainer.setFollowChildEnabled(true);
      houmonKaigoEmergencyAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      houmonKaigoEmergencyAddRadioGroupContainer.add(getHoumonKaigoEmergencyAddRadioGroup(), null);
    }
    return houmonKaigoEmergencyAddRadioGroupContainer;
  }

  /**
   * 緊急時訪問介護加算モデルを取得します。
   * @return 緊急時訪問介護加算モデル
   */
  protected ACListModelAdapter getHoumonKaigoEmergencyAddRadioGroupModel(){
    if(houmonKaigoEmergencyAddRadioGroupModel==null){
      houmonKaigoEmergencyAddRadioGroupModel = new ACListModelAdapter();
      addHoumonKaigoEmergencyAddRadioGroupModel();
    }
    return houmonKaigoEmergencyAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonKaigoEmergencyAddRadioItem1(){
    if(houmonKaigoEmergencyAddRadioItem1==null){

      houmonKaigoEmergencyAddRadioItem1 = new ACRadioButtonItem();

      houmonKaigoEmergencyAddRadioItem1.setText("なし");

      houmonKaigoEmergencyAddRadioItem1.setGroup(getHoumonKaigoEmergencyAddRadioGroup());

      houmonKaigoEmergencyAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonKaigoEmergencyAddRadioItem1();
    }
    return houmonKaigoEmergencyAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonKaigoEmergencyAddRadioItem2(){
    if(houmonKaigoEmergencyAddRadioItem2==null){

      houmonKaigoEmergencyAddRadioItem2 = new ACRadioButtonItem();

      houmonKaigoEmergencyAddRadioItem2.setText("あり");

      houmonKaigoEmergencyAddRadioItem2.setGroup(getHoumonKaigoEmergencyAddRadioGroup());

      houmonKaigoEmergencyAddRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonKaigoEmergencyAddRadioItem2();
    }
    return houmonKaigoEmergencyAddRadioItem2;

  }

  /**
   * 提供時間コンテナを取得します。
   * @return 提供時間コンテナ
   */
  public ACBackLabelContainer getHoumonKaigoTimeContainer(){
    if(houmonKaigoTimeContainer==null){

      houmonKaigoTimeContainer = new ACBackLabelContainer();

      houmonKaigoTimeContainer.setFollowChildEnabled(true);

      addHoumonKaigoTimeContainer();
    }
    return houmonKaigoTimeContainer;

  }

  /**
   * 開始時刻コンボを取得します。
   * @return 開始時刻コンボ
   */
  public ACTimeComboBox getHoumonKaigoBeginTime(){
    if(houmonKaigoBeginTime==null){

      houmonKaigoBeginTime = new ACTimeComboBox();

      getHoumonKaigoBeginTimeContainer().setText("開始時刻");

      houmonKaigoBeginTime.setBindPath("3");

      houmonKaigoBeginTime.setModelBindPath("3");

      houmonKaigoBeginTime.setRenderBindPath("CONTENT");

      houmonKaigoBeginTime.setModel(getHoumonKaigoBeginTimeModel());

      addHoumonKaigoBeginTime();
    }
    return houmonKaigoBeginTime;

  }

  /**
   * 開始時刻コンボコンテナを取得します。
   * @return 開始時刻コンボコンテナ
   */
  protected ACLabelContainer getHoumonKaigoBeginTimeContainer(){
    if(houmonKaigoBeginTimeContainer==null){
      houmonKaigoBeginTimeContainer = new ACLabelContainer();
      houmonKaigoBeginTimeContainer.setFollowChildEnabled(true);
      houmonKaigoBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonKaigoBeginTimeContainer.add(getHoumonKaigoBeginTime(), null);
    }
    return houmonKaigoBeginTimeContainer;
  }

  /**
   * 開始時刻コンボモデルを取得します。
   * @return 開始時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getHoumonKaigoBeginTimeModel(){
    if(houmonKaigoBeginTimeModel==null){
      houmonKaigoBeginTimeModel = new ACComboBoxModelAdapter();
      addHoumonKaigoBeginTimeModel();
    }
    return houmonKaigoBeginTimeModel;
  }

  /**
   * 終了時刻コンボを取得します。
   * @return 終了時刻コンボ
   */
  public ACTimeComboBox getHoumonKaigoEndTime(){
    if(houmonKaigoEndTime==null){

      houmonKaigoEndTime = new ACTimeComboBox();

      getHoumonKaigoEndTimeContainer().setText("終了時刻");

      houmonKaigoEndTime.setBindPath("4");

      houmonKaigoEndTime.setModelBindPath("4");

      houmonKaigoEndTime.setRenderBindPath("CONTENT");

      houmonKaigoEndTime.setModel(getHoumonKaigoEndTimeModel());

      addHoumonKaigoEndTime();
    }
    return houmonKaigoEndTime;

  }

  /**
   * 終了時刻コンボコンテナを取得します。
   * @return 終了時刻コンボコンテナ
   */
  protected ACLabelContainer getHoumonKaigoEndTimeContainer(){
    if(houmonKaigoEndTimeContainer==null){
      houmonKaigoEndTimeContainer = new ACLabelContainer();
      houmonKaigoEndTimeContainer.setFollowChildEnabled(true);
      houmonKaigoEndTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonKaigoEndTimeContainer.add(getHoumonKaigoEndTime(), null);
    }
    return houmonKaigoEndTimeContainer;
  }

  /**
   * 終了時刻コンボモデルを取得します。
   * @return 終了時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getHoumonKaigoEndTimeModel(){
    if(houmonKaigoEndTimeModel==null){
      houmonKaigoEndTimeModel = new ACComboBoxModelAdapter();
      addHoumonKaigoEndTimeModel();
    }
    return houmonKaigoEndTimeModel;
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
   * 中山間地域等でのサービス提供加算を取得します。
   * @return 中山間地域等でのサービス提供加算
   */
  public ACValueArrayRadioButtonGroup getProviderAddMountainousAreaRafioRadioGroup(){
    if(providerAddMountainousAreaRafioRadioGroup==null){

      providerAddMountainousAreaRafioRadioGroup = new ACValueArrayRadioButtonGroup();

      getProviderAddMountainousAreaRafioRadioGroupContainer().setText("中山間地域等でのサービス提供加算");

      providerAddMountainousAreaRafioRadioGroup.setBindPath("12");

      providerAddMountainousAreaRafioRadioGroup.setNoSelectIndex(0);

      providerAddMountainousAreaRafioRadioGroup.setUseClearButton(false);

      providerAddMountainousAreaRafioRadioGroup.setModel(getProviderAddMountainousAreaRafioRadioGroupModel());

      providerAddMountainousAreaRafioRadioGroup.setValues(new int[]{1,2});

      addProviderAddMountainousAreaRafioRadioGroup();
    }
    return providerAddMountainousAreaRafioRadioGroup;

  }

  /**
   * 中山間地域等でのサービス提供加算コンテナを取得します。
   * @return 中山間地域等でのサービス提供加算コンテナ
   */
  protected ACLabelContainer getProviderAddMountainousAreaRafioRadioGroupContainer(){
    if(providerAddMountainousAreaRafioRadioGroupContainer==null){
      providerAddMountainousAreaRafioRadioGroupContainer = new ACLabelContainer();
      providerAddMountainousAreaRafioRadioGroupContainer.setFollowChildEnabled(true);
      providerAddMountainousAreaRafioRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      providerAddMountainousAreaRafioRadioGroupContainer.add(getProviderAddMountainousAreaRafioRadioGroup(), null);
    }
    return providerAddMountainousAreaRafioRadioGroupContainer;
  }

  /**
   * 中山間地域等でのサービス提供加算モデルを取得します。
   * @return 中山間地域等でのサービス提供加算モデル
   */
  protected ACListModelAdapter getProviderAddMountainousAreaRafioRadioGroupModel(){
    if(providerAddMountainousAreaRafioRadioGroupModel==null){
      providerAddMountainousAreaRafioRadioGroupModel = new ACListModelAdapter();
      addProviderAddMountainousAreaRafioRadioGroupModel();
    }
    return providerAddMountainousAreaRafioRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getProviderAddMountainousAreaRafioItem1(){
    if(providerAddMountainousAreaRafioItem1==null){

      providerAddMountainousAreaRafioItem1 = new ACRadioButtonItem();

      providerAddMountainousAreaRafioItem1.setText("なし");

      providerAddMountainousAreaRafioItem1.setGroup(getProviderAddMountainousAreaRafioRadioGroup());

      providerAddMountainousAreaRafioItem1.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaRafioItem1();
    }
    return providerAddMountainousAreaRafioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getProviderAddMountainousAreaRafioRadioItem2(){
    if(providerAddMountainousAreaRafioRadioItem2==null){

      providerAddMountainousAreaRafioRadioItem2 = new ACRadioButtonItem();

      providerAddMountainousAreaRafioRadioItem2.setText("あり");

      providerAddMountainousAreaRafioRadioItem2.setGroup(getProviderAddMountainousAreaRafioRadioGroup());

      providerAddMountainousAreaRafioRadioItem2.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaRafioRadioItem2();
    }
    return providerAddMountainousAreaRafioRadioItem2;

  }

  /**
   * 同一建物居住者へのサービス提供を取得します。
   * @return 同一建物居住者へのサービス提供
   */
  public ACValueArrayRadioButtonGroup getHoumonNeededRadio(){
    if(houmonNeededRadio==null){

      houmonNeededRadio = new ACValueArrayRadioButtonGroup();

      getHoumonNeededRadioContainer().setText("同一建物居住者へのサービス提供");

      houmonNeededRadio.setBindPath("16");

      houmonNeededRadio.setNoSelectIndex(0);

      houmonNeededRadio.setUseClearButton(false);

      houmonNeededRadio.setModel(getHoumonNeededRadioModel());

      houmonNeededRadio.setValues(new int[]{1,2});

      addHoumonNeededRadio();
    }
    return houmonNeededRadio;

  }

  /**
   * 同一建物居住者へのサービス提供コンテナを取得します。
   * @return 同一建物居住者へのサービス提供コンテナ
   */
  protected ACLabelContainer getHoumonNeededRadioContainer(){
    if(houmonNeededRadioContainer==null){
      houmonNeededRadioContainer = new ACLabelContainer();
      houmonNeededRadioContainer.setFollowChildEnabled(true);
      houmonNeededRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonNeededRadioContainer.add(getHoumonNeededRadio(), null);
    }
    return houmonNeededRadioContainer;
  }

  /**
   * 同一建物居住者へのサービス提供モデルを取得します。
   * @return 同一建物居住者へのサービス提供モデル
   */
  protected ACListModelAdapter getHoumonNeededRadioModel(){
    if(houmonNeededRadioModel==null){
      houmonNeededRadioModel = new ACListModelAdapter();
      addHoumonNeededRadioModel();
    }
    return houmonNeededRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonNeededRadioItem1(){
    if(houmonNeededRadioItem1==null){

      houmonNeededRadioItem1 = new ACRadioButtonItem();

      houmonNeededRadioItem1.setText("なし");

      houmonNeededRadioItem1.setGroup(getHoumonNeededRadio());

      houmonNeededRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonNeededRadioItem1();
    }
    return houmonNeededRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonNeededRadioItem2(){
    if(houmonNeededRadioItem2==null){

      houmonNeededRadioItem2 = new ACRadioButtonItem();

      houmonNeededRadioItem2.setText("あり");

      houmonNeededRadioItem2.setGroup(getHoumonNeededRadio());

      houmonNeededRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonNeededRadioItem2();
    }
    return houmonNeededRadioItem2;

  }

  /**
   * コンストラクタです。
   */
  public QS001_11111_201204Design() {

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

    tab1.add(getHoumonKaigoServicePatternContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHomonkaigoTeikyoTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKaigoInTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKaigoClassContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKaigoNumberOfPeopleContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKaigoTimeZoneContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getSpecificProviderAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKaigoFirstAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getRehabilitationSpecialistPersonnelCooperationRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKaigoEmergencyAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKaigoTimeContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * サービスコンボに内部項目を追加します。
   */
  protected void addHoumonKaigoServicePattern(){

  }

  /**
   * サービスコンボモデルに内部項目を追加します。
   */
  protected void addHoumonKaigoServicePatternModel(){

  }

  /**
   * 身体介護に内部項目を追加します。
   */
  protected void addHomonkaigoTeikyoTime(){

  }

  /**
   * 身体介護モデルに内部項目を追加します。
   */
  protected void addHomonkaigoTeikyoTimeModel(){

  }

  /**
   * 生活援助に内部項目を追加します。
   */
  protected void addHoumonKaigoInTime(){

  }

  /**
   * 生活援助モデルに内部項目を追加します。
   */
  protected void addHoumonKaigoInTimeModel(){

  }

  /**
   * サービス提供責任者の級職に内部項目を追加します。
   */
  protected void addHoumonKaigoClass(){

  }

  /**
   * サービス提供責任者の級職モデルに内部項目を追加します。
   */
  protected void addHoumonKaigoClassModel(){

    getHoumonKaigoClassOther().setButtonIndex(1);

    getHoumonKaigoClassModel().add(getHoumonKaigoClassOther());

    getHoumonKaigoClass3().setButtonIndex(2);

    getHoumonKaigoClassModel().add(getHoumonKaigoClass3());

  }

  /**
   * 2級以外に内部項目を追加します。
   */
  protected void addHoumonKaigoClassOther(){

  }

  /**
   * 2級に内部項目を追加します。
   */
  protected void addHoumonKaigoClass3(){

  }

  /**
   * 訪問人数に内部項目を追加します。
   */
  protected void addHoumonKaigoNumberOfPeople(){

  }

  /**
   * 訪問人数モデルに内部項目を追加します。
   */
  protected void addHoumonKaigoNumberOfPeopleModel(){

    getHoumonKaigoNumberOfPeople1().setButtonIndex(1);

    getHoumonKaigoNumberOfPeopleModel().add(getHoumonKaigoNumberOfPeople1());

    getHoumonKaigoNumberOfPeople2().setButtonIndex(2);

    getHoumonKaigoNumberOfPeopleModel().add(getHoumonKaigoNumberOfPeople2());

  }

  /**
   * 1人に内部項目を追加します。
   */
  protected void addHoumonKaigoNumberOfPeople1(){

  }

  /**
   * 2人に内部項目を追加します。
   */
  protected void addHoumonKaigoNumberOfPeople2(){

  }

  /**
   * 時間帯に内部項目を追加します。
   */
  protected void addHoumonKaigoTimeZone(){

  }

  /**
   * 時間帯モデルに内部項目を追加します。
   */
  protected void addHoumonKaigoTimeZoneModel(){

    getHoumonKaigoTimeZoneNormal().setButtonIndex(1);

    getHoumonKaigoTimeZoneModel().add(getHoumonKaigoTimeZoneNormal());

    getHoumonKaigoTimeZoneEarlyMorning().setButtonIndex(2);

    getHoumonKaigoTimeZoneModel().add(getHoumonKaigoTimeZoneEarlyMorning());

    getHoumonKaigoTimeZoneNighttime().setButtonIndex(3);

    getHoumonKaigoTimeZoneModel().add(getHoumonKaigoTimeZoneNighttime());

    getHoumonKaigoTimeZoneMidnight().setButtonIndex(4);

    getHoumonKaigoTimeZoneModel().add(getHoumonKaigoTimeZoneMidnight());

  }

  /**
   * 通常に内部項目を追加します。
   */
  protected void addHoumonKaigoTimeZoneNormal(){

  }

  /**
   * 早朝に内部項目を追加します。
   */
  protected void addHoumonKaigoTimeZoneEarlyMorning(){

  }

  /**
   * 夜間に内部項目を追加します。
   */
  protected void addHoumonKaigoTimeZoneNighttime(){

  }

  /**
   * 深夜に内部項目を追加します。
   */
  protected void addHoumonKaigoTimeZoneMidnight(){

  }

  /**
   * 特定事業所加算に内部項目を追加します。
   */
  protected void addSpecificProviderAddRadio(){

  }

  /**
   * 特定事業所加算モデルに内部項目を追加します。
   */
  protected void addSpecificProviderAddRadioModel(){

    getSpecificProviderAddRadioItem1().setButtonIndex(1);

    getSpecificProviderAddRadioModel().add(getSpecificProviderAddRadioItem1());

    getSpecificProviderAddRadioItem2().setButtonIndex(2);

    getSpecificProviderAddRadioModel().add(getSpecificProviderAddRadioItem2());

    getSpecificProviderAddRadioItem3().setButtonIndex(3);

    getSpecificProviderAddRadioModel().add(getSpecificProviderAddRadioItem3());

    getSpecificProviderAddRadioItem4().setButtonIndex(4);

    getSpecificProviderAddRadioModel().add(getSpecificProviderAddRadioItem4());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSpecificProviderAddRadioItem1(){

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addSpecificProviderAddRadioItem2(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addSpecificProviderAddRadioItem3(){

  }

  /**
   * III型に内部項目を追加します。
   */
  protected void addSpecificProviderAddRadioItem4(){

  }

  /**
   * 初回加算に内部項目を追加します。
   */
  protected void addHoumonKaigoFirstAddRadioGroup(){

  }

  /**
   * 初回加算モデルに内部項目を追加します。
   */
  protected void addHoumonKaigoFirstAddRadioGroupModel(){

    getHoumonKaigoFirstAddRadioItem1().setButtonIndex(1);

    getHoumonKaigoFirstAddRadioGroupModel().add(getHoumonKaigoFirstAddRadioItem1());

    getHoumonKaigoFirstAddRadioItem2().setButtonIndex(2);

    getHoumonKaigoFirstAddRadioGroupModel().add(getHoumonKaigoFirstAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonKaigoFirstAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonKaigoFirstAddRadioItem2(){

  }

  /**
   * 生活機能向上連携加算に内部項目を追加します。
   */
  protected void addRehabilitationSpecialistPersonnelCooperationRadioGroup(){

  }

  /**
   * 生活機能向上連携加算モデルに内部項目を追加します。
   */
  protected void addRehabilitationSpecialistPersonnelCooperationRadioGroupModel(){

    getRehabilitationSpecialistPersonnelCooperationItem1().setButtonIndex(1);

    getRehabilitationSpecialistPersonnelCooperationRadioGroupModel().add(getRehabilitationSpecialistPersonnelCooperationItem1());

    getRehabilitationSpecialistPersonnelCooperationItem2().setButtonIndex(2);

    getRehabilitationSpecialistPersonnelCooperationRadioGroupModel().add(getRehabilitationSpecialistPersonnelCooperationItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addRehabilitationSpecialistPersonnelCooperationItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addRehabilitationSpecialistPersonnelCooperationItem2(){

  }

  /**
   * 緊急時訪問介護加算に内部項目を追加します。
   */
  protected void addHoumonKaigoEmergencyAddRadioGroup(){

  }

  /**
   * 緊急時訪問介護加算モデルに内部項目を追加します。
   */
  protected void addHoumonKaigoEmergencyAddRadioGroupModel(){

    getHoumonKaigoEmergencyAddRadioItem1().setButtonIndex(1);

    getHoumonKaigoEmergencyAddRadioGroupModel().add(getHoumonKaigoEmergencyAddRadioItem1());

    getHoumonKaigoEmergencyAddRadioItem2().setButtonIndex(2);

    getHoumonKaigoEmergencyAddRadioGroupModel().add(getHoumonKaigoEmergencyAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonKaigoEmergencyAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonKaigoEmergencyAddRadioItem2(){

  }

  /**
   * 提供時間コンテナに内部項目を追加します。
   */
  protected void addHoumonKaigoTimeContainer(){

    houmonKaigoTimeContainer.add(getHoumonKaigoBeginTimeContainer(), VRLayout.FLOW);

    houmonKaigoTimeContainer.add(getHoumonKaigoEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * 開始時刻コンボに内部項目を追加します。
   */
  protected void addHoumonKaigoBeginTime(){

  }

  /**
   * 開始時刻コンボモデルに内部項目を追加します。
   */
  protected void addHoumonKaigoBeginTimeModel(){

  }

  /**
   * 終了時刻コンボに内部項目を追加します。
   */
  protected void addHoumonKaigoEndTime(){

  }

  /**
   * 終了時刻コンボモデルに内部項目を追加します。
   */
  protected void addHoumonKaigoEndTimeModel(){

  }

  /**
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getProviderAddMountainousAreaRafioRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonNeededRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 中山間地域等でのサービス提供加算に内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRafioRadioGroup(){

  }

  /**
   * 中山間地域等でのサービス提供加算モデルに内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRafioRadioGroupModel(){

    getProviderAddMountainousAreaRafioItem1().setButtonIndex(1);

    getProviderAddMountainousAreaRafioRadioGroupModel().add(getProviderAddMountainousAreaRafioItem1());

    getProviderAddMountainousAreaRafioRadioItem2().setButtonIndex(2);

    getProviderAddMountainousAreaRafioRadioGroupModel().add(getProviderAddMountainousAreaRafioRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRafioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRafioRadioItem2(){

  }

  /**
   * 同一建物居住者へのサービス提供に内部項目を追加します。
   */
  protected void addHoumonNeededRadio(){

  }

  /**
   * 同一建物居住者へのサービス提供モデルに内部項目を追加します。
   */
  protected void addHoumonNeededRadioModel(){

    getHoumonNeededRadioItem1().setButtonIndex(1);

    getHoumonNeededRadioModel().add(getHoumonNeededRadioItem1());

    getHoumonNeededRadioItem2().setButtonIndex(2);

    getHoumonNeededRadioModel().add(getHoumonNeededRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonNeededRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonNeededRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_11111_201204Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_11111_201204Design getThis() {
    return this;
  }
}
