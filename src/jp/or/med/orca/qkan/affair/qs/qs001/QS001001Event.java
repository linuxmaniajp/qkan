
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
 * 作成日: 2006/03/20  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム 週間表 (QS001001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.ListCellRenderer;
import javax.swing.event.ListSelectionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * 週間表イベント定義(QS001001) 
 */
public abstract class QS001001Event extends QS001001State {
  /**
   * コンストラクタです。
   */
  public QS001001Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getTimeButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                timeButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getExceptionButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                exceptionButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getEverydayButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                everydayButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getExpansionButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                expansionButtonActionPerformed(e);
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
   * 「サービスの設定」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void timeButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「サービスの設定」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void exceptionButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「サービスの設定」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void everydayButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「月間表への展開」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void expansionButtonActionPerformed(ActionEvent e) throws Exception;

  //変数定義

  private QS001 ownerAffair;
  public static final String SERVICE_SPAN_BIND_PATH = "101";
  //getter/setter

  /**
   * ownerAffairを返します。
   * @return ownerAffair
   */
  protected QS001 getOwnerAffair(){
    return ownerAffair;
  }
  /**
   * ownerAffairを設定します。
   * @param ownerAffair ownerAffair
   */
  protected void setOwnerAffair(QS001 ownerAffair){
    this.ownerAffair = ownerAffair;
  }

  //内部関数

  /**
   * 「画面初期化」に関する処理を行ないます。
   *
   * @param ownerAffair QS001
   * @throws Exception 処理例外
   *
   */
  public abstract void initialize(QS001 ownerAffair) throws Exception;

  /**
   * 「日常チェックボックスのEnabled設定」に関する処理を行ないます。
   *
   * @param enabled boolean
   * @throws Exception 処理例外
   *
   */
  public abstract void setDailylifeCheckEnabled(boolean enabled) throws Exception;

  /**
   * 「作成年月日の取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return Date
   */
  public abstract Date getCreateDateValue() throws Exception;

  /**
   * 「対象年月を設定」に関する処理を行ないます。
   *
   * @param targetDate Date
   * @throws Exception 処理例外
   *
   */
  public abstract void setTargetDate(Date targetDate) throws Exception;

  /**
   * 「サービス描画用のセルレンダラ設定」に関する処理を行ないます。
   *
   * @param renderer ListCellRenderer
   * @throws Exception 処理例外
   *
   */
  public abstract void setCellRenderer(ListCellRenderer renderer) throws Exception;

  /**
   * 「サービスマスタ設定」に関する処理を行ないます。
   *
   * @param serviceMaster VRMap
   * @throws Exception 処理例外
   *
   */
  public abstract void setMasterService(VRMap serviceMaster) throws Exception;

  /**
   * 「スケジュール全体を設定」に関する処理を行ないます。
   *
   * @param schedules VRList
   * @throws Exception 処理例外
   *
   */
  public abstract void setSchedule(VRList schedules) throws Exception;

  /**
   * 「スケジュール全体を取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return VRList
   */
  public abstract VRList getSchedule() throws Exception;

  /**
   * 「リスト選択イベントリスナを追加」に関する処理を行ないます。
   *
   * @param listener ListSelectionListener   *
   */
  public abstract void addListSelectionListener(ListSelectionListener listener);

  /**
   * 「リスト選択イベントリスナを追加」に関する処理を行ないます。
   *
   * @param listener KeyListener   *
   */
  public abstract void addKeyListener(KeyListener listener);

  /**
   * 「スケジュール件数を取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return int
   */
  public abstract int getScheduleCount() throws Exception;

  /**
   * 「スケジュールを初期化」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void clearSchedule() throws Exception;

  /**
   * 「開始日と期間を設定」に関する処理を行ないます。
   *
   * @param service VRMap
   * @throws Exception 処理例外
   *
   */
  public abstract void setServiceSpan(VRMap service) throws Exception;

  /**
   * 「週単位以外のサービスを設定」に関する処理を行ないます。
   *
   * @param schedules VRList
   * @throws Exception 処理例外
   *
   */
  public abstract void setFreedaySchedule(VRList schedules) throws Exception;

  /**
   * 「週単位以外のサービスを取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return VRList
   */
  public abstract VRList getAllFreedaySchedule() throws Exception;

  /**
   * 「週単位のサービスを取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return VRList
   */
  public abstract VRList getAllWeeklySchedule() throws Exception;

  /**
   * 「週間表のリストであるか」に関する処理を行ないます。
   *
   * @param list QS001DaySchedule
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean isWeeklyServiceList(QS001DaySchedule list) throws Exception;

  /**
   * 「主な日常生活上の活動を表すリストであるか」に関する処理を行ないます。
   *
   * @param list QS001DaySchedule
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean isDailyServiceList(QS001DaySchedule list) throws Exception;

}
