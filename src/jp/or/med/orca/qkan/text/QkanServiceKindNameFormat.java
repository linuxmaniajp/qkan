package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.Iterator;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.util.VRMap;

/**
 * �T�[�r�X��ރR�[�h��n���ꂽ�ꍇ�A�R�[�h���疼�̂ɕϊ�����t�H�[�}�b�g�ł��B<br>
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Kazuyoshi Kamitsukasa
 * @version 1.0 2006/01/20
 * @see Format
 */
public class QkanServiceKindNameFormat extends Format {
    private static QkanServiceKindNameFormat singleton;
    private VRMap masterService;

    /**
     * �T�[�r�X�}�X�^ ��Ԃ��܂��B
     * 
     * @return �T�[�r�X�}�X�^
     */
    public VRMap getMasterService() {
        return masterService;
    }

    /**
     * �T�[�r�X�}�X�^ ��ݒ肵�܂��B
     * 
     * @param serviceMaster �T�[�r�X�}�X�^
     */
    public void setMasterService(VRMap serviceMaster) {
        this.masterService = serviceMaster;
    }

    /**
     * �R���X�g���N�^�ł��B
     */
    protected QkanServiceKindNameFormat() {
        super();
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     * 
     * @return �C���X�^���X
     */
    public static QkanServiceKindNameFormat getInstance() {
        if (singleton == null) {
            singleton = new QkanServiceKindNameFormat();
        }
        return singleton;
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {

        if (obj != null) {
            if (getMasterService() != null) {
                int val = ACCastUtilities.toInt(obj, 0) - 1000;
                if (val > 0) {
                    Iterator it = getMasterService().values().iterator();
                    while (it.hasNext()) {
                        Map row = (Map) it.next();
                        if (ACCastUtilities.toInt(row.get("SERVICE_CODE_KIND"),
                                0) == val) {
                            // �T�[�r�X�̗��̖��ɒu��
                            obj = row.get("SERVICE_KIND_NAME");
                            if (obj != null) {
                                toAppendTo.append(obj);
                                break;
                            }
                        }
                    }

                }
            }
        }
        return toAppendTo;
    }

    public Object parseObject(String source, ParsePosition pos) {

        if (source == null)
            return null;

        String result = null;

        return result;
    }

}
