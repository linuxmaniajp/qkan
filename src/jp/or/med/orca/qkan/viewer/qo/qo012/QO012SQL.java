
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
 * 開発者: 
 * 作成日: 2006/04/17  日本コンピューター株式会社  新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム  (O)
 * プロセス  (012)
 * プログラム  (QO012)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.viewer.qo.qo012;
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
 * SQL定義(QO012) 
 */
public class QO012SQL extends QO012Design {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * コンストラクタです。
   */
  public QO012SQL() {
  }

  /**
   * 「事業所情報を取得する」のためのSQLを返します。
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

    sb.append(" FROM");

    sb.append(" PROVIDER");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PROVIDER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「利用者情報と被保険者番号を取得する」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_PATIENT_INFO(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT.PATIENT_ID");

    sb.append(",PATIENT.PATIENT_FAMILY_NAME");

    sb.append(",PATIENT.PATIENT_FIRST_NAME");

    sb.append(",PATIENT_NINTEI_HISTORY.INSURED_ID");

    sb.append(",PATIENT_NINTEI_HISTORY.INSURE_VALID_START");

    sb.append(",PATIENT_NINTEI_HISTORY.INSURE_VALID_END");

    sb.append(" FROM");

    sb.append(" PATIENT");

    sb.append(" LEFT JOIN");

    sb.append(" PATIENT_NINTEI_HISTORY");

    sb.append(" ON");

    sb.append("(");

    sb.append(" PATIENT.PATIENT_ID");

    sb.append(" =");

    sb.append(" PATIENT_NINTEI_HISTORY.PATIENT_ID");

    sb.append(")");

    sb.append(" WHERE");

    sb.append("(");

    sb.append("(");

    sb.append("(");

    sb.append(" PATIENT_NINTEI_HISTORY.INSURE_VALID_START");

    sb.append("  <= ");

    sb.append(dateFormat.format(VRBindPathParser.get("START_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" PATIENT_NINTEI_HISTORY.INSURE_VALID_END");

    sb.append("  >=");

    sb.append(dateFormat.format(VRBindPathParser.get("START_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(")");

    sb.append("OR");

    sb.append("(");

    sb.append("(");

    sb.append(" PATIENT_NINTEI_HISTORY.INSURE_VALID_START");

    sb.append(" <= ");

    sb.append(dateFormat.format(VRBindPathParser.get("END_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" PATIENT_NINTEI_HISTORY.INSURE_VALID_END");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("END_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(")");

    sb.append("OR");

    sb.append("(");

    sb.append("(");

    sb.append(" PATIENT_NINTEI_HISTORY.INSURE_VALID_START");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("START_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" PATIENT_NINTEI_HISTORY.INSURE_VALID_END");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("END_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(")");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append("(");

    sb.append(" PATIENT_NINTEI_HISTORY.INSURED_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURED_ID", sqlParam)));

    sb.append(")");
    
    //[ID:0000623][Shin Fujihara] 2010/11 add begin 2010年度対応
    sb.append("AND");
    
    sb.append("(");
    
    sb.append(" PATIENT_NINTEI_HISTORY.INSURER_ID");
    
    sb.append(" =");
    
    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));
    
    sb.append(")");
    //[ID:0000623][Shin Fujihara] 2010/11 add end 2010年度対応

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「利用者情報を取得する」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_PATIENT_INFO_MANAGEMENT(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" PATIENT.PATIENT_ID");

    sb.append(",PATIENT.PATIENT_FAMILY_NAME");

    sb.append(",PATIENT.PATIENT_FIRST_NAME");

    sb.append(",PATIENT_NINTEI_HISTORY.INSURED_ID");

    sb.append(",PATIENT_NINTEI_HISTORY.INSURE_VALID_START");

    sb.append(",PATIENT_NINTEI_HISTORY.INSURE_VALID_END");

    sb.append(" FROM");

    sb.append(" PATIENT");

    sb.append(" LEFT JOIN");

    sb.append(" PATIENT_NINTEI_HISTORY");

    sb.append(" ON");

    sb.append("(");

    sb.append(" PATIENT.PATIENT_ID");

    sb.append(" =");

    sb.append(" PATIENT_NINTEI_HISTORY.PATIENT_ID");

    sb.append(")");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_NINTEI_HISTORY.INSURED_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURED_ID", sqlParam)));

    sb.append(")");
    
    
    //[ID:0000623][Shin Fujihara] 2010/11 add begin 2010年度対応
    sb.append(" AND (");

    sb.append(" PATIENT_NINTEI_HISTORY.INSURER_ID");

    sb.append(" =");
    
    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

    sb.append(")");
    //[ID:0000623][Shin Fujihara] 2010/11 add end 2010年度対応

    return sb.toString();
  }

}
