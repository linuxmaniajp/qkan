
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
 * 作成日: 2016/12/02  日本コンピューター株式会社 日高　しのぶ 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン通所型サービス(独自) (QS001_50611_201804)
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
 * サービスパターン通所型サービス(独自)画面項目デザイン(QS001_50611_201804) 
 */
public class QS001_50611_201804Design extends QS001ServicePanelSogo {
  //GUIコンポーネント

  private JTabbedPane preventiveExpertPlaceCareMultiPatterns;

  private ACPanel tab1;

  private ACLabelContainer insurerContainer;

  private ACComboBox insurerName;

  private ACComboBoxModelAdapter insurerNameModel;

  private ACComboBox servicePattern;

  private ACComboBoxModelAdapter servicePatternModel;

  private ACValueArrayRadioButtonGroup preventiveExpertPlaceCareServiceRadio;

  private ACLabelContainer preventiveExpertPlaceCareServiceRadioContainer;

  private ACListModelAdapter preventiveExpertPlaceCareServiceRadioModel;

  private ACRadioButtonItem preventiveExpertPlaceCareServiceRadioItem1;

  private ACRadioButtonItem preventiveExpertPlaceCareServiceRadioItem2;

  private ACIntegerCheckBox crackOnCntCheck;

  private ACIntegerCheckBox crackOnDayCheck;

  private ACIntegerCheckBox printable;

  private ACClearableRadioButtonGroup activityAddRadio;

  private ACLabelContainer activityAddRadioContainer;

  private ACListModelAdapter activityAddRadioModel;

  private ACRadioButtonItem activityAddRadioItem1;

  private ACRadioButtonItem activityAddRadioItem2;

  private ACValueArrayRadioButtonGroup moveFunctionImprovementAddRadio;

  private ACLabelContainer moveFunctionImprovementAddRadioContainer;

  private ACListModelAdapter moveFunctionImprovementAddRadioModel;

  private ACRadioButtonItem moveFunctionImprovementAddRadioItem1;

  private ACRadioButtonItem moveFunctionImprovementAddRadioItem2;

  private ACValueArrayRadioButtonGroup nourishmentImprovementAddRadio;

  private ACLabelContainer nourishmentImprovementAddRadioContainer;

  private ACListModelAdapter nourishmentImprovementAddRadioModel;

  private ACRadioButtonItem nourishmentImprovementAddRadioItem1;

  private ACRadioButtonItem nourishmentImprovementAddRadioItem2;

  private ACValueArrayRadioButtonGroup mouthFunctionImprovementAddRadio;

  private ACLabelContainer mouthFunctionImprovementAddRadioContainer;

  private ACListModelAdapter mouthFunctionImprovementAddRadioModel;

  private ACRadioButtonItem mouthFunctionImprovementAddRadioItem1;

  private ACRadioButtonItem mouthFunctionImprovementAddRadioItem2;

  private ACValueArrayRadioButtonGroup sentakutekiServiceRadio;

  private ACLabelContainer sentakutekiServiceRadioContainer;

  private ACListModelAdapter sentakutekiServiceRadioModel;

  private ACRadioButtonItem sentakutekiServiceRadioItem1;

  private ACRadioButtonItem sentakutekiServiceRadioItem2;

  private ACRadioButtonItem sentakutekiServiceRadioItem3;

  private ACRadioButtonItem sentakutekiServiceRadioItem4;

  private ACRadioButtonItem sentakutekiServiceRadioItem5;

  private ACBackLabelContainer houmonKaigoTimeContainer;

  private ACTimeComboBox houmonKaigoBeginTime;

  private ACLabelContainer houmonKaigoBeginTimeContainer;

  private ACComboBoxModelAdapter houmonKaigoBeginTimeModel;

  private ACTimeComboBox houmonKaigoEndTime;

  private ACLabelContainer houmonKaigoEndTimeContainer;

  private ACComboBoxModelAdapter houmonKaigoEndTimeModel;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACValueArrayRadioButtonGroup staffSubtractionRadio;

  private ACLabelContainer staffSubtractionRadioContainer;

  private ACListModelAdapter staffSubtractionRadioModel;

  private ACRadioButtonItem staffSubtractionRadioItem1;

  private ACRadioButtonItem staffSubtractionRadioItem2;

  private ACRadioButtonItem staffSubtractionRadioItem3;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACValueArrayRadioButtonGroup officeEvaluationAddRadio;

  private ACLabelContainer officeEvaluationAddRadioContainer;

  private ACListModelAdapter officeEvaluationAddRadioModel;

  private ACRadioButtonItem officeEvaluationAddRadioItem1;

  private ACRadioButtonItem officeEvaluationAddRadioItem2;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaRadioItem1;

  private ACRadioButtonItem providerAddMountainousAreaRadioItem2;

  private ACValueArrayRadioButtonGroup transportationCallRadioGroup;

  private ACLabelContainer transportationCallRadioGroupContainer;

  private ACListModelAdapter transportationCallRadioGroupModel;

  private ACRadioButtonItem transportationCallRadioItem1;

  private ACRadioButtonItem transportationCallRadioItem2;

  private ACValueArrayRadioButtonGroup calculationDivision;

  private ACLabelContainer calculationDivisionContainer;

  private ACListModelAdapter calculationDivisionModel;

  private ACRadioButtonItem calculationDivisionNormal;

  private ACRadioButtonItem calculationDivisionAddOnly;

  private ACPanel tab3;

  private ACGroupBox infoGroup;

  private ACLabel infoLabelPlan;

  //getter

  /**
   * 通所型サービス(独自)パターン領域を取得します。
   * @return 通所型サービス(独自)パターン領域
   */
  public JTabbedPane getPreventiveExpertPlaceCareMultiPatterns(){
    if(preventiveExpertPlaceCareMultiPatterns==null){

      preventiveExpertPlaceCareMultiPatterns = new JTabbedPane();

      addPreventiveExpertPlaceCareMultiPatterns();
    }
    return preventiveExpertPlaceCareMultiPatterns;

  }

  /**
   * タブ1を取得します。
   * @return タブ1
   */
  public ACPanel getTab1(){
    if(tab1==null){

      tab1 = new ACPanel();

      tab1.setFollowChildEnabled(true);

      tab1.setLabelMargin(0);

      tab1.setVgap(0);

      addTab1();
    }
    return tab1;

  }

  /**
   * 保険者コンテナを取得します。
   * @return 保険者コンテナ
   */
  public ACLabelContainer getInsurerContainer(){
    if(insurerContainer==null){

      insurerContainer = new ACLabelContainer();

      insurerContainer.setText("保険者名");

      insurerContainer.setFollowChildEnabled(true);

      addInsurerContainer();
    }
    return insurerContainer;

  }

  /**
   * 保険者名を取得します。
   * @return 保険者名
   */
  public ACComboBox getInsurerName(){
    if(insurerName==null){

      insurerName = new ACComboBox();

      insurerName.setBindPath("500");

      insurerName.setEditable(false);

      insurerName.setColumns(7);

      insurerName.setModelBindPath("INSURER");

      insurerName.setRenderBindPath("INSURER_NAME");

      insurerName.setModel(getInsurerNameModel());

      addInsurerName();
    }
    return insurerName;

  }

  /**
   * 保険者名モデルを取得します。
   * @return 保険者名モデル
   */
  protected ACComboBoxModelAdapter getInsurerNameModel(){
    if(insurerNameModel==null){
      insurerNameModel = new ACComboBoxModelAdapter();
      addInsurerNameModel();
    }
    return insurerNameModel;
  }

  /**
   * パターンを取得します。
   * @return パターン
   */
  public ACComboBox getServicePattern(){
    if(servicePattern==null){

      servicePattern = new ACComboBox();

      servicePattern.setBindPath("5060112");

      servicePattern.setEditable(false);

      servicePattern.setColumns(5);

      servicePattern.setModelBindPath("5060112");

      servicePattern.setRenderBindPath("CONTENT");

      servicePattern.setModel(getServicePatternModel());

      addServicePattern();
    }
    return servicePattern;

  }

  /**
   * パターンモデルを取得します。
   * @return パターンモデル
   */
  protected ACComboBoxModelAdapter getServicePatternModel(){
    if(servicePatternModel==null){
      servicePatternModel = new ACComboBoxModelAdapter();
      addServicePatternModel();
    }
    return servicePatternModel;
  }

  /**
   * 通所型サービス費を取得します。
   * @return 通所型サービス費
   */
  public ACValueArrayRadioButtonGroup getPreventiveExpertPlaceCareServiceRadio(){
    if(preventiveExpertPlaceCareServiceRadio==null){

      preventiveExpertPlaceCareServiceRadio = new ACValueArrayRadioButtonGroup();

      getPreventiveExpertPlaceCareServiceRadioContainer().setText("通所型サービス費");

      preventiveExpertPlaceCareServiceRadio.setBindPath("5060101");

      preventiveExpertPlaceCareServiceRadio.setUseClearButton(false);

      preventiveExpertPlaceCareServiceRadio.setModel(getPreventiveExpertPlaceCareServiceRadioModel());

      preventiveExpertPlaceCareServiceRadio.setValues(new int[]{1,2});

      addPreventiveExpertPlaceCareServiceRadio();
    }
    return preventiveExpertPlaceCareServiceRadio;

  }

  /**
   * 通所型サービス費コンテナを取得します。
   * @return 通所型サービス費コンテナ
   */
  protected ACLabelContainer getPreventiveExpertPlaceCareServiceRadioContainer(){
    if(preventiveExpertPlaceCareServiceRadioContainer==null){
      preventiveExpertPlaceCareServiceRadioContainer = new ACLabelContainer();
      preventiveExpertPlaceCareServiceRadioContainer.setFollowChildEnabled(true);
      preventiveExpertPlaceCareServiceRadioContainer.setVAlignment(VRLayout.CENTER);
      preventiveExpertPlaceCareServiceRadioContainer.add(getPreventiveExpertPlaceCareServiceRadio(), null);
    }
    return preventiveExpertPlaceCareServiceRadioContainer;
  }

  /**
   * 通所型サービス費モデルを取得します。
   * @return 通所型サービス費モデル
   */
  protected ACListModelAdapter getPreventiveExpertPlaceCareServiceRadioModel(){
    if(preventiveExpertPlaceCareServiceRadioModel==null){
      preventiveExpertPlaceCareServiceRadioModel = new ACListModelAdapter();
      addPreventiveExpertPlaceCareServiceRadioModel();
    }
    return preventiveExpertPlaceCareServiceRadioModel;
  }

  /**
   * １型を取得します。
   * @return １型
   */
  public ACRadioButtonItem getPreventiveExpertPlaceCareServiceRadioItem1(){
    if(preventiveExpertPlaceCareServiceRadioItem1==null){

      preventiveExpertPlaceCareServiceRadioItem1 = new ACRadioButtonItem();

      preventiveExpertPlaceCareServiceRadioItem1.setText("１型");

      preventiveExpertPlaceCareServiceRadioItem1.setGroup(getPreventiveExpertPlaceCareServiceRadio());

      preventiveExpertPlaceCareServiceRadioItem1.setConstraints(VRLayout.FLOW);

      addPreventiveExpertPlaceCareServiceRadioItem1();
    }
    return preventiveExpertPlaceCareServiceRadioItem1;

  }

  /**
   * ２型を取得します。
   * @return ２型
   */
  public ACRadioButtonItem getPreventiveExpertPlaceCareServiceRadioItem2(){
    if(preventiveExpertPlaceCareServiceRadioItem2==null){

      preventiveExpertPlaceCareServiceRadioItem2 = new ACRadioButtonItem();

      preventiveExpertPlaceCareServiceRadioItem2.setText("２型");

      preventiveExpertPlaceCareServiceRadioItem2.setGroup(getPreventiveExpertPlaceCareServiceRadio());

      preventiveExpertPlaceCareServiceRadioItem2.setConstraints(VRLayout.FLOW);

      addPreventiveExpertPlaceCareServiceRadioItem2();
    }
    return preventiveExpertPlaceCareServiceRadioItem2;

  }

  /**
   * 回数を取得します。
   * @return 回数
   */
  public ACIntegerCheckBox getCrackOnCntCheck(){
    if(crackOnCntCheck==null){

      crackOnCntCheck = new ACIntegerCheckBox();

      crackOnCntCheck.setText("回数");

      crackOnCntCheck.setBindPath("5060102");

      crackOnCntCheck.setSelectValue(2);

      crackOnCntCheck.setUnSelectValue(1);

      addCrackOnCntCheck();
    }
    return crackOnCntCheck;

  }

  /**
   * 日割を取得します。
   * @return 日割
   */
  public ACIntegerCheckBox getCrackOnDayCheck(){
    if(crackOnDayCheck==null){

      crackOnDayCheck = new ACIntegerCheckBox();

      crackOnDayCheck.setText("日割");

      crackOnDayCheck.setBindPath("5060104");

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
   * 生活機能向上グループ活動加算を取得します。
   * @return 生活機能向上グループ活動加算
   */
  public ACClearableRadioButtonGroup getActivityAddRadio(){
    if(activityAddRadio==null){

      activityAddRadio = new ACClearableRadioButtonGroup();

      getActivityAddRadioContainer().setText("生活機能向上グループ活動加算");

      activityAddRadio.setBindPath("5060105");

      activityAddRadio.setUseClearButton(false);

      activityAddRadio.setModel(getActivityAddRadioModel());

      addActivityAddRadio();
    }
    return activityAddRadio;

  }

  /**
   * 生活機能向上グループ活動加算コンテナを取得します。
   * @return 生活機能向上グループ活動加算コンテナ
   */
  protected ACLabelContainer getActivityAddRadioContainer(){
    if(activityAddRadioContainer==null){
      activityAddRadioContainer = new ACLabelContainer();
      activityAddRadioContainer.setFollowChildEnabled(true);
      activityAddRadioContainer.setVAlignment(VRLayout.CENTER);
      activityAddRadioContainer.add(getActivityAddRadio(), null);
    }
    return activityAddRadioContainer;
  }

  /**
   * 生活機能向上グループ活動加算モデルを取得します。
   * @return 生活機能向上グループ活動加算モデル
   */
  protected ACListModelAdapter getActivityAddRadioModel(){
    if(activityAddRadioModel==null){
      activityAddRadioModel = new ACListModelAdapter();
      addActivityAddRadioModel();
    }
    return activityAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getActivityAddRadioItem1(){
    if(activityAddRadioItem1==null){

      activityAddRadioItem1 = new ACRadioButtonItem();

      activityAddRadioItem1.setText("なし");

      activityAddRadioItem1.setGroup(getActivityAddRadio());

      activityAddRadioItem1.setConstraints(VRLayout.FLOW);

      addActivityAddRadioItem1();
    }
    return activityAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getActivityAddRadioItem2(){
    if(activityAddRadioItem2==null){

      activityAddRadioItem2 = new ACRadioButtonItem();

      activityAddRadioItem2.setText("あり");

      activityAddRadioItem2.setGroup(getActivityAddRadio());

      activityAddRadioItem2.setConstraints(VRLayout.FLOW);

      addActivityAddRadioItem2();
    }
    return activityAddRadioItem2;

  }

  /**
   * 運動器機能向上加算を取得します。
   * @return 運動器機能向上加算
   */
  public ACValueArrayRadioButtonGroup getMoveFunctionImprovementAddRadio(){
    if(moveFunctionImprovementAddRadio==null){

      moveFunctionImprovementAddRadio = new ACValueArrayRadioButtonGroup();

      getMoveFunctionImprovementAddRadioContainer().setText("運動器機能向上加算");

      moveFunctionImprovementAddRadio.setBindPath("5060106");

      moveFunctionImprovementAddRadio.setUseClearButton(false);

      moveFunctionImprovementAddRadio.setModel(getMoveFunctionImprovementAddRadioModel());

      moveFunctionImprovementAddRadio.setValues(new int[]{1,2});

      addMoveFunctionImprovementAddRadio();
    }
    return moveFunctionImprovementAddRadio;

  }

  /**
   * 運動器機能向上加算コンテナを取得します。
   * @return 運動器機能向上加算コンテナ
   */
  protected ACLabelContainer getMoveFunctionImprovementAddRadioContainer(){
    if(moveFunctionImprovementAddRadioContainer==null){
      moveFunctionImprovementAddRadioContainer = new ACLabelContainer();
      moveFunctionImprovementAddRadioContainer.setFollowChildEnabled(true);
      moveFunctionImprovementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      moveFunctionImprovementAddRadioContainer.add(getMoveFunctionImprovementAddRadio(), null);
    }
    return moveFunctionImprovementAddRadioContainer;
  }

  /**
   * 運動器機能向上加算モデルを取得します。
   * @return 運動器機能向上加算モデル
   */
  protected ACListModelAdapter getMoveFunctionImprovementAddRadioModel(){
    if(moveFunctionImprovementAddRadioModel==null){
      moveFunctionImprovementAddRadioModel = new ACListModelAdapter();
      addMoveFunctionImprovementAddRadioModel();
    }
    return moveFunctionImprovementAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMoveFunctionImprovementAddRadioItem1(){
    if(moveFunctionImprovementAddRadioItem1==null){

      moveFunctionImprovementAddRadioItem1 = new ACRadioButtonItem();

      moveFunctionImprovementAddRadioItem1.setText("なし");

      moveFunctionImprovementAddRadioItem1.setGroup(getMoveFunctionImprovementAddRadio());

      moveFunctionImprovementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addMoveFunctionImprovementAddRadioItem1();
    }
    return moveFunctionImprovementAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMoveFunctionImprovementAddRadioItem2(){
    if(moveFunctionImprovementAddRadioItem2==null){

      moveFunctionImprovementAddRadioItem2 = new ACRadioButtonItem();

      moveFunctionImprovementAddRadioItem2.setText("あり");

      moveFunctionImprovementAddRadioItem2.setGroup(getMoveFunctionImprovementAddRadio());

      moveFunctionImprovementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addMoveFunctionImprovementAddRadioItem2();
    }
    return moveFunctionImprovementAddRadioItem2;

  }

  /**
   * 栄養改善加算を取得します。
   * @return 栄養改善加算
   */
  public ACValueArrayRadioButtonGroup getNourishmentImprovementAddRadio(){
    if(nourishmentImprovementAddRadio==null){

      nourishmentImprovementAddRadio = new ACValueArrayRadioButtonGroup();

      getNourishmentImprovementAddRadioContainer().setText("栄養改善加算");

      nourishmentImprovementAddRadio.setBindPath("5060107");

      nourishmentImprovementAddRadio.setUseClearButton(false);

      nourishmentImprovementAddRadio.setModel(getNourishmentImprovementAddRadioModel());

      nourishmentImprovementAddRadio.setValues(new int[]{1,2});

      addNourishmentImprovementAddRadio();
    }
    return nourishmentImprovementAddRadio;

  }

  /**
   * 栄養改善加算コンテナを取得します。
   * @return 栄養改善加算コンテナ
   */
  protected ACLabelContainer getNourishmentImprovementAddRadioContainer(){
    if(nourishmentImprovementAddRadioContainer==null){
      nourishmentImprovementAddRadioContainer = new ACLabelContainer();
      nourishmentImprovementAddRadioContainer.setFollowChildEnabled(true);
      nourishmentImprovementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      nourishmentImprovementAddRadioContainer.add(getNourishmentImprovementAddRadio(), null);
    }
    return nourishmentImprovementAddRadioContainer;
  }

  /**
   * 栄養改善加算モデルを取得します。
   * @return 栄養改善加算モデル
   */
  protected ACListModelAdapter getNourishmentImprovementAddRadioModel(){
    if(nourishmentImprovementAddRadioModel==null){
      nourishmentImprovementAddRadioModel = new ACListModelAdapter();
      addNourishmentImprovementAddRadioModel();
    }
    return nourishmentImprovementAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNourishmentImprovementAddRadioItem1(){
    if(nourishmentImprovementAddRadioItem1==null){

      nourishmentImprovementAddRadioItem1 = new ACRadioButtonItem();

      nourishmentImprovementAddRadioItem1.setText("なし");

      nourishmentImprovementAddRadioItem1.setGroup(getNourishmentImprovementAddRadio());

      nourishmentImprovementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addNourishmentImprovementAddRadioItem1();
    }
    return nourishmentImprovementAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getNourishmentImprovementAddRadioItem2(){
    if(nourishmentImprovementAddRadioItem2==null){

      nourishmentImprovementAddRadioItem2 = new ACRadioButtonItem();

      nourishmentImprovementAddRadioItem2.setText("あり");

      nourishmentImprovementAddRadioItem2.setGroup(getNourishmentImprovementAddRadio());

      nourishmentImprovementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addNourishmentImprovementAddRadioItem2();
    }
    return nourishmentImprovementAddRadioItem2;

  }

  /**
   * 口腔機能向上加算を取得します。
   * @return 口腔機能向上加算
   */
  public ACValueArrayRadioButtonGroup getMouthFunctionImprovementAddRadio(){
    if(mouthFunctionImprovementAddRadio==null){

      mouthFunctionImprovementAddRadio = new ACValueArrayRadioButtonGroup();

      getMouthFunctionImprovementAddRadioContainer().setText("口腔機能向上加算");

      mouthFunctionImprovementAddRadio.setBindPath("5060108");

      mouthFunctionImprovementAddRadio.setUseClearButton(false);

      mouthFunctionImprovementAddRadio.setModel(getMouthFunctionImprovementAddRadioModel());

      mouthFunctionImprovementAddRadio.setValues(new int[]{1,2});

      addMouthFunctionImprovementAddRadio();
    }
    return mouthFunctionImprovementAddRadio;

  }

  /**
   * 口腔機能向上加算コンテナを取得します。
   * @return 口腔機能向上加算コンテナ
   */
  protected ACLabelContainer getMouthFunctionImprovementAddRadioContainer(){
    if(mouthFunctionImprovementAddRadioContainer==null){
      mouthFunctionImprovementAddRadioContainer = new ACLabelContainer();
      mouthFunctionImprovementAddRadioContainer.setFollowChildEnabled(true);
      mouthFunctionImprovementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      mouthFunctionImprovementAddRadioContainer.add(getMouthFunctionImprovementAddRadio(), null);
    }
    return mouthFunctionImprovementAddRadioContainer;
  }

  /**
   * 口腔機能向上加算モデルを取得します。
   * @return 口腔機能向上加算モデル
   */
  protected ACListModelAdapter getMouthFunctionImprovementAddRadioModel(){
    if(mouthFunctionImprovementAddRadioModel==null){
      mouthFunctionImprovementAddRadioModel = new ACListModelAdapter();
      addMouthFunctionImprovementAddRadioModel();
    }
    return mouthFunctionImprovementAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMouthFunctionImprovementAddRadioItem1(){
    if(mouthFunctionImprovementAddRadioItem1==null){

      mouthFunctionImprovementAddRadioItem1 = new ACRadioButtonItem();

      mouthFunctionImprovementAddRadioItem1.setText("なし");

      mouthFunctionImprovementAddRadioItem1.setGroup(getMouthFunctionImprovementAddRadio());

      mouthFunctionImprovementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addMouthFunctionImprovementAddRadioItem1();
    }
    return mouthFunctionImprovementAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMouthFunctionImprovementAddRadioItem2(){
    if(mouthFunctionImprovementAddRadioItem2==null){

      mouthFunctionImprovementAddRadioItem2 = new ACRadioButtonItem();

      mouthFunctionImprovementAddRadioItem2.setText("あり");

      mouthFunctionImprovementAddRadioItem2.setGroup(getMouthFunctionImprovementAddRadio());

      mouthFunctionImprovementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addMouthFunctionImprovementAddRadioItem2();
    }
    return mouthFunctionImprovementAddRadioItem2;

  }

  /**
   * 選択的サービス複数実施加算を取得します。
   * @return 選択的サービス複数実施加算
   */
  public ACValueArrayRadioButtonGroup getSentakutekiServiceRadio(){
    if(sentakutekiServiceRadio==null){

      sentakutekiServiceRadio = new ACValueArrayRadioButtonGroup();

      getSentakutekiServiceRadioContainer().setText("選択的サービス" + ACConstants.LINE_SEPARATOR + "複数実施加算");

      sentakutekiServiceRadio.setBindPath("5060113");

      sentakutekiServiceRadio.setUseClearButton(false);

      sentakutekiServiceRadio.setModel(getSentakutekiServiceRadioModel());

      sentakutekiServiceRadio.setValues(new int[]{1,2,3,4,5});

      addSentakutekiServiceRadio();
    }
    return sentakutekiServiceRadio;

  }

  /**
   * 選択的サービス複数実施加算コンテナを取得します。
   * @return 選択的サービス複数実施加算コンテナ
   */
  protected ACLabelContainer getSentakutekiServiceRadioContainer(){
    if(sentakutekiServiceRadioContainer==null){
      sentakutekiServiceRadioContainer = new ACLabelContainer();
      sentakutekiServiceRadioContainer.setFollowChildEnabled(true);
      sentakutekiServiceRadioContainer.setVAlignment(VRLayout.CENTER);
      sentakutekiServiceRadioContainer.add(getSentakutekiServiceRadio(), null);
    }
    return sentakutekiServiceRadioContainer;
  }

  /**
   * 選択的サービス複数実施加算モデルを取得します。
   * @return 選択的サービス複数実施加算モデル
   */
  protected ACListModelAdapter getSentakutekiServiceRadioModel(){
    if(sentakutekiServiceRadioModel==null){
      sentakutekiServiceRadioModel = new ACListModelAdapter();
      addSentakutekiServiceRadioModel();
    }
    return sentakutekiServiceRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSentakutekiServiceRadioItem1(){
    if(sentakutekiServiceRadioItem1==null){

      sentakutekiServiceRadioItem1 = new ACRadioButtonItem();

      sentakutekiServiceRadioItem1.setText("なし");

      sentakutekiServiceRadioItem1.setGroup(getSentakutekiServiceRadio());

      sentakutekiServiceRadioItem1.setConstraints(VRLayout.FLOW);

      addSentakutekiServiceRadioItem1();
    }
    return sentakutekiServiceRadioItem1;

  }

  /**
   * I1を取得します。
   * @return I1
   */
  public ACRadioButtonItem getSentakutekiServiceRadioItem2(){
    if(sentakutekiServiceRadioItem2==null){

      sentakutekiServiceRadioItem2 = new ACRadioButtonItem();

      sentakutekiServiceRadioItem2.setText("I1");

      sentakutekiServiceRadioItem2.setGroup(getSentakutekiServiceRadio());

      sentakutekiServiceRadioItem2.setConstraints(VRLayout.FLOW);

      addSentakutekiServiceRadioItem2();
    }
    return sentakutekiServiceRadioItem2;

  }

  /**
   * I2を取得します。
   * @return I2
   */
  public ACRadioButtonItem getSentakutekiServiceRadioItem3(){
    if(sentakutekiServiceRadioItem3==null){

      sentakutekiServiceRadioItem3 = new ACRadioButtonItem();

      sentakutekiServiceRadioItem3.setText("I2");

      sentakutekiServiceRadioItem3.setGroup(getSentakutekiServiceRadio());

      sentakutekiServiceRadioItem3.setConstraints(VRLayout.FLOW);

      addSentakutekiServiceRadioItem3();
    }
    return sentakutekiServiceRadioItem3;

  }

  /**
   * I3を取得します。
   * @return I3
   */
  public ACRadioButtonItem getSentakutekiServiceRadioItem4(){
    if(sentakutekiServiceRadioItem4==null){

      sentakutekiServiceRadioItem4 = new ACRadioButtonItem();

      sentakutekiServiceRadioItem4.setText("I3");

      sentakutekiServiceRadioItem4.setGroup(getSentakutekiServiceRadio());

      sentakutekiServiceRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addSentakutekiServiceRadioItem4();
    }
    return sentakutekiServiceRadioItem4;

  }

  /**
   * IIを取得します。
   * @return II
   */
  public ACRadioButtonItem getSentakutekiServiceRadioItem5(){
    if(sentakutekiServiceRadioItem5==null){

      sentakutekiServiceRadioItem5 = new ACRadioButtonItem();

      sentakutekiServiceRadioItem5.setText("II");

      sentakutekiServiceRadioItem5.setGroup(getSentakutekiServiceRadio());

      sentakutekiServiceRadioItem5.setConstraints(VRLayout.FLOW);

      addSentakutekiServiceRadioItem5();
    }
    return sentakutekiServiceRadioItem5;

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

      tab2.setLabelMargin(0);

      tab2.setVgap(0);

      addTab2();
    }
    return tab2;

  }

  /**
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("5060111");

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
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACValueArrayRadioButtonGroup getStaffSubtractionRadio(){
    if(staffSubtractionRadio==null){

      staffSubtractionRadio = new ACValueArrayRadioButtonGroup();

      getStaffSubtractionRadioContainer().setText("人員減算");

      staffSubtractionRadio.setBindPath("5060103");

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
   * 看護・介護職員が欠員を取得します。
   * @return 看護・介護職員が欠員
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
   * 若年性認知症利用者受入加算を取得します。
   * @return 若年性認知症利用者受入加算
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("若年性認知症利用者受入加算");

      youngDementiaPatinetAddRadioGroup.setBindPath("5060110");

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
   * 事業所評価加算を取得します。
   * @return 事業所評価加算
   */
  public ACValueArrayRadioButtonGroup getOfficeEvaluationAddRadio(){
    if(officeEvaluationAddRadio==null){

      officeEvaluationAddRadio = new ACValueArrayRadioButtonGroup();

      getOfficeEvaluationAddRadioContainer().setText("事業所評価加算");

      officeEvaluationAddRadio.setBindPath("5060109");

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
   * タブ3を取得します。
   * @return タブ3
   */
  public ACPanel getTab3(){
    if(tab3==null){

      tab3 = new ACPanel();

      tab3.setFollowChildEnabled(true);

      tab3.setHgap(0);

      tab3.setLabelMargin(0);

      tab3.setVgap(0);

      addTab3();
    }
    return tab3;

  }

  /**
   * 注意書きグループを取得します。
   * @return 注意書きグループ
   */
  public ACGroupBox getInfoGroup(){
    if(infoGroup==null){

      infoGroup = new ACGroupBox();

      infoGroup.setFollowChildEnabled(true);

      infoGroup.setHgap(0);

      infoGroup.setLabelMargin(0);

      infoGroup.setVgap(0);

      addInfoGroup();
    }
    return infoGroup;

  }

  /**
   * 注意書きラベルを取得します。
   * @return 注意書きラベル
   */
  public ACLabel getInfoLabelPlan(){
    if(infoLabelPlan==null){

      infoLabelPlan = new ACLabel();

      infoLabelPlan.setText("月途中で区分変更となる場合、" + ACConstants.LINE_SEPARATOR + "（要支援1⇔要支援2、事業対象者→要支援）" + ACConstants.LINE_SEPARATOR + "(1) 各日割りサービスを全ての日数に貼り付け、" + ACConstants.LINE_SEPARATOR + "実際の提供日には『提供日』のチェックをつけ" + ACConstants.LINE_SEPARATOR + "〔設定〕ボタンをクリックしてください。" + ACConstants.LINE_SEPARATOR + "(2) サービス提供体制加算の算定は、まず全ての日数で" + ACConstants.LINE_SEPARATOR + "加算「なし」と貼り付け、次に月初(1日)のサービスを" + ACConstants.LINE_SEPARATOR + "クリック、加算(1型／2型）にチェックをつけ、" + ACConstants.LINE_SEPARATOR + "〔設定〕ボタンをクリックしてください。");

      addInfoLabelPlan();
    }
    return infoLabelPlan;

  }

  /**
   * コンストラクタです。
   */
  public QS001_50611_201804Design() {

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

    this.add(getPreventiveExpertPlaceCareMultiPatterns(), VRLayout.CLIENT);

  }

  /**
   * 通所型サービス(独自)パターン領域に内部項目を追加します。
   */
  protected void addPreventiveExpertPlaceCareMultiPatterns(){

    preventiveExpertPlaceCareMultiPatterns.addTab("1", getTab1());

    preventiveExpertPlaceCareMultiPatterns.addTab("2", getTab2());

    preventiveExpertPlaceCareMultiPatterns.addTab("3", getTab3());

  }

  /**
   * タブ1に内部項目を追加します。
   */
  protected void addTab1(){

    tab1.add(getInsurerContainer(), VRLayout.FLOW_RETURN);

    tab1.add(getPreventiveExpertPlaceCareServiceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getCrackOnCntCheck(), VRLayout.FLOW);

    tab1.add(getCrackOnDayCheck(), VRLayout.FLOW);

    tab1.add(getPrintable(), VRLayout.FLOW_RETURN);

    tab1.add(getActivityAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMoveFunctionImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getNourishmentImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMouthFunctionImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getSentakutekiServiceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKaigoTimeContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * 保険者コンテナに内部項目を追加します。
   */
  protected void addInsurerContainer(){

    insurerContainer.add(getInsurerName(), VRLayout.FLOW);

    insurerContainer.add(getServicePattern(), VRLayout.FLOW);

  }

  /**
   * 保険者名に内部項目を追加します。
   */
  protected void addInsurerName(){

  }

  /**
   * 保険者名モデルに内部項目を追加します。
   */
  protected void addInsurerNameModel(){

  }

  /**
   * パターンに内部項目を追加します。
   */
  protected void addServicePattern(){

  }

  /**
   * パターンモデルに内部項目を追加します。
   */
  protected void addServicePatternModel(){

  }

  /**
   * 通所型サービス費に内部項目を追加します。
   */
  protected void addPreventiveExpertPlaceCareServiceRadio(){

  }

  /**
   * 通所型サービス費モデルに内部項目を追加します。
   */
  protected void addPreventiveExpertPlaceCareServiceRadioModel(){

    getPreventiveExpertPlaceCareServiceRadioItem1().setButtonIndex(1);

    getPreventiveExpertPlaceCareServiceRadioModel().add(getPreventiveExpertPlaceCareServiceRadioItem1());

    getPreventiveExpertPlaceCareServiceRadioItem2().setButtonIndex(2);

    getPreventiveExpertPlaceCareServiceRadioModel().add(getPreventiveExpertPlaceCareServiceRadioItem2());

  }

  /**
   * １型に内部項目を追加します。
   */
  protected void addPreventiveExpertPlaceCareServiceRadioItem1(){

  }

  /**
   * ２型に内部項目を追加します。
   */
  protected void addPreventiveExpertPlaceCareServiceRadioItem2(){

  }

  /**
   * 回数に内部項目を追加します。
   */
  protected void addCrackOnCntCheck(){

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
   * 生活機能向上グループ活動加算に内部項目を追加します。
   */
  protected void addActivityAddRadio(){

  }

  /**
   * 生活機能向上グループ活動加算モデルに内部項目を追加します。
   */
  protected void addActivityAddRadioModel(){

    getActivityAddRadioItem1().setButtonIndex(1);

    getActivityAddRadioModel().add(getActivityAddRadioItem1());

    getActivityAddRadioItem2().setButtonIndex(2);

    getActivityAddRadioModel().add(getActivityAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addActivityAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addActivityAddRadioItem2(){

  }

  /**
   * 運動器機能向上加算に内部項目を追加します。
   */
  protected void addMoveFunctionImprovementAddRadio(){

  }

  /**
   * 運動器機能向上加算モデルに内部項目を追加します。
   */
  protected void addMoveFunctionImprovementAddRadioModel(){

    getMoveFunctionImprovementAddRadioItem1().setButtonIndex(1);

    getMoveFunctionImprovementAddRadioModel().add(getMoveFunctionImprovementAddRadioItem1());

    getMoveFunctionImprovementAddRadioItem2().setButtonIndex(2);

    getMoveFunctionImprovementAddRadioModel().add(getMoveFunctionImprovementAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMoveFunctionImprovementAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMoveFunctionImprovementAddRadioItem2(){

  }

  /**
   * 栄養改善加算に内部項目を追加します。
   */
  protected void addNourishmentImprovementAddRadio(){

  }

  /**
   * 栄養改善加算モデルに内部項目を追加します。
   */
  protected void addNourishmentImprovementAddRadioModel(){

    getNourishmentImprovementAddRadioItem1().setButtonIndex(1);

    getNourishmentImprovementAddRadioModel().add(getNourishmentImprovementAddRadioItem1());

    getNourishmentImprovementAddRadioItem2().setButtonIndex(2);

    getNourishmentImprovementAddRadioModel().add(getNourishmentImprovementAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNourishmentImprovementAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addNourishmentImprovementAddRadioItem2(){

  }

  /**
   * 口腔機能向上加算に内部項目を追加します。
   */
  protected void addMouthFunctionImprovementAddRadio(){

  }

  /**
   * 口腔機能向上加算モデルに内部項目を追加します。
   */
  protected void addMouthFunctionImprovementAddRadioModel(){

    getMouthFunctionImprovementAddRadioItem1().setButtonIndex(1);

    getMouthFunctionImprovementAddRadioModel().add(getMouthFunctionImprovementAddRadioItem1());

    getMouthFunctionImprovementAddRadioItem2().setButtonIndex(2);

    getMouthFunctionImprovementAddRadioModel().add(getMouthFunctionImprovementAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMouthFunctionImprovementAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMouthFunctionImprovementAddRadioItem2(){

  }

  /**
   * 選択的サービス複数実施加算に内部項目を追加します。
   */
  protected void addSentakutekiServiceRadio(){

  }

  /**
   * 選択的サービス複数実施加算モデルに内部項目を追加します。
   */
  protected void addSentakutekiServiceRadioModel(){

    getSentakutekiServiceRadioItem1().setButtonIndex(1);

    getSentakutekiServiceRadioModel().add(getSentakutekiServiceRadioItem1());

    getSentakutekiServiceRadioItem2().setButtonIndex(2);

    getSentakutekiServiceRadioModel().add(getSentakutekiServiceRadioItem2());

    getSentakutekiServiceRadioItem3().setButtonIndex(3);

    getSentakutekiServiceRadioModel().add(getSentakutekiServiceRadioItem3());

    getSentakutekiServiceRadioItem4().setButtonIndex(4);

    getSentakutekiServiceRadioModel().add(getSentakutekiServiceRadioItem4());

    getSentakutekiServiceRadioItem5().setButtonIndex(5);

    getSentakutekiServiceRadioModel().add(getSentakutekiServiceRadioItem5());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSentakutekiServiceRadioItem1(){

  }

  /**
   * I1に内部項目を追加します。
   */
  protected void addSentakutekiServiceRadioItem2(){

  }

  /**
   * I2に内部項目を追加します。
   */
  protected void addSentakutekiServiceRadioItem3(){

  }

  /**
   * I3に内部項目を追加します。
   */
  protected void addSentakutekiServiceRadioItem4(){

  }

  /**
   * IIに内部項目を追加します。
   */
  protected void addSentakutekiServiceRadioItem5(){

  }

  /**
   * 提供時間コンテナに内部項目を追加します。
   */
  protected void addHoumonKaigoTimeContainer(){

    houmonKaigoTimeContainer.add(getHoumonKaigoBeginTimeContainer(), VRLayout.FLOW);

    houmonKaigoTimeContainer.add(getHoumonKaigoEndTimeContainer(), VRLayout.FLOW_RETURN);

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

    tab2.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getStaffSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getOfficeEvaluationAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getProviderAddMountainousAreaRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getTransportationCallRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getCalculationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * 看護・介護職員が欠員に内部項目を追加します。
   */
  protected void addStaffSubtractionRadioItem3(){

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
   * タブ3に内部項目を追加します。
   */
  protected void addTab3(){

    tab3.add(getInfoGroup(), VRLayout.FLOW);

  }

  /**
   * 注意書きグループに内部項目を追加します。
   */
  protected void addInfoGroup(){

    infoGroup.add(getInfoLabelPlan(), VRLayout.FLOW);

  }

  /**
   * 注意書きラベルに内部項目を追加します。
   */
  protected void addInfoLabelPlan(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_50611_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_50611_201804Design getThis() {
    return this;
  }
}
