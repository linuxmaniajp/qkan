
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
 * 作成日: 2009/08/03  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 保険者管理 (002)
 * プログラム 保険者登録 (QO002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo002;
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
 * 保険者登録状態定義(QO002) 
 */
public class QO002State extends QO002Design {
  /**
   * コンストラクタです。
   */
  public QO002State(){
  }

  /**
   * 「初期設定」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INIT_STATE() throws Exception {

        getInsurerLimitRateInsertButton().setEnabled(true);

        getInsurerLimitRateEditButton().setEnabled(false);

        getInsurerLimitRateDeleteButton().setEnabled(false);

        getInsert().setVisible(true);

        getUpdate().setVisible(false);

        getNewData().setVisible(false);

        getClear().setVisible(true);

        getInsurerId().setVisible(true);

        getInsurerLimitRateInfo().setEnabled(false);

        getValidPeriodStart().setEnabled(false);

        getValidPeriodEnd().setEnabled(false);

        getYosien().setEnabled(false);

        getYokaigo1().setEnabled(false);

        getYokaigo2().setEnabled(false);

        getYokaigo3().setEnabled(false);

        getYokaigo4().setEnabled(false);

        getYokaigo5().setEnabled(false);

        getInsurerLimitRateRegularButton().setEnabled(false);

        getInsurerLimitRateInsertButton().setEnabled(false);

        getInsurerLimitRateEditButton().setEnabled(false);

        getInsurerLimitRateDeleteButton().setEnabled(false);

        getInsurerSelectButton().setEnabled(false);

  }

  /**
   * 「支給限度額編集・削除不可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_NOT_POSSIBLE_FIND_AND_DELETE_LIMIT_RATE() throws Exception {

        getInsurerLimitRateInsertButton().setEnabled(true);

        getInsurerLimitRateEditButton().setEnabled(false);

        getInsurerLimitRateDeleteButton().setEnabled(false);

  }

  /**
   * 「支給限度額編集・削除可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_POSSIBLE_FIND_AND_DELETE_LIMIT_RATE() throws Exception {

        getInsurerLimitRateInsertButton().setEnabled(true);

        getInsurerLimitRateEditButton().setEnabled(true);

        getInsurerLimitRateDeleteButton().setEnabled(true);

  }

  /**
   * 「登録モード」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INSERT_STATE() throws Exception {

        getInsert().setVisible(true);

        getUpdate().setVisible(false);

        getNewData().setVisible(false);

        getClear().setVisible(true);

        getInsurerId().setEnabled(true);

        getInsurerSelectButton().setEnabled(true);

  }

  /**
   * 「更新モード」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_UPDATE_STATE() throws Exception {

        getInsert().setVisible(false);

        getUpdate().setVisible(true);

        getNewData().setVisible(true);

        getClear().setVisible(false);

        getInsurerId().setEnabled(false);

        getInsurerSelectButton().setEnabled(false);

  }

  /**
   * 「支給限度額編集可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INSURER_LIMIT_RATE_ENABLE_TRUE() throws Exception {

        getInsurerLimitRateInfo().setEnabled(true);

        getValidPeriodStart().setEnabled(true);

        getValidPeriodEnd().setEnabled(true);

        getYosien().setEnabled(true);

        getYokaigo1().setEnabled(true);

        getYokaigo2().setEnabled(true);

        getYokaigo3().setEnabled(true);

        getYokaigo4().setEnabled(true);

        getYokaigo5().setEnabled(true);

        getInsurerLimitRateRegularButton().setEnabled(true);

        getInsurerLimitRateInsertButton().setEnabled(true);

        getInsurerLimitRateEditButton().setEnabled(true);

        getInsurerLimitRateDeleteButton().setEnabled(true);

  }

  /**
   * 「支給限度額編集不可」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INSURER_LIMIT_RATE_ENABLE_FALSE() throws Exception {

        getInsurerLimitRateInfo().setEnabled(false);

        getValidPeriodStart().setEnabled(false);

        getValidPeriodEnd().setEnabled(false);

        getYosien().setEnabled(false);

        getYokaigo1().setEnabled(false);

        getYokaigo2().setEnabled(false);

        getYokaigo3().setEnabled(false);

        getYokaigo4().setEnabled(false);

        getYokaigo5().setEnabled(false);

        getInsurerLimitRateRegularButton().setEnabled(false);

        getInsurerLimitRateInsertButton().setEnabled(false);

        getInsurerLimitRateEditButton().setEnabled(false);

        getInsurerLimitRateDeleteButton().setEnabled(false);

        getInsurerLimitRateEnableCheck().setEnabled(false);

  }

  /**
   * 「保険者選択ボタン・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_INSURER_SELECT() throws Exception {

        getInsurerSelectButton().setEnabled(true);

  }

  /**
   * 「保険者選択ボタン・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_INSURER_SELECT() throws Exception {

        getInsurerSelectButton().setEnabled(false);

  }

}
