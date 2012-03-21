
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
 * 作成日: 2012/03/06  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン訪問看護（介護） (QS001_11311_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Component;

import javax.swing.JTabbedPane;

import jp.nichicom.ac.component.ACIntegerCheckBox;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACTimeComboBox;
import jp.nichicom.ac.component.ACValueArrayRadioButtonGroup;
import jp.nichicom.ac.container.ACBackLabelContainer;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * サービスパターン訪問看護（介護）画面項目デザイン(QS001_11311_201204) 
 */
public class QS001_11311_201204Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel houmonKangoKaigoPatterns;

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup houmonKangoKaigoFacilityType;

  private ACLabelContainer houmonKangoKaigoFacilityTypeContainer;

  private ACListModelAdapter houmonKangoKaigoFacilityTypeModel;

  private ACRadioButtonItem houmonKangoKaigoStation;

  private ACRadioButtonItem houmonKangoKaigoMedicalInstitution;

  private ACRadioButtonItem houmonKangoKaigoFacilityTypeItem3;

  private ACValueArrayRadioButtonGroup houmonKangoKaigoClass;

  private ACLabelContainer houmonKangoKaigoClassContainer;

  private ACListModelAdapter houmonKangoKaigoClassModel;

  private ACRadioButtonItem houmonKangoKaigoClass1;

  private ACRadioButtonItem houmonKangoKaigoClass2;

  private ACRadioButtonItem houmonKangoKaigoClass3;

  private ACValueArrayRadioButtonGroup houmonKangoKaigoTime;

  private ACLabelContainer houmonKangoKaigoTimeContainer;

  private ACListModelAdapter houmonKangoKaigoTimeModel;

  private ACRadioButtonItem houmonKangoKaigoTime1;

  private ACRadioButtonItem houmonKangoKaigoTime2;

  private ACRadioButtonItem houmonKangoKaigoTime3;

  private ACRadioButtonItem houmonKangoKaigoTime4;

  private ACValueArrayRadioButtonGroup houmonKangoKaigoTimeZone;

  private ACLabelContainer houmonKangoKaigoTimeZoneContainer;

  private ACListModelAdapter houmonKangoKaigoTimeZoneModel;

  private ACRadioButtonItem houmonKangoKaigoTimeZoneNormal;

  private ACRadioButtonItem houmonKangoKaigoTimeZoneEarlyMorning;

  private ACRadioButtonItem houmonKangoKaigoTimeZoneNighttime;

  private ACRadioButtonItem houmonKangoKaigoTimeZoneMidnight;

  private ACValueArrayRadioButtonGroup specialManagementRadioGroup;

  private ACLabelContainer specialManagementRadioGroupContainer;

  private ACListModelAdapter specialManagementRadioGroupModel;

  private ACRadioButtonItem specialManagementRadioItem1;

  private ACRadioButtonItem specialManagementRadioItem2;

  private ACRadioButtonItem specialManagementRadioItem3;

  private ACIntegerCheckBox twoOrMoreTimesCheck;

  private ACIntegerCheckBox crackOnDayCheck;

  private ACIntegerCheckBox printable;

  private ACBackLabelContainer houmonKangoKaigoTimeContena;

  private ACTimeComboBox houmonKangoKaigoBeginTime;

  private ACLabelContainer houmonKangoKaigoBeginTimeContainer;

  private ACComboBoxModelAdapter houmonKangoKaigoBeginTimeModel;

  private ACTimeComboBox houmonKangoKaigoEndTime;

  private ACLabelContainer houmonKangoKaigoEndTimeContainer;

  private ACComboBoxModelAdapter houmonKangoKaigoEndTimeModel;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup houmonKangoKaigoLongTime;

  private ACLabelContainer houmonKangoKaigoLongTimeContainer;

  private ACListModelAdapter houmonKangoKaigoLongTimeModel;

  private ACRadioButtonItem houmonKangoKaigoLongTimeItem1;

  private ACRadioButtonItem houmonKangoKaigoLongTimeItem2;

  private ACValueArrayRadioButtonGroup houmonKangoKaigoUrgentTimeRadio;

  private ACLabelContainer houmonKangoKaigoUrgentTimeRadioContainer;

  private ACListModelAdapter houmonKangoKaigoUrgentTimeRadioModel;

  private ACRadioButtonItem houmonKangoKaigoUrgentTimeRadioItem1;

  private ACRadioButtonItem houmonKangoKaigoUrgentTimeRadioItem2;

  private ACValueArrayRadioButtonGroup houmonKangoKaigoUrgentTime2Radio;

  private ACLabelContainer houmonKangoKaigoUrgentTime2RadioContainer;

  private ACListModelAdapter houmonKangoKaigoUrgentTime2RadioModel;

  private ACRadioButtonItem houmonKangoKaigoUrgentTime2RadioItem1;

  private ACRadioButtonItem houmonKangoKaigoUrgentTime2RadioItem2;

  private ACRadioButtonItem houmonKangoKaigoUrgentTime2RadioItem3;

  private ACValueArrayRadioButtonGroup houmonKangoKaigoTerminalRadio;

  private ACLabelContainer houmonKangoKaigoTerminalRadioContainer;

  private ACListModelAdapter houmonKangoKaigoTerminalRadioModel;

  private ACRadioButtonItem houmonKangoKaigoTerminalRadioItem1;

  private ACRadioButtonItem houmonKangoKaigoTerminalRadioItem2;

  private ACValueArrayRadioButtonGroup initialAddRadioGroup;

  private ACLabelContainer initialAddRadioGroupContainer;

  private ACListModelAdapter initialAddRadioGroupModel;

  private ACRadioButtonItem initialAddRadioItem1;

  private ACRadioButtonItem initialAddRadioItem2;

  private ACValueArrayRadioButtonGroup leavingHospitalGuidanceAddRadioGroup;

  private ACLabelContainer leavingHospitalGuidanceAddRadioGroupContainer;

  private ACListModelAdapter leavingHospitalGuidanceAddRadioGroupModel;

  private ACRadioButtonItem leavingHospitalGuidanceAddRadioItem1;

  private ACRadioButtonItem leavingHospitalGuidanceAddRadioItem2;

  private ACValueArrayRadioButtonGroup cooperationMedicalCareAddRadioGroup;

  private ACLabelContainer cooperationMedicalCareAddRadioGroupContainer;

  private ACListModelAdapter cooperationMedicalCareAddRadioGroupModel;

  private ACRadioButtonItem cooperationMedicalCareAddRadioItem1;

  private ACRadioButtonItem cooperationMedicalCareAddRadioItem2;

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

  private ACValueArrayRadioButtonGroup houmonKangoNumberOfPeopleTime;

  private ACLabelContainer houmonKangoNumberOfPeopleTimeContainer;

  private ACListModelAdapter houmonKangoNumberOfPeopleTimeModel;

  private ACRadioButtonItem houmonKangoNumberOfPeopleTimeItem1;

  private ACRadioButtonItem houmonKangoNumberOfPeopleTimeItem2;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRafioRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRafioRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRafioRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaRafioRadioItem1;

  private ACRadioButtonItem providerAddMountainousAreaRafioRadioItem2;

  private ACPanel tab3;

  private ACValueArrayRadioButtonGroup houmonNeededRadio;

  private ACLabelContainer houmonNeededRadioContainer;

  private ACListModelAdapter houmonNeededRadioModel;

  private ACRadioButtonItem houmonNeededRadioItem1;

  private ACRadioButtonItem houmonNeededRadioItem2;

  private ACValueArrayRadioButtonGroup houmonNissuReduceRadio;

  private ACLabelContainer houmonNissuReduceRadioContainer;

  private ACListModelAdapter houmonNissuReduceRadioModel;

  private ACRadioButtonItem houmonNissuReduceRadioItem1;

  private ACRadioButtonItem houmonNissuReduceRadioItem2;

  private ACValueArrayRadioButtonGroup calculationDivision;

  private ACLabelContainer calculationDivisionContainer;

  private ACListModelAdapter calculationDivisionModel;

  private ACRadioButtonItem calculationDivisionNormal;

  private ACRadioButtonItem calculationDivisionAddOnly;

  //getter

  /**
   * 訪問看護（介護）パターン領域）を取得します。
   * @return 訪問看護（介護）パターン領域）
   */
  public ACPanel getHoumonKangoKaigoPatterns(){
    if(houmonKangoKaigoPatterns==null){

      houmonKangoKaigoPatterns = new ACPanel();

      houmonKangoKaigoPatterns.setFollowChildEnabled(true);

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
  public ACValueArrayRadioButtonGroup getHoumonKangoKaigoFacilityType(){
    if(houmonKangoKaigoFacilityType==null){

      houmonKangoKaigoFacilityType = new ACValueArrayRadioButtonGroup();

      getHoumonKangoKaigoFacilityTypeContainer().setText("施設等の区分");

      houmonKangoKaigoFacilityType.setBindPath("1130103");

      houmonKangoKaigoFacilityType.setUseClearButton(false);

      houmonKangoKaigoFacilityType.setModel(getHoumonKangoKaigoFacilityTypeModel());

      houmonKangoKaigoFacilityType.setValues(new int[]{1,2,3});

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

      houmonKangoKaigoMedicalInstitution.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoKaigoMedicalInstitution();
    }
    return houmonKangoKaigoMedicalInstitution;

  }

  /**
   * 定期巡回・随時対応サービスを取得します。
   * @return 定期巡回・随時対応サービス
   */
  public ACRadioButtonItem getHoumonKangoKaigoFacilityTypeItem3(){
    if(houmonKangoKaigoFacilityTypeItem3==null){

      houmonKangoKaigoFacilityTypeItem3 = new ACRadioButtonItem();

      houmonKangoKaigoFacilityTypeItem3.setText("定期巡回・随時対応サービス");

      houmonKangoKaigoFacilityTypeItem3.setGroup(getHoumonKangoKaigoFacilityType());

      houmonKangoKaigoFacilityTypeItem3.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoFacilityTypeItem3();
    }
    return houmonKangoKaigoFacilityTypeItem3;

  }

  /**
   * 訪問看護職員区分を取得します。
   * @return 訪問看護職員区分
   */
  public ACValueArrayRadioButtonGroup getHoumonKangoKaigoClass(){
    if(houmonKangoKaigoClass==null){

      houmonKangoKaigoClass = new ACValueArrayRadioButtonGroup();

      getHoumonKangoKaigoClassContainer().setText("職員区分");

      houmonKangoKaigoClass.setBindPath("1130104");

      houmonKangoKaigoClass.setUseClearButton(false);

      houmonKangoKaigoClass.setModel(getHoumonKangoKaigoClassModel());

      houmonKangoKaigoClass.setValues(new int[]{1,2,3});

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
  public ACValueArrayRadioButtonGroup getHoumonKangoKaigoTime(){
    if(houmonKangoKaigoTime==null){

      houmonKangoKaigoTime = new ACValueArrayRadioButtonGroup();

      getHoumonKangoKaigoTimeContainer().setText("時間区分");

      houmonKangoKaigoTime.setBindPath("1130111");

      houmonKangoKaigoTime.setUseClearButton(false);

      houmonKangoKaigoTime.setModel(getHoumonKangoKaigoTimeModel());

      houmonKangoKaigoTime.setValues(new int[]{1,2,3,4});

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
  public ACRadioButtonItem getHoumonKangoKaigoTime1(){
    if(houmonKangoKaigoTime1==null){

      houmonKangoKaigoTime1 = new ACRadioButtonItem();

      houmonKangoKaigoTime1.setText("20分未満");

      houmonKangoKaigoTime1.setGroup(getHoumonKangoKaigoTime());

      houmonKangoKaigoTime1.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoTime1();
    }
    return houmonKangoKaigoTime1;

  }

  /**
   * 30分未満を取得します。
   * @return 30分未満
   */
  public ACRadioButtonItem getHoumonKangoKaigoTime2(){
    if(houmonKangoKaigoTime2==null){

      houmonKangoKaigoTime2 = new ACRadioButtonItem();

      houmonKangoKaigoTime2.setText("30分未満");

      houmonKangoKaigoTime2.setGroup(getHoumonKangoKaigoTime());

      houmonKangoKaigoTime2.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoKaigoTime2();
    }
    return houmonKangoKaigoTime2;

  }

  /**
   * 30分以上、1時間未満を取得します。
   * @return 30分以上、1時間未満
   */
  public ACRadioButtonItem getHoumonKangoKaigoTime3(){
    if(houmonKangoKaigoTime3==null){

      houmonKangoKaigoTime3 = new ACRadioButtonItem();

      houmonKangoKaigoTime3.setText("30分以上、1時間未満");

      houmonKangoKaigoTime3.setGroup(getHoumonKangoKaigoTime());

      houmonKangoKaigoTime3.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoKaigoTime3();
    }
    return houmonKangoKaigoTime3;

  }

  /**
   * 1時間以上、1時間半未満を取得します。
   * @return 1時間以上、1時間半未満
   */
  public ACRadioButtonItem getHoumonKangoKaigoTime4(){
    if(houmonKangoKaigoTime4==null){

      houmonKangoKaigoTime4 = new ACRadioButtonItem();

      houmonKangoKaigoTime4.setText("1時間以上、1時間半未満");

      houmonKangoKaigoTime4.setGroup(getHoumonKangoKaigoTime());

      houmonKangoKaigoTime4.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoKaigoTime4();
    }
    return houmonKangoKaigoTime4;

  }

  /**
   * 訪問看護介護時間帯を取得します。
   * @return 訪問看護介護時間帯
   */
  public ACValueArrayRadioButtonGroup getHoumonKangoKaigoTimeZone(){
    if(houmonKangoKaigoTimeZone==null){

      houmonKangoKaigoTimeZone = new ACValueArrayRadioButtonGroup();

      getHoumonKangoKaigoTimeZoneContainer().setText("時間帯");

      houmonKangoKaigoTimeZone.setBindPath("1130106");

      houmonKangoKaigoTimeZone.setUseClearButton(false);

      houmonKangoKaigoTimeZone.setModel(getHoumonKangoKaigoTimeZoneModel());

      houmonKangoKaigoTimeZone.setValues(new int[]{1,2,3,4});

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
  public ACValueArrayRadioButtonGroup getSpecialManagementRadioGroup(){
    if(specialManagementRadioGroup==null){

      specialManagementRadioGroup = new ACValueArrayRadioButtonGroup();

      getSpecialManagementRadioGroupContainer().setText("特別管理加算");

      specialManagementRadioGroup.setBindPath("1130116");

      specialManagementRadioGroup.setUseClearButton(false);

      specialManagementRadioGroup.setModel(getSpecialManagementRadioGroupModel());

      specialManagementRadioGroup.setValues(new int[]{1,2,3});

      addSpecialManagementRadioGroup();
    }
    return specialManagementRadioGroup;

  }

  /**
   * 特別管理加算コンテナを取得します。
   * @return 特別管理加算コンテナ
   */
  protected ACLabelContainer getSpecialManagementRadioGroupContainer(){
    if(specialManagementRadioGroupContainer==null){
      specialManagementRadioGroupContainer = new ACLabelContainer();
      specialManagementRadioGroupContainer.setFollowChildEnabled(true);
      specialManagementRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      specialManagementRadioGroupContainer.add(getSpecialManagementRadioGroup(), null);
    }
    return specialManagementRadioGroupContainer;
  }

  /**
   * 特別管理加算モデルを取得します。
   * @return 特別管理加算モデル
   */
  protected ACListModelAdapter getSpecialManagementRadioGroupModel(){
    if(specialManagementRadioGroupModel==null){
      specialManagementRadioGroupModel = new ACListModelAdapter();
      addSpecialManagementRadioGroupModel();
    }
    return specialManagementRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSpecialManagementRadioItem1(){
    if(specialManagementRadioItem1==null){

      specialManagementRadioItem1 = new ACRadioButtonItem();

      specialManagementRadioItem1.setText("なし");

      specialManagementRadioItem1.setGroup(getSpecialManagementRadioGroup());

      specialManagementRadioItem1.setConstraints(VRLayout.FLOW);

      addSpecialManagementRadioItem1();
    }
    return specialManagementRadioItem1;

  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getSpecialManagementRadioItem2(){
    if(specialManagementRadioItem2==null){

      specialManagementRadioItem2 = new ACRadioButtonItem();

      specialManagementRadioItem2.setText("I型");

      specialManagementRadioItem2.setGroup(getSpecialManagementRadioGroup());

      specialManagementRadioItem2.setConstraints(VRLayout.FLOW);

      addSpecialManagementRadioItem2();
    }
    return specialManagementRadioItem2;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getSpecialManagementRadioItem3(){
    if(specialManagementRadioItem3==null){

      specialManagementRadioItem3 = new ACRadioButtonItem();

      specialManagementRadioItem3.setText("II型");

      specialManagementRadioItem3.setGroup(getSpecialManagementRadioGroup());

      specialManagementRadioItem3.setConstraints(VRLayout.FLOW);

      addSpecialManagementRadioItem3();
    }
    return specialManagementRadioItem3;

  }

  /**
   * 1日に2回を越えて実施を取得します。
   * @return 1日に2回を越えて実施
   */
  public ACIntegerCheckBox getTwoOrMoreTimesCheck(){
    if(twoOrMoreTimesCheck==null){

      twoOrMoreTimesCheck = new ACIntegerCheckBox();

      twoOrMoreTimesCheck.setText("1日に2回を越えて実施");

      twoOrMoreTimesCheck.setBindPath("1130121");

      twoOrMoreTimesCheck.setSelectValue(2);

      twoOrMoreTimesCheck.setUnSelectValue(1);

      addTwoOrMoreTimesCheck();
    }
    return twoOrMoreTimesCheck;

  }

  /**
   * 日割を取得します。
   * @return 日割
   */
  public ACIntegerCheckBox getCrackOnDayCheck(){
    if(crackOnDayCheck==null){

      crackOnDayCheck = new ACIntegerCheckBox();

      crackOnDayCheck.setText("日割");

      crackOnDayCheck.setBindPath("1130123");

      crackOnDayCheck.setSelectValue(2);

      crackOnDayCheck.setUnSelectValue(1);

      addCrackOnDayCheck();
    }
    return crackOnDayCheck;

  }

  /**
   * 提供日を取得します。
   * @return 提供日
   */
  public ACIntegerCheckBox getPrintable(){
    if(printable==null){

      printable = new ACIntegerCheckBox();

      printable.setText("提供日");

      printable.setBindPath("15");

      printable.setSelectValue(2);

      printable.setUnSelectValue(1);

      addPrintable();
    }
    return printable;

  }

  /**
   * 提供時間コンテナを取得します。
   * @return 提供時間コンテナ
   */
  public ACBackLabelContainer getHoumonKangoKaigoTimeContena(){
    if(houmonKangoKaigoTimeContena==null){

      houmonKangoKaigoTimeContena = new ACBackLabelContainer();

      houmonKangoKaigoTimeContena.setFollowChildEnabled(true);

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
   * 長時間訪問看護加算を取得します。
   * @return 長時間訪問看護加算
   */
  public ACValueArrayRadioButtonGroup getHoumonKangoKaigoLongTime(){
    if(houmonKangoKaigoLongTime==null){

      houmonKangoKaigoLongTime = new ACValueArrayRadioButtonGroup();

      getHoumonKangoKaigoLongTimeContainer().setText("長時間訪問看護加算");

      houmonKangoKaigoLongTime.setBindPath("1130114");

      houmonKangoKaigoLongTime.setUseClearButton(false);

      houmonKangoKaigoLongTime.setModel(getHoumonKangoKaigoLongTimeModel());

      houmonKangoKaigoLongTime.setValues(new int[]{1,2});

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
   * 緊急時訪問看護加算を取得します。
   * @return 緊急時訪問看護加算
   */
  public ACValueArrayRadioButtonGroup getHoumonKangoKaigoUrgentTimeRadio(){
    if(houmonKangoKaigoUrgentTimeRadio==null){

      houmonKangoKaigoUrgentTimeRadio = new ACValueArrayRadioButtonGroup();

      getHoumonKangoKaigoUrgentTimeRadioContainer().setText("緊急時訪問看護加算");

      houmonKangoKaigoUrgentTimeRadio.setBindPath("1130108");

      houmonKangoKaigoUrgentTimeRadio.setUseClearButton(false);

      houmonKangoKaigoUrgentTimeRadio.setModel(getHoumonKangoKaigoUrgentTimeRadioModel());

      houmonKangoKaigoUrgentTimeRadio.setValues(new int[]{1,2});

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
   * 緊急時訪問看護加算を取得します。
   * @return 緊急時訪問看護加算
   */
  public ACValueArrayRadioButtonGroup getHoumonKangoKaigoUrgentTime2Radio(){
    if(houmonKangoKaigoUrgentTime2Radio==null){

      houmonKangoKaigoUrgentTime2Radio = new ACValueArrayRadioButtonGroup();

      getHoumonKangoKaigoUrgentTime2RadioContainer().setText("緊急時訪問看護加算");

      houmonKangoKaigoUrgentTime2Radio.setBindPath("1130122");

      houmonKangoKaigoUrgentTime2Radio.setUseClearButton(false);

      houmonKangoKaigoUrgentTime2Radio.setModel(getHoumonKangoKaigoUrgentTime2RadioModel());

      houmonKangoKaigoUrgentTime2Radio.setValues(new int[]{1,2,3});

      addHoumonKangoKaigoUrgentTime2Radio();
    }
    return houmonKangoKaigoUrgentTime2Radio;

  }

  /**
   * 緊急時訪問看護加算コンテナを取得します。
   * @return 緊急時訪問看護加算コンテナ
   */
  protected ACLabelContainer getHoumonKangoKaigoUrgentTime2RadioContainer(){
    if(houmonKangoKaigoUrgentTime2RadioContainer==null){
      houmonKangoKaigoUrgentTime2RadioContainer = new ACLabelContainer();
      houmonKangoKaigoUrgentTime2RadioContainer.setFollowChildEnabled(true);
      houmonKangoKaigoUrgentTime2RadioContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoKaigoUrgentTime2RadioContainer.add(getHoumonKangoKaigoUrgentTime2Radio(), null);
    }
    return houmonKangoKaigoUrgentTime2RadioContainer;
  }

  /**
   * 緊急時訪問看護加算モデルを取得します。
   * @return 緊急時訪問看護加算モデル
   */
  protected ACListModelAdapter getHoumonKangoKaigoUrgentTime2RadioModel(){
    if(houmonKangoKaigoUrgentTime2RadioModel==null){
      houmonKangoKaigoUrgentTime2RadioModel = new ACListModelAdapter();
      addHoumonKangoKaigoUrgentTime2RadioModel();
    }
    return houmonKangoKaigoUrgentTime2RadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonKangoKaigoUrgentTime2RadioItem1(){
    if(houmonKangoKaigoUrgentTime2RadioItem1==null){

      houmonKangoKaigoUrgentTime2RadioItem1 = new ACRadioButtonItem();

      houmonKangoKaigoUrgentTime2RadioItem1.setText("なし");

      houmonKangoKaigoUrgentTime2RadioItem1.setGroup(getHoumonKangoKaigoUrgentTime2Radio());

      houmonKangoKaigoUrgentTime2RadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoKaigoUrgentTime2RadioItem1();
    }
    return houmonKangoKaigoUrgentTime2RadioItem1;

  }

  /**
   * 指定訪問看護ステーションを取得します。
   * @return 指定訪問看護ステーション
   */
  public ACRadioButtonItem getHoumonKangoKaigoUrgentTime2RadioItem2(){
    if(houmonKangoKaigoUrgentTime2RadioItem2==null){

      houmonKangoKaigoUrgentTime2RadioItem2 = new ACRadioButtonItem();

      houmonKangoKaigoUrgentTime2RadioItem2.setText("指定訪問看護ステーション");

      houmonKangoKaigoUrgentTime2RadioItem2.setGroup(getHoumonKangoKaigoUrgentTime2Radio());

      houmonKangoKaigoUrgentTime2RadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoKaigoUrgentTime2RadioItem2();
    }
    return houmonKangoKaigoUrgentTime2RadioItem2;

  }

  /**
   * 医療機関を取得します。
   * @return 医療機関
   */
  public ACRadioButtonItem getHoumonKangoKaigoUrgentTime2RadioItem3(){
    if(houmonKangoKaigoUrgentTime2RadioItem3==null){

      houmonKangoKaigoUrgentTime2RadioItem3 = new ACRadioButtonItem();

      houmonKangoKaigoUrgentTime2RadioItem3.setText("医療機関");

      houmonKangoKaigoUrgentTime2RadioItem3.setGroup(getHoumonKangoKaigoUrgentTime2Radio());

      houmonKangoKaigoUrgentTime2RadioItem3.setConstraints(VRLayout.FLOW);

      addHoumonKangoKaigoUrgentTime2RadioItem3();
    }
    return houmonKangoKaigoUrgentTime2RadioItem3;

  }

  /**
   * ターミナルケア加算を取得します。
   * @return ターミナルケア加算
   */
  public ACValueArrayRadioButtonGroup getHoumonKangoKaigoTerminalRadio(){
    if(houmonKangoKaigoTerminalRadio==null){

      houmonKangoKaigoTerminalRadio = new ACValueArrayRadioButtonGroup();

      getHoumonKangoKaigoTerminalRadioContainer().setText("ターミナルケア加算");

      houmonKangoKaigoTerminalRadio.setBindPath("1130110");

      houmonKangoKaigoTerminalRadio.setUseClearButton(false);

      houmonKangoKaigoTerminalRadio.setModel(getHoumonKangoKaigoTerminalRadioModel());

      houmonKangoKaigoTerminalRadio.setValues(new int[]{1,2});

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
   * 初回加算を取得します。
   * @return 初回加算
   */
  public ACValueArrayRadioButtonGroup getInitialAddRadioGroup(){
    if(initialAddRadioGroup==null){

      initialAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getInitialAddRadioGroupContainer().setText("初回加算");

      initialAddRadioGroup.setBindPath("1130117");

      initialAddRadioGroup.setNoSelectIndex(0);

      initialAddRadioGroup.setUseClearButton(false);

      initialAddRadioGroup.setModel(getInitialAddRadioGroupModel());

      initialAddRadioGroup.setValues(new int[]{1,2});

      addInitialAddRadioGroup();
    }
    return initialAddRadioGroup;

  }

  /**
   * 初回加算コンテナを取得します。
   * @return 初回加算コンテナ
   */
  protected ACLabelContainer getInitialAddRadioGroupContainer(){
    if(initialAddRadioGroupContainer==null){
      initialAddRadioGroupContainer = new ACLabelContainer();
      initialAddRadioGroupContainer.setFollowChildEnabled(true);
      initialAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      initialAddRadioGroupContainer.add(getInitialAddRadioGroup(), null);
    }
    return initialAddRadioGroupContainer;
  }

  /**
   * 初回加算モデルを取得します。
   * @return 初回加算モデル
   */
  protected ACListModelAdapter getInitialAddRadioGroupModel(){
    if(initialAddRadioGroupModel==null){
      initialAddRadioGroupModel = new ACListModelAdapter();
      addInitialAddRadioGroupModel();
    }
    return initialAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getInitialAddRadioItem1(){
    if(initialAddRadioItem1==null){

      initialAddRadioItem1 = new ACRadioButtonItem();

      initialAddRadioItem1.setText("なし");

      initialAddRadioItem1.setGroup(getInitialAddRadioGroup());

      initialAddRadioItem1.setConstraints(VRLayout.FLOW);

      addInitialAddRadioItem1();
    }
    return initialAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getInitialAddRadioItem2(){
    if(initialAddRadioItem2==null){

      initialAddRadioItem2 = new ACRadioButtonItem();

      initialAddRadioItem2.setText("あり");

      initialAddRadioItem2.setGroup(getInitialAddRadioGroup());

      initialAddRadioItem2.setConstraints(VRLayout.FLOW);

      addInitialAddRadioItem2();
    }
    return initialAddRadioItem2;

  }

  /**
   * 退院時共同指導加算を取得します。
   * @return 退院時共同指導加算
   */
  public ACValueArrayRadioButtonGroup getLeavingHospitalGuidanceAddRadioGroup(){
    if(leavingHospitalGuidanceAddRadioGroup==null){

      leavingHospitalGuidanceAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getLeavingHospitalGuidanceAddRadioGroupContainer().setText("退院時共同指導加算");

      leavingHospitalGuidanceAddRadioGroup.setBindPath("1130118");

      leavingHospitalGuidanceAddRadioGroup.setNoSelectIndex(0);

      leavingHospitalGuidanceAddRadioGroup.setUseClearButton(false);

      leavingHospitalGuidanceAddRadioGroup.setModel(getLeavingHospitalGuidanceAddRadioGroupModel());

      leavingHospitalGuidanceAddRadioGroup.setValues(new int[]{1,2});

      addLeavingHospitalGuidanceAddRadioGroup();
    }
    return leavingHospitalGuidanceAddRadioGroup;

  }

  /**
   * 退院時共同指導加算コンテナを取得します。
   * @return 退院時共同指導加算コンテナ
   */
  protected ACLabelContainer getLeavingHospitalGuidanceAddRadioGroupContainer(){
    if(leavingHospitalGuidanceAddRadioGroupContainer==null){
      leavingHospitalGuidanceAddRadioGroupContainer = new ACLabelContainer();
      leavingHospitalGuidanceAddRadioGroupContainer.setFollowChildEnabled(true);
      leavingHospitalGuidanceAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      leavingHospitalGuidanceAddRadioGroupContainer.add(getLeavingHospitalGuidanceAddRadioGroup(), null);
    }
    return leavingHospitalGuidanceAddRadioGroupContainer;
  }

  /**
   * 退院時共同指導加算モデルを取得します。
   * @return 退院時共同指導加算モデル
   */
  protected ACListModelAdapter getLeavingHospitalGuidanceAddRadioGroupModel(){
    if(leavingHospitalGuidanceAddRadioGroupModel==null){
      leavingHospitalGuidanceAddRadioGroupModel = new ACListModelAdapter();
      addLeavingHospitalGuidanceAddRadioGroupModel();
    }
    return leavingHospitalGuidanceAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getLeavingHospitalGuidanceAddRadioItem1(){
    if(leavingHospitalGuidanceAddRadioItem1==null){

      leavingHospitalGuidanceAddRadioItem1 = new ACRadioButtonItem();

      leavingHospitalGuidanceAddRadioItem1.setText("なし");

      leavingHospitalGuidanceAddRadioItem1.setGroup(getLeavingHospitalGuidanceAddRadioGroup());

      leavingHospitalGuidanceAddRadioItem1.setConstraints(VRLayout.FLOW);

      addLeavingHospitalGuidanceAddRadioItem1();
    }
    return leavingHospitalGuidanceAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getLeavingHospitalGuidanceAddRadioItem2(){
    if(leavingHospitalGuidanceAddRadioItem2==null){

      leavingHospitalGuidanceAddRadioItem2 = new ACRadioButtonItem();

      leavingHospitalGuidanceAddRadioItem2.setText("あり");

      leavingHospitalGuidanceAddRadioItem2.setGroup(getLeavingHospitalGuidanceAddRadioGroup());

      leavingHospitalGuidanceAddRadioItem2.setConstraints(VRLayout.FLOW);

      addLeavingHospitalGuidanceAddRadioItem2();
    }
    return leavingHospitalGuidanceAddRadioItem2;

  }

  /**
   * 看護・介護職員連携強化加算を取得します。
   * @return 看護・介護職員連携強化加算
   */
  public ACValueArrayRadioButtonGroup getCooperationMedicalCareAddRadioGroup(){
    if(cooperationMedicalCareAddRadioGroup==null){

      cooperationMedicalCareAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getCooperationMedicalCareAddRadioGroupContainer().setText("看護・介護職員連携強化加算");

      cooperationMedicalCareAddRadioGroup.setBindPath("1130119");

      cooperationMedicalCareAddRadioGroup.setNoSelectIndex(0);

      cooperationMedicalCareAddRadioGroup.setUseClearButton(false);

      cooperationMedicalCareAddRadioGroup.setModel(getCooperationMedicalCareAddRadioGroupModel());

      cooperationMedicalCareAddRadioGroup.setValues(new int[]{1,2});

      addCooperationMedicalCareAddRadioGroup();
    }
    return cooperationMedicalCareAddRadioGroup;

  }

  /**
   * 看護・介護職員連携強化加算コンテナを取得します。
   * @return 看護・介護職員連携強化加算コンテナ
   */
  protected ACLabelContainer getCooperationMedicalCareAddRadioGroupContainer(){
    if(cooperationMedicalCareAddRadioGroupContainer==null){
      cooperationMedicalCareAddRadioGroupContainer = new ACLabelContainer();
      cooperationMedicalCareAddRadioGroupContainer.setFollowChildEnabled(true);
      cooperationMedicalCareAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      cooperationMedicalCareAddRadioGroupContainer.add(getCooperationMedicalCareAddRadioGroup(), null);
    }
    return cooperationMedicalCareAddRadioGroupContainer;
  }

  /**
   * 看護・介護職員連携強化加算モデルを取得します。
   * @return 看護・介護職員連携強化加算モデル
   */
  protected ACListModelAdapter getCooperationMedicalCareAddRadioGroupModel(){
    if(cooperationMedicalCareAddRadioGroupModel==null){
      cooperationMedicalCareAddRadioGroupModel = new ACListModelAdapter();
      addCooperationMedicalCareAddRadioGroupModel();
    }
    return cooperationMedicalCareAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getCooperationMedicalCareAddRadioItem1(){
    if(cooperationMedicalCareAddRadioItem1==null){

      cooperationMedicalCareAddRadioItem1 = new ACRadioButtonItem();

      cooperationMedicalCareAddRadioItem1.setText("なし");

      cooperationMedicalCareAddRadioItem1.setGroup(getCooperationMedicalCareAddRadioGroup());

      cooperationMedicalCareAddRadioItem1.setConstraints(VRLayout.FLOW);

      addCooperationMedicalCareAddRadioItem1();
    }
    return cooperationMedicalCareAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getCooperationMedicalCareAddRadioItem2(){
    if(cooperationMedicalCareAddRadioItem2==null){

      cooperationMedicalCareAddRadioItem2 = new ACRadioButtonItem();

      cooperationMedicalCareAddRadioItem2.setText("あり");

      cooperationMedicalCareAddRadioItem2.setGroup(getCooperationMedicalCareAddRadioGroup());

      cooperationMedicalCareAddRadioItem2.setConstraints(VRLayout.FLOW);

      addCooperationMedicalCareAddRadioItem2();
    }
    return cooperationMedicalCareAddRadioItem2;

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
   * 2人目の訪問時間を取得します。
   * @return 2人目の訪問時間
   */
  public ACValueArrayRadioButtonGroup getHoumonKangoNumberOfPeopleTime(){
    if(houmonKangoNumberOfPeopleTime==null){

      houmonKangoNumberOfPeopleTime = new ACValueArrayRadioButtonGroup();

      getHoumonKangoNumberOfPeopleTimeContainer().setText("2人目の訪問時間");

      houmonKangoNumberOfPeopleTime.setBindPath("1130115");

      houmonKangoNumberOfPeopleTime.setNoSelectIndex(0);

      houmonKangoNumberOfPeopleTime.setUseClearButton(false);

      houmonKangoNumberOfPeopleTime.setModel(getHoumonKangoNumberOfPeopleTimeModel());

      houmonKangoNumberOfPeopleTime.setValues(new int[]{1,2});

      addHoumonKangoNumberOfPeopleTime();
    }
    return houmonKangoNumberOfPeopleTime;

  }

  /**
   * 2人目の訪問時間コンテナを取得します。
   * @return 2人目の訪問時間コンテナ
   */
  protected ACLabelContainer getHoumonKangoNumberOfPeopleTimeContainer(){
    if(houmonKangoNumberOfPeopleTimeContainer==null){
      houmonKangoNumberOfPeopleTimeContainer = new ACLabelContainer();
      houmonKangoNumberOfPeopleTimeContainer.setFollowChildEnabled(true);
      houmonKangoNumberOfPeopleTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoNumberOfPeopleTimeContainer.add(getHoumonKangoNumberOfPeopleTime(), null);
    }
    return houmonKangoNumberOfPeopleTimeContainer;
  }

  /**
   * 2人目の訪問時間モデルを取得します。
   * @return 2人目の訪問時間モデル
   */
  protected ACListModelAdapter getHoumonKangoNumberOfPeopleTimeModel(){
    if(houmonKangoNumberOfPeopleTimeModel==null){
      houmonKangoNumberOfPeopleTimeModel = new ACListModelAdapter();
      addHoumonKangoNumberOfPeopleTimeModel();
    }
    return houmonKangoNumberOfPeopleTimeModel;
  }

  /**
   * 30分未満を取得します。
   * @return 30分未満
   */
  public ACRadioButtonItem getHoumonKangoNumberOfPeopleTimeItem1(){
    if(houmonKangoNumberOfPeopleTimeItem1==null){

      houmonKangoNumberOfPeopleTimeItem1 = new ACRadioButtonItem();

      houmonKangoNumberOfPeopleTimeItem1.setText("30分未満");

      houmonKangoNumberOfPeopleTimeItem1.setGroup(getHoumonKangoNumberOfPeopleTime());

      houmonKangoNumberOfPeopleTimeItem1.setConstraints(VRLayout.FLOW);

      addHoumonKangoNumberOfPeopleTimeItem1();
    }
    return houmonKangoNumberOfPeopleTimeItem1;

  }

  /**
   * 30分以上を取得します。
   * @return 30分以上
   */
  public ACRadioButtonItem getHoumonKangoNumberOfPeopleTimeItem2(){
    if(houmonKangoNumberOfPeopleTimeItem2==null){

      houmonKangoNumberOfPeopleTimeItem2 = new ACRadioButtonItem();

      houmonKangoNumberOfPeopleTimeItem2.setText("30分以上");

      houmonKangoNumberOfPeopleTimeItem2.setGroup(getHoumonKangoNumberOfPeopleTime());

      houmonKangoNumberOfPeopleTimeItem2.setConstraints(VRLayout.FLOW);

      addHoumonKangoNumberOfPeopleTimeItem2();
    }
    return houmonKangoNumberOfPeopleTimeItem2;

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
   * タブ３を取得します。
   * @return タブ３
   */
  public ACPanel getTab3(){
    if(tab3==null){

      tab3 = new ACPanel();

      tab3.setFollowChildEnabled(true);

      addTab3();
    }
    return tab3;

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
   * 訪問看護指示期間の日数減算を取得します。
   * @return 訪問看護指示期間の日数減算
   */
  public ACValueArrayRadioButtonGroup getHoumonNissuReduceRadio(){
    if(houmonNissuReduceRadio==null){

      houmonNissuReduceRadio = new ACValueArrayRadioButtonGroup();

      getHoumonNissuReduceRadioContainer().setText("訪問看護指示期間の日数減算");

      houmonNissuReduceRadio.setBindPath("1130120");

      houmonNissuReduceRadio.setNoSelectIndex(0);

      houmonNissuReduceRadio.setUseClearButton(false);

      houmonNissuReduceRadio.setModel(getHoumonNissuReduceRadioModel());

      houmonNissuReduceRadio.setValues(new int[]{1,2});

      addHoumonNissuReduceRadio();
    }
    return houmonNissuReduceRadio;

  }

  /**
   * 訪問看護指示期間の日数減算コンテナを取得します。
   * @return 訪問看護指示期間の日数減算コンテナ
   */
  protected ACLabelContainer getHoumonNissuReduceRadioContainer(){
    if(houmonNissuReduceRadioContainer==null){
      houmonNissuReduceRadioContainer = new ACLabelContainer();
      houmonNissuReduceRadioContainer.setFollowChildEnabled(true);
      houmonNissuReduceRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonNissuReduceRadioContainer.add(getHoumonNissuReduceRadio(), null);
    }
    return houmonNissuReduceRadioContainer;
  }

  /**
   * 訪問看護指示期間の日数減算モデルを取得します。
   * @return 訪問看護指示期間の日数減算モデル
   */
  protected ACListModelAdapter getHoumonNissuReduceRadioModel(){
    if(houmonNissuReduceRadioModel==null){
      houmonNissuReduceRadioModel = new ACListModelAdapter();
      addHoumonNissuReduceRadioModel();
    }
    return houmonNissuReduceRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonNissuReduceRadioItem1(){
    if(houmonNissuReduceRadioItem1==null){

      houmonNissuReduceRadioItem1 = new ACRadioButtonItem();

      houmonNissuReduceRadioItem1.setText("なし");

      houmonNissuReduceRadioItem1.setGroup(getHoumonNissuReduceRadio());

      houmonNissuReduceRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonNissuReduceRadioItem1();
    }
    return houmonNissuReduceRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonNissuReduceRadioItem2(){
    if(houmonNissuReduceRadioItem2==null){

      houmonNissuReduceRadioItem2 = new ACRadioButtonItem();

      houmonNissuReduceRadioItem2.setText("あり");

      houmonNissuReduceRadioItem2.setGroup(getHoumonNissuReduceRadio());

      houmonNissuReduceRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonNissuReduceRadioItem2();
    }
    return houmonNissuReduceRadioItem2;

  }

  /**
   * 算定区分を取得します。
   * @return 算定区分
   */
  public ACValueArrayRadioButtonGroup getCalculationDivision(){
    if(calculationDivision==null){

      calculationDivision = new ACValueArrayRadioButtonGroup();

      getCalculationDivisionContainer().setText("算定区分");

      calculationDivision.setBindPath("9");

      calculationDivision.setUseClearButton(false);

      calculationDivision.setModel(getCalculationDivisionModel());

      calculationDivision.setValues(new int[]{1,2});

      addCalculationDivision();
    }
    return calculationDivision;

  }

  /**
   * 算定区分コンテナを取得します。
   * @return 算定区分コンテナ
   */
  protected ACLabelContainer getCalculationDivisionContainer(){
    if(calculationDivisionContainer==null){
      calculationDivisionContainer = new ACLabelContainer();
      calculationDivisionContainer.setFollowChildEnabled(true);
      calculationDivisionContainer.setVAlignment(VRLayout.CENTER);
      calculationDivisionContainer.add(getCalculationDivision(), null);
    }
    return calculationDivisionContainer;
  }

  /**
   * 算定区分モデルを取得します。
   * @return 算定区分モデル
   */
  protected ACListModelAdapter getCalculationDivisionModel(){
    if(calculationDivisionModel==null){
      calculationDivisionModel = new ACListModelAdapter();
      addCalculationDivisionModel();
    }
    return calculationDivisionModel;
  }

  /**
   * 通常を取得します。
   * @return 通常
   */
  public ACRadioButtonItem getCalculationDivisionNormal(){
    if(calculationDivisionNormal==null){

      calculationDivisionNormal = new ACRadioButtonItem();

      calculationDivisionNormal.setText("通常");

      calculationDivisionNormal.setGroup(getCalculationDivision());

      calculationDivisionNormal.setConstraints(VRLayout.FLOW);

      addCalculationDivisionNormal();
    }
    return calculationDivisionNormal;

  }

  /**
   * 加算のみを取得します。
   * @return 加算のみ
   */
  public ACRadioButtonItem getCalculationDivisionAddOnly(){
    if(calculationDivisionAddOnly==null){

      calculationDivisionAddOnly = new ACRadioButtonItem();

      calculationDivisionAddOnly.setText("加算のみ");

      calculationDivisionAddOnly.setGroup(getCalculationDivision());

      calculationDivisionAddOnly.setConstraints(VRLayout.FLOW);

      addCalculationDivisionAddOnly();
    }
    return calculationDivisionAddOnly;

  }

  /**
   * コンストラクタです。
   */
  public QS001_11311_201204Design() {

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

    tabs.addTab("3", getTab3());

  }

  /**
   * タブ1に内部項目を追加します。
   */
  protected void addTab1(){

    tab1.add(getHoumonKangoKaigoFacilityTypeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoKaigoClassContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoKaigoTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoKaigoTimeZoneContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getSpecialManagementRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTwoOrMoreTimesCheck(), VRLayout.FLOW);

    tab1.add(getCrackOnDayCheck(), VRLayout.FLOW_INSETLINE);

    tab1.add(getPrintable(), VRLayout.FLOW_RETURN);

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

    getHoumonKangoKaigoFacilityTypeItem3().setButtonIndex(3);

    getHoumonKangoKaigoFacilityTypeModel().add(getHoumonKangoKaigoFacilityTypeItem3());

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
   * 定期巡回・随時対応サービスに内部項目を追加します。
   */
  protected void addHoumonKangoKaigoFacilityTypeItem3(){

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

    getHoumonKangoKaigoTime1().setButtonIndex(1);

    getHoumonKangoKaigoTimeModel().add(getHoumonKangoKaigoTime1());

    getHoumonKangoKaigoTime2().setButtonIndex(2);

    getHoumonKangoKaigoTimeModel().add(getHoumonKangoKaigoTime2());

    getHoumonKangoKaigoTime3().setButtonIndex(3);

    getHoumonKangoKaigoTimeModel().add(getHoumonKangoKaigoTime3());

    getHoumonKangoKaigoTime4().setButtonIndex(4);

    getHoumonKangoKaigoTimeModel().add(getHoumonKangoKaigoTime4());

  }

  /**
   * 20分未満に内部項目を追加します。
   */
  protected void addHoumonKangoKaigoTime1(){

  }

  /**
   * 30分未満に内部項目を追加します。
   */
  protected void addHoumonKangoKaigoTime2(){

  }

  /**
   * 30分以上、1時間未満に内部項目を追加します。
   */
  protected void addHoumonKangoKaigoTime3(){

  }

  /**
   * 1時間以上、1時間半未満に内部項目を追加します。
   */
  protected void addHoumonKangoKaigoTime4(){

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
  protected void addSpecialManagementRadioGroup(){

  }

  /**
   * 特別管理加算モデルに内部項目を追加します。
   */
  protected void addSpecialManagementRadioGroupModel(){

    getSpecialManagementRadioItem1().setButtonIndex(1);

    getSpecialManagementRadioGroupModel().add(getSpecialManagementRadioItem1());

    getSpecialManagementRadioItem2().setButtonIndex(2);

    getSpecialManagementRadioGroupModel().add(getSpecialManagementRadioItem2());

    getSpecialManagementRadioItem3().setButtonIndex(3);

    getSpecialManagementRadioGroupModel().add(getSpecialManagementRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSpecialManagementRadioItem1(){

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addSpecialManagementRadioItem2(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addSpecialManagementRadioItem3(){

  }

  /**
   * 1日に2回を越えて実施に内部項目を追加します。
   */
  protected void addTwoOrMoreTimesCheck(){

  }

  /**
   * 日割に内部項目を追加します。
   */
  protected void addCrackOnDayCheck(){

  }

  /**
   * 提供日に内部項目を追加します。
   */
  protected void addPrintable(){

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

    tab2.add(getHoumonKangoKaigoLongTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonKangoKaigoUrgentTimeRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonKangoKaigoUrgentTime2RadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonKangoKaigoTerminalRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getInitialAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getLeavingHospitalGuidanceAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getCooperationMedicalCareAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonKangoNumberOfPeopleContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonKangoNumberOfPeopleTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getProviderAddMountainousAreaRafioRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * 緊急時訪問看護加算に内部項目を追加します。
   */
  protected void addHoumonKangoKaigoUrgentTime2Radio(){

  }

  /**
   * 緊急時訪問看護加算モデルに内部項目を追加します。
   */
  protected void addHoumonKangoKaigoUrgentTime2RadioModel(){

    getHoumonKangoKaigoUrgentTime2RadioItem1().setButtonIndex(1);

    getHoumonKangoKaigoUrgentTime2RadioModel().add(getHoumonKangoKaigoUrgentTime2RadioItem1());

    getHoumonKangoKaigoUrgentTime2RadioItem2().setButtonIndex(2);

    getHoumonKangoKaigoUrgentTime2RadioModel().add(getHoumonKangoKaigoUrgentTime2RadioItem2());

    getHoumonKangoKaigoUrgentTime2RadioItem3().setButtonIndex(3);

    getHoumonKangoKaigoUrgentTime2RadioModel().add(getHoumonKangoKaigoUrgentTime2RadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonKangoKaigoUrgentTime2RadioItem1(){

  }

  /**
   * 指定訪問看護ステーションに内部項目を追加します。
   */
  protected void addHoumonKangoKaigoUrgentTime2RadioItem2(){

  }

  /**
   * 医療機関に内部項目を追加します。
   */
  protected void addHoumonKangoKaigoUrgentTime2RadioItem3(){

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
   * 初回加算に内部項目を追加します。
   */
  protected void addInitialAddRadioGroup(){

  }

  /**
   * 初回加算モデルに内部項目を追加します。
   */
  protected void addInitialAddRadioGroupModel(){

    getInitialAddRadioItem1().setButtonIndex(1);

    getInitialAddRadioGroupModel().add(getInitialAddRadioItem1());

    getInitialAddRadioItem2().setButtonIndex(2);

    getInitialAddRadioGroupModel().add(getInitialAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addInitialAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addInitialAddRadioItem2(){

  }

  /**
   * 退院時共同指導加算に内部項目を追加します。
   */
  protected void addLeavingHospitalGuidanceAddRadioGroup(){

  }

  /**
   * 退院時共同指導加算モデルに内部項目を追加します。
   */
  protected void addLeavingHospitalGuidanceAddRadioGroupModel(){

    getLeavingHospitalGuidanceAddRadioItem1().setButtonIndex(1);

    getLeavingHospitalGuidanceAddRadioGroupModel().add(getLeavingHospitalGuidanceAddRadioItem1());

    getLeavingHospitalGuidanceAddRadioItem2().setButtonIndex(2);

    getLeavingHospitalGuidanceAddRadioGroupModel().add(getLeavingHospitalGuidanceAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addLeavingHospitalGuidanceAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addLeavingHospitalGuidanceAddRadioItem2(){

  }

  /**
   * 看護・介護職員連携強化加算に内部項目を追加します。
   */
  protected void addCooperationMedicalCareAddRadioGroup(){

  }

  /**
   * 看護・介護職員連携強化加算モデルに内部項目を追加します。
   */
  protected void addCooperationMedicalCareAddRadioGroupModel(){

    getCooperationMedicalCareAddRadioItem1().setButtonIndex(1);

    getCooperationMedicalCareAddRadioGroupModel().add(getCooperationMedicalCareAddRadioItem1());

    getCooperationMedicalCareAddRadioItem2().setButtonIndex(2);

    getCooperationMedicalCareAddRadioGroupModel().add(getCooperationMedicalCareAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addCooperationMedicalCareAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addCooperationMedicalCareAddRadioItem2(){

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
   * 2人目の訪問時間に内部項目を追加します。
   */
  protected void addHoumonKangoNumberOfPeopleTime(){

  }

  /**
   * 2人目の訪問時間モデルに内部項目を追加します。
   */
  protected void addHoumonKangoNumberOfPeopleTimeModel(){

    getHoumonKangoNumberOfPeopleTimeItem1().setButtonIndex(1);

    getHoumonKangoNumberOfPeopleTimeModel().add(getHoumonKangoNumberOfPeopleTimeItem1());

    getHoumonKangoNumberOfPeopleTimeItem2().setButtonIndex(2);

    getHoumonKangoNumberOfPeopleTimeModel().add(getHoumonKangoNumberOfPeopleTimeItem2());

  }

  /**
   * 30分未満に内部項目を追加します。
   */
  protected void addHoumonKangoNumberOfPeopleTimeItem1(){

  }

  /**
   * 30分以上に内部項目を追加します。
   */
  protected void addHoumonKangoNumberOfPeopleTimeItem2(){

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
   * タブ３に内部項目を追加します。
   */
  protected void addTab3(){

    tab3.add(getHoumonNeededRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getHoumonNissuReduceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getCalculationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * 訪問看護指示期間の日数減算に内部項目を追加します。
   */
  protected void addHoumonNissuReduceRadio(){

  }

  /**
   * 訪問看護指示期間の日数減算モデルに内部項目を追加します。
   */
  protected void addHoumonNissuReduceRadioModel(){

    getHoumonNissuReduceRadioItem1().setButtonIndex(1);

    getHoumonNissuReduceRadioModel().add(getHoumonNissuReduceRadioItem1());

    getHoumonNissuReduceRadioItem2().setButtonIndex(2);

    getHoumonNissuReduceRadioModel().add(getHoumonNissuReduceRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonNissuReduceRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonNissuReduceRadioItem2(){

  }

  /**
   * 算定区分に内部項目を追加します。
   */
  protected void addCalculationDivision(){

  }

  /**
   * 算定区分モデルに内部項目を追加します。
   */
  protected void addCalculationDivisionModel(){

    getCalculationDivisionNormal().setButtonIndex(1);

    getCalculationDivisionModel().add(getCalculationDivisionNormal());

    getCalculationDivisionAddOnly().setButtonIndex(2);

    getCalculationDivisionModel().add(getCalculationDivisionAddOnly());

  }

  /**
   * 通常に内部項目を追加します。
   */
  protected void addCalculationDivisionNormal(){

  }

  /**
   * 加算のみに内部項目を追加します。
   */
  protected void addCalculationDivisionAddOnly(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_11311_201204Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_11311_201204Design getThis() {
    return this;
  }
}
