
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
 * 開発者: 上司　和善
 * 作成日: 2011/11/16  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 利用者管理 (U)
 * プロセス 公費・社福軽減情報 (004)
 * プログラム 公費・社福軽減情報 (QU004)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu004;
/**
 * 公費・社福軽減情報状態定義(QU004) 
 */
@SuppressWarnings("serial")
public class QU004State extends QU004Design {
  /**
   * コンストラクタです。
   */
  public QU004State(){
  }

  /**
   * 「介護公費編集不可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_KAIGO_BUTTON_FALSE() throws Exception {

        getKaigoInfoButtonConpile().setEnabled(false);

        getKaigoInfoButtonDelete().setEnabled(false);

  }

  /**
   * 「介護公費編集可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_KAIGO_BUTTON_TRUE() throws Exception {

        getKaigoInfoButtonConpile().setEnabled(true);

        getKaigoInfoButtonDelete().setEnabled(true);

  }

  /**
   * 「業務ボタン設定（登録モードへ変更）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INSERT_MODE() throws Exception {

        getInsert().setVisible(true);

        getUpdate().setVisible(false);

  }

  /**
   * 「業務ボタン設定（更新モードへ変更）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_UPDATE_MODE() throws Exception {

        getInsert().setVisible(false);

        getUpdate().setVisible(true);

  }

  /**
   * 「社会福祉減免編集不可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_SHAHUKU_BUTTON_FALSE() throws Exception {

        getShahukuInfoButtonConpile().setEnabled(false);

        getShahukuInfoButtonDelete().setEnabled(false);

  }

  /**
   * 「社会福祉減免編集可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_SHAHUKU_BUTTON_TRUE() throws Exception {

        getShahukuInfoButtonConpile().setEnabled(true);

        getShahukuInfoButtonDelete().setEnabled(true);

  }

  /**
   * 「介護その他公費OFF」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_KAIGO_OTHER_OFF() throws Exception {

        getKaigoInfoKohiNo().setEditable(false);

        getKaigoInfoServices().setVisible(false);

  }

  /**
   * 「介護その他公費ON」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_KAIGO_OTHER_ON() throws Exception {

        getKaigoInfoKohiNo().setEditable(true);

        getKaigoInfoServices().setVisible(true);

  }

}
