
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
 * 作成日: 2006/09/06  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 訪問看護療養費領収書編集 (012)
 * プログラム 訪問看護療養費領収書 (QP012P01)
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
import jp.or.med.orca.qkan.text.*;
import jp.nichicom.ac.lib.care.claim.print.schedule.*;

/**
 * 訪問看護療養費領収書イベント定義(QP012P01) 
 * 帳票定義体ファイル名 ： QP012P01.xml
 */
public abstract class QP012P01Event  {
  /**
   * コンストラクタです。
   */
  public QP012P01Event(){
  }
  /**
   * 印刷します。
   * @param writer 印刷管理クラス
   * @param printParam 印刷パラメタ
   * @throws Exception 処理例外
   */
  public abstract boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam) throws Exception;

  //変数定義

  public static final String NO_MARK = "";
  public static final String CIRCLE = "○";
  public static final String TRIANGLE = "△";
  public static final String DOUBLE_CIRCLE = "◎";
  public static final String RHOMBUS = "◇";
  public static final String[] CALC_INSURER = new String[] {"BY_INSURER_NAME11","BY_INSURER_NAME12","BY_INSURER_NAME13","BY_INSURER_NAME14","BY_INSURER_NAME15","BY_INSURER_NAME16","BY_INSURER_NAME17","BY_INSURER_NAME18","BY_INSURER_NAME19","BY_INSURER_NAME20"};
  public static final String[] CALC_PATIENT_INSURER = new String[] {"BY_PATIENT_NAME11","BY_PATIENT_NAME12","BY_PATIENT_NAME13","BY_PATIENT_NAME14","BY_PATIENT_NAME15","BY_PATIENT_NAME16","BY_PATIENT_NAME17","BY_PATIENT_NAME18","BY_PATIENT_NAME19","BY_PATIENT_NAME20"};
  //getter/setter

  //内部関数

  /**
   * 「印刷用にデータを変換します。」に関する処理を行ないます。
   *
   * @param printParam VRMap
   * @param key String
   * @throws Exception 処理例外
   *
   */
  public abstract void convertCalenderData(VRMap printParam, String key) throws Exception;

  /**
   * 「税の内・外を変換します」に関する処理を行ないます。
   *
   * @param printParam VRMap
   * @param key String
   * @throws Exception 処理例外
   *
   */
  public abstract void convertTax(VRMap printParam, String key) throws Exception;

  /**
   * 「ページ数計算」に関する処理を行ないます。
   *
   * @param printParam VRMap
   * @throws Exception 処理例外
   *
   */
  public abstract void pageCalc(VRMap printParam) throws Exception;

}
