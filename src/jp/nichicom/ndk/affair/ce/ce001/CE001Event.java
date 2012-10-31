
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
 * 開発者: 田中　統蔵
 * 作成日: 2006/04/26  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム CodeWall (C)
 * サブシステム CodeWall (E)
 * プロセス 暗号化 (001)
 * プログラム 暗号化 (CE001)
 *
 *****************************************************************
 */
package jp.nichicom.ndk.affair.ce.ce001;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRList;

/**
 * 暗号化イベント定義(CE001) 
 */
@SuppressWarnings("serial")
public abstract class CE001Event extends CE001Design {
  /**
   * コンストラクタです。
   */
  public CE001Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getEncode().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                encodeActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getDecode().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                decodeActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getTargets().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                targetsSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getTargetPathBrose().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                targetPathBroseActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getTargetSettingInsert().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                targetSettingInsertActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getTargetSettingUpdate().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                targetSettingUpdateActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getTargetSettingDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                targetSettingDeleteActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getStubOut().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                stubOutActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getStubOutPathBrose().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                stubOutPathBroseActionPerformed(e);
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
   * 「暗号化」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void encodeActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「復号化」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void decodeActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「既存の対象を選択」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void targetsSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「対象先を参照」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void targetPathBroseActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「対象を追加」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void targetSettingInsertActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「対象を更新」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void targetSettingUpdateActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「対象を削除」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void targetSettingDeleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「スタブ生成」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void stubOutActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「対象先を参照」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void stubOutPathBroseActionPerformed(ActionEvent e) throws Exception;

  //変数定義

  private VRList targetsModel = new VRArrayList();
  public static final int TARGET_TYPE_DIRECTORY = 1;
  public static final int TARGET_TYPE_FILE = 2;
  public static final int TARGET_FILTER_ADD = 1;
  public static final int TARGET_FILTER_REMOVE = 2;
  //getter/setter

  /**
   * targetsModelを返します。
   * @return targetsModel
   */
  protected VRList getTargetsModel(){
    return targetsModel;
  }
  /**
   * targetsModelを設定します。
   * @param targetsModel targetsModel
   */
  protected void setTargetsModel(VRList targetsModel){
    this.targetsModel = targetsModel;
  }

  //内部関数

  /**
   * 「対象が有効か検証」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean isValidTarget() throws Exception;

  /**
   * 「埋め込むヘッダ情報取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return byte[]
   */
  public abstract byte[] getProtectHeader() throws Exception;

  /**
   * 「対象のファイル集合取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return ArrayList
   */
  public abstract ArrayList<String> getTargetFilePathes() throws Exception;

  /**
   * 「クラスファイルを再帰的に追加」に関する処理を行ないます。
   *
   * @param file File
   * @param dest ArrayList
   * @param extention String
   * @throws Exception 処理例外
   *
   */
  public abstract void stockClassFile(File file, ArrayList<String> dest, String extention) throws Exception;

  /**
   * 「バイト配列のint化」に関する処理を行ないます。
   *
   * @param src byte[]
   * @throws Exception 処理例外
   * @return int
   */
  public abstract int parseInt(byte[] src) throws Exception;

}
