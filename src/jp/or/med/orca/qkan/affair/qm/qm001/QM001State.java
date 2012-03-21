
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
 * 作成日: 2012/02/03  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム メニュー (M)
 * プロセス ログイン画面 (001)
 * プログラム ログイン画面 (QM001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qm.qm001;
/**
 * ログイン画面状態定義(QM001) 
 */
public class QM001State extends QM001Design {
  /**
   * コンストラクタです。
   */
  public QM001State(){
  }

  /**
   * 「バージョン取得エラー」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_VERSION() throws Exception {

        getVersionErros().setVisible(true);

        getStart().setEnabled(false);

        getDbErros().setVisible(false);

        getNoProviders().setVisible(false);

        getNoInsurers().setVisible(false);

        getNoPatients().setVisible(false);

        getNoPDFViewers().setVisible(false);

        getNoErrors().setVisible(false);

        getShareDBs().setVisible(false);

  }

  /**
   * 「バージョン取得成功」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_VERSION() throws Exception {

        getVersionErros().setVisible(false);

  }

  /**
   * 「自事業所未登録」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_PROVIDER() throws Exception {

        getStart().setEnabled(false);

        getNoProviders().setVisible(true);

        getNoInsurers().setVisible(false);

        getNoPatients().setVisible(false);

        getNoPDFViewers().setVisible(false);

        getNoErrors().setVisible(false);

        getShareDBs().setVisible(true);

  }

  /**
   * 「自事業所登録済み」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_PROVIDER() throws Exception {

        getNoProviders().setVisible(false);

        getShareDBs().setVisible(false);

  }

  /**
   * 「保険者未登録」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_INSURER() throws Exception {

        getNoInsurers().setVisible(true);

        getNoErrors().setVisible(false);

  }

  /**
   * 「保険者登録済み」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_INSURER() throws Exception {

        getNoInsurers().setVisible(false);

  }

  /**
   * 「利用者未登録」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_PATIENT() throws Exception {

        getNoPatients().setVisible(true);

        getNoErrors().setVisible(false);

  }

  /**
   * 「利用者登録済み」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_PATIENT() throws Exception {

        getNoPatients().setVisible(false);

  }

  /**
   * 「PDFビューワなし」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_PDF_VIEWER() throws Exception {

        getNoPDFViewers().setVisible(true);

        getNoErrors().setVisible(false);

  }

  /**
   * 「PDFビューワあり」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_PDF_VIEWER() throws Exception {

        getNoPDFViewers().setVisible(false);

  }

  /**
   * 「DB成功」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_DB() throws Exception {

        getDbErros().setVisible(false);

  }

  /**
   * 「DB接続エラー」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_DB_CONNECTION() throws Exception {

        getVersionErros().setVisible(false);

        getStart().setEnabled(false);

        getDbErros().setVisible(true);

        getNoProviders().setVisible(false);

        getNoInsurers().setVisible(false);

        getNoPatients().setVisible(false);

        getNoPDFViewers().setVisible(false);

        getNoErrors().setVisible(false);

        getDbConnectionError().setVisible(true);

        getDbmsError().setVisible(false);

        getDbVersionError().setVisible(false);

        getShareDBs().setVisible(false);

        getDbSchemaError().setVisible(false);

  }

  /**
   * 「非対応のDBマネージャ」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_DBMS() throws Exception {

        getVersionErros().setVisible(false);

        getStart().setEnabled(false);

        getDbErros().setVisible(true);

        getNoProviders().setVisible(false);

        getNoInsurers().setVisible(false);

        getNoPatients().setVisible(false);

        getNoPDFViewers().setVisible(false);

        getNoErrors().setVisible(false);

        getDbConnectionError().setVisible(false);

        getDbmsError().setVisible(true);

        getDbVersionError().setVisible(false);

        getShareDBs().setVisible(false);

        getDbSchemaError().setVisible(false);

  }

  /**
   * 「DBバージョンの取得失敗」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_MASTER_VERSION() throws Exception {

        getVersionErros().setVisible(false);

        getStart().setEnabled(false);

        getDbErros().setVisible(true);

        getNoProviders().setVisible(false);

        getNoInsurers().setVisible(false);

        getNoPatients().setVisible(false);

        getNoPDFViewers().setVisible(false);

        getNoErrors().setVisible(false);

        getDbConnectionError().setVisible(false);

        getDbmsError().setVisible(false);

        getDbVersionError().setVisible(true);

        getShareDBs().setVisible(false);

        getDbSchemaError().setVisible(false);

  }

  /**
   * 「SCHEMAバージョンエラー」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_SCHEMA_VERSION() throws Exception {

        getVersionErros().setVisible(false);

        getStart().setEnabled(false);

        getDbErros().setVisible(true);

        getNoProviders().setVisible(false);

        getNoInsurers().setVisible(false);

        getNoPatients().setVisible(false);

        getNoPDFViewers().setVisible(false);

        getNoErrors().setVisible(false);

        getDbConnectionError().setVisible(false);

        getDbmsError().setVisible(false);

        getDbVersionError().setVisible(false);

        getShareDBs().setVisible(false);

        getDbSchemaError().setVisible(true);

  }

}
