
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
 * 開発者: 亀井　陽一郎
 * 作成日: 2018/02/16  日本コンピューター株式会社 亀井　陽一郎 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービスパターン短期入所療養介護（病院療養） (001)
 * プログラム サービスパターン短期入所療養介護（介護医療院） (QS001_204211_201804)
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
 * サービスパターン短期入所療養介護（介護医療院）状態定義(QS001_204211_201804) 
 */
public class QS001_204211_201804State extends QS001_204211_201804Design {
  /**
   * コンストラクタです。
   */
  public QS001_204211_201804State(){
  }

  /**
   * 「食事提供・あり」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_USE_MEAT() throws Exception {

        getShortStayRecuperationHealthFacilityDinnerCost().setEnabled(true);

  }

  /**
   * 「食事提供・なし」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_NOT_USE_MEAT() throws Exception {

        getShortStayRecuperationHealthFacilityDinnerCost().setEnabled(false);

  }

  /**
   * 「人員配置・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_PERSON_SUBTRACTION() throws Exception {

        getStaffAssignmentDivisionItem1().setEnabled(false);

        getStaffAssignmentDivisionItem2().setEnabled(false);

        getStaffAssignmentDivisionItem4().setEnabled(false);

        getStaffAssignmentDivisionItem5().setEnabled(false);

        getStaffAssignmentDivisionItem6().setEnabled(false);

        getStaffAssignmentDivisionItem8().setEnabled(false);

  }

  /**
   * 「人員配置・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_PERSON_SUBTRACTION() throws Exception {

        getStaffAssignmentDivisionItem1().setEnabled(true);

        getStaffAssignmentDivisionItem2().setEnabled(true);

        getStaffAssignmentDivisionItem4().setEnabled(true);

        getStaffAssignmentDivisionItem5().setEnabled(true);

        getStaffAssignmentDivisionItem6().setEnabled(true);

        getStaffAssignmentDivisionItem8().setEnabled(true);

  }

  /**
   * 「人員配置・無効（ユニット型）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_PERSON_SUBTRACTION_UNIT() throws Exception {

        getStaffAssignmentDivisionItem1().setEnabled(false);

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

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

  }

  /**
   * 「認知症行動・心理症状緊急対応加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_DEMENTIA_ACTION() throws Exception {

        getDementiaActionAddRadioGroup().setEnabled(false);
        getDementiaActionAddRadioGroup().getParent().setEnabled(false);

  }

  /**
   * 「施設区分・I型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_NORMAL() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setVisible(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().setEnabled(false);
        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationHospitalRoomContena().setVisible(true);

        getTankinyusyoTimeDivision().setEnabled(false);

        getShortStayHospitalRecuperationAdditionType().setEnabled(true);
        getShortStayHospitalRecuperationAdditionType().getParent().setEnabled(true);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getEmergencyAcceptanceRadioGroup().setEnabled(true);
        getEmergencyAcceptanceRadioGroup().getParent().setEnabled(true);

        getStaffAssignment1Division().setVisible(true);

        getStaffAssignment1Division().setEnabled(true);
        getStaffAssignment1Division().getParent().setEnabled(true);

        getStaffAssignment2Division().setVisible(false);

        getStaffAssignment2Division().setEnabled(false);

        getStaffAssignment3Division().setVisible(false);

        getStaffAssignment3Division().setEnabled(false);

        getShortStayHospitalRecuperationSpecificConsultationFee().setEnabled(true);

        getMedicalFacilityHospitalSubstractionItem4().setEnabled(true);

  }

  /**
   * 「施設区分・II型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_NORMAL2() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setVisible(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().setEnabled(false);
        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationHospitalRoomContena().setVisible(true);

        getTankinyusyoTimeDivision().setEnabled(false);

        getShortStayHospitalRecuperationAdditionType().setEnabled(true);
        getShortStayHospitalRecuperationAdditionType().getParent().setEnabled(true);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getEmergencyAcceptanceRadioGroup().setEnabled(true);
        getEmergencyAcceptanceRadioGroup().getParent().setEnabled(true);

        getStaffAssignment1Division().setVisible(false);

        getStaffAssignment1Division().setEnabled(false);

        getStaffAssignment2Division().setVisible(true);

        getStaffAssignment2Division().setEnabled(true);
        getStaffAssignment2Division().getParent().setEnabled(true);

        getStaffAssignment3Division().setVisible(false);

        getStaffAssignment3Division().setEnabled(false);

        getShortStayHospitalRecuperationSpecificConsultationFee().setEnabled(true);

        getMedicalFacilityHospitalSubstractionItem4().setEnabled(true);

  }

  /**
   * 「施設区分・特別型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_SPECIAL() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setVisible(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().setEnabled(false);
        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationHospitalRoomContena().setVisible(true);

        getTankinyusyoTimeDivision().setEnabled(false);

        getShortStayHospitalRecuperationAdditionType().setEnabled(true);
        getShortStayHospitalRecuperationAdditionType().getParent().setEnabled(true);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getEmergencyAcceptanceRadioGroup().setEnabled(true);
        getEmergencyAcceptanceRadioGroup().getParent().setEnabled(true);

        getStaffAssignment1Division().setVisible(false);

        getStaffAssignment1Division().setEnabled(false);

        getStaffAssignment2Division().setVisible(false);

        getStaffAssignment2Division().setEnabled(false);

        getStaffAssignment3Division().setVisible(true);

        getStaffAssignment3Division().setEnabled(true);
        getStaffAssignment3Division().getParent().setEnabled(true);

        getShortStayHospitalRecuperationSpecificConsultationFee().setEnabled(false);

        getMedicalFacilityHospitalSubstractionItem4().setEnabled(true);

  }

  /**
   * 「施設区分・ユニット型I型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_UNIT() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(true);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(true);
        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setVisible(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().setEnabled(false);
        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationHospitalRoomContena().setVisible(true);

        getTankinyusyoTimeDivision().setEnabled(false);

        getShortStayHospitalRecuperationAdditionType().setEnabled(true);
        getShortStayHospitalRecuperationAdditionType().getParent().setEnabled(true);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getEmergencyAcceptanceRadioGroup().setEnabled(true);
        getEmergencyAcceptanceRadioGroup().getParent().setEnabled(true);

        getStaffAssignment1Division().setVisible(true);

        getStaffAssignment1Division().setEnabled(true);
        getStaffAssignment1Division().getParent().setEnabled(true);

        getStaffAssignmentDivisionItem1().setEnabled(true);

        getStaffAssignmentDivisionItem2().setEnabled(true);

        getStaffAssignmentDivisionItem3().setEnabled(false);

        getStaffAssignment2Division().setVisible(false);

        getStaffAssignment2Division().setEnabled(false);

        getStaffAssignment3Division().setVisible(false);

        getStaffAssignment3Division().setEnabled(false);

        getShortStayHospitalRecuperationSpecificConsultationFee().setEnabled(true);

        getMedicalFacilityHospitalSubstractionItem4().setEnabled(true);

  }

  /**
   * 「施設区分・ユニット型II型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_UNIT2() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(true);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(true);
        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setVisible(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().setEnabled(false);
        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationHospitalRoomContena().setVisible(true);

        getTankinyusyoTimeDivision().setEnabled(false);

        getShortStayHospitalRecuperationAdditionType().setEnabled(true);
        getShortStayHospitalRecuperationAdditionType().getParent().setEnabled(true);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getEmergencyAcceptanceRadioGroup().setEnabled(true);
        getEmergencyAcceptanceRadioGroup().getParent().setEnabled(true);

        getStaffAssignment1Division().setEnabled(false);
        getStaffAssignment1Division().getParent().setEnabled(false);

        getStaffAssignment2Division().setEnabled(false);
        getStaffAssignment2Division().getParent().setEnabled(false);

        getStaffAssignment3Division().setEnabled(false);
        getStaffAssignment3Division().getParent().setEnabled(false);

        getShortStayHospitalRecuperationSpecificConsultationFee().setEnabled(true);

        getMedicalFacilityHospitalSubstractionItem4().setEnabled(true);

  }

  /**
   * 「施設区分・ユニット型特別型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_UNIT_SPECIAL() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(true);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(true);
        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setVisible(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().setEnabled(false);
        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationHospitalRoomContena().setVisible(true);

        getTankinyusyoTimeDivision().setEnabled(false);

        getShortStayHospitalRecuperationAdditionType().setEnabled(true);
        getShortStayHospitalRecuperationAdditionType().getParent().setEnabled(true);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getEmergencyAcceptanceRadioGroup().setEnabled(true);
        getEmergencyAcceptanceRadioGroup().getParent().setEnabled(true);

        getStaffAssignment1Division().setVisible(false);

        getStaffAssignment1Division().setEnabled(false);

        getStaffAssignment2Division().setVisible(false);

        getStaffAssignment2Division().setEnabled(false);

        getStaffAssignment3Division().setVisible(true);

        getStaffAssignment3Division().setEnabled(true);
        getStaffAssignment3Division().getParent().setEnabled(true);

        getShortStayHospitalRecuperationSpecificConsultationFee().setEnabled(false);

        getMedicalFacilityHospitalSubstractionItem4().setEnabled(true);

  }

  /**
   * 「施設区分・日帰りショートステイ」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_SHORT_STAY() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setVisible(true);

        getShortStayHospitalRecuperationSickroomDivisionRadio().setEnabled(true);
        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setEnabled(true);

        getShortStayHospitalRecuperationHospitalRoomContena().setVisible(false);

        getTankinyusyoTimeDivision().setEnabled(true);

        getShortStayHospitalRecuperationAdditionType().setEnabled(false);
        getShortStayHospitalRecuperationAdditionType().getParent().setEnabled(false);

        getDementiaActionAddRadioGroup().setEnabled(false);
        getDementiaActionAddRadioGroup().getParent().setEnabled(false);

        getEmergencyAcceptanceRadioGroup().setEnabled(false);
        getEmergencyAcceptanceRadioGroup().getParent().setEnabled(false);

        getStaffAssignment1Division().setEnabled(false);
        getStaffAssignment1Division().getParent().setEnabled(false);

        getStaffAssignment2Division().setEnabled(false);
        getStaffAssignment2Division().getParent().setEnabled(false);

        getStaffAssignment3Division().setEnabled(false);
        getStaffAssignment3Division().getParent().setEnabled(false);

        getShortStayHospitalRecuperationSpecificConsultationFee().setEnabled(true);

        getMedicalFacilityHospitalSubstractionItem4().setEnabled(false);

  }

  /**
   * 「緊急短期入所受入加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_EMERGENCY_ACCEPTANCE() throws Exception {

        getEmergencyAcceptanceRadioGroup().setEnabled(true);
        getEmergencyAcceptanceRadioGroup().getParent().setEnabled(true);

  }

  /**
   * 「緊急短期入所受入加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_EMERGENCY_ACCEPTANCE() throws Exception {

        getEmergencyAcceptanceRadioGroup().setEnabled(false);
        getEmergencyAcceptanceRadioGroup().getParent().setEnabled(false);

  }

  /**
   * 「夜間勤務等看護加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_HOSPITAL_RECUPERATION() throws Exception {

        getShortStayHospitalRecuperationAdditionType().setEnabled(true);
        getShortStayHospitalRecuperationAdditionType().getParent().setEnabled(true);

  }

  /**
   * 「夜間勤務等看護加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_HOSPITAL_RECUPERATION() throws Exception {

        getShortStayHospitalRecuperationAdditionType().setEnabled(false);
        getShortStayHospitalRecuperationAdditionType().getParent().setEnabled(false);

  }

}
