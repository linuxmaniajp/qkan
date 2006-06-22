package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionListener;

import jp.nichicom.ac.component.dnd.event.ACDroppableListener;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.container.VRPanel;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

/**
 * 週間スケジュールです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/01/12
 */
public class QS001WeekSchedule extends VRPanel {
    private JPanel weekHeaderContainer = new JPanel();
    private JLabel weekHeader = new JLabel();
    private JLabel anteMeridiem1 = new JLabel();
    private JLabel anteMeridiem2 = new JLabel();
    private JLabel postMeridiem1 = new JLabel();
    private JLabel postMeridiem2 = new JLabel();
    private QS001DaySchedule day1AM = new QS001DaySchedule();
    private QS001DaySchedule day2AM = new QS001DaySchedule();
    private QS001DaySchedule day3AM = new QS001DaySchedule();
    private QS001DaySchedule day4AM = new QS001DaySchedule();
    private QS001DaySchedule day5AM = new QS001DaySchedule();
    private QS001DaySchedule day6AM = new QS001DaySchedule();
    private QS001DaySchedule day7AM = new QS001DaySchedule();
    private QS001DaySchedule dayFreeAM = new QS001DaySchedule();
    private QS001DaySchedule day1PM = new QS001DaySchedule();
    private QS001DaySchedule day2PM = new QS001DaySchedule();
    private QS001DaySchedule day3PM = new QS001DaySchedule();
    private QS001DaySchedule day4PM = new QS001DaySchedule();
    private QS001DaySchedule day5PM = new QS001DaySchedule();
    private QS001DaySchedule day6PM = new QS001DaySchedule();
    private QS001DaySchedule day7PM = new QS001DaySchedule();
    private QS001DaySchedule dayFreePM = new QS001DaySchedule();
    private JPanel anteMeridiemContainer = new JPanel();
    private JPanel postMeridiemContainer = new JPanel();
    private Date targetDate;

    /**
     * 対象年 を返します。
     * 
     * @return 対象年
     */
    public Date getTargetDate() {
        return targetDate;
    }

    /**
     * 対象年 を設定します。
     * 
     * @param targetDate 対象年
     */
    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    /**
     * コンストラクタです。
     */
    public QS001WeekSchedule() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * コンポーネントを設定します。
     * 
     * @throws Exception 処理例外
     */
    private void jbInit() throws Exception {
        this.setLayout(new GridBagLayout());
        weekHeaderContainer.setLayout(new BorderLayout());
        postMeridiemContainer.setLayout(new GridBagLayout());
        anteMeridiemContainer.setLayout(new GridBagLayout());

        weekHeader.setText("　");
        anteMeridiemContainer.setBorder(BorderFactory.createBevelBorder(
                BevelBorder.LOWERED, Color.white, Color.white, new Color(115,
                        114, 105), new Color(165, 163, 151)));
        postMeridiemContainer.setBorder(BorderFactory.createBevelBorder(
                BevelBorder.LOWERED, Color.white, Color.white, new Color(115,
                        114, 105), new Color(165, 163, 151)));
        anteMeridiem1.setHorizontalAlignment(SwingConstants.CENTER);
        anteMeridiem1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        anteMeridiem2.setHorizontalAlignment(SwingConstants.CENTER);
        anteMeridiem2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        postMeridiem1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        postMeridiem2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        weekHeaderContainer.add(weekHeader, BorderLayout.NORTH);
        weekHeaderContainer.add(anteMeridiemContainer, BorderLayout.CENTER);

        anteMeridiemContainer.add(anteMeridiem1, new GridBagConstraints(0, 0,
                1, 1, 10.0, 10.0, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        anteMeridiemContainer.add(anteMeridiem2, new GridBagConstraints(0, 1,
                1, 1, 10.0, 10.0, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        postMeridiemContainer.add(postMeridiem1, new GridBagConstraints(0, 0,
                1, 1, 10.0, 10.0, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        postMeridiemContainer.add(postMeridiem2, new GridBagConstraints(0, 1,
                1, 1, 10.0, 10.0, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        anteMeridiem1.setText("午");
        anteMeridiem2.setText("前");
        postMeridiem1.setText("午");
        postMeridiem2.setText("後");

        day1AM.setHeaderHorizontalAlignment(SwingConstants.CENTER);
        day2AM.setHeaderHorizontalAlignment(SwingConstants.CENTER);
        day3AM.setHeaderHorizontalAlignment(SwingConstants.CENTER);
        day4AM.setHeaderHorizontalAlignment(SwingConstants.CENTER);
        day5AM.setHeaderHorizontalAlignment(SwingConstants.CENTER);
        day6AM.setHeaderHorizontalAlignment(SwingConstants.CENTER);
        day7AM.setHeaderHorizontalAlignment(SwingConstants.CENTER);
        dayFreeAM.setHeaderHorizontalAlignment(SwingConstants.CENTER);
        day1AM.setHeader("月");
        day1PM.setHeaderVisible(false);
        day2PM.setHeaderVisible(false);
        day3PM.setHeaderVisible(false);
        day4PM.setHeaderVisible(false);
        day5PM.setHeaderVisible(false);
        day6PM.setHeaderVisible(false);
        day7PM.setHeaderVisible(false);
        dayFreePM.setHeaderVisible(false);
        day2AM.setHeader("火");
        day3AM.setHeader("水");
        day4AM.setHeader("木");
        day5AM.setHeader("金");
        day6AM.setHeader("土");
        day7AM.setHeader("日");
        day7AM.setSchedulesBackground(new Color(255, 214, 208));
        day7PM.setSchedulesBackground(new Color(255, 214, 208));
        day6AM.setSchedulesBackground(new Color(208, 233, 255));
        day6PM.setSchedulesBackground(new Color(208, 233, 255));
        dayFreeAM.setHeader(" 日常");

        this.add(weekHeaderContainer, new GridBagConstraints(0, 0, 1, 1, 0.0,
                0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        this.add(day1AM, new GridBagConstraints(1, 0, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day2AM, new GridBagConstraints(2, 0, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day3AM, new GridBagConstraints(3, 0, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day4AM, new GridBagConstraints(4, 0, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day5AM, new GridBagConstraints(5, 0, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day6AM, new GridBagConstraints(6, 0, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day7AM, new GridBagConstraints(7, 0, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(dayFreeAM, new GridBagConstraints(8, 0, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(postMeridiemContainer, new GridBagConstraints(0, 1, 1, 1, 0.0,
                0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        this.add(day1PM, new GridBagConstraints(1, 1, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day2PM, new GridBagConstraints(2, 1, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day3PM, new GridBagConstraints(3, 1, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day4PM, new GridBagConstraints(4, 1, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day5PM, new GridBagConstraints(5, 1, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day6PM, new GridBagConstraints(6, 1, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day7PM, new GridBagConstraints(7, 1, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(dayFreePM, new GridBagConstraints(8, 1, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
    }

    /**
     * サービスを描画するセルレンダラを返します。
     * 
     * @return セルレンダラ
     */
    public ListCellRenderer getCellRenderer() {
        return day1AM.getCellRenderer();
    }

    /**
     * サービスを描画するセルレンダラを設定します。
     * 
     * @param renderer セルレンダラ
     */
    public void setCellRenderer(ListCellRenderer renderer) {
        // レンダラを共有することでフォーカス描画も共有する
        QS001DaySchedule[] days = getSchedules();
        for (int i = 0; i < days.length; i++) {
            days[i].setCellRenderer(renderer);
            days[i]
                    .setDropAllowedServiceBitMask(QkanConstants.CALENADR_DROP_WEEKLY);
        }
        dayFreeAM
                .setDropAllowedServiceBitMask(QkanConstants.CALENADR_DROP_DAILY_LIFE);
        dayFreePM
                .setDropAllowedServiceBitMask(QkanConstants.CALENADR_DROP_DAILY_LIFE);
    }

    /**
     * サービスマスタ を設定します。
     * 
     * @param serviceMaster サービスマスタ
     */
    public void setMasterService(VRMap serviceMaster) {
        QS001DaySchedule[] days = getSchedules();
        for (int i = 0; i < days.length; i++) {
            days[i].setMasterService(serviceMaster);
        }
    }

    /**
     * ドロップイベントリスナを追加します。
     * 
     * @param l ドロップイベントリスナ
     */
    public void addDroppableListener(ACDroppableListener l) {
        QS001DaySchedule[] days = getSchedules();
        for (int i = 0; i < days.length; i++) {
            days[i].addDroppableListener(l);
        }
    }    
    /**
     * スケジュール画面項目一覧を返します。
     * 
     * @return スケジュール画面項目一覧
     */
    protected QS001DaySchedule[] getSchedules() {
        return new QS001DaySchedule[] { day1AM, day2AM, day3AM, day4AM, day5AM,
                day6AM, day7AM, dayFreeAM, day1PM, day2PM, day3PM, day4PM,
                day5PM, day6PM, day7PM, dayFreePM, };
    }

    /**
     * 週間表のリストであるかを返します。
     * @param list 比較リスト
     * @return 週間表のリストであるか
     */
    public boolean isWeeklyServiceList(QS001DaySchedule list){
        QS001DaySchedule[] days = getSchedules();
        for (int i = 0; i < days.length; i++) {
            if(list==days[i]){
                return true;
            }
        }
        return false;
    }

    /**
     * 主な日常生活上の活動を表すリストであるかを返します。
     * @param list 比較リスト
     * @return 主な日常生活上の活動を表すリストであるか
     */
    public boolean isDailyServiceList(QS001DaySchedule list){
        return (list==dayFreeAM)||(list==dayFreePM);
    }

    /**
     * 週間位置フラグ一覧を返します。
     * 
     * @return 週間位置フラグ一覧
     */
    protected Integer[] getWeekdays() {
        return new Integer[] { 
                QkanConstants.SERVICE_WEEK_DAY_MONDAY_AM,
                QkanConstants.SERVICE_WEEK_DAY_TUESDAY_AM,
                QkanConstants.SERVICE_WEEK_DAY_WEDNESDAY_AM,
                QkanConstants.SERVICE_WEEK_DAY_THURSDAY_AM,
                QkanConstants.SERVICE_WEEK_DAY_FRIDAY_AM,
                QkanConstants.SERVICE_WEEK_DAY_SATURDAY_AM,
                QkanConstants.SERVICE_WEEK_DAY_SUNDAY_AM,
                QkanConstants.SERVICE_WEEK_DAY_FREE_AM,
                QkanConstants.SERVICE_WEEK_DAY_MONDAY_PM,
                QkanConstants.SERVICE_WEEK_DAY_TUESDAY_PM,
                QkanConstants.SERVICE_WEEK_DAY_WEDNESDAY_PM,
                QkanConstants.SERVICE_WEEK_DAY_THURSDAY_PM,
                QkanConstants.SERVICE_WEEK_DAY_FRIDAY_PM,
                QkanConstants.SERVICE_WEEK_DAY_SATURDAY_PM,
                QkanConstants.SERVICE_WEEK_DAY_SUNDAY_PM,
                QkanConstants.SERVICE_WEEK_DAY_FREE_PM, 
                };
    }
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
    private QS001 ownerAffair; 

    /**
     * スケジュールデータを返します。
     * 
     * @return スケジュールデータ
     */
    public VRList getSchedule() throws Exception {
        QS001DaySchedule[] days = getSchedules();
        Integer[] weekdays = getWeekdays();

        Integer useType=null;
        if(getOwnerAffair().getProcessType()==QkanConstants.PROCESS_TYPE_PLAN){
            useType = QkanConstants.SERVICE_USE_TYPE_PLAN_WEEKLY_DAY;
        }else if(getOwnerAffair().getProcessType()==QkanConstants.PROCESS_TYPE_RESULT){
            useType = QkanConstants.SERVICE_USE_TYPE_RESULT_WEEKLY_DAY;
        }

        VRList result = new VRArrayList();
        int end = days.length;
        for (int i = 0; i < end; i++) {
            if (days[i].isVisible()) {
                VRList list = days[i].getSchedule();
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        // サービス提供日とUSE_TYPEを設定
                        try {
                            VRMap row = (VRMap) it.next();
                            VRBindPathParser.set("SERVICE_DATE", row,
                                    getTargetDate());
                            VRBindPathParser.set("WEEK_DAY", row, weekdays[i]);
                            VRBindPathParser.set("SERVICE_USE_TYPE", row,
                                    useType);
                        } catch (java.util.ConcurrentModificationException ex) {
                            //イテレーションの同期例外は無視
                        }
                    }
                    result.addAll(list);
                }
            }
        }

        return result;
    }

    /**
     * リスト選択イベントリスナを追加します。
     * 
     * @param listener リスト選択イベントリスナ
     */
    public void addListSelectionListener(ListSelectionListener listener) {
        QS001DaySchedule[] days = getSchedules();
        for (int i = 0; i < days.length; i++) {
            days[i].addListSelectionListener(listener);
        }
    }

    /**
     * キー入力イベントリスナを追加します。
     * 
     * @param listener キー入力イベントリスナ
     */
    public void addKeyListener(KeyListener listener) {
        QS001DaySchedule[] days = getSchedules();
        for (int i = 0; i < days.length; i++) {
            days[i].addKeyListener(listener);
        }
    }

    /**
     * スケジュールデータを設定します。
     * 
     * @param schedules スケジュールデータ
     * @throws Exception 処理例外
     */
    public void setSchedule(VRList schedules) throws Exception {
        // いったん初期化
        clearSchedule();

        addSchedule(schedules);
    }
    
    /**
     * スケジュールデータを追加します。
     * @param schedules スケジュールデータ
     * @throws Exception 処理例外
     */
    public void addSchedule(VRList schedules) throws Exception {
        QS001DaySchedule[] days = getSchedules();
        Integer[] weekdays = getWeekdays();
        HashMap map = new HashMap();
        int end = days.length;
        for (int i = 0; i < end; i++) {
            map.put(weekdays[i], days[i]);
        }

        Iterator it = schedules.iterator();
        while (it.hasNext()) {
            VRMap row = (VRMap) it.next();

            Object type = VRBindPathParser.get("SERVICE_USE_TYPE", row);
            if (QkanConstants.SERVICE_USE_TYPE_PLAN_WEEKLY_DAY.equals(type)||
                    QkanConstants.SERVICE_USE_TYPE_RESULT_WEEKLY_DAY.equals(type)) {
                //SERVICE_USE_TYPEが週間表に関するもののみ抽出
                Object schedule = map
                        .get(VRBindPathParser.get("WEEK_DAY", row));
                if (schedule instanceof QS001DaySchedule) {
                    // 週間系データのみ
                    // 日から対応する画面項目を取得し、スケジュールを追加する
                    ((QS001DaySchedule) schedule).addSchedule(row);
                }
            }
        }
    }

    /**
     * スケジュールデータ件数を返します。
     * 
     * @return スケジュールデータ件数
     */
    public int getScheduleCount() {
        QS001DaySchedule[] days = getSchedules();
        int total = 0;
        int end = days.length;
        for (int i = 0; i < end; i++) {
            total += days[i].getScheduleCount();
        }
        return total;
    }

    /**
     * スケジュールデータを初期化します。
     */
    public void clearSchedule() {
        QS001DaySchedule[] days = getSchedules();
        int end = days.length;
        for (int i = 0; i < end; i++) {
            // いったん初期化
            days[i].clearSchedule();
        }
    }
}
