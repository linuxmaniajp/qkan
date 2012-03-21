
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
 * 作成日: 2011/12/07  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業所管理 (004)
 * プログラム 事業所登録 (QO004)
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
import jp.or.med.orca.qkan.text.*;
import jp.nichicom.ac.lib.care.claim.print.schedule.*;

/**
 * 事業所登録イベント定義(QO004) 
 */
public abstract class QO004Event extends QO004SQL {
  /**
   * コンストラクタです。
   */
  public QO004Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getReflection().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                reflectionActionPerformed(e);
            }catch(Throwable ex){
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
            }catch(Throwable ex){
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
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getProviderStaffTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                providerStaffTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getServiceKindTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                serviceKindTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getOfferCheck().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                offerCheckActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getProviderStaffInsert().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                providerStaffInsertActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getProviderStaffFind().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                providerStaffFindActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getProviderStaffDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                providerStaffDeleteActionPerformed(e);
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

  }
  //コンポーネントイベント

  /**
   * 「提供サービス情報反映」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void reflectionActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「新規登録モード」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void newDataActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「クリア処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void clearActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「対象レコードを画面に展開」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void providerStaffTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「対象レコードを画面に展開」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void serviceKindTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「サービスパネルの制御」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void offerCheckActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「担当者追加」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void providerStaffInsertActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「担当者編集」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void providerStaffFindActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「担当者削除」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void providerStaffDeleteActionPerformed(ActionEvent e) throws Exception;

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

  //変数定義

  private ACPassiveKey PROVIDER_PASSIVE_CHECK_KEY;
  public static final String AFFAIR_ID = "QO004";
  public static final String KAIGO_KANGO_NAME = "訪問看護";
  public static final String BIND_PATH_OF_MOUNTAINOUS_AREA_RAFIO = "2";
  public static final String BIND_PATH_OF_MOUNTAINOUS_AREA_SCALE = "3";
  public static final Date TARGET_DATE_20060401 = ACCastUtilities.toDate("2006/4/1", null);
  public static final Date TARGET_DATE_20051001 = ACCastUtilities.toDate("2005/10/1", null);
  public static final Date TARGET_DATE_20120401 = ACCastUtilities.toDate("2012/4/1", null);
  public static final int SERVICE_TYPE_KAIGO_KANGO = 11311;
  public static final int SERVICE_TYPE_CARE_PLAN = 14311;
  public static final int SERVICE_TYPE_OTHER = 90101;
  public static final int SERVICE_TYPE_ROUTINE = 90201;
  public static final int CODE_PROVIDER_TYPE = 195;
  public static final int CODE_LAW_VERSION = 202;
  public static final int DEFAULT_LAW_VERSION = 0;
  public static final int PROVIDER_TYPE_JIJIGYOSHO = 1;
  public static final int CHECK_MODE_INSERT = 1;
  public static final int CHECK_MODE_UPDATE = 2;
  private int providerStaffTableChangeFlag = 0;
  private int providerServiceTableChangeFlag = 0;
  private int STAFF_PROCESS_MODE;
  private int PROCESS_MODE;
  private int compulsoryBackFlag;
  private int currentServiceType;
  private int serviceDataExistenceFlag;
  private int staffDataExistenceFlag;
  private int menuDataExistenceFlag;
  private String selectedProviderId;
  private VRList providerServiceList = new VRArrayList();
  private VRList providerList = new VRArrayList();
  private VRList providerStaffList = new VRArrayList();
  private VRList providerMenuList = new VRArrayList();
  private VRList masterMenuList = new VRArrayList();
  private VRList filteredServiceList = new VRArrayList();
  private ACTableModelAdapter providerStaffTableModel;
  private ACTableModelAdapter providerServiceTableModel;
  private iProviderServicePanel providerServiceClass;
  private ACSnapshot serviceSnapshot = new ACSnapshot();
  private ACSnapshot staffSnapshot = new ACSnapshot();
  //getter/setter

  /**
   * PROVIDER_PASSIVE_CHECK_KEYを返します。
   * @return PROVIDER_PASSIVE_CHECK_KEY
   */
  protected ACPassiveKey getPROVIDER_PASSIVE_CHECK_KEY(){
    return PROVIDER_PASSIVE_CHECK_KEY;
  }
  /**
   * PROVIDER_PASSIVE_CHECK_KEYを設定します。
   * @param PROVIDER_PASSIVE_CHECK_KEY PROVIDER_PASSIVE_CHECK_KEY
   */
  protected void setPROVIDER_PASSIVE_CHECK_KEY(ACPassiveKey PROVIDER_PASSIVE_CHECK_KEY){
    this.PROVIDER_PASSIVE_CHECK_KEY = PROVIDER_PASSIVE_CHECK_KEY;
  }

  /**
   * providerStaffTableChangeFlagを返します。
   * @return providerStaffTableChangeFlag
   */
  protected int getProviderStaffTableChangeFlag(){
    return providerStaffTableChangeFlag;
  }
  /**
   * providerStaffTableChangeFlagを設定します。
   * @param providerStaffTableChangeFlag providerStaffTableChangeFlag
   */
  protected void setProviderStaffTableChangeFlag(int providerStaffTableChangeFlag){
    this.providerStaffTableChangeFlag = providerStaffTableChangeFlag;
  }

  /**
   * providerServiceTableChangeFlagを返します。
   * @return providerServiceTableChangeFlag
   */
  protected int getProviderServiceTableChangeFlag(){
    return providerServiceTableChangeFlag;
  }
  /**
   * providerServiceTableChangeFlagを設定します。
   * @param providerServiceTableChangeFlag providerServiceTableChangeFlag
   */
  protected void setProviderServiceTableChangeFlag(int providerServiceTableChangeFlag){
    this.providerServiceTableChangeFlag = providerServiceTableChangeFlag;
  }

  /**
   * STAFF_PROCESS_MODEを返します。
   * @return STAFF_PROCESS_MODE
   */
  protected int getSTAFF_PROCESS_MODE(){
    return STAFF_PROCESS_MODE;
  }
  /**
   * STAFF_PROCESS_MODEを設定します。
   * @param STAFF_PROCESS_MODE STAFF_PROCESS_MODE
   */
  protected void setSTAFF_PROCESS_MODE(int STAFF_PROCESS_MODE){
    this.STAFF_PROCESS_MODE = STAFF_PROCESS_MODE;
  }

  /**
   * PROCESS_MODEを返します。
   * @return PROCESS_MODE
   */
  protected int getPROCESS_MODE(){
    return PROCESS_MODE;
  }
  /**
   * PROCESS_MODEを設定します。
   * @param PROCESS_MODE PROCESS_MODE
   */
  protected void setPROCESS_MODE(int PROCESS_MODE){
    this.PROCESS_MODE = PROCESS_MODE;
  }

  /**
   * compulsoryBackFlagを返します。
   * @return compulsoryBackFlag
   */
  protected int getCompulsoryBackFlag(){
    return compulsoryBackFlag;
  }
  /**
   * compulsoryBackFlagを設定します。
   * @param compulsoryBackFlag compulsoryBackFlag
   */
  protected void setCompulsoryBackFlag(int compulsoryBackFlag){
    this.compulsoryBackFlag = compulsoryBackFlag;
  }

  /**
   * currentServiceTypeを返します。
   * @return currentServiceType
   */
  protected int getCurrentServiceType(){
    return currentServiceType;
  }
  /**
   * currentServiceTypeを設定します。
   * @param currentServiceType currentServiceType
   */
  protected void setCurrentServiceType(int currentServiceType){
    this.currentServiceType = currentServiceType;
  }

  /**
   * serviceDataExistenceFlagを返します。
   * @return serviceDataExistenceFlag
   */
  protected int getServiceDataExistenceFlag(){
    return serviceDataExistenceFlag;
  }
  /**
   * serviceDataExistenceFlagを設定します。
   * @param serviceDataExistenceFlag serviceDataExistenceFlag
   */
  protected void setServiceDataExistenceFlag(int serviceDataExistenceFlag){
    this.serviceDataExistenceFlag = serviceDataExistenceFlag;
  }

  /**
   * staffDataExistenceFlagを返します。
   * @return staffDataExistenceFlag
   */
  protected int getStaffDataExistenceFlag(){
    return staffDataExistenceFlag;
  }
  /**
   * staffDataExistenceFlagを設定します。
   * @param staffDataExistenceFlag staffDataExistenceFlag
   */
  protected void setStaffDataExistenceFlag(int staffDataExistenceFlag){
    this.staffDataExistenceFlag = staffDataExistenceFlag;
  }

  /**
   * menuDataExistenceFlagを返します。
   * @return menuDataExistenceFlag
   */
  protected int getMenuDataExistenceFlag(){
    return menuDataExistenceFlag;
  }
  /**
   * menuDataExistenceFlagを設定します。
   * @param menuDataExistenceFlag menuDataExistenceFlag
   */
  protected void setMenuDataExistenceFlag(int menuDataExistenceFlag){
    this.menuDataExistenceFlag = menuDataExistenceFlag;
  }

  /**
   * selectedProviderIdを返します。
   * @return selectedProviderId
   */
  protected String getSelectedProviderId(){
    return selectedProviderId;
  }
  /**
   * selectedProviderIdを設定します。
   * @param selectedProviderId selectedProviderId
   */
  protected void setSelectedProviderId(String selectedProviderId){
    this.selectedProviderId = selectedProviderId;
  }

  /**
   * providerServiceListを返します。
   * @return providerServiceList
   */
  protected VRList getProviderServiceList(){
    return providerServiceList;
  }
  /**
   * providerServiceListを設定します。
   * @param providerServiceList providerServiceList
   */
  protected void setProviderServiceList(VRList providerServiceList){
    this.providerServiceList = providerServiceList;
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
   * providerStaffListを返します。
   * @return providerStaffList
   */
  protected VRList getProviderStaffList(){
    return providerStaffList;
  }
  /**
   * providerStaffListを設定します。
   * @param providerStaffList providerStaffList
   */
  protected void setProviderStaffList(VRList providerStaffList){
    this.providerStaffList = providerStaffList;
  }

  /**
   * providerMenuListを返します。
   * @return providerMenuList
   */
  protected VRList getProviderMenuList(){
    return providerMenuList;
  }
  /**
   * providerMenuListを設定します。
   * @param providerMenuList providerMenuList
   */
  protected void setProviderMenuList(VRList providerMenuList){
    this.providerMenuList = providerMenuList;
  }

  /**
   * masterMenuListを返します。
   * @return masterMenuList
   */
  protected VRList getMasterMenuList(){
    return masterMenuList;
  }
  /**
   * masterMenuListを設定します。
   * @param masterMenuList masterMenuList
   */
  protected void setMasterMenuList(VRList masterMenuList){
    this.masterMenuList = masterMenuList;
  }

  /**
   * filteredServiceListを返します。
   * @return filteredServiceList
   */
  protected VRList getFilteredServiceList(){
    return filteredServiceList;
  }
  /**
   * filteredServiceListを設定します。
   * @param filteredServiceList filteredServiceList
   */
  protected void setFilteredServiceList(VRList filteredServiceList){
    this.filteredServiceList = filteredServiceList;
  }

  /**
   * providerStaffTableModelを返します。
   * @return providerStaffTableModel
   */
  protected ACTableModelAdapter getProviderStaffTableModel(){
    return providerStaffTableModel;
  }
  /**
   * providerStaffTableModelを設定します。
   * @param providerStaffTableModel providerStaffTableModel
   */
  protected void setProviderStaffTableModel(ACTableModelAdapter providerStaffTableModel){
    this.providerStaffTableModel = providerStaffTableModel;
  }

  /**
   * providerServiceTableModelを返します。
   * @return providerServiceTableModel
   */
  protected ACTableModelAdapter getProviderServiceTableModel(){
    return providerServiceTableModel;
  }
  /**
   * providerServiceTableModelを設定します。
   * @param providerServiceTableModel providerServiceTableModel
   */
  protected void setProviderServiceTableModel(ACTableModelAdapter providerServiceTableModel){
    this.providerServiceTableModel = providerServiceTableModel;
  }

  /**
   * providerServiceClassを返します。
   * @return providerServiceClass
   */
  protected iProviderServicePanel getProviderServiceClass(){
    return providerServiceClass;
  }
  /**
   * providerServiceClassを設定します。
   * @param providerServiceClass providerServiceClass
   */
  protected void setProviderServiceClass(iProviderServicePanel providerServiceClass){
    this.providerServiceClass = providerServiceClass;
  }

  /**
   * serviceSnapshotを返します。
   * @return serviceSnapshot
   */
  protected ACSnapshot getServiceSnapshot(){
    return serviceSnapshot;
  }
  /**
   * serviceSnapshotを設定します。
   * @param serviceSnapshot serviceSnapshot
   */
  protected void setServiceSnapshot(ACSnapshot serviceSnapshot){
    this.serviceSnapshot = serviceSnapshot;
  }

  /**
   * staffSnapshotを返します。
   * @return staffSnapshot
   */
  protected ACSnapshot getStaffSnapshot(){
    return staffSnapshot;
  }
  /**
   * staffSnapshotを設定します。
   * @param staffSnapshot staffSnapshot
   */
  protected void setStaffSnapshot(ACSnapshot staffSnapshot){
    this.staffSnapshot = staffSnapshot;
  }

  //内部関数

  /**
   * 「初期化」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void initialize() throws Exception;

  /**
   * 「画面の設定」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void affairSetUp() throws Exception;

  /**
   * 「事業所情報取得処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * 「事業所メニュー情報を取得する」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFindProviderMenu() throws Exception;

  /**
   * 「提供サービスリスト用のデータを作成する」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doCreateServiceTableData() throws Exception;

  /**
   * 「担当者情報取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doCreateStaffData() throws Exception;

  /**
   * 「担当者情報入力チェック」に関する処理を行ないます。
   *
   * @param checkMode int
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean isValidInputStaff(int checkMode) throws Exception;

  /**
   * 「保存処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doSave() throws Exception;

  /**
   * 「削除可能なサービスか判断する処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doCheckDeleteService() throws Exception;

  /**
   * 「事業所メニュー情報を登録する」に関する処理を行ないます。
   *
   * @param list VRList
   * @throws Exception 処理例外
   *
   */
  public abstract void insertProviderMenu(VRList list) throws Exception;

  /**
   * 「マスタメニューから情報を取得する処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void getMasterMenu() throws Exception;

  /**
   * 「事業所基本情報チェック」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doValidProviderCheck() throws Exception;

  /**
   * 「クリア処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void allClear() throws Exception;

  /**
   * 「サービス詳細情報の反映」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean reflect() throws Exception;

  /**
   * 「サービス詳細情報変更チェック」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean isModifiedOnService() throws Exception;

}
