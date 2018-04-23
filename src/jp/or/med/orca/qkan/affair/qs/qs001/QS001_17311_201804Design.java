
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
 * 作成日: 2018/04/20  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン小規模多機能型介護 (QS001_17311_201804)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
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
 * サービスパターン小規模多機能型介護画面項目デザイン(QS001_17311_201804) 
 */
public class QS001_17311_201804Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel regionSmallscaleMultiPatterns;

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup initialAddRadio;

  private ACLabelContainer initialAddRadioContainer;

  private ACListModelAdapter initialAddRadioModel;

  private ACRadioButtonItem initialAddRadioItem1;

  private ACRadioButtonItem initialAddRadioItem2;

  private ACValueArrayRadioButtonGroup smallServiceRadio;

  private ACLabelContainer smallServiceRadioContainer;

  private ACListModelAdapter smallServiceRadioModel;

  private ACRadioButtonItem smallServiceRadioItem1;

  private ACRadioButtonItem smallServiceRadioItem2;

  private ACValueArrayRadioButtonGroup staffSubtractionRadio;

  private ACLabelContainer staffSubtractionRadioContainer;

  private ACListModelAdapter staffSubtractionRadioModel;

  private ACRadioButtonItem staffSubtractionRadioItem1;

  private ACRadioButtonItem staffSubtractionRadioItem2;

  private ACRadioButtonItem staffSubtractionRadioItem3;

  private ACValueArrayRadioButtonGroup dementiaAddRadioGroup;

  private ACLabelContainer dementiaAddRadioGroupContainer;

  private ACListModelAdapter dementiaAddRadioGroupModel;

  private ACRadioButtonItem dementiaAddRadioItem1;

  private ACRadioButtonItem dementiaAddRadioItem2;

  private ACRadioButtonItem dementiaAddRadioItem3;

  private ACValueArrayRadioButtonGroup nurseStaffDispositionAddRadioGroup;

  private ACLabelContainer nurseStaffDispositionAddRadioGroupContainer;

  private ACListModelAdapter nurseStaffDispositionAddRadioGroupModel;

  private ACRadioButtonItem nurseStaffDispositionAddRadioItem1;

  private ACRadioButtonItem nurseStaffDispositionAddRadioItem2;

  private ACRadioButtonItem nurseStaffDispositionAddRadioItem3;

  private ACRadioButtonItem nurseStaffDispositionAddRadioItem4;

  private ACValueArrayRadioButtonGroup houmonNeededRadio;

  private ACLabelContainer houmonNeededRadioContainer;

  private ACListModelAdapter houmonNeededRadioModel;

  private ACRadioButtonItem houmonNeededRadioItem1;

  private ACRadioButtonItem houmonNeededRadioItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACComboBox municipalityAdd;

  private ACLabelContainer municipalityAddContainer;

  private ACComboBoxModelAdapter municipalityAddModel;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRafioRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRafioRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRafioRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaRafioItem1;

  private ACRadioButtonItem providerAddMountainousAreaRafioRadioItem2;

  private ACValueArrayRadioButtonGroup terminalCareInformationRadioGroup;

  private ACLabelContainer terminalCareInformationRadioGroupContainer;

  private ACListModelAdapter terminalCareInformationRadioGroupModel;

  private ACRadioButtonItem terminalCareInformationRadioItem1;

  private ACRadioButtonItem terminalCareInformationRadioItem2;

  private ACLabelContainer terminalCareInformationAddDaysContainer;

  private ACTextField terminalCareInformationAddDays;

  private ACLabel terminalCareInformationAddDaysUnit;

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

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACValueArrayRadioButtonGroup rehabilitationSpecialistPersonnelCooperationRadioGroup;

  private ACLabelContainer rehabilitationSpecialistPersonnelCooperationRadioGroupContainer;

  private ACListModelAdapter rehabilitationSpecialistPersonnelCooperationRadioGroupModel;

  private ACRadioButtonItem rehabilitationSpecialistPersonnelCooperationItem1;

  private ACRadioButtonItem rehabilitationSpecialistPersonnelCooperationItem2;

  private ACRadioButtonItem rehabilitationSpecialistPersonnelCooperationItem3;

  private ACValueArrayRadioButtonGroup nutritionScreening;

  private ACLabelContainer nutritionScreeningContainer;

  private ACListModelAdapter nutritionScreeningModel;

  private ACRadioButtonItem nutritionScreeningItem1;

  private ACRadioButtonItem nutritionScreeningItem2;

  private ACValueArrayRadioButtonGroup calculationDivision;

  private ACLabelContainer calculationDivisionContainer;

  private ACListModelAdapter calculationDivisionModel;

  private ACRadioButtonItem calculationDivisionItem1;

  private ACRadioButtonItem calculationDivisionItem2;

  private ACPanel tab3;

  private ACIntegerCheckBox crackOnDayCheck;

  private ACIntegerCheckBox printable;

  private ACGroupBox infoGroup;

  private ACLabel infoLabel;

  private ACGroupBox kaigoSupportSpecialMemberContainer;

  private ACTextField kaigoSupportSpecialMemberNumber;

  private ACLabelContainer kaigoSupportSpecialMemberNumberContainer;

  private ACComboBox kaigoSupportSpecialMemberName;

  private ACLabelContainer kaigoSupportSpecialMemberNameContainer;

  private ACComboBoxModelAdapter kaigoSupportSpecialMemberNameModel;

  private ACGroupBox tekiyouGroup;

  private ACTextField tekiyouText;

  private ACLabelContainer tekiyouTextContainer;

  private ACLabel tekiyouCommentTitle;

  //getter

  /**
   * 地域密着小規模多機能型介護パターン領域を取得します。
   * @return 地域密着小規模多機能型介護パターン領域
   */
  public ACPanel getRegionSmallscaleMultiPatterns(){
    if(regionSmallscaleMultiPatterns==null){

      regionSmallscaleMultiPatterns = new ACPanel();

      regionSmallscaleMultiPatterns.setAutoWrap(false);

      regionSmallscaleMultiPatterns.setFollowChildEnabled(true);

      regionSmallscaleMultiPatterns.setHgrid(200);

      addRegionSmallscaleMultiPatterns();
    }
    return regionSmallscaleMultiPatterns;

  }

  /**
   * タブパネルを取得します。
   * @return タブパネル
   */
  public JTabbedPane getTabs(){
    if(tabs==null){

      tabs = new JTabbedPane();

      addTabs();
    }
    return tabs;

  }

  /**
   * タブ1を取得します。
   * @return タブ1
   */
  public ACPanel getTab1(){
    if(tab1==null){

      tab1 = new ACPanel();

      tab1.setFollowChildEnabled(true);

      tab1.setHgap(0);

      tab1.setLabelMargin(0);

      tab1.setVgap(0);

      addTab1();
    }
    return tab1;

  }

  /**
   * 初期加算を取得します。
   * @return 初期加算
   */
  public ACValueArrayRadioButtonGroup getInitialAddRadio(){
    if(initialAddRadio==null){

      initialAddRadio = new ACValueArrayRadioButtonGroup();

      getInitialAddRadioContainer().setText("初期加算");

      initialAddRadio.setBindPath("1730101");

      initialAddRadio.setUseClearButton(false);

      initialAddRadio.setModel(getInitialAddRadioModel());

      initialAddRadio.setValues(new int[]{1,2});

      addInitialAddRadio();
    }
    return initialAddRadio;

  }

  /**
   * 初期加算コンテナを取得します。
   * @return 初期加算コンテナ
   */
  protected ACLabelContainer getInitialAddRadioContainer(){
    if(initialAddRadioContainer==null){
      initialAddRadioContainer = new ACLabelContainer();
      initialAddRadioContainer.setFollowChildEnabled(true);
      initialAddRadioContainer.setVAlignment(VRLayout.CENTER);
      initialAddRadioContainer.add(getInitialAddRadio(), null);
    }
    return initialAddRadioContainer;
  }

  /**
   * 初期加算モデルを取得します。
   * @return 初期加算モデル
   */
  protected ACListModelAdapter getInitialAddRadioModel(){
    if(initialAddRadioModel==null){
      initialAddRadioModel = new ACListModelAdapter();
      addInitialAddRadioModel();
    }
    return initialAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getInitialAddRadioItem1(){
    if(initialAddRadioItem1==null){

      initialAddRadioItem1 = new ACRadioButtonItem();

      initialAddRadioItem1.setText("なし");

      initialAddRadioItem1.setGroup(getInitialAddRadio());

      initialAddRadioItem1.setConstraints(VRLayout.FLOW);

      addInitialAddRadioItem1();
    }
    return initialAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getInitialAddRadioItem2(){
    if(initialAddRadioItem2==null){

      initialAddRadioItem2 = new ACRadioButtonItem();

      initialAddRadioItem2.setText("あり");

      initialAddRadioItem2.setGroup(getInitialAddRadio());

      initialAddRadioItem2.setConstraints(VRLayout.FLOW);

      addInitialAddRadioItem2();
    }
    return initialAddRadioItem2;

  }

  /**
   * 過小サービスに対する減算を取得します。
   * @return 過小サービスに対する減算
   */
  public ACValueArrayRadioButtonGroup getSmallServiceRadio(){
    if(smallServiceRadio==null){

      smallServiceRadio = new ACValueArrayRadioButtonGroup();

      getSmallServiceRadioContainer().setText("過小サービスに対する減算");

      smallServiceRadio.setBindPath("1730106");

      smallServiceRadio.setNoSelectIndex(0);

      smallServiceRadio.setUseClearButton(false);

      smallServiceRadio.setModel(getSmallServiceRadioModel());

      smallServiceRadio.setValues(new int[]{1,2});

      addSmallServiceRadio();
    }
    return smallServiceRadio;

  }

  /**
   * 過小サービスに対する減算コンテナを取得します。
   * @return 過小サービスに対する減算コンテナ
   */
  protected ACLabelContainer getSmallServiceRadioContainer(){
    if(smallServiceRadioContainer==null){
      smallServiceRadioContainer = new ACLabelContainer();
      smallServiceRadioContainer.setFollowChildEnabled(true);
      smallServiceRadioContainer.setVAlignment(VRLayout.CENTER);
      smallServiceRadioContainer.add(getSmallServiceRadio(), null);
    }
    return smallServiceRadioContainer;
  }

  /**
   * 過小サービスに対する減算モデルを取得します。
   * @return 過小サービスに対する減算モデル
   */
  protected ACListModelAdapter getSmallServiceRadioModel(){
    if(smallServiceRadioModel==null){
      smallServiceRadioModel = new ACListModelAdapter();
      addSmallServiceRadioModel();
    }
    return smallServiceRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSmallServiceRadioItem1(){
    if(smallServiceRadioItem1==null){

      smallServiceRadioItem1 = new ACRadioButtonItem();

      smallServiceRadioItem1.setText("なし");

      smallServiceRadioItem1.setGroup(getSmallServiceRadio());

      smallServiceRadioItem1.setConstraints(VRLayout.FLOW);

      addSmallServiceRadioItem1();
    }
    return smallServiceRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getSmallServiceRadioItem2(){
    if(smallServiceRadioItem2==null){

      smallServiceRadioItem2 = new ACRadioButtonItem();

      smallServiceRadioItem2.setText("あり");

      smallServiceRadioItem2.setGroup(getSmallServiceRadio());

      smallServiceRadioItem2.setConstraints(VRLayout.FLOW);

      addSmallServiceRadioItem2();
    }
    return smallServiceRadioItem2;

  }

  /**
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACValueArrayRadioButtonGroup getStaffSubtractionRadio(){
    if(staffSubtractionRadio==null){

      staffSubtractionRadio = new ACValueArrayRadioButtonGroup();

      getStaffSubtractionRadioContainer().setText("人員減算");

      staffSubtractionRadio.setBindPath("1730102");

      staffSubtractionRadio.setUseClearButton(false);

      staffSubtractionRadio.setModel(getStaffSubtractionRadioModel());

      staffSubtractionRadio.setValues(new int[]{1,2,3});

      addStaffSubtractionRadio();
    }
    return staffSubtractionRadio;

  }

  /**
   * 人員減算コンテナを取得します。
   * @return 人員減算コンテナ
   */
  protected ACLabelContainer getStaffSubtractionRadioContainer(){
    if(staffSubtractionRadioContainer==null){
      staffSubtractionRadioContainer = new ACLabelContainer();
      staffSubtractionRadioContainer.setFollowChildEnabled(true);
      staffSubtractionRadioContainer.setVAlignment(VRLayout.CENTER);
      staffSubtractionRadioContainer.add(getStaffSubtractionRadio(), null);
    }
    return staffSubtractionRadioContainer;
  }

  /**
   * 人員減算モデルを取得します。
   * @return 人員減算モデル
   */
  protected ACListModelAdapter getStaffSubtractionRadioModel(){
    if(staffSubtractionRadioModel==null){
      staffSubtractionRadioModel = new ACListModelAdapter();
      addStaffSubtractionRadioModel();
    }
    return staffSubtractionRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getStaffSubtractionRadioItem1(){
    if(staffSubtractionRadioItem1==null){

      staffSubtractionRadioItem1 = new ACRadioButtonItem();

      staffSubtractionRadioItem1.setText("なし");

      staffSubtractionRadioItem1.setGroup(getStaffSubtractionRadio());

      staffSubtractionRadioItem1.setConstraints(VRLayout.FLOW);

      addStaffSubtractionRadioItem1();
    }
    return staffSubtractionRadioItem1;

  }

  /**
   * 定員超過を取得します。
   * @return 定員超過
   */
  public ACRadioButtonItem getStaffSubtractionRadioItem2(){
    if(staffSubtractionRadioItem2==null){

      staffSubtractionRadioItem2 = new ACRadioButtonItem();

      staffSubtractionRadioItem2.setText("定員超過");

      staffSubtractionRadioItem2.setGroup(getStaffSubtractionRadio());

      staffSubtractionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addStaffSubtractionRadioItem2();
    }
    return staffSubtractionRadioItem2;

  }

  /**
   * 従業者の不足を取得します。
   * @return 従業者の不足
   */
  public ACRadioButtonItem getStaffSubtractionRadioItem3(){
    if(staffSubtractionRadioItem3==null){

      staffSubtractionRadioItem3 = new ACRadioButtonItem();

      staffSubtractionRadioItem3.setText("従業者の不足");

      staffSubtractionRadioItem3.setGroup(getStaffSubtractionRadio());

      staffSubtractionRadioItem3.setConstraints(VRLayout.FLOW);

      addStaffSubtractionRadioItem3();
    }
    return staffSubtractionRadioItem3;

  }

  /**
   * 認知症加算を取得します。
   * @return 認知症加算
   */
  public ACValueArrayRadioButtonGroup getDementiaAddRadioGroup(){
    if(dementiaAddRadioGroup==null){

      dementiaAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaAddRadioGroupContainer().setText("認知症加算");

      dementiaAddRadioGroup.setBindPath("1730107");

      dementiaAddRadioGroup.setNoSelectIndex(0);

      dementiaAddRadioGroup.setUseClearButton(false);

      dementiaAddRadioGroup.setModel(getDementiaAddRadioGroupModel());

      dementiaAddRadioGroup.setValues(new int[]{1,2,3});

      addDementiaAddRadioGroup();
    }
    return dementiaAddRadioGroup;

  }

  /**
   * 認知症加算コンテナを取得します。
   * @return 認知症加算コンテナ
   */
  protected ACLabelContainer getDementiaAddRadioGroupContainer(){
    if(dementiaAddRadioGroupContainer==null){
      dementiaAddRadioGroupContainer = new ACLabelContainer();
      dementiaAddRadioGroupContainer.setFollowChildEnabled(true);
      dementiaAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      dementiaAddRadioGroupContainer.add(getDementiaAddRadioGroup(), null);
    }
    return dementiaAddRadioGroupContainer;
  }

  /**
   * 認知症加算モデルを取得します。
   * @return 認知症加算モデル
   */
  protected ACListModelAdapter getDementiaAddRadioGroupModel(){
    if(dementiaAddRadioGroupModel==null){
      dementiaAddRadioGroupModel = new ACListModelAdapter();
      addDementiaAddRadioGroupModel();
    }
    return dementiaAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getDementiaAddRadioItem1(){
    if(dementiaAddRadioItem1==null){

      dementiaAddRadioItem1 = new ACRadioButtonItem();

      dementiaAddRadioItem1.setText("なし");

      dementiaAddRadioItem1.setGroup(getDementiaAddRadioGroup());

      dementiaAddRadioItem1.setConstraints(VRLayout.FLOW);

      addDementiaAddRadioItem1();
    }
    return dementiaAddRadioItem1;

  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getDementiaAddRadioItem2(){
    if(dementiaAddRadioItem2==null){

      dementiaAddRadioItem2 = new ACRadioButtonItem();

      dementiaAddRadioItem2.setText("I型");

      dementiaAddRadioItem2.setGroup(getDementiaAddRadioGroup());

      dementiaAddRadioItem2.setConstraints(VRLayout.FLOW);

      addDementiaAddRadioItem2();
    }
    return dementiaAddRadioItem2;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getDementiaAddRadioItem3(){
    if(dementiaAddRadioItem3==null){

      dementiaAddRadioItem3 = new ACRadioButtonItem();

      dementiaAddRadioItem3.setText("II型");

      dementiaAddRadioItem3.setGroup(getDementiaAddRadioGroup());

      dementiaAddRadioItem3.setConstraints(VRLayout.FLOW);

      addDementiaAddRadioItem3();
    }
    return dementiaAddRadioItem3;

  }

  /**
   * 看護職員配置加算を取得します。
   * @return 看護職員配置加算
   */
  public ACValueArrayRadioButtonGroup getNurseStaffDispositionAddRadioGroup(){
    if(nurseStaffDispositionAddRadioGroup==null){

      nurseStaffDispositionAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getNurseStaffDispositionAddRadioGroupContainer().setText("看護職員配置加算");

      nurseStaffDispositionAddRadioGroup.setBindPath("1730108");

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
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getNurseStaffDispositionAddRadioItem2(){
    if(nurseStaffDispositionAddRadioItem2==null){

      nurseStaffDispositionAddRadioItem2 = new ACRadioButtonItem();

      nurseStaffDispositionAddRadioItem2.setText("I型");

      nurseStaffDispositionAddRadioItem2.setGroup(getNurseStaffDispositionAddRadioGroup());

      nurseStaffDispositionAddRadioItem2.setConstraints(VRLayout.FLOW);

      addNurseStaffDispositionAddRadioItem2();
    }
    return nurseStaffDispositionAddRadioItem2;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getNurseStaffDispositionAddRadioItem3(){
    if(nurseStaffDispositionAddRadioItem3==null){

      nurseStaffDispositionAddRadioItem3 = new ACRadioButtonItem();

      nurseStaffDispositionAddRadioItem3.setText("II型");

      nurseStaffDispositionAddRadioItem3.setGroup(getNurseStaffDispositionAddRadioGroup());

      nurseStaffDispositionAddRadioItem3.setConstraints(VRLayout.FLOW);

      addNurseStaffDispositionAddRadioItem3();
    }
    return nurseStaffDispositionAddRadioItem3;

  }

  /**
   * III型を取得します。
   * @return III型
   */
  public ACRadioButtonItem getNurseStaffDispositionAddRadioItem4(){
    if(nurseStaffDispositionAddRadioItem4==null){

      nurseStaffDispositionAddRadioItem4 = new ACRadioButtonItem();

      nurseStaffDispositionAddRadioItem4.setText("III型");

      nurseStaffDispositionAddRadioItem4.setGroup(getNurseStaffDispositionAddRadioGroup());

      nurseStaffDispositionAddRadioItem4.setConstraints(VRLayout.FLOW);

      addNurseStaffDispositionAddRadioItem4();
    }
    return nurseStaffDispositionAddRadioItem4;

  }

  /**
   * 同一建物居住者へのサービス提供を取得します。
   * @return 同一建物居住者へのサービス提供
   */
  public ACValueArrayRadioButtonGroup getHoumonNeededRadio(){
    if(houmonNeededRadio==null){

      houmonNeededRadio = new ACValueArrayRadioButtonGroup();

      getHoumonNeededRadioContainer().setText("同一建物居住者へのサービス提供");

      houmonNeededRadio.setBindPath("16");

      houmonNeededRadio.setNoSelectIndex(0);

      houmonNeededRadio.setUseClearButton(false);

      houmonNeededRadio.setModel(getHoumonNeededRadioModel());

      houmonNeededRadio.setValues(new int[]{1,2});

      addHoumonNeededRadio();
    }
    return houmonNeededRadio;

  }

  /**
   * 同一建物居住者へのサービス提供コンテナを取得します。
   * @return 同一建物居住者へのサービス提供コンテナ
   */
  protected ACLabelContainer getHoumonNeededRadioContainer(){
    if(houmonNeededRadioContainer==null){
      houmonNeededRadioContainer = new ACLabelContainer();
      houmonNeededRadioContainer.setFollowChildEnabled(true);
      houmonNeededRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonNeededRadioContainer.add(getHoumonNeededRadio(), null);
    }
    return houmonNeededRadioContainer;
  }

  /**
   * 同一建物居住者へのサービス提供モデルを取得します。
   * @return 同一建物居住者へのサービス提供モデル
   */
  protected ACListModelAdapter getHoumonNeededRadioModel(){
    if(houmonNeededRadioModel==null){
      houmonNeededRadioModel = new ACListModelAdapter();
      addHoumonNeededRadioModel();
    }
    return houmonNeededRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonNeededRadioItem1(){
    if(houmonNeededRadioItem1==null){

      houmonNeededRadioItem1 = new ACRadioButtonItem();

      houmonNeededRadioItem1.setText("なし");

      houmonNeededRadioItem1.setGroup(getHoumonNeededRadio());

      houmonNeededRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonNeededRadioItem1();
    }
    return houmonNeededRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonNeededRadioItem2(){
    if(houmonNeededRadioItem2==null){

      houmonNeededRadioItem2 = new ACRadioButtonItem();

      houmonNeededRadioItem2.setText("あり");

      houmonNeededRadioItem2.setGroup(getHoumonNeededRadio());

      houmonNeededRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonNeededRadioItem2();
    }
    return houmonNeededRadioItem2;

  }

  /**
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1730110");

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
   * Iイ型を取得します。
   * @return Iイ型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem5(){
    if(serviceAddProvisionStructuralRadioItem5==null){

      serviceAddProvisionStructuralRadioItem5 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem5.setText("Iイ型");

      serviceAddProvisionStructuralRadioItem5.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem5.setConstraints(VRLayout.FLOW_RETURN);

      addServiceAddProvisionStructuralRadioItem5();
    }
    return serviceAddProvisionStructuralRadioItem5;

  }

  /**
   * Iロ型を取得します。
   * @return Iロ型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("Iロ型");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem2();
    }
    return serviceAddProvisionStructuralRadioItem2;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem3(){
    if(serviceAddProvisionStructuralRadioItem3==null){

      serviceAddProvisionStructuralRadioItem3 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem3.setText("II型");

      serviceAddProvisionStructuralRadioItem3.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem3();
    }
    return serviceAddProvisionStructuralRadioItem3;

  }

  /**
   * III型を取得します。
   * @return III型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem4(){
    if(serviceAddProvisionStructuralRadioItem4==null){

      serviceAddProvisionStructuralRadioItem4 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem4.setText("III型");

      serviceAddProvisionStructuralRadioItem4.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem4.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem4();
    }
    return serviceAddProvisionStructuralRadioItem4;

  }

  /**
   * 市町村独自加算を取得します。
   * @return 市町村独自加算
   */
  public ACComboBox getMunicipalityAdd(){
    if(municipalityAdd==null){

      municipalityAdd = new ACComboBox();

      getMunicipalityAddContainer().setText("市町村独自加算");

      municipalityAdd.setBindPath("1730111");

      municipalityAdd.setEditable(false);

      municipalityAdd.setModelBindPath("1730111");

      municipalityAdd.setRenderBindPath("CONTENT");

      municipalityAdd.setBlankable(false);

      municipalityAdd.setModel(getMunicipalityAddModel());

      addMunicipalityAdd();
    }
    return municipalityAdd;

  }

  /**
   * 市町村独自加算コンテナを取得します。
   * @return 市町村独自加算コンテナ
   */
  protected ACLabelContainer getMunicipalityAddContainer(){
    if(municipalityAddContainer==null){
      municipalityAddContainer = new ACLabelContainer();
      municipalityAddContainer.setFollowChildEnabled(true);
      municipalityAddContainer.setVAlignment(VRLayout.CENTER);
      municipalityAddContainer.add(getMunicipalityAdd(), null);
    }
    return municipalityAddContainer;
  }

  /**
   * 市町村独自加算モデルを取得します。
   * @return 市町村独自加算モデル
   */
  protected ACComboBoxModelAdapter getMunicipalityAddModel(){
    if(municipalityAddModel==null){
      municipalityAddModel = new ACComboBoxModelAdapter();
      addMunicipalityAddModel();
    }
    return municipalityAddModel;
  }

  /**
   * タブ2を取得します。
   * @return タブ2
   */
  public ACPanel getTab2(){
    if(tab2==null){

      tab2 = new ACPanel();

      tab2.setFollowChildEnabled(true);

      tab2.setHgap(0);

      tab2.setLabelMargin(0);

      tab2.setVgap(0);

      addTab2();
    }
    return tab2;

  }

  /**
   * 中山間地域等でのサービス提供加算を取得します。
   * @return 中山間地域等でのサービス提供加算
   */
  public ACValueArrayRadioButtonGroup getProviderAddMountainousAreaRafioRadioGroup(){
    if(providerAddMountainousAreaRafioRadioGroup==null){

      providerAddMountainousAreaRafioRadioGroup = new ACValueArrayRadioButtonGroup();

      getProviderAddMountainousAreaRafioRadioGroupContainer().setText("中山間地域等でのサービス提供加算");

      providerAddMountainousAreaRafioRadioGroup.setBindPath("12");

      providerAddMountainousAreaRafioRadioGroup.setNoSelectIndex(0);

      providerAddMountainousAreaRafioRadioGroup.setUseClearButton(false);

      providerAddMountainousAreaRafioRadioGroup.setModel(getProviderAddMountainousAreaRafioRadioGroupModel());

      providerAddMountainousAreaRafioRadioGroup.setValues(new int[]{1,2});

      addProviderAddMountainousAreaRafioRadioGroup();
    }
    return providerAddMountainousAreaRafioRadioGroup;

  }

  /**
   * 中山間地域等でのサービス提供加算コンテナを取得します。
   * @return 中山間地域等でのサービス提供加算コンテナ
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
   * 中山間地域等でのサービス提供加算モデルを取得します。
   * @return 中山間地域等でのサービス提供加算モデル
   */
  protected ACListModelAdapter getProviderAddMountainousAreaRafioRadioGroupModel(){
    if(providerAddMountainousAreaRafioRadioGroupModel==null){
      providerAddMountainousAreaRafioRadioGroupModel = new ACListModelAdapter();
      addProviderAddMountainousAreaRafioRadioGroupModel();
    }
    return providerAddMountainousAreaRafioRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getProviderAddMountainousAreaRafioItem1(){
    if(providerAddMountainousAreaRafioItem1==null){

      providerAddMountainousAreaRafioItem1 = new ACRadioButtonItem();

      providerAddMountainousAreaRafioItem1.setText("なし");

      providerAddMountainousAreaRafioItem1.setGroup(getProviderAddMountainousAreaRafioRadioGroup());

      providerAddMountainousAreaRafioItem1.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaRafioItem1();
    }
    return providerAddMountainousAreaRafioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getProviderAddMountainousAreaRafioRadioItem2(){
    if(providerAddMountainousAreaRafioRadioItem2==null){

      providerAddMountainousAreaRafioRadioItem2 = new ACRadioButtonItem();

      providerAddMountainousAreaRafioRadioItem2.setText("あり");

      providerAddMountainousAreaRafioRadioItem2.setGroup(getProviderAddMountainousAreaRafioRadioGroup());

      providerAddMountainousAreaRafioRadioItem2.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaRafioRadioItem2();
    }
    return providerAddMountainousAreaRafioRadioItem2;

  }

  /**
   * 看取り連携体制加算を取得します。
   * @return 看取り連携体制加算
   */
  public ACValueArrayRadioButtonGroup getTerminalCareInformationRadioGroup(){
    if(terminalCareInformationRadioGroup==null){

      terminalCareInformationRadioGroup = new ACValueArrayRadioButtonGroup();

      getTerminalCareInformationRadioGroupContainer().setText("看取り連携体制加算");

      terminalCareInformationRadioGroup.setBindPath("1730113");

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
   * 看取り連携体制加算コンテナを取得します。
   * @return 看取り連携体制加算コンテナ
   */
  public ACLabelContainer getTerminalCareInformationAddDaysContainer(){
    if(terminalCareInformationAddDaysContainer==null){

      terminalCareInformationAddDaysContainer = new ACLabelContainer();

      terminalCareInformationAddDaysContainer.setText("看取り連携体制加算日数");

      terminalCareInformationAddDaysContainer.setFollowChildEnabled(true);

      addTerminalCareInformationAddDaysContainer();
    }
    return terminalCareInformationAddDaysContainer;

  }

  /**
   * 看取り連携体制加算日数を取得します。
   * @return 看取り連携体制加算日数
   */
  public ACTextField getTerminalCareInformationAddDays(){
    if(terminalCareInformationAddDays==null){

      terminalCareInformationAddDays = new ACTextField();

      terminalCareInformationAddDays.setText("1");

      terminalCareInformationAddDays.setBindPath("1730116");

      terminalCareInformationAddDays.setColumns(2);

      terminalCareInformationAddDays.setCharType(VRCharType.ONLY_DIGIT);

      terminalCareInformationAddDays.setHorizontalAlignment(SwingConstants.RIGHT);

      terminalCareInformationAddDays.setMaxLength(2);

      addTerminalCareInformationAddDays();
    }
    return terminalCareInformationAddDays;

  }

  /**
   * 看取り連携体制加算日数単位を取得します。
   * @return 看取り連携体制加算日数単位
   */
  public ACLabel getTerminalCareInformationAddDaysUnit(){
    if(terminalCareInformationAddDaysUnit==null){

      terminalCareInformationAddDaysUnit = new ACLabel();

      terminalCareInformationAddDaysUnit.setText("日");

      addTerminalCareInformationAddDaysUnit();
    }
    return terminalCareInformationAddDaysUnit;

  }

  /**
   * 訪問体制強化加算を取得します。
   * @return 訪問体制強化加算
   */
  public ACValueArrayRadioButtonGroup getVisitStrengthenAddRadioGroup(){
    if(visitStrengthenAddRadioGroup==null){

      visitStrengthenAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getVisitStrengthenAddRadioGroupContainer().setText("訪問体制強化加算");

      visitStrengthenAddRadioGroup.setBindPath("1730114");

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

      comprehensiveManagementSystemRadioGroup.setBindPath("1730115");

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
   * 若年性認知症受入加算を取得します。
   * @return 若年性認知症受入加算
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("若年性認知症受入加算");

      youngDementiaPatinetAddRadioGroup.setBindPath("1730117");

      youngDementiaPatinetAddRadioGroup.setNoSelectIndex(0);

      youngDementiaPatinetAddRadioGroup.setUseClearButton(false);

      youngDementiaPatinetAddRadioGroup.setModel(getYoungDementiaPatinetAddRadioGroupModel());

      youngDementiaPatinetAddRadioGroup.setValues(new int[]{1,2});

      addYoungDementiaPatinetAddRadioGroup();
    }
    return youngDementiaPatinetAddRadioGroup;

  }

  /**
   * 若年性認知症受入加算コンテナを取得します。
   * @return 若年性認知症受入加算コンテナ
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
   * 若年性認知症受入加算モデルを取得します。
   * @return 若年性認知症受入加算モデル
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
   * 生活機能向上連携加算を取得します。
   * @return 生活機能向上連携加算
   */
  public ACValueArrayRadioButtonGroup getRehabilitationSpecialistPersonnelCooperationRadioGroup(){
    if(rehabilitationSpecialistPersonnelCooperationRadioGroup==null){

      rehabilitationSpecialistPersonnelCooperationRadioGroup = new ACValueArrayRadioButtonGroup();

      getRehabilitationSpecialistPersonnelCooperationRadioGroupContainer().setText("生活機能向上連携加算");

      rehabilitationSpecialistPersonnelCooperationRadioGroup.setBindPath("1730118");

      rehabilitationSpecialistPersonnelCooperationRadioGroup.setNoSelectIndex(0);

      rehabilitationSpecialistPersonnelCooperationRadioGroup.setUseClearButton(false);

      rehabilitationSpecialistPersonnelCooperationRadioGroup.setModel(getRehabilitationSpecialistPersonnelCooperationRadioGroupModel());

      rehabilitationSpecialistPersonnelCooperationRadioGroup.setValues(new int[]{1,2,3});

      addRehabilitationSpecialistPersonnelCooperationRadioGroup();
    }
    return rehabilitationSpecialistPersonnelCooperationRadioGroup;

  }

  /**
   * 生活機能向上連携加算コンテナを取得します。
   * @return 生活機能向上連携加算コンテナ
   */
  protected ACLabelContainer getRehabilitationSpecialistPersonnelCooperationRadioGroupContainer(){
    if(rehabilitationSpecialistPersonnelCooperationRadioGroupContainer==null){
      rehabilitationSpecialistPersonnelCooperationRadioGroupContainer = new ACLabelContainer();
      rehabilitationSpecialistPersonnelCooperationRadioGroupContainer.setFollowChildEnabled(true);
      rehabilitationSpecialistPersonnelCooperationRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      rehabilitationSpecialistPersonnelCooperationRadioGroupContainer.add(getRehabilitationSpecialistPersonnelCooperationRadioGroup(), null);
    }
    return rehabilitationSpecialistPersonnelCooperationRadioGroupContainer;
  }

  /**
   * 生活機能向上連携加算モデルを取得します。
   * @return 生活機能向上連携加算モデル
   */
  protected ACListModelAdapter getRehabilitationSpecialistPersonnelCooperationRadioGroupModel(){
    if(rehabilitationSpecialistPersonnelCooperationRadioGroupModel==null){
      rehabilitationSpecialistPersonnelCooperationRadioGroupModel = new ACListModelAdapter();
      addRehabilitationSpecialistPersonnelCooperationRadioGroupModel();
    }
    return rehabilitationSpecialistPersonnelCooperationRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getRehabilitationSpecialistPersonnelCooperationItem1(){
    if(rehabilitationSpecialistPersonnelCooperationItem1==null){

      rehabilitationSpecialistPersonnelCooperationItem1 = new ACRadioButtonItem();

      rehabilitationSpecialistPersonnelCooperationItem1.setText("なし");

      rehabilitationSpecialistPersonnelCooperationItem1.setGroup(getRehabilitationSpecialistPersonnelCooperationRadioGroup());

      rehabilitationSpecialistPersonnelCooperationItem1.setConstraints(VRLayout.FLOW);

      addRehabilitationSpecialistPersonnelCooperationItem1();
    }
    return rehabilitationSpecialistPersonnelCooperationItem1;

  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getRehabilitationSpecialistPersonnelCooperationItem2(){
    if(rehabilitationSpecialistPersonnelCooperationItem2==null){

      rehabilitationSpecialistPersonnelCooperationItem2 = new ACRadioButtonItem();

      rehabilitationSpecialistPersonnelCooperationItem2.setText("I型");

      rehabilitationSpecialistPersonnelCooperationItem2.setGroup(getRehabilitationSpecialistPersonnelCooperationRadioGroup());

      rehabilitationSpecialistPersonnelCooperationItem2.setConstraints(VRLayout.FLOW);

      addRehabilitationSpecialistPersonnelCooperationItem2();
    }
    return rehabilitationSpecialistPersonnelCooperationItem2;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getRehabilitationSpecialistPersonnelCooperationItem3(){
    if(rehabilitationSpecialistPersonnelCooperationItem3==null){

      rehabilitationSpecialistPersonnelCooperationItem3 = new ACRadioButtonItem();

      rehabilitationSpecialistPersonnelCooperationItem3.setText("II型");

      rehabilitationSpecialistPersonnelCooperationItem3.setGroup(getRehabilitationSpecialistPersonnelCooperationRadioGroup());

      rehabilitationSpecialistPersonnelCooperationItem3.setConstraints(VRLayout.FLOW);

      addRehabilitationSpecialistPersonnelCooperationItem3();
    }
    return rehabilitationSpecialistPersonnelCooperationItem3;

  }

  /**
   * 栄養スクリーニング加算を取得します。
   * @return 栄養スクリーニング加算
   */
  public ACValueArrayRadioButtonGroup getNutritionScreening(){
    if(nutritionScreening==null){

      nutritionScreening = new ACValueArrayRadioButtonGroup();

      getNutritionScreeningContainer().setText("栄養スクリーニング加算");

      nutritionScreening.setBindPath("1730119");

      nutritionScreening.setUseClearButton(false);

      nutritionScreening.setModel(getNutritionScreeningModel());

      nutritionScreening.setValues(new int[]{1,2});

      addNutritionScreening();
    }
    return nutritionScreening;

  }

  /**
   * 栄養スクリーニング加算コンテナを取得します。
   * @return 栄養スクリーニング加算コンテナ
   */
  protected ACLabelContainer getNutritionScreeningContainer(){
    if(nutritionScreeningContainer==null){
      nutritionScreeningContainer = new ACLabelContainer();
      nutritionScreeningContainer.setFollowChildEnabled(true);
      nutritionScreeningContainer.setVAlignment(VRLayout.CENTER);
      nutritionScreeningContainer.add(getNutritionScreening(), null);
    }
    return nutritionScreeningContainer;
  }

  /**
   * 栄養スクリーニング加算モデルを取得します。
   * @return 栄養スクリーニング加算モデル
   */
  protected ACListModelAdapter getNutritionScreeningModel(){
    if(nutritionScreeningModel==null){
      nutritionScreeningModel = new ACListModelAdapter();
      addNutritionScreeningModel();
    }
    return nutritionScreeningModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNutritionScreeningItem1(){
    if(nutritionScreeningItem1==null){

      nutritionScreeningItem1 = new ACRadioButtonItem();

      nutritionScreeningItem1.setText("なし");

      nutritionScreeningItem1.setGroup(getNutritionScreening());

      addNutritionScreeningItem1();
    }
    return nutritionScreeningItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getNutritionScreeningItem2(){
    if(nutritionScreeningItem2==null){

      nutritionScreeningItem2 = new ACRadioButtonItem();

      nutritionScreeningItem2.setText("あり");

      nutritionScreeningItem2.setGroup(getNutritionScreening());

      addNutritionScreeningItem2();
    }
    return nutritionScreeningItem2;

  }

  /**
   * 算定区分を取得します。
   * @return 算定区分
   */
  public ACValueArrayRadioButtonGroup getCalculationDivision(){
    if(calculationDivision==null){

      calculationDivision = new ACValueArrayRadioButtonGroup();

      getCalculationDivisionContainer().setText("算定区分");

      calculationDivision.setBindPath("9");

      calculationDivision.setUseClearButton(false);

      calculationDivision.setModel(getCalculationDivisionModel());

      calculationDivision.setValues(new int[]{1,2});

      addCalculationDivision();
    }
    return calculationDivision;

  }

  /**
   * 算定区分コンテナを取得します。
   * @return 算定区分コンテナ
   */
  protected ACLabelContainer getCalculationDivisionContainer(){
    if(calculationDivisionContainer==null){
      calculationDivisionContainer = new ACLabelContainer();
      calculationDivisionContainer.setFollowChildEnabled(true);
      calculationDivisionContainer.setVAlignment(VRLayout.CENTER);
      calculationDivisionContainer.add(getCalculationDivision(), null);
    }
    return calculationDivisionContainer;
  }

  /**
   * 算定区分モデルを取得します。
   * @return 算定区分モデル
   */
  protected ACListModelAdapter getCalculationDivisionModel(){
    if(calculationDivisionModel==null){
      calculationDivisionModel = new ACListModelAdapter();
      addCalculationDivisionModel();
    }
    return calculationDivisionModel;
  }

  /**
   * 通常を取得します。
   * @return 通常
   */
  public ACRadioButtonItem getCalculationDivisionItem1(){
    if(calculationDivisionItem1==null){

      calculationDivisionItem1 = new ACRadioButtonItem();

      calculationDivisionItem1.setText("通常");

      calculationDivisionItem1.setGroup(getCalculationDivision());

      calculationDivisionItem1.setConstraints(VRLayout.FLOW);

      addCalculationDivisionItem1();
    }
    return calculationDivisionItem1;

  }

  /**
   * 加算のみを取得します。
   * @return 加算のみ
   */
  public ACRadioButtonItem getCalculationDivisionItem2(){
    if(calculationDivisionItem2==null){

      calculationDivisionItem2 = new ACRadioButtonItem();

      calculationDivisionItem2.setText("加算のみ");

      calculationDivisionItem2.setGroup(getCalculationDivision());

      calculationDivisionItem2.setConstraints(VRLayout.FLOW);

      addCalculationDivisionItem2();
    }
    return calculationDivisionItem2;

  }

  /**
   * タブ3を取得します。
   * @return タブ3
   */
  public ACPanel getTab3(){
    if(tab3==null){

      tab3 = new ACPanel();

      tab3.setFollowChildEnabled(true);

      tab3.setHgap(0);

      tab3.setLabelMargin(0);

      tab3.setVgap(0);

      addTab3();
    }
    return tab3;

  }

  /**
   * 日割を取得します。
   * @return 日割
   */
  public ACIntegerCheckBox getCrackOnDayCheck(){
    if(crackOnDayCheck==null){

      crackOnDayCheck = new ACIntegerCheckBox();

      crackOnDayCheck.setText("日割");

      crackOnDayCheck.setBindPath("1730103");

      crackOnDayCheck.setSelectValue(2);

      crackOnDayCheck.setUnSelectValue(1);

      addCrackOnDayCheck();
    }
    return crackOnDayCheck;

  }

  /**
   * 提供日を取得します。
   * @return 提供日
   */
  public ACIntegerCheckBox getPrintable(){
    if(printable==null){

      printable = new ACIntegerCheckBox();

      printable.setText("提供日");

      printable.setBindPath("15");

      printable.setSelectValue(2);

      printable.setUnSelectValue(1);

      addPrintable();
    }
    return printable;

  }

  /**
   * 注意書きグループを取得します。
   * @return 注意書きグループ
   */
  public ACGroupBox getInfoGroup(){
    if(infoGroup==null){

      infoGroup = new ACGroupBox();

      infoGroup.setFollowChildEnabled(true);

      infoGroup.setHgap(0);

      infoGroup.setLabelMargin(0);

      infoGroup.setVgap(0);

      addInfoGroup();
    }
    return infoGroup;

  }

  /**
   * 注意書きラベルを取得します。
   * @return 注意書きラベル
   */
  public ACLabel getInfoLabel(){
    if(infoLabel==null){

      infoLabel = new ACLabel();

      infoLabel.setText("月途中で要介護状態区分が変更になる場合は、" + ACConstants.LINE_SEPARATOR + "各日割りサービスを全ての日数に貼り付け、" + ACConstants.LINE_SEPARATOR + "実際の提供日には『提供日』のチェックをつけ" + ACConstants.LINE_SEPARATOR + "〔設定〕ボタンをクリックしてください。");

      addInfoLabel();
    }
    return infoLabel;

  }

  /**
   * 介護支援専門員コンテナを取得します。
   * @return 介護支援専門員コンテナ
   */
  public ACGroupBox getKaigoSupportSpecialMemberContainer(){
    if(kaigoSupportSpecialMemberContainer==null){

      kaigoSupportSpecialMemberContainer = new ACGroupBox();

      kaigoSupportSpecialMemberContainer.setText("介護支援専門員情報");

      kaigoSupportSpecialMemberContainer.setFollowChildEnabled(true);

      addKaigoSupportSpecialMemberContainer();
    }
    return kaigoSupportSpecialMemberContainer;

  }

  /**
   * 介護支援専門員番号を取得します。
   * @return 介護支援専門員番号
   */
  public ACTextField getKaigoSupportSpecialMemberNumber(){
    if(kaigoSupportSpecialMemberNumber==null){

      kaigoSupportSpecialMemberNumber = new ACTextField();

      getKaigoSupportSpecialMemberNumberContainer().setText("介護支援専門員番号");

      kaigoSupportSpecialMemberNumber.setBindPath("1730104");

      kaigoSupportSpecialMemberNumber.setColumns(6);

      kaigoSupportSpecialMemberNumber.setCharType(VRCharType.ONLY_DIGIT);

      kaigoSupportSpecialMemberNumber.setMaxLength(8);

      addKaigoSupportSpecialMemberNumber();
    }
    return kaigoSupportSpecialMemberNumber;

  }

  /**
   * 介護支援専門員番号コンテナを取得します。
   * @return 介護支援専門員番号コンテナ
   */
  protected ACLabelContainer getKaigoSupportSpecialMemberNumberContainer(){
    if(kaigoSupportSpecialMemberNumberContainer==null){
      kaigoSupportSpecialMemberNumberContainer = new ACLabelContainer();
      kaigoSupportSpecialMemberNumberContainer.setFollowChildEnabled(true);
      kaigoSupportSpecialMemberNumberContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportSpecialMemberNumberContainer.add(getKaigoSupportSpecialMemberNumber(), null);
    }
    return kaigoSupportSpecialMemberNumberContainer;
  }

  /**
   * 介護支援専門員氏名を取得します。
   * @return 介護支援専門員氏名
   */
  public ACComboBox getKaigoSupportSpecialMemberName(){
    if(kaigoSupportSpecialMemberName==null){

      kaigoSupportSpecialMemberName = new ACComboBox();

      getKaigoSupportSpecialMemberNameContainer().setText("介護支援専門員氏名");

      kaigoSupportSpecialMemberName.setEditable(false);

      kaigoSupportSpecialMemberName.setRenderBindPath("STAFF_NAME");

      kaigoSupportSpecialMemberName.setMaxColumns(10);

      kaigoSupportSpecialMemberName.setModel(getKaigoSupportSpecialMemberNameModel());

      addKaigoSupportSpecialMemberName();
    }
    return kaigoSupportSpecialMemberName;

  }

  /**
   * 介護支援専門員氏名コンテナを取得します。
   * @return 介護支援専門員氏名コンテナ
   */
  protected ACLabelContainer getKaigoSupportSpecialMemberNameContainer(){
    if(kaigoSupportSpecialMemberNameContainer==null){
      kaigoSupportSpecialMemberNameContainer = new ACLabelContainer();
      kaigoSupportSpecialMemberNameContainer.setFollowChildEnabled(true);
      kaigoSupportSpecialMemberNameContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportSpecialMemberNameContainer.add(getKaigoSupportSpecialMemberName(), null);
    }
    return kaigoSupportSpecialMemberNameContainer;
  }

  /**
   * 介護支援専門員氏名モデルを取得します。
   * @return 介護支援専門員氏名モデル
   */
  protected ACComboBoxModelAdapter getKaigoSupportSpecialMemberNameModel(){
    if(kaigoSupportSpecialMemberNameModel==null){
      kaigoSupportSpecialMemberNameModel = new ACComboBoxModelAdapter();
      addKaigoSupportSpecialMemberNameModel();
    }
    return kaigoSupportSpecialMemberNameModel;
  }

  /**
   * 摘要欄説明グループを取得します。
   * @return 摘要欄説明グループ
   */
  public ACGroupBox getTekiyouGroup(){
    if(tekiyouGroup==null){

      tekiyouGroup = new ACGroupBox();

      tekiyouGroup.setText("摘要欄");

      tekiyouGroup.setVisible(true);

      tekiyouGroup.setEnabled(true);

      tekiyouGroup.setFollowChildEnabled(true);

      tekiyouGroup.setHgap(0);

      tekiyouGroup.setLabelMargin(0);

      tekiyouGroup.setVgap(0);

      addTekiyouGroup();
    }
    return tekiyouGroup;

  }

  /**
   * 摘要欄テキストを取得します。
   * @return 摘要欄テキスト
   */
  public ACTextField getTekiyouText(){
    if(tekiyouText==null){

      tekiyouText = new ACTextField();

      getTekiyouTextContainer().setText("通所訪問宿泊日数");

      tekiyouText.setBindPath("1730105");

      tekiyouText.setVisible(true);

      tekiyouText.setEnabled(true);

      tekiyouText.setEditable(true);

      tekiyouText.setColumns(5);

      tekiyouText.setCharType(VRCharType.ONLY_DIGIT);

      tekiyouText.setHorizontalAlignment(SwingConstants.LEFT);

      tekiyouText.setIMEMode(InputSubset.LATIN);

      tekiyouText.setMaxLength(6);

      addTekiyouText();
    }
    return tekiyouText;

  }

  /**
   * 摘要欄テキストコンテナを取得します。
   * @return 摘要欄テキストコンテナ
   */
  protected ACLabelContainer getTekiyouTextContainer(){
    if(tekiyouTextContainer==null){
      tekiyouTextContainer = new ACLabelContainer();
      tekiyouTextContainer.setFollowChildEnabled(true);
      tekiyouTextContainer.setVAlignment(VRLayout.CENTER);
      tekiyouTextContainer.add(getTekiyouText(), null);
    }
    return tekiyouTextContainer;
  }

  /**
   * 摘要欄説明ラベルを取得します。
   * @return 摘要欄説明ラベル
   */
  public ACLabel getTekiyouCommentTitle(){
    if(tekiyouCommentTitle==null){

      tekiyouCommentTitle = new ACLabel();

      tekiyouCommentTitle.setText("月の一番最初の利用日に記入してください。");

      tekiyouCommentTitle.setIconPath(ACConstants.ICON_PATH_EXCLAMATION_16);

      tekiyouCommentTitle.setAutoWrap(true);

      addTekiyouCommentTitle();
    }
    return tekiyouCommentTitle;

  }

  /**
   * コンストラクタです。
   */
  public QS001_17311_201804Design() {

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

    this.add(getRegionSmallscaleMultiPatterns(), VRLayout.CLIENT);

  }

  /**
   * 地域密着小規模多機能型介護パターン領域に内部項目を追加します。
   */
  protected void addRegionSmallscaleMultiPatterns(){

    regionSmallscaleMultiPatterns.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * タブパネルに内部項目を追加します。
   */
  protected void addTabs(){

    tabs.addTab("1", getTab1());

    tabs.addTab("2", getTab2());

    tabs.addTab("3", getTab3());

  }

  /**
   * タブ1に内部項目を追加します。
   */
  protected void addTab1(){

    tab1.add(getInitialAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getSmallServiceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getStaffSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getDementiaAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getNurseStaffDispositionAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonNeededRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMunicipalityAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 初期加算に内部項目を追加します。
   */
  protected void addInitialAddRadio(){

  }

  /**
   * 初期加算モデルに内部項目を追加します。
   */
  protected void addInitialAddRadioModel(){

    getInitialAddRadioItem1().setButtonIndex(1);

    getInitialAddRadioModel().add(getInitialAddRadioItem1());

    getInitialAddRadioItem2().setButtonIndex(2);

    getInitialAddRadioModel().add(getInitialAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addInitialAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addInitialAddRadioItem2(){

  }

  /**
   * 過小サービスに対する減算に内部項目を追加します。
   */
  protected void addSmallServiceRadio(){

  }

  /**
   * 過小サービスに対する減算モデルに内部項目を追加します。
   */
  protected void addSmallServiceRadioModel(){

    getSmallServiceRadioItem1().setButtonIndex(1);

    getSmallServiceRadioModel().add(getSmallServiceRadioItem1());

    getSmallServiceRadioItem2().setButtonIndex(2);

    getSmallServiceRadioModel().add(getSmallServiceRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSmallServiceRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addSmallServiceRadioItem2(){

  }

  /**
   * 人員減算に内部項目を追加します。
   */
  protected void addStaffSubtractionRadio(){

  }

  /**
   * 人員減算モデルに内部項目を追加します。
   */
  protected void addStaffSubtractionRadioModel(){

    getStaffSubtractionRadioItem1().setButtonIndex(1);

    getStaffSubtractionRadioModel().add(getStaffSubtractionRadioItem1());

    getStaffSubtractionRadioItem2().setButtonIndex(2);

    getStaffSubtractionRadioModel().add(getStaffSubtractionRadioItem2());

    getStaffSubtractionRadioItem3().setButtonIndex(3);

    getStaffSubtractionRadioModel().add(getStaffSubtractionRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addStaffSubtractionRadioItem1(){

  }

  /**
   * 定員超過に内部項目を追加します。
   */
  protected void addStaffSubtractionRadioItem2(){

  }

  /**
   * 従業者の不足に内部項目を追加します。
   */
  protected void addStaffSubtractionRadioItem3(){

  }

  /**
   * 認知症加算に内部項目を追加します。
   */
  protected void addDementiaAddRadioGroup(){

  }

  /**
   * 認知症加算モデルに内部項目を追加します。
   */
  protected void addDementiaAddRadioGroupModel(){

    getDementiaAddRadioItem1().setButtonIndex(1);

    getDementiaAddRadioGroupModel().add(getDementiaAddRadioItem1());

    getDementiaAddRadioItem2().setButtonIndex(2);

    getDementiaAddRadioGroupModel().add(getDementiaAddRadioItem2());

    getDementiaAddRadioItem3().setButtonIndex(3);

    getDementiaAddRadioGroupModel().add(getDementiaAddRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addDementiaAddRadioItem1(){

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addDementiaAddRadioItem2(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addDementiaAddRadioItem3(){

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
   * I型に内部項目を追加します。
   */
  protected void addNurseStaffDispositionAddRadioItem2(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addNurseStaffDispositionAddRadioItem3(){

  }

  /**
   * III型に内部項目を追加します。
   */
  protected void addNurseStaffDispositionAddRadioItem4(){

  }

  /**
   * 同一建物居住者へのサービス提供に内部項目を追加します。
   */
  protected void addHoumonNeededRadio(){

  }

  /**
   * 同一建物居住者へのサービス提供モデルに内部項目を追加します。
   */
  protected void addHoumonNeededRadioModel(){

    getHoumonNeededRadioItem1().setButtonIndex(1);

    getHoumonNeededRadioModel().add(getHoumonNeededRadioItem1());

    getHoumonNeededRadioItem2().setButtonIndex(2);

    getHoumonNeededRadioModel().add(getHoumonNeededRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonNeededRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonNeededRadioItem2(){

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

    getServiceAddProvisionStructuralRadioItem5().setButtonIndex(5);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem5());

    getServiceAddProvisionStructuralRadioItem2().setButtonIndex(2);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem2());

    getServiceAddProvisionStructuralRadioItem3().setButtonIndex(3);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem3());

    getServiceAddProvisionStructuralRadioItem4().setButtonIndex(4);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem4());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * Iイ型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem5(){

  }

  /**
   * Iロ型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem3(){

  }

  /**
   * III型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem4(){

  }

  /**
   * 市町村独自加算に内部項目を追加します。
   */
  protected void addMunicipalityAdd(){

  }

  /**
   * 市町村独自加算モデルに内部項目を追加します。
   */
  protected void addMunicipalityAddModel(){

  }

  /**
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getProviderAddMountainousAreaRafioRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getTerminalCareInformationRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getTerminalCareInformationAddDaysContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getVisitStrengthenAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getComprehensiveManagementSystemRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getRehabilitationSpecialistPersonnelCooperationRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getNutritionScreeningContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getCalculationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 中山間地域等でのサービス提供加算に内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRafioRadioGroup(){

  }

  /**
   * 中山間地域等でのサービス提供加算モデルに内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRafioRadioGroupModel(){

    getProviderAddMountainousAreaRafioItem1().setButtonIndex(1);

    getProviderAddMountainousAreaRafioRadioGroupModel().add(getProviderAddMountainousAreaRafioItem1());

    getProviderAddMountainousAreaRafioRadioItem2().setButtonIndex(2);

    getProviderAddMountainousAreaRafioRadioGroupModel().add(getProviderAddMountainousAreaRafioRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRafioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRafioRadioItem2(){

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
   * 看取り連携体制加算コンテナに内部項目を追加します。
   */
  protected void addTerminalCareInformationAddDaysContainer(){

    terminalCareInformationAddDaysContainer.add(getTerminalCareInformationAddDays(), VRLayout.FLOW);

    terminalCareInformationAddDaysContainer.add(getTerminalCareInformationAddDaysUnit(), VRLayout.FLOW);

  }

  /**
   * 看取り連携体制加算日数に内部項目を追加します。
   */
  protected void addTerminalCareInformationAddDays(){

  }

  /**
   * 看取り連携体制加算日数単位に内部項目を追加します。
   */
  protected void addTerminalCareInformationAddDaysUnit(){

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
   * 若年性認知症受入加算に内部項目を追加します。
   */
  protected void addYoungDementiaPatinetAddRadioGroup(){

  }

  /**
   * 若年性認知症受入加算モデルに内部項目を追加します。
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
   * 生活機能向上連携加算に内部項目を追加します。
   */
  protected void addRehabilitationSpecialistPersonnelCooperationRadioGroup(){

  }

  /**
   * 生活機能向上連携加算モデルに内部項目を追加します。
   */
  protected void addRehabilitationSpecialistPersonnelCooperationRadioGroupModel(){

    getRehabilitationSpecialistPersonnelCooperationItem1().setButtonIndex(1);

    getRehabilitationSpecialistPersonnelCooperationRadioGroupModel().add(getRehabilitationSpecialistPersonnelCooperationItem1());

    getRehabilitationSpecialistPersonnelCooperationItem2().setButtonIndex(2);

    getRehabilitationSpecialistPersonnelCooperationRadioGroupModel().add(getRehabilitationSpecialistPersonnelCooperationItem2());

    getRehabilitationSpecialistPersonnelCooperationItem3().setButtonIndex(3);

    getRehabilitationSpecialistPersonnelCooperationRadioGroupModel().add(getRehabilitationSpecialistPersonnelCooperationItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addRehabilitationSpecialistPersonnelCooperationItem1(){

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addRehabilitationSpecialistPersonnelCooperationItem2(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addRehabilitationSpecialistPersonnelCooperationItem3(){

  }

  /**
   * 栄養スクリーニング加算に内部項目を追加します。
   */
  protected void addNutritionScreening(){

  }

  /**
   * 栄養スクリーニング加算モデルに内部項目を追加します。
   */
  protected void addNutritionScreeningModel(){

    getNutritionScreeningItem1().setButtonIndex(1);

    getNutritionScreeningModel().add(getNutritionScreeningItem1());

    getNutritionScreeningItem2().setButtonIndex(2);

    getNutritionScreeningModel().add(getNutritionScreeningItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNutritionScreeningItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addNutritionScreeningItem2(){

  }

  /**
   * 算定区分に内部項目を追加します。
   */
  protected void addCalculationDivision(){

  }

  /**
   * 算定区分モデルに内部項目を追加します。
   */
  protected void addCalculationDivisionModel(){

    getCalculationDivisionItem1().setButtonIndex(1);

    getCalculationDivisionModel().add(getCalculationDivisionItem1());

    getCalculationDivisionItem2().setButtonIndex(2);

    getCalculationDivisionModel().add(getCalculationDivisionItem2());

  }

  /**
   * 通常に内部項目を追加します。
   */
  protected void addCalculationDivisionItem1(){

  }

  /**
   * 加算のみに内部項目を追加します。
   */
  protected void addCalculationDivisionItem2(){

  }

  /**
   * タブ3に内部項目を追加します。
   */
  protected void addTab3(){

    tab3.add(getCrackOnDayCheck(), VRLayout.FLOW_INSETLINE);

    tab3.add(getPrintable(), VRLayout.FLOW_RETURN);

    tab3.add(getInfoGroup(), VRLayout.FLOW);

    tab3.add(getKaigoSupportSpecialMemberContainer(), VRLayout.FLOW_RETURN);

    tab3.add(getTekiyouGroup(), VRLayout.FLOW_RETURN);

  }

  /**
   * 日割に内部項目を追加します。
   */
  protected void addCrackOnDayCheck(){

  }

  /**
   * 提供日に内部項目を追加します。
   */
  protected void addPrintable(){

  }

  /**
   * 注意書きグループに内部項目を追加します。
   */
  protected void addInfoGroup(){

    infoGroup.add(getInfoLabel(), VRLayout.FLOW);

  }

  /**
   * 注意書きラベルに内部項目を追加します。
   */
  protected void addInfoLabel(){

  }

  /**
   * 介護支援専門員コンテナに内部項目を追加します。
   */
  protected void addKaigoSupportSpecialMemberContainer(){

    kaigoSupportSpecialMemberContainer.add(getKaigoSupportSpecialMemberNumberContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoSupportSpecialMemberContainer.add(getKaigoSupportSpecialMemberNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 介護支援専門員番号に内部項目を追加します。
   */
  protected void addKaigoSupportSpecialMemberNumber(){

  }

  /**
   * 介護支援専門員氏名に内部項目を追加します。
   */
  protected void addKaigoSupportSpecialMemberName(){

  }

  /**
   * 介護支援専門員氏名モデルに内部項目を追加します。
   */
  protected void addKaigoSupportSpecialMemberNameModel(){

  }

  /**
   * 摘要欄説明グループに内部項目を追加します。
   */
  protected void addTekiyouGroup(){

    tekiyouGroup.add(getTekiyouTextContainer(), VRLayout.FLOW_RETURN);

    tekiyouGroup.add(getTekiyouCommentTitle(), VRLayout.FLOW_RETURN);

  }

  /**
   * 摘要欄テキストに内部項目を追加します。
   */
  protected void addTekiyouText(){

  }

  /**
   * 摘要欄説明ラベルに内部項目を追加します。
   */
  protected void addTekiyouCommentTitle(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_17311_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_17311_201804Design getThis() {
    return this;
  }
}
