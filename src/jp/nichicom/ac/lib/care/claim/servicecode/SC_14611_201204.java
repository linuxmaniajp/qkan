package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ‰îŒì—\–hx‰‡
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_14611_201204 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "‰îŒì—\–hx‰‡";
    }

    public String getServiceCodeKind() {
        return "46";
    }

    public String getSystemServiceKindDetail() {
        return "14611";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // ƒpƒ‰ƒ[ƒ^’Šo
        // =========================================================================
        // 1460101 ‰‰ñ‰ÁZ@1-‚È‚µ 2-‚ ‚è
        int _1460101 = getIntValue(map, "1460101", 1);

        // 1460104 ‰îŒì—\–h¬‹K–Í‘½‹@”\Œ^<‰üs>‹‘î‰îŒì–‹ÆŠ˜AŒg‰ÁZ
        int _1460104 = getIntValue(map, "1460104", 1);

        // “Æ©ƒR[ƒh¶¬
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // Šî–{ƒT[ƒrƒXƒR[ƒh
        sb.append(DEFAULT_CHAR);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ‰ÁZ
        // ============================================================================
        // ‰‰ñ‰ÁZ
        if (_1460101 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4001");
        }

        // 6131 ‰îŒì—\–hx‰‡¬‹K–Í‘½‹@”\˜AŒg‰ÁZ
        if (_1460104 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6131");
        }

        return sysSvcCdItems;
    }
}
