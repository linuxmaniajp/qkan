
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
 * プログラム サービスパターン介護予防短期入所療養介護（病院） (QS001_12611_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * サービスパターン介護予防短期入所療養介護（病院）状態定義(QS001_12611_201204) 
 */
public class QS001_12611_201204State extends QS001_12611_201204Design {
  /**
   * コンストラクタです。
   */
  public QS001_12611_201204State(){
  }

  /**
   * 「画面状態１　病院-人員(なし・定員超過・僻地届出有)」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_1() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationDivision().setEnabled(true);
        getShortStayHospitalRecuperationDivision().getParent().setEnabled(true);

        getShortStayHospitalRecuperationType1().setEnabled(true);

        getShortStayHospitalRecuperationType2().setEnabled(true);

        getShortStayHospitalRecuperationType3().setEnabled(true);

  }

  /**
   * 「画面状態２　病院-人員(看護・介護職員の不足・正看比率が20%未満・僻地届出無)」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_2() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationDivision().setEnabled(true);
        getShortStayHospitalRecuperationDivision().getParent().setEnabled(true);

        getShortStayHospitalRecuperationType1().setEnabled(false);

        getShortStayHospitalRecuperationType2().setEnabled(false);

        getShortStayHospitalRecuperationType3().setEnabled(true);

  }

  /**
   * 「画面状態３　ユニット型病院」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_3() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(true);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(true);
        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getShortStayHospitalRecuperationDivision().setEnabled(false);
        getShortStayHospitalRecuperationDivision().getParent().setEnabled(false);

        getShortStayHospitalRecuperationType1().setEnabled(false);

        getShortStayHospitalRecuperationType2().setEnabled(false);

        getShortStayHospitalRecuperationType3().setEnabled(false);

  }

  /**
   * 「画面状態４　経過型-人員(なし・定員超過・僻地届出有)」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_4() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationDivision().setEnabled(true);
        getShortStayHospitalRecuperationDivision().getParent().setEnabled(true);

        getShortStayHospitalRecuperationType1().setEnabled(true);

        getShortStayHospitalRecuperationType2().setEnabled(true);

        getShortStayHospitalRecuperationType3().setEnabled(false);

  }

  /**
   * 「画面状態５　経過型-人員(看護・介護職員の不足・正看比率が20%未満・僻地届出無)」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_5() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getShortStayHospitalRecuperationDivision().setEnabled(true);
        getShortStayHospitalRecuperationDivision().getParent().setEnabled(true);

        getShortStayHospitalRecuperationType1().setEnabled(false);

        getShortStayHospitalRecuperationType2().setEnabled(true);

        getShortStayHospitalRecuperationType3().setEnabled(false);

  }

  /**
   * 「画面状態６　ユニット型経過型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_6() throws Exception {

        getShortStayHospitalRecuperationHospitalRoomRadio().setEnabled(false);

        getShortStayHospitalRecuperationUnitHospitalRoomRadio().setEnabled(true);

        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().setEnabled(true);
        getShortStayHospitalRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getShortStayHospitalRecuperationDivision().setEnabled(false);
        getShortStayHospitalRecuperationDivision().getParent().setEnabled(false);

        getShortStayHospitalRecuperationType1().setEnabled(false);

        getShortStayHospitalRecuperationType2().setEnabled(false);

        getShortStayHospitalRecuperationType3().setEnabled(false);

  }

  /**
   * 「食費テキスト・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DINNER_COST_ENABLE_FALSE() throws Exception {

        getShortStayRecuperationHealthFacilityDinnerCost().setEnabled(false);

  }

  /**
   * 「食費テキスト・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DINNER_COST_ENABLE_TRUE() throws Exception {

        getShortStayRecuperationHealthFacilityDinnerCost().setEnabled(true);

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

}
