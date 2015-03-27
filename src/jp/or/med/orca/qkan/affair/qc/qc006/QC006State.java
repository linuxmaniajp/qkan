
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
 * 開発者: 日高　しのぶ
 * 作成日: 2014/12/02  MIS九州株式会社 日高　しのぶ 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 帳票管理 (C)
 * プロセス 居宅療養管理指導書 (006)
 * プログラム 居宅療養管理指導書一覧 (QC006)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qc.qc006;
/**
 * 居宅療養管理指導書一覧状態定義(QC006) 
 */
public class QC006State extends QC006Design {
  /**
   * コンストラクタです。
   */
  public QC006State(){
  }

  /**
   * 「新規・更新（セル選択状態）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SELECTED() throws Exception {

        getDetail().setEnabled(true);

        getInsert().setEnabled(true);

        getDelete().setEnabled(true);

  }

  /**
   * 「新規・更新（セル未選択状態）、新規のみ」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_NEWSELECTED() throws Exception {

        getDetail().setEnabled(false);

        getInsert().setEnabled(true);

        getDelete().setEnabled(false);

  }

  /**
   * 「更新のみ（セル選択）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_NEWUNSELECTED() throws Exception {

        getDetail().setEnabled(true);

        getInsert().setEnabled(false);

        getDelete().setEnabled(true);

  }

  /**
   * 「更新のみ（セル未選択）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_UNSELECTED() throws Exception {

        getDetail().setEnabled(false);

        getInsert().setEnabled(false);

        getDelete().setEnabled(false);

  }

}
