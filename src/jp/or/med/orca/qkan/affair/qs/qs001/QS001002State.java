
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
 * 作成日: 2006/05/15  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム 月間表 (QS001002)
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
 * 月間表状態定義(QS001002) 
 */
public class QS001002State extends QS001002Design {
  /**
   * コンストラクタです。
   */
  public QS001002State(){
  }

  /**
   * 「サービス選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SERVICE_SELECTED() throws Exception {

        getCoordinatePrivateExpenses().setEnabled(true);

  }

  /**
   * 「サービス未選択時」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SERVICE_UNSELECTED() throws Exception {

        getCoordinatePrivateExpenses().setEnabled(false);

  }

  /**
   * 「初期状態」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INIT_STATE() throws Exception {

        getLimit().setEditable(false);

        getLimitAmount().setEditable(false);

        getAfterAdjustment().setEditable(false);

        getAdjustment().setEditable(false);

  }

  /**
   * 「サービス予定」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SERVICE_PLAN() throws Exception {

        getOver().getParent().setVisible(true);

        getAfterAdjustment().getParent().setVisible(true);

        getAdjustment().getParent().setVisible(true);

        getCoordinatePrivateExpenses().setVisible(true);

        getAddInfomations().setVisible(false);

  }

  /**
   * 「サービス実績」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SERVICE_RESULT() throws Exception {

        getOver().getParent().setVisible(false);

        getAfterAdjustment().getParent().setVisible(false);

        getAdjustment().getParent().setVisible(false);

        getCoordinatePrivateExpenses().setVisible(false);

        getAddInfomations().setVisible(true);

  }

}
