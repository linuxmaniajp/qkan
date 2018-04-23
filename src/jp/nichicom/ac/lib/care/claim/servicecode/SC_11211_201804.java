package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * –K–â“ü—‰îŒì
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_11211_201804 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "–K–â“ü—‰îŒì";
    }

    public String getServiceCodeKind() {
        return "12";
    }

    public String getSystemServiceKindDetail() {
        return "11211";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // ƒpƒ‰ƒ[ƒ^’Šo
        // =========================================================================

        // 1 —v‰îŒì“x
        int _1 = convertYokaigodo(getIntValue(map, "1"));
        // –¾‚ç‚©‚É—v‰îŒì“x‚ª‚¨‚©‚µ‚¢ê‡‚Í‹ó‚ğ•Ô‚·
        switch (_1) {
        case 1: // ©—§
        case 3: // —vx‰‡‚P
        case 4: // —vx‰‡‚Q
        case 10: // –‹Æ‘ÎÛÒ
            return new ArrayList<HashMap<String, String>>();
        }

        // 1120103 –K–âÒí•Ê
        int _1120103 = getIntValue(map, "1120103");
        // 1120104 “ü—‰îŒì‹æ•ª
        int _1120104 = getIntValue(map, "1120104");
        // 2 “Á•Ê’nˆæ‰ÁZ
        int _2 = getIntValue(map, "2");
        // 13 ’†RŠÔ’nˆæ“™‚É‚¨‚¯‚é¬‹K–Í–‹ÆŠ
        int _13 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);
        // 12 ’†RŠÔ’nˆæ“™‚Å‚ÌƒT[ƒrƒX’ñ‹Ÿ‰ÁZ
        int _12 = getIntValue(map, "12", 1);
        // 1120105 ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‹­‰»‰ÁZ
        int _1120105 = getIntValue(map, "1120105");
        // 23 “¯ˆêŒš•¨Œ¸Z
        int _23 = getIntValue(map, "23", 1);

        // 17 ˆ‹ö‰ü‘P‰ÁZ
        int _17 = getIntValue(map, Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // “Æ©ƒR[ƒh¶¬
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // –K–âÒí•Ê
        sb.append(CODE_CHAR[_1120103]);
        // “ü—‰îŒì‹æ•ª
        sb.append(CODE_CHAR[_1120104]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ‰ÁZ
        // ============================================================================
        // “Á•Ê’nˆæ‰ÁZ
        if (_2 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8000");
        }

        // –K–â“ü—¬‹K–Í–‹ÆŠ‰ÁZ
        if (_13 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8100");
        }

        // –K–â“ü—’†RŠÔ’nˆæ“™’ñ‹Ÿ‰ÁZ
        if (_12 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
        }

        // –K–â“ü—ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ
        switch (_1120105) {
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
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
        
        // ˆ‹ö‰ü‘P‰ÁZ
        switch(_17){
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
