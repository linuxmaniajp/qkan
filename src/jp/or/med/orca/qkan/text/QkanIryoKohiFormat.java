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
public class QkanIryoKohiFormat extends Format{
    private static QkanIryoKohiFormat singleton;

    /**
     * コンストラクタです。
     * 
     * @deprecated #getInstanceを使用してください。
     */
    public QkanIryoKohiFormat() {
        super();
    }

    /**
     * インスタンスを返します。
     * 
     * @return インスタンス
     */
    public static QkanIryoKohiFormat getInstance() {
        if (singleton == null) {
            singleton = new QkanIryoKohiFormat();
        }
        return singleton;
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {

        if (obj == null)
            return new StringBuffer();

        String code = String.valueOf(obj);
        
        // 公費種類（KOHI_TYPE）の判定を行う。
        // 1301-戦傷療養
        if ("1301".equals(code)) {
            toAppendTo.append("戦傷療養");
            // 1401-戦傷
        } else if ("1401".equals(code)) {
            toAppendTo.append("戦傷");
            // 1801-原爆認定
        } else if ("1801".equals(code)) {
            toAppendTo.append("原爆認定");
            // 1103-結35
        } else if ("1103".equals(code)) {
            toAppendTo.append("結35");
            // 2102-精32
        } else if ("2102".equals(code)) {
            toAppendTo.append("精32");
            // 1502-身障更生
        } else if ("1502".equals(code)) {
            toAppendTo.append("身障更生");
            // 1601-児童福祉
        } else if ("1601".equals(code)) {
            toAppendTo.append("児童福祉");
            // 1902-原爆一般
        } else if ("1902".equals(code)) {
            toAppendTo.append("原爆一般");
            // 5103-特定疾患
        } else if ("5103".equals(code)) {
            toAppendTo.append("特定疾患");
            // 5201-小児特疾
        } else if ("5201".equals(code)) {
            toAppendTo.append("小児特疾");
            // 5301-児童精神
        } else if ("5301".equals(code)) {
            toAppendTo.append("児童精神");
            // 1202-生保
        } else if ("1202".equals(code)) {
            toAppendTo.append("生保");
        }

        return toAppendTo;
    }

    public Object parseObject(String source, ParsePosition pos) {

        if (source == null)
            return null;

        String result = null;

        // 公費種類（KOHI_TYPE）の判定を行う。
		// 1301-戦傷療養
        if ("戦傷療養".equals(source)) {
            result = "1301";
    		// 1401-戦傷
        } else if ("戦傷".equals(source)) {
            result = "1401";
    		// 1801-原爆認定
        } else if ("原爆認定".equals(source)) {
            result = "1801";
    		// 1103-結35
        } else if ("結35".equals(source)) {
            result = "1103";
    		// 2102-精32
        } else if ("精32".equals(source)) {
            result = "2102";
    		// 1502-身障更生
        } else if ("身障更生".equals(source)) {
            result = "1502";
    		// 1601-児童福祉
        } else if ("児童福祉".equals(source)) {
            result = "1601";
    		// 1902-原爆一般
        } else if ("原爆一般".equals(source)) {
            result = "1902";
    		// 5103-特定疾患
        } else if ("特定疾患".equals(source)) {
            result = "5103";
    		// 5201-小児特疾
        } else if ("小児特疾".equals(source)) {
            result = "5201";
    		// 5301-児童精神
        } else if ("児童精神".equals(source)) {
            result = "5301";
    		// 1202-生保
        } else if ("生保".equals(source)) {
            result = "1202";
        }

        return result;
    }

}
