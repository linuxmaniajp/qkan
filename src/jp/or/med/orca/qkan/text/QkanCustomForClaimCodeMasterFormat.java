package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;

/**
 * �R�[�h�}�X�^���g�p����t�H�[�}�b�g�ł��B
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
     * �R���X�g���N�^�ł��B
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
                // �n���ꂽ��������u/�v�ŕ���
                String[] temp;
                temp = (ACCastUtilities.toString(obj)).split("/");
                // ��������������̂����A�O�̕�������擾
                String source = ACTextUtilities.trim(temp[0]);
                return qcmf.format(source, toAppendTo, pos);
            } catch (Exception e) {
            }
        }
        return toAppendTo;
    }

}
