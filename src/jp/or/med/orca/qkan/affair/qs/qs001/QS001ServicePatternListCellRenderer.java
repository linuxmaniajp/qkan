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
    // [ID:0000444][Tozo TANAKA] 2009/03/14 add begin 平成21年4月法改正対応
    private Date targetDate;
    // [ID:0000444][Tozo TANAKA] 2009/03/14 add end
    // [ID:0000472][Masahiko Higuchi] 2009/04 add begin 平成21年4月法改正対応
    private int processType;
    // [ID:0000472][Masahiko Higuchi] 2009/04 add end

    // 2009/01/13 [Mizuki Tsutsumi] : add begin / カレンダーの色変更
    // Color[] COLOR_ARRAY = {
    // (未選択・前), (未選択・後),
    // (選択＆フォーカスなし・前), (選択＆フォーカスなし・後),
    // (選択＆フォーカスあり・前), (選択＆フォーカスあり・後)}
    // →null指定で着色なし（色の変更はなし）

    // 自己負担時
    private final Color[] COLOR_ARRAY_OF_REGULATION_RATE = {
            new Color(160, 40, 40), null, new Color(255, 255, 255),
            new Color(228, 57, 57), // HSV = (0, 75, 89.5)
            new Color(255, 255, 255), new Color(160, 40, 40) // HSV = (0, 75,
                                                             // 63)
    };
    // 2009/01/13 [Mizuki Tsutsumi] : end begin

    // [ID:0000444][Tozo TANAKA] 2009/03/14 add begin 平成21年4月法改正対応
    private final Color[] COLOR_ARRAY_OF_INVALID_LOW = { null,
            new Color(230, 230, 230), null, new Color(128, 128, 128), null,
            new Color(77, 77, 77) };

    // [ID:0000444][Tozo TANAKA] 2009/03/14 add end
    
    // 特定診療費・特別療養費にチェックを付けている場合
    private final Color[] COLOR_ARRAY_OF_MEDICAL = {
            new Color(51,0, 255), null, // (未選択・前), (未選択・後),
            new Color(255, 255, 255), new Color(51, 0, 255), // (選択＆フォーカスなし・前), (選択＆フォーカスなし・後),
            new Color(255, 255, 255), new Color(51, 0, 153) // (選択＆フォーカスあり・前), (選択＆フォーカスあり・後)
    };
    
    // 特定診療費・特別療養費にチェックを付けていて、かつ自己負担が発生しているとき
    private final Color[] COLOR_ARRAY_OF_MEDICAL_WITH_REGULATION_RATE = {
            new Color(102, 0, 102), null, // (未選択・前), (未選択・後),
            new Color(255, 255, 255), new Color(153, 51, 204), // (選択＆フォーカスなし・前), (選択＆フォーカスなし・後),
            new Color(255, 255, 255), new Color(153, 0, 153) // (選択＆フォーカスあり・前), (選択＆フォーカスあり・後)
    };

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
            // 上位コントロールの取得
            parent = list.getParent();
            while (!(parent instanceof QS001DaySchedule)) {
                if (parent != null) {
                    parent = parent.getParent();
                } else {
                    break;
                }
            }
        }

        // 2009/01/13 [Mizuki Tsutsumi] : add begin / カレンダー色変更（のためのフラグ）
        boolean hasRegulationRate = false;
        // 2009/01/13 [Mizuki Tsutsumi] : add end
        // [ID:0000444][Tozo TANAKA] 2009/03/14 add begin 平成21年4月法改正対応
        boolean isInvalidLowVersion = false;
        
        // 特定診療費、特別療養費の情報を保持しているか
        boolean isMedical = false;

        // 対象年月の法改正区分
        int targetLowVer = 0;
        // [H27.4改正対応][Shinobu Hitaka] 2015/02/20 edit begin 平成27年4月の初期設定対応
//        if (getTargetDate() != null) {
//            if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2404,
//                    getTargetDate()) < 1) {
//                // 平成24年4月以降
//                targetLowVer = QkanConstants.SERVICE_LOW_VERSION_H2404;
//            }
//        }
        if (getTargetDate() != null) {
            if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2704,
                    getTargetDate()) < 1) {
                // 平成27年4月以降
                targetLowVer = QkanConstants.SERVICE_LOW_VERSION_H2704;
            }
        }
        // [H27.4改正対応][Shinobu Hitaka] 2015/02/20 edit end
        
        // [ID:0000444][Tozo TANAKA] 2009/03/14 add end

        VRMap map = null;
        if (value instanceof VRMap) {

            map = (VRMap) value;
            try {
                // 2009/01/13 [Mizuki Tsutsumi] : add begin / カレンダー色変更（自己負担時）
                int regulationRate = ACCastUtilities.toInt(
                        (VRBindPathParser.get("REGULATION_RATE", map)), 0);
                if (regulationRate > 0) {
                    hasRegulationRate = true;
                }

                // [ID:0000560][Masahiko Higuchi] 2009/10 add begin
                // 不正表示機能の対応漏れに対応（位置を移動）
                String serviceKind = String.valueOf(VRBindPathParser.get(
                        "SYSTEM_SERVICE_KIND_DETAIL", map));
                // [ID:0000560][Masahiko Higuchi] 2009/10 add end

                // 2009/01/13 [Mizuki Tsutsumi] : add end
                // [ID:0000444][Tozo TANAKA] 2009/03/14 add begin 平成21年4月法改正対応
                // レコードの法改正区分を取得する。
                int mapLowVer = CareServiceCommon.getServiceLowVersion(map);

                // [ID:0000560][Masahiko Higuchi] 2009/10 edit begin
                // 不正表示機能の対応漏れに対応
                // その他、主な日常生活上の活動を除外する
                if (mapLowVer != targetLowVer && !"90101".equals(serviceKind)
                        && !"90201".equals(serviceKind)) {
                    // [ID:0000560][Masahiko Higuchi] 2009/10 edit end
                    // 不正表示機能の対応漏れに対応

                    // 対象年月の法改正区分とレコードの法改正区分が異なる場合
                    // 不正な法改正区分を表すフラグisInvalidLowVersionを真(true)にする。
                    isInvalidLowVersion = true;
                }
                // [ID:0000444][Tozo TANAKA] 2009/03/14 add end
                // [ID:0000560][Masahiko Higuchi] 2009/10 del begin
                // 不正表示機能の対応漏れに対応
                // Map(レコード)すべてではなく説明だけを描画する
                // String serviceKind =
                // String.valueOf(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL",
                // map));
                // [ID:0000560][Masahiko Higuchi] 2009/10 del end
                
                
                // 特定診療費、特別療養費の情報があるか確認
                isMedical = hasMedicalData(map);
                
                Object service;
                if (getMasterService() != null) {
                    service = getMasterService().get(
                            ACCastUtilities.toInteger(serviceKind, 0));
                    if (service instanceof Map) {
                        if (parent == getPatternList()) {
                            // 2008/01/07 [Masahiko Higuchi] add - begin
                            // サービスパターン名称変更
                            // 変更後の名称が設定されている場合
                            if (((Map) value).containsKey("11")) {
                                serviceKind = ACCastUtilities.toString(
                                        ((Map) value).get("11"), "");

                            } else {
                                // 2008/01/07 [Masahiko Higuchi] add - end
                                // サービス名に置換
                                serviceKind = String.valueOf(((Map) service)
                                        .get("SERVICE_ABBREVIATION"));
                                // 2008/01/07 [Masahiko Higuchi] add - begin
                                // サービスパターン名称変更
                            }
                            // 2008/01/07 [Masahiko Higuchi] add - end
                        } else {
                            // サービスの略称名に置換
                            serviceKind = String.valueOf(((Map) service)
                                    .get("SERVICE_CALENDAR_ABBREVIATION"));

                            // 2009/01/15 [Mizuki Tsutsumi] : add begin /
                            // 訪問介護のとき、訪問種別も表示名に追加
                            // 利用票・計画表や事業所情報で文言を使用しているため個別書き換えで対応する。
                            String serviceCodeKind = ACCastUtilities.toString(
                                    ((Map) service).get("SERVICE_CODE_KIND"),
                                    "");
                            if (serviceCodeKind.equals("11")) {
                                int homonShubetsu = ACCastUtilities.toInt(
                                        (VRBindPathParser.get("1110101", map)),
                                        0);
                                switch (homonShubetsu) {
                                case 1:
                                    serviceKind = "身体介護";
                                    break;
                                case 2:
                                    serviceKind = "生活援助";
                                    break;
                                case 3:
                                    serviceKind = "身体生活";
                                    break;
                                case 4:
                                    serviceKind = "乗降介助";
                                    break;
                                }

                            } else if (serviceCodeKind.equals("13")) {
                                serviceKind = "訪看";

                            } else if ("31".equals(serviceCodeKind)) {
                                serviceKind = "居宅療養";

                                // [ID:0000442][Masahiko Higuchi] 2009/04 edit
                                // begin V545出荷後対応
                            } else if ("63".equals(serviceCodeKind)) {
                                serviceKind = "予訪看";

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
                    // 略称のみ
                    value = serviceKind;
                }

                if (CareServiceCommon.isWelfareEquipment(map)) {
                    // 福祉用具貸与の場合は道具を表示する
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
                // パターンリストである場合のみ番号を表示する。
                if (parent == getPatternList()) {
                    // 採番済みである場合は表示処理
                    if (VRBindPathParser.has("10", map)) {
                        value = VRBindPathParser.get("10", map) + " - " + value;
                    }
                }
            } catch (ParseException e) {
            }
        }

        Component comp = super.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);

        // [ID:0000472][Masahiko Higuchi] 2009/04 edit begin 平成21年4月法改正対応
        // TODO
        if (getProcessType() == QkanConstants.PROCESS_TYPE_PLAN) {
            // 2009/01/13 [Mizuki Tsutsumi] : add begin / カレンダーの色を変える
            // 自己負担時
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
        // [ID:0000444][Tozo TANAKA] 2009/03/14 add begin 平成21年4月法改正対応
        // [ID:0000472][Masahiko Higuchi] 2009/04 edit end
        if (isInvalidLowVersion) {
            // 不正な法改正区分を表すフラグisInvalidLowVersionが真(true)の場合
            // レンダラの背景色を不正な法改正区分色に変更する。
            setComponentColor(comp, isSelected, cellHasFocus,
                    COLOR_ARRAY_OF_INVALID_LOW);
        }
        // [ID:0000444][Tozo TANAKA] 2009/03/14 add end
        

        if (parent != null) {
            // 表示形式に応じてコントロールのVisibleを切り替える
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
                                .format(VRBindPathParser
                                        .get(QkanConstants.SERVICE_SYSTEM_BIND_PATH_SPAN,
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
                                .format(VRBindPathParser
                                        .get(QkanConstants.SERVICE_SYSTEM_BIND_PATH_SPAN,
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

    // 2009/01/15 [Mizuki Tsutsumi] : add begin
    /**
     * カレンダー項目の色を変更
     * 
     * @param comp カレンダーの項目
     * @param isSelected 選択有無
     * @param cellHasFocus フォーカス有無
     * @param colorArray 色情報配列
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

    // [ID:0000444][Tozo TANAKA] 2009/03/14 add begin 平成21年4月法改正対応
    /**
     * 対象年月 を返します。
     * 
     * @return 対象年月
     */
    public Date getTargetDate() {
        return targetDate;
    }

    /**
     * 対象年月 を設定します。
     * 
     * @param targetDate 対象年月
     */
    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    // [ID:0000444][Tozo TANAKA] 2009/03/14 add end

    // [ID:0000472][Masahiko Higuchi] 2009/04 add begin 平成21年4月法改正対応
    /**
     * 現在処理中のモードを取得します。
     */
    public int getProcessType() {
        return this.processType;
    }

    /**
     * 現在処理中のモードを設定します。
     * 
     * @param processType 処理モード
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
