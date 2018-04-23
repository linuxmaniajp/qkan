
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
 * 作成日: 2009/03/30  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業所登録 (004)
 * プログラム 夜間対応型訪問介護 (QO004123)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;
/**
 * 夜間対応型訪問介護状態定義(QO004123) 
 */
public class QO004_17111_201804State extends QO004_17111_201804Design {
  /**
   * コンストラクタです。
   */
  public QO004_17111_201804State(){
  }

  /**
   * 「パネル全体有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SET_PANEL_TRUE() throws Exception {

        getMainGroup().setEnabled(true);

  }

  /**
   * 「パネル全体無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SET_PANEL_FALSE() throws Exception {

        getMainGroup().setEnabled(false);

  }

  /**
   * 「基本夜間訪問I市町村独自加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_BASE_MUNICIPALITY_ADD() throws Exception {

        getBaseMunicipalityAdd().setEnabled(true);
        getBaseMunicipalityAdd().getParent().setEnabled(true);

  }

  /**
   * 「基本夜間訪問I市町村独自加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_BASE_MUNICIPALITY_ADD() throws Exception {

        getBaseMunicipalityAdd().setEnabled(false);
        getBaseMunicipalityAdd().getParent().setEnabled(false);

  }

  /**
   * 「夜間訪問II市町村独自加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_SERVICE_MUNICIPALITY_ADD() throws Exception {

        getServiceMunicipalityAdd().setEnabled(true);
        getServiceMunicipalityAdd().getParent().setEnabled(true);

  }

  /**
   * 「夜間訪問II市町村独自加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_SERVICE_MUNICIPALITY_ADD() throws Exception {

        getServiceMunicipalityAdd().setEnabled(false);
        getServiceMunicipalityAdd().getParent().setEnabled(false);

  }

}
