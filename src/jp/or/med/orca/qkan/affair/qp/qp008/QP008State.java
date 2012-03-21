
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
 * 作成日: 2006/02/16  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス CSV出力 (008)
 * プログラム フォルダ選択 (QP008)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp008;
/**
 * フォルダ選択状態定義(QP008) 
 */
public class QP008State extends QP008Design {
  /**
   * コンストラクタです。
   */
  public QP008State(){
  }

  /**
   * 「初期状態」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INIT() throws Exception {

        getErrorPanel().setVisible(false);

        getFileSelects().setVisible(true);

        getGoBack().setEnabled(false);

        getCancel().setEnabled(true);

        getFilePath().setEditable(false);

  }

  /**
   * 「CSV出力完了時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INFO() throws Exception {

        getErrorPanel().setVisible(true);

        getFileSelects().setVisible(false);

        getGoBack().setEnabled(false);

        getCancel().setEnabled(false);

        getFilePath().setEditable(false);

  }

  /**
   * 「CSV出力エラー時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ERROR() throws Exception {

        getErrorPanel().setVisible(true);

        getFileSelects().setVisible(false);

        getGoBack().setEnabled(true);

        getCancel().setEnabled(true);

        getFilePath().setEditable(false);

  }

}
