
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
 * 作成日: 2012/02/22  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン小規模多機能型介護 (QS001_17311_201204)
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
import jp.nichicom.ac.component.ACValueArrayRadioButtonGroup;
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
 * サービスパターン小規模多機能型介護画面項目デザイン(QS001_17311_201204) 
 */
public class QS001_17311_201204Design extends QS001ServicePanel {
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

  private ACValueArrayRadioButtonGroup providerStartAddRadioGroup;

  private ACLabelContainer providerStartAddRadioGroupContainer;

  private ACListModelAdapter providerStartAddRadioGroupModel;

  private ACRadioButtonItem providerStartAddRadioItem1;

  private ACRadioButtonItem providerStartAddRadioItem2;

  private ACValueArrayRadioButtonGroup houmonNeededRadio;

  private ACLabelContainer houmonNeededRadioContainer;

  private ACListModelAdapter houmonNeededRadioModel;

  private ACRadioButtonItem houmonNeededRadioItem1;

  private ACRadioButtonItem houmonNeededRadioItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACComboBox municipalityAdd;

  private ACLabelContainer municipalityAddContainer;

  private ACComboBoxModelAdapter municipalityAddModel;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup calculationDivision;

  private ACLabelContainer calculationDivisionContainer;

  private ACListModelAdapter calculationDivisionModel;

  private ACRadioButtonItem calculationDivisionItem1;

  private ACRadioButtonItem calculationDivisionItem2;

  private ACIntegerCheckBox crackOnDayCheck;

  private ACIntegerCheckBox printable;

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

  private ACGroupBox infoGroup;

  private ACLabel infoLabel;

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

      nurseStaffDispositionAddRadioGroup.setValues(new int[]{1,2,3});

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
   * 事業開始時支援加算を取得します。
   * @return 事業開始時支援加算
   */
  public ACValueArrayRadioButtonGroup getProviderStartAddRadioGroup(){
    if(providerStartAddRadioGroup==null){

      providerStartAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getProviderStartAddRadioGroupContainer().setText("事業開始時支援加算");

      providerStartAddRadioGroup.setBindPath("1730109");

      providerStartAddRadioGroup.setNoSelectIndex(0);

      providerStartAddRadioGroup.setUseClearButton(false);

      providerStartAddRadioGroup.setModel(getProviderStartAddRadioGroupModel());

      providerStartAddRadioGroup.setValues(new int[]{1,2});

      addProviderStartAddRadioGroup();
    }
    return providerStartAddRadioGroup;

  }

  /**
   * 事業開始時支援加算コンテナを取得します。
   * @return 事業開始時支援加算コンテナ
   */
  protected ACLabelContainer getProviderStartAddRadioGroupContainer(){
    if(providerStartAddRadioGroupContainer==null){
      providerStartAddRadioGroupContainer = new ACLabelContainer();
      providerStartAddRadioGroupContainer.setFollowChildEnabled(true);
      providerStartAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      providerStartAddRadioGroupContainer.add(getProviderStartAddRadioGroup(), null);
    }
    return providerStartAddRadioGroupContainer;
  }

  /**
   * 事業開始時支援加算モデルを取得します。
   * @return 事業開始時支援加算モデル
   */
  protected ACListModelAdapter getProviderStartAddRadioGroupModel(){
    if(providerStartAddRadioGroupModel==null){
      providerStartAddRadioGroupModel = new ACListModelAdapter();
      addProviderStartAddRadioGroupModel();
    }
    return providerStartAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getProviderStartAddRadioItem1(){
    if(providerStartAddRadioItem1==null){

      providerStartAddRadioItem1 = new ACRadioButtonItem();

      providerStartAddRadioItem1.setText("なし");

      providerStartAddRadioItem1.setGroup(getProviderStartAddRadioGroup());

      providerStartAddRadioItem1.setConstraints(VRLayout.FLOW);

      addProviderStartAddRadioItem1();
    }
    return providerStartAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getProviderStartAddRadioItem2(){
    if(providerStartAddRadioItem2==null){

      providerStartAddRadioItem2 = new ACRadioButtonItem();

      providerStartAddRadioItem2.setText("あり");

      providerStartAddRadioItem2.setGroup(getProviderStartAddRadioGroup());

      providerStartAddRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addProviderStartAddRadioItem2();
    }
    return providerStartAddRadioItem2;

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

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,2,3,4});

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
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("I型");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

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
   * コンストラクタです。
   */
  public QS001_17311_201204Design() {

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

    tab1.add(getProviderStartAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * 事業開始時支援加算に内部項目を追加します。
   */
  protected void addProviderStartAddRadioGroup(){

  }

  /**
   * 事業開始時支援加算モデルに内部項目を追加します。
   */
  protected void addProviderStartAddRadioGroupModel(){

    getProviderStartAddRadioItem1().setButtonIndex(1);

    getProviderStartAddRadioGroupModel().add(getProviderStartAddRadioItem1());

    getProviderStartAddRadioItem2().setButtonIndex(2);

    getProviderStartAddRadioGroupModel().add(getProviderStartAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addProviderStartAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addProviderStartAddRadioItem2(){

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
   * I型に内部項目を追加します。
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

    tab2.add(getCalculationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getCrackOnDayCheck(), VRLayout.FLOW_INSETLINE);

    tab2.add(getPrintable(), VRLayout.FLOW_RETURN);

    tab2.add(getKaigoSupportSpecialMemberContainer(), VRLayout.FLOW_RETURN);

    tab2.add(getTekiyouGroup(), VRLayout.FLOW_RETURN);

    tab2.add(getInfoGroup(), VRLayout.FLOW);

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
      ACFrame.debugStart(new ACAffairInfo(QS001_17311_201204Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_17311_201204Design getThis() {
    return this;
  }
}
