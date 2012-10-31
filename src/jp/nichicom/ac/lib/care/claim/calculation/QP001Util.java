
/*
 * Project code name "ORCA"
 * ���t�Ǘ��䒠�\�t�g QKANCHO�iJMA care benefit management software�j
 * Copyright(C) 2002 JMA (Japan Medical Association)
 *
 * This program is part of "QKANCHO (JMA care benefit management software)".
 *
 * This program is distributed in the hope that it will be useful
 * for further advancement in medical care, according to JMA Open
 * Source License, but WITHOUT ANY WARRANTY.
 * Everyone is granted permission to use, copy, modify and
 * redistribute this program, but only under the conditions described
 * in the JMA Open Source License. You should have received a copy of
 * this license along with this program. If not, stop using this
 * program and contact JMA, 2-28-16 Honkomagome, Bunkyo-ku, Tokyo,
 * 113-8621, Japan.
 *****************************************************************
 * �A�v��: QKANCHO
 * �J����: �����@�L
 * �쐬��: 2006/01/24  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X �������� (001)
 * �v���O���� �����o�̓��[�e�B���e�B�[�N���X (QP001Util)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.or.med.orca.qkan.QkanConstants;

public class QP001Util {

    /**
     * ���t�ɕϊ��\�ł��邩���肷��B
     * @param value
     * @return
     * @throws Exception
     */
    public static boolean isDate(Object value) throws Exception {
        if(value == null){
            return false;
        }
        
        if(value instanceof Date){
        	return true;
        }
        
        String sValue = String.valueOf(value);
        if(sValue.length() == 6){
            sValue += "01";
        }
        
        Date dValue = ACCastUtilities.toDate(sValue,null);
        if(dValue == null){
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * ���l��S�p�̕�����ɕϊ����܂��B
     * @param number
     * @return
     */
    public static String toWideNumber(Object number) {
        StringBuilder result = new StringBuilder();
        char[] values = String.valueOf(number).toCharArray();
        
        for(int i = 0; i < values.length; i++){
            switch(values[i]){
            case '0':
                result.append("�O");
                break;
            case '1':
                result.append("�P");
                break;
            case '2':
                result.append("�Q");
                break;
            case '3':
                result.append("�R");
                break;
            case '4':
                result.append("�S");
                break;
            case '5':
                result.append("�T");
                break;
            case '6':
                result.append("�U");
                break;
            case '7':
                result.append("�V");
                break;
            case '8':
                result.append("�W");
                break;
            case '9':
                result.append("�X");
                break;
            }
        }
        
        return result.toString();
    }
    
    public static final int TERM_START = 0; 
    public static final int TERM_200704_AFFTER = 1;
    public static final int TERM_200804_AFFTER = 2;
    public static final int TERM_200805_AFFTER = 3;
    public static final int TERM_200904_AFFTER = 4;
    
    /**
     * �@�����̊��Ԃ��擾����
     * @param obj ���t
     */
    public static int getTerm(Object obj) {
    	Date target = null;
    	int result = TERM_START;
    	
    	if (obj instanceof Date){
    		target = (Date)obj;
    	} else {
    		String tmp = String.valueOf(obj);
    		if (tmp.length() == 6) {
    			tmp += "01";
    		}
    		target = ACCastUtilities.toDate(tmp, null);
    	}
    	
    	if (target == null){
    		return result;
    	}
    	
    	try{
	    	
	    	//2007/3-2008/3
	    	if ((0 <= getDiff(target,QkanConstants.H1904)) && (getDiff(target,QkanConstants.H2004) < 0)){
	    		result = TERM_200704_AFFTER;
	    	} else if ((0 <= getDiff(target,QkanConstants.H2004)) && (getDiff(target,QkanConstants.H2005) < 0)){
	    		result = TERM_200804_AFFTER;
	    	//} else if (0 <= getDiff(target,QkanConstants.H2005)){
	    	} else if (0 <= getDiff(target,QkanConstants.H2005) && (getDiff(target,QkanConstants.H2104) < 0)){
	    		result = TERM_200805_AFFTER;
	    	//[ID:0000447][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
	    	} else if (0 <= getDiff(target,QkanConstants.H2104)){
	    		result = TERM_200904_AFFTER;
	    	//[ID:0000447][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
	    	} else {
	    		result = TERM_START;
	    	}
    	
    	} catch(Exception e){
    		
    	}
    	
    	return result;
    }
    
    private static int getDiff(Date target, Date diff){
    	int result = 0;
    	
		try {
			result = ACDateUtilities.getDifferenceOnMonth(target,diff);
		} catch (Exception e){}
    	
    	return result;
    }
    
    //[H20.4 �@�����Ή�] fujihara add end
    
}
