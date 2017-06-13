
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
 * プログラム サービスパターン訪問型サービス（独自） (QS001_50211_201504)
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
 * サービスパターン訪問型サービス（独自）画面項目デザイン(QS001_50211_201504) 
 */
public class QS001_50211_201504Design extends QS001ServicePanelSogo {
  //GUIコンポーネント

  private JTabbedPane preventiveVisitCareMultiPatterns;

  private ACPanel tab1;

  private ACLabelContainer insurerContainer;

  private ACComboBox insurerName;

  private ACComboBoxModelAdapter insurerNameModel;

  private ACComboBox servicePattern;

  private ACComboBoxModelAdapter servicePatternModel;

  private ACValueArrayRadioButtonGroup visitCareExpenseAddRadio;

  private ACLabelContainer visitCareExpenseAddRadioContainer;

  private ACListModelAdapter visitCareExpenseAddRadioModel;

  private ACRadioButtonItem visitCareExpenseAddRadioItem1;

  private ACRadioButtonItem visitCareExpenseAddRadioItem2;

  private ACRadioButtonItem visitCareExpenseAddRadioItem3;

  private ACRadioButtonItem visitCareExpenseAddRadioItem4;

  private ACRadioButtonItem visitCareExpenseAddRadioItem5;

  private ACRadioButtonItem visitCareExpenseAddRadioItem6;

  private ACRadioButtonItem visitCareExpenseAddRadioItem7;

  private ACValueArrayRadioButtonGroup classEmploymentAddRadio;

  private ACLabelContainer classEmploymentAddRadioContainer;

  private ACListModelAdapter classEmploymentAddRadioModel;

  private ACRadioButtonItem classEmploymentAddRadioItem1;

  private ACRadioButtonItem classEmploymentAddRadioItem2;

  private ACValueArrayRadioButtonGroup visitDemandRadioGroup;

  private ACLabelContainer visitDemandRadioGroupContainer;

  private ACListModelAdapter visitDemandRadioGroupModel;

  private ACRadioButtonItem visitDemandRadioItem1;

  private ACRadioButtonItem visitDemandRadioItem2;

  private ACValueArrayRadioButtonGroup houmonKaigoFirstAddRadioGroup;

  private ACLabelContainer houmonKaigoFirstAddRadioGroupContainer;

  private ACListModelAdapter houmonKaigoFirstAddRadioGroupModel;

  private ACRadioButtonItem houmonKaigoFirstAddRadioItem1;

  private ACRadioButtonItem houmonKaigoFirstAddRadioItem2;

  private ACValueArrayRadioButtonGroup rehabilitationProAddRadioGroup;

  private ACLabelContainer rehabilitationProAddRadioGroupContainer;

  private ACListModelAdapter rehabilitationProAddRadioGroupModel;

  private ACRadioButtonItem rehabilitationProAddRadioItem1;

  private ACRadioButtonItem rehabilitationProAddRadioItem2;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRafioRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRafioRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRafioRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaRafioItem1;

  private ACRadioButtonItem providerAddMountainousAreaRafioRadioItem2;

  private ACIntegerCheckBox crackOnDayCheck;

  private ACIntegerCheckBox printable;

  private ACBackLabelContainer houmonKaigoTimeContainer;

  private ACTimeComboBox houmonKaigoBeginTime;

  private ACLabelContainer houmonKaigoBeginTimeContainer;

  private ACComboBoxModelAdapter houmonKaigoBeginTimeModel;

  private ACTimeComboBox houmonKaigoEndTime;

  private ACLabelContainer houmonKaigoEndTimeContainer;

  private ACComboBoxModelAdapter houmonKaigoEndTimeModel;

  private ACPanel tab2;

  private ACGroupBox infoGroup;

  private ACLabel infoLabel;

  //getter

  /**
   * 訪問型サービスパターン領域を取得します。
   * @return 訪問型サービスパターン領域
   */
  public JTabbedPane getPreventiveVisitCareMultiPatterns(){
    if(preventiveVisitCareMultiPatterns==null){

      preventiveVisitCareMultiPatterns = new JTabbedPane();

      addPreventiveVisitCareMultiPatterns();
    }
    return preventiveVisitCareMultiPatterns;

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

      servicePattern.setBindPath("5020106");

      servicePattern.setEditable(false);

      servicePattern.setColumns(5);

      servicePattern.setModelBindPath("5020106");

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
   * 訪問型サービス費を取得します。
   * @return 訪問型サービス費
   */
  public ACValueArrayRadioButtonGroup getVisitCareExpenseAddRadio(){
    if(visitCareExpenseAddRadio==null){

      visitCareExpenseAddRadio = new ACValueArrayRadioButtonGroup();

      getVisitCareExpenseAddRadioContainer().setText("訪問型" + ACConstants.LINE_SEPARATOR + "サービス費");

      visitCareExpenseAddRadio.setBindPath("5020101");

      visitCareExpenseAddRadio.setUseClearButton(false);

      visitCareExpenseAddRadio.setModel(getVisitCareExpenseAddRadioModel());

      visitCareExpenseAddRadio.setValues(new int[]{1,2,3,4,5,6,7});

      addVisitCareExpenseAddRadio();
    }
    return visitCareExpenseAddRadio;

  }

  /**
   * 訪問型サービス費コンテナを取得します。
   * @return 訪問型サービス費コンテナ
   */
  protected ACLabelContainer getVisitCareExpenseAddRadioContainer(){
    if(visitCareExpenseAddRadioContainer==null){
      visitCareExpenseAddRadioContainer = new ACLabelContainer();
      visitCareExpenseAddRadioContainer.setFollowChildEnabled(true);
      visitCareExpenseAddRadioContainer.setVAlignment(VRLayout.CENTER);
      visitCareExpenseAddRadioContainer.add(getVisitCareExpenseAddRadio(), null);
    }
    return visitCareExpenseAddRadioContainer;
  }

  /**
   * 訪問型サービス費モデルを取得します。
   * @return 訪問型サービス費モデル
   */
  protected ACListModelAdapter getVisitCareExpenseAddRadioModel(){
    if(visitCareExpenseAddRadioModel==null){
      visitCareExpenseAddRadioModel = new ACListModelAdapter();
      addVisitCareExpenseAddRadioModel();
    }
    return visitCareExpenseAddRadioModel;
  }

  /**
   * Ⅰ型を取得します。
   * @return Ⅰ型
   */
  public ACRadioButtonItem getVisitCareExpenseAddRadioItem1(){
    if(visitCareExpenseAddRadioItem1==null){

      visitCareExpenseAddRadioItem1 = new ACRadioButtonItem();

      visitCareExpenseAddRadioItem1.setText("I型");

      visitCareExpenseAddRadioItem1.setGroup(getVisitCareExpenseAddRadio());

      visitCareExpenseAddRadioItem1.setConstraints(VRLayout.FLOW);

      addVisitCareExpenseAddRadioItem1();
    }
    return visitCareExpenseAddRadioItem1;

  }

  /**
   * Ⅱ型を取得します。
   * @return Ⅱ型
   */
  public ACRadioButtonItem getVisitCareExpenseAddRadioItem2(){
    if(visitCareExpenseAddRadioItem2==null){

      visitCareExpenseAddRadioItem2 = new ACRadioButtonItem();

      visitCareExpenseAddRadioItem2.setText("II型");

      visitCareExpenseAddRadioItem2.setGroup(getVisitCareExpenseAddRadio());

      visitCareExpenseAddRadioItem2.setConstraints(VRLayout.FLOW);

      addVisitCareExpenseAddRadioItem2();
    }
    return visitCareExpenseAddRadioItem2;

  }

  /**
   * Ⅲ型を取得します。
   * @return Ⅲ型
   */
  public ACRadioButtonItem getVisitCareExpenseAddRadioItem3(){
    if(visitCareExpenseAddRadioItem3==null){

      visitCareExpenseAddRadioItem3 = new ACRadioButtonItem();

      visitCareExpenseAddRadioItem3.setText("III型");

      visitCareExpenseAddRadioItem3.setGroup(getVisitCareExpenseAddRadio());

      visitCareExpenseAddRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addVisitCareExpenseAddRadioItem3();
    }
    return visitCareExpenseAddRadioItem3;

  }

  /**
   * Ⅳ型を取得します。
   * @return Ⅳ型
   */
  public ACRadioButtonItem getVisitCareExpenseAddRadioItem4(){
    if(visitCareExpenseAddRadioItem4==null){

      visitCareExpenseAddRadioItem4 = new ACRadioButtonItem();

      visitCareExpenseAddRadioItem4.setText("IV型");

      visitCareExpenseAddRadioItem4.setGroup(getVisitCareExpenseAddRadio());

      visitCareExpenseAddRadioItem4.setConstraints(VRLayout.FLOW);

      addVisitCareExpenseAddRadioItem4();
    }
    return visitCareExpenseAddRadioItem4;

  }

  /**
   * Ⅴ型を取得します。
   * @return Ⅴ型
   */
  public ACRadioButtonItem getVisitCareExpenseAddRadioItem5(){
    if(visitCareExpenseAddRadioItem5==null){

      visitCareExpenseAddRadioItem5 = new ACRadioButtonItem();

      visitCareExpenseAddRadioItem5.setText("V型");

      visitCareExpenseAddRadioItem5.setGroup(getVisitCareExpenseAddRadio());

      visitCareExpenseAddRadioItem5.setConstraints(VRLayout.FLOW);

      addVisitCareExpenseAddRadioItem5();
    }
    return visitCareExpenseAddRadioItem5;

  }

  /**
   * Ⅵ型を取得します。
   * @return Ⅵ型
   */
  public ACRadioButtonItem getVisitCareExpenseAddRadioItem6(){
    if(visitCareExpenseAddRadioItem6==null){

      visitCareExpenseAddRadioItem6 = new ACRadioButtonItem();

      visitCareExpenseAddRadioItem6.setText("VI型");

      visitCareExpenseAddRadioItem6.setGroup(getVisitCareExpenseAddRadio());

      visitCareExpenseAddRadioItem6.setConstraints(VRLayout.FLOW);

      addVisitCareExpenseAddRadioItem6();
    }
    return visitCareExpenseAddRadioItem6;

  }

  /**
   * 短時間型を取得します。
   * @return 短時間型
   */
  public ACRadioButtonItem getVisitCareExpenseAddRadioItem7(){
    if(visitCareExpenseAddRadioItem7==null){

      visitCareExpenseAddRadioItem7 = new ACRadioButtonItem();

      visitCareExpenseAddRadioItem7.setText("短時間型");

      visitCareExpenseAddRadioItem7.setGroup(getVisitCareExpenseAddRadio());

      visitCareExpenseAddRadioItem7.setConstraints(VRLayout.FLOW);

      addVisitCareExpenseAddRadioItem7();
    }
    return visitCareExpenseAddRadioItem7;

  }

  /**
   * サービス提供責任者の級職を取得します。
   * @return サービス提供責任者の級職
   */
  public ACValueArrayRadioButtonGroup getClassEmploymentAddRadio(){
    if(classEmploymentAddRadio==null){

      classEmploymentAddRadio = new ACValueArrayRadioButtonGroup();

      getClassEmploymentAddRadioContainer().setText("サービス提供責任者の級職");

      classEmploymentAddRadio.setBindPath("5020102");

      classEmploymentAddRadio.setUseClearButton(false);

      classEmploymentAddRadio.setModel(getClassEmploymentAddRadioModel());

      classEmploymentAddRadio.setValues(new int[]{1,2});

      addClassEmploymentAddRadio();
    }
    return classEmploymentAddRadio;

  }

  /**
   * サービス提供責任者の級職コンテナを取得します。
   * @return サービス提供責任者の級職コンテナ
   */
  protected ACLabelContainer getClassEmploymentAddRadioContainer(){
    if(classEmploymentAddRadioContainer==null){
      classEmploymentAddRadioContainer = new ACLabelContainer();
      classEmploymentAddRadioContainer.setFollowChildEnabled(true);
      classEmploymentAddRadioContainer.setVAlignment(VRLayout.CENTER);
      classEmploymentAddRadioContainer.add(getClassEmploymentAddRadio(), null);
    }
    return classEmploymentAddRadioContainer;
  }

  /**
   * サービス提供責任者の級職モデルを取得します。
   * @return サービス提供責任者の級職モデル
   */
  protected ACListModelAdapter getClassEmploymentAddRadioModel(){
    if(classEmploymentAddRadioModel==null){
      classEmploymentAddRadioModel = new ACListModelAdapter();
      addClassEmploymentAddRadioModel();
    }
    return classEmploymentAddRadioModel;
  }

  /**
   * 初任以外を取得します。
   * @return 初任以外
   */
  public ACRadioButtonItem getClassEmploymentAddRadioItem1(){
    if(classEmploymentAddRadioItem1==null){

      classEmploymentAddRadioItem1 = new ACRadioButtonItem();

      classEmploymentAddRadioItem1.setText("初任以外");

      classEmploymentAddRadioItem1.setGroup(getClassEmploymentAddRadio());

      classEmploymentAddRadioItem1.setConstraints(VRLayout.FLOW);

      addClassEmploymentAddRadioItem1();
    }
    return classEmploymentAddRadioItem1;

  }

  /**
   * 初任を取得します。
   * @return 初任
   */
  public ACRadioButtonItem getClassEmploymentAddRadioItem2(){
    if(classEmploymentAddRadioItem2==null){

      classEmploymentAddRadioItem2 = new ACRadioButtonItem();

      classEmploymentAddRadioItem2.setText("初任");

      classEmploymentAddRadioItem2.setGroup(getClassEmploymentAddRadio());

      classEmploymentAddRadioItem2.setConstraints(VRLayout.FLOW);

      addClassEmploymentAddRadioItem2();
    }
    return classEmploymentAddRadioItem2;

  }

  /**
   * 同一建物居住者へのサービス提供を取得します。
   * @return 同一建物居住者へのサービス提供
   */
  public ACValueArrayRadioButtonGroup getVisitDemandRadioGroup(){
    if(visitDemandRadioGroup==null){

      visitDemandRadioGroup = new ACValueArrayRadioButtonGroup();

      getVisitDemandRadioGroupContainer().setText("同一建物居住者へのサービス提供");

      visitDemandRadioGroup.setBindPath("16");

      visitDemandRadioGroup.setUseClearButton(false);

      visitDemandRadioGroup.setModel(getVisitDemandRadioGroupModel());

      visitDemandRadioGroup.setValues(new int[]{1,2});

      addVisitDemandRadioGroup();
    }
    return visitDemandRadioGroup;

  }

  /**
   * 同一建物居住者へのサービス提供コンテナを取得します。
   * @return 同一建物居住者へのサービス提供コンテナ
   */
  protected ACLabelContainer getVisitDemandRadioGroupContainer(){
    if(visitDemandRadioGroupContainer==null){
      visitDemandRadioGroupContainer = new ACLabelContainer();
      visitDemandRadioGroupContainer.setFollowChildEnabled(true);
      visitDemandRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      visitDemandRadioGroupContainer.add(getVisitDemandRadioGroup(), null);
    }
    return visitDemandRadioGroupContainer;
  }

  /**
   * 同一建物居住者へのサービス提供モデルを取得します。
   * @return 同一建物居住者へのサービス提供モデル
   */
  protected ACListModelAdapter getVisitDemandRadioGroupModel(){
    if(visitDemandRadioGroupModel==null){
      visitDemandRadioGroupModel = new ACListModelAdapter();
      addVisitDemandRadioGroupModel();
    }
    return visitDemandRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getVisitDemandRadioItem1(){
    if(visitDemandRadioItem1==null){

      visitDemandRadioItem1 = new ACRadioButtonItem();

      visitDemandRadioItem1.setText("なし");

      visitDemandRadioItem1.setGroup(getVisitDemandRadioGroup());

      visitDemandRadioItem1.setConstraints(VRLayout.FLOW);

      addVisitDemandRadioItem1();
    }
    return visitDemandRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getVisitDemandRadioItem2(){
    if(visitDemandRadioItem2==null){

      visitDemandRadioItem2 = new ACRadioButtonItem();

      visitDemandRadioItem2.setText("あり");

      visitDemandRadioItem2.setGroup(getVisitDemandRadioGroup());

      visitDemandRadioItem2.setConstraints(VRLayout.FLOW);

      addVisitDemandRadioItem2();
    }
    return visitDemandRadioItem2;

  }

  /**
   * 初回加算を取得します。
   * @return 初回加算
   */
  public ACValueArrayRadioButtonGroup getHoumonKaigoFirstAddRadioGroup(){
    if(houmonKaigoFirstAddRadioGroup==null){

      houmonKaigoFirstAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getHoumonKaigoFirstAddRadioGroupContainer().setText("初回加算");

      houmonKaigoFirstAddRadioGroup.setBindPath("5020104");

      houmonKaigoFirstAddRadioGroup.setNoSelectIndex(0);

      houmonKaigoFirstAddRadioGroup.setUseClearButton(false);

      houmonKaigoFirstAddRadioGroup.setModel(getHoumonKaigoFirstAddRadioGroupModel());

      houmonKaigoFirstAddRadioGroup.setValues(new int[]{1,2});

      addHoumonKaigoFirstAddRadioGroup();
    }
    return houmonKaigoFirstAddRadioGroup;

  }

  /**
   * 初回加算コンテナを取得します。
   * @return 初回加算コンテナ
   */
  protected ACLabelContainer getHoumonKaigoFirstAddRadioGroupContainer(){
    if(houmonKaigoFirstAddRadioGroupContainer==null){
      houmonKaigoFirstAddRadioGroupContainer = new ACLabelContainer();
      houmonKaigoFirstAddRadioGroupContainer.setFollowChildEnabled(true);
      houmonKaigoFirstAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      houmonKaigoFirstAddRadioGroupContainer.add(getHoumonKaigoFirstAddRadioGroup(), null);
    }
    return houmonKaigoFirstAddRadioGroupContainer;
  }

  /**
   * 初回加算モデルを取得します。
   * @return 初回加算モデル
   */
  protected ACListModelAdapter getHoumonKaigoFirstAddRadioGroupModel(){
    if(houmonKaigoFirstAddRadioGroupModel==null){
      houmonKaigoFirstAddRadioGroupModel = new ACListModelAdapter();
      addHoumonKaigoFirstAddRadioGroupModel();
    }
    return houmonKaigoFirstAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonKaigoFirstAddRadioItem1(){
    if(houmonKaigoFirstAddRadioItem1==null){

      houmonKaigoFirstAddRadioItem1 = new ACRadioButtonItem();

      houmonKaigoFirstAddRadioItem1.setText("なし");

      houmonKaigoFirstAddRadioItem1.setGroup(getHoumonKaigoFirstAddRadioGroup());

      houmonKaigoFirstAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonKaigoFirstAddRadioItem1();
    }
    return houmonKaigoFirstAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonKaigoFirstAddRadioItem2(){
    if(houmonKaigoFirstAddRadioItem2==null){

      houmonKaigoFirstAddRadioItem2 = new ACRadioButtonItem();

      houmonKaigoFirstAddRadioItem2.setText("あり");

      houmonKaigoFirstAddRadioItem2.setGroup(getHoumonKaigoFirstAddRadioGroup());

      houmonKaigoFirstAddRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonKaigoFirstAddRadioItem2();
    }
    return houmonKaigoFirstAddRadioItem2;

  }

  /**
   * 生活機能向上連携加算を取得します。
   * @return 生活機能向上連携加算
   */
  public ACValueArrayRadioButtonGroup getRehabilitationProAddRadioGroup(){
    if(rehabilitationProAddRadioGroup==null){

      rehabilitationProAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getRehabilitationProAddRadioGroupContainer().setText("生活機能向上連携加算");

      rehabilitationProAddRadioGroup.setBindPath("5020105");

      rehabilitationProAddRadioGroup.setNoSelectIndex(0);

      rehabilitationProAddRadioGroup.setUseClearButton(false);

      rehabilitationProAddRadioGroup.setModel(getRehabilitationProAddRadioGroupModel());

      rehabilitationProAddRadioGroup.setValues(new int[]{1,2});

      addRehabilitationProAddRadioGroup();
    }
    return rehabilitationProAddRadioGroup;

  }

  /**
   * 生活機能向上連携加算コンテナを取得します。
   * @return 生活機能向上連携加算コンテナ
   */
  protected ACLabelContainer getRehabilitationProAddRadioGroupContainer(){
    if(rehabilitationProAddRadioGroupContainer==null){
      rehabilitationProAddRadioGroupContainer = new ACLabelContainer();
      rehabilitationProAddRadioGroupContainer.setFollowChildEnabled(true);
      rehabilitationProAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      rehabilitationProAddRadioGroupContainer.add(getRehabilitationProAddRadioGroup(), null);
    }
    return rehabilitationProAddRadioGroupContainer;
  }

  /**
   * 生活機能向上連携加算モデルを取得します。
   * @return 生活機能向上連携加算モデル
   */
  protected ACListModelAdapter getRehabilitationProAddRadioGroupModel(){
    if(rehabilitationProAddRadioGroupModel==null){
      rehabilitationProAddRadioGroupModel = new ACListModelAdapter();
      addRehabilitationProAddRadioGroupModel();
    }
    return rehabilitationProAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getRehabilitationProAddRadioItem1(){
    if(rehabilitationProAddRadioItem1==null){

      rehabilitationProAddRadioItem1 = new ACRadioButtonItem();

      rehabilitationProAddRadioItem1.setText("なし");

      rehabilitationProAddRadioItem1.setGroup(getRehabilitationProAddRadioGroup());

      rehabilitationProAddRadioItem1.setConstraints(VRLayout.FLOW);

      addRehabilitationProAddRadioItem1();
    }
    return rehabilitationProAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getRehabilitationProAddRadioItem2(){
    if(rehabilitationProAddRadioItem2==null){

      rehabilitationProAddRadioItem2 = new ACRadioButtonItem();

      rehabilitationProAddRadioItem2.setText("あり");

      rehabilitationProAddRadioItem2.setGroup(getRehabilitationProAddRadioGroup());

      rehabilitationProAddRadioItem2.setConstraints(VRLayout.FLOW);

      addRehabilitationProAddRadioItem2();
    }
    return rehabilitationProAddRadioItem2;

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
  public ACRadioButtonItem getProviderAddMountainousAreaRafioItem1(){
    if(providerAddMountainousAreaRafioItem1==null){

      providerAddMountainousAreaRafioItem1 = new ACRadioButtonItem();

      providerAddMountainousAreaRafioItem1.setText("なし");

      providerAddMountainousAreaRafioItem1.setGroup(getProviderAddMountainousAreaRafioRadioGroup());

      providerAddMountainousAreaRafioItem1.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaRafioItem1();
    }
    return providerAddMountainousAreaRafioItem1;

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
   * 日割を取得します。
   * @return 日割
   */
  public ACIntegerCheckBox getCrackOnDayCheck(){
    if(crackOnDayCheck==null){

      crackOnDayCheck = new ACIntegerCheckBox();

      crackOnDayCheck.setText("日割");

      crackOnDayCheck.setBindPath("5020103");

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
  public ACLabel getInfoLabel(){
    if(infoLabel==null){

      infoLabel = new ACLabel();

      infoLabel.setText("月途中で区分変更となる場合（要支援1⇔要支援2、" + ACConstants.LINE_SEPARATOR + "事業対象者→要支援）各日割りサービスを全ての日に" + ACConstants.LINE_SEPARATOR + "貼り付け、実際の提供日には『提供日』にチェック後" + ACConstants.LINE_SEPARATOR + "〔設定〕ボタンをクリックしてください。");

      addInfoLabel();
    }
    return infoLabel;

  }

  /**
   * コンストラクタです。
   */
  public QS001_50211_201504Design() {

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

    this.add(getPreventiveVisitCareMultiPatterns(), VRLayout.CLIENT);

  }

  /**
   * 訪問型サービスパターン領域に内部項目を追加します。
   */
  protected void addPreventiveVisitCareMultiPatterns(){

    preventiveVisitCareMultiPatterns.addTab("1", getTab1());

    preventiveVisitCareMultiPatterns.addTab("2", getTab2());

  }

  /**
   * タブ1に内部項目を追加します。
   */
  protected void addTab1(){

    tab1.add(getInsurerContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getVisitCareExpenseAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getClassEmploymentAddRadioContainer(), VRLayout.FLOW_RETURN);

    tab1.add(getVisitDemandRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKaigoFirstAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getRehabilitationProAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getProviderAddMountainousAreaRafioRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getCrackOnDayCheck(), VRLayout.FLOW);

    tab1.add(getPrintable(), VRLayout.FLOW_RETURN);

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
   * 訪問型サービス費に内部項目を追加します。
   */
  protected void addVisitCareExpenseAddRadio(){

  }

  /**
   * 訪問型サービス費モデルに内部項目を追加します。
   */
  protected void addVisitCareExpenseAddRadioModel(){

    getVisitCareExpenseAddRadioItem1().setButtonIndex(1);

    getVisitCareExpenseAddRadioModel().add(getVisitCareExpenseAddRadioItem1());

    getVisitCareExpenseAddRadioItem2().setButtonIndex(2);

    getVisitCareExpenseAddRadioModel().add(getVisitCareExpenseAddRadioItem2());

    getVisitCareExpenseAddRadioItem3().setButtonIndex(3);

    getVisitCareExpenseAddRadioModel().add(getVisitCareExpenseAddRadioItem3());

    getVisitCareExpenseAddRadioItem4().setButtonIndex(4);

    getVisitCareExpenseAddRadioModel().add(getVisitCareExpenseAddRadioItem4());

    getVisitCareExpenseAddRadioItem5().setButtonIndex(5);

    getVisitCareExpenseAddRadioModel().add(getVisitCareExpenseAddRadioItem5());

    getVisitCareExpenseAddRadioItem6().setButtonIndex(6);

    getVisitCareExpenseAddRadioModel().add(getVisitCareExpenseAddRadioItem6());

    getVisitCareExpenseAddRadioItem7().setButtonIndex(7);

    getVisitCareExpenseAddRadioModel().add(getVisitCareExpenseAddRadioItem7());

  }

  /**
   * Ⅰ型に内部項目を追加します。
   */
  protected void addVisitCareExpenseAddRadioItem1(){

  }

  /**
   * Ⅱ型に内部項目を追加します。
   */
  protected void addVisitCareExpenseAddRadioItem2(){

  }

  /**
   * Ⅲ型に内部項目を追加します。
   */
  protected void addVisitCareExpenseAddRadioItem3(){

  }

  /**
   * Ⅳ型に内部項目を追加します。
   */
  protected void addVisitCareExpenseAddRadioItem4(){

  }

  /**
   * Ⅴ型に内部項目を追加します。
   */
  protected void addVisitCareExpenseAddRadioItem5(){

  }

  /**
   * Ⅵ型に内部項目を追加します。
   */
  protected void addVisitCareExpenseAddRadioItem6(){

  }

  /**
   * 短時間型に内部項目を追加します。
   */
  protected void addVisitCareExpenseAddRadioItem7(){

  }

  /**
   * サービス提供責任者の級職に内部項目を追加します。
   */
  protected void addClassEmploymentAddRadio(){

  }

  /**
   * サービス提供責任者の級職モデルに内部項目を追加します。
   */
  protected void addClassEmploymentAddRadioModel(){

    getClassEmploymentAddRadioItem1().setButtonIndex(1);

    getClassEmploymentAddRadioModel().add(getClassEmploymentAddRadioItem1());

    getClassEmploymentAddRadioItem2().setButtonIndex(2);

    getClassEmploymentAddRadioModel().add(getClassEmploymentAddRadioItem2());

  }

  /**
   * 初任以外に内部項目を追加します。
   */
  protected void addClassEmploymentAddRadioItem1(){

  }

  /**
   * 初任に内部項目を追加します。
   */
  protected void addClassEmploymentAddRadioItem2(){

  }

  /**
   * 同一建物居住者へのサービス提供に内部項目を追加します。
   */
  protected void addVisitDemandRadioGroup(){

  }

  /**
   * 同一建物居住者へのサービス提供モデルに内部項目を追加します。
   */
  protected void addVisitDemandRadioGroupModel(){

    getVisitDemandRadioItem1().setButtonIndex(1);

    getVisitDemandRadioGroupModel().add(getVisitDemandRadioItem1());

    getVisitDemandRadioItem2().setButtonIndex(2);

    getVisitDemandRadioGroupModel().add(getVisitDemandRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addVisitDemandRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addVisitDemandRadioItem2(){

  }

  /**
   * 初回加算に内部項目を追加します。
   */
  protected void addHoumonKaigoFirstAddRadioGroup(){

  }

  /**
   * 初回加算モデルに内部項目を追加します。
   */
  protected void addHoumonKaigoFirstAddRadioGroupModel(){

    getHoumonKaigoFirstAddRadioItem1().setButtonIndex(1);

    getHoumonKaigoFirstAddRadioGroupModel().add(getHoumonKaigoFirstAddRadioItem1());

    getHoumonKaigoFirstAddRadioItem2().setButtonIndex(2);

    getHoumonKaigoFirstAddRadioGroupModel().add(getHoumonKaigoFirstAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonKaigoFirstAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonKaigoFirstAddRadioItem2(){

  }

  /**
   * 生活機能向上連携加算に内部項目を追加します。
   */
  protected void addRehabilitationProAddRadioGroup(){

  }

  /**
   * 生活機能向上連携加算モデルに内部項目を追加します。
   */
  protected void addRehabilitationProAddRadioGroupModel(){

    getRehabilitationProAddRadioItem1().setButtonIndex(1);

    getRehabilitationProAddRadioGroupModel().add(getRehabilitationProAddRadioItem1());

    getRehabilitationProAddRadioItem2().setButtonIndex(2);

    getRehabilitationProAddRadioGroupModel().add(getRehabilitationProAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addRehabilitationProAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addRehabilitationProAddRadioItem2(){

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

    getProviderAddMountainousAreaRafioItem1().setButtonIndex(1);

    getProviderAddMountainousAreaRafioRadioGroupModel().add(getProviderAddMountainousAreaRafioItem1());

    getProviderAddMountainousAreaRafioRadioItem2().setButtonIndex(2);

    getProviderAddMountainousAreaRafioRadioGroupModel().add(getProviderAddMountainousAreaRafioRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRafioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRafioRadioItem2(){

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
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getInfoGroup(), VRLayout.FLOW);

  }

  /**
   * 注意書きグループに内部項目を追加します。
   */
  protected void addInfoGroup(){

    infoGroup.add(getInfoLabel(), VRLayout.FLOW);

  }

  /**
   * 注意書きラベルに内部項目を追加します。
   */
  protected void addInfoLabel(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_50211_201504Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_50211_201504Design getThis() {
    return this;
  }
}
