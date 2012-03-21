
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
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護療養型医療施設（病院） (QS001_15311_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * サービスパターン介護療養型医療施設（病院）状態定義(QS001_15311_201204) 
 */
public class QS001_15311_201204State extends QS001_15311_201204Design {
  /**
   * コンストラクタです。
   */
  public QS001_15311_201204State(){
  }

  /**
   * 「経口移行・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_NUTRITION() throws Exception {

        getMedicalFacilityHospitalOralSwitchRadio().setEnabled(true);
        getMedicalFacilityHospitalOralSwitchRadio().getParent().setEnabled(true);

  }

  /**
   * 「経口移行・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_NUTRITION() throws Exception {

        getMedicalFacilityHospitalOralSwitchRadio().setEnabled(false);
        getMedicalFacilityHospitalOralSwitchRadio().getParent().setEnabled(false);

  }

  /**
   * 「従来型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_CONVENTIONAL_FORM() throws Exception {

        getMedicalFacilityHospitalHospitalRoomRadio().setEnabled(true);

        getMedicalFacilityHospitalUnitHospitalRoomRadio().setEnabled(false);

        getUnitCareMaintenanceRadio().setEnabled(false);
        getUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getMedicalFacilityHospitalHospitalDivision().setEnabled(true);
        getMedicalFacilityHospitalHospitalDivision().getParent().setEnabled(true);

        getTrialHijoRadio().setEnabled(false);
        getTrialHijoRadio().getParent().setEnabled(false);

  }

  /**
   * 「ユニット型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_UNIT_FORM() throws Exception {

        getMedicalFacilityHospitalHospitalRoomRadio().setEnabled(false);

        getMedicalFacilityHospitalUnitHospitalRoomRadio().setEnabled(true);

        getUnitCareMaintenanceRadio().setEnabled(true);
        getUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getMedicalFacilityHospitalHospitalDivision().setEnabled(false);
        getMedicalFacilityHospitalHospitalDivision().getParent().setEnabled(false);

        getTrialHijoRadio().setEnabled(false);
        getTrialHijoRadio().getParent().setEnabled(false);

  }

  /**
   * 「食事提供・あり」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_USE_MEAT() throws Exception {

        getMedicalFacilityDinnerCost().setEnabled(true);

  }

  /**
   * 「食事提供・なし」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_NOT_USE_MEAT() throws Exception {

        getMedicalFacilityDinnerCost().setEnabled(false);

  }

  /**
   * 「人員減算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_SUBTRACTION() throws Exception {

        getMedicalFacilityHospitalDivision1().setEnabled(true);

        getMedicalFacilityHospitalDivision2().setEnabled(true);

        getMedicalFacilityHospitalDivision3().setEnabled(true);

  }

  /**
   * 「人員減算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_SUBTRACTION() throws Exception {

        getMedicalFacilityHospitalDivision1().setEnabled(false);

        getMedicalFacilityHospitalDivision2().setEnabled(false);

        getMedicalFacilityHospitalDivision3().setEnabled(true);

  }

  /**
   * 「経口維持加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_KEEP_NUTRITION() throws Exception {

        getOralMaintenanceRadio().setEnabled(true);
        getOralMaintenanceRadio().getParent().setEnabled(true);

  }

  /**
   * 「経口維持加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_KEEP_NUTRITION() throws Exception {

        getOralMaintenanceRadio().setEnabled(false);
        getOralMaintenanceRadio().getParent().setEnabled(false);

  }

  /**
   * 「他科受信の有無・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_TAKAJYUSIN() throws Exception {

        getMedicalFacilityHospitalMedicalExaminationRadio().setEnabled(true);
        getMedicalFacilityHospitalMedicalExaminationRadio().getParent().setEnabled(true);

  }

  /**
   * 「他科受信の有無・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_TAKAJYUSIN() throws Exception {

        getMedicalFacilityHospitalMedicalExaminationRadio().setEnabled(false);
        getMedicalFacilityHospitalMedicalExaminationRadio().getParent().setEnabled(false);

  }

  /**
   * 「外泊加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_GAIHAKU() throws Exception {

        getMedicalFacilityHospitalStayRadio().setEnabled(true);
        getMedicalFacilityHospitalStayRadio().getParent().setEnabled(true);

  }

  /**
   * 「外泊加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_GAIHAKU() throws Exception {

        getMedicalFacilityHospitalStayRadio().setEnabled(false);
        getMedicalFacilityHospitalStayRadio().getParent().setEnabled(false);

  }

  /**
   * 「経過型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_PASSAGE_FORM() throws Exception {

        getMedicalFacilityHospitalHospitalRoomRadio().setEnabled(true);

        getMedicalFacilityHospitalUnitHospitalRoomRadio().setEnabled(false);

        getUnitCareMaintenanceRadio().setEnabled(false);
        getUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getMedicalFacilityHospitalHospitalDivision().setEnabled(true);
        getMedicalFacilityHospitalHospitalDivision().getParent().setEnabled(true);

        getTrialHijoRadio().setEnabled(true);
        getTrialHijoRadio().getParent().setEnabled(true);

  }

  /**
   * 「試行的退院・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_TRIAL_HIJO() throws Exception {

        getTrialHijoRadio().setEnabled(true);
        getTrialHijoRadio().getParent().setEnabled(true);

  }

  /**
   * 「試行的退院・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_TRIAL_HIJO() throws Exception {

        getTrialHijoRadio().setEnabled(false);
        getTrialHijoRadio().getParent().setEnabled(false);

  }

  /**
   * 「人員減算・無効（経過型_1）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_SUBTRACTION_3_ENABLE() throws Exception {

        getMedicalFacilityHospitalDivision1().setEnabled(true);

        getMedicalFacilityHospitalDivision2().setEnabled(true);

        getMedicalFacilityHospitalDivision3().setEnabled(false);

  }

  /**
   * 「人員減算・無効（経過型_2）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_SUBTRACTION_1_3_ENABLE() throws Exception {

        getMedicalFacilityHospitalDivision1().setEnabled(false);

        getMedicalFacilityHospitalDivision2().setEnabled(true);

        getMedicalFacilityHospitalDivision3().setEnabled(false);

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
