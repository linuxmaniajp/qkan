
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
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護予防訪問看護 (QS001_16311_201504)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * サービスパターン介護予防訪問看護状態定義(QS001_16311_201504) 
 */
public class QS001_16311_201504State extends QS001_16311_201504Design {
  /**
   * コンストラクタです。
   */
  public QS001_16311_201504State(){
  }

  /**
   * 「画面状態1・訪問看護ステーション-正看・准看-時間区分-20分未満以外」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_1() throws Exception {

        getHoumonKangoKaigoClass3().setEnabled(true);

        getHoumonKangoKaigoTime().setEnabled(true);

        getTwoOrMoreTimesCheck().setEnabled(false);

  }

  /**
   * 「画面状態2・訪問看護ステーション-正看・准看-時間区分-20分未満」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_2() throws Exception {

        getHoumonKangoKaigoClass3().setEnabled(true);

        getHoumonKangoKaigoTime().setEnabled(true);

        getTwoOrMoreTimesCheck().setEnabled(false);

  }

  /**
   * 「画面状態3・訪問看護ステーション-理学」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_3() throws Exception {

        getHoumonKangoKaigoClass3().setEnabled(true);

        getHoumonKangoKaigoTime().setEnabled(false);

        getTwoOrMoreTimesCheck().setEnabled(true);

  }

  /**
   * 「画面状態4・医療機関-正看・准看-時間区分-20分未満以外」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_4() throws Exception {

        getHoumonKangoKaigoClass3().setEnabled(false);

        getHoumonKangoKaigoTime().setEnabled(true);

        getTwoOrMoreTimesCheck().setEnabled(false);

  }

  /**
   * 「画面状態5・医療機関-正看・准看-時間区分-20分未満」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_5() throws Exception {

        getHoumonKangoKaigoClass3().setEnabled(false);

        getHoumonKangoKaigoTime().setEnabled(true);

        getTwoOrMoreTimesCheck().setEnabled(false);

  }

  /**
   * 「画面状態6・医療機関-理学」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_6() throws Exception {

        getHoumonKangoKaigoClass3().setEnabled(false);

        getHoumonKangoKaigoTime().setEnabled(false);

        getTwoOrMoreTimesCheck().setEnabled(false);

  }

  /**
   * 「長時間訪問看護加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_LONG_TIME() throws Exception {

        getHoumonKangoKaigoLongTime().setEnabled(true);
        getHoumonKangoKaigoLongTime().getParent().setEnabled(true);

  }

  /**
   * 「長時間訪問看護加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_LONG_TIME() throws Exception {

        getHoumonKangoKaigoLongTime().setEnabled(false);
        getHoumonKangoKaigoLongTime().getParent().setEnabled(false);

  }

  /**
   * 「2人目の訪問時間・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_NUMBER_OF_PEOPLE_TIME() throws Exception {

        getHoumonKangoNumberOfPeopleTime().setEnabled(true);
        getHoumonKangoNumberOfPeopleTime().getParent().setEnabled(true);

  }

  /**
   * 「2人目の訪問時間・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_NUMBER_OF_PEOPLE_TIME() throws Exception {

        getHoumonKangoNumberOfPeopleTime().setEnabled(false);
        getHoumonKangoNumberOfPeopleTime().getParent().setEnabled(false);

  }

}
