
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
 * 開発者: 日高　しのぶ
 * 作成日: 2018/02/18  日本コンピューター株式会社 日高　しのぶ 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業所登録 (004)
 * プログラム 介護保健施設サービス (QO004_15211_201804)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;
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
 * 介護保健施設サービス状態定義(QO004_15211_201804) 
 */
public class QO004_15211_201804State extends QO004_15211_201804Design {
  /**
   * コンストラクタです。
   */
  public QO004_15211_201804State(){
  }

  /**
   * 「パネル全体有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SET_PANEL_TRUE() throws Exception {

        getMainGroup().setEnabled(true);

  }

  /**
   * 「パネル全体無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_SET_PANEL_FALSE() throws Exception {

        getMainGroup().setEnabled(false);

  }

  /**
   * 「ユニットタイプ」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_UNIT() throws Exception {

        getUnitCareMaintenance().setEnabled(true);
        getUnitCareMaintenance().getParent().setEnabled(true);

  }

  /**
   * 「ノーマルタイプ」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_NORMAL() throws Exception {

        getUnitCareMaintenance().setEnabled(false);
        getUnitCareMaintenance().getParent().setEnabled(false);

  }

  /**
   * 「施設等区分療養型タイプ」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITIES_DIVISION_RYOYOGATA() throws Exception {

        getStaffAssignment1Division().setEnabled(false);
        getStaffAssignment1Division().getParent().setEnabled(false);

        getAggressiveSupportRadioGroup().setEnabled(false);
        getAggressiveSupportRadioGroup().getParent().setEnabled(false);

        getMedicalSystemUpkeep().setEnabled(true);
        getMedicalSystemUpkeep().getParent().setEnabled(true);

        getSpecialMedicalDetailsContainer().setEnabled(true);

        getRehabilitationDetailsContainer().setEnabled(true);

        getPressureUlcerManagement().setEnabled(false);
        getPressureUlcerManagement().getParent().setEnabled(false);

        getMedicalSystemUpkeep2().setEnabled(true);
        getMedicalSystemUpkeep2().getParent().setEnabled(true);

  }

  /**
   * 「施設等区分ノーマルタイプ」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITIES_DIVISION_NORMAL() throws Exception {

        getStaffAssignment1Division().setEnabled(true);
        getStaffAssignment1Division().getParent().setEnabled(true);

        getAggressiveSupportRadioGroup().setEnabled(true);
        getAggressiveSupportRadioGroup().getParent().setEnabled(true);

        getMedicalSystemUpkeep().setEnabled(false);
        getMedicalSystemUpkeep().getParent().setEnabled(false);

        getSpecialMedicalDetailsContainer().setEnabled(false);

        getRehabilitationDetailsContainer().setEnabled(false);

        getPressureUlcerManagement().setEnabled(true);
        getPressureUlcerManagement().getParent().setEnabled(true);

        getMedicalSystemUpkeep2().setEnabled(false);
        getMedicalSystemUpkeep2().getParent().setEnabled(false);

  }

  /**
   * 「施設等区分IVタイプ」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITIES_DIVISION_4() throws Exception {

        getStaffAssignment1Division().setEnabled(false);
        getStaffAssignment1Division().getParent().setEnabled(false);

        getAggressiveSupportRadioGroup().setEnabled(false);
        getAggressiveSupportRadioGroup().getParent().setEnabled(false);

        getMedicalSystemUpkeep().setEnabled(false);
        getMedicalSystemUpkeep().getParent().setEnabled(false);

        getSpecialMedicalDetailsContainer().setEnabled(false);

        getRehabilitationDetailsContainer().setEnabled(false);

        getPressureUlcerManagement().setEnabled(false);
        getPressureUlcerManagement().getParent().setEnabled(false);

        getMedicalSystemUpkeep2().setEnabled(false);
        getMedicalSystemUpkeep2().getParent().setEnabled(false);

  }

}
