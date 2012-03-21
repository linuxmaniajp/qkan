
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
 * 作成日: 2010/11/05  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム 特別療養費画面 (QS001200)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;

/**
 * 特別療養費画面イベント定義(QS001200) 
 */
@SuppressWarnings("serial")
public abstract class QS001S02_201204Event extends QS001S02_201204State {
  /**
   * コンストラクタです。
   */
  public QS001S02_201204Event(){
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
            }catch(Throwable ex){
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
            }catch(Throwable ex){
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
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getRehabilitationSystem().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                rehabilitationSystemActionPerformed(e);
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
   * 「設定」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void applyActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「言語聴覚療法Ｉの有効状態変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void languageTherapy1ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「言語聴覚(I)の有効状態変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void language1ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「リハビリ体制強化加算の有効状態変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void rehabilitationSystemActionPerformed(ActionEvent e) throws Exception;

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
