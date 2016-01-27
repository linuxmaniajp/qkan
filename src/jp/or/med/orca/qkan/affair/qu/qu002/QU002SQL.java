
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
 * 開発者: 利用者登録
 * 作成日: 2015/04/15  日本コンピューター株式会社 利用者登録 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 利用者管理 (U)
 * プロセス 利用者登録 (002)
 * プログラム 利用者登録 (QU002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu002;
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
 * 利用者登録SQL定義(QU002) 
 */
public class QU002SQL extends QU002State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * コンストラクタです。
   */
  public QU002SQL() {
  }

  /**
   * 「利用者介護保険情報取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_PATIENT_KAIGO(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT_ID");

    sb.append(",NINTEI_HISTORY_ID");

    sb.append(",INSURER_ID");

    sb.append(",INSURED_ID");

    sb.append(",INSURE_RATE");

    sb.append(",PLANNER");

    sb.append(",PROVIDER_ID");

    sb.append(",SHUBETSU_CODE");

    sb.append(",CHANGE_CODE");

    sb.append(",JOTAI_CODE");

    sb.append(",SHINSEI_DATE");

    sb.append(",NINTEI_DATE");

    sb.append(",INSURE_VALID_START");

    sb.append(",INSURE_VALID_END");

    sb.append(",STOP_DATE");

    sb.append(",STOP_REASON");

    sb.append(",REPORTED_DATE");

    sb.append(",LIMIT_RATE");

    sb.append(",EXTERNAL_USE_LIMIT");

    sb.append(",LAST_TIME");

    sb.append(",SYSTEM_INSURE_VALID_START");

    sb.append(",SYSTEM_INSURE_VALID_END");

    sb.append(",JIGYOTAISYO_FLAG");

    sb.append(",SHORTSTAY_USE_INIT_COUNT");

    sb.append(" FROM");

    sb.append(" PATIENT_NINTEI_HISTORY");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" SYSTEM_INSURE_VALID_START");

    sb.append(" DESC");

    return sb.toString();
  }

  /**
   * 「利用者異動情報取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_PATIENT_CHANGES(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT_ID");

    sb.append(",CHANGES_HISTORY_ID");

    sb.append(",SYSTEM_SERVICE_KIND_DETAIL");

    sb.append(",CHANGES_CONTENT");

    sb.append(",CHANGES_DATE");

    sb.append(",CHANGES_TIME");

    sb.append(",CHANGES_REASON");

    sb.append(",REASON_MEMO");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" PATIENT_CHANGES_HISTORY");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" CHANGES_DATE");

    sb.append(" DESC");

    return sb.toString();
  }

  /**
   * 「利用者施設情報取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_PATIENT_SHISETSU(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT_ID");

    sb.append(",SHISETSU_HISTORY_ID");

    sb.append(",TOKUTEI_NYUSHO_FLAG");

    sb.append(",LIMIT_SHOKUHI");

    sb.append(",LIMIT_UNIT_KOSHITSU");

    sb.append(",LIMIT_UNIT_JUNKOSHITSU");

    sb.append(",LIMIT_JURAIGATA1");

    sb.append(",LIMIT_JURAIGATA2");

    sb.append(",LIMIT_TASHOSHITSU");

    sb.append(",KYUSOCHI_FLAG");

    sb.append(",DISEASE");

    sb.append(",LAST_TIME");

    sb.append(",SHISETSU_VALID_START");

    sb.append(",SHISETSU_VALID_END");

    sb.append(" FROM");

    sb.append(" PATIENT_SHISETSU_HISTORY");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" SHISETSU_VALID_START");

    sb.append(" DESC");

    return sb.toString();
  }

  /**
   * 「利用者住所地特例情報取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_PATIENT_JUSHOTI_TOKUREI(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT_ID");

    sb.append(",JUSHOTI_HISTORY_ID");

    sb.append(",JUSHOTI_VALID_START");

    sb.append(",JUSHOTI_VALID_END");

    sb.append(",JUSHOTI_INSURER_ID");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" PATIENT_JUSHOTI_TOKUREI");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" JUSHOTI_VALID_START");

    sb.append(" DESC");

    return sb.toString();
  }

  /**
   * 「利用者基本情報登録」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_INSERT_PATIENT(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
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

  /**
   * 「利用者基本情報更新」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_UPDATE_PATIENT(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" PATIENT");

    sb.append(" SET");

    sb.append(" PATIENT_CODE");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_CODE", sqlParam)));

    sb.append(",");

    sb.append(" PATIENT_FAMILY_NAME");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_FAMILY_NAME", sqlParam)));

    sb.append(",");

    sb.append(" PATIENT_FIRST_NAME");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_FIRST_NAME", sqlParam)));

    sb.append(",");

    sb.append(" PATIENT_FAMILY_KANA");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_FAMILY_KANA", sqlParam)));

    sb.append(",");

    sb.append(" PATIENT_FIRST_KANA");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_FIRST_KANA", sqlParam)));

    sb.append(",");

    sb.append(" PATIENT_SEX");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_SEX", sqlParam)));

    sb.append(",");

    sb.append(" PATIENT_BIRTHDAY");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("PATIENT_BIRTHDAY", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(" PATIENT_TEL_FIRST");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_TEL_FIRST", sqlParam)));

    sb.append(",");

    sb.append(" PATIENT_TEL_SECOND");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_TEL_SECOND", sqlParam)));

    sb.append(",");

    sb.append(" PATIENT_TEL_THIRD");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_TEL_THIRD", sqlParam)));

    sb.append(",");

    sb.append(" PATIENT_ZIP_FIRST");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_ZIP_FIRST", sqlParam)));

    sb.append(",");

    sb.append(" PATIENT_ZIP_SECOND");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_ZIP_SECOND", sqlParam)));

    sb.append(",");

    sb.append(" PATIENT_ADDRESS");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_ADDRESS", sqlParam)));

    sb.append(",");

    sb.append(" SHOW_FLAG");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SHOW_FLAG", sqlParam)));

    sb.append(",");

    sb.append(" DELETE_FLAG");

    sb.append(" =");

    sb.append(" 0");

    sb.append(",");

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

  /**
   * 「異動履歴追加」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_INSERT_CHANGES_HISTORY(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("INSERT INTO");

    sb.append(" PATIENT_CHANGES_HISTORY");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(",CHANGES_HISTORY_ID");

    sb.append(",SYSTEM_SERVICE_KIND_DETAIL");

    sb.append(",CHANGES_CONTENT");

    sb.append(",CHANGES_DATE");

    sb.append(",CHANGES_TIME");

    sb.append(",CHANGES_REASON");

    sb.append(",REASON_MEMO");

    sb.append(",LAST_TIME");

    sb.append(")VALUES(");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CHANGES_HISTORY_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CHANGES_CONTENT", sqlParam)));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("CHANGES_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("CHANGES_TIME", sqlParam), "yyyy-MM-dd HH:mm:00"));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CHANGES_REASON", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("REASON_MEMO", sqlParam)));

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「要介護認定履歴追加」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_INSERT_NINTEI_HISTORY(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("INSERT INTO");

    sb.append(" PATIENT_NINTEI_HISTORY");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(",NINTEI_HISTORY_ID");

    sb.append(",INSURER_ID");

    sb.append(",INSURED_ID");

    sb.append(",INSURE_RATE");

    sb.append(",PLANNER");

    sb.append(",PROVIDER_ID");

    sb.append(",SHUBETSU_CODE");

    sb.append(",CHANGE_CODE");

    sb.append(",JOTAI_CODE");

    sb.append(",SHINSEI_DATE");

    sb.append(",NINTEI_DATE");

    sb.append(",INSURE_VALID_START");

    sb.append(",INSURE_VALID_END");

    sb.append(",STOP_DATE");

    sb.append(",STOP_REASON");

    sb.append(",REPORTED_DATE");

    sb.append(",LIMIT_RATE");

    sb.append(",EXTERNAL_USE_LIMIT");

    sb.append(",LAST_TIME");

    sb.append(",SYSTEM_INSURE_VALID_START");

    sb.append(",SYSTEM_INSURE_VALID_END");

    sb.append(",JIGYOTAISYO_FLAG");

    sb.append(",SHORTSTAY_USE_INIT_COUNT");

    sb.append(")VALUES(");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("NINTEI_HISTORY_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURED_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("INSURE_RATE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PLANNER", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SHUBETSU_CODE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CHANGE_CODE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("JOTAI_CODE", sqlParam)));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("SHINSEI_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("NINTEI_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("INSURE_VALID_START", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("INSURE_VALID_END", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("STOP_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("STOP_REASON", sqlParam)));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("REPORTED_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("LIMIT_RATE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("EXTERNAL_USE_LIMIT", sqlParam)));

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("SYSTEM_INSURE_VALID_START", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("SYSTEM_INSURE_VALID_END", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("JIGYOTAISYO_FLAG", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SHORTSTAY_USE_INIT_COUNT", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「施設履歴追加」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_INSERT_SHISETSU_HISTORY(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("INSERT INTO");

    sb.append(" PATIENT_SHISETSU_HISTORY");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(",SHISETSU_HISTORY_ID");

    sb.append(",TOKUTEI_NYUSHO_FLAG");

    sb.append(",LIMIT_SHOKUHI");

    sb.append(",LIMIT_UNIT_KOSHITSU");

    sb.append(",LIMIT_UNIT_JUNKOSHITSU");

    sb.append(",LIMIT_JURAIGATA1");

    sb.append(",LIMIT_JURAIGATA2");

    sb.append(",LIMIT_TASHOSHITSU");

    sb.append(",KYUSOCHI_FLAG");

    sb.append(",DISEASE");

    sb.append(",LAST_TIME");

    sb.append(",SHISETSU_VALID_START");

    sb.append(",SHISETSU_VALID_END");

    sb.append(")VALUES(");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SHISETSU_HISTORY_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("TOKUTEI_NYUSHO_FLAG", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("LIMIT_SHOKUHI", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("LIMIT_UNIT_KOSHITSU", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("LIMIT_UNIT_JUNKOSHITSU", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("LIMIT_JURAIGATA1", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("LIMIT_JURAIGATA2", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("LIMIT_TASHOSHITSU", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("KYUSOCHI_FLAG", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("DISEASE", sqlParam)));

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("SHISETSU_VALID_START", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("SHISETSU_VALID_END", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「住所地特例追加」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_INSERT_JUSHOTI_TOKUREI(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("INSERT INTO");

    sb.append(" PATIENT_JUSHOTI_TOKUREI");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(",JUSHOTI_HISTORY_ID");

    sb.append(",JUSHOTI_VALID_START");

    sb.append(",JUSHOTI_VALID_END");

    sb.append(",JUSHOTI_INSURER_ID");

    sb.append(",LAST_TIME");

    sb.append(")VALUES(");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("JUSHOTI_HISTORY_ID", sqlParam)));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("JUSHOTI_VALID_START", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("JUSHOTI_VALID_END", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("JUSHOTI_INSURER_ID", sqlParam)));

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「異動履歴削除」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_DELETE_CHANGES_HISTORY(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("DELETE FROM");

    sb.append(" PATIENT_CHANGES_HISTORY");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「要介護認定履歴削除」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_DELETE_NINTEI_HISTORY(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("DELETE FROM");

    sb.append(" PATIENT_NINTEI_HISTORY");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「施設履歴削除」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_DELETE_SHISETSU_HISTORY(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("DELETE FROM");

    sb.append(" PATIENT_SHISETSU_HISTORY");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「住所地特例削除」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_DELETE_JUSHOTI_TOKUREI(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("DELETE FROM");

    sb.append(" PATIENT_JUSHOTI_TOKUREI");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「利用者登録サービスを取得する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_PATIENT_RESERVED_SERVICE(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" SERVICE_ID");

    sb.append(" FROM");

    sb.append(" SERVICE");

    conditionStack.push(new Boolean(firstCondition));
    firstCondition = true;

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }

    sb.append("(");

    sb.append(" SERVICE_USE_TYPE");

    sb.append(" IN");

    sb.append(" (4,6)");

    sb.append(")");

    if(
      VRBindPathParser.has("VALID_START", sqlParam)
    ){

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }else{
        sb.append(" AND");

      }

    sb.append("(");

    sb.append(" SERVICE_DATE");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("VALID_START", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    }

    if(
      VRBindPathParser.has("VALID_END", sqlParam)
    ){

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }else{
        sb.append(" AND");

      }

    sb.append("(");

    sb.append(" SERVICE_DATE");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("VALID_END", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    }

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }else{
        sb.append(" AND");

      }

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    firstCondition = ((Boolean)conditionStack.pop()).booleanValue();

    return sb.toString();
  }

  /**
   * 「厚労省規定の支給限度額を取得する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_OFFICIAL_LIMIT_RATE(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" LIMIT_RATE_VALUE");

    sb.append(" FROM");

    sb.append(" M_LIMIT_RATE_DETAIL");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" M_LIMIT_RATE_DETAIL.JOTAI_CODE");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("JOTAI_CODE", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" M_LIMIT_RATE_DETAIL.LIMIT_RATE_TYPE");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("LIMIT_RATE_TYPE", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" M_LIMIT_RATE_DETAIL.LIMIT_RATE_HISTORY_ID");

    sb.append(" =");

    sb.append(" (");

    sb.append("SELECT");

    sb.append(" MAX(M_LIMIT_RATE.LIMIT_RATE_HISTORY_ID)");

    sb.append(" FROM");

    sb.append(" M_LIMIT_RATE");

    sb.append(" WHERE");

    sb.append("(");

    sb.append("(");

    sb.append(" M_LIMIT_RATE.LIMIT_RATE_TYPE");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("LIMIT_RATE_TYPE", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" M_LIMIT_RATE.LIMIT_RATE_VALID_START");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("VALID_START", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" M_LIMIT_RATE.LIMIT_RATE_VALID_END");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("VALID_END", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(")");

    sb.append("OR");

    sb.append("(");

    sb.append("(");

    sb.append(" M_LIMIT_RATE.LIMIT_RATE_TYPE");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("LIMIT_RATE_TYPE", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" M_LIMIT_RATE.LIMIT_RATE_VALID_START");

    sb.append(" >");

    sb.append(dateFormat.format(VRBindPathParser.get("VALID_START", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" M_LIMIT_RATE.LIMIT_RATE_VALID_START");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("VALID_END", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" M_LIMIT_RATE.LIMIT_RATE_VALID_END");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("VALID_END", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(")");

    sb.append(")");

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「保険者支給限度額を取得する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_INSURER_LIMIT_RATE(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" LIMIT_RATE_VALUE");

    sb.append(" FROM");

    sb.append(" INSURER_LIMIT_RATE_DETAIL");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" INSURER_LIMIT_RATE_DETAIL.INSURER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" INSURER_LIMIT_RATE_DETAIL.JOTAI_CODE");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("JOTAI_CODE", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" INSURER_LIMIT_RATE_DETAIL.LIMIT_RATE_HISTORY_ID");

    sb.append(" =");

    sb.append(" (");

    sb.append("SELECT");

    sb.append(" MAX(INSURER_LIMIT_RATE.LIMIT_RATE_HISTORY_ID)");

    sb.append(" FROM");

    sb.append(" INSURER_LIMIT_RATE");

    sb.append(" WHERE");

    sb.append("(");

    sb.append("(");

    sb.append(" INSURER_LIMIT_RATE.INSURER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" INSURER_LIMIT_RATE.LIMIT_RATE_VALID_START");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("VALID_START", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" INSURER_LIMIT_RATE.LIMIT_RATE_VALID_END");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("VALID_END", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(")");

    sb.append("OR");

    sb.append("(");

    sb.append("(");

    sb.append(" INSURER_LIMIT_RATE.INSURER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" INSURER_LIMIT_RATE.LIMIT_RATE_VALID_START");

    sb.append(" >");

    sb.append(dateFormat.format(VRBindPathParser.get("VALID_START", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" INSURER_LIMIT_RATE.LIMIT_RATE_VALID_START");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("VALID_END", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" INSURER_LIMIT_RATE.LIMIT_RATE_VALID_END");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("VALID_END", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(")");

    sb.append(")");

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
    StringBuilder sb = new StringBuilder();
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

}
