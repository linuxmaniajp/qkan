package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

/**
 * ˆÙ“®——R(•ÒWÏ)‚ğ“n‚³‚ê‚½ê‡A‹æ•ª‚©‚ç–¼Ì‚É•ÏŠ·‚·‚éƒtƒH[ƒ}ƒbƒg‚Å‚·B<br>
 * —˜—pÒ“o˜^(QU002)‚Åg—p‚µ‚Ü‚·B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Kazuyoshi Kamitsukasa
 * @version 1.0 2006/01/20
 * @see Format
 */
public class QkanChangesReasonFormat extends Format{
    private static QkanChangesReasonFormat singleton;

    /**
     * ƒRƒ“ƒXƒgƒ‰ƒNƒ^‚Å‚·B
     * 
     * @deprecated #getInstance‚ğg—p‚µ‚Ä‚­‚¾‚³‚¢B
     */
    public QkanChangesReasonFormat() {
        super();
    }

    /**
     * ƒCƒ“ƒXƒ^ƒ“ƒX‚ğ•Ô‚µ‚Ü‚·B
     * 
     * @return ƒCƒ“ƒXƒ^ƒ“ƒX
     */
    public static QkanChangesReasonFormat getInstance() {
        if (singleton == null) {
            singleton = new QkanChangesReasonFormat();
        }
        return singleton;
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {

        if (obj == null)
            return new StringBuffer();

        String code = String.valueOf(obj);

        // ˆÙ“®——R‚Ì‹æ•ª‚Ì”»’è‚ğs‚¤B
        // 11-”ñŠY“–
        if ("11".equals(code)) {
            toAppendTo.append("”ñŠY“–");
            // 12-‰îŒì{İ
        } else if ("12".equals(code)) {
            toAppendTo.append("‰îŒì{İ");
            // 13-ˆã—Ã‹@ŠÖ“ü‰@
        } else if ("13".equals(code)) {
            toAppendTo.append("ˆã—Ã‹@ŠÖ“ü‰@");
            // 14-€–S
        } else if ("14".equals(code)) {
            toAppendTo.append("€–S");
            // 15-‚»‚Ì‘¼
        } else if ("15".equals(code)) {
            toAppendTo.append("‚»‚Ì‘¼");
            // 21-‹‘î
        } else if ("21".equals(code)) {
            toAppendTo.append("‹‘î");
            // 22-‰îŒì{İ
        } else if ("22".equals(code)) {
            toAppendTo.append("‰îŒì{İ");
            // 23-ˆã—Ã‹@ŠÖ“ü‰@
        } else if ("23".equals(code)) {
            toAppendTo.append("ˆã—Ã‹@ŠÖ“ü‰@");
            // 24-€–S
        } else if ("24".equals(code)) {
            toAppendTo.append("€–S");
            // 25-‚»‚Ì‘¼
        } else if ("25".equals(code)) {
            toAppendTo.append("‚»‚Ì‘¼");
            // 31-‹‘î
        } else if ("31".equals(code)) {
            toAppendTo.append("‹‘î");
            // 32-‰îŒì{İ
        } else if ("32".equals(code)) {
            toAppendTo.append("‰îŒì{İ");
            // 33-ˆã—Ã‹@ŠÖ“ü‰@
        } else if ("33".equals(code)) {
            toAppendTo.append("ˆã—Ã‹@ŠÖ“ü‰@");
            // 34-€–S
        } else if ("34".equals(code)) {
            toAppendTo.append("€–S");
            // 35-‚»‚Ì‘¼
        } else if ("35".equals(code)) {
            toAppendTo.append("‚»‚Ì‘¼");
            // 41-Œy‰õ
        } else if ("41".equals(code)) {
            toAppendTo.append("Œy‰õ");
            // 42-{İ
        } else if ("42".equals(code)) {
            toAppendTo.append("{İ");
            // 43-ˆã—Ã‹@ŠÖ
        } else if ("43".equals(code)) {
            toAppendTo.append("ˆã—Ã‹@ŠÖ");
            // 44-€–S
        } else if ("44".equals(code)) {
            toAppendTo.append("€–S");
            // 45-‚»‚Ì‘¼
        } else if ("45".equals(code)) {
            toAppendTo.append("‚»‚Ì‘¼");
        }

        return toAppendTo;
    }

    public Object parseObject(String source, ParsePosition pos) {

        if (source == null)
            return null;

        String result = null;

        // ˆÙ“®——R‚Ì‹æ•ª‚Ì”»’è‚ğs‚¤B
        // 11-”ñŠY“–
        if ("”ñŠY“–".equals(source)) {
            result = "11";
            // 12-‰îŒì{İ
        } else if ("‰îŒì{İ".equals(source)) {
            result = "12";
            // 13-ˆã—Ã‹@ŠÖ“ü‰@
        } else if ("ˆã—Ã‹@ŠÖ“ü‰@".equals(source)) {
            result = "13";
            // 14-€–S
        } else if ("€–S".equals(source)) {
            result = "14";
            // 15-‚»‚Ì‘¼
        } else if ("‚»‚Ì‘¼".equals(source)) {
            result = "15";
            // 21-‹‘î
        } else if ("‹‘î".equals(source)) {
            result = "21";
            // 22-‰îŒì{İ
        } else if ("‰îŒì{İ".equals(source)) {
            result = "22";
            // 23-ˆã—Ã‹@ŠÖ“ü‰@
        } else if ("ˆã—Ã‹@ŠÖ“ü‰@".equals(source)) {
            result = "23";
            // 24-€–S
        } else if ("€–S".equals(source)) {
            result = "24";
            // 25-‚»‚Ì‘¼
        } else if ("‚»‚Ì‘¼".equals(source)) {
            result = "25";
            // 31-‹‘î
        } else if ("‹‘î".equals(source)) {
            result = "31";
            // 32-‰îŒì{İ
        } else if ("‰îŒì{İ".equals(source)) {
            result = "32";
            // 33-ˆã—Ã‹@ŠÖ“ü‰@
        } else if ("ˆã—Ã‹@ŠÖ“ü‰@".equals(source)) {
            result = "33";
            // 34-€–S
        } else if ("€–S".equals(source)) {
            result = "34";
            // 35-‚»‚Ì‘¼
        } else if ("‚»‚Ì‘¼".equals(source)) {
            result = "35";
            // 41-Œy‰õ
        } else if ("Œy‰õ".equals(source)) {
            result = "41";
            // 42-{İ
        } else if ("{İ".equals(source)) {
            result = "42";
            // 43-ˆã—Ã‹@ŠÖ
        } else if ("ˆã—Ã‹@ŠÖ".equals(source)) {
            result = "43";
            // 44-€–S
        } else if ("€–S".equals(source)) {
            result = "44";
            // 45-‚»‚Ì‘¼
        } else if ("‚»‚Ì‘¼".equals(source)) {
            result = "45";
        }

        return result;
    }

}
