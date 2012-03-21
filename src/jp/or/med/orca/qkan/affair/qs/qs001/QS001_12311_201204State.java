
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
 * 作成日: 2012/02/16  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービスパターン短期入所療養介護（病院療養） (001)
 * プログラム サービスパターン短期入所療養介護（病院療養） (QS001_12311_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * サービスパターン短期入所療養介護（病院療養）状態定義(QS001_12311_201204) 
 */
public class QS001_12311_201204State extends QS001_12311_201204Design {
  /**
   * コンストラクタです。
   */
  public QS001_12311_201204State(){
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
   * 「人員配置Ⅰ・Ⅱ・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_PERSON_SUBTRACTION() throws Exception {

        getShortStayHospitalRecuperationType1().setEnabled(false);

        getShortStayHospitalRecuperationType2().setEnabled(false);

  }

  /**
   * 「人員配置Ⅰ・Ⅱ・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_PERSON_SUBTRACTION() throws Exception {

        getShortStayHospitalRecuperationType1().setEnabled(true);

        getShortStayHospitalRecuperationType2().setEnabled(true);

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
   * 「人員配置Ⅰ・Ⅲ・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_PERSON_SUBTRACTION_1_3() throws Exception {

        getShortStayHospitalRecuperationDivision().setEnabled(true);
        getShortStayHospitalRecuperationDivision().getParent().setEnabled(true);

        getShortStayHospitalRecuperationType1().setEnabled(false);

        getShortStayHospitalRecuperationType2().setEnabled(true);

        getShortStayHospitalRecuperationType3().setEnabled(false);

  }

  /**
   * 「施設区分・病院療養型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_NORMAL() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationDivision().setEnabled(true);
        getShortStayHospitalRecuperationDivision().getParent().setEnabled(true);

        getShortStayHospitalRecuperationType1().setEnabled(true);

        getShortStayHospitalRecuperationType2().setEnabled(true);

        getShortStayHospitalRecuperationType3().setEnabled(true);

        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setVisible(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().setEnabled(false);
        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationHospitalRoomContena().setVisible(true);

        getTankinyusyoTimeDivision().setEnabled(false);

        getShortStayHospitalRecuperationAdditionType().getParent().setVisible(true);

        getShortStayHospitalRecuperationAdditionType().setEnabled(true);
        getShortStayHospitalRecuperationAdditionType().getParent().setEnabled(true);

        getShortStayHospitalRecuperationAdditionTypeForShortstay().getParent().setVisible(false);

        getShortStayHospitalRecuperationAdditionTypeForShortstay().setEnabled(false);
        getShortStayHospitalRecuperationAdditionTypeForShortstay().getParent().setEnabled(false);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getEmergencyAcceptanceRadioGroup().setEnabled(true);
        getEmergencyAcceptanceRadioGroup().getParent().setEnabled(true);

  }

  /**
   * 「施設区分・ユニット型病院療養型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_UNIT() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(true);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(true);
        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getShortStayHospitalRecuperationDivision().setEnabled(false);
        getShortStayHospitalRecuperationDivision().getParent().setEnabled(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setVisible(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().setEnabled(false);
        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationHospitalRoomContena().setVisible(true);

        getTankinyusyoTimeDivision().setEnabled(false);

        getShortStayHospitalRecuperationAdditionType().getParent().setVisible(true);

        getShortStayHospitalRecuperationAdditionType().setEnabled(true);
        getShortStayHospitalRecuperationAdditionType().getParent().setEnabled(true);

        getShortStayHospitalRecuperationAdditionTypeForShortstay().getParent().setVisible(false);

        getShortStayHospitalRecuperationAdditionTypeForShortstay().setEnabled(false);
        getShortStayHospitalRecuperationAdditionTypeForShortstay().getParent().setEnabled(false);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getEmergencyAcceptanceRadioGroup().setEnabled(true);
        getEmergencyAcceptanceRadioGroup().getParent().setEnabled(true);

  }

  /**
   * 「施設区分・病院経過型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_KEIKAGATA() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationDivision().setEnabled(true);
        getShortStayHospitalRecuperationDivision().getParent().setEnabled(true);

        getShortStayHospitalRecuperationType1().setEnabled(true);

        getShortStayHospitalRecuperationType2().setEnabled(true);

        getShortStayHospitalRecuperationType3().setEnabled(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setVisible(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().setEnabled(false);
        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationHospitalRoomContena().setVisible(true);

        getTankinyusyoTimeDivision().setEnabled(false);

        getShortStayHospitalRecuperationAdditionType().getParent().setVisible(true);

        getShortStayHospitalRecuperationAdditionType().setEnabled(true);
        getShortStayHospitalRecuperationAdditionType().getParent().setEnabled(true);

        getShortStayHospitalRecuperationAdditionTypeForShortstay().getParent().setVisible(false);

        getShortStayHospitalRecuperationAdditionTypeForShortstay().setEnabled(false);
        getShortStayHospitalRecuperationAdditionTypeForShortstay().getParent().setEnabled(false);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getEmergencyAcceptanceRadioGroup().setEnabled(true);
        getEmergencyAcceptanceRadioGroup().getParent().setEnabled(true);

  }

  /**
   * 「施設区分・ユニット型病院経過型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_UNIT_KEIKAGATA() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(true);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(true);
        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getShortStayHospitalRecuperationDivision().setEnabled(false);
        getShortStayHospitalRecuperationDivision().getParent().setEnabled(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setVisible(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().setEnabled(false);
        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationHospitalRoomContena().setVisible(true);

        getTankinyusyoTimeDivision().setEnabled(false);

        getShortStayHospitalRecuperationAdditionType().getParent().setVisible(true);

        getShortStayHospitalRecuperationAdditionType().setEnabled(true);
        getShortStayHospitalRecuperationAdditionType().getParent().setEnabled(true);

        getShortStayHospitalRecuperationAdditionTypeForShortstay().getParent().setVisible(false);

        getShortStayHospitalRecuperationAdditionTypeForShortstay().setEnabled(false);
        getShortStayHospitalRecuperationAdditionTypeForShortstay().getParent().setEnabled(false);

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getEmergencyAcceptanceRadioGroup().setEnabled(true);
        getEmergencyAcceptanceRadioGroup().getParent().setEnabled(true);

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

        getShortStayHospitalRecuperationDivision().setEnabled(false);
        getShortStayHospitalRecuperationDivision().getParent().setEnabled(false);

        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setVisible(true);

        getShortStayHospitalRecuperationSickroomDivisionRadio().setEnabled(true);
        getShortStayHospitalRecuperationSickroomDivisionRadio().getParent().setEnabled(true);

        getShortStayHospitalRecuperationHospitalRoomContena().setVisible(false);

        getTankinyusyoTimeDivision().setEnabled(true);

        getShortStayHospitalRecuperationAdditionType().getParent().setVisible(false);

        getShortStayHospitalRecuperationAdditionType().setEnabled(false);
        getShortStayHospitalRecuperationAdditionType().getParent().setEnabled(false);

        getShortStayHospitalRecuperationAdditionTypeForShortstay().getParent().setVisible(true);

        getShortStayHospitalRecuperationAdditionTypeForShortstay().setEnabled(true);
        getShortStayHospitalRecuperationAdditionTypeForShortstay().getParent().setEnabled(true);

        getDementiaActionAddRadioGroup().setEnabled(false);
        getDementiaActionAddRadioGroup().getParent().setEnabled(false);

        getEmergencyAcceptanceRadioGroup().setEnabled(false);
        getEmergencyAcceptanceRadioGroup().getParent().setEnabled(false);

  }

}
