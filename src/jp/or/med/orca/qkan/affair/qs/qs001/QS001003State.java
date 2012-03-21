
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
 * 作成日: 2006/06/12  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定・実績 (001)
 * プログラム 利用・提供票印刷 (QS001031)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * 利用・提供票印刷状態定義(QS001031) 
 */
@SuppressWarnings("serial")
public class QS001003State extends QS001003Design {
  /**
   * コンストラクタです。
   */
  public QS001003State(){
  }

  /**
   * 「作成者・事業所」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_PROVIDER_MADE() throws Exception {

        getSupportProviderCd().setEnabled(true);

        getSupportProviderName().setEnabled(true);

        getPersonInCharge().setEnabled(true);

        getDateOfWrittenReport().setEnabled(false);

  }

  /**
   * 「作成者・被保険者」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SELF_MADE() throws Exception {

        getSupportProviderCd().setEnabled(false);

        getSupportProviderName().setEnabled(false);

        getPersonInCharge().setEnabled(false);

        getDateOfWrittenReport().setEnabled(true);

  }

  /**
   * 「予定印刷」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_PROCESS_TYPE_PLAN() throws Exception {

        getDateOfMakingOutsideFrame().getParent().setVisible(true);

        getPublicExpense().setVisible(true);

        getSlitKinds().setVisible(true);

  }

  /**
   * 「実績印刷」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_PROCESS_TYPE_RESULT() throws Exception {

        getDateOfMakingOutsideFrame().getParent().setVisible(false);

        getPublicExpense().setVisible(false);

        getSlitKinds().setVisible(false);

  }

}
