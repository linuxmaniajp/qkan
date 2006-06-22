
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
 * 開発者: 堤 瑞樹
 * 作成日: 2006/02/02  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 帳票管理 (C)
 * プロセス 計画書情報入力 (001)
 * プログラム 計画書情報入力 (QC001)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qc.qc001;

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
import jp.or.med.orca.qkan.lib.*;

/**
 * 計画書情報入力イベント定義(QC001) 
 */
public abstract class QC001Event extends QC001SQL {
  /**
   * コンストラクタです。
   */
  public QC001Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getPrint().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                printActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getOpen().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                openActionPerformed(e);
            }catch(Exception ex){
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
    getProviderName().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                providerNameActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPlanNoteEditButtonAdd().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                planNoteEditButtonAddActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPlanNoteEditButtonEdit().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                planNoteEditButtonEditActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPlanNoteEditButtonDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                planNoteEditButtonDeleteActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPlanNoteEditButtonClear().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                planNoteEditButtonClearActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPlanNotes().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                planNotesSelectionChanged(e);
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
   * 「印刷処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void printActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「直近の訪問看護計画書情報の読込」イベントです。
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
   * 「選択事業所の管理者氏名の設定」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void providerNameActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「問題点・解決策の追加」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void planNoteEditButtonAddActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「問題点・解決策の更新」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void planNoteEditButtonEditActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「問題点・解決策の削除」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void planNoteEditButtonDeleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「問題点・解決策のクリア」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void planNoteEditButtonClearActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「セル選択イベント」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void planNotesSelectionChanged(ListSelectionEvent e) throws Exception;

  //変数定義

  private ACPassiveKey PASSIVE_CHECK_KEY_PLAN;
  private int patientID;
  private int processMode;
  private int noteCount;
  private boolean planNoteChangeFlag;
  private boolean forciblyBackCheckFlag;
  private Date targetDateSource;
  private VRMap planData = new VRHashMap();
  private VRList planNoteData = new VRArrayList();
  private VRList stationList = new VRArrayList();
  //getter/setter

  /**
   * PASSIVE_CHECK_KEY_PLANを返します。
   * @return PASSIVE_CHECK_KEY_PLAN
   */
  protected ACPassiveKey getPASSIVE_CHECK_KEY_PLAN(){
    return PASSIVE_CHECK_KEY_PLAN;
  }
  /**
   * PASSIVE_CHECK_KEY_PLANを設定します。
   * @param PASSIVE_CHECK_KEY_PLAN PASSIVE_CHECK_KEY_PLAN
   */
  protected void setPASSIVE_CHECK_KEY_PLAN(ACPassiveKey PASSIVE_CHECK_KEY_PLAN){
    this.PASSIVE_CHECK_KEY_PLAN = PASSIVE_CHECK_KEY_PLAN;
  }

  /**
   * patientIDを返します。
   * @return patientID
   */
  protected int getPatientID(){
    return patientID;
  }
  /**
   * patientIDを設定します。
   * @param patientID patientID
   */
  protected void setPatientID(int patientID){
    this.patientID = patientID;
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
   * noteCountを返します。
   * @return noteCount
   */
  protected int getNoteCount(){
    return noteCount;
  }
  /**
   * noteCountを設定します。
   * @param noteCount noteCount
   */
  protected void setNoteCount(int noteCount){
    this.noteCount = noteCount;
  }

  /**
   * planNoteChangeFlagを返します。
   * @return planNoteChangeFlag
   */
  protected boolean getPlanNoteChangeFlag(){
    return planNoteChangeFlag;
  }
  /**
   * planNoteChangeFlagを設定します。
   * @param planNoteChangeFlag planNoteChangeFlag
   */
  protected void setPlanNoteChangeFlag(boolean planNoteChangeFlag){
    this.planNoteChangeFlag = planNoteChangeFlag;
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
   * targetDateSourceを返します。
   * @return targetDateSource
   */
  protected Date getTargetDateSource(){
    return targetDateSource;
  }
  /**
   * targetDateSourceを設定します。
   * @param targetDateSource targetDateSource
   */
  protected void setTargetDateSource(Date targetDateSource){
    this.targetDateSource = targetDateSource;
  }

  /**
   * planDataを返します。
   * @return planData
   */
  protected VRMap getPlanData(){
    return planData;
  }
  /**
   * planDataを設定します。
   * @param planData planData
   */
  protected void setPlanData(VRMap planData){
    this.planData = planData;
  }

  /**
   * planNoteDataを返します。
   * @return planNoteData
   */
  protected VRList getPlanNoteData(){
    return planNoteData;
  }
  /**
   * planNoteDataを設定します。
   * @param planNoteData planNoteData
   */
  protected void setPlanNoteData(VRList planNoteData){
    this.planNoteData = planNoteData;
  }

  /**
   * stationListを返します。
   * @return stationList
   */
  protected VRList getStationList(){
    return stationList;
  }
  /**
   * stationListを設定します。
   * @param stationList stationList
   */
  protected void setStationList(VRList stationList){
    this.stationList = stationList;
  }

  //内部関数

  /**
   * 「ウィンドウタイトルの設定」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void initialize() throws Exception;

  /**
   * 「訪問看護計画書情報の取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * 「初期値の設定」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void setInitValue() throws Exception;

  /**
   * 「入力チェック(問題点・解決策)」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean checkNoteValue() throws Exception;

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
   * 「問題点・解決策情報の件数取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return int
   */
  public abstract int getNoteMaxCount() throws Exception;

  /**
   * 「事業所の管理者氏名取得」に関する処理を行ないます。
   *
   * @param rec VRMap
   * @throws Exception 処理例外
   * @return String
   */
  public abstract String getAdministratorName(VRMap rec) throws Exception;

  /**
   * 「入力チェック」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean checkValidInput() throws Exception;

}
