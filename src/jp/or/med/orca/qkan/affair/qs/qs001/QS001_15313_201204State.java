
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
 * プログラム サービスパターン介護療養型医療施設（認知症） (QS001_15313_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * サービスパターン介護療養型医療施設（認知症）状態定義(QS001_15313_201204) 
 */
public class QS001_15313_201204State extends QS001_15313_201204Design {
  /**
   * コンストラクタです。
   */
  public QS001_15313_201204State(){
  }

  /**
   * 「経口移行・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_NUTRITION() throws Exception {

        getMedicalFacilityCognitiveHospitalOralSwitchRadio().setEnabled(true);
        getMedicalFacilityCognitiveHospitalOralSwitchRadio().getParent().setEnabled(true);

  }

  /**
   * 「経口移行・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_NUTRITION() throws Exception {

        getMedicalFacilityCognitiveHospitalOralSwitchRadio().setEnabled(false);
        getMedicalFacilityCognitiveHospitalOralSwitchRadio().getParent().setEnabled(false);

  }

  /**
   * 「従来型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_CONVENTIONAL_FORM() throws Exception {

        getMedicalFacilityCognitiveHospitalHospitalRoomRadio().setEnabled(true);

        getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadio().setEnabled(false);

        getUnitCareMaintenanceRadio().setEnabled(false);
        getUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getHospitalDivisionRadio().setEnabled(true);
        getHospitalDivisionRadio().getParent().setEnabled(true);

  }

  /**
   * 「ユニット型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_UNIT_FORM() throws Exception {

        getMedicalFacilityCognitiveHospitalHospitalRoomRadio().setEnabled(false);

        getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadio().setEnabled(true);

        getUnitCareMaintenanceRadio().setEnabled(true);
        getUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getHospitalDivisionRadio().setEnabled(true);
        getHospitalDivisionRadio().getParent().setEnabled(true);

  }

  /**
   * 「食事提供・あり」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_USE_MEAT() throws Exception {

        getMedicalFacilityCognitiveHospitalDinnerCost().setEnabled(true);

  }

  /**
   * 「食事提供・なし」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_NOT_USE_MEAT() throws Exception {

        getMedicalFacilityCognitiveHospitalDinnerCost().setEnabled(false);

  }

  /**
   * 「人員配置区分・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_HUMAN_TYPE() throws Exception {

        getMedicalFacilityCognitiveHospitalHospitalDivision().setEnabled(true);
        getMedicalFacilityCognitiveHospitalHospitalDivision().getParent().setEnabled(true);

        getMedicalFacilityCognitiveHospitalDivision1().setEnabled(true);

        getMedicalFacilityCognitiveHospitalDivision2().setEnabled(true);

        getMedicalFacilityCognitiveHospitalDivision3().setEnabled(true);

        getMedicalFacilityCognitiveHospitalDivision4().setEnabled(true);

        getMedicalFacilityCognitiveHospitalDivision5().setEnabled(true);

  }

  /**
   * 「人員配置区分・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_HUMAN_TYPE() throws Exception {

        getMedicalFacilityCognitiveHospitalHospitalDivision().setEnabled(false);
        getMedicalFacilityCognitiveHospitalHospitalDivision().getParent().setEnabled(false);

        getMedicalFacilityCognitiveHospitalDivision1().setEnabled(false);

        getMedicalFacilityCognitiveHospitalDivision2().setEnabled(false);

        getMedicalFacilityCognitiveHospitalDivision3().setEnabled(false);

        getMedicalFacilityCognitiveHospitalDivision4().setEnabled(false);

        getMedicalFacilityCognitiveHospitalDivision5().setEnabled(false);

  }

  /**
   * 「人員配置区分制限・あり」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_USE_HUMAN_COST_DOWN() throws Exception {

        getMedicalFacilityCognitiveHospitalHospitalDivision().setEnabled(true);
        getMedicalFacilityCognitiveHospitalHospitalDivision().getParent().setEnabled(true);

        getMedicalFacilityCognitiveHospitalDivision1().setEnabled(true);

        getMedicalFacilityCognitiveHospitalDivision2().setEnabled(false);

        getMedicalFacilityCognitiveHospitalDivision3().setEnabled(false);

        getMedicalFacilityCognitiveHospitalDivision4().setEnabled(true);

        getMedicalFacilityCognitiveHospitalDivision5().setEnabled(true);

  }

  /**
   * 「人員配置区分・制限Ⅰ型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_USE_HUMAN_COST_DOWN1() throws Exception {

        getMedicalFacilityCognitiveHospitalDivision1().setEnabled(true);

        getMedicalFacilityCognitiveHospitalDivision2().setEnabled(false);

        getMedicalFacilityCognitiveHospitalDivision3().setEnabled(false);

        getMedicalFacilityCognitiveHospitalDivision4().setEnabled(false);

        getMedicalFacilityCognitiveHospitalDivision5().setEnabled(false);

  }

  /**
   * 「人員配置区分・制限Ⅰ型以外」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_USE_HUMAN_COST_DOWN_NOT1() throws Exception {

        getMedicalFacilityCognitiveHospitalDivision1().setEnabled(false);

        getMedicalFacilityCognitiveHospitalDivision2().setEnabled(true);

        getMedicalFacilityCognitiveHospitalDivision3().setEnabled(true);

        getMedicalFacilityCognitiveHospitalDivision4().setEnabled(true);

        getMedicalFacilityCognitiveHospitalDivision5().setEnabled(true);

  }

  /**
   * 「人員配置区分・制限・IV・V」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_USE_HUMAN_COST_DOWN14_OR_5() throws Exception {

        getMedicalFacilityCognitiveHospitalDivision1().setEnabled(false);

        getMedicalFacilityCognitiveHospitalDivision2().setEnabled(false);

        getMedicalFacilityCognitiveHospitalDivision3().setEnabled(false);

        getMedicalFacilityCognitiveHospitalDivision4().setEnabled(true);

        getMedicalFacilityCognitiveHospitalDivision5().setEnabled(true);

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
   * 「他科受信加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_TAKAJUSIN_ADD() throws Exception {

        getMedicalFacilityCognitiveHospitalMedicalExaminationRadio().setEnabled(true);
        getMedicalFacilityCognitiveHospitalMedicalExaminationRadio().getParent().setEnabled(true);

  }

  /**
   * 「他科受信加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_TAKAJUSIN_ADD() throws Exception {

        getMedicalFacilityCognitiveHospitalMedicalExaminationRadio().setEnabled(false);
        getMedicalFacilityCognitiveHospitalMedicalExaminationRadio().getParent().setEnabled(false);

  }

  /**
   * 「外泊加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_GAIHAKU_ADD() throws Exception {

        getMedicalFacilityCognitiveHospitalStayRadio().setEnabled(true);
        getMedicalFacilityCognitiveHospitalStayRadio().getParent().setEnabled(true);

  }

  /**
   * 「外泊加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_GAIHAKU_ADD() throws Exception {

        getMedicalFacilityCognitiveHospitalStayRadio().setEnabled(false);
        getMedicalFacilityCognitiveHospitalStayRadio().getParent().setEnabled(false);

  }

  /**
   * 「経過型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_PASSAGE_FORM() throws Exception {

        getMedicalFacilityCognitiveHospitalHospitalRoomRadio().setEnabled(true);

        getMedicalFacilityCognitiveHospitalUnitHospitalRoomRadio().setEnabled(false);

        getUnitCareMaintenanceRadio().setEnabled(false);
        getUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getMedicalFacilityCognitiveHospitalHospitalDivision().setEnabled(false);
        getMedicalFacilityCognitiveHospitalHospitalDivision().getParent().setEnabled(false);

        getHospitalDivisionRadio().setEnabled(false);
        getHospitalDivisionRadio().getParent().setEnabled(false);

  }

  /**
   * 「口腔機能維持管理加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_ORAL_CARE() throws Exception {

        getYoungDementiaPatinetAddRadioGroup().setEnabled(true);
        getYoungDementiaPatinetAddRadioGroup().getParent().setEnabled(true);

  }

  /**
   * 「口腔機能維持管理加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_ORAL_CARE() throws Exception {

        getYoungDementiaPatinetAddRadioGroup().setEnabled(false);
        getYoungDementiaPatinetAddRadioGroup().getParent().setEnabled(false);

  }

}
