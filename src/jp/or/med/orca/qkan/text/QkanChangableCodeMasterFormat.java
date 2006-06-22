package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
/**
 *�R�[�h�}�X�^���g�p����t�H�[�}�b�g�ł��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Shin Fujihara
 * @version 1.0 2006/03/31
 * @see Format
 */
public class QkanChangableCodeMasterFormat extends Format {
	    private QkanCodeMasterFormat qcmf = new QkanCodeMasterFormat();

	    /**
	     * �R���X�g���N�^�ł��B
	     */
	    public QkanChangableCodeMasterFormat(int contentID) {
	        super();
	       qcmf.setContentID(contentID);
	    }

	    public Object parseObject(String source, ParsePosition pos) {
	        return qcmf.parseObject(source, pos);
	    }

	    public StringBuffer format(Object obj, StringBuffer toAppendTo,
	            FieldPosition pos) {
	        return qcmf.format(obj, toAppendTo, pos);
	    }
	    

}
