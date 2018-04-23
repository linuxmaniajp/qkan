
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
 * 作成日: 2018/02/04  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン短期入所療養介護（居宅療養管理指導） (QS001_13111_201804)
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
 * サービスパターン短期入所療養介護（居宅療養管理指導）画面項目デザイン(QS001_13111_201804) 
 */
public class QS001_13111_201804Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel recuperationManagementGuidancePatterns;

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup recuperationManagementGuidanceOccupationalCategory;

  private ACLabelContainer recuperationManagementGuidanceOccupationalCategoryContainer;

  private ACListModelAdapter recuperationManagementGuidanceOccupationalCategoryModel;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryDoctor1;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryDoctor2;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryDentist;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryHealth;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryDietitian;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryEtc;

  private ACGroupBox patientGroup;

  private ACValueArrayRadioButtonGroup patientRadioGroup;

  private ACLabelContainer patientRadioGroupContainer;

  private ACListModelAdapter patientRadioGroupModel;

  private ACRadioButtonItem patientLocationRadioItem1;

  private ACRadioButtonItem patientLocationRadioItem2;

  private ACRadioButtonItem patientLocationRadioItem3;

  private ACValueArrayRadioButtonGroup patientOldRadioGroup;

  private ACLabelContainer patientOldRadioGroupContainer;

  private ACListModelAdapter patientOldRadioGroupModel;

  private ACRadioButtonItem patientRadioItem1;

  private ACRadioButtonItem patientRadioItem2;

  private ACIntegerCheckBox recuperationManagementGuidanceTimesCancerEndCheck;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio;

  private ACLabelContainer recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer;

  private ACListModelAdapter recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2;

  private ACValueArrayRadioButtonGroup kyotakuClass;

  private ACLabelContainer kyotakuClassContainer;

  private ACListModelAdapter kyotakuClassModel;

  private ACRadioButtonItem kyotakuClass1;

  private ACRadioButtonItem kyotakuClass2;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaItem1;

  private ACRadioButtonItem providerAddMountainousAreaItem2;

  private ACBackLabelContainer recuperationManagementGuidanceTimeContena;

  private ACTimeComboBox recuperationManagementGuidanceBeginTime;

  private ACLabelContainer recuperationManagementGuidanceBeginTimeContainer;

  private ACComboBoxModelAdapter recuperationManagementGuidanceBeginTimeModel;

  private ACTimeComboBox recuperationManagementGuidanceEndTime;

  private ACLabelContainer recuperationManagementGuidanceEndTimeContainer;

  private ACComboBoxModelAdapter recuperationManagementGuidanceEndTimeModel;

  //getter

  /**
   * 短期入所療養介護（居宅療養管理指導）パターン領域）を取得します。
   * @return 短期入所療養介護（居宅療養管理指導）パターン領域）
   */
  public ACPanel getRecuperationManagementGuidancePatterns(){
    if(recuperationManagementGuidancePatterns==null){

      recuperationManagementGuidancePatterns = new ACPanel();

      recuperationManagementGuidancePatterns.setAutoWrap(false);

      recuperationManagementGuidancePatterns.setFollowChildEnabled(true);

      recuperationManagementGuidancePatterns.setHgap(0);

      recuperationManagementGuidancePatterns.setHgrid(200);

      addRecuperationManagementGuidancePatterns();
    }
    return recuperationManagementGuidancePatterns;

  }

  /**
   * タブを取得します。
   * @return タブ
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
   * 担当者区分を取得します。
   * @return 担当者区分
   */
  public ACValueArrayRadioButtonGroup getRecuperationManagementGuidanceOccupationalCategory(){
    if(recuperationManagementGuidanceOccupationalCategory==null){

      recuperationManagementGuidanceOccupationalCategory = new ACValueArrayRadioButtonGroup();

      getRecuperationManagementGuidanceOccupationalCategoryContainer().setText("担当者区分");

      recuperationManagementGuidanceOccupationalCategory.setBindPath("1310111");

      recuperationManagementGuidanceOccupationalCategory.setUseClearButton(false);

      recuperationManagementGuidanceOccupationalCategory.setModel(getRecuperationManagementGuidanceOccupationalCategoryModel());

      recuperationManagementGuidanceOccupationalCategory.setValues(new int[]{1,8,2,7,3,4,5,6});

      addRecuperationManagementGuidanceOccupationalCategory();
    }
    return recuperationManagementGuidanceOccupationalCategory;

  }

  /**
   * 担当者区分コンテナを取得します。
   * @return 担当者区分コンテナ
   */
  protected ACLabelContainer getRecuperationManagementGuidanceOccupationalCategoryContainer(){
    if(recuperationManagementGuidanceOccupationalCategoryContainer==null){
      recuperationManagementGuidanceOccupationalCategoryContainer = new ACLabelContainer();
      recuperationManagementGuidanceOccupationalCategoryContainer.setFollowChildEnabled(true);
      recuperationManagementGuidanceOccupationalCategoryContainer.setVAlignment(VRLayout.CENTER);
      recuperationManagementGuidanceOccupationalCategoryContainer.add(getRecuperationManagementGuidanceOccupationalCategory(), null);
    }
    return recuperationManagementGuidanceOccupationalCategoryContainer;
  }

  /**
   * 担当者区分モデルを取得します。
   * @return 担当者区分モデル
   */
  protected ACListModelAdapter getRecuperationManagementGuidanceOccupationalCategoryModel(){
    if(recuperationManagementGuidanceOccupationalCategoryModel==null){
      recuperationManagementGuidanceOccupationalCategoryModel = new ACListModelAdapter();
      addRecuperationManagementGuidanceOccupationalCategoryModel();
    }
    return recuperationManagementGuidanceOccupationalCategoryModel;
  }

  /**
   * 医師(指導費I)を取得します。
   * @return 医師(指導費I)
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryDoctor1(){
    if(recuperationManagementGuidanceOccupationalCategoryDoctor1==null){

      recuperationManagementGuidanceOccupationalCategoryDoctor1 = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryDoctor1.setText("医師(指導費I)");

      recuperationManagementGuidanceOccupationalCategoryDoctor1.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryDoctor1.setConstraints(VRLayout.FLOW_RETURN);

      addRecuperationManagementGuidanceOccupationalCategoryDoctor1();
    }
    return recuperationManagementGuidanceOccupationalCategoryDoctor1;

  }

  /**
   * 医師(指導費II)　医学総合管理料を取得します。
   * @return 医師(指導費II)　医学総合管理料
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryDoctor2(){
    if(recuperationManagementGuidanceOccupationalCategoryDoctor2==null){

      recuperationManagementGuidanceOccupationalCategoryDoctor2 = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryDoctor2.setText("医師(指導費II)　医学総合管理料");

      recuperationManagementGuidanceOccupationalCategoryDoctor2.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryDoctor2.setConstraints(VRLayout.FLOW_RETURN);

      addRecuperationManagementGuidanceOccupationalCategoryDoctor2();
    }
    return recuperationManagementGuidanceOccupationalCategoryDoctor2;

  }

  /**
   * 歯科医師を取得します。
   * @return 歯科医師
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryDentist(){
    if(recuperationManagementGuidanceOccupationalCategoryDentist==null){

      recuperationManagementGuidanceOccupationalCategoryDentist = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryDentist.setText("歯科医師");

      recuperationManagementGuidanceOccupationalCategoryDentist.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryDentist.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceOccupationalCategoryDentist();
    }
    return recuperationManagementGuidanceOccupationalCategoryDentist;

  }

  /**
   * 看護職員を取得します。
   * @return 看護職員
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryHealth(){
    if(recuperationManagementGuidanceOccupationalCategoryHealth==null){

      recuperationManagementGuidanceOccupationalCategoryHealth = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryHealth.setText("看護職員");

      recuperationManagementGuidanceOccupationalCategoryHealth.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryHealth.setConstraints(VRLayout.FLOW_RETURN);

      addRecuperationManagementGuidanceOccupationalCategoryHealth();
    }
    return recuperationManagementGuidanceOccupationalCategoryHealth;

  }

  /**
   * 薬剤師(医療機関)を取得します。
   * @return 薬剤師(医療機関)
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacist(){
    if(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist==null){

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist.setText("薬剤師(医療機関)");

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacist();
    }
    return recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist;

  }

  /**
   * 薬剤師(薬局)を取得します。
   * @return 薬剤師(薬局)
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist(){
    if(recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist==null){

      recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist.setText("薬剤師(薬局)");

      recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist.setConstraints(VRLayout.FLOW_RETURN);

      addRecuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist();
    }
    return recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist;

  }

  /**
   * 管理栄養士を取得します。
   * @return 管理栄養士
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryDietitian(){
    if(recuperationManagementGuidanceOccupationalCategoryDietitian==null){

      recuperationManagementGuidanceOccupationalCategoryDietitian = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryDietitian.setText("管理栄養士");

      recuperationManagementGuidanceOccupationalCategoryDietitian.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryDietitian.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceOccupationalCategoryDietitian();
    }
    return recuperationManagementGuidanceOccupationalCategoryDietitian;

  }

  /**
   * 歯科衛生士等を取得します。
   * @return 歯科衛生士等
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryEtc(){
    if(recuperationManagementGuidanceOccupationalCategoryEtc==null){

      recuperationManagementGuidanceOccupationalCategoryEtc = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryEtc.setText("歯科衛生士等");

      recuperationManagementGuidanceOccupationalCategoryEtc.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryEtc.setConstraints(VRLayout.FLOW_RETURN);

      addRecuperationManagementGuidanceOccupationalCategoryEtc();
    }
    return recuperationManagementGuidanceOccupationalCategoryEtc;

  }

  /**
   * 利用者区分を取得します。
   * @return 利用者区分
   */
  public ACGroupBox getPatientGroup(){
    if(patientGroup==null){

      patientGroup = new ACGroupBox();

      patientGroup.setText("利用者サービス区分");

      patientGroup.setFollowChildEnabled(true);

      addPatientGroup();
    }
    return patientGroup;

  }

  /**
   * 所在地区分を取得します。
   * @return 所在地区分
   */
  public ACValueArrayRadioButtonGroup getPatientRadioGroup(){
    if(patientRadioGroup==null){

      patientRadioGroup = new ACValueArrayRadioButtonGroup();

      getPatientRadioGroupContainer().setText("所在地区分");

      patientRadioGroup.setBindPath("1310113");

      patientRadioGroup.setNoSelectIndex(0);

      patientRadioGroup.setUseClearButton(false);

      patientRadioGroup.setModel(getPatientRadioGroupModel());

      patientRadioGroup.setValues(new int[]{1,2,3});

      addPatientRadioGroup();
    }
    return patientRadioGroup;

  }

  /**
   * 所在地区分コンテナを取得します。
   * @return 所在地区分コンテナ
   */
  protected ACLabelContainer getPatientRadioGroupContainer(){
    if(patientRadioGroupContainer==null){
      patientRadioGroupContainer = new ACLabelContainer();
      patientRadioGroupContainer.setFollowChildEnabled(true);
      patientRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      patientRadioGroupContainer.add(getPatientRadioGroup(), null);
    }
    return patientRadioGroupContainer;
  }

  /**
   * 所在地区分モデルを取得します。
   * @return 所在地区分モデル
   */
  protected ACListModelAdapter getPatientRadioGroupModel(){
    if(patientRadioGroupModel==null){
      patientRadioGroupModel = new ACListModelAdapter();
      addPatientRadioGroupModel();
    }
    return patientRadioGroupModel;
  }

  /**
   * 単一建物居住者（1人）を取得します。
   * @return 単一建物居住者（1人）
   */
  public ACRadioButtonItem getPatientLocationRadioItem1(){
    if(patientLocationRadioItem1==null){

      patientLocationRadioItem1 = new ACRadioButtonItem();

      patientLocationRadioItem1.setText("<html>単一建物居住者（1人）<br>%unit%<html>");

      patientLocationRadioItem1.setGroup(getPatientRadioGroup());

      patientLocationRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addPatientLocationRadioItem1();
    }
    return patientLocationRadioItem1;

  }

  /**
   * 単一建物居住者（2～9人）を取得します。
   * @return 単一建物居住者（2～9人）
   */
  public ACRadioButtonItem getPatientLocationRadioItem2(){
    if(patientLocationRadioItem2==null){

      patientLocationRadioItem2 = new ACRadioButtonItem();

      patientLocationRadioItem2.setText("<html>単一建物居住者（2～9人）<br>%unit%<html>");

      patientLocationRadioItem2.setGroup(getPatientRadioGroup());

      patientLocationRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addPatientLocationRadioItem2();
    }
    return patientLocationRadioItem2;

  }

  /**
   * 上記以外を取得します。
   * @return 上記以外
   */
  public ACRadioButtonItem getPatientLocationRadioItem3(){
    if(patientLocationRadioItem3==null){

      patientLocationRadioItem3 = new ACRadioButtonItem();

      patientLocationRadioItem3.setText("<html>上記以外<br>%unit%<html>");

      patientLocationRadioItem3.setGroup(getPatientRadioGroup());

      patientLocationRadioItem3.setConstraints(VRLayout.FLOW);

      addPatientLocationRadioItem3();
    }
    return patientLocationRadioItem3;

  }

  /**
   * 所在地区分を取得します。
   * @return 所在地区分
   */
  public ACValueArrayRadioButtonGroup getPatientOldRadioGroup(){
    if(patientOldRadioGroup==null){

      patientOldRadioGroup = new ACValueArrayRadioButtonGroup();

      getPatientOldRadioGroupContainer().setText("所在地区分");

      patientOldRadioGroup.setBindPath("16");

      patientOldRadioGroup.setNoSelectIndex(0);

      patientOldRadioGroup.setUseClearButton(false);

      patientOldRadioGroup.setModel(getPatientOldRadioGroupModel());

      patientOldRadioGroup.setValues(new int[]{1,2});

      addPatientOldRadioGroup();
    }
    return patientOldRadioGroup;

  }

  /**
   * 所在地区分コンテナを取得します。
   * @return 所在地区分コンテナ
   */
  protected ACLabelContainer getPatientOldRadioGroupContainer(){
    if(patientOldRadioGroupContainer==null){
      patientOldRadioGroupContainer = new ACLabelContainer();
      patientOldRadioGroupContainer.setFollowChildEnabled(true);
      patientOldRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      patientOldRadioGroupContainer.add(getPatientOldRadioGroup(), null);
    }
    return patientOldRadioGroupContainer;
  }

  /**
   * 所在地区分モデルを取得します。
   * @return 所在地区分モデル
   */
  protected ACListModelAdapter getPatientOldRadioGroupModel(){
    if(patientOldRadioGroupModel==null){
      patientOldRadioGroupModel = new ACListModelAdapter();
      addPatientOldRadioGroupModel();
    }
    return patientOldRadioGroupModel;
  }

  /**
   * 同一建物居住者以外を取得します。
   * @return 同一建物居住者以外
   */
  public ACRadioButtonItem getPatientRadioItem1(){
    if(patientRadioItem1==null){

      patientRadioItem1 = new ACRadioButtonItem();

      patientRadioItem1.setText("<html>同一建物居住者以外<br>（402単位）<html>");

      patientRadioItem1.setGroup(getPatientOldRadioGroup());

      patientRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addPatientRadioItem1();
    }
    return patientRadioItem1;

  }

  /**
   * 居宅系施設入居者を取得します。
   * @return 居宅系施設入居者
   */
  public ACRadioButtonItem getPatientRadioItem2(){
    if(patientRadioItem2==null){

      patientRadioItem2 = new ACRadioButtonItem();

      patientRadioItem2.setText("<html>同一建物居住者<br>（362単位）<html>");

      patientRadioItem2.setGroup(getPatientOldRadioGroup());

      patientRadioItem2.setConstraints(VRLayout.FLOW);

      addPatientRadioItem2();
    }
    return patientRadioItem2;

  }

  /**
   * ガン末期等を取得します。
   * @return ガン末期等
   */
  public ACIntegerCheckBox getRecuperationManagementGuidanceTimesCancerEndCheck(){
    if(recuperationManagementGuidanceTimesCancerEndCheck==null){

      recuperationManagementGuidanceTimesCancerEndCheck = new ACIntegerCheckBox();

      recuperationManagementGuidanceTimesCancerEndCheck.setText("ガン末期等");

      recuperationManagementGuidanceTimesCancerEndCheck.setBindPath("1310110");

      recuperationManagementGuidanceTimesCancerEndCheck.setSelectValue(2);

      recuperationManagementGuidanceTimesCancerEndCheck.setUnSelectValue(1);

      addRecuperationManagementGuidanceTimesCancerEndCheck();
    }
    return recuperationManagementGuidanceTimesCancerEndCheck;

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
   * 特別薬剤を取得します。
   * @return 特別薬剤
   */
  public ACValueArrayRadioButtonGroup getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio(){
    if(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio==null){

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio = new ACValueArrayRadioButtonGroup();

      getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer().setText("特別薬剤");

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio.setBindPath("1310105");

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio.setUseClearButton(false);

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio.setModel(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel());

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio.setValues(new int[]{1,2});

      addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio();
    }
    return recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio;

  }

  /**
   * 特別薬剤コンテナを取得します。
   * @return 特別薬剤コンテナ
   */
  protected ACLabelContainer getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer(){
    if(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer==null){
      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer = new ACLabelContainer();
      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer.setFollowChildEnabled(true);
      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer.setVAlignment(VRLayout.CENTER);
      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer.add(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio(), null);
    }
    return recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer;
  }

  /**
   * 特別薬剤モデルを取得します。
   * @return 特別薬剤モデル
   */
  protected ACListModelAdapter getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel(){
    if(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel==null){
      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel = new ACListModelAdapter();
      addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel();
    }
    return recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1(){
    if(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1==null){

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1 = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1.setText("なし");

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1.setGroup(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio());

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1();
    }
    return recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2(){
    if(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2==null){

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2 = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2.setText("あり");

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2.setGroup(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio());

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2();
    }
    return recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2;

  }

  /**
   * 看護職員区分を取得します。
   * @return 看護職員区分
   */
  public ACValueArrayRadioButtonGroup getKyotakuClass(){
    if(kyotakuClass==null){

      kyotakuClass = new ACValueArrayRadioButtonGroup();

      getKyotakuClassContainer().setText("看護職員区分");

      kyotakuClass.setBindPath("1310112");

      kyotakuClass.setUseClearButton(false);

      kyotakuClass.setModel(getKyotakuClassModel());

      kyotakuClass.setValues(new int[]{1,2});

      addKyotakuClass();
    }
    return kyotakuClass;

  }

  /**
   * 看護職員区分コンテナを取得します。
   * @return 看護職員区分コンテナ
   */
  protected ACLabelContainer getKyotakuClassContainer(){
    if(kyotakuClassContainer==null){
      kyotakuClassContainer = new ACLabelContainer();
      kyotakuClassContainer.setFollowChildEnabled(true);
      kyotakuClassContainer.setVAlignment(VRLayout.CENTER);
      kyotakuClassContainer.add(getKyotakuClass(), null);
    }
    return kyotakuClassContainer;
  }

  /**
   * 看護職員区分モデルを取得します。
   * @return 看護職員区分モデル
   */
  protected ACListModelAdapter getKyotakuClassModel(){
    if(kyotakuClassModel==null){
      kyotakuClassModel = new ACListModelAdapter();
      addKyotakuClassModel();
    }
    return kyotakuClassModel;
  }

  /**
   * 正看等を取得します。
   * @return 正看等
   */
  public ACRadioButtonItem getKyotakuClass1(){
    if(kyotakuClass1==null){

      kyotakuClass1 = new ACRadioButtonItem();

      kyotakuClass1.setText("正看等");

      kyotakuClass1.setGroup(getKyotakuClass());

      addKyotakuClass1();
    }
    return kyotakuClass1;

  }

  /**
   * 准看を取得します。
   * @return 准看
   */
  public ACRadioButtonItem getKyotakuClass2(){
    if(kyotakuClass2==null){

      kyotakuClass2 = new ACRadioButtonItem();

      kyotakuClass2.setText("准看");

      kyotakuClass2.setGroup(getKyotakuClass());

      addKyotakuClass2();
    }
    return kyotakuClass2;

  }

  /**
   * 中山間地域等でのサービス提供加算を取得します。
   * @return 中山間地域等でのサービス提供加算
   */
  public ACValueArrayRadioButtonGroup getProviderAddMountainousAreaRadioGroup(){
    if(providerAddMountainousAreaRadioGroup==null){

      providerAddMountainousAreaRadioGroup = new ACValueArrayRadioButtonGroup();

      getProviderAddMountainousAreaRadioGroupContainer().setText("中山間地域等でのサービス提供加算");

      providerAddMountainousAreaRadioGroup.setBindPath("12");

      providerAddMountainousAreaRadioGroup.setNoSelectIndex(0);

      providerAddMountainousAreaRadioGroup.setUseClearButton(false);

      providerAddMountainousAreaRadioGroup.setModel(getProviderAddMountainousAreaRadioGroupModel());

      providerAddMountainousAreaRadioGroup.setValues(new int[]{1,2});

      addProviderAddMountainousAreaRadioGroup();
    }
    return providerAddMountainousAreaRadioGroup;

  }

  /**
   * 中山間地域等でのサービス提供加算コンテナを取得します。
   * @return 中山間地域等でのサービス提供加算コンテナ
   */
  protected ACLabelContainer getProviderAddMountainousAreaRadioGroupContainer(){
    if(providerAddMountainousAreaRadioGroupContainer==null){
      providerAddMountainousAreaRadioGroupContainer = new ACLabelContainer();
      providerAddMountainousAreaRadioGroupContainer.setFollowChildEnabled(true);
      providerAddMountainousAreaRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      providerAddMountainousAreaRadioGroupContainer.add(getProviderAddMountainousAreaRadioGroup(), null);
    }
    return providerAddMountainousAreaRadioGroupContainer;
  }

  /**
   * 中山間地域等でのサービス提供加算モデルを取得します。
   * @return 中山間地域等でのサービス提供加算モデル
   */
  protected ACListModelAdapter getProviderAddMountainousAreaRadioGroupModel(){
    if(providerAddMountainousAreaRadioGroupModel==null){
      providerAddMountainousAreaRadioGroupModel = new ACListModelAdapter();
      addProviderAddMountainousAreaRadioGroupModel();
    }
    return providerAddMountainousAreaRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getProviderAddMountainousAreaItem1(){
    if(providerAddMountainousAreaItem1==null){

      providerAddMountainousAreaItem1 = new ACRadioButtonItem();

      providerAddMountainousAreaItem1.setText("なし");

      providerAddMountainousAreaItem1.setGroup(getProviderAddMountainousAreaRadioGroup());

      providerAddMountainousAreaItem1.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaItem1();
    }
    return providerAddMountainousAreaItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getProviderAddMountainousAreaItem2(){
    if(providerAddMountainousAreaItem2==null){

      providerAddMountainousAreaItem2 = new ACRadioButtonItem();

      providerAddMountainousAreaItem2.setText("あり");

      providerAddMountainousAreaItem2.setGroup(getProviderAddMountainousAreaRadioGroup());

      providerAddMountainousAreaItem2.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaItem2();
    }
    return providerAddMountainousAreaItem2;

  }

  /**
   * 提供時間コンテナを取得します。
   * @return 提供時間コンテナ
   */
  public ACBackLabelContainer getRecuperationManagementGuidanceTimeContena(){
    if(recuperationManagementGuidanceTimeContena==null){

      recuperationManagementGuidanceTimeContena = new ACBackLabelContainer();

      recuperationManagementGuidanceTimeContena.setFollowChildEnabled(true);

      addRecuperationManagementGuidanceTimeContena();
    }
    return recuperationManagementGuidanceTimeContena;

  }

  /**
   * 開始時刻コンボを取得します。
   * @return 開始時刻コンボ
   */
  public ACTimeComboBox getRecuperationManagementGuidanceBeginTime(){
    if(recuperationManagementGuidanceBeginTime==null){

      recuperationManagementGuidanceBeginTime = new ACTimeComboBox();

      getRecuperationManagementGuidanceBeginTimeContainer().setText("開始時刻");

      recuperationManagementGuidanceBeginTime.setBindPath("3");

      recuperationManagementGuidanceBeginTime.setModelBindPath("3");

      recuperationManagementGuidanceBeginTime.setRenderBindPath("CONTENT");

      recuperationManagementGuidanceBeginTime.setModel(getRecuperationManagementGuidanceBeginTimeModel());

      addRecuperationManagementGuidanceBeginTime();
    }
    return recuperationManagementGuidanceBeginTime;

  }

  /**
   * 開始時刻コンボコンテナを取得します。
   * @return 開始時刻コンボコンテナ
   */
  protected ACLabelContainer getRecuperationManagementGuidanceBeginTimeContainer(){
    if(recuperationManagementGuidanceBeginTimeContainer==null){
      recuperationManagementGuidanceBeginTimeContainer = new ACLabelContainer();
      recuperationManagementGuidanceBeginTimeContainer.setFollowChildEnabled(true);
      recuperationManagementGuidanceBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      recuperationManagementGuidanceBeginTimeContainer.add(getRecuperationManagementGuidanceBeginTime(), null);
    }
    return recuperationManagementGuidanceBeginTimeContainer;
  }

  /**
   * 開始時刻コンボモデルを取得します。
   * @return 開始時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getRecuperationManagementGuidanceBeginTimeModel(){
    if(recuperationManagementGuidanceBeginTimeModel==null){
      recuperationManagementGuidanceBeginTimeModel = new ACComboBoxModelAdapter();
      addRecuperationManagementGuidanceBeginTimeModel();
    }
    return recuperationManagementGuidanceBeginTimeModel;
  }

  /**
   * 終了時刻コンボを取得します。
   * @return 終了時刻コンボ
   */
  public ACTimeComboBox getRecuperationManagementGuidanceEndTime(){
    if(recuperationManagementGuidanceEndTime==null){

      recuperationManagementGuidanceEndTime = new ACTimeComboBox();

      getRecuperationManagementGuidanceEndTimeContainer().setText("終了時刻");

      recuperationManagementGuidanceEndTime.setBindPath("4");

      recuperationManagementGuidanceEndTime.setModelBindPath("4");

      recuperationManagementGuidanceEndTime.setRenderBindPath("CONTENT");

      recuperationManagementGuidanceEndTime.setModel(getRecuperationManagementGuidanceEndTimeModel());

      addRecuperationManagementGuidanceEndTime();
    }
    return recuperationManagementGuidanceEndTime;

  }

  /**
   * 終了時刻コンボコンテナを取得します。
   * @return 終了時刻コンボコンテナ
   */
  protected ACLabelContainer getRecuperationManagementGuidanceEndTimeContainer(){
    if(recuperationManagementGuidanceEndTimeContainer==null){
      recuperationManagementGuidanceEndTimeContainer = new ACLabelContainer();
      recuperationManagementGuidanceEndTimeContainer.setFollowChildEnabled(true);
      recuperationManagementGuidanceEndTimeContainer.setVAlignment(VRLayout.CENTER);
      recuperationManagementGuidanceEndTimeContainer.add(getRecuperationManagementGuidanceEndTime(), null);
    }
    return recuperationManagementGuidanceEndTimeContainer;
  }

  /**
   * 終了時刻コンボモデルを取得します。
   * @return 終了時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getRecuperationManagementGuidanceEndTimeModel(){
    if(recuperationManagementGuidanceEndTimeModel==null){
      recuperationManagementGuidanceEndTimeModel = new ACComboBoxModelAdapter();
      addRecuperationManagementGuidanceEndTimeModel();
    }
    return recuperationManagementGuidanceEndTimeModel;
  }

  /**
   * コンストラクタです。
   */
  public QS001_13111_201804Design() {

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

    this.add(getRecuperationManagementGuidancePatterns(), VRLayout.CLIENT);

  }

  /**
   * 短期入所療養介護（居宅療養管理指導）パターン領域）に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidancePatterns(){

    recuperationManagementGuidancePatterns.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * タブに内部項目を追加します。
   */
  protected void addTabs(){

    tabs.addTab("1", getTab1());

    tabs.addTab("2", getTab2());

  }

  /**
   * タブ1に内部項目を追加します。
   */
  protected void addTab1(){

    tab1.add(getRecuperationManagementGuidanceOccupationalCategoryContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getPatientGroup(), VRLayout.FLOW_RETURN);

  }

  /**
   * 担当者区分に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategory(){

  }

  /**
   * 担当者区分モデルに内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryModel(){

    getRecuperationManagementGuidanceOccupationalCategoryDoctor1().setButtonIndex(1);

    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryDoctor1());

    getRecuperationManagementGuidanceOccupationalCategoryDoctor2().setButtonIndex(8);

    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryDoctor2());

    getRecuperationManagementGuidanceOccupationalCategoryDentist().setButtonIndex(2);

    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryDentist());

    getRecuperationManagementGuidanceOccupationalCategoryHealth().setButtonIndex(7);

    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryHealth());

    getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacist().setButtonIndex(3);

    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacist());

    getRecuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist().setButtonIndex(4);

    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist());

    getRecuperationManagementGuidanceOccupationalCategoryDietitian().setButtonIndex(5);

    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryDietitian());

    getRecuperationManagementGuidanceOccupationalCategoryEtc().setButtonIndex(6);

    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryEtc());

  }

  /**
   * 医師(指導費I)に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryDoctor1(){

  }

  /**
   * 医師(指導費II)　医学総合管理料に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryDoctor2(){

  }

  /**
   * 歯科医師に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryDentist(){

  }

  /**
   * 看護職員に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryHealth(){

  }

  /**
   * 薬剤師(医療機関)に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacist(){

  }

  /**
   * 薬剤師(薬局)に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist(){

  }

  /**
   * 管理栄養士に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryDietitian(){

  }

  /**
   * 歯科衛生士等に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryEtc(){

  }

  /**
   * 利用者区分に内部項目を追加します。
   */
  protected void addPatientGroup(){

    patientGroup.add(getPatientRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    patientGroup.add(getPatientOldRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    patientGroup.add(getRecuperationManagementGuidanceTimesCancerEndCheck(), VRLayout.FLOW);

  }

  /**
   * 所在地区分に内部項目を追加します。
   */
  protected void addPatientRadioGroup(){

  }

  /**
   * 所在地区分モデルに内部項目を追加します。
   */
  protected void addPatientRadioGroupModel(){

    getPatientLocationRadioItem1().setButtonIndex(1);

    getPatientRadioGroupModel().add(getPatientLocationRadioItem1());

    getPatientLocationRadioItem2().setButtonIndex(2);

    getPatientRadioGroupModel().add(getPatientLocationRadioItem2());

    getPatientLocationRadioItem3().setButtonIndex(3);

    getPatientRadioGroupModel().add(getPatientLocationRadioItem3());

  }

  /**
   * 単一建物居住者（1人）に内部項目を追加します。
   */
  protected void addPatientLocationRadioItem1(){

  }

  /**
   * 単一建物居住者（2～9人）に内部項目を追加します。
   */
  protected void addPatientLocationRadioItem2(){

  }

  /**
   * 上記以外に内部項目を追加します。
   */
  protected void addPatientLocationRadioItem3(){

  }

  /**
   * 所在地区分に内部項目を追加します。
   */
  protected void addPatientOldRadioGroup(){

  }

  /**
   * 所在地区分モデルに内部項目を追加します。
   */
  protected void addPatientOldRadioGroupModel(){

    getPatientRadioItem1().setButtonIndex(1);

    getPatientOldRadioGroupModel().add(getPatientRadioItem1());

    getPatientRadioItem2().setButtonIndex(2);

    getPatientOldRadioGroupModel().add(getPatientRadioItem2());

  }

  /**
   * 同一建物居住者以外に内部項目を追加します。
   */
  protected void addPatientRadioItem1(){

  }

  /**
   * 居宅系施設入居者に内部項目を追加します。
   */
  protected void addPatientRadioItem2(){

  }

  /**
   * ガン末期等に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceTimesCancerEndCheck(){

  }

  /**
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKyotakuClassContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getProviderAddMountainousAreaRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getRecuperationManagementGuidanceTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * 特別薬剤に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio(){

  }

  /**
   * 特別薬剤モデルに内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel(){

    getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1().setButtonIndex(1);

    getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel().add(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1());

    getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2().setButtonIndex(2);

    getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel().add(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2(){

  }

  /**
   * 看護職員区分に内部項目を追加します。
   */
  protected void addKyotakuClass(){

  }

  /**
   * 看護職員区分モデルに内部項目を追加します。
   */
  protected void addKyotakuClassModel(){

    getKyotakuClass1().setButtonIndex(1);

    getKyotakuClassModel().add(getKyotakuClass1());

    getKyotakuClass2().setButtonIndex(2);

    getKyotakuClassModel().add(getKyotakuClass2());

  }

  /**
   * 正看等に内部項目を追加します。
   */
  protected void addKyotakuClass1(){

  }

  /**
   * 准看に内部項目を追加します。
   */
  protected void addKyotakuClass2(){

  }

  /**
   * 中山間地域等でのサービス提供加算に内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRadioGroup(){

  }

  /**
   * 中山間地域等でのサービス提供加算モデルに内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRadioGroupModel(){

    getProviderAddMountainousAreaItem1().setButtonIndex(1);

    getProviderAddMountainousAreaRadioGroupModel().add(getProviderAddMountainousAreaItem1());

    getProviderAddMountainousAreaItem2().setButtonIndex(2);

    getProviderAddMountainousAreaRadioGroupModel().add(getProviderAddMountainousAreaItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaItem2(){

  }

  /**
   * 提供時間コンテナに内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceTimeContena(){

    recuperationManagementGuidanceTimeContena.add(getRecuperationManagementGuidanceBeginTimeContainer(), VRLayout.FLOW);

    recuperationManagementGuidanceTimeContena.add(getRecuperationManagementGuidanceEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * 開始時刻コンボに内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceBeginTime(){

  }

  /**
   * 開始時刻コンボモデルに内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceBeginTimeModel(){

  }

  /**
   * 終了時刻コンボに内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceEndTime(){

  }

  /**
   * 終了時刻コンボモデルに内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceEndTimeModel(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_13111_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_13111_201804Design getThis() {
    return this;
  }
}
