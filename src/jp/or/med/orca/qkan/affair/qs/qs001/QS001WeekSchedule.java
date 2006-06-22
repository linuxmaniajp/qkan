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
 * �T�ԃX�P�W���[���ł��B
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
     * �Ώ۔N ��Ԃ��܂��B
     * 
     * @return �Ώ۔N
     */
    public Date getTargetDate() {
        return targetDate;
    }

    /**
     * �Ώ۔N ��ݒ肵�܂��B
     * 
     * @param targetDate �Ώ۔N
     */
    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001WeekSchedule() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * �R���|�[�l���g��ݒ肵�܂��B
     * 
     * @throws Exception ������O
     */
    private void jbInit() throws Exception {
        this.setLayout(new GridBagLayout());
        weekHeaderContainer.setLayout(new BorderLayout());
        postMeridiemContainer.setLayout(new GridBagLayout());
        anteMeridiemContainer.setLayout(new GridBagLayout());

        weekHeader.setText("�@");
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

        anteMeridiem1.setText("��");
        anteMeridiem2.setText("�O");
        postMeridiem1.setText("��");
        postMeridiem2.setText("��");

        day1AM.setHeaderHorizontalAlignment(SwingConstants.CENTER);
        day2AM.setHeaderHorizontalAlignment(SwingConstants.CENTER);
        day3AM.setHeaderHorizontalAlignment(SwingConstants.CENTER);
        day4AM.setHeaderHorizontalAlignment(SwingConstants.CENTER);
        day5AM.setHeaderHorizontalAlignment(SwingConstants.CENTER);
        day6AM.setHeaderHorizontalAlignment(SwingConstants.CENTER);
        day7AM.setHeaderHorizontalAlignment(SwingConstants.CENTER);
        dayFreeAM.setHeaderHorizontalAlignment(SwingConstants.CENTER);
        day1AM.setHeader("��");
        day1PM.setHeaderVisible(false);
        day2PM.setHeaderVisible(false);
        day3PM.setHeaderVisible(false);
        day4PM.setHeaderVisible(false);
        day5PM.setHeaderVisible(false);
        day6PM.setHeaderVisible(false);
        day7PM.setHeaderVisible(false);
        dayFreePM.setHeaderVisible(false);
        day2AM.setHeader("��");
        day3AM.setHeader("��");
        day4AM.setHeader("��");
        day5AM.setHeader("��");
        day6AM.setHeader("�y");
        day7AM.setHeader("��");
        day7AM.setSchedulesBackground(new Color(255, 214, 208));
        day7PM.setSchedulesBackground(new Color(255, 214, 208));
        day6AM.setSchedulesBackground(new Color(208, 233, 255));
        day6PM.setSchedulesBackground(new Color(208, 233, 255));
        dayFreeAM.setHeader(" ����");

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
     * �T�[�r�X��`�悷��Z�������_����Ԃ��܂��B
     * 
     * @return �Z�������_��
     */
    public ListCellRenderer getCellRenderer() {
        return day1AM.getCellRenderer();
    }

    /**
     * �T�[�r�X��`�悷��Z�������_����ݒ肵�܂��B
     * 
     * @param renderer �Z�������_��
     */
    public void setCellRenderer(ListCellRenderer renderer) {
        // �����_�������L���邱�ƂŃt�H�[�J�X�`������L����
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
     * �T�[�r�X�}�X�^ ��ݒ肵�܂��B
     * 
     * @param serviceMaster �T�[�r�X�}�X�^
     */
    public void setMasterService(VRMap serviceMaster) {
        QS001DaySchedule[] days = getSchedules();
        for (int i = 0; i < days.length; i++) {
            days[i].setMasterService(serviceMaster);
        }
    }

    /**
     * �h���b�v�C�x���g���X�i��ǉ����܂��B
     * 
     * @param l �h���b�v�C�x���g���X�i
     */
    public void addDroppableListener(ACDroppableListener l) {
        QS001DaySchedule[] days = getSchedules();
        for (int i = 0; i < days.length; i++) {
            days[i].addDroppableListener(l);
        }
    }    
    /**
     * �X�P�W���[����ʍ��ڈꗗ��Ԃ��܂��B
     * 
     * @return �X�P�W���[����ʍ��ڈꗗ
     */
    protected QS001DaySchedule[] getSchedules() {
        return new QS001DaySchedule[] { day1AM, day2AM, day3AM, day4AM, day5AM,
                day6AM, day7AM, dayFreeAM, day1PM, day2PM, day3PM, day4PM,
                day5PM, day6PM, day7PM, dayFreePM, };
    }

    /**
     * �T�ԕ\�̃��X�g�ł��邩��Ԃ��܂��B
     * @param list ��r���X�g
     * @return �T�ԕ\�̃��X�g�ł��邩
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
     * ��ȓ��퐶����̊�����\�����X�g�ł��邩��Ԃ��܂��B
     * @param list ��r���X�g
     * @return ��ȓ��퐶����̊�����\�����X�g�ł��邩
     */
    public boolean isDailyServiceList(QS001DaySchedule list){
        return (list==dayFreeAM)||(list==dayFreePM);
    }

    /**
     * �T�Ԉʒu�t���O�ꗗ��Ԃ��܂��B
     * 
     * @return �T�Ԉʒu�t���O�ꗗ
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
     * ownerAffair��Ԃ��܂��B
     * @return ownerAffair
     */
    protected QS001 getOwnerAffair(){
      return ownerAffair;
    }
    /**
     * ownerAffair��ݒ肵�܂��B
     * @param ownerAffair ownerAffair
     */
    protected void setOwnerAffair(QS001 ownerAffair){
      this.ownerAffair = ownerAffair;
    }
    private QS001 ownerAffair; 

    /**
     * �X�P�W���[���f�[�^��Ԃ��܂��B
     * 
     * @return �X�P�W���[���f�[�^
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
                        // �T�[�r�X�񋟓���USE_TYPE��ݒ�
                        try {
                            VRMap row = (VRMap) it.next();
                            VRBindPathParser.set("SERVICE_DATE", row,
                                    getTargetDate());
                            VRBindPathParser.set("WEEK_DAY", row, weekdays[i]);
                            VRBindPathParser.set("SERVICE_USE_TYPE", row,
                                    useType);
                        } catch (java.util.ConcurrentModificationException ex) {
                            //�C�e���[�V�����̓�����O�͖���
                        }
                    }
                    result.addAll(list);
                }
            }
        }

        return result;
    }

    /**
     * ���X�g�I���C�x���g���X�i��ǉ����܂��B
     * 
     * @param listener ���X�g�I���C�x���g���X�i
     */
    public void addListSelectionListener(ListSelectionListener listener) {
        QS001DaySchedule[] days = getSchedules();
        for (int i = 0; i < days.length; i++) {
            days[i].addListSelectionListener(listener);
        }
    }

    /**
     * �L�[���̓C�x���g���X�i��ǉ����܂��B
     * 
     * @param listener �L�[���̓C�x���g���X�i
     */
    public void addKeyListener(KeyListener listener) {
        QS001DaySchedule[] days = getSchedules();
        for (int i = 0; i < days.length; i++) {
            days[i].addKeyListener(listener);
        }
    }

    /**
     * �X�P�W���[���f�[�^��ݒ肵�܂��B
     * 
     * @param schedules �X�P�W���[���f�[�^
     * @throws Exception ������O
     */
    public void setSchedule(VRList schedules) throws Exception {
        // �������񏉊���
        clearSchedule();

        addSchedule(schedules);
    }
    
    /**
     * �X�P�W���[���f�[�^��ǉ����܂��B
     * @param schedules �X�P�W���[���f�[�^
     * @throws Exception ������O
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
                //SERVICE_USE_TYPE���T�ԕ\�Ɋւ�����̂̂ݒ��o
                Object schedule = map
                        .get(VRBindPathParser.get("WEEK_DAY", row));
                if (schedule instanceof QS001DaySchedule) {
                    // �T�Ԍn�f�[�^�̂�
                    // ������Ή������ʍ��ڂ��擾���A�X�P�W���[����ǉ�����
                    ((QS001DaySchedule) schedule).addSchedule(row);
                }
            }
        }
    }

    /**
     * �X�P�W���[���f�[�^������Ԃ��܂��B
     * 
     * @return �X�P�W���[���f�[�^����
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
     * �X�P�W���[���f�[�^�����������܂��B
     */
    public void clearSchedule() {
        QS001DaySchedule[] days = getSchedules();
        int end = days.length;
        for (int i = 0; i < end; i++) {
            // �������񏉊���
            days[i].clearSchedule();
        }
    }
}
