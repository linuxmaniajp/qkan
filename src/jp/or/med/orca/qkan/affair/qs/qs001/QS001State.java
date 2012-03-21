
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
 * 開発者: 上司　和善
 * 作成日: 2011/12/13  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービス予定 (QS001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * サービス予定状態定義(QS001) 
 */
public class QS001State extends QS001Design {
  /**
   * コンストラクタです。
   */
  public QS001State(){
  }

  /**
   * 「更新モード」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_PROCESS_MODE_INSERT() throws Exception {

        getInsert().setVisible(true);

        getUpdate().setVisible(false);

  }

  /**
   * 「登録モード」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_PROCESS_MODE_UPDATE() throws Exception {

        getInsert().setVisible(false);

        getUpdate().setVisible(true);

  }

  /**
   * 「週間サービス計画票印刷」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_PRINT_WEEKLY() throws Exception {

        getPrintWeekly().setVisible(true);

        getPrintMonthly().setVisible(false);

        getOpenPlan().setEnabled(true);

        getOpenResult().setEnabled(false);

  }

  /**
   * 「利用票・提供票印刷」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_PRINT_MONTHLY() throws Exception {

        getPrintWeekly().setVisible(false);

        getPrintMonthly().setVisible(true);

        getOpenPlan().setEnabled(false);

        getOpenResult().setEnabled(true);

  }

  /**
   * 「サービスパターン選択」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SERVICE_PATTERN_SELECTED() throws Exception {

        getPatternDelete().setEnabled(true);

        getServiceDelete().setEnabled(false);

        getPatternNameChange().setEnabled(true);

  }

  /**
   * 「サービスパターン未選択」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SERVICE_PATTERN_UNSELECTED() throws Exception {

        getPatternDelete().setEnabled(false);

        getPatternNameChange().setEnabled(false);

  }

  /**
   * 「予定モード」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_AFFIR_MODE_PLAN() throws Exception {

        getClearPlan().setVisible(true);

        getOpenPlan().setVisible(true);

        getClearResult().setVisible(false);

        getOpenResult().setVisible(false);

  }

  /**
   * 「実績モード」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_AFFIR_MODE_RESULT() throws Exception {

        getPrintWeekly().setVisible(false);

        getClearPlan().setVisible(false);

        getOpenPlan().setVisible(false);

        getClearResult().setVisible(true);

        getOpenResult().setVisible(true);

  }

  /**
   * 「事業所情報使用サービス」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_USE_PROVIDER_SERVICE() throws Exception {

        getServiceOfferEntrepreneur().setEnabled(true);

  }

  /**
   * 「事業所情報未使用サービス」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_NOT_USE_PROVIDER_SERVICE() throws Exception {

        getServiceOfferEntrepreneur().setEnabled(false);

  }

  /**
   * 「サービス選択中」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SERVICE_SELECTED() throws Exception {

        getServiceSet().setEnabled(true);

        getServiceDelete().setEnabled(true);

  }

  /**
   * 「サービス未選択中」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SERVICE_UNSELECTED() throws Exception {

        getServiceSet().setEnabled(false);

        getServiceDelete().setEnabled(false);

  }

  /**
   * 「自事業所居宅介護支援未提供」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_NOT_PROVIDE_CARE_MANAGEMENT() throws Exception {

        getOpenResult().setVisible(false);

  }

  /**
   * 「自事業所居宅介護支援提供」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_PROVIDE_CARE_MANAGEMENT() throws Exception {

        getOpenResult().setVisible(true);

  }

  /**
   * 「サービス実績・週間計画表印刷無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_RESULT_PRINT_WEEKLY() throws Exception {

        getPrintWeekly().setEnabled(false);

  }

  /**
   * 「利用可能事業所」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_USABLE_PROVIDER() throws Exception {

        getServiceSet().setEnabled(true);

        getPatternAdd().setEnabled(true);

        getPicture().setEnabled(true);

  }

  /**
   * 「利用不能事業所」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_NOT_USABLE_PROVIDER() throws Exception {

        getServiceSet().setEnabled(false);

        getPatternAdd().setEnabled(false);

        getPicture().setEnabled(false);

  }

}
