package jp.or.med.orca.qkan.affair.qp.qp003;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.table.ACCheckBoxTableColumnPopupMenu;
import jp.nichicom.ac.component.table.ACTable;
import jp.nichicom.ac.component.table.ACTableColumn;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.component.table.VRTableCellViewer;
import jp.nichicom.vr.component.table.VRTableColumnModel;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

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
 * �v���O���� ���p�Ҍ����������ڍוҏW (QP003ResultCalendar)
 * @since V5.4.9
 *
 *****************************************************************
 */
public class QP003ResultCalendar extends ACPanel {
    
    private ACLabel calenderLabel;
    private ACTable calenderTable;
    private VRTableColumnModel calenderTableColumnModel;
    private ACTableModelAdapter model;
    private ACTableColumn calenderTableColumn1;
    private ACTableColumn calenderTableColumn2;
    private ACTableColumn calenderTableColumn3;
    private Date calenderDate;
    private VRTableCellViewer cellViewer1;
    private VRTableCellViewer cellViewer2;
    private VRTableCellViewer cellViewer3;
    
    public QP003ResultCalendar() {
        super();
    }
    
    /**
     * 
     */
    protected void initComponent() {
        super.initComponent();
        this.add(getCalenderLabel(),VRLayout.NORTH);
        this.add(getCalenderTable(),VRLayout.CLIENT);
        // �C�x���g�ǉ�
        addEvents();
        
    }
    
    /**
     * �J�����_�[�̓��t��Ԃ��܂��B
     * 
     * @return
     */
    public int getDayOfMonth() {
        if(getCalenderDate() instanceof Date ) {
            // ���t�K�p���͓K�p���t���画�f���ԋp����
            return ACDateUtilities.getDayOfMonth(getCalenderDate());
        }
        // �s���Ȓl
        return -1;
        
    }
    
    /**
     * ���t�ɑΉ�����f�[�^���e�[�u���ɓW�J���܂��B
     * 
     * @param data
     * @throws Exception
     */
    public void setData(VRMap data) throws Exception {
        if(data == null) {
            return;
        }
        // �Y�����t�̃f�[�^���擾�ł����ꍇ
        if (data.getData(ACCastUtilities.toString(getDayOfMonth())) instanceof VRList) {
            VRList lists = (VRList) data.getData(ACCastUtilities
                    .toString(getDayOfMonth()));
            getModel().setAdaptee(lists);
        }
        
    }

    
    /**
     * �J�����_�[�̓��t��\�����郉�x���R���|�[�l���g���擾���܂��B
     * 
     * @return
     */
    public ACLabel getCalenderLabel() {
        if(calenderLabel == null) {
            calenderLabel = new ACLabel();
            calenderLabel.setForeground(Color.black);
            calenderLabel.setHorizontalAlignment(SwingConstants.LEFT);
            calenderLabel.setPreferredSize(new Dimension(120,15));
        }
        return calenderLabel;
    }

    /**
     * �J�����_�[�̓��t��\�����郉�x���R���|�[�l���g��ݒ肵�܂��B
     * 
     * @param calenderLabel
     */
    public void setCalenderLabel(ACLabel calenderLabel) {
        this.calenderLabel = calenderLabel;
    }

    /**
     * �T�[�r�X����\������e�[�u�����擾���܂��B
     * 
     * @return
     */
    public ACTable getCalenderTable() {
        if(calenderTable == null) {
            calenderTable = new QP003ResultCalendarTable();
            calenderTable.setColumnModel(getCalenderTableColumnModel());
            calenderTable.setColumnSort(false);
            calenderTable.setPreferredSize(new Dimension(120,80));
            calenderTable.setModel(getModel());
            calenderTable.setAutoscrolls(true);

        }
        return calenderTable;
    }

    /**
     * �T�[�r�X����\������e�[�u����ݒ肵�܂��B
     * 
     * @param calenderTable
     */
    public void setCalenderTable(ACTable calenderTable) {
        this.calenderTable = calenderTable;
    }

    /**
     * 
     * @return
     */
    public ACTableColumn getCalenderTableColumn1() {
        if (calenderTableColumn1 == null) {
            calenderTableColumn1 = new ACTableColumn();
            calenderTableColumn1.setColumnName("CHECK");
            calenderTableColumn1.setEditable(false);
            calenderTableColumn1.setColumns(2);
            calenderTableColumn1.setHeaderPopupMenu(new ACCheckBoxTableColumnPopupMenu(
                    getCalenderTable(), "CHECK", new Boolean(true),
                    new Boolean(false)));
            calenderTableColumn1.setEditorRenderBindPath("CHECK");
            // �I���W�i���̃r���[���[�ݒ�
            calenderTableColumn1.setCellRenderer(getCellViewer1());
            calenderTableColumn1.setCellEditor(getCellViewer1());
            
        }
        return calenderTableColumn1;
    }

    /**
     * 
     * @param calenderTableColumn1
     */
    public void setCalenderTableColumn1(ACTableColumn col1) {
        this.calenderTableColumn1 = col1;
    }

    /**
     * �t�H�[�J�X�F�̑J�ڂɑΉ������I���W�i���̃Z���r���[���[�ł��B
     * 
     * @return
     */
    public VRTableCellViewer getCellViewer1() {
        if(cellViewer1 == null) {
            cellViewer1 = new QP003ResultCalendarTableCellViewer();
            cellViewer1.setEditable(false);
            cellViewer1.setRendererType(VRTableCellViewer.RENDERER_TYPE_CHECK_BOX);
            cellViewer1.setEditorType(VRTableCellViewer.EDITOR_TYPE_CHECK_BOX);

        }
        return cellViewer1;
    }

    public void setCellViewer1(VRTableCellViewer cellViewer1) {
        this.cellViewer1 = cellViewer1;
    }
    
    /**
     * 
     * @return
     */
    public ACTableColumn getCalenderTableColumn2() {
        if (calenderTableColumn2 == null) {
            calenderTableColumn2 = new ACTableColumn();
            calenderTableColumn2.setColumnName("MARK");
            calenderTableColumn2.setColumns(1);
            calenderTableColumn2.setHorizontalAlignment(SwingConstants.LEFT);
            calenderTableColumn2.setEditorRenderBindPath("MARK");
            calenderTableColumn2.setCellRenderer(getCellViewer2());
        }
        return calenderTableColumn2;
    }

    /**
     * 
     * @param calenderTableColumn2
     */
    public void setCalenderTableColumn2(ACTableColumn col2) {
        this.calenderTableColumn2 = col2;
    }

    
    public VRTableCellViewer getCellViewer2() {
        if(cellViewer2 == null) {
            cellViewer2 = new QP003ResultCalendarTableCellViewer();
        }
        return cellViewer2;
    }

    public void setCellViewer2(VRTableCellViewer cellViewer2) {
        this.cellViewer2 = cellViewer2;
    }
    
    /**
     * 
     * @return
     */
    public ACTableColumn getCalenderTableColumn3() {
        if (calenderTableColumn3 == null) {
            calenderTableColumn3 = new ACTableColumn();
            calenderTableColumn3.setColumnName("SERVICE_NAME_COL");
            calenderTableColumn3.setColumns(10);
            calenderTableColumn3.setHorizontalAlignment(SwingConstants.LEFT);
            calenderTableColumn3.setEditorRenderBindPath("SERVICE_NAME_COL");
            calenderTableColumn3.setCellRenderer(getCellViewer3());
        }
        return calenderTableColumn3;
    }

    /**
     * 
     * @param calenderTableColumn3
     */
    public void setCalenderTableColumn3(ACTableColumn col3) {
        this.calenderTableColumn3 = col3;
    }
    
    
    public VRTableCellViewer getCellViewer3() {
        if(cellViewer3 == null) {
            cellViewer3 = new QP003ResultCalendarTableCellViewer();

        }
        return cellViewer3;
    }

    public void setCellViewer3(VRTableCellViewer cellViewer3) {
        this.cellViewer3 = cellViewer3;
    }

    /**
     * �J�����_�[�ɐݒ肷��e�[�u�����f�����擾���܂��B
     * 
     * @return
     */
    public VRTableColumnModel getCalenderTableColumnModel() {
        if (calenderTableColumnModel == null) {
            calenderTableColumnModel = new VRTableColumnModel(
                    new TableColumn[] {});
            calenderTableColumnModel.addColumn(getCalenderTableColumn1());
            calenderTableColumnModel.addColumn(getCalenderTableColumn2());
            calenderTableColumnModel.addColumn(getCalenderTableColumn3());
        }
        return calenderTableColumnModel;
    }

    /**
     * �J�����_�[�ɐݒ肷��e�[�u�����f����ݒ肵�܂��B
     * 
     * @param calenderTableColumnModel
     */
    public void setCalenderTableColumnModel(
            VRTableColumnModel calenderTableColumnModel) {
        this.calenderTableColumnModel = calenderTableColumnModel;
    }

    /**
     * �R���|�[�l���g�̓��t�����擾���܂��B
     * 
     * @return
     */
    public Date getCalenderDate() {
        return calenderDate;
    }

    /**
     * �J�����_�[�ɓ��t����ݒ肵�܂��B
     * 
     * @param calenderDate
     */
    public void setCalenderDate(Date calenderDate) {
        this.calenderDate = calenderDate;
        // ���t�ݒ莞�Ƀe�L�X�g�ɓ��t���o��
        calenderLabel.setText(ACCastUtilities.toString(ACDateUtilities
                .getDayOfMonth(calenderDate), ""));
        
    }

    /**
     * �e�[�u�����f���A�_�v�^�[���擾���܂��B
     * 
     * @return
     */
    public ACTableModelAdapter getModel() {
        if (model == null) {
            model = new ACTableModelAdapter();
            model
                    .setColumns(new String[] { "CHECK", "MARK",
                            "SERVICE_NAME_COL" });
        }
        return model;
    }

    /**
     * �e�[�u�����f����ݒ肵�܂��B
     * 
     * @param model
     */
    public void setModel(ACTableModelAdapter model) {
        this.model = model;
    }

    /**
     * �C�x���g�����������`���܂��B
     */
    protected void addEvents() {
        // �e�[�u���֘A�̃C�x���g
        getCalenderTable().addMouseListener(new MouseAdapter(){
            private boolean lockFlag = false;
            public void mouseClicked(MouseEvent e) {
                if (lockFlag) {
                    return;
                }
                lockFlag = true;
                try {
                    calenderTableCheck(e);
                }catch(Throwable ex){
                    ACCommon.getInstance().showExceptionMessage(ex);
                }finally{
                    lockFlag = false;
                }
            }
        });     
    }

    /**
     * �J�����_�[�N���b�N���̃C�x���g�ł��B
     * 
     * @param e
     * @throws Exception
     */
    protected void calenderTableCheck(MouseEvent e) throws Exception {
        if(getCalenderTable().isSelected()) {
            Object obj = getCalenderTable().getSelectedModelRowValue();
            if(obj instanceof VRMap) {
                VRMap map = (VRMap)obj;
                boolean check = ACCastUtilities.toBoolean(map.getData("CHECK"));
                map.setData("CHECK",new Boolean(!check));
                getCalenderTable().repaint();
            }
        }
    }
    
}
