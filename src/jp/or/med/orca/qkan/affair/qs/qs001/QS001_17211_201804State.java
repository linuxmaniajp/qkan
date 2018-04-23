
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
 * 作成日: 2012/02/17  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン認知症対応型通所介護 (QS001_17211_201804)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * サービスパターン認知症対応型通所介護状態定義(QS001_17211_201804) 
 */
public class QS001_17211_201804State extends QS001_17211_201804Design {
  /**
   * コンストラクタです。
   */
  public QS001_17211_201804State(){
  }

  /**
   * 「施設区分2・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_FACILITY_STATE2() throws Exception {

        getDivisionRadion().setEnabled(true);
        getDivisionRadion().getParent().setEnabled(true);

  }

  /**
   * 「施設区分2・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_FACILITY_STATE2() throws Exception {

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

  }

}
