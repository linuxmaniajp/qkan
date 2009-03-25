
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
 * 作成日: 2009/03/14  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービスパターン介護老人福祉施設 (001)
 * プログラム サービスパターン介護老人福祉施設 (QS001118_H2104)
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
 * サービスパターン介護老人福祉施設状態定義(QS001118_H2104) 
 */
public class QS001118_H2104State extends QS001118_H2104Design {
  /**
   * コンストラクタです。
   */
  public QS001118_H2104State(){
  }

  /**
   * 「機能訓練・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_FUNCTION_TRAINING() throws Exception {

        getKaigoWelfareFacilityFunctionTrainingRadio().setEnabled(true);

  }

  /**
   * 「機能訓練・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_FUNCTION_TRAINING() throws Exception {

        getKaigoWelfareFacilityFunctionTrainingRadio().setEnabled(false);

  }

  /**
   * 「常勤専従医師配置・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_DOCTOR() throws Exception {

        getKaigoWelfareFacilityFacilityFulltimeDoctorRadio().setEnabled(true);

  }

  /**
   * 「常勤専従医師配置・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_DOCTOR() throws Exception {

        getKaigoWelfareFacilityFacilityFulltimeDoctorRadio().setEnabled(false);

  }

  /**
   * 「精神科医師定期的療養指導・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_PSYCHIATRIST() throws Exception {

        getKaigoWelfareFacilityPsychiatristRadio().setEnabled(true);

  }

  /**
   * 「精神科医師定期的療養指導・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_PSYCHIATRIST() throws Exception {

        getKaigoWelfareFacilityPsychiatristRadio().setEnabled(false);

  }

  /**
   * 「障害者生活支援・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_HANDICAPPED() throws Exception {

        getKaigoWelfareFacilityHandicappedRadio().setEnabled(true);

  }

  /**
   * 「障害者生活支援・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_HANDICAPPED() throws Exception {

        getKaigoWelfareFacilityHandicappedRadio().setEnabled(false);

  }

  /**
   * 「栄養管理・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_DIETICIAN_MANAGE() throws Exception {

  }

  /**
   * 「栄養管理・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_DIETICIAN_MANAGE() throws Exception {

  }

  /**
   * 「栄養マネジメント・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_MANAGE() throws Exception {

        getKaigoWelfareFacilityNutritionRadio().setEnabled(true);

  }

  /**
   * 「栄養マネジメント・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_MANAGE() throws Exception {

        getKaigoWelfareFacilityNutritionRadio().setEnabled(false);

  }

  /**
   * 「経口移行加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_NUTRITION() throws Exception {

        getKaigoWelfareFacilityOralSwitchRadio().setEnabled(true);

  }

  /**
   * 「経口移行加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_NUTRITION() throws Exception {

        getKaigoWelfareFacilityOralSwitchRadio().setEnabled(false);

  }

  /**
   * 「療養食・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_MEDICAL_EXPENSES() throws Exception {

        getKaigoWelfareFacilityRecuperateDinnerRadio().setEnabled(true);

  }

  /**
   * 「療養食・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_MEDICAL_EXPENSES() throws Exception {

        getKaigoWelfareFacilityRecuperateDinnerRadio().setEnabled(false);

  }

  /**
   * 「従来型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_CONVENTIONAL_FORM() throws Exception {

        getKaigoWelfareFacilityHospitalRoomDivisionRadio().setEnabled(true);

        getKaigoWelfareFacilityUnitHospitalRoomDivisionRadio().setEnabled(false);

        getKaigoWelfareFacilityUnitCareMaintenanceRadio().setEnabled(false);

  }

  /**
   * 「ユニット型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_UNIT_FORM() throws Exception {

        getKaigoWelfareFacilityHospitalRoomDivisionRadio().setEnabled(false);

        getKaigoWelfareFacilityUnitHospitalRoomDivisionRadio().setEnabled(true);

        getKaigoWelfareFacilityUnitCareMaintenanceRadio().setEnabled(true);

  }

  /**
   * 「食事提供・あり」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_USE_MEAT() throws Exception {

        getKaigoWelfareFacilityDinnerCost().setEnabled(true);

  }

  /**
   * 「食事提供・なし」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_NOT_USE_MEAT() throws Exception {

        getKaigoWelfareFacilityDinnerCost().setEnabled(false);

  }

  /**
   * 「ユニットケア体制・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_UNIT_CARE() throws Exception {

        getKaigoWelfareFacilityUnitCareMaintenanceRadio().setEnabled(true);

  }

  /**
   * 「ユニットケア体制・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_UNIT_CARE() throws Exception {

        getKaigoWelfareFacilityUnitCareMaintenanceRadio().setEnabled(false);

  }

  /**
   * 「外泊型・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_GAIHAKU_STATE_ON() throws Exception {

        getTab1().setEnabled(false);

        getTab2().setEnabled(false);

        getTab3().setEnabled(false);

        getKaigoWelfareFacilityStayingOutOvernightCostRadio().setEnabled(true);

  }

  /**
   * 「外泊型・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_GAIHAKU_STATE_OFF() throws Exception {

        getTab1().setEnabled(true);

        getTab2().setEnabled(true);

        getTab3().setEnabled(true);

        getKaigoWelfareFacilityStayingOutOvernightCostRadio().setEnabled(true);

  }

  /**
   * 「看取り介護・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_TERMINAL() throws Exception {

        getKaigoWelfareFacilityTakingCareNursingAddDays().setEnabled(true);

  }

  /**
   * 「看取り介護・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_TERMINAL() throws Exception {

        getKaigoWelfareFacilityTakingCareNursingAddDays().setEnabled(false);

  }

  /**
   * 「経口維持加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_KEEP_NUTRITION() throws Exception {

        getKaigoWelfareFacilityJunOralSwitchRadio().setEnabled(true);

  }

  /**
   * 「経口維持加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_KEEP_NUTRITION() throws Exception {

        getKaigoWelfareFacilityJunOralSwitchRadio().setEnabled(false);

  }

  /**
   * 「準ユニットケア体制・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_SUB_UNIT_CARE() throws Exception {

        getKaigoWelfareFacilityJunUnitCareAddRadio().setEnabled(true);

  }

  /**
   * 「準ユニットケア体制・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALLID_SUB_UNIT_CARE() throws Exception {

        getKaigoWelfareFacilityJunUnitCareAddRadio().setEnabled(false);

  }

  /**
   * 「夜勤職員配置加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_NIGHT_NURSE() throws Exception {

        getNightStaffDispositionAddRadioGroup().setEnabled(true);

  }

  /**
   * 「夜勤職員配置加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_NIGHT_NURSE() throws Exception {

        getNightStaffDispositionAddRadioGroup().setEnabled(false);

  }

  /**
   * 「認知症専門ケア加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_DEMENTIA_PRO_CARE() throws Exception {

        getDementiaProfessionalCareAddRadioGroup().setEnabled(true);

  }

  /**
   * 「認知症専門ケア加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_DEMENTIA_PRO_CARE() throws Exception {

        getDementiaProfessionalCareAddRadioGroup().setEnabled(false);

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

}
