
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
 * 作成日: 2008/03/18  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン介護療養型医療施設（診療所） (QS001121_H2004)
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
 * サービスパターン介護療養型医療施設（診療所）画面項目デザイン(QS001121_H2004) 
 */
public class QS001121_H2004Design extends QS001ServicePanel {
  //GUIコンポーネント

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACClearableRadioButtonGroup medicalFacilityClinicInstitutionDivisionRadio;

  private ACLabelContainer medicalFacilityClinicInstitutionDivisionRadioContainer;

  private ACListModelAdapter medicalFacilityClinicInstitutionDivisionRadioModel;

  private ACRadioButtonItem medicalFacilityClinicInstitutionDivisionRadioItem1;

  private ACRadioButtonItem medicalFacilityClinicInstitutionDivisionRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityClinicDivision;

  private ACLabelContainer medicalFacilityClinicDivisionContainer;

  private ACListModelAdapter medicalFacilityClinicDivisionModel;

  private ACRadioButtonItem medicalFacilityClinicDivision1;

  private ACRadioButtonItem medicalFacilityClinicDivision2;

  private ACLabelContainer medicalFacilityClinicHospitalRoomContena;

  private ACClearableRadioButtonGroup medicalFacilityClinicHospitalRoomRadio;

  private ACListModelAdapter medicalFacilityClinicHospitalRoomRadioModel;

  private ACRadioButtonItem medicalFacilityClinicHospitalRoomRadioItem1;

  private ACRadioButtonItem medicalFacilityClinicHospitalRoomRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityClinicUnitHospitalRoomRadio;

  private ACListModelAdapter medicalFacilityClinicUnitHospitalRoomRadioModel;

  private ACRadioButtonItem medicalFacilityClinicUnitHospitalRoomRadioItem1;

  private ACRadioButtonItem medicalFacilityClinicUnitHospitalRoomRadioItem2;

  private ACValueArrayRadioButtonGroup medicalFacilityClinicEnvironmentalRadio;

  private ACLabelContainer medicalFacilityClinicEnvironmentalRadioContainer;

  private ACListModelAdapter medicalFacilityClinicEnvironmentalRadioModel;

  private ACRadioButtonItem medicalFacilityClinicEnvironmentalRadioItem1;

  private ACRadioButtonItem medicalFacilityClinicEnvironmentalRadioItem3;

  private ACValueArrayRadioButtonGroup medicalFacilityClinicProvisionBaseRadio;

  private ACLabelContainer medicalFacilityClinicProvisionBaseRadioContainer;

  private ACListModelAdapter medicalFacilityClinicProvisionBaseRadioModel;

  private ACRadioButtonItem medicalFacilityClinicProvisionBaseRadioItem1;

  private ACRadioButtonItem medicalFacilityClinicProvisionBaseRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityClinicStayRadio;

  private ACLabelContainer medicalFacilityClinicStayRadioContainer;

  private ACListModelAdapter medicalFacilityClinicStayRadioModel;

  private ACRadioButtonItem medicalFacilityClinicStayRadioItem1;

  private ACRadioButtonItem medicalFacilityClinicStayRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityClinicStandardRadio;

  private ACLabelContainer medicalFacilityClinicStandardRadioContainer;

  private ACListModelAdapter medicalFacilityClinicStandardRadioModel;

  private ACRadioButtonItem medicalFacilityClinicStandardRadioItem1;

  private ACRadioButtonItem medicalFacilityClinicStandardRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityClinicMedicalExaminationRadio;

  private ACLabelContainer medicalFacilityClinicMedicalExaminationRadioContainer;

  private ACListModelAdapter medicalFacilityClinicMedicalExaminationRadioModel;

  private ACRadioButtonItem medicalFacilityClinicMedicalExaminationRadioItem1;

  private ACRadioButtonItem medicalFacilityClinicMedicalExaminationRadioItem2;

  private ACClearableRadioButtonGroup medicalFacilityClinicNutritionManageRadio;

  private ACLabelContainer medicalFacilityClinicNutritionManageRadioContainer;

  private ACListModelAdapter medicalFacilityClinicNutritionManageRadioModel;

  private ACRadioButtonItem medicalFacilityClinicNutritionManageRadioItem1;

  private ACRadioButtonItem medicalFacilityClinicNutritionManageRadioItem2;

  private ACRadioButtonItem medicalFacilityClinicNutritionManageRadioItem3;

  private ACClearableRadioButtonGroup medicalFacilityClinicNutritionRadio;

  private ACLabelContainer medicalFacilityClinicNutritionRadioContainer;

  private ACListModelAdapter medicalFacilityClinicNutritionRadioModel;

  private ACRadioButtonItem medicalFacilityClinicNutritionRadioItem1;

  private ACRadioButtonItem medicalFacilityClinicNutritionRadioItem2;

  private ACPanel tab2;

  private ACClearableRadioButtonGroup medicalFacilityClinicOralSwitchRadio;

  private ACLabelContainer medicalFacilityClinicOralSwitchRadioContainer;

  private ACListModelAdapter medicalFacilityClinicOralSwitchRadioModel;

  private ACRadioButtonItem medicalFacilityClinicOralSwitchRadioItem1;

  private ACRadioButtonItem medicalFacilityClinicOralSwitchRadioItem2;

  private ACClearableRadioButtonGroup oralMaintenanceAddRadio;

  private ACLabelContainer oralMaintenanceAddRadioContainer;

  private ACListModelAdapter oralMaintenanceAddRadioModel;

  private ACRadioButtonItem oralMaintenanceAddRadioItem1;

  private ACRadioButtonItem oralMaintenanceAddRadioItem2;

  private ACRadioButtonItem oralMaintenanceAddRadioItem3;

  private ACClearableRadioButtonGroup medicalFacilityClinicRecuperateDinnerRadio;

  private ACLabelContainer medicalFacilityClinicRecuperateDinnerRadioContainer;

  private ACListModelAdapter medicalFacilityClinicRecuperateDinnerRadioModel;

  private ACRadioButtonItem medicalFacilityClinicRecuperateDinnerRadioItem1;

  private ACRadioButtonItem medicalFacilityClinicRecuperateDinnerRadioItem2;

  private ACLabelContainer medicalFacilityClinicHijoAddition;

  private ACIntegerCheckBox leavingHospitalPreConsultationAddition;

  private ACIntegerCheckBox leavingHospitalConsultationAddition;

  private ACIntegerCheckBox leavingHospitalDissemination;

  private ACIntegerCheckBox leavingHospitalCooperationAddition;

  private ACIntegerCheckBox leavingHospital;

  private ACMapBindButton medicalFacilityClinicConsultationFee;

  private ACLabel medicalFacilityClinicConsultationFeeLabel;

  private ACClearableRadioButtonGroup medicalFacilityClinicSubstractionRadio;

  private ACLabelContainer medicalFacilityClinicSubstractionRadioContainer;

  private ACListModelAdapter medicalFacilityClinicSubstractionRadioModel;

  private ACRadioButtonItem medicalFacilityClinicSubstractionRadioItem1;

  private ACRadioButtonItem medicalFacilityClinicSubstractionRadioItem2;

  private ACBackLabelContainer medicalFacilityClinicDinnerContainer;

  private ACComboBox medicalFacilityClinicDinnerOffer;

  private ACLabelContainer medicalFacilityClinicDinnerOfferContainer;

  private ACComboBoxModelAdapter medicalFacilityClinicDinnerOfferModel;

  private ACTextField medicalFacilityClinicDinnerCost;

  private ACLabelContainer medicalFacilityClinicDinnerCostContainer;

  private ACPanel tab3;

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

  private ACClearableRadioButtonGroup medicalFacilityClinicCalculationDivisionRadio;

  private ACLabelContainer medicalFacilityClinicCalculationDivisionRadioContainer;

  private ACListModelAdapter medicalFacilityClinicCalculationDivisionRadioModel;

  private ACRadioButtonItem medicalFacilityClinicCalculationDivisionRadioItem1;

  private ACRadioButtonItem medicalFacilityClinicCalculationDivisionRadioItem2;

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
  public ACClearableRadioButtonGroup getMedicalFacilityClinicInstitutionDivisionRadio(){
    if(medicalFacilityClinicInstitutionDivisionRadio==null){

      medicalFacilityClinicInstitutionDivisionRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityClinicInstitutionDivisionRadioContainer().setText("施設等の区分");

      medicalFacilityClinicInstitutionDivisionRadio.setBindPath("1530201");

      medicalFacilityClinicInstitutionDivisionRadio.setUseClearButton(false);

      medicalFacilityClinicInstitutionDivisionRadio.setModel(getMedicalFacilityClinicInstitutionDivisionRadioModel());

      addMedicalFacilityClinicInstitutionDivisionRadio();
    }
    return medicalFacilityClinicInstitutionDivisionRadio;

  }

  /**
   * 施設等の区分コンテナを取得します。
   * @return 施設等の区分コンテナ
   */
  protected ACLabelContainer getMedicalFacilityClinicInstitutionDivisionRadioContainer(){
    if(medicalFacilityClinicInstitutionDivisionRadioContainer==null){
      medicalFacilityClinicInstitutionDivisionRadioContainer = new ACLabelContainer();
      medicalFacilityClinicInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      medicalFacilityClinicInstitutionDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityClinicInstitutionDivisionRadioContainer.add(getMedicalFacilityClinicInstitutionDivisionRadio(), null);
    }
    return medicalFacilityClinicInstitutionDivisionRadioContainer;
  }

  /**
   * 施設等の区分モデルを取得します。
   * @return 施設等の区分モデル
   */
  protected ACListModelAdapter getMedicalFacilityClinicInstitutionDivisionRadioModel(){
    if(medicalFacilityClinicInstitutionDivisionRadioModel==null){
      medicalFacilityClinicInstitutionDivisionRadioModel = new ACListModelAdapter();
      addMedicalFacilityClinicInstitutionDivisionRadioModel();
    }
    return medicalFacilityClinicInstitutionDivisionRadioModel;
  }

  /**
   * 診療所を取得します。
   * @return 診療所
   */
  public ACRadioButtonItem getMedicalFacilityClinicInstitutionDivisionRadioItem1(){
    if(medicalFacilityClinicInstitutionDivisionRadioItem1==null){

      medicalFacilityClinicInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      medicalFacilityClinicInstitutionDivisionRadioItem1.setText("診療所");

      medicalFacilityClinicInstitutionDivisionRadioItem1.setGroup(getMedicalFacilityClinicInstitutionDivisionRadio());

      medicalFacilityClinicInstitutionDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicInstitutionDivisionRadioItem1();
    }
    return medicalFacilityClinicInstitutionDivisionRadioItem1;

  }

  /**
   * ユニット型診療所を取得します。
   * @return ユニット型診療所
   */
  public ACRadioButtonItem getMedicalFacilityClinicInstitutionDivisionRadioItem2(){
    if(medicalFacilityClinicInstitutionDivisionRadioItem2==null){

      medicalFacilityClinicInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      medicalFacilityClinicInstitutionDivisionRadioItem2.setText("ユニット型診療所");

      medicalFacilityClinicInstitutionDivisionRadioItem2.setGroup(getMedicalFacilityClinicInstitutionDivisionRadio());

      medicalFacilityClinicInstitutionDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicInstitutionDivisionRadioItem2();
    }
    return medicalFacilityClinicInstitutionDivisionRadioItem2;

  }

  /**
   * 人員配置区分を取得します。
   * @return 人員配置区分
   */
  public ACClearableRadioButtonGroup getMedicalFacilityClinicDivision(){
    if(medicalFacilityClinicDivision==null){

      medicalFacilityClinicDivision = new ACClearableRadioButtonGroup();

      getMedicalFacilityClinicDivisionContainer().setText("人員配置区分");

      medicalFacilityClinicDivision.setBindPath("1530202");

      medicalFacilityClinicDivision.setUseClearButton(false);

      medicalFacilityClinicDivision.setModel(getMedicalFacilityClinicDivisionModel());

      addMedicalFacilityClinicDivision();
    }
    return medicalFacilityClinicDivision;

  }

  /**
   * 人員配置区分コンテナを取得します。
   * @return 人員配置区分コンテナ
   */
  protected ACLabelContainer getMedicalFacilityClinicDivisionContainer(){
    if(medicalFacilityClinicDivisionContainer==null){
      medicalFacilityClinicDivisionContainer = new ACLabelContainer();
      medicalFacilityClinicDivisionContainer.setFollowChildEnabled(true);
      medicalFacilityClinicDivisionContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityClinicDivisionContainer.add(getMedicalFacilityClinicDivision(), null);
    }
    return medicalFacilityClinicDivisionContainer;
  }

  /**
   * 人員配置区分モデルを取得します。
   * @return 人員配置区分モデル
   */
  protected ACListModelAdapter getMedicalFacilityClinicDivisionModel(){
    if(medicalFacilityClinicDivisionModel==null){
      medicalFacilityClinicDivisionModel = new ACListModelAdapter();
      addMedicalFacilityClinicDivisionModel();
    }
    return medicalFacilityClinicDivisionModel;
  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getMedicalFacilityClinicDivision1(){
    if(medicalFacilityClinicDivision1==null){

      medicalFacilityClinicDivision1 = new ACRadioButtonItem();

      medicalFacilityClinicDivision1.setText("I型");

      medicalFacilityClinicDivision1.setGroup(getMedicalFacilityClinicDivision());

      medicalFacilityClinicDivision1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicDivision1();
    }
    return medicalFacilityClinicDivision1;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getMedicalFacilityClinicDivision2(){
    if(medicalFacilityClinicDivision2==null){

      medicalFacilityClinicDivision2 = new ACRadioButtonItem();

      medicalFacilityClinicDivision2.setText("II型");

      medicalFacilityClinicDivision2.setGroup(getMedicalFacilityClinicDivision());

      medicalFacilityClinicDivision2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicDivision2();
    }
    return medicalFacilityClinicDivision2;

  }

  /**
   * 病室区分コンテナを取得します。
   * @return 病室区分コンテナ
   */
  public ACLabelContainer getMedicalFacilityClinicHospitalRoomContena(){
    if(medicalFacilityClinicHospitalRoomContena==null){

      medicalFacilityClinicHospitalRoomContena = new ACLabelContainer();

      medicalFacilityClinicHospitalRoomContena.setText("病室区分");

      addMedicalFacilityClinicHospitalRoomContena();
    }
    return medicalFacilityClinicHospitalRoomContena;

  }

  /**
   * 病室区分（病院）を取得します。
   * @return 病室区分（病院）
   */
  public ACClearableRadioButtonGroup getMedicalFacilityClinicHospitalRoomRadio(){
    if(medicalFacilityClinicHospitalRoomRadio==null){

      medicalFacilityClinicHospitalRoomRadio = new ACClearableRadioButtonGroup();

      medicalFacilityClinicHospitalRoomRadio.setBindPath("1530203");

      medicalFacilityClinicHospitalRoomRadio.setUseClearButton(false);

      medicalFacilityClinicHospitalRoomRadio.setModel(getMedicalFacilityClinicHospitalRoomRadioModel());

      addMedicalFacilityClinicHospitalRoomRadio();
    }
    return medicalFacilityClinicHospitalRoomRadio;

  }

  /**
   * 病室区分（病院）モデルを取得します。
   * @return 病室区分（病院）モデル
   */
  protected ACListModelAdapter getMedicalFacilityClinicHospitalRoomRadioModel(){
    if(medicalFacilityClinicHospitalRoomRadioModel==null){
      medicalFacilityClinicHospitalRoomRadioModel = new ACListModelAdapter();
      addMedicalFacilityClinicHospitalRoomRadioModel();
    }
    return medicalFacilityClinicHospitalRoomRadioModel;
  }

  /**
   * 従来型個室を取得します。
   * @return 従来型個室
   */
  public ACRadioButtonItem getMedicalFacilityClinicHospitalRoomRadioItem1(){
    if(medicalFacilityClinicHospitalRoomRadioItem1==null){

      medicalFacilityClinicHospitalRoomRadioItem1 = new ACRadioButtonItem();

      medicalFacilityClinicHospitalRoomRadioItem1.setText("従来型個室");

      medicalFacilityClinicHospitalRoomRadioItem1.setGroup(getMedicalFacilityClinicHospitalRoomRadio());

      medicalFacilityClinicHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicHospitalRoomRadioItem1();
    }
    return medicalFacilityClinicHospitalRoomRadioItem1;

  }

  /**
   * 多床室を取得します。
   * @return 多床室
   */
  public ACRadioButtonItem getMedicalFacilityClinicHospitalRoomRadioItem2(){
    if(medicalFacilityClinicHospitalRoomRadioItem2==null){

      medicalFacilityClinicHospitalRoomRadioItem2 = new ACRadioButtonItem();

      medicalFacilityClinicHospitalRoomRadioItem2.setText("多床室");

      medicalFacilityClinicHospitalRoomRadioItem2.setGroup(getMedicalFacilityClinicHospitalRoomRadio());

      medicalFacilityClinicHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicHospitalRoomRadioItem2();
    }
    return medicalFacilityClinicHospitalRoomRadioItem2;

  }

  /**
   * 病室区分（ユニット型）を取得します。
   * @return 病室区分（ユニット型）
   */
  public ACClearableRadioButtonGroup getMedicalFacilityClinicUnitHospitalRoomRadio(){
    if(medicalFacilityClinicUnitHospitalRoomRadio==null){

      medicalFacilityClinicUnitHospitalRoomRadio = new ACClearableRadioButtonGroup();

      medicalFacilityClinicUnitHospitalRoomRadio.setBindPath("1530204");

      medicalFacilityClinicUnitHospitalRoomRadio.setUseClearButton(false);

      medicalFacilityClinicUnitHospitalRoomRadio.setModel(getMedicalFacilityClinicUnitHospitalRoomRadioModel());

      addMedicalFacilityClinicUnitHospitalRoomRadio();
    }
    return medicalFacilityClinicUnitHospitalRoomRadio;

  }

  /**
   * 病室区分（ユニット型）モデルを取得します。
   * @return 病室区分（ユニット型）モデル
   */
  protected ACListModelAdapter getMedicalFacilityClinicUnitHospitalRoomRadioModel(){
    if(medicalFacilityClinicUnitHospitalRoomRadioModel==null){
      medicalFacilityClinicUnitHospitalRoomRadioModel = new ACListModelAdapter();
      addMedicalFacilityClinicUnitHospitalRoomRadioModel();
    }
    return medicalFacilityClinicUnitHospitalRoomRadioModel;
  }

  /**
   * ユニット型個室を取得します。
   * @return ユニット型個室
   */
  public ACRadioButtonItem getMedicalFacilityClinicUnitHospitalRoomRadioItem1(){
    if(medicalFacilityClinicUnitHospitalRoomRadioItem1==null){

      medicalFacilityClinicUnitHospitalRoomRadioItem1 = new ACRadioButtonItem();

      medicalFacilityClinicUnitHospitalRoomRadioItem1.setText("ユニット型個室");

      medicalFacilityClinicUnitHospitalRoomRadioItem1.setGroup(getMedicalFacilityClinicUnitHospitalRoomRadio());

      medicalFacilityClinicUnitHospitalRoomRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicUnitHospitalRoomRadioItem1();
    }
    return medicalFacilityClinicUnitHospitalRoomRadioItem1;

  }

  /**
   * ユニット型準個室を取得します。
   * @return ユニット型準個室
   */
  public ACRadioButtonItem getMedicalFacilityClinicUnitHospitalRoomRadioItem2(){
    if(medicalFacilityClinicUnitHospitalRoomRadioItem2==null){

      medicalFacilityClinicUnitHospitalRoomRadioItem2 = new ACRadioButtonItem();

      medicalFacilityClinicUnitHospitalRoomRadioItem2.setText("ユニット型準個室");

      medicalFacilityClinicUnitHospitalRoomRadioItem2.setGroup(getMedicalFacilityClinicUnitHospitalRoomRadio());

      medicalFacilityClinicUnitHospitalRoomRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicUnitHospitalRoomRadioItem2();
    }
    return medicalFacilityClinicUnitHospitalRoomRadioItem2;

  }

  /**
   * 療養環境基準を取得します。
   * @return 療養環境基準
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityClinicEnvironmentalRadio(){
    if(medicalFacilityClinicEnvironmentalRadio==null){

      medicalFacilityClinicEnvironmentalRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityClinicEnvironmentalRadioContainer().setText("療養環境基準");

      medicalFacilityClinicEnvironmentalRadio.setBindPath("1530205");

      medicalFacilityClinicEnvironmentalRadio.setNoSelectIndex(0);

      medicalFacilityClinicEnvironmentalRadio.setUseClearButton(false);

      medicalFacilityClinicEnvironmentalRadio.setModel(getMedicalFacilityClinicEnvironmentalRadioModel());

      medicalFacilityClinicEnvironmentalRadio.setValues(new int[]{1,3});

      addMedicalFacilityClinicEnvironmentalRadio();
    }
    return medicalFacilityClinicEnvironmentalRadio;

  }

  /**
   * 療養環境基準コンテナを取得します。
   * @return 療養環境基準コンテナ
   */
  protected ACLabelContainer getMedicalFacilityClinicEnvironmentalRadioContainer(){
    if(medicalFacilityClinicEnvironmentalRadioContainer==null){
      medicalFacilityClinicEnvironmentalRadioContainer = new ACLabelContainer();
      medicalFacilityClinicEnvironmentalRadioContainer.setFollowChildEnabled(true);
      medicalFacilityClinicEnvironmentalRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityClinicEnvironmentalRadioContainer.add(getMedicalFacilityClinicEnvironmentalRadio(), null);
    }
    return medicalFacilityClinicEnvironmentalRadioContainer;
  }

  /**
   * 療養環境基準モデルを取得します。
   * @return 療養環境基準モデル
   */
  protected ACListModelAdapter getMedicalFacilityClinicEnvironmentalRadioModel(){
    if(medicalFacilityClinicEnvironmentalRadioModel==null){
      medicalFacilityClinicEnvironmentalRadioModel = new ACListModelAdapter();
      addMedicalFacilityClinicEnvironmentalRadioModel();
    }
    return medicalFacilityClinicEnvironmentalRadioModel;
  }

  /**
   * 基準型を取得します。
   * @return 基準型
   */
  public ACRadioButtonItem getMedicalFacilityClinicEnvironmentalRadioItem1(){
    if(medicalFacilityClinicEnvironmentalRadioItem1==null){

      medicalFacilityClinicEnvironmentalRadioItem1 = new ACRadioButtonItem();

      medicalFacilityClinicEnvironmentalRadioItem1.setText("基準型");

      medicalFacilityClinicEnvironmentalRadioItem1.setGroup(getMedicalFacilityClinicEnvironmentalRadio());

      medicalFacilityClinicEnvironmentalRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicEnvironmentalRadioItem1();
    }
    return medicalFacilityClinicEnvironmentalRadioItem1;

  }

  /**
   * 減算IIを取得します。
   * @return 減算II
   */
  public ACRadioButtonItem getMedicalFacilityClinicEnvironmentalRadioItem3(){
    if(medicalFacilityClinicEnvironmentalRadioItem3==null){

      medicalFacilityClinicEnvironmentalRadioItem3 = new ACRadioButtonItem();

      medicalFacilityClinicEnvironmentalRadioItem3.setText("減算型II");

      medicalFacilityClinicEnvironmentalRadioItem3.setGroup(getMedicalFacilityClinicEnvironmentalRadio());

      medicalFacilityClinicEnvironmentalRadioItem3.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicEnvironmentalRadioItem3();
    }
    return medicalFacilityClinicEnvironmentalRadioItem3;

  }

  /**
   * 設備基準基準を取得します。
   * @return 設備基準基準
   */
  public ACValueArrayRadioButtonGroup getMedicalFacilityClinicProvisionBaseRadio(){
    if(medicalFacilityClinicProvisionBaseRadio==null){

      medicalFacilityClinicProvisionBaseRadio = new ACValueArrayRadioButtonGroup();

      getMedicalFacilityClinicProvisionBaseRadioContainer().setText("設備基準減算");

      medicalFacilityClinicProvisionBaseRadio.setBindPath("1530260");

      medicalFacilityClinicProvisionBaseRadio.setNoSelectIndex(0);

      medicalFacilityClinicProvisionBaseRadio.setUseClearButton(false);

      medicalFacilityClinicProvisionBaseRadio.setModel(getMedicalFacilityClinicProvisionBaseRadioModel());

      medicalFacilityClinicProvisionBaseRadio.setValues(new int[]{1,2});

      addMedicalFacilityClinicProvisionBaseRadio();
    }
    return medicalFacilityClinicProvisionBaseRadio;

  }

  /**
   * 設備基準基準コンテナを取得します。
   * @return 設備基準基準コンテナ
   */
  protected ACLabelContainer getMedicalFacilityClinicProvisionBaseRadioContainer(){
    if(medicalFacilityClinicProvisionBaseRadioContainer==null){
      medicalFacilityClinicProvisionBaseRadioContainer = new ACLabelContainer();
      medicalFacilityClinicProvisionBaseRadioContainer.setFollowChildEnabled(true);
      medicalFacilityClinicProvisionBaseRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityClinicProvisionBaseRadioContainer.add(getMedicalFacilityClinicProvisionBaseRadio(), null);
    }
    return medicalFacilityClinicProvisionBaseRadioContainer;
  }

  /**
   * 設備基準基準モデルを取得します。
   * @return 設備基準基準モデル
   */
  protected ACListModelAdapter getMedicalFacilityClinicProvisionBaseRadioModel(){
    if(medicalFacilityClinicProvisionBaseRadioModel==null){
      medicalFacilityClinicProvisionBaseRadioModel = new ACListModelAdapter();
      addMedicalFacilityClinicProvisionBaseRadioModel();
    }
    return medicalFacilityClinicProvisionBaseRadioModel;
  }

  /**
   * 基準型を取得します。
   * @return 基準型
   */
  public ACRadioButtonItem getMedicalFacilityClinicProvisionBaseRadioItem1(){
    if(medicalFacilityClinicProvisionBaseRadioItem1==null){

      medicalFacilityClinicProvisionBaseRadioItem1 = new ACRadioButtonItem();

      medicalFacilityClinicProvisionBaseRadioItem1.setText("基準型");

      medicalFacilityClinicProvisionBaseRadioItem1.setGroup(getMedicalFacilityClinicProvisionBaseRadio());

      medicalFacilityClinicProvisionBaseRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicProvisionBaseRadioItem1();
    }
    return medicalFacilityClinicProvisionBaseRadioItem1;

  }

  /**
   * 減算型を取得します。
   * @return 減算型
   */
  public ACRadioButtonItem getMedicalFacilityClinicProvisionBaseRadioItem2(){
    if(medicalFacilityClinicProvisionBaseRadioItem2==null){

      medicalFacilityClinicProvisionBaseRadioItem2 = new ACRadioButtonItem();

      medicalFacilityClinicProvisionBaseRadioItem2.setText("減算型");

      medicalFacilityClinicProvisionBaseRadioItem2.setGroup(getMedicalFacilityClinicProvisionBaseRadio());

      medicalFacilityClinicProvisionBaseRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicProvisionBaseRadioItem2();
    }
    return medicalFacilityClinicProvisionBaseRadioItem2;

  }

  /**
   * 外泊加算を取得します。
   * @return 外泊加算
   */
  public ACClearableRadioButtonGroup getMedicalFacilityClinicStayRadio(){
    if(medicalFacilityClinicStayRadio==null){

      medicalFacilityClinicStayRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityClinicStayRadioContainer().setText("外泊加算");

      medicalFacilityClinicStayRadio.setBindPath("1530206");

      medicalFacilityClinicStayRadio.setUseClearButton(false);

      medicalFacilityClinicStayRadio.setModel(getMedicalFacilityClinicStayRadioModel());

      addMedicalFacilityClinicStayRadio();
    }
    return medicalFacilityClinicStayRadio;

  }

  /**
   * 外泊加算コンテナを取得します。
   * @return 外泊加算コンテナ
   */
  protected ACLabelContainer getMedicalFacilityClinicStayRadioContainer(){
    if(medicalFacilityClinicStayRadioContainer==null){
      medicalFacilityClinicStayRadioContainer = new ACLabelContainer();
      medicalFacilityClinicStayRadioContainer.setFollowChildEnabled(true);
      medicalFacilityClinicStayRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityClinicStayRadioContainer.add(getMedicalFacilityClinicStayRadio(), null);
    }
    return medicalFacilityClinicStayRadioContainer;
  }

  /**
   * 外泊加算モデルを取得します。
   * @return 外泊加算モデル
   */
  protected ACListModelAdapter getMedicalFacilityClinicStayRadioModel(){
    if(medicalFacilityClinicStayRadioModel==null){
      medicalFacilityClinicStayRadioModel = new ACListModelAdapter();
      addMedicalFacilityClinicStayRadioModel();
    }
    return medicalFacilityClinicStayRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalFacilityClinicStayRadioItem1(){
    if(medicalFacilityClinicStayRadioItem1==null){

      medicalFacilityClinicStayRadioItem1 = new ACRadioButtonItem();

      medicalFacilityClinicStayRadioItem1.setText("なし");

      medicalFacilityClinicStayRadioItem1.setGroup(getMedicalFacilityClinicStayRadio());

      medicalFacilityClinicStayRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicStayRadioItem1();
    }
    return medicalFacilityClinicStayRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalFacilityClinicStayRadioItem2(){
    if(medicalFacilityClinicStayRadioItem2==null){

      medicalFacilityClinicStayRadioItem2 = new ACRadioButtonItem();

      medicalFacilityClinicStayRadioItem2.setText("あり");

      medicalFacilityClinicStayRadioItem2.setGroup(getMedicalFacilityClinicStayRadio());

      medicalFacilityClinicStayRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicStayRadioItem2();
    }
    return medicalFacilityClinicStayRadioItem2;

  }

  /**
   * 初期加算を取得します。
   * @return 初期加算
   */
  public ACClearableRadioButtonGroup getMedicalFacilityClinicStandardRadio(){
    if(medicalFacilityClinicStandardRadio==null){

      medicalFacilityClinicStandardRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityClinicStandardRadioContainer().setText("初期加算");

      medicalFacilityClinicStandardRadio.setBindPath("1530207");

      medicalFacilityClinicStandardRadio.setUseClearButton(false);

      medicalFacilityClinicStandardRadio.setModel(getMedicalFacilityClinicStandardRadioModel());

      addMedicalFacilityClinicStandardRadio();
    }
    return medicalFacilityClinicStandardRadio;

  }

  /**
   * 初期加算コンテナを取得します。
   * @return 初期加算コンテナ
   */
  protected ACLabelContainer getMedicalFacilityClinicStandardRadioContainer(){
    if(medicalFacilityClinicStandardRadioContainer==null){
      medicalFacilityClinicStandardRadioContainer = new ACLabelContainer();
      medicalFacilityClinicStandardRadioContainer.setFollowChildEnabled(true);
      medicalFacilityClinicStandardRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityClinicStandardRadioContainer.add(getMedicalFacilityClinicStandardRadio(), null);
    }
    return medicalFacilityClinicStandardRadioContainer;
  }

  /**
   * 初期加算モデルを取得します。
   * @return 初期加算モデル
   */
  protected ACListModelAdapter getMedicalFacilityClinicStandardRadioModel(){
    if(medicalFacilityClinicStandardRadioModel==null){
      medicalFacilityClinicStandardRadioModel = new ACListModelAdapter();
      addMedicalFacilityClinicStandardRadioModel();
    }
    return medicalFacilityClinicStandardRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalFacilityClinicStandardRadioItem1(){
    if(medicalFacilityClinicStandardRadioItem1==null){

      medicalFacilityClinicStandardRadioItem1 = new ACRadioButtonItem();

      medicalFacilityClinicStandardRadioItem1.setText("なし");

      medicalFacilityClinicStandardRadioItem1.setGroup(getMedicalFacilityClinicStandardRadio());

      medicalFacilityClinicStandardRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicStandardRadioItem1();
    }
    return medicalFacilityClinicStandardRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalFacilityClinicStandardRadioItem2(){
    if(medicalFacilityClinicStandardRadioItem2==null){

      medicalFacilityClinicStandardRadioItem2 = new ACRadioButtonItem();

      medicalFacilityClinicStandardRadioItem2.setText("あり");

      medicalFacilityClinicStandardRadioItem2.setGroup(getMedicalFacilityClinicStandardRadio());

      medicalFacilityClinicStandardRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicStandardRadioItem2();
    }
    return medicalFacilityClinicStandardRadioItem2;

  }

  /**
   * 他科受診を取得します。
   * @return 他科受診
   */
  public ACClearableRadioButtonGroup getMedicalFacilityClinicMedicalExaminationRadio(){
    if(medicalFacilityClinicMedicalExaminationRadio==null){

      medicalFacilityClinicMedicalExaminationRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityClinicMedicalExaminationRadioContainer().setText("他科受診加算");

      medicalFacilityClinicMedicalExaminationRadio.setBindPath("1530208");

      medicalFacilityClinicMedicalExaminationRadio.setUseClearButton(false);

      medicalFacilityClinicMedicalExaminationRadio.setModel(getMedicalFacilityClinicMedicalExaminationRadioModel());

      addMedicalFacilityClinicMedicalExaminationRadio();
    }
    return medicalFacilityClinicMedicalExaminationRadio;

  }

  /**
   * 他科受診コンテナを取得します。
   * @return 他科受診コンテナ
   */
  protected ACLabelContainer getMedicalFacilityClinicMedicalExaminationRadioContainer(){
    if(medicalFacilityClinicMedicalExaminationRadioContainer==null){
      medicalFacilityClinicMedicalExaminationRadioContainer = new ACLabelContainer();
      medicalFacilityClinicMedicalExaminationRadioContainer.setFollowChildEnabled(true);
      medicalFacilityClinicMedicalExaminationRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityClinicMedicalExaminationRadioContainer.add(getMedicalFacilityClinicMedicalExaminationRadio(), null);
    }
    return medicalFacilityClinicMedicalExaminationRadioContainer;
  }

  /**
   * 他科受診モデルを取得します。
   * @return 他科受診モデル
   */
  protected ACListModelAdapter getMedicalFacilityClinicMedicalExaminationRadioModel(){
    if(medicalFacilityClinicMedicalExaminationRadioModel==null){
      medicalFacilityClinicMedicalExaminationRadioModel = new ACListModelAdapter();
      addMedicalFacilityClinicMedicalExaminationRadioModel();
    }
    return medicalFacilityClinicMedicalExaminationRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalFacilityClinicMedicalExaminationRadioItem1(){
    if(medicalFacilityClinicMedicalExaminationRadioItem1==null){

      medicalFacilityClinicMedicalExaminationRadioItem1 = new ACRadioButtonItem();

      medicalFacilityClinicMedicalExaminationRadioItem1.setText("なし");

      medicalFacilityClinicMedicalExaminationRadioItem1.setGroup(getMedicalFacilityClinicMedicalExaminationRadio());

      medicalFacilityClinicMedicalExaminationRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicMedicalExaminationRadioItem1();
    }
    return medicalFacilityClinicMedicalExaminationRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalFacilityClinicMedicalExaminationRadioItem2(){
    if(medicalFacilityClinicMedicalExaminationRadioItem2==null){

      medicalFacilityClinicMedicalExaminationRadioItem2 = new ACRadioButtonItem();

      medicalFacilityClinicMedicalExaminationRadioItem2.setText("あり");

      medicalFacilityClinicMedicalExaminationRadioItem2.setGroup(getMedicalFacilityClinicMedicalExaminationRadio());

      medicalFacilityClinicMedicalExaminationRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicMedicalExaminationRadioItem2();
    }
    return medicalFacilityClinicMedicalExaminationRadioItem2;

  }

  /**
   * 栄養管理体制加算を取得します。
   * @return 栄養管理体制加算
   */
  public ACClearableRadioButtonGroup getMedicalFacilityClinicNutritionManageRadio(){
    if(medicalFacilityClinicNutritionManageRadio==null){

      medicalFacilityClinicNutritionManageRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityClinicNutritionManageRadioContainer().setText("栄養管理体制加算");

      medicalFacilityClinicNutritionManageRadio.setBindPath("1530209");

      medicalFacilityClinicNutritionManageRadio.setUseClearButton(false);

      medicalFacilityClinicNutritionManageRadio.setModel(getMedicalFacilityClinicNutritionManageRadioModel());

      addMedicalFacilityClinicNutritionManageRadio();
    }
    return medicalFacilityClinicNutritionManageRadio;

  }

  /**
   * 栄養管理体制加算コンテナを取得します。
   * @return 栄養管理体制加算コンテナ
   */
  protected ACLabelContainer getMedicalFacilityClinicNutritionManageRadioContainer(){
    if(medicalFacilityClinicNutritionManageRadioContainer==null){
      medicalFacilityClinicNutritionManageRadioContainer = new ACLabelContainer();
      medicalFacilityClinicNutritionManageRadioContainer.setFollowChildEnabled(true);
      medicalFacilityClinicNutritionManageRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityClinicNutritionManageRadioContainer.add(getMedicalFacilityClinicNutritionManageRadio(), null);
    }
    return medicalFacilityClinicNutritionManageRadioContainer;
  }

  /**
   * 栄養管理体制加算モデルを取得します。
   * @return 栄養管理体制加算モデル
   */
  protected ACListModelAdapter getMedicalFacilityClinicNutritionManageRadioModel(){
    if(medicalFacilityClinicNutritionManageRadioModel==null){
      medicalFacilityClinicNutritionManageRadioModel = new ACListModelAdapter();
      addMedicalFacilityClinicNutritionManageRadioModel();
    }
    return medicalFacilityClinicNutritionManageRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalFacilityClinicNutritionManageRadioItem1(){
    if(medicalFacilityClinicNutritionManageRadioItem1==null){

      medicalFacilityClinicNutritionManageRadioItem1 = new ACRadioButtonItem();

      medicalFacilityClinicNutritionManageRadioItem1.setText("なし");

      medicalFacilityClinicNutritionManageRadioItem1.setGroup(getMedicalFacilityClinicNutritionManageRadio());

      medicalFacilityClinicNutritionManageRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicNutritionManageRadioItem1();
    }
    return medicalFacilityClinicNutritionManageRadioItem1;

  }

  /**
   * 管理栄養士を取得します。
   * @return 管理栄養士
   */
  public ACRadioButtonItem getMedicalFacilityClinicNutritionManageRadioItem2(){
    if(medicalFacilityClinicNutritionManageRadioItem2==null){

      medicalFacilityClinicNutritionManageRadioItem2 = new ACRadioButtonItem();

      medicalFacilityClinicNutritionManageRadioItem2.setText("管理栄養士");

      medicalFacilityClinicNutritionManageRadioItem2.setGroup(getMedicalFacilityClinicNutritionManageRadio());

      medicalFacilityClinicNutritionManageRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addMedicalFacilityClinicNutritionManageRadioItem2();
    }
    return medicalFacilityClinicNutritionManageRadioItem2;

  }

  /**
   * 栄養士を取得します。
   * @return 栄養士
   */
  public ACRadioButtonItem getMedicalFacilityClinicNutritionManageRadioItem3(){
    if(medicalFacilityClinicNutritionManageRadioItem3==null){

      medicalFacilityClinicNutritionManageRadioItem3 = new ACRadioButtonItem();

      medicalFacilityClinicNutritionManageRadioItem3.setText("栄養士");

      medicalFacilityClinicNutritionManageRadioItem3.setGroup(getMedicalFacilityClinicNutritionManageRadio());

      medicalFacilityClinicNutritionManageRadioItem3.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicNutritionManageRadioItem3();
    }
    return medicalFacilityClinicNutritionManageRadioItem3;

  }

  /**
   * 栄養マネジメント加算を取得します。
   * @return 栄養マネジメント加算
   */
  public ACClearableRadioButtonGroup getMedicalFacilityClinicNutritionRadio(){
    if(medicalFacilityClinicNutritionRadio==null){

      medicalFacilityClinicNutritionRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityClinicNutritionRadioContainer().setText("栄養マネジメント加算");

      medicalFacilityClinicNutritionRadio.setBindPath("1530210");

      medicalFacilityClinicNutritionRadio.setUseClearButton(false);

      medicalFacilityClinicNutritionRadio.setModel(getMedicalFacilityClinicNutritionRadioModel());

      addMedicalFacilityClinicNutritionRadio();
    }
    return medicalFacilityClinicNutritionRadio;

  }

  /**
   * 栄養マネジメント加算コンテナを取得します。
   * @return 栄養マネジメント加算コンテナ
   */
  protected ACLabelContainer getMedicalFacilityClinicNutritionRadioContainer(){
    if(medicalFacilityClinicNutritionRadioContainer==null){
      medicalFacilityClinicNutritionRadioContainer = new ACLabelContainer();
      medicalFacilityClinicNutritionRadioContainer.setFollowChildEnabled(true);
      medicalFacilityClinicNutritionRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityClinicNutritionRadioContainer.add(getMedicalFacilityClinicNutritionRadio(), null);
    }
    return medicalFacilityClinicNutritionRadioContainer;
  }

  /**
   * 栄養マネジメント加算モデルを取得します。
   * @return 栄養マネジメント加算モデル
   */
  protected ACListModelAdapter getMedicalFacilityClinicNutritionRadioModel(){
    if(medicalFacilityClinicNutritionRadioModel==null){
      medicalFacilityClinicNutritionRadioModel = new ACListModelAdapter();
      addMedicalFacilityClinicNutritionRadioModel();
    }
    return medicalFacilityClinicNutritionRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalFacilityClinicNutritionRadioItem1(){
    if(medicalFacilityClinicNutritionRadioItem1==null){

      medicalFacilityClinicNutritionRadioItem1 = new ACRadioButtonItem();

      medicalFacilityClinicNutritionRadioItem1.setText("なし");

      medicalFacilityClinicNutritionRadioItem1.setGroup(getMedicalFacilityClinicNutritionRadio());

      medicalFacilityClinicNutritionRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicNutritionRadioItem1();
    }
    return medicalFacilityClinicNutritionRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalFacilityClinicNutritionRadioItem2(){
    if(medicalFacilityClinicNutritionRadioItem2==null){

      medicalFacilityClinicNutritionRadioItem2 = new ACRadioButtonItem();

      medicalFacilityClinicNutritionRadioItem2.setText("あり");

      medicalFacilityClinicNutritionRadioItem2.setGroup(getMedicalFacilityClinicNutritionRadio());

      medicalFacilityClinicNutritionRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicNutritionRadioItem2();
    }
    return medicalFacilityClinicNutritionRadioItem2;

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
   * 経口移行加算を取得します。
   * @return 経口移行加算
   */
  public ACClearableRadioButtonGroup getMedicalFacilityClinicOralSwitchRadio(){
    if(medicalFacilityClinicOralSwitchRadio==null){

      medicalFacilityClinicOralSwitchRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityClinicOralSwitchRadioContainer().setText("経口移行加算");

      medicalFacilityClinicOralSwitchRadio.setBindPath("1530211");

      medicalFacilityClinicOralSwitchRadio.setUseClearButton(false);

      medicalFacilityClinicOralSwitchRadio.setModel(getMedicalFacilityClinicOralSwitchRadioModel());

      addMedicalFacilityClinicOralSwitchRadio();
    }
    return medicalFacilityClinicOralSwitchRadio;

  }

  /**
   * 経口移行加算コンテナを取得します。
   * @return 経口移行加算コンテナ
   */
  protected ACLabelContainer getMedicalFacilityClinicOralSwitchRadioContainer(){
    if(medicalFacilityClinicOralSwitchRadioContainer==null){
      medicalFacilityClinicOralSwitchRadioContainer = new ACLabelContainer();
      medicalFacilityClinicOralSwitchRadioContainer.setFollowChildEnabled(true);
      medicalFacilityClinicOralSwitchRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityClinicOralSwitchRadioContainer.add(getMedicalFacilityClinicOralSwitchRadio(), null);
    }
    return medicalFacilityClinicOralSwitchRadioContainer;
  }

  /**
   * 経口移行加算モデルを取得します。
   * @return 経口移行加算モデル
   */
  protected ACListModelAdapter getMedicalFacilityClinicOralSwitchRadioModel(){
    if(medicalFacilityClinicOralSwitchRadioModel==null){
      medicalFacilityClinicOralSwitchRadioModel = new ACListModelAdapter();
      addMedicalFacilityClinicOralSwitchRadioModel();
    }
    return medicalFacilityClinicOralSwitchRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalFacilityClinicOralSwitchRadioItem1(){
    if(medicalFacilityClinicOralSwitchRadioItem1==null){

      medicalFacilityClinicOralSwitchRadioItem1 = new ACRadioButtonItem();

      medicalFacilityClinicOralSwitchRadioItem1.setText("なし");

      medicalFacilityClinicOralSwitchRadioItem1.setGroup(getMedicalFacilityClinicOralSwitchRadio());

      medicalFacilityClinicOralSwitchRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicOralSwitchRadioItem1();
    }
    return medicalFacilityClinicOralSwitchRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalFacilityClinicOralSwitchRadioItem2(){
    if(medicalFacilityClinicOralSwitchRadioItem2==null){

      medicalFacilityClinicOralSwitchRadioItem2 = new ACRadioButtonItem();

      medicalFacilityClinicOralSwitchRadioItem2.setText("あり");

      medicalFacilityClinicOralSwitchRadioItem2.setGroup(getMedicalFacilityClinicOralSwitchRadio());

      medicalFacilityClinicOralSwitchRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicOralSwitchRadioItem2();
    }
    return medicalFacilityClinicOralSwitchRadioItem2;

  }

  /**
   * 経口維持加算を取得します。
   * @return 経口維持加算
   */
  public ACClearableRadioButtonGroup getOralMaintenanceAddRadio(){
    if(oralMaintenanceAddRadio==null){

      oralMaintenanceAddRadio = new ACClearableRadioButtonGroup();

      getOralMaintenanceAddRadioContainer().setText("経口維持加算");

      oralMaintenanceAddRadio.setBindPath("1530213");

      oralMaintenanceAddRadio.setUseClearButton(false);

      oralMaintenanceAddRadio.setModel(getOralMaintenanceAddRadioModel());

      addOralMaintenanceAddRadio();
    }
    return oralMaintenanceAddRadio;

  }

  /**
   * 経口維持加算コンテナを取得します。
   * @return 経口維持加算コンテナ
   */
  protected ACLabelContainer getOralMaintenanceAddRadioContainer(){
    if(oralMaintenanceAddRadioContainer==null){
      oralMaintenanceAddRadioContainer = new ACLabelContainer();
      oralMaintenanceAddRadioContainer.setFollowChildEnabled(true);
      oralMaintenanceAddRadioContainer.setVAlignment(VRLayout.CENTER);
      oralMaintenanceAddRadioContainer.add(getOralMaintenanceAddRadio(), null);
    }
    return oralMaintenanceAddRadioContainer;
  }

  /**
   * 経口維持加算モデルを取得します。
   * @return 経口維持加算モデル
   */
  protected ACListModelAdapter getOralMaintenanceAddRadioModel(){
    if(oralMaintenanceAddRadioModel==null){
      oralMaintenanceAddRadioModel = new ACListModelAdapter();
      addOralMaintenanceAddRadioModel();
    }
    return oralMaintenanceAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getOralMaintenanceAddRadioItem1(){
    if(oralMaintenanceAddRadioItem1==null){

      oralMaintenanceAddRadioItem1 = new ACRadioButtonItem();

      oralMaintenanceAddRadioItem1.setText("なし");

      oralMaintenanceAddRadioItem1.setGroup(getOralMaintenanceAddRadio());

      oralMaintenanceAddRadioItem1.setConstraints(VRLayout.FLOW);

      addOralMaintenanceAddRadioItem1();
    }
    return oralMaintenanceAddRadioItem1;

  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getOralMaintenanceAddRadioItem2(){
    if(oralMaintenanceAddRadioItem2==null){

      oralMaintenanceAddRadioItem2 = new ACRadioButtonItem();

      oralMaintenanceAddRadioItem2.setText("I型");

      oralMaintenanceAddRadioItem2.setGroup(getOralMaintenanceAddRadio());

      oralMaintenanceAddRadioItem2.setConstraints(VRLayout.FLOW);

      addOralMaintenanceAddRadioItem2();
    }
    return oralMaintenanceAddRadioItem2;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getOralMaintenanceAddRadioItem3(){
    if(oralMaintenanceAddRadioItem3==null){

      oralMaintenanceAddRadioItem3 = new ACRadioButtonItem();

      oralMaintenanceAddRadioItem3.setText("II型");

      oralMaintenanceAddRadioItem3.setGroup(getOralMaintenanceAddRadio());

      oralMaintenanceAddRadioItem3.setConstraints(VRLayout.FLOW);

      addOralMaintenanceAddRadioItem3();
    }
    return oralMaintenanceAddRadioItem3;

  }

  /**
   * 療養食加算を取得します。
   * @return 療養食加算
   */
  public ACClearableRadioButtonGroup getMedicalFacilityClinicRecuperateDinnerRadio(){
    if(medicalFacilityClinicRecuperateDinnerRadio==null){

      medicalFacilityClinicRecuperateDinnerRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityClinicRecuperateDinnerRadioContainer().setText("療養食加算");

      medicalFacilityClinicRecuperateDinnerRadio.setBindPath("1530212");

      medicalFacilityClinicRecuperateDinnerRadio.setUseClearButton(false);

      medicalFacilityClinicRecuperateDinnerRadio.setModel(getMedicalFacilityClinicRecuperateDinnerRadioModel());

      addMedicalFacilityClinicRecuperateDinnerRadio();
    }
    return medicalFacilityClinicRecuperateDinnerRadio;

  }

  /**
   * 療養食加算コンテナを取得します。
   * @return 療養食加算コンテナ
   */
  protected ACLabelContainer getMedicalFacilityClinicRecuperateDinnerRadioContainer(){
    if(medicalFacilityClinicRecuperateDinnerRadioContainer==null){
      medicalFacilityClinicRecuperateDinnerRadioContainer = new ACLabelContainer();
      medicalFacilityClinicRecuperateDinnerRadioContainer.setFollowChildEnabled(true);
      medicalFacilityClinicRecuperateDinnerRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityClinicRecuperateDinnerRadioContainer.add(getMedicalFacilityClinicRecuperateDinnerRadio(), null);
    }
    return medicalFacilityClinicRecuperateDinnerRadioContainer;
  }

  /**
   * 療養食加算モデルを取得します。
   * @return 療養食加算モデル
   */
  protected ACListModelAdapter getMedicalFacilityClinicRecuperateDinnerRadioModel(){
    if(medicalFacilityClinicRecuperateDinnerRadioModel==null){
      medicalFacilityClinicRecuperateDinnerRadioModel = new ACListModelAdapter();
      addMedicalFacilityClinicRecuperateDinnerRadioModel();
    }
    return medicalFacilityClinicRecuperateDinnerRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalFacilityClinicRecuperateDinnerRadioItem1(){
    if(medicalFacilityClinicRecuperateDinnerRadioItem1==null){

      medicalFacilityClinicRecuperateDinnerRadioItem1 = new ACRadioButtonItem();

      medicalFacilityClinicRecuperateDinnerRadioItem1.setText("なし");

      medicalFacilityClinicRecuperateDinnerRadioItem1.setGroup(getMedicalFacilityClinicRecuperateDinnerRadio());

      medicalFacilityClinicRecuperateDinnerRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicRecuperateDinnerRadioItem1();
    }
    return medicalFacilityClinicRecuperateDinnerRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalFacilityClinicRecuperateDinnerRadioItem2(){
    if(medicalFacilityClinicRecuperateDinnerRadioItem2==null){

      medicalFacilityClinicRecuperateDinnerRadioItem2 = new ACRadioButtonItem();

      medicalFacilityClinicRecuperateDinnerRadioItem2.setText("あり");

      medicalFacilityClinicRecuperateDinnerRadioItem2.setGroup(getMedicalFacilityClinicRecuperateDinnerRadio());

      medicalFacilityClinicRecuperateDinnerRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicRecuperateDinnerRadioItem2();
    }
    return medicalFacilityClinicRecuperateDinnerRadioItem2;

  }

  /**
   * 退所関連加算を取得します。
   * @return 退所関連加算
   */
  public ACLabelContainer getMedicalFacilityClinicHijoAddition(){
    if(medicalFacilityClinicHijoAddition==null){

      medicalFacilityClinicHijoAddition = new ACLabelContainer();

      medicalFacilityClinicHijoAddition.setText("退院関連加算");

      addMedicalFacilityClinicHijoAddition();
    }
    return medicalFacilityClinicHijoAddition;

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
   * 特定診療費を取得します。
   * @return 特定診療費
   */
  public ACMapBindButton getMedicalFacilityClinicConsultationFee(){
    if(medicalFacilityClinicConsultationFee==null){

      medicalFacilityClinicConsultationFee = new ACMapBindButton();

      medicalFacilityClinicConsultationFee.setText("特定診療費");

      medicalFacilityClinicConsultationFee.setToolTipText("特定診療費を設定します。");

      addMedicalFacilityClinicConsultationFee();
    }
    return medicalFacilityClinicConsultationFee;

  }

  /**
   * ラベルを取得します。
   * @return ラベル
   */
  public ACLabel getMedicalFacilityClinicConsultationFeeLabel(){
    if(medicalFacilityClinicConsultationFeeLabel==null){

      medicalFacilityClinicConsultationFeeLabel = new ACLabel();

      medicalFacilityClinicConsultationFeeLabel.setText("設定なし");

      medicalFacilityClinicConsultationFeeLabel.setOpaque(true);
      medicalFacilityClinicConsultationFeeLabel.setBackground(new Color(255,255,172));

      addMedicalFacilityClinicConsultationFeeLabel();
    }
    return medicalFacilityClinicConsultationFeeLabel;

  }

  /**
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACClearableRadioButtonGroup getMedicalFacilityClinicSubstractionRadio(){
    if(medicalFacilityClinicSubstractionRadio==null){

      medicalFacilityClinicSubstractionRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityClinicSubstractionRadioContainer().setText("人員減算");

      medicalFacilityClinicSubstractionRadio.setBindPath("1530256");

      medicalFacilityClinicSubstractionRadio.setUseClearButton(false);

      medicalFacilityClinicSubstractionRadio.setModel(getMedicalFacilityClinicSubstractionRadioModel());

      addMedicalFacilityClinicSubstractionRadio();
    }
    return medicalFacilityClinicSubstractionRadio;

  }

  /**
   * 人員減算コンテナを取得します。
   * @return 人員減算コンテナ
   */
  protected ACLabelContainer getMedicalFacilityClinicSubstractionRadioContainer(){
    if(medicalFacilityClinicSubstractionRadioContainer==null){
      medicalFacilityClinicSubstractionRadioContainer = new ACLabelContainer();
      medicalFacilityClinicSubstractionRadioContainer.setFollowChildEnabled(true);
      medicalFacilityClinicSubstractionRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityClinicSubstractionRadioContainer.add(getMedicalFacilityClinicSubstractionRadio(), null);
    }
    return medicalFacilityClinicSubstractionRadioContainer;
  }

  /**
   * 人員減算モデルを取得します。
   * @return 人員減算モデル
   */
  protected ACListModelAdapter getMedicalFacilityClinicSubstractionRadioModel(){
    if(medicalFacilityClinicSubstractionRadioModel==null){
      medicalFacilityClinicSubstractionRadioModel = new ACListModelAdapter();
      addMedicalFacilityClinicSubstractionRadioModel();
    }
    return medicalFacilityClinicSubstractionRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalFacilityClinicSubstractionRadioItem1(){
    if(medicalFacilityClinicSubstractionRadioItem1==null){

      medicalFacilityClinicSubstractionRadioItem1 = new ACRadioButtonItem();

      medicalFacilityClinicSubstractionRadioItem1.setText("なし");

      medicalFacilityClinicSubstractionRadioItem1.setGroup(getMedicalFacilityClinicSubstractionRadio());

      medicalFacilityClinicSubstractionRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicSubstractionRadioItem1();
    }
    return medicalFacilityClinicSubstractionRadioItem1;

  }

  /**
   * 定員超過を取得します。
   * @return 定員超過
   */
  public ACRadioButtonItem getMedicalFacilityClinicSubstractionRadioItem2(){
    if(medicalFacilityClinicSubstractionRadioItem2==null){

      medicalFacilityClinicSubstractionRadioItem2 = new ACRadioButtonItem();

      medicalFacilityClinicSubstractionRadioItem2.setText("定員超過");

      medicalFacilityClinicSubstractionRadioItem2.setGroup(getMedicalFacilityClinicSubstractionRadio());

      medicalFacilityClinicSubstractionRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicSubstractionRadioItem2();
    }
    return medicalFacilityClinicSubstractionRadioItem2;

  }

  /**
   * 食事コンテナを取得します。
   * @return 食事コンテナ
   */
  public ACBackLabelContainer getMedicalFacilityClinicDinnerContainer(){
    if(medicalFacilityClinicDinnerContainer==null){

      medicalFacilityClinicDinnerContainer = new ACBackLabelContainer();

      addMedicalFacilityClinicDinnerContainer();
    }
    return medicalFacilityClinicDinnerContainer;

  }

  /**
   * 食事提供を取得します。
   * @return 食事提供
   */
  public ACComboBox getMedicalFacilityClinicDinnerOffer(){
    if(medicalFacilityClinicDinnerOffer==null){

      medicalFacilityClinicDinnerOffer = new ACComboBox();

      getMedicalFacilityClinicDinnerOfferContainer().setText("食事提供");

      medicalFacilityClinicDinnerOffer.setBindPath("1530257");

      medicalFacilityClinicDinnerOffer.setEditable(false);

      medicalFacilityClinicDinnerOffer.setModelBindPath("1530257");

      medicalFacilityClinicDinnerOffer.setRenderBindPath("CONTENT");

      medicalFacilityClinicDinnerOffer.setModel(getMedicalFacilityClinicDinnerOfferModel());

      addMedicalFacilityClinicDinnerOffer();
    }
    return medicalFacilityClinicDinnerOffer;

  }

  /**
   * 食事提供コンテナを取得します。
   * @return 食事提供コンテナ
   */
  protected ACLabelContainer getMedicalFacilityClinicDinnerOfferContainer(){
    if(medicalFacilityClinicDinnerOfferContainer==null){
      medicalFacilityClinicDinnerOfferContainer = new ACLabelContainer();
      medicalFacilityClinicDinnerOfferContainer.setFollowChildEnabled(true);
      medicalFacilityClinicDinnerOfferContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityClinicDinnerOfferContainer.add(getMedicalFacilityClinicDinnerOffer(), null);
    }
    return medicalFacilityClinicDinnerOfferContainer;
  }

  /**
   * 食事提供モデルを取得します。
   * @return 食事提供モデル
   */
  protected ACComboBoxModelAdapter getMedicalFacilityClinicDinnerOfferModel(){
    if(medicalFacilityClinicDinnerOfferModel==null){
      medicalFacilityClinicDinnerOfferModel = new ACComboBoxModelAdapter();
      addMedicalFacilityClinicDinnerOfferModel();
    }
    return medicalFacilityClinicDinnerOfferModel;
  }

  /**
   * 食事費用を取得します。
   * @return 食事費用
   */
  public ACTextField getMedicalFacilityClinicDinnerCost(){
    if(medicalFacilityClinicDinnerCost==null){

      medicalFacilityClinicDinnerCost = new ACTextField();

      getMedicalFacilityClinicDinnerCostContainer().setText("食事費用");

      medicalFacilityClinicDinnerCost.setBindPath("1530259");

      medicalFacilityClinicDinnerCost.setColumns(4);

      medicalFacilityClinicDinnerCost.setCharType(VRCharType.ONLY_DIGIT);

      medicalFacilityClinicDinnerCost.setHorizontalAlignment(SwingConstants.RIGHT);

      medicalFacilityClinicDinnerCost.setIMEMode(InputSubset.LATIN);

      medicalFacilityClinicDinnerCost.setMaxLength(5);

      addMedicalFacilityClinicDinnerCost();
    }
    return medicalFacilityClinicDinnerCost;

  }

  /**
   * 食事費用コンテナを取得します。
   * @return 食事費用コンテナ
   */
  protected ACLabelContainer getMedicalFacilityClinicDinnerCostContainer(){
    if(medicalFacilityClinicDinnerCostContainer==null){
      medicalFacilityClinicDinnerCostContainer = new ACLabelContainer();
      medicalFacilityClinicDinnerCostContainer.setFollowChildEnabled(true);
      medicalFacilityClinicDinnerCostContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityClinicDinnerCostContainer.add(getMedicalFacilityClinicDinnerCost(), null);
    }
    return medicalFacilityClinicDinnerCostContainer;
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
   * ユニットケアの整備を取得します。
   * @return ユニットケアの整備
   */
  public ACClearableRadioButtonGroup getUnitCareMaintenanceRadio(){
    if(unitCareMaintenanceRadio==null){

      unitCareMaintenanceRadio = new ACClearableRadioButtonGroup();

      getUnitCareMaintenanceRadioContainer().setText("ユニットケアの整備");

      unitCareMaintenanceRadio.setBindPath("1530214");

      unitCareMaintenanceRadio.setUseClearButton(false);

      unitCareMaintenanceRadio.setModel(getUnitCareMaintenanceRadioModel());

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

      bodyRestraintAbolitionRadio.setBindPath("1530215");

      bodyRestraintAbolitionRadio.setUseClearButton(false);

      bodyRestraintAbolitionRadio.setModel(getBodyRestraintAbolitionRadioModel());

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

      stayReturnSupportAddRadio.setBindPath("1530216");

      stayReturnSupportAddRadio.setUseClearButton(false);

      stayReturnSupportAddRadio.setModel(getStayReturnSupportAddRadioModel());

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
   * 算定区分を取得します。
   * @return 算定区分
   */
  public ACClearableRadioButtonGroup getMedicalFacilityClinicCalculationDivisionRadio(){
    if(medicalFacilityClinicCalculationDivisionRadio==null){

      medicalFacilityClinicCalculationDivisionRadio = new ACClearableRadioButtonGroup();

      getMedicalFacilityClinicCalculationDivisionRadioContainer().setText("算定区分");

      medicalFacilityClinicCalculationDivisionRadio.setBindPath("9");

      medicalFacilityClinicCalculationDivisionRadio.setUseClearButton(false);

      medicalFacilityClinicCalculationDivisionRadio.setModel(getMedicalFacilityClinicCalculationDivisionRadioModel());

      addMedicalFacilityClinicCalculationDivisionRadio();
    }
    return medicalFacilityClinicCalculationDivisionRadio;

  }

  /**
   * 算定区分コンテナを取得します。
   * @return 算定区分コンテナ
   */
  protected ACLabelContainer getMedicalFacilityClinicCalculationDivisionRadioContainer(){
    if(medicalFacilityClinicCalculationDivisionRadioContainer==null){
      medicalFacilityClinicCalculationDivisionRadioContainer = new ACLabelContainer();
      medicalFacilityClinicCalculationDivisionRadioContainer.setFollowChildEnabled(true);
      medicalFacilityClinicCalculationDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityClinicCalculationDivisionRadioContainer.add(getMedicalFacilityClinicCalculationDivisionRadio(), null);
    }
    return medicalFacilityClinicCalculationDivisionRadioContainer;
  }

  /**
   * 算定区分モデルを取得します。
   * @return 算定区分モデル
   */
  protected ACListModelAdapter getMedicalFacilityClinicCalculationDivisionRadioModel(){
    if(medicalFacilityClinicCalculationDivisionRadioModel==null){
      medicalFacilityClinicCalculationDivisionRadioModel = new ACListModelAdapter();
      addMedicalFacilityClinicCalculationDivisionRadioModel();
    }
    return medicalFacilityClinicCalculationDivisionRadioModel;
  }

  /**
   * 通常を取得します。
   * @return 通常
   */
  public ACRadioButtonItem getMedicalFacilityClinicCalculationDivisionRadioItem1(){
    if(medicalFacilityClinicCalculationDivisionRadioItem1==null){

      medicalFacilityClinicCalculationDivisionRadioItem1 = new ACRadioButtonItem();

      medicalFacilityClinicCalculationDivisionRadioItem1.setText("通常");

      medicalFacilityClinicCalculationDivisionRadioItem1.setGroup(getMedicalFacilityClinicCalculationDivisionRadio());

      medicalFacilityClinicCalculationDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicCalculationDivisionRadioItem1();
    }
    return medicalFacilityClinicCalculationDivisionRadioItem1;

  }

  /**
   * 加算のみを取得します。
   * @return 加算のみ
   */
  public ACRadioButtonItem getMedicalFacilityClinicCalculationDivisionRadioItem2(){
    if(medicalFacilityClinicCalculationDivisionRadioItem2==null){

      medicalFacilityClinicCalculationDivisionRadioItem2 = new ACRadioButtonItem();

      medicalFacilityClinicCalculationDivisionRadioItem2.setText("加算のみ");

      medicalFacilityClinicCalculationDivisionRadioItem2.setGroup(getMedicalFacilityClinicCalculationDivisionRadio());

      medicalFacilityClinicCalculationDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalFacilityClinicCalculationDivisionRadioItem2();
    }
    return medicalFacilityClinicCalculationDivisionRadioItem2;

  }

  /**
   * コンストラクタです。
   */
  public QS001121_H2004Design() {

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

    tab1.add(getMedicalFacilityClinicInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityClinicDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityClinicHospitalRoomContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityClinicEnvironmentalRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityClinicProvisionBaseRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityClinicStayRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityClinicStandardRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityClinicMedicalExaminationRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityClinicNutritionManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMedicalFacilityClinicNutritionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 施設等の区分に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicInstitutionDivisionRadio(){

  }

  /**
   * 施設等の区分モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicInstitutionDivisionRadioModel(){

    getMedicalFacilityClinicInstitutionDivisionRadioItem1().setButtonIndex(1);

    getMedicalFacilityClinicInstitutionDivisionRadioModel().add(getMedicalFacilityClinicInstitutionDivisionRadioItem1());

    getMedicalFacilityClinicInstitutionDivisionRadioItem2().setButtonIndex(2);

    getMedicalFacilityClinicInstitutionDivisionRadioModel().add(getMedicalFacilityClinicInstitutionDivisionRadioItem2());

  }

  /**
   * 診療所に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicInstitutionDivisionRadioItem1(){

  }

  /**
   * ユニット型診療所に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicInstitutionDivisionRadioItem2(){

  }

  /**
   * 人員配置区分に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicDivision(){

  }

  /**
   * 人員配置区分モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicDivisionModel(){

    getMedicalFacilityClinicDivision1().setButtonIndex(1);

    getMedicalFacilityClinicDivisionModel().add(getMedicalFacilityClinicDivision1());

    getMedicalFacilityClinicDivision2().setButtonIndex(2);

    getMedicalFacilityClinicDivisionModel().add(getMedicalFacilityClinicDivision2());

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicDivision1(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicDivision2(){

  }

  /**
   * 病室区分コンテナに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicHospitalRoomContena(){

    medicalFacilityClinicHospitalRoomContena.add(getMedicalFacilityClinicHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalFacilityClinicHospitalRoomContena.add(getMedicalFacilityClinicUnitHospitalRoomRadio(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 病室区分（病院）に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicHospitalRoomRadio(){

  }

  /**
   * 病室区分（病院）モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicHospitalRoomRadioModel(){

    getMedicalFacilityClinicHospitalRoomRadioItem1().setButtonIndex(1);

    getMedicalFacilityClinicHospitalRoomRadioModel().add(getMedicalFacilityClinicHospitalRoomRadioItem1());

    getMedicalFacilityClinicHospitalRoomRadioItem2().setButtonIndex(2);

    getMedicalFacilityClinicHospitalRoomRadioModel().add(getMedicalFacilityClinicHospitalRoomRadioItem2());

  }

  /**
   * 従来型個室に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicHospitalRoomRadioItem1(){

  }

  /**
   * 多床室に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicHospitalRoomRadioItem2(){

  }

  /**
   * 病室区分（ユニット型）に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicUnitHospitalRoomRadio(){

  }

  /**
   * 病室区分（ユニット型）モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicUnitHospitalRoomRadioModel(){

    getMedicalFacilityClinicUnitHospitalRoomRadioItem1().setButtonIndex(1);

    getMedicalFacilityClinicUnitHospitalRoomRadioModel().add(getMedicalFacilityClinicUnitHospitalRoomRadioItem1());

    getMedicalFacilityClinicUnitHospitalRoomRadioItem2().setButtonIndex(2);

    getMedicalFacilityClinicUnitHospitalRoomRadioModel().add(getMedicalFacilityClinicUnitHospitalRoomRadioItem2());

  }

  /**
   * ユニット型個室に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicUnitHospitalRoomRadioItem1(){

  }

  /**
   * ユニット型準個室に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicUnitHospitalRoomRadioItem2(){

  }

  /**
   * 療養環境基準に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicEnvironmentalRadio(){

  }

  /**
   * 療養環境基準モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicEnvironmentalRadioModel(){

    getMedicalFacilityClinicEnvironmentalRadioItem1().setButtonIndex(1);

    getMedicalFacilityClinicEnvironmentalRadioModel().add(getMedicalFacilityClinicEnvironmentalRadioItem1());

    getMedicalFacilityClinicEnvironmentalRadioItem3().setButtonIndex(3);

    getMedicalFacilityClinicEnvironmentalRadioModel().add(getMedicalFacilityClinicEnvironmentalRadioItem3());

  }

  /**
   * 基準型に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicEnvironmentalRadioItem1(){

  }

  /**
   * 減算IIに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicEnvironmentalRadioItem3(){

  }

  /**
   * 設備基準基準に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicProvisionBaseRadio(){

  }

  /**
   * 設備基準基準モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicProvisionBaseRadioModel(){

    getMedicalFacilityClinicProvisionBaseRadioItem1().setButtonIndex(1);

    getMedicalFacilityClinicProvisionBaseRadioModel().add(getMedicalFacilityClinicProvisionBaseRadioItem1());

    getMedicalFacilityClinicProvisionBaseRadioItem2().setButtonIndex(2);

    getMedicalFacilityClinicProvisionBaseRadioModel().add(getMedicalFacilityClinicProvisionBaseRadioItem2());

  }

  /**
   * 基準型に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicProvisionBaseRadioItem1(){

  }

  /**
   * 減算型に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicProvisionBaseRadioItem2(){

  }

  /**
   * 外泊加算に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicStayRadio(){

  }

  /**
   * 外泊加算モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicStayRadioModel(){

    getMedicalFacilityClinicStayRadioItem1().setButtonIndex(1);

    getMedicalFacilityClinicStayRadioModel().add(getMedicalFacilityClinicStayRadioItem1());

    getMedicalFacilityClinicStayRadioItem2().setButtonIndex(2);

    getMedicalFacilityClinicStayRadioModel().add(getMedicalFacilityClinicStayRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicStayRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicStayRadioItem2(){

  }

  /**
   * 初期加算に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicStandardRadio(){

  }

  /**
   * 初期加算モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicStandardRadioModel(){

    getMedicalFacilityClinicStandardRadioItem1().setButtonIndex(1);

    getMedicalFacilityClinicStandardRadioModel().add(getMedicalFacilityClinicStandardRadioItem1());

    getMedicalFacilityClinicStandardRadioItem2().setButtonIndex(2);

    getMedicalFacilityClinicStandardRadioModel().add(getMedicalFacilityClinicStandardRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicStandardRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicStandardRadioItem2(){

  }

  /**
   * 他科受診に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicMedicalExaminationRadio(){

  }

  /**
   * 他科受診モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicMedicalExaminationRadioModel(){

    getMedicalFacilityClinicMedicalExaminationRadioItem1().setButtonIndex(1);

    getMedicalFacilityClinicMedicalExaminationRadioModel().add(getMedicalFacilityClinicMedicalExaminationRadioItem1());

    getMedicalFacilityClinicMedicalExaminationRadioItem2().setButtonIndex(2);

    getMedicalFacilityClinicMedicalExaminationRadioModel().add(getMedicalFacilityClinicMedicalExaminationRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicMedicalExaminationRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicMedicalExaminationRadioItem2(){

  }

  /**
   * 栄養管理体制加算に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicNutritionManageRadio(){

  }

  /**
   * 栄養管理体制加算モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicNutritionManageRadioModel(){

    getMedicalFacilityClinicNutritionManageRadioItem1().setButtonIndex(1);

    getMedicalFacilityClinicNutritionManageRadioModel().add(getMedicalFacilityClinicNutritionManageRadioItem1());

    getMedicalFacilityClinicNutritionManageRadioItem2().setButtonIndex(2);

    getMedicalFacilityClinicNutritionManageRadioModel().add(getMedicalFacilityClinicNutritionManageRadioItem2());

    getMedicalFacilityClinicNutritionManageRadioItem3().setButtonIndex(3);

    getMedicalFacilityClinicNutritionManageRadioModel().add(getMedicalFacilityClinicNutritionManageRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicNutritionManageRadioItem1(){

  }

  /**
   * 管理栄養士に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicNutritionManageRadioItem2(){

  }

  /**
   * 栄養士に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicNutritionManageRadioItem3(){

  }

  /**
   * 栄養マネジメント加算に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicNutritionRadio(){

  }

  /**
   * 栄養マネジメント加算モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicNutritionRadioModel(){

    getMedicalFacilityClinicNutritionRadioItem1().setButtonIndex(1);

    getMedicalFacilityClinicNutritionRadioModel().add(getMedicalFacilityClinicNutritionRadioItem1());

    getMedicalFacilityClinicNutritionRadioItem2().setButtonIndex(2);

    getMedicalFacilityClinicNutritionRadioModel().add(getMedicalFacilityClinicNutritionRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicNutritionRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicNutritionRadioItem2(){

  }

  /**
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getMedicalFacilityClinicOralSwitchRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getOralMaintenanceAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityClinicRecuperateDinnerRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityClinicHijoAddition(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityClinicConsultationFee(), VRLayout.FLOW);

    tab2.add(getMedicalFacilityClinicConsultationFeeLabel(), VRLayout.FLOW_RETURN);

    tab2.add(getMedicalFacilityClinicSubstractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getMedicalFacilityClinicDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * 経口移行加算に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicOralSwitchRadio(){

  }

  /**
   * 経口移行加算モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicOralSwitchRadioModel(){

    getMedicalFacilityClinicOralSwitchRadioItem1().setButtonIndex(1);

    getMedicalFacilityClinicOralSwitchRadioModel().add(getMedicalFacilityClinicOralSwitchRadioItem1());

    getMedicalFacilityClinicOralSwitchRadioItem2().setButtonIndex(2);

    getMedicalFacilityClinicOralSwitchRadioModel().add(getMedicalFacilityClinicOralSwitchRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicOralSwitchRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicOralSwitchRadioItem2(){

  }

  /**
   * 経口維持加算に内部項目を追加します。
   */
  protected void addOralMaintenanceAddRadio(){

  }

  /**
   * 経口維持加算モデルに内部項目を追加します。
   */
  protected void addOralMaintenanceAddRadioModel(){

    getOralMaintenanceAddRadioItem1().setButtonIndex(1);

    getOralMaintenanceAddRadioModel().add(getOralMaintenanceAddRadioItem1());

    getOralMaintenanceAddRadioItem2().setButtonIndex(2);

    getOralMaintenanceAddRadioModel().add(getOralMaintenanceAddRadioItem2());

    getOralMaintenanceAddRadioItem3().setButtonIndex(3);

    getOralMaintenanceAddRadioModel().add(getOralMaintenanceAddRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addOralMaintenanceAddRadioItem1(){

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addOralMaintenanceAddRadioItem2(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addOralMaintenanceAddRadioItem3(){

  }

  /**
   * 療養食加算に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicRecuperateDinnerRadio(){

  }

  /**
   * 療養食加算モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicRecuperateDinnerRadioModel(){

    getMedicalFacilityClinicRecuperateDinnerRadioItem1().setButtonIndex(1);

    getMedicalFacilityClinicRecuperateDinnerRadioModel().add(getMedicalFacilityClinicRecuperateDinnerRadioItem1());

    getMedicalFacilityClinicRecuperateDinnerRadioItem2().setButtonIndex(2);

    getMedicalFacilityClinicRecuperateDinnerRadioModel().add(getMedicalFacilityClinicRecuperateDinnerRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicRecuperateDinnerRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicRecuperateDinnerRadioItem2(){

  }

  /**
   * 退所関連加算に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicHijoAddition(){

    medicalFacilityClinicHijoAddition.add(getLeavingHospitalPreConsultationAddition(), VRLayout.FLOW_RETURN);

    medicalFacilityClinicHijoAddition.add(getLeavingHospitalConsultationAddition(), VRLayout.FLOW_RETURN);

    medicalFacilityClinicHijoAddition.add(getLeavingHospitalDissemination(), VRLayout.FLOW_RETURN);

    medicalFacilityClinicHijoAddition.add(getLeavingHospitalCooperationAddition(), VRLayout.FLOW_RETURN);

    medicalFacilityClinicHijoAddition.add(getLeavingHospital(), VRLayout.FLOW_RETURN);

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
   * 特定診療費に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicConsultationFee(){

  }

  /**
   * ラベルに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicConsultationFeeLabel(){

  }

  /**
   * 人員減算に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicSubstractionRadio(){

  }

  /**
   * 人員減算モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicSubstractionRadioModel(){

    getMedicalFacilityClinicSubstractionRadioItem1().setButtonIndex(1);

    getMedicalFacilityClinicSubstractionRadioModel().add(getMedicalFacilityClinicSubstractionRadioItem1());

    getMedicalFacilityClinicSubstractionRadioItem2().setButtonIndex(2);

    getMedicalFacilityClinicSubstractionRadioModel().add(getMedicalFacilityClinicSubstractionRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicSubstractionRadioItem1(){

  }

  /**
   * 定員超過に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicSubstractionRadioItem2(){

  }

  /**
   * 食事コンテナに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicDinnerContainer(){

    medicalFacilityClinicDinnerContainer.add(getMedicalFacilityClinicDinnerOfferContainer(), VRLayout.FLOW);

    medicalFacilityClinicDinnerContainer.add(getMedicalFacilityClinicDinnerCostContainer(), VRLayout.FLOW);

  }

  /**
   * 食事提供に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicDinnerOffer(){

  }

  /**
   * 食事提供モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicDinnerOfferModel(){

  }

  /**
   * 食事費用に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicDinnerCost(){

  }

  /**
   * タブ3に内部項目を追加します。
   */
  protected void addTab3(){

    tab3.add(getUnitCareMaintenanceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getBodyRestraintAbolitionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getStayReturnSupportAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getMedicalFacilityClinicCalculationDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * 算定区分に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicCalculationDivisionRadio(){

  }

  /**
   * 算定区分モデルに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicCalculationDivisionRadioModel(){

    getMedicalFacilityClinicCalculationDivisionRadioItem1().setButtonIndex(1);

    getMedicalFacilityClinicCalculationDivisionRadioModel().add(getMedicalFacilityClinicCalculationDivisionRadioItem1());

    getMedicalFacilityClinicCalculationDivisionRadioItem2().setButtonIndex(2);

    getMedicalFacilityClinicCalculationDivisionRadioModel().add(getMedicalFacilityClinicCalculationDivisionRadioItem2());

  }

  /**
   * 通常に内部項目を追加します。
   */
  protected void addMedicalFacilityClinicCalculationDivisionRadioItem1(){

  }

  /**
   * 加算のみに内部項目を追加します。
   */
  protected void addMedicalFacilityClinicCalculationDivisionRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001121_H2004Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001121_H2004Design getThis() {
    return this;
  }
}
