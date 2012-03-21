
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
 * 作成日: 2011/11/16  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護予防訪問介護 (QS001_16111_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * サービスパターン介護予防訪問介護状態定義(QS001_16111_201204) 
 */
@SuppressWarnings("serial")
public class QS001_16111_201204State extends QS001_16111_201204Design {
  /**
   * コンストラクタです。
   */
  public QS001_16111_201204State(){
  }

  /**
   * 「Ⅲ型・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_EXPENSE_ADD_RADIO_ITEM_3_ENABLE_FALSE() throws Exception {

        getVisitCareExpenseAddRadioItem3().setEnabled(false);

  }

  /**
   * 「Ⅲ型・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_EXPENSE_ADD_RADIO_ITEM_3_ENABLE_TRUE() throws Exception {

        getVisitCareExpenseAddRadioItem3().setEnabled(true);

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
