
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
 * 作成日: 2015/02/19  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン介護予防居宅療養管理指導 (QS001_13411_201504)
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
 * サービスパターン介護予防居宅療養管理指導画面項目デザイン(QS001_13411_201504) 
 */
public class QS001_13411_201504Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel recuperationManagementGuidancePatterns;

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup chargeClassificationRadioGroup;

  private ACLabelContainer chargeClassificationRadioGroupContainer;

  private ACListModelAdapter chargeClassificationRadioGroupModel;

  private ACRadioButtonItem chargeClassificationRadioItem1;

  private ACRadioButtonItem chargeClassificationRadioItem2;

  private ACRadioButtonItem chargeClassificationRadioItem3;

  private ACRadioButtonItem chargeClassificationRadioItem4;

  private ACRadioButtonItem chargeClassificationRadioItem5;

  private ACRadioButtonItem chargeClassificationRadioItem6;

  private ACRadioButtonItem chargeClassificationRadioItem7;

  private ACValueArrayRadioButtonGroup medicineManagementRadioGroup;

  private ACLabelContainer medicineManagementRadioGroupContainer;

  private ACListModelAdapter medicineManagementRadioGroupModel;

  private ACRadioButtonItem medicineManagementRadioItem1;

  private ACRadioButtonItem medicineManagementRadioItem2;

  private ACGroupBox patientGroup;

  private ACValueArrayRadioButtonGroup patientDivisionRadio;

  private ACLabelContainer patientDivisionRadioContainer;

  private ACListModelAdapter patientDivisionRadioModel;

  private ACRadioButtonItem patientDivisionRadioItem1;

  private ACRadioButtonItem patientDivisionRadioItem2;

  private ACIntegerCheckBox recuperationManagementGuidanceTimesCancerEndCheck;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup specialMedicineRadioGroup;

  private ACLabelContainer specialMedicineRadioGroupContainer;

  private ACListModelAdapter specialMedicineRadioGroupModel;

  private ACRadioButtonItem specialMedicineRadioItem1;

  private ACRadioButtonItem specialMedicineRadioItem2;

  private ACValueArrayRadioButtonGroup kyotakuClass;

  private ACLabelContainer kyotakuClassContainer;

  private ACListModelAdapter kyotakuClassModel;

  private ACRadioButtonItem kyotakuClass1;

  private ACRadioButtonItem kyotakuClass2;

  private ACBackLabelContainer recuperationManagementGuidanceTimeContena;

  private ACTimeComboBox recuperationManagementGuidanceBeginTime;

  private ACLabelContainer recuperationManagementGuidanceBeginTimeContainer;

  private ACComboBoxModelAdapter recuperationManagementGuidanceBeginTimeModel;

  private ACTimeComboBox recuperationManagementGuidanceEndTime;

  private ACLabelContainer recuperationManagementGuidanceEndTimeContainer;

  private ACComboBoxModelAdapter recuperationManagementGuidanceEndTimeModel;

  //getter

  /**
   * 居宅療養管理指導パターン領域を取得します。
   * @return 居宅療養管理指導パターン領域
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
   * タブ１を取得します。
   * @return タブ１
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
  public ACValueArrayRadioButtonGroup getChargeClassificationRadioGroup(){
    if(chargeClassificationRadioGroup==null){

      chargeClassificationRadioGroup = new ACValueArrayRadioButtonGroup();

      getChargeClassificationRadioGroupContainer().setText("担当者区分");

      chargeClassificationRadioGroup.setBindPath("1340108");

      chargeClassificationRadioGroup.setNoSelectIndex(0);

      chargeClassificationRadioGroup.setUseClearButton(false);

      chargeClassificationRadioGroup.setModel(getChargeClassificationRadioGroupModel());

      chargeClassificationRadioGroup.setValues(new int[]{1,2,3,4,5,6,7});

      addChargeClassificationRadioGroup();
    }
    return chargeClassificationRadioGroup;

  }

  /**
   * 担当者区分コンテナを取得します。
   * @return 担当者区分コンテナ
   */
  protected ACLabelContainer getChargeClassificationRadioGroupContainer(){
    if(chargeClassificationRadioGroupContainer==null){
      chargeClassificationRadioGroupContainer = new ACLabelContainer();
      chargeClassificationRadioGroupContainer.setFollowChildEnabled(true);
      chargeClassificationRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      chargeClassificationRadioGroupContainer.add(getChargeClassificationRadioGroup(), null);
    }
    return chargeClassificationRadioGroupContainer;
  }

  /**
   * 担当者区分モデルを取得します。
   * @return 担当者区分モデル
   */
  protected ACListModelAdapter getChargeClassificationRadioGroupModel(){
    if(chargeClassificationRadioGroupModel==null){
      chargeClassificationRadioGroupModel = new ACListModelAdapter();
      addChargeClassificationRadioGroupModel();
    }
    return chargeClassificationRadioGroupModel;
  }

  /**
   * 医師を取得します。
   * @return 医師
   */
  public ACRadioButtonItem getChargeClassificationRadioItem1(){
    if(chargeClassificationRadioItem1==null){

      chargeClassificationRadioItem1 = new ACRadioButtonItem();

      chargeClassificationRadioItem1.setText("医師");

      chargeClassificationRadioItem1.setGroup(getChargeClassificationRadioGroup());

      chargeClassificationRadioItem1.setConstraints(VRLayout.FLOW);

      addChargeClassificationRadioItem1();
    }
    return chargeClassificationRadioItem1;

  }

  /**
   * 歯科医師を取得します。
   * @return 歯科医師
   */
  public ACRadioButtonItem getChargeClassificationRadioItem2(){
    if(chargeClassificationRadioItem2==null){

      chargeClassificationRadioItem2 = new ACRadioButtonItem();

      chargeClassificationRadioItem2.setText("歯科医師");

      chargeClassificationRadioItem2.setGroup(getChargeClassificationRadioGroup());

      chargeClassificationRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addChargeClassificationRadioItem2();
    }
    return chargeClassificationRadioItem2;

  }

  /**
   * 薬剤師（医療機関）を取得します。
   * @return 薬剤師（医療機関）
   */
  public ACRadioButtonItem getChargeClassificationRadioItem3(){
    if(chargeClassificationRadioItem3==null){

      chargeClassificationRadioItem3 = new ACRadioButtonItem();

      chargeClassificationRadioItem3.setText("薬剤師（医療機関）");

      chargeClassificationRadioItem3.setGroup(getChargeClassificationRadioGroup());

      chargeClassificationRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addChargeClassificationRadioItem3();
    }
    return chargeClassificationRadioItem3;

  }

  /**
   * 薬剤師（薬局）を取得します。
   * @return 薬剤師（薬局）
   */
  public ACRadioButtonItem getChargeClassificationRadioItem4(){
    if(chargeClassificationRadioItem4==null){

      chargeClassificationRadioItem4 = new ACRadioButtonItem();

      chargeClassificationRadioItem4.setText("薬剤師（薬局）");

      chargeClassificationRadioItem4.setGroup(getChargeClassificationRadioGroup());

      chargeClassificationRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addChargeClassificationRadioItem4();
    }
    return chargeClassificationRadioItem4;

  }

  /**
   * 管理栄養士を取得します。
   * @return 管理栄養士
   */
  public ACRadioButtonItem getChargeClassificationRadioItem5(){
    if(chargeClassificationRadioItem5==null){

      chargeClassificationRadioItem5 = new ACRadioButtonItem();

      chargeClassificationRadioItem5.setText("管理栄養士");

      chargeClassificationRadioItem5.setGroup(getChargeClassificationRadioGroup());

      chargeClassificationRadioItem5.setConstraints(VRLayout.FLOW);

      addChargeClassificationRadioItem5();
    }
    return chargeClassificationRadioItem5;

  }

  /**
   * 歯科衛生士等を取得します。
   * @return 歯科衛生士等
   */
  public ACRadioButtonItem getChargeClassificationRadioItem6(){
    if(chargeClassificationRadioItem6==null){

      chargeClassificationRadioItem6 = new ACRadioButtonItem();

      chargeClassificationRadioItem6.setText("歯科衛生士等");

      chargeClassificationRadioItem6.setGroup(getChargeClassificationRadioGroup());

      chargeClassificationRadioItem6.setConstraints(VRLayout.FLOW_RETURN);

      addChargeClassificationRadioItem6();
    }
    return chargeClassificationRadioItem6;

  }

  /**
   * 看護職員を取得します。
   * @return 看護職員
   */
  public ACRadioButtonItem getChargeClassificationRadioItem7(){
    if(chargeClassificationRadioItem7==null){

      chargeClassificationRadioItem7 = new ACRadioButtonItem();

      chargeClassificationRadioItem7.setText("看護職員");

      chargeClassificationRadioItem7.setGroup(getChargeClassificationRadioGroup());

      chargeClassificationRadioItem7.setConstraints(VRLayout.FLOW_RETURN);

      addChargeClassificationRadioItem7();
    }
    return chargeClassificationRadioItem7;

  }

  /**
   * 医学総合管理料を取得します。
   * @return 医学総合管理料
   */
  public ACValueArrayRadioButtonGroup getMedicineManagementRadioGroup(){
    if(medicineManagementRadioGroup==null){

      medicineManagementRadioGroup = new ACValueArrayRadioButtonGroup();

      getMedicineManagementRadioGroupContainer().setText("医学総合管理料");

      medicineManagementRadioGroup.setBindPath("1340102");

      medicineManagementRadioGroup.setUseClearButton(false);

      medicineManagementRadioGroup.setModel(getMedicineManagementRadioGroupModel());

      medicineManagementRadioGroup.setValues(new int[]{1,2});

      addMedicineManagementRadioGroup();
    }
    return medicineManagementRadioGroup;

  }

  /**
   * 医学総合管理料コンテナを取得します。
   * @return 医学総合管理料コンテナ
   */
  protected ACLabelContainer getMedicineManagementRadioGroupContainer(){
    if(medicineManagementRadioGroupContainer==null){
      medicineManagementRadioGroupContainer = new ACLabelContainer();
      medicineManagementRadioGroupContainer.setFollowChildEnabled(true);
      medicineManagementRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      medicineManagementRadioGroupContainer.add(getMedicineManagementRadioGroup(), null);
    }
    return medicineManagementRadioGroupContainer;
  }

  /**
   * 医学総合管理料モデルを取得します。
   * @return 医学総合管理料モデル
   */
  protected ACListModelAdapter getMedicineManagementRadioGroupModel(){
    if(medicineManagementRadioGroupModel==null){
      medicineManagementRadioGroupModel = new ACListModelAdapter();
      addMedicineManagementRadioGroupModel();
    }
    return medicineManagementRadioGroupModel;
  }

  /**
   * なし（指導費 ( I ) ）を取得します。
   * @return なし（指導費 ( I ) ）
   */
  public ACRadioButtonItem getMedicineManagementRadioItem1(){
    if(medicineManagementRadioItem1==null){

      medicineManagementRadioItem1 = new ACRadioButtonItem();

      medicineManagementRadioItem1.setText("なし（指導費 ( I ) ）");

      medicineManagementRadioItem1.setGroup(getMedicineManagementRadioGroup());

      medicineManagementRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addMedicineManagementRadioItem1();
    }
    return medicineManagementRadioItem1;

  }

  /**
   * あり（指導費 ( II ) ）を取得します。
   * @return あり（指導費 ( II ) ）
   */
  public ACRadioButtonItem getMedicineManagementRadioItem2(){
    if(medicineManagementRadioItem2==null){

      medicineManagementRadioItem2 = new ACRadioButtonItem();

      medicineManagementRadioItem2.setText("あり（指導費 ( II ) ）");

      medicineManagementRadioItem2.setGroup(getMedicineManagementRadioGroup());

      medicineManagementRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicineManagementRadioItem2();
    }
    return medicineManagementRadioItem2;

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
  public ACValueArrayRadioButtonGroup getPatientDivisionRadio(){
    if(patientDivisionRadio==null){

      patientDivisionRadio = new ACValueArrayRadioButtonGroup();

      getPatientDivisionRadioContainer().setText("所在地区分");

      patientDivisionRadio.setBindPath("16");

      patientDivisionRadio.setNoSelectIndex(0);

      patientDivisionRadio.setUseClearButton(false);

      patientDivisionRadio.setModel(getPatientDivisionRadioModel());

      patientDivisionRadio.setValues(new int[]{1,2});

      addPatientDivisionRadio();
    }
    return patientDivisionRadio;

  }

  /**
   * 所在地区分コンテナを取得します。
   * @return 所在地区分コンテナ
   */
  protected ACLabelContainer getPatientDivisionRadioContainer(){
    if(patientDivisionRadioContainer==null){
      patientDivisionRadioContainer = new ACLabelContainer();
      patientDivisionRadioContainer.setFollowChildEnabled(true);
      patientDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      patientDivisionRadioContainer.add(getPatientDivisionRadio(), null);
    }
    return patientDivisionRadioContainer;
  }

  /**
   * 所在地区分モデルを取得します。
   * @return 所在地区分モデル
   */
  protected ACListModelAdapter getPatientDivisionRadioModel(){
    if(patientDivisionRadioModel==null){
      patientDivisionRadioModel = new ACListModelAdapter();
      addPatientDivisionRadioModel();
    }
    return patientDivisionRadioModel;
  }

  /**
   * 同一建物居住者以外を取得します。
   * @return 同一建物居住者以外
   */
  public ACRadioButtonItem getPatientDivisionRadioItem1(){
    if(patientDivisionRadioItem1==null){

      patientDivisionRadioItem1 = new ACRadioButtonItem();

      patientDivisionRadioItem1.setText("<html>同一建物居住者以外<br>（指導費：( I ) 503単位／( II ) 292単位）<html>");

      patientDivisionRadioItem1.setGroup(getPatientDivisionRadio());

      patientDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addPatientDivisionRadioItem1();
    }
    return patientDivisionRadioItem1;

  }

  /**
   * 同一建物居住者を取得します。
   * @return 同一建物居住者
   */
  public ACRadioButtonItem getPatientDivisionRadioItem2(){
    if(patientDivisionRadioItem2==null){

      patientDivisionRadioItem2 = new ACRadioButtonItem();

      patientDivisionRadioItem2.setText("<html>同一建物居住者<br>（指導費：( I ) 452単位／( II ) 262単位）<html>");

      patientDivisionRadioItem2.setGroup(getPatientDivisionRadio());

      patientDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addPatientDivisionRadioItem2();
    }
    return patientDivisionRadioItem2;

  }

  /**
   * ガン末期等を取得します。
   * @return ガン末期等
   */
  public ACIntegerCheckBox getRecuperationManagementGuidanceTimesCancerEndCheck(){
    if(recuperationManagementGuidanceTimesCancerEndCheck==null){

      recuperationManagementGuidanceTimesCancerEndCheck = new ACIntegerCheckBox();

      recuperationManagementGuidanceTimesCancerEndCheck.setText("ガン末期等");

      recuperationManagementGuidanceTimesCancerEndCheck.setBindPath("1340107");

      recuperationManagementGuidanceTimesCancerEndCheck.setSelectValue(2);

      recuperationManagementGuidanceTimesCancerEndCheck.setUnSelectValue(1);

      addRecuperationManagementGuidanceTimesCancerEndCheck();
    }
    return recuperationManagementGuidanceTimesCancerEndCheck;

  }

  /**
   * タブ２を取得します。
   * @return タブ２
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
  public ACValueArrayRadioButtonGroup getSpecialMedicineRadioGroup(){
    if(specialMedicineRadioGroup==null){

      specialMedicineRadioGroup = new ACValueArrayRadioButtonGroup();

      getSpecialMedicineRadioGroupContainer().setText("特別薬剤");

      specialMedicineRadioGroup.setBindPath("1340103");

      specialMedicineRadioGroup.setUseClearButton(false);

      specialMedicineRadioGroup.setModel(getSpecialMedicineRadioGroupModel());

      specialMedicineRadioGroup.setValues(new int[]{1,2});

      addSpecialMedicineRadioGroup();
    }
    return specialMedicineRadioGroup;

  }

  /**
   * 特別薬剤コンテナを取得します。
   * @return 特別薬剤コンテナ
   */
  protected ACLabelContainer getSpecialMedicineRadioGroupContainer(){
    if(specialMedicineRadioGroupContainer==null){
      specialMedicineRadioGroupContainer = new ACLabelContainer();
      specialMedicineRadioGroupContainer.setFollowChildEnabled(true);
      specialMedicineRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      specialMedicineRadioGroupContainer.add(getSpecialMedicineRadioGroup(), null);
    }
    return specialMedicineRadioGroupContainer;
  }

  /**
   * 特別薬剤モデルを取得します。
   * @return 特別薬剤モデル
   */
  protected ACListModelAdapter getSpecialMedicineRadioGroupModel(){
    if(specialMedicineRadioGroupModel==null){
      specialMedicineRadioGroupModel = new ACListModelAdapter();
      addSpecialMedicineRadioGroupModel();
    }
    return specialMedicineRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSpecialMedicineRadioItem1(){
    if(specialMedicineRadioItem1==null){

      specialMedicineRadioItem1 = new ACRadioButtonItem();

      specialMedicineRadioItem1.setText("なし");

      specialMedicineRadioItem1.setGroup(getSpecialMedicineRadioGroup());

      specialMedicineRadioItem1.setConstraints(VRLayout.FLOW);

      addSpecialMedicineRadioItem1();
    }
    return specialMedicineRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getSpecialMedicineRadioItem2(){
    if(specialMedicineRadioItem2==null){

      specialMedicineRadioItem2 = new ACRadioButtonItem();

      specialMedicineRadioItem2.setText("あり");

      specialMedicineRadioItem2.setGroup(getSpecialMedicineRadioGroup());

      specialMedicineRadioItem2.setConstraints(VRLayout.FLOW);

      addSpecialMedicineRadioItem2();
    }
    return specialMedicineRadioItem2;

  }

  /**
   * 看護職員区分を取得します。
   * @return 看護職員区分
   */
  public ACValueArrayRadioButtonGroup getKyotakuClass(){
    if(kyotakuClass==null){

      kyotakuClass = new ACValueArrayRadioButtonGroup();

      getKyotakuClassContainer().setText("看護職員区分");

      kyotakuClass.setBindPath("1340109");

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
  public QS001_13411_201504Design() {

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
   * 居宅療養管理指導パターン領域に内部項目を追加します。
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
   * タブ１に内部項目を追加します。
   */
  protected void addTab1(){

    tab1.add(getChargeClassificationRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicineManagementRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getPatientGroup(), VRLayout.FLOW_RETURN);

  }

  /**
   * 担当者区分に内部項目を追加します。
   */
  protected void addChargeClassificationRadioGroup(){

  }

  /**
   * 担当者区分モデルに内部項目を追加します。
   */
  protected void addChargeClassificationRadioGroupModel(){

    getChargeClassificationRadioItem1().setButtonIndex(1);

    getChargeClassificationRadioGroupModel().add(getChargeClassificationRadioItem1());

    getChargeClassificationRadioItem2().setButtonIndex(2);

    getChargeClassificationRadioGroupModel().add(getChargeClassificationRadioItem2());

    getChargeClassificationRadioItem3().setButtonIndex(3);

    getChargeClassificationRadioGroupModel().add(getChargeClassificationRadioItem3());

    getChargeClassificationRadioItem4().setButtonIndex(4);

    getChargeClassificationRadioGroupModel().add(getChargeClassificationRadioItem4());

    getChargeClassificationRadioItem5().setButtonIndex(5);

    getChargeClassificationRadioGroupModel().add(getChargeClassificationRadioItem5());

    getChargeClassificationRadioItem6().setButtonIndex(6);

    getChargeClassificationRadioGroupModel().add(getChargeClassificationRadioItem6());

    getChargeClassificationRadioItem7().setButtonIndex(7);

    getChargeClassificationRadioGroupModel().add(getChargeClassificationRadioItem7());

  }

  /**
   * 医師に内部項目を追加します。
   */
  protected void addChargeClassificationRadioItem1(){

  }

  /**
   * 歯科医師に内部項目を追加します。
   */
  protected void addChargeClassificationRadioItem2(){

  }

  /**
   * 薬剤師（医療機関）に内部項目を追加します。
   */
  protected void addChargeClassificationRadioItem3(){

  }

  /**
   * 薬剤師（薬局）に内部項目を追加します。
   */
  protected void addChargeClassificationRadioItem4(){

  }

  /**
   * 管理栄養士に内部項目を追加します。
   */
  protected void addChargeClassificationRadioItem5(){

  }

  /**
   * 歯科衛生士等に内部項目を追加します。
   */
  protected void addChargeClassificationRadioItem6(){

  }

  /**
   * 看護職員に内部項目を追加します。
   */
  protected void addChargeClassificationRadioItem7(){

  }

  /**
   * 医学総合管理料に内部項目を追加します。
   */
  protected void addMedicineManagementRadioGroup(){

  }

  /**
   * 医学総合管理料モデルに内部項目を追加します。
   */
  protected void addMedicineManagementRadioGroupModel(){

    getMedicineManagementRadioItem1().setButtonIndex(1);

    getMedicineManagementRadioGroupModel().add(getMedicineManagementRadioItem1());

    getMedicineManagementRadioItem2().setButtonIndex(2);

    getMedicineManagementRadioGroupModel().add(getMedicineManagementRadioItem2());

  }

  /**
   * なし（指導費 ( I ) ）に内部項目を追加します。
   */
  protected void addMedicineManagementRadioItem1(){

  }

  /**
   * あり（指導費 ( II ) ）に内部項目を追加します。
   */
  protected void addMedicineManagementRadioItem2(){

  }

  /**
   * 利用者区分に内部項目を追加します。
   */
  protected void addPatientGroup(){

    patientGroup.add(getPatientDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    patientGroup.add(getRecuperationManagementGuidanceTimesCancerEndCheck(), VRLayout.FLOW);

  }

  /**
   * 所在地区分に内部項目を追加します。
   */
  protected void addPatientDivisionRadio(){

  }

  /**
   * 所在地区分モデルに内部項目を追加します。
   */
  protected void addPatientDivisionRadioModel(){

    getPatientDivisionRadioItem1().setButtonIndex(1);

    getPatientDivisionRadioModel().add(getPatientDivisionRadioItem1());

    getPatientDivisionRadioItem2().setButtonIndex(2);

    getPatientDivisionRadioModel().add(getPatientDivisionRadioItem2());

  }

  /**
   * 同一建物居住者以外に内部項目を追加します。
   */
  protected void addPatientDivisionRadioItem1(){

  }

  /**
   * 同一建物居住者に内部項目を追加します。
   */
  protected void addPatientDivisionRadioItem2(){

  }

  /**
   * ガン末期等に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceTimesCancerEndCheck(){

  }

  /**
   * タブ２に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getSpecialMedicineRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKyotakuClassContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getRecuperationManagementGuidanceTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * 特別薬剤に内部項目を追加します。
   */
  protected void addSpecialMedicineRadioGroup(){

  }

  /**
   * 特別薬剤モデルに内部項目を追加します。
   */
  protected void addSpecialMedicineRadioGroupModel(){

    getSpecialMedicineRadioItem1().setButtonIndex(1);

    getSpecialMedicineRadioGroupModel().add(getSpecialMedicineRadioItem1());

    getSpecialMedicineRadioItem2().setButtonIndex(2);

    getSpecialMedicineRadioGroupModel().add(getSpecialMedicineRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSpecialMedicineRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addSpecialMedicineRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_13411_201504Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_13411_201504Design getThis() {
    return this;
  }
}
