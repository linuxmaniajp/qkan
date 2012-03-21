
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
 * 作成日: 2011/12/19  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 利用者管理 (U)
 * プロセス 利用者登録 (004)
 * プログラム 公費・社福軽減情報 (QU004)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu004;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Date;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.util.ACSnapshot;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

/**
 * 公費・社福軽減情報イベント定義(QU004) 
 */
@SuppressWarnings("serial")
public abstract class QU004Event extends QU004SQL {
  /**
   * コンストラクタです。
   */
  public QU004Event(){
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
    getKaigoInfoButtonClear().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoButtonClearActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoButtonInsert().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoButtonInsertActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoButtonConpile().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoButtonConpileActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoButtonDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoButtonDeleteActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoInsurerNo().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoInsurerNoFocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoBearName().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoBearNameActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoPublicExpense().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoPublicExpenseActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getShahukuInfoButtonClear().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                shahukuInfoButtonClearActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getShahukuInfoButtonInsert().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                shahukuInfoButtonInsertActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getShahukuInfoButtonConpile().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                shahukuInfoButtonConpileActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getShahukuInfoButtonDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                shahukuInfoButtonDeleteActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getShahukuInfoTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                shahukuInfoTableSelectionChanged(e);
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
   * 「介護公費情報クリア処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void kaigoInfoButtonClearActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「介護公費情報追加処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void kaigoInfoButtonInsertActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「介護公費情報編集処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void kaigoInfoButtonConpileActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「介護公費情報削除処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void kaigoInfoButtonDeleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「負担者番号入力時処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void kaigoInfoInsurerNoFocusLost(FocusEvent e) throws Exception;

  /**
   * 「介護公費情報展開処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void kaigoInfoTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「負担者名選択時処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void kaigoInfoBearNameActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「公費情報選択時処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void kaigoInfoPublicExpenseActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「クリア処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void shahukuInfoButtonClearActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「追加処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void shahukuInfoButtonInsertActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「編集処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void shahukuInfoButtonConpileActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「削除処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void shahukuInfoButtonDeleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「社会福祉減免情報展開処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void shahukuInfoTableSelectionChanged(ListSelectionEvent e) throws Exception;

  //変数定義

  private ACPassiveKey PASSIVE_CHECK_KEY;
  public static final int INSURE_TYPE_KAIGO = 1;
  public static final int INSURE_TYPE_SHAHUKU = 3;
  public static final int CHECK_MODE_INSERT = 1;
  public static final int CHECK_MODE_UPDATE = 2;
  public static final int TYPE_SHAHUKU = 7701;
  public static final int KAIGO_OTHER_KOHI = 9999;
  public static final int IRYO_OTHER_KOHI = 9998;
  public static final Date MAX_DATE = ACCastUtilities.toDate("9999/12/31", null);
  public static final Date MIN_DATE = ACCastUtilities.toDate("0001/01/01", null);
  private int patientId;
  private int systemDate;
  private int processMode = QkanConstants.PROCESS_MODE_INSERT;
  private int kaigoTableChangeFlg;
  private int shahukuTableChangeFlg;
  private int kohiDataFlg;
  private int compulsoryBackFlg;
  private String processStart;
  public static final String AFFAIR_ID = "QU004";
  private VRList masterKohiServiceList = new VRArrayList();
  private VRList patientKohiList = new VRArrayList();
  private VRList insurerList = new VRArrayList();
  private VRList masterKohiList = new VRArrayList();
  private VRMap masterService = new VRHashMap();
  private ACTableModelAdapter kaigoTableModel;
  private ACTableModelAdapter shahukuTableModel;
  private ACTableModelAdapter kaigoServiceTableModel;
  private ACTableModelAdapter shahukuServiceTableModel;
  private ACSnapshot snapShotKaigo = new ACSnapshot();
  private ACSnapshot snapShotShahuku = new ACSnapshot();
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
   * kaigoTableChangeFlgを返します。
   * @return kaigoTableChangeFlg
   */
  protected int getKaigoTableChangeFlg(){
    return kaigoTableChangeFlg;
  }
  /**
   * kaigoTableChangeFlgを設定します。
   * @param kaigoTableChangeFlg kaigoTableChangeFlg
   */
  protected void setKaigoTableChangeFlg(int kaigoTableChangeFlg){
    this.kaigoTableChangeFlg = kaigoTableChangeFlg;
  }

  /**
   * shahukuTableChangeFlgを返します。
   * @return shahukuTableChangeFlg
   */
  protected int getShahukuTableChangeFlg(){
    return shahukuTableChangeFlg;
  }
  /**
   * shahukuTableChangeFlgを設定します。
   * @param shahukuTableChangeFlg shahukuTableChangeFlg
   */
  protected void setShahukuTableChangeFlg(int shahukuTableChangeFlg){
    this.shahukuTableChangeFlg = shahukuTableChangeFlg;
  }

  /**
   * kohiDataFlgを返します。
   * @return kohiDataFlg
   */
  protected int getKohiDataFlg(){
    return kohiDataFlg;
  }
  /**
   * kohiDataFlgを設定します。
   * @param kohiDataFlg kohiDataFlg
   */
  protected void setKohiDataFlg(int kohiDataFlg){
    this.kohiDataFlg = kohiDataFlg;
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
   * masterKohiServiceListを返します。
   * @return masterKohiServiceList
   */
  protected VRList getMasterKohiServiceList(){
    return masterKohiServiceList;
  }
  /**
   * masterKohiServiceListを設定します。
   * @param masterKohiServiceList masterKohiServiceList
   */
  protected void setMasterKohiServiceList(VRList masterKohiServiceList){
    this.masterKohiServiceList = masterKohiServiceList;
  }

  /**
   * patientKohiListを返します。
   * @return patientKohiList
   */
  protected VRList getPatientKohiList(){
    return patientKohiList;
  }
  /**
   * patientKohiListを設定します。
   * @param patientKohiList patientKohiList
   */
  protected void setPatientKohiList(VRList patientKohiList){
    this.patientKohiList = patientKohiList;
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
   * masterKohiListを返します。
   * @return masterKohiList
   */
  protected VRList getMasterKohiList(){
    return masterKohiList;
  }
  /**
   * masterKohiListを設定します。
   * @param masterKohiList masterKohiList
   */
  protected void setMasterKohiList(VRList masterKohiList){
    this.masterKohiList = masterKohiList;
  }

  /**
   * masterServiceを返します。
   * @return masterService
   */
  protected VRMap getMasterService(){
    return masterService;
  }
  /**
   * masterServiceを設定します。
   * @param masterService masterService
   */
  protected void setMasterService(VRMap masterService){
    this.masterService = masterService;
  }

  /**
   * kaigoTableModelを返します。
   * @return kaigoTableModel
   */
  protected ACTableModelAdapter getKaigoTableModel(){
    return kaigoTableModel;
  }
  /**
   * kaigoTableModelを設定します。
   * @param kaigoTableModel kaigoTableModel
   */
  protected void setKaigoTableModel(ACTableModelAdapter kaigoTableModel){
    this.kaigoTableModel = kaigoTableModel;
  }

  /**
   * shahukuTableModelを返します。
   * @return shahukuTableModel
   */
  protected ACTableModelAdapter getShahukuTableModel(){
    return shahukuTableModel;
  }
  /**
   * shahukuTableModelを設定します。
   * @param shahukuTableModel shahukuTableModel
   */
  protected void setShahukuTableModel(ACTableModelAdapter shahukuTableModel){
    this.shahukuTableModel = shahukuTableModel;
  }

  /**
   * kaigoServiceTableModelを返します。
   * @return kaigoServiceTableModel
   */
  protected ACTableModelAdapter getKaigoServiceTableModel(){
    return kaigoServiceTableModel;
  }
  /**
   * kaigoServiceTableModelを設定します。
   * @param kaigoServiceTableModel kaigoServiceTableModel
   */
  protected void setKaigoServiceTableModel(ACTableModelAdapter kaigoServiceTableModel){
    this.kaigoServiceTableModel = kaigoServiceTableModel;
  }

  /**
   * shahukuServiceTableModelを返します。
   * @return shahukuServiceTableModel
   */
  protected ACTableModelAdapter getShahukuServiceTableModel(){
    return shahukuServiceTableModel;
  }
  /**
   * shahukuServiceTableModelを設定します。
   * @param shahukuServiceTableModel shahukuServiceTableModel
   */
  protected void setShahukuServiceTableModel(ACTableModelAdapter shahukuServiceTableModel){
    this.shahukuServiceTableModel = shahukuServiceTableModel;
  }

  /**
   * snapShotKaigoを返します。
   * @return snapShotKaigo
   */
  protected ACSnapshot getSnapShotKaigo(){
    return snapShotKaigo;
  }
  /**
   * snapShotKaigoを設定します。
   * @param snapShotKaigo snapShotKaigo
   */
  protected void setSnapShotKaigo(ACSnapshot snapShotKaigo){
    this.snapShotKaigo = snapShotKaigo;
  }

  /**
   * snapShotShahukuを返します。
   * @return snapShotShahuku
   */
  protected ACSnapshot getSnapShotShahuku(){
    return snapShotShahuku;
  }
  /**
   * snapShotShahukuを設定します。
   * @param snapShotShahuku snapShotShahuku
   */
  protected void setSnapShotShahuku(ACSnapshot snapShotShahuku){
    this.snapShotShahuku = snapShotShahuku;
  }

  //内部関数

  /**
   * 「レコード取得・画面設定」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * 「利用者公費情報取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFindPatientKohi() throws Exception;

  /**
   * 「負担者名検索」に関する処理を行ないます。
   *
   * @param insureType int
   * @throws Exception 処理例外
   *
   */
  public abstract void doFindInsurerName(int insureType) throws Exception;

  /**
   * 「負担者番号検索」に関する処理を行ないます。
   *
   * @param insureType int
   * @throws Exception 処理例外
   *
   */
  public abstract void doFindInsurerId(int insureType) throws Exception;

  /**
   * 「給付対象サービス検索」に関する処理を行ないます。
   *
   * @param kohiType int
   * @param insureType int
   * @throws Exception 処理例外
   *
   */
  public abstract void doFindTargetService(int kohiType, int insureType) throws Exception;

  /**
   * 「入力チェック」に関する処理を行ないます。
   *
   * @param insureType int
   * @param checkMode int
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean isValidInput(int insureType, int checkMode) throws Exception;

  /**
   * 「介護公費のチェック」に関する処理を行ないます。
   *
   * @param checkMode int
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doCheckKaigoKohi(int checkMode) throws Exception;

  /**
   * 「保存処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doSave() throws Exception;

  /**
   * 「利用者公費サービス情報展開」に関する処理を行ないます。
   *
   * @param kohiId int
   * @param insureType int
   * @throws Exception 処理例外
   *
   */
  public abstract void setPatientKohiService(int kohiId, int insureType) throws Exception;

  /**
   * 「利用者公費サービス情報を画面より取得」に関する処理を行ないます。
   *
   * @param kohiId int
   * @param insureType int
   * @throws Exception 処理例外
   * @return VRList
   */
  public abstract VRList getPatientKohiService(int kohiId, int insureType) throws Exception;

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
  public abstract VRList toKohiTableList(VRList list) throws Exception;

  /**
   * 「データ編集」に関する処理を行ないます。
   *
   * @param map VRMap
   * @throws Exception 処理例外
   * @return VRMap
   */
  public abstract VRMap toKohiTableList(VRMap map) throws Exception;

  /**
   * 「各保険のデータ取得」に関する処理を行ないます。
   *
   * @param list VRList
   * @param insureType int
   * @throws Exception 処理例外
   * @return VRList
   */
  public abstract VRList getListToSetTable(VRList list, int insureType) throws Exception;

  /**
   * 「データ編集」に関する処理を行ないます。
   *
   * @param map VRMap
   * @param mode String
   * @throws Exception 処理例外
   * @return VRMap
   */
  public abstract VRMap toShahukuTableList(VRMap map, String mode) throws Exception;

  /**
   * 「判定」に関する処理を行ないます。
   *
   * @param kohi VRMap
   * @param aimDate Date
   * @param showOldKohi int
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean canShowKohi(VRMap kohi, Date aimDate, int showOldKohi) throws Exception;

}
