package jp.or.med.orca.qkan.affair.qs.qs001;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.swing.ListModel;

import jp.nichicom.ac.component.ACMutableListBox;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.bind.event.VRBindEvent;

/**
 * バインドによってモデルを書き換えるリストボックスです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/31
 */
public class QS001BindModelValueListBox extends ACMutableListBox {
    private String[] bindPathes;

    /**
     * Constructs a <code>JList</code> with an empty model.
     */
    public QS001BindModelValueListBox() {
        super();
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
    public QS001BindModelValueListBox(ListModel dataModel) {
        super(dataModel);
    }

    /**
     * Constructs a <code>JList</code> that displays the elements in the
     * specified array. This constructor just delegates to the
     * <code>ListModel</code> constructor.
     * 
     * @param listData the array of Objects to be loaded into the data model
     */
    public QS001BindModelValueListBox(Object[] listData) {
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
    public QS001BindModelValueListBox(Vector listData) {
        super(listData);
    }

    public void applySource() throws ParseException {

        VRBindSource source = getSource();
        if (source != null) {
            // 設定先ソースがnullでない場合
            String[] pathes = getBindPathes();
            if (pathes != null) {
                // パスがnullでない場合
                ListModel mdl = getModel();
                if (mdl != null) {
                    // モデルがnullでない場合
                    Map result = new HashMap();
                    Map blanks = new HashMap();
                    int end = Math.min(mdl.getSize(), pathes.length);
                    // モデルの値を順にパスと関連付ける
                    for (int i = 0; i < end; i++) {
                        Object data = mdl.getElementAt(i);
                        if(data!=null){
                            result.put(pathes[i], data);
                            if(!blanks.isEmpty()){
                                //データがあった場合はそこまでのnullデータも追加
                                result.putAll(blanks);
                                blanks = new HashMap();
                            }
                        }else{
                            //データがない場合はnull用マップに格納
                            blanks.put(pathes[i], data);
                        }
                    }

                    if (!result.isEmpty()) {
                        // 1件以上抽出したら
                        if (source instanceof Map) {
                            // 設定先がMapなら一括転記
                            ((Map) source).putAll(result);
                        } else if (source instanceof List) {
                            // 設定先がListなら逐次追加
                            Iterator it = result.entrySet().iterator();
                            while (it.hasNext()) {
                                source.addData(it.next());
                            }
                        } else {
                            // 設定先が不明なら逐次設定
                            Iterator it = result.entrySet().iterator();
                            while (it.hasNext()) {
                                Map.Entry ent = (Map.Entry) it.next();
                                source.setData(ent.getKey(), ent.getValue());
                            }
                        }
                        // イベント発行
                        fireApplySource(new VRBindEvent(this));
                    }

                }
            }
        }
    }

    public void bindSource() throws ParseException {

        String[] pathes = getBindPathes();
        if (pathes != null) {
            List result = new ArrayList();
            int end = pathes.length;
            int lastFind = -1;
            for (int i = 0; i < end; i++) {
                if (VRBindPathParser.has(pathes[i], getSource())) {
                    Object data = VRBindPathParser.get(pathes[i], getSource());
                    result.add(data);
                    lastFind = i;
                } else {
                    // パスが該当しない行はnullで追加
                    result.add(null);
                }
            }

            if(lastFind<result.size()-1){
                //末尾の空データは除去
                result = result.subList(0, lastFind + 1);
            }
            // 上位クラスのbindを利用
            if (bindModelSourceImpl(result)) {
                fireBindSource(new VRBindEvent(this));
            }

        }

    }

    public String getBindPath() {
        String[] pathes = getBindPathes();
        if ((pathes != null) && (pathes.length > 0)) {
            return pathes[0];
        }
        return null;
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

}
