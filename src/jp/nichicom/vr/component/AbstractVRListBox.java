package jp.nichicom.vr.component;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import jp.nichicom.vr.bind.VRBindModelable;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.bind.VRBindable;
import jp.nichicom.vr.bind.event.VRBindEvent;
import jp.nichicom.vr.bind.event.VRBindEventListener;
import jp.nichicom.vr.bind.event.VRBindModelEvent;
import jp.nichicom.vr.bind.event.VRBindModelEventListener;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.adapter.VRListModelAdapter;

/**
 * バインド機構を実装したリストボックスの基底クラスです。
 * <p>
 * モデルバインド機構も実装しています。
 * </p>
 * <p>
 * 選択モードがListSelectionModel.SINGLE_SELECTIONの場合は選択している単一オジェクトがbind対象となり、それ以外の選択モードならば選択しているオブジェクトの配列がbind対象となります。
 * </p>
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/31
 * @see JList
 * @see VRBindable
 * @see VRBindEventListener
 * @see VRBindSource
 * @see VRBindModelable
 * @see VRBindModelEventListener
 */
@SuppressWarnings("serial")
public class AbstractVRListBox extends JList implements VRListBoxar {

    private boolean autoApplySource = false;
    private String bindPath;
    private String modelBindPath;
    private VRBindSource modelSource;
    private boolean shouldScrollOnSelect = true;
    private VRBindSource source;

    /**
     * Constructs a <code>JList</code> with an empty model.
     */
    public AbstractVRListBox() {
        super();
        initComponent();
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
    public AbstractVRListBox(ListModel dataModel) {
        super(dataModel);
        initComponent();
    }

    /**
     * Constructs a <code>JList</code> that displays the elements in the
     * specified array. This constructor just delegates to the
     * <code>ListModel</code> constructor.
     * 
     * @param listData the array of Objects to be loaded into the data model
     */
    public AbstractVRListBox(Object[] listData) {
        super(listData);
        initComponent();
    }

    /**
     * Constructs a <code>JList</code> that displays the elements in the
     * specified <code>Vector</code>. This constructor just delegates to the
     * <code>ListModel</code> constructor.
     * 
     * @param listData the <code>Vector</code> to be loaded into the data
     *            model
     */
    public AbstractVRListBox(Vector<?> listData) {
        super(listData);
        initComponent();
    }

    public void addBindEventListener(VRBindEventListener listener) {
        listenerList.add(VRBindEventListener.class, listener);
    }

    public void addBindModelEventListener(VRBindModelEventListener listener) {
        listenerList.add(VRBindModelEventListener.class, listener);
    }

    public void applyModelSource() throws ParseException {
        if (VRBindPathParser.set(getModelBindPath(), getModelSource(),
                getModel())) {
            fireModelApplySource(new VRBindModelEvent(this));
        }
    }

    public void applySource() throws ParseException {
        Object data;
        if (isSingleSelection()) {
            // 単一選択モードならば単一データをapply
            data = getSelectedValue();
        } else {
            // 複数選択モードならば複数データをapply
            data = getSelectedValues();
        }
        if (VRBindPathParser.set(getBindPath(), getSource(), data)) {
            fireApplySource(new VRBindEvent(this));
        }
    }

    public void bindModelSource() throws ParseException {
        if (!VRBindPathParser.has(getModelBindPath(), getModelSource())) {
            return;
        }
        if (bindModelSourceImpl(VRBindPathParser.get(getModelBindPath(),
                getModelSource()))) {
            fireModelBindSource(new VRBindModelEvent(this));
        }
    }

    /**
     * バインドモデルを処理します。
     * 
     * @param bindData バインドするモデルデータ
     * @throws ParseException 解析例外
     * @return バインドしたか
     */
    protected boolean bindModelSourceImpl(Object bindData)
            throws ParseException {
        bindData = formatBindModel(bindData);
        if (bindData instanceof ListModel) {
            setModel((ListModel) bindData);
        } else if (bindData instanceof VRBindSource) {
            setModel(new VRListModelAdapter((VRBindSource) bindData));
        } else if (bindData instanceof List) {
            setModel(new VRListModelAdapter(new VRArrayList((List) bindData)));
        } else if (bindData == null) {
            setModel(null);
        } else {
            return false;
        }
        return true;
    }

    public void bindSource() throws ParseException {
        if (!VRBindPathParser.has(getBindPath(), source)) {
            return;
        }
        if (bindSourceImpl(VRBindPathParser.get(getBindPath(), source))) {
            fireBindSource(new VRBindEvent(this));
        }

    }

    public Object createModelSource() {
        return new VRArrayList();
    }

    public Object createSource() {
        // 未選択(null)を返す
        return null;
    }

    /**
     * バインドイベントリスナを返します。
     * 
     * @return バインドイベントリスナ
     */
    public synchronized VRBindEventListener[] getBindEventListeners() {
        return (VRBindEventListener[]) (getListeners(VRBindEventListener.class));
    }

    /**
     * バインドモデルイベントリスナを返します。
     * 
     * @return バインドモデルイベントリスナ
     */
    public synchronized VRBindModelEventListener[] getBindModelEventListeners() {
        return (VRBindModelEventListener[]) (getListeners(VRBindModelEventListener.class));
    }

    public String getBindPath() {
        return bindPath;
    }

    public String getModelBindPath() {
        return modelBindPath;
    }

    public VRBindSource getModelSource() {
        return modelSource;
    }

    public VRBindSource getSource() {
        return source;
    }

    public boolean isAutoApplySource() {
        return this.autoApplySource;
    }

    /**
     * bindによる単一選択時に選択した項目が見えるようにスクロールするかを返します。
     * 
     * @return 選択した項目が見えるようにスクロールするか
     */
    public boolean isShouldScrollOnSelect() {
        return shouldScrollOnSelect;
    }

    /**
     * 単一選択モード(<code>ListSelectionModel.SINGLE_SELECTION</code>)であるかを返します。
     * 
     * @return 単一選択モードであるか
     */
    public boolean isSingleSelection() {
        return getSelectionMode() == ListSelectionModel.SINGLE_SELECTION;
    }

    public void removeBindEventListener(VRBindEventListener listener) {
        listenerList.remove(VRBindEventListener.class, listener);
    }

    public void removeBindModelEventListener(VRBindModelEventListener listener) {
        listenerList.remove(VRBindModelEventListener.class, listener);
    }

    public void setAutoApplySource(boolean autoApplySource) {
        this.autoApplySource = autoApplySource;
    }

    public void setBindPath(String bindPath) {
        this.bindPath = bindPath;
    }

    public void setModelBindPath(String modelBindPath) {
        this.modelBindPath = modelBindPath;
    }

    public void setModelSource(VRBindSource modelSource) {
        this.modelSource = modelSource;
    }

    /**
     * bindによる単一選択時に選択した項目が見えるようにスクロールするかを返します。
     * 
     * @param shouldScrollOnSelect 選択した項目が見えるようにスクロールするか
     */
    public void setShouldScrollOnSelect(boolean shouldScrollOnSelect) {
        this.shouldScrollOnSelect = shouldScrollOnSelect;
    }

    public void setSource(VRBindSource source) {
        this.source = source;
    }

    /**
     * バインドを処理します。
     * 
     * @param bindData バインドするデータ
     * @throws ParseException 解析例外
     * @return バインドしたか
     */
    protected boolean bindSourceImpl(Object bindData) throws ParseException {
        ListSelectionModel selModel = getSelectionModel();
        if (selModel != null) {
            // まずは選択をクリアする
            selModel.clearSelection();
            if (bindData instanceof List) {
                // List構造であれば配列化する
                bindData = ((List) bindData).toArray();
            }

            if (bindData instanceof Object[]) {
                // 配列上のデータをbindされた場合
                ListModel mdl = getModel();
                if (mdl != null) {
                    // データモデルを走査して選択すべき項目を洗う
                    Object[] array = (Object[]) bindData;
                    int end = mdl.getSize();
                    for (int i = 0; i < end; i++) {
                        int find = Arrays.binarySearch(array, mdl
                                .getElementAt(i));
                        if (find >= 0) {
                            // 該当した項目を選択する
                            selModel.addSelectionInterval(find, find);
                        }
                    }
                }
            } else {
                // 単一のデータをbindされた場合
                setSelectedValue(bindData, isShouldScrollOnSelect());
            }
            return true;
        }
        return false;
    }

    /**
     * バインドイベントリスナを全走査してapplySourceイベントを呼び出します。
     * 
     * @param e イベント情報
     */
    protected void fireApplySource(VRBindEvent e) {
        VRBindEventListener[] listeners = getBindEventListeners();
        for (int i = 0; i < listeners.length; i++) {
            listeners[i].applySource(e);
        }
    }

    /**
     * バインドイベントリスナを全走査してbindSourceイベントを呼び出します。
     * 
     * @param e イベント情報
     */
    protected void fireBindSource(VRBindEvent e) {
        VRBindEventListener[] listeners = getBindEventListeners();
        for (int i = 0; i < listeners.length; i++) {
            listeners[i].bindSource(e);
        }
    }

    /**
     * モデルバインドイベントリスナを全走査してapplyModelSourceイベントを呼び出します。
     * 
     * @param e イベント情報
     */
    protected void fireModelApplySource(VRBindModelEvent e) {
        VRBindModelEventListener[] listeners = getBindModelEventListeners();
        for (int i = 0; i < listeners.length; i++) {
            listeners[i].applyModelSource(e);
        }
    }

    /**
     * モデルバインドイベントリスナを全走査してbindModelSourceイベントを呼び出します。
     * 
     * @param e イベント情報
     */
    protected void fireModelBindSource(VRBindModelEvent e) {
        VRBindModelEventListener[] listeners = getBindModelEventListeners();
        for (int i = 0; i < listeners.length; i++) {
            listeners[i].bindModelSource(e);
        }
    }

    /**
     * バインドするモデルを必要に応じて変換して返します。
     * 
     * @param src バインドするモデル
     * @return 変換結果のバインドするモデル
     */
    protected Object formatBindModel(Object src) {
        return src;
    }

    /**
     * コンストラクタ実行後に必ず呼ばれる初期化処理です。
     */
    protected void initComponent() {

    }
}
