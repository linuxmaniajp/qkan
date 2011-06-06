package jp.or.med.orca.qkan.affair.qp.qp003;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.FocusManager;
import javax.swing.JTable;

import jp.nichicom.ac.component.table.ACTableCellViewer;
import jp.nichicom.vr.component.table.VRTableColumnModel;

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
 * �v���O���� ���p�Ҍ����������ڍוҏW (QP003ResultCalendarTableCellViewer)
 * @since V5.4.9
 *
 *****************************************************************
 */
public class QP003ResultCalendarTableCellViewer extends ACTableCellViewer {
    
    protected void applyTableCellColor(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column,
            Component cmp) {
        
        if (cmp != null) {
            // �I��F�̒��F
            if (isSelected) {
                if(table != null){
                    if (!table.hasFocus()) {
                        super.applyTableCellColor(table, value, false, hasFocus, row, column, cmp);
                        // �F�����Ȃ��ӏ��͑I���������s��
                        table.clearSelection();
                        return;
                    }
                }
            }
        }
        super.applyTableCellColor(table, value, isSelected, hasFocus, row, column, cmp);
        //super.applyTableCellColor(table, value, false, hasFocus, row, column, cmp);
        return;
    }

}
