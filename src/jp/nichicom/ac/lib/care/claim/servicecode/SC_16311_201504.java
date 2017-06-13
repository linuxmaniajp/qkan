package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ‰îŒì—\–h–K–âŠÅŒì
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_16311_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "‰îŒì—\–h–K–âŠÅŒì";
    }

    public String getServiceCodeKind() {
        return "63";
    }

    public String getSystemServiceKindDetail() {
        return "16311";
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

        // 1630101 {İ“™‚Ì‹æ•ª@1-w’è–K–âŠÅŒìƒXƒe[ƒVƒ‡ƒ“ 2-•a‰@–”‚Íf—ÃŠ
        int _1630101 = getIntValue(map, "1630101", 1);

        // 1630102 Eˆõ‹æ•ª@1-³ŠÅ“™ 2-yŠÅ 3-PTAOTAST
        int _1630102 = getIntValue(map, "1630102", 1);

        // 1630107 ŠÔ‹æ•ª@1-20•ª–¢– 2-30•ª–¢– 3-30•ªˆÈãA1ŠÔ–¢– 4-1ŠÔˆÈãA1ŠÔ”¼–¢–
        int _1630107 = getIntValue(map, "1630107", 1);

        // 1630110 ’·ŠÔ–K–âŠÅŒì‰ÁZ
        int _1630110 = getIntValue(map, "1630110", 1);

        // 1630104 ŠÔ‘Ñ@1-’Êí 2-‘’© 3-–éŠÔ 4-[–é
        // •ÏŠ·¨1-’Êí 2-–éŠÔ‘’© 3-[–é
        int _1630104 = getIntValue(map, "1630104", 1);
        // ƒ}ƒXƒ^‚É‡‚í‚¹A’l‚ğ•ÏŠ·
        switch (_1630104) {
        case 1: // 1-’Êí => 1-’Êí
            _1630104 = 1;
            break;
        case 2: // 2-‘’© => 2-–éŠÔ‘’© 
            _1630104 = 2;
            break;
        case 3: // 3-–éŠÔ => 2-–éŠÔ‘’©
            _1630104 = 2;
            break;
        case 4: // 4-[–é => 3-[–é
            _1630104 = 3;
            break;
        }

        // 1630105 ‹Ù‹}–K–âŠÅŒì‰ÁZ@1-‚È‚µ 2-‚ ‚è
        int _1630105 = getIntValue(map, "1630105", 1);

        // 1630106 “Á•ÊŠÇ—‰ÁZ@1-‚È‚µ 2-‚ ‚è
        int _1630106 = getIntValue(map, "1630106", 1);

        // 2 “Á•Ê’nˆæ‰ÁZ
        int _2 = getIntValue(map, "2");

        // ’†RŠÔ’nˆæ“™‚Å‚ÌƒT[ƒrƒX’ñ‹Ÿ‰ÁZ
        int _12 = getIntValue(map, "12", 1);

        // ’†RŠÔ’nˆæ“™¬‹K–Í–‹ÆŠ‰ÁZ
        int _13 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);

        // 1630108 –K–âÒ‚Ìl”
        int _1630108 = getIntValue(map, "1630108");
        
        // 1630109 ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‹­‰»‰ÁZ
        int _1630109 = getIntValue(map, "1630109");

        // 1630111 2l–Ú‚Ì–K–âŠÔ
        int _1630111 = getIntValue(map, "1630111", 1);
        

        // 1630112 ‰‰ñ‰ÁZ
        int _1630112 = getIntValue(map, "1630112", 1);

        // 1630113 ‘Ş‰@‹¤“¯w“±‰ÁZ
        int _1630113 = getIntValue(map, "1630113", 1);
        
        // 1630116 1“ú‚É2‰ñ‚ğ‰z‚¦‚ÄÀ{
        int _1630116 = getIntValue(map, "1630116", 1);
        
        // ŠÅŒì‘Ì§‹­‰»‰ÁZ
        int _1630117 = getIntValue(map, "1630117", 1);
        
        
        // 16 “¯ˆêŒš•¨‹ZÒ‚Ö‚ÌƒT[ƒrƒX’ñ‹Ÿ
        int _16 = getIntValue(map, "16", 1);
        
        // ‰ÁZ‚Ì‚İ(‘Ş‰@‹¤“¯w“±‰ÁZ‘Î‰)
        int _9 = getIntValue(map,"9");
        
        // ’P“Æ‰ÁZ‚Ì‚İ---------------------------------------------------------------
        // ’P“Æ‰ÁZƒT[ƒrƒX
        if(_9 == 2){
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            // —\–h–K–âŠÅŒì‘Ş‰@‹¤“¯w“±‰ÁZ
            if (_1630113 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z4003");
            }
            
            return sysSvcCdItems;
        }


        // “Æ©ƒR[ƒh¶¬
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // {İ“™‚Ì‹æ•ª@1-w’è–K–âŠÅŒìƒXƒe[ƒVƒ‡ƒ“ 2-•a‰@–”‚Íf—ÃŠ
        sb.append(CODE_CHAR[_1630101]);

        // ŠÔ‹æ•ª@1-20•ª–¢– 2-30•ª–¢– 3-30•ªˆÈãA1ŠÔ–¢– 4-1ŠÔˆÈãA1ŠÔ”¼–¢–
        sb.append(CODE_CHAR[_1630107]);

        // Eˆõ‹æ•ª@1-³ŠÅ“™ 2-yŠÅ 3-PTAOTAST
        sb.append(CODE_CHAR[_1630102]);
        
        // “¯ˆêŒš•¨‹ZÒ‚Ö‚ÌƒT[ƒrƒX’ñ‹Ÿ
        sb.append(CODE_CHAR[_16]);
        
        // ŠÔ‘Ñ@•ÏŠ·¨1-–éŠÔ‘’© 2-[–é 3-’Êí
        sb.append(CODE_CHAR[_1630104]);
        
        // –K–âÒ‚Ìl”
        sb.append(CODE_CHAR[_1630108]);
        
        // 2l–Ú‚Ì–K–âŠÔ
        sb.append(CODE_CHAR[_1630111]);
        
        // 1630110 ’·ŠÔ–K–âŠÅŒì‰ÁZ
        sb.append(CODE_CHAR[_1630110]);
        
        // 1“ú‚É2‰ñ‚ğ‰z‚¦‚ÄÀ{
        sb.append(CODE_CHAR[_1630116]);
        
        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ‰ÁZ
        // ============================================================================

        // “Á•Ê’nˆæ‰ÁZ
        if (_2 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8000");
        }
        
        // 8100 —\–h–K–âŠÅŒì¬‹K–Í–‹ÆŠ‰ÁZ
        if (_13 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8100");
        }
        
        // 8110 —\–h–K–âŠÅŒì’†RŠÔ’nˆæ“™’ñ‹Ÿ‰ÁZ
        if (_12 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
        }
        
        // ‹Ù‹}–K–âŠÅŒì‰ÁZ@1-‚È‚µ 2-‚ ‚è
        if (_1630105 > 1) {
            switch (_1630101) {
            case 1: // w’è–K–âŠÅŒìƒXƒe[ƒVƒ‡ƒ“
                putSystemServiceCodeItem(sysSvcCdItems, "Z3100");
                break;
            case 2: // •a‰@–”‚Íf—ÃŠ
                putSystemServiceCodeItem(sysSvcCdItems, "Z3200");
                break;
            default:
                break;
            }
        }
        
        // “Á•ÊŠÇ—‰ÁZ
        switch(_1630106) {
        case 2:
            // —\–h–K–âŠÅŒì“Á•ÊŠÇ—‰ÁZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z4000");
            break;
        case 3:
            // —\–h–K–âŠÅŒì“Á•ÊŠÇ—‰ÁZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z4001");
            break;
        }

        // ‰‰ñ‰ÁZ
        if (_1630112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4002");
        }

        // —\–h–K–âŠÅŒì‘Ş‰@‹¤“¯w“±‰ÁZ
        if (_1630113 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4003");
        }
        
        // ŠÅŒì‘Ì§‹­‰»‰ÁZ
        if (_1630117 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4005");//TODO:ƒR[ƒh’lŠm”F
        }
        
        // 6101 —\–h–K–âŠÅŒìƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ
        if (_1630109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
        }
        
        
        return sysSvcCdItems;
    }
}
