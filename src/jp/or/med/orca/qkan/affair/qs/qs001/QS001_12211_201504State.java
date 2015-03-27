
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
 * 作成日: 2012/03/06  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービスパターン短期入所療養介護 (001)
 * プログラム サービスパターン短期入所療養介護(介護老人保健施設) (QS001_12211_201504)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * サービスパターン短期入所療養介護(介護老人保健施設)状態定義(QS001_12211_201504) 
 */
public class QS001_12211_201504State extends QS001_12211_201504Design {
  /**
   * コンストラクタです。
   */
  public QS001_12211_201504State(){
  }

  /**
   * 「介護老人保健施設（I）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_1() throws Exception {

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionContena().setVisible(true);

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio().setEnabled(true);

        getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio().setEnabled(false);

        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().getParent().setVisible(false);

        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().setEnabled(false);
        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().getParent().setEnabled(false);

        getTankinyusyoTimeDivision().setEnabled(false);
        getTankinyusyoTimeDivision().getParent().setEnabled(false);

        getShortStayRecuperationHealthUnitCareAddRadio().setEnabled(false);
        getShortStayRecuperationHealthUnitCareAddRadio().getParent().setEnabled(false);

        getNightStaffDispositionAddRadioGroup().setEnabled(true);
        getNightStaffDispositionAddRadioGroup().getParent().setEnabled(true);

        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().setEnabled(true);
        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().getParent().setEnabled(true);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getShortStayRecuperationHealthPersonnelDivision1().setEnabled(true);

        getShortStayRecuperationHealthPersonnelDivision2().setEnabled(false);

        getShortStayRecuperationHealthFacilitySpecialMedicalExpense().setEnabled(false);

        getShortStayRecuperationHealthFacilityRecuperationRadio().setEnabled(false);
        getShortStayRecuperationHealthFacilityRecuperationRadio().getParent().setEnabled(false);

  }

  /**
   * 「ユニット型介護老人保健施設（I）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_2() throws Exception {

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionContena().setVisible(true);

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio().setEnabled(false);

        getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio().setEnabled(true);

        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().getParent().setVisible(false);

        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().setEnabled(false);
        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().getParent().setEnabled(false);

        getTankinyusyoTimeDivision().setEnabled(false);
        getTankinyusyoTimeDivision().getParent().setEnabled(false);

        getShortStayRecuperationHealthUnitCareAddRadio().setEnabled(true);
        getShortStayRecuperationHealthUnitCareAddRadio().getParent().setEnabled(true);

        getNightStaffDispositionAddRadioGroup().setEnabled(true);
        getNightStaffDispositionAddRadioGroup().getParent().setEnabled(true);

        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().setEnabled(false);
        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().getParent().setEnabled(false);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getShortStayRecuperationHealthPersonnelDivision1().setEnabled(true);

        getShortStayRecuperationHealthPersonnelDivision2().setEnabled(false);

        getShortStayRecuperationHealthFacilitySpecialMedicalExpense().setEnabled(false);

        getShortStayRecuperationHealthFacilityRecuperationRadio().setEnabled(false);
        getShortStayRecuperationHealthFacilityRecuperationRadio().getParent().setEnabled(false);

  }

  /**
   * 「介護老人保健施設（II）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_3() throws Exception {

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionContena().setVisible(true);

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio().setEnabled(true);

        getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio().setEnabled(false);

        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().getParent().setVisible(false);

        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().setEnabled(false);
        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().getParent().setEnabled(false);

        getTankinyusyoTimeDivision().setEnabled(false);
        getTankinyusyoTimeDivision().getParent().setEnabled(false);

        getShortStayRecuperationHealthUnitCareAddRadio().setEnabled(false);
        getShortStayRecuperationHealthUnitCareAddRadio().getParent().setEnabled(false);

        getNightStaffDispositionAddRadioGroup().setEnabled(true);
        getNightStaffDispositionAddRadioGroup().getParent().setEnabled(true);

        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().setEnabled(true);
        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().getParent().setEnabled(true);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getShortStayRecuperationHealthPersonnelDivision1().setEnabled(false);

        getShortStayRecuperationHealthPersonnelDivision2().setEnabled(true);

        getShortStayRecuperationHealthFacilitySpecialMedicalExpense().setEnabled(true);

        getShortStayRecuperationHealthFacilityRecuperationRadio().setEnabled(true);
        getShortStayRecuperationHealthFacilityRecuperationRadio().getParent().setEnabled(true);

  }

  /**
   * 「ユニット型介護老人保健施設（II）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_4() throws Exception {

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionContena().setVisible(true);

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio().setEnabled(false);

        getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio().setEnabled(true);

        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().getParent().setVisible(false);

        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().setEnabled(false);
        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().getParent().setEnabled(false);

        getTankinyusyoTimeDivision().setEnabled(false);
        getTankinyusyoTimeDivision().getParent().setEnabled(false);

        getShortStayRecuperationHealthUnitCareAddRadio().setEnabled(true);
        getShortStayRecuperationHealthUnitCareAddRadio().getParent().setEnabled(true);

        getNightStaffDispositionAddRadioGroup().setEnabled(true);
        getNightStaffDispositionAddRadioGroup().getParent().setEnabled(true);

        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().setEnabled(false);
        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().getParent().setEnabled(false);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getShortStayRecuperationHealthPersonnelDivision1().setEnabled(false);

        getShortStayRecuperationHealthPersonnelDivision2().setEnabled(true);

        getShortStayRecuperationHealthFacilitySpecialMedicalExpense().setEnabled(true);

        getShortStayRecuperationHealthFacilityRecuperationRadio().setEnabled(true);
        getShortStayRecuperationHealthFacilityRecuperationRadio().getParent().setEnabled(true);

  }

  /**
   * 「介護老人保健施設（III）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_5() throws Exception {

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionContena().setVisible(true);

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio().setEnabled(true);

        getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio().setEnabled(false);

        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().getParent().setVisible(false);

        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().setEnabled(false);
        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().getParent().setEnabled(false);

        getTankinyusyoTimeDivision().setEnabled(false);
        getTankinyusyoTimeDivision().getParent().setEnabled(false);

        getShortStayRecuperationHealthUnitCareAddRadio().setEnabled(false);
        getShortStayRecuperationHealthUnitCareAddRadio().getParent().setEnabled(false);

        getNightStaffDispositionAddRadioGroup().setEnabled(true);
        getNightStaffDispositionAddRadioGroup().getParent().setEnabled(true);

        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().setEnabled(true);
        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().getParent().setEnabled(true);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getShortStayRecuperationHealthPersonnelDivision1().setEnabled(false);

        getShortStayRecuperationHealthPersonnelDivision2().setEnabled(true);

        getShortStayRecuperationHealthFacilitySpecialMedicalExpense().setEnabled(true);

        getShortStayRecuperationHealthFacilityRecuperationRadio().setEnabled(true);
        getShortStayRecuperationHealthFacilityRecuperationRadio().getParent().setEnabled(true);

  }

  /**
   * 「ユニット型介護老人保健施設（III）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_6() throws Exception {

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionContena().setVisible(true);

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio().setEnabled(false);

        getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio().setEnabled(true);

        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().getParent().setVisible(false);

        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().setEnabled(false);
        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().getParent().setEnabled(false);

        getTankinyusyoTimeDivision().setEnabled(false);
        getTankinyusyoTimeDivision().getParent().setEnabled(false);

        getShortStayRecuperationHealthUnitCareAddRadio().setEnabled(true);
        getShortStayRecuperationHealthUnitCareAddRadio().getParent().setEnabled(true);

        getNightStaffDispositionAddRadioGroup().setEnabled(true);
        getNightStaffDispositionAddRadioGroup().getParent().setEnabled(true);

        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().setEnabled(false);
        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().getParent().setEnabled(false);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getShortStayRecuperationHealthPersonnelDivision1().setEnabled(false);

        getShortStayRecuperationHealthPersonnelDivision2().setEnabled(true);

        getShortStayRecuperationHealthFacilitySpecialMedicalExpense().setEnabled(true);

        getShortStayRecuperationHealthFacilityRecuperationRadio().setEnabled(true);
        getShortStayRecuperationHealthFacilityRecuperationRadio().getParent().setEnabled(true);

  }

  /**
   * 「日帰りショートステイ」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_7() throws Exception {

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionContena().setVisible(false);

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio().setEnabled(false);

        getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio().setEnabled(false);

        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().getParent().setVisible(true);

        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().setEnabled(true);
        getShortStayRecuperationHealthFacilitySickroomDivisionRadio().getParent().setEnabled(true);

        getTankinyusyoTimeDivision().setEnabled(true);
        getTankinyusyoTimeDivision().getParent().setEnabled(true);

        getShortStayRecuperationHealthUnitCareAddRadio().setEnabled(false);
        getShortStayRecuperationHealthUnitCareAddRadio().getParent().setEnabled(false);

        getNightStaffDispositionAddRadioGroup().setEnabled(false);
        getNightStaffDispositionAddRadioGroup().getParent().setEnabled(false);

        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().setEnabled(false);
        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().getParent().setEnabled(false);

        getDementiaActionAddRadioGroup().setEnabled(false);
        getDementiaActionAddRadioGroup().getParent().setEnabled(false);

        getShortStayRecuperationHealthPersonnelDivision1().setEnabled(false);

        getShortStayRecuperationHealthPersonnelDivision2().setEnabled(false);

        getShortStayRecuperationHealthFacilitySpecialMedicalExpense().setEnabled(true);

        getShortStayRecuperationHealthFacilityRecuperationRadio().setEnabled(false);
        getShortStayRecuperationHealthFacilityRecuperationRadio().getParent().setEnabled(false);

  }

  /**
   * 「認知症ケア加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_DEMENTIA_CARE() throws Exception {

        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().setEnabled(true);
        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().getParent().setEnabled(true);

  }

  /**
   * 「認知症ケア加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_DEMENTIA_CARE() throws Exception {

        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().setEnabled(false);
        getShortStayRecuperationHealthFacilityCommunicationDifficultyCareAddRadio().getParent().setEnabled(false);

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
   * 「食事提供・あり」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_USE_MEAT() throws Exception {

        getShortStayRecuperationHealthFacilityDinnerCost().setEnabled(true);
        getShortStayRecuperationHealthFacilityDinnerCost().getParent().setEnabled(true);

  }

  /**
   * 「食事提供・なし」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_NOT_USE_MEAT() throws Exception {

        getShortStayRecuperationHealthFacilityDinnerCost().setEnabled(false);
        getShortStayRecuperationHealthFacilityDinnerCost().getParent().setEnabled(false);

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
   * 「重度療養管理加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_MEDICAL_MANAGEMENT() throws Exception {

        getSeverelyMedicalManagementAdd().setEnabled(true);
        getSeverelyMedicalManagementAdd().getParent().setEnabled(true);

  }

  /**
   * 「重度療養管理加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_MEDICAL_MANAGEMENT() throws Exception {

        getSeverelyMedicalManagementAdd().setEnabled(false);
        getSeverelyMedicalManagementAdd().getParent().setEnabled(false);

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

}
