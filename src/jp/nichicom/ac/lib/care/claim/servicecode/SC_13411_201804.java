
package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ‰îŒì—\–h‹‘î—Ã—{ŠÇ—w“±
 * 
 * @since V7.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_13411_201804 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "‰îŒì—\–h‹‘î—Ã—{ŠÇ—w“±";
    }

    public String getServiceCodeKind() {
        return "34";
    }

    public String getSystemServiceKindDetail() {
        return "13411";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(Map<String, String> map) {
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

        // 12 ’†RŠÔ’nˆæ“™‚Å‚ÌƒT[ƒrƒX’ñ‹Ÿ‰ÁZ
        int _12 = getIntValue(map, "12", 1);   
        
        // ’†RŠÔ’nˆæ“™¬‹K–Í–‹ÆŠ‰ÁZ
        int _13 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);

        // 2 “Á•Ê’nˆæ‰ÁZ
        int _2 = getIntValue(map, "2");
        
        // 1340108 ’S“–Ò‹æ•ª@1-ˆãt 2-•‰Èˆãt 3-–òÜt(ˆã—Ã‹@ŠÖ) 4-–òÜt(–ò‹Ç) 5-ŠÇ—‰h—{m 6-•‰È‰q¶m“™
        // 7-ŠÅŒìt
        int _1340108 = getIntValue(map, "1340108", 1);

        // 1340102 İ‘îˆãŠw‘‡ŠÇ——¿@1-‚È‚µ 2-‚ ‚è
        //int _1340102 = getIntValue(map, "1340102", 1);

        // 1340103 “Á•Ê–òÜ@1-‚È‚µ 2-‚ ‚è
        int _1340103 = getIntValue(map, "1340103", 1);

        // 1340107 ‚ª‚ñ––Šú@1-‚ª‚ñ––Šú‚Å‚È‚¢ 2-‚ª‚ñ––Šú‚Å‚È‚¢
        int _1340107 = getIntValue(map, "1340107", 1);

        // 1340109 ŠÅŒìEˆõ‹æ•ª 1-³ŠÅ“™ 2-yŠÅ
        int _1340109 = getIntValue(map, "1340109", 1);

        // 16 Šİ’n‹æ•ªi‹Œj
        int _16 = getIntValue(map, "16", 1);

        // 1340111 Šİ’n‹æ•ª
        int _1340111 = getIntValue(map, "1340111");


        // “Æ©ƒR[ƒh¶¬
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // ’S“–Ò‹æ•ª@1-ˆãt 2-•‰Èˆãt 3-–òÜt(ˆã—Ã‹@ŠÖ) 4-–òÜt(–ò‹Ç) 5-ŠÇ—‰h—{m 6-•‰È‰q¶m“™ 7-ŠÅŒìt
        sb.append(CODE_CHAR[_1340108]);

        // İ‘îˆãŠw‘‡ŠÇ——¿@1-‚È‚µ 2-‚ ‚è
        //sb.append(CODE_CHAR[_1340102]);

        // Šİ’n‹æ•ª
        //sb.append(CODE_CHAR[_16]);
        if (_1340108 == 7) {
        	// Eˆõ‹æ•ª‚ªuŠÅŒìEˆõv‚Ìê‡
        	if (_16 == 2) {
        		sb.append("5"); // “¯ˆêŒš•¨
        	} else {
        		sb.append("4"); // “¯ˆêŒš•¨ˆÈŠO
        	}
        } else {
        	sb.append(CODE_CHAR[_1340111]);
        }
        
        // ‚ª‚ñ––Šú@1-‚ª‚ñ––Šú‚Å‚È‚¢ 2-‚ª‚ñ––Šú‚Å‚È‚¢
        sb.append(CODE_CHAR[_1340107]);

        // “Á•Ê–òÜ@1-‚È‚µ 2-‚ ‚è
        sb.append(CODE_CHAR[_1340103]);

        // ŠÅŒìEˆõ‹æ•ª
        sb.append(CODE_CHAR[_1340109]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ‰ÁZ
        // ============================================================================
        // “Á•Ê’nˆæ‰ÁZ
        if (_2 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8000");//2018.04
        }
        
        // ¬‹K–Í–‹ÆŠ‰ÁZ
        if (_13 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8100");//2018.04
        }
        
        // ’†RŠÔ’nˆæ“™’ñ‹Ÿ‰ÁZ
        if (_12 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8110");//2018.04
        }

        return sysSvcCdItems;
    }
}
