package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.Position.Bias;

import jp.nichicom.ac.component.dnd.ACDroppable;
import jp.nichicom.ac.component.dnd.event.ACDroppableListener;
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.component.VRListBoxar;
import jp.nichicom.vr.container.VRPanel;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.adapter.VRBindSourceAdapter;

/**
 * �T�[�r�X�X�P�W���[���p�̓��p�l���ł��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/31
 */
public class QS001DaySchedule extends VRPanel implements KeyListener,
        ListSelectionListener, VRListBoxar, ACDroppable {
    private JLabel header = new JLabel();
    private QS001ScrollableScheduleListBox schedules = new QS001ScrollableScheduleListBox();

    /**
     * �T�[�r�X�}�X�^ ��Ԃ��܂��B
     * 
     * @return �T�[�r�X�}�X�^
     */
    public VRMap getMasterService() {
        return schedules.getMasterService();
    }

    /**
     * �T�[�r�X�}�X�^ ��ݒ肵�܂��B
     * 
     * @param serviceMaster �T�[�r�X�}�X�^
     */
    public void setMasterService(VRMap serviceMaster) {
        schedules.setMasterService(serviceMaster);
    }
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001DaySchedule() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * �R���|�[�l���g��ݒ肵�܂��B
     * 
     * @throws Exception ������O
     */
    private void jbInit() throws Exception {
        this.setLayout(new BorderLayout());

        schedules.addKeyListener(this);
        schedules.addListSelectionListener(this);
        header.setText("1");

        this.setPreferredSize(new Dimension(50, 100));

        this.add(header, BorderLayout.NORTH);
        this.add(schedules, BorderLayout.CENTER);
    }

    /**
     * �X�P�W���[���f�[�^��Ԃ��܂��B
     * 
     * @return �X�P�W���[���f�[�^
     */
    public VRList getSchedule() {
        Object model = schedules.getModel();
        while (model instanceof VRBindSourceAdapter) {
            model = ((VRBindSourceAdapter) model).getAdaptee();
        }
        if (model instanceof VRList) {
            return (VRList) model;
        } else if (model instanceof DefaultListModel) {
            return new VRArrayList(Arrays.asList(((DefaultListModel) model)
                    .toArray()));
        }
        return null;
    }

    /**
     * �X�P�W���[���f�[�^������Ԃ��܂��B
     * 
     * @return �X�P�W���[���f�[�^����
     */
    public int getScheduleCount() {
        return schedules.getModel().getSize();
    }


    /**
     * �X�P�W���[���f�[�^��ǉ����܂��B
     * 
     * @param data �X�P�W���[���f�[�^
     */
    public void addSchedule(VRMap data) {
        Object model = schedules.getModel();
        while (model instanceof VRBindSourceAdapter) {
            model = ((VRBindSourceAdapter) model).getAdaptee();
        }
        if (model instanceof VRBindSource) {
            ((VRBindSource) model).addData(data);
        } else if (model instanceof DefaultListModel) {
            ((DefaultListModel) model).addElement(data);
        }
    }

    /**
     * �X�P�W���[���f�[�^���폜���܂��B
     * 
     * @param data �X�P�W���[���f�[�^
     */
    public void removeSchedule(VRMap data) {
        Object model = schedules.getModel();
        while (model instanceof VRBindSourceAdapter) {
            model = ((VRBindSourceAdapter) model).getAdaptee();
        }
        if (model instanceof VRBindSource) {
            VRBindSource src = (VRBindSource) model;
            int end = src.getDataSize();
            if (data == null) {
                for (int i = 0; i < end; i++) {
                    if (src.getData(i) == null) {
                        src.removeData(i);
                        break;
                    }
                }
            } else {
                for (int i = 0; i < end; i++) {
                    if (data.equals(src.getData(i))) {
                        src.removeData(i);
                        break;
                    }
                }
            }
        } else if (model instanceof DefaultListModel) {
            ((DefaultListModel) model).removeElement(data);
        }
    }

    /**
     * �ݒ肳��Ă���T�[�r�X���N���A���܂��B
     */
    public void clearSchedule() {
        Object model = schedules.getModel();
        while (model instanceof VRBindSourceAdapter) {
            model = ((VRBindSourceAdapter) model).getAdaptee();
        }
        if (model instanceof VRBindSource) {
            ((VRBindSource) model).clearData();
        } else if (model instanceof DefaultListModel) {
            ((DefaultListModel) model).clear();
        }
    }

    /**
     * �w�b�_��Ԃ��܂��B
     * 
     * @return �w�b�_
     */
    public String getHeader() {
        return header.getText();
    }

    /**
     * �w�b�_��ݒ肵�܂��B
     * 
     * @param header �w�b�_
     */
    public void setHeader(String header) {
        this.header.setText(header);
    }

    /**
     * �X�P�W���[���ꗗ�̔w�i�F��Ԃ��܂��B
     * 
     * @return �X�P�W���[���ꗗ�̔w�i�F
     */
    public Color getSchedulesBackground() {
        return schedules.getMainContentBackground();
    }

    /**
     * �X�P�W���[���ꗗ�̔w�i�F��ݒ肵�܂��B
     * 
     * @param schedulesBackground �X�P�W���[���ꗗ�̔w�i�F
     */
    public void setSchedulesBackground(Color schedulesBackground) {
        schedules.setMainContentBackground(schedulesBackground);
    }

    /**
     * �X�P�W���[���ꗗ�̕\���ۂ�Ԃ��܂��B
     * 
     * @return �X�P�W���[���ꗗ�̕\����
     */
    public boolean isSchedulesVisible() {
        return schedules.isVisible();
    }

    /**
     * �X�P�W���[���ꗗ�̕\���ۂ�ݒ肵�܂��B
     * 
     * @param schedulesVisible �X�P�W���[���ꗗ�̕\����
     */
    public void setSchedulesVisible(boolean schedulesVisible) {
        schedules.setVisible(schedulesVisible);
    }

    /**
     * �w�b�_�̕\���ۂ�Ԃ��܂��B
     * 
     * @return �w�b�_�̕\����
     */
    public boolean isHeaderVisible() {
        return header.isVisible();
    }

    /**
     * �w�b�_�̕\���ۂ�ݒ肵�܂��B
     * 
     * @param headerVisible �w�b�_�̕\����
     */
    public void setHeaderVisible(boolean headerVisible) {
        header.setVisible(headerVisible);
    }

    /**
     * �w�b�_�̐�������������Ԃ��܂��B
     * 
     * @return �w�b�_�̐�����������
     */
    public int getHeaderHorizontalAlignment() {
        return header.getHorizontalAlignment();
    }

    /**
     * �w�b�_�̐�������������ݒ肵�܂��B
     * 
     * @param headerHorizontalAlignment �w�b�_�̐�����������
     */
    public void setHeaderHorizontalAlignment(int headerHorizontalAlignment) {
        header.setHorizontalAlignment(headerHorizontalAlignment);
    }

    /**
     * ���X�g�̃Z�������_����Ԃ��܂��B
     * 
     * @return ���X�g�̃Z�������_��
     */
    public ListCellRenderer getCellRenderer() {
        return schedules.getCellRenderer();
    }

    /**
     * ���X�g�̃Z�������_����ݒ肵�܂��B
     * 
     * @param renderer ���X�g�̃Z�������_��
     */
    public void setCellRenderer(ListCellRenderer renderer) {
        schedules.setCellRenderer(renderer);
    }

    /**
     * �h���b�v��������T�[�r�X�̃r�b�g�t���O ��Ԃ��܂��B
     * 
     * @return �h���b�v��������T�[�r�X�̃r�b�g�t���O
     */
    public int getDropAllowedServiceBitMask() {
        return schedules.getDropAllowedServiceBitMask();
    }

    /**
     * �h���b�v��������T�[�r�X�̃r�b�g�t���O ��ݒ肵�܂��B
     * 
     * @param dropAllowedServiceBitMask �h���b�v��������T�[�r�X�̃r�b�g�t���O
     */
    public void setDropAllowedServiceBitMask(int dropAllowedServiceBitMask) {
        schedules.setDropAllowedServiceBitMask(dropAllowedServiceBitMask);
    }

    /**
     * Adds a listener to the list that's notified each time a change to the
     * selection occurs. Listeners added directly to the <code>JList</code>
     * will have their <code>ListSelectionEvent.getSource() == 
     * this JList</code>
     * (instead of the <code>ListSelectionModel</code>).
     * 
     * @param listener the <code>ListSelectionListener</code> to add
     * @see #getSelectionModel
     * @see #getListSelectionListeners
     */
    public void addListSelectionListener(ListSelectionListener listener) {
        listenerList.add(ListSelectionListener.class, listener);
    }

    protected void processKeyEvent(KeyEvent e) {
        if (e.getSource() == schedules) {
            // �q�̃C�x���g���ԐړI�ɔ��s
            e = new KeyEvent(this, e.getID(), e.getWhen(), e.getModifiers(), e
                    .getKeyCode(), e.getKeyChar(), e.getKeyLocation());
        }
        super.processKeyEvent(e);
    }

    public void keyPressed(KeyEvent e) {
        processKeyEvent(e);
    }

    public void keyReleased(KeyEvent e) {
        processKeyEvent(e);
    }

    public void keyTyped(KeyEvent e) {
        processKeyEvent(e);
    }

    public void valueChanged(ListSelectionEvent e) {
        fireValueChanged(e);
    }

    /**
     * ���ڑI���C�x���g���X�i��S��������applySource�C�x���g���Ăяo���܂��B
     */
    protected void fireValueChanged(ListSelectionEvent e) {
        if (e.getSource() == schedules) {
            // �q�̃C�x���g���ԐړI�ɔ��s
            e = new ListSelectionEvent(this, e.getFirstIndex(), e
                    .getLastIndex(), e.getValueIsAdjusting());
        }
        ListSelectionListener[] listeners = (ListSelectionListener[]) (getListeners(ListSelectionListener.class));
        for (int i = 0; i < listeners.length; i++) {
            listeners[i].valueChanged(e);
        }
    }

    /**
     * �I�����Ă���T�[�r�X���폜���܂��B
     */
    public void removeSelectedSchedule() {
        int selIndex = schedules.getSelectedIndex();
        if (selIndex >= 0) {
            Object schedule = schedules.getSelectedValue();
            if (schedule instanceof VRMap) {

                removeSchedule((VRMap) schedule);
                if (selIndex <= schedules.getModel().getSize()) {
                    // �폜�������O��I��
                    if (selIndex > 0) {
                        selIndex--;
                    }
                    if(selIndex>=0){
                        schedules.setSelectedIndex(selIndex);
                    }
                }
            }
        }
    }

    /**
     * �T�[�r�X��I�����Ă��邩��Ԃ��܂��B
     * 
     * @return �T�[�r�X��I�����Ă��邩
     */
    public boolean isSelected() {
        return schedules.isSelected();
    }

    /**
     * �I�����Ă���T�[�r�X��Ԃ��܂��B
     * 
     * @return �I�����Ă���T�[�r�X
     */
    public VRMap getSelectedService() {
        Object val = schedules.getSelectedValue();
        if (val instanceof VRMap) {
            return (VRMap) val;
        }
        return null;
    }

    /**
     * D&D�ɂ��ړ� ���s�Ȃ� ��ݒ肵�܂��B
     * 
     * @param moveMode D&D�ɂ��ړ����s�Ȃ�
     */
    public void setMoveMode(boolean moveMode) {
        schedules.setMoveMode(moveMode);
    }

    /**
     * D&D�ɂ��\��t�����󂯓���邩 ��ݒ肵�܂��B
     * 
     * @param recieveMode D&D�ɂ��\��t�����󂯓���邩
     */
    public void setRecieveMode(boolean recieveMode) {
        schedules.setRecieveMode(recieveMode);
    }

    /**
     * D&D�ɂ��ړ� ���s�Ȃ����Ԃ��܂��B
     * 
     * @return D&D�ɂ��ړ����s�Ȃ�
     */
    public boolean isMoveMode() {
        return schedules.isMoveMode();
    }

    /**
     * D&D�ɂ��\��t�����󂯓���邩 ��Ԃ��܂��B
     * 
     * @return D&D�ɂ��\��t�����󂯓���邩
     */
    public boolean isRecieveMode() {
        return schedules.isRecieveMode();
    }
    /**
     * �I�����������܂��B
     */
    public void clearSelection(){
        schedules.clearSelection();
    }

    public void addSelectionInterval(int anchor, int lead) {
        schedules.addSelectionInterval(anchor, lead);
    }

    public void ensureIndexIsVisible(int index) {
        schedules.ensureIndexIsVisible(index);
    }

    public int getAnchorSelectionIndex() {
        return schedules.getAnchorSelectionIndex();
    }

    public Rectangle getCellBounds(int index0, int index1) {
        return schedules.getCellBounds(index0, index1);
    }

    public boolean getDragEnabled() {
        return schedules.getDragEnabled();
    }

    public int getFirstVisibleIndex() {
        return schedules.getFirstVisibleIndex();
    }

    public int getFixedCellHeight() {
        return schedules.getFixedCellHeight();
    }

    public int getFixedCellWidth() {
        return schedules.getFixedCellWidth();
    }

    public int getLastVisibleIndex() {
        return schedules.getLastVisibleIndex();
    }

    public int getLayoutOrientation() {
        return schedules.getLayoutOrientation();
    }

    public int getLeadSelectionIndex() {
        return schedules.getLeadSelectionIndex();
    }

    public ListSelectionListener[] getListSelectionListeners() {
        return schedules.getListSelectionListeners();
    }

    public int getMaxSelectionIndex() {
        return schedules.getMaxSelectionIndex();
    }

    public int getMinSelectionIndex() {
        return schedules.getMinSelectionIndex();
    }

    public ListModel getModel() {
        return schedules.getModel();
    }

    public int getNextMatch(String prefix, int startIndex, Bias bias) {
        return schedules.getNextMatch(prefix, startIndex, bias);
    }

    public Object getPrototypeCellValue() {
        return schedules.getPrototypeCellValue();
    }

    public int getSelectedIndex() {
        return schedules.getSelectedIndex();
    }

    public int[] getSelectedIndices() {
        return schedules.getSelectedIndices();
    }

    public Object getSelectedValue() {
        return schedules.getSelectedValue();
    }

    public Object[] getSelectedValues() {
        return schedules.getSelectedValues();
    }

    public Color getSelectionBackground() {
        return schedules.getSelectionBackground();
    }

    public Color getSelectionForeground() {
        return schedules.getSelectionForeground();
    }

    public int getSelectionMode() {
        return schedules.getSelectionMode();
    }

    public ListSelectionModel getSelectionModel() {
        return schedules.getSelectionModel();
    }

    public boolean getValueIsAdjusting() {
        return schedules.getValueIsAdjusting();
    }

    public boolean isShouldScrollOnSelect() {
        return schedules.isShouldScrollOnSelect();
    }

    public boolean isSingleSelection() {
        return schedules.isSingleSelection();
    }

    public void setShouldScrollOnSelect(boolean shouldScrollOnSelect) {
        schedules.setShouldScrollOnSelect(shouldScrollOnSelect);
    }

    public void setVisibleRowCount(int visibleRowCount) {
        schedules.setVisibleRowCount(visibleRowCount);
    }

    public void setSelectionInterval(int anchor, int lead) {
        schedules.setSelectionInterval(anchor, lead);
    }

    public void removeSelectionInterval(int index0, int index1) {
        schedules.removeSelectionInterval(index0, index1);
    }

    public boolean isSelectionEmpty() {
        return schedules.isSelectionEmpty();
    }

    public void setSelectionMode(int selectionMode) {
        schedules.setSelectionMode(selectionMode);
    }

    public void setSelectionModel(ListSelectionModel selectionModel) {
        schedules.setSelectionModel(selectionModel);
    }

    public void setSelectionBackground(Color selectionBackground) {
        schedules.setSelectionBackground(selectionBackground);
    }

    public void setSelectionForeground(Color selectionForeground) {
        schedules.setSelectionForeground(selectionForeground);
    }

    public boolean isSelectedIndex(int index) {
        return schedules.isSelectedIndex(index);
    }

    public void setPrototypeCellValue(Object prototypeCellValue) {
        schedules.setPrototypeCellValue(prototypeCellValue);
    }

    public void setFixedCellHeight(int height) {
        schedules.setFixedCellHeight(height);
    }

    public void setFixedCellWidth(int width) {
        schedules.setFixedCellWidth(width);
    }

    public void setModel(ListModel model) {
        schedules.setModel(model);
    }

    public void setLayoutOrientation(int layoutOrientation) {
        schedules.setLayoutOrientation(layoutOrientation);
    }

    public int getVisibleRowCount() {
        return schedules.getVisibleRowCount();
    }

    public void setDragEnabled(boolean b) {
        schedules.setDragEnabled(b);
    }

    public void setSelectedIndex(int index) {
        schedules.setSelectedIndex(index);
    }

    public boolean getScrollableTracksViewportHeight() {
        return schedules.getScrollableTracksViewportHeight();
    }

    public boolean getScrollableTracksViewportWidth() {
        return schedules.getScrollableTracksViewportWidth();
    }

    public Dimension getPreferredScrollableViewportSize() {
        return schedules.getPreferredScrollableViewportSize();
    }

    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        return schedules.getScrollableBlockIncrement(visibleRect, orientation, direction);
    }

    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        return schedules.getScrollableUnitIncrement(visibleRect, orientation, direction);
    }

    public void addDroppableListener(ACDroppableListener l) {
        schedules.addDroppableListener(l);
    }

    public void removeDroppableListener(ACDroppableListener l) {
        schedules.removeDroppableListener(l);       
    }
    /**
     * �o�C���h�\�[�X�`���Ń��X�g���f����Ԃ��܂��B
     * <p>
     * ���f�����o�C���h�\�[�X�`������\������Ă��Ȃ��ꍇ�Anull��Ԃ��܂��B
     * </p>
     * 
     * @return ���f��
     */
    public VRBindSource getModelAtBindSource() {
        return schedules.getModelAtBindSource();
    }
    
}
