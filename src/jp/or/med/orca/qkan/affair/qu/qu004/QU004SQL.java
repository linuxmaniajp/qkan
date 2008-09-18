
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
 * 開発者: 公費・社福軽減情報
 * 作成日: 2007/04/05  日本コンピューター株式会社 公費・社福軽減情報 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 利用者管理 (U)
 * プロセス 公費・社福軽減情報 (004)
 * プログラム 公費・社福軽減情報 (QU004)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu004;
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
 * 公費・社福軽減情報SQL定義(QU004) 
 */
public class QU004SQL extends QU004State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * コンストラクタです。
   */
  public QU004SQL() {
  }

  /**
   * 「公費サービスマスタ情報を取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_MASTER_KOHI_SERVICE(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" DISTINCT");

    sb.append(" KOHI_TYPE");

    sb.append(",SYSTEM_SERVICE_KIND_DETAIL");

    sb.append(" FROM");

    sb.append(" M_KOHI_SERVICE");

    return sb.toString();
  }

  /**
   * 「利用者公費情報を取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_PATIENT_KOHI(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT_ID");

    sb.append(",KOHI_ID");

    sb.append(",INSURE_TYPE");

    sb.append(",KOHI_TYPE");

    sb.append(",BENEFIT_RATE");

    sb.append(",KOHI_LAW_NO");

    sb.append(",INSURER_ID");

    sb.append(",KOHI_RECIPIENT_NO");

    sb.append(",KOHI_VALID_START");

    sb.append(",KOHI_VALID_END");

    sb.append(",SELF_PAY");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" PATIENT_KOHI");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" KOHI_VALID_START");

    sb.append(" DESC");

    return sb.toString();
  }

  /**
   * 「利用者公費サービス情報を取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_PATIENT_KOHI_SERVICE(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT_ID");

    sb.append(",KOHI_ID");

    sb.append(",SYSTEM_SERVICE_KIND_DETAIL");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" PATIENT_KOHI_SERVICE");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「該当利用者の公費情報を全件削除」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_DELETE_PATIENT_KOHI(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("DELETE FROM");

    sb.append(" PATIENT_KOHI");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「利用者の公費情報を登録」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_INSERT_PATIENT_KOHI(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("INSERT INTO");

    sb.append(" PATIENT_KOHI");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(",KOHI_ID");

    sb.append(",INSURE_TYPE");

    sb.append(",KOHI_TYPE");

    sb.append(",BENEFIT_RATE");

    sb.append(",KOHI_LAW_NO");

    sb.append(",INSURER_ID");

    sb.append(",KOHI_RECIPIENT_NO");

    sb.append(",KOHI_VALID_START");

    sb.append(",KOHI_VALID_END");

    sb.append(",SELF_PAY");

    sb.append(",LAST_TIME");

    sb.append(")VALUES(");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("KOHI_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("INSURE_TYPE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("KOHI_TYPE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BENEFIT_RATE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("KOHI_LAW_NO", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("KOHI_RECIPIENT_NO", sqlParam)));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("KOHI_VALID_START", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("KOHI_VALID_END", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SELF_PAY", sqlParam)));

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「該当利用者公費サービス情報を全件削除」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_DELETE_PATIENT_KOHI_SERVICE(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("DELETE FROM");

    sb.append(" PATIENT_KOHI_SERVICE");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「利用者公費サービス情報を登録」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_INSERT_PATIENT_KOHI_SERVICE(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("INSERT INTO");

    sb.append(" PATIENT_KOHI_SERVICE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(",KOHI_ID");

    sb.append(",SYSTEM_SERVICE_KIND_DETAIL");

    sb.append(",LAST_TIME");

    sb.append(")VALUES(");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("KOHI_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL", sqlParam)));

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「公費マスタ情報を取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_MASTER_KOHI(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" KOHI_TYPE");

    sb.append(",KOHI_LAW_NO");

    sb.append(",KOHI_NAME");

    sb.append(",KOHI_ABBREVIATION");

    sb.append(",BENEFIT_RATE");

    sb.append(",CITY_CLAIM_FLAG");

    sb.append(",INSURE_TYPE");

    sb.append(",KOHI_SORT");

    sb.append(",LAST_TIME");

    sb.append(",KOHI_VALID_START");

    sb.append(",KOHI_VALID_END");

    sb.append(" FROM");

    sb.append(" M_KOHI");

    sb.append(" ORDER BY");

    sb.append(" KOHI_SORT");

    sb.append(" ");

    return sb.toString();
  }

  /**
   * 「利用者TBLの最終更新日時の更新」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_UPDATE_PATIENT_LAST_TIME(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" PATIENT");

    sb.append(" SET");

    sb.append(" LAST_TIME");

    sb.append(" =");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

}
