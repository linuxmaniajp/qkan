
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
 * 開発者: 在宅療養生活のポイント
 * 作成日: 2007/12/26  日本コンピューター株式会社 在宅療養生活のポイント 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 帳票管理 (C)
 * プロセス 在宅療養生活のポイント (005)
 * プログラム 在宅療養生活のポイント (QC005)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qc.qc005;
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
 * 在宅療養生活のポイントSQL定義(QC005) 
 */
public class QC005SQL extends QC005State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * コンストラクタです。
   */
  public QC005SQL() {
  }

  /**
   * 「在宅療養生活のポイント情報を取得する」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_KYOTAKU_RYOYO(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT_ID");

    sb.append(",TARGET_DATE");

    sb.append(",JOTAI_CODE");

    sb.append(",SHOGAI_JIRITSUDO");

    sb.append(",NINCHISHO_JIRITSUDO");

    sb.append(",PATIENT_ADDRESS");

    sb.append(",PATIENT_TEL_FIRST");

    sb.append(",PATIENT_TEL_SECOND");

    sb.append(",PATIENT_TEL_THIRD");

    sb.append(",CREATE_DATE_ZAITAKU");

    sb.append(",VISIT_THIS_MONTH_NO1");

    sb.append(",VISIT_THIS_MONTH_NO2");

    sb.append(",VISIT_THIS_MONTH_NO3");

    sb.append(",VISIT_THIS_MONTH_NO4");

    sb.append(",VISIT_THIS_MONTH_NO5");

    sb.append(",VISIT_THIS_MONTH_NO6");

    sb.append(",VISIT_NEXT_MONTH_NO1");

    sb.append(",VISIT_NEXT_MONTH_NO2");

    sb.append(",VISIT_NEXT_MONTH_NO3");

    sb.append(",VISIT_NEXT_MONTH_NO4");

    sb.append(",VISIT_NEXT_MONTH_NO5");

    sb.append(",VISIT_NEXT_MONTH_NO6");

    sb.append(",ADVICE_MONTH");

    sb.append(",ADVICE");

    sb.append(",MEDICAL_FACILITY_NAME");

    sb.append(",DOCTOR_NAME");

    sb.append(",MEDICAL_FACILITY_ADDRESS");

    sb.append(",MEDICAL_FACILITY_TEL_FIRST");

    sb.append(",MEDICAL_FACILITY_TEL_SECOND");

    sb.append(",MEDICAL_FACILITY_TEL_THIRD");

    sb.append(",SENMONIN");

    sb.append(",PROVIDER_NAME");

    sb.append(",CREATE_DATE_KYOTAKU");

    sb.append(",CONDITION");

    sb.append(",CONDITION_PASSAGE");

    sb.append(",NOTE_OF_KAIGO_SERVICE");

    sb.append(",NOTE_OF_DAILY_LIFE");

    sb.append(",REMARKS");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" KYOTAKU_RYOYO");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" TARGET_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「在宅療養生活のポイント情報のうち、過去の直近の情報を取得する」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_LAST_KYOTAKU_RYOYO(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT_ID");

    sb.append(",TARGET_DATE");

    sb.append(",JOTAI_CODE");

    sb.append(",SHOGAI_JIRITSUDO");

    sb.append(",NINCHISHO_JIRITSUDO");

    sb.append(",PATIENT_ADDRESS");

    sb.append(",PATIENT_TEL_FIRST");

    sb.append(",PATIENT_TEL_SECOND");

    sb.append(",PATIENT_TEL_THIRD");

    sb.append(",CREATE_DATE_ZAITAKU");

    sb.append(",VISIT_THIS_MONTH_NO1");

    sb.append(",VISIT_THIS_MONTH_NO2");

    sb.append(",VISIT_THIS_MONTH_NO3");

    sb.append(",VISIT_THIS_MONTH_NO4");

    sb.append(",VISIT_THIS_MONTH_NO5");

    sb.append(",VISIT_THIS_MONTH_NO6");

    sb.append(",VISIT_NEXT_MONTH_NO1");

    sb.append(",VISIT_NEXT_MONTH_NO2");

    sb.append(",VISIT_NEXT_MONTH_NO3");

    sb.append(",VISIT_NEXT_MONTH_NO4");

    sb.append(",VISIT_NEXT_MONTH_NO5");

    sb.append(",VISIT_NEXT_MONTH_NO6");

    sb.append(",ADVICE_MONTH");

    sb.append(",ADVICE");

    sb.append(",MEDICAL_FACILITY_NAME");

    sb.append(",DOCTOR_NAME");

    sb.append(",MEDICAL_FACILITY_ADDRESS");

    sb.append(",MEDICAL_FACILITY_TEL_FIRST");

    sb.append(",MEDICAL_FACILITY_TEL_SECOND");

    sb.append(",MEDICAL_FACILITY_TEL_THIRD");

    sb.append(",SENMONIN");

    sb.append(",PROVIDER_NAME");

    sb.append(",CREATE_DATE_KYOTAKU");

    sb.append(",CONDITION");

    sb.append(",CONDITION_PASSAGE");

    sb.append(",NOTE_OF_KAIGO_SERVICE");

    sb.append(",NOTE_OF_DAILY_LIFE");

    sb.append(",REMARKS");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" KYOTAKU_RYOYO");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" TARGET_DATE");

    sb.append(" =");

    sb.append(" (");

    sb.append("SELECT");

    sb.append(" MAX(TARGET_DATE)");

    sb.append(" FROM");

    sb.append(" KYOTAKU_RYOYO");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" TARGET_DATE");

    sb.append(" <");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(")");

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「在宅療養生活のポイント情報を追加する」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_INSERT_KYOTAKU_RYOYO(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("INSERT INTO");

    sb.append(" KYOTAKU_RYOYO");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(",TARGET_DATE");

    sb.append(",JOTAI_CODE");

    sb.append(",SHOGAI_JIRITSUDO");

    sb.append(",NINCHISHO_JIRITSUDO");

    sb.append(",PATIENT_ADDRESS");

    sb.append(",PATIENT_TEL_FIRST");

    sb.append(",PATIENT_TEL_SECOND");

    sb.append(",PATIENT_TEL_THIRD");

    sb.append(",CREATE_DATE_ZAITAKU");

    sb.append(",VISIT_THIS_MONTH_NO1");

    sb.append(",VISIT_THIS_MONTH_NO2");

    sb.append(",VISIT_THIS_MONTH_NO3");

    sb.append(",VISIT_THIS_MONTH_NO4");

    sb.append(",VISIT_THIS_MONTH_NO5");

    sb.append(",VISIT_THIS_MONTH_NO6");

    sb.append(",VISIT_NEXT_MONTH_NO1");

    sb.append(",VISIT_NEXT_MONTH_NO2");

    sb.append(",VISIT_NEXT_MONTH_NO3");

    sb.append(",VISIT_NEXT_MONTH_NO4");

    sb.append(",VISIT_NEXT_MONTH_NO5");

    sb.append(",VISIT_NEXT_MONTH_NO6");

    sb.append(",ADVICE_MONTH");

    sb.append(",ADVICE");

    sb.append(",MEDICAL_FACILITY_NAME");

    sb.append(",DOCTOR_NAME");

    sb.append(",MEDICAL_FACILITY_ADDRESS");

    sb.append(",MEDICAL_FACILITY_TEL_FIRST");

    sb.append(",MEDICAL_FACILITY_TEL_SECOND");

    sb.append(",MEDICAL_FACILITY_TEL_THIRD");

    sb.append(",SENMONIN");

    sb.append(",PROVIDER_NAME");

    sb.append(",CREATE_DATE_KYOTAKU");

    sb.append(",CONDITION");

    sb.append(",CONDITION_PASSAGE");

    sb.append(",NOTE_OF_KAIGO_SERVICE");

    sb.append(",NOTE_OF_DAILY_LIFE");

    sb.append(",REMARKS");

    sb.append(",LAST_TIME");

    sb.append(",FINISH_FLAG");

    sb.append(")VALUES(");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("JOTAI_CODE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SHOGAI_JIRITSUDO", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("NINCHISHO_JIRITSUDO", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_ADDRESS", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_TEL_FIRST", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_TEL_SECOND", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_TEL_THIRD", sqlParam)));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("CREATE_DATE_ZAITAKU", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("VISIT_THIS_MONTH_NO1", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("VISIT_THIS_MONTH_NO2", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("VISIT_THIS_MONTH_NO3", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("VISIT_THIS_MONTH_NO4", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("VISIT_THIS_MONTH_NO5", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("VISIT_THIS_MONTH_NO6", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("VISIT_NEXT_MONTH_NO1", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("VISIT_NEXT_MONTH_NO2", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("VISIT_NEXT_MONTH_NO3", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("VISIT_NEXT_MONTH_NO4", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("VISIT_NEXT_MONTH_NO5", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("VISIT_NEXT_MONTH_NO6", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("ADVICE_MONTH", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("ADVICE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_FACILITY_NAME", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("DOCTOR_NAME", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_FACILITY_ADDRESS", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_FACILITY_TEL_FIRST", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_FACILITY_TEL_SECOND", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_FACILITY_TEL_THIRD", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SENMONIN", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_NAME", sqlParam)));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("CREATE_DATE_KYOTAKU", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("CONDITION", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("CONDITION_PASSAGE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("NOTE_OF_KAIGO_SERVICE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("NOTE_OF_DAILY_LIFE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("REMARKS", sqlParam)));

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(",");

    sb.append(" 0");

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「在宅療養生活のポイント情報を更新する」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_UPDATE_KYOTAKU_RYOYO(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" KYOTAKU_RYOYO");

    sb.append(" SET");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(",");

    sb.append(" TARGET_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(" JOTAI_CODE");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("JOTAI_CODE", sqlParam)));

    sb.append(",");

    sb.append(" SHOGAI_JIRITSUDO");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SHOGAI_JIRITSUDO", sqlParam)));

    sb.append(",");

    sb.append(" NINCHISHO_JIRITSUDO");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("NINCHISHO_JIRITSUDO", sqlParam)));

    sb.append(",");

    sb.append(" PATIENT_ADDRESS");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_ADDRESS", sqlParam)));

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

    sb.append(" CREATE_DATE_ZAITAKU");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("CREATE_DATE_ZAITAKU", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(" VISIT_THIS_MONTH_NO1");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("VISIT_THIS_MONTH_NO1", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(" VISIT_THIS_MONTH_NO2");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("VISIT_THIS_MONTH_NO2", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(" VISIT_THIS_MONTH_NO3");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("VISIT_THIS_MONTH_NO3", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(" VISIT_THIS_MONTH_NO4");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("VISIT_THIS_MONTH_NO4", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(" VISIT_THIS_MONTH_NO5");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("VISIT_THIS_MONTH_NO5", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(" VISIT_THIS_MONTH_NO6");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("VISIT_THIS_MONTH_NO6", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(" VISIT_NEXT_MONTH_NO1");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("VISIT_NEXT_MONTH_NO1", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(" VISIT_NEXT_MONTH_NO2");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("VISIT_NEXT_MONTH_NO2", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(" VISIT_NEXT_MONTH_NO3");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("VISIT_NEXT_MONTH_NO3", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(" VISIT_NEXT_MONTH_NO4");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("VISIT_NEXT_MONTH_NO4", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(" VISIT_NEXT_MONTH_NO5");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("VISIT_NEXT_MONTH_NO5", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(" VISIT_NEXT_MONTH_NO6");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("VISIT_NEXT_MONTH_NO6", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(" ADVICE_MONTH");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("ADVICE_MONTH", sqlParam)));

    sb.append(",");

    sb.append(" ADVICE");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("ADVICE", sqlParam)));

    sb.append(",");

    sb.append(" MEDICAL_FACILITY_NAME");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_FACILITY_NAME", sqlParam)));

    sb.append(",");

    sb.append(" DOCTOR_NAME");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("DOCTOR_NAME", sqlParam)));

    sb.append(",");

    sb.append(" MEDICAL_FACILITY_ADDRESS");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_FACILITY_ADDRESS", sqlParam)));

    sb.append(",");

    sb.append(" MEDICAL_FACILITY_TEL_FIRST");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_FACILITY_TEL_FIRST", sqlParam)));

    sb.append(",");

    sb.append(" MEDICAL_FACILITY_TEL_SECOND");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_FACILITY_TEL_SECOND", sqlParam)));

    sb.append(",");

    sb.append(" MEDICAL_FACILITY_TEL_THIRD");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_FACILITY_TEL_THIRD", sqlParam)));

    sb.append(",");

    sb.append(" SENMONIN");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SENMONIN", sqlParam)));

    sb.append(",");

    sb.append(" PROVIDER_NAME");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_NAME", sqlParam)));

    sb.append(",");

    sb.append(" CREATE_DATE_KYOTAKU");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("CREATE_DATE_KYOTAKU", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(" CONDITION");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("CONDITION", sqlParam)));

    sb.append(",");

    sb.append(" CONDITION_PASSAGE");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("CONDITION_PASSAGE", sqlParam)));

    sb.append(",");

    sb.append(" NOTE_OF_KAIGO_SERVICE");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("NOTE_OF_KAIGO_SERVICE", sqlParam)));

    sb.append(",");

    sb.append(" NOTE_OF_DAILY_LIFE");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("NOTE_OF_DAILY_LIFE", sqlParam)));

    sb.append(",");

    sb.append(" REMARKS");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("REMARKS", sqlParam)));

    sb.append(",");

    sb.append(" LAST_TIME");

    sb.append(" =");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(",");

    sb.append(" FINISH_FLAG");

    sb.append(" =");

    sb.append(" 0");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" TARGET_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「医療機関を取得する」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_MEDICAL_PROVIDER(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PROVIDER_ID");

    sb.append(",MEDICAL_FLAG");

    sb.append(",PROVIDER_KANA");

    sb.append(",PROVIDER_NAME");

    sb.append(",PROVIDER_ZIP_FIRST");

    sb.append(",PROVIDER_ZIP_SECOND");

    sb.append(",PROVIDER_ADDRESS");

    sb.append(",PROVIDER_TEL_FIRST");

    sb.append(",PROVIDER_TEL_SECOND");

    sb.append(",PROVIDER_TEL_THIRD");

    sb.append(",PROVIDER_FAX_FIRST");

    sb.append(",PROVIDER_FAX_SECOND");

    sb.append(",PROVIDER_FAX_THIRD");

    sb.append(",PROVIDER_JIJIGYOUSHO_TYPE");

    sb.append(",PROVIDER_JIGYOU_TYPE");

    sb.append(",PROVIDER_AREA_TYPE");

    sb.append(",SPECIAL_AREA_FLAG");

    sb.append(",SHAFUKU_GENMEN_FLAG");

    sb.append(",PROVIDER_OWNER_NAME");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" PROVIDER");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" MEDICAL_FLAG");

    sb.append(" =");

    sb.append(" 1");

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「対象利用者の訪問看護ステーション履歴TABLE情報を取得する」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_PATIENT_STATION_HISTORY(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" MEDICAL_FACILITY_ID");

    sb.append(",DOCTOR_NAME");

    sb.append(" FROM");

    sb.append(" PATIENT_STATION_HISTORY");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" STATION_HISTORY_ID");

    sb.append(" =");

    sb.append(" 1");

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「医療機関マスタより医療機関名取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_MEDICAL_FACIRITY(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" MEDICAL_FACILITY_ID");

    sb.append(",MEDICAL_FACILITY_NAME");

    sb.append(",MEDICAL_FACILITY_TEL_FIRST");

    sb.append(",MEDICAL_FACILITY_TEL_SECOND");

    sb.append(",MEDICAL_FACILITY_TEL_THIRD");

    sb.append(",MEDICAL_FACILITY_ADDRESS");

    sb.append(" FROM");

    sb.append(" MEDICAL_FACILITY");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" DELETE_FLAG");

    sb.append(" <>");

    sb.append(" 1");

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「介護支援専門員情報の取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_CARE_MANAGER(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" STAFF.PROVIDER_ID");

    sb.append(",STAFF.STAFF_ID");

    sb.append(",STAFF.CARE_MANAGER_NO");

    sb.append(",STAFF.STAFF_FAMILY_NAME");

    sb.append(",STAFF.STAFF_FIRST_NAME");

    sb.append(" FROM");

    sb.append(" STAFF");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" STAFF.PROVIDER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" STAFF.STAFF_ID");

    sb.append(" ASC");

    return sb.toString();
  }

  /**
   * 「印刷済みフラグの取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_FINISH_FLAG(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" FINISH_FLAG");

    sb.append(" FROM");

    sb.append(" KYOTAKU_RYOYO");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" TARGET_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「印刷済みフラグの更新処理」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_UPDATE_FINISH_FLAG(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" KYOTAKU_RYOYO");

    sb.append(" SET");

    sb.append(" FINISH_FLAG");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("FINISH_FLAG", sqlParam)));

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" TARGET_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    return sb.toString();
  }

}
