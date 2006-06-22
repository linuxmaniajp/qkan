package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

/**
 * �T�[�r�X�J�n���p�̃t�H�[�}�b�g�ł��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/31
 */
public class QkanServiceBeginDayFormat extends Format {
    private static QkanServiceBeginDayFormat singleton;
    private static final int CONTENT_ID = 24;
    private QkanCodeMasterFormat qcmf = new QkanCodeMasterFormat();

    /**
     * �R���X�g���N�^�ł��B
     */
    protected QkanServiceBeginDayFormat() {
        super();
        qcmf.setContentID(CONTENT_ID);
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     * 
     * @return �C���X�^���X
     */
    public static QkanServiceBeginDayFormat getInstance() {
        if (singleton == null) {
            singleton = new QkanServiceBeginDayFormat();
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
