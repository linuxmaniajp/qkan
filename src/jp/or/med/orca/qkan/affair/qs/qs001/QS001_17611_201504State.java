
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
 * プロセス サービスパターン地域密着型特定施設入居者生活介護 (001)
 * プログラム サービスパターン定期巡回・随時対応型訪問介護看護 (QS001_17611_201504)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * サービスパターン定期巡回・随時対応型訪問介護看護状態定義(QS001_17611_201504) 
 */
public class QS001_17611_201504State extends QS001_17611_201504Design {
  /**
   * コンストラクタです。
   */
  public QS001_17611_201504State(){
  }

  /**
   * 「施設区分・一体型（指示なし）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DIVISION_STATE_1() throws Exception {

        getSijishoOfferRadioGroup().setEnabled(true);
        getSijishoOfferRadioGroup().getParent().setEnabled(true);

        getEmergencyVisitRadioGroup().setEnabled(false);
        getEmergencyVisitRadioGroup().getParent().setEnabled(false);

        getSpecialManagementRadioGroup().setEnabled(false);
        getSpecialManagementRadioGroup().getParent().setEnabled(false);

        getTerminalCareRadioGroup().setEnabled(false);
        getTerminalCareRadioGroup().getParent().setEnabled(false);

        getNurseStaffDivisionRadioGroup().setEnabled(false);
        getNurseStaffDivisionRadioGroup().getParent().setEnabled(false);

  }

  /**
   * 「施設区分・一体型（指示あり）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DIVISION_STATE_2() throws Exception {

        getSijishoOfferRadioGroup().setEnabled(true);
        getSijishoOfferRadioGroup().getParent().setEnabled(true);

        getEmergencyVisitRadioGroup().setEnabled(true);
        getEmergencyVisitRadioGroup().getParent().setEnabled(true);

        getSpecialManagementRadioGroup().setEnabled(true);
        getSpecialManagementRadioGroup().getParent().setEnabled(true);

        getTerminalCareRadioGroup().setEnabled(true);
        getTerminalCareRadioGroup().getParent().setEnabled(true);

        getNurseStaffDivisionRadioGroup().setEnabled(true);
        getNurseStaffDivisionRadioGroup().getParent().setEnabled(true);

  }

  /**
   * 「施設区分・状態３」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DIVISION_STATE_3() throws Exception {

        getSijishoOfferRadioGroup().setEnabled(false);
        getSijishoOfferRadioGroup().getParent().setEnabled(false);

        getEmergencyVisitRadioGroup().setEnabled(false);
        getEmergencyVisitRadioGroup().getParent().setEnabled(false);

        getSpecialManagementRadioGroup().setEnabled(false);
        getSpecialManagementRadioGroup().getParent().setEnabled(false);

        getTerminalCareRadioGroup().setEnabled(false);
        getTerminalCareRadioGroup().getParent().setEnabled(false);

        getNurseStaffDivisionRadioGroup().setEnabled(false);
        getNurseStaffDivisionRadioGroup().getParent().setEnabled(false);

  }

  /**
   * 「日割チェック有り」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DAY_CHECK_ON() throws Exception {

        getPrintable().setEnabled(true);

  }

  /**
   * 「日割チェック無し」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DAY_CHECK_OFF() throws Exception {

        getPrintable().setEnabled(false);

  }

}
