
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
 * 開発者: サービス予定
 * 作成日: 2009/07/24  日本コンピューター株式会社 サービス予定 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービス予定 (QS001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
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
 * サービス予定SQL定義(QS001) 
 */
public class QS001SQL extends QS001State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * コンストラクタです。
   */
  public QS001SQL() {
  }

  /**
   * 「週間表のみのサービスを除き、使用されている事業所提供サービスの一覧を取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_USED_PROVIDER_SERVICE_WITHOUT_WEEKLY_SERVICE(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" DISTINCT M_SERVICE.SYSTEM_SERVICE_KIND_DETAIL");

    sb.append(",M_SERVICE.SERVICE_CODE_KIND");

    sb.append(",M_SERVICE.SERVICE_NAME");

    sb.append(",M_SERVICE.SERVICE_ABBREVIATION");

    sb.append(",M_SERVICE.SERVICE_KIND_NAME");

    sb.append(",M_SERVICE.SERVICE_CALENDAR_ABBREVIATION");

    sb.append(",M_SERVICE.CLAIM_STYLE_TYPE");

    sb.append(",M_SERVICE.SERVICE_SORT");

    sb.append(",M_SERVICE.BUSINESS_TYPE");

    sb.append(",M_SERVICE.CALENDAR_PASTE_FLAG");

    sb.append(",M_SERVICE.SERVICE_VALID_START");

    sb.append(",M_SERVICE.SERVICE_VALID_END");

    sb.append(" FROM");

    sb.append(" M_SERVICE");

    sb.append(",PROVIDER_SERVICE");

    sb.append(" LEFT JOIN");

    sb.append(" PROVIDER");

    sb.append(" ON");

    sb.append("(");

    sb.append(" PROVIDER_SERVICE.PROVIDER_ID");

    sb.append(" =");

    sb.append(" PROVIDER.PROVIDER_ID");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" PROVIDER.DELETE_FLAG");

    sb.append(" =");

    sb.append(" 0");

    sb.append(")");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" M_SERVICE.SYSTEM_SERVICE_KIND_DETAIL");

    sb.append(" =");

    sb.append(" PROVIDER_SERVICE.SYSTEM_SERVICE_KIND_DETAIL");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" M_SERVICE.SERVICE_VALID_START");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" M_SERVICE.SERVICE_VALID_END");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" M_SERVICE.SERVICE_SORT");

    sb.append(" ");

    return sb.toString();
  }

  /**
   * 「週間表のみのサービスと、使用されている事業所提供サービスの一覧を取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_USED_PROVIDER_SERVICE_WITH_WEEKLY_SERVICE(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" DISTINCT M_SERVICE.SYSTEM_SERVICE_KIND_DETAIL");

    sb.append(",M_SERVICE.SERVICE_CODE_KIND");

    sb.append(",M_SERVICE.SERVICE_NAME");

    sb.append(",M_SERVICE.SERVICE_ABBREVIATION");

    sb.append(",M_SERVICE.SERVICE_KIND_NAME");

    sb.append(",M_SERVICE.SERVICE_CALENDAR_ABBREVIATION");

    sb.append(",M_SERVICE.CLAIM_STYLE_TYPE");

    sb.append(",M_SERVICE.SERVICE_SORT");

    sb.append(",M_SERVICE.BUSINESS_TYPE");

    sb.append(",M_SERVICE.CALENDAR_PASTE_FLAG");

    sb.append(",M_SERVICE.SERVICE_VALID_START");

    sb.append(",M_SERVICE.SERVICE_VALID_END");

    sb.append(" FROM");

    sb.append(" M_SERVICE");

    sb.append(",PROVIDER_SERVICE");

    sb.append(" LEFT JOIN");

    sb.append(" PROVIDER");

    sb.append(" ON");

    sb.append("(");

    sb.append(" PROVIDER_SERVICE.PROVIDER_ID");

    sb.append(" =");

    sb.append(" PROVIDER.PROVIDER_ID");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" PROVIDER.DELETE_FLAG");

    sb.append(" =");

    sb.append(" 0");

    sb.append(")");

    sb.append(" WHERE");

    sb.append("(");

    sb.append("(");

    sb.append(" M_SERVICE.SYSTEM_SERVICE_KIND_DETAIL");

    sb.append(" =");

    sb.append(" PROVIDER_SERVICE.SYSTEM_SERVICE_KIND_DETAIL");

    sb.append(")");

    sb.append("OR");

    sb.append("(");

    sb.append(" M_SERVICE.SYSTEM_SERVICE_KIND_DETAIL");

    sb.append(" >");

    sb.append(" 90000");

    sb.append(")");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" M_SERVICE.SERVICE_VALID_START");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" M_SERVICE.SERVICE_VALID_END");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" M_SERVICE.SERVICE_SORT");

    sb.append(" ");

    return sb.toString();
  }

  /**
   * 「サービスのパッシブチェックレコードを取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_PASSIVE_CHECK_RECORD(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" SERVICE_PASSIVE_CHECK.PATIENT_ID");

    sb.append(",SERVICE_PASSIVE_CHECK.TARGET_DATE");

    sb.append(",SERVICE_PASSIVE_CHECK.CHECK_TYPE");

    sb.append(",SERVICE_PASSIVE_CHECK.LAST_TIME");

    sb.append(" FROM");

    sb.append(" SERVICE_PASSIVE_CHECK");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" SERVICE_PASSIVE_CHECK.PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" SERVICE_PASSIVE_CHECK.TARGET_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-01"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" SERVICE_PASSIVE_CHECK.CHECK_TYPE");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CHECK_TYPE", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「サービスのパッシブチェックレコードを追加」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_INSERT_PASSIVE_CHECK_RECORD(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("INSERT INTO");

    sb.append(" SERVICE_PASSIVE_CHECK");

    sb.append("(");

    sb.append(" SERVICE_PASSIVE_CHECK.PATIENT_ID");

    sb.append(",SERVICE_PASSIVE_CHECK.TARGET_DATE");

    sb.append(",SERVICE_PASSIVE_CHECK.CHECK_TYPE");

    sb.append(",SERVICE_PASSIVE_CHECK.LAST_TIME");

    sb.append(")VALUES(");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-01"));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CHECK_TYPE", sqlParam)));

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「サービスのパッシブチェックレコードを更新」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_UPDATE_PASSIVE_CHECK_RECORD(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" SERVICE_PASSIVE_CHECK");

    sb.append(" SET");

    sb.append(" SERVICE_PASSIVE_CHECK.PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(",");

    sb.append(" SERVICE_PASSIVE_CHECK.TARGET_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-01"));

    sb.append(",");

    sb.append(" SERVICE_PASSIVE_CHECK.CHECK_TYPE");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CHECK_TYPE", sqlParam)));

    sb.append(",");

    sb.append(" SERVICE_PASSIVE_CHECK.LAST_TIME");

    sb.append(" =");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" SERVICE_PASSIVE_CHECK.PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" SERVICE_PASSIVE_CHECK.TARGET_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-01"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" SERVICE_PASSIVE_CHECK.CHECK_TYPE");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CHECK_TYPE", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「直近のサービス予定年月を取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_LAST_PLAN_DATE(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" FIRST 1 SERVICE_PASSIVE_CHECK.TARGET_DATE");

    sb.append(" FROM");

    sb.append(" SERVICE_PASSIVE_CHECK");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" SERVICE_PASSIVE_CHECK.PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" SERVICE_PASSIVE_CHECK.CHECK_TYPE");

    sb.append(" =");

    sb.append(" 1");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" SERVICE_PASSIVE_CHECK.TARGET_DATE");

    sb.append(" <");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-01"));

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" SERVICE_PASSIVE_CHECK.TARGET_DATE");

    sb.append(" DESC");

    return sb.toString();
  }

  /**
   * 「特定入居者フラグを取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_PATIENT_FACILITY_FLAG(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT_SHISETSU_HISTORY.TOKUTEI_NYUSHO_FLAG");

    sb.append(",PATIENT_SHISETSU_HISTORY.KYUSOCHI_FLAG");

    sb.append(" FROM");

    sb.append(" PATIENT_SHISETSU_HISTORY");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_SHISETSU_HISTORY.PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「ログイン事業所の居宅介護支援サービスを取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_LOGIN_PROVIDER_CARE_MANAGEMENT(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PROVIDER_SERVICE.PROVIDER_ID");

    sb.append(" FROM");

    sb.append(" PROVIDER_SERVICE");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PROVIDER_SERVICE.PROVIDER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" PROVIDER_SERVICE.SYSTEM_SERVICE_KIND_DETAIL");

    sb.append(" IN");

    sb.append(" (14311,17311,14611,17511)");

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「認定履歴の存在チェック」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_CHECK_NINTEI_HISTORY_EXISTS(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" FIRST 1 PATIENT_NINTEI_HISTORY.PATIENT_ID");

    sb.append(" FROM");

    sb.append(" PATIENT_NINTEI_HISTORY");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_NINTEI_HISTORY.PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「請求情報の親番号取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_CLAIM_ID(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" CLAIM.CLAIM_ID");

    sb.append(" FROM");

    sb.append(" CLAIM");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" CLAIM.TARGET_DATE");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE_FIRST", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM.TARGET_DATE");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE_LAST", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM.PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「請求情報の差し戻し」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_UPDATE_CLAIM_ID(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" CLAIM");

    sb.append(" SET");

    sb.append(" CLAIM.CLAIM_FINISH_FLAG");

    sb.append(" =");

    sb.append(" NULL");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" CLAIM.CLAIM_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CLAIM_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

}
