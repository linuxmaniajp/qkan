
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
 * 作成日: 2018/03/02  日本コンピューター株式会社 日高　しのぶ 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン介護予防訪問リハビリテーション (QS001_16411_201804)
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
 * サービスパターン介護予防訪問リハビリテーション画面項目デザイン(QS001_16411_201804) 
 */
public class QS001_16411_201804Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel houmonRehabilitationPatterns;

  private ACValueArrayRadioButtonGroup houmonRehabilitationFacilityDivision;

  private ACLabelContainer houmonRehabilitationFacilityDivisionContainer;

  private ACListModelAdapter houmonRehabilitationFacilityDivisionModel;

  private ACRadioButtonItem houmonRehabilitationClassDouble;

  private ACRadioButtonItem houmonRehabilitationClassSingle;

  private ACRadioButtonItem houmonRehabilitationClassIryo;

  private ACValueArrayRadioButtonGroup houmonNeededRadio;

  private ACLabelContainer houmonNeededRadioContainer;

  private ACListModelAdapter houmonNeededRadioModel;

  private ACRadioButtonItem houmonNeededRadioItem1;

  private ACRadioButtonItem houmonNeededRadioItem2;

  private ACRadioButtonItem houmonNeededRadioItem3;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaItem1;

  private ACRadioButtonItem providerAddMountainousAreaItem2;

  private ACValueArrayRadioButtonGroup houmonRehabiliShortConcentrationAddRadio;

  private ACLabelContainer houmonRehabiliShortConcentrationAddRadioContainer;

  private ACListModelAdapter houmonRehabiliShortConcentrationAddRadioModel;

  private ACRadioButtonItem houmonRehabiliShortConcentrationAddRadioItem1;

  private ACRadioButtonItem houmonRehabiliShortConcentrationAddRadioItem2;

  private ACValueArrayRadioButtonGroup houmonRehabilitationManagementAddRadio;

  private ACLabelContainer houmonRehabilitationManagementAddRadioContainer;

  private ACListModelAdapter houmonRehabilitationManagementAddRadioModel;

  private ACRadioButtonItem houmonRehabilitationManagementAddRadioItem1;

  private ACRadioButtonItem houmonRehabilitationManagementAddRadioItem2;

  private ACValueArrayRadioButtonGroup plannedUnexecutedSubRadioGroup;

  private ACLabelContainer plannedUnexecutedSubRadioGroupContainer;

  private ACListModelAdapter plannedUnexecutedSubRadioGroupModel;

  private ACRadioButtonItem plannedUnexecutedSubRadioItem1;

  private ACRadioButtonItem plannedUnexecutedSubRadioItem2;

  private ACValueArrayRadioButtonGroup officeEvaluationAddRadio;

  private ACLabelContainer officeEvaluationAddRadioContainer;

  private ACListModelAdapter officeEvaluationAddRadioModel;

  private ACRadioButtonItem officeEvaluationAddRadioItem1;

  private ACRadioButtonItem officeEvaluationAddRadioItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACBackLabelContainer houmonRehabilitationTimeContena;

  private ACTimeComboBox houmonRehabilitationBeginTime;

  private ACLabelContainer houmonRehabilitationBeginTimeContainer;

  private ACComboBoxModelAdapter houmonRehabilitationBeginTimeModel;

  private ACTimeComboBox houmonRehabilitationEndTime;

  private ACLabelContainer houmonRehabilitationEndTimeContainer;

  private ACComboBoxModelAdapter houmonRehabilitationEndTimeModel;

  //getter

  /**
   * 訪問リハビリテーションパターン領域を取得します。
   * @return 訪問リハビリテーションパターン領域
   */
  public ACPanel getHoumonRehabilitationPatterns(){
    if(houmonRehabilitationPatterns==null){

      houmonRehabilitationPatterns = new ACPanel();

      houmonRehabilitationPatterns.setFollowChildEnabled(true);

      addHoumonRehabilitationPatterns();
    }
    return houmonRehabilitationPatterns;

  }

  /**
   * 施設等の区分を取得します。
   * @return 施設等の区分
   */
  public ACValueArrayRadioButtonGroup getHoumonRehabilitationFacilityDivision(){
    if(houmonRehabilitationFacilityDivision==null){

      houmonRehabilitationFacilityDivision = new ACValueArrayRadioButtonGroup();

      getHoumonRehabilitationFacilityDivisionContainer().setText("施設等の区分");

      houmonRehabilitationFacilityDivision.setBindPath("1640101");

      houmonRehabilitationFacilityDivision.setUseClearButton(false);

      houmonRehabilitationFacilityDivision.setModel(getHoumonRehabilitationFacilityDivisionModel());

      houmonRehabilitationFacilityDivision.setValues(new int[]{1,2,3});

      addHoumonRehabilitationFacilityDivision();
    }
    return houmonRehabilitationFacilityDivision;

  }

  /**
   * 施設等の区分コンテナを取得します。
   * @return 施設等の区分コンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationFacilityDivisionContainer(){
    if(houmonRehabilitationFacilityDivisionContainer==null){
      houmonRehabilitationFacilityDivisionContainer = new ACLabelContainer();
      houmonRehabilitationFacilityDivisionContainer.setFollowChildEnabled(true);
      houmonRehabilitationFacilityDivisionContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationFacilityDivisionContainer.add(getHoumonRehabilitationFacilityDivision(), null);
    }
    return houmonRehabilitationFacilityDivisionContainer;
  }

  /**
   * 施設等の区分モデルを取得します。
   * @return 施設等の区分モデル
   */
  protected ACListModelAdapter getHoumonRehabilitationFacilityDivisionModel(){
    if(houmonRehabilitationFacilityDivisionModel==null){
      houmonRehabilitationFacilityDivisionModel = new ACListModelAdapter();
      addHoumonRehabilitationFacilityDivisionModel();
    }
    return houmonRehabilitationFacilityDivisionModel;
  }

  /**
   * 病院または診療所を取得します。
   * @return 病院または診療所
   */
  public ACRadioButtonItem getHoumonRehabilitationClassDouble(){
    if(houmonRehabilitationClassDouble==null){

      houmonRehabilitationClassDouble = new ACRadioButtonItem();

      houmonRehabilitationClassDouble.setText("病院又は診療所");

      houmonRehabilitationClassDouble.setGroup(getHoumonRehabilitationFacilityDivision());

      houmonRehabilitationClassDouble.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabilitationClassDouble();
    }
    return houmonRehabilitationClassDouble;

  }

  /**
   * 介護老人保健施設を取得します。
   * @return 介護老人保健施設
   */
  public ACRadioButtonItem getHoumonRehabilitationClassSingle(){
    if(houmonRehabilitationClassSingle==null){

      houmonRehabilitationClassSingle = new ACRadioButtonItem();

      houmonRehabilitationClassSingle.setText("介護老人保健施設");

      houmonRehabilitationClassSingle.setGroup(getHoumonRehabilitationFacilityDivision());

      houmonRehabilitationClassSingle.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabilitationClassSingle();
    }
    return houmonRehabilitationClassSingle;

  }

  /**
   * 介護医療院を取得します。
   * @return 介護医療院
   */
  public ACRadioButtonItem getHoumonRehabilitationClassIryo(){
    if(houmonRehabilitationClassIryo==null){

      houmonRehabilitationClassIryo = new ACRadioButtonItem();

      houmonRehabilitationClassIryo.setText("介護医療院");

      houmonRehabilitationClassIryo.setGroup(getHoumonRehabilitationFacilityDivision());

      houmonRehabilitationClassIryo.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationClassIryo();
    }
    return houmonRehabilitationClassIryo;

  }

  /**
   * 同一建物減算を取得します。
   * @return 同一建物減算
   */
  public ACValueArrayRadioButtonGroup getHoumonNeededRadio(){
    if(houmonNeededRadio==null){

      houmonNeededRadio = new ACValueArrayRadioButtonGroup();

      getHoumonNeededRadioContainer().setText("同一建物減算");

      houmonNeededRadio.setBindPath("23");

      houmonNeededRadio.setNoSelectIndex(0);

      houmonNeededRadio.setUseClearButton(false);

      houmonNeededRadio.setModel(getHoumonNeededRadioModel());

      houmonNeededRadio.setValues(new int[]{1,2,3});

      addHoumonNeededRadio();
    }
    return houmonNeededRadio;

  }

  /**
   * 同一建物減算コンテナを取得します。
   * @return 同一建物減算コンテナ
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
   * 同一建物減算モデルを取得します。
   * @return 同一建物減算モデル
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
   * 20人以上を取得します。
   * @return 20人以上
   */
  public ACRadioButtonItem getHoumonNeededRadioItem2(){
    if(houmonNeededRadioItem2==null){

      houmonNeededRadioItem2 = new ACRadioButtonItem();

      houmonNeededRadioItem2.setText("20人以上");

      houmonNeededRadioItem2.setGroup(getHoumonNeededRadio());

      houmonNeededRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonNeededRadioItem2();
    }
    return houmonNeededRadioItem2;

  }

  /**
   * 50人以上を取得します。
   * @return 50人以上
   */
  public ACRadioButtonItem getHoumonNeededRadioItem3(){
    if(houmonNeededRadioItem3==null){

      houmonNeededRadioItem3 = new ACRadioButtonItem();

      houmonNeededRadioItem3.setText("50人以上");

      houmonNeededRadioItem3.setGroup(getHoumonNeededRadio());

      houmonNeededRadioItem3.setConstraints(VRLayout.FLOW);

      addHoumonNeededRadioItem3();
    }
    return houmonNeededRadioItem3;

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
  public ACRadioButtonItem getProviderAddMountainousAreaItem1(){
    if(providerAddMountainousAreaItem1==null){

      providerAddMountainousAreaItem1 = new ACRadioButtonItem();

      providerAddMountainousAreaItem1.setText("なし");

      providerAddMountainousAreaItem1.setGroup(getProviderAddMountainousAreaRadioGroup());

      providerAddMountainousAreaItem1.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaItem1();
    }
    return providerAddMountainousAreaItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getProviderAddMountainousAreaItem2(){
    if(providerAddMountainousAreaItem2==null){

      providerAddMountainousAreaItem2 = new ACRadioButtonItem();

      providerAddMountainousAreaItem2.setText("あり");

      providerAddMountainousAreaItem2.setGroup(getProviderAddMountainousAreaRadioGroup());

      providerAddMountainousAreaItem2.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaItem2();
    }
    return providerAddMountainousAreaItem2;

  }

  /**
   * 短期集中リハビリ実施加算を取得します。
   * @return 短期集中リハビリ実施加算
   */
  public ACValueArrayRadioButtonGroup getHoumonRehabiliShortConcentrationAddRadio(){
    if(houmonRehabiliShortConcentrationAddRadio==null){

      houmonRehabiliShortConcentrationAddRadio = new ACValueArrayRadioButtonGroup();

      getHoumonRehabiliShortConcentrationAddRadioContainer().setText("短期集中リハビリ実施加算");

      houmonRehabiliShortConcentrationAddRadio.setBindPath("1640103");

      houmonRehabiliShortConcentrationAddRadio.setUseClearButton(false);

      houmonRehabiliShortConcentrationAddRadio.setModel(getHoumonRehabiliShortConcentrationAddRadioModel());

      houmonRehabiliShortConcentrationAddRadio.setValues(new int[]{1,2});

      addHoumonRehabiliShortConcentrationAddRadio();
    }
    return houmonRehabiliShortConcentrationAddRadio;

  }

  /**
   * 短期集中リハビリ実施加算コンテナを取得します。
   * @return 短期集中リハビリ実施加算コンテナ
   */
  protected ACLabelContainer getHoumonRehabiliShortConcentrationAddRadioContainer(){
    if(houmonRehabiliShortConcentrationAddRadioContainer==null){
      houmonRehabiliShortConcentrationAddRadioContainer = new ACLabelContainer();
      houmonRehabiliShortConcentrationAddRadioContainer.setFollowChildEnabled(true);
      houmonRehabiliShortConcentrationAddRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabiliShortConcentrationAddRadioContainer.add(getHoumonRehabiliShortConcentrationAddRadio(), null);
    }
    return houmonRehabiliShortConcentrationAddRadioContainer;
  }

  /**
   * 短期集中リハビリ実施加算モデルを取得します。
   * @return 短期集中リハビリ実施加算モデル
   */
  protected ACListModelAdapter getHoumonRehabiliShortConcentrationAddRadioModel(){
    if(houmonRehabiliShortConcentrationAddRadioModel==null){
      houmonRehabiliShortConcentrationAddRadioModel = new ACListModelAdapter();
      addHoumonRehabiliShortConcentrationAddRadioModel();
    }
    return houmonRehabiliShortConcentrationAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonRehabiliShortConcentrationAddRadioItem1(){
    if(houmonRehabiliShortConcentrationAddRadioItem1==null){

      houmonRehabiliShortConcentrationAddRadioItem1 = new ACRadioButtonItem();

      houmonRehabiliShortConcentrationAddRadioItem1.setText("なし");

      houmonRehabiliShortConcentrationAddRadioItem1.setGroup(getHoumonRehabiliShortConcentrationAddRadio());

      houmonRehabiliShortConcentrationAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabiliShortConcentrationAddRadioItem1();
    }
    return houmonRehabiliShortConcentrationAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonRehabiliShortConcentrationAddRadioItem2(){
    if(houmonRehabiliShortConcentrationAddRadioItem2==null){

      houmonRehabiliShortConcentrationAddRadioItem2 = new ACRadioButtonItem();

      houmonRehabiliShortConcentrationAddRadioItem2.setText("あり");

      houmonRehabiliShortConcentrationAddRadioItem2.setGroup(getHoumonRehabiliShortConcentrationAddRadio());

      houmonRehabiliShortConcentrationAddRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabiliShortConcentrationAddRadioItem2();
    }
    return houmonRehabiliShortConcentrationAddRadioItem2;

  }

  /**
   * リハビリ・マネジメント加算を取得します。
   * @return リハビリ・マネジメント加算
   */
  public ACValueArrayRadioButtonGroup getHoumonRehabilitationManagementAddRadio(){
    if(houmonRehabilitationManagementAddRadio==null){

      houmonRehabilitationManagementAddRadio = new ACValueArrayRadioButtonGroup();

      getHoumonRehabilitationManagementAddRadioContainer().setText("リハビリ・マネジメント加算");

      houmonRehabilitationManagementAddRadio.setBindPath("1640102");

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
   * 計画診療未実施減算を取得します。
   * @return 計画診療未実施減算
   */
  public ACValueArrayRadioButtonGroup getPlannedUnexecutedSubRadioGroup(){
    if(plannedUnexecutedSubRadioGroup==null){

      plannedUnexecutedSubRadioGroup = new ACValueArrayRadioButtonGroup();

      getPlannedUnexecutedSubRadioGroupContainer().setText("計画診療未実施減算");

      plannedUnexecutedSubRadioGroup.setBindPath("1640107");

      plannedUnexecutedSubRadioGroup.setVisible(true);

      plannedUnexecutedSubRadioGroup.setEnabled(true);

      plannedUnexecutedSubRadioGroup.setNoSelectIndex(0);

      plannedUnexecutedSubRadioGroup.setUseClearButton(false);

      plannedUnexecutedSubRadioGroup.setModel(getPlannedUnexecutedSubRadioGroupModel());

      plannedUnexecutedSubRadioGroup.setValues(new int[]{1,2});

      addPlannedUnexecutedSubRadioGroup();
    }
    return plannedUnexecutedSubRadioGroup;

  }

  /**
   * 計画診療未実施減算コンテナを取得します。
   * @return 計画診療未実施減算コンテナ
   */
  protected ACLabelContainer getPlannedUnexecutedSubRadioGroupContainer(){
    if(plannedUnexecutedSubRadioGroupContainer==null){
      plannedUnexecutedSubRadioGroupContainer = new ACLabelContainer();
      plannedUnexecutedSubRadioGroupContainer.setFollowChildEnabled(true);
      plannedUnexecutedSubRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      plannedUnexecutedSubRadioGroupContainer.add(getPlannedUnexecutedSubRadioGroup(), null);
    }
    return plannedUnexecutedSubRadioGroupContainer;
  }

  /**
   * 計画診療未実施減算モデルを取得します。
   * @return 計画診療未実施減算モデル
   */
  protected ACListModelAdapter getPlannedUnexecutedSubRadioGroupModel(){
    if(plannedUnexecutedSubRadioGroupModel==null){
      plannedUnexecutedSubRadioGroupModel = new ACListModelAdapter();
      addPlannedUnexecutedSubRadioGroupModel();
    }
    return plannedUnexecutedSubRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getPlannedUnexecutedSubRadioItem1(){
    if(plannedUnexecutedSubRadioItem1==null){

      plannedUnexecutedSubRadioItem1 = new ACRadioButtonItem();

      plannedUnexecutedSubRadioItem1.setText("なし");

      plannedUnexecutedSubRadioItem1.setGroup(getPlannedUnexecutedSubRadioGroup());

      plannedUnexecutedSubRadioItem1.setConstraints(VRLayout.FLOW);

      addPlannedUnexecutedSubRadioItem1();
    }
    return plannedUnexecutedSubRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getPlannedUnexecutedSubRadioItem2(){
    if(plannedUnexecutedSubRadioItem2==null){

      plannedUnexecutedSubRadioItem2 = new ACRadioButtonItem();

      plannedUnexecutedSubRadioItem2.setText("あり");

      plannedUnexecutedSubRadioItem2.setGroup(getPlannedUnexecutedSubRadioGroup());

      plannedUnexecutedSubRadioItem2.setConstraints(VRLayout.FLOW);

      addPlannedUnexecutedSubRadioItem2();
    }
    return plannedUnexecutedSubRadioItem2;

  }

  /**
   * 事業所評価加算を取得します。
   * @return 事業所評価加算
   */
  public ACValueArrayRadioButtonGroup getOfficeEvaluationAddRadio(){
    if(officeEvaluationAddRadio==null){

      officeEvaluationAddRadio = new ACValueArrayRadioButtonGroup();

      getOfficeEvaluationAddRadioContainer().setText("事業所評価加算");

      officeEvaluationAddRadio.setBindPath("1640108");

      officeEvaluationAddRadio.setUseClearButton(false);

      officeEvaluationAddRadio.setModel(getOfficeEvaluationAddRadioModel());

      officeEvaluationAddRadio.setValues(new int[]{1,2});

      addOfficeEvaluationAddRadio();
    }
    return officeEvaluationAddRadio;

  }

  /**
   * 事業所評価加算コンテナを取得します。
   * @return 事業所評価加算コンテナ
   */
  protected ACLabelContainer getOfficeEvaluationAddRadioContainer(){
    if(officeEvaluationAddRadioContainer==null){
      officeEvaluationAddRadioContainer = new ACLabelContainer();
      officeEvaluationAddRadioContainer.setFollowChildEnabled(true);
      officeEvaluationAddRadioContainer.setVAlignment(VRLayout.CENTER);
      officeEvaluationAddRadioContainer.add(getOfficeEvaluationAddRadio(), null);
    }
    return officeEvaluationAddRadioContainer;
  }

  /**
   * 事業所評価加算モデルを取得します。
   * @return 事業所評価加算モデル
   */
  protected ACListModelAdapter getOfficeEvaluationAddRadioModel(){
    if(officeEvaluationAddRadioModel==null){
      officeEvaluationAddRadioModel = new ACListModelAdapter();
      addOfficeEvaluationAddRadioModel();
    }
    return officeEvaluationAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getOfficeEvaluationAddRadioItem1(){
    if(officeEvaluationAddRadioItem1==null){

      officeEvaluationAddRadioItem1 = new ACRadioButtonItem();

      officeEvaluationAddRadioItem1.setText("なし");

      officeEvaluationAddRadioItem1.setGroup(getOfficeEvaluationAddRadio());

      officeEvaluationAddRadioItem1.setConstraints(VRLayout.FLOW);

      addOfficeEvaluationAddRadioItem1();
    }
    return officeEvaluationAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getOfficeEvaluationAddRadioItem2(){
    if(officeEvaluationAddRadioItem2==null){

      officeEvaluationAddRadioItem2 = new ACRadioButtonItem();

      officeEvaluationAddRadioItem2.setText("あり");

      officeEvaluationAddRadioItem2.setGroup(getOfficeEvaluationAddRadio());

      officeEvaluationAddRadioItem2.setConstraints(VRLayout.FLOW);

      addOfficeEvaluationAddRadioItem2();
    }
    return officeEvaluationAddRadioItem2;

  }

  /**
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1640104");

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
   * 提供時間コンテナを取得します。
   * @return 提供時間コンテナ
   */
  public ACBackLabelContainer getHoumonRehabilitationTimeContena(){
    if(houmonRehabilitationTimeContena==null){

      houmonRehabilitationTimeContena = new ACBackLabelContainer();

      houmonRehabilitationTimeContena.setFollowChildEnabled(true);

      addHoumonRehabilitationTimeContena();
    }
    return houmonRehabilitationTimeContena;

  }

  /**
   * 開始時刻コンボを取得します。
   * @return 開始時刻コンボ
   */
  public ACTimeComboBox getHoumonRehabilitationBeginTime(){
    if(houmonRehabilitationBeginTime==null){

      houmonRehabilitationBeginTime = new ACTimeComboBox();

      getHoumonRehabilitationBeginTimeContainer().setText("開始時刻");

      houmonRehabilitationBeginTime.setBindPath("3");

      houmonRehabilitationBeginTime.setModelBindPath("3");

      houmonRehabilitationBeginTime.setRenderBindPath("CONTENT");

      houmonRehabilitationBeginTime.setModel(getHoumonRehabilitationBeginTimeModel());

      addHoumonRehabilitationBeginTime();
    }
    return houmonRehabilitationBeginTime;

  }

  /**
   * 開始時刻コンボコンテナを取得します。
   * @return 開始時刻コンボコンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationBeginTimeContainer(){
    if(houmonRehabilitationBeginTimeContainer==null){
      houmonRehabilitationBeginTimeContainer = new ACLabelContainer();
      houmonRehabilitationBeginTimeContainer.setFollowChildEnabled(true);
      houmonRehabilitationBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationBeginTimeContainer.add(getHoumonRehabilitationBeginTime(), null);
    }
    return houmonRehabilitationBeginTimeContainer;
  }

  /**
   * 開始時刻コンボモデルを取得します。
   * @return 開始時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getHoumonRehabilitationBeginTimeModel(){
    if(houmonRehabilitationBeginTimeModel==null){
      houmonRehabilitationBeginTimeModel = new ACComboBoxModelAdapter();
      addHoumonRehabilitationBeginTimeModel();
    }
    return houmonRehabilitationBeginTimeModel;
  }

  /**
   * 終了時刻コンボを取得します。
   * @return 終了時刻コンボ
   */
  public ACTimeComboBox getHoumonRehabilitationEndTime(){
    if(houmonRehabilitationEndTime==null){

      houmonRehabilitationEndTime = new ACTimeComboBox();

      getHoumonRehabilitationEndTimeContainer().setText("終了時刻");

      houmonRehabilitationEndTime.setBindPath("4");

      houmonRehabilitationEndTime.setModelBindPath("4");

      houmonRehabilitationEndTime.setRenderBindPath("CONTENT");

      houmonRehabilitationEndTime.setModel(getHoumonRehabilitationEndTimeModel());

      addHoumonRehabilitationEndTime();
    }
    return houmonRehabilitationEndTime;

  }

  /**
   * 終了時刻コンボコンテナを取得します。
   * @return 終了時刻コンボコンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationEndTimeContainer(){
    if(houmonRehabilitationEndTimeContainer==null){
      houmonRehabilitationEndTimeContainer = new ACLabelContainer();
      houmonRehabilitationEndTimeContainer.setFollowChildEnabled(true);
      houmonRehabilitationEndTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationEndTimeContainer.add(getHoumonRehabilitationEndTime(), null);
    }
    return houmonRehabilitationEndTimeContainer;
  }

  /**
   * 終了時刻コンボモデルを取得します。
   * @return 終了時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getHoumonRehabilitationEndTimeModel(){
    if(houmonRehabilitationEndTimeModel==null){
      houmonRehabilitationEndTimeModel = new ACComboBoxModelAdapter();
      addHoumonRehabilitationEndTimeModel();
    }
    return houmonRehabilitationEndTimeModel;
  }

  /**
   * コンストラクタです。
   */
  public QS001_16411_201804Design() {

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

    this.add(getHoumonRehabilitationPatterns(), VRLayout.CLIENT);

  }

  /**
   * 訪問リハビリテーションパターン領域に内部項目を追加します。
   */
  protected void addHoumonRehabilitationPatterns(){

    houmonRehabilitationPatterns.add(getHoumonRehabilitationFacilityDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonRehabilitationPatterns.add(getHoumonNeededRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonRehabilitationPatterns.add(getProviderAddMountainousAreaRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonRehabilitationPatterns.add(getHoumonRehabiliShortConcentrationAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonRehabilitationPatterns.add(getHoumonRehabilitationManagementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonRehabilitationPatterns.add(getPlannedUnexecutedSubRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonRehabilitationPatterns.add(getOfficeEvaluationAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonRehabilitationPatterns.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonRehabilitationPatterns.add(getHoumonRehabilitationTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * 施設等の区分に内部項目を追加します。
   */
  protected void addHoumonRehabilitationFacilityDivision(){

  }

  /**
   * 施設等の区分モデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationFacilityDivisionModel(){

    getHoumonRehabilitationClassDouble().setButtonIndex(1);

    getHoumonRehabilitationFacilityDivisionModel().add(getHoumonRehabilitationClassDouble());

    getHoumonRehabilitationClassSingle().setButtonIndex(2);

    getHoumonRehabilitationFacilityDivisionModel().add(getHoumonRehabilitationClassSingle());

    getHoumonRehabilitationClassIryo().setButtonIndex(3);

    getHoumonRehabilitationFacilityDivisionModel().add(getHoumonRehabilitationClassIryo());

  }

  /**
   * 病院または診療所に内部項目を追加します。
   */
  protected void addHoumonRehabilitationClassDouble(){

  }

  /**
   * 介護老人保健施設に内部項目を追加します。
   */
  protected void addHoumonRehabilitationClassSingle(){

  }

  /**
   * 介護医療院に内部項目を追加します。
   */
  protected void addHoumonRehabilitationClassIryo(){

  }

  /**
   * 同一建物減算に内部項目を追加します。
   */
  protected void addHoumonNeededRadio(){

  }

  /**
   * 同一建物減算モデルに内部項目を追加します。
   */
  protected void addHoumonNeededRadioModel(){

    getHoumonNeededRadioItem1().setButtonIndex(1);

    getHoumonNeededRadioModel().add(getHoumonNeededRadioItem1());

    getHoumonNeededRadioItem2().setButtonIndex(2);

    getHoumonNeededRadioModel().add(getHoumonNeededRadioItem2());

    getHoumonNeededRadioItem3().setButtonIndex(3);

    getHoumonNeededRadioModel().add(getHoumonNeededRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonNeededRadioItem1(){

  }

  /**
   * 20人以上に内部項目を追加します。
   */
  protected void addHoumonNeededRadioItem2(){

  }

  /**
   * 50人以上に内部項目を追加します。
   */
  protected void addHoumonNeededRadioItem3(){

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

    getProviderAddMountainousAreaItem1().setButtonIndex(1);

    getProviderAddMountainousAreaRadioGroupModel().add(getProviderAddMountainousAreaItem1());

    getProviderAddMountainousAreaItem2().setButtonIndex(2);

    getProviderAddMountainousAreaRadioGroupModel().add(getProviderAddMountainousAreaItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaItem2(){

  }

  /**
   * 短期集中リハビリ実施加算に内部項目を追加します。
   */
  protected void addHoumonRehabiliShortConcentrationAddRadio(){

  }

  /**
   * 短期集中リハビリ実施加算モデルに内部項目を追加します。
   */
  protected void addHoumonRehabiliShortConcentrationAddRadioModel(){

    getHoumonRehabiliShortConcentrationAddRadioItem1().setButtonIndex(1);

    getHoumonRehabiliShortConcentrationAddRadioModel().add(getHoumonRehabiliShortConcentrationAddRadioItem1());

    getHoumonRehabiliShortConcentrationAddRadioItem2().setButtonIndex(2);

    getHoumonRehabiliShortConcentrationAddRadioModel().add(getHoumonRehabiliShortConcentrationAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonRehabiliShortConcentrationAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonRehabiliShortConcentrationAddRadioItem2(){

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
   * 計画診療未実施減算に内部項目を追加します。
   */
  protected void addPlannedUnexecutedSubRadioGroup(){

  }

  /**
   * 計画診療未実施減算モデルに内部項目を追加します。
   */
  protected void addPlannedUnexecutedSubRadioGroupModel(){

    getPlannedUnexecutedSubRadioItem1().setButtonIndex(1);

    getPlannedUnexecutedSubRadioGroupModel().add(getPlannedUnexecutedSubRadioItem1());

    getPlannedUnexecutedSubRadioItem2().setButtonIndex(2);

    getPlannedUnexecutedSubRadioGroupModel().add(getPlannedUnexecutedSubRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addPlannedUnexecutedSubRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addPlannedUnexecutedSubRadioItem2(){

  }

  /**
   * 事業所評価加算に内部項目を追加します。
   */
  protected void addOfficeEvaluationAddRadio(){

  }

  /**
   * 事業所評価加算モデルに内部項目を追加します。
   */
  protected void addOfficeEvaluationAddRadioModel(){

    getOfficeEvaluationAddRadioItem1().setButtonIndex(1);

    getOfficeEvaluationAddRadioModel().add(getOfficeEvaluationAddRadioItem1());

    getOfficeEvaluationAddRadioItem2().setButtonIndex(2);

    getOfficeEvaluationAddRadioModel().add(getOfficeEvaluationAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addOfficeEvaluationAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addOfficeEvaluationAddRadioItem2(){

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
   * 提供時間コンテナに内部項目を追加します。
   */
  protected void addHoumonRehabilitationTimeContena(){

    houmonRehabilitationTimeContena.add(getHoumonRehabilitationBeginTimeContainer(), VRLayout.FLOW);

    houmonRehabilitationTimeContena.add(getHoumonRehabilitationEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * 開始時刻コンボに内部項目を追加します。
   */
  protected void addHoumonRehabilitationBeginTime(){

  }

  /**
   * 開始時刻コンボモデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationBeginTimeModel(){

  }

  /**
   * 終了時刻コンボに内部項目を追加します。
   */
  protected void addHoumonRehabilitationEndTime(){

  }

  /**
   * 終了時刻コンボモデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationEndTimeModel(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_16411_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_16411_201804Design getThis() {
    return this;
  }
}
