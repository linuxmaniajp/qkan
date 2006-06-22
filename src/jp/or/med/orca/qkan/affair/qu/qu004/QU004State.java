
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
 * 開発者: 上司　和善
 * 作成日: 2006/03/03  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 利用者管理 (U)
 * プロセス 公費・減免情報 (004)
 * プログラム 公費・減免情報 (QU004)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu004;
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
import jp.or.med.orca.qkan.lib.*;
/**
 * 公費・減免情報状態定義(QU004) 
 */
public class QU004State extends QU004Design {
  /**
   * コンストラクタです。
   */
  public QU004State(){
  }

  /**
   * 「介護公費編集不可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_KAIGO_BUTTON_FALSE() throws Exception {

        getKaigoInfoButtonConpile().setEnabled(false);

        getKaigoInfoButtonDelete().setEnabled(false);

  }

  /**
   * 「介護公費編集可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_KAIGO_BUTTON_TRUE() throws Exception {

        getKaigoInfoButtonConpile().setEnabled(true);

        getKaigoInfoButtonDelete().setEnabled(true);

  }

  /**
   * 「医療公費編集不可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_IRYO_BUTTON_FALSE() throws Exception {

        getIryoInfoButtonConpile().setEnabled(false);

        getIryoInfoButtonDelete().setEnabled(false);

  }

  /**
   * 「医療公費編集可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_IRYO_BUTTON_TRUE() throws Exception {

        getIryoInfoButtonConpile().setEnabled(true);

        getIryoInfoButtonDelete().setEnabled(true);

  }

  /**
   * 「業務ボタン設定（登録モードへ変更）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INSERT_MODE() throws Exception {

        getInsert().setVisible(true);

        getUpdate().setVisible(false);

  }

  /**
   * 「業務ボタン設定（更新モードへ変更）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_UPDATE_MODE() throws Exception {

        getInsert().setVisible(false);

        getUpdate().setVisible(true);

  }

  /**
   * 「給付率編集不可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_EDITABLE_BENEFIT_RATE_FALSE() throws Exception {

  }

  /**
   * 「給付率編集可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_EDITABLE_BENEFIT_RATE_TRUE() throws Exception {

  }

  /**
   * 「社会福祉減免編集不可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_SHAHUKU_BUTTON_FALSE() throws Exception {

        getShahukuInfoButtonConpile().setEnabled(false);

        getShahukuInfoButtonDelete().setEnabled(false);

  }

  /**
   * 「社会福祉減免編集可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_SHAHUKU_BUTTON_TRUE() throws Exception {

        getShahukuInfoButtonConpile().setEnabled(true);

        getShahukuInfoButtonDelete().setEnabled(true);

  }

}
