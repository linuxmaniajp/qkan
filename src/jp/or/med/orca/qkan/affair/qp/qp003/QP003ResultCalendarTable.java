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
 * �J����: ����@��F
 * �쐬��: 2009  ���{�R���s���[�^�[������� ��� ��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X �������� (003)
 * �v���O���� ���p�Ҍ����������ڍוҏW (QP003ResultCalendarTable)
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
                                
                                // �g������ begin
                                // =======================================
                                // ���Y��̃f�[�^��S���삵�āA���������J�E���g����
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
                                
                                // 1����������Ɋm�ۂ��ׂ��T�C�Y���擾
                                int columnWidth = 0;
                                FontMetrics fm = getTable()
                                        .getFontMetrics(this.getFont());
                                columnWidth = fm.charWidth('m');
                                // ���{�ꕶ���Ή��̂��߁A1.1�{����
                                columnWidth = (int) (columnWidth * 1.1);
                                
                                // �c��Z�����ƕK�v���������̑傫�������Ō�̗�̊m�ۃT�C�Y�Ƃ���B
                                lastWidth = Math.max(lastWidth, maxColumnCharCount * columnWidth);
                                // �g������ end
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
