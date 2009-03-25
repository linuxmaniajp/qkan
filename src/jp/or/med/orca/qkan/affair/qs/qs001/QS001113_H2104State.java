
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
 * 作成日: 2009/02/27  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービスパターン短期入所療養介護（認知症疾患） (001)
 * プログラム サービスパターン短期入所療養介護（認知症疾患） (QS001113_H2104)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.dnd.*;
import jp.nichicom.ac.component.dnd.event.*;
import jp.nichicom.ac.component.event.*;
import jp.nichicom.ac.component.mainmenu.*;
import jp.nichicom.ac.component.table.*;
import jp.nichicom.ac.component.table.event.*;
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
import jp.nichicom.ac.lang.*;
import jp.nichicom.ac.pdf.*;
import jp.nichicom.ac.sql.*;
import jp.nichicom.ac.text.*;
import jp.nichicom.ac.util.*;
import jp.nichicom.ac.util.adapter.*;
import jp.nichicom.vr.*;
import jp.nichicom.vr.bind.*;
import jp.nichicom.vr.bind.event.*;
import jp.nichicom.vr.border.*;
import jp.nichicom.vr.component.*;
import jp.nichicom.vr.component.event.*;
import jp.nichicom.vr.component.table.*;
import jp.nichicom.vr.container.*;
import jp.nichicom.vr.focus.*;
import jp.nichicom.vr.image.*;
import jp.nichicom.vr.io.*;
import jp.nichicom.vr.layout.*;
import jp.nichicom.vr.text.*;
import jp.nichicom.vr.text.parsers.*;
import jp.nichicom.vr.util.*;
import jp.nichicom.vr.util.adapter.*;
import jp.nichicom.vr.util.logging.*;
import jp.or.med.orca.qkan.*;
import jp.or.med.orca.qkan.affair.*;
import jp.or.med.orca.qkan.component.*;
/**
 * サービスパターン短期入所療養介護（認知症疾患）状態定義(QS001113_H2104) 
 */
public class QS001113_H2104State extends QS001113_H2104Design {
  /**
   * コンストラクタです。
   */
  public QS001113_H2104State(){
  }

  /**
   * 「食事提供・あり」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_USE_MEAT() throws Exception {

        getShortStayDementiaRecuperationDinnerCost().setEnabled(true);

  }

  /**
   * 「食事提供・なし」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_NOT_USE_MEAT() throws Exception {

        getShortStayDementiaRecuperationDinnerCost().setEnabled(false);

  }

  /**
   * 「療養食加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_MEDICAL_EXPENSES() throws Exception {

        getShortStayDementiaRecuperationMedicalExpensesRadio().setEnabled(true);

  }

  /**
   * 「療養食加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_MEDICAL_EXPENSES() throws Exception {

        getShortStayDementiaRecuperationMedicalExpensesRadio().setEnabled(false);

  }

  /**
   * 「従来型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_CONVENTIONAL_FORM() throws Exception {

        getShortStayDementiaRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayDementiaRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayDementiaRecuperationHospitalDivisionRadio().setEnabled(true);

        getShortStayDementiaRecuperationDivision().setEnabled(true);

        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().setEnabled(false);

        getShortStayDementiaRecuperationType1().setEnabled(true);

        getShortStayDementiaRecuperationType2().setEnabled(false);

        getShortStayDementiaRecuperationType3().setEnabled(false);

        getShortStayDementiaRecuperationType4().setEnabled(false);

        getShortStayDementiaRecuperationType5().setEnabled(false);

  }

  /**
   * 「ユニット型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_UNIT_FORM() throws Exception {

        getShortStayDementiaRecuperationHospitalRoomRadio().setEnabled(false);

        getShortStayDementiaRecuperationUnitHospitalRoomRadio().setEnabled(true);

        getShortStayDementiaRecuperationHospitalDivisionRadio().setEnabled(true);

        getShortStayDementiaRecuperationDivision().setEnabled(false);

        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().setEnabled(true);

        getShortStayDementiaRecuperationType1().setEnabled(false);

        getShortStayDementiaRecuperationType2().setEnabled(true);

        getShortStayDementiaRecuperationType3().setEnabled(true);

        getShortStayDementiaRecuperationType4().setEnabled(true);

        getShortStayDementiaRecuperationType5().setEnabled(true);

  }

  /**
   * 「日帰りショートステイ・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SELECT_SHORT_STAY() throws Exception {

        getShortStayDementiaRecuperationHospitalRoomRadio().setEnabled(false);

        getShortStayDementiaRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayDementiaRecuperationHospitalDivisionRadio().setEnabled(false);

        getShortStayDementiaRecuperationDivision().setEnabled(false);

        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().setEnabled(false);

        getShortStayDementiaRecuperationEmergencyNetworkAddRadio().setEnabled(false);

  }

  /**
   * 「ユニットケアの整備・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_UNIT_CARE() throws Exception {

        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().setEnabled(true);

  }

  /**
   * 「ユニットケアの整備・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_UNIT_CARE() throws Exception {

        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().setEnabled(false);

  }

  /**
   * 「緊急短期入所ネットワーク体制・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_NETWORK_ADD() throws Exception {

        getShortStayDementiaRecuperationEmergencyNetworkAddRadio().setEnabled(true);

  }

  /**
   * 「緊急短期入所ネットワーク体制・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_NETWORK_ADD() throws Exception {

        getShortStayDementiaRecuperationEmergencyNetworkAddRadio().setEnabled(false);

  }

  /**
   * 「人員配置区分・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_STAFF_ASSIGNMENT() throws Exception {

        getShortStayDementiaRecuperationType2().setEnabled(true);

        getShortStayDementiaRecuperationType3().setEnabled(true);

  }

  /**
   * 「人員配置区分・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_STAFF_ASSIGNMENT() throws Exception {

        getShortStayDementiaRecuperationType1().setEnabled(true);

        getShortStayDementiaRecuperationType2().setEnabled(false);

        getShortStayDementiaRecuperationType3().setEnabled(false);

        getShortStayDementiaRecuperationType4().setEnabled(true);

        getShortStayDementiaRecuperationType5().setEnabled(true);

  }

  /**
   * 「人員配置区分・大学病院選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SELECT_HOSPITAL() throws Exception {

        getShortStayDementiaRecuperationType1().setEnabled(true);

        getShortStayDementiaRecuperationType2().setEnabled(false);

        getShortStayDementiaRecuperationType3().setEnabled(false);

        getShortStayDementiaRecuperationType4().setEnabled(false);

        getShortStayDementiaRecuperationType5().setEnabled(false);

  }

  /**
   * 「人員配置区分・大学病院非選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_UNSELECT_HOSPITAL() throws Exception {

        getShortStayDementiaRecuperationType1().setEnabled(false);

        getShortStayDementiaRecuperationType2().setEnabled(false);

        getShortStayDementiaRecuperationType3().setEnabled(false);

        getShortStayDementiaRecuperationType4().setEnabled(true);

        getShortStayDementiaRecuperationType5().setEnabled(true);

  }

  /**
   * 「人員配置区分・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_STAFF() throws Exception {

        getShortStayDementiaRecuperationDivision().setEnabled(true);

  }

  /**
   * 「人員配置区分・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_STAFF() throws Exception {

        getShortStayDementiaRecuperationDivision().setEnabled(false);

  }

  /**
   * 「人員配置区分Ⅰ型・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_STAFF_DIVISION1() throws Exception {

        getShortStayDementiaRecuperationType1().setEnabled(false);

        getShortStayDementiaRecuperationType2().setEnabled(true);

        getShortStayDementiaRecuperationType3().setEnabled(true);

        getShortStayDementiaRecuperationType4().setEnabled(true);

        getShortStayDementiaRecuperationType5().setEnabled(true);

  }

  /**
   * 「日帰りショートステイ・選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SHORT_STAY_SELECT() throws Exception {

        getShortStayDementiaRecuperationSickroomDivisionRadio().getParent().setVisible(true);

        getShortStayDementiaRecuperationHospitalRoomDivisionContena().setVisible(false);

        getTankinyusyoTimeDivision().setEnabled(true);

  }

  /**
   * 「日帰りショートステイ・非選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SHORT_STAY_UNSELECT() throws Exception {

        getShortStayDementiaRecuperationSickroomDivisionRadio().getParent().setVisible(false);

        getShortStayDementiaRecuperationHospitalRoomDivisionContena().setVisible(true);

        getTankinyusyoTimeDivision().setEnabled(false);

  }

  /**
   * 「経過型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_PASSAGE_FORM() throws Exception {

        getShortStayDementiaRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayDementiaRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayDementiaRecuperationHospitalDivisionRadio().setEnabled(false);

        getShortStayDementiaRecuperationDivision().setEnabled(false);

        getShortStayDementiaRecuperationUnitCareMaintenanceRadio().setEnabled(false);

  }

}
