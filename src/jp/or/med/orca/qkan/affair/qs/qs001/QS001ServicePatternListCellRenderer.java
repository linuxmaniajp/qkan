package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.swing.JList;
import javax.swing.SwingConstants;

import jp.nichicom.ac.component.ACFocusSharedListCellRenderer;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.text.QkanServiceBeginDayFormat;
import jp.or.med.orca.qkan.text.QkanServiceSpanFormat;
import jp.or.med.orca.qkan.text.QkanWelfareToolFormat;

/**
 * �T�[�r�X�\��ɂ�����T�[�r�X�p�̃Z�������_���ł��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/01/08
 */
public class QS001ServicePatternListCellRenderer extends
        ACFocusSharedListCellRenderer {
    private SimpleDateFormat formater = new SimpleDateFormat("HH:mm");

    private ACPanel contents;
    private ACLabel begin;
    private ACLabel span;
    private QS001DaySchedule useBeginList;
    private QS001DaySchedule useSpanList;
    private VRMap masterService;

    /**
     * �T�[�r�X�}�X�^ ��Ԃ��܂��B
     * 
     * @return �T�[�r�X�}�X�^
     */
    public VRMap getMasterService() {
        return masterService;
    }

    /**
     * �T�[�r�X�}�X�^ ��ݒ肵�܂��B
     * 
     * @param serviceMaster �T�[�r�X�}�X�^
     */
    public void setMasterService(VRMap serviceMaster) {
        this.masterService = serviceMaster;
    }

    /**
     * �J�n����\�����郊�X�g�C���X�^���X ��Ԃ��܂��B
     * 
     * @return �J�n����\�����郊�X�g�C���X�^���X
     */
    public QS001DaySchedule getUseBeginList() {
        return useBeginList;
    }

    /**
     * �J�n����\�����郊�X�g�C���X�^���X ��ݒ肵�܂��B
     * 
     * @param useBeginList �J�n����\�����郊�X�g�C���X�^���X
     */
    public void setUseBeginList(QS001DaySchedule useBeginList) {
        this.useBeginList = useBeginList;
    }

    /**
     * ���Ԃ�\�����郊�X�g�C���X�^���X ��Ԃ��܂��B
     * 
     * @return ���Ԃ�\�����郊�X�g�C���X�^���X
     */
    public QS001DaySchedule getUseSpanList() {
        return useSpanList;
    }

    /**
     * ���Ԃ�\�����郊�X�g�C���X�^���X ��ݒ肵�܂��B
     * 
     * @param useSpanList ���Ԃ�\�����郊�X�g�C���X�^���X
     */
    public void setUseSpanList(QS001DaySchedule useSpanList) {
        this.useSpanList = useSpanList;
    }

    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001ServicePatternListCellRenderer() {
        super();
        initComponent();
    }

    /**
     * �R���|�[�l���g�����������܂��B
     */
    protected void initComponent() {
        contents = new ACPanel();
        begin = new ACLabel();
        span = new ACLabel();
        begin.setColumns(6);
        span.setColumns(5);
        begin.setHorizontalAlignment(SwingConstants.RIGHT);
        span.setHorizontalAlignment(SwingConstants.CENTER);
        begin.setOpaque(true);
        span.setOpaque(true);
        this.setOpaque(true);
        begin.setPreferredSize(new Dimension(100, 10));
        span.setPreferredSize(new Dimension(60, 10));

        contents.add(span, VRLayout.EAST);
        contents.add(begin, VRLayout.EAST);
        contents.add(this, VRLayout.CLIENT);
    }

    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
        VRMap map = null;
        if (value instanceof VRMap) {

            map = (VRMap) value;
            try {
                // Map(���R�[�h)���ׂĂł͂Ȃ�����������`�悷��
                String serviceKind = String.valueOf(VRBindPathParser.get(
                        "SYSTEM_SERVICE_KIND_DETAIL", map));

                Object service;
                if (getMasterService() != null) {
                    service = getMasterService().get(
                            ACCastUtilities.toInteger(serviceKind, 0));
                    if (service instanceof Map) {
                        // �T�[�r�X�̗��̖��ɒu��
                        serviceKind = String.valueOf(((Map) service)
                                .get("SERVICE_CALENDAR_ABBREVIATION"));
                    }
                }
                Object begin = VRBindPathParser.get("3", map);
                Object end = VRBindPathParser.get("4", map);
                if ((begin instanceof Date) && (end instanceof Date)) {
                    value = serviceKind + " " + formater.format((Date) begin)
                            + "-" + formater.format((Date) end);
                } else {
                    // ���̂̂�
                    value = serviceKind;
                }

                if (CareServiceCommon.isWelfareEquipment(map)) {
                    // �����p��ݗ^�̏ꍇ�͓����\������
                    value = value
                            + " "
                            + QkanWelfareToolFormat.getInstance().format(
                                    VRBindPathParser.get("1170101", map));
                }

            } catch (ParseException e) {
            }
        }

        Component comp = super.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);

        if (list != null) {
            // �\���`���ɉ����ăR���g���[����Visible��؂�ւ���
            Container parent = list.getParent();
            while (!(parent instanceof QS001DaySchedule)) {
                if (parent != null) {
                    parent = parent.getParent();
                } else {
                    break;
                }
            }
            try {
                if (parent == getUseBeginList()) {
                    String wday = "";
                    String spans = "";
                    if (map != null) {
                        // �T�[�r�X�J�n���Ɗ��Ԃ��擾

                        wday = QkanServiceBeginDayFormat.getInstance().format(
                                VRBindPathParser.get("WEEK_DAY", map));
                        if ((wday != null) && (!"".equals(wday))) {
                            wday = wday + " ����";
                        }
                        spans = QkanServiceSpanFormat
                                .getInstance()
                                .format(
                                        VRBindPathParser
                                                .get(
                                                        QkanConstants.SERVICE_SYSTEM_BIND_PATH_SPAN,
                                                        map));
                        if ((spans != null) && (!"".equals(spans))
                                && (!"����".equals(spans))) {
                            spans = spans + "����";
                        }
                    }
                    this.begin.setText(wday);
                    this.span.setText(spans);

                    begin.setBackground(comp.getBackground());
                    begin.setForeground(comp.getForeground());
                    span.setBackground(comp.getBackground());
                    span.setForeground(comp.getForeground());
                    span.setVisible(true);
                    begin.setVisible(true);
                } else if (parent == getUseSpanList()) {
                    String spans = "";
                    if (map != null) {
                        // �T�[�r�X���Ԃ��擾
                        spans = QkanServiceSpanFormat
                                .getInstance()
                                .format(
                                        VRBindPathParser
                                                .get(
                                                        QkanConstants.SERVICE_SYSTEM_BIND_PATH_SPAN,
                                                        map));
                        if ((spans != null) && (!"".equals(spans))
                                && (!"����".equals(spans))) {
                            spans = spans + "����";
                        }
                    }
                    this.span.setText(spans);

                    span.setBackground(comp.getBackground());
                    span.setForeground(comp.getForeground());
                    span.setVisible(true);
                    begin.setVisible(false);
                } else {
                    span.setVisible(false);
                    begin.setVisible(false);
                    // return comp;
                }
            } catch (ParseException e) {
            }
        }
        return contents;

    }
}
