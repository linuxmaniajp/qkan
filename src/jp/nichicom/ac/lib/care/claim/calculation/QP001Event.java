
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
 * 開発者: 藤原　伸
 * 作成日: 2010/11/08  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 実績確定/請求書出力 (P)
 * プロセス 請求処理 (001)
 * プログラム 利用者一覧（請求） (QP001)
 *
 *****************************************************************
 */
package jp.nichicom.ac.lib.care.claim.calculation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.component.table.ACCheckBoxTableColumnPopupMenu;
import jp.nichicom.ac.component.table.event.ACCheckBoxTableColumnPopupMenuAdapter;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * 利用者一覧（請求）イベント定義(QP001) 
 */
@SuppressWarnings("serial")
public abstract class QP001Event extends QP001SQL {
  /**
   * コンストラクタです。
   */
  public QP001Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getEntry().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                entryActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
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
    getCommit().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                commitActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getCsvOut().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                csvOutActionPerformed(e);
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
    getInfoTable().addMouseListener(new MouseAdapter(){
        private boolean lockFlag = false;
        public void mouseClicked(MouseEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
            	setButtonState();	// 2014.12.11 Hitaka add
                if (e.getClickCount() == 2) {
                	infoTableSelectionchangedDouble(e);
                }
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInfoTableColumn3().addCellEditorListener(new CellEditorListener(){
        private boolean lockFlag = false;
        public void editingStopped(ChangeEvent e) {
          cellEditing(e);
        }
        public void editingCanceled(ChangeEvent e) {
          cellEditing(e);
        }
        public void cellEditing(ChangeEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
            	infoTableSelectionChanged(null);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInfoTableColumn4().addCellEditorListener(new CellEditorListener(){
        private boolean lockFlag = false;
        public void editingStopped(ChangeEvent e) {
          cellEditing(e);
        }
        public void editingCanceled(ChangeEvent e) {
          cellEditing(e);
        }
        public void cellEditing(ChangeEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
            	infoTableSelectionChanged(null);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });

    getInsurerNoText().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                insurerNoTextFocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInsurerNoConbo().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                insurerNoConboActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    if(getInfoTableColumn3().getHeaderPopupMenu() instanceof ACCheckBoxTableColumnPopupMenu){      ((ACCheckBoxTableColumnPopupMenu)getInfoTableColumn3().getHeaderPopupMenu()).addPopupMenuListener(new ACCheckBoxTableColumnPopupMenuAdapter(){
          private boolean lockFlag = false;
          public void allCheckMenuActionPerformed(ActionEvent e) {
              if (lockFlag) {
                  return;
              }
              lockFlag = true;
              try {
                  infoTableColumn3CheckMenuActionPerformed(e);
              }catch(Throwable ex){
                  ACCommon.getInstance().showExceptionMessage(ex);
              }finally{
                  lockFlag = false;
              }
          }
       });
      ((ACCheckBoxTableColumnPopupMenu)getInfoTableColumn3().getHeaderPopupMenu()).addPopupMenuListener(new ACCheckBoxTableColumnPopupMenuAdapter(){
          private boolean lockFlag = false;
          public void allUncheckMenuActionPerformed(ActionEvent e) {
              if (lockFlag) {
                  return;
              }
              lockFlag = true;
              try {
                  infoTableColumn3CheckMenuActionPerformed(e);
              }catch(Throwable ex){
                  ACCommon.getInstance().showExceptionMessage(ex);
              }finally{
                  lockFlag = false;
              }
          }
       });
      ((ACCheckBoxTableColumnPopupMenu)getInfoTableColumn3().getHeaderPopupMenu()).addPopupMenuListener(new ACCheckBoxTableColumnPopupMenuAdapter(){
          private boolean lockFlag = false;
          public void reverseCheckMenuActionPerformed(ActionEvent e) {
              if (lockFlag) {
                  return;
              }
              lockFlag = true;
              try {
                  infoTableColumn3CheckMenuActionPerformed(e);
              }catch(Throwable ex){
                  ACCommon.getInstance().showExceptionMessage(ex);
              }finally{
                  lockFlag = false;
              }
          }
       });
    }    if(getInfoTableColumn4().getHeaderPopupMenu() instanceof ACCheckBoxTableColumnPopupMenu){      ((ACCheckBoxTableColumnPopupMenu)getInfoTableColumn4().getHeaderPopupMenu()).addPopupMenuListener(new ACCheckBoxTableColumnPopupMenuAdapter(){
          private boolean lockFlag = false;
          public void allCheckMenuActionPerformed(ActionEvent e) {
              if (lockFlag) {
                  return;
              }
              lockFlag = true;
              try {
                  infoTableColumn4CheckMenuActionPerformed(e);
              }catch(Throwable ex){
                  ACCommon.getInstance().showExceptionMessage(ex);
              }finally{
                  lockFlag = false;
              }
          }
       });
      ((ACCheckBoxTableColumnPopupMenu)getInfoTableColumn4().getHeaderPopupMenu()).addPopupMenuListener(new ACCheckBoxTableColumnPopupMenuAdapter(){
          private boolean lockFlag = false;
          public void allUncheckMenuActionPerformed(ActionEvent e) {
              if (lockFlag) {
                  return;
              }
              lockFlag = true;
              try {
                  infoTableColumn4CheckMenuActionPerformed(e);
              }catch(Throwable ex){
                  ACCommon.getInstance().showExceptionMessage(ex);
              }finally{
                  lockFlag = false;
              }
          }
       });
      ((ACCheckBoxTableColumnPopupMenu)getInfoTableColumn4().getHeaderPopupMenu()).addPopupMenuListener(new ACCheckBoxTableColumnPopupMenuAdapter(){
          private boolean lockFlag = false;
          public void reverseCheckMenuActionPerformed(ActionEvent e) {
              if (lockFlag) {
                  return;
              }
              lockFlag = true;
              try {
                  infoTableColumn4CheckMenuActionPerformed(e);
              }catch(Throwable ex){
                  ACCommon.getInstance().showExceptionMessage(ex);
              }finally{
                  lockFlag = false;
              }
          }
       });
    }
    getPrintList().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                printListActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    
    getClaimDateUpdateChangePermit().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
            	claimDateChangePermitPerformed(e);
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
   * 「帳票（様式）・事業所選択に遷移」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void entryActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「検索」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void findActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「印刷」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void printActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「実績集計処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void commitActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「CSVファイル出力」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void csvOutActionPerformed(ActionEvent e) throws Exception;
  
  protected abstract void deleteActionPerformed(ActionEvent e) throws Exception;
  protected abstract void insurerNoConboActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「保険者テキストボックス入力時の処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void insurerNoTextFocusLost(FocusEvent e) throws Exception;

  /**
   * 「選択操作メニュークリック」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void infoTableColumn3CheckMenuActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「選択操作メニュークリック」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void infoTableColumn4CheckMenuActionPerformed(ActionEvent e) throws Exception;
  
  
  protected abstract void infoTableSelectionChanged(MouseEvent e) throws Exception;
  
  protected abstract void infoTableSelectionchangedDouble(MouseEvent e) throws Exception;
  protected abstract void printListActionPerformed(ActionEvent e) throws Exception;
  protected abstract void claimDateChangePermitPerformed(ActionEvent e) throws Exception;
  
  /**
   * 一覧の行選択（マウスクリック）時の業務ボタン表示設定処理」イベントです。
   * 2014.12.11 Shinobu Hitaka add
   * @param なし
   * @throws Exception 処理例外
   */
  protected abstract void setButtonState() throws Exception;
  
  //変数定義

  private ACPassiveKey PASSIVE_CHECK_KEY;
  private String affair;
  private VRList patientData = new VRArrayList();
  private VRList insureData = new VRArrayList();
  private ACTableModelAdapter patientTableModel;
  private VRMap masterServiceCache = new VRHashMap();
  private boolean isServiceByReceipt = false;
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
   * affairを返します。
   * @return affair
   */
  protected String getAffair(){
    return affair;
  }
  /**
   * affairを設定します。
   * @param affair affair
   */
  protected void setAffair(String affair){
    this.affair = affair;
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
   * insureDataを返します。
   * @return insureData
   */
  protected VRList getInsureData(){
    return insureData;
  }
  /**
   * insureDataを設定します。
   * @param insureData insureData
   */
  protected void setInsureData(VRList insureData){
    this.insureData = insureData;
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
  /**
   * masterServiceCacheを返します。
   * @return
   */
  protected VRMap getMasterServiceCache() {
	  return masterServiceCache;
  }
  /**
   * masterServiceCacheを設定します。
   * @param masterServiceCache masterServiceCache
   */
  protected void setMasterServiceCache(VRMap masterServiceCache) {
	  this.masterServiceCache = masterServiceCache;
  }
  
  /**
   * サービス種類ごとに領収書を発行するか。
   * @return
   */
  protected boolean isServiceByReceipt() {
	  return isServiceByReceipt;
  }
  /**
   * サービス種類ごとに領収書を発行するかのフラグを設定します。
   * @param isServiceByReceipt isServiceByReceipt
   */
  protected void setServiceByReceipt(boolean isServiceByReceipt) {
	  this.isServiceByReceipt = isServiceByReceipt;
  }

  //内部関数

  /**
   * 「検索条件の取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * 「実績データの取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doTotal() throws Exception;

  /**
   * 「事業者毎の実績集計」に関する処理を行ないます。
   *
   * @param patient VRList
   * @param serviceDetailList VRList
   * @param providerData VRList
   * @throws Exception 処理例外
   *
   */
  public abstract int doTotalDetail(VRMap patient, VRList servicePlanList,VRList serviceDetailList,QP001Manager manager, QP001TotalErrors errors) throws Exception;

  /**
   * 「利用者選択の確認」に関する処理を行ないます。
   *
   * @param fieldName String
   * @param processName String
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean checkSelect(String fieldName, String processName) throws Exception;


  /**
   * 「検索前チェック」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean checkFind() throws Exception;

}
