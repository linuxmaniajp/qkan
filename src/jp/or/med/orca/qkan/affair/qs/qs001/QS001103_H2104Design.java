
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
 * 開発者: 田中　統蔵
 * 作成日: 2009/03/13  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン訪問看護（介護） (QS001103_H2104)
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
 * サービスパターン訪問看護（介護）画面項目デザイン(QS001103_H2104) 
 */
public class QS001103_H2104Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel houmonKangoKaigoPatterns;

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACClearableRadioButtonGroup houmonKangoKaigoFacilityType;

  private ACLabelContainer houmonKangoKaigoFacilityTypeContainer;

  private ACListModelAdapter houmonKangoKaigoFacilityTypeModel;

  private ACRadioButtonItem houmonKangoKaigoStation;

  private ACRadioButtonItem houmonKangoKaigoMedicalInstitution;

  private ACClearableRadioButtonGroup houmonKangoKaigoClass;

  private ACLabelContainer houmonKangoKaigoClassContainer;

  private ACListModelAdapter houmonKangoKaigoClassModel;

  private ACRadioButtonItem houmonKangoKaigoClass1;

  private ACRadioButtonItem houmonKangoKaigoClass2;

  private ACRadioButtonItem houmonKangoKaigoClass3;

  private ACClearableRadioButtonGroup houmonKangoKaigoTime;

  private ACLabelContainer houmonKangoKaigoTimeContainer;

  private ACListModelAdapter houmonKangoKaigoTimeModel;

  private ACRadioButtonItem houmonKangoKaigoTime4;

  private ACRadioButtonItem houmonKangoKaigoTime1;

  private ACRadioButtonItem houmonKangoKaigoTime2;

  private ACRadioButtonItem houmonKangoKaigoTime3;

  private ACClearableRadioButtonGroup houmonKangoKaigoTimeZone;

  private ACLabelContainer houmonKangoKaigoTimeZoneContainer;

  private ACListModelAdapter houmonKangoKaigoTimeZoneModel;

  private ACRadioButtonItem houmonKangoKaigoTimeZoneNormal;

  private ACRadioButtonItem houmonKangoKaigoTimeZoneEarlyMorning;

  private ACRadioButtonItem houmonKangoKaigoTimeZoneNighttime;

  private ACRadioButtonItem houmonKangoKaigoTimeZoneMidnight;

  private ACClearableRadioButtonGroup houmonKangoKaigoSpecialManageRadio;

  private ACLabelContainer houmonKangoKaigoSpecialManageRadioContainer;

  private ACListModelAdapter houmonKangoKaigoSpecialManageRadioModel;

  private ACRadioButtonItem houmonKangoKaigoSpecialManageRadioItem1;

  private ACRadioButtonItem houmonKangoKaigoSpecialManageRadioItem2;

  private ACClearableRadioButtonGroup houmonKangoKaigoLongTime;

  private ACLabelContainer houmonKangoKaigoLongTimeContainer;

  private ACListModelAdapter houmonKangoKaigoLongTimeModel;

  private ACRadioButtonItem houmonKangoKaigoLongTimeItem1;

  private ACRadioButtonItem houmonKangoKaigoLongTimeItem2;

  private ACBackLabelContainer houmonKangoKaigoTimeContena;

  private ACTimeComboBox houmonKangoKaigoBeginTime;

  private ACLabelContainer houmonKangoKaigoBeginTimeContainer;

  private ACComboBoxModelAdapter houmonKangoKaigoBeginTimeModel;

  private ACTimeComboBox houmonKangoKaigoEndTime;

  private ACLabelContainer houmonKangoKaigoEndTimeContainer;

  private ACComboBoxModelAdapter houmonKangoKaigoEndTimeModel;

  private ACPanel tab2;

  private ACClearableRadioButtonGroup houmonKangoKaigoUrgentTimeRadio;

  private ACLabelContainer houmonKangoKaigoUrgentTimeRadioContainer;

  private ACListModelAdapter houmonKangoKaigoUrgentTimeRadioModel;

  private ACRadioButtonItem houmonKangoKaigoUrgentTimeRadioItem1;

  private ACRadioButtonItem houmonKangoKaigoUrgentTimeRadioItem2;

  private ACClearableRadioButtonGroup houmonKangoKaigoTerminalRadio;

  private ACLabelContainer houmonKangoKaigoTerminalRadioContainer;

  private ACListModelAdapter houmonKangoKaigoTerminalRadioModel;

  private ACRadioButtonItem houmonKangoKaigoTerminalRadioItem1;

  private ACRadioButtonItem houmonKangoKaigoTerminalRadioItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACValueArrayRadioButtonGroup houmonKangoNumberOfPeople;

  private ACLabelContainer houmonKangoNumberOfPeopleContainer;

  private ACListModelAdapter houmonKangoNumberOfPeopleModel;

  private ACRadioButtonItem houmonKangoNumberOfPeople1;

  private ACRadioButtonItem houmonKangoNumberOfPeople2;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRafioRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRafioRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRafioRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaRafioRadioItem1;

  private ACRadioButtonItem providerAddMountainousAreaRafioRadioItem2;

  //getter

  /**
   * 訪問看護（介護）パターン領域）を取得します。
   * @return 訪問看護（介護）パターン領域）
   */
  public ACPanel getHoumonKangoKaigoPatterns(){
    if(houmonKangoKaigoPatterns==null){

      houmonKangoKaigoPatterns = new ACPanel();

      addHoumonKangoKaigoPatterns();
    }
    return houmonKangoKaigoPatterns;

  }

  /**
   * タブを取得します。
   * @return タブ
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

      addTab1();
    }
    return tab1;

  }

  /**
   * 訪問看護施設種別を取得します。
   * @return 訪問看護施設種別
   */
  public ACClearableRadioButtonGroup getHoumonKangoKaigoFacilityType(){
    if(houmonKangoKaigoFacilityType==null){

      houmonKangoKaigoFacilityType = new ACClearableRadioButtonGroup();

      getHoumonKangoKaigoFacilityTypeContainer().setText("施設等の区分");

      houmonKangoKaigoFacilityType.setBindPath("1130103");

      houmonKangoKaigoFacilityType.setUseClearButton(false);

      houmonKangoKaigoFacilityType.setModel(getHoumonKangoKaigoFacilityTypeModel());

      addHoumonKangoKaigoFacilityType();
    }
    return houmonKangoKaigoFacilityType;

  }

  /**
   * 訪問看護施設種別コンテナを取得します。
   * @return 訪問看護施設種別コンテナ
   */
  protected ACLabelContainer getHoumonKangoKaigoFacilityTypeContainer(){
    if(houmonKangoKaigoFacilityTypeContainer==null){
      houmonKangoKaigoFacilityTypeContainer = new ACLabelContainer();
      houmonKangoKaigoFacilityTypeContainer.setFollowChildEnabled(true);
      houmonKangoKaigoFacilityTypeContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoKaigoFacilityTypeContainer.add(getHoumonKangoKaigoFacilityType(), null);
    }
    return houmonKangoKaigoFacilityTypeContainer;
  }

  /**
   * 訪問看護施設種別モデルを取得します。
   * @return 訪問看護施設種別モデル
   */
  protected ACListModelAdapter getHoumonKangoKaigoFacilityTypeModel(){
    if(houmonKangoKaigoFacilityTypeModel==null){
      houmonKangoKaigoFacilityTypeModel = new ACListModelAdapter();
      addHoumonKangoKaigoFacilityTypeModel();
    }
    return houmonKangoKaigoFacilityTypeModel;
  }

  /**
   * 指定訪問看護ステーションを取得します。
   * @return 指定訪問看護ステーション
   */
  public ACRadioButtonItem getHoumonKangoKaigoStation(){
    if(houmonKangoKaigoStation==null){

      houmonKangoKaigoStation = new ACRadioButtonItem();

      houmonKangoKaigoStation.setText("指定訪問看護ステーション");

      houmonKangoKaigoStation.setGroup(getHoumonKangoKaigoFacilityType());

      houmonKangoKaigoStation.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoKaigoStation();
    }
    return houmonKangoKaigoStation;

  }

  /**
   * 医療機関を取得します。
   * @return 医療機関
   */
  public ACRadioButtonItem getHoumonKangoKaigoMedicalInstitution(){
    if(houmonKangoKaigoMedicalInstitution==null){

      houmonKangoKaigoMedicalInstitution = new ACRadioButtonItem();

      houmonKangoKaigoMedicalInstitution.setText("病院又は診療所");

      houmonKangoKaigoMedicalInstitution.setGroup(getHoumonKangoKaigoFacilityType());

      houmonKangoKaigoMedicalInstitution.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoMedicalInstitution();
    }
    return houmonKangoKaigoMedicalInstitution;

  }

  /**
   * 訪問看護職員区分を取得します。
   * @return 訪問看護職員区分
   */
  public ACClearableRadioButtonGroup getHoumonKangoKaigoClass(){
    if(houmonKangoKaigoClass==null){

      houmonKangoKaigoClass = new ACClearableRadioButtonGroup();

      getHoumonKangoKaigoClassContainer().setText("職員区分");

      houmonKangoKaigoClass.setBindPath("1130104");

      houmonKangoKaigoClass.setUseClearButton(false);

      houmonKangoKaigoClass.setModel(getHoumonKangoKaigoClassModel());

      addHoumonKangoKaigoClass();
    }
    return houmonKangoKaigoClass;

  }

  /**
   * 訪問看護職員区分コンテナを取得します。
   * @return 訪問看護職員区分コンテナ
   */
  protected ACLabelContainer getHoumonKangoKaigoClassContainer(){
    if(houmonKangoKaigoClassContainer==null){
      houmonKangoKaigoClassContainer = new ACLabelContainer();
      houmonKangoKaigoClassContainer.setFollowChildEnabled(true);
      houmonKangoKaigoClassContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoKaigoClassContainer.add(getHoumonKangoKaigoClass(), null);
    }
    return houmonKangoKaigoClassContainer;
  }

  /**
   * 訪問看護職員区分モデルを取得します。
   * @return 訪問看護職員区分モデル
   */
  protected ACListModelAdapter getHoumonKangoKaigoClassModel(){
    if(houmonKangoKaigoClassModel==null){
      houmonKangoKaigoClassModel = new ACListModelAdapter();
      addHoumonKangoKaigoClassModel();
    }
    return houmonKangoKaigoClassModel;
  }

  /**
   * 正看を取得します。
   * @return 正看
   */
  public ACRadioButtonItem getHoumonKangoKaigoClass1(){
    if(houmonKangoKaigoClass1==null){

      houmonKangoKaigoClass1 = new ACRadioButtonItem();

      houmonKangoKaigoClass1.setText("正看等");

      houmonKangoKaigoClass1.setGroup(getHoumonKangoKaigoClass());

      houmonKangoKaigoClass1.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoClass1();
    }
    return houmonKangoKaigoClass1;

  }

  /**
   * 准看を取得します。
   * @return 准看
   */
  public ACRadioButtonItem getHoumonKangoKaigoClass2(){
    if(houmonKangoKaigoClass2==null){

      houmonKangoKaigoClass2 = new ACRadioButtonItem();

      houmonKangoKaigoClass2.setText("准看");

      houmonKangoKaigoClass2.setGroup(getHoumonKangoKaigoClass());

      houmonKangoKaigoClass2.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoKaigoClass2();
    }
    return houmonKangoKaigoClass2;

  }

  /**
   * 理学療法士又は作業療法士又は言語聴覚士を取得します。
   * @return 理学療法士又は作業療法士又は言語聴覚士
   */
  public ACRadioButtonItem getHoumonKangoKaigoClass3(){
    if(houmonKangoKaigoClass3==null){

      houmonKangoKaigoClass3 = new ACRadioButtonItem();

      houmonKangoKaigoClass3.setText("PT、OT、ST");

      houmonKangoKaigoClass3.setGroup(getHoumonKangoKaigoClass());

      houmonKangoKaigoClass3.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoClass3();
    }
    return houmonKangoKaigoClass3;

  }

  /**
   * 訪問看護時間区分を取得します。
   * @return 訪問看護時間区分
   */
  public ACClearableRadioButtonGroup getHoumonKangoKaigoTime(){
    if(houmonKangoKaigoTime==null){

      houmonKangoKaigoTime = new ACClearableRadioButtonGroup();

      getHoumonKangoKaigoTimeContainer().setText("時間区分");

      houmonKangoKaigoTime.setBindPath("1130111");

      houmonKangoKaigoTime.setUseClearButton(false);

      houmonKangoKaigoTime.setModel(getHoumonKangoKaigoTimeModel());

      addHoumonKangoKaigoTime();
    }
    return houmonKangoKaigoTime;

  }

  /**
   * 訪問看護時間区分コンテナを取得します。
   * @return 訪問看護時間区分コンテナ
   */
  protected ACLabelContainer getHoumonKangoKaigoTimeContainer(){
    if(houmonKangoKaigoTimeContainer==null){
      houmonKangoKaigoTimeContainer = new ACLabelContainer();
      houmonKangoKaigoTimeContainer.setFollowChildEnabled(true);
      houmonKangoKaigoTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoKaigoTimeContainer.add(getHoumonKangoKaigoTime(), null);
    }
    return houmonKangoKaigoTimeContainer;
  }

  /**
   * 訪問看護時間区分モデルを取得します。
   * @return 訪問看護時間区分モデル
   */
  protected ACListModelAdapter getHoumonKangoKaigoTimeModel(){
    if(houmonKangoKaigoTimeModel==null){
      houmonKangoKaigoTimeModel = new ACListModelAdapter();
      addHoumonKangoKaigoTimeModel();
    }
    return houmonKangoKaigoTimeModel;
  }

  /**
   * 20分未満を取得します。
   * @return 20分未満
   */
  public ACRadioButtonItem getHoumonKangoKaigoTime4(){
    if(houmonKangoKaigoTime4==null){

      houmonKangoKaigoTime4 = new ACRadioButtonItem();

      houmonKangoKaigoTime4.setText("20分未満");

      houmonKangoKaigoTime4.setGroup(getHoumonKangoKaigoTime());

      houmonKangoKaigoTime4.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoTime4();
    }
    return houmonKangoKaigoTime4;

  }

  /**
   * 30分未満を取得します。
   * @return 30分未満
   */
  public ACRadioButtonItem getHoumonKangoKaigoTime1(){
    if(houmonKangoKaigoTime1==null){

      houmonKangoKaigoTime1 = new ACRadioButtonItem();

      houmonKangoKaigoTime1.setText("30分未満");

      houmonKangoKaigoTime1.setGroup(getHoumonKangoKaigoTime());

      houmonKangoKaigoTime1.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoKaigoTime1();
    }
    return houmonKangoKaigoTime1;

  }

  /**
   * 30分以上、1時間未満を取得します。
   * @return 30分以上、1時間未満
   */
  public ACRadioButtonItem getHoumonKangoKaigoTime2(){
    if(houmonKangoKaigoTime2==null){

      houmonKangoKaigoTime2 = new ACRadioButtonItem();

      houmonKangoKaigoTime2.setText("30分以上、1時間未満");

      houmonKangoKaigoTime2.setGroup(getHoumonKangoKaigoTime());

      houmonKangoKaigoTime2.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoKaigoTime2();
    }
    return houmonKangoKaigoTime2;

  }

  /**
   * 1時間以上、1時間半未満を取得します。
   * @return 1時間以上、1時間半未満
   */
  public ACRadioButtonItem getHoumonKangoKaigoTime3(){
    if(houmonKangoKaigoTime3==null){

      houmonKangoKaigoTime3 = new ACRadioButtonItem();

      houmonKangoKaigoTime3.setText("1時間以上、1時間半未満");

      houmonKangoKaigoTime3.setGroup(getHoumonKangoKaigoTime());

      houmonKangoKaigoTime3.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoKaigoTime3();
    }
    return houmonKangoKaigoTime3;

  }

  /**
   * 訪問看護介護時間帯を取得します。
   * @return 訪問看護介護時間帯
   */
  public ACClearableRadioButtonGroup getHoumonKangoKaigoTimeZone(){
    if(houmonKangoKaigoTimeZone==null){

      houmonKangoKaigoTimeZone = new ACClearableRadioButtonGroup();

      getHoumonKangoKaigoTimeZoneContainer().setText("時間帯");

      houmonKangoKaigoTimeZone.setBindPath("1130106");

      houmonKangoKaigoTimeZone.setUseClearButton(false);

      houmonKangoKaigoTimeZone.setModel(getHoumonKangoKaigoTimeZoneModel());

      addHoumonKangoKaigoTimeZone();
    }
    return houmonKangoKaigoTimeZone;

  }

  /**
   * 訪問看護介護時間帯コンテナを取得します。
   * @return 訪問看護介護時間帯コンテナ
   */
  protected ACLabelContainer getHoumonKangoKaigoTimeZoneContainer(){
    if(houmonKangoKaigoTimeZoneContainer==null){
      houmonKangoKaigoTimeZoneContainer = new ACLabelContainer();
      houmonKangoKaigoTimeZoneContainer.setFollowChildEnabled(true);
      houmonKangoKaigoTimeZoneContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoKaigoTimeZoneContainer.add(getHoumonKangoKaigoTimeZone(), null);
    }
    return houmonKangoKaigoTimeZoneContainer;
  }

  /**
   * 訪問看護介護時間帯モデルを取得します。
   * @return 訪問看護介護時間帯モデル
   */
  protected ACListModelAdapter getHoumonKangoKaigoTimeZoneModel(){
    if(houmonKangoKaigoTimeZoneModel==null){
      houmonKangoKaigoTimeZoneModel = new ACListModelAdapter();
      addHoumonKangoKaigoTimeZoneModel();
    }
    return houmonKangoKaigoTimeZoneModel;
  }

  /**
   * 通常を取得します。
   * @return 通常
   */
  public ACRadioButtonItem getHoumonKangoKaigoTimeZoneNormal(){
    if(houmonKangoKaigoTimeZoneNormal==null){

      houmonKangoKaigoTimeZoneNormal = new ACRadioButtonItem();

      houmonKangoKaigoTimeZoneNormal.setText("通常");

      houmonKangoKaigoTimeZoneNormal.setGroup(getHoumonKangoKaigoTimeZone());

      houmonKangoKaigoTimeZoneNormal.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoTimeZoneNormal();
    }
    return houmonKangoKaigoTimeZoneNormal;

  }

  /**
   * 早朝を取得します。
   * @return 早朝
   */
  public ACRadioButtonItem getHoumonKangoKaigoTimeZoneEarlyMorning(){
    if(houmonKangoKaigoTimeZoneEarlyMorning==null){

      houmonKangoKaigoTimeZoneEarlyMorning = new ACRadioButtonItem();

      houmonKangoKaigoTimeZoneEarlyMorning.setText("早朝");

      houmonKangoKaigoTimeZoneEarlyMorning.setGroup(getHoumonKangoKaigoTimeZone());

      houmonKangoKaigoTimeZoneEarlyMorning.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoTimeZoneEarlyMorning();
    }
    return houmonKangoKaigoTimeZoneEarlyMorning;

  }

  /**
   * 夜間を取得します。
   * @return 夜間
   */
  public ACRadioButtonItem getHoumonKangoKaigoTimeZoneNighttime(){
    if(houmonKangoKaigoTimeZoneNighttime==null){

      houmonKangoKaigoTimeZoneNighttime = new ACRadioButtonItem();

      houmonKangoKaigoTimeZoneNighttime.setText("夜間");

      houmonKangoKaigoTimeZoneNighttime.setGroup(getHoumonKangoKaigoTimeZone());

      houmonKangoKaigoTimeZoneNighttime.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoTimeZoneNighttime();
    }
    return houmonKangoKaigoTimeZoneNighttime;

  }

  /**
   * 深夜を取得します。
   * @return 深夜
   */
  public ACRadioButtonItem getHoumonKangoKaigoTimeZoneMidnight(){
    if(houmonKangoKaigoTimeZoneMidnight==null){

      houmonKangoKaigoTimeZoneMidnight = new ACRadioButtonItem();

      houmonKangoKaigoTimeZoneMidnight.setText("深夜");

      houmonKangoKaigoTimeZoneMidnight.setGroup(getHoumonKangoKaigoTimeZone());

      houmonKangoKaigoTimeZoneMidnight.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoTimeZoneMidnight();
    }
    return houmonKangoKaigoTimeZoneMidnight;

  }

  /**
   * 特別管理加算を取得します。
   * @return 特別管理加算
   */
  public ACClearableRadioButtonGroup getHoumonKangoKaigoSpecialManageRadio(){
    if(houmonKangoKaigoSpecialManageRadio==null){

      houmonKangoKaigoSpecialManageRadio = new ACClearableRadioButtonGroup();

      getHoumonKangoKaigoSpecialManageRadioContainer().setText("特別管理加算");

      houmonKangoKaigoSpecialManageRadio.setBindPath("1130109");

      houmonKangoKaigoSpecialManageRadio.setUseClearButton(false);

      houmonKangoKaigoSpecialManageRadio.setModel(getHoumonKangoKaigoSpecialManageRadioModel());

      addHoumonKangoKaigoSpecialManageRadio();
    }
    return houmonKangoKaigoSpecialManageRadio;

  }

  /**
   * 特別管理加算コンテナを取得します。
   * @return 特別管理加算コンテナ
   */
  protected ACLabelContainer getHoumonKangoKaigoSpecialManageRadioContainer(){
    if(houmonKangoKaigoSpecialManageRadioContainer==null){
      houmonKangoKaigoSpecialManageRadioContainer = new ACLabelContainer();
      houmonKangoKaigoSpecialManageRadioContainer.setFollowChildEnabled(true);
      houmonKangoKaigoSpecialManageRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoKaigoSpecialManageRadioContainer.add(getHoumonKangoKaigoSpecialManageRadio(), null);
    }
    return houmonKangoKaigoSpecialManageRadioContainer;
  }

  /**
   * 特別管理加算モデルを取得します。
   * @return 特別管理加算モデル
   */
  protected ACListModelAdapter getHoumonKangoKaigoSpecialManageRadioModel(){
    if(houmonKangoKaigoSpecialManageRadioModel==null){
      houmonKangoKaigoSpecialManageRadioModel = new ACListModelAdapter();
      addHoumonKangoKaigoSpecialManageRadioModel();
    }
    return houmonKangoKaigoSpecialManageRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonKangoKaigoSpecialManageRadioItem1(){
    if(houmonKangoKaigoSpecialManageRadioItem1==null){

      houmonKangoKaigoSpecialManageRadioItem1 = new ACRadioButtonItem();

      houmonKangoKaigoSpecialManageRadioItem1.setText("なし");

      houmonKangoKaigoSpecialManageRadioItem1.setGroup(getHoumonKangoKaigoSpecialManageRadio());

      houmonKangoKaigoSpecialManageRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoSpecialManageRadioItem1();
    }
    return houmonKangoKaigoSpecialManageRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonKangoKaigoSpecialManageRadioItem2(){
    if(houmonKangoKaigoSpecialManageRadioItem2==null){

      houmonKangoKaigoSpecialManageRadioItem2 = new ACRadioButtonItem();

      houmonKangoKaigoSpecialManageRadioItem2.setText("あり");

      houmonKangoKaigoSpecialManageRadioItem2.setGroup(getHoumonKangoKaigoSpecialManageRadio());

      houmonKangoKaigoSpecialManageRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoSpecialManageRadioItem2();
    }
    return houmonKangoKaigoSpecialManageRadioItem2;

  }

  /**
   * 長時間訪問看護加算を取得します。
   * @return 長時間訪問看護加算
   */
  public ACClearableRadioButtonGroup getHoumonKangoKaigoLongTime(){
    if(houmonKangoKaigoLongTime==null){

      houmonKangoKaigoLongTime = new ACClearableRadioButtonGroup();

      getHoumonKangoKaigoLongTimeContainer().setText("長時間訪問看護加算");

      houmonKangoKaigoLongTime.setBindPath("1130114");

      houmonKangoKaigoLongTime.setUseClearButton(false);

      houmonKangoKaigoLongTime.setModel(getHoumonKangoKaigoLongTimeModel());

      addHoumonKangoKaigoLongTime();
    }
    return houmonKangoKaigoLongTime;

  }

  /**
   * 長時間訪問看護加算コンテナを取得します。
   * @return 長時間訪問看護加算コンテナ
   */
  protected ACLabelContainer getHoumonKangoKaigoLongTimeContainer(){
    if(houmonKangoKaigoLongTimeContainer==null){
      houmonKangoKaigoLongTimeContainer = new ACLabelContainer();
      houmonKangoKaigoLongTimeContainer.setFollowChildEnabled(true);
      houmonKangoKaigoLongTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoKaigoLongTimeContainer.add(getHoumonKangoKaigoLongTime(), null);
    }
    return houmonKangoKaigoLongTimeContainer;
  }

  /**
   * 長時間訪問看護加算モデルを取得します。
   * @return 長時間訪問看護加算モデル
   */
  protected ACListModelAdapter getHoumonKangoKaigoLongTimeModel(){
    if(houmonKangoKaigoLongTimeModel==null){
      houmonKangoKaigoLongTimeModel = new ACListModelAdapter();
      addHoumonKangoKaigoLongTimeModel();
    }
    return houmonKangoKaigoLongTimeModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonKangoKaigoLongTimeItem1(){
    if(houmonKangoKaigoLongTimeItem1==null){

      houmonKangoKaigoLongTimeItem1 = new ACRadioButtonItem();

      houmonKangoKaigoLongTimeItem1.setText("なし");

      houmonKangoKaigoLongTimeItem1.setGroup(getHoumonKangoKaigoLongTime());

      houmonKangoKaigoLongTimeItem1.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoLongTimeItem1();
    }
    return houmonKangoKaigoLongTimeItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonKangoKaigoLongTimeItem2(){
    if(houmonKangoKaigoLongTimeItem2==null){

      houmonKangoKaigoLongTimeItem2 = new ACRadioButtonItem();

      houmonKangoKaigoLongTimeItem2.setText("あり");

      houmonKangoKaigoLongTimeItem2.setGroup(getHoumonKangoKaigoLongTime());

      houmonKangoKaigoLongTimeItem2.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoLongTimeItem2();
    }
    return houmonKangoKaigoLongTimeItem2;

  }

  /**
   * 提供時間コンテナを取得します。
   * @return 提供時間コンテナ
   */
  public ACBackLabelContainer getHoumonKangoKaigoTimeContena(){
    if(houmonKangoKaigoTimeContena==null){

      houmonKangoKaigoTimeContena = new ACBackLabelContainer();

      addHoumonKangoKaigoTimeContena();
    }
    return houmonKangoKaigoTimeContena;

  }

  /**
   * 開始時刻コンボを取得します。
   * @return 開始時刻コンボ
   */
  public ACTimeComboBox getHoumonKangoKaigoBeginTime(){
    if(houmonKangoKaigoBeginTime==null){

      houmonKangoKaigoBeginTime = new ACTimeComboBox();

      getHoumonKangoKaigoBeginTimeContainer().setText("開始時刻");

      houmonKangoKaigoBeginTime.setBindPath("3");

      houmonKangoKaigoBeginTime.setModelBindPath("3");

      houmonKangoKaigoBeginTime.setRenderBindPath("CONTENT");

      houmonKangoKaigoBeginTime.setModel(getHoumonKangoKaigoBeginTimeModel());

      addHoumonKangoKaigoBeginTime();
    }
    return houmonKangoKaigoBeginTime;

  }

  /**
   * 開始時刻コンボコンテナを取得します。
   * @return 開始時刻コンボコンテナ
   */
  protected ACLabelContainer getHoumonKangoKaigoBeginTimeContainer(){
    if(houmonKangoKaigoBeginTimeContainer==null){
      houmonKangoKaigoBeginTimeContainer = new ACLabelContainer();
      houmonKangoKaigoBeginTimeContainer.setFollowChildEnabled(true);
      houmonKangoKaigoBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoKaigoBeginTimeContainer.add(getHoumonKangoKaigoBeginTime(), null);
    }
    return houmonKangoKaigoBeginTimeContainer;
  }

  /**
   * 開始時刻コンボモデルを取得します。
   * @return 開始時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getHoumonKangoKaigoBeginTimeModel(){
    if(houmonKangoKaigoBeginTimeModel==null){
      houmonKangoKaigoBeginTimeModel = new ACComboBoxModelAdapter();
      addHoumonKangoKaigoBeginTimeModel();
    }
    return houmonKangoKaigoBeginTimeModel;
  }

  /**
   * 終了時刻コンボを取得します。
   * @return 終了時刻コンボ
   */
  public ACTimeComboBox getHoumonKangoKaigoEndTime(){
    if(houmonKangoKaigoEndTime==null){

      houmonKangoKaigoEndTime = new ACTimeComboBox();

      getHoumonKangoKaigoEndTimeContainer().setText("終了時刻");

      houmonKangoKaigoEndTime.setBindPath("4");

      houmonKangoKaigoEndTime.setModelBindPath("4");

      houmonKangoKaigoEndTime.setRenderBindPath("CONTENT");

      houmonKangoKaigoEndTime.setModel(getHoumonKangoKaigoEndTimeModel());

      addHoumonKangoKaigoEndTime();
    }
    return houmonKangoKaigoEndTime;

  }

  /**
   * 終了時刻コンボコンテナを取得します。
   * @return 終了時刻コンボコンテナ
   */
  protected ACLabelContainer getHoumonKangoKaigoEndTimeContainer(){
    if(houmonKangoKaigoEndTimeContainer==null){
      houmonKangoKaigoEndTimeContainer = new ACLabelContainer();
      houmonKangoKaigoEndTimeContainer.setFollowChildEnabled(true);
      houmonKangoKaigoEndTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoKaigoEndTimeContainer.add(getHoumonKangoKaigoEndTime(), null);
    }
    return houmonKangoKaigoEndTimeContainer;
  }

  /**
   * 終了時刻コンボモデルを取得します。
   * @return 終了時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getHoumonKangoKaigoEndTimeModel(){
    if(houmonKangoKaigoEndTimeModel==null){
      houmonKangoKaigoEndTimeModel = new ACComboBoxModelAdapter();
      addHoumonKangoKaigoEndTimeModel();
    }
    return houmonKangoKaigoEndTimeModel;
  }

  /**
   * タブ2を取得します。
   * @return タブ2
   */
  public ACPanel getTab2(){
    if(tab2==null){

      tab2 = new ACPanel();

      tab2.setFollowChildEnabled(true);

      addTab2();
    }
    return tab2;

  }

  /**
   * 緊急時訪問看護加算を取得します。
   * @return 緊急時訪問看護加算
   */
  public ACClearableRadioButtonGroup getHoumonKangoKaigoUrgentTimeRadio(){
    if(houmonKangoKaigoUrgentTimeRadio==null){

      houmonKangoKaigoUrgentTimeRadio = new ACClearableRadioButtonGroup();

      getHoumonKangoKaigoUrgentTimeRadioContainer().setText("緊急時訪問看護加算");

      houmonKangoKaigoUrgentTimeRadio.setBindPath("1130108");

      houmonKangoKaigoUrgentTimeRadio.setUseClearButton(false);

      houmonKangoKaigoUrgentTimeRadio.setModel(getHoumonKangoKaigoUrgentTimeRadioModel());

      addHoumonKangoKaigoUrgentTimeRadio();
    }
    return houmonKangoKaigoUrgentTimeRadio;

  }

  /**
   * 緊急時訪問看護加算コンテナを取得します。
   * @return 緊急時訪問看護加算コンテナ
   */
  protected ACLabelContainer getHoumonKangoKaigoUrgentTimeRadioContainer(){
    if(houmonKangoKaigoUrgentTimeRadioContainer==null){
      houmonKangoKaigoUrgentTimeRadioContainer = new ACLabelContainer();
      houmonKangoKaigoUrgentTimeRadioContainer.setFollowChildEnabled(true);
      houmonKangoKaigoUrgentTimeRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoKaigoUrgentTimeRadioContainer.add(getHoumonKangoKaigoUrgentTimeRadio(), null);
    }
    return houmonKangoKaigoUrgentTimeRadioContainer;
  }

  /**
   * 緊急時訪問看護加算モデルを取得します。
   * @return 緊急時訪問看護加算モデル
   */
  protected ACListModelAdapter getHoumonKangoKaigoUrgentTimeRadioModel(){
    if(houmonKangoKaigoUrgentTimeRadioModel==null){
      houmonKangoKaigoUrgentTimeRadioModel = new ACListModelAdapter();
      addHoumonKangoKaigoUrgentTimeRadioModel();
    }
    return houmonKangoKaigoUrgentTimeRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonKangoKaigoUrgentTimeRadioItem1(){
    if(houmonKangoKaigoUrgentTimeRadioItem1==null){

      houmonKangoKaigoUrgentTimeRadioItem1 = new ACRadioButtonItem();

      houmonKangoKaigoUrgentTimeRadioItem1.setText("なし");

      houmonKangoKaigoUrgentTimeRadioItem1.setGroup(getHoumonKangoKaigoUrgentTimeRadio());

      houmonKangoKaigoUrgentTimeRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoUrgentTimeRadioItem1();
    }
    return houmonKangoKaigoUrgentTimeRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonKangoKaigoUrgentTimeRadioItem2(){
    if(houmonKangoKaigoUrgentTimeRadioItem2==null){

      houmonKangoKaigoUrgentTimeRadioItem2 = new ACRadioButtonItem();

      houmonKangoKaigoUrgentTimeRadioItem2.setText("あり");

      houmonKangoKaigoUrgentTimeRadioItem2.setGroup(getHoumonKangoKaigoUrgentTimeRadio());

      houmonKangoKaigoUrgentTimeRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoUrgentTimeRadioItem2();
    }
    return houmonKangoKaigoUrgentTimeRadioItem2;

  }

  /**
   * ターミナルケア加算を取得します。
   * @return ターミナルケア加算
   */
  public ACClearableRadioButtonGroup getHoumonKangoKaigoTerminalRadio(){
    if(houmonKangoKaigoTerminalRadio==null){

      houmonKangoKaigoTerminalRadio = new ACClearableRadioButtonGroup();

      getHoumonKangoKaigoTerminalRadioContainer().setText("ターミナルケア加算");

      houmonKangoKaigoTerminalRadio.setBindPath("1130110");

      houmonKangoKaigoTerminalRadio.setUseClearButton(false);

      houmonKangoKaigoTerminalRadio.setModel(getHoumonKangoKaigoTerminalRadioModel());

      addHoumonKangoKaigoTerminalRadio();
    }
    return houmonKangoKaigoTerminalRadio;

  }

  /**
   * ターミナルケア加算コンテナを取得します。
   * @return ターミナルケア加算コンテナ
   */
  protected ACLabelContainer getHoumonKangoKaigoTerminalRadioContainer(){
    if(houmonKangoKaigoTerminalRadioContainer==null){
      houmonKangoKaigoTerminalRadioContainer = new ACLabelContainer();
      houmonKangoKaigoTerminalRadioContainer.setFollowChildEnabled(true);
      houmonKangoKaigoTerminalRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoKaigoTerminalRadioContainer.add(getHoumonKangoKaigoTerminalRadio(), null);
    }
    return houmonKangoKaigoTerminalRadioContainer;
  }

  /**
   * ターミナルケア加算モデルを取得します。
   * @return ターミナルケア加算モデル
   */
  protected ACListModelAdapter getHoumonKangoKaigoTerminalRadioModel(){
    if(houmonKangoKaigoTerminalRadioModel==null){
      houmonKangoKaigoTerminalRadioModel = new ACListModelAdapter();
      addHoumonKangoKaigoTerminalRadioModel();
    }
    return houmonKangoKaigoTerminalRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonKangoKaigoTerminalRadioItem1(){
    if(houmonKangoKaigoTerminalRadioItem1==null){

      houmonKangoKaigoTerminalRadioItem1 = new ACRadioButtonItem();

      houmonKangoKaigoTerminalRadioItem1.setText("なし");

      houmonKangoKaigoTerminalRadioItem1.setGroup(getHoumonKangoKaigoTerminalRadio());

      houmonKangoKaigoTerminalRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoTerminalRadioItem1();
    }
    return houmonKangoKaigoTerminalRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonKangoKaigoTerminalRadioItem2(){
    if(houmonKangoKaigoTerminalRadioItem2==null){

      houmonKangoKaigoTerminalRadioItem2 = new ACRadioButtonItem();

      houmonKangoKaigoTerminalRadioItem2.setText("あり");

      houmonKangoKaigoTerminalRadioItem2.setGroup(getHoumonKangoKaigoTerminalRadio());

      houmonKangoKaigoTerminalRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoTerminalRadioItem2();
    }
    return houmonKangoKaigoTerminalRadioItem2;

  }

  /**
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1130113");

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,2});

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
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("あり");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem2();
    }
    return serviceAddProvisionStructuralRadioItem2;

  }

  /**
   * 訪問人数を取得します。
   * @return 訪問人数
   */
  public ACValueArrayRadioButtonGroup getHoumonKangoNumberOfPeople(){
    if(houmonKangoNumberOfPeople==null){

      houmonKangoNumberOfPeople = new ACValueArrayRadioButtonGroup();

      getHoumonKangoNumberOfPeopleContainer().setText("訪問人数");

      houmonKangoNumberOfPeople.setBindPath("1130112");

      houmonKangoNumberOfPeople.setNoSelectIndex(0);

      houmonKangoNumberOfPeople.setUseClearButton(false);

      houmonKangoNumberOfPeople.setModel(getHoumonKangoNumberOfPeopleModel());

      houmonKangoNumberOfPeople.setValues(new int[]{1,2});

      addHoumonKangoNumberOfPeople();
    }
    return houmonKangoNumberOfPeople;

  }

  /**
   * 訪問人数コンテナを取得します。
   * @return 訪問人数コンテナ
   */
  protected ACLabelContainer getHoumonKangoNumberOfPeopleContainer(){
    if(houmonKangoNumberOfPeopleContainer==null){
      houmonKangoNumberOfPeopleContainer = new ACLabelContainer();
      houmonKangoNumberOfPeopleContainer.setFollowChildEnabled(true);
      houmonKangoNumberOfPeopleContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoNumberOfPeopleContainer.add(getHoumonKangoNumberOfPeople(), null);
    }
    return houmonKangoNumberOfPeopleContainer;
  }

  /**
   * 訪問人数モデルを取得します。
   * @return 訪問人数モデル
   */
  protected ACListModelAdapter getHoumonKangoNumberOfPeopleModel(){
    if(houmonKangoNumberOfPeopleModel==null){
      houmonKangoNumberOfPeopleModel = new ACListModelAdapter();
      addHoumonKangoNumberOfPeopleModel();
    }
    return houmonKangoNumberOfPeopleModel;
  }

  /**
   * 1人を取得します。
   * @return 1人
   */
  public ACRadioButtonItem getHoumonKangoNumberOfPeople1(){
    if(houmonKangoNumberOfPeople1==null){

      houmonKangoNumberOfPeople1 = new ACRadioButtonItem();

      houmonKangoNumberOfPeople1.setText("1人");

      houmonKangoNumberOfPeople1.setGroup(getHoumonKangoNumberOfPeople());

      houmonKangoNumberOfPeople1.setConstraints(VRLayout.FLOW);

      addHoumonKangoNumberOfPeople1();
    }
    return houmonKangoNumberOfPeople1;

  }

  /**
   * 2人を取得します。
   * @return 2人
   */
  public ACRadioButtonItem getHoumonKangoNumberOfPeople2(){
    if(houmonKangoNumberOfPeople2==null){

      houmonKangoNumberOfPeople2 = new ACRadioButtonItem();

      houmonKangoNumberOfPeople2.setText("2人");

      houmonKangoNumberOfPeople2.setGroup(getHoumonKangoNumberOfPeople());

      houmonKangoNumberOfPeople2.setConstraints(VRLayout.FLOW);

      addHoumonKangoNumberOfPeople2();
    }
    return houmonKangoNumberOfPeople2;

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
  public ACRadioButtonItem getProviderAddMountainousAreaRafioRadioItem1(){
    if(providerAddMountainousAreaRafioRadioItem1==null){

      providerAddMountainousAreaRafioRadioItem1 = new ACRadioButtonItem();

      providerAddMountainousAreaRafioRadioItem1.setText("なし");

      providerAddMountainousAreaRafioRadioItem1.setGroup(getProviderAddMountainousAreaRafioRadioGroup());

      providerAddMountainousAreaRafioRadioItem1.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaRafioRadioItem1();
    }
    return providerAddMountainousAreaRafioRadioItem1;

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
   * コンストラクタです。
   */
  public QS001103_H2104Design() {

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

    this.add(getHoumonKangoKaigoPatterns(), VRLayout.CLIENT);

  }

  /**
   * 訪問看護（介護）パターン領域）に内部項目を追加します。
   */
  protected void addHoumonKangoKaigoPatterns(){

    houmonKangoKaigoPatterns.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * タブに内部項目を追加します。
   */
  protected void addTabs(){

    tabs.addTab("1", getTab1());

    tabs.addTab("2", getTab2());

  }

  /**
   * タブ1に内部項目を追加します。
   */
  protected void addTab1(){

    tab1.add(getHoumonKangoKaigoFacilityTypeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoKaigoClassContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoKaigoTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoKaigoTimeZoneContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoKaigoSpecialManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoKaigoLongTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoKaigoTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * 訪問看護施設種別に内部項目を追加します。
   */
  protected void addHoumonKangoKaigoFacilityType(){

  }

  /**
   * 訪問看護施設種別モデルに内部項目を追加します。
   */
  protected void addHoumonKangoKaigoFacilityTypeModel(){

    getHoumonKangoKaigoStation().setButtonIndex(1);

    getHoumonKangoKaigoFacilityTypeModel().add(getHoumonKangoKaigoStation());

    getHoumonKangoKaigoMedicalInstitution().setButtonIndex(2);

    getHoumonKangoKaigoFacilityTypeModel().add(getHoumonKangoKaigoMedicalInstitution());

  }

  /**
   * 指定訪問看護ステーションに内部項目を追加します。
   */
  protected void addHoumonKangoKaigoStation(){

  }

  /**
   * 医療機関に内部項目を追加します。
   */
  protected void addHoumonKangoKaigoMedicalInstitution(){

  }

  /**
   * 訪問看護職員区分に内部項目を追加します。
   */
  protected void addHoumonKangoKaigoClass(){

  }

  /**
   * 訪問看護職員区分モデルに内部項目を追加します。
   */
  protected void addHoumonKangoKaigoClassModel(){

    getHoumonKangoKaigoClass1().setButtonIndex(1);

    getHoumonKangoKaigoClassModel().add(getHoumonKangoKaigoClass1());

    getHoumonKangoKaigoClass2().setButtonIndex(2);

    getHoumonKangoKaigoClassModel().add(getHoumonKangoKaigoClass2());

    getHoumonKangoKaigoClass3().setButtonIndex(3);

    getHoumonKangoKaigoClassModel().add(getHoumonKangoKaigoClass3());

  }

  /**
   * 正看に内部項目を追加します。
   */
  protected void addHoumonKangoKaigoClass1(){

  }

  /**
   * 准看に内部項目を追加します。
   */
  protected void addHoumonKangoKaigoClass2(){

  }

  /**
   * 理学療法士又は作業療法士又は言語聴覚士に内部項目を追加します。
   */
  protected void addHoumonKangoKaigoClass3(){

  }

  /**
   * 訪問看護時間区分に内部項目を追加します。
   */
  protected void addHoumonKangoKaigoTime(){

  }

  /**
   * 訪問看護時間区分モデルに内部項目を追加します。
   */
  protected void addHoumonKangoKaigoTimeModel(){

    getHoumonKangoKaigoTime4().setButtonIndex(1);

    getHoumonKangoKaigoTimeModel().add(getHoumonKangoKaigoTime4());

    getHoumonKangoKaigoTime1().setButtonIndex(2);

    getHoumonKangoKaigoTimeModel().add(getHoumonKangoKaigoTime1());

    getHoumonKangoKaigoTime2().setButtonIndex(3);

    getHoumonKangoKaigoTimeModel().add(getHoumonKangoKaigoTime2());

    getHoumonKangoKaigoTime3().setButtonIndex(4);

    getHoumonKangoKaigoTimeModel().add(getHoumonKangoKaigoTime3());

  }

  /**
   * 20分未満に内部項目を追加します。
   */
  protected void addHoumonKangoKaigoTime4(){

  }

  /**
   * 30分未満に内部項目を追加します。
   */
  protected void addHoumonKangoKaigoTime1(){

  }

  /**
   * 30分以上、1時間未満に内部項目を追加します。
   */
  protected void addHoumonKangoKaigoTime2(){

  }

  /**
   * 1時間以上、1時間半未満に内部項目を追加します。
   */
  protected void addHoumonKangoKaigoTime3(){

  }

  /**
   * 訪問看護介護時間帯に内部項目を追加します。
   */
  protected void addHoumonKangoKaigoTimeZone(){

  }

  /**
   * 訪問看護介護時間帯モデルに内部項目を追加します。
   */
  protected void addHoumonKangoKaigoTimeZoneModel(){

    getHoumonKangoKaigoTimeZoneNormal().setButtonIndex(1);

    getHoumonKangoKaigoTimeZoneModel().add(getHoumonKangoKaigoTimeZoneNormal());

    getHoumonKangoKaigoTimeZoneEarlyMorning().setButtonIndex(2);

    getHoumonKangoKaigoTimeZoneModel().add(getHoumonKangoKaigoTimeZoneEarlyMorning());

    getHoumonKangoKaigoTimeZoneNighttime().setButtonIndex(3);

    getHoumonKangoKaigoTimeZoneModel().add(getHoumonKangoKaigoTimeZoneNighttime());

    getHoumonKangoKaigoTimeZoneMidnight().setButtonIndex(4);

    getHoumonKangoKaigoTimeZoneModel().add(getHoumonKangoKaigoTimeZoneMidnight());

  }

  /**
   * 通常に内部項目を追加します。
   */
  protected void addHoumonKangoKaigoTimeZoneNormal(){

  }

  /**
   * 早朝に内部項目を追加します。
   */
  protected void addHoumonKangoKaigoTimeZoneEarlyMorning(){

  }

  /**
   * 夜間に内部項目を追加します。
   */
  protected void addHoumonKangoKaigoTimeZoneNighttime(){

  }

  /**
   * 深夜に内部項目を追加します。
   */
  protected void addHoumonKangoKaigoTimeZoneMidnight(){

  }

  /**
   * 特別管理加算に内部項目を追加します。
   */
  protected void addHoumonKangoKaigoSpecialManageRadio(){

  }

  /**
   * 特別管理加算モデルに内部項目を追加します。
   */
  protected void addHoumonKangoKaigoSpecialManageRadioModel(){

    getHoumonKangoKaigoSpecialManageRadioItem1().setButtonIndex(1);

    getHoumonKangoKaigoSpecialManageRadioModel().add(getHoumonKangoKaigoSpecialManageRadioItem1());

    getHoumonKangoKaigoSpecialManageRadioItem2().setButtonIndex(2);

    getHoumonKangoKaigoSpecialManageRadioModel().add(getHoumonKangoKaigoSpecialManageRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonKangoKaigoSpecialManageRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonKangoKaigoSpecialManageRadioItem2(){

  }

  /**
   * 長時間訪問看護加算に内部項目を追加します。
   */
  protected void addHoumonKangoKaigoLongTime(){

  }

  /**
   * 長時間訪問看護加算モデルに内部項目を追加します。
   */
  protected void addHoumonKangoKaigoLongTimeModel(){

    getHoumonKangoKaigoLongTimeItem1().setButtonIndex(1);

    getHoumonKangoKaigoLongTimeModel().add(getHoumonKangoKaigoLongTimeItem1());

    getHoumonKangoKaigoLongTimeItem2().setButtonIndex(2);

    getHoumonKangoKaigoLongTimeModel().add(getHoumonKangoKaigoLongTimeItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonKangoKaigoLongTimeItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonKangoKaigoLongTimeItem2(){

  }

  /**
   * 提供時間コンテナに内部項目を追加します。
   */
  protected void addHoumonKangoKaigoTimeContena(){

    houmonKangoKaigoTimeContena.add(getHoumonKangoKaigoBeginTimeContainer(), VRLayout.FLOW);

    houmonKangoKaigoTimeContena.add(getHoumonKangoKaigoEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * 開始時刻コンボに内部項目を追加します。
   */
  protected void addHoumonKangoKaigoBeginTime(){

  }

  /**
   * 開始時刻コンボモデルに内部項目を追加します。
   */
  protected void addHoumonKangoKaigoBeginTimeModel(){

  }

  /**
   * 終了時刻コンボに内部項目を追加します。
   */
  protected void addHoumonKangoKaigoEndTime(){

  }

  /**
   * 終了時刻コンボモデルに内部項目を追加します。
   */
  protected void addHoumonKangoKaigoEndTimeModel(){

  }

  /**
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getHoumonKangoKaigoUrgentTimeRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonKangoKaigoTerminalRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonKangoNumberOfPeopleContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getProviderAddMountainousAreaRafioRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 緊急時訪問看護加算に内部項目を追加します。
   */
  protected void addHoumonKangoKaigoUrgentTimeRadio(){

  }

  /**
   * 緊急時訪問看護加算モデルに内部項目を追加します。
   */
  protected void addHoumonKangoKaigoUrgentTimeRadioModel(){

    getHoumonKangoKaigoUrgentTimeRadioItem1().setButtonIndex(1);

    getHoumonKangoKaigoUrgentTimeRadioModel().add(getHoumonKangoKaigoUrgentTimeRadioItem1());

    getHoumonKangoKaigoUrgentTimeRadioItem2().setButtonIndex(2);

    getHoumonKangoKaigoUrgentTimeRadioModel().add(getHoumonKangoKaigoUrgentTimeRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonKangoKaigoUrgentTimeRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonKangoKaigoUrgentTimeRadioItem2(){

  }

  /**
   * ターミナルケア加算に内部項目を追加します。
   */
  protected void addHoumonKangoKaigoTerminalRadio(){

  }

  /**
   * ターミナルケア加算モデルに内部項目を追加します。
   */
  protected void addHoumonKangoKaigoTerminalRadioModel(){

    getHoumonKangoKaigoTerminalRadioItem1().setButtonIndex(1);

    getHoumonKangoKaigoTerminalRadioModel().add(getHoumonKangoKaigoTerminalRadioItem1());

    getHoumonKangoKaigoTerminalRadioItem2().setButtonIndex(2);

    getHoumonKangoKaigoTerminalRadioModel().add(getHoumonKangoKaigoTerminalRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonKangoKaigoTerminalRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonKangoKaigoTerminalRadioItem2(){

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

    getServiceAddProvisionStructuralRadioItem2().setButtonIndex(2);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * 訪問人数に内部項目を追加します。
   */
  protected void addHoumonKangoNumberOfPeople(){

  }

  /**
   * 訪問人数モデルに内部項目を追加します。
   */
  protected void addHoumonKangoNumberOfPeopleModel(){

    getHoumonKangoNumberOfPeople1().setButtonIndex(1);

    getHoumonKangoNumberOfPeopleModel().add(getHoumonKangoNumberOfPeople1());

    getHoumonKangoNumberOfPeople2().setButtonIndex(2);

    getHoumonKangoNumberOfPeopleModel().add(getHoumonKangoNumberOfPeople2());

  }

  /**
   * 1人に内部項目を追加します。
   */
  protected void addHoumonKangoNumberOfPeople1(){

  }

  /**
   * 2人に内部項目を追加します。
   */
  protected void addHoumonKangoNumberOfPeople2(){

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

    getProviderAddMountainousAreaRafioRadioItem1().setButtonIndex(1);

    getProviderAddMountainousAreaRafioRadioGroupModel().add(getProviderAddMountainousAreaRafioRadioItem1());

    getProviderAddMountainousAreaRafioRadioItem2().setButtonIndex(2);

    getProviderAddMountainousAreaRafioRadioGroupModel().add(getProviderAddMountainousAreaRafioRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRafioRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRafioRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001103_H2104Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001103_H2104Design getThis() {
    return this;
  }
}
