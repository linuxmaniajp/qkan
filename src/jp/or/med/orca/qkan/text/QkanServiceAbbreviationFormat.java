package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.util.VRMap;

/**
 * �V�X�e���T�[�r�X��ރR�[�h��n���ꂽ�ꍇ�A�R�[�h���疼�̂ɕϊ�����t�H�[�}�b�g�ł��B<br>
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Kazuyoshi Kamitsukasa
 * @version 1.0 2006/01/20
 * @see Format
 */
public class QkanServiceAbbreviationFormat extends Format{
    private static QkanServiceAbbreviationFormat singleton;
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
    protected QkanServiceAbbreviationFormat() {
        super();
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     * 
     * @return �C���X�^���X
     */
    public static QkanServiceAbbreviationFormat getInstance() {
        if (singleton == null) {
            singleton = new QkanServiceAbbreviationFormat();
        }
        return singleton;
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {

        if (obj != null){
            if (getMasterService() != null) {
                Object service = getMasterService().get(
                        ACCastUtilities.toInteger(obj, 0));
                if (service instanceof Map) {
                    // �T�[�r�X�̗��̖��ɒu��
                    obj = ((Map) service).get("SERVICE_ABBREVIATION");
                    if (obj != null) {
                        toAppendTo.append(obj);
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

        // �V�X�e���T�[�r�X��ރR�[�h�̔�����s���B
        // 11101-�K����
        if ("�K����".equals(source)) {
            result = "11101";
            // 11201-�K��������
        } else if ("�K��������".equals(source)) {
            result = "11201";
            // 11301-�K��Ō�(���ی�)
        } else if ("�K��Ō�(���ی�)".equals(source) || "�K��Ō�i���ی��j".equals(source)) {
            result = "11301";
            // 20101-�K��Ō�(��Õی�)
        } else if ("�K��Ō�(��Õی�)".equals(source) || "�K��Ō�i��Õی��j".equals(source)) {
            result = "20101";
            // 11401-�K�⃊�n
        } else if ("�K�⃊�n".equals(source)) {
            result = "11401";
            // 11501-�ʏ����
        } else if ("�ʏ����".equals(source)) {
            result = "11501";
            // 11601-�ʏ����n
        } else if ("�ʏ����n".equals(source)) {
            result = "11601";
            // 11701-�����p��ݗ^
        } else if ("�����p��ݗ^".equals(source)) {
            result = "11701";
            // 12101-�Z�������������
        } else if ("�Z�������������".equals(source)) {
            result = "12101";
            // 12201-�Z�������×{���(�V���{��)
        } else if ("�Z�������×{���(�V���{��)".equals(source) || "�Z�������×{���i�V���{�݁j".equals(source)) {
            result = "12201";
            // 12301-�Z�������×{���(�a�@�×{�^)
        } else if ("�Z�������×{���(�a�@�×{�^)".equals(source) || "�Z�������×{���i�a�@�×{�^�j".equals(source)) {
            result = "12301";
            // 12302-�Z�������×{���(�f�Ï��×{�^)
        } else if ("�Z�������×{���(�f�Ï��×{�^)".equals(source) || "�Z�������×{���i�f�Ï��×{�^�j".equals(source)) {
            result = "12302";
            // 12303-�Z�������×{���(�F�m�ǎ����^)
        } else if ("�Z�������×{���(�F�m�ǎ����^)".equals(source) || "�Z�������×{���i�F�m�ǎ����^�j".equals(source)) {
            result = "12303";
            // 12304-�Z�������×{���(��K���f�Ï��^)
        } else if ("�Z�������×{���(��K���f�Ï��^)".equals(source) || "�Z�������×{���i��K���f�Ï��^�j".equals(source)) {
            result = "12304";
            // 13101-����×{�Ǘ��w��
        } else if ("����×{�Ǘ��w��".equals(source)) {
            result = "13101";
            // 13201-�F�m�ǑΉ��^�����������
        } else if ("�F�m�ǑΉ��^�����������".equals(source)) {
            result = "13201";
            // 13301-����{�ݓ����Ґ������
        } else if ("����{�ݓ����Ґ������".equals(source)) {
            result = "13301";
            // 14301-������x��
        } else if ("������x��".equals(source)) {
            result = "14301";
            // 15101-���V�l�����{��
        } else if ("���V�l�����{��".equals(source)) {
            result = "15101";
            // 15201-���V�l�ی��{��
        } else if ("���V�l�ی��{��".equals(source)) {
            result = "15201";
            // 15301-���×{�^��Î{��(�×{�^�a�@)
        } else if ("���×{�^��Î{��(�×{�^�a�@)".equals(source) || "���×{�^��Î{�݁i�×{�^�a�@�j".equals(source)) {
            result = "15301";
            // 15302-���×{�^��Î{��(�f�Ï��^)
        } else if ("���×{�^��Î{��(�f�Ï��^)".equals(source) || "���×{�^��Î{�݁i�f�Ï��^�j".equals(source)) {
            result = "15302";
            // 15303-���×{�^��Î{��(�F�m�ǎ����^)
        } else if ("���×{�^��Î{��(�F�m�ǎ����^)".equals(source) || "���×{�^��Î{�݁i�F�m�ǎ����^�j".equals(source)) {
            result = "15303";
            // 90101-���̑�
        } else if ("���̑�".equals(source)) {
            result = "90101";
            // 90201-��ȓ��퐶����̊���
        } else if ("��ȓ��퐶����̊���".equals(source)) {
            result = "90201";
        }

        return result;
    }

}
