
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
 * 作成日: 2006/05/09  日本コンピューター株式会社 松本　幸一 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン介護予防訪問看護 (QS001132)
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
 * サービスパターン介護予防訪問看護画面項目デザイン(QS001132) 
 */
public class QS001132Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel preventionVisitNursingPatterns;

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

  private ACClearableRadioButtonGroup houmonKangoKaigoUrgentTimeRadio;

  private ACLabelContainer houmonKangoKaigoUrgentTimeRadioContainer;

  private ACListModelAdapter houmonKangoKaigoUrgentTimeRadioModel;

  private ACRadioButtonItem houmonKangoKaigoUrgentTimeRadioItem1;

  private ACRadioButtonItem houmonKangoKaigoUrgentTimeRadioItem2;

  private ACClearableRadioButtonGroup houmonKangoKaigoSpecialManageRadio;

  private ACLabelContainer houmonKangoKaigoSpecialManageRadioContainer;

  private ACListModelAdapter houmonKangoKaigoSpecialManageRadioModel;

  private ACRadioButtonItem houmonKangoKaigoSpecialManageRadioItem1;

  private ACRadioButtonItem houmonKangoKaigoSpecialManageRadioItem2;

  private ACBackLabelContainer houmonKangoKaigoTimeContena;

  private ACTimeComboBox houmonKangoKaigoBeginTime;

  private ACLabelContainer houmonKangoKaigoBeginTimeContainer;

  private ACComboBoxModelAdapter houmonKangoKaigoBeginTimeModel;

  private ACTimeComboBox houmonKangoKaigoEndTime;

  private ACLabelContainer houmonKangoKaigoEndTimeContainer;

  private ACComboBoxModelAdapter houmonKangoKaigoEndTimeModel;

  //getter

  /**
   * 介護予防訪問看護パターン領域を取得します。
   * @return 介護予防訪問看護パターン領域
   */
  public ACPanel getPreventionVisitNursingPatterns(){
    if(preventionVisitNursingPatterns==null){

      preventionVisitNursingPatterns = new ACPanel();

      addPreventionVisitNursingPatterns();
    }
    return preventionVisitNursingPatterns;

  }

  /**
   * 訪問看護施設種別を取得します。
   * @return 訪問看護施設種別
   */
  public ACClearableRadioButtonGroup getHoumonKangoKaigoFacilityType(){
    if(houmonKangoKaigoFacilityType==null){

      houmonKangoKaigoFacilityType = new ACClearableRadioButtonGroup();

      getHoumonKangoKaigoFacilityTypeContainer().setText("施設等の区分");

      houmonKangoKaigoFacilityType.setBindPath("1630101");

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

      houmonKangoKaigoClass.setBindPath("1630102");

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

      houmonKangoKaigoTime.setBindPath("1630103");

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

      houmonKangoKaigoTime3.setConstraints(VRLayout.FLOW);

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

      houmonKangoKaigoTimeZone.setBindPath("1630104");

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
   * 緊急時訪問看護加算を取得します。
   * @return 緊急時訪問看護加算
   */
  public ACClearableRadioButtonGroup getHoumonKangoKaigoUrgentTimeRadio(){
    if(houmonKangoKaigoUrgentTimeRadio==null){

      houmonKangoKaigoUrgentTimeRadio = new ACClearableRadioButtonGroup();

      getHoumonKangoKaigoUrgentTimeRadioContainer().setText("緊急時訪問看護加算");

      houmonKangoKaigoUrgentTimeRadio.setBindPath("1630105");

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
   * 特別管理加算を取得します。
   * @return 特別管理加算
   */
  public ACClearableRadioButtonGroup getHoumonKangoKaigoSpecialManageRadio(){
    if(houmonKangoKaigoSpecialManageRadio==null){

      houmonKangoKaigoSpecialManageRadio = new ACClearableRadioButtonGroup();

      getHoumonKangoKaigoSpecialManageRadioContainer().setText("特別管理加算");

      houmonKangoKaigoSpecialManageRadio.setBindPath("1630106");

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
   * コンストラクタです。
   */
  public QS001132Design() {

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

    this.add(getPreventionVisitNursingPatterns(), VRLayout.CLIENT);

  }

  /**
   * 介護予防訪問看護パターン領域に内部項目を追加します。
   */
  protected void addPreventionVisitNursingPatterns(){

    preventionVisitNursingPatterns.add(getHoumonKangoKaigoFacilityTypeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventionVisitNursingPatterns.add(getHoumonKangoKaigoClassContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventionVisitNursingPatterns.add(getHoumonKangoKaigoTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventionVisitNursingPatterns.add(getHoumonKangoKaigoTimeZoneContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventionVisitNursingPatterns.add(getHoumonKangoKaigoUrgentTimeRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventionVisitNursingPatterns.add(getHoumonKangoKaigoSpecialManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventionVisitNursingPatterns.add(getHoumonKangoKaigoTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

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
      ACFrame.debugStart(new ACAffairInfo(QS001132Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001132Design getThis() {
    return this;
  }
}
