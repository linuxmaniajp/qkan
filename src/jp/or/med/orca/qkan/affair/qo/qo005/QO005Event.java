
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
 * 作成日: 2006/03/09  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他 (O)
 * プロセス 設定変更・メンテナンス (005)
 * プログラム 設定変更・メンテナンス (QO005)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo005;
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
import jp.or.med.orca.qkan.lib.*;
import jp.or.med.orca.qkan.text.*;

/**
 * 設定変更・メンテナンスイベント定義(QO005) 
 */
public abstract class QO005Event extends QO005State {
  /**
   * コンストラクタです。
   */
  public QO005Event(){
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
    getServerSelectRadios().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                serverSelectRadiosActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getDbFileSelectFileCompareButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                dbFileSelectFileCompareButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getBackup().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                backupActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getRestore().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                restoreActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPdfFileSelectFileCompareButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                pdfFileSelectFileCompareButtonActionPerformed(e);
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
   * 「設定ファイルの更新」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void updateActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「画面の状態設定」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void serverSelectRadiosActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「DBファイル参照」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void dbFileSelectFileCompareButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「FDBファイルバックアップ」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void backupActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「FDBファイルリストア」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void restoreActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「PDFファイル参照」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void pdfFileSelectFileCompareButtonActionPerformed(ActionEvent e) throws Exception;

  //変数定義

  public static final int SERVER_RADIO_LOCAL = 1;
  public static final int SERVER_RADIO_REMOTE = 2;
  public static final int SELECT_OK = 1;
  public static final int SELECT_CANCEL = 2;
  public static final int CHECKBOX_ON = 1;
  public static final int CHECKBOX_OFF = 0;
  public static final String[] FB_FILE_EXTENSIONS = {"old", "fdb"};
  public static final String[] PDF_FILE_EXTENSIONS = {"exe"};
  private boolean updateSuccessed;
  //getter/setter

  /**
   * updateSuccessedを返します。
   * @return updateSuccessed
   */
  protected boolean getUpdateSuccessed(){
    return updateSuccessed;
  }
  /**
   * updateSuccessedを設定します。
   * @param updateSuccessed updateSuccessed
   */
  protected void setUpdateSuccessed(boolean updateSuccessed){
    this.updateSuccessed = updateSuccessed;
  }

  //内部関数

  /**
   * 「状態の切替」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void setServerSelectIpTextState() throws Exception;

  /**
   * 「設定情報取込処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doLoad() throws Exception;

  /**
   * 「設定をファイルから読込」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return VRMap
   */
  public abstract VRMap loadSettingFile() throws Exception;

  /**
   * 「設定情報保存処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doSave() throws Exception;

  /**
   * 「設定をファイルに保存」に関する処理を行ないます。
   *
   * @param params VRMap
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean saveSettingFile(VRMap params) throws Exception;

  /**
   * 「画面初期値の設定」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void setInitValue() throws Exception;

  /**
   * 「ファイルのコピー」に関する処理を行ないます。
   *
   * @param orgFile String
   * @param newFile String
   * @throws Exception 処理例外
   *
   */
  public abstract void fileCpy(String orgFile, String newFile) throws Exception;

  /**
   * 「拡張子付きファイル名を取得」に関する処理を行ないます。
   *
   * @param fileName String
   * @param defaultExtensionIndex int
   * @param extensions String[]
   * @throws Exception 処理例外
   * @return String
   */
  public abstract String getFBFilePathWithExtension(String fileName, int defaultExtensionIndex, String[] extensions) throws Exception;

  /**
   * 「拡張子付きファイル名を取得」に関する処理を行ないます。
   *
   * @param fileName String
   * @param defaultExtensionIndex int
   * @param extensions String[]
   * @throws Exception 処理例外
   * @return String
   */
  public abstract String getPDFFilePathWithExtension(String fileName, int defaultExtensionIndex, String[] extensions) throws Exception;

  /**
   * 「DBの接続試験」に関する処理を行ないます。
   *
   * @param params VRMap
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean checkDBConnect(VRMap params) throws Exception;

	/**
	 * デフォルトのファイル名を取得します。
	 * 
	 * @param fileExtension
	 *            拡張子
	 * @return ファイル名
	 */
	public abstract String getDefaultFileName(String fileExtension) throws Exception;
}
