package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
/**
 * 本人/家族区分用のフォーマットです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Tozo Tanaka
 * @version 1.0 2006/08/22
 */
public class QkanMedicalSelfFlagFormat extends Format {
    private static QkanMedicalSelfFlagFormat singleton;
    private static final int CONTENT_ID = 14;
    private QkanCodeMasterFormat qcmf = new QkanCodeMasterFormat();

    /**
     * コンストラクタです。
     */
    protected QkanMedicalSelfFlagFormat() {
        super();
        qcmf.setContentID(CONTENT_ID);
    }

    /**
     * インスタンスを返します。
     * 
     * @return インスタンス
     */
    public static QkanMedicalSelfFlagFormat getInstance() {
        if (singleton == null) {
            singleton = new QkanMedicalSelfFlagFormat();
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
