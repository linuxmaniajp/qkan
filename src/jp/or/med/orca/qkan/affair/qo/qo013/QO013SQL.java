
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
 * 作成日: 2016/02/04  日本コンピューター株式会社 日医標準レセプトソフト連携 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 日医標準レセプトソフト連携 (013)
 * プログラム 日医標準レセプトソフト連携 (QO013)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo013;
import java.util.Stack;

import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACSQLSafeIntegerFormat;
import jp.nichicom.ac.text.ACSQLSafeStringFormat;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;

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
    StringBuilder sb = new StringBuilder();
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

    sb.append(",RECEIPT_ACCESS_SPACE.HOSPNUM");

    sb.append(",RECEIPT_ACCESS_SPACE.CHECKED");

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

    sb.append("AND");

    sb.append("(");

    sb.append(" RECEIPT_ACCESS_SPACE.LOCAL_IP");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("LOCAL_IP", sqlParam)));

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" RECEIPT_ACCESS_SPACE.SERIAL_ID");

    sb.append(" ");

    return sb.toString();
  }

  /**
   * 「利用者情報取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_PATIENT_INFO(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
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

    sb.append(",PTID");

    sb.append(",HOSPNUM");

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

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PTID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("HOSPNUM", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「患者情報チェックフラグ更新」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_UPDATE_RECEPT_INFO(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" RECEIPT_ACCESS_SPACE");

    sb.append(" SET");

    sb.append(" CHECKED");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CHECKED", sqlParam)));

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" RECEIPT_ACCESS_SPACE.LOCAL_IP");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("LOCAL_IP", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" SERIAL_ID");

    sb.append(" IN");

    sb.append(" (");

    inValues = (Object[])VRBindPathParser.get("SERIAL_ID", sqlParam);
    
    sb.append(ACSQLSafeIntegerFormat.getInstance().format(inValues[0]));

    for(int i=1; i<inValues.length; i++){
      sb.append(", ");
      
    sb.append(ACSQLSafeIntegerFormat.getInstance().format(inValues[i]));

    }

    sb.append(")");

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「チェックされている患者情報取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_RECEPT_INFO_ALL_CHECKED(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
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

    sb.append(",RECEIPT_ACCESS_SPACE.HOSPNUM");

    sb.append(",RECEIPT_ACCESS_SPACE.CHECKED");

    sb.append(" FROM");

    sb.append(" RECEIPT_ACCESS_SPACE");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" RECEIPT_ACCESS_SPACE.LOCAL_IP");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("LOCAL_IP", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" RECEIPT_ACCESS_SPACE.CHECKED");

    sb.append(" =");

    sb.append(" 1");

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「患者情報チェックフラグ全件更新」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_UPDATE_RECEPT_INFO_ALL(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" RECEIPT_ACCESS_SPACE");

    sb.append(" SET");

    sb.append(" CHECKED");

    sb.append(" =");

    sb.append(" 0");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" RECEIPT_ACCESS_SPACE.LOCAL_IP");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("LOCAL_IP", sqlParam)));

    sb.append(")");

    return sb.toString();
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
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" INSURER_ID");

    sb.append(",INSURER_NAME");

    sb.append(",INSURER_TYPE");

    sb.append(",DELETE_FLAG");

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
   * 「保険者情報を復活させる。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_UPDATE_INSURER_INFO(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" INSURER");

    sb.append(" SET");

    sb.append(" DELETE_FLAG");

    sb.append(" =");

    sb.append(" 0");

    sb.append(",");

    sb.append(" LAST_TIME");

    sb.append(" =");

    sb.append(" CURRENT_TIMESTAMP");

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
   * 「保険者の情報を登録する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_INSERT_INSURER_INFO(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("INSERT INTO");

    sb.append(" INSURER");

    sb.append("(");

    sb.append(" INSURER_ID");

    sb.append(",INSURER_NAME");

    sb.append(",INSURER_TYPE");

    sb.append(",DELETE_FLAG");

    sb.append(",LAST_TIME");

    sb.append(")VALUES(");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_NAME", sqlParam)));

    sb.append(",");

    sb.append(" 1");

    sb.append(",");

    sb.append(" 0");

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「保険者マスタを検索する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_FIND_M_INSURER_INFO(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" INSURER_NAME");

    sb.append(",INSURER_NO");

    sb.append(" FROM");

    sb.append(" M_INSURER");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" INSURER_NO");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

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

    sb.append(" 0");

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(",");

    sb.append(" 1");

    sb.append(",");

    sb.append(" 0");

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

    sb.append(" 0");

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

    sb.append(" 1");

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SHORTSTAY_USE_INIT_COUNT", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

}
