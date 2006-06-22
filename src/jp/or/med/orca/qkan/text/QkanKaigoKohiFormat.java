package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

/**
 * 公費種類（KOHI_TYPE）を渡された場合、名称に変換するフォーマットです。<br>
 * 公費・減免情報(QU003)で使用します。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Kazuyoshi Kamitsukasa
 * @version 1.0 2006/01/27
 * @see Format
 */
public class QkanKaigoKohiFormat extends Format{
    private static QkanKaigoKohiFormat singleton;

    /**
     * コンストラクタです。
     * 
     * @deprecated #getInstanceを使用してください。
     */
    public QkanKaigoKohiFormat() {
        super();
    }

    /**
     * インスタンスを返します。
     * 
     * @return インスタンス
     */
    public static QkanKaigoKohiFormat getInstance() {
        if (singleton == null) {
            singleton = new QkanKaigoKohiFormat();
        }
        return singleton;
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {

        if (obj == null)
            return new StringBuffer();

        String code = String.valueOf(obj);
        
        // 公費種類（KOHI_TYPE）の判定を行う。
        // 1001-結核(一般)
        if ("1001".equals(code)) {
            toAppendTo.append("結核(一般)");
            // 1101-結核(従業)
        } else if ("1101".equals(code)) {
            toAppendTo.append("結核(従業)");
            // 1102-結核(命令)
        } else if ("1102".equals(code)) {
            toAppendTo.append("結核(命令)");
            // 2101-精神
        } else if ("2101".equals(code)) {
            toAppendTo.append("精神");
            // 1501-身障者(更生)
        } else if ("1501".equals(code)) {
            toAppendTo.append("身障者(更生)");
            // 1901-原爆
        } else if ("1901".equals(code)) {
            toAppendTo.append("原爆");
            // 8601-被爆体験
        } else if ("8601".equals(code)) {
            toAppendTo.append("被爆体験");
            // 5101-特定疾患
        } else if ("5101".equals(code)) {
            toAppendTo.append("特定疾患");
            // 5102-血液
        } else if ("5102".equals(code)) {
            toAppendTo.append("血液");
            // 8801-水俣病
        } else if ("8801".equals(code)) {
            toAppendTo.append("水俣病");
            // 8701-ヒ素
        } else if ("8701".equals(code)) {
            toAppendTo.append("ヒ素");
            // 5701-特対(身障者)
        } else if ("5701".equals(code)) {
            toAppendTo.append("特対(身障者)");
            // 8101-地方原爆(訪介)
        } else if ("8101".equals(code)) {
            toAppendTo.append("地方原爆(訪介)");
            // 8102-地方原爆(介保)
        } else if ("8102".equals(code)) {
            toAppendTo.append("地方原爆(介保)");
            // 1201-生保
        } else if ("1201".equals(code)) {
            toAppendTo.append("生保");
            // 7701-社福減免1/2
        } else if ("7701".equals(code)) {
            toAppendTo.append("社福減免1/2");
            // 7702-社福減免1/4
        } else if ("7702".equals(code)) {
            toAppendTo.append("社福減免1/4");
        }

        return toAppendTo;
    }

    public Object parseObject(String source, ParsePosition pos) {

        if (source == null)
            return null;

        String result = null;

        // 公費種類（KOHI_TYPE）の判定を行う。
        // 1001-結核(一般)
        if ("結核(一般)".equals(source)) {
            result = "1001";
            // 1101-結核(従業)
        } else if ("結核(従業)".equals(source)) {
            result = "1101";
    		// 1102-結核(命令)
        } else if ("結核(命令)".equals(source)) {
            result = "1102";
    		// 2101-精神
        } else if ("精神".equals(source)) {
            result = "2101";
    		// 1501-身障者(更生)
        } else if ("身障者(更生)".equals(source)) {
            result = "1501";
    		// 1901-原爆
        } else if ("原爆".equals(source)) {
            result = "1901";
    		// 8601-被爆体験
        } else if ("被爆体験".equals(source)) {
            result = "8601";
    		// 5101-特定疾患
        } else if ("特定疾患".equals(source)) {
            result = "5101";
    		// 5102-血液
        } else if ("血液".equals(source)) {
            result = "5102";
    		// 8801-水俣病
        } else if ("水俣病".equals(source)) {
            result = "8801";
    		// 8701-ヒ素
        } else if ("ヒ素".equals(source)) {
            result = "8701";
    		// 5701-特対(身障者)
        } else if ("特対(身障者)".equals(source)) {
            result = "5701";
    		// 8101-地方原爆(訪介)
        } else if ("地方原爆(訪介)".equals(source)) {
            result = "8101";
    		// 8102-地方原爆(介保)
        } else if ("地方原爆(介保)".equals(source)) {
            result = "8102";
    		// 1201-生保
        } else if ("生保".equals(source)) {
            result = "1201";
    		// 7701-社福減免1/2
        } else if ("社福減免1/2".equals(source)) {
            result = "7701";
    		// 7702-社福減免1/4
        } else if ("社福減免1/4".equals(source)) {
            result = "7702";
        }

        return result;
    }

}
