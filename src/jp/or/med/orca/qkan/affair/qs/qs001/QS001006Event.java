
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
 * 作成日: 2006/02/14  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム 自費・調整画面 (QS001029)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.component.event.ACFollowContainerFormatEventListener;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;

/**
 * 自費・調整画面イベント定義(QS001029) 
 */
@SuppressWarnings("serial")
public abstract class QS001006Event extends QS001006State {
  /**
   * コンストラクタです。
   */
  public QS001006Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getServiceIndependence().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                serviceIndependenceActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getServiceAdjustUnit().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                serviceAdjustUnitFocusLost(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getSubmit().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                submitActionPerformed(e);
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

  }
  //コンポーネントイベント

  /**
   * 「自費/調整変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void serviceIndependenceActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「調整額変更時チェック」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void serviceAdjustUnitFocusLost(FocusEvent e) throws Exception;

  /**
   * 「決定処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void submitActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「キャンセル」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void closeActionPerformed(ActionEvent e) throws Exception;

  //変数定義

  private VRMap values = new VRHashMap();
  private boolean applied = false;
  private ACFollowContainerFormatEventListener adjustUnitBackgroundChanger;
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

  /**
   * adjustUnitBackgroundChangerを返します。
   * @return adjustUnitBackgroundChanger
   */
  protected ACFollowContainerFormatEventListener getAdjustUnitBackgroundChanger(){
    return adjustUnitBackgroundChanger;
  }
  /**
   * adjustUnitBackgroundChangerを設定します。
   * @param adjustUnitBackgroundChanger adjustUnitBackgroundChanger
   */
  protected void setAdjustUnitBackgroundChanger(ACFollowContainerFormatEventListener adjustUnitBackgroundChanger){
    this.adjustUnitBackgroundChanger = adjustUnitBackgroundChanger;
  }

  //内部関数

  /**
   * 「初期設定」に関する処理を行ないます。
   *
   * @param serviceData VRMap
   * @param serviceMaster VRMap
   * @param provider VRMap
   * @param managementTotal int
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean showModal(VRMap serviceData, VRMap serviceMaster, VRMap provider, int managementTotal) throws Exception;

  /**
   * 「自費/調整変更時の状態設定」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void setExpenceState() throws Exception;

  /**
   * 「調整結果判定」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return int
   */
  public abstract int getAdjustResult() throws Exception;

}
