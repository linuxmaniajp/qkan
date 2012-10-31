package jp.nichicom.ac.text;

import java.text.FieldPosition;
import java.util.Calendar;
import java.util.Date;

/**
 * 0001/01/01と9999/12/31を空文字として変換する日付フォーマットです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/02
 */
public class ACBorderBlankDateFormat extends ACDateFormat {
    /**
     * コンストラクタです。
     */
    public ACBorderBlankDateFormat() {
        super();
    }

    /**
     * コンストラクタです。
     * 
     * @param format 出力書式
     */
    public ACBorderBlankDateFormat(String format) {
        super(format);
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {
        Date date = null;
        if (obj instanceof Calendar) {
            date = ((Calendar) obj).getTime();
        } else if (obj instanceof Date) {
            date = (Date) obj;
        } else if (obj instanceof Number) {
            date = new Date(((Number) obj).longValue());
        }
        if (date != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int y = cal.get(Calendar.YEAR);
            if (y > 9999) {
                // 9999年over
                return toAppendTo;
            } else if (y == 9999) {
                // 9999年
                int m = cal.get(Calendar.MONTH);
                if (m > 11) {
                    // 11月over
                    return toAppendTo;
                } else if (m == 11) {
                    // 11月
                    int d = cal.get(Calendar.DAY_OF_MONTH);
                    if (d >= 31) {
                        // 31日over
                        return toAppendTo;
                    }
                }
            } else if (y < 1) {
                // 1年未満
                return toAppendTo;
            } else if (y == 1) {
                // 1年
                int m = cal.get(Calendar.MONTH);
                if (m < 0) {
                    // 1月未満
                    return toAppendTo;
                } else if (m == 0) {
                    // 1月
                    int d = cal.get(Calendar.DAY_OF_MONTH);
                    if (d <= 1) {
                        // 1日以下
                        return toAppendTo;
                    }
                }
            }

        }
        return super.format(obj, toAppendTo, pos);
    }

}
