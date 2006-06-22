
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
 * 作成日: 2006/01/24  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン訪問介護 (QS001003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * サービスパターン訪問介護状態定義(QS001003) 
 */
public class QS001003State extends QS001003Design {
  /**
   * コンストラクタです。
   */
  public QS001003State(){
  }

  /**
   * 「身体介護」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_SHINTAI_KAIGO() throws Exception {

        getHomonkaigoTeikyoTime().setEnabled(true);

        getHoumonKaigoInTime().setEnabled(false);

        getHoumonKaigoNumberOfPeople().setEnabled(true);

  }

  /**
   * 「生活援助」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_SEIKATSU_ENJO() throws Exception {

        getHomonkaigoTeikyoTime().setEnabled(true);

        getHoumonKaigoInTime().setEnabled(false);

        getHoumonKaigoNumberOfPeople().setEnabled(true);

  }

  /**
   * 「身体生活」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_SHINTAI_SEIKATSU() throws Exception {

        getHomonkaigoTeikyoTime().setEnabled(true);

        getHoumonKaigoInTime().setEnabled(true);

        getHoumonKaigoNumberOfPeople().setEnabled(true);

  }

  /**
   * 「通院等乗降介助」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_JOKOKAIJO() throws Exception {

        getHomonkaigoTeikyoTime().setEnabled(false);

        getHoumonKaigoInTime().setEnabled(false);

        getHoumonKaigoNumberOfPeople().setEnabled(false);

  }

}
