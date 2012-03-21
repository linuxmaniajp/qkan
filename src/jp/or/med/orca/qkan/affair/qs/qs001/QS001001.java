/*
 * Project code name "ORCA"
 * ���t�Ǘ��䒠�\�t�g QKANCHO�iJMA care benefit management software�j
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
 * �A�v��: QKANCHO
 * �J����: �� ����
 * �쐬��: 2006/01/08  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�ԕ\ (QS001001)
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
 * �T�ԕ\(QS001001)
 */
public class QS001001 extends QS001001Event {
    /**
     * �R���X�g���N�^�ł��B
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
     * �������������s�Ȃ��܂��B
     * 
     * @param affair �Ɩ����
     * @throws Exception ������O
     */
    protected void initAction(ACAffairInfo affair) throws Exception {
        getFreedayServices().setHeaderVisible(false);
        // �T�ԕ\�̍쐬���t�ɂ̓V�X�e�����t��ݒ�
        getCreateDate().setDate(
                QkanSystemInformation.getInstance().getSystemDate());

    }

    // �R���|�[�l���g�C�x���g

    /**
     * �u�T�[�r�X�̐ݒ�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void timeButtonActionPerformed(ActionEvent e) throws Exception {
        // ���T�ԕ\�Ɂu�T�[�r�X�ڍׁv�̏���ݒ�
        Integer useType = null;
        if (getOwnerAffair().getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
            useType = QkanConstants.SERVICE_USE_TYPE_PLAN_WEEKLY_DAY;
        } else if (getOwnerAffair().getProcessType() == QkanConstants.PROCESS_TYPE_RESULT) {
            useType = QkanConstants.SERVICE_USE_TYPE_RESULT_WEEKLY_DAY;
        }

        if (getMondayCheck().isVisible()) {
            // �T�[�r�X���u��ȓ��퐶����̊����v�ł͂Ȃ��ꍇ
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
                // �u�����E�j���̐ݒ�v�Ń`�F�b�N���Ă���j���Ɂu�T�[�r�X�ڍׁv�̏���ݒ肷��B�u�ߑO�v�u�ߌ�v�̔��ʂ́u�J�n�����v�ɂčs���B
                // �u�J�n�����v���ݒ肳��Ă��Ȃ��ꍇ�A�ߑO�̃T�[�r�X�Ƃ��ď�������B
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
                // ���j�[�N�L�[�̍폜
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
            // �T�[�r�X���u��ȓ��퐶����̊����v�̏ꍇ
            VRMap service = getOwnerAffair().createServiceData();
            if (service != null) {
                // �T�ԕ\�́u��ȓ��퐶����̊����v���Ɂu�T�[�r�X�ڍׁv�̏���ݒ肷��B�u�ߑO�v�u�ߌ�v�̔��ʂ́u�J�n�����v�ɂčs���B
                // �u�J�n�����v���ݒ肳��Ă��Ȃ��ꍇ�A�ߑO�̃T�[�r�X�Ƃ��ď�������B
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
                // ���j�[�N�L�[�̍폜
                service.remove("SERVICE_ID");

                VRBindPathParser.set("SERVICE_USE_TYPE", service, useType);

                VRList add = new VRArrayList();
                add.add(service);
                getWeeklySchedule().addSchedule(add);
            }
        }

    }

    /**
     * �u�T�[�r�X�̐ݒ�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void exceptionButtonActionPerformed(ActionEvent e)
            throws Exception {
        // ���T�ԕ\�́u�T�P�ʈȊO�v�ɁA�u�T�[�r�X�ڍׁv�̏���ݒ�(���Ԃ̓R���{�őI������Ă������)
        // �������A�u��ȓ��퐶����̊����v�́A�u�����i�����`�����j�v�̏ꍇ�̂ݓW�J�\�B
        if ((!getExceptionEndCombo().isSelected())
                || (!(getExceptionEndCombo().getSelectedItem() instanceof VRMap))) {
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_PASTE_DAY();
            return;
        }

        VRMap service = getOwnerAffair().createServiceData();
        if (service != null) {
            // ���j�[�N�L�[�̍폜
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
                // �J�n��
                service.setData("WEEK_DAY",
                        VRBindPathParser.get("CONTENT_KEY", (VRMap) obj));
                // ����
                service.setData(QkanConstants.SERVICE_SYSTEM_BIND_PATH_SPAN,
                        VRBindPathParser.get("CONTENT_KEY",
                                (VRMap) getExceptionEndCombo()
                                        .getSelectedModelItem()));
                // �\��t����
                getFreedayServices().addSchedule(service);
                getOwnerAffair().setServiceModify(true);
            }
        }

    }

    /**
     * �u�T�[�r�X�̐ݒ�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void everydayButtonActionPerformed(ActionEvent e)
            throws Exception {
        // ���T�ԕ\�́u�T�P�ʈȊO�v�ɁA�u�T�[�r�X�ڍׁv�̏���ݒ�(���Ԃ́A�u�����v����u�����v)
        // ���Ԃ̃R���{���u�����v����u�����v�ɐݒ肷��B
        getExceptionBeginCombo().setSelectedIndex(
                getExceptionBeginCombo().getItemCount() - 1);
        getExceptionEndCombo().setSelectedIndex(
                getExceptionEndCombo().getItemCount() - 1);
        exceptionButtonActionPerformed(e);
    }

    /**
     * �u���ԕ\�ւ̓W�J�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void expansionButtonActionPerformed(ActionEvent e)
            throws Exception {
        // ���T�ԕ\�ɐݒ肳��Ă���T�[�r�X�������ԕ\�ɐݒ�
        // �����ԕ\�ɓW�J���Ȃ��T�[�r�X
        // �T�[�r�X�u���̑��v�́A���ԕ\�ɓW�J���Ȃ��B

        // �W�J�J�n�����Z�o
        Date expansionBeginDay = ACDateUtilities
                .toFirstDayOfMonth(getWeeklySchedule().getTargetDate());
        // �����̍ŏI�����Z�o
        int lastDay = ACDateUtilities.getLastDayOfMonth(expansionBeginDay);
        boolean expandsWeekly = true;
        int beginDayVal = 1;
        String beginDayText = getExpansionStartDate().getText();
        if (!ACTextUtilities.isNullText(beginDayText)) {
            // �W�J�J�n�����󗓂łȂ��ꍇ(�J�n���󗓂͌������Ӗ�����)
            beginDayVal = ACCastUtilities.toInt(beginDayText, 99);
            if (beginDayVal > lastDay) {
                // �w��̊J�n���������𒴂���ꍇ�͏T�P�ʂ̓W�J���s��Ȃ��B
                expandsWeekly = false;
            } else {
                // �W�J�J�n������͂���������Ƃ���B
                expansionBeginDay = ACDateUtilities.setDayOfMonth(
                        expansionBeginDay, beginDayVal);
            }
        }
        // �{�݌n�T�[�r�X���p��
        boolean[] inFacilityTable = new boolean[31];

        VRList paste = new VRArrayList();
        Iterator it;

        // ���T�P�ʈȊO�̃T�[�r�X�����ԂɓW�J����
        it = getFreedayServices().getSchedule().iterator();
        while (it.hasNext()) {
            VRMap service = (VRMap) it.next();
            // Object kindDetail = VRBindPathParser.get(
            // "SYSTEM_SERVICE_KIND_DETAIL", service);
            if (CareServiceCommon.isOtherService(service)) {
                // �T�[�r�X�u���̑��v�͖���
                continue;
            }

            // �\��t���f�[�^�𕡐�����
            service = (VRMap) service.clone();
            // ���j�[�N�L�[�̍폜
            service.remove("SERVICE_ID");

            // �T�[�r�X�̊J�n�����`�F�b�N
            Object obj = VRBindPathParser.get("WEEK_DAY", service);
            if (CareServiceCommon.isWelfareEquipment(service)
                    && QkanConstants.SERVICE_WEEK_DAY_UNKNOWN.equals(obj)) {
                // �����p��ݗ^�̎w�薳���͌������Ӗ�����
                obj = QkanConstants.SERVICE_WEEK_DAY_FIRST_DAY;
            }

            if (QkanConstants.SERVICE_WEEK_DAY_UNKNOWN.equals(obj)) {
                // �J�n�����u�w��Ȃ��v�Ȃ�ΊJ�n���̓���ł��Ȃ����ԃT�[�r�X�Ƃ���
                VRBindPathParser.set("SERVICE_USE_TYPE", service,
                        QkanConstants.SERVICE_USE_TYPE_PLAN_MONTHLY_FREE_DAY);

                // �W�J�J�n����ݒ�
                VRBindPathParser
                        .set("SERVICE_DATE", service, expansionBeginDay);
                // �J�n���̓���ł��Ȃ��T�[�r�X��ǉ�
                paste.add(service);
            } else {
                // �J�n�������\�ȃT�[�r�X�̏ꍇ

                int serviceBeginDay;
                if (QkanConstants.SERVICE_WEEK_DAY_FIRST_DAY.equals(obj)) {
                    // �u�����v��1�����w��
                    serviceBeginDay = 1;
                } else {
                    int val = ACCastUtilities.toInt(obj);

                    // 1���Z����7�̏�]+1���j��
                    int wday = (val - 1) % 7 + 1;
                    // 1���Z����7�̏�+1���T
                    int week = (val - 2) / 7 + 1;

                    // �ꎞ�ϐ��������Ƃ���
                    Date day = ACDateUtilities
                            .toFirstDayOfMonth(expansionBeginDay);
                    if (ACDateUtilities.getDayOfWeek(day) > wday) {
                        // ���������O�̗j���ł���ΏT��1���Z����
                        week++;
                    }

                    // �����𒴉߂��Ă��邩�`�F�b�N
                    Date lastDate = ACDateUtilities
                            .toLastDayOfMonth(expansionBeginDay);
                    int lastWDay = ACDateUtilities.getDayOfWeek(lastDate);
                    int lastWeek = ACDateUtilities.getWeekOfMonth(lastDate);
                    if ((lastWeek < week)
                            || ((lastWeek == week) && (lastWDay < wday))) {
                        // �ŏI�T�𒴉߂��ŏI�T�̍ŏI�j���𒴉߂����ꍇ�͖���
                        continue;
                    }

                    // ��week�T��wday�j���̓��ɂ����擾
                    serviceBeginDay = ACDateUtilities
                            .getDayOfMonth(ACDateUtilities.setDayOfWeek(
                                    ACDateUtilities.setWeekOfMonth(day, week),
                                    wday));
                }

                if (serviceBeginDay < ACDateUtilities
                        .getDayOfMonth(expansionBeginDay)) {
                    // �T�[�r�X�̊J�n�����W�J�J�n�����O�ł���ΓW�J���Ȃ�
                    continue;
                }

                // �T�[�r�X�̊J�n������W�J����
                Date beginDay = ACDateUtilities.setDayOfMonth(
                        expansionBeginDay, serviceBeginDay);

                boolean adjustEndDay = false;
                int endDay = serviceBeginDay
                        + ACCastUtilities.toInt(VRBindPathParser.get(
                                QkanConstants.SERVICE_SYSTEM_BIND_PATH_SPAN,
                                service), 0) - 1;
                if (endDay > lastDay) {
                    // �W�J�J�n��+�W�J�����������𒴂����ꍇ�͖����܂łɂ���
                    endDay = lastDay;
                    adjustEndDay = true;
                }

                // �T�[�r�X�p�r�͗\�茎�ԕ\�Ƃ���
                VRBindPathParser.set("SERVICE_USE_TYPE", service,
                        QkanConstants.SERVICE_USE_TYPE_PLAN_MONTHLY_DAY);
                // �W�J�J�n����ݒ�
                VRBindPathParser.set("SERVICE_DATE", service, beginDay);
                // �W�J�J�n���̃T�[�r�X��ǉ�
                paste.add(service);

                final String SENDING_BIND_PATH = "6";
                // int kindDetailVal = ACCastUtilities.toInt(kindDetail, 0);
                if (CareServiceCommon.isShortStay(service)
                        && VRBindPathParser.has(SENDING_BIND_PATH, service)) {
                    // ���Z�������n�̏ꍇ
                    final Integer SENDING_ROUND_NONE = new Integer(1);
                    final Integer SENDING_ROUND_ONE_WAY = new Integer(2);
                    final Integer SENDING_ROUND_TRIP = new Integer(3);

                    Object spanSending;
                    Object lastSending;
                    Object sending = VRBindPathParser.get(SENDING_BIND_PATH,
                            service);
                    if (SENDING_ROUND_TRIP.equals(sending)) {
                        // �T�[�r�X�Ɂu���}���Z�E�����v���ݒ肳��Ă���ꍇ
                        // �����́u���}���Z�E�Г��v�ɂ���B
                        // �����́u���}���Z�E�Ȃ��v�ɂ���B
                        // �����́u���}���Z�E�Г��v�ɂ���B

                        // �������́u���}���Z�E�Г��v�ɂ���B
                        VRBindPathParser.set(SENDING_BIND_PATH, service,
                                SENDING_ROUND_ONE_WAY);

                        if (adjustEndDay) {
                            // �W�J������␳�����ꍇ�́A�Ō�܂Łu���}���Z�E�Ȃ��v�ɂȂ�B
                            spanSending = SENDING_ROUND_NONE;
                            lastSending = SENDING_ROUND_NONE;
                        } else {
                            // �W�J������␳���Ȃ������ꍇ�́A�Ōゾ���u���}���Z�E�Г��v�ɂȂ�B
                            spanSending = SENDING_ROUND_NONE;
                            lastSending = SENDING_ROUND_ONE_WAY;
                        }
                    } else if (SENDING_ROUND_ONE_WAY.equals(sending)) {
                        // �T�[�r�X�Ɂu���}���Z�E�Г��v���ݒ肳��Ă���ꍇ
                        // �����́u���}���Z�E�Г��v�ɂ���B
                        // �����ȊO�́u���}���Z�E�Ȃ��v�ɂ���B
                        spanSending = SENDING_ROUND_NONE;
                        lastSending = sending;
                    } else {
                        // ���}���Z�ɕύX����
                        spanSending = sending;
                        lastSending = sending;
                    }

                    // �w�肵�����}���Z�ɕύX���Ȃ���W�J�I�����܂ł̃T�[�r�X�𐶐�����
                    for (int i = serviceBeginDay + 1; i <= endDay; i++) {
                        service = (VRMap) service.clone();
                        VRBindPathParser.set("SERVICE_DATE", service,
                                ACDateUtilities.setDayOfMonth(beginDay, i));
                        // �������̑��}���Z��ݒ�
                        VRBindPathParser.set(SENDING_BIND_PATH, service,
                                spanSending);
                        paste.add(service);
                    }

                    // ���W�J�����̑��}���Z��ݒ�
                    VRBindPathParser.set(SENDING_BIND_PATH, service,
                            lastSending);
                } else {
                    // ���Z�������n�ȊO�̏ꍇ

                    // �W�J�J�n���̗�������W�J�I�����܂ł̃T�[�r�X�𐶐�����
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
                    // ���T�P�ʁE�T�P�ʈȊO�̗����ɐݒ肳��Ă���ꍇ�A�W�J���Ȃ��T�[�r�X
                    // �T�[�r�X��ރR�[�h�����L�̂��̂́A�u�T�P�ʁv�Ɓu�T�P�ʈȊO�v�ŏd�������ꍇ�A�u�T�P�ʈȊO�v�݂̂�W�J����B
                    // 21, 22, 23, 32, 33, 51, 52, 53
                    // �i�K��Ō�,�K�⃊�n,�ʏ����n,�K����,�K��������,�ʏ����=�R�[�h��1�Ŏn�܂�T�[�r�X�ŕ����p��ݗ^�ȊO�͍폜����j
                    for (int i = serviceBeginDay; i <= endDay; i++) {
                        inFacilityTable[i - 1] = true;
                    }
                }
            }
        }

        if (expandsWeekly) {
            // ���T�P�ʂ̃T�[�r�X�����ԂɓW�J����

            // �W�J�J�n���̗j�����Z�o
            int expansionBeginWDay = ACDateUtilities
                    .getDayOfWeek(expansionBeginDay);

            // �W�J�J�n������1�T�ԕ��̓��t�𐶐�
            // �����̗j�����c�r�A���߂�j�������r�Ƃ������ɂ��ϊ��e�[�u��
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

            // �T�P�ʂ̃T�[�r�X��W�J����ꍇ
            // �T�ԕ\�̃T�[�r�X��S����
            it = getWeeklySchedule().getSchedule().iterator();
            while (it.hasNext()) {
                VRMap service = (VRMap) it.next();
                if (CareServiceCommon.isOtherService(service)
                        || CareServiceCommon.isDailyAction(service)) {
                    // �T�[�r�X�u���̑��v�u��ȓ��퐶����̊����v�͖���
                    continue;
                }
                // �T�[�r�X�̗j�����`�F�b�N
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
                    // �j���ȊO(���퐶��)�͖���
                    continue;
                }
                // �T�[�r�X�̗j������W�J�J�n�����Z�o
                Date beginDay = expansionBeginDays[wday - 1];
                if (beginDay == null) {
                    // �����𒴉߂����T�[�r�X�͓W�J���Ȃ�
                    continue;
                }

                boolean removeService = CareServiceCommon.isHomeVisit(service)
                        || CareServiceCommon.isFacilityVisit(service);

                // �\��t���f�[�^�𕡐�����
                service = (VRMap) service.clone();
                // ���j�[�N�L�[�̍폜
                service.remove("SERVICE_ID");
                // �T�[�r�X�p�r�͗\�茎�ԕ\�Ƃ���
                VRBindPathParser.set("SERVICE_USE_TYPE", service,
                        QkanConstants.SERVICE_USE_TYPE_PLAN_MONTHLY_DAY);

                int beginDayOfMonth = ACDateUtilities.getDayOfMonth(beginDay);
                if ((!inFacilityTable[beginDayOfMonth - 1]) || (!removeService)) {
                    // �T�P�ʈȊO�ɂ����Ď{�݊֌W�T�[�r�X���󂯂Ă��Ȃ��������O�Ώۂ̃T�[�r�X�ł͂Ȃ��ꍇ
                    VRBindPathParser.set("SERVICE_DATE", service, beginDay);
                    // �W�J�J�n���̃T�[�r�X��ǉ�
                    paste.add(service);
                }
                // �W�J�J�n���̗��T���疖���܂ł̃T�[�r�X�𐶐�����
                for (int i = beginDayOfMonth + 7; i <= lastDay; i += 7) {
                    if ((!inFacilityTable[i - 1]) || (!removeService)) {
                        // �T�P�ʈȊO�ɂ����Ď{�݊֌W�T�[�r�X���󂯂Ă��Ȃ��������O�Ώۂ̃T�[�r�X�ł͂Ȃ��ꍇ
                        service = (VRMap) service.clone();
                        VRBindPathParser.set("SERVICE_DATE", service,
                                ACDateUtilities.setDayOfMonth(beginDay, i));
                        paste.add(service);
                    }
                }
            }
        }

        // �T�[�r�X�̉񐔐����`�F�b�N
        convertServiceData(paste);

        // �W�J�J�n���ȍ~�̗\����폜
        getOwnerAffair().getMonthlyPanel().clearSchedule(expansionBeginDay);
        // �W�J
        getOwnerAffair().getMonthlyPanel().addSchedule(paste);

        getOwnerAffair().getMonthlyPanel().recalcServiceTotal();
        getOwnerAffair().showMonthly();
        getOwnerAffair().clearServiceSelection();

        getOwnerAffair().setServiceModify(true);
    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        ACFrame.debugStart(new ACAffairInfo(QS001001.class.getName()));
    }

    // �����֐�

    /**
     * �u����`�F�b�N�{�b�N�X��Enabled�ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void setDailylifeCheckEnabled(boolean enabled) throws Exception {
        // ���u3.�����E�j���̑I���v�u����v�`�F�b�N�{�b�N�X�̏�Ԃ�ݒ肷��B
        // ����enabled�̒l���`�F�b�N����B
        if (enabled) {
            // true�̏ꍇ
            // �u���v�`�u���v�̃`�F�b�N�{�b�N�X���\���ɁA�u�T�P�ʈȊO�̃T�[�r�X�v�ȉ��𖳌��ɂ���B
            setState_EXT_CONTENT_DETAIL_SELECTED();
        } else {
            // false�̏ꍇ
            // �u���v�`�u���v�̃`�F�b�N�{�b�N�X��\�����A�u�T�P�ʈȊO�̃T�[�r�X�v�ȉ���L���ɂ���B
            setState_EXT_CONTENT_DETAIL_UNSELECTED();
        }
    }

    /**
     * �u�쐬�N�����̎擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public Date getCreateDateValue() throws Exception {
        // ���쐬�N�����̎擾
        // ��ʂ́u�쐬�N����(createDate)�v�̒l��Ԃ��B
        return getCreateDate().getDate();
    }

    /**
     * �u�Ώ۔N����ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void setTargetDate(Date targetDate) throws Exception {
        // �����ԕ\�̑Ώ۔N����ݒ�
        // ���ԕ\�̑Ώ۔N����ݒ肷��B
        getWeeklySchedule().setTargetDate(targetDate);
    }

    /**
     * �u�T�[�r�X�`��p�̃Z�������_���ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param renderer ListCellRenderer
     * @throws Exception ������O
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
     * �T�[�r�X�}�X�^ ��ݒ肵�܂��B
     * 
     * @param serviceMaster �T�[�r�X�}�X�^
     */
    public void setMasterService(VRMap serviceMaster) {
        getWeeklySchedule().setMasterService(serviceMaster);
        getFreedayServices().setMasterService(serviceMaster);
    }

    /**
     * �u�X�P�W���[���S�̂�ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param schedules VRList
     * @throws Exception ������O
     */
    public void setSchedule(VRList schedules) throws Exception {
        getWeeklySchedule().setSchedule(schedules);
        setFreedaySchedule(schedules);
        getOwnerAffair().setServiceModify(true);
    }

    /**
     * �u�X�P�W���[���S�̂��擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     * @return VRList
     */
    public VRList getSchedule() throws Exception {
        VRList list = getWeeklySchedule().getSchedule();
        list.addAll(getAllFreedaySchedule());
        return list;
    }

    /**
     * �u���X�g�I���C�x���g���X�i��ǉ��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param listener ListSelectionListener
     * @throws Exception ������O
     */
    public void addListSelectionListener(ListSelectionListener listener) {
        getWeeklySchedule().addListSelectionListener(listener);
        getFreedayServices().addListSelectionListener(listener);
    }

    /**
     * �u���X�g�I���C�x���g���X�i��ǉ��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param listener KeyListener
     * @throws Exception ������O
     */
    public void addKeyListener(KeyListener listener) {
        getWeeklySchedule().addKeyListener(listener);
        getFreedayServices().addKeyListener(listener);
    }

    /**
     * �X�P�W���[���f�[�^������Ԃ��܂��B
     * 
     * @return �X�P�W���[���f�[�^����
     */
    public int getScheduleCount() throws Exception {
        return getWeeklySchedule().getScheduleCount()
                + getFreedayServices().getScheduleCount();
    }

    /**
     * �u�X�P�W���[�����������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void clearSchedule() throws Exception {
        getWeeklySchedule().clearSchedule();
        getFreedayServices().clearSchedule();
        getOwnerAffair().setServiceModify(true);
    }

    /**
     * �u��ʏ������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param ownerAffair QS001
     * @throws Exception ������O
     */
    public void initialize(QS001 ownerAffair) throws Exception {
        // ����ʓW�J���̏����ݒ�
        // ownerAffair���`�ϐ��ɑޔ�����B
        setOwnerAffair(ownerAffair);
        // ���R���{�A�C�e���̐ݒ�
        // ������
        // �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
        VRMap comboItemMap = new VRHashMap();

        // ���J�n����
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 3 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
        // ���I������
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 4 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
        // ���T
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F24�i�T�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 24 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("24", QkanCommon.getArrayFromMasterCode(24, "24"));
        // ������
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F25�i�����j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 25 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("25", QkanCommon.getArrayFromMasterCode(25, "25"));
        // ���R���{�A�C�e���̐ݒ�
        // �u���g(this)�v��comboItemMap�ɐݒ肷��B
        getThis().setModelSource(comboItemMap);
        // �R���{�A�C�e����W�J����B
        getThis().bindModelSource();

        // ���I�����ڂ̏����ݒ�
        // �J�n�R���{(exceptionBeginCombo)�́u�w��Ȃ��v��I������B
        getExceptionBeginCombo().setSelectedIndex(0);

        getWeeklySchedule().addDroppableListener(getOwnerAffair());
    }

    /**
     * �u�T�[�r�X����J�n���R���{�Ɗ��ԃR���{��ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param service VRMap
     * @throws Exception ������O
     */
    public void setServiceSpan(VRMap service) throws Exception {
        Object useType = VRBindPathParser.get("SERVICE_USE_TYPE", service);
        if (QkanConstants.SERVICE_USE_TYPE_PLAN_WEEKLY_FREE_DAY.equals(useType)
                || QkanConstants.SERVICE_USE_TYPE_RESULT_WEEKLY_FREE_DAY
                        .equals(useType)) {
            // �T�P�ʈȊO�̃T�[�r�X�̏ꍇ
            // �J�n���R���{���uWEEK_DAY�v�̒l�ɂ���B
            VRMap map = new VRHashMap();
            map.setData(getExceptionBeginCombo().getBindPath(),
                    VRBindPathParser.get("WEEK_DAY", service));
            if (CareServiceCommon.isWelfareEquipment(service)) {
                // �����p��ݗ^�̏ꍇ
                // ���ԃR���{���u1���v�Ƃ��A����s�Ƃ���B
                getExceptionEndCombo().setSelectedIndex(1);
                setState_WELFARE_EQUIPMENT_SELECTED();
            } else {
                // �����p��ݗ^�ȊO�̏ꍇ
                // �T�[�r�X�̎����Ԃ̒l��W�J���A���ԃR���{�𑀍�\�Ƃ���B
                map.setData(getExceptionEndCombo().getBindPath(),
                        VRBindPathParser.get(
                                QkanConstants.SERVICE_SYSTEM_BIND_PATH_SPAN,
                                service));
                setState_WELFARE_EQUIPMENT_UNSELECTED();
            }
            getExceptionServiceCombos().setSource(map);
            getExceptionServiceCombos().bindSource();

        } else {
            // �T�P�ʂ̃T�[�r�X�̏ꍇ
            // �J�n���R���{���u�w��Ȃ��v�ɂ���B
            getExceptionBeginCombo().setSelectedIndex(0);
            if (CareServiceCommon.isWelfareEquipment(service)) {
                // �����p��ݗ^�̏ꍇ
                // ���ԃR���{���u1���v�Ƃ��A����s�Ƃ���B
                getExceptionEndCombo().setSelectedIndex(1);
                setState_WELFARE_EQUIPMENT_SELECTED();
            } else {
                // �����p��ݗ^�ȊO�̏ꍇ
                // ���ԃR���{���u�����v�ɂ���B
                getExceptionEndCombo().setSelectedIndex(
                        getExceptionEndCombo().getItemCount() - 1);
                setState_WELFARE_EQUIPMENT_UNSELECTED();
            }
        }

        // �T�[�r�X�̎��ԑт�ݒ肷��B
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
     * �u�T�P�ʈȊO�̃T�[�r�X��ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param schedules VRList
     * @throws Exception ������O
     */
    public void setFreedaySchedule(VRList schedules) throws Exception {
        // ���T�P�ʈȊO�̃T�[�r�X��ݒ�

        // �T�P�ʈȊO�̃T�[�r�X������������B
        getFreedayServices().clearSchedule();
        Iterator it = schedules.iterator();
        while (it.hasNext()) {
            // �X�P�W���[���W�������ׂđ�������B
            VRMap row = (VRMap) it.next();

            Object type = VRBindPathParser.get("SERVICE_USE_TYPE", row);
            if (QkanConstants.SERVICE_USE_TYPE_PLAN_WEEKLY_FREE_DAY
                    .equals(type)
                    || QkanConstants.SERVICE_USE_TYPE_RESULT_WEEKLY_FREE_DAY
                            .equals(type)) {
                // �X�P�W���[����SERVICE_USE_TYPE���u�T�ԕ\�̏T�P�ʈȊO�v�̏ꍇ
                // �T�P�ʈȊO�̃T�[�r�X�Ƃ��ăX�P�W���[����ǉ�����B
                getFreedayServices().addSchedule(row);
            }
        }
    }

    /**
     * �u�T�P�ʈȊO�̃T�[�r�X���擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
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
                // �T�[�r�X�񋟓���USE_TYPE��ݒ�
                VRMap row = (VRMap) it.next();
                VRBindPathParser.set("SERVICE_DATE", row, getWeeklySchedule()
                        .getTargetDate());
                VRBindPathParser.set("SERVICE_USE_TYPE", row, useType);
            }
        }
        return list;
    }

    /**
     * �u�T�P�ʂ̃T�[�r�X���擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
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
     * �u�T�ԕ\�̃��X�g�ł��邩�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param list QS001DaySchedule
     * @throws Exception ������O
     * @return boolean
     */
    public boolean isWeeklyServiceList(QS001DaySchedule list) throws Exception {
        return getWeeklySchedule().isWeeklyServiceList(list)
                || (getFreedayServices() == list);
    }

    /**
     * �u��ȓ��퐶����̊�����\�����X�g�ł��邩�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param list QS001DaySchedule
     * @throws Exception ������O
     * @return boolean
     */
    public boolean isDailyServiceList(QS001DaySchedule list) throws Exception {
        return getWeeklySchedule().isDailyServiceList(list);
    }

    /**
     * �u�T�[�r�X�̐����񐔃`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂�
     * 
     * @param paste �W�J���悤�Ƃ��Ă���T�[�r�X�̃��X�g
     * @throws Exception ������O
     */
    public void convertServiceData(VRList paste) throws Exception {
        final Integer OFF = new Integer(1);
        final Integer ON = new Integer(2);
        // [ID:0000559][Masahiko Higuchi] 2009/10 replace begin �����W�J���̐�������
        String[] times2 = null;
        int lowVersion = 0;
        // ��ł͂Ȃ��ꍇ
        if (paste != null && !paste.isEmpty()) {
            for (int j = 0; j < paste.size(); j++) {
                VRMap check = (VRMap) paste.get(j);
                // �O�̂��߃��[�v���ă`�F�b�N����
                lowVersion = CareServiceCommon.getServiceLowVersion(check);
                if (lowVersion != 0) {
                    break;
                }
            }
        }

        // ����21�N4���@�����Ή�
        // �ʏ����A�ʏ����n�r���A�F�m�ǑΉ��^�ʏ����̉h�{���P���Z�A���o�@�\������Z�𐧌�[����2��]
        times2 = new String[] { "1150112", "1150116", "1160114", "1160115",
                "1720105", "1720108" };

        // [ID:0000559][Masahiko Higuchi] 2009/10 replace end �����W�J���̐�������
        Collections.sort(paste, new ServiceDateComparator()); // DataComparator�ŏ���

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
     * �T�[�r�X�񋟓����ɃT�[�r�X����ёւ���
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
