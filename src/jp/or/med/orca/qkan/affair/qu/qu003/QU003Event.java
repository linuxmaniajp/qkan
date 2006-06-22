
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
 * 作成日: 2006/04/16  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 利用者管理 (U)
 * プロセス 医療看護情報画面 (003)
 * プログラム 医療看護情報画面 (QU003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu003;
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
 * 医療看護情報画面イベント定義(QU003) 
 */
public abstract class QU003Event extends QU003SQL {
  /**
   * コンストラクタです。
   */
  public QU003Event(){
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
    getMedicalInfoTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalInfoTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalInfoButtonClear().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalInfoButtonClearActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalInfoButtonInsert().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalInfoButtonInsertActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalInfoButtonConpile().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalInfoButtonConpileActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalInfoButtonDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalInfoButtonDeleteActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getSpecialInstructButton2().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                specialInstructButton2ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalInfoInsurerNo().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalInfoInsurerNoFocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalInfoInsurerName().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalInfoInsurerNameActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalInfoCitiesNo().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalInfoCitiesNoFocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalInfoCitiesName().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalInfoCitiesNameActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalTreatmentInfoOrgan().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalTreatmentInfoOrganActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalInfoInsuranceVarietyRadio2().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalInfoInsuranceVarietyRadio2SelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalInfoInsuranceVarietyRadio1().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalInfoInsuranceVarietyRadio1SelectionChanged(e);
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
   * 「DB登録」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void insertActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「DB更新」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void updateActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「対象レコードを表示」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void medicalInfoTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「クリア処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void medicalInfoButtonClearActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「追加処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void medicalInfoButtonInsertActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「編集処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void medicalInfoButtonConpileActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「削除処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void medicalInfoButtonDeleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「クリア処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void specialInstructButton2ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「画面処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void medicalInfoInsurerNoFocusLost(FocusEvent e) throws Exception;

  /**
   * 「画面処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void medicalInfoInsurerNameActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「画面処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void medicalInfoCitiesNoFocusLost(FocusEvent e) throws Exception;

  /**
   * 「画面処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void medicalInfoCitiesNameActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「画面処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void medicalTreatmentInfoOrganActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「画面処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void medicalInfoInsuranceVarietyRadio2SelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「画面処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void medicalInfoInsuranceVarietyRadio1SelectionChanged(ListSelectionEvent e) throws Exception;

  //変数定義

  private ACPassiveKey PASSIVE_CHECK_KEY;
  private int patientId;
  private int systemDate;
  private int processMode = QkanConstants.PROCESS_MODE_INSERT;
  private int medicalTableChangeFlg;
  private int medicalDataFlg;
  private int stationDataFlg;
  private int compulsoryBackFlg;
  public static final String AFFAIR_ID = "QU003";
  public static final int CODE_BENEFIT_RATE = 17;
  public static final int CODE_INSURE_TYPE = 15;
  public static final int CODE_HONNIN_KAZOKU = 14;
  public static final int INSURE_TYPE_KOHI = 3;
  public static final int STATION_HISTORY_ID = 1;
  public static final int CHECK_MODE_INSERT = 1;
  public static final int CHECK_MODE_UPDATE = 2;
  private String processStart;
  private VRList medicalHistoryList = new VRArrayList();
  private VRList stationHistoryList = new VRArrayList();
  private VRList medicalFacilityList = new VRArrayList();
  private VRList insurerList = new VRArrayList();
  private VRMap masterCode = new VRHashMap();
  private ACTableModelAdapter medicalTableModel;
  private ACSnapshot snapShotIryo = new ACSnapshot();
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
   * systemDateを返します。
   * @return systemDate
   */
  protected int getSystemDate(){
    return systemDate;
  }
  /**
   * systemDateを設定します。
   * @param systemDate systemDate
   */
  protected void setSystemDate(int systemDate){
    this.systemDate = systemDate;
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
   * medicalTableChangeFlgを返します。
   * @return medicalTableChangeFlg
   */
  protected int getMedicalTableChangeFlg(){
    return medicalTableChangeFlg;
  }
  /**
   * medicalTableChangeFlgを設定します。
   * @param medicalTableChangeFlg medicalTableChangeFlg
   */
  protected void setMedicalTableChangeFlg(int medicalTableChangeFlg){
    this.medicalTableChangeFlg = medicalTableChangeFlg;
  }

  /**
   * medicalDataFlgを返します。
   * @return medicalDataFlg
   */
  protected int getMedicalDataFlg(){
    return medicalDataFlg;
  }
  /**
   * medicalDataFlgを設定します。
   * @param medicalDataFlg medicalDataFlg
   */
  protected void setMedicalDataFlg(int medicalDataFlg){
    this.medicalDataFlg = medicalDataFlg;
  }

  /**
   * stationDataFlgを返します。
   * @return stationDataFlg
   */
  protected int getStationDataFlg(){
    return stationDataFlg;
  }
  /**
   * stationDataFlgを設定します。
   * @param stationDataFlg stationDataFlg
   */
  protected void setStationDataFlg(int stationDataFlg){
    this.stationDataFlg = stationDataFlg;
  }

  /**
   * compulsoryBackFlgを返します。
   * @return compulsoryBackFlg
   */
  protected int getCompulsoryBackFlg(){
    return compulsoryBackFlg;
  }
  /**
   * compulsoryBackFlgを設定します。
   * @param compulsoryBackFlg compulsoryBackFlg
   */
  protected void setCompulsoryBackFlg(int compulsoryBackFlg){
    this.compulsoryBackFlg = compulsoryBackFlg;
  }

  /**
   * processStartを返します。
   * @return processStart
   */
  protected String getProcessStart(){
    return processStart;
  }
  /**
   * processStartを設定します。
   * @param processStart processStart
   */
  protected void setProcessStart(String processStart){
    this.processStart = processStart;
  }

  /**
   * medicalHistoryListを返します。
   * @return medicalHistoryList
   */
  protected VRList getMedicalHistoryList(){
    return medicalHistoryList;
  }
  /**
   * medicalHistoryListを設定します。
   * @param medicalHistoryList medicalHistoryList
   */
  protected void setMedicalHistoryList(VRList medicalHistoryList){
    this.medicalHistoryList = medicalHistoryList;
  }

  /**
   * stationHistoryListを返します。
   * @return stationHistoryList
   */
  protected VRList getStationHistoryList(){
    return stationHistoryList;
  }
  /**
   * stationHistoryListを設定します。
   * @param stationHistoryList stationHistoryList
   */
  protected void setStationHistoryList(VRList stationHistoryList){
    this.stationHistoryList = stationHistoryList;
  }

  /**
   * medicalFacilityListを返します。
   * @return medicalFacilityList
   */
  protected VRList getMedicalFacilityList(){
    return medicalFacilityList;
  }
  /**
   * medicalFacilityListを設定します。
   * @param medicalFacilityList medicalFacilityList
   */
  protected void setMedicalFacilityList(VRList medicalFacilityList){
    this.medicalFacilityList = medicalFacilityList;
  }

  /**
   * insurerListを返します。
   * @return insurerList
   */
  protected VRList getInsurerList(){
    return insurerList;
  }
  /**
   * insurerListを設定します。
   * @param insurerList insurerList
   */
  protected void setInsurerList(VRList insurerList){
    this.insurerList = insurerList;
  }

  /**
   * masterCodeを返します。
   * @return masterCode
   */
  protected VRMap getMasterCode(){
    return masterCode;
  }
  /**
   * masterCodeを設定します。
   * @param masterCode masterCode
   */
  protected void setMasterCode(VRMap masterCode){
    this.masterCode = masterCode;
  }

  /**
   * medicalTableModelを返します。
   * @return medicalTableModel
   */
  protected ACTableModelAdapter getMedicalTableModel(){
    return medicalTableModel;
  }
  /**
   * medicalTableModelを設定します。
   * @param medicalTableModel medicalTableModel
   */
  protected void setMedicalTableModel(ACTableModelAdapter medicalTableModel){
    this.medicalTableModel = medicalTableModel;
  }

  /**
   * snapShotIryoを返します。
   * @return snapShotIryo
   */
  protected ACSnapshot getSnapShotIryo(){
    return snapShotIryo;
  }
  /**
   * snapShotIryoを設定します。
   * @param snapShotIryo snapShotIryo
   */
  protected void setSnapShotIryo(ACSnapshot snapShotIryo){
    this.snapShotIryo = snapShotIryo;
  }

  //内部関数

  /**
   * 「入力チェック」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean isValidInputStation() throws Exception;

  /**
   * 「入力チェック」に関する処理を行ないます。
   *
   * @param checkMode int
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean isValidInputMedical(int checkMode) throws Exception;

  /**
   * 「保存処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doSave() throws Exception;

  /**
   * 「レコード取得・画面設定」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * 「医療保険履歴を取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFindMedical() throws Exception;

  /**
   * 「訪問看護ステーション履歴を取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFindStation() throws Exception;

  /**
   * 「画面初期化」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void initialize() throws Exception;

  /**
   * 「画面設定」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void casualInitialize() throws Exception;

  /**
   * 「データ編集」に関する処理を行ないます。
   *
   * @param list VRList
   * @throws Exception 処理例外
   * @return VRList
   */
  public abstract VRList toMedicalTableList(VRList list) throws Exception;

  /**
   * 「データ編集」に関する処理を行ないます。
   *
   * @param map VRMap
   * @throws Exception 処理例外
   * @return VRMap
   */
  public abstract VRMap toMedicalTableList(VRMap map) throws Exception;

}
