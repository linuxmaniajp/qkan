
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
 * 作成日: 2018/02/26  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護療養型医療施設（診療所） (QS001_15312_201804)
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
/**
 * サービスパターン介護療養型医療施設（診療所）状態定義(QS001_15312_201804) 
 */
public class QS001_15312_201804State extends QS001_15312_201804Design {
  /**
   * コンストラクタです。
   */
  public QS001_15312_201804State(){
  }

  /**
   * 「経口移行・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_NUTRITION() throws Exception {

        getMedicalFacilityClinicOralSwitchRadio().setEnabled(true);
        getMedicalFacilityClinicOralSwitchRadio().getParent().setEnabled(true);

  }

  /**
   * 「経口移行・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_NUTRITION() throws Exception {

        getMedicalFacilityClinicOralSwitchRadio().setEnabled(false);
        getMedicalFacilityClinicOralSwitchRadio().getParent().setEnabled(false);

  }

  /**
   * 「従来型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_CONVENTIONAL_FORM() throws Exception {

        getMedicalFacilityClinicHospitalRoomRadio().setEnabled(true);

        getMedicalFacilityClinicUnitHospitalRoomRadio().setEnabled(false);

        getUnitCareMaintenanceRadio().setEnabled(false);
        getUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getStaffAssignment1Division().setVisible(true);

        getStaffAssignment1Division().setEnabled(true);
        getStaffAssignment1Division().getParent().setEnabled(true);

        getStaffAssignment2Division().setVisible(false);

        getStaffAssignment2Division().setEnabled(false);

  }

  /**
   * 「ユニット型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_UNIT_FORM() throws Exception {

        getMedicalFacilityClinicHospitalRoomRadio().setEnabled(false);

        getMedicalFacilityClinicUnitHospitalRoomRadio().setEnabled(true);

        getUnitCareMaintenanceRadio().setEnabled(true);
        getUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getStaffAssignment1Division().setVisible(false);

        getStaffAssignment1Division().setEnabled(false);

        getStaffAssignment2Division().setVisible(true);

        getStaffAssignment2Division().setEnabled(true);
        getStaffAssignment2Division().getParent().setEnabled(true);

  }

  /**
   * 「食事提供・あり」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_USE_MEAT() throws Exception {

        getMedicalFacilityClinicDinnerCost().setEnabled(true);

  }

  /**
   * 「食事提供・なし」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_NOT_USE_MEAT() throws Exception {

        getMedicalFacilityClinicDinnerCost().setEnabled(false);

  }

  /**
   * 「経口維持加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_KEEP_NUTRITION() throws Exception {

        getOralMaintenanceAdd().setEnabled(true);
        getOralMaintenanceAdd().getParent().setEnabled(true);

  }

  /**
   * 「経口維持加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_KEEP_NUTRITION() throws Exception {

        getOralMaintenanceAdd().setEnabled(false);
        getOralMaintenanceAdd().getParent().setEnabled(false);

  }

  /**
   * 「他科受信加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_TAKAJUSIN() throws Exception {

        getMedicalFacilityClinicMedicalExaminationRadio().setEnabled(true);
        getMedicalFacilityClinicMedicalExaminationRadio().getParent().setEnabled(true);

  }

  /**
   * 「他科受信加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_TAKAJUSIN() throws Exception {

        getMedicalFacilityClinicMedicalExaminationRadio().setEnabled(false);
        getMedicalFacilityClinicMedicalExaminationRadio().getParent().setEnabled(false);

  }

  /**
   * 「外泊加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_GAIHAKU_ADD() throws Exception {

        getMedicalFacilityClinicStayRadio().setEnabled(true);
        getMedicalFacilityClinicStayRadio().getParent().setEnabled(true);

  }

  /**
   * 「外泊加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_GAIHAKU_ADD() throws Exception {

        getMedicalFacilityClinicStayRadio().setEnabled(false);
        getMedicalFacilityClinicStayRadio().getParent().setEnabled(false);

  }

  /**
   * 「口腔機能維持管理加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_ORAL_CARE() throws Exception {

        getOralKeepAddRadioGroup().setEnabled(true);
        getOralKeepAddRadioGroup().getParent().setEnabled(true);

  }

  /**
   * 「口腔機能維持管理加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_ORAL_CARE() throws Exception {

        getOralKeepAddRadioGroup().setEnabled(false);
        getOralKeepAddRadioGroup().getParent().setEnabled(false);

  }

  /**
   * 「経口維持加算２・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_ORAL_MAINTENANCE2() throws Exception {

        getOralMaintenanceAddItem3().setEnabled(true);

  }

  /**
   * 「経口維持加算２・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_ORAL_MAINTENANCE2() throws Exception {

        getOralMaintenanceAddItem3().setEnabled(false);

  }

  /**
   * 「若年性認知症利用者受入加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_YOUNG_DEMENTIA_PATINET() throws Exception {

        getYoungDementiaPatinetAddRadioGroup().setEnabled(true);
        getYoungDementiaPatinetAddRadioGroup().getParent().setEnabled(true);

  }

  /**
   * 「若年性認知症利用者受入加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_YOUNG_DEMENTIA_PATINET() throws Exception {

        getYoungDementiaPatinetAddRadioGroup().setEnabled(false);
        getYoungDementiaPatinetAddRadioGroup().getParent().setEnabled(false);

  }

  /**
   * 「認知症行動・心理症状緊急対応加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_DEMENTIA_ACTION() throws Exception {

        getDementiaEmergencyAddRadioGroup().setEnabled(true);
        getDementiaEmergencyAddRadioGroup().getParent().setEnabled(true);

  }

  /**
   * 「認知症行動・心理症状緊急対応加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_DEMENTIA_ACTION() throws Exception {

        getDementiaEmergencyAddRadioGroup().setEnabled(false);
        getDementiaEmergencyAddRadioGroup().getParent().setEnabled(false);

  }

  /**
   * 「入院患者基準・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_HOSPITALIZED_PATIENTS_CRITERIA() throws Exception {

        getHospitalizedPatientsCriteriaRadio().setEnabled(true);
        getHospitalizedPatientsCriteriaRadio().getParent().setEnabled(true);

  }

  /**
   * 「入院患者基準・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_HOSPITALIZED_PATIENTS_CRITERIA() throws Exception {

        getHospitalizedPatientsCriteriaRadio().setEnabled(false);
        getHospitalizedPatientsCriteriaRadio().getParent().setEnabled(false);

  }

  /**
   * 「入院患者基準の関連加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_HOSPITAL_PATIENT_RELATED() throws Exception {

        getMedicalFacilityClinicOralSwitchRadio().setEnabled(true);
        getMedicalFacilityClinicOralSwitchRadio().getParent().setEnabled(true);

        getOralKeepAddRadioGroup().setEnabled(true);
        getOralKeepAddRadioGroup().getParent().setEnabled(true);

        getMedicalFacilityClinicHijoAddition().setEnabled(true);

        getLowNutritionalRiskImprovementAdd().setEnabled(true);
        getLowNutritionalRiskImprovementAdd().getParent().setEnabled(true);

        getOralMaintenanceAddContainer().setEnabled(true);

        getOralKeepStructureAddRadioGroup().setEnabled(true);
        getOralKeepStructureAddRadioGroup().getParent().setEnabled(true);

        getStayReturnSupportAddRadio().setEnabled(true);
        getStayReturnSupportAddRadio().getParent().setEnabled(true);

        getMedicalFacilityClinicConsultationFee().setEnabled(true);

        getExcretionSupport().setEnabled(true);
        getExcretionSupport().getParent().setEnabled(true);

  }

  /**
   * 「入院患者基準の関連加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_HOSPITAL_PATIENT_RELATED() throws Exception {

        getMedicalFacilityClinicOralSwitchRadio().setEnabled(false);
        getMedicalFacilityClinicOralSwitchRadio().getParent().setEnabled(false);

        getOralKeepAddRadioGroup().setEnabled(false);
        getOralKeepAddRadioGroup().getParent().setEnabled(false);

        getMedicalFacilityClinicHijoAddition().setEnabled(false);

        getLowNutritionalRiskImprovementAdd().setEnabled(false);
        getLowNutritionalRiskImprovementAdd().getParent().setEnabled(false);

        getOralMaintenanceAddContainer().setEnabled(false);

        getOralKeepStructureAddRadioGroup().setEnabled(false);
        getOralKeepStructureAddRadioGroup().getParent().setEnabled(false);

        getStayReturnSupportAddRadio().setEnabled(false);
        getStayReturnSupportAddRadio().getParent().setEnabled(false);

        getMedicalFacilityClinicConsultationFee().setEnabled(false);

        getExcretionSupport().setEnabled(false);
        getExcretionSupport().getParent().setEnabled(false);

  }

  /**
   * 「低栄養リスク改善加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_LOW_NUTRITIONAL() throws Exception {

        getLowNutritionalRiskImprovementAdd().setEnabled(true);
        getLowNutritionalRiskImprovementAdd().getParent().setEnabled(true);

  }

  /**
   * 「低栄養リスク改善加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_LOW_NUTRITIONAL() throws Exception {

        getLowNutritionalRiskImprovementAdd().setEnabled(false);
        getLowNutritionalRiskImprovementAdd().getParent().setEnabled(false);

  }

}
