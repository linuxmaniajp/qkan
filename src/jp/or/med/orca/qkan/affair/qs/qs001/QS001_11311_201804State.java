
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
 * 作成日: 2018/02/23  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン訪問看護(介護) (QS001_11311_201804)
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
 * サービスパターン訪問看護(介護)状態定義(QS001_11311_201804) 
 */
public class QS001_11311_201804State extends QS001_11311_201804Design {
  /**
   * コンストラクタです。
   */
  public QS001_11311_201804State(){
  }

  /**
   * 「施設区分・ステーション」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_TYPE_STATION() throws Exception {

        getHoumonKangoKaigoClass().setEnabled(true);
        getHoumonKangoKaigoClass().getParent().setEnabled(true);

        getHoumonKangoKaigoClass3().setEnabled(true);

        getHoumonKangoKaigoLongTime().setEnabled(true);
        getHoumonKangoKaigoLongTime().getParent().setEnabled(true);

        getHoumonKangoNumberOfPeopleTime().setEnabled(true);
        getHoumonKangoNumberOfPeopleTime().getParent().setEnabled(true);

        getHoumonKangoKaigoTimeZone().setEnabled(true);
        getHoumonKangoKaigoTimeZone().getParent().setEnabled(true);

        getHoumonKangoNumberOfPeople().setEnabled(true);
        getHoumonKangoNumberOfPeople().getParent().setEnabled(true);

        getHoumonKangoKaigoTime().setEnabled(true);
        getHoumonKangoKaigoTime().getParent().setEnabled(true);

        getHoumonNissuReduceRadio().setEnabled(false);
        getHoumonNissuReduceRadio().getParent().setEnabled(false);

        getHoumonKangoKaigoUrgentTimeRadio().getParent().setVisible(true);

        getHoumonKangoKaigoUrgentTime2Radio().getParent().setVisible(false);

        getCrackOnDayCheck().setEnabled(false);

        getPrintable().setEnabled(false);

        getHoumonNeededRadio().setEnabled(true);
        getHoumonNeededRadio().getParent().setEnabled(true);

        getCareSupportSystem().setEnabled(true);
        getCareSupportSystem().getParent().setEnabled(true);

  }

  /**
   * 「施設区分・医療機関」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_TYPE_HOSPITAL() throws Exception {

        getHoumonKangoKaigoClass().setEnabled(true);
        getHoumonKangoKaigoClass().getParent().setEnabled(true);

        getHoumonKangoKaigoClass3().setEnabled(false);

        getHoumonKangoKaigoLongTime().setEnabled(true);
        getHoumonKangoKaigoLongTime().getParent().setEnabled(true);

        getHoumonKangoNumberOfPeopleTime().setEnabled(true);
        getHoumonKangoNumberOfPeopleTime().getParent().setEnabled(true);

        getHoumonKangoKaigoTimeZone().setEnabled(true);
        getHoumonKangoKaigoTimeZone().getParent().setEnabled(true);

        getHoumonKangoNumberOfPeople().setEnabled(true);
        getHoumonKangoNumberOfPeople().getParent().setEnabled(true);

        getHoumonKangoKaigoTime().setEnabled(true);
        getHoumonKangoKaigoTime().getParent().setEnabled(true);

        getHoumonNissuReduceRadio().setEnabled(false);
        getHoumonNissuReduceRadio().getParent().setEnabled(false);

        getHoumonKangoKaigoUrgentTimeRadio().getParent().setVisible(true);

        getHoumonKangoKaigoUrgentTime2Radio().getParent().setVisible(false);

        getCrackOnDayCheck().setEnabled(false);

        getPrintable().setEnabled(false);

        getHoumonNeededRadio().setEnabled(true);
        getHoumonNeededRadio().getParent().setEnabled(true);

        getCareSupportSystem().setEnabled(true);
        getCareSupportSystem().getParent().setEnabled(true);

  }

  /**
   * 「施設区分・定期巡回」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_TYPE_TEIKIJUNKAI() throws Exception {

        getHoumonKangoKaigoClass().setEnabled(true);
        getHoumonKangoKaigoClass().getParent().setEnabled(true);

        getHoumonKangoKaigoClass3().setEnabled(false);

        getHoumonKangoKaigoLongTime().setEnabled(false);
        getHoumonKangoKaigoLongTime().getParent().setEnabled(false);

        getHoumonKangoNumberOfPeopleTime().setEnabled(false);
        getHoumonKangoNumberOfPeopleTime().getParent().setEnabled(false);

        getHoumonKangoKaigoTimeZone().setEnabled(false);
        getHoumonKangoKaigoTimeZone().getParent().setEnabled(false);

        getHoumonKangoNumberOfPeople().setEnabled(false);
        getHoumonKangoNumberOfPeople().getParent().setEnabled(false);

        getHoumonKangoKaigoTime().setEnabled(false);
        getHoumonKangoKaigoTime().getParent().setEnabled(false);

        getHoumonNissuReduceRadio().setEnabled(true);
        getHoumonNissuReduceRadio().getParent().setEnabled(true);

        getHoumonKangoKaigoUrgentTimeRadio().getParent().setVisible(false);

        getHoumonKangoKaigoUrgentTime2Radio().getParent().setVisible(true);

        getCrackOnDayCheck().setEnabled(true);

        getHoumonNeededRadio().setEnabled(false);
        getHoumonNeededRadio().getParent().setEnabled(false);

        getCareSupportSystem().setEnabled(false);
        getCareSupportSystem().getParent().setEnabled(false);

  }

  /**
   * 「理学療法士の場合」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_WORKER_IS_PTOT() throws Exception {

        getHoumonKangoKaigoTime().setEnabled(false);
        getHoumonKangoKaigoTime().getParent().setEnabled(false);

        getTwoOrMoreTimesCheck().setEnabled(true);

  }

  /**
   * 「理学療法士以外の場合」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_WORKER_IS_NOT_PTOT() throws Exception {

        getHoumonKangoKaigoTime().setEnabled(true);
        getHoumonKangoKaigoTime().getParent().setEnabled(true);

        getTwoOrMoreTimesCheck().setEnabled(false);

  }

  /**
   * 「長時間訪問看護加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_LONG_TIME() throws Exception {

        getHoumonKangoKaigoLongTime().setEnabled(true);
        getHoumonKangoKaigoLongTime().getParent().setEnabled(true);

  }

  /**
   * 「長時間訪問看護加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_LONG_TIME() throws Exception {

        getHoumonKangoKaigoLongTime().setEnabled(false);
        getHoumonKangoKaigoLongTime().getParent().setEnabled(false);

  }

  /**
   * 「2人目の訪問時間・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_NUMBER_OF_PEOPLE_TIME() throws Exception {

        getHoumonKangoNumberOfPeopleTime().setEnabled(true);
        getHoumonKangoNumberOfPeopleTime().getParent().setEnabled(true);

  }

  /**
   * 「2人目の訪問時間・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_NUMBER_OF_PEOPLE_TIME() throws Exception {

        getHoumonKangoNumberOfPeopleTime().setEnabled(false);
        getHoumonKangoNumberOfPeopleTime().getParent().setEnabled(false);

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

}
