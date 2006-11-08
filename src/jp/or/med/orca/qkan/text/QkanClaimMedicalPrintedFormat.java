package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

/**
 * 訪問看護療養費明細書の印刷済みであるかのフラグを表示するフォーマットです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/08/21
 */
public class QkanClaimMedicalPrintedFormat extends Format {

    public QkanClaimMedicalPrintedFormat() {
        super();
    }

    private static QkanClaimMedicalPrintedFormat singleton;

    /**
     * インスタンスを返します。
     * 
     * @return インスタンス
     */
    public static QkanClaimMedicalPrintedFormat getInstance() {
        if (singleton == null) {
            singleton = new QkanClaimMedicalPrintedFormat();
        }
        return singleton;
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {

        String code = String.valueOf(obj);
        if ("1".equals(code)) {
            // 1-済
            toAppendTo.append("済");
        }

        return toAppendTo;
    }

    public Object parseObject(String source, ParsePosition pos) {
        int result = 0;

        if ("済".equals(source)) {
            // 1-済
            result = 1;
        }
        return new Integer(result);
    }

}
