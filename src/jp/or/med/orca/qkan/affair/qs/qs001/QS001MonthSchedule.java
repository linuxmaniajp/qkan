package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionListener;

import jp.nichicom.ac.component.dnd.event.ACDroppableListener;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.container.VRPanel;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

/**
 * 月間表です。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/01/08
 */
public class QS001MonthSchedule extends VRPanel {
    private JLabel weekSaturday = new JLabel();
    private JLabel weekHeader = new JLabel();
    private JLabel weekSunday = new JLabel();
    private JLabel weekMonday = new JLabel();
    private JLabel weekTuesday = new JLabel();
    private JLabel weekWednesday = new JLabel();
    private JLabel weekThursday = new JLabel();
    private JLabel weekFriday = new JLabel();
    private JLabel week1Header = new JLabel();
    private JLabel week2Header = new JLabel();
    private JLabel week3Header = new JLabel();
    private JLabel week4Header = new JLabel();
    private JLabel week5Header = new JLabel();
    private JLabel week6Header = new JLabel();
    private QS001DaySchedule day11 = new QS001DaySchedule();
    private QS001DaySchedule day12 = new QS001DaySchedule();
    private QS001DaySchedule day13 = new QS001DaySchedule();
    private QS001DaySchedule day14 = new QS001DaySchedule();
    private QS001DaySchedule day15 = new QS001DaySchedule();
    private QS001DaySchedule day16 = new QS001DaySchedule();
    private QS001DaySchedule day17 = new QS001DaySchedule();
    private QS001DaySchedule day21 = new QS001DaySchedule();
    private QS001DaySchedule day22 = new QS001DaySchedule();
    private QS001DaySchedule day23 = new QS001DaySchedule();
    private QS001DaySchedule day24 = new QS001DaySchedule();
    private QS001DaySchedule day25 = new QS001DaySchedule();
    private QS001DaySchedule day26 = new QS001DaySchedule();
    private QS001DaySchedule day27 = new QS001DaySchedule();
    private QS001DaySchedule day31 = new QS001DaySchedule();
    private QS001DaySchedule day32 = new QS001DaySchedule();
    private QS001DaySchedule day33 = new QS001DaySchedule();
    private QS001DaySchedule day34 = new QS001DaySchedule();
    private QS001DaySchedule day35 = new QS001DaySchedule();
    private QS001DaySchedule day36 = new QS001DaySchedule();
    private QS001DaySchedule day37 = new QS001DaySchedule();
    private QS001DaySchedule day41 = new QS001DaySchedule();
    private QS001DaySchedule day42 = new QS001DaySchedule();
    private QS001DaySchedule day43 = new QS001DaySchedule();
    private QS001DaySchedule day44 = new QS001DaySchedule();
    private QS001DaySchedule day45 = new QS001DaySchedule();
    private QS001DaySchedule day46 = new QS001DaySchedule();
    private QS001DaySchedule day47 = new QS001DaySchedule();
    private QS001DaySchedule day51 = new QS001DaySchedule();
    private QS001DaySchedule day52 = new QS001DaySchedule();
    private QS001DaySchedule day53 = new QS001DaySchedule();
    private QS001DaySchedule day54 = new QS001DaySchedule();
    private QS001DaySchedule day55 = new QS001DaySchedule();
    private QS001DaySchedule day56 = new QS001DaySchedule();
    private QS001DaySchedule day57 = new QS001DaySchedule();
    private QS001DaySchedule day61 = new QS001DaySchedule();
    private QS001DaySchedule day62 = new QS001DaySchedule();
    private QS001DaySchedule daySpacer = new QS001DaySchedule();
    private QS001DaySchedule dayFreeService = new QS001DaySchedule();
    private Date targetDate;

    /**
     * 対象年月 を返します。
     * 
     * @return 対象年月
     */
    public Date getTargetDate() {
        return targetDate;
    }

    /**
     * 対象年月 を返します。
     * 
     * @param day 対象のリストボックス
     * @return 対象年月
     */
    public Date getTargetDate(QS001DaySchedule day) {
        QS001DaySchedule[] days = getSchedules(true, false);
        int end = days.length;
        for (int i = 0; i < end; i++) {
            if (days[i] == day) {
                return ACDateUtilities.setDayOfMonth(getTargetDate(), i + 1);
            }
        }
        return null;
    }

    /**
     * コンストラクタです。
     */
    public QS001MonthSchedule() {
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

        weekFriday.setBorder(BorderFactory.createBevelBorder(
                BevelBorder.LOWERED, Color.white, Color.white, new Color(115,
                        114, 105), new Color(165, 163, 151)));
        weekFriday.setHorizontalAlignment(SwingConstants.CENTER);
        weekFriday.setText("金");
        weekSaturday.setBorder(BorderFactory.createBevelBorder(
                BevelBorder.LOWERED, Color.white, Color.white, new Color(115,
                        114, 105), new Color(165, 163, 151)));
        weekSaturday.setHorizontalAlignment(SwingConstants.CENTER);
        weekSaturday.setText("土");
        weekThursday.setBorder(BorderFactory.createBevelBorder(
                BevelBorder.LOWERED, Color.white, Color.white, new Color(115,
                        114, 105), new Color(165, 163, 151)));
        weekThursday.setHorizontalAlignment(SwingConstants.CENTER);
        weekThursday.setText("木");
        weekWednesday.setBorder(BorderFactory.createBevelBorder(
                BevelBorder.LOWERED, Color.white, Color.white, new Color(115,
                        114, 105), new Color(165, 163, 151)));
        weekWednesday.setHorizontalAlignment(SwingConstants.CENTER);
        weekWednesday.setText("水");
        weekTuesday.setBorder(BorderFactory.createBevelBorder(
                BevelBorder.LOWERED, Color.white, Color.white, new Color(115,
                        114, 105), new Color(165, 163, 151)));
        weekTuesday.setHorizontalAlignment(SwingConstants.CENTER);
        weekTuesday.setText("火");
        weekMonday.setBorder(BorderFactory.createBevelBorder(
                BevelBorder.LOWERED, Color.white, Color.white, new Color(115,
                        114, 105), new Color(165, 163, 151)));
        weekMonday.setHorizontalAlignment(SwingConstants.CENTER);
        weekMonday.setText("月");
        weekSunday.setBorder(BorderFactory.createBevelBorder(
                BevelBorder.LOWERED, Color.white, Color.white, new Color(115,
                        114, 105), new Color(165, 163, 151)));
        weekSunday.setHorizontalAlignment(SwingConstants.CENTER);
        weekSunday.setText("日");
        weekHeader.setBorder(BorderFactory.createBevelBorder(
                BevelBorder.RAISED, Color.white, Color.white, new Color(115,
                        114, 105), new Color(165, 163, 151)));
        weekHeader.setHorizontalAlignment(SwingConstants.CENTER);
        weekHeader.setText("週");
        week1Header.setText("1");
        week1Header.setHorizontalAlignment(SwingConstants.CENTER);
        week1Header.setBorder(BorderFactory.createBevelBorder(
                BevelBorder.LOWERED, Color.white, Color.white, new Color(115,
                        114, 105), new Color(165, 163, 151)));
        week2Header.setHorizontalAlignment(SwingConstants.CENTER);
        week2Header.setBorder(BorderFactory.createBevelBorder(
                BevelBorder.LOWERED, Color.white, Color.white, new Color(115,
                        114, 105), new Color(165, 163, 151)));
        week2Header.setText("2");
        week3Header.setHorizontalAlignment(SwingConstants.CENTER);
        week3Header.setBorder(BorderFactory.createBevelBorder(
                BevelBorder.LOWERED, Color.white, Color.white, new Color(115,
                        114, 105), new Color(165, 163, 151)));
        week3Header.setText("3");
        week4Header.setHorizontalAlignment(SwingConstants.CENTER);
        week4Header.setBorder(BorderFactory.createBevelBorder(
                BevelBorder.LOWERED, Color.white, Color.white, new Color(115,
                        114, 105), new Color(165, 163, 151)));
        week4Header.setText("4");
        week5Header.setHorizontalAlignment(SwingConstants.CENTER);
        week5Header.setBorder(BorderFactory.createBevelBorder(
                BevelBorder.LOWERED, Color.white, Color.white, new Color(115,
                        114, 105), new Color(165, 163, 151)));
        week5Header.setText("5");
        week6Header.setText("6");
        week6Header.setHorizontalAlignment(SwingConstants.CENTER);
        week6Header.setBorder(BorderFactory.createBevelBorder(
                BevelBorder.LOWERED, Color.white, Color.white, new Color(115,
                        114, 105), new Color(165, 163, 151)));
        day11.setSchedulesBackground(new Color(255, 214, 208));
        day21.setSchedulesBackground(new Color(255, 214, 208));
        day31.setSchedulesBackground(new Color(255, 214, 208));
        day41.setSchedulesBackground(new Color(255, 214, 208));
        day51.setSchedulesBackground(new Color(255, 214, 208));
        day61.setSchedulesBackground(new Color(255, 214, 208));
        day17.setSchedulesBackground(new Color(208, 233, 255));
        day27.setSchedulesBackground(new Color(208, 233, 255));
        day37.setSchedulesBackground(new Color(208, 233, 255));
        day47.setSchedulesBackground(new Color(208, 233, 255));
        day57.setSchedulesBackground(new Color(208, 233, 255));

        dayFreeService.setHeader("開始日の特定できないサービス");
        daySpacer.setVisible(false);

        this.add(weekHeader, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(weekSunday, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(weekMonday, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(weekTuesday, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(weekWednesday, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(weekThursday, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(weekFriday, new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(weekSaturday, new GridBagConstraints(7, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));

        this.add(week1Header, new GridBagConstraints(0, 1, 1, 1, 0.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day11, new GridBagConstraints(1, 1, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day12, new GridBagConstraints(2, 1, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day13, new GridBagConstraints(3, 1, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day14, new GridBagConstraints(4, 1, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day15, new GridBagConstraints(5, 1, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day16, new GridBagConstraints(6, 1, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day17, new GridBagConstraints(7, 1, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));

        this.add(week2Header, new GridBagConstraints(0, 2, 1, 1, 0.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day21, new GridBagConstraints(1, 2, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day22, new GridBagConstraints(2, 2, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day23, new GridBagConstraints(3, 2, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day24, new GridBagConstraints(4, 2, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day25, new GridBagConstraints(5, 2, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day26, new GridBagConstraints(6, 2, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day27, new GridBagConstraints(7, 2, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));

        this.add(week3Header, new GridBagConstraints(0, 3, 1, 1, 0.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day31, new GridBagConstraints(1, 3, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day32, new GridBagConstraints(2, 3, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day33, new GridBagConstraints(3, 3, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day34, new GridBagConstraints(4, 3, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day35, new GridBagConstraints(5, 3, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day36, new GridBagConstraints(6, 3, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day37, new GridBagConstraints(7, 3, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));

        this.add(week4Header, new GridBagConstraints(0, 4, 1, 1, 0.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day41, new GridBagConstraints(1, 4, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day42, new GridBagConstraints(2, 4, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day43, new GridBagConstraints(3, 4, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day44, new GridBagConstraints(4, 4, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day45, new GridBagConstraints(5, 4, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day46, new GridBagConstraints(6, 4, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day47, new GridBagConstraints(7, 4, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));

        this.add(week5Header, new GridBagConstraints(0, 5, 1, 1, 0.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day51, new GridBagConstraints(1, 5, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day52, new GridBagConstraints(2, 5, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day53, new GridBagConstraints(3, 5, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day54, new GridBagConstraints(4, 5, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day55, new GridBagConstraints(5, 5, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day56, new GridBagConstraints(6, 5, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day57, new GridBagConstraints(7, 5, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));

        this.add(week6Header, new GridBagConstraints(0, 6, 1, 1, 0.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day61, new GridBagConstraints(1, 6, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(day62, new GridBagConstraints(2, 6, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(daySpacer, new GridBagConstraints(3, 6, 1, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        this.add(dayFreeService, new GridBagConstraints(4, 6, 4, 1, 10.0, 10.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));

    }

    /**
     * サービスを描画するセルレンダラを返します。
     * 
     * @return セルレンダラ
     */
    public ListCellRenderer getCellRenderer() {
        return day11.getCellRenderer();
    }

    /**
     * サービスを描画するセルレンダラを設定します。
     * 
     * @param renderer セルレンダラ
     */
    public void setCellRenderer(ListCellRenderer renderer) {
        // レンダラを共有することでフォーカス描画も共有する
        QS001DaySchedule[] days = getSchedules(false, false);
        for (int i = 0; i < days.length; i++) {
            days[i].setCellRenderer(renderer);
            days[i]
                    .setDropAllowedServiceBitMask(QkanConstants.CALENADR_DROP_MONTHLY);
        }
        dayFreeService
                .setDropAllowedServiceBitMask(QkanConstants.CALENADR_DROP_NONE);

        if (renderer instanceof QS001ServicePatternListCellRenderer) {
            ((QS001ServicePatternListCellRenderer) renderer)
                    .setUseSpanList(dayFreeService);
        }
    }

    /**
     * サービスマスタ を設定します。
     * 
     * @param serviceMaster サービスマスタ
     */
    public void setMasterService(VRMap serviceMaster) {
        QS001DaySchedule[] days = getSchedules(false, true);
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
        QS001DaySchedule[] days = getSchedules(false, true);
        for (int i = 0; i < days.length; i++) {
            days[i].addDroppableListener(l);
        }
    }
    /**
     * サービスマスタを返します。
     * 
     * @return サービスマスタ
     */
    public VRMap getMasterService() {
        return day11.getMasterService();
    }

    /**
     * リスト選択イベントリスナを追加します。
     * 
     * @param listener リスト選択イベントリスナ
     */
    public void addListSelectionListener(ListSelectionListener listener) {
        QS001DaySchedule[] days = getSchedules(false, false);
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
        QS001DaySchedule[] days = getSchedules(false, false);
        for (int i = 0; i < days.length; i++) {
            days[i].addKeyListener(listener);
        }
    }

    /**
     * 開始日の特定できる月間サービス洋のリストであるかを返します。
     * 
     * @param day 検査対象のリスト
     * @return 開始日の特定できる月間サービス洋のリストであるか
     */
    public boolean isInCalendarSchedule(QS001DaySchedule day) {
        QS001DaySchedule[] days = getSchedules(true, false);
        int end = days.length;
        for (int i = 0; i < end; i++) {
            if (days[i] == day) {
                return true;
            }
        }
        return false;
    }

    /**
     * スケジュール画面項目一覧を返します。
     * 
     * @param filtered 表示されているものに絞り込むか
     * @param includeFreeService 開始日の指定されないサービスも含むか
     * @return スケジュール画面項目一覧
     */
    public QS001DaySchedule[] getSchedules(boolean filtered,
            boolean includeFreeService) {
        final QS001DaySchedule[] days = new QS001DaySchedule[] { day11, day12,
                day13, day14, day15, day16, day17, day21, day22, day23, day24,
                day25, day26, day27, day31, day32, day33, day34, day35, day36,
                day37, day41, day42, day43, day44, day45, day46, day47, day51,
                day52, day53, day54, day55, day56, day57, day61, day62,
                dayFreeService };
        if (filtered) {
            ArrayList list = new ArrayList(days.length);

            int end = days.length;
            if (!includeFreeService) {
                end--;
            }
            for (int i = 0; i < end; i++) {
                if (days[i].isVisible()) {
                    list.add(days[i]);
                }
            }
            int length = list.size();
            QS001DaySchedule[] schedules = new QS001DaySchedule[length];
            System.arraycopy(list.toArray(), 0, schedules, 0, length);
            return schedules;
        } else {
            return days;
        }
    }

    /**
     * 対象年月を設定します。
     * 
     * @param targetDate 対象年月
     */
    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
        Date firstDay = ACDateUtilities.toFirstDayOfMonth(targetDate);
        int firstWDay = ACDateUtilities.getDayOfWeek(firstDay) - 1;

        QS001DaySchedule[] days = getSchedules(false, false);
        // 1週目の空き曜日
        for (int i = 0; i < firstWDay; i++) {
            days[i].setHeader("");
            days[i].setEnabled(false);
            days[i].setVisible(false);
        }
        // 存在する日
        int end = ACDateUtilities.getLastDayOfMonth(targetDate);
        for (int i = 0; i < end; i++) {
            QS001DaySchedule day = days[i + firstWDay];
            day.setHeader(" " + String.valueOf(i + 1));
            day.setEnabled(true);
            Date checkDay = ACDateUtilities.addDay(firstDay, i);
            if (ACDateUtilities.isHolyday(checkDay)) {
                // 祝祭日は着色
                day.setSchedulesBackground(new Color(255, 214, 208));
                day.setHeader(day.getHeader() + " "
                        + ACDateUtilities.getHolydayNames(checkDay));
            }
        }
        // 末週の空き曜日
        for (int i = end + firstWDay; i < days.length - 1; i++) {
            days[i].setHeader("");
            days[i].setEnabled(false);
            days[i].setVisible(false);
        }
    }

    /**
     * スケジュールデータを返します。
     * 
     * @param useType 予定と実績のどちらとして取得するか
     * @return スケジュールデータ
     * @see QkanConstants.SERVICE_DETAIL_GET_PLAN
     * @see QkanConstants.SERVICE_DETAIL_GET_RESULT
     */
    public VRList getSchedule(int useType) throws Exception {
        QS001DaySchedule[] days = getSchedules(true, false);

        // 日別サービス
        Integer useTypeVal;
        // 開始日の特定できないサービス
        Integer freeDayUseType;

        if ((QkanConstants.SERVICE_DETAIL_GET_PLAN == useType)
                || (QkanConstants.SERVICE_DETAIL_GET_PLAN_OF_MONTHLY_ONLY == useType)) {
            // 予定の場合
            useTypeVal = QkanConstants.SERVICE_USE_TYPE_PLAN_MONTHLY_DAY;
            freeDayUseType = QkanConstants.SERVICE_USE_TYPE_PLAN_MONTHLY_FREE_DAY;
        } else {
            // 実績の場合
            useTypeVal = QkanConstants.SERVICE_USE_TYPE_RESULT_MONTHLY_DAY;
            freeDayUseType = QkanConstants.SERVICE_USE_TYPE_RESULT_MONTHLY_FREE_DAY;
        }

        VRList result = new VRArrayList();
        int end = days.length;
        for (int i = 0; i < end; i++) {
            VRList list = days[i].getSchedule();
            if ((list != null) && (!list.isEmpty())) {
                String header = ACTextUtilities.trim(days[i].getHeader());
                if(header.length()>2){
                    //先頭2文字に限定
                    header = header.substring(0,2);
                }
                Date date = ACDateUtilities.setDayOfMonth(getTargetDate(),
                        ACCastUtilities.toInt(header));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    // サービス提供日とUSE_TYPEを設定
                    try{
                        VRMap row = (VRMap) it.next();
                        VRBindPathParser.set("SERVICE_DATE", row, date);
                        VRBindPathParser.set("SERVICE_USE_TYPE", row, useTypeVal);
                    }catch(java.util.ConcurrentModificationException ex){
                        //イテレーションの同期例外は無視
                    }
                }
                result.addAll(list);
            }
        }

        VRList list = dayFreeService.getSchedule();
        if ((list != null) && (!list.isEmpty())) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                // サービス提供日とUSE_TYPEを設定
                try{
                    VRMap row = (VRMap) it.next();
                    VRBindPathParser.set("SERVICE_DATE", row, getTargetDate());
                    VRBindPathParser.set("SERVICE_USE_TYPE", row, freeDayUseType);
                }catch(java.util.ConcurrentModificationException ex){
                    //イテレーションの同期例外は無視
                }
            }
            result.addAll(list);
        }
        return result;
    }

    /**
     * スケジュールデータ件数を返します。
     * 
     * @return スケジュールデータ件数
     */
    public int getScheduleCount() {
        QS001DaySchedule[] days = getSchedules(true, false);
        int total = 0;
        int end = days.length;
        for (int i = 0; i < end; i++) {
            total += days[i].getScheduleCount();
        }
        return total;
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
     * 
     * @param schedules スケジュールデータ
     * @throws Exception 処理例外
     */
    public void addSchedule(VRList schedules) throws Exception {
        QS001DaySchedule[] days = getSchedules(true, false);
        Iterator it = schedules.iterator();
        while (it.hasNext()) {
            VRMap row = (VRMap) it.next();
            Object useType = VRBindPathParser.get("SERVICE_USE_TYPE", row);
            if (QkanConstants.SERVICE_USE_TYPE_PLAN_MONTHLY_DAY.equals(useType)
                    || QkanConstants.SERVICE_USE_TYPE_RESULT_MONTHLY_DAY
                            .equals(useType)) {
                // 月間系データのみ
                // 日から対応する画面項目を取得し、スケジュールを作成
                int idx =ACDateUtilities.getDayOfMonth(ACCastUtilities
                        .toDate(VRBindPathParser.get("SERVICE_DATE", row))) - 1;
                if((idx>=0)&&(idx<days.length)){
                    days[idx].addSchedule(row);
                }
            }else if(QkanConstants.SERVICE_USE_TYPE_PLAN_MONTHLY_FREE_DAY.equals(useType)){
                //開始日を特定しないサービス
                dayFreeService.addSchedule(row);
            }
        }
    }

    /**
     * スケジュールデータを削除します。
     */
    public void clearSchedule() {
        QS001DaySchedule[] days = getSchedules(true, true);
        int end = days.length;
        for (int i = 0; i < end; i++) {
            // いったん初期化
            days[i].clearSchedule();
        }
    }

    /**
     * 指定日以降のスケジュールデータを削除します。
     * 
     * @param clearBegin 削除開始日
     */
    public void clearSchedule(Date clearBegin) {
        QS001DaySchedule[] days = getSchedules(true, true);
        int end = days.length;
        for (int i = ACDateUtilities.getDayOfMonth(clearBegin) - 1; i < end; i++) {
            days[i].clearSchedule();
        }
    }
    /**
     * 開始日の特定されないサービス表示用のリストを返します。
     * @return 開始日の特定されないサービス表示用のリスト
     */
    public QS001DaySchedule getDayFreeServices(){
        return dayFreeService;
    }
}
