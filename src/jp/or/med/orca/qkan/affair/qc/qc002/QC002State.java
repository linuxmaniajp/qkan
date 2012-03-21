
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
 * 作成日: 2006/01/16  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 帳票管理 (C)
 * プロセス 報告書情報入力 (002)
 * プログラム 報告書情報入力 (QC002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qc.qc002;
/**
 * 報告書情報入力状態定義(QC002) 
 */
public class QC002State extends QC002Design {
  /**
   * コンストラクタです。
   */
  public QC002State(){
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
   * 「カレンダー左・大の月」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_CALENDAR_LEFT_ODD_MONTH() throws Exception {

        getCalendarLeftDay29().setVisible(true);

        getCalendarLeftDay30().setVisible(true);

        getCalendarLeftDay31().setVisible(true);

        getCalendarLeftDay29Label().setVisible(false);

        getCalendarLeftDay30Label().setVisible(false);

        getCalendarLeftDay31Label().setVisible(false);

  }

  /**
   * 「カレンダー左・小の月」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_CALENDAR_LEFT_EVEN_MONTH() throws Exception {

        getCalendarLeftDay29().setVisible(true);

        getCalendarLeftDay30().setVisible(true);

        getCalendarLeftDay31().setVisible(false);

        getCalendarLeftDay29Label().setVisible(false);

        getCalendarLeftDay30Label().setVisible(false);

        getCalendarLeftDay31Label().setVisible(true);

  }

  /**
   * 「カレンダー左・2月」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_CALENDAR_LEFT_FEBRUARY() throws Exception {

        getCalendarLeftDay29().setVisible(false);

        getCalendarLeftDay30().setVisible(false);

        getCalendarLeftDay31().setVisible(false);

        getCalendarLeftDay29Label().setVisible(true);

        getCalendarLeftDay30Label().setVisible(true);

        getCalendarLeftDay31Label().setVisible(true);

  }

  /**
   * 「カレンダー左・2月閏年」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_CALENDAR_LEFT_BISSEXTILE() throws Exception {

        getCalendarLeftDay29().setVisible(true);

        getCalendarLeftDay30().setVisible(false);

        getCalendarLeftDay31().setVisible(false);

        getCalendarLeftDay29Label().setVisible(false);

        getCalendarLeftDay30Label().setVisible(true);

        getCalendarLeftDay31Label().setVisible(true);

  }

  /**
   * 「カレンダー右・大の月」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_CALENDAR_RIGHT_ODD_MONTH() throws Exception {

        getCalendarRightDay29().setVisible(true);

        getCalendarRightDay30().setVisible(true);

        getCalendarRightDay31().setVisible(true);

        getCalendarRightDay29Label().setVisible(false);

        getCalendarRightDay30Label().setVisible(false);

        getCalendarRightDay31Label().setVisible(false);

  }

  /**
   * 「カレンダー右・小の月」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_CALENDAR_RIGHT_EVEN_MONTH() throws Exception {

        getCalendarRightDay29().setVisible(true);

        getCalendarRightDay30().setVisible(true);

        getCalendarRightDay31().setVisible(false);

        getCalendarRightDay29Label().setVisible(false);

        getCalendarRightDay30Label().setVisible(false);

        getCalendarRightDay31Label().setVisible(true);

  }

  /**
   * 「カレンダー右・2月」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_CALENDAR_RIGHT_FEBRUARY() throws Exception {

        getCalendarRightDay29().setVisible(false);

        getCalendarRightDay30().setVisible(false);

        getCalendarRightDay31().setVisible(false);

        getCalendarRightDay29Label().setVisible(true);

        getCalendarRightDay30Label().setVisible(true);

        getCalendarRightDay31Label().setVisible(true);

  }

  /**
   * 「カレンダー右・2月閏年」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_CALENDAR_RIGHT_BISSEXTILE() throws Exception {

        getCalendarRightDay29().setVisible(true);

        getCalendarRightDay30().setVisible(false);

        getCalendarRightDay31().setVisible(false);

        getCalendarRightDay29Label().setVisible(false);

        getCalendarRightDay30Label().setVisible(true);

        getCalendarRightDay31Label().setVisible(true);

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
