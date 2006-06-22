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
 * 作成日: 2006/01/09  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム 月間表 (QS001002)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.ListCellRenderer;
import javax.swing.event.ListSelectionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceCodeCalcurater;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceUnitCalcurateResult;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * 月間表(QS001002)
 */
public class QS001002 extends QS001002Event {
    /**
     * コンストラクタです。
     */
    public QS001002() {
        try {
            initAction(null);
        } catch (Exception ex) {
            ACCommon.getInstance().showExceptionMessage(ex);
        }
    }

    public void initAffair(ACAffairInfo affair) throws Exception {
        super.initAffair(affair);
        initAction(affair);
    }

    /**
     * 初期化処理を行ないます。
     * 
     * @param affair 業務情報
     * @throws Exception 処理例外
     */
    protected void initAction(ACAffairInfo affair) throws Exception {
    }

    /**
     * 「画面展開時イベント」に関する処理を行ないます。
     * 
     * @param ownerAffair QS001
     * @throws Exception 処理例外
     */
    public void initialize(QS001 ownerAffair) throws Exception {
        // ■画面展開時の処理を実行
        setOwnerAffair(ownerAffair);
        setCalcurater(getOwnerAffair().getCalcurater());
        // ※初期状態の設定
        // 状態の初期設定を行う。
        setState_INIT_STATE();
        // サービス予定なのか、サービス実績なのかをチェックする。

        setProcessType(getOwnerAffair().getProcessType());
        if (getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
            // サービス予定の場合
            // 「集計情報領域(sumups)」を表示する。
            setState_SERVICE_PLAN();
            // ※利用者情報(要介護度情報)の設定

            // 要介護度履歴情報格納用のレコード集合 patientInsureInfoHistoryListを生成する。
            VRList patientInsureInfoHistoryList = getPatientInsureInfoHistoryList();
            // 最も重い要介護度履歴情報格納用レコード patientInsureInfoHeaviest を生成する。
            VRMap patientInsureInfoHeaviest = QkanCommon
                    .getPatientInsureInfoOnMostHeavy(patientInsureInfoHistoryList);
            if (patientInsureInfoHeaviest != null) {
                // patientInsureInfoHeaviestより、最大の限度額(LIMIT_RATE)を取得する。
                // 取得した限度額を画面の「限度額(limit)」に設定する。
                getLimit().setText(
                        ACCastUtilities.toString(patientInsureInfoHeaviest
                                .getData("LIMIT_RATE")));
                
                setPatientInsureInfoHeaviest(patientInsureInfoHeaviest);
            }
            recalcServiceTotal();
        }else if(getProcessType()==QkanConstants.PROCESS_TYPE_RESULT){
            // サービス実績の場合
            // 「集計情報領域(sumups)」を非表示にする。
            setState_SERVICE_RESULT();
        }
        
        getMonthlySchedule().addDroppableListener(getOwnerAffair());

    }

    // コンポーネントイベント

    /**
     * 「自費調整」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void coordinatePrivateExpensesActionPerformed(ActionEvent e)
            throws Exception {
//        ■選択されているサービスに対する自費調整を行う                     
//        ※集計情報再計算                        
//            サービス種類ごとに下記の情報の再集計を行う。                  
//                管理対象内(サービスのうち、M_SERVICE_CODE.LIMIT_AMOUNT_OBJECT = 1であり、かつ30日超でないもの）                
//                調整分(サービス毎に設定した自費・調整単位の合計)               
//            集計によって洗い出された各サービスごとに、調整後合計(管理対象内 - 調整分)をもとめる。                   

        if (getSelectedServiceListBox() != null) {
            Date date = getMonthlySchedule().getTargetDate(
                    getSelectedServiceListBox());
            if (date != null) {
                VRMap service = getSelectedServiceListBox().getSelectedService();
                if (service != null) {
                     if(CareServiceCommon.is30DayOver(service)){
                         //30日超のサービスの場合
                         //30日超のサービスは全額自費扱いになるメッセージを表示して処理を終了する。
                         QkanMessageList.getInstance().QS001_ERROR_OF_EDIT_ON_30_DAY_OVER_SERVICE();
                         return;
                     }
                     
                    //TODO 1日や1月単位の算定項目（基本夜間対応型訪問介護費など）も自費調整の対象？
                    service.setData("SERVICE_DATE", date);
                    int reductedUnit = getCalcurater().getReductedUnit(service, false, CareServiceCodeCalcurater.CALC_MODE_IN_LIMIT_AMOUNT_OR_OUTER_SERVICE, null);
                    if (reductedUnit > 0) {
                        
                        // ※調整画面
                        // 「QS001029 自費・調整画面」を開く(ダイアログ)。その際、上記で準備したパラメータを送る。
                        // 「自費・調整画面」の終了方法をチェックする。
                        if (new QS001029().showModal(service, getMonthlySchedule()
                                .getMasterService(),
                                (VRMap) getHashedProviders().get(
                                        service.getData("PROVIDER_ID")),
                                reductedUnit)) {
                            // 「決定」で戻ってきた場合
                            // 「調整額」「自費フラグ」を更新する。
                            getOwnerAffair().setServiceModify(true);
                        }
                        // 「閉じる」で戻ってきた場合
                        // 何もしない。
                    }else{
                        QkanMessageList.getInstance().QS001_ERROR_OF_INVALID_UNIT_ADJUST();
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        ACFrame.debugStart(new ACAffairInfo(QS001002.class.getName()));
    }

    // 内部関数

    /**
     * 「月間表更新時イベント」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void recalcServiceTotal() throws Exception {
        // ■月間表の値が変更された場合のイベント
        // ※予定/実績判定
        // サービス予定なのか、サービス実績なのかをチェックする。
        // サービス予定の場合
        // 処理を継続する。
        // サービス実績の場合
        // 処理を中断する。


            // ※集計情報再計算
            // 下記の情報の再集計を行う。
            // 限度額(利用者の限度額)
            // 管理対象内(サービスのうち、M_SERVICE_CODE.LIMIT_AMOUNT_OBJECT =
            // 1であり、かつ30日超でないもの）
            // 超過分(限度額≧管理内の場合、0。限度額＜管理内の場合、管理内－限度額)
            // 調整分(サービス毎に設定した自費・調整単位の合計)
            // 調整後合計(管理対象内 - 調整分)
            int adjustTotal = 0;
            int managementTotal = 0;
            Map[] totalGroupingCache=new Map[]{new HashMap(), new HashMap()};
            VRList list = getSchedule(QkanConstants.SERVICE_DETAIL_GET_PLAN_OF_MONTHLY_ONLY);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                // サービスコードデータを取得
                VRMap row = (VRMap) it.next();
                managementTotal += getCalcurater().getReductedUnit(row, true, CareServiceCodeCalcurater.CALC_MODE_IN_LIMIT_AMOUNT,totalGroupingCache);
                adjustTotal += ACCastUtilities.toInt(row
                        .getData("REGULATION_RATE"), 0);
            }
            updateTotal(managementTotal, adjustTotal);
    }

    /**
     * 「集計明細の表示更新」に関する処理を行ないます。
     * 
     * @param managementTotal int
     * @param adjustTotal int
     * @throws Exception 処理例外
     */
    public void updateTotal(int managementTotal, int adjustTotal)
            throws Exception {
        int limit = ACCastUtilities.toInt(getLimit().getText(), 0);
        getLimitAmount().setText(ACCastUtilities.toString(managementTotal));
        getAdjustment().setText(ACCastUtilities.toString(adjustTotal));
        getAfterAdjustment().setText(
                ACCastUtilities.toString(managementTotal - adjustTotal));
        getOver().setText(
                ACCastUtilities.toString(Math.max(0, managementTotal- adjustTotal - limit)));
    }

    /**
     * 「対象年月を設定」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void setTargetDate(Date targetDate) throws Exception {
        // ■月間表の対象年月を設定
        // 月間表の対象年月を設定する。
        getMonthlySchedule().setTargetDate(targetDate);
    }

    /**
     * 「サービス描画用のセルレンダラ設定」に関する処理を行ないます。
     * 
     * @param renderer ListCellRenderer
     * @throws Exception 処理例外
     */
    public void setCellRenderer(ListCellRenderer renderer) throws Exception {
        getMonthlySchedule().setCellRenderer(renderer);
    }

    /**
     * サービスマスタ を設定します。
     * 
     * @param serviceMaster サービスマスタ
     */
    public void setMasterService(VRMap serviceMaster) {
        getMonthlySchedule().setMasterService(serviceMaster);
    }

    /**
     * 「スケジュール全体を設定」に関する処理を行ないます。
     * 
     * @param schedules VRList
     * @throws Exception 処理例外
     */
    public void setSchedule(VRList schedules) throws Exception {
        getMonthlySchedule().setSchedule(schedules);
        if(getOwnerAffair()!=null){
        getOwnerAffair().setServiceModify(true);
        }
    }

    /**
     * 「スケジュール全体を取得」に関する処理を行ないます。
     * 
     * @param useType int
     * @throws Exception 処理例外
     * @return VRList
     */
    public VRList getSchedule(int useType) throws Exception {
        return getMonthlySchedule().getSchedule(useType);
    }

    /**
     * スケジュールデータ件数を返します。
     * 
     * @return スケジュールデータ件数
     */
    public int getScheduleCount() throws Exception {
        return getMonthlySchedule().getScheduleCount();
    }

    /**
     * 「リスト選択イベントリスナを追加」に関する処理を行ないます。
     * 
     * @param listener ListSelectionListener
     * @throws Exception 処理例外
     */
    public void addListSelectionListener(ListSelectionListener listener) {
        getMonthlySchedule().addListSelectionListener(listener);
    }

    /**
     * 「リスト選択イベントリスナを追加」に関する処理を行ないます。
     * 
     * @param listener KeyListener
     * @throws Exception 処理例外
     */
    public void addKeyListener(KeyListener listener) {
        getMonthlySchedule().addKeyListener(listener);
    }

    /**
     * 「スケジュールを初期化」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void clearSchedule() throws Exception {
        getMonthlySchedule().clearSchedule();
        getOwnerAffair().setServiceModify(true);
    }

    /**
     * 「スケジュールを初期化」に関する処理を行ないます。
     * 
     * @param clearBegin Date
     * @throws Exception 処理例外
     */
    public void clearSchedule(Date clearBegin) throws Exception {
        getMonthlySchedule().clearSchedule(clearBegin);
    }

    /**
     * 「スケジュールを追加」に関する処理を行ないます。
     * 
     * @param schedules VRList
     * @throws Exception 処理例外
     */
    public void addSchedule(VRList schedules) throws Exception {
        getMonthlySchedule().addSchedule(schedules);
    }

    /**
     * 「サービスの選択」に関する処理を行ないます。
     * 
     * @param service QS001Service
     * @param selectedServiceListBox QS001DaySchedule
     * @throws Exception 処理例外
     */
    public void setSelectedService(QS001Service service,
            QS001DaySchedule selectedServiceListBox) throws Exception {
        // ■サービスの選択状態に応じて画面状態を設定
        // 選択しているサービスパネルクラスを内部変数(selectedServiceClass)に退避する。
        setSelectedServiceClass(service);
        // 選択しているサービスを所有するリストボックスを内部変数(selectedServiceListBox)に退避する。
        setSelectedServiceListBox(selectedServiceListBox);
        if (service != null) {
            // サービスが選択されている（サービスパネルがnullでない）場合
            if (getMonthlySchedule().isInCalendarSchedule(
                    getSelectedServiceListBox())) {
                // 選択しているサービスを所有するリストボックスが月間表の開始日を特定できるサービス用のリストボックスの場合
                // サービスを選択状態にする。
                setState_SERVICE_SELECTED();
            } else {
                // 選択しているサービスを所有するリストボックスが月間表の開始日を特定できるサービス用のリストボックスではない場合
                // サービスを未選択状態にする。
                setState_SERVICE_UNSELECTED();
            }
        } else {
            // サービスが選択されていない（サービスパネルがnull）の場合
            // サービスを未選択状態にする。
            setState_SERVICE_UNSELECTED();
        }
    }

    /**
     * 「単位集計」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void calcurateActionPerformed(ActionEvent e) throws Exception {
        // ■設定されているサービスの単位集計
        // 設定されているサービスの単位集計を行う。
        recalcServiceTotal();

    }

    /**
     * 「集計明細」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void detailsbuttonActionPerformed(ActionEvent e) throws Exception {
        // ■集計明細を表示する
        // ※集計情報再計算
        // サービス種類ごとに下記の情報の再集計を行う。
        // 管理対象内(サービスのうち、M_SERVICE_CODE.LIMIT_AMOUNT_OBJECT = 1であり、かつ30日超でないもの）
        // 調整分(サービス毎に設定した自費・調整単位の合計)
        
        VRList list = getSchedule(QkanConstants.SERVICE_DETAIL_GET_PLAN_OF_MONTHLY_ONLY);
        CareServiceUnitCalcurateResult inLimitAmout = getCalcurater()
                .getServiceUnitCalcurateResult(list,
                        CareServiceCodeCalcurater.CALC_MODE_IN_LIMIT_AMOUNT);
        CareServiceUnitCalcurateResult outerService = getCalcurater()
        .getServiceUnitCalcurateResult(list,
                CareServiceCodeCalcurater.CALC_MODE_OUTER_SERVICE_LIMIT_AMOUNT);


        // 集計によって洗い出された各サービスごとに、調整後合計(管理対象内 - 調整分)をもとめる。
        updateTotal(inLimitAmout.getManagementTotal(), inLimitAmout.getAdjustTotal());

        // ※集計明細画面
        // 「QS001030 集計明細画面」を開く(ダイアログ)。その際、上記で準備したパラメータを送る。
        new QS001030().showModal(inLimitAmout, outerService, getPatientInsureInfoHeaviest());
    }

    /**
     * 「印刷可能要件チェック」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     * @return boolean
     */
    public boolean checkPrintable() throws Exception {
        // ■印刷処理実行に必要な要件を満たしているかをチェックし、その結果を返す。

        // 当月の要介護認定履歴のうち最も重い要介護度の認定履歴を取得する。
        VRMap info = QkanCommon
                .getPatientInsureInfoOnMostHeavy(getPatientInsureInfoHistoryList());
        if (info == null) {
            // 認定履歴を取得できなかった場合
            // 認定履歴が存在しないエラーを表示し、falseを返す。
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_INSURE_INFO();
            return false;
        }

        // 引数の予定/実績モードを基準に月間表を走査し、サービスの調整済み単位を合算する。
        int getType;
        if (getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
            getType = QkanConstants.SERVICE_DETAIL_GET_PLAN_OF_MONTHLY_ONLY;
        } else {
            //実績ならば常に印刷可能
            return true;
//            getType = QkanConstants.SERVICE_DETAIL_GET_RESULT;
        }

        //再集計ロジックを通す。
        recalcServiceTotal();
        int limitRate = ACCastUtilities.toInt(getLimit().getText(), 0);
        int managementTotal = ACCastUtilities.toInt(getAfterAdjustment().getText(), 0);

        if (limitRate < managementTotal) {
            // 調整済み単位の合算が、当月の最も重い要介護認定履歴の支給限度額を超えている場合
            // 支給限度額の超過エラーを表示し、falseを返す。
            QkanMessageList.getInstance().QS001_ERROR_OF_LIMIT_RATE_OVER();
            return false;
        }
        if(managementTotal<0){
            //調整後合計が0未満
            QkanMessageList.getInstance().QS001_ERROR_OF_MINIMUM_OVER();
            return false;
        }
        // 問題なければtrueを返す。
        return true;
    }

    /**
     * 「DBマネージャ取得」に関する処理を行ないます。
     *
     * @throws Exception 処理例外
     * @return ACDBManager
     */
    public ACDBManager getDBManager() throws Exception {
        return getCalcurater().getDBManager();
    }

    /**
     * 「要介護認定履歴取得」に関する処理を行ないます。
     *
     * @throws Exception 処理例外
     * @return VRList
     */
    public VRList getPatientInsureInfoHistoryList() throws Exception {
        return getCalcurater().getPatientInsureInfoHistoryList();
    }

    /**
     * 「事業所情報ハッシュ取得」に関する処理を行ないます。
     *
     * @throws Exception 処理例外
     * @return VRMap
     */
    public VRMap getHashedProviders() throws Exception {
        return getCalcurater().getHashedProviders();
    }

    /**
     * 「開始日の特定できないサービスリスト取得」に関する処理を行ないます。
     *
     * @throws Exception 処理例外
     * @return QS001DaySchedule
     */
    public QS001DaySchedule getDayFreeServices() throws Exception {
        return getMonthlySchedule().getDayFreeServices();
    }

}
