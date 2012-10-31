package jp.nichicom.ac.util.adapter;

/**
 * 結合カラムにおけるリテラル文字列です。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/01/13
 * @see ACTableModelAdapter
 */
public class ACTableModelAdapterLiteral {
    private String text;

    /**
     * コンストラクタです。
     */
    public ACTableModelAdapterLiteral() {
        super();
    }

    /**
     * コンストラクタです。
     * 
     * @param text 文字列
     */
    public ACTableModelAdapterLiteral(String text) {
        super();
        setText(text);
    }

    /**
     * 表示すべき文字列 を返します。
     * 
     * @return 表示すべき文字列
     */
    public String getText() {
        return text;
    }

    /**
     * 表示すべき文字列 を設定します。
     * 
     * @param text 表示すべき文字列
     */
    public void setText(String text) {
        this.text = text;
    }

    public String toString() {
        return getText();
    }

}
