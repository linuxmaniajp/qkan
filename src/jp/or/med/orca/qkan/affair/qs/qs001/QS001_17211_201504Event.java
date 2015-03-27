
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
 * 作成日: 2011/12/14  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン認知症対応型通所介護 (QS001_17211_201504)
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
import jp.nichicom.vr.util.VRMap;

/**
 * サービスパターン認知症対応型通所介護イベント定義(QS001_17211_201504) 
 */
public abstract class QS001_17211_201504Event extends QS001_17211_201504State implements QS001Service {
  /**
   * コンストラクタです。
   */
  public QS001_17211_201504Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getBeginTime().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                beginTimeActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getTimeDivisionRadio().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                timeDivisionRadioSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getProviderDivisionRadio().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                providerDivisionRadioSelectionChanged(e);
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
   * 「開始時間選択」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void beginTimeActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「時刻区分選択」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void timeDivisionRadioSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「施設区分1,2の連動」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void providerDivisionRadioSelectionChanged(ListSelectionEvent e) throws Exception;

  //変数定義

  private boolean invalidFaclityState2Provider;
  //getter/setter

  /**
   * invalidFaclityState2Providerを返します。
   * @return invalidFaclityState2Provider
   */
  protected boolean getInvalidFaclityState2Provider(){
    return invalidFaclityState2Provider;
  }
  /**
   * invalidFaclityState2Providerを設定します。
   * @param invalidFaclityState2Provider invalidFaclityState2Provider
   */
  protected void setInvalidFaclityState2Provider(boolean invalidFaclityState2Provider){
    this.invalidFaclityState2Provider = invalidFaclityState2Provider;
  }

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
   * 「終了時間のチェック」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void checkEndTime() throws Exception;

  /**
   * 「時間区分の時間取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return int
   */
  public abstract int getNintiTuusho() throws Exception;

}
