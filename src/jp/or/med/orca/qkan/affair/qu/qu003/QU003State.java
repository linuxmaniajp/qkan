
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
 * 作成日: 2006/04/16  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 利用者管理 (U)
 * プロセス 医療看護情報 (003)
 * プログラム 医療看護情報 (QU003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu003;
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
 * 医療看護情報状態定義(QU003) 
 */
public class QU003State extends QU003Design {
  /**
   * コンストラクタです。
   */
  public QU003State(){
  }

  /**
   * 「老人医療給付率制御不可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_OLD_RADIO_FALSE() throws Exception {

        getMedicalInfoOld9AndOld8Radio().setEnabled(false);

  }

  /**
   * 「老人医療給付率制御可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_OLD_RADIO_TRUE() throws Exception {

        getMedicalInfoOld9AndOld8Radio().setEnabled(true);

  }

  /**
   * 「医療履歴編集不可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_MEDICAL_BUTTON_FALSE() throws Exception {

        getMedicalInfoButtonConpile().setEnabled(false);

        getMedicalInfoButtonDelete().setEnabled(false);

  }

  /**
   * 「医療履歴編集可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ENABLE_MEDICAL_BUTTON_TRUE() throws Exception {

        getMedicalInfoButtonConpile().setEnabled(true);

        getMedicalInfoButtonDelete().setEnabled(true);

  }

  /**
   * 「業務ボタン状態設定（登録モードへ変更）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INSERT_MODE() throws Exception {

        getInsert().setVisible(true);

        getUpdate().setVisible(false);

  }

  /**
   * 「業務ボタン状態設定（更新モードへ変更）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_UPDATE_MODE() throws Exception {

        getInsert().setVisible(false);

        getUpdate().setVisible(true);

  }

  /**
   * 「ノーマル」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_NOT_ONLY_KOHI() throws Exception {

        getMedicalInfoInsurerNoContena().setEnabled(true);

        getMedicalInfoInsurerName().getParent().setEnabled(true);

        getMedicalInfoMark().getParent().setEnabled(true);

        getMedicalInfoProvideContena().setEnabled(true);

        getMedicalInfoCitiesNoContena().setEnabled(true);

        getMedicalInfoCitiesName().getParent().setEnabled(true);

        getMedicalInfoOldPersonReceiptNo().getParent().setEnabled(true);

  }

  /**
   * 「公費単独」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_ONLY_KOHI() throws Exception {

        getMedicalInfoInsurerNoContena().setEnabled(false);

        getMedicalInfoInsurerName().getParent().setEnabled(false);

        getMedicalInfoMark().getParent().setEnabled(false);

        getMedicalInfoProvideContena().setEnabled(false);

        getMedicalInfoCitiesNoContena().setEnabled(false);

        getMedicalInfoCitiesName().getParent().setEnabled(false);

        getMedicalInfoOldPersonReceiptNo().getParent().setEnabled(false);

  }

}
