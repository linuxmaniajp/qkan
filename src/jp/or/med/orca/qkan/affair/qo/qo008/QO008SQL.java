
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
 * 開発者: 定型文編集
 * 作成日: 2006/08/28  日本コンピューター株式会社 定型文編集 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 定型文編集 (008)
 * プログラム 定型文編集 (QO008)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo008;
import java.util.Stack;

import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACSQLSafeIntegerFormat;
import jp.nichicom.ac.text.ACSQLSafeStringFormat;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;

/**
 * 定型文編集SQL定義(QO008) 
 */
public class QO008SQL extends QO008State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * コンストラクタです。
   */
  public QO008SQL() {
  }

  /**
   * 「定型文分類情報取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_FIXED_FORM_GROUP(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" TABLE_TYPE");

    sb.append(",FIXED_FORM_ID");

    sb.append(",FIXED_FORM_GROUP");

    sb.append(",FIXED_FORM_TITLE");

    sb.append(",SYSTEM_SERVICE_KIND_DETAIL");

    sb.append(",FIXED_FORM_SORT");

    sb.append(" FROM");

    sb.append(" M_FIXED_FORM_GROUP");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" TABLE_TYPE");

    sb.append(" IN");

    sb.append(" (1,2)");

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" TABLE_TYPE");

    sb.append(" ASC");

    sb.append(",FIXED_FORM_ID");

    sb.append(" ASC");

    return sb.toString();
  }

  /**
   * 「定型文情報取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_FIXED_FORM(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" TABLE_TYPE");

    sb.append(",FIXED_FORM_ID");

    sb.append(",CONTENT_KEY");

    sb.append(",CONTENT");

    sb.append(",CONTENT_SORT");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" FIXED_FORM");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" TABLE_TYPE");

    sb.append(" IN");

    sb.append(" (1,2)");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" FIXED_FORM_ID");

    sb.append(" IN");

    sb.append(" (1,2)");

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" TABLE_TYPE");

    sb.append(" ");

    sb.append(",CONTENT_SORT");

    return sb.toString();
  }

  /**
   * 「定型文登録」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_INSERT_FIXED_FORM(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("INSERT INTO");

    sb.append(" FIXED_FORM");

    sb.append("(");

    sb.append(" TABLE_TYPE");

    sb.append(",FIXED_FORM_ID");

    sb.append(",CONTENT_KEY");

    sb.append(",CONTENT");

    sb.append(",CONTENT_SORT");

    sb.append(",LAST_TIME");

    sb.append(")VALUES(");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("TABLE_TYPE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("FIXED_FORM_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CONTENT_KEY", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("CONTENT", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CONTENT_SORT", sqlParam)));

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_DELETE_FIXED_FORM(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("DELETE FROM");

    sb.append(" FIXED_FORM");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" TABLE_TYPE");

    sb.append(" IN");

    sb.append(" (1,2)");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" FIXED_FORM_ID");

    sb.append(" IN");

    sb.append(" (1,2)");

    sb.append(")");

    return sb.toString();
  }
  /**
   * 「定型文分類情報取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_FIXED_FORM_GROUP_WITHOUT_IRYO(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" TABLE_TYPE");

    sb.append(",FIXED_FORM_ID");

    sb.append(",FIXED_FORM_GROUP");

    sb.append(",FIXED_FORM_TITLE");

    sb.append(",SYSTEM_SERVICE_KIND_DETAIL");

    sb.append(",FIXED_FORM_SORT");

    sb.append(" FROM");

    sb.append(" M_FIXED_FORM_GROUP");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" TABLE_TYPE");

    sb.append(" IN");
    
    sb.append(" (1)");

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" TABLE_TYPE");

    sb.append(" ASC");

    sb.append(",FIXED_FORM_ID");

    sb.append(" ASC");

    return sb.toString();
  }
}
