
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
 * 開発者: 上司　和善
 * 作成日: 2012/03/07  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン複合型サービスI (QS001_17711_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACIntegerCheckBox;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.ACTimeComboBox;
import jp.nichicom.ac.component.ACValueArrayRadioButtonGroup;
import jp.nichicom.ac.container.ACBackLabelContainer;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * サービスパターン複合型サービスI画面項目デザイン(QS001_17711_201204) 
 */
public class QS001_17711_201204Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel mainGroup;

  private JTabbedPane tab;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup staffSubtractionRadio;

  private ACLabelContainer staffSubtractionRadioContainer;

  private ACListModelAdapter staffSubtractionRadioModel;

  private ACRadioButtonItem staffSubtractionRadioItem1;

  private ACRadioButtonItem staffSubtractionRadioItem2;

  private ACRadioButtonItem staffSubtractionRadioItem3;

  private ACValueArrayRadioButtonGroup smallServiceRadio;

  private ACLabelContainer smallServiceRadioContainer;

  private ACListModelAdapter smallServiceRadioModel;

  private ACRadioButtonItem smallServiceRadioItem1;

  private ACRadioButtonItem smallServiceRadioItem2;

  private ACValueArrayRadioButtonGroup initialAddRadio;

  private ACLabelContainer initialAddRadioContainer;

  private ACListModelAdapter initialAddRadioModel;

  private ACRadioButtonItem initialAddRadioItem1;

  private ACRadioButtonItem initialAddRadioItem2;

  private ACValueArrayRadioButtonGroup dementiaRadio;

  private ACLabelContainer dementiaRadioContainer;

  private ACListModelAdapter dementiaRadioModel;

  private ACRadioButtonItem dementiaRadioItem1;

  private ACRadioButtonItem dementiaRadioItem2;

  private ACRadioButtonItem dementiaRadioItem3;

  private ACValueArrayRadioButtonGroup leavingHospitalGuidanceAddRadio;

  private ACLabelContainer leavingHospitalGuidanceAddRadioContainer;

  private ACListModelAdapter leavingHospitalGuidanceAddRadioModel;

  private ACRadioButtonItem leavingHospitalGuidanceAddRadioItem1;

  private ACRadioButtonItem leavingHospitalGuidanceAddRadioItem2;

  private ACValueArrayRadioButtonGroup businessBeginnerAddRadio;

  private ACLabelContainer businessBeginnerAddRadioContainer;

  private ACListModelAdapter businessBeginnerAddRadioModel;

  private ACRadioButtonItem businessBeginnerAddRadioItem1;

  private ACRadioButtonItem businessBeginnerAddRadioItem2;

  private ACValueArrayRadioButtonGroup urgentTimeAddRadio;

  private ACLabelContainer urgentTimeAddRadioContainer;

  private ACListModelAdapter urgentTimeAddRadioModel;

  private ACRadioButtonItem urgentTimeAddRadioItem1;

  private ACRadioButtonItem urgentTimeAddRadioItem2;

  private ACValueArrayRadioButtonGroup serviceProvisionStructuralAddRadio;

  private ACLabelContainer serviceProvisionStructuralAddRadioContainer;

  private ACListModelAdapter serviceProvisionStructuralAddRadioModel;

  private ACRadioButtonItem serviceProvisionStructuralAddRadioItem1;

  private ACRadioButtonItem serviceProvisionStructuralAddRadioItem2;

  private ACRadioButtonItem serviceProvisionStructuralAddRadioItem3;

  private ACRadioButtonItem serviceProvisionStructuralAddRadioItem4;

  private ACValueArrayRadioButtonGroup specialManagementRadio;

  private ACLabelContainer specialManagementRadioContainer;

  private ACListModelAdapter specialManagementRadioModel;

  private ACRadioButtonItem specialManagementRadioItem1;

  private ACRadioButtonItem specialManagementRadioItem2;

  private ACRadioButtonItem specialManagementRadioItem3;

  private ACValueArrayRadioButtonGroup terminalCareAddRadio;

  private ACLabelContainer terminalCareAddRadioContainer;

  private ACListModelAdapter terminalCareAddRadioModel;

  private ACRadioButtonItem terminalCareAddRadioItem1;

  private ACRadioButtonItem terminalCareAddRadioItem2;

  private ACPanel tab2;

  private ACComboBox serviceMunicipalityAdd;

  private ACLabelContainer serviceMunicipalityAddContainer;

  private ACComboBoxModelAdapter serviceMunicipalityAddModel;

  private ACValueArrayRadioButtonGroup subtractVisitingNurseRadioGroup;

  private ACLabelContainer subtractVisitingNurseRadioGroupContainer;

  private ACListModelAdapter subtractVisitingNurseRadioGroupModel;

  private ACRadioButtonItem subtractVisitingNurseRadioItem1;

  private ACRadioButtonItem subtractVisitingNurseRadioItem2;

  private ACValueArrayRadioButtonGroup subtractSpecialVisitingNursingSupportRadioGroup;

  private ACLabelContainer subtractSpecialVisitingNursingSupportRadioGroupContainer;

  private ACListModelAdapter subtractSpecialVisitingNursingSupportRadioGroupModel;

  private ACRadioButtonItem subtractSpecialVisitingNursingSupportRadioItem1;

  private ACRadioButtonItem subtractSpecialVisitingNursingSupportRadioItem2;

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

  private ACValueArrayRadioButtonGroup calculationDivision;

  private ACLabelContainer calculationDivisionContainer;

  private ACListModelAdapter calculationDivisionModel;

  private ACRadioButtonItem calculationDivisionNormal;

  private ACRadioButtonItem calculationDivisionAddOnly;

  private ACIntegerCheckBox crackOnDayCheck;

  private ACIntegerCheckBox printable;

  private ACBackLabelContainer homonNyuyokuTimeContainer;

  private ACTimeComboBox homonNyuyokuBeginTime;

  private ACLabelContainer homonNyuyokuBeginTimeContainer;

  private ACComboBoxModelAdapter homonNyuyokuBeginTimeModel;

  private ACTimeComboBox homonNyuyokuEndTime;

  private ACLabelContainer homonNyuyokuEndTimeContainer;

  private ACComboBoxModelAdapter homonNyuyokuEndTimeModel;

  //getter

  /**
   * パターン領域を取得します。
   * @return パターン領域
   */
  public ACPanel getMainGroup(){
    if(mainGroup==null){

      mainGroup = new ACPanel();

      mainGroup.setFollowChildEnabled(true);

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
   * タブ1を取得します。
   * @return タブ1
   */
  public ACPanel getTab1(){
    if(tab1==null){

      tab1 = new ACPanel();

      tab1.setFollowChildEnabled(true);

      tab1.setHgap(0);

      addTab1();
    }
    return tab1;

  }

  /**
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACValueArrayRadioButtonGroup getStaffSubtractionRadio(){
    if(staffSubtractionRadio==null){

      staffSubtractionRadio = new ACValueArrayRadioButtonGroup();

      getStaffSubtractionRadioContainer().setText("人員減算");

      staffSubtractionRadio.setBindPath("1770101");

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
   * 従業員の不足を取得します。
   * @return 従業員の不足
   */
  public ACRadioButtonItem getStaffSubtractionRadioItem3(){
    if(staffSubtractionRadioItem3==null){

      staffSubtractionRadioItem3 = new ACRadioButtonItem();

      staffSubtractionRadioItem3.setText("従業員の不足");

      staffSubtractionRadioItem3.setGroup(getStaffSubtractionRadio());

      staffSubtractionRadioItem3.setConstraints(VRLayout.FLOW);

      addStaffSubtractionRadioItem3();
    }
    return staffSubtractionRadioItem3;

  }

  /**
   * 過小サービスに対する減算を取得します。
   * @return 過小サービスに対する減算
   */
  public ACValueArrayRadioButtonGroup getSmallServiceRadio(){
    if(smallServiceRadio==null){

      smallServiceRadio = new ACValueArrayRadioButtonGroup();

      getSmallServiceRadioContainer().setText("過小サービスに対する減算");

      smallServiceRadio.setBindPath("1770102");

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
   * 初期加算を取得します。
   * @return 初期加算
   */
  public ACValueArrayRadioButtonGroup getInitialAddRadio(){
    if(initialAddRadio==null){

      initialAddRadio = new ACValueArrayRadioButtonGroup();

      getInitialAddRadioContainer().setText("初期加算");

      initialAddRadio.setBindPath("1770104");

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
   * 認知症加算を取得します。
   * @return 認知症加算
   */
  public ACValueArrayRadioButtonGroup getDementiaRadio(){
    if(dementiaRadio==null){

      dementiaRadio = new ACValueArrayRadioButtonGroup();

      getDementiaRadioContainer().setText("認知症加算");

      dementiaRadio.setBindPath("1770105");

      dementiaRadio.setUseClearButton(false);

      dementiaRadio.setModel(getDementiaRadioModel());

      dementiaRadio.setValues(new int[]{1,2,3});

      addDementiaRadio();
    }
    return dementiaRadio;

  }

  /**
   * 認知症加算コンテナを取得します。
   * @return 認知症加算コンテナ
   */
  protected ACLabelContainer getDementiaRadioContainer(){
    if(dementiaRadioContainer==null){
      dementiaRadioContainer = new ACLabelContainer();
      dementiaRadioContainer.setFollowChildEnabled(true);
      dementiaRadioContainer.setVAlignment(VRLayout.CENTER);
      dementiaRadioContainer.add(getDementiaRadio(), null);
    }
    return dementiaRadioContainer;
  }

  /**
   * 認知症加算モデルを取得します。
   * @return 認知症加算モデル
   */
  protected ACListModelAdapter getDementiaRadioModel(){
    if(dementiaRadioModel==null){
      dementiaRadioModel = new ACListModelAdapter();
      addDementiaRadioModel();
    }
    return dementiaRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getDementiaRadioItem1(){
    if(dementiaRadioItem1==null){

      dementiaRadioItem1 = new ACRadioButtonItem();

      dementiaRadioItem1.setText("なし");

      dementiaRadioItem1.setGroup(getDementiaRadio());

      dementiaRadioItem1.setConstraints(VRLayout.FLOW);

      addDementiaRadioItem1();
    }
    return dementiaRadioItem1;

  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getDementiaRadioItem2(){
    if(dementiaRadioItem2==null){

      dementiaRadioItem2 = new ACRadioButtonItem();

      dementiaRadioItem2.setText("I型");

      dementiaRadioItem2.setGroup(getDementiaRadio());

      dementiaRadioItem2.setConstraints(VRLayout.FLOW);

      addDementiaRadioItem2();
    }
    return dementiaRadioItem2;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getDementiaRadioItem3(){
    if(dementiaRadioItem3==null){

      dementiaRadioItem3 = new ACRadioButtonItem();

      dementiaRadioItem3.setText("II型");

      dementiaRadioItem3.setGroup(getDementiaRadio());

      dementiaRadioItem3.setConstraints(VRLayout.FLOW);

      addDementiaRadioItem3();
    }
    return dementiaRadioItem3;

  }

  /**
   * 退院時共同指導加算を取得します。
   * @return 退院時共同指導加算
   */
  public ACValueArrayRadioButtonGroup getLeavingHospitalGuidanceAddRadio(){
    if(leavingHospitalGuidanceAddRadio==null){

      leavingHospitalGuidanceAddRadio = new ACValueArrayRadioButtonGroup();

      getLeavingHospitalGuidanceAddRadioContainer().setText("退院時共同指導加算");

      leavingHospitalGuidanceAddRadio.setBindPath("1770106");

      leavingHospitalGuidanceAddRadio.setNoSelectIndex(0);

      leavingHospitalGuidanceAddRadio.setUseClearButton(false);

      leavingHospitalGuidanceAddRadio.setModel(getLeavingHospitalGuidanceAddRadioModel());

      leavingHospitalGuidanceAddRadio.setValues(new int[]{1,2});

      addLeavingHospitalGuidanceAddRadio();
    }
    return leavingHospitalGuidanceAddRadio;

  }

  /**
   * 退院時共同指導加算コンテナを取得します。
   * @return 退院時共同指導加算コンテナ
   */
  protected ACLabelContainer getLeavingHospitalGuidanceAddRadioContainer(){
    if(leavingHospitalGuidanceAddRadioContainer==null){
      leavingHospitalGuidanceAddRadioContainer = new ACLabelContainer();
      leavingHospitalGuidanceAddRadioContainer.setFollowChildEnabled(true);
      leavingHospitalGuidanceAddRadioContainer.setVAlignment(VRLayout.CENTER);
      leavingHospitalGuidanceAddRadioContainer.add(getLeavingHospitalGuidanceAddRadio(), null);
    }
    return leavingHospitalGuidanceAddRadioContainer;
  }

  /**
   * 退院時共同指導加算モデルを取得します。
   * @return 退院時共同指導加算モデル
   */
  protected ACListModelAdapter getLeavingHospitalGuidanceAddRadioModel(){
    if(leavingHospitalGuidanceAddRadioModel==null){
      leavingHospitalGuidanceAddRadioModel = new ACListModelAdapter();
      addLeavingHospitalGuidanceAddRadioModel();
    }
    return leavingHospitalGuidanceAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getLeavingHospitalGuidanceAddRadioItem1(){
    if(leavingHospitalGuidanceAddRadioItem1==null){

      leavingHospitalGuidanceAddRadioItem1 = new ACRadioButtonItem();

      leavingHospitalGuidanceAddRadioItem1.setText("なし");

      leavingHospitalGuidanceAddRadioItem1.setGroup(getLeavingHospitalGuidanceAddRadio());

      leavingHospitalGuidanceAddRadioItem1.setConstraints(VRLayout.FLOW);

      addLeavingHospitalGuidanceAddRadioItem1();
    }
    return leavingHospitalGuidanceAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getLeavingHospitalGuidanceAddRadioItem2(){
    if(leavingHospitalGuidanceAddRadioItem2==null){

      leavingHospitalGuidanceAddRadioItem2 = new ACRadioButtonItem();

      leavingHospitalGuidanceAddRadioItem2.setText("あり");

      leavingHospitalGuidanceAddRadioItem2.setGroup(getLeavingHospitalGuidanceAddRadio());

      leavingHospitalGuidanceAddRadioItem2.setConstraints(VRLayout.FLOW);

      addLeavingHospitalGuidanceAddRadioItem2();
    }
    return leavingHospitalGuidanceAddRadioItem2;

  }

  /**
   * 事業開始時支援加算を取得します。
   * @return 事業開始時支援加算
   */
  public ACValueArrayRadioButtonGroup getBusinessBeginnerAddRadio(){
    if(businessBeginnerAddRadio==null){

      businessBeginnerAddRadio = new ACValueArrayRadioButtonGroup();

      getBusinessBeginnerAddRadioContainer().setText("事業開始時支援加算");

      businessBeginnerAddRadio.setBindPath("1770107");

      businessBeginnerAddRadio.setUseClearButton(false);

      businessBeginnerAddRadio.setModel(getBusinessBeginnerAddRadioModel());

      businessBeginnerAddRadio.setValues(new int[]{1,2});

      addBusinessBeginnerAddRadio();
    }
    return businessBeginnerAddRadio;

  }

  /**
   * 事業開始時支援加算コンテナを取得します。
   * @return 事業開始時支援加算コンテナ
   */
  protected ACLabelContainer getBusinessBeginnerAddRadioContainer(){
    if(businessBeginnerAddRadioContainer==null){
      businessBeginnerAddRadioContainer = new ACLabelContainer();
      businessBeginnerAddRadioContainer.setFollowChildEnabled(true);
      businessBeginnerAddRadioContainer.setVAlignment(VRLayout.CENTER);
      businessBeginnerAddRadioContainer.add(getBusinessBeginnerAddRadio(), null);
    }
    return businessBeginnerAddRadioContainer;
  }

  /**
   * 事業開始時支援加算モデルを取得します。
   * @return 事業開始時支援加算モデル
   */
  protected ACListModelAdapter getBusinessBeginnerAddRadioModel(){
    if(businessBeginnerAddRadioModel==null){
      businessBeginnerAddRadioModel = new ACListModelAdapter();
      addBusinessBeginnerAddRadioModel();
    }
    return businessBeginnerAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getBusinessBeginnerAddRadioItem1(){
    if(businessBeginnerAddRadioItem1==null){

      businessBeginnerAddRadioItem1 = new ACRadioButtonItem();

      businessBeginnerAddRadioItem1.setText("なし");

      businessBeginnerAddRadioItem1.setGroup(getBusinessBeginnerAddRadio());

      businessBeginnerAddRadioItem1.setConstraints(VRLayout.FLOW);

      addBusinessBeginnerAddRadioItem1();
    }
    return businessBeginnerAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getBusinessBeginnerAddRadioItem2(){
    if(businessBeginnerAddRadioItem2==null){

      businessBeginnerAddRadioItem2 = new ACRadioButtonItem();

      businessBeginnerAddRadioItem2.setText("あり");

      businessBeginnerAddRadioItem2.setGroup(getBusinessBeginnerAddRadio());

      businessBeginnerAddRadioItem2.setConstraints(VRLayout.FLOW);

      addBusinessBeginnerAddRadioItem2();
    }
    return businessBeginnerAddRadioItem2;

  }

  /**
   * 緊急時訪問看護加算を取得します。
   * @return 緊急時訪問看護加算
   */
  public ACValueArrayRadioButtonGroup getUrgentTimeAddRadio(){
    if(urgentTimeAddRadio==null){

      urgentTimeAddRadio = new ACValueArrayRadioButtonGroup();

      getUrgentTimeAddRadioContainer().setText("緊急時訪問看護加算");

      urgentTimeAddRadio.setBindPath("1770108");

      urgentTimeAddRadio.setUseClearButton(false);

      urgentTimeAddRadio.setModel(getUrgentTimeAddRadioModel());

      urgentTimeAddRadio.setValues(new int[]{1,2});

      addUrgentTimeAddRadio();
    }
    return urgentTimeAddRadio;

  }

  /**
   * 緊急時訪問看護加算コンテナを取得します。
   * @return 緊急時訪問看護加算コンテナ
   */
  protected ACLabelContainer getUrgentTimeAddRadioContainer(){
    if(urgentTimeAddRadioContainer==null){
      urgentTimeAddRadioContainer = new ACLabelContainer();
      urgentTimeAddRadioContainer.setFollowChildEnabled(true);
      urgentTimeAddRadioContainer.setVAlignment(VRLayout.CENTER);
      urgentTimeAddRadioContainer.add(getUrgentTimeAddRadio(), null);
    }
    return urgentTimeAddRadioContainer;
  }

  /**
   * 緊急時訪問看護加算モデルを取得します。
   * @return 緊急時訪問看護加算モデル
   */
  protected ACListModelAdapter getUrgentTimeAddRadioModel(){
    if(urgentTimeAddRadioModel==null){
      urgentTimeAddRadioModel = new ACListModelAdapter();
      addUrgentTimeAddRadioModel();
    }
    return urgentTimeAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getUrgentTimeAddRadioItem1(){
    if(urgentTimeAddRadioItem1==null){

      urgentTimeAddRadioItem1 = new ACRadioButtonItem();

      urgentTimeAddRadioItem1.setText("なし");

      urgentTimeAddRadioItem1.setGroup(getUrgentTimeAddRadio());

      urgentTimeAddRadioItem1.setConstraints(VRLayout.FLOW);

      addUrgentTimeAddRadioItem1();
    }
    return urgentTimeAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getUrgentTimeAddRadioItem2(){
    if(urgentTimeAddRadioItem2==null){

      urgentTimeAddRadioItem2 = new ACRadioButtonItem();

      urgentTimeAddRadioItem2.setText("あり");

      urgentTimeAddRadioItem2.setGroup(getUrgentTimeAddRadio());

      urgentTimeAddRadioItem2.setConstraints(VRLayout.FLOW);

      addUrgentTimeAddRadioItem2();
    }
    return urgentTimeAddRadioItem2;

  }

  /**
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceProvisionStructuralAddRadio(){
    if(serviceProvisionStructuralAddRadio==null){

      serviceProvisionStructuralAddRadio = new ACValueArrayRadioButtonGroup();

      getServiceProvisionStructuralAddRadioContainer().setText("サービス提供体制強化加算");

      serviceProvisionStructuralAddRadio.setBindPath("1770111");

      serviceProvisionStructuralAddRadio.setNoSelectIndex(0);

      serviceProvisionStructuralAddRadio.setUseClearButton(false);

      serviceProvisionStructuralAddRadio.setModel(getServiceProvisionStructuralAddRadioModel());

      serviceProvisionStructuralAddRadio.setValues(new int[]{1,2,3,4});

      addServiceProvisionStructuralAddRadio();
    }
    return serviceProvisionStructuralAddRadio;

  }

  /**
   * サービス提供体制強化加算コンテナを取得します。
   * @return サービス提供体制強化加算コンテナ
   */
  protected ACLabelContainer getServiceProvisionStructuralAddRadioContainer(){
    if(serviceProvisionStructuralAddRadioContainer==null){
      serviceProvisionStructuralAddRadioContainer = new ACLabelContainer();
      serviceProvisionStructuralAddRadioContainer.setFollowChildEnabled(true);
      serviceProvisionStructuralAddRadioContainer.setVAlignment(VRLayout.CENTER);
      serviceProvisionStructuralAddRadioContainer.add(getServiceProvisionStructuralAddRadio(), null);
    }
    return serviceProvisionStructuralAddRadioContainer;
  }

  /**
   * サービス提供体制強化加算モデルを取得します。
   * @return サービス提供体制強化加算モデル
   */
  protected ACListModelAdapter getServiceProvisionStructuralAddRadioModel(){
    if(serviceProvisionStructuralAddRadioModel==null){
      serviceProvisionStructuralAddRadioModel = new ACListModelAdapter();
      addServiceProvisionStructuralAddRadioModel();
    }
    return serviceProvisionStructuralAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getServiceProvisionStructuralAddRadioItem1(){
    if(serviceProvisionStructuralAddRadioItem1==null){

      serviceProvisionStructuralAddRadioItem1 = new ACRadioButtonItem();

      serviceProvisionStructuralAddRadioItem1.setText("なし");

      serviceProvisionStructuralAddRadioItem1.setGroup(getServiceProvisionStructuralAddRadio());

      serviceProvisionStructuralAddRadioItem1.setConstraints(VRLayout.FLOW);

      addServiceProvisionStructuralAddRadioItem1();
    }
    return serviceProvisionStructuralAddRadioItem1;

  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getServiceProvisionStructuralAddRadioItem2(){
    if(serviceProvisionStructuralAddRadioItem2==null){

      serviceProvisionStructuralAddRadioItem2 = new ACRadioButtonItem();

      serviceProvisionStructuralAddRadioItem2.setText("I型");

      serviceProvisionStructuralAddRadioItem2.setGroup(getServiceProvisionStructuralAddRadio());

      serviceProvisionStructuralAddRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addServiceProvisionStructuralAddRadioItem2();
    }
    return serviceProvisionStructuralAddRadioItem2;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getServiceProvisionStructuralAddRadioItem3(){
    if(serviceProvisionStructuralAddRadioItem3==null){

      serviceProvisionStructuralAddRadioItem3 = new ACRadioButtonItem();

      serviceProvisionStructuralAddRadioItem3.setText("II型");

      serviceProvisionStructuralAddRadioItem3.setGroup(getServiceProvisionStructuralAddRadio());

      serviceProvisionStructuralAddRadioItem3.setConstraints(VRLayout.FLOW);

      addServiceProvisionStructuralAddRadioItem3();
    }
    return serviceProvisionStructuralAddRadioItem3;

  }

  /**
   * III型を取得します。
   * @return III型
   */
  public ACRadioButtonItem getServiceProvisionStructuralAddRadioItem4(){
    if(serviceProvisionStructuralAddRadioItem4==null){

      serviceProvisionStructuralAddRadioItem4 = new ACRadioButtonItem();

      serviceProvisionStructuralAddRadioItem4.setText("III型");

      serviceProvisionStructuralAddRadioItem4.setGroup(getServiceProvisionStructuralAddRadio());

      serviceProvisionStructuralAddRadioItem4.setConstraints(VRLayout.FLOW);

      addServiceProvisionStructuralAddRadioItem4();
    }
    return serviceProvisionStructuralAddRadioItem4;

  }

  /**
   * 特別管理加算を取得します。
   * @return 特別管理加算
   */
  public ACValueArrayRadioButtonGroup getSpecialManagementRadio(){
    if(specialManagementRadio==null){

      specialManagementRadio = new ACValueArrayRadioButtonGroup();

      getSpecialManagementRadioContainer().setText("特別管理加算");

      specialManagementRadio.setBindPath("1770109");

      specialManagementRadio.setUseClearButton(false);

      specialManagementRadio.setModel(getSpecialManagementRadioModel());

      specialManagementRadio.setValues(new int[]{1,2,3});

      addSpecialManagementRadio();
    }
    return specialManagementRadio;

  }

  /**
   * 特別管理加算コンテナを取得します。
   * @return 特別管理加算コンテナ
   */
  protected ACLabelContainer getSpecialManagementRadioContainer(){
    if(specialManagementRadioContainer==null){
      specialManagementRadioContainer = new ACLabelContainer();
      specialManagementRadioContainer.setFollowChildEnabled(true);
      specialManagementRadioContainer.setVAlignment(VRLayout.CENTER);
      specialManagementRadioContainer.add(getSpecialManagementRadio(), null);
    }
    return specialManagementRadioContainer;
  }

  /**
   * 特別管理加算モデルを取得します。
   * @return 特別管理加算モデル
   */
  protected ACListModelAdapter getSpecialManagementRadioModel(){
    if(specialManagementRadioModel==null){
      specialManagementRadioModel = new ACListModelAdapter();
      addSpecialManagementRadioModel();
    }
    return specialManagementRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSpecialManagementRadioItem1(){
    if(specialManagementRadioItem1==null){

      specialManagementRadioItem1 = new ACRadioButtonItem();

      specialManagementRadioItem1.setText("なし");

      specialManagementRadioItem1.setGroup(getSpecialManagementRadio());

      specialManagementRadioItem1.setConstraints(VRLayout.FLOW);

      addSpecialManagementRadioItem1();
    }
    return specialManagementRadioItem1;

  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getSpecialManagementRadioItem2(){
    if(specialManagementRadioItem2==null){

      specialManagementRadioItem2 = new ACRadioButtonItem();

      specialManagementRadioItem2.setText("I型");

      specialManagementRadioItem2.setGroup(getSpecialManagementRadio());

      specialManagementRadioItem2.setConstraints(VRLayout.FLOW);

      addSpecialManagementRadioItem2();
    }
    return specialManagementRadioItem2;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getSpecialManagementRadioItem3(){
    if(specialManagementRadioItem3==null){

      specialManagementRadioItem3 = new ACRadioButtonItem();

      specialManagementRadioItem3.setText("II型");

      specialManagementRadioItem3.setGroup(getSpecialManagementRadio());

      specialManagementRadioItem3.setConstraints(VRLayout.FLOW);

      addSpecialManagementRadioItem3();
    }
    return specialManagementRadioItem3;

  }

  /**
   * ターミナルケア加算を取得します。
   * @return ターミナルケア加算
   */
  public ACValueArrayRadioButtonGroup getTerminalCareAddRadio(){
    if(terminalCareAddRadio==null){

      terminalCareAddRadio = new ACValueArrayRadioButtonGroup();

      getTerminalCareAddRadioContainer().setText("ターミナルケア加算");

      terminalCareAddRadio.setBindPath("1770110");

      terminalCareAddRadio.setUseClearButton(false);

      terminalCareAddRadio.setModel(getTerminalCareAddRadioModel());

      terminalCareAddRadio.setValues(new int[]{1,2});

      addTerminalCareAddRadio();
    }
    return terminalCareAddRadio;

  }

  /**
   * ターミナルケア加算コンテナを取得します。
   * @return ターミナルケア加算コンテナ
   */
  protected ACLabelContainer getTerminalCareAddRadioContainer(){
    if(terminalCareAddRadioContainer==null){
      terminalCareAddRadioContainer = new ACLabelContainer();
      terminalCareAddRadioContainer.setFollowChildEnabled(true);
      terminalCareAddRadioContainer.setVAlignment(VRLayout.CENTER);
      terminalCareAddRadioContainer.add(getTerminalCareAddRadio(), null);
    }
    return terminalCareAddRadioContainer;
  }

  /**
   * ターミナルケア加算モデルを取得します。
   * @return ターミナルケア加算モデル
   */
  protected ACListModelAdapter getTerminalCareAddRadioModel(){
    if(terminalCareAddRadioModel==null){
      terminalCareAddRadioModel = new ACListModelAdapter();
      addTerminalCareAddRadioModel();
    }
    return terminalCareAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTerminalCareAddRadioItem1(){
    if(terminalCareAddRadioItem1==null){

      terminalCareAddRadioItem1 = new ACRadioButtonItem();

      terminalCareAddRadioItem1.setText("なし");

      terminalCareAddRadioItem1.setGroup(getTerminalCareAddRadio());

      terminalCareAddRadioItem1.setConstraints(VRLayout.FLOW);

      addTerminalCareAddRadioItem1();
    }
    return terminalCareAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getTerminalCareAddRadioItem2(){
    if(terminalCareAddRadioItem2==null){

      terminalCareAddRadioItem2 = new ACRadioButtonItem();

      terminalCareAddRadioItem2.setText("あり");

      terminalCareAddRadioItem2.setGroup(getTerminalCareAddRadio());

      terminalCareAddRadioItem2.setConstraints(VRLayout.FLOW);

      addTerminalCareAddRadioItem2();
    }
    return terminalCareAddRadioItem2;

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

      addTab2();
    }
    return tab2;

  }

  /**
   * 複合型市町村独自加算を取得します。
   * @return 複合型市町村独自加算
   */
  public ACComboBox getServiceMunicipalityAdd(){
    if(serviceMunicipalityAdd==null){

      serviceMunicipalityAdd = new ACComboBox();

      getServiceMunicipalityAddContainer().setText("複合型市町村独自加算");

      serviceMunicipalityAdd.setBindPath("1770112");

      serviceMunicipalityAdd.setEditable(false);

      serviceMunicipalityAdd.setModelBindPath("1770112");

      serviceMunicipalityAdd.setRenderBindPath("CONTENT");

      serviceMunicipalityAdd.setBlankable(false);

      serviceMunicipalityAdd.setModel(getServiceMunicipalityAddModel());

      addServiceMunicipalityAdd();
    }
    return serviceMunicipalityAdd;

  }

  /**
   * 複合型市町村独自加算コンテナを取得します。
   * @return 複合型市町村独自加算コンテナ
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
   * 複合型市町村独自加算モデルを取得します。
   * @return 複合型市町村独自加算モデル
   */
  protected ACComboBoxModelAdapter getServiceMunicipalityAddModel(){
    if(serviceMunicipalityAddModel==null){
      serviceMunicipalityAddModel = new ACComboBoxModelAdapter();
      addServiceMunicipalityAddModel();
    }
    return serviceMunicipalityAddModel;
  }

  /**
   * 訪問看護減算を取得します。
   * @return 訪問看護減算
   */
  public ACValueArrayRadioButtonGroup getSubtractVisitingNurseRadioGroup(){
    if(subtractVisitingNurseRadioGroup==null){

      subtractVisitingNurseRadioGroup = new ACValueArrayRadioButtonGroup();

      getSubtractVisitingNurseRadioGroupContainer().setText("訪問看護減算");

      subtractVisitingNurseRadioGroup.setBindPath("1770113");

      subtractVisitingNurseRadioGroup.setUseClearButton(false);

      subtractVisitingNurseRadioGroup.setModel(getSubtractVisitingNurseRadioGroupModel());

      subtractVisitingNurseRadioGroup.setValues(new int[]{1,2});

      addSubtractVisitingNurseRadioGroup();
    }
    return subtractVisitingNurseRadioGroup;

  }

  /**
   * 訪問看護減算コンテナを取得します。
   * @return 訪問看護減算コンテナ
   */
  protected ACLabelContainer getSubtractVisitingNurseRadioGroupContainer(){
    if(subtractVisitingNurseRadioGroupContainer==null){
      subtractVisitingNurseRadioGroupContainer = new ACLabelContainer();
      subtractVisitingNurseRadioGroupContainer.setFollowChildEnabled(true);
      subtractVisitingNurseRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      subtractVisitingNurseRadioGroupContainer.add(getSubtractVisitingNurseRadioGroup(), null);
    }
    return subtractVisitingNurseRadioGroupContainer;
  }

  /**
   * 訪問看護減算モデルを取得します。
   * @return 訪問看護減算モデル
   */
  protected ACListModelAdapter getSubtractVisitingNurseRadioGroupModel(){
    if(subtractVisitingNurseRadioGroupModel==null){
      subtractVisitingNurseRadioGroupModel = new ACListModelAdapter();
      addSubtractVisitingNurseRadioGroupModel();
    }
    return subtractVisitingNurseRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSubtractVisitingNurseRadioItem1(){
    if(subtractVisitingNurseRadioItem1==null){

      subtractVisitingNurseRadioItem1 = new ACRadioButtonItem();

      subtractVisitingNurseRadioItem1.setText("なし");

      subtractVisitingNurseRadioItem1.setGroup(getSubtractVisitingNurseRadioGroup());

      subtractVisitingNurseRadioItem1.setConstraints(VRLayout.FLOW);

      addSubtractVisitingNurseRadioItem1();
    }
    return subtractVisitingNurseRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getSubtractVisitingNurseRadioItem2(){
    if(subtractVisitingNurseRadioItem2==null){

      subtractVisitingNurseRadioItem2 = new ACRadioButtonItem();

      subtractVisitingNurseRadioItem2.setText("あり");

      subtractVisitingNurseRadioItem2.setGroup(getSubtractVisitingNurseRadioGroup());

      subtractVisitingNurseRadioItem2.setConstraints(VRLayout.FLOW);

      addSubtractVisitingNurseRadioItem2();
    }
    return subtractVisitingNurseRadioItem2;

  }

  /**
   * 訪問看護特別指示減算を取得します。
   * @return 訪問看護特別指示減算
   */
  public ACValueArrayRadioButtonGroup getSubtractSpecialVisitingNursingSupportRadioGroup(){
    if(subtractSpecialVisitingNursingSupportRadioGroup==null){

      subtractSpecialVisitingNursingSupportRadioGroup = new ACValueArrayRadioButtonGroup();

      getSubtractSpecialVisitingNursingSupportRadioGroupContainer().setText("訪問看護特別指示減算");

      subtractSpecialVisitingNursingSupportRadioGroup.setBindPath("1770114");

      subtractSpecialVisitingNursingSupportRadioGroup.setUseClearButton(false);

      subtractSpecialVisitingNursingSupportRadioGroup.setModel(getSubtractSpecialVisitingNursingSupportRadioGroupModel());

      subtractSpecialVisitingNursingSupportRadioGroup.setValues(new int[]{1,2});

      addSubtractSpecialVisitingNursingSupportRadioGroup();
    }
    return subtractSpecialVisitingNursingSupportRadioGroup;

  }

  /**
   * 訪問看護特別指示減算コンテナを取得します。
   * @return 訪問看護特別指示減算コンテナ
   */
  protected ACLabelContainer getSubtractSpecialVisitingNursingSupportRadioGroupContainer(){
    if(subtractSpecialVisitingNursingSupportRadioGroupContainer==null){
      subtractSpecialVisitingNursingSupportRadioGroupContainer = new ACLabelContainer();
      subtractSpecialVisitingNursingSupportRadioGroupContainer.setFollowChildEnabled(true);
      subtractSpecialVisitingNursingSupportRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      subtractSpecialVisitingNursingSupportRadioGroupContainer.add(getSubtractSpecialVisitingNursingSupportRadioGroup(), null);
    }
    return subtractSpecialVisitingNursingSupportRadioGroupContainer;
  }

  /**
   * 訪問看護特別指示減算モデルを取得します。
   * @return 訪問看護特別指示減算モデル
   */
  protected ACListModelAdapter getSubtractSpecialVisitingNursingSupportRadioGroupModel(){
    if(subtractSpecialVisitingNursingSupportRadioGroupModel==null){
      subtractSpecialVisitingNursingSupportRadioGroupModel = new ACListModelAdapter();
      addSubtractSpecialVisitingNursingSupportRadioGroupModel();
    }
    return subtractSpecialVisitingNursingSupportRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSubtractSpecialVisitingNursingSupportRadioItem1(){
    if(subtractSpecialVisitingNursingSupportRadioItem1==null){

      subtractSpecialVisitingNursingSupportRadioItem1 = new ACRadioButtonItem();

      subtractSpecialVisitingNursingSupportRadioItem1.setText("なし");

      subtractSpecialVisitingNursingSupportRadioItem1.setGroup(getSubtractSpecialVisitingNursingSupportRadioGroup());

      subtractSpecialVisitingNursingSupportRadioItem1.setConstraints(VRLayout.FLOW);

      addSubtractSpecialVisitingNursingSupportRadioItem1();
    }
    return subtractSpecialVisitingNursingSupportRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getSubtractSpecialVisitingNursingSupportRadioItem2(){
    if(subtractSpecialVisitingNursingSupportRadioItem2==null){

      subtractSpecialVisitingNursingSupportRadioItem2 = new ACRadioButtonItem();

      subtractSpecialVisitingNursingSupportRadioItem2.setText("あり");

      subtractSpecialVisitingNursingSupportRadioItem2.setGroup(getSubtractSpecialVisitingNursingSupportRadioGroup());

      subtractSpecialVisitingNursingSupportRadioItem2.setConstraints(VRLayout.FLOW);

      addSubtractSpecialVisitingNursingSupportRadioItem2();
    }
    return subtractSpecialVisitingNursingSupportRadioItem2;

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

      kaigoSupportSpecialMemberNumber.setBindPath("1770116");

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

      getTekiyouTextContainer().setText("看護通所訪問宿泊日数");

      tekiyouText.setBindPath("1770117");

      tekiyouText.setVisible(true);

      tekiyouText.setEnabled(true);

      tekiyouText.setEditable(true);

      tekiyouText.setColumns(6);

      tekiyouText.setCharType(VRCharType.ONLY_DIGIT);

      tekiyouText.setHorizontalAlignment(SwingConstants.LEFT);

      tekiyouText.setIMEMode(InputSubset.LATIN);

      tekiyouText.setMaxLength(8);

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
  public ACRadioButtonItem getCalculationDivisionNormal(){
    if(calculationDivisionNormal==null){

      calculationDivisionNormal = new ACRadioButtonItem();

      calculationDivisionNormal.setText("通常");

      calculationDivisionNormal.setGroup(getCalculationDivision());

      calculationDivisionNormal.setConstraints(VRLayout.FLOW);

      addCalculationDivisionNormal();
    }
    return calculationDivisionNormal;

  }

  /**
   * 加算のみを取得します。
   * @return 加算のみ
   */
  public ACRadioButtonItem getCalculationDivisionAddOnly(){
    if(calculationDivisionAddOnly==null){

      calculationDivisionAddOnly = new ACRadioButtonItem();

      calculationDivisionAddOnly.setText("加算のみ");

      calculationDivisionAddOnly.setGroup(getCalculationDivision());

      calculationDivisionAddOnly.setConstraints(VRLayout.FLOW);

      addCalculationDivisionAddOnly();
    }
    return calculationDivisionAddOnly;

  }

  /**
   * 日割を取得します。
   * @return 日割
   */
  public ACIntegerCheckBox getCrackOnDayCheck(){
    if(crackOnDayCheck==null){

      crackOnDayCheck = new ACIntegerCheckBox();

      crackOnDayCheck.setText("日割");

      crackOnDayCheck.setBindPath("1770115");

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
   * 提供時間コンテナを取得します。
   * @return 提供時間コンテナ
   */
  public ACBackLabelContainer getHomonNyuyokuTimeContainer(){
    if(homonNyuyokuTimeContainer==null){

      homonNyuyokuTimeContainer = new ACBackLabelContainer();

      homonNyuyokuTimeContainer.setFollowChildEnabled(true);

      addHomonNyuyokuTimeContainer();
    }
    return homonNyuyokuTimeContainer;

  }

  /**
   * 開始時刻コンボを取得します。
   * @return 開始時刻コンボ
   */
  public ACTimeComboBox getHomonNyuyokuBeginTime(){
    if(homonNyuyokuBeginTime==null){

      homonNyuyokuBeginTime = new ACTimeComboBox();

      getHomonNyuyokuBeginTimeContainer().setText("開始時刻");

      homonNyuyokuBeginTime.setBindPath("3");

      homonNyuyokuBeginTime.setModelBindPath("3");

      homonNyuyokuBeginTime.setRenderBindPath("CONTENT");

      homonNyuyokuBeginTime.setModel(getHomonNyuyokuBeginTimeModel());

      addHomonNyuyokuBeginTime();
    }
    return homonNyuyokuBeginTime;

  }

  /**
   * 開始時刻コンボコンテナを取得します。
   * @return 開始時刻コンボコンテナ
   */
  protected ACLabelContainer getHomonNyuyokuBeginTimeContainer(){
    if(homonNyuyokuBeginTimeContainer==null){
      homonNyuyokuBeginTimeContainer = new ACLabelContainer();
      homonNyuyokuBeginTimeContainer.setFollowChildEnabled(true);
      homonNyuyokuBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      homonNyuyokuBeginTimeContainer.add(getHomonNyuyokuBeginTime(), null);
    }
    return homonNyuyokuBeginTimeContainer;
  }

  /**
   * 開始時刻コンボモデルを取得します。
   * @return 開始時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getHomonNyuyokuBeginTimeModel(){
    if(homonNyuyokuBeginTimeModel==null){
      homonNyuyokuBeginTimeModel = new ACComboBoxModelAdapter();
      addHomonNyuyokuBeginTimeModel();
    }
    return homonNyuyokuBeginTimeModel;
  }

  /**
   * 終了時刻コンボを取得します。
   * @return 終了時刻コンボ
   */
  public ACTimeComboBox getHomonNyuyokuEndTime(){
    if(homonNyuyokuEndTime==null){

      homonNyuyokuEndTime = new ACTimeComboBox();

      getHomonNyuyokuEndTimeContainer().setText("終了時刻");

      homonNyuyokuEndTime.setBindPath("4");

      homonNyuyokuEndTime.setModelBindPath("4");

      homonNyuyokuEndTime.setRenderBindPath("CONTENT");

      homonNyuyokuEndTime.setModel(getHomonNyuyokuEndTimeModel());

      addHomonNyuyokuEndTime();
    }
    return homonNyuyokuEndTime;

  }

  /**
   * 終了時刻コンボコンテナを取得します。
   * @return 終了時刻コンボコンテナ
   */
  protected ACLabelContainer getHomonNyuyokuEndTimeContainer(){
    if(homonNyuyokuEndTimeContainer==null){
      homonNyuyokuEndTimeContainer = new ACLabelContainer();
      homonNyuyokuEndTimeContainer.setFollowChildEnabled(true);
      homonNyuyokuEndTimeContainer.setVAlignment(VRLayout.CENTER);
      homonNyuyokuEndTimeContainer.add(getHomonNyuyokuEndTime(), null);
    }
    return homonNyuyokuEndTimeContainer;
  }

  /**
   * 終了時刻コンボモデルを取得します。
   * @return 終了時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getHomonNyuyokuEndTimeModel(){
    if(homonNyuyokuEndTimeModel==null){
      homonNyuyokuEndTimeModel = new ACComboBoxModelAdapter();
      addHomonNyuyokuEndTimeModel();
    }
    return homonNyuyokuEndTimeModel;
  }

  /**
   * コンストラクタです。
   */
  public QS001_17711_201204Design() {

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
   * パターン領域に内部項目を追加します。
   */
  protected void addMainGroup(){

    mainGroup.add(getTab(), VRLayout.CLIENT);

  }

  /**
   * タブに内部項目を追加します。
   */
  protected void addTab(){

    tab.addTab("1", getTab1());

    tab.addTab("2", getTab2());

  }

  /**
   * タブ1に内部項目を追加します。
   */
  protected void addTab1(){

    tab1.add(getStaffSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getSmallServiceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getInitialAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getDementiaRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getLeavingHospitalGuidanceAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getBusinessBeginnerAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getUrgentTimeAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getServiceProvisionStructuralAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getSpecialManagementRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTerminalCareAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * 従業員の不足に内部項目を追加します。
   */
  protected void addStaffSubtractionRadioItem3(){

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
   * 認知症加算に内部項目を追加します。
   */
  protected void addDementiaRadio(){

  }

  /**
   * 認知症加算モデルに内部項目を追加します。
   */
  protected void addDementiaRadioModel(){

    getDementiaRadioItem1().setButtonIndex(1);

    getDementiaRadioModel().add(getDementiaRadioItem1());

    getDementiaRadioItem2().setButtonIndex(2);

    getDementiaRadioModel().add(getDementiaRadioItem2());

    getDementiaRadioItem3().setButtonIndex(3);

    getDementiaRadioModel().add(getDementiaRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addDementiaRadioItem1(){

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addDementiaRadioItem2(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addDementiaRadioItem3(){

  }

  /**
   * 退院時共同指導加算に内部項目を追加します。
   */
  protected void addLeavingHospitalGuidanceAddRadio(){

  }

  /**
   * 退院時共同指導加算モデルに内部項目を追加します。
   */
  protected void addLeavingHospitalGuidanceAddRadioModel(){

    getLeavingHospitalGuidanceAddRadioItem1().setButtonIndex(1);

    getLeavingHospitalGuidanceAddRadioModel().add(getLeavingHospitalGuidanceAddRadioItem1());

    getLeavingHospitalGuidanceAddRadioItem2().setButtonIndex(2);

    getLeavingHospitalGuidanceAddRadioModel().add(getLeavingHospitalGuidanceAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addLeavingHospitalGuidanceAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addLeavingHospitalGuidanceAddRadioItem2(){

  }

  /**
   * 事業開始時支援加算に内部項目を追加します。
   */
  protected void addBusinessBeginnerAddRadio(){

  }

  /**
   * 事業開始時支援加算モデルに内部項目を追加します。
   */
  protected void addBusinessBeginnerAddRadioModel(){

    getBusinessBeginnerAddRadioItem1().setButtonIndex(1);

    getBusinessBeginnerAddRadioModel().add(getBusinessBeginnerAddRadioItem1());

    getBusinessBeginnerAddRadioItem2().setButtonIndex(2);

    getBusinessBeginnerAddRadioModel().add(getBusinessBeginnerAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addBusinessBeginnerAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addBusinessBeginnerAddRadioItem2(){

  }

  /**
   * 緊急時訪問看護加算に内部項目を追加します。
   */
  protected void addUrgentTimeAddRadio(){

  }

  /**
   * 緊急時訪問看護加算モデルに内部項目を追加します。
   */
  protected void addUrgentTimeAddRadioModel(){

    getUrgentTimeAddRadioItem1().setButtonIndex(1);

    getUrgentTimeAddRadioModel().add(getUrgentTimeAddRadioItem1());

    getUrgentTimeAddRadioItem2().setButtonIndex(2);

    getUrgentTimeAddRadioModel().add(getUrgentTimeAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addUrgentTimeAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addUrgentTimeAddRadioItem2(){

  }

  /**
   * サービス提供体制強化加算に内部項目を追加します。
   */
  protected void addServiceProvisionStructuralAddRadio(){

  }

  /**
   * サービス提供体制強化加算モデルに内部項目を追加します。
   */
  protected void addServiceProvisionStructuralAddRadioModel(){

    getServiceProvisionStructuralAddRadioItem1().setButtonIndex(1);

    getServiceProvisionStructuralAddRadioModel().add(getServiceProvisionStructuralAddRadioItem1());

    getServiceProvisionStructuralAddRadioItem2().setButtonIndex(2);

    getServiceProvisionStructuralAddRadioModel().add(getServiceProvisionStructuralAddRadioItem2());

    getServiceProvisionStructuralAddRadioItem3().setButtonIndex(3);

    getServiceProvisionStructuralAddRadioModel().add(getServiceProvisionStructuralAddRadioItem3());

    getServiceProvisionStructuralAddRadioItem4().setButtonIndex(4);

    getServiceProvisionStructuralAddRadioModel().add(getServiceProvisionStructuralAddRadioItem4());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addServiceProvisionStructuralAddRadioItem1(){

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addServiceProvisionStructuralAddRadioItem2(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addServiceProvisionStructuralAddRadioItem3(){

  }

  /**
   * III型に内部項目を追加します。
   */
  protected void addServiceProvisionStructuralAddRadioItem4(){

  }

  /**
   * 特別管理加算に内部項目を追加します。
   */
  protected void addSpecialManagementRadio(){

  }

  /**
   * 特別管理加算モデルに内部項目を追加します。
   */
  protected void addSpecialManagementRadioModel(){

    getSpecialManagementRadioItem1().setButtonIndex(1);

    getSpecialManagementRadioModel().add(getSpecialManagementRadioItem1());

    getSpecialManagementRadioItem2().setButtonIndex(2);

    getSpecialManagementRadioModel().add(getSpecialManagementRadioItem2());

    getSpecialManagementRadioItem3().setButtonIndex(3);

    getSpecialManagementRadioModel().add(getSpecialManagementRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSpecialManagementRadioItem1(){

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addSpecialManagementRadioItem2(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addSpecialManagementRadioItem3(){

  }

  /**
   * ターミナルケア加算に内部項目を追加します。
   */
  protected void addTerminalCareAddRadio(){

  }

  /**
   * ターミナルケア加算モデルに内部項目を追加します。
   */
  protected void addTerminalCareAddRadioModel(){

    getTerminalCareAddRadioItem1().setButtonIndex(1);

    getTerminalCareAddRadioModel().add(getTerminalCareAddRadioItem1());

    getTerminalCareAddRadioItem2().setButtonIndex(2);

    getTerminalCareAddRadioModel().add(getTerminalCareAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTerminalCareAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addTerminalCareAddRadioItem2(){

  }

  /**
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getServiceMunicipalityAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getSubtractVisitingNurseRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getSubtractSpecialVisitingNursingSupportRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKaigoSupportSpecialMemberContainer(), VRLayout.FLOW_RETURN);

    tab2.add(getTekiyouGroup(), VRLayout.FLOW_RETURN);

    tab2.add(getCalculationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getCrackOnDayCheck(), VRLayout.FLOW);

    tab2.add(getPrintable(), VRLayout.FLOW_RETURN);

    tab2.add(getHomonNyuyokuTimeContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * 複合型市町村独自加算に内部項目を追加します。
   */
  protected void addServiceMunicipalityAdd(){

  }

  /**
   * 複合型市町村独自加算モデルに内部項目を追加します。
   */
  protected void addServiceMunicipalityAddModel(){

  }

  /**
   * 訪問看護減算に内部項目を追加します。
   */
  protected void addSubtractVisitingNurseRadioGroup(){

  }

  /**
   * 訪問看護減算モデルに内部項目を追加します。
   */
  protected void addSubtractVisitingNurseRadioGroupModel(){

    getSubtractVisitingNurseRadioItem1().setButtonIndex(1);

    getSubtractVisitingNurseRadioGroupModel().add(getSubtractVisitingNurseRadioItem1());

    getSubtractVisitingNurseRadioItem2().setButtonIndex(2);

    getSubtractVisitingNurseRadioGroupModel().add(getSubtractVisitingNurseRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSubtractVisitingNurseRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addSubtractVisitingNurseRadioItem2(){

  }

  /**
   * 訪問看護特別指示減算に内部項目を追加します。
   */
  protected void addSubtractSpecialVisitingNursingSupportRadioGroup(){

  }

  /**
   * 訪問看護特別指示減算モデルに内部項目を追加します。
   */
  protected void addSubtractSpecialVisitingNursingSupportRadioGroupModel(){

    getSubtractSpecialVisitingNursingSupportRadioItem1().setButtonIndex(1);

    getSubtractSpecialVisitingNursingSupportRadioGroupModel().add(getSubtractSpecialVisitingNursingSupportRadioItem1());

    getSubtractSpecialVisitingNursingSupportRadioItem2().setButtonIndex(2);

    getSubtractSpecialVisitingNursingSupportRadioGroupModel().add(getSubtractSpecialVisitingNursingSupportRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSubtractSpecialVisitingNursingSupportRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addSubtractSpecialVisitingNursingSupportRadioItem2(){

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
   * 算定区分に内部項目を追加します。
   */
  protected void addCalculationDivision(){

  }

  /**
   * 算定区分モデルに内部項目を追加します。
   */
  protected void addCalculationDivisionModel(){

    getCalculationDivisionNormal().setButtonIndex(1);

    getCalculationDivisionModel().add(getCalculationDivisionNormal());

    getCalculationDivisionAddOnly().setButtonIndex(2);

    getCalculationDivisionModel().add(getCalculationDivisionAddOnly());

  }

  /**
   * 通常に内部項目を追加します。
   */
  protected void addCalculationDivisionNormal(){

  }

  /**
   * 加算のみに内部項目を追加します。
   */
  protected void addCalculationDivisionAddOnly(){

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
   * 提供時間コンテナに内部項目を追加します。
   */
  protected void addHomonNyuyokuTimeContainer(){

    homonNyuyokuTimeContainer.add(getHomonNyuyokuBeginTimeContainer(), VRLayout.FLOW);

    homonNyuyokuTimeContainer.add(getHomonNyuyokuEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * 開始時刻コンボに内部項目を追加します。
   */
  protected void addHomonNyuyokuBeginTime(){

  }

  /**
   * 開始時刻コンボモデルに内部項目を追加します。
   */
  protected void addHomonNyuyokuBeginTimeModel(){

  }

  /**
   * 終了時刻コンボに内部項目を追加します。
   */
  protected void addHomonNyuyokuEndTime(){

  }

  /**
   * 終了時刻コンボモデルに内部項目を追加します。
   */
  protected void addHomonNyuyokuEndTimeModel(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_17711_201204Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_17711_201204Design getThis() {
    return this;
  }
}
