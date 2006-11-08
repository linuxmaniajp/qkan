
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
 * 作成日: 2006/06/02  日本コンピューター株式会社 確認・修正 新規作成
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
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
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
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
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
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
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
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
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
    StringBuffer sb = new StringBuffer();
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
   * 「利用者向け請求詳細情報を取得する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_CLAIM_PATIENT_DETAIL(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
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

    sb.append(",CLAIM_PATIENT_DETAIL.LAST_TIME");

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
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
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

    sb.append(" CURRENT_TIMESTAMP");

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
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
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
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
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
   * 「登録パッシブチェック用」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_NEW_CLAIM_PATIENT_DETAIL(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
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
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
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

    return sb.toString();
  }

  /**
   * 「直近の利用者向け請求書情報取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_LAST_CLAIM_PATIENT(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

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

    sb.append(",LAST_TIME");

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

}
