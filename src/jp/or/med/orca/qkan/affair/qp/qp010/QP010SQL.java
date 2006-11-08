
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
 * 開発者: 利用者一覧(訪問看護療養費領収書)
 * 作成日: 2006/09/14  日本コンピューター株式会社 利用者一覧(訪問看護療養費領収書) 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 利用者一覧(訪問看護療養費領収書) (010)
 * プログラム 利用者一覧(訪問看護療養費領収書) (QP010)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp010;
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
 * 利用者一覧(訪問看護療養費領収書)SQL定義(QP010) 
 */
public class QP010SQL extends QP010State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * コンストラクタです。
   */
  public QP010SQL() {
  }

  /**
   * 「実績のある利用者を検索」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_SELECT_PATIENT(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" DISTINCT");

    sb.append(" PATIENT.PATIENT_ID");

    sb.append(",PATIENT.PATIENT_CODE");

    sb.append(",PATIENT.PATIENT_FAMILY_NAME");

    sb.append(",PATIENT.PATIENT_FIRST_NAME");

    sb.append(",PATIENT.PATIENT_FAMILY_KANA");

    sb.append(",PATIENT.PATIENT_FIRST_KANA");

    sb.append(",PATIENT.PATIENT_SEX");

    sb.append(",PATIENT.PATIENT_BIRTHDAY");

    sb.append(",(");

    sb.append("SELECT");

    sb.append(" FIRST 1");

    sb.append(" CASE");

    sb.append(" WHEN");

    sb.append(" PATIENT_MEDICAL_HISTORY.MEDICAL_LAW_NO");

    sb.append(" IS");

    sb.append(" NULL");

    sb.append(" THEN");

    sb.append(" PATIENT_MEDICAL_HISTORY.MEDICAL_INSURER_ID");

    sb.append(" ELSE");

    sb.append(" PATIENT_MEDICAL_HISTORY.MEDICAL_LAW_NO||PATIENT_MEDICAL_HISTORY.MEDICAL_INSURER_ID");

    sb.append(" END");

    sb.append(" FROM");

    sb.append(" PATIENT_MEDICAL_HISTORY");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT.PATIENT_ID");

    sb.append(" =");

    sb.append(" PATIENT_MEDICAL_HISTORY.PATIENT_ID");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append("(");

    sb.append("(");

    sb.append(" PATIENT_MEDICAL_HISTORY.MEDICAL_VALID_START");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE_START_DAY", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" PATIENT_MEDICAL_HISTORY.MEDICAL_VALID_END");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE_END_DAY", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(")");

    sb.append("OR");

    sb.append("(");

    sb.append("(");

    sb.append(" PATIENT_MEDICAL_HISTORY.MEDICAL_VALID_END");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE_START_DAY", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" PATIENT_MEDICAL_HISTORY.MEDICAL_VALID_START");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE_END_DAY", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(")");

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" PATIENT_MEDICAL_HISTORY.MEDICAL_VALID_START");

    sb.append(" DESC");

    sb.append(")");

    sb.append(" AS INSURER_ID");

    sb.append(",(");

    sb.append("SELECT");

    sb.append(" FIRST 1");

    sb.append(" PATIENT_MEDICAL_HISTORY.MEDICAL_INSURE_ID");

    sb.append(" FROM");

    sb.append(" PATIENT_MEDICAL_HISTORY");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT.PATIENT_ID");

    sb.append(" =");

    sb.append(" PATIENT_MEDICAL_HISTORY.PATIENT_ID");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append("(");

    sb.append("(");

    sb.append(" PATIENT_MEDICAL_HISTORY.MEDICAL_VALID_START");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE_START_DAY", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" PATIENT_MEDICAL_HISTORY.MEDICAL_VALID_END");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE_END_DAY", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(")");

    sb.append("OR");

    sb.append("(");

    sb.append("(");

    sb.append(" PATIENT_MEDICAL_HISTORY.MEDICAL_VALID_END");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE_START_DAY", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" PATIENT_MEDICAL_HISTORY.MEDICAL_VALID_START");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE_END_DAY", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(")");

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" PATIENT_MEDICAL_HISTORY.MEDICAL_VALID_START");

    sb.append(" DESC");

    sb.append(")");

    sb.append(" AS MEDICAL_INSURE_ID");

    sb.append(",(");

    sb.append("SELECT");

    sb.append(" FIRST 1");

    sb.append(" PATIENT_MEDICAL_HISTORY.INSURE_TYPE");

    sb.append(" FROM");

    sb.append(" PATIENT_MEDICAL_HISTORY");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT.PATIENT_ID");

    sb.append(" =");

    sb.append(" PATIENT_MEDICAL_HISTORY.PATIENT_ID");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append("(");

    sb.append("(");

    sb.append(" PATIENT_MEDICAL_HISTORY.MEDICAL_VALID_START");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE_START_DAY", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" PATIENT_MEDICAL_HISTORY.MEDICAL_VALID_END");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE_END_DAY", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(")");

    sb.append("OR");

    sb.append("(");

    sb.append("(");

    sb.append(" PATIENT_MEDICAL_HISTORY.MEDICAL_VALID_END");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE_START_DAY", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" PATIENT_MEDICAL_HISTORY.MEDICAL_VALID_START");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE_END_DAY", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(")");

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" PATIENT_MEDICAL_HISTORY.MEDICAL_VALID_START");

    sb.append(" DESC");

    sb.append(")");

    sb.append(" AS INSURE_TYPE");

    sb.append(" FROM");

    sb.append(" PATIENT");

    conditionStackOfFrom.push(new Boolean(firstConditionOfFrom));
    firstConditionOfFrom = false;

    if(VRBindPathParser.has("ONLY_EXISTS_RESULT", sqlParam)){

      if(firstConditionOfFrom){
        firstConditionOfFrom = false;
      }else{

    sb.append(",");

      }

    sb.append("SERVICE");

      }

      firstConditionOfFrom = ((Boolean)conditionStackOfFrom.pop()).booleanValue();

    conditionStack.push(new Boolean(firstCondition));
    firstCondition = true;

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }

    sb.append("(");

    sb.append(" PATIENT.SHOW_FLAG");

    sb.append(" =");

    sb.append(" 1");

    sb.append(")");

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }else{
        sb.append(" AND");

      }

    sb.append("(");

    sb.append(" PATIENT.DELETE_FLAG");

    sb.append(" =");

    sb.append(" 0");

    sb.append(")");

    if(
      VRBindPathParser.has("PATIENT_CODE", sqlParam)
    ){

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }else{
        sb.append(" AND");

      }

    sb.append("(");

    sb.append(" PATIENT.PATIENT_CODE");

    sb.append(" LIKE");

    sb.append(" ");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_CODE", sqlParam)+"%"));

    sb.append(")");

    }

    if(
      VRBindPathParser.has("PATIENT_KANA", sqlParam)
    ){

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }else{
        sb.append(" AND");

      }

    sb.append("(");

    sb.append(" CASE WHEN PATIENT_FAMILY_KANA IS NULL THEN '' ELSE PATIENT_FAMILY_KANA END ||'　'|| CASE WHEN PATIENT_FIRST_KANA IS NULL THEN '' ELSE PATIENT_FIRST_KANA END");

    sb.append(" LIKE");

    sb.append(" ");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PATIENT_KANA", sqlParam)+"%"));

    sb.append(")");

    }

    if(VRBindPathParser.has("ONLY_EXISTS_RESULT", sqlParam)){

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }else{
        sb.append(" AND (");

      }

    sb.append("(");

    sb.append(" PATIENT.PATIENT_ID");

    sb.append(" =");

    sb.append(" SERVICE.PATIENT_ID");

    sb.append(")");

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }else{
        sb.append(" AND");

      }

    sb.append("(");

    sb.append(" SERVICE.PATIENT_ID");

    sb.append(" IS NOT ");

    sb.append(" NULL");

    sb.append(")");

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }else{
        sb.append(" AND");

      }

    sb.append("(");

    sb.append(" SERVICE.SERVICE_USE_TYPE");

    sb.append(" =");

    sb.append(" 6");

    sb.append(")");

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }else{
        sb.append(" AND");

      }

    sb.append("(");

    sb.append(" SERVICE.PROVIDER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("LOGIN_PROVIDER_ID", sqlParam)));

    sb.append(")");

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }else{
        sb.append(" AND");

      }

    sb.append("(");

    sb.append(" SERVICE.SERVICE_DATE");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE_START_DAY", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }else{
        sb.append(" AND");

      }

    sb.append("(");

    sb.append(" SERVICE.SERVICE_DATE");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE_END_DAY", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }else{
        sb.append(" AND");

      }

    sb.append("(");

    sb.append(" SERVICE.SYSTEM_SERVICE_KIND_DETAIL");

    sb.append(" =");

    sb.append(" 20101");

    sb.append(")");

    sb.append(")");

    }

    firstCondition = ((Boolean)conditionStack.pop()).booleanValue();

    sb.append(" ORDER BY");

    sb.append(" PATIENT.PATIENT_FAMILY_KANA");

    sb.append(" ");

    sb.append(",PATIENT.PATIENT_FIRST_KANA");

    return sb.toString();
  }

}
