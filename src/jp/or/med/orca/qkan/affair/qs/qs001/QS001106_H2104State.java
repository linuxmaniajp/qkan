
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
 * 作成日: 2009/03/05  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービスパターン居宅療養管理指導 (001)
 * プログラム サービスパターン居宅療養管理指導 (QS001106_H2104)
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
 * サービスパターン居宅療養管理指導状態定義(QS001106_H2104) 
 */
public class QS001106_H2104State extends QS001106_H2104Design {
  /**
   * コンストラクタです。
   */
  public QS001106_H2104State(){
  }

  /**
   * 「医師選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DOCTOR() throws Exception {

        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().setEnabled(true);

        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().setEnabled(false);

        getRecuperationManagementGuidanceInfoAddRadio().setEnabled(true);

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(false);

        getKyotakuClass().setEnabled(false);

        getPatientRadioGroup().setEnabled(false);

  }

  /**
   * 「薬剤師（医療機関）選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_CHEMIST_HOSPITAL() throws Exception {

        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().setEnabled(false);

        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().setEnabled(true);

        getRecuperationManagementGuidanceInfoAddRadio().setEnabled(false);

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(false);

        getKyotakuClass().setEnabled(false);

        getPatientRadioGroup().setEnabled(true);

  }

  /**
   * 「薬剤師（薬局）選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_CHEMIST_PHARMACY() throws Exception {

        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().setEnabled(false);

        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().setEnabled(true);

        getRecuperationManagementGuidanceInfoAddRadio().setEnabled(false);

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(true);

        getKyotakuClass().setEnabled(false);

        getPatientRadioGroup().setEnabled(true);

  }

  /**
   * 「栄養士・歯科衛生士等選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DIETICIAN() throws Exception {

        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().setEnabled(false);

        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().setEnabled(false);

        getRecuperationManagementGuidanceInfoAddRadio().setEnabled(false);

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(false);

        getKyotakuClass().setEnabled(false);

        getPatientRadioGroup().setEnabled(true);

  }

  /**
   * 「情報提供・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INFO_TRUE() throws Exception {

        getRecuperationManagementGuidanceInfoAddRadio().setEnabled(true);

  }

  /**
   * 「情報提供・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INFO_FALSE() throws Exception {

        getRecuperationManagementGuidanceInfoAddRadio().setEnabled(false);

  }

  /**
   * 「看護職員」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_KANGO() throws Exception {

        getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio().setEnabled(false);

        getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio().setEnabled(false);

        getRecuperationManagementGuidanceInfoAddRadio().setEnabled(false);

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(false);

        getKyotakuClass().setEnabled(true);

        getPatientRadioGroup().setEnabled(false);

  }

  /**
   * 「施設区分・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_PATIENT_RADIO() throws Exception {

        getPatientRadioGroup().setEnabled(true);

  }

  /**
   * 「施設区分・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_PATIENT_RADIO() throws Exception {

        getPatientRadioGroup().setEnabled(false);

  }

  /**
   * 「がん末期・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_GAN_MAKKI() throws Exception {

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(false);

  }

  /**
   * 「がん末期・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_GAN_MAKKI() throws Exception {

        getRecuperationManagementGuidanceTimesCancerEndCheck().setEnabled(true);

  }

}
