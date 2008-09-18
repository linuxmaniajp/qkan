
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
 * 作成日: 2006/03/09  日本コンピューター株式会社 松本　幸一 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン通所介護 (QS001107)
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
import jp.or.med.orca.qkan.lib.*;
import jp.or.med.orca.qkan.text.*;
/**
 * サービスパターン通所介護画面項目デザイン(QS001107) 
 */
public class QS001107Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel tsuusyoKaigoPatterns;

  private ACLabelContainer tsuusyoKaigoFacilitiesDivisionContainer;

  private ACClearableRadioButtonGroup tsuusyoKaigoTimeContenaFacilityDivision;

  private ACListModelAdapter tsuusyoKaigoTimeContenaFacilityDivisionModel;

  private ACRadioButtonItem tsuusyoKaigoTimeContenaFacilityDivisionItem1;

  private ACRadioButtonItem tsuusyoKaigoTimeContenaFacilityDivisionItem2;

  private ACRadioButtonItem tsuusyoKaigoTimeContenaFacilityDivisionItem3;

  private ACIntegerCheckBox tsuusyoKaigoDementiaLargeCheck;

  private ACComboBox tsuusyoKaigoTimeDivision;

  private ACLabelContainer tsuusyoKaigoTimeDivisionContainer;

  private ACComboBoxModelAdapter tsuusyoKaigoTimeDivisionModel;

  private ACClearableRadioButtonGroup tsuusyoKaigoAdditionFunctionTrainingRadio;

  private ACLabelContainer tsuusyoKaigoAdditionFunctionTrainingRadioContainer;

  private ACListModelAdapter tsuusyoKaigoAdditionFunctionTrainingRadioModel;

  private ACRadioButtonItem tsuusyoKaigoAdditionFunctionTrainingRadioItem1;

  private ACRadioButtonItem tsuusyoKaigoAdditionFunctionTrainingRadioItem2;

  private ACClearableRadioButtonGroup tsuusyoKaigoAdditionFunctionBathRadio;

  private ACLabelContainer tsuusyoKaigoAdditionFunctionBathRadioContainer;

  private ACListModelAdapter tsuusyoKaigoAdditionFunctionBathRadioModel;

  private ACRadioButtonItem tsuusyoKaigoAdditionFunctionBathRadioItem1;

  private ACRadioButtonItem tsuusyoKaigoAdditionFunctionBathRadioItem2;

  private ACClearableRadioButtonGroup tsuusyoKaigoSubtraction;

  private ACLabelContainer tsuusyoKaigoSubtractionContainer;

  private ACListModelAdapter tsuusyoKaigoSubtractionModel;

  private ACRadioButtonItem tsuusyoKaigoSubtractionNot;

  private ACRadioButtonItem tsuusyoKaigoSubtractionExcess;

  private ACRadioButtonItem tsuusyoKaigoSubtractionLack;

  private ACClearableRadioButtonGroup tsuusyoKaigoYouthNinchishoAddRadio;

  private ACLabelContainer tsuusyoKaigoYouthNinchishoAddRadioContainer;

  private ACListModelAdapter tsuusyoKaigoYouthNinchishoAddRadioModel;

  private ACRadioButtonItem tsuusyoKaigoYouthNinchishoAddRadioItem1;

  private ACRadioButtonItem tsuusyoKaigoYouthNinchishoAddRadioItem2;

  private ACClearableRadioButtonGroup tsuusyoKaigoNourishmentManagementAddRadio;

  private ACLabelContainer tsuusyoKaigoNourishmentManagementAddRadioContainer;

  private ACListModelAdapter tsuusyoKaigoNourishmentManagementAddRadioModel;

  private ACRadioButtonItem tsuusyoKaigoNourishmentManagementAddRadioItem1;

  private ACRadioButtonItem tsuusyoKaigoNourishmentManagementAddRadioItem2;

  private ACClearableRadioButtonGroup tsuusyoKaigoMouthFunctionAddRadio;

  private ACLabelContainer tsuusyoKaigoMouthFunctionAddRadioContainer;

  private ACListModelAdapter tsuusyoKaigoMouthFunctionAddRadioModel;

  private ACRadioButtonItem tsuusyoKaigoMouthFunctionAddRadioItem1;

  private ACRadioButtonItem tsuusyoKaigoMouthFunctionAddRadioItem2;

  private ACBackLabelContainer tsuusyoKaigoTimeContena;

  private ACTimeComboBox tsuusyoKaigoTimeBeginTime;

  private ACLabelContainer tsuusyoKaigoTimeBeginTimeContainer;

  private ACComboBoxModelAdapter tsuusyoKaigoTimeBeginTimeModel;

  private ACTimeComboBox tsuusyoKaigoTimeEndTime;

  private ACLabelContainer tsuusyoKaigoTimeEndTimeContainer;

  private ACComboBoxModelAdapter tsuusyoKaigoTimeEndTimeModel;

  //getter

  /**
   * 通所介護パターン領域を取得します。
   * @return 通所介護パターン領域
   */
  public ACPanel getTsuusyoKaigoPatterns(){
    if(tsuusyoKaigoPatterns==null){

      tsuusyoKaigoPatterns = new ACPanel();

      tsuusyoKaigoPatterns.setHgap(0);

      tsuusyoKaigoPatterns.setHgrid(200);

      addTsuusyoKaigoPatterns();
    }
    return tsuusyoKaigoPatterns;

  }

  /**
   * 施設等の区分コンテナを取得します。
   * @return 施設等の区分コンテナ
   */
  public ACLabelContainer getTsuusyoKaigoFacilitiesDivisionContainer(){
    if(tsuusyoKaigoFacilitiesDivisionContainer==null){

      tsuusyoKaigoFacilitiesDivisionContainer = new ACLabelContainer();

      tsuusyoKaigoFacilitiesDivisionContainer.setText("施設等の区分");

      addTsuusyoKaigoFacilitiesDivisionContainer();
    }
    return tsuusyoKaigoFacilitiesDivisionContainer;

  }

  /**
   * 施設等の区分ラジオグループを取得します。
   * @return 施設等の区分ラジオグループ
   */
  public ACClearableRadioButtonGroup getTsuusyoKaigoTimeContenaFacilityDivision(){
    if(tsuusyoKaigoTimeContenaFacilityDivision==null){

      tsuusyoKaigoTimeContenaFacilityDivision = new ACClearableRadioButtonGroup();

      tsuusyoKaigoTimeContenaFacilityDivision.setBindPath("1150103");

      tsuusyoKaigoTimeContenaFacilityDivision.setModel(getTsuusyoKaigoTimeContenaFacilityDivisionModel());

      tsuusyoKaigoTimeContenaFacilityDivision.setUseClearButton(false);

      addTsuusyoKaigoTimeContenaFacilityDivision();
    }
    return tsuusyoKaigoTimeContenaFacilityDivision;

  }

  /**
   * 施設等の区分ラジオグループモデルを取得します。
   * @return 施設等の区分ラジオグループモデル
   */
  protected ACListModelAdapter getTsuusyoKaigoTimeContenaFacilityDivisionModel(){
    if(tsuusyoKaigoTimeContenaFacilityDivisionModel==null){
      tsuusyoKaigoTimeContenaFacilityDivisionModel = new ACListModelAdapter();
      addTsuusyoKaigoTimeContenaFacilityDivisionModel();
    }
    return tsuusyoKaigoTimeContenaFacilityDivisionModel;
  }

  /**
   * 小規模を取得します。
   * @return 小規模
   */
  public ACRadioButtonItem getTsuusyoKaigoTimeContenaFacilityDivisionItem1(){
    if(tsuusyoKaigoTimeContenaFacilityDivisionItem1==null){

      tsuusyoKaigoTimeContenaFacilityDivisionItem1 = new ACRadioButtonItem();

      tsuusyoKaigoTimeContenaFacilityDivisionItem1.setText("小規模");

      tsuusyoKaigoTimeContenaFacilityDivisionItem1.setGroup(getTsuusyoKaigoTimeContenaFacilityDivision());

      tsuusyoKaigoTimeContenaFacilityDivisionItem1.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoTimeContenaFacilityDivisionItem1();
    }
    return tsuusyoKaigoTimeContenaFacilityDivisionItem1;

  }

  /**
   * 通常規模を取得します。
   * @return 通常規模
   */
  public ACRadioButtonItem getTsuusyoKaigoTimeContenaFacilityDivisionItem2(){
    if(tsuusyoKaigoTimeContenaFacilityDivisionItem2==null){

      tsuusyoKaigoTimeContenaFacilityDivisionItem2 = new ACRadioButtonItem();

      tsuusyoKaigoTimeContenaFacilityDivisionItem2.setText("通常規模");

      tsuusyoKaigoTimeContenaFacilityDivisionItem2.setGroup(getTsuusyoKaigoTimeContenaFacilityDivision());

      tsuusyoKaigoTimeContenaFacilityDivisionItem2.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoTimeContenaFacilityDivisionItem2();
    }
    return tsuusyoKaigoTimeContenaFacilityDivisionItem2;

  }

  /**
   * 療養通所を取得します。
   * @return 療養通所
   */
  public ACRadioButtonItem getTsuusyoKaigoTimeContenaFacilityDivisionItem3(){
    if(tsuusyoKaigoTimeContenaFacilityDivisionItem3==null){

      tsuusyoKaigoTimeContenaFacilityDivisionItem3 = new ACRadioButtonItem();

      tsuusyoKaigoTimeContenaFacilityDivisionItem3.setText("療養通所");

      tsuusyoKaigoTimeContenaFacilityDivisionItem3.setGroup(getTsuusyoKaigoTimeContenaFacilityDivision());

      tsuusyoKaigoTimeContenaFacilityDivisionItem3.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoTimeContenaFacilityDivisionItem3();
    }
    return tsuusyoKaigoTimeContenaFacilityDivisionItem3;

  }

  /**
   * 大規模事業所を取得します。
   * @return 大規模事業所
   */
  public ACIntegerCheckBox getTsuusyoKaigoDementiaLargeCheck(){
    if(tsuusyoKaigoDementiaLargeCheck==null){

      tsuusyoKaigoDementiaLargeCheck = new ACIntegerCheckBox();

      tsuusyoKaigoDementiaLargeCheck.setText("大規模事業所");

      tsuusyoKaigoDementiaLargeCheck.setBindPath("1150109");

      tsuusyoKaigoDementiaLargeCheck.setSelectValue(2);

      tsuusyoKaigoDementiaLargeCheck.setUnSelectValue(1);

      addTsuusyoKaigoDementiaLargeCheck();
    }
    return tsuusyoKaigoDementiaLargeCheck;

  }

  /**
   * 時間区分を取得します。
   * @return 時間区分
   */
  public ACComboBox getTsuusyoKaigoTimeDivision(){
    if(tsuusyoKaigoTimeDivision==null){

      tsuusyoKaigoTimeDivision = new ACComboBox();

      getTsuusyoKaigoTimeDivisionContainer().setText("時間区分");

      tsuusyoKaigoTimeDivision.setBindPath("1150104");

      tsuusyoKaigoTimeDivision.setEditable(false);

      tsuusyoKaigoTimeDivision.setModelBindPath("1150104");

      tsuusyoKaigoTimeDivision.setModel(getTsuusyoKaigoTimeDivisionModel());

      tsuusyoKaigoTimeDivision.setRenderBindPath("CONTENT");

      addTsuusyoKaigoTimeDivision();
    }
    return tsuusyoKaigoTimeDivision;

  }

  /**
   * 時間区分コンテナを取得します。
   * @return 時間区分コンテナ
   */
  protected ACLabelContainer getTsuusyoKaigoTimeDivisionContainer(){
    if(tsuusyoKaigoTimeDivisionContainer==null){
      tsuusyoKaigoTimeDivisionContainer = new ACLabelContainer();
      tsuusyoKaigoTimeDivisionContainer.setFollowChildEnabled(true);
      tsuusyoKaigoTimeDivisionContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoTimeDivisionContainer.add(getTsuusyoKaigoTimeDivision(), null);
    }
    return tsuusyoKaigoTimeDivisionContainer;
  }

  /**
   * 時間区分モデルを取得します。
   * @return 時間区分モデル
   */
  protected ACComboBoxModelAdapter getTsuusyoKaigoTimeDivisionModel(){
    if(tsuusyoKaigoTimeDivisionModel==null){
      tsuusyoKaigoTimeDivisionModel = new ACComboBoxModelAdapter();
      addTsuusyoKaigoTimeDivisionModel();
    }
    return tsuusyoKaigoTimeDivisionModel;
  }

  /**
   * 個別機能訓練指導加算を取得します。
   * @return 個別機能訓練指導加算
   */
  public ACClearableRadioButtonGroup getTsuusyoKaigoAdditionFunctionTrainingRadio(){
    if(tsuusyoKaigoAdditionFunctionTrainingRadio==null){

      tsuusyoKaigoAdditionFunctionTrainingRadio = new ACClearableRadioButtonGroup();

      getTsuusyoKaigoAdditionFunctionTrainingRadioContainer().setText("個別機能訓練指導加算");

      tsuusyoKaigoAdditionFunctionTrainingRadio.setBindPath("1150105");

      tsuusyoKaigoAdditionFunctionTrainingRadio.setModel(getTsuusyoKaigoAdditionFunctionTrainingRadioModel());

      tsuusyoKaigoAdditionFunctionTrainingRadio.setUseClearButton(false);

      addTsuusyoKaigoAdditionFunctionTrainingRadio();
    }
    return tsuusyoKaigoAdditionFunctionTrainingRadio;

  }

  /**
   * 個別機能訓練指導加算コンテナを取得します。
   * @return 個別機能訓練指導加算コンテナ
   */
  protected ACLabelContainer getTsuusyoKaigoAdditionFunctionTrainingRadioContainer(){
    if(tsuusyoKaigoAdditionFunctionTrainingRadioContainer==null){
      tsuusyoKaigoAdditionFunctionTrainingRadioContainer = new ACLabelContainer();
      tsuusyoKaigoAdditionFunctionTrainingRadioContainer.setFollowChildEnabled(true);
      tsuusyoKaigoAdditionFunctionTrainingRadioContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoAdditionFunctionTrainingRadioContainer.add(getTsuusyoKaigoAdditionFunctionTrainingRadio(), null);
    }
    return tsuusyoKaigoAdditionFunctionTrainingRadioContainer;
  }

  /**
   * 個別機能訓練指導加算モデルを取得します。
   * @return 個別機能訓練指導加算モデル
   */
  protected ACListModelAdapter getTsuusyoKaigoAdditionFunctionTrainingRadioModel(){
    if(tsuusyoKaigoAdditionFunctionTrainingRadioModel==null){
      tsuusyoKaigoAdditionFunctionTrainingRadioModel = new ACListModelAdapter();
      addTsuusyoKaigoAdditionFunctionTrainingRadioModel();
    }
    return tsuusyoKaigoAdditionFunctionTrainingRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTsuusyoKaigoAdditionFunctionTrainingRadioItem1(){
    if(tsuusyoKaigoAdditionFunctionTrainingRadioItem1==null){

      tsuusyoKaigoAdditionFunctionTrainingRadioItem1 = new ACRadioButtonItem();

      tsuusyoKaigoAdditionFunctionTrainingRadioItem1.setText("なし");

      tsuusyoKaigoAdditionFunctionTrainingRadioItem1.setGroup(getTsuusyoKaigoAdditionFunctionTrainingRadio());

      tsuusyoKaigoAdditionFunctionTrainingRadioItem1.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoAdditionFunctionTrainingRadioItem1();
    }
    return tsuusyoKaigoAdditionFunctionTrainingRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getTsuusyoKaigoAdditionFunctionTrainingRadioItem2(){
    if(tsuusyoKaigoAdditionFunctionTrainingRadioItem2==null){

      tsuusyoKaigoAdditionFunctionTrainingRadioItem2 = new ACRadioButtonItem();

      tsuusyoKaigoAdditionFunctionTrainingRadioItem2.setText("あり");

      tsuusyoKaigoAdditionFunctionTrainingRadioItem2.setGroup(getTsuusyoKaigoAdditionFunctionTrainingRadio());

      tsuusyoKaigoAdditionFunctionTrainingRadioItem2.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoAdditionFunctionTrainingRadioItem2();
    }
    return tsuusyoKaigoAdditionFunctionTrainingRadioItem2;

  }

  /**
   * 入浴加算を取得します。
   * @return 入浴加算
   */
  public ACClearableRadioButtonGroup getTsuusyoKaigoAdditionFunctionBathRadio(){
    if(tsuusyoKaigoAdditionFunctionBathRadio==null){

      tsuusyoKaigoAdditionFunctionBathRadio = new ACClearableRadioButtonGroup();

      getTsuusyoKaigoAdditionFunctionBathRadioContainer().setText("入浴加算");

      tsuusyoKaigoAdditionFunctionBathRadio.setBindPath("1150106");

      tsuusyoKaigoAdditionFunctionBathRadio.setModel(getTsuusyoKaigoAdditionFunctionBathRadioModel());

      tsuusyoKaigoAdditionFunctionBathRadio.setUseClearButton(false);

      addTsuusyoKaigoAdditionFunctionBathRadio();
    }
    return tsuusyoKaigoAdditionFunctionBathRadio;

  }

  /**
   * 入浴加算コンテナを取得します。
   * @return 入浴加算コンテナ
   */
  protected ACLabelContainer getTsuusyoKaigoAdditionFunctionBathRadioContainer(){
    if(tsuusyoKaigoAdditionFunctionBathRadioContainer==null){
      tsuusyoKaigoAdditionFunctionBathRadioContainer = new ACLabelContainer();
      tsuusyoKaigoAdditionFunctionBathRadioContainer.setFollowChildEnabled(true);
      tsuusyoKaigoAdditionFunctionBathRadioContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoAdditionFunctionBathRadioContainer.add(getTsuusyoKaigoAdditionFunctionBathRadio(), null);
    }
    return tsuusyoKaigoAdditionFunctionBathRadioContainer;
  }

  /**
   * 入浴加算モデルを取得します。
   * @return 入浴加算モデル
   */
  protected ACListModelAdapter getTsuusyoKaigoAdditionFunctionBathRadioModel(){
    if(tsuusyoKaigoAdditionFunctionBathRadioModel==null){
      tsuusyoKaigoAdditionFunctionBathRadioModel = new ACListModelAdapter();
      addTsuusyoKaigoAdditionFunctionBathRadioModel();
    }
    return tsuusyoKaigoAdditionFunctionBathRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTsuusyoKaigoAdditionFunctionBathRadioItem1(){
    if(tsuusyoKaigoAdditionFunctionBathRadioItem1==null){

      tsuusyoKaigoAdditionFunctionBathRadioItem1 = new ACRadioButtonItem();

      tsuusyoKaigoAdditionFunctionBathRadioItem1.setText("なし");

      tsuusyoKaigoAdditionFunctionBathRadioItem1.setGroup(getTsuusyoKaigoAdditionFunctionBathRadio());

      tsuusyoKaigoAdditionFunctionBathRadioItem1.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoAdditionFunctionBathRadioItem1();
    }
    return tsuusyoKaigoAdditionFunctionBathRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getTsuusyoKaigoAdditionFunctionBathRadioItem2(){
    if(tsuusyoKaigoAdditionFunctionBathRadioItem2==null){

      tsuusyoKaigoAdditionFunctionBathRadioItem2 = new ACRadioButtonItem();

      tsuusyoKaigoAdditionFunctionBathRadioItem2.setText("あり");

      tsuusyoKaigoAdditionFunctionBathRadioItem2.setGroup(getTsuusyoKaigoAdditionFunctionBathRadio());

      tsuusyoKaigoAdditionFunctionBathRadioItem2.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoAdditionFunctionBathRadioItem2();
    }
    return tsuusyoKaigoAdditionFunctionBathRadioItem2;

  }

  /**
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACClearableRadioButtonGroup getTsuusyoKaigoSubtraction(){
    if(tsuusyoKaigoSubtraction==null){

      tsuusyoKaigoSubtraction = new ACClearableRadioButtonGroup();

      getTsuusyoKaigoSubtractionContainer().setText("人員減算");

      tsuusyoKaigoSubtraction.setBindPath("1150108");

      tsuusyoKaigoSubtraction.setModel(getTsuusyoKaigoSubtractionModel());

      tsuusyoKaigoSubtraction.setUseClearButton(false);

      addTsuusyoKaigoSubtraction();
    }
    return tsuusyoKaigoSubtraction;

  }

  /**
   * 人員減算コンテナを取得します。
   * @return 人員減算コンテナ
   */
  protected ACLabelContainer getTsuusyoKaigoSubtractionContainer(){
    if(tsuusyoKaigoSubtractionContainer==null){
      tsuusyoKaigoSubtractionContainer = new ACLabelContainer();
      tsuusyoKaigoSubtractionContainer.setFollowChildEnabled(true);
      tsuusyoKaigoSubtractionContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoSubtractionContainer.add(getTsuusyoKaigoSubtraction(), null);
    }
    return tsuusyoKaigoSubtractionContainer;
  }

  /**
   * 人員減算モデルを取得します。
   * @return 人員減算モデル
   */
  protected ACListModelAdapter getTsuusyoKaigoSubtractionModel(){
    if(tsuusyoKaigoSubtractionModel==null){
      tsuusyoKaigoSubtractionModel = new ACListModelAdapter();
      addTsuusyoKaigoSubtractionModel();
    }
    return tsuusyoKaigoSubtractionModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTsuusyoKaigoSubtractionNot(){
    if(tsuusyoKaigoSubtractionNot==null){

      tsuusyoKaigoSubtractionNot = new ACRadioButtonItem();

      tsuusyoKaigoSubtractionNot.setText("なし");

      tsuusyoKaigoSubtractionNot.setGroup(getTsuusyoKaigoSubtraction());

      tsuusyoKaigoSubtractionNot.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoSubtractionNot();
    }
    return tsuusyoKaigoSubtractionNot;

  }

  /**
   * 定員超過を取得します。
   * @return 定員超過
   */
  public ACRadioButtonItem getTsuusyoKaigoSubtractionExcess(){
    if(tsuusyoKaigoSubtractionExcess==null){

      tsuusyoKaigoSubtractionExcess = new ACRadioButtonItem();

      tsuusyoKaigoSubtractionExcess.setText("定員超過");

      tsuusyoKaigoSubtractionExcess.setGroup(getTsuusyoKaigoSubtraction());

      tsuusyoKaigoSubtractionExcess.setConstraints(VRLayout.FLOW_RETURN);

      addTsuusyoKaigoSubtractionExcess();
    }
    return tsuusyoKaigoSubtractionExcess;

  }

  /**
   * 看護・介護職員の不足を取得します。
   * @return 看護・介護職員の不足
   */
  public ACRadioButtonItem getTsuusyoKaigoSubtractionLack(){
    if(tsuusyoKaigoSubtractionLack==null){

      tsuusyoKaigoSubtractionLack = new ACRadioButtonItem();

      tsuusyoKaigoSubtractionLack.setText("看護・介護職員の不足");

      tsuusyoKaigoSubtractionLack.setGroup(getTsuusyoKaigoSubtraction());

      tsuusyoKaigoSubtractionLack.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoSubtractionLack();
    }
    return tsuusyoKaigoSubtractionLack;

  }

  /**
   * 若年性認知症ケア加算を取得します。
   * @return 若年性認知症ケア加算
   */
  public ACClearableRadioButtonGroup getTsuusyoKaigoYouthNinchishoAddRadio(){
    if(tsuusyoKaigoYouthNinchishoAddRadio==null){

      tsuusyoKaigoYouthNinchishoAddRadio = new ACClearableRadioButtonGroup();

      getTsuusyoKaigoYouthNinchishoAddRadioContainer().setText("若年性認知症ケア加算");

      tsuusyoKaigoYouthNinchishoAddRadio.setBindPath("1150110");

      tsuusyoKaigoYouthNinchishoAddRadio.setModel(getTsuusyoKaigoYouthNinchishoAddRadioModel());

      tsuusyoKaigoYouthNinchishoAddRadio.setUseClearButton(false);

      addTsuusyoKaigoYouthNinchishoAddRadio();
    }
    return tsuusyoKaigoYouthNinchishoAddRadio;

  }

  /**
   * 若年性認知症ケア加算コンテナを取得します。
   * @return 若年性認知症ケア加算コンテナ
   */
  protected ACLabelContainer getTsuusyoKaigoYouthNinchishoAddRadioContainer(){
    if(tsuusyoKaigoYouthNinchishoAddRadioContainer==null){
      tsuusyoKaigoYouthNinchishoAddRadioContainer = new ACLabelContainer();
      tsuusyoKaigoYouthNinchishoAddRadioContainer.setFollowChildEnabled(true);
      tsuusyoKaigoYouthNinchishoAddRadioContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoYouthNinchishoAddRadioContainer.add(getTsuusyoKaigoYouthNinchishoAddRadio(), null);
    }
    return tsuusyoKaigoYouthNinchishoAddRadioContainer;
  }

  /**
   * 若年性認知症ケア加算モデルを取得します。
   * @return 若年性認知症ケア加算モデル
   */
  protected ACListModelAdapter getTsuusyoKaigoYouthNinchishoAddRadioModel(){
    if(tsuusyoKaigoYouthNinchishoAddRadioModel==null){
      tsuusyoKaigoYouthNinchishoAddRadioModel = new ACListModelAdapter();
      addTsuusyoKaigoYouthNinchishoAddRadioModel();
    }
    return tsuusyoKaigoYouthNinchishoAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTsuusyoKaigoYouthNinchishoAddRadioItem1(){
    if(tsuusyoKaigoYouthNinchishoAddRadioItem1==null){

      tsuusyoKaigoYouthNinchishoAddRadioItem1 = new ACRadioButtonItem();

      tsuusyoKaigoYouthNinchishoAddRadioItem1.setText("なし");

      tsuusyoKaigoYouthNinchishoAddRadioItem1.setGroup(getTsuusyoKaigoYouthNinchishoAddRadio());

      tsuusyoKaigoYouthNinchishoAddRadioItem1.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoYouthNinchishoAddRadioItem1();
    }
    return tsuusyoKaigoYouthNinchishoAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getTsuusyoKaigoYouthNinchishoAddRadioItem2(){
    if(tsuusyoKaigoYouthNinchishoAddRadioItem2==null){

      tsuusyoKaigoYouthNinchishoAddRadioItem2 = new ACRadioButtonItem();

      tsuusyoKaigoYouthNinchishoAddRadioItem2.setText("あり");

      tsuusyoKaigoYouthNinchishoAddRadioItem2.setGroup(getTsuusyoKaigoYouthNinchishoAddRadio());

      tsuusyoKaigoYouthNinchishoAddRadioItem2.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoYouthNinchishoAddRadioItem2();
    }
    return tsuusyoKaigoYouthNinchishoAddRadioItem2;

  }

  /**
   * 栄養マネジメント加算を取得します。
   * @return 栄養マネジメント加算
   */
  public ACClearableRadioButtonGroup getTsuusyoKaigoNourishmentManagementAddRadio(){
    if(tsuusyoKaigoNourishmentManagementAddRadio==null){

      tsuusyoKaigoNourishmentManagementAddRadio = new ACClearableRadioButtonGroup();

      getTsuusyoKaigoNourishmentManagementAddRadioContainer().setText("栄養マネジメント加算");

      tsuusyoKaigoNourishmentManagementAddRadio.setBindPath("1150111");

      tsuusyoKaigoNourishmentManagementAddRadio.setModel(getTsuusyoKaigoNourishmentManagementAddRadioModel());

      tsuusyoKaigoNourishmentManagementAddRadio.setUseClearButton(false);

      addTsuusyoKaigoNourishmentManagementAddRadio();
    }
    return tsuusyoKaigoNourishmentManagementAddRadio;

  }

  /**
   * 栄養マネジメント加算コンテナを取得します。
   * @return 栄養マネジメント加算コンテナ
   */
  protected ACLabelContainer getTsuusyoKaigoNourishmentManagementAddRadioContainer(){
    if(tsuusyoKaigoNourishmentManagementAddRadioContainer==null){
      tsuusyoKaigoNourishmentManagementAddRadioContainer = new ACLabelContainer();
      tsuusyoKaigoNourishmentManagementAddRadioContainer.setFollowChildEnabled(true);
      tsuusyoKaigoNourishmentManagementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoNourishmentManagementAddRadioContainer.add(getTsuusyoKaigoNourishmentManagementAddRadio(), null);
    }
    return tsuusyoKaigoNourishmentManagementAddRadioContainer;
  }

  /**
   * 栄養マネジメント加算モデルを取得します。
   * @return 栄養マネジメント加算モデル
   */
  protected ACListModelAdapter getTsuusyoKaigoNourishmentManagementAddRadioModel(){
    if(tsuusyoKaigoNourishmentManagementAddRadioModel==null){
      tsuusyoKaigoNourishmentManagementAddRadioModel = new ACListModelAdapter();
      addTsuusyoKaigoNourishmentManagementAddRadioModel();
    }
    return tsuusyoKaigoNourishmentManagementAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTsuusyoKaigoNourishmentManagementAddRadioItem1(){
    if(tsuusyoKaigoNourishmentManagementAddRadioItem1==null){

      tsuusyoKaigoNourishmentManagementAddRadioItem1 = new ACRadioButtonItem();

      tsuusyoKaigoNourishmentManagementAddRadioItem1.setText("なし");

      tsuusyoKaigoNourishmentManagementAddRadioItem1.setGroup(getTsuusyoKaigoNourishmentManagementAddRadio());

      tsuusyoKaigoNourishmentManagementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoNourishmentManagementAddRadioItem1();
    }
    return tsuusyoKaigoNourishmentManagementAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getTsuusyoKaigoNourishmentManagementAddRadioItem2(){
    if(tsuusyoKaigoNourishmentManagementAddRadioItem2==null){

      tsuusyoKaigoNourishmentManagementAddRadioItem2 = new ACRadioButtonItem();

      tsuusyoKaigoNourishmentManagementAddRadioItem2.setText("あり");

      tsuusyoKaigoNourishmentManagementAddRadioItem2.setGroup(getTsuusyoKaigoNourishmentManagementAddRadio());

      tsuusyoKaigoNourishmentManagementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoNourishmentManagementAddRadioItem2();
    }
    return tsuusyoKaigoNourishmentManagementAddRadioItem2;

  }

  /**
   * 口腔機能向上加算を取得します。
   * @return 口腔機能向上加算
   */
  public ACClearableRadioButtonGroup getTsuusyoKaigoMouthFunctionAddRadio(){
    if(tsuusyoKaigoMouthFunctionAddRadio==null){

      tsuusyoKaigoMouthFunctionAddRadio = new ACClearableRadioButtonGroup();

      getTsuusyoKaigoMouthFunctionAddRadioContainer().setText("口腔機能向上加算");

      tsuusyoKaigoMouthFunctionAddRadio.setBindPath("1150112");

      tsuusyoKaigoMouthFunctionAddRadio.setModel(getTsuusyoKaigoMouthFunctionAddRadioModel());

      tsuusyoKaigoMouthFunctionAddRadio.setUseClearButton(false);

      addTsuusyoKaigoMouthFunctionAddRadio();
    }
    return tsuusyoKaigoMouthFunctionAddRadio;

  }

  /**
   * 口腔機能向上加算コンテナを取得します。
   * @return 口腔機能向上加算コンテナ
   */
  protected ACLabelContainer getTsuusyoKaigoMouthFunctionAddRadioContainer(){
    if(tsuusyoKaigoMouthFunctionAddRadioContainer==null){
      tsuusyoKaigoMouthFunctionAddRadioContainer = new ACLabelContainer();
      tsuusyoKaigoMouthFunctionAddRadioContainer.setFollowChildEnabled(true);
      tsuusyoKaigoMouthFunctionAddRadioContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoMouthFunctionAddRadioContainer.add(getTsuusyoKaigoMouthFunctionAddRadio(), null);
    }
    return tsuusyoKaigoMouthFunctionAddRadioContainer;
  }

  /**
   * 口腔機能向上加算モデルを取得します。
   * @return 口腔機能向上加算モデル
   */
  protected ACListModelAdapter getTsuusyoKaigoMouthFunctionAddRadioModel(){
    if(tsuusyoKaigoMouthFunctionAddRadioModel==null){
      tsuusyoKaigoMouthFunctionAddRadioModel = new ACListModelAdapter();
      addTsuusyoKaigoMouthFunctionAddRadioModel();
    }
    return tsuusyoKaigoMouthFunctionAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTsuusyoKaigoMouthFunctionAddRadioItem1(){
    if(tsuusyoKaigoMouthFunctionAddRadioItem1==null){

      tsuusyoKaigoMouthFunctionAddRadioItem1 = new ACRadioButtonItem();

      tsuusyoKaigoMouthFunctionAddRadioItem1.setText("なし");

      tsuusyoKaigoMouthFunctionAddRadioItem1.setGroup(getTsuusyoKaigoMouthFunctionAddRadio());

      tsuusyoKaigoMouthFunctionAddRadioItem1.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoMouthFunctionAddRadioItem1();
    }
    return tsuusyoKaigoMouthFunctionAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getTsuusyoKaigoMouthFunctionAddRadioItem2(){
    if(tsuusyoKaigoMouthFunctionAddRadioItem2==null){

      tsuusyoKaigoMouthFunctionAddRadioItem2 = new ACRadioButtonItem();

      tsuusyoKaigoMouthFunctionAddRadioItem2.setText("あり");

      tsuusyoKaigoMouthFunctionAddRadioItem2.setGroup(getTsuusyoKaigoMouthFunctionAddRadio());

      tsuusyoKaigoMouthFunctionAddRadioItem2.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoMouthFunctionAddRadioItem2();
    }
    return tsuusyoKaigoMouthFunctionAddRadioItem2;

  }

  /**
   * 提供時間コンテナを取得します。
   * @return 提供時間コンテナ
   */
  public ACBackLabelContainer getTsuusyoKaigoTimeContena(){
    if(tsuusyoKaigoTimeContena==null){

      tsuusyoKaigoTimeContena = new ACBackLabelContainer();

      addTsuusyoKaigoTimeContena();
    }
    return tsuusyoKaigoTimeContena;

  }

  /**
   * 開始時刻コンボを取得します。
   * @return 開始時刻コンボ
   */
  public ACTimeComboBox getTsuusyoKaigoTimeBeginTime(){
    if(tsuusyoKaigoTimeBeginTime==null){

      tsuusyoKaigoTimeBeginTime = new ACTimeComboBox();

      getTsuusyoKaigoTimeBeginTimeContainer().setText("開始時刻");

      tsuusyoKaigoTimeBeginTime.setBindPath("3");

      tsuusyoKaigoTimeBeginTime.setModelBindPath("3");

      tsuusyoKaigoTimeBeginTime.setModel(getTsuusyoKaigoTimeBeginTimeModel());

      tsuusyoKaigoTimeBeginTime.setRenderBindPath("CONTENT");

      addTsuusyoKaigoTimeBeginTime();
    }
    return tsuusyoKaigoTimeBeginTime;

  }

  /**
   * 開始時刻コンボコンテナを取得します。
   * @return 開始時刻コンボコンテナ
   */
  protected ACLabelContainer getTsuusyoKaigoTimeBeginTimeContainer(){
    if(tsuusyoKaigoTimeBeginTimeContainer==null){
      tsuusyoKaigoTimeBeginTimeContainer = new ACLabelContainer();
      tsuusyoKaigoTimeBeginTimeContainer.setFollowChildEnabled(true);
      tsuusyoKaigoTimeBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoTimeBeginTimeContainer.add(getTsuusyoKaigoTimeBeginTime(), null);
    }
    return tsuusyoKaigoTimeBeginTimeContainer;
  }

  /**
   * 開始時刻コンボモデルを取得します。
   * @return 開始時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getTsuusyoKaigoTimeBeginTimeModel(){
    if(tsuusyoKaigoTimeBeginTimeModel==null){
      tsuusyoKaigoTimeBeginTimeModel = new ACComboBoxModelAdapter();
      addTsuusyoKaigoTimeBeginTimeModel();
    }
    return tsuusyoKaigoTimeBeginTimeModel;
  }

  /**
   * 終了時刻コンボを取得します。
   * @return 終了時刻コンボ
   */
  public ACTimeComboBox getTsuusyoKaigoTimeEndTime(){
    if(tsuusyoKaigoTimeEndTime==null){

      tsuusyoKaigoTimeEndTime = new ACTimeComboBox();

      getTsuusyoKaigoTimeEndTimeContainer().setText("終了時刻");

      tsuusyoKaigoTimeEndTime.setBindPath("4");

      tsuusyoKaigoTimeEndTime.setModelBindPath("4");

      tsuusyoKaigoTimeEndTime.setModel(getTsuusyoKaigoTimeEndTimeModel());

      tsuusyoKaigoTimeEndTime.setRenderBindPath("CONTENT");

      addTsuusyoKaigoTimeEndTime();
    }
    return tsuusyoKaigoTimeEndTime;

  }

  /**
   * 終了時刻コンボコンテナを取得します。
   * @return 終了時刻コンボコンテナ
   */
  protected ACLabelContainer getTsuusyoKaigoTimeEndTimeContainer(){
    if(tsuusyoKaigoTimeEndTimeContainer==null){
      tsuusyoKaigoTimeEndTimeContainer = new ACLabelContainer();
      tsuusyoKaigoTimeEndTimeContainer.setFollowChildEnabled(true);
      tsuusyoKaigoTimeEndTimeContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoTimeEndTimeContainer.add(getTsuusyoKaigoTimeEndTime(), null);
    }
    return tsuusyoKaigoTimeEndTimeContainer;
  }

  /**
   * 終了時刻コンボモデルを取得します。
   * @return 終了時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getTsuusyoKaigoTimeEndTimeModel(){
    if(tsuusyoKaigoTimeEndTimeModel==null){
      tsuusyoKaigoTimeEndTimeModel = new ACComboBoxModelAdapter();
      addTsuusyoKaigoTimeEndTimeModel();
    }
    return tsuusyoKaigoTimeEndTimeModel;
  }

  /**
   * コンストラクタです。
   */
  public QS001107Design() {

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

    this.add(getTsuusyoKaigoPatterns(), VRLayout.CLIENT);

  }

  /**
   * 通所介護パターン領域に内部項目を追加します。
   */
  protected void addTsuusyoKaigoPatterns(){

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoTimeDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoAdditionFunctionTrainingRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoAdditionFunctionBathRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoYouthNinchishoAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoNourishmentManagementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoMouthFunctionAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * 施設等の区分コンテナに内部項目を追加します。
   */
  protected void addTsuusyoKaigoFacilitiesDivisionContainer(){

    tsuusyoKaigoFacilitiesDivisionContainer.add(getTsuusyoKaigoTimeContenaFacilityDivision(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyoKaigoFacilitiesDivisionContainer.add(getTsuusyoKaigoDementiaLargeCheck(), VRLayout.FLOW);

  }

  /**
   * 施設等の区分ラジオグループに内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeContenaFacilityDivision(){

  }

  /**
   * 施設等の区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeContenaFacilityDivisionModel(){

    getTsuusyoKaigoTimeContenaFacilityDivisionItem1().setButtonIndex(1);
    getTsuusyoKaigoTimeContenaFacilityDivisionModel().add(getTsuusyoKaigoTimeContenaFacilityDivisionItem1());

    getTsuusyoKaigoTimeContenaFacilityDivisionItem2().setButtonIndex(2);
    getTsuusyoKaigoTimeContenaFacilityDivisionModel().add(getTsuusyoKaigoTimeContenaFacilityDivisionItem2());

    getTsuusyoKaigoTimeContenaFacilityDivisionItem3().setButtonIndex(3);
    getTsuusyoKaigoTimeContenaFacilityDivisionModel().add(getTsuusyoKaigoTimeContenaFacilityDivisionItem3());

  }

  /**
   * 小規模に内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeContenaFacilityDivisionItem1(){

  }

  /**
   * 通常規模に内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeContenaFacilityDivisionItem2(){

  }

  /**
   * 療養通所に内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeContenaFacilityDivisionItem3(){

  }

  /**
   * 大規模事業所に内部項目を追加します。
   */
  protected void addTsuusyoKaigoDementiaLargeCheck(){

  }

  /**
   * 時間区分に内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeDivision(){

  }

  /**
   * 時間区分モデルに内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeDivisionModel(){

  }

  /**
   * 個別機能訓練指導加算に内部項目を追加します。
   */
  protected void addTsuusyoKaigoAdditionFunctionTrainingRadio(){

  }

  /**
   * 個別機能訓練指導加算モデルに内部項目を追加します。
   */
  protected void addTsuusyoKaigoAdditionFunctionTrainingRadioModel(){

    getTsuusyoKaigoAdditionFunctionTrainingRadioItem1().setButtonIndex(1);
    getTsuusyoKaigoAdditionFunctionTrainingRadioModel().add(getTsuusyoKaigoAdditionFunctionTrainingRadioItem1());

    getTsuusyoKaigoAdditionFunctionTrainingRadioItem2().setButtonIndex(2);
    getTsuusyoKaigoAdditionFunctionTrainingRadioModel().add(getTsuusyoKaigoAdditionFunctionTrainingRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTsuusyoKaigoAdditionFunctionTrainingRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addTsuusyoKaigoAdditionFunctionTrainingRadioItem2(){

  }

  /**
   * 入浴加算に内部項目を追加します。
   */
  protected void addTsuusyoKaigoAdditionFunctionBathRadio(){

  }

  /**
   * 入浴加算モデルに内部項目を追加します。
   */
  protected void addTsuusyoKaigoAdditionFunctionBathRadioModel(){

    getTsuusyoKaigoAdditionFunctionBathRadioItem1().setButtonIndex(1);
    getTsuusyoKaigoAdditionFunctionBathRadioModel().add(getTsuusyoKaigoAdditionFunctionBathRadioItem1());

    getTsuusyoKaigoAdditionFunctionBathRadioItem2().setButtonIndex(2);
    getTsuusyoKaigoAdditionFunctionBathRadioModel().add(getTsuusyoKaigoAdditionFunctionBathRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTsuusyoKaigoAdditionFunctionBathRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addTsuusyoKaigoAdditionFunctionBathRadioItem2(){

  }

  /**
   * 人員減算に内部項目を追加します。
   */
  protected void addTsuusyoKaigoSubtraction(){

  }

  /**
   * 人員減算モデルに内部項目を追加します。
   */
  protected void addTsuusyoKaigoSubtractionModel(){

    getTsuusyoKaigoSubtractionNot().setButtonIndex(1);
    getTsuusyoKaigoSubtractionModel().add(getTsuusyoKaigoSubtractionNot());

    getTsuusyoKaigoSubtractionExcess().setButtonIndex(2);
    getTsuusyoKaigoSubtractionModel().add(getTsuusyoKaigoSubtractionExcess());

    getTsuusyoKaigoSubtractionLack().setButtonIndex(3);
    getTsuusyoKaigoSubtractionModel().add(getTsuusyoKaigoSubtractionLack());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTsuusyoKaigoSubtractionNot(){

  }

  /**
   * 定員超過に内部項目を追加します。
   */
  protected void addTsuusyoKaigoSubtractionExcess(){

  }

  /**
   * 看護・介護職員の不足に内部項目を追加します。
   */
  protected void addTsuusyoKaigoSubtractionLack(){

  }

  /**
   * 若年性認知症ケア加算に内部項目を追加します。
   */
  protected void addTsuusyoKaigoYouthNinchishoAddRadio(){

  }

  /**
   * 若年性認知症ケア加算モデルに内部項目を追加します。
   */
  protected void addTsuusyoKaigoYouthNinchishoAddRadioModel(){

    getTsuusyoKaigoYouthNinchishoAddRadioItem1().setButtonIndex(1);
    getTsuusyoKaigoYouthNinchishoAddRadioModel().add(getTsuusyoKaigoYouthNinchishoAddRadioItem1());

    getTsuusyoKaigoYouthNinchishoAddRadioItem2().setButtonIndex(2);
    getTsuusyoKaigoYouthNinchishoAddRadioModel().add(getTsuusyoKaigoYouthNinchishoAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTsuusyoKaigoYouthNinchishoAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addTsuusyoKaigoYouthNinchishoAddRadioItem2(){

  }

  /**
   * 栄養マネジメント加算に内部項目を追加します。
   */
  protected void addTsuusyoKaigoNourishmentManagementAddRadio(){

  }

  /**
   * 栄養マネジメント加算モデルに内部項目を追加します。
   */
  protected void addTsuusyoKaigoNourishmentManagementAddRadioModel(){

    getTsuusyoKaigoNourishmentManagementAddRadioItem1().setButtonIndex(1);
    getTsuusyoKaigoNourishmentManagementAddRadioModel().add(getTsuusyoKaigoNourishmentManagementAddRadioItem1());

    getTsuusyoKaigoNourishmentManagementAddRadioItem2().setButtonIndex(2);
    getTsuusyoKaigoNourishmentManagementAddRadioModel().add(getTsuusyoKaigoNourishmentManagementAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTsuusyoKaigoNourishmentManagementAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addTsuusyoKaigoNourishmentManagementAddRadioItem2(){

  }

  /**
   * 口腔機能向上加算に内部項目を追加します。
   */
  protected void addTsuusyoKaigoMouthFunctionAddRadio(){

  }

  /**
   * 口腔機能向上加算モデルに内部項目を追加します。
   */
  protected void addTsuusyoKaigoMouthFunctionAddRadioModel(){

    getTsuusyoKaigoMouthFunctionAddRadioItem1().setButtonIndex(1);
    getTsuusyoKaigoMouthFunctionAddRadioModel().add(getTsuusyoKaigoMouthFunctionAddRadioItem1());

    getTsuusyoKaigoMouthFunctionAddRadioItem2().setButtonIndex(2);
    getTsuusyoKaigoMouthFunctionAddRadioModel().add(getTsuusyoKaigoMouthFunctionAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTsuusyoKaigoMouthFunctionAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addTsuusyoKaigoMouthFunctionAddRadioItem2(){

  }

  /**
   * 提供時間コンテナに内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeContena(){

    tsuusyoKaigoTimeContena.add(getTsuusyoKaigoTimeBeginTimeContainer(), VRLayout.FLOW);

    tsuusyoKaigoTimeContena.add(getTsuusyoKaigoTimeEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * 開始時刻コンボに内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeBeginTime(){

  }

  /**
   * 開始時刻コンボモデルに内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeBeginTimeModel(){

  }

  /**
   * 終了時刻コンボに内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeEndTime(){

  }

  /**
   * 終了時刻コンボモデルに内部項目を追加します。
   */
  protected void addTsuusyoKaigoTimeEndTimeModel(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001107Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001107Design getThis() {
    return this;
  }
}
