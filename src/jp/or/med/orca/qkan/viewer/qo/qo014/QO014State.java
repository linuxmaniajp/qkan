
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
 * 作成日: 2012/09/19  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その多機能 (O)
 * プロセス ログビューア (014)
 * プログラム ログビューア (QO014)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.viewer.qo.qo014;
/**
 * ログビューア状態定義(QO014) 
 */
@SuppressWarnings("serial")
public class QO014State extends QO014Design {
  /**
   * コンストラクタです。
   */
  public QO014State(){
  }

  /**
   * 「双方向無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_MOVE_NONE() throws Exception {

        getPrevButton().setEnabled(false);

        getNextButton().setEnabled(false);

  }

  /**
   * 「次へのみ有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_MOVE_NEXT_ONLY() throws Exception {

        getPrevButton().setEnabled(false);

        getNextButton().setEnabled(true);

  }

  /**
   * 「戻るのみ有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_MOVE_PREV_ONLY() throws Exception {

        getPrevButton().setEnabled(true);

        getNextButton().setEnabled(false);

  }

  /**
   * 「双方向有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_MOVE_ALL() throws Exception {

        getPrevButton().setEnabled(true);

        getNextButton().setEnabled(true);

  }

}
