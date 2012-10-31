
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
 * 作成日: 2006/09/13  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム nichicom (N)
 * サブシステム ユーティリティ (U)
 * プロセス PDF比較 (001)
 * プログラム PDF比較 (NU001)
 *
 *****************************************************************
 */
package jp.nichicom.ndk.affair.nu.nu001;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jp.nichicom.ac.ACCommon;

/**
 * PDF比較イベント定義(NU001) 
 */
@SuppressWarnings("serial")
public abstract class NU001Event extends NU001Design {
  /**
   * コンストラクタです。
   */
  public NU001Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getCompare().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                compareActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getExit().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                exitActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPdf1Browse().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                pdf1BrowseActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPdf2Browse().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                pdf2BrowseActionPerformed(e);
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
   * 「比較」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void compareActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「終了」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void exitActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「PDF1参照」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void pdf1BrowseActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「PDF2参照」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void pdf2BrowseActionPerformed(ActionEvent e) throws Exception;

  //変数定義

  //getter/setter

}
