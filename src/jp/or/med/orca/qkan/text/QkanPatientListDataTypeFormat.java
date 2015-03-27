package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.qc.qc001.QC001;
import jp.or.med.orca.qkan.affair.qc.qc002.QC002;
import jp.or.med.orca.qkan.affair.qc.qc003.QC003;
import jp.or.med.orca.qkan.affair.qc.qc004.QC004;
import jp.or.med.orca.qkan.affair.qc.qc005.QC005;
import jp.or.med.orca.qkan.affair.qs.qs001.QS001;

public class QkanPatientListDataTypeFormat extends Format {
    
    public static QkanPatientListDataTypeFormat singleton;
    
    private String nextAffair = "";
    
    /**
     * �R���X�g���N�^�ł��B<br>
     * �Ɩ����[�h�̎w�肪�K�v�ł��B
     */
    public QkanPatientListDataTypeFormat(String nextAffair) {
        this.nextAffair = nextAffair;
    }

    /**
     * 
     */
    public Object parseObject(String source, ParsePosition pos) {
        
        if(source ==null) return "";
        
        String result ="";
        
        // �󔒂̏ꍇ
        if("".equals(source)){
        
        }else if("��".equals(source)){
            // ����ς݂̏ꍇ
            result = "1";
        }
        
        return result;
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {
        if(obj == null) return new StringBuffer();
        
        String code = String.valueOf(obj);
        
        //(null)
        if((code == null) || ("".equals(code))){
            //��
        }else {
            int printed = getPrintedCode(nextAffair);
            int columnCode = ACCastUtilities.toInt(obj,0);

            // ����ςݑΏۂł��邩
            if((printed & columnCode) > 0){
                toAppendTo.append("��");
            }
            
        }
        return toAppendTo;
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     * 
     * @return �C���X�^���X
     */
    public static QkanPatientListDataTypeFormat getInstance(String nextAffair) {
        if (singleton == null) {
            singleton = new QkanPatientListDataTypeFormat(nextAffair);
        }
        return singleton;
    }
    /**
     * ����ς݃R�[�h���擾���܂��B
     * 
     * @param nextAffair
     * @param nowPrintedCode
     * @return
     */
    public static int getPrintedCode(String nextAffair,Object nowPrintedCode){
        
        int printedCode = 0;
        int code = 0;
        // �����t���O���擾
        code = getPrintedCode(nextAffair);
        
        // ���݂̈���ς݃R�[�h�𔻕�
        if(nowPrintedCode != null && String.valueOf(nowPrintedCode).length() > 0){
            printedCode = ACCastUtilities.toInt(nowPrintedCode,0);
        }
        // �_���a�Ōv�Z���ĕԋp
        return code | printedCode;
    }
    
    
    /**
     * ����ς݂̃R�[�h���擾���܂��B
     * @param nextAffair
     * @return
     */
    public static int getPrintedCode(String nextAffair){
        /*
         * �K�p�\�ȃJ������Ԃɉ����Đ��l��ݒ�
         * �u""�v- 0
         * �u�ρv- 1
         */
        int code = 0;

        // ���p�ҕҏW
        if("QU002".equals(nextAffair)){
            code = 0;
            
        }else if("QC001".equals(nextAffair)){
            code = 0;
            
        }else if("QC002".equals(nextAffair)){
            code = 0;
            
        }else if("QC003".equals(nextAffair)){
            code = 0;
            
        }else if("QC004".equals(nextAffair)){
            code = 0;
            
        }else if("QC005".equals(nextAffair)){
            code = 1;
            
        // [2014�N�v�]][Shinobu Hitaka] 2014/12/02 add begin ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
        }else if("QC006".equals(nextAffair)){
            code = 1;
        // [2014�N�v�]][Shinobu Hitaka] 2014/12/02 add end   ����×{�Ǘ��w�����̑Ώ۔N���ɕ����o�^�Ή�
        }else if("QS001".equals(nextAffair)){
            code = 0;
            
        }else if("QR001".equals(nextAffair)){
            code = 0;
            
        }

        return code;
    }

    
}
