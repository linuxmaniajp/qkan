
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
 * 開発者: 医療機関管理
 * 作成日: 2011/12/19  日本コンピューター株式会社 医療機関管理 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 医療機関管理 (009)
 * プログラム 医療機関一覧 (QO009)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo009;
import java.util.Stack;

import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACSQLSafeIntegerFormat;
import jp.nichicom.ac.text.ACSQLSafeStringFormat;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;

/**
 * 医療機関一覧SQL定義(QO009) 
 */
public class QO009SQL extends QO009State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * コンストラクタです。
   */
  public QO009SQL() {
  }

  /**
   * 「医療機関情報取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_MEDICAL_FACILITY(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
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

    sb.append(",MEDICAL_FACILITY_ZIP_FIRST");

    sb.append(",MEDICAL_FACILITY_ZIP_SECOND");

    sb.append(",MEDICAL_FACILITY_ADDRESS");

    sb.append(",MEDICAL_FACILITY_FAX_FIRST");

    sb.append(",MEDICAL_FACILITY_FAX_SECOND");

    sb.append(",MEDICAL_FACILITY_FAX_THIRD");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" MEDICAL_FACILITY");

    conditionStack.push(new Boolean(firstCondition));
    firstCondition = true;

    if(
      VRBindPathParser.has("MEDICAL_FACILITY_NAME", sqlParam)
    ){

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }

    sb.append("(");

    sb.append(" MEDICAL_FACILITY_NAME");

    sb.append(" LIKE");

    sb.append(" ");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("MEDICAL_FACILITY_NAME", sqlParam)+"%"));

    sb.append(")");

    }

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }else{
        sb.append(" AND");

      }

    sb.append("(");

    sb.append(" DELETE_FLAG");

    sb.append(" <>");

    sb.append(" 1");

    sb.append(")");

    firstCondition = ((Boolean)conditionStack.pop()).booleanValue();

    sb.append(" ORDER BY");

    sb.append(" MEDICAL_FACILITY_NAME");

    sb.append(" ");

    return sb.toString();
  }

  /**
   * 「医療機関情報削除」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_DELETE_MEDICAL_FACILITY(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" MEDICAL_FACILITY");

    sb.append(" SET");

    sb.append(" DELETE_FLAG");

    sb.append(" =");

    sb.append(" 1");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" MEDICAL_FACILITY_ID");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("MEDICAL_FACILITY_ID", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

}
