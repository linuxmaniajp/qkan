package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

/**
 * �T�P�ʈȊO�̃T�[�r�X�ɂ�����J�n���̃t�H�[�}�b�g�ł��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/31
 */
public class QkanNonWeeklyServiceBeginFormat extends Format {
    private static QkanNonWeeklyServiceBeginFormat singleton;
    private static final int CONTENT_ID = 24;
    private QkanCodeMasterFormat qcmf = new QkanCodeMasterFormat();

    /**
     * �R���X�g���N�^�ł��B
     */
    protected QkanNonWeeklyServiceBeginFormat() {
        super();
        qcmf. setContentID(CONTENT_ID);
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     * 
     * @return �C���X�^���X
     */
    public static QkanNonWeeklyServiceBeginFormat getInstance() {
        if (singleton == null) {
            singleton = new QkanNonWeeklyServiceBeginFormat();
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
