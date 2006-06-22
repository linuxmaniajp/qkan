package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
/**
 * �ی��ҋ敪�p�t�H�[�}�b�g�ł��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Tozo Tanaka
 * @version 1.0 2006/03/30
 */
public class QkanInsurerTypeFormat extends Format {

    /**
     * �R���X�g���N�^�ł��B
     */
    protected QkanInsurerTypeFormat() {
        super();
    }
    private static QkanInsurerTypeFormat singleton;
    /**
     * �C���X�^���X��Ԃ��܂��B
     * 
     * @return �C���X�^���X
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
            // 1-���
            toAppendTo.append("���");
        } else if ("2".equals(code)) {
            // 2-���
            toAppendTo.append("���");
        }

        return toAppendTo;
    }

    public Object parseObject(String source, ParsePosition pos) {
        int result = 0;

        // 11-��Y��
        if ("���".equals(source)) {
            // 1-���
            result = 1;
        } else if ("���".equals(source)) {
            // 2-���
            result = 2;
        }
        return new Integer(result);
    }

}
