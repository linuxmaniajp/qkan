package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

import jp.nichicom.ac.lang.ACCastUtilities;

/**
 * 訪問看護療養費領収書で使用する保険(公費)短縮制度名フォーマットです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/08/28
 */
public class QkanMedicalInsureTypeFormat extends Format {
    private static QkanMedicalInsureTypeFormat singleton;
    private static final int CONTENT_ID = 270;
    private QkanCodeMasterFormat qcmf = new QkanCodeMasterFormat();

    /**
     * コンストラクタです。
     */
    protected QkanMedicalInsureTypeFormat() {
        super();
        qcmf.setContentID(CONTENT_ID);
    }

    /**
     * インスタンスを返します。
     * 
     * @return インスタンス
     */
    public static QkanMedicalInsureTypeFormat getInstance() {
        if (singleton == null) {
            singleton = new QkanMedicalInsureTypeFormat();
        }
        return singleton;
    }

    public Object parseObject(String source, ParsePosition pos) {
        return qcmf.parseObject(source, pos);
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {
        //replace-begin 2006-10-25 Tozo TANAKA
        // return qcmf.format(obj, toAppendTo, pos);
        String valText = String.valueOf(obj);
        Integer val = new Integer(0);
        if (valText.length() >= 2) {
            //負担者番号の先頭2桁
            val = ACCastUtilities.toInteger(valText.substring(0, 2), 0);
            if ((val.intValue() == 51) && (valText.length() >= 7)) {
                // 負担者番号の先頭2桁が51(特定疾患)で、4～7桁目が601ならば「特定負無」と変換する。
                if ("601".equals(valText.substring(4, 7))) {
                    toAppendTo.append("特定負無");
                    return toAppendTo;
                }
            }
        }
        return qcmf.format(val, toAppendTo, pos);
        //replace-end 2006-10-25 Tozo TANAKA

    }

}
