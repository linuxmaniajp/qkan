
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
 * 作成日: 2006/01/22  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 保険者管理 (001)
 * プログラム 保険者一覧 (QO001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo001;
/**
 * 保険者一覧状態定義(QO001) 
 */
public class QO001State extends QO001Design {
  /**
   * コンストラクタです。
   */
  public QO001State(){
  }

  /**
   * 「セル選択状態」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_SELECTED() throws Exception {

        getFind().setEnabled(true);

        getDetail().setEnabled(true);

        getInsert().setEnabled(true);

        getDelete().setEnabled(true);

  }

  /**
   * 「セル未選択状態」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_UNSELECTED() throws Exception {

        getFind().setEnabled(true);

        getDetail().setEnabled(false);

        getInsert().setEnabled(true);

        getDelete().setEnabled(false);

  }

}
