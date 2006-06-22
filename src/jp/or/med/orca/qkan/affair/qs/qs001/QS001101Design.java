
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
 * 作成日: 2006/03/19  日本コンピューター株式会社 松本　幸一 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン訪問介護 (QS001101)
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
 * サービスパターン訪問介護画面項目デザイン(QS001101) 
 */
public class QS001101Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel houmonKaigoPatterns;

  private ACComboBox houmonKaigoServicePattern;

  private ACLabelContainer houmonKaigoServicePatternContainer;

  private ACComboBoxModelAdapter houmonKaigoServicePatternModel;

  private ACComboBox homonkaigoTeikyoTime;

  private ACLabelContainer homonkaigoTeikyoTimeContainer;

  private ACComboBoxModelAdapter homonkaigoTeikyoTimeModel;

  private ACComboBox houmonKaigoInTime;

  private ACLabelContainer houmonKaigoInTimeContainer;

  private ACComboBoxModelAdapter houmonKaigoInTimeModel;

  private ACClearableRadioButtonGroup houmonKaigoClass;

  private ACLabelContainer houmonKaigoClassContainer;

  private ACListModelAdapter houmonKaigoClassModel;

  private ACRadioButtonItem houmonKaigoClassOther;

  private ACRadioButtonItem houmonKaigoClass3;

  private ACClearableRadioButtonGroup houmonKaigoNumberOfPeople;

  private ACLabelContainer houmonKaigoNumberOfPeopleContainer;

  private ACListModelAdapter houmonKaigoNumberOfPeopleModel;

  private ACRadioButtonItem houmonKaigoNumberOfPeople1;

  private ACRadioButtonItem houmonKaigoNumberOfPeople2;

  private ACClearableRadioButtonGroup houmonKaigoTimeZone;

  private ACLabelContainer houmonKaigoTimeZoneContainer;

  private ACListModelAdapter houmonKaigoTimeZoneModel;

  private ACRadioButtonItem houmonKaigoTimeZoneNormal;

  private ACRadioButtonItem houmonKaigoTimeZoneEarlyMorning;

  private ACRadioButtonItem houmonKaigoTimeZoneNighttime;

  private ACRadioButtonItem houmonKaigoTimeZoneMidnight;

  private ACClearableRadioButtonGroup specificProviderAddRadio;

  private ACLabelContainer specificProviderAddRadioContainer;

  private ACListModelAdapter specificProviderAddRadioModel;

  private ACRadioButtonItem specificProviderAddRadioItem1;

  private ACRadioButtonItem specificProviderAddRadioItem2;

  private ACRadioButtonItem specificProviderAddRadioItem3;

  private ACRadioButtonItem specificProviderAddRadioItem4;

  private ACBackLabelContainer houmonKaigoTimeContainer;

  private ACTimeComboBox houmonKaigoBeginTime;

  private ACLabelContainer houmonKaigoBeginTimeContainer;

  private ACComboBoxModelAdapter houmonKaigoBeginTimeModel;

  private ACTimeComboBox houmonKaigoEndTime;

  private ACLabelContainer houmonKaigoEndTimeContainer;

  private ACComboBoxModelAdapter houmonKaigoEndTimeModel;

  //getter

  /**
   * 訪問介護パターン領域を取得します。
   * @return 訪問介護パターン領域
   */
  public ACPanel getHoumonKaigoPatterns(){
    if(houmonKaigoPatterns==null){

      houmonKaigoPatterns = new ACPanel();

      addHoumonKaigoPatterns();
    }
    return houmonKaigoPatterns;

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

      houmonKaigoServicePattern.setModel(getHoumonKaigoServicePatternModel());

      houmonKaigoServicePattern.setRenderBindPath("CONTENT");

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

      homonkaigoTeikyoTime.setModelBindPath("1110105");

      homonkaigoTeikyoTime.setModel(getHomonkaigoTeikyoTimeModel());

      homonkaigoTeikyoTime.setRenderBindPath("CONTENT");

      homonkaigoTeikyoTime.setBlankable(false);

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

      houmonKaigoInTime.setModelBindPath("1110104");

      houmonKaigoInTime.setModel(getHoumonKaigoInTimeModel());

      houmonKaigoInTime.setRenderBindPath("CONTENT");

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
   * 訪問者の級職を取得します。
   * @return 訪問者の級職
   */
  public ACClearableRadioButtonGroup getHoumonKaigoClass(){
    if(houmonKaigoClass==null){

      houmonKaigoClass = new ACClearableRadioButtonGroup();

      getHoumonKaigoClassContainer().setText("訪問者の級職");

      houmonKaigoClass.setBindPath("1110106");

      houmonKaigoClass.setModel(getHoumonKaigoClassModel());

      houmonKaigoClass.setUseClearButton(false);

      addHoumonKaigoClass();
    }
    return houmonKaigoClass;

  }

  /**
   * 訪問者の級職コンテナを取得します。
   * @return 訪問者の級職コンテナ
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
   * 訪問者の級職モデルを取得します。
   * @return 訪問者の級職モデル
   */
  protected ACListModelAdapter getHoumonKaigoClassModel(){
    if(houmonKaigoClassModel==null){
      houmonKaigoClassModel = new ACListModelAdapter();
      addHoumonKaigoClassModel();
    }
    return houmonKaigoClassModel;
  }

  /**
   * ３級以外を取得します。
   * @return ３級以外
   */
  public ACRadioButtonItem getHoumonKaigoClassOther(){
    if(houmonKaigoClassOther==null){

      houmonKaigoClassOther = new ACRadioButtonItem();

      houmonKaigoClassOther.setText("3級以外");

      houmonKaigoClassOther.setGroup(getHoumonKaigoClass());

      addHoumonKaigoClassOther();
    }
    return houmonKaigoClassOther;

  }

  /**
   * ３級を取得します。
   * @return ３級
   */
  public ACRadioButtonItem getHoumonKaigoClass3(){
    if(houmonKaigoClass3==null){

      houmonKaigoClass3 = new ACRadioButtonItem();

      houmonKaigoClass3.setText("3級");

      houmonKaigoClass3.setGroup(getHoumonKaigoClass());

      addHoumonKaigoClass3();
    }
    return houmonKaigoClass3;

  }

  /**
   * 訪問人数を取得します。
   * @return 訪問人数
   */
  public ACClearableRadioButtonGroup getHoumonKaigoNumberOfPeople(){
    if(houmonKaigoNumberOfPeople==null){

      houmonKaigoNumberOfPeople = new ACClearableRadioButtonGroup();

      getHoumonKaigoNumberOfPeopleContainer().setText("訪問人数");

      houmonKaigoNumberOfPeople.setBindPath("1110107");

      houmonKaigoNumberOfPeople.setModel(getHoumonKaigoNumberOfPeopleModel());

      houmonKaigoNumberOfPeople.setUseClearButton(false);

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
  public ACClearableRadioButtonGroup getHoumonKaigoTimeZone(){
    if(houmonKaigoTimeZone==null){

      houmonKaigoTimeZone = new ACClearableRadioButtonGroup();

      getHoumonKaigoTimeZoneContainer().setText("時間帯");

      houmonKaigoTimeZone.setBindPath("1110108");

      houmonKaigoTimeZone.setModel(getHoumonKaigoTimeZoneModel());

      houmonKaigoTimeZone.setUseClearButton(false);

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
  public ACClearableRadioButtonGroup getSpecificProviderAddRadio(){
    if(specificProviderAddRadio==null){

      specificProviderAddRadio = new ACClearableRadioButtonGroup();

      getSpecificProviderAddRadioContainer().setText("特定事業所加算");

      specificProviderAddRadio.setBindPath("1110109");

      specificProviderAddRadio.setModel(getSpecificProviderAddRadioModel());

      specificProviderAddRadio.setUseClearButton(false);

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

      specificProviderAddRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

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
   * 提供時間コンテナを取得します。
   * @return 提供時間コンテナ
   */
  public ACBackLabelContainer getHoumonKaigoTimeContainer(){
    if(houmonKaigoTimeContainer==null){

      houmonKaigoTimeContainer = new ACBackLabelContainer();

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

      houmonKaigoBeginTime.setModel(getHoumonKaigoBeginTimeModel());

      houmonKaigoBeginTime.setRenderBindPath("CONTENT");

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

      houmonKaigoEndTime.setModel(getHoumonKaigoEndTimeModel());

      houmonKaigoEndTime.setRenderBindPath("CONTENT");

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
   * コンストラクタです。
   */
  public QS001101Design() {

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

    this.add(getHoumonKaigoPatterns(), VRLayout.CLIENT);

  }

  /**
   * 訪問介護パターン領域に内部項目を追加します。
   */
  protected void addHoumonKaigoPatterns(){

    houmonKaigoPatterns.add(getHoumonKaigoServicePatternContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKaigoPatterns.add(getHomonkaigoTeikyoTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKaigoPatterns.add(getHoumonKaigoInTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKaigoPatterns.add(getHoumonKaigoClassContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKaigoPatterns.add(getHoumonKaigoNumberOfPeopleContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKaigoPatterns.add(getHoumonKaigoTimeZoneContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKaigoPatterns.add(getSpecificProviderAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKaigoPatterns.add(getHoumonKaigoTimeContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

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
   * 訪問者の級職に内部項目を追加します。
   */
  protected void addHoumonKaigoClass(){

  }

  /**
   * 訪問者の級職モデルに内部項目を追加します。
   */
  protected void addHoumonKaigoClassModel(){

    getHoumonKaigoClassOther().setButtonIndex(1);
    getHoumonKaigoClassModel().add(getHoumonKaigoClassOther());

    getHoumonKaigoClass3().setButtonIndex(2);
    getHoumonKaigoClassModel().add(getHoumonKaigoClass3());

  }

  /**
   * ３級以外に内部項目を追加します。
   */
  protected void addHoumonKaigoClassOther(){

  }

  /**
   * ３級に内部項目を追加します。
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
      ACFrame.debugStart(new ACAffairInfo(QS001101Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001101Design getThis() {
    return this;
  }
}
