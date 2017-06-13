
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
 * 作成日: 2016/09/09  日本コンピューター株式会社  新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 総合事業サービスコード取込 (015)
 * プログラム 総合事業サービスコード取込 (QO015)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo015;
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
 * 総合事業サービスコード取込イベント定義(QO015) 
 */
public abstract class QO015Event extends QO015SQL {
  /**
   * コンストラクタです。
   */
  public QO015Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getCsvFileSelectFileCompareButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                csvFileSelectFileCompareButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getImportButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                importButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getEditButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                editButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getHistoryInfoTable().addMouseListener(new MouseAdapter(){
        private boolean lockFlag = false;
        public void mouseClicked(MouseEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                if (e.getClickCount() == 2) {
                    historyInfoTableMouseClicked(e);
                }
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
   * 「CSVファイル参照」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void csvFileSelectFileCompareButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「取込」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void importButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「編集」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void editButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「画面遷移処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void historyInfoTableMouseClicked(MouseEvent e) throws Exception;

  //変数定義

  public static final String[] CSV_FILE_EXTENSIONS = {"csv"};
  public static final String MESSAGE_FILE_OPEN_DIALOG_TITLE = "CSVファイルを指定して下さい";
  public static final String ERROR_CSV_FILE_CAN_NOT_READ = "CSVファイルの読み込みに失敗しました";
  public static final String ERROR_FILE_NOT_SELECTED = "CSVファイルを指定して下さい";
  public static final String ERROR_SELECTED_FILE_NOT_FOUND = "選択されたファイルは存在しませんでした";
  public static final String ERROR_DATA_NOT_FOUND = "データが存在しません。";
  public static final String ERROR_DATA_NOT_FOUND_INSURERID = "保険者番号が取得できていません。";
  public static final String MESSAGE_SPLASH_TEXT1 = "CSVファイル情報レコード解析中";
  public static final String MESSAGE_SPLASH_TEXT2 = "CSVファイル保存中";
  public static final int CSV_REC_CNT = 19;
  public static final int COMMON_RECORD_FORMAT_INSURERID = 0;
  public static final int COMMON_RECORD_FORMAT_SERVICE_CODE_KIND = 1;
  private ACPassiveKey M_SJ_SERVICE_CODE_INFO_PASSIVE_CHECK_KEY;
  private String inputCSVFilePath;
  private VRCSVFile inputCSVFile;
  private VRList outputTableList = new VRArrayList();
  private VRList historyInfoList = new VRArrayList();
  private ACTableModelAdapter historyInfoTableModel;
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
   * inputCSVFilePathを返します。
   * @return inputCSVFilePath
   */
  protected String getInputCSVFilePath(){
    return inputCSVFilePath;
  }
  /**
   * inputCSVFilePathを設定します。
   * @param inputCSVFilePath inputCSVFilePath
   */
  protected void setInputCSVFilePath(String inputCSVFilePath){
    this.inputCSVFilePath = inputCSVFilePath;
  }

  /**
   * inputCSVFileを返します。
   * @return inputCSVFile
   */
  protected VRCSVFile getInputCSVFile(){
    return inputCSVFile;
  }
  /**
   * inputCSVFileを設定します。
   * @param inputCSVFile inputCSVFile
   */
  protected void setInputCSVFile(VRCSVFile inputCSVFile){
    this.inputCSVFile = inputCSVFile;
  }

  /**
   * outputTableListを返します。
   * @return outputTableList
   */
  protected VRList getOutputTableList(){
    return outputTableList;
  }
  /**
   * outputTableListを設定します。
   * @param outputTableList outputTableList
   */
  protected void setOutputTableList(VRList outputTableList){
    this.outputTableList = outputTableList;
  }

  /**
   * historyInfoListを返します。
   * @return historyInfoList
   */
  protected VRList getHistoryInfoList(){
    return historyInfoList;
  }
  /**
   * historyInfoListを設定します。
   * @param historyInfoList historyInfoList
   */
  protected void setHistoryInfoList(VRList historyInfoList){
    this.historyInfoList = historyInfoList;
  }

  /**
   * historyInfoTableModelを返します。
   * @return historyInfoTableModel
   */
  protected ACTableModelAdapter getHistoryInfoTableModel(){
    return historyInfoTableModel;
  }
  /**
   * historyInfoTableModelを設定します。
   * @param historyInfoTableModel historyInfoTableModel
   */
  protected void setHistoryInfoTableModel(ACTableModelAdapter historyInfoTableModel){
    this.historyInfoTableModel = historyInfoTableModel;
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
   * 「総合事業サービスコード取込履歴情報取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFindHistoryInfo() throws Exception;

  /**
   * 「CSVデータ取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean csvReader() throws Exception;

  /**
   * 「レコード解析」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean setImportInfo() throws Exception;

  /**
   * 「取込可能なファイルかチェックする」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean checkControlRecord() throws Exception;

  /**
   * 「コントロールレコード解析」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean controlRecordParser() throws Exception;

  /**
   * 「保存処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doSave() throws Exception;

  /**
   * 「CSVファイル拡張子補完」に関する処理を行ないます。
   *
   * @param fileName String
   * @param defaultExtensionIndex int
   * @param extensions String[]
   * @throws Exception 処理例外
   * @return String
   */
  public abstract String getCSVFilePathWithExtension(String fileName, int defaultExtensionIndex, String[] extensions) throws Exception;

  /**
   * 「文字列（年月）を日付型に変換する」に関する処理を行ないます。
   *
   * @param filed String
   * @param mode String
   * @throws Exception 処理例外
   * @return Date
   */
  public abstract Date convYmToDate(String filed, String mode) throws Exception;

  /**
   * 「文字列（年月日）を日付型に変換する」に関する処理を行ないます。
   *
   * @param filed String
   * @throws Exception 処理例外
   * @return Date
   */
  public abstract Date convYmdToDate(String filed) throws Exception;

  /**
   * 「機種依存文字を置換する」に関する処理を行ないます。
   *
   * @param str String
   * @throws Exception 処理例外
   * @return String
   */
  public abstract String convCharacters(String str) throws Exception;

}
