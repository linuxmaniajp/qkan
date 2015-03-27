
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
 * プログラム サービスパターン地域密着型特定施設入所者生活介護 (QS001_13611_201504)
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
 * サービスパターン地域密着型特定施設入所者生活介護画面項目デザイン(QS001_13611_201504) 
 */
public class QS001_13611_201504Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel regionSpecificFacilityPatterns;

  private ACValueArrayRadioButtonGroup regionStaffSubtractionRadio;

  private ACLabelContainer regionStaffSubtractionRadioContainer;

  private ACListModelAdapter regionStaffSubtractionRadioModel;

  private ACRadioButtonItem regionSubtractionNo;

  private ACRadioButtonItem regionSubtractionPersonLack;

  private ACValueArrayRadioButtonGroup regionTrainingRadio;

  private ACLabelContainer regionTrainingRadioContainer;

  private ACListModelAdapter regionTrainingRadioModel;

  private ACRadioButtonItem regionTrainingRadioItem1;

  private ACRadioButtonItem regionTrainingRadioItem2;

  private ACValueArrayRadioButtonGroup regionNightStandardRadio;

  private ACLabelContainer regionNightStandardRadioContainer;

  private ACListModelAdapter regionNightStandardRadioModel;

  private ACRadioButtonItem regionNightStandardRadioItem1;

  private ACRadioButtonItem regionNightStandardRadioItem2;

  private ACValueArrayRadioButtonGroup medicalCoordinateAddRadioGroup;

  private ACLabelContainer medicalCoordinateAddRadioGroupContainer;

  private ACListModelAdapter medicalCoordinateAddRadioGroupModel;

  private ACRadioButtonItem medicalCoordinateAddRadioItem1;

  private ACRadioButtonItem medicalCoordinateAddRadioItem2;

  private ACValueArrayRadioButtonGroup watchCareRadioGroup;

  private ACLabelContainer watchCareRadioGroupContainer;

  private ACListModelAdapter watchCareRadioGroupModel;

  private ACRadioButtonItem watchCareRadioItem1;

  private ACRadioButtonItem watchCareRadioItem2;

  private ACRadioButtonItem watchCareRadioItem3;

  private ACRadioButtonItem watchCareRadioItem4;

  private ACValueArrayRadioButtonGroup dementiaProfessionalCareAddRadioGroup;

  private ACLabelContainer dementiaProfessionalCareAddRadioGroupContainer;

  private ACListModelAdapter dementiaProfessionalCareAddRadioGroupModel;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem1;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem2;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem3;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

  //getter

  /**
   * 地域密着特定施設入所者生活介護パターン領域を取得します。
   * @return 地域密着特定施設入所者生活介護パターン領域
   */
  public ACPanel getRegionSpecificFacilityPatterns(){
    if(regionSpecificFacilityPatterns==null){

      regionSpecificFacilityPatterns = new ACPanel();

      regionSpecificFacilityPatterns.setAutoWrap(false);

      regionSpecificFacilityPatterns.setFollowChildEnabled(true);

      regionSpecificFacilityPatterns.setHgrid(200);

      addRegionSpecificFacilityPatterns();
    }
    return regionSpecificFacilityPatterns;

  }

  /**
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACValueArrayRadioButtonGroup getRegionStaffSubtractionRadio(){
    if(regionStaffSubtractionRadio==null){

      regionStaffSubtractionRadio = new ACValueArrayRadioButtonGroup();

      getRegionStaffSubtractionRadioContainer().setText("人員減算");

      regionStaffSubtractionRadio.setBindPath("1360101");

      regionStaffSubtractionRadio.setUseClearButton(false);

      regionStaffSubtractionRadio.setModel(getRegionStaffSubtractionRadioModel());

      regionStaffSubtractionRadio.setValues(new int[]{1,2});

      addRegionStaffSubtractionRadio();
    }
    return regionStaffSubtractionRadio;

  }

  /**
   * 人員減算コンテナを取得します。
   * @return 人員減算コンテナ
   */
  protected ACLabelContainer getRegionStaffSubtractionRadioContainer(){
    if(regionStaffSubtractionRadioContainer==null){
      regionStaffSubtractionRadioContainer = new ACLabelContainer();
      regionStaffSubtractionRadioContainer.setFollowChildEnabled(true);
      regionStaffSubtractionRadioContainer.setVAlignment(VRLayout.CENTER);
      regionStaffSubtractionRadioContainer.add(getRegionStaffSubtractionRadio(), null);
    }
    return regionStaffSubtractionRadioContainer;
  }

  /**
   * 人員減算モデルを取得します。
   * @return 人員減算モデル
   */
  protected ACListModelAdapter getRegionStaffSubtractionRadioModel(){
    if(regionStaffSubtractionRadioModel==null){
      regionStaffSubtractionRadioModel = new ACListModelAdapter();
      addRegionStaffSubtractionRadioModel();
    }
    return regionStaffSubtractionRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getRegionSubtractionNo(){
    if(regionSubtractionNo==null){

      regionSubtractionNo = new ACRadioButtonItem();

      regionSubtractionNo.setText("なし");

      regionSubtractionNo.setGroup(getRegionStaffSubtractionRadio());

      regionSubtractionNo.setConstraints(VRLayout.FLOW);

      addRegionSubtractionNo();
    }
    return regionSubtractionNo;

  }

  /**
   * 看護・介護職員の不足を取得します。
   * @return 看護・介護職員の不足
   */
  public ACRadioButtonItem getRegionSubtractionPersonLack(){
    if(regionSubtractionPersonLack==null){

      regionSubtractionPersonLack = new ACRadioButtonItem();

      regionSubtractionPersonLack.setText("看護・介護職員の不足");

      regionSubtractionPersonLack.setGroup(getRegionStaffSubtractionRadio());

      regionSubtractionPersonLack.setConstraints(VRLayout.FLOW);

      addRegionSubtractionPersonLack();
    }
    return regionSubtractionPersonLack;

  }

  /**
   * 個別機能訓練指導体制加算を取得します。
   * @return 個別機能訓練指導体制加算
   */
  public ACValueArrayRadioButtonGroup getRegionTrainingRadio(){
    if(regionTrainingRadio==null){

      regionTrainingRadio = new ACValueArrayRadioButtonGroup();

      getRegionTrainingRadioContainer().setText("個別機能訓練指導加算");

      regionTrainingRadio.setBindPath("1360102");

      regionTrainingRadio.setUseClearButton(false);

      regionTrainingRadio.setModel(getRegionTrainingRadioModel());

      regionTrainingRadio.setValues(new int[]{1,2});

      addRegionTrainingRadio();
    }
    return regionTrainingRadio;

  }

  /**
   * 個別機能訓練指導体制加算コンテナを取得します。
   * @return 個別機能訓練指導体制加算コンテナ
   */
  protected ACLabelContainer getRegionTrainingRadioContainer(){
    if(regionTrainingRadioContainer==null){
      regionTrainingRadioContainer = new ACLabelContainer();
      regionTrainingRadioContainer.setFollowChildEnabled(true);
      regionTrainingRadioContainer.setVAlignment(VRLayout.CENTER);
      regionTrainingRadioContainer.add(getRegionTrainingRadio(), null);
    }
    return regionTrainingRadioContainer;
  }

  /**
   * 個別機能訓練指導体制加算モデルを取得します。
   * @return 個別機能訓練指導体制加算モデル
   */
  protected ACListModelAdapter getRegionTrainingRadioModel(){
    if(regionTrainingRadioModel==null){
      regionTrainingRadioModel = new ACListModelAdapter();
      addRegionTrainingRadioModel();
    }
    return regionTrainingRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getRegionTrainingRadioItem1(){
    if(regionTrainingRadioItem1==null){

      regionTrainingRadioItem1 = new ACRadioButtonItem();

      regionTrainingRadioItem1.setText("なし");

      regionTrainingRadioItem1.setGroup(getRegionTrainingRadio());

      regionTrainingRadioItem1.setConstraints(VRLayout.FLOW);

      addRegionTrainingRadioItem1();
    }
    return regionTrainingRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getRegionTrainingRadioItem2(){
    if(regionTrainingRadioItem2==null){

      regionTrainingRadioItem2 = new ACRadioButtonItem();

      regionTrainingRadioItem2.setText("あり");

      regionTrainingRadioItem2.setGroup(getRegionTrainingRadio());

      regionTrainingRadioItem2.setConstraints(VRLayout.FLOW);

      addRegionTrainingRadioItem2();
    }
    return regionTrainingRadioItem2;

  }

  /**
   * 夜間看護体制加算を取得します。
   * @return 夜間看護体制加算
   */
  public ACValueArrayRadioButtonGroup getRegionNightStandardRadio(){
    if(regionNightStandardRadio==null){

      regionNightStandardRadio = new ACValueArrayRadioButtonGroup();

      getRegionNightStandardRadioContainer().setText("夜間看護体制");

      regionNightStandardRadio.setBindPath("1360103");

      regionNightStandardRadio.setUseClearButton(false);

      regionNightStandardRadio.setModel(getRegionNightStandardRadioModel());

      regionNightStandardRadio.setValues(new int[]{1,2});

      addRegionNightStandardRadio();
    }
    return regionNightStandardRadio;

  }

  /**
   * 夜間看護体制加算コンテナを取得します。
   * @return 夜間看護体制加算コンテナ
   */
  protected ACLabelContainer getRegionNightStandardRadioContainer(){
    if(regionNightStandardRadioContainer==null){
      regionNightStandardRadioContainer = new ACLabelContainer();
      regionNightStandardRadioContainer.setFollowChildEnabled(true);
      regionNightStandardRadioContainer.setVAlignment(VRLayout.CENTER);
      regionNightStandardRadioContainer.add(getRegionNightStandardRadio(), null);
    }
    return regionNightStandardRadioContainer;
  }

  /**
   * 夜間看護体制加算モデルを取得します。
   * @return 夜間看護体制加算モデル
   */
  protected ACListModelAdapter getRegionNightStandardRadioModel(){
    if(regionNightStandardRadioModel==null){
      regionNightStandardRadioModel = new ACListModelAdapter();
      addRegionNightStandardRadioModel();
    }
    return regionNightStandardRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getRegionNightStandardRadioItem1(){
    if(regionNightStandardRadioItem1==null){

      regionNightStandardRadioItem1 = new ACRadioButtonItem();

      regionNightStandardRadioItem1.setText("なし");

      regionNightStandardRadioItem1.setGroup(getRegionNightStandardRadio());

      regionNightStandardRadioItem1.setConstraints(VRLayout.FLOW);

      addRegionNightStandardRadioItem1();
    }
    return regionNightStandardRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getRegionNightStandardRadioItem2(){
    if(regionNightStandardRadioItem2==null){

      regionNightStandardRadioItem2 = new ACRadioButtonItem();

      regionNightStandardRadioItem2.setText("あり");

      regionNightStandardRadioItem2.setGroup(getRegionNightStandardRadio());

      regionNightStandardRadioItem2.setConstraints(VRLayout.FLOW);

      addRegionNightStandardRadioItem2();
    }
    return regionNightStandardRadioItem2;

  }

  /**
   * 医療機関連携加算を取得します。
   * @return 医療機関連携加算
   */
  public ACValueArrayRadioButtonGroup getMedicalCoordinateAddRadioGroup(){
    if(medicalCoordinateAddRadioGroup==null){

      medicalCoordinateAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getMedicalCoordinateAddRadioGroupContainer().setText("医療機関連携加算");

      medicalCoordinateAddRadioGroup.setBindPath("1360104");

      medicalCoordinateAddRadioGroup.setUseClearButton(false);

      medicalCoordinateAddRadioGroup.setModel(getMedicalCoordinateAddRadioGroupModel());

      medicalCoordinateAddRadioGroup.setValues(new int[]{1,2});

      addMedicalCoordinateAddRadioGroup();
    }
    return medicalCoordinateAddRadioGroup;

  }

  /**
   * 医療機関連携加算コンテナを取得します。
   * @return 医療機関連携加算コンテナ
   */
  protected ACLabelContainer getMedicalCoordinateAddRadioGroupContainer(){
    if(medicalCoordinateAddRadioGroupContainer==null){
      medicalCoordinateAddRadioGroupContainer = new ACLabelContainer();
      medicalCoordinateAddRadioGroupContainer.setFollowChildEnabled(true);
      medicalCoordinateAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      medicalCoordinateAddRadioGroupContainer.add(getMedicalCoordinateAddRadioGroup(), null);
    }
    return medicalCoordinateAddRadioGroupContainer;
  }

  /**
   * 医療機関連携加算モデルを取得します。
   * @return 医療機関連携加算モデル
   */
  protected ACListModelAdapter getMedicalCoordinateAddRadioGroupModel(){
    if(medicalCoordinateAddRadioGroupModel==null){
      medicalCoordinateAddRadioGroupModel = new ACListModelAdapter();
      addMedicalCoordinateAddRadioGroupModel();
    }
    return medicalCoordinateAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalCoordinateAddRadioItem1(){
    if(medicalCoordinateAddRadioItem1==null){

      medicalCoordinateAddRadioItem1 = new ACRadioButtonItem();

      medicalCoordinateAddRadioItem1.setText("なし");

      medicalCoordinateAddRadioItem1.setGroup(getMedicalCoordinateAddRadioGroup());

      medicalCoordinateAddRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalCoordinateAddRadioItem1();
    }
    return medicalCoordinateAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalCoordinateAddRadioItem2(){
    if(medicalCoordinateAddRadioItem2==null){

      medicalCoordinateAddRadioItem2 = new ACRadioButtonItem();

      medicalCoordinateAddRadioItem2.setText("あり");

      medicalCoordinateAddRadioItem2.setGroup(getMedicalCoordinateAddRadioGroup());

      medicalCoordinateAddRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalCoordinateAddRadioItem2();
    }
    return medicalCoordinateAddRadioItem2;

  }

  /**
   * 看取り介護加算を取得します。
   * @return 看取り介護加算
   */
  public ACValueArrayRadioButtonGroup getWatchCareRadioGroup(){
    if(watchCareRadioGroup==null){

      watchCareRadioGroup = new ACValueArrayRadioButtonGroup();

      getWatchCareRadioGroupContainer().setText("看取り介護加算");

      watchCareRadioGroup.setBindPath("1360106");

      watchCareRadioGroup.setUseClearButton(false);

      watchCareRadioGroup.setModel(getWatchCareRadioGroupModel());

      watchCareRadioGroup.setValues(new int[]{1,2,3,4});

      addWatchCareRadioGroup();
    }
    return watchCareRadioGroup;

  }

  /**
   * 看取り介護加算コンテナを取得します。
   * @return 看取り介護加算コンテナ
   */
  protected ACLabelContainer getWatchCareRadioGroupContainer(){
    if(watchCareRadioGroupContainer==null){
      watchCareRadioGroupContainer = new ACLabelContainer();
      watchCareRadioGroupContainer.setFollowChildEnabled(true);
      watchCareRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      watchCareRadioGroupContainer.add(getWatchCareRadioGroup(), null);
    }
    return watchCareRadioGroupContainer;
  }

  /**
   * 看取り介護加算モデルを取得します。
   * @return 看取り介護加算モデル
   */
  protected ACListModelAdapter getWatchCareRadioGroupModel(){
    if(watchCareRadioGroupModel==null){
      watchCareRadioGroupModel = new ACListModelAdapter();
      addWatchCareRadioGroupModel();
    }
    return watchCareRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getWatchCareRadioItem1(){
    if(watchCareRadioItem1==null){

      watchCareRadioItem1 = new ACRadioButtonItem();

      watchCareRadioItem1.setText("なし");

      watchCareRadioItem1.setGroup(getWatchCareRadioGroup());

      watchCareRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addWatchCareRadioItem1();
    }
    return watchCareRadioItem1;

  }

  /**
   * 死亡日以前4日以上30日以下を取得します。
   * @return 死亡日以前4日以上30日以下
   */
  public ACRadioButtonItem getWatchCareRadioItem2(){
    if(watchCareRadioItem2==null){

      watchCareRadioItem2 = new ACRadioButtonItem();

      watchCareRadioItem2.setText("死亡日以前4日以上30日以下");

      watchCareRadioItem2.setGroup(getWatchCareRadioGroup());

      watchCareRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addWatchCareRadioItem2();
    }
    return watchCareRadioItem2;

  }

  /**
   * 死亡日以前2日又は3日を取得します。
   * @return 死亡日以前2日又は3日
   */
  public ACRadioButtonItem getWatchCareRadioItem3(){
    if(watchCareRadioItem3==null){

      watchCareRadioItem3 = new ACRadioButtonItem();

      watchCareRadioItem3.setText("死亡日以前2日又は3日");

      watchCareRadioItem3.setGroup(getWatchCareRadioGroup());

      watchCareRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addWatchCareRadioItem3();
    }
    return watchCareRadioItem3;

  }

  /**
   * 死亡日を取得します。
   * @return 死亡日
   */
  public ACRadioButtonItem getWatchCareRadioItem4(){
    if(watchCareRadioItem4==null){

      watchCareRadioItem4 = new ACRadioButtonItem();

      watchCareRadioItem4.setText("死亡日");

      watchCareRadioItem4.setGroup(getWatchCareRadioGroup());

      watchCareRadioItem4.setConstraints(VRLayout.FLOW);

      addWatchCareRadioItem4();
    }
    return watchCareRadioItem4;

  }

  /**
   * 認知症専門ケア加算を取得します。
   * @return 認知症専門ケア加算
   */
  public ACValueArrayRadioButtonGroup getDementiaProfessionalCareAddRadioGroup(){
    if(dementiaProfessionalCareAddRadioGroup==null){

      dementiaProfessionalCareAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaProfessionalCareAddRadioGroupContainer().setText("認知症専門ケア加算");

      dementiaProfessionalCareAddRadioGroup.setBindPath("1360107");

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
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1360108");

      serviceAddProvisionStructuralRadioGroup.setVisible(true);

      serviceAddProvisionStructuralRadioGroup.setEnabled(true);

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
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("Iイ型");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addServiceAddProvisionStructuralRadioItem2();
    }
    return serviceAddProvisionStructuralRadioItem2;

  }

  /**
   * Iロ型を取得します。
   * @return Iロ型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem3(){
    if(serviceAddProvisionStructuralRadioItem3==null){

      serviceAddProvisionStructuralRadioItem3 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem3.setText("Iロ型");

      serviceAddProvisionStructuralRadioItem3.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem3();
    }
    return serviceAddProvisionStructuralRadioItem3;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem4(){
    if(serviceAddProvisionStructuralRadioItem4==null){

      serviceAddProvisionStructuralRadioItem4 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem4.setText("II型");

      serviceAddProvisionStructuralRadioItem4.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem4.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem4();
    }
    return serviceAddProvisionStructuralRadioItem4;

  }

  /**
   * III型を取得します。
   * @return III型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem5(){
    if(serviceAddProvisionStructuralRadioItem5==null){

      serviceAddProvisionStructuralRadioItem5 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem5.setText("III型");

      serviceAddProvisionStructuralRadioItem5.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem5.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem5();
    }
    return serviceAddProvisionStructuralRadioItem5;

  }

  /**
   * コンストラクタです。
   */
  public QS001_13611_201504Design() {

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

    this.add(getRegionSpecificFacilityPatterns(), VRLayout.CLIENT);

  }

  /**
   * 地域密着特定施設入所者生活介護パターン領域に内部項目を追加します。
   */
  protected void addRegionSpecificFacilityPatterns(){

    regionSpecificFacilityPatterns.add(getRegionStaffSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    regionSpecificFacilityPatterns.add(getRegionTrainingRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    regionSpecificFacilityPatterns.add(getRegionNightStandardRadioContainer(), VRLayout.FLOW_RETURN);

    regionSpecificFacilityPatterns.add(getMedicalCoordinateAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    regionSpecificFacilityPatterns.add(getWatchCareRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    regionSpecificFacilityPatterns.add(getDementiaProfessionalCareAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    regionSpecificFacilityPatterns.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 人員減算に内部項目を追加します。
   */
  protected void addRegionStaffSubtractionRadio(){

  }

  /**
   * 人員減算モデルに内部項目を追加します。
   */
  protected void addRegionStaffSubtractionRadioModel(){

    getRegionSubtractionNo().setButtonIndex(1);

    getRegionStaffSubtractionRadioModel().add(getRegionSubtractionNo());

    getRegionSubtractionPersonLack().setButtonIndex(2);

    getRegionStaffSubtractionRadioModel().add(getRegionSubtractionPersonLack());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addRegionSubtractionNo(){

  }

  /**
   * 看護・介護職員の不足に内部項目を追加します。
   */
  protected void addRegionSubtractionPersonLack(){

  }

  /**
   * 個別機能訓練指導体制加算に内部項目を追加します。
   */
  protected void addRegionTrainingRadio(){

  }

  /**
   * 個別機能訓練指導体制加算モデルに内部項目を追加します。
   */
  protected void addRegionTrainingRadioModel(){

    getRegionTrainingRadioItem1().setButtonIndex(1);

    getRegionTrainingRadioModel().add(getRegionTrainingRadioItem1());

    getRegionTrainingRadioItem2().setButtonIndex(2);

    getRegionTrainingRadioModel().add(getRegionTrainingRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addRegionTrainingRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addRegionTrainingRadioItem2(){

  }

  /**
   * 夜間看護体制加算に内部項目を追加します。
   */
  protected void addRegionNightStandardRadio(){

  }

  /**
   * 夜間看護体制加算モデルに内部項目を追加します。
   */
  protected void addRegionNightStandardRadioModel(){

    getRegionNightStandardRadioItem1().setButtonIndex(1);

    getRegionNightStandardRadioModel().add(getRegionNightStandardRadioItem1());

    getRegionNightStandardRadioItem2().setButtonIndex(2);

    getRegionNightStandardRadioModel().add(getRegionNightStandardRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addRegionNightStandardRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addRegionNightStandardRadioItem2(){

  }

  /**
   * 医療機関連携加算に内部項目を追加します。
   */
  protected void addMedicalCoordinateAddRadioGroup(){

  }

  /**
   * 医療機関連携加算モデルに内部項目を追加します。
   */
  protected void addMedicalCoordinateAddRadioGroupModel(){

    getMedicalCoordinateAddRadioItem1().setButtonIndex(1);

    getMedicalCoordinateAddRadioGroupModel().add(getMedicalCoordinateAddRadioItem1());

    getMedicalCoordinateAddRadioItem2().setButtonIndex(2);

    getMedicalCoordinateAddRadioGroupModel().add(getMedicalCoordinateAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalCoordinateAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalCoordinateAddRadioItem2(){

  }

  /**
   * 看取り介護加算に内部項目を追加します。
   */
  protected void addWatchCareRadioGroup(){

  }

  /**
   * 看取り介護加算モデルに内部項目を追加します。
   */
  protected void addWatchCareRadioGroupModel(){

    getWatchCareRadioItem1().setButtonIndex(1);

    getWatchCareRadioGroupModel().add(getWatchCareRadioItem1());

    getWatchCareRadioItem2().setButtonIndex(2);

    getWatchCareRadioGroupModel().add(getWatchCareRadioItem2());

    getWatchCareRadioItem3().setButtonIndex(3);

    getWatchCareRadioGroupModel().add(getWatchCareRadioItem3());

    getWatchCareRadioItem4().setButtonIndex(4);

    getWatchCareRadioGroupModel().add(getWatchCareRadioItem4());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addWatchCareRadioItem1(){

  }

  /**
   * 死亡日以前4日以上30日以下に内部項目を追加します。
   */
  protected void addWatchCareRadioItem2(){

  }

  /**
   * 死亡日以前2日又は3日に内部項目を追加します。
   */
  protected void addWatchCareRadioItem3(){

  }

  /**
   * 死亡日に内部項目を追加します。
   */
  protected void addWatchCareRadioItem4(){

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

    getServiceAddProvisionStructuralRadioItem4().setButtonIndex(4);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem4());

    getServiceAddProvisionStructuralRadioItem5().setButtonIndex(5);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem5());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * Iイ型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * Iロ型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem3(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem4(){

  }

  /**
   * III型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem5(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_13611_201504Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_13611_201504Design getThis() {
    return this;
  }
}
