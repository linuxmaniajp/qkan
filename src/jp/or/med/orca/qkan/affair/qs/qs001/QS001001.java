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
 * 作成日: 2006/01/08  日本コンピューター株式会社 堤 瑞樹 新規作成
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
import java.awt.event.KeyListener;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JCheckBox;
import javax.swing.ListCellRenderer;
import javax.swing.event.ListSelectionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * 週間表(QS001001)
 */
public class QS001001 extends QS001001Event {
    /**
     * コンストラクタです。
     */
    public QS001001() {
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
        getFreedayServices().setHeaderVisible(false);
        // 週間表の作成日付にはシステム日付を設定
        getCreateDate().setDate(
                QkanSystemInformation.getInstance().getSystemDate());

    }

    // コンポーネントイベント

    /**
     * 「サービスの設定」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void timeButtonActionPerformed(ActionEvent e) throws Exception {
        // ■週間表に「サービス詳細」の情報を設定
        Integer useType = null;
        if (getOwnerAffair().getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
            useType = QkanConstants.SERVICE_USE_TYPE_PLAN_WEEKLY_DAY;
        } else if (getOwnerAffair().getProcessType() == QkanConstants.PROCESS_TYPE_RESULT) {
            useType = QkanConstants.SERVICE_USE_TYPE_RESULT_WEEKLY_DAY;
        }

        if (getMondayCheck().isVisible()) {
            // サービスが「主な日常生活上の活動」ではない場合
            if (!(getMondayCheck().isSelected()
                    || getTuesdayCheck().isSelected()
                    || getWednesdayCheck().isSelected()
                    || getThursdayCheck().isSelected()
                    || getFridayCheck().isSelected()
                    || getSaturdayCheck().isSelected() || getSundayCheck()
                    .isSelected())) {
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_PASTE_WEEK();
                return;
            }

            VRMap service = getOwnerAffair().createServiceData();
            if (service != null) {
                // 「時刻・曜日の設定」でチェックしている曜日に「サービス詳細」の情報を設定する。「午前」「午後」の判別は「開始時刻」にて行う。
                // 「開始時刻」が設定されていない場合、午前のサービスとして処理する。
                Integer[] weekdays;

                Object beginTime = getBeginCombo().getDate();
                if ((!(beginTime instanceof Date))
                        || ACDateUtilities.isAM(ACCastUtilities
                                .toDate(beginTime))) {
                    weekdays = new Integer[] {
                            QkanConstants.SERVICE_WEEK_DAY_MONDAY_AM,
                            QkanConstants.SERVICE_WEEK_DAY_TUESDAY_AM,
                            QkanConstants.SERVICE_WEEK_DAY_WEDNESDAY_AM,
                            QkanConstants.SERVICE_WEEK_DAY_THURSDAY_AM,
                            QkanConstants.SERVICE_WEEK_DAY_FRIDAY_AM,
                            QkanConstants.SERVICE_WEEK_DAY_SATURDAY_AM,
                            QkanConstants.SERVICE_WEEK_DAY_SUNDAY_AM, };
                } else {
                    weekdays = new Integer[] {
                            QkanConstants.SERVICE_WEEK_DAY_MONDAY_PM,
                            QkanConstants.SERVICE_WEEK_DAY_TUESDAY_PM,
                            QkanConstants.SERVICE_WEEK_DAY_WEDNESDAY_PM,
                            QkanConstants.SERVICE_WEEK_DAY_THURSDAY_PM,
                            QkanConstants.SERVICE_WEEK_DAY_FRIDAY_PM,
                            QkanConstants.SERVICE_WEEK_DAY_SATURDAY_PM,
                            QkanConstants.SERVICE_WEEK_DAY_SUNDAY_PM, };
                }
                JCheckBox[] checks = new JCheckBox[] { getMondayCheck(),
                        getTuesdayCheck(), getWednesdayCheck(),
                        getThursdayCheck(), getFridayCheck(),
                        getSaturdayCheck(), getSundayCheck(), };
                // ユニークキーの削除
                service.remove("SERVICE_ID");
                VRList add = new VRArrayList();
                for (int i = 0; i < weekdays.length; i++) {
                    if (checks[i].isSelected()) {
                        VRMap map = (VRMap) (((HashMap) service).clone());
                        VRBindPathParser.set("WEEK_DAY", map, weekdays[i]);
                        VRBindPathParser.set("SERVICE_USE_TYPE", map, useType);
                        add.add(map);
                    }
                }
                getWeeklySchedule().addSchedule(add);
            }
        } else {
            // サービスが「主な日常生活上の活動」の場合
            VRMap service = getOwnerAffair().createServiceData();
            if (service != null) {
                // 週間表の「主な日常生活上の活動」欄に「サービス詳細」の情報を設定する。「午前」「午後」の判別は「開始時刻」にて行う。
                // 「開始時刻」が設定されていない場合、午前のサービスとして処理する。
                Object beginTime = getBeginCombo().getDate();
                if ((!(beginTime instanceof Date))
                        || ACDateUtilities.isAM(ACCastUtilities
                                .toDate(beginTime))) {
                    VRBindPathParser.set("WEEK_DAY", service,
                            QkanConstants.SERVICE_WEEK_DAY_FREE_AM);
                } else {
                    VRBindPathParser.set("WEEK_DAY", service,
                            QkanConstants.SERVICE_WEEK_DAY_FREE_PM);
                }
                // ユニークキーの削除
                service.remove("SERVICE_ID");

                VRBindPathParser.set("SERVICE_USE_TYPE", service, useType);

                VRList add = new VRArrayList();
                add.add(service);
                getWeeklySchedule().addSchedule(add);
            }
        }

    }

    /**
     * 「サービスの設定」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void exceptionButtonActionPerformed(ActionEvent e)
            throws Exception {
        // ■週間表の「週単位以外」に、「サービス詳細」の情報を設定(期間はコンボで選択されている期間)
        // ただし、「主な日常生活上の活動」は、「毎日（月初～末迄）」の場合のみ展開可能。
        if ((!getExceptionEndCombo().isSelected())
                || (!(getExceptionEndCombo().getSelectedItem() instanceof VRMap))) {
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_PASTE_DAY();
            return;
        }

        VRMap service = getOwnerAffair().createServiceData();
        if (service != null) {
            // ユニークキーの削除
            service.remove("SERVICE_ID");
            Integer useType = null;
            if (getOwnerAffair().getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
                useType = QkanConstants.SERVICE_USE_TYPE_PLAN_WEEKLY_FREE_DAY;
            } else if (getOwnerAffair().getProcessType() == QkanConstants.PROCESS_TYPE_RESULT) {
                useType = QkanConstants.SERVICE_USE_TYPE_RESULT_WEEKLY_FREE_DAY;
            }
            service.setData("SERVICE_USE_TYPE", useType);
            Object obj = getExceptionBeginCombo().getSelectedModelItem();
            if (obj instanceof VRMap) {
                // 開始日
                service.setData("WEEK_DAY",
                        VRBindPathParser.get("CONTENT_KEY", (VRMap) obj));
                // 日数
                service.setData(QkanConstants.SERVICE_SYSTEM_BIND_PATH_SPAN,
                        VRBindPathParser.get("CONTENT_KEY",
                                (VRMap) getExceptionEndCombo()
                                        .getSelectedModelItem()));
                // 貼り付ける
                getFreedayServices().addSchedule(service);
                getOwnerAffair().setServiceModify(true);
            }
        }

    }

    /**
     * 「サービスの設定」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void everydayButtonActionPerformed(ActionEvent e)
            throws Exception {
        // ■週間表の「週単位以外」に、「サービス詳細」の情報を設定(期間は、「月初」から「末迄」)
        // 期間のコンボを「月初」から「末迄」に設定する。
        getExceptionBeginCombo().setSelectedIndex(
                getExceptionBeginCombo().getItemCount() - 1);
        getExceptionEndCombo().setSelectedIndex(
                getExceptionEndCombo().getItemCount() - 1);
        exceptionButtonActionPerformed(e);
    }

    /**
     * 「月間表への展開」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void expansionButtonActionPerformed(ActionEvent e)
            throws Exception {
        // ■週間表に設定されているサービス情報を月間表に設定
        // ※月間表に展開しないサービス
        // サービス「その他」は、月間表に展開しない。

        // 展開開始日を算出
        Date expansionBeginDay = ACDateUtilities
                .toFirstDayOfMonth(getWeeklySchedule().getTargetDate());
        // 当月の最終日を算出
        int lastDay = ACDateUtilities.getLastDayOfMonth(expansionBeginDay);
        boolean expandsWeekly = true;
        int beginDayVal = 1;
        String beginDayText = getExpansionStartDate().getText();
        if (!ACTextUtilities.isNullText(beginDayText)) {
            // 展開開始日が空欄でない場合(開始日空欄は月初を意味する)
            beginDayVal = ACCastUtilities.toInt(beginDayText, 99);
            if (beginDayVal > lastDay) {
                // 指定の開始日が月末を超える場合は週単位の展開を行わない。
                expandsWeekly = false;
            } else {
                // 展開開始日を入力した日からとする。
                expansionBeginDay = ACDateUtilities.setDayOfMonth(
                        expansionBeginDay, beginDayVal);
            }
        }
        // 施設系サービス利用日
        boolean[] inFacilityTable = new boolean[31];

        VRList paste = new VRArrayList();
        Iterator it;

        // ※週単位以外のサービスを月間に展開する
        it = getFreedayServices().getSchedule().iterator();
        while (it.hasNext()) {
            VRMap service = (VRMap) it.next();
            // Object kindDetail = VRBindPathParser.get(
            // "SYSTEM_SERVICE_KIND_DETAIL", service);
            if (CareServiceCommon.isOtherService(service)) {
                // サービス「その他」は無視
                continue;
            }

            // 貼り付けデータを複製する
            service = (VRMap) service.clone();
            // ユニークキーの削除
            service.remove("SERVICE_ID");

            // サービスの開始日をチェック
            Object obj = VRBindPathParser.get("WEEK_DAY", service);
            if (CareServiceCommon.isWelfareEquipment(service)
                    && QkanConstants.SERVICE_WEEK_DAY_UNKNOWN.equals(obj)) {
                // 福祉用具貸与の指定無しは月初を意味する
                obj = QkanConstants.SERVICE_WEEK_DAY_FIRST_DAY;
            }

            if (QkanConstants.SERVICE_WEEK_DAY_UNKNOWN.equals(obj)) {
                // 開始日が「指定なし」ならば開始日の特定できない月間サービスとする
                VRBindPathParser.set("SERVICE_USE_TYPE", service,
                        QkanConstants.SERVICE_USE_TYPE_PLAN_MONTHLY_FREE_DAY);

                // 展開開始日を設定
                VRBindPathParser
                        .set("SERVICE_DATE", service, expansionBeginDay);
                // 開始日の特定できないサービスを追加
                paste.add(service);
            } else {
                // 開始日を特定可能なサービスの場合

                int serviceBeginDay;
                if (QkanConstants.SERVICE_WEEK_DAY_FIRST_DAY.equals(obj)) {
                    // 「月初」は1日を指す
                    serviceBeginDay = 1;
                } else {
                    int val = ACCastUtilities.toInt(obj);

                    // 1減算して7の剰余+1が曜日
                    int wday = (val - 1) % 7 + 1;
                    // 1減算して7の商+1が週
                    int week = (val - 2) / 7 + 1;

                    // 一時変数を月初とする
                    Date day = ACDateUtilities
                            .toFirstDayOfMonth(expansionBeginDay);
                    if (ACDateUtilities.getDayOfWeek(day) > wday) {
                        // 月初よりも前の曜日であれば週を1加算する
                        week++;
                    }

                    // 末日を超過しているかチェック
                    Date lastDate = ACDateUtilities
                            .toLastDayOfMonth(expansionBeginDay);
                    int lastWDay = ACDateUtilities.getDayOfWeek(lastDate);
                    int lastWeek = ACDateUtilities.getWeekOfMonth(lastDate);
                    if ((lastWeek < week)
                            || ((lastWeek == week) && (lastWDay < wday))) {
                        // 最終週を超過か最終週の最終曜日を超過した場合は無視
                        continue;
                    }

                    // 第week週のwday曜日の日にちを取得
                    serviceBeginDay = ACDateUtilities
                            .getDayOfMonth(ACDateUtilities.setDayOfWeek(
                                    ACDateUtilities.setWeekOfMonth(day, week),
                                    wday));
                }

                if (serviceBeginDay < ACDateUtilities
                        .getDayOfMonth(expansionBeginDay)) {
                    // サービスの開始日が展開開始日より前であれば展開しない
                    continue;
                }

                // サービスの開始日から展開する
                Date beginDay = ACDateUtilities.setDayOfMonth(
                        expansionBeginDay, serviceBeginDay);

                boolean adjustEndDay = false;
                int endDay = serviceBeginDay
                        + ACCastUtilities.toInt(VRBindPathParser.get(
                                QkanConstants.SERVICE_SYSTEM_BIND_PATH_SPAN,
                                service), 0) - 1;
                if (endDay > lastDay) {
                    // 展開開始日+展開日数が末日を超えた場合は末日までにする
                    endDay = lastDay;
                    adjustEndDay = true;
                }

                // サービス用途は予定月間表とする
                VRBindPathParser.set("SERVICE_USE_TYPE", service,
                        QkanConstants.SERVICE_USE_TYPE_PLAN_MONTHLY_DAY);
                // 展開開始日を設定
                VRBindPathParser.set("SERVICE_DATE", service, beginDay);
                // 展開開始日のサービスを追加
                paste.add(service);

                final String SENDING_BIND_PATH = "6";
                // int kindDetailVal = ACCastUtilities.toInt(kindDetail, 0);
                if (CareServiceCommon.isShortStay(service)
                        && VRBindPathParser.has(SENDING_BIND_PATH, service)) {
                    // ※短期入所系の場合
                    final Integer SENDING_ROUND_NONE = new Integer(1);
                    final Integer SENDING_ROUND_ONE_WAY = new Integer(2);
                    final Integer SENDING_ROUND_TRIP = new Integer(3);

                    Object spanSending;
                    Object lastSending;
                    Object sending = VRBindPathParser.get(SENDING_BIND_PATH,
                            service);
                    if (SENDING_ROUND_TRIP.equals(sending)) {
                        // サービスに「送迎加算・往復」が設定されている場合
                        // 初日は「送迎加算・片道」にする。
                        // 中日は「送迎加算・なし」にする。
                        // 末日は「送迎加算・片道」にする。

                        // ※初日は「送迎加算・片道」にする。
                        VRBindPathParser.set(SENDING_BIND_PATH, service,
                                SENDING_ROUND_ONE_WAY);

                        if (adjustEndDay) {
                            // 展開末日を補正した場合は、最後まで「送迎加算・なし」になる。
                            spanSending = SENDING_ROUND_NONE;
                            lastSending = SENDING_ROUND_NONE;
                        } else {
                            // 展開末日を補正しなかった場合は、最後だけ「送迎加算・片道」になる。
                            spanSending = SENDING_ROUND_NONE;
                            lastSending = SENDING_ROUND_ONE_WAY;
                        }
                    } else if (SENDING_ROUND_ONE_WAY.equals(sending)) {
                        // サービスに「送迎加算・片道」が設定されている場合
                        // 初日は「送迎加算・片道」にする。
                        // 初日以外は「送迎加算・なし」にする。
                        spanSending = SENDING_ROUND_NONE;
                        lastSending = sending;
                    } else {
                        // 送迎加算に変更無し
                        spanSending = sending;
                        lastSending = sending;
                    }

                    // 指定した送迎加算に変更しながら展開終了日までのサービスを生成する
                    for (int i = serviceBeginDay + 1; i <= endDay; i++) {
                        service = (VRMap) service.clone();
                        VRBindPathParser.set("SERVICE_DATE", service,
                                ACDateUtilities.setDayOfMonth(beginDay, i));
                        // ※中日の送迎加算を設定
                        VRBindPathParser.set(SENDING_BIND_PATH, service,
                                spanSending);
                        paste.add(service);
                    }

                    // ※展開末日の送迎加算を設定
                    VRBindPathParser.set(SENDING_BIND_PATH, service,
                            lastSending);
                } else {
                    // ※短期入所系以外の場合

                    // 展開開始日の翌日から展開終了日までのサービスを生成する
                    for (int i = serviceBeginDay + 1; i <= endDay; i++) {
                        service = (VRMap) service.clone();
                        VRBindPathParser.set("SERVICE_DATE", service,
                                ACDateUtilities.setDayOfMonth(beginDay, i));
                        paste.add(service);
                    }
                }

                if (CareServiceCommon.isFacility(service)
                        || CareServiceCommon.isLifeCare(service)
                        || CareServiceCommon.isShortStay(service)) {
                    // ※週単位・週単位以外の両方に設定されている場合、展開しないサービス
                    // サービス種類コードが下記のものは、「週単位」と「週単位以外」で重複した場合、「週単位以外」のみを展開する。
                    // 21, 22, 23, 32, 33, 51, 52, 53
                    // （訪問看護,訪問リハ,通所リハ,訪問介護,訪問入浴介護,通所介護=コードが1で始まるサービスで福祉用具貸与以外は削除する）
                    for (int i = serviceBeginDay; i <= endDay; i++) {
                        inFacilityTable[i - 1] = true;
                    }
                }
            }
        }

        if (expandsWeekly) {
            // ※週単位のサービスを月間に展開する

            // 展開開始日の曜日を算出
            int expansionBeginWDay = ACDateUtilities
                    .getDayOfWeek(expansionBeginDay);

            // 展開開始日から1週間分の日付を生成
            // 月初の曜日を縦罫、求める曜日を横罫とした日にち変換テーブル
            final int[][] beginDayTable = { { 0, 1, 2, 3, 4, 5, 6 },
                    { 6, 0, 1, 2, 3, 4, 5 }, { 5, 6, 0, 1, 2, 3, 4 },
                    { 4, 5, 6, 0, 1, 2, 3 }, { 3, 4, 5, 6, 0, 1, 2 },
                    { 2, 3, 4, 5, 6, 0, 1 }, { 1, 2, 3, 4, 5, 6, 0 } };
            Date[] expansionBeginDays = new Date[7];
            for (int i = 0; i < 7; i++) {
                int shiftDays = beginDayTable[expansionBeginWDay - 1][i];
                if (beginDayVal + shiftDays > lastDay) {
                    expansionBeginDays[i] = null;
                } else {
                    expansionBeginDays[i] = ACDateUtilities.addDay(
                            expansionBeginDay, shiftDays);
                }
            }

            // 週単位のサービスを展開する場合
            // 週間表のサービスを全走査
            it = getWeeklySchedule().getSchedule().iterator();
            while (it.hasNext()) {
                VRMap service = (VRMap) it.next();
                if (CareServiceCommon.isOtherService(service)
                        || CareServiceCommon.isDailyAction(service)) {
                    // サービス「その他」「主な日常生活上の活動」は無視
                    continue;
                }
                // サービスの曜日をチェック
                int wday;
                Object obj = VRBindPathParser.get("WEEK_DAY", service);
                if (QkanConstants.SERVICE_WEEK_DAY_SUNDAY_AM.equals(obj)
                        || QkanConstants.SERVICE_WEEK_DAY_SUNDAY_PM.equals(obj)) {
                    wday = Calendar.SUNDAY;
                } else if (QkanConstants.SERVICE_WEEK_DAY_MONDAY_AM.equals(obj)
                        || QkanConstants.SERVICE_WEEK_DAY_MONDAY_PM.equals(obj)) {
                    wday = Calendar.MONDAY;
                } else if (QkanConstants.SERVICE_WEEK_DAY_TUESDAY_AM
                        .equals(obj)
                        || QkanConstants.SERVICE_WEEK_DAY_TUESDAY_PM
                                .equals(obj)) {
                    wday = Calendar.TUESDAY;
                } else if (QkanConstants.SERVICE_WEEK_DAY_WEDNESDAY_AM
                        .equals(obj)
                        || QkanConstants.SERVICE_WEEK_DAY_WEDNESDAY_PM
                                .equals(obj)) {
                    wday = Calendar.WEDNESDAY;
                } else if (QkanConstants.SERVICE_WEEK_DAY_THURSDAY_AM
                        .equals(obj)
                        || QkanConstants.SERVICE_WEEK_DAY_THURSDAY_PM
                                .equals(obj)) {
                    wday = Calendar.THURSDAY;
                } else if (QkanConstants.SERVICE_WEEK_DAY_FRIDAY_AM.equals(obj)
                        || QkanConstants.SERVICE_WEEK_DAY_FRIDAY_PM.equals(obj)) {
                    wday = Calendar.FRIDAY;
                } else if (QkanConstants.SERVICE_WEEK_DAY_SATURDAY_AM
                        .equals(obj)
                        || QkanConstants.SERVICE_WEEK_DAY_SATURDAY_PM
                                .equals(obj)) {
                    wday = Calendar.SATURDAY;
                } else {
                    // 曜日以外(日常生活)は無視
                    continue;
                }
                // サービスの曜日から展開開始日を算出
                Date beginDay = expansionBeginDays[wday - 1];
                if (beginDay == null) {
                    // 月末を超過したサービスは展開しない
                    continue;
                }

                boolean removeService = CareServiceCommon.isHomeVisit(service)
                        || CareServiceCommon.isFacilityVisit(service);

                // 貼り付けデータを複製する
                service = (VRMap) service.clone();
                // ユニークキーの削除
                service.remove("SERVICE_ID");
                // サービス用途は予定月間表とする
                VRBindPathParser.set("SERVICE_USE_TYPE", service,
                        QkanConstants.SERVICE_USE_TYPE_PLAN_MONTHLY_DAY);

                int beginDayOfMonth = ACDateUtilities.getDayOfMonth(beginDay);
                if ((!inFacilityTable[beginDayOfMonth - 1]) || (!removeService)) {
                    // 週単位以外において施設関係サービスを受けていない日か除外対象のサービスではない場合
                    VRBindPathParser.set("SERVICE_DATE", service, beginDay);
                    // 展開開始日のサービスを追加
                    paste.add(service);
                }
                // 展開開始日の翌週から末日までのサービスを生成する
                for (int i = beginDayOfMonth + 7; i <= lastDay; i += 7) {
                    if ((!inFacilityTable[i - 1]) || (!removeService)) {
                        // 週単位以外において施設関係サービスを受けていない日か除外対象のサービスではない場合
                        service = (VRMap) service.clone();
                        VRBindPathParser.set("SERVICE_DATE", service,
                                ACDateUtilities.setDayOfMonth(beginDay, i));
                        paste.add(service);
                    }
                }
            }
        }

        // サービスの回数制限チェック
        convertServiceData(paste);

        // 展開開始日以降の予定を削除
        getOwnerAffair().getMonthlyPanel().clearSchedule(expansionBeginDay);
        // 展開
        getOwnerAffair().getMonthlyPanel().addSchedule(paste);

        getOwnerAffair().getMonthlyPanel().recalcServiceTotal();
        getOwnerAffair().showMonthly();
        getOwnerAffair().clearServiceSelection();

        getOwnerAffair().setServiceModify(true);
    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        ACFrame.debugStart(new ACAffairInfo(QS001001.class.getName()));
    }

    // 内部関数

    /**
     * 「日常チェックボックスのEnabled設定」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void setDailylifeCheckEnabled(boolean enabled) throws Exception {
        // ■「3.時刻・曜日の選択」「日常」チェックボックスの状態を設定する。
        // 引数enabledの値をチェックする。
        if (enabled) {
            // trueの場合
            // 「月」～「日」のチェックボックスを非表示に、「週単位以外のサービス」以下を無効にする。
            setState_EXT_CONTENT_DETAIL_SELECTED();
        } else {
            // falseの場合
            // 「月」～「日」のチェックボックスを表示し、「週単位以外のサービス」以下を有効にする。
            setState_EXT_CONTENT_DETAIL_UNSELECTED();
        }
    }

    /**
     * 「作成年月日の取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public Date getCreateDateValue() throws Exception {
        // ■作成年月日の取得
        // 画面の「作成年月日(createDate)」の値を返す。
        return getCreateDate().getDate();
    }

    /**
     * 「対象年月を設定」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void setTargetDate(Date targetDate) throws Exception {
        // ■月間表の対象年月を設定
        // 月間表の対象年月を設定する。
        getWeeklySchedule().setTargetDate(targetDate);
    }

    /**
     * 「サービス描画用のセルレンダラ設定」に関する処理を行ないます。
     * 
     * @param renderer ListCellRenderer
     * @throws Exception 処理例外
     */
    public void setCellRenderer(ListCellRenderer renderer) throws Exception {
        getWeeklySchedule().setCellRenderer(renderer);
        getFreedayServices().setCellRenderer(renderer);

        if (renderer instanceof QS001ServicePatternListCellRenderer) {
            ((QS001ServicePatternListCellRenderer) renderer)
                    .setUseBeginList(getFreedayServices());
        }
    }

    /**
     * サービスマスタ を設定します。
     * 
     * @param serviceMaster サービスマスタ
     */
    public void setMasterService(VRMap serviceMaster) {
        getWeeklySchedule().setMasterService(serviceMaster);
        getFreedayServices().setMasterService(serviceMaster);
    }

    /**
     * 「スケジュール全体を設定」に関する処理を行ないます。
     * 
     * @param schedules VRList
     * @throws Exception 処理例外
     */
    public void setSchedule(VRList schedules) throws Exception {
        getWeeklySchedule().setSchedule(schedules);
        setFreedaySchedule(schedules);
        getOwnerAffair().setServiceModify(true);
    }

    /**
     * 「スケジュール全体を取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     * @return VRList
     */
    public VRList getSchedule() throws Exception {
        VRList list = getWeeklySchedule().getSchedule();
        list.addAll(getAllFreedaySchedule());
        return list;
    }

    /**
     * 「リスト選択イベントリスナを追加」に関する処理を行ないます。
     * 
     * @param listener ListSelectionListener
     * @throws Exception 処理例外
     */
    public void addListSelectionListener(ListSelectionListener listener) {
        getWeeklySchedule().addListSelectionListener(listener);
        getFreedayServices().addListSelectionListener(listener);
    }

    /**
     * 「リスト選択イベントリスナを追加」に関する処理を行ないます。
     * 
     * @param listener KeyListener
     * @throws Exception 処理例外
     */
    public void addKeyListener(KeyListener listener) {
        getWeeklySchedule().addKeyListener(listener);
        getFreedayServices().addKeyListener(listener);
    }

    /**
     * スケジュールデータ件数を返します。
     * 
     * @return スケジュールデータ件数
     */
    public int getScheduleCount() throws Exception {
        return getWeeklySchedule().getScheduleCount()
                + getFreedayServices().getScheduleCount();
    }

    /**
     * 「スケジュールを初期化」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void clearSchedule() throws Exception {
        getWeeklySchedule().clearSchedule();
        getFreedayServices().clearSchedule();
        getOwnerAffair().setServiceModify(true);
    }

    /**
     * 「画面初期化」に関する処理を行ないます。
     * 
     * @param ownerAffair QS001
     * @throws Exception 処理例外
     */
    public void initialize(QS001 ownerAffair) throws Exception {
        // ※画面展開時の初期設定
        // ownerAffairを定義変数に退避する。
        setOwnerAffair(ownerAffair);
        // ※コンボアイテムの設定
        // ※準備
        // コンボアイテム設定用のレコード comboItemMap を生成する。
        VRMap comboItemMap = new VRHashMap();

        // ※開始時刻
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        // 取得した値を、comboItemMapの KEY : 3 の VALUE として設定する。
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
        // ※終了時刻
        // コードマスタデータよりCODE_ID：23（時刻・曜日の選択 / 時刻(開始)）を取得する。
        // 取得した値を、comboItemMapの KEY : 4 の VALUE として設定する。
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
        // ※週
        // コードマスタデータよりCODE_ID：24（週）を取得する。
        // 取得した値を、comboItemMapの KEY : 24 の VALUE として設定する。
        comboItemMap.setData("24", QkanCommon.getArrayFromMasterCode(24, "24"));
        // ※日数
        // コードマスタデータよりCODE_ID：25（日数）を取得する。
        // 取得した値を、comboItemMapの KEY : 25 の VALUE として設定する。
        comboItemMap.setData("25", QkanCommon.getArrayFromMasterCode(25, "25"));
        // ※コンボアイテムの設定
        // 「自身(this)」にcomboItemMapに設定する。
        getThis().setModelSource(comboItemMap);
        // コンボアイテムを展開する。
        getThis().bindModelSource();

        // ※選択項目の初期設定
        // 開始コンボ(exceptionBeginCombo)の「指定なし」を選択する。
        getExceptionBeginCombo().setSelectedIndex(0);

        getWeeklySchedule().addDroppableListener(getOwnerAffair());
    }

    /**
     * 「サービスから開始日コンボと期間コンボを設定」に関する処理を行ないます。
     * 
     * @param service VRMap
     * @throws Exception 処理例外
     */
    public void setServiceSpan(VRMap service) throws Exception {
        Object useType = VRBindPathParser.get("SERVICE_USE_TYPE", service);
        if (QkanConstants.SERVICE_USE_TYPE_PLAN_WEEKLY_FREE_DAY.equals(useType)
                || QkanConstants.SERVICE_USE_TYPE_RESULT_WEEKLY_FREE_DAY
                        .equals(useType)) {
            // 週単位以外のサービスの場合
            // 開始日コンボを「WEEK_DAY」の値にする。
            VRMap map = new VRHashMap();
            map.setData(getExceptionBeginCombo().getBindPath(),
                    VRBindPathParser.get("WEEK_DAY", service));
            if (CareServiceCommon.isWelfareEquipment(service)) {
                // 福祉用具貸与の場合
                // 期間コンボを「1日」とし、操作不可とする。
                getExceptionEndCombo().setSelectedIndex(1);
                setState_WELFARE_EQUIPMENT_SELECTED();
            } else {
                // 福祉用具貸与以外の場合
                // サービスの持つ期間の値を展開し、期間コンボを操作可能とする。
                map.setData(getExceptionEndCombo().getBindPath(),
                        VRBindPathParser.get(
                                QkanConstants.SERVICE_SYSTEM_BIND_PATH_SPAN,
                                service));
                setState_WELFARE_EQUIPMENT_UNSELECTED();
            }
            getExceptionServiceCombos().setSource(map);
            getExceptionServiceCombos().bindSource();

        } else {
            // 週単位のサービスの場合
            // 開始日コンボを「指定なし」にする。
            getExceptionBeginCombo().setSelectedIndex(0);
            if (CareServiceCommon.isWelfareEquipment(service)) {
                // 福祉用具貸与の場合
                // 期間コンボを「1日」とし、操作不可とする。
                getExceptionEndCombo().setSelectedIndex(1);
                setState_WELFARE_EQUIPMENT_SELECTED();
            } else {
                // 福祉用具貸与以外の場合
                // 期間コンボを「末迄」にする。
                getExceptionEndCombo().setSelectedIndex(
                        getExceptionEndCombo().getItemCount() - 1);
                setState_WELFARE_EQUIPMENT_UNSELECTED();
            }
        }

        // サービスの時間帯を設定する。
        VRMap time = new VRHashMap();
        VRBindPathParser.set("3", time, VRBindPathParser.get("3", service));
        VRBindPathParser.set("4", time, VRBindPathParser.get("4", service));
        getTimeContentLabelWeeksLeft().setSource(time);
        getTimeContentLabelWeeksLeft().bindSource();

        getSundayCheck().setSelected(false);
        getMondayCheck().setSelected(false);
        getTuesdayCheck().setSelected(false);
        getWednesdayCheck().setSelected(false);
        getThursdayCheck().setSelected(false);
        getFridayCheck().setSelected(false);
        getSaturdayCheck().setSelected(false);
    }

    /**
     * 「週単位以外のサービスを設定」に関する処理を行ないます。
     * 
     * @param schedules VRList
     * @throws Exception 処理例外
     */
    public void setFreedaySchedule(VRList schedules) throws Exception {
        // ■週単位以外のサービスを設定

        // 週単位以外のサービスを初期化する。
        getFreedayServices().clearSchedule();
        Iterator it = schedules.iterator();
        while (it.hasNext()) {
            // スケジュール集合をすべて走査する。
            VRMap row = (VRMap) it.next();

            Object type = VRBindPathParser.get("SERVICE_USE_TYPE", row);
            if (QkanConstants.SERVICE_USE_TYPE_PLAN_WEEKLY_FREE_DAY
                    .equals(type)
                    || QkanConstants.SERVICE_USE_TYPE_RESULT_WEEKLY_FREE_DAY
                            .equals(type)) {
                // スケジュールのSERVICE_USE_TYPEが「週間表の週単位以外」の場合
                // 週単位以外のサービスとしてスケジュールを追加する。
                getFreedayServices().addSchedule(row);
            }
        }
    }

    /**
     * 「週単位以外のサービスを取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     * @return VRList
     */
    public VRList getAllFreedaySchedule() throws Exception {
        VRList list = getFreedayServices().getSchedule();
        if (list != null) {
            Integer useType = null;
            if (getOwnerAffair().getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
                useType = QkanConstants.SERVICE_USE_TYPE_PLAN_WEEKLY_FREE_DAY;
            } else if (getOwnerAffair().getProcessType() == QkanConstants.PROCESS_TYPE_RESULT) {
                useType = QkanConstants.SERVICE_USE_TYPE_RESULT_WEEKLY_FREE_DAY;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                // サービス提供日とUSE_TYPEを設定
                VRMap row = (VRMap) it.next();
                VRBindPathParser.set("SERVICE_DATE", row, getWeeklySchedule()
                        .getTargetDate());
                VRBindPathParser.set("SERVICE_USE_TYPE", row, useType);
            }
        }
        return list;
    }

    /**
     * 「週単位のサービスを取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     * @return VRList
     */
    public VRList getAllWeeklySchedule() throws Exception {
        return getWeeklySchedule().getSchedule();
    }

    protected void setOwnerAffair(QS001 ownerAffair) {
        super.setOwnerAffair(ownerAffair);
        getWeeklySchedule().setOwnerAffair(ownerAffair);
    }

    /**
     * 「週間表のリストであるか」に関する処理を行ないます。
     * 
     * @param list QS001DaySchedule
     * @throws Exception 処理例外
     * @return boolean
     */
    public boolean isWeeklyServiceList(QS001DaySchedule list) throws Exception {
        return getWeeklySchedule().isWeeklyServiceList(list)
                || (getFreedayServices() == list);
    }

    /**
     * 「主な日常生活上の活動を表すリストであるか」に関する処理を行ないます。
     * 
     * @param list QS001DaySchedule
     * @throws Exception 処理例外
     * @return boolean
     */
    public boolean isDailyServiceList(QS001DaySchedule list) throws Exception {
        return getWeeklySchedule().isDailyServiceList(list);
    }

    /**
     * 「サービスの制限回数チェック」に関する処理を行ないます
     * 
     * @param paste 展開しようとしているサービスのリスト
     * @throws Exception 処理例外
     */
    public void convertServiceData(VRList paste) throws Exception {
        final Integer OFF = new Integer(1);
        final Integer ON = new Integer(2);
        // [ID:0000559][Masahiko Higuchi] 2009/10 replace begin 自動展開時の制限処理
        String[] times2 = null;
        int lowVersion = 0;
        // 空ではない場合
        if (paste != null && !paste.isEmpty()) {
            for (int j = 0; j < paste.size(); j++) {
                VRMap check = (VRMap) paste.get(j);
                // 念のためループしてチェックする
                lowVersion = CareServiceCommon.getServiceLowVersion(check);
                if (lowVersion != 0) {
                    break;
                }
            }
        }

        // 平成21年4月法改正対応
        // 通所介護、通所リハビリ、認知症対応型通所介護の栄養改善加算、口腔機能向上加算を制限[月に2回]
        times2 = new String[] { "1150112", "1150116", "1160114", "1160115",
                "1720105", "1720108" };

        // [ID:0000559][Masahiko Higuchi] 2009/10 replace end 自動展開時の制限処理
        Collections.sort(paste, new ServiceDateComparator()); // DataComparatorで順序

        VRMap timesCheck = new VRHashMap();

        for (int i = 0; i < paste.size(); i++) {
            VRMap service = (VRMap) paste.get(i);

            for (int j = 0; j < times2.length; j++) {
                if (service.containsKey(times2[j])) {
                    if (ACCastUtilities.toInt(service.get(times2[j]), 0) == ON
                            .intValue()) {
                        int onTimes = 0;
                        String key = times2[j]
                                + "-"
                                + ACCastUtilities.toString(
                                        service.get("PROVIDER_ID"), "");
                        if (timesCheck.containsKey(key)) {
                            onTimes = ACCastUtilities.toInt(
                                    timesCheck.get(key), 0);
                        }
                        onTimes++;
                        if (onTimes > 2) {
                            service.put(times2[j], OFF);
                        }
                        timesCheck.put(key, new Integer(onTimes));
                    }
                }
            }
        }
    }

    /**
     * サービス提供日順にサービスを並び替える
     */
    class ServiceDateComparator implements java.util.Comparator {
        public int compare(Object o1, Object o2) {
            Date date1 = ACCastUtilities.toDate(
                    ((VRMap) o1).get("SERVICE_DATE"), null);
            Date date2 = ACCastUtilities.toDate(
                    ((VRMap) o2).get("SERVICE_DATE"), null);

            if (date1 == null || date2 == null) {
                return 0;
            }
            return ACDateUtilities.getDifferenceOnDay(date1, date2);
        }
    }
}
