package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ‹‘î‰îŒìx‰‡
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_14311_201204 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "‹‘î‰îŒìx‰‡";
    }

    public String getServiceCodeKind() {
        return "43";
    }

    public String getSystemServiceKindDetail() {
        return "14311 ";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // ƒpƒ‰ƒ[ƒ^’Šo
        // =========================================================================
        // 1430103 ‹æ•ª
        int _1430103 = getIntValue(map, "1430103");

        // 1 —v‰îŒì“x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1430101 ‰^‰cŠî€Œ¸Z
        int _1430101 = getIntValue(map, "1430101", 1);

        // 2 “Á•Ê’nˆæ‰ÁZ
        int _2 = getIntValue(map, "2", 1);

        // 13 ’†RŠÔ’nˆæ“™‚É‚¨‚¯‚é¬‹K–Í–‹ÆŠ
        int _13 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);

        // 1430104 “Á’è–‹ÆŠW’†Œ¸Z
        int _1430104 = getIntValue(map, "1430104", 1);

        // 1430108 ‰‰ñ‰ÁZ
        int _1430108 = getIntValue(map, "1430108", 1);

        // 1430113 ‘Ş‰@E‘ŞŠ‰ÁZ
        int _1430113 = getIntValue(map, "1430113", 1);

        // 1430106 “Á’è–‹ÆŠ‰ÁZ
        int _1430106 = getIntValue(map, "1430106", 1);

        // 1430110 ”F’mÇ‰ÁZ
        int _1430110 = getIntValue(map, "1430110", 1);

        // 1430111 “Æ‹‚—îÒ‰ÁZ
        int _1430111 = getIntValue(map, "1430111", 1);

        // 1430112 ¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì–‹ÆŠ˜AŒg‰ÁZ
        int _1430112 = getIntValue(map, "1430112", 1);

        // 12 ’†RŠÔ’nˆæ“™‚Å‚ÌƒT[ƒrƒX’ñ‹Ÿ‰ÁZ
        int _12 = getIntValue(map, "12", 1);

        // 1430114 İ‘îŠ³Ò‹Ù‹}ƒJƒ“ƒtƒ@ƒŒƒ“ƒX‰ÁZ
        int _1430114 = getIntValue(map, "1430114", 1);
        
        // 1430115 “ü‰@î•ñ˜AŒg‰ÁZ
        int _1430115 = getIntValue(map, "1430115", 1);
        
        // 1430116 •¡‡Œ^ƒT[ƒrƒX–‹ÆŠ˜AŒg‰ÁZ
        int _1430116 = getIntValue(map, "1430116", 1);
        
        // [ID:0000702][Masahiko.Higuchi] 2012/03 •½¬24”N4Œ–@‰ü³‘Î‰ add begin
        // ’P“Æ‰ÁZ
        int _9 = getIntValue(map, "9");

        // ’P“Æ‰ÁZ‚Ì‚İ---------------------------------------------------------------
        // ’P“Æ‰ÁZƒT[ƒrƒX
        if (_9 == 2) {
            // ‹‘îx‰‡‘Ş‰@‘ŞŠ‰ÁZ
            if (_1430113 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6132");
            }
            
            // İ‘îŠ³Ò‹Ù‹}ƒJƒ“ƒtƒ@ƒŒƒ“ƒX‰ÁZ
            if (_1430114 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6133");
            }
            
            return sysSvcCdItems;
        }
        // [ID:0000702][Masahiko.Higuchi] 2012/03 add end
        
        // “Æ©ƒR[ƒh¶¬
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // ‹æ•ª
        sb.append(CODE_CHAR[_1430103]);

        // —v‰îŒì“x
        sb.append(CODE_CHAR[_1]);

        // ‰^‰cŠî€Œ¸Z
        sb.append(CODE_CHAR[_1430101]);

        // 1-‚È‚µ 2-“Á•Ê’nˆæ‰ÁZ 3-’†RŠÔ’nˆæ“™‚Ì¬‹K–Í–‹ÆŠ
        // “Á•Ê’nˆæ‰ÁZƒ`ƒFƒbƒN
        if (_2 > 1) {
            // “Á•Ê’nˆæ‰ÁZ
            sb.append(CODE_CHAR[2]);
            
        } else if (_13 > 1) {
            // ’†RŠÔ’nˆæ“™‚Ì¬‹K–Í–‹ÆŠ
            sb.append(CODE_CHAR[3]);
            
        } else {
            sb.append(DEFAULT_CHAR);
            
        }

        // 12 ’†RŠÔ’nˆæ“™‚Å‚ÌƒT[ƒrƒX’ñ‹Ÿ‰ÁZ
        sb.append(CODE_CHAR[_12]);

        // “Á’è–‹ÆŠW’†Œ¸Z
        sb.append(CODE_CHAR[_1430104]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ‰ÁZ
        // ============================================================================
        switch (_1430108) {
        case 2:
            // ‹‘îx‰‡‰‰ñ‰ÁZ
            putSystemServiceCodeItem(sysSvcCdItems, "Z4001");
            break;
        }
        
        switch (_1430106) {
        case 2:
            // ‹‘îx‰‡“Á’è–‹ÆŠ‰ÁZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z4002");
            break;
        case 3:
            // ‹‘îx‰‡“Á’è–‹ÆŠ‰ÁZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z4003");
            break;
        }
        
        // “ü‰@î•ñ˜AŒg‰ÁZ
        switch(_1430115) {
        case 2: // IŒ^
            putSystemServiceCodeItem(sysSvcCdItems, "Z6125");
            break;
        case 3: // IIŒ^
            putSystemServiceCodeItem(sysSvcCdItems, "Z6129");
            break;
        }
        
        // ‹‘îx‰‡‘Ş‰@‘ŞŠ‰ÁZ
        if (_1430113 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6132");
        }
        
        // ‹‘îx‰‡”F’mÇ‰ÁZ
        if (_1430110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6128");
        }
        
        // ‹‘îx‰‡“Æ‹‚—îÒ‰ÁZ
        if (_1430111 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6130");
        }
        
        // ‹‘îx‰‡¬‹K–Í‘½‹@”\Œ^˜AŒg‰ÁZ
        if (_1430112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6131");
        }
        
        // •¡‡Œ^ƒT[ƒrƒX–‹ÆŠ˜AŒg‰ÁZ
        if (_1430116 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6134");
        }
        
        // İ‘îŠ³Ò‹Ù‹}ƒJƒ“ƒtƒ@ƒŒƒ“ƒX‰ÁZ
        if (_1430114 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6133");
        }

        return sysSvcCdItems;
    }
}
