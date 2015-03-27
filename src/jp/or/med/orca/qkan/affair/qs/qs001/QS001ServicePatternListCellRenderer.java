package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JList;
import javax.swing.SwingConstants;

import jp.nichicom.ac.component.ACFocusSharedListCellRenderer;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.util.ACDateUtilities;
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
    private QS001DaySchedule patternList;
    private VRMap masterService;
    // [ID:0000444][Tozo TANAKA] 2009/03/14 add begin ����21�N4���@�����Ή�
    private Date targetDate;
    // [ID:0000444][Tozo TANAKA] 2009/03/14 add end
    // [ID:0000472][Masahiko Higuchi] 2009/04 add begin ����21�N4���@�����Ή�
    private int processType;
    // [ID:0000472][Masahiko Higuchi] 2009/04 add end

    // 2009/01/13 [Mizuki Tsutsumi] : add begin / �J�����_�[�̐F�ύX
    // Color[] COLOR_ARRAY = {
    // (���I���E�O), (���I���E��),
    // (�I�����t�H�[�J�X�Ȃ��E�O), (�I�����t�H�[�J�X�Ȃ��E��),
    // (�I�����t�H�[�J�X����E�O), (�I�����t�H�[�J�X����E��)}
    // ��null�w��Œ��F�Ȃ��i�F�̕ύX�͂Ȃ��j

    // ���ȕ��S��
    private final Color[] COLOR_ARRAY_OF_REGULATION_RATE = {
            new Color(160, 40, 40), null, new Color(255, 255, 255),
            new Color(228, 57, 57), // HSV = (0, 75, 89.5)
            new Color(255, 255, 255), new Color(160, 40, 40) // HSV = (0, 75,
                                                             // 63)
    };
    // 2009/01/13 [Mizuki Tsutsumi] : end begin

    // [ID:0000444][Tozo TANAKA] 2009/03/14 add begin ����21�N4���@�����Ή�
    private final Color[] COLOR_ARRAY_OF_INVALID_LOW = { null,
            new Color(230, 230, 230), null, new Color(128, 128, 128), null,
            new Color(77, 77, 77) };

    // [ID:0000444][Tozo TANAKA] 2009/03/14 add end
    
    // ����f�Ô�E���ʗ×{��Ƀ`�F�b�N��t���Ă���ꍇ
    private final Color[] COLOR_ARRAY_OF_MEDICAL = {
            new Color(51,0, 255), null, // (���I���E�O), (���I���E��),
            new Color(255, 255, 255), new Color(51, 0, 255), // (�I�����t�H�[�J�X�Ȃ��E�O), (�I�����t�H�[�J�X�Ȃ��E��),
            new Color(255, 255, 255), new Color(51, 0, 153) // (�I�����t�H�[�J�X����E�O), (�I�����t�H�[�J�X����E��)
    };
    
    // ����f�Ô�E���ʗ×{��Ƀ`�F�b�N��t���Ă��āA�����ȕ��S���������Ă���Ƃ�
    private final Color[] COLOR_ARRAY_OF_MEDICAL_WITH_REGULATION_RATE = {
            new Color(102, 0, 102), null, // (���I���E�O), (���I���E��),
            new Color(255, 255, 255), new Color(153, 51, 204), // (�I�����t�H�[�J�X�Ȃ��E�O), (�I�����t�H�[�J�X�Ȃ��E��),
            new Color(255, 255, 255), new Color(153, 0, 153) // (�I�����t�H�[�J�X����E�O), (�I�����t�H�[�J�X����E��)
    };

    /**
     * �p�^�[�����X�g�C���X�^���X ��Ԃ��܂��B
     * 
     * @return �p�^�[�����X�g�C���X�^���X
     */
    public QS001DaySchedule getPatternList() {
        return patternList;
    }

    /**
     * �p�^�[�����X�g�C���X�^���X ��ݒ肵�܂��B
     * 
     * @param patternList �p�^�[�����X�g�C���X�^���X
     */
    public void setPatternList(QS001DaySchedule patternList) {
        this.patternList = patternList;
    }

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

        Container parent = null;
        if (list != null) {
            // ��ʃR���g���[���̎擾
            parent = list.getParent();
            while (!(parent instanceof QS001DaySchedule)) {
                if (parent != null) {
                    parent = parent.getParent();
                } else {
                    break;
                }
            }
        }

        // 2009/01/13 [Mizuki Tsutsumi] : add begin / �J�����_�[�F�ύX�i�̂��߂̃t���O�j
        boolean hasRegulationRate = false;
        // 2009/01/13 [Mizuki Tsutsumi] : add end
        // [ID:0000444][Tozo TANAKA] 2009/03/14 add begin ����21�N4���@�����Ή�
        boolean isInvalidLowVersion = false;
        
        // ����f�Ô�A���ʗ×{��̏���ێ����Ă��邩
        boolean isMedical = false;

        // �Ώ۔N���̖@�����敪
        int targetLowVer = 0;
        // [H27.4�����Ή�][Shinobu Hitaka] 2015/02/20 edit begin ����27�N4���̏����ݒ�Ή�
//        if (getTargetDate() != null) {
//            if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2404,
//                    getTargetDate()) < 1) {
//                // ����24�N4���ȍ~
//                targetLowVer = QkanConstants.SERVICE_LOW_VERSION_H2404;
//            }
//        }
        if (getTargetDate() != null) {
            if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2704,
                    getTargetDate()) < 1) {
                // ����27�N4���ȍ~
                targetLowVer = QkanConstants.SERVICE_LOW_VERSION_H2704;
            }
        }
        // [H27.4�����Ή�][Shinobu Hitaka] 2015/02/20 edit end
        
        // [ID:0000444][Tozo TANAKA] 2009/03/14 add end

        VRMap map = null;
        if (value instanceof VRMap) {

            map = (VRMap) value;
            try {
                // 2009/01/13 [Mizuki Tsutsumi] : add begin / �J�����_�[�F�ύX�i���ȕ��S���j
                int regulationRate = ACCastUtilities.toInt(
                        (VRBindPathParser.get("REGULATION_RATE", map)), 0);
                if (regulationRate > 0) {
                    hasRegulationRate = true;
                }

                // [ID:0000560][Masahiko Higuchi] 2009/10 add begin
                // �s���\���@�\�̑Ή��R��ɑΉ��i�ʒu���ړ��j
                String serviceKind = String.valueOf(VRBindPathParser.get(
                        "SYSTEM_SERVICE_KIND_DETAIL", map));
                // [ID:0000560][Masahiko Higuchi] 2009/10 add end

                // 2009/01/13 [Mizuki Tsutsumi] : add end
                // [ID:0000444][Tozo TANAKA] 2009/03/14 add begin ����21�N4���@�����Ή�
                // ���R�[�h�̖@�����敪���擾����B
                int mapLowVer = CareServiceCommon.getServiceLowVersion(map);

                // [ID:0000560][Masahiko Higuchi] 2009/10 edit begin
                // �s���\���@�\�̑Ή��R��ɑΉ�
                // ���̑��A��ȓ��퐶����̊��������O����
                if (mapLowVer != targetLowVer && !"90101".equals(serviceKind)
                        && !"90201".equals(serviceKind)) {
                    // [ID:0000560][Masahiko Higuchi] 2009/10 edit end
                    // �s���\���@�\�̑Ή��R��ɑΉ�

                    // �Ώ۔N���̖@�����敪�ƃ��R�[�h�̖@�����敪���قȂ�ꍇ
                    // �s���Ȗ@�����敪��\���t���OisInvalidLowVersion��^(true)�ɂ���B
                    isInvalidLowVersion = true;
                }
                // [ID:0000444][Tozo TANAKA] 2009/03/14 add end
                // [ID:0000560][Masahiko Higuchi] 2009/10 del begin
                // �s���\���@�\�̑Ή��R��ɑΉ�
                // Map(���R�[�h)���ׂĂł͂Ȃ�����������`�悷��
                // String serviceKind =
                // String.valueOf(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL",
                // map));
                // [ID:0000560][Masahiko Higuchi] 2009/10 del end
                
                
                // ����f�Ô�A���ʗ×{��̏�񂪂��邩�m�F
                isMedical = hasMedicalData(map);
                
                Object service;
                if (getMasterService() != null) {
                    service = getMasterService().get(
                            ACCastUtilities.toInteger(serviceKind, 0));
                    if (service instanceof Map) {
                        if (parent == getPatternList()) {
                            // 2008/01/07 [Masahiko Higuchi] add - begin
                            // �T�[�r�X�p�^�[�����̕ύX
                            // �ύX��̖��̂��ݒ肳��Ă���ꍇ
                            if (((Map) value).containsKey("11")) {
                                serviceKind = ACCastUtilities.toString(
                                        ((Map) value).get("11"), "");

                            } else {
                                // 2008/01/07 [Masahiko Higuchi] add - end
                                // �T�[�r�X���ɒu��
                                serviceKind = String.valueOf(((Map) service)
                                        .get("SERVICE_ABBREVIATION"));
                                // 2008/01/07 [Masahiko Higuchi] add - begin
                                // �T�[�r�X�p�^�[�����̕ύX
                            }
                            // 2008/01/07 [Masahiko Higuchi] add - end
                        } else {
                            // �T�[�r�X�̗��̖��ɒu��
                            serviceKind = String.valueOf(((Map) service)
                                    .get("SERVICE_CALENDAR_ABBREVIATION"));

                            // 2009/01/15 [Mizuki Tsutsumi] : add begin /
                            // �K����̂Ƃ��A�K���ʂ��\�����ɒǉ�
                            // ���p�[�E�v��\�⎖�Ə����ŕ������g�p���Ă��邽�ߌʏ��������őΉ�����B
                            String serviceCodeKind = ACCastUtilities.toString(
                                    ((Map) service).get("SERVICE_CODE_KIND"),
                                    "");
                            if (serviceCodeKind.equals("11")) {
                                int homonShubetsu = ACCastUtilities.toInt(
                                        (VRBindPathParser.get("1110101", map)),
                                        0);
                                switch (homonShubetsu) {
                                case 1:
                                    serviceKind = "�g�̉��";
                                    break;
                                case 2:
                                    serviceKind = "��������";
                                    break;
                                case 3:
                                    serviceKind = "�g�̐���";
                                    break;
                                case 4:
                                    serviceKind = "��~�";
                                    break;
                                }

                            } else if (serviceCodeKind.equals("13")) {
                                serviceKind = "�K��";

                            } else if ("31".equals(serviceCodeKind)) {
                                serviceKind = "����×{";

                                // [ID:0000442][Masahiko Higuchi] 2009/04 edit
                                // begin V545�o�׌�Ή�
                            } else if ("63".equals(serviceCodeKind)) {
                                serviceKind = "�\�K��";

                            }
                            // [ID:0000442][Masahiko Higuchi] 2009/04 edit end

                            // 2009/01/15 [Mizuki Tsutsumi] : add end
                        }
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
                    String itemBindPath;
                    if (CareServiceCommon.isPreventService(map)) {
                        itemBindPath = "1670101";
                    } else {
                        itemBindPath = "1170101";
                    }
                    value = value
                            + " "
                            + QkanWelfareToolFormat.getInstance().format(
                                    VRBindPathParser.get(itemBindPath, map));
                }
                // �p�^�[�����X�g�ł���ꍇ�̂ݔԍ���\������B
                if (parent == getPatternList()) {
                    // �̔ԍς݂ł���ꍇ�͕\������
                    if (VRBindPathParser.has("10", map)) {
                        value = VRBindPathParser.get("10", map) + " - " + value;
                    }
                }
            } catch (ParseException e) {
            }
        }

        Component comp = super.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);

        // [ID:0000472][Masahiko Higuchi] 2009/04 edit begin ����21�N4���@�����Ή�
        // TODO
        if (getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
            // 2009/01/13 [Mizuki Tsutsumi] : add begin / �J�����_�[�̐F��ς���
            // ���ȕ��S��
            if (hasRegulationRate && isMedical) {
                setComponentColor(comp, isSelected, cellHasFocus, COLOR_ARRAY_OF_MEDICAL_WITH_REGULATION_RATE);
            } else if (hasRegulationRate) {
                setComponentColor(comp, isSelected, cellHasFocus, COLOR_ARRAY_OF_REGULATION_RATE);
            } else if (isMedical) {
                setComponentColor(comp, isSelected, cellHasFocus, COLOR_ARRAY_OF_MEDICAL);
            }
            // 2009/01/13 [Mizuki Tsutsumi] : add end
        } else {
            if (isMedical) {
                setComponentColor(comp, isSelected, cellHasFocus, COLOR_ARRAY_OF_MEDICAL);
            }
        }
        // [ID:0000444][Tozo TANAKA] 2009/03/14 add begin ����21�N4���@�����Ή�
        // [ID:0000472][Masahiko Higuchi] 2009/04 edit end
        if (isInvalidLowVersion) {
            // �s���Ȗ@�����敪��\���t���OisInvalidLowVersion���^(true)�̏ꍇ
            // �����_���̔w�i�F��s���Ȗ@�����敪�F�ɕύX����B
            setComponentColor(comp, isSelected, cellHasFocus,
                    COLOR_ARRAY_OF_INVALID_LOW);
        }
        // [ID:0000444][Tozo TANAKA] 2009/03/14 add end
        

        if (parent != null) {
            // �\���`���ɉ����ăR���g���[����Visible��؂�ւ���
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
                                .format(VRBindPathParser
                                        .get(QkanConstants.SERVICE_SYSTEM_BIND_PATH_SPAN,
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
                                .format(VRBindPathParser
                                        .get(QkanConstants.SERVICE_SYSTEM_BIND_PATH_SPAN,
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

    // 2009/01/15 [Mizuki Tsutsumi] : add begin
    /**
     * �J�����_�[���ڂ̐F��ύX
     * 
     * @param comp �J�����_�[�̍���
     * @param isSelected �I��L��
     * @param cellHasFocus �t�H�[�J�X�L��
     * @param colorArray �F���z��
     */
    protected void setComponentColor(Component comp, boolean isSelected,
            boolean cellHasFocus, Color[] colorArray) {
        if (colorArray.length != 6) {
            return;
        }

        if (isSelected) {
            if (cellHasFocus) {
                if (colorArray[4] != null) {
                    comp.setForeground(colorArray[4]);
                }
                if (colorArray[5] != null) {
                    comp.setBackground(colorArray[5]);
                }
            } else {
                if (colorArray[2] != null) {
                    comp.setForeground(colorArray[2]);
                }
                if (colorArray[3] != null) {
                    comp.setBackground(colorArray[3]);
                }
            }
        } else {
            if (colorArray[0] != null) {
                comp.setForeground(colorArray[0]);
            }
            if (colorArray[1] != null) {
                comp.setBackground(colorArray[1]);
            }
        }
    }

    // 2009/01/15 [Mizuki Tsutsumi] : add end

    // [ID:0000444][Tozo TANAKA] 2009/03/14 add begin ����21�N4���@�����Ή�
    /**
     * �Ώ۔N�� ��Ԃ��܂��B
     * 
     * @return �Ώ۔N��
     */
    public Date getTargetDate() {
        return targetDate;
    }

    /**
     * �Ώ۔N�� ��ݒ肵�܂��B
     * 
     * @param targetDate �Ώ۔N��
     */
    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    // [ID:0000444][Tozo TANAKA] 2009/03/14 add end

    // [ID:0000472][Masahiko Higuchi] 2009/04 add begin ����21�N4���@�����Ή�
    /**
     * ���ݏ������̃��[�h���擾���܂��B
     */
    public int getProcessType() {
        return this.processType;
    }

    /**
     * ���ݏ������̃��[�h��ݒ肵�܂��B
     * 
     * @param processType �������[�h
     */
    public void setProcessType(int processType) {
        this.processType = processType;
    }
    // [ID:0000472][Masahiko Higuchi] 2009/04 add end
    
    
    private boolean hasMedicalData(VRMap map) {
        
        Iterator it = map.keySet().iterator();
        while(it.hasNext()) {
            String key = ACCastUtilities.toString(it.next(), "");
            if (key.startsWith("3010") && key.length() == 7){
                return true; 
            }
        }
        return false;
    }

}
