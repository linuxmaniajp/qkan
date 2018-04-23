
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
 * 作成日: 2018/03/06  日本コンピューター株式会社 日高　しのぶ 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業者登録 (004)
 * プログラム 居宅介護支援 (QO004_14311_201804)
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
 * 居宅介護支援画面項目デザイン(QO004_14311_201804) 
 */
public class QO004_14311_201804Design extends QO004ProviderPanel {
  //GUIコンポーネント

  private ACGroupBox mainGroup;

  private ACPanel calculationDetails;

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

  private ACValueArrayRadioButtonGroup specificProviderSub;

  private ACLabelContainer specificProviderSubContainer;

  private ACListModelAdapter specificProviderSubModel;

  private ACRadioButtonItem specificProviderSubItem1;

  private ACRadioButtonItem specificProviderSubItem2;

  private ACValueArrayRadioButtonGroup specificProviderAdd;

  private ACLabelContainer specificProviderAddContainer;

  private ACListModelAdapter specificProviderAddModel;

  private ACRadioButtonItem specificProviderAddItem1;

  private ACRadioButtonItem specificProviderAddItem2;

  private ACRadioButtonItem specificProviderAddItem3;

  private ACRadioButtonItem specificProviderAddItem4;

  private ACValueArrayRadioButtonGroup specificProviderAdd4;

  private ACLabelContainer specificProviderAdd4Container;

  private ACListModelAdapter specificProviderAdd4Model;

  private ACRadioButtonItem specificProviderAdd4Item1;

  private ACRadioButtonItem specificProviderAdd4Item2;

  private ACValueArrayRadioButtonGroup terminalCareManagement;

  private ACLabelContainer terminalCareManagementContainer;

  private ACListModelAdapter terminalCareManagementModel;

  private ACRadioButtonItem terminalCareManagementItem1;

  private ACRadioButtonItem terminalCareManagementItem2;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getMainGroup(){
    if(mainGroup==null){

      mainGroup = new ACGroupBox();

      mainGroup.setText("居宅介護支援");

      mainGroup.setFollowChildEnabled(true);

      mainGroup.setHgrid(200);

      addMainGroup();
    }
    return mainGroup;

  }

  /**
   * 算定項目領域を取得します。
   * @return 算定項目領域
   */
  public ACPanel getCalculationDetails(){
    if(calculationDetails==null){

      calculationDetails = new ACPanel();

      calculationDetails.setFollowChildEnabled(true);

      calculationDetails.setHgrid(200);

      addCalculationDetails();
    }
    return calculationDetails;

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
   * 特定事業所集中減算を取得します。
   * @return 特定事業所集中減算
   */
  public ACValueArrayRadioButtonGroup getSpecificProviderSub(){
    if(specificProviderSub==null){

      specificProviderSub = new ACValueArrayRadioButtonGroup();

      getSpecificProviderSubContainer().setText("特定事業所集中減算");

      specificProviderSub.setBindPath("1430102");

      specificProviderSub.setNoSelectIndex(0);

      specificProviderSub.setUseClearButton(false);

      specificProviderSub.setModel(getSpecificProviderSubModel());

      specificProviderSub.setValues(new int[]{1,2});

      addSpecificProviderSub();
    }
    return specificProviderSub;

  }

  /**
   * 特定事業所集中減算コンテナを取得します。
   * @return 特定事業所集中減算コンテナ
   */
  protected ACLabelContainer getSpecificProviderSubContainer(){
    if(specificProviderSubContainer==null){
      specificProviderSubContainer = new ACLabelContainer();
      specificProviderSubContainer.setFollowChildEnabled(true);
      specificProviderSubContainer.setVAlignment(VRLayout.CENTER);
      specificProviderSubContainer.add(getSpecificProviderSub(), null);
    }
    return specificProviderSubContainer;
  }

  /**
   * 特定事業所集中減算モデルを取得します。
   * @return 特定事業所集中減算モデル
   */
  protected ACListModelAdapter getSpecificProviderSubModel(){
    if(specificProviderSubModel==null){
      specificProviderSubModel = new ACListModelAdapter();
      addSpecificProviderSubModel();
    }
    return specificProviderSubModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSpecificProviderSubItem1(){
    if(specificProviderSubItem1==null){

      specificProviderSubItem1 = new ACRadioButtonItem();

      specificProviderSubItem1.setText("なし");

      specificProviderSubItem1.setGroup(getSpecificProviderSub());

      specificProviderSubItem1.setConstraints(VRLayout.FLOW);

      addSpecificProviderSubItem1();
    }
    return specificProviderSubItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getSpecificProviderSubItem2(){
    if(specificProviderSubItem2==null){

      specificProviderSubItem2 = new ACRadioButtonItem();

      specificProviderSubItem2.setText("あり");

      specificProviderSubItem2.setGroup(getSpecificProviderSub());

      specificProviderSubItem2.setConstraints(VRLayout.FLOW);

      addSpecificProviderSubItem2();
    }
    return specificProviderSubItem2;

  }

  /**
   * 特定事業所加算を取得します。
   * @return 特定事業所加算
   */
  public ACValueArrayRadioButtonGroup getSpecificProviderAdd(){
    if(specificProviderAdd==null){

      specificProviderAdd = new ACValueArrayRadioButtonGroup();

      getSpecificProviderAddContainer().setText("特定事業所加算");

      specificProviderAdd.setBindPath("1430104");

      specificProviderAdd.setNoSelectIndex(0);

      specificProviderAdd.setUseClearButton(false);

      specificProviderAdd.setModel(getSpecificProviderAddModel());

      specificProviderAdd.setValues(new int[]{1,2,3,4});

      addSpecificProviderAdd();
    }
    return specificProviderAdd;

  }

  /**
   * 特定事業所加算コンテナを取得します。
   * @return 特定事業所加算コンテナ
   */
  protected ACLabelContainer getSpecificProviderAddContainer(){
    if(specificProviderAddContainer==null){
      specificProviderAddContainer = new ACLabelContainer();
      specificProviderAddContainer.setFollowChildEnabled(true);
      specificProviderAddContainer.setVAlignment(VRLayout.CENTER);
      specificProviderAddContainer.add(getSpecificProviderAdd(), null);
    }
    return specificProviderAddContainer;
  }

  /**
   * 特定事業所加算モデルを取得します。
   * @return 特定事業所加算モデル
   */
  protected ACListModelAdapter getSpecificProviderAddModel(){
    if(specificProviderAddModel==null){
      specificProviderAddModel = new ACListModelAdapter();
      addSpecificProviderAddModel();
    }
    return specificProviderAddModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSpecificProviderAddItem1(){
    if(specificProviderAddItem1==null){

      specificProviderAddItem1 = new ACRadioButtonItem();

      specificProviderAddItem1.setText("なし");

      specificProviderAddItem1.setGroup(getSpecificProviderAdd());

      specificProviderAddItem1.setConstraints(VRLayout.FLOW);

      addSpecificProviderAddItem1();
    }
    return specificProviderAddItem1;

  }

  /**
   * 加算Iを取得します。
   * @return 加算I
   */
  public ACRadioButtonItem getSpecificProviderAddItem2(){
    if(specificProviderAddItem2==null){

      specificProviderAddItem2 = new ACRadioButtonItem();

      specificProviderAddItem2.setText("加算I");

      specificProviderAddItem2.setGroup(getSpecificProviderAdd());

      specificProviderAddItem2.setConstraints(VRLayout.FLOW);

      addSpecificProviderAddItem2();
    }
    return specificProviderAddItem2;

  }

  /**
   * 加算IIを取得します。
   * @return 加算II
   */
  public ACRadioButtonItem getSpecificProviderAddItem3(){
    if(specificProviderAddItem3==null){

      specificProviderAddItem3 = new ACRadioButtonItem();

      specificProviderAddItem3.setText("加算II");

      specificProviderAddItem3.setGroup(getSpecificProviderAdd());

      specificProviderAddItem3.setConstraints(VRLayout.FLOW);

      addSpecificProviderAddItem3();
    }
    return specificProviderAddItem3;

  }

  /**
   * 加算IIIを取得します。
   * @return 加算III
   */
  public ACRadioButtonItem getSpecificProviderAddItem4(){
    if(specificProviderAddItem4==null){

      specificProviderAddItem4 = new ACRadioButtonItem();

      specificProviderAddItem4.setText("加算III");

      specificProviderAddItem4.setGroup(getSpecificProviderAdd());

      specificProviderAddItem4.setConstraints(VRLayout.FLOW);

      addSpecificProviderAddItem4();
    }
    return specificProviderAddItem4;

  }

  /**
   * 特定事業所加算IVを取得します。
   * @return 特定事業所加算IV
   */
  public ACValueArrayRadioButtonGroup getSpecificProviderAdd4(){
    if(specificProviderAdd4==null){

      specificProviderAdd4 = new ACValueArrayRadioButtonGroup();

      getSpecificProviderAdd4Container().setText("特定事業所加算IV");

      specificProviderAdd4.setBindPath("1430105");

      specificProviderAdd4.setNoSelectIndex(0);

      specificProviderAdd4.setUseClearButton(false);

      specificProviderAdd4.setModel(getSpecificProviderAdd4Model());

      specificProviderAdd4.setValues(new int[]{1,2});

      addSpecificProviderAdd4();
    }
    return specificProviderAdd4;

  }

  /**
   * 特定事業所加算IVコンテナを取得します。
   * @return 特定事業所加算IVコンテナ
   */
  protected ACLabelContainer getSpecificProviderAdd4Container(){
    if(specificProviderAdd4Container==null){
      specificProviderAdd4Container = new ACLabelContainer();
      specificProviderAdd4Container.setFollowChildEnabled(true);
      specificProviderAdd4Container.setVAlignment(VRLayout.CENTER);
      specificProviderAdd4Container.add(getSpecificProviderAdd4(), null);
    }
    return specificProviderAdd4Container;
  }

  /**
   * 特定事業所加算IVモデルを取得します。
   * @return 特定事業所加算IVモデル
   */
  protected ACListModelAdapter getSpecificProviderAdd4Model(){
    if(specificProviderAdd4Model==null){
      specificProviderAdd4Model = new ACListModelAdapter();
      addSpecificProviderAdd4Model();
    }
    return specificProviderAdd4Model;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSpecificProviderAdd4Item1(){
    if(specificProviderAdd4Item1==null){

      specificProviderAdd4Item1 = new ACRadioButtonItem();

      specificProviderAdd4Item1.setText("なし");

      specificProviderAdd4Item1.setGroup(getSpecificProviderAdd4());

      specificProviderAdd4Item1.setConstraints(VRLayout.FLOW);

      addSpecificProviderAdd4Item1();
    }
    return specificProviderAdd4Item1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getSpecificProviderAdd4Item2(){
    if(specificProviderAdd4Item2==null){

      specificProviderAdd4Item2 = new ACRadioButtonItem();

      specificProviderAdd4Item2.setText("あり");

      specificProviderAdd4Item2.setGroup(getSpecificProviderAdd4());

      specificProviderAdd4Item2.setConstraints(VRLayout.FLOW);

      addSpecificProviderAdd4Item2();
    }
    return specificProviderAdd4Item2;

  }

  /**
   * ターミナルケアマネジメント加算を取得します。
   * @return ターミナルケアマネジメント加算
   */
  public ACValueArrayRadioButtonGroup getTerminalCareManagement(){
    if(terminalCareManagement==null){

      terminalCareManagement = new ACValueArrayRadioButtonGroup();

      getTerminalCareManagementContainer().setText("ターミナルケアマネジメント加算");

      terminalCareManagement.setBindPath("1430106");

      terminalCareManagement.setNoSelectIndex(0);

      terminalCareManagement.setUseClearButton(false);

      terminalCareManagement.setModel(getTerminalCareManagementModel());

      terminalCareManagement.setValues(new int[]{1,2});

      addTerminalCareManagement();
    }
    return terminalCareManagement;

  }

  /**
   * ターミナルケアマネジメント加算コンテナを取得します。
   * @return ターミナルケアマネジメント加算コンテナ
   */
  protected ACLabelContainer getTerminalCareManagementContainer(){
    if(terminalCareManagementContainer==null){
      terminalCareManagementContainer = new ACLabelContainer();
      terminalCareManagementContainer.setFollowChildEnabled(true);
      terminalCareManagementContainer.setVAlignment(VRLayout.CENTER);
      terminalCareManagementContainer.add(getTerminalCareManagement(), null);
    }
    return terminalCareManagementContainer;
  }

  /**
   * ターミナルケアマネジメント加算モデルを取得します。
   * @return ターミナルケアマネジメント加算モデル
   */
  protected ACListModelAdapter getTerminalCareManagementModel(){
    if(terminalCareManagementModel==null){
      terminalCareManagementModel = new ACListModelAdapter();
      addTerminalCareManagementModel();
    }
    return terminalCareManagementModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTerminalCareManagementItem1(){
    if(terminalCareManagementItem1==null){

      terminalCareManagementItem1 = new ACRadioButtonItem();

      terminalCareManagementItem1.setText("なし");

      terminalCareManagementItem1.setGroup(getTerminalCareManagement());

      terminalCareManagementItem1.setConstraints(VRLayout.FLOW);

      addTerminalCareManagementItem1();
    }
    return terminalCareManagementItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getTerminalCareManagementItem2(){
    if(terminalCareManagementItem2==null){

      terminalCareManagementItem2 = new ACRadioButtonItem();

      terminalCareManagementItem2.setText("あり");

      terminalCareManagementItem2.setGroup(getTerminalCareManagement());

      terminalCareManagementItem2.setConstraints(VRLayout.FLOW);

      addTerminalCareManagementItem2();
    }
    return terminalCareManagementItem2;

  }

  /**
   * コンストラクタです。
   */
  public QO004_14311_201804Design() {

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

    mainGroup.add(getCalculationDetails(), VRLayout.NORTH);

  }

  /**
   * 算定項目領域に内部項目を追加します。
   */
  protected void addCalculationDetails(){

    calculationDetails.add(getProviderAddMountainousAreaRafioRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getProviderAddMountainousAreaScaleRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getSpecificProviderSubContainer(), VRLayout.FLOW_RETURN);

    calculationDetails.add(getSpecificProviderAddContainer(), VRLayout.FLOW_RETURN);

    calculationDetails.add(getSpecificProviderAdd4Container(), VRLayout.FLOW_RETURN);

    calculationDetails.add(getTerminalCareManagementContainer(), VRLayout.FLOW_RETURN);

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
   * 特定事業所集中減算に内部項目を追加します。
   */
  protected void addSpecificProviderSub(){

  }

  /**
   * 特定事業所集中減算モデルに内部項目を追加します。
   */
  protected void addSpecificProviderSubModel(){

    getSpecificProviderSubItem1().setButtonIndex(1);

    getSpecificProviderSubModel().add(getSpecificProviderSubItem1());

    getSpecificProviderSubItem2().setButtonIndex(2);

    getSpecificProviderSubModel().add(getSpecificProviderSubItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSpecificProviderSubItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addSpecificProviderSubItem2(){

  }

  /**
   * 特定事業所加算に内部項目を追加します。
   */
  protected void addSpecificProviderAdd(){

  }

  /**
   * 特定事業所加算モデルに内部項目を追加します。
   */
  protected void addSpecificProviderAddModel(){

    getSpecificProviderAddItem1().setButtonIndex(1);

    getSpecificProviderAddModel().add(getSpecificProviderAddItem1());

    getSpecificProviderAddItem2().setButtonIndex(2);

    getSpecificProviderAddModel().add(getSpecificProviderAddItem2());

    getSpecificProviderAddItem3().setButtonIndex(3);

    getSpecificProviderAddModel().add(getSpecificProviderAddItem3());

    getSpecificProviderAddItem4().setButtonIndex(4);

    getSpecificProviderAddModel().add(getSpecificProviderAddItem4());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSpecificProviderAddItem1(){

  }

  /**
   * 加算Iに内部項目を追加します。
   */
  protected void addSpecificProviderAddItem2(){

  }

  /**
   * 加算IIに内部項目を追加します。
   */
  protected void addSpecificProviderAddItem3(){

  }

  /**
   * 加算IIIに内部項目を追加します。
   */
  protected void addSpecificProviderAddItem4(){

  }

  /**
   * 特定事業所加算IVに内部項目を追加します。
   */
  protected void addSpecificProviderAdd4(){

  }

  /**
   * 特定事業所加算IVモデルに内部項目を追加します。
   */
  protected void addSpecificProviderAdd4Model(){

    getSpecificProviderAdd4Item1().setButtonIndex(1);

    getSpecificProviderAdd4Model().add(getSpecificProviderAdd4Item1());

    getSpecificProviderAdd4Item2().setButtonIndex(2);

    getSpecificProviderAdd4Model().add(getSpecificProviderAdd4Item2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSpecificProviderAdd4Item1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addSpecificProviderAdd4Item2(){

  }

  /**
   * ターミナルケアマネジメント加算に内部項目を追加します。
   */
  protected void addTerminalCareManagement(){

  }

  /**
   * ターミナルケアマネジメント加算モデルに内部項目を追加します。
   */
  protected void addTerminalCareManagementModel(){

    getTerminalCareManagementItem1().setButtonIndex(1);

    getTerminalCareManagementModel().add(getTerminalCareManagementItem1());

    getTerminalCareManagementItem2().setButtonIndex(2);

    getTerminalCareManagementModel().add(getTerminalCareManagementItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTerminalCareManagementItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addTerminalCareManagementItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004_14311_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004_14311_201804Design getThis() {
    return this;
  }
}
