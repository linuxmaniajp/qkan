package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ‰îŒì—\–h”F’mÇ‘Î‰Œ^’ÊŠ‰îŒì
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_17411_201504 extends Qkan10011_ServiceUnitGetter {

    public String getServiceName() {
        return "‰îŒì—\–h”F’mÇ‘Î‰Œ^’ÊŠ‰îŒì";
    }

    public String getServiceCodeKind() {
        return "74";
    }

    public String getSystemServiceKindDetail() {
        return "17411";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // ƒpƒ‰ƒ[ƒ^’Šo
        // =========================================================================

        // 1 —v‰îŒì“x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1740101 {İ“™‚Ì‹æ•ª1@1-‡TŒ^ 2-‡UŒ^
        int _1740101 = getIntValue(map, "1740101", 1);

        // 1740102 {İ“™‚Ì‹æ•ª2@1-’P“ÆŒ^ 2-•¹İŒ^
        int _1740102 = getIntValue(map, "1740102", 1);

        // 1740103 ŠÔ‹æ•ª@1-2`3ŠÔ 2-3`4ŠÔ 3-4`6ŠÔ 4-6`8ŠÔ 5-8`9ŠÔ 6-9`10ŠÔ
        int _1740103 = getIntValue(map, "1740103", 1);

        // 1740104 lˆõŒ¸Z@1-‚È‚µ 2-’èˆõ’´‰ß 3-ŠÅŒìE‰îŒìEˆõ‚Ì•s‘«
        int _1740104 = getIntValue(map, "1740104", 1);

        // 1740105 “ü—‰î•‰ÁZ@1-‚È‚µ 2-‚ ‚è
        int _1740105 = getIntValue(map, "1740105", 1);

        // 1740106 ŒÂ•Ê‹@”\ŒP—ûw“±‰ÁZ@1-‚È‚µ 2-‚ ‚è
        int _1740106 = getIntValue(map, "1740106", 1);

        // 1740107 ‰h—{‰ü‘P‰ÁZ@1-‚È‚µ 2-‚ ‚è
        int _1740107 = getIntValue(map, "1740107", 1);

        // 1740108 Œûo‹@”\Œüã‰ÁZ@1-‚È‚µ 2-‚ ‚è
        int _1740108 = getIntValue(map, "1740108", 1);

        // 1740109 á”N«”F’mÇ—˜—pÒó“ü‰ÁZ@1-‚È‚µ 2-‚ ‚è
        int _1740109 = getIntValue(map, "1740109", 1);

        // 1740110 ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‹­‰»‰ÁZ@1-‚È‚µ 2-IŒ^ 3-IIŒ^
        int _1740110 = getIntValue(map, "1740110", 1);

        // 16 “¯ˆêŒš•¨‹ZÒ‚Ö‚ÌƒT[ƒrƒX’ñ‹Ÿ
        int _16 = getIntValue(map, "16", 1);
        
        // 18 ‘—Œ}Œ¸Z
        int _18 = getIntValue(map, "18");

        // 17 ‰îŒìEˆõˆ‹ö‰ü‘P‰ÁZ
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // “Æ©ƒR[ƒh¶¬
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // {İ“™‚Ì‹æ•ª1@1-‡TŒ^ 2-‡UŒ^
        sb.append(CODE_CHAR[_1740101]);

        // {İ“™‚Ì‹æ•ª2@1-’P“ÆŒ^ 2-•¹İŒ^
        sb.append(CODE_CHAR[_1740102]);

        // ŠÔ‹æ•ª@1-2`3ŠÔ 2-3`4ŠÔ 3-4`6ŠÔ 4-6`8ŠÔ 5-8`9ŠÔ 6-9`10ŠÔ
        sb.append(CODE_CHAR[_1740103]);

        // —v‰îŒì“x
        sb.append(CODE_CHAR[_1]);

        // lˆõŒ¸Z@1-‚È‚µ 2-’èˆõ’´‰ß 3-ŠÅŒìE‰îŒìEˆõ‚Ì•s‘«‚ ‚è
        sb.append(CODE_CHAR[_1740104]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ‰ÁZ
        // ============================================================================

        // “ü—‰î•‰ÁZ@1-‚È‚µ 2-‚ ‚è
        if (_1740105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5301");
        }
        
        // ŒÂ•Ê‹@”\ŒP—ûw“±‰ÁZ@1-‚È‚µ 2-‚ ‚è
        if (_1740106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5050");
        }
        
        // 6109 —\”F’ÊŠ‰îŒìá”N«”F’mÇó“ü‰ÁZ
        if (_1740109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // ‰h—{‰ü‘P‰ÁZ@1-‚È‚µ 2-‚ ‚è
        if (_1740107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5606");
        }
        
        // Œûo‹@”\Œüã‰ÁZ@1-‚È‚µ 2-‚ ‚è
        if (_1740108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5607");
        }
        
        // “¯ˆêŒš•¨‹ZÒ‚Ö‚ÌƒT[ƒrƒX’ñ‹Ÿ 1-‚È‚µ 2-‚ ‚è
        if (_16 > 1) {
            // —\”F’ÊŠ‰îŒì‘—Œ}Œ¸Z
            putSystemServiceCodeItem(sysSvcCdItems, "Z5611");
        }
        
        // ‘—Œ}Œ¸Z
        switch (_18) {
        case 3: // ‰•œ
            putSystemServiceCodeItem(sysSvcCdItems, "Z56122");	//2015.04
        case 2: // •Ğ“¹
            putSystemServiceCodeItem(sysSvcCdItems, "Z56121");	//2015.04
            break;
        }
        
        switch (_1740110) {
        case 4:
            // 6100 —\”F’Ê‰îƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZIƒC
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");	//2015.04
            break;
        case 2:
            // 6101 —\”F’Ê‰îƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZIƒ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // 6102 —\”F’Ê‰îƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        }
        
        // ‰îŒìEˆõˆ‹ö‰ü‘P‚ğ•Ô‹p
        switch (_17) {
        case 6:
            // —\”F’ÊŠ‰îŒìˆ‹ö‰ü‘P‰ÁZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");	//2017.04
            break;
        case 5:
            // —\”F’ÊŠ‰îŒìˆ‹ö‰ü‘P‰ÁZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");	//2015.04
            break;
        case 2:
            // —\”F’ÊŠ‰îŒìˆ‹ö‰ü‘P‰ÁZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        case 3:
            // —\”F’ÊŠ‰îŒìˆ‹ö‰ü‘P‰ÁZIV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        case 4:
            // —\”F’ÊŠ‰îŒìˆ‹ö‰ü‘P‰ÁZV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
            break;
        }

        return sysSvcCdItems;
    }
}
