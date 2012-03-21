
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
 * 作成日: 2012/02/03  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業者登録 (004)
 * プログラム 通所リハ (QO004_11611_201204)
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
 * 通所リハ画面項目デザイン(QO004_11611_201204) 
 */
public class QO004_11611_201204Design extends QO004ProviderPanel {
  //GUIコンポーネント

  private ACGroupBox mainGroup;

  private ACPanel providerMainPanel;

  private ACValueArrayRadioButtonGroup facilitiesDivisionAfterH2104RadioGroup;

  private ACLabelContainer facilitiesDivisionAfterH2104RadioGroupContainer;

  private ACListModelAdapter facilitiesDivisionAfterH2104RadioGroupModel;

  private ACRadioButtonItem facilitiesDivisionAfterH2104RadioItem1;

  private ACRadioButtonItem facilitiesDivisionAfterH2104RadioItem4;

  private ACRadioButtonItem facilitiesDivisionAfterH2104RadioItem2;

  private ACRadioButtonItem facilitiesDivisionAfterH2104RadioItem5;

  private ACRadioButtonItem facilitiesDivisionAfterH2104RadioItem3;

  private ACRadioButtonItem facilitiesDivisionAfterH2104RadioItem6;

  private ACValueArrayRadioButtonGroup staffLack;

  private ACLabelContainer staffLackContainer;

  private ACListModelAdapter staffLackModel;

  private ACRadioButtonItem staffLackItem1;

  private ACRadioButtonItem staffLackItem2;

  private ACRadioButtonItem staffLackItem3;

  private ACRadioButtonItem staffLackItem4;

  private ACRadioButtonItem staffLackItem5;

  private ACRadioButtonItem staffLackItem6;

  private ACRadioButtonItem staffLackItem7;

  private ACValueArrayRadioButtonGroup extendTime;

  private ACLabelContainer extendTimeContainer;

  private ACListModelAdapter extendTimeModel;

  private ACRadioButtonItem extendTimeItem1;

  private ACRadioButtonItem extendTimeItem2;

  private ACValueArrayRadioButtonGroup bathingHelpSystem;

  private ACLabelContainer bathingHelpSystemContainer;

  private ACListModelAdapter bathingHelpSystemModel;

  private ACRadioButtonItem bathingHelpSystemItem1;

  private ACRadioButtonItem bathingHelpSystemItem2;

  private ACValueArrayRadioButtonGroup dementiaRihaAddRadioGroup;

  private ACLabelContainer dementiaRihaAddRadioGroupContainer;

  private ACListModelAdapter dementiaRihaAddRadioGroupModel;

  private ACRadioButtonItem dementiaRihaAddRadioItem1;

  private ACRadioButtonItem dementiaRihaAddRadioItem2;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

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

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACValueArrayRadioButtonGroup staffUpgradeRadioGroup;

  private ACLabelContainer staffUpgradeRadioGroupContainer;

  private ACListModelAdapter staffUpgradeRadioGroupModel;

  private ACRadioButtonItem staffUpgradeRadioItem1;

  private ACRadioButtonItem staffUpgradeRadioItem2;

  private ACRadioButtonItem staffUpgradeRadioItem3;

  private ACRadioButtonItem staffUpgradeRadioItem4;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getMainGroup(){
    if(mainGroup==null){

      mainGroup = new ACGroupBox();

      mainGroup.setText("通所リハ");

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
   * 施設区分ラジオグループ（平成21年4月以降）を取得します。
   * @return 施設区分ラジオグループ（平成21年4月以降）
   */
  public ACValueArrayRadioButtonGroup getFacilitiesDivisionAfterH2104RadioGroup(){
    if(facilitiesDivisionAfterH2104RadioGroup==null){

      facilitiesDivisionAfterH2104RadioGroup = new ACValueArrayRadioButtonGroup();

      getFacilitiesDivisionAfterH2104RadioGroupContainer().setText("施設等の区分");

      facilitiesDivisionAfterH2104RadioGroup.setBindPath("1160112");

      facilitiesDivisionAfterH2104RadioGroup.setNoSelectIndex(0);

      facilitiesDivisionAfterH2104RadioGroup.setUseClearButton(false);

      facilitiesDivisionAfterH2104RadioGroup.setModel(getFacilitiesDivisionAfterH2104RadioGroupModel());

      facilitiesDivisionAfterH2104RadioGroup.setValues(new int[]{1,2,3,4,5,6});

      addFacilitiesDivisionAfterH2104RadioGroup();
    }
    return facilitiesDivisionAfterH2104RadioGroup;

  }

  /**
   * 施設区分ラジオグループ（平成21年4月以降）コンテナを取得します。
   * @return 施設区分ラジオグループ（平成21年4月以降）コンテナ
   */
  protected ACLabelContainer getFacilitiesDivisionAfterH2104RadioGroupContainer(){
    if(facilitiesDivisionAfterH2104RadioGroupContainer==null){
      facilitiesDivisionAfterH2104RadioGroupContainer = new ACLabelContainer();
      facilitiesDivisionAfterH2104RadioGroupContainer.setFollowChildEnabled(true);
      facilitiesDivisionAfterH2104RadioGroupContainer.setVAlignment(VRLayout.CENTER);
      facilitiesDivisionAfterH2104RadioGroupContainer.add(getFacilitiesDivisionAfterH2104RadioGroup(), null);
    }
    return facilitiesDivisionAfterH2104RadioGroupContainer;
  }

  /**
   * 施設区分ラジオグループ（平成21年4月以降）モデルを取得します。
   * @return 施設区分ラジオグループ（平成21年4月以降）モデル
   */
  protected ACListModelAdapter getFacilitiesDivisionAfterH2104RadioGroupModel(){
    if(facilitiesDivisionAfterH2104RadioGroupModel==null){
      facilitiesDivisionAfterH2104RadioGroupModel = new ACListModelAdapter();
      addFacilitiesDivisionAfterH2104RadioGroupModel();
    }
    return facilitiesDivisionAfterH2104RadioGroupModel;
  }

  /**
   * 通常規模の事業所(病院・診療所)を取得します。
   * @return 通常規模の事業所(病院・診療所)
   */
  public ACRadioButtonItem getFacilitiesDivisionAfterH2104RadioItem1(){
    if(facilitiesDivisionAfterH2104RadioItem1==null){

      facilitiesDivisionAfterH2104RadioItem1 = new ACRadioButtonItem();

      facilitiesDivisionAfterH2104RadioItem1.setText("通常規模の事業所（病院・診療所）");

      facilitiesDivisionAfterH2104RadioItem1.setGroup(getFacilitiesDivisionAfterH2104RadioGroup());

      facilitiesDivisionAfterH2104RadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionAfterH2104RadioItem1();
    }
    return facilitiesDivisionAfterH2104RadioItem1;

  }

  /**
   * 通常規模の事業所(介護老人保健施設)を取得します。
   * @return 通常規模の事業所(介護老人保健施設)
   */
  public ACRadioButtonItem getFacilitiesDivisionAfterH2104RadioItem4(){
    if(facilitiesDivisionAfterH2104RadioItem4==null){

      facilitiesDivisionAfterH2104RadioItem4 = new ACRadioButtonItem();

      facilitiesDivisionAfterH2104RadioItem4.setText("通常規模の事業所（介護老人保健施設）");

      facilitiesDivisionAfterH2104RadioItem4.setGroup(getFacilitiesDivisionAfterH2104RadioGroup());

      facilitiesDivisionAfterH2104RadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionAfterH2104RadioItem4();
    }
    return facilitiesDivisionAfterH2104RadioItem4;

  }

  /**
   * 大規模事業所(I)(病院・診療所)を取得します。
   * @return 大規模事業所(I)(病院・診療所)
   */
  public ACRadioButtonItem getFacilitiesDivisionAfterH2104RadioItem2(){
    if(facilitiesDivisionAfterH2104RadioItem2==null){

      facilitiesDivisionAfterH2104RadioItem2 = new ACRadioButtonItem();

      facilitiesDivisionAfterH2104RadioItem2.setText("大規模事業所（I）（病院・診療所）");

      facilitiesDivisionAfterH2104RadioItem2.setGroup(getFacilitiesDivisionAfterH2104RadioGroup());

      facilitiesDivisionAfterH2104RadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionAfterH2104RadioItem2();
    }
    return facilitiesDivisionAfterH2104RadioItem2;

  }

  /**
   * 大規模事業所(I)(介護老人保健施設)を取得します。
   * @return 大規模事業所(I)(介護老人保健施設)
   */
  public ACRadioButtonItem getFacilitiesDivisionAfterH2104RadioItem5(){
    if(facilitiesDivisionAfterH2104RadioItem5==null){

      facilitiesDivisionAfterH2104RadioItem5 = new ACRadioButtonItem();

      facilitiesDivisionAfterH2104RadioItem5.setText("大規模事業所（I）（介護老人保健施設）");

      facilitiesDivisionAfterH2104RadioItem5.setGroup(getFacilitiesDivisionAfterH2104RadioGroup());

      facilitiesDivisionAfterH2104RadioItem5.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionAfterH2104RadioItem5();
    }
    return facilitiesDivisionAfterH2104RadioItem5;

  }

  /**
   * 大規模事業所(II)(病院・診療所)を取得します。
   * @return 大規模事業所(II)(病院・診療所)
   */
  public ACRadioButtonItem getFacilitiesDivisionAfterH2104RadioItem3(){
    if(facilitiesDivisionAfterH2104RadioItem3==null){

      facilitiesDivisionAfterH2104RadioItem3 = new ACRadioButtonItem();

      facilitiesDivisionAfterH2104RadioItem3.setText("大規模事業所（II）（病院・診療所）");

      facilitiesDivisionAfterH2104RadioItem3.setGroup(getFacilitiesDivisionAfterH2104RadioGroup());

      facilitiesDivisionAfterH2104RadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionAfterH2104RadioItem3();
    }
    return facilitiesDivisionAfterH2104RadioItem3;

  }

  /**
   * 大規模事業所(II)(介護老人保健施設)を取得します。
   * @return 大規模事業所(II)(介護老人保健施設)
   */
  public ACRadioButtonItem getFacilitiesDivisionAfterH2104RadioItem6(){
    if(facilitiesDivisionAfterH2104RadioItem6==null){

      facilitiesDivisionAfterH2104RadioItem6 = new ACRadioButtonItem();

      facilitiesDivisionAfterH2104RadioItem6.setText("大規模事業所（II）（介護老人保健施設）");

      facilitiesDivisionAfterH2104RadioItem6.setGroup(getFacilitiesDivisionAfterH2104RadioGroup());

      facilitiesDivisionAfterH2104RadioItem6.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionAfterH2104RadioItem6();
    }
    return facilitiesDivisionAfterH2104RadioItem6;

  }

  /**
   * 職員の欠員による減算の状況ラジオグループを取得します。
   * @return 職員の欠員による減算の状況ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getStaffLack(){
    if(staffLack==null){

      staffLack = new ACValueArrayRadioButtonGroup();

      getStaffLackContainer().setText("職員の欠員による減算の状況");

      staffLack.setBindPath("1160105");

      staffLack.setUseClearButton(false);

      staffLack.setModel(getStaffLackModel());

      staffLack.setValues(new int[]{1,2,3,4,5,6,7});

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
   * 医師を取得します。
   * @return 医師
   */
  public ACRadioButtonItem getStaffLackItem2(){
    if(staffLackItem2==null){

      staffLackItem2 = new ACRadioButtonItem();

      staffLackItem2.setText("医師");

      staffLackItem2.setGroup(getStaffLack());

      staffLackItem2.setConstraints(VRLayout.FLOW);

      addStaffLackItem2();
    }
    return staffLackItem2;

  }

  /**
   * 看護職員を取得します。
   * @return 看護職員
   */
  public ACRadioButtonItem getStaffLackItem3(){
    if(staffLackItem3==null){

      staffLackItem3 = new ACRadioButtonItem();

      staffLackItem3.setText("看護職員");

      staffLackItem3.setGroup(getStaffLack());

      staffLackItem3.setConstraints(VRLayout.FLOW);

      addStaffLackItem3();
    }
    return staffLackItem3;

  }

  /**
   * 介護職員を取得します。
   * @return 介護職員
   */
  public ACRadioButtonItem getStaffLackItem4(){
    if(staffLackItem4==null){

      staffLackItem4 = new ACRadioButtonItem();

      staffLackItem4.setText("介護職員");

      staffLackItem4.setGroup(getStaffLack());

      staffLackItem4.setConstraints(VRLayout.FLOW_RETURN);

      addStaffLackItem4();
    }
    return staffLackItem4;

  }

  /**
   * 理学療法士を取得します。
   * @return 理学療法士
   */
  public ACRadioButtonItem getStaffLackItem5(){
    if(staffLackItem5==null){

      staffLackItem5 = new ACRadioButtonItem();

      staffLackItem5.setText("理学療法士");

      staffLackItem5.setGroup(getStaffLack());

      staffLackItem5.setConstraints(VRLayout.FLOW);

      addStaffLackItem5();
    }
    return staffLackItem5;

  }

  /**
   * 作業療法士を取得します。
   * @return 作業療法士
   */
  public ACRadioButtonItem getStaffLackItem6(){
    if(staffLackItem6==null){

      staffLackItem6 = new ACRadioButtonItem();

      staffLackItem6.setText("作業療法士");

      staffLackItem6.setGroup(getStaffLack());

      staffLackItem6.setConstraints(VRLayout.FLOW);

      addStaffLackItem6();
    }
    return staffLackItem6;

  }

  /**
   * 言語聴覚士を取得します。
   * @return 言語聴覚士
   */
  public ACRadioButtonItem getStaffLackItem7(){
    if(staffLackItem7==null){

      staffLackItem7 = new ACRadioButtonItem();

      staffLackItem7.setText("言語聴覚士");

      staffLackItem7.setGroup(getStaffLack());

      staffLackItem7.setConstraints(VRLayout.FLOW);

      addStaffLackItem7();
    }
    return staffLackItem7;

  }

  /**
   * 時間延長サービス体制を取得します。
   * @return 時間延長サービス体制
   */
  public ACValueArrayRadioButtonGroup getExtendTime(){
    if(extendTime==null){

      extendTime = new ACValueArrayRadioButtonGroup();

      getExtendTimeContainer().setText("時間延長サービス体制");

      extendTime.setBindPath("1160110");

      extendTime.setUseClearButton(false);

      extendTime.setModel(getExtendTimeModel());

      extendTime.setValues(new int[]{1,2});

      addExtendTime();
    }
    return extendTime;

  }

  /**
   * 時間延長サービス体制コンテナを取得します。
   * @return 時間延長サービス体制コンテナ
   */
  protected ACLabelContainer getExtendTimeContainer(){
    if(extendTimeContainer==null){
      extendTimeContainer = new ACLabelContainer();
      extendTimeContainer.setFollowChildEnabled(true);
      extendTimeContainer.setVAlignment(VRLayout.CENTER);
      extendTimeContainer.add(getExtendTime(), null);
    }
    return extendTimeContainer;
  }

  /**
   * 時間延長サービス体制モデルを取得します。
   * @return 時間延長サービス体制モデル
   */
  protected ACListModelAdapter getExtendTimeModel(){
    if(extendTimeModel==null){
      extendTimeModel = new ACListModelAdapter();
      addExtendTimeModel();
    }
    return extendTimeModel;
  }

  /**
   * 対応不可を取得します。
   * @return 対応不可
   */
  public ACRadioButtonItem getExtendTimeItem1(){
    if(extendTimeItem1==null){

      extendTimeItem1 = new ACRadioButtonItem();

      extendTimeItem1.setText("対応不可");

      extendTimeItem1.setGroup(getExtendTime());

      extendTimeItem1.setConstraints(VRLayout.FLOW);

      addExtendTimeItem1();
    }
    return extendTimeItem1;

  }

  /**
   * 対応可を取得します。
   * @return 対応可
   */
  public ACRadioButtonItem getExtendTimeItem2(){
    if(extendTimeItem2==null){

      extendTimeItem2 = new ACRadioButtonItem();

      extendTimeItem2.setText("対応可");

      extendTimeItem2.setGroup(getExtendTime());

      extendTimeItem2.setConstraints(VRLayout.FLOW);

      addExtendTimeItem2();
    }
    return extendTimeItem2;

  }

  /**
   * 入浴介助体制ラジオグループを取得します。
   * @return 入浴介助体制ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getBathingHelpSystem(){
    if(bathingHelpSystem==null){

      bathingHelpSystem = new ACValueArrayRadioButtonGroup();

      getBathingHelpSystemContainer().setText("入浴介助体制");

      bathingHelpSystem.setBindPath("1160102");

      bathingHelpSystem.setUseClearButton(false);

      bathingHelpSystem.setModel(getBathingHelpSystemModel());

      bathingHelpSystem.setValues(new int[]{1,2});

      addBathingHelpSystem();
    }
    return bathingHelpSystem;

  }

  /**
   * 入浴介助体制ラジオグループコンテナを取得します。
   * @return 入浴介助体制ラジオグループコンテナ
   */
  protected ACLabelContainer getBathingHelpSystemContainer(){
    if(bathingHelpSystemContainer==null){
      bathingHelpSystemContainer = new ACLabelContainer();
      bathingHelpSystemContainer.setFollowChildEnabled(true);
      bathingHelpSystemContainer.setVAlignment(VRLayout.CENTER);
      bathingHelpSystemContainer.add(getBathingHelpSystem(), null);
    }
    return bathingHelpSystemContainer;
  }

  /**
   * 入浴介助体制ラジオグループモデルを取得します。
   * @return 入浴介助体制ラジオグループモデル
   */
  protected ACListModelAdapter getBathingHelpSystemModel(){
    if(bathingHelpSystemModel==null){
      bathingHelpSystemModel = new ACListModelAdapter();
      addBathingHelpSystemModel();
    }
    return bathingHelpSystemModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getBathingHelpSystemItem1(){
    if(bathingHelpSystemItem1==null){

      bathingHelpSystemItem1 = new ACRadioButtonItem();

      bathingHelpSystemItem1.setText("なし");

      bathingHelpSystemItem1.setGroup(getBathingHelpSystem());

      bathingHelpSystemItem1.setConstraints(VRLayout.FLOW);

      addBathingHelpSystemItem1();
    }
    return bathingHelpSystemItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getBathingHelpSystemItem2(){
    if(bathingHelpSystemItem2==null){

      bathingHelpSystemItem2 = new ACRadioButtonItem();

      bathingHelpSystemItem2.setText("あり");

      bathingHelpSystemItem2.setGroup(getBathingHelpSystem());

      bathingHelpSystemItem2.setConstraints(VRLayout.FLOW);

      addBathingHelpSystemItem2();
    }
    return bathingHelpSystemItem2;

  }

  /**
   * 認知症短期集中リハビリテーション加算を取得します。
   * @return 認知症短期集中リハビリテーション加算
   */
  public ACValueArrayRadioButtonGroup getDementiaRihaAddRadioGroup(){
    if(dementiaRihaAddRadioGroup==null){

      dementiaRihaAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaRihaAddRadioGroupContainer().setText("認知症短期集中リハビリテーション加算");

      dementiaRihaAddRadioGroup.setBindPath("1160113");

      dementiaRihaAddRadioGroup.setNoSelectIndex(0);

      dementiaRihaAddRadioGroup.setUseClearButton(false);

      dementiaRihaAddRadioGroup.setModel(getDementiaRihaAddRadioGroupModel());

      dementiaRihaAddRadioGroup.setValues(new int[]{1,2});

      addDementiaRihaAddRadioGroup();
    }
    return dementiaRihaAddRadioGroup;

  }

  /**
   * 認知症短期集中リハビリテーション加算コンテナを取得します。
   * @return 認知症短期集中リハビリテーション加算コンテナ
   */
  protected ACLabelContainer getDementiaRihaAddRadioGroupContainer(){
    if(dementiaRihaAddRadioGroupContainer==null){
      dementiaRihaAddRadioGroupContainer = new ACLabelContainer();
      dementiaRihaAddRadioGroupContainer.setFollowChildEnabled(true);
      dementiaRihaAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      dementiaRihaAddRadioGroupContainer.add(getDementiaRihaAddRadioGroup(), null);
    }
    return dementiaRihaAddRadioGroupContainer;
  }

  /**
   * 認知症短期集中リハビリテーション加算モデルを取得します。
   * @return 認知症短期集中リハビリテーション加算モデル
   */
  protected ACListModelAdapter getDementiaRihaAddRadioGroupModel(){
    if(dementiaRihaAddRadioGroupModel==null){
      dementiaRihaAddRadioGroupModel = new ACListModelAdapter();
      addDementiaRihaAddRadioGroupModel();
    }
    return dementiaRihaAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getDementiaRihaAddRadioItem1(){
    if(dementiaRihaAddRadioItem1==null){

      dementiaRihaAddRadioItem1 = new ACRadioButtonItem();

      dementiaRihaAddRadioItem1.setText("なし");

      dementiaRihaAddRadioItem1.setGroup(getDementiaRihaAddRadioGroup());

      dementiaRihaAddRadioItem1.setConstraints(VRLayout.FLOW);

      addDementiaRihaAddRadioItem1();
    }
    return dementiaRihaAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getDementiaRihaAddRadioItem2(){
    if(dementiaRihaAddRadioItem2==null){

      dementiaRihaAddRadioItem2 = new ACRadioButtonItem();

      dementiaRihaAddRadioItem2.setText("あり");

      dementiaRihaAddRadioItem2.setGroup(getDementiaRihaAddRadioGroup());

      dementiaRihaAddRadioItem2.setConstraints(VRLayout.FLOW);

      addDementiaRihaAddRadioItem2();
    }
    return dementiaRihaAddRadioItem2;

  }

  /**
   * 若年性認知症利用者受入加算を取得します。
   * @return 若年性認知症利用者受入加算
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("若年性認知症利用者受入加算");

      youngDementiaPatinetAddRadioGroup.setBindPath("1160114");

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
   * 栄養改善体制を取得します。
   * @return 栄養改善体制
   */
  public ACValueArrayRadioButtonGroup getNourishmentImprovement(){
    if(nourishmentImprovement==null){

      nourishmentImprovement = new ACValueArrayRadioButtonGroup();

      getNourishmentImprovementContainer().setText("栄養改善体制");

      nourishmentImprovement.setBindPath("1160116");

      nourishmentImprovement.setUseClearButton(false);

      nourishmentImprovement.setModel(getNourishmentImprovementModel());

      nourishmentImprovement.setValues(new int[]{1,2});

      addNourishmentImprovement();
    }
    return nourishmentImprovement;

  }

  /**
   * 栄養改善体制コンテナを取得します。
   * @return 栄養改善体制コンテナ
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
   * 栄養改善体制モデルを取得します。
   * @return 栄養改善体制モデル
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
   * 口腔機能向上体制を取得します。
   * @return 口腔機能向上体制
   */
  public ACValueArrayRadioButtonGroup getMouthImprovementAdd(){
    if(mouthImprovementAdd==null){

      mouthImprovementAdd = new ACValueArrayRadioButtonGroup();

      getMouthImprovementAddContainer().setText("口腔機能向上体制");

      mouthImprovementAdd.setBindPath("1160109");

      mouthImprovementAdd.setUseClearButton(false);

      mouthImprovementAdd.setModel(getMouthImprovementAddModel());

      mouthImprovementAdd.setValues(new int[]{1,2});

      addMouthImprovementAdd();
    }
    return mouthImprovementAdd;

  }

  /**
   * 口腔機能向上体制コンテナを取得します。
   * @return 口腔機能向上体制コンテナ
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
   * 口腔機能向上体制モデルを取得します。
   * @return 口腔機能向上体制モデル
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
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1160115");

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
   * 加算Iを取得します。
   * @return 加算I
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("加算I");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem2();
    }
    return serviceAddProvisionStructuralRadioItem2;

  }

  /**
   * 加算IIを取得します。
   * @return 加算II
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem3(){
    if(serviceAddProvisionStructuralRadioItem3==null){

      serviceAddProvisionStructuralRadioItem3 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem3.setText("加算II");

      serviceAddProvisionStructuralRadioItem3.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem3();
    }
    return serviceAddProvisionStructuralRadioItem3;

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
   * コンストラクタです。
   */
  public QO004_11611_201204Design() {

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

    providerMainPanel.add(getFacilitiesDivisionAfterH2104RadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getExtendTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getBathingHelpSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getDementiaRihaAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getNourishmentImprovementContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getMouthImprovementAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getStaffUpgradeRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 施設区分ラジオグループ（平成21年4月以降）に内部項目を追加します。
   */
  protected void addFacilitiesDivisionAfterH2104RadioGroup(){

  }

  /**
   * 施設区分ラジオグループ（平成21年4月以降）モデルに内部項目を追加します。
   */
  protected void addFacilitiesDivisionAfterH2104RadioGroupModel(){

    getFacilitiesDivisionAfterH2104RadioItem1().setButtonIndex(1);

    getFacilitiesDivisionAfterH2104RadioGroupModel().add(getFacilitiesDivisionAfterH2104RadioItem1());

    getFacilitiesDivisionAfterH2104RadioItem4().setButtonIndex(2);

    getFacilitiesDivisionAfterH2104RadioGroupModel().add(getFacilitiesDivisionAfterH2104RadioItem4());

    getFacilitiesDivisionAfterH2104RadioItem2().setButtonIndex(3);

    getFacilitiesDivisionAfterH2104RadioGroupModel().add(getFacilitiesDivisionAfterH2104RadioItem2());

    getFacilitiesDivisionAfterH2104RadioItem5().setButtonIndex(4);

    getFacilitiesDivisionAfterH2104RadioGroupModel().add(getFacilitiesDivisionAfterH2104RadioItem5());

    getFacilitiesDivisionAfterH2104RadioItem3().setButtonIndex(5);

    getFacilitiesDivisionAfterH2104RadioGroupModel().add(getFacilitiesDivisionAfterH2104RadioItem3());

    getFacilitiesDivisionAfterH2104RadioItem6().setButtonIndex(6);

    getFacilitiesDivisionAfterH2104RadioGroupModel().add(getFacilitiesDivisionAfterH2104RadioItem6());

  }

  /**
   * 通常規模の事業所(病院・診療所)に内部項目を追加します。
   */
  protected void addFacilitiesDivisionAfterH2104RadioItem1(){

  }

  /**
   * 通常規模の事業所(介護老人保健施設)に内部項目を追加します。
   */
  protected void addFacilitiesDivisionAfterH2104RadioItem4(){

  }

  /**
   * 大規模事業所(I)(病院・診療所)に内部項目を追加します。
   */
  protected void addFacilitiesDivisionAfterH2104RadioItem2(){

  }

  /**
   * 大規模事業所(I)(介護老人保健施設)に内部項目を追加します。
   */
  protected void addFacilitiesDivisionAfterH2104RadioItem5(){

  }

  /**
   * 大規模事業所(II)(病院・診療所)に内部項目を追加します。
   */
  protected void addFacilitiesDivisionAfterH2104RadioItem3(){

  }

  /**
   * 大規模事業所(II)(介護老人保健施設)に内部項目を追加します。
   */
  protected void addFacilitiesDivisionAfterH2104RadioItem6(){

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

    getStaffLackItem4().setButtonIndex(4);

    getStaffLackModel().add(getStaffLackItem4());

    getStaffLackItem5().setButtonIndex(5);

    getStaffLackModel().add(getStaffLackItem5());

    getStaffLackItem6().setButtonIndex(6);

    getStaffLackModel().add(getStaffLackItem6());

    getStaffLackItem7().setButtonIndex(7);

    getStaffLackModel().add(getStaffLackItem7());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addStaffLackItem1(){

  }

  /**
   * 医師に内部項目を追加します。
   */
  protected void addStaffLackItem2(){

  }

  /**
   * 看護職員に内部項目を追加します。
   */
  protected void addStaffLackItem3(){

  }

  /**
   * 介護職員に内部項目を追加します。
   */
  protected void addStaffLackItem4(){

  }

  /**
   * 理学療法士に内部項目を追加します。
   */
  protected void addStaffLackItem5(){

  }

  /**
   * 作業療法士に内部項目を追加します。
   */
  protected void addStaffLackItem6(){

  }

  /**
   * 言語聴覚士に内部項目を追加します。
   */
  protected void addStaffLackItem7(){

  }

  /**
   * 時間延長サービス体制に内部項目を追加します。
   */
  protected void addExtendTime(){

  }

  /**
   * 時間延長サービス体制モデルに内部項目を追加します。
   */
  protected void addExtendTimeModel(){

    getExtendTimeItem1().setButtonIndex(1);

    getExtendTimeModel().add(getExtendTimeItem1());

    getExtendTimeItem2().setButtonIndex(2);

    getExtendTimeModel().add(getExtendTimeItem2());

  }

  /**
   * 対応不可に内部項目を追加します。
   */
  protected void addExtendTimeItem1(){

  }

  /**
   * 対応可に内部項目を追加します。
   */
  protected void addExtendTimeItem2(){

  }

  /**
   * 入浴介助体制ラジオグループに内部項目を追加します。
   */
  protected void addBathingHelpSystem(){

  }

  /**
   * 入浴介助体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addBathingHelpSystemModel(){

    getBathingHelpSystemItem1().setButtonIndex(1);

    getBathingHelpSystemModel().add(getBathingHelpSystemItem1());

    getBathingHelpSystemItem2().setButtonIndex(2);

    getBathingHelpSystemModel().add(getBathingHelpSystemItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addBathingHelpSystemItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addBathingHelpSystemItem2(){

  }

  /**
   * 認知症短期集中リハビリテーション加算に内部項目を追加します。
   */
  protected void addDementiaRihaAddRadioGroup(){

  }

  /**
   * 認知症短期集中リハビリテーション加算モデルに内部項目を追加します。
   */
  protected void addDementiaRihaAddRadioGroupModel(){

    getDementiaRihaAddRadioItem1().setButtonIndex(1);

    getDementiaRihaAddRadioGroupModel().add(getDementiaRihaAddRadioItem1());

    getDementiaRihaAddRadioItem2().setButtonIndex(2);

    getDementiaRihaAddRadioGroupModel().add(getDementiaRihaAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addDementiaRihaAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addDementiaRihaAddRadioItem2(){

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
   * 栄養改善体制に内部項目を追加します。
   */
  protected void addNourishmentImprovement(){

  }

  /**
   * 栄養改善体制モデルに内部項目を追加します。
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
   * 口腔機能向上体制に内部項目を追加します。
   */
  protected void addMouthImprovementAdd(){

  }

  /**
   * 口腔機能向上体制モデルに内部項目を追加します。
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
   * 加算Iに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * 加算IIに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem3(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004_11611_201204Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004_11611_201204Design getThis() {
    return this;
  }
}
