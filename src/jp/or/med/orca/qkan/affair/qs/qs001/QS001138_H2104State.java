
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
 * 開発者: 田中　統蔵
 * 作成日: 2009/03/09  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護予防短期入所療養介護（介護老人保健施設） (QS001138_H2104)
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
 * サービスパターン介護予防短期入所療養介護（介護老人保健施設）状態定義(QS001138_H2104) 
 */
public class QS001138_H2104State extends QS001138_H2104Design {
  /**
   * コンストラクタです。
   */
  public QS001138_H2104State(){
  }

  /**
   * 「病室区分・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_HOSPITAL_ROOM_DIVISION_ENABLE_FALSE() throws Exception {

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio().setEnabled(false);

  }

  /**
   * 「病室区分・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_HOSPITAL_ROOM_DIVISION_ENABLE_TRUE() throws Exception {

        getShortStayRecuperationHealthFacilityHospitalRoomDivisionRadio().setEnabled(true);

  }

  /**
   * 「ユニット型・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_UNIT_HOSPITAL_ROOM_DIVISION_ENABEL_FALSE() throws Exception {

        getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio().setEnabled(false);

  }

  /**
   * 「ユニット型・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_UNIT_HOSPITAL_ROOM_DIVISION_ENABEL_TRUE() throws Exception {

        getShortStayRecuperationHealthFacilityUnitHospitalRoomDivisionRadio().setEnabled(true);

  }

  /**
   * 「ユニットケア・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_UNIT_CARE_ENABLE_FALSE() throws Exception {

        getShortStayRecuperationHealthUnitCareAddRadio().setEnabled(false);

  }

  /**
   * 「ユニットケア・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_UNIT_CARE_ENABLE_TRUE() throws Exception {

        getShortStayRecuperationHealthUnitCareAddRadio().setEnabled(true);

  }

  /**
   * 「リハビリ機能強化加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_REHABILITATION_ENABLE_FALSE() throws Exception {

        getShortStayRecuperationHealthFacilityEtcRehabilitation().setEnabled(false);

  }

  /**
   * 「リハビリ機能強化加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_REHABILITATION_ENABLE_TRUE() throws Exception {

        getShortStayRecuperationHealthFacilityEtcRehabilitation().setEnabled(true);

  }

  /**
   * 「食事テキスト・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DINNER_COST_ENABLE_FALSE() throws Exception {

        getShortStayRecuperationHealthFacilityDinnerCost().setEnabled(false);

  }

  /**
   * 「食事テキスト・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DINNER_COST_ENABLE_TRUE() throws Exception {

        getShortStayRecuperationHealthFacilityDinnerCost().setEnabled(true);

  }

  /**
   * 「療養食加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_MEDICAL_EXPENSES() throws Exception {

        getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio().setEnabled(true);

  }

  /**
   * 「療養食加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_MEDICAL_EXPENSES() throws Exception {

        getShortStayRecuperationHealthFacilityDieticianMedicalExpensesRadio().setEnabled(false);

  }

  /**
   * 「若年性認知症利用者受入加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_YOUNG_DEMENTIA_PATINET() throws Exception {

        getYoungDementiaPatinetAddRadioGroup().setEnabled(true);

  }

  /**
   * 「若年性認知症利用者受入加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_YOUNG_DEMENTIA_PATINET() throws Exception {

        getYoungDementiaPatinetAddRadioGroup().setEnabled(false);

  }

  /**
   * 「認知症行動・心理症状緊急対応加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_DEMENTIA_ACTION() throws Exception {

        getDementiaActionAddRadioGroup().setEnabled(true);

  }

  /**
   * 「認知症行動・心理症状緊急対応加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_DEMENTIA_ACTION() throws Exception {

        getDementiaActionAddRadioGroup().setEnabled(false);

  }

}
