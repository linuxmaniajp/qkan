
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
 * 作成日: 2015/01/06  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 実績データ作成 (P)
 * プロセス 確認・修正 (005)
 * プログラム 明細書詳細編集 (QP005)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp005;
/**
 * 明細書詳細編集状態定義(QP005) 
 */
public class QP005State extends QP005Design {
  /**
   * コンストラクタです。
   */
  public QP005State(){
  }

  /**
   * 「状態コントロール1」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_TYPE1() throws Exception {

        getParticularInfos().setEnabled(false);

        getNyushoInfos().setEnabled(false);

        getDetailsInfoTable().setVisible(true);

        getKyotakuDetailsInfoTable().setVisible(false);

        getParticularInfoTable().setVisible(true);

        getSpecialClinicInfoTable().setVisible(false);

  }

  /**
   * 「状態コントロール2」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_TYPE2() throws Exception {

        getParticularInfos().setEnabled(false);

        getDetailsInfoTable().setVisible(true);

        getKyotakuDetailsInfoTable().setVisible(false);

        getParticularInfoTable().setVisible(true);

        getSpecialClinicInfoTable().setVisible(false);

  }

  /**
   * 「状態コントロール3」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_TYPE3() throws Exception {

        getShahukuInfos().setEnabled(false);

        getDetailsInfoTable().setVisible(true);

        getKyotakuDetailsInfoTable().setVisible(false);

        getParticularInfoTable().setVisible(true);

        getSpecialClinicInfoTable().setVisible(false);

  }

  /**
   * 「状態コントロール4」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_TYPE4() throws Exception {

        getShahukuInfos().setVisible(false);

        getDetailsInfoTable().setVisible(true);

        getKyotakuDetailsInfoTable().setVisible(false);

        getParticularInfoTable().setVisible(false);

        getSpecialClinicInfoTable().setVisible(true);

  }

  /**
   * 「状態コントロール5」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_TYPE5() throws Exception {

        getParticularInfos().setEnabled(false);

        getNyushoInfos().setEnabled(false);

        getShahukuInfos().setEnabled(false);

        getDetailsInfoTable().setVisible(true);

        getKyotakuDetailsInfoTable().setVisible(false);

        getParticularInfoTable().setVisible(true);

        getSpecialClinicInfoTable().setVisible(false);

  }

  /**
   * 「状態コントロール6」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_TYPE6() throws Exception {

        getBasicInfos().setEnabled(false);

        getParticularInfos().setEnabled(false);

        getTotalInfos().setEnabled(false);

        getNyushoInfos().setEnabled(false);

        getShahukuInfos().setEnabled(false);

        getDetailsInfoTable().setVisible(false);

        getKyotakuDetailsInfoTable().setVisible(true);

        getParticularInfoTable().setVisible(true);

        getSpecialClinicInfoTable().setVisible(false);

  }

  /**
   * 「状態コントロール7」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_TYPE7() throws Exception {

        getServiceDelButton().setEnabled(true);

  }

  /**
   * 「状態コントロール8」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_TYPE8() throws Exception {

        getServiceDelButton().setEnabled(false);

  }

  /**
   * 「状態コントロール9」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_TYPE9() throws Exception {

        getServiceDelButton().setEnabled(false);

        getServiceAddButton().setEnabled(false);

  }

  /**
   * 「状態コントロール10」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_TYPE10() throws Exception {

        getDetailsDelButton().setEnabled(true);

  }

  /**
   * 「状態コントロール11」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_TYPE11() throws Exception {

        getDetailsDelButton().setEnabled(false);

  }

  /**
   * 「状態コントロール12」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_TYPE12() throws Exception {

        getDetailsJushotiTokureiDelButton().setEnabled(true);

  }

  /**
   * 「状態コントロール13」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_TYPE13() throws Exception {

        getDetailsJushotiTokureiDelButton().setEnabled(false);

  }

}
