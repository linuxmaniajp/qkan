package jp.nichicom.ac.component;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 * ロストフォーカスした選択セルの色を変更可能なリストセルレンダラです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/31
 */
public class ACFocusBrighterListCellRenderer extends
        DefaultListCellRenderer {
    /**
     * 色変更を行なわないことをあらわす着色定数です。
     */
    public static final int COLOR_NO_CHANGE = 0;
    /**
     * 選択背景色を淡白にすることをあらわす着色定数です。
     */
    public static final int COLOR_BRIGHTER = 1;
    /**
     * 未選択色と同じにすることをあらわす着色定数です。
     */
    public static final int COLOR_CLEAR = 2;

    private int lostFocusColorMode = COLOR_BRIGHTER;

    /**
     * フォーカスロストした選択セルの着色方法 を返します。
     * 
     * @return フォーカスロストした選択セルの着色方法
     * @see ACFocusBrighterListCellRenderer.COLOR_NO_CHANGE
     * @see ACFocusBrighterListCellRenderer.COLOR_BRIGHTER
     * @see ACFocusBrighterListCellRenderer.COLOR_CLEAR
     */
    public int getLostFocusColorMode() {
        return lostFocusColorMode;
    }

    /**
     * フォーカスロストした選択セルの着色方法 を設定します。
     * 
     * @param lostFocusColorMode フォーカスロストした選択セルの着色方法
     * @see ACFocusBrighterListCellRenderer.COLOR_NO_CHANGE
     * @see ACFocusBrighterListCellRenderer.COLOR_BRIGHTER
     * @see ACFocusBrighterListCellRenderer.COLOR_CLEAR
     */
    public void setLostFocusColorMode(int lostFocusColorMode) {
        this.lostFocusColorMode = lostFocusColorMode;
    }

    /**
     * コンストラクタです。
     */
    public ACFocusBrighterListCellRenderer() {
        super();
    }

    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
        Component cmp = super.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);
        if (cmp != null) {
            if ((list != null) && (isSelected) && (!list.hasFocus())) {
                // 選択セルでかつフォーカスがない
                switch (getLostFocusColorMode()) {
                case COLOR_BRIGHTER:
                    Color bg = cmp.getBackground();
                    if (bg != null) {
                        // 選択背景色を淡色表示とする。
                        cmp.setBackground(bg.brighter());
                    }
                    break;
                case COLOR_CLEAR:
                    cmp.setForeground(list.getForeground());
                    cmp.setBackground(list.getBackground());
                    break;
                }
            }
        }
        return cmp;
    }
}
