
/*
 * Project code name "ORCA"
 * 給付管理台帳ソフト QKANCHO（JMA care benefit management software）
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
 * アプリ: QKANCHO
 * 開発者: 藤原　伸
 * 作成日: 2006/01/24  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 請求処理 (001)
 * プログラム 請求出力ユーティリティークラス (QP001Util)
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
     * 日付に変換可能であるか判定する。
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
     * 数値を全角の文字列に変換します。
     * @param number
     * @return
     */
    public static String toWideNumber(Object number) {
        StringBuilder result = new StringBuilder();
        char[] values = String.valueOf(number).toCharArray();
        
        for(int i = 0; i < values.length; i++){
            switch(values[i]){
            case '0':
                result.append("０");
                break;
            case '1':
                result.append("１");
                break;
            case '2':
                result.append("２");
                break;
            case '3':
                result.append("３");
                break;
            case '4':
                result.append("４");
                break;
            case '5':
                result.append("５");
                break;
            case '6':
                result.append("６");
                break;
            case '7':
                result.append("７");
                break;
            case '8':
                result.append("８");
                break;
            case '9':
                result.append("９");
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
     * 法改正の期間を取得する
     * @param obj 日付
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
	    	//[ID:0000447][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
	    	} else if (0 <= getDiff(target,QkanConstants.H2104)){
	    		result = TERM_200904_AFFTER;
	    	//[ID:0000447][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応
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
    
    //[H20.4 法改正対応] fujihara add end
    
}
