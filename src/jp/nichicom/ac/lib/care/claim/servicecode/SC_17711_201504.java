package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * •¡‡Œ^ƒT[ƒrƒXiŠÅŒì¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒìE’ZŠú—˜—pˆÈŠOj
 * 
 * @since V7.0.0
 * @author Shinobu Hitaka
 * 
 */
public class SC_17711_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "•¡‡Œ^ƒT[ƒrƒX(ŠÅŒì¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒìE’ZŠú—˜—pˆÈŠO)";
    }

    public String getServiceCodeKind() {
        return "77";
    }

    public String getSystemServiceKindDetail() {
        return "17711";
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

        // 1770101 lˆõŒ¸Z
        int _1770101 = getIntValue(map, "1770101", 1);

        // 1770102 ‰ß¬ƒT[ƒrƒX‚É‘Î‚·‚éŒ¸Z
        int _1770102 = getIntValue(map, "1770102", 1);

        // 1770104 ‰Šú‰ÁZ
        int _1770104 = getIntValue(map, "1770104", 1);

        // 1770105 ”F’mÇ‰ÁZ
        int _1770105 = getIntValue(map, "1770105", 1);

        // 1770106 ‘Ş‰@‹¤“¯w“±‰ÁZ
        int _1770106 = getIntValue(map, "1770106", 1);

        // 1770107 –‹ÆŠJnx‰‡‰ÁZ
        int _1770107 = getIntValue(map, "1770107", 1);

        // 1770108 ‹Ù‹}–K–âŠÅŒì‰ÁZ
        int _1770108 = getIntValue(map, "1770108", 1);

        // 1770109 “Á•ÊŠÇ—‰ÁZ
        int _1770109 = getIntValue(map, "1770109", 1);

        // 1770110 ƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ
        int _1770110 = getIntValue(map, "1770110", 1);

        // 1770111 ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‹­‰»‰ÁZ
        int _1770111 = getIntValue(map, "1770111", 1);

        // 1770112 •¡‡Œ^s’¬‘º“Æ©‰ÁZ
        int _1770112 = getIntValue(map, "1770112", 1);

        // 1770113 –K–âŠÅŒìŒ¸Z 1-‚È‚µ 2-‚ ‚è
        int _1770113 = getIntValue(map, "1770113", 1);

        // 1770114 –K–âŠÅŒì“Á•Êw¦Œ¸Z 1-‚È‚µ 2-‚ ‚è
        int _1770114 = getIntValue(map, "1770114", 1);

        // 1770115 “úŠ„@1-“úŠ„‚Å‚È‚¢ 2-“úŠ„‚Å‚ ‚é
        int _1770115 = getIntValue(map, "1770115", 1);
        
        // 1770118 –K–âŠÅŒì‘Ì§Œ¸Z 1-‚È‚µ 2-‚ ‚è 2015.04
        int _1770118 = getIntValue(map, "1770118", 1);
        
        // 1770119 –K–âŠÅŒì‘Ì§‹­‰»‰ÁZ 1-‚È‚µ 2-‚ ‚è 2015.04
        int _1770119 = getIntValue(map, "1770119", 1);

        // 1770120 ‘‡ƒ}ƒlƒWƒƒ“ƒg‘Ì§‹­‰»‰ÁZ 1-‚È‚µ 2-‚ ‚è 2015.04
        int _1770120 = getIntValue(map, "1770120", 1);
        
        // 16 “¯ˆê‚ÌŒš•¨‚É‹Z‚·‚é—˜—pÒ 1-‚È‚µ 2-‚ ‚è 2015.04
        int _16 = getIntValue(map, "16", 1);

        // 17 ‰îŒìEˆõˆ‹ö‰ü‘P‰ÁZ
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // ‰ÁZ‚Ì‚İ(‘Ş‰@‹¤“¯w“±‰ÁZ‘Î‰)
        int _9 = getIntValue(map, "9");

        // ’P“Æ‰ÁZ‚Ì‚İ---------------------------------------------------------------
        // ’P“Æ‰ÁZƒT[ƒrƒX
        if (_9 == 2) {
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            // 1770104 ‰Šú‰ÁZ
            if (_1770104 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6300");
            }

            // –K–âŠÅŒì“Á•Êw¦Œ¸Z 1-‚È‚µ 2-‚ ‚è
            if (_1770114 > 1) {
                // —v‰îŒì“x‚ğŠm”F
                switch (_1) {
                case 5: // —v‰îŒì‚P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6011");
                    break;
                case 6: // —v‰îŒì‚Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6012");
                    break;
                case 7: // —v‰îŒì‚R
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6013");
                    break;
                case 8: // —v‰îŒì‚S
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6014");
                    break;
                case 9: // —v‰îŒì‚T
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6015");
                    break;
                }
            }

            // 1770106 ‘Ş‰@‹¤“¯w“±‰ÁZ
            if (_1770106 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z4003");
            }

            // 1770110 ƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ
            if (_1770110 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6100");
            }

            // ‰îŒìEˆõˆ‹ö‰ü‘P‚ğ•Ô‹p
            switch (_17) {
            case 6:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6114");//2017.04
                break;
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6112");
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
                break;
            }

            return sysSvcCdItems;
        }

        // “Æ©ƒR[ƒh¶¬
        // =========================================================================
        StringBuilder sb = new StringBuilder();

        // “¯ˆê‚ÌŒš•¨‚É‹Z‚·‚é—˜—pÒ 
        sb.append(CODE_CHAR[_16]);        //2015.04

        // —v‰îŒì“x
        sb.append(CODE_CHAR[_1]);
        
        // ‰ß¬ƒT[ƒrƒX‚É‘Î‚·‚éŒ¸Z
        sb.append(CODE_CHAR[_1770102]);

        // lˆõŒ¸Z
        sb.append(CODE_CHAR[_1770101]);

        // “úŠ„‚è
        sb.append(CODE_CHAR[_1770115]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());
        

        // ‰ÁZ
        // =========================================================================

        // –K–âŠÅŒì“Á•Êw¦Œ¸Z 1-‚È‚µ 2-‚ ‚è
        if (_1770114 > 1) {
            // —v‰îŒì“x‚ğŠm”F
            switch (_1) {
            case 5: // —v‰îŒì‚P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6011");
                break;
            case 6: // —v‰îŒì‚Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6012");
                break;
            case 7: // —v‰îŒì‚R
                putSystemServiceCodeItem(sysSvcCdItems, "Z6013");
                break;
            case 8: // —v‰îŒì‚S
                putSystemServiceCodeItem(sysSvcCdItems, "Z6014");
                break;
            case 9: // —v‰îŒì‚T
                putSystemServiceCodeItem(sysSvcCdItems, "Z6015");
                break;
            }
        }

        // 1770104 ‰Šú‰ÁZ
        if (_1770104 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6300");
        }

        // 1770105 ”F’mÇ‰ÁZ
        switch (_1770105) {
        // •¡‡Œ^”F’mÇ‰ÁZI
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6128");
            break;
        // •¡‡Œ^”F’mÇ‰ÁZII
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6129");
            break;

        }

        // 1770106 ‘Ş‰@‹¤“¯w“±‰ÁZ
        if (_1770106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4003");
        }

        // 1770107 –‹ÆŠJnx‰‡‰ÁZ
        if (_1770107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6139");
        }

        // 1770108 ‹Ù‹}–K–âŠÅŒì‰ÁZ
        if (_1770108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3100");
        }

        // 1770109 “Á•ÊŠÇ—‰ÁZ
        switch (_1770109) {
        case 2:
            // •¡‡Œ^“Á•ÊŠÇ—‰ÁZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z4000");
            break;
        case 3:
            // •¡‡Œ^“Á•ÊŠÇ—‰ÁZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z4001");
            break;

        }

        // 1770110 ƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ
        if (_1770110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");
        }

        // 1770111 ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‹­‰»‰ÁZ
        switch (_1770111) {
        case 5:
            // ’ñ‹Ÿ‘Ì§‰ÁZIƒC
            putSystemServiceCodeItem(sysSvcCdItems, "Z6111");//2015.04
            break;
        case 2:
            // ’ñ‹Ÿ‘Ì§‰ÁZIƒ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // ’ñ‹Ÿ‘Ì§‰ÁZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
            // ’ñ‹Ÿ‘Ì§‰ÁZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }

        // 1770119 –K–âŠÅŒì‘Ì§‹­‰»‰ÁZ 2015.04
        if (_1770119 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4015");//2015.04
        }

        // 1770120 ‘‡ƒ}ƒlƒWƒƒ“ƒg‘Ì§‹­‰»‰ÁZ 2015.04
        if (_1770120 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4010");//2015.04
        }
        
        // ‰îŒìEˆõˆ‹ö‰ü‘P‚ğ•Ô‹p
        switch (_17) {
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6114");//2017.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6112");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
            break;
        }

        // “úŠ„‚è‚Å‚Í‚È‚¢ê‡
        if (_1770115 == 1) {
            // –K–âŠÅŒì‘Ì§Œ¸Z 2015.04
            if (_1770118 > 1) {
                // —v‰îŒì“x‚ğŠm”F
                switch (_1) {
                case 5: // —v‰îŒì‚P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6021");//2015.04
                    break;
                case 6: // —v‰îŒì‚Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6023");//2015.04
                    break;
                case 7: // —v‰îŒì‚R
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6025");//2015.04
                    break;
                case 8: // —v‰îŒì‚S
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6027");//2015.04
                    break;
                case 9: // —v‰îŒì‚T
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6029");//2015.04
                    break;
                }
            }
            
            // –K–âŠÅŒìŒ¸Z
            if (_1770113 > 1) {
                // —v‰îŒì“x‚ğŠm”F
                switch (_1) {
                case 5: // —v‰îŒì‚P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6001");
                    break;
                case 6: // —v‰îŒì‚Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6003");
                    break;
                case 7: // —v‰îŒì‚R
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6005");
                    break;
                case 8: // —v‰îŒì‚S
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6007");
                    break;
                case 9: // —v‰îŒì‚T
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6009");
                    break;
                }
            }

            // •¡‡Œ^s’¬‘º“Æ©‰ÁZ
            switch (_1770112) {
            case 2:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P
                putSystemServiceCodeItem(sysSvcCdItems, "Z7101");
                break;
            case 3:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z7103");
                break;
            case 4:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚R
                putSystemServiceCodeItem(sysSvcCdItems, "Z7105");
                break;
            case 5:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚S
                putSystemServiceCodeItem(sysSvcCdItems, "Z7107");
                break;
            case 6:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚T
                putSystemServiceCodeItem(sysSvcCdItems, "Z7109");
                break;
            case 7:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚U
                putSystemServiceCodeItem(sysSvcCdItems, "Z7111");
                break;
            case 8:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚V
                putSystemServiceCodeItem(sysSvcCdItems, "Z7113");
                break;
            case 9:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚W
                putSystemServiceCodeItem(sysSvcCdItems, "Z7115");
                break;
            case 10:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚X
                putSystemServiceCodeItem(sysSvcCdItems, "Z7117");
                break;
            case 11:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚O
                putSystemServiceCodeItem(sysSvcCdItems, "Z7119");
                break;
            case 12:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚P
                putSystemServiceCodeItem(sysSvcCdItems, "Z7121");
                break;
            case 13:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z7123");
                break;
            case 14:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚R
                putSystemServiceCodeItem(sysSvcCdItems, "Z7125");
                break;
            case 15:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚S
                putSystemServiceCodeItem(sysSvcCdItems, "Z7127");
                break;
            case 16:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚T
                putSystemServiceCodeItem(sysSvcCdItems, "Z7129");
                break;
            case 17:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚U
                putSystemServiceCodeItem(sysSvcCdItems, "Z7131");
                break;
            case 18:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚V
                putSystemServiceCodeItem(sysSvcCdItems, "Z7133");
                break;
            case 19:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚W
                putSystemServiceCodeItem(sysSvcCdItems, "Z7135");
                break;
            case 20:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚X
                putSystemServiceCodeItem(sysSvcCdItems, "Z7137");
                break;
            case 21:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚Q‚O
                putSystemServiceCodeItem(sysSvcCdItems, "Z7139");
                break;
            }

            // “úŠ„‚è‚Ìê‡
        } else {
            // –K–âŠÅŒì‘Ì§Œ¸Z“úŠ„ 2015.04
            if (_1770118 > 1) {
                // —v‰îŒì“x‚ğŠm”F
                switch (_1) {
                case 5: // —v‰îŒì‚P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6022");//2015.04
                    break;
                case 6: // —v‰îŒì‚Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6024");//2015.04
                    break;
                case 7: // —v‰îŒì‚R
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6026");//2015.04
                    break;
                case 8: // —v‰îŒì‚S
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6028");//2015.04
                    break;
                case 9: // —v‰îŒì‚T
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6030");//2015.04
                    break;
                }
            }
            
            // –K–âŠÅŒìŒ¸Z“úŠ„
            if (_1770113 > 1) {
                // —v‰îŒì“x‚ğŠm”F
                switch (_1) {
                case 5: // —v‰îŒì‚P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6002");
                    break;
                case 6: // —v‰îŒì‚Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6004");
                    break;
                case 7: // —v‰îŒì‚R
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6006");
                    break;
                case 8: // —v‰îŒì‚S
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6008");
                    break;
                case 9: // —v‰îŒì‚T
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6010");
                    break;
                }
            }

            // •¡‡Œ^s’¬‘º“Æ©‰ÁZ
            switch (_1770112) {
            case 2:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7102");
                break;
            case 3:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚Q“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7104");
                break;
            case 4:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚R“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7106");
                break;
            case 5:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚S“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7108");
                break;
            case 6:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚T“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7110");
                break;
            case 7:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚U“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7112");
                break;
            case 8:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚V“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7114");
                break;
            case 9:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚W“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7116");
                break;
            case 10:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚X“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7118");
                break;
            case 11:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚O“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7120");
                break;
            case 12:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚P“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7122");
                break;
            case 13:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚Q“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7124");
                break;
            case 14:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚R“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7126");
                break;
            case 15:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚S“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7128");
                break;
            case 16:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚T“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7130");
                break;
            case 17:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚U“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7132");
                break;
            case 18:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚V“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7134");
                break;
            case 19:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚W“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7136");
                break;
            case 20:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚X“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7138");
                break;
            case 21:
                // •¡‡Œ^s’¬‘º“Æ©‰ÁZ‚Q‚O“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7140");
                break;
            }

        }

        return sysSvcCdItems;
    }
}
