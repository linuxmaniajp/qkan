
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
 * 作成日: 2009/12/10  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 実績データ作成 (P)
 * プロセス 確認・修正 (005)
 * プログラム 明細書詳細編集 (QP005)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp005;
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
 * 明細書詳細編集状態定義(QP005) 
 */
public class QP005State extends QP005Design {
  /**
   * コンストラクタです。
   */
  public QP005State(){
  }

  /**
   * 「状態コントロール1」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_TYPE1() throws Exception {

        getParticularInfos().setEnabled(false);

        getNyushoInfos().setEnabled(false);

        getDetailsInfoTable().setVisible(true);

        getKyotakuDetailsInfoTable().setVisible(false);

        getParticularInfoTable().setVisible(true);

        getSpecialClinicInfoTable().setVisible(false);

  }

  /**
   * 「状態コントロール2」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_TYPE2() throws Exception {

        getParticularInfos().setEnabled(false);

        getDetailsInfoTable().setVisible(true);

        getKyotakuDetailsInfoTable().setVisible(false);

        getParticularInfoTable().setVisible(true);

        getSpecialClinicInfoTable().setVisible(false);

  }

  /**
   * 「状態コントロール3」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_TYPE3() throws Exception {

        getShahukuInfos().setEnabled(false);

        getDetailsInfoTable().setVisible(true);

        getKyotakuDetailsInfoTable().setVisible(false);

        getParticularInfoTable().setVisible(true);

        getSpecialClinicInfoTable().setVisible(false);

  }

  /**
   * 「状態コントロール4」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_TYPE4() throws Exception {

        getShahukuInfos().setVisible(false);

        getDetailsInfoTable().setVisible(true);

        getKyotakuDetailsInfoTable().setVisible(false);

        getParticularInfoTable().setVisible(false);

        getSpecialClinicInfoTable().setVisible(true);

  }

  /**
   * 「状態コントロール5」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_TYPE5() throws Exception {

        getParticularInfos().setEnabled(false);

        getNyushoInfos().setEnabled(false);

        getShahukuInfos().setEnabled(false);

        getDetailsInfoTable().setVisible(true);

        getKyotakuDetailsInfoTable().setVisible(false);

        getParticularInfoTable().setVisible(true);

        getSpecialClinicInfoTable().setVisible(false);

  }

  /**
   * 「状態コントロール6」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_TYPE6() throws Exception {

        getBasicInfos().setEnabled(false);

        getParticularInfos().setEnabled(false);

        getTotalInfos().setEnabled(false);

        getNyushoInfos().setEnabled(false);

        getShahukuInfos().setEnabled(false);

        getDetailsInfoTable().setVisible(false);

        getKyotakuDetailsInfoTable().setVisible(true);

        getParticularInfoTable().setVisible(true);

        getSpecialClinicInfoTable().setVisible(false);

  }

  /**
   * 「状態コントロール7」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_TYPE7() throws Exception {

        getServiceDelButton().setEnabled(true);

  }

  /**
   * 「状態コントロール8」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_TYPE8() throws Exception {

        getServiceDelButton().setEnabled(false);

  }

  /**
   * 「状態コントロール9」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_TYPE9() throws Exception {

        getServiceDelButton().setEnabled(false);

        getServiceAddButton().setEnabled(false);

  }

  /**
   * 「状態コントロール10」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_TYPE10() throws Exception {

        getDetailsDelButton().setEnabled(true);

  }

  /**
   * 「状態コントロール11」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_TYPE11() throws Exception {

        getDetailsDelButton().setEnabled(false);

  }

}
