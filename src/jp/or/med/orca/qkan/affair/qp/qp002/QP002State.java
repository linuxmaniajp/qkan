
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
 * 作成日: 2010/11/11  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 確認・修正 (002)
 * プログラム 帳票(様式)選択 (QP002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp002;
/**
 * 帳票(様式)選択状態定義(QP002) 
 */
public class QP002State extends QP002Design {
  /**
   * コンストラクタです。
   */
  public QP002State(){
  }

  /**
   * 「業務ボタン・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_AFFAIR_BUTTON_ENABLE_FALSE() throws Exception {

        getSeikyu().setEnabled(false);

        getSelect().setEnabled(false);

  }

  /**
   * 「業務ボタン・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_AFFAIR_BUTTON_ENABLE_TRUE() throws Exception {

        getSeikyu().setEnabled(true);

        getSelect().setEnabled(true);

  }

  /**
   * 「請求ボタン・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SEIKYU_BUTTON_ENABLE_FALSE() throws Exception {

        getSeikyu().setEnabled(false);

        getSelect().setEnabled(true);

  }

}
