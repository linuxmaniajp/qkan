
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
 * プログラム 通所リハ (QO004_11611_201804)
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
 * 通所リハ画面項目デザイン(QO004_11611_201804) 
 */
public class QO004_11611_201804Design extends QO004ProviderPanel {
  //GUIコンポーネント

  private ACGroupBox mainGroup;

  private JTabbedPane tab;

  private ACPanel panel1;

  private ACPanel calculationDetails;

  private ACValueArrayRadioButtonGroup facilitiesDivisionAfterH2104RadioGroup;

  private ACLabelContainer facilitiesDivisionAfterH2104RadioGroupContainer;

  private ACListModelAdapter facilitiesDivisionAfterH2104RadioGroupModel;

  private ACRadioButtonItem facilitiesDivisionAfterH2104RadioItem1;

  private ACRadioButtonItem facilitiesDivisionAfterH2104RadioItem4;

  private ACRadioButtonItem facilitiesDivisionAfterH2104RadioItem7;

  private ACRadioButtonItem facilitiesDivisionAfterH2104RadioItem2;

  private ACRadioButtonItem facilitiesDivisionAfterH2104RadioItem5;

  private ACRadioButtonItem facilitiesDivisionAfterH2104RadioItem8;

  private ACRadioButtonItem facilitiesDivisionAfterH2104RadioItem3;

  private ACRadioButtonItem facilitiesDivisionAfterH2104RadioItem6;

  private ACRadioButtonItem facilitiesDivisionAfterH2104RadioItem9;

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

  private ACValueArrayRadioButtonGroup rehabilitationSystem;

  private ACLabelContainer rehabilitationSystemContainer;

  private ACListModelAdapter rehabilitationSystemModel;

  private ACRadioButtonItem rehabilitationSystemItem1;

  private ACRadioButtonItem rehabilitationSystemItem2;

  private ACValueArrayRadioButtonGroup bathingHelpSystem;

  private ACLabelContainer bathingHelpSystemContainer;

  private ACListModelAdapter bathingHelpSystemModel;

  private ACRadioButtonItem bathingHelpSystemItem1;

  private ACRadioButtonItem bathingHelpSystemItem2;

  private ACValueArrayRadioButtonGroup rehabilitationManagementRadioGroup;

  private ACLabelContainer rehabilitationManagementRadioGroupContainer;

  private ACListModelAdapter rehabilitationManagementRadioGroupModel;

  private ACRadioButtonItem rehabilitationManagementRadioItem1;

  private ACRadioButtonItem rehabilitationManagementRadioItem2;

  private ACRadioButtonItem rehabilitationManagementRadioItem3;

  private ACRadioButtonItem rehabilitationManagementRadioItem4;

  private ACRadioButtonItem rehabilitationManagementRadioItem5;

  private ACPanel panel2;

  private ACPanel calculationDetails2;

  private ACValueArrayRadioButtonGroup intensiveRehabilitationRadioGroup;

  private ACLabelContainer intensiveRehabilitationRadioGroupContainer;

  private ACListModelAdapter intensiveRehabilitationRadioGroupModel;

  private ACRadioButtonItem intensiveRehabilitationRadioItem1;

  private ACRadioButtonItem intensiveRehabilitationRadioItem2;

  private ACValueArrayRadioButtonGroup dementiaRihaAddRadioGroup;

  private ACLabelContainer dementiaRihaAddRadioGroupContainer;

  private ACListModelAdapter dementiaRihaAddRadioGroupModel;

  private ACRadioButtonItem dementiaRihaAddRadioItem1;

  private ACRadioButtonItem dementiaRihaAddRadioItem2;

  private ACRadioButtonItem dementiaRihaAddRadioItem3;

  private ACValueArrayRadioButtonGroup lifeActsImproveRehabilitationRadioGroup;

  private ACLabelContainer lifeActsImproveRehabilitationRadioGroupContainer;

  private ACListModelAdapter lifeActsImproveRehabilitationRadioGroupModel;

  private ACRadioButtonItem lifeActsImproveRehabilitationRadioItem1;

  private ACRadioButtonItem lifeActsImproveRehabilitationRadioItem2;

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

  private ACValueArrayRadioButtonGroup mediumSeverePersonCare;

  private ACLabelContainer mediumSeverePersonCareContainer;

  private ACListModelAdapter mediumSeverePersonCareModel;

  private ACRadioButtonItem mediumSeverePersonCareItem1;

  private ACRadioButtonItem mediumSeverePersonCareItem2;

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

      facilitiesDivisionAfterH2104RadioGroup.setValues(new int[]{1,2,7,3,4,8,5,6,9});

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

      facilitiesDivisionAfterH2104RadioItem1.setText("通常規模の事業所  (病院・診療所)");

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

      facilitiesDivisionAfterH2104RadioItem4.setText("通常規模の事業所  (介護老人保健施設)");

      facilitiesDivisionAfterH2104RadioItem4.setGroup(getFacilitiesDivisionAfterH2104RadioGroup());

      facilitiesDivisionAfterH2104RadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionAfterH2104RadioItem4();
    }
    return facilitiesDivisionAfterH2104RadioItem4;

  }

  /**
   * 通常規模の事業所(介護医療院)を取得します。
   * @return 通常規模の事業所(介護医療院)
   */
  public ACRadioButtonItem getFacilitiesDivisionAfterH2104RadioItem7(){
    if(facilitiesDivisionAfterH2104RadioItem7==null){

      facilitiesDivisionAfterH2104RadioItem7 = new ACRadioButtonItem();

      facilitiesDivisionAfterH2104RadioItem7.setText("通常規模の事業所  (介護医療院)");

      facilitiesDivisionAfterH2104RadioItem7.setGroup(getFacilitiesDivisionAfterH2104RadioGroup());

      facilitiesDivisionAfterH2104RadioItem7.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionAfterH2104RadioItem7();
    }
    return facilitiesDivisionAfterH2104RadioItem7;

  }

  /**
   * 大規模事業所(I)(病院・診療所)を取得します。
   * @return 大規模事業所(I)(病院・診療所)
   */
  public ACRadioButtonItem getFacilitiesDivisionAfterH2104RadioItem2(){
    if(facilitiesDivisionAfterH2104RadioItem2==null){

      facilitiesDivisionAfterH2104RadioItem2 = new ACRadioButtonItem();

      facilitiesDivisionAfterH2104RadioItem2.setText("大規模事業所（I） (病院・診療所)");

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

      facilitiesDivisionAfterH2104RadioItem5.setText("大規模事業所（I） (介護老人保健施設)");

      facilitiesDivisionAfterH2104RadioItem5.setGroup(getFacilitiesDivisionAfterH2104RadioGroup());

      facilitiesDivisionAfterH2104RadioItem5.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionAfterH2104RadioItem5();
    }
    return facilitiesDivisionAfterH2104RadioItem5;

  }

  /**
   * 大規模事業所(I)(介護医療院)を取得します。
   * @return 大規模事業所(I)(介護医療院)
   */
  public ACRadioButtonItem getFacilitiesDivisionAfterH2104RadioItem8(){
    if(facilitiesDivisionAfterH2104RadioItem8==null){

      facilitiesDivisionAfterH2104RadioItem8 = new ACRadioButtonItem();

      facilitiesDivisionAfterH2104RadioItem8.setText("大規模事業所（I） (介護医療院)");

      facilitiesDivisionAfterH2104RadioItem8.setGroup(getFacilitiesDivisionAfterH2104RadioGroup());

      facilitiesDivisionAfterH2104RadioItem8.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionAfterH2104RadioItem8();
    }
    return facilitiesDivisionAfterH2104RadioItem8;

  }

  /**
   * 大規模事業所(II)(病院・診療所)を取得します。
   * @return 大規模事業所(II)(病院・診療所)
   */
  public ACRadioButtonItem getFacilitiesDivisionAfterH2104RadioItem3(){
    if(facilitiesDivisionAfterH2104RadioItem3==null){

      facilitiesDivisionAfterH2104RadioItem3 = new ACRadioButtonItem();

      facilitiesDivisionAfterH2104RadioItem3.setText("大規模事業所（II）(病院・診療所)");

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

      facilitiesDivisionAfterH2104RadioItem6.setText("大規模事業所（II）(介護老人保健施設)");

      facilitiesDivisionAfterH2104RadioItem6.setGroup(getFacilitiesDivisionAfterH2104RadioGroup());

      facilitiesDivisionAfterH2104RadioItem6.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionAfterH2104RadioItem6();
    }
    return facilitiesDivisionAfterH2104RadioItem6;

  }

  /**
   * 大規模事業所(II)(介護医療院)を取得します。
   * @return 大規模事業所(II)(介護医療院)
   */
  public ACRadioButtonItem getFacilitiesDivisionAfterH2104RadioItem9(){
    if(facilitiesDivisionAfterH2104RadioItem9==null){

      facilitiesDivisionAfterH2104RadioItem9 = new ACRadioButtonItem();

      facilitiesDivisionAfterH2104RadioItem9.setText("大規模事業所（II）(介護医療院)");

      facilitiesDivisionAfterH2104RadioItem9.setGroup(getFacilitiesDivisionAfterH2104RadioGroup());

      facilitiesDivisionAfterH2104RadioItem9.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionAfterH2104RadioItem9();
    }
    return facilitiesDivisionAfterH2104RadioItem9;

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
   * リハビリテーション提供体制加算を取得します。
   * @return リハビリテーション提供体制加算
   */
  public ACValueArrayRadioButtonGroup getRehabilitationSystem(){
    if(rehabilitationSystem==null){

      rehabilitationSystem = new ACValueArrayRadioButtonGroup();

      getRehabilitationSystemContainer().setText("リハビリテーション提供体制加算");

      rehabilitationSystem.setBindPath("1160126");

      rehabilitationSystem.setUseClearButton(false);

      rehabilitationSystem.setModel(getRehabilitationSystemModel());

      rehabilitationSystem.setValues(new int[]{1,2});

      addRehabilitationSystem();
    }
    return rehabilitationSystem;

  }

  /**
   * リハビリテーション提供体制加算コンテナを取得します。
   * @return リハビリテーション提供体制加算コンテナ
   */
  protected ACLabelContainer getRehabilitationSystemContainer(){
    if(rehabilitationSystemContainer==null){
      rehabilitationSystemContainer = new ACLabelContainer();
      rehabilitationSystemContainer.setFollowChildEnabled(true);
      rehabilitationSystemContainer.setVAlignment(VRLayout.CENTER);
      rehabilitationSystemContainer.add(getRehabilitationSystem(), null);
    }
    return rehabilitationSystemContainer;
  }

  /**
   * リハビリテーション提供体制加算モデルを取得します。
   * @return リハビリテーション提供体制加算モデル
   */
  protected ACListModelAdapter getRehabilitationSystemModel(){
    if(rehabilitationSystemModel==null){
      rehabilitationSystemModel = new ACListModelAdapter();
      addRehabilitationSystemModel();
    }
    return rehabilitationSystemModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getRehabilitationSystemItem1(){
    if(rehabilitationSystemItem1==null){

      rehabilitationSystemItem1 = new ACRadioButtonItem();

      rehabilitationSystemItem1.setText("なし");

      rehabilitationSystemItem1.setGroup(getRehabilitationSystem());

      rehabilitationSystemItem1.setConstraints(VRLayout.FLOW);

      addRehabilitationSystemItem1();
    }
    return rehabilitationSystemItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getRehabilitationSystemItem2(){
    if(rehabilitationSystemItem2==null){

      rehabilitationSystemItem2 = new ACRadioButtonItem();

      rehabilitationSystemItem2.setText("あり");

      rehabilitationSystemItem2.setGroup(getRehabilitationSystem());

      rehabilitationSystemItem2.setConstraints(VRLayout.FLOW);

      addRehabilitationSystemItem2();
    }
    return rehabilitationSystemItem2;

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
   * リハビリテーションマネジメント加算を取得します。
   * @return リハビリテーションマネジメント加算
   */
  public ACValueArrayRadioButtonGroup getRehabilitationManagementRadioGroup(){
    if(rehabilitationManagementRadioGroup==null){

      rehabilitationManagementRadioGroup = new ACValueArrayRadioButtonGroup();

      getRehabilitationManagementRadioGroupContainer().setText("リハビリテーションマネジメント加算");

      rehabilitationManagementRadioGroup.setBindPath("1160119");

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
   * 短期集中個別リハビリテーション実施加算を取得します。
   * @return 短期集中個別リハビリテーション実施加算
   */
  public ACValueArrayRadioButtonGroup getIntensiveRehabilitationRadioGroup(){
    if(intensiveRehabilitationRadioGroup==null){

      intensiveRehabilitationRadioGroup = new ACValueArrayRadioButtonGroup();

      getIntensiveRehabilitationRadioGroupContainer().setText("短期集中個別リハビリテーション実施加算");

      intensiveRehabilitationRadioGroup.setBindPath("1160120");

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
   * 短期集中個別リハビリテーション実施加算コンテナを取得します。
   * @return 短期集中個別リハビリテーション実施加算コンテナ
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
   * 短期集中個別リハビリテーション実施加算モデルを取得します。
   * @return 短期集中個別リハビリテーション実施加算モデル
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
   * 認知症短期集中リハビリテーション実施加算を取得します。
   * @return 認知症短期集中リハビリテーション実施加算
   */
  public ACValueArrayRadioButtonGroup getDementiaRihaAddRadioGroup(){
    if(dementiaRihaAddRadioGroup==null){

      dementiaRihaAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaRihaAddRadioGroupContainer().setText("認知症短期集中リハビリテーション実施加算");

      dementiaRihaAddRadioGroup.setBindPath("1160113");

      dementiaRihaAddRadioGroup.setNoSelectIndex(0);

      dementiaRihaAddRadioGroup.setUseClearButton(false);

      dementiaRihaAddRadioGroup.setModel(getDementiaRihaAddRadioGroupModel());

      dementiaRihaAddRadioGroup.setValues(new int[]{1,2,3});

      addDementiaRihaAddRadioGroup();
    }
    return dementiaRihaAddRadioGroup;

  }

  /**
   * 認知症短期集中リハビリテーション実施加算コンテナを取得します。
   * @return 認知症短期集中リハビリテーション実施加算コンテナ
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
   * 認知症短期集中リハビリテーション実施加算モデルを取得します。
   * @return 認知症短期集中リハビリテーション実施加算モデル
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
   * 加算Iを取得します。
   * @return 加算I
   */
  public ACRadioButtonItem getDementiaRihaAddRadioItem2(){
    if(dementiaRihaAddRadioItem2==null){

      dementiaRihaAddRadioItem2 = new ACRadioButtonItem();

      dementiaRihaAddRadioItem2.setText("加算I");

      dementiaRihaAddRadioItem2.setGroup(getDementiaRihaAddRadioGroup());

      dementiaRihaAddRadioItem2.setConstraints(VRLayout.FLOW);

      addDementiaRihaAddRadioItem2();
    }
    return dementiaRihaAddRadioItem2;

  }

  /**
   * 加算IIを取得します。
   * @return 加算II
   */
  public ACRadioButtonItem getDementiaRihaAddRadioItem3(){
    if(dementiaRihaAddRadioItem3==null){

      dementiaRihaAddRadioItem3 = new ACRadioButtonItem();

      dementiaRihaAddRadioItem3.setText("加算II");

      dementiaRihaAddRadioItem3.setGroup(getDementiaRihaAddRadioGroup());

      dementiaRihaAddRadioItem3.setConstraints(VRLayout.FLOW);

      addDementiaRihaAddRadioItem3();
    }
    return dementiaRihaAddRadioItem3;

  }

  /**
   * 生活行為向上リハビリテーション実施加算を取得します。
   * @return 生活行為向上リハビリテーション実施加算
   */
  public ACValueArrayRadioButtonGroup getLifeActsImproveRehabilitationRadioGroup(){
    if(lifeActsImproveRehabilitationRadioGroup==null){

      lifeActsImproveRehabilitationRadioGroup = new ACValueArrayRadioButtonGroup();

      getLifeActsImproveRehabilitationRadioGroupContainer().setText("生活行為向上リハビリテーション実施加算");

      lifeActsImproveRehabilitationRadioGroup.setBindPath("1160121");

      lifeActsImproveRehabilitationRadioGroup.setVisible(true);

      lifeActsImproveRehabilitationRadioGroup.setEnabled(true);

      lifeActsImproveRehabilitationRadioGroup.setNoSelectIndex(0);

      lifeActsImproveRehabilitationRadioGroup.setUseClearButton(false);

      lifeActsImproveRehabilitationRadioGroup.setModel(getLifeActsImproveRehabilitationRadioGroupModel());

      lifeActsImproveRehabilitationRadioGroup.setValues(new int[]{1,2});

      addLifeActsImproveRehabilitationRadioGroup();
    }
    return lifeActsImproveRehabilitationRadioGroup;

  }

  /**
   * 生活行為向上リハビリテーション実施加算コンテナを取得します。
   * @return 生活行為向上リハビリテーション実施加算コンテナ
   */
  protected ACLabelContainer getLifeActsImproveRehabilitationRadioGroupContainer(){
    if(lifeActsImproveRehabilitationRadioGroupContainer==null){
      lifeActsImproveRehabilitationRadioGroupContainer = new ACLabelContainer();
      lifeActsImproveRehabilitationRadioGroupContainer.setFollowChildEnabled(true);
      lifeActsImproveRehabilitationRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      lifeActsImproveRehabilitationRadioGroupContainer.add(getLifeActsImproveRehabilitationRadioGroup(), null);
    }
    return lifeActsImproveRehabilitationRadioGroupContainer;
  }

  /**
   * 生活行為向上リハビリテーション実施加算モデルを取得します。
   * @return 生活行為向上リハビリテーション実施加算モデル
   */
  protected ACListModelAdapter getLifeActsImproveRehabilitationRadioGroupModel(){
    if(lifeActsImproveRehabilitationRadioGroupModel==null){
      lifeActsImproveRehabilitationRadioGroupModel = new ACListModelAdapter();
      addLifeActsImproveRehabilitationRadioGroupModel();
    }
    return lifeActsImproveRehabilitationRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getLifeActsImproveRehabilitationRadioItem1(){
    if(lifeActsImproveRehabilitationRadioItem1==null){

      lifeActsImproveRehabilitationRadioItem1 = new ACRadioButtonItem();

      lifeActsImproveRehabilitationRadioItem1.setText("なし");

      lifeActsImproveRehabilitationRadioItem1.setGroup(getLifeActsImproveRehabilitationRadioGroup());

      lifeActsImproveRehabilitationRadioItem1.setConstraints(VRLayout.FLOW);

      addLifeActsImproveRehabilitationRadioItem1();
    }
    return lifeActsImproveRehabilitationRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getLifeActsImproveRehabilitationRadioItem2(){
    if(lifeActsImproveRehabilitationRadioItem2==null){

      lifeActsImproveRehabilitationRadioItem2 = new ACRadioButtonItem();

      lifeActsImproveRehabilitationRadioItem2.setText("あり");

      lifeActsImproveRehabilitationRadioItem2.setGroup(getLifeActsImproveRehabilitationRadioGroup());

      lifeActsImproveRehabilitationRadioItem2.setConstraints(VRLayout.FLOW);

      addLifeActsImproveRehabilitationRadioItem2();
    }
    return lifeActsImproveRehabilitationRadioItem2;

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
   * 中重度者ケア体制加算を取得します。
   * @return 中重度者ケア体制加算
   */
  public ACValueArrayRadioButtonGroup getMediumSeverePersonCare(){
    if(mediumSeverePersonCare==null){

      mediumSeverePersonCare = new ACValueArrayRadioButtonGroup();

      getMediumSeverePersonCareContainer().setText("中重度者ケア体制加算");

      mediumSeverePersonCare.setBindPath("1160124");

      mediumSeverePersonCare.setUseClearButton(false);

      mediumSeverePersonCare.setModel(getMediumSeverePersonCareModel());

      mediumSeverePersonCare.setValues(new int[]{1,2});

      addMediumSeverePersonCare();
    }
    return mediumSeverePersonCare;

  }

  /**
   * 中重度者ケア体制加算コンテナを取得します。
   * @return 中重度者ケア体制加算コンテナ
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
   * 中重度者ケア体制加算モデルを取得します。
   * @return 中重度者ケア体制加算モデル
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
   * 社会参加支援加算を取得します。
   * @return 社会参加支援加算
   */
  public ACValueArrayRadioButtonGroup getSocialSupportRadioGroup(){
    if(socialSupportRadioGroup==null){

      socialSupportRadioGroup = new ACValueArrayRadioButtonGroup();

      getSocialSupportRadioGroupContainer().setText("社会参加支援加算");

      socialSupportRadioGroup.setBindPath("1160125");

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

      serviceAddProvisionStructuralRadioGroup.setBindPath("1160115");

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
   * コンストラクタです。
   */
  public QO004_11611_201804Design() {

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

    panel1.add(getCalculationDetails(), VRLayout.NORTH);

  }

  /**
   * 算定項目領域に内部項目を追加します。
   */
  protected void addCalculationDetails(){

    calculationDetails.add(getFacilitiesDivisionAfterH2104RadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getExtendTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getRehabilitationSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getBathingHelpSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getRehabilitationManagementRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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

    getFacilitiesDivisionAfterH2104RadioItem7().setButtonIndex(7);

    getFacilitiesDivisionAfterH2104RadioGroupModel().add(getFacilitiesDivisionAfterH2104RadioItem7());

    getFacilitiesDivisionAfterH2104RadioItem2().setButtonIndex(3);

    getFacilitiesDivisionAfterH2104RadioGroupModel().add(getFacilitiesDivisionAfterH2104RadioItem2());

    getFacilitiesDivisionAfterH2104RadioItem5().setButtonIndex(4);

    getFacilitiesDivisionAfterH2104RadioGroupModel().add(getFacilitiesDivisionAfterH2104RadioItem5());

    getFacilitiesDivisionAfterH2104RadioItem8().setButtonIndex(8);

    getFacilitiesDivisionAfterH2104RadioGroupModel().add(getFacilitiesDivisionAfterH2104RadioItem8());

    getFacilitiesDivisionAfterH2104RadioItem3().setButtonIndex(5);

    getFacilitiesDivisionAfterH2104RadioGroupModel().add(getFacilitiesDivisionAfterH2104RadioItem3());

    getFacilitiesDivisionAfterH2104RadioItem6().setButtonIndex(6);

    getFacilitiesDivisionAfterH2104RadioGroupModel().add(getFacilitiesDivisionAfterH2104RadioItem6());

    getFacilitiesDivisionAfterH2104RadioItem9().setButtonIndex(9);

    getFacilitiesDivisionAfterH2104RadioGroupModel().add(getFacilitiesDivisionAfterH2104RadioItem9());

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
   * 通常規模の事業所(介護医療院)に内部項目を追加します。
   */
  protected void addFacilitiesDivisionAfterH2104RadioItem7(){

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
   * 大規模事業所(I)(介護医療院)に内部項目を追加します。
   */
  protected void addFacilitiesDivisionAfterH2104RadioItem8(){

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
   * 大規模事業所(II)(介護医療院)に内部項目を追加します。
   */
  protected void addFacilitiesDivisionAfterH2104RadioItem9(){

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
   * リハビリテーション提供体制加算に内部項目を追加します。
   */
  protected void addRehabilitationSystem(){

  }

  /**
   * リハビリテーション提供体制加算モデルに内部項目を追加します。
   */
  protected void addRehabilitationSystemModel(){

    getRehabilitationSystemItem1().setButtonIndex(1);

    getRehabilitationSystemModel().add(getRehabilitationSystemItem1());

    getRehabilitationSystemItem2().setButtonIndex(2);

    getRehabilitationSystemModel().add(getRehabilitationSystemItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addRehabilitationSystemItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addRehabilitationSystemItem2(){

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
   * パネル2に内部項目を追加します。
   */
  protected void addPanel2(){

    panel2.add(getCalculationDetails2(), VRLayout.NORTH);

  }

  /**
   * 算定項目領域2に内部項目を追加します。
   */
  protected void addCalculationDetails2(){

    calculationDetails2.add(getIntensiveRehabilitationRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getDementiaRihaAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getLifeActsImproveRehabilitationRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getNourishmentImprovementContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getMouthImprovementAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getMediumSeverePersonCareContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getSocialSupportRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getStaffUpgradeRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 短期集中個別リハビリテーション実施加算に内部項目を追加します。
   */
  protected void addIntensiveRehabilitationRadioGroup(){

  }

  /**
   * 短期集中個別リハビリテーション実施加算モデルに内部項目を追加します。
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
   * 認知症短期集中リハビリテーション実施加算に内部項目を追加します。
   */
  protected void addDementiaRihaAddRadioGroup(){

  }

  /**
   * 認知症短期集中リハビリテーション実施加算モデルに内部項目を追加します。
   */
  protected void addDementiaRihaAddRadioGroupModel(){

    getDementiaRihaAddRadioItem1().setButtonIndex(1);

    getDementiaRihaAddRadioGroupModel().add(getDementiaRihaAddRadioItem1());

    getDementiaRihaAddRadioItem2().setButtonIndex(2);

    getDementiaRihaAddRadioGroupModel().add(getDementiaRihaAddRadioItem2());

    getDementiaRihaAddRadioItem3().setButtonIndex(3);

    getDementiaRihaAddRadioGroupModel().add(getDementiaRihaAddRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addDementiaRihaAddRadioItem1(){

  }

  /**
   * 加算Iに内部項目を追加します。
   */
  protected void addDementiaRihaAddRadioItem2(){

  }

  /**
   * 加算IIに内部項目を追加します。
   */
  protected void addDementiaRihaAddRadioItem3(){

  }

  /**
   * 生活行為向上リハビリテーション実施加算に内部項目を追加します。
   */
  protected void addLifeActsImproveRehabilitationRadioGroup(){

  }

  /**
   * 生活行為向上リハビリテーション実施加算モデルに内部項目を追加します。
   */
  protected void addLifeActsImproveRehabilitationRadioGroupModel(){

    getLifeActsImproveRehabilitationRadioItem1().setButtonIndex(1);

    getLifeActsImproveRehabilitationRadioGroupModel().add(getLifeActsImproveRehabilitationRadioItem1());

    getLifeActsImproveRehabilitationRadioItem2().setButtonIndex(2);

    getLifeActsImproveRehabilitationRadioGroupModel().add(getLifeActsImproveRehabilitationRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addLifeActsImproveRehabilitationRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addLifeActsImproveRehabilitationRadioItem2(){

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
   * 中重度者ケア体制加算に内部項目を追加します。
   */
  protected void addMediumSeverePersonCare(){

  }

  /**
   * 中重度者ケア体制加算モデルに内部項目を追加します。
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
      ACFrame.debugStart(new ACAffairInfo(QO004_11611_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004_11611_201804Design getThis() {
    return this;
  }
}
