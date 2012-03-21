
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
 * 作成日: 2005/12/14  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 帳票管理 (C)
 * プロセス 計画書情報入力 (001)
 * プログラム 計画書情報入力 (QC001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qc.qc001;
/**
 * 計画書情報入力状態定義(QC001) 
 */
public class QC001State extends QC001Design {
  /**
   * コンストラクタです。
   */
  public QC001State(){
  }

  /**
   * 「初期状態」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_INIT_STATE() throws Exception {

        getPatientName().setEditable(false);

        getPatientBirth().setEditable(false);

        getPatientAge().setEditable(false);

        getPatientAddress().setEditable(false);

  }

  /**
   * 「問題点・解決策選択状態」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_NOTE_SELECTED() throws Exception {

        getPlanNoteEditButtonEdit().setEnabled(true);

        getPlanNoteEditButtonDelete().setEnabled(true);

  }

  /**
   * 「問題点・解決策未選択状態」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_NOTE_UNSELECTED() throws Exception {

        getPlanNoteEditButtonEdit().setEnabled(false);

        getPlanNoteEditButtonDelete().setEnabled(false);

  }

  /**
   * 「登録モード」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_PROCESS_MODE_INSERT() throws Exception {

        getInsert().setVisible(true);

        getUpdate().setVisible(false);

  }

  /**
   * 「更新モード」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_PROCESS_MODE_UPDATE() throws Exception {

        getInsert().setVisible(false);

        getUpdate().setVisible(true);

  }

}
