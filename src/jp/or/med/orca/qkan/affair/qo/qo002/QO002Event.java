
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
 * 作成日: 2009/07/09  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 保険者管理 (002)
 * プログラム 保険者登録 (QO002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo002;
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
 * 保険者登録イベント定義(QO002) 
 */
public abstract class QO002Event extends QO002SQL {
  /**
   * コンストラクタです。
   */
  public QO002Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getInsurerSelectButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                insurerSelectButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInsurerLimitRateEnableCheck().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                insurerLimitRateEnableCheckActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInsurerLimitRateTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                insurerLimitRateTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInsurerLimitRateInsertButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                insurerLimitRateInsertButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInsurerLimitRateEditButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                insurerLimitRateEditButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInsurerLimitRateDeleteButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                insurerLimitRateDeleteButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInsurerLimitRateRegularButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                insurerLimitRateRegularButtonActionPerformed(e);
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

  }
  //コンポーネントイベント

  /**
   * 「保険者選択ボタン押下時」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void insurerSelectButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「区分支給限度額情報パネルを制御する」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void insurerLimitRateEnableCheckActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「対象レコードを表示」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void insurerLimitRateTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「追加処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void insurerLimitRateInsertButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「編集処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void insurerLimitRateEditButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「削除処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void insurerLimitRateDeleteButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「基準支給限度額を表示する処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void insurerLimitRateRegularButtonActionPerformed(ActionEvent e) throws Exception;

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
   * 「新規登録モード変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void newDataActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「画面情報のクリア」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void clearActionPerformed(ActionEvent e) throws Exception;

  //変数定義

  private ACPassiveKey INSURER_INFO_PASSIVE_CHECK_KEY;
  private String PROCESS_MODE;
  private String insurereId;
  private String affairMap;
  private int insurerLimitRateTableChangeFlg = 0;
  private VRMap insurerInfoMap = new VRHashMap();
  private VRMap insurerLimitRateMap = new VRHashMap();
  private VRList insurerInfoList = new VRArrayList();
  private VRList insurerLimitRateList = new VRArrayList();
  private VRList insurerLimitRateListSource = new VRArrayList();
  private ACTableModelAdapter insurerLimitRateTableModel;
  private ACSnapshot snapShotPeriod = new ACSnapshot();
  private ACDBManager masterInsurerDBManager;
  private QO002_InsurerRelation QO002_InsurerRelation;
  //getter/setter

  /**
   * INSURER_INFO_PASSIVE_CHECK_KEYを返します。
   * @return INSURER_INFO_PASSIVE_CHECK_KEY
   */
  protected ACPassiveKey getINSURER_INFO_PASSIVE_CHECK_KEY(){
    return INSURER_INFO_PASSIVE_CHECK_KEY;
  }
  /**
   * INSURER_INFO_PASSIVE_CHECK_KEYを設定します。
   * @param INSURER_INFO_PASSIVE_CHECK_KEY INSURER_INFO_PASSIVE_CHECK_KEY
   */
  protected void setINSURER_INFO_PASSIVE_CHECK_KEY(ACPassiveKey INSURER_INFO_PASSIVE_CHECK_KEY){
    this.INSURER_INFO_PASSIVE_CHECK_KEY = INSURER_INFO_PASSIVE_CHECK_KEY;
  }

  /**
   * PROCESS_MODEを返します。
   * @return PROCESS_MODE
   */
  protected String getPROCESS_MODE(){
    return PROCESS_MODE;
  }
  /**
   * PROCESS_MODEを設定します。
   * @param PROCESS_MODE PROCESS_MODE
   */
  protected void setPROCESS_MODE(String PROCESS_MODE){
    this.PROCESS_MODE = PROCESS_MODE;
  }

  /**
   * insurereIdを返します。
   * @return insurereId
   */
  protected String getInsurereId(){
    return insurereId;
  }
  /**
   * insurereIdを設定します。
   * @param insurereId insurereId
   */
  protected void setInsurereId(String insurereId){
    this.insurereId = insurereId;
  }

  /**
   * affairMapを返します。
   * @return affairMap
   */
  protected String getAffairMap(){
    return affairMap;
  }
  /**
   * affairMapを設定します。
   * @param affairMap affairMap
   */
  protected void setAffairMap(String affairMap){
    this.affairMap = affairMap;
  }

  /**
   * insurerLimitRateTableChangeFlgを返します。
   * @return insurerLimitRateTableChangeFlg
   */
  protected int getInsurerLimitRateTableChangeFlg(){
    return insurerLimitRateTableChangeFlg;
  }
  /**
   * insurerLimitRateTableChangeFlgを設定します。
   * @param insurerLimitRateTableChangeFlg insurerLimitRateTableChangeFlg
   */
  protected void setInsurerLimitRateTableChangeFlg(int insurerLimitRateTableChangeFlg){
    this.insurerLimitRateTableChangeFlg = insurerLimitRateTableChangeFlg;
  }

  /**
   * insurerInfoMapを返します。
   * @return insurerInfoMap
   */
  protected VRMap getInsurerInfoMap(){
    return insurerInfoMap;
  }
  /**
   * insurerInfoMapを設定します。
   * @param insurerInfoMap insurerInfoMap
   */
  protected void setInsurerInfoMap(VRMap insurerInfoMap){
    this.insurerInfoMap = insurerInfoMap;
  }

  /**
   * insurerLimitRateMapを返します。
   * @return insurerLimitRateMap
   */
  protected VRMap getInsurerLimitRateMap(){
    return insurerLimitRateMap;
  }
  /**
   * insurerLimitRateMapを設定します。
   * @param insurerLimitRateMap insurerLimitRateMap
   */
  protected void setInsurerLimitRateMap(VRMap insurerLimitRateMap){
    this.insurerLimitRateMap = insurerLimitRateMap;
  }

  /**
   * insurerInfoListを返します。
   * @return insurerInfoList
   */
  protected VRList getInsurerInfoList(){
    return insurerInfoList;
  }
  /**
   * insurerInfoListを設定します。
   * @param insurerInfoList insurerInfoList
   */
  protected void setInsurerInfoList(VRList insurerInfoList){
    this.insurerInfoList = insurerInfoList;
  }

  /**
   * insurerLimitRateListを返します。
   * @return insurerLimitRateList
   */
  protected VRList getInsurerLimitRateList(){
    return insurerLimitRateList;
  }
  /**
   * insurerLimitRateListを設定します。
   * @param insurerLimitRateList insurerLimitRateList
   */
  protected void setInsurerLimitRateList(VRList insurerLimitRateList){
    this.insurerLimitRateList = insurerLimitRateList;
  }

  /**
   * insurerLimitRateListSourceを返します。
   * @return insurerLimitRateListSource
   */
  protected VRList getInsurerLimitRateListSource(){
    return insurerLimitRateListSource;
  }
  /**
   * insurerLimitRateListSourceを設定します。
   * @param insurerLimitRateListSource insurerLimitRateListSource
   */
  protected void setInsurerLimitRateListSource(VRList insurerLimitRateListSource){
    this.insurerLimitRateListSource = insurerLimitRateListSource;
  }

  /**
   * insurerLimitRateTableModelを返します。
   * @return insurerLimitRateTableModel
   */
  protected ACTableModelAdapter getInsurerLimitRateTableModel(){
    return insurerLimitRateTableModel;
  }
  /**
   * insurerLimitRateTableModelを設定します。
   * @param insurerLimitRateTableModel insurerLimitRateTableModel
   */
  protected void setInsurerLimitRateTableModel(ACTableModelAdapter insurerLimitRateTableModel){
    this.insurerLimitRateTableModel = insurerLimitRateTableModel;
  }

  /**
   * snapShotPeriodを返します。
   * @return snapShotPeriod
   */
  protected ACSnapshot getSnapShotPeriod(){
    return snapShotPeriod;
  }
  /**
   * snapShotPeriodを設定します。
   * @param snapShotPeriod snapShotPeriod
   */
  protected void setSnapShotPeriod(ACSnapshot snapShotPeriod){
    this.snapShotPeriod = snapShotPeriod;
  }

  /**
   * masterInsurerDBManagerを返します。
   * @return masterInsurerDBManager
   */
  protected ACDBManager getMasterInsurerDBManager(){
    return masterInsurerDBManager;
  }
  /**
   * masterInsurerDBManagerを設定します。
   * @param masterInsurerDBManager masterInsurerDBManager
   */
  protected void setMasterInsurerDBManager(ACDBManager masterInsurerDBManager){
    this.masterInsurerDBManager = masterInsurerDBManager;
  }

  /**
   * QO002_InsurerRelationを返します。
   * @return QO002_InsurerRelation
   */
  protected QO002_InsurerRelation getQO002_InsurerRelation(){
    return QO002_InsurerRelation;
  }
  /**
   * QO002_InsurerRelationを設定します。
   * @param QO002_InsurerRelation QO002_InsurerRelation
   */
  protected void setQO002_InsurerRelation(QO002_InsurerRelation QO002_InsurerRelation){
    this.QO002_InsurerRelation = QO002_InsurerRelation;
  }

  //内部関数

  /**
   * 「レコードを取得し画面に設定する。」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * 「保険者情報取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFindInsurerInfo() throws Exception;

  /**
   * 「支給限度額情報取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFindInsurerLimitRate() throws Exception;

  /**
   * 「保存処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doSave() throws Exception;

  /**
   * 「支給限度額情報登録処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doSaveLimitRate() throws Exception;

  /**
   * 「渡しパラメーターを設定する。」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void setParameter() throws Exception;

  /**
   * 「保険者全情報入力チェック」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doValidCheck() throws Exception;

  /**
   * 「保険者基本情報入力チェック」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doValidInsurerInfoCheck() throws Exception;

  /**
   * 「支給限度額情報チェック処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doValidLimitRateCheck() throws Exception;

  /**
   * 「新規登録モードに変更する処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void insertModeChange() throws Exception;

  /**
   * 「画面をクリアする処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void allClear() throws Exception;

  /**
   * 「スナップショットを撮影する処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void snapshotCustom() throws Exception;

  /**
   * 「規定支給限度額を取得する処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return VRMap
   */
  public abstract VRMap doFindRegularLImitRate() throws Exception;

}
