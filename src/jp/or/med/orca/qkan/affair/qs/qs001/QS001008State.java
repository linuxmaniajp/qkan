
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
 * 作成日: 2012/08/08  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定 (S)
 * プロセス カレンダー (001)
 * プログラム 特定診療費・特別療養費集計 (QS001008)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * 特定診療費・特別療養費集計状態定義(QS001008) 
 */
public class QS001008State extends QS001008Design {
  /**
   * コンストラクタです。
   */
  public QS001008State(){
  }

  /**
   * 「ダイアログ無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_DIALOG_FALSE() throws Exception {

        getTokubetsuGroup().setEnabled(false);

        getDayDetailGroup().setEnabled(false);

        getTokubetsuTable().setEnabled(false);

        getDayDetailTable().setEnabled(false);

        getProviderCombo().setEnabled(false);
        getProviderCombo().getParent().setEnabled(false);

        getServiceCombo().setEnabled(false);
        getServiceCombo().getParent().setEnabled(false);

  }

  /**
   * 「ダイアログ有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_DIALOG_TRUE() throws Exception {

        getTokubetsuGroup().setEnabled(true);

        getDayDetailGroup().setEnabled(true);

        getTokubetsuTable().setEnabled(true);

        getDayDetailTable().setEnabled(true);

        getProviderCombo().setEnabled(true);
        getProviderCombo().getParent().setEnabled(true);

        getServiceCombo().setEnabled(true);
        getServiceCombo().getParent().setEnabled(true);

  }

}
