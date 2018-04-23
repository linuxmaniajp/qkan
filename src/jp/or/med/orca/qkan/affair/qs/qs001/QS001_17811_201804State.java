
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
 * 開発者: 日高　しのぶ
 * 作成日: 2018/03/03  日本コンピューター株式会社 日高　しのぶ 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン地域密着型通所介護 (QS001_17811_201804)
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
 * サービスパターン地域密着型通所介護状態定義(QS001_17811_201804) 
 */
public class QS001_17811_201804State extends QS001_17811_201804Design {
  /**
   * コンストラクタです。
   */
  public QS001_17811_201804State(){
  }

  /**
   * 「個別機能訓練・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_FUNCTION_TRAINING() throws Exception {

        getTsuusyoKaigoAdditionFunctionTrainingRadio().setEnabled(true);

  }

  /**
   * 「個別機能訓練・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_FUNCTION_TRAINING() throws Exception {

        getTsuusyoKaigoAdditionFunctionTrainingRadio().setEnabled(false);

  }

  /**
   * 「入浴加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_ADD_BATH() throws Exception {

        getTsuusyoKaigoAdditionFunctionBathRadio().setEnabled(true);
        getTsuusyoKaigoAdditionFunctionBathRadio().getParent().setEnabled(true);

  }

  /**
   * 「入浴加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_ADD_BATH() throws Exception {

        getTsuusyoKaigoAdditionFunctionBathRadio().setEnabled(false);
        getTsuusyoKaigoAdditionFunctionBathRadio().getParent().setEnabled(false);

  }

  /**
   * 「栄養マネジメント体制・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_NOURISHMENT_MANAGEMENT() throws Exception {

        getTsuusyoKaigoNourishmentManagementAddRadio().setEnabled(true);
        getTsuusyoKaigoNourishmentManagementAddRadio().getParent().setEnabled(true);

  }

  /**
   * 「栄養マネジメント体制・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_NOURISHMENT_MANAGEMENT() throws Exception {

        getTsuusyoKaigoNourishmentManagementAddRadio().setEnabled(false);
        getTsuusyoKaigoNourishmentManagementAddRadio().getParent().setEnabled(false);

  }

  /**
   * 「口腔機能向上加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_MOUTH_FUNCTION() throws Exception {

        getTsuusyoKaigoMouthFunctionAddRadio().setEnabled(true);
        getTsuusyoKaigoMouthFunctionAddRadio().getParent().setEnabled(true);

  }

  /**
   * 「口腔機能向上加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_MOUTH_FUNCTION() throws Exception {

        getTsuusyoKaigoMouthFunctionAddRadio().setEnabled(false);
        getTsuusyoKaigoMouthFunctionAddRadio().getParent().setEnabled(false);

  }

  /**
   * 「療養通所選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_RYOYO() throws Exception {

        getTsuusyoKaigoAdditionFunctionTrainingRadio().setEnabled(false);

        getTsuusyoKaigoAdditionFunctionBathRadio().setEnabled(false);
        getTsuusyoKaigoAdditionFunctionBathRadio().getParent().setEnabled(false);

        getTsuusyoKaigoNourishmentManagementAddRadio().setEnabled(false);
        getTsuusyoKaigoNourishmentManagementAddRadio().getParent().setEnabled(false);

        getTsuusyoKaigoMouthFunctionAddRadio().setEnabled(false);
        getTsuusyoKaigoMouthFunctionAddRadio().getParent().setEnabled(false);

        getYoungDementiaPatinetAddRadioGroup().setEnabled(false);
        getYoungDementiaPatinetAddRadioGroup().getParent().setEnabled(false);

        getDementiaElderlyAccepted().setEnabled(false);
        getDementiaElderlyAccepted().getParent().setEnabled(false);

        getSevereCareRecipientsAccepted().setEnabled(false);
        getSevereCareRecipientsAccepted().getParent().setEnabled(false);

        getIndividualPickupSystem().setEnabled(true);
        getIndividualPickupSystem().getParent().setEnabled(true);

        getBathingAssistanceSystem().setEnabled(true);
        getBathingAssistanceSystem().getParent().setEnabled(true);

  }

  /**
   * 「地域密着型通所選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_STATE_SMALL() throws Exception {

        getTsuusyoKaigoAdditionFunctionTrainingRadio().setEnabled(true);

        getTsuusyoKaigoAdditionFunctionBathRadio().setEnabled(true);
        getTsuusyoKaigoAdditionFunctionBathRadio().getParent().setEnabled(true);

        getTsuusyoKaigoNourishmentManagementAddRadio().setEnabled(true);
        getTsuusyoKaigoNourishmentManagementAddRadio().getParent().setEnabled(true);

        getTsuusyoKaigoMouthFunctionAddRadio().setEnabled(true);
        getTsuusyoKaigoMouthFunctionAddRadio().getParent().setEnabled(true);

        getYoungDementiaPatinetAddRadioGroup().setEnabled(true);
        getYoungDementiaPatinetAddRadioGroup().getParent().setEnabled(true);

        getDementiaElderlyAccepted().setEnabled(true);
        getDementiaElderlyAccepted().getParent().setEnabled(true);

        getSevereCareRecipientsAccepted().setEnabled(true);
        getSevereCareRecipientsAccepted().getParent().setEnabled(true);

        getIndividualPickupSystem().setEnabled(false);
        getIndividualPickupSystem().getParent().setEnabled(false);

        getBathingAssistanceSystem().setEnabled(false);
        getBathingAssistanceSystem().getParent().setEnabled(false);

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
   * 「個別機能訓練II・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_FUNCTION_TRAINING2() throws Exception {

        getTsuusyoKaigoAdditionFunctionTrainingRadio().setEnabled(true);

        getTsuusyoKaigoAdditionFunctionTrainingRadioItem1().setEnabled(false);

        getTsuusyoKaigoAdditionFunctionTrainingRadioItem2().setEnabled(true);

  }

  /**
   * 「個別機能訓練II・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_FUNCTION_TRAINING2() throws Exception {

        getTsuusyoKaigoAdditionFunctionTrainingRadio().setEnabled(false);

        getTsuusyoKaigoAdditionFunctionTrainingRadioItem1().setEnabled(false);

        getTsuusyoKaigoAdditionFunctionTrainingRadioItem2().setEnabled(false);

  }

  /**
   * 「個別機能訓練I・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_FUNCTION_TRAINING1() throws Exception {

        getTsuusyoKaigoAdditionFunctionTrainingRadio().setEnabled(true);

        getTsuusyoKaigoAdditionFunctionTrainingRadioItem1().setEnabled(true);

        getTsuusyoKaigoAdditionFunctionTrainingRadioItem2().setEnabled(false);

  }

  /**
   * 「個別機能訓練I・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_FUNCTION_TRAINING1() throws Exception {

        getTsuusyoKaigoAdditionFunctionTrainingRadio().setEnabled(false);

        getTsuusyoKaigoAdditionFunctionTrainingRadioItem1().setEnabled(false);

        getTsuusyoKaigoAdditionFunctionTrainingRadioItem2().setEnabled(false);

  }

}
