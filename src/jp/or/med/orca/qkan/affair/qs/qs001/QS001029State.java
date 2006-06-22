
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
 * 作成日: 2006/02/07  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム 自費・調整画面 (QS001029)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * 自費・調整画面状態定義(QS001029) 
 */
public class QS001029State extends QS001029Design {
  /**
   * コンストラクタです。
   */
  public QS001029State(){
  }

  /**
   * 「初期状態」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INIT_STATE() throws Exception {

        getServiceDate().setEditable(false);

        getServiceStartTime().setEditable(false);

        getServiceEndTime().setEditable(false);

        getServiceUnit().setEditable(false);

        getServiceAdjustUnit().setEditable(false);

        getServiceResultUnit().setEditable(false);

  }

  /**
   * 「自費」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_EXPENCE() throws Exception {

        getServiceAdjustUnit().setEditable(false);

  }

  /**
   * 「調整」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ADJUST() throws Exception {

        getServiceAdjustUnit().setEditable(true);

  }

}
