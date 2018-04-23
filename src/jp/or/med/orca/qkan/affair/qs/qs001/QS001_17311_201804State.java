
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
 * 作成日: 2015/03/17  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護予防小規模多機能居宅介護 (QS001_17311_201804)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

/**
 * サービスパターン介護予防小規模多機能居宅介護状態定義(QS001_17311_201804) 
 */
@SuppressWarnings("serial")
public class QS001_17311_201804State extends QS001_17311_201804Design {
  /**
   * コンストラクタです。
   */
  public QS001_17311_201804State(){
  }

  /**
   * 「日割チェック有り」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DAY_CHECK_ON() throws Exception {

        getPrintable().setEnabled(true);

  }

  /**
   * 「日割チェック無し」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DAY_CHECK_OFF() throws Exception {

        getPrintable().setEnabled(false);

  }

  /**
   * 「看取り連携体制加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_TERMINAL_CARE_INFORMATION() throws Exception {

        getTerminalCareInformationRadioGroup().setEnabled(true);
        getTerminalCareInformationRadioGroup().getParent().setEnabled(true);

  }

  /**
   * 「看取り連携体制加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_TERMINAL_CARE_INFORMATION() throws Exception {

        getTerminalCareInformationRadioGroup().setEnabled(false);
        getTerminalCareInformationRadioGroup().getParent().setEnabled(false);

  }

  /**
   * 「看取り介護・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_TERMINAL() throws Exception {

        getTerminalCareInformationAddDays().setEnabled(true);
        getTerminalCareInformationAddDays().getParent().setEnabled(true);

  }

  /**
   * 「看取り介護・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_TERMINAL() throws Exception {

        getTerminalCareInformationAddDays().setEnabled(false);
        getTerminalCareInformationAddDays().getParent().setEnabled(false);

  }

}
