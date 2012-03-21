
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
 * 開発者: 藤原　伸
 * 作成日: 2006/02/15  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 利用者向け印刷 (007)
 * プログラム 利用者向請求書印刷設定 (QP007)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp007;
/**
 * 利用者向請求書印刷設定状態定義(QP007) 
 */
public class QP007State extends QP007Design {
  /**
   * コンストラクタです。
   */
  public QP007State(){
  }

  /**
   * 「請求書ラジオボタンクリック」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_RADIO_1() throws Exception {

        getPatientBillSetupUnderPrintOn().setEnabled(true);

        getPatientBillSetupMedicalTreatmentOn().setEnabled(false);

  }

  /**
   * 「領収書ラジオボタンクリック」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_RADIO_2() throws Exception {

        getPatientBillSetupUnderPrintOn().setEnabled(false);

        getPatientBillSetupMedicalTreatmentOn().setEnabled(true);

  }

  /**
   * 「請求書・領収書ラジオボタンクリック」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_RADIO_3() throws Exception {

        getPatientBillSetupUnderPrintOn().setEnabled(true);

        getPatientBillSetupMedicalTreatmentOn().setEnabled(true);

  }

}
