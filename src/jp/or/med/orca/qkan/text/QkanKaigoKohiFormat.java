package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

/**
 * �����ށiKOHI_TYPE�j��n���ꂽ�ꍇ�A���̂ɕϊ�����t�H�[�}�b�g�ł��B<br>
 * ����E���Ə��(QU003)�Ŏg�p���܂��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Kazuyoshi Kamitsukasa
 * @version 1.0 2006/01/27
 * @see Format
 */
public class QkanKaigoKohiFormat extends Format{
    private static QkanKaigoKohiFormat singleton;

    /**
     * �R���X�g���N�^�ł��B
     * 
     * @deprecated #getInstance���g�p���Ă��������B
     */
    public QkanKaigoKohiFormat() {
        super();
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     * 
     * @return �C���X�^���X
     */
    public static QkanKaigoKohiFormat getInstance() {
        if (singleton == null) {
            singleton = new QkanKaigoKohiFormat();
        }
        return singleton;
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {

        if (obj == null)
            return new StringBuffer();

        String code = String.valueOf(obj);
        
        // �����ށiKOHI_TYPE�j�̔�����s���B
        // 1001-���j(���)
        if ("1001".equals(code)) {
            toAppendTo.append("���j(���)");
            // 1101-���j(�]��)
        } else if ("1101".equals(code)) {
            toAppendTo.append("���j(�]��)");
            // 1102-���j(����)
        } else if ("1102".equals(code)) {
            toAppendTo.append("���j(����)");
            // 2101-���_
        } else if ("2101".equals(code)) {
            toAppendTo.append("���_");
            // 1501-�g���(�X��)
        } else if ("1501".equals(code)) {
            toAppendTo.append("�g���(�X��)");
            // 1901-����
        } else if ("1901".equals(code)) {
            toAppendTo.append("����");
            // 8601-�픚�̌�
        } else if ("8601".equals(code)) {
            toAppendTo.append("�픚�̌�");
            // 5101-���莾��
        } else if ("5101".equals(code)) {
            toAppendTo.append("���莾��");
            // 5102-���t
        } else if ("5102".equals(code)) {
            toAppendTo.append("���t");
            // 8801-�����a
        } else if ("8801".equals(code)) {
            toAppendTo.append("�����a");
            // 8701-�q�f
        } else if ("8701".equals(code)) {
            toAppendTo.append("�q�f");
            // 5701-����(�g���)
        } else if ("5701".equals(code)) {
            toAppendTo.append("����(�g���)");
            // 8101-�n������(�K��)
        } else if ("8101".equals(code)) {
            toAppendTo.append("�n������(�K��)");
            // 8102-�n������(���)
        } else if ("8102".equals(code)) {
            toAppendTo.append("�n������(���)");
            // 1201-����
        } else if ("1201".equals(code)) {
            toAppendTo.append("����");
            // 7701-�Е�����1/2
        } else if ("7701".equals(code)) {
            toAppendTo.append("�Е�����1/2");
            // 7702-�Е�����1/4
        } else if ("7702".equals(code)) {
            toAppendTo.append("�Е�����1/4");
        }

        return toAppendTo;
    }

    public Object parseObject(String source, ParsePosition pos) {

        if (source == null)
            return null;

        String result = null;

        // �����ށiKOHI_TYPE�j�̔�����s���B
        // 1001-���j(���)
        if ("���j(���)".equals(source)) {
            result = "1001";
            // 1101-���j(�]��)
        } else if ("���j(�]��)".equals(source)) {
            result = "1101";
    		// 1102-���j(����)
        } else if ("���j(����)".equals(source)) {
            result = "1102";
    		// 2101-���_
        } else if ("���_".equals(source)) {
            result = "2101";
    		// 1501-�g���(�X��)
        } else if ("�g���(�X��)".equals(source)) {
            result = "1501";
    		// 1901-����
        } else if ("����".equals(source)) {
            result = "1901";
    		// 8601-�픚�̌�
        } else if ("�픚�̌�".equals(source)) {
            result = "8601";
    		// 5101-���莾��
        } else if ("���莾��".equals(source)) {
            result = "5101";
    		// 5102-���t
        } else if ("���t".equals(source)) {
            result = "5102";
    		// 8801-�����a
        } else if ("�����a".equals(source)) {
            result = "8801";
    		// 8701-�q�f
        } else if ("�q�f".equals(source)) {
            result = "8701";
    		// 5701-����(�g���)
        } else if ("����(�g���)".equals(source)) {
            result = "5701";
    		// 8101-�n������(�K��)
        } else if ("�n������(�K��)".equals(source)) {
            result = "8101";
    		// 8102-�n������(���)
        } else if ("�n������(���)".equals(source)) {
            result = "8102";
    		// 1201-����
        } else if ("����".equals(source)) {
            result = "1201";
    		// 7701-�Е�����1/2
        } else if ("�Е�����1/2".equals(source)) {
            result = "7701";
    		// 7702-�Е�����1/4
        } else if ("�Е�����1/4".equals(source)) {
            result = "7702";
        }

        return result;
    }

}
