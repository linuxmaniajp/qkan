package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

/**
 * 事業所種別用のフォーマットです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/31
 */
public class QkanProviderJigyoTypeFormat extends Format {
    private static QkanProviderJigyoTypeFormat singleton;
    private static final int CONTENT_ID = 152;
    private QkanCodeMasterFormat qcmf = new QkanCodeMasterFormat();

    /**
     * コンストラクタです。
     */
    protected QkanProviderJigyoTypeFormat() {
        super();
        qcmf.setContentID(CONTENT_ID);
    }

    /**
     * インスタンスを返します。
     * 
     * @return インスタンス
     */
    public static QkanProviderJigyoTypeFormat getInstance() {
        if (singleton == null) {
            singleton = new QkanProviderJigyoTypeFormat();
        }
        return singleton;
    }

    public Object parseObject(String source, ParsePosition pos) {
        return qcmf.parseObject(source, pos);
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {
        return qcmf.format(obj, toAppendTo, pos);
    }

}
