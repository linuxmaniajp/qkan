
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
 * 開発者: 小笠　貴志
 * 作成日: 2006/02/18  日本コンピューター株式会社 小笠　貴志 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業者登録 (004)
 * プログラム 介護療養型医療施設（療養型病院） (QO004018)
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
import jp.or.med.orca.qkan.lib.*;
import jp.or.med.orca.qkan.text.*;
/**
 * 介護療養型医療施設（療養型病院）画面項目デザイン(QO004018) 
 */
public class QO004018Design extends ACPanel {
  //GUIコンポーネント

  private ACGroupBox kaigoRecuperationMedicalFacilitiesGroup;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesDiscountContainer;

  private ACTextField kaigoRecuperationMedicalFacilitiesDiscountRate;

  private ACLabel percentSign;

  private ACClearableRadioButtonGroup InstitutionDivisionRadio;

  private ACLabelContainer InstitutionDivisionRadioContainer;

  private ACListModelAdapter InstitutionDivisionRadioModel;

  private ACRadioButtonItem InstitutionDivisionRadioItem1;

  private ACRadioButtonItem InstitutionDivisionRadioItem2;

  private ACClearableRadioButtonGroup staffAssignmentDivision;

  private ACLabelContainer staffAssignmentDivisionContainer;

  private ACListModelAdapter staffAssignmentDivisionModel;

  private ACRadioButtonItem staffAssignmentDivision1;

  private ACRadioButtonItem staffAssignmentDivision2;

  private ACRadioButtonItem staffAssignmentDivision3;

  private ACClearableRadioButtonGroup nightShiftCondition;

  private ACLabelContainer nightShiftConditionContainer;

  private ACListModelAdapter nightShiftConditionModel;

  private ACRadioButtonItem nightShiftConditionStandard;

  private ACRadioButtonItem nightShiftConditionAddition1;

  private ACRadioButtonItem nightShiftConditionAddition2;

  private ACRadioButtonItem nightShiftConditionAddition3;

  private ACRadioButtonItem nightShiftConditionSubtraction;

  private ACClearableRadioButtonGroup recuperationEnvironmental;

  private ACLabelContainer recuperationEnvironmentalContainer;

  private ACListModelAdapter recuperationEnvironmentalModel;

  private ACRadioButtonItem recuperationEnvironmentalStandard;

  private ACRadioButtonItem recuperationEnvironmentalSubtraction1;

  private ACRadioButtonItem recuperationEnvironmentalSubtraction2;

  private ACRadioButtonItem recuperationEnvironmentalSubtraction3;

  private ACClearableRadioButtonGroup doctorsArrangement;

  private ACLabelContainer doctorsArrangementContainer;

  private ACListModelAdapter doctorsArrangementModel;

  private ACRadioButtonItem doctorsArrangementStandard;

  private ACRadioButtonItem doctorsArrangementArticle49;

  private ACClearableRadioButtonGroup nutritionManageRadio;

  private ACLabelContainer nutritionManageRadioContainer;

  private ACListModelAdapter nutritionManageRadioModel;

  private ACRadioButtonItem nutritionManageRadioItem1;

  private ACRadioButtonItem nutritionManageRadioItem2;

  private ACClearableRadioButtonGroup nutritionRadio;

  private ACLabelContainer nutritionRadioContainer;

  private ACListModelAdapter nutritionRadioModel;

  private ACRadioButtonItem nutritionRadioItem1;

  private ACRadioButtonItem nutritionRadioItem2 ;

  private ACClearableRadioButtonGroup oralSwitchRadio;

  private ACLabelContainer oralSwitchRadioContainer;

  private ACListModelAdapter oralSwitchRadioModel;

  private ACRadioButtonItem oralSwitchRadioItem1;

  private ACRadioButtonItem oralSwitchRadioItem2 ;

  private ACClearableRadioButtonGroup recuperateDinnerRadio;

  private ACLabelContainer recuperateDinnerRadioContainer;

  private ACListModelAdapter recuperateDinnerRadioModel;

  private ACRadioButtonItem recuperateDinnerRadioItem1;

  private ACRadioButtonItem recuperateDinnerRadioItem2;

  private ACComboBox staffReduce;

  private ACLabelContainer staffReduceContainer;

  private ACComboBoxModelAdapter staffReduceModel;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner;

  private ACTextField kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyTotal;

  private ACLabel kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoneyLabel;

  private ACTextField kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney;

  private ACLabel kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoneyLabel;

  private ACTextField kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney;

  private ACLabel kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoneyLabel;

  private ACTextField kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney;

  private ACLabel kaigoRecuperationMedicalFacilitiesDinnerBasicMoney4Label;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyConteiner;

  private ACTextField kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyText;

  private ACLabel kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyLabel;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyConteiner;

  private ACTextField kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyText;

  private ACLabel kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyLabel;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyConteiner;

  private ACTextField kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyText;

  private ACLabel kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyLabel;

  private ACLabelContainer kaigoRecuperationMedicalFacilitiesTasyouRoomConteiner;

  private ACTextField kaigoRecuperationMedicalFacilitiesTasyouRoomText;

  private ACLabel kaigoRecuperationMedicalFacilitiesTasyouRoomLabel;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getKaigoRecuperationMedicalFacilitiesGroup(){
    if(kaigoRecuperationMedicalFacilitiesGroup==null){

      kaigoRecuperationMedicalFacilitiesGroup = new ACGroupBox();

      kaigoRecuperationMedicalFacilitiesGroup.setText("介護療養型医療施設（療養型病院）");

      kaigoRecuperationMedicalFacilitiesGroup.setFollowChildEnabled(true);

      kaigoRecuperationMedicalFacilitiesGroup.setHgrid(200);

      addKaigoRecuperationMedicalFacilitiesGroup();
    }
    return kaigoRecuperationMedicalFacilitiesGroup;

  }

  /**
   * 割引率コンテナを取得します。
   * @return 割引率コンテナ
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesDiscountContainer(){
    if(kaigoRecuperationMedicalFacilitiesDiscountContainer==null){

      kaigoRecuperationMedicalFacilitiesDiscountContainer = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesDiscountContainer.setText("割引率");

      kaigoRecuperationMedicalFacilitiesDiscountContainer.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesDiscountContainer();
    }
    return kaigoRecuperationMedicalFacilitiesDiscountContainer;

  }

  /**
   * 割引率を取得します。
   * @return 割引率
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesDiscountRate(){
    if(kaigoRecuperationMedicalFacilitiesDiscountRate==null){

      kaigoRecuperationMedicalFacilitiesDiscountRate = new ACTextField();

      kaigoRecuperationMedicalFacilitiesDiscountRate.setBindPath("REDUCT_RATE");

      kaigoRecuperationMedicalFacilitiesDiscountRate.setColumns(3);

      kaigoRecuperationMedicalFacilitiesDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesDiscountRate.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesDiscountRate.setMaxLength(3);

      addKaigoRecuperationMedicalFacilitiesDiscountRate();
    }
    return kaigoRecuperationMedicalFacilitiesDiscountRate;

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
   * 施設区分ラジオグループを取得します。
   * @return 施設区分ラジオグループ
   */
  public ACClearableRadioButtonGroup getInstitutionDivisionRadio(){
    if(InstitutionDivisionRadio==null){

      InstitutionDivisionRadio = new ACClearableRadioButtonGroup();

      getInstitutionDivisionRadioContainer().setText("施設区分");

      InstitutionDivisionRadio.setBindPath("1530101");

      InstitutionDivisionRadio.setModel(getInstitutionDivisionRadioModel());

      InstitutionDivisionRadio.setUseClearButton(false);

      addInstitutionDivisionRadio();
    }
    return InstitutionDivisionRadio;

  }

  /**
   * 施設区分ラジオグループコンテナを取得します。
   * @return 施設区分ラジオグループコンテナ
   */
  protected ACLabelContainer getInstitutionDivisionRadioContainer(){
    if(InstitutionDivisionRadioContainer==null){
      InstitutionDivisionRadioContainer = new ACLabelContainer();
      InstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      InstitutionDivisionRadioContainer.add(getInstitutionDivisionRadio(), null);
    }
    return InstitutionDivisionRadioContainer;
  }

  /**
   * 施設区分ラジオグループモデルを取得します。
   * @return 施設区分ラジオグループモデル
   */
  protected ACListModelAdapter getInstitutionDivisionRadioModel(){
    if(InstitutionDivisionRadioModel==null){
      InstitutionDivisionRadioModel = new ACListModelAdapter();
      addInstitutionDivisionRadioModel();
    }
    return InstitutionDivisionRadioModel;
  }

  /**
   * 病院を取得します。
   * @return 病院
   */
  public ACRadioButtonItem getInstitutionDivisionRadioItem1(){
    if(InstitutionDivisionRadioItem1==null){

      InstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      InstitutionDivisionRadioItem1.setText("病院");

      InstitutionDivisionRadioItem1.setGroup(getInstitutionDivisionRadio());

      addInstitutionDivisionRadioItem1();
    }
    return InstitutionDivisionRadioItem1;

  }

  /**
   * ユニット型病院を取得します。
   * @return ユニット型病院
   */
  public ACRadioButtonItem getInstitutionDivisionRadioItem2(){
    if(InstitutionDivisionRadioItem2==null){

      InstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      InstitutionDivisionRadioItem2.setText("ユニット型病院");

      InstitutionDivisionRadioItem2.setGroup(getInstitutionDivisionRadio());

      addInstitutionDivisionRadioItem2();
    }
    return InstitutionDivisionRadioItem2;

  }

  /**
   * 人員配置区分ラジオグループを取得します。
   * @return 人員配置区分ラジオグループ
   */
  public ACClearableRadioButtonGroup getStaffAssignmentDivision(){
    if(staffAssignmentDivision==null){

      staffAssignmentDivision = new ACClearableRadioButtonGroup();

      getStaffAssignmentDivisionContainer().setText("人員配置区分");

      staffAssignmentDivision.setBindPath("1530102");

      staffAssignmentDivision.setModel(getStaffAssignmentDivisionModel());

      staffAssignmentDivision.setUseClearButton(false);

      addStaffAssignmentDivision();
    }
    return staffAssignmentDivision;

  }

  /**
   * 人員配置区分ラジオグループコンテナを取得します。
   * @return 人員配置区分ラジオグループコンテナ
   */
  protected ACLabelContainer getStaffAssignmentDivisionContainer(){
    if(staffAssignmentDivisionContainer==null){
      staffAssignmentDivisionContainer = new ACLabelContainer();
      staffAssignmentDivisionContainer.setFollowChildEnabled(true);
      staffAssignmentDivisionContainer.add(getStaffAssignmentDivision(), null);
    }
    return staffAssignmentDivisionContainer;
  }

  /**
   * 人員配置区分ラジオグループモデルを取得します。
   * @return 人員配置区分ラジオグループモデル
   */
  protected ACListModelAdapter getStaffAssignmentDivisionModel(){
    if(staffAssignmentDivisionModel==null){
      staffAssignmentDivisionModel = new ACListModelAdapter();
      addStaffAssignmentDivisionModel();
    }
    return staffAssignmentDivisionModel;
  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getStaffAssignmentDivision1(){
    if(staffAssignmentDivision1==null){

      staffAssignmentDivision1 = new ACRadioButtonItem();

      staffAssignmentDivision1.setText("I型");

      staffAssignmentDivision1.setGroup(getStaffAssignmentDivision());

      addStaffAssignmentDivision1();
    }
    return staffAssignmentDivision1;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getStaffAssignmentDivision2(){
    if(staffAssignmentDivision2==null){

      staffAssignmentDivision2 = new ACRadioButtonItem();

      staffAssignmentDivision2.setText("II型");

      staffAssignmentDivision2.setGroup(getStaffAssignmentDivision());

      addStaffAssignmentDivision2();
    }
    return staffAssignmentDivision2;

  }

  /**
   * III型を取得します。
   * @return III型
   */
  public ACRadioButtonItem getStaffAssignmentDivision3(){
    if(staffAssignmentDivision3==null){

      staffAssignmentDivision3 = new ACRadioButtonItem();

      staffAssignmentDivision3.setText("III型");

      staffAssignmentDivision3.setGroup(getStaffAssignmentDivision());

      addStaffAssignmentDivision3();
    }
    return staffAssignmentDivision3;

  }

  /**
   * 夜間勤務条件基準ラジオグループを取得します。
   * @return 夜間勤務条件基準ラジオグループ
   */
  public ACClearableRadioButtonGroup getNightShiftCondition(){
    if(nightShiftCondition==null){

      nightShiftCondition = new ACClearableRadioButtonGroup();

      getNightShiftConditionContainer().setText("夜間勤務条件基準");

      nightShiftCondition.setBindPath("1530103");

      nightShiftCondition.setModel(getNightShiftConditionModel());

      nightShiftCondition.setUseClearButton(false);

      addNightShiftCondition();
    }
    return nightShiftCondition;

  }

  /**
   * 夜間勤務条件基準ラジオグループコンテナを取得します。
   * @return 夜間勤務条件基準ラジオグループコンテナ
   */
  protected ACLabelContainer getNightShiftConditionContainer(){
    if(nightShiftConditionContainer==null){
      nightShiftConditionContainer = new ACLabelContainer();
      nightShiftConditionContainer.setFollowChildEnabled(true);
      nightShiftConditionContainer.add(getNightShiftCondition(), null);
    }
    return nightShiftConditionContainer;
  }

  /**
   * 夜間勤務条件基準ラジオグループモデルを取得します。
   * @return 夜間勤務条件基準ラジオグループモデル
   */
  protected ACListModelAdapter getNightShiftConditionModel(){
    if(nightShiftConditionModel==null){
      nightShiftConditionModel = new ACListModelAdapter();
      addNightShiftConditionModel();
    }
    return nightShiftConditionModel;
  }

  /**
   * 基準型を取得します。
   * @return 基準型
   */
  public ACRadioButtonItem getNightShiftConditionStandard(){
    if(nightShiftConditionStandard==null){

      nightShiftConditionStandard = new ACRadioButtonItem();

      nightShiftConditionStandard.setText("基準型");

      nightShiftConditionStandard.setGroup(getNightShiftCondition());

      addNightShiftConditionStandard();
    }
    return nightShiftConditionStandard;

  }

  /**
   * 加算型Iを取得します。
   * @return 加算型I
   */
  public ACRadioButtonItem getNightShiftConditionAddition1(){
    if(nightShiftConditionAddition1==null){

      nightShiftConditionAddition1 = new ACRadioButtonItem();

      nightShiftConditionAddition1.setText("加算型I");

      nightShiftConditionAddition1.setGroup(getNightShiftCondition());

      addNightShiftConditionAddition1();
    }
    return nightShiftConditionAddition1;

  }

  /**
   * 加算型IIを取得します。
   * @return 加算型II
   */
  public ACRadioButtonItem getNightShiftConditionAddition2(){
    if(nightShiftConditionAddition2==null){

      nightShiftConditionAddition2 = new ACRadioButtonItem();

      nightShiftConditionAddition2.setText("加算型II");

      nightShiftConditionAddition2.setGroup(getNightShiftCondition());

      addNightShiftConditionAddition2();
    }
    return nightShiftConditionAddition2;

  }

  /**
   * 加算型IIIを取得します。
   * @return 加算型III
   */
  public ACRadioButtonItem getNightShiftConditionAddition3(){
    if(nightShiftConditionAddition3==null){

      nightShiftConditionAddition3 = new ACRadioButtonItem();

      nightShiftConditionAddition3.setText("加算型III");

      nightShiftConditionAddition3.setGroup(getNightShiftCondition());

      addNightShiftConditionAddition3();
    }
    return nightShiftConditionAddition3;

  }

  /**
   * 減算型を取得します。
   * @return 減算型
   */
  public ACRadioButtonItem getNightShiftConditionSubtraction(){
    if(nightShiftConditionSubtraction==null){

      nightShiftConditionSubtraction = new ACRadioButtonItem();

      nightShiftConditionSubtraction.setText("減算型");

      nightShiftConditionSubtraction.setGroup(getNightShiftCondition());

      addNightShiftConditionSubtraction();
    }
    return nightShiftConditionSubtraction;

  }

  /**
   * 療養環境基準ラジオグループを取得します。
   * @return 療養環境基準ラジオグループ
   */
  public ACClearableRadioButtonGroup getRecuperationEnvironmental(){
    if(recuperationEnvironmental==null){

      recuperationEnvironmental = new ACClearableRadioButtonGroup();

      getRecuperationEnvironmentalContainer().setText("療養環境基準");

      recuperationEnvironmental.setBindPath("1530104");

      recuperationEnvironmental.setModel(getRecuperationEnvironmentalModel());

      recuperationEnvironmental.setUseClearButton(false);

      addRecuperationEnvironmental();
    }
    return recuperationEnvironmental;

  }

  /**
   * 療養環境基準ラジオグループコンテナを取得します。
   * @return 療養環境基準ラジオグループコンテナ
   */
  protected ACLabelContainer getRecuperationEnvironmentalContainer(){
    if(recuperationEnvironmentalContainer==null){
      recuperationEnvironmentalContainer = new ACLabelContainer();
      recuperationEnvironmentalContainer.setFollowChildEnabled(true);
      recuperationEnvironmentalContainer.add(getRecuperationEnvironmental(), null);
    }
    return recuperationEnvironmentalContainer;
  }

  /**
   * 療養環境基準ラジオグループモデルを取得します。
   * @return 療養環境基準ラジオグループモデル
   */
  protected ACListModelAdapter getRecuperationEnvironmentalModel(){
    if(recuperationEnvironmentalModel==null){
      recuperationEnvironmentalModel = new ACListModelAdapter();
      addRecuperationEnvironmentalModel();
    }
    return recuperationEnvironmentalModel;
  }

  /**
   * 基準型を取得します。
   * @return 基準型
   */
  public ACRadioButtonItem getRecuperationEnvironmentalStandard(){
    if(recuperationEnvironmentalStandard==null){

      recuperationEnvironmentalStandard = new ACRadioButtonItem();

      recuperationEnvironmentalStandard.setText("基準型");

      recuperationEnvironmentalStandard.setGroup(getRecuperationEnvironmental());

      addRecuperationEnvironmentalStandard();
    }
    return recuperationEnvironmentalStandard;

  }

  /**
   * 減算型Iを取得します。
   * @return 減算型I
   */
  public ACRadioButtonItem getRecuperationEnvironmentalSubtraction1(){
    if(recuperationEnvironmentalSubtraction1==null){

      recuperationEnvironmentalSubtraction1 = new ACRadioButtonItem();

      recuperationEnvironmentalSubtraction1.setText("減算型I");

      recuperationEnvironmentalSubtraction1.setGroup(getRecuperationEnvironmental());

      addRecuperationEnvironmentalSubtraction1();
    }
    return recuperationEnvironmentalSubtraction1;

  }

  /**
   * 減算型IIを取得します。
   * @return 減算型II
   */
  public ACRadioButtonItem getRecuperationEnvironmentalSubtraction2(){
    if(recuperationEnvironmentalSubtraction2==null){

      recuperationEnvironmentalSubtraction2 = new ACRadioButtonItem();

      recuperationEnvironmentalSubtraction2.setText("減算型II");

      recuperationEnvironmentalSubtraction2.setGroup(getRecuperationEnvironmental());

      addRecuperationEnvironmentalSubtraction2();
    }
    return recuperationEnvironmentalSubtraction2;

  }

  /**
   * 減算型IIIを取得します。
   * @return 減算型III
   */
  public ACRadioButtonItem getRecuperationEnvironmentalSubtraction3(){
    if(recuperationEnvironmentalSubtraction3==null){

      recuperationEnvironmentalSubtraction3 = new ACRadioButtonItem();

      recuperationEnvironmentalSubtraction3.setText("減算型III");

      recuperationEnvironmentalSubtraction3.setGroup(getRecuperationEnvironmental());

      addRecuperationEnvironmentalSubtraction3();
    }
    return recuperationEnvironmentalSubtraction3;

  }

  /**
   * 医師の配置基準ラジオグループを取得します。
   * @return 医師の配置基準ラジオグループ
   */
  public ACClearableRadioButtonGroup getDoctorsArrangement(){
    if(doctorsArrangement==null){

      doctorsArrangement = new ACClearableRadioButtonGroup();

      getDoctorsArrangementContainer().setText("医師の配置基準");

      doctorsArrangement.setBindPath("1530105");

      doctorsArrangement.setModel(getDoctorsArrangementModel());

      doctorsArrangement.setUseClearButton(false);

      addDoctorsArrangement();
    }
    return doctorsArrangement;

  }

  /**
   * 医師の配置基準ラジオグループコンテナを取得します。
   * @return 医師の配置基準ラジオグループコンテナ
   */
  protected ACLabelContainer getDoctorsArrangementContainer(){
    if(doctorsArrangementContainer==null){
      doctorsArrangementContainer = new ACLabelContainer();
      doctorsArrangementContainer.setFollowChildEnabled(true);
      doctorsArrangementContainer.add(getDoctorsArrangement(), null);
    }
    return doctorsArrangementContainer;
  }

  /**
   * 医師の配置基準ラジオグループモデルを取得します。
   * @return 医師の配置基準ラジオグループモデル
   */
  protected ACListModelAdapter getDoctorsArrangementModel(){
    if(doctorsArrangementModel==null){
      doctorsArrangementModel = new ACListModelAdapter();
      addDoctorsArrangementModel();
    }
    return doctorsArrangementModel;
  }

  /**
   * 基準を取得します。
   * @return 基準
   */
  public ACRadioButtonItem getDoctorsArrangementStandard(){
    if(doctorsArrangementStandard==null){

      doctorsArrangementStandard = new ACRadioButtonItem();

      doctorsArrangementStandard.setText("基準");

      doctorsArrangementStandard.setGroup(getDoctorsArrangement());

      addDoctorsArrangementStandard();
    }
    return doctorsArrangementStandard;

  }

  /**
   * 医療法施行規則第49条適用を取得します。
   * @return 医療法施行規則第49条適用
   */
  public ACRadioButtonItem getDoctorsArrangementArticle49(){
    if(doctorsArrangementArticle49==null){

      doctorsArrangementArticle49 = new ACRadioButtonItem();

      doctorsArrangementArticle49.setText("49条適用");

      doctorsArrangementArticle49.setGroup(getDoctorsArrangement());

      addDoctorsArrangementArticle49();
    }
    return doctorsArrangementArticle49;

  }

  /**
   * 栄養管理体制ラジオグループを取得します。
   * @return 栄養管理体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getNutritionManageRadio(){
    if(nutritionManageRadio==null){

      nutritionManageRadio = new ACClearableRadioButtonGroup();

      getNutritionManageRadioContainer().setText("栄養管理体制");

      nutritionManageRadio.setBindPath("1530106");

      nutritionManageRadio.setModel(getNutritionManageRadioModel());

      nutritionManageRadio.setUseClearButton(false);

      addNutritionManageRadio();
    }
    return nutritionManageRadio;

  }

  /**
   * 栄養管理体制ラジオグループコンテナを取得します。
   * @return 栄養管理体制ラジオグループコンテナ
   */
  protected ACLabelContainer getNutritionManageRadioContainer(){
    if(nutritionManageRadioContainer==null){
      nutritionManageRadioContainer = new ACLabelContainer();
      nutritionManageRadioContainer.setFollowChildEnabled(true);
      nutritionManageRadioContainer.add(getNutritionManageRadio(), null);
    }
    return nutritionManageRadioContainer;
  }

  /**
   * 栄養管理体制ラジオグループモデルを取得します。
   * @return 栄養管理体制ラジオグループモデル
   */
  protected ACListModelAdapter getNutritionManageRadioModel(){
    if(nutritionManageRadioModel==null){
      nutritionManageRadioModel = new ACListModelAdapter();
      addNutritionManageRadioModel();
    }
    return nutritionManageRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNutritionManageRadioItem1(){
    if(nutritionManageRadioItem1==null){

      nutritionManageRadioItem1 = new ACRadioButtonItem();

      nutritionManageRadioItem1.setText("なし");

      nutritionManageRadioItem1.setGroup(getNutritionManageRadio());

      addNutritionManageRadioItem1();
    }
    return nutritionManageRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getNutritionManageRadioItem2(){
    if(nutritionManageRadioItem2==null){

      nutritionManageRadioItem2 = new ACRadioButtonItem();

      nutritionManageRadioItem2.setText("あり");

      nutritionManageRadioItem2.setGroup(getNutritionManageRadio());

      addNutritionManageRadioItem2();
    }
    return nutritionManageRadioItem2;

  }

  /**
   * 栄養マネジメント体制ラジオグループを取得します。
   * @return 栄養マネジメント体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getNutritionRadio(){
    if(nutritionRadio==null){

      nutritionRadio = new ACClearableRadioButtonGroup();

      getNutritionRadioContainer().setText("栄養マネジメント体制");

      nutritionRadio.setBindPath("1530107");

      nutritionRadio.setModel(getNutritionRadioModel());

      nutritionRadio.setUseClearButton(false);

      addNutritionRadio();
    }
    return nutritionRadio;

  }

  /**
   * 栄養マネジメント体制ラジオグループコンテナを取得します。
   * @return 栄養マネジメント体制ラジオグループコンテナ
   */
  protected ACLabelContainer getNutritionRadioContainer(){
    if(nutritionRadioContainer==null){
      nutritionRadioContainer = new ACLabelContainer();
      nutritionRadioContainer.setFollowChildEnabled(true);
      nutritionRadioContainer.add(getNutritionRadio(), null);
    }
    return nutritionRadioContainer;
  }

  /**
   * 栄養マネジメント体制ラジオグループモデルを取得します。
   * @return 栄養マネジメント体制ラジオグループモデル
   */
  protected ACListModelAdapter getNutritionRadioModel(){
    if(nutritionRadioModel==null){
      nutritionRadioModel = new ACListModelAdapter();
      addNutritionRadioModel();
    }
    return nutritionRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNutritionRadioItem1(){
    if(nutritionRadioItem1==null){

      nutritionRadioItem1 = new ACRadioButtonItem();

      nutritionRadioItem1.setText("なし");

      nutritionRadioItem1.setGroup(getNutritionRadio());

      addNutritionRadioItem1();
    }
    return nutritionRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getNutritionRadioItem2 (){
    if(nutritionRadioItem2 ==null){

      nutritionRadioItem2  = new ACRadioButtonItem();

      nutritionRadioItem2 .setText("あり");

      nutritionRadioItem2 .setGroup(getNutritionRadio());

      addNutritionRadioItem2 ();
    }
    return nutritionRadioItem2 ;

  }

  /**
   * 経口移行体制ラジオグループを取得します。
   * @return 経口移行体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getOralSwitchRadio(){
    if(oralSwitchRadio==null){

      oralSwitchRadio = new ACClearableRadioButtonGroup();

      getOralSwitchRadioContainer().setText("経口移行体制");

      oralSwitchRadio.setBindPath("1530108");

      oralSwitchRadio.setModel(getOralSwitchRadioModel());

      oralSwitchRadio.setUseClearButton(false);

      addOralSwitchRadio();
    }
    return oralSwitchRadio;

  }

  /**
   * 経口移行体制ラジオグループコンテナを取得します。
   * @return 経口移行体制ラジオグループコンテナ
   */
  protected ACLabelContainer getOralSwitchRadioContainer(){
    if(oralSwitchRadioContainer==null){
      oralSwitchRadioContainer = new ACLabelContainer();
      oralSwitchRadioContainer.setFollowChildEnabled(true);
      oralSwitchRadioContainer.add(getOralSwitchRadio(), null);
    }
    return oralSwitchRadioContainer;
  }

  /**
   * 経口移行体制ラジオグループモデルを取得します。
   * @return 経口移行体制ラジオグループモデル
   */
  protected ACListModelAdapter getOralSwitchRadioModel(){
    if(oralSwitchRadioModel==null){
      oralSwitchRadioModel = new ACListModelAdapter();
      addOralSwitchRadioModel();
    }
    return oralSwitchRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getOralSwitchRadioItem1(){
    if(oralSwitchRadioItem1==null){

      oralSwitchRadioItem1 = new ACRadioButtonItem();

      oralSwitchRadioItem1.setText("なし");

      oralSwitchRadioItem1.setGroup(getOralSwitchRadio());

      addOralSwitchRadioItem1();
    }
    return oralSwitchRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getOralSwitchRadioItem2 (){
    if(oralSwitchRadioItem2 ==null){

      oralSwitchRadioItem2  = new ACRadioButtonItem();

      oralSwitchRadioItem2 .setText("あり");

      oralSwitchRadioItem2 .setGroup(getOralSwitchRadio());

      addOralSwitchRadioItem2 ();
    }
    return oralSwitchRadioItem2 ;

  }

  /**
   * 療養食体制ラジオグループを取得します。
   * @return 療養食体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getRecuperateDinnerRadio(){
    if(recuperateDinnerRadio==null){

      recuperateDinnerRadio = new ACClearableRadioButtonGroup();

      getRecuperateDinnerRadioContainer().setText("療養食体制");

      recuperateDinnerRadio.setBindPath("1530109");

      recuperateDinnerRadio.setModel(getRecuperateDinnerRadioModel());

      recuperateDinnerRadio.setUseClearButton(false);

      addRecuperateDinnerRadio();
    }
    return recuperateDinnerRadio;

  }

  /**
   * 療養食体制ラジオグループコンテナを取得します。
   * @return 療養食体制ラジオグループコンテナ
   */
  protected ACLabelContainer getRecuperateDinnerRadioContainer(){
    if(recuperateDinnerRadioContainer==null){
      recuperateDinnerRadioContainer = new ACLabelContainer();
      recuperateDinnerRadioContainer.setFollowChildEnabled(true);
      recuperateDinnerRadioContainer.add(getRecuperateDinnerRadio(), null);
    }
    return recuperateDinnerRadioContainer;
  }

  /**
   * 療養食体制ラジオグループモデルを取得します。
   * @return 療養食体制ラジオグループモデル
   */
  protected ACListModelAdapter getRecuperateDinnerRadioModel(){
    if(recuperateDinnerRadioModel==null){
      recuperateDinnerRadioModel = new ACListModelAdapter();
      addRecuperateDinnerRadioModel();
    }
    return recuperateDinnerRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getRecuperateDinnerRadioItem1(){
    if(recuperateDinnerRadioItem1==null){

      recuperateDinnerRadioItem1 = new ACRadioButtonItem();

      recuperateDinnerRadioItem1.setText("なし");

      recuperateDinnerRadioItem1.setGroup(getRecuperateDinnerRadio());

      addRecuperateDinnerRadioItem1();
    }
    return recuperateDinnerRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getRecuperateDinnerRadioItem2(){
    if(recuperateDinnerRadioItem2==null){

      recuperateDinnerRadioItem2 = new ACRadioButtonItem();

      recuperateDinnerRadioItem2.setText("あり");

      recuperateDinnerRadioItem2.setGroup(getRecuperateDinnerRadio());

      addRecuperateDinnerRadioItem2();
    }
    return recuperateDinnerRadioItem2;

  }

  /**
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACComboBox getStaffReduce(){
    if(staffReduce==null){

      staffReduce = new ACComboBox();

      getStaffReduceContainer().setText("人員減算");

      staffReduce.setBindPath("1530110");

      staffReduce.setEditable(false);

      staffReduce.setModel(getStaffReduceModel());

      staffReduce.setRenderBindPath("CONTENT");

      addStaffReduce();
    }
    return staffReduce;

  }

  /**
   * 人員減算コンテナを取得します。
   * @return 人員減算コンテナ
   */
  protected ACLabelContainer getStaffReduceContainer(){
    if(staffReduceContainer==null){
      staffReduceContainer = new ACLabelContainer();
      staffReduceContainer.setFollowChildEnabled(true);
      staffReduceContainer.add(getStaffReduce(), null);
    }
    return staffReduceContainer;
  }

  /**
   * 人員減算モデルを取得します。
   * @return 人員減算モデル
   */
  protected ACComboBoxModelAdapter getStaffReduceModel(){
    if(staffReduceModel==null){
      staffReduceModel = new ACComboBoxModelAdapter();
      addStaffReduceModel();
    }
    return staffReduceModel;
  }

  /**
   * 食費基準額・コンテナを取得します。
   * @return 食費基準額・コンテナ
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner(){
    if(kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner==null){

      kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner.setText("食費基準額");

      kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner();
    }
    return kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner;

  }

  /**
   * 食費基準額・合計・テキストを取得します。
   * @return 食費基準額・合計・テキスト
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesDinnerBasicMoneyTotal(){
    if(kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyTotal==null){

      kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyTotal = new ACTextField();

      kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyTotal.setBindPath("1530111");

      kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyTotal.setEditable(false);

      kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyTotal.setColumns(4);

      kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyTotal.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyTotal.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyTotal.setMaxLength(4);

      addKaigoRecuperationMedicalFacilitiesDinnerBasicMoneyTotal();
    }
    return kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyTotal;

  }

  /**
   * 食費基準額・朝・ラベルを取得します。
   * @return 食費基準額・朝・ラベル
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoneyLabel(){
    if(kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoneyLabel==null){

      kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoneyLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoneyLabel.setText("　朝");

      addKaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoneyLabel();
    }
    return kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoneyLabel;

  }

  /**
   * 食費基準額・朝・テキストを取得します。
   * @return 食費基準額・朝・テキスト
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney(){
    if(kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney==null){

      kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney = new ACTextField();

      kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney.setBindPath("1530112");

      kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney.setColumns(3);

      kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney.setMaxLength(3);

      addKaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney();
    }
    return kaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney;

  }

  /**
   * 食費基準額・昼・ラベルを取得します。
   * @return 食費基準額・昼・ラベル
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoneyLabel(){
    if(kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoneyLabel==null){

      kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoneyLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoneyLabel.setText("昼");

      addKaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoneyLabel();
    }
    return kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoneyLabel;

  }

  /**
   * 食費基準額・昼・テキストを取得します。
   * @return 食費基準額・昼・テキスト
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney(){
    if(kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney==null){

      kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney = new ACTextField();

      kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney.setBindPath("1530113");

      kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney.setColumns(3);

      kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney.setMaxLength(3);

      addKaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney();
    }
    return kaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney;

  }

  /**
   * 食費基準額・夜・ラベルを取得します。
   * @return 食費基準額・夜・ラベル
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesNightDinnerBasicMoneyLabel(){
    if(kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoneyLabel==null){

      kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoneyLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoneyLabel.setText("夜");

      addKaigoRecuperationMedicalFacilitiesNightDinnerBasicMoneyLabel();
    }
    return kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoneyLabel;

  }

  /**
   * 食費基準額・夜・テキストを取得します。
   * @return 食費基準額・夜・テキスト
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney(){
    if(kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney==null){

      kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney = new ACTextField();

      kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney.setBindPath("1530114");

      kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney.setColumns(3);

      kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney.setMaxLength(3);

      addKaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney();
    }
    return kaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney;

  }

  /**
   * 食費基準額・ラベルを取得します。
   * @return 食費基準額・ラベル
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesDinnerBasicMoney4Label(){
    if(kaigoRecuperationMedicalFacilitiesDinnerBasicMoney4Label==null){

      kaigoRecuperationMedicalFacilitiesDinnerBasicMoney4Label = new ACLabel();

      kaigoRecuperationMedicalFacilitiesDinnerBasicMoney4Label.setText("（円）");

      addKaigoRecuperationMedicalFacilitiesDinnerBasicMoney4Label();
    }
    return kaigoRecuperationMedicalFacilitiesDinnerBasicMoney4Label;

  }

  /**
   * ユニット型個室基準額・コンテナを取得します。
   * @return ユニット型個室基準額・コンテナ
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyConteiner(){
    if(kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyConteiner==null){

      kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyConteiner = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyConteiner.setText("ユニット型個室基準額");

      kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyConteiner.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyConteiner();
    }
    return kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyConteiner;

  }

  /**
   * ユニット型個室基準額・テキストを取得します。
   * @return ユニット型個室基準額・テキスト
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyText(){
    if(kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyText==null){

      kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyText = new ACTextField();

      kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyText.setBindPath("1530115");

      kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyText.setColumns(4);

      kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyText.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyText.setMaxLength(4);

      addKaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyText();
    }
    return kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyText;

  }

  /**
   * ユニット型個室基準額・ラベルを取得します。
   * @return ユニット型個室基準額・ラベル
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyLabel(){
    if(kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyLabel==null){

      kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyLabel.setText("（円）");

      addKaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyLabel();
    }
    return kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyLabel;

  }

  /**
   * ユニット型準個室基準額・コンテナを取得します。
   * @return ユニット型準個室基準額・コンテナ
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyConteiner(){
    if(kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyConteiner==null){

      kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyConteiner = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyConteiner.setText("ユニット型準個室基準額");

      kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyConteiner.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyConteiner();
    }
    return kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyConteiner;

  }

  /**
   * ユニット型準個室基準額・テキストを取得します。
   * @return ユニット型準個室基準額・テキスト
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyText(){
    if(kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyText==null){

      kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyText = new ACTextField();

      kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyText.setBindPath("1530116");

      kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyText.setColumns(4);

      kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyText.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyText.setMaxLength(4);

      addKaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyText();
    }
    return kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyText;

  }

  /**
   * ユニット型準個室基準額・ラベルを取得します。
   * @return ユニット型準個室基準額・ラベル
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyLabel(){
    if(kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyLabel==null){

      kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyLabel.setText("（円）");

      addKaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyLabel();
    }
    return kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyLabel;

  }

  /**
   * 従来型個室基準額・コンテナを取得します。
   * @return 従来型個室基準額・コンテナ
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyConteiner(){
    if(kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyConteiner==null){

      kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyConteiner = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyConteiner.setText("　　従来型個室基準額");

      kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyConteiner.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyConteiner();
    }
    return kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyConteiner;

  }

  /**
   * 従来型個室基準額・テキストを取得します。
   * @return 従来型個室基準額・テキスト
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyText(){
    if(kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyText==null){

      kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyText = new ACTextField();

      kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyText.setBindPath("1530117");

      kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyText.setColumns(4);

      kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyText.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyText.setMaxLength(4);

      addKaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyText();
    }
    return kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyText;

  }

  /**
   * 従来型個室基準額・ラベルを取得します。
   * @return 従来型個室基準額・ラベル
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyLabel(){
    if(kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyLabel==null){

      kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyLabel.setText("（円）");

      addKaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyLabel();
    }
    return kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyLabel;

  }

  /**
   * 多床室基準額・コンテナを取得します。
   * @return 多床室基準額・コンテナ
   */
  public ACLabelContainer getKaigoRecuperationMedicalFacilitiesTasyouRoomConteiner(){
    if(kaigoRecuperationMedicalFacilitiesTasyouRoomConteiner==null){

      kaigoRecuperationMedicalFacilitiesTasyouRoomConteiner = new ACLabelContainer();

      kaigoRecuperationMedicalFacilitiesTasyouRoomConteiner.setText("　　多床室基準額");

      kaigoRecuperationMedicalFacilitiesTasyouRoomConteiner.setFollowChildEnabled(true);

      addKaigoRecuperationMedicalFacilitiesTasyouRoomConteiner();
    }
    return kaigoRecuperationMedicalFacilitiesTasyouRoomConteiner;

  }

  /**
   * 多床室基準額・テキストを取得します。
   * @return 多床室基準額・テキスト
   */
  public ACTextField getKaigoRecuperationMedicalFacilitiesTasyouRoomText(){
    if(kaigoRecuperationMedicalFacilitiesTasyouRoomText==null){

      kaigoRecuperationMedicalFacilitiesTasyouRoomText = new ACTextField();

      kaigoRecuperationMedicalFacilitiesTasyouRoomText.setBindPath("1530118");

      kaigoRecuperationMedicalFacilitiesTasyouRoomText.setColumns(4);

      kaigoRecuperationMedicalFacilitiesTasyouRoomText.setCharType(VRCharType.ONLY_DIGIT);

      kaigoRecuperationMedicalFacilitiesTasyouRoomText.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoRecuperationMedicalFacilitiesTasyouRoomText.setIMEMode(InputSubset.LATIN);

      kaigoRecuperationMedicalFacilitiesTasyouRoomText.setMaxLength(4);

      addKaigoRecuperationMedicalFacilitiesTasyouRoomText();
    }
    return kaigoRecuperationMedicalFacilitiesTasyouRoomText;

  }

  /**
   * 多床室基準額・ラベルを取得します。
   * @return 多床室基準額・ラベル
   */
  public ACLabel getKaigoRecuperationMedicalFacilitiesTasyouRoomLabel(){
    if(kaigoRecuperationMedicalFacilitiesTasyouRoomLabel==null){

      kaigoRecuperationMedicalFacilitiesTasyouRoomLabel = new ACLabel();

      kaigoRecuperationMedicalFacilitiesTasyouRoomLabel.setText("（円）");

      addKaigoRecuperationMedicalFacilitiesTasyouRoomLabel();
    }
    return kaigoRecuperationMedicalFacilitiesTasyouRoomLabel;

  }

  /**
   * コンストラクタです。
   */
  public QO004018Design() {

    try {
      initialize();

      initAffair(null);

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

    this.add(getKaigoRecuperationMedicalFacilitiesGroup(), VRLayout.CLIENT);

  }

  /**
   * 事業グループに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesGroup(){

    kaigoRecuperationMedicalFacilitiesGroup.add(getKaigoRecuperationMedicalFacilitiesDiscountContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getStaffAssignmentDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getNightShiftConditionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getRecuperationEnvironmentalContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getDoctorsArrangementContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getNutritionManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getNutritionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getOralSwitchRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getRecuperateDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getStaffReduceContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getKaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getKaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getKaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getKaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoRecuperationMedicalFacilitiesGroup.add(getKaigoRecuperationMedicalFacilitiesTasyouRoomConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 割引率コンテナに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesDiscountContainer(){

    kaigoRecuperationMedicalFacilitiesDiscountContainer.add(getKaigoRecuperationMedicalFacilitiesDiscountRate(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDiscountContainer.add(getPercentSign(), VRLayout.FLOW);

  }

  /**
   * 割引率に内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesDiscountRate(){

  }

  /**
   * ％ラベルに内部項目を追加します。
   */
  protected void addPercentSign(){

  }

  /**
   * 施設区分ラジオグループに内部項目を追加します。
   */
  protected void addInstitutionDivisionRadio(){

  }

  /**
   * 施設区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addInstitutionDivisionRadioModel(){

    getInstitutionDivisionRadioItem1().setButtonIndex(1);
    getInstitutionDivisionRadioModel().add(getInstitutionDivisionRadioItem1());

    getInstitutionDivisionRadioItem2().setButtonIndex(2);
    getInstitutionDivisionRadioModel().add(getInstitutionDivisionRadioItem2());

  }

  /**
   * 病院に内部項目を追加します。
   */
  protected void addInstitutionDivisionRadioItem1(){

  }

  /**
   * ユニット型病院に内部項目を追加します。
   */
  protected void addInstitutionDivisionRadioItem2(){

  }

  /**
   * 人員配置区分ラジオグループに内部項目を追加します。
   */
  protected void addStaffAssignmentDivision(){

  }

  /**
   * 人員配置区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addStaffAssignmentDivisionModel(){

    getStaffAssignmentDivision1().setButtonIndex(1);
    getStaffAssignmentDivisionModel().add(getStaffAssignmentDivision1());

    getStaffAssignmentDivision2().setButtonIndex(2);
    getStaffAssignmentDivisionModel().add(getStaffAssignmentDivision2());

    getStaffAssignmentDivision3().setButtonIndex(3);
    getStaffAssignmentDivisionModel().add(getStaffAssignmentDivision3());

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addStaffAssignmentDivision1(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addStaffAssignmentDivision2(){

  }

  /**
   * III型に内部項目を追加します。
   */
  protected void addStaffAssignmentDivision3(){

  }

  /**
   * 夜間勤務条件基準ラジオグループに内部項目を追加します。
   */
  protected void addNightShiftCondition(){

  }

  /**
   * 夜間勤務条件基準ラジオグループモデルに内部項目を追加します。
   */
  protected void addNightShiftConditionModel(){

    getNightShiftConditionStandard().setButtonIndex(1);
    getNightShiftConditionModel().add(getNightShiftConditionStandard());

    getNightShiftConditionAddition1().setButtonIndex(2);
    getNightShiftConditionModel().add(getNightShiftConditionAddition1());

    getNightShiftConditionAddition2().setButtonIndex(3);
    getNightShiftConditionModel().add(getNightShiftConditionAddition2());

    getNightShiftConditionAddition3().setButtonIndex(4);
    getNightShiftConditionModel().add(getNightShiftConditionAddition3());

    getNightShiftConditionSubtraction().setButtonIndex(5);
    getNightShiftConditionModel().add(getNightShiftConditionSubtraction());

  }

  /**
   * 基準型に内部項目を追加します。
   */
  protected void addNightShiftConditionStandard(){

  }

  /**
   * 加算型Iに内部項目を追加します。
   */
  protected void addNightShiftConditionAddition1(){

  }

  /**
   * 加算型IIに内部項目を追加します。
   */
  protected void addNightShiftConditionAddition2(){

  }

  /**
   * 加算型IIIに内部項目を追加します。
   */
  protected void addNightShiftConditionAddition3(){

  }

  /**
   * 減算型に内部項目を追加します。
   */
  protected void addNightShiftConditionSubtraction(){

  }

  /**
   * 療養環境基準ラジオグループに内部項目を追加します。
   */
  protected void addRecuperationEnvironmental(){

  }

  /**
   * 療養環境基準ラジオグループモデルに内部項目を追加します。
   */
  protected void addRecuperationEnvironmentalModel(){

    getRecuperationEnvironmentalStandard().setButtonIndex(1);
    getRecuperationEnvironmentalModel().add(getRecuperationEnvironmentalStandard());

    getRecuperationEnvironmentalSubtraction1().setButtonIndex(2);
    getRecuperationEnvironmentalModel().add(getRecuperationEnvironmentalSubtraction1());

    getRecuperationEnvironmentalSubtraction2().setButtonIndex(3);
    getRecuperationEnvironmentalModel().add(getRecuperationEnvironmentalSubtraction2());

    getRecuperationEnvironmentalSubtraction3().setButtonIndex(4);
    getRecuperationEnvironmentalModel().add(getRecuperationEnvironmentalSubtraction3());

  }

  /**
   * 基準型に内部項目を追加します。
   */
  protected void addRecuperationEnvironmentalStandard(){

  }

  /**
   * 減算型Iに内部項目を追加します。
   */
  protected void addRecuperationEnvironmentalSubtraction1(){

  }

  /**
   * 減算型IIに内部項目を追加します。
   */
  protected void addRecuperationEnvironmentalSubtraction2(){

  }

  /**
   * 減算型IIIに内部項目を追加します。
   */
  protected void addRecuperationEnvironmentalSubtraction3(){

  }

  /**
   * 医師の配置基準ラジオグループに内部項目を追加します。
   */
  protected void addDoctorsArrangement(){

  }

  /**
   * 医師の配置基準ラジオグループモデルに内部項目を追加します。
   */
  protected void addDoctorsArrangementModel(){

    getDoctorsArrangementStandard().setButtonIndex(1);
    getDoctorsArrangementModel().add(getDoctorsArrangementStandard());

    getDoctorsArrangementArticle49().setButtonIndex(2);
    getDoctorsArrangementModel().add(getDoctorsArrangementArticle49());

  }

  /**
   * 基準に内部項目を追加します。
   */
  protected void addDoctorsArrangementStandard(){

  }

  /**
   * 医療法施行規則第49条適用に内部項目を追加します。
   */
  protected void addDoctorsArrangementArticle49(){

  }

  /**
   * 栄養管理体制ラジオグループに内部項目を追加します。
   */
  protected void addNutritionManageRadio(){

  }

  /**
   * 栄養管理体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addNutritionManageRadioModel(){

    getNutritionManageRadioItem1().setButtonIndex(1);
    getNutritionManageRadioModel().add(getNutritionManageRadioItem1());

    getNutritionManageRadioItem2().setButtonIndex(2);
    getNutritionManageRadioModel().add(getNutritionManageRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNutritionManageRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addNutritionManageRadioItem2(){

  }

  /**
   * 栄養マネジメント体制ラジオグループに内部項目を追加します。
   */
  protected void addNutritionRadio(){

  }

  /**
   * 栄養マネジメント体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addNutritionRadioModel(){

    getNutritionRadioItem1().setButtonIndex(1);
    getNutritionRadioModel().add(getNutritionRadioItem1());

    getNutritionRadioItem2 ().setButtonIndex(2);
    getNutritionRadioModel().add(getNutritionRadioItem2 ());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNutritionRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addNutritionRadioItem2 (){

  }

  /**
   * 経口移行体制ラジオグループに内部項目を追加します。
   */
  protected void addOralSwitchRadio(){

  }

  /**
   * 経口移行体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addOralSwitchRadioModel(){

    getOralSwitchRadioItem1().setButtonIndex(1);
    getOralSwitchRadioModel().add(getOralSwitchRadioItem1());

    getOralSwitchRadioItem2 ().setButtonIndex(2);
    getOralSwitchRadioModel().add(getOralSwitchRadioItem2 ());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addOralSwitchRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addOralSwitchRadioItem2 (){

  }

  /**
   * 療養食体制ラジオグループに内部項目を追加します。
   */
  protected void addRecuperateDinnerRadio(){

  }

  /**
   * 療養食体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addRecuperateDinnerRadioModel(){

    getRecuperateDinnerRadioItem1().setButtonIndex(1);
    getRecuperateDinnerRadioModel().add(getRecuperateDinnerRadioItem1());

    getRecuperateDinnerRadioItem2().setButtonIndex(2);
    getRecuperateDinnerRadioModel().add(getRecuperateDinnerRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addRecuperateDinnerRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addRecuperateDinnerRadioItem2(){

  }

  /**
   * 人員減算に内部項目を追加します。
   */
  protected void addStaffReduce(){

  }

  /**
   * 人員減算モデルに内部項目を追加します。
   */
  protected void addStaffReduceModel(){

  }

  /**
   * 食費基準額・コンテナに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner(){

    kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesDinnerBasicMoneyTotal(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoneyLabel(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoneyLabel(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesNightDinnerBasicMoneyLabel(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney(), VRLayout.FLOW);

    kaigoRecuperationMedicalFacilitiesDinnerBasicMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesDinnerBasicMoney4Label(), VRLayout.FLOW);

  }

  /**
   * 食費基準額・合計・テキストに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesDinnerBasicMoneyTotal(){

  }

  /**
   * 食費基準額・朝・ラベルに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoneyLabel(){

  }

  /**
   * 食費基準額・朝・テキストに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesMorningDinnerBasicMoney(){

  }

  /**
   * 食費基準額・昼・ラベルに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoneyLabel(){

  }

  /**
   * 食費基準額・昼・テキストに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesNoonDinnerBasicMoney(){

  }

  /**
   * 食費基準額・夜・ラベルに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesNightDinnerBasicMoneyLabel(){

  }

  /**
   * 食費基準額・夜・テキストに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesNightDinnerBasicMoney(){

  }

  /**
   * 食費基準額・ラベルに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesDinnerBasicMoney4Label(){

  }

  /**
   * ユニット型個室基準額・コンテナに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyConteiner(){

    kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyText(), null);

    kaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyLabel(), null);

  }

  /**
   * ユニット型個室基準額・テキストに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyText(){

  }

  /**
   * ユニット型個室基準額・ラベルに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesUnitRoomBasicMoneyLabel(){

  }

  /**
   * ユニット型準個室基準額・コンテナに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyConteiner(){

    kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyText(), null);

    kaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyLabel(), null);

  }

  /**
   * ユニット型準個室基準額・テキストに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyText(){

  }

  /**
   * ユニット型準個室基準額・ラベルに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesUnitSemiRoomBasicMoneyLabel(){

  }

  /**
   * 従来型個室基準額・コンテナに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyConteiner(){

    kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyText(), null);

    kaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyConteiner.add(getKaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyLabel(), null);

  }

  /**
   * 従来型個室基準額・テキストに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyText(){

  }

  /**
   * 従来型個室基準額・ラベルに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesNormalRoomBasicMoneyLabel(){

  }

  /**
   * 多床室基準額・コンテナに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesTasyouRoomConteiner(){

    kaigoRecuperationMedicalFacilitiesTasyouRoomConteiner.add(getKaigoRecuperationMedicalFacilitiesTasyouRoomText(), null);

    kaigoRecuperationMedicalFacilitiesTasyouRoomConteiner.add(getKaigoRecuperationMedicalFacilitiesTasyouRoomLabel(), null);

  }

  /**
   * 多床室基準額・テキストに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesTasyouRoomText(){

  }

  /**
   * 多床室基準額・ラベルに内部項目を追加します。
   */
  protected void addKaigoRecuperationMedicalFacilitiesTasyouRoomLabel(){

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
      ACFrame.setVRLookAndFeel();
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.getInstance().getContentPane().add(new QO004018Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004018Design getThis() {
    return this;
  }
}
