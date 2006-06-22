
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
 * 開発者: 堤 瑞樹
 * 作成日: 2006/06/02  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービスパターン特定施設入所者生活介護 (001)
 * プログラム サービスパターン特定施設入所者生活介護 (QS001115)
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
 * サービスパターン特定施設入所者生活介護状態定義(QS001115) 
 */
public class QS001115State extends QS001115Design {
  /**
   * コンストラクタです。
   */
  public QS001115State(){
  }

  /**
   * 「特定施設入所者選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SELECT_SPECIAL() throws Exception {

        getSpecificFacilityFunctionTrainingRadio().setEnabled(true);

        getNightNursingSystemRadio().setEnabled(true);

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getSpecificFacilityBeginTime().setEnabled(false);

        getSpecificFacilityEndTime().setEnabled(false);

        getOutsideServiceRadio().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

  }

  /**
   * 「外部サービス利用型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SELECT_OUT() throws Exception {

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);

        getNightNursingSystemRadio().setEnabled(false);

        getVisitCareGroup().setEnabled(true);

        getVisitNursingRadioGroup().setEnabled(true);

        getVisitRehabiliGroup().setEnabled(true);

        getExpertPlaceNursingGroup().setEnabled(true);

        getExpertPlaceRehabiliGroup().setEnabled(true);

        getWelfareToolsGroup().setEnabled(true);

        getSpecificFacilityBeginTime().setEnabled(true);

        getSpecificFacilityEndTime().setEnabled(true);

        getOutsideServiceRadio().setEnabled(true);

        getNinchishoTaioTsushoGroup().setEnabled(true);

  }

  /**
   * 「訪問介護選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SELECT_VISIT() throws Exception {

        getVisitCareGroup().setEnabled(true);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

  }

  /**
   * 「訪問看護選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SELECT_VISIT_NURSING() throws Exception {

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(true);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

  }

  /**
   * 「訪問リハ選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SELECT_VISIT_REHABILI() throws Exception {

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(true);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

  }

  /**
   * 「通所介護選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SELECT_EXPERTPLACE_NURSING() throws Exception {

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(true);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

  }

  /**
   * 「通所リハ選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SELECT_EXPERTPLACE_REHABILI() throws Exception {

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(true);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

  }

  /**
   * 「福祉用具貸与選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SELECT_WELFARE_TOOLS() throws Exception {

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(true);

        getNinchishoTaioTsushoGroup().setEnabled(false);

  }

  /**
   * 「訪問入浴介護選択医時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SELECT_VISIT_BATH() throws Exception {

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

  }

  /**
   * 「個別機能訓練指導加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_TRAINING() throws Exception {

        getSpecificFacilityFunctionTrainingRadio().setEnabled(true);

  }

  /**
   * 「個別機能訓練指導加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_TRAINING() throws Exception {

        getSpecificFacilityFunctionTrainingRadio().setEnabled(false);

  }

  /**
   * 「夜間看護体制加算・湯有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_NIGHT_NURSING() throws Exception {

        getNightNursingSystemRadio().setEnabled(true);

  }

  /**
   * 「夜間看護体制・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_NIGHT_NURSING() throws Exception {

        getNightNursingSystemRadio().setEnabled(false);

  }

  /**
   * 「PT・OT・ST・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_STAFF_DIVISION_() throws Exception {

        getVisitNursingStaffDivisionRadioItem2().setEnabled(true);

  }

  /**
   * 「PT・OT・ST・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_STAFF_DIVISION_() throws Exception {

        getVisitNursingStaffDivisionRadioItem2().setEnabled(false);

  }

  /**
   * 「認知症対応通所介護・施設区分２・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_NINTI_DIVISION() throws Exception {

        getDivisionRadion().setEnabled(true);

  }

  /**
   * 「認知症対応通所介護・施設区分２・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_NINTI_DIVISION() throws Exception {

        getDivisionRadion().setEnabled(false);

  }

  /**
   * 「認知症対応通所介護選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SELECT_NINTITUUSHO() throws Exception {

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(true);

  }

  /**
   * 「基本単位のみ選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SELECT_ONLY_BASE() throws Exception {

        getVisitCareGroup().setEnabled(false);

        getVisitNursingRadioGroup().setEnabled(false);

        getVisitRehabiliGroup().setEnabled(false);

        getExpertPlaceNursingGroup().setEnabled(false);

        getExpertPlaceRehabiliGroup().setEnabled(false);

        getWelfareToolsGroup().setEnabled(false);

        getNinchishoTaioTsushoGroup().setEnabled(false);

  }

}
