
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
 * プロセス サービスパターン介護療養型医療施設（診療所） (001)
 * プログラム サービスパターン介護療養型医療施設（診療所） (QS001024)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * サービスパターン介護療養型医療施設（診療所）状態定義(QS001024) 
 */
public class QS001024State extends QS001024Design {
  /**
   * コンストラクタです。
   */
  public QS001024State(){
  }

  /**
   * 「栄養管理・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_VALID_DIETICIAN_MANAGE() throws Exception {

        getMedicalFacilityClinicNutritionManageRadio().setEnabled(true);

  }

  /**
   * 「栄養管理・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_INVALID_DIETICIAN_MANAGE() throws Exception {

        getMedicalFacilityClinicNutritionManageRadio().setEnabled(false);

  }

  /**
   * 「栄養マネジメント・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_VALID_MANAGE() throws Exception {

        getMedicalFacilityClinicNutritionRadio().setEnabled(true);

  }

  /**
   * 「栄養マネジメント・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_INVALID_MANAGE() throws Exception {

        getMedicalFacilityClinicNutritionRadio().setEnabled(false);

  }

  /**
   * 「経口移行・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_VALID_NUTRITION() throws Exception {

        getMedicalFacilityClinicOralSwitchRadio().setEnabled(true);

  }

  /**
   * 「経口移行・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_INVALID_NUTRITION() throws Exception {

        getMedicalFacilityClinicOralSwitchRadio().setEnabled(false);

  }

  /**
   * 「療養食・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_VALID_MEDICAL_EXPENSES() throws Exception {

        getMedicalFacilityClinicRecuperateDinnerRadio().setEnabled(true);

  }

  /**
   * 「療養食・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_INVALID_MEDICAL_EXPENSES() throws Exception {

        getMedicalFacilityClinicRecuperateDinnerRadio().setEnabled(false);

  }

  /**
   * 「従来型」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_CONVENTIONAL_FORM() throws Exception {

        getMedicalFacilityClinicHospitalRoomRadio().setEnabled(true);

        getMedicalFacilityClinicUnitHospitalRoomRadio().setEnabled(false);

  }

  /**
   * 「ユニット型」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_UNIT_FORM() throws Exception {

        getMedicalFacilityClinicHospitalRoomRadio().setEnabled(false);

        getMedicalFacilityClinicUnitHospitalRoomRadio().setEnabled(true);

  }

  /**
   * 「食事提供・あり」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_USE_MEAT() throws Exception {

        getMedicalFacilityClinicDinnerCost().setEnabled(true);

  }

  /**
   * 「食事提供・なし」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_NOT_USE_MEAT() throws Exception {

        getMedicalFacilityClinicDinnerCost().setEnabled(false);

  }

}
