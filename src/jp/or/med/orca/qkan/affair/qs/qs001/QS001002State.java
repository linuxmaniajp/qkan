
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
 * 作成日: 2006/02/06  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム 月間表 (QS001002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * 月間表状態定義(QS001002) 
 */
public class QS001002State extends QS001002Design {
  /**
   * コンストラクタです。
   */
  public QS001002State(){
  }

  /**
   * 「サービス選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SERVICE_SELECTED() throws Exception {

        getCoordinatePrivateExpenses().setEnabled(true);

  }

  /**
   * 「サービス未選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SERVICE_UNSELECTED() throws Exception {

        getCoordinatePrivateExpenses().setEnabled(false);

  }

  /**
   * 「初期状態」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INIT_STATE() throws Exception {

        getLimit().setEditable(false);

        getLimitAmount().setEditable(false);

        getAfterAdjustment().setEditable(false);

        getAdjustment().setEditable(false);

  }

  /**
   * 「サービス予定」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SERVICE_PLAN() throws Exception {

        getUppers().setVisible(true);

  }

  /**
   * 「サービス実績」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SERVICE_RESULT() throws Exception {

        getUppers().setVisible(false);

  }

}
