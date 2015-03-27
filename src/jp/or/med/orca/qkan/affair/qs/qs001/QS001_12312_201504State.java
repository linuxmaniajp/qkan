
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
 * 作成日: 2015/03/13  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービスパターン短期入所療養介護（診療所療養） (001)
 * プログラム サービスパターン短期入所療養介護（診療所療養） (QS001_12312_201504)
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
 * サービスパターン短期入所療養介護（診療所療養）状態定義(QS001_12312_201504) 
 */
public class QS001_12312_201504State extends QS001_12312_201504Design {
  /**
   * コンストラクタです。
   */
  public QS001_12312_201504State(){
  }

  /**
   * 「食事提供・あり」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_USE_MEAT() throws Exception {

        getShortStayClinicRecuperationDinnerCost().setEnabled(true);

  }

  /**
   * 「食事提供・なし」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_NOT_USE_MEAT() throws Exception {

        getShortStayClinicRecuperationDinnerCost().setEnabled(false);

  }

  /**
   * 「従来型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_CONVENTIONAL_FORM() throws Exception {

        getShortStayClinicRecuperationHospitalRoomRadio().setEnabled(true);

        getShortStayClinicRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayClinicRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayClinicRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getStaffAssignment1Division().setVisible(true);

        getStaffAssignment1Division().setEnabled(true);
        getStaffAssignment1Division().getParent().setEnabled(true);

        getStaffAssignment2Division().setVisible(false);

        getStaffAssignment2Division().setEnabled(false);

  }

  /**
   * 「ユニット型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_UNIT_FORM() throws Exception {

        getShortStayClinicRecuperationHospitalRoomRadio().setEnabled(false);

        getShortStayClinicRecuperationUnitHospitalRoomRadio().setEnabled(true);

        getShortStayClinicRecuperationUnitCareMaintenanceRadio().setEnabled(true);
        getShortStayClinicRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getStaffAssignment1Division().setVisible(false);

        getStaffAssignment1Division().setEnabled(false);

        getStaffAssignment2Division().setVisible(true);

        getStaffAssignment2Division().setEnabled(true);
        getStaffAssignment2Division().getParent().setEnabled(true);

  }

  /**
   * 「日帰りショートステイ・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SELECT_SHORT_STAY_STATE() throws Exception {

        getShortStayClinicRecuperationHospitalRoomRadio().setEnabled(false);

        getShortStayClinicRecuperationUnitHospitalRoomRadio().setEnabled(false);

        getShortStayClinicRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayClinicRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

  }

  /**
   * 「ユニットケアの整備・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_UNIT_CARE() throws Exception {

        getShortStayClinicRecuperationUnitCareMaintenanceRadio().setEnabled(true);
        getShortStayClinicRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(true);

  }

  /**
   * 「ユニットケアの整備・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_UNIT_CARE() throws Exception {

        getShortStayClinicRecuperationUnitCareMaintenanceRadio().setEnabled(false);
        getShortStayClinicRecuperationUnitCareMaintenanceRadio().getParent().setEnabled(false);

  }

  /**
   * 「日帰りショート・選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SHORT_STAY_SELECT() throws Exception {

        getShortStayClinicRecuperationSickroomDivisionRadio().getParent().setVisible(true);

        getShortStayClinicRecuperationSickroomDivisionRadio().setEnabled(true);
        getShortStayClinicRecuperationSickroomDivisionRadio().getParent().setEnabled(true);

        getShortStayClinicRecuperationHospitalRoomContena().setVisible(false);

        getTankinyusyoTimeDivision().setEnabled(true);

        getDementiaActionAddRadioGroup().setEnabled(false);
        getDementiaActionAddRadioGroup().getParent().setEnabled(false);

        getStaffAssignment1Division().setEnabled(false);
        getStaffAssignment1Division().getParent().setEnabled(false);

        getStaffAssignment2Division().setEnabled(false);
        getStaffAssignment2Division().getParent().setEnabled(false);

  }

  /**
   * 「日帰りショート・非選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SHORT_STAY_UNSELECT() throws Exception {

        getShortStayClinicRecuperationSickroomDivisionRadio().getParent().setVisible(false);

        getShortStayClinicRecuperationSickroomDivisionRadio().setEnabled(false);
        getShortStayClinicRecuperationSickroomDivisionRadio().getParent().setEnabled(false);

        getShortStayClinicRecuperationHospitalRoomContena().setVisible(true);

        getTankinyusyoTimeDivision().setEnabled(false);

  }

  /**
   * 「若年性認知症利用者受入加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_YOUNG_DEMENTIA_PATINET() throws Exception {

        getYoungDementiaPatinetAddRadioGroup().setEnabled(true);
        getYoungDementiaPatinetAddRadioGroup().getParent().setEnabled(true);

  }

  /**
   * 「若年性認知症利用者受入加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_YOUNG_DEMENTIA_PATINET() throws Exception {

        getYoungDementiaPatinetAddRadioGroup().setEnabled(false);
        getYoungDementiaPatinetAddRadioGroup().getParent().setEnabled(false);

  }

  /**
   * 「認知症行動・心理症状緊急対応加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_DEMENTIA_ACTION() throws Exception {

        getDementiaActionAddRadioGroup().setEnabled(true);
        getDementiaActionAddRadioGroup().getParent().setEnabled(true);

        getShortStayClinicRecuperationEmergencyNetworkAddRadio().setEnabled(true);
        getShortStayClinicRecuperationEmergencyNetworkAddRadio().getParent().setEnabled(true);

  }

  /**
   * 「認知症行動・心理症状緊急対応加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_DEMENTIA_ACTION() throws Exception {

        getDementiaActionAddRadioGroup().setEnabled(false);
        getDementiaActionAddRadioGroup().getParent().setEnabled(false);

        getShortStayClinicRecuperationEmergencyNetworkAddRadio().setEnabled(false);
        getShortStayClinicRecuperationEmergencyNetworkAddRadio().getParent().setEnabled(false);

  }

  /**
   * 「緊急短期入所受入加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_EMERGENCY_ACCEPTANCE() throws Exception {

        getShortStayClinicRecuperationEmergencyNetworkAddRadio().setEnabled(true);
        getShortStayClinicRecuperationEmergencyNetworkAddRadio().getParent().setEnabled(true);

  }

  /**
   * 「緊急短期入所受入加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_EMERGENCY_ACCEPTANCE() throws Exception {

        getShortStayClinicRecuperationEmergencyNetworkAddRadio().setEnabled(false);
        getShortStayClinicRecuperationEmergencyNetworkAddRadio().getParent().setEnabled(false);

  }

}
