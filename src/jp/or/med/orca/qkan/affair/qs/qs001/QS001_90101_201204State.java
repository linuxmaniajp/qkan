
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
 * 作成日: 2011/11/16  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターンその他内容詳細 (QS001_90101_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * サービスパターンその他内容詳細状態定義(QS001_90101_201204) 
 */
@SuppressWarnings("serial")
public class QS001_90101_201204State extends QS001_90101_201204Design {
  /**
   * コンストラクタです。
   */
  public QS001_90101_201204State(){
  }

  /**
   * 「編集可能」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_EDIT() throws Exception {

        getDailyLifeActivitFindButton().setEnabled(true);

        getDailyLifeActivitDeleteButton().setEnabled(true);

  }

  /**
   * 「編集不能」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_EDIT() throws Exception {

        getDailyLifeActivitFindButton().setEnabled(false);

        getDailyLifeActivitDeleteButton().setEnabled(false);

  }

  /**
   * 「追加可能」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_ADD() throws Exception {

        getDailyLifeActivitInsertButton().setEnabled(true);

  }

  /**
   * 「追加不能」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_ADD() throws Exception {

        getDailyLifeActivitInsertButton().setEnabled(false);

  }

}
