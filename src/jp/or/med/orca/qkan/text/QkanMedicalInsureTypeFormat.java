package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

import jp.nichicom.ac.lang.ACCastUtilities;

/**
 * �K��Ō�×{��̎����Ŏg�p����ی�(����)�Z�k���x���t�H�[�}�b�g�ł��B
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
     * �R���X�g���N�^�ł��B
     */
    protected QkanMedicalInsureTypeFormat() {
        super();
        qcmf.setContentID(CONTENT_ID);
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     * 
     * @return �C���X�^���X
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
            //���S�Ҕԍ��̐擪2��
            val = ACCastUtilities.toInteger(valText.substring(0, 2), 0);
            if ((val.intValue() == 51) && (valText.length() >= 7)) {
                // ���S�Ҕԍ��̐擪2����51(���莾��)�ŁA4�`7���ڂ�601�Ȃ�΁u���蕉���v�ƕϊ�����B
                if ("601".equals(valText.substring(4, 7))) {
                    toAppendTo.append("���蕉��");
                    return toAppendTo;
                }
            }
        }
        return qcmf.format(val, toAppendTo, pos);
        //replace-end 2006-10-25 Tozo TANAKA

    }

}
