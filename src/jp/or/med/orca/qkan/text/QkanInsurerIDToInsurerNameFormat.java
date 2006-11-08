package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Iterator;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACNullToBlankFormat;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * �ی���ID����ی��Җ��ɕϊ�����t�H�[�}�b�g<br/> QP010�Ŏg�p���܂��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/08/19
 */
public class QkanInsurerIDToInsurerNameFormat extends Format {
    private VRList insurers;

    /**
     * �ی��҈ꗗ ��Ԃ��܂��B
     * 
     * @return �ی��҈ꗗ
     */
    public VRList getInsurers() {
        return insurers;
    }

    /**
     * �ی��҈ꗗ ��ݒ肵�܂��B
     * 
     * @param insurers �ی��҈ꗗ
     */
    public void setInsurers(VRList insurers) {
        this.insurers = insurers;
    }

    /**
     * �R���X�g���N�^�ł��B
     */
    public QkanInsurerIDToInsurerNameFormat() {
        super();
    }

    /**
     * �R���X�g���N�^�ł��B
     * 
     * @param insurers �ی��҈ꗗ
     */
    public QkanInsurerIDToInsurerNameFormat(VRList insurers) {
        super();
        setInsurers(insurers);
    }

    public Object parseObject(String source, ParsePosition pos) {
        // �ی��Җ�����ی��Ҕԍ���
        if (getInsurers() != null) {
            try {
                VRMap row = ACBindUtilities.getMatchRowFromValue(getInsurers(),
                        "INSURER_NAME", source);
                if (row != null) {
                    return ACNullToBlankFormat.getInstance().format(
                            VRBindPathParser.get("INSURER_ID", row));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {
        // �ی��Ҕԍ�����ی��Җ���
        if (getInsurers() != null) {
            try {
                String val = ACCastUtilities.toString(obj, "");
                if (!"".equals(val)) {
                    Iterator it = getInsurers().iterator();
                    while (it.hasNext()) {
                        VRMap row = (VRMap) it.next();
                        String id = ACCastUtilities.toString(VRBindPathParser
                                .get("INSURER_ID", row), "*");
                        if (val.endsWith(id)) {
                            //��Â̕ی��Ҕԍ����l�����A��������v�����OK
                            toAppendTo.append(ACNullToBlankFormat.getInstance()
                                    .format(
                                            VRBindPathParser.get(
                                                    "INSURER_NAME", row)));
                            break;
                        }
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return toAppendTo;
    }

}
