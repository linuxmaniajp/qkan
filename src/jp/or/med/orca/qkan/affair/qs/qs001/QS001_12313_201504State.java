
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
 * プロセス サービスパターン短期入所療養介護（認知症疾患） (001)
 * プログラム サービスパターン短期入所療養介護（認知症疾患） (QS001_12313_201504)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * サービスパターン短期入所療養介護（認知症疾患）状態定義(QS001_12313_201504) 
 */
public class QS001_12313_201504State extends QS001_12313_201504Design {
  /**
   * コンストラクタです。
   */
  public QS001_12313_201504State(){
  }

  /**
   * 「食事提供・あり」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_USE_MEAT() throws Exception {

        getShortStayDementiaRecuperationDinnerCost().setEnabled(true);

  }

  /**
   * 「食事提供・なし」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_NOT_USE_MEAT() throws Exception {

        getShortStayDementiaRecuperationDinnerCost().setEnabled(false);

  }

  /**
   * 「従来型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_CONVENTIONAL_FORM() throws Exception {

        getShortStayDementiaRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayDementiaRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayDementiaRecuperationHospitalDivisionRadio().setEnabled(true);
        getShortStayDementiaRecuperationHospitalDivisionRadio().getParent().setEnabled(true);

        getShortStayDementiaRecuperationDivision().setEnabled(true);
        getShortStayDementiaRecuperationDivision().getParent().setEnabled(true);

        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getShortStayDementiaRecuperationType1().setEnabled(true);

        getShortStayDementiaRecuperationType2().setEnabled(false);

        getShortStayDementiaRecuperationType3().setEnabled(false);

        getShortStayDementiaRecuperationType4().setEnabled(false);

        getShortStayDementiaRecuperationType5().setEnabled(false);

  }

  /**
   * 「ユニット型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_UNIT_FORM() throws Exception {

        getShortStayDementiaRecuperationHospitalRoomRadio().setEnabled(false);

        getShortStayDementiaRecuperationUnitHospitalRoomRadio().setEnabled(true);

        getShortStayDementiaRecuperationHospitalDivisionRadio().setEnabled(true);
        getShortStayDementiaRecuperationHospitalDivisionRadio().getParent().setEnabled(true);

        getShortStayDementiaRecuperationDivision().setEnabled(true);
        getShortStayDementiaRecuperationDivision().getParent().setEnabled(true);

        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().setEnabled(true);
        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getShortStayDementiaRecuperationType1().setEnabled(false);

        getShortStayDementiaRecuperationType2().setEnabled(true);

        getShortStayDementiaRecuperationType3().setEnabled(true);

        getShortStayDementiaRecuperationType4().setEnabled(true);

        getShortStayDementiaRecuperationType5().setEnabled(true);

  }

  /**
   * 「日帰りショートステイ・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SELECT_SHORT_STAY() throws Exception {

        getShortStayDementiaRecuperationHospitalRoomRadio().setEnabled(false);

        getShortStayDementiaRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayDementiaRecuperationHospitalDivisionRadio().setEnabled(false);
        getShortStayDementiaRecuperationHospitalDivisionRadio().getParent().setEnabled(false);

        getShortStayDementiaRecuperationDivision().setEnabled(false);
        getShortStayDementiaRecuperationDivision().getParent().setEnabled(false);

        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

  }

  /**
   * 「ユニットケアの整備・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_UNIT_CARE() throws Exception {

        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().setEnabled(true);
        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(true);

  }

  /**
   * 「ユニットケアの整備・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_UNIT_CARE() throws Exception {

        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

  }

  /**
   * 「人員配置区分・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_STAFF_ASSIGNMENT() throws Exception {

        getShortStayDementiaRecuperationType2().setEnabled(true);

        getShortStayDementiaRecuperationType3().setEnabled(true);

  }

  /**
   * 「人員配置区分・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_STAFF_ASSIGNMENT() throws Exception {

        getShortStayDementiaRecuperationType1().setEnabled(true);

        getShortStayDementiaRecuperationType2().setEnabled(false);

        getShortStayDementiaRecuperationType3().setEnabled(false);

        getShortStayDementiaRecuperationType4().setEnabled(true);

        getShortStayDementiaRecuperationType5().setEnabled(true);

  }

  /**
   * 「人員配置区分・大学病院選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SELECT_HOSPITAL() throws Exception {

        getShortStayDementiaRecuperationType1().setEnabled(true);

        getShortStayDementiaRecuperationType2().setEnabled(false);

        getShortStayDementiaRecuperationType3().setEnabled(false);

        getShortStayDementiaRecuperationType4().setEnabled(false);

        getShortStayDementiaRecuperationType5().setEnabled(false);

  }

  /**
   * 「人員配置区分・大学病院非選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_UNSELECT_HOSPITAL() throws Exception {

        getShortStayDementiaRecuperationType1().setEnabled(false);

        getShortStayDementiaRecuperationType2().setEnabled(false);

        getShortStayDementiaRecuperationType3().setEnabled(false);

        getShortStayDementiaRecuperationType4().setEnabled(true);

        getShortStayDementiaRecuperationType5().setEnabled(true);

  }

  /**
   * 「人員配置区分・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_STAFF() throws Exception {

        getShortStayDementiaRecuperationDivision().setEnabled(true);
        getShortStayDementiaRecuperationDivision().getParent().setEnabled(true);

  }

  /**
   * 「人員配置区分・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_STAFF() throws Exception {

        getShortStayDementiaRecuperationDivision().setEnabled(false);
        getShortStayDementiaRecuperationDivision().getParent().setEnabled(false);

  }

  /**
   * 「人員配置区分Ⅰ型・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_STAFF_DIVISION1() throws Exception {

        getShortStayDementiaRecuperationType1().setEnabled(false);

        getShortStayDementiaRecuperationType2().setEnabled(true);

        getShortStayDementiaRecuperationType3().setEnabled(true);

        getShortStayDementiaRecuperationType4().setEnabled(true);

        getShortStayDementiaRecuperationType5().setEnabled(true);

  }

  /**
   * 「日帰りショートステイ・選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SHORT_STAY_SELECT() throws Exception {

        getShortStayDementiaRecuperationSickroomDivisionRadio().getParent().setVisible(true);

        getShortStayDementiaRecuperationSickroomDivisionRadio().setEnabled(true);
        getShortStayDementiaRecuperationSickroomDivisionRadio().getParent().setEnabled(true);

        getShortStayDementiaRecuperationHospitalRoomDivisionContena().setVisible(false);

        getTankinyusyoTimeDivision().setEnabled(true);

  }

  /**
   * 「日帰りショートステイ・非選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SHORT_STAY_UNSELECT() throws Exception {

        getShortStayDementiaRecuperationSickroomDivisionRadio().getParent().setVisible(false);

        getShortStayDementiaRecuperationSickroomDivisionRadio().setEnabled(false);
        getShortStayDementiaRecuperationSickroomDivisionRadio().getParent().setEnabled(false);

        getShortStayDementiaRecuperationHospitalRoomDivisionContena().setVisible(true);

        getTankinyusyoTimeDivision().setEnabled(false);

  }

  /**
   * 「経過型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_PASSAGE_FORM() throws Exception {

        getShortStayDementiaRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayDementiaRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayDementiaRecuperationHospitalDivisionRadio().setEnabled(false);
        getShortStayDementiaRecuperationHospitalDivisionRadio().getParent().setEnabled(false);

        getShortStayDementiaRecuperationDivision().setEnabled(false);
        getShortStayDementiaRecuperationDivision().getParent().setEnabled(false);

        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

  }

}
