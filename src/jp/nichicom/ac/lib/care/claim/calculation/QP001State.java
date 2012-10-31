
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
 * 開発者: 藤原　伸
 * 作成日: 2011/02/10  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 実績確定/請求書出力 (P)
 * プロセス 請求処理 (001)
 * プログラム 利用者一覧（請求） (QP001)
 *
 *****************************************************************
 */
package jp.nichicom.ac.lib.care.claim.calculation;
/**
 * 利用者一覧（請求）状態定義(QP001) 
 */
@SuppressWarnings("serial")
public class QP001State extends QP001Design {
  /**
   * コンストラクタです。
   */
  public QP001State(){
  }

  /**
   * 「利用者一覧（実績確定・請求データ作成）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INIT_01() throws Exception {

        getEntry().setVisible(true);

        getEntry().setEnabled(false);

        getFind().setVisible(true);

        getDelete().setVisible(true);

        getDelete().setEnabled(false);

        getPrint().setVisible(false);

        getPrint().setEnabled(false);

        getCsvOut().setVisible(false);

        getCsvOut().setEnabled(false);

        getCommit().setVisible(true);

        getCommit().setEnabled(false);

        getClaimDateContainer().setVisible(false);

        getPrintConditions().setVisible(false);

        getTypeCountInfomations().setVisible(false);

        getDemandMoneyAndTotalDenominations().setVisible(false);

        getInfoTableColumn14().setVisible(false);

        getInfoTableColumn17().setVisible(false);

        getInfoTableColumn18().setVisible(false);

        getInfoTableColumn19().setVisible(false);

        getInfoTableColumn20().setVisible(false);

        getInfoTableColumn21().setVisible(false);

        getInfoTableColumn22().setVisible(false);

        getInfoTableColumn23().setVisible(false);

        getPrintList().setVisible(false);

        getPrintList().setEnabled(false);

  }

  /**
   * 「利用者一覧（給付管理票）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INIT_02() throws Exception {

        getEntry().setVisible(false);

        getFind().setVisible(true);

        getDelete().setVisible(false);

        getPrint().setVisible(true);

        getPrint().setEnabled(false);

        getCsvOut().setVisible(true);

        getCsvOut().setEnabled(false);

        getCommit().setVisible(false);

        getTargetDateContena().setVisible(false);

        getPrintConditions().setVisible(false);

        getUpdateConditions().setVisible(false);

        getNursingCountContainer().setVisible(false);

        getType7CountContainer().setVisible(false);

        getType2CountContainer().setVisible(false);

        getType3CountContainer().setVisible(false);

        getType4CountContainer().setVisible(false);

        getType5CountContainer().setVisible(false);

        getType6CountContainer().setVisible(false);

        getType8CountContainer().setVisible(false);

        getType9CountContainer().setVisible(false);

        getType10CountContainer().setVisible(false);

        getVisitCountContainer().setVisible(false);

        getSyahoCountContainer().setVisible(false);

        getKokuhoCountContainer().setVisible(false);

        getServiceCountContainer().setVisible(false);

        getDemandMoneyAndTotalDenominations().setVisible(false);

        getInfoTableColumn4().setVisible(false);

        getInfoTableColumn14().setVisible(false);

        getInfoTableColumn17().setVisible(false);

        getInfoTableColumn18().setVisible(false);

        getInfoTableColumn19().setVisible(false);

        getInfoTableColumn20().setVisible(false);

        getInfoTableColumn21().setVisible(false);

        getInfoTableColumn22().setVisible(false);

        getPrintList().setVisible(false);

        getPrintList().setEnabled(false);

  }

  /**
   * 「利用者一覧（在宅サービス支援事業所請求）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INIT_03() throws Exception {

        getEntry().setVisible(false);

        getFind().setVisible(true);

        getDelete().setVisible(false);

        getPrint().setVisible(true);

        getPrint().setEnabled(false);

        getCsvOut().setVisible(false);

        getCsvOut().setEnabled(false);

        getCommit().setVisible(false);

        getTargetDateContena().setVisible(false);

        getPrintConditions().setVisible(false);

        getUpdateConditions().setVisible(false);

        getSupplyCountContainer().setVisible(false);

        getNursingCountContainer().setVisible(false);

        getType2CountContainer().setVisible(false);

        getType3CountContainer().setVisible(false);

        getType4CountContainer().setVisible(false);

        getType5CountContainer().setVisible(false);

        getType6CountContainer().setVisible(false);

        getType8CountContainer().setVisible(false);

        getType9CountContainer().setVisible(false);

        getType10CountContainer().setVisible(false);

        getVisitCountContainer().setVisible(false);

        getSyahoCountContainer().setVisible(false);

        getKokuhoCountContainer().setVisible(false);

        getServiceCountContainer().setVisible(false);

        getDemandMoneyInsuranceMoneyTextContainer().setVisible(false);

        getDemandMoneyPatientMoneyTextContainer().setVisible(false);

        getTotalDenominationPublicExpenseMoneyTextContainer().setVisible(false);

        getInfoTableColumn4().setVisible(false);

        getInfoTableColumn17().setVisible(false);

        getInfoTableColumn20().setVisible(false);

        getInfoTableColumn21().setVisible(false);

        getInfoTableColumn22().setVisible(false);

        getInfoTableColumn23().setVisible(false);

        getPrintList().setVisible(false);

        getPrintList().setEnabled(false);

  }

  /**
   * 「利用者一覧（在宅サービス提供事業所請求）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INIT_04() throws Exception {

        getEntry().setVisible(false);

        getFind().setVisible(true);

        getDelete().setVisible(false);

        getPrint().setVisible(true);

        getPrint().setEnabled(false);

        getCsvOut().setVisible(false);

        getCsvOut().setEnabled(false);

        getCommit().setVisible(false);

        getTargetDateContena().setVisible(false);

        getPrintConditions().setVisible(false);

        getUpdateConditions().setVisible(false);

        getSupplyCountContainer().setVisible(false);

        getNursingCountContainer().setVisible(false);

        getType7CountContainer().setVisible(false);

        getVisitCountContainer().setVisible(false);

        getSyahoCountContainer().setVisible(false);

        getKokuhoCountContainer().setVisible(false);

        getServiceCountContainer().setVisible(false);

        getInfoTableColumn4().setVisible(false);

        getInfoTableColumn23().setVisible(false);

        getPrintList().setVisible(true);

        getPrintList().setEnabled(false);

  }

  /**
   * 「利用者一覧（施設サービス提供事業者請求）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INIT_05() throws Exception {

        getEntry().setVisible(false);

        getFind().setVisible(true);

        getDelete().setVisible(false);

        getPrint().setVisible(true);

        getPrint().setEnabled(false);

        getCsvOut().setVisible(false);

        getCsvOut().setEnabled(false);

        getCommit().setVisible(false);

        getTargetDateContena().setVisible(false);

        getPrintConditions().setVisible(false);

        getUpdateConditions().setVisible(false);

        getSupplyCountContainer().setVisible(false);

        getNursingCountContainer().setVisible(false);

        getType7CountContainer().setVisible(false);

        getType2CountContainer().setVisible(false);

        getType3CountContainer().setVisible(false);

        getType4CountContainer().setVisible(false);

        getType5CountContainer().setVisible(false);

        getType6CountContainer().setVisible(false);

        getVisitCountContainer().setVisible(false);

        getSyahoCountContainer().setVisible(false);

        getKokuhoCountContainer().setVisible(false);

        getServiceCountContainer().setVisible(false);

        getInfoTableColumn4().setVisible(false);

        getInfoTableColumn23().setVisible(false);

        getPrintList().setVisible(true);

        getPrintList().setEnabled(false);

  }

  /**
   * 「利用者一覧（医療請求）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INIT_06() throws Exception {

        getEntry().setVisible(false);

        getFind().setVisible(true);

        getDelete().setVisible(false);

        getPrint().setVisible(true);

        getPrint().setEnabled(false);

        getCsvOut().setVisible(false);

        getCommit().setVisible(false);

        getTargetDateContena().setVisible(false);

        getUpdateConditions().setVisible(false);

        getSupplyCountContainer().setVisible(false);

        getNursingCountContainer().setVisible(false);

        getType7CountContainer().setVisible(false);

        getType2CountContainer().setVisible(false);

        getType3CountContainer().setVisible(false);

        getType4CountContainer().setVisible(false);

        getType5CountContainer().setVisible(false);

        getType6CountContainer().setVisible(false);

        getType8CountContainer().setVisible(false);

        getType9CountContainer().setVisible(false);

        getType10CountContainer().setVisible(false);

        getServiceCountContainer().setVisible(false);

        getTotalDenominationTextContainer().setVisible(false);

        getDemandMoneyInsuranceMoneyTextContainer().setVisible(false);

        getTotalDenominationPublicExpenseMoneyTextContainer().setVisible(false);

        getInfoTableColumn4().setVisible(false);

        getInfoTableColumn14().setVisible(false);

        getInfoTableColumn17().setVisible(false);

        getInfoTableColumn18().setVisible(false);

        getInfoTableColumn20().setVisible(false);

        getInfoTableColumn21().setVisible(false);

        getInfoTableColumn23().setVisible(false);

        getPrintList().setVisible(false);

        getPrintList().setEnabled(false);

  }

  /**
   * 「利用者一覧(利用者向け印刷)」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INIT_07() throws Exception {

        getEntry().setVisible(false);

        getFind().setVisible(true);

        getDelete().setVisible(false);

        getPrint().setVisible(true);

        getPrint().setEnabled(false);

        getCsvOut().setVisible(false);

        getCommit().setVisible(false);

        getTargetDateContena().setVisible(false);

        getPrintConditions().setVisible(false);

        getUpdateConditions().setVisible(false);

        getSupplyCountContainer().setVisible(false);

        getNursingCountContainer().setVisible(false);

        getType7CountContainer().setVisible(false);

        getType2CountContainer().setVisible(false);

        getType3CountContainer().setVisible(false);

        getType4CountContainer().setVisible(false);

        getType5CountContainer().setVisible(false);

        getType6CountContainer().setVisible(false);

        getType8CountContainer().setVisible(false);

        getType9CountContainer().setVisible(false);

        getType10CountContainer().setVisible(false);

        getVisitCountContainer().setVisible(false);

        getSyahoCountContainer().setVisible(false);

        getKokuhoCountContainer().setVisible(false);

        getTypeCountInfomations().setVisible(false);

        getDemandMoneyAndTotalDenominations().setVisible(false);

        getInfoTableColumn4().setVisible(false);

        getInfoTableColumn14().setVisible(false);

        getInfoTableColumn17().setVisible(false);

        getInfoTableColumn18().setVisible(false);

        getInfoTableColumn19().setVisible(false);

        getInfoTableColumn20().setVisible(false);

        getInfoTableColumn21().setVisible(false);

        getInfoTableColumn22().setVisible(false);

        getInfoTableColumn23().setVisible(false);

        getPrintList().setVisible(false);

        getPrintList().setEnabled(false);

  }

  /**
   * 「利用者一覧（介護給付費請求書）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INIT_08() throws Exception {

        getEntry().setVisible(false);

        getFind().setVisible(true);

        getDelete().setVisible(false);

        getPrint().setVisible(true);

        getPrint().setEnabled(false);

        getCsvOut().setVisible(true);

        getCsvOut().setEnabled(false);

        getCommit().setVisible(false);

        getTargetDateContena().setVisible(false);

        getUpdateConditions().setVisible(false);

        getSupplyCountContainer().setVisible(false);

        getType7CountContainer().setVisible(false);

        getType2CountContainer().setVisible(false);

        getType3CountContainer().setVisible(false);

        getType4CountContainer().setVisible(false);

        getType5CountContainer().setVisible(false);

        getType6CountContainer().setVisible(false);

        getType8CountContainer().setVisible(false);

        getType9CountContainer().setVisible(false);

        getType10CountContainer().setVisible(false);

        getVisitCountContainer().setVisible(false);

        getSyahoCountContainer().setVisible(false);

        getKokuhoCountContainer().setVisible(false);

        getServiceCountContainer().setVisible(false);

        getTypeCountInfomations().setVisible(false);

        getDemandMoneyAndTotalDenominations().setVisible(false);

        getInfoTableColumn4().setVisible(false);

        getInfoTableColumn14().setVisible(false);

        getInfoTableColumn17().setVisible(false);

        getInfoTableColumn18().setVisible(false);

        getInfoTableColumn19().setVisible(false);

        getInfoTableColumn20().setVisible(false);

        getInfoTableColumn21().setVisible(false);

        getInfoTableColumn22().setVisible(false);

        getInfoTableColumn23().setVisible(false);

        getPrintList().setVisible(false);

        getPrintList().setEnabled(false);

  }

  /**
   * 「検索結果有(集計データあり選択)」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SELECTED_CLAIM() throws Exception {

        getEntry().setEnabled(true);

        getDelete().setEnabled(false);

        getPrint().setEnabled(true);

        getCsvOut().setEnabled(true);

        getCommit().setEnabled(true);

        getPrintList().setEnabled(true);

  }

  /**
   * 「検索結果有(集計データあり選択)」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SELECTED_NO_CLAIM() throws Exception {

        getEntry().setEnabled(false);

        getDelete().setEnabled(false);

        getPrint().setEnabled(true);

        getCsvOut().setEnabled(true);

        getCommit().setEnabled(true);

        getPrintList().setEnabled(true);

  }

  /**
   * 「検索結果無し」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_UNSELECTED() throws Exception {

        getEntry().setEnabled(false);

        getDelete().setEnabled(false);

        getPrint().setEnabled(false);

        getCsvOut().setEnabled(false);

        getCommit().setEnabled(false);

        getPrintList().setEnabled(false);

  }

  /**
   * 「請求年月変更許可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_CLAIM_DATE_ENABLE() throws Exception {

        getClaimDateUpdate().setEditable(true);

  }

  /**
   * 「請求年月変更不可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_CLAIM_DATE_DISABLE() throws Exception {

        getClaimDateUpdate().setEditable(false);

  }

}
