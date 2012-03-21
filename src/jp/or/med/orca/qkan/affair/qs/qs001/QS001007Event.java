
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
 * 作成日: 2007/12/17  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービス予定 (QS001033)
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
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;

/**
 * サービス予定イベント定義(QS001033) 
 */
@SuppressWarnings("serial")
public abstract class QS001007Event extends QS001007Design {
  /**
   * コンストラクタです。
   */
  public QS001007Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getOkButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                okButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getCancelButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                cancelButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getAfterServiceText().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                afterServiceTextFocusLost(e);
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
   * 「okボタン押下時の処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void okButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「キャンセルボタン押下時の処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void cancelButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「ロストフォーカスイベント」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void afterServiceTextFocusLost(FocusEvent e) throws Exception;

  //変数定義

  private VRMap changeData = new VRHashMap();
  private boolean entryType;
  private ACFollowContainerFormatEventListener afterServiceTextBackgroundChanger;
  //getter/setter

  /**
   * changeDataを返します。
   * @return changeData
   */
  protected VRMap getChangeData(){
    return changeData;
  }
  /**
   * changeDataを設定します。
   * @param changeData changeData
   */
  protected void setChangeData(VRMap changeData){
    this.changeData = changeData;
  }

  /**
   * entryTypeを返します。
   * @return entryType
   */
  protected boolean getEntryType(){
    return entryType;
  }
  /**
   * entryTypeを設定します。
   * @param entryType entryType
   */
  protected void setEntryType(boolean entryType){
    this.entryType = entryType;
  }

  /**
   * afterServiceTextBackgroundChangerを返します。
   * @return afterServiceTextBackgroundChanger
   */
  protected ACFollowContainerFormatEventListener getAfterServiceTextBackgroundChanger(){
    return afterServiceTextBackgroundChanger;
  }
  /**
   * afterServiceTextBackgroundChangerを設定します。
   * @param afterServiceTextBackgroundChanger afterServiceTextBackgroundChanger
   */
  protected void setAfterServiceTextBackgroundChanger(ACFollowContainerFormatEventListener afterServiceTextBackgroundChanger){
    this.afterServiceTextBackgroundChanger = afterServiceTextBackgroundChanger;
  }

  //内部関数

  /**
   * 「画面展開」に関する処理を行ないます。
   *
   * @param baseData VRMap
   * @param dbm ACDBManager
   * @throws Exception 処理例外
   *
   */
  public abstract void showModel(VRMap baseData, ACDBManager dbm) throws Exception;

  /**
   * 「入力チェック処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean checkInputData() throws Exception;

  /**
   * 「戻り状態返却」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean isPatternNameChange() throws Exception;

}
