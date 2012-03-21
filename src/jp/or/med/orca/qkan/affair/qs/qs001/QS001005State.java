
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
 * 開発者: 田中　統蔵
 * 作成日: 2006/05/08  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム 集計明細画面 (QS001030)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * 集計明細画面状態定義(QS001030) 
 */
@SuppressWarnings("serial")
public class QS001005State extends QS001005Design {
  /**
   * コンストラクタです。
   */
  public QS001005State(){
  }

  /**
   * 「予定モード」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_PROCESS_TYPE_PLAN() throws Exception {

        getDetailsTableColumn4().setVisible(true);

        getDetailsTableColumn5().setVisible(true);

        getOuterTableColumn4().setVisible(true);

        getOuterTableColumn5().setVisible(true);

  }

  /**
   * 「実績モード」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_PROCESS_TYPE_RESULT() throws Exception {

        getDetailsTableColumn4().setVisible(false);

        getDetailsTableColumn5().setVisible(false);

        getOuterTableColumn4().setVisible(false);

        getOuterTableColumn5().setVisible(false);

  }

}
