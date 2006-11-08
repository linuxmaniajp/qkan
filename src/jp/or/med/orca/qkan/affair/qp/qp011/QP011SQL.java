
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
 * 開発者: 訪問看護療養費領収書一覧
 * 作成日: 2006/08/22  日本コンピューター株式会社 訪問看護療養費領収書一覧 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 訪問看護療養費領収書一覧 (011)
 * プログラム 訪問看護療養費領収書一覧 (QP011)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp011;
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
 * 訪問看護療養費領収書一覧SQL定義(QP011) 
 */
public class QP011SQL extends QP011State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * コンストラクタです。
   */
  public QP011SQL() {
  }

  /**
   * 「領収書の検索」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_SELECT_BILL(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" CLAIM_PATIENT_MEDICAL.CLAIM_PATIENT_MEDICAL_ID");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_SPAN_START");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_SPAN_END");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_PRINTED");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_PRINT_DATE");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_INSURE_TYPE");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_FULL_TOTAL");

    sb.append(",CLAIM_PATIENT_MEDICAL.LAST_TIME");

    sb.append(" FROM");

    sb.append(" CLAIM_PATIENT_MEDICAL");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" CLAIM_PATIENT_MEDICAL.PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM_PATIENT_MEDICAL.BILL_SPAN_START");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("BILL_SPAN_START", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" CLAIM_PATIENT_MEDICAL.BILL_SPAN_END");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("BILL_SPAN_END", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" CLAIM_PATIENT_MEDICAL.BILL_SPAN_START");

    sb.append(" ASC");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_NO");

    sb.append(" ASC");

    return sb.toString();
  }

  /**
   * 「領収書の削除」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_DELETE_BILL(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("DELETE FROM");

    sb.append(" CLAIM_PATIENT_MEDICAL");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" CLAIM_PATIENT_MEDICAL.CLAIM_PATIENT_MEDICAL_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CLAIM_PATIENT_MEDICAL_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

}
