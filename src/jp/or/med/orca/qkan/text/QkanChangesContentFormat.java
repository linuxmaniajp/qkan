package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

/**
 * 異動事由(編集済)を渡された場合、区分から名称に変換するフォーマットです。<br>
 * 利用者登録(QU002)で使用します。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Kazuyoshi Kamitsukasa
 * @version 1.0 2006/01/20
 * @see Format
 */
public class QkanChangesContentFormat extends Format{
    private static QkanChangesContentFormat singleton;

    /**
     * コンストラクタです。
     * 
     * @deprecated #getInstanceを使用してください。
     */
    public QkanChangesContentFormat() {
        super();
    }

    /**
     * インスタンスを返します。
     * 
     * @return インスタンス
     */
    public static QkanChangesContentFormat getInstance() {
        if (singleton == null) {
            singleton = new QkanChangesContentFormat();
        }
        return singleton;
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {

        if (obj == null)
            return new StringBuffer();

        String code = String.valueOf(obj);

        // 異動事由(編集済)の区分の判定を行う。
        // 11-開始
        if ("11".equals(code)) {
            toAppendTo.append("開始");
            // 12-中止
        } else if ("12".equals(code)) {
            toAppendTo.append("中止");
            // 21-入所
        } else if ("21".equals(code)) {
            toAppendTo.append("入所");
            // 22-退所
        } else if ("22".equals(code)) {
            toAppendTo.append("退所");
            // 31-入院
        } else if ("31".equals(code)) {
            toAppendTo.append("入院");
            // 32-退院
        } else if ("32".equals(code)) {
            toAppendTo.append("退院");
            // 41-開始
        } else if ("41".equals(code)) {
            toAppendTo.append("開始");
            // 42-終了
        } else if ("42".equals(code)) {
            toAppendTo.append("終了");
        }

        return toAppendTo;
    }

    public Object parseObject(String source, ParsePosition pos) {

        if (source == null)
            return null;

        String result = null;

        // 異動事由(編集済)の区分の判定を行う。
        // 11-開始
        if ("開始".equals(source)) {
            result = "11";
            // 12-中止
        } else if ("中止".equals(source)) {
            result = "12";
            // 21-入所
        } else if ("入所".equals(source)) {
            result = "21";
            // 22-退所
        } else if ("退所".equals(source)) {
            result = "22";
            // 31-入院
        } else if ("入院".equals(source)) {
            result = "31";
            // 32-退院
        } else if ("退院".equals(source)) {
            result = "32";
            // 41-開始
        } else if ("開始".equals(source)) {
            result = "41";
            // 42-終了
        } else if ("終了".equals(source)) {
            result = "42";
        }

        return result;
    }

}
