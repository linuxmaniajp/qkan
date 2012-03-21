
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
 * 開発者: 事業所一覧
 * 作成日: 2006/06/06  日本コンピューター株式会社 事業所一覧 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業所一覧 (003)
 * プログラム 事業所一覧 (QO003P01)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo003;
import java.util.Stack;

import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACSQLSafeStringFormat;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;

/**
 * 事業所一覧SQL定義(QO003P01) 
 */
public class QO003P01SQL  {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * コンストラクタです。
   */
  public QO003P01SQL() {
  }

  /**
   * 「サービスカレンダー名を取得する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_SERVICE_CALENDAR_NAME(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" DISTINCT");

    sb.append(" M_SERVICE.SERVICE_CALENDAR_ABBREVIATION");

    sb.append(" FROM");

    sb.append(" PROVIDER_SERVICE");

    sb.append(",M_SERVICE");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PROVIDER_SERVICE.PROVIDER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" PROVIDER_SERVICE.SYSTEM_SERVICE_KIND_DETAIL");

    sb.append(" =");

    sb.append(" M_SERVICE.SYSTEM_SERVICE_KIND_DETAIL");

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" SERVICE_SORT");

    sb.append(" ASC");

    return sb.toString();
  }

}
