
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
 * 開発者: 訪問看護療養費領収書編集
 * 作成日: 2007/02/15  日本コンピューター株式会社 訪問看護療養費領収書編集 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 訪問看護療養費領収書編集 (012)
 * プログラム 訪問看護療養費領収書編集 (QP012)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp012;
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
 * 訪問看護療養費領収書編集SQL定義(QP012) 
 */
public class QP012SQL extends QP012State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * コンストラクタです。
   */
  public QP012SQL() {
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
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" CLAIM_PATIENT_MEDICAL.CLAIM_PATIENT_MEDICAL_ID");

    sb.append(",CLAIM_PATIENT_MEDICAL.PATIENT_ID");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDER_ID");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_SPAN_START");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_SPAN_END");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_PRINTED");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_NO");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_PATIENT_CODE");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_PRINT_DATE");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_RATE");

    sb.append(",CLAIM_PATIENT_MEDICAL.SELF_FLAG");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_INSURE_TYPE");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_TAX");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME1");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE1");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER1");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM1");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME2");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE2");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER2");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM2");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME3");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE3");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER3");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM3");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME4");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE4");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER4");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM4");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME5");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE5");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER5");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM5");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME6");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE6");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER6");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM6");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME7");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE7");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER7");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM7");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME8");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE8");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER8");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM8");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME9");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE9");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER9");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM9");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME10");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE10");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER10");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM10");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME11");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE11");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER11");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM11");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME12");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE12");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER12");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM12");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME13");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE13");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER13");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM13");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME14");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE14");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER14");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM14");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME15");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE15");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER15");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM15");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME16");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE16");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER16");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM16");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME17");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE17");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER17");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM17");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME18");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE18");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER18");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM18");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME19");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE19");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER19");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM19");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME20");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE20");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER20");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM20");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME1");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE1");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER1");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM1");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET1");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX1");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX1");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME2");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE2");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER2");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM2");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET2");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX2");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX2");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME3");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE3");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER3");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM3");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET3");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX3");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX3");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME4");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE4");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER4");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM4");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET4");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX4");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX4");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME5");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE5");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER5");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM5");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET5");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX5");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX5");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME6");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE6");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER6");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM6");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET6");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX6");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX6");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME7");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE7");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER7");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM7");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET7");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX7");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX7");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME8");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE8");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER8");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM8");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET8");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX8");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX8");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME9");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE9");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER9");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM9");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET9");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX9");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX9");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME10");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE10");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER10");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM10");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET10");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX10");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX10");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME11");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE11");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER11");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM11");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET11");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX11");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX11");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME12");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE12");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER12");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM12");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET12");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX12");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX12");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME13");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE13");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER13");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM13");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET13");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX13");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX13");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME14");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE14");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER14");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM14");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET14");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX14");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX14");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME15");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE15");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER15");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM15");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET15");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX15");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX15");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME16");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE16");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER16");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM16");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET16");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX16");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX16");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME17");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE17");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER17");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM17");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET17");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX17");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX17");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME18");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE18");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER18");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM18");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET18");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX18");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX18");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME19");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE19");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER19");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM19");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET19");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX19");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX19");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME20");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE20");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER20");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM20");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET20");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX20");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX20");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_1");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_2");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_3");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_4");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_5");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_6");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_7");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_8");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_9");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_10");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_11");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_12");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_13");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_14");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_15");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_16");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_17");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_18");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_19");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_20");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_21");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_22");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_23");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_24");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_25");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_26");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_27");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_28");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_29");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_30");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_31");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_NOTE");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_NO_TAX_BY_INSURER");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_NO_TAX_BY_PATIENT");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_IN_TAX_BY_PATIENT");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_FULL_TOTAL");

    sb.append(",CLAIM_PATIENT_MEDICAL.LAST_TIME");

    sb.append(" FROM");

    sb.append(" CLAIM_PATIENT_MEDICAL");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" CLAIM_PATIENT_MEDICAL.CLAIM_PATIENT_MEDICAL_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CLAIM_PATIENT_MEDICAL_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「複製元の領収書の検索」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_SELECT_COPY_BILL(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" CLAIM_PATIENT_MEDICAL.BILL_PATIENT_CODE");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME1");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE1");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER1");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM1");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET1");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX1");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX1");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME2");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE2");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER2");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM2");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET2");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX2");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX2");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME3");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE3");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER3");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM3");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET3");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX3");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX3");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME4");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE4");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER4");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM4");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET4");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX4");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX4");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME5");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE5");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER5");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM5");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET5");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX5");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX5");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME6");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE6");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER6");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM6");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET6");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX6");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX6");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME7");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE7");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER7");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM7");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET7");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX7");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX7");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME8");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE8");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER8");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM8");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET8");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX8");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX8");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME9");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE9");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER9");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM9");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET9");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX9");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX9");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME10");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE10");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER10");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM10");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET10");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX10");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX10");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME11");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE11");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER11");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM11");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET11");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX11");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX11");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME12");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE12");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER12");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM12");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET12");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX12");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX12");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME13");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE13");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER13");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM13");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET13");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX13");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX13");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME14");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE14");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER14");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM14");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET14");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX14");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX14");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME15");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE15");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER15");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM15");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET15");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX15");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX15");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME16");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE16");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER16");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM16");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET16");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX16");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX16");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME17");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE17");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER17");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM17");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET17");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX17");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX17");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME18");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE18");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER18");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM18");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET18");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX18");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX18");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME19");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE19");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER19");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM19");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET19");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX19");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX19");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME20");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE20");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER20");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM20");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET20");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX20");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX20");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_NOTE");

    sb.append(" FROM");

    sb.append(" CLAIM_PATIENT_MEDICAL");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" CLAIM_PATIENT_MEDICAL.CLAIM_PATIENT_MEDICAL_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CLAIM_PATIENT_MEDICAL_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「領収書の登録」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_INSERT_BILL(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("INSERT INTO");

    sb.append(" CLAIM_PATIENT_MEDICAL");

    sb.append("(");

    sb.append(" CLAIM_PATIENT_MEDICAL.CLAIM_PATIENT_MEDICAL_ID");

    sb.append(",CLAIM_PATIENT_MEDICAL.PATIENT_ID");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDER_ID");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_SPAN_START");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_SPAN_END");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_PRINTED");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_NO");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_PATIENT_CODE");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_PRINT_DATE");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_RATE");

    sb.append(",CLAIM_PATIENT_MEDICAL.SELF_FLAG");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_INSURE_TYPE");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_TAX");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME1");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE1");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER1");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM1");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME2");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE2");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER2");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM2");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME3");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE3");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER3");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM3");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME4");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE4");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER4");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM4");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME5");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE5");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER5");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM5");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME6");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE6");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER6");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM6");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME7");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE7");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER7");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM7");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME8");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE8");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER8");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM8");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME9");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE9");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER9");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM9");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME10");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE10");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER10");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM10");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME11");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE11");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER11");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM11");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME12");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE12");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER12");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM12");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME13");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE13");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER13");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM13");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME14");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE14");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER14");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM14");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME15");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE15");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER15");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM15");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME16");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE16");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER16");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM16");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME17");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE17");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER17");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM17");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME18");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE18");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER18");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM18");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME19");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE19");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER19");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM19");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME20");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE20");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER20");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM20");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME1");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE1");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER1");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM1");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET1");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX1");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX1");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME2");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE2");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER2");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM2");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET2");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX2");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX2");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME3");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE3");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER3");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM3");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET3");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX3");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX3");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME4");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE4");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER4");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM4");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET4");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX4");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX4");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME5");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE5");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER5");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM5");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET5");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX5");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX5");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME6");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE6");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER6");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM6");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET6");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX6");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX6");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME7");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE7");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER7");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM7");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET7");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX7");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX7");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME8");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE8");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER8");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM8");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET8");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX8");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX8");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME9");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE9");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER9");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM9");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET9");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX9");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX9");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME10");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE10");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER10");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM10");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET10");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX10");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX10");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME11");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE11");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER11");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM11");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET11");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX11");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX11");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME12");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE12");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER12");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM12");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET12");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX12");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX12");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME13");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE13");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER13");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM13");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET13");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX13");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX13");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME14");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE14");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER14");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM14");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET14");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX14");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX14");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME15");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE15");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER15");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM15");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET15");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX15");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX15");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME16");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE16");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER16");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM16");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET16");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX16");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX16");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME17");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE17");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER17");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM17");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET17");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX17");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX17");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME18");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE18");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER18");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM18");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET18");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX18");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX18");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME19");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE19");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER19");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM19");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET19");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX19");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX19");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME20");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE20");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER20");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM20");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET20");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX20");

    sb.append(",CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX20");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_1");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_2");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_3");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_4");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_5");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_6");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_7");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_8");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_9");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_10");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_11");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_12");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_13");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_14");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_15");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_16");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_17");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_18");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_19");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_20");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_21");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_22");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_23");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_24");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_25");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_26");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_27");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_28");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_29");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_30");

    sb.append(",CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_31");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_NOTE");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_NO_TAX_BY_INSURER");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_NO_TAX_BY_PATIENT");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_IN_TAX_BY_PATIENT");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_FULL_TOTAL");

    sb.append(",CLAIM_PATIENT_MEDICAL.LAST_TIME");

    sb.append(")VALUES(");

    sb.append(" (");

    sb.append("SELECT");

    sb.append(" CASE");

    sb.append(" WHEN");

    sb.append(" MAX(CLAIM_PATIENT_MEDICAL.CLAIM_PATIENT_MEDICAL_ID)");

    sb.append(" IS");

    sb.append(" NULL");

    sb.append(" THEN");

    sb.append(" 1");

    sb.append(" ELSE");

    sb.append(" MAX(CLAIM_PATIENT_MEDICAL.CLAIM_PATIENT_MEDICAL_ID)+1");

    sb.append(" END");

    sb.append(" FROM");

    sb.append(" CLAIM_PATIENT_MEDICAL");

    sb.append(")");

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("BILL_SPAN_START", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("BILL_SPAN_END", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(" 0");

    sb.append(",");

    sb.append(" (");

    sb.append("SELECT");

    sb.append(" CASE");

    sb.append(" WHEN");

    sb.append(" MAX(CLAIM_PATIENT_MEDICAL.BILL_NO)");

    sb.append(" IS");

    sb.append(" NULL");

    sb.append(" THEN");

    sb.append(" 1");

    sb.append(" ELSE");

    sb.append(" MAX(CLAIM_PATIENT_MEDICAL.BILL_NO)+1");

    sb.append(" END");

    sb.append(" FROM");

    sb.append(" CLAIM_PATIENT_MEDICAL");

    sb.append(")");

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BILL_PATIENT_CODE", sqlParam)));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("BILL_PRINT_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_RATE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SELF_FLAG", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BILL_INSURE_TYPE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BILL_TAX", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME1", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE1", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER1", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM1", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME2", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE2", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER2", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM2", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME3", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE3", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER3", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM3", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME4", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE4", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER4", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM4", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME5", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE5", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER5", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM5", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME6", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE6", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER6", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM6", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME7", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE7", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER7", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM7", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME8", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE8", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER8", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM8", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME9", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE9", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER9", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM9", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME10", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE10", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER10", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM10", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME11", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE11", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER11", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM11", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME12", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE12", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER12", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM12", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME13", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE13", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER13", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM13", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME14", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE14", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER14", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM14", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME15", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE15", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER15", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM15", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME16", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE16", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER16", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM16", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME17", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE17", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER17", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM17", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME18", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE18", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER18", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM18", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME19", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE19", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER19", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM19", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME20", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE20", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER20", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM20", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME1", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE1", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER1", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM1", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET1", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX1", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX1", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME2", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE2", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER2", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM2", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET2", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX2", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX2", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME3", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE3", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER3", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM3", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET3", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX3", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX3", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME4", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE4", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER4", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM4", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET4", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX4", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX4", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME5", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE5", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER5", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM5", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET5", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX5", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX5", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME6", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE6", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER6", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM6", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET6", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX6", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX6", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME7", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE7", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER7", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM7", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET7", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX7", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX7", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME8", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE8", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER8", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM8", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET8", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX8", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX8", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME9", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE9", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER9", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM9", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET9", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX9", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX9", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME10", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE10", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER10", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM10", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET10", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX10", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX10", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME11", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE11", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER11", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM11", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET11", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX11", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX11", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME12", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE12", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER12", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM12", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET12", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX12", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX12", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME13", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE13", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER13", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM13", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET13", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX13", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX13", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME14", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE14", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER14", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM14", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET14", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX14", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX14", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME15", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE15", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER15", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM15", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET15", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX15", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX15", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME16", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE16", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER16", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM16", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET16", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX16", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX16", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME17", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE17", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER17", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM17", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET17", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX17", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX17", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME18", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE18", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER18", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM18", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET18", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX18", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX18", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME19", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE19", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER19", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM19", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET19", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX19", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX19", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME20", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE20", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER20", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM20", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET20", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX20", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX20", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_1", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_2", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_3", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_4", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_5", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_6", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_7", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_8", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_9", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_10", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_11", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_12", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_13", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_14", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_15", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_16", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_17", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_18", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_19", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_20", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_21", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_22", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_23", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_24", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_25", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_26", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_27", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_28", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_29", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_30", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_31", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BILL_NOTE", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BILL_NO_TAX_BY_INSURER", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BILL_NO_TAX_BY_PATIENT", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BILL_IN_TAX_BY_PATIENT", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BILL_FULL_TOTAL", sqlParam)));

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「登録後の再取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_SELECT_INSERTED_BILL(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" CLAIM_PATIENT_MEDICAL.CLAIM_PATIENT_MEDICAL_ID");

    sb.append(",CLAIM_PATIENT_MEDICAL.BILL_NO");

    sb.append(",CLAIM_PATIENT_MEDICAL.LAST_TIME");

    sb.append(" FROM");

    sb.append(" CLAIM_PATIENT_MEDICAL");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" CLAIM_PATIENT_MEDICAL.CLAIM_PATIENT_MEDICAL_ID");

    sb.append(" =");

    sb.append(" (");

    sb.append("SELECT");

    sb.append(" MAX(CLAIM_PATIENT_MEDICAL.CLAIM_PATIENT_MEDICAL_ID)");

    sb.append(" FROM");

    sb.append(" CLAIM_PATIENT_MEDICAL");

    sb.append(")");

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「量数書の更新」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_UPDATE_BILL(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" CLAIM_PATIENT_MEDICAL");

    sb.append(" SET");

    sb.append(" CLAIM_PATIENT_MEDICAL.PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BILL_SPAN_START");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("BILL_SPAN_START", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BILL_SPAN_END");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("BILL_SPAN_END", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BILL_PRINTED");

    sb.append(" =");

    sb.append(" 0");

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BILL_NO");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BILL_NO", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BILL_PATIENT_CODE");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BILL_PATIENT_CODE", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BILL_PRINT_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("BILL_PRINT_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_RATE");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_RATE", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.SELF_FLAG");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SELF_FLAG", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BILL_INSURE_TYPE");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BILL_INSURE_TYPE", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BILL_TAX");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BILL_TAX", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME1");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME1", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE1");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE1", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER1");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER1", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM1");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM1", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME2");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME2", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE2");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE2", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER2");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER2", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM2");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM2", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME3");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME3", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE3");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE3", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER3");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER3", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM3");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM3", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME4");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME4", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE4");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE4", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER4");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER4", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM4");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM4", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME5");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME5", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE5");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE5", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER5");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER5", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM5");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM5", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME6");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME6", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE6");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE6", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER6");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER6", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM6");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM6", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME7");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME7", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE7");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE7", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER7");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER7", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM7");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM7", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME8");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME8", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE8");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE8", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER8");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER8", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM8");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM8", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME9");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME9", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE9");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE9", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER9");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER9", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM9");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM9", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME10");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME10", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE10");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE10", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER10");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER10", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM10");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM10", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME11");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME11", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE11");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE11", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER11");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER11", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM11");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM11", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME12");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME12", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE12");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE12", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER12");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER12", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM12");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM12", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME13");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME13", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE13");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE13", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER13");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER13", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM13");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM13", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME14");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME14", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE14");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE14", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER14");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER14", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM14");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM14", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME15");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME15", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE15");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE15", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER15");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER15", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM15");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM15", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME16");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME16", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE16");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE16", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER16");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER16", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM16");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM16", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME17");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME17", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE17");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE17", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER17");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER17", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM17");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM17", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME18");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME18", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE18");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE18", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER18");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER18", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM18");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM18", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME19");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME19", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE19");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE19", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER19");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER19", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM19");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM19", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NAME20");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NAME20", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_PRICE20");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_PRICE20", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_NUMBER20");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_NUMBER20", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_INSURER_SUM20");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_INSURER_SUM20", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME1");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME1", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE1");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE1", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER1");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER1", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM1");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM1", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET1");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET1", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX1");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX1", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX1");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX1", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME2");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME2", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE2");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE2", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER2");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER2", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM2");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM2", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET2");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET2", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX2");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX2", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX2");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX2", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME3");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME3", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE3");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE3", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER3");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER3", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM3");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM3", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET3");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET3", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX3");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX3", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX3");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX3", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME4");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME4", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE4");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE4", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER4");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER4", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM4");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM4", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET4");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET4", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX4");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX4", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX4");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX4", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME5");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME5", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE5");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE5", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER5");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER5", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM5");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM5", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET5");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET5", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX5");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX5", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX5");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX5", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME6");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME6", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE6");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE6", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER6");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER6", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM6");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM6", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET6");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET6", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX6");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX6", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX6");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX6", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME7");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME7", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE7");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE7", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER7");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER7", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM7");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM7", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET7");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET7", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX7");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX7", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX7");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX7", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME8");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME8", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE8");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE8", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER8");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER8", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM8");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM8", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET8");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET8", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX8");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX8", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX8");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX8", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME9");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME9", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE9");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE9", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER9");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER9", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM9");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM9", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET9");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET9", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX9");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX9", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX9");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX9", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME10");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME10", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE10");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE10", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER10");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER10", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM10");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM10", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET10");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET10", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX10");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX10", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX10");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX10", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME11");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME11", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE11");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE11", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER11");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER11", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM11");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM11", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET11");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET11", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX11");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX11", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX11");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX11", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME12");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME12", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE12");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE12", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER12");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER12", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM12");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM12", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET12");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET12", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX12");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX12", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX12");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX12", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME13");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME13", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE13");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE13", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER13");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER13", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM13");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM13", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET13");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET13", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX13");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX13", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX13");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX13", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME14");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME14", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE14");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE14", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER14");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER14", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM14");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM14", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET14");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET14", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX14");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX14", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX14");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX14", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME15");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME15", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE15");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE15", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER15");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER15", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM15");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM15", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET15");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET15", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX15");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX15", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX15");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX15", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME16");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME16", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE16");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE16", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER16");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER16", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM16");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM16", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET16");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET16", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX16");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX16", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX16");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX16", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME17");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME17", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE17");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE17", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER17");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER17", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM17");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM17", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET17");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET17", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX17");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX17", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX17");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX17", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME18");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME18", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE18");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE18", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER18");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER18", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM18");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM18", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET18");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET18", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX18");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX18", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX18");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX18", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME19");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME19", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE19");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE19", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER19");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER19", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM19");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM19", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET19");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET19", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX19");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX19", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX19");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX19", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NAME20");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NAME20", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_PRICE20");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_PRICE20", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_NUMBER20");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_NUMBER20", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_SUM20");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_SUM20", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX_TARGET20");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX_TARGET20", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_USE_TAX20");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_USE_TAX20", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BY_PATIENT_TAX20");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BY_PATIENT_TAX20", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_1");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_1", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_2");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_2", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_3");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_3", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_4");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_4", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_5");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_5", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_6");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_6", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_7");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_7", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_8");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_8", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_9");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_9", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_10");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_10", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_11");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_11", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_12");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_12", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_13");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_13", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_14");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_14", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_15");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_15", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_16");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_16", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_17");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_17", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_18");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_18", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_19");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_19", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_20");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_20", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_21");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_21", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_22");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_22", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_23");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_23", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_24");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_24", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_25");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_25", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_26");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_26", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_27");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_27", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_28");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_28", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_29");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_29", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_30");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_30", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.PROVIDE_DAY_31");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDE_DAY_31", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BILL_NOTE");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("BILL_NOTE", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BILL_NO_TAX_BY_INSURER");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BILL_NO_TAX_BY_INSURER", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BILL_NO_TAX_BY_PATIENT");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BILL_NO_TAX_BY_PATIENT", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BILL_IN_TAX_BY_PATIENT");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BILL_IN_TAX_BY_PATIENT", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.BILL_FULL_TOTAL");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("BILL_FULL_TOTAL", sqlParam)));

    sb.append(",");

    sb.append(" CLAIM_PATIENT_MEDICAL.LAST_TIME");

    sb.append(" =");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" CLAIM_PATIENT_MEDICAL.CLAIM_PATIENT_MEDICAL_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CLAIM_PATIENT_MEDICAL_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「更新後の再取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_SELECT_UPDATED_BILL(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" CLAIM_PATIENT_MEDICAL.CLAIM_PATIENT_MEDICAL_ID");

    sb.append(",CLAIM_PATIENT_MEDICAL.LAST_TIME");

    sb.append(" FROM");

    sb.append(" CLAIM_PATIENT_MEDICAL");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" CLAIM_PATIENT_MEDICAL.CLAIM_PATIENT_MEDICAL_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CLAIM_PATIENT_MEDICAL_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「印刷済みへの更新」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_UPDATE_TO_PRINTED(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" CLAIM_PATIENT_MEDICAL");

    sb.append(" SET");

    sb.append(" CLAIM_PATIENT_MEDICAL.BILL_PRINTED");

    sb.append(" =");

    sb.append(" 1");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" CLAIM_PATIENT_MEDICAL.CLAIM_PATIENT_MEDICAL_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("CLAIM_PATIENT_MEDICAL_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「定型文取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_SELECT_FIXED_FORM(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" FIXED_FORM.CONTENT");

    sb.append(" FROM");

    sb.append(" FIXED_FORM");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" FIXED_FORM.TABLE_TYPE");

    sb.append(" =");

    sb.append(" 2");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" FIXED_FORM.FIXED_FORM_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("FIXED_FORM_ID", sqlParam)));

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" CONTENT_SORT");

    sb.append(" ASC");

    return sb.toString();
  }

  /**
   * 「定型文追加」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_INSERT_FIXED_FORM(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("INSERT INTO");

    sb.append(" FIXED_FORM");

    sb.append("(");

    sb.append(" FIXED_FORM.TABLE_TYPE");

    sb.append(",FIXED_FORM.FIXED_FORM_ID");

    sb.append(",FIXED_FORM.CONTENT_KEY");

    sb.append(",FIXED_FORM.CONTENT");

    sb.append(",FIXED_FORM.CONTENT_SORT");

    sb.append(",LAST_TIME");

    sb.append(")VALUES(");

    sb.append(" 2");

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("FIXED_FORM_ID", sqlParam)));

    sb.append(",");

    sb.append(" (");

    sb.append("SELECT");

    sb.append(" CASE");

    sb.append(" WHEN");

    sb.append(" MAX(FIXED_FORM.CONTENT_KEY)");

    sb.append(" IS");

    sb.append(" NULL");

    sb.append(" THEN");

    sb.append(" 0");

    sb.append(" ELSE");

    sb.append(" MAX(FIXED_FORM.CONTENT_KEY)+1");

    sb.append(" END");

    sb.append(" FROM");

    sb.append(" FIXED_FORM");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" FIXED_FORM.TABLE_TYPE");

    sb.append(" =");

    sb.append(" 2");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" FIXED_FORM.FIXED_FORM_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("FIXED_FORM_ID", sqlParam)));

    sb.append(")");

    sb.append(")");

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("CONTENT", sqlParam)));

    sb.append(",");

    sb.append(" (");

    sb.append("SELECT");

    sb.append(" CASE");

    sb.append(" WHEN");

    sb.append(" MAX(FIXED_FORM.CONTENT_SORT)");

    sb.append(" IS");

    sb.append(" NULL");

    sb.append(" THEN");

    sb.append(" 0");

    sb.append(" ELSE");

    sb.append(" MAX(FIXED_FORM.CONTENT_SORT)+1");

    sb.append(" END");

    sb.append(" FROM");

    sb.append(" FIXED_FORM");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" FIXED_FORM.TABLE_TYPE");

    sb.append(" =");

    sb.append(" 2");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" FIXED_FORM.FIXED_FORM_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("FIXED_FORM_ID", sqlParam)));

    sb.append(")");

    sb.append(")");

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「請求期間の公費取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_SELECT_BILL_KOHI(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" DISTINCT");

    sb.append(" PATIENT_KOHI.KOHI_LAW_NO");

    sb.append(",PATIENT_KOHI.INSURER_ID");

    sb.append(" FROM");

    sb.append(" PATIENT_KOHI");

    sb.append(",M_KOHI");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PATIENT_KOHI.PATIENT_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" PATIENT_KOHI.INSURE_TYPE");

    sb.append(" =");

    sb.append(" 2");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append("(");

    sb.append("(");

    sb.append(" PATIENT_KOHI.KOHI_VALID_START");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("BILL_SPAN_START", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" PATIENT_KOHI.KOHI_VALID_END");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("BILL_SPAN_END", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(")");

    sb.append("OR");

    sb.append("(");

    sb.append("(");

    sb.append(" PATIENT_KOHI.KOHI_VALID_END");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("BILL_SPAN_START", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" PATIENT_KOHI.KOHI_VALID_START");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("BILL_SPAN_END", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(")");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" PATIENT_KOHI.KOHI_TYPE");

    sb.append(" =");

    sb.append(" M_KOHI.KOHI_TYPE");

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" KOHI_SORT");

    sb.append(" ASC");

    return sb.toString();
  }

}
