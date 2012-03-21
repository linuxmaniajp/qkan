
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
 * プロセス サービスパターン通所リハ (001)
 * プログラム サービスパターン通所リハ (QS001_11611_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * サービスパターン通所リハ状態定義(QS001_11611_201204) 
 */
public class QS001_11611_201204State extends QS001_11611_201204Design {
  /**
   * コンストラクタです。
   */
  public QS001_11611_201204State(){
  }

  /**
   * 「理学療法士等体制強化加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_PHYSIOTHERAPIST_STRENGTHENED() throws Exception {

        getPhysiotherapistStrengthenedAddRadioGroup().setEnabled(true);
        getPhysiotherapistStrengthenedAddRadioGroup().getParent().setEnabled(true);

  }

  /**
   * 「理学療法士等体制強化加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_PHYSIOTHERAPIST_STRENGTHENED() throws Exception {

        getPhysiotherapistStrengthenedAddRadioGroup().setEnabled(false);
        getPhysiotherapistStrengthenedAddRadioGroup().getParent().setEnabled(false);

  }

  /**
   * 「重度療養管理加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_ADD_MEDICAL_MANAGEMENT() throws Exception {

        getMedicalManagementRadioGroup().setEnabled(true);
        getMedicalManagementRadioGroup().getParent().setEnabled(true);

  }

  /**
   * 「重度療養管理加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_ADD_MEDICAL_MANAGEMENT() throws Exception {

        getMedicalManagementRadioGroup().setEnabled(false);
        getMedicalManagementRadioGroup().getParent().setEnabled(false);

  }

}
