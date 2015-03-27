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
     * コンストラクタです。<br>
     * 業務モードの指定が必要です。
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
        
        // 空白の場合
        if("".equals(source)){
        
        }else if("済".equals(source)){
            // 印刷済みの場合
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
            //空白
        }else {
            int printed = getPrintedCode(nextAffair);
            int columnCode = ACCastUtilities.toInt(obj,0);

            // 印刷済み対象であるか
            if((printed & columnCode) > 0){
                toAppendTo.append("済");
            }
            
        }
        return toAppendTo;
    }

    /**
     * インスタンスを返します。
     * 
     * @return インスタンス
     */
    public static QkanPatientListDataTypeFormat getInstance(String nextAffair) {
        if (singleton == null) {
            singleton = new QkanPatientListDataTypeFormat(nextAffair);
        }
        return singleton;
    }
    /**
     * 印刷済みコードを取得します。
     * 
     * @param nextAffair
     * @param nowPrintedCode
     * @return
     */
    public static int getPrintedCode(String nextAffair,Object nowPrintedCode){
        
        int printedCode = 0;
        int code = 0;
        // 処理フラグを取得
        code = getPrintedCode(nextAffair);
        
        // 現在の印刷済みコードを判別
        if(nowPrintedCode != null && String.valueOf(nowPrintedCode).length() > 0){
            printedCode = ACCastUtilities.toInt(nowPrintedCode,0);
        }
        // 論理和で計算して返却
        return code | printedCode;
    }
    
    
    /**
     * 印刷済みのコードを取得します。
     * @param nextAffair
     * @return
     */
    public static int getPrintedCode(String nextAffair){
        /*
         * 適用可能なカラム状態に応じて数値を設定
         * 「""」- 0
         * 「済」- 1
         */
        int code = 0;

        // 利用者編集
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
            
        // [2014年要望][Shinobu Hitaka] 2014/12/02 add begin 居宅療養管理指導書の対象年月に複数登録対応
        }else if("QC006".equals(nextAffair)){
            code = 1;
        // [2014年要望][Shinobu Hitaka] 2014/12/02 add end   居宅療養管理指導書の対象年月に複数登録対応
        }else if("QS001".equals(nextAffair)){
            code = 0;
            
        }else if("QR001".equals(nextAffair)){
            code = 0;
            
        }

        return code;
    }

    
}
