
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
import java.util.Stack;

import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACSQLSafeStringFormat;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;

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
    StringBuilder sb = new StringBuilder();
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
    StringBuilder sb = new StringBuilder();
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
    StringBuilder sb = new StringBuilder();
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
