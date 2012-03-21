
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
 * 作成日: 2006/02/21  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業所管理 (004)
 * プログラム 事業所登録 (QO004)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;
/**
 * 事業所登録状態定義(QO004) 
 */
public class QO004State extends QO004Design {
  /**
   * コンストラクタです。
   */
  public QO004State(){
  }

  /**
   * 「初期状態」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INIT_STATE() throws Exception {

        getProviderStaffInsert().setEnabled(true);

        getProviderStaffFind().setEnabled(false);

        getProviderStaffDelete().setEnabled(false);

        getReflection().setEnabled(true);

        getOfferCheck().setEnabled(true);

        getProviderDetailServiceDetails().setEnabled(false);

        getInsert().setVisible(true);

        getUpdate().setVisible(false);

        getClear().setVisible(true);

        getNewData().setVisible(false);

        getProviderId().setEditable(true);

  }

  /**
   * 「追加操作可能」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STAFF_BUTTON_STATE1() throws Exception {

        getProviderStaffInsert().setEnabled(true);

        getProviderStaffFind().setEnabled(false);

        getProviderStaffDelete().setEnabled(false);

  }

  /**
   * 「追加・編集・削除可能」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STAFF_BUTTON_STATE2() throws Exception {

        getProviderStaffInsert().setEnabled(true);

        getProviderStaffFind().setEnabled(true);

        getProviderStaffDelete().setEnabled(true);

  }

  /**
   * 「提供サービス詳細情報ボタン初期状態」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SERVICE_DETAIL_BUTTON_ENABLE_TRUE() throws Exception {

        getReflection().setEnabled(true);

        getOfferCheck().setEnabled(true);

  }

  /**
   * 「提供サービス詳細情報ボタン押下不可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SERVICE_DETAIL_BUTTON_ENABLE_FALSE() throws Exception {

        getReflection().setEnabled(false);

        getOfferCheck().setEnabled(false);

  }

  /**
   * 「サービスパネル操作可能」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SERVICE_PANEL_ENABLE_TRUE() throws Exception {

        getProviderDetailServiceDetails().setEnabled(true);

  }

  /**
   * 「サービスパネル操作不可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SERVICE_PANEL_ENABLE_FALSE() throws Exception {

        getProviderDetailServiceDetails().setEnabled(false);

  }

  /**
   * 「登録モード」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INSERT_STATE() throws Exception {

        getReflection().setVisible(true);

        getInsert().setVisible(true);

        getUpdate().setVisible(false);

        getClear().setVisible(true);

        getNewData().setVisible(false);

        getProviderId().setEditable(true);

  }

  /**
   * 「更新モード」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_UPDATE_STATE() throws Exception {

        getReflection().setVisible(true);

        getInsert().setVisible(false);

        getUpdate().setVisible(true);

        getClear().setVisible(false);

        getNewData().setVisible(true);

        getProviderId().setEditable(false);

  }

}
