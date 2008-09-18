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
 * サービス予定におけるサービス用のセルレンダラです。
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

    /**
     * パターンリストインスタンス を返します。
     * 
     * @return パターンリストインスタンス
     */
    public QS001DaySchedule getPatternList() {
        return patternList;
    }

    /**
     * パターンリストインスタンス を設定します。
     * 
     * @param patternList パターンリストインスタンス
     */
    public void setPatternList(QS001DaySchedule patternList) {
        this.patternList = patternList;
    }

    /**
     * サービスマスタ を返します。
     * 
     * @return サービスマスタ
     */
    public VRMap getMasterService() {
        return masterService;
    }

    /**
     * サービスマスタ を設定します。
     * 
     * @param serviceMaster サービスマスタ
     */
    public void setMasterService(VRMap serviceMaster) {
        this.masterService = serviceMaster;
    }

    /**
     * 開始日を表示するリストインスタンス を返します。
     * 
     * @return 開始日を表示するリストインスタンス
     */
    public QS001DaySchedule getUseBeginList() {
        return useBeginList;
    }

    /**
     * 開始日を表示するリストインスタンス を設定します。
     * 
     * @param useBeginList 開始日を表示するリストインスタンス
     */
    public void setUseBeginList(QS001DaySchedule useBeginList) {
        this.useBeginList = useBeginList;
    }

    /**
     * 期間を表示するリストインスタンス を返します。
     * 
     * @return 期間を表示するリストインスタンス
     */
    public QS001DaySchedule getUseSpanList() {
        return useSpanList;
    }

    /**
     * 期間を表示するリストインスタンス を設定します。
     * 
     * @param useSpanList 期間を表示するリストインスタンス
     */
    public void setUseSpanList(QS001DaySchedule useSpanList) {
        this.useSpanList = useSpanList;
    }

    /**
     * コンストラクタです。
     */
    public QS001ServicePatternListCellRenderer() {
        super();
        initComponent();
    }

    /**
     * コンポーネントを初期化します。
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
            //上位コントロールの取得
            parent = list.getParent();
            while (!(parent instanceof QS001DaySchedule)) {
                if (parent != null) {
                    parent = parent.getParent();
                } else {
                    break;
                }
            }
        }

        VRMap map = null;
        if (value instanceof VRMap) {

            map = (VRMap) value;
            try {
                // Map(レコード)すべてではなく説明だけを描画する
                String serviceKind = String.valueOf(VRBindPathParser.get(
                        "SYSTEM_SERVICE_KIND_DETAIL", map));

                Object service;
                if (getMasterService() != null) {
                    service = getMasterService().get(
                            ACCastUtilities.toInteger(serviceKind, 0));
                    if (service instanceof Map) {
                        if (parent == getPatternList()) {
                            // 2008/01/07 [Masahiko Higuchi] add - begin サービスパターン名称変更
                            // 変更後の名称が設定されている場合
                            if(((Map)value).containsKey("11")){
                                serviceKind = ACCastUtilities.toString(((Map) value)
                                        .get("11"),"");
                                
                            }else{
                            // 2008/01/07 [Masahiko Higuchi] add - end
                                // サービス名に置換
                                serviceKind = String.valueOf(((Map) service)
                                    .get("SERVICE_ABBREVIATION"));
                            // 2008/01/07 [Masahiko Higuchi] add - begin サービスパターン名称変更
                            }
                            // 2008/01/07 [Masahiko Higuchi] add - end
                        } else {
                            // サービスの略称名に置換
                            serviceKind = String.valueOf(((Map) service)
                                    .get("SERVICE_CALENDAR_ABBREVIATION"));
                        }
                    }
                }
                Object begin = VRBindPathParser.get("3", map);
                Object end = VRBindPathParser.get("4", map);
                if ((begin instanceof Date) && (end instanceof Date)) {
                    value = serviceKind + " " + formater.format((Date) begin)
                            + "-" + formater.format((Date) end);
                } else {
                    // 略称のみ
                    value = serviceKind;
                }

                if (CareServiceCommon.isWelfareEquipment(map)) {
                    // 福祉用具貸与の場合は道具を表示する
                    String itemBindPath;
                    if (CareServiceCommon.isPreventService(map)) {
                        itemBindPath = "1670101";
                    }else{
                        itemBindPath = "1170101";
                    }
                    value = value
                            + " "
                            + QkanWelfareToolFormat.getInstance().format(
                                    VRBindPathParser.get(itemBindPath, map));
                }
                // パターンリストである場合のみ番号を表示する。
                if (parent == getPatternList()) {
                    // 採番済みである場合は表示処理
                    if(VRBindPathParser.has("10",map)){
                        value = VRBindPathParser.get("10",map) + " - " + value;
                    }
                }

            } catch (ParseException e) {
            }
        }

        Component comp = super.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);

        if (parent != null) {
//          表示形式に応じてコントロールのVisibleを切り替える
                        try {
                if (parent == getUseBeginList()) {
                    String wday = "";
                    String spans = "";
                    if (map != null) {
                        // サービス開始日と期間を取得

                        wday = QkanServiceBeginDayFormat.getInstance().format(
                                VRBindPathParser.get("WEEK_DAY", map));
                        if ((wday != null) && (!"".equals(wday))) {
                            wday = wday + " から";
                        }
                        spans = QkanServiceSpanFormat
                                .getInstance()
                                .format(
                                        VRBindPathParser
                                                .get(
                                                        QkanConstants.SERVICE_SYSTEM_BIND_PATH_SPAN,
                                                        map));
                        if ((spans != null) && (!"".equals(spans))
                                && (!"末迄".equals(spans))) {
                            spans = spans + "日間";
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
                        // サービス期間を取得
                        spans = QkanServiceSpanFormat
                                .getInstance()
                                .format(
                                        VRBindPathParser
                                                .get(
                                                        QkanConstants.SERVICE_SYSTEM_BIND_PATH_SPAN,
                                                        map));
                        if ((spans != null) && (!"".equals(spans))
                                && (!"末迄".equals(spans))) {
                            spans = spans + "日間";
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
