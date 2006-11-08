
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
 * プログラム サービスパターン介護予防通所介護 (QS001135)
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
 * サービスパターン介護予防通所介護画面項目デザイン(QS001135) 
 */
public class QS001135Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel preventiveExpertPlaceCareMultiPatterns;

  private ACClearableRadioButtonGroup staffSubtractionRadio;

  private ACLabelContainer staffSubtractionRadioContainer;

  private ACListModelAdapter staffSubtractionRadioModel;

  private ACRadioButtonItem staffSubtractionRadioItem1;

  private ACRadioButtonItem staffSubtractionRadioItem2;

  private ACRadioButtonItem staffSubtractionRadioItem3;

  private ACIntegerCheckBox crackOnDayCheck;

  private ACClearableRadioButtonGroup activityAddRadio;

  private ACLabelContainer activityAddRadioContainer;

  private ACListModelAdapter activityAddRadioModel;

  private ACRadioButtonItem activityAddRadioItem1;

  private ACRadioButtonItem activityAddRadioItem2;

  private ACClearableRadioButtonGroup moveFunctionImprovementAddRadio;

  private ACLabelContainer moveFunctionImprovementAddRadioContainer;

  private ACListModelAdapter moveFunctionImprovementAddRadioModel;

  private ACRadioButtonItem moveFunctionImprovementAddRadioItem1;

  private ACRadioButtonItem moveFunctionImprovementAddRadioItem2;

  private ACClearableRadioButtonGroup nourishmentImprovementAddRadio;

  private ACLabelContainer nourishmentImprovementAddRadioContainer;

  private ACListModelAdapter nourishmentImprovementAddRadioModel;

  private ACRadioButtonItem nourishmentImprovementAddRadioItem1;

  private ACRadioButtonItem nourishmentImprovementAddRadioItem2;

  private ACClearableRadioButtonGroup mouthFunctionImprovementAddRadio;

  private ACLabelContainer mouthFunctionImprovementAddRadioContainer;

  private ACListModelAdapter mouthFunctionImprovementAddRadioModel;

  private ACRadioButtonItem mouthFunctionImprovementAddRadioItem1;

  private ACRadioButtonItem mouthFunctionImprovementAddRadioItem2;

  private ACClearableRadioButtonGroup officeEvaluationAddRadio;

  private ACLabelContainer officeEvaluationAddRadioContainer;

  private ACListModelAdapter officeEvaluationAddRadioModel;

  private ACRadioButtonItem officeEvaluationAddRadioItem1;

  private ACRadioButtonItem officeEvaluationAddRadioItem2;

  private ACBackLabelContainer houmonKaigoTimeContainer;

  private ACTimeComboBox houmonKaigoBeginTime;

  private ACLabelContainer houmonKaigoBeginTimeContainer;

  private ACComboBoxModelAdapter houmonKaigoBeginTimeModel;

  private ACTimeComboBox houmonKaigoEndTime;

  private ACLabelContainer houmonKaigoEndTimeContainer;

  private ACComboBoxModelAdapter houmonKaigoEndTimeModel;

  //getter

  /**
   * 介護予防通所介護パターン領域を取得します。
   * @return 介護予防通所介護パターン領域
   */
  public ACPanel getPreventiveExpertPlaceCareMultiPatterns(){
    if(preventiveExpertPlaceCareMultiPatterns==null){

      preventiveExpertPlaceCareMultiPatterns = new ACPanel();

      preventiveExpertPlaceCareMultiPatterns.setAutoWrap(false);

      preventiveExpertPlaceCareMultiPatterns.setHgrid(200);

      addPreventiveExpertPlaceCareMultiPatterns();
    }
    return preventiveExpertPlaceCareMultiPatterns;

  }

  /**
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACClearableRadioButtonGroup getStaffSubtractionRadio(){
    if(staffSubtractionRadio==null){

      staffSubtractionRadio = new ACClearableRadioButtonGroup();

      getStaffSubtractionRadioContainer().setText("人員減算");

      staffSubtractionRadio.setBindPath("1650101");

      staffSubtractionRadio.setUseClearButton(false);

      staffSubtractionRadio.setModel(getStaffSubtractionRadioModel());

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
   * 日割を取得します。
   * @return 日割
   */
  public ACIntegerCheckBox getCrackOnDayCheck(){
    if(crackOnDayCheck==null){

      crackOnDayCheck = new ACIntegerCheckBox();

      crackOnDayCheck.setText("日割");

      crackOnDayCheck.setBindPath("1650102");

      crackOnDayCheck.setSelectValue(2);

      crackOnDayCheck.setUnSelectValue(1);

      addCrackOnDayCheck();
    }
    return crackOnDayCheck;

  }

  /**
   * アクティビティ実施加算を取得します。
   * @return アクティビティ実施加算
   */
  public ACClearableRadioButtonGroup getActivityAddRadio(){
    if(activityAddRadio==null){

      activityAddRadio = new ACClearableRadioButtonGroup();

      getActivityAddRadioContainer().setText("アクティビティ実施加算");

      activityAddRadio.setBindPath("1650103");

      activityAddRadio.setUseClearButton(false);

      activityAddRadio.setModel(getActivityAddRadioModel());

      addActivityAddRadio();
    }
    return activityAddRadio;

  }

  /**
   * アクティビティ実施加算コンテナを取得します。
   * @return アクティビティ実施加算コンテナ
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
   * アクティビティ実施加算モデルを取得します。
   * @return アクティビティ実施加算モデル
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
  public ACClearableRadioButtonGroup getMoveFunctionImprovementAddRadio(){
    if(moveFunctionImprovementAddRadio==null){

      moveFunctionImprovementAddRadio = new ACClearableRadioButtonGroup();

      getMoveFunctionImprovementAddRadioContainer().setText("運動器機能向上加算");

      moveFunctionImprovementAddRadio.setBindPath("1650104");

      moveFunctionImprovementAddRadio.setUseClearButton(false);

      moveFunctionImprovementAddRadio.setModel(getMoveFunctionImprovementAddRadioModel());

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
  public ACClearableRadioButtonGroup getNourishmentImprovementAddRadio(){
    if(nourishmentImprovementAddRadio==null){

      nourishmentImprovementAddRadio = new ACClearableRadioButtonGroup();

      getNourishmentImprovementAddRadioContainer().setText("栄養改善加算");

      nourishmentImprovementAddRadio.setBindPath("1650105");

      nourishmentImprovementAddRadio.setUseClearButton(false);

      nourishmentImprovementAddRadio.setModel(getNourishmentImprovementAddRadioModel());

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
  public ACClearableRadioButtonGroup getMouthFunctionImprovementAddRadio(){
    if(mouthFunctionImprovementAddRadio==null){

      mouthFunctionImprovementAddRadio = new ACClearableRadioButtonGroup();

      getMouthFunctionImprovementAddRadioContainer().setText("口腔機能向上加算");

      mouthFunctionImprovementAddRadio.setBindPath("1650106");

      mouthFunctionImprovementAddRadio.setUseClearButton(false);

      mouthFunctionImprovementAddRadio.setModel(getMouthFunctionImprovementAddRadioModel());

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
   * 事業所評価加算を取得します。
   * @return 事業所評価加算
   */
  public ACClearableRadioButtonGroup getOfficeEvaluationAddRadio(){
    if(officeEvaluationAddRadio==null){

      officeEvaluationAddRadio = new ACClearableRadioButtonGroup();

      getOfficeEvaluationAddRadioContainer().setText("事業所評価加算");

      officeEvaluationAddRadio.setBindPath("1650107");

      officeEvaluationAddRadio.setUseClearButton(false);

      officeEvaluationAddRadio.setModel(getOfficeEvaluationAddRadioModel());

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
   * コンストラクタです。
   */
  public QS001135Design() {

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
   * 介護予防通所介護パターン領域に内部項目を追加します。
   */
  protected void addPreventiveExpertPlaceCareMultiPatterns(){

    preventiveExpertPlaceCareMultiPatterns.add(getStaffSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventiveExpertPlaceCareMultiPatterns.add(getCrackOnDayCheck(), VRLayout.FLOW_RETURN);

    preventiveExpertPlaceCareMultiPatterns.add(getActivityAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventiveExpertPlaceCareMultiPatterns.add(getMoveFunctionImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventiveExpertPlaceCareMultiPatterns.add(getNourishmentImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventiveExpertPlaceCareMultiPatterns.add(getMouthFunctionImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventiveExpertPlaceCareMultiPatterns.add(getOfficeEvaluationAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventiveExpertPlaceCareMultiPatterns.add(getHoumonKaigoTimeContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

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
   * 日割に内部項目を追加します。
   */
  protected void addCrackOnDayCheck(){

  }

  /**
   * アクティビティ実施加算に内部項目を追加します。
   */
  protected void addActivityAddRadio(){

  }

  /**
   * アクティビティ実施加算モデルに内部項目を追加します。
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
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QS001135Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001135Design getThis() {
    return this;
  }
}
