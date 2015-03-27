
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
 * プログラム サービスパターン介護予防短期入所療養介護（介護老人保健施設） (QS001_12511_201504)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * サービスパターン介護予防短期入所療養介護（介護老人保健施設）状態定義(QS001_12511_201504) 
 */
public class QS001_12511_201504State extends QS001_12511_201504Design {
  /**
   * コンストラクタです。
   */
  public QS001_12511_201504State(){
  }

  /**
   * 「介護老人保健施設（I）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_1() throws Exception {

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio().setEnabled(true);

        getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio().setEnabled(false);

        getShortStayRecuperationHealthUnitCareAddRadio().setEnabled(false);
        getShortStayRecuperationHealthUnitCareAddRadio().getParent().setEnabled(false);

        getShortStayRecuperationHealthPersonnelDivision1RadioGroup().setEnabled(true);

        getShortStayRecuperationHealthPersonnelDivision2RadioGroup().setEnabled(false);

        getSpecialMedicalExpense().setEnabled(false);

        getRecuperationRadio().setEnabled(false);
        getRecuperationRadio().getParent().setEnabled(false);

  }

  /**
   * 「ユニット型介護老人保健施設（I）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_2() throws Exception {

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio().setEnabled(false);

        getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio().setEnabled(true);

        getShortStayRecuperationHealthUnitCareAddRadio().setEnabled(true);
        getShortStayRecuperationHealthUnitCareAddRadio().getParent().setEnabled(true);

        getShortStayRecuperationHealthPersonnelDivision1RadioGroup().setEnabled(true);

        getShortStayRecuperationHealthPersonnelDivision2RadioGroup().setEnabled(false);

        getSpecialMedicalExpense().setEnabled(false);

        getRecuperationRadio().setEnabled(false);
        getRecuperationRadio().getParent().setEnabled(false);

  }

  /**
   * 「介護老人保健施設（II）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_3() throws Exception {

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio().setEnabled(true);

        getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio().setEnabled(false);

        getShortStayRecuperationHealthUnitCareAddRadio().setEnabled(false);
        getShortStayRecuperationHealthUnitCareAddRadio().getParent().setEnabled(false);

        getShortStayRecuperationHealthPersonnelDivision1RadioGroup().setEnabled(false);

        getShortStayRecuperationHealthPersonnelDivision2RadioGroup().setEnabled(true);

        getSpecialMedicalExpense().setEnabled(true);

        getRecuperationRadio().setEnabled(true);
        getRecuperationRadio().getParent().setEnabled(true);

  }

  /**
   * 「ユニット型介護老人保健施設（II）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_4() throws Exception {

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio().setEnabled(false);

        getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio().setEnabled(true);

        getShortStayRecuperationHealthUnitCareAddRadio().setEnabled(true);
        getShortStayRecuperationHealthUnitCareAddRadio().getParent().setEnabled(true);

        getShortStayRecuperationHealthPersonnelDivision1RadioGroup().setEnabled(false);

        getShortStayRecuperationHealthPersonnelDivision2RadioGroup().setEnabled(true);

        getSpecialMedicalExpense().setEnabled(true);

        getRecuperationRadio().setEnabled(true);
        getRecuperationRadio().getParent().setEnabled(true);

  }

  /**
   * 「介護老人保健施設（III）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_5() throws Exception {

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio().setEnabled(true);

        getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio().setEnabled(false);

        getShortStayRecuperationHealthUnitCareAddRadio().setEnabled(false);
        getShortStayRecuperationHealthUnitCareAddRadio().getParent().setEnabled(false);

        getShortStayRecuperationHealthPersonnelDivision1RadioGroup().setEnabled(false);

        getShortStayRecuperationHealthPersonnelDivision2RadioGroup().setEnabled(true);

        getSpecialMedicalExpense().setEnabled(true);

        getRecuperationRadio().setEnabled(true);
        getRecuperationRadio().getParent().setEnabled(true);

  }

  /**
   * 「ユニット型介護老人保健施設（III）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_6() throws Exception {

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio().setEnabled(false);

        getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio().setEnabled(true);

        getShortStayRecuperationHealthUnitCareAddRadio().setEnabled(true);
        getShortStayRecuperationHealthUnitCareAddRadio().getParent().setEnabled(true);

        getShortStayRecuperationHealthPersonnelDivision1RadioGroup().setEnabled(false);

        getShortStayRecuperationHealthPersonnelDivision2RadioGroup().setEnabled(true);

        getSpecialMedicalExpense().setEnabled(true);

        getRecuperationRadio().setEnabled(true);
        getRecuperationRadio().getParent().setEnabled(true);

  }

  /**
   * 「食事テキスト・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DINNER_COST_ENABLE_FALSE() throws Exception {

        getShortStayRecuperationHealthFacilityDinnerCost().setEnabled(false);

  }

  /**
   * 「食事テキスト・有効」の状態に設定します。
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
