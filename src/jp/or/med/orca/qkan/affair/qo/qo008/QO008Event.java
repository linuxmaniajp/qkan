
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
 * 作成日: 2010/11/15  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 定型文編集 (008)
 * プログラム 定型文編集 (QO008)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo008;
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
 * 定型文編集イベント定義(QO008) 
 */
public abstract class QO008Event extends QO008SQL {
  /**
   * コンストラクタです。
   */
  public QO008Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
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
    getFixedFormTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                fixedFormTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getFixedFormEditItemTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                fixedFormEditItemTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getFixedFormEditInsert().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                fixedFormEditInsertActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getFixedFormEditUpdate().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                fixedFormEditUpdateActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getFixedFormEditDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                fixedFormEditDeleteActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getFixedFormEditCancelDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                fixedFormEditCancelDeleteActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getFixedFormEditItemManipulateButtonUp().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                fixedFormEditItemManipulateButtonUpActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getFixedFormEditItemManipulateButtonDown().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                fixedFormEditItemManipulateButtonDownActionPerformed(e);
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
   * 「更新処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void updateActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「表示データ切り替え処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void fixedFormTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「定型文表示処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void fixedFormEditItemTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「定型文追加処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void fixedFormEditInsertActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「定型文更新処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void fixedFormEditUpdateActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「定型文削除処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void fixedFormEditDeleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「定型文削除取消処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void fixedFormEditCancelDeleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「順番繰り上げ処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void fixedFormEditItemManipulateButtonUpActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「順番繰り下げ処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void fixedFormEditItemManipulateButtonDownActionPerformed(ActionEvent e) throws Exception;

  //変数定義

  private ACPassiveKey PASSIVE_CHECK_KEY;
  private int dataChangeFlag;
  private int tableType;
  private int fixedFormId;
  public static final String AFFAIR_ID = "QO008";
  public static final String PRINT_PROVIDER = "3-1";
  public static final int TABLE_TYPE_FIXED_FORM = 1;
  public static final int SQL_MODE_DEFAULT = 0;
  public static final int SQL_MODE_INSERT = 1;
  public static final int SQL_MODE_UPDATE = 2;
  public static final int SQL_MODE_INSERT_TO_UPDATE = 3;
  public static final int SQL_MODE_DELETE = 4;
  public static final int SQL_MODE_UPDATE_TO_DELETE = 6;
  private VRMap listGroupMap = new VRHashMap();
  private VRList fixedFormList = new VRArrayList();
  private ACTableModelAdapter fixedFormGroupTableModel;
  private ACTableModelAdapter fixedFormTableModel;
  private String selectedKey;
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
   * dataChangeFlagを返します。
   * @return dataChangeFlag
   */
  protected int getDataChangeFlag(){
    return dataChangeFlag;
  }
  /**
   * dataChangeFlagを設定します。
   * @param dataChangeFlag dataChangeFlag
   */
  protected void setDataChangeFlag(int dataChangeFlag){
    this.dataChangeFlag = dataChangeFlag;
  }

  /**
   * tableTypeを返します。
   * @return tableType
   */
  protected int getTableType(){
    return tableType;
  }
  /**
   * tableTypeを設定します。
   * @param tableType tableType
   */
  protected void setTableType(int tableType){
    this.tableType = tableType;
  }

  /**
   * fixedFormIdを返します。
   * @return fixedFormId
   */
  protected int getFixedFormId(){
    return fixedFormId;
  }
  /**
   * fixedFormIdを設定します。
   * @param fixedFormId fixedFormId
   */
  protected void setFixedFormId(int fixedFormId){
    this.fixedFormId = fixedFormId;
  }

  /**
   * listGroupMapを返します。
   * @return listGroupMap
   */
  protected VRMap getListGroupMap(){
    return listGroupMap;
  }
  /**
   * listGroupMapを設定します。
   * @param listGroupMap listGroupMap
   */
  protected void setListGroupMap(VRMap listGroupMap){
    this.listGroupMap = listGroupMap;
  }

  /**
   * fixedFormListを返します。
   * @return fixedFormList
   */
  protected VRList getFixedFormList(){
    return fixedFormList;
  }
  /**
   * fixedFormListを設定します。
   * @param fixedFormList fixedFormList
   */
  protected void setFixedFormList(VRList fixedFormList){
    this.fixedFormList = fixedFormList;
  }

  /**
   * fixedFormGroupTableModelを返します。
   * @return fixedFormGroupTableModel
   */
  protected ACTableModelAdapter getFixedFormGroupTableModel(){
    return fixedFormGroupTableModel;
  }
  /**
   * fixedFormGroupTableModelを設定します。
   * @param fixedFormGroupTableModel fixedFormGroupTableModel
   */
  protected void setFixedFormGroupTableModel(ACTableModelAdapter fixedFormGroupTableModel){
    this.fixedFormGroupTableModel = fixedFormGroupTableModel;
  }

  /**
   * fixedFormTableModelを返します。
   * @return fixedFormTableModel
   */
  protected ACTableModelAdapter getFixedFormTableModel(){
    return fixedFormTableModel;
  }
  /**
   * fixedFormTableModelを設定します。
   * @param fixedFormTableModel fixedFormTableModel
   */
  protected void setFixedFormTableModel(ACTableModelAdapter fixedFormTableModel){
    this.fixedFormTableModel = fixedFormTableModel;
  }

  /**
   * selectedKeyを返します。
   * @return selectedKey
   */
  protected String getSelectedKey(){
    return selectedKey;
  }
  /**
   * selectedKeyを設定します。
   * @param selectedKey selectedKey
   */
  protected void setSelectedKey(String selectedKey){
    this.selectedKey = selectedKey;
  }

  //内部関数

  /**
   * 「画面初期化」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void initialize() throws Exception;

  /**
   * 「検索処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * 「入力チェック」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean isValidInput() throws Exception;

  /**
   * 「保存処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doSave() throws Exception;

  /**
   * 「グループごとにまとめたMapを作成する。」に関する処理を行ないます。
   *
   * @param list VRList
   * @throws Exception 処理例外
   *
   */
  public abstract void createGroupMap(VRList list) throws Exception;

}
