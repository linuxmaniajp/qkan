
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
 * 開発者: 事業所登録
 * 作成日: 2006/05/02  日本コンピューター株式会社 事業所登録 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業所登録 (004)
 * プログラム 介護予防短期入所療養介護（基準適合診療所型） (QO004142)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;
import java.util.Stack;

import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;

/**
 * 介護予防短期入所療養介護（基準適合診療所型）SQL定義(QO004142) 
 */
public class QO004142SQL extends QO004142State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * コンストラクタです。
   */
  public QO004142SQL() {
  }

  /**
   * 「居住費・食費の取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_RESIDENCE_FOOD(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" RESIDENCE_FOOD_COST_ID");

    sb.append(",RESIDENCE_FOOD_COST");

    sb.append(" FROM");

    sb.append(" M_RESIDENCE_FOOD_COST");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" RESIDENCE_FOOD_COST_VALID_START");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("SYSTEM_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" RESIDENCE_FOOD_COST_VALID_END");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("SYSTEM_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    return sb.toString();
  }

}
