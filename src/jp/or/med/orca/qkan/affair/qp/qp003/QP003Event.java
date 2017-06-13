
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
 * 開発者: 上司　和善
 * 作成日: 2016/12/08  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 確認・修正 (003)
 * プログラム 利用者向け請求詳細編集 (QP003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp003;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Date;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * 利用者向け請求詳細編集イベント定義(QP003) 
 */
public abstract class QP003Event extends QP003SQL {
  /**
   * コンストラクタです。
   */
  public QP003Event(){
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
    getOpen().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                openActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentJikohutanUse1().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentJikohutanUse1FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentJikohutanUse2().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentJikohutanUse2FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentJikohutanUse3().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentJikohutanUse3FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUse1().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUse1FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUse2().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUse2FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUse3().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUse3FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUse4().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUse4FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUse5().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUse5FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUse6().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUse6FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUnit1().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUnit1FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcCount1().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcCount1FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUnit2().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUnit2FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcCount2().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcCount2FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUnit3().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUnit3FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcCount3().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcCount3FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUnit4().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUnit4FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcCount4().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcCount4FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUnit5().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUnit5FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcCount5().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcCount5FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUnit6().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUnit6FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcCount6().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcCount6FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getTabs().addChangeListener(new ChangeListener(){
        private boolean lockFlag = false;
        public void stateChanged(ChangeEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                tabsStateChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKoujoDispCheck().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                koujoDispCheckActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentHokenIryoUse().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentHokenIryoUseFocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentHokenFukushiUse().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentHokenFukushiUseFocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentHokenIryoKoujoCheck().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentHokenIryoKoujoCheckActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentHokenFukushiKoujoCheck().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentHokenFukushiKoujoCheckActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentJikohutanKoujoCheck1().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentJikohutanKoujoCheck1ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentJikohutanKoujoCheck2().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentJikohutanKoujoCheck2ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentJikohutanKoujoCheck3().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentJikohutanKoujoCheck3ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcKoujoCheck1().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcKoujoCheck1ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcKoujoCheck2().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcKoujoCheck2ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcKoujoCheck3().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcKoujoCheck3ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcKoujoCheck4().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcKoujoCheck4ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcKoujoCheck5().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcKoujoCheck5ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcKoujoCheck6().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcKoujoCheck6ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getReflection().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                reflectionActionPerformed(e);
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
   * 「DB登録」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void insertActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「DB登録」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void updateActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「直近の訪問看護計画書情報の読込」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void openActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「合計金額の計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentJikohutanUse1FocusLost(FocusEvent e) throws Exception;

  /**
   * 「合計金額の計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentJikohutanUse2FocusLost(FocusEvent e) throws Exception;

  /**
   * 「合計金額の計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentJikohutanUse3FocusLost(FocusEvent e) throws Exception;

  /**
   * 「合計金額の計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentEtcUse1FocusLost(FocusEvent e) throws Exception;

  /**
   * 「合計金額の計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentEtcUse2FocusLost(FocusEvent e) throws Exception;

  /**
   * 「合計金額の計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentEtcUse3FocusLost(FocusEvent e) throws Exception;

  /**
   * 「合計金額の計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentEtcUse4FocusLost(FocusEvent e) throws Exception;

  /**
   * 「合計金額の計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentEtcUse5FocusLost(FocusEvent e) throws Exception;

  /**
   * 「合計金額の計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentEtcUse6FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額算出」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentEtcUnit1FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額算出」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentEtcCount1FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額算出」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentEtcUnit2FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額算出」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentEtcCount2FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額算出」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentEtcUnit3FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額算出」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentEtcCount3FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額算出」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentEtcUnit4FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額算出」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentEtcCount4FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額算出」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentEtcUnit5FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額算出」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentEtcCount5FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額算出」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentEtcUnit6FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額算出」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentEtcCount6FocusLost(FocusEvent e) throws Exception;

  /**
   * 「サービス提供日タブクリック」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void tabsStateChanged(ChangeEvent e) throws Exception;

  /**
   * 「医療費控除補助の制御」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void koujoDispCheckActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「医療費控除金額算出」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentHokenIryoUseFocusLost(FocusEvent e) throws Exception;

  /**
   * 「医療費控除金額算出」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentHokenFukushiUseFocusLost(FocusEvent e) throws Exception;

  /**
   * 「医療費控除金額算出」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentHokenIryoKoujoCheckActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「医療費控除金額算出」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentHokenFukushiKoujoCheckActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「医療費控除金額算出」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentJikohutanKoujoCheck1ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「医療費控除金額算出」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentJikohutanKoujoCheck2ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「医療費控除金額算出」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentJikohutanKoujoCheck3ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「医療費控除金額算出」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentEtcKoujoCheck1ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「医療費控除金額算出」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentEtcKoujoCheck2ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「医療費控除金額算出」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentEtcKoujoCheck3ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「医療費控除金額算出」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentEtcKoujoCheck4ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「医療費控除金額算出」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentEtcKoujoCheck5ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「医療費控除金額算出」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentEtcKoujoCheck6ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「医療費控除金額反映」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void reflectionActionPerformed(ActionEvent e) throws Exception;

  //変数定義

  private ACPassiveKey PASSIVE_CHECK_KEY;
  public static final int STYLE_TYPE_CLAIM_FOR_PATIENT = 30101;
  public static final int CATEGORY_NO_CLAIM_FOR_PATIENT = 16;
  public static final Date DATE_20070401 = ACCastUtilities.toDate("2007/04/01", null);
  private int patientId;
  private int listIndex;
  private int sum;
  private int claimId;
  private int dataFlg;
  private int processMode;
  private String providerId;
  private String insurerId;
  private String insuredId;
  private String serviceKind;
  private Date targetDate;
  private Date claimDate;
  private VRList claimList = new VRArrayList();
  private VRList comboSet1 = new VRArrayList();
  private VRList comboSet2 = new VRArrayList();
  private VRMap modelMap = new VRHashMap();
  private VRMap sourceMap = new VRHashMap();
  private VRMap snapShotMap = new VRHashMap();
  //getter/setter

  /**
   * PASSIVE_CHECK_KEYを返します。
   * @return PASSIVE_CHECK_KEY
   */
  protected ACPassiveKey getPASSIVE_CHECK_KEY(){
    return PASSIVE_CHECK_KEY;
  }
  /**
   * PASSIVE_CHECK_KEYを設定します。
   * @param PASSIVE_CHECK_KEY PASSIVE_CHECK_KEY
   */
  protected void setPASSIVE_CHECK_KEY(ACPassiveKey PASSIVE_CHECK_KEY){
    this.PASSIVE_CHECK_KEY = PASSIVE_CHECK_KEY;
  }

  /**
   * patientIdを返します。
   * @return patientId
   */
  protected int getPatientId(){
    return patientId;
  }
  /**
   * patientIdを設定します。
   * @param patientId patientId
   */
  protected void setPatientId(int patientId){
    this.patientId = patientId;
  }

  /**
   * listIndexを返します。
   * @return listIndex
   */
  protected int getListIndex(){
    return listIndex;
  }
  /**
   * listIndexを設定します。
   * @param listIndex listIndex
   */
  protected void setListIndex(int listIndex){
    this.listIndex = listIndex;
  }

  /**
   * sumを返します。
   * @return sum
   */
  protected int getSum(){
    return sum;
  }
  /**
   * sumを設定します。
   * @param sum sum
   */
  protected void setSum(int sum){
    this.sum = sum;
  }

  /**
   * claimIdを返します。
   * @return claimId
   */
  protected int getClaimId(){
    return claimId;
  }
  /**
   * claimIdを設定します。
   * @param claimId claimId
   */
  protected void setClaimId(int claimId){
    this.claimId = claimId;
  }

  /**
   * dataFlgを返します。
   * @return dataFlg
   */
  protected int getDataFlg(){
    return dataFlg;
  }
  /**
   * dataFlgを設定します。
   * @param dataFlg dataFlg
   */
  protected void setDataFlg(int dataFlg){
    this.dataFlg = dataFlg;
  }

  /**
   * processModeを返します。
   * @return processMode
   */
  protected int getProcessMode(){
    return processMode;
  }
  /**
   * processModeを設定します。
   * @param processMode processMode
   */
  protected void setProcessMode(int processMode){
    this.processMode = processMode;
  }

  /**
   * providerIdを返します。
   * @return providerId
   */
  protected String getProviderId(){
    return providerId;
  }
  /**
   * providerIdを設定します。
   * @param providerId providerId
   */
  protected void setProviderId(String providerId){
    this.providerId = providerId;
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
   * insuredIdを返します。
   * @return insuredId
   */
  protected String getInsuredId(){
    return insuredId;
  }
  /**
   * insuredIdを設定します。
   * @param insuredId insuredId
   */
  protected void setInsuredId(String insuredId){
    this.insuredId = insuredId;
  }

  /**
   * serviceKindを返します。
   * @return serviceKind
   */
  protected String getServiceKind(){
    return serviceKind;
  }
  /**
   * serviceKindを設定します。
   * @param serviceKind serviceKind
   */
  protected void setServiceKind(String serviceKind){
    this.serviceKind = serviceKind;
  }

  /**
   * targetDateを返します。
   * @return targetDate
   */
  protected Date getTargetDate(){
    return targetDate;
  }
  /**
   * targetDateを設定します。
   * @param targetDate targetDate
   */
  protected void setTargetDate(Date targetDate){
    this.targetDate = targetDate;
  }

  /**
   * claimDateを返します。
   * @return claimDate
   */
  protected Date getClaimDate(){
    return claimDate;
  }
  /**
   * claimDateを設定します。
   * @param claimDate claimDate
   */
  protected void setClaimDate(Date claimDate){
    this.claimDate = claimDate;
  }

  /**
   * claimListを返します。
   * @return claimList
   */
  protected VRList getClaimList(){
    return claimList;
  }
  /**
   * claimListを設定します。
   * @param claimList claimList
   */
  protected void setClaimList(VRList claimList){
    this.claimList = claimList;
  }

  /**
   * comboSet1を返します。
   * @return comboSet1
   */
  protected VRList getComboSet1(){
    return comboSet1;
  }
  /**
   * comboSet1を設定します。
   * @param comboSet1 comboSet1
   */
  protected void setComboSet1(VRList comboSet1){
    this.comboSet1 = comboSet1;
  }

  /**
   * comboSet2を返します。
   * @return comboSet2
   */
  protected VRList getComboSet2(){
    return comboSet2;
  }
  /**
   * comboSet2を設定します。
   * @param comboSet2 comboSet2
   */
  protected void setComboSet2(VRList comboSet2){
    this.comboSet2 = comboSet2;
  }

  /**
   * modelMapを返します。
   * @return modelMap
   */
  protected VRMap getModelMap(){
    return modelMap;
  }
  /**
   * modelMapを設定します。
   * @param modelMap modelMap
   */
  protected void setModelMap(VRMap modelMap){
    this.modelMap = modelMap;
  }

  /**
   * sourceMapを返します。
   * @return sourceMap
   */
  protected VRMap getSourceMap(){
    return sourceMap;
  }
  /**
   * sourceMapを設定します。
   * @param sourceMap sourceMap
   */
  protected void setSourceMap(VRMap sourceMap){
    this.sourceMap = sourceMap;
  }

  /**
   * snapShotMapを返します。
   * @return snapShotMap
   */
  protected VRMap getSnapShotMap(){
    return snapShotMap;
  }
  /**
   * snapShotMapを設定します。
   * @param snapShotMap snapShotMap
   */
  protected void setSnapShotMap(VRMap snapShotMap){
    this.snapShotMap = snapShotMap;
  }

  //内部関数

  /**
   * 「データ取得、画面展開」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * 「利用者向け請求詳細情報を取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFindClaimForPatient() throws Exception;

  /**
   * 「合計金額の計算処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void calcSum() throws Exception;

  /**
   * 「保存処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doSave() throws Exception;

  /**
   * 「画面データチェック・編集」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doCheckInput() throws Exception;

  /**
   * 「入力データの値をチェックする。」に関する処理を行ないます。
   *
   * @param himokuCombo ACComboBox
   * @param jikohutanText ACTextField
   * @param unitText ACTextField
   * @param countText ACTextField
   * @throws Exception 処理例外
   *
   */
  public abstract void checkValue(ACComboBox himokuCombo, ACTextField jikohutanText, ACTextField unitText, ACTextField countText) throws Exception;

  /**
   * 「コンボ候補を設定する。」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void comboInitialize() throws Exception;

  /**
   * 「項目単位の計算処理」に関する処理を行ないます。
   *
   * @param unit ACTextField
   * @param count ACTextField
   * @param price ACTextField
   * @throws Exception 処理例外
   *
   */
  public abstract void doCalcUnitPrice(ACTextField unit, ACTextField count, ACTextField price) throws Exception;

  /**
   * 「カレンダー情報を取得します。」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return VRMap
   */
  public abstract VRMap getCalenderBitData() throws Exception;

  /**
   * 「カレンダースナップショット」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void calenderSnapShot() throws Exception;

  /**
   * 「カレンダー変更チェック」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean calenderIsModified() throws Exception;

  /**
   * 「医療費控除計算」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void calcKoujoPrice() throws Exception;

}
