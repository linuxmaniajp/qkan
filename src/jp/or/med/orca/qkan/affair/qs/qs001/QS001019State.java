
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
 * 作成日: 2006/01/18  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービスパターン特定施設入所者生活介護 (001)
 * プログラム サービスパターン特定施設入所者生活介護 (QS001020)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * サービスパターン特定施設入所者生活介護状態定義(QS001020) 
 */
public class QS001019State extends QS001019Design {
  /**
   * コンストラクタです。
   */
  public QS001019State(){
  }

  /**
   * 「機能訓練・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_VALID_FUNCTION_TRAINING() throws Exception {

        getSpecificFacilityFunctionTrainingRadio().setEnabled(true);

  }

  /**
   * 「機能訓練・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_INVALID_FUNCTION_TRAINING() throws Exception {

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);

  }

}
