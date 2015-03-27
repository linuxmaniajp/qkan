
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
 * 作成日: 2015/02/27  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護予防特定施設入居者生活介護 (QS001_13511_201504)
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
 * サービスパターン介護予防特定施設入居者生活介護状態定義(QS001_13511_201504) 
 */
public class QS001_13511_201504State extends QS001_13511_201504Design {
  /**
   * コンストラクタです。
   */
  public QS001_13511_201504State(){
  }

  /**
   * 「画面状態１」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_1() throws Exception {

        getOutsideServiceRadio().setEnabled(false);
        getOutsideServiceRadio().getParent().setEnabled(false);

        getSpecificFacilityBeginTime().setEnabled(false);
        getSpecificFacilityBeginTime().getParent().setEnabled(false);

        getSpecificFacilityEndTime().setEnabled(false);
        getSpecificFacilityEndTime().getParent().setEnabled(false);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getVisitCareServiceGroup().setEnabled(false);

        getExpertPlaceNursingServiceGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(true);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(true);

        getImpairedPersonHelpAddRadioGroup().setEnabled(false);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(false);

        getMedicalCoordinateAddRadioGroup().setEnabled(true);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(true);

        getDementiaProfessionalCareAddRadioGroup().setEnabled(true);
        getDementiaProfessionalCareAddRadioGroup().getParent().setEnabled(true);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

        getVisitCareServicePrintable().setEnabled(false);

        getExpertPlaceNursingServicePrintable().setEnabled(false);

  }

  /**
   * 「画面状態２訪問介護」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_2() throws Exception {

        getOutsideServiceRadio().setEnabled(true);
        getOutsideServiceRadio().getParent().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);
        getSpecificFacilityBeginTime().getParent().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);
        getSpecificFacilityEndTime().getParent().setEnabled(true);

        getVisitCareGroup().setEnabled(true);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getVisitCareServiceGroup().setEnabled(false);

        getExpertPlaceNursingServiceGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getDementiaProfessionalCareAddRadioGroup().setEnabled(false);
        getDementiaProfessionalCareAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(true);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

        getVisitCareServicePrintable().setEnabled(false);

        getExpertPlaceNursingServicePrintable().setEnabled(false);

  }

  /**
   * 「画面状態３訪問入浴」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_3() throws Exception {

        getOutsideServiceRadio().setEnabled(true);
        getOutsideServiceRadio().getParent().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);
        getSpecificFacilityBeginTime().getParent().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);
        getSpecificFacilityEndTime().getParent().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getVisitCareServiceGroup().setEnabled(false);

        getExpertPlaceNursingServiceGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getDementiaProfessionalCareAddRadioGroup().setEnabled(false);
        getDementiaProfessionalCareAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

        getVisitCareServicePrintable().setEnabled(false);

        getExpertPlaceNursingServicePrintable().setEnabled(false);

  }

  /**
   * 「画面状態４訪問看護」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_4() throws Exception {

        getOutsideServiceRadio().setEnabled(true);
        getOutsideServiceRadio().getParent().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);
        getSpecificFacilityBeginTime().getParent().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);
        getSpecificFacilityEndTime().getParent().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(true);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getVisitCareServiceGroup().setEnabled(false);

        getExpertPlaceNursingServiceGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getDementiaProfessionalCareAddRadioGroup().setEnabled(false);
        getDementiaProfessionalCareAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

        getVisitCareServicePrintable().setEnabled(false);

        getExpertPlaceNursingServicePrintable().setEnabled(false);

  }

  /**
   * 「画面状態５訪問看護」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_5() throws Exception {

        getOutsideServiceRadio().setEnabled(true);
        getOutsideServiceRadio().getParent().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);
        getSpecificFacilityBeginTime().getParent().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);
        getSpecificFacilityEndTime().getParent().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(true);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(true);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getVisitCareServiceGroup().setEnabled(false);

        getExpertPlaceNursingServiceGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getDementiaProfessionalCareAddRadioGroup().setEnabled(false);
        getDementiaProfessionalCareAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

        getVisitCareServicePrintable().setEnabled(false);

        getExpertPlaceNursingServicePrintable().setEnabled(false);

  }

  /**
   * 「画面状態６訪問リハ」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_6() throws Exception {

        getOutsideServiceRadio().setEnabled(true);
        getOutsideServiceRadio().getParent().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);
        getSpecificFacilityBeginTime().getParent().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);
        getSpecificFacilityEndTime().getParent().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(true);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getVisitCareServiceGroup().setEnabled(false);

        getExpertPlaceNursingServiceGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getDementiaProfessionalCareAddRadioGroup().setEnabled(false);
        getDementiaProfessionalCareAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

        getVisitCareServicePrintable().setEnabled(false);

        getExpertPlaceNursingServicePrintable().setEnabled(false);

  }

  /**
   * 「画面状態７通所介護」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_7() throws Exception {

        getOutsideServiceRadio().setEnabled(true);
        getOutsideServiceRadio().getParent().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);
        getSpecificFacilityBeginTime().getParent().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);
        getSpecificFacilityEndTime().getParent().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(true);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getVisitCareServiceGroup().setEnabled(false);

        getExpertPlaceNursingServiceGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getDementiaProfessionalCareAddRadioGroup().setEnabled(false);
        getDementiaProfessionalCareAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(true);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

        getVisitCareServicePrintable().setEnabled(false);

        getExpertPlaceNursingServicePrintable().setEnabled(false);

  }

  /**
   * 「画面状態８通所リハ」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_8() throws Exception {

        getOutsideServiceRadio().setEnabled(true);
        getOutsideServiceRadio().getParent().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);
        getSpecificFacilityBeginTime().getParent().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);
        getSpecificFacilityEndTime().getParent().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(true);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getVisitCareServiceGroup().setEnabled(false);

        getExpertPlaceNursingServiceGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getDementiaProfessionalCareAddRadioGroup().setEnabled(false);
        getDementiaProfessionalCareAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(true);

        getVisitCareServicePrintable().setEnabled(false);

        getExpertPlaceNursingServicePrintable().setEnabled(false);

  }

  /**
   * 「画面状態９福祉用具」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_9() throws Exception {

        getOutsideServiceRadio().setEnabled(true);
        getOutsideServiceRadio().getParent().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);
        getSpecificFacilityBeginTime().getParent().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);
        getSpecificFacilityEndTime().getParent().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(true);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getVisitCareServiceGroup().setEnabled(false);

        getExpertPlaceNursingServiceGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getDementiaProfessionalCareAddRadioGroup().setEnabled(false);
        getDementiaProfessionalCareAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

        getVisitCareServicePrintable().setEnabled(false);

        getExpertPlaceNursingServicePrintable().setEnabled(false);

  }

  /**
   * 「画面状態１０認知症」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_10() throws Exception {

        getOutsideServiceRadio().setEnabled(true);
        getOutsideServiceRadio().getParent().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);
        getSpecificFacilityBeginTime().getParent().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);
        getSpecificFacilityEndTime().getParent().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(true);

        getVisitCareServiceGroup().setEnabled(false);

        getExpertPlaceNursingServiceGroup().setEnabled(false);

        getDivisionRadion().setEnabled(true);
        getDivisionRadion().getParent().setEnabled(true);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getDementiaProfessionalCareAddRadioGroup().setEnabled(false);
        getDementiaProfessionalCareAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

        getVisitCareServicePrintable().setEnabled(false);

        getExpertPlaceNursingServicePrintable().setEnabled(false);

  }

  /**
   * 「画面状態１１認知症」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_11() throws Exception {

        getOutsideServiceRadio().setEnabled(true);
        getOutsideServiceRadio().getParent().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);
        getSpecificFacilityBeginTime().getParent().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);
        getSpecificFacilityEndTime().getParent().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(true);

        getVisitCareServiceGroup().setEnabled(false);

        getExpertPlaceNursingServiceGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getDementiaProfessionalCareAddRadioGroup().setEnabled(false);
        getDementiaProfessionalCareAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

        getVisitCareServicePrintable().setEnabled(false);

        getExpertPlaceNursingServicePrintable().setEnabled(false);

  }

  /**
   * 「画面状態1２」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_12() throws Exception {

        getOutsideServiceRadio().setEnabled(true);
        getOutsideServiceRadio().getParent().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);
        getSpecificFacilityBeginTime().getParent().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);
        getSpecificFacilityEndTime().getParent().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getVisitCareServiceGroup().setEnabled(true);

        getExpertPlaceNursingServiceGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getDementiaProfessionalCareAddRadioGroup().setEnabled(false);
        getDementiaProfessionalCareAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

        getVisitCareServicePrintable().setEnabled(true);

        getExpertPlaceNursingServicePrintable().setEnabled(false);

  }

  /**
   * 「画面状態１３」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_13() throws Exception {

        getOutsideServiceRadio().setEnabled(true);
        getOutsideServiceRadio().getParent().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);
        getSpecificFacilityBeginTime().getParent().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);
        getSpecificFacilityEndTime().getParent().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getVisitCareServiceGroup().setEnabled(false);

        getExpertPlaceNursingServiceGroup().setEnabled(true);

        getDivisionRadion().setEnabled(false);
        getDivisionRadion().getParent().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);
        getSpecificFacilityFunctionTrainingRadio().getParent().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);
        getImpairedPersonHelpAddRadioGroup().getParent().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);
        getMedicalCoordinateAddRadioGroup().getParent().setEnabled(false);

        getDementiaProfessionalCareAddRadioGroup().setEnabled(false);
        getDementiaProfessionalCareAddRadioGroup().getParent().setEnabled(false);

        getVisitCarePrintable().setEnabled(false);

        getExpertPlaceNursingPrintable().setEnabled(false);

        getExpertPlaceRehabiliPrintable().setEnabled(false);

        getVisitCareServicePrintable().setEnabled(false);

        getExpertPlaceNursingServicePrintable().setEnabled(true);

  }

  /**
   * 「訪問介護・日割・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DAY_CHECK_VISIT_CARE_ON() throws Exception {

        getVisitCarePrintable().setEnabled(true);

  }

  /**
   * 「訪問介護・日割・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DAY_CHECK_VISIT_CARE_OFF() throws Exception {

        getVisitCarePrintable().setEnabled(false);

  }

  /**
   * 「通所介護・日割・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DAY_CHECK_NURSING_ON() throws Exception {

        getExpertPlaceNursingPrintable().setEnabled(true);

  }

  /**
   * 「通所介護・日割・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DAY_CHECK_NURSING_OFF() throws Exception {

        getExpertPlaceNursingPrintable().setEnabled(false);

  }

  /**
   * 「通所リハ・日割・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DAY_CHECK_REHABILI_ON() throws Exception {

        getExpertPlaceRehabiliPrintable().setEnabled(true);

  }

  /**
   * 「通所リハ・日割・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DAY_CHECK_REHABILI_OFF() throws Exception {

        getExpertPlaceRehabiliPrintable().setEnabled(false);

  }

  /**
   * 「1日に2回を越えて実施・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_TWO_OR_MORE_TIMES() throws Exception {

        getTwoOrMoreTimesCheck().setEnabled(true);

        getVisitNursingCombo().setEnabled(false);

  }

  /**
   * 「1日に2回を越えて実施・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_TWO_OR_MORE_TIMES() throws Exception {

        getTwoOrMoreTimesCheck().setEnabled(false);

        getVisitNursingCombo().setEnabled(true);

  }

  /**
   * 「訪問型サービス・日割・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DAY_CHECK_VISIT_CARE_SERVICE_ON() throws Exception {

        getVisitCareServicePrintable().setEnabled(true);

  }

  /**
   * 「訪問型サービス・日割・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DAY_CHECK_VISIT_CARE_SERVICE_OFF() throws Exception {

        getVisitCareServicePrintable().setEnabled(false);

  }

  /**
   * 「通所型サービス・日割・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DAY_CHECK_NURSING_SERVICE_ON() throws Exception {

        getExpertPlaceNursingServicePrintable().setEnabled(true);

  }

  /**
   * 「通所型サービス・日割・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DAY_CHECK_NURSING_SERVICE_OFF() throws Exception {

        getExpertPlaceNursingServicePrintable().setEnabled(false);

  }

  /**
   * 「看護職員区分・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_NURSE_STAFF_DIVISION() throws Exception {

        getNurseStaffDivisionRadioGroup().setEnabled(true);
        getNurseStaffDivisionRadioGroup().getParent().setEnabled(true);

  }

  /**
   * 「看護職員区分・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_NURSE_STAFF_DIVISION() throws Exception {

        getNurseStaffDivisionRadioGroup().setEnabled(false);
        getNurseStaffDivisionRadioGroup().getParent().setEnabled(false);

  }

}
