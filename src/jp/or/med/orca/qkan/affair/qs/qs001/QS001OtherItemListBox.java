package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.Component;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.swing.ListModel;

import jp.nichicom.ac.component.ACListBox;
import jp.nichicom.vr.component.AbstractVRListBox;

/**
 * その他や日常生活上の活動に使用するリストボックスです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/31
 */
public class QS001OtherItemListBox extends ACListBox {

    /**
     * Creates an empty (no viewport view) <code>JScrollPane</code> where both
     * horizontal and vertical scrollbars appear when needed.
     */
    public QS001OtherItemListBox() {
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
    public QS001OtherItemListBox(Component view) {
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
    public QS001OtherItemListBox(Component view, int vsbPolicy, int hsbPolicy) {
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
    public QS001OtherItemListBox(ListModel dataModel) {
        super(dataModel);
    }

    /**
     * Constructs a <code>JList</code> that displays the elements in the
     * specified array. This constructor just delegates to the
     * <code>ListModel</code> constructor.
     * 
     * @param listData the array of Objects to be loaded into the data model
     */
    public QS001OtherItemListBox(Object[] listData) {
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
    public QS001OtherItemListBox(Vector listData) {
        super(listData);
    }

    /**
     * バインド対象のキー集合を返します。
     * 
     * @return バインド対象のキー集合
     */
    public String[] getBindPathes() {
        if (getMainContent() instanceof QS001BindModelValueListBox) {
            return ((QS001BindModelValueListBox) getMainContent())
                    .getBindPathes();
        }
        return null;
    }

    /**
     * バインド対象のキー集合を設定します。
     * 
     * @param bindPathes バインド対象のキー集合
     */
    public void setBindPathes(List bindPathes) {
        if (getMainContent() instanceof QS001BindModelValueListBox) {
            ((QS001BindModelValueListBox) getMainContent())
                    .setBindPathes(bindPathes);
        }
    }

    /**
     * バインド対象のキー集合を設定します。
     * 
     * @param bindPathes バインド対象のキー集合
     */
    public void setBindPathes(Object[] bindPathes) {
        if (getMainContent() instanceof QS001BindModelValueListBox) {
            ((QS001BindModelValueListBox) getMainContent())
                    .setBindPathes(bindPathes);
        }
    }

    /**
     * バインド対象のキー集合を設定します。
     * 
     * @param bindPathes バインド対象のキー集合
     */
    public void setBindPathes(Set bindPathes) {
        if (getMainContent() instanceof QS001BindModelValueListBox) {
            ((QS001BindModelValueListBox) getMainContent())
                    .setBindPathes(bindPathes);
        }
    }

    /**
     * バインド対象のキー集合を設定します。
     * 
     * @param bindPathes バインド対象のキー集合
     */
    public void setBindPathes(String[] bindPathes) {
        if (getMainContent() instanceof QS001BindModelValueListBox) {
            ((QS001BindModelValueListBox) getMainContent())
                    .setBindPathes(bindPathes);
        }
    }

    protected AbstractVRListBox createMainContent() {
        return new QS001BindModelValueListBox();
    }
}
