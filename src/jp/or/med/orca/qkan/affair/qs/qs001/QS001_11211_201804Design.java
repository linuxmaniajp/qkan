
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
 * 作成日: 2018/02/04  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン訪問入浴介護 (QS001_11211_201804)
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
 * サービスパターン訪問入浴介護画面項目デザイン(QS001_11211_201804) 
 */
public class QS001_11211_201804Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel homonNyuyokuPatterns;

  private ACValueArrayRadioButtonGroup homonNyuyokuClass;

  private ACLabelContainer homonNyuyokuClassContainer;

  private ACListModelAdapter homonNyuyokuClassModel;

  private ACRadioButtonItem homonNyuyokuClassDouble;

  private ACRadioButtonItem homonNyuyokuClassSingle;

  private ACValueArrayRadioButtonGroup homonNyuyokuPartsRadio;

  private ACLabelContainer homonNyuyokuPartsRadioContainer;

  private ACListModelAdapter homonNyuyokuPartsRadioModel;

  private ACRadioButtonItem homonNyuyokuPartsRadioItem1;

  private ACRadioButtonItem homonNyuyokuPartsRadioItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRafioRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRafioRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRafioRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaRafioItem1;

  private ACRadioButtonItem providerAddMountainousAreaRafioRadioItem2;

  private ACValueArrayRadioButtonGroup houmonNeededRadio;

  private ACLabelContainer houmonNeededRadioContainer;

  private ACListModelAdapter houmonNeededRadioModel;

  private ACRadioButtonItem houmonNeededRadioItem1;

  private ACRadioButtonItem houmonNeededRadioItem2;

  private ACRadioButtonItem houmonNeededRadioItem3;

  private ACBackLabelContainer homonNyuyokuTimeContainer;

  private ACTimeComboBox homonNyuyokuBeginTime;

  private ACLabelContainer homonNyuyokuBeginTimeContainer;

  private ACComboBoxModelAdapter homonNyuyokuBeginTimeModel;

  private ACTimeComboBox homonNyuyokuEndTime;

  private ACLabelContainer homonNyuyokuEndTimeContainer;

  private ACComboBoxModelAdapter homonNyuyokuEndTimeModel;

  //getter

  /**
   * 訪問入浴介護パターン領域を取得します。
   * @return 訪問入浴介護パターン領域
   */
  public ACPanel getHomonNyuyokuPatterns(){
    if(homonNyuyokuPatterns==null){

      homonNyuyokuPatterns = new ACPanel();

      homonNyuyokuPatterns.setFollowChildEnabled(true);

      addHomonNyuyokuPatterns();
    }
    return homonNyuyokuPatterns;

  }

  /**
   * 訪問者の種別ラジオグループを取得します。
   * @return 訪問者の種別ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getHomonNyuyokuClass(){
    if(homonNyuyokuClass==null){

      homonNyuyokuClass = new ACValueArrayRadioButtonGroup();

      getHomonNyuyokuClassContainer().setText("訪問者の人数");

      homonNyuyokuClass.setBindPath("1120103");

      homonNyuyokuClass.setUseClearButton(false);

      homonNyuyokuClass.setModel(getHomonNyuyokuClassModel());

      homonNyuyokuClass.setValues(new int[]{1,2});

      addHomonNyuyokuClass();
    }
    return homonNyuyokuClass;

  }

  /**
   * 訪問者の種別ラジオグループコンテナを取得します。
   * @return 訪問者の種別ラジオグループコンテナ
   */
  protected ACLabelContainer getHomonNyuyokuClassContainer(){
    if(homonNyuyokuClassContainer==null){
      homonNyuyokuClassContainer = new ACLabelContainer();
      homonNyuyokuClassContainer.setFollowChildEnabled(true);
      homonNyuyokuClassContainer.setVAlignment(VRLayout.CENTER);
      homonNyuyokuClassContainer.add(getHomonNyuyokuClass(), null);
    }
    return homonNyuyokuClassContainer;
  }

  /**
   * 訪問者の種別ラジオグループモデルを取得します。
   * @return 訪問者の種別ラジオグループモデル
   */
  protected ACListModelAdapter getHomonNyuyokuClassModel(){
    if(homonNyuyokuClassModel==null){
      homonNyuyokuClassModel = new ACListModelAdapter();
      addHomonNyuyokuClassModel();
    }
    return homonNyuyokuClassModel;
  }

  /**
   * 看護職員1人＋介護職員2人を取得します。
   * @return 看護職員1人＋介護職員2人
   */
  public ACRadioButtonItem getHomonNyuyokuClassDouble(){
    if(homonNyuyokuClassDouble==null){

      homonNyuyokuClassDouble = new ACRadioButtonItem();

      homonNyuyokuClassDouble.setText("看護職員1人及び介護職員2人");

      homonNyuyokuClassDouble.setGroup(getHomonNyuyokuClass());

      homonNyuyokuClassDouble.setConstraints(VRLayout.FLOW_RETURN);

      addHomonNyuyokuClassDouble();
    }
    return homonNyuyokuClassDouble;

  }

  /**
   * 介護職員3人を取得します。
   * @return 介護職員3人
   */
  public ACRadioButtonItem getHomonNyuyokuClassSingle(){
    if(homonNyuyokuClassSingle==null){

      homonNyuyokuClassSingle = new ACRadioButtonItem();

      homonNyuyokuClassSingle.setText("介護職員3人");

      homonNyuyokuClassSingle.setGroup(getHomonNyuyokuClass());

      homonNyuyokuClassSingle.setConstraints(VRLayout.FLOW);

      addHomonNyuyokuClassSingle();
    }
    return homonNyuyokuClassSingle;

  }

  /**
   * 訪問入浴介護区分ラジオグループを取得します。
   * @return 訪問入浴介護区分ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getHomonNyuyokuPartsRadio(){
    if(homonNyuyokuPartsRadio==null){

      homonNyuyokuPartsRadio = new ACValueArrayRadioButtonGroup();

      getHomonNyuyokuPartsRadioContainer().setText("入浴介護区分");

      homonNyuyokuPartsRadio.setBindPath("1120104");

      homonNyuyokuPartsRadio.setUseClearButton(false);

      homonNyuyokuPartsRadio.setModel(getHomonNyuyokuPartsRadioModel());

      homonNyuyokuPartsRadio.setValues(new int[]{1,2});

      addHomonNyuyokuPartsRadio();
    }
    return homonNyuyokuPartsRadio;

  }

  /**
   * 訪問入浴介護区分ラジオグループコンテナを取得します。
   * @return 訪問入浴介護区分ラジオグループコンテナ
   */
  protected ACLabelContainer getHomonNyuyokuPartsRadioContainer(){
    if(homonNyuyokuPartsRadioContainer==null){
      homonNyuyokuPartsRadioContainer = new ACLabelContainer();
      homonNyuyokuPartsRadioContainer.setFollowChildEnabled(true);
      homonNyuyokuPartsRadioContainer.setVAlignment(VRLayout.CENTER);
      homonNyuyokuPartsRadioContainer.add(getHomonNyuyokuPartsRadio(), null);
    }
    return homonNyuyokuPartsRadioContainer;
  }

  /**
   * 訪問入浴介護区分ラジオグループモデルを取得します。
   * @return 訪問入浴介護区分ラジオグループモデル
   */
  protected ACListModelAdapter getHomonNyuyokuPartsRadioModel(){
    if(homonNyuyokuPartsRadioModel==null){
      homonNyuyokuPartsRadioModel = new ACListModelAdapter();
      addHomonNyuyokuPartsRadioModel();
    }
    return homonNyuyokuPartsRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHomonNyuyokuPartsRadioItem1(){
    if(homonNyuyokuPartsRadioItem1==null){

      homonNyuyokuPartsRadioItem1 = new ACRadioButtonItem();

      homonNyuyokuPartsRadioItem1.setText("なし");

      homonNyuyokuPartsRadioItem1.setGroup(getHomonNyuyokuPartsRadio());

      homonNyuyokuPartsRadioItem1.setConstraints(VRLayout.FLOW);

      addHomonNyuyokuPartsRadioItem1();
    }
    return homonNyuyokuPartsRadioItem1;

  }

  /**
   * 部分浴・清拭のみを取得します。
   * @return 部分浴・清拭のみ
   */
  public ACRadioButtonItem getHomonNyuyokuPartsRadioItem2(){
    if(homonNyuyokuPartsRadioItem2==null){

      homonNyuyokuPartsRadioItem2 = new ACRadioButtonItem();

      homonNyuyokuPartsRadioItem2.setText("部分浴・清拭のみ");

      homonNyuyokuPartsRadioItem2.setGroup(getHomonNyuyokuPartsRadio());

      homonNyuyokuPartsRadioItem2.setConstraints(VRLayout.FLOW);

      addHomonNyuyokuPartsRadioItem2();
    }
    return homonNyuyokuPartsRadioItem2;

  }

  /**
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1120105");

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,3,2});

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
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem3(){
    if(serviceAddProvisionStructuralRadioItem3==null){

      serviceAddProvisionStructuralRadioItem3 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem3.setText("Iイ型");

      serviceAddProvisionStructuralRadioItem3.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem3();
    }
    return serviceAddProvisionStructuralRadioItem3;

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
   * 提供時間コンテナを取得します。
   * @return 提供時間コンテナ
   */
  public ACBackLabelContainer getHomonNyuyokuTimeContainer(){
    if(homonNyuyokuTimeContainer==null){

      homonNyuyokuTimeContainer = new ACBackLabelContainer();

      homonNyuyokuTimeContainer.setFollowChildEnabled(true);

      addHomonNyuyokuTimeContainer();
    }
    return homonNyuyokuTimeContainer;

  }

  /**
   * 開始時刻コンボを取得します。
   * @return 開始時刻コンボ
   */
  public ACTimeComboBox getHomonNyuyokuBeginTime(){
    if(homonNyuyokuBeginTime==null){

      homonNyuyokuBeginTime = new ACTimeComboBox();

      getHomonNyuyokuBeginTimeContainer().setText("開始時刻");

      homonNyuyokuBeginTime.setBindPath("3");

      homonNyuyokuBeginTime.setModelBindPath("3");

      homonNyuyokuBeginTime.setRenderBindPath("CONTENT");

      homonNyuyokuBeginTime.setModel(getHomonNyuyokuBeginTimeModel());

      addHomonNyuyokuBeginTime();
    }
    return homonNyuyokuBeginTime;

  }

  /**
   * 開始時刻コンボコンテナを取得します。
   * @return 開始時刻コンボコンテナ
   */
  protected ACLabelContainer getHomonNyuyokuBeginTimeContainer(){
    if(homonNyuyokuBeginTimeContainer==null){
      homonNyuyokuBeginTimeContainer = new ACLabelContainer();
      homonNyuyokuBeginTimeContainer.setFollowChildEnabled(true);
      homonNyuyokuBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      homonNyuyokuBeginTimeContainer.add(getHomonNyuyokuBeginTime(), null);
    }
    return homonNyuyokuBeginTimeContainer;
  }

  /**
   * 開始時刻コンボモデルを取得します。
   * @return 開始時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getHomonNyuyokuBeginTimeModel(){
    if(homonNyuyokuBeginTimeModel==null){
      homonNyuyokuBeginTimeModel = new ACComboBoxModelAdapter();
      addHomonNyuyokuBeginTimeModel();
    }
    return homonNyuyokuBeginTimeModel;
  }

  /**
   * 終了時刻コンボを取得します。
   * @return 終了時刻コンボ
   */
  public ACTimeComboBox getHomonNyuyokuEndTime(){
    if(homonNyuyokuEndTime==null){

      homonNyuyokuEndTime = new ACTimeComboBox();

      getHomonNyuyokuEndTimeContainer().setText("終了時刻");

      homonNyuyokuEndTime.setBindPath("4");

      homonNyuyokuEndTime.setModelBindPath("4");

      homonNyuyokuEndTime.setRenderBindPath("CONTENT");

      homonNyuyokuEndTime.setModel(getHomonNyuyokuEndTimeModel());

      addHomonNyuyokuEndTime();
    }
    return homonNyuyokuEndTime;

  }

  /**
   * 終了時刻コンボコンテナを取得します。
   * @return 終了時刻コンボコンテナ
   */
  protected ACLabelContainer getHomonNyuyokuEndTimeContainer(){
    if(homonNyuyokuEndTimeContainer==null){
      homonNyuyokuEndTimeContainer = new ACLabelContainer();
      homonNyuyokuEndTimeContainer.setFollowChildEnabled(true);
      homonNyuyokuEndTimeContainer.setVAlignment(VRLayout.CENTER);
      homonNyuyokuEndTimeContainer.add(getHomonNyuyokuEndTime(), null);
    }
    return homonNyuyokuEndTimeContainer;
  }

  /**
   * 終了時刻コンボモデルを取得します。
   * @return 終了時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getHomonNyuyokuEndTimeModel(){
    if(homonNyuyokuEndTimeModel==null){
      homonNyuyokuEndTimeModel = new ACComboBoxModelAdapter();
      addHomonNyuyokuEndTimeModel();
    }
    return homonNyuyokuEndTimeModel;
  }

  /**
   * コンストラクタです。
   */
  public QS001_11211_201804Design() {

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

    this.add(getHomonNyuyokuPatterns(), VRLayout.CLIENT);

  }

  /**
   * 訪問入浴介護パターン領域に内部項目を追加します。
   */
  protected void addHomonNyuyokuPatterns(){

    homonNyuyokuPatterns.add(getHomonNyuyokuClassContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    homonNyuyokuPatterns.add(getHomonNyuyokuPartsRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    homonNyuyokuPatterns.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    homonNyuyokuPatterns.add(getProviderAddMountainousAreaRafioRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    homonNyuyokuPatterns.add(getHoumonNeededRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    homonNyuyokuPatterns.add(getHomonNyuyokuTimeContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * 訪問者の種別ラジオグループに内部項目を追加します。
   */
  protected void addHomonNyuyokuClass(){

  }

  /**
   * 訪問者の種別ラジオグループモデルに内部項目を追加します。
   */
  protected void addHomonNyuyokuClassModel(){

    getHomonNyuyokuClassDouble().setButtonIndex(1);

    getHomonNyuyokuClassModel().add(getHomonNyuyokuClassDouble());

    getHomonNyuyokuClassSingle().setButtonIndex(2);

    getHomonNyuyokuClassModel().add(getHomonNyuyokuClassSingle());

  }

  /**
   * 看護職員1人＋介護職員2人に内部項目を追加します。
   */
  protected void addHomonNyuyokuClassDouble(){

  }

  /**
   * 介護職員3人に内部項目を追加します。
   */
  protected void addHomonNyuyokuClassSingle(){

  }

  /**
   * 訪問入浴介護区分ラジオグループに内部項目を追加します。
   */
  protected void addHomonNyuyokuPartsRadio(){

  }

  /**
   * 訪問入浴介護区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addHomonNyuyokuPartsRadioModel(){

    getHomonNyuyokuPartsRadioItem1().setButtonIndex(1);

    getHomonNyuyokuPartsRadioModel().add(getHomonNyuyokuPartsRadioItem1());

    getHomonNyuyokuPartsRadioItem2().setButtonIndex(2);

    getHomonNyuyokuPartsRadioModel().add(getHomonNyuyokuPartsRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHomonNyuyokuPartsRadioItem1(){

  }

  /**
   * 部分浴・清拭のみに内部項目を追加します。
   */
  protected void addHomonNyuyokuPartsRadioItem2(){

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

    getServiceAddProvisionStructuralRadioItem3().setButtonIndex(3);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem3());

    getServiceAddProvisionStructuralRadioItem2().setButtonIndex(2);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * Iイ型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem3(){

  }

  /**
   * Iロ型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

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
   * 提供時間コンテナに内部項目を追加します。
   */
  protected void addHomonNyuyokuTimeContainer(){

    homonNyuyokuTimeContainer.add(getHomonNyuyokuBeginTimeContainer(), VRLayout.FLOW);

    homonNyuyokuTimeContainer.add(getHomonNyuyokuEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * 開始時刻コンボに内部項目を追加します。
   */
  protected void addHomonNyuyokuBeginTime(){

  }

  /**
   * 開始時刻コンボモデルに内部項目を追加します。
   */
  protected void addHomonNyuyokuBeginTimeModel(){

  }

  /**
   * 終了時刻コンボに内部項目を追加します。
   */
  protected void addHomonNyuyokuEndTime(){

  }

  /**
   * 終了時刻コンボモデルに内部項目を追加します。
   */
  protected void addHomonNyuyokuEndTimeModel(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_11211_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_11211_201804Design getThis() {
    return this;
  }
}
