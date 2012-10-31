package jp.nichicom.ac.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

/**
 * カンマを含まない単純な整数化フォーマットです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/31
 */
public class ACSimpleIntegerFormat extends Format {

    /**
     * コンストラクタです。
     */
    public ACSimpleIntegerFormat() {
        super();
    }

    public Object parseObject(String source, ParsePosition pos) {
        if ((source == null) || "".equals(source)) {
            return null;
        }
        Integer val = Integer.valueOf(source);
        pos.setIndex(source.length());
        return val;
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {
        Integer val = null;
        if (obj instanceof Integer) {
            val = (Integer) obj;
        } else if (obj instanceof Long) {
            val = new Integer(((Long) obj).intValue());
        } else if ((obj != null) && (!"".equals(obj))) {
            val = Integer.valueOf(String.valueOf(obj));
        }
        if (val != null) {
            toAppendTo.append(String.valueOf(val));
        }

        return toAppendTo;
    }

}
