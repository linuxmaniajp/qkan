
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
 * 作成日: 2006/06/05  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム 月間表 (QS001002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.dnd.*;
import jp.nichicom.ac.component.dnd.event.*;
import jp.nichicom.ac.component.event.*;
import jp.nichicom.ac.component.mainmenu.*;
import jp.nichicom.ac.component.table.*;
import jp.nichicom.ac.component.table.event.*;
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
import jp.nichicom.ac.lang.*;
import jp.nichicom.ac.pdf.*;
import jp.nichicom.ac.sql.*;
import jp.nichicom.ac.text.*;
import jp.nichicom.ac.util.*;
import jp.nichicom.ac.util.adapter.*;
import jp.nichicom.vr.*;
import jp.nichicom.vr.bind.*;
import jp.nichicom.vr.bind.event.*;
import jp.nichicom.vr.border.*;
import jp.nichicom.vr.component.*;
import jp.nichicom.vr.component.event.*;
import jp.nichicom.vr.component.table.*;
import jp.nichicom.vr.container.*;
import jp.nichicom.vr.focus.*;
import jp.nichicom.vr.image.*;
import jp.nichicom.vr.io.*;
import jp.nichicom.vr.layout.*;
import jp.nichicom.vr.text.*;
import jp.nichicom.vr.text.parsers.*;
import jp.nichicom.vr.util.*;
import jp.nichicom.vr.util.adapter.*;
import jp.nichicom.vr.util.logging.*;
import jp.or.med.orca.qkan.*;
import jp.or.med.orca.qkan.affair.*;
import jp.or.med.orca.qkan.component.*;
import jp.or.med.orca.qkan.text.*;
import jp.nichicom.ac.lib.care.claim.print.schedule.*;

/**
 * 月間表イベント定義(QS001002) 
 */
public abstract class QS001002Event extends QS001002State {
  /**
   * コンストラクタです。
   */
  public QS001002Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getCoordinatePrivateExpenses().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                coordinatePrivateExpensesActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getDetailsbutton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                detailsbuttonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getCalcurate().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                calcurateActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPlanUnit().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                planUnitActionPerformed(e);
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
   * 「自費調整」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void coordinatePrivateExpensesActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「集計明細」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void detailsbuttonActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「単位集計」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void calcurateActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「計画単位数編集」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void planUnitActionPerformed(ActionEvent e) throws Exception;

  //変数定義

  private QS001 ownerAffair;
  private int processType;
  private QS001DaySchedule selectedServiceListBox;
  private QS001Service selectedServiceClass;
  public static final int CALC_MODE_IN_LIMIT_AMOUNT = 1;
  private CareServiceCodeCalcurater calcurater;
  private VRMap patientInsureInfoHeaviest = new VRHashMap();
  private VRMap planUnits = new VRHashMap();
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

  /**
   * processTypeを返します。
   * @return processType
   */
  protected int getProcessType(){
    return processType;
  }
  /**
   * processTypeを設定します。
   * @param processType processType
   */
  protected void setProcessType(int processType){
    this.processType = processType;
  }

  /**
   * selectedServiceListBoxを返します。
   * @return selectedServiceListBox
   */
  protected QS001DaySchedule getSelectedServiceListBox(){
    return selectedServiceListBox;
  }
  /**
   * selectedServiceListBoxを設定します。
   * @param selectedServiceListBox selectedServiceListBox
   */
  protected void setSelectedServiceListBox(QS001DaySchedule selectedServiceListBox){
    this.selectedServiceListBox = selectedServiceListBox;
  }

  /**
   * selectedServiceClassを返します。
   * @return selectedServiceClass
   */
  protected QS001Service getSelectedServiceClass(){
    return selectedServiceClass;
  }
  /**
   * selectedServiceClassを設定します。
   * @param selectedServiceClass selectedServiceClass
   */
  protected void setSelectedServiceClass(QS001Service selectedServiceClass){
    this.selectedServiceClass = selectedServiceClass;
  }

  /**
   * calcuraterを返します。
   * @return calcurater
   */
  protected CareServiceCodeCalcurater getCalcurater(){
    return calcurater;
  }
  /**
   * calcuraterを設定します。
   * @param calcurater calcurater
   */
  protected void setCalcurater(CareServiceCodeCalcurater calcurater){
    this.calcurater = calcurater;
  }

  /**
   * patientInsureInfoHeaviestを返します。
   * @return patientInsureInfoHeaviest
   */
  protected VRMap getPatientInsureInfoHeaviest(){
    return patientInsureInfoHeaviest;
  }
  /**
   * patientInsureInfoHeaviestを設定します。
   * @param patientInsureInfoHeaviest patientInsureInfoHeaviest
   */
  protected void setPatientInsureInfoHeaviest(VRMap patientInsureInfoHeaviest){
    this.patientInsureInfoHeaviest = patientInsureInfoHeaviest;
  }

  /**
   * planUnitsを返します。
   * @return planUnits
   */
  protected VRMap getPlanUnits(){
    return planUnits;
  }
  /**
   * planUnitsを設定します。
   * @param planUnits planUnits
   */
  protected void setPlanUnits(VRMap planUnits){
    this.planUnits = planUnits;
  }

  //内部関数

  /**
   * 「画面展開時イベント」に関する処理を行ないます。
   *
   * @param ownerAffair QS001
   * @throws Exception 処理例外
   *
   */
  public abstract void initialize(QS001 ownerAffair) throws Exception;

  /**
   * 「月間表更新時イベント」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void recalcServiceTotal() throws Exception;

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
   * @param useType int
   * @param includeFreeday boolean
   * @throws Exception 処理例外
   * @return VRList
   */
  public abstract VRList getSchedule(int useType, boolean includeFreeday) throws Exception;

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
   * 「スケジュールを初期化」に関する処理を行ないます。
   *
   * @param clearBegin Date
   * @throws Exception 処理例外
   *
   */
  public abstract void clearSchedule(Date clearBegin) throws Exception;

  /**
   * 「スケジュールを追加」に関する処理を行ないます。
   *
   * @param schedules VRList
   * @throws Exception 処理例外
   *
   */
  public abstract void addSchedule(VRList schedules) throws Exception;

  /**
   * 「サービスの選択」に関する処理を行ないます。
   *
   * @param service QS001Service
   * @param selectedServiceListBox QS001DaySchedule
   * @throws Exception 処理例外
   *
   */
  public abstract void setSelectedService(QS001Service service, QS001DaySchedule selectedServiceListBox) throws Exception;

  /**
   * 「集計明細の表示更新」に関する処理を行ないます。
   *
   * @param managementTotal int
   * @param adjustTotal int
   * @throws Exception 処理例外
   *
   */
  public abstract void updateTotal(int managementTotal, int adjustTotal) throws Exception;

  /**
   * 「印刷可能要件チェック」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean checkPrintable() throws Exception;

  /**
   * 「DBマネージャ取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return ACDBManager
   */
  public abstract ACDBManager getDBManager() throws Exception;

  /**
   * 「要介護認定履歴取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return VRList
   */
  public abstract VRList getPatientInsureInfoHistoryList() throws Exception;

  /**
   * 「事業所情報ハッシュ取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return VRMap
   */
  public abstract VRMap getHashedProviders() throws Exception;

  /**
   * 「開始日の特定できないサービスリスト取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return QS001DaySchedule
   */
  public abstract QS001DaySchedule getDayFreeServices() throws Exception;

  /**
   * 「計画単位数を取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return VRMap
   */
  public abstract VRMap getServicePlanUnits() throws Exception;

  /**
   * 「計画単位数を設定」に関する処理を行ないます。
   *
   * @param services VRMap
   * @throws Exception 処理例外
   *
   */
  public abstract void setServicePlanUnits(VRMap services) throws Exception;

}
