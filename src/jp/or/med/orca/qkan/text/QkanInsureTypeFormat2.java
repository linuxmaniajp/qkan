package jp.or.med.orca.qkan.text;

import java.lang.reflect.Array;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;


/**
 * 
 * QkanInsureTypeFormat2です。
 * <p>
 * Copyright (c) 2006 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Masahiko Higuchi
 * @version 1.0 2006/02/17
 */
public class QkanInsureTypeFormat2 extends Format {
    private static QkanInsureTypeFormat2 singleton;
    
   /**
    * コンストラクタです。
    */ 
    public QkanInsureTypeFormat2() {
        super();
    }

    /**
     * インスタンスを返します。
     * @return
     */
    public static QkanInsureTypeFormat2 getInstance() {
        if (singleton == null) {
            singleton = new QkanInsureTypeFormat2();
        }
        return singleton;
    }
    
    public Object parseObject(String source, ParsePosition pos) {
        
        if(source == null) return "";
        
        String result = "";
        
        //1:社保
        if("社保".equals(source)){
            result = "20101";
        //2:国保
        } else if("国保".equals(source)){
            result = "20102";
        }
        
        return result;
    }
    
    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {
        
        if(obj == null) return new StringBuffer();
                
        String code = String.valueOf(obj);
        //ハイフンを基準に文字列を分割
        String[] spStr = code.split("-");        
        //解析結果をチェックする。
        if(spStr.length > 0){

            String strInsurerd = String.valueOf(spStr[0]);
            //被保険者番号が生保単独である場合
            if("H".equals(strInsurerd.substring(0,1))){
                toAppendTo.append("生保単独");
            }else{
                toAppendTo.append("介護");
            }
            
            //文字列の長さをチェックする。
            if(spStr.length <= 2){
                String strStyle = String.valueOf(spStr[1]);
                if("20101".equals(strStyle)){
                    toAppendTo = new StringBuffer();
                    toAppendTo.append("社保");
                }else if("20102".equals(strStyle)){
                    toAppendTo = new StringBuffer();
                    toAppendTo.append("国保");
                }
            }
            
        }
        
        
        return toAppendTo;
    }
    
    
}
