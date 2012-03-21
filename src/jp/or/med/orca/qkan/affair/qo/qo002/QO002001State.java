
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
 * 作成日: 2009/07/09  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 保険者管理 (002)
 * プログラム 保険者選択 (QO002001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo002;
/**
 * 保険者選択状態定義(QO002001) 
 */
public class QO002001State extends QO002001Design {
  /**
   * コンストラクタです。
   */
  public QO002001State(){
  }

  /**
   * 「設定ボタン・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_APPLY() throws Exception {

        getApply().setEnabled(true);

  }

  /**
   * 「設定ボタン・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_APPLY() throws Exception {

        getApply().setEnabled(false);

  }

}
