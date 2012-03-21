
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
 * 作成日: 2006/03/11  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム メニュー (M)
 * プロセス ログイン画面 (001)
 * プログラム ログイン画面 (QM001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qm.qm001;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jp.nichicom.ac.ACCommon;

/**
 * ログイン画面イベント定義(QM001) 
 */
public abstract class QM001Event extends QM001SQL {
  /**
   * コンストラクタです。
   */
  public QM001Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getShowVersion().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                showVersionActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getStart().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                startActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getEnd().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                endActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getGoSetting1().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                goSetting1ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getGoSetting2().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                goSetting2ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getGoProvider().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                goProviderActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getGoInsurer().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                goInsurerActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getGoPatient().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                goPatientActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getGoSetting3().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                goSetting3ActionPerformed(e);
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
   * 「バージョン情報表示」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void showVersionActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「ログイン処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void startActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「終了処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void endActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「設定変更画面遷移」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void goSetting1ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「設定変更画面遷移」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void goSetting2ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「事業所登録画面遷移」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void goProviderActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「保険者登録画面遷移」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void goInsurerActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「利用者登録画面遷移」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void goPatientActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「設定変更画面遷移」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void goSetting3ActionPerformed(ActionEvent e) throws Exception;

  //変数定義

  //getter/setter

}
