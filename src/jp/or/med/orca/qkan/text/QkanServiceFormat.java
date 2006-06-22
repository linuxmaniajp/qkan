package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

/**
 * ƒVƒXƒeƒ€ƒT[ƒrƒXí—ŞƒR[ƒh‚ğ“n‚³‚ê‚½ê‡AƒR[ƒh‚©‚ç–¼Ì‚É•ÏŠ·‚·‚éƒtƒH[ƒ}ƒbƒg‚Å‚·B<br>
 * —˜—pÒ“o˜^(QU002)‚Åg—p‚µ‚Ü‚·B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Kazuyoshi Kamitsukasa
 * @version 1.0 2006/01/20
 * @see Format
 */
public class QkanServiceFormat extends Format{
    private static QkanServiceFormat singleton;

    /**
     * ƒRƒ“ƒXƒgƒ‰ƒNƒ^‚Å‚·B
     * 
     * @deprecated #getInstance‚ğg—p‚µ‚Ä‚­‚¾‚³‚¢B
     */
    public QkanServiceFormat() {
        super();
    }

    /**
     * ƒCƒ“ƒXƒ^ƒ“ƒX‚ğ•Ô‚µ‚Ü‚·B
     * 
     * @return ƒCƒ“ƒXƒ^ƒ“ƒX
     */
    public static QkanServiceFormat getInstance() {
        if (singleton == null) {
            singleton = new QkanServiceFormat();
        }
        return singleton;
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {

        if (obj == null)
            return new StringBuffer();

        String code = String.valueOf(obj);

        // ƒVƒXƒeƒ€ƒT[ƒrƒXí—ŞƒR[ƒh‚Ì”»’è‚ğs‚¤B
        if ("11101".equals(code)||"11111".equals(code)) {
            // 11101-–K–â‰îŒì
            toAppendTo.append("–K–â‰îŒì");
        } else if ("11201".equals(code)||"11211".equals(code)) {
            // 11201-–K–â“ü—‰îŒì
            toAppendTo.append("–K–â“ü—‰îŒì");
        } else if ("11301".equals(code)||"11311".equals(code)) {
            // 11301-–K–âŠÅŒì(‰îŒì•ÛŒ¯)
            toAppendTo.append("–K–âŠÅŒì(‰îŒì•ÛŒ¯)");
        } else if ("20101".equals(code)||"20111".equals(code)) {
            // 20101-–K–âŠÅŒì(ˆã—Ã•ÛŒ¯)
            toAppendTo.append("–K–âŠÅŒì(ˆã—Ã•ÛŒ¯)");
        } else if ("11401".equals(code)||"11411".equals(code)) {
            // 11401-–K–âƒŠƒn
            toAppendTo.append("–K–âƒŠƒn");
        } else if ("11501".equals(code)||"11511".equals(code)) {
            // 11501-’ÊŠ‰îŒì
            toAppendTo.append("’ÊŠ‰îŒì");
        } else if ("11601".equals(code)||"11611".equals(code)) {
            // 11601-’ÊŠƒŠƒn
            toAppendTo.append("’ÊŠƒŠƒn");
        } else if ("11701".equals(code)||"11711".equals(code)) {
            // 11701-•Ÿƒ—p‹ï‘İ—^
            toAppendTo.append("•Ÿƒ—p‹ï‘İ—^");
        } else if ("12101".equals(code)||"12111".equals(code)) {
            // 12101-’ZŠú“üŠ¶Šˆ‰îŒì
            toAppendTo.append("’ZŠú“üŠ¶Šˆ‰îŒì");
        } else if ("12201".equals(code)||"12211".equals(code)) {
            // 12201-’ZŠú“üŠ—Ã—{‰îŒì(˜VŒ’{İ)
            toAppendTo.append("’ZŠú“üŠ—Ã—{‰îŒì(˜VŒ’{İ)");
        } else if ("12301".equals(code)||"12311".equals(code)) {
            // 12301-’ZŠú“üŠ—Ã—{‰îŒì(•a‰@—Ã—{Œ^)
            toAppendTo.append("’ZŠú“üŠ—Ã—{‰îŒì(•a‰@—Ã—{Œ^)");
        } else if ("12302".equals(code)||"12312".equals(code)) {
            // 12302-’ZŠú“üŠ—Ã—{‰îŒì(f—ÃŠ—Ã—{Œ^)
            toAppendTo.append("’ZŠú“üŠ—Ã—{‰îŒì(f—ÃŠ—Ã—{Œ^)");
        } else if ("12303".equals(code)||"12313".equals(code)) {
            // 12303-’ZŠú“üŠ—Ã—{‰îŒì(”F’mÇ¾Š³Œ^)
            toAppendTo.append("’ZŠú“üŠ—Ã—{‰îŒì(”F’mÇ¾Š³Œ^)");
        } else if ("12304".equals(code)||"12314".equals(code)) {
            // 12304-’ZŠú“üŠ—Ã—{‰îŒì(Šî€“K‡f—ÃŠŒ^)
            toAppendTo.append("’ZŠú“üŠ—Ã—{‰îŒì(Šî€“K‡f—ÃŠŒ^)");
        } else if ("13101".equals(code)||"13111".equals(code)) {
            // 13101-‹‘î—Ã—{ŠÇ—w“±
            toAppendTo.append("‹‘î—Ã—{ŠÇ—w“±");
        } else if ("13201".equals(code)||"13211".equals(code)) {
            // 13201-”F’mÇ‘Î‰Œ^‹¤“¯¶Šˆ‰îŒì
            toAppendTo.append("”F’mÇ‘Î‰Œ^‹¤“¯¶Šˆ‰îŒì");
        } else if ("13301".equals(code)||"13311".equals(code)) {
            // 13301-“Á’è{İ“üŠÒ¶Šˆ‰îŒì
            toAppendTo.append("“Á’è{İ“üŠÒ¶Šˆ‰îŒì");
        } else if ("13611".equals(code)) {
            // 13611-’nˆæ–§’…Œ^“Á’è{İ“ü‹Ò¶Šˆ‰îŒì
            toAppendTo.append("’nˆæ–§’…Œ^“Á’è{İ“ü‹Ò¶Šˆ‰îŒì");
        } else if ("13811".equals(code)) {
            // 13811-”F’mÇ‘Î‰Œ^‹¤“¯¶Šˆ‰îŒì(’ZŠú—˜—p)
            toAppendTo.append("”F’mÇ‘Î‰Œ^‹¤“¯¶Šˆ‰îŒì(’ZŠú—˜—p)");
        } else if ("14301".equals(code)||"14311".equals(code)) {
            // 14301-‹‘î‰îŒìx‰‡
            toAppendTo.append("‹‘î‰îŒìx‰‡");
        } else if ("15101".equals(code)||"15111".equals(code)) {
            // 15101-‰îŒì˜Vl•Ÿƒ{İ
            toAppendTo.append("‰îŒì˜Vl•Ÿƒ{İ");
        } else if ("15201".equals(code)||"15211".equals(code)) {
            // 15201-‰îŒì˜Vl•ÛŒ’{İ
            toAppendTo.append("‰îŒì˜Vl•ÛŒ’{İ");
        } else if ("15301".equals(code)||"15311".equals(code)) {
            // 15301-‰îŒì—Ã—{Œ^ˆã—Ã{İ(—Ã—{Œ^•a‰@)
            toAppendTo.append("‰îŒì—Ã—{Œ^ˆã—Ã{İ(—Ã—{Œ^•a‰@)");
        } else if ("15302".equals(code)||"15312".equals(code)) {
            // 15302-‰îŒì—Ã—{Œ^ˆã—Ã{İ(f—ÃŠŒ^)
            toAppendTo.append("‰îŒì—Ã—{Œ^ˆã—Ã{İ(f—ÃŠŒ^)");
        } else if ("15303".equals(code)||"15313".equals(code)) {
            // 15303-‰îŒì—Ã—{Œ^ˆã—Ã{İ(”F’mÇ¾Š³Œ^)
            toAppendTo.append("‰îŒì—Ã—{Œ^ˆã—Ã{İ(”F’mÇ¾Š³Œ^)");
        } else if ("15411".equals(code)) {
            // 15411-’nˆæ–§’…Œ^‰îŒì•Ÿƒ{İ
            toAppendTo.append("’nˆæ–§’…Œ^‰îŒì•Ÿƒ{İ");
        } else if ("17111".equals(code)) {
            // 17111-–éŠÔ‘Î‰Œ^–K–â‰îŒì
            toAppendTo.append("–éŠÔ‘Î‰Œ^–K–â‰îŒì");
        } else if ("17211".equals(code)) {
            // 17211-”F’mÇ‘Î‰Œ^’ÊŠ‰îŒì
            toAppendTo.append("”F’mÇ‘Î‰Œ^’ÊŠ‰îŒì");
        } else if ("17311".equals(code)) {
            // 17311-¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì
            toAppendTo.append("¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì");        
        } else if ("90101".equals(code)) {
            // 90101-‚»‚Ì‘¼
            toAppendTo.append("‚»‚Ì‘¼");
        } else if ("90201".equals(code)) {
            // 90201-å‚È“úí¶Šˆã‚ÌŠˆ“®
            toAppendTo.append("å‚È“úí¶Šˆã‚ÌŠˆ“®");
        }

        return toAppendTo;
    }

    public Object parseObject(String source, ParsePosition pos) {

        if (source == null)
            return null;

        String result = null;

        // ƒVƒXƒeƒ€ƒT[ƒrƒXí—ŞƒR[ƒh‚Ì”»’è‚ğs‚¤B
        // 11101-–K–â‰îŒì
        if ("–K–â‰îŒì".equals(source)) {
            result = "11101";
            // 11201-–K–â“ü—‰îŒì
        } else if ("–K–â“ü—‰îŒì".equals(source)) {
            result = "11201";
            // 11301-–K–âŠÅŒì(‰îŒì•ÛŒ¯)
        } else if ("–K–âŠÅŒì(‰îŒì•ÛŒ¯)".equals(source) || "–K–âŠÅŒìi‰îŒì•ÛŒ¯j".equals(source)) {
            result = "11301";
            // 20101-–K–âŠÅŒì(ˆã—Ã•ÛŒ¯)
        } else if ("–K–âŠÅŒì(ˆã—Ã•ÛŒ¯)".equals(source) || "–K–âŠÅŒìiˆã—Ã•ÛŒ¯j".equals(source)) {
            result = "20101";
            // 11401-–K–âƒŠƒn
        } else if ("–K–âƒŠƒn".equals(source)) {
            result = "11401";
            // 11501-’ÊŠ‰îŒì
        } else if ("’ÊŠ‰îŒì".equals(source)) {
            result = "11501";
            // 11601-’ÊŠƒŠƒn
        } else if ("’ÊŠƒŠƒn".equals(source)) {
            result = "11601";
            // 11701-•Ÿƒ—p‹ï‘İ—^
        } else if ("•Ÿƒ—p‹ï‘İ—^".equals(source)) {
            result = "11701";
            // 12101-’ZŠú“üŠ¶Šˆ‰îŒì
        } else if ("’ZŠú“üŠ¶Šˆ‰îŒì".equals(source)) {
            result = "12101";
            // 12201-’ZŠú“üŠ—Ã—{‰îŒì(˜VŒ’{İ)
        } else if ("’ZŠú“üŠ—Ã—{‰îŒì(˜VŒ’{İ)".equals(source) || "’ZŠú“üŠ—Ã—{‰îŒìi˜VŒ’{İj".equals(source)) {
            result = "12201";
            // 12301-’ZŠú“üŠ—Ã—{‰îŒì(•a‰@—Ã—{Œ^)
        } else if ("’ZŠú“üŠ—Ã—{‰îŒì(•a‰@—Ã—{Œ^)".equals(source) || "’ZŠú“üŠ—Ã—{‰îŒìi•a‰@—Ã—{Œ^j".equals(source)) {
            result = "12301";
            // 12302-’ZŠú“üŠ—Ã—{‰îŒì(f—ÃŠ—Ã—{Œ^)
        } else if ("’ZŠú“üŠ—Ã—{‰îŒì(f—ÃŠ—Ã—{Œ^)".equals(source) || "’ZŠú“üŠ—Ã—{‰îŒìif—ÃŠ—Ã—{Œ^j".equals(source)) {
            result = "12302";
            // 12303-’ZŠú“üŠ—Ã—{‰îŒì(”F’mÇ¾Š³Œ^)
        } else if ("’ZŠú“üŠ—Ã—{‰îŒì(”F’mÇ¾Š³Œ^)".equals(source) || "’ZŠú“üŠ—Ã—{‰îŒìi”F’mÇ¾Š³Œ^j".equals(source)) {
            result = "12303";
            // 12304-’ZŠú“üŠ—Ã—{‰îŒì(Šî€“K‡f—ÃŠŒ^)
        } else if ("’ZŠú“üŠ—Ã—{‰îŒì(Šî€“K‡f—ÃŠŒ^)".equals(source) || "’ZŠú“üŠ—Ã—{‰îŒìiŠî€“K‡f—ÃŠŒ^j".equals(source)) {
            result = "12304";
            // 13101-‹‘î—Ã—{ŠÇ—w“±
        } else if ("‹‘î—Ã—{ŠÇ—w“±".equals(source)) {
            result = "13101";
            // 13201-”F’mÇ‘Î‰Œ^‹¤“¯¶Šˆ‰îŒì
        } else if ("”F’mÇ‘Î‰Œ^‹¤“¯¶Šˆ‰îŒì".equals(source)) {
            result = "13201";
            // 13301-“Á’è{İ“üŠÒ¶Šˆ‰îŒì
        } else if ("“Á’è{İ“üŠÒ¶Šˆ‰îŒì".equals(source)) {
            result = "13301";
            // 14301-‹‘î‰îŒìx‰‡
        } else if ("‹‘î‰îŒìx‰‡".equals(source)) {
            result = "14301";
            // 15101-‰îŒì˜Vl•Ÿƒ{İ
        } else if ("‰îŒì˜Vl•Ÿƒ{İ".equals(source)) {
            result = "15101";
            // 15201-‰îŒì˜Vl•ÛŒ’{İ
        } else if ("‰îŒì˜Vl•ÛŒ’{İ".equals(source)) {
            result = "15201";
            // 15301-‰îŒì—Ã—{Œ^ˆã—Ã{İ(—Ã—{Œ^•a‰@)
        } else if ("‰îŒì—Ã—{Œ^ˆã—Ã{İ(—Ã—{Œ^•a‰@)".equals(source) || "‰îŒì—Ã—{Œ^ˆã—Ã{İi—Ã—{Œ^•a‰@j".equals(source)) {
            result = "15301";
            // 15302-‰îŒì—Ã—{Œ^ˆã—Ã{İ(f—ÃŠŒ^)
        } else if ("‰îŒì—Ã—{Œ^ˆã—Ã{İ(f—ÃŠŒ^)".equals(source) || "‰îŒì—Ã—{Œ^ˆã—Ã{İif—ÃŠŒ^j".equals(source)) {
            result = "15302";
            // 15303-‰îŒì—Ã—{Œ^ˆã—Ã{İ(”F’mÇ¾Š³Œ^)
        } else if ("‰îŒì—Ã—{Œ^ˆã—Ã{İ(”F’mÇ¾Š³Œ^)".equals(source) || "‰îŒì—Ã—{Œ^ˆã—Ã{İi”F’mÇ¾Š³Œ^j".equals(source)) {
            result = "15303";
            // 90101-‚»‚Ì‘¼
        } else if ("‚»‚Ì‘¼".equals(source)) {
            result = "90101";
            // 90201-å‚È“úí¶Šˆã‚ÌŠˆ“®
        } else if ("å‚È“úí¶Šˆã‚ÌŠˆ“®".equals(source)) {
            result = "90201";
        }

        return result;
    }

}
