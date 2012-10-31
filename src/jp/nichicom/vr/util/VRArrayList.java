/** TODO <HEAD> */
package jp.nichicom.vr.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.bind.event.VRBindSourceEvent;
import jp.nichicom.vr.bind.event.VRBindSourceEventListener;

/**
 * バインドソース機構を実装したArrayListクラスです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2005/10/31
 * @see ArrayList
 * @see VRBindSource
 * @see VRBindSourceEventListener
 */
@SuppressWarnings("serial")
public class VRArrayList extends ArrayList implements VRList {
    protected ArrayList<VRBindSourceEventListener> listeners = new ArrayList<VRBindSourceEventListener>();

    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public VRArrayList() {
        super();
    }

    /**
     * Constructs a list containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.  The <tt>ArrayList</tt> instance has an initial capacity of
     * 110% the size of the specified collection.
     *
     * @param c the collection whose elements are to be placed into this list.
     * @throws NullPointerException if the specified collection is null.
     */
    public VRArrayList(Collection c) {
        super(c);
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param   initialCapacity   the initial capacity of the list.
     * @exception IllegalArgumentException if the specified initial capacity
     *            is negative
     */
    public VRArrayList(int initialCapacity) {
        super(initialCapacity);
    }

    public void add(int index, Object element) {
        super.add(index, element);
        addElementListener(element);
        fireAddSource();
    }

    public boolean add(Object o) {
        if (super.add(o)) {
            addElementListener(o);
            fireAddSource();
            return true;
        }
        return false;
    }

    public boolean addAll(Collection c) {
        if (super.addAll(c)) {
            addElementListener(c);
            fireAddSource();
            return true;
        }
        return false;
    }

    public boolean addAll(int index, Collection c) {
        if (super.addAll(index, c)) {
            addElementListener(c);
            fireAddSource();
            return true;
        }
        return false;
    }

    public void addBindSourceEventListener(VRBindSourceEventListener listener) {
        if ((listener instanceof VRBindSourceEventListener)
                && (listener != this)) {
            listeners.add(listener);
        }
    }

    public void addData(Object data) {
        add(data);
    }

    public void addSource(VRBindSourceEvent e) {
        Iterator<VRBindSourceEventListener> it = listeners.iterator();
        while (it.hasNext()) {
            it.next().addSource(e);
        }
    }

    public void changeSource(VRBindSourceEvent e) {
        Iterator<VRBindSourceEventListener> it = listeners.iterator();
        while (it.hasNext()) {
            it.next().changeSource(e);
        }
    }

    public void clear() {
        removeElementListener(this);
        super.clear();
        fireClearSource();
    }

    public void clearData() {
        clear();
    }

    public void clearSource(VRBindSourceEvent e) {
        Iterator<VRBindSourceEventListener> it = listeners.iterator();
        while (it.hasNext()) {
            it.next().clearSource(e);
        }
    }

    public Object getData() {
        return getData(0);
    }

    public Object getData(int index) {
        return get(index);
    }

    public Object getData(Object key) {
        return getData(parseKey(key));
    }

    public int getDataSize() {
        return size();
    }

    public Object remove(int index) {
        Object ret = removeElementListener(super.remove(index));
        fireRemoveSource(index, null);
        return ret;
    }

    public void removeBindSourceEventListener(VRBindSourceEventListener listener) {
        listeners.remove(listener);
    }

    public void removeData(int index) {
        remove(index);
    }

    public void removeData(Object key) {
        removeData(parseKey(key));
    }

    public void removeSource(VRBindSourceEvent e) {
        Iterator<VRBindSourceEventListener> it = listeners.iterator();
        while (it.hasNext()) {
            it.next().removeSource(e);
        }
    }

    public Object set(int index, Object element) {
        addElementListener(element);
        Object ret = removeElementListener(super.set(index, element));
        fireChangeSource(index, null);
        return ret;
    }

    public void setData(int index, Object data) {
        set(index, data);
    }

    public void setData(Object data) {
        setData(0, data);
    }

    public void setData(Object key, Object data) {
        setData(parseKey(key), data);

    }

    /**
     * 集合内の要素がVRBindSourceの場合は自身をリスナとして登録します。
     * 
     * @param c 要素集合
     */
    protected void addElementListener(Collection c) {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            if (o instanceof VRBindSource) {
                ((VRBindSource) o).addBindSourceEventListener(this);
            }
        }
    }

    /**
     * 要素がVRBindSourceの場合は自身をリスナとして登録します。
     * 
     * @param o 要素
     */
    protected void addElementListener(Object o) {
        if (o instanceof VRBindSource) {
            ((VRBindSource) o).addBindSourceEventListener(this);
        }
    }

    /**
     * ファイナライザです。
     */
    protected void finalize() {
        removeElementListener(this);
    }

    /**
     * バインドソースの追加をリスナに通知します。
     */
    protected void fireAddSource() {
        Iterator<VRBindSourceEventListener> it = listeners.iterator();
        VRBindSourceEvent e = new VRBindSourceEvent(this, getDataSize() - 1, null);
        while (it.hasNext()) {
            it.next().addSource(e);
        }
    }

    /**
     * バインドソースの変更をリスナに通知します。
     * 
     * @param index 要素番号
     * @param key 要素キー
     */
    protected void fireChangeSource(int index, Object key) {
        Iterator<VRBindSourceEventListener> it = listeners.iterator();
        VRBindSourceEvent e = new VRBindSourceEvent(this, index, key);
        while (it.hasNext()) {
            it.next().changeSource(e);
        }
    }

    /**
     * バインドソース集合の初期化をリスナに通知します。
     */
    protected void fireClearSource() {
        Iterator<VRBindSourceEventListener> it = listeners.iterator();
        VRBindSourceEvent e = new VRBindSourceEvent(this, -1, null);
        while (it.hasNext()) {
            it.next().clearSource(e);
        }
    }

    /**
     * バインドソースの削除をリスナに通知します。
     * 
     * @param index 要素番号
     * @param key 要素キー
     */
    protected void fireRemoveSource(int index, Object key) {
        Iterator<VRBindSourceEventListener> it = listeners.iterator();
        VRBindSourceEvent e = new VRBindSourceEvent(this, index, key);
        while (it.hasNext()) {
            it.next().removeSource(e);
        }
    }

    /**
     * キーを解析してインデックスとして返します。
     * 
     * @param key キー
     * @return インデックス
     */
    protected int parseKey(Object key) {
        if (key instanceof Integer) {
            return ((Integer) key).intValue();
        } else {
            return Integer.parseInt(String.valueOf(key));
        }
    }

    /**
     * 集合内要素のリスナから自身を除外します。
     * 
     * @param c 要素集合
     */
    protected void removeElementListener(Collection c) {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            removeElementListener(it.next());
        }
    }

    /**
     * 要素のリスナから自身を除外します。
     * 
     * @param o 要素
     */
    protected Object removeElementListener(Object o) {
        if (o instanceof VRBindSource) {
            ((VRBindSource) o).removeBindSourceEventListener(this);
        }
        return o;
    }

}