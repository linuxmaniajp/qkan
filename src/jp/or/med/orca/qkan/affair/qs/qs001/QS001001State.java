
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
 * 作成日: 2006/02/01  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム 週間表 (QS001001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * 週間表状態定義(QS001001) 
 */
public class QS001001State extends QS001001Design {
  /**
   * コンストラクタです。
   */
  public QS001001State(){
  }

  /**
   * 「サービスパターン・主な日常生活上の活動・選択」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_EXT_CONTENT_DETAIL_SELECTED() throws Exception {

        getMondayCheck().setVisible(false);

        getTuesdayCheck().setVisible(false);

        getWednesdayCheck().setVisible(false);

        getThursdayCheck().setVisible(false);

        getFridayCheck().setVisible(false);

        getSaturdayCheck().setVisible(false);

        getSundayCheck().setVisible(false);

        getExceptionServiceCombos().setEnabled(false);

        getExceptionBeginCombo().setEnabled(false);

        getExceptionEndCombo().setEnabled(false);

        getExceptionButton().setEnabled(false);

  }

  /**
   * 「サービスパターン・主な日常生活上の活動・未選択」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_EXT_CONTENT_DETAIL_UNSELECTED() throws Exception {

        getMondayCheck().setVisible(true);

        getTuesdayCheck().setVisible(true);

        getWednesdayCheck().setVisible(true);

        getThursdayCheck().setVisible(true);

        getFridayCheck().setVisible(true);

        getSaturdayCheck().setVisible(true);

        getSundayCheck().setVisible(true);

        getExceptionServiceCombos().setEnabled(true);

        getExceptionBeginCombo().setEnabled(true);

        getExceptionEndCombo().setEnabled(true);

        getExceptionButton().setEnabled(true);

  }

}
