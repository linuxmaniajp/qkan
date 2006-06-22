package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

/**
 * 要介護度区分を渡された場合、区分から名称に変換するフォーマットです。<br>
 * 請求一覧(QP001)で使用します。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Shin Fujihara
 * @version 1.0 2005/12/07
 * @see Format
 */

public class QkanJotaiCodeFormat extends Format {
    private static QkanJotaiCodeFormat singleton;
    private static final int CONTENT_ID = 203;
    private QkanCodeMasterFormat qcmf = new QkanCodeMasterFormat();

    /**
     * コンストラクタです。
     */
    protected QkanJotaiCodeFormat() {
        super();
        qcmf.setContentID(CONTENT_ID);
    }

    /**
     * インスタンスを返します。
     * 
     * @return インスタンス
     */
    public static QkanJotaiCodeFormat getInstance() {
        if (singleton == null) {
            singleton = new QkanJotaiCodeFormat();
        }
        return singleton;
    }

    public Object parseObject(String source, ParsePosition pos) {
        return qcmf.parseObject(source, pos);
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {
        return qcmf.format(obj, toAppendTo, pos);
    }
    
    
    
//    private static QkanJotaiCodeFormat singleton;
//
//    /**
//     * コンストラクタです。
//     * 
//     * @deprecated #getInstanceを使用してください。
//     */
//    public QkanJotaiCodeFormat() {
//        super();
//    }
//
//    /**
//     * インスタンスを返します。
//     * 
//     * @return インスタンス
//     */
//    public static QkanJotaiCodeFormat getInstance() {
//        if (singleton == null) {
//            singleton = new QkanJotaiCodeFormat();
//        }
//        return singleton;
//    }
//
//    public StringBuffer format(Object obj, StringBuffer toAppendTo,
//            FieldPosition pos) {
//
//        if (obj == null)
//            return new StringBuffer();
//
//        String code = String.valueOf(obj);
//
//        // 要介護状態区分の判定を行う。
//        if ("1".equals(code)) {
//            // 1-自立
//            toAppendTo.append("自立");
//        } else if ("11".equals(code)) {
//            // 11-経過的要介護
//            toAppendTo.append("経過的要介護");
//        } else if ("12".equals(code)) {
//            // 12-要支援１
//            toAppendTo.append("要支援１");
//        } else if ("13".equals(code)) {
//            // 13-要支援２
//            toAppendTo.append("要支援２");
//        } else if ("21".equals(code)) {
//            // 21-要介護1
//            toAppendTo.append("要介護１");
//        } else if ("22".equals(code)) {
//            // 22-要介護2
//            toAppendTo.append("要介護２");
//        } else if ("23".equals(code)) {
//            // 23-要介護3
//            toAppendTo.append("要介護３");
//        } else if ("24".equals(code)) {
//            // 24-要介護4
//            toAppendTo.append("要介護４");
//        } else if ("25".equals(code)) {
//            // 25-要介護5
//            toAppendTo.append("要介護５");
//        }else{
//            //履歴なし
//            toAppendTo.append("認定履歴なし");
//        }
//        
//        return toAppendTo;
//    }
//
//    public Object parseObject(String source, ParsePosition pos) {
//
//        if (source == null)
//            return null;
//
//        String result = null;
//
//        // 要介護状態区分の判定を行う。
//        if ("自立".equals(source)) {
//            // 1-自立
//            result = "1";
//        } else if ("経過的要介護".equals(source) || "要支援".equals(source)) {
//            // 11-経過的要介護
//            result = "11";
//        } else if ("要支援１".equals(source) || "要支援1".equals(source)) {
//            // 12-要支援１
//            result = "12";
//        } else if ("要支援２".equals(source) || "要支援2".equals(source)) {
//            // 13-要支援２
//            result = "13";
//        } else if ("要介護１".equals(source) || "要介護1".equals(source)) {
//            // 21-要介護1
//            result = "21";
//        } else if ("要介護２".equals(source) || "要介護2".equals(source)) {
//            // 22-要介護２
//            result = "22";
//        } else if ("要介護３".equals(source) || "要介護3".equals(source)) {
//            // 23-要介護３
//            result = "23";
//        } else if ("要介護４".equals(source) || "要介護4".equals(source)) {
//            // 24-要介護4
//            result = "24";
//        } else if ("要介護５".equals(source) || "要介護5".equals(source)) {
//            // 25-要介護5
//            result = "25";
//        }
//
//        return result;
//    }

}
