
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
 * 作成日: 2006/03/01  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他 (O)
 * プロセス 設定変更・メンテナンス (005)
 * プログラム 設定変更・メンテナンス (QO005)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo005;
/**
 * 設定変更・メンテナンス状態定義(QO005) 
 */
public class QO005State extends QO005Design {
  /**
   * コンストラクタです。
   */
  public QO005State(){
  }

  /**
   * 「サーバ種類・ローカル」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SERVER_TYPE_LOCAL() throws Exception {

        getServerSelectIpText().setEnabled(false);

        getDbFileSelectFileCompareButton().setEnabled(true);

        getBackup().setEnabled(true);
        getBackup().getParent().setEnabled(true);
        getRestore().setEnabled(true);

  }

  /**
   * 「サーバ種類・他のコンピュータ」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SERVER_TYPE_OTHER() throws Exception {

        getServerSelectIpText().setEnabled(true);

        getDbFileSelectFileCompareButton().setEnabled(false);

        getBackup().setEnabled(false);
        getBackup().getParent().setEnabled(false);
        getRestore().setEnabled(false);
  }

}
