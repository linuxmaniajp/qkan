
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
 * 開発者: サービス予定
 * 作成日: 2009/03/27  日本コンピューター株式会社 サービス予定 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム 集計明細画面 (QS001030)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.util.Stack;

import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACSQLSafeIntegerFormat;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;

/**
 * 集計明細画面SQL定義(QS001030) 
 */
public class QS001005SQL extends QS001005State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * コンストラクタです。
   */
  public QS001005SQL() {
  }

  /**
   * 「外部利用型の給付上限単位数取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_SELECT_EXTERNAL_USE_LIMIT(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" LIMIT_RATE_VALUE");

    sb.append(" AS EXTERNAL_USE_LIMIT");

    sb.append(" FROM");

    sb.append(" M_LIMIT_RATE");

    sb.append(",M_LIMIT_RATE_DETAIL");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" M_LIMIT_RATE.LIMIT_RATE_TYPE");

    sb.append(" =");

    sb.append(" 2");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" M_LIMIT_RATE.LIMIT_RATE_TYPE");

    sb.append(" =");

    sb.append(" M_LIMIT_RATE_DETAIL.LIMIT_RATE_TYPE");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" M_LIMIT_RATE.LIMIT_RATE_HISTORY_ID");

    sb.append(" =");

    sb.append(" M_LIMIT_RATE_DETAIL.LIMIT_RATE_HISTORY_ID");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" M_LIMIT_RATE.LIMIT_RATE_VALID_START");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE_START", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" M_LIMIT_RATE.LIMIT_RATE_VALID_END");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE_START", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" M_LIMIT_RATE_DETAIL.JOTAI_CODE");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("JOTAI_CODE", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

}
