
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
 * プロセス サービスパターン居宅療養管理指導 (001)
 * プログラム サービスパターン居宅療養管理指導 (QS001_13111_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * サービスパターン居宅療養管理指導状態定義(QS001_13111_201204) 
 */
public class QS001_13111_201204State extends QS001_13111_201204Design {
  /**
   * コンストラクタです。
   */
  public QS001_13111_201204State(){
  }

  /**
   * 「医師選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DOCTOR() throws Exception {

        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().setEnabled(true);
        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().getParent().setEnabled(true);

        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().setEnabled(false);
        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().getParent().setEnabled(false);

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(false);

        getKyotakuClass().setEnabled(false);
        getKyotakuClass().getParent().setEnabled(false);

        getPatientRadioGroup().setEnabled(true);
        getPatientRadioGroup().getParent().setEnabled(true);

  }

  /**
   * 「薬剤師（医療機関）選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_CHEMIST_HOSPITAL() throws Exception {

        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().setEnabled(false);
        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().getParent().setEnabled(false);

        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().setEnabled(true);
        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().getParent().setEnabled(true);

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(false);

        getKyotakuClass().setEnabled(false);
        getKyotakuClass().getParent().setEnabled(false);

        getPatientRadioGroup().setEnabled(true);
        getPatientRadioGroup().getParent().setEnabled(true);

  }

  /**
   * 「薬剤師（薬局）選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_CHEMIST_PHARMACY() throws Exception {

        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().setEnabled(false);
        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().getParent().setEnabled(false);

        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().setEnabled(true);
        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().getParent().setEnabled(true);

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(true);

        getKyotakuClass().setEnabled(false);
        getKyotakuClass().getParent().setEnabled(false);

        getPatientRadioGroup().setEnabled(true);
        getPatientRadioGroup().getParent().setEnabled(true);

  }

  /**
   * 「栄養士・歯科衛生士等選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DIETICIAN() throws Exception {

        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().setEnabled(false);
        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().getParent().setEnabled(false);

        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().setEnabled(false);
        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().getParent().setEnabled(false);

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(false);

        getKyotakuClass().setEnabled(false);
        getKyotakuClass().getParent().setEnabled(false);

        getPatientRadioGroup().setEnabled(true);
        getPatientRadioGroup().getParent().setEnabled(true);

  }

  /**
   * 「歯科医師選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DENTAL_DOCTOR() throws Exception {

        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().setEnabled(false);
        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().getParent().setEnabled(false);

        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().setEnabled(false);
        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().getParent().setEnabled(false);

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(false);

        getKyotakuClass().setEnabled(false);
        getKyotakuClass().getParent().setEnabled(false);

        getPatientRadioGroup().setEnabled(true);
        getPatientRadioGroup().getParent().setEnabled(true);

  }

  /**
   * 「看護職員」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_KANGO() throws Exception {

        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().setEnabled(false);
        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().getParent().setEnabled(false);

        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().setEnabled(false);
        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().getParent().setEnabled(false);

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(false);

        getKyotakuClass().setEnabled(true);
        getKyotakuClass().getParent().setEnabled(true);

        getPatientRadioGroup().setEnabled(true);
        getPatientRadioGroup().getParent().setEnabled(true);

  }

  /**
   * 「施設区分・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_PATIENT_RADIO() throws Exception {

        getPatientRadioGroup().setEnabled(true);
        getPatientRadioGroup().getParent().setEnabled(true);

  }

  /**
   * 「施設区分・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_PATIENT_RADIO() throws Exception {

        getPatientRadioGroup().setEnabled(false);
        getPatientRadioGroup().getParent().setEnabled(false);

  }

  /**
   * 「がん末期・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_GAN_MAKKI() throws Exception {

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(false);

  }

  /**
   * 「がん末期・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_GAN_MAKKI() throws Exception {

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(true);

  }

}
