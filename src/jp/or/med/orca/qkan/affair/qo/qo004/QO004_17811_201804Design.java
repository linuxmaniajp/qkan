
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
 * 開発者: 日高しのぶ
 * 作成日: 2018/01/30  日本コンピューター株式会社 日高しのぶ 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業者登録 (004)
 * プログラム 地域密着型通所介護 (QO004_17811_201804)
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
 * 地域密着型通所介護画面項目デザイン(QO004_17811_201804) 
 */
public class QO004_17811_201804Design extends QO004ProviderPanel {
  //GUIコンポーネント

  private ACGroupBox mainGroup;

  private JTabbedPane tab;

  private ACPanel panel1;

  private ACPanel providerMainPanel;

  private ACLabelContainer facilitiesDivisionContainer;

  private ACValueArrayRadioButtonGroup facilitiesDivision;

  private ACListModelAdapter facilitiesDivisionModel;

  private ACRadioButtonItem facilitiesDivisionItem1;

  private ACRadioButtonItem facilitiesDivisionItem2;

  private ACValueArrayRadioButtonGroup staffLack;

  private ACLabelContainer staffLackContainer;

  private ACListModelAdapter staffLackModel;

  private ACRadioButtonItem staffLackItem1;

  private ACRadioButtonItem staffLackItem2;

  private ACRadioButtonItem staffLackItem3;

  private ACValueArrayRadioButtonGroup extendTime;

  private ACLabelContainer extendTimeContainer;

  private ACListModelAdapter extendTimeModel;

  private ACRadioButtonItem extendTimeItem1;

  private ACRadioButtonItem extendTimeItem2;

  private ACValueArrayRadioButtonGroup kyoseiServiceSeikatsuRadioGroup;

  private ACLabelContainer kyoseiServiceSeikatsuRadioGroupContainer;

  private ACListModelAdapter kyoseiServiceSeikatsuRadioGroupModel;

  private ACRadioButtonItem kyoseiServiceSeikatsuRadioItem1;

  private ACRadioButtonItem kyoseiServiceSeikatsuRadioItem2;

  private ACValueArrayRadioButtonGroup kyoseiServiceJiritsuRadioGroup;

  private ACLabelContainer kyoseiServiceJiritsuRadioGroupContainer;

  private ACListModelAdapter kyoseiServiceJiritsuRadioGroupModel;

  private ACRadioButtonItem kyoseiServiceJiritsuRadioItem1;

  private ACRadioButtonItem kyoseiServiceJiritsuRadioItem2;

  private ACValueArrayRadioButtonGroup kyoseiServiceJidoRadioGroup;

  private ACLabelContainer kyoseiServiceJidoRadioGroupContainer;

  private ACListModelAdapter kyoseiServiceJidoRadioGroupModel;

  private ACRadioButtonItem kyoseiServiceJidoRadioItem1;

  private ACRadioButtonItem kyoseiServiceJidoRadioItem2;

  private ACValueArrayRadioButtonGroup kyoseiServiceDayRadioGroup;

  private ACLabelContainer kyoseiServiceDayRadioGroupContainer;

  private ACListModelAdapter kyoseiServiceDayRadioGroupModel;

  private ACRadioButtonItem kyoseiServiceDayRadioItem1;

  private ACRadioButtonItem kyoseiServiceDayRadioItem2;

  private ACValueArrayRadioButtonGroup seikatsuSoudanGroup;

  private ACLabelContainer seikatsuSoudanGroupContainer;

  private ACListModelAdapter seikatsuSoudanGroupModel;

  private ACRadioButtonItem seikatsuSoudanGroupItem1;

  private ACRadioButtonItem seikatsuSoudanGroupItem2;

  private ACValueArrayRadioButtonGroup bathingHelpSystem;

  private ACLabelContainer bathingHelpSystemContainer;

  private ACListModelAdapter bathingHelpSystemModel;

  private ACRadioButtonItem bathingHelpSystemItem1;

  private ACRadioButtonItem bathingHelpSystemItem2;

  private ACValueArrayRadioButtonGroup mediumSeverePersonCare;

  private ACLabelContainer mediumSeverePersonCareContainer;

  private ACListModelAdapter mediumSeverePersonCareModel;

  private ACRadioButtonItem mediumSeverePersonCareItem1;

  private ACRadioButtonItem mediumSeverePersonCareItem2;

  private ACValueArrayRadioButtonGroup seikatsuKinouGroup;

  private ACLabelContainer seikatsuKinouGroupContainer;

  private ACListModelAdapter seikatsuKinouGroupModel;

  private ACRadioButtonItem seikatsuKinouGroupItem1;

  private ACRadioButtonItem seikatsuKinouGroupItem2;

  private ACValueArrayRadioButtonGroup individualfunctionTrainingSystem;

  private ACLabelContainer individualfunctionTrainingSystemContainer;

  private ACListModelAdapter individualfunctionTrainingSystemModel;

  private ACRadioButtonItem individualfunctionTrainingSystemItem1;

  private ACRadioButtonItem individualfunctionTrainingSystemItem2;

  private ACValueArrayRadioButtonGroup individualfunctionTrainingSystem2;

  private ACLabelContainer individualfunctionTrainingSystem2Container;

  private ACListModelAdapter individualfunctionTrainingSystem2Model;

  private ACRadioButtonItem individualfunctionTrainingSystem2Item1;

  private ACRadioButtonItem individualfunctionTrainingSystem2Item2;

  private ACValueArrayRadioButtonGroup adlIjiGroup;

  private ACLabelContainer adlIjiGroupContainer;

  private ACListModelAdapter adlIjiGroupModel;

  private ACRadioButtonItem adlIjiGroupItem1;

  private ACRadioButtonItem adlIjiGroupItem2;

  private ACValueArrayRadioButtonGroup adlIjiGroup2;

  private ACLabelContainer adlIjiGroup2Container;

  private ACListModelAdapter adlIjiGroup2Model;

  private ACRadioButtonItem adlIjiGroup2Item1;

  private ACRadioButtonItem adlIjiGroup2Item2;

  private ACPanel panel2;

  private ACPanel calculationDetails2;

  private ACValueArrayRadioButtonGroup dementiaAdd;

  private ACLabelContainer dementiaAddContainer;

  private ACListModelAdapter dementiaAddModel;

  private ACRadioButtonItem dementiaAddItem1;

  private ACRadioButtonItem dementiaAddItem2;

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

  private ACValueArrayRadioButtonGroup individualPickupSystem;

  private ACLabelContainer individualPickupSystemContainer;

  private ACListModelAdapter individualPickupSystemModel;

  private ACRadioButtonItem individualPickupSystemItem1;

  private ACRadioButtonItem individualPickupSystemItem2;

  private ACValueArrayRadioButtonGroup bathingAssistanceSystem;

  private ACLabelContainer bathingAssistanceSystemContainer;

  private ACListModelAdapter bathingAssistanceSystemModel;

  private ACRadioButtonItem bathingAssistanceSystemItem1;

  private ACRadioButtonItem bathingAssistanceSystemItem2;

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

  private ACRadioButtonItem staffUpgradeRadioItem6;

  private ACPanel providerSubPanel;

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

      mainGroup.setText("地域密着型通所介護");

      mainGroup.setFollowChildEnabled(true);

      mainGroup.setHgrid(200);

      addMainGroup();
    }
    return mainGroup;

  }

  /**
   * タブを取得します。
   * @return タブ
   */
  public JTabbedPane getTab(){
    if(tab==null){

      tab = new JTabbedPane();

      addTab();
    }
    return tab;

  }

  /**
   * パネル１を取得します。
   * @return パネル１
   */
  public ACPanel getPanel1(){
    if(panel1==null){

      panel1 = new ACPanel();

      panel1.setFollowChildEnabled(true);

      addPanel1();
    }
    return panel1;

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

      providerMainPanel.setHgrid(200);

      addProviderMainPanel();
    }
    return providerMainPanel;

  }

  /**
   * 施設区分コンテナを取得します。
   * @return 施設区分コンテナ
   */
  public ACLabelContainer getFacilitiesDivisionContainer(){
    if(facilitiesDivisionContainer==null){

      facilitiesDivisionContainer = new ACLabelContainer();

      facilitiesDivisionContainer.setText("施設等の区分");

      facilitiesDivisionContainer.setFollowChildEnabled(true);

      facilitiesDivisionContainer.setHgap(0);

      facilitiesDivisionContainer.setLabelMargin(0);

      facilitiesDivisionContainer.setVgap(0);

      addFacilitiesDivisionContainer();
    }
    return facilitiesDivisionContainer;

  }

  /**
   * 施設区分ラジオグループを取得します。
   * @return 施設区分ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getFacilitiesDivision(){
    if(facilitiesDivision==null){

      facilitiesDivision = new ACValueArrayRadioButtonGroup();

      facilitiesDivision.setBindPath("1780101");

      facilitiesDivision.setUseClearButton(false);

      facilitiesDivision.setModel(getFacilitiesDivisionModel());

      facilitiesDivision.setValues(new int[]{1,2});

      addFacilitiesDivision();
    }
    return facilitiesDivision;

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
   * 地域密着型通所介護を取得します。
   * @return 地域密着型通所介護
   */
  public ACRadioButtonItem getFacilitiesDivisionItem1(){
    if(facilitiesDivisionItem1==null){

      facilitiesDivisionItem1 = new ACRadioButtonItem();

      facilitiesDivisionItem1.setText("地域密着型通所介護");

      facilitiesDivisionItem1.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem1.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem1();
    }
    return facilitiesDivisionItem1;

  }

  /**
   * 療養通所介護を取得します。
   * @return 療養通所介護
   */
  public ACRadioButtonItem getFacilitiesDivisionItem2(){
    if(facilitiesDivisionItem2==null){

      facilitiesDivisionItem2 = new ACRadioButtonItem();

      facilitiesDivisionItem2.setText("療養通所介護");

      facilitiesDivisionItem2.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem2.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem2();
    }
    return facilitiesDivisionItem2;

  }

  /**
   * 職員の欠員による減算の状況ラジオグループを取得します。
   * @return 職員の欠員による減算の状況ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getStaffLack(){
    if(staffLack==null){

      staffLack = new ACValueArrayRadioButtonGroup();

      getStaffLackContainer().setText("職員の欠員による減算の状況");

      staffLack.setBindPath("1780102");

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
   * 時間延長サービス体制を取得します。
   * @return 時間延長サービス体制
   */
  public ACValueArrayRadioButtonGroup getExtendTime(){
    if(extendTime==null){

      extendTime = new ACValueArrayRadioButtonGroup();

      getExtendTimeContainer().setText("時間延長サービス体制");

      extendTime.setBindPath("1780103");

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
   * 共生型サービスの提供（生活介護事業所）を取得します。
   * @return 共生型サービスの提供（生活介護事業所）
   */
  public ACValueArrayRadioButtonGroup getKyoseiServiceSeikatsuRadioGroup(){
    if(kyoseiServiceSeikatsuRadioGroup==null){

      kyoseiServiceSeikatsuRadioGroup = new ACValueArrayRadioButtonGroup();

      getKyoseiServiceSeikatsuRadioGroupContainer().setText("共生型サービスの提供（生活介護事業所）");

      kyoseiServiceSeikatsuRadioGroup.setBindPath("1780114");

      kyoseiServiceSeikatsuRadioGroup.setVisible(true);

      kyoseiServiceSeikatsuRadioGroup.setEnabled(true);

      kyoseiServiceSeikatsuRadioGroup.setNoSelectIndex(0);

      kyoseiServiceSeikatsuRadioGroup.setUseClearButton(false);

      kyoseiServiceSeikatsuRadioGroup.setModel(getKyoseiServiceSeikatsuRadioGroupModel());

      kyoseiServiceSeikatsuRadioGroup.setValues(new int[]{1,2});

      addKyoseiServiceSeikatsuRadioGroup();
    }
    return kyoseiServiceSeikatsuRadioGroup;

  }

  /**
   * 共生型サービスの提供（生活介護事業所）コンテナを取得します。
   * @return 共生型サービスの提供（生活介護事業所）コンテナ
   */
  protected ACLabelContainer getKyoseiServiceSeikatsuRadioGroupContainer(){
    if(kyoseiServiceSeikatsuRadioGroupContainer==null){
      kyoseiServiceSeikatsuRadioGroupContainer = new ACLabelContainer();
      kyoseiServiceSeikatsuRadioGroupContainer.setFollowChildEnabled(true);
      kyoseiServiceSeikatsuRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      kyoseiServiceSeikatsuRadioGroupContainer.add(getKyoseiServiceSeikatsuRadioGroup(), null);
    }
    return kyoseiServiceSeikatsuRadioGroupContainer;
  }

  /**
   * 共生型サービスの提供（生活介護事業所）モデルを取得します。
   * @return 共生型サービスの提供（生活介護事業所）モデル
   */
  protected ACListModelAdapter getKyoseiServiceSeikatsuRadioGroupModel(){
    if(kyoseiServiceSeikatsuRadioGroupModel==null){
      kyoseiServiceSeikatsuRadioGroupModel = new ACListModelAdapter();
      addKyoseiServiceSeikatsuRadioGroupModel();
    }
    return kyoseiServiceSeikatsuRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKyoseiServiceSeikatsuRadioItem1(){
    if(kyoseiServiceSeikatsuRadioItem1==null){

      kyoseiServiceSeikatsuRadioItem1 = new ACRadioButtonItem();

      kyoseiServiceSeikatsuRadioItem1.setText("なし");

      kyoseiServiceSeikatsuRadioItem1.setGroup(getKyoseiServiceSeikatsuRadioGroup());

      kyoseiServiceSeikatsuRadioItem1.setConstraints(VRLayout.FLOW);

      addKyoseiServiceSeikatsuRadioItem1();
    }
    return kyoseiServiceSeikatsuRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKyoseiServiceSeikatsuRadioItem2(){
    if(kyoseiServiceSeikatsuRadioItem2==null){

      kyoseiServiceSeikatsuRadioItem2 = new ACRadioButtonItem();

      kyoseiServiceSeikatsuRadioItem2.setText("あり");

      kyoseiServiceSeikatsuRadioItem2.setGroup(getKyoseiServiceSeikatsuRadioGroup());

      kyoseiServiceSeikatsuRadioItem2.setConstraints(VRLayout.FLOW);

      addKyoseiServiceSeikatsuRadioItem2();
    }
    return kyoseiServiceSeikatsuRadioItem2;

  }

  /**
   * 共生型サービスの提供（自立訓練事業所）を取得します。
   * @return 共生型サービスの提供（自立訓練事業所）
   */
  public ACValueArrayRadioButtonGroup getKyoseiServiceJiritsuRadioGroup(){
    if(kyoseiServiceJiritsuRadioGroup==null){

      kyoseiServiceJiritsuRadioGroup = new ACValueArrayRadioButtonGroup();

      getKyoseiServiceJiritsuRadioGroupContainer().setText("共生型サービスの提供（自立訓練事業所）");

      kyoseiServiceJiritsuRadioGroup.setBindPath("1780115");

      kyoseiServiceJiritsuRadioGroup.setVisible(true);

      kyoseiServiceJiritsuRadioGroup.setEnabled(true);

      kyoseiServiceJiritsuRadioGroup.setNoSelectIndex(0);

      kyoseiServiceJiritsuRadioGroup.setUseClearButton(false);

      kyoseiServiceJiritsuRadioGroup.setModel(getKyoseiServiceJiritsuRadioGroupModel());

      kyoseiServiceJiritsuRadioGroup.setValues(new int[]{1,2});

      addKyoseiServiceJiritsuRadioGroup();
    }
    return kyoseiServiceJiritsuRadioGroup;

  }

  /**
   * 共生型サービスの提供（自立訓練事業所）コンテナを取得します。
   * @return 共生型サービスの提供（自立訓練事業所）コンテナ
   */
  protected ACLabelContainer getKyoseiServiceJiritsuRadioGroupContainer(){
    if(kyoseiServiceJiritsuRadioGroupContainer==null){
      kyoseiServiceJiritsuRadioGroupContainer = new ACLabelContainer();
      kyoseiServiceJiritsuRadioGroupContainer.setFollowChildEnabled(true);
      kyoseiServiceJiritsuRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      kyoseiServiceJiritsuRadioGroupContainer.add(getKyoseiServiceJiritsuRadioGroup(), null);
    }
    return kyoseiServiceJiritsuRadioGroupContainer;
  }

  /**
   * 共生型サービスの提供（自立訓練事業所）モデルを取得します。
   * @return 共生型サービスの提供（自立訓練事業所）モデル
   */
  protected ACListModelAdapter getKyoseiServiceJiritsuRadioGroupModel(){
    if(kyoseiServiceJiritsuRadioGroupModel==null){
      kyoseiServiceJiritsuRadioGroupModel = new ACListModelAdapter();
      addKyoseiServiceJiritsuRadioGroupModel();
    }
    return kyoseiServiceJiritsuRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKyoseiServiceJiritsuRadioItem1(){
    if(kyoseiServiceJiritsuRadioItem1==null){

      kyoseiServiceJiritsuRadioItem1 = new ACRadioButtonItem();

      kyoseiServiceJiritsuRadioItem1.setText("なし");

      kyoseiServiceJiritsuRadioItem1.setGroup(getKyoseiServiceJiritsuRadioGroup());

      kyoseiServiceJiritsuRadioItem1.setConstraints(VRLayout.FLOW);

      addKyoseiServiceJiritsuRadioItem1();
    }
    return kyoseiServiceJiritsuRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKyoseiServiceJiritsuRadioItem2(){
    if(kyoseiServiceJiritsuRadioItem2==null){

      kyoseiServiceJiritsuRadioItem2 = new ACRadioButtonItem();

      kyoseiServiceJiritsuRadioItem2.setText("あり");

      kyoseiServiceJiritsuRadioItem2.setGroup(getKyoseiServiceJiritsuRadioGroup());

      kyoseiServiceJiritsuRadioItem2.setConstraints(VRLayout.FLOW);

      addKyoseiServiceJiritsuRadioItem2();
    }
    return kyoseiServiceJiritsuRadioItem2;

  }

  /**
   * 共生型サービスの提供（児童発達支援事業所）を取得します。
   * @return 共生型サービスの提供（児童発達支援事業所）
   */
  public ACValueArrayRadioButtonGroup getKyoseiServiceJidoRadioGroup(){
    if(kyoseiServiceJidoRadioGroup==null){

      kyoseiServiceJidoRadioGroup = new ACValueArrayRadioButtonGroup();

      getKyoseiServiceJidoRadioGroupContainer().setText("共生型サービスの提供（児童発達支援事業所）");

      kyoseiServiceJidoRadioGroup.setBindPath("1780116");

      kyoseiServiceJidoRadioGroup.setVisible(true);

      kyoseiServiceJidoRadioGroup.setEnabled(true);

      kyoseiServiceJidoRadioGroup.setNoSelectIndex(0);

      kyoseiServiceJidoRadioGroup.setUseClearButton(false);

      kyoseiServiceJidoRadioGroup.setModel(getKyoseiServiceJidoRadioGroupModel());

      kyoseiServiceJidoRadioGroup.setValues(new int[]{1,2});

      addKyoseiServiceJidoRadioGroup();
    }
    return kyoseiServiceJidoRadioGroup;

  }

  /**
   * 共生型サービスの提供（児童発達支援事業所）コンテナを取得します。
   * @return 共生型サービスの提供（児童発達支援事業所）コンテナ
   */
  protected ACLabelContainer getKyoseiServiceJidoRadioGroupContainer(){
    if(kyoseiServiceJidoRadioGroupContainer==null){
      kyoseiServiceJidoRadioGroupContainer = new ACLabelContainer();
      kyoseiServiceJidoRadioGroupContainer.setFollowChildEnabled(true);
      kyoseiServiceJidoRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      kyoseiServiceJidoRadioGroupContainer.add(getKyoseiServiceJidoRadioGroup(), null);
    }
    return kyoseiServiceJidoRadioGroupContainer;
  }

  /**
   * 共生型サービスの提供（児童発達支援事業所）モデルを取得します。
   * @return 共生型サービスの提供（児童発達支援事業所）モデル
   */
  protected ACListModelAdapter getKyoseiServiceJidoRadioGroupModel(){
    if(kyoseiServiceJidoRadioGroupModel==null){
      kyoseiServiceJidoRadioGroupModel = new ACListModelAdapter();
      addKyoseiServiceJidoRadioGroupModel();
    }
    return kyoseiServiceJidoRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKyoseiServiceJidoRadioItem1(){
    if(kyoseiServiceJidoRadioItem1==null){

      kyoseiServiceJidoRadioItem1 = new ACRadioButtonItem();

      kyoseiServiceJidoRadioItem1.setText("なし");

      kyoseiServiceJidoRadioItem1.setGroup(getKyoseiServiceJidoRadioGroup());

      kyoseiServiceJidoRadioItem1.setConstraints(VRLayout.FLOW);

      addKyoseiServiceJidoRadioItem1();
    }
    return kyoseiServiceJidoRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKyoseiServiceJidoRadioItem2(){
    if(kyoseiServiceJidoRadioItem2==null){

      kyoseiServiceJidoRadioItem2 = new ACRadioButtonItem();

      kyoseiServiceJidoRadioItem2.setText("あり");

      kyoseiServiceJidoRadioItem2.setGroup(getKyoseiServiceJidoRadioGroup());

      kyoseiServiceJidoRadioItem2.setConstraints(VRLayout.FLOW);

      addKyoseiServiceJidoRadioItem2();
    }
    return kyoseiServiceJidoRadioItem2;

  }

  /**
   * 共生型サービスの提供（放課後等デイサービス事業所）を取得します。
   * @return 共生型サービスの提供（放課後等デイサービス事業所）
   */
  public ACValueArrayRadioButtonGroup getKyoseiServiceDayRadioGroup(){
    if(kyoseiServiceDayRadioGroup==null){

      kyoseiServiceDayRadioGroup = new ACValueArrayRadioButtonGroup();

      getKyoseiServiceDayRadioGroupContainer().setText("共生型サービスの提供（放課後等デイサービス事業所）");

      kyoseiServiceDayRadioGroup.setBindPath("1780117");

      kyoseiServiceDayRadioGroup.setVisible(true);

      kyoseiServiceDayRadioGroup.setEnabled(true);

      kyoseiServiceDayRadioGroup.setNoSelectIndex(0);

      kyoseiServiceDayRadioGroup.setUseClearButton(false);

      kyoseiServiceDayRadioGroup.setModel(getKyoseiServiceDayRadioGroupModel());

      kyoseiServiceDayRadioGroup.setValues(new int[]{1,2});

      addKyoseiServiceDayRadioGroup();
    }
    return kyoseiServiceDayRadioGroup;

  }

  /**
   * 共生型サービスの提供（放課後等デイサービス事業所）コンテナを取得します。
   * @return 共生型サービスの提供（放課後等デイサービス事業所）コンテナ
   */
  protected ACLabelContainer getKyoseiServiceDayRadioGroupContainer(){
    if(kyoseiServiceDayRadioGroupContainer==null){
      kyoseiServiceDayRadioGroupContainer = new ACLabelContainer();
      kyoseiServiceDayRadioGroupContainer.setFollowChildEnabled(true);
      kyoseiServiceDayRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      kyoseiServiceDayRadioGroupContainer.add(getKyoseiServiceDayRadioGroup(), null);
    }
    return kyoseiServiceDayRadioGroupContainer;
  }

  /**
   * 共生型サービスの提供（放課後等デイサービス事業所）モデルを取得します。
   * @return 共生型サービスの提供（放課後等デイサービス事業所）モデル
   */
  protected ACListModelAdapter getKyoseiServiceDayRadioGroupModel(){
    if(kyoseiServiceDayRadioGroupModel==null){
      kyoseiServiceDayRadioGroupModel = new ACListModelAdapter();
      addKyoseiServiceDayRadioGroupModel();
    }
    return kyoseiServiceDayRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getKyoseiServiceDayRadioItem1(){
    if(kyoseiServiceDayRadioItem1==null){

      kyoseiServiceDayRadioItem1 = new ACRadioButtonItem();

      kyoseiServiceDayRadioItem1.setText("なし");

      kyoseiServiceDayRadioItem1.setGroup(getKyoseiServiceDayRadioGroup());

      kyoseiServiceDayRadioItem1.setConstraints(VRLayout.FLOW);

      addKyoseiServiceDayRadioItem1();
    }
    return kyoseiServiceDayRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getKyoseiServiceDayRadioItem2(){
    if(kyoseiServiceDayRadioItem2==null){

      kyoseiServiceDayRadioItem2 = new ACRadioButtonItem();

      kyoseiServiceDayRadioItem2.setText("あり");

      kyoseiServiceDayRadioItem2.setGroup(getKyoseiServiceDayRadioGroup());

      kyoseiServiceDayRadioItem2.setConstraints(VRLayout.FLOW);

      addKyoseiServiceDayRadioItem2();
    }
    return kyoseiServiceDayRadioItem2;

  }

  /**
   * 生活相談員配置等加算を取得します。
   * @return 生活相談員配置等加算
   */
  public ACValueArrayRadioButtonGroup getSeikatsuSoudanGroup(){
    if(seikatsuSoudanGroup==null){

      seikatsuSoudanGroup = new ACValueArrayRadioButtonGroup();

      getSeikatsuSoudanGroupContainer().setText("生活相談員配置等加算");

      seikatsuSoudanGroup.setBindPath("1780118");

      seikatsuSoudanGroup.setNoSelectIndex(0);

      seikatsuSoudanGroup.setUseClearButton(false);

      seikatsuSoudanGroup.setModel(getSeikatsuSoudanGroupModel());

      seikatsuSoudanGroup.setValues(new int[]{1,2});

      addSeikatsuSoudanGroup();
    }
    return seikatsuSoudanGroup;

  }

  /**
   * 生活相談員配置等加算コンテナを取得します。
   * @return 生活相談員配置等加算コンテナ
   */
  protected ACLabelContainer getSeikatsuSoudanGroupContainer(){
    if(seikatsuSoudanGroupContainer==null){
      seikatsuSoudanGroupContainer = new ACLabelContainer();
      seikatsuSoudanGroupContainer.setFollowChildEnabled(true);
      seikatsuSoudanGroupContainer.setVAlignment(VRLayout.CENTER);
      seikatsuSoudanGroupContainer.add(getSeikatsuSoudanGroup(), null);
    }
    return seikatsuSoudanGroupContainer;
  }

  /**
   * 生活相談員配置等加算モデルを取得します。
   * @return 生活相談員配置等加算モデル
   */
  protected ACListModelAdapter getSeikatsuSoudanGroupModel(){
    if(seikatsuSoudanGroupModel==null){
      seikatsuSoudanGroupModel = new ACListModelAdapter();
      addSeikatsuSoudanGroupModel();
    }
    return seikatsuSoudanGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSeikatsuSoudanGroupItem1(){
    if(seikatsuSoudanGroupItem1==null){

      seikatsuSoudanGroupItem1 = new ACRadioButtonItem();

      seikatsuSoudanGroupItem1.setText("なし");

      seikatsuSoudanGroupItem1.setGroup(getSeikatsuSoudanGroup());

      seikatsuSoudanGroupItem1.setConstraints(VRLayout.FLOW);

      addSeikatsuSoudanGroupItem1();
    }
    return seikatsuSoudanGroupItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getSeikatsuSoudanGroupItem2(){
    if(seikatsuSoudanGroupItem2==null){

      seikatsuSoudanGroupItem2 = new ACRadioButtonItem();

      seikatsuSoudanGroupItem2.setText("あり");

      seikatsuSoudanGroupItem2.setGroup(getSeikatsuSoudanGroup());

      seikatsuSoudanGroupItem2.setConstraints(VRLayout.FLOW);

      addSeikatsuSoudanGroupItem2();
    }
    return seikatsuSoudanGroupItem2;

  }

  /**
   * 入浴介助体制ラジオグループを取得します。
   * @return 入浴介助体制ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getBathingHelpSystem(){
    if(bathingHelpSystem==null){

      bathingHelpSystem = new ACValueArrayRadioButtonGroup();

      getBathingHelpSystemContainer().setText("入浴介助体制");

      bathingHelpSystem.setBindPath("1780104");

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
   * 中重度者ケア体制加算ラジオグループを取得します。
   * @return 中重度者ケア体制加算ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getMediumSeverePersonCare(){
    if(mediumSeverePersonCare==null){

      mediumSeverePersonCare = new ACValueArrayRadioButtonGroup();

      getMediumSeverePersonCareContainer().setText("中重度者ケア体制加算");

      mediumSeverePersonCare.setBindPath("1780105");

      mediumSeverePersonCare.setUseClearButton(false);

      mediumSeverePersonCare.setModel(getMediumSeverePersonCareModel());

      mediumSeverePersonCare.setValues(new int[]{1,2});

      addMediumSeverePersonCare();
    }
    return mediumSeverePersonCare;

  }

  /**
   * 中重度者ケア体制加算ラジオグループコンテナを取得します。
   * @return 中重度者ケア体制加算ラジオグループコンテナ
   */
  protected ACLabelContainer getMediumSeverePersonCareContainer(){
    if(mediumSeverePersonCareContainer==null){
      mediumSeverePersonCareContainer = new ACLabelContainer();
      mediumSeverePersonCareContainer.setFollowChildEnabled(true);
      mediumSeverePersonCareContainer.setVAlignment(VRLayout.CENTER);
      mediumSeverePersonCareContainer.add(getMediumSeverePersonCare(), null);
    }
    return mediumSeverePersonCareContainer;
  }

  /**
   * 中重度者ケア体制加算ラジオグループモデルを取得します。
   * @return 中重度者ケア体制加算ラジオグループモデル
   */
  protected ACListModelAdapter getMediumSeverePersonCareModel(){
    if(mediumSeverePersonCareModel==null){
      mediumSeverePersonCareModel = new ACListModelAdapter();
      addMediumSeverePersonCareModel();
    }
    return mediumSeverePersonCareModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMediumSeverePersonCareItem1(){
    if(mediumSeverePersonCareItem1==null){

      mediumSeverePersonCareItem1 = new ACRadioButtonItem();

      mediumSeverePersonCareItem1.setText("なし");

      mediumSeverePersonCareItem1.setGroup(getMediumSeverePersonCare());

      mediumSeverePersonCareItem1.setConstraints(VRLayout.FLOW);

      addMediumSeverePersonCareItem1();
    }
    return mediumSeverePersonCareItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMediumSeverePersonCareItem2(){
    if(mediumSeverePersonCareItem2==null){

      mediumSeverePersonCareItem2 = new ACRadioButtonItem();

      mediumSeverePersonCareItem2.setText("あり");

      mediumSeverePersonCareItem2.setGroup(getMediumSeverePersonCare());

      mediumSeverePersonCareItem2.setConstraints(VRLayout.FLOW);

      addMediumSeverePersonCareItem2();
    }
    return mediumSeverePersonCareItem2;

  }

  /**
   * 生活機能向上連携加算を取得します。
   * @return 生活機能向上連携加算
   */
  public ACValueArrayRadioButtonGroup getSeikatsuKinouGroup(){
    if(seikatsuKinouGroup==null){

      seikatsuKinouGroup = new ACValueArrayRadioButtonGroup();

      getSeikatsuKinouGroupContainer().setText("生活機能向上連携加算");

      seikatsuKinouGroup.setBindPath("1780119");

      seikatsuKinouGroup.setNoSelectIndex(0);

      seikatsuKinouGroup.setUseClearButton(false);

      seikatsuKinouGroup.setModel(getSeikatsuKinouGroupModel());

      seikatsuKinouGroup.setValues(new int[]{1,2});

      addSeikatsuKinouGroup();
    }
    return seikatsuKinouGroup;

  }

  /**
   * 生活機能向上連携加算コンテナを取得します。
   * @return 生活機能向上連携加算コンテナ
   */
  protected ACLabelContainer getSeikatsuKinouGroupContainer(){
    if(seikatsuKinouGroupContainer==null){
      seikatsuKinouGroupContainer = new ACLabelContainer();
      seikatsuKinouGroupContainer.setFollowChildEnabled(true);
      seikatsuKinouGroupContainer.setVAlignment(VRLayout.CENTER);
      seikatsuKinouGroupContainer.add(getSeikatsuKinouGroup(), null);
    }
    return seikatsuKinouGroupContainer;
  }

  /**
   * 生活機能向上連携加算モデルを取得します。
   * @return 生活機能向上連携加算モデル
   */
  protected ACListModelAdapter getSeikatsuKinouGroupModel(){
    if(seikatsuKinouGroupModel==null){
      seikatsuKinouGroupModel = new ACListModelAdapter();
      addSeikatsuKinouGroupModel();
    }
    return seikatsuKinouGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSeikatsuKinouGroupItem1(){
    if(seikatsuKinouGroupItem1==null){

      seikatsuKinouGroupItem1 = new ACRadioButtonItem();

      seikatsuKinouGroupItem1.setText("なし");

      seikatsuKinouGroupItem1.setGroup(getSeikatsuKinouGroup());

      seikatsuKinouGroupItem1.setConstraints(VRLayout.FLOW);

      addSeikatsuKinouGroupItem1();
    }
    return seikatsuKinouGroupItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getSeikatsuKinouGroupItem2(){
    if(seikatsuKinouGroupItem2==null){

      seikatsuKinouGroupItem2 = new ACRadioButtonItem();

      seikatsuKinouGroupItem2.setText("あり");

      seikatsuKinouGroupItem2.setGroup(getSeikatsuKinouGroup());

      seikatsuKinouGroupItem2.setConstraints(VRLayout.FLOW);

      addSeikatsuKinouGroupItem2();
    }
    return seikatsuKinouGroupItem2;

  }

  /**
   * 個別機能訓練体制Iラジオグループを取得します。
   * @return 個別機能訓練体制Iラジオグループ
   */
  public ACValueArrayRadioButtonGroup getIndividualfunctionTrainingSystem(){
    if(individualfunctionTrainingSystem==null){

      individualfunctionTrainingSystem = new ACValueArrayRadioButtonGroup();

      getIndividualfunctionTrainingSystemContainer().setText("個別機能訓練体制 I");

      individualfunctionTrainingSystem.setBindPath("1780106");

      individualfunctionTrainingSystem.setNoSelectIndex(0);

      individualfunctionTrainingSystem.setUseClearButton(false);

      individualfunctionTrainingSystem.setModel(getIndividualfunctionTrainingSystemModel());

      individualfunctionTrainingSystem.setValues(new int[]{1,2});

      addIndividualfunctionTrainingSystem();
    }
    return individualfunctionTrainingSystem;

  }

  /**
   * 個別機能訓練体制Iラジオグループコンテナを取得します。
   * @return 個別機能訓練体制Iラジオグループコンテナ
   */
  protected ACLabelContainer getIndividualfunctionTrainingSystemContainer(){
    if(individualfunctionTrainingSystemContainer==null){
      individualfunctionTrainingSystemContainer = new ACLabelContainer();
      individualfunctionTrainingSystemContainer.setFollowChildEnabled(true);
      individualfunctionTrainingSystemContainer.setVAlignment(VRLayout.CENTER);
      individualfunctionTrainingSystemContainer.add(getIndividualfunctionTrainingSystem(), null);
    }
    return individualfunctionTrainingSystemContainer;
  }

  /**
   * 個別機能訓練体制Iラジオグループモデルを取得します。
   * @return 個別機能訓練体制Iラジオグループモデル
   */
  protected ACListModelAdapter getIndividualfunctionTrainingSystemModel(){
    if(individualfunctionTrainingSystemModel==null){
      individualfunctionTrainingSystemModel = new ACListModelAdapter();
      addIndividualfunctionTrainingSystemModel();
    }
    return individualfunctionTrainingSystemModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getIndividualfunctionTrainingSystemItem1(){
    if(individualfunctionTrainingSystemItem1==null){

      individualfunctionTrainingSystemItem1 = new ACRadioButtonItem();

      individualfunctionTrainingSystemItem1.setText("なし");

      individualfunctionTrainingSystemItem1.setGroup(getIndividualfunctionTrainingSystem());

      individualfunctionTrainingSystemItem1.setConstraints(VRLayout.FLOW);

      addIndividualfunctionTrainingSystemItem1();
    }
    return individualfunctionTrainingSystemItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getIndividualfunctionTrainingSystemItem2(){
    if(individualfunctionTrainingSystemItem2==null){

      individualfunctionTrainingSystemItem2 = new ACRadioButtonItem();

      individualfunctionTrainingSystemItem2.setText("あり");

      individualfunctionTrainingSystemItem2.setGroup(getIndividualfunctionTrainingSystem());

      individualfunctionTrainingSystemItem2.setConstraints(VRLayout.FLOW);

      addIndividualfunctionTrainingSystemItem2();
    }
    return individualfunctionTrainingSystemItem2;

  }

  /**
   * 個別機能訓練体制IIラジオグループを取得します。
   * @return 個別機能訓練体制IIラジオグループ
   */
  public ACValueArrayRadioButtonGroup getIndividualfunctionTrainingSystem2(){
    if(individualfunctionTrainingSystem2==null){

      individualfunctionTrainingSystem2 = new ACValueArrayRadioButtonGroup();

      getIndividualfunctionTrainingSystem2Container().setText("個別機能訓練体制 II");

      individualfunctionTrainingSystem2.setBindPath("1780120");

      individualfunctionTrainingSystem2.setNoSelectIndex(0);

      individualfunctionTrainingSystem2.setUseClearButton(false);

      individualfunctionTrainingSystem2.setModel(getIndividualfunctionTrainingSystem2Model());

      individualfunctionTrainingSystem2.setValues(new int[]{1,2});

      addIndividualfunctionTrainingSystem2();
    }
    return individualfunctionTrainingSystem2;

  }

  /**
   * 個別機能訓練体制IIラジオグループコンテナを取得します。
   * @return 個別機能訓練体制IIラジオグループコンテナ
   */
  protected ACLabelContainer getIndividualfunctionTrainingSystem2Container(){
    if(individualfunctionTrainingSystem2Container==null){
      individualfunctionTrainingSystem2Container = new ACLabelContainer();
      individualfunctionTrainingSystem2Container.setFollowChildEnabled(true);
      individualfunctionTrainingSystem2Container.setVAlignment(VRLayout.CENTER);
      individualfunctionTrainingSystem2Container.add(getIndividualfunctionTrainingSystem2(), null);
    }
    return individualfunctionTrainingSystem2Container;
  }

  /**
   * 個別機能訓練体制IIラジオグループモデルを取得します。
   * @return 個別機能訓練体制IIラジオグループモデル
   */
  protected ACListModelAdapter getIndividualfunctionTrainingSystem2Model(){
    if(individualfunctionTrainingSystem2Model==null){
      individualfunctionTrainingSystem2Model = new ACListModelAdapter();
      addIndividualfunctionTrainingSystem2Model();
    }
    return individualfunctionTrainingSystem2Model;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getIndividualfunctionTrainingSystem2Item1(){
    if(individualfunctionTrainingSystem2Item1==null){

      individualfunctionTrainingSystem2Item1 = new ACRadioButtonItem();

      individualfunctionTrainingSystem2Item1.setText("なし");

      individualfunctionTrainingSystem2Item1.setGroup(getIndividualfunctionTrainingSystem2());

      individualfunctionTrainingSystem2Item1.setConstraints(VRLayout.FLOW);

      addIndividualfunctionTrainingSystem2Item1();
    }
    return individualfunctionTrainingSystem2Item1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getIndividualfunctionTrainingSystem2Item2(){
    if(individualfunctionTrainingSystem2Item2==null){

      individualfunctionTrainingSystem2Item2 = new ACRadioButtonItem();

      individualfunctionTrainingSystem2Item2.setText("あり");

      individualfunctionTrainingSystem2Item2.setGroup(getIndividualfunctionTrainingSystem2());

      individualfunctionTrainingSystem2Item2.setConstraints(VRLayout.FLOW);

      addIndividualfunctionTrainingSystem2Item2();
    }
    return individualfunctionTrainingSystem2Item2;

  }

  /**
   * ADL維持等加算〔申出〕の有無を取得します。
   * @return ADL維持等加算〔申出〕の有無
   */
  public ACValueArrayRadioButtonGroup getAdlIjiGroup(){
    if(adlIjiGroup==null){

      adlIjiGroup = new ACValueArrayRadioButtonGroup();

      getAdlIjiGroupContainer().setText("ADL維持等加算〔申出〕の有無");

      adlIjiGroup.setBindPath("1780121");

      adlIjiGroup.setNoSelectIndex(0);

      adlIjiGroup.setUseClearButton(false);

      adlIjiGroup.setModel(getAdlIjiGroupModel());

      adlIjiGroup.setValues(new int[]{1,2});

      addAdlIjiGroup();
    }
    return adlIjiGroup;

  }

  /**
   * ADL維持等加算〔申出〕の有無コンテナを取得します。
   * @return ADL維持等加算〔申出〕の有無コンテナ
   */
  protected ACLabelContainer getAdlIjiGroupContainer(){
    if(adlIjiGroupContainer==null){
      adlIjiGroupContainer = new ACLabelContainer();
      adlIjiGroupContainer.setFollowChildEnabled(true);
      adlIjiGroupContainer.setVAlignment(VRLayout.CENTER);
      adlIjiGroupContainer.add(getAdlIjiGroup(), null);
    }
    return adlIjiGroupContainer;
  }

  /**
   * ADL維持等加算〔申出〕の有無モデルを取得します。
   * @return ADL維持等加算〔申出〕の有無モデル
   */
  protected ACListModelAdapter getAdlIjiGroupModel(){
    if(adlIjiGroupModel==null){
      adlIjiGroupModel = new ACListModelAdapter();
      addAdlIjiGroupModel();
    }
    return adlIjiGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getAdlIjiGroupItem1(){
    if(adlIjiGroupItem1==null){

      adlIjiGroupItem1 = new ACRadioButtonItem();

      adlIjiGroupItem1.setText("なし");

      adlIjiGroupItem1.setGroup(getAdlIjiGroup());

      adlIjiGroupItem1.setConstraints(VRLayout.FLOW);

      addAdlIjiGroupItem1();
    }
    return adlIjiGroupItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getAdlIjiGroupItem2(){
    if(adlIjiGroupItem2==null){

      adlIjiGroupItem2 = new ACRadioButtonItem();

      adlIjiGroupItem2.setText("あり");

      adlIjiGroupItem2.setGroup(getAdlIjiGroup());

      adlIjiGroupItem2.setConstraints(VRLayout.FLOW);

      addAdlIjiGroupItem2();
    }
    return adlIjiGroupItem2;

  }

  /**
   * ADL維持等加算を取得します。
   * @return ADL維持等加算
   */
  public ACValueArrayRadioButtonGroup getAdlIjiGroup2(){
    if(adlIjiGroup2==null){

      adlIjiGroup2 = new ACValueArrayRadioButtonGroup();

      getAdlIjiGroup2Container().setText("ADL維持等加算");

      adlIjiGroup2.setBindPath("1780122");

      adlIjiGroup2.setNoSelectIndex(0);

      adlIjiGroup2.setUseClearButton(false);

      adlIjiGroup2.setModel(getAdlIjiGroup2Model());

      adlIjiGroup2.setValues(new int[]{1,2});

      addAdlIjiGroup2();
    }
    return adlIjiGroup2;

  }

  /**
   * ADL維持等加算コンテナを取得します。
   * @return ADL維持等加算コンテナ
   */
  protected ACLabelContainer getAdlIjiGroup2Container(){
    if(adlIjiGroup2Container==null){
      adlIjiGroup2Container = new ACLabelContainer();
      adlIjiGroup2Container.setFollowChildEnabled(true);
      adlIjiGroup2Container.setVAlignment(VRLayout.CENTER);
      adlIjiGroup2Container.add(getAdlIjiGroup2(), null);
    }
    return adlIjiGroup2Container;
  }

  /**
   * ADL維持等加算モデルを取得します。
   * @return ADL維持等加算モデル
   */
  protected ACListModelAdapter getAdlIjiGroup2Model(){
    if(adlIjiGroup2Model==null){
      adlIjiGroup2Model = new ACListModelAdapter();
      addAdlIjiGroup2Model();
    }
    return adlIjiGroup2Model;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getAdlIjiGroup2Item1(){
    if(adlIjiGroup2Item1==null){

      adlIjiGroup2Item1 = new ACRadioButtonItem();

      adlIjiGroup2Item1.setText("なし");

      adlIjiGroup2Item1.setGroup(getAdlIjiGroup2());

      adlIjiGroup2Item1.setConstraints(VRLayout.FLOW);

      addAdlIjiGroup2Item1();
    }
    return adlIjiGroup2Item1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getAdlIjiGroup2Item2(){
    if(adlIjiGroup2Item2==null){

      adlIjiGroup2Item2 = new ACRadioButtonItem();

      adlIjiGroup2Item2.setText("あり");

      adlIjiGroup2Item2.setGroup(getAdlIjiGroup2());

      adlIjiGroup2Item2.setConstraints(VRLayout.FLOW);

      addAdlIjiGroup2Item2();
    }
    return adlIjiGroup2Item2;

  }

  /**
   * パネル2を取得します。
   * @return パネル2
   */
  public ACPanel getPanel2(){
    if(panel2==null){

      panel2 = new ACPanel();

      panel2.setFollowChildEnabled(true);

      addPanel2();
    }
    return panel2;

  }

  /**
   * 算定項目領域2を取得します。
   * @return 算定項目領域2
   */
  public ACPanel getCalculationDetails2(){
    if(calculationDetails2==null){

      calculationDetails2 = new ACPanel();

      calculationDetails2.setFollowChildEnabled(true);

      calculationDetails2.setHgrid(200);

      addCalculationDetails2();
    }
    return calculationDetails2;

  }

  /**
   * 認知症加算ラジオグループを取得します。
   * @return 認知症加算ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getDementiaAdd(){
    if(dementiaAdd==null){

      dementiaAdd = new ACValueArrayRadioButtonGroup();

      getDementiaAddContainer().setText("認知症加算");

      dementiaAdd.setBindPath("1780107");

      dementiaAdd.setUseClearButton(false);

      dementiaAdd.setModel(getDementiaAddModel());

      dementiaAdd.setValues(new int[]{1,2});

      addDementiaAdd();
    }
    return dementiaAdd;

  }

  /**
   * 認知症加算ラジオグループコンテナを取得します。
   * @return 認知症加算ラジオグループコンテナ
   */
  protected ACLabelContainer getDementiaAddContainer(){
    if(dementiaAddContainer==null){
      dementiaAddContainer = new ACLabelContainer();
      dementiaAddContainer.setFollowChildEnabled(true);
      dementiaAddContainer.setVAlignment(VRLayout.CENTER);
      dementiaAddContainer.add(getDementiaAdd(), null);
    }
    return dementiaAddContainer;
  }

  /**
   * 認知症加算ラジオグループモデルを取得します。
   * @return 認知症加算ラジオグループモデル
   */
  protected ACListModelAdapter getDementiaAddModel(){
    if(dementiaAddModel==null){
      dementiaAddModel = new ACListModelAdapter();
      addDementiaAddModel();
    }
    return dementiaAddModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getDementiaAddItem1(){
    if(dementiaAddItem1==null){

      dementiaAddItem1 = new ACRadioButtonItem();

      dementiaAddItem1.setText("なし");

      dementiaAddItem1.setGroup(getDementiaAdd());

      dementiaAddItem1.setConstraints(VRLayout.FLOW);

      addDementiaAddItem1();
    }
    return dementiaAddItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getDementiaAddItem2(){
    if(dementiaAddItem2==null){

      dementiaAddItem2 = new ACRadioButtonItem();

      dementiaAddItem2.setText("あり");

      dementiaAddItem2.setGroup(getDementiaAdd());

      dementiaAddItem2.setConstraints(VRLayout.FLOW);

      addDementiaAddItem2();
    }
    return dementiaAddItem2;

  }

  /**
   * 若年性認知症利用者受入加算を取得します。
   * @return 若年性認知症利用者受入加算
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("若年性認知症利用者受入加算");

      youngDementiaPatinetAddRadioGroup.setBindPath("1780108");

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

      nourishmentImprovement.setBindPath("1780109");

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

      mouthImprovementAdd.setBindPath("1780110");

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
   * 個別送迎体制強化加算を取得します。
   * @return 個別送迎体制強化加算
   */
  public ACValueArrayRadioButtonGroup getIndividualPickupSystem(){
    if(individualPickupSystem==null){

      individualPickupSystem = new ACValueArrayRadioButtonGroup();

      getIndividualPickupSystemContainer().setText("個別送迎体制強化加算");

      individualPickupSystem.setBindPath("1780111");

      individualPickupSystem.setUseClearButton(false);

      individualPickupSystem.setModel(getIndividualPickupSystemModel());

      individualPickupSystem.setValues(new int[]{1,2});

      addIndividualPickupSystem();
    }
    return individualPickupSystem;

  }

  /**
   * 個別送迎体制強化加算コンテナを取得します。
   * @return 個別送迎体制強化加算コンテナ
   */
  protected ACLabelContainer getIndividualPickupSystemContainer(){
    if(individualPickupSystemContainer==null){
      individualPickupSystemContainer = new ACLabelContainer();
      individualPickupSystemContainer.setFollowChildEnabled(true);
      individualPickupSystemContainer.setVAlignment(VRLayout.CENTER);
      individualPickupSystemContainer.add(getIndividualPickupSystem(), null);
    }
    return individualPickupSystemContainer;
  }

  /**
   * 個別送迎体制強化加算モデルを取得します。
   * @return 個別送迎体制強化加算モデル
   */
  protected ACListModelAdapter getIndividualPickupSystemModel(){
    if(individualPickupSystemModel==null){
      individualPickupSystemModel = new ACListModelAdapter();
      addIndividualPickupSystemModel();
    }
    return individualPickupSystemModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getIndividualPickupSystemItem1(){
    if(individualPickupSystemItem1==null){

      individualPickupSystemItem1 = new ACRadioButtonItem();

      individualPickupSystemItem1.setText("なし");

      individualPickupSystemItem1.setGroup(getIndividualPickupSystem());

      addIndividualPickupSystemItem1();
    }
    return individualPickupSystemItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getIndividualPickupSystemItem2(){
    if(individualPickupSystemItem2==null){

      individualPickupSystemItem2 = new ACRadioButtonItem();

      individualPickupSystemItem2.setText("あり");

      individualPickupSystemItem2.setGroup(getIndividualPickupSystem());

      addIndividualPickupSystemItem2();
    }
    return individualPickupSystemItem2;

  }

  /**
   * 入浴介助体制強化加算を取得します。
   * @return 入浴介助体制強化加算
   */
  public ACValueArrayRadioButtonGroup getBathingAssistanceSystem(){
    if(bathingAssistanceSystem==null){

      bathingAssistanceSystem = new ACValueArrayRadioButtonGroup();

      getBathingAssistanceSystemContainer().setText("入浴介助体制強化加算");

      bathingAssistanceSystem.setBindPath("1780112");

      bathingAssistanceSystem.setUseClearButton(false);

      bathingAssistanceSystem.setModel(getBathingAssistanceSystemModel());

      bathingAssistanceSystem.setValues(new int[]{1,2});

      addBathingAssistanceSystem();
    }
    return bathingAssistanceSystem;

  }

  /**
   * 入浴介助体制強化加算コンテナを取得します。
   * @return 入浴介助体制強化加算コンテナ
   */
  protected ACLabelContainer getBathingAssistanceSystemContainer(){
    if(bathingAssistanceSystemContainer==null){
      bathingAssistanceSystemContainer = new ACLabelContainer();
      bathingAssistanceSystemContainer.setFollowChildEnabled(true);
      bathingAssistanceSystemContainer.setVAlignment(VRLayout.CENTER);
      bathingAssistanceSystemContainer.add(getBathingAssistanceSystem(), null);
    }
    return bathingAssistanceSystemContainer;
  }

  /**
   * 入浴介助体制強化加算モデルを取得します。
   * @return 入浴介助体制強化加算モデル
   */
  protected ACListModelAdapter getBathingAssistanceSystemModel(){
    if(bathingAssistanceSystemModel==null){
      bathingAssistanceSystemModel = new ACListModelAdapter();
      addBathingAssistanceSystemModel();
    }
    return bathingAssistanceSystemModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getBathingAssistanceSystemItem1(){
    if(bathingAssistanceSystemItem1==null){

      bathingAssistanceSystemItem1 = new ACRadioButtonItem();

      bathingAssistanceSystemItem1.setText("なし");

      bathingAssistanceSystemItem1.setGroup(getBathingAssistanceSystem());

      bathingAssistanceSystemItem1.setConstraints(VRLayout.FLOW);

      addBathingAssistanceSystemItem1();
    }
    return bathingAssistanceSystemItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getBathingAssistanceSystemItem2(){
    if(bathingAssistanceSystemItem2==null){

      bathingAssistanceSystemItem2 = new ACRadioButtonItem();

      bathingAssistanceSystemItem2.setText("あり");

      bathingAssistanceSystemItem2.setGroup(getBathingAssistanceSystem());

      bathingAssistanceSystemItem2.setConstraints(VRLayout.FLOW);

      addBathingAssistanceSystemItem2();
    }
    return bathingAssistanceSystemItem2;

  }

  /**
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1780113");

      serviceAddProvisionStructuralRadioGroup.setVisible(true);

      serviceAddProvisionStructuralRadioGroup.setEnabled(true);

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,2,3,4,5});

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

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

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
   * 加算IIIを取得します。
   * @return 加算III
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem5(){
    if(serviceAddProvisionStructuralRadioItem5==null){

      serviceAddProvisionStructuralRadioItem5 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem5.setText("加算III");

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
   * 事業所サブパネルを取得します。
   * @return 事業所サブパネル
   */
  public ACPanel getProviderSubPanel(){
    if(providerSubPanel==null){

      providerSubPanel = new ACPanel();

      providerSubPanel.setFollowChildEnabled(true);

      providerSubPanel.setHgap(0);

      providerSubPanel.setLabelMargin(0);

      providerSubPanel.setVgap(0);

      addProviderSubPanel();
    }
    return providerSubPanel;

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
  public QO004_17811_201804Design() {

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

    mainGroup.add(getTab(), VRLayout.CLIENT);

  }

  /**
   * タブに内部項目を追加します。
   */
  protected void addTab(){

    tab.addTab("1", getPanel1());

    tab.addTab("2", getPanel2());

  }

  /**
   * パネル１に内部項目を追加します。
   */
  protected void addPanel1(){

    panel1.add(getProviderMainPanel(), VRLayout.NORTH);

  }

  /**
   * 事業所メインパネルに内部項目を追加します。
   */
  protected void addProviderMainPanel(){

    providerMainPanel.add(getFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getExtendTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getKyoseiServiceSeikatsuRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getKyoseiServiceJiritsuRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getKyoseiServiceJidoRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getKyoseiServiceDayRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getSeikatsuSoudanGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getBathingHelpSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getMediumSeverePersonCareContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getSeikatsuKinouGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getIndividualfunctionTrainingSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getIndividualfunctionTrainingSystem2Container(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getAdlIjiGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getAdlIjiGroup2Container(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 施設区分コンテナに内部項目を追加します。
   */
  protected void addFacilitiesDivisionContainer(){

    facilitiesDivisionContainer.add(getFacilitiesDivision(), VRLayout.FLOW_RETURN);

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
   * 地域密着型通所介護に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem1(){

  }

  /**
   * 療養通所介護に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem2(){

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
   * 共生型サービスの提供（生活介護事業所）に内部項目を追加します。
   */
  protected void addKyoseiServiceSeikatsuRadioGroup(){

  }

  /**
   * 共生型サービスの提供（生活介護事業所）モデルに内部項目を追加します。
   */
  protected void addKyoseiServiceSeikatsuRadioGroupModel(){

    getKyoseiServiceSeikatsuRadioItem1().setButtonIndex(1);

    getKyoseiServiceSeikatsuRadioGroupModel().add(getKyoseiServiceSeikatsuRadioItem1());

    getKyoseiServiceSeikatsuRadioItem2().setButtonIndex(2);

    getKyoseiServiceSeikatsuRadioGroupModel().add(getKyoseiServiceSeikatsuRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKyoseiServiceSeikatsuRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKyoseiServiceSeikatsuRadioItem2(){

  }

  /**
   * 共生型サービスの提供（自立訓練事業所）に内部項目を追加します。
   */
  protected void addKyoseiServiceJiritsuRadioGroup(){

  }

  /**
   * 共生型サービスの提供（自立訓練事業所）モデルに内部項目を追加します。
   */
  protected void addKyoseiServiceJiritsuRadioGroupModel(){

    getKyoseiServiceJiritsuRadioItem1().setButtonIndex(1);

    getKyoseiServiceJiritsuRadioGroupModel().add(getKyoseiServiceJiritsuRadioItem1());

    getKyoseiServiceJiritsuRadioItem2().setButtonIndex(2);

    getKyoseiServiceJiritsuRadioGroupModel().add(getKyoseiServiceJiritsuRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKyoseiServiceJiritsuRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKyoseiServiceJiritsuRadioItem2(){

  }

  /**
   * 共生型サービスの提供（児童発達支援事業所）に内部項目を追加します。
   */
  protected void addKyoseiServiceJidoRadioGroup(){

  }

  /**
   * 共生型サービスの提供（児童発達支援事業所）モデルに内部項目を追加します。
   */
  protected void addKyoseiServiceJidoRadioGroupModel(){

    getKyoseiServiceJidoRadioItem1().setButtonIndex(1);

    getKyoseiServiceJidoRadioGroupModel().add(getKyoseiServiceJidoRadioItem1());

    getKyoseiServiceJidoRadioItem2().setButtonIndex(2);

    getKyoseiServiceJidoRadioGroupModel().add(getKyoseiServiceJidoRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKyoseiServiceJidoRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKyoseiServiceJidoRadioItem2(){

  }

  /**
   * 共生型サービスの提供（放課後等デイサービス事業所）に内部項目を追加します。
   */
  protected void addKyoseiServiceDayRadioGroup(){

  }

  /**
   * 共生型サービスの提供（放課後等デイサービス事業所）モデルに内部項目を追加します。
   */
  protected void addKyoseiServiceDayRadioGroupModel(){

    getKyoseiServiceDayRadioItem1().setButtonIndex(1);

    getKyoseiServiceDayRadioGroupModel().add(getKyoseiServiceDayRadioItem1());

    getKyoseiServiceDayRadioItem2().setButtonIndex(2);

    getKyoseiServiceDayRadioGroupModel().add(getKyoseiServiceDayRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addKyoseiServiceDayRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addKyoseiServiceDayRadioItem2(){

  }

  /**
   * 生活相談員配置等加算に内部項目を追加します。
   */
  protected void addSeikatsuSoudanGroup(){

  }

  /**
   * 生活相談員配置等加算モデルに内部項目を追加します。
   */
  protected void addSeikatsuSoudanGroupModel(){

    getSeikatsuSoudanGroupItem1().setButtonIndex(1);

    getSeikatsuSoudanGroupModel().add(getSeikatsuSoudanGroupItem1());

    getSeikatsuSoudanGroupItem2().setButtonIndex(2);

    getSeikatsuSoudanGroupModel().add(getSeikatsuSoudanGroupItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSeikatsuSoudanGroupItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addSeikatsuSoudanGroupItem2(){

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
   * 中重度者ケア体制加算ラジオグループに内部項目を追加します。
   */
  protected void addMediumSeverePersonCare(){

  }

  /**
   * 中重度者ケア体制加算ラジオグループモデルに内部項目を追加します。
   */
  protected void addMediumSeverePersonCareModel(){

    getMediumSeverePersonCareItem1().setButtonIndex(1);

    getMediumSeverePersonCareModel().add(getMediumSeverePersonCareItem1());

    getMediumSeverePersonCareItem2().setButtonIndex(2);

    getMediumSeverePersonCareModel().add(getMediumSeverePersonCareItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMediumSeverePersonCareItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMediumSeverePersonCareItem2(){

  }

  /**
   * 生活機能向上連携加算に内部項目を追加します。
   */
  protected void addSeikatsuKinouGroup(){

  }

  /**
   * 生活機能向上連携加算モデルに内部項目を追加します。
   */
  protected void addSeikatsuKinouGroupModel(){

    getSeikatsuKinouGroupItem1().setButtonIndex(1);

    getSeikatsuKinouGroupModel().add(getSeikatsuKinouGroupItem1());

    getSeikatsuKinouGroupItem2().setButtonIndex(2);

    getSeikatsuKinouGroupModel().add(getSeikatsuKinouGroupItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSeikatsuKinouGroupItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addSeikatsuKinouGroupItem2(){

  }

  /**
   * 個別機能訓練体制Iラジオグループに内部項目を追加します。
   */
  protected void addIndividualfunctionTrainingSystem(){

  }

  /**
   * 個別機能訓練体制Iラジオグループモデルに内部項目を追加します。
   */
  protected void addIndividualfunctionTrainingSystemModel(){

    getIndividualfunctionTrainingSystemItem1().setButtonIndex(1);

    getIndividualfunctionTrainingSystemModel().add(getIndividualfunctionTrainingSystemItem1());

    getIndividualfunctionTrainingSystemItem2().setButtonIndex(2);

    getIndividualfunctionTrainingSystemModel().add(getIndividualfunctionTrainingSystemItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addIndividualfunctionTrainingSystemItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addIndividualfunctionTrainingSystemItem2(){

  }

  /**
   * 個別機能訓練体制IIラジオグループに内部項目を追加します。
   */
  protected void addIndividualfunctionTrainingSystem2(){

  }

  /**
   * 個別機能訓練体制IIラジオグループモデルに内部項目を追加します。
   */
  protected void addIndividualfunctionTrainingSystem2Model(){

    getIndividualfunctionTrainingSystem2Item1().setButtonIndex(1);

    getIndividualfunctionTrainingSystem2Model().add(getIndividualfunctionTrainingSystem2Item1());

    getIndividualfunctionTrainingSystem2Item2().setButtonIndex(2);

    getIndividualfunctionTrainingSystem2Model().add(getIndividualfunctionTrainingSystem2Item2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addIndividualfunctionTrainingSystem2Item1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addIndividualfunctionTrainingSystem2Item2(){

  }

  /**
   * ADL維持等加算〔申出〕の有無に内部項目を追加します。
   */
  protected void addAdlIjiGroup(){

  }

  /**
   * ADL維持等加算〔申出〕の有無モデルに内部項目を追加します。
   */
  protected void addAdlIjiGroupModel(){

    getAdlIjiGroupItem1().setButtonIndex(1);

    getAdlIjiGroupModel().add(getAdlIjiGroupItem1());

    getAdlIjiGroupItem2().setButtonIndex(2);

    getAdlIjiGroupModel().add(getAdlIjiGroupItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addAdlIjiGroupItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addAdlIjiGroupItem2(){

  }

  /**
   * ADL維持等加算に内部項目を追加します。
   */
  protected void addAdlIjiGroup2(){

  }

  /**
   * ADL維持等加算モデルに内部項目を追加します。
   */
  protected void addAdlIjiGroup2Model(){

    getAdlIjiGroup2Item1().setButtonIndex(1);

    getAdlIjiGroup2Model().add(getAdlIjiGroup2Item1());

    getAdlIjiGroup2Item2().setButtonIndex(2);

    getAdlIjiGroup2Model().add(getAdlIjiGroup2Item2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addAdlIjiGroup2Item1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addAdlIjiGroup2Item2(){

  }

  /**
   * パネル2に内部項目を追加します。
   */
  protected void addPanel2(){

    panel2.add(getCalculationDetails2(), VRLayout.NORTH);

    panel2.add(getProviderSubPanel(), VRLayout.NORTH);

  }

  /**
   * 算定項目領域2に内部項目を追加します。
   */
  protected void addCalculationDetails2(){

    calculationDetails2.add(getDementiaAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getNourishmentImprovementContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getMouthImprovementAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getIndividualPickupSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getBathingAssistanceSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getStaffUpgradeRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 認知症加算ラジオグループに内部項目を追加します。
   */
  protected void addDementiaAdd(){

  }

  /**
   * 認知症加算ラジオグループモデルに内部項目を追加します。
   */
  protected void addDementiaAddModel(){

    getDementiaAddItem1().setButtonIndex(1);

    getDementiaAddModel().add(getDementiaAddItem1());

    getDementiaAddItem2().setButtonIndex(2);

    getDementiaAddModel().add(getDementiaAddItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addDementiaAddItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addDementiaAddItem2(){

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
   * 個別送迎体制強化加算に内部項目を追加します。
   */
  protected void addIndividualPickupSystem(){

  }

  /**
   * 個別送迎体制強化加算モデルに内部項目を追加します。
   */
  protected void addIndividualPickupSystemModel(){

    getIndividualPickupSystemItem1().setButtonIndex(1);

    getIndividualPickupSystemModel().add(getIndividualPickupSystemItem1());

    getIndividualPickupSystemItem2().setButtonIndex(2);

    getIndividualPickupSystemModel().add(getIndividualPickupSystemItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addIndividualPickupSystemItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addIndividualPickupSystemItem2(){

  }

  /**
   * 入浴介助体制強化加算に内部項目を追加します。
   */
  protected void addBathingAssistanceSystem(){

  }

  /**
   * 入浴介助体制強化加算モデルに内部項目を追加します。
   */
  protected void addBathingAssistanceSystemModel(){

    getBathingAssistanceSystemItem1().setButtonIndex(1);

    getBathingAssistanceSystemModel().add(getBathingAssistanceSystemItem1());

    getBathingAssistanceSystemItem2().setButtonIndex(2);

    getBathingAssistanceSystemModel().add(getBathingAssistanceSystemItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addBathingAssistanceSystemItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addBathingAssistanceSystemItem2(){

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

    getServiceAddProvisionStructuralRadioItem4().setButtonIndex(4);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem4());

    getServiceAddProvisionStructuralRadioItem5().setButtonIndex(5);

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
   * 加算IIに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem4(){

  }

  /**
   * 加算IIIに内部項目を追加します。
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
   * 事業所サブパネルに内部項目を追加します。
   */
  protected void addProviderSubPanel(){

    providerSubPanel.add(getReduceRateContainer(), VRLayout.FLOW_INSETLINE);

    providerSubPanel.add(getShahukuReduce(), VRLayout.FLOW_RETURN);

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
      ACFrame.debugStart(new ACAffairInfo(QO004_17811_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004_17811_201804Design getThis() {
    return this;
  }
}
