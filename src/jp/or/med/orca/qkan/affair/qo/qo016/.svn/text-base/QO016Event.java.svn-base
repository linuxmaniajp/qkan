
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
 * 開発者: 
 * 作成日: 2016/09/14  日本コンピューター株式会社  新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 総合事業サービスコード管理 (016)
 * プログラム 総合事業サービスコード一覧 (QO016)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo016;
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
 * 総合事業サービスコード一覧イベント定義(QO016) 
 */
public abstract class QO016Event extends QO016SQL {
  /**
   * コンストラクタです。
   */
  public QO016Event(){
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
    getSjServiceCodeInfoTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                sjServiceCodeInfoTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getSjServiceCodeInfoTable().addMouseListener(new MouseAdapter(){
        private boolean lockFlag = false;
        public void mouseClicked(MouseEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                if (e.getClickCount() == 2) {
                    sjServiceCodeInfoTableMouseClicked(e);
                }
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
    getInsurerNoCombo().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                insurerNoComboActionPerformed(e);
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
   * 「検索処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void findActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「総合事業サービスコード登録画面に遷移（更新）」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void detailActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「総合事業サービスコード登録画面に遷移（新規）」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void insertActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「削除処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void deleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「画面制御」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void sjServiceCodeInfoTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「画面遷移処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void sjServiceCodeInfoTableMouseClicked(MouseEvent e) throws Exception;

  /**
   * 「保険者名表示」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void insurerNoTextFocusLost(FocusEvent e) throws Exception;

  /**
   * 「保険者番号表示」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void insurerNoComboActionPerformed(ActionEvent e) throws Exception;

  //変数定義

  private ACPassiveKey M_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY;
  private int PROCESS_MODE;
  private String systemServiceCodeItem;
  private String sjServiceCodeHistoryId;
  private Date tekiyoStDate;
  private VRMap affairMap = new VRHashMap();
  private VRList sjServiceCodeInfoList = new VRArrayList();
  private ACTableModelAdapter sjServiceCodeInfoTableModel;
  //getter/setter

  /**
   * M_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEYを返します。
   * @return M_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY
   */
  protected ACPassiveKey getM_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY(){
    return M_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY;
  }
  /**
   * M_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEYを設定します。
   * @param M_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY M_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY
   */
  protected void setM_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY(ACPassiveKey M_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY){
    this.M_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY = M_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY;
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
   * systemServiceCodeItemを返します。
   * @return systemServiceCodeItem
   */
  protected String getSystemServiceCodeItem(){
    return systemServiceCodeItem;
  }
  /**
   * systemServiceCodeItemを設定します。
   * @param systemServiceCodeItem systemServiceCodeItem
   */
  protected void setSystemServiceCodeItem(String systemServiceCodeItem){
    this.systemServiceCodeItem = systemServiceCodeItem;
  }

  /**
   * sjServiceCodeHistoryIdを返します。
   * @return sjServiceCodeHistoryId
   */
  protected String getSjServiceCodeHistoryId(){
    return sjServiceCodeHistoryId;
  }
  /**
   * sjServiceCodeHistoryIdを設定します。
   * @param sjServiceCodeHistoryId sjServiceCodeHistoryId
   */
  protected void setSjServiceCodeHistoryId(String sjServiceCodeHistoryId){
    this.sjServiceCodeHistoryId = sjServiceCodeHistoryId;
  }

  /**
   * tekiyoStDateを返します。
   * @return tekiyoStDate
   */
  protected Date getTekiyoStDate(){
    return tekiyoStDate;
  }
  /**
   * tekiyoStDateを設定します。
   * @param tekiyoStDate tekiyoStDate
   */
  protected void setTekiyoStDate(Date tekiyoStDate){
    this.tekiyoStDate = tekiyoStDate;
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
   * sjServiceCodeInfoListを返します。
   * @return sjServiceCodeInfoList
   */
  protected VRList getSjServiceCodeInfoList(){
    return sjServiceCodeInfoList;
  }
  /**
   * sjServiceCodeInfoListを設定します。
   * @param sjServiceCodeInfoList sjServiceCodeInfoList
   */
  protected void setSjServiceCodeInfoList(VRList sjServiceCodeInfoList){
    this.sjServiceCodeInfoList = sjServiceCodeInfoList;
  }

  /**
   * sjServiceCodeInfoTableModelを返します。
   * @return sjServiceCodeInfoTableModel
   */
  protected ACTableModelAdapter getSjServiceCodeInfoTableModel(){
    return sjServiceCodeInfoTableModel;
  }
  /**
   * sjServiceCodeInfoTableModelを設定します。
   * @param sjServiceCodeInfoTableModel sjServiceCodeInfoTableModel
   */
  protected void setSjServiceCodeInfoTableModel(ACTableModelAdapter sjServiceCodeInfoTableModel){
    this.sjServiceCodeInfoTableModel = sjServiceCodeInfoTableModel;
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
   * 「選択総合事業サービスコード削除処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doDelete() throws Exception;

  /**
   * 「検索条件のチェック」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean checkFind() throws Exception;

  /**
   * 「検索処理を行う。」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFindData() throws Exception;

  /**
   * 「システムサービス項目コードが使用されているかチェックする」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean checkSjServiceCode() throws Exception;

  /**
   * 「総合事業サービスコード登録画面に遷移（更新）」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void moveQO017() throws Exception;

}
