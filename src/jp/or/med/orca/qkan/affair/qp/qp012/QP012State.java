
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
 * 作成日: 2006/08/22  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 訪問看護療養費領収書編集 (012)
 * プログラム 訪問看護療養費領収書編集 (QP012)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp012;
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
 * 訪問看護療養費領収書編集状態定義(QP012) 
 */
public class QP012State extends QP012Design {
  /**
   * コンストラクタです。
   */
  public QP012State(){
  }

  /**
   * 「登録モード」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INSERT_MODE() throws Exception {

        getInsert().setVisible(true);

        getUpdate().setVisible(false);

  }

  /**
   * 「更新モード」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_UPDATE_MODE() throws Exception {

        getInsert().setVisible(false);

        getUpdate().setVisible(true);

  }

  /**
   * 「最大提供日28日」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_MAX_DAY_28() throws Exception {

        getProvideDay29().setVisible(false);

        getProvideDay30().setVisible(false);

        getProvideDay31().setVisible(false);

  }

  /**
   * 「最大提供日29日」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_MAX_DAY_29() throws Exception {

        getProvideDay29().setVisible(true);

        getProvideDay30().setVisible(false);

        getProvideDay31().setVisible(false);

  }

  /**
   * 「最大提供日30日」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_MAX_DAY_30() throws Exception {

        getProvideDay29().setVisible(true);

        getProvideDay30().setVisible(true);

        getProvideDay31().setVisible(false);

  }

  /**
   * 「最大提供日31日」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_MAX_DAY_31() throws Exception {

        getProvideDay29().setVisible(true);

        getProvideDay30().setVisible(true);

        getProvideDay31().setVisible(true);

  }

}
