package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ‰îŒì—\–h’ÊŠ‰îŒì
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_16511_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "‰îŒì—\–h’ÊŠ‰îŒì";
    }

    public String getServiceCodeKind() {
        return "65";
    }

    public String getSystemServiceKindDetail() {
        return "16511";
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
        case 2: // Œo‰ß“I—v‰îŒì
        case 5: // —v‰îŒì‚P
        case 6: // —v‰îŒì‚Q
        case 7: // —v‰îŒì‚R
        case 8: // —v‰îŒì‚S
        case 9: // —v‰îŒì‚T
        case 10: // –‹Æ‘ÎÛÒ
            return new ArrayList<HashMap<String, String>>();
        }
        
        // 1650101 lˆõŒ¸Z@1-‚È‚µ 2-’èˆõ’´‰ß 3-ŠÅŒìE‰îŒìEˆõ‚ªŒ‡ˆõ
        int _1650101 = getIntValue(map, "1650101", 1);

        // 1650102 “úŠ„@1-“úŠ„‚Å‚È‚¢ 2-“úŠ„‚Å‚ ‚é
        int _1650102 = getIntValue(map, "1650102", 1);

        // 1650103 ¶Šˆ‹@”\ŒüãƒOƒ‹[ƒvŠˆ“®‰ÁZ@1-‚È‚µ 2-‚ ‚è
        int _1650103 = getIntValue(map, "1650103", 1);

        // 1650104 ‰^“®Ší‹@”\Œüã‰ÁZ@1-‚È‚µ 2-‚ ‚è
        int _1650104 = getIntValue(map, "1650104", 1);

        // 1650105 ‰h—{‰ü‘P‰ÁZ@1-‚È‚µ 2-‚ ‚è
        int _1650105 = getIntValue(map, "1650105", 1);

        // 1650106 Œûo‹@”\Œüã‰ÁZ@1-‚È‚µ 2-‚ ‚è
        int _1650106 = getIntValue(map, "1650106", 1);

        // 1650107 –‹ÆŠ•]‰¿‰ÁZ@1-‚È‚µ 2-‚ ‚è
        int _1650107 = getIntValue(map, "1650107", 1);

        // 1650108 á”N«”F’mÇ—˜—pÒó“ü‰ÁZ
        int _1650108 = getIntValue(map, "1650108", 1);

        // ’†RŠÔ’nˆæ“™‚Å‚ÌƒT[ƒrƒX’ñ‹Ÿ‰ÁZ
        int _12 = getIntValue(map, "12", 1);

        // 1650109 ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‹­‰»‰ÁZ
        int _1650109 = getIntValue(map, "1650109");

        // [CCCX:03692][Shinobu Hitaka] 2016/12/01 add - begin ŒÂ•Ê‘I‘ğ‘Î‰
        // 1650111 ‘I‘ğ“IƒT[ƒrƒX•¡”À{‰ÁZ@1-‚È‚µ 2-I1 3-I2 4-I3 5-II
        int _1650111 = getIntValue(map, "1650111", 1);

        // 16 “¯ˆêŒš•¨‹ZÒ‚Ö‚ÌƒT[ƒrƒX’ñ‹Ÿ
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
            
            // ‰^“®Ší‹@”\Œüã‰ÁZA‰h—{‰ü‘P‰ÁZAŒûo‹@”\Œüã‰ÁZA‘I‘ğ“IƒT[ƒrƒX•¡”À{‰ÁZ
            setSentakutekiService(_1650111, _1650104, _1650105, _1650106, sysSvcCdItems);
            
            // ‰îŒìEˆõˆ‹ö‰ü‘P‚ğ•Ô‹p
            switch (_17) {
            case 6:
                // —\–h’ÊŠ‰îŒìˆ‹ö‰ü‘P‰ÁZI
                putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2017.04
                break;
            case 5:
                // —\–h’ÊŠ‰îŒìˆ‹ö‰ü‘P‰ÁZII
                putSystemServiceCodeItem(sysSvcCdItems, "Z6110");
                break;
            case 2:
                // —\–h’ÊŠ‰îŒìˆ‹ö‰ü‘P‰ÁZIII
                putSystemServiceCodeItem(sysSvcCdItems, "Z6111");
                break;
            case 3:
                // —\–h’ÊŠ‰îŒìˆ‹ö‰ü‘P‰ÁZIV
                putSystemServiceCodeItem(sysSvcCdItems, "Z6113");
                break;
            case 4:
                // —\–h’ÊŠ‰îŒìˆ‹ö‰ü‘P‰ÁZV
                putSystemServiceCodeItem(sysSvcCdItems, "Z6115");
                break;
            }
            
            return sysSvcCdItems;
        }
        // [ID:0000746][Masahiko.Higuchi] 2012/06/20 add - end

        // “Æ©ƒR[ƒh¶¬
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // —v‰îŒì“x
        sb.append(CODE_CHAR[_1]);

        // lˆõŒ¸Z@1-‚È‚µ 2-’èˆõ’´‰ß 3-ŠÅŒìE‰îŒìEˆõ‚ªŒ‡ˆõ
        sb.append(CODE_CHAR[_1650101]);

        // “úŠ„@1-“úŠ„‚Å‚È‚¢ 2-“úŠ„‚Å‚ ‚é
        sb.append(CODE_CHAR[_1650102]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ‰ÁZ
        // ============================================================================
        
        // 6109 —\–h’ÊŠ‰îŒìá”N«”F’mÇó“ü‰ÁZ
        if (_1650108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // “¯ˆêŒš•¨‹ZÒ‚Ö‚ÌƒT[ƒrƒX’ñ‹Ÿ‚ª‚ ‚è‚Ìê‡
        if (_16 > 1) {
            
            // —v‰îŒì“x‚Å•ªŠò
            switch(_1) {
            // —vx‰‡‚P
            case 3:
                // —\–h’ÊŠ‰îŒì‘—Œ}Œ¸Z‚P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
                break;
            // —vx‰‡‚Q
            case 4:
                // —\–h’ÊŠ‰îŒì‘—Œ}Œ¸Z‚Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                break;
            }
            
        }
        
        // ¶Šˆ‹@”\ŒüãƒOƒ‹[ƒvŠˆ“®‰ÁZ@1-‚È‚µ 2-‚ ‚è
        if (_1650103 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5010");
        }
        
        // ‰^“®Ší‹@”\Œüã‰ÁZA‰h—{‰ü‘P‰ÁZAŒûo‹@”\Œüã‰ÁZA‘I‘ğ“IƒT[ƒrƒX•¡”À{‰ÁZ
        setSentakutekiService(_1650111, _1650104, _1650105, _1650106, sysSvcCdItems);
        
        // –‹ÆŠ•]‰¿‰ÁZ@1-‚È‚µ 2-‚ ‚è
        if (_1650107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5005");
        }
        
        switch (_1650109) {
        case 4:
            if (_1 == 3) {
                // —vx‰‡‚P‚Ìê‡
                // 6107 —\–h’ÊŠƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZIƒC‚P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6107");
            } else if (_1 == 4) {
                // —vx‰‡‚Q‚Ìê‡
                // 6108 —\–h’ÊŠƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZIƒC‚Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
            }
            break;
        case 2:
            if (_1 == 3) {
                // —vx‰‡‚P‚Ìê‡
                // 6101 —\–h’ÊŠƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZIƒ‚P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            } else if (_1 == 4) {
                // —vx‰‡‚Q‚Ìê‡
                // 6102 —\–h’ÊŠƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZIƒ‚Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            }
            break;
        case 3:
            if (_1 == 3) {
                // —vx‰‡‚P‚Ìê‡
                // 6103 —\–h’ÊŠƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZII‚P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            } else if (_1 == 4) {
                // —vx‰‡‚Q‚Ìê‡
                // 6104 —\–h’ÊŠƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZII‚Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            }
            break;
        }
        
        
        // ‰îŒìEˆõˆ‹ö‰ü‘P‚ğ•Ô‹p
        switch (_17) {
        case 6:
            // —\–h’ÊŠ‰îŒìˆ‹ö‰ü‘P‰ÁZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2017.04
            break;
        case 5:
            // —\–h’ÊŠ‰îŒìˆ‹ö‰ü‘P‰ÁZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6110");
            break;
        case 2:
            // —\–h’ÊŠ‰îŒìˆ‹ö‰ü‘P‰ÁZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6111");
            break;
        case 3:
            // —\–h’ÊŠ‰îŒìˆ‹ö‰ü‘P‰ÁZIV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6113");
            break;
        case 4:
            // —\–h’ÊŠ‰îŒìˆ‹ö‰ü‘P‰ÁZV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6115");
            break;
        }
        
        
        // “úŠ„‚è‚Å‚Í‚È‚¢ê‡
        if (_1650102 == 1) {
            
            // 8110 —\–h’ÊŠ‰îŒì’†RŠÔ’nˆæ“™’ñ‹Ÿ‰ÁZ
            if (_12 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
            }
            
            
        // “úŠ„‚è‚Ìê‡
        } else {
            
            // 8111 —\–h’ÊŠ‰îŒì’†RŠÔ’nˆæ“™‰ÁZ“úŠ„
            if (_12 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z8111");
            }
        }

        return sysSvcCdItems;
    }
    
    /**
     * ‰^“®Ší‹@”\Œüã‰ÁZA‰h—{‰ü‘P‰ÁZAŒûo‹@”\Œüã‰ÁZ‚Ì‘I‘ğó‹µ‚É‚æ‚Á‚Ä•¡”ƒT[ƒrƒXÀ{‰ÁZ‚ğİ’è‚µ‚Ü‚·B
	 * @param sentakuteki •¡”ƒT[ƒrƒXÀ{‰ÁZ
	 * @param moveFunction ‰^“®Ší‹@”\Œüã‰ÁZ
	 * @param nourishment ‰h—{‰ü‘P‰ÁZ
	 * @param mouthFunction Œûo‹@”\Œüã‰ÁZ
	 * @param sysSvcCdItems ƒT[ƒrƒXƒR[ƒhMap
     */
    private void setSentakutekiService(int sentakuteki, 
    		int moveFunction, int nourishment, int mouthFunction, 
    		ArrayList<HashMap<String, String>> sysSvcCdItems) {
    	// ‘I‘ğ“IƒT[ƒrƒX•¡”À{‰ÁZ@1-‚È‚µ 2-I1 3-I2 4-I3 5-II
        if (sentakuteki > 1) {
        	switch (sentakuteki) {
            case 2:
                // •¡”ƒT[ƒrƒXÀ{‰ÁZI‚P
                putSystemServiceCodeItem(sysSvcCdItems, "Z5006");
                break;
            case 3:
            	// •¡”ƒT[ƒrƒXÀ{‰ÁZI‚Q
	            putSystemServiceCodeItem(sysSvcCdItems, "Z5007");
                break;
            case 4:
            	// •¡”ƒT[ƒrƒXÀ{‰ÁZI‚R
	            putSystemServiceCodeItem(sysSvcCdItems, "Z5008");
                break;
            case 5:
            	// •¡”ƒT[ƒrƒXÀ{‰ÁZII
	            putSystemServiceCodeItem(sysSvcCdItems, "Z5009");
                break;
            }
        } else {
	        // ‰^“®Ší‹@”\Œüã‰ÁZA‰h—{‰ü‘P‰ÁZAŒûo‹@”\Œüã‰ÁZ‚Ì—áŠOˆ—
	        // 
	        // [‰^“®Ší‹@”\Œüã‰ÁZ‚Ìƒtƒ‰ƒO][‰h—{‰ü‘P‰ÁZ‚Ìƒtƒ‰ƒO][Œûo‹@”\Œüã‰ÁZ‚Ìƒtƒ‰ƒO]
	        // ‚Æ‚¢‚¤•À‚Ñ‚Ì3Œ…‚Ì”’l‚ğì¬‚µ‚Ä•ªŠòiƒtƒ‰ƒO‚Í 1-‚È‚µ 2-‚ ‚èj
	        int addParam = (moveFunction * 100) + (nourishment * 10) + mouthFunction;
	        
	        switch(addParam) {
	        // ‰^“®Ší‹@”\Œüã‰ÁZ
	        case 211:
	            // ‰^“®Ší‹@”\Œüã‰ÁZ
	            putSystemServiceCodeItem(sysSvcCdItems, "Z5002");
	            break;
	        // ‰h—{‰ü‘P‰ÁZ
	        case 121:
	            // ‰h—{‰ü‘P‰ÁZ
	            putSystemServiceCodeItem(sysSvcCdItems, "Z5003");
	            break;
	        // Œûo‹@”\Œüã‰ÁZ
	        case 112:
	            // Œûo‹@”\Œüã‰ÁZ
	            putSystemServiceCodeItem(sysSvcCdItems, "Z5004");
	            break;
	        // ‰^“®Ší‹@”\Œüã‰ÁZ + ‰h—{‰ü‘P‰ÁZ
	        case 221:
	            // •¡”ƒT[ƒrƒXÀ{‰ÁZI‚P
	            putSystemServiceCodeItem(sysSvcCdItems, "Z5006");
	            break;
	        // ‰^“®Ší‹@”\Œüã‰ÁZ + Œûo‹@”\Œüã‰ÁZ
	        case 212:
	            // •¡”ƒT[ƒrƒXÀ{‰ÁZI‚Q
	            putSystemServiceCodeItem(sysSvcCdItems, "Z5007");
	            break;
	        // ‰h—{‰ü‘P‰ÁZ + Œûo‹@”\Œüã‰ÁZ
	        case 122:
	            // •¡”ƒT[ƒrƒXÀ{‰ÁZI‚R
	            putSystemServiceCodeItem(sysSvcCdItems, "Z5008");
	            break;
	        // ‰^“®Ší‹@”\Œüã‰ÁZ + ‰h—{‰ü‘P‰ÁZ + Œûo‹@”\Œüã‰ÁZ
	        case 222:
	            // •¡”ƒT[ƒrƒXÀ{‰ÁZII
	            putSystemServiceCodeItem(sysSvcCdItems, "Z5009");
	            break;
	        }
        }
    }
}
