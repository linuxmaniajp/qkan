package jp.or.med.orca.qkan.affair.qp.qp003;

import java.awt.FontMetrics;

import javax.swing.JViewport;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import jp.nichicom.ac.component.table.ACCellStylizableTable;
import jp.nichicom.ac.component.table.ACTable;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.component.table.VRTablar;

/**
 * Project code name "ORCA"
 * 給付管理台帳ソフト QKANCHO（JMA care benefit management software）
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
 * アプリ: QKANCHO
 * 開発者: 樋口　雅彦
 * 作成日: 2009  日本コンピューター株式会社 樋口 雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 請求処理 (003)
 * プログラム 利用者向け請求書詳細編集 (QP003ResultCalendarTable)
 * @since V5.4.9
 *
 *****************************************************************
 */
public class QP003ResultCalendarTable extends ACTable {
    
    protected VRTablar createTable() {
        return new ACCellStylizableTable(){
            public void doExtendLastColumn() {
                if (isExtendLastColumn()) {
                    if (getParent() != null && getParent() instanceof JViewport) {
                        int viewWidth = ((JViewport) getParent()).getExtentSize().width;
                        int lastWidth = viewWidth;
                        if (getColumnCount() > 0) {
                            for (int i = 0; i < getColumnCount() - 1; i++) {
                                lastWidth -= getColumnModel().getColumn(i).getWidth();
                            }
                            if (lastWidth > 0) {
                                TableColumn column = getColumnModel().getColumn(
                                        getColumnCount() - 1);
                                
                                // 拡張処理 begin
                                // =======================================
                                // 当該列のデータを全操作して、文字数をカウントする
                                int columnModelIndex=column.getModelIndex();
                                
                                int maxColumnCharCount = 0;
                                TableModel model=this.getModel();
                                int rows=model.getRowCount();
                                for(int i=0; i<rows;i++){
                                    maxColumnCharCount = Math
                                            .max(
                                                    maxColumnCharCount,
                                                    ACCastUtilities
                                                            .toString(
                                                                    model
                                                                            .getValueAt(
                                                                                    i,
                                                                                    columnModelIndex),
                                                                    "")
                                                            .length());
                                }
                                
                                // 1文字あたりに確保すべきサイズを取得
                                int columnWidth = 0;
                                FontMetrics fm = getTable()
                                        .getFontMetrics(this.getFont());
                                columnWidth = fm.charWidth('m');
                                // 日本語文字対応のため、1.1倍する
                                columnWidth = (int) (columnWidth * 1.1);
                                
                                // 残りセル幅と必要文字数幅の大きい方を最後の列の確保サイズとする。
                                lastWidth = Math.max(lastWidth, maxColumnCharCount * columnWidth);
                                // 拡張処理 end
                                // =======================================
                                
                                
                                if (lastWidth < column.getMinWidth()) {
                                    lastWidth = column.getMinWidth();
                                }
                                column.setWidth(lastWidth);
                                column.setPreferredWidth(lastWidth);
                                resizeAndRepaint();
                            }
                        }
                    }
                }
            }
        };
    }
    
}
