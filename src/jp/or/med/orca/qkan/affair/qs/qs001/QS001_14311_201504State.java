
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
 * 作成日: 2012/02/16  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン居宅介護支援 (QS001_14311_201504)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * サービスパターン居宅介護支援状態定義(QS001_14311_201504) 
 */
public class QS001_14311_201504State extends QS001_14311_201504Design {
  /**
   * コンストラクタです。
   */
  public QS001_14311_201504State(){
  }

  /**
   * 「事業所情報・減算無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_PROVIDER_CUT_OFF() throws Exception {

        getKaigoSupportSpecificProviderSubtractionRadio().setEnabled(false);
        getKaigoSupportSpecificProviderSubtractionRadio().getParent().setEnabled(false);

  }

  /**
   * 「事業所情報・減算有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_PROVIDER_CUT_ON() throws Exception {

        getKaigoSupportSpecificProviderSubtractionRadio().setEnabled(true);
        getKaigoSupportSpecificProviderSubtractionRadio().getParent().setEnabled(true);

  }

  /**
   * 「初回加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_SYOKAI_ADD() throws Exception {

        getKaigoSupportStandardRadio().setEnabled(false);
        getKaigoSupportStandardRadio().getParent().setEnabled(false);

  }

  /**
   * 「初回加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_SYOKAI_ADD() throws Exception {

        getKaigoSupportStandardRadio().setEnabled(true);
        getKaigoSupportStandardRadio().getParent().setEnabled(true);

  }

  /**
   * 「退院・退所加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_TAIIN_ADD() throws Exception {

        getDischargeAddRadio().setEnabled(false);
        getDischargeAddRadio().getParent().setEnabled(false);

  }

  /**
   * 「退院・退所加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_TAIIN_ADD() throws Exception {

        getDischargeAddRadio().setEnabled(true);
        getDischargeAddRadio().getParent().setEnabled(true);

  }

}
