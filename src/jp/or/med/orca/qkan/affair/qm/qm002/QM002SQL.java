
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
 * 開発者: メインメニュー
 * 作成日: 2006/02/20  日本コンピューター株式会社 メインメニュー 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム メニュー (M)
 * プロセス メインメニュー (002)
 * プログラム メインメニュー (QM002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qm.qm002;
import java.util.Stack;

import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACSQLSafeStringFormat;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;

/**
 * メインメニューSQL定義(QM002) 
 */
public class QM002SQL extends QM002State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * コンストラクタです。
   */
  public QM002SQL() {
  }

  /**
   * 「登録されている保険者数を取得する」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_INSURER_COUNT(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" COUNT(*) AS INSURER_COUNT");

    sb.append(" FROM");

    sb.append(" INSURER");

    return sb.toString();
  }

  /**
   * 「登録されている利用者数を取得する」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_PATIENT_COUNT(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" COUNT(*) AS PATIENT_COUNT");

    sb.append(" FROM");

    sb.append(" PATIENT");

    return sb.toString();
  }

  /**
   * 「ログイン事業者のメニュー情報を」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_MENU_TREE(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" M_MENU.MENU_ID");

    sb.append(",M_MENU.PARENT_MENU_ID");

    sb.append(",M_MENU.NEXT_CLASS");

    sb.append(",M_MENU.CAPTION");

    sb.append(",M_MENU.TOOLTIP_TEXT");

    sb.append(",M_MENU.ICON");

    sb.append(",M_MENU.MENU_SORT");

    sb.append(",M_PARAMETER.PARAMETER_VALUE");

    sb.append(",M_PARAMETER.PARAMETER_KEY");

    sb.append(" FROM");

    sb.append(" PROVIDER_MENU");

    sb.append(",M_MENU");

    sb.append(" LEFT JOIN");

    sb.append(" M_PARAMETER");

    sb.append(" ON");

    sb.append("(");

    sb.append(" M_MENU.PARAMETER_ID");

    sb.append(" =");

    sb.append(" M_PARAMETER.PARAMETER_ID");

    sb.append(")");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" PROVIDER_MENU.LOGIN_PROVIDER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("LOGIN_PROVIDER_ID", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" PROVIDER_MENU.SHOW_FLAG");

    sb.append(" =");

    sb.append(" 1");

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" PROVIDER_MENU.MENU_ID");

    sb.append(" =");

    sb.append(" M_MENU.MENU_ID");

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" MENU_SORT");

    sb.append(" ASC");

    return sb.toString();
  }

  /**
   * 「事業所のマスタ情報」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_M_MENU(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" M_MENU.MENU_ID");

    sb.append(",M_MENU.BUSINESS_TYPE");

    sb.append(",M_MENU.PARENT_MENU_ID");

    sb.append(",M_MENU.CAN_CHANGE_VISIBLE_FLAG");

    sb.append(",M_MENU.NEXT_CLASS");

    sb.append(",M_MENU.CAPTION");

    sb.append(",M_MENU.TOOLTIP_TEXT");

    sb.append(",M_MENU.ICON");

    sb.append(",M_MENU.PARAMETER_ID");

    sb.append(",M_MENU.MENU_SORT");

    sb.append(",M_PARAMETER.PARAMETER_KEY");

    sb.append(",M_PARAMETER.PARAMETER_VALUE");

    sb.append(" FROM");

    sb.append(" M_MENU");

    sb.append(" LEFT JOIN");

    sb.append(" M_PARAMETER");

    sb.append(" ON");

    sb.append("(");

    sb.append(" M_MENU.PARAMETER_ID");

    sb.append(" =");

    sb.append(" M_PARAMETER.PARAMETER_ID");

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" MENU_SORT");

    sb.append(" ASC");

    return sb.toString();
  }

}
