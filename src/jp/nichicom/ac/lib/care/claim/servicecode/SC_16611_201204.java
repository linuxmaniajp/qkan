package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SC_16611_201204 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "‰îŒì—\–h’ÊŠƒŠƒn";
    }

    public String getServiceCodeKind() {
        return "66";
    }

    public String getSystemServiceKindDetail() {
        return "16611";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // ƒpƒ‰ƒ[ƒ^’Šo
        // =========================================================================

        // 1 —v‰îŒì“x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1660101 lˆõŒ¸Z@1-‚È‚µ 2-’èˆõ’´‰ß 3-ˆãtAPTEOTESTAŠÅŒìE‰îŒìEˆõ‚ÌŒ‡ˆõ
        int _1660101 = getIntValue(map, "1660101", 1);

        // 1660102 “úŠ„@1-“úŠ„‚Å‚È‚¢ 2-“úŠ„‚Å‚ ‚é
        int _1660102 = getIntValue(map, "1660102", 1);

        // 1660103 ‰^“®Ší‹@”\Œüã‰ÁZ@1-‚È‚µ 2-‚ ‚è
        int _1660103 = getIntValue(map, "1660103", 1);

        // 1660104 ‰h—{‰ü‘P‰ÁZ@1-‚È‚µ 2-‚ ‚è
        int _1660104 = getIntValue(map, "1660104", 1);

        // 1660105 Œûo‹@”\Œüã‰ÁZ@1-‚È‚µ 2-‚ ‚è
        int _1660105 = getIntValue(map, "1660105", 1);

        // 1660106 –‹ÆŠ•]‰¿‰ÁZ@1-‚È‚µ 2-‚ ‚è
        int _1660106 = getIntValue(map, "1660106", 1);

        // 1660107 á”N«”F’mÇ—˜—pÒó“ü‰ÁZ
        int _1660107 = getIntValue(map, "1660107", 1);

        // ’†RŠÔ’nˆæ“™‚Å‚ÌƒT[ƒrƒX’ñ‹Ÿ‰ÁZ
        int _12 = getIntValue(map, "12", 1);

        // 1660108 ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‹­‰»‰ÁZ
        int _1660108 = getIntValue(map, "1660108", 1);

        // 1660110 {İ‹æ•ªƒ‰ƒWƒIƒOƒ‹[ƒv
        int _1660110 = getIntValue(map, "1660110", 1);

        // 16 ‘—Œ}‚Ì•K—v«
        int _16 = getIntValue(map, "16", 1);

        // 17 ‰îŒìEˆõˆ‹ö‰ü‘P‰ÁZ
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);
        
        // [ID:0000746][Masahiko.Higuchi] 2012/06/20 add - begin  ‰ÁZ‚Ì‚İ‘Î‰
        // ‰ÁZ‚Ì‚İ(‰^“®‹@ŠíE‰h—{‰ü‘PEŒûo‹@”\Œüã)
        int _9 = getIntValue(map,"9");

        // ’P“Æ‰ÁZ‚Ì‚İ---------------------------------------------------------------
        // ’P“Æ‰ÁZƒT[ƒrƒX
        if(_9 == 2){
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            // 1660103 ‰^“®Ší‹@”\Œüã‰ÁZ@1-‚È‚µ 2-‚ ‚è
            if (_1660103 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z5002");
            }
            
            // 1660104 ‰h—{‰ü‘P‰ÁZ@1-‚È‚µ 2-‚ ‚è
            if (_1660104 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z5003");
            }
            
            // 1660105 Œûo‹@”\Œüã‰ÁZ@1-‚È‚µ 2-‚ ‚è
            if (_1660105 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z5004");
            }
            
            // ‰îŒìEˆõˆ‹ö‰ü‘P‚ğ•Ô‹p
            switch (_17) {
            case 2:
                // —\–h’ÊŠƒŠƒnˆ‹ö‰ü‘P‰ÁZI
                putSystemServiceCodeItem(sysSvcCdItems, "Z6111");
                break;
            case 3:
                // —\–h’ÊŠƒŠƒnˆ‹ö‰ü‘P‰ÁZII
                putSystemServiceCodeItem(sysSvcCdItems, "Z6113");
                break;
            case 4:
                // —\–h’ÊŠƒŠƒnˆ‹ö‰ü‘P‰ÁZIII
                putSystemServiceCodeItem(sysSvcCdItems, "Z6115");
                break;
            }
            
            return sysSvcCdItems;
        }
        // [ID:0000746][Masahiko.Higuchi] 2012/06/20 add - end
        
        // “Æ©ƒR[ƒh¶¬
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // {İ‹æ•ª 1-•a‰@–”‚Íf—ÃŠ@2-‰îŒì˜Vl•ÛŒ’{İ
        sb.append(CODE_CHAR[_1660110]);

        // —v‰îŒì“x
        sb.append(CODE_CHAR[_1]);

        // lˆõŒ¸Z@1-‚È‚µ 2-’èˆõ’´‰ß 3-ˆãtAPTEOTESTAŠÅŒìE‰îŒìEˆõ‚ÌŒ‡ˆõ
        sb.append(CODE_CHAR[_1660101]);

        // “úŠ„@1-“úŠ„‚Å‚È‚¢ 2-“úŠ„‚Å‚ ‚é
        sb.append(CODE_CHAR[_1660102]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ‰ÁZ
        // ============================================================================

        // 6109 —\–h’ÊŠƒŠƒná”N«”F’mÇó“ü‰ÁZ
        if (_1660107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // “¯ˆêŒš•¨‹ZÒ‚Ö‚ÌƒT[ƒrƒX’ñ‹Ÿ‚ª‚ ‚è‚Ìê‡
        if (_16 > 1) {
            
            //{İ‹æ•ª‚ğŠm”F
            switch (_1660110) {
            case 1: // •a‰@–”‚Íf—ÃŠ
                // —v‰îŒì“x
                switch(_1) {
                case 3: // —vx‰‡‚P
                    // —\–h’ÊŠƒŠƒn‘—Œ}Œ¸Z‚P‚P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
                    break;
                case 4: // —vx‰‡‚Q
                    // —\–h’ÊŠƒŠƒn‘—Œ}Œ¸Z‚P‚Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                    break;
                }
                break;
            case 2: // ‰îŒì˜Vl•ÛŒ’{İ
                // —v‰îŒì“x
                switch(_1) {
                case 3: // —vx‰‡‚P
                    // —\–h’ÊŠƒŠƒn‘—Œ}Œ¸Z‚Q‚P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6107");
                    break;
                case 4: // —vx‰‡‚Q
                    // —\–h’ÊŠƒŠƒn‘—Œ}Œ¸Z‚Q‚Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
                    break;
                }
                break;
            }
        }
        
        
        // ‰^“®Ší‹@”\Œüã‰ÁZA‰h—{‰ü‘P‰ÁZAŒûo‹@”\Œüã‰ÁZ‚Ì—áŠOˆ—
        // 
        // [‰^“®Ší‹@”\Œüã‰ÁZ‚Ìƒtƒ‰ƒO][‰h—{‰ü‘P‰ÁZ‚Ìƒtƒ‰ƒO][Œûo‹@”\Œüã‰ÁZ‚Ìƒtƒ‰ƒO]
        // ‚Æ‚¢‚¤•À‚Ñ‚Ì3Œ…‚Ì”’l‚ğì¬‚µ‚Ä•ªŠòiƒtƒ‰ƒO‚Í 1-‚È‚µ 2-‚ ‚èj
        int addParam = (_1660103 * 100) + (_1660104 * 10) + _1660105;
        
        switch(addParam) {
        // ‰^“®Ší‹@”\Œüã‰ÁZ
        case 211:
            // —\–h’ÊŠƒŠƒn‰^“®Ší‹@”\Œüã‰ÁZ
            putSystemServiceCodeItem(sysSvcCdItems, "Z5002");
            break;
        // ‰h—{‰ü‘P‰ÁZ
        case 121:
            // —\–h’ÊŠƒŠƒn‰h—{‰ü‘P‰ÁZ
            putSystemServiceCodeItem(sysSvcCdItems, "Z5003");
            break;
        // Œûo‹@”\Œüã‰ÁZ
        case 112:
            // —\–h’ÊŠƒŠƒnŒûo‹@”\Œüã‰ÁZ
            putSystemServiceCodeItem(sysSvcCdItems, "Z5004");
            break;
        // ‰^“®Ší‹@”\Œüã‰ÁZ + ‰h—{‰ü‘P‰ÁZ
        case 221:
            // —\’ÊƒŠƒn•¡”ƒT[ƒrƒXÀ{‰ÁZI‚P
            putSystemServiceCodeItem(sysSvcCdItems, "Z5006");
            break;
        // ‰^“®Ší‹@”\Œüã‰ÁZ + Œûo‹@”\Œüã‰ÁZ
        case 212:
            // —\’ÊƒŠƒn•¡”ƒT[ƒrƒXÀ{‰ÁZI‚Q
            putSystemServiceCodeItem(sysSvcCdItems, "Z5007");
            break;
        // ‰h—{‰ü‘P‰ÁZ + Œûo‹@”\Œüã‰ÁZ
        case 122:
            // —\’ÊƒŠƒn•¡”ƒT[ƒrƒXÀ{‰ÁZI‚R
            putSystemServiceCodeItem(sysSvcCdItems, "Z5008");
            break;
        // ‰^“®Ší‹@”\Œüã‰ÁZ + ‰h—{‰ü‘P‰ÁZ + Œûo‹@”\Œüã‰ÁZ
        case 222:
            // —\’ÊƒŠƒn•¡”ƒT[ƒrƒXÀ{‰ÁZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z5009");
            break;
        }
        
        // –‹ÆŠ•]‰¿‰ÁZ@1-‚È‚µ 2-‚ ‚è
        if (_1660106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5005");
        }
        
        // ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‹­‰»‰ÁZ
        switch (_1660108) {
        case 2: // IŒ^
            // —v‰îŒì“x
            switch (_1) {
            case 3: // —vx‰‡‚P
                // —\’ÊƒŠƒnƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZI‚P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
                break;
            case 4: // —vx‰‡‚Q
                // —\’ÊƒŠƒnƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZI‚Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
                break;
            }
            break;
            
        case 3: // IIŒ^
            // —v‰îŒì“x
            switch (_1) {
            case 3: // —vx‰‡‚P
                // —\’ÊƒŠƒnƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZII‚P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
                break;
            case 4: // —vx‰‡‚Q
                // —\’ÊƒŠƒnƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZII‚Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
                break;
            }
            break;
        }
        
        
        // ‰îŒìEˆõˆ‹ö‰ü‘P‚ğ•Ô‹p
        switch (_17) {
        case 2:
            // —\–h’ÊŠƒŠƒnˆ‹ö‰ü‘P‰ÁZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6111");
            break;
        case 3:
            // —\–h’ÊŠƒŠƒnˆ‹ö‰ü‘P‰ÁZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6113");
            break;
        case 4:
            // —\–h’ÊŠƒŠƒnˆ‹ö‰ü‘P‰ÁZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6115");
            break;
        }
        
        
        // “úŠ„‚è‚Å‚Í‚È‚¢ê‡
        if (_1660102 == 1) {
            
            if (_12 > 1) {
                // 8110 —\–h’ÊŠƒŠƒn’†RŠÔ’nˆæ“™’ñ‹Ÿ‰ÁZ
                putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
            }
            
            
        // “úŠ„‚è‚Ìê‡
        } else {
            
            if (_12 > 1) {
                // 8111 —\–h’ÊŠƒŠƒn’†RŠÔ’nˆæ“™‰ÁZ“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z8111");
            }
            
        }

        return sysSvcCdItems;
    }
}
