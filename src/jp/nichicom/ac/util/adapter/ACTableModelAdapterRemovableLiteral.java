package jp.nichicom.ac.util.adapter;

/**
 * 結合カラムにおけるデータがすべてnullもしくは空文字ならば除外されるリテラル文字列です。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/01/13
 * @see ACTableModelAdapter
 * @see ACTableModelAdapterLiteral
 */
public class ACTableModelAdapterRemovableLiteral extends
        ACTableModelAdapterLiteral {

    /**
     * コンストラクタです。
     */
    public ACTableModelAdapterRemovableLiteral() {
        super();
    }

    /**
     * コンストラクタです。
     * 
     * @param text 表示すべき文字列
     */
    public ACTableModelAdapterRemovableLiteral(String text) {
        super(text);
    }

}
