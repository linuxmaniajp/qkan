
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
 * 開発者: 訪問看護記録書Ⅰ
 * 作成日: 2006/03/19  日本コンピューター株式会社 訪問看護記録書Ⅰ 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 帳票管理 (C)
 * プロセス 訪問看護記録書Ⅰ (004 )
 * プログラム 訪問看護記録書Ⅰ (QC004)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qc.qc004 ;
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
 * 訪問看護記録書ⅠSQL定義(QC004) 
 */
public class QC004SQL extends QC004State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * コンストラクタです。
   */
  public QC004SQL() {
  }

  /**
   * 「訪問看護の記録書Ⅰ情報を取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_HOMONKANGO_KIROKUSHO(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT_ID");

    sb.append(",TARGET_DATE");

    sb.append(",NURSE_NAME");

    sb.append(",FIRST_VISIT_DATE");

    sb.append(",FIRST_VISIT_DATE_START");

    sb.append(",FIRST_VISIT_DATE_END");

    sb.append(",DISEASE");

    sb.append(",BYOJO_CHIYU_JOTAI");

    sb.append(",GENBYOREKI");

    sb.append(",KIOREKI");

    sb.append(",SEIKATSUREKI");

    sb.append(",FAMILY_NAME1");

    sb.append(",FAMILY_AGE1");

    sb.append(",FAMILY_RELATION1");

    sb.append(",FAMILY_JOB1");

    sb.append(",FAMILY_COMMENT1");

    sb.append(",FAMILY_NAME2");

    sb.append(",FAMILY_AGE2");

    sb.append(",FAMILY_RELATION2");

    sb.append(",FAMILY_JOB2");

    sb.append(",FAMILY_COMMENT2");

    sb.append(",FAMILY_NAME3");

    sb.append(",FAMILY_AGE3");

    sb.append(",FAMILY_RELATION3");

    sb.append(",FAMILY_JOB3");

    sb.append(",FAMILY_COMMENT3");

    sb.append(",FAMILY_NAME4");

    sb.append(",FAMILY_AGE4");

    sb.append(",FAMILY_RELATION4");

    sb.append(",FAMILY_JOB4");

    sb.append(",FAMILY_COMMENT4");

    sb.append(",FAMILY_NAME5");

    sb.append(",FAMILY_AGE5");

    sb.append(",FAMILY_RELATION5");

    sb.append(",FAMILY_JOB5");

    sb.append(",FAMILY_COMMENT5");

    sb.append(",FAMILY_NAME6");

    sb.append(",FAMILY_AGE6");

    sb.append(",FAMILY_RELATION6");

    sb.append(",FAMILY_JOB6");

    sb.append(",FAMILY_COMMENT6");

    sb.append(",CAREGIVER");

    sb.append(",HOUSE");

    sb.append(",PURPOSE");

    sb.append(",DOCTOR_NAME");

    sb.append(",MEDICAL_FACILITY_NAME");

    sb.append(",MEDICAL_FACILITY_ADDRESS");

    sb.append(",MEDICAL_FACILITY_TEL_FIRST");

    sb.append(",MEDICAL_FACILITY_TEL_SECOND");

    sb.append(",MEDICAL_FACILITY_TEL_THIRD");

    sb.append(",ADL_MOVE");

    sb.append(",ADL_EXCRETION");

    sb.append(",ADL_CHANGE_CLOTH");

    sb.append(",ADL_FOOD");

    sb.append(",ADL_BATH");

    sb.append(",ADL_COSMETIC");

    sb.append(",ADL_COMMUNICATION");

    sb.append(",DOCTOR_RENRAKUSAKI");

    sb.append(",MEDICAL_RENRAKUSAKI1");

    sb.append(",MEDICAL_PREPARED1");

    sb.append(",MEDICAL_NOTE1");

    sb.append(",MEDICAL_RENRAKUSAKI2");

    sb.append(",MEDICAL_PREPARED2");

    sb.append(",MEDICAL_NOTE2");

    sb.append(",MEDICAL_RENRAKUSAKI3");

    sb.append(",MEDICAL_PREPARED3");

    sb.append(",MEDICAL_NOTE3");

    sb.append(",MEDICAL_RENRAKUSAKI4");

    sb.append(",MEDICAL_PREPARED4");

    sb.append(",MEDICAL_NOTE4");

    sb.append(",USED_STATE");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" HOMONKANGO_KIROKUSHO");

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
   * 「前月以前の訪問看護記録書Ⅰの」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_LAST_HOMONKANGO_KIROKUSHO(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT_ID");

    sb.append(",TARGET_DATE");

    sb.append(",NURSE_NAME");

    sb.append(",FIRST_VISIT_DATE");

    sb.append(",FIRST_VISIT_DATE_START");

    sb.append(",FIRST_VISIT_DATE_END");

    sb.append(",DISEASE");

    sb.append(",BYOJO_CHIYU_JOTAI");

    sb.append(",GENBYOREKI");

    sb.append(",KIOREKI");

    sb.append(",SEIKATSUREKI");

    sb.append(",FAMILY_NAME1");

    sb.append(",FAMILY_AGE1");

    sb.append(",FAMILY_RELATION1");

    sb.append(",FAMILY_JOB1");

    sb.append(",FAMILY_COMMENT1");

    sb.append(",FAMILY_NAME2");

    sb.append(",FAMILY_AGE2");

    sb.append(",FAMILY_RELATION2");

    sb.append(",FAMILY_JOB2");

    sb.append(",FAMILY_COMMENT2");

    sb.append(",FAMILY_NAME3");

    sb.append(",FAMILY_AGE3");

    sb.append(",FAMILY_RELATION3");

    sb.append(",FAMILY_JOB3");

    sb.append(",FAMILY_COMMENT3");

    sb.append(",FAMILY_NAME4");

    sb.append(",FAMILY_AGE4");

    sb.append(",FAMILY_RELATION4");

    sb.append(",FAMILY_JOB4");

    sb.append(",FAMILY_COMMENT4");

    sb.append(",FAMILY_NAME5");

    sb.append(",FAMILY_AGE5");

    sb.append(",FAMILY_RELATION5");

    sb.append(",FAMILY_JOB5");

    sb.append(",FAMILY_COMMENT5");

    sb.append(",FAMILY_NAME6");

    sb.append(",FAMILY_AGE6");

    sb.append(",FAMILY_RELATION6");

    sb.append(",FAMILY_JOB6");

    sb.append(",FAMILY_COMMENT6");

    sb.append(",CAREGIVER");

    sb.append(",HOUSE");

    sb.append(",PURPOSE");

    sb.append(",DOCTOR_NAME");

    sb.append(",MEDICAL_FACILITY_NAME");

    sb.append(",MEDICAL_FACILITY_ADDRESS");

    sb.append(",MEDICAL_FACILITY_TEL_FIRST");

    sb.append(",MEDICAL_FACILITY_TEL_SECOND");

    sb.append(",MEDICAL_FACILITY_TEL_THIRD");

    sb.append(",ADL_MOVE");

    sb.append(",ADL_EXCRETION");

    sb.append(",ADL_CHANGE_CLOTH");

    sb.append(",ADL_FOOD");

    sb.append(",ADL_BATH");

    sb.append(",ADL_COSMETIC");

    sb.append(",ADL_COMMUNICATION");

    sb.append(",DOCTOR_RENRAKUSAKI");

    sb.append(",MEDICAL_RENRAKUSAKI1");

    sb.append(",MEDICAL_PREPARED1");

    sb.append(",MEDICAL_NOTE1");

    sb.append(",MEDICAL_RENRAKUSAKI2");

    sb.append(",MEDICAL_PREPARED2");

    sb.append(",MEDICAL_NOTE2");

    sb.append(",MEDICAL_RENRAKUSAKI3");

    sb.append(",MEDICAL_PREPARED3");

    sb.append(",MEDICAL_NOTE3");

    sb.append(",MEDICAL_RENRAKUSAKI4");

    sb.append(",MEDICAL_PREPARED4");

    sb.append(",MEDICAL_NOTE4");

    sb.append(",USED_STATE");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" HOMONKANGO_KIROKUSHO");

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

    sb.append(" HOMONKANGO_KIROKUSHO");

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
   * 「訪問看護記録書Ⅰの情報を」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_INSERT_KIROKUSHO(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("INSERT INTO");

    sb.append(" HOMONKANGO_KIROKUSHO");

    sb.append("(");

    sb.append(" PATIENT_ID");

    sb.append(",TARGET_DATE");

    sb.append(",NURSE_NAME");

    sb.append(",FIRST_VISIT_DATE");

    sb.append(",FIRST_VISIT_DATE_START");

    sb.append(",FIRST_VISIT_DATE_END");

    sb.append(",DISEASE");

    sb.append(",BYOJO_CHIYU_JOTAI");

    sb.append(",GENBYOREKI");

    sb.append(",KIOREKI");

    sb.append(",SEIKATSUREKI");

    sb.append(",FAMILY_NAME1");

    sb.append(",FAMILY_AGE1");

    sb.append(",FAMILY_RELATION1");

    sb.append(",FAMILY_JOB1");

    sb.append(",FAMILY_COMMENT1");

    sb.append(",FAMILY_NAME2");

    sb.append(",FAMILY_AGE2");

    sb.append(",FAMILY_RELATION2");

    sb.append(",FAMILY_JOB2");

    sb.append(",FAMILY_COMMENT2");

    sb.append(",FAMILY_NAME3");

    sb.append(",FAMILY_AGE3");

    sb.append(",FAMILY_RELATION3");

    sb.append(",FAMILY_JOB3");

    sb.append(",FAMILY_COMMENT3");

    sb.append(",FAMILY_NAME4");

    sb.append(",FAMILY_AGE4");

    sb.append(",FAMILY_RELATION4");

    sb.append(",FAMILY_JOB4");

    sb.append(",FAMILY_COMMENT4");

    sb.append(",FAMILY_NAME5");

    sb.append(",FAMILY_AGE5");

    sb.append(",FAMILY_RELATION5");

    sb.append(",FAMILY_JOB5");

    sb.append(",FAMILY_COMMENT5");

    sb.append(",FAMILY_NAME6");

    sb.append(",FAMILY_AGE6");

    sb.append(",FAMILY_RELATION6");

    sb.append(",FAMILY_JOB6");

    sb.append(",FAMILY_COMMENT6");

    sb.append(",CAREGIVER");

    sb.append(",HOUSE");

    sb.append(",PURPOSE");

    sb.append(",DOCTOR_NAME");

    sb.append(",MEDICAL_FACILITY_NAME");

    sb.append(",MEDICAL_FACILITY_ADDRESS");

    sb.append(",MEDICAL_FACILITY_TEL_FIRST");

    sb.append(",MEDICAL_FACILITY_TEL_SECOND");

    sb.append(",MEDICAL_FACILITY_TEL_THIRD");

    sb.append(",ADL_MOVE");

    sb.append(",ADL_EXCRETION");

    sb.append(",ADL_CHANGE_CLOTH");

    sb.append(",ADL_FOOD");

    sb.append(",ADL_BATH");

    sb.append(",ADL_COSMETIC");

    sb.append(",ADL_COMMUNICATION");

    sb.append(",DOCTOR_RENRAKUSAKI");

    sb.append(",MEDICAL_RENRAKUSAKI1");

    sb.append(",MEDICAL_PREPARED1");

    sb.append(",MEDICAL_NOTE1");

    sb.append(",MEDICAL_RENRAKUSAKI2");

    sb.append(",MEDICAL_PREPARED2");

    sb.append(",MEDICAL_NOTE2");

    sb.append(",MEDICAL_RENRAKUSAKI3");

    sb.append(",MEDICAL_PREPARED3");

    sb.append(",MEDICAL_NOTE3");

    sb.append(",MEDICAL_RENRAKUSAKI4");

    sb.append(",MEDICAL_PREPARED4");

    sb.append(",MEDICAL_NOTE4");

    sb.append(",USED_STATE");

    sb.append(",LAST_TIME");

    sb.append(")VALUES(");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("NURSE_NAME", sqlParam)));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("FIRST_VISIT_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("FIRST_VISIT_DATE_START", sqlParam), "HH:mm"));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("FIRST_VISIT_DATE_END", sqlParam), "HH:mm"));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("DISEASE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BYOJO_CHIYU_JOTAI", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("GENBYOREKI", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("KIOREKI", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SEIKATSUREKI", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_NAME1", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("FAMILY_AGE1", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_RELATION1", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_JOB1", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_COMMENT1", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_NAME2", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("FAMILY_AGE2", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_RELATION2", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_JOB2", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_COMMENT2", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_NAME3", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("FAMILY_AGE3", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_RELATION3", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_JOB3", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_COMMENT3", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_NAME4", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("FAMILY_AGE4", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_RELATION4", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_JOB4", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_COMMENT4", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_NAME5", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("FAMILY_AGE5", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_RELATION5", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_JOB5", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_COMMENT5", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_NAME6", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("FAMILY_AGE6", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_RELATION6", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_JOB6", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_COMMENT6", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("CAREGIVER", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("HOUSE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PURPOSE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("DOCTOR_NAME", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_FACILITY_NAME", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_FACILITY_ADDRESS", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_FACILITY_TEL_FIRST", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_FACILITY_TEL_SECOND", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_FACILITY_TEL_THIRD", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("ADL_MOVE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("ADL_EXCRETION", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("ADL_CHANGE_CLOTH", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("ADL_FOOD", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("ADL_BATH", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("ADL_COSMETIC", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("ADL_COMMUNICATION", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("DOCTOR_RENRAKUSAKI", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_RENRAKUSAKI1", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_PREPARED1", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_NOTE1", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_RENRAKUSAKI2", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_PREPARED2", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_NOTE2", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_RENRAKUSAKI3", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_PREPARED3", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_NOTE3", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_RENRAKUSAKI4", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_PREPARED4", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_NOTE4", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("USED_STATE", sqlParam)));

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「訪問看護記録書Ⅰ情報を更新する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_UPDATE_KIROKUSHO(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" HOMONKANGO_KIROKUSHO");

    sb.append(" SET");

    sb.append(" PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(",");

    sb.append(" TARGET_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(" NURSE_NAME");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("NURSE_NAME", sqlParam)));

    sb.append(",");

    sb.append(" FIRST_VISIT_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("FIRST_VISIT_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(" FIRST_VISIT_DATE_START");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("FIRST_VISIT_DATE_START", sqlParam), "HH:mm"));

    sb.append(",");

    sb.append(" FIRST_VISIT_DATE_END");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("FIRST_VISIT_DATE_END", sqlParam), "HH:mm"));

    sb.append(",");

    sb.append(" DISEASE");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("DISEASE", sqlParam)));

    sb.append(",");

    sb.append(" BYOJO_CHIYU_JOTAI");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BYOJO_CHIYU_JOTAI", sqlParam)));

    sb.append(",");

    sb.append(" GENBYOREKI");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("GENBYOREKI", sqlParam)));

    sb.append(",");

    sb.append(" KIOREKI");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("KIOREKI", sqlParam)));

    sb.append(",");

    sb.append(" SEIKATSUREKI");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SEIKATSUREKI", sqlParam)));

    sb.append(",");

    sb.append(" FAMILY_NAME1");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_NAME1", sqlParam)));

    sb.append(",");

    sb.append(" FAMILY_AGE1");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("FAMILY_AGE1", sqlParam)));

    sb.append(",");

    sb.append(" FAMILY_RELATION1");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_RELATION1", sqlParam)));

    sb.append(",");

    sb.append(" FAMILY_JOB1");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_JOB1", sqlParam)));

    sb.append(",");

    sb.append(" FAMILY_COMMENT1");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_COMMENT1", sqlParam)));

    sb.append(",");

    sb.append(" FAMILY_NAME2");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_NAME2", sqlParam)));

    sb.append(",");

    sb.append(" FAMILY_AGE2");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("FAMILY_AGE2", sqlParam)));

    sb.append(",");

    sb.append(" FAMILY_RELATION2");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_RELATION2", sqlParam)));

    sb.append(",");

    sb.append(" FAMILY_JOB2");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_JOB2", sqlParam)));

    sb.append(",");

    sb.append(" FAMILY_COMMENT2");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_COMMENT2", sqlParam)));

    sb.append(",");

    sb.append(" FAMILY_NAME3");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_NAME3", sqlParam)));

    sb.append(",");

    sb.append(" FAMILY_AGE3");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("FAMILY_AGE3", sqlParam)));

    sb.append(",");

    sb.append(" FAMILY_RELATION3");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_RELATION3", sqlParam)));

    sb.append(",");

    sb.append(" FAMILY_JOB3");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_JOB3", sqlParam)));

    sb.append(",");

    sb.append(" FAMILY_COMMENT3");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_COMMENT3", sqlParam)));

    sb.append(",");

    sb.append(" FAMILY_NAME4");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_NAME4", sqlParam)));

    sb.append(",");

    sb.append(" FAMILY_AGE4");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("FAMILY_AGE4", sqlParam)));

    sb.append(",");

    sb.append(" FAMILY_RELATION4");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_RELATION4", sqlParam)));

    sb.append(",");

    sb.append(" FAMILY_JOB4");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_JOB4", sqlParam)));

    sb.append(",");

    sb.append(" FAMILY_COMMENT4");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_COMMENT4", sqlParam)));

    sb.append(",");

    sb.append(" FAMILY_NAME5");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_NAME5", sqlParam)));

    sb.append(",");

    sb.append(" FAMILY_AGE5");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("FAMILY_AGE5", sqlParam)));

    sb.append(",");

    sb.append(" FAMILY_RELATION5");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_RELATION5", sqlParam)));

    sb.append(",");

    sb.append(" FAMILY_JOB5");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_JOB5", sqlParam)));

    sb.append(",");

    sb.append(" FAMILY_COMMENT5");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_COMMENT5", sqlParam)));

    sb.append(",");

    sb.append(" FAMILY_NAME6");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_NAME6", sqlParam)));

    sb.append(",");

    sb.append(" FAMILY_AGE6");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("FAMILY_AGE6", sqlParam)));

    sb.append(",");

    sb.append(" FAMILY_RELATION6");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_RELATION6", sqlParam)));

    sb.append(",");

    sb.append(" FAMILY_JOB6");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_JOB6", sqlParam)));

    sb.append(",");

    sb.append(" FAMILY_COMMENT6");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("FAMILY_COMMENT6", sqlParam)));

    sb.append(",");

    sb.append(" CAREGIVER");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("CAREGIVER", sqlParam)));

    sb.append(",");

    sb.append(" HOUSE");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("HOUSE", sqlParam)));

    sb.append(",");

    sb.append(" PURPOSE");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PURPOSE", sqlParam)));

    sb.append(",");

    sb.append(" DOCTOR_NAME");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("DOCTOR_NAME", sqlParam)));

    sb.append(",");

    sb.append(" MEDICAL_FACILITY_NAME");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_FACILITY_NAME", sqlParam)));

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

    sb.append(" ADL_MOVE");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("ADL_MOVE", sqlParam)));

    sb.append(",");

    sb.append(" ADL_EXCRETION");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("ADL_EXCRETION", sqlParam)));

    sb.append(",");

    sb.append(" ADL_CHANGE_CLOTH");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("ADL_CHANGE_CLOTH", sqlParam)));

    sb.append(",");

    sb.append(" ADL_FOOD");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("ADL_FOOD", sqlParam)));

    sb.append(",");

    sb.append(" ADL_BATH");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("ADL_BATH", sqlParam)));

    sb.append(",");

    sb.append(" ADL_COSMETIC");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("ADL_COSMETIC", sqlParam)));

    sb.append(",");

    sb.append(" ADL_COMMUNICATION");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("ADL_COMMUNICATION", sqlParam)));

    sb.append(",");

    sb.append(" DOCTOR_RENRAKUSAKI");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("DOCTOR_RENRAKUSAKI", sqlParam)));

    sb.append(",");

    sb.append(" MEDICAL_RENRAKUSAKI1");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_RENRAKUSAKI1", sqlParam)));

    sb.append(",");

    sb.append(" MEDICAL_PREPARED1");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_PREPARED1", sqlParam)));

    sb.append(",");

    sb.append(" MEDICAL_NOTE1");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_NOTE1", sqlParam)));

    sb.append(",");

    sb.append(" MEDICAL_RENRAKUSAKI2");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_RENRAKUSAKI2", sqlParam)));

    sb.append(",");

    sb.append(" MEDICAL_PREPARED2");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_PREPARED2", sqlParam)));

    sb.append(",");

    sb.append(" MEDICAL_NOTE2");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_NOTE2", sqlParam)));

    sb.append(",");

    sb.append(" MEDICAL_RENRAKUSAKI3");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_RENRAKUSAKI3", sqlParam)));

    sb.append(",");

    sb.append(" MEDICAL_PREPARED3");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_PREPARED3", sqlParam)));

    sb.append(",");

    sb.append(" MEDICAL_NOTE3");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_NOTE3", sqlParam)));

    sb.append(",");

    sb.append(" MEDICAL_RENRAKUSAKI4");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_RENRAKUSAKI4", sqlParam)));

    sb.append(",");

    sb.append(" MEDICAL_PREPARED4");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_PREPARED4", sqlParam)));

    sb.append(",");

    sb.append(" MEDICAL_NOTE4");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_NOTE4", sqlParam)));

    sb.append(",");

    sb.append(" USED_STATE");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("USED_STATE", sqlParam)));

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

    sb.append("AND");

    sb.append("(");

    sb.append(" TARGET_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「医療機関の事業所情報を取得する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_PROVIDER_INFO(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PROVIDER_ID");

    sb.append(",PROVIDER_NAME");

    sb.append(",PROVIDER_ADDRESS");

    sb.append(",PROVIDER_TEL_FIRST");

    sb.append(",PROVIDER_TEL_SECOND");

    sb.append(",PROVIDER_TEL_THIRD");

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
   * 「医療機関情報を取得する処理」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_MEDICAL_FACILITY(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" MEDICAL_FACILITY_ID");

    sb.append(",MEDICAL_FACILITY_NAME");

    sb.append(",MEDICAL_FACILITY_TEL_FIRST");

    sb.append(",MEDICAL_FACILITY_TEL_SECOND");

    sb.append(",MEDICAL_FACILITY_TEL_THIRD");

    sb.append(",MEDICAL_FACILITY_ZIP_FIRST");

    sb.append(",MEDICAL_FACILITY_ZIP_SECOND");

    sb.append(",MEDICAL_FACILITY_ADDRESS");

    sb.append(",MEDICAL_FACILITY_FAX_FIRST");

    sb.append(",MEDICAL_FACILITY_FAX_SECOND");

    sb.append(",MEDICAL_FACILITY_FAX_THIRD");

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
   * 「利用者登録医療機関情報を取得する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_PATIENT_STATION_HISTORY(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT_STATION_HISTORY.MEDICAL_FACILITY_ID");

    sb.append(",PATIENT_STATION_HISTORY.DOCTOR_NAME");

    sb.append(",MEDICAL_FACILITY.MEDICAL_FACILITY_NAME");

    sb.append(",MEDICAL_FACILITY.MEDICAL_FACILITY_TEL_FIRST");

    sb.append(",MEDICAL_FACILITY.MEDICAL_FACILITY_TEL_SECOND");

    sb.append(",MEDICAL_FACILITY.MEDICAL_FACILITY_TEL_THIRD");

    sb.append(",MEDICAL_FACILITY.MEDICAL_FACILITY_ADDRESS");

    sb.append(" FROM");

    sb.append(" PATIENT_STATION_HISTORY");

    sb.append(",MEDICAL_FACILITY");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_STATION_HISTORY.MEDICAL_FACILITY_ID");

    sb.append(" =");

    sb.append(" MEDICAL_FACILITY.MEDICAL_FACILITY_ID");

    sb.append(")");

    sb.append("AND ");

    sb.append("(");

    sb.append(" PATIENT_STATION_HISTORY.PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" PATIENT_STATION_HISTORY.STATION_HISTORY_ID");

    sb.append(" DESC");

    return sb.toString();
  }

}
