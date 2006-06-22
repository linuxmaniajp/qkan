
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
 * プロセス 利用者一覧（サービス予定作成/変更） (001)
 * プログラム サービスパターン通所リハ (QS001108)
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
 * サービスパターン通所リハ画面項目デザイン(QS001108) 
 */
public class QS001108Design extends QS001ServicePanel {
  //GUIコンポーネント

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACLabelContainer houmonRehabilitationTimeFacilityDivisionContena;

  private ACClearableRadioButtonGroup houmonRehabilitationTimeContenaFacilityDivision;

  private ACListModelAdapter houmonRehabilitationTimeContenaFacilityDivisionModel;

  private ACRadioButtonItem houmonRehabilitationMedicalInstitution;

  private ACRadioButtonItem houmonRehabilitationDouble;

  private ACRadioButtonItem houmonRehabilitationClinic;

  private ACIntegerCheckBox houmonRehabilitationLarge;

  private ACComboBox houmonRehabilitationTimeDivision;

  private ACLabelContainer houmonRehabilitationTimeDivisionContainer;

  private ACComboBoxModelAdapter houmonRehabilitationTimeDivisionModel;

  private ACClearableRadioButtonGroup houmonRehabilitationBathRadio;

  private ACLabelContainer houmonRehabilitationBathRadioContainer;

  private ACListModelAdapter houmonRehabilitationBathRadioModel;

  private ACRadioButtonItem houmonRehabilitationBathRadioItem1;

  private ACRadioButtonItem houmonRehabilitationBathRadioItem2;

  private ACClearableRadioButtonGroup houmonRehabilitationAdditionTreatmentPersonRadio;

  private ACLabelContainer houmonRehabilitationAdditionTreatmentPersonRadioContainer;

  private ACListModelAdapter houmonRehabilitationAdditionTreatmentPersonRadioModel;

  private ACRadioButtonItem houmonRehabilitationAdditionTreatmentPersonRadioItem1;

  private ACRadioButtonItem houmonRehabilitationAdditionTreatmentPersonRadioItem2;

  private ACClearableRadioButtonGroup houmonRehabilitationManagementAddRadio;

  private ACLabelContainer houmonRehabilitationManagementAddRadioContainer;

  private ACListModelAdapter houmonRehabilitationManagementAddRadioModel;

  private ACRadioButtonItem houmonRehabilitationManagementAddRadioItem1;

  private ACRadioButtonItem houmonRehabilitationManagementAddRadioItem2;

  private ACClearableRadioButtonGroup houmonRehabilitationShortConcentrationAddRadio;

  private ACLabelContainer houmonRehabilitationShortConcentrationAddRadioContainer;

  private ACListModelAdapter houmonRehabilitationShortConcentrationAddRadioModel;

  private ACRadioButtonItem houmonRehabilitationShortConcentrationAddRadioItem1;

  private ACRadioButtonItem houmonRehabilitationShortConcentrationAddRadioItem2;

  private ACRadioButtonItem houmonRehabilitationShortConcentrationAddRadioItem3;

  private ACRadioButtonItem houmonRehabilitationShortConcentrationAddRadioItem4;

  private ACBackLabelContainer houmonRehabilitationTimeContena;

  private ACTimeComboBox houmonRehabilitationTimeContenaBeginTime;

  private ACLabelContainer houmonRehabilitationTimeContenaBeginTimeContainer;

  private ACComboBoxModelAdapter houmonRehabilitationTimeContenaBeginTimeModel;

  private ACTimeComboBox houmonRehabilitationTimeContenaEndTime;

  private ACLabelContainer houmonRehabilitationTimeContenaEndTimeContainer;

  private ACComboBoxModelAdapter houmonRehabilitationTimeContenaEndTimeModel;

  private ACPanel tab2;

  private ACClearableRadioButtonGroup houmonRehabilitationYouthNinchishoAddRadio;

  private ACLabelContainer houmonRehabilitationYouthNinchishoAddRadioContainer;

  private ACListModelAdapter houmonRehabilitationYouthNinchishoAddRadioModel;

  private ACRadioButtonItem houmonRehabilitationYouthNinchishoAddRadioItem1;

  private ACRadioButtonItem houmonRehabilitationYouthNinchishoAddRadioItem2;

  private ACClearableRadioButtonGroup houmonRehabilitationNourishmentManagementAddRadio;

  private ACLabelContainer houmonRehabilitationNourishmentManagementAddRadioContainer;

  private ACListModelAdapter houmonRehabilitationNourishmentManagementAddRadioModel;

  private ACRadioButtonItem houmonRehabilitationNourishmentManagementAddRadioItem1;

  private ACRadioButtonItem houmonRehabilitationNourishmentManagementAddRadioItem2;

  private ACClearableRadioButtonGroup houmonRehabilitationMouthFunctionAddRadio;

  private ACLabelContainer houmonRehabilitationMouthFunctionAddRadioContainer;

  private ACListModelAdapter houmonRehabilitationMouthFunctionAddRadioModel;

  private ACRadioButtonItem houmonRehabilitationMouthFunctionAddRadioItem1;

  private ACRadioButtonItem houmonRehabilitationMouthFunctionAddRadioItem2;

  private ACClearableRadioButtonGroup houmonRehabilitationSubtraction;

  private ACLabelContainer houmonRehabilitationSubtractionContainer;

  private ACListModelAdapter houmonRehabilitationSubtractionModel;

  private ACRadioButtonItem houmonRehabilitationSubtractionNot;

  private ACRadioButtonItem houmonRehabilitationSubtractionExcess;

  private ACRadioButtonItem houmonRehabilitationSubtractionLack;

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
   * 施設等の区分コンテナを取得します。
   * @return 施設等の区分コンテナ
   */
  public ACLabelContainer getHoumonRehabilitationTimeFacilityDivisionContena(){
    if(houmonRehabilitationTimeFacilityDivisionContena==null){

      houmonRehabilitationTimeFacilityDivisionContena = new ACLabelContainer();

      houmonRehabilitationTimeFacilityDivisionContena.setText("施設等の区分");

      addHoumonRehabilitationTimeFacilityDivisionContena();
    }
    return houmonRehabilitationTimeFacilityDivisionContena;

  }

  /**
   * 施設等の区分を取得します。
   * @return 施設等の区分
   */
  public ACClearableRadioButtonGroup getHoumonRehabilitationTimeContenaFacilityDivision(){
    if(houmonRehabilitationTimeContenaFacilityDivision==null){

      houmonRehabilitationTimeContenaFacilityDivision = new ACClearableRadioButtonGroup();

      houmonRehabilitationTimeContenaFacilityDivision.setBindPath("1160103");

      houmonRehabilitationTimeContenaFacilityDivision.setModel(getHoumonRehabilitationTimeContenaFacilityDivisionModel());

      houmonRehabilitationTimeContenaFacilityDivision.setUseClearButton(false);

      addHoumonRehabilitationTimeContenaFacilityDivision();
    }
    return houmonRehabilitationTimeContenaFacilityDivision;

  }

  /**
   * 施設等の区分モデルを取得します。
   * @return 施設等の区分モデル
   */
  protected ACListModelAdapter getHoumonRehabilitationTimeContenaFacilityDivisionModel(){
    if(houmonRehabilitationTimeContenaFacilityDivisionModel==null){
      houmonRehabilitationTimeContenaFacilityDivisionModel = new ACListModelAdapter();
      addHoumonRehabilitationTimeContenaFacilityDivisionModel();
    }
    return houmonRehabilitationTimeContenaFacilityDivisionModel;
  }

  /**
   * 通常規模医療機関を取得します。
   * @return 通常規模医療機関
   */
  public ACRadioButtonItem getHoumonRehabilitationMedicalInstitution(){
    if(houmonRehabilitationMedicalInstitution==null){

      houmonRehabilitationMedicalInstitution = new ACRadioButtonItem();

      houmonRehabilitationMedicalInstitution.setText("通常規模医療機関");

      houmonRehabilitationMedicalInstitution.setGroup(getHoumonRehabilitationTimeContenaFacilityDivision());

      houmonRehabilitationMedicalInstitution.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationMedicalInstitution();
    }
    return houmonRehabilitationMedicalInstitution;

  }

  /**
   * 小規模診療所を取得します。
   * @return 小規模診療所
   */
  public ACRadioButtonItem getHoumonRehabilitationDouble(){
    if(houmonRehabilitationDouble==null){

      houmonRehabilitationDouble = new ACRadioButtonItem();

      houmonRehabilitationDouble.setText("小規模診療所");

      houmonRehabilitationDouble.setGroup(getHoumonRehabilitationTimeContenaFacilityDivision());

      houmonRehabilitationDouble.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabilitationDouble();
    }
    return houmonRehabilitationDouble;

  }

  /**
   * 介護老人保健施設を取得します。
   * @return 介護老人保健施設
   */
  public ACRadioButtonItem getHoumonRehabilitationClinic(){
    if(houmonRehabilitationClinic==null){

      houmonRehabilitationClinic = new ACRadioButtonItem();

      houmonRehabilitationClinic.setText("介護老人保健施設");

      houmonRehabilitationClinic.setGroup(getHoumonRehabilitationTimeContenaFacilityDivision());

      houmonRehabilitationClinic.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationClinic();
    }
    return houmonRehabilitationClinic;

  }

  /**
   * 大規模事業所を取得します。
   * @return 大規模事業所
   */
  public ACIntegerCheckBox getHoumonRehabilitationLarge(){
    if(houmonRehabilitationLarge==null){

      houmonRehabilitationLarge = new ACIntegerCheckBox();

      houmonRehabilitationLarge.setText("大規模事業所");

      houmonRehabilitationLarge.setBindPath("1160110");

      houmonRehabilitationLarge.setSelectValue(2);

      houmonRehabilitationLarge.setUnSelectValue(1);

      addHoumonRehabilitationLarge();
    }
    return houmonRehabilitationLarge;

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

      houmonRehabilitationTimeDivision.setModel(getHoumonRehabilitationTimeDivisionModel());

      houmonRehabilitationTimeDivision.setRenderBindPath("CONTENT");

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
  public ACClearableRadioButtonGroup getHoumonRehabilitationBathRadio(){
    if(houmonRehabilitationBathRadio==null){

      houmonRehabilitationBathRadio = new ACClearableRadioButtonGroup();

      getHoumonRehabilitationBathRadioContainer().setText("入浴加算");

      houmonRehabilitationBathRadio.setBindPath("1160105");

      houmonRehabilitationBathRadio.setModel(getHoumonRehabilitationBathRadioModel());

      houmonRehabilitationBathRadio.setUseClearButton(false);

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
  public ACClearableRadioButtonGroup getHoumonRehabilitationAdditionTreatmentPersonRadio(){
    if(houmonRehabilitationAdditionTreatmentPersonRadio==null){

      houmonRehabilitationAdditionTreatmentPersonRadio = new ACClearableRadioButtonGroup();

      getHoumonRehabilitationAdditionTreatmentPersonRadioContainer().setText("リハビリ訪問指導等加算");

      houmonRehabilitationAdditionTreatmentPersonRadio.setBindPath("1160107");

      houmonRehabilitationAdditionTreatmentPersonRadio.setModel(getHoumonRehabilitationAdditionTreatmentPersonRadioModel());

      houmonRehabilitationAdditionTreatmentPersonRadio.setUseClearButton(false);

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
  public ACClearableRadioButtonGroup getHoumonRehabilitationManagementAddRadio(){
    if(houmonRehabilitationManagementAddRadio==null){

      houmonRehabilitationManagementAddRadio = new ACClearableRadioButtonGroup();

      getHoumonRehabilitationManagementAddRadioContainer().setText("リハビリ・マネジメント加算");

      houmonRehabilitationManagementAddRadio.setBindPath("1160111");

      houmonRehabilitationManagementAddRadio.setModel(getHoumonRehabilitationManagementAddRadioModel());

      houmonRehabilitationManagementAddRadio.setUseClearButton(false);

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
   * 短期集中リハビリ加算を取得します。
   * @return 短期集中リハビリ加算
   */
  public ACClearableRadioButtonGroup getHoumonRehabilitationShortConcentrationAddRadio(){
    if(houmonRehabilitationShortConcentrationAddRadio==null){

      houmonRehabilitationShortConcentrationAddRadio = new ACClearableRadioButtonGroup();

      getHoumonRehabilitationShortConcentrationAddRadioContainer().setText("短期集中リハビリ加算");

      houmonRehabilitationShortConcentrationAddRadio.setBindPath("1160112");

      houmonRehabilitationShortConcentrationAddRadio.setModel(getHoumonRehabilitationShortConcentrationAddRadioModel());

      houmonRehabilitationShortConcentrationAddRadio.setUseClearButton(false);

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
   * 3月超を取得します。
   * @return 3月超
   */
  public ACRadioButtonItem getHoumonRehabilitationShortConcentrationAddRadioItem4(){
    if(houmonRehabilitationShortConcentrationAddRadioItem4==null){

      houmonRehabilitationShortConcentrationAddRadioItem4 = new ACRadioButtonItem();

      houmonRehabilitationShortConcentrationAddRadioItem4.setText("3月超");

      houmonRehabilitationShortConcentrationAddRadioItem4.setGroup(getHoumonRehabilitationShortConcentrationAddRadio());

      houmonRehabilitationShortConcentrationAddRadioItem4.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationShortConcentrationAddRadioItem4();
    }
    return houmonRehabilitationShortConcentrationAddRadioItem4;

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

      houmonRehabilitationTimeContenaBeginTime.setModel(getHoumonRehabilitationTimeContenaBeginTimeModel());

      houmonRehabilitationTimeContenaBeginTime.setRenderBindPath("CONTENT");

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

      houmonRehabilitationTimeContenaEndTime.setModel(getHoumonRehabilitationTimeContenaEndTimeModel());

      houmonRehabilitationTimeContenaEndTime.setRenderBindPath("CONTENT");

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

      tab2.setHgap(0);

      addTab2();
    }
    return tab2;

  }

  /**
   * 若年性認知症ケア加算を取得します。
   * @return 若年性認知症ケア加算
   */
  public ACClearableRadioButtonGroup getHoumonRehabilitationYouthNinchishoAddRadio(){
    if(houmonRehabilitationYouthNinchishoAddRadio==null){

      houmonRehabilitationYouthNinchishoAddRadio = new ACClearableRadioButtonGroup();

      getHoumonRehabilitationYouthNinchishoAddRadioContainer().setText("若年性認知症ケア加算");

      houmonRehabilitationYouthNinchishoAddRadio.setBindPath("1160113");

      houmonRehabilitationYouthNinchishoAddRadio.setModel(getHoumonRehabilitationYouthNinchishoAddRadioModel());

      houmonRehabilitationYouthNinchishoAddRadio.setUseClearButton(false);

      addHoumonRehabilitationYouthNinchishoAddRadio();
    }
    return houmonRehabilitationYouthNinchishoAddRadio;

  }

  /**
   * 若年性認知症ケア加算コンテナを取得します。
   * @return 若年性認知症ケア加算コンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationYouthNinchishoAddRadioContainer(){
    if(houmonRehabilitationYouthNinchishoAddRadioContainer==null){
      houmonRehabilitationYouthNinchishoAddRadioContainer = new ACLabelContainer();
      houmonRehabilitationYouthNinchishoAddRadioContainer.setFollowChildEnabled(true);
      houmonRehabilitationYouthNinchishoAddRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationYouthNinchishoAddRadioContainer.add(getHoumonRehabilitationYouthNinchishoAddRadio(), null);
    }
    return houmonRehabilitationYouthNinchishoAddRadioContainer;
  }

  /**
   * 若年性認知症ケア加算モデルを取得します。
   * @return 若年性認知症ケア加算モデル
   */
  protected ACListModelAdapter getHoumonRehabilitationYouthNinchishoAddRadioModel(){
    if(houmonRehabilitationYouthNinchishoAddRadioModel==null){
      houmonRehabilitationYouthNinchishoAddRadioModel = new ACListModelAdapter();
      addHoumonRehabilitationYouthNinchishoAddRadioModel();
    }
    return houmonRehabilitationYouthNinchishoAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonRehabilitationYouthNinchishoAddRadioItem1(){
    if(houmonRehabilitationYouthNinchishoAddRadioItem1==null){

      houmonRehabilitationYouthNinchishoAddRadioItem1 = new ACRadioButtonItem();

      houmonRehabilitationYouthNinchishoAddRadioItem1.setText("なし");

      houmonRehabilitationYouthNinchishoAddRadioItem1.setGroup(getHoumonRehabilitationYouthNinchishoAddRadio());

      houmonRehabilitationYouthNinchishoAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationYouthNinchishoAddRadioItem1();
    }
    return houmonRehabilitationYouthNinchishoAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonRehabilitationYouthNinchishoAddRadioItem2(){
    if(houmonRehabilitationYouthNinchishoAddRadioItem2==null){

      houmonRehabilitationYouthNinchishoAddRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationYouthNinchishoAddRadioItem2.setText("あり");

      houmonRehabilitationYouthNinchishoAddRadioItem2.setGroup(getHoumonRehabilitationYouthNinchishoAddRadio());

      houmonRehabilitationYouthNinchishoAddRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationYouthNinchishoAddRadioItem2();
    }
    return houmonRehabilitationYouthNinchishoAddRadioItem2;

  }

  /**
   * 栄養マネジメント加算を取得します。
   * @return 栄養マネジメント加算
   */
  public ACClearableRadioButtonGroup getHoumonRehabilitationNourishmentManagementAddRadio(){
    if(houmonRehabilitationNourishmentManagementAddRadio==null){

      houmonRehabilitationNourishmentManagementAddRadio = new ACClearableRadioButtonGroup();

      getHoumonRehabilitationNourishmentManagementAddRadioContainer().setText("栄養マネジメント加算");

      houmonRehabilitationNourishmentManagementAddRadio.setBindPath("1160114");

      houmonRehabilitationNourishmentManagementAddRadio.setModel(getHoumonRehabilitationNourishmentManagementAddRadioModel());

      houmonRehabilitationNourishmentManagementAddRadio.setUseClearButton(false);

      addHoumonRehabilitationNourishmentManagementAddRadio();
    }
    return houmonRehabilitationNourishmentManagementAddRadio;

  }

  /**
   * 栄養マネジメント加算コンテナを取得します。
   * @return 栄養マネジメント加算コンテナ
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
   * 栄養マネジメント加算モデルを取得します。
   * @return 栄養マネジメント加算モデル
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
  public ACClearableRadioButtonGroup getHoumonRehabilitationMouthFunctionAddRadio(){
    if(houmonRehabilitationMouthFunctionAddRadio==null){

      houmonRehabilitationMouthFunctionAddRadio = new ACClearableRadioButtonGroup();

      getHoumonRehabilitationMouthFunctionAddRadioContainer().setText("口腔機能向上加算");

      houmonRehabilitationMouthFunctionAddRadio.setBindPath("1160115");

      houmonRehabilitationMouthFunctionAddRadio.setModel(getHoumonRehabilitationMouthFunctionAddRadioModel());

      houmonRehabilitationMouthFunctionAddRadio.setUseClearButton(false);

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
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACClearableRadioButtonGroup getHoumonRehabilitationSubtraction(){
    if(houmonRehabilitationSubtraction==null){

      houmonRehabilitationSubtraction = new ACClearableRadioButtonGroup();

      getHoumonRehabilitationSubtractionContainer().setText("人員減算");

      houmonRehabilitationSubtraction.setBindPath("1160109");

      houmonRehabilitationSubtraction.setModel(getHoumonRehabilitationSubtractionModel());

      houmonRehabilitationSubtraction.setUseClearButton(false);

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
   * コンストラクタです。
   */
  public QS001108Design() {

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

    tab1.add(getHoumonRehabilitationTimeFacilityDivisionContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationTimeDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationBathRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationAdditionTreatmentPersonRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationManagementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationShortConcentrationAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonRehabilitationTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * 施設等の区分コンテナに内部項目を追加します。
   */
  protected void addHoumonRehabilitationTimeFacilityDivisionContena(){

    houmonRehabilitationTimeFacilityDivisionContena.add(getHoumonRehabilitationTimeContenaFacilityDivision(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonRehabilitationTimeFacilityDivisionContena.add(getHoumonRehabilitationLarge(), VRLayout.FLOW);

  }

  /**
   * 施設等の区分に内部項目を追加します。
   */
  protected void addHoumonRehabilitationTimeContenaFacilityDivision(){

  }

  /**
   * 施設等の区分モデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationTimeContenaFacilityDivisionModel(){

    getHoumonRehabilitationMedicalInstitution().setButtonIndex(1);
    getHoumonRehabilitationTimeContenaFacilityDivisionModel().add(getHoumonRehabilitationMedicalInstitution());

    getHoumonRehabilitationDouble().setButtonIndex(2);
    getHoumonRehabilitationTimeContenaFacilityDivisionModel().add(getHoumonRehabilitationDouble());

    getHoumonRehabilitationClinic().setButtonIndex(3);
    getHoumonRehabilitationTimeContenaFacilityDivisionModel().add(getHoumonRehabilitationClinic());

  }

  /**
   * 通常規模医療機関に内部項目を追加します。
   */
  protected void addHoumonRehabilitationMedicalInstitution(){

  }

  /**
   * 小規模診療所に内部項目を追加します。
   */
  protected void addHoumonRehabilitationDouble(){

  }

  /**
   * 介護老人保健施設に内部項目を追加します。
   */
  protected void addHoumonRehabilitationClinic(){

  }

  /**
   * 大規模事業所に内部項目を追加します。
   */
  protected void addHoumonRehabilitationLarge(){

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

    getHoumonRehabilitationShortConcentrationAddRadioItem4().setButtonIndex(4);
    getHoumonRehabilitationShortConcentrationAddRadioModel().add(getHoumonRehabilitationShortConcentrationAddRadioItem4());

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
   * 3月超に内部項目を追加します。
   */
  protected void addHoumonRehabilitationShortConcentrationAddRadioItem4(){

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

    tab2.add(getHoumonRehabilitationYouthNinchishoAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonRehabilitationNourishmentManagementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonRehabilitationMouthFunctionAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonRehabilitationSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 若年性認知症ケア加算に内部項目を追加します。
   */
  protected void addHoumonRehabilitationYouthNinchishoAddRadio(){

  }

  /**
   * 若年性認知症ケア加算モデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationYouthNinchishoAddRadioModel(){

    getHoumonRehabilitationYouthNinchishoAddRadioItem1().setButtonIndex(1);
    getHoumonRehabilitationYouthNinchishoAddRadioModel().add(getHoumonRehabilitationYouthNinchishoAddRadioItem1());

    getHoumonRehabilitationYouthNinchishoAddRadioItem2().setButtonIndex(2);
    getHoumonRehabilitationYouthNinchishoAddRadioModel().add(getHoumonRehabilitationYouthNinchishoAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonRehabilitationYouthNinchishoAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonRehabilitationYouthNinchishoAddRadioItem2(){

  }

  /**
   * 栄養マネジメント加算に内部項目を追加します。
   */
  protected void addHoumonRehabilitationNourishmentManagementAddRadio(){

  }

  /**
   * 栄養マネジメント加算モデルに内部項目を追加します。
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
      ACFrame.debugStart(new ACAffairInfo(QS001108Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001108Design getThis() {
    return this;
  }
}
