
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
 * 作成日: 2017/02/24  日本コンピューター株式会社 松本　幸一 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業者登録 (004)
 * プログラム 小規模多機能型居宅介護(短期利用以外) (QO004_17311_201504)
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
 * 小規模多機能型居宅介護(短期利用以外)画面項目デザイン(QO004_17311_201504) 
 */
public class QO004_17311_201504Design extends QO004ProviderPanel {
  //GUIコンポーネント

  private ACGroupBox mainGroup;

  private ACValueArrayRadioButtonGroup facilityDivisionRadioGroup;

  private ACLabelContainer facilityDivisionRadioGroupContainer;

  private ACListModelAdapter facilityDivisionRadioGroupModel;

  private ACRadioButtonItem facilityDivisionRadioItem1;

  private ACRadioButtonItem facilityDivisionRadioItem2;

  private ACValueArrayRadioButtonGroup staffLack;

  private ACLabelContainer staffLackContainer;

  private ACListModelAdapter staffLackModel;

  private ACRadioButtonItem staffLackItem1;

  private ACRadioButtonItem staffLackItem2;

  private ACRadioButtonItem staffLackItem3;

  private ACValueArrayRadioButtonGroup nurseStaffDispositionAddRadioGroup;

  private ACLabelContainer nurseStaffDispositionAddRadioGroupContainer;

  private ACListModelAdapter nurseStaffDispositionAddRadioGroupModel;

  private ACRadioButtonItem nurseStaffDispositionAddRadioItem1;

  private ACRadioButtonItem nurseStaffDispositionAddRadioItem2;

  private ACRadioButtonItem nurseStaffDispositionAddRadioItem3;

  private ACRadioButtonItem nurseStaffDispositionAddRadioItem4;

  private ACValueArrayRadioButtonGroup terminalCareInformationRadioGroup;

  private ACLabelContainer terminalCareInformationRadioGroupContainer;

  private ACListModelAdapter terminalCareInformationRadioGroupModel;

  private ACRadioButtonItem terminalCareInformationRadioItem1;

  private ACRadioButtonItem terminalCareInformationRadioItem2;

  private ACValueArrayRadioButtonGroup visitStrengthenAddRadioGroup;

  private ACLabelContainer visitStrengthenAddRadioGroupContainer;

  private ACListModelAdapter visitStrengthenAddRadioGroupModel;

  private ACRadioButtonItem visitStrengthenAddRadioItem1;

  private ACRadioButtonItem visitStrengthenAddRadioItem2;

  private ACValueArrayRadioButtonGroup comprehensiveManagementSystemRadioGroup;

  private ACLabelContainer comprehensiveManagementSystemRadioGroupContainer;

  private ACListModelAdapter comprehensiveManagementSystemRadioGroupModel;

  private ACRadioButtonItem comprehensiveManagementSystemRadioItem1;

  private ACRadioButtonItem comprehensiveManagementSystemRadioItem2;

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

  private ACRadioButtonItem baseMunicipalityAddItem8;

  private ACRadioButtonItem baseMunicipalityAddItem9;

  private ACRadioButtonItem baseMunicipalityAddItem10;

  private ACRadioButtonItem baseMunicipalityAddItem11;

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

      mainGroup.setText("小規模多機能型居宅介護（短期利用以外）");

      mainGroup.setAutoWrap(false);

      mainGroup.setFollowChildEnabled(true);

      mainGroup.setHgrid(200);

      addMainGroup();
    }
    return mainGroup;

  }

  /**
   * 施設等の区分を取得します。
   * @return 施設等の区分
   */
  public ACValueArrayRadioButtonGroup getFacilityDivisionRadioGroup(){
    if(facilityDivisionRadioGroup==null){

      facilityDivisionRadioGroup = new ACValueArrayRadioButtonGroup();

      getFacilityDivisionRadioGroupContainer().setText("施設等の区分");

      facilityDivisionRadioGroup.setBindPath("1730105");

      facilityDivisionRadioGroup.setUseClearButton(false);

      facilityDivisionRadioGroup.setModel(getFacilityDivisionRadioGroupModel());

      facilityDivisionRadioGroup.setValues(new int[]{1,2});

      addFacilityDivisionRadioGroup();
    }
    return facilityDivisionRadioGroup;

  }

  /**
   * 施設等の区分コンテナを取得します。
   * @return 施設等の区分コンテナ
   */
  protected ACLabelContainer getFacilityDivisionRadioGroupContainer(){
    if(facilityDivisionRadioGroupContainer==null){
      facilityDivisionRadioGroupContainer = new ACLabelContainer();
      facilityDivisionRadioGroupContainer.setFollowChildEnabled(true);
      facilityDivisionRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      facilityDivisionRadioGroupContainer.add(getFacilityDivisionRadioGroup(), null);
    }
    return facilityDivisionRadioGroupContainer;
  }

  /**
   * 施設等の区分モデルを取得します。
   * @return 施設等の区分モデル
   */
  protected ACListModelAdapter getFacilityDivisionRadioGroupModel(){
    if(facilityDivisionRadioGroupModel==null){
      facilityDivisionRadioGroupModel = new ACListModelAdapter();
      addFacilityDivisionRadioGroupModel();
    }
    return facilityDivisionRadioGroupModel;
  }

  /**
   * 小規模多機能型居宅介護事業所を取得します。
   * @return 小規模多機能型居宅介護事業所
   */
  public ACRadioButtonItem getFacilityDivisionRadioItem1(){
    if(facilityDivisionRadioItem1==null){

      facilityDivisionRadioItem1 = new ACRadioButtonItem();

      facilityDivisionRadioItem1.setText("小規模多機能型居宅介護事業所");

      facilityDivisionRadioItem1.setGroup(getFacilityDivisionRadioGroup());

      facilityDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addFacilityDivisionRadioItem1();
    }
    return facilityDivisionRadioItem1;

  }

  /**
   * サテライト型小規模多機能型居宅介護事業所を取得します。
   * @return サテライト型小規模多機能型居宅介護事業所
   */
  public ACRadioButtonItem getFacilityDivisionRadioItem2(){
    if(facilityDivisionRadioItem2==null){

      facilityDivisionRadioItem2 = new ACRadioButtonItem();

      facilityDivisionRadioItem2.setText("サテライト型小規模多機能型居宅介護事業所");

      facilityDivisionRadioItem2.setGroup(getFacilityDivisionRadioGroup());

      facilityDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addFacilityDivisionRadioItem2();
    }
    return facilityDivisionRadioItem2;

  }

  /**
   * 職員の欠員による減算の状況を取得します。
   * @return 職員の欠員による減算の状況
   */
  public ACValueArrayRadioButtonGroup getStaffLack(){
    if(staffLack==null){

      staffLack = new ACValueArrayRadioButtonGroup();

      getStaffLackContainer().setText("職員の欠員による減算の状況");

      staffLack.setBindPath("1730101");

      staffLack.setUseClearButton(false);

      staffLack.setModel(getStaffLackModel());

      staffLack.setValues(new int[]{1,2,3});

      addStaffLack();
    }
    return staffLack;

  }

  /**
   * 職員の欠員による減算の状況コンテナを取得します。
   * @return 職員の欠員による減算の状況コンテナ
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
   * 職員の欠員による減算の状況モデルを取得します。
   * @return 職員の欠員による減算の状況モデル
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
   * 看護職員配置加算を取得します。
   * @return 看護職員配置加算
   */
  public ACValueArrayRadioButtonGroup getNurseStaffDispositionAddRadioGroup(){
    if(nurseStaffDispositionAddRadioGroup==null){

      nurseStaffDispositionAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getNurseStaffDispositionAddRadioGroupContainer().setText("看護職員配置加算");

      nurseStaffDispositionAddRadioGroup.setBindPath("1730102");

      nurseStaffDispositionAddRadioGroup.setNoSelectIndex(0);

      nurseStaffDispositionAddRadioGroup.setUseClearButton(false);

      nurseStaffDispositionAddRadioGroup.setModel(getNurseStaffDispositionAddRadioGroupModel());

      nurseStaffDispositionAddRadioGroup.setValues(new int[]{1,2,3,4});

      addNurseStaffDispositionAddRadioGroup();
    }
    return nurseStaffDispositionAddRadioGroup;

  }

  /**
   * 看護職員配置加算コンテナを取得します。
   * @return 看護職員配置加算コンテナ
   */
  protected ACLabelContainer getNurseStaffDispositionAddRadioGroupContainer(){
    if(nurseStaffDispositionAddRadioGroupContainer==null){
      nurseStaffDispositionAddRadioGroupContainer = new ACLabelContainer();
      nurseStaffDispositionAddRadioGroupContainer.setFollowChildEnabled(true);
      nurseStaffDispositionAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      nurseStaffDispositionAddRadioGroupContainer.add(getNurseStaffDispositionAddRadioGroup(), null);
    }
    return nurseStaffDispositionAddRadioGroupContainer;
  }

  /**
   * 看護職員配置加算モデルを取得します。
   * @return 看護職員配置加算モデル
   */
  protected ACListModelAdapter getNurseStaffDispositionAddRadioGroupModel(){
    if(nurseStaffDispositionAddRadioGroupModel==null){
      nurseStaffDispositionAddRadioGroupModel = new ACListModelAdapter();
      addNurseStaffDispositionAddRadioGroupModel();
    }
    return nurseStaffDispositionAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNurseStaffDispositionAddRadioItem1(){
    if(nurseStaffDispositionAddRadioItem1==null){

      nurseStaffDispositionAddRadioItem1 = new ACRadioButtonItem();

      nurseStaffDispositionAddRadioItem1.setText("なし");

      nurseStaffDispositionAddRadioItem1.setGroup(getNurseStaffDispositionAddRadioGroup());

      nurseStaffDispositionAddRadioItem1.setConstraints(VRLayout.FLOW);

      addNurseStaffDispositionAddRadioItem1();
    }
    return nurseStaffDispositionAddRadioItem1;

  }

  /**
   * 加算Iを取得します。
   * @return 加算I
   */
  public ACRadioButtonItem getNurseStaffDispositionAddRadioItem2(){
    if(nurseStaffDispositionAddRadioItem2==null){

      nurseStaffDispositionAddRadioItem2 = new ACRadioButtonItem();

      nurseStaffDispositionAddRadioItem2.setText("加算I");

      nurseStaffDispositionAddRadioItem2.setGroup(getNurseStaffDispositionAddRadioGroup());

      nurseStaffDispositionAddRadioItem2.setConstraints(VRLayout.FLOW);

      addNurseStaffDispositionAddRadioItem2();
    }
    return nurseStaffDispositionAddRadioItem2;

  }

  /**
   * 加算IIを取得します。
   * @return 加算II
   */
  public ACRadioButtonItem getNurseStaffDispositionAddRadioItem3(){
    if(nurseStaffDispositionAddRadioItem3==null){

      nurseStaffDispositionAddRadioItem3 = new ACRadioButtonItem();

      nurseStaffDispositionAddRadioItem3.setText("加算II");

      nurseStaffDispositionAddRadioItem3.setGroup(getNurseStaffDispositionAddRadioGroup());

      nurseStaffDispositionAddRadioItem3.setConstraints(VRLayout.FLOW);

      addNurseStaffDispositionAddRadioItem3();
    }
    return nurseStaffDispositionAddRadioItem3;

  }

  /**
   * 加算IIIを取得します。
   * @return 加算III
   */
  public ACRadioButtonItem getNurseStaffDispositionAddRadioItem4(){
    if(nurseStaffDispositionAddRadioItem4==null){

      nurseStaffDispositionAddRadioItem4 = new ACRadioButtonItem();

      nurseStaffDispositionAddRadioItem4.setText("加算III");

      nurseStaffDispositionAddRadioItem4.setGroup(getNurseStaffDispositionAddRadioGroup());

      nurseStaffDispositionAddRadioItem4.setConstraints(VRLayout.FLOW);

      addNurseStaffDispositionAddRadioItem4();
    }
    return nurseStaffDispositionAddRadioItem4;

  }

  /**
   * 看取り連携体制加算を取得します。
   * @return 看取り連携体制加算
   */
  public ACValueArrayRadioButtonGroup getTerminalCareInformationRadioGroup(){
    if(terminalCareInformationRadioGroup==null){

      terminalCareInformationRadioGroup = new ACValueArrayRadioButtonGroup();

      getTerminalCareInformationRadioGroupContainer().setText("看取り連携体制加算");

      terminalCareInformationRadioGroup.setBindPath("1730106");

      terminalCareInformationRadioGroup.setVisible(true);

      terminalCareInformationRadioGroup.setEnabled(true);

      terminalCareInformationRadioGroup.setNoSelectIndex(0);

      terminalCareInformationRadioGroup.setUseClearButton(false);

      terminalCareInformationRadioGroup.setModel(getTerminalCareInformationRadioGroupModel());

      terminalCareInformationRadioGroup.setValues(new int[]{1,2});

      addTerminalCareInformationRadioGroup();
    }
    return terminalCareInformationRadioGroup;

  }

  /**
   * 看取り連携体制加算コンテナを取得します。
   * @return 看取り連携体制加算コンテナ
   */
  protected ACLabelContainer getTerminalCareInformationRadioGroupContainer(){
    if(terminalCareInformationRadioGroupContainer==null){
      terminalCareInformationRadioGroupContainer = new ACLabelContainer();
      terminalCareInformationRadioGroupContainer.setFollowChildEnabled(true);
      terminalCareInformationRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      terminalCareInformationRadioGroupContainer.add(getTerminalCareInformationRadioGroup(), null);
    }
    return terminalCareInformationRadioGroupContainer;
  }

  /**
   * 看取り連携体制加算モデルを取得します。
   * @return 看取り連携体制加算モデル
   */
  protected ACListModelAdapter getTerminalCareInformationRadioGroupModel(){
    if(terminalCareInformationRadioGroupModel==null){
      terminalCareInformationRadioGroupModel = new ACListModelAdapter();
      addTerminalCareInformationRadioGroupModel();
    }
    return terminalCareInformationRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTerminalCareInformationRadioItem1(){
    if(terminalCareInformationRadioItem1==null){

      terminalCareInformationRadioItem1 = new ACRadioButtonItem();

      terminalCareInformationRadioItem1.setText("なし");

      terminalCareInformationRadioItem1.setGroup(getTerminalCareInformationRadioGroup());

      terminalCareInformationRadioItem1.setConstraints(VRLayout.FLOW);

      addTerminalCareInformationRadioItem1();
    }
    return terminalCareInformationRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getTerminalCareInformationRadioItem2(){
    if(terminalCareInformationRadioItem2==null){

      terminalCareInformationRadioItem2 = new ACRadioButtonItem();

      terminalCareInformationRadioItem2.setText("あり");

      terminalCareInformationRadioItem2.setGroup(getTerminalCareInformationRadioGroup());

      terminalCareInformationRadioItem2.setConstraints(VRLayout.FLOW);

      addTerminalCareInformationRadioItem2();
    }
    return terminalCareInformationRadioItem2;

  }

  /**
   * 訪問体制強化加算を取得します。
   * @return 訪問体制強化加算
   */
  public ACValueArrayRadioButtonGroup getVisitStrengthenAddRadioGroup(){
    if(visitStrengthenAddRadioGroup==null){

      visitStrengthenAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getVisitStrengthenAddRadioGroupContainer().setText("訪問体制強化加算");

      visitStrengthenAddRadioGroup.setBindPath("1730107");

      visitStrengthenAddRadioGroup.setVisible(true);

      visitStrengthenAddRadioGroup.setEnabled(true);

      visitStrengthenAddRadioGroup.setNoSelectIndex(0);

      visitStrengthenAddRadioGroup.setUseClearButton(false);

      visitStrengthenAddRadioGroup.setModel(getVisitStrengthenAddRadioGroupModel());

      visitStrengthenAddRadioGroup.setValues(new int[]{1,2});

      addVisitStrengthenAddRadioGroup();
    }
    return visitStrengthenAddRadioGroup;

  }

  /**
   * 訪問体制強化加算コンテナを取得します。
   * @return 訪問体制強化加算コンテナ
   */
  protected ACLabelContainer getVisitStrengthenAddRadioGroupContainer(){
    if(visitStrengthenAddRadioGroupContainer==null){
      visitStrengthenAddRadioGroupContainer = new ACLabelContainer();
      visitStrengthenAddRadioGroupContainer.setFollowChildEnabled(true);
      visitStrengthenAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      visitStrengthenAddRadioGroupContainer.add(getVisitStrengthenAddRadioGroup(), null);
    }
    return visitStrengthenAddRadioGroupContainer;
  }

  /**
   * 訪問体制強化加算モデルを取得します。
   * @return 訪問体制強化加算モデル
   */
  protected ACListModelAdapter getVisitStrengthenAddRadioGroupModel(){
    if(visitStrengthenAddRadioGroupModel==null){
      visitStrengthenAddRadioGroupModel = new ACListModelAdapter();
      addVisitStrengthenAddRadioGroupModel();
    }
    return visitStrengthenAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getVisitStrengthenAddRadioItem1(){
    if(visitStrengthenAddRadioItem1==null){

      visitStrengthenAddRadioItem1 = new ACRadioButtonItem();

      visitStrengthenAddRadioItem1.setText("なし");

      visitStrengthenAddRadioItem1.setGroup(getVisitStrengthenAddRadioGroup());

      visitStrengthenAddRadioItem1.setConstraints(VRLayout.FLOW);

      addVisitStrengthenAddRadioItem1();
    }
    return visitStrengthenAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getVisitStrengthenAddRadioItem2(){
    if(visitStrengthenAddRadioItem2==null){

      visitStrengthenAddRadioItem2 = new ACRadioButtonItem();

      visitStrengthenAddRadioItem2.setText("あり");

      visitStrengthenAddRadioItem2.setGroup(getVisitStrengthenAddRadioGroup());

      visitStrengthenAddRadioItem2.setConstraints(VRLayout.FLOW);

      addVisitStrengthenAddRadioItem2();
    }
    return visitStrengthenAddRadioItem2;

  }

  /**
   * 総合マネジメント体制強化加算を取得します。
   * @return 総合マネジメント体制強化加算
   */
  public ACValueArrayRadioButtonGroup getComprehensiveManagementSystemRadioGroup(){
    if(comprehensiveManagementSystemRadioGroup==null){

      comprehensiveManagementSystemRadioGroup = new ACValueArrayRadioButtonGroup();

      getComprehensiveManagementSystemRadioGroupContainer().setText("総合マネジメント体制強化加算");

      comprehensiveManagementSystemRadioGroup.setBindPath("1730108");

      comprehensiveManagementSystemRadioGroup.setVisible(true);

      comprehensiveManagementSystemRadioGroup.setEnabled(true);

      comprehensiveManagementSystemRadioGroup.setNoSelectIndex(0);

      comprehensiveManagementSystemRadioGroup.setUseClearButton(false);

      comprehensiveManagementSystemRadioGroup.setModel(getComprehensiveManagementSystemRadioGroupModel());

      comprehensiveManagementSystemRadioGroup.setValues(new int[]{1,2});

      addComprehensiveManagementSystemRadioGroup();
    }
    return comprehensiveManagementSystemRadioGroup;

  }

  /**
   * 総合マネジメント体制強化加算コンテナを取得します。
   * @return 総合マネジメント体制強化加算コンテナ
   */
  protected ACLabelContainer getComprehensiveManagementSystemRadioGroupContainer(){
    if(comprehensiveManagementSystemRadioGroupContainer==null){
      comprehensiveManagementSystemRadioGroupContainer = new ACLabelContainer();
      comprehensiveManagementSystemRadioGroupContainer.setFollowChildEnabled(true);
      comprehensiveManagementSystemRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      comprehensiveManagementSystemRadioGroupContainer.add(getComprehensiveManagementSystemRadioGroup(), null);
    }
    return comprehensiveManagementSystemRadioGroupContainer;
  }

  /**
   * 総合マネジメント体制強化加算モデルを取得します。
   * @return 総合マネジメント体制強化加算モデル
   */
  protected ACListModelAdapter getComprehensiveManagementSystemRadioGroupModel(){
    if(comprehensiveManagementSystemRadioGroupModel==null){
      comprehensiveManagementSystemRadioGroupModel = new ACListModelAdapter();
      addComprehensiveManagementSystemRadioGroupModel();
    }
    return comprehensiveManagementSystemRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getComprehensiveManagementSystemRadioItem1(){
    if(comprehensiveManagementSystemRadioItem1==null){

      comprehensiveManagementSystemRadioItem1 = new ACRadioButtonItem();

      comprehensiveManagementSystemRadioItem1.setText("なし");

      comprehensiveManagementSystemRadioItem1.setGroup(getComprehensiveManagementSystemRadioGroup());

      comprehensiveManagementSystemRadioItem1.setConstraints(VRLayout.FLOW);

      addComprehensiveManagementSystemRadioItem1();
    }
    return comprehensiveManagementSystemRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getComprehensiveManagementSystemRadioItem2(){
    if(comprehensiveManagementSystemRadioItem2==null){

      comprehensiveManagementSystemRadioItem2 = new ACRadioButtonItem();

      comprehensiveManagementSystemRadioItem2.setText("あり");

      comprehensiveManagementSystemRadioItem2.setGroup(getComprehensiveManagementSystemRadioGroup());

      comprehensiveManagementSystemRadioItem2.setConstraints(VRLayout.FLOW);

      addComprehensiveManagementSystemRadioItem2();
    }
    return comprehensiveManagementSystemRadioItem2;

  }

  /**
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1730103");

      serviceAddProvisionStructuralRadioGroup.setVisible(true);

      serviceAddProvisionStructuralRadioGroup.setEnabled(true);

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,5,2,3,4});

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

      getStaffUpgradeRadioGroupContainer().setText("<html>介護職員処遇改善加算<br>（旧加算：～H29.3）</html>");

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

      staffUpgradeRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

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

      staffUpgradeRadioItem3.setText("加算II（旧加算I）");

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

      staffUpgradeRadioItem4.setText("加算III（旧加算II）");

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

      staffUpgradeRadioItem5.setText("加算IV（旧加算III）");

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

      staffUpgradeRadioItem6.setText("加算V（旧加算IV）");

      staffUpgradeRadioItem6.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem6.setConstraints(VRLayout.FLOW);

      addStaffUpgradeRadioItem6();
    }
    return staffUpgradeRadioItem6;

  }

  /**
   * 小規模多機能型市町村独自加算を取得します。
   * @return 小規模多機能型市町村独自加算
   */
  public ACValueArrayRadioButtonGroup getBaseMunicipalityAdd(){
    if(baseMunicipalityAdd==null){

      baseMunicipalityAdd = new ACValueArrayRadioButtonGroup();

      getBaseMunicipalityAddContainer().setText("小規模多機能型市町村独自加算");

      baseMunicipalityAdd.setBindPath("1730104");

      baseMunicipalityAdd.setNoSelectIndex(0);

      baseMunicipalityAdd.setUseClearButton(false);

      baseMunicipalityAdd.setModel(getBaseMunicipalityAddModel());

      baseMunicipalityAdd.setValues(new int[]{1,2,3,4,5,6,7,8,9,10,11});

      addBaseMunicipalityAdd();
    }
    return baseMunicipalityAdd;

  }

  /**
   * 小規模多機能型市町村独自加算コンテナを取得します。
   * @return 小規模多機能型市町村独自加算コンテナ
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
   * 小規模多機能型市町村独自加算モデルを取得します。
   * @return 小規模多機能型市町村独自加算モデル
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
   * 加算7を取得します。
   * @return 加算7
   */
  public ACRadioButtonItem getBaseMunicipalityAddItem8(){
    if(baseMunicipalityAddItem8==null){

      baseMunicipalityAddItem8 = new ACRadioButtonItem();

      baseMunicipalityAddItem8.setText("加算7");

      baseMunicipalityAddItem8.setGroup(getBaseMunicipalityAdd());

      baseMunicipalityAddItem8.setConstraints(VRLayout.FLOW_RETURN);

      addBaseMunicipalityAddItem8();
    }
    return baseMunicipalityAddItem8;

  }

  /**
   * 加算8を取得します。
   * @return 加算8
   */
  public ACRadioButtonItem getBaseMunicipalityAddItem9(){
    if(baseMunicipalityAddItem9==null){

      baseMunicipalityAddItem9 = new ACRadioButtonItem();

      baseMunicipalityAddItem9.setText("加算8");

      baseMunicipalityAddItem9.setGroup(getBaseMunicipalityAdd());

      baseMunicipalityAddItem9.setConstraints(VRLayout.FLOW);

      addBaseMunicipalityAddItem9();
    }
    return baseMunicipalityAddItem9;

  }

  /**
   * 加算9を取得します。
   * @return 加算9
   */
  public ACRadioButtonItem getBaseMunicipalityAddItem10(){
    if(baseMunicipalityAddItem10==null){

      baseMunicipalityAddItem10 = new ACRadioButtonItem();

      baseMunicipalityAddItem10.setText("加算9");

      baseMunicipalityAddItem10.setGroup(getBaseMunicipalityAdd());

      baseMunicipalityAddItem10.setConstraints(VRLayout.FLOW);

      addBaseMunicipalityAddItem10();
    }
    return baseMunicipalityAddItem10;

  }

  /**
   * 加算10を取得します。
   * @return 加算10
   */
  public ACRadioButtonItem getBaseMunicipalityAddItem11(){
    if(baseMunicipalityAddItem11==null){

      baseMunicipalityAddItem11 = new ACRadioButtonItem();

      baseMunicipalityAddItem11.setText("加算10");

      baseMunicipalityAddItem11.setGroup(getBaseMunicipalityAdd());

      baseMunicipalityAddItem11.setConstraints(VRLayout.FLOW);

      addBaseMunicipalityAddItem11();
    }
    return baseMunicipalityAddItem11;

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
  public QO004_17311_201504Design() {

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

    mainGroup.add(getFacilityDivisionRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getNurseStaffDispositionAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getTerminalCareInformationRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getVisitStrengthenAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getComprehensiveManagementSystemRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getStaffUpgradeRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getBaseMunicipalityAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getReduceRateContainer(), VRLayout.FLOW_INSETLINE);

    mainGroup.add(getShahukuReduce(), VRLayout.FLOW_RETURN);

    mainGroup.add(getOldLowElementArea(), VRLayout.FLOW_RETURN);

  }

  /**
   * 施設等の区分に内部項目を追加します。
   */
  protected void addFacilityDivisionRadioGroup(){

  }

  /**
   * 施設等の区分モデルに内部項目を追加します。
   */
  protected void addFacilityDivisionRadioGroupModel(){

    getFacilityDivisionRadioItem1().setButtonIndex(1);

    getFacilityDivisionRadioGroupModel().add(getFacilityDivisionRadioItem1());

    getFacilityDivisionRadioItem2().setButtonIndex(2);

    getFacilityDivisionRadioGroupModel().add(getFacilityDivisionRadioItem2());

  }

  /**
   * 小規模多機能型居宅介護事業所に内部項目を追加します。
   */
  protected void addFacilityDivisionRadioItem1(){

  }

  /**
   * サテライト型小規模多機能型居宅介護事業所に内部項目を追加します。
   */
  protected void addFacilityDivisionRadioItem2(){

  }

  /**
   * 職員の欠員による減算の状況に内部項目を追加します。
   */
  protected void addStaffLack(){

  }

  /**
   * 職員の欠員による減算の状況モデルに内部項目を追加します。
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
   * 看護職員配置加算に内部項目を追加します。
   */
  protected void addNurseStaffDispositionAddRadioGroup(){

  }

  /**
   * 看護職員配置加算モデルに内部項目を追加します。
   */
  protected void addNurseStaffDispositionAddRadioGroupModel(){

    getNurseStaffDispositionAddRadioItem1().setButtonIndex(1);

    getNurseStaffDispositionAddRadioGroupModel().add(getNurseStaffDispositionAddRadioItem1());

    getNurseStaffDispositionAddRadioItem2().setButtonIndex(2);

    getNurseStaffDispositionAddRadioGroupModel().add(getNurseStaffDispositionAddRadioItem2());

    getNurseStaffDispositionAddRadioItem3().setButtonIndex(3);

    getNurseStaffDispositionAddRadioGroupModel().add(getNurseStaffDispositionAddRadioItem3());

    getNurseStaffDispositionAddRadioItem4().setButtonIndex(4);

    getNurseStaffDispositionAddRadioGroupModel().add(getNurseStaffDispositionAddRadioItem4());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNurseStaffDispositionAddRadioItem1(){

  }

  /**
   * 加算Iに内部項目を追加します。
   */
  protected void addNurseStaffDispositionAddRadioItem2(){

  }

  /**
   * 加算IIに内部項目を追加します。
   */
  protected void addNurseStaffDispositionAddRadioItem3(){

  }

  /**
   * 加算IIIに内部項目を追加します。
   */
  protected void addNurseStaffDispositionAddRadioItem4(){

  }

  /**
   * 看取り連携体制加算に内部項目を追加します。
   */
  protected void addTerminalCareInformationRadioGroup(){

  }

  /**
   * 看取り連携体制加算モデルに内部項目を追加します。
   */
  protected void addTerminalCareInformationRadioGroupModel(){

    getTerminalCareInformationRadioItem1().setButtonIndex(1);

    getTerminalCareInformationRadioGroupModel().add(getTerminalCareInformationRadioItem1());

    getTerminalCareInformationRadioItem2().setButtonIndex(2);

    getTerminalCareInformationRadioGroupModel().add(getTerminalCareInformationRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTerminalCareInformationRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addTerminalCareInformationRadioItem2(){

  }

  /**
   * 訪問体制強化加算に内部項目を追加します。
   */
  protected void addVisitStrengthenAddRadioGroup(){

  }

  /**
   * 訪問体制強化加算モデルに内部項目を追加します。
   */
  protected void addVisitStrengthenAddRadioGroupModel(){

    getVisitStrengthenAddRadioItem1().setButtonIndex(1);

    getVisitStrengthenAddRadioGroupModel().add(getVisitStrengthenAddRadioItem1());

    getVisitStrengthenAddRadioItem2().setButtonIndex(2);

    getVisitStrengthenAddRadioGroupModel().add(getVisitStrengthenAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addVisitStrengthenAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addVisitStrengthenAddRadioItem2(){

  }

  /**
   * 総合マネジメント体制強化加算に内部項目を追加します。
   */
  protected void addComprehensiveManagementSystemRadioGroup(){

  }

  /**
   * 総合マネジメント体制強化加算モデルに内部項目を追加します。
   */
  protected void addComprehensiveManagementSystemRadioGroupModel(){

    getComprehensiveManagementSystemRadioItem1().setButtonIndex(1);

    getComprehensiveManagementSystemRadioGroupModel().add(getComprehensiveManagementSystemRadioItem1());

    getComprehensiveManagementSystemRadioItem2().setButtonIndex(2);

    getComprehensiveManagementSystemRadioGroupModel().add(getComprehensiveManagementSystemRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addComprehensiveManagementSystemRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addComprehensiveManagementSystemRadioItem2(){

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

    getServiceAddProvisionStructuralRadioItem2().setButtonIndex(5);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem2());

    getServiceAddProvisionStructuralRadioItem3().setButtonIndex(2);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem3());

    getServiceAddProvisionStructuralRadioItem4().setButtonIndex(3);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem4());

    getServiceAddProvisionStructuralRadioItem5().setButtonIndex(4);

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
   * 小規模多機能型市町村独自加算に内部項目を追加します。
   */
  protected void addBaseMunicipalityAdd(){

  }

  /**
   * 小規模多機能型市町村独自加算モデルに内部項目を追加します。
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

    getBaseMunicipalityAddItem8().setButtonIndex(8);

    getBaseMunicipalityAddModel().add(getBaseMunicipalityAddItem8());

    getBaseMunicipalityAddItem9().setButtonIndex(9);

    getBaseMunicipalityAddModel().add(getBaseMunicipalityAddItem9());

    getBaseMunicipalityAddItem10().setButtonIndex(10);

    getBaseMunicipalityAddModel().add(getBaseMunicipalityAddItem10());

    getBaseMunicipalityAddItem11().setButtonIndex(11);

    getBaseMunicipalityAddModel().add(getBaseMunicipalityAddItem11());

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
   * 加算7に内部項目を追加します。
   */
  protected void addBaseMunicipalityAddItem8(){

  }

  /**
   * 加算8に内部項目を追加します。
   */
  protected void addBaseMunicipalityAddItem9(){

  }

  /**
   * 加算9に内部項目を追加します。
   */
  protected void addBaseMunicipalityAddItem10(){

  }

  /**
   * 加算10に内部項目を追加します。
   */
  protected void addBaseMunicipalityAddItem11(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004_17311_201504Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004_17311_201504Design getThis() {
    return this;
  }
}
