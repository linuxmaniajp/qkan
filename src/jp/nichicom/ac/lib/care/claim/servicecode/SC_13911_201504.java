package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ‰îŒì—\–h”F’mÇ‘Î‰Œ^‹¤“¯¶Šˆ‰îŒì(’ZŠú—˜—p)
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_13911_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "‰îŒì—\–h”F’mÇ‘Î‰Œ^‹¤“¯¶Šˆ‰îŒì(’ZŠú—˜—p)";
    }

    public String getServiceCodeKind() {
        return "39";
    }

    public String getSystemServiceKindDetail() {
        return "13911";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // ƒpƒ‰ƒ[ƒ^’Šo
        // =========================================================================

        // 1 —v‰îŒì“x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1390101 lˆõŒ¸Z@1-‚È‚µ 2-’èˆõ’´‰ß 3-‰îŒì]‹Æˆõ‚Ì•s‘«
        int _1390101 = getIntValue(map, "1390101", 1);

        // 1390102 –éŠÔ‹Î–±ğŒŠî€@1-–‚½‚µ‚Ä‚¢‚é 2-–‚½‚µ‚Ä‚¢‚È‚¢
        int _1390102 = getIntValue(map, "1390102", 1);

        // 1390103 –éŠÔx‰‡‘Ì§‰ÁZ
        int _1390103 = getIntValue(map, "1390103", 1);

        // 1390107 ”F’mÇs“®ES—Çó‹Ù‹}‘Î‰‰ÁZ
        int _1390107 = getIntValue(map, "1390107", 1);

        // 1390104 á”N«”F’mÇ—˜—pÒó“ü‰ÁZ
        int _1390104 = getIntValue(map, "1390104", 1);

        // 1390106 ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‹­‰»‰ÁZ
        int _1390106 = getIntValue(map, "1390106", 1);

        // 1390109 {İ“™‚Ì‹æ•ª
        int _1390109 = getIntValue(map, "1390109", 1);

        // 17 ‰îŒìEˆõˆ‹ö‰ü‘P‰ÁZ
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // “Æ©ƒR[ƒh¶¬
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // {İ“™‚Ì‹æ•ª
        sb.append(CODE_CHAR[_1390109]);

        // —v‰îŒì“x
        sb.append(CODE_CHAR[_1]);

        // –éŠÔ‹Î–±ğŒŠî€@1-–‚½‚µ‚Ä‚¢‚é 2-–‚½‚µ‚Ä‚¢‚È‚¢
        sb.append(CODE_CHAR[_1390102]);

        // lˆõŒ¸Z@1-‚È‚µ 2-’èˆõ’´‰ß 3-‰îŒì]‹Æˆõ‚Ì•s‘«
        sb.append(CODE_CHAR[_1390101]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ‰ÁZ
        // ============================================================================
        // 6161 —\”F’mÇ‘Î‰–éŠÔx‰‡‘Ì§‰ÁZ
        if (_1390103 > 1) {
            //{İ‹æ•ª‚É‚æ‚è•ªŠò
            switch (_1390109) {
            case 1: // IŒ^
                putSystemServiceCodeItem(sysSvcCdItems, "Z6161");//2015.04
                break;
            case 2: // IIŒ^
                putSystemServiceCodeItem(sysSvcCdItems, "Z6171");//2015.04
                break;
            }
        }
        
        // 6121 —\’ZŠú‹¤“¯”F’mÇ‹Ù‹}‘Î‰‰ÁZ
        if (_1390107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6121");
        }
        
        // 6109 —\”F’mÇ‘Î‰á”N«”F’mÇó“ü‰ÁZ
        if (_1390104 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        switch (_1390106) {
        case 5:
            // 6100 —\”F’m‘Î‰ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZIƒC
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        case 2:
            // 6101 —\”F’m‘Î‰ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZIƒ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // 6102 —\”F’m‘Î‰ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
            // 6103 —\”F’m‘Î‰ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }

        // ‰îŒìEˆõˆ‹ö‰ü‘P‚ğ•Ô‹p
        switch (_17) {
        case 6:
            // —\’ZŠú‹¤“¯¶Šˆˆ‹ö‰ü‘P‰ÁZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2017.04
            break;
        case 5:
            // —\’ZŠú‹¤“¯¶Šˆˆ‹ö‰ü‘P‰ÁZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");//2015.04
            break;
        case 2:
            // —\’ZŠú‹¤“¯¶Šˆˆ‹ö‰ü‘P‰ÁZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        case 3:
            // —\’ZŠú‹¤“¯¶Šˆˆ‹ö‰ü‘P‰ÁZIV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
            break;
        case 4:
            // —\’ZŠú‹¤“¯¶Šˆˆ‹ö‰ü‘P‰ÁZV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
            break;
        }

        return sysSvcCdItems;
    }
}
