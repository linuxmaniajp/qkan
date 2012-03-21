
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
 * 作成日: 2008/06/02  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 利用者管理 (U)
 * プロセス 利用者一覧 (001)
 * プログラム 利用者一覧 (QU001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu001;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.component.table.ACCheckBoxTableColumnPopupMenu;
import jp.nichicom.ac.component.table.event.ACCheckBoxTableColumnPopupMenuAdapter;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * 利用者一覧イベント定義(QU001) 
 */
public abstract class QU001Event extends QU001SQL {
  /**
   * コンストラクタです。
   */
  public QU001Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getFind().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                findActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getDetail().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                detailActionPerformed(e);
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
    getPlanInsert().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                planInsertActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getResultInsert().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                resultInsertActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                deleteActionPerformed(e);
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
    getPrintReport().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                printReportActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPatients().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                patientsSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPatients().addMouseListener(new MouseAdapter(){
        private boolean lockFlag = false;
        public void mouseClicked(MouseEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                if (e.getClickCount() == 2) {
                    patientsMouseClicked(e);
                }
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    if(getPatientChoiseColumn().getHeaderPopupMenu() instanceof ACCheckBoxTableColumnPopupMenu){      ((ACCheckBoxTableColumnPopupMenu)getPatientChoiseColumn().getHeaderPopupMenu()).addPopupMenuListener(new ACCheckBoxTableColumnPopupMenuAdapter(){
          private boolean lockFlag = false;
          public void allCheckMenuActionPerformed(ActionEvent e) {
              if (lockFlag) {
                  return;
              }
              lockFlag = true;
              try {
                  patientChoiseColumnCheckMenuActionPerformed(e);
              }catch(Throwable ex){
                  ACCommon.getInstance().showExceptionMessage(ex);
              }finally{
                  lockFlag = false;
              }
          }
       });
      ((ACCheckBoxTableColumnPopupMenu)getPatientChoiseColumn().getHeaderPopupMenu()).addPopupMenuListener(new ACCheckBoxTableColumnPopupMenuAdapter(){
          private boolean lockFlag = false;
          public void allUncheckMenuActionPerformed(ActionEvent e) {
              if (lockFlag) {
                  return;
              }
              lockFlag = true;
              try {
                  patientChoiseColumnCheckMenuActionPerformed(e);
              }catch(Throwable ex){
                  ACCommon.getInstance().showExceptionMessage(ex);
              }finally{
                  lockFlag = false;
              }
          }
       });
      ((ACCheckBoxTableColumnPopupMenu)getPatientChoiseColumn().getHeaderPopupMenu()).addPopupMenuListener(new ACCheckBoxTableColumnPopupMenuAdapter(){
          private boolean lockFlag = false;
          public void reverseCheckMenuActionPerformed(ActionEvent e) {
              if (lockFlag) {
                  return;
              }
              lockFlag = true;
              try {
                  patientChoiseColumnCheckMenuActionPerformed(e);
              }catch(Throwable ex){
                  ACCommon.getInstance().showExceptionMessage(ex);
              }finally{
                  lockFlag = false;
              }
          }
       });
    }    getProviderName().addActionListener(new ActionListener(){
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

  }
  //コンポーネントイベント

  /**
   * 「検索」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void findActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「詳細画面に遷移」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void detailActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「登録画面に遷移」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void insertActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「サービス予定に遷移」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void planInsertActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「サービス実績に遷移」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void resultInsertActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「利用者削除」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void deleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「利用者一覧印刷」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void printActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「帳票印刷」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void printReportActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「画面制御」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void patientsSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「画面遷移処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void patientsMouseClicked(MouseEvent e) throws Exception;

  /**
   * 「選択操作メニュークリック」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void patientChoiseColumnCheckMenuActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「事業所選択処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void providerNameActionPerformed(ActionEvent e) throws Exception;

  //変数定義

  private ACPassiveKey PASSIVE_CHECK_KEY;
  public static final String AFFAIR_ID = "QU001";
  public static final Date TARGET_DATE_20060401 = ACCastUtilities.toDate("2006/04/01", null);
  public static final int PRINT_NORMAL = 0;
  public static final int PRINT_NO_SELECT = 1;
  public static final int PRINT_EMPTY_AND_TARGET = 2;
  public static final int PRINT_ERROR = 99;
  private int patientId;
  private String nextAffair;
  private Date findTargetDate;
  private VRList patientData = new VRArrayList();
  private VRList kyotakuData = new VRArrayList();
  private ACTableModelAdapter patientTableModel;
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
   * nextAffairを返します。
   * @return nextAffair
   */
  protected String getNextAffair(){
    return nextAffair;
  }
  /**
   * nextAffairを設定します。
   * @param nextAffair nextAffair
   */
  protected void setNextAffair(String nextAffair){
    this.nextAffair = nextAffair;
  }

  /**
   * findTargetDateを返します。
   * @return findTargetDate
   */
  protected Date getFindTargetDate(){
    return findTargetDate;
  }
  /**
   * findTargetDateを設定します。
   * @param findTargetDate findTargetDate
   */
  protected void setFindTargetDate(Date findTargetDate){
    this.findTargetDate = findTargetDate;
  }

  /**
   * patientDataを返します。
   * @return patientData
   */
  protected VRList getPatientData(){
    return patientData;
  }
  /**
   * patientDataを設定します。
   * @param patientData patientData
   */
  protected void setPatientData(VRList patientData){
    this.patientData = patientData;
  }

  /**
   * kyotakuDataを返します。
   * @return kyotakuData
   */
  protected VRList getKyotakuData(){
    return kyotakuData;
  }
  /**
   * kyotakuDataを設定します。
   * @param kyotakuData kyotakuData
   */
  protected void setKyotakuData(VRList kyotakuData){
    this.kyotakuData = kyotakuData;
  }

  /**
   * patientTableModelを返します。
   * @return patientTableModel
   */
  protected ACTableModelAdapter getPatientTableModel(){
    return patientTableModel;
  }
  /**
   * patientTableModelを設定します。
   * @param patientTableModel patientTableModel
   */
  protected void setPatientTableModel(ACTableModelAdapter patientTableModel){
    this.patientTableModel = patientTableModel;
  }

  //内部関数

  /**
   * 「初期化処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void initialize() throws Exception;

  /**
   * 「検索」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * 「画面遷移処理」に関する処理を行ないます。
   *
   * @param patientId int
   * @throws Exception 処理例外
   *
   */
  public abstract void transferNext(int patientId) throws Exception;

  /**
   * 「入力チェック」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean checkValue() throws Exception;

  /**
   * 「利用者の要介護情報チェック」に関する処理を行ないます。
   *
   * @param patientId int
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean checkInsureInfo(int patientId) throws Exception;

  /**
   * 「居宅療養管理指導初期化処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doInitializeQC005() throws Exception;

  /**
   * 「居宅療養管理指導用の検索処理」に関する処理を行ないます。
   *
   * @param patientData VRList
   * @param sqlParam VRMap
   * @throws Exception 処理例外
   * @return VRList
   */
  public abstract VRList doFindQC005(VRList patientData, VRMap sqlParam) throws Exception;

  /**
   * 「手動検索処理」に関する処理を行ないます。
   *
   * @param targetList VRList
   * @param findParam VRMap
   * @param keys String[]
   * @throws Exception 処理例外
   * @return VRList 
   */
  public abstract VRList  doMultiFind(VRList targetList, VRMap findParam, String[] keys) throws Exception;

  /**
   * 「検索処理」に関する処理を行ないます。
   *
   * @param targetList VRList
   * @param findParam VRMap
   * @param filterKey String
   * @throws Exception 処理例外
   * @return VRList
   */
  public abstract VRList filterData(VRList targetList, VRMap findParam, String filterKey) throws Exception;

  /**
   * 「印刷メイン処理」に関する処理を行ないます。
   *
   * @param printData VRList
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doPrintQC005(VRList printData) throws Exception;

  /**
   * 「印刷対象データをチェックします」に関する処理を行ないます。
   *
   * @param patientData VRList
   * @throws Exception 処理例外
   * @return int
   */
  public abstract int checkPrintData(VRList patientData) throws Exception;

  /**
   * 「データ変換処理」に関する処理を行ないます。
   *
   * @param printParam VRMap
   * @throws Exception 処理例外
   * @return VRMap
   */
  public abstract VRMap parseQC005PrintData(VRMap printParam) throws Exception;

}
