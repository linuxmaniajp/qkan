package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

/**
 * �V�X�e���T�[�r�X��ރR�[�h��n���ꂽ�ꍇ�A�R�[�h���疼�̂ɕϊ�����t�H�[�}�b�g�ł��B<br>
 * ���p�ғo�^(QU002)�Ŏg�p���܂��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Kazuyoshi Kamitsukasa
 * @version 1.0 2006/01/20
 * @see Format
 */
public class QkanServiceFormat extends Format{
    private static QkanServiceFormat singleton;

    /**
     * �R���X�g���N�^�ł��B
     * 
     * @deprecated #getInstance���g�p���Ă��������B
     */
    public QkanServiceFormat() {
        super();
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     * 
     * @return �C���X�^���X
     */
    public static QkanServiceFormat getInstance() {
        if (singleton == null) {
            singleton = new QkanServiceFormat();
        }
        return singleton;
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {

        if (obj == null)
            return new StringBuffer();

        String code = String.valueOf(obj);

        // �V�X�e���T�[�r�X��ރR�[�h�̔�����s���B
        if ("11101".equals(code)||"11111".equals(code)) {
            // 11101-�K����
            toAppendTo.append("�K����");
        } else if ("11201".equals(code)||"11211".equals(code)) {
            // 11201-�K��������
            toAppendTo.append("�K��������");
        } else if ("11301".equals(code)||"11311".equals(code)) {
            // 11301-�K��Ō�(���ی�)
            toAppendTo.append("�K��Ō�(���ی�)");
        } else if ("20101".equals(code)||"20111".equals(code)) {
            // 20101-�K��Ō�(��Õی�)
            toAppendTo.append("�K��Ō�(��Õی�)");
        } else if ("11401".equals(code)||"11411".equals(code)) {
            // 11401-�K�⃊�n
            toAppendTo.append("�K�⃊�n");
        } else if ("11501".equals(code)||"11511".equals(code)) {
            // 11501-�ʏ����
            toAppendTo.append("�ʏ����");
        } else if ("11601".equals(code)||"11611".equals(code)) {
            // 11601-�ʏ����n
            toAppendTo.append("�ʏ����n");
        } else if ("11701".equals(code)||"11711".equals(code)) {
            // 11701-�����p��ݗ^
            toAppendTo.append("�����p��ݗ^");
        } else if ("12101".equals(code)||"12111".equals(code)) {
            // 12101-�Z�������������
            toAppendTo.append("�Z�������������");
        } else if ("12201".equals(code)||"12211".equals(code)) {
            // 12201-�Z�������×{���(�V���{��)
            toAppendTo.append("�Z�������×{���(�V���{��)");
        } else if ("12301".equals(code)||"12311".equals(code)) {
            // 12301-�Z�������×{���(�a�@�×{�^)
            toAppendTo.append("�Z�������×{���(�a�@�×{�^)");
        } else if ("12302".equals(code)||"12312".equals(code)) {
            // 12302-�Z�������×{���(�f�Ï��×{�^)
            toAppendTo.append("�Z�������×{���(�f�Ï��×{�^)");
        } else if ("12303".equals(code)||"12313".equals(code)) {
            // 12303-�Z�������×{���(�F�m�ǎ����^)
            toAppendTo.append("�Z�������×{���(�F�m�ǎ����^)");
        } else if ("12304".equals(code)||"12314".equals(code)) {
            // 12304-�Z�������×{���(��K���f�Ï��^)
            toAppendTo.append("�Z�������×{���(��K���f�Ï��^)");
        } else if ("13101".equals(code)||"13111".equals(code)) {
            // 13101-����×{�Ǘ��w��
            toAppendTo.append("����×{�Ǘ��w��");
        } else if ("13201".equals(code)||"13211".equals(code)) {
            // 13201-�F�m�ǑΉ��^�����������
            toAppendTo.append("�F�m�ǑΉ��^�����������");
        } else if ("13301".equals(code)||"13311".equals(code)) {
            // 13301-����{�ݓ����Ґ������
            toAppendTo.append("����{�ݓ����Ґ������");
        } else if ("13611".equals(code)) {
            // 13611-�n�斧���^����{�ݓ����Ґ������
            toAppendTo.append("�n�斧���^����{�ݓ����Ґ������");
        } else if ("13811".equals(code)) {
            // 13811-�F�m�ǑΉ��^�����������(�Z�����p)
            toAppendTo.append("�F�m�ǑΉ��^�����������(�Z�����p)");
        } else if ("14301".equals(code)||"14311".equals(code)) {
            // 14301-������x��
            toAppendTo.append("������x��");
        } else if ("15101".equals(code)||"15111".equals(code)) {
            // 15101-���V�l�����{��
            toAppendTo.append("���V�l�����{��");
        } else if ("15201".equals(code)||"15211".equals(code)) {
            // 15201-���V�l�ی��{��
            toAppendTo.append("���V�l�ی��{��");
        } else if ("15301".equals(code)||"15311".equals(code)) {
            // 15301-���×{�^��Î{��(�×{�^�a�@)
            toAppendTo.append("���×{�^��Î{��(�×{�^�a�@)");
        } else if ("15302".equals(code)||"15312".equals(code)) {
            // 15302-���×{�^��Î{��(�f�Ï��^)
            toAppendTo.append("���×{�^��Î{��(�f�Ï��^)");
        } else if ("15303".equals(code)||"15313".equals(code)) {
            // 15303-���×{�^��Î{��(�F�m�ǎ����^)
            toAppendTo.append("���×{�^��Î{��(�F�m�ǎ����^)");
        } else if ("15411".equals(code)) {
            // 15411-�n�斧���^��앟���{��
            toAppendTo.append("�n�斧���^��앟���{��");
        } else if ("17111".equals(code)) {
            // 17111-��ԑΉ��^�K����
            toAppendTo.append("��ԑΉ��^�K����");
        } else if ("17211".equals(code)) {
            // 17211-�F�m�ǑΉ��^�ʏ����
            toAppendTo.append("�F�m�ǑΉ��^�ʏ����");
        } else if ("17311".equals(code)) {
            // 17311-���K�͑��@�\�^������
            toAppendTo.append("���K�͑��@�\�^������");        
        } else if ("90101".equals(code)) {
            // 90101-���̑�
            toAppendTo.append("���̑�");
        } else if ("90201".equals(code)) {
            // 90201-��ȓ��퐶����̊���
            toAppendTo.append("��ȓ��퐶����̊���");
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
