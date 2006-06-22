
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
 * 作成日: 2006/01/18  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービスパターン居宅療養管理指導 (001)
 * プログラム サービスパターン居宅療養管理指導 (QS001018)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * サービスパターン居宅療養管理指導状態定義(QS001018) 
 */
public class QS001017State extends QS001017Design {
  /**
   * コンストラクタです。
   */
  public QS001017State(){
  }

  /**
   * 「医師選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_DOCTOR() throws Exception {

        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().setEnabled(true);

        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().setEnabled(false);

        getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio().setEnabled(false);

  }

  /**
   * 「歯科医師選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_DENTAL() throws Exception {

        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().setEnabled(false);

        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().setEnabled(false);

        getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio().setEnabled(false);

  }

  /**
   * 「薬剤師（医療機関）選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_CHEMIST_HOSPITAL() throws Exception {

        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().setEnabled(false);

        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().setEnabled(true);

        getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio().setEnabled(false);

  }

  /**
   * 「薬剤師（薬局）選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_CHEMIST_PHARMACY() throws Exception {

        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().setEnabled(false);

        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().setEnabled(true);

        getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio().setEnabled(true);

  }

  /**
   * 「栄養士選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_DIETICIAN() throws Exception {

        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().setEnabled(false);

        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().setEnabled(false);

        getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio().setEnabled(false);

  }

  /**
   * 「歯科衛生士等選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_DENTAL_HYGIENIST() throws Exception {

        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().setEnabled(false);

        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().setEnabled(false);

        getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio().setEnabled(true);

  }

}
