
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
 * 開発者: 廣瀬 一海
 * 作成日: 2009/03/04  日本コンピューター株式会社 廣瀬 一海 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業所登録 (004)
 * プログラム 介護予防短期入所療養介護（認知症疾患型） (QO004141)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;
/**
 * 介護予防短期入所療養介護（認知症疾患型）状態定義(QO004141) 
 */
@SuppressWarnings("serial")
public class QO004_12613_201804State extends QO004_12613_201804Design {
  /**
   * コンストラクタです。
   */
  public QO004_12613_201804State(){
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
   * 「ユニットタイプ」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_UNIT() throws Exception {

        getUnitCareMaintenance().setEnabled(true);
        getUnitCareMaintenance().getParent().setEnabled(true);

        getStaffAssignmentDivision().setEnabled(true);
        getStaffAssignmentDivision().getParent().setEnabled(true);

        getStaffAssignmentDivisionItem1().setEnabled(true);
        getStaffAssignmentDivisionItem2().setEnabled(true);
        getStaffAssignmentDivisionItem3().setEnabled(false);
        getStaffAssignmentDivisionItem4().setEnabled(false);
        getStaffAssignmentDivisionItem5().setEnabled(false);

  }

  /**
   * 「ノーマルタイプ」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_NORMAL() throws Exception {

        getUnitCareMaintenance().setEnabled(false);
        getUnitCareMaintenance().getParent().setEnabled(false);

        getStaffAssignmentDivision().setEnabled(true);
        getStaffAssignmentDivision().getParent().setEnabled(true);

        getStaffAssignmentDivisionItem1().setEnabled(true);
        getStaffAssignmentDivisionItem2().setEnabled(true);
        getStaffAssignmentDivisionItem3().setEnabled(true);
        getStaffAssignmentDivisionItem4().setEnabled(true);
        getStaffAssignmentDivisionItem5().setEnabled(true);

  }

  /**
   * 「経過型タイプ」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_PASSAGE() throws Exception {

        getUnitCareMaintenance().setEnabled(false);
        getUnitCareMaintenance().getParent().setEnabled(false);

        getStaffAssignmentDivision().setEnabled(false);
        getStaffAssignmentDivision().getParent().setEnabled(false);

  }

}
