
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
 * プロセス サービスパターン短期入所療養介護（診療所療養） (001)
 * プログラム サービスパターン短期入所療養介護（診療所療養） (QS001_12312_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * サービスパターン短期入所療養介護（診療所療養）状態定義(QS001_12312_201204) 
 */
public class QS001_12312_201204State extends QS001_12312_201204Design {
  /**
   * コンストラクタです。
   */
  public QS001_12312_201204State(){
  }

  /**
   * 「食事提供・あり」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_USE_MEAT() throws Exception {

        getShortStayClinicRecuperationDinnerCost().setEnabled(true);

  }

  /**
   * 「食事提供・なし」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_NOT_USE_MEAT() throws Exception {

        getShortStayClinicRecuperationDinnerCost().setEnabled(false);

  }

  /**
   * 「従来型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_CONVENTIONAL_FORM() throws Exception {

        getShortStayClinicRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayClinicRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayClinicRecuperationDivision().setEnabled(true);
        getShortStayClinicRecuperationDivision().getParent().setEnabled(true);

        getShortStayClinicRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayClinicRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

  }

  /**
   * 「ユニット型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_UNIT_FORM() throws Exception {

        getShortStayClinicRecuperationHospitalRoomRadio().setEnabled(false);

        getShortStayClinicRecuperationUnitHospitalRoomRadio().setEnabled(true);

        getShortStayClinicRecuperationDivision().setEnabled(false);
        getShortStayClinicRecuperationDivision().getParent().setEnabled(false);

        getShortStayClinicRecuperationUnitCareMaintenanceRadio().setEnabled(true);
        getShortStayClinicRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(true);

  }

  /**
   * 「日帰りショートステイ・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SELECT_SHORT_STAY_STATE() throws Exception {

        getShortStayClinicRecuperationHospitalRoomRadio().setEnabled(false);

        getShortStayClinicRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayClinicRecuperationDivision().setEnabled(false);
        getShortStayClinicRecuperationDivision().getParent().setEnabled(false);

        getShortStayClinicRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayClinicRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

  }

  /**
   * 「ユニットケアの整備・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_UNIT_CARE() throws Exception {

        getShortStayClinicRecuperationUnitCareMaintenanceRadio().setEnabled(true);
        getShortStayClinicRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(true);

  }

  /**
   * 「ユニットケアの整備・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_UNIT_CARE() throws Exception {

        getShortStayClinicRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayClinicRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

  }

  /**
   * 「日帰りショート・選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SHORT_STAY_SELECT() throws Exception {

        getShortStayClinicRecuperationSickroomDivisionRadio().getParent().setVisible(true);

        getShortStayClinicRecuperationSickroomDivisionRadio().setEnabled(true);
        getShortStayClinicRecuperationSickroomDivisionRadio().getParent().setEnabled(true);

        getShortStayClinicRecuperationHospitalRoomContena().setVisible(false);

        getTankinyusyoTimeDivision().setEnabled(true);

        getDementiaActionAddRadioGroup().setEnabled(false);
        getDementiaActionAddRadioGroup().getParent().setEnabled(false);

  }

  /**
   * 「日帰りショート・非選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SHORT_STAY_UNSELECT() throws Exception {

        getShortStayClinicRecuperationSickroomDivisionRadio().getParent().setVisible(false);

        getShortStayClinicRecuperationSickroomDivisionRadio().setEnabled(false);
        getShortStayClinicRecuperationSickroomDivisionRadio().getParent().setEnabled(false);

        getShortStayClinicRecuperationHospitalRoomContena().setVisible(true);

        getTankinyusyoTimeDivision().setEnabled(false);

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

        getShortStayClinicRecuperationEmergencyNetworkAddRadio().setEnabled(true);
        getShortStayClinicRecuperationEmergencyNetworkAddRadio().getParent().setEnabled(true);

  }

  /**
   * 「認知症行動・心理症状緊急対応加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_DEMENTIA_ACTION() throws Exception {

        getDementiaActionAddRadioGroup().setEnabled(false);
        getDementiaActionAddRadioGroup().getParent().setEnabled(false);

        getShortStayClinicRecuperationEmergencyNetworkAddRadio().setEnabled(false);
        getShortStayClinicRecuperationEmergencyNetworkAddRadio().getParent().setEnabled(false);

  }

}
