
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
 * 作成日: 2006/01/13  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービスパターン通所介護 (001)
 * プログラム サービスパターン通所介護 (QS001008)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * サービスパターン通所介護状態定義(QS001008) 
 */
public class QS001008State extends QS001008Design {
  /**
   * コンストラクタです。
   */
  public QS001008State(){
  }

  /**
   * 「機能訓練・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_VALID_FUNCTION_TRAINING() throws Exception {

        getTsuusyoKaigoAdditionFunctionTrainingRadio().setEnabled(true);

  }

  /**
   * 「機能訓練・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_INVALID_FUNCTION_TRAINING() throws Exception {

        getTsuusyoKaigoAdditionFunctionTrainingRadio().setEnabled(false);

  }

  /**
   * 「送迎加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_VALID_MEETING_AND_SENDING_OFF() throws Exception {

        getTsuusyoKaigoMeetingAndSendingOff().setEnabled(true);

  }

  /**
   * 「送迎加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_INVALID_MEETING_AND_SENDING_OFF() throws Exception {

        getTsuusyoKaigoMeetingAndSendingOff().setEnabled(false);

  }

  /**
   * 「入浴加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_VALID_ADD_BATH() throws Exception {

        getTsuusyoKaigoAdditionFunctionBathRadioItem2().setEnabled(true);

  }

  /**
   * 「入浴加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_INVALID_ADD_BATH() throws Exception {

        getTsuusyoKaigoAdditionFunctionBathRadioItem2().setEnabled(false);

  }

  /**
   * 「特別入浴加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_VALID_ADD_SPECIAL_BATH() throws Exception {

        getTsuusyoKaigoAdditionFunctionBathRadioItem3().setEnabled(true);

  }

  /**
   * 「特別入浴加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_INVALID_ADD_SPECIAL_BATH() throws Exception {

        getTsuusyoKaigoAdditionFunctionBathRadioItem3().setEnabled(false);

  }

}
