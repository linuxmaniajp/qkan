package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.util.VRMap;

/**
 * ƒVƒXƒeƒ€ƒT[ƒrƒXí—ŞƒR[ƒh‚ğ“n‚³‚ê‚½ê‡AƒR[ƒh‚©‚ç–¼Ì‚É•ÏŠ·‚·‚éƒtƒH[ƒ}ƒbƒg‚Å‚·B<br>
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Kazuyoshi Kamitsukasa
 * @version 1.0 2006/01/20
 * @see Format
 */
public class QkanServiceAbbreviationFormat extends Format{
    private static QkanServiceAbbreviationFormat singleton;
    private VRMap masterService;

    /**
     * ƒT[ƒrƒXƒ}ƒXƒ^ ‚ğ•Ô‚µ‚Ü‚·B
     * 
     * @return ƒT[ƒrƒXƒ}ƒXƒ^
     */
    public VRMap getMasterService() {
        return masterService;
    }

    /**
     * ƒT[ƒrƒXƒ}ƒXƒ^ ‚ğİ’è‚µ‚Ü‚·B
     * 
     * @param serviceMaster ƒT[ƒrƒXƒ}ƒXƒ^
     */
    public void setMasterService(VRMap serviceMaster) {
        this.masterService = serviceMaster;
    }

    /**
     * ƒRƒ“ƒXƒgƒ‰ƒNƒ^‚Å‚·B
     */
    protected QkanServiceAbbreviationFormat() {
        super();
    }

    /**
     * ƒCƒ“ƒXƒ^ƒ“ƒX‚ğ•Ô‚µ‚Ü‚·B
     * 
     * @return ƒCƒ“ƒXƒ^ƒ“ƒX
     */
    public static QkanServiceAbbreviationFormat getInstance() {
        if (singleton == null) {
            singleton = new QkanServiceAbbreviationFormat();
        }
        return singleton;
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {

        if (obj != null){
            if (getMasterService() != null) {
                Object service = getMasterService().get(
                        ACCastUtilities.toInteger(obj, 0));
                if (service instanceof Map) {
                    // ƒT[ƒrƒX‚Ì—ªÌ–¼‚É’uŠ·
                    obj = ((Map) service).get("SERVICE_ABBREVIATION");
                    if (obj != null) {
                        toAppendTo.append(obj);
                    }
                }
            }
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
