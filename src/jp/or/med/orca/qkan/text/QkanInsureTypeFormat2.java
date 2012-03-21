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
 * QkanInsureTypeFormat2�ł��B
 * <p>
 * Copyright (c) 2006 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Masahiko Higuchi
 * @version 1.0 2006/02/17
 */
public class QkanInsureTypeFormat2 extends Format {
    private static QkanInsureTypeFormat2 singleton;
    
   /**
    * �R���X�g���N�^�ł��B
    */ 
    public QkanInsureTypeFormat2() {
        super();
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
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
        
        //1:�Е�
        if("�Е�".equals(source)){
            result = "20101";
        //2:����
        } else if("����".equals(source)){
            result = "20102";
        }
        
        return result;
    }
    
    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {
        
        if(obj == null) return new StringBuffer();
                
        String code = String.valueOf(obj);
        //�n�C�t������ɕ�����𕪊�
        String[] spStr = code.split("-");        
        //��͌��ʂ��`�F�b�N����B
        if(spStr.length > 0){

            String strInsurerd = String.valueOf(spStr[0]);
            //��ی��Ҕԍ������ےP�Ƃł���ꍇ
            if("H".equals(strInsurerd.substring(0,1))){
                toAppendTo.append("���ےP��");
            }else{
                toAppendTo.append("���");
            }
            
            //������̒������`�F�b�N����B
            if(spStr.length <= 2){
                String strStyle = String.valueOf(spStr[1]);
                if("20101".equals(strStyle)){
                    toAppendTo = new StringBuffer();
                    toAppendTo.append("�Е�");
                }else if("20102".equals(strStyle)){
                    toAppendTo = new StringBuffer();
                    toAppendTo.append("����");
                }
            }
            
        }
        
        
        return toAppendTo;
    }
    
    
}
