
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
 * 開発者: 総合事業サービスコード管理
 * 作成日: 2016/09/16  日本コンピューター株式会社 総合事業サービスコード管理 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 総合事業サービスコード管理 (017)
 * プログラム 総合事業サービスコード情報登録 (QO017)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo017;
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
 * 総合事業サービスコード情報登録SQL定義(QO017) 
 */
public class QO017SQL extends QO017State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * コンストラクタです。
   */
  public QO017SQL() {
  }

  /**
   * 「総合事業サービスコード情報を取得する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_M_SJ_SERVICE_CODE_INFO(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" SYSTEM_SERVICE_CODE_ITEM");

    sb.append(",INSURER_ID");

    sb.append(",SYSTEM_SERVICE_KIND_DETAIL");

    sb.append(",TEKIYO_ST_DATE");

    sb.append(",CASE WHEN TEKIYO_ED_DATE = '9999-12-31' THEN NULL ELSE TEKIYO_ED_DATE END TEKIYO_ED_DATE");

    sb.append(",SERVICE_CODE_KIND");

    sb.append(",SERVICE_CODE_ITEM");

    sb.append(",SERVICE_NAME");

    sb.append(",SERVICE_UNIT");

    sb.append(",SANTEI_TANI");

    sb.append(",SEIGEN_NISSU_KAISU");

    sb.append(",SANTEI_KAISU_SEIGEN_KIKAN");

    sb.append(",CASE WHEN SHIKYU_GENDOGAKU_TAISHO_KBN IS NULL THEN '1' ELSE SHIKYU_GENDOGAKU_TAISHO_KBN END SHIKYU_GENDOGAKU_TAISHO_KBN");

    sb.append(",YOBI");

    sb.append(",KYUFURITSU");

    sb.append(",FUTANGAKU");

    sb.append(",JIGYO_TAISHOSHA_JISSHI_KBN");

    sb.append(",YOSHIEN1_JUKYUSHA_JISSHI_KBN");

    sb.append(",YOSHIEN2_JUKYUSHA_JISSHI_KBN");

    sb.append(",KOKUHO_ITAKU_KBN");

    sb.append(",SAKUSEI_DATE");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" M_SJ_SERVICE_CODE");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" SYSTEM_SERVICE_CODE_ITEM");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SYSTEM_SERVICE_CODE_ITEM", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" TEKIYO_ST_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("TEKIYO_ST_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");


    return sb.toString();
  }

  /**
   * 「総合事業サービスコード情報を取得する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_GET_M_SJ_SERVICE_CODE_INFO_DELETE_FLAG(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" SYSTEM_SERVICE_CODE_ITEM");

    sb.append(" FROM");

    sb.append(" M_SJ_SERVICE_CODE");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" SYSTEM_SERVICE_CODE_ITEM");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SYSTEM_SERVICE_CODE_ITEM", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" TEKIYO_ST_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("TEKIYO_ST_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" DELETE_FLG");

    sb.append(" =");

    sb.append(" 1");

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「総合事業サービスコードマスタ情報を登録する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_INSERT_M_SJ_SERVICE_CODE(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("INSERT INTO");

    sb.append(" M_SJ_SERVICE_CODE");

    sb.append("(");

    sb.append(" SYSTEM_SERVICE_CODE_ITEM");

    sb.append(",INSURER_ID");

    sb.append(",SYSTEM_SERVICE_KIND_DETAIL");

    sb.append(",TEKIYO_ST_DATE");

    sb.append(",TEKIYO_ED_DATE");

    sb.append(",SERVICE_CODE_KIND");

    sb.append(",SERVICE_CODE_ITEM");

    sb.append(",SERVICE_NAME");

    sb.append(",SERVICE_UNIT");

    sb.append(",SANTEI_TANI");

    sb.append(",SEIGEN_NISSU_KAISU");

    sb.append(",SANTEI_KAISU_SEIGEN_KIKAN");

    sb.append(",SHIKYU_GENDOGAKU_TAISHO_KBN");

    sb.append(",YOBI");

    sb.append(",KYUFURITSU");

    sb.append(",FUTANGAKU");

    sb.append(",JIGYO_TAISHOSHA_JISSHI_KBN");

    sb.append(",YOSHIEN1_JUKYUSHA_JISSHI_KBN");

    sb.append(",YOSHIEN2_JUKYUSHA_JISSHI_KBN");

    sb.append(",KOKUHO_ITAKU_KBN");

    sb.append(",SAKUSEI_DATE");

    sb.append(",DELETE_FLG");

    sb.append(",LAST_TIME");

    sb.append(")VALUES(");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SYSTEM_SERVICE_CODE_ITEM", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL", sqlParam)));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("TEKIYO_ST_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("TEKIYO_ED_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SERVICE_CODE_KIND", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SERVICE_CODE_ITEM", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SERVICE_NAME", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SERVICE_UNIT", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SANTEI_TANI", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SEIGEN_NISSU_KAISU", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SANTEI_KAISU_SEIGEN_KIKAN", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SHIKYU_GENDOGAKU_TAISHO_KBN", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("YOBI", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("KYUFURITSU", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("FUTANGAKU", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("JIGYO_TAISHOSHA_JISSHI_KBN", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("YOSHIEN1_JUKYUSHA_JISSHI_KBN", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("YOSHIEN2_JUKYUSHA_JISSHI_KBN", sqlParam)));

    sb.append(",");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("KOKUHO_ITAKU_KBN", sqlParam)));

    sb.append(",");

    sb.append(dateFormat.format(VRBindPathParser.get("SAKUSEI_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(" 0");

    sb.append(",");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(")");

    return sb.toString();
  }

  /**
   * 「総合事業サービスコードマスタ情報を更新する。」のためのSQLを返します。
   * @param sqlParam SQL構築に必要なパラメタを格納したハッシュマップ
   * @throws Exception 処理例外
   * @return SQL文
   */
  public String getSQL_UPDATE_M_SJ_SERVICE_CODE_INFO(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" M_SJ_SERVICE_CODE");

    sb.append(" SET");

    sb.append(" SYSTEM_SERVICE_CODE_ITEM");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SYSTEM_SERVICE_CODE_ITEM", sqlParam)));

    sb.append(",");

    sb.append(" INSURER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

    sb.append(",");

    sb.append(" SYSTEM_SERVICE_KIND_DETAIL");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL", sqlParam)));

    sb.append(",");

    sb.append(" TEKIYO_ST_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("TEKIYO_ST_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(" TEKIYO_ED_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("TEKIYO_ED_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(" SERVICE_CODE_KIND");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SERVICE_CODE_KIND", sqlParam)));

    sb.append(",");

    sb.append(" SERVICE_CODE_ITEM");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SERVICE_CODE_ITEM", sqlParam)));

    sb.append(",");

    sb.append(" SERVICE_NAME");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SERVICE_NAME", sqlParam)));

    sb.append(",");

    sb.append(" SERVICE_UNIT");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SERVICE_UNIT", sqlParam)));

    sb.append(",");

    sb.append(" SANTEI_TANI");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SANTEI_TANI", sqlParam)));

    sb.append(",");

    sb.append(" SEIGEN_NISSU_KAISU");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SEIGEN_NISSU_KAISU", sqlParam)));

    sb.append(",");

    sb.append(" SANTEI_KAISU_SEIGEN_KIKAN");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SANTEI_KAISU_SEIGEN_KIKAN", sqlParam)));

    sb.append(",");

    sb.append(" SHIKYU_GENDOGAKU_TAISHO_KBN");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SHIKYU_GENDOGAKU_TAISHO_KBN", sqlParam)));

    sb.append(",");

    sb.append(" YOBI");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("YOBI", sqlParam)));

    sb.append(",");

    sb.append(" KYUFURITSU");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("KYUFURITSU", sqlParam)));

    sb.append(",");

    sb.append(" FUTANGAKU");

    sb.append(" =");

    sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("FUTANGAKU", sqlParam)));

    sb.append(",");

    sb.append(" JIGYO_TAISHOSHA_JISSHI_KBN");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("JIGYO_TAISHOSHA_JISSHI_KBN", sqlParam)));

    sb.append(",");

    sb.append(" YOSHIEN1_JUKYUSHA_JISSHI_KBN");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("YOSHIEN1_JUKYUSHA_JISSHI_KBN", sqlParam)));

    sb.append(",");

    sb.append(" YOSHIEN2_JUKYUSHA_JISSHI_KBN");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("YOSHIEN2_JUKYUSHA_JISSHI_KBN", sqlParam)));

    sb.append(",");

    sb.append(" KOKUHO_ITAKU_KBN");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("KOKUHO_ITAKU_KBN", sqlParam)));

    sb.append(",");

    sb.append(" SAKUSEI_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("SAKUSEI_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(",");

    sb.append(" DELETE_FLG");

    sb.append(" =");

    sb.append(" 0");

    sb.append(",");

    sb.append(" LAST_TIME");

    sb.append(" =");

    sb.append(" CURRENT_TIMESTAMP");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" SYSTEM_SERVICE_CODE_ITEM");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SYSTEM_SERVICE_CODE_ITEM", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" TEKIYO_ST_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("TEKIYO_ST_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    return sb.toString();
  }

}
