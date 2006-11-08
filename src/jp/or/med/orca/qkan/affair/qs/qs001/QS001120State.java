
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
 * 作成日: 2006/07/11  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護療養型医療施設（病院） (QS001120)
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
 * サービスパターン介護療養型医療施設（病院）状態定義(QS001120) 
 */
public class QS001120State extends QS001120Design {
  /**
   * コンストラクタです。
   */
  public QS001120State(){
  }

  /**
   * 「栄養管理・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_DIETICIAN_MANAGE() throws Exception {

        getMedicalFacilityHospitalNutritionManageRadio().setEnabled(true);

  }

  /**
   * 「栄養管理・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_DIETICIAN_MANAGE() throws Exception {

        getMedicalFacilityHospitalNutritionManageRadio().setEnabled(false);

  }

  /**
   * 「栄養マネジメント・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_MANAGE() throws Exception {

        getMedicalFacilityHospitalNutritionRadio().setEnabled(true);

  }

  /**
   * 「栄養マネジメント・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_MANAGE() throws Exception {

        getMedicalFacilityHospitalNutritionRadio().setEnabled(false);

  }

  /**
   * 「経口移行・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_NUTRITION() throws Exception {

        getMedicalFacilityHospitalOralSwitchRadio().setEnabled(true);

  }

  /**
   * 「経口移行・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_NUTRITION() throws Exception {

        getMedicalFacilityHospitalOralSwitchRadio().setEnabled(false);

  }

  /**
   * 「療養食・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_MEDICAL_EXPENSES() throws Exception {

        getMedicalFacilityHospitalRecuperateDinnerRadio().setEnabled(true);

  }

  /**
   * 「療養食・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_MEDICAL_EXPENSES() throws Exception {

        getMedicalFacilityHospitalRecuperateDinnerRadio().setEnabled(false);

  }

  /**
   * 「従来型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_CONVENTIONAL_FORM() throws Exception {

        getMedicalFacilityHospitalHospitalRoomRadio().setEnabled(true);

        getMedicalFacilityHospitalUnitHospitalRoomRadio().setEnabled(false);

        getUnitCareMaintenanceRadio().setEnabled(false);

        getMedicalFacilityHospitalHospitalDivision().setEnabled(true);

        getTrialHijoRadio().setEnabled(false);

  }

  /**
   * 「ユニット型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_UNIT_FORM() throws Exception {

        getMedicalFacilityHospitalHospitalRoomRadio().setEnabled(false);

        getMedicalFacilityHospitalUnitHospitalRoomRadio().setEnabled(true);

        getUnitCareMaintenanceRadio().setEnabled(true);

        getMedicalFacilityHospitalHospitalDivision().setEnabled(false);

        getTrialHijoRadio().setEnabled(false);

  }

  /**
   * 「食事提供・あり」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_USE_MEAT() throws Exception {

        getMedicalFacilityDinnerCost().setEnabled(true);

  }

  /**
   * 「食事提供・なし」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_NOT_USE_MEAT() throws Exception {

        getMedicalFacilityDinnerCost().setEnabled(false);

  }

  /**
   * 「ユニットケア体制・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_UNIT_CARE() throws Exception {

        getUnitCareMaintenanceRadio().setEnabled(true);

  }

  /**
   * 「ユニットケア体制・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_UNIT_CARE() throws Exception {

        getUnitCareMaintenanceRadio().setEnabled(false);

  }

  /**
   * 「人員減算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_SUBTRACTION() throws Exception {

        getMedicalFacilityHospitalDivision1().setEnabled(true);

        getMedicalFacilityHospitalDivision2().setEnabled(true);

        getMedicalFacilityHospitalDivision3().setEnabled(true);

  }

  /**
   * 「人員減算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_SUBTRACTION() throws Exception {

        getMedicalFacilityHospitalDivision1().setEnabled(false);

        getMedicalFacilityHospitalDivision2().setEnabled(false);

        getMedicalFacilityHospitalDivision3().setEnabled(true);

  }

  /**
   * 「経口維持加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_KEEP_NUTRITION() throws Exception {

        getOralMaintenanceRadio().setEnabled(true);

  }

  /**
   * 「経口維持加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_KEEP_NUTRITION() throws Exception {

        getOralMaintenanceRadio().setEnabled(false);

  }

  /**
   * 「他科受信の有無・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_TAKAJYUSIN() throws Exception {

        getMedicalFacilityHospitalMedicalExaminationRadio().setEnabled(true);

  }

  /**
   * 「他科受信の有無・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_TAKAJYUSIN() throws Exception {

        getMedicalFacilityHospitalMedicalExaminationRadio().setEnabled(false);

  }

  /**
   * 「外泊加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_GAIHAKU() throws Exception {

        getMedicalFacilityHospitalStayRadio().setEnabled(true);

  }

  /**
   * 「外泊加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_GAIHAKU() throws Exception {

        getMedicalFacilityHospitalStayRadio().setEnabled(false);

  }

  /**
   * 「経過型」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_PASSAGE_FORM() throws Exception {

        getMedicalFacilityHospitalHospitalRoomRadio().setEnabled(true);

        getMedicalFacilityHospitalUnitHospitalRoomRadio().setEnabled(false);

        getUnitCareMaintenanceRadio().setEnabled(false);

        getMedicalFacilityHospitalHospitalDivision().setEnabled(false);

        getTrialHijoRadio().setEnabled(true);

  }

  /**
   * 「試行的退院・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_TRIAL_HIJO() throws Exception {

        getTrialHijoRadio().setEnabled(true);

  }

  /**
   * 「試行的退院・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_TRIAL_HIJO() throws Exception {

        getTrialHijoRadio().setEnabled(false);

  }

}
