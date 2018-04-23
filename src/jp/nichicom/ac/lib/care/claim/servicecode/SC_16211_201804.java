package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SC_16211_201804 extends Qkan10011_ServiceUnitGetter {

    public String getServiceName() {
        return "‰îŒì—\–h–K–â“ü—‰îŒì";
    }

    public String getServiceCodeKind() {
        return "62";
    }

    public String getSystemServiceKindDetail() {
        return "16211";
    }

    protected ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // ƒpƒ‰ƒ[ƒ^’Šo
        // =========================================================================

        // 1 —v‰îŒì“x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // –¾‚ç‚©‚É—v‰îŒì“x‚ª‚¨‚©‚µ‚¢ê‡‚Í‹ó‚ğ•Ô‚·
        switch (_1) {
        case 1: // ©—§
        case 2: // Œo‰ß“I—v‰îŒì
        case 5: // —v‰îŒì‚P
        case 6: // —v‰îŒì‚Q
        case 7: // —v‰îŒì‚R
        case 8: // —v‰îŒì‚S
        case 9: // —v‰îŒì‚T
        case 10: // –‹Æ‘ÎÛÒ
            return new ArrayList<HashMap<String, String>>();
        }

        // 1620101 –K–âÒ‚Ìl”@1-ŠÅŒìEˆõ1l‹y‚Ñ‰îŒìEˆõ1l 2-‰îŒìEˆõ2l
        int _1620101 = getIntValue(map, "1620101", 1);

        // 1620102 “ü—‰îŒì‹æ•ª@1-‚È‚µ 2-•”•ª—E´@‚Ì‚İ
        int _1620102 = getIntValue(map, "1620102", 1);

        // 2 “Á•Ê’nˆæ‰ÁZ
        int _2 = getIntValue(map, "2");

        // ’†RŠÔ’nˆæ“™‚Å‚ÌƒT[ƒrƒX’ñ‹Ÿ‰ÁZ
        int _12 = getIntValue(map, "12", 1);

        // ’†RŠÔ’nˆæ“™¬‹K–Í–‹ÆŠ‰ÁZ
        int chusankantiikiJigyosyo = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);

        // 1620103 ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‹­‰»‰ÁZ
        int _1620103 = getIntValue(map, "1620103");

        // 23 “¯ˆêŒš•¨Œ¸Z
        int _23 = getIntValue(map, "23", 1);

        // 17 ‰îŒìEˆõˆ‹ö‰ü‘P‰ÁZ
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // “Æ©ƒR[ƒh¶¬
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // –K–âÒ‚Ìl”@1-ŠÅŒìEˆõ1l‹y‚Ñ‰îŒìEˆõ1l 2-‰îŒìEˆõ2l
        sb.append(CODE_CHAR[_1620101]);

        // “ü—‰îŒì‹æ•ª@1-‚È‚µ 2-•”•ª—E´@‚Ì‚İ
        sb.append(CODE_CHAR[_1620102]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ‰ÁZ
        // ============================================================================
        // “Á•Ê’nˆæ‰ÁZ
        if (_2 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8000");
        }

        // 8100 —\–h–K–â“ü—¬‹K–Í–‹ÆŠ‰ÁZ
        if (chusankantiikiJigyosyo > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8100");
        }

        // 8110 —\–h–K–â“ü—’†RŠÔ’nˆæ“™’ñ‹Ÿ‰ÁZ
        if (_12 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
        }

        // 6101 —\–h–K–â“ü—ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ
        switch (_1620103) {
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");//2015.04
            break;
        }

        // “¯ˆêŒš•¨Œ¸Z //2018.04
        switch (_23) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4111");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4112");
            break;
        }
        
        // ‰îŒìEˆõˆ‹ö‰ü‘P‚ğ•Ô‹p
        switch (_17) {
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");//2017.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        }

        return sysSvcCdItems;
    }

}
