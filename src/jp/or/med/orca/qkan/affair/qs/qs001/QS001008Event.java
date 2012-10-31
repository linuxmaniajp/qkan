
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
 * 作成日: 2012/08/08  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定 (S)
 * プロセス カレンダー (001)
 * プログラム 特定診療費・特別療養費集計 (QS001008)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * 特定診療費・特別療養費集計イベント定義(QS001008) 
 */
public abstract class QS001008Event extends QS001008State {
  /**
   * コンストラクタです。
   */
  public QS001008Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getClose().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                closeActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getServiceCombo().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                serviceComboActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getTokubetsuTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                tokubetsuTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getProviderCombo().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                providerComboActionPerformed(e);
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
   * 「閉じる」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void closeActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「サービス種類コンボ選択」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void serviceComboActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「特定診療費テーブル選択」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void tokubetsuTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「事業所コンボ選択時」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void providerComboActionPerformed(ActionEvent e) throws Exception;

  //変数定義

  private ACTableModelAdapter mainTableModel;
  private ACTableModelAdapter detailTableModel;
  private VRMap providerService = new VRHashMap();
  private VRMap providerDiagnosis = new VRHashMap();
  private Date targetDate;
  //getter/setter

  /**
   * mainTableModelを返します。
   * @return mainTableModel
   */
  protected ACTableModelAdapter getMainTableModel(){
    return mainTableModel;
  }
  /**
   * mainTableModelを設定します。
   * @param mainTableModel mainTableModel
   */
  protected void setMainTableModel(ACTableModelAdapter mainTableModel){
    this.mainTableModel = mainTableModel;
  }

  /**
   * detailTableModelを返します。
   * @return detailTableModel
   */
  protected ACTableModelAdapter getDetailTableModel(){
    return detailTableModel;
  }
  /**
   * detailTableModelを設定します。
   * @param detailTableModel detailTableModel
   */
  protected void setDetailTableModel(ACTableModelAdapter detailTableModel){
    this.detailTableModel = detailTableModel;
  }

  /**
   * providerServiceを返します。
   * @return providerService
   */
  protected VRMap getProviderService(){
    return providerService;
  }
  /**
   * providerServiceを設定します。
   * @param providerService providerService
   */
  protected void setProviderService(VRMap providerService){
    this.providerService = providerService;
  }

  /**
   * providerDiagnosisを返します。
   * @return providerDiagnosis
   */
  protected VRMap getProviderDiagnosis(){
    return providerDiagnosis;
  }
  /**
   * providerDiagnosisを設定します。
   * @param providerDiagnosis providerDiagnosis
   */
  protected void setProviderDiagnosis(VRMap providerDiagnosis){
    this.providerDiagnosis = providerDiagnosis;
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

  //内部関数

  /**
   * 「初期設定」に関する処理を行ないます。
   *
   * @param Map> diagnosisDateMap Map<String,
   * @param targetDate Date
   * @throws Exception 処理例外
   *
   */
  public abstract void showModal(Map<String, Map> diagnosisDateMap, Date targetDate) throws Exception;

  /**
   * 「特定診療費・特別療養費計算」に関する処理を行ないます。
   *
   * @param ArrayList<Map>> tokuteiMap Map<String,
   * @throws Exception 処理例外
   * @return VRList
   */
  public abstract VRList calcDiagnosis(Map<String, ArrayList<Map>> tokuteiMap) throws Exception;

}
