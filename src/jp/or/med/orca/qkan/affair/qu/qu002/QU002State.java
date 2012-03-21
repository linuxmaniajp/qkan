
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
 * 開発者: 上司　和善
 * 作成日: 2011/12/19  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 利用者管理 (U)
 * プロセス 利用者登録 (002)
 * プログラム 利用者登録 (QU002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu002;
/**
 * 利用者登録状態定義(QU002) 
 */
@SuppressWarnings("serial")
public class QU002State extends QU002Design {
  /**
   * コンストラクタです。
   */
  public QU002State(){
  }

  /**
   * 「介護情報編集不可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_KAIGO_BUTTON_FALSE() throws Exception {

        getKaigoInfoButtonEdit().setEnabled(false);

        getKaigoInfoDelete().setEnabled(false);

  }

  /**
   * 「介護情報編集可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_KAIGO_BUTTON_TRUE() throws Exception {

        getKaigoInfoButtonEdit().setEnabled(true);

        getKaigoInfoDelete().setEnabled(true);

  }

  /**
   * 「異動情報編集不可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_IDOU_BUTTON_FALSE() throws Exception {

        getIdouInfoButtonEdit().setEnabled(false);

        getIdouInfoButtonDelete().setEnabled(false);

  }

  /**
   * 「異動情報編集可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_IDOU_BUTTON_TRUE() throws Exception {

        getIdouInfoButtonEdit().setEnabled(true);

        getIdouInfoButtonDelete().setEnabled(true);

  }

  /**
   * 「異動時刻有効可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_TIME_TRUE() throws Exception {

        getIdouInfoTime().setEnabled(true);
        getIdouInfoTime().getParent().setEnabled(true);

  }

  /**
   * 「異動時刻有効不可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_TIME_FALSE() throws Exception {

        getIdouInfoTime().setEnabled(false);
        getIdouInfoTime().getParent().setEnabled(false);

  }

  /**
   * 「支援事業所コンボ有効不可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_SHIEN_FALSE() throws Exception {

        getKaigoInfoKyotakuServicePlanCombo().setEnabled(false);

  }

  /**
   * 「支援事業所コンボ有効可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_SHIEN_TRUE() throws Exception {

        getKaigoInfoKyotakuServicePlanCombo().setEnabled(true);

  }

  /**
   * 「その他内容非表示」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VISIBLE_REASON_MEMO_FALSE() throws Exception {

        getIdouInfoReasonMemo().getParent().setVisible(false);

  }

  /**
   * 「その他内容表示」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VISIBLE_REASON_MEMO_TRUE() throws Exception {

        getIdouInfoReasonMemo().getParent().setVisible(true);

  }

  /**
   * 「業務ボタン設定（登録モード状態に変更）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INSERT_MODE() throws Exception {

        getInsert().setVisible(true);

        getUpdate().setVisible(false);

        getClearInsertMode().setVisible(true);

        getClearUpdateMode().setVisible(false);

  }

  /**
   * 「業務ボタン設定（更新モード状態に変更）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_UPDATE_MODE() throws Exception {

        getInsert().setVisible(false);

        getUpdate().setVisible(true);

        getClearInsertMode().setVisible(false);

        getClearUpdateMode().setVisible(true);

  }

  /**
   * 「異動領域初期化」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_IDOU_INIT() throws Exception {

        getIdouInfoChangeContent().setEnabled(false);
        getIdouInfoChangeContent().getParent().setEnabled(false);

        getIdouInfoTime().setEnabled(false);
        getIdouInfoTime().getParent().setEnabled(false);

        getIdouInfoReason().setEnabled(false);
        getIdouInfoReason().getParent().setEnabled(false);

        getIdouInfoReasonMemo().getParent().setVisible(false);

  }

  /**
   * 「異動理由有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_REASON_TRUE() throws Exception {

        getIdouInfoReason().setEnabled(true);
        getIdouInfoReason().getParent().setEnabled(true);

  }

  /**
   * 「異動理由無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_REASON_FALSE() throws Exception {

        getIdouInfoReason().setEnabled(false);
        getIdouInfoReason().getParent().setEnabled(false);

  }

  /**
   * 「異動事由有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_CONTENT_TRUE() throws Exception {

        getIdouInfoChangeContent().setEnabled(true);
        getIdouInfoChangeContent().getParent().setEnabled(true);

  }

  /**
   * 「異動事由無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_CONTENT_FALSE() throws Exception {

        getIdouInfoChangeContent().setEnabled(false);
        getIdouInfoChangeContent().getParent().setEnabled(false);

  }

  /**
   * 「負担限度額無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_TOKUTEI_NYUSHO_FALSE() throws Exception {

        getInstitutionInfoDinnerBearLimitMoneyText().setEnabled(false);

        getInstitutionInfoUnitRoomLimitMoneyText().setEnabled(false);

        getInstitutionInfoUnitSemiRoomLimitMoneyText().setEnabled(false);

        getInstitutionInfoNormalRoomLimitMoneyText().setEnabled(false);

        getInstitutionInfoNormalRoomLimitMoneyText2().setEnabled(false);

        getInstitutionInfoTasyoRoomLimitMoneyText().setEnabled(false);

        getInstitutionInfoDinnerBearLimitMoneyContena().setEnabled(false);

        getInstitutionInfoDinnerBearLimitMoneyLabel().setEnabled(false);

        getInstitutionInfoUnitRoomLimitMoneyContena().setEnabled(false);

        getInstitutionInfoUnitRoomLimitMoneyLabel().setEnabled(false);

        getInstitutionInfoUnitSemiRoomLimitMoneyContena().setEnabled(false);

        getInstitutionInfoUnitSemiRoomLimitMoneyLabel().setEnabled(false);

        getInstitutionInfoNormalRoomLimitMoneyContena().setEnabled(false);

        getInstitutionInfoNormalRoomLimitMoneyLabel().setEnabled(false);

        getInstitutionInfoNormalRoomLimitMoneyContena2().setEnabled(false);

        getInstitutionInfoNormalRoomLimitMoneyLabel2().setEnabled(false);

        getInstitutionInfoTasyoRoomLimitMoneyContena().setEnabled(false);

        getInstitutionInfoTasyoRoomLimitMoneyLabel().setEnabled(false);

  }

  /**
   * 「負担限度額有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_TOKUTEI_NYUSHO_TRUE() throws Exception {

        getInstitutionInfoDinnerBearLimitMoneyText().setEnabled(true);

        getInstitutionInfoUnitRoomLimitMoneyText().setEnabled(true);

        getInstitutionInfoUnitSemiRoomLimitMoneyText().setEnabled(true);

        getInstitutionInfoNormalRoomLimitMoneyText().setEnabled(true);

        getInstitutionInfoNormalRoomLimitMoneyText2().setEnabled(true);

        getInstitutionInfoTasyoRoomLimitMoneyText().setEnabled(true);

        getInstitutionInfoDinnerBearLimitMoneyContena().setEnabled(true);

        getInstitutionInfoDinnerBearLimitMoneyLabel().setEnabled(true);

        getInstitutionInfoUnitRoomLimitMoneyContena().setEnabled(true);

        getInstitutionInfoUnitRoomLimitMoneyLabel().setEnabled(true);

        getInstitutionInfoUnitSemiRoomLimitMoneyContena().setEnabled(true);

        getInstitutionInfoUnitSemiRoomLimitMoneyLabel().setEnabled(true);

        getInstitutionInfoNormalRoomLimitMoneyContena().setEnabled(true);

        getInstitutionInfoNormalRoomLimitMoneyLabel().setEnabled(true);

        getInstitutionInfoNormalRoomLimitMoneyContena2().setEnabled(true);

        getInstitutionInfoNormalRoomLimitMoneyLabel2().setEnabled(true);

        getInstitutionInfoTasyoRoomLimitMoneyContena().setEnabled(true);

        getInstitutionInfoTasyoRoomLimitMoneyLabel().setEnabled(true);

  }

}
