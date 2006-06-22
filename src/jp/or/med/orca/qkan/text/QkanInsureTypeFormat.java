package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

/**
 * �ی��敪��n���ꂽ�ꍇ�A�敪���疼�̂ɕϊ�����t�H�[�}�b�g�ł��B<br>
 * �����ꗗ(QP001)�Ŏg�p���܂��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Shin Fujihara
 * @version 1.0 2005/12/07
 * @see Format
 */

public class QkanInsureTypeFormat extends Format{

    private static QkanInsureTypeFormat singleton;
    /**
     * �R���X�g���N�^�ł��B
     * 
     * @deprecated #getInstance���g�p���Ă��������B
     */
    public QkanInsureTypeFormat() {
        super();
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     * 
     * @return �C���X�^���X
     */
    public static QkanInsureTypeFormat getInstance() {
        if (singleton == null) {
            singleton = new QkanInsureTypeFormat();
        }
        return singleton;
    }

	public Object parseObject(String source, ParsePosition pos) {
		
		if(source == null) return "";
		
		String result = "";
		
		//1:�Е�
		if("�Е�".equals(source) || "��".equals(source) || "�Љ�ی�".equals(source)){
			result = "1";
		//2:����
		} else if("����".equals(source) || "��".equals(source) || "�����ی�".equals(source)){
			result = "2";
		//3:����
		} else if("����".equals(source) || "��".equals(source)){
			result = "3";
		}
		
		return result;
	}

	public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
		
		if(obj == null) return new StringBuffer();
		
		String code = String.valueOf(obj);
		
		//1:�Е�
		if("1".equals(code)){
			toAppendTo.append("�Е�");
		//2:����
		} else if("2".equals(code)){
			toAppendTo.append("����");
		//3:����
		} else if("3".equals(code)){
			toAppendTo.append("����");
		}
		
		return toAppendTo;
	}

}
