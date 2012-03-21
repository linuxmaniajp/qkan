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
 * サービススケジュール用の日パネルです。
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
     * サービスマスタ を返します。
     * 
     * @return サービスマスタ
     */
    public VRMap getMasterService() {
        return schedules.getMasterService();
    }

    /**
     * サービスマスタ を設定します。
     * 
     * @param serviceMaster サービスマスタ
     */
    public void setMasterService(VRMap serviceMaster) {
        schedules.setMasterService(serviceMaster);
    }
    /**
     * コンストラクタです。
     */
    public QS001DaySchedule() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * コンポーネントを設定します。
     * 
     * @throws Exception 処理例外
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
     * スケジュールデータを返します。
     * 
     * @return スケジュールデータ
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
     * スケジュールデータ件数を返します。
     * 
     * @return スケジュールデータ件数
     */
    public int getScheduleCount() {
        return schedules.getModel().getSize();
    }


    /**
     * スケジュールデータを追加します。
     * 
     * @param data スケジュールデータ
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
     * スケジュールデータを削除します。
     * 
     * @param data スケジュールデータ
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
     * 設定されているサービスをクリアします。
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
     * ヘッダを返します。
     * 
     * @return ヘッダ
     */
    public String getHeader() {
        return header.getText();
    }

    /**
     * ヘッダを設定します。
     * 
     * @param header ヘッダ
     */
    public void setHeader(String header) {
        this.header.setText(header);
    }

    /**
     * スケジュール一覧の背景色を返します。
     * 
     * @return スケジュール一覧の背景色
     */
    public Color getSchedulesBackground() {
        return schedules.getMainContentBackground();
    }

    /**
     * スケジュール一覧の背景色を設定します。
     * 
     * @param schedulesBackground スケジュール一覧の背景色
     */
    public void setSchedulesBackground(Color schedulesBackground) {
        schedules.setMainContentBackground(schedulesBackground);
    }

    /**
     * スケジュール一覧の表示可否を返します。
     * 
     * @return スケジュール一覧の表示可否
     */
    public boolean isSchedulesVisible() {
        return schedules.isVisible();
    }

    /**
     * スケジュール一覧の表示可否を設定します。
     * 
     * @param schedulesVisible スケジュール一覧の表示可否
     */
    public void setSchedulesVisible(boolean schedulesVisible) {
        schedules.setVisible(schedulesVisible);
    }

    /**
     * ヘッダの表示可否を返します。
     * 
     * @return ヘッダの表示可否
     */
    public boolean isHeaderVisible() {
        return header.isVisible();
    }

    /**
     * ヘッダの表示可否を設定します。
     * 
     * @param headerVisible ヘッダの表示可否
     */
    public void setHeaderVisible(boolean headerVisible) {
        header.setVisible(headerVisible);
    }

    /**
     * ヘッダの水平文字揃えを返します。
     * 
     * @return ヘッダの水平文字揃え
     */
    public int getHeaderHorizontalAlignment() {
        return header.getHorizontalAlignment();
    }

    /**
     * ヘッダの水平文字揃えを設定します。
     * 
     * @param headerHorizontalAlignment ヘッダの水平文字揃え
     */
    public void setHeaderHorizontalAlignment(int headerHorizontalAlignment) {
        header.setHorizontalAlignment(headerHorizontalAlignment);
    }

    /**
     * リストのセルレンダラを返します。
     * 
     * @return リストのセルレンダラ
     */
    public ListCellRenderer getCellRenderer() {
        return schedules.getCellRenderer();
    }

    /**
     * リストのセルレンダラを設定します。
     * 
     * @param renderer リストのセルレンダラ
     */
    public void setCellRenderer(ListCellRenderer renderer) {
        schedules.setCellRenderer(renderer);
    }

    /**
     * ドロップを許可するサービスのビットフラグ を返します。
     * 
     * @return ドロップを許可するサービスのビットフラグ
     */
    public int getDropAllowedServiceBitMask() {
        return schedules.getDropAllowedServiceBitMask();
    }

    /**
     * ドロップを許可するサービスのビットフラグ を設定します。
     * 
     * @param dropAllowedServiceBitMask ドロップを許可するサービスのビットフラグ
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
            // 子のイベントを間接的に発行
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
     * 項目選択イベントリスナを全走査してapplySourceイベントを呼び出します。
     */
    protected void fireValueChanged(ListSelectionEvent e) {
        if (e.getSource() == schedules) {
            // 子のイベントを間接的に発行
            e = new ListSelectionEvent(this, e.getFirstIndex(), e
                    .getLastIndex(), e.getValueIsAdjusting());
        }
        ListSelectionListener[] listeners = (ListSelectionListener[]) (getListeners(ListSelectionListener.class));
        for (int i = 0; i < listeners.length; i++) {
            listeners[i].valueChanged(e);
        }
    }

    /**
     * 選択しているサービスを削除します。
     */
    public void removeSelectedSchedule() {
        int selIndex = schedules.getSelectedIndex();
        if (selIndex >= 0) {
            Object schedule = schedules.getSelectedValue();
            if (schedule instanceof VRMap) {

                removeSchedule((VRMap) schedule);
                if (selIndex <= schedules.getModel().getSize()) {
                    // 削除したら一つ前を選択
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
     * サービスを選択しているかを返します。
     * 
     * @return サービスを選択しているか
     */
    public boolean isSelected() {
        return schedules.isSelected();
    }

    /**
     * 選択しているサービスを返します。
     * 
     * @return 選択しているサービス
     */
    public VRMap getSelectedService() {
        Object val = schedules.getSelectedValue();
        if (val instanceof VRMap) {
            return (VRMap) val;
        }
        return null;
    }

    /**
     * D&Dによる移動 を行なう を設定します。
     * 
     * @param moveMode D&Dによる移動を行なう
     */
    public void setMoveMode(boolean moveMode) {
        schedules.setMoveMode(moveMode);
    }

    /**
     * D&Dによる貼り付けを受け入れるか を設定します。
     * 
     * @param recieveMode D&Dによる貼り付けを受け入れるか
     */
    public void setRecieveMode(boolean recieveMode) {
        schedules.setRecieveMode(recieveMode);
    }

    /**
     * D&Dによる移動 を行なうか返します。
     * 
     * @return D&Dによる移動を行なう
     */
    public boolean isMoveMode() {
        return schedules.isMoveMode();
    }

    /**
     * D&Dによる貼り付けを受け入れるか を返します。
     * 
     * @return D&Dによる貼り付けを受け入れるか
     */
    public boolean isRecieveMode() {
        return schedules.isRecieveMode();
    }
    /**
     * 選択を解除します。
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
     * バインドソース形式でリストモデルを返します。
     * <p>
     * モデルがバインドソース形式から構成されていない場合、nullを返します。
     * </p>
     * 
     * @return モデル
     */
    public VRBindSource getModelAtBindSource() {
        return schedules.getModelAtBindSource();
    }
    
}
