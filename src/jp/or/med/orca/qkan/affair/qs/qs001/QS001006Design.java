
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
 * 開発者: 小笠　貴志
 * 作成日: 2006/04/19  日本コンピューター株式会社 小笠　貴志 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン訪問看護（医療） (QS001006)
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
 * サービスパターン訪問看護（医療）画面項目デザイン(QS001006) 
 */
public class QS001006Design extends QS001ServicePanel {
  //GUIコンポーネント

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACClearableRadioButtonGroup houmonKangoIryoBasicChargeDivision;

  private ACLabelContainer houmonKangoIryoBasicChargeDivisionContainer;

  private ACListModelAdapter houmonKangoIryoBasicChargeDivisionModel;

  private ACRadioButtonItem houmonKangoIryoBasicChargeDivision1;

  private ACRadioButtonItem houmonKangoIryoBasicChargeDivision2;

  private ACClearableRadioButtonGroup houmonKangoIryoClass;

  private ACLabelContainer houmonKangoIryoClassContainer;

  private ACListModelAdapter houmonKangoIryoClassModel;

  private ACRadioButtonItem houmonKangoIryoClass1;

  private ACRadioButtonItem houmonKangoIryoClass2;

  private ACClearableRadioButtonGroup houmonKangoIryoIntractableDiseaseRadio;

  private ACLabelContainer houmonKangoIryoIntractableDiseaseRadioContainer;

  private ACListModelAdapter houmonKangoIryoIntractableDiseaseRadioModel;

  private ACRadioButtonItem houmonKangoIryoIntractableDiseaseRadioItem1;

  private ACRadioButtonItem houmonKangoIryoIntractableDiseaseRadioItem2;

  private ACLabelContainer houmonKangoIryoExtensionTimeContena;

  private ACTextField houmonKangoIryoExtensionTimeText;

  private ACLabel houmonKangoIryoExtensionTimeLabel;

  private ACClearableRadioButtonGroup houmonKangoIryoGuidanceRadio;

  private ACLabelContainer houmonKangoIryoGuidanceRadioContainer;

  private ACListModelAdapter houmonKangoIryoGuidanceRadioModel;

  private ACRadioButtonItem houmonKangoIryoGuidanceRadioItem1;

  private ACRadioButtonItem houmonKangoIryoGuidanceRadioItem2;

  private ACRadioButtonItem houmonKangoIryoGuidanceRadioItem3;

  private ACClearableRadioButtonGroup houmonKangoIryo24HoureRadio;

  private ACLabelContainer houmonKangoIryo24HoureRadioContainer;

  private ACListModelAdapter houmonKangoIryo24HoureRadioModel;

  private ACRadioButtonItem houmonKangoIryo24HoureRadioItem1;

  private ACRadioButtonItem houmonKangoIryo24HoureRadioItem2;

  private ACClearableRadioButtonGroup houmonKangoIryoSeriousIllnessRadio;

  private ACLabelContainer houmonKangoIryoSeriousIllnessRadioContainer;

  private ACListModelAdapter houmonKangoIryoSeriousIllnessRadioModel;

  private ACRadioButtonItem houmonKangoIryoSeriousIllnessRadioItem1;

  private ACRadioButtonItem houmonKangoIryoSeriousIllnessRadioItem2;

  private ACRadioButtonItem houmonKangoIryoSeriousIllnessRadioItem3;

  private ACClearableRadioButtonGroup houmonKangoIryoInfoRadio;

  private ACLabelContainer houmonKangoIryoInfoRadioContainer;

  private ACListModelAdapter houmonKangoIryoInfoRadioModel;

  private ACRadioButtonItem houmonKangoIryoInfoRadioItem1;

  private ACRadioButtonItem houmonKangoIryoInfoRadioItem2;

  private ACPanel tab2;

  private ACClearableRadioButtonGroup houmonKangoIryoTerminalRadio;

  private ACLabelContainer houmonKangoIryoTerminalRadioContainer;

  private ACListModelAdapter houmonKangoIryoTerminalRadioModel;

  private ACRadioButtonItem houmonKangoIryoTerminalRadioItem1;

  private ACRadioButtonItem houmonKangoIryoTerminalRadioItem2;

  private ACRadioButtonItem houmonKangoIryoTerminalRadioItem3;

  private ACClearableRadioButtonGroup houmonKangoIryoEmergencyVisitNursingRadio;

  private ACLabelContainer houmonKangoIryoEmergencyVisitNursingRadioContainer;

  private ACListModelAdapter houmonKangoIryoEmergencyVisitNursingRadioModel;

  private ACRadioButtonItem houmonKangoIryoEmergencyVisitNursingRadioItem1;

  private ACRadioButtonItem houmonKangoIryoEmergencyVisitNursingRadioItem2;

  private ACBackLabelContainer houmonKangoIryoTimeContena;

  private ACTimeComboBox houmonKangoIryoBeginTime;

  private ACLabelContainer houmonKangoIryoBeginTimeContainer;

  private ACComboBoxModelAdapter houmonKangoIryoBeginTimeModel;

  private ACTimeComboBox houmonKangoIryoEndTime;

  private ACLabelContainer houmonKangoIryoEndTimeContainer;

  private ACComboBoxModelAdapter houmonKangoIryoEndTimeModel;

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
   * 基本療養費区分を取得します。
   * @return 基本療養費区分
   */
  public ACClearableRadioButtonGroup getHoumonKangoIryoBasicChargeDivision(){
    if(houmonKangoIryoBasicChargeDivision==null){

      houmonKangoIryoBasicChargeDivision = new ACClearableRadioButtonGroup();

      getHoumonKangoIryoBasicChargeDivisionContainer().setText("基本療養費区分");

      houmonKangoIryoBasicChargeDivision.setBindPath("2010103");

      houmonKangoIryoBasicChargeDivision.setUseClearButton(false);

      houmonKangoIryoBasicChargeDivision.setModel(getHoumonKangoIryoBasicChargeDivisionModel());

      addHoumonKangoIryoBasicChargeDivision();
    }
    return houmonKangoIryoBasicChargeDivision;

  }

  /**
   * 基本療養費区分コンテナを取得します。
   * @return 基本療養費区分コンテナ
   */
  protected ACLabelContainer getHoumonKangoIryoBasicChargeDivisionContainer(){
    if(houmonKangoIryoBasicChargeDivisionContainer==null){
      houmonKangoIryoBasicChargeDivisionContainer = new ACLabelContainer();
      houmonKangoIryoBasicChargeDivisionContainer.setFollowChildEnabled(true);
      houmonKangoIryoBasicChargeDivisionContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoIryoBasicChargeDivisionContainer.add(getHoumonKangoIryoBasicChargeDivision(), null);
    }
    return houmonKangoIryoBasicChargeDivisionContainer;
  }

  /**
   * 基本療養費区分モデルを取得します。
   * @return 基本療養費区分モデル
   */
  protected ACListModelAdapter getHoumonKangoIryoBasicChargeDivisionModel(){
    if(houmonKangoIryoBasicChargeDivisionModel==null){
      houmonKangoIryoBasicChargeDivisionModel = new ACListModelAdapter();
      addHoumonKangoIryoBasicChargeDivisionModel();
    }
    return houmonKangoIryoBasicChargeDivisionModel;
  }

  /**
   * 基本療養費Iを取得します。
   * @return 基本療養費I
   */
  public ACRadioButtonItem getHoumonKangoIryoBasicChargeDivision1(){
    if(houmonKangoIryoBasicChargeDivision1==null){

      houmonKangoIryoBasicChargeDivision1 = new ACRadioButtonItem();

      houmonKangoIryoBasicChargeDivision1.setText("基本療養費I");

      houmonKangoIryoBasicChargeDivision1.setGroup(getHoumonKangoIryoBasicChargeDivision());

      addHoumonKangoIryoBasicChargeDivision1();
    }
    return houmonKangoIryoBasicChargeDivision1;

  }

  /**
   * 基本療養費IIを取得します。
   * @return 基本療養費II
   */
  public ACRadioButtonItem getHoumonKangoIryoBasicChargeDivision2(){
    if(houmonKangoIryoBasicChargeDivision2==null){

      houmonKangoIryoBasicChargeDivision2 = new ACRadioButtonItem();

      houmonKangoIryoBasicChargeDivision2.setText("基本療養費II");

      houmonKangoIryoBasicChargeDivision2.setGroup(getHoumonKangoIryoBasicChargeDivision());

      addHoumonKangoIryoBasicChargeDivision2();
    }
    return houmonKangoIryoBasicChargeDivision2;

  }

  /**
   * 訪問看護職員区分を取得します。
   * @return 訪問看護職員区分
   */
  public ACClearableRadioButtonGroup getHoumonKangoIryoClass(){
    if(houmonKangoIryoClass==null){

      houmonKangoIryoClass = new ACClearableRadioButtonGroup();

      getHoumonKangoIryoClassContainer().setText("職員区分");

      houmonKangoIryoClass.setBindPath("2010104");

      houmonKangoIryoClass.setUseClearButton(false);

      houmonKangoIryoClass.setModel(getHoumonKangoIryoClassModel());

      addHoumonKangoIryoClass();
    }
    return houmonKangoIryoClass;

  }

  /**
   * 訪問看護職員区分コンテナを取得します。
   * @return 訪問看護職員区分コンテナ
   */
  protected ACLabelContainer getHoumonKangoIryoClassContainer(){
    if(houmonKangoIryoClassContainer==null){
      houmonKangoIryoClassContainer = new ACLabelContainer();
      houmonKangoIryoClassContainer.setFollowChildEnabled(true);
      houmonKangoIryoClassContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoIryoClassContainer.add(getHoumonKangoIryoClass(), null);
    }
    return houmonKangoIryoClassContainer;
  }

  /**
   * 訪問看護職員区分モデルを取得します。
   * @return 訪問看護職員区分モデル
   */
  protected ACListModelAdapter getHoumonKangoIryoClassModel(){
    if(houmonKangoIryoClassModel==null){
      houmonKangoIryoClassModel = new ACListModelAdapter();
      addHoumonKangoIryoClassModel();
    }
    return houmonKangoIryoClassModel;
  }

  /**
   * 正看等を取得します。
   * @return 正看等
   */
  public ACRadioButtonItem getHoumonKangoIryoClass1(){
    if(houmonKangoIryoClass1==null){

      houmonKangoIryoClass1 = new ACRadioButtonItem();

      houmonKangoIryoClass1.setText("正看等");

      houmonKangoIryoClass1.setGroup(getHoumonKangoIryoClass());

      addHoumonKangoIryoClass1();
    }
    return houmonKangoIryoClass1;

  }

  /**
   * 准看を取得します。
   * @return 准看
   */
  public ACRadioButtonItem getHoumonKangoIryoClass2(){
    if(houmonKangoIryoClass2==null){

      houmonKangoIryoClass2 = new ACRadioButtonItem();

      houmonKangoIryoClass2.setText("准看");

      houmonKangoIryoClass2.setGroup(getHoumonKangoIryoClass());

      addHoumonKangoIryoClass2();
    }
    return houmonKangoIryoClass2;

  }

  /**
   * 難病等複数回数訪問加算を取得します。
   * @return 難病等複数回数訪問加算
   */
  public ACClearableRadioButtonGroup getHoumonKangoIryoIntractableDiseaseRadio(){
    if(houmonKangoIryoIntractableDiseaseRadio==null){

      houmonKangoIryoIntractableDiseaseRadio = new ACClearableRadioButtonGroup();

      getHoumonKangoIryoIntractableDiseaseRadioContainer().setText("難病等複数回数訪問加算");

      houmonKangoIryoIntractableDiseaseRadio.setBindPath("2010105");

      houmonKangoIryoIntractableDiseaseRadio.setUseClearButton(false);

      houmonKangoIryoIntractableDiseaseRadio.setModel(getHoumonKangoIryoIntractableDiseaseRadioModel());

      addHoumonKangoIryoIntractableDiseaseRadio();
    }
    return houmonKangoIryoIntractableDiseaseRadio;

  }

  /**
   * 難病等複数回数訪問加算コンテナを取得します。
   * @return 難病等複数回数訪問加算コンテナ
   */
  protected ACLabelContainer getHoumonKangoIryoIntractableDiseaseRadioContainer(){
    if(houmonKangoIryoIntractableDiseaseRadioContainer==null){
      houmonKangoIryoIntractableDiseaseRadioContainer = new ACLabelContainer();
      houmonKangoIryoIntractableDiseaseRadioContainer.setFollowChildEnabled(true);
      houmonKangoIryoIntractableDiseaseRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoIryoIntractableDiseaseRadioContainer.add(getHoumonKangoIryoIntractableDiseaseRadio(), null);
    }
    return houmonKangoIryoIntractableDiseaseRadioContainer;
  }

  /**
   * 難病等複数回数訪問加算モデルを取得します。
   * @return 難病等複数回数訪問加算モデル
   */
  protected ACListModelAdapter getHoumonKangoIryoIntractableDiseaseRadioModel(){
    if(houmonKangoIryoIntractableDiseaseRadioModel==null){
      houmonKangoIryoIntractableDiseaseRadioModel = new ACListModelAdapter();
      addHoumonKangoIryoIntractableDiseaseRadioModel();
    }
    return houmonKangoIryoIntractableDiseaseRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonKangoIryoIntractableDiseaseRadioItem1(){
    if(houmonKangoIryoIntractableDiseaseRadioItem1==null){

      houmonKangoIryoIntractableDiseaseRadioItem1 = new ACRadioButtonItem();

      houmonKangoIryoIntractableDiseaseRadioItem1.setText("なし");

      houmonKangoIryoIntractableDiseaseRadioItem1.setGroup(getHoumonKangoIryoIntractableDiseaseRadio());

      addHoumonKangoIryoIntractableDiseaseRadioItem1();
    }
    return houmonKangoIryoIntractableDiseaseRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonKangoIryoIntractableDiseaseRadioItem2(){
    if(houmonKangoIryoIntractableDiseaseRadioItem2==null){

      houmonKangoIryoIntractableDiseaseRadioItem2 = new ACRadioButtonItem();

      houmonKangoIryoIntractableDiseaseRadioItem2.setText("あり");

      houmonKangoIryoIntractableDiseaseRadioItem2.setGroup(getHoumonKangoIryoIntractableDiseaseRadio());

      addHoumonKangoIryoIntractableDiseaseRadioItem2();
    }
    return houmonKangoIryoIntractableDiseaseRadioItem2;

  }

  /**
   * 延長時間加算コンテナを取得します。
   * @return 延長時間加算コンテナ
   */
  public ACLabelContainer getHoumonKangoIryoExtensionTimeContena(){
    if(houmonKangoIryoExtensionTimeContena==null){

      houmonKangoIryoExtensionTimeContena = new ACLabelContainer();

      houmonKangoIryoExtensionTimeContena.setText("延長時間加算");

      houmonKangoIryoExtensionTimeContena.setFollowChildEnabled(false);

      addHoumonKangoIryoExtensionTimeContena();
    }
    return houmonKangoIryoExtensionTimeContena;

  }

  /**
   * 延長時間・テキストを取得します。
   * @return 延長時間・テキスト
   */
  public ACTextField getHoumonKangoIryoExtensionTimeText(){
    if(houmonKangoIryoExtensionTimeText==null){

      houmonKangoIryoExtensionTimeText = new ACTextField();

      houmonKangoIryoExtensionTimeText.setBindPath("2010106");

      houmonKangoIryoExtensionTimeText.setColumns(2);

      houmonKangoIryoExtensionTimeText.setCharType(VRCharType.ONLY_DIGIT);

      houmonKangoIryoExtensionTimeText.setHorizontalAlignment(SwingConstants.RIGHT);

      houmonKangoIryoExtensionTimeText.setIMEMode(InputSubset.LATIN);

      houmonKangoIryoExtensionTimeText.setMaxLength(1);

      addHoumonKangoIryoExtensionTimeText();
    }
    return houmonKangoIryoExtensionTimeText;

  }

  /**
   * 延長時間・ラベル2を取得します。
   * @return 延長時間・ラベル2
   */
  public ACLabel getHoumonKangoIryoExtensionTimeLabel(){
    if(houmonKangoIryoExtensionTimeLabel==null){

      houmonKangoIryoExtensionTimeLabel = new ACLabel();

      houmonKangoIryoExtensionTimeLabel.setText("時間");

      addHoumonKangoIryoExtensionTimeLabel();
    }
    return houmonKangoIryoExtensionTimeLabel;

  }

  /**
   * 地域連携退院時共同指導加算を取得します。
   * @return 地域連携退院時共同指導加算
   */
  public ACClearableRadioButtonGroup getHoumonKangoIryoGuidanceRadio(){
    if(houmonKangoIryoGuidanceRadio==null){

      houmonKangoIryoGuidanceRadio = new ACClearableRadioButtonGroup();

      getHoumonKangoIryoGuidanceRadioContainer().setText("地域連携共同指導加算");

      houmonKangoIryoGuidanceRadio.setBindPath("2010107");

      houmonKangoIryoGuidanceRadio.setUseClearButton(false);

      houmonKangoIryoGuidanceRadio.setModel(getHoumonKangoIryoGuidanceRadioModel());

      addHoumonKangoIryoGuidanceRadio();
    }
    return houmonKangoIryoGuidanceRadio;

  }

  /**
   * 地域連携退院時共同指導加算コンテナを取得します。
   * @return 地域連携退院時共同指導加算コンテナ
   */
  protected ACLabelContainer getHoumonKangoIryoGuidanceRadioContainer(){
    if(houmonKangoIryoGuidanceRadioContainer==null){
      houmonKangoIryoGuidanceRadioContainer = new ACLabelContainer();
      houmonKangoIryoGuidanceRadioContainer.setFollowChildEnabled(true);
      houmonKangoIryoGuidanceRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoIryoGuidanceRadioContainer.add(getHoumonKangoIryoGuidanceRadio(), null);
    }
    return houmonKangoIryoGuidanceRadioContainer;
  }

  /**
   * 地域連携退院時共同指導加算モデルを取得します。
   * @return 地域連携退院時共同指導加算モデル
   */
  protected ACListModelAdapter getHoumonKangoIryoGuidanceRadioModel(){
    if(houmonKangoIryoGuidanceRadioModel==null){
      houmonKangoIryoGuidanceRadioModel = new ACListModelAdapter();
      addHoumonKangoIryoGuidanceRadioModel();
    }
    return houmonKangoIryoGuidanceRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonKangoIryoGuidanceRadioItem1(){
    if(houmonKangoIryoGuidanceRadioItem1==null){

      houmonKangoIryoGuidanceRadioItem1 = new ACRadioButtonItem();

      houmonKangoIryoGuidanceRadioItem1.setText("なし");

      houmonKangoIryoGuidanceRadioItem1.setGroup(getHoumonKangoIryoGuidanceRadio());

      houmonKangoIryoGuidanceRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoIryoGuidanceRadioItem1();
    }
    return houmonKangoIryoGuidanceRadioItem1;

  }

  /**
   * 通常の場合を取得します。
   * @return 通常の場合
   */
  public ACRadioButtonItem getHoumonKangoIryoGuidanceRadioItem2(){
    if(houmonKangoIryoGuidanceRadioItem2==null){

      houmonKangoIryoGuidanceRadioItem2 = new ACRadioButtonItem();

      houmonKangoIryoGuidanceRadioItem2.setText("通常の場合");

      houmonKangoIryoGuidanceRadioItem2.setGroup(getHoumonKangoIryoGuidanceRadio());

      houmonKangoIryoGuidanceRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoIryoGuidanceRadioItem2();
    }
    return houmonKangoIryoGuidanceRadioItem2;

  }

  /**
   * 在宅療養支援診療所の保険医の場合を取得します。
   * @return 在宅療養支援診療所の保険医の場合
   */
  public ACRadioButtonItem getHoumonKangoIryoGuidanceRadioItem3(){
    if(houmonKangoIryoGuidanceRadioItem3==null){

      houmonKangoIryoGuidanceRadioItem3 = new ACRadioButtonItem();

      houmonKangoIryoGuidanceRadioItem3.setText("<html>在宅療養支援診療所の<br>保険医の場合</html>");

      houmonKangoIryoGuidanceRadioItem3.setGroup(getHoumonKangoIryoGuidanceRadio());

      houmonKangoIryoGuidanceRadioItem3.setConstraints(VRLayout.FLOW);

      addHoumonKangoIryoGuidanceRadioItem3();
    }
    return houmonKangoIryoGuidanceRadioItem3;

  }

  /**
   * 24時間加算を取得します。
   * @return 24時間加算
   */
  public ACClearableRadioButtonGroup getHoumonKangoIryo24HoureRadio(){
    if(houmonKangoIryo24HoureRadio==null){

      houmonKangoIryo24HoureRadio = new ACClearableRadioButtonGroup();

      getHoumonKangoIryo24HoureRadioContainer().setText("24時間連絡体制加算");

      houmonKangoIryo24HoureRadio.setBindPath("2010108");

      houmonKangoIryo24HoureRadio.setUseClearButton(false);

      houmonKangoIryo24HoureRadio.setModel(getHoumonKangoIryo24HoureRadioModel());

      addHoumonKangoIryo24HoureRadio();
    }
    return houmonKangoIryo24HoureRadio;

  }

  /**
   * 24時間加算コンテナを取得します。
   * @return 24時間加算コンテナ
   */
  protected ACLabelContainer getHoumonKangoIryo24HoureRadioContainer(){
    if(houmonKangoIryo24HoureRadioContainer==null){
      houmonKangoIryo24HoureRadioContainer = new ACLabelContainer();
      houmonKangoIryo24HoureRadioContainer.setFollowChildEnabled(true);
      houmonKangoIryo24HoureRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoIryo24HoureRadioContainer.add(getHoumonKangoIryo24HoureRadio(), null);
    }
    return houmonKangoIryo24HoureRadioContainer;
  }

  /**
   * 24時間加算モデルを取得します。
   * @return 24時間加算モデル
   */
  protected ACListModelAdapter getHoumonKangoIryo24HoureRadioModel(){
    if(houmonKangoIryo24HoureRadioModel==null){
      houmonKangoIryo24HoureRadioModel = new ACListModelAdapter();
      addHoumonKangoIryo24HoureRadioModel();
    }
    return houmonKangoIryo24HoureRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonKangoIryo24HoureRadioItem1(){
    if(houmonKangoIryo24HoureRadioItem1==null){

      houmonKangoIryo24HoureRadioItem1 = new ACRadioButtonItem();

      houmonKangoIryo24HoureRadioItem1.setText("なし");

      houmonKangoIryo24HoureRadioItem1.setGroup(getHoumonKangoIryo24HoureRadio());

      addHoumonKangoIryo24HoureRadioItem1();
    }
    return houmonKangoIryo24HoureRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonKangoIryo24HoureRadioItem2(){
    if(houmonKangoIryo24HoureRadioItem2==null){

      houmonKangoIryo24HoureRadioItem2 = new ACRadioButtonItem();

      houmonKangoIryo24HoureRadioItem2.setText("あり");

      houmonKangoIryo24HoureRadioItem2.setGroup(getHoumonKangoIryo24HoureRadio());

      addHoumonKangoIryo24HoureRadioItem2();
    }
    return houmonKangoIryo24HoureRadioItem2;

  }

  /**
   * 重症者加算を取得します。
   * @return 重症者加算
   */
  public ACClearableRadioButtonGroup getHoumonKangoIryoSeriousIllnessRadio(){
    if(houmonKangoIryoSeriousIllnessRadio==null){

      houmonKangoIryoSeriousIllnessRadio = new ACClearableRadioButtonGroup();

      getHoumonKangoIryoSeriousIllnessRadioContainer().setText("重症者管理加算");

      houmonKangoIryoSeriousIllnessRadio.setBindPath("2010109");

      houmonKangoIryoSeriousIllnessRadio.setUseClearButton(false);

      houmonKangoIryoSeriousIllnessRadio.setModel(getHoumonKangoIryoSeriousIllnessRadioModel());

      addHoumonKangoIryoSeriousIllnessRadio();
    }
    return houmonKangoIryoSeriousIllnessRadio;

  }

  /**
   * 重症者加算コンテナを取得します。
   * @return 重症者加算コンテナ
   */
  protected ACLabelContainer getHoumonKangoIryoSeriousIllnessRadioContainer(){
    if(houmonKangoIryoSeriousIllnessRadioContainer==null){
      houmonKangoIryoSeriousIllnessRadioContainer = new ACLabelContainer();
      houmonKangoIryoSeriousIllnessRadioContainer.setFollowChildEnabled(true);
      houmonKangoIryoSeriousIllnessRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoIryoSeriousIllnessRadioContainer.add(getHoumonKangoIryoSeriousIllnessRadio(), null);
    }
    return houmonKangoIryoSeriousIllnessRadioContainer;
  }

  /**
   * 重症者加算モデルを取得します。
   * @return 重症者加算モデル
   */
  protected ACListModelAdapter getHoumonKangoIryoSeriousIllnessRadioModel(){
    if(houmonKangoIryoSeriousIllnessRadioModel==null){
      houmonKangoIryoSeriousIllnessRadioModel = new ACListModelAdapter();
      addHoumonKangoIryoSeriousIllnessRadioModel();
    }
    return houmonKangoIryoSeriousIllnessRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonKangoIryoSeriousIllnessRadioItem1(){
    if(houmonKangoIryoSeriousIllnessRadioItem1==null){

      houmonKangoIryoSeriousIllnessRadioItem1 = new ACRadioButtonItem();

      houmonKangoIryoSeriousIllnessRadioItem1.setText("なし");

      houmonKangoIryoSeriousIllnessRadioItem1.setGroup(getHoumonKangoIryoSeriousIllnessRadio());

      houmonKangoIryoSeriousIllnessRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoIryoSeriousIllnessRadioItem1();
    }
    return houmonKangoIryoSeriousIllnessRadioItem1;

  }

  /**
   * 特別な管理を必要とする患者を取得します。
   * @return 特別な管理を必要とする患者
   */
  public ACRadioButtonItem getHoumonKangoIryoSeriousIllnessRadioItem2(){
    if(houmonKangoIryoSeriousIllnessRadioItem2==null){

      houmonKangoIryoSeriousIllnessRadioItem2 = new ACRadioButtonItem();

      houmonKangoIryoSeriousIllnessRadioItem2.setText("特別な管理を必要とする患者");

      houmonKangoIryoSeriousIllnessRadioItem2.setGroup(getHoumonKangoIryoSeriousIllnessRadio());

      houmonKangoIryoSeriousIllnessRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoIryoSeriousIllnessRadioItem2();
    }
    return houmonKangoIryoSeriousIllnessRadioItem2;

  }

  /**
   * 重症度等の高い患者を取得します。
   * @return 重症度等の高い患者
   */
  public ACRadioButtonItem getHoumonKangoIryoSeriousIllnessRadioItem3(){
    if(houmonKangoIryoSeriousIllnessRadioItem3==null){

      houmonKangoIryoSeriousIllnessRadioItem3 = new ACRadioButtonItem();

      houmonKangoIryoSeriousIllnessRadioItem3.setText("重症度等の高い患者");

      houmonKangoIryoSeriousIllnessRadioItem3.setGroup(getHoumonKangoIryoSeriousIllnessRadio());

      houmonKangoIryoSeriousIllnessRadioItem3.setConstraints(VRLayout.FLOW);

      addHoumonKangoIryoSeriousIllnessRadioItem3();
    }
    return houmonKangoIryoSeriousIllnessRadioItem3;

  }

  /**
   * 情報提供加算を取得します。
   * @return 情報提供加算
   */
  public ACClearableRadioButtonGroup getHoumonKangoIryoInfoRadio(){
    if(houmonKangoIryoInfoRadio==null){

      houmonKangoIryoInfoRadio = new ACClearableRadioButtonGroup();

      getHoumonKangoIryoInfoRadioContainer().setText("情報提供加算");

      houmonKangoIryoInfoRadio.setBindPath("2010110");

      houmonKangoIryoInfoRadio.setUseClearButton(false);

      houmonKangoIryoInfoRadio.setModel(getHoumonKangoIryoInfoRadioModel());

      addHoumonKangoIryoInfoRadio();
    }
    return houmonKangoIryoInfoRadio;

  }

  /**
   * 情報提供加算コンテナを取得します。
   * @return 情報提供加算コンテナ
   */
  protected ACLabelContainer getHoumonKangoIryoInfoRadioContainer(){
    if(houmonKangoIryoInfoRadioContainer==null){
      houmonKangoIryoInfoRadioContainer = new ACLabelContainer();
      houmonKangoIryoInfoRadioContainer.setFollowChildEnabled(true);
      houmonKangoIryoInfoRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoIryoInfoRadioContainer.add(getHoumonKangoIryoInfoRadio(), null);
    }
    return houmonKangoIryoInfoRadioContainer;
  }

  /**
   * 情報提供加算モデルを取得します。
   * @return 情報提供加算モデル
   */
  protected ACListModelAdapter getHoumonKangoIryoInfoRadioModel(){
    if(houmonKangoIryoInfoRadioModel==null){
      houmonKangoIryoInfoRadioModel = new ACListModelAdapter();
      addHoumonKangoIryoInfoRadioModel();
    }
    return houmonKangoIryoInfoRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonKangoIryoInfoRadioItem1(){
    if(houmonKangoIryoInfoRadioItem1==null){

      houmonKangoIryoInfoRadioItem1 = new ACRadioButtonItem();

      houmonKangoIryoInfoRadioItem1.setText("なし");

      houmonKangoIryoInfoRadioItem1.setGroup(getHoumonKangoIryoInfoRadio());

      addHoumonKangoIryoInfoRadioItem1();
    }
    return houmonKangoIryoInfoRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonKangoIryoInfoRadioItem2(){
    if(houmonKangoIryoInfoRadioItem2==null){

      houmonKangoIryoInfoRadioItem2 = new ACRadioButtonItem();

      houmonKangoIryoInfoRadioItem2.setText("あり");

      houmonKangoIryoInfoRadioItem2.setGroup(getHoumonKangoIryoInfoRadio());

      addHoumonKangoIryoInfoRadioItem2();
    }
    return houmonKangoIryoInfoRadioItem2;

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
   * ターミナルケア療養費を取得します。
   * @return ターミナルケア療養費
   */
  public ACClearableRadioButtonGroup getHoumonKangoIryoTerminalRadio(){
    if(houmonKangoIryoTerminalRadio==null){

      houmonKangoIryoTerminalRadio = new ACClearableRadioButtonGroup();

      getHoumonKangoIryoTerminalRadioContainer().setText("ターミナルケア療養費");

      houmonKangoIryoTerminalRadio.setBindPath("2010111");

      houmonKangoIryoTerminalRadio.setUseClearButton(false);

      houmonKangoIryoTerminalRadio.setModel(getHoumonKangoIryoTerminalRadioModel());

      addHoumonKangoIryoTerminalRadio();
    }
    return houmonKangoIryoTerminalRadio;

  }

  /**
   * ターミナルケア療養費コンテナを取得します。
   * @return ターミナルケア療養費コンテナ
   */
  protected ACLabelContainer getHoumonKangoIryoTerminalRadioContainer(){
    if(houmonKangoIryoTerminalRadioContainer==null){
      houmonKangoIryoTerminalRadioContainer = new ACLabelContainer();
      houmonKangoIryoTerminalRadioContainer.setFollowChildEnabled(true);
      houmonKangoIryoTerminalRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoIryoTerminalRadioContainer.add(getHoumonKangoIryoTerminalRadio(), null);
    }
    return houmonKangoIryoTerminalRadioContainer;
  }

  /**
   * ターミナルケア療養費モデルを取得します。
   * @return ターミナルケア療養費モデル
   */
  protected ACListModelAdapter getHoumonKangoIryoTerminalRadioModel(){
    if(houmonKangoIryoTerminalRadioModel==null){
      houmonKangoIryoTerminalRadioModel = new ACListModelAdapter();
      addHoumonKangoIryoTerminalRadioModel();
    }
    return houmonKangoIryoTerminalRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonKangoIryoTerminalRadioItem1(){
    if(houmonKangoIryoTerminalRadioItem1==null){

      houmonKangoIryoTerminalRadioItem1 = new ACRadioButtonItem();

      houmonKangoIryoTerminalRadioItem1.setText("なし");

      houmonKangoIryoTerminalRadioItem1.setGroup(getHoumonKangoIryoTerminalRadio());

      houmonKangoIryoTerminalRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoIryoTerminalRadioItem1();
    }
    return houmonKangoIryoTerminalRadioItem1;

  }

  /**
   * 在宅療養支援診療所の保険医の指示を取得します。
   * @return 在宅療養支援診療所の保険医の指示
   */
  public ACRadioButtonItem getHoumonKangoIryoTerminalRadioItem2(){
    if(houmonKangoIryoTerminalRadioItem2==null){

      houmonKangoIryoTerminalRadioItem2 = new ACRadioButtonItem();

      houmonKangoIryoTerminalRadioItem2.setText("<html>在宅療養支援診療所の<br>保険医の指示</html>");

      houmonKangoIryoTerminalRadioItem2.setGroup(getHoumonKangoIryoTerminalRadio());

      houmonKangoIryoTerminalRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoIryoTerminalRadioItem2();
    }
    return houmonKangoIryoTerminalRadioItem2;

  }

  /**
   * 保険医療機関の保険医の指示を取得します。
   * @return 保険医療機関の保険医の指示
   */
  public ACRadioButtonItem getHoumonKangoIryoTerminalRadioItem3(){
    if(houmonKangoIryoTerminalRadioItem3==null){

      houmonKangoIryoTerminalRadioItem3 = new ACRadioButtonItem();

      houmonKangoIryoTerminalRadioItem3.setText("保険医療機関の保険医の指示");

      houmonKangoIryoTerminalRadioItem3.setGroup(getHoumonKangoIryoTerminalRadio());

      houmonKangoIryoTerminalRadioItem3.setConstraints(VRLayout.FLOW);

      addHoumonKangoIryoTerminalRadioItem3();
    }
    return houmonKangoIryoTerminalRadioItem3;

  }

  /**
   * 緊急訪問看護加算を取得します。
   * @return 緊急訪問看護加算
   */
  public ACClearableRadioButtonGroup getHoumonKangoIryoEmergencyVisitNursingRadio(){
    if(houmonKangoIryoEmergencyVisitNursingRadio==null){

      houmonKangoIryoEmergencyVisitNursingRadio = new ACClearableRadioButtonGroup();

      getHoumonKangoIryoEmergencyVisitNursingRadioContainer().setText("緊急時訪問看護加算");

      houmonKangoIryoEmergencyVisitNursingRadio.setBindPath("2010112");

      houmonKangoIryoEmergencyVisitNursingRadio.setUseClearButton(false);

      houmonKangoIryoEmergencyVisitNursingRadio.setModel(getHoumonKangoIryoEmergencyVisitNursingRadioModel());

      addHoumonKangoIryoEmergencyVisitNursingRadio();
    }
    return houmonKangoIryoEmergencyVisitNursingRadio;

  }

  /**
   * 緊急訪問看護加算コンテナを取得します。
   * @return 緊急訪問看護加算コンテナ
   */
  protected ACLabelContainer getHoumonKangoIryoEmergencyVisitNursingRadioContainer(){
    if(houmonKangoIryoEmergencyVisitNursingRadioContainer==null){
      houmonKangoIryoEmergencyVisitNursingRadioContainer = new ACLabelContainer();
      houmonKangoIryoEmergencyVisitNursingRadioContainer.setFollowChildEnabled(true);
      houmonKangoIryoEmergencyVisitNursingRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoIryoEmergencyVisitNursingRadioContainer.add(getHoumonKangoIryoEmergencyVisitNursingRadio(), null);
    }
    return houmonKangoIryoEmergencyVisitNursingRadioContainer;
  }

  /**
   * 緊急訪問看護加算モデルを取得します。
   * @return 緊急訪問看護加算モデル
   */
  protected ACListModelAdapter getHoumonKangoIryoEmergencyVisitNursingRadioModel(){
    if(houmonKangoIryoEmergencyVisitNursingRadioModel==null){
      houmonKangoIryoEmergencyVisitNursingRadioModel = new ACListModelAdapter();
      addHoumonKangoIryoEmergencyVisitNursingRadioModel();
    }
    return houmonKangoIryoEmergencyVisitNursingRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonKangoIryoEmergencyVisitNursingRadioItem1(){
    if(houmonKangoIryoEmergencyVisitNursingRadioItem1==null){

      houmonKangoIryoEmergencyVisitNursingRadioItem1 = new ACRadioButtonItem();

      houmonKangoIryoEmergencyVisitNursingRadioItem1.setText("なし");

      houmonKangoIryoEmergencyVisitNursingRadioItem1.setGroup(getHoumonKangoIryoEmergencyVisitNursingRadio());

      houmonKangoIryoEmergencyVisitNursingRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonKangoIryoEmergencyVisitNursingRadioItem1();
    }
    return houmonKangoIryoEmergencyVisitNursingRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonKangoIryoEmergencyVisitNursingRadioItem2(){
    if(houmonKangoIryoEmergencyVisitNursingRadioItem2==null){

      houmonKangoIryoEmergencyVisitNursingRadioItem2 = new ACRadioButtonItem();

      houmonKangoIryoEmergencyVisitNursingRadioItem2.setText("あり");

      houmonKangoIryoEmergencyVisitNursingRadioItem2.setGroup(getHoumonKangoIryoEmergencyVisitNursingRadio());

      houmonKangoIryoEmergencyVisitNursingRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonKangoIryoEmergencyVisitNursingRadioItem2();
    }
    return houmonKangoIryoEmergencyVisitNursingRadioItem2;

  }

  /**
   * 提供時間コンテナを取得します。
   * @return 提供時間コンテナ
   */
  public ACBackLabelContainer getHoumonKangoIryoTimeContena(){
    if(houmonKangoIryoTimeContena==null){

      houmonKangoIryoTimeContena = new ACBackLabelContainer();

      addHoumonKangoIryoTimeContena();
    }
    return houmonKangoIryoTimeContena;

  }

  /**
   * 開始時刻コンボを取得します。
   * @return 開始時刻コンボ
   */
  public ACTimeComboBox getHoumonKangoIryoBeginTime(){
    if(houmonKangoIryoBeginTime==null){

      houmonKangoIryoBeginTime = new ACTimeComboBox();

      getHoumonKangoIryoBeginTimeContainer().setText("開始時刻");

      houmonKangoIryoBeginTime.setBindPath("3");

      houmonKangoIryoBeginTime.setModelBindPath("3");

      houmonKangoIryoBeginTime.setRenderBindPath("CONTENT");

      houmonKangoIryoBeginTime.setModel(getHoumonKangoIryoBeginTimeModel());

      addHoumonKangoIryoBeginTime();
    }
    return houmonKangoIryoBeginTime;

  }

  /**
   * 開始時刻コンボコンテナを取得します。
   * @return 開始時刻コンボコンテナ
   */
  protected ACLabelContainer getHoumonKangoIryoBeginTimeContainer(){
    if(houmonKangoIryoBeginTimeContainer==null){
      houmonKangoIryoBeginTimeContainer = new ACLabelContainer();
      houmonKangoIryoBeginTimeContainer.setFollowChildEnabled(true);
      houmonKangoIryoBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoIryoBeginTimeContainer.add(getHoumonKangoIryoBeginTime(), null);
    }
    return houmonKangoIryoBeginTimeContainer;
  }

  /**
   * 開始時刻コンボモデルを取得します。
   * @return 開始時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getHoumonKangoIryoBeginTimeModel(){
    if(houmonKangoIryoBeginTimeModel==null){
      houmonKangoIryoBeginTimeModel = new ACComboBoxModelAdapter();
      addHoumonKangoIryoBeginTimeModel();
    }
    return houmonKangoIryoBeginTimeModel;
  }

  /**
   * 終了時刻コンボを取得します。
   * @return 終了時刻コンボ
   */
  public ACTimeComboBox getHoumonKangoIryoEndTime(){
    if(houmonKangoIryoEndTime==null){

      houmonKangoIryoEndTime = new ACTimeComboBox();

      getHoumonKangoIryoEndTimeContainer().setText("終了時刻");

      houmonKangoIryoEndTime.setBindPath("4");

      houmonKangoIryoEndTime.setModelBindPath("4");

      houmonKangoIryoEndTime.setRenderBindPath("CONTENT");

      houmonKangoIryoEndTime.setModel(getHoumonKangoIryoEndTimeModel());

      addHoumonKangoIryoEndTime();
    }
    return houmonKangoIryoEndTime;

  }

  /**
   * 終了時刻コンボコンテナを取得します。
   * @return 終了時刻コンボコンテナ
   */
  protected ACLabelContainer getHoumonKangoIryoEndTimeContainer(){
    if(houmonKangoIryoEndTimeContainer==null){
      houmonKangoIryoEndTimeContainer = new ACLabelContainer();
      houmonKangoIryoEndTimeContainer.setFollowChildEnabled(true);
      houmonKangoIryoEndTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoIryoEndTimeContainer.add(getHoumonKangoIryoEndTime(), null);
    }
    return houmonKangoIryoEndTimeContainer;
  }

  /**
   * 終了時刻コンボモデルを取得します。
   * @return 終了時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getHoumonKangoIryoEndTimeModel(){
    if(houmonKangoIryoEndTimeModel==null){
      houmonKangoIryoEndTimeModel = new ACComboBoxModelAdapter();
      addHoumonKangoIryoEndTimeModel();
    }
    return houmonKangoIryoEndTimeModel;
  }

  /**
   * コンストラクタです。
   */
  public QS001006Design() {

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

    tab1.add(getHoumonKangoIryoBasicChargeDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoIryoClassContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoIryoIntractableDiseaseRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoIryoExtensionTimeContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoIryoGuidanceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoIryo24HoureRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoIryoSeriousIllnessRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoIryoInfoRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 基本療養費区分に内部項目を追加します。
   */
  protected void addHoumonKangoIryoBasicChargeDivision(){

  }

  /**
   * 基本療養費区分モデルに内部項目を追加します。
   */
  protected void addHoumonKangoIryoBasicChargeDivisionModel(){

    getHoumonKangoIryoBasicChargeDivision1().setButtonIndex(1);
    getHoumonKangoIryoBasicChargeDivisionModel().add(getHoumonKangoIryoBasicChargeDivision1());

    getHoumonKangoIryoBasicChargeDivision2().setButtonIndex(2);
    getHoumonKangoIryoBasicChargeDivisionModel().add(getHoumonKangoIryoBasicChargeDivision2());

  }

  /**
   * 基本療養費Iに内部項目を追加します。
   */
  protected void addHoumonKangoIryoBasicChargeDivision1(){

  }

  /**
   * 基本療養費IIに内部項目を追加します。
   */
  protected void addHoumonKangoIryoBasicChargeDivision2(){

  }

  /**
   * 訪問看護職員区分に内部項目を追加します。
   */
  protected void addHoumonKangoIryoClass(){

  }

  /**
   * 訪問看護職員区分モデルに内部項目を追加します。
   */
  protected void addHoumonKangoIryoClassModel(){

    getHoumonKangoIryoClass1().setButtonIndex(1);
    getHoumonKangoIryoClassModel().add(getHoumonKangoIryoClass1());

    getHoumonKangoIryoClass2().setButtonIndex(2);
    getHoumonKangoIryoClassModel().add(getHoumonKangoIryoClass2());

  }

  /**
   * 正看等に内部項目を追加します。
   */
  protected void addHoumonKangoIryoClass1(){

  }

  /**
   * 准看に内部項目を追加します。
   */
  protected void addHoumonKangoIryoClass2(){

  }

  /**
   * 難病等複数回数訪問加算に内部項目を追加します。
   */
  protected void addHoumonKangoIryoIntractableDiseaseRadio(){

  }

  /**
   * 難病等複数回数訪問加算モデルに内部項目を追加します。
   */
  protected void addHoumonKangoIryoIntractableDiseaseRadioModel(){

    getHoumonKangoIryoIntractableDiseaseRadioItem1().setButtonIndex(1);
    getHoumonKangoIryoIntractableDiseaseRadioModel().add(getHoumonKangoIryoIntractableDiseaseRadioItem1());

    getHoumonKangoIryoIntractableDiseaseRadioItem2().setButtonIndex(2);
    getHoumonKangoIryoIntractableDiseaseRadioModel().add(getHoumonKangoIryoIntractableDiseaseRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonKangoIryoIntractableDiseaseRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonKangoIryoIntractableDiseaseRadioItem2(){

  }

  /**
   * 延長時間加算コンテナに内部項目を追加します。
   */
  protected void addHoumonKangoIryoExtensionTimeContena(){

    houmonKangoIryoExtensionTimeContena.add(getHoumonKangoIryoExtensionTimeText(), VRLayout.FLOW);

    houmonKangoIryoExtensionTimeContena.add(getHoumonKangoIryoExtensionTimeLabel(), VRLayout.FLOW);

  }

  /**
   * 延長時間・テキストに内部項目を追加します。
   */
  protected void addHoumonKangoIryoExtensionTimeText(){

  }

  /**
   * 延長時間・ラベル2に内部項目を追加します。
   */
  protected void addHoumonKangoIryoExtensionTimeLabel(){

  }

  /**
   * 地域連携退院時共同指導加算に内部項目を追加します。
   */
  protected void addHoumonKangoIryoGuidanceRadio(){

  }

  /**
   * 地域連携退院時共同指導加算モデルに内部項目を追加します。
   */
  protected void addHoumonKangoIryoGuidanceRadioModel(){

    getHoumonKangoIryoGuidanceRadioItem1().setButtonIndex(1);
    getHoumonKangoIryoGuidanceRadioModel().add(getHoumonKangoIryoGuidanceRadioItem1());

    getHoumonKangoIryoGuidanceRadioItem2().setButtonIndex(2);
    getHoumonKangoIryoGuidanceRadioModel().add(getHoumonKangoIryoGuidanceRadioItem2());

    getHoumonKangoIryoGuidanceRadioItem3().setButtonIndex(3);
    getHoumonKangoIryoGuidanceRadioModel().add(getHoumonKangoIryoGuidanceRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonKangoIryoGuidanceRadioItem1(){

  }

  /**
   * 通常の場合に内部項目を追加します。
   */
  protected void addHoumonKangoIryoGuidanceRadioItem2(){

  }

  /**
   * 在宅療養支援診療所の保険医の場合に内部項目を追加します。
   */
  protected void addHoumonKangoIryoGuidanceRadioItem3(){

  }

  /**
   * 24時間加算に内部項目を追加します。
   */
  protected void addHoumonKangoIryo24HoureRadio(){

  }

  /**
   * 24時間加算モデルに内部項目を追加します。
   */
  protected void addHoumonKangoIryo24HoureRadioModel(){

    getHoumonKangoIryo24HoureRadioItem1().setButtonIndex(1);
    getHoumonKangoIryo24HoureRadioModel().add(getHoumonKangoIryo24HoureRadioItem1());

    getHoumonKangoIryo24HoureRadioItem2().setButtonIndex(2);
    getHoumonKangoIryo24HoureRadioModel().add(getHoumonKangoIryo24HoureRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonKangoIryo24HoureRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonKangoIryo24HoureRadioItem2(){

  }

  /**
   * 重症者加算に内部項目を追加します。
   */
  protected void addHoumonKangoIryoSeriousIllnessRadio(){

  }

  /**
   * 重症者加算モデルに内部項目を追加します。
   */
  protected void addHoumonKangoIryoSeriousIllnessRadioModel(){

    getHoumonKangoIryoSeriousIllnessRadioItem1().setButtonIndex(1);
    getHoumonKangoIryoSeriousIllnessRadioModel().add(getHoumonKangoIryoSeriousIllnessRadioItem1());

    getHoumonKangoIryoSeriousIllnessRadioItem2().setButtonIndex(2);
    getHoumonKangoIryoSeriousIllnessRadioModel().add(getHoumonKangoIryoSeriousIllnessRadioItem2());

    getHoumonKangoIryoSeriousIllnessRadioItem3().setButtonIndex(3);
    getHoumonKangoIryoSeriousIllnessRadioModel().add(getHoumonKangoIryoSeriousIllnessRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonKangoIryoSeriousIllnessRadioItem1(){

  }

  /**
   * 特別な管理を必要とする患者に内部項目を追加します。
   */
  protected void addHoumonKangoIryoSeriousIllnessRadioItem2(){

  }

  /**
   * 重症度等の高い患者に内部項目を追加します。
   */
  protected void addHoumonKangoIryoSeriousIllnessRadioItem3(){

  }

  /**
   * 情報提供加算に内部項目を追加します。
   */
  protected void addHoumonKangoIryoInfoRadio(){

  }

  /**
   * 情報提供加算モデルに内部項目を追加します。
   */
  protected void addHoumonKangoIryoInfoRadioModel(){

    getHoumonKangoIryoInfoRadioItem1().setButtonIndex(1);
    getHoumonKangoIryoInfoRadioModel().add(getHoumonKangoIryoInfoRadioItem1());

    getHoumonKangoIryoInfoRadioItem2().setButtonIndex(2);
    getHoumonKangoIryoInfoRadioModel().add(getHoumonKangoIryoInfoRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonKangoIryoInfoRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonKangoIryoInfoRadioItem2(){

  }

  /**
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getHoumonKangoIryoTerminalRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonKangoIryoEmergencyVisitNursingRadioContainer(), VRLayout.FLOW_INSETLINE);

    tab2.add(getHoumonKangoIryoTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * ターミナルケア療養費に内部項目を追加します。
   */
  protected void addHoumonKangoIryoTerminalRadio(){

  }

  /**
   * ターミナルケア療養費モデルに内部項目を追加します。
   */
  protected void addHoumonKangoIryoTerminalRadioModel(){

    getHoumonKangoIryoTerminalRadioItem1().setButtonIndex(1);
    getHoumonKangoIryoTerminalRadioModel().add(getHoumonKangoIryoTerminalRadioItem1());

    getHoumonKangoIryoTerminalRadioItem2().setButtonIndex(2);
    getHoumonKangoIryoTerminalRadioModel().add(getHoumonKangoIryoTerminalRadioItem2());

    getHoumonKangoIryoTerminalRadioItem3().setButtonIndex(3);
    getHoumonKangoIryoTerminalRadioModel().add(getHoumonKangoIryoTerminalRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonKangoIryoTerminalRadioItem1(){

  }

  /**
   * 在宅療養支援診療所の保険医の指示に内部項目を追加します。
   */
  protected void addHoumonKangoIryoTerminalRadioItem2(){

  }

  /**
   * 保険医療機関の保険医の指示に内部項目を追加します。
   */
  protected void addHoumonKangoIryoTerminalRadioItem3(){

  }

  /**
   * 緊急訪問看護加算に内部項目を追加します。
   */
  protected void addHoumonKangoIryoEmergencyVisitNursingRadio(){

  }

  /**
   * 緊急訪問看護加算モデルに内部項目を追加します。
   */
  protected void addHoumonKangoIryoEmergencyVisitNursingRadioModel(){

    getHoumonKangoIryoEmergencyVisitNursingRadioItem1().setButtonIndex(1);
    getHoumonKangoIryoEmergencyVisitNursingRadioModel().add(getHoumonKangoIryoEmergencyVisitNursingRadioItem1());

    getHoumonKangoIryoEmergencyVisitNursingRadioItem2().setButtonIndex(2);
    getHoumonKangoIryoEmergencyVisitNursingRadioModel().add(getHoumonKangoIryoEmergencyVisitNursingRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonKangoIryoEmergencyVisitNursingRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonKangoIryoEmergencyVisitNursingRadioItem2(){

  }

  /**
   * 提供時間コンテナに内部項目を追加します。
   */
  protected void addHoumonKangoIryoTimeContena(){

    houmonKangoIryoTimeContena.add(getHoumonKangoIryoBeginTimeContainer(), VRLayout.FLOW);

    houmonKangoIryoTimeContena.add(getHoumonKangoIryoEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * 開始時刻コンボに内部項目を追加します。
   */
  protected void addHoumonKangoIryoBeginTime(){

  }

  /**
   * 開始時刻コンボモデルに内部項目を追加します。
   */
  protected void addHoumonKangoIryoBeginTimeModel(){

  }

  /**
   * 終了時刻コンボに内部項目を追加します。
   */
  protected void addHoumonKangoIryoEndTime(){

  }

  /**
   * 終了時刻コンボモデルに内部項目を追加します。
   */
  protected void addHoumonKangoIryoEndTimeModel(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001006Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001006Design getThis() {
    return this;
  }
}
