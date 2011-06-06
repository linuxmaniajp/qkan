
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
 * 開発者: 田中　統蔵
 * 作成日: 2009/08/26  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン夜間対応型訪問介護 (QS001123_H2104)
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
 * サービスパターン夜間対応型訪問介護画面項目デザイン(QS001123_H2104) 
 */
public class QS001123_H2104Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel nightTypeVisitCarePatterns;

  private ACClearableRadioButtonGroup providerDivisionRadio;

  private ACLabelContainer providerDivisionRadioContainer;

  private ACListModelAdapter providerDivisionRadioModel;

  private ACRadioButtonItem providerDivisionRadioItem1;

  private ACRadioButtonItem providerDivisionRadioItem2;

  private ACClearableRadioButtonGroup serviceDivisionRadio;

  private ACLabelContainer serviceDivisionRadioContainer;

  private ACListModelAdapter serviceDivisionRadioModel;

  private ACRadioButtonItem serviceDivisionRadioItem1;

  private ACRadioButtonItem serviceDivisionRadioItem2;

  private ACClearableRadioButtonGroup anytimeCorrespondenceTypeRadio;

  private ACLabelContainer anytimeCorrespondenceTypeRadioContainer;

  private ACListModelAdapter anytimeCorrespondenceTypeRadioModel;

  private ACRadioButtonItem anytimeCorrespondenceTypeRadioItem1;

  private ACRadioButtonItem anytimeCorrespondenceTypeRadioItem2;

  private ACClearableRadioButtonGroup classEmploymentRadio;

  private ACLabelContainer classEmploymentRadioContainer;

  private ACListModelAdapter classEmploymentRadioModel;

  private ACRadioButtonItem classEmploymentRadioItem1;

  private ACRadioButtonItem classEmploymentRadioItem2;

  private ACValueArrayRadioButtonGroup hours24MessageAddRadioGroup;

  private ACLabelContainer hours24MessageAddRadioGroupContainer;

  private ACListModelAdapter hours24MessageAddRadioGroupModel;

  private ACRadioButtonItem hours24MessageAddRadioItem1;

  private ACRadioButtonItem hours24MessageAddRadioItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACComboBox baseMunicipalityAdd;

  private ACLabelContainer baseMunicipalityAddContainer;

  private ACComboBoxModelAdapter baseMunicipalityAddModel;

  private ACComboBox serviceMunicipalityAdd;

  private ACLabelContainer serviceMunicipalityAddContainer;

  private ACComboBoxModelAdapter serviceMunicipalityAddModel;

  private ACValueArrayRadioButtonGroup calculationDivision;

  private ACLabelContainer calculationDivisionContainer;

  private ACListModelAdapter calculationDivisionModel;

  private ACRadioButtonItem calculationDivisionNormal;

  private ACRadioButtonItem calculationDivisionBasicOnly;

  private ACIntegerCheckBox crackOnDayCheck;

  private ACIntegerCheckBox printable;

  private ACBackLabelContainer yakanHoumonKaigoTimeContainer;

  private ACTimeComboBox yakanHoumonKaigoBeginTime;

  private ACLabelContainer yakanHoumonKaigoBeginTimeContainer;

  private ACComboBoxModelAdapter yakanHoumonKaigoBeginTimeModel;

  private ACTimeComboBox yakanHoumonKaigoEndTime;

  private ACLabelContainer yakanHoumonKaigoEndTimeContainer;

  private ACComboBoxModelAdapter yakanHoumonKaigoEndTimeModel;

  //getter

  /**
   * 夜間対応型訪問介護パターン領域を取得します。
   * @return 夜間対応型訪問介護パターン領域
   */
  public ACPanel getNightTypeVisitCarePatterns(){
    if(nightTypeVisitCarePatterns==null){

      nightTypeVisitCarePatterns = new ACPanel();

      nightTypeVisitCarePatterns.setAutoWrap(false);

      nightTypeVisitCarePatterns.setHgrid(200);

      addNightTypeVisitCarePatterns();
    }
    return nightTypeVisitCarePatterns;

  }

  /**
   * 施設等の区分を取得します。
   * @return 施設等の区分
   */
  public ACClearableRadioButtonGroup getProviderDivisionRadio(){
    if(providerDivisionRadio==null){

      providerDivisionRadio = new ACClearableRadioButtonGroup();

      getProviderDivisionRadioContainer().setText("施設等の区分");

      providerDivisionRadio.setBindPath("1710101");

      providerDivisionRadio.setUseClearButton(false);

      providerDivisionRadio.setModel(getProviderDivisionRadioModel());

      addProviderDivisionRadio();
    }
    return providerDivisionRadio;

  }

  /**
   * 施設等の区分コンテナを取得します。
   * @return 施設等の区分コンテナ
   */
  protected ACLabelContainer getProviderDivisionRadioContainer(){
    if(providerDivisionRadioContainer==null){
      providerDivisionRadioContainer = new ACLabelContainer();
      providerDivisionRadioContainer.setFollowChildEnabled(true);
      providerDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      providerDivisionRadioContainer.add(getProviderDivisionRadio(), null);
    }
    return providerDivisionRadioContainer;
  }

  /**
   * 施設等の区分モデルを取得します。
   * @return 施設等の区分モデル
   */
  protected ACListModelAdapter getProviderDivisionRadioModel(){
    if(providerDivisionRadioModel==null){
      providerDivisionRadioModel = new ACListModelAdapter();
      addProviderDivisionRadioModel();
    }
    return providerDivisionRadioModel;
  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getProviderDivisionRadioItem1(){
    if(providerDivisionRadioItem1==null){

      providerDivisionRadioItem1 = new ACRadioButtonItem();

      providerDivisionRadioItem1.setText("I型");

      providerDivisionRadioItem1.setGroup(getProviderDivisionRadio());

      providerDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addProviderDivisionRadioItem1();
    }
    return providerDivisionRadioItem1;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getProviderDivisionRadioItem2(){
    if(providerDivisionRadioItem2==null){

      providerDivisionRadioItem2 = new ACRadioButtonItem();

      providerDivisionRadioItem2.setText("II型");

      providerDivisionRadioItem2.setGroup(getProviderDivisionRadio());

      providerDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addProviderDivisionRadioItem2();
    }
    return providerDivisionRadioItem2;

  }

  /**
   * サービス区分を取得します。
   * @return サービス区分
   */
  public ACClearableRadioButtonGroup getServiceDivisionRadio(){
    if(serviceDivisionRadio==null){

      serviceDivisionRadio = new ACClearableRadioButtonGroup();

      getServiceDivisionRadioContainer().setText("サービス区分");

      serviceDivisionRadio.setBindPath("1710102");

      serviceDivisionRadio.setUseClearButton(false);

      serviceDivisionRadio.setModel(getServiceDivisionRadioModel());

      addServiceDivisionRadio();
    }
    return serviceDivisionRadio;

  }

  /**
   * サービス区分コンテナを取得します。
   * @return サービス区分コンテナ
   */
  protected ACLabelContainer getServiceDivisionRadioContainer(){
    if(serviceDivisionRadioContainer==null){
      serviceDivisionRadioContainer = new ACLabelContainer();
      serviceDivisionRadioContainer.setFollowChildEnabled(true);
      serviceDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      serviceDivisionRadioContainer.add(getServiceDivisionRadio(), null);
    }
    return serviceDivisionRadioContainer;
  }

  /**
   * サービス区分モデルを取得します。
   * @return サービス区分モデル
   */
  protected ACListModelAdapter getServiceDivisionRadioModel(){
    if(serviceDivisionRadioModel==null){
      serviceDivisionRadioModel = new ACListModelAdapter();
      addServiceDivisionRadioModel();
    }
    return serviceDivisionRadioModel;
  }

  /**
   * 定期巡回型を取得します。
   * @return 定期巡回型
   */
  public ACRadioButtonItem getServiceDivisionRadioItem1(){
    if(serviceDivisionRadioItem1==null){

      serviceDivisionRadioItem1 = new ACRadioButtonItem();

      serviceDivisionRadioItem1.setText("定期巡回型");

      serviceDivisionRadioItem1.setGroup(getServiceDivisionRadio());

      serviceDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addServiceDivisionRadioItem1();
    }
    return serviceDivisionRadioItem1;

  }

  /**
   * 随時対応型を取得します。
   * @return 随時対応型
   */
  public ACRadioButtonItem getServiceDivisionRadioItem2(){
    if(serviceDivisionRadioItem2==null){

      serviceDivisionRadioItem2 = new ACRadioButtonItem();

      serviceDivisionRadioItem2.setText("随時対応型");

      serviceDivisionRadioItem2.setGroup(getServiceDivisionRadio());

      serviceDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addServiceDivisionRadioItem2();
    }
    return serviceDivisionRadioItem2;

  }

  /**
   * 対応人数を取得します。
   * @return 対応人数
   */
  public ACClearableRadioButtonGroup getAnytimeCorrespondenceTypeRadio(){
    if(anytimeCorrespondenceTypeRadio==null){

      anytimeCorrespondenceTypeRadio = new ACClearableRadioButtonGroup();

      getAnytimeCorrespondenceTypeRadioContainer().setText("対応人数");

      anytimeCorrespondenceTypeRadio.setBindPath("1710104");

      anytimeCorrespondenceTypeRadio.setUseClearButton(false);

      anytimeCorrespondenceTypeRadio.setModel(getAnytimeCorrespondenceTypeRadioModel());

      addAnytimeCorrespondenceTypeRadio();
    }
    return anytimeCorrespondenceTypeRadio;

  }

  /**
   * 対応人数コンテナを取得します。
   * @return 対応人数コンテナ
   */
  protected ACLabelContainer getAnytimeCorrespondenceTypeRadioContainer(){
    if(anytimeCorrespondenceTypeRadioContainer==null){
      anytimeCorrespondenceTypeRadioContainer = new ACLabelContainer();
      anytimeCorrespondenceTypeRadioContainer.setFollowChildEnabled(true);
      anytimeCorrespondenceTypeRadioContainer.setVAlignment(VRLayout.CENTER);
      anytimeCorrespondenceTypeRadioContainer.add(getAnytimeCorrespondenceTypeRadio(), null);
    }
    return anytimeCorrespondenceTypeRadioContainer;
  }

  /**
   * 対応人数モデルを取得します。
   * @return 対応人数モデル
   */
  protected ACListModelAdapter getAnytimeCorrespondenceTypeRadioModel(){
    if(anytimeCorrespondenceTypeRadioModel==null){
      anytimeCorrespondenceTypeRadioModel = new ACListModelAdapter();
      addAnytimeCorrespondenceTypeRadioModel();
    }
    return anytimeCorrespondenceTypeRadioModel;
  }

  /**
   * 1人対応を取得します。
   * @return 1人対応
   */
  public ACRadioButtonItem getAnytimeCorrespondenceTypeRadioItem1(){
    if(anytimeCorrespondenceTypeRadioItem1==null){

      anytimeCorrespondenceTypeRadioItem1 = new ACRadioButtonItem();

      anytimeCorrespondenceTypeRadioItem1.setText("1人対応");

      anytimeCorrespondenceTypeRadioItem1.setGroup(getAnytimeCorrespondenceTypeRadio());

      anytimeCorrespondenceTypeRadioItem1.setConstraints(VRLayout.FLOW);

      addAnytimeCorrespondenceTypeRadioItem1();
    }
    return anytimeCorrespondenceTypeRadioItem1;

  }

  /**
   * 2人対応を取得します。
   * @return 2人対応
   */
  public ACRadioButtonItem getAnytimeCorrespondenceTypeRadioItem2(){
    if(anytimeCorrespondenceTypeRadioItem2==null){

      anytimeCorrespondenceTypeRadioItem2 = new ACRadioButtonItem();

      anytimeCorrespondenceTypeRadioItem2.setText("2人対応");

      anytimeCorrespondenceTypeRadioItem2.setGroup(getAnytimeCorrespondenceTypeRadio());

      anytimeCorrespondenceTypeRadioItem2.setConstraints(VRLayout.FLOW);

      addAnytimeCorrespondenceTypeRadioItem2();
    }
    return anytimeCorrespondenceTypeRadioItem2;

  }

  /**
   * 訪問者の級職を取得します。
   * @return 訪問者の級職
   */
  public ACClearableRadioButtonGroup getClassEmploymentRadio(){
    if(classEmploymentRadio==null){

      classEmploymentRadio = new ACClearableRadioButtonGroup();

      getClassEmploymentRadioContainer().setText("訪問者の級職");

      classEmploymentRadio.setBindPath("1710105");

      classEmploymentRadio.setUseClearButton(false);

      classEmploymentRadio.setModel(getClassEmploymentRadioModel());

      addClassEmploymentRadio();
    }
    return classEmploymentRadio;

  }

  /**
   * 訪問者の級職コンテナを取得します。
   * @return 訪問者の級職コンテナ
   */
  protected ACLabelContainer getClassEmploymentRadioContainer(){
    if(classEmploymentRadioContainer==null){
      classEmploymentRadioContainer = new ACLabelContainer();
      classEmploymentRadioContainer.setFollowChildEnabled(true);
      classEmploymentRadioContainer.setVAlignment(VRLayout.CENTER);
      classEmploymentRadioContainer.add(getClassEmploymentRadio(), null);
    }
    return classEmploymentRadioContainer;
  }

  /**
   * 訪問者の級職モデルを取得します。
   * @return 訪問者の級職モデル
   */
  protected ACListModelAdapter getClassEmploymentRadioModel(){
    if(classEmploymentRadioModel==null){
      classEmploymentRadioModel = new ACListModelAdapter();
      addClassEmploymentRadioModel();
    }
    return classEmploymentRadioModel;
  }

  /**
   * 3級以外を取得します。
   * @return 3級以外
   */
  public ACRadioButtonItem getClassEmploymentRadioItem1(){
    if(classEmploymentRadioItem1==null){

      classEmploymentRadioItem1 = new ACRadioButtonItem();

      classEmploymentRadioItem1.setText("3級以外");

      classEmploymentRadioItem1.setGroup(getClassEmploymentRadio());

      classEmploymentRadioItem1.setConstraints(VRLayout.FLOW);

      addClassEmploymentRadioItem1();
    }
    return classEmploymentRadioItem1;

  }

  /**
   * 3級を取得します。
   * @return 3級
   */
  public ACRadioButtonItem getClassEmploymentRadioItem2(){
    if(classEmploymentRadioItem2==null){

      classEmploymentRadioItem2 = new ACRadioButtonItem();

      classEmploymentRadioItem2.setText("3級");

      classEmploymentRadioItem2.setGroup(getClassEmploymentRadio());

      classEmploymentRadioItem2.setConstraints(VRLayout.FLOW);

      addClassEmploymentRadioItem2();
    }
    return classEmploymentRadioItem2;

  }

  /**
   * 24時間通報対応加算を取得します。
   * @return 24時間通報対応加算
   */
  public ACValueArrayRadioButtonGroup getHours24MessageAddRadioGroup(){
    if(hours24MessageAddRadioGroup==null){

      hours24MessageAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getHours24MessageAddRadioGroupContainer().setText("24時間通報対応加算");

      hours24MessageAddRadioGroup.setBindPath("1710107");

      hours24MessageAddRadioGroup.setVisible(true);

      hours24MessageAddRadioGroup.setEnabled(true);

      hours24MessageAddRadioGroup.setNoSelectIndex(0);

      hours24MessageAddRadioGroup.setUseClearButton(false);

      hours24MessageAddRadioGroup.setModel(getHours24MessageAddRadioGroupModel());

      hours24MessageAddRadioGroup.setValues(new int[]{1,2});

      addHours24MessageAddRadioGroup();
    }
    return hours24MessageAddRadioGroup;

  }

  /**
   * 24時間通報対応加算コンテナを取得します。
   * @return 24時間通報対応加算コンテナ
   */
  protected ACLabelContainer getHours24MessageAddRadioGroupContainer(){
    if(hours24MessageAddRadioGroupContainer==null){
      hours24MessageAddRadioGroupContainer = new ACLabelContainer();
      hours24MessageAddRadioGroupContainer.setFollowChildEnabled(true);
      hours24MessageAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      hours24MessageAddRadioGroupContainer.add(getHours24MessageAddRadioGroup(), null);
    }
    return hours24MessageAddRadioGroupContainer;
  }

  /**
   * 24時間通報対応加算モデルを取得します。
   * @return 24時間通報対応加算モデル
   */
  protected ACListModelAdapter getHours24MessageAddRadioGroupModel(){
    if(hours24MessageAddRadioGroupModel==null){
      hours24MessageAddRadioGroupModel = new ACListModelAdapter();
      addHours24MessageAddRadioGroupModel();
    }
    return hours24MessageAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHours24MessageAddRadioItem1(){
    if(hours24MessageAddRadioItem1==null){

      hours24MessageAddRadioItem1 = new ACRadioButtonItem();

      hours24MessageAddRadioItem1.setText("なし");

      hours24MessageAddRadioItem1.setGroup(getHours24MessageAddRadioGroup());

      hours24MessageAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHours24MessageAddRadioItem1();
    }
    return hours24MessageAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHours24MessageAddRadioItem2(){
    if(hours24MessageAddRadioItem2==null){

      hours24MessageAddRadioItem2 = new ACRadioButtonItem();

      hours24MessageAddRadioItem2.setText("あり");

      hours24MessageAddRadioItem2.setGroup(getHours24MessageAddRadioGroup());

      hours24MessageAddRadioItem2.setConstraints(VRLayout.FLOW);

      addHours24MessageAddRadioItem2();
    }
    return hours24MessageAddRadioItem2;

  }

  /**
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1710108");

      serviceAddProvisionStructuralRadioGroup.setVisible(true);

      serviceAddProvisionStructuralRadioGroup.setEnabled(true);

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,2,3});

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
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("I型");

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
   * 基本夜間訪問 I 市町村独自加算を取得します。
   * @return 基本夜間訪問 I 市町村独自加算
   */
  public ACComboBox getBaseMunicipalityAdd(){
    if(baseMunicipalityAdd==null){

      baseMunicipalityAdd = new ACComboBox();

      getBaseMunicipalityAddContainer().setText("基本夜間訪問 I 市町村独自加算");

      baseMunicipalityAdd.setBindPath("1710109");

      baseMunicipalityAdd.setEditable(false);

      baseMunicipalityAdd.setModelBindPath("1710109");

      baseMunicipalityAdd.setRenderBindPath("CONTENT");

      baseMunicipalityAdd.setBlankable(false);

      baseMunicipalityAdd.setModel(getBaseMunicipalityAddModel());

      addBaseMunicipalityAdd();
    }
    return baseMunicipalityAdd;

  }

  /**
   * 基本夜間訪問 I 市町村独自加算コンテナを取得します。
   * @return 基本夜間訪問 I 市町村独自加算コンテナ
   */
  protected ACLabelContainer getBaseMunicipalityAddContainer(){
    if(baseMunicipalityAddContainer==null){
      baseMunicipalityAddContainer = new ACLabelContainer();
      baseMunicipalityAddContainer.setFollowChildEnabled(true);
      baseMunicipalityAddContainer.setVAlignment(VRLayout.CENTER);
      baseMunicipalityAddContainer.add(getBaseMunicipalityAdd(), null);
    }
    return baseMunicipalityAddContainer;
  }

  /**
   * 基本夜間訪問 I 市町村独自加算モデルを取得します。
   * @return 基本夜間訪問 I 市町村独自加算モデル
   */
  protected ACComboBoxModelAdapter getBaseMunicipalityAddModel(){
    if(baseMunicipalityAddModel==null){
      baseMunicipalityAddModel = new ACComboBoxModelAdapter();
      addBaseMunicipalityAddModel();
    }
    return baseMunicipalityAddModel;
  }

  /**
   * 夜間訪問介護 II 市町村独自加算を取得します。
   * @return 夜間訪問介護 II 市町村独自加算
   */
  public ACComboBox getServiceMunicipalityAdd(){
    if(serviceMunicipalityAdd==null){

      serviceMunicipalityAdd = new ACComboBox();

      getServiceMunicipalityAddContainer().setText("夜間訪問介護 II 市町村独自加算");

      serviceMunicipalityAdd.setBindPath("1710110");

      serviceMunicipalityAdd.setEditable(false);

      serviceMunicipalityAdd.setModelBindPath("1710110");

      serviceMunicipalityAdd.setRenderBindPath("CONTENT");

      serviceMunicipalityAdd.setBlankable(false);

      serviceMunicipalityAdd.setModel(getServiceMunicipalityAddModel());

      addServiceMunicipalityAdd();
    }
    return serviceMunicipalityAdd;

  }

  /**
   * 夜間訪問介護 II 市町村独自加算コンテナを取得します。
   * @return 夜間訪問介護 II 市町村独自加算コンテナ
   */
  protected ACLabelContainer getServiceMunicipalityAddContainer(){
    if(serviceMunicipalityAddContainer==null){
      serviceMunicipalityAddContainer = new ACLabelContainer();
      serviceMunicipalityAddContainer.setFollowChildEnabled(true);
      serviceMunicipalityAddContainer.setVAlignment(VRLayout.CENTER);
      serviceMunicipalityAddContainer.add(getServiceMunicipalityAdd(), null);
    }
    return serviceMunicipalityAddContainer;
  }

  /**
   * 夜間訪問介護 II 市町村独自加算モデルを取得します。
   * @return 夜間訪問介護 II 市町村独自加算モデル
   */
  protected ACComboBoxModelAdapter getServiceMunicipalityAddModel(){
    if(serviceMunicipalityAddModel==null){
      serviceMunicipalityAddModel = new ACComboBoxModelAdapter();
      addServiceMunicipalityAddModel();
    }
    return serviceMunicipalityAddModel;
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

      calculationDivision.setValues(new int[]{1,3});

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
   * 基本のみを取得します。
   * @return 基本のみ
   */
  public ACRadioButtonItem getCalculationDivisionBasicOnly(){
    if(calculationDivisionBasicOnly==null){

      calculationDivisionBasicOnly = new ACRadioButtonItem();

      calculationDivisionBasicOnly.setText("基本のみ");

      calculationDivisionBasicOnly.setGroup(getCalculationDivision());

      calculationDivisionBasicOnly.setConstraints(VRLayout.FLOW);

      addCalculationDivisionBasicOnly();
    }
    return calculationDivisionBasicOnly;

  }

  /**
   * 日割を取得します。
   * @return 日割
   */
  public ACIntegerCheckBox getCrackOnDayCheck(){
    if(crackOnDayCheck==null){

      crackOnDayCheck = new ACIntegerCheckBox();

      crackOnDayCheck.setText("日割");

      crackOnDayCheck.setBindPath("1710106");

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
  public ACBackLabelContainer getYakanHoumonKaigoTimeContainer(){
    if(yakanHoumonKaigoTimeContainer==null){

      yakanHoumonKaigoTimeContainer = new ACBackLabelContainer();

      addYakanHoumonKaigoTimeContainer();
    }
    return yakanHoumonKaigoTimeContainer;

  }

  /**
   * 開始時刻コンボを取得します。
   * @return 開始時刻コンボ
   */
  public ACTimeComboBox getYakanHoumonKaigoBeginTime(){
    if(yakanHoumonKaigoBeginTime==null){

      yakanHoumonKaigoBeginTime = new ACTimeComboBox();

      getYakanHoumonKaigoBeginTimeContainer().setText("開始時刻");

      yakanHoumonKaigoBeginTime.setBindPath("3");

      yakanHoumonKaigoBeginTime.setModelBindPath("3");

      yakanHoumonKaigoBeginTime.setRenderBindPath("CONTENT");

      yakanHoumonKaigoBeginTime.setModel(getYakanHoumonKaigoBeginTimeModel());

      addYakanHoumonKaigoBeginTime();
    }
    return yakanHoumonKaigoBeginTime;

  }

  /**
   * 開始時刻コンボコンテナを取得します。
   * @return 開始時刻コンボコンテナ
   */
  protected ACLabelContainer getYakanHoumonKaigoBeginTimeContainer(){
    if(yakanHoumonKaigoBeginTimeContainer==null){
      yakanHoumonKaigoBeginTimeContainer = new ACLabelContainer();
      yakanHoumonKaigoBeginTimeContainer.setFollowChildEnabled(true);
      yakanHoumonKaigoBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      yakanHoumonKaigoBeginTimeContainer.add(getYakanHoumonKaigoBeginTime(), null);
    }
    return yakanHoumonKaigoBeginTimeContainer;
  }

  /**
   * 開始時刻コンボモデルを取得します。
   * @return 開始時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getYakanHoumonKaigoBeginTimeModel(){
    if(yakanHoumonKaigoBeginTimeModel==null){
      yakanHoumonKaigoBeginTimeModel = new ACComboBoxModelAdapter();
      addYakanHoumonKaigoBeginTimeModel();
    }
    return yakanHoumonKaigoBeginTimeModel;
  }

  /**
   * 終了時刻コンボを取得します。
   * @return 終了時刻コンボ
   */
  public ACTimeComboBox getYakanHoumonKaigoEndTime(){
    if(yakanHoumonKaigoEndTime==null){

      yakanHoumonKaigoEndTime = new ACTimeComboBox();

      getYakanHoumonKaigoEndTimeContainer().setText("終了時刻");

      yakanHoumonKaigoEndTime.setBindPath("4");

      yakanHoumonKaigoEndTime.setModelBindPath("4");

      yakanHoumonKaigoEndTime.setRenderBindPath("CONTENT");

      yakanHoumonKaigoEndTime.setModel(getYakanHoumonKaigoEndTimeModel());

      addYakanHoumonKaigoEndTime();
    }
    return yakanHoumonKaigoEndTime;

  }

  /**
   * 終了時刻コンボコンテナを取得します。
   * @return 終了時刻コンボコンテナ
   */
  protected ACLabelContainer getYakanHoumonKaigoEndTimeContainer(){
    if(yakanHoumonKaigoEndTimeContainer==null){
      yakanHoumonKaigoEndTimeContainer = new ACLabelContainer();
      yakanHoumonKaigoEndTimeContainer.setFollowChildEnabled(true);
      yakanHoumonKaigoEndTimeContainer.setVAlignment(VRLayout.CENTER);
      yakanHoumonKaigoEndTimeContainer.add(getYakanHoumonKaigoEndTime(), null);
    }
    return yakanHoumonKaigoEndTimeContainer;
  }

  /**
   * 終了時刻コンボモデルを取得します。
   * @return 終了時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getYakanHoumonKaigoEndTimeModel(){
    if(yakanHoumonKaigoEndTimeModel==null){
      yakanHoumonKaigoEndTimeModel = new ACComboBoxModelAdapter();
      addYakanHoumonKaigoEndTimeModel();
    }
    return yakanHoumonKaigoEndTimeModel;
  }

  /**
   * コンストラクタです。
   */
  public QS001123_H2104Design() {

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

    this.add(getNightTypeVisitCarePatterns(), VRLayout.CLIENT);

  }

  /**
   * 夜間対応型訪問介護パターン領域に内部項目を追加します。
   */
  protected void addNightTypeVisitCarePatterns(){

    nightTypeVisitCarePatterns.add(getProviderDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nightTypeVisitCarePatterns.add(getServiceDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nightTypeVisitCarePatterns.add(getAnytimeCorrespondenceTypeRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nightTypeVisitCarePatterns.add(getClassEmploymentRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nightTypeVisitCarePatterns.add(getHours24MessageAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nightTypeVisitCarePatterns.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nightTypeVisitCarePatterns.add(getBaseMunicipalityAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nightTypeVisitCarePatterns.add(getServiceMunicipalityAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nightTypeVisitCarePatterns.add(getCalculationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nightTypeVisitCarePatterns.add(getCrackOnDayCheck(), VRLayout.FLOW);

    nightTypeVisitCarePatterns.add(getPrintable(), VRLayout.FLOW_RETURN);

    nightTypeVisitCarePatterns.add(getYakanHoumonKaigoTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 施設等の区分に内部項目を追加します。
   */
  protected void addProviderDivisionRadio(){

  }

  /**
   * 施設等の区分モデルに内部項目を追加します。
   */
  protected void addProviderDivisionRadioModel(){

    getProviderDivisionRadioItem1().setButtonIndex(1);

    getProviderDivisionRadioModel().add(getProviderDivisionRadioItem1());

    getProviderDivisionRadioItem2().setButtonIndex(2);

    getProviderDivisionRadioModel().add(getProviderDivisionRadioItem2());

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addProviderDivisionRadioItem1(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addProviderDivisionRadioItem2(){

  }

  /**
   * サービス区分に内部項目を追加します。
   */
  protected void addServiceDivisionRadio(){

  }

  /**
   * サービス区分モデルに内部項目を追加します。
   */
  protected void addServiceDivisionRadioModel(){

    getServiceDivisionRadioItem1().setButtonIndex(1);

    getServiceDivisionRadioModel().add(getServiceDivisionRadioItem1());

    getServiceDivisionRadioItem2().setButtonIndex(2);

    getServiceDivisionRadioModel().add(getServiceDivisionRadioItem2());

  }

  /**
   * 定期巡回型に内部項目を追加します。
   */
  protected void addServiceDivisionRadioItem1(){

  }

  /**
   * 随時対応型に内部項目を追加します。
   */
  protected void addServiceDivisionRadioItem2(){

  }

  /**
   * 対応人数に内部項目を追加します。
   */
  protected void addAnytimeCorrespondenceTypeRadio(){

  }

  /**
   * 対応人数モデルに内部項目を追加します。
   */
  protected void addAnytimeCorrespondenceTypeRadioModel(){

    getAnytimeCorrespondenceTypeRadioItem1().setButtonIndex(1);

    getAnytimeCorrespondenceTypeRadioModel().add(getAnytimeCorrespondenceTypeRadioItem1());

    getAnytimeCorrespondenceTypeRadioItem2().setButtonIndex(2);

    getAnytimeCorrespondenceTypeRadioModel().add(getAnytimeCorrespondenceTypeRadioItem2());

  }

  /**
   * 1人対応に内部項目を追加します。
   */
  protected void addAnytimeCorrespondenceTypeRadioItem1(){

  }

  /**
   * 2人対応に内部項目を追加します。
   */
  protected void addAnytimeCorrespondenceTypeRadioItem2(){

  }

  /**
   * 訪問者の級職に内部項目を追加します。
   */
  protected void addClassEmploymentRadio(){

  }

  /**
   * 訪問者の級職モデルに内部項目を追加します。
   */
  protected void addClassEmploymentRadioModel(){

    getClassEmploymentRadioItem1().setButtonIndex(1);

    getClassEmploymentRadioModel().add(getClassEmploymentRadioItem1());

    getClassEmploymentRadioItem2().setButtonIndex(2);

    getClassEmploymentRadioModel().add(getClassEmploymentRadioItem2());

  }

  /**
   * 3級以外に内部項目を追加します。
   */
  protected void addClassEmploymentRadioItem1(){

  }

  /**
   * 3級に内部項目を追加します。
   */
  protected void addClassEmploymentRadioItem2(){

  }

  /**
   * 24時間通報対応加算に内部項目を追加します。
   */
  protected void addHours24MessageAddRadioGroup(){

  }

  /**
   * 24時間通報対応加算モデルに内部項目を追加します。
   */
  protected void addHours24MessageAddRadioGroupModel(){

    getHours24MessageAddRadioItem1().setButtonIndex(1);

    getHours24MessageAddRadioGroupModel().add(getHours24MessageAddRadioItem1());

    getHours24MessageAddRadioItem2().setButtonIndex(2);

    getHours24MessageAddRadioGroupModel().add(getHours24MessageAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHours24MessageAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHours24MessageAddRadioItem2(){

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

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem3(){

  }

  /**
   * 基本夜間訪問 I 市町村独自加算に内部項目を追加します。
   */
  protected void addBaseMunicipalityAdd(){

  }

  /**
   * 基本夜間訪問 I 市町村独自加算モデルに内部項目を追加します。
   */
  protected void addBaseMunicipalityAddModel(){

  }

  /**
   * 夜間訪問介護 II 市町村独自加算に内部項目を追加します。
   */
  protected void addServiceMunicipalityAdd(){

  }

  /**
   * 夜間訪問介護 II 市町村独自加算モデルに内部項目を追加します。
   */
  protected void addServiceMunicipalityAddModel(){

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

    getCalculationDivisionBasicOnly().setButtonIndex(3);

    getCalculationDivisionModel().add(getCalculationDivisionBasicOnly());

  }

  /**
   * 通常に内部項目を追加します。
   */
  protected void addCalculationDivisionNormal(){

  }

  /**
   * 基本のみに内部項目を追加します。
   */
  protected void addCalculationDivisionBasicOnly(){

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
  protected void addYakanHoumonKaigoTimeContainer(){

    yakanHoumonKaigoTimeContainer.add(getYakanHoumonKaigoBeginTimeContainer(), VRLayout.FLOW);

    yakanHoumonKaigoTimeContainer.add(getYakanHoumonKaigoEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * 開始時刻コンボに内部項目を追加します。
   */
  protected void addYakanHoumonKaigoBeginTime(){

  }

  /**
   * 開始時刻コンボモデルに内部項目を追加します。
   */
  protected void addYakanHoumonKaigoBeginTimeModel(){

  }

  /**
   * 終了時刻コンボに内部項目を追加します。
   */
  protected void addYakanHoumonKaigoEndTime(){

  }

  /**
   * 終了時刻コンボモデルに内部項目を追加します。
   */
  protected void addYakanHoumonKaigoEndTimeModel(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001123_H2104Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001123_H2104Design getThis() {
    return this;
  }
}
