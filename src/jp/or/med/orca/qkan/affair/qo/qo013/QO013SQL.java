
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
 * 開発者: 日医標準レセプトソフト連携
 * 作成日: 2006/10/25  日本コンピューター株式会社 日医標準レセプトソフト連携 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 日医標準レセプトソフト連携 (013)
 * プログラム 日医標準レセプトソフト連携 (QO013)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo013;
import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.text.*;
import java.io.*;
import java.sql.SQLException;
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
 * 日医標準レセプトソフト連携SQL定義(QO013) 
 */
public class QO013SQL extends QO013State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * コンストラクタです。
   */
  public QO013SQL() {
  }

  /**
   * 「患者情報取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_RECEPT_INFO(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" RECEIPT_ACCESS_SPACE.SERIAL_ID");

    sb.append(",RECEIPT_ACCESS_SPACE.PTID");

    sb.append(",RECEIPT_ACCESS_SPACE.NAME");

    sb.append(",RECEIPT_ACCESS_SPACE.KANANAME");

    sb.append(",RECEIPT_ACCESS_SPACE.SEX");

    sb.append(",RECEIPT_ACCESS_SPACE.BIRTHDAY");

    sb.append(",RECEIPT_ACCESS_SPACE.HOME_POST");

    sb.append(",RECEIPT_ACCESS_SPACE.HOME_ADRS");

    sb.append(",RECEIPT_ACCESS_SPACE.HOME_BANTI");

    sb.append(",RECEIPT_ACCESS_SPACE.HOME_TEL1");

    sb.append(" FROM");

    sb.append(" RECEIPT_ACCESS_SPACE");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" RECEIPT_ACCESS_SPACE.SERIAL_ID");

    sb.append(" >=");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SERIAL_ID_HOME", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" RECEIPT_ACCESS_SPACE.SERIAL_ID");

    sb.append(" <");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SERIAL_ID_END", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「利用者情報取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_PATIENT_INFO(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT_FAMILY_NAME");

    sb.append(",PATIENT_FIRST_NAME");

    sb.append(",PATIENT_BIRTHDAY");

    sb.append(" FROM");

    sb.append(" PATIENT");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" DELETE_FLAG");

    sb.append(" =");

    sb.append(" 0");

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「新利用者IDを取得する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_NEW_PATIENT_ID(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" MAX(PATIENT_ID) AS PATIENT_ID");

    sb.append(" FROM");

    sb.append(" PATIENT");

    return sb.toString();
  }

  /**
   * 「利用者基本情報登録」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_INSERT_PATIENT(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("INSERT INTO");

    sb.append(" PATIENT");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(",PATIENT_CODE");

    sb.append(",PATIENT_FAMILY_NAME");

    sb.append(",PATIENT_FIRST_NAME");

    sb.append(",PATIENT_FAMILY_KANA");

    sb.append(",PATIENT_FIRST_KANA");

    sb.append(",PATIENT_SEX");

    sb.append(",PATIENT_BIRTHDAY");

    sb.append(",PATIENT_TEL_FIRST");

    sb.append(",PATIENT_TEL_SECOND");

    sb.append(",PATIENT_TEL_THIRD");

    sb.append(",PATIENT_ZIP_FIRST");

    sb.append(",PATIENT_ZIP_SECOND");

    sb.append(",PATIENT_ADDRESS");

    sb.append(",SHOW_FLAG");

    sb.append(",DELETE_FLAG");

    sb.append(",LAST_TIME");

    sb.append(")VALUES(");

    sb.append(" (");

    sb.append("SELECT");

    sb.append(" CASE");

    sb.append(" WHEN");

    sb.append(" MAX(PATIENT_ID)  IS NULL THEN 1");

    sb.append(" ELSE");

    sb.append(" MAX(PATIENT_ID) +1");

    sb.append(" END");

    sb.append(" FROM");

    sb.append(" PATIENT");

    sb.append(")");

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_CODE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_FAMILY_NAME", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_FIRST_NAME", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_FAMILY_KANA", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_FIRST_KANA", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_SEX", sqlParam)));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("PATIENT_BIRTHDAY", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_TEL_FIRST", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_TEL_SECOND", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_TEL_THIRD", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_ZIP_FIRST", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_ZIP_SECOND", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_ADDRESS", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SHOW_FLAG", sqlParam)));

    sb.append(",");

    sb.append(" 0");

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(")");

    return sb.toString();
  }

}
