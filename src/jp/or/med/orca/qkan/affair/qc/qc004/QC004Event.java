
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
 * 作成日: 2006/01/16  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 帳票管理 (C)
 * プロセス 訪問看護記録書Ⅰ (004)
 * プログラム 訪問看護記録書Ⅰ (QC004)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qc.qc004;

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

/**
 * 訪問看護記録書Ⅰイベント定義(QC004) 
 */
public abstract class QC004Event extends QC004SQL {
  /**
   * コンストラクタです。
   */
  public QC004Event(){
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
            }catch(Exception ex){
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
    getSyujiMedicalName().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                syujiMedicalNameActionPerformed(e);
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
   * 「読込み処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void openActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「印刷処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void printActionPerformed(ActionEvent e) throws Exception;

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
   * 「画面処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void syujiMedicalNameActionPerformed(ActionEvent e) throws Exception;

  //変数定義

  private ACPassiveKey PASSIVE_CHECK_KEY_KIROKUSHO;
  private int patientId;
  private int processMode;
  private Date targetDate;
  private VRMap patientMap = new VRHashMap();
  private VRMap stationMap = new VRHashMap();
  private VRMap providerMap = new VRHashMap();
  private VRMap kirokushoMap = new VRHashMap();
  private VRMap affairMap = new VRHashMap();
  private VRList providerList = new VRArrayList();
  private VRList kirokushoList = new VRArrayList();
  //getter/setter

  /**
   * PASSIVE_CHECK_KEY_KIROKUSHOを返します。
   * @return PASSIVE_CHECK_KEY_KIROKUSHO
   */
  protected ACPassiveKey getPASSIVE_CHECK_KEY_KIROKUSHO(){
    return PASSIVE_CHECK_KEY_KIROKUSHO;
  }
  /**
   * PASSIVE_CHECK_KEY_KIROKUSHOを設定します。
   * @param PASSIVE_CHECK_KEY_KIROKUSHO PASSIVE_CHECK_KEY_KIROKUSHO
   */
  protected void setPASSIVE_CHECK_KEY_KIROKUSHO(ACPassiveKey PASSIVE_CHECK_KEY_KIROKUSHO){
    this.PASSIVE_CHECK_KEY_KIROKUSHO = PASSIVE_CHECK_KEY_KIROKUSHO;
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
   * patientMapを返します。
   * @return patientMap
   */
  protected VRMap getPatientMap(){
    return patientMap;
  }
  /**
   * patientMapを設定します。
   * @param patientMap patientMap
   */
  protected void setPatientMap(VRMap patientMap){
    this.patientMap = patientMap;
  }

  /**
   * stationMapを返します。
   * @return stationMap
   */
  protected VRMap getStationMap(){
    return stationMap;
  }
  /**
   * stationMapを設定します。
   * @param stationMap stationMap
   */
  protected void setStationMap(VRMap stationMap){
    this.stationMap = stationMap;
  }

  /**
   * providerMapを返します。
   * @return providerMap
   */
  protected VRMap getProviderMap(){
    return providerMap;
  }
  /**
   * providerMapを設定します。
   * @param providerMap providerMap
   */
  protected void setProviderMap(VRMap providerMap){
    this.providerMap = providerMap;
  }

  /**
   * kirokushoMapを返します。
   * @return kirokushoMap
   */
  protected VRMap getKirokushoMap(){
    return kirokushoMap;
  }
  /**
   * kirokushoMapを設定します。
   * @param kirokushoMap kirokushoMap
   */
  protected void setKirokushoMap(VRMap kirokushoMap){
    this.kirokushoMap = kirokushoMap;
  }

  /**
   * affairMapを返します。
   * @return affairMap
   */
  protected VRMap getAffairMap(){
    return affairMap;
  }
  /**
   * affairMapを設定します。
   * @param affairMap affairMap
   */
  protected void setAffairMap(VRMap affairMap){
    this.affairMap = affairMap;
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

  /**
   * kirokushoListを返します。
   * @return kirokushoList
   */
  protected VRList getKirokushoList(){
    return kirokushoList;
  }
  /**
   * kirokushoListを設定します。
   * @param kirokushoList kirokushoList
   */
  protected void setKirokushoList(VRList kirokushoList){
    this.kirokushoList = kirokushoList;
  }

  //内部関数

  /**
   * 「パッシブチェック用データ登録」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFindPassive() throws Exception;

  /**
   * 「保存処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract boolean doSave() throws Exception;

  /**
   * 「登録処理を行う」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract boolean doInsert() throws Exception;

  /**
   * 「更新処理を行う」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract boolean doUpdate() throws Exception;

  /**
   * 「渡しパラメーター作成」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void setParameter(VRMap parameters) throws Exception;

  /**
   * 「訪問開始時間・訪問終了時間入力チェック」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doCheck() throws Exception;

  /**
   * 「訪問開始時間入力チェック」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doCheckStartTime() throws Exception;

  /**
   * 「訪問終了時間入力チェック」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doCheckEndTime() throws Exception;

  /**
   * 「医療機関情報コンボセット」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void getMedicalFacilityInfo() throws Exception;

}
