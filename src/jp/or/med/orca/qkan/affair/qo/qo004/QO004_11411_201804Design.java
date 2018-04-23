
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
 * 作成日: 2018/01/27  日本コンピューター株式会社 日高　しのぶ 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業者登録 (004)
 * プログラム 訪問リハ (QO004_11411_201804)
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
 * 訪問リハ画面項目デザイン(QO004_11411_201804) 
 */
public class QO004_11411_201804Design extends QO004ProviderPanel {
  //GUIコンポーネント

  private ACGroupBox mainGroup;

  private ACValueArrayRadioButtonGroup facilitiesDivision;

  private ACLabelContainer facilitiesDivisionContainer;

  private ACListModelAdapter facilitiesDivisionModel;

  private ACRadioButtonItem facilitiesDivisionItem1;

  private ACRadioButtonItem facilitiesDivisionItem2;

  private ACRadioButtonItem facilitiesDivisionItem3;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRafioRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRafioRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRafioRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaRafioRadioItem1;

  private ACRadioButtonItem providerAddMountainousAreaRafioRadioItem2;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaScaleRadioGroup;

  private ACLabelContainer providerAddMountainousAreaScaleRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaScaleRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaScaleRadioItem1;

  private ACRadioButtonItem providerAddMountainousAreaScaleRadioItem2;

  private ACValueArrayRadioButtonGroup intensiveRehabilitationRadioGroup;

  private ACLabelContainer intensiveRehabilitationRadioGroupContainer;

  private ACListModelAdapter intensiveRehabilitationRadioGroupModel;

  private ACRadioButtonItem intensiveRehabilitationRadioItem1;

  private ACRadioButtonItem intensiveRehabilitationRadioItem2;

  private ACValueArrayRadioButtonGroup rehabilitationManagementRadioGroup;

  private ACLabelContainer rehabilitationManagementRadioGroupContainer;

  private ACListModelAdapter rehabilitationManagementRadioGroupModel;

  private ACRadioButtonItem rehabilitationManagementRadioItem1;

  private ACRadioButtonItem rehabilitationManagementRadioItem2;

  private ACRadioButtonItem rehabilitationManagementRadioItem3;

  private ACRadioButtonItem rehabilitationManagementRadioItem4;

  private ACRadioButtonItem rehabilitationManagementRadioItem5;

  private ACValueArrayRadioButtonGroup socialSupportRadioGroup;

  private ACLabelContainer socialSupportRadioGroupContainer;

  private ACListModelAdapter socialSupportRadioGroupModel;

  private ACRadioButtonItem socialSupportRadioItem1;

  private ACRadioButtonItem socialSupportRadioItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getMainGroup(){
    if(mainGroup==null){

      mainGroup = new ACGroupBox();

      mainGroup.setText("訪問リハ");

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

      facilitiesDivision.setBindPath("1140101");

      facilitiesDivision.setUseClearButton(false);

      facilitiesDivision.setModel(getFacilitiesDivisionModel());

      facilitiesDivision.setValues(new int[]{1,2,3});

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
   * 病院又は診療所を取得します。
   * @return 病院又は診療所
   */
  public ACRadioButtonItem getFacilitiesDivisionItem1(){
    if(facilitiesDivisionItem1==null){

      facilitiesDivisionItem1 = new ACRadioButtonItem();

      facilitiesDivisionItem1.setText("病院又は診療所");

      facilitiesDivisionItem1.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem1.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem1();
    }
    return facilitiesDivisionItem1;

  }

  /**
   * 介護老人保健施設を取得します。
   * @return 介護老人保健施設
   */
  public ACRadioButtonItem getFacilitiesDivisionItem2(){
    if(facilitiesDivisionItem2==null){

      facilitiesDivisionItem2 = new ACRadioButtonItem();

      facilitiesDivisionItem2.setText("介護老人保健施設");

      facilitiesDivisionItem2.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem2.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem2();
    }
    return facilitiesDivisionItem2;

  }

  /**
   * 介護医療院を取得します。
   * @return 介護医療院
   */
  public ACRadioButtonItem getFacilitiesDivisionItem3(){
    if(facilitiesDivisionItem3==null){

      facilitiesDivisionItem3 = new ACRadioButtonItem();

      facilitiesDivisionItem3.setText("介護医療院");

      facilitiesDivisionItem3.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem3.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem3();
    }
    return facilitiesDivisionItem3;

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
  public ACRadioButtonItem getProviderAddMountainousAreaScaleRadioItem2(){
    if(providerAddMountainousAreaScaleRadioItem2==null){

      providerAddMountainousAreaScaleRadioItem2 = new ACRadioButtonItem();

      providerAddMountainousAreaScaleRadioItem2.setText("該当");

      providerAddMountainousAreaScaleRadioItem2.setGroup(getProviderAddMountainousAreaScaleRadioGroup());

      providerAddMountainousAreaScaleRadioItem2.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaScaleRadioItem2();
    }
    return providerAddMountainousAreaScaleRadioItem2;

  }

  /**
   * 短期集中リハビリテーション実施加算を取得します。
   * @return 短期集中リハビリテーション実施加算
   */
  public ACValueArrayRadioButtonGroup getIntensiveRehabilitationRadioGroup(){
    if(intensiveRehabilitationRadioGroup==null){

      intensiveRehabilitationRadioGroup = new ACValueArrayRadioButtonGroup();

      getIntensiveRehabilitationRadioGroupContainer().setText("短期集中リハビリテーション実施加算");

      intensiveRehabilitationRadioGroup.setBindPath("1140103");

      intensiveRehabilitationRadioGroup.setVisible(true);

      intensiveRehabilitationRadioGroup.setEnabled(true);

      intensiveRehabilitationRadioGroup.setNoSelectIndex(0);

      intensiveRehabilitationRadioGroup.setUseClearButton(false);

      intensiveRehabilitationRadioGroup.setModel(getIntensiveRehabilitationRadioGroupModel());

      intensiveRehabilitationRadioGroup.setValues(new int[]{1,2});

      addIntensiveRehabilitationRadioGroup();
    }
    return intensiveRehabilitationRadioGroup;

  }

  /**
   * 短期集中リハビリテーション実施加算コンテナを取得します。
   * @return 短期集中リハビリテーション実施加算コンテナ
   */
  protected ACLabelContainer getIntensiveRehabilitationRadioGroupContainer(){
    if(intensiveRehabilitationRadioGroupContainer==null){
      intensiveRehabilitationRadioGroupContainer = new ACLabelContainer();
      intensiveRehabilitationRadioGroupContainer.setFollowChildEnabled(true);
      intensiveRehabilitationRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      intensiveRehabilitationRadioGroupContainer.add(getIntensiveRehabilitationRadioGroup(), null);
    }
    return intensiveRehabilitationRadioGroupContainer;
  }

  /**
   * 短期集中リハビリテーション実施加算モデルを取得します。
   * @return 短期集中リハビリテーション実施加算モデル
   */
  protected ACListModelAdapter getIntensiveRehabilitationRadioGroupModel(){
    if(intensiveRehabilitationRadioGroupModel==null){
      intensiveRehabilitationRadioGroupModel = new ACListModelAdapter();
      addIntensiveRehabilitationRadioGroupModel();
    }
    return intensiveRehabilitationRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getIntensiveRehabilitationRadioItem1(){
    if(intensiveRehabilitationRadioItem1==null){

      intensiveRehabilitationRadioItem1 = new ACRadioButtonItem();

      intensiveRehabilitationRadioItem1.setText("なし");

      intensiveRehabilitationRadioItem1.setGroup(getIntensiveRehabilitationRadioGroup());

      intensiveRehabilitationRadioItem1.setConstraints(VRLayout.FLOW);

      addIntensiveRehabilitationRadioItem1();
    }
    return intensiveRehabilitationRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getIntensiveRehabilitationRadioItem2(){
    if(intensiveRehabilitationRadioItem2==null){

      intensiveRehabilitationRadioItem2 = new ACRadioButtonItem();

      intensiveRehabilitationRadioItem2.setText("あり");

      intensiveRehabilitationRadioItem2.setGroup(getIntensiveRehabilitationRadioGroup());

      intensiveRehabilitationRadioItem2.setConstraints(VRLayout.FLOW);

      addIntensiveRehabilitationRadioItem2();
    }
    return intensiveRehabilitationRadioItem2;

  }

  /**
   * リハビリテーションマネジメント加算を取得します。
   * @return リハビリテーションマネジメント加算
   */
  public ACValueArrayRadioButtonGroup getRehabilitationManagementRadioGroup(){
    if(rehabilitationManagementRadioGroup==null){

      rehabilitationManagementRadioGroup = new ACValueArrayRadioButtonGroup();

      getRehabilitationManagementRadioGroupContainer().setText("リハビリテーションマネジメント加算");

      rehabilitationManagementRadioGroup.setBindPath("1140104");

      rehabilitationManagementRadioGroup.setVisible(true);

      rehabilitationManagementRadioGroup.setEnabled(true);

      rehabilitationManagementRadioGroup.setNoSelectIndex(0);

      rehabilitationManagementRadioGroup.setUseClearButton(false);

      rehabilitationManagementRadioGroup.setModel(getRehabilitationManagementRadioGroupModel());

      rehabilitationManagementRadioGroup.setValues(new int[]{1,2,3,4,5});

      addRehabilitationManagementRadioGroup();
    }
    return rehabilitationManagementRadioGroup;

  }

  /**
   * リハビリテーションマネジメント加算コンテナを取得します。
   * @return リハビリテーションマネジメント加算コンテナ
   */
  protected ACLabelContainer getRehabilitationManagementRadioGroupContainer(){
    if(rehabilitationManagementRadioGroupContainer==null){
      rehabilitationManagementRadioGroupContainer = new ACLabelContainer();
      rehabilitationManagementRadioGroupContainer.setFollowChildEnabled(true);
      rehabilitationManagementRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      rehabilitationManagementRadioGroupContainer.add(getRehabilitationManagementRadioGroup(), null);
    }
    return rehabilitationManagementRadioGroupContainer;
  }

  /**
   * リハビリテーションマネジメント加算モデルを取得します。
   * @return リハビリテーションマネジメント加算モデル
   */
  protected ACListModelAdapter getRehabilitationManagementRadioGroupModel(){
    if(rehabilitationManagementRadioGroupModel==null){
      rehabilitationManagementRadioGroupModel = new ACListModelAdapter();
      addRehabilitationManagementRadioGroupModel();
    }
    return rehabilitationManagementRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getRehabilitationManagementRadioItem1(){
    if(rehabilitationManagementRadioItem1==null){

      rehabilitationManagementRadioItem1 = new ACRadioButtonItem();

      rehabilitationManagementRadioItem1.setText("なし");

      rehabilitationManagementRadioItem1.setGroup(getRehabilitationManagementRadioGroup());

      rehabilitationManagementRadioItem1.setConstraints(VRLayout.FLOW);

      addRehabilitationManagementRadioItem1();
    }
    return rehabilitationManagementRadioItem1;

  }

  /**
   * 加算Iを取得します。
   * @return 加算I
   */
  public ACRadioButtonItem getRehabilitationManagementRadioItem2(){
    if(rehabilitationManagementRadioItem2==null){

      rehabilitationManagementRadioItem2 = new ACRadioButtonItem();

      rehabilitationManagementRadioItem2.setText("加算I");

      rehabilitationManagementRadioItem2.setGroup(getRehabilitationManagementRadioGroup());

      rehabilitationManagementRadioItem2.setConstraints(VRLayout.FLOW);

      addRehabilitationManagementRadioItem2();
    }
    return rehabilitationManagementRadioItem2;

  }

  /**
   * 加算IIを取得します。
   * @return 加算II
   */
  public ACRadioButtonItem getRehabilitationManagementRadioItem3(){
    if(rehabilitationManagementRadioItem3==null){

      rehabilitationManagementRadioItem3 = new ACRadioButtonItem();

      rehabilitationManagementRadioItem3.setText("加算II");

      rehabilitationManagementRadioItem3.setGroup(getRehabilitationManagementRadioGroup());

      rehabilitationManagementRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addRehabilitationManagementRadioItem3();
    }
    return rehabilitationManagementRadioItem3;

  }

  /**
   * 加算IIIを取得します。
   * @return 加算III
   */
  public ACRadioButtonItem getRehabilitationManagementRadioItem4(){
    if(rehabilitationManagementRadioItem4==null){

      rehabilitationManagementRadioItem4 = new ACRadioButtonItem();

      rehabilitationManagementRadioItem4.setText("加算III");

      rehabilitationManagementRadioItem4.setGroup(getRehabilitationManagementRadioGroup());

      rehabilitationManagementRadioItem4.setConstraints(VRLayout.FLOW);

      addRehabilitationManagementRadioItem4();
    }
    return rehabilitationManagementRadioItem4;

  }

  /**
   * 加算IVを取得します。
   * @return 加算IV
   */
  public ACRadioButtonItem getRehabilitationManagementRadioItem5(){
    if(rehabilitationManagementRadioItem5==null){

      rehabilitationManagementRadioItem5 = new ACRadioButtonItem();

      rehabilitationManagementRadioItem5.setText("加算IV");

      rehabilitationManagementRadioItem5.setGroup(getRehabilitationManagementRadioGroup());

      rehabilitationManagementRadioItem5.setConstraints(VRLayout.FLOW);

      addRehabilitationManagementRadioItem5();
    }
    return rehabilitationManagementRadioItem5;

  }

  /**
   * 社会参加支援加算を取得します。
   * @return 社会参加支援加算
   */
  public ACValueArrayRadioButtonGroup getSocialSupportRadioGroup(){
    if(socialSupportRadioGroup==null){

      socialSupportRadioGroup = new ACValueArrayRadioButtonGroup();

      getSocialSupportRadioGroupContainer().setText("社会参加支援加算");

      socialSupportRadioGroup.setBindPath("1140105");

      socialSupportRadioGroup.setVisible(true);

      socialSupportRadioGroup.setEnabled(true);

      socialSupportRadioGroup.setNoSelectIndex(0);

      socialSupportRadioGroup.setUseClearButton(false);

      socialSupportRadioGroup.setModel(getSocialSupportRadioGroupModel());

      socialSupportRadioGroup.setValues(new int[]{1,2});

      addSocialSupportRadioGroup();
    }
    return socialSupportRadioGroup;

  }

  /**
   * 社会参加支援加算コンテナを取得します。
   * @return 社会参加支援加算コンテナ
   */
  protected ACLabelContainer getSocialSupportRadioGroupContainer(){
    if(socialSupportRadioGroupContainer==null){
      socialSupportRadioGroupContainer = new ACLabelContainer();
      socialSupportRadioGroupContainer.setFollowChildEnabled(true);
      socialSupportRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      socialSupportRadioGroupContainer.add(getSocialSupportRadioGroup(), null);
    }
    return socialSupportRadioGroupContainer;
  }

  /**
   * 社会参加支援加算モデルを取得します。
   * @return 社会参加支援加算モデル
   */
  protected ACListModelAdapter getSocialSupportRadioGroupModel(){
    if(socialSupportRadioGroupModel==null){
      socialSupportRadioGroupModel = new ACListModelAdapter();
      addSocialSupportRadioGroupModel();
    }
    return socialSupportRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSocialSupportRadioItem1(){
    if(socialSupportRadioItem1==null){

      socialSupportRadioItem1 = new ACRadioButtonItem();

      socialSupportRadioItem1.setText("なし");

      socialSupportRadioItem1.setGroup(getSocialSupportRadioGroup());

      socialSupportRadioItem1.setConstraints(VRLayout.FLOW);

      addSocialSupportRadioItem1();
    }
    return socialSupportRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getSocialSupportRadioItem2(){
    if(socialSupportRadioItem2==null){

      socialSupportRadioItem2 = new ACRadioButtonItem();

      socialSupportRadioItem2.setText("あり");

      socialSupportRadioItem2.setGroup(getSocialSupportRadioGroup());

      socialSupportRadioItem2.setConstraints(VRLayout.FLOW);

      addSocialSupportRadioItem2();
    }
    return socialSupportRadioItem2;

  }

  /**
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1140102");

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
   * コンストラクタです。
   */
  public QO004_11411_201804Design() {

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

    mainGroup.add(getProviderAddMountainousAreaRafioRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getProviderAddMountainousAreaScaleRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getIntensiveRehabilitationRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getRehabilitationManagementRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getSocialSupportRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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

    getFacilitiesDivisionItem3().setButtonIndex(3);

    getFacilitiesDivisionModel().add(getFacilitiesDivisionItem3());

  }

  /**
   * 病院又は診療所に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem1(){

  }

  /**
   * 介護老人保健施設に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem2(){

  }

  /**
   * 介護医療院に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem3(){

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

    getProviderAddMountainousAreaScaleRadioItem2().setButtonIndex(2);

    getProviderAddMountainousAreaScaleRadioGroupModel().add(getProviderAddMountainousAreaScaleRadioItem2());

  }

  /**
   * 非該当に内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaScaleRadioItem1(){

  }

  /**
   * 該当に内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaScaleRadioItem2(){

  }

  /**
   * 短期集中リハビリテーション実施加算に内部項目を追加します。
   */
  protected void addIntensiveRehabilitationRadioGroup(){

  }

  /**
   * 短期集中リハビリテーション実施加算モデルに内部項目を追加します。
   */
  protected void addIntensiveRehabilitationRadioGroupModel(){

    getIntensiveRehabilitationRadioItem1().setButtonIndex(1);

    getIntensiveRehabilitationRadioGroupModel().add(getIntensiveRehabilitationRadioItem1());

    getIntensiveRehabilitationRadioItem2().setButtonIndex(2);

    getIntensiveRehabilitationRadioGroupModel().add(getIntensiveRehabilitationRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addIntensiveRehabilitationRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addIntensiveRehabilitationRadioItem2(){

  }

  /**
   * リハビリテーションマネジメント加算に内部項目を追加します。
   */
  protected void addRehabilitationManagementRadioGroup(){

  }

  /**
   * リハビリテーションマネジメント加算モデルに内部項目を追加します。
   */
  protected void addRehabilitationManagementRadioGroupModel(){

    getRehabilitationManagementRadioItem1().setButtonIndex(1);

    getRehabilitationManagementRadioGroupModel().add(getRehabilitationManagementRadioItem1());

    getRehabilitationManagementRadioItem2().setButtonIndex(2);

    getRehabilitationManagementRadioGroupModel().add(getRehabilitationManagementRadioItem2());

    getRehabilitationManagementRadioItem3().setButtonIndex(3);

    getRehabilitationManagementRadioGroupModel().add(getRehabilitationManagementRadioItem3());

    getRehabilitationManagementRadioItem4().setButtonIndex(4);

    getRehabilitationManagementRadioGroupModel().add(getRehabilitationManagementRadioItem4());

    getRehabilitationManagementRadioItem5().setButtonIndex(5);

    getRehabilitationManagementRadioGroupModel().add(getRehabilitationManagementRadioItem5());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addRehabilitationManagementRadioItem1(){

  }

  /**
   * 加算Iに内部項目を追加します。
   */
  protected void addRehabilitationManagementRadioItem2(){

  }

  /**
   * 加算IIに内部項目を追加します。
   */
  protected void addRehabilitationManagementRadioItem3(){

  }

  /**
   * 加算IIIに内部項目を追加します。
   */
  protected void addRehabilitationManagementRadioItem4(){

  }

  /**
   * 加算IVに内部項目を追加します。
   */
  protected void addRehabilitationManagementRadioItem5(){

  }

  /**
   * 社会参加支援加算に内部項目を追加します。
   */
  protected void addSocialSupportRadioGroup(){

  }

  /**
   * 社会参加支援加算モデルに内部項目を追加します。
   */
  protected void addSocialSupportRadioGroupModel(){

    getSocialSupportRadioItem1().setButtonIndex(1);

    getSocialSupportRadioGroupModel().add(getSocialSupportRadioItem1());

    getSocialSupportRadioItem2().setButtonIndex(2);

    getSocialSupportRadioGroupModel().add(getSocialSupportRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSocialSupportRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addSocialSupportRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004_11411_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004_11411_201804Design getThis() {
    return this;
  }
}
