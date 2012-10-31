package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * “Á’è{İ“ü‹Ò¶Šˆ‰îŒìi’ZŠú—˜—pj
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_12711_201204 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "“Á’è{İ“ü‹Ò¶Šˆ‰îŒì(’ZŠú—˜—p)";
    }

    public String getServiceCodeKind() {
        return "27";
    }

    public String getSystemServiceKindDetail() {
        return "12711";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // ƒpƒ‰ƒ[ƒ^’Šo
        // =========================================================================
        // 1 —v‰îŒì“x
        int _1 = convertYokaigodo(getIntValue(map, "1"));
        
        // 1270101 lˆõŒ¸Z
        int _1270101 = getIntValue(map, "1270101");

        // 1270102 –éŠÔŠÅŒì‘Ì§‰ÁZ
        int _1270102 = getIntValue(map, "1270102");

        // 17 ‰îŒìEˆõˆ‹ö‰ü‘P‰ÁZ
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // “Æ©ƒR[ƒh¶¬
        // =========================================================================
        StringBuilder sb = new StringBuilder();
        
        // —v‰îŒì“x
        sb.append(CODE_CHAR[_1]);

        // lˆõŒ¸Z
        sb.append(CODE_CHAR[_1270101]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ‰ÁZ
        // =========================================================================
        // –éŠÔŠÅŒì‘Ì§‰ÁZ
        if (_1270102 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z1160");
        }

        // ‰îŒìEˆõˆ‹ö‰ü‘P‚ğ•Ô‹p
        switch (_17) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6128");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6129");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6130");
            break;
        }

        return sysSvcCdItems;
    }
}
