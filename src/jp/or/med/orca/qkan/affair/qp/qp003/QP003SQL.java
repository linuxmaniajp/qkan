
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
 * 開発者: 確認・修正
 * 作成日: 2016/01/28  日本コンピューター株式会社 確認・修正 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 確認・修正 (003)
 * プログラム 利用者向け請求詳細編集 (QP003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp003;
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
 * 利用者向け請求詳細編集SQL定義(QP003) 
 */
public class QP003SQL extends QP003State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * コンストラクタです。
   */
  public QP003SQL() {
  }

  /**
   * 「コンボの選択肢を取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_COMBO_DETAIL(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" FIXED_FORM_ID");

    sb.append(",CONTENT_KEY");

    sb.append(",CONTENT");

    sb.append(" FROM");

    sb.append(" FIXED_FORM");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" TABLE_TYPE");

    sb.append(" =");

    sb.append(" 1");

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" CONTENT_SORT");

    sb.append(" ASC");

    return sb.toString();
  }

  /**
   * 「選択肢として既に登録されているか確認する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_COUNT_SELF_PAY(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" CASE");

    sb.append(" WHEN");

    sb.append(" MAX(CONTENT_KEY) IS NULL THEN 0 ELSE MAX(CONTENT_KEY + 1) END AS CONTENT_SELF_PAY");

    sb.append(" FROM");

    sb.append(" FIXED_FORM");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" TABLE_TYPE");

    sb.append(" =");

    sb.append(" 1");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" FIXED_FORM_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("FIXED_FORM_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CONTENT");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("CONTENT", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「CONTENT_KEYの最大値+1の値を取得する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_NEW_CONTENT_KEY(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" CASE");

    sb.append(" WHEN");

    sb.append(" MAX(CONTENT_KEY)  IS NULL THEN 0 ELSE MAX(CONTENT_KEY + 1) END AS NEW_CONTENT_KEY");

    sb.append(" FROM");

    sb.append(" FIXED_FORM");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" TABLE_TYPE");

    sb.append(" =");

    sb.append(" 1");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" FIXED_FORM_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("FIXED_FORM_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「新たにCONTENT_SORTを取得する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_NEW_CONTENT_SORT(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" CASE");

    sb.append(" WHEN");

    sb.append(" MAX(CONTENT_SORT)  IS NULL THEN 0 ELSE MAX(CONTENT_SORT + 1) END AS NEW_CONTENT_SORT");

    sb.append(" FROM");

    sb.append(" FIXED_FORM");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" TABLE_TYPE");

    sb.append(" =");

    sb.append(" 1");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" FIXED_FORM_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("FIXED_FORM_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「定型文テーブルに追加する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_INSERT_FIXED_FORM(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
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
   * 「利用者向け請求詳細情報を取得する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_CLAIM_PATIENT_DETAIL(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" CLAIM.CLAIM_ID");

    sb.append(",CLAIM_PATIENT_DETAIL.CLAIM_ID AS DATA_FLAG");

    sb.append(",CLAIM_PATIENT_DETAIL.SELF_SERVICE_NO1");

    sb.append(",CLAIM_PATIENT_DETAIL.SELF_PAY_NO1");

    sb.append(",CLAIM_PATIENT_DETAIL.SELF_SERVICE_NO2");

    sb.append(",CLAIM_PATIENT_DETAIL.SELF_PAY_NO2");

    sb.append(",CLAIM_PATIENT_DETAIL.SELF_SERVICE_NO3");

    sb.append(",CLAIM_PATIENT_DETAIL.SELF_PAY_NO3");

    sb.append(",CLAIM_PATIENT_DETAIL.OTHER_HIMOKU_NO1");

    sb.append(",CLAIM_PATIENT_DETAIL.OTHER_PAY_NO1");

    sb.append(",CLAIM_PATIENT_DETAIL.OTHER_HIMOKU_NO2");

    sb.append(",CLAIM_PATIENT_DETAIL.OTHER_PAY_NO2");

    sb.append(",CLAIM_PATIENT_DETAIL.OTHER_HIMOKU_NO3");

    sb.append(",CLAIM_PATIENT_DETAIL.OTHER_PAY_NO3");

    sb.append(",CLAIM_PATIENT_DETAIL.OTHER_HIMOKU_NO4");

    sb.append(",CLAIM_PATIENT_DETAIL.OTHER_PAY_NO4");

    sb.append(",CLAIM_PATIENT_DETAIL.OTHER_HIMOKU_NO5");

    sb.append(",CLAIM_PATIENT_DETAIL.OTHER_PAY_NO5");

    sb.append(",CLAIM_PATIENT_DETAIL.KOJO_TARGET");

    sb.append(",CLAIM_PATIENT_DETAIL.INNER_TAX");

    sb.append(",CLAIM_PATIENT_DETAIL.LAST_TIME");

    sb.append(",CLAIM_PATIENT_DETAIL.OTHER_UNIT_NO1");

    sb.append(",CLAIM_PATIENT_DETAIL.OTHER_COUNT_NO1");

    sb.append(",CLAIM_PATIENT_DETAIL.OTHER_UNIT_NO2");

    sb.append(",CLAIM_PATIENT_DETAIL.OTHER_COUNT_NO2");

    sb.append(",CLAIM_PATIENT_DETAIL.OTHER_UNIT_NO3");

    sb.append(",CLAIM_PATIENT_DETAIL.OTHER_COUNT_NO3");

    sb.append(",CLAIM_PATIENT_DETAIL.OTHER_UNIT_NO4");

    sb.append(",CLAIM_PATIENT_DETAIL.OTHER_COUNT_NO4");

    sb.append(",CLAIM_PATIENT_DETAIL.OTHER_UNIT_NO5");

    sb.append(",CLAIM_PATIENT_DETAIL.OTHER_COUNT_NO5");

    sb.append(",CLAIM_PATIENT_DETAIL.OTHER_HIMOKU_NO6");

    sb.append(",CLAIM_PATIENT_DETAIL.OTHER_UNIT_NO6");

    sb.append(",CLAIM_PATIENT_DETAIL.OTHER_COUNT_NO6");

    sb.append(",CLAIM_PATIENT_DETAIL.OTHER_PAY_NO6");

    sb.append(",CLAIM_PATIENT_DETAIL.MARK1_SERVICE_NAME");

    sb.append(",CLAIM_PATIENT_DETAIL.MARK1_SERVICE_DATE_BIT");

    sb.append(",CLAIM_PATIENT_DETAIL.MARK2_SERVICE_NAME");

    sb.append(",CLAIM_PATIENT_DETAIL.MARK2_SERVICE_DATE_BIT");

    sb.append(",CLAIM_PATIENT_DETAIL.MARK3_SERVICE_NAME");

    sb.append(",CLAIM_PATIENT_DETAIL.MARK3_SERVICE_DATE_BIT");

    sb.append(",CLAIM_PATIENT_DETAIL.MARK4_SERVICE_NAME");

    sb.append(",CLAIM_PATIENT_DETAIL.MARK4_SERVICE_DATE_BIT");

    sb.append(",CLAIM_PATIENT_DETAIL.MARK5_SERVICE_NAME");

    sb.append(",CLAIM_PATIENT_DETAIL.MARK5_SERVICE_DATE_BIT");

    sb.append(",CLAIM_PATIENT_DETAIL.MARK6_SERVICE_NAME");

    sb.append(",CLAIM_PATIENT_DETAIL.MARK6_SERVICE_DATE_BIT");

    sb.append(",CLAIM_PATIENT_DETAIL.MARK7_SERVICE_NAME");

    sb.append(",CLAIM_PATIENT_DETAIL.MARK7_SERVICE_DATE_BIT");

    sb.append(",CLAIM_PATIENT_DETAIL.REMARKS");

    sb.append(" FROM");

    sb.append(" CLAIM");

    sb.append(" LEFT JOIN");

    sb.append(" CLAIM_PATIENT_DETAIL");

    sb.append(" ON");

    sb.append("(");

    sb.append(" CLAIM_PATIENT_DETAIL.CLAIM_ID");

    sb.append(" =");

    sb.append(" CLAIM.CLAIM_ID");

    sb.append(")");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" CLAIM.PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM.TARGET_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM.CLAIM_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("CLAIM_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM.PROVIDER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM.CLAIM_STYLE_TYPE");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CLAIM_STYLE_TYPE", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM.CATEGORY_NO");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CATEGORY_NO", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「利用者向け請求詳細情報を登録する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_INSERT_CLAIM_PATIENT_DETAIL(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("INSERT INTO");

    sb.append(" CLAIM_PATIENT_DETAIL");

    sb.append("(");

    sb.append(" CLAIM_ID");

    sb.append(",SELF_SERVICE_NO1");

    sb.append(",SELF_PAY_NO1");

    sb.append(",SELF_SERVICE_NO2");

    sb.append(",SELF_PAY_NO2");

    sb.append(",SELF_SERVICE_NO3");

    sb.append(",SELF_PAY_NO3");

    sb.append(",OTHER_HIMOKU_NO1");

    sb.append(",OTHER_PAY_NO1");

    sb.append(",OTHER_HIMOKU_NO2");

    sb.append(",OTHER_PAY_NO2");

    sb.append(",OTHER_HIMOKU_NO3");

    sb.append(",OTHER_PAY_NO3");

    sb.append(",OTHER_HIMOKU_NO4");

    sb.append(",OTHER_PAY_NO4");

    sb.append(",OTHER_HIMOKU_NO5");

    sb.append(",OTHER_PAY_NO5");

    sb.append(",KOJO_TARGET");

    sb.append(",INNER_TAX");

    sb.append(",LAST_TIME");

    sb.append(",OTHER_UNIT_NO1");

    sb.append(",OTHER_COUNT_NO1");

    sb.append(",OTHER_UNIT_NO2");

    sb.append(",OTHER_COUNT_NO2");

    sb.append(",OTHER_UNIT_NO3");

    sb.append(",OTHER_COUNT_NO3");

    sb.append(",OTHER_UNIT_NO4");

    sb.append(",OTHER_COUNT_NO4");

    sb.append(",OTHER_UNIT_NO5");

    sb.append(",OTHER_COUNT_NO5");

    sb.append(",OTHER_HIMOKU_NO6");

    sb.append(",OTHER_UNIT_NO6");

    sb.append(",OTHER_COUNT_NO6");

    sb.append(",OTHER_PAY_NO6");

    sb.append(",REMARKS");

    sb.append(")VALUES(");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CLAIM_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SELF_SERVICE_NO1", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SELF_PAY_NO1", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SELF_SERVICE_NO2", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SELF_PAY_NO2", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SELF_SERVICE_NO3", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SELF_PAY_NO3", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("OTHER_HIMOKU_NO1", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_PAY_NO1", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("OTHER_HIMOKU_NO2", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_PAY_NO2", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("OTHER_HIMOKU_NO3", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_PAY_NO3", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("OTHER_HIMOKU_NO4", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_PAY_NO4", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("OTHER_HIMOKU_NO5", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_PAY_NO5", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("KOJO_TARGET", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("INNER_TAX", sqlParam)));

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_UNIT_NO1", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_COUNT_NO1", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_UNIT_NO2", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_COUNT_NO2", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_UNIT_NO3", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_COUNT_NO3", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_UNIT_NO4", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_COUNT_NO4", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_UNIT_NO5", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_COUNT_NO5", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("OTHER_HIMOKU_NO6", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_UNIT_NO6", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_COUNT_NO6", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_PAY_NO6", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("REMARKS", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「請求情報を登録する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_INSERT_CLAIM(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("INSERT INTO");

    sb.append(" CLAIM");

    sb.append("(");

    sb.append(" CLAIM_ID");

    sb.append(",CLAIM_STYLE_TYPE");

    sb.append(",CATEGORY_NO");

    sb.append(",PATIENT_ID");

    sb.append(",INSURED_ID");

    sb.append(",TARGET_DATE");

    sb.append(",CLAIM_DATE");

    sb.append(",INSURER_ID");

    sb.append(",PROVIDER_ID");

    sb.append(",CLAIM_FINISH_FLAG");

    sb.append(",LAST_TIME");

    sb.append(")VALUES(");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CLAIM_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CLAIM_STYLE_TYPE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CATEGORY_NO", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURED_ID", sqlParam)));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("CLAIM_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CLAIM_FINISH_FLAG", sqlParam)));

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「利用者向け請求詳細情報を更新する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_UPDATE_CLAIM_PATIENT_DETAIL(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" CLAIM_PATIENT_DETAIL");

    sb.append(" SET");

    sb.append(" CLAIM_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CLAIM_ID", sqlParam)));

    sb.append(",");

    sb.append(" SELF_SERVICE_NO1");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SELF_SERVICE_NO1", sqlParam)));

    sb.append(",");

    sb.append(" SELF_PAY_NO1");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SELF_PAY_NO1", sqlParam)));

    sb.append(",");

    sb.append(" SELF_SERVICE_NO2");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SELF_SERVICE_NO2", sqlParam)));

    sb.append(",");

    sb.append(" SELF_PAY_NO2");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SELF_PAY_NO2", sqlParam)));

    sb.append(",");

    sb.append(" SELF_SERVICE_NO3");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SELF_SERVICE_NO3", sqlParam)));

    sb.append(",");

    sb.append(" SELF_PAY_NO3");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SELF_PAY_NO3", sqlParam)));

    sb.append(",");

    sb.append(" OTHER_HIMOKU_NO1");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("OTHER_HIMOKU_NO1", sqlParam)));

    sb.append(",");

    sb.append(" OTHER_PAY_NO1");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_PAY_NO1", sqlParam)));

    sb.append(",");

    sb.append(" OTHER_HIMOKU_NO2");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("OTHER_HIMOKU_NO2", sqlParam)));

    sb.append(",");

    sb.append(" OTHER_PAY_NO2");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_PAY_NO2", sqlParam)));

    sb.append(",");

    sb.append(" OTHER_HIMOKU_NO3");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("OTHER_HIMOKU_NO3", sqlParam)));

    sb.append(",");

    sb.append(" OTHER_PAY_NO3");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_PAY_NO3", sqlParam)));

    sb.append(",");

    sb.append(" OTHER_HIMOKU_NO4");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("OTHER_HIMOKU_NO4", sqlParam)));

    sb.append(",");

    sb.append(" OTHER_PAY_NO4");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_PAY_NO4", sqlParam)));

    sb.append(",");

    sb.append(" OTHER_HIMOKU_NO5");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("OTHER_HIMOKU_NO5", sqlParam)));

    sb.append(",");

    sb.append(" OTHER_PAY_NO5");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_PAY_NO5", sqlParam)));

    sb.append(",");

    sb.append(" KOJO_TARGET");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("KOJO_TARGET", sqlParam)));

    sb.append(",");

    sb.append(" INNER_TAX");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("INNER_TAX", sqlParam)));

    sb.append(",");

    sb.append(" LAST_TIME");

    sb.append(" =");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(",");

    sb.append(" OTHER_UNIT_NO1");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_UNIT_NO1", sqlParam)));

    sb.append(",");

    sb.append(" OTHER_COUNT_NO1");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_COUNT_NO1", sqlParam)));

    sb.append(",");

    sb.append(" OTHER_UNIT_NO2");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_UNIT_NO2", sqlParam)));

    sb.append(",");

    sb.append(" OTHER_COUNT_NO2");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_COUNT_NO2", sqlParam)));

    sb.append(",");

    sb.append(" OTHER_UNIT_NO3");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_UNIT_NO3", sqlParam)));

    sb.append(",");

    sb.append(" OTHER_COUNT_NO3");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_COUNT_NO3", sqlParam)));

    sb.append(",");

    sb.append(" OTHER_UNIT_NO4");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_UNIT_NO4", sqlParam)));

    sb.append(",");

    sb.append(" OTHER_COUNT_NO4");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_COUNT_NO4", sqlParam)));

    sb.append(",");

    sb.append(" OTHER_UNIT_NO5");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_UNIT_NO5", sqlParam)));

    sb.append(",");

    sb.append(" OTHER_COUNT_NO5");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_COUNT_NO5", sqlParam)));

    sb.append(",");

    sb.append(" OTHER_HIMOKU_NO6");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("OTHER_HIMOKU_NO6", sqlParam)));

    sb.append(",");

    sb.append(" OTHER_UNIT_NO6");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_UNIT_NO6", sqlParam)));

    sb.append(",");

    sb.append(" OTHER_COUNT_NO6");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_COUNT_NO6", sqlParam)));

    sb.append(",");

    sb.append(" OTHER_PAY_NO6");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("OTHER_PAY_NO6", sqlParam)));

    sb.append(",");

    sb.append(" MARK1_SERVICE_DATE_BIT");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("MARK1_SERVICE_DATE_BIT", sqlParam)));

    sb.append(",");

    sb.append(" MARK2_SERVICE_DATE_BIT");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("MARK2_SERVICE_DATE_BIT", sqlParam)));

    sb.append(",");

    sb.append(" MARK3_SERVICE_DATE_BIT");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("MARK3_SERVICE_DATE_BIT", sqlParam)));

    sb.append(",");

    sb.append(" MARK4_SERVICE_DATE_BIT");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("MARK4_SERVICE_DATE_BIT", sqlParam)));

    sb.append(",");

    sb.append(" MARK5_SERVICE_DATE_BIT");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("MARK5_SERVICE_DATE_BIT", sqlParam)));

    sb.append(",");

    sb.append(" MARK6_SERVICE_DATE_BIT");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("MARK6_SERVICE_DATE_BIT", sqlParam)));

    sb.append(",");

    sb.append(" MARK7_SERVICE_DATE_BIT");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("MARK7_SERVICE_DATE_BIT", sqlParam)));

    sb.append(",");

    sb.append(" REMARKS");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("REMARKS", sqlParam)));

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" CLAIM_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CLAIM_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「登録パッシブチェック用」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_NEW_CLAIM_PATIENT_DETAIL(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
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

    sb.append(" CLAIM.PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM.TARGET_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM.CLAIM_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("CLAIM_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM.PROVIDER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM.CLAIM_STYLE_TYPE");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CLAIM_STYLE_TYPE", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM.CATEGORY_NO");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CATEGORY_NO", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「直近の利用者向け請求書情報取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_LAST_CLAIM_NO(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" CLAIM_ID");

    sb.append(" FROM");

    sb.append(" CLAIM");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" CLAIM.PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM.PROVIDER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM.CLAIM_STYLE_TYPE");

    sb.append(" =");

    sb.append(" 30101");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM.CATEGORY_NO");

    sb.append(" =");

    sb.append(" 16");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM.TARGET_DATE");

    sb.append(" =");

    sb.append(" (");

    sb.append("SELECT");

    sb.append(" MAX(CLAIM.TARGET_DATE)");

    sb.append(" FROM");

    sb.append(" CLAIM");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" CLAIM.PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM.PROVIDER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM.CLAIM_STYLE_TYPE");

    sb.append(" =");

    sb.append(" 30101");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM.CATEGORY_NO");

    sb.append(" =");

    sb.append(" 16");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM.TARGET_DATE");

    sb.append(" <");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(")");

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" CLAIM.LAST_TIME");

    sb.append(" DESC");

    return sb.toString();
  }

  /**
   * 「直近の利用者向け請求書情報取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_LAST_CLAIM_PATIENT(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" CLAIM_ID");

    sb.append(",OTHER_HIMOKU_NO1");

    sb.append(",OTHER_PAY_NO1");

    sb.append(",OTHER_HIMOKU_NO2");

    sb.append(",OTHER_PAY_NO2");

    sb.append(",OTHER_HIMOKU_NO3");

    sb.append(",OTHER_PAY_NO3");

    sb.append(",OTHER_HIMOKU_NO4");

    sb.append(",OTHER_PAY_NO4");

    sb.append(",OTHER_HIMOKU_NO5");

    sb.append(",OTHER_PAY_NO5");

    sb.append(",LAST_TIME");

    sb.append(",OTHER_UNIT_NO1");

    sb.append(",OTHER_COUNT_NO1");

    sb.append(",OTHER_UNIT_NO2");

    sb.append(",OTHER_COUNT_NO2");

    sb.append(",OTHER_UNIT_NO3");

    sb.append(",OTHER_COUNT_NO3");

    sb.append(",OTHER_UNIT_NO4");

    sb.append(",OTHER_COUNT_NO4");

    sb.append(",OTHER_UNIT_NO5");

    sb.append(",OTHER_COUNT_NO5");

    sb.append(",OTHER_HIMOKU_NO6");

    sb.append(",OTHER_UNIT_NO6");

    sb.append(",OTHER_COUNT_NO6");

    sb.append(",OTHER_PAY_NO6");

    sb.append(",REMARKS");

    sb.append(" FROM");

    sb.append(" CLAIM_PATIENT_DETAIL");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" CLAIM_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CLAIM_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「全額自己負担項目のみ更新用SQL」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_UPDATE_CLAIM_PATIENT_DETAIL_ONLY_SELF(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" CLAIM_PATIENT_DETAIL");

    sb.append(" SET");

    sb.append(" CLAIM_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CLAIM_ID", sqlParam)));

    sb.append(",");

    sb.append(" SELF_SERVICE_NO1");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SELF_SERVICE_NO1", sqlParam)));

    sb.append(",");

    sb.append(" SELF_PAY_NO1");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SELF_PAY_NO1", sqlParam)));

    sb.append(",");

    sb.append(" SELF_SERVICE_NO2");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SELF_SERVICE_NO2", sqlParam)));

    sb.append(",");

    sb.append(" SELF_PAY_NO2");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SELF_PAY_NO2", sqlParam)));

    sb.append(",");

    sb.append(" SELF_SERVICE_NO3");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SELF_SERVICE_NO3", sqlParam)));

    sb.append(",");

    sb.append(" SELF_PAY_NO3");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SELF_PAY_NO3", sqlParam)));

    sb.append(",");

    sb.append(" LAST_TIME");

    sb.append(" =");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" CLAIM_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CLAIM_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「全額自己負担項目のみ登録用SQL」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_INSERT_CLAIM_PATIENT_DETAIL_ONLY_SELF(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("INSERT INTO");

    sb.append(" CLAIM_PATIENT_DETAIL");

    sb.append("(");

    sb.append(" CLAIM_ID");

    sb.append(",SELF_SERVICE_NO1");

    sb.append(",SELF_PAY_NO1");

    sb.append(",SELF_SERVICE_NO2");

    sb.append(",SELF_PAY_NO2");

    sb.append(",SELF_SERVICE_NO3");

    sb.append(",SELF_PAY_NO3");

    sb.append(",LAST_TIME");

    sb.append(")VALUES(");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CLAIM_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SELF_SERVICE_NO1", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SELF_PAY_NO1", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SELF_SERVICE_NO2", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SELF_PAY_NO2", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SELF_SERVICE_NO3", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SELF_PAY_NO3", sqlParam)));

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「利用者向け請求書データが存在しているかチェックします。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_CLAIM_PATIENT_TARGET_DATA_COUNT(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" CLAIM_ID");

    sb.append(" FROM");

    sb.append(" CLAIM_PATIENT_DETAIL");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" CLAIM_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CLAIM_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }


  /**
   * 「医療費控除に記載する利用者負担額を取得する」ためのSQLを返します。 
   * @param sqlParam
   * @return
   * @throws Exception
   */
  public String getSQL_GET_RIYOUSYA_UNIT(VRMap sqlParam) throws Exception {
      StringBuilder sb = new StringBuilder();
      Date seikyuDate = null;
      if (VRBindPathParser.has("CLAIM_DATE", sqlParam)) {
          seikyuDate = ACCastUtilities.toDate(VRBindPathParser.get(
                  "CLAIM_DATE", sqlParam));
      } else {
          return sb.toString();
      }
      
      Date fiscalDate = null;
      fiscalDate = ACDateUtilities.addMonth(seikyuDate, -3);

      sb.append("SELECT");
      sb.append(" CLAIM1.PATIENT_ID,");
      sb.append(" CLAIM1.INSURED_ID,");
      sb.append(" CLAIM1.CLAIM_ID,");
      sb.append(" CLAIM1.CLAIM_STYLE_TYPE,");
      sb.append(" CLAIM1.UNIT,");
      sb.append(" CLAIM2.SERVICE_CODE_KIND");
      sb.append(" FROM (");
      
      // 各利用者負担額
      sb.append("SELECT");
      sb.append(" CLAIM.PATIENT_ID,");
      sb.append(" CLAIM.INSURED_ID,");
      sb.append(" CLAIM.CLAIM_ID,");
      sb.append(" CLAIM.CLAIM_STYLE_TYPE,");
      sb.append(" SUM(CAST(CLAIM_TEMP.DETAIL_VALUE AS INTEGER)) AS UNIT");
      sb.append(" FROM");
      sb.append(" CLAIM,");
      sb.append(" CLAIM_DETAIL_TEXT_" + VRDateParser.format(fiscalDate, "yyyy") + " CLAIM_TEMP");
      sb.append(" WHERE");
      sb.append("(");
      sb.append(" CLAIM.PATIENT_ID");
      sb.append(" =");
      sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));
      sb.append(")");
      sb.append("AND");
      sb.append("(");
      sb.append(" CLAIM.TARGET_DATE");
      sb.append(" =");
      sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));
      sb.append(")");
      sb.append("AND");
      sb.append("(");
      sb.append(" CLAIM.CLAIM_DATE");
      sb.append(" =");
      sb.append(dateFormat.format(VRBindPathParser.get("CLAIM_DATE", sqlParam), "yyyy-MM-dd"));
      sb.append(")");
      sb.append("AND");
      sb.append("(");
      sb.append(" CLAIM.PROVIDER_ID");
      sb.append(" =");
      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));
      sb.append(")");
      // 様式６と様式７は除外する
      sb.append(" AND(CLAIM.CLAIM_STYLE_TYPE < 10611 OR CLAIM.CLAIM_STYLE_TYPE > 10713)");
      sb.append(" AND(CLAIM.CLAIM_ID = CLAIM_TEMP.CLAIM_ID)");

      sb.append(" AND (");
      //集計情報レコード
      sb.append("((CLAIM.CATEGORY_NO = 7) AND CLAIM_TEMP.SYSTEM_BIND_PATH IN (");
      //保険+公費
      sb.append("'701017'"); //(保険)利用者負担額8桁
      sb.append(",'701020'"); //(公費1)本人負担額8桁
      sb.append(",'701023'"); //(公費2)本人負担額8桁
      sb.append(",'701026'"); //(公費3)本人負担額8桁
      //緊急時施設療養費＋特定診療費・特別療養費
      sb.append(",'701029'"); //(保険分出来高医療費)出来高医療費利用者負担額8桁
      sb.append(",'701032'"); //(公費1分出来高医療費)出来高医療費本人負担額8桁
      sb.append(",'701035'"); //(公費2分出来高医療費)出来高医療費本人負担額8桁
      sb.append(",'701038'"); //(公費3分出来高医療費)出来高医療費本人負担額8桁
      sb.append("))");
      //特定入所者レコード
      sb.append(" OR ");
      sb.append("((CLAIM.CATEGORY_NO = 8) AND CLAIM_TEMP.SYSTEM_BIND_PATH IN (");
      //特定入所者介護サービス費
      sb.append("'801024'"); //(特定入所者)利用者負担額合計6桁
      sb.append(",'801027'"); //(特定入所者　公費1)本人負担月額5桁
      sb.append(",'801030'"); //(特定入所者　公費2)本人負担月額5桁
      sb.append(",'801033'"); //(特定入所者　公費3)本人負担月額5桁
      sb.append("))");
      sb.append(")");
      sb.append(" GROUP BY");
      sb.append(" CLAIM.PATIENT_ID,");
      sb.append(" CLAIM.INSURED_ID,");
      sb.append(" CLAIM.CLAIM_ID,");
      sb.append(" CLAIM.CLAIM_STYLE_TYPE");

      // サービス種類をJOINする※集計レコード以外はNullが設定されるので注意
      sb.append(" ) CLAIM1");
      sb.append(" LEFT JOIN (");
      sb.append(" SELECT CLAIM_ID, DETAIL_VALUE AS SERVICE_CODE_KIND");
      sb.append(" FROM");
      sb.append(" CLAIM_DETAIL_TEXT_" + VRDateParser.format(fiscalDate, "yyyy"));
      sb.append(" WHERE");
      sb.append(" SYSTEM_BIND_PATH = 701007");
      sb.append(" ) CLAIM2");
      sb.append(" ON CLAIM1.CLAIM_ID = CLAIM2.CLAIM_ID");

      sb.append(" ORDER BY");
      sb.append(" CLAIM1.CLAIM_ID, CLAIM1.CLAIM_STYLE_TYPE");
      sb.append(" ASC");

      return sb.toString();
  }

}
