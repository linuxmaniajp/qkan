
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
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン居宅介護支援 (QS001_14311_201504)
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
 * サービスパターン居宅介護支援イベント定義(QS001_14311_201504) 
 */
public abstract class QS001_14311_201504Event extends QS001_14311_201504SQL implements QS001Service {
  /**
   * コンストラクタです。
   */
  public QS001_14311_201504Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getKaigoSupportSpecialMemberName().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoSupportSpecialMemberNameActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoSupportManagementBasicRadio().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoSupportManagementBasicRadioSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoSupportDivisionRadio().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoSupportDivisionRadioSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoSupportStandardRadio().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoSupportStandardRadioSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getDischargeAddRadio().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                dischargeAddRadioSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getProviderAddMountainousAreaRafioRadioGroup().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                providerAddMountainousAreaRafioRadioGroupSelectionChanged(e);
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
   * 「介護支援専門員番号の表示」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void kaigoSupportSpecialMemberNameActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「運営環境基準減算選択時」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void kaigoSupportManagementBasicRadioSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「支援費区分選択時」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void kaigoSupportDivisionRadioSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「初回加算選択時」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void kaigoSupportStandardRadioSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「退院・退居時加算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void dischargeAddRadioSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「中山間地域等でのサービス提供」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void providerAddMountainousAreaRafioRadioGroupSelectionChanged(ListSelectionEvent e) throws Exception;

  //変数定義

  private boolean tokuteiAddFlag;
  private boolean controlLockFlag;
  private boolean isMountainousAreaProvider;
  //getter/setter

  /**
   * tokuteiAddFlagを返します。
   * @return tokuteiAddFlag
   */
  protected boolean getTokuteiAddFlag(){
    return tokuteiAddFlag;
  }
  /**
   * tokuteiAddFlagを設定します。
   * @param tokuteiAddFlag tokuteiAddFlag
   */
  protected void setTokuteiAddFlag(boolean tokuteiAddFlag){
    this.tokuteiAddFlag = tokuteiAddFlag;
  }

  /**
   * controlLockFlagを返します。
   * @return controlLockFlag
   */
  protected boolean getControlLockFlag(){
    return controlLockFlag;
  }
  /**
   * controlLockFlagを設定します。
   * @param controlLockFlag controlLockFlag
   */
  protected void setControlLockFlag(boolean controlLockFlag){
    this.controlLockFlag = controlLockFlag;
  }

  /**
   * isMountainousAreaProviderを返します。
   * @return isMountainousAreaProvider
   */
  protected boolean getIsMountainousAreaProvider(){
    return isMountainousAreaProvider;
  }
  /**
   * isMountainousAreaProviderを設定します。
   * @param isMountainousAreaProvider isMountainousAreaProvider
   */
  protected void setIsMountainousAreaProvider(boolean isMountainousAreaProvider){
    this.isMountainousAreaProvider = isMountainousAreaProvider;
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
   * 「画面状態制御」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void changeState() throws Exception;

}
