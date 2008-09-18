
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
 * プログラム 短期入所療養介護病院療養型 (QO004010)
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
 * 短期入所療養介護病院療養型画面項目デザイン(QO004010) 
 */
public class QO004010Design extends ACPanel {
  //GUIコンポーネント

  private ACGroupBox shortStayHospitalRecuperationGroup;

  private ACLabelContainer shortStayHospitalRecuperationDiscountContainer;

  private ACTextField shortStayHospitalRecuperationDiscountRate;

  private ACLabel percentSign;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationInstitutionDivisionRadio;

  private ACLabelContainer shortStayHospitalRecuperationInstitutionDivisionRadioContainer;

  private ACListModelAdapter shortStayHospitalRecuperationInstitutionDivisionRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationInstitutionDivisionRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationInstitutionDivisionRadioItem2;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationStaffAssignmentDivision;

  private ACLabelContainer shortStayHospitalRecuperationStaffAssignmentDivisionContainer;

  private ACListModelAdapter shortStayHospitalRecuperationStaffAssignmentDivisionModel;

  private ACRadioButtonItem shortStayHospitalRecuperationStaffAssignmentDivision1;

  private ACRadioButtonItem shortStayHospitalRecuperationStaffAssignmentDivision2;

  private ACRadioButtonItem shortStayHospitalRecuperationStaffAssignmentDivision3;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationNightShiftCondition;

  private ACLabelContainer shortStayHospitalRecuperationNightShiftConditionContainer;

  private ACListModelAdapter shortStayHospitalRecuperationNightShiftConditionModel;

  private VRLayout shortStayHospitalRecuperationNightShiftConditionLayout;

  private ACRadioButtonItem shortStayHospitalRecuperationNightShiftConditionStandard;

  private ACRadioButtonItem shortStayHospitalRecuperationNightShiftConditionAddition1;

  private ACRadioButtonItem shortStayHospitalRecuperationNightShiftConditionAddition2;

  private ACRadioButtonItem shortStayHospitalRecuperationNightShiftConditionAddition3;

  private ACRadioButtonItem shortStayHospitalRecuperationNightShiftConditionSubtraction;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationRecuperationEnvironmental;

  private ACLabelContainer shortStayHospitalRecuperationRecuperationEnvironmentalContainer;

  private ACListModelAdapter shortStayHospitalRecuperationRecuperationEnvironmentalModel;

  private ACRadioButtonItem shortStayHospitalRecuperationRecuperationEnvironmentalStandard;

  private ACRadioButtonItem shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction1;

  private ACRadioButtonItem shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction2;

  private ACRadioButtonItem shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction3;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationDoctorsArrangement;

  private ACLabelContainer shortStayHospitalRecuperationDoctorsArrangementContainer;

  private ACListModelAdapter shortStayHospitalRecuperationDoctorsArrangementModel;

  private ACRadioButtonItem shortStayHospitalRecuperationDoctorsArrangementStandard;

  private ACRadioButtonItem shortStayHospitalRecuperationDoctorsArrangementArticle49;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationMeetingAndSendingOffSystem;

  private ACLabelContainer shortStayHospitalRecuperationMeetingAndSendingOffSystemContainer;

  private ACListModelAdapter shortStayHospitalRecuperationMeetingAndSendingOffSystemModel;

  private ACRadioButtonItem shortStayHospitalRecuperationMeetingAndSendingOffSystemOff;

  private ACRadioButtonItem shortStayHospitalRecuperationMeetingAndSendingOffSystemOn;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationNutritionManageRadio;

  private ACLabelContainer shortStayHospitalRecuperationNutritionManageRadioContainer;

  private ACListModelAdapter shortStayHospitalRecuperationNutritionManageRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationNutritionManageRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationNutritionManageRadioItem2;

  private ACClearableRadioButtonGroup shortStayHospitalRecuperationRecuperationRadio;

  private ACLabelContainer shortStayHospitalRecuperationRecuperationRadioContainer;

  private ACListModelAdapter shortStayHospitalRecuperationRecuperationRadioModel;

  private ACRadioButtonItem shortStayHospitalRecuperationRecuperationRadioItem1;

  private ACRadioButtonItem shortStayHospitalRecuperationRecuperationRadioItem2;

  private ACComboBox shortStayHospitalRecuperationStaffReduce;

  private ACLabelContainer shortStayHospitalRecuperationStaffReduceContainer;

  private ACComboBoxModelAdapter shortStayHospitalRecuperationStaffReduceModel;

  private ACLabelContainer shortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal;

  private ACLabel shortStayRecuperateCareHospitalMorningDinnerStandeirdMoneyLabel;

  private ACTextField shortStayRecuperateCareHospitalMorningDinnerStandeirdMoney;

  private ACLabel shortStayRecuperateCareHospitalNoonDinnerStandeirdMoneyLabel;

  private ACTextField shortStayRecuperateCareHospitalNoonDinnerStandeirdMoney;

  private ACLabel shortStayRecuperateCareHospitalNightDinnerStandeirdMoneyLabel;

  private ACTextField shortStayRecuperateCareHospitalNightDinnerStandeirdMoney;

  private ACLabel shortStayRecuperateCareHospitalDinnerStandeirdMoneyDenomination;

  private ACLabelContainer shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText;

  private ACLabel shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyLabel;

  private ACLabelContainer shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText;

  private ACLabel shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyLabel;

  private ACLabelContainer shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyConteiner;

  private ACTextField shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText;

  private ACLabel shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyLabel;

  private ACLabelContainer shortStayRecuperateCareHospitalTasyouRoomConteiner;

  private ACTextField shortStayRecuperateCareHospitalTasyouRoomText;

  private ACLabel shortStayRecuperateCareHospitalTasyouRoomLabel;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getShortStayHospitalRecuperationGroup(){
    if(shortStayHospitalRecuperationGroup==null){

      shortStayHospitalRecuperationGroup = new ACGroupBox();

      shortStayHospitalRecuperationGroup.setText("短期入所療養介護（病院療養型）");

      shortStayHospitalRecuperationGroup.setFollowChildEnabled(true);

      shortStayHospitalRecuperationGroup.setHgrid(200);

      addShortStayHospitalRecuperationGroup();
    }
    return shortStayHospitalRecuperationGroup;

  }

  /**
   * 割引率コンテナを取得します。
   * @return 割引率コンテナ
   */
  public ACLabelContainer getShortStayHospitalRecuperationDiscountContainer(){
    if(shortStayHospitalRecuperationDiscountContainer==null){

      shortStayHospitalRecuperationDiscountContainer = new ACLabelContainer();

      shortStayHospitalRecuperationDiscountContainer.setText("割引率");

      shortStayHospitalRecuperationDiscountContainer.setFollowChildEnabled(true);

      addShortStayHospitalRecuperationDiscountContainer();
    }
    return shortStayHospitalRecuperationDiscountContainer;

  }

  /**
   * 割引率を取得します。
   * @return 割引率
   */
  public ACTextField getShortStayHospitalRecuperationDiscountRate(){
    if(shortStayHospitalRecuperationDiscountRate==null){

      shortStayHospitalRecuperationDiscountRate = new ACTextField();

      shortStayHospitalRecuperationDiscountRate.setBindPath("REDUCT_RATE");

      shortStayHospitalRecuperationDiscountRate.setColumns(3);

      shortStayHospitalRecuperationDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      shortStayHospitalRecuperationDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayHospitalRecuperationDiscountRate.setIMEMode(InputSubset.LATIN);

      shortStayHospitalRecuperationDiscountRate.setMaxLength(3);

      addShortStayHospitalRecuperationDiscountRate();
    }
    return shortStayHospitalRecuperationDiscountRate;

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
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationInstitutionDivisionRadio(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadio==null){

      shortStayHospitalRecuperationInstitutionDivisionRadio = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationInstitutionDivisionRadioContainer().setText("施設区分");

      shortStayHospitalRecuperationInstitutionDivisionRadio.setBindPath("1230101");

      shortStayHospitalRecuperationInstitutionDivisionRadio.setModel(getShortStayHospitalRecuperationInstitutionDivisionRadioModel());

      shortStayHospitalRecuperationInstitutionDivisionRadio.setUseClearButton(false);

      addShortStayHospitalRecuperationInstitutionDivisionRadio();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadio;

  }

  /**
   * 施設区分ラジオグループコンテナを取得します。
   * @return 施設区分ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayHospitalRecuperationInstitutionDivisionRadioContainer(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioContainer==null){
      shortStayHospitalRecuperationInstitutionDivisionRadioContainer = new ACLabelContainer();
      shortStayHospitalRecuperationInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationInstitutionDivisionRadioContainer.add(getShortStayHospitalRecuperationInstitutionDivisionRadio(), null);
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioContainer;
  }

  /**
   * 施設区分ラジオグループモデルを取得します。
   * @return 施設区分ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationInstitutionDivisionRadioModel(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioModel==null){
      shortStayHospitalRecuperationInstitutionDivisionRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationInstitutionDivisionRadioModel();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioModel;
  }

  /**
   * 病院を取得します。
   * @return 病院
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationInstitutionDivisionRadioItem1(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioItem1==null){

      shortStayHospitalRecuperationInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationInstitutionDivisionRadioItem1.setText("病院");

      shortStayHospitalRecuperationInstitutionDivisionRadioItem1.setGroup(getShortStayHospitalRecuperationInstitutionDivisionRadio());

      addShortStayHospitalRecuperationInstitutionDivisionRadioItem1();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioItem1;

  }

  /**
   * ユニット型病院を取得します。
   * @return ユニット型病院
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationInstitutionDivisionRadioItem2(){
    if(shortStayHospitalRecuperationInstitutionDivisionRadioItem2==null){

      shortStayHospitalRecuperationInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationInstitutionDivisionRadioItem2.setText("ユニット型病院");

      shortStayHospitalRecuperationInstitutionDivisionRadioItem2.setGroup(getShortStayHospitalRecuperationInstitutionDivisionRadio());

      addShortStayHospitalRecuperationInstitutionDivisionRadioItem2();
    }
    return shortStayHospitalRecuperationInstitutionDivisionRadioItem2;

  }

  /**
   * 人員配置区分ラジオグループを取得します。
   * @return 人員配置区分ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationStaffAssignmentDivision(){
    if(shortStayHospitalRecuperationStaffAssignmentDivision==null){

      shortStayHospitalRecuperationStaffAssignmentDivision = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationStaffAssignmentDivisionContainer().setText("人員配置区分");

      shortStayHospitalRecuperationStaffAssignmentDivision.setBindPath("1230102");

      shortStayHospitalRecuperationStaffAssignmentDivision.setModel(getShortStayHospitalRecuperationStaffAssignmentDivisionModel());

      shortStayHospitalRecuperationStaffAssignmentDivision.setUseClearButton(false);

      addShortStayHospitalRecuperationStaffAssignmentDivision();
    }
    return shortStayHospitalRecuperationStaffAssignmentDivision;

  }

  /**
   * 人員配置区分ラジオグループコンテナを取得します。
   * @return 人員配置区分ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayHospitalRecuperationStaffAssignmentDivisionContainer(){
    if(shortStayHospitalRecuperationStaffAssignmentDivisionContainer==null){
      shortStayHospitalRecuperationStaffAssignmentDivisionContainer = new ACLabelContainer();
      shortStayHospitalRecuperationStaffAssignmentDivisionContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationStaffAssignmentDivisionContainer.add(getShortStayHospitalRecuperationStaffAssignmentDivision(), null);
    }
    return shortStayHospitalRecuperationStaffAssignmentDivisionContainer;
  }

  /**
   * 人員配置区分ラジオグループモデルを取得します。
   * @return 人員配置区分ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationStaffAssignmentDivisionModel(){
    if(shortStayHospitalRecuperationStaffAssignmentDivisionModel==null){
      shortStayHospitalRecuperationStaffAssignmentDivisionModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationStaffAssignmentDivisionModel();
    }
    return shortStayHospitalRecuperationStaffAssignmentDivisionModel;
  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationStaffAssignmentDivision1(){
    if(shortStayHospitalRecuperationStaffAssignmentDivision1==null){

      shortStayHospitalRecuperationStaffAssignmentDivision1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationStaffAssignmentDivision1.setText("I型");

      shortStayHospitalRecuperationStaffAssignmentDivision1.setGroup(getShortStayHospitalRecuperationStaffAssignmentDivision());

      addShortStayHospitalRecuperationStaffAssignmentDivision1();
    }
    return shortStayHospitalRecuperationStaffAssignmentDivision1;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationStaffAssignmentDivision2(){
    if(shortStayHospitalRecuperationStaffAssignmentDivision2==null){

      shortStayHospitalRecuperationStaffAssignmentDivision2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationStaffAssignmentDivision2.setText("II型");

      shortStayHospitalRecuperationStaffAssignmentDivision2.setGroup(getShortStayHospitalRecuperationStaffAssignmentDivision());

      addShortStayHospitalRecuperationStaffAssignmentDivision2();
    }
    return shortStayHospitalRecuperationStaffAssignmentDivision2;

  }

  /**
   * III型を取得します。
   * @return III型
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationStaffAssignmentDivision3(){
    if(shortStayHospitalRecuperationStaffAssignmentDivision3==null){

      shortStayHospitalRecuperationStaffAssignmentDivision3 = new ACRadioButtonItem();

      shortStayHospitalRecuperationStaffAssignmentDivision3.setText("III型");

      shortStayHospitalRecuperationStaffAssignmentDivision3.setGroup(getShortStayHospitalRecuperationStaffAssignmentDivision());

      addShortStayHospitalRecuperationStaffAssignmentDivision3();
    }
    return shortStayHospitalRecuperationStaffAssignmentDivision3;

  }

  /**
   * 夜間勤務条件基準ラジオグループを取得します。
   * @return 夜間勤務条件基準ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationNightShiftCondition(){
    if(shortStayHospitalRecuperationNightShiftCondition==null){

      shortStayHospitalRecuperationNightShiftCondition = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationNightShiftConditionContainer().setText("夜間勤務条件基準");

      shortStayHospitalRecuperationNightShiftCondition.setBindPath("1230103");

      shortStayHospitalRecuperationNightShiftCondition.setLayout(getShortStayHospitalRecuperationNightShiftConditionLayout());

      shortStayHospitalRecuperationNightShiftCondition.setModel(getShortStayHospitalRecuperationNightShiftConditionModel());

      shortStayHospitalRecuperationNightShiftCondition.setUseClearButton(false);

      addShortStayHospitalRecuperationNightShiftCondition();
    }
    return shortStayHospitalRecuperationNightShiftCondition;

  }

  /**
   * 夜間勤務条件基準ラジオグループコンテナを取得します。
   * @return 夜間勤務条件基準ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayHospitalRecuperationNightShiftConditionContainer(){
    if(shortStayHospitalRecuperationNightShiftConditionContainer==null){
      shortStayHospitalRecuperationNightShiftConditionContainer = new ACLabelContainer();
      shortStayHospitalRecuperationNightShiftConditionContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationNightShiftConditionContainer.add(getShortStayHospitalRecuperationNightShiftCondition(), null);
    }
    return shortStayHospitalRecuperationNightShiftConditionContainer;
  }

  /**
   * 夜間勤務条件基準ラジオグループモデルを取得します。
   * @return 夜間勤務条件基準ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationNightShiftConditionModel(){
    if(shortStayHospitalRecuperationNightShiftConditionModel==null){
      shortStayHospitalRecuperationNightShiftConditionModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationNightShiftConditionModel();
    }
    return shortStayHospitalRecuperationNightShiftConditionModel;
  }

  /**
   * 夜間勤務条件基準ラジオグループレイアウトを取得します。
   * @return 夜間勤務条件基準ラジオグループレイアウト
   */
  public VRLayout getShortStayHospitalRecuperationNightShiftConditionLayout(){
    if(shortStayHospitalRecuperationNightShiftConditionLayout==null){

      shortStayHospitalRecuperationNightShiftConditionLayout = new VRLayout();

      shortStayHospitalRecuperationNightShiftConditionLayout.setAutoWrap(false);

      shortStayHospitalRecuperationNightShiftConditionLayout.setHgap(0);

      addShortStayHospitalRecuperationNightShiftConditionLayout();
    }
    return shortStayHospitalRecuperationNightShiftConditionLayout;

  }

  /**
   * 基準型を取得します。
   * @return 基準型
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationNightShiftConditionStandard(){
    if(shortStayHospitalRecuperationNightShiftConditionStandard==null){

      shortStayHospitalRecuperationNightShiftConditionStandard = new ACRadioButtonItem();

      shortStayHospitalRecuperationNightShiftConditionStandard.setText("基準型");

      shortStayHospitalRecuperationNightShiftConditionStandard.setGroup(getShortStayHospitalRecuperationNightShiftCondition());

      addShortStayHospitalRecuperationNightShiftConditionStandard();
    }
    return shortStayHospitalRecuperationNightShiftConditionStandard;

  }

  /**
   * 加算型Iを取得します。
   * @return 加算型I
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationNightShiftConditionAddition1(){
    if(shortStayHospitalRecuperationNightShiftConditionAddition1==null){

      shortStayHospitalRecuperationNightShiftConditionAddition1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationNightShiftConditionAddition1.setText("加算型I");

      shortStayHospitalRecuperationNightShiftConditionAddition1.setGroup(getShortStayHospitalRecuperationNightShiftCondition());

      addShortStayHospitalRecuperationNightShiftConditionAddition1();
    }
    return shortStayHospitalRecuperationNightShiftConditionAddition1;

  }

  /**
   * 加算型IIを取得します。
   * @return 加算型II
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationNightShiftConditionAddition2(){
    if(shortStayHospitalRecuperationNightShiftConditionAddition2==null){

      shortStayHospitalRecuperationNightShiftConditionAddition2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationNightShiftConditionAddition2.setText("加算型II");

      shortStayHospitalRecuperationNightShiftConditionAddition2.setGroup(getShortStayHospitalRecuperationNightShiftCondition());

      addShortStayHospitalRecuperationNightShiftConditionAddition2();
    }
    return shortStayHospitalRecuperationNightShiftConditionAddition2;

  }

  /**
   * 加算型IIIを取得します。
   * @return 加算型III
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationNightShiftConditionAddition3(){
    if(shortStayHospitalRecuperationNightShiftConditionAddition3==null){

      shortStayHospitalRecuperationNightShiftConditionAddition3 = new ACRadioButtonItem();

      shortStayHospitalRecuperationNightShiftConditionAddition3.setText("加算型III");

      shortStayHospitalRecuperationNightShiftConditionAddition3.setGroup(getShortStayHospitalRecuperationNightShiftCondition());

      addShortStayHospitalRecuperationNightShiftConditionAddition3();
    }
    return shortStayHospitalRecuperationNightShiftConditionAddition3;

  }

  /**
   * 減算型を取得します。
   * @return 減算型
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationNightShiftConditionSubtraction(){
    if(shortStayHospitalRecuperationNightShiftConditionSubtraction==null){

      shortStayHospitalRecuperationNightShiftConditionSubtraction = new ACRadioButtonItem();

      shortStayHospitalRecuperationNightShiftConditionSubtraction.setText("減算型");

      shortStayHospitalRecuperationNightShiftConditionSubtraction.setGroup(getShortStayHospitalRecuperationNightShiftCondition());

      addShortStayHospitalRecuperationNightShiftConditionSubtraction();
    }
    return shortStayHospitalRecuperationNightShiftConditionSubtraction;

  }

  /**
   * 療養環境基準ラジオグループを取得します。
   * @return 療養環境基準ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationRecuperationEnvironmental(){
    if(shortStayHospitalRecuperationRecuperationEnvironmental==null){

      shortStayHospitalRecuperationRecuperationEnvironmental = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationRecuperationEnvironmentalContainer().setText("療養環境基準");

      shortStayHospitalRecuperationRecuperationEnvironmental.setBindPath("1230104");

      shortStayHospitalRecuperationRecuperationEnvironmental.setModel(getShortStayHospitalRecuperationRecuperationEnvironmentalModel());

      shortStayHospitalRecuperationRecuperationEnvironmental.setUseClearButton(false);

      addShortStayHospitalRecuperationRecuperationEnvironmental();
    }
    return shortStayHospitalRecuperationRecuperationEnvironmental;

  }

  /**
   * 療養環境基準ラジオグループコンテナを取得します。
   * @return 療養環境基準ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayHospitalRecuperationRecuperationEnvironmentalContainer(){
    if(shortStayHospitalRecuperationRecuperationEnvironmentalContainer==null){
      shortStayHospitalRecuperationRecuperationEnvironmentalContainer = new ACLabelContainer();
      shortStayHospitalRecuperationRecuperationEnvironmentalContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationRecuperationEnvironmentalContainer.add(getShortStayHospitalRecuperationRecuperationEnvironmental(), null);
    }
    return shortStayHospitalRecuperationRecuperationEnvironmentalContainer;
  }

  /**
   * 療養環境基準ラジオグループモデルを取得します。
   * @return 療養環境基準ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationRecuperationEnvironmentalModel(){
    if(shortStayHospitalRecuperationRecuperationEnvironmentalModel==null){
      shortStayHospitalRecuperationRecuperationEnvironmentalModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationRecuperationEnvironmentalModel();
    }
    return shortStayHospitalRecuperationRecuperationEnvironmentalModel;
  }

  /**
   * 基準型を取得します。
   * @return 基準型
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationRecuperationEnvironmentalStandard(){
    if(shortStayHospitalRecuperationRecuperationEnvironmentalStandard==null){

      shortStayHospitalRecuperationRecuperationEnvironmentalStandard = new ACRadioButtonItem();

      shortStayHospitalRecuperationRecuperationEnvironmentalStandard.setText("基準型");

      shortStayHospitalRecuperationRecuperationEnvironmentalStandard.setGroup(getShortStayHospitalRecuperationRecuperationEnvironmental());

      addShortStayHospitalRecuperationRecuperationEnvironmentalStandard();
    }
    return shortStayHospitalRecuperationRecuperationEnvironmentalStandard;

  }

  /**
   * 減算型Iを取得します。
   * @return 減算型I
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationRecuperationEnvironmentalSubtraction1(){
    if(shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction1==null){

      shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction1.setText("減算型I");

      shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction1.setGroup(getShortStayHospitalRecuperationRecuperationEnvironmental());

      addShortStayHospitalRecuperationRecuperationEnvironmentalSubtraction1();
    }
    return shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction1;

  }

  /**
   * 減算型IIを取得します。
   * @return 減算型II
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationRecuperationEnvironmentalSubtraction2(){
    if(shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction2==null){

      shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction2.setText("減算型II");

      shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction2.setGroup(getShortStayHospitalRecuperationRecuperationEnvironmental());

      addShortStayHospitalRecuperationRecuperationEnvironmentalSubtraction2();
    }
    return shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction2;

  }

  /**
   * 減算型IIIを取得します。
   * @return 減算型III
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationRecuperationEnvironmentalSubtraction3(){
    if(shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction3==null){

      shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction3 = new ACRadioButtonItem();

      shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction3.setText("減算型III");

      shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction3.setGroup(getShortStayHospitalRecuperationRecuperationEnvironmental());

      addShortStayHospitalRecuperationRecuperationEnvironmentalSubtraction3();
    }
    return shortStayHospitalRecuperationRecuperationEnvironmentalSubtraction3;

  }

  /**
   * 医師の配置基準ラジオグループを取得します。
   * @return 医師の配置基準ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationDoctorsArrangement(){
    if(shortStayHospitalRecuperationDoctorsArrangement==null){

      shortStayHospitalRecuperationDoctorsArrangement = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationDoctorsArrangementContainer().setText("医師の配置基準");

      shortStayHospitalRecuperationDoctorsArrangement.setBindPath("1230105");

      shortStayHospitalRecuperationDoctorsArrangement.setModel(getShortStayHospitalRecuperationDoctorsArrangementModel());

      shortStayHospitalRecuperationDoctorsArrangement.setUseClearButton(false);

      addShortStayHospitalRecuperationDoctorsArrangement();
    }
    return shortStayHospitalRecuperationDoctorsArrangement;

  }

  /**
   * 医師の配置基準ラジオグループコンテナを取得します。
   * @return 医師の配置基準ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayHospitalRecuperationDoctorsArrangementContainer(){
    if(shortStayHospitalRecuperationDoctorsArrangementContainer==null){
      shortStayHospitalRecuperationDoctorsArrangementContainer = new ACLabelContainer();
      shortStayHospitalRecuperationDoctorsArrangementContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationDoctorsArrangementContainer.add(getShortStayHospitalRecuperationDoctorsArrangement(), null);
    }
    return shortStayHospitalRecuperationDoctorsArrangementContainer;
  }

  /**
   * 医師の配置基準ラジオグループモデルを取得します。
   * @return 医師の配置基準ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationDoctorsArrangementModel(){
    if(shortStayHospitalRecuperationDoctorsArrangementModel==null){
      shortStayHospitalRecuperationDoctorsArrangementModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationDoctorsArrangementModel();
    }
    return shortStayHospitalRecuperationDoctorsArrangementModel;
  }

  /**
   * 基準を取得します。
   * @return 基準
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationDoctorsArrangementStandard(){
    if(shortStayHospitalRecuperationDoctorsArrangementStandard==null){

      shortStayHospitalRecuperationDoctorsArrangementStandard = new ACRadioButtonItem();

      shortStayHospitalRecuperationDoctorsArrangementStandard.setText("基準");

      shortStayHospitalRecuperationDoctorsArrangementStandard.setGroup(getShortStayHospitalRecuperationDoctorsArrangement());

      addShortStayHospitalRecuperationDoctorsArrangementStandard();
    }
    return shortStayHospitalRecuperationDoctorsArrangementStandard;

  }

  /**
   * 医療法施行規則第49条適用を取得します。
   * @return 医療法施行規則第49条適用
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationDoctorsArrangementArticle49(){
    if(shortStayHospitalRecuperationDoctorsArrangementArticle49==null){

      shortStayHospitalRecuperationDoctorsArrangementArticle49 = new ACRadioButtonItem();

      shortStayHospitalRecuperationDoctorsArrangementArticle49.setText("49条適用");

      shortStayHospitalRecuperationDoctorsArrangementArticle49.setGroup(getShortStayHospitalRecuperationDoctorsArrangement());

      addShortStayHospitalRecuperationDoctorsArrangementArticle49();
    }
    return shortStayHospitalRecuperationDoctorsArrangementArticle49;

  }

  /**
   * 送迎体制ラジオグループを取得します。
   * @return 送迎体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationMeetingAndSendingOffSystem(){
    if(shortStayHospitalRecuperationMeetingAndSendingOffSystem==null){

      shortStayHospitalRecuperationMeetingAndSendingOffSystem = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationMeetingAndSendingOffSystemContainer().setText("送迎体制");

      shortStayHospitalRecuperationMeetingAndSendingOffSystem.setBindPath("1230106");

      shortStayHospitalRecuperationMeetingAndSendingOffSystem.setModel(getShortStayHospitalRecuperationMeetingAndSendingOffSystemModel());

      shortStayHospitalRecuperationMeetingAndSendingOffSystem.setUseClearButton(false);

      addShortStayHospitalRecuperationMeetingAndSendingOffSystem();
    }
    return shortStayHospitalRecuperationMeetingAndSendingOffSystem;

  }

  /**
   * 送迎体制ラジオグループコンテナを取得します。
   * @return 送迎体制ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayHospitalRecuperationMeetingAndSendingOffSystemContainer(){
    if(shortStayHospitalRecuperationMeetingAndSendingOffSystemContainer==null){
      shortStayHospitalRecuperationMeetingAndSendingOffSystemContainer = new ACLabelContainer();
      shortStayHospitalRecuperationMeetingAndSendingOffSystemContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationMeetingAndSendingOffSystemContainer.add(getShortStayHospitalRecuperationMeetingAndSendingOffSystem(), null);
    }
    return shortStayHospitalRecuperationMeetingAndSendingOffSystemContainer;
  }

  /**
   * 送迎体制ラジオグループモデルを取得します。
   * @return 送迎体制ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationMeetingAndSendingOffSystemModel(){
    if(shortStayHospitalRecuperationMeetingAndSendingOffSystemModel==null){
      shortStayHospitalRecuperationMeetingAndSendingOffSystemModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationMeetingAndSendingOffSystemModel();
    }
    return shortStayHospitalRecuperationMeetingAndSendingOffSystemModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationMeetingAndSendingOffSystemOff(){
    if(shortStayHospitalRecuperationMeetingAndSendingOffSystemOff==null){

      shortStayHospitalRecuperationMeetingAndSendingOffSystemOff = new ACRadioButtonItem();

      shortStayHospitalRecuperationMeetingAndSendingOffSystemOff.setText("なし");

      shortStayHospitalRecuperationMeetingAndSendingOffSystemOff.setGroup(getShortStayHospitalRecuperationMeetingAndSendingOffSystem());

      addShortStayHospitalRecuperationMeetingAndSendingOffSystemOff();
    }
    return shortStayHospitalRecuperationMeetingAndSendingOffSystemOff;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationMeetingAndSendingOffSystemOn(){
    if(shortStayHospitalRecuperationMeetingAndSendingOffSystemOn==null){

      shortStayHospitalRecuperationMeetingAndSendingOffSystemOn = new ACRadioButtonItem();

      shortStayHospitalRecuperationMeetingAndSendingOffSystemOn.setText("あり");

      shortStayHospitalRecuperationMeetingAndSendingOffSystemOn.setGroup(getShortStayHospitalRecuperationMeetingAndSendingOffSystem());

      addShortStayHospitalRecuperationMeetingAndSendingOffSystemOn();
    }
    return shortStayHospitalRecuperationMeetingAndSendingOffSystemOn;

  }

  /**
   * 栄養管理体制ラジオグループを取得します。
   * @return 栄養管理体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationNutritionManageRadio(){
    if(shortStayHospitalRecuperationNutritionManageRadio==null){

      shortStayHospitalRecuperationNutritionManageRadio = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationNutritionManageRadioContainer().setText("栄養管理体制");

      shortStayHospitalRecuperationNutritionManageRadio.setBindPath("1230107");

      shortStayHospitalRecuperationNutritionManageRadio.setModel(getShortStayHospitalRecuperationNutritionManageRadioModel());

      shortStayHospitalRecuperationNutritionManageRadio.setUseClearButton(false);

      addShortStayHospitalRecuperationNutritionManageRadio();
    }
    return shortStayHospitalRecuperationNutritionManageRadio;

  }

  /**
   * 栄養管理体制ラジオグループコンテナを取得します。
   * @return 栄養管理体制ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayHospitalRecuperationNutritionManageRadioContainer(){
    if(shortStayHospitalRecuperationNutritionManageRadioContainer==null){
      shortStayHospitalRecuperationNutritionManageRadioContainer = new ACLabelContainer();
      shortStayHospitalRecuperationNutritionManageRadioContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationNutritionManageRadioContainer.add(getShortStayHospitalRecuperationNutritionManageRadio(), null);
    }
    return shortStayHospitalRecuperationNutritionManageRadioContainer;
  }

  /**
   * 栄養管理体制ラジオグループモデルを取得します。
   * @return 栄養管理体制ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationNutritionManageRadioModel(){
    if(shortStayHospitalRecuperationNutritionManageRadioModel==null){
      shortStayHospitalRecuperationNutritionManageRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationNutritionManageRadioModel();
    }
    return shortStayHospitalRecuperationNutritionManageRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationNutritionManageRadioItem1(){
    if(shortStayHospitalRecuperationNutritionManageRadioItem1==null){

      shortStayHospitalRecuperationNutritionManageRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationNutritionManageRadioItem1.setText("なし");

      shortStayHospitalRecuperationNutritionManageRadioItem1.setGroup(getShortStayHospitalRecuperationNutritionManageRadio());

      addShortStayHospitalRecuperationNutritionManageRadioItem1();
    }
    return shortStayHospitalRecuperationNutritionManageRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationNutritionManageRadioItem2(){
    if(shortStayHospitalRecuperationNutritionManageRadioItem2==null){

      shortStayHospitalRecuperationNutritionManageRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationNutritionManageRadioItem2.setText("あり");

      shortStayHospitalRecuperationNutritionManageRadioItem2.setGroup(getShortStayHospitalRecuperationNutritionManageRadio());

      addShortStayHospitalRecuperationNutritionManageRadioItem2();
    }
    return shortStayHospitalRecuperationNutritionManageRadioItem2;

  }

  /**
   * 療養食体制ラジオグループを取得します。
   * @return 療養食体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayHospitalRecuperationRecuperationRadio(){
    if(shortStayHospitalRecuperationRecuperationRadio==null){

      shortStayHospitalRecuperationRecuperationRadio = new ACClearableRadioButtonGroup();

      getShortStayHospitalRecuperationRecuperationRadioContainer().setText("療養食体制");

      shortStayHospitalRecuperationRecuperationRadio.setBindPath("1230108");

      shortStayHospitalRecuperationRecuperationRadio.setModel(getShortStayHospitalRecuperationRecuperationRadioModel());

      shortStayHospitalRecuperationRecuperationRadio.setUseClearButton(false);

      addShortStayHospitalRecuperationRecuperationRadio();
    }
    return shortStayHospitalRecuperationRecuperationRadio;

  }

  /**
   * 療養食体制ラジオグループコンテナを取得します。
   * @return 療養食体制ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayHospitalRecuperationRecuperationRadioContainer(){
    if(shortStayHospitalRecuperationRecuperationRadioContainer==null){
      shortStayHospitalRecuperationRecuperationRadioContainer = new ACLabelContainer();
      shortStayHospitalRecuperationRecuperationRadioContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationRecuperationRadioContainer.add(getShortStayHospitalRecuperationRecuperationRadio(), null);
    }
    return shortStayHospitalRecuperationRecuperationRadioContainer;
  }

  /**
   * 療養食体制ラジオグループモデルを取得します。
   * @return 療養食体制ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayHospitalRecuperationRecuperationRadioModel(){
    if(shortStayHospitalRecuperationRecuperationRadioModel==null){
      shortStayHospitalRecuperationRecuperationRadioModel = new ACListModelAdapter();
      addShortStayHospitalRecuperationRecuperationRadioModel();
    }
    return shortStayHospitalRecuperationRecuperationRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationRecuperationRadioItem1(){
    if(shortStayHospitalRecuperationRecuperationRadioItem1==null){

      shortStayHospitalRecuperationRecuperationRadioItem1 = new ACRadioButtonItem();

      shortStayHospitalRecuperationRecuperationRadioItem1.setText("なし");

      shortStayHospitalRecuperationRecuperationRadioItem1.setGroup(getShortStayHospitalRecuperationRecuperationRadio());

      addShortStayHospitalRecuperationRecuperationRadioItem1();
    }
    return shortStayHospitalRecuperationRecuperationRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayHospitalRecuperationRecuperationRadioItem2(){
    if(shortStayHospitalRecuperationRecuperationRadioItem2==null){

      shortStayHospitalRecuperationRecuperationRadioItem2 = new ACRadioButtonItem();

      shortStayHospitalRecuperationRecuperationRadioItem2.setText("あり");

      shortStayHospitalRecuperationRecuperationRadioItem2.setGroup(getShortStayHospitalRecuperationRecuperationRadio());

      addShortStayHospitalRecuperationRecuperationRadioItem2();
    }
    return shortStayHospitalRecuperationRecuperationRadioItem2;

  }

  /**
   * 人員減算コンボを取得します。
   * @return 人員減算コンボ
   */
  public ACComboBox getShortStayHospitalRecuperationStaffReduce(){
    if(shortStayHospitalRecuperationStaffReduce==null){

      shortStayHospitalRecuperationStaffReduce = new ACComboBox();

      getShortStayHospitalRecuperationStaffReduceContainer().setText("人員減算");

      shortStayHospitalRecuperationStaffReduce.setBindPath("1230109");

      shortStayHospitalRecuperationStaffReduce.setEditable(false);

      shortStayHospitalRecuperationStaffReduce.setModelBindPath("STAFF_REDUCE");

      shortStayHospitalRecuperationStaffReduce.setModel(getShortStayHospitalRecuperationStaffReduceModel());

      shortStayHospitalRecuperationStaffReduce.setRenderBindPath("CONTENT");

      addShortStayHospitalRecuperationStaffReduce();
    }
    return shortStayHospitalRecuperationStaffReduce;

  }

  /**
   * 人員減算コンボコンテナを取得します。
   * @return 人員減算コンボコンテナ
   */
  protected ACLabelContainer getShortStayHospitalRecuperationStaffReduceContainer(){
    if(shortStayHospitalRecuperationStaffReduceContainer==null){
      shortStayHospitalRecuperationStaffReduceContainer = new ACLabelContainer();
      shortStayHospitalRecuperationStaffReduceContainer.setFollowChildEnabled(true);
      shortStayHospitalRecuperationStaffReduceContainer.add(getShortStayHospitalRecuperationStaffReduce(), null);
    }
    return shortStayHospitalRecuperationStaffReduceContainer;
  }

  /**
   * 人員減算コンボモデルを取得します。
   * @return 人員減算コンボモデル
   */
  protected ACComboBoxModelAdapter getShortStayHospitalRecuperationStaffReduceModel(){
    if(shortStayHospitalRecuperationStaffReduceModel==null){
      shortStayHospitalRecuperationStaffReduceModel = new ACComboBoxModelAdapter();
      addShortStayHospitalRecuperationStaffReduceModel();
    }
    return shortStayHospitalRecuperationStaffReduceModel;
  }

  /**
   * 食費基準額・コンテナを取得します。
   * @return 食費基準額・コンテナ
   */
  public ACLabelContainer getShortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner==null){

      shortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner.setText("食費基準額");

      shortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner;

  }

  /**
   * 食費基準額・合計・テキストを取得します。
   * @return 食費基準額・合計・テキスト
   */
  public ACTextField getShortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal(){
    if(shortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal==null){

      shortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal = new ACTextField();

      shortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal.setBindPath("1230110");

      shortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal.setEditable(false);

      shortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal.setColumns(4);

      shortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal.setMaxLength(4);

      addShortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal();
    }
    return shortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal;

  }

  /**
   * 食費基準額・朝・ラベルを取得します。
   * @return 食費基準額・朝・ラベル
   */
  public ACLabel getShortStayRecuperateCareHospitalMorningDinnerStandeirdMoneyLabel(){
    if(shortStayRecuperateCareHospitalMorningDinnerStandeirdMoneyLabel==null){

      shortStayRecuperateCareHospitalMorningDinnerStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareHospitalMorningDinnerStandeirdMoneyLabel.setText("　朝");

      addShortStayRecuperateCareHospitalMorningDinnerStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareHospitalMorningDinnerStandeirdMoneyLabel;

  }

  /**
   * 食費基準額・朝・テキストを取得します。
   * @return 食費基準額・朝・テキスト
   */
  public ACTextField getShortStayRecuperateCareHospitalMorningDinnerStandeirdMoney(){
    if(shortStayRecuperateCareHospitalMorningDinnerStandeirdMoney==null){

      shortStayRecuperateCareHospitalMorningDinnerStandeirdMoney = new ACTextField();

      shortStayRecuperateCareHospitalMorningDinnerStandeirdMoney.setBindPath("1230111");

      shortStayRecuperateCareHospitalMorningDinnerStandeirdMoney.setColumns(3);

      shortStayRecuperateCareHospitalMorningDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareHospitalMorningDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareHospitalMorningDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareHospitalMorningDinnerStandeirdMoney.setMaxLength(3);

      addShortStayRecuperateCareHospitalMorningDinnerStandeirdMoney();
    }
    return shortStayRecuperateCareHospitalMorningDinnerStandeirdMoney;

  }

  /**
   * 食費基準額・昼・ラベルを取得します。
   * @return 食費基準額・昼・ラベル
   */
  public ACLabel getShortStayRecuperateCareHospitalNoonDinnerStandeirdMoneyLabel(){
    if(shortStayRecuperateCareHospitalNoonDinnerStandeirdMoneyLabel==null){

      shortStayRecuperateCareHospitalNoonDinnerStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareHospitalNoonDinnerStandeirdMoneyLabel.setText("昼");

      addShortStayRecuperateCareHospitalNoonDinnerStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareHospitalNoonDinnerStandeirdMoneyLabel;

  }

  /**
   * 食費基準額・昼・テキストを取得します。
   * @return 食費基準額・昼・テキスト
   */
  public ACTextField getShortStayRecuperateCareHospitalNoonDinnerStandeirdMoney(){
    if(shortStayRecuperateCareHospitalNoonDinnerStandeirdMoney==null){

      shortStayRecuperateCareHospitalNoonDinnerStandeirdMoney = new ACTextField();

      shortStayRecuperateCareHospitalNoonDinnerStandeirdMoney.setBindPath("1230112");

      shortStayRecuperateCareHospitalNoonDinnerStandeirdMoney.setColumns(3);

      shortStayRecuperateCareHospitalNoonDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareHospitalNoonDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareHospitalNoonDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareHospitalNoonDinnerStandeirdMoney.setMaxLength(3);

      addShortStayRecuperateCareHospitalNoonDinnerStandeirdMoney();
    }
    return shortStayRecuperateCareHospitalNoonDinnerStandeirdMoney;

  }

  /**
   * 食費基準額・夜・ラベルを取得します。
   * @return 食費基準額・夜・ラベル
   */
  public ACLabel getShortStayRecuperateCareHospitalNightDinnerStandeirdMoneyLabel(){
    if(shortStayRecuperateCareHospitalNightDinnerStandeirdMoneyLabel==null){

      shortStayRecuperateCareHospitalNightDinnerStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareHospitalNightDinnerStandeirdMoneyLabel.setText("夜");

      addShortStayRecuperateCareHospitalNightDinnerStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareHospitalNightDinnerStandeirdMoneyLabel;

  }

  /**
   * 食費基準額・夜・テキストを取得します。
   * @return 食費基準額・夜・テキスト
   */
  public ACTextField getShortStayRecuperateCareHospitalNightDinnerStandeirdMoney(){
    if(shortStayRecuperateCareHospitalNightDinnerStandeirdMoney==null){

      shortStayRecuperateCareHospitalNightDinnerStandeirdMoney = new ACTextField();

      shortStayRecuperateCareHospitalNightDinnerStandeirdMoney.setBindPath("1230113");

      shortStayRecuperateCareHospitalNightDinnerStandeirdMoney.setColumns(3);

      shortStayRecuperateCareHospitalNightDinnerStandeirdMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareHospitalNightDinnerStandeirdMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareHospitalNightDinnerStandeirdMoney.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareHospitalNightDinnerStandeirdMoney.setMaxLength(3);

      addShortStayRecuperateCareHospitalNightDinnerStandeirdMoney();
    }
    return shortStayRecuperateCareHospitalNightDinnerStandeirdMoney;

  }

  /**
   * 食費基準額・ラベルを取得します。
   * @return 食費基準額・ラベル
   */
  public ACLabel getShortStayRecuperateCareHospitalDinnerStandeirdMoneyDenomination(){
    if(shortStayRecuperateCareHospitalDinnerStandeirdMoneyDenomination==null){

      shortStayRecuperateCareHospitalDinnerStandeirdMoneyDenomination = new ACLabel();

      shortStayRecuperateCareHospitalDinnerStandeirdMoneyDenomination.setText("（円）");

      addShortStayRecuperateCareHospitalDinnerStandeirdMoneyDenomination();
    }
    return shortStayRecuperateCareHospitalDinnerStandeirdMoneyDenomination;

  }

  /**
   * ユニット型個室基準額・コンテナを取得します。
   * @return ユニット型個室基準額・コンテナ
   */
  public ACLabelContainer getShortStayRecuperateCareHospitalUnitRoomStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyConteiner==null){

      shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyConteiner.setText("ユニット型個室基準額");

      shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareHospitalUnitRoomStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyConteiner;

  }

  /**
   * ユニット型個室基準額・テキストを取得します。
   * @return ユニット型個室基準額・テキスト
   */
  public ACTextField getShortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText(){
    if(shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText==null){

      shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText = new ACTextField();

      shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText.setBindPath("1230114");

      shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText.setColumns(4);

      shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText.setMaxLength(4);

      addShortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText();
    }
    return shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText;

  }

  /**
   * ユニット型個室基準額・ラベルを取得します。
   * @return ユニット型個室基準額・ラベル
   */
  public ACLabel getShortStayRecuperateCareHospitalUnitRoomStandeirdMoneyLabel(){
    if(shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyLabel==null){

      shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyLabel.setText("（円）");

      addShortStayRecuperateCareHospitalUnitRoomStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyLabel;

  }

  /**
   * ユニット型準個室基準額・コンテナを取得します。
   * @return ユニット型準個室基準額・コンテナ
   */
  public ACLabelContainer getShortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyConteiner==null){

      shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyConteiner.setText("ユニット型準個室基準額");

      shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyConteiner;

  }

  /**
   * ユニット型準個室基準額・テキストを取得します。
   * @return ユニット型準個室基準額・テキスト
   */
  public ACTextField getShortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText(){
    if(shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText==null){

      shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText = new ACTextField();

      shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText.setBindPath("1230115");

      shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText.setColumns(4);

      shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText.setMaxLength(4);

      addShortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText();
    }
    return shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText;

  }

  /**
   * ユニット型準個室基準額・ラベルを取得します。
   * @return ユニット型準個室基準額・ラベル
   */
  public ACLabel getShortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyLabel(){
    if(shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyLabel==null){

      shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyLabel.setText("（円）");

      addShortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyLabel;

  }

  /**
   * 従来型個室基準額・コンテナを取得します。
   * @return 従来型個室基準額・コンテナ
   */
  public ACLabelContainer getShortStayRecuperateCareHospitalNormalRoomStandeirdMoneyConteiner(){
    if(shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyConteiner==null){

      shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyConteiner = new ACLabelContainer();

      shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyConteiner.setText("　　従来型個室基準額");

      shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareHospitalNormalRoomStandeirdMoneyConteiner();
    }
    return shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyConteiner;

  }

  /**
   * 従来型個室基準額・テキストを取得します。
   * @return 従来型個室基準額・テキスト
   */
  public ACTextField getShortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText(){
    if(shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText==null){

      shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText = new ACTextField();

      shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText.setBindPath("1230116");

      shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText.setColumns(4);

      shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText.setMaxLength(4);

      addShortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText();
    }
    return shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText;

  }

  /**
   * 従来型個室基準額・ラベルを取得します。
   * @return 従来型個室基準額・ラベル
   */
  public ACLabel getShortStayRecuperateCareHospitalNormalRoomStandeirdMoneyLabel(){
    if(shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyLabel==null){

      shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyLabel = new ACLabel();

      shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyLabel.setText("（円）");

      addShortStayRecuperateCareHospitalNormalRoomStandeirdMoneyLabel();
    }
    return shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyLabel;

  }

  /**
   * 多床室基準額・コンテナを取得します。
   * @return 多床室基準額・コンテナ
   */
  public ACLabelContainer getShortStayRecuperateCareHospitalTasyouRoomConteiner(){
    if(shortStayRecuperateCareHospitalTasyouRoomConteiner==null){

      shortStayRecuperateCareHospitalTasyouRoomConteiner = new ACLabelContainer();

      shortStayRecuperateCareHospitalTasyouRoomConteiner.setText("　　多床室基準額");

      shortStayRecuperateCareHospitalTasyouRoomConteiner.setFollowChildEnabled(true);

      addShortStayRecuperateCareHospitalTasyouRoomConteiner();
    }
    return shortStayRecuperateCareHospitalTasyouRoomConteiner;

  }

  /**
   * 多床室基準額・テキストを取得します。
   * @return 多床室基準額・テキスト
   */
  public ACTextField getShortStayRecuperateCareHospitalTasyouRoomText(){
    if(shortStayRecuperateCareHospitalTasyouRoomText==null){

      shortStayRecuperateCareHospitalTasyouRoomText = new ACTextField();

      shortStayRecuperateCareHospitalTasyouRoomText.setBindPath("1230117");

      shortStayRecuperateCareHospitalTasyouRoomText.setColumns(4);

      shortStayRecuperateCareHospitalTasyouRoomText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayRecuperateCareHospitalTasyouRoomText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayRecuperateCareHospitalTasyouRoomText.setIMEMode(InputSubset.LATIN);

      shortStayRecuperateCareHospitalTasyouRoomText.setMaxLength(4);

      addShortStayRecuperateCareHospitalTasyouRoomText();
    }
    return shortStayRecuperateCareHospitalTasyouRoomText;

  }

  /**
   * 多床室基準額・ラベルを取得します。
   * @return 多床室基準額・ラベル
   */
  public ACLabel getShortStayRecuperateCareHospitalTasyouRoomLabel(){
    if(shortStayRecuperateCareHospitalTasyouRoomLabel==null){

      shortStayRecuperateCareHospitalTasyouRoomLabel = new ACLabel();

      shortStayRecuperateCareHospitalTasyouRoomLabel.setText("（円）");

      addShortStayRecuperateCareHospitalTasyouRoomLabel();
    }
    return shortStayRecuperateCareHospitalTasyouRoomLabel;

  }

  /**
   * コンストラクタです。
   */
  public QO004010Design() {

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

    this.add(getShortStayHospitalRecuperationGroup(), VRLayout.CLIENT);

  }

  /**
   * 事業グループに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationGroup(){

    shortStayHospitalRecuperationGroup.add(getShortStayHospitalRecuperationDiscountContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationGroup.add(getShortStayHospitalRecuperationInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationGroup.add(getShortStayHospitalRecuperationStaffAssignmentDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationGroup.add(getShortStayHospitalRecuperationNightShiftConditionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationGroup.add(getShortStayHospitalRecuperationRecuperationEnvironmentalContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationGroup.add(getShortStayHospitalRecuperationDoctorsArrangementContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationGroup.add(getShortStayHospitalRecuperationMeetingAndSendingOffSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationGroup.add(getShortStayHospitalRecuperationNutritionManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationGroup.add(getShortStayHospitalRecuperationRecuperationRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationGroup.add(getShortStayHospitalRecuperationStaffReduceContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationGroup.add(getShortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationGroup.add(getShortStayRecuperateCareHospitalUnitRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationGroup.add(getShortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationGroup.add(getShortStayRecuperateCareHospitalNormalRoomStandeirdMoneyConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayHospitalRecuperationGroup.add(getShortStayRecuperateCareHospitalTasyouRoomConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 割引率コンテナに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationDiscountContainer(){

    shortStayHospitalRecuperationDiscountContainer.add(getShortStayHospitalRecuperationDiscountRate(), VRLayout.FLOW);

    shortStayHospitalRecuperationDiscountContainer.add(getPercentSign(), VRLayout.FLOW);

  }

  /**
   * 割引率に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationDiscountRate(){

  }

  /**
   * ％ラベルに内部項目を追加します。
   */
  protected void addPercentSign(){

  }

  /**
   * 施設区分ラジオグループに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadio(){

  }

  /**
   * 施設区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioModel(){

    getShortStayHospitalRecuperationInstitutionDivisionRadioItem1().setButtonIndex(1);
    getShortStayHospitalRecuperationInstitutionDivisionRadioModel().add(getShortStayHospitalRecuperationInstitutionDivisionRadioItem1());

    getShortStayHospitalRecuperationInstitutionDivisionRadioItem2().setButtonIndex(2);
    getShortStayHospitalRecuperationInstitutionDivisionRadioModel().add(getShortStayHospitalRecuperationInstitutionDivisionRadioItem2());

  }

  /**
   * 病院に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioItem1(){

  }

  /**
   * ユニット型病院に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationInstitutionDivisionRadioItem2(){

  }

  /**
   * 人員配置区分ラジオグループに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationStaffAssignmentDivision(){

  }

  /**
   * 人員配置区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationStaffAssignmentDivisionModel(){

    getShortStayHospitalRecuperationStaffAssignmentDivision1().setButtonIndex(1);
    getShortStayHospitalRecuperationStaffAssignmentDivisionModel().add(getShortStayHospitalRecuperationStaffAssignmentDivision1());

    getShortStayHospitalRecuperationStaffAssignmentDivision2().setButtonIndex(2);
    getShortStayHospitalRecuperationStaffAssignmentDivisionModel().add(getShortStayHospitalRecuperationStaffAssignmentDivision2());

    getShortStayHospitalRecuperationStaffAssignmentDivision3().setButtonIndex(3);
    getShortStayHospitalRecuperationStaffAssignmentDivisionModel().add(getShortStayHospitalRecuperationStaffAssignmentDivision3());

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationStaffAssignmentDivision1(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationStaffAssignmentDivision2(){

  }

  /**
   * III型に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationStaffAssignmentDivision3(){

  }

  /**
   * 夜間勤務条件基準ラジオグループに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationNightShiftCondition(){

  }

  /**
   * 夜間勤務条件基準ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationNightShiftConditionModel(){

    getShortStayHospitalRecuperationNightShiftConditionStandard().setButtonIndex(1);
    getShortStayHospitalRecuperationNightShiftConditionModel().add(getShortStayHospitalRecuperationNightShiftConditionStandard());

    getShortStayHospitalRecuperationNightShiftConditionAddition1().setButtonIndex(2);
    getShortStayHospitalRecuperationNightShiftConditionModel().add(getShortStayHospitalRecuperationNightShiftConditionAddition1());

    getShortStayHospitalRecuperationNightShiftConditionAddition2().setButtonIndex(3);
    getShortStayHospitalRecuperationNightShiftConditionModel().add(getShortStayHospitalRecuperationNightShiftConditionAddition2());

    getShortStayHospitalRecuperationNightShiftConditionAddition3().setButtonIndex(4);
    getShortStayHospitalRecuperationNightShiftConditionModel().add(getShortStayHospitalRecuperationNightShiftConditionAddition3());

    getShortStayHospitalRecuperationNightShiftConditionSubtraction().setButtonIndex(5);
    getShortStayHospitalRecuperationNightShiftConditionModel().add(getShortStayHospitalRecuperationNightShiftConditionSubtraction());

  }

  /**
   * 夜間勤務条件基準ラジオグループレイアウトに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationNightShiftConditionLayout(){

  }

  /**
   * 基準型に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationNightShiftConditionStandard(){

  }

  /**
   * 加算型Iに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationNightShiftConditionAddition1(){

  }

  /**
   * 加算型IIに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationNightShiftConditionAddition2(){

  }

  /**
   * 加算型IIIに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationNightShiftConditionAddition3(){

  }

  /**
   * 減算型に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationNightShiftConditionSubtraction(){

  }

  /**
   * 療養環境基準ラジオグループに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationRecuperationEnvironmental(){

  }

  /**
   * 療養環境基準ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationRecuperationEnvironmentalModel(){

    getShortStayHospitalRecuperationRecuperationEnvironmentalStandard().setButtonIndex(1);
    getShortStayHospitalRecuperationRecuperationEnvironmentalModel().add(getShortStayHospitalRecuperationRecuperationEnvironmentalStandard());

    getShortStayHospitalRecuperationRecuperationEnvironmentalSubtraction1().setButtonIndex(2);
    getShortStayHospitalRecuperationRecuperationEnvironmentalModel().add(getShortStayHospitalRecuperationRecuperationEnvironmentalSubtraction1());

    getShortStayHospitalRecuperationRecuperationEnvironmentalSubtraction2().setButtonIndex(3);
    getShortStayHospitalRecuperationRecuperationEnvironmentalModel().add(getShortStayHospitalRecuperationRecuperationEnvironmentalSubtraction2());

    getShortStayHospitalRecuperationRecuperationEnvironmentalSubtraction3().setButtonIndex(4);
    getShortStayHospitalRecuperationRecuperationEnvironmentalModel().add(getShortStayHospitalRecuperationRecuperationEnvironmentalSubtraction3());

  }

  /**
   * 基準型に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationRecuperationEnvironmentalStandard(){

  }

  /**
   * 減算型Iに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationRecuperationEnvironmentalSubtraction1(){

  }

  /**
   * 減算型IIに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationRecuperationEnvironmentalSubtraction2(){

  }

  /**
   * 減算型IIIに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationRecuperationEnvironmentalSubtraction3(){

  }

  /**
   * 医師の配置基準ラジオグループに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationDoctorsArrangement(){

  }

  /**
   * 医師の配置基準ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationDoctorsArrangementModel(){

    getShortStayHospitalRecuperationDoctorsArrangementStandard().setButtonIndex(1);
    getShortStayHospitalRecuperationDoctorsArrangementModel().add(getShortStayHospitalRecuperationDoctorsArrangementStandard());

    getShortStayHospitalRecuperationDoctorsArrangementArticle49().setButtonIndex(2);
    getShortStayHospitalRecuperationDoctorsArrangementModel().add(getShortStayHospitalRecuperationDoctorsArrangementArticle49());

  }

  /**
   * 基準に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationDoctorsArrangementStandard(){

  }

  /**
   * 医療法施行規則第49条適用に内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationDoctorsArrangementArticle49(){

  }

  /**
   * 送迎体制ラジオグループに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationMeetingAndSendingOffSystem(){

  }

  /**
   * 送迎体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationMeetingAndSendingOffSystemModel(){

    getShortStayHospitalRecuperationMeetingAndSendingOffSystemOff().setButtonIndex(1);
    getShortStayHospitalRecuperationMeetingAndSendingOffSystemModel().add(getShortStayHospitalRecuperationMeetingAndSendingOffSystemOff());

    getShortStayHospitalRecuperationMeetingAndSendingOffSystemOn().setButtonIndex(2);
    getShortStayHospitalRecuperationMeetingAndSendingOffSystemModel().add(getShortStayHospitalRecuperationMeetingAndSendingOffSystemOn());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationMeetingAndSendingOffSystemOff(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationMeetingAndSendingOffSystemOn(){

  }

  /**
   * 栄養管理体制ラジオグループに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationNutritionManageRadio(){

  }

  /**
   * 栄養管理体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationNutritionManageRadioModel(){

    getShortStayHospitalRecuperationNutritionManageRadioItem1().setButtonIndex(1);
    getShortStayHospitalRecuperationNutritionManageRadioModel().add(getShortStayHospitalRecuperationNutritionManageRadioItem1());

    getShortStayHospitalRecuperationNutritionManageRadioItem2().setButtonIndex(2);
    getShortStayHospitalRecuperationNutritionManageRadioModel().add(getShortStayHospitalRecuperationNutritionManageRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationNutritionManageRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationNutritionManageRadioItem2(){

  }

  /**
   * 療養食体制ラジオグループに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationRecuperationRadio(){

  }

  /**
   * 療養食体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationRecuperationRadioModel(){

    getShortStayHospitalRecuperationRecuperationRadioItem1().setButtonIndex(1);
    getShortStayHospitalRecuperationRecuperationRadioModel().add(getShortStayHospitalRecuperationRecuperationRadioItem1());

    getShortStayHospitalRecuperationRecuperationRadioItem2().setButtonIndex(2);
    getShortStayHospitalRecuperationRecuperationRadioModel().add(getShortStayHospitalRecuperationRecuperationRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationRecuperationRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationRecuperationRadioItem2(){

  }

  /**
   * 人員減算コンボに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationStaffReduce(){

  }

  /**
   * 人員減算コンボモデルに内部項目を追加します。
   */
  protected void addShortStayHospitalRecuperationStaffReduceModel(){

  }

  /**
   * 食費基準額・コンテナに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner(){

    shortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal(), VRLayout.FLOW);

    shortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareHospitalMorningDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    shortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareHospitalMorningDinnerStandeirdMoney(), VRLayout.FLOW);

    shortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareHospitalNoonDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    shortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareHospitalNoonDinnerStandeirdMoney(), VRLayout.FLOW);

    shortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareHospitalNightDinnerStandeirdMoneyLabel(), VRLayout.FLOW);

    shortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareHospitalNightDinnerStandeirdMoney(), VRLayout.FLOW);

    shortStayRecuperateCareHospitalDinnerStandeirdMoneyConteiner.add(getShortStayRecuperateCareHospitalDinnerStandeirdMoneyDenomination(), VRLayout.FLOW);

  }

  /**
   * 食費基準額・合計・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareHospitalDinnerStandeirdMoneyTotal(){

  }

  /**
   * 食費基準額・朝・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareHospitalMorningDinnerStandeirdMoneyLabel(){

  }

  /**
   * 食費基準額・朝・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareHospitalMorningDinnerStandeirdMoney(){

  }

  /**
   * 食費基準額・昼・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareHospitalNoonDinnerStandeirdMoneyLabel(){

  }

  /**
   * 食費基準額・昼・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareHospitalNoonDinnerStandeirdMoney(){

  }

  /**
   * 食費基準額・夜・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareHospitalNightDinnerStandeirdMoneyLabel(){

  }

  /**
   * 食費基準額・夜・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareHospitalNightDinnerStandeirdMoney(){

  }

  /**
   * 食費基準額・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareHospitalDinnerStandeirdMoneyDenomination(){

  }

  /**
   * ユニット型個室基準額・コンテナに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareHospitalUnitRoomStandeirdMoneyConteiner(){

    shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText(), null);

    shortStayRecuperateCareHospitalUnitRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareHospitalUnitRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ユニット型個室基準額・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareHospitalUnitRoomStandeirdMoneyText(){

  }

  /**
   * ユニット型個室基準額・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareHospitalUnitRoomStandeirdMoneyLabel(){

  }

  /**
   * ユニット型準個室基準額・コンテナに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyConteiner(){

    shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText(), null);

    shortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyLabel(), null);

  }

  /**
   * ユニット型準個室基準額・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyText(){

  }

  /**
   * ユニット型準個室基準額・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareHospitalUnitSemiRoomStandeirdMoneyLabel(){

  }

  /**
   * 従来型個室基準額・コンテナに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareHospitalNormalRoomStandeirdMoneyConteiner(){

    shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText(), null);

    shortStayRecuperateCareHospitalNormalRoomStandeirdMoneyConteiner.add(getShortStayRecuperateCareHospitalNormalRoomStandeirdMoneyLabel(), null);

  }

  /**
   * 従来型個室基準額・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareHospitalNormalRoomStandeirdMoneyText(){

  }

  /**
   * 従来型個室基準額・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareHospitalNormalRoomStandeirdMoneyLabel(){

  }

  /**
   * 多床室基準額・コンテナに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareHospitalTasyouRoomConteiner(){

    shortStayRecuperateCareHospitalTasyouRoomConteiner.add(getShortStayRecuperateCareHospitalTasyouRoomText(), null);

    shortStayRecuperateCareHospitalTasyouRoomConteiner.add(getShortStayRecuperateCareHospitalTasyouRoomLabel(), null);

  }

  /**
   * 多床室基準額・テキストに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareHospitalTasyouRoomText(){

  }

  /**
   * 多床室基準額・ラベルに内部項目を追加します。
   */
  protected void addShortStayRecuperateCareHospitalTasyouRoomLabel(){

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
      ACFrame.getInstance().getContentPane().add(new QO004010Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004010Design getThis() {
    return this;
  }
}
