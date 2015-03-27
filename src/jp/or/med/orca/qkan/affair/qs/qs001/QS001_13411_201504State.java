
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
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護予防居宅療養管理指導 (QS001_13411_201504)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
/**
 * サービスパターン介護予防居宅療養管理指導状態定義(QS001_13411_201504) 
 */
public class QS001_13411_201504State extends QS001_13411_201504Design {
  /**
   * コンストラクタです。
   */
  public QS001_13411_201504State(){
  }

  /**
   * 「画面状態-医師選択」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_1() throws Exception {

        getMedicineManagementRadioGroup().setEnabled(true);
        getMedicineManagementRadioGroup().getParent().setEnabled(true);

        getKyotakuClass().setEnabled(false);
        getKyotakuClass().getParent().setEnabled(false);

        getSpecialMedicineRadioGroup().setEnabled(false);
        getSpecialMedicineRadioGroup().getParent().setEnabled(false);

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(false);

  }

  /**
   * 「画面状態-歯科医師選択」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_2() throws Exception {

        getMedicineManagementRadioGroup().setEnabled(false);
        getMedicineManagementRadioGroup().getParent().setEnabled(false);

        getKyotakuClass().setEnabled(false);
        getKyotakuClass().getParent().setEnabled(false);

        getSpecialMedicineRadioGroup().setEnabled(false);
        getSpecialMedicineRadioGroup().getParent().setEnabled(false);

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(false);

  }

  /**
   * 「画面状態-薬剤師（医療機関）選択」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_3() throws Exception {

        getMedicineManagementRadioGroup().setEnabled(false);
        getMedicineManagementRadioGroup().getParent().setEnabled(false);

        getKyotakuClass().setEnabled(false);
        getKyotakuClass().getParent().setEnabled(false);

        getSpecialMedicineRadioGroup().setEnabled(true);
        getSpecialMedicineRadioGroup().getParent().setEnabled(true);

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(false);

  }

  /**
   * 「画面状態-薬剤師（薬局）選択」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_4() throws Exception {

        getMedicineManagementRadioGroup().setEnabled(false);
        getMedicineManagementRadioGroup().getParent().setEnabled(false);

        getKyotakuClass().setEnabled(false);
        getKyotakuClass().getParent().setEnabled(false);

        getSpecialMedicineRadioGroup().setEnabled(true);
        getSpecialMedicineRadioGroup().getParent().setEnabled(true);

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(true);

  }

  /**
   * 「画面状態-管理栄養士選択」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_5() throws Exception {

        getMedicineManagementRadioGroup().setEnabled(false);
        getMedicineManagementRadioGroup().getParent().setEnabled(false);

        getKyotakuClass().setEnabled(false);
        getKyotakuClass().getParent().setEnabled(false);

        getSpecialMedicineRadioGroup().setEnabled(false);
        getSpecialMedicineRadioGroup().getParent().setEnabled(false);

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(false);

  }

  /**
   * 「画面状態-歯科衛生士等選択」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_6() throws Exception {

        getMedicineManagementRadioGroup().setEnabled(false);
        getMedicineManagementRadioGroup().getParent().setEnabled(false);

        getKyotakuClass().setEnabled(false);
        getKyotakuClass().getParent().setEnabled(false);

        getSpecialMedicineRadioGroup().setEnabled(false);
        getSpecialMedicineRadioGroup().getParent().setEnabled(false);

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(false);

  }

  /**
   * 「画面状態-看護職員選択」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_7() throws Exception {

        getMedicineManagementRadioGroup().setEnabled(false);
        getMedicineManagementRadioGroup().getParent().setEnabled(false);

        getKyotakuClass().setEnabled(true);
        getKyotakuClass().getParent().setEnabled(true);

        getSpecialMedicineRadioGroup().setEnabled(false);
        getSpecialMedicineRadioGroup().getParent().setEnabled(false);

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(false);

  }

}
