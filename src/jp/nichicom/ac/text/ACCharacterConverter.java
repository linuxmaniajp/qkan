package jp.nichicom.ac.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

/**
 * 基本的な文字列置換を行うクラスです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Tozo Tanaka
 * @version 1.0 2006/05/12
 */
public class ACCharacterConverter extends Format {
    /**
     * すべての文字を対象とすることを表す変換元定数です。
     */
    public static int FROM_ALL = 0;
    /**
     * 半角文字を対象とすることを表す変換元定数です。
     */
    public static int FROM_HALF_CHAR = 2<<2;
    /**
     * 半角カタカナを対象とすることを表す変換元定数です。
     */
    public static int FROM_HALF_KATAKANA = 2<<4;
    /**
     * 小文字を対象とすることを表す変換元定数です。
     */
    public static int FROM_LOWER = 2<<0;
    /**
     * 大文字を対象とすることを表す変換元定数です。
     */
    public static int FROM_UPPER = 2<<1;
    /**
     * 全角文字を対象とすることを表す変換元定数です。
     */
    public static int FROM_WIDE_CHAR = 2<<3;
    /**
     * 全角ひらがなを対象とすることを表す変換元定数です。
     */
    public static int FROM_WIDE_HIRAGANA = 2<<6;

    /**
     * 全角カタカナを対象とすることを表す変換元定数です。
     */
    public static int FROM_WIDE_KATAKANA = 2<<5;
    /**
     * 半角文字に変換することを表す変換結果定数です。
     */
    public static int TO_HALF_CHAR = 2<<2;
    /**
     * 半角カタカナに変換することを表す変換結果定数です。
     */
    public static int TO_HALF_KATAKANA = 2<<4;
    /**
     * 小文字に変換することを表す変換結果定数です。
     */
    public static int TO_LOWER = 2<<0;
    /**
     * 大文字に変換することを表す変換結果定数です。
     */
    public static int TO_UPPER = 2<<1;
    /**
     * 全角文字に変換することを表す変換結果定数です。
     */
    public static int TO_WIDE_CHAR = 2<<3;
    /**
     * 全角ひらがなに変換することを表す変換結果定数です。
     */
    public static int TO_WIDE_HIRAGANA = 2<<6;
    /**
     * 全角カタカナに変換することを表す変換結果定数です。
     */
    public static int TO_WIDE_KATAKANA = 2<<5;
    private int fromCharacter;
    private int toCharacter;
    
    /**
     * コンストラクタです。
     */
    public ACCharacterConverter() {
        super();
    }
    /**
     * コンストラクタです。
     * @param toCharacter 変換結果
     */
    public ACCharacterConverter(int toCharacter) {
        this(toCharacter, FROM_ALL);
    }
    /**
     * コンストラクタです。
     * @param toCharacter 変換結果の文字種別
     * @param fromCharacter 変換対象の文字種別
     */
    public ACCharacterConverter(int toCharacter, int fromCharacter) {
        super();
        setToCharacter(toCharacter);
        setFromCharacter(fromCharacter);
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
        toAppendTo.append(format(String.valueOf(obj), getToCharacter(), getFromCharacter()));
        return toAppendTo;
    }
    
    /**
     * 文字変換結果を返します。
     * @param src 変換元
     * @param toCharacter 変換結果の文字種別
     * @param fromCharacter 変換対象の文字種別
     * @return 文字変換結果
     */
    public String format(String src, int toCharacter, int fromCharacter) {
        
        if((toCharacter&TO_LOWER)!=0){
            src = src.toLowerCase();
        } 
        if((toCharacter&TO_UPPER)!=0){
            src = src.toUpperCase();
        } 
        if((toCharacter&TO_WIDE_CHAR)!=0){
            src = ACKanaConvert.toFullWidth(src);
        } 
        if((toCharacter&TO_WIDE_KATAKANA)!=0){
            src = ACKanaConvert.toKatakana(src);
        } 
        if((toCharacter&TO_HALF_CHAR)!=0){
            if((toCharacter&TO_HALF_KATAKANA)!=0){
                src = ACKanaConvert.toKatakana(src);
            } 
            src = ACKanaConvert.toHalfWidth(src);
        } 
        
        return src;
    }
    /**
     * 変換対象の文字種別 を返します。
     * @return 変換対象の文字種別
     */
    public int getFromCharacter() {
        return fromCharacter;
    }

    /**
     * 変換結果の文字種別 を返します。
     * @return 変換結果の文字種別
     */
    public int getToCharacter() {
        return toCharacter;
    }

    public Object parseObject(String source, ParsePosition pos) {
        return source;
    }
    
    /**
     * 変換対象の文字種別 を設定します。
     * @param fromCharacter 変換対象の文字種別
     */
    public void setFromCharacter(int fromCharacter) {
        this.fromCharacter = fromCharacter;
    }
    
    /**
     * 変換結果の文字種別 を設定します。
     * @param toCharacter 変換結果の文字種別
     */
    public void setToCharacter(int toCharacter) {
        this.toCharacter = toCharacter;
    }

}
