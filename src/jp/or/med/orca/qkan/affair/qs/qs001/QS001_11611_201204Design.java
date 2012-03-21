
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
 * 作成日: 2012/03/09  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス 利用者一覧（サービス予定作成/変更） (001)
 * プログラム サービスパターン通所リハ (QS001_11611_201204)
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
 * サービスパターン通所リハ画面項目デザイン(QS001_11611_201204) 
 */
public class QS001_11611_201204Design extends QS001ServicePanel {
  //GUIコンポーネント

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup facilityDivisionRadioGroup;

  private ACLabelContainer facilityDivisionRadioGroupContainer;

  private ACListModelAdapter facilityDivisionRadioGroupModel;

  private ACRadioButtonItem facilityDivisionRadioItem1;

  private ACRadioButtonItem facilityDivisionRadioItem2;

  private ACRadioButtonItem facilityDivisionRadioItem3;

  private ACRadioButtonItem facilityDivisionRadioItem4;

  private ACRadioButtonItem facilityDivisionRadioItem5;

  private ACRadioButtonItem facilityDivisionRadioItem6;

  private ACComboBox houmonRehabilitationTimeDivision;

  private ACLabelContainer houmonRehabilitationTimeDivisionContainer;

  private ACComboBoxModelAdapter houmonRehabilitationTimeDivisionModel;

  private ACValueArrayRadioButtonGroup houmonRehabilitationBathRadio;

  private ACLabelContainer houmonRehabilitationBathRadioContainer;

  private ACListModelAdapter houmonRehabilitationBathRadioModel;

  private ACRadioButtonItem houmonRehabilitationBathRadioItem1;

  private ACRadioButtonItem houmonRehabilitationBathRadioItem2;

  private ACValueArrayRadioButtonGroup houmonRehabilitationAdditionTreatmentPersonRadio;

  private ACLabelContainer houmonRehabilitationAdditionTreatmentPersonRadioContainer;

  private ACListModelAdapter houmonRehabilitationAdditionTreatmentPersonRadioModel;

  private ACRadioButtonItem houmonRehabilitationAdditionTreatmentPersonRadioItem1;

  private ACRadioButtonItem houmonRehabilitationAdditionTreatmentPersonRadioItem2;

  private ACValueArrayRadioButtonGroup houmonRehabilitationManagementAddRadio;

  private ACLabelContainer houmonRehabilitationManagementAddRadioContainer;

  private ACListModelAdapter houmonRehabilitationManagementAddRadioModel;

  private ACRadioButtonItem houmonRehabilitationManagementAddRadioItem1;

  private ACRadioButtonItem houmonRehabilitationManagementAddRadioItem2;

  private ACBackLabelContainer houmonRehabilitationTimeContena;

  private ACTimeComboBox houmonRehabilitationTimeContenaBeginTime;

  private ACLabelContainer houmonRehabilitationTimeContenaBeginTimeContainer;

  private ACComboBoxModelAdapter houmonRehabilitationTimeContenaBeginTimeModel;

  private ACTimeComboBox houmonRehabilitationTimeContenaEndTime;

  private ACLabelContainer houmonRehabilitationTimeContenaEndTimeContainer;

  private ACComboBoxModelAdapter houmonRehabilitationTimeContenaEndTimeModel;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup houmonRehabilitationShortConcentrationAddRadio;

  private ACLabelContainer houmonRehabilitationShortConcentrationAddRadioContainer;

  private ACListModelAdapter houmonRehabilitationShortConcentrationAddRadioModel;

  private ACRadioButtonItem houmonRehabilitationShortConcentrationAddRadioItem1;

  private ACRadioButtonItem houmonRehabilitationShortConcentrationAddRadioItem2;

  private ACRadioButtonItem houmonRehabilitationShortConcentrationAddRadioItem3;

  private ACValueArrayRadioButtonGroup openStockRehabilitationConcentrationAddRadio;

  private ACLabelContainer openStockRehabilitationConcentrationAddRadioContainer;

  private ACListModelAdapter openStockRehabilitationConcentrationAddRadioModel;

  private ACRadioButtonItem openStockRehabilitationConcentrationAddRadioItem1;

  private ACRadioButtonItem openStockRehabilitationConcentrationAddRadioItem2;

  private ACValueArrayRadioButtonGroup physiotherapistStrengthenedAddRadioGroup;

  private ACLabelContainer physiotherapistStrengthenedAddRadioGroupContainer;

  private ACListModelAdapter physiotherapistStrengthenedAddRadioGroupModel;

  private ACRadioButtonItem physiotherapistStrengthenedAddRadioItem1;

  private ACRadioButtonItem physiotherapistStrengthenedAddRadioItem2;

  private ACValueArrayRadioButtonGroup dementiaRehabilitationShortConcentrationAddRadio;

  private ACLabelContainer dementiaRehabilitationShortConcentrationAddRadioContainer;

  private ACListModelAdapter dementiaRehabilitationShortConcentrationAddRadioModel;

  private ACRadioButtonItem dementiaRehabilitationShortConcentrationAddRadioItem1;

  private ACRadioButtonItem dementiaRehabilitationShortConcentrationAddRadioItem2;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACValueArrayRadioButtonGroup houmonRehabilitationNourishmentManagementAddRadio;

  private ACLabelContainer houmonRehabilitationNourishmentManagementAddRadioContainer;

  private ACListModelAdapter houmonRehabilitationNourishmentManagementAddRadioModel;

  private ACRadioButtonItem houmonRehabilitationNourishmentManagementAddRadioItem1;

  private ACRadioButtonItem houmonRehabilitationNourishmentManagementAddRadioItem2;

  private ACValueArrayRadioButtonGroup houmonRehabilitationMouthFunctionAddRadio;

  private ACLabelContainer houmonRehabilitationMouthFunctionAddRadioContainer;

  private ACListModelAdapter houmonRehabilitationMouthFunctionAddRadioModel;

  private ACRadioButtonItem houmonRehabilitationMouthFunctionAddRadioItem1;

  private ACRadioButtonItem houmonRehabilitationMouthFunctionAddRadioItem2;

  private ACValueArrayRadioButtonGroup medicalManagementRadioGroup;

  private ACLabelContainer medicalManagementRadioGroupContainer;

  private ACListModelAdapter medicalManagementRadioGroupModel;

  private ACRadioButtonItem medicalManagementRadioItem1;

  private ACRadioButtonItem medicalManagementRadioItem2;

  private ACValueArrayRadioButtonGroup transportationCallRadioGroup;

  private ACLabelContainer transportationCallRadioGroupContainer;

  private ACListModelAdapter transportationCallRadioGroupModel;

  private ACRadioButtonItem transportationCallRadioItem1;

  private ACRadioButtonItem transportationCallRadioItem2;

  private ACPanel tab3;

  private ACValueArrayRadioButtonGroup houmonRehabilitationSubtraction;

  private ACLabelContainer houmonRehabilitationSubtractionContainer;

  private ACListModelAdapter houmonRehabilitationSubtractionModel;

  private ACRadioButtonItem houmonRehabilitationSubtractionNot;

  private ACRadioButtonItem houmonRehabilitationSubtractionExcess;

  private ACRadioButtonItem houmonRehabilitationSubtractionLack;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaRadioItem1;

  private ACRadioButtonItem providerAddMountainousAreaRadioItem2;

  private ACValueArrayRadioButtonGroup calculationDivision;

  private ACLabelContainer calculationDivisionContainer;

  private ACListModelAdapter calculationDivisionModel;

  private ACRadioButtonItem calculationDivisionNormal;

  private ACRadioButtonItem calculationDivisionAddOnly;

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
  public ACValueArrayRadioButtonGroup getFacilityDivisionRadioGroup(){
    if(facilityDivisionRadioGroup==null){

      facilityDivisionRadioGroup = new ACValueArrayRadioButtonGroup();

      getFacilityDivisionRadioGroupContainer().setText("施設等の区分");

      facilityDivisionRadioGroup.setBindPath("1160116");

      facilityDivisionRadioGroup.setNoSelectIndex(0);

      facilityDivisionRadioGroup.setUseClearButton(false);

      facilityDivisionRadioGroup.setModel(getFacilityDivisionRadioGroupModel());

      facilityDivisionRadioGroup.setValues(new int[]{1,2,3,4,5,6});

      addFacilityDivisionRadioGroup();
    }
    return facilityDivisionRadioGroup;

  }

  /**
   * 施設等の区分コンテナを取得します。
   * @return 施設等の区分コンテナ
   */
  protected ACLabelContainer getFacilityDivisionRadioGroupContainer(){
    if(facilityDivisionRadioGroupContainer==null){
      facilityDivisionRadioGroupContainer = new ACLabelContainer();
      facilityDivisionRadioGroupContainer.setFollowChildEnabled(true);
      facilityDivisionRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      facilityDivisionRadioGroupContainer.add(getFacilityDivisionRadioGroup(), null);
    }
    return facilityDivisionRadioGroupContainer;
  }

  /**
   * 施設等の区分モデルを取得します。
   * @return 施設等の区分モデル
   */
  protected ACListModelAdapter getFacilityDivisionRadioGroupModel(){
    if(facilityDivisionRadioGroupModel==null){
      facilityDivisionRadioGroupModel = new ACListModelAdapter();
      addFacilityDivisionRadioGroupModel();
    }
    return facilityDivisionRadioGroupModel;
  }

  /**
   * 通常規模（病院・診療所）を取得します。
   * @return 通常規模（病院・診療所）
   */
  public ACRadioButtonItem getFacilityDivisionRadioItem1(){
    if(facilityDivisionRadioItem1==null){

      facilityDivisionRadioItem1 = new ACRadioButtonItem();

      facilityDivisionRadioItem1.setText("通常規模（病院・診療所）");

      facilityDivisionRadioItem1.setGroup(getFacilityDivisionRadioGroup());

      facilityDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addFacilityDivisionRadioItem1();
    }
    return facilityDivisionRadioItem1;

  }

  /**
   * 通常規模（老健施設）を取得します。
   * @return 通常規模（老健施設）
   */
  public ACRadioButtonItem getFacilityDivisionRadioItem2(){
    if(facilityDivisionRadioItem2==null){

      facilityDivisionRadioItem2 = new ACRadioButtonItem();

      facilityDivisionRadioItem2.setText("通常規模（老健施設）");

      facilityDivisionRadioItem2.setGroup(getFacilityDivisionRadioGroup());

      facilityDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addFacilityDivisionRadioItem2();
    }
    return facilityDivisionRadioItem2;

  }

  /**
   * 大規模（I）（病院・診療所）を取得します。
   * @return 大規模（I）（病院・診療所）
   */
  public ACRadioButtonItem getFacilityDivisionRadioItem3(){
    if(facilityDivisionRadioItem3==null){

      facilityDivisionRadioItem3 = new ACRadioButtonItem();

      facilityDivisionRadioItem3.setText("大規模（I）（病院・診療所）");

      facilityDivisionRadioItem3.setGroup(getFacilityDivisionRadioGroup());

      facilityDivisionRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addFacilityDivisionRadioItem3();
    }
    return facilityDivisionRadioItem3;

  }

  /**
   * 大規模（I）（老健施設）を取得します。
   * @return 大規模（I）（老健施設）
   */
  public ACRadioButtonItem getFacilityDivisionRadioItem4(){
    if(facilityDivisionRadioItem4==null){

      facilityDivisionRadioItem4 = new ACRadioButtonItem();

      facilityDivisionRadioItem4.setText("大規模（I）（老健施設）");

      facilityDivisionRadioItem4.setGroup(getFacilityDivisionRadioGroup());

      facilityDivisionRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addFacilityDivisionRadioItem4();
    }
    return facilityDivisionRadioItem4;

  }

  /**
   * 大規模（II）（病院・診療所）を取得します。
   * @return 大規模（II）（病院・診療所）
   */
  public ACRadioButtonItem getFacilityDivisionRadioItem5(){
    if(facilityDivisionRadioItem5==null){

      facilityDivisionRadioItem5 = new ACRadioButtonItem();

      facilityDivisionRadioItem5.setText("大規模（II）（病院・診療所）");

      facilityDivisionRadioItem5.setGroup(getFacilityDivisionRadioGroup());

      facilityDivisionRadioItem5.setConstraints(VRLayout.FLOW_RETURN);

      addFacilityDivisionRadioItem5();
    }
    return facilityDivisionRadioItem5;

  }

  /**
   * 大規模（II）（老健施設）を取得します。
   * @return 大規模（II）（老健施設）
   */
  public ACRadioButtonItem getFacilityDivisionRadioItem6(){
    if(facilityDivisionRadioItem6==null){

      facilityDivisionRadioItem6 = new ACRadioButtonItem();

      facilityDivisionRadioItem6.setText("大規模（II）（老健施設）");

      facilityDivisionRadioItem6.setGroup(getFacilityDivisionRadioGroup());

      facilityDivisionRadioItem6.setConstraints(VRLayout.FLOW_RETURN);

      addFacilityDivisionRadioItem6();
    }
    return facilityDivisionRadioItem6;

  }

  /**
   * 時間区分を取得します。
   * @return 時間区分
   */
  public ACComboBox getHoumonRehabilitationTimeDivision(){
    if(houmonRehabilitationTimeDivision==null){

      houmonRehabilitationTimeDivision = new ACComboBox();

      getHoumonRehabilitationTimeDivisionContainer().setText("時間区分");

      houmonRehabilitationTimeDivision.setBindPath("1160104");

      houmonRehabilitationTimeDivision.setEditable(false);

      houmonRehabilitationTimeDivision.setModelBindPath("1160104");

      houmonRehabilitationTimeDivision.setRenderBindPath("CONTENT");

      houmonRehabilitationTimeDivision.setModel(getHoumonRehabilitationTimeDivisionModel());

      addHoumonRehabilitationTimeDivision();
    }
    return houmonRehabilitationTimeDivision;

  }

  /**
   * 時間区分コンテナを取得します。
   * @return 時間区分コンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationTimeDivisionContainer(){
    if(houmonRehabilitationTimeDivisionContainer==null){
      houmonRehabilitationTimeDivisionContainer = new ACLabelContainer();
      houmonRehabilitationTimeDivisionContainer.setFollowChildEnabled(true);
      houmonRehabilitationTimeDivisionContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationTimeDivisionContainer.add(getHoumonRehabilitationTimeDivision(), null);
    }
    return houmonRehabilitationTimeDivisionContainer;
  }

  /**
   * 時間区分モデルを取得します。
   * @return 時間区分モデル
   */
  protected ACComboBoxModelAdapter getHoumonRehabilitationTimeDivisionModel(){
    if(houmonRehabilitationTimeDivisionModel==null){
      houmonRehabilitationTimeDivisionModel = new ACComboBoxModelAdapter();
      addHoumonRehabilitationTimeDivisionModel();
    }
    return houmonRehabilitationTimeDivisionModel;
  }

  /**
   * 入浴加算を取得します。
   * @return 入浴加算
   */
  public ACValueArrayRadioButtonGroup getHoumonRehabilitationBathRadio(){
    if(houmonRehabilitationBathRadio==null){

      houmonRehabilitationBathRadio = new ACValueArrayRadioButtonGroup();

      getHoumonRehabilitationBathRadioContainer().setText("入浴加算");

      houmonRehabilitationBathRadio.setBindPath("1160105");

      houmonRehabilitationBathRadio.setUseClearButton(false);

      houmonRehabilitationBathRadio.setModel(getHoumonRehabilitationBathRadioModel());

      houmonRehabilitationBathRadio.setValues(new int[]{1,2});

      addHoumonRehabilitationBathRadio();
    }
    return houmonRehabilitationBathRadio;

  }

  /**
   * 入浴加算コンテナを取得します。
   * @return 入浴加算コンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationBathRadioContainer(){
    if(houmonRehabilitationBathRadioContainer==null){
      houmonRehabilitationBathRadioContainer = new ACLabelContainer();
      houmonRehabilitationBathRadioContainer.setFollowChildEnabled(true);
      houmonRehabilitationBathRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationBathRadioContainer.add(getHoumonRehabilitationBathRadio(), null);
    }
    return houmonRehabilitationBathRadioContainer;
  }

  /**
   * 入浴加算モデルを取得します。
   * @return 入浴加算モデル
   */
  protected ACListModelAdapter getHoumonRehabilitationBathRadioModel(){
    if(houmonRehabilitationBathRadioModel==null){
      houmonRehabilitationBathRadioModel = new ACListModelAdapter();
      addHoumonRehabilitationBathRadioModel();
    }
    return houmonRehabilitationBathRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonRehabilitationBathRadioItem1(){
    if(houmonRehabilitationBathRadioItem1==null){

      houmonRehabilitationBathRadioItem1 = new ACRadioButtonItem();

      houmonRehabilitationBathRadioItem1.setText("なし");

      houmonRehabilitationBathRadioItem1.setGroup(getHoumonRehabilitationBathRadio());

      houmonRehabilitationBathRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationBathRadioItem1();
    }
    return houmonRehabilitationBathRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonRehabilitationBathRadioItem2(){
    if(houmonRehabilitationBathRadioItem2==null){

      houmonRehabilitationBathRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationBathRadioItem2.setText("あり");

      houmonRehabilitationBathRadioItem2.setGroup(getHoumonRehabilitationBathRadio());

      houmonRehabilitationBathRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationBathRadioItem2();
    }
    return houmonRehabilitationBathRadioItem2;

  }

  /**
   * リハビリ訪問指導等加算を取得します。
   * @return リハビリ訪問指導等加算
   */
  public ACValueArrayRadioButtonGroup getHoumonRehabilitationAdditionTreatmentPersonRadio(){
    if(houmonRehabilitationAdditionTreatmentPersonRadio==null){

      houmonRehabilitationAdditionTreatmentPersonRadio = new ACValueArrayRadioButtonGroup();

      getHoumonRehabilitationAdditionTreatmentPersonRadioContainer().setText("リハビリ訪問指導等加算" + ACConstants.LINE_SEPARATOR + "（1月に1回を限度）");

      houmonRehabilitationAdditionTreatmentPersonRadio.setBindPath("1160107");

      houmonRehabilitationAdditionTreatmentPersonRadio.setUseClearButton(false);

      houmonRehabilitationAdditionTreatmentPersonRadio.setModel(getHoumonRehabilitationAdditionTreatmentPersonRadioModel());

      houmonRehabilitationAdditionTreatmentPersonRadio.setValues(new int[]{1,2});

      addHoumonRehabilitationAdditionTreatmentPersonRadio();
    }
    return houmonRehabilitationAdditionTreatmentPersonRadio;

  }

  /**
   * リハビリ訪問指導等加算コンテナを取得します。
   * @return リハビリ訪問指導等加算コンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationAdditionTreatmentPersonRadioContainer(){
    if(houmonRehabilitationAdditionTreatmentPersonRadioContainer==null){
      houmonRehabilitationAdditionTreatmentPersonRadioContainer = new ACLabelContainer();
      houmonRehabilitationAdditionTreatmentPersonRadioContainer.setFollowChildEnabled(true);
      houmonRehabilitationAdditionTreatmentPersonRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationAdditionTreatmentPersonRadioContainer.add(getHoumonRehabilitationAdditionTreatmentPersonRadio(), null);
    }
    return houmonRehabilitationAdditionTreatmentPersonRadioContainer;
  }

  /**
   * リハビリ訪問指導等加算モデルを取得します。
   * @return リハビリ訪問指導等加算モデル
   */
  protected ACListModelAdapter getHoumonRehabilitationAdditionTreatmentPersonRadioModel(){
    if(houmonRehabilitationAdditionTreatmentPersonRadioModel==null){
      houmonRehabilitationAdditionTreatmentPersonRadioModel = new ACListModelAdapter();
      addHoumonRehabilitationAdditionTreatmentPersonRadioModel();
    }
    return houmonRehabilitationAdditionTreatmentPersonRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonRehabilitationAdditionTreatmentPersonRadioItem1(){
    if(houmonRehabilitationAdditionTreatmentPersonRadioItem1==null){

      houmonRehabilitationAdditionTreatmentPersonRadioItem1 = new ACRadioButtonItem();

      houmonRehabilitationAdditionTreatmentPersonRadioItem1.setText("なし");

      houmonRehabilitationAdditionTreatmentPersonRadioItem1.setGroup(getHoumonRehabilitationAdditionTreatmentPersonRadio());

      houmonRehabilitationAdditionTreatmentPersonRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationAdditionTreatmentPersonRadioItem1();
    }
    return houmonRehabilitationAdditionTreatmentPersonRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonRehabilitationAdditionTreatmentPersonRadioItem2(){
    if(houmonRehabilitationAdditionTreatmentPersonRadioItem2==null){

      houmonRehabilitationAdditionTreatmentPersonRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationAdditionTreatmentPersonRadioItem2.setText("あり");

      houmonRehabilitationAdditionTreatmentPersonRadioItem2.setGroup(getHoumonRehabilitationAdditionTreatmentPersonRadio());

      houmonRehabilitationAdditionTreatmentPersonRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationAdditionTreatmentPersonRadioItem2();
    }
    return houmonRehabilitationAdditionTreatmentPersonRadioItem2;

  }

  /**
   * リハビリ・マネジメント加算を取得します。
   * @return リハビリ・マネジメント加算
   */
  public ACValueArrayRadioButtonGroup getHoumonRehabilitationManagementAddRadio(){
    if(houmonRehabilitationManagementAddRadio==null){

      houmonRehabilitationManagementAddRadio = new ACValueArrayRadioButtonGroup();

      getHoumonRehabilitationManagementAddRadioContainer().setText("リハビリ・マネジメント加算");

      houmonRehabilitationManagementAddRadio.setBindPath("1160111");

      houmonRehabilitationManagementAddRadio.setUseClearButton(false);

      houmonRehabilitationManagementAddRadio.setModel(getHoumonRehabilitationManagementAddRadioModel());

      houmonRehabilitationManagementAddRadio.setValues(new int[]{1,2});

      addHoumonRehabilitationManagementAddRadio();
    }
    return houmonRehabilitationManagementAddRadio;

  }

  /**
   * リハビリ・マネジメント加算コンテナを取得します。
   * @return リハビリ・マネジメント加算コンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationManagementAddRadioContainer(){
    if(houmonRehabilitationManagementAddRadioContainer==null){
      houmonRehabilitationManagementAddRadioContainer = new ACLabelContainer();
      houmonRehabilitationManagementAddRadioContainer.setFollowChildEnabled(true);
      houmonRehabilitationManagementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationManagementAddRadioContainer.add(getHoumonRehabilitationManagementAddRadio(), null);
    }
    return houmonRehabilitationManagementAddRadioContainer;
  }

  /**
   * リハビリ・マネジメント加算モデルを取得します。
   * @return リハビリ・マネジメント加算モデル
   */
  protected ACListModelAdapter getHoumonRehabilitationManagementAddRadioModel(){
    if(houmonRehabilitationManagementAddRadioModel==null){
      houmonRehabilitationManagementAddRadioModel = new ACListModelAdapter();
      addHoumonRehabilitationManagementAddRadioModel();
    }
    return houmonRehabilitationManagementAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonRehabilitationManagementAddRadioItem1(){
    if(houmonRehabilitationManagementAddRadioItem1==null){

      houmonRehabilitationManagementAddRadioItem1 = new ACRadioButtonItem();

      houmonRehabilitationManagementAddRadioItem1.setText("なし");

      houmonRehabilitationManagementAddRadioItem1.setGroup(getHoumonRehabilitationManagementAddRadio());

      houmonRehabilitationManagementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationManagementAddRadioItem1();
    }
    return houmonRehabilitationManagementAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonRehabilitationManagementAddRadioItem2(){
    if(houmonRehabilitationManagementAddRadioItem2==null){

      houmonRehabilitationManagementAddRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationManagementAddRadioItem2.setText("あり");

      houmonRehabilitationManagementAddRadioItem2.setGroup(getHoumonRehabilitationManagementAddRadio());

      houmonRehabilitationManagementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationManagementAddRadioItem2();
    }
    return houmonRehabilitationManagementAddRadioItem2;

  }

  /**
   * 提供時間コンテナを取得します。
   * @return 提供時間コンテナ
   */
  public ACBackLabelContainer getHoumonRehabilitationTimeContena(){
    if(houmonRehabilitationTimeContena==null){

      houmonRehabilitationTimeContena = new ACBackLabelContainer();

      addHoumonRehabilitationTimeContena();
    }
    return houmonRehabilitationTimeContena;

  }

  /**
   * 開始時刻コンボを取得します。
   * @return 開始時刻コンボ
   */
  public ACTimeComboBox getHoumonRehabilitationTimeContenaBeginTime(){
    if(houmonRehabilitationTimeContenaBeginTime==null){

      houmonRehabilitationTimeContenaBeginTime = new ACTimeComboBox();

      getHoumonRehabilitationTimeContenaBeginTimeContainer().setText("開始時刻");

      houmonRehabilitationTimeContenaBeginTime.setBindPath("3");

      houmonRehabilitationTimeContenaBeginTime.setModelBindPath("3");

      houmonRehabilitationTimeContenaBeginTime.setRenderBindPath("CONTENT");

      houmonRehabilitationTimeContenaBeginTime.setModel(getHoumonRehabilitationTimeContenaBeginTimeModel());

      addHoumonRehabilitationTimeContenaBeginTime();
    }
    return houmonRehabilitationTimeContenaBeginTime;

  }

  /**
   * 開始時刻コンボコンテナを取得します。
   * @return 開始時刻コンボコンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationTimeContenaBeginTimeContainer(){
    if(houmonRehabilitationTimeContenaBeginTimeContainer==null){
      houmonRehabilitationTimeContenaBeginTimeContainer = new ACLabelContainer();
      houmonRehabilitationTimeContenaBeginTimeContainer.setFollowChildEnabled(true);
      houmonRehabilitationTimeContenaBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationTimeContenaBeginTimeContainer.add(getHoumonRehabilitationTimeContenaBeginTime(), null);
    }
    return houmonRehabilitationTimeContenaBeginTimeContainer;
  }

  /**
   * 開始時刻コンボモデルを取得します。
   * @return 開始時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getHoumonRehabilitationTimeContenaBeginTimeModel(){
    if(houmonRehabilitationTimeContenaBeginTimeModel==null){
      houmonRehabilitationTimeContenaBeginTimeModel = new ACComboBoxModelAdapter();
      addHoumonRehabilitationTimeContenaBeginTimeModel();
    }
    return houmonRehabilitationTimeContenaBeginTimeModel;
  }

  /**
   * 終了時刻コンボを取得します。
   * @return 終了時刻コンボ
   */
  public ACTimeComboBox getHoumonRehabilitationTimeContenaEndTime(){
    if(houmonRehabilitationTimeContenaEndTime==null){

      houmonRehabilitationTimeContenaEndTime = new ACTimeComboBox();

      getHoumonRehabilitationTimeContenaEndTimeContainer().setText("終了時刻");

      houmonRehabilitationTimeContenaEndTime.setBindPath("4");

      houmonRehabilitationTimeContenaEndTime.setModelBindPath("4");

      houmonRehabilitationTimeContenaEndTime.setRenderBindPath("CONTENT");

      houmonRehabilitationTimeContenaEndTime.setModel(getHoumonRehabilitationTimeContenaEndTimeModel());

      addHoumonRehabilitationTimeContenaEndTime();
    }
    return houmonRehabilitationTimeContenaEndTime;

  }

  /**
   * 終了時刻コンボコンテナを取得します。
   * @return 終了時刻コンボコンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationTimeContenaEndTimeContainer(){
    if(houmonRehabilitationTimeContenaEndTimeContainer==null){
      houmonRehabilitationTimeContenaEndTimeContainer = new ACLabelContainer();
      houmonRehabilitationTimeContenaEndTimeContainer.setFollowChildEnabled(true);
      houmonRehabilitationTimeContenaEndTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationTimeContenaEndTimeContainer.add(getHoumonRehabilitationTimeContenaEndTime(), null);
    }
    return houmonRehabilitationTimeContenaEndTimeContainer;
  }

  /**
   * 終了時刻コンボモデルを取得します。
   * @return 終了時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getHoumonRehabilitationTimeContenaEndTimeModel(){
    if(houmonRehabilitationTimeContenaEndTimeModel==null){
      houmonRehabilitationTimeContenaEndTimeModel = new ACComboBoxModelAdapter();
      addHoumonRehabilitationTimeContenaEndTimeModel();
    }
    return houmonRehabilitationTimeContenaEndTimeModel;
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
   * 短期集中リハビリ加算を取得します。
   * @return 短期集中リハビリ加算
   */
  public ACValueArrayRadioButtonGroup getHoumonRehabilitationShortConcentrationAddRadio(){
    if(houmonRehabilitationShortConcentrationAddRadio==null){

      houmonRehabilitationShortConcentrationAddRadio = new ACValueArrayRadioButtonGroup();

      getHoumonRehabilitationShortConcentrationAddRadioContainer().setText("短期集中リハビリ加算");

      houmonRehabilitationShortConcentrationAddRadio.setBindPath("1160112");

      houmonRehabilitationShortConcentrationAddRadio.setUseClearButton(false);

      houmonRehabilitationShortConcentrationAddRadio.setModel(getHoumonRehabilitationShortConcentrationAddRadioModel());

      houmonRehabilitationShortConcentrationAddRadio.setValues(new int[]{1,2,3});

      addHoumonRehabilitationShortConcentrationAddRadio();
    }
    return houmonRehabilitationShortConcentrationAddRadio;

  }

  /**
   * 短期集中リハビリ加算コンテナを取得します。
   * @return 短期集中リハビリ加算コンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationShortConcentrationAddRadioContainer(){
    if(houmonRehabilitationShortConcentrationAddRadioContainer==null){
      houmonRehabilitationShortConcentrationAddRadioContainer = new ACLabelContainer();
      houmonRehabilitationShortConcentrationAddRadioContainer.setFollowChildEnabled(true);
      houmonRehabilitationShortConcentrationAddRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationShortConcentrationAddRadioContainer.add(getHoumonRehabilitationShortConcentrationAddRadio(), null);
    }
    return houmonRehabilitationShortConcentrationAddRadioContainer;
  }

  /**
   * 短期集中リハビリ加算モデルを取得します。
   * @return 短期集中リハビリ加算モデル
   */
  protected ACListModelAdapter getHoumonRehabilitationShortConcentrationAddRadioModel(){
    if(houmonRehabilitationShortConcentrationAddRadioModel==null){
      houmonRehabilitationShortConcentrationAddRadioModel = new ACListModelAdapter();
      addHoumonRehabilitationShortConcentrationAddRadioModel();
    }
    return houmonRehabilitationShortConcentrationAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonRehabilitationShortConcentrationAddRadioItem1(){
    if(houmonRehabilitationShortConcentrationAddRadioItem1==null){

      houmonRehabilitationShortConcentrationAddRadioItem1 = new ACRadioButtonItem();

      houmonRehabilitationShortConcentrationAddRadioItem1.setText("なし");

      houmonRehabilitationShortConcentrationAddRadioItem1.setGroup(getHoumonRehabilitationShortConcentrationAddRadio());

      houmonRehabilitationShortConcentrationAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationShortConcentrationAddRadioItem1();
    }
    return houmonRehabilitationShortConcentrationAddRadioItem1;

  }

  /**
   * 1月以内を取得します。
   * @return 1月以内
   */
  public ACRadioButtonItem getHoumonRehabilitationShortConcentrationAddRadioItem2(){
    if(houmonRehabilitationShortConcentrationAddRadioItem2==null){

      houmonRehabilitationShortConcentrationAddRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationShortConcentrationAddRadioItem2.setText("1月以内");

      houmonRehabilitationShortConcentrationAddRadioItem2.setGroup(getHoumonRehabilitationShortConcentrationAddRadio());

      houmonRehabilitationShortConcentrationAddRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabilitationShortConcentrationAddRadioItem2();
    }
    return houmonRehabilitationShortConcentrationAddRadioItem2;

  }

  /**
   * 1月超3月以内を取得します。
   * @return 1月超3月以内
   */
  public ACRadioButtonItem getHoumonRehabilitationShortConcentrationAddRadioItem3(){
    if(houmonRehabilitationShortConcentrationAddRadioItem3==null){

      houmonRehabilitationShortConcentrationAddRadioItem3 = new ACRadioButtonItem();

      houmonRehabilitationShortConcentrationAddRadioItem3.setText("1月超3月以内");

      houmonRehabilitationShortConcentrationAddRadioItem3.setGroup(getHoumonRehabilitationShortConcentrationAddRadio());

      houmonRehabilitationShortConcentrationAddRadioItem3.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationShortConcentrationAddRadioItem3();
    }
    return houmonRehabilitationShortConcentrationAddRadioItem3;

  }

  /**
   * 個別リハビリ実施加算を取得します。
   * @return 個別リハビリ実施加算
   */
  public ACValueArrayRadioButtonGroup getOpenStockRehabilitationConcentrationAddRadio(){
    if(openStockRehabilitationConcentrationAddRadio==null){

      openStockRehabilitationConcentrationAddRadio = new ACValueArrayRadioButtonGroup();

      getOpenStockRehabilitationConcentrationAddRadioContainer().setText("個別リハビリ実施加算");

      openStockRehabilitationConcentrationAddRadio.setBindPath("1160118");

      openStockRehabilitationConcentrationAddRadio.setNoSelectIndex(0);

      openStockRehabilitationConcentrationAddRadio.setUseClearButton(false);

      openStockRehabilitationConcentrationAddRadio.setModel(getOpenStockRehabilitationConcentrationAddRadioModel());

      openStockRehabilitationConcentrationAddRadio.setValues(new int[]{1,2});

      addOpenStockRehabilitationConcentrationAddRadio();
    }
    return openStockRehabilitationConcentrationAddRadio;

  }

  /**
   * 個別リハビリ実施加算コンテナを取得します。
   * @return 個別リハビリ実施加算コンテナ
   */
  protected ACLabelContainer getOpenStockRehabilitationConcentrationAddRadioContainer(){
    if(openStockRehabilitationConcentrationAddRadioContainer==null){
      openStockRehabilitationConcentrationAddRadioContainer = new ACLabelContainer();
      openStockRehabilitationConcentrationAddRadioContainer.setFollowChildEnabled(true);
      openStockRehabilitationConcentrationAddRadioContainer.setVAlignment(VRLayout.CENTER);
      openStockRehabilitationConcentrationAddRadioContainer.add(getOpenStockRehabilitationConcentrationAddRadio(), null);
    }
    return openStockRehabilitationConcentrationAddRadioContainer;
  }

  /**
   * 個別リハビリ実施加算モデルを取得します。
   * @return 個別リハビリ実施加算モデル
   */
  protected ACListModelAdapter getOpenStockRehabilitationConcentrationAddRadioModel(){
    if(openStockRehabilitationConcentrationAddRadioModel==null){
      openStockRehabilitationConcentrationAddRadioModel = new ACListModelAdapter();
      addOpenStockRehabilitationConcentrationAddRadioModel();
    }
    return openStockRehabilitationConcentrationAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getOpenStockRehabilitationConcentrationAddRadioItem1(){
    if(openStockRehabilitationConcentrationAddRadioItem1==null){

      openStockRehabilitationConcentrationAddRadioItem1 = new ACRadioButtonItem();

      openStockRehabilitationConcentrationAddRadioItem1.setText("なし");

      openStockRehabilitationConcentrationAddRadioItem1.setGroup(getOpenStockRehabilitationConcentrationAddRadio());

      openStockRehabilitationConcentrationAddRadioItem1.setConstraints(VRLayout.FLOW);

      addOpenStockRehabilitationConcentrationAddRadioItem1();
    }
    return openStockRehabilitationConcentrationAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getOpenStockRehabilitationConcentrationAddRadioItem2(){
    if(openStockRehabilitationConcentrationAddRadioItem2==null){

      openStockRehabilitationConcentrationAddRadioItem2 = new ACRadioButtonItem();

      openStockRehabilitationConcentrationAddRadioItem2.setText("あり");

      openStockRehabilitationConcentrationAddRadioItem2.setGroup(getOpenStockRehabilitationConcentrationAddRadio());

      openStockRehabilitationConcentrationAddRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addOpenStockRehabilitationConcentrationAddRadioItem2();
    }
    return openStockRehabilitationConcentrationAddRadioItem2;

  }

  /**
   * 理学療法士等体制強化加算を取得します。
   * @return 理学療法士等体制強化加算
   */
  public ACValueArrayRadioButtonGroup getPhysiotherapistStrengthenedAddRadioGroup(){
    if(physiotherapistStrengthenedAddRadioGroup==null){

      physiotherapistStrengthenedAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getPhysiotherapistStrengthenedAddRadioGroupContainer().setText("理学療法士等体制強化加算");

      physiotherapistStrengthenedAddRadioGroup.setBindPath("1160119");

      physiotherapistStrengthenedAddRadioGroup.setNoSelectIndex(0);

      physiotherapistStrengthenedAddRadioGroup.setUseClearButton(false);

      physiotherapistStrengthenedAddRadioGroup.setModel(getPhysiotherapistStrengthenedAddRadioGroupModel());

      physiotherapistStrengthenedAddRadioGroup.setValues(new int[]{1,2});

      addPhysiotherapistStrengthenedAddRadioGroup();
    }
    return physiotherapistStrengthenedAddRadioGroup;

  }

  /**
   * 理学療法士等体制強化加算コンテナを取得します。
   * @return 理学療法士等体制強化加算コンテナ
   */
  protected ACLabelContainer getPhysiotherapistStrengthenedAddRadioGroupContainer(){
    if(physiotherapistStrengthenedAddRadioGroupContainer==null){
      physiotherapistStrengthenedAddRadioGroupContainer = new ACLabelContainer();
      physiotherapistStrengthenedAddRadioGroupContainer.setFollowChildEnabled(true);
      physiotherapistStrengthenedAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      physiotherapistStrengthenedAddRadioGroupContainer.add(getPhysiotherapistStrengthenedAddRadioGroup(), null);
    }
    return physiotherapistStrengthenedAddRadioGroupContainer;
  }

  /**
   * 理学療法士等体制強化加算モデルを取得します。
   * @return 理学療法士等体制強化加算モデル
   */
  protected ACListModelAdapter getPhysiotherapistStrengthenedAddRadioGroupModel(){
    if(physiotherapistStrengthenedAddRadioGroupModel==null){
      physiotherapistStrengthenedAddRadioGroupModel = new ACListModelAdapter();
      addPhysiotherapistStrengthenedAddRadioGroupModel();
    }
    return physiotherapistStrengthenedAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getPhysiotherapistStrengthenedAddRadioItem1(){
    if(physiotherapistStrengthenedAddRadioItem1==null){

      physiotherapistStrengthenedAddRadioItem1 = new ACRadioButtonItem();

      physiotherapistStrengthenedAddRadioItem1.setText("なし");

      physiotherapistStrengthenedAddRadioItem1.setGroup(getPhysiotherapistStrengthenedAddRadioGroup());

      physiotherapistStrengthenedAddRadioItem1.setConstraints(VRLayout.FLOW);

      addPhysiotherapistStrengthenedAddRadioItem1();
    }
    return physiotherapistStrengthenedAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getPhysiotherapistStrengthenedAddRadioItem2(){
    if(physiotherapistStrengthenedAddRadioItem2==null){

      physiotherapistStrengthenedAddRadioItem2 = new ACRadioButtonItem();

      physiotherapistStrengthenedAddRadioItem2.setText("あり");

      physiotherapistStrengthenedAddRadioItem2.setGroup(getPhysiotherapistStrengthenedAddRadioGroup());

      physiotherapistStrengthenedAddRadioItem2.setConstraints(VRLayout.FLOW);

      addPhysiotherapistStrengthenedAddRadioItem2();
    }
    return physiotherapistStrengthenedAddRadioItem2;

  }

  /**
   * 認知症短期集中リハビリ実施加算を取得します。
   * @return 認知症短期集中リハビリ実施加算
   */
  public ACValueArrayRadioButtonGroup getDementiaRehabilitationShortConcentrationAddRadio(){
    if(dementiaRehabilitationShortConcentrationAddRadio==null){

      dementiaRehabilitationShortConcentrationAddRadio = new ACValueArrayRadioButtonGroup();

      getDementiaRehabilitationShortConcentrationAddRadioContainer().setText("認知症短期集中リハビリ実施加算");

      dementiaRehabilitationShortConcentrationAddRadio.setBindPath("1160120");

      dementiaRehabilitationShortConcentrationAddRadio.setNoSelectIndex(0);

      dementiaRehabilitationShortConcentrationAddRadio.setUseClearButton(false);

      dementiaRehabilitationShortConcentrationAddRadio.setModel(getDementiaRehabilitationShortConcentrationAddRadioModel());

      dementiaRehabilitationShortConcentrationAddRadio.setValues(new int[]{1,2});

      addDementiaRehabilitationShortConcentrationAddRadio();
    }
    return dementiaRehabilitationShortConcentrationAddRadio;

  }

  /**
   * 認知症短期集中リハビリ実施加算コンテナを取得します。
   * @return 認知症短期集中リハビリ実施加算コンテナ
   */
  protected ACLabelContainer getDementiaRehabilitationShortConcentrationAddRadioContainer(){
    if(dementiaRehabilitationShortConcentrationAddRadioContainer==null){
      dementiaRehabilitationShortConcentrationAddRadioContainer = new ACLabelContainer();
      dementiaRehabilitationShortConcentrationAddRadioContainer.setFollowChildEnabled(true);
      dementiaRehabilitationShortConcentrationAddRadioContainer.setVAlignment(VRLayout.CENTER);
      dementiaRehabilitationShortConcentrationAddRadioContainer.add(getDementiaRehabilitationShortConcentrationAddRadio(), null);
    }
    return dementiaRehabilitationShortConcentrationAddRadioContainer;
  }

  /**
   * 認知症短期集中リハビリ実施加算モデルを取得します。
   * @return 認知症短期集中リハビリ実施加算モデル
   */
  protected ACListModelAdapter getDementiaRehabilitationShortConcentrationAddRadioModel(){
    if(dementiaRehabilitationShortConcentrationAddRadioModel==null){
      dementiaRehabilitationShortConcentrationAddRadioModel = new ACListModelAdapter();
      addDementiaRehabilitationShortConcentrationAddRadioModel();
    }
    return dementiaRehabilitationShortConcentrationAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getDementiaRehabilitationShortConcentrationAddRadioItem1(){
    if(dementiaRehabilitationShortConcentrationAddRadioItem1==null){

      dementiaRehabilitationShortConcentrationAddRadioItem1 = new ACRadioButtonItem();

      dementiaRehabilitationShortConcentrationAddRadioItem1.setText("なし");

      dementiaRehabilitationShortConcentrationAddRadioItem1.setGroup(getDementiaRehabilitationShortConcentrationAddRadio());

      dementiaRehabilitationShortConcentrationAddRadioItem1.setConstraints(VRLayout.FLOW);

      addDementiaRehabilitationShortConcentrationAddRadioItem1();
    }
    return dementiaRehabilitationShortConcentrationAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getDementiaRehabilitationShortConcentrationAddRadioItem2(){
    if(dementiaRehabilitationShortConcentrationAddRadioItem2==null){

      dementiaRehabilitationShortConcentrationAddRadioItem2 = new ACRadioButtonItem();

      dementiaRehabilitationShortConcentrationAddRadioItem2.setText("あり");

      dementiaRehabilitationShortConcentrationAddRadioItem2.setGroup(getDementiaRehabilitationShortConcentrationAddRadio());

      dementiaRehabilitationShortConcentrationAddRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addDementiaRehabilitationShortConcentrationAddRadioItem2();
    }
    return dementiaRehabilitationShortConcentrationAddRadioItem2;

  }

  /**
   * 若年性認知症利用者受入加算を取得します。
   * @return 若年性認知症利用者受入加算
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("若年性認知症利用者受入加算");

      youngDementiaPatinetAddRadioGroup.setBindPath("1160121");

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
  public ACValueArrayRadioButtonGroup getHoumonRehabilitationNourishmentManagementAddRadio(){
    if(houmonRehabilitationNourishmentManagementAddRadio==null){

      houmonRehabilitationNourishmentManagementAddRadio = new ACValueArrayRadioButtonGroup();

      getHoumonRehabilitationNourishmentManagementAddRadioContainer().setText("栄養改善加算");

      houmonRehabilitationNourishmentManagementAddRadio.setBindPath("1160114");

      houmonRehabilitationNourishmentManagementAddRadio.setUseClearButton(false);

      houmonRehabilitationNourishmentManagementAddRadio.setModel(getHoumonRehabilitationNourishmentManagementAddRadioModel());

      houmonRehabilitationNourishmentManagementAddRadio.setValues(new int[]{1,2});

      addHoumonRehabilitationNourishmentManagementAddRadio();
    }
    return houmonRehabilitationNourishmentManagementAddRadio;

  }

  /**
   * 栄養改善加算コンテナを取得します。
   * @return 栄養改善加算コンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationNourishmentManagementAddRadioContainer(){
    if(houmonRehabilitationNourishmentManagementAddRadioContainer==null){
      houmonRehabilitationNourishmentManagementAddRadioContainer = new ACLabelContainer();
      houmonRehabilitationNourishmentManagementAddRadioContainer.setFollowChildEnabled(true);
      houmonRehabilitationNourishmentManagementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationNourishmentManagementAddRadioContainer.add(getHoumonRehabilitationNourishmentManagementAddRadio(), null);
    }
    return houmonRehabilitationNourishmentManagementAddRadioContainer;
  }

  /**
   * 栄養改善加算モデルを取得します。
   * @return 栄養改善加算モデル
   */
  protected ACListModelAdapter getHoumonRehabilitationNourishmentManagementAddRadioModel(){
    if(houmonRehabilitationNourishmentManagementAddRadioModel==null){
      houmonRehabilitationNourishmentManagementAddRadioModel = new ACListModelAdapter();
      addHoumonRehabilitationNourishmentManagementAddRadioModel();
    }
    return houmonRehabilitationNourishmentManagementAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonRehabilitationNourishmentManagementAddRadioItem1(){
    if(houmonRehabilitationNourishmentManagementAddRadioItem1==null){

      houmonRehabilitationNourishmentManagementAddRadioItem1 = new ACRadioButtonItem();

      houmonRehabilitationNourishmentManagementAddRadioItem1.setText("なし");

      houmonRehabilitationNourishmentManagementAddRadioItem1.setGroup(getHoumonRehabilitationNourishmentManagementAddRadio());

      houmonRehabilitationNourishmentManagementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationNourishmentManagementAddRadioItem1();
    }
    return houmonRehabilitationNourishmentManagementAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonRehabilitationNourishmentManagementAddRadioItem2(){
    if(houmonRehabilitationNourishmentManagementAddRadioItem2==null){

      houmonRehabilitationNourishmentManagementAddRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationNourishmentManagementAddRadioItem2.setText("あり");

      houmonRehabilitationNourishmentManagementAddRadioItem2.setGroup(getHoumonRehabilitationNourishmentManagementAddRadio());

      houmonRehabilitationNourishmentManagementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationNourishmentManagementAddRadioItem2();
    }
    return houmonRehabilitationNourishmentManagementAddRadioItem2;

  }

  /**
   * 口腔機能向上加算を取得します。
   * @return 口腔機能向上加算
   */
  public ACValueArrayRadioButtonGroup getHoumonRehabilitationMouthFunctionAddRadio(){
    if(houmonRehabilitationMouthFunctionAddRadio==null){

      houmonRehabilitationMouthFunctionAddRadio = new ACValueArrayRadioButtonGroup();

      getHoumonRehabilitationMouthFunctionAddRadioContainer().setText("口腔機能向上加算");

      houmonRehabilitationMouthFunctionAddRadio.setBindPath("1160115");

      houmonRehabilitationMouthFunctionAddRadio.setUseClearButton(false);

      houmonRehabilitationMouthFunctionAddRadio.setModel(getHoumonRehabilitationMouthFunctionAddRadioModel());

      houmonRehabilitationMouthFunctionAddRadio.setValues(new int[]{1,2});

      addHoumonRehabilitationMouthFunctionAddRadio();
    }
    return houmonRehabilitationMouthFunctionAddRadio;

  }

  /**
   * 口腔機能向上加算コンテナを取得します。
   * @return 口腔機能向上加算コンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationMouthFunctionAddRadioContainer(){
    if(houmonRehabilitationMouthFunctionAddRadioContainer==null){
      houmonRehabilitationMouthFunctionAddRadioContainer = new ACLabelContainer();
      houmonRehabilitationMouthFunctionAddRadioContainer.setFollowChildEnabled(true);
      houmonRehabilitationMouthFunctionAddRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationMouthFunctionAddRadioContainer.add(getHoumonRehabilitationMouthFunctionAddRadio(), null);
    }
    return houmonRehabilitationMouthFunctionAddRadioContainer;
  }

  /**
   * 口腔機能向上加算モデルを取得します。
   * @return 口腔機能向上加算モデル
   */
  protected ACListModelAdapter getHoumonRehabilitationMouthFunctionAddRadioModel(){
    if(houmonRehabilitationMouthFunctionAddRadioModel==null){
      houmonRehabilitationMouthFunctionAddRadioModel = new ACListModelAdapter();
      addHoumonRehabilitationMouthFunctionAddRadioModel();
    }
    return houmonRehabilitationMouthFunctionAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonRehabilitationMouthFunctionAddRadioItem1(){
    if(houmonRehabilitationMouthFunctionAddRadioItem1==null){

      houmonRehabilitationMouthFunctionAddRadioItem1 = new ACRadioButtonItem();

      houmonRehabilitationMouthFunctionAddRadioItem1.setText("なし");

      houmonRehabilitationMouthFunctionAddRadioItem1.setGroup(getHoumonRehabilitationMouthFunctionAddRadio());

      houmonRehabilitationMouthFunctionAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationMouthFunctionAddRadioItem1();
    }
    return houmonRehabilitationMouthFunctionAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonRehabilitationMouthFunctionAddRadioItem2(){
    if(houmonRehabilitationMouthFunctionAddRadioItem2==null){

      houmonRehabilitationMouthFunctionAddRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationMouthFunctionAddRadioItem2.setText("あり");

      houmonRehabilitationMouthFunctionAddRadioItem2.setGroup(getHoumonRehabilitationMouthFunctionAddRadio());

      houmonRehabilitationMouthFunctionAddRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationMouthFunctionAddRadioItem2();
    }
    return houmonRehabilitationMouthFunctionAddRadioItem2;

  }

  /**
   * 重度療養管理加算を取得します。
   * @return 重度療養管理加算
   */
  public ACValueArrayRadioButtonGroup getMedicalManagementRadioGroup(){
    if(medicalManagementRadioGroup==null){

      medicalManagementRadioGroup = new ACValueArrayRadioButtonGroup();

      getMedicalManagementRadioGroupContainer().setText("重度療養管理加算");

      medicalManagementRadioGroup.setBindPath("1160123");

      medicalManagementRadioGroup.setUseClearButton(false);

      medicalManagementRadioGroup.setModel(getMedicalManagementRadioGroupModel());

      medicalManagementRadioGroup.setValues(new int[]{1,2});

      addMedicalManagementRadioGroup();
    }
    return medicalManagementRadioGroup;

  }

  /**
   * 重度療養管理加算コンテナを取得します。
   * @return 重度療養管理加算コンテナ
   */
  protected ACLabelContainer getMedicalManagementRadioGroupContainer(){
    if(medicalManagementRadioGroupContainer==null){
      medicalManagementRadioGroupContainer = new ACLabelContainer();
      medicalManagementRadioGroupContainer.setFollowChildEnabled(true);
      medicalManagementRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      medicalManagementRadioGroupContainer.add(getMedicalManagementRadioGroup(), null);
    }
    return medicalManagementRadioGroupContainer;
  }

  /**
   * 重度療養管理加算モデルを取得します。
   * @return 重度療養管理加算モデル
   */
  protected ACListModelAdapter getMedicalManagementRadioGroupModel(){
    if(medicalManagementRadioGroupModel==null){
      medicalManagementRadioGroupModel = new ACListModelAdapter();
      addMedicalManagementRadioGroupModel();
    }
    return medicalManagementRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalManagementRadioItem1(){
    if(medicalManagementRadioItem1==null){

      medicalManagementRadioItem1 = new ACRadioButtonItem();

      medicalManagementRadioItem1.setText("なし");

      medicalManagementRadioItem1.setGroup(getMedicalManagementRadioGroup());

      medicalManagementRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalManagementRadioItem1();
    }
    return medicalManagementRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalManagementRadioItem2(){
    if(medicalManagementRadioItem2==null){

      medicalManagementRadioItem2 = new ACRadioButtonItem();

      medicalManagementRadioItem2.setText("あり");

      medicalManagementRadioItem2.setGroup(getMedicalManagementRadioGroup());

      medicalManagementRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalManagementRadioItem2();
    }
    return medicalManagementRadioItem2;

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
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACValueArrayRadioButtonGroup getHoumonRehabilitationSubtraction(){
    if(houmonRehabilitationSubtraction==null){

      houmonRehabilitationSubtraction = new ACValueArrayRadioButtonGroup();

      getHoumonRehabilitationSubtractionContainer().setText("人員減算");

      houmonRehabilitationSubtraction.setBindPath("1160109");

      houmonRehabilitationSubtraction.setUseClearButton(false);

      houmonRehabilitationSubtraction.setModel(getHoumonRehabilitationSubtractionModel());

      houmonRehabilitationSubtraction.setValues(new int[]{1,2,3});

      addHoumonRehabilitationSubtraction();
    }
    return houmonRehabilitationSubtraction;

  }

  /**
   * 人員減算コンテナを取得します。
   * @return 人員減算コンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationSubtractionContainer(){
    if(houmonRehabilitationSubtractionContainer==null){
      houmonRehabilitationSubtractionContainer = new ACLabelContainer();
      houmonRehabilitationSubtractionContainer.setFollowChildEnabled(true);
      houmonRehabilitationSubtractionContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationSubtractionContainer.add(getHoumonRehabilitationSubtraction(), null);
    }
    return houmonRehabilitationSubtractionContainer;
  }

  /**
   * 人員減算モデルを取得します。
   * @return 人員減算モデル
   */
  protected ACListModelAdapter getHoumonRehabilitationSubtractionModel(){
    if(houmonRehabilitationSubtractionModel==null){
      houmonRehabilitationSubtractionModel = new ACListModelAdapter();
      addHoumonRehabilitationSubtractionModel();
    }
    return houmonRehabilitationSubtractionModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonRehabilitationSubtractionNot(){
    if(houmonRehabilitationSubtractionNot==null){

      houmonRehabilitationSubtractionNot = new ACRadioButtonItem();

      houmonRehabilitationSubtractionNot.setText("なし");

      houmonRehabilitationSubtractionNot.setGroup(getHoumonRehabilitationSubtraction());

      houmonRehabilitationSubtractionNot.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationSubtractionNot();
    }
    return houmonRehabilitationSubtractionNot;

  }

  /**
   * 定員超過を取得します。
   * @return 定員超過
   */
  public ACRadioButtonItem getHoumonRehabilitationSubtractionExcess(){
    if(houmonRehabilitationSubtractionExcess==null){

      houmonRehabilitationSubtractionExcess = new ACRadioButtonItem();

      houmonRehabilitationSubtractionExcess.setText("定員超過");

      houmonRehabilitationSubtractionExcess.setGroup(getHoumonRehabilitationSubtraction());

      houmonRehabilitationSubtractionExcess.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabilitationSubtractionExcess();
    }
    return houmonRehabilitationSubtractionExcess;

  }

  /**
   * 医師、PT・OT・ST、看護・介護職員の不足を取得します。
   * @return 医師、PT・OT・ST、看護・介護職員の不足
   */
  public ACRadioButtonItem getHoumonRehabilitationSubtractionLack(){
    if(houmonRehabilitationSubtractionLack==null){

      houmonRehabilitationSubtractionLack = new ACRadioButtonItem();

      houmonRehabilitationSubtractionLack.setText("<html>医師、PT・OT・ST、<br>看護・介護職員の不足</html>");

      houmonRehabilitationSubtractionLack.setGroup(getHoumonRehabilitationSubtraction());

      houmonRehabilitationSubtractionLack.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationSubtractionLack();
    }
    return houmonRehabilitationSubtractionLack;

  }

  /**
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1160122");

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,2,3});

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
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("I型");

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
  public QS001_11611_201204Design() {

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

  }

  /**
   * タブ1に内部項目を追加します。
   */
  protected void addTab1(){

    tab1.add(getFacilityDivisionRadioGroupContainer(), VRLayout.FLOW_INSETLINE);

    tab1.add(getHoumonRehabilitationTimeDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationBathRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationAdditionTreatmentPersonRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationManagementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * 施設等の区分に内部項目を追加します。
   */
  protected void addFacilityDivisionRadioGroup(){

  }

  /**
   * 施設等の区分モデルに内部項目を追加します。
   */
  protected void addFacilityDivisionRadioGroupModel(){

    getFacilityDivisionRadioItem1().setButtonIndex(1);

    getFacilityDivisionRadioGroupModel().add(getFacilityDivisionRadioItem1());

    getFacilityDivisionRadioItem2().setButtonIndex(2);

    getFacilityDivisionRadioGroupModel().add(getFacilityDivisionRadioItem2());

    getFacilityDivisionRadioItem3().setButtonIndex(3);

    getFacilityDivisionRadioGroupModel().add(getFacilityDivisionRadioItem3());

    getFacilityDivisionRadioItem4().setButtonIndex(4);

    getFacilityDivisionRadioGroupModel().add(getFacilityDivisionRadioItem4());

    getFacilityDivisionRadioItem5().setButtonIndex(5);

    getFacilityDivisionRadioGroupModel().add(getFacilityDivisionRadioItem5());

    getFacilityDivisionRadioItem6().setButtonIndex(6);

    getFacilityDivisionRadioGroupModel().add(getFacilityDivisionRadioItem6());

  }

  /**
   * 通常規模（病院・診療所）に内部項目を追加します。
   */
  protected void addFacilityDivisionRadioItem1(){

  }

  /**
   * 通常規模（老健施設）に内部項目を追加します。
   */
  protected void addFacilityDivisionRadioItem2(){

  }

  /**
   * 大規模（I）（病院・診療所）に内部項目を追加します。
   */
  protected void addFacilityDivisionRadioItem3(){

  }

  /**
   * 大規模（I）（老健施設）に内部項目を追加します。
   */
  protected void addFacilityDivisionRadioItem4(){

  }

  /**
   * 大規模（II）（病院・診療所）に内部項目を追加します。
   */
  protected void addFacilityDivisionRadioItem5(){

  }

  /**
   * 大規模（II）（老健施設）に内部項目を追加します。
   */
  protected void addFacilityDivisionRadioItem6(){

  }

  /**
   * 時間区分に内部項目を追加します。
   */
  protected void addHoumonRehabilitationTimeDivision(){

  }

  /**
   * 時間区分モデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationTimeDivisionModel(){

  }

  /**
   * 入浴加算に内部項目を追加します。
   */
  protected void addHoumonRehabilitationBathRadio(){

  }

  /**
   * 入浴加算モデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationBathRadioModel(){

    getHoumonRehabilitationBathRadioItem1().setButtonIndex(1);

    getHoumonRehabilitationBathRadioModel().add(getHoumonRehabilitationBathRadioItem1());

    getHoumonRehabilitationBathRadioItem2().setButtonIndex(2);

    getHoumonRehabilitationBathRadioModel().add(getHoumonRehabilitationBathRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonRehabilitationBathRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonRehabilitationBathRadioItem2(){

  }

  /**
   * リハビリ訪問指導等加算に内部項目を追加します。
   */
  protected void addHoumonRehabilitationAdditionTreatmentPersonRadio(){

  }

  /**
   * リハビリ訪問指導等加算モデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationAdditionTreatmentPersonRadioModel(){

    getHoumonRehabilitationAdditionTreatmentPersonRadioItem1().setButtonIndex(1);

    getHoumonRehabilitationAdditionTreatmentPersonRadioModel().add(getHoumonRehabilitationAdditionTreatmentPersonRadioItem1());

    getHoumonRehabilitationAdditionTreatmentPersonRadioItem2().setButtonIndex(2);

    getHoumonRehabilitationAdditionTreatmentPersonRadioModel().add(getHoumonRehabilitationAdditionTreatmentPersonRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonRehabilitationAdditionTreatmentPersonRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonRehabilitationAdditionTreatmentPersonRadioItem2(){

  }

  /**
   * リハビリ・マネジメント加算に内部項目を追加します。
   */
  protected void addHoumonRehabilitationManagementAddRadio(){

  }

  /**
   * リハビリ・マネジメント加算モデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationManagementAddRadioModel(){

    getHoumonRehabilitationManagementAddRadioItem1().setButtonIndex(1);

    getHoumonRehabilitationManagementAddRadioModel().add(getHoumonRehabilitationManagementAddRadioItem1());

    getHoumonRehabilitationManagementAddRadioItem2().setButtonIndex(2);

    getHoumonRehabilitationManagementAddRadioModel().add(getHoumonRehabilitationManagementAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonRehabilitationManagementAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonRehabilitationManagementAddRadioItem2(){

  }

  /**
   * 提供時間コンテナに内部項目を追加します。
   */
  protected void addHoumonRehabilitationTimeContena(){

    houmonRehabilitationTimeContena.add(getHoumonRehabilitationTimeContenaBeginTimeContainer(), VRLayout.FLOW);

    houmonRehabilitationTimeContena.add(getHoumonRehabilitationTimeContenaEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * 開始時刻コンボに内部項目を追加します。
   */
  protected void addHoumonRehabilitationTimeContenaBeginTime(){

  }

  /**
   * 開始時刻コンボモデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationTimeContenaBeginTimeModel(){

  }

  /**
   * 終了時刻コンボに内部項目を追加します。
   */
  protected void addHoumonRehabilitationTimeContenaEndTime(){

  }

  /**
   * 終了時刻コンボモデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationTimeContenaEndTimeModel(){

  }

  /**
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getHoumonRehabilitationShortConcentrationAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getOpenStockRehabilitationConcentrationAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getPhysiotherapistStrengthenedAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getDementiaRehabilitationShortConcentrationAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonRehabilitationNourishmentManagementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonRehabilitationMouthFunctionAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalManagementRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getTransportationCallRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 短期集中リハビリ加算に内部項目を追加します。
   */
  protected void addHoumonRehabilitationShortConcentrationAddRadio(){

  }

  /**
   * 短期集中リハビリ加算モデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationShortConcentrationAddRadioModel(){

    getHoumonRehabilitationShortConcentrationAddRadioItem1().setButtonIndex(1);

    getHoumonRehabilitationShortConcentrationAddRadioModel().add(getHoumonRehabilitationShortConcentrationAddRadioItem1());

    getHoumonRehabilitationShortConcentrationAddRadioItem2().setButtonIndex(2);

    getHoumonRehabilitationShortConcentrationAddRadioModel().add(getHoumonRehabilitationShortConcentrationAddRadioItem2());

    getHoumonRehabilitationShortConcentrationAddRadioItem3().setButtonIndex(3);

    getHoumonRehabilitationShortConcentrationAddRadioModel().add(getHoumonRehabilitationShortConcentrationAddRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonRehabilitationShortConcentrationAddRadioItem1(){

  }

  /**
   * 1月以内に内部項目を追加します。
   */
  protected void addHoumonRehabilitationShortConcentrationAddRadioItem2(){

  }

  /**
   * 1月超3月以内に内部項目を追加します。
   */
  protected void addHoumonRehabilitationShortConcentrationAddRadioItem3(){

  }

  /**
   * 個別リハビリ実施加算に内部項目を追加します。
   */
  protected void addOpenStockRehabilitationConcentrationAddRadio(){

  }

  /**
   * 個別リハビリ実施加算モデルに内部項目を追加します。
   */
  protected void addOpenStockRehabilitationConcentrationAddRadioModel(){

    getOpenStockRehabilitationConcentrationAddRadioItem1().setButtonIndex(1);

    getOpenStockRehabilitationConcentrationAddRadioModel().add(getOpenStockRehabilitationConcentrationAddRadioItem1());

    getOpenStockRehabilitationConcentrationAddRadioItem2().setButtonIndex(2);

    getOpenStockRehabilitationConcentrationAddRadioModel().add(getOpenStockRehabilitationConcentrationAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addOpenStockRehabilitationConcentrationAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addOpenStockRehabilitationConcentrationAddRadioItem2(){

  }

  /**
   * 理学療法士等体制強化加算に内部項目を追加します。
   */
  protected void addPhysiotherapistStrengthenedAddRadioGroup(){

  }

  /**
   * 理学療法士等体制強化加算モデルに内部項目を追加します。
   */
  protected void addPhysiotherapistStrengthenedAddRadioGroupModel(){

    getPhysiotherapistStrengthenedAddRadioItem1().setButtonIndex(1);

    getPhysiotherapistStrengthenedAddRadioGroupModel().add(getPhysiotherapistStrengthenedAddRadioItem1());

    getPhysiotherapistStrengthenedAddRadioItem2().setButtonIndex(2);

    getPhysiotherapistStrengthenedAddRadioGroupModel().add(getPhysiotherapistStrengthenedAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addPhysiotherapistStrengthenedAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addPhysiotherapistStrengthenedAddRadioItem2(){

  }

  /**
   * 認知症短期集中リハビリ実施加算に内部項目を追加します。
   */
  protected void addDementiaRehabilitationShortConcentrationAddRadio(){

  }

  /**
   * 認知症短期集中リハビリ実施加算モデルに内部項目を追加します。
   */
  protected void addDementiaRehabilitationShortConcentrationAddRadioModel(){

    getDementiaRehabilitationShortConcentrationAddRadioItem1().setButtonIndex(1);

    getDementiaRehabilitationShortConcentrationAddRadioModel().add(getDementiaRehabilitationShortConcentrationAddRadioItem1());

    getDementiaRehabilitationShortConcentrationAddRadioItem2().setButtonIndex(2);

    getDementiaRehabilitationShortConcentrationAddRadioModel().add(getDementiaRehabilitationShortConcentrationAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addDementiaRehabilitationShortConcentrationAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addDementiaRehabilitationShortConcentrationAddRadioItem2(){

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
  protected void addHoumonRehabilitationNourishmentManagementAddRadio(){

  }

  /**
   * 栄養改善加算モデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationNourishmentManagementAddRadioModel(){

    getHoumonRehabilitationNourishmentManagementAddRadioItem1().setButtonIndex(1);

    getHoumonRehabilitationNourishmentManagementAddRadioModel().add(getHoumonRehabilitationNourishmentManagementAddRadioItem1());

    getHoumonRehabilitationNourishmentManagementAddRadioItem2().setButtonIndex(2);

    getHoumonRehabilitationNourishmentManagementAddRadioModel().add(getHoumonRehabilitationNourishmentManagementAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonRehabilitationNourishmentManagementAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonRehabilitationNourishmentManagementAddRadioItem2(){

  }

  /**
   * 口腔機能向上加算に内部項目を追加します。
   */
  protected void addHoumonRehabilitationMouthFunctionAddRadio(){

  }

  /**
   * 口腔機能向上加算モデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationMouthFunctionAddRadioModel(){

    getHoumonRehabilitationMouthFunctionAddRadioItem1().setButtonIndex(1);

    getHoumonRehabilitationMouthFunctionAddRadioModel().add(getHoumonRehabilitationMouthFunctionAddRadioItem1());

    getHoumonRehabilitationMouthFunctionAddRadioItem2().setButtonIndex(2);

    getHoumonRehabilitationMouthFunctionAddRadioModel().add(getHoumonRehabilitationMouthFunctionAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonRehabilitationMouthFunctionAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonRehabilitationMouthFunctionAddRadioItem2(){

  }

  /**
   * 重度療養管理加算に内部項目を追加します。
   */
  protected void addMedicalManagementRadioGroup(){

  }

  /**
   * 重度療養管理加算モデルに内部項目を追加します。
   */
  protected void addMedicalManagementRadioGroupModel(){

    getMedicalManagementRadioItem1().setButtonIndex(1);

    getMedicalManagementRadioGroupModel().add(getMedicalManagementRadioItem1());

    getMedicalManagementRadioItem2().setButtonIndex(2);

    getMedicalManagementRadioGroupModel().add(getMedicalManagementRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalManagementRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalManagementRadioItem2(){

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
   * タブ3に内部項目を追加します。
   */
  protected void addTab3(){

    tab3.add(getHoumonRehabilitationSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getProviderAddMountainousAreaRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getCalculationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 人員減算に内部項目を追加します。
   */
  protected void addHoumonRehabilitationSubtraction(){

  }

  /**
   * 人員減算モデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationSubtractionModel(){

    getHoumonRehabilitationSubtractionNot().setButtonIndex(1);

    getHoumonRehabilitationSubtractionModel().add(getHoumonRehabilitationSubtractionNot());

    getHoumonRehabilitationSubtractionExcess().setButtonIndex(2);

    getHoumonRehabilitationSubtractionModel().add(getHoumonRehabilitationSubtractionExcess());

    getHoumonRehabilitationSubtractionLack().setButtonIndex(3);

    getHoumonRehabilitationSubtractionModel().add(getHoumonRehabilitationSubtractionLack());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonRehabilitationSubtractionNot(){

  }

  /**
   * 定員超過に内部項目を追加します。
   */
  protected void addHoumonRehabilitationSubtractionExcess(){

  }

  /**
   * 医師、PT・OT・ST、看護・介護職員の不足に内部項目を追加します。
   */
  protected void addHoumonRehabilitationSubtractionLack(){

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

    getServiceAddProvisionStructuralRadioItem3().setButtonIndex(3);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem3(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_11611_201204Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_11611_201204Design getThis() {
    return this;
  }
}
