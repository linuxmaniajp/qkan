/**
 * 
 */
package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * –K–â‰îŒì
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_11111_201504 extends Qkan10011_ServiceUnitGetter {

    public String getServiceName() {
        return "–K–â‰îŒì";
    }

    public String getServiceCodeKind() {
        return "11";
    }

    public String getSystemServiceKindDetail() {
        return "11111";
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

        // 1110101 –K–âí•Ê 1-g‘Ì‰îŒì 2-¶Šˆ‰‡• 3-g‘Ì¶Šˆ 4-’Ê‰@æ~‰î•
        int _1110101 = getIntValue(map, "1110101");

        // 1110104 g‘ÌŠÔ
        int _1110104 = getIntValue(map, "1110104", 1);

        // 1110105 ¶ŠˆŠÔ
        int _1110105 = getIntValue(map, "1110105", 1);

        // 1110107 –K–âl” 1-1l 2-2l
        int _1110107 = getIntValue(map, "1110107");

        // 1110108 ŠÔ‘Ñ 1-’Êí 2-‘’© 3-–éŠÔ 4-[–é
        int _1110108 = getIntValue(map, "1110108");

        // 1110109 “Á’è–‹ÆŠ‰ÁZ 1-‚È‚µ 2-IŒ^ 3-IIŒ^ 4-IIIŒ^ 5-IVŒ^
        int _1110109 = getIntValue(map, "1110109");

        // ‰‰ñ‰ÁZ
        int _1110110 = getIntValue(map, "1110110", 1);

        // ‹Ù‹}–K–â‰îŒì‰ÁZ
        int _1110111 = getIntValue(map, "1110111", 1);

        // ’†RŠÔ’nˆæ“™‚Å‚ÌƒT[ƒrƒX’ñ‹Ÿ‰ÁZ
        int _12 = getIntValue(map, "12", 1);

        // ’†RŠÔ’nˆæ“™¬‹K–Í–‹ÆŠ‰ÁZ
        int _13 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);

        // 2 “Á•Ê’nˆæ‰ÁZ
        int _2 = getIntValue(map, "2");

        // 1110113 ƒT[ƒrƒX’ñ‹ŸÓ”CÒ‚Ì‹‰E
        int _1110113 = getIntValue(map, "1110113", 1);

        // 1110112 ¶Šˆ‹@”\Œüã˜AŒg‰ÁZ
        int _1110112 = getIntValue(map, "1110112", 1);
        
        // 1110114	•p‰ñ‚Ì–K–â‚Æ‚µ‚Äs‚¤
        int _1110114 = getIntValue(map, "1110114", 1);

        // 16 “¯ˆêŒš•¨‹ZÒ‚Ö‚ÌƒT[ƒrƒX’ñ‹Ÿ
        int _16 = getIntValue(map, "16", 1);
        
        // 17 ‰îŒìEˆõˆ‹ö‰ü‘P‰ÁZ
        int _17 = getIntValue(map, Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // ŠÔ‘Ñ‚ğ’l‚É‰‚¶‚Äƒ}ƒXƒ^‚É‡‚í‚¹•ÏŠ·
        if (_1110108 == 3) {
            _1110108 = 2;
        } else if (_1110108 == 4) {
            _1110108 = 3;
        }

        switch (_1110101) {
        case 3:// g‘Ì¶Šˆ‘I‘ğ
               // “Á’è–‹ÆŠ‰ÁZ‚ğƒ`ƒFƒbƒN‚·‚éB

            if (_1110105 > 3) {
                _1110105 = 3;
            }
            break;
        case 2:// ¶Šˆ‰‡•‘I‘ğ
               // ˆê—¥‚RŠÔˆÈã‚Æ‚İ‚È‚·
            if (_1110105 > 3) {
                _1110105 = 3;
            }
            break;
        case 1:// g‘Ì‰îŒì‘I‘ğ
            break;
        }

        // “Æ©ƒR[ƒh¶¬
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // –K–âí•Ê 1-g‘Ì‰îŒì 2-¶Šˆ‰‡• 3-g‘Ì¶Šˆ 4-’Ê‰@æ~‰î•
        sb.append(CODE_CHAR[_1110101]);

        // g‘ÌŠÔ
        sb.append(CODE_CHAR[_1110104]);

        // ¶ŠˆŠÔ
        sb.append(CODE_CHAR[_1110105]);

        // ƒT[ƒrƒX’ñ‹ŸÓ”CÒ‚Ì‹‰E
        sb.append(CODE_CHAR[_1110113]);

        // –K–â‚Ì•K—v«
        sb.append(CODE_CHAR[_16]);

        // –K–âl” 1-1l 2-2l
        sb.append(CODE_CHAR[_1110107]);

        // ŠÔ‘Ñ 1-’Êí 2-‘’© 3-–éŠÔ 4-[–é
        sb.append(CODE_CHAR[_1110108]);

        // “Á’è–‹ÆŠ‰ÁZ 1-‚È‚µ 2-IŒ^ 3-IIŒ^ 4-IIIŒ^ 5-IVŒ^
        sb.append(CODE_CHAR[_1110109]);
        
        // 	•p‰ñ‚Ì–K–â‚Æ‚µ‚Äs‚¤
        sb.append(CODE_CHAR[_1110114]); //2015.04
        

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ‰ÁZ
        // ============================================================================

        // “Á•Ê’nˆæ‰ÁZ
        if (_2 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8000");
        }
        
        // –K–â‰îŒì¬‹K–Í–‹ÆŠ‰ÁZ
        if (_13 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8100");
        }
        
        // –K–â‰îŒì’†RŠÔ’nˆæ“™’ñ‹Ÿ‰ÁZ
        if (_12 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
        }
        
        // ‹Ù‹}–K–â‰îŒì‰ÁZ
        if (_1110111 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4000");
        }
        
        // –K–â‰îŒì‰‰ñ‰ÁZ
        if (_1110110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4001");
        }
        
        // ¶Šˆ‹@”\Œüã˜AŒg‰ÁZ
        if (_1110112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4002");
        }
        
        // ‰îŒìEˆõˆ‹ö‰ü‘P‚ğ•Ô‹p
        switch(_17){
        case 5:
            // –K–â‰îŒìˆ‹ö‰ü‘P‰ÁZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6274");//2015.04
            break;
        case 2:
            // –K–â‰îŒìˆ‹ö‰ü‘P‰ÁZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6271");
            break;
        case 3:
            // –K–â‰îŒìˆ‹ö‰ü‘P‰ÁZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6272");
            break;
        case 4:
            // –K–â‰îŒìˆ‹ö‰ü‘P‰ÁZIV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6273");
            break;
        }

        return sysSvcCdItems;
    }
}
