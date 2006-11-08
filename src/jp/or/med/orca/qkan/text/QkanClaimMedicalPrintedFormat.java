package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

/**
 * �K��Ō�×{��׏��̈���ς݂ł��邩�̃t���O��\������t�H�[�}�b�g�ł��B
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
     * �C���X�^���X��Ԃ��܂��B
     * 
     * @return �C���X�^���X
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
            // 1-��
            toAppendTo.append("��");
        }

        return toAppendTo;
    }

    public Object parseObject(String source, ParsePosition pos) {
        int result = 0;

        if ("��".equals(source)) {
            // 1-��
            result = 1;
        }
        return new Integer(result);
    }

}
