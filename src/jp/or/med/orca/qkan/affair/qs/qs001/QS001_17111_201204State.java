
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
 * 作成日: 2012/02/20  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン夜間対応型訪問介護 (QS001_17111_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * サービスパターン夜間対応型訪問介護状態定義(QS001_17111_201204) 
 */
public class QS001_17111_201204State extends QS001_17111_201204Design {
  /**
   * コンストラクタです。
   */
  public QS001_17111_201204State(){
  }

  /**
   * 「施設区分・I型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_STATE_1() throws Exception {

        getServiceDivisionRadio().setEnabled(true);
        getServiceDivisionRadio().getParent().setEnabled(true);

        getAnytimeCorrespondenceTypeRadio().setEnabled(true);
        getAnytimeCorrespondenceTypeRadio().getParent().setEnabled(true);

        getCalculationDivision().setEnabled(true);
        getCalculationDivision().getParent().setEnabled(true);

  }

  /**
   * 「施設区分・II型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_STATE_2() throws Exception {

        getServiceDivisionRadio().setEnabled(false);
        getServiceDivisionRadio().getParent().setEnabled(false);

        getAnytimeCorrespondenceTypeRadio().setEnabled(false);
        getAnytimeCorrespondenceTypeRadio().getParent().setEnabled(false);

        getCalculationDivision().setEnabled(false);
        getCalculationDivision().getParent().setEnabled(false);

  }

  /**
   * 「対応人数・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_PERSONS() throws Exception {

        getAnytimeCorrespondenceTypeRadio().setEnabled(true);
        getAnytimeCorrespondenceTypeRadio().getParent().setEnabled(true);

  }

  /**
   * 「対応人数・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_PERSONS() throws Exception {

        getAnytimeCorrespondenceTypeRadio().setEnabled(false);
        getAnytimeCorrespondenceTypeRadio().getParent().setEnabled(false);

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

}
