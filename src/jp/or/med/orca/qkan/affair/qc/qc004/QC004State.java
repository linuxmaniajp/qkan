
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
 * 作成日: 2006/01/13  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム  (C)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qc.qc004;
/**
 * 状態定義(QC004) 
 */
public class QC004State extends QC004Design {
  /**
   * コンストラクタです。
   */
  public QC004State(){
  }

  /**
   * 「登録モード」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_INSERT_STATE() throws Exception {

        getInsert().setVisible(true);

        getUpdate().setVisible(false);

  }

  /**
   * 「更新モード」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_UPDATE_STATE() throws Exception {

        getInsert().setVisible(false);

        getUpdate().setVisible(true);

  }

}
