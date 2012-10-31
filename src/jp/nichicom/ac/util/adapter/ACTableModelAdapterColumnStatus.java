package jp.nichicom.ac.util.adapter;

import java.util.ArrayList;
import java.util.Collection;

import jp.nichicom.vr.util.VRArrayList;

/**
 * 結合カラム化が可能なカラムの結合状態クラスです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/01/13
 * @see ACTableModelAdapter
 * @see ACTableModelAdapterColumn
 * @see ACTableModelAdapterLiteral
 * @see ACTableModelAdapterRemovableLiteral
 */
public class ACTableModelAdapterColumnStatus extends VRArrayList {
    private String columnName;
    private boolean useRemovableLiteral = false;

    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public ACTableModelAdapterColumnStatus() {
        super();
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     * 
     * @param initialCapacity the initial capacity of the list.
     * @exception IllegalArgumentException if the specified initial capacity is
     *                negative
     */
    public ACTableModelAdapterColumnStatus(Collection c) {
        super(c);
    }

    /**
     * Constructs a list containing the elements of the specified collection, in
     * the order they are returned by the collection's iterator. The
     * <tt>ArrayList</tt> instance has an initial capacity of 110% the size of
     * the specified collection.
     * 
     * @param c the collection whose elements are to be placed into this list.
     * @throws NullPointerException if the specified collection is null.
     */
    public ACTableModelAdapterColumnStatus(int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * コンストラクタです。
     * 
     * @param columnName 解析すべきカラム名
     */
    public ACTableModelAdapterColumnStatus(String columnName) {
        super();
        setColumnName(columnName);
    }

    /**
     * カラム名 を返します。
     * 
     * @return カラム名
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * 指定行列のデータを返します。
     * 
     * @param rowIndex 行番号
     * @param columnIndex 列番号
     * @param model データ参照もとのモデル
     * @return データ
     */
    public Object getValueAt(int rowIndex, int columnIndex,
            ACTableModelAdapter model) {
        // 結合設定を解釈する
        StringBuilder sb = new StringBuilder();

        int end = size();

        if (isUseRemovableLiteral()) {
            // すべてのデータがnullか空文字であるかによって出力するかを変更するリテラルがある
            ArrayList list = new ArrayList();

            boolean dataEmpty = true;
            for (int i = 0; i < end; i++) {
                Object status = get(i);
                if (status instanceof ACTableModelAdapterColumn) {
                    Object data = model.getValueAt(rowIndex,
                            ((ACTableModelAdapterColumn) status)
                                    .getColumnName());
                    list.add(data);
                    if ((data != null) && (!"".equals(data))) {
                        // カラムのデータはnullおよび空文字ではない。
                        dataEmpty = false;
                    }
                } else {
                    // リテラル
                    list.add(status);
                }
            }

            if (dataEmpty) {
                // すべてのデータが空であったため、除外カラムを考慮して出力する
                for (int i = 0; i < end; i++) {
                    Object status = get(i);
                    if (status instanceof ACTableModelAdapterColumn) {
                        Object data = list.get(i);
                        if (data != null) {
                            sb.append(data);
                        }
                    } else if (!(status instanceof ACTableModelAdapterRemovableLiteral)) {
                        // 除外の可能性のあるリテラル以外
                        sb.append(list.get(i));
                    }
                }
            } else {
                // すべてのデータが空でなかったため、すべて出力する
                for (int i = 0; i < end; i++) {
                    Object data = list.get(i);
                    if (data != null) {
                        sb.append(data);
                    }
                }
            }
            return sb.toString();

        } else {
            // すべてカラム名か必須出力のリテラル
            for (int i = 0; i < end; i++) {
                Object status = get(i);
                if (status instanceof ACTableModelAdapterColumn) {
                    Object data = model.getValueAt(rowIndex,
                            ((ACTableModelAdapterColumn) status)
                                    .getColumnName());
                    if (data != null) {
                        sb.append(data);
                    }
                } else {
                    // リテラル
                    sb.append(status);
                }
            }
            return sb.toString();
        }

    }

    /**
     * データがすべてnullもしくは空文字ならば除外されるリテラル文字列を使用しているか を返します。
     * 
     * @return データがすべてnullもしくは空文字ならば除外されるリテラル文字列を使用しているか
     */
    public boolean isUseRemovableLiteral() {
        return useRemovableLiteral;
    }

    /**
     * カラム名 を設定します。
     * 
     * @param columnName カラム名
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName;
        parseConcatStatus(columnName);
    }

    /**
     * データがすべてnullもしくは空文字ならば除外されるリテラル文字列を使用しているか を設定します。
     * 
     * @param useRemovableLiteral データがすべてnullもしくは空文字ならば除外されるリテラル文字列を使用しているか
     */
    public void setUseRemovableLiteral(boolean useRemovableLiteral) {
        this.useRemovableLiteral = useRemovableLiteral;
    }

    /**
     * 結合設定を解析します。
     * <p>
     * 結合設定がなされていないから無名であれば、要素数0になります。
     * </p>
     * 
     * @param column 解析対象のカラム名
     */
    protected void parseConcatStatus(String column) {
        // 結合識別子
        final String CONCAT_TOKEN = "+";
        // エスケープシーケンス
        final char ESCAPE_TAG = '\\';
        // リテラル文字を囲む識別子
        final String LITERAL_QUOTE = "\"";
        // データがすべてnullもしくは空文字ならば除外されるリテラル文字を囲む識別子
        final String REMOVABLE_LITERAL_QUOTE = "'";

        clear();
        setUseRemovableLiteral(false);
        String[] array = column.split(ESCAPE_TAG + CONCAT_TOKEN);
        int arrayLength = array.length;
        if (arrayLength <= 1) {
            // トークン(+)がなければリテラルを含まない
            return;
        }

        StringBuilder sb = new StringBuilder();
        ArrayList list = new ArrayList();
        for (int j = 0; j < arrayLength; j++) {
            // カラム名を+で分割して走査する
            String concat = array[j];
            if (!"".equals(concat)) {
                boolean escaping = false;
                int len = concat.length();
                for (int k = 0; k < len; k++) {
                    // エスケープシーケンスの走査
                    char c = concat.charAt(k);
                    if (c == ESCAPE_TAG) {
                        if (escaping) {
                            // エスケープシーケンスの連続はエスケープ文字
                            sb.append(ESCAPE_TAG);
                        }
                        escaping = !escaping;
                    } else {
                        sb.append(concat.charAt(k));
                        escaping = false;
                    }
                }
                if (escaping) {
                    // エスケープシーケンスで終わった
                    // →次の要素を連結する
                    sb.append(CONCAT_TOKEN);
                    continue;
                }

                String val = sb.toString();
                if (val.startsWith(LITERAL_QUOTE)) {
                    // リテラル開始文字で始まっている
                    if (!val.endsWith(LITERAL_QUOTE)) {
                        // リテラル終端文字で終わっていない（リテラル中のトークン）
                        // →次の要素を連結する
                        sb.append(CONCAT_TOKEN);
                        continue;
                    }
                    // リテラル文字として追加
                    list.add(new ACTableModelAdapterLiteral(val.substring(1,
                            val.length() - 1)));
                } else if (val.startsWith(REMOVABLE_LITERAL_QUOTE)) {
                    // 除外リテラル開始文字で始まっている
                    if (!val.endsWith(REMOVABLE_LITERAL_QUOTE)) {
                        // 除外リテラル終端文字で終わっていない（リテラル中のトークン）
                        // →次の要素を連結する
                        sb.append(CONCAT_TOKEN);
                        continue;
                    }
                    // リテラル文字として追加
                    list.add(new ACTableModelAdapterRemovableLiteral(val
                            .substring(1, val.length() - 1)));
                    setUseRemovableLiteral(true);
                } else {
                    // カラムの列名を追加
                    list.add(new ACTableModelAdapterColumn(val));// new
                    // Integer(getColumnIndex(val)));
                }
            }

            sb = new StringBuilder();
        }
        addAll(list);
    }
}
