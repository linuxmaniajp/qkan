
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
 * 開発者: 
 * 作成日: 2016/09/16  日本コンピューター株式会社  新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 総合事業サービスコード管理 (017)
 * プログラム 総合事業サービスコード登録 (QO017)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo017;
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
 * 総合事業サービスコード登録状態定義(QO017) 
 */
public class QO017State extends QO017Design {
  /**
   * コンストラクタです。
   */
  public QO017State(){
  }

  /**
   * 「初期設定」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INIT_STATE() throws Exception {

        getInsert().setVisible(true);

        getUpdate().setVisible(false);

        getNewData().setVisible(false);

        getClear().setVisible(true);

        getInsurerIdText().setEditable(true);

        getInsurerIdCombo().setEnabled(true);

        getServiceCodeKindCombo().setVisible(true);

        getServeceCodeKindNameText().setVisible(false);

        getServiceCodeItemText().setEditable(true);

        getTekiyoKikanSt().setEditable(true);

  }

  /**
   * 「登録モード」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INSERT_STATE() throws Exception {

        getInsert().setVisible(true);

        getUpdate().setVisible(false);

        getNewData().setVisible(false);

        getClear().setVisible(true);

        getInsurerIdText().setEditable(true);

        getInsurerIdCombo().setEnabled(true);

        getServiceCodeKindCombo().setVisible(true);

        getServeceCodeKindNameText().setVisible(false);

        getServiceCodeItemText().setEditable(true);

        getTekiyoKikanSt().setEditable(true);

  }

  /**
   * 「更新モード」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_UPDATE_STATE() throws Exception {

        getInsert().setVisible(false);

        getUpdate().setVisible(true);

        getNewData().setVisible(true);

        getClear().setVisible(false);

        getInsurerIdText().setEditable(false);

        getInsurerIdCombo().setEnabled(false);

        getServiceCodeKindCombo().setVisible(false);

        getServeceCodeKindNameText().setVisible(true);

        getServiceCodeItemText().setEditable(false);

        getTekiyoKikanSt().setEditable(false);

  }

}
