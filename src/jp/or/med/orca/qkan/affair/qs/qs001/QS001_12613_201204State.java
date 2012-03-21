
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
 * 作成日: 2012/02/20  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護予防短期入所療養介護（認知症） (QS001_12613_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * サービスパターン介護予防短期入所療養介護（認知症）状態定義(QS001_12613_201204) 
 */
public class QS001_12613_201204State extends QS001_12613_201204Design {
  /**
   * コンストラクタです。
   */
  public QS001_12613_201204State(){
  }

  /**
   * 「画面状態１・認知症疾患型-大学病院」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_1() throws Exception {

        getShortStayDementiaRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayDementiaRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayDementiaRecuperationDivision().setEnabled(true);
        getShortStayDementiaRecuperationDivision().getParent().setEnabled(true);

        getShortStayDementiaRecuperationType1().setEnabled(true);

        getShortStayDementiaRecuperationType2().setEnabled(false);

        getShortStayDementiaRecuperationType3().setEnabled(false);

        getShortStayDementiaRecuperationType4().setEnabled(false);

        getShortStayDementiaRecuperationType5().setEnabled(false);

        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getShortStayDementiaRecuperationHospitalDivisionRadio().setEnabled(true);
        getShortStayDementiaRecuperationHospitalDivisionRadio().getParent().setEnabled(true);

  }

  /**
   * 「画面状態２・認知症疾患型-一般病院-(なし、定員超過、僻地届出無)」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_2() throws Exception {

        getShortStayDementiaRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayDementiaRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayDementiaRecuperationDivision().setEnabled(true);
        getShortStayDementiaRecuperationDivision().getParent().setEnabled(true);

        getShortStayDementiaRecuperationType1().setEnabled(false);

        getShortStayDementiaRecuperationType2().setEnabled(true);

        getShortStayDementiaRecuperationType3().setEnabled(true);

        getShortStayDementiaRecuperationType4().setEnabled(true);

        getShortStayDementiaRecuperationType5().setEnabled(true);

        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getShortStayDementiaRecuperationHospitalDivisionRadio().setEnabled(true);
        getShortStayDementiaRecuperationHospitalDivisionRadio().getParent().setEnabled(true);

  }

  /**
   * 「画面状態３・認知症疾患型-一般病院-(看護・介護職員の不足、正看比率が20%未満、僻地届出有)」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_3() throws Exception {

        getShortStayDementiaRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayDementiaRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayDementiaRecuperationDivision().setEnabled(true);
        getShortStayDementiaRecuperationDivision().getParent().setEnabled(true);

        getShortStayDementiaRecuperationType1().setEnabled(false);

        getShortStayDementiaRecuperationType2().setEnabled(false);

        getShortStayDementiaRecuperationType3().setEnabled(false);

        getShortStayDementiaRecuperationType4().setEnabled(true);

        getShortStayDementiaRecuperationType5().setEnabled(true);

        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getShortStayDementiaRecuperationHospitalDivisionRadio().setEnabled(true);
        getShortStayDementiaRecuperationHospitalDivisionRadio().getParent().setEnabled(true);

  }

  /**
   * 「画面状態４・ユニット型認知症疾患型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_4() throws Exception {

        getShortStayDementiaRecuperationHospitalRoomRadio().setEnabled(false);

        getShortStayDementiaRecuperationUnitHospitalRoomRadio().setEnabled(true);

        getShortStayDementiaRecuperationDivision().setEnabled(false);
        getShortStayDementiaRecuperationDivision().getParent().setEnabled(false);

        getShortStayDementiaRecuperationType1().setEnabled(false);

        getShortStayDementiaRecuperationType2().setEnabled(false);

        getShortStayDementiaRecuperationType3().setEnabled(false);

        getShortStayDementiaRecuperationType4().setEnabled(false);

        getShortStayDementiaRecuperationType5().setEnabled(false);

        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().setEnabled(true);
        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getShortStayDementiaRecuperationHospitalDivisionRadio().setEnabled(true);
        getShortStayDementiaRecuperationHospitalDivisionRadio().getParent().setEnabled(true);

  }

  /**
   * 「画面状態５・経過型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_5() throws Exception {

        getShortStayDementiaRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayDementiaRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayDementiaRecuperationDivision().setEnabled(false);
        getShortStayDementiaRecuperationDivision().getParent().setEnabled(false);

        getShortStayDementiaRecuperationType1().setEnabled(false);

        getShortStayDementiaRecuperationType2().setEnabled(false);

        getShortStayDementiaRecuperationType3().setEnabled(false);

        getShortStayDementiaRecuperationType4().setEnabled(false);

        getShortStayDementiaRecuperationType5().setEnabled(false);

        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getShortStayDementiaRecuperationHospitalDivisionRadio().setEnabled(false);
        getShortStayDementiaRecuperationHospitalDivisionRadio().getParent().setEnabled(false);

  }

  /**
   * 「食費テキスト・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DINNER_COST_ENABLE_FALSE() throws Exception {

        getShortStayDementiaRecuperationDinnerCost().setEnabled(false);

  }

  /**
   * 「食費テキスト・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DINNER_COST_ENABLE_TRUE() throws Exception {

        getShortStayDementiaRecuperationDinnerCost().setEnabled(true);

  }

}
