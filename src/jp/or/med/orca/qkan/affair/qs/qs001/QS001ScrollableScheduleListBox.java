package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.Component;
import java.awt.dnd.DragGestureEvent;
import java.util.Vector;

import javax.swing.ListModel;

import jp.nichicom.ac.component.ACListBox;
import jp.nichicom.ac.component.dnd.ACDroppable;
import jp.nichicom.ac.component.dnd.ACDroppableListBox;
import jp.nichicom.ac.component.dnd.event.ACDroppableListener;
import jp.nichicom.vr.component.AbstractVRListBox;
import jp.nichicom.vr.util.VRMap;

/**
 * スクロールペイン一体型の<code>QS001ScheduleListBox</code>です。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/31
 * @see ACListBox
 * @see QS001ScheduleListBox
 */
public class QS001ScrollableScheduleListBox extends ACListBox implements ACDroppable {

    /**
     * コンストラクタです。
     */
    public QS001ScrollableScheduleListBox() {
        super();
    }

    /**
     * Creates a <code>JScrollPane</code> that displays the contents of the
     * specified component, where both horizontal and vertical scrollbars appear
     * whenever the component's contents are larger than the view.
     * 
     * @see #setViewportView
     * @param view the component to display in the scrollpane's viewport
     */
    public QS001ScrollableScheduleListBox(Component view) {
        super(view);
    }

    /**
     * Creates a <code>JScrollPane</code> that displays the view component in
     * a viewport whose view position can be controlled with a pair of
     * scrollbars. The scrollbar policies specify when the scrollbars are
     * displayed, For example, if <code>vsbPolicy</code> is
     * <code>VERTICAL_SCROLLBAR_AS_NEEDED</code> then the vertical scrollbar
     * only appears if the view doesn't fit vertically. The available policy
     * settings are listed at {@link #setVerticalScrollBarPolicy} and
     * {@link #setHorizontalScrollBarPolicy}.
     * 
     * @see #setViewportView
     * @param view the component to display in the scrollpanes viewport
     * @param vsbPolicy an integer that specifies the vertical scrollbar policy
     * @param hsbPolicy an integer that specifies the horizontal scrollbar
     *            policy
     */
    public QS001ScrollableScheduleListBox(Component view, int vsbPolicy,
            int hsbPolicy) {
        super(view, vsbPolicy, hsbPolicy);
    }

    /**
     * Constructs a <code>JList</code> that displays the elements in the
     * specified, non-<code>null</code> model. All <code>JList</code>
     * constructors delegate to this one.
     * 
     * @param dataModel the data model for this list
     * @exception IllegalArgumentException if <code>dataModel</code> is
     *                <code>null</code>
     */
    public QS001ScrollableScheduleListBox(ListModel dataModel) {
        super(dataModel);
    }

    /**
     * Constructs a <code>JList</code> that displays the elements in the
     * specified array. This constructor just delegates to the
     * <code>ListModel</code> constructor.
     * 
     * @param listData the array of Objects to be loaded into the data model
     */
    public QS001ScrollableScheduleListBox(Object[] listData) {
        super(listData);
    }

    /**
     * Constructs a <code>JList</code> that displays the elements in the
     * specified <code>Vector</code>. This constructor just delegates to the
     * <code>ListModel</code> constructor.
     * 
     * @param listData the <code>Vector</code> to be loaded into the data
     *            model
     */
    public QS001ScrollableScheduleListBox(Vector listData) {
        super(listData);
    }

    public void addDroppableListener(ACDroppableListener l) {
        AbstractVRListBox list = getMainContent();
        if (list instanceof ACDroppableListBox) {
            ((ACDroppableListBox) list).addDroppableListener(l);
        }
    }

    /**
     * 要素を追加します。
     * 
     * @param data 要素
     */
    public void addElement(Object data) {
        AbstractVRListBox list = getMainContent();
        if (list instanceof ACDroppableListBox) {
            ((ACDroppableListBox) list).addElement(data);
        }
    }

    /**
     * ドラッグ開始時点のイベント を返します。
     * 
     * @return ドラッグ開始時点のイベント
     */
    public DragGestureEvent getBeginDragEvent() {
        AbstractVRListBox list = getMainContent();
        if (list instanceof ACDroppableListBox) {
            return ((ACDroppableListBox) list).getBeginDragEvent();
        }
        return null;
    }

    /**
     * ドロップを許可するサービスのビットフラグ を返します。
     * 
     * @return ドロップを許可するサービスのビットフラグ
     */
    public int getDropAllowedServiceBitMask() {
        AbstractVRListBox list = getMainContent();
        if (list instanceof QS001ScheduleListBox) {
            return ((QS001ScheduleListBox) list).getDropAllowedServiceBitMask();
        }
        return 0;
    }

    /**
     * 要素を返します。
     * 
     * @param index 行番号
     * @return data 要素
     */
    public Object getElement(int index) {
        AbstractVRListBox list = getMainContent();
        if (list instanceof ACDroppableListBox) {
            ((ACDroppableListBox) list).getElement(index);
        }
        return null;
    }

    /**
     * サービスマスタ を返します。
     * 
     * @return サービスマスタ
     */
    public VRMap getMasterService() {
        AbstractVRListBox list = getMainContent();
        if (list instanceof QS001ScheduleListBox) {
           return  ((QS001ScheduleListBox) list).getMasterService();
        }
        return null;
    }

    /**
     * 要素を挿入します。
     * 
     * @param data 要素
     * @param index 挿入位置
     */
    public void insertElementAt(Object data, int index) {
        AbstractVRListBox list = getMainContent();
        if (list instanceof ACDroppableListBox) {
            ((ACDroppableListBox) list).addElement(data);
        }
    }

    /**
     * D&Dによる移動 を行なうか返します。
     * 
     * @return D&Dによる移動を行なう
     */
    public boolean isMoveMode() {
        AbstractVRListBox list = getMainContent();
        if (list instanceof ACDroppableListBox) {
            return ((ACDroppableListBox) list).isMoveMode();
        }
        return false;
    }

    /**
     * D&Dによる貼り付けを受け入れるか を返します。
     * 
     * @return D&Dによる貼り付けを受け入れるか
     */
    public boolean isRecieveMode() {
        AbstractVRListBox list = getMainContent();
        if (list instanceof ACDroppableListBox) {
            return ((ACDroppableListBox) list).isRecieveMode();
        }
        return false;
    }

    /**
     * 要素をすべて削除します。
     */
    public void removeAllElement() {
        AbstractVRListBox list = getMainContent();
        if (list instanceof ACDroppableListBox) {
            ((ACDroppableListBox) list).removeAllElement();
        }
    }

    public void removeDroppableListener(ACDroppableListener l) {
        AbstractVRListBox list = getMainContent();
        if (list instanceof ACDroppableListBox) {
            ((ACDroppableListBox) list).removeDroppableListener(l);
        }         
    }

    /**
     * 要素を削除します。
     * 
     * @param index 削除位置
     */
    public void removeElementAt(int index) {
        AbstractVRListBox list = getMainContent();
        if (list instanceof ACDroppableListBox) {
            ((ACDroppableListBox) list).removeElementAt(index);
        }
    }
    /**
     * ドラッグ開始時点のイベント を設定します。
     * 
     * @param dragModifiers ドラッグ開始時点のイベント
     */
    public void setBeginDragEvent(DragGestureEvent beginDragEvent) {
        AbstractVRListBox list = getMainContent();
        if (list instanceof ACDroppableListBox) {
            ((ACDroppableListBox) list).setBeginDragEvent(beginDragEvent);
        }
    }

    /**
     * ドロップを許可するサービスのビットフラグ を設定します。
     * 
     * @param dropAllowedServiceBitMask ドロップを許可するサービスのビットフラグ
     */
    public void setDropAllowedServiceBitMask(int dropAllowedServiceBitMask) {
        AbstractVRListBox list = getMainContent();
        if (list instanceof QS001ScheduleListBox) {
            ((QS001ScheduleListBox) list)
                    .setDropAllowedServiceBitMask(dropAllowedServiceBitMask);
        }
    }

    /**
     * サービスマスタ を設定します。
     * 
     * @param serviceMaster サービスマスタ
     */
    public void setMasterService(VRMap serviceMaster) {
        AbstractVRListBox list = getMainContent();
        if (list instanceof QS001ScheduleListBox) {
            ((QS001ScheduleListBox) list).setMasterService(serviceMaster);
        }
    }

    /**
     * D&Dによる移動 を行なう を設定します。
     * 
     * @param moveMode D&Dによる移動を行なう
     */
    public void setMoveMode(boolean moveMode) {
        AbstractVRListBox list = getMainContent();
        if (list instanceof ACDroppableListBox) {
            ((ACDroppableListBox) list).setMoveMode(moveMode);
        }
    }

    /**
     * D&Dによる貼り付けを受け入れるか を設定します。
     * 
     * @param recieveMode D&Dによる貼り付けを受け入れるか
     */
    public void setRecieveMode(boolean recieveMode) {
        AbstractVRListBox list = getMainContent();
        if (list instanceof ACDroppableListBox) {
            ((ACDroppableListBox) list).setRecieveMode(recieveMode);
        }
    }

    protected AbstractVRListBox createMainContent() {
        return new QS001ScheduleListBox();
    }
}
