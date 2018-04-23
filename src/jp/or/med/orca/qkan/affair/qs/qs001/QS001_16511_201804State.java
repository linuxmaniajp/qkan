
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
 * 開発者: 樋口　雅彦
 * 作成日: 2016/11/28  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護予防通所介護 (QS001_16511_201804)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.sql.SQLException;
import java.text.*;
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
 * サービスパターン介護予防通所介護状態定義(QS001_16511_201804) 
 */
public class QS001_16511_201804State extends QS001_16511_201804Design {
  /**
   * コンストラクタです。
   */
  public QS001_16511_201804State(){
  }

  /**
   * 「日割チェック有り」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DAY_CHECK_ON() throws Exception {

        getPrintable().setEnabled(true);

  }

  /**
   * 「日割チェック無し」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_DAY_CHECK_OFF() throws Exception {

        getPrintable().setEnabled(false);

  }

  /**
   * 「生活機能向上グループ活動加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_ACTIVITY_ADD() throws Exception {

        getActivityAddRadio().setEnabled(true);
        getActivityAddRadio().getParent().setEnabled(true);

  }

  /**
   * 「生活機能向上グループ活動加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_ACTIVITY_ADD() throws Exception {

        getActivityAddRadio().setEnabled(false);
        getActivityAddRadio().getParent().setEnabled(false);

  }

  /**
   * 「運動器機能向上加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_MOVE_FUNCTION_ADD() throws Exception {

        getMoveFunctionImprovementAddRadio().setEnabled(true);
        getMoveFunctionImprovementAddRadio().getParent().setEnabled(true);

  }

  /**
   * 「運動器機能向上加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_MOVE_FUNCTION_ADD() throws Exception {

        getMoveFunctionImprovementAddRadio().setEnabled(false);
        getMoveFunctionImprovementAddRadio().getParent().setEnabled(false);

  }

  /**
   * 「栄養改善加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_NOURISHMENT_ADD() throws Exception {

        getNourishmentImprovementAddRadio().setEnabled(true);
        getNourishmentImprovementAddRadio().getParent().setEnabled(true);

  }

  /**
   * 「栄養改善加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_NOURISHMENT_ADD() throws Exception {

        getNourishmentImprovementAddRadio().setEnabled(false);
        getNourishmentImprovementAddRadio().getParent().setEnabled(false);

  }

  /**
   * 「口腔機能向上加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_MOUTH_ADD() throws Exception {

        getMouthFunctionImprovementAddRadio().setEnabled(true);
        getMouthFunctionImprovementAddRadio().getParent().setEnabled(true);

  }

  /**
   * 「口腔機能向上加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_MOUTH_ADD() throws Exception {

        getMouthFunctionImprovementAddRadio().setEnabled(false);
        getMouthFunctionImprovementAddRadio().getParent().setEnabled(false);

  }

  /**
   * 「選択的サービス複数実施加算」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_SENTAKU_ADD() throws Exception {

        getSentakutekiServiceRadio().setEnabled(true);
        getSentakutekiServiceRadio().getParent().setEnabled(true);

  }

  /**
   * 「選択的サービス複数実施加算」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_SENTAKU_ADD() throws Exception {

        getSentakutekiServiceRadio().setEnabled(false);
        getSentakutekiServiceRadio().getParent().setEnabled(false);

  }

}
