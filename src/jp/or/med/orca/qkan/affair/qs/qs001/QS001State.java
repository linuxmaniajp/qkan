
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
 * 作成日: 2006/03/29  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービス予定 (QS001)
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
 * サービス予定状態定義(QS001) 
 */
public class QS001State extends QS001Design {
  /**
   * コンストラクタです。
   */
  public QS001State(){
  }

  /**
   * 「更新モード」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_PROCESS_MODE_INSERT() throws Exception {

        getInsert().setVisible(true);

        getUpdate().setVisible(false);

  }

  /**
   * 「登録モード」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_PROCESS_MODE_UPDATE() throws Exception {

        getInsert().setVisible(false);

        getUpdate().setVisible(true);

  }

  /**
   * 「週間サービス計画票印刷」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_PRINT_WEEKLY() throws Exception {

        getPrintWeekly().setVisible(true);

        getPrintMonthly().setVisible(false);

        getOpenPlan().setEnabled(true);

  }

  /**
   * 「利用票・提供票印刷」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_PRINT_MONTHLY() throws Exception {

        getPrintWeekly().setVisible(false);

        getPrintMonthly().setVisible(true);

        getOpenPlan().setEnabled(false);

  }

  /**
   * 「サービスパターン選択」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SERVICE_PATTERN_SELECTED() throws Exception {

        getPatternDelete().setEnabled(true);

        getServiceDelete().setEnabled(false);

  }

  /**
   * 「サービスパターン未選択」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SERVICE_PATTERN_UNSELECTED() throws Exception {

        getPatternDelete().setEnabled(false);

  }

  /**
   * 「予定モード」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_AFFIR_MODE_PLAN() throws Exception {

        getClearPlan().setVisible(true);

        getOpenPlan().setVisible(true);

        getClearResult().setVisible(false);

        getOpenResult().setVisible(false);

  }

  /**
   * 「実績モード」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_AFFIR_MODE_RESULT() throws Exception {

        getPrintWeekly().setVisible(false);

        getClearPlan().setVisible(false);

        getOpenPlan().setVisible(false);

        getClearResult().setVisible(true);

        getOpenResult().setVisible(true);

  }

  /**
   * 「事業所情報使用サービス」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_USE_PROVIDER_SERVICE() throws Exception {

        getServiceOfferEntrepreneur().setEnabled(true);

  }

  /**
   * 「事業所情報未使用サービス」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_NOT_USE_PROVIDER_SERVICE() throws Exception {

        getServiceOfferEntrepreneur().setEnabled(false);

  }

  /**
   * 「サービス選択中」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SERVICE_SELECTED() throws Exception {

        getServiceSet().setEnabled(true);

        getServiceDelete().setEnabled(true);

  }

  /**
   * 「サービス未選択中」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SERVICE_UNSELECTED() throws Exception {

        getServiceSet().setEnabled(false);

        getServiceDelete().setEnabled(false);

  }

  /**
   * 「自事業所居宅介護支援未提供」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_NOT_PROVIDE_CARE_MANAGEMENT() throws Exception {

        getOpenResult().setVisible(false);

  }

  /**
   * 「自事業所居宅介護支援提供」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_PROVIDE_CARE_MANAGEMENT() throws Exception {

        getOpenResult().setVisible(true);

  }

}
