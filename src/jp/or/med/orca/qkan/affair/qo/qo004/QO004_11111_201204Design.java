
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
 * 作成日: 2012/02/03  日本コンピューター株式会社 松本　幸一 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業者登録 (004)
 * プログラム 訪問介護 (QO004_11111_201204)
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
 * 訪問介護画面項目デザイン(QO004_11111_201204) 
 */
public class QO004_11111_201204Design extends QO004ProviderPanel {
  //GUIコンポーネント

  private ACGroupBox mainGroup;

  private ACValueArrayRadioButtonGroup dayTimeRadioGroup;

  private ACLabelContainer dayTimeRadioGroupContainer;

  private ACListModelAdapter dayTimeRadioGroupModel;

  private ACRadioButtonItem dayTimeRadioItem1;

  private ACRadioButtonItem dayTimeRadioItem2;

  private ACValueArrayRadioButtonGroup secondClassServiceRadioGroup;

  private ACLabelContainer secondClassServiceRadioGroupContainer;

  private ACListModelAdapter secondClassServiceRadioGroupModel;

  private ACRadioButtonItem secondClassServiceRadioItem1;

  private ACRadioButtonItem secondClassServiceRadioItem2;

  private ACValueArrayRadioButtonGroup sameBuildingRadioGroup;

  private ACLabelContainer sameBuildingRadioGroupContainer;

  private ACListModelAdapter sameBuildingRadioGroupModel;

  private ACRadioButtonItem sameBuildingRadioItem1;

  private ACRadioButtonItem sameBuildingRadioItem2;

  private ACValueArrayRadioButtonGroup specificProviderAdd;

  private ACLabelContainer specificProviderAddContainer;

  private ACListModelAdapter specificProviderAddModel;

  private ACRadioButtonItem specificProviderAddItem1;

  private ACRadioButtonItem specificProviderAddItem2;

  private ACRadioButtonItem specificProviderAddItem3;

  private ACRadioButtonItem specificProviderAddItem4;

  private ACValueArrayRadioButtonGroup staffUpgradeRadioGroup;

  private ACLabelContainer staffUpgradeRadioGroupContainer;

  private ACListModelAdapter staffUpgradeRadioGroupModel;

  private ACRadioButtonItem staffUpgradeRadioItem1;

  private ACRadioButtonItem staffUpgradeRadioItem2;

  private ACRadioButtonItem staffUpgradeRadioItem3;

  private ACRadioButtonItem staffUpgradeRadioItem4;

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

  private ACLabelContainer reduceRateContainer;

  private ACTextField reduceRate;

  private ACLabel percentSign;

  private ACIntegerCheckBox ShahukuReduce;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getMainGroup(){
    if(mainGroup==null){

      mainGroup = new ACGroupBox();

      mainGroup.setText("訪問介護");

      mainGroup.setFollowChildEnabled(true);

      addMainGroup();
    }
    return mainGroup;

  }

  /**
   * 日中の身体介護20分未満体制を取得します。
   * @return 日中の身体介護20分未満体制
   */
  public ACValueArrayRadioButtonGroup getDayTimeRadioGroup(){
    if(dayTimeRadioGroup==null){

      dayTimeRadioGroup = new ACValueArrayRadioButtonGroup();

      getDayTimeRadioGroupContainer().setText("日中の身体介護20分未満体制");

      dayTimeRadioGroup.setBindPath("1110104");

      dayTimeRadioGroup.setVisible(true);

      dayTimeRadioGroup.setEnabled(true);

      dayTimeRadioGroup.setNoSelectIndex(0);

      dayTimeRadioGroup.setUseClearButton(false);

      dayTimeRadioGroup.setModel(getDayTimeRadioGroupModel());

      dayTimeRadioGroup.setValues(new int[]{1,2});

      addDayTimeRadioGroup();
    }
    return dayTimeRadioGroup;

  }

  /**
   * 日中の身体介護20分未満体制コンテナを取得します。
   * @return 日中の身体介護20分未満体制コンテナ
   */
  protected ACLabelContainer getDayTimeRadioGroupContainer(){
    if(dayTimeRadioGroupContainer==null){
      dayTimeRadioGroupContainer = new ACLabelContainer();
      dayTimeRadioGroupContainer.setFollowChildEnabled(true);
      dayTimeRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      dayTimeRadioGroupContainer.add(getDayTimeRadioGroup(), null);
    }
    return dayTimeRadioGroupContainer;
  }

  /**
   * 日中の身体介護20分未満体制モデルを取得します。
   * @return 日中の身体介護20分未満体制モデル
   */
  protected ACListModelAdapter getDayTimeRadioGroupModel(){
    if(dayTimeRadioGroupModel==null){
      dayTimeRadioGroupModel = new ACListModelAdapter();
      addDayTimeRadioGroupModel();
    }
    return dayTimeRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getDayTimeRadioItem1(){
    if(dayTimeRadioItem1==null){

      dayTimeRadioItem1 = new ACRadioButtonItem();

      dayTimeRadioItem1.setText("なし");

      dayTimeRadioItem1.setGroup(getDayTimeRadioGroup());

      dayTimeRadioItem1.setConstraints(VRLayout.FLOW);

      addDayTimeRadioItem1();
    }
    return dayTimeRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getDayTimeRadioItem2(){
    if(dayTimeRadioItem2==null){

      dayTimeRadioItem2 = new ACRadioButtonItem();

      dayTimeRadioItem2.setText("あり");

      dayTimeRadioItem2.setGroup(getDayTimeRadioGroup());

      dayTimeRadioItem2.setConstraints(VRLayout.FLOW);

      addDayTimeRadioItem2();
    }
    return dayTimeRadioItem2;

  }

  /**
   * サービス提供責任者体制を取得します。
   * @return サービス提供責任者体制
   */
  public ACValueArrayRadioButtonGroup getSecondClassServiceRadioGroup(){
    if(secondClassServiceRadioGroup==null){

      secondClassServiceRadioGroup = new ACValueArrayRadioButtonGroup();

      getSecondClassServiceRadioGroupContainer().setText("サービス提供責任者体制");

      secondClassServiceRadioGroup.setBindPath("1110103");

      secondClassServiceRadioGroup.setVisible(true);

      secondClassServiceRadioGroup.setEnabled(true);

      secondClassServiceRadioGroup.setNoSelectIndex(0);

      secondClassServiceRadioGroup.setUseClearButton(false);

      secondClassServiceRadioGroup.setModel(getSecondClassServiceRadioGroupModel());

      secondClassServiceRadioGroup.setValues(new int[]{1,2});

      addSecondClassServiceRadioGroup();
    }
    return secondClassServiceRadioGroup;

  }

  /**
   * サービス提供責任者体制コンテナを取得します。
   * @return サービス提供責任者体制コンテナ
   */
  protected ACLabelContainer getSecondClassServiceRadioGroupContainer(){
    if(secondClassServiceRadioGroupContainer==null){
      secondClassServiceRadioGroupContainer = new ACLabelContainer();
      secondClassServiceRadioGroupContainer.setFollowChildEnabled(true);
      secondClassServiceRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      secondClassServiceRadioGroupContainer.add(getSecondClassServiceRadioGroup(), null);
    }
    return secondClassServiceRadioGroupContainer;
  }

  /**
   * サービス提供責任者体制モデルを取得します。
   * @return サービス提供責任者体制モデル
   */
  protected ACListModelAdapter getSecondClassServiceRadioGroupModel(){
    if(secondClassServiceRadioGroupModel==null){
      secondClassServiceRadioGroupModel = new ACListModelAdapter();
      addSecondClassServiceRadioGroupModel();
    }
    return secondClassServiceRadioGroupModel;
  }

  /**
   * 減算なしを取得します。
   * @return 減算なし
   */
  public ACRadioButtonItem getSecondClassServiceRadioItem1(){
    if(secondClassServiceRadioItem1==null){

      secondClassServiceRadioItem1 = new ACRadioButtonItem();

      secondClassServiceRadioItem1.setText("減算なし");

      secondClassServiceRadioItem1.setGroup(getSecondClassServiceRadioGroup());

      secondClassServiceRadioItem1.setConstraints(VRLayout.FLOW);

      addSecondClassServiceRadioItem1();
    }
    return secondClassServiceRadioItem1;

  }

  /**
   * 減算ありを取得します。
   * @return 減算あり
   */
  public ACRadioButtonItem getSecondClassServiceRadioItem2(){
    if(secondClassServiceRadioItem2==null){

      secondClassServiceRadioItem2 = new ACRadioButtonItem();

      secondClassServiceRadioItem2.setText("減算あり");

      secondClassServiceRadioItem2.setGroup(getSecondClassServiceRadioGroup());

      secondClassServiceRadioItem2.setConstraints(VRLayout.FLOW);

      addSecondClassServiceRadioItem2();
    }
    return secondClassServiceRadioItem2;

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
   * 特定事業所加算を取得します。
   * @return 特定事業所加算
   */
  public ACValueArrayRadioButtonGroup getSpecificProviderAdd(){
    if(specificProviderAdd==null){

      specificProviderAdd = new ACValueArrayRadioButtonGroup();

      getSpecificProviderAddContainer().setText("特定事業所加算");

      specificProviderAdd.setBindPath("1110101");

      specificProviderAdd.setEnabled(true);

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
   * 介護職員処遇改善加算を取得します。
   * @return 介護職員処遇改善加算
   */
  public ACValueArrayRadioButtonGroup getStaffUpgradeRadioGroup(){
    if(staffUpgradeRadioGroup==null){

      staffUpgradeRadioGroup = new ACValueArrayRadioButtonGroup();

      getStaffUpgradeRadioGroupContainer().setText("介護職員処遇改善加算");

      staffUpgradeRadioGroup.setBindPath("4");

      staffUpgradeRadioGroup.setVisible(true);

      staffUpgradeRadioGroup.setEnabled(true);

      staffUpgradeRadioGroup.setUseClearButton(false);

      staffUpgradeRadioGroup.setModel(getStaffUpgradeRadioGroupModel());

      staffUpgradeRadioGroup.setValues(new int[]{1,2,3,4});

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
   * コンストラクタです。
   */
  public QO004_11111_201204Design() {

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

    mainGroup.add(getDayTimeRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getSecondClassServiceRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getSameBuildingRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getSpecificProviderAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getStaffUpgradeRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getProviderAddMountainousAreaRafioRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getProviderAddMountainousAreaScaleRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getReduceRateContainer(), VRLayout.FLOW_INSETLINE);

    mainGroup.add(getShahukuReduce(), VRLayout.FLOW_RETURN);

  }

  /**
   * 日中の身体介護20分未満体制に内部項目を追加します。
   */
  protected void addDayTimeRadioGroup(){

  }

  /**
   * 日中の身体介護20分未満体制モデルに内部項目を追加します。
   */
  protected void addDayTimeRadioGroupModel(){

    getDayTimeRadioItem1().setButtonIndex(1);

    getDayTimeRadioGroupModel().add(getDayTimeRadioItem1());

    getDayTimeRadioItem2().setButtonIndex(2);

    getDayTimeRadioGroupModel().add(getDayTimeRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addDayTimeRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addDayTimeRadioItem2(){

  }

  /**
   * サービス提供責任者体制に内部項目を追加します。
   */
  protected void addSecondClassServiceRadioGroup(){

  }

  /**
   * サービス提供責任者体制モデルに内部項目を追加します。
   */
  protected void addSecondClassServiceRadioGroupModel(){

    getSecondClassServiceRadioItem1().setButtonIndex(1);

    getSecondClassServiceRadioGroupModel().add(getSecondClassServiceRadioItem1());

    getSecondClassServiceRadioItem2().setButtonIndex(2);

    getSecondClassServiceRadioGroupModel().add(getSecondClassServiceRadioItem2());

  }

  /**
   * 減算なしに内部項目を追加します。
   */
  protected void addSecondClassServiceRadioItem1(){

  }

  /**
   * 減算ありに内部項目を追加します。
   */
  protected void addSecondClassServiceRadioItem2(){

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

    getStaffUpgradeRadioItem2().setButtonIndex(2);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem2());

    getStaffUpgradeRadioItem3().setButtonIndex(3);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem3());

    getStaffUpgradeRadioItem4().setButtonIndex(4);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem4());

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
      ACFrame.debugStart(new ACAffairInfo(QO004_11111_201204Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004_11111_201204Design getThis() {
    return this;
  }
}
