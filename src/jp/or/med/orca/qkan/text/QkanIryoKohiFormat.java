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
public class QkanIryoKohiFormat extends Format{
    private static QkanIryoKohiFormat singleton;

    /**
     * �R���X�g���N�^�ł��B
     * 
     * @deprecated #getInstance���g�p���Ă��������B
     */
    public QkanIryoKohiFormat() {
        super();
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     * 
     * @return �C���X�^���X
     */
    public static QkanIryoKohiFormat getInstance() {
        if (singleton == null) {
            singleton = new QkanIryoKohiFormat();
        }
        return singleton;
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {

        if (obj == null)
            return new StringBuffer();

        String code = String.valueOf(obj);
        
        // �����ށiKOHI_TYPE�j�̔�����s���B
        // 1301-�폝�×{
        if ("1301".equals(code)) {
            toAppendTo.append("�폝�×{");
            // 1401-�폝
        } else if ("1401".equals(code)) {
            toAppendTo.append("�폝");
            // 1801-�����F��
        } else if ("1801".equals(code)) {
            toAppendTo.append("�����F��");
            // 1103-��35
        } else if ("1103".equals(code)) {
            toAppendTo.append("��35");
            // 2102-��32
        } else if ("2102".equals(code)) {
            toAppendTo.append("��32");
            // 1502-�g��X��
        } else if ("1502".equals(code)) {
            toAppendTo.append("�g��X��");
            // 1601-��������
        } else if ("1601".equals(code)) {
            toAppendTo.append("��������");
            // 1902-�������
        } else if ("1902".equals(code)) {
            toAppendTo.append("�������");
            // 5103-���莾��
        } else if ("5103".equals(code)) {
            toAppendTo.append("���莾��");
            // 5201-��������
        } else if ("5201".equals(code)) {
            toAppendTo.append("��������");
            // 5301-�������_
        } else if ("5301".equals(code)) {
            toAppendTo.append("�������_");
            // 1202-����
        } else if ("1202".equals(code)) {
            toAppendTo.append("����");
        }

        return toAppendTo;
    }

    public Object parseObject(String source, ParsePosition pos) {

        if (source == null)
            return null;

        String result = null;

        // �����ށiKOHI_TYPE�j�̔�����s���B
		// 1301-�폝�×{
        if ("�폝�×{".equals(source)) {
            result = "1301";
    		// 1401-�폝
        } else if ("�폝".equals(source)) {
            result = "1401";
    		// 1801-�����F��
        } else if ("�����F��".equals(source)) {
            result = "1801";
    		// 1103-��35
        } else if ("��35".equals(source)) {
            result = "1103";
    		// 2102-��32
        } else if ("��32".equals(source)) {
            result = "2102";
    		// 1502-�g��X��
        } else if ("�g��X��".equals(source)) {
            result = "1502";
    		// 1601-��������
        } else if ("��������".equals(source)) {
            result = "1601";
    		// 1902-�������
        } else if ("�������".equals(source)) {
            result = "1902";
    		// 5103-���莾��
        } else if ("���莾��".equals(source)) {
            result = "5103";
    		// 5201-��������
        } else if ("��������".equals(source)) {
            result = "5201";
    		// 5301-�������_
        } else if ("�������_".equals(source)) {
            result = "5301";
    		// 1202-����
        } else if ("����".equals(source)) {
            result = "1202";
        }

        return result;
    }

}
