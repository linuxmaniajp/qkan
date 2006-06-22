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
public class QkanChangesContentFormat extends Format{
    private static QkanChangesContentFormat singleton;

    /**
     * �R���X�g���N�^�ł��B
     * 
     * @deprecated #getInstance���g�p���Ă��������B
     */
    public QkanChangesContentFormat() {
        super();
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     * 
     * @return �C���X�^���X
     */
    public static QkanChangesContentFormat getInstance() {
        if (singleton == null) {
            singleton = new QkanChangesContentFormat();
        }
        return singleton;
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {

        if (obj == null)
            return new StringBuffer();

        String code = String.valueOf(obj);

        // �ٓ����R(�ҏW��)�̋敪�̔�����s���B
        // 11-�J�n
        if ("11".equals(code)) {
            toAppendTo.append("�J�n");
            // 12-���~
        } else if ("12".equals(code)) {
            toAppendTo.append("���~");
            // 21-����
        } else if ("21".equals(code)) {
            toAppendTo.append("����");
            // 22-�ޏ�
        } else if ("22".equals(code)) {
            toAppendTo.append("�ޏ�");
            // 31-���@
        } else if ("31".equals(code)) {
            toAppendTo.append("���@");
            // 32-�މ@
        } else if ("32".equals(code)) {
            toAppendTo.append("�މ@");
            // 41-�J�n
        } else if ("41".equals(code)) {
            toAppendTo.append("�J�n");
            // 42-�I��
        } else if ("42".equals(code)) {
            toAppendTo.append("�I��");
        }

        return toAppendTo;
    }

    public Object parseObject(String source, ParsePosition pos) {

        if (source == null)
            return null;

        String result = null;

        // �ٓ����R(�ҏW��)�̋敪�̔�����s���B
        // 11-�J�n
        if ("�J�n".equals(source)) {
            result = "11";
            // 12-���~
        } else if ("���~".equals(source)) {
            result = "12";
            // 21-����
        } else if ("����".equals(source)) {
            result = "21";
            // 22-�ޏ�
        } else if ("�ޏ�".equals(source)) {
            result = "22";
            // 31-���@
        } else if ("���@".equals(source)) {
            result = "31";
            // 32-�މ@
        } else if ("�މ@".equals(source)) {
            result = "32";
            // 41-�J�n
        } else if ("�J�n".equals(source)) {
            result = "41";
            // 42-�I��
        } else if ("�I��".equals(source)) {
            result = "42";
        }

        return result;
    }

}
