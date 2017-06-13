package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * –K–âŒ^ƒT[ƒrƒX(‚İ‚È‚µ)
 * 
 * @since V7.2.1
 * @author Yoichiro.Kamei
 * 
 */
public class SC_50111_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "–K–âŒ^ƒT[ƒrƒX(‚İ‚È‚µ)";
    }

    public String getServiceCodeKind() {
        return "A1";
    }

    public String getSystemServiceKindDetail() {
        return "50111";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // ƒpƒ‰ƒ[ƒ^’Šo
        // =========================================================================

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
            return new ArrayList<HashMap<String, String>>();
        }

        // 5010101 –K–â‰îŒì”ï@1-‡TŒ^ 2-‡UŒ^ 3-‡VŒ^ 4-‡WŒ^ 5-‡XŒ^ 6-‡YŒ^ 7-’ZŠÔŒ^
        int _5010101 = getIntValue(map, "5010101", 1);

        // 5010102 ƒT[ƒrƒX’ñ‹ŸÓ”CÒ‚Ì‹‰E@1-‰”CˆÈŠO 2-‰”C
        int _5010102 = getIntValue(map, "5010102", 1);

        // 5010103 “úŠ„@1-“úŠ„‚Å‚È‚¢ 2-“úŠ„‚Å‚ ‚é
        int _5010103 = getIntValue(map, "5010103", 1);

        // 2 “Á•Ê’nˆæ‰ÁZ
        int _2 = getIntValue(map, "2");

        // ’†RŠÔ’nˆæ“™‚Å‚ÌƒT[ƒrƒX’ñ‹Ÿ‰ÁZ
        int _12 = getIntValue(map, "12", 1);

        // ’†RŠÔ’nˆæ“™¬‹K–Í–‹ÆŠ‰ÁZ
        int _13 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);

        // 5010104 ‰‰ñ‰ÁZ
        int _5010104 = getIntValue(map, "5010104", 1);

        // 5010105 ¶Šˆ‹@”\Œüã˜AŒg‰ÁZ
        int _5010105 = getIntValue(map, "5010105", 1);

        // 16 “¯ˆêŒš•¨‹ZÒ‚Ö‚ÌƒT[ƒrƒX’ñ‹Ÿ
        int _16 = getIntValue(map, "16", 1);
        
        // 17 ‰îŒìEˆõˆ‹ö‰ü‘P‰ÁZ
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // “Æ©ƒR[ƒh¶¬
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // –K–â‰îŒì”ï@1-‡TŒ^ 2-‡UŒ^ 3-‡VŒ^ 4-‡WŒ^ 5-‡XŒ^ 6-‡YŒ^ 7-’ZŠÔŒ^
        sb.append(CODE_CHAR[_5010101]);

        // —v‰îŒì“x
        sb.append(CODE_CHAR[_1]);

        // ƒT[ƒrƒX’ñ‹ŸÓ”CÒ‚Ì‹‰E@1-‰”CˆÈŠO 2-‰”C
        sb.append(CODE_CHAR[_5010102]);

        // “¯ˆêŒš•¨‹ZÒ‚Ö‚ÌƒT[ƒrƒX’ñ‹Ÿ
        sb.append(CODE_CHAR[_16]);

        // “úŠ„@1-“úŠ„‚Å‚È‚¢ 2-“úŠ„‚Å‚ ‚é
        sb.append(CODE_CHAR[_5010103]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ‰ÁZ
        // ============================================================================
        
        // ‰‰ñ‰ÁZ
        if (_5010104 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4001");
        }

        // ¶Šˆ‹@”\Œüã˜AŒg‰ÁZ
        if (_5010105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4002");
        }
        
        
        // ‰îŒìEˆõˆ‹ö‰ü‘P‚ğ•Ô‹p
        switch (_17) {
        case 5:
            // ˆ‹ö‰ü‘P‰ÁZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6270");
            break;
        case 2:
        	// ˆ‹ö‰ü‘P‰ÁZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6271");
            break;
        case 3:
        	// ˆ‹ö‰ü‘P‰ÁZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6273");
            break;
        case 4:
        	// ˆ‹ö‰ü‘P‰ÁZIV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
            break;
        }
        
        
        // “úŠ„‚è‚È‚µ‚Ìê‡
        if (_5010103 == 1) {
            
        	
        	// Œ’PˆÊƒT[ƒrƒX‚Ìê‡
        	if (_5010101 < 4) {
        		
                // “Á•Ê’nˆæ‰ÁZ
                if (_2 > 1) {
                    putSystemServiceCodeItem(sysSvcCdItems, "Z8000");
                }
                
                // ’†RŠÔ’nˆæ“™¬‹K–Í–‹ÆŠ‰ÁZ
                if (_13 > 1) {
                    // 8100 —\–h–K–â‰îŒì¬‹K–Í–‹ÆŠ‰ÁZ
                    putSystemServiceCodeItem(sysSvcCdItems, "Z8100");
                }
                
                // ’†RŠÔ’nˆæ“™‚Å‚ÌƒT[ƒrƒX’ñ‹Ÿ‰ÁZ
                if (_12 > 1) {
                    // 8110 —\–h–K–â‰îŒì’†RŠÔ’nˆæ“™’ñ‹Ÿ‰ÁZ
                    putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
                }
                
            // ‰ñ”’PˆÊƒT[ƒrƒX‚Ìê‡
        	} else {
        		
                // “Á•Ê’nˆæ‰ÁZ
                if (_2 > 1) {
                    putSystemServiceCodeItem(sysSvcCdItems, "Z8002");
                }
                
                // ’†RŠÔ’nˆæ“™¬‹K–Í–‹ÆŠ‰ÁZ
                if (_13 > 1) {
                    // 8100 —\–h–K–â‰îŒì¬‹K–Í–‹ÆŠ‰ÁZ
                    putSystemServiceCodeItem(sysSvcCdItems, "Z8102");
                }
                
                // ’†RŠÔ’nˆæ“™‚Å‚ÌƒT[ƒrƒX’ñ‹Ÿ‰ÁZ
                if (_12 > 1) {
                    // 8110 —\–h–K–â‰îŒì’†RŠÔ’nˆæ“™’ñ‹Ÿ‰ÁZ
                    putSystemServiceCodeItem(sysSvcCdItems, "Z8112");
                }
        	}
            
        // “úŠ„‚è‚Ìê‡
        } else {
            // “Á•Ê’nˆæ‰ÁZ
            if (_2 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z8001");
            }
            
            // ’†RŠÔ’nˆæ“™¬‹K–Í–‹ÆŠ‰ÁZ
            if (_13 > 1) {
                // 8101 —\–h–K–â‰îŒì¬‹K–Í–‹ÆŠ‰ÁZ“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z8101");
            }
            
            // ’†RŠÔ’nˆæ“™‚Å‚ÌƒT[ƒrƒX’ñ‹Ÿ‰ÁZ
            if (_12 > 1) {
                // 8111 —\–h–K–â‰îŒì’†RŠÔ’nˆæ“™‰ÁZ“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z8111");
            }
            
        }
        
        
        return sysSvcCdItems;
    }
}
