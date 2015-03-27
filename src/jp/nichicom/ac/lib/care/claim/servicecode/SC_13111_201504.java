package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ‹‘î—Ã—{ŠÇ—w“±
 * 
 * @since V7.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_13111_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "‹‘î—Ã—{ŠÇ—w“±";
    }

    public String getServiceCodeKind() {
        return "31";
    }

    public String getSystemServiceKindDetail() {
        return "13111";
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
            return new ArrayList<HashMap<String, String>>();
        }

        // 1310111 Eˆõ‹æ•ª
        int _1310111 = getIntValue(map, "1310111");

        // 1310104 İ‘f
        int _1310104 = getIntValue(map, "1310104");

        // 1310110 ‚ª‚ñ––Šú
        int _1310110 = getIntValue(map, "1310110");

        // 1310105 “Á•Ê–òÜ
        int _1310105 = getIntValue(map, "1310105");

        // 1310112 ŠÅŒìEˆõ‹æ•ª
        int _1310112 = getIntValue(map, "1310112");

        // 16 Šİ’n‹æ•ª
        int _16 = getIntValue(map, "16");

        // “Æ©ƒR[ƒh¶¬
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // Eˆõ‹æ•ª
        sb.append(CODE_CHAR[_1310111]);

        // İ‘f
        sb.append(CODE_CHAR[_1310104]);

        // Šİ’n‹æ•ª
        sb.append(CODE_CHAR[_16]);

        // ‚ª‚ñ––Šú
        sb.append(CODE_CHAR[_1310110]);

        // “Á•Ê–òÜ
        sb.append(CODE_CHAR[_1310105]);

        // ŠÅŒìEˆõ‹æ•ª
        sb.append(CODE_CHAR[_1310112]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ‰ÁZ
        // ============================================================================

        return sysSvcCdItems;
    }
}
