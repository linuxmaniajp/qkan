
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
 * 開発者: 上司　和善
 * 作成日: 2012/01/30  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業者登録 (004)
 * プログラム 介護予防訪問看護 (QO004_16311_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;
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
 * 介護予防訪問看護画面項目デザイン(QO004_16311_201204) 
 */
public class QO004_16311_201204Design extends QO004ProviderPanel {
  //GUIコンポーネント

  private ACGroupBox mainGroup;

  private ACValueArrayRadioButtonGroup facilitiesDivision;

  private ACLabelContainer facilitiesDivisionContainer;

  private ACListModelAdapter facilitiesDivisionModel;

  private ACRadioButtonItem facilitiesDivisionItem1;

  private ACRadioButtonItem facilitiesDivisionItem2;

  private ACValueArrayRadioButtonGroup sameBuildingRadioGroup;

  private ACLabelContainer sameBuildingRadioGroupContainer;

  private ACListModelAdapter sameBuildingRadioGroupModel;

  private ACRadioButtonItem sameBuildingRadioItem1;

  private ACRadioButtonItem sameBuildingRadioItem2;

  private ACValueArrayRadioButtonGroup homonkangoPressing;

  private ACLabelContainer homonkangoPressingContainer;

  private ACListModelAdapter homonkangoPressingModel;

  private ACRadioButtonItem homonkangoPressingRadioItem1;

  private ACRadioButtonItem homonkangoPressingRadioItem2;

  private ACValueArrayRadioButtonGroup specialManagementSystem;

  private ACLabelContainer specialManagementSystemContainer;

  private ACListModelAdapter specialManagementSystemModel;

  private ACRadioButtonItem specialManagementSystemItem1;

  private ACRadioButtonItem specialManagementSystemItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRafioRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRafioRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRafioRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaRafioRadioItem1;

  private ACRadioButtonItem providerAddMountainousAreaRafioRadioItem2;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaScaleRadioGroup;

  private ACLabelContainer providerAddMountainousAreaScaleRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaScaleRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaScaleRadioItem1;

  private ACRadioButtonItem usAreaScaleRadioItem2;

  private ACPanel oldLowElementArea;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getMainGroup(){
    if(mainGroup==null){

      mainGroup = new ACGroupBox();

      mainGroup.setText("介護予防訪問看護");

      mainGroup.setFollowChildEnabled(true);

      mainGroup.setHgrid(200);

      addMainGroup();
    }
    return mainGroup;

  }

  /**
   * 施設区分ラジオグループを取得します。
   * @return 施設区分ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getFacilitiesDivision(){
    if(facilitiesDivision==null){

      facilitiesDivision = new ACValueArrayRadioButtonGroup();

      getFacilitiesDivisionContainer().setText("施設等の区分");

      facilitiesDivision.setBindPath("1630101");

      facilitiesDivision.setUseClearButton(false);

      facilitiesDivision.setModel(getFacilitiesDivisionModel());

      facilitiesDivision.setValues(new int[]{1,2});

      addFacilitiesDivision();
    }
    return facilitiesDivision;

  }

  /**
   * 施設区分ラジオグループコンテナを取得します。
   * @return 施設区分ラジオグループコンテナ
   */
  protected ACLabelContainer getFacilitiesDivisionContainer(){
    if(facilitiesDivisionContainer==null){
      facilitiesDivisionContainer = new ACLabelContainer();
      facilitiesDivisionContainer.setFollowChildEnabled(true);
      facilitiesDivisionContainer.setVAlignment(VRLayout.CENTER);
      facilitiesDivisionContainer.add(getFacilitiesDivision(), null);
    }
    return facilitiesDivisionContainer;
  }

  /**
   * 施設区分ラジオグループモデルを取得します。
   * @return 施設区分ラジオグループモデル
   */
  protected ACListModelAdapter getFacilitiesDivisionModel(){
    if(facilitiesDivisionModel==null){
      facilitiesDivisionModel = new ACListModelAdapter();
      addFacilitiesDivisionModel();
    }
    return facilitiesDivisionModel;
  }

  /**
   * 訪問看護ステーションを取得します。
   * @return 訪問看護ステーション
   */
  public ACRadioButtonItem getFacilitiesDivisionItem1(){
    if(facilitiesDivisionItem1==null){

      facilitiesDivisionItem1 = new ACRadioButtonItem();

      facilitiesDivisionItem1.setText("訪問看護ステーション");

      facilitiesDivisionItem1.setGroup(getFacilitiesDivision());

      addFacilitiesDivisionItem1();
    }
    return facilitiesDivisionItem1;

  }

  /**
   * 病院または診療所を取得します。
   * @return 病院または診療所
   */
  public ACRadioButtonItem getFacilitiesDivisionItem2(){
    if(facilitiesDivisionItem2==null){

      facilitiesDivisionItem2 = new ACRadioButtonItem();

      facilitiesDivisionItem2.setText("病院又は診療所");

      facilitiesDivisionItem2.setGroup(getFacilitiesDivision());

      addFacilitiesDivisionItem2();
    }
    return facilitiesDivisionItem2;

  }

  /**
   * 同一建物に居住する利用者の減算を取得します。
   * @return 同一建物に居住する利用者の減算
   */
  public ACValueArrayRadioButtonGroup getSameBuildingRadioGroup(){
    if(sameBuildingRadioGroup==null){

      sameBuildingRadioGroup = new ACValueArrayRadioButtonGroup();

      getSameBuildingRadioGroupContainer().setText("同一建物に居住する利用者の減算");

      sameBuildingRadioGroup.setBindPath("5");

      sameBuildingRadioGroup.setVisible(true);

      sameBuildingRadioGroup.setEnabled(true);

      sameBuildingRadioGroup.setNoSelectIndex(0);

      sameBuildingRadioGroup.setUseClearButton(false);

      sameBuildingRadioGroup.setModel(getSameBuildingRadioGroupModel());

      sameBuildingRadioGroup.setValues(new int[]{1,2});

      addSameBuildingRadioGroup();
    }
    return sameBuildingRadioGroup;

  }

  /**
   * 同一建物に居住する利用者の減算コンテナを取得します。
   * @return 同一建物に居住する利用者の減算コンテナ
   */
  protected ACLabelContainer getSameBuildingRadioGroupContainer(){
    if(sameBuildingRadioGroupContainer==null){
      sameBuildingRadioGroupContainer = new ACLabelContainer();
      sameBuildingRadioGroupContainer.setFollowChildEnabled(true);
      sameBuildingRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      sameBuildingRadioGroupContainer.add(getSameBuildingRadioGroup(), null);
    }
    return sameBuildingRadioGroupContainer;
  }

  /**
   * 同一建物に居住する利用者の減算モデルを取得します。
   * @return 同一建物に居住する利用者の減算モデル
   */
  protected ACListModelAdapter getSameBuildingRadioGroupModel(){
    if(sameBuildingRadioGroupModel==null){
      sameBuildingRadioGroupModel = new ACListModelAdapter();
      addSameBuildingRadioGroupModel();
    }
    return sameBuildingRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSameBuildingRadioItem1(){
    if(sameBuildingRadioItem1==null){

      sameBuildingRadioItem1 = new ACRadioButtonItem();

      sameBuildingRadioItem1.setText("なし");

      sameBuildingRadioItem1.setGroup(getSameBuildingRadioGroup());

      sameBuildingRadioItem1.setConstraints(VRLayout.FLOW);

      addSameBuildingRadioItem1();
    }
    return sameBuildingRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getSameBuildingRadioItem2(){
    if(sameBuildingRadioItem2==null){

      sameBuildingRadioItem2 = new ACRadioButtonItem();

      sameBuildingRadioItem2.setText("あり");

      sameBuildingRadioItem2.setGroup(getSameBuildingRadioGroup());

      sameBuildingRadioItem2.setConstraints(VRLayout.FLOW);

      addSameBuildingRadioItem2();
    }
    return sameBuildingRadioItem2;

  }

  /**
   * 緊急時介護予防訪問看護加算を取得します。
   * @return 緊急時介護予防訪問看護加算
   */
  public ACValueArrayRadioButtonGroup getHomonkangoPressing(){
    if(homonkangoPressing==null){

      homonkangoPressing = new ACValueArrayRadioButtonGroup();

      getHomonkangoPressingContainer().setText("緊急時介護予防訪問看護加算");

      homonkangoPressing.setBindPath("1630102");

      homonkangoPressing.setUseClearButton(false);

      homonkangoPressing.setModel(getHomonkangoPressingModel());

      homonkangoPressing.setValues(new int[]{1,2});

      addHomonkangoPressing();
    }
    return homonkangoPressing;

  }

  /**
   * 緊急時介護予防訪問看護加算コンテナを取得します。
   * @return 緊急時介護予防訪問看護加算コンテナ
   */
  protected ACLabelContainer getHomonkangoPressingContainer(){
    if(homonkangoPressingContainer==null){
      homonkangoPressingContainer = new ACLabelContainer();
      homonkangoPressingContainer.setFollowChildEnabled(true);
      homonkangoPressingContainer.setVAlignment(VRLayout.CENTER);
      homonkangoPressingContainer.add(getHomonkangoPressing(), null);
    }
    return homonkangoPressingContainer;
  }

  /**
   * 緊急時介護予防訪問看護加算モデルを取得します。
   * @return 緊急時介護予防訪問看護加算モデル
   */
  protected ACListModelAdapter getHomonkangoPressingModel(){
    if(homonkangoPressingModel==null){
      homonkangoPressingModel = new ACListModelAdapter();
      addHomonkangoPressingModel();
    }
    return homonkangoPressingModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHomonkangoPressingRadioItem1(){
    if(homonkangoPressingRadioItem1==null){

      homonkangoPressingRadioItem1 = new ACRadioButtonItem();

      homonkangoPressingRadioItem1.setText("なし");

      homonkangoPressingRadioItem1.setGroup(getHomonkangoPressing());

      addHomonkangoPressingRadioItem1();
    }
    return homonkangoPressingRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHomonkangoPressingRadioItem2(){
    if(homonkangoPressingRadioItem2==null){

      homonkangoPressingRadioItem2 = new ACRadioButtonItem();

      homonkangoPressingRadioItem2.setText("あり");

      homonkangoPressingRadioItem2.setGroup(getHomonkangoPressing());

      addHomonkangoPressingRadioItem2();
    }
    return homonkangoPressingRadioItem2;

  }

  /**
   * 特別管理体制ラジオグループを取得します。
   * @return 特別管理体制ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getSpecialManagementSystem(){
    if(specialManagementSystem==null){

      specialManagementSystem = new ACValueArrayRadioButtonGroup();

      getSpecialManagementSystemContainer().setText("特別管理体制");

      specialManagementSystem.setBindPath("1630103");

      specialManagementSystem.setUseClearButton(false);

      specialManagementSystem.setModel(getSpecialManagementSystemModel());

      specialManagementSystem.setValues(new int[]{1,2});

      addSpecialManagementSystem();
    }
    return specialManagementSystem;

  }

  /**
   * 特別管理体制ラジオグループコンテナを取得します。
   * @return 特別管理体制ラジオグループコンテナ
   */
  protected ACLabelContainer getSpecialManagementSystemContainer(){
    if(specialManagementSystemContainer==null){
      specialManagementSystemContainer = new ACLabelContainer();
      specialManagementSystemContainer.setFollowChildEnabled(true);
      specialManagementSystemContainer.setVAlignment(VRLayout.CENTER);
      specialManagementSystemContainer.add(getSpecialManagementSystem(), null);
    }
    return specialManagementSystemContainer;
  }

  /**
   * 特別管理体制ラジオグループモデルを取得します。
   * @return 特別管理体制ラジオグループモデル
   */
  protected ACListModelAdapter getSpecialManagementSystemModel(){
    if(specialManagementSystemModel==null){
      specialManagementSystemModel = new ACListModelAdapter();
      addSpecialManagementSystemModel();
    }
    return specialManagementSystemModel;
  }

  /**
   * 対応不可を取得します。
   * @return 対応不可
   */
  public ACRadioButtonItem getSpecialManagementSystemItem1(){
    if(specialManagementSystemItem1==null){

      specialManagementSystemItem1 = new ACRadioButtonItem();

      specialManagementSystemItem1.setText("対応不可");

      specialManagementSystemItem1.setGroup(getSpecialManagementSystem());

      addSpecialManagementSystemItem1();
    }
    return specialManagementSystemItem1;

  }

  /**
   * 対応可を取得します。
   * @return 対応可
   */
  public ACRadioButtonItem getSpecialManagementSystemItem2(){
    if(specialManagementSystemItem2==null){

      specialManagementSystemItem2 = new ACRadioButtonItem();

      specialManagementSystemItem2.setText("対応可");

      specialManagementSystemItem2.setGroup(getSpecialManagementSystem());

      addSpecialManagementSystemItem2();
    }
    return specialManagementSystemItem2;

  }

  /**
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1630106");

      serviceAddProvisionStructuralRadioGroup.setVisible(true);

      serviceAddProvisionStructuralRadioGroup.setEnabled(true);

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
   * 中山間地域等における小規模事業所加算（地域に関する状況）を取得します。
   * @return 中山間地域等における小規模事業所加算（地域に関する状況）
   */
  public ACValueArrayRadioButtonGroup getProviderAddMountainousAreaRafioRadioGroup(){
    if(providerAddMountainousAreaRafioRadioGroup==null){

      providerAddMountainousAreaRafioRadioGroup = new ACValueArrayRadioButtonGroup();

      getProviderAddMountainousAreaRafioRadioGroupContainer().setText("中山間地域等における小規模事業所加算（地域に関する状況）");

      providerAddMountainousAreaRafioRadioGroup.setBindPath("2");

      providerAddMountainousAreaRafioRadioGroup.setVisible(true);

      providerAddMountainousAreaRafioRadioGroup.setEnabled(true);

      providerAddMountainousAreaRafioRadioGroup.setNoSelectIndex(0);

      providerAddMountainousAreaRafioRadioGroup.setUseClearButton(false);

      providerAddMountainousAreaRafioRadioGroup.setModel(getProviderAddMountainousAreaRafioRadioGroupModel());

      providerAddMountainousAreaRafioRadioGroup.setValues(new int[]{1,2});

      addProviderAddMountainousAreaRafioRadioGroup();
    }
    return providerAddMountainousAreaRafioRadioGroup;

  }

  /**
   * 中山間地域等における小規模事業所加算（地域に関する状況）コンテナを取得します。
   * @return 中山間地域等における小規模事業所加算（地域に関する状況）コンテナ
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
   * 中山間地域等における小規模事業所加算（地域に関する状況）モデルを取得します。
   * @return 中山間地域等における小規模事業所加算（地域に関する状況）モデル
   */
  protected ACListModelAdapter getProviderAddMountainousAreaRafioRadioGroupModel(){
    if(providerAddMountainousAreaRafioRadioGroupModel==null){
      providerAddMountainousAreaRafioRadioGroupModel = new ACListModelAdapter();
      addProviderAddMountainousAreaRafioRadioGroupModel();
    }
    return providerAddMountainousAreaRafioRadioGroupModel;
  }

  /**
   * 非該当を取得します。
   * @return 非該当
   */
  public ACRadioButtonItem getProviderAddMountainousAreaRafioRadioItem1(){
    if(providerAddMountainousAreaRafioRadioItem1==null){

      providerAddMountainousAreaRafioRadioItem1 = new ACRadioButtonItem();

      providerAddMountainousAreaRafioRadioItem1.setText("非該当");

      providerAddMountainousAreaRafioRadioItem1.setGroup(getProviderAddMountainousAreaRafioRadioGroup());

      providerAddMountainousAreaRafioRadioItem1.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaRafioRadioItem1();
    }
    return providerAddMountainousAreaRafioRadioItem1;

  }

  /**
   * 該当を取得します。
   * @return 該当
   */
  public ACRadioButtonItem getProviderAddMountainousAreaRafioRadioItem2(){
    if(providerAddMountainousAreaRafioRadioItem2==null){

      providerAddMountainousAreaRafioRadioItem2 = new ACRadioButtonItem();

      providerAddMountainousAreaRafioRadioItem2.setText("該当");

      providerAddMountainousAreaRafioRadioItem2.setGroup(getProviderAddMountainousAreaRafioRadioGroup());

      providerAddMountainousAreaRafioRadioItem2.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaRafioRadioItem2();
    }
    return providerAddMountainousAreaRafioRadioItem2;

  }

  /**
   * 中山間地域等における小規模事業所加算（規模に関する状況）を取得します。
   * @return 中山間地域等における小規模事業所加算（規模に関する状況）
   */
  public ACValueArrayRadioButtonGroup getProviderAddMountainousAreaScaleRadioGroup(){
    if(providerAddMountainousAreaScaleRadioGroup==null){

      providerAddMountainousAreaScaleRadioGroup = new ACValueArrayRadioButtonGroup();

      getProviderAddMountainousAreaScaleRadioGroupContainer().setText("中山間地域等における小規模事業所加算（規模に関する状況）");

      providerAddMountainousAreaScaleRadioGroup.setBindPath("3");

      providerAddMountainousAreaScaleRadioGroup.setVisible(true);

      providerAddMountainousAreaScaleRadioGroup.setEnabled(true);

      providerAddMountainousAreaScaleRadioGroup.setNoSelectIndex(0);

      providerAddMountainousAreaScaleRadioGroup.setUseClearButton(false);

      providerAddMountainousAreaScaleRadioGroup.setModel(getProviderAddMountainousAreaScaleRadioGroupModel());

      providerAddMountainousAreaScaleRadioGroup.setValues(new int[]{1,2});

      addProviderAddMountainousAreaScaleRadioGroup();
    }
    return providerAddMountainousAreaScaleRadioGroup;

  }

  /**
   * 中山間地域等における小規模事業所加算（規模に関する状況）コンテナを取得します。
   * @return 中山間地域等における小規模事業所加算（規模に関する状況）コンテナ
   */
  protected ACLabelContainer getProviderAddMountainousAreaScaleRadioGroupContainer(){
    if(providerAddMountainousAreaScaleRadioGroupContainer==null){
      providerAddMountainousAreaScaleRadioGroupContainer = new ACLabelContainer();
      providerAddMountainousAreaScaleRadioGroupContainer.setFollowChildEnabled(true);
      providerAddMountainousAreaScaleRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      providerAddMountainousAreaScaleRadioGroupContainer.add(getProviderAddMountainousAreaScaleRadioGroup(), null);
    }
    return providerAddMountainousAreaScaleRadioGroupContainer;
  }

  /**
   * 中山間地域等における小規模事業所加算（規模に関する状況）モデルを取得します。
   * @return 中山間地域等における小規模事業所加算（規模に関する状況）モデル
   */
  protected ACListModelAdapter getProviderAddMountainousAreaScaleRadioGroupModel(){
    if(providerAddMountainousAreaScaleRadioGroupModel==null){
      providerAddMountainousAreaScaleRadioGroupModel = new ACListModelAdapter();
      addProviderAddMountainousAreaScaleRadioGroupModel();
    }
    return providerAddMountainousAreaScaleRadioGroupModel;
  }

  /**
   * 非該当を取得します。
   * @return 非該当
   */
  public ACRadioButtonItem getProviderAddMountainousAreaScaleRadioItem1(){
    if(providerAddMountainousAreaScaleRadioItem1==null){

      providerAddMountainousAreaScaleRadioItem1 = new ACRadioButtonItem();

      providerAddMountainousAreaScaleRadioItem1.setText("非該当");

      providerAddMountainousAreaScaleRadioItem1.setGroup(getProviderAddMountainousAreaScaleRadioGroup());

      providerAddMountainousAreaScaleRadioItem1.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaScaleRadioItem1();
    }
    return providerAddMountainousAreaScaleRadioItem1;

  }

  /**
   * 該当を取得します。
   * @return 該当
   */
  public ACRadioButtonItem getUsAreaScaleRadioItem2(){
    if(usAreaScaleRadioItem2==null){

      usAreaScaleRadioItem2 = new ACRadioButtonItem();

      usAreaScaleRadioItem2.setText("該当");

      usAreaScaleRadioItem2.setGroup(getProviderAddMountainousAreaScaleRadioGroup());

      usAreaScaleRadioItem2.setConstraints(VRLayout.FLOW);

      addUsAreaScaleRadioItem2();
    }
    return usAreaScaleRadioItem2;

  }

  /**
   * 旧法項目を取得します。
   * @return 旧法項目
   */
  public ACPanel getOldLowElementArea(){
    if(oldLowElementArea==null){

      oldLowElementArea = new ACPanel();

      oldLowElementArea.setFollowChildEnabled(true);

      addOldLowElementArea();
    }
    return oldLowElementArea;

  }

  /**
   * コンストラクタです。
   */
  public QO004_16311_201204Design() {

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

    this.add(getMainGroup(), VRLayout.CLIENT);

  }

  /**
   * 事業グループに内部項目を追加します。
   */
  protected void addMainGroup(){

    mainGroup.add(getFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getSameBuildingRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getHomonkangoPressingContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getSpecialManagementSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getProviderAddMountainousAreaRafioRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getProviderAddMountainousAreaScaleRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getOldLowElementArea(), VRLayout.FLOW_RETURN);

  }

  /**
   * 施設区分ラジオグループに内部項目を追加します。
   */
  protected void addFacilitiesDivision(){

  }

  /**
   * 施設区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addFacilitiesDivisionModel(){

    getFacilitiesDivisionItem1().setButtonIndex(1);

    getFacilitiesDivisionModel().add(getFacilitiesDivisionItem1());

    getFacilitiesDivisionItem2().setButtonIndex(2);

    getFacilitiesDivisionModel().add(getFacilitiesDivisionItem2());

  }

  /**
   * 訪問看護ステーションに内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem1(){

  }

  /**
   * 病院または診療所に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem2(){

  }

  /**
   * 同一建物に居住する利用者の減算に内部項目を追加します。
   */
  protected void addSameBuildingRadioGroup(){

  }

  /**
   * 同一建物に居住する利用者の減算モデルに内部項目を追加します。
   */
  protected void addSameBuildingRadioGroupModel(){

    getSameBuildingRadioItem1().setButtonIndex(1);

    getSameBuildingRadioGroupModel().add(getSameBuildingRadioItem1());

    getSameBuildingRadioItem2().setButtonIndex(2);

    getSameBuildingRadioGroupModel().add(getSameBuildingRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSameBuildingRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addSameBuildingRadioItem2(){

  }

  /**
   * 緊急時介護予防訪問看護加算に内部項目を追加します。
   */
  protected void addHomonkangoPressing(){

  }

  /**
   * 緊急時介護予防訪問看護加算モデルに内部項目を追加します。
   */
  protected void addHomonkangoPressingModel(){

    getHomonkangoPressingRadioItem1().setButtonIndex(1);

    getHomonkangoPressingModel().add(getHomonkangoPressingRadioItem1());

    getHomonkangoPressingRadioItem2().setButtonIndex(2);

    getHomonkangoPressingModel().add(getHomonkangoPressingRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHomonkangoPressingRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHomonkangoPressingRadioItem2(){

  }

  /**
   * 特別管理体制ラジオグループに内部項目を追加します。
   */
  protected void addSpecialManagementSystem(){

  }

  /**
   * 特別管理体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addSpecialManagementSystemModel(){

    getSpecialManagementSystemItem1().setButtonIndex(1);

    getSpecialManagementSystemModel().add(getSpecialManagementSystemItem1());

    getSpecialManagementSystemItem2().setButtonIndex(2);

    getSpecialManagementSystemModel().add(getSpecialManagementSystemItem2());

  }

  /**
   * 対応不可に内部項目を追加します。
   */
  protected void addSpecialManagementSystemItem1(){

  }

  /**
   * 対応可に内部項目を追加します。
   */
  protected void addSpecialManagementSystemItem2(){

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
   * 中山間地域等における小規模事業所加算（地域に関する状況）に内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRafioRadioGroup(){

  }

  /**
   * 中山間地域等における小規模事業所加算（地域に関する状況）モデルに内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRafioRadioGroupModel(){

    getProviderAddMountainousAreaRafioRadioItem1().setButtonIndex(1);

    getProviderAddMountainousAreaRafioRadioGroupModel().add(getProviderAddMountainousAreaRafioRadioItem1());

    getProviderAddMountainousAreaRafioRadioItem2().setButtonIndex(2);

    getProviderAddMountainousAreaRafioRadioGroupModel().add(getProviderAddMountainousAreaRafioRadioItem2());

  }

  /**
   * 非該当に内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRafioRadioItem1(){

  }

  /**
   * 該当に内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRafioRadioItem2(){

  }

  /**
   * 中山間地域等における小規模事業所加算（規模に関する状況）に内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaScaleRadioGroup(){

  }

  /**
   * 中山間地域等における小規模事業所加算（規模に関する状況）モデルに内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaScaleRadioGroupModel(){

    getProviderAddMountainousAreaScaleRadioItem1().setButtonIndex(1);

    getProviderAddMountainousAreaScaleRadioGroupModel().add(getProviderAddMountainousAreaScaleRadioItem1());

    getUsAreaScaleRadioItem2().setButtonIndex(2);

    getProviderAddMountainousAreaScaleRadioGroupModel().add(getUsAreaScaleRadioItem2());

  }

  /**
   * 非該当に内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaScaleRadioItem1(){

  }

  /**
   * 該当に内部項目を追加します。
   */
  protected void addUsAreaScaleRadioItem2(){

  }

  /**
   * 旧法項目に内部項目を追加します。
   */
  protected void addOldLowElementArea(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004_16311_201204Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004_16311_201204Design getThis() {
    return this;
  }
}
