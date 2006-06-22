
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
 * 作成日: 2006/01/25  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービスパターン短期入所療養介護（基準適合診療所） (001)
 * プログラム サービスパターン短期入所療養介護（基準適合診療所） (QS001016)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * サービスパターン短期入所療養介護（基準適合診療所）状態定義(QS001016) 
 */
public class QS001016State extends QS001016Design {
  /**
   * コンストラクタです。
   */
  public QS001016State(){
  }

  /**
   * 「食事提供・あり」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_USE_MEAT() throws Exception {

        getShortStayStandardRecuperationDinnerCost().setEnabled(true);

  }

  /**
   * 「食事提供・なし」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_NOT_USE_MEAT() throws Exception {

        getShortStayStandardRecuperationDinnerCost().setEnabled(false);

  }

  /**
   * 「栄養管理体制加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_VALID_DIETICIAN_MANAGE() throws Exception {

        getShortStayStandardRecuperationDieticianManageRadio().setEnabled(true);

  }

  /**
   * 「栄養管理体制加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_INVALID_DIETICIAN_MANAGE() throws Exception {

        getShortStayStandardRecuperationDieticianManageRadio().setEnabled(false);

  }

  /**
   * 「療養食加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_VALID_MEDICAL_EXPENSES() throws Exception {

        getShortStayStandardRecuperationMedicalExpensesRadio().setEnabled(true);

  }

  /**
   * 「療養食加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_INVALID_MEDICAL_EXPENSES() throws Exception {

        getShortStayStandardRecuperationMedicalExpensesRadio().setEnabled(false);

  }

}
