package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
/**
 * 保険者区分用フォーマットです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Tozo Tanaka
 * @version 1.0 2006/03/30
 */
public class QkanInsurerTypeFormat extends Format {

    /**
     * コンストラクタです。
     */
    protected QkanInsurerTypeFormat() {
        super();
    }
    private static QkanInsurerTypeFormat singleton;
    /**
     * インスタンスを返します。
     * 
     * @return インスタンス
     */
    public static QkanInsurerTypeFormat getInstance() {
        if (singleton == null) {
            singleton = new QkanInsurerTypeFormat();
        }
        return singleton;
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {

        String code = String.valueOf(obj);
        if ("1".equals(code)) {
            // 1-介護
            toAppendTo.append("介護");
        } else if ("2".equals(code)) {
            // 2-医療
            toAppendTo.append("医療");
        }

        return toAppendTo;
    }

    public Object parseObject(String source, ParsePosition pos) {
        int result = 0;

        // 11-非該当
        if ("介護".equals(source)) {
            // 1-介護
            result = 1;
        } else if ("医療".equals(source)) {
            // 2-医療
            result = 2;
        }
        return new Integer(result);
    }

}
