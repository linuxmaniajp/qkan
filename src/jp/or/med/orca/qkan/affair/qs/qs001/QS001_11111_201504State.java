
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
 * 作成日: 2015/02/25  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン訪問介護 (QS001_11111_201504)
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
 * サービスパターン訪問介護状態定義(QS001_11111_201504) 
 */
public class QS001_11111_201504State extends QS001_11111_201504Design {
  /**
   * コンストラクタです。
   */
  public QS001_11111_201504State(){
  }

  /**
   * 「身体介護」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SHINTAI_KAIGO() throws Exception {

        getHomonkaigoTeikyoTime().setEnabled(true);
        getHomonkaigoTeikyoTime().getParent().setEnabled(true);

        getHoumonKaigoInTime().setEnabled(false);
        getHoumonKaigoInTime().getParent().setEnabled(false);

        getHoumonKaigoNumberOfPeople().setEnabled(true);
        getHoumonKaigoNumberOfPeople().getParent().setEnabled(true);

        getHoumonKaigoEmergencyAddRadioGroup().setEnabled(true);
        getHoumonKaigoEmergencyAddRadioGroup().getParent().setEnabled(true);

  }

  /**
   * 「生活援助」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SEIKATSU_ENJO() throws Exception {

        getHomonkaigoTeikyoTime().setEnabled(false);
        getHomonkaigoTeikyoTime().getParent().setEnabled(false);

        getHoumonKaigoInTime().setEnabled(true);
        getHoumonKaigoInTime().getParent().setEnabled(true);

        getHoumonKaigoNumberOfPeople().setEnabled(true);
        getHoumonKaigoNumberOfPeople().getParent().setEnabled(true);

        getHoumonKaigoEmergencyAddRadioGroup().setEnabled(false);
        getHoumonKaigoEmergencyAddRadioGroup().getParent().setEnabled(false);

  }

  /**
   * 「身体生活」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SHINTAI_SEIKATSU() throws Exception {

        getHomonkaigoTeikyoTime().setEnabled(true);
        getHomonkaigoTeikyoTime().getParent().setEnabled(true);

        getHoumonKaigoInTime().setEnabled(true);
        getHoumonKaigoInTime().getParent().setEnabled(true);

        getHoumonKaigoNumberOfPeople().setEnabled(true);
        getHoumonKaigoNumberOfPeople().getParent().setEnabled(true);

        getHoumonKaigoEmergencyAddRadioGroup().setEnabled(true);
        getHoumonKaigoEmergencyAddRadioGroup().getParent().setEnabled(true);

  }

  /**
   * 「通院等乗降介助」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_JOKOKAIJO() throws Exception {

        getHomonkaigoTeikyoTime().setEnabled(false);
        getHomonkaigoTeikyoTime().getParent().setEnabled(false);

        getHoumonKaigoInTime().setEnabled(false);
        getHoumonKaigoInTime().getParent().setEnabled(false);

        getHoumonKaigoNumberOfPeople().setEnabled(false);
        getHoumonKaigoNumberOfPeople().getParent().setEnabled(false);

        getHoumonKaigoEmergencyAddRadioGroup().setEnabled(false);
        getHoumonKaigoEmergencyAddRadioGroup().getParent().setEnabled(false);

  }

  /**
   * 「2級サービス提供責任者・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_CLASS2_VALID() throws Exception {

        getHoumonKaigoClass().setEnabled(true);
        getHoumonKaigoClass().getParent().setEnabled(true);

  }

  /**
   * 「2級サービス提供責任者・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_CLASS2_INVALID() throws Exception {

        getHoumonKaigoClass().setEnabled(false);
        getHoumonKaigoClass().getParent().setEnabled(false);

  }

  /**
   * 「頻回の訪問として行う・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_MORE_TIMES_CHECK_VALID() throws Exception {

        getHoumonKaigoMoreTimesCheck().setEnabled(true);

  }

  /**
   * 「頻回の訪問として行う・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_MORE_TIMES_CHECK_INVALID() throws Exception {

        getHoumonKaigoMoreTimesCheck().setEnabled(false);

  }

}
