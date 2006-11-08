package jp.or.med.orca.qkan.text;

import java.lang.reflect.Array;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

import com.lowagie.text.List;

/**
 * 
 * QkanInsureTypeFormat2�ł��B
 * <p>
 * Copyright (c) 2006 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Masahiko Higuchi
 * @version 1.0 2006/02/17
 */
public class QkanInsureTypeDivision extends Format {
    private static QkanInsureTypeDivision singleton;
    
   /**
    * �R���X�g���N�^�ł��B
    */ 
    public QkanInsureTypeDivision() {
        super();
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     * @return
     */
    public static QkanInsureTypeDivision getInstance() {
        if (singleton == null) {
            singleton = new QkanInsureTypeDivision();
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
            if(!"".equals(strInsurerd)){
                //��ی��Ҕԍ������ےP�Ƃł���ꍇ
                if("H".equals(strInsurerd.substring(0,1))){
                    toAppendTo.append("���ےP��");
                }else{
                    toAppendTo.append("���");
                }
            }
            //������̒������`�F�b�N����B
            if(code != null){
                String strStyle = "";
                // ��ÂŔ�ی��Ҕԍ����擾�ł��Ȃ������ꍇ
                if(code.indexOf("-")>=0){
                    int i = code.indexOf("-");
                    // �n�C�t�����������f�[�^���쐬
                    strStyle = code.substring(i+1,code.length());
                }
                if(strStyle.endsWith("20101")){
                    toAppendTo = new StringBuffer();
                    toAppendTo.append("�Е�");
                }else if(strStyle.endsWith("20102")){
                    toAppendTo = new StringBuffer();
                    toAppendTo.append("����");
                }
            }
        }
        
        
        return toAppendTo;
    }
    
    
}
