
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
 * 作成日: 2006/05/11  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 帳票管理 (C)
 * プロセス 老人訪問看護・訪問看護情報提供書 (003)
 * プログラム 老人訪問看護・訪問看護の情報提供書 (QC003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qc.qc003;
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
import jp.or.med.orca.qkan.text.*;
import jp.nichicom.ac.lib.care.claim.print.schedule.*;

/**
 * 老人訪問看護・訪問看護の情報提供書イベント定義(QC003) 
 */
public abstract class QC003Event extends QC003SQL {
  /**
   * コンストラクタです。
   */
  public QC003Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getOpen().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                openActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInsert().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                insertActionPerformed(e);
            }catch(Throwable ex){
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
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPrint().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                printActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getProviderName().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                providerNameActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getHomonkaisuResultReadButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                homonkaisuResultReadButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });

  }
  //コンポーネントイベント

  /**
   * 「読込み処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void openActionPerformed(ActionEvent e) throws Exception;

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
   * 「印刷処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void printActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「画面処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void providerNameActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「訪問看護実績読込」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void homonkaisuResultReadButtonActionPerformed(ActionEvent e) throws Exception;

  //変数定義

  private ACPassiveKey PASSIVE_CHECK_JOHO_TEIKYOSHO;
  private boolean forciblyBackCheckFlag;
  private int patientId;
  private int homonkangoInfoemation;
  private int processMode;
  private int homonkango;
  private Date targetDate;
  private VRList providerList = new VRArrayList();
  //getter/setter

  /**
   * PASSIVE_CHECK_JOHO_TEIKYOSHOを返します。
   * @return PASSIVE_CHECK_JOHO_TEIKYOSHO
   */
  protected ACPassiveKey getPASSIVE_CHECK_JOHO_TEIKYOSHO(){
    return PASSIVE_CHECK_JOHO_TEIKYOSHO;
  }
  /**
   * PASSIVE_CHECK_JOHO_TEIKYOSHOを設定します。
   * @param PASSIVE_CHECK_JOHO_TEIKYOSHO PASSIVE_CHECK_JOHO_TEIKYOSHO
   */
  protected void setPASSIVE_CHECK_JOHO_TEIKYOSHO(ACPassiveKey PASSIVE_CHECK_JOHO_TEIKYOSHO){
    this.PASSIVE_CHECK_JOHO_TEIKYOSHO = PASSIVE_CHECK_JOHO_TEIKYOSHO;
  }

  /**
   * forciblyBackCheckFlagを返します。
   * @return forciblyBackCheckFlag
   */
  protected boolean getForciblyBackCheckFlag(){
    return forciblyBackCheckFlag;
  }
  /**
   * forciblyBackCheckFlagを設定します。
   * @param forciblyBackCheckFlag forciblyBackCheckFlag
   */
  protected void setForciblyBackCheckFlag(boolean forciblyBackCheckFlag){
    this.forciblyBackCheckFlag = forciblyBackCheckFlag;
  }

  /**
   * patientIdを返します。
   * @return patientId
   */
  protected int getPatientId(){
    return patientId;
  }
  /**
   * patientIdを設定します。
   * @param patientId patientId
   */
  protected void setPatientId(int patientId){
    this.patientId = patientId;
  }

  /**
   * homonkangoInfoemationを返します。
   * @return homonkangoInfoemation
   */
  protected int getHomonkangoInfoemation(){
    return homonkangoInfoemation;
  }
  /**
   * homonkangoInfoemationを設定します。
   * @param homonkangoInfoemation homonkangoInfoemation
   */
  protected void setHomonkangoInfoemation(int homonkangoInfoemation){
    this.homonkangoInfoemation = homonkangoInfoemation;
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

  /**
   * homonkangoを返します。
   * @return homonkango
   */
  protected int getHomonkango(){
    return homonkango;
  }
  /**
   * homonkangoを設定します。
   * @param homonkango homonkango
   */
  protected void setHomonkango(int homonkango){
    this.homonkango = homonkango;
  }

  /**
   * targetDateを返します。
   * @return targetDate
   */
  protected Date getTargetDate(){
    return targetDate;
  }
  /**
   * targetDateを設定します。
   * @param targetDate targetDate
   */
  protected void setTargetDate(Date targetDate){
    this.targetDate = targetDate;
  }

  /**
   * providerListを返します。
   * @return providerList
   */
  protected VRList getProviderList(){
    return providerList;
  }
  /**
   * providerListを設定します。
   * @param providerList providerList
   */
  protected void setProviderList(VRList providerList){
    this.providerList = providerList;
  }

  //内部関数

  /**
   * 「パッシブチェック情報登録」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFindPassive() throws Exception;

  /**
   * 「登録処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doInsert() throws Exception;

  /**
   * 「更新処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doUpdate() throws Exception;

  /**
   * 「入力チェック」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doCheck() throws Exception;

  /**
   * 「渡しパラメーター作成」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void setParameter() throws Exception;

  /**
   * 「訪問看護の情報提供書情報を取得する処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return VRList
   */
  public abstract VRList getJohoteikyoshoInfo() throws Exception;

  /**
   * 「訪問看護の実施回数を取得する処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return int
   */
  public abstract int getResultCount() throws Exception;

  /**
   * 「訪問看護の実施日数を取得する処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return int
   */
  public abstract int getResultDayCount() throws Exception;

  /**
   * 「情報提供先を取得します」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return String
   */
  public abstract String getJohoteikyosaki() throws Exception;

}
