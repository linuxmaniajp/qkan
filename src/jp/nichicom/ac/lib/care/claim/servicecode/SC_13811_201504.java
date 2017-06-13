package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ”F’mÇ‘Î‰Œ^‹¤“¯¶Šˆ‰îŒì(’ZŠú—˜—p)
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_13811_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "”F’mÇ‘Î‰Œ^‹¤“¯¶Šˆ‰îŒì(’ZŠú—˜—p)";
    }

    public String getServiceCodeKind() {
        return "38";
    }

    public String getSystemServiceKindDetail() {
        return "13811 ";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // ƒpƒ‰ƒ[ƒ^’Šo
        // =========================================================================
        // 1 —v‰îŒì“x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1380102 –éŠÔ‹Î–±ğŒŠî€ 1-–‚½‚µ‚Ä‚¢‚é 2-–‚½‚µ‚Ä‚¢‚È‚¢
        int _1380102 = getIntValue(map, "1380102");

        // 1380101 lˆõŒ¸Z 1-‚È‚µ 2-’èˆõ’´‰ß 3-‰îŒì]‹Æˆõ•s‘«
        int _1380101 = getIntValue(map, "1380101");

        // 1380103 ˆã—Ã˜AŒg‘Ì§‰ÁZ 1-‚È‚µ 2-‚ ‚è
        int _1380103 = getIntValue(map, "1380103");

        // 1380104 –éŠÔx‰‡‘Ì§‰ÁZ
        int _1380104 = getIntValue(map, "1380104");

        // 1380108 ”F’mÇs“®ES—Çó‹Ù‹}‘Î‰‰ÁZ
        int _1380108 = getIntValue(map, "1380108");

        // 1380105 á”N«”F’mÇ—˜—pÒó“ü‰ÁZ
        int _1380105 = getIntValue(map, "1380105");

        // 1380107 ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‹­‰»‰ÁZ
        int _1380107 = getIntValue(map, "1380107");

        // 1380110 {İ“™‚Ì‹æ•ª
        int _1380110 = getIntValue(map, "1380110", 1);

        // 17 ‰îŒìEˆõˆ‹ö‰ü‘P‰ÁZ
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // “Æ©ƒR[ƒh¶¬
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // {İ“™‚Ì‹æ•ª
        sb.append(CODE_CHAR[_1380110]);

        // —v‰îŒì“x
        sb.append(CODE_CHAR[_1]);

        // –éŠÔ‹Î–±ğŒŠî€ 1-–‚½‚µ‚Ä‚¢‚é 2-–‚½‚µ‚Ä‚¢‚È‚¢
        sb.append(CODE_CHAR[_1380102]);

        // lˆõŒ¸Z 1-‚È‚µ 2-’èˆõ’´‰ß 3-‰îŒì]‹Æˆõ•s‘«
        sb.append(CODE_CHAR[_1380101]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ‰ÁZ
        // ============================================================================
        
        // Z6161 ’ZŠú‹¤“¯¶Šˆ–éŠÔx‰‡‘Ì§‰ÁZ
        if (_1380104 > 1) {
            // {İ‹æ•ª‚Å•ªŠò
            switch (_1380110) {
            case 1: // IŒ^
                // ’ZŠú‹¤“¯¶Šˆ–éŠÔx‰‡‘Ì§‰ÁZI
                putSystemServiceCodeItem(sysSvcCdItems, "Z6161");//2015.04
                break;
            case 2: // IIŒ^
                // ’ZŠú‹¤“¯¶Šˆ–éŠÔx‰‡‘Ì§‰ÁZII
                putSystemServiceCodeItem(sysSvcCdItems, "Z6171");//2015.04
                break;
            }
        }
        
        // 6121 ’ZŠú‹¤“¯¶Šˆ”F’mÇ‹Ù‹}‘Î‰‰ÁZ
        if (_1380108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6121");
        }
        
        // 6109 ’ZŠú‹¤“¯¶Šˆá”N«”F’mÇó“ü‰ÁZ
        if (_1380105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // ˆã—Ã˜AŒg‘Ì§‰ÁZ 1-‚È‚µ 2-‚ ‚è
        if (_1380103 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z1600");
        }
        

        switch (_1380107) {
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        case 2:
            // 6101 ’ZŠú‹¤“¯ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // 6102 ’ZŠú‹¤“¯ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
            // 6103 ’ZŠú‹¤“¯ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }

        // ‰îŒìEˆõˆ‹ö‰ü‘P‚ğ•Ô‹p
        switch (_17) {
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2017.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
            break;
        }

        return sysSvcCdItems;
    }
}
