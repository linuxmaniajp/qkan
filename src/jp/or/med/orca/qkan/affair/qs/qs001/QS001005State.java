
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
 * 作成日: 2006/01/26  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン訪問看護(介護) (QS001005)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * サービスパターン訪問看護(介護)状態定義(QS001005) 
 */
public class QS001005State extends QS001005Design {
  /**
   * コンストラクタです。
   */
  public QS001005State(){
  }

  /**
   * 「理学療法士又は作業療法士・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_VALID_HOMON_KANGO_PTOT() throws Exception {

        getHoumonKangoKaigoClass3().setEnabled(true);

  }

  /**
   * 「理学療法士又は作業療法士・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_INVALID_HOMON_KANGO_PTOT() throws Exception {

        getHoumonKangoKaigoClass3().setEnabled(false);

  }

  /**
   * 「緊急時訪問看護加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_VALID_URGENT_TIME_RADIO() throws Exception {

        getHoumonKangoKaigoUrgentTimeRadio().setEnabled(true);

  }

  /**
   * 「緊急時訪問看護加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_INVALID_URGENT_TIME_RADIO() throws Exception {

        getHoumonKangoKaigoUrgentTimeRadio().setEnabled(false);

  }

  /**
   * 「特別管理体制・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_VALID_SPECIAL_MANAGE_RADIO() throws Exception {

        getHoumonKangoKaigoSpecialManageRadio().setEnabled(true);

  }

  /**
   * 「特別管理体制・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_INVALID_SPECIAL_MANAGE_RADIO() throws Exception {

        getHoumonKangoKaigoSpecialManageRadio().setEnabled(false);

  }

}
