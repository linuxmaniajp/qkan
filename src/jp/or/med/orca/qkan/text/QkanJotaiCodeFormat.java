package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

/**
 * �v���x�敪��n���ꂽ�ꍇ�A�敪���疼�̂ɕϊ�����t�H�[�}�b�g�ł��B<br>
 * �����ꗗ(QP001)�Ŏg�p���܂��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Shin Fujihara
 * @version 1.0 2005/12/07
 * @see Format
 */

public class QkanJotaiCodeFormat extends Format {
    private static QkanJotaiCodeFormat singleton;
    private static final int CONTENT_ID = 203;
    private QkanCodeMasterFormat qcmf = new QkanCodeMasterFormat();

    /**
     * �R���X�g���N�^�ł��B
     */
    protected QkanJotaiCodeFormat() {
        super();
        qcmf.setContentID(CONTENT_ID);
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     * 
     * @return �C���X�^���X
     */
    public static QkanJotaiCodeFormat getInstance() {
        if (singleton == null) {
            singleton = new QkanJotaiCodeFormat();
        }
        return singleton;
    }

    public Object parseObject(String source, ParsePosition pos) {
        return qcmf.parseObject(source, pos);
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {
        return qcmf.format(obj, toAppendTo, pos);
    }
    
    
    
//    private static QkanJotaiCodeFormat singleton;
//
//    /**
//     * �R���X�g���N�^�ł��B
//     * 
//     * @deprecated #getInstance���g�p���Ă��������B
//     */
//    public QkanJotaiCodeFormat() {
//        super();
//    }
//
//    /**
//     * �C���X�^���X��Ԃ��܂��B
//     * 
//     * @return �C���X�^���X
//     */
//    public static QkanJotaiCodeFormat getInstance() {
//        if (singleton == null) {
//            singleton = new QkanJotaiCodeFormat();
//        }
//        return singleton;
//    }
//
//    public StringBuffer format(Object obj, StringBuffer toAppendTo,
//            FieldPosition pos) {
//
//        if (obj == null)
//            return new StringBuffer();
//
//        String code = String.valueOf(obj);
//
//        // �v����ԋ敪�̔�����s���B
//        if ("1".equals(code)) {
//            // 1-����
//            toAppendTo.append("����");
//        } else if ("11".equals(code)) {
//            // 11-�o�ߓI�v���
//            toAppendTo.append("�o�ߓI�v���");
//        } else if ("12".equals(code)) {
//            // 12-�v�x���P
//            toAppendTo.append("�v�x���P");
//        } else if ("13".equals(code)) {
//            // 13-�v�x���Q
//            toAppendTo.append("�v�x���Q");
//        } else if ("21".equals(code)) {
//            // 21-�v���1
//            toAppendTo.append("�v���P");
//        } else if ("22".equals(code)) {
//            // 22-�v���2
//            toAppendTo.append("�v���Q");
//        } else if ("23".equals(code)) {
//            // 23-�v���3
//            toAppendTo.append("�v���R");
//        } else if ("24".equals(code)) {
//            // 24-�v���4
//            toAppendTo.append("�v���S");
//        } else if ("25".equals(code)) {
//            // 25-�v���5
//            toAppendTo.append("�v���T");
//        }else{
//            //�����Ȃ�
//            toAppendTo.append("�F�藚���Ȃ�");
//        }
//        
//        return toAppendTo;
//    }
//
//    public Object parseObject(String source, ParsePosition pos) {
//
//        if (source == null)
//            return null;
//
//        String result = null;
//
//        // �v����ԋ敪�̔�����s���B
//        if ("����".equals(source)) {
//            // 1-����
//            result = "1";
//        } else if ("�o�ߓI�v���".equals(source) || "�v�x��".equals(source)) {
//            // 11-�o�ߓI�v���
//            result = "11";
//        } else if ("�v�x���P".equals(source) || "�v�x��1".equals(source)) {
//            // 12-�v�x���P
//            result = "12";
//        } else if ("�v�x���Q".equals(source) || "�v�x��2".equals(source)) {
//            // 13-�v�x���Q
//            result = "13";
//        } else if ("�v���P".equals(source) || "�v���1".equals(source)) {
//            // 21-�v���1
//            result = "21";
//        } else if ("�v���Q".equals(source) || "�v���2".equals(source)) {
//            // 22-�v���Q
//            result = "22";
//        } else if ("�v���R".equals(source) || "�v���3".equals(source)) {
//            // 23-�v���R
//            result = "23";
//        } else if ("�v���S".equals(source) || "�v���4".equals(source)) {
//            // 24-�v���4
//            result = "24";
//        } else if ("�v���T".equals(source) || "�v���5".equals(source)) {
//            // 25-�v���5
//            result = "25";
//        }
//
//        return result;
//    }

}
