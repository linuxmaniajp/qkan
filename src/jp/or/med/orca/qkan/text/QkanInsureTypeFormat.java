package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

/**
 * 保険区分を渡された場合、区分から名称に変換するフォーマットです。<br>
 * 請求一覧(QP001)で使用します。
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
     * コンストラクタです。
     * 
     * @deprecated #getInstanceを使用してください。
     */
    public QkanInsureTypeFormat() {
        super();
    }

    /**
     * インスタンスを返します。
     * 
     * @return インスタンス
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
		
		//1:社保
		if("社保".equals(source) || "社".equals(source) || "社会保険".equals(source)){
			result = "1";
		//2:国保
		} else if("国保".equals(source) || "国".equals(source) || "国民保険".equals(source)){
			result = "2";
		//3:公費
		} else if("公費".equals(source) || "公".equals(source)){
			result = "3";
		}
		
		return result;
	}

	public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
		
		if(obj == null) return new StringBuffer();
		
		String code = String.valueOf(obj);
		
		//1:社保
		if("1".equals(code)){
			toAppendTo.append("社保");
		//2:国保
		} else if("2".equals(code)){
			toAppendTo.append("国保");
		//3:公費
		} else if("3".equals(code)){
			toAppendTo.append("公費");
		}
		
		return toAppendTo;
	}

}
