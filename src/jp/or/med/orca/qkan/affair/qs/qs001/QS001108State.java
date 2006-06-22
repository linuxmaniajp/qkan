
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
 * 作成日: 2006/03/19  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービスパターン通所リハ (001)
 * プログラム サービスパターン通所リハ (QS001108)
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
 * サービスパターン通所リハ状態定義(QS001108) 
 */
public class QS001108State extends QS001108Design {
  /**
   * コンストラクタです。
   */
  public QS001108State(){
  }

  /**
   * 「入浴加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_ADD_BATH() throws Exception {

        getHoumonRehabilitationBathRadio().setEnabled(true);

  }

  /**
   * 「入浴加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_ADD_BATH() throws Exception {

        getHoumonRehabilitationBathRadio().setEnabled(false);

  }

  /**
   * 「リハビリ・マネジメント加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_REHABILITATION_MANAGEMENT_ADD() throws Exception {

        getHoumonRehabilitationManagementAddRadio().setEnabled(true);

  }

  /**
   * 「リハビリ・マネジメント加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_REHABILITATION_MANAGEMENT_ADD() throws Exception {

        getHoumonRehabilitationManagementAddRadio().setEnabled(false);

  }

  /**
   * 「栄養マネジメント加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_NOURISHMENT_MANAGEMENT() throws Exception {

        getHoumonRehabilitationNourishmentManagementAddRadio().setEnabled(true);

  }

  /**
   * 「栄養マネジメント加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_NOURISHMENT_MANAGEMENT() throws Exception {

        getHoumonRehabilitationNourishmentManagementAddRadio().setEnabled(false);

  }

  /**
   * 「口腔機能向上加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_MOUTH_FUNCTION() throws Exception {

        getHoumonRehabilitationMouthFunctionAddRadio().setEnabled(true);

  }

  /**
   * 「口腔機能向上加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_MOUTH_FUNCTION() throws Exception {

        getHoumonRehabilitationMouthFunctionAddRadio().setEnabled(false);

  }

  /**
   * 「通所リハビリ訪問指導等加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_ADD_CORCHING() throws Exception {

        getHoumonRehabilitationAdditionTreatmentPersonRadio().setEnabled(true);

  }

  /**
   * 「通所リハビリ訪問指導等加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_ADD_CORCHING() throws Exception {

        getHoumonRehabilitationAdditionTreatmentPersonRadio().setEnabled(false);

  }

}
