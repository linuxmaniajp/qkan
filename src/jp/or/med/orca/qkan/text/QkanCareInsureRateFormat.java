package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

/**
 * 保険の給付率コードと給付率の変換を行うフォーマッタです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/31
 */
public class QkanCareInsureRateFormat extends Format {
    private static QkanCareInsureRateFormat singleton;

    /**
     * コンストラクタです。
     */
    protected QkanCareInsureRateFormat() {
        super();
    }

    /**
     * インスタンスを返します。
     * 
     * @return インスタンス
     */
    public static QkanCareInsureRateFormat getInstance() {
        if (singleton == null) {
            singleton = new QkanCareInsureRateFormat();
        }
        return singleton;
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {

        if (obj == null)
            return new StringBuffer();

        String code = String.valueOf(obj);
        if ("49".equals(code)) {
            // 49-介護9割
            toAppendTo.append("90");
        } else if ("47".equals(code)) {
            // 47-介護7割
            toAppendTo.append("70");
        } else if ("12".equals(code)) {
            // 12-生保単独
            toAppendTo.append("100");
        }else{
            //それ以外はそのまま
            toAppendTo.append(code);
        }

        return toAppendTo;
    }

    public Object parseObject(String source, ParsePosition pos) {

        if (source == null) {
            return null;
        }

        String result = null;
        if ("90".equals(source)) {
            // 49-介護9割
            result = "49";
        } else if ("70".equals(source)) {
            // 47-介護7割
            result = "47";
        } else if ("1001".equals(source)) {
            // 12-生保単独
            result = "12";
        }else{
            result = source;
        }
        return result;
    }

}
