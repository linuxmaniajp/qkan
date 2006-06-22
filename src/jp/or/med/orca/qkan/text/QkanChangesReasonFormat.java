package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

/**
 * �ٓ����R(�ҏW��)��n���ꂽ�ꍇ�A�敪���疼�̂ɕϊ�����t�H�[�}�b�g�ł��B<br>
 * ���p�ғo�^(QU002)�Ŏg�p���܂��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Kazuyoshi Kamitsukasa
 * @version 1.0 2006/01/20
 * @see Format
 */
public class QkanChangesReasonFormat extends Format{
    private static QkanChangesReasonFormat singleton;

    /**
     * �R���X�g���N�^�ł��B
     * 
     * @deprecated #getInstance���g�p���Ă��������B
     */
    public QkanChangesReasonFormat() {
        super();
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     * 
     * @return �C���X�^���X
     */
    public static QkanChangesReasonFormat getInstance() {
        if (singleton == null) {
            singleton = new QkanChangesReasonFormat();
        }
        return singleton;
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {

        if (obj == null)
            return new StringBuffer();

        String code = String.valueOf(obj);

        // �ٓ����R�̋敪�̔�����s���B
        // 11-��Y��
        if ("11".equals(code)) {
            toAppendTo.append("��Y��");
            // 12-���{��
        } else if ("12".equals(code)) {
            toAppendTo.append("���{��");
            // 13-��Ë@�֓��@
        } else if ("13".equals(code)) {
            toAppendTo.append("��Ë@�֓��@");
            // 14-���S
        } else if ("14".equals(code)) {
            toAppendTo.append("���S");
            // 15-���̑�
        } else if ("15".equals(code)) {
            toAppendTo.append("���̑�");
            // 21-����
        } else if ("21".equals(code)) {
            toAppendTo.append("����");
            // 22-���{��
        } else if ("22".equals(code)) {
            toAppendTo.append("���{��");
            // 23-��Ë@�֓��@
        } else if ("23".equals(code)) {
            toAppendTo.append("��Ë@�֓��@");
            // 24-���S
        } else if ("24".equals(code)) {
            toAppendTo.append("���S");
            // 25-���̑�
        } else if ("25".equals(code)) {
            toAppendTo.append("���̑�");
            // 31-����
        } else if ("31".equals(code)) {
            toAppendTo.append("����");
            // 32-���{��
        } else if ("32".equals(code)) {
            toAppendTo.append("���{��");
            // 33-��Ë@�֓��@
        } else if ("33".equals(code)) {
            toAppendTo.append("��Ë@�֓��@");
            // 34-���S
        } else if ("34".equals(code)) {
            toAppendTo.append("���S");
            // 35-���̑�
        } else if ("35".equals(code)) {
            toAppendTo.append("���̑�");
            // 41-�y��
        } else if ("41".equals(code)) {
            toAppendTo.append("�y��");
            // 42-�{��
        } else if ("42".equals(code)) {
            toAppendTo.append("�{��");
            // 43-��Ë@��
        } else if ("43".equals(code)) {
            toAppendTo.append("��Ë@��");
            // 44-���S
        } else if ("44".equals(code)) {
            toAppendTo.append("���S");
            // 45-���̑�
        } else if ("45".equals(code)) {
            toAppendTo.append("���̑�");
        }

        return toAppendTo;
    }

    public Object parseObject(String source, ParsePosition pos) {

        if (source == null)
            return null;

        String result = null;

        // �ٓ����R�̋敪�̔�����s���B
        // 11-��Y��
        if ("��Y��".equals(source)) {
            result = "11";
            // 12-���{��
        } else if ("���{��".equals(source)) {
            result = "12";
            // 13-��Ë@�֓��@
        } else if ("��Ë@�֓��@".equals(source)) {
            result = "13";
            // 14-���S
        } else if ("���S".equals(source)) {
            result = "14";
            // 15-���̑�
        } else if ("���̑�".equals(source)) {
            result = "15";
            // 21-����
        } else if ("����".equals(source)) {
            result = "21";
            // 22-���{��
        } else if ("���{��".equals(source)) {
            result = "22";
            // 23-��Ë@�֓��@
        } else if ("��Ë@�֓��@".equals(source)) {
            result = "23";
            // 24-���S
        } else if ("���S".equals(source)) {
            result = "24";
            // 25-���̑�
        } else if ("���̑�".equals(source)) {
            result = "25";
            // 31-����
        } else if ("����".equals(source)) {
            result = "31";
            // 32-���{��
        } else if ("���{��".equals(source)) {
            result = "32";
            // 33-��Ë@�֓��@
        } else if ("��Ë@�֓��@".equals(source)) {
            result = "33";
            // 34-���S
        } else if ("���S".equals(source)) {
            result = "34";
            // 35-���̑�
        } else if ("���̑�".equals(source)) {
            result = "35";
            // 41-�y��
        } else if ("�y��".equals(source)) {
            result = "41";
            // 42-�{��
        } else if ("�{��".equals(source)) {
            result = "42";
            // 43-��Ë@��
        } else if ("��Ë@��".equals(source)) {
            result = "43";
            // 44-���S
        } else if ("���S".equals(source)) {
            result = "44";
            // 45-���̑�
        } else if ("���̑�".equals(source)) {
            result = "45";
        }

        return result;
    }

}
