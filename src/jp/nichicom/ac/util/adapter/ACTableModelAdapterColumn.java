package jp.nichicom.ac.util.adapter;

/**
 * 結合カラムにおけるカラム名です。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/01/13
 * @see ACTableModelAdapter
 */
public class ACTableModelAdapterColumn {
    private String columnName;

    /**
     * コンストラクタです。
     */
    public ACTableModelAdapterColumn() {
        super();
    }

    /**
     * コンストラクタです。
     * 
     * @param columnName カラム名
     */
    public ACTableModelAdapterColumn(String columnName) {
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
     * カラム名 を設定します。
     * 
     * @param columnName カラム名
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String toString() {
        return getColumnName();
    }
}
