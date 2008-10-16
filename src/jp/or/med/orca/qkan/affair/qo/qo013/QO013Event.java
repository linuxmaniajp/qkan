
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
 * 作成日: 2008/09/18  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その多機能 (O)
 * プロセス 日医標準レセプトソフト連携 (013)
 * プログラム 日医標準レセプトソフト連携 (QO013)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo013;
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
import jp.nichicom.ac.util.splash.ACSplashable;
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
 * 日医標準レセプトソフト連携イベント定義(QO013) 
 */
public abstract class QO013Event extends QO013SQL {
  /**
   * コンストラクタです。
   */
  public QO013Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getConnect().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                connectActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getImportPatient().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                importPatientActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPreviewPage().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                previewPageActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getNextPage().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                nextPageActionPerformed(e);
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
   * 「通信処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void connectActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「取り込み処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void importPatientActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「前へボタン押下」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void previewPageActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「次へボタン押下」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void nextPageActionPerformed(ActionEvent e) throws Exception;

  //変数定義

  private String port;
  private String ip;
  private String user;
  private String pass;
  private String dbsVer;
  private String toHiraganaConvert;
  private String receiptVersion;
  public static final int PAGE_COUNT = 100;
  public static final int CODE_RECEIPT_VERSION = 271;
  public static final int DEFAULT_RECEIPT_VERSION_INDEX = 1;
  private int nowPage;
  private Integer hospNum;
  private ACTableModelAdapter receiptTableModel;
  private VRList receiptDataList = new VRArrayList();
  //getter/setter

  /**
   * portを返します。
   * @return port
   */
  protected String getPort(){
    return port;
  }
  /**
   * portを設定します。
   * @param port port
   */
  protected void setPort(String port){
    this.port = port;
  }

  /**
   * ipを返します。
   * @return ip
   */
  protected String getIp(){
    return ip;
  }
  /**
   * ipを設定します。
   * @param ip ip
   */
  protected void setIp(String ip){
    this.ip = ip;
  }

  /**
   * userを返します。
   * @return user
   */
  protected String getUser(){
    return user;
  }
  /**
   * userを設定します。
   * @param user user
   */
  protected void setUser(String user){
    this.user = user;
  }

  /**
   * passを返します。
   * @return pass
   */
  protected String getPass(){
    return pass;
  }
  /**
   * passを設定します。
   * @param pass pass
   */
  protected void setPass(String pass){
    this.pass = pass;
  }

  /**
   * dbsVerを返します。
   * @return dbsVer
   */
  protected String getDbsVer(){
    return dbsVer;
  }
  /**
   * dbsVerを設定します。
   * @param dbsVer dbsVer
   */
  protected void setDbsVer(String dbsVer){
    this.dbsVer = dbsVer;
  }

  /**
   * toHiraganaConvertを返します。
   * @return toHiraganaConvert
   */
  protected String getToHiraganaConvert(){
    return toHiraganaConvert;
  }
  /**
   * toHiraganaConvertを設定します。
   * @param toHiraganaConvert toHiraganaConvert
   */
  protected void setToHiraganaConvert(String toHiraganaConvert){
    this.toHiraganaConvert = toHiraganaConvert;
  }

  /**
   * receiptVersionを返します。
   * @return receiptVersion
   */
  protected String getReceiptVersion(){
    return receiptVersion;
  }
  /**
   * receiptVersionを設定します。
   * @param receiptVersion receiptVersion
   */
  protected void setReceiptVersion(String receiptVersion){
    this.receiptVersion = receiptVersion;
  }

  /**
   * nowPageを返します。
   * @return nowPage
   */
  protected int getNowPage(){
    return nowPage;
  }
  /**
   * nowPageを設定します。
   * @param nowPage nowPage
   */
  protected void setNowPage(int nowPage){
    this.nowPage = nowPage;
  }

  /**
   * hospNumを返します。
   * @return hospNum
   */
  protected Integer getHospNum(){
    return hospNum;
  }
  /**
   * hospNumを設定します。
   * @param hospNum hospNum
   */
  protected void setHospNum(Integer hospNum){
    this.hospNum = hospNum;
  }

  /**
   * receiptTableModelを返します。
   * @return receiptTableModel
   */
  protected ACTableModelAdapter getReceiptTableModel(){
    return receiptTableModel;
  }
  /**
   * receiptTableModelを設定します。
   * @param receiptTableModel receiptTableModel
   */
  protected void setReceiptTableModel(ACTableModelAdapter receiptTableModel){
    this.receiptTableModel = receiptTableModel;
  }

  /**
   * receiptDataListを返します。
   * @return receiptDataList
   */
  protected VRList getReceiptDataList(){
    return receiptDataList;
  }
  /**
   * receiptDataListを設定します。
   * @param receiptDataList receiptDataList
   */
  protected void setReceiptDataList(VRList receiptDataList){
    this.receiptDataList = receiptDataList;
  }

  //内部関数

  /**
   * 「初期設定」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void initialize() throws Exception;

  /**
   * 「通信設定読込み」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void readProperty() throws Exception;

  /**
   * 「通信設定書き込み」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void saveProperty() throws Exception;

  /**
   * 「重複患者名チェック」に関する処理を行ないます。
   *
   * @param list VRList
   * @throws Exception 処理例外
   * @return VRList
   */
  public abstract VRList checkSameName(VRList list) throws Exception;

  /**
   * 「日レセデータ変換処理」に関する処理を行ないます。
   *
   * @param list VRList
   * @throws Exception 処理例外
   * @return VRList
   */
  public abstract VRList convertQkanData(VRList list) throws Exception;

  /**
   * 「取り込み患者データ取り込み処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doInsert() throws Exception;

  /**
   * 「取り込み患者取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return VRList
   */
  public abstract VRList getInsertCheckedRows() throws Exception;

  /**
   * 「日レセデータ取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * 「スプラッシュを閉じる」に関する処理を行ないます。
   *
   * @param splash ACSplashable
   * @throws Exception 処理例外
   * @return ACSplashable
   */
  public abstract ACSplashable closeSplash(ACSplashable splash) throws Exception;

  /**
   * 「一時領域から患者を取得」に関する処理を行ないます。
   *
   * @param begin int
   * @param end int
   * @throws Exception 処理例外
   * @return VRList
   */
  public abstract VRList readFromAccessSpace(int begin, int end) throws Exception;

  /**
   * 「設定復元」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void setRestoration() throws Exception;

  /**
   * 「電話番号変換」に関する処理を行ないます。
   *
   * @param src String
   * @throws Exception 処理例外
   * @return String
   */
  public abstract String toNotTelCharReplace(String src) throws Exception;

  /**
   * 「ページ操作ボタン状態制御」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void pageButtonState() throws Exception;

  /**
   * 「1頁分のデータ取得」に関する処理を行ないます。
   *
   * @param begin int
   * @param end int
   * @throws Exception 処理例外
   * @return VRList
   */
  public abstract VRList getPageData(int begin, int end) throws Exception;

}
