
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
 * 作成日: 2011/11/16  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターンその他内容詳細 (QS001_90101_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.vr.bind.event.VRBindEvent;
import jp.nichicom.vr.bind.event.VRBindEventAdapter;
import jp.nichicom.vr.util.VRMap;

/**
 * サービスパターンその他内容詳細イベント定義(QS001_90101_201204) 
 */
@SuppressWarnings("serial")
public abstract class QS001_90101_201504Event extends QS001_90101_201504State implements QS001Service {
  /**
   * コンストラクタです。
   */
  public QS001_90101_201504Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getDailyLifeActivitInsertButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                dailyLifeActivitInsertButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getDailyLifeActivitFindButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                dailyLifeActivitFindButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getDailyLifeActivitDeleteButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                dailyLifeActivitDeleteButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getDailyLifeActivitList().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                dailyLifeActivitListSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getDailyLifeActivitList().addBindEventListener(new VRBindEventAdapter(){
        private boolean lockFlag = false;
        public void bindSource(VRBindEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                dailyLifeActivitListBindSource(e);
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
   * 「追加ボタンのクリック」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void dailyLifeActivitInsertButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「編集ボタンのクリック」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void dailyLifeActivitFindButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「削除ボタンのクリック」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void dailyLifeActivitDeleteButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「リストの選択」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void dailyLifeActivitListSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「リストへのバインド」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void dailyLifeActivitListBindSource(VRBindEvent e) throws Exception;

  //変数定義

  //getter/setter

  //内部関数

  /**
   * 「初期化」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void initialize() throws Exception;

  /**
   * 「事業所コンボ変更時関数」に関する処理を行ないます。
   *
   * @param provider VRMap
   * @throws Exception 処理例外
   *
   */
  public abstract void providerSelected(VRMap provider) throws Exception;

  /**
   * 「入力内容の不備を検査」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return VRMap
   */
  public abstract VRMap getValidData() throws Exception;

  /**
   * 「事業所情報の必要性を取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean isUseProvider() throws Exception;

  /**
   * 「開始時刻入力用のコンボ取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return ACComboBox
   */
  public abstract ACComboBox getBeginTimeCombo() throws Exception;

  /**
   * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return ACComboBox
   */
  public abstract ACComboBox getEndTimeCombo() throws Exception;

  /**
   * 「追加ボタンの有効状態チェック」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void checkAddCondition() throws Exception;

}
