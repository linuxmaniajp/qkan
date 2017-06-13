
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
 * 開発者: 保険者管理
 * 作成日: 2006/03/30  日本コンピューター株式会社 保険者管理 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 保険者管理 (002)
 * プログラム 保険者登録 (QO002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo002;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Stack;

import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACSQLSafeIntegerFormat;
import jp.nichicom.ac.text.ACSQLSafeStringFormat;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * 保険者登録SQL定義(QO002) 
 */
public class QO002SQL extends QO002State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * コンストラクタです。
   */
  public QO002SQL() {
  }

  /**
   * 「保険者情報を取得する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_INSURER_INFO(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" INSURER_ID");

    sb.append(",INSURER_NAME");

    sb.append(",INSURER_TYPE");

    sb.append(",INSURER_ZIP_FIRST");

    sb.append(",INSURER_ZIP_SECOND");

    sb.append(",INSURER_ADDRESS");

    sb.append(",INSURER_TEL_FIRST");

    sb.append(",INSURER_TEL_SECOND");

    sb.append(",INSURER_TEL_THIRD");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" INSURER");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" INSURER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「保険者の支給限度額情報を」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_INSURER_LIMIT_RATE(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" INSURER_LIMIT_RATE.INSURER_ID");

    sb.append(",INSURER_LIMIT_RATE_DETAIL.LIMIT_RATE_HISTORY_ID");

    sb.append(",INSURER_LIMIT_RATE.LIMIT_RATE_VALID_START");

    sb.append(",INSURER_LIMIT_RATE.LIMIT_RATE_VALID_END");

    sb.append(",INSURER_LIMIT_RATE_DETAIL.JOTAI_CODE");

    sb.append(",INSURER_LIMIT_RATE_DETAIL.LIMIT_RATE_VALUE");

    sb.append(" FROM");

    sb.append(" INSURER_LIMIT_RATE");

    sb.append(",INSURER_LIMIT_RATE_DETAIL");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" INSURER_LIMIT_RATE.INSURER_ID");

    sb.append(" =");

    sb.append(" INSURER_LIMIT_RATE_DETAIL.INSURER_ID");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" INSURER_LIMIT_RATE.LIMIT_RATE_HISTORY_ID");

    sb.append(" =");

    sb.append(" INSURER_LIMIT_RATE_DETAIL.LIMIT_RATE_HISTORY_ID");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" INSURER_LIMIT_RATE.INSURER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" INSURER_LIMIT_RATE.INSURER_ID");

    sb.append(" ");

    sb.append(",INSURER_LIMIT_RATE_DETAIL.LIMIT_RATE_HISTORY_ID");

    return sb.toString();
  }

  /**
   * 「保険者の情報を登録する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_INSERT_INSURER_INFO(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("INSERT INTO");

    sb.append(" INSURER");

    sb.append("(");

    sb.append(" INSURER_ID");

    sb.append(",INSURER_NAME");

    sb.append(",INSURER_TYPE");

    sb.append(",INSURER_ZIP_FIRST");

    sb.append(",INSURER_ZIP_SECOND");

    sb.append(",INSURER_ADDRESS");

    sb.append(",INSURER_TEL_FIRST");

    sb.append(",INSURER_TEL_SECOND");

    sb.append(",INSURER_TEL_THIRD");

    sb.append(",DELETE_FLAG");

    sb.append(",LAST_TIME");

    sb.append(")VALUES(");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_NAME", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("INSURER_TYPE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ZIP_FIRST", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ZIP_SECOND", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ADDRESS", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_TEL_FIRST", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_TEL_SECOND", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_TEL_THIRD", sqlParam)));

    sb.append(",");

    sb.append(" 0");

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「保険者情報を更新する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_UPDATE_INSURER_INFO(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" INSURER");

    sb.append(" SET");

    sb.append(" INSURER_NAME");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_NAME", sqlParam)));

    sb.append(",");

    sb.append(" INSURER_TYPE");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("INSURER_TYPE", sqlParam)));

    sb.append(",");

    sb.append(" INSURER_ZIP_FIRST");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ZIP_FIRST", sqlParam)));

    sb.append(",");

    sb.append(" INSURER_ZIP_SECOND");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ZIP_SECOND", sqlParam)));

    sb.append(",");

    sb.append(" INSURER_ADDRESS");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ADDRESS", sqlParam)));

    sb.append(",");

    sb.append(" INSURER_TEL_FIRST");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_TEL_FIRST", sqlParam)));

    sb.append(",");

    sb.append(" INSURER_TEL_SECOND");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_TEL_SECOND", sqlParam)));

    sb.append(",");

    sb.append(" INSURER_TEL_THIRD");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_TEL_THIRD", sqlParam)));

    sb.append(",");

    sb.append(" LAST_TIME");

    sb.append(" =");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(",");

    sb.append(" DELETE_FLAG");

    sb.append(" =");

    sb.append(" 0");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" INSURER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「保険者支給限度額情報を登録する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_INSURT_INSURER_LIMIT_RATE(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("INSERT INTO");

    sb.append(" INSURER_LIMIT_RATE");

    sb.append("(");

    sb.append(" INSURER_ID");

    sb.append(",LIMIT_RATE_HISTORY_ID");

    sb.append(",LIMIT_RATE_VALID_START");

    sb.append(",LIMIT_RATE_VALID_END");

    sb.append(",LAST_TIME");

    sb.append(")VALUES(");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("LIMIT_RATE_HISTORY_ID", sqlParam)));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("LIMIT_RATE_VALID_START", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("LIMIT_RATE_VALID_END", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「保険者支給限度額情報詳細を」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_INSURT_INSURER_LIMIT_RATE_DETAIL(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("INSERT INTO");

    sb.append(" INSURER_LIMIT_RATE_DETAIL");

    sb.append("(");

    sb.append(" INSURER_ID");

    sb.append(",LIMIT_RATE_HISTORY_ID");

    sb.append(",JOTAI_CODE");

    sb.append(",LIMIT_RATE_VALUE");

    sb.append(",LAST_TIME");

    sb.append(")VALUES(");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("LIMIT_RATE_HISTORY_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("JOTAI_CODE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("LIMIT_RATE_VALUE", sqlParam)));

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「支給限度額情報を削除する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_DELETE_INSURER_LIMIT_RATE(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("DELETE FROM");

    sb.append(" INSURER_LIMIT_RATE");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" INSURER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「支給限度額詳細情報を削除する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_DELETE_INSURER_LIMIT_RATE_DETAIL(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("DELETE FROM");

    sb.append(" INSURER_LIMIT_RATE_DETAIL");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" INSURER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「支給限度額マスタより厚生労働省規定の支給限度額を取得する処理」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_SELECT_M_LIMIT_RATE(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" M_LIMIT_RATE.LIMIT_RATE_VALID_START");

    sb.append(",M_LIMIT_RATE.LIMIT_RATE_VALID_END");

    sb.append(",M_LIMIT_RATE_DETAIL.JOTAI_CODE");

    sb.append(",M_LIMIT_RATE_DETAIL.LIMIT_RATE_VALUE");

    sb.append(" FROM");

    sb.append(" M_LIMIT_RATE");

    sb.append(",M_LIMIT_RATE_DETAIL");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" M_LIMIT_RATE.LIMIT_RATE_HISTORY_ID");

    sb.append(" =");

    sb.append(" M_LIMIT_RATE_DETAIL.LIMIT_RATE_HISTORY_ID");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" M_LIMIT_RATE_DETAIL.LIMIT_RATE_TYPE");

    sb.append(" =");

    sb.append(" 1");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" M_LIMIT_RATE_DETAIL.LIMIT_RATE_HISTORY_ID");

    sb.append(" =");

    sb.append(" (");

    sb.append("SELECT");

    sb.append(" MAX(LIMIT_RATE_HISTORY_ID)");

    sb.append(" FROM");

    sb.append(" M_LIMIT_RATE_DETAIL");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" LIMIT_RATE_TYPE");

    sb.append(" =");

    sb.append(" 1");

    sb.append(")");

    sb.append(")");

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「保険者情報を取得する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_INSURER_INFO_DELETE_FLAG(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" INSURER_ID");

    sb.append(",INSURER_NAME");

    sb.append(",INSURER_TYPE");

    sb.append(",INSURER_ZIP_FIRST");

    sb.append(",INSURER_ZIP_SECOND");

    sb.append(",INSURER_ADDRESS");

    sb.append(",INSURER_TEL_FIRST");

    sb.append(",INSURER_TEL_SECOND");

    sb.append(",INSURER_TEL_THIRD");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" INSURER");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" DELETE_FLAG");

    sb.append(" =");

    sb.append(" 1");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" INSURER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「保険者の単位数単価情報」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_INSURER_UNIT_PRICE(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();

    sb.append("SELECT");

    sb.append(" INSURER_UNIT_PRICE.INSURER_ID");

    sb.append(",INSURER_UNIT_PRICE_DETAIL.UNIT_PRICE_HISTORY_ID");

    sb.append(",INSURER_UNIT_PRICE.UNIT_PRICE_VALID_START");

    sb.append(",INSURER_UNIT_PRICE.UNIT_PRICE_VALID_END");

    sb.append(",INSURER_UNIT_PRICE.UNIT_PRICE_TYPE");

    sb.append(",INSURER_UNIT_PRICE_DETAIL.SYSTEM_SERVICE_KIND_DETAIL");

    sb.append(",INSURER_UNIT_PRICE_DETAIL.UNIT_PRICE_VALUE");

    sb.append(" FROM");

    sb.append(" INSURER_UNIT_PRICE");

    sb.append(",INSURER_UNIT_PRICE_DETAIL");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" INSURER_UNIT_PRICE.INSURER_ID");

    sb.append(" =");

    sb.append(" INSURER_UNIT_PRICE_DETAIL.INSURER_ID");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" INSURER_UNIT_PRICE.UNIT_PRICE_HISTORY_ID");

    sb.append(" =");

    sb.append(" INSURER_UNIT_PRICE_DETAIL.UNIT_PRICE_HISTORY_ID");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" INSURER_UNIT_PRICE.INSURER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" INSURER_UNIT_PRICE.INSURER_ID");

    sb.append(" ");

    sb.append(",INSURER_UNIT_PRICE_DETAIL.UNIT_PRICE_HISTORY_ID");

    return sb.toString();
  }
  
  /**
   * 「地域単価マスタを取得する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_AREA_UNIT_PRICE(VRMap sqlParam) throws Exception{
    String ym = dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd");
    String serviceKind = ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL", sqlParam));

    StringBuilder sb = new StringBuilder();

    sb.append("SELECT");
    sb.append(" DISTINCT UNIT_PRICE_VALUE");
    sb.append(" FROM");
    sb.append(" M_AREA_UNIT_PRICE");
    sb.append(" WHERE");
    sb.append(" (UNIT_PRICE_TYPE");
    sb.append(" IN");
    sb.append(" ('5',");// その他の単位数単価
    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("UNIT_PRICE_TYPE", sqlParam)));
    sb.append(" )");
    sb.append(" )");
    sb.append(" AND(M_AREA_UNIT_PRICE.UNIT_VALID_START <= " + ym + ")");
    sb.append(" AND(M_AREA_UNIT_PRICE.UNIT_VALID_END >= " + ym + ")");
    if (VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL", sqlParam) != null) {
        sb.append(" AND(M_AREA_UNIT_PRICE.SYSTEM_SERVICE_KIND_DETAIL = " + serviceKind + ")");
      }
    sb.append(" ORDER BY UNIT_PRICE_VALUE");

    return sb.toString();

  }
  
  /**
   * 「単位数単価情報を削除する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_DELETE_INSURER_UNIT_PRICE(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();

    sb.append("DELETE FROM");

    sb.append(" INSURER_UNIT_PRICE");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" INSURER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「単位数単価詳細情報を削除する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_DELETE_INSURER_UNIT_PRICE_DETAIL(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();

    sb.append("DELETE FROM");

    sb.append(" INSURER_UNIT_PRICE_DETAIL");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" INSURER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }
  /**
   * 「単位数単価情報を登録する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_INSURT_INSURER_UNIT_PRICE(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();

    sb.append("INSERT INTO");

    sb.append(" INSURER_UNIT_PRICE");

    sb.append("(");

    sb.append(" INSURER_ID");

    sb.append(",UNIT_PRICE_HISTORY_ID");

    sb.append(",UNIT_PRICE_VALID_START");

    sb.append(",UNIT_PRICE_VALID_END");

    sb.append(",UNIT_PRICE_TYPE");

    sb.append(",LAST_TIME");

    sb.append(")VALUES(");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("UNIT_PRICE_HISTORY_ID", sqlParam)));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("UNIT_PRICE_VALID_START", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("UNIT_PRICE_VALID_END", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("UNIT_PRICE_TYPE", sqlParam)));

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「単位数単価情報詳細を」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_INSURT_INSURER_UNIT_PRICE_DETAIL(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();

    sb.append("INSERT INTO");

    sb.append(" INSURER_UNIT_PRICE_DETAIL");

    sb.append("(");

    sb.append(" INSURER_ID");

    sb.append(",UNIT_PRICE_HISTORY_ID");

    sb.append(",SYSTEM_SERVICE_KIND_DETAIL");

    sb.append(",UNIT_PRICE_VALUE");

    sb.append(",LAST_TIME");

    sb.append(")VALUES(");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("UNIT_PRICE_HISTORY_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("UNIT_PRICE_VALUE", sqlParam)));

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(")");

    return sb.toString();
  }
}
