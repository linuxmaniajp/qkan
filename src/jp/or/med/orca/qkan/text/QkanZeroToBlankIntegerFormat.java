package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACSimpleIntegerFormat;
/**
 * 値が0なら空文字として返す整数フォーマットです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Tozo Tanaka
 * @version 1.0 2006/05/30
 */
public class QkanZeroToBlankIntegerFormat extends ACSimpleIntegerFormat {

    /**
     * コンストラクタです。
     */
    public QkanZeroToBlankIntegerFormat() {
        super();
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {
        if(ACCastUtilities.toInt(obj, 0)==0){
            //数値以外か0なら空文字とする
            return toAppendTo;
        }
        return super.format(obj, toAppendTo, pos);
    }
}
