
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
 * 作成日: 2012/02/16  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護老人保健施設 (QS001_15211_201204)
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
 * サービスパターン介護老人保健施設イベント定義(QS001_15211_201204) 
 */
public abstract class QS001_15211_201204Event extends QS001_15211_201204State implements QS001Service {
  /**
   * コンストラクタです。
   */
  public QS001_15211_201204Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getKaigoHealthCareOfTheAgedDivisionRadio().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoHealthCareOfTheAgedDivisionRadioActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoHealthCareOfTheAgedHospitalDivision1().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoHealthCareOfTheAgedHospitalDivision1ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoHealthCareOfTheAgedDinnerOffer().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoHealthCareOfTheAgedDinnerOfferActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getSpecialMedicalExpense().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                specialMedicalExpenseActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoHealthCareOfTheAgedOralSwitchRadio().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoHealthCareOfTheAgedOralSwitchRadioSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getOralMaintenanceAddRadio().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                oralMaintenanceAddRadioSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getOralKeepStructureAddRadioGroup().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                oralKeepStructureAddRadioGroupSelectionChanged(e);
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
   * 「施設区分選択時イベント」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void kaigoHealthCareOfTheAgedDivisionRadioActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「人員配置区分選択時イベント」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void kaigoHealthCareOfTheAgedHospitalDivision1ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「食事提供選択」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void kaigoHealthCareOfTheAgedDinnerOfferActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「特別療養費設定」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void specialMedicalExpenseActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「経口移行加算の変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void kaigoHealthCareOfTheAgedOralSwitchRadioSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「経口維持加算の変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void oralMaintenanceAddRadioSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「口腔機能維持管理体制加算の変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void oralKeepStructureAddRadioGroupSelectionChanged(ListSelectionEvent e) throws Exception;

  //変数定義

  private boolean unitCareFlag;
  public static final int SYSTEM_SERVICE_KIND_DETAIL = 15211;
  //getter/setter

  /**
   * unitCareFlagを返します。
   * @return unitCareFlag
   */
  protected boolean getUnitCareFlag(){
    return unitCareFlag;
  }
  /**
   * unitCareFlagを設定します。
   * @param unitCareFlag unitCareFlag
   */
  protected void setUnitCareFlag(boolean unitCareFlag){
    this.unitCareFlag = unitCareFlag;
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
   * 「食事費用を取得」に関する処理を行ないます。
   *
   * @param meatType int
   * @throws Exception 処理例外
   * @return String
   */
  public abstract String getMeatCost(int meatType) throws Exception;

  /**
   * 「データバインド後の処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void binded() throws Exception;

  /**
   * 「画面状態制御」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void changeState() throws Exception;

}
