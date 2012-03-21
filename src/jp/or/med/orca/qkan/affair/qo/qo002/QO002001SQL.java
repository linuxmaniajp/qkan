
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
 * 開発者: 保険者情報登録
 * 作成日: 2009/08/03  日本コンピューター株式会社 保険者情報登録 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 保険者管理 (O)
 * プロセス 保険者情報登録 (002)
 * プログラム 保険者選択 (QO002001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo002;
import java.util.Stack;

import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACSQLSafeStringFormat;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;

/**
 * 保険者選択SQL定義(QO002001) 
 */
public class QO002001SQL extends QO002001State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * コンストラクタです。
   */
  public QO002001SQL() {
  }

  /**
   * 「検索SQL」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_FIND_M_INSURER_INFO(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" INSURER_NAME");

    sb.append(",INSURER_NO");

    sb.append(" FROM");

    sb.append(" M_INSURER");

    conditionStack.push(new Boolean(firstCondition));
    firstCondition = true;

    if(
      VRBindPathParser.has("FIND_INSURER_NAME", sqlParam)
    ){

      if(firstCondition){
        sb.append(" WHERE");
        firstCondition = false;

      }

    sb.append("(");

    sb.append(" INSURER_NAME");

    sb.append(" LIKE");

    sb.append(" ");

    sb.append(ACSQLSafeStringFormat.getInstance().format("%"+VRBindPathParser.get("FIND_INSURER_NAME", sqlParam)+"%"));

    sb.append(")");

    }

    firstCondition = ((Boolean)conditionStack.pop()).booleanValue();

    sb.append(" ORDER BY");

    sb.append(" INSURER_PREFECTURAL_CODE");

    sb.append(" ASC");

    sb.append(",INSURER_NO");

    sb.append(" ASC");

    return sb.toString();
  }

  /**
   * 「保険者マスタデータを全て取得します。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_M_INSURER_INFO(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" INSURER_NAME");

    sb.append(",INSURER_NO");

    sb.append(" FROM");

    sb.append(" M_INSURER");

    sb.append(" ORDER BY");

    sb.append(" INSURER_PREFECTURAL_CODE");

    sb.append(" ASC");

    sb.append(",INSURER_NO");

    sb.append(" ASC");

    return sb.toString();
  }

}
