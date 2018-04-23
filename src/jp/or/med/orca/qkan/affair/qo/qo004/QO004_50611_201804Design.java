
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
 * 作成日: 2018/02/01  日本コンピューター株式会社 日高　しのぶ 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業者登録 (004)
 * プログラム 通所型サービス（独自） (QO004_50611_201804)
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
 * 通所型サービス（独自）画面項目デザイン(QO004_50611_201804) 
 */
public class QO004_50611_201804Design extends QO004ProviderPanel {
  //GUIコンポーネント

  private ACGroupBox mainGroup;

  private ACValueArrayRadioButtonGroup staffLack;

  private ACLabelContainer staffLackContainer;

  private ACListModelAdapter staffLackModel;

  private ACRadioButtonItem staffLackItem1;

  private ACRadioButtonItem staffLackItem2;

  private ACRadioButtonItem staffLackItem3;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACValueArrayRadioButtonGroup smallGroupsLifeRadioGroup;

  private ACLabelContainer smallGroupsLifeRadioGroupContainer;

  private ACListModelAdapter smallGroupsLifeRadioGroupModel;

  private ACRadioButtonItem smallGroupsLifeRadioItem1;

  private ACRadioButtonItem smallGroupsLifeRadioItem2;

  private ACValueArrayRadioButtonGroup functionImprovement;

  private ACLabelContainer functionImprovementContainer;

  private ACListModelAdapter functionImprovementModel;

  private ACRadioButtonItem functionImprovementItem1;

  private ACRadioButtonItem functionImprovementItem2;

  private ACValueArrayRadioButtonGroup nourishmentImprovement;

  private ACLabelContainer nourishmentImprovementContainer;

  private ACListModelAdapter nourishmentImprovementModel;

  private ACRadioButtonItem nourishmentImprovementItem1;

  private ACRadioButtonItem nourishmentImprovementItem2;

  private ACValueArrayRadioButtonGroup mouthImprovementAdd;

  private ACLabelContainer mouthImprovementAddContainer;

  private ACListModelAdapter mouthImprovementAddModel;

  private ACRadioButtonItem mouthImprovementAddItem1;

  private ACRadioButtonItem mouthImprovementAddItem2;

  private ACValueArrayRadioButtonGroup selectiveServiceRadioGroup;

  private ACLabelContainer selectiveServiceRadioGroupContainer;

  private ACListModelAdapter selectiveServiceRadioGroupModel;

  private ACRadioButtonItem selectiveServiceRadioItem1;

  private ACRadioButtonItem selectiveServiceRadioItem2;

  private ACValueArrayRadioButtonGroup providerEvaluation;

  private ACLabelContainer providerEvaluationContainer;

  private ACListModelAdapter providerEvaluationModel;

  private ACRadioButtonItem providerEvaluationItem1;

  private ACRadioButtonItem providerEvaluationItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACValueArrayRadioButtonGroup staffUpgradeRadioGroup;

  private ACLabelContainer staffUpgradeRadioGroupContainer;

  private ACListModelAdapter staffUpgradeRadioGroupModel;

  private ACRadioButtonItem staffUpgradeRadioItem1;

  private ACRadioButtonItem staffUpgradeRadioItem2;

  private ACRadioButtonItem staffUpgradeRadioItem3;

  private ACRadioButtonItem staffUpgradeRadioItem4;

  private ACRadioButtonItem staffUpgradeRadioItem5;

  private ACRadioButtonItem staffUpgradeRadioItem6;

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

      mainGroup.setText("通所型サービス（独自）");

      mainGroup.setFollowChildEnabled(true);

      mainGroup.setHgrid(200);

      addMainGroup();
    }
    return mainGroup;

  }

  /**
   * 職員の欠員による減算の状況ラジオグループを取得します。
   * @return 職員の欠員による減算の状況ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getStaffLack(){
    if(staffLack==null){

      staffLack = new ACValueArrayRadioButtonGroup();

      getStaffLackContainer().setText("職員の欠員による減算の状況");

      staffLack.setBindPath("5060101");

      staffLack.setUseClearButton(false);

      staffLack.setModel(getStaffLackModel());

      staffLack.setValues(new int[]{1,2,3});

      addStaffLack();
    }
    return staffLack;

  }

  /**
   * 職員の欠員による減算の状況ラジオグループコンテナを取得します。
   * @return 職員の欠員による減算の状況ラジオグループコンテナ
   */
  protected ACLabelContainer getStaffLackContainer(){
    if(staffLackContainer==null){
      staffLackContainer = new ACLabelContainer();
      staffLackContainer.setFollowChildEnabled(true);
      staffLackContainer.setVAlignment(VRLayout.CENTER);
      staffLackContainer.add(getStaffLack(), null);
    }
    return staffLackContainer;
  }

  /**
   * 職員の欠員による減算の状況ラジオグループモデルを取得します。
   * @return 職員の欠員による減算の状況ラジオグループモデル
   */
  protected ACListModelAdapter getStaffLackModel(){
    if(staffLackModel==null){
      staffLackModel = new ACListModelAdapter();
      addStaffLackModel();
    }
    return staffLackModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getStaffLackItem1(){
    if(staffLackItem1==null){

      staffLackItem1 = new ACRadioButtonItem();

      staffLackItem1.setText("なし");

      staffLackItem1.setGroup(getStaffLack());

      staffLackItem1.setConstraints(VRLayout.FLOW);

      addStaffLackItem1();
    }
    return staffLackItem1;

  }

  /**
   * 看護職員を取得します。
   * @return 看護職員
   */
  public ACRadioButtonItem getStaffLackItem2(){
    if(staffLackItem2==null){

      staffLackItem2 = new ACRadioButtonItem();

      staffLackItem2.setText("看護職員");

      staffLackItem2.setGroup(getStaffLack());

      staffLackItem2.setConstraints(VRLayout.FLOW);

      addStaffLackItem2();
    }
    return staffLackItem2;

  }

  /**
   * 介護職員を取得します。
   * @return 介護職員
   */
  public ACRadioButtonItem getStaffLackItem3(){
    if(staffLackItem3==null){

      staffLackItem3 = new ACRadioButtonItem();

      staffLackItem3.setText("介護職員");

      staffLackItem3.setGroup(getStaffLack());

      staffLackItem3.setConstraints(VRLayout.FLOW);

      addStaffLackItem3();
    }
    return staffLackItem3;

  }

  /**
   * 若年性認知症利用者受入加算を取得します。
   * @return 若年性認知症利用者受入加算
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("若年性認知症利用者受入加算");

      youngDementiaPatinetAddRadioGroup.setBindPath("5060106");

      youngDementiaPatinetAddRadioGroup.setNoSelectIndex(0);

      youngDementiaPatinetAddRadioGroup.setUseClearButton(false);

      youngDementiaPatinetAddRadioGroup.setModel(getYoungDementiaPatinetAddRadioGroupModel());

      youngDementiaPatinetAddRadioGroup.setValues(new int[]{1,2});

      addYoungDementiaPatinetAddRadioGroup();
    }
    return youngDementiaPatinetAddRadioGroup;

  }

  /**
   * 若年性認知症利用者受入加算コンテナを取得します。
   * @return 若年性認知症利用者受入加算コンテナ
   */
  protected ACLabelContainer getYoungDementiaPatinetAddRadioGroupContainer(){
    if(youngDementiaPatinetAddRadioGroupContainer==null){
      youngDementiaPatinetAddRadioGroupContainer = new ACLabelContainer();
      youngDementiaPatinetAddRadioGroupContainer.setFollowChildEnabled(true);
      youngDementiaPatinetAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      youngDementiaPatinetAddRadioGroupContainer.add(getYoungDementiaPatinetAddRadioGroup(), null);
    }
    return youngDementiaPatinetAddRadioGroupContainer;
  }

  /**
   * 若年性認知症利用者受入加算モデルを取得します。
   * @return 若年性認知症利用者受入加算モデル
   */
  protected ACListModelAdapter getYoungDementiaPatinetAddRadioGroupModel(){
    if(youngDementiaPatinetAddRadioGroupModel==null){
      youngDementiaPatinetAddRadioGroupModel = new ACListModelAdapter();
      addYoungDementiaPatinetAddRadioGroupModel();
    }
    return youngDementiaPatinetAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getYoungDementiaPatinetAddRadioItem1(){
    if(youngDementiaPatinetAddRadioItem1==null){

      youngDementiaPatinetAddRadioItem1 = new ACRadioButtonItem();

      youngDementiaPatinetAddRadioItem1.setText("なし");

      youngDementiaPatinetAddRadioItem1.setGroup(getYoungDementiaPatinetAddRadioGroup());

      youngDementiaPatinetAddRadioItem1.setConstraints(VRLayout.FLOW);

      addYoungDementiaPatinetAddRadioItem1();
    }
    return youngDementiaPatinetAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getYoungDementiaPatinetAddRadioItem2(){
    if(youngDementiaPatinetAddRadioItem2==null){

      youngDementiaPatinetAddRadioItem2 = new ACRadioButtonItem();

      youngDementiaPatinetAddRadioItem2.setText("あり");

      youngDementiaPatinetAddRadioItem2.setGroup(getYoungDementiaPatinetAddRadioGroup());

      youngDementiaPatinetAddRadioItem2.setConstraints(VRLayout.FLOW);

      addYoungDementiaPatinetAddRadioItem2();
    }
    return youngDementiaPatinetAddRadioItem2;

  }

  /**
   * 生活機能向上グループ活動加算を取得します。
   * @return 生活機能向上グループ活動加算
   */
  public ACValueArrayRadioButtonGroup getSmallGroupsLifeRadioGroup(){
    if(smallGroupsLifeRadioGroup==null){

      smallGroupsLifeRadioGroup = new ACValueArrayRadioButtonGroup();

      getSmallGroupsLifeRadioGroupContainer().setText("生活機能向上グループ活動加算");

      smallGroupsLifeRadioGroup.setBindPath("5060108");

      smallGroupsLifeRadioGroup.setUseClearButton(false);

      smallGroupsLifeRadioGroup.setModel(getSmallGroupsLifeRadioGroupModel());

      smallGroupsLifeRadioGroup.setValues(new int[]{1,2});

      addSmallGroupsLifeRadioGroup();
    }
    return smallGroupsLifeRadioGroup;

  }

  /**
   * 生活機能向上グループ活動加算コンテナを取得します。
   * @return 生活機能向上グループ活動加算コンテナ
   */
  protected ACLabelContainer getSmallGroupsLifeRadioGroupContainer(){
    if(smallGroupsLifeRadioGroupContainer==null){
      smallGroupsLifeRadioGroupContainer = new ACLabelContainer();
      smallGroupsLifeRadioGroupContainer.setFollowChildEnabled(true);
      smallGroupsLifeRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      smallGroupsLifeRadioGroupContainer.add(getSmallGroupsLifeRadioGroup(), null);
    }
    return smallGroupsLifeRadioGroupContainer;
  }

  /**
   * 生活機能向上グループ活動加算モデルを取得します。
   * @return 生活機能向上グループ活動加算モデル
   */
  protected ACListModelAdapter getSmallGroupsLifeRadioGroupModel(){
    if(smallGroupsLifeRadioGroupModel==null){
      smallGroupsLifeRadioGroupModel = new ACListModelAdapter();
      addSmallGroupsLifeRadioGroupModel();
    }
    return smallGroupsLifeRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSmallGroupsLifeRadioItem1(){
    if(smallGroupsLifeRadioItem1==null){

      smallGroupsLifeRadioItem1 = new ACRadioButtonItem();

      smallGroupsLifeRadioItem1.setText("なし");

      smallGroupsLifeRadioItem1.setGroup(getSmallGroupsLifeRadioGroup());

      smallGroupsLifeRadioItem1.setConstraints(VRLayout.FLOW);

      addSmallGroupsLifeRadioItem1();
    }
    return smallGroupsLifeRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getSmallGroupsLifeRadioItem2(){
    if(smallGroupsLifeRadioItem2==null){

      smallGroupsLifeRadioItem2 = new ACRadioButtonItem();

      smallGroupsLifeRadioItem2.setText("あり");

      smallGroupsLifeRadioItem2.setGroup(getSmallGroupsLifeRadioGroup());

      smallGroupsLifeRadioItem2.setConstraints(VRLayout.FLOW);

      addSmallGroupsLifeRadioItem2();
    }
    return smallGroupsLifeRadioItem2;

  }

  /**
   * 運動器機能向上体制ラジオグループを取得します。
   * @return 運動器機能向上体制ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getFunctionImprovement(){
    if(functionImprovement==null){

      functionImprovement = new ACValueArrayRadioButtonGroup();

      getFunctionImprovementContainer().setText("運動器機能向上体制");

      functionImprovement.setBindPath("5060102");

      functionImprovement.setUseClearButton(false);

      functionImprovement.setModel(getFunctionImprovementModel());

      functionImprovement.setValues(new int[]{1,2});

      addFunctionImprovement();
    }
    return functionImprovement;

  }

  /**
   * 運動器機能向上体制ラジオグループコンテナを取得します。
   * @return 運動器機能向上体制ラジオグループコンテナ
   */
  protected ACLabelContainer getFunctionImprovementContainer(){
    if(functionImprovementContainer==null){
      functionImprovementContainer = new ACLabelContainer();
      functionImprovementContainer.setFollowChildEnabled(true);
      functionImprovementContainer.setVAlignment(VRLayout.CENTER);
      functionImprovementContainer.add(getFunctionImprovement(), null);
    }
    return functionImprovementContainer;
  }

  /**
   * 運動器機能向上体制ラジオグループモデルを取得します。
   * @return 運動器機能向上体制ラジオグループモデル
   */
  protected ACListModelAdapter getFunctionImprovementModel(){
    if(functionImprovementModel==null){
      functionImprovementModel = new ACListModelAdapter();
      addFunctionImprovementModel();
    }
    return functionImprovementModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getFunctionImprovementItem1(){
    if(functionImprovementItem1==null){

      functionImprovementItem1 = new ACRadioButtonItem();

      functionImprovementItem1.setText("なし");

      functionImprovementItem1.setGroup(getFunctionImprovement());

      functionImprovementItem1.setConstraints(VRLayout.FLOW);

      addFunctionImprovementItem1();
    }
    return functionImprovementItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getFunctionImprovementItem2(){
    if(functionImprovementItem2==null){

      functionImprovementItem2 = new ACRadioButtonItem();

      functionImprovementItem2.setText("あり");

      functionImprovementItem2.setGroup(getFunctionImprovement());

      functionImprovementItem2.setConstraints(VRLayout.FLOW);

      addFunctionImprovementItem2();
    }
    return functionImprovementItem2;

  }

  /**
   * 栄養改善体制ラジオグループを取得します。
   * @return 栄養改善体制ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getNourishmentImprovement(){
    if(nourishmentImprovement==null){

      nourishmentImprovement = new ACValueArrayRadioButtonGroup();

      getNourishmentImprovementContainer().setText("栄養改善体制");

      nourishmentImprovement.setBindPath("5060103");

      nourishmentImprovement.setUseClearButton(false);

      nourishmentImprovement.setModel(getNourishmentImprovementModel());

      nourishmentImprovement.setValues(new int[]{1,2});

      addNourishmentImprovement();
    }
    return nourishmentImprovement;

  }

  /**
   * 栄養改善体制ラジオグループコンテナを取得します。
   * @return 栄養改善体制ラジオグループコンテナ
   */
  protected ACLabelContainer getNourishmentImprovementContainer(){
    if(nourishmentImprovementContainer==null){
      nourishmentImprovementContainer = new ACLabelContainer();
      nourishmentImprovementContainer.setFollowChildEnabled(true);
      nourishmentImprovementContainer.setVAlignment(VRLayout.CENTER);
      nourishmentImprovementContainer.add(getNourishmentImprovement(), null);
    }
    return nourishmentImprovementContainer;
  }

  /**
   * 栄養改善体制ラジオグループモデルを取得します。
   * @return 栄養改善体制ラジオグループモデル
   */
  protected ACListModelAdapter getNourishmentImprovementModel(){
    if(nourishmentImprovementModel==null){
      nourishmentImprovementModel = new ACListModelAdapter();
      addNourishmentImprovementModel();
    }
    return nourishmentImprovementModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNourishmentImprovementItem1(){
    if(nourishmentImprovementItem1==null){

      nourishmentImprovementItem1 = new ACRadioButtonItem();

      nourishmentImprovementItem1.setText("なし");

      nourishmentImprovementItem1.setGroup(getNourishmentImprovement());

      nourishmentImprovementItem1.setConstraints(VRLayout.FLOW);

      addNourishmentImprovementItem1();
    }
    return nourishmentImprovementItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getNourishmentImprovementItem2(){
    if(nourishmentImprovementItem2==null){

      nourishmentImprovementItem2 = new ACRadioButtonItem();

      nourishmentImprovementItem2.setText("あり");

      nourishmentImprovementItem2.setGroup(getNourishmentImprovement());

      nourishmentImprovementItem2.setConstraints(VRLayout.FLOW);

      addNourishmentImprovementItem2();
    }
    return nourishmentImprovementItem2;

  }

  /**
   * 口腔機能向上体制ラジオグループを取得します。
   * @return 口腔機能向上体制ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getMouthImprovementAdd(){
    if(mouthImprovementAdd==null){

      mouthImprovementAdd = new ACValueArrayRadioButtonGroup();

      getMouthImprovementAddContainer().setText("口腔機能向上体制");

      mouthImprovementAdd.setBindPath("5060104");

      mouthImprovementAdd.setUseClearButton(false);

      mouthImprovementAdd.setModel(getMouthImprovementAddModel());

      mouthImprovementAdd.setValues(new int[]{1,2});

      addMouthImprovementAdd();
    }
    return mouthImprovementAdd;

  }

  /**
   * 口腔機能向上体制ラジオグループコンテナを取得します。
   * @return 口腔機能向上体制ラジオグループコンテナ
   */
  protected ACLabelContainer getMouthImprovementAddContainer(){
    if(mouthImprovementAddContainer==null){
      mouthImprovementAddContainer = new ACLabelContainer();
      mouthImprovementAddContainer.setFollowChildEnabled(true);
      mouthImprovementAddContainer.setVAlignment(VRLayout.CENTER);
      mouthImprovementAddContainer.add(getMouthImprovementAdd(), null);
    }
    return mouthImprovementAddContainer;
  }

  /**
   * 口腔機能向上体制ラジオグループモデルを取得します。
   * @return 口腔機能向上体制ラジオグループモデル
   */
  protected ACListModelAdapter getMouthImprovementAddModel(){
    if(mouthImprovementAddModel==null){
      mouthImprovementAddModel = new ACListModelAdapter();
      addMouthImprovementAddModel();
    }
    return mouthImprovementAddModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMouthImprovementAddItem1(){
    if(mouthImprovementAddItem1==null){

      mouthImprovementAddItem1 = new ACRadioButtonItem();

      mouthImprovementAddItem1.setText("なし");

      mouthImprovementAddItem1.setGroup(getMouthImprovementAdd());

      mouthImprovementAddItem1.setConstraints(VRLayout.FLOW);

      addMouthImprovementAddItem1();
    }
    return mouthImprovementAddItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMouthImprovementAddItem2(){
    if(mouthImprovementAddItem2==null){

      mouthImprovementAddItem2 = new ACRadioButtonItem();

      mouthImprovementAddItem2.setText("あり");

      mouthImprovementAddItem2.setGroup(getMouthImprovementAdd());

      mouthImprovementAddItem2.setConstraints(VRLayout.FLOW);

      addMouthImprovementAddItem2();
    }
    return mouthImprovementAddItem2;

  }

  /**
   * 選択的サービス複数実施加算を取得します。
   * @return 選択的サービス複数実施加算
   */
  public ACValueArrayRadioButtonGroup getSelectiveServiceRadioGroup(){
    if(selectiveServiceRadioGroup==null){

      selectiveServiceRadioGroup = new ACValueArrayRadioButtonGroup();

      getSelectiveServiceRadioGroupContainer().setText("選択的サービス複数実施加算");

      selectiveServiceRadioGroup.setBindPath("5060109");

      selectiveServiceRadioGroup.setNoSelectIndex(0);

      selectiveServiceRadioGroup.setUseClearButton(false);

      selectiveServiceRadioGroup.setModel(getSelectiveServiceRadioGroupModel());

      selectiveServiceRadioGroup.setValues(new int[]{1,2});

      addSelectiveServiceRadioGroup();
    }
    return selectiveServiceRadioGroup;

  }

  /**
   * 選択的サービス複数実施加算コンテナを取得します。
   * @return 選択的サービス複数実施加算コンテナ
   */
  protected ACLabelContainer getSelectiveServiceRadioGroupContainer(){
    if(selectiveServiceRadioGroupContainer==null){
      selectiveServiceRadioGroupContainer = new ACLabelContainer();
      selectiveServiceRadioGroupContainer.setFollowChildEnabled(true);
      selectiveServiceRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      selectiveServiceRadioGroupContainer.add(getSelectiveServiceRadioGroup(), null);
    }
    return selectiveServiceRadioGroupContainer;
  }

  /**
   * 選択的サービス複数実施加算モデルを取得します。
   * @return 選択的サービス複数実施加算モデル
   */
  protected ACListModelAdapter getSelectiveServiceRadioGroupModel(){
    if(selectiveServiceRadioGroupModel==null){
      selectiveServiceRadioGroupModel = new ACListModelAdapter();
      addSelectiveServiceRadioGroupModel();
    }
    return selectiveServiceRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSelectiveServiceRadioItem1(){
    if(selectiveServiceRadioItem1==null){

      selectiveServiceRadioItem1 = new ACRadioButtonItem();

      selectiveServiceRadioItem1.setText("なし");

      selectiveServiceRadioItem1.setGroup(getSelectiveServiceRadioGroup());

      selectiveServiceRadioItem1.setConstraints(VRLayout.FLOW);

      addSelectiveServiceRadioItem1();
    }
    return selectiveServiceRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getSelectiveServiceRadioItem2(){
    if(selectiveServiceRadioItem2==null){

      selectiveServiceRadioItem2 = new ACRadioButtonItem();

      selectiveServiceRadioItem2.setText("あり");

      selectiveServiceRadioItem2.setGroup(getSelectiveServiceRadioGroup());

      selectiveServiceRadioItem2.setConstraints(VRLayout.FLOW);

      addSelectiveServiceRadioItem2();
    }
    return selectiveServiceRadioItem2;

  }

  /**
   * 事業所評価加算（申出）の有無ラジオグループを取得します。
   * @return 事業所評価加算（申出）の有無ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getProviderEvaluation(){
    if(providerEvaluation==null){

      providerEvaluation = new ACValueArrayRadioButtonGroup();

      getProviderEvaluationContainer().setText("事業所評価加算（申出）の有無");

      providerEvaluation.setBindPath("5060105");

      providerEvaluation.setUseClearButton(false);

      providerEvaluation.setModel(getProviderEvaluationModel());

      providerEvaluation.setValues(new int[]{1,2});

      addProviderEvaluation();
    }
    return providerEvaluation;

  }

  /**
   * 事業所評価加算（申出）の有無ラジオグループコンテナを取得します。
   * @return 事業所評価加算（申出）の有無ラジオグループコンテナ
   */
  protected ACLabelContainer getProviderEvaluationContainer(){
    if(providerEvaluationContainer==null){
      providerEvaluationContainer = new ACLabelContainer();
      providerEvaluationContainer.setFollowChildEnabled(true);
      providerEvaluationContainer.setVAlignment(VRLayout.CENTER);
      providerEvaluationContainer.add(getProviderEvaluation(), null);
    }
    return providerEvaluationContainer;
  }

  /**
   * 事業所評価加算（申出）の有無ラジオグループモデルを取得します。
   * @return 事業所評価加算（申出）の有無ラジオグループモデル
   */
  protected ACListModelAdapter getProviderEvaluationModel(){
    if(providerEvaluationModel==null){
      providerEvaluationModel = new ACListModelAdapter();
      addProviderEvaluationModel();
    }
    return providerEvaluationModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getProviderEvaluationItem1(){
    if(providerEvaluationItem1==null){

      providerEvaluationItem1 = new ACRadioButtonItem();

      providerEvaluationItem1.setText("なし");

      providerEvaluationItem1.setGroup(getProviderEvaluation());

      providerEvaluationItem1.setConstraints(VRLayout.FLOW);

      addProviderEvaluationItem1();
    }
    return providerEvaluationItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getProviderEvaluationItem2(){
    if(providerEvaluationItem2==null){

      providerEvaluationItem2 = new ACRadioButtonItem();

      providerEvaluationItem2.setText("あり");

      providerEvaluationItem2.setGroup(getProviderEvaluation());

      providerEvaluationItem2.setConstraints(VRLayout.FLOW);

      addProviderEvaluationItem2();
    }
    return providerEvaluationItem2;

  }

  /**
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("5060107");

      serviceAddProvisionStructuralRadioGroup.setVisible(true);

      serviceAddProvisionStructuralRadioGroup.setEnabled(true);

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,4,2,3});

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
   * 加算IIを取得します。
   * @return 加算II
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem4(){
    if(serviceAddProvisionStructuralRadioItem4==null){

      serviceAddProvisionStructuralRadioItem4 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem4.setText("加算II");

      serviceAddProvisionStructuralRadioItem4.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem4.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem4();
    }
    return serviceAddProvisionStructuralRadioItem4;

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

      staffUpgradeRadioGroup.setValues(new int[]{1,6,5,2,3,4});

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

      staffUpgradeRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

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
   * 加算Vを取得します。
   * @return 加算V
   */
  public ACRadioButtonItem getStaffUpgradeRadioItem6(){
    if(staffUpgradeRadioItem6==null){

      staffUpgradeRadioItem6 = new ACRadioButtonItem();

      staffUpgradeRadioItem6.setText("加算V");

      staffUpgradeRadioItem6.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem6.setConstraints(VRLayout.FLOW);

      addStaffUpgradeRadioItem6();
    }
    return staffUpgradeRadioItem6;

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

      oldLowElementArea.setFollowChildEnabled(true);

      addOldLowElementArea();
    }
    return oldLowElementArea;

  }

  /**
   * コンストラクタです。
   */
  public QO004_50611_201804Design() {

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

    mainGroup.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getSmallGroupsLifeRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getFunctionImprovementContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getNourishmentImprovementContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getMouthImprovementAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getSelectiveServiceRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getProviderEvaluationContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getStaffUpgradeRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getReduceRateContainer(), VRLayout.FLOW_INSETLINE);

    mainGroup.add(getShahukuReduce(), VRLayout.FLOW_RETURN);

    mainGroup.add(getOldLowElementArea(), VRLayout.FLOW_RETURN);

  }

  /**
   * 職員の欠員による減算の状況ラジオグループに内部項目を追加します。
   */
  protected void addStaffLack(){

  }

  /**
   * 職員の欠員による減算の状況ラジオグループモデルに内部項目を追加します。
   */
  protected void addStaffLackModel(){

    getStaffLackItem1().setButtonIndex(1);

    getStaffLackModel().add(getStaffLackItem1());

    getStaffLackItem2().setButtonIndex(2);

    getStaffLackModel().add(getStaffLackItem2());

    getStaffLackItem3().setButtonIndex(3);

    getStaffLackModel().add(getStaffLackItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addStaffLackItem1(){

  }

  /**
   * 看護職員に内部項目を追加します。
   */
  protected void addStaffLackItem2(){

  }

  /**
   * 介護職員に内部項目を追加します。
   */
  protected void addStaffLackItem3(){

  }

  /**
   * 若年性認知症利用者受入加算に内部項目を追加します。
   */
  protected void addYoungDementiaPatinetAddRadioGroup(){

  }

  /**
   * 若年性認知症利用者受入加算モデルに内部項目を追加します。
   */
  protected void addYoungDementiaPatinetAddRadioGroupModel(){

    getYoungDementiaPatinetAddRadioItem1().setButtonIndex(1);

    getYoungDementiaPatinetAddRadioGroupModel().add(getYoungDementiaPatinetAddRadioItem1());

    getYoungDementiaPatinetAddRadioItem2().setButtonIndex(2);

    getYoungDementiaPatinetAddRadioGroupModel().add(getYoungDementiaPatinetAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addYoungDementiaPatinetAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addYoungDementiaPatinetAddRadioItem2(){

  }

  /**
   * 生活機能向上グループ活動加算に内部項目を追加します。
   */
  protected void addSmallGroupsLifeRadioGroup(){

  }

  /**
   * 生活機能向上グループ活動加算モデルに内部項目を追加します。
   */
  protected void addSmallGroupsLifeRadioGroupModel(){

    getSmallGroupsLifeRadioItem1().setButtonIndex(1);

    getSmallGroupsLifeRadioGroupModel().add(getSmallGroupsLifeRadioItem1());

    getSmallGroupsLifeRadioItem2().setButtonIndex(2);

    getSmallGroupsLifeRadioGroupModel().add(getSmallGroupsLifeRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSmallGroupsLifeRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addSmallGroupsLifeRadioItem2(){

  }

  /**
   * 運動器機能向上体制ラジオグループに内部項目を追加します。
   */
  protected void addFunctionImprovement(){

  }

  /**
   * 運動器機能向上体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addFunctionImprovementModel(){

    getFunctionImprovementItem1().setButtonIndex(1);

    getFunctionImprovementModel().add(getFunctionImprovementItem1());

    getFunctionImprovementItem2().setButtonIndex(2);

    getFunctionImprovementModel().add(getFunctionImprovementItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addFunctionImprovementItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addFunctionImprovementItem2(){

  }

  /**
   * 栄養改善体制ラジオグループに内部項目を追加します。
   */
  protected void addNourishmentImprovement(){

  }

  /**
   * 栄養改善体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addNourishmentImprovementModel(){

    getNourishmentImprovementItem1().setButtonIndex(1);

    getNourishmentImprovementModel().add(getNourishmentImprovementItem1());

    getNourishmentImprovementItem2().setButtonIndex(2);

    getNourishmentImprovementModel().add(getNourishmentImprovementItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNourishmentImprovementItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addNourishmentImprovementItem2(){

  }

  /**
   * 口腔機能向上体制ラジオグループに内部項目を追加します。
   */
  protected void addMouthImprovementAdd(){

  }

  /**
   * 口腔機能向上体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addMouthImprovementAddModel(){

    getMouthImprovementAddItem1().setButtonIndex(1);

    getMouthImprovementAddModel().add(getMouthImprovementAddItem1());

    getMouthImprovementAddItem2().setButtonIndex(2);

    getMouthImprovementAddModel().add(getMouthImprovementAddItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMouthImprovementAddItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMouthImprovementAddItem2(){

  }

  /**
   * 選択的サービス複数実施加算に内部項目を追加します。
   */
  protected void addSelectiveServiceRadioGroup(){

  }

  /**
   * 選択的サービス複数実施加算モデルに内部項目を追加します。
   */
  protected void addSelectiveServiceRadioGroupModel(){

    getSelectiveServiceRadioItem1().setButtonIndex(1);

    getSelectiveServiceRadioGroupModel().add(getSelectiveServiceRadioItem1());

    getSelectiveServiceRadioItem2().setButtonIndex(2);

    getSelectiveServiceRadioGroupModel().add(getSelectiveServiceRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSelectiveServiceRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addSelectiveServiceRadioItem2(){

  }

  /**
   * 事業所評価加算（申出）の有無ラジオグループに内部項目を追加します。
   */
  protected void addProviderEvaluation(){

  }

  /**
   * 事業所評価加算（申出）の有無ラジオグループモデルに内部項目を追加します。
   */
  protected void addProviderEvaluationModel(){

    getProviderEvaluationItem1().setButtonIndex(1);

    getProviderEvaluationModel().add(getProviderEvaluationItem1());

    getProviderEvaluationItem2().setButtonIndex(2);

    getProviderEvaluationModel().add(getProviderEvaluationItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addProviderEvaluationItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addProviderEvaluationItem2(){

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

    getServiceAddProvisionStructuralRadioItem4().setButtonIndex(3);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem4());

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
   * 加算IIに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem4(){

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

    getStaffUpgradeRadioItem2().setButtonIndex(6);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem2());

    getStaffUpgradeRadioItem3().setButtonIndex(5);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem3());

    getStaffUpgradeRadioItem4().setButtonIndex(2);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem4());

    getStaffUpgradeRadioItem5().setButtonIndex(3);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem5());

    getStaffUpgradeRadioItem6().setButtonIndex(4);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem6());

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
   * 加算Vに内部項目を追加します。
   */
  protected void addStaffUpgradeRadioItem6(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004_50611_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004_50611_201804Design getThis() {
    return this;
  }
}
