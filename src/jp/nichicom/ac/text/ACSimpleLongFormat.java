package jp.nichicom.ac.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

/**
 * カンマを含まない単純な長整数化フォーマットです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/31
 */
public class ACSimpleLongFormat extends Format {

    /**
     * コンストラクタです。
     */
    public ACSimpleLongFormat() {
        super();
    }

    public Object parseObject(String source, ParsePosition pos) {
        Long val = Long.valueOf(source);
        pos.setIndex(source.length());
        return val;
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {
        Long val;
        if (obj instanceof Long) {
            val = (Long) obj;
        } else if (obj instanceof Integer) {
            val = new Long(((Integer) obj).longValue());
        } else {
            val = Long.valueOf(String.valueOf(obj));
        }
        if (val != null) {
            toAppendTo.append(val.toString());
        }

        return toAppendTo;
    }

}
