package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ’nˆæ–§’…Œ^“Á’è{İ“ü‹Ò¶Šˆ‰îŒì
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_13611_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "’nˆæ–§’…Œ^“Á’è{İ“ü‹Ò¶Šˆ‰îŒì";
    }

    public String getServiceCodeKind() {
        return "36";
    }

    public String getSystemServiceKindDetail() {
        return "13611";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // ƒpƒ‰ƒ[ƒ^’Šo
        // =========================================================================
        // 1 —v‰îŒì“x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1360102 ŒÂ•Ê‹@”\ŒP—ûw“±‰ÁZ 1-‚È‚µ 2-‚ ‚è
        int _1360102 = getIntValue(map, "1360102");

        // 1360101 lˆõŒ¸Z 1-‚È‚µ 2-ŠÅŒìE‰îŒìEˆõ•s‘«
        int _1360101 = getIntValue(map, "1360101");

        // 1360103 –éŠÔŠÅŒì‘Ì§‰ÁZ 1-‚È‚µ 2-‚ ‚è
        int _1360103 = getIntValue(map, "1360103");

        // 1360104 ˆã—Ã‹@ŠÖ˜AŒg‰ÁZ
        int _1360104 = getIntValue(map, "1360104");

        // 1360106 ŠÅæ‚è‰îŒì‰ÁZ
        int _1360106 = getIntValue(map, "1360106");

        // 1360107 ”F’mÇê–åƒPƒA‰ÁZ
        int _1360107 = getIntValue(map, "1360107", 1);
        
        // 1360108 ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‹­‰»‰ÁZ
        int _1360108 = getIntValue(map, "1360108", 1);

        // 17 ‰îŒìEˆõˆ‹ö‰ü‘P‰ÁZ
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // “Æ©ƒR[ƒh¶¬
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // —v‰îŒì“x
        sb.append(CODE_CHAR[_1]);

        // lˆõŒ¸Z 1-‚È‚µ 2-ŠÅŒìE‰îŒìEˆõ•s‘«
        sb.append(CODE_CHAR[_1360101]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ‰ÁZ
        // ============================================================================
        // Z6003 ’nˆæ“Á’è{İŒÂ•Ê‹@”\ŒP—û‰ÁZ
        if (_1360102 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6003");
        }
        
        // Z6123 ’nˆæ“Á’è{İˆã—Ã‹@ŠÖ˜AŒg‰ÁZ
        if (_1360104 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6123");
        }
        
        // –éŠÔŠÅŒì‘Ì§‰ÁZ 1-‚È‚µ 2-‚ ‚è
        if (_1360103 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2000");
        }
        
        // 1360106 ŠÅæ‚è‰îŒì‰ÁZ
        switch(_1360106) {
        case 2:
            // ’nˆæ“Á’è{İŠÅæ‚è‰îŒì‰ÁZ‚P
            putSystemServiceCodeItem(sysSvcCdItems, "Z6125");
            break;
        case 3:
            // ’nˆæ“Á’è{İŠÅæ‚è‰îŒì‰ÁZ‚Q
            putSystemServiceCodeItem(sysSvcCdItems, "Z6126");
            break;
        case 4:
            // ’nˆæ“Á’è{İŠÅæ‚è‰îŒì‰ÁZ‚R
            putSystemServiceCodeItem(sysSvcCdItems, "Z6127");
            break;
        }
        
        // 1360107 ”F’mÇê–åƒPƒA‰ÁZ
        switch (_1360107) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6133");//2015.04
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6134");//2015.04
            break;
        }
        
        // 1360108 ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ
        switch (_1360108) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");//2015.04
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");//2015.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");//2015.04
            break;
        }
        
        // ‰îŒìEˆõˆ‹ö‰ü‘P‚ğ•Ô‹p
        switch (_17) {
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6132");//2017.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6131");//2015.04
            break;
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
