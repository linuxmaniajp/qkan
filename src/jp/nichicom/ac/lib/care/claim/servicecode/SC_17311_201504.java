package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_17311_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì(’ZŠú—˜—pˆÈŠO)";
    }

    public String getServiceCodeKind() {
        return "73";
    }

    public String getSystemServiceKindDetail() {
        return "17311";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // ƒpƒ‰ƒ[ƒ^’Šo
        // =========================================================================
        // 1 —v‰îŒì“x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1730102 lˆõŒ¸Z 1-‚È‚µ 2-’èˆõ’´‰ß 3-‰îŒì]‹Æˆõ•s‘«
        int _1730102 = getIntValue(map, "1730102");

        // 1730103 “úŠ„
        int _1730103 = getIntValue(map, "1730103");

        // 1730101 ‰Šú‰ÁZ 1-‚È‚µ 2-‚ ‚è
        int _1730101 = getIntValue(map, "1730101");

        // 1730106 ‰ß¬ƒT[ƒrƒX‚É‘Î‚·‚éŒ¸Z
        int _1730106 = getIntValue(map, "1730106");

        // 1730107 ”F’mÇ‰ÁZ
        int _1730107 = getIntValue(map, "1730107");

        // 1730108 ŠÅŒìEˆõ”z’u‰ÁZ
        int _1730108 = getIntValue(map, "1730108");

        // 1730110 ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‹­‰»‰ÁZ
        int _1730110 = getIntValue(map, "1730110");

        // 1730111 s’¬‘º“Æ©‰ÁZ
        int _1730111 = getIntValue(map, "1730111");
        
        // 1730113 ŠÅæ‚è˜AŒg‘Ì§‰ÁZ
        int _1730113 = getIntValue(map, "1730113");

        // 1730114 –K–â‘Ì§‹­‰»‰ÁZ
        int _1730114 = getIntValue(map, "1730114");
        
        // 1730115	‘‡ƒ}ƒlƒWƒƒ“ƒg‘Ì§‹­‰»‰ÁZ
        int _1730115 = getIntValue(map, "1730115");
        
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
            if (_1730101 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6300");
            }
            
            // ŠÅæ‚è˜AŒg‘Ì§‰ÁZ
            if (_1730113 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z4000");//2015.04
            }

            // ‰îŒìEˆõˆ‹ö‰ü‘P‚ğ•Ô‹p
            switch (_17) {
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6110");//2015.04
                break;
            case 2:
                // ¬‹K–Í‘½‹@”\Œ^ˆ‹ö‰ü‘P‰ÁZI“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
                break;
            case 3:
                // ¬‹K–Í‘½‹@”\Œ^ˆ‹ö‰ü‘P‰ÁZII“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                break;
            case 4:
                // ¬‹K–Í‘½‹@”\Œ^ˆ‹ö‰ü‘P‰ÁZIII“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
                break;
            }

            return sysSvcCdItems;
        }

        // “Æ©ƒR[ƒh¶¬
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // “¯ˆêŒš•¨‹ZÒ‚Ö‚ÌƒT[ƒrƒX’ñ‹Ÿ
        sb.append(CODE_CHAR[_16]); //2015.04
        // —v‰îŒì“x
        sb.append(CODE_CHAR[_1]);
        // lˆõŒ¸Z 1-‚È‚µ 2-’èˆõ’´‰ß 3-‰îŒì]‹Æˆõ•s‘«
        sb.append(CODE_CHAR[_1730102]);
        // ‰ß¬ƒT[ƒrƒX‚É‘Î‚·‚éŒ¸Z
        sb.append(CODE_CHAR[_1730106]);
        // “úŠ„
        sb.append(CODE_CHAR[_1730103]);
        

        

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ‰ÁZ
        // ============================================================================

        // ‰Šú‰ÁZ 1-‚È‚µ 2-‚ ‚è
        if (_1730101 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6300");
        }

        switch (_1730107) {
        case 2:
            // 6128 ¬‹K–Í‘½‹@”\Œ^”F’mÇ‰ÁZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6128");
            break;
        case 3:
            // 6129 ¬‹K–Í‘½‹@”\Œ^”F’mÇ‰ÁZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6129");
            break;
        }

        switch (_1730108) {
        case 2:
            // 6137 ¬‹K–Í‘½‹@”\Œ^ŠÅŒìEˆõ”z’u‰ÁZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6137");
            break;
        case 3:
            // 6138 ¬‹K–Í‘½‹@”\Œ^ŠÅŒìEˆõ”z’u‰ÁZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6138");
            break;
        case 4:
        	// 6141 ¬‹K–Í‘½‹@”\Œ^ŠÅŒìEˆõ”z’u‰ÁZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6141");//2015.04
            break;
        }

        // 1730113 ŠÅæ‚è˜AŒg‘Ì§‰ÁZ
        if (_1730113 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4000");//2015.04
        }

        // 1730114 –K–â‘Ì§‹­‰»‰ÁZ
        if (_1730114 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4005");//2015.04
        }

        // 1730115 ‘‡ƒ}ƒlƒWƒƒ“ƒg‘Ì§‹­‰»‰ÁZ
        if (_1730115 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4010");//2015.04
        }
        
        
        switch (_1730110) {
        case 5:
            //  ¬‘½‹@”\Œ^ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZIƒC
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        case 2:
            // 6101 ¬‘½‹@”\Œ^ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZIƒ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // 6102 ¬‘½‹@”\Œ^ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
            // 6103 ¬‘½‹@”\Œ^ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }

        // ‰îŒìEˆõˆ‹ö‰ü‘P‚ğ•Ô‹p
        switch (_17) {
            // ¬‹K–Í‘½‹@”\Œ^ˆ‹ö‰ü‘P‰ÁZI
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6110");//2015.04
            break;
        case 2:
            // ¬‹K–Í‘½‹@”\Œ^ˆ‹ö‰ü‘P‰ÁZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        case 3:
            // ¬‹K–Í‘½‹@”\Œ^ˆ‹ö‰ü‘P‰ÁZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
            break;
        case 4:
            // ¬‹K–Í‘½‹@”\Œ^ˆ‹ö‰ü‘P‰ÁZIV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
            break;
        }

        // “úŠ„‚è‚Ìê‡
        if (_1730103 == 2) {

            switch (_1730111) {
            case 2:
                // ¬‘½‹@”\s’¬‘º“Æ©‰ÁZ‚P“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7102");
                break;
            case 3:
                // ¬‘½‹@”\s’¬‘º“Æ©‰ÁZ‚Q“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7104");
                break;
            case 4:
                // ¬‘½‹@”\s’¬‘º“Æ©‰ÁZ‚R“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7106");
                break;
            case 5:
                // ¬‘½‹@”\s’¬‘º“Æ©‰ÁZ‚S“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7108");
                break;
            case 6:
                // ¬‘½‹@”\s’¬‘º“Æ©‰ÁZ‚T“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7110");
                break;
            case 7:
                // ¬‘½‹@”\s’¬‘º“Æ©‰ÁZ‚U“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7112");
                break;
            case 8:
                // ¬‘½‹@”\s’¬‘º“Æ©‰ÁZ‚V“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7114");
                break;
            case 9:
                // ¬‘½‹@”\s’¬‘º“Æ©‰ÁZ‚W“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7116");
                break;
            case 10:
                // ¬‘½‹@”\s’¬‘º“Æ©‰ÁZ‚X“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7118");
                break;
            case 11:
                // ¬‘½‹@”\s’¬‘º“Æ©‰ÁZ‚P‚O“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7120");
                break;

            case 12:
                // ¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚P“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7122");
                break;
            case 13:
                // ¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚Q“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7124");
                break;
            case 14:
                // ¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚R“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7126");
                break;
            case 15:
                // ¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚S“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7128");
                break;
            case 16:
                // ¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚T“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7130");
                break;
            case 17:
                // ¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚U“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7132");
                break;
            case 18:
                // ¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚V“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7134");
                break;
            case 19:
                // ¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚W“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7136");
                break;
            case 20:
                // ¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚X“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7138");
                break;
            case 21:
                // ¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚Q‚O“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7140");
                break;

            }
            
            // ’†RŠÔ’nˆæ“™‚Å‚ÌƒT[ƒrƒX’ñ‹Ÿ‰ÁZ“úŠ„
            if (_12 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6311");//2015.04
            }
            
        } else {

            switch (_1730111) {
            case 2:
                // ¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P
                putSystemServiceCodeItem(sysSvcCdItems, "Z7101");
                break;
            case 3:
                // ¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z7103");
                break;
            case 4:
                // ¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚R
                putSystemServiceCodeItem(sysSvcCdItems, "Z7105");
                break;
            case 5:
                // ¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚S
                putSystemServiceCodeItem(sysSvcCdItems, "Z7107");
                break;
            case 6:
                // ¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚T
                putSystemServiceCodeItem(sysSvcCdItems, "Z7109");
                break;
            case 7:
                // ¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚U
                putSystemServiceCodeItem(sysSvcCdItems, "Z7111");
                break;
            case 8:
                // ¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚V
                putSystemServiceCodeItem(sysSvcCdItems, "Z7113");
                break;
            case 9:
                // ¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚W
                putSystemServiceCodeItem(sysSvcCdItems, "Z7115");
                break;
            case 10:
                // ¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚X
                putSystemServiceCodeItem(sysSvcCdItems, "Z7117");
                break;
            case 11:
                // ¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚O
                putSystemServiceCodeItem(sysSvcCdItems, "Z7119");
                break;

            case 12:
                // ¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚P
                putSystemServiceCodeItem(sysSvcCdItems, "Z7121");
                break;
            case 13:
                // ¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z7123");
                break;
            case 14:
                // ¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚R
                putSystemServiceCodeItem(sysSvcCdItems, "Z7125");
                break;
            case 15:
                // ¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚S
                putSystemServiceCodeItem(sysSvcCdItems, "Z7127");
                break;
            case 16:
                // ¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚T
                putSystemServiceCodeItem(sysSvcCdItems, "Z7129");
                break;
            case 17:
                // ¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚U
                putSystemServiceCodeItem(sysSvcCdItems, "Z7131");
                break;
            case 18:
                // ¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚V
                putSystemServiceCodeItem(sysSvcCdItems, "Z7133");
                break;
            case 19:
                // ¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚W
                putSystemServiceCodeItem(sysSvcCdItems, "Z7135");
                break;
            case 20:
                // ¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚X
                putSystemServiceCodeItem(sysSvcCdItems, "Z7137");
                break;
            case 21:
                // ¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚Q‚O
                putSystemServiceCodeItem(sysSvcCdItems, "Z7139");
                break;
            }
            
            // ’†RŠÔ’nˆæ“™‚Å‚ÌƒT[ƒrƒX’ñ‹Ÿ‰ÁZ
            if (_12 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6310");//2015.04
            }

        }

        return sysSvcCdItems;
    }
}
