
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
 * 開発者: 確認・修正
 * 作成日: 2006/03/03  日本コンピューター株式会社 確認・修正 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 確認・修正 (005)
 * プログラム 明細書詳細編集 (QP005)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp005;
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
 * 明細書詳細編集SQL定義(QP005) 
 */
public class QP005SQL extends QP005State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * コンストラクタです。
   */
  public QP005SQL() {
  }

  /**
   * 「項目コメントマスタデータの取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_DETAIL_COMMENT(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" CATEGORY_NO");

    sb.append(",COMMENT_ID");

    sb.append(",TABLE_TYPE");

    sb.append(",DETAIL_NAME");

    sb.append(",COMMENT");

    sb.append(",SHOW_FLAG");

    sb.append(",EDITABLE_FLAG");

    sb.append(",SYSTEM_BIND_PATH");

    sb.append(",MAX_LENGTH");

    sb.append(",CHAR_TYPE");

    sb.append(",ALIGNMENT");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" M_DETAIL_COMMENT");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" COMMENT_VALID_START");

    sb.append(" <=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" COMMENT_VALID_END");

    sb.append(" >=");

    sb.append(dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" CATEGORY_NO");

    sb.append(" ");

    sb.append(",COMMENT_ID");

    return sb.toString();
  }

  /**
   * 「公費マスタ情報の取得」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_KOHI(VRMap sqlParam) throws Exception{
    StringBuffer sb = new StringBuffer();
    Object[] inValues;
    Stack conditionStack = new Stack();
    boolean firstCondition = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" KOHI_TYPE");

    sb.append(",KOHI_LAW_NO");

    sb.append(",KOHI_NAME");

    sb.append(",KOHI_ABBREVIATION");

    sb.append(",KOHI_SORT");

    sb.append(",BENEFIT_RATE");

    sb.append(",CITY_CLAIM_FLAG");

    sb.append(",INSURE_TYPE");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" M_KOHI");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" KOHI_TYPE");

    sb.append(" IN");

    sb.append(" (");

    inValues = (Object[])VRBindPathParser.get("KOHI_TYPE", sqlParam);
    
    sb.append(ACSQLSafeIntegerFormat.getInstance().format(inValues[0]));

    for(int i=1; i<inValues.length; i++){
      sb.append(", ");
      
    sb.append(ACSQLSafeIntegerFormat.getInstance().format(inValues[i]));

    }

    sb.append(")");

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" KOHI_SORT");

    sb.append(" ");

    return sb.toString();
  }

}
