package jp.nichicom.ac.component;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.Action;
import javax.swing.Icon;

import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.bind.event.VRBindEvent;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;

/**
 * Map形式でデータをバインドするボタンです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/31
 */
public class ACMapBindButton extends ACButton {
    private VRMap dataModel;
    private String[] bindPathes;

    /**
     * Creates a button with no set text or icon.
     */
    public ACMapBindButton() {
        super();
    }

    /**
     * Creates a button where properties are taken from the <code>Action</code>
     * supplied.
     * 
     * @param a the <code>Action</code> used to specify the new button
     * @since 1.3
     */
    public ACMapBindButton(Action a) {
        super(a);
    }

    /**
     * Creates a button with an icon.
     * 
     * @param icon the Icon image to display on the button
     */
    public ACMapBindButton(Icon icon) {
        super(icon);
    }

    /**
     * Creates a button with text.
     * 
     * @param text the text of the button
     */
    public ACMapBindButton(String text) {
        super(text);
    }

    /**
     * Creates a button with initial text and an icon.
     * 
     * @param text the text of the button
     * @param icon the Icon image to display on the button
     */
    public ACMapBindButton(String text, Icon icon) {
        super(text, icon);
    }

    public void applySource() throws ParseException {
        VRMap map = getDataModel();
        if (map != null) {
            boolean processed = false;

            String[] pathes = getBindPathes();
            if (pathes != null) {
                int end = pathes.length;
                for (int i = 0; i < end; i++) {
                    if (VRBindPathParser.has(pathes[i], map)) {
                        processed |= VRBindPathParser.set(pathes[i],
                                getSource(), VRBindPathParser.get(pathes[i],
                                        map));
                    }
                }
            }

            if (processed) {
                fireApplySource(new VRBindEvent(this));
            }
        }
    }

    public void bindSource() throws ParseException {
        VRMap map = getDataModel();
        if (map != null) {

            boolean processed = false;

            String[] pathes = getBindPathes();
            if (pathes != null) {
                int end = pathes.length;
                for (int i = 0; i < end; i++) {
                    if (VRBindPathParser.has(pathes[i], getSource())) {
                        processed |= VRBindPathParser.set(pathes[i], map,
                                VRBindPathParser.get(pathes[i], getSource()));
                    }
                }
            }

            if (processed) {
                fireBindSource(new VRBindEvent(this));
            }
        }
    }

    /**
     * バインド対象のキーと値の集合をクリアします。
     */
    public void clearData() {
        Map map = getDataModel();
        if (map != null) {
            map.clear();
        }
    }

    public Object createSource() {
        return null;
    }

    public String getBindPath() {
        String[] pathes = getBindPathes();
        if ((pathes != null) && (pathes.length > 0)) {
            return pathes[0];
        }
        return "";
    }

    /**
     * バインド対象のキーと値の集合 を返します。
     * 
     * @return バインド対象のキーと値の集合
     */
    public VRMap getDataModel() {
        return dataModel;
    }

    /**
     * バインド対象のキー集合を返します。
     * 
     * @return バインド対象のキー集合
     */
    public String[] getBindPathes() {
        return bindPathes;
    }

    public void setBindPath(String bindPath) {
        setBindPathes(new String[] { bindPath });
    }

    /**
     * バインド対象のキーと値の集合 を設定します。
     * 
     * @param bindPathMap バインド対象のキーと値の集合
     */
    public void setDataModel(VRMap bindPathMap) {
        this.dataModel = bindPathMap;
    }

    /**
     * バインド対象のキー集合を設定します。
     * 
     * @param bindPathes バインド対象のキー集合
     */
    public void setBindPathes(List bindPathes) {
        if (bindPathes != null) {
            setBindPathes(bindPathes.toArray());
        }
    }

    /**
     * バインド対象のキー集合を設定します。
     * 
     * @param bindPathes バインド対象のキー集合
     */
    public void setBindPathes(Object[] bindPathes) {
        if (bindPathes != null) {
            setBindPathes((String[]) toStringArray(bindPathes));
        }
    }

    /**
     * バインド対象のキー集合を設定します。
     * 
     * @param bindPathes バインド対象のキー集合
     */
    public void setBindPathes(Set bindPathes) {
        if (bindPathes != null) {
            setBindPathes(bindPathes.toArray());
        }
    }

    /**
     * バインド対象のキー集合を設定します。
     * 
     * @param bindPathes バインド対象のキー集合
     */
    public void setBindPathes(String[] bindPathes) {
        this.bindPathes = bindPathes;
    }

    /**
     * 初期状態のモデルを生成します。
     * 
     * @return 初期状態のモデル
     */
    protected VRMap createDataModel() {
        return new VRHashMap();
    }

    protected void initComponent() {
        super.initComponent();
        setDataModel(createDataModel());
    }

    /**
     * 文字列配列に変換します。
     * 
     * @param array 配列
     * @return 文字列配列
     */
    protected String[] toStringArray(Object[] array) {
        if (!(array instanceof String[])) {
            int len = array.length;
            String[] newArray = new String[len];
            for (int i = 0; i < len; i++) {
                newArray[i] = String.valueOf(array[i]);
            }
            array = newArray;
        }
        return (String[]) array;
    }

    /**
     * データモデルを初期化します。
     */
    public void clearDataModel() {
        if (getDataModel() != null) {
            getDataModel().clear();
        }
    }
}
