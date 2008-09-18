
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
 * 開発者: 上司　和善
 * 作成日: 2006/01/16  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 医療機関管理 (010)
 * プログラム 医療機関登録 (QO010)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qo.qo010;

import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
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
import jp.or.med.orca.qkan.lib.*;

/**
 * 医療機関登録イベント定義(QO010) 
 */
public abstract class QO010Event extends QO010SQL {
  /**
   * コンストラクタです。
   */
  public QO010Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getInsert().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                insertActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getUpdate().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                updateActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getNewData().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                newDataActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getClear().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                clearActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });

  }
  //コンポーネントイベント

  /**
   * 「登録処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void insertActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「更新処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void updateActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「画面クリア（更新モード時）」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void newDataActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「画面クリア（新規モード時）」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void clearActionPerformed(ActionEvent e) throws Exception;

  //変数定義

  private ACPassiveKey PASSIVE_CHECK_KEY;
  private int medicalFacilityId;
  private int processMode;
  public static final String AFFAIR_ID = "QO010";
  //getter/setter

  /**
   * PASSIVE_CHECK_KEYを返します。
   * @return PASSIVE_CHECK_KEY
   */
  protected ACPassiveKey getPASSIVE_CHECK_KEY(){
    return PASSIVE_CHECK_KEY;
  }
  /**
   * PASSIVE_CHECK_KEYを設定します。
   * @param PASSIVE_CHECK_KEY PASSIVE_CHECK_KEY
   */
  protected void setPASSIVE_CHECK_KEY(ACPassiveKey PASSIVE_CHECK_KEY){
    this.PASSIVE_CHECK_KEY = PASSIVE_CHECK_KEY;
  }

  /**
   * medicalFacilityIdを返します。
   * @return medicalFacilityId
   */
  protected int getMedicalFacilityId(){
    return medicalFacilityId;
  }
  /**
   * medicalFacilityIdを設定します。
   * @param medicalFacilityId medicalFacilityId
   */
  protected void setMedicalFacilityId(int medicalFacilityId){
    this.medicalFacilityId = medicalFacilityId;
  }

  /**
   * processModeを返します。
   * @return processMode
   */
  protected int getProcessMode(){
    return processMode;
  }
  /**
   * processModeを設定します。
   * @param processMode processMode
   */
  protected void setProcessMode(int processMode){
    this.processMode = processMode;
  }

  //内部関数

  /**
   * 「画面初期化」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void initialize() throws Exception;

  /**
   * 「検索処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * 「入力チェック」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean isValidInput() throws Exception;

  /**
   * 「保存処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract boolean doSave() throws Exception;

  /**
   * 「画面クリア処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doClear() throws Exception;

}
