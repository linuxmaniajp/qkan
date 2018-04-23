
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
 * 作成日: 2011/12/09  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービスパターン地域密着型特定施設入居者生活介護 (001)
 * プログラム サービスパターン地域密着型特定施設入居者生活介護 (QS001_13611_201804)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * サービスパターン地域密着型特定施設入居者生活介護状態定義(QS001_13611_201804) 
 */
public class QS001_13611_201804State extends QS001_13611_201804Design {
  /**
   * コンストラクタです。
   */
  public QS001_13611_201804State(){
  }

  /**
   * 「個別機能訓練・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_FUNCTION_TRAINING() throws Exception {

        getRegionTrainingRadio().setEnabled(true);

  }

  /**
   * 「個別機能訓練・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_FUNCTION_TRAINING() throws Exception {

        getRegionTrainingRadio().setEnabled(false);

  }

  /**
   * 「看取り介護加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_WATCH_CARE() throws Exception {

        getWatchCareRadioGroup().setEnabled(true);

  }

  /**
   * 「看取り介護加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_WATCH_CARE() throws Exception {

        getWatchCareRadioGroup().setEnabled(false);

  }

}
