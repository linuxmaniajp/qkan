
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
 * 作成日: 2006/01/24  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 帳票管理 (C)
 * プロセス 報告書情報入力 (002)
 * プログラム 報告書情報入力 (QC002)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qc.qc002;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * 報告書情報入力イベント定義(QC002) 
 */
public abstract class QC002Event extends QC002SQL {
  /**
   * コンストラクタです。
   */
  public QC002Event(){
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
    getResultReadButtonLeft().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                resultReadButtonLeftActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getResultReadButtonRight().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                resultReadButtonRightActionPerformed(e);
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
   * 「直近の訪問看護報告書情報の読込」イベントです。
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
   * 「訪問日情報（左）を展開する処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void resultReadButtonLeftActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「訪問日情報（右）を展開する処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void resultReadButtonRightActionPerformed(ActionEvent e) throws Exception;

  //変数定義

  private ACPassiveKey PASSIVE_CHECK_KEY_RESULT;
  private ACPassiveKey PASSIVE_CHECK_KEY_CALENDAR_LEFT;
  private ACPassiveKey PASSIVE_CHECK_KEY_CALENDAR_RIGHT;
  private int patientID;
  private int processMode;
  private int calendarLeftCount;
  private int calendarRightCount;
  private boolean loadedValueCalendarLeft;
  private boolean loadedValueCalendarRight;
  private boolean forciblyBackCheckFlag;
  private Date targetDateSource;
  private VRMap resultData = new VRHashMap();
  private VRList calendarData = new VRArrayList();
  //getter/setter

  /**
   * PASSIVE_CHECK_KEY_RESULTを返します。
   * @return PASSIVE_CHECK_KEY_RESULT
   */
  protected ACPassiveKey getPASSIVE_CHECK_KEY_RESULT(){
    return PASSIVE_CHECK_KEY_RESULT;
  }
  /**
   * PASSIVE_CHECK_KEY_RESULTを設定します。
   * @param PASSIVE_CHECK_KEY_RESULT PASSIVE_CHECK_KEY_RESULT
   */
  protected void setPASSIVE_CHECK_KEY_RESULT(ACPassiveKey PASSIVE_CHECK_KEY_RESULT){
    this.PASSIVE_CHECK_KEY_RESULT = PASSIVE_CHECK_KEY_RESULT;
  }

  /**
   * PASSIVE_CHECK_KEY_CALENDAR_LEFTを返します。
   * @return PASSIVE_CHECK_KEY_CALENDAR_LEFT
   */
  protected ACPassiveKey getPASSIVE_CHECK_KEY_CALENDAR_LEFT(){
    return PASSIVE_CHECK_KEY_CALENDAR_LEFT;
  }
  /**
   * PASSIVE_CHECK_KEY_CALENDAR_LEFTを設定します。
   * @param PASSIVE_CHECK_KEY_CALENDAR_LEFT PASSIVE_CHECK_KEY_CALENDAR_LEFT
   */
  protected void setPASSIVE_CHECK_KEY_CALENDAR_LEFT(ACPassiveKey PASSIVE_CHECK_KEY_CALENDAR_LEFT){
    this.PASSIVE_CHECK_KEY_CALENDAR_LEFT = PASSIVE_CHECK_KEY_CALENDAR_LEFT;
  }

  /**
   * PASSIVE_CHECK_KEY_CALENDAR_RIGHTを返します。
   * @return PASSIVE_CHECK_KEY_CALENDAR_RIGHT
   */
  protected ACPassiveKey getPASSIVE_CHECK_KEY_CALENDAR_RIGHT(){
    return PASSIVE_CHECK_KEY_CALENDAR_RIGHT;
  }
  /**
   * PASSIVE_CHECK_KEY_CALENDAR_RIGHTを設定します。
   * @param PASSIVE_CHECK_KEY_CALENDAR_RIGHT PASSIVE_CHECK_KEY_CALENDAR_RIGHT
   */
  protected void setPASSIVE_CHECK_KEY_CALENDAR_RIGHT(ACPassiveKey PASSIVE_CHECK_KEY_CALENDAR_RIGHT){
    this.PASSIVE_CHECK_KEY_CALENDAR_RIGHT = PASSIVE_CHECK_KEY_CALENDAR_RIGHT;
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
   * calendarLeftCountを返します。
   * @return calendarLeftCount
   */
  protected int getCalendarLeftCount(){
    return calendarLeftCount;
  }
  /**
   * calendarLeftCountを設定します。
   * @param calendarLeftCount calendarLeftCount
   */
  protected void setCalendarLeftCount(int calendarLeftCount){
    this.calendarLeftCount = calendarLeftCount;
  }

  /**
   * calendarRightCountを返します。
   * @return calendarRightCount
   */
  protected int getCalendarRightCount(){
    return calendarRightCount;
  }
  /**
   * calendarRightCountを設定します。
   * @param calendarRightCount calendarRightCount
   */
  protected void setCalendarRightCount(int calendarRightCount){
    this.calendarRightCount = calendarRightCount;
  }

  /**
   * loadedValueCalendarLeftを返します。
   * @return loadedValueCalendarLeft
   */
  protected boolean getLoadedValueCalendarLeft(){
    return loadedValueCalendarLeft;
  }
  /**
   * loadedValueCalendarLeftを設定します。
   * @param loadedValueCalendarLeft loadedValueCalendarLeft
   */
  protected void setLoadedValueCalendarLeft(boolean loadedValueCalendarLeft){
    this.loadedValueCalendarLeft = loadedValueCalendarLeft;
  }

  /**
   * loadedValueCalendarRightを返します。
   * @return loadedValueCalendarRight
   */
  protected boolean getLoadedValueCalendarRight(){
    return loadedValueCalendarRight;
  }
  /**
   * loadedValueCalendarRightを設定します。
   * @param loadedValueCalendarRight loadedValueCalendarRight
   */
  protected void setLoadedValueCalendarRight(boolean loadedValueCalendarRight){
    this.loadedValueCalendarRight = loadedValueCalendarRight;
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
   * resultDataを返します。
   * @return resultData
   */
  protected VRMap getResultData(){
    return resultData;
  }
  /**
   * resultDataを設定します。
   * @param resultData resultData
   */
  protected void setResultData(VRMap resultData){
    this.resultData = resultData;
  }

  /**
   * calendarDataを返します。
   * @return calendarData
   */
  protected VRList getCalendarData(){
    return calendarData;
  }
  /**
   * calendarDataを設定します。
   * @param calendarData calendarData
   */
  protected void setCalendarData(VRList calendarData){
    this.calendarData = calendarData;
  }

  //内部関数

  /**
   * 「ウィンドウタイトルの設定」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doInitialize() throws Exception;

  /**
   * 「訪問看護報告書情報の設定」に関する処理を行ないます。
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
   * 「登録済みの訪問日情報取得」に関する処理を行ないます。
   *
   * @param visitDate Date
   * @throws Exception 処理例外
   * @return VRList
   */
  public abstract VRList getVisitDataFromResult(Date visitDate) throws Exception;

  /**
   * 「サービス実績から訪問日を取得」に関する処理を行ないます。
   *
   * @param targetDate Date
   * @param type String
   * @throws Exception 処理例外
   * @return VRMap
   */
  public abstract VRMap getVisitDataFromService(Date targetDate, String type) throws Exception;

  /**
   * 「保存処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doInsert() throws Exception;

  /**
   * 「保存処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doUpdate() throws Exception;

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

  /**
   * 「訪問日のコンボデータを作成する処理」に関する処理を行ないます。
   *
   * @param targetDate Date
   * @param type String
   * @throws Exception 処理例外
   * @return VRMap
   */
  public abstract VRMap createCalendarData(Date targetDate, String type) throws Exception;

  /**
   * 「取得したカレンダーを画面に展開する処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void findCalendar() throws Exception;

  /**
   * 「画面に展開するカレンダーデータを作成する処理」に関する処理を行ないます。
   *
   * @param targetDate Date
   * @param type String
   * @throws Exception 処理例外
   * @return VRMap
   */
  public abstract VRMap createBindData(Date targetDate, String type) throws Exception;

  /**
   * 「保存に使用するデータを作成する処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return VRMap
   */
  public abstract VRMap createSaveData() throws Exception;

  /**
   * 「カレンダー情報を保存する処理」に関する処理を行ないます。
   *
   * @param leftList VRList
   * @param rightList VRList
   * @throws Exception 処理例外
   *
   */
  public abstract void doSaveCalendar(VRList leftList, VRList rightList) throws Exception;

  /**
   * 「カレンダーの初期値を設定する処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void initializeCalendar(boolean isLeft, boolean isRight) throws Exception;

}
