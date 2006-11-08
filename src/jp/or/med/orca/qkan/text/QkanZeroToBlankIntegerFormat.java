package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACSimpleIntegerFormat;
/**
 * �l��0�Ȃ�󕶎��Ƃ��ĕԂ������t�H�[�}�b�g�ł��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Tozo Tanaka
 * @version 1.0 2006/05/30
 */
public class QkanZeroToBlankIntegerFormat extends ACSimpleIntegerFormat {

    /**
     * �R���X�g���N�^�ł��B
     */
    public QkanZeroToBlankIntegerFormat() {
        super();
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {
        if(ACCastUtilities.toInt(obj, 0)==0){
            //���l�ȊO��0�Ȃ�󕶎��Ƃ���
            return toAppendTo;
        }
        return super.format(obj, toAppendTo, pos);
    }
}
