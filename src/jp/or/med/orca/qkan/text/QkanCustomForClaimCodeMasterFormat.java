package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;

/**
 * コードマスタを使用するフォーマットです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Kazuyoshi Kamitsukasa
 * @version 1.0 2006/04/05
 * @see Format
 */
public class QkanCustomForClaimCodeMasterFormat extends Format {
    private QkanCodeMasterFormat qcmf = new QkanCodeMasterFormat();

    /**
     * コンストラクタです。
     */
    public QkanCustomForClaimCodeMasterFormat(int contentID) {
        super();
        qcmf.setContentID(contentID);
    }

    public Object parseObject(String source, ParsePosition pos) {
        return qcmf.parseObject(source, pos);
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {
        if (obj != null) {
            try {
                // 渡された文字列を「/」で分割
                String[] temp;
                temp = (ACCastUtilities.toString(obj)).split("/");
                // 分割した文字列のうち、前の文字列を取得
                String source = ACTextUtilities.trim(temp[0]);
                return qcmf.format(source, toAppendTo, pos);
            } catch (Exception e) {
            }
        }
        return toAppendTo;
    }

}
