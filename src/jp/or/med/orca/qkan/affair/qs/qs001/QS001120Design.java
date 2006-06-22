
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
 * 作成日: 2006/03/17  日本コンピューター株式会社 松本　幸一 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン介護療養型医療施設（病院） (QS001120)
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
 * サービスパターン介護療養型医療施設（病院）画面項目デザイン(QS001120) 
 */
public class QS001120Design extends QS001ServicePanel {
  //GUIコンポーネント

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACClearableRadioButtonGroup medicalFacilityHospitalInstitutionDivisionRadio;

  private ACLabelContainer medicalFacilityHospitalInstitutionDivisionRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalInstitutionDivisionRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalHospitalInstitutionDivisionRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalHospitalInstitutionDivisionRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityHospitalHospitalDivision;

  private ACLabelContainer medicalFacilityHospitalHospitalDivisionContainer;

  private ACListModelAdapter medicalFacilityHospitalHospitalDivisionModel;

  private ACRadioButtonItem medicalFacilityHospitalDivision1;

  private ACRadioButtonItem medicalFacilityHospitalDivision2;

  private ACRadioButtonItem medicalFacilityHospitalDivision3;

  private ACLabelContainer medicalFacilityHospitalHospitalRoomContena;

  private ACClearableRadioButtonGroup medicalFacilityHospitalHospitalRoomRadio;

  private ACListModelAdapter medicalFacilityHospitalHospitalRoomRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalHospitalRoomRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalHospitalRoomRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityHospitalUnitHospitalRoomRadio;

  private ACListModelAdapter medicalFacilityHospitalUnitHospitalRoomRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalUnitHospitalRoomRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalUnitHospitalRoomRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityHospitalNightShiftSubtractionRadio;

  private ACLabelContainer medicalFacilityHospitalNightShiftSubtractionRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalNightShiftSubtractionRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalNightShiftSubtractionRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalNightShiftSubtractionRadioItem2;

  private ACRadioButtonItem medicalFacilityHospitalNightShiftSubtractionRadioItem3;

  private ACRadioButtonItem medicalFacilityHospitalNightShiftSubtractionRadioItem4;

  private ACRadioButtonItem medicalFacilityHospitalNightShiftSubtractionRadioItem5;

  private ACClearableRadioButtonGroup medicalFacilityHospitalEnvironmentalRadio;

  private ACLabelContainer medicalFacilityHospitalEnvironmentalRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalEnvironmentalRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalEnvironmentalRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalEnvironmentalRadioItem2;

  private ACRadioButtonItem medicalFacilityHospitalEnvironmentalRadioItem3;

  private ACRadioButtonItem medicalFacilityHospitalEnvironmentalRadioItem4;

  private ACClearableRadioButtonGroup medicalFacilityHospitalDoctorArrangeStandardRadio;

  private ACLabelContainer medicalFacilityHospitalDoctorArrangeStandardRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalDoctorArrangeStandardRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalDoctorArrangeStandardRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalDoctorArrangeStandardRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityHospitalStayRadio;

  private ACLabelContainer medicalFacilityHospitalStayRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalStayRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalStayRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalStayRadioItem2;

  private ACPanel tab2;

  private ACClearableRadioButtonGroup medicalFacilityHospitalStandardRadio;

  private ACLabelContainer medicalFacilityHospitalStandardRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalStandardRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalStandardRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalStandardRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityHospitalMedicalExaminationRadio;

  private ACLabelContainer medicalFacilityHospitalMedicalExaminationRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalMedicalExaminationRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalMedicalExaminationRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalMedicalExaminationRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityHospitalNutritionManageRadio;

  private ACLabelContainer medicalFacilityHospitalNutritionManageRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalNutritionManageRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalNutritionManageRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalNutritionManageRadioItem2;

  private ACRadioButtonItem medicalFacilityHospitalNutritionManageRadioItem3;

  private ACClearableRadioButtonGroup medicalFacilityHospitalNutritionRadio;

  private ACLabelContainer medicalFacilityHospitalNutritionRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalNutritionRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalNutritionRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalNutritionRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityHospitalOralSwitchRadio;

  private ACLabelContainer medicalFacilityHospitalOralSwitchRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalOralSwitchRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalOralSwitchRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalOralSwitchRadioItem2;

  private ACClearableRadioButtonGroup oralMaintenanceRadio;

  private ACLabelContainer oralMaintenanceRadioContainer;

  private ACListModelAdapter oralMaintenanceRadioModel;

  private ACRadioButtonItem oralMaintenanceRadioItem1;

  private ACRadioButtonItem oralMaintenanceRadioItem2;

  private ACRadioButtonItem oralMaintenanceRadioItem3;

  private ACClearableRadioButtonGroup medicalFacilityHospitalRecuperateDinnerRadio;

  private ACLabelContainer medicalFacilityHospitalRecuperateDinnerRadioContainer;

  private ACListModelAdapter medicalFacilityHospitalRecuperateDinnerRadioModel;

  private ACRadioButtonItem medicalFacilityHospitalRecuperateDinnerRadioItem1;

  private ACRadioButtonItem medicalFacilityHospitalRecuperateDinnerRadioItem2;

  private ACLabelContainer medicalFacilityHospitalHijoAddition;

  private ACIntegerCheckBox leavingHospitalPreConsultationAddition;

  private ACIntegerCheckBox leavingHospitalConsultationAddition;

  private ACIntegerCheckBox leavingHospitalDissemination;

  private ACIntegerCheckBox leavingHospitalCooperationAddition;

  private ACIntegerCheckBox leavingHospital;

  private ACPanel tab3;

  private ACMapBindButton medicalFacilityHospitalConsultationFee;

  private ACLabel medicalFacilityHospitalConsultationFeeLabel;

  private ACComboBox medicalFacilityHospitalSubstraction;

  private ACLabelContainer medicalFacilityHospitalSubstractionContainer;

  private ACComboBoxModelAdapter medicalFacilityHospitalSubstractionModel;

  private ACBackLabelContainer medicalFacilityDinnerContainer;

  private ACComboBox medicalFacilityDinnerOffer;

  private ACLabelContainer medicalFacilityDinnerOfferContainer;

  private ACComboBoxModelAdapter medicalFacilityDinnerOfferModel;

  private ACTextField medicalFacilityDinnerCost;

  private ACLabelContainer medicalFacilityDinnerCostContainer;

  private ACClearableRadioButtonGroup unitCareMaintenanceRadio;

  private ACLabelContainer unitCareMaintenanceRadioContainer;

  private ACListModelAdapter unitCareMaintenanceRadioModel;

  private ACRadioButtonItem unitCareMaintenanceRadioItem1;

  private ACRadioButtonItem unitCareMaintenanceRadioItem2;

  private ACClearableRadioButtonGroup bodyRestraintAbolitionRadio;

  private ACLabelContainer bodyRestraintAbolitionRadioContainer;

  private ACListModelAdapter bodyRestraintAbolitionRadioModel;

  private ACRadioButtonItem bodyRestraintAbolitionRadioItem1;

  private ACRadioButtonItem bodyRestraintAbolitionRadioItem2;

  private ACClearableRadioButtonGroup stayReturnSupportAddRadio;

  private ACLabelContainer stayReturnSupportAddRadioContainer;

  private ACListModelAdapter stayReturnSupportAddRadioModel;

  private ACRadioButtonItem stayReturnSupportAddRadioItem1;

  private ACRadioButtonItem stayReturnSupportAddRadioItem2;

  //getter

  /**
   * タブペインを取得します。
   * @return タブペイン
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

      tab1.setHgap(0);

      addTab1();
    }
    return tab1;

  }

  /**
   * 施設等の区分を取得します。
   * @return 施設等の区分
   */
  public ACClearableRadioButtonGroup getMedicalFacilityHospitalInstitutionDivisionRadio(){
    if(medicalFacilityHospitalInstitutionDivisionRadio==null){

      medicalFacilityHospitalInstitutionDivisionRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityHospitalInstitutionDivisionRadioContainer().setText("施設等の区分");

      medicalFacilityHospitalInstitutionDivisionRadio.setBindPath("1530101");

      medicalFacilityHospitalInstitutionDivisionRadio.setModel(getMedicalFacilityHospitalInstitutionDivisionRadioModel());

      medicalFacilityHospitalInstitutionDivisionRadio.setUseClearButton(false);

      addMedicalFacilityHospitalInstitutionDivisionRadio();
    }
    return medicalFacilityHospitalInstitutionDivisionRadio;

  }

  /**
   * 施設等の区分コンテナを取得します。
   * @return 施設等の区分コンテナ
   */
  protected ACLabelContainer getMedicalFacilityHospitalInstitutionDivisionRadioContainer(){
    if(medicalFacilityHospitalInstitutionDivisionRadioContainer==null){
      medicalFacilityHospitalInstitutionDivisionRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalInstitutionDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalInstitutionDivisionRadioContainer.add(getMedicalFacilityHospitalInstitutionDivisionRadio(), null);
    }
    return medicalFacilityHospitalInstitutionDivisionRadioContainer;
  }

  /**
   * 施設等の区分モデルを取得します。
   * @return 施設等の区分モデル
   */
  protected ACListModelAdapter getMedicalFacilityHospitalInstitutionDivisionRadioModel(){
    if(medicalFacilityHospitalInstitutionDivisionRadioModel==null){
      medicalFacilityHospitalInstitutionDivisionRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalInstitutionDivisionRadioModel();
    }
    return medicalFacilityHospitalInstitutionDivisionRadioModel;
  }

  /**
   * 病院を取得します。
   * @return 病院
   */
  public ACRadioButtonItem getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem1(){
    if(medicalFacilityHospitalHospitalInstitutionDivisionRadioItem1==null){

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem1.setText("病院");

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem1.setGroup(getMedicalFacilityHospitalInstitutionDivisionRadio());

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem1();
    }
    return medicalFacilityHospitalHospitalInstitutionDivisionRadioItem1;

  }

  /**
   * ユニット型病院を取得します。
   * @return ユニット型病院
   */
  public ACRadioButtonItem getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem2(){
    if(medicalFacilityHospitalHospitalInstitutionDivisionRadioItem2==null){

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem2.setText("ユニット型病院");

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem2.setGroup(getMedicalFacilityHospitalInstitutionDivisionRadio());

      medicalFacilityHospitalHospitalInstitutionDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem2();
    }
    return medicalFacilityHospitalHospitalInstitutionDivisionRadioItem2;

  }

  /**
   * 人員配置区分を取得します。
   * @return 人員配置区分
   */
  public ACClearableRadioButtonGroup getMedicalFacilityHospitalHospitalDivision(){
    if(medicalFacilityHospitalHospitalDivision==null){

      medicalFacilityHospitalHospitalDivision = new ACClearableRadioButtonGroup();

      getMedicalFacilityHospitalHospitalDivisionContainer().setText("人員配置区分");

      medicalFacilityHospitalHospitalDivision.setBindPath("1530102");

      medicalFacilityHospitalHospitalDivision.setModel(getMedicalFacilityHospitalHospitalDivisionModel());

      medicalFacilityHospitalHospitalDivision.setUseClearButton(false);

      addMedicalFacilityHospitalHospitalDivision();
    }
    return medicalFacilityHospitalHospitalDivision;

  }

  /**
   * 人員配置区分コンテナを取得します。
   * @return 人員配置区分コンテナ
   */
  protected ACLabelContainer getMedicalFacilityHospitalHospitalDivisionContainer(){
    if(medicalFacilityHospitalHospitalDivisionContainer==null){
      medicalFacilityHospitalHospitalDivisionContainer = new ACLabelContainer();
      medicalFacilityHospitalHospitalDivisionContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalHospitalDivisionContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalHospitalDivisionContainer.add(getMedicalFacilityHospitalHospitalDivision(), null);
    }
    return medicalFacilityHospitalHospitalDivisionContainer;
  }

  /**
   * 人員配置区分モデルを取得します。
   * @return 人員配置区分モデル
   */
  protected ACListModelAdapter getMedicalFacilityHospitalHospitalDivisionModel(){
    if(medicalFacilityHospitalHospitalDivisionModel==null){
      medicalFacilityHospitalHospitalDivisionModel = new ACListModelAdapter();
      addMedicalFacilityHospitalHospitalDivisionModel();
    }
    return medicalFacilityHospitalHospitalDivisionModel;
  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getMedicalFacilityHospitalDivision1(){
    if(medicalFacilityHospitalDivision1==null){

      medicalFacilityHospitalDivision1 = new ACRadioButtonItem();

      medicalFacilityHospitalDivision1.setText("I型");

      medicalFacilityHospitalDivision1.setGroup(getMedicalFacilityHospitalHospitalDivision());

      medicalFacilityHospitalDivision1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalDivision1();
    }
    return medicalFacilityHospitalDivision1;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getMedicalFacilityHospitalDivision2(){
    if(medicalFacilityHospitalDivision2==null){

      medicalFacilityHospitalDivision2 = new ACRadioButtonItem();

      medicalFacilityHospitalDivision2.setText("II型");

      medicalFacilityHospitalDivision2.setGroup(getMedicalFacilityHospitalHospitalDivision());

      medicalFacilityHospitalDivision2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalDivision2();
    }
    return medicalFacilityHospitalDivision2;

  }

  /**
   * III型を取得します。
   * @return III型
   */
  public ACRadioButtonItem getMedicalFacilityHospitalDivision3(){
    if(medicalFacilityHospitalDivision3==null){

      medicalFacilityHospitalDivision3 = new ACRadioButtonItem();

      medicalFacilityHospitalDivision3.setText("III型");

      medicalFacilityHospitalDivision3.setGroup(getMedicalFacilityHospitalHospitalDivision());

      medicalFacilityHospitalDivision3.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalDivision3();
    }
    return medicalFacilityHospitalDivision3;

  }

  /**
   * 病室区分コンテナを取得します。
   * @return 病室区分コンテナ
   */
  public ACLabelContainer getMedicalFacilityHospitalHospitalRoomContena(){
    if(medicalFacilityHospitalHospitalRoomContena==null){

      medicalFacilityHospitalHospitalRoomContena = new ACLabelContainer();

      medicalFacilityHospitalHospitalRoomContena.setText("病室区分");

      addMedicalFacilityHospitalHospitalRoomContena();
    }
    return medicalFacilityHospitalHospitalRoomContena;

  }

  /**
   * 病室区分（病院）を取得します。
   * @return 病室区分（病院）
   */
  public ACClearableRadioButtonGroup getMedicalFacilityHospitalHospitalRoomRadio(){
    if(medicalFacilityHospitalHospitalRoomRadio==null){

      medicalFacilityHospitalHospitalRoomRadio = new ACClearableRadioButtonGroup();

      medicalFacilityHospitalHospitalRoomRadio.setBindPath("1530103");

      medicalFacilityHospitalHospitalRoomRadio.setModel(getMedicalFacilityHospitalHospitalRoomRadioModel());

      medicalFacilityHospitalHospitalRoomRadio.setUseClearButton(false);

      addMedicalFacilityHospitalHospitalRoomRadio();
    }
    return medicalFacilityHospitalHospitalRoomRadio;

  }

  /**
   * 病室区分（病院）モデルを取得します。
   * @return 病室区分（病院）モデル
   */
  protected ACListModelAdapter getMedicalFacilityHospitalHospitalRoomRadioModel(){
    if(medicalFacilityHospitalHospitalRoomRadioModel==null){
      medicalFacilityHospitalHospitalRoomRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalHospitalRoomRadioModel();
    }
    return medicalFacilityHospitalHospitalRoomRadioModel;
  }

  /**
   * 従来型個室を取得します。
   * @return 従来型個室
   */
  public ACRadioButtonItem getMedicalFacilityHospitalHospitalRoomRadioItem1(){
    if(medicalFacilityHospitalHospitalRoomRadioItem1==null){

      medicalFacilityHospitalHospitalRoomRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalHospitalRoomRadioItem1.setText("従来型個室");

      medicalFacilityHospitalHospitalRoomRadioItem1.setGroup(getMedicalFacilityHospitalHospitalRoomRadio());

      medicalFacilityHospitalHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalHospitalRoomRadioItem1();
    }
    return medicalFacilityHospitalHospitalRoomRadioItem1;

  }

  /**
   * 多床室を取得します。
   * @return 多床室
   */
  public ACRadioButtonItem getMedicalFacilityHospitalHospitalRoomRadioItem2(){
    if(medicalFacilityHospitalHospitalRoomRadioItem2==null){

      medicalFacilityHospitalHospitalRoomRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalHospitalRoomRadioItem2.setText("多床室");

      medicalFacilityHospitalHospitalRoomRadioItem2.setGroup(getMedicalFacilityHospitalHospitalRoomRadio());

      medicalFacilityHospitalHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalHospitalRoomRadioItem2();
    }
    return medicalFacilityHospitalHospitalRoomRadioItem2;

  }

  /**
   * 病室区分（ユニット型）を取得します。
   * @return 病室区分（ユニット型）
   */
  public ACClearableRadioButtonGroup getMedicalFacilityHospitalUnitHospitalRoomRadio(){
    if(medicalFacilityHospitalUnitHospitalRoomRadio==null){

      medicalFacilityHospitalUnitHospitalRoomRadio = new ACClearableRadioButtonGroup();

      medicalFacilityHospitalUnitHospitalRoomRadio.setBindPath("1530104");

      medicalFacilityHospitalUnitHospitalRoomRadio.setModel(getMedicalFacilityHospitalUnitHospitalRoomRadioModel());

      medicalFacilityHospitalUnitHospitalRoomRadio.setUseClearButton(false);

      addMedicalFacilityHospitalUnitHospitalRoomRadio();
    }
    return medicalFacilityHospitalUnitHospitalRoomRadio;

  }

  /**
   * 病室区分（ユニット型）モデルを取得します。
   * @return 病室区分（ユニット型）モデル
   */
  protected ACListModelAdapter getMedicalFacilityHospitalUnitHospitalRoomRadioModel(){
    if(medicalFacilityHospitalUnitHospitalRoomRadioModel==null){
      medicalFacilityHospitalUnitHospitalRoomRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalUnitHospitalRoomRadioModel();
    }
    return medicalFacilityHospitalUnitHospitalRoomRadioModel;
  }

  /**
   * ユニット型個室を取得します。
   * @return ユニット型個室
   */
  public ACRadioButtonItem getMedicalFacilityHospitalUnitHospitalRoomRadioItem1(){
    if(medicalFacilityHospitalUnitHospitalRoomRadioItem1==null){

      medicalFacilityHospitalUnitHospitalRoomRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalUnitHospitalRoomRadioItem1.setText("ユニット型個室");

      medicalFacilityHospitalUnitHospitalRoomRadioItem1.setGroup(getMedicalFacilityHospitalUnitHospitalRoomRadio());

      medicalFacilityHospitalUnitHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalUnitHospitalRoomRadioItem1();
    }
    return medicalFacilityHospitalUnitHospitalRoomRadioItem1;

  }

  /**
   * ユニット型準個室を取得します。
   * @return ユニット型準個室
   */
  public ACRadioButtonItem getMedicalFacilityHospitalUnitHospitalRoomRadioItem2(){
    if(medicalFacilityHospitalUnitHospitalRoomRadioItem2==null){

      medicalFacilityHospitalUnitHospitalRoomRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalUnitHospitalRoomRadioItem2.setText("ユニット型準個室");

      medicalFacilityHospitalUnitHospitalRoomRadioItem2.setGroup(getMedicalFacilityHospitalUnitHospitalRoomRadio());

      medicalFacilityHospitalUnitHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalUnitHospitalRoomRadioItem2();
    }
    return medicalFacilityHospitalUnitHospitalRoomRadioItem2;

  }

  /**
   * 夜間勤務条件基準を取得します。
   * @return 夜間勤務条件基準
   */
  public ACClearableRadioButtonGroup getMedicalFacilityHospitalNightShiftSubtractionRadio(){
    if(medicalFacilityHospitalNightShiftSubtractionRadio==null){

      medicalFacilityHospitalNightShiftSubtractionRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityHospitalNightShiftSubtractionRadioContainer().setText("夜間勤務条件基準");

      medicalFacilityHospitalNightShiftSubtractionRadio.setBindPath("1530105");

      medicalFacilityHospitalNightShiftSubtractionRadio.setModel(getMedicalFacilityHospitalNightShiftSubtractionRadioModel());

      medicalFacilityHospitalNightShiftSubtractionRadio.setUseClearButton(false);

      addMedicalFacilityHospitalNightShiftSubtractionRadio();
    }
    return medicalFacilityHospitalNightShiftSubtractionRadio;

  }

  /**
   * 夜間勤務条件基準コンテナを取得します。
   * @return 夜間勤務条件基準コンテナ
   */
  protected ACLabelContainer getMedicalFacilityHospitalNightShiftSubtractionRadioContainer(){
    if(medicalFacilityHospitalNightShiftSubtractionRadioContainer==null){
      medicalFacilityHospitalNightShiftSubtractionRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalNightShiftSubtractionRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalNightShiftSubtractionRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalNightShiftSubtractionRadioContainer.add(getMedicalFacilityHospitalNightShiftSubtractionRadio(), null);
    }
    return medicalFacilityHospitalNightShiftSubtractionRadioContainer;
  }

  /**
   * 夜間勤務条件基準モデルを取得します。
   * @return 夜間勤務条件基準モデル
   */
  protected ACListModelAdapter getMedicalFacilityHospitalNightShiftSubtractionRadioModel(){
    if(medicalFacilityHospitalNightShiftSubtractionRadioModel==null){
      medicalFacilityHospitalNightShiftSubtractionRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalNightShiftSubtractionRadioModel();
    }
    return medicalFacilityHospitalNightShiftSubtractionRadioModel;
  }

  /**
   * 基準型を取得します。
   * @return 基準型
   */
  public ACRadioButtonItem getMedicalFacilityHospitalNightShiftSubtractionRadioItem1(){
    if(medicalFacilityHospitalNightShiftSubtractionRadioItem1==null){

      medicalFacilityHospitalNightShiftSubtractionRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalNightShiftSubtractionRadioItem1.setText("基準型");

      medicalFacilityHospitalNightShiftSubtractionRadioItem1.setGroup(getMedicalFacilityHospitalNightShiftSubtractionRadio());

      medicalFacilityHospitalNightShiftSubtractionRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalNightShiftSubtractionRadioItem1();
    }
    return medicalFacilityHospitalNightShiftSubtractionRadioItem1;

  }

  /**
   * 加算型Iを取得します。
   * @return 加算型I
   */
  public ACRadioButtonItem getMedicalFacilityHospitalNightShiftSubtractionRadioItem2(){
    if(medicalFacilityHospitalNightShiftSubtractionRadioItem2==null){

      medicalFacilityHospitalNightShiftSubtractionRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalNightShiftSubtractionRadioItem2.setText("加算型I");

      medicalFacilityHospitalNightShiftSubtractionRadioItem2.setGroup(getMedicalFacilityHospitalNightShiftSubtractionRadio());

      medicalFacilityHospitalNightShiftSubtractionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityHospitalNightShiftSubtractionRadioItem2();
    }
    return medicalFacilityHospitalNightShiftSubtractionRadioItem2;

  }

  /**
   * 加算型IIを取得します。
   * @return 加算型II
   */
  public ACRadioButtonItem getMedicalFacilityHospitalNightShiftSubtractionRadioItem3(){
    if(medicalFacilityHospitalNightShiftSubtractionRadioItem3==null){

      medicalFacilityHospitalNightShiftSubtractionRadioItem3 = new ACRadioButtonItem();

      medicalFacilityHospitalNightShiftSubtractionRadioItem3.setText("加算型II");

      medicalFacilityHospitalNightShiftSubtractionRadioItem3.setGroup(getMedicalFacilityHospitalNightShiftSubtractionRadio());

      medicalFacilityHospitalNightShiftSubtractionRadioItem3.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalNightShiftSubtractionRadioItem3();
    }
    return medicalFacilityHospitalNightShiftSubtractionRadioItem3;

  }

  /**
   * 加算型IIIを取得します。
   * @return 加算型III
   */
  public ACRadioButtonItem getMedicalFacilityHospitalNightShiftSubtractionRadioItem4(){
    if(medicalFacilityHospitalNightShiftSubtractionRadioItem4==null){

      medicalFacilityHospitalNightShiftSubtractionRadioItem4 = new ACRadioButtonItem();

      medicalFacilityHospitalNightShiftSubtractionRadioItem4.setText("加算型III");

      medicalFacilityHospitalNightShiftSubtractionRadioItem4.setGroup(getMedicalFacilityHospitalNightShiftSubtractionRadio());

      medicalFacilityHospitalNightShiftSubtractionRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityHospitalNightShiftSubtractionRadioItem4();
    }
    return medicalFacilityHospitalNightShiftSubtractionRadioItem4;

  }

  /**
   * 減算型を取得します。
   * @return 減算型
   */
  public ACRadioButtonItem getMedicalFacilityHospitalNightShiftSubtractionRadioItem5(){
    if(medicalFacilityHospitalNightShiftSubtractionRadioItem5==null){

      medicalFacilityHospitalNightShiftSubtractionRadioItem5 = new ACRadioButtonItem();

      medicalFacilityHospitalNightShiftSubtractionRadioItem5.setText("減算型");

      medicalFacilityHospitalNightShiftSubtractionRadioItem5.setGroup(getMedicalFacilityHospitalNightShiftSubtractionRadio());

      medicalFacilityHospitalNightShiftSubtractionRadioItem5.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalNightShiftSubtractionRadioItem5();
    }
    return medicalFacilityHospitalNightShiftSubtractionRadioItem5;

  }

  /**
   * 療養環境基準を取得します。
   * @return 療養環境基準
   */
  public ACClearableRadioButtonGroup getMedicalFacilityHospitalEnvironmentalRadio(){
    if(medicalFacilityHospitalEnvironmentalRadio==null){

      medicalFacilityHospitalEnvironmentalRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityHospitalEnvironmentalRadioContainer().setText("療養環境基準");

      medicalFacilityHospitalEnvironmentalRadio.setBindPath("1530106");

      medicalFacilityHospitalEnvironmentalRadio.setModel(getMedicalFacilityHospitalEnvironmentalRadioModel());

      medicalFacilityHospitalEnvironmentalRadio.setUseClearButton(false);

      addMedicalFacilityHospitalEnvironmentalRadio();
    }
    return medicalFacilityHospitalEnvironmentalRadio;

  }

  /**
   * 療養環境基準コンテナを取得します。
   * @return 療養環境基準コンテナ
   */
  protected ACLabelContainer getMedicalFacilityHospitalEnvironmentalRadioContainer(){
    if(medicalFacilityHospitalEnvironmentalRadioContainer==null){
      medicalFacilityHospitalEnvironmentalRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalEnvironmentalRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalEnvironmentalRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalEnvironmentalRadioContainer.add(getMedicalFacilityHospitalEnvironmentalRadio(), null);
    }
    return medicalFacilityHospitalEnvironmentalRadioContainer;
  }

  /**
   * 療養環境基準モデルを取得します。
   * @return 療養環境基準モデル
   */
  protected ACListModelAdapter getMedicalFacilityHospitalEnvironmentalRadioModel(){
    if(medicalFacilityHospitalEnvironmentalRadioModel==null){
      medicalFacilityHospitalEnvironmentalRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalEnvironmentalRadioModel();
    }
    return medicalFacilityHospitalEnvironmentalRadioModel;
  }

  /**
   * 基準型を取得します。
   * @return 基準型
   */
  public ACRadioButtonItem getMedicalFacilityHospitalEnvironmentalRadioItem1(){
    if(medicalFacilityHospitalEnvironmentalRadioItem1==null){

      medicalFacilityHospitalEnvironmentalRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalEnvironmentalRadioItem1.setText("基準型");

      medicalFacilityHospitalEnvironmentalRadioItem1.setGroup(getMedicalFacilityHospitalEnvironmentalRadio());

      medicalFacilityHospitalEnvironmentalRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalEnvironmentalRadioItem1();
    }
    return medicalFacilityHospitalEnvironmentalRadioItem1;

  }

  /**
   * 減算Iを取得します。
   * @return 減算I
   */
  public ACRadioButtonItem getMedicalFacilityHospitalEnvironmentalRadioItem2(){
    if(medicalFacilityHospitalEnvironmentalRadioItem2==null){

      medicalFacilityHospitalEnvironmentalRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalEnvironmentalRadioItem2.setText("減算型I");

      medicalFacilityHospitalEnvironmentalRadioItem2.setGroup(getMedicalFacilityHospitalEnvironmentalRadio());

      medicalFacilityHospitalEnvironmentalRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityHospitalEnvironmentalRadioItem2();
    }
    return medicalFacilityHospitalEnvironmentalRadioItem2;

  }

  /**
   * 減算IIを取得します。
   * @return 減算II
   */
  public ACRadioButtonItem getMedicalFacilityHospitalEnvironmentalRadioItem3(){
    if(medicalFacilityHospitalEnvironmentalRadioItem3==null){

      medicalFacilityHospitalEnvironmentalRadioItem3 = new ACRadioButtonItem();

      medicalFacilityHospitalEnvironmentalRadioItem3.setText("減算型II");

      medicalFacilityHospitalEnvironmentalRadioItem3.setGroup(getMedicalFacilityHospitalEnvironmentalRadio());

      medicalFacilityHospitalEnvironmentalRadioItem3.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalEnvironmentalRadioItem3();
    }
    return medicalFacilityHospitalEnvironmentalRadioItem3;

  }

  /**
   * 減算IIIを取得します。
   * @return 減算III
   */
  public ACRadioButtonItem getMedicalFacilityHospitalEnvironmentalRadioItem4(){
    if(medicalFacilityHospitalEnvironmentalRadioItem4==null){

      medicalFacilityHospitalEnvironmentalRadioItem4 = new ACRadioButtonItem();

      medicalFacilityHospitalEnvironmentalRadioItem4.setText("減算型III");

      medicalFacilityHospitalEnvironmentalRadioItem4.setGroup(getMedicalFacilityHospitalEnvironmentalRadio());

      medicalFacilityHospitalEnvironmentalRadioItem4.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalEnvironmentalRadioItem4();
    }
    return medicalFacilityHospitalEnvironmentalRadioItem4;

  }

  /**
   * 医師の配置基準を取得します。
   * @return 医師の配置基準
   */
  public ACClearableRadioButtonGroup getMedicalFacilityHospitalDoctorArrangeStandardRadio(){
    if(medicalFacilityHospitalDoctorArrangeStandardRadio==null){

      medicalFacilityHospitalDoctorArrangeStandardRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityHospitalDoctorArrangeStandardRadioContainer().setText("医師の配置基準");

      medicalFacilityHospitalDoctorArrangeStandardRadio.setBindPath("1530107");

      medicalFacilityHospitalDoctorArrangeStandardRadio.setModel(getMedicalFacilityHospitalDoctorArrangeStandardRadioModel());

      medicalFacilityHospitalDoctorArrangeStandardRadio.setUseClearButton(false);

      addMedicalFacilityHospitalDoctorArrangeStandardRadio();
    }
    return medicalFacilityHospitalDoctorArrangeStandardRadio;

  }

  /**
   * 医師の配置基準コンテナを取得します。
   * @return 医師の配置基準コンテナ
   */
  protected ACLabelContainer getMedicalFacilityHospitalDoctorArrangeStandardRadioContainer(){
    if(medicalFacilityHospitalDoctorArrangeStandardRadioContainer==null){
      medicalFacilityHospitalDoctorArrangeStandardRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalDoctorArrangeStandardRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalDoctorArrangeStandardRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalDoctorArrangeStandardRadioContainer.add(getMedicalFacilityHospitalDoctorArrangeStandardRadio(), null);
    }
    return medicalFacilityHospitalDoctorArrangeStandardRadioContainer;
  }

  /**
   * 医師の配置基準モデルを取得します。
   * @return 医師の配置基準モデル
   */
  protected ACListModelAdapter getMedicalFacilityHospitalDoctorArrangeStandardRadioModel(){
    if(medicalFacilityHospitalDoctorArrangeStandardRadioModel==null){
      medicalFacilityHospitalDoctorArrangeStandardRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalDoctorArrangeStandardRadioModel();
    }
    return medicalFacilityHospitalDoctorArrangeStandardRadioModel;
  }

  /**
   * 基準を取得します。
   * @return 基準
   */
  public ACRadioButtonItem getMedicalFacilityHospitalDoctorArrangeStandardRadioItem1(){
    if(medicalFacilityHospitalDoctorArrangeStandardRadioItem1==null){

      medicalFacilityHospitalDoctorArrangeStandardRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalDoctorArrangeStandardRadioItem1.setText("基準");

      medicalFacilityHospitalDoctorArrangeStandardRadioItem1.setGroup(getMedicalFacilityHospitalDoctorArrangeStandardRadio());

      medicalFacilityHospitalDoctorArrangeStandardRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityHospitalDoctorArrangeStandardRadioItem1();
    }
    return medicalFacilityHospitalDoctorArrangeStandardRadioItem1;

  }

  /**
   * 医療法施行規則第49条適用を取得します。
   * @return 医療法施行規則第49条適用
   */
  public ACRadioButtonItem getMedicalFacilityHospitalDoctorArrangeStandardRadioItem2(){
    if(medicalFacilityHospitalDoctorArrangeStandardRadioItem2==null){

      medicalFacilityHospitalDoctorArrangeStandardRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalDoctorArrangeStandardRadioItem2.setText("医療法施行規則第49条適用");

      medicalFacilityHospitalDoctorArrangeStandardRadioItem2.setGroup(getMedicalFacilityHospitalDoctorArrangeStandardRadio());

      medicalFacilityHospitalDoctorArrangeStandardRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalDoctorArrangeStandardRadioItem2();
    }
    return medicalFacilityHospitalDoctorArrangeStandardRadioItem2;

  }

  /**
   * 外泊加算を取得します。
   * @return 外泊加算
   */
  public ACClearableRadioButtonGroup getMedicalFacilityHospitalStayRadio(){
    if(medicalFacilityHospitalStayRadio==null){

      medicalFacilityHospitalStayRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityHospitalStayRadioContainer().setText("外泊加算");

      medicalFacilityHospitalStayRadio.setBindPath("1530108");

      medicalFacilityHospitalStayRadio.setModel(getMedicalFacilityHospitalStayRadioModel());

      medicalFacilityHospitalStayRadio.setUseClearButton(false);

      addMedicalFacilityHospitalStayRadio();
    }
    return medicalFacilityHospitalStayRadio;

  }

  /**
   * 外泊加算コンテナを取得します。
   * @return 外泊加算コンテナ
   */
  protected ACLabelContainer getMedicalFacilityHospitalStayRadioContainer(){
    if(medicalFacilityHospitalStayRadioContainer==null){
      medicalFacilityHospitalStayRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalStayRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalStayRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalStayRadioContainer.add(getMedicalFacilityHospitalStayRadio(), null);
    }
    return medicalFacilityHospitalStayRadioContainer;
  }

  /**
   * 外泊加算モデルを取得します。
   * @return 外泊加算モデル
   */
  protected ACListModelAdapter getMedicalFacilityHospitalStayRadioModel(){
    if(medicalFacilityHospitalStayRadioModel==null){
      medicalFacilityHospitalStayRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalStayRadioModel();
    }
    return medicalFacilityHospitalStayRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalFacilityHospitalStayRadioItem1(){
    if(medicalFacilityHospitalStayRadioItem1==null){

      medicalFacilityHospitalStayRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalStayRadioItem1.setText("なし");

      medicalFacilityHospitalStayRadioItem1.setGroup(getMedicalFacilityHospitalStayRadio());

      medicalFacilityHospitalStayRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalStayRadioItem1();
    }
    return medicalFacilityHospitalStayRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalFacilityHospitalStayRadioItem2(){
    if(medicalFacilityHospitalStayRadioItem2==null){

      medicalFacilityHospitalStayRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalStayRadioItem2.setText("あり");

      medicalFacilityHospitalStayRadioItem2.setGroup(getMedicalFacilityHospitalStayRadio());

      medicalFacilityHospitalStayRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalStayRadioItem2();
    }
    return medicalFacilityHospitalStayRadioItem2;

  }

  /**
   * タブ2を取得します。
   * @return タブ2
   */
  public ACPanel getTab2(){
    if(tab2==null){

      tab2 = new ACPanel();

      tab2.setHgap(0);

      addTab2();
    }
    return tab2;

  }

  /**
   * 初期加算を取得します。
   * @return 初期加算
   */
  public ACClearableRadioButtonGroup getMedicalFacilityHospitalStandardRadio(){
    if(medicalFacilityHospitalStandardRadio==null){

      medicalFacilityHospitalStandardRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityHospitalStandardRadioContainer().setText("初期加算");

      medicalFacilityHospitalStandardRadio.setBindPath("1530109");

      medicalFacilityHospitalStandardRadio.setModel(getMedicalFacilityHospitalStandardRadioModel());

      medicalFacilityHospitalStandardRadio.setUseClearButton(false);

      addMedicalFacilityHospitalStandardRadio();
    }
    return medicalFacilityHospitalStandardRadio;

  }

  /**
   * 初期加算コンテナを取得します。
   * @return 初期加算コンテナ
   */
  protected ACLabelContainer getMedicalFacilityHospitalStandardRadioContainer(){
    if(medicalFacilityHospitalStandardRadioContainer==null){
      medicalFacilityHospitalStandardRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalStandardRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalStandardRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalStandardRadioContainer.add(getMedicalFacilityHospitalStandardRadio(), null);
    }
    return medicalFacilityHospitalStandardRadioContainer;
  }

  /**
   * 初期加算モデルを取得します。
   * @return 初期加算モデル
   */
  protected ACListModelAdapter getMedicalFacilityHospitalStandardRadioModel(){
    if(medicalFacilityHospitalStandardRadioModel==null){
      medicalFacilityHospitalStandardRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalStandardRadioModel();
    }
    return medicalFacilityHospitalStandardRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalFacilityHospitalStandardRadioItem1(){
    if(medicalFacilityHospitalStandardRadioItem1==null){

      medicalFacilityHospitalStandardRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalStandardRadioItem1.setText("なし");

      medicalFacilityHospitalStandardRadioItem1.setGroup(getMedicalFacilityHospitalStandardRadio());

      medicalFacilityHospitalStandardRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalStandardRadioItem1();
    }
    return medicalFacilityHospitalStandardRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalFacilityHospitalStandardRadioItem2(){
    if(medicalFacilityHospitalStandardRadioItem2==null){

      medicalFacilityHospitalStandardRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalStandardRadioItem2.setText("あり");

      medicalFacilityHospitalStandardRadioItem2.setGroup(getMedicalFacilityHospitalStandardRadio());

      medicalFacilityHospitalStandardRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalStandardRadioItem2();
    }
    return medicalFacilityHospitalStandardRadioItem2;

  }

  /**
   * 他科受診を取得します。
   * @return 他科受診
   */
  public ACClearableRadioButtonGroup getMedicalFacilityHospitalMedicalExaminationRadio(){
    if(medicalFacilityHospitalMedicalExaminationRadio==null){

      medicalFacilityHospitalMedicalExaminationRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityHospitalMedicalExaminationRadioContainer().setText("他科受診加算");

      medicalFacilityHospitalMedicalExaminationRadio.setBindPath("1530110");

      medicalFacilityHospitalMedicalExaminationRadio.setModel(getMedicalFacilityHospitalMedicalExaminationRadioModel());

      medicalFacilityHospitalMedicalExaminationRadio.setUseClearButton(false);

      addMedicalFacilityHospitalMedicalExaminationRadio();
    }
    return medicalFacilityHospitalMedicalExaminationRadio;

  }

  /**
   * 他科受診コンテナを取得します。
   * @return 他科受診コンテナ
   */
  protected ACLabelContainer getMedicalFacilityHospitalMedicalExaminationRadioContainer(){
    if(medicalFacilityHospitalMedicalExaminationRadioContainer==null){
      medicalFacilityHospitalMedicalExaminationRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalMedicalExaminationRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalMedicalExaminationRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalMedicalExaminationRadioContainer.add(getMedicalFacilityHospitalMedicalExaminationRadio(), null);
    }
    return medicalFacilityHospitalMedicalExaminationRadioContainer;
  }

  /**
   * 他科受診モデルを取得します。
   * @return 他科受診モデル
   */
  protected ACListModelAdapter getMedicalFacilityHospitalMedicalExaminationRadioModel(){
    if(medicalFacilityHospitalMedicalExaminationRadioModel==null){
      medicalFacilityHospitalMedicalExaminationRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalMedicalExaminationRadioModel();
    }
    return medicalFacilityHospitalMedicalExaminationRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalFacilityHospitalMedicalExaminationRadioItem1(){
    if(medicalFacilityHospitalMedicalExaminationRadioItem1==null){

      medicalFacilityHospitalMedicalExaminationRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalMedicalExaminationRadioItem1.setText("なし");

      medicalFacilityHospitalMedicalExaminationRadioItem1.setGroup(getMedicalFacilityHospitalMedicalExaminationRadio());

      medicalFacilityHospitalMedicalExaminationRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalMedicalExaminationRadioItem1();
    }
    return medicalFacilityHospitalMedicalExaminationRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalFacilityHospitalMedicalExaminationRadioItem2(){
    if(medicalFacilityHospitalMedicalExaminationRadioItem2==null){

      medicalFacilityHospitalMedicalExaminationRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalMedicalExaminationRadioItem2.setText("あり");

      medicalFacilityHospitalMedicalExaminationRadioItem2.setGroup(getMedicalFacilityHospitalMedicalExaminationRadio());

      medicalFacilityHospitalMedicalExaminationRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalMedicalExaminationRadioItem2();
    }
    return medicalFacilityHospitalMedicalExaminationRadioItem2;

  }

  /**
   * 栄養管理体制加算を取得します。
   * @return 栄養管理体制加算
   */
  public ACClearableRadioButtonGroup getMedicalFacilityHospitalNutritionManageRadio(){
    if(medicalFacilityHospitalNutritionManageRadio==null){

      medicalFacilityHospitalNutritionManageRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityHospitalNutritionManageRadioContainer().setText("栄養管理体制加算");

      medicalFacilityHospitalNutritionManageRadio.setBindPath("1530111");

      medicalFacilityHospitalNutritionManageRadio.setModel(getMedicalFacilityHospitalNutritionManageRadioModel());

      medicalFacilityHospitalNutritionManageRadio.setUseClearButton(false);

      addMedicalFacilityHospitalNutritionManageRadio();
    }
    return medicalFacilityHospitalNutritionManageRadio;

  }

  /**
   * 栄養管理体制加算コンテナを取得します。
   * @return 栄養管理体制加算コンテナ
   */
  protected ACLabelContainer getMedicalFacilityHospitalNutritionManageRadioContainer(){
    if(medicalFacilityHospitalNutritionManageRadioContainer==null){
      medicalFacilityHospitalNutritionManageRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalNutritionManageRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalNutritionManageRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalNutritionManageRadioContainer.add(getMedicalFacilityHospitalNutritionManageRadio(), null);
    }
    return medicalFacilityHospitalNutritionManageRadioContainer;
  }

  /**
   * 栄養管理体制加算モデルを取得します。
   * @return 栄養管理体制加算モデル
   */
  protected ACListModelAdapter getMedicalFacilityHospitalNutritionManageRadioModel(){
    if(medicalFacilityHospitalNutritionManageRadioModel==null){
      medicalFacilityHospitalNutritionManageRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalNutritionManageRadioModel();
    }
    return medicalFacilityHospitalNutritionManageRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalFacilityHospitalNutritionManageRadioItem1(){
    if(medicalFacilityHospitalNutritionManageRadioItem1==null){

      medicalFacilityHospitalNutritionManageRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalNutritionManageRadioItem1.setText("なし");

      medicalFacilityHospitalNutritionManageRadioItem1.setGroup(getMedicalFacilityHospitalNutritionManageRadio());

      medicalFacilityHospitalNutritionManageRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalNutritionManageRadioItem1();
    }
    return medicalFacilityHospitalNutritionManageRadioItem1;

  }

  /**
   * 管理栄養士を取得します。
   * @return 管理栄養士
   */
  public ACRadioButtonItem getMedicalFacilityHospitalNutritionManageRadioItem2(){
    if(medicalFacilityHospitalNutritionManageRadioItem2==null){

      medicalFacilityHospitalNutritionManageRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalNutritionManageRadioItem2.setText("管理栄養士");

      medicalFacilityHospitalNutritionManageRadioItem2.setGroup(getMedicalFacilityHospitalNutritionManageRadio());

      medicalFacilityHospitalNutritionManageRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityHospitalNutritionManageRadioItem2();
    }
    return medicalFacilityHospitalNutritionManageRadioItem2;

  }

  /**
   * 栄養士を取得します。
   * @return 栄養士
   */
  public ACRadioButtonItem getMedicalFacilityHospitalNutritionManageRadioItem3(){
    if(medicalFacilityHospitalNutritionManageRadioItem3==null){

      medicalFacilityHospitalNutritionManageRadioItem3 = new ACRadioButtonItem();

      medicalFacilityHospitalNutritionManageRadioItem3.setText("栄養士");

      medicalFacilityHospitalNutritionManageRadioItem3.setGroup(getMedicalFacilityHospitalNutritionManageRadio());

      medicalFacilityHospitalNutritionManageRadioItem3.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalNutritionManageRadioItem3();
    }
    return medicalFacilityHospitalNutritionManageRadioItem3;

  }

  /**
   * 栄養マネジメント加算を取得します。
   * @return 栄養マネジメント加算
   */
  public ACClearableRadioButtonGroup getMedicalFacilityHospitalNutritionRadio(){
    if(medicalFacilityHospitalNutritionRadio==null){

      medicalFacilityHospitalNutritionRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityHospitalNutritionRadioContainer().setText("栄養マネジメント加算");

      medicalFacilityHospitalNutritionRadio.setBindPath("1530112");

      medicalFacilityHospitalNutritionRadio.setModel(getMedicalFacilityHospitalNutritionRadioModel());

      medicalFacilityHospitalNutritionRadio.setUseClearButton(false);

      addMedicalFacilityHospitalNutritionRadio();
    }
    return medicalFacilityHospitalNutritionRadio;

  }

  /**
   * 栄養マネジメント加算コンテナを取得します。
   * @return 栄養マネジメント加算コンテナ
   */
  protected ACLabelContainer getMedicalFacilityHospitalNutritionRadioContainer(){
    if(medicalFacilityHospitalNutritionRadioContainer==null){
      medicalFacilityHospitalNutritionRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalNutritionRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalNutritionRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalNutritionRadioContainer.add(getMedicalFacilityHospitalNutritionRadio(), null);
    }
    return medicalFacilityHospitalNutritionRadioContainer;
  }

  /**
   * 栄養マネジメント加算モデルを取得します。
   * @return 栄養マネジメント加算モデル
   */
  protected ACListModelAdapter getMedicalFacilityHospitalNutritionRadioModel(){
    if(medicalFacilityHospitalNutritionRadioModel==null){
      medicalFacilityHospitalNutritionRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalNutritionRadioModel();
    }
    return medicalFacilityHospitalNutritionRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalFacilityHospitalNutritionRadioItem1(){
    if(medicalFacilityHospitalNutritionRadioItem1==null){

      medicalFacilityHospitalNutritionRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalNutritionRadioItem1.setText("なし");

      medicalFacilityHospitalNutritionRadioItem1.setGroup(getMedicalFacilityHospitalNutritionRadio());

      medicalFacilityHospitalNutritionRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalNutritionRadioItem1();
    }
    return medicalFacilityHospitalNutritionRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalFacilityHospitalNutritionRadioItem2(){
    if(medicalFacilityHospitalNutritionRadioItem2==null){

      medicalFacilityHospitalNutritionRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalNutritionRadioItem2.setText("あり");

      medicalFacilityHospitalNutritionRadioItem2.setGroup(getMedicalFacilityHospitalNutritionRadio());

      medicalFacilityHospitalNutritionRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalNutritionRadioItem2();
    }
    return medicalFacilityHospitalNutritionRadioItem2;

  }

  /**
   * 経口移行加算を取得します。
   * @return 経口移行加算
   */
  public ACClearableRadioButtonGroup getMedicalFacilityHospitalOralSwitchRadio(){
    if(medicalFacilityHospitalOralSwitchRadio==null){

      medicalFacilityHospitalOralSwitchRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityHospitalOralSwitchRadioContainer().setText("経口移行加算");

      medicalFacilityHospitalOralSwitchRadio.setBindPath("1530113");

      medicalFacilityHospitalOralSwitchRadio.setModel(getMedicalFacilityHospitalOralSwitchRadioModel());

      medicalFacilityHospitalOralSwitchRadio.setUseClearButton(false);

      addMedicalFacilityHospitalOralSwitchRadio();
    }
    return medicalFacilityHospitalOralSwitchRadio;

  }

  /**
   * 経口移行加算コンテナを取得します。
   * @return 経口移行加算コンテナ
   */
  protected ACLabelContainer getMedicalFacilityHospitalOralSwitchRadioContainer(){
    if(medicalFacilityHospitalOralSwitchRadioContainer==null){
      medicalFacilityHospitalOralSwitchRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalOralSwitchRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalOralSwitchRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalOralSwitchRadioContainer.add(getMedicalFacilityHospitalOralSwitchRadio(), null);
    }
    return medicalFacilityHospitalOralSwitchRadioContainer;
  }

  /**
   * 経口移行加算モデルを取得します。
   * @return 経口移行加算モデル
   */
  protected ACListModelAdapter getMedicalFacilityHospitalOralSwitchRadioModel(){
    if(medicalFacilityHospitalOralSwitchRadioModel==null){
      medicalFacilityHospitalOralSwitchRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalOralSwitchRadioModel();
    }
    return medicalFacilityHospitalOralSwitchRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalFacilityHospitalOralSwitchRadioItem1(){
    if(medicalFacilityHospitalOralSwitchRadioItem1==null){

      medicalFacilityHospitalOralSwitchRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalOralSwitchRadioItem1.setText("なし");

      medicalFacilityHospitalOralSwitchRadioItem1.setGroup(getMedicalFacilityHospitalOralSwitchRadio());

      medicalFacilityHospitalOralSwitchRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalOralSwitchRadioItem1();
    }
    return medicalFacilityHospitalOralSwitchRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalFacilityHospitalOralSwitchRadioItem2(){
    if(medicalFacilityHospitalOralSwitchRadioItem2==null){

      medicalFacilityHospitalOralSwitchRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalOralSwitchRadioItem2.setText("あり");

      medicalFacilityHospitalOralSwitchRadioItem2.setGroup(getMedicalFacilityHospitalOralSwitchRadio());

      medicalFacilityHospitalOralSwitchRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalOralSwitchRadioItem2();
    }
    return medicalFacilityHospitalOralSwitchRadioItem2;

  }

  /**
   * 経口維持加算を取得します。
   * @return 経口維持加算
   */
  public ACClearableRadioButtonGroup getOralMaintenanceRadio(){
    if(oralMaintenanceRadio==null){

      oralMaintenanceRadio = new ACClearableRadioButtonGroup();

      getOralMaintenanceRadioContainer().setText("経口維持加算");

      oralMaintenanceRadio.setBindPath("1530115");

      oralMaintenanceRadio.setModel(getOralMaintenanceRadioModel());

      oralMaintenanceRadio.setUseClearButton(false);

      addOralMaintenanceRadio();
    }
    return oralMaintenanceRadio;

  }

  /**
   * 経口維持加算コンテナを取得します。
   * @return 経口維持加算コンテナ
   */
  protected ACLabelContainer getOralMaintenanceRadioContainer(){
    if(oralMaintenanceRadioContainer==null){
      oralMaintenanceRadioContainer = new ACLabelContainer();
      oralMaintenanceRadioContainer.setFollowChildEnabled(true);
      oralMaintenanceRadioContainer.setVAlignment(VRLayout.CENTER);
      oralMaintenanceRadioContainer.add(getOralMaintenanceRadio(), null);
    }
    return oralMaintenanceRadioContainer;
  }

  /**
   * 経口維持加算モデルを取得します。
   * @return 経口維持加算モデル
   */
  protected ACListModelAdapter getOralMaintenanceRadioModel(){
    if(oralMaintenanceRadioModel==null){
      oralMaintenanceRadioModel = new ACListModelAdapter();
      addOralMaintenanceRadioModel();
    }
    return oralMaintenanceRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getOralMaintenanceRadioItem1(){
    if(oralMaintenanceRadioItem1==null){

      oralMaintenanceRadioItem1 = new ACRadioButtonItem();

      oralMaintenanceRadioItem1.setText("なし");

      oralMaintenanceRadioItem1.setGroup(getOralMaintenanceRadio());

      oralMaintenanceRadioItem1.setConstraints(VRLayout.FLOW);

      addOralMaintenanceRadioItem1();
    }
    return oralMaintenanceRadioItem1;

  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getOralMaintenanceRadioItem2(){
    if(oralMaintenanceRadioItem2==null){

      oralMaintenanceRadioItem2 = new ACRadioButtonItem();

      oralMaintenanceRadioItem2.setText("I型");

      oralMaintenanceRadioItem2.setGroup(getOralMaintenanceRadio());

      oralMaintenanceRadioItem2.setConstraints(VRLayout.FLOW);

      addOralMaintenanceRadioItem2();
    }
    return oralMaintenanceRadioItem2;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getOralMaintenanceRadioItem3(){
    if(oralMaintenanceRadioItem3==null){

      oralMaintenanceRadioItem3 = new ACRadioButtonItem();

      oralMaintenanceRadioItem3.setText("II型");

      oralMaintenanceRadioItem3.setGroup(getOralMaintenanceRadio());

      oralMaintenanceRadioItem3.setConstraints(VRLayout.FLOW);

      addOralMaintenanceRadioItem3();
    }
    return oralMaintenanceRadioItem3;

  }

  /**
   * 療養食加算を取得します。
   * @return 療養食加算
   */
  public ACClearableRadioButtonGroup getMedicalFacilityHospitalRecuperateDinnerRadio(){
    if(medicalFacilityHospitalRecuperateDinnerRadio==null){

      medicalFacilityHospitalRecuperateDinnerRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityHospitalRecuperateDinnerRadioContainer().setText("療養食加算");

      medicalFacilityHospitalRecuperateDinnerRadio.setBindPath("1530114");

      medicalFacilityHospitalRecuperateDinnerRadio.setModel(getMedicalFacilityHospitalRecuperateDinnerRadioModel());

      medicalFacilityHospitalRecuperateDinnerRadio.setUseClearButton(false);

      addMedicalFacilityHospitalRecuperateDinnerRadio();
    }
    return medicalFacilityHospitalRecuperateDinnerRadio;

  }

  /**
   * 療養食加算コンテナを取得します。
   * @return 療養食加算コンテナ
   */
  protected ACLabelContainer getMedicalFacilityHospitalRecuperateDinnerRadioContainer(){
    if(medicalFacilityHospitalRecuperateDinnerRadioContainer==null){
      medicalFacilityHospitalRecuperateDinnerRadioContainer = new ACLabelContainer();
      medicalFacilityHospitalRecuperateDinnerRadioContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalRecuperateDinnerRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalRecuperateDinnerRadioContainer.add(getMedicalFacilityHospitalRecuperateDinnerRadio(), null);
    }
    return medicalFacilityHospitalRecuperateDinnerRadioContainer;
  }

  /**
   * 療養食加算モデルを取得します。
   * @return 療養食加算モデル
   */
  protected ACListModelAdapter getMedicalFacilityHospitalRecuperateDinnerRadioModel(){
    if(medicalFacilityHospitalRecuperateDinnerRadioModel==null){
      medicalFacilityHospitalRecuperateDinnerRadioModel = new ACListModelAdapter();
      addMedicalFacilityHospitalRecuperateDinnerRadioModel();
    }
    return medicalFacilityHospitalRecuperateDinnerRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalFacilityHospitalRecuperateDinnerRadioItem1(){
    if(medicalFacilityHospitalRecuperateDinnerRadioItem1==null){

      medicalFacilityHospitalRecuperateDinnerRadioItem1 = new ACRadioButtonItem();

      medicalFacilityHospitalRecuperateDinnerRadioItem1.setText("なし");

      medicalFacilityHospitalRecuperateDinnerRadioItem1.setGroup(getMedicalFacilityHospitalRecuperateDinnerRadio());

      medicalFacilityHospitalRecuperateDinnerRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalRecuperateDinnerRadioItem1();
    }
    return medicalFacilityHospitalRecuperateDinnerRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalFacilityHospitalRecuperateDinnerRadioItem2(){
    if(medicalFacilityHospitalRecuperateDinnerRadioItem2==null){

      medicalFacilityHospitalRecuperateDinnerRadioItem2 = new ACRadioButtonItem();

      medicalFacilityHospitalRecuperateDinnerRadioItem2.setText("あり");

      medicalFacilityHospitalRecuperateDinnerRadioItem2.setGroup(getMedicalFacilityHospitalRecuperateDinnerRadio());

      medicalFacilityHospitalRecuperateDinnerRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityHospitalRecuperateDinnerRadioItem2();
    }
    return medicalFacilityHospitalRecuperateDinnerRadioItem2;

  }

  /**
   * 退所関連加算を取得します。
   * @return 退所関連加算
   */
  public ACLabelContainer getMedicalFacilityHospitalHijoAddition(){
    if(medicalFacilityHospitalHijoAddition==null){

      medicalFacilityHospitalHijoAddition = new ACLabelContainer();

      medicalFacilityHospitalHijoAddition.setText("退院関連加算");

      addMedicalFacilityHospitalHijoAddition();
    }
    return medicalFacilityHospitalHijoAddition;

  }

  /**
   * 退所(院)前後訪問指導加算を取得します。
   * @return 退所(院)前後訪問指導加算
   */
  public ACIntegerCheckBox getLeavingHospitalPreConsultationAddition(){
    if(leavingHospitalPreConsultationAddition==null){

      leavingHospitalPreConsultationAddition = new ACIntegerCheckBox();

      leavingHospitalPreConsultationAddition.setText("退院前後訪問指導加算");

      leavingHospitalPreConsultationAddition.setBindPath("3020104");

      leavingHospitalPreConsultationAddition.setSelectValue(2);

      leavingHospitalPreConsultationAddition.setUnSelectValue(1);

      addLeavingHospitalPreConsultationAddition();
    }
    return leavingHospitalPreConsultationAddition;

  }

  /**
   * 退所(院)時指導加算を取得します。
   * @return 退所(院)時指導加算
   */
  public ACIntegerCheckBox getLeavingHospitalConsultationAddition(){
    if(leavingHospitalConsultationAddition==null){

      leavingHospitalConsultationAddition = new ACIntegerCheckBox();

      leavingHospitalConsultationAddition.setText("退院時指導加算");

      leavingHospitalConsultationAddition.setBindPath("3020105");

      leavingHospitalConsultationAddition.setSelectValue(2);

      leavingHospitalConsultationAddition.setUnSelectValue(1);

      addLeavingHospitalConsultationAddition();
    }
    return leavingHospitalConsultationAddition;

  }

  /**
   * 退所(院)時情報提供加算を取得します。
   * @return 退所(院)時情報提供加算
   */
  public ACIntegerCheckBox getLeavingHospitalDissemination(){
    if(leavingHospitalDissemination==null){

      leavingHospitalDissemination = new ACIntegerCheckBox();

      leavingHospitalDissemination.setText("退院時情報提供加算");

      leavingHospitalDissemination.setBindPath("3020106");

      leavingHospitalDissemination.setSelectValue(2);

      leavingHospitalDissemination.setUnSelectValue(1);

      addLeavingHospitalDissemination();
    }
    return leavingHospitalDissemination;

  }

  /**
   * 退所(院)前連携加算を取得します。
   * @return 退所(院)前連携加算
   */
  public ACIntegerCheckBox getLeavingHospitalCooperationAddition(){
    if(leavingHospitalCooperationAddition==null){

      leavingHospitalCooperationAddition = new ACIntegerCheckBox();

      leavingHospitalCooperationAddition.setText("退院前連携加算");

      leavingHospitalCooperationAddition.setBindPath("3020107");

      leavingHospitalCooperationAddition.setSelectValue(2);

      leavingHospitalCooperationAddition.setUnSelectValue(1);

      addLeavingHospitalCooperationAddition();
    }
    return leavingHospitalCooperationAddition;

  }

  /**
   * 老人訪問看護指示加算を取得します。
   * @return 老人訪問看護指示加算
   */
  public ACIntegerCheckBox getLeavingHospital(){
    if(leavingHospital==null){

      leavingHospital = new ACIntegerCheckBox();

      leavingHospital.setText("老人訪問看護指示加算");

      leavingHospital.setBindPath("3020108");

      leavingHospital.setSelectValue(2);

      leavingHospital.setUnSelectValue(1);

      addLeavingHospital();
    }
    return leavingHospital;

  }

  /**
   * タブ3を取得します。
   * @return タブ3
   */
  public ACPanel getTab3(){
    if(tab3==null){

      tab3 = new ACPanel();

      tab3.setHgap(0);

      addTab3();
    }
    return tab3;

  }

  /**
   * 特定診療費を取得します。
   * @return 特定診療費
   */
  public ACMapBindButton getMedicalFacilityHospitalConsultationFee(){
    if(medicalFacilityHospitalConsultationFee==null){

      medicalFacilityHospitalConsultationFee = new ACMapBindButton();

      medicalFacilityHospitalConsultationFee.setText("特定診療費");

      medicalFacilityHospitalConsultationFee.setToolTipText("特定診療費を設定します。");

      addMedicalFacilityHospitalConsultationFee();
    }
    return medicalFacilityHospitalConsultationFee;

  }

  /**
   * ラベルを取得します。
   * @return ラベル
   */
  public ACLabel getMedicalFacilityHospitalConsultationFeeLabel(){
    if(medicalFacilityHospitalConsultationFeeLabel==null){

      medicalFacilityHospitalConsultationFeeLabel = new ACLabel();

      medicalFacilityHospitalConsultationFeeLabel.setText("設定なし");

      medicalFacilityHospitalConsultationFeeLabel.setOpaque(true);
      medicalFacilityHospitalConsultationFeeLabel.setBackground(new Color(255,255,172));

      addMedicalFacilityHospitalConsultationFeeLabel();
    }
    return medicalFacilityHospitalConsultationFeeLabel;

  }

  /**
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACComboBox getMedicalFacilityHospitalSubstraction(){
    if(medicalFacilityHospitalSubstraction==null){

      medicalFacilityHospitalSubstraction = new ACComboBox();

      getMedicalFacilityHospitalSubstractionContainer().setText("人員減算");

      medicalFacilityHospitalSubstraction.setBindPath("1530158");

      medicalFacilityHospitalSubstraction.setEditable(false);

      medicalFacilityHospitalSubstraction.setModelBindPath("1530158");

      medicalFacilityHospitalSubstraction.setModel(getMedicalFacilityHospitalSubstractionModel());

      medicalFacilityHospitalSubstraction.setRenderBindPath("CONTENT");

      addMedicalFacilityHospitalSubstraction();
    }
    return medicalFacilityHospitalSubstraction;

  }

  /**
   * 人員減算コンテナを取得します。
   * @return 人員減算コンテナ
   */
  protected ACLabelContainer getMedicalFacilityHospitalSubstractionContainer(){
    if(medicalFacilityHospitalSubstractionContainer==null){
      medicalFacilityHospitalSubstractionContainer = new ACLabelContainer();
      medicalFacilityHospitalSubstractionContainer.setFollowChildEnabled(true);
      medicalFacilityHospitalSubstractionContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityHospitalSubstractionContainer.add(getMedicalFacilityHospitalSubstraction(), null);
    }
    return medicalFacilityHospitalSubstractionContainer;
  }

  /**
   * 人員減算モデルを取得します。
   * @return 人員減算モデル
   */
  protected ACComboBoxModelAdapter getMedicalFacilityHospitalSubstractionModel(){
    if(medicalFacilityHospitalSubstractionModel==null){
      medicalFacilityHospitalSubstractionModel = new ACComboBoxModelAdapter();
      addMedicalFacilityHospitalSubstractionModel();
    }
    return medicalFacilityHospitalSubstractionModel;
  }

  /**
   * 食事コンテナを取得します。
   * @return 食事コンテナ
   */
  public ACBackLabelContainer getMedicalFacilityDinnerContainer(){
    if(medicalFacilityDinnerContainer==null){

      medicalFacilityDinnerContainer = new ACBackLabelContainer();

      addMedicalFacilityDinnerContainer();
    }
    return medicalFacilityDinnerContainer;

  }

  /**
   * 食事提供を取得します。
   * @return 食事提供
   */
  public ACComboBox getMedicalFacilityDinnerOffer(){
    if(medicalFacilityDinnerOffer==null){

      medicalFacilityDinnerOffer = new ACComboBox();

      getMedicalFacilityDinnerOfferContainer().setText("食事提供");

      medicalFacilityDinnerOffer.setBindPath("1530159");

      medicalFacilityDinnerOffer.setEditable(false);

      medicalFacilityDinnerOffer.setModelBindPath("1530159");

      medicalFacilityDinnerOffer.setModel(getMedicalFacilityDinnerOfferModel());

      medicalFacilityDinnerOffer.setRenderBindPath("CONTENT");

      addMedicalFacilityDinnerOffer();
    }
    return medicalFacilityDinnerOffer;

  }

  /**
   * 食事提供コンテナを取得します。
   * @return 食事提供コンテナ
   */
  protected ACLabelContainer getMedicalFacilityDinnerOfferContainer(){
    if(medicalFacilityDinnerOfferContainer==null){
      medicalFacilityDinnerOfferContainer = new ACLabelContainer();
      medicalFacilityDinnerOfferContainer.setFollowChildEnabled(true);
      medicalFacilityDinnerOfferContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityDinnerOfferContainer.add(getMedicalFacilityDinnerOffer(), null);
    }
    return medicalFacilityDinnerOfferContainer;
  }

  /**
   * 食事提供モデルを取得します。
   * @return 食事提供モデル
   */
  protected ACComboBoxModelAdapter getMedicalFacilityDinnerOfferModel(){
    if(medicalFacilityDinnerOfferModel==null){
      medicalFacilityDinnerOfferModel = new ACComboBoxModelAdapter();
      addMedicalFacilityDinnerOfferModel();
    }
    return medicalFacilityDinnerOfferModel;
  }

  /**
   * 食事費用を取得します。
   * @return 食事費用
   */
  public ACTextField getMedicalFacilityDinnerCost(){
    if(medicalFacilityDinnerCost==null){

      medicalFacilityDinnerCost = new ACTextField();

      getMedicalFacilityDinnerCostContainer().setText("食事費用");

      medicalFacilityDinnerCost.setBindPath("1530161");

      medicalFacilityDinnerCost.setColumns(4);

      medicalFacilityDinnerCost.setCharType(VRCharType.ONLY_DIGIT);

      medicalFacilityDinnerCost.setHorizontalAlignment(SwingConstants.RIGHT);

      medicalFacilityDinnerCost.setIMEMode(InputSubset.LATIN);

      medicalFacilityDinnerCost.setMaxLength(5);

      addMedicalFacilityDinnerCost();
    }
    return medicalFacilityDinnerCost;

  }

  /**
   * 食事費用コンテナを取得します。
   * @return 食事費用コンテナ
   */
  protected ACLabelContainer getMedicalFacilityDinnerCostContainer(){
    if(medicalFacilityDinnerCostContainer==null){
      medicalFacilityDinnerCostContainer = new ACLabelContainer();
      medicalFacilityDinnerCostContainer.setFollowChildEnabled(true);
      medicalFacilityDinnerCostContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityDinnerCostContainer.add(getMedicalFacilityDinnerCost(), null);
    }
    return medicalFacilityDinnerCostContainer;
  }

  /**
   * ユニットケアの整備を取得します。
   * @return ユニットケアの整備
   */
  public ACClearableRadioButtonGroup getUnitCareMaintenanceRadio(){
    if(unitCareMaintenanceRadio==null){

      unitCareMaintenanceRadio = new ACClearableRadioButtonGroup();

      getUnitCareMaintenanceRadioContainer().setText("ユニットケアの整備");

      unitCareMaintenanceRadio.setBindPath("1530116");

      unitCareMaintenanceRadio.setModel(getUnitCareMaintenanceRadioModel());

      unitCareMaintenanceRadio.setUseClearButton(false);

      addUnitCareMaintenanceRadio();
    }
    return unitCareMaintenanceRadio;

  }

  /**
   * ユニットケアの整備コンテナを取得します。
   * @return ユニットケアの整備コンテナ
   */
  protected ACLabelContainer getUnitCareMaintenanceRadioContainer(){
    if(unitCareMaintenanceRadioContainer==null){
      unitCareMaintenanceRadioContainer = new ACLabelContainer();
      unitCareMaintenanceRadioContainer.setFollowChildEnabled(true);
      unitCareMaintenanceRadioContainer.setVAlignment(VRLayout.CENTER);
      unitCareMaintenanceRadioContainer.add(getUnitCareMaintenanceRadio(), null);
    }
    return unitCareMaintenanceRadioContainer;
  }

  /**
   * ユニットケアの整備モデルを取得します。
   * @return ユニットケアの整備モデル
   */
  protected ACListModelAdapter getUnitCareMaintenanceRadioModel(){
    if(unitCareMaintenanceRadioModel==null){
      unitCareMaintenanceRadioModel = new ACListModelAdapter();
      addUnitCareMaintenanceRadioModel();
    }
    return unitCareMaintenanceRadioModel;
  }

  /**
   * 未整備を取得します。
   * @return 未整備
   */
  public ACRadioButtonItem getUnitCareMaintenanceRadioItem1(){
    if(unitCareMaintenanceRadioItem1==null){

      unitCareMaintenanceRadioItem1 = new ACRadioButtonItem();

      unitCareMaintenanceRadioItem1.setText("未整備");

      unitCareMaintenanceRadioItem1.setGroup(getUnitCareMaintenanceRadio());

      unitCareMaintenanceRadioItem1.setConstraints(VRLayout.FLOW);

      addUnitCareMaintenanceRadioItem1();
    }
    return unitCareMaintenanceRadioItem1;

  }

  /**
   * 整備を取得します。
   * @return 整備
   */
  public ACRadioButtonItem getUnitCareMaintenanceRadioItem2(){
    if(unitCareMaintenanceRadioItem2==null){

      unitCareMaintenanceRadioItem2 = new ACRadioButtonItem();

      unitCareMaintenanceRadioItem2.setText("整備");

      unitCareMaintenanceRadioItem2.setGroup(getUnitCareMaintenanceRadio());

      unitCareMaintenanceRadioItem2.setConstraints(VRLayout.FLOW);

      addUnitCareMaintenanceRadioItem2();
    }
    return unitCareMaintenanceRadioItem2;

  }

  /**
   * 身体拘束廃止未実施減算を取得します。
   * @return 身体拘束廃止未実施減算
   */
  public ACClearableRadioButtonGroup getBodyRestraintAbolitionRadio(){
    if(bodyRestraintAbolitionRadio==null){

      bodyRestraintAbolitionRadio = new ACClearableRadioButtonGroup();

      getBodyRestraintAbolitionRadioContainer().setText("身体拘束廃止未実施減算");

      bodyRestraintAbolitionRadio.setBindPath("1530117");

      bodyRestraintAbolitionRadio.setModel(getBodyRestraintAbolitionRadioModel());

      bodyRestraintAbolitionRadio.setUseClearButton(false);

      addBodyRestraintAbolitionRadio();
    }
    return bodyRestraintAbolitionRadio;

  }

  /**
   * 身体拘束廃止未実施減算コンテナを取得します。
   * @return 身体拘束廃止未実施減算コンテナ
   */
  protected ACLabelContainer getBodyRestraintAbolitionRadioContainer(){
    if(bodyRestraintAbolitionRadioContainer==null){
      bodyRestraintAbolitionRadioContainer = new ACLabelContainer();
      bodyRestraintAbolitionRadioContainer.setFollowChildEnabled(true);
      bodyRestraintAbolitionRadioContainer.setVAlignment(VRLayout.CENTER);
      bodyRestraintAbolitionRadioContainer.add(getBodyRestraintAbolitionRadio(), null);
    }
    return bodyRestraintAbolitionRadioContainer;
  }

  /**
   * 身体拘束廃止未実施減算モデルを取得します。
   * @return 身体拘束廃止未実施減算モデル
   */
  protected ACListModelAdapter getBodyRestraintAbolitionRadioModel(){
    if(bodyRestraintAbolitionRadioModel==null){
      bodyRestraintAbolitionRadioModel = new ACListModelAdapter();
      addBodyRestraintAbolitionRadioModel();
    }
    return bodyRestraintAbolitionRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getBodyRestraintAbolitionRadioItem1(){
    if(bodyRestraintAbolitionRadioItem1==null){

      bodyRestraintAbolitionRadioItem1 = new ACRadioButtonItem();

      bodyRestraintAbolitionRadioItem1.setText("なし");

      bodyRestraintAbolitionRadioItem1.setGroup(getBodyRestraintAbolitionRadio());

      bodyRestraintAbolitionRadioItem1.setConstraints(VRLayout.FLOW);

      addBodyRestraintAbolitionRadioItem1();
    }
    return bodyRestraintAbolitionRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getBodyRestraintAbolitionRadioItem2(){
    if(bodyRestraintAbolitionRadioItem2==null){

      bodyRestraintAbolitionRadioItem2 = new ACRadioButtonItem();

      bodyRestraintAbolitionRadioItem2.setText("あり");

      bodyRestraintAbolitionRadioItem2.setGroup(getBodyRestraintAbolitionRadio());

      bodyRestraintAbolitionRadioItem2.setConstraints(VRLayout.FLOW);

      addBodyRestraintAbolitionRadioItem2();
    }
    return bodyRestraintAbolitionRadioItem2;

  }

  /**
   * 在宅復帰支援機能加算を取得します。
   * @return 在宅復帰支援機能加算
   */
  public ACClearableRadioButtonGroup getStayReturnSupportAddRadio(){
    if(stayReturnSupportAddRadio==null){

      stayReturnSupportAddRadio = new ACClearableRadioButtonGroup();

      getStayReturnSupportAddRadioContainer().setText("在宅復帰支援機能加算");

      stayReturnSupportAddRadio.setBindPath("1530118");

      stayReturnSupportAddRadio.setModel(getStayReturnSupportAddRadioModel());

      stayReturnSupportAddRadio.setUseClearButton(false);

      addStayReturnSupportAddRadio();
    }
    return stayReturnSupportAddRadio;

  }

  /**
   * 在宅復帰支援機能加算コンテナを取得します。
   * @return 在宅復帰支援機能加算コンテナ
   */
  protected ACLabelContainer getStayReturnSupportAddRadioContainer(){
    if(stayReturnSupportAddRadioContainer==null){
      stayReturnSupportAddRadioContainer = new ACLabelContainer();
      stayReturnSupportAddRadioContainer.setFollowChildEnabled(true);
      stayReturnSupportAddRadioContainer.setVAlignment(VRLayout.CENTER);
      stayReturnSupportAddRadioContainer.add(getStayReturnSupportAddRadio(), null);
    }
    return stayReturnSupportAddRadioContainer;
  }

  /**
   * 在宅復帰支援機能加算モデルを取得します。
   * @return 在宅復帰支援機能加算モデル
   */
  protected ACListModelAdapter getStayReturnSupportAddRadioModel(){
    if(stayReturnSupportAddRadioModel==null){
      stayReturnSupportAddRadioModel = new ACListModelAdapter();
      addStayReturnSupportAddRadioModel();
    }
    return stayReturnSupportAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getStayReturnSupportAddRadioItem1(){
    if(stayReturnSupportAddRadioItem1==null){

      stayReturnSupportAddRadioItem1 = new ACRadioButtonItem();

      stayReturnSupportAddRadioItem1.setText("なし");

      stayReturnSupportAddRadioItem1.setGroup(getStayReturnSupportAddRadio());

      stayReturnSupportAddRadioItem1.setConstraints(VRLayout.FLOW);

      addStayReturnSupportAddRadioItem1();
    }
    return stayReturnSupportAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getStayReturnSupportAddRadioItem2(){
    if(stayReturnSupportAddRadioItem2==null){

      stayReturnSupportAddRadioItem2 = new ACRadioButtonItem();

      stayReturnSupportAddRadioItem2.setText("あり");

      stayReturnSupportAddRadioItem2.setGroup(getStayReturnSupportAddRadio());

      stayReturnSupportAddRadioItem2.setConstraints(VRLayout.FLOW);

      addStayReturnSupportAddRadioItem2();
    }
    return stayReturnSupportAddRadioItem2;

  }

  /**
   * コンストラクタです。
   */
  public QS001120Design() {

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

    this.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * タブペインに内部項目を追加します。
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

    tab1.add(getMedicalFacilityHospitalInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityHospitalHospitalDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityHospitalHospitalRoomContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityHospitalNightShiftSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityHospitalEnvironmentalRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityHospitalDoctorArrangeStandardRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityHospitalStayRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 施設等の区分に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalInstitutionDivisionRadio(){

  }

  /**
   * 施設等の区分モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalInstitutionDivisionRadioModel(){

    getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem1().setButtonIndex(1);
    getMedicalFacilityHospitalInstitutionDivisionRadioModel().add(getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem1());

    getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem2().setButtonIndex(2);
    getMedicalFacilityHospitalInstitutionDivisionRadioModel().add(getMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem2());

  }

  /**
   * 病院に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem1(){

  }

  /**
   * ユニット型病院に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalHospitalInstitutionDivisionRadioItem2(){

  }

  /**
   * 人員配置区分に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalHospitalDivision(){

  }

  /**
   * 人員配置区分モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalHospitalDivisionModel(){

    getMedicalFacilityHospitalDivision1().setButtonIndex(1);
    getMedicalFacilityHospitalHospitalDivisionModel().add(getMedicalFacilityHospitalDivision1());

    getMedicalFacilityHospitalDivision2().setButtonIndex(2);
    getMedicalFacilityHospitalHospitalDivisionModel().add(getMedicalFacilityHospitalDivision2());

    getMedicalFacilityHospitalDivision3().setButtonIndex(3);
    getMedicalFacilityHospitalHospitalDivisionModel().add(getMedicalFacilityHospitalDivision3());

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalDivision1(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalDivision2(){

  }

  /**
   * III型に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalDivision3(){

  }

  /**
   * 病室区分コンテナに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalHospitalRoomContena(){

    medicalFacilityHospitalHospitalRoomContena.add(getMedicalFacilityHospitalHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalFacilityHospitalHospitalRoomContena.add(getMedicalFacilityHospitalUnitHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 病室区分（病院）に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalHospitalRoomRadio(){

  }

  /**
   * 病室区分（病院）モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalHospitalRoomRadioModel(){

    getMedicalFacilityHospitalHospitalRoomRadioItem1().setButtonIndex(1);
    getMedicalFacilityHospitalHospitalRoomRadioModel().add(getMedicalFacilityHospitalHospitalRoomRadioItem1());

    getMedicalFacilityHospitalHospitalRoomRadioItem2().setButtonIndex(2);
    getMedicalFacilityHospitalHospitalRoomRadioModel().add(getMedicalFacilityHospitalHospitalRoomRadioItem2());

  }

  /**
   * 従来型個室に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalHospitalRoomRadioItem1(){

  }

  /**
   * 多床室に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalHospitalRoomRadioItem2(){

  }

  /**
   * 病室区分（ユニット型）に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalUnitHospitalRoomRadio(){

  }

  /**
   * 病室区分（ユニット型）モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalUnitHospitalRoomRadioModel(){

    getMedicalFacilityHospitalUnitHospitalRoomRadioItem1().setButtonIndex(1);
    getMedicalFacilityHospitalUnitHospitalRoomRadioModel().add(getMedicalFacilityHospitalUnitHospitalRoomRadioItem1());

    getMedicalFacilityHospitalUnitHospitalRoomRadioItem2().setButtonIndex(2);
    getMedicalFacilityHospitalUnitHospitalRoomRadioModel().add(getMedicalFacilityHospitalUnitHospitalRoomRadioItem2());

  }

  /**
   * ユニット型個室に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalUnitHospitalRoomRadioItem1(){

  }

  /**
   * ユニット型準個室に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalUnitHospitalRoomRadioItem2(){

  }

  /**
   * 夜間勤務条件基準に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalNightShiftSubtractionRadio(){

  }

  /**
   * 夜間勤務条件基準モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalNightShiftSubtractionRadioModel(){

    getMedicalFacilityHospitalNightShiftSubtractionRadioItem1().setButtonIndex(1);
    getMedicalFacilityHospitalNightShiftSubtractionRadioModel().add(getMedicalFacilityHospitalNightShiftSubtractionRadioItem1());

    getMedicalFacilityHospitalNightShiftSubtractionRadioItem2().setButtonIndex(2);
    getMedicalFacilityHospitalNightShiftSubtractionRadioModel().add(getMedicalFacilityHospitalNightShiftSubtractionRadioItem2());

    getMedicalFacilityHospitalNightShiftSubtractionRadioItem3().setButtonIndex(3);
    getMedicalFacilityHospitalNightShiftSubtractionRadioModel().add(getMedicalFacilityHospitalNightShiftSubtractionRadioItem3());

    getMedicalFacilityHospitalNightShiftSubtractionRadioItem4().setButtonIndex(4);
    getMedicalFacilityHospitalNightShiftSubtractionRadioModel().add(getMedicalFacilityHospitalNightShiftSubtractionRadioItem4());

    getMedicalFacilityHospitalNightShiftSubtractionRadioItem5().setButtonIndex(5);
    getMedicalFacilityHospitalNightShiftSubtractionRadioModel().add(getMedicalFacilityHospitalNightShiftSubtractionRadioItem5());

  }

  /**
   * 基準型に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalNightShiftSubtractionRadioItem1(){

  }

  /**
   * 加算型Iに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalNightShiftSubtractionRadioItem2(){

  }

  /**
   * 加算型IIに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalNightShiftSubtractionRadioItem3(){

  }

  /**
   * 加算型IIIに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalNightShiftSubtractionRadioItem4(){

  }

  /**
   * 減算型に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalNightShiftSubtractionRadioItem5(){

  }

  /**
   * 療養環境基準に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalEnvironmentalRadio(){

  }

  /**
   * 療養環境基準モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalEnvironmentalRadioModel(){

    getMedicalFacilityHospitalEnvironmentalRadioItem1().setButtonIndex(1);
    getMedicalFacilityHospitalEnvironmentalRadioModel().add(getMedicalFacilityHospitalEnvironmentalRadioItem1());

    getMedicalFacilityHospitalEnvironmentalRadioItem2().setButtonIndex(2);
    getMedicalFacilityHospitalEnvironmentalRadioModel().add(getMedicalFacilityHospitalEnvironmentalRadioItem2());

    getMedicalFacilityHospitalEnvironmentalRadioItem3().setButtonIndex(3);
    getMedicalFacilityHospitalEnvironmentalRadioModel().add(getMedicalFacilityHospitalEnvironmentalRadioItem3());

    getMedicalFacilityHospitalEnvironmentalRadioItem4().setButtonIndex(4);
    getMedicalFacilityHospitalEnvironmentalRadioModel().add(getMedicalFacilityHospitalEnvironmentalRadioItem4());

  }

  /**
   * 基準型に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalEnvironmentalRadioItem1(){

  }

  /**
   * 減算Iに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalEnvironmentalRadioItem2(){

  }

  /**
   * 減算IIに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalEnvironmentalRadioItem3(){

  }

  /**
   * 減算IIIに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalEnvironmentalRadioItem4(){

  }

  /**
   * 医師の配置基準に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalDoctorArrangeStandardRadio(){

  }

  /**
   * 医師の配置基準モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalDoctorArrangeStandardRadioModel(){

    getMedicalFacilityHospitalDoctorArrangeStandardRadioItem1().setButtonIndex(1);
    getMedicalFacilityHospitalDoctorArrangeStandardRadioModel().add(getMedicalFacilityHospitalDoctorArrangeStandardRadioItem1());

    getMedicalFacilityHospitalDoctorArrangeStandardRadioItem2().setButtonIndex(2);
    getMedicalFacilityHospitalDoctorArrangeStandardRadioModel().add(getMedicalFacilityHospitalDoctorArrangeStandardRadioItem2());

  }

  /**
   * 基準に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalDoctorArrangeStandardRadioItem1(){

  }

  /**
   * 医療法施行規則第49条適用に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalDoctorArrangeStandardRadioItem2(){

  }

  /**
   * 外泊加算に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalStayRadio(){

  }

  /**
   * 外泊加算モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalStayRadioModel(){

    getMedicalFacilityHospitalStayRadioItem1().setButtonIndex(1);
    getMedicalFacilityHospitalStayRadioModel().add(getMedicalFacilityHospitalStayRadioItem1());

    getMedicalFacilityHospitalStayRadioItem2().setButtonIndex(2);
    getMedicalFacilityHospitalStayRadioModel().add(getMedicalFacilityHospitalStayRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalStayRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalStayRadioItem2(){

  }

  /**
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getMedicalFacilityHospitalStandardRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityHospitalMedicalExaminationRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityHospitalNutritionManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityHospitalNutritionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityHospitalOralSwitchRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getOralMaintenanceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityHospitalRecuperateDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityHospitalHijoAddition(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 初期加算に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalStandardRadio(){

  }

  /**
   * 初期加算モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalStandardRadioModel(){

    getMedicalFacilityHospitalStandardRadioItem1().setButtonIndex(1);
    getMedicalFacilityHospitalStandardRadioModel().add(getMedicalFacilityHospitalStandardRadioItem1());

    getMedicalFacilityHospitalStandardRadioItem2().setButtonIndex(2);
    getMedicalFacilityHospitalStandardRadioModel().add(getMedicalFacilityHospitalStandardRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalStandardRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalStandardRadioItem2(){

  }

  /**
   * 他科受診に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalMedicalExaminationRadio(){

  }

  /**
   * 他科受診モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalMedicalExaminationRadioModel(){

    getMedicalFacilityHospitalMedicalExaminationRadioItem1().setButtonIndex(1);
    getMedicalFacilityHospitalMedicalExaminationRadioModel().add(getMedicalFacilityHospitalMedicalExaminationRadioItem1());

    getMedicalFacilityHospitalMedicalExaminationRadioItem2().setButtonIndex(2);
    getMedicalFacilityHospitalMedicalExaminationRadioModel().add(getMedicalFacilityHospitalMedicalExaminationRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalMedicalExaminationRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalMedicalExaminationRadioItem2(){

  }

  /**
   * 栄養管理体制加算に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalNutritionManageRadio(){

  }

  /**
   * 栄養管理体制加算モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalNutritionManageRadioModel(){

    getMedicalFacilityHospitalNutritionManageRadioItem1().setButtonIndex(1);
    getMedicalFacilityHospitalNutritionManageRadioModel().add(getMedicalFacilityHospitalNutritionManageRadioItem1());

    getMedicalFacilityHospitalNutritionManageRadioItem2().setButtonIndex(2);
    getMedicalFacilityHospitalNutritionManageRadioModel().add(getMedicalFacilityHospitalNutritionManageRadioItem2());

    getMedicalFacilityHospitalNutritionManageRadioItem3().setButtonIndex(3);
    getMedicalFacilityHospitalNutritionManageRadioModel().add(getMedicalFacilityHospitalNutritionManageRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalNutritionManageRadioItem1(){

  }

  /**
   * 管理栄養士に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalNutritionManageRadioItem2(){

  }

  /**
   * 栄養士に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalNutritionManageRadioItem3(){

  }

  /**
   * 栄養マネジメント加算に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalNutritionRadio(){

  }

  /**
   * 栄養マネジメント加算モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalNutritionRadioModel(){

    getMedicalFacilityHospitalNutritionRadioItem1().setButtonIndex(1);
    getMedicalFacilityHospitalNutritionRadioModel().add(getMedicalFacilityHospitalNutritionRadioItem1());

    getMedicalFacilityHospitalNutritionRadioItem2().setButtonIndex(2);
    getMedicalFacilityHospitalNutritionRadioModel().add(getMedicalFacilityHospitalNutritionRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalNutritionRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalNutritionRadioItem2(){

  }

  /**
   * 経口移行加算に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalOralSwitchRadio(){

  }

  /**
   * 経口移行加算モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalOralSwitchRadioModel(){

    getMedicalFacilityHospitalOralSwitchRadioItem1().setButtonIndex(1);
    getMedicalFacilityHospitalOralSwitchRadioModel().add(getMedicalFacilityHospitalOralSwitchRadioItem1());

    getMedicalFacilityHospitalOralSwitchRadioItem2().setButtonIndex(2);
    getMedicalFacilityHospitalOralSwitchRadioModel().add(getMedicalFacilityHospitalOralSwitchRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalOralSwitchRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalOralSwitchRadioItem2(){

  }

  /**
   * 経口維持加算に内部項目を追加します。
   */
  protected void addOralMaintenanceRadio(){

  }

  /**
   * 経口維持加算モデルに内部項目を追加します。
   */
  protected void addOralMaintenanceRadioModel(){

    getOralMaintenanceRadioItem1().setButtonIndex(1);
    getOralMaintenanceRadioModel().add(getOralMaintenanceRadioItem1());

    getOralMaintenanceRadioItem2().setButtonIndex(2);
    getOralMaintenanceRadioModel().add(getOralMaintenanceRadioItem2());

    getOralMaintenanceRadioItem3().setButtonIndex(3);
    getOralMaintenanceRadioModel().add(getOralMaintenanceRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addOralMaintenanceRadioItem1(){

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addOralMaintenanceRadioItem2(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addOralMaintenanceRadioItem3(){

  }

  /**
   * 療養食加算に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalRecuperateDinnerRadio(){

  }

  /**
   * 療養食加算モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalRecuperateDinnerRadioModel(){

    getMedicalFacilityHospitalRecuperateDinnerRadioItem1().setButtonIndex(1);
    getMedicalFacilityHospitalRecuperateDinnerRadioModel().add(getMedicalFacilityHospitalRecuperateDinnerRadioItem1());

    getMedicalFacilityHospitalRecuperateDinnerRadioItem2().setButtonIndex(2);
    getMedicalFacilityHospitalRecuperateDinnerRadioModel().add(getMedicalFacilityHospitalRecuperateDinnerRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalRecuperateDinnerRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalRecuperateDinnerRadioItem2(){

  }

  /**
   * 退所関連加算に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalHijoAddition(){

    medicalFacilityHospitalHijoAddition.add(getLeavingHospitalPreConsultationAddition(), VRLayout.FLOW_RETURN);

    medicalFacilityHospitalHijoAddition.add(getLeavingHospitalConsultationAddition(), VRLayout.FLOW_RETURN);

    medicalFacilityHospitalHijoAddition.add(getLeavingHospitalDissemination(), VRLayout.FLOW_RETURN);

    medicalFacilityHospitalHijoAddition.add(getLeavingHospitalCooperationAddition(), VRLayout.FLOW_RETURN);

    medicalFacilityHospitalHijoAddition.add(getLeavingHospital(), VRLayout.FLOW_RETURN);

  }

  /**
   * 退所(院)前後訪問指導加算に内部項目を追加します。
   */
  protected void addLeavingHospitalPreConsultationAddition(){

  }

  /**
   * 退所(院)時指導加算に内部項目を追加します。
   */
  protected void addLeavingHospitalConsultationAddition(){

  }

  /**
   * 退所(院)時情報提供加算に内部項目を追加します。
   */
  protected void addLeavingHospitalDissemination(){

  }

  /**
   * 退所(院)前連携加算に内部項目を追加します。
   */
  protected void addLeavingHospitalCooperationAddition(){

  }

  /**
   * 老人訪問看護指示加算に内部項目を追加します。
   */
  protected void addLeavingHospital(){

  }

  /**
   * タブ3に内部項目を追加します。
   */
  protected void addTab3(){

    tab3.add(getMedicalFacilityHospitalConsultationFee(), VRLayout.FLOW);

    tab3.add(getMedicalFacilityHospitalConsultationFeeLabel(), VRLayout.FLOW_RETURN);

    tab3.add(getMedicalFacilityHospitalSubstractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getMedicalFacilityDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tab3.add(getUnitCareMaintenanceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getBodyRestraintAbolitionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getStayReturnSupportAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 特定診療費に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalConsultationFee(){

  }

  /**
   * ラベルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalConsultationFeeLabel(){

  }

  /**
   * 人員減算に内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalSubstraction(){

  }

  /**
   * 人員減算モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityHospitalSubstractionModel(){

  }

  /**
   * 食事コンテナに内部項目を追加します。
   */
  protected void addMedicalFacilityDinnerContainer(){

    medicalFacilityDinnerContainer.add(getMedicalFacilityDinnerOfferContainer(), VRLayout.FLOW);

    medicalFacilityDinnerContainer.add(getMedicalFacilityDinnerCostContainer(), VRLayout.FLOW);

  }

  /**
   * 食事提供に内部項目を追加します。
   */
  protected void addMedicalFacilityDinnerOffer(){

  }

  /**
   * 食事提供モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityDinnerOfferModel(){

  }

  /**
   * 食事費用に内部項目を追加します。
   */
  protected void addMedicalFacilityDinnerCost(){

  }

  /**
   * ユニットケアの整備に内部項目を追加します。
   */
  protected void addUnitCareMaintenanceRadio(){

  }

  /**
   * ユニットケアの整備モデルに内部項目を追加します。
   */
  protected void addUnitCareMaintenanceRadioModel(){

    getUnitCareMaintenanceRadioItem1().setButtonIndex(1);
    getUnitCareMaintenanceRadioModel().add(getUnitCareMaintenanceRadioItem1());

    getUnitCareMaintenanceRadioItem2().setButtonIndex(2);
    getUnitCareMaintenanceRadioModel().add(getUnitCareMaintenanceRadioItem2());

  }

  /**
   * 未整備に内部項目を追加します。
   */
  protected void addUnitCareMaintenanceRadioItem1(){

  }

  /**
   * 整備に内部項目を追加します。
   */
  protected void addUnitCareMaintenanceRadioItem2(){

  }

  /**
   * 身体拘束廃止未実施減算に内部項目を追加します。
   */
  protected void addBodyRestraintAbolitionRadio(){

  }

  /**
   * 身体拘束廃止未実施減算モデルに内部項目を追加します。
   */
  protected void addBodyRestraintAbolitionRadioModel(){

    getBodyRestraintAbolitionRadioItem1().setButtonIndex(1);
    getBodyRestraintAbolitionRadioModel().add(getBodyRestraintAbolitionRadioItem1());

    getBodyRestraintAbolitionRadioItem2().setButtonIndex(2);
    getBodyRestraintAbolitionRadioModel().add(getBodyRestraintAbolitionRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addBodyRestraintAbolitionRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addBodyRestraintAbolitionRadioItem2(){

  }

  /**
   * 在宅復帰支援機能加算に内部項目を追加します。
   */
  protected void addStayReturnSupportAddRadio(){

  }

  /**
   * 在宅復帰支援機能加算モデルに内部項目を追加します。
   */
  protected void addStayReturnSupportAddRadioModel(){

    getStayReturnSupportAddRadioItem1().setButtonIndex(1);
    getStayReturnSupportAddRadioModel().add(getStayReturnSupportAddRadioItem1());

    getStayReturnSupportAddRadioItem2().setButtonIndex(2);
    getStayReturnSupportAddRadioModel().add(getStayReturnSupportAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addStayReturnSupportAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addStayReturnSupportAddRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001120Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001120Design getThis() {
    return this;
  }
}
