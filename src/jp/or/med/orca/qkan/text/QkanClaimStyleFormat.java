package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

/**
 * ���[���(CLAIM_STYLE_TYPE)��n���ꂽ�ꍇ�A���̂ɕϊ�����t�H�[�}�b�g�ł��B<br>
 * ����E���Ə��(QU003)�Ŏg�p���܂��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Kazuyoshi Kamitsukasa
 * @version 1.0 2006/01/20
 * @see Format
 */
public class QkanClaimStyleFormat extends Format{
    private static QkanClaimStyleFormat singleton;

    /**
     * �R���X�g���N�^�ł��B
     * 
     * @deprecated #getInstance���g�p���Ă��������B
     */
    public QkanClaimStyleFormat() {
        super();
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     * 
     * @return �C���X�^���X
     */
    public static QkanClaimStyleFormat getInstance() {
        if (singleton == null) {
            singleton = new QkanClaimStyleFormat();
        }
        return singleton;
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {

        if (obj == null)
            return new StringBuffer();

        String code = String.valueOf(obj);

        // ���[���(CLAIM_STYLE_TYPE)�̔�����s���B
        // 10101-��싋�t�����
        if ("10101".equals(code)) {
            toAppendTo.append("��싋�t�����");
    		// 10201-�l����j
        } else if ("10201".equals(code)) {
            toAppendTo.append("�l����j");
    		// 10301-�l����O
        } else if ("10301".equals(code)) {
            toAppendTo.append("�l����O");
    		// 10401-�l����l
        } else if ("10401".equals(code)) {
            toAppendTo.append("�l����l");
    		// 10501-�l�����
        } else if ("10501".equals(code)) {
            toAppendTo.append("�l�����");
    		// 10601-�l����Z
        } else if ("10601".equals(code)) {
            toAppendTo.append("�l����Z");
    		// 10701-�l���掵
        } else if ("10701".equals(code)) {
            toAppendTo.append("�l���掵");
    		// 10801-�l���攪
        } else if ("10801".equals(code)) {
            toAppendTo.append("�l���攪");
    		// 10901-�l�����
        } else if ("10901".equals(code)) {
            toAppendTo.append("�l�����");
    		// 11001-�l����\
        } else if ("11001".equals(code)) {
            toAppendTo.append("�l����\");
    		// 11101-���t�Ǘ��[�����[
        } else if ("11101".equals(code)) {
            toAppendTo.append("���t�Ǘ��[�����[");
    		// 11201-���t�Ǘ��[
        } else if ("11201".equals(code)) {
            toAppendTo.append("���t�Ǘ��[");
    		// 20101-�K��Ō�×{��׏��i�Еہj
        } else if ("20101".equals(code)) {
            toAppendTo.append("�K��Ō�×{��׏��i�Еہj");
    		// 20102-�K��Ō�×{��׏��i���ہj
        } else if ("20102".equals(code)) {
            toAppendTo.append("�K��Ō�×{��׏��i���ہj");
    		// 20201-�K��Ō�×{������i�Еہj
        } else if ("20201".equals(code)) {
            toAppendTo.append("�K��Ō�×{������i�Еہj");
    		// 20202-�K��Ō�×{������i���ہj
        } else if ("20202".equals(code)) {
            toAppendTo.append("�K��Ō�×{������i���ہj");
    		// 30101-���p�Ҍ���������
        } else if ("30101".equals(code)) {
            toAppendTo.append("���p�Ҍ���������");
            // 10111-��싋�t�����
        } else if ("10111".equals(code)) {
            toAppendTo.append("��싋�t�����");
    		// 10211-�l����j
        } else if ("10211".equals(code)) {
            toAppendTo.append("�l����j");
    		// 10212-�l����j�̓�
        } else if ("10212".equals(code)) {
            toAppendTo.append("�l����j�̓�");
    		// 10311-�l����O
        } else if ("10311".equals(code)) {
            toAppendTo.append("�l����O");
    		// 10312-�l����O�̓�
        } else if ("10312".equals(code)) {
            toAppendTo.append("�l����O�̓�");
    		// 10411-�l����l
        } else if ("10411".equals(code)) {
            toAppendTo.append("�l����l");
    		// 10412-�l����l�̓�
        } else if ("10412".equals(code)) {
            toAppendTo.append("�l����l�̓�");
    		// 10511-�l�����
        } else if ("10511".equals(code)) {
            toAppendTo.append("�l�����");
    		// 10512-�l����܂̓�
        } else if ("10512".equals(code)) {
            toAppendTo.append("�l����܂̓�");
    		// 10611-�l����Z
        } else if ("10611".equals(code)) {
            toAppendTo.append("�l����Z");
    		// 10612-�l����Z�̓�
        } else if ("10612".equals(code)) {
            toAppendTo.append("�l����Z�̓�");
    		// 10613-�l����Z�̎O
        } else if ("10613".equals(code)) {
            toAppendTo.append("�l����Z�̎O");
    		// 10614-�l����Z�̎l
        } else if ("10614".equals(code)) {
            toAppendTo.append("�l����Z�̎l");
    		// 10615-�l����Z�̌�
        } else if ("10615".equals(code)) {
            toAppendTo.append("�l����Z�̌�");
    		// 10616-�l����Z�̘Z
        } else if ("10616".equals(code)) {
            toAppendTo.append("�l����Z�̘Z");
    		// 10711-�l���掵
        } else if ("10711".equals(code)) {
            toAppendTo.append("�l���掵");
    		// 10712-�l���掵�̓�
        } else if ("10712".equals(code)) {
            toAppendTo.append("�l���掵�̓�");
    		// 10811-�l���攪
        } else if ("10811".equals(code)) {
            toAppendTo.append("�l���攪");
    		// 10911-�l�����
        } else if ("10911".equals(code)) {
            toAppendTo.append("�l�����");
    		// 11011-�l����\
        } else if ("11011".equals(code)) {
            toAppendTo.append("�l����\");
    		// 11111-���t�Ǘ��[�����[
        } else if ("11111".equals(code)) {
            toAppendTo.append("���t�Ǘ��[�����[");
    		// 11211-���t�Ǘ��[
        } else if ("11211".equals(code)) {
            toAppendTo.append("���t�Ǘ��[");
        }

        return toAppendTo;
    }

    public Object parseObject(String source, ParsePosition pos) {

        if (source == null)
            return null;

        String result = null;

        // ���[���(CLAIM_STYLE_TYPE)�̔�����s���B
        // 10101-��싋�t�����
        if ("��싋�t�����".equals(source)) {
            result = "10101";
    		// 10201-�l����j
        } else if ("�l����j".equals(source)) {
            result = "10201";
    		// 10301-�l����O
        } else if ("�l����O".equals(source)) {
            result = "10301";
    		// 10401-�l����l
        } else if ("�l����l".equals(source)) {
            result = "10401";
    		// 10501-�l�����
        } else if ("�l�����".equals(source)) {
            result = "10501";
    		// 10601-�l����Z
        } else if ("�l����Z".equals(source)) {
            result = "10601";
    		// 10701-�l���掵
        } else if ("�l���掵".equals(source)) {
            result = "10701";
    		// 10801-�l���攪
        } else if ("�l���攪".equals(source)) {
            result = "10801";
    		// 10901-�l�����
        } else if ("�l�����".equals(source)) {
            result = "10901";
    		// 11001-�l����\
        } else if ("�l����\".equals(source)) {
            result = "11001";
    		// 11101-���t�Ǘ��[�����[
        } else if ("���t�Ǘ��[����".equals(source)) {
            result = "11101";
    		// 11201-���t�Ǘ��[
        } else if ("���t�Ǘ��[".equals(source)) {
            result = "11201";
    		// 20101-�K��Ō�×{��׏��i�Еہj
        } else if ("�K��Ō�×{��׏��i�Еہj".equals(source)) {
            result = "20101";
    		// 20102-�K��Ō�×{��׏��i���ہj
        } else if ("�K��Ō�×{��׏��i���ہj".equals(source)) {
            result = "20102";
    		// 20201-�K��Ō�×{������i�Еہj
        } else if ("�K��Ō�×{������i�Еہj".equals(source)) {
            result = "20201";
    		// 20202-�K��Ō�×{������i���ہj
        } else if ("��Ō�×{������i���ہj".equals(source)) {
            result = "20202";
    		// 30101-���p�Ҍ���������
        } else if ("���p�Ҍ���������".equals(source)) {
            result = "30101";
            // 10111-��싋�t�����
        } else if ("��싋�t�����".equals(source)) {
            result = "10111";
    		// 10211-�l����j
        } else if ("�l����j".equals(source)) {
            result = "10211";
    		// 10212-�l����j�̓�
        } else if ("�l����j�̓�".equals(source)) {
            result = "10212";
    		// 10311-�l����O
        } else if ("�l����O".equals(source)) {
            result = "10311";
    		// 10312-�l����O�̓�
        } else if ("�l����O�̓�".equals(source)) {
            result = "10312";
    		// 10411-�l����l
        } else if ("�l����l".equals(source)) {
            result = "10411";
    		// 10412-�l����l�̓�
        } else if ("�l����l�̓�".equals(source)) {
            result = "10412";
    		// 10511-�l�����
        } else if ("�l�����".equals(source)) {
            result = "10511";
    		// 10512-�l����܂̓�
        } else if ("�l����܂̓�".equals(source)) {
            result = "10512";
    		// 10611-�l����Z
        } else if ("�l����Z".equals(source)) {
            result = "10611";
    		// 10612-�l����Z�̓�
        } else if ("�l����Z�̓�".equals(source)) {
            result = "10612";
    		// 10613-�l����Z�̎O
        } else if ("�l����Z�̎O".equals(source)) {
            result = "10613";
    		// 10614-�l����Z�̎l
        } else if ("�l����Z�̎l".equals(source)) {
            result = "10614";
    		// 10615-�l����Z�̌�
        } else if ("�l����Z�̌�".equals(source)) {
            result = "10615";
    		// 10616-�l����Z�̘Z
        } else if ("�l����Z�̘Z".equals(source)) {
            result = "10616";
    		// 10711-�l���掵
        } else if ("�l���掵".equals(source)) {
            result = "10711";
    		// 10712-�l���掵�̓�
        } else if ("�l���掵�̓�".equals(source)) {
            result = "10712";
    		// 10811-�l���攪
        } else if ("�l���攪".equals(source)) {
            result = "10811";
    		// 10911-�l�����
        } else if ("�l�����".equals(source)) {
            result = "10911";
    		// 11011-�l����\
        } else if ("�l����\".equals(source)) {
            result = "11011";
    		// 11111-���t�Ǘ��[�����[
        } else if ("���t�Ǘ��[����".equals(source)) {
            result = "11111";
    		// 11211-���t�Ǘ��[
        } else if ("���t�Ǘ��[".equals(source)) {
            result = "11211";
        }

        return result;
    }

}
