
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
 * 開発者: 堤 瑞樹
 * 作成日: 2006/01/27  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービスパターン介護老人保健施設 (001)
 * プログラム サービスパターン介護老人保健施設 (QS001022)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * サービスパターン介護老人保健施設状態定義(QS001022) 
 */
public class QS001022State extends QS001022Design {
  /**
   * コンストラクタです。
   */
  public QS001022State(){
  }

  /**
   * 「リハビリ機能強化加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_VALID_REHABILITATION() throws Exception {

        getKaigoHealthCareOfTheAgedRehabilitationRadio().setEnabled(true);

  }

  /**
   * 「リハビリ機能強化加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_INVALID_REHABILITATION() throws Exception {

        getKaigoHealthCareOfTheAgedRehabilitationRadio().setEnabled(false);

  }

  /**
   * 「認知症専門加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_VALID_SPECIAL() throws Exception {

        getKaigoHealthCareOfTheAgedDementiaRadio().setEnabled(true);

  }

  /**
   * 「認知症専門加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_INVALID_SPECIAL() throws Exception {

        getKaigoHealthCareOfTheAgedDementiaRadio().setEnabled(false);

  }

  /**
   * 「栄養管理・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_VALID_DIETICIAN_MANAGE() throws Exception {

        getKaigoHealthCareOfTheAgedNutritionManageRadio().setEnabled(true);

  }

  /**
   * 「栄養管理・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_INVALID_DIETICIAN_MANAGE() throws Exception {

        getKaigoHealthCareOfTheAgedNutritionManageRadio().setEnabled(false);

  }

  /**
   * 「栄養マネジメント・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_VALID_MANAGE() throws Exception {

        getKaigoHealthCareOfTheAgedNutritionRadio().setEnabled(true);

  }

  /**
   * 「栄養マネジメント・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_INVALID_MANAGE() throws Exception {

        getKaigoHealthCareOfTheAgedNutritionRadio().setEnabled(false);

  }

  /**
   * 「経口移行・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_VALID_NUTRITION() throws Exception {

        getKaigoHealthCareOfTheAgedOralSwitchRadio().setEnabled(true);

  }

  /**
   * 「経口移行・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_INVALID_NUTRITION() throws Exception {

        getKaigoHealthCareOfTheAgedOralSwitchRadio().setEnabled(false);

  }

  /**
   * 「療養食・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_VALID_MEDICAL_EXPENSES() throws Exception {

        getKaigoHealthCareOfTheAgedRecuperateDinnerRadio().setEnabled(true);

  }

  /**
   * 「療養食・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_INVALID_MEDICAL_EXPENSES() throws Exception {

        getKaigoHealthCareOfTheAgedRecuperateDinnerRadio().setEnabled(false);

  }

  /**
   * 「従来型」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_CONVENTIONAL_FORM() throws Exception {

        getKaigoHealthCareOfTheAgedHospitalRoomRadio().setEnabled(true);

        getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio().setEnabled(false);

  }

  /**
   * 「ユニット型」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_UNIT_FORM() throws Exception {

        getKaigoHealthCareOfTheAgedHospitalRoomRadio().setEnabled(false);

        getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio().setEnabled(true);

  }

  /**
   * 「食事提供・あり」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_USE_MEAT() throws Exception {

        getKaigoHealthCareOfTheAgedDinnerCost().setEnabled(true);

  }

  /**
   * 「食事提供・なし」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_NOT_USE_MEAT() throws Exception {

        getKaigoHealthCareOfTheAgedDinnerCost().setEnabled(false);

  }

}
