
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
 * 開発者: 小笠　貴志
 * 作成日: 2007/12/13  日本コンピューター株式会社 小笠　貴志 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービス予定 (QS001)
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
import jp.or.med.orca.qkan.text.*;
import jp.nichicom.ac.lib.care.claim.print.schedule.*;

/**
 * サービス予定イベント定義(QS001) 
 */
public abstract class QS001Event extends QS001SQL implements ACDroppableListener {
  /**
   * コンストラクタです。
   */
  public QS001Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getPrintWeekly().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                printWeeklyActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPrintMonthly().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                printMonthlyActionPerformed(e);
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
    getOpenPlan().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                openPlanActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getClearPlan().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                clearPlanActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getOpenResult().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                openResultActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getClearResult().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                clearResultActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getServiceKindList().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                serviceKindListSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPatternList().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                patternListSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPatternAdd().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                patternAddActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPatternDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                patternDeleteActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPatternNameChange().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                patternNameChangeActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getServiceOfferEntrepreneur().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                serviceOfferEntrepreneurActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getServiceSet().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                serviceSetActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getServiceDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                serviceDeleteActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getChangeChart().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                changeChartActionPerformed(e);
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
   * 「印刷処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void printWeeklyActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「印刷処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void printMonthlyActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「DBへの登録」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void insertActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「DBへの更新」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void updateActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「過去データ読込」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void openPlanActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「画面クリア」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void clearPlanActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「予定データ読込」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void openResultActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「画面クリア」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void clearResultActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「サービス種類選択イベント」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void serviceKindListSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「サービスパターン選択イベント」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void patternListSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「サービスパターン登録」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void patternAddActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「サービスパターン削除」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void patternDeleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「サービスパターン名称変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void patternNameChangeActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「サービス内容の設定」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void serviceOfferEntrepreneurActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「サービス情報上書」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void serviceSetActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「サービス情報削除」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void serviceDeleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「週間表・月間表の切替」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void changeChartActionPerformed(ActionEvent e) throws Exception;

  //変数定義

  private int processMode;
  private int processType;
  private int patientID;
  private int selectedServiceKind;
  private int inSpecialFacilityFlag;
  private int oldFacilityUserFlag;
  private Date targetDate;
  private VRMap patientInfo = new VRHashMap();
  private VRMap passiveCheckSQLParam = new VRHashMap();
  private VRMap servicePatternHash = new VRHashMap();
  private VRMap nowSelectedService = new VRHashMap();
  private VRList nowServicePatterns = new VRArrayList();
  private VRList deleteReseveServicePatterns = new VRArrayList();
  private VRList insertReserveServicePatterns = new VRArrayList();
  private VRList serviceKindsList = new VRArrayList();
  private QS001001 weeklyPanel;
  private QS001002 monthlyPanel;
  private QS001Service selectedServiceClass;
  public static final int DAYLY_LIFE_SERVICE = 90201;
  private ACPassiveKey SERVICE_PASSIVE_CHECK_KEY;
  private QS001DaySchedule selectedServiceListBox;
  private QS001ServicePatternListCellRenderer sharedFocusCellRenderer;
  private QS001FollowTimeComboDocumentListener beginTimeFollowListener;
  private QS001FollowTimeComboDocumentListener endTimeFollowListener;
  private CareServiceCodeCalcurater calcurater;
  private boolean serviceModify = false;
  private boolean serviceListLockFlag = false;
  private Dimension servicePreferredSize;
  //getter/setter

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
   * processTypeを返します。
   * @return processType
   */
  protected int getProcessType(){
    return processType;
  }
  /**
   * processTypeを設定します。
   * @param processType processType
   */
  protected void setProcessType(int processType){
    this.processType = processType;
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
   * selectedServiceKindを返します。
   * @return selectedServiceKind
   */
  protected int getSelectedServiceKind(){
    return selectedServiceKind;
  }
  /**
   * selectedServiceKindを設定します。
   * @param selectedServiceKind selectedServiceKind
   */
  protected void setSelectedServiceKind(int selectedServiceKind){
    this.selectedServiceKind = selectedServiceKind;
  }

  /**
   * inSpecialFacilityFlagを返します。
   * @return inSpecialFacilityFlag
   */
  protected int getInSpecialFacilityFlag(){
    return inSpecialFacilityFlag;
  }
  /**
   * inSpecialFacilityFlagを設定します。
   * @param inSpecialFacilityFlag inSpecialFacilityFlag
   */
  protected void setInSpecialFacilityFlag(int inSpecialFacilityFlag){
    this.inSpecialFacilityFlag = inSpecialFacilityFlag;
  }

  /**
   * oldFacilityUserFlagを返します。
   * @return oldFacilityUserFlag
   */
  protected int getOldFacilityUserFlag(){
    return oldFacilityUserFlag;
  }
  /**
   * oldFacilityUserFlagを設定します。
   * @param oldFacilityUserFlag oldFacilityUserFlag
   */
  protected void setOldFacilityUserFlag(int oldFacilityUserFlag){
    this.oldFacilityUserFlag = oldFacilityUserFlag;
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
   * patientInfoを返します。
   * @return patientInfo
   */
  protected VRMap getPatientInfo(){
    return patientInfo;
  }
  /**
   * patientInfoを設定します。
   * @param patientInfo patientInfo
   */
  protected void setPatientInfo(VRMap patientInfo){
    this.patientInfo = patientInfo;
  }

  /**
   * passiveCheckSQLParamを返します。
   * @return passiveCheckSQLParam
   */
  protected VRMap getPassiveCheckSQLParam(){
    return passiveCheckSQLParam;
  }
  /**
   * passiveCheckSQLParamを設定します。
   * @param passiveCheckSQLParam passiveCheckSQLParam
   */
  protected void setPassiveCheckSQLParam(VRMap passiveCheckSQLParam){
    this.passiveCheckSQLParam = passiveCheckSQLParam;
  }

  /**
   * servicePatternHashを返します。
   * @return servicePatternHash
   */
  protected VRMap getServicePatternHash(){
    return servicePatternHash;
  }
  /**
   * servicePatternHashを設定します。
   * @param servicePatternHash servicePatternHash
   */
  protected void setServicePatternHash(VRMap servicePatternHash){
    this.servicePatternHash = servicePatternHash;
  }

  /**
   * nowSelectedServiceを返します。
   * @return nowSelectedService
   */
  protected VRMap getNowSelectedService(){
    return nowSelectedService;
  }
  /**
   * nowSelectedServiceを設定します。
   * @param nowSelectedService nowSelectedService
   */
  protected void setNowSelectedService(VRMap nowSelectedService){
    this.nowSelectedService = nowSelectedService;
  }

  /**
   * nowServicePatternsを返します。
   * @return nowServicePatterns
   */
  protected VRList getNowServicePatterns(){
    return nowServicePatterns;
  }
  /**
   * nowServicePatternsを設定します。
   * @param nowServicePatterns nowServicePatterns
   */
  protected void setNowServicePatterns(VRList nowServicePatterns){
    this.nowServicePatterns = nowServicePatterns;
  }

  /**
   * deleteReseveServicePatternsを返します。
   * @return deleteReseveServicePatterns
   */
  protected VRList getDeleteReseveServicePatterns(){
    return deleteReseveServicePatterns;
  }
  /**
   * deleteReseveServicePatternsを設定します。
   * @param deleteReseveServicePatterns deleteReseveServicePatterns
   */
  protected void setDeleteReseveServicePatterns(VRList deleteReseveServicePatterns){
    this.deleteReseveServicePatterns = deleteReseveServicePatterns;
  }

  /**
   * insertReserveServicePatternsを返します。
   * @return insertReserveServicePatterns
   */
  protected VRList getInsertReserveServicePatterns(){
    return insertReserveServicePatterns;
  }
  /**
   * insertReserveServicePatternsを設定します。
   * @param insertReserveServicePatterns insertReserveServicePatterns
   */
  protected void setInsertReserveServicePatterns(VRList insertReserveServicePatterns){
    this.insertReserveServicePatterns = insertReserveServicePatterns;
  }

  /**
   * serviceKindsListを返します。
   * @return serviceKindsList
   */
  protected VRList getServiceKindsList(){
    return serviceKindsList;
  }
  /**
   * serviceKindsListを設定します。
   * @param serviceKindsList serviceKindsList
   */
  protected void setServiceKindsList(VRList serviceKindsList){
    this.serviceKindsList = serviceKindsList;
  }

  /**
   * weeklyPanelを返します。
   * @return weeklyPanel
   */
  protected QS001001 getWeeklyPanel(){
    return weeklyPanel;
  }
  /**
   * weeklyPanelを設定します。
   * @param weeklyPanel weeklyPanel
   */
  protected void setWeeklyPanel(QS001001 weeklyPanel){
    this.weeklyPanel = weeklyPanel;
  }

  /**
   * monthlyPanelを返します。
   * @return monthlyPanel
   */
  public QS001002 getMonthlyPanel(){
    return monthlyPanel;
  }
  /**
   * monthlyPanelを設定します。
   * @param monthlyPanel monthlyPanel
   */
  public void setMonthlyPanel(QS001002 monthlyPanel){
    this.monthlyPanel = monthlyPanel;
  }

  /**
   * selectedServiceClassを返します。
   * @return selectedServiceClass
   */
  protected QS001Service getSelectedServiceClass(){
    return selectedServiceClass;
  }
  /**
   * selectedServiceClassを設定します。
   * @param selectedServiceClass selectedServiceClass
   */
  protected void setSelectedServiceClass(QS001Service selectedServiceClass){
    this.selectedServiceClass = selectedServiceClass;
  }

  /**
   * SERVICE_PASSIVE_CHECK_KEYを返します。
   * @return SERVICE_PASSIVE_CHECK_KEY
   */
  protected ACPassiveKey getSERVICE_PASSIVE_CHECK_KEY(){
    return SERVICE_PASSIVE_CHECK_KEY;
  }
  /**
   * SERVICE_PASSIVE_CHECK_KEYを設定します。
   * @param SERVICE_PASSIVE_CHECK_KEY SERVICE_PASSIVE_CHECK_KEY
   */
  protected void setSERVICE_PASSIVE_CHECK_KEY(ACPassiveKey SERVICE_PASSIVE_CHECK_KEY){
    this.SERVICE_PASSIVE_CHECK_KEY = SERVICE_PASSIVE_CHECK_KEY;
  }

  /**
   * selectedServiceListBoxを返します。
   * @return selectedServiceListBox
   */
  protected QS001DaySchedule getSelectedServiceListBox(){
    return selectedServiceListBox;
  }
  /**
   * selectedServiceListBoxを設定します。
   * @param selectedServiceListBox selectedServiceListBox
   */
  protected void setSelectedServiceListBox(QS001DaySchedule selectedServiceListBox){
    this.selectedServiceListBox = selectedServiceListBox;
  }

  /**
   * sharedFocusCellRendererを返します。
   * @return sharedFocusCellRenderer
   */
  protected QS001ServicePatternListCellRenderer getSharedFocusCellRenderer(){
    return sharedFocusCellRenderer;
  }
  /**
   * sharedFocusCellRendererを設定します。
   * @param sharedFocusCellRenderer sharedFocusCellRenderer
   */
  protected void setSharedFocusCellRenderer(QS001ServicePatternListCellRenderer sharedFocusCellRenderer){
    this.sharedFocusCellRenderer = sharedFocusCellRenderer;
  }

  /**
   * beginTimeFollowListenerを返します。
   * @return beginTimeFollowListener
   */
  protected QS001FollowTimeComboDocumentListener getBeginTimeFollowListener(){
    return beginTimeFollowListener;
  }
  /**
   * beginTimeFollowListenerを設定します。
   * @param beginTimeFollowListener beginTimeFollowListener
   */
  protected void setBeginTimeFollowListener(QS001FollowTimeComboDocumentListener beginTimeFollowListener){
    this.beginTimeFollowListener = beginTimeFollowListener;
  }

  /**
   * endTimeFollowListenerを返します。
   * @return endTimeFollowListener
   */
  protected QS001FollowTimeComboDocumentListener getEndTimeFollowListener(){
    return endTimeFollowListener;
  }
  /**
   * endTimeFollowListenerを設定します。
   * @param endTimeFollowListener endTimeFollowListener
   */
  protected void setEndTimeFollowListener(QS001FollowTimeComboDocumentListener endTimeFollowListener){
    this.endTimeFollowListener = endTimeFollowListener;
  }

  /**
   * calcuraterを返します。
   * @return calcurater
   */
  protected CareServiceCodeCalcurater getCalcurater(){
    return calcurater;
  }
  /**
   * calcuraterを設定します。
   * @param calcurater calcurater
   */
  protected void setCalcurater(CareServiceCodeCalcurater calcurater){
    this.calcurater = calcurater;
  }

  /**
   * serviceModifyを返します。
   * @return serviceModify
   */
  protected boolean getServiceModify(){
    return serviceModify;
  }
  /**
   * serviceModifyを設定します。
   * @param serviceModify serviceModify
   */
  protected void setServiceModify(boolean serviceModify){
    this.serviceModify = serviceModify;
  }

  /**
   * serviceListLockFlagを返します。
   * @return serviceListLockFlag
   */
  protected boolean getServiceListLockFlag(){
    return serviceListLockFlag;
  }
  /**
   * serviceListLockFlagを設定します。
   * @param serviceListLockFlag serviceListLockFlag
   */
  protected void setServiceListLockFlag(boolean serviceListLockFlag){
    this.serviceListLockFlag = serviceListLockFlag;
  }

  /**
   * servicePreferredSizeを返します。
   * @return servicePreferredSize
   */
  protected Dimension getServicePreferredSize(){
    return servicePreferredSize;
  }
  /**
   * servicePreferredSizeを設定します。
   * @param servicePreferredSize servicePreferredSize
   */
  protected void setServicePreferredSize(Dimension servicePreferredSize){
    this.servicePreferredSize = servicePreferredSize;
  }

  //内部関数

  /**
   * 「入力チェック」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean checkValidInput() throws Exception;

  /**
   * 「検索処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFind() throws Exception;

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
   * 「週間表表示」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void showWeekly() throws Exception;

  /**
   * 「月間表表示」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void showMonthly() throws Exception;

  /**
   * 「サービスパターン選択/未選択チェック」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void checkServicePatternSelected() throws Exception;

  /**
   * 「詳細内容D&D」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void pictureDragAndDrop() throws Exception;

  /**
   * 「予定データ読込」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doOpenResult() throws Exception;

  /**
   * 「サービスクラスの生成」に関する処理を行ないます。
   *
   * @param targetDate Date
   * @throws Exception 処理例外
   * @return ACPanel
   */
  public abstract ACPanel createServicePatternClass(Date targetDate) throws Exception;

  /**
   * 「サービスパネルのデータ取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return VRMap
   */
  public abstract VRMap createServiceData() throws Exception;

  /**
   * 「処理モードの確認」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void checkProcessMode() throws Exception;

  /**
   * 「月間/週間サービスリスト選択変更」に関する処理を行ないます。
   *
   * @param e ListSelectionEvent
   * @throws Exception 処理例外
   *
   */
  public abstract void serviceListSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「月間/週間サービスリストキー押下」に関する処理を行ないます。
   *
   * @param e KeyEvent
   * @throws Exception 処理例外
   *
   */
  public abstract void serviceListKeyDown(KeyEvent e) throws Exception;

  /**
   * 「選択サービスの削除」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void removeSelectedService() throws Exception;

  /**
   * 「サービスパターンの追加削除を実行」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void saveServicePattern() throws Exception;

  /**
   * 「サービス種類の選択設定」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void refleshServiceKind() throws Exception;

  /**
   * 「サービス未選択状態設定」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void clearServiceSelection() throws Exception;

  /**
   * 「最新週間予定読み込み」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doOpenPlan() throws Exception;

  /**
   * 「データ更新処理」に関する処理を行ないます。
   *
   * @param isInsert boolean
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doUpdateImpl(boolean isInsert) throws Exception;

  /**
   * 「データが存在しているかチェックします」に関する処理を行ないます。
   *
   * @param bindPaths String[]
   * @param service VRMap
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean checkValidSysteBindPath(String[] bindPaths, VRMap service) throws Exception;

}
