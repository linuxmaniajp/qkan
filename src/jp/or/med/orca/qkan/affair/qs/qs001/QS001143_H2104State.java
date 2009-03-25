
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
 * 作成日: 2009/03/16  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護予防特定施設入居者生活介護 (QS001143_H2104)
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
 * サービスパターン介護予防特定施設入居者生活介護状態定義(QS001143_H2104) 
 */
public class QS001143_H2104State extends QS001143_H2104Design {
  /**
   * コンストラクタです。
   */
  public QS001143_H2104State(){
  }

  /**
   * 「画面状態１」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_1() throws Exception {

        getOutsideServiceRadio().setEnabled(false);

        getSpecificFacilityBeginTime().setEnabled(false);

        getSpecificFacilityEndTime().setEnabled(false);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(true);

        getImpairedPersonHelpAddRadioGroup().setEnabled(false);

        getMedicalCoordinateAddRadioGroup().setEnabled(true);

  }

  /**
   * 「画面状態２」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_2() throws Exception {

        getOutsideServiceRadio().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);

        getVisitCareGroup().setEnabled(true);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);

  }

  /**
   * 「画面状態３」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_3() throws Exception {

        getOutsideServiceRadio().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);

  }

  /**
   * 「画面状態４」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_4() throws Exception {

        getOutsideServiceRadio().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(true);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);

  }

  /**
   * 「画面状態５」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_5() throws Exception {

        getOutsideServiceRadio().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(true);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(true);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);

  }

  /**
   * 「画面状態６」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_6() throws Exception {

        getOutsideServiceRadio().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(true);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);

  }

  /**
   * 「画面状態７」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_7() throws Exception {

        getOutsideServiceRadio().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(true);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);

  }

  /**
   * 「画面状態８」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_8() throws Exception {

        getOutsideServiceRadio().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(true);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);

  }

  /**
   * 「画面状態９」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_9() throws Exception {

        getOutsideServiceRadio().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(true);

        getNinchishoTaioTsushoGroup().setEnabled(false);

        getDivisionRadion().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);

  }

  /**
   * 「画面状態１０」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_10() throws Exception {

        getOutsideServiceRadio().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(true);

        getDivisionRadion().setEnabled(true);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);

  }

  /**
   * 「画面状態１１」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_MODE_11() throws Exception {

        getOutsideServiceRadio().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(true);

        getDivisionRadion().setEnabled(false);

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);

        getImpairedPersonHelpAddRadioGroup().setEnabled(true);

        getMedicalCoordinateAddRadioGroup().setEnabled(false);

  }

  /**
   * 「個別機能訓練体制・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INDIVIDUAL_FUNCTION_TRAINING_ENABLE_FALSE() throws Exception {

        getNinchishoTaioTsushoIndividualFunctionTrainingAddRadio().setEnabled(false);

  }

  /**
   * 「個別機能訓練体制・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INDIVIDUAL_FUNCTION_TRAINING_ENABLE_TRUE() throws Exception {

        getNinchishoTaioTsushoIndividualFunctionTrainingAddRadio().setEnabled(true);

  }

}
