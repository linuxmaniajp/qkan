
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
 * 作成日: 2011/12/13  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン福祉用具 (QS001_11711_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * サービスパターン福祉用具状態定義(QS001_11711_201204) 
 */
public class QS001_11711_201204State extends QS001_11711_201204Design {
  /**
   * コンストラクタです。
   */
  public QS001_11711_201204State(){
  }

  /**
   * 「中山間地域等の小規模事業所・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_MOUNTAINOUS_AREA() throws Exception {

        getProviderAddMountainousAreaScalePoint().setEnabled(true);

  }

  /**
   * 「中山間地域等の小規模事業所・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_MOUNTAINOUS_AREA() throws Exception {

        getProviderAddMountainousAreaScalePoint().setEnabled(false);

  }

}
