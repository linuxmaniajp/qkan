package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ‰îŒì—\–h¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_17511_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "‰îŒì—\–h¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì(’ZŠú—˜—pˆÈŠO)";
    }

    public String getServiceCodeKind() {
        return "75";
    }

    public String getSystemServiceKindDetail() {
        return "17511";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // ƒpƒ‰ƒ[ƒ^’Šo
        // =========================================================================

        // 1 —v‰îŒì“x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1750101 ‰Šú‰ÁZ@1-‚È‚µ 2-‚ ‚è
        int _1750101 = getIntValue(map, "1750101", 1);

        // 1750102 lˆõŒ¸Z@1-‚È‚µ 2-’èˆõ’´‰ß 3-ŠÅŒìE‰îŒìEˆõ‚Ì•s‘«
        int _1750102 = getIntValue(map, "1750102", 1);

        // 1750103 “úŠ„@1-“úŠ„‚Å‚È‚¢ 2-“úŠ„‚Å‚ ‚é
        int _1750103 = getIntValue(map, "1750103", 1);

        // 1750106 ‰ß¬ƒT[ƒrƒX‚É‘Î‚·‚éŒ¸Z
        int _1750106 = getIntValue(map, "1750106", 1);


        // 1750108 ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‹­‰»‰ÁZ
        int _1750108 = getIntValue(map, "1750108", 1);
        
        // 1750110	‘‡ƒ}ƒlƒWƒƒ“ƒg‘Ì§‹­‰»‰ÁZ
        int _1750110 = getIntValue(map, "1750110");

        // ’†RŠÔ’nˆæ“™‚Å‚ÌƒT[ƒrƒX’ñ‹Ÿ‰ÁZ
        int _12 = getIntValue(map, "12", 1);
        
        // ’P“Æ‰ÁZ
        int _9 = getIntValue(map, "9");

        // 16 “¯ˆêŒš•¨‹ZÒ‚Ö‚ÌƒT[ƒrƒX’ñ‹Ÿ
        int _16 = getIntValue(map, "16", 1);

        // 17 ‰îŒìEˆõˆ‹ö‰ü‘P‰ÁZ
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // ’P“Æ‰ÁZ‚Ì‚İ---------------------------------------------------------------
        // ’P“Æ‰ÁZƒT[ƒrƒX
        if (_9 == 2) {
            // ‰Šú‰ÁZ
            if (_1750101 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6300");
            }
            
            // ‰îŒìEˆõˆ‹ö‰ü‘P‚ğ•Ô‹p
            switch (_17) {
            case 6:
                // —\¬‹K–Í‘½‹@”\ˆ‹ö‰ü‘P‰ÁZI
                putSystemServiceCodeItem(sysSvcCdItems, "Z6112");//2017.04
                break;
            case 5:
                // —\¬‹K–Í‘½‹@”\ˆ‹ö‰ü‘P‰ÁZII
                putSystemServiceCodeItem(sysSvcCdItems, "Z6110");//2015.04
                break;
            case 2:
                // —\¬‹K–Í‘½‹@”\ˆ‹ö‰ü‘P‰ÁZIII
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
                break;
            case 3:
                // —\¬‹K–Í‘½‹@”\ˆ‹ö‰ü‘P‰ÁZIV
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                break;
            case 4:
                // —\¬‹K–Í‘½‹@”\ˆ‹ö‰ü‘P‰ÁZV
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
                break;
            }

            return sysSvcCdItems;
        }

        // “Æ©ƒR[ƒh¶¬
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        
        // “¯ˆêŒš•¨‹ZÒ‚Ö‚ÌƒT[ƒrƒX’ñ‹Ÿ
        sb.append(CODE_CHAR[_16]);		//2015.04
        
        // —v‰îŒì“x
        sb.append(CODE_CHAR[_1]);

        // lˆõŒ¸Z@1-‚È‚µ 2-’èˆõ’´‰ß 3-ŠÅŒìE‰îŒìEˆõ‚Ì•s‘«
        sb.append(CODE_CHAR[_1750102]);

        // ‰ß¬ƒT[ƒrƒX‚É‘Î‚·‚éŒ¸Z
        sb.append(CODE_CHAR[_1750106]);
        
        // “úŠ„@1-“úŠ„‚Å‚È‚¢ 2-“úŠ„‚Å‚ ‚é
        sb.append(CODE_CHAR[_1750103]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ‰ÁZ
        // ============================================================================

        // ‰Šú‰ÁZ@1-‚È‚µ 2-‚ ‚è
        if (_1750101 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6300");
        }
        
        // 1750110	‘‡ƒ}ƒlƒWƒƒ“ƒg‘Ì§‹­‰»‰ÁZ
        if (_1750110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4010");//2015.04
        }
        
        switch (_1750108) {
        case 5:
            // 6100@—\¬‘½‹@”\Œ^ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZIƒC
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        case 2:
            // 6101@—\¬‘½‹@”\ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // 6102@—\¬‘½‹@”\ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
            // 6103@—\¬‘½‹@”\ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }
        
        // ‰îŒìEˆõˆ‹ö‰ü‘P‚ğ•Ô‹p
        switch (_17) {
        case 6:
            // —\¬‹K–Í‘½‹@”\ˆ‹ö‰ü‘P‰ÁZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6112");//2017.04
            break;
        case 5:
            // —\¬‹K–Í‘½‹@”\ˆ‹ö‰ü‘P‰ÁZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6110");//2015.04
            break;
        case 2:
            // —\¬‹K–Í‘½‹@”\ˆ‹ö‰ü‘P‰ÁZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        case 3:
            // —\¬‹K–Í‘½‹@”\ˆ‹ö‰ü‘P‰ÁZIV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
            break;
        case 4:
            // —\¬‹K–Í‘½‹@”\ˆ‹ö‰ü‘P‰ÁZV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
            break;
        }
        
        // “úŠ„‚è‚È‚µ
        if (_1750103 == 1) {
            // ’†RŠÔ’nˆæ“™‚Å‚ÌƒT[ƒrƒX’ñ‹Ÿ‰ÁZ
            if (_12 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6310");//2015.04
            }
            
        } else {
            // ’†RŠÔ’nˆæ“™‚Å‚ÌƒT[ƒrƒX’ñ‹Ÿ‰ÁZ
            if (_12 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6311");//2015.04
            }
        	
        }

        return sysSvcCdItems;
    }

}
