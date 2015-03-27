
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
 * 作成日: 2015/02/28  日本コンピューター株式会社 松本　幸一 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業者登録 (004)
 * プログラム 夜間対応型訪問看護 (QO004_17111_201504)
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
 * 夜間対応型訪問看護画面項目デザイン(QO004_17111_201504) 
 */
public class QO004_17111_201504Design extends QO004ProviderPanel {
  //GUIコンポーネント

  private ACGroupBox mainGroup;

  private ACPanel providerMainPanel;

  private ACValueArrayRadioButtonGroup facilitiesDivision;

  private ACLabelContainer facilitiesDivisionContainer;

  private ACListModelAdapter facilitiesDivisionModel;

  private ACRadioButtonItem facilitiesDivisionItem1;

  private ACRadioButtonItem facilitiesDivisionItem2;

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

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

  private ACValueArrayRadioButtonGroup staffUpgradeRadioGroup;

  private ACLabelContainer staffUpgradeRadioGroupContainer;

  private ACListModelAdapter staffUpgradeRadioGroupModel;

  private ACRadioButtonItem staffUpgradeRadioItem1;

  private ACRadioButtonItem staffUpgradeRadioItem2;

  private ACRadioButtonItem staffUpgradeRadioItem3;

  private ACRadioButtonItem staffUpgradeRadioItem4;

  private ACRadioButtonItem staffUpgradeRadioItem5;

  private ACValueArrayRadioButtonGroup baseMunicipalityAdd;

  private ACLabelContainer baseMunicipalityAddContainer;

  private ACListModelAdapter baseMunicipalityAddModel;

  private ACRadioButtonItem baseMunicipalityAddItem1;

  private ACRadioButtonItem baseMunicipalityAddItem2;

  private ACRadioButtonItem baseMunicipalityAddItem3;

  private ACRadioButtonItem baseMunicipalityAddItem4;

  private ACRadioButtonItem baseMunicipalityAddItem5;

  private ACRadioButtonItem baseMunicipalityAddItem6;

  private ACRadioButtonItem baseMunicipalityAddItem7;

  private ACValueArrayRadioButtonGroup serviceMunicipalityAdd;

  private ACLabelContainer serviceMunicipalityAddContainer;

  private ACListModelAdapter serviceMunicipalityAddModel;

  private ACRadioButtonItem serviceMunicipalityAddItem1;

  private ACRadioButtonItem serviceMunicipalityAddItem2;

  private ACRadioButtonItem serviceMunicipalityAddItem3;

  private ACRadioButtonItem serviceMunicipalityAddItem4;

  private ACRadioButtonItem serviceMunicipalityAddItem5;

  private ACRadioButtonItem serviceMunicipalityAddItem6;

  private ACRadioButtonItem serviceMunicipalityAddItem7;

  private ACLabelContainer reduceRateContainer;

  private ACTextField reduceRate;

  private ACLabel percentSign;

  private ACIntegerCheckBox ShahukuReduce;

  private ACPanel oldLowElementArea;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getMainGroup(){
    if(mainGroup==null){

      mainGroup = new ACGroupBox();

      mainGroup.setText("夜間対応型訪問介護");

      mainGroup.setFollowChildEnabled(true);

      mainGroup.setHgrid(200);

      addMainGroup();
    }
    return mainGroup;

  }

  /**
   * 事業所メインパネルを取得します。
   * @return 事業所メインパネル
   */
  public ACPanel getProviderMainPanel(){
    if(providerMainPanel==null){

      providerMainPanel = new ACPanel();

      providerMainPanel.setFollowChildEnabled(true);

      providerMainPanel.setHgap(0);

      providerMainPanel.setLabelMargin(0);

      providerMainPanel.setVgap(0);

      addProviderMainPanel();
    }
    return providerMainPanel;

  }

  /**
   * 施設区分ラジオグループを取得します。
   * @return 施設区分ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getFacilitiesDivision(){
    if(facilitiesDivision==null){

      facilitiesDivision = new ACValueArrayRadioButtonGroup();

      getFacilitiesDivisionContainer().setText("施設等の区分");

      facilitiesDivision.setBindPath("1710101");

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
   * Ⅰ型を取得します。
   * @return Ⅰ型
   */
  public ACRadioButtonItem getFacilitiesDivisionItem1(){
    if(facilitiesDivisionItem1==null){

      facilitiesDivisionItem1 = new ACRadioButtonItem();

      facilitiesDivisionItem1.setText("I 型");

      facilitiesDivisionItem1.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem1.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem1();
    }
    return facilitiesDivisionItem1;

  }

  /**
   * Ⅱ型を取得します。
   * @return Ⅱ型
   */
  public ACRadioButtonItem getFacilitiesDivisionItem2(){
    if(facilitiesDivisionItem2==null){

      facilitiesDivisionItem2 = new ACRadioButtonItem();

      facilitiesDivisionItem2.setText("II 型");

      facilitiesDivisionItem2.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem2.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem2();
    }
    return facilitiesDivisionItem2;

  }

  /**
   * 24時間通報対応加算を取得します。
   * @return 24時間通報対応加算
   */
  public ACValueArrayRadioButtonGroup getHours24MessageAddRadioGroup(){
    if(hours24MessageAddRadioGroup==null){

      hours24MessageAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getHours24MessageAddRadioGroupContainer().setText("24時間通報対応加算");

      hours24MessageAddRadioGroup.setBindPath("1710103");

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
   * 対応不可を取得します。
   * @return 対応不可
   */
  public ACRadioButtonItem getHours24MessageAddRadioItem1(){
    if(hours24MessageAddRadioItem1==null){

      hours24MessageAddRadioItem1 = new ACRadioButtonItem();

      hours24MessageAddRadioItem1.setText("対応不可");

      hours24MessageAddRadioItem1.setGroup(getHours24MessageAddRadioGroup());

      hours24MessageAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHours24MessageAddRadioItem1();
    }
    return hours24MessageAddRadioItem1;

  }

  /**
   * 対応可を取得します。
   * @return 対応可
   */
  public ACRadioButtonItem getHours24MessageAddRadioItem2(){
    if(hours24MessageAddRadioItem2==null){

      hours24MessageAddRadioItem2 = new ACRadioButtonItem();

      hours24MessageAddRadioItem2.setText("対応可");

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

      serviceAddProvisionStructuralRadioGroup.setBindPath("1710104");

      serviceAddProvisionStructuralRadioGroup.setVisible(true);

      serviceAddProvisionStructuralRadioGroup.setEnabled(true);

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,4,2,5,3});

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
   * 加算Iイを取得します。
   * @return 加算Iイ
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("加算Iイ");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem2();
    }
    return serviceAddProvisionStructuralRadioItem2;

  }

  /**
   * 加算Iロを取得します。
   * @return 加算Iロ
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem3(){
    if(serviceAddProvisionStructuralRadioItem3==null){

      serviceAddProvisionStructuralRadioItem3 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem3.setText("加算Iロ");

      serviceAddProvisionStructuralRadioItem3.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem3();
    }
    return serviceAddProvisionStructuralRadioItem3;

  }

  /**
   * 加算IIイを取得します。
   * @return 加算IIイ
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem4(){
    if(serviceAddProvisionStructuralRadioItem4==null){

      serviceAddProvisionStructuralRadioItem4 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem4.setText("加算IIイ");

      serviceAddProvisionStructuralRadioItem4.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem4.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem4();
    }
    return serviceAddProvisionStructuralRadioItem4;

  }

  /**
   * 加算IIロを取得します。
   * @return 加算IIロ
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem5(){
    if(serviceAddProvisionStructuralRadioItem5==null){

      serviceAddProvisionStructuralRadioItem5 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem5.setText("加算IIロ");

      serviceAddProvisionStructuralRadioItem5.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem5.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem5();
    }
    return serviceAddProvisionStructuralRadioItem5;

  }

  /**
   * 介護職員処遇改善加算を取得します。
   * @return 介護職員処遇改善加算
   */
  public ACValueArrayRadioButtonGroup getStaffUpgradeRadioGroup(){
    if(staffUpgradeRadioGroup==null){

      staffUpgradeRadioGroup = new ACValueArrayRadioButtonGroup();

      getStaffUpgradeRadioGroupContainer().setText("介護職員処遇改善加算");

      staffUpgradeRadioGroup.setBindPath("4");

      staffUpgradeRadioGroup.setEnabled(true);

      staffUpgradeRadioGroup.setUseClearButton(false);

      staffUpgradeRadioGroup.setModel(getStaffUpgradeRadioGroupModel());

      staffUpgradeRadioGroup.setValues(new int[]{1,5,2,3,4});

      addStaffUpgradeRadioGroup();
    }
    return staffUpgradeRadioGroup;

  }

  /**
   * 介護職員処遇改善加算コンテナを取得します。
   * @return 介護職員処遇改善加算コンテナ
   */
  protected ACLabelContainer getStaffUpgradeRadioGroupContainer(){
    if(staffUpgradeRadioGroupContainer==null){
      staffUpgradeRadioGroupContainer = new ACLabelContainer();
      staffUpgradeRadioGroupContainer.setFollowChildEnabled(true);
      staffUpgradeRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      staffUpgradeRadioGroupContainer.add(getStaffUpgradeRadioGroup(), null);
    }
    return staffUpgradeRadioGroupContainer;
  }

  /**
   * 介護職員処遇改善加算モデルを取得します。
   * @return 介護職員処遇改善加算モデル
   */
  protected ACListModelAdapter getStaffUpgradeRadioGroupModel(){
    if(staffUpgradeRadioGroupModel==null){
      staffUpgradeRadioGroupModel = new ACListModelAdapter();
      addStaffUpgradeRadioGroupModel();
    }
    return staffUpgradeRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getStaffUpgradeRadioItem1(){
    if(staffUpgradeRadioItem1==null){

      staffUpgradeRadioItem1 = new ACRadioButtonItem();

      staffUpgradeRadioItem1.setText("なし");

      staffUpgradeRadioItem1.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem1.setConstraints(VRLayout.FLOW);

      addStaffUpgradeRadioItem1();
    }
    return staffUpgradeRadioItem1;

  }

  /**
   * 加算Iを取得します。
   * @return 加算I
   */
  public ACRadioButtonItem getStaffUpgradeRadioItem2(){
    if(staffUpgradeRadioItem2==null){

      staffUpgradeRadioItem2 = new ACRadioButtonItem();

      staffUpgradeRadioItem2.setText("加算I");

      staffUpgradeRadioItem2.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem2.setConstraints(VRLayout.FLOW);

      addStaffUpgradeRadioItem2();
    }
    return staffUpgradeRadioItem2;

  }

  /**
   * 加算IIを取得します。
   * @return 加算II
   */
  public ACRadioButtonItem getStaffUpgradeRadioItem3(){
    if(staffUpgradeRadioItem3==null){

      staffUpgradeRadioItem3 = new ACRadioButtonItem();

      staffUpgradeRadioItem3.setText("加算II");

      staffUpgradeRadioItem3.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem3.setConstraints(VRLayout.FLOW);

      addStaffUpgradeRadioItem3();
    }
    return staffUpgradeRadioItem3;

  }

  /**
   * 加算IIIを取得します。
   * @return 加算III
   */
  public ACRadioButtonItem getStaffUpgradeRadioItem4(){
    if(staffUpgradeRadioItem4==null){

      staffUpgradeRadioItem4 = new ACRadioButtonItem();

      staffUpgradeRadioItem4.setText("加算III");

      staffUpgradeRadioItem4.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem4.setConstraints(VRLayout.FLOW);

      addStaffUpgradeRadioItem4();
    }
    return staffUpgradeRadioItem4;

  }

  /**
   * 加算IVを取得します。
   * @return 加算IV
   */
  public ACRadioButtonItem getStaffUpgradeRadioItem5(){
    if(staffUpgradeRadioItem5==null){

      staffUpgradeRadioItem5 = new ACRadioButtonItem();

      staffUpgradeRadioItem5.setText("加算IV");

      staffUpgradeRadioItem5.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem5.setConstraints(VRLayout.FLOW);

      addStaffUpgradeRadioItem5();
    }
    return staffUpgradeRadioItem5;

  }

  /**
   * 基本夜間訪問 I 市町村独自加算を取得します。
   * @return 基本夜間訪問 I 市町村独自加算
   */
  public ACValueArrayRadioButtonGroup getBaseMunicipalityAdd(){
    if(baseMunicipalityAdd==null){

      baseMunicipalityAdd = new ACValueArrayRadioButtonGroup();

      getBaseMunicipalityAddContainer().setText("基本夜間訪問 I 市町村独自加算");

      baseMunicipalityAdd.setBindPath("1710105");

      baseMunicipalityAdd.setNoSelectIndex(0);

      baseMunicipalityAdd.setUseClearButton(false);

      baseMunicipalityAdd.setModel(getBaseMunicipalityAddModel());

      baseMunicipalityAdd.setValues(new int[]{1,2,3,4,5,6,7});

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
  protected ACListModelAdapter getBaseMunicipalityAddModel(){
    if(baseMunicipalityAddModel==null){
      baseMunicipalityAddModel = new ACListModelAdapter();
      addBaseMunicipalityAddModel();
    }
    return baseMunicipalityAddModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getBaseMunicipalityAddItem1(){
    if(baseMunicipalityAddItem1==null){

      baseMunicipalityAddItem1 = new ACRadioButtonItem();

      baseMunicipalityAddItem1.setText("なし");

      baseMunicipalityAddItem1.setGroup(getBaseMunicipalityAdd());

      baseMunicipalityAddItem1.setConstraints(VRLayout.FLOW);

      addBaseMunicipalityAddItem1();
    }
    return baseMunicipalityAddItem1;

  }

  /**
   * 加算1を取得します。
   * @return 加算1
   */
  public ACRadioButtonItem getBaseMunicipalityAddItem2(){
    if(baseMunicipalityAddItem2==null){

      baseMunicipalityAddItem2 = new ACRadioButtonItem();

      baseMunicipalityAddItem2.setText("加算1");

      baseMunicipalityAddItem2.setGroup(getBaseMunicipalityAdd());

      baseMunicipalityAddItem2.setConstraints(VRLayout.FLOW);

      addBaseMunicipalityAddItem2();
    }
    return baseMunicipalityAddItem2;

  }

  /**
   * 加算2を取得します。
   * @return 加算2
   */
  public ACRadioButtonItem getBaseMunicipalityAddItem3(){
    if(baseMunicipalityAddItem3==null){

      baseMunicipalityAddItem3 = new ACRadioButtonItem();

      baseMunicipalityAddItem3.setText("加算2");

      baseMunicipalityAddItem3.setGroup(getBaseMunicipalityAdd());

      baseMunicipalityAddItem3.setConstraints(VRLayout.FLOW);

      addBaseMunicipalityAddItem3();
    }
    return baseMunicipalityAddItem3;

  }

  /**
   * 加算3を取得します。
   * @return 加算3
   */
  public ACRadioButtonItem getBaseMunicipalityAddItem4(){
    if(baseMunicipalityAddItem4==null){

      baseMunicipalityAddItem4 = new ACRadioButtonItem();

      baseMunicipalityAddItem4.setText("加算3");

      baseMunicipalityAddItem4.setGroup(getBaseMunicipalityAdd());

      baseMunicipalityAddItem4.setConstraints(VRLayout.FLOW_RETURN);

      addBaseMunicipalityAddItem4();
    }
    return baseMunicipalityAddItem4;

  }

  /**
   * 加算4を取得します。
   * @return 加算4
   */
  public ACRadioButtonItem getBaseMunicipalityAddItem5(){
    if(baseMunicipalityAddItem5==null){

      baseMunicipalityAddItem5 = new ACRadioButtonItem();

      baseMunicipalityAddItem5.setText("加算4");

      baseMunicipalityAddItem5.setGroup(getBaseMunicipalityAdd());

      baseMunicipalityAddItem5.setConstraints(VRLayout.FLOW);

      addBaseMunicipalityAddItem5();
    }
    return baseMunicipalityAddItem5;

  }

  /**
   * 加算5を取得します。
   * @return 加算5
   */
  public ACRadioButtonItem getBaseMunicipalityAddItem6(){
    if(baseMunicipalityAddItem6==null){

      baseMunicipalityAddItem6 = new ACRadioButtonItem();

      baseMunicipalityAddItem6.setText("加算5");

      baseMunicipalityAddItem6.setGroup(getBaseMunicipalityAdd());

      baseMunicipalityAddItem6.setConstraints(VRLayout.FLOW);

      addBaseMunicipalityAddItem6();
    }
    return baseMunicipalityAddItem6;

  }

  /**
   * 加算6を取得します。
   * @return 加算6
   */
  public ACRadioButtonItem getBaseMunicipalityAddItem7(){
    if(baseMunicipalityAddItem7==null){

      baseMunicipalityAddItem7 = new ACRadioButtonItem();

      baseMunicipalityAddItem7.setText("加算6");

      baseMunicipalityAddItem7.setGroup(getBaseMunicipalityAdd());

      baseMunicipalityAddItem7.setConstraints(VRLayout.FLOW);

      addBaseMunicipalityAddItem7();
    }
    return baseMunicipalityAddItem7;

  }

  /**
   * 夜間訪問介護 II 市町村独自加算を取得します。
   * @return 夜間訪問介護 II 市町村独自加算
   */
  public ACValueArrayRadioButtonGroup getServiceMunicipalityAdd(){
    if(serviceMunicipalityAdd==null){

      serviceMunicipalityAdd = new ACValueArrayRadioButtonGroup();

      getServiceMunicipalityAddContainer().setText("夜間訪問介護 II 市町村独自加算");

      serviceMunicipalityAdd.setBindPath("1710106");

      serviceMunicipalityAdd.setNoSelectIndex(0);

      serviceMunicipalityAdd.setUseClearButton(false);

      serviceMunicipalityAdd.setModel(getServiceMunicipalityAddModel());

      serviceMunicipalityAdd.setValues(new int[]{1,2,3,4,5,6,7});

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
  protected ACListModelAdapter getServiceMunicipalityAddModel(){
    if(serviceMunicipalityAddModel==null){
      serviceMunicipalityAddModel = new ACListModelAdapter();
      addServiceMunicipalityAddModel();
    }
    return serviceMunicipalityAddModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getServiceMunicipalityAddItem1(){
    if(serviceMunicipalityAddItem1==null){

      serviceMunicipalityAddItem1 = new ACRadioButtonItem();

      serviceMunicipalityAddItem1.setText("なし");

      serviceMunicipalityAddItem1.setGroup(getServiceMunicipalityAdd());

      serviceMunicipalityAddItem1.setConstraints(VRLayout.FLOW);

      addServiceMunicipalityAddItem1();
    }
    return serviceMunicipalityAddItem1;

  }

  /**
   * 加算1を取得します。
   * @return 加算1
   */
  public ACRadioButtonItem getServiceMunicipalityAddItem2(){
    if(serviceMunicipalityAddItem2==null){

      serviceMunicipalityAddItem2 = new ACRadioButtonItem();

      serviceMunicipalityAddItem2.setText("加算1");

      serviceMunicipalityAddItem2.setGroup(getServiceMunicipalityAdd());

      serviceMunicipalityAddItem2.setConstraints(VRLayout.FLOW);

      addServiceMunicipalityAddItem2();
    }
    return serviceMunicipalityAddItem2;

  }

  /**
   * 加算2を取得します。
   * @return 加算2
   */
  public ACRadioButtonItem getServiceMunicipalityAddItem3(){
    if(serviceMunicipalityAddItem3==null){

      serviceMunicipalityAddItem3 = new ACRadioButtonItem();

      serviceMunicipalityAddItem3.setText("加算2");

      serviceMunicipalityAddItem3.setGroup(getServiceMunicipalityAdd());

      serviceMunicipalityAddItem3.setConstraints(VRLayout.FLOW);

      addServiceMunicipalityAddItem3();
    }
    return serviceMunicipalityAddItem3;

  }

  /**
   * 加算3を取得します。
   * @return 加算3
   */
  public ACRadioButtonItem getServiceMunicipalityAddItem4(){
    if(serviceMunicipalityAddItem4==null){

      serviceMunicipalityAddItem4 = new ACRadioButtonItem();

      serviceMunicipalityAddItem4.setText("加算3");

      serviceMunicipalityAddItem4.setGroup(getServiceMunicipalityAdd());

      serviceMunicipalityAddItem4.setConstraints(VRLayout.FLOW_RETURN);

      addServiceMunicipalityAddItem4();
    }
    return serviceMunicipalityAddItem4;

  }

  /**
   * 加算4を取得します。
   * @return 加算4
   */
  public ACRadioButtonItem getServiceMunicipalityAddItem5(){
    if(serviceMunicipalityAddItem5==null){

      serviceMunicipalityAddItem5 = new ACRadioButtonItem();

      serviceMunicipalityAddItem5.setText("加算4");

      serviceMunicipalityAddItem5.setGroup(getServiceMunicipalityAdd());

      serviceMunicipalityAddItem5.setConstraints(VRLayout.FLOW);

      addServiceMunicipalityAddItem5();
    }
    return serviceMunicipalityAddItem5;

  }

  /**
   * 加算5を取得します。
   * @return 加算5
   */
  public ACRadioButtonItem getServiceMunicipalityAddItem6(){
    if(serviceMunicipalityAddItem6==null){

      serviceMunicipalityAddItem6 = new ACRadioButtonItem();

      serviceMunicipalityAddItem6.setText("加算5");

      serviceMunicipalityAddItem6.setGroup(getServiceMunicipalityAdd());

      serviceMunicipalityAddItem6.setConstraints(VRLayout.FLOW);

      addServiceMunicipalityAddItem6();
    }
    return serviceMunicipalityAddItem6;

  }

  /**
   * 加算6を取得します。
   * @return 加算6
   */
  public ACRadioButtonItem getServiceMunicipalityAddItem7(){
    if(serviceMunicipalityAddItem7==null){

      serviceMunicipalityAddItem7 = new ACRadioButtonItem();

      serviceMunicipalityAddItem7.setText("加算6");

      serviceMunicipalityAddItem7.setGroup(getServiceMunicipalityAdd());

      serviceMunicipalityAddItem7.setConstraints(VRLayout.FLOW);

      addServiceMunicipalityAddItem7();
    }
    return serviceMunicipalityAddItem7;

  }

  /**
   * 割引率コンテナを取得します。
   * @return 割引率コンテナ
   */
  public ACLabelContainer getReduceRateContainer(){
    if(reduceRateContainer==null){

      reduceRateContainer = new ACLabelContainer();

      reduceRateContainer.setText("割引率");

      reduceRateContainer.setFollowChildEnabled(true);

      addReduceRateContainer();
    }
    return reduceRateContainer;

  }

  /**
   * 割引率を取得します。
   * @return 割引率
   */
  public ACTextField getReduceRate(){
    if(reduceRate==null){

      reduceRate = new ACTextField();

      reduceRate.setBindPath("REDUCT_RATE");

      reduceRate.setColumns(3);

      reduceRate.setCharType(VRCharType.ONLY_DIGIT);

      reduceRate.setHorizontalAlignment(SwingConstants.RIGHT);

      reduceRate.setIMEMode(InputSubset.LATIN);

      reduceRate.setMaxLength(3);

      addReduceRate();
    }
    return reduceRate;

  }

  /**
   * ％ラベルを取得します。
   * @return ％ラベル
   */
  public ACLabel getPercentSign(){
    if(percentSign==null){

      percentSign = new ACLabel();

      percentSign.setText("％");

      addPercentSign();
    }
    return percentSign;

  }

  /**
   * 社福減免対象事業者を取得します。
   * @return 社福減免対象事業者
   */
  public ACIntegerCheckBox getShahukuReduce(){
    if(ShahukuReduce==null){

      ShahukuReduce = new ACIntegerCheckBox();

      ShahukuReduce.setText("社会福祉法人等の軽減制度");

      ShahukuReduce.setBindPath("1");

      ShahukuReduce.setSelectValue(2);

      ShahukuReduce.setUnSelectValue(1);

      addShahukuReduce();
    }
    return ShahukuReduce;

  }

  /**
   * 旧法項目を取得します。
   * @return 旧法項目
   */
  public ACPanel getOldLowElementArea(){
    if(oldLowElementArea==null){

      oldLowElementArea = new ACPanel();

      addOldLowElementArea();
    }
    return oldLowElementArea;

  }

  /**
   * コンストラクタです。
   */
  public QO004_17111_201504Design() {

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

    mainGroup.add(getProviderMainPanel(), VRLayout.NORTH);

  }

  /**
   * 事業所メインパネルに内部項目を追加します。
   */
  protected void addProviderMainPanel(){

    providerMainPanel.add(getFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getHours24MessageAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getStaffUpgradeRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getBaseMunicipalityAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getServiceMunicipalityAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getReduceRateContainer(), VRLayout.FLOW_INSETLINE);

    providerMainPanel.add(getShahukuReduce(), VRLayout.FLOW_RETURN);

    providerMainPanel.add(getOldLowElementArea(), VRLayout.FLOW_RETURN);

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
   * Ⅰ型に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem1(){

  }

  /**
   * Ⅱ型に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem2(){

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
   * 対応不可に内部項目を追加します。
   */
  protected void addHours24MessageAddRadioItem1(){

  }

  /**
   * 対応可に内部項目を追加します。
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

    getServiceAddProvisionStructuralRadioItem2().setButtonIndex(4);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem2());

    getServiceAddProvisionStructuralRadioItem3().setButtonIndex(2);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem3());

    getServiceAddProvisionStructuralRadioItem4().setButtonIndex(5);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem4());

    getServiceAddProvisionStructuralRadioItem5().setButtonIndex(3);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem5());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * 加算Iイに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * 加算Iロに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem3(){

  }

  /**
   * 加算IIイに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem4(){

  }

  /**
   * 加算IIロに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem5(){

  }

  /**
   * 介護職員処遇改善加算に内部項目を追加します。
   */
  protected void addStaffUpgradeRadioGroup(){

  }

  /**
   * 介護職員処遇改善加算モデルに内部項目を追加します。
   */
  protected void addStaffUpgradeRadioGroupModel(){

    getStaffUpgradeRadioItem1().setButtonIndex(1);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem1());

    getStaffUpgradeRadioItem2().setButtonIndex(5);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem2());

    getStaffUpgradeRadioItem3().setButtonIndex(2);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem3());

    getStaffUpgradeRadioItem4().setButtonIndex(3);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem4());

    getStaffUpgradeRadioItem5().setButtonIndex(4);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem5());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addStaffUpgradeRadioItem1(){

  }

  /**
   * 加算Iに内部項目を追加します。
   */
  protected void addStaffUpgradeRadioItem2(){

  }

  /**
   * 加算IIに内部項目を追加します。
   */
  protected void addStaffUpgradeRadioItem3(){

  }

  /**
   * 加算IIIに内部項目を追加します。
   */
  protected void addStaffUpgradeRadioItem4(){

  }

  /**
   * 加算IVに内部項目を追加します。
   */
  protected void addStaffUpgradeRadioItem5(){

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

    getBaseMunicipalityAddItem1().setButtonIndex(1);

    getBaseMunicipalityAddModel().add(getBaseMunicipalityAddItem1());

    getBaseMunicipalityAddItem2().setButtonIndex(2);

    getBaseMunicipalityAddModel().add(getBaseMunicipalityAddItem2());

    getBaseMunicipalityAddItem3().setButtonIndex(3);

    getBaseMunicipalityAddModel().add(getBaseMunicipalityAddItem3());

    getBaseMunicipalityAddItem4().setButtonIndex(4);

    getBaseMunicipalityAddModel().add(getBaseMunicipalityAddItem4());

    getBaseMunicipalityAddItem5().setButtonIndex(5);

    getBaseMunicipalityAddModel().add(getBaseMunicipalityAddItem5());

    getBaseMunicipalityAddItem6().setButtonIndex(6);

    getBaseMunicipalityAddModel().add(getBaseMunicipalityAddItem6());

    getBaseMunicipalityAddItem7().setButtonIndex(7);

    getBaseMunicipalityAddModel().add(getBaseMunicipalityAddItem7());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addBaseMunicipalityAddItem1(){

  }

  /**
   * 加算1に内部項目を追加します。
   */
  protected void addBaseMunicipalityAddItem2(){

  }

  /**
   * 加算2に内部項目を追加します。
   */
  protected void addBaseMunicipalityAddItem3(){

  }

  /**
   * 加算3に内部項目を追加します。
   */
  protected void addBaseMunicipalityAddItem4(){

  }

  /**
   * 加算4に内部項目を追加します。
   */
  protected void addBaseMunicipalityAddItem5(){

  }

  /**
   * 加算5に内部項目を追加します。
   */
  protected void addBaseMunicipalityAddItem6(){

  }

  /**
   * 加算6に内部項目を追加します。
   */
  protected void addBaseMunicipalityAddItem7(){

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

    getServiceMunicipalityAddItem1().setButtonIndex(1);

    getServiceMunicipalityAddModel().add(getServiceMunicipalityAddItem1());

    getServiceMunicipalityAddItem2().setButtonIndex(2);

    getServiceMunicipalityAddModel().add(getServiceMunicipalityAddItem2());

    getServiceMunicipalityAddItem3().setButtonIndex(3);

    getServiceMunicipalityAddModel().add(getServiceMunicipalityAddItem3());

    getServiceMunicipalityAddItem4().setButtonIndex(4);

    getServiceMunicipalityAddModel().add(getServiceMunicipalityAddItem4());

    getServiceMunicipalityAddItem5().setButtonIndex(5);

    getServiceMunicipalityAddModel().add(getServiceMunicipalityAddItem5());

    getServiceMunicipalityAddItem6().setButtonIndex(6);

    getServiceMunicipalityAddModel().add(getServiceMunicipalityAddItem6());

    getServiceMunicipalityAddItem7().setButtonIndex(7);

    getServiceMunicipalityAddModel().add(getServiceMunicipalityAddItem7());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addServiceMunicipalityAddItem1(){

  }

  /**
   * 加算1に内部項目を追加します。
   */
  protected void addServiceMunicipalityAddItem2(){

  }

  /**
   * 加算2に内部項目を追加します。
   */
  protected void addServiceMunicipalityAddItem3(){

  }

  /**
   * 加算3に内部項目を追加します。
   */
  protected void addServiceMunicipalityAddItem4(){

  }

  /**
   * 加算4に内部項目を追加します。
   */
  protected void addServiceMunicipalityAddItem5(){

  }

  /**
   * 加算5に内部項目を追加します。
   */
  protected void addServiceMunicipalityAddItem6(){

  }

  /**
   * 加算6に内部項目を追加します。
   */
  protected void addServiceMunicipalityAddItem7(){

  }

  /**
   * 割引率コンテナに内部項目を追加します。
   */
  protected void addReduceRateContainer(){

    reduceRateContainer.add(getReduceRate(), VRLayout.FLOW);

    reduceRateContainer.add(getPercentSign(), VRLayout.FLOW);

  }

  /**
   * 割引率に内部項目を追加します。
   */
  protected void addReduceRate(){

  }

  /**
   * ％ラベルに内部項目を追加します。
   */
  protected void addPercentSign(){

  }

  /**
   * 社福減免対象事業者に内部項目を追加します。
   */
  protected void addShahukuReduce(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004_17111_201504Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004_17111_201504Design getThis() {
    return this;
  }
}
