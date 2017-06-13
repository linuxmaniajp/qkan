
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
 * 作成日: 2016/09/16  日本コンピューター株式会社  新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 総合事業サービスコード管理 (017)
 * プログラム 総合事業サービスコード登録 (QO017)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo017;
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
 * 総合事業サービスコード登録イベント定義(QO017) 
 */
public abstract class QO017Event extends QO017SQL {
  /**
   * コンストラクタです。
   */
  public QO017Event(){
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
    getInsurerIdText().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                insurerIdTextFocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInsurerIdCombo().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                insurerIdComboActionPerformed(e);
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

  /**
   * 「保険者名表示」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void insurerIdTextFocusLost(FocusEvent e) throws Exception;

  /**
   * 「保険者番号表示」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void insurerIdComboActionPerformed(ActionEvent e) throws Exception;

  //変数定義

  private ACPassiveKey M_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY;
  private String PROCESS_MODE;
  private String systemServiceCodeItem;
  private Date tekiyoStDate;
  private String insurerId;
  private String affairMap;
  private VRMap sjServiceCodeInfoMap = new VRHashMap();
  private VRList sjServiceCodeInfoList = new VRArrayList();
  public static final Date MAX_DATE = ACCastUtilities.toDate("9999/12/31", null);
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
   * insurerIdを返します。
   * @return insurerId
   */
  protected String getInsurerId(){
    return insurerId;
  }
  /**
   * insurerIdを設定します。
   * @param insurerId insurerId
   */
  protected void setInsurerId(String insurerId){
    this.insurerId = insurerId;
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
   * sjServiceCodeInfoMapを返します。
   * @return sjServiceCodeInfoMap
   */
  protected VRMap getSjServiceCodeInfoMap(){
    return sjServiceCodeInfoMap;
  }
  /**
   * sjServiceCodeInfoMapを設定します。
   * @param sjServiceCodeInfoMap sjServiceCodeInfoMap
   */
  protected void setSjServiceCodeInfoMap(VRMap sjServiceCodeInfoMap){
    this.sjServiceCodeInfoMap = sjServiceCodeInfoMap;
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

  //内部関数

  /**
   * 「レコードを取得し画面に設定する。」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * 「保存処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doSave() throws Exception;

  /**
   * 「総合事業サービスコード情報入力チェック」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doValidSjServiceCodeInfoCheck() throws Exception;

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

}
