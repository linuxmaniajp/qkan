
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
 * 作成日: 2012/03/08  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護老人保健施設 (QS001_15211_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * サービスパターン介護老人保健施設状態定義(QS001_15211_201204) 
 */
public class QS001_15211_201204State extends QS001_15211_201204Design {
  /**
   * コンストラクタです。
   */
  public QS001_15211_201204State(){
  }

  /**
   * 「食事提供・あり」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_USE_MEAT() throws Exception {

        getKaigoHealthCareOfTheAgedDinnerCost().setEnabled(true);

  }

  /**
   * 「食事提供・なし」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_NOT_USE_MEAT() throws Exception {

        getKaigoHealthCareOfTheAgedDinnerCost().setEnabled(false);

  }

  /**
   * 「経口移行・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_NUTRITION() throws Exception {

        getKaigoHealthCareOfTheAgedOralSwitchRadio().setEnabled(true);
        getKaigoHealthCareOfTheAgedOralSwitchRadio().getParent().setEnabled(true);

  }

  /**
   * 「経口移行・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_NUTRITION() throws Exception {

        getKaigoHealthCareOfTheAgedOralSwitchRadio().setEnabled(false);
        getKaigoHealthCareOfTheAgedOralSwitchRadio().getParent().setEnabled(false);

  }

  /**
   * 「経口維持加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_KEEP_NUTRITION() throws Exception {

        getOralMaintenanceAddRadio().setEnabled(true);
        getOralMaintenanceAddRadio().getParent().setEnabled(true);

  }

  /**
   * 「経口維持加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_KEEP_NUTRITION() throws Exception {

        getOralMaintenanceAddRadio().setEnabled(false);
        getOralMaintenanceAddRadio().getParent().setEnabled(false);

  }

  /**
   * 「外泊加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_GAIHAKU() throws Exception {

        getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadio().setEnabled(true);
        getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadio().getParent().setEnabled(true);

  }

  /**
   * 「外泊加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_GAIHAKU() throws Exception {

        getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadio().setEnabled(false);
        getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadio().getParent().setEnabled(false);

  }

  /**
   * 「介護老人保健施設（I）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_1() throws Exception {

        getKaigoHealthCareOfTheAgedHospitalRoomRadio().setEnabled(true);

        getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio().setEnabled(false);

        getUnitCareMaintenanceRadio().setEnabled(false);
        getUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getSpecialMedicalExpense().setEnabled(false);

        getIntentionCommunicationDifficultyAddRadio().setEnabled(true);
        getIntentionCommunicationDifficultyAddRadio().getParent().setEnabled(true);

        getKaigoHealthCareOfTheAgedHospitalDivision1().setEnabled(true);

        getKaigoHealthCareOfTheAgedHospitalDivision2().setEnabled(false);

        getStayReturnSupportAddRadio().setEnabled(false);
        getStayReturnSupportAddRadio().getParent().setEnabled(false);

        getRecuperationRadio().setEnabled(false);
        getRecuperationRadio().getParent().setEnabled(false);

  }

  /**
   * 「ユニット型介護老人保健施設（I）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_2() throws Exception {

        getKaigoHealthCareOfTheAgedHospitalRoomRadio().setEnabled(false);

        getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio().setEnabled(true);

        getUnitCareMaintenanceRadio().setEnabled(true);
        getUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getSpecialMedicalExpense().setEnabled(false);

        getIntentionCommunicationDifficultyAddRadio().setEnabled(false);
        getIntentionCommunicationDifficultyAddRadio().getParent().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision1().setEnabled(true);

        getKaigoHealthCareOfTheAgedHospitalDivision2().setEnabled(false);

        getStayReturnSupportAddRadio().setEnabled(false);
        getStayReturnSupportAddRadio().getParent().setEnabled(false);

        getRecuperationRadio().setEnabled(false);
        getRecuperationRadio().getParent().setEnabled(false);

  }

  /**
   * 「介護老人保健施設（II）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_3() throws Exception {

        getKaigoHealthCareOfTheAgedHospitalRoomRadio().setEnabled(true);

        getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio().setEnabled(false);

        getUnitCareMaintenanceRadio().setEnabled(false);
        getUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getSpecialMedicalExpense().setEnabled(true);

        getIntentionCommunicationDifficultyAddRadio().setEnabled(true);
        getIntentionCommunicationDifficultyAddRadio().getParent().setEnabled(true);

        getStayReturnSupportRyoyoAddRadio().setEnabled(false);
        getStayReturnSupportRyoyoAddRadio().getParent().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision1().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision2().setEnabled(true);

        getStayReturnSupportAddRadio().setEnabled(true);
        getStayReturnSupportAddRadio().getParent().setEnabled(true);

        getRecuperationRadio().setEnabled(true);
        getRecuperationRadio().getParent().setEnabled(true);

  }

  /**
   * 「ユニット型介護老人保健施設（II）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_4() throws Exception {

        getKaigoHealthCareOfTheAgedHospitalRoomRadio().setEnabled(false);

        getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio().setEnabled(true);

        getUnitCareMaintenanceRadio().setEnabled(true);
        getUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getSpecialMedicalExpense().setEnabled(true);

        getIntentionCommunicationDifficultyAddRadio().setEnabled(false);
        getIntentionCommunicationDifficultyAddRadio().getParent().setEnabled(false);

        getStayReturnSupportRyoyoAddRadio().setEnabled(false);
        getStayReturnSupportRyoyoAddRadio().getParent().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision1().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision2().setEnabled(true);

        getStayReturnSupportAddRadio().setEnabled(true);
        getStayReturnSupportAddRadio().getParent().setEnabled(true);

        getRecuperationRadio().setEnabled(true);
        getRecuperationRadio().getParent().setEnabled(true);

  }

  /**
   * 「介護老人保健施設（III）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_5() throws Exception {

        getKaigoHealthCareOfTheAgedHospitalRoomRadio().setEnabled(true);

        getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio().setEnabled(false);

        getUnitCareMaintenanceRadio().setEnabled(false);
        getUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getSpecialMedicalExpense().setEnabled(true);

        getIntentionCommunicationDifficultyAddRadio().setEnabled(true);
        getIntentionCommunicationDifficultyAddRadio().getParent().setEnabled(true);

        getStayReturnSupportRyoyoAddRadio().setEnabled(false);
        getStayReturnSupportRyoyoAddRadio().getParent().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision1().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision2().setEnabled(true);

        getStayReturnSupportAddRadio().setEnabled(true);
        getStayReturnSupportAddRadio().getParent().setEnabled(true);

        getRecuperationRadio().setEnabled(true);
        getRecuperationRadio().getParent().setEnabled(true);

  }

  /**
   * 「ユニット型介護老人保健施設（III）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_6() throws Exception {

        getKaigoHealthCareOfTheAgedHospitalRoomRadio().setEnabled(false);

        getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio().setEnabled(true);

        getUnitCareMaintenanceRadio().setEnabled(true);
        getUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getSpecialMedicalExpense().setEnabled(true);

        getIntentionCommunicationDifficultyAddRadio().setEnabled(false);
        getIntentionCommunicationDifficultyAddRadio().getParent().setEnabled(false);

        getStayReturnSupportRyoyoAddRadio().setEnabled(false);
        getStayReturnSupportRyoyoAddRadio().getParent().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision1().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision2().setEnabled(true);

        getStayReturnSupportAddRadio().setEnabled(true);
        getStayReturnSupportAddRadio().getParent().setEnabled(true);

        getRecuperationRadio().setEnabled(true);
        getRecuperationRadio().getParent().setEnabled(true);

  }

  /**
   * 「在宅復帰支援機能加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_STAY_RETURN() throws Exception {

        getStayReturnSupportRyoyoAddRadio().setEnabled(true);
        getStayReturnSupportRyoyoAddRadio().getParent().setEnabled(true);

  }

  /**
   * 「在宅復帰支援機能加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_STAY_RETURN() throws Exception {

        getStayReturnSupportRyoyoAddRadio().setEnabled(false);
        getStayReturnSupportRyoyoAddRadio().getParent().setEnabled(false);

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

}
