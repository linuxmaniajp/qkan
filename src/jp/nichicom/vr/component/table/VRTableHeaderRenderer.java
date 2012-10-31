/** TODO <HEAD> */
package jp.nichicom.vr.component.table;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import jp.nichicom.vr.image.VRArrowIcon;

/**
 * ソート方向を描画するテーブルヘッダ用のレンダラです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Yosuke Takemoto
 * @version 1.0 2005/12/01
 * @see DefaultTableCellRenderer
 * @see JTable
 * @see VRTableSortable
 * @see VRArrowIcon
 */
@SuppressWarnings("serial")
public class VRTableHeaderRenderer extends DefaultTableCellRenderer {
    private VRTableHeaderRendererAssistant assistant=new VRTableHeaderRendererAssistant();
    
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
                row, column);
        assistant.applyRenderer(this, table, value, isSelected, hasFocus, row, column);

        return this;
    }

}