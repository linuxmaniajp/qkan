
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
 * 作成日: 2009/03/06  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン居宅介護支援 (QS001117_H2104)
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
 * サービスパターン居宅介護支援画面項目デザイン(QS001117_H2104) 
 */
public class QS001117_H2104Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel kaigoSupportPattern;

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACClearableRadioButtonGroup kaigoSupportDivisionRadio;

  private ACLabelContainer kaigoSupportDivisionRadioContainer;

  private ACListModelAdapter kaigoSupportDivisionRadioModel;

  private ACRadioButtonItem kaigoSupportDivisionRadioItem1;

  private ACRadioButtonItem kaigoSupportDivisionRadioItem2;

  private ACRadioButtonItem kaigoSupportDivisionRadioItem3;

  private ACClearableRadioButtonGroup kaigoSupportManagementBasicRadio;

  private ACLabelContainer kaigoSupportManagementBasicRadioContainer;

  private ACListModelAdapter kaigoSupportManagementBasicRadioModel;

  private ACRadioButtonItem kaigoSupportManagementBasicRadioItem1;

  private ACRadioButtonItem kaigoSupportManagementBasicRadioItem2;

  private ACRadioButtonItem kaigoSupportManagementBasicRadioItem3;

  private ACValueArrayRadioButtonGroup kaigoSupportSpecificProviderSubtractionRadio;

  private ACLabelContainer kaigoSupportSpecificProviderSubtractionRadioContainer;

  private ACListModelAdapter kaigoSupportSpecificProviderSubtractionRadioModel;

  private ACRadioButtonItem kaigoSupportSpecificProviderSubtractionRadioItem1;

  private ACRadioButtonItem kaigoSupportSpecificProviderSubtractionRadioItem2;

  private ACValueArrayRadioButtonGroup kaigoSupportStandardRadio;

  private ACLabelContainer kaigoSupportStandardRadioContainer;

  private ACListModelAdapter kaigoSupportStandardRadioModel;

  private ACRadioButtonItem kaigoSupportStandardRadioItem1;

  private ACRadioButtonItem kaigoSupportStandardRadioItem2;

  private ACValueArrayRadioButtonGroup dischargeAddRadio;

  private ACLabelContainer dischargeAddRadioContainer;

  private ACListModelAdapter dischargeAddRadioModel;

  private ACRadioButtonItem dischargeAddRadioItem1;

  private ACRadioButtonItem dischargeAddRadioItem2;

  private ACRadioButtonItem dischargeAddRadioItem3;

  private ACValueArrayRadioButtonGroup kaigoSupportSpecificStandardRadio;

  private ACLabelContainer kaigoSupportSpecificStandardRadioContainer;

  private ACListModelAdapter kaigoSupportSpecificStandardRadioModel;

  private ACRadioButtonItem kaigoSupportSpecificStandardRadioItem1;

  private ACRadioButtonItem kaigoSupportSpecificStandardRadioItem2;

  private ACRadioButtonItem kaigoSupportSpecificStandardRadioItem3;

  private ACValueArrayRadioButtonGroup medicalCoordinateAddRadioGroup;

  private ACLabelContainer medicalCoordinateAddRadioGroupContainer;

  private ACListModelAdapter medicalCoordinateAddRadioGroupModel;

  private ACRadioButtonItem medicalCoordinateAddRadioItem1;

  private ACRadioButtonItem medicalCoordinateAddRadioItem2;

  private ACValueArrayRadioButtonGroup dementiaAddRadioGroup;

  private ACLabelContainer dementiaAddRadioGroupContainer;

  private ACListModelAdapter dementiaAddRadioGroupModel;

  private ACRadioButtonItem dementiaAddRadioItem1;

  private ACRadioButtonItem dementiaAddRadioItem2;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup solitaryOldPeopleRadioGroup;

  private ACLabelContainer solitaryOldPeopleRadioGroupContainer;

  private ACListModelAdapter solitaryOldPeopleRadioGroupModel;

  private ACRadioButtonItem solitaryOldPeopleRadioItem1;

  private ACRadioButtonItem solitaryOldPeopleRadioItem2;

  private ACValueArrayRadioButtonGroup smallScaleProviderHelpAddRadioGroup;

  private ACLabelContainer smallScaleProviderHelpAddRadioGroupContainer;

  private ACListModelAdapter smallScaleProviderHelpAddRadioGroupModel;

  private ACRadioButtonItem smallScaleProviderHelpAddRadioItem1;

  private ACRadioButtonItem smallScaleProviderHelpAddRadioItem2;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRafioRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRafioRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRafioRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaRafioItem1;

  private ACRadioButtonItem providerAddMountainousAreaRafioRadioItem2;

  private ACGroupBox kaigoSupportSpecialMemberContainer;

  private ACTextField kaigoSupportSpecialMemberNumber;

  private ACLabelContainer kaigoSupportSpecialMemberNumberContainer;

  private ACComboBox kaigoSupportSpecialMemberName;

  private ACLabelContainer kaigoSupportSpecialMemberNameContainer;

  private ACComboBoxModelAdapter kaigoSupportSpecialMemberNameModel;

  //getter

  /**
   * 居宅介護支援領域を取得します。
   * @return 居宅介護支援領域
   */
  public ACPanel getKaigoSupportPattern(){
    if(kaigoSupportPattern==null){

      kaigoSupportPattern = new ACPanel();

      kaigoSupportPattern.setAutoWrap(false);

      addKaigoSupportPattern();
    }
    return kaigoSupportPattern;

  }

  /**
   * タブパネルを取得します。
   * @return タブパネル
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

      tab1.setLabelMargin(0);

      tab1.setVgap(0);

      addTab1();
    }
    return tab1;

  }

  /**
   * 居宅介護支援費を取得します。
   * @return 居宅介護支援費
   */
  public ACClearableRadioButtonGroup getKaigoSupportDivisionRadio(){
    if(kaigoSupportDivisionRadio==null){

      kaigoSupportDivisionRadio = new ACClearableRadioButtonGroup();

      getKaigoSupportDivisionRadioContainer().setText("居宅介護支援費");

      kaigoSupportDivisionRadio.setBindPath("1430103");

      kaigoSupportDivisionRadio.setUseClearButton(false);

      kaigoSupportDivisionRadio.setModel(getKaigoSupportDivisionRadioModel());

      addKaigoSupportDivisionRadio();
    }
    return kaigoSupportDivisionRadio;

  }

  /**
   * 居宅介護支援費コンテナを取得します。
   * @return 居宅介護支援費コンテナ
   */
  protected ACLabelContainer getKaigoSupportDivisionRadioContainer(){
    if(kaigoSupportDivisionRadioContainer==null){
      kaigoSupportDivisionRadioContainer = new ACLabelContainer();
      kaigoSupportDivisionRadioContainer.setFollowChildEnabled(true);
      kaigoSupportDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportDivisionRadioContainer.add(getKaigoSupportDivisionRadio(), null);
    }
    return kaigoSupportDivisionRadioContainer;
  }

  /**
   * 居宅介護支援費モデルを取得します。
   * @return 居宅介護支援費モデル
   */
  protected ACListModelAdapter getKaigoSupportDivisionRadioModel(){
    if(kaigoSupportDivisionRadioModel==null){
      kaigoSupportDivisionRadioModel = new ACListModelAdapter();
      addKaigoSupportDivisionRadioModel();
    }
    return kaigoSupportDivisionRadioModel;
  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getKaigoSupportDivisionRadioItem1(){
    if(kaigoSupportDivisionRadioItem1==null){

      kaigoSupportDivisionRadioItem1 = new ACRadioButtonItem();

      kaigoSupportDivisionRadioItem1.setText("I型");

      kaigoSupportDivisionRadioItem1.setGroup(getKaigoSupportDivisionRadio());

      kaigoSupportDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoSupportDivisionRadioItem1();
    }
    return kaigoSupportDivisionRadioItem1;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getKaigoSupportDivisionRadioItem2(){
    if(kaigoSupportDivisionRadioItem2==null){

      kaigoSupportDivisionRadioItem2 = new ACRadioButtonItem();

      kaigoSupportDivisionRadioItem2.setText("II型");

      kaigoSupportDivisionRadioItem2.setGroup(getKaigoSupportDivisionRadio());

      kaigoSupportDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoSupportDivisionRadioItem2();
    }
    return kaigoSupportDivisionRadioItem2;

  }

  /**
   * III型を取得します。
   * @return III型
   */
  public ACRadioButtonItem getKaigoSupportDivisionRadioItem3(){
    if(kaigoSupportDivisionRadioItem3==null){

      kaigoSupportDivisionRadioItem3 = new ACRadioButtonItem();

      kaigoSupportDivisionRadioItem3.setText("III型");

      kaigoSupportDivisionRadioItem3.setGroup(getKaigoSupportDivisionRadio());

      kaigoSupportDivisionRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoSupportDivisionRadioItem3();
    }
    return kaigoSupportDivisionRadioItem3;

  }

  /**
   * 運営基準減算を取得します。
   * @return 運営基準減算
   */
  public ACClearableRadioButtonGroup getKaigoSupportManagementBasicRadio(){
    if(kaigoSupportManagementBasicRadio==null){

      kaigoSupportManagementBasicRadio = new ACClearableRadioButtonGroup();

      getKaigoSupportManagementBasicRadioContainer().setText("運営基準減算");

      kaigoSupportManagementBasicRadio.setBindPath("1430101");

      kaigoSupportManagementBasicRadio.setUseClearButton(false);

      kaigoSupportManagementBasicRadio.setModel(getKaigoSupportManagementBasicRadioModel());

      addKaigoSupportManagementBasicRadio();
    }
    return kaigoSupportManagementBasicRadio;

  }

  /**
   * 運営基準減算コンテナを取得します。
   * @return 運営基準減算コンテナ
   */
  protected ACLabelContainer getKaigoSupportManagementBasicRadioContainer(){
    if(kaigoSupportManagementBasicRadioContainer==null){
      kaigoSupportManagementBasicRadioContainer = new ACLabelContainer();
      kaigoSupportManagementBasicRadioContainer.setFollowChildEnabled(true);
      kaigoSupportManagementBasicRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportManagementBasicRadioContainer.add(getKaigoSupportManagementBasicRadio(), null);
    }
    return kaigoSupportManagementBasicRadioContainer;
  }

  /**
   * 運営基準減算モデルを取得します。
   * @return 運営基準減算モデル
   */
  protected ACListModelAdapter getKaigoSupportManagementBasicRadioModel(){
    if(kaigoSupportManagementBasicRadioModel==null){
      kaigoSupportManagementBasicRadioModel = new ACListModelAdapter();
      addKaigoSupportManagementBasicRadioModel();
    }
    return kaigoSupportManagementBasicRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoSupportManagementBasicRadioItem1(){
    if(kaigoSupportManagementBasicRadioItem1==null){

      kaigoSupportManagementBasicRadioItem1 = new ACRadioButtonItem();

      kaigoSupportManagementBasicRadioItem1.setText("なし");

      kaigoSupportManagementBasicRadioItem1.setGroup(getKaigoSupportManagementBasicRadio());

      kaigoSupportManagementBasicRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoSupportManagementBasicRadioItem1();
    }
    return kaigoSupportManagementBasicRadioItem1;

  }

  /**
   * 減算要件該当を取得します。
   * @return 減算要件該当
   */
  public ACRadioButtonItem getKaigoSupportManagementBasicRadioItem2(){
    if(kaigoSupportManagementBasicRadioItem2==null){

      kaigoSupportManagementBasicRadioItem2 = new ACRadioButtonItem();

      kaigoSupportManagementBasicRadioItem2.setText("I型");

      kaigoSupportManagementBasicRadioItem2.setGroup(getKaigoSupportManagementBasicRadio());

      kaigoSupportManagementBasicRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoSupportManagementBasicRadioItem2();
    }
    return kaigoSupportManagementBasicRadioItem2;

  }

  /**
   * 減算要件該当が2ヶ月以上を取得します。
   * @return 減算要件該当が2ヶ月以上
   */
  public ACRadioButtonItem getKaigoSupportManagementBasicRadioItem3(){
    if(kaigoSupportManagementBasicRadioItem3==null){

      kaigoSupportManagementBasicRadioItem3 = new ACRadioButtonItem();

      kaigoSupportManagementBasicRadioItem3.setText("II型(I型の減算が2ヶ月以上継続)");

      kaigoSupportManagementBasicRadioItem3.setGroup(getKaigoSupportManagementBasicRadio());

      kaigoSupportManagementBasicRadioItem3.setConstraints(VRLayout.FLOW);

      addKaigoSupportManagementBasicRadioItem3();
    }
    return kaigoSupportManagementBasicRadioItem3;

  }

  /**
   * 特定事業所集中減算を取得します。
   * @return 特定事業所集中減算
   */
  public ACValueArrayRadioButtonGroup getKaigoSupportSpecificProviderSubtractionRadio(){
    if(kaigoSupportSpecificProviderSubtractionRadio==null){

      kaigoSupportSpecificProviderSubtractionRadio = new ACValueArrayRadioButtonGroup();

      getKaigoSupportSpecificProviderSubtractionRadioContainer().setText("特定事業所集中減算");

      kaigoSupportSpecificProviderSubtractionRadio.setBindPath("1430104");

      kaigoSupportSpecificProviderSubtractionRadio.setNoSelectIndex(0);

      kaigoSupportSpecificProviderSubtractionRadio.setUseClearButton(false);

      kaigoSupportSpecificProviderSubtractionRadio.setModel(getKaigoSupportSpecificProviderSubtractionRadioModel());

      kaigoSupportSpecificProviderSubtractionRadio.setValues(new int[]{1,2});

      addKaigoSupportSpecificProviderSubtractionRadio();
    }
    return kaigoSupportSpecificProviderSubtractionRadio;

  }

  /**
   * 特定事業所集中減算コンテナを取得します。
   * @return 特定事業所集中減算コンテナ
   */
  protected ACLabelContainer getKaigoSupportSpecificProviderSubtractionRadioContainer(){
    if(kaigoSupportSpecificProviderSubtractionRadioContainer==null){
      kaigoSupportSpecificProviderSubtractionRadioContainer = new ACLabelContainer();
      kaigoSupportSpecificProviderSubtractionRadioContainer.setFollowChildEnabled(true);
      kaigoSupportSpecificProviderSubtractionRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportSpecificProviderSubtractionRadioContainer.add(getKaigoSupportSpecificProviderSubtractionRadio(), null);
    }
    return kaigoSupportSpecificProviderSubtractionRadioContainer;
  }

  /**
   * 特定事業所集中減算モデルを取得します。
   * @return 特定事業所集中減算モデル
   */
  protected ACListModelAdapter getKaigoSupportSpecificProviderSubtractionRadioModel(){
    if(kaigoSupportSpecificProviderSubtractionRadioModel==null){
      kaigoSupportSpecificProviderSubtractionRadioModel = new ACListModelAdapter();
      addKaigoSupportSpecificProviderSubtractionRadioModel();
    }
    return kaigoSupportSpecificProviderSubtractionRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoSupportSpecificProviderSubtractionRadioItem1(){
    if(kaigoSupportSpecificProviderSubtractionRadioItem1==null){

      kaigoSupportSpecificProviderSubtractionRadioItem1 = new ACRadioButtonItem();

      kaigoSupportSpecificProviderSubtractionRadioItem1.setText("なし");

      kaigoSupportSpecificProviderSubtractionRadioItem1.setGroup(getKaigoSupportSpecificProviderSubtractionRadio());

      kaigoSupportSpecificProviderSubtractionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoSupportSpecificProviderSubtractionRadioItem1();
    }
    return kaigoSupportSpecificProviderSubtractionRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKaigoSupportSpecificProviderSubtractionRadioItem2(){
    if(kaigoSupportSpecificProviderSubtractionRadioItem2==null){

      kaigoSupportSpecificProviderSubtractionRadioItem2 = new ACRadioButtonItem();

      kaigoSupportSpecificProviderSubtractionRadioItem2.setText("あり");

      kaigoSupportSpecificProviderSubtractionRadioItem2.setGroup(getKaigoSupportSpecificProviderSubtractionRadio());

      kaigoSupportSpecificProviderSubtractionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoSupportSpecificProviderSubtractionRadioItem2();
    }
    return kaigoSupportSpecificProviderSubtractionRadioItem2;

  }

  /**
   * 初回加算を取得します。
   * @return 初回加算
   */
  public ACValueArrayRadioButtonGroup getKaigoSupportStandardRadio(){
    if(kaigoSupportStandardRadio==null){

      kaigoSupportStandardRadio = new ACValueArrayRadioButtonGroup();

      getKaigoSupportStandardRadioContainer().setText("初回加算");

      kaigoSupportStandardRadio.setBindPath("1430108");

      kaigoSupportStandardRadio.setNoSelectIndex(0);

      kaigoSupportStandardRadio.setUseClearButton(false);

      kaigoSupportStandardRadio.setModel(getKaigoSupportStandardRadioModel());

      kaigoSupportStandardRadio.setValues(new int[]{1,2});

      addKaigoSupportStandardRadio();
    }
    return kaigoSupportStandardRadio;

  }

  /**
   * 初回加算コンテナを取得します。
   * @return 初回加算コンテナ
   */
  protected ACLabelContainer getKaigoSupportStandardRadioContainer(){
    if(kaigoSupportStandardRadioContainer==null){
      kaigoSupportStandardRadioContainer = new ACLabelContainer();
      kaigoSupportStandardRadioContainer.setFollowChildEnabled(true);
      kaigoSupportStandardRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportStandardRadioContainer.add(getKaigoSupportStandardRadio(), null);
    }
    return kaigoSupportStandardRadioContainer;
  }

  /**
   * 初回加算モデルを取得します。
   * @return 初回加算モデル
   */
  protected ACListModelAdapter getKaigoSupportStandardRadioModel(){
    if(kaigoSupportStandardRadioModel==null){
      kaigoSupportStandardRadioModel = new ACListModelAdapter();
      addKaigoSupportStandardRadioModel();
    }
    return kaigoSupportStandardRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoSupportStandardRadioItem1(){
    if(kaigoSupportStandardRadioItem1==null){

      kaigoSupportStandardRadioItem1 = new ACRadioButtonItem();

      kaigoSupportStandardRadioItem1.setText("なし");

      kaigoSupportStandardRadioItem1.setGroup(getKaigoSupportStandardRadio());

      kaigoSupportStandardRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoSupportStandardRadioItem1();
    }
    return kaigoSupportStandardRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKaigoSupportStandardRadioItem2(){
    if(kaigoSupportStandardRadioItem2==null){

      kaigoSupportStandardRadioItem2 = new ACRadioButtonItem();

      kaigoSupportStandardRadioItem2.setText("あり");

      kaigoSupportStandardRadioItem2.setGroup(getKaigoSupportStandardRadio());

      kaigoSupportStandardRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoSupportStandardRadioItem2();
    }
    return kaigoSupportStandardRadioItem2;

  }

  /**
   * 退院・退所加算を取得します。
   * @return 退院・退所加算
   */
  public ACValueArrayRadioButtonGroup getDischargeAddRadio(){
    if(dischargeAddRadio==null){

      dischargeAddRadio = new ACValueArrayRadioButtonGroup();

      getDischargeAddRadioContainer().setText("退院・退所加算");

      dischargeAddRadio.setBindPath("1430113");

      dischargeAddRadio.setNoSelectIndex(0);

      dischargeAddRadio.setUseClearButton(false);

      dischargeAddRadio.setModel(getDischargeAddRadioModel());

      dischargeAddRadio.setValues(new int[]{1,2,3});

      addDischargeAddRadio();
    }
    return dischargeAddRadio;

  }

  /**
   * 退院・退所加算コンテナを取得します。
   * @return 退院・退所加算コンテナ
   */
  protected ACLabelContainer getDischargeAddRadioContainer(){
    if(dischargeAddRadioContainer==null){
      dischargeAddRadioContainer = new ACLabelContainer();
      dischargeAddRadioContainer.setFollowChildEnabled(true);
      dischargeAddRadioContainer.setVAlignment(VRLayout.CENTER);
      dischargeAddRadioContainer.add(getDischargeAddRadio(), null);
    }
    return dischargeAddRadioContainer;
  }

  /**
   * 退院・退所加算モデルを取得します。
   * @return 退院・退所加算モデル
   */
  protected ACListModelAdapter getDischargeAddRadioModel(){
    if(dischargeAddRadioModel==null){
      dischargeAddRadioModel = new ACListModelAdapter();
      addDischargeAddRadioModel();
    }
    return dischargeAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getDischargeAddRadioItem1(){
    if(dischargeAddRadioItem1==null){

      dischargeAddRadioItem1 = new ACRadioButtonItem();

      dischargeAddRadioItem1.setText("なし");

      dischargeAddRadioItem1.setGroup(getDischargeAddRadio());

      dischargeAddRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addDischargeAddRadioItem1();
    }
    return dischargeAddRadioItem1;

  }

  /**
   * 退院・退所時（I型）を取得します。
   * @return 退院・退所時（I型）
   */
  public ACRadioButtonItem getDischargeAddRadioItem2(){
    if(dischargeAddRadioItem2==null){

      dischargeAddRadioItem2 = new ACRadioButtonItem();

      dischargeAddRadioItem2.setText("退院・退所時（I型）");

      dischargeAddRadioItem2.setGroup(getDischargeAddRadio());

      dischargeAddRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addDischargeAddRadioItem2();
    }
    return dischargeAddRadioItem2;

  }

  /**
   * 退院・退所時（II型）を取得します。
   * @return 退院・退所時（II型）
   */
  public ACRadioButtonItem getDischargeAddRadioItem3(){
    if(dischargeAddRadioItem3==null){

      dischargeAddRadioItem3 = new ACRadioButtonItem();

      dischargeAddRadioItem3.setText("退院・退所時（II型）");

      dischargeAddRadioItem3.setGroup(getDischargeAddRadio());

      dischargeAddRadioItem3.setConstraints(VRLayout.FLOW);

      addDischargeAddRadioItem3();
    }
    return dischargeAddRadioItem3;

  }

  /**
   * 特定事業所加算を取得します。
   * @return 特定事業所加算
   */
  public ACValueArrayRadioButtonGroup getKaigoSupportSpecificStandardRadio(){
    if(kaigoSupportSpecificStandardRadio==null){

      kaigoSupportSpecificStandardRadio = new ACValueArrayRadioButtonGroup();

      getKaigoSupportSpecificStandardRadioContainer().setText("特定事業所加算");

      kaigoSupportSpecificStandardRadio.setBindPath("1430106");

      kaigoSupportSpecificStandardRadio.setNoSelectIndex(0);

      kaigoSupportSpecificStandardRadio.setUseClearButton(false);

      kaigoSupportSpecificStandardRadio.setModel(getKaigoSupportSpecificStandardRadioModel());

      kaigoSupportSpecificStandardRadio.setValues(new int[]{1,2,3});

      addKaigoSupportSpecificStandardRadio();
    }
    return kaigoSupportSpecificStandardRadio;

  }

  /**
   * 特定事業所加算コンテナを取得します。
   * @return 特定事業所加算コンテナ
   */
  protected ACLabelContainer getKaigoSupportSpecificStandardRadioContainer(){
    if(kaigoSupportSpecificStandardRadioContainer==null){
      kaigoSupportSpecificStandardRadioContainer = new ACLabelContainer();
      kaigoSupportSpecificStandardRadioContainer.setFollowChildEnabled(true);
      kaigoSupportSpecificStandardRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportSpecificStandardRadioContainer.add(getKaigoSupportSpecificStandardRadio(), null);
    }
    return kaigoSupportSpecificStandardRadioContainer;
  }

  /**
   * 特定事業所加算モデルを取得します。
   * @return 特定事業所加算モデル
   */
  protected ACListModelAdapter getKaigoSupportSpecificStandardRadioModel(){
    if(kaigoSupportSpecificStandardRadioModel==null){
      kaigoSupportSpecificStandardRadioModel = new ACListModelAdapter();
      addKaigoSupportSpecificStandardRadioModel();
    }
    return kaigoSupportSpecificStandardRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKaigoSupportSpecificStandardRadioItem1(){
    if(kaigoSupportSpecificStandardRadioItem1==null){

      kaigoSupportSpecificStandardRadioItem1 = new ACRadioButtonItem();

      kaigoSupportSpecificStandardRadioItem1.setText("なし");

      kaigoSupportSpecificStandardRadioItem1.setGroup(getKaigoSupportSpecificStandardRadio());

      kaigoSupportSpecificStandardRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoSupportSpecificStandardRadioItem1();
    }
    return kaigoSupportSpecificStandardRadioItem1;

  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getKaigoSupportSpecificStandardRadioItem2(){
    if(kaigoSupportSpecificStandardRadioItem2==null){

      kaigoSupportSpecificStandardRadioItem2 = new ACRadioButtonItem();

      kaigoSupportSpecificStandardRadioItem2.setText("I型");

      kaigoSupportSpecificStandardRadioItem2.setGroup(getKaigoSupportSpecificStandardRadio());

      kaigoSupportSpecificStandardRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoSupportSpecificStandardRadioItem2();
    }
    return kaigoSupportSpecificStandardRadioItem2;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getKaigoSupportSpecificStandardRadioItem3(){
    if(kaigoSupportSpecificStandardRadioItem3==null){

      kaigoSupportSpecificStandardRadioItem3 = new ACRadioButtonItem();

      kaigoSupportSpecificStandardRadioItem3.setText("II型");

      kaigoSupportSpecificStandardRadioItem3.setGroup(getKaigoSupportSpecificStandardRadio());

      kaigoSupportSpecificStandardRadioItem3.setConstraints(VRLayout.FLOW);

      addKaigoSupportSpecificStandardRadioItem3();
    }
    return kaigoSupportSpecificStandardRadioItem3;

  }

  /**
   * 医療機関連携加算を取得します。
   * @return 医療機関連携加算
   */
  public ACValueArrayRadioButtonGroup getMedicalCoordinateAddRadioGroup(){
    if(medicalCoordinateAddRadioGroup==null){

      medicalCoordinateAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getMedicalCoordinateAddRadioGroupContainer().setText("医療機関連携加算");

      medicalCoordinateAddRadioGroup.setBindPath("1430109");

      medicalCoordinateAddRadioGroup.setNoSelectIndex(0);

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
   * 認知症加算を取得します。
   * @return 認知症加算
   */
  public ACValueArrayRadioButtonGroup getDementiaAddRadioGroup(){
    if(dementiaAddRadioGroup==null){

      dementiaAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaAddRadioGroupContainer().setText("認知症加算");

      dementiaAddRadioGroup.setBindPath("1430110");

      dementiaAddRadioGroup.setNoSelectIndex(0);

      dementiaAddRadioGroup.setUseClearButton(false);

      dementiaAddRadioGroup.setModel(getDementiaAddRadioGroupModel());

      dementiaAddRadioGroup.setValues(new int[]{1,2});

      addDementiaAddRadioGroup();
    }
    return dementiaAddRadioGroup;

  }

  /**
   * 認知症加算コンテナを取得します。
   * @return 認知症加算コンテナ
   */
  protected ACLabelContainer getDementiaAddRadioGroupContainer(){
    if(dementiaAddRadioGroupContainer==null){
      dementiaAddRadioGroupContainer = new ACLabelContainer();
      dementiaAddRadioGroupContainer.setFollowChildEnabled(true);
      dementiaAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      dementiaAddRadioGroupContainer.add(getDementiaAddRadioGroup(), null);
    }
    return dementiaAddRadioGroupContainer;
  }

  /**
   * 認知症加算モデルを取得します。
   * @return 認知症加算モデル
   */
  protected ACListModelAdapter getDementiaAddRadioGroupModel(){
    if(dementiaAddRadioGroupModel==null){
      dementiaAddRadioGroupModel = new ACListModelAdapter();
      addDementiaAddRadioGroupModel();
    }
    return dementiaAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getDementiaAddRadioItem1(){
    if(dementiaAddRadioItem1==null){

      dementiaAddRadioItem1 = new ACRadioButtonItem();

      dementiaAddRadioItem1.setText("なし");

      dementiaAddRadioItem1.setGroup(getDementiaAddRadioGroup());

      dementiaAddRadioItem1.setConstraints(VRLayout.FLOW);

      addDementiaAddRadioItem1();
    }
    return dementiaAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getDementiaAddRadioItem2(){
    if(dementiaAddRadioItem2==null){

      dementiaAddRadioItem2 = new ACRadioButtonItem();

      dementiaAddRadioItem2.setText("あり");

      dementiaAddRadioItem2.setGroup(getDementiaAddRadioGroup());

      dementiaAddRadioItem2.setConstraints(VRLayout.FLOW);

      addDementiaAddRadioItem2();
    }
    return dementiaAddRadioItem2;

  }

  /**
   * タブ2を取得します。
   * @return タブ2
   */
  public ACPanel getTab2(){
    if(tab2==null){

      tab2 = new ACPanel();

      tab2.setHgap(0);

      tab2.setLabelMargin(0);

      tab2.setVgap(0);

      addTab2();
    }
    return tab2;

  }

  /**
   * 独居高齢者加算を取得します。
   * @return 独居高齢者加算
   */
  public ACValueArrayRadioButtonGroup getSolitaryOldPeopleRadioGroup(){
    if(solitaryOldPeopleRadioGroup==null){

      solitaryOldPeopleRadioGroup = new ACValueArrayRadioButtonGroup();

      getSolitaryOldPeopleRadioGroupContainer().setText("独居高齢者加算");

      solitaryOldPeopleRadioGroup.setBindPath("1430111");

      solitaryOldPeopleRadioGroup.setNoSelectIndex(0);

      solitaryOldPeopleRadioGroup.setUseClearButton(false);

      solitaryOldPeopleRadioGroup.setModel(getSolitaryOldPeopleRadioGroupModel());

      solitaryOldPeopleRadioGroup.setValues(new int[]{1,2});

      addSolitaryOldPeopleRadioGroup();
    }
    return solitaryOldPeopleRadioGroup;

  }

  /**
   * 独居高齢者加算コンテナを取得します。
   * @return 独居高齢者加算コンテナ
   */
  protected ACLabelContainer getSolitaryOldPeopleRadioGroupContainer(){
    if(solitaryOldPeopleRadioGroupContainer==null){
      solitaryOldPeopleRadioGroupContainer = new ACLabelContainer();
      solitaryOldPeopleRadioGroupContainer.setFollowChildEnabled(true);
      solitaryOldPeopleRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      solitaryOldPeopleRadioGroupContainer.add(getSolitaryOldPeopleRadioGroup(), null);
    }
    return solitaryOldPeopleRadioGroupContainer;
  }

  /**
   * 独居高齢者加算モデルを取得します。
   * @return 独居高齢者加算モデル
   */
  protected ACListModelAdapter getSolitaryOldPeopleRadioGroupModel(){
    if(solitaryOldPeopleRadioGroupModel==null){
      solitaryOldPeopleRadioGroupModel = new ACListModelAdapter();
      addSolitaryOldPeopleRadioGroupModel();
    }
    return solitaryOldPeopleRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSolitaryOldPeopleRadioItem1(){
    if(solitaryOldPeopleRadioItem1==null){

      solitaryOldPeopleRadioItem1 = new ACRadioButtonItem();

      solitaryOldPeopleRadioItem1.setText("なし");

      solitaryOldPeopleRadioItem1.setGroup(getSolitaryOldPeopleRadioGroup());

      solitaryOldPeopleRadioItem1.setConstraints(VRLayout.FLOW);

      addSolitaryOldPeopleRadioItem1();
    }
    return solitaryOldPeopleRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getSolitaryOldPeopleRadioItem2(){
    if(solitaryOldPeopleRadioItem2==null){

      solitaryOldPeopleRadioItem2 = new ACRadioButtonItem();

      solitaryOldPeopleRadioItem2.setText("あり");

      solitaryOldPeopleRadioItem2.setGroup(getSolitaryOldPeopleRadioGroup());

      solitaryOldPeopleRadioItem2.setConstraints(VRLayout.FLOW);

      addSolitaryOldPeopleRadioItem2();
    }
    return solitaryOldPeopleRadioItem2;

  }

  /**
   * 小規模多機能型居宅介護事業所連携加算を取得します。
   * @return 小規模多機能型居宅介護事業所連携加算
   */
  public ACValueArrayRadioButtonGroup getSmallScaleProviderHelpAddRadioGroup(){
    if(smallScaleProviderHelpAddRadioGroup==null){

      smallScaleProviderHelpAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getSmallScaleProviderHelpAddRadioGroupContainer().setText("小規模多機能型居宅介護" + ACConstants.LINE_SEPARATOR + "事業所連携加算");

      smallScaleProviderHelpAddRadioGroup.setBindPath("1430112");

      smallScaleProviderHelpAddRadioGroup.setNoSelectIndex(0);

      smallScaleProviderHelpAddRadioGroup.setUseClearButton(false);

      smallScaleProviderHelpAddRadioGroup.setModel(getSmallScaleProviderHelpAddRadioGroupModel());

      smallScaleProviderHelpAddRadioGroup.setValues(new int[]{1,2});

      addSmallScaleProviderHelpAddRadioGroup();
    }
    return smallScaleProviderHelpAddRadioGroup;

  }

  /**
   * 小規模多機能型居宅介護事業所連携加算コンテナを取得します。
   * @return 小規模多機能型居宅介護事業所連携加算コンテナ
   */
  protected ACLabelContainer getSmallScaleProviderHelpAddRadioGroupContainer(){
    if(smallScaleProviderHelpAddRadioGroupContainer==null){
      smallScaleProviderHelpAddRadioGroupContainer = new ACLabelContainer();
      smallScaleProviderHelpAddRadioGroupContainer.setFollowChildEnabled(true);
      smallScaleProviderHelpAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      smallScaleProviderHelpAddRadioGroupContainer.add(getSmallScaleProviderHelpAddRadioGroup(), null);
    }
    return smallScaleProviderHelpAddRadioGroupContainer;
  }

  /**
   * 小規模多機能型居宅介護事業所連携加算モデルを取得します。
   * @return 小規模多機能型居宅介護事業所連携加算モデル
   */
  protected ACListModelAdapter getSmallScaleProviderHelpAddRadioGroupModel(){
    if(smallScaleProviderHelpAddRadioGroupModel==null){
      smallScaleProviderHelpAddRadioGroupModel = new ACListModelAdapter();
      addSmallScaleProviderHelpAddRadioGroupModel();
    }
    return smallScaleProviderHelpAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSmallScaleProviderHelpAddRadioItem1(){
    if(smallScaleProviderHelpAddRadioItem1==null){

      smallScaleProviderHelpAddRadioItem1 = new ACRadioButtonItem();

      smallScaleProviderHelpAddRadioItem1.setText("なし");

      smallScaleProviderHelpAddRadioItem1.setGroup(getSmallScaleProviderHelpAddRadioGroup());

      smallScaleProviderHelpAddRadioItem1.setConstraints(VRLayout.FLOW);

      addSmallScaleProviderHelpAddRadioItem1();
    }
    return smallScaleProviderHelpAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getSmallScaleProviderHelpAddRadioItem2(){
    if(smallScaleProviderHelpAddRadioItem2==null){

      smallScaleProviderHelpAddRadioItem2 = new ACRadioButtonItem();

      smallScaleProviderHelpAddRadioItem2.setText("あり");

      smallScaleProviderHelpAddRadioItem2.setGroup(getSmallScaleProviderHelpAddRadioGroup());

      smallScaleProviderHelpAddRadioItem2.setConstraints(VRLayout.FLOW);

      addSmallScaleProviderHelpAddRadioItem2();
    }
    return smallScaleProviderHelpAddRadioItem2;

  }

  /**
   * 中山間地域等でのサービス提供加算を取得します。
   * @return 中山間地域等でのサービス提供加算
   */
  public ACValueArrayRadioButtonGroup getProviderAddMountainousAreaRafioRadioGroup(){
    if(providerAddMountainousAreaRafioRadioGroup==null){

      providerAddMountainousAreaRafioRadioGroup = new ACValueArrayRadioButtonGroup();

      getProviderAddMountainousAreaRafioRadioGroupContainer().setText("中山間地域等でのサービス" + ACConstants.LINE_SEPARATOR + "提供加算");

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
   * 介護支援専門員コンテナを取得します。
   * @return 介護支援専門員コンテナ
   */
  public ACGroupBox getKaigoSupportSpecialMemberContainer(){
    if(kaigoSupportSpecialMemberContainer==null){

      kaigoSupportSpecialMemberContainer = new ACGroupBox();

      kaigoSupportSpecialMemberContainer.setText("介護支援専門員情報");

      addKaigoSupportSpecialMemberContainer();
    }
    return kaigoSupportSpecialMemberContainer;

  }

  /**
   * 介護支援専門員番号を取得します。
   * @return 介護支援専門員番号
   */
  public ACTextField getKaigoSupportSpecialMemberNumber(){
    if(kaigoSupportSpecialMemberNumber==null){

      kaigoSupportSpecialMemberNumber = new ACTextField();

      getKaigoSupportSpecialMemberNumberContainer().setText("介護支援専門員番号");

      kaigoSupportSpecialMemberNumber.setBindPath("1430107");

      kaigoSupportSpecialMemberNumber.setColumns(6);

      kaigoSupportSpecialMemberNumber.setCharType(VRCharType.ONLY_DIGIT);

      kaigoSupportSpecialMemberNumber.setMaxLength(8);

      addKaigoSupportSpecialMemberNumber();
    }
    return kaigoSupportSpecialMemberNumber;

  }

  /**
   * 介護支援専門員番号コンテナを取得します。
   * @return 介護支援専門員番号コンテナ
   */
  protected ACLabelContainer getKaigoSupportSpecialMemberNumberContainer(){
    if(kaigoSupportSpecialMemberNumberContainer==null){
      kaigoSupportSpecialMemberNumberContainer = new ACLabelContainer();
      kaigoSupportSpecialMemberNumberContainer.setFollowChildEnabled(true);
      kaigoSupportSpecialMemberNumberContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportSpecialMemberNumberContainer.add(getKaigoSupportSpecialMemberNumber(), null);
    }
    return kaigoSupportSpecialMemberNumberContainer;
  }

  /**
   * 介護支援専門員氏名を取得します。
   * @return 介護支援専門員氏名
   */
  public ACComboBox getKaigoSupportSpecialMemberName(){
    if(kaigoSupportSpecialMemberName==null){

      kaigoSupportSpecialMemberName = new ACComboBox();

      getKaigoSupportSpecialMemberNameContainer().setText("介護支援専門員氏名");

      kaigoSupportSpecialMemberName.setEditable(false);

      kaigoSupportSpecialMemberName.setRenderBindPath("STAFF_NAME");

      kaigoSupportSpecialMemberName.setMaxColumns(10);

      kaigoSupportSpecialMemberName.setModel(getKaigoSupportSpecialMemberNameModel());

      addKaigoSupportSpecialMemberName();
    }
    return kaigoSupportSpecialMemberName;

  }

  /**
   * 介護支援専門員氏名コンテナを取得します。
   * @return 介護支援専門員氏名コンテナ
   */
  protected ACLabelContainer getKaigoSupportSpecialMemberNameContainer(){
    if(kaigoSupportSpecialMemberNameContainer==null){
      kaigoSupportSpecialMemberNameContainer = new ACLabelContainer();
      kaigoSupportSpecialMemberNameContainer.setFollowChildEnabled(true);
      kaigoSupportSpecialMemberNameContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportSpecialMemberNameContainer.add(getKaigoSupportSpecialMemberName(), null);
    }
    return kaigoSupportSpecialMemberNameContainer;
  }

  /**
   * 介護支援専門員氏名モデルを取得します。
   * @return 介護支援専門員氏名モデル
   */
  protected ACComboBoxModelAdapter getKaigoSupportSpecialMemberNameModel(){
    if(kaigoSupportSpecialMemberNameModel==null){
      kaigoSupportSpecialMemberNameModel = new ACComboBoxModelAdapter();
      addKaigoSupportSpecialMemberNameModel();
    }
    return kaigoSupportSpecialMemberNameModel;
  }

  /**
   * コンストラクタです。
   */
  public QS001117_H2104Design() {

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

    this.add(getKaigoSupportPattern(), VRLayout.CLIENT);

  }

  /**
   * 居宅介護支援領域に内部項目を追加します。
   */
  protected void addKaigoSupportPattern(){

    kaigoSupportPattern.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * タブパネルに内部項目を追加します。
   */
  protected void addTabs(){

    tabs.addTab("1", getTab1());

    tabs.addTab("2", getTab2());

  }

  /**
   * タブ1に内部項目を追加します。
   */
  protected void addTab1(){

    tab1.add(getKaigoSupportDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoSupportManagementBasicRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoSupportSpecificProviderSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoSupportStandardRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getDischargeAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoSupportSpecificStandardRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalCoordinateAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getDementiaAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 居宅介護支援費に内部項目を追加します。
   */
  protected void addKaigoSupportDivisionRadio(){

  }

  /**
   * 居宅介護支援費モデルに内部項目を追加します。
   */
  protected void addKaigoSupportDivisionRadioModel(){

    getKaigoSupportDivisionRadioItem1().setButtonIndex(1);

    getKaigoSupportDivisionRadioModel().add(getKaigoSupportDivisionRadioItem1());

    getKaigoSupportDivisionRadioItem2().setButtonIndex(2);

    getKaigoSupportDivisionRadioModel().add(getKaigoSupportDivisionRadioItem2());

    getKaigoSupportDivisionRadioItem3().setButtonIndex(3);

    getKaigoSupportDivisionRadioModel().add(getKaigoSupportDivisionRadioItem3());

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addKaigoSupportDivisionRadioItem1(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addKaigoSupportDivisionRadioItem2(){

  }

  /**
   * III型に内部項目を追加します。
   */
  protected void addKaigoSupportDivisionRadioItem3(){

  }

  /**
   * 運営基準減算に内部項目を追加します。
   */
  protected void addKaigoSupportManagementBasicRadio(){

  }

  /**
   * 運営基準減算モデルに内部項目を追加します。
   */
  protected void addKaigoSupportManagementBasicRadioModel(){

    getKaigoSupportManagementBasicRadioItem1().setButtonIndex(1);

    getKaigoSupportManagementBasicRadioModel().add(getKaigoSupportManagementBasicRadioItem1());

    getKaigoSupportManagementBasicRadioItem2().setButtonIndex(2);

    getKaigoSupportManagementBasicRadioModel().add(getKaigoSupportManagementBasicRadioItem2());

    getKaigoSupportManagementBasicRadioItem3().setButtonIndex(3);

    getKaigoSupportManagementBasicRadioModel().add(getKaigoSupportManagementBasicRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoSupportManagementBasicRadioItem1(){

  }

  /**
   * 減算要件該当に内部項目を追加します。
   */
  protected void addKaigoSupportManagementBasicRadioItem2(){

  }

  /**
   * 減算要件該当が2ヶ月以上に内部項目を追加します。
   */
  protected void addKaigoSupportManagementBasicRadioItem3(){

  }

  /**
   * 特定事業所集中減算に内部項目を追加します。
   */
  protected void addKaigoSupportSpecificProviderSubtractionRadio(){

  }

  /**
   * 特定事業所集中減算モデルに内部項目を追加します。
   */
  protected void addKaigoSupportSpecificProviderSubtractionRadioModel(){

    getKaigoSupportSpecificProviderSubtractionRadioItem1().setButtonIndex(1);

    getKaigoSupportSpecificProviderSubtractionRadioModel().add(getKaigoSupportSpecificProviderSubtractionRadioItem1());

    getKaigoSupportSpecificProviderSubtractionRadioItem2().setButtonIndex(2);

    getKaigoSupportSpecificProviderSubtractionRadioModel().add(getKaigoSupportSpecificProviderSubtractionRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoSupportSpecificProviderSubtractionRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKaigoSupportSpecificProviderSubtractionRadioItem2(){

  }

  /**
   * 初回加算に内部項目を追加します。
   */
  protected void addKaigoSupportStandardRadio(){

  }

  /**
   * 初回加算モデルに内部項目を追加します。
   */
  protected void addKaigoSupportStandardRadioModel(){

    getKaigoSupportStandardRadioItem1().setButtonIndex(1);

    getKaigoSupportStandardRadioModel().add(getKaigoSupportStandardRadioItem1());

    getKaigoSupportStandardRadioItem2().setButtonIndex(2);

    getKaigoSupportStandardRadioModel().add(getKaigoSupportStandardRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoSupportStandardRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKaigoSupportStandardRadioItem2(){

  }

  /**
   * 退院・退所加算に内部項目を追加します。
   */
  protected void addDischargeAddRadio(){

  }

  /**
   * 退院・退所加算モデルに内部項目を追加します。
   */
  protected void addDischargeAddRadioModel(){

    getDischargeAddRadioItem1().setButtonIndex(1);

    getDischargeAddRadioModel().add(getDischargeAddRadioItem1());

    getDischargeAddRadioItem2().setButtonIndex(2);

    getDischargeAddRadioModel().add(getDischargeAddRadioItem2());

    getDischargeAddRadioItem3().setButtonIndex(3);

    getDischargeAddRadioModel().add(getDischargeAddRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addDischargeAddRadioItem1(){

  }

  /**
   * 退院・退所時（I型）に内部項目を追加します。
   */
  protected void addDischargeAddRadioItem2(){

  }

  /**
   * 退院・退所時（II型）に内部項目を追加します。
   */
  protected void addDischargeAddRadioItem3(){

  }

  /**
   * 特定事業所加算に内部項目を追加します。
   */
  protected void addKaigoSupportSpecificStandardRadio(){

  }

  /**
   * 特定事業所加算モデルに内部項目を追加します。
   */
  protected void addKaigoSupportSpecificStandardRadioModel(){

    getKaigoSupportSpecificStandardRadioItem1().setButtonIndex(1);

    getKaigoSupportSpecificStandardRadioModel().add(getKaigoSupportSpecificStandardRadioItem1());

    getKaigoSupportSpecificStandardRadioItem2().setButtonIndex(2);

    getKaigoSupportSpecificStandardRadioModel().add(getKaigoSupportSpecificStandardRadioItem2());

    getKaigoSupportSpecificStandardRadioItem3().setButtonIndex(3);

    getKaigoSupportSpecificStandardRadioModel().add(getKaigoSupportSpecificStandardRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKaigoSupportSpecificStandardRadioItem1(){

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addKaigoSupportSpecificStandardRadioItem2(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addKaigoSupportSpecificStandardRadioItem3(){

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
   * 認知症加算に内部項目を追加します。
   */
  protected void addDementiaAddRadioGroup(){

  }

  /**
   * 認知症加算モデルに内部項目を追加します。
   */
  protected void addDementiaAddRadioGroupModel(){

    getDementiaAddRadioItem1().setButtonIndex(1);

    getDementiaAddRadioGroupModel().add(getDementiaAddRadioItem1());

    getDementiaAddRadioItem2().setButtonIndex(2);

    getDementiaAddRadioGroupModel().add(getDementiaAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addDementiaAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addDementiaAddRadioItem2(){

  }

  /**
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getSolitaryOldPeopleRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getSmallScaleProviderHelpAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getProviderAddMountainousAreaRafioRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKaigoSupportSpecialMemberContainer(), VRLayout.FLOW);

  }

  /**
   * 独居高齢者加算に内部項目を追加します。
   */
  protected void addSolitaryOldPeopleRadioGroup(){

  }

  /**
   * 独居高齢者加算モデルに内部項目を追加します。
   */
  protected void addSolitaryOldPeopleRadioGroupModel(){

    getSolitaryOldPeopleRadioItem1().setButtonIndex(1);

    getSolitaryOldPeopleRadioGroupModel().add(getSolitaryOldPeopleRadioItem1());

    getSolitaryOldPeopleRadioItem2().setButtonIndex(2);

    getSolitaryOldPeopleRadioGroupModel().add(getSolitaryOldPeopleRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSolitaryOldPeopleRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addSolitaryOldPeopleRadioItem2(){

  }

  /**
   * 小規模多機能型居宅介護事業所連携加算に内部項目を追加します。
   */
  protected void addSmallScaleProviderHelpAddRadioGroup(){

  }

  /**
   * 小規模多機能型居宅介護事業所連携加算モデルに内部項目を追加します。
   */
  protected void addSmallScaleProviderHelpAddRadioGroupModel(){

    getSmallScaleProviderHelpAddRadioItem1().setButtonIndex(1);

    getSmallScaleProviderHelpAddRadioGroupModel().add(getSmallScaleProviderHelpAddRadioItem1());

    getSmallScaleProviderHelpAddRadioItem2().setButtonIndex(2);

    getSmallScaleProviderHelpAddRadioGroupModel().add(getSmallScaleProviderHelpAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSmallScaleProviderHelpAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addSmallScaleProviderHelpAddRadioItem2(){

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
   * 介護支援専門員コンテナに内部項目を追加します。
   */
  protected void addKaigoSupportSpecialMemberContainer(){

    kaigoSupportSpecialMemberContainer.add(getKaigoSupportSpecialMemberNumberContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoSupportSpecialMemberContainer.add(getKaigoSupportSpecialMemberNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 介護支援専門員番号に内部項目を追加します。
   */
  protected void addKaigoSupportSpecialMemberNumber(){

  }

  /**
   * 介護支援専門員氏名に内部項目を追加します。
   */
  protected void addKaigoSupportSpecialMemberName(){

  }

  /**
   * 介護支援専門員氏名モデルに内部項目を追加します。
   */
  protected void addKaigoSupportSpecialMemberNameModel(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001117_H2104Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001117_H2104Design getThis() {
    return this;
  }
}
