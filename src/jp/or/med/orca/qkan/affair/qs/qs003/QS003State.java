
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
 * 作成日: 2005/12/22  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス 利用・提供票印刷 (003)
 * プログラム 利用・提供票印刷 (QS003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs003;
import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.event.*;
import jp.nichicom.ac.component.mainmenu.*;
import jp.nichicom.ac.component.table.*;
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
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
import jp.or.med.orca.qkan.lib.*;
/**
 * 利用・提供票印刷状態定義(QS003) 
 */
public class QS003State extends QS003Design {
  /**
   * コンストラクタです。
   */
  public QS003State(){
  }

  /**
   * 「作成者・事業所」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_PROVIDER_MADE() throws Exception {

        getSupportProviderCd().setEnabled(true);

        getSupportProviderName().setEnabled(true);

        getPersonInCharge().setEnabled(true);

        getDateOfWrittenReport().setEnabled(true);

  }

  /**
   * 「作成者・被保険者」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_SELF_MADE() throws Exception {

        getSupportProviderCd().setEnabled(false);

        getSupportProviderName().setEnabled(false);

        getPersonInCharge().setEnabled(false);

        getDateOfWrittenReport().setEnabled(false);

  }

  /**
   * 「予定印刷」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_PROCESS_TYPE_PLAN() throws Exception {

        getPublicExpense().setVisible(true);

        getSlitKinds().setVisible(true);

  }

  /**
   * 「実績印刷」の状態に設定します。
   * @throws Exception 処理例外
   */
  protected void setState_PROCESS_TYPE_RESULT() throws Exception {

        getPublicExpense().setVisible(false);

        getSlitKinds().setVisible(false);

  }

}
