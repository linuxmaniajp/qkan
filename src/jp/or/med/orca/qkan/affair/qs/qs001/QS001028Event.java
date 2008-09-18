
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
 * 作成日: 2006/02/26  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム 特定診療費画面 (QS001028)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
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
 * 特定診療費画面イベント定義(QS001028) 
 */
public abstract class QS001028Event extends QS001028State {
  /**
   * コンストラクタです。
   */
  public QS001028Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getApply().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                applyActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getClose().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                closeActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getScienceTherapy1().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                scienceTherapy1ActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getScienceTherapy2().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                scienceTherapy2ActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getScienceTherapy3().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                scienceTherapy3ActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getScienceTherapy4().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                scienceTherapy4ActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getScience1().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                science1ActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getScience2().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                science2ActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getScience3().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                science3ActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getScience4().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                science4ActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getNormalLife().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                normalLifeActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getWorkTherapy1().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                workTherapy1ActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getWorkTherapy2().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                workTherapy2ActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getWork1().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                work1ActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getWork2().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                work2ActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getNormalLife2().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                normalLife2ActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getLanguageTherapy1().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                languageTherapy1ActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getLanguageTherapy2().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                languageTherapy2ActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getLanguage1().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                language1ActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getLanguage2().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                language2ActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });

  }
  //コンポーネントイベント

  /**
   * 「設定」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void applyActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「キャンセル」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void closeActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「理学療法（Ｉ）の有効状態変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void scienceTherapy1ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「理学療法（ＩＩ）の有効状態変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void scienceTherapy2ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「理学療法（ＩＩＩ）の有効状態変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void scienceTherapy3ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「理学療法（ＩＶ）の有効状態変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void scienceTherapy4ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「理学（Ｉ）の有効状態変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void science1ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「理学（ＩＩ）の有効状態変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void science2ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「理学（ＩＩＩ）の有効状態変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void science3ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「理学（ＩＶ）の有効状態変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void science4ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「日常生活活動訓練加算の有効状態変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void normalLifeActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「作業療法Iの有効状態変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void workTherapy1ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「作業療法IIの有効状態変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void workTherapy2ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「作業(I)の有効状態変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void work1ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「作業(II)の有効状態変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void work2ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「日常生活活動導加算の有効状態変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void normalLife2ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「言語聴覚療法Ｉの有効状態変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void languageTherapy1ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「言語聴覚療法ＩIの有効状態変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void languageTherapy2ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「言語聴覚(I)の有効状態変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void language1ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「言語聴覚(II)の有効状態変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void language2ActionPerformed(ActionEvent e) throws Exception;

  //変数定義

  private VRMap values = new VRHashMap();
  private boolean applied = false;
  //getter/setter

  /**
   * valuesを返します。
   * @return values
   */
  protected VRMap getValues(){
    return values;
  }
  /**
   * valuesを設定します。
   * @param values values
   */
  protected void setValues(VRMap values){
    this.values = values;
  }

  /**
   * appliedを返します。
   * @return applied
   */
  protected boolean getApplied(){
    return applied;
  }
  /**
   * appliedを設定します。
   * @param applied applied
   */
  protected void setApplied(boolean applied){
    this.applied = applied;
  }

  //内部関数

  /**
   * 「初期化」に関する処理を行ないます。
   *
   * @param systemServiceKindDetail int
   * @param param VRMap
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean showModal(int systemServiceKindDetail, VRMap param) throws Exception;

}
