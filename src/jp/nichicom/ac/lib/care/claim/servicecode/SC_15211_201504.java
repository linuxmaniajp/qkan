package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * ‰îŒì•ÛŒ’{İ
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_15211_201504 extends Qkan10011_ServiceUnitGetter {
    private int _1520122 = 0;

    private final String PATH_UNIT_ROOM = "1520114";
    private final String PATH_UNIT_SEMI_ROOM = "1520115";
    private final String PATH_NORMAL_ROOM = "1520116";
    private final String PATH_TASHO_ROOM = "1520117";

    public String getServiceName() {
        return "‰îŒì•ÛŒ’{İ";
    }

    public String getServiceCodeKind() {
        return "52";
    }

    public String getSystemServiceKindDetail() {
        return "15211";
    }

    private boolean isRyoyoType(int _1520101) {
        boolean ret = true;
        switch (_1520101) {
        case 1: // ‰îŒì˜Vl•ÛŒ’{İiIj
        case 2: // ƒ†ƒjƒbƒgŒ^‰îŒì˜Vl•ÛŒ’{İiIj
            ret = false;
            break;
        }
        return ret;
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // ƒpƒ‰ƒ[ƒ^’Šo
        // =========================================================================
        // 1520101 {İ‹æ•ª
        int _1520101 = getIntValue(map, "1520101");

        // 1520102 •aº‹æ•ª(]—ˆŒ^)
        int _1520102 = getIntValue(map, "1520102");

        // 1520103 •aº‹æ•ª(ƒ†ƒjƒbƒgŒ^)
        int _1520103 = getIntValue(map, "1520103");

        // •aº‹æ•ª
        int byoshitsu = 1;
        switch (_1520101) {
        case 1:
        case 3:
        case 5:
            byoshitsu = convertByoshitsuKbn(_1520102, false);
            break;
        case 2:
        case 4:
        case 6:
            byoshitsu = convertByoshitsuKbn(_1520103, true);
            break;
        }

        // 1 —v‰îŒì“x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // Œo‰ß‘[’u‘Î‰—p‚É—vx‰‡‚P‚Ü‚½‚Í—vx‰‡‚Q‚¾‚Á‚½ê‡‚Í—v‰îŒì‚P‚Æ‚İ‚È‚·
        if (_1 == 3 || _1 == 4) {
            _1 = 5;
        }

        // 1520104 –éŠÔ‹Î–±ğŒŠî€
        int _1520104 = getIntValue(map, "1520104");

        // 1520119 lˆõŒ¸Z
        int _1520119 = getIntValue(map, "1520119");

        // 1520127 ƒ†ƒjƒbƒgƒPƒA‚Ì®”õ
        int _1520127 = getIntValue(map, "1520127");

        // 1520124 ’ZŠúW’†ƒŠƒnƒrƒŠƒe[ƒVƒ‡ƒ“‰ÁZ
        int _1520124 = getIntValue(map, "1520124");

        // 1520125 ”F’mÇ‚—îÒ
        int _1520125 = getIntValue(map, "1520125");

        // 1520128 ˆÓv‘a’Ê¢“ï“™ƒPƒA‰ÁZ
        int _1520128 = getIntValue(map, "1520128");

        // 1520130 g‘ÌS‘©”p~–¢À{Œ¸Z
        int _1520130 = getIntValue(map, "1520130");

        // 1520107 ŠO”‘‰ÁZ
        int _1520107 = getIntValue(map, "1520107");

        // 1520108 ‰Šú‰ÁZ
        int _1520108 = getIntValue(map, "1520108");

        // 3020105 ‘ŞŠw“±‰ÁZ
        int _3020105 = getIntValue(map, "3020105");

        // 3020106 ‘ŞŠî•ñ’ñ‹Ÿ‰ÁZ
        int _3020106 = getIntValue(map, "3020106");

        // 3020107 ‘ŞŠ‘O˜AŒg‰ÁZ
        int _3020107 = getIntValue(map, "3020107");

        // 3020108 ˜Vl–K–âŠÅŒìw¦‰ÁZ
        int _3020108 = getIntValue(map, "3020108");

        // 1520111 ‰h—{ƒ}ƒlƒWƒƒ“ƒg‰ÁZ
        int _1520111 = getIntValue(map, "1520111");

        // 1520112 ŒoŒûˆÚs‰ÁZ
        int _1520112 = getIntValue(map, "1520112");

        // 1520126 ŒoŒûˆÛ‰ÁZI
        int _1520126 = getIntValue(map, "1520126");
        
        // 1520151 ŒoŒûˆÛ‰ÁZII
        int _1520151 = getIntValue(map, "1520151");

        // 1520134 —Ã—{‘Ì§ˆÛ“Á•Ê‰ÁZ
        int _1520134 = getIntValue(map, "1520134");

        // 1520113 —Ã—{H‰ÁZ
        int _1520113 = getIntValue(map, "1520113");

        // 1520133 ƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ
        int _1520141 = getIntValue(map, "1520141");

        // 1520109 ‹Ù‹}¡—ÃŠÇ—‰ÁZ
        int _1520109 = getIntValue(map, "1520109");

        // 1520120 H–’ñ‹Ÿ
        int _1520120 = getIntValue(map, "1520120");

        // 1520122 H”ï
        this._1520122 = getIntValue(map, "1520122");

        // 1520135 Œûo‹@”\ˆÛŠÇ—‰ÁZ
        int _1520135 = getIntValue(map, "1520135");

        // 1520136 –é‹ÎEˆõ”z’u‰ÁZ
        int _1520136 = getIntValue(map, "1520136");

        // 1520137 ”F’mÇê–åƒPƒA‰ÁZ
        int _1520137 = getIntValue(map, "1520137");

        // 1520138 á”N«”F’mÇ“üŠÒó“ü‰ÁZ
        int _1520138 = getIntValue(map, "1520138");

        // 1520139 ”F’mÇî•ñ’ñ‹Ÿ‰ÁZ
        int _1520139 = getIntValue(map, "1520139");

        // 1520142 ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‹­‰»‰ÁZ
        int _1520142 = getIntValue(map, "1520142");

        // ’P“Æ‰ÁZ
        int _9 = getIntValue(map, "9");

        // 1520143 lˆõ”z’u‹æ•ª
        int _1520143 = getIntValue(map, "1520143", 1);

        // 3020109 ‘ŞŠ(‰@)‘O–K–âw“±‰ÁZ
        int _3020109 = getIntValue(map, "3020109", 1);

        // 3020110 ‘ŞŠ(‰@)Œã–K–âw“±‰ÁZ
        int _3020110 = getIntValue(map, "3020110", 1);

        // 1520146 ”F’mÇs“®ES—Çó‹Ù‹}‘Î‰‰ÁZ
        int _1520146 = getIntValue(map, "1520146", 1);

        // 1520144 “üŠ‘OŒã–K–âw“±‰ÁZ
        int _1520144 = getIntValue(map, "1520144", 1);

        // 1520145 Š’è¾Š³{İ—Ã—{”ï
        int _1520145 = getIntValue(map, "1520145", 1);

        // 1520147 ’nˆæ˜AŒgf—ÃŒv‰æî•ñ’ñ‹Ÿ‰ÁZ
        int _1520147 = getIntValue(map, "1520147", 1);

        // 1520149 lˆõ”z’u‹æ•ªi—Ã—{Œ^j
        int _1520149 = getIntValue(map, "1520149", 1);

        // 1520140 İ‘î•œ‹Aİ‘î—Ã—{x‰‡‰ÁZ
        int _1520140 = getIntValue(map, "1520140", 1);

        // 1510145 Œûo‹@”\ˆÛŠÇ—‘Ì§‰ÁZ
        int _1510145 = getIntValue(map, "1510145", 1);

        // 1520148 İ‘î•œ‹Ax‰‡‹@”\‰ÁZ
        int _1520148 = getIntValue(map, "1520148", 1);

        // 17 ‰îŒìEˆõˆ‹ö‰ü‘P‰ÁZ
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // ’P“Æ‰ÁZ‚Ì‚İ---------------------------------------------------------------
        // ’P“Æ‰ÁZƒT[ƒrƒX
        if (_9 == 2) {

            // ‘ŞŠŒã–K–âw“±‰ÁZ
            if (_3020110 > 1) {

                // —Ã—{Œ^ˆÈŠO‚Ìê‡‚ÍA]—ˆŒ^/İ‘î‹­‰»Œ^‚ğƒ`ƒFƒbƒN
                if (!isRyoyoType(_1520101)) {
                    // İ‘î‹­‰»Œ^
                    if (_1520143 == 2) {
                        // •ÛŒ’{İ‘ŞŠŒã–K–âw“±‰ÁZ‚P
                        putSystemServiceCodeItem(sysSvcCdItems, "Z6507");

                        // İ‘î‹­‰»Œ^ˆÈŠO
                    } else {
                        // •ÛŒ’{İ‘ŞŠŒã–K–âw“±‰ÁZ‚Q
                        putSystemServiceCodeItem(sysSvcCdItems, "Z6508");
                    }

                    // —Ã—{Œ^‚Ìê‡‚ÍA—Ã—{Œ^/—Ã—{‹­‰»Œ^‚ğƒ`ƒFƒbƒN
                } else {
                    // —Ã—{‹­‰»Œ^
                    if (_1520149 == 2) {
                        // •ÛŒ’{İ‘ŞŠŒã–K–âw“±‰ÁZ‚P
                        putSystemServiceCodeItem(sysSvcCdItems, "Z6507");

                        // —Ã—{‹­‰»Œ^ˆÈŠO
                    } else {
                        // •ÛŒ’{İ‘ŞŠŒã–K–âw“±‰ÁZ‚Q
                        putSystemServiceCodeItem(sysSvcCdItems, "Z6508");
                    }
                }
            }

            // ƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ
            switch (_1520141) {
            // €–S“úˆÈ‘O4“úˆÈã30“úˆÈ‰º
            case 2:
                // —Ã—{Œ^ˆÈŠO
                if (!isRyoyoType(_1520101)) {
                    // •ÛŒ’{İƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ‚P‚P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6600");

                    // —Ã—{Œ^
                } else {
                    // •ÛŒ’{İƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ‚P‚Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6001");
                }
                break;

            // €–S“úˆÈ‘O2“ú–”‚Í3“ú
            case 3:
                // —Ã—{Œ^ˆÈŠO
                if (!isRyoyoType(_1520101)) {
                    // •ÛŒ’{İƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ‚Q‚P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6602");

                    // —Ã—{Œ^
                } else {
                    // •ÛŒ’{İƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ‚Q‚Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6002");
                }
                break;

            // €–S“ú
            case 4:
                // —Ã—{Œ^ˆÈŠO
                if (!isRyoyoType(_1520101)) {
                    // •ÛŒ’{İƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ‚R‚P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6603");

                    // —Ã—{Œ^
                } else {
                    // •ÛŒ’{İƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ‚R‚Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6003");
                }
                break;
            }

            // ‰îŒìEˆõˆ‹ö‰ü‘P‚ğ•Ô‹p
            switch (_17) {
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2015.04
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                break;
            }

            return sysSvcCdItems;
        }

        // “Æ©ƒR[ƒh¶¬
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // {İ‹æ•ª
        sb.append(CODE_CHAR[_1520101]);

        // •aº‹æ•ª(]—ˆŒ^ŒÂº/‘½°º)
        sb.append(CODE_CHAR[_1520102]);

        // •aº‹æ•ª(ƒ†ƒjƒbƒgŒ^ŒÂº/ƒ†ƒjƒbƒgŒ^€ŒÂº)
        sb.append(CODE_CHAR[_1520103]);

        // lˆõ”z’u‹æ•ª(]—ˆŒ^/İ‘î‹­‰»Œ^)
        sb.append(CODE_CHAR[_1520143]);

        // lˆõ”z’u‹æ•ª(—Ã—{Œ^/—Ã—{‹­‰»Œ^)
        sb.append(CODE_CHAR[_1520149]);

        // —v‰îŒì“x
        sb.append(CODE_CHAR[_1]);

        // –éŠÔ‹Î–±ğŒŠî€
        sb.append(CODE_CHAR[_1520104]);

        // lˆõŒ¸Z
        sb.append(CODE_CHAR[_1520119]);

        // ƒ†ƒjƒbƒgƒPƒA‚Ì®”õ
        switch (_1520101) {
        case 1: // ŒÂºE‘½°º
        case 3:
        case 5:
            sb.append(DEFAULT_CHAR);
            break;
        case 2: // ƒ†ƒjƒbƒgŒ^
        case 4:
        case 6:
            // 1-–¢®”õ 2-®”õ
            if (_1520127 > 1) {
                sb.append(DEFAULT_CHAR);
            } else {
                sb.append(CODE_CHAR[2]);
            }
            break;
        }

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ‰ÁZ
        // ============================================================================

        // Z6117 •ÛŒ’{İ–é‹ÎEˆõ”z’u‰ÁZ
        if (_1520136 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6117");
        }

        // ’ZŠúW’†ƒŠƒnƒrƒŠƒe[ƒVƒ‡ƒ“‰ÁZ
        if (_1520124 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6252");
        }

        // ”F’mÇ‚—îÒ(”F’mÇ’ZŠúW’†ƒŠƒn‰ÁZ)
        if (_1520125 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6253");
        }

        // ”F’mÇƒPƒA‰ÁZ
        if (_1520128 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6254");
        }

        // Z6109 •ÛŒ’{İá”N«”F’mÇó“ü‰ÁZ
        if (_1520138 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }

        // İ‘î•œ‹Aİ‘î—Ã—{x‰‡‰ÁZ
        if (_1520140 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6110");
        }

        // g‘ÌS‘©”p~–¢À{Œ¸Z
        if (_1520130 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6304");
        }

        // ŠO”‘‰ÁZ
        if (_1520107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6300");
        }

        // ƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ
        switch (_1520141) {
        // €–S“úˆÈ‘O4“úˆÈã30“úˆÈ‰º
        case 2:
            // —Ã—{Œ^ˆÈŠO
            if (!isRyoyoType(_1520101)) {
                // •ÛŒ’{İƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ‚P‚P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6600");

                // —Ã—{Œ^
            } else {
                // •ÛŒ’{İƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ‚P‚Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6001");
            }
            break;

        // €–S“úˆÈ‘O2“ú–”‚Í3“ú
        case 3:
            // —Ã—{Œ^ˆÈŠO
            if (!isRyoyoType(_1520101)) {
                // •ÛŒ’{İƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ‚Q‚P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6602");

                // —Ã—{Œ^
            } else {
                // •ÛŒ’{İƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ‚Q‚Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6002");
            }
            break;

        // €–S“ú
        case 4:
            // —Ã—{Œ^ˆÈŠO
            if (!isRyoyoType(_1520101)) {
                // •ÛŒ’{İƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ‚R‚P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6603");

                // —Ã—{Œ^
            } else {
                // •ÛŒ’{İƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ‚R‚Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6003");
            }
            break;
        }

        // —Ã—{‘Ì§ˆÛ“Á•Ê‰ÁZ
        if (_1520134 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6601");
        }

        // ‰Šú‰ÁZ
        if (_1520108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6400");
        }

        // “üŠ‘OŒã–K–âw“±‰ÁZ
        switch(_1520144) {
        case 2:
            // —Ã—{Œ^ˆÈŠO‚Ìê‡‚ÍA]—ˆŒ^/İ‘î‹­‰»Œ^‚ğƒ`ƒFƒbƒN
            if (!isRyoyoType(_1520101)) {
                // İ‘î‹­‰»Œ^
                if (_1520143 == 2) {
                    // •ÛŒ’{İ“üŠ‘OŒã–K–âw“±‰ÁZI‚P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6401");

                    // İ‘î‹­‰»Œ^ˆÈŠO
                } else {
                    // •ÛŒ’{İ“üŠ‘OŒã–K–âw“±‰ÁZI‚Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6402");
                }

                // —Ã—{Œ^‚Ìê‡‚ÍA—Ã—{Œ^/—Ã—{‹­‰»Œ^‚ğƒ`ƒFƒbƒN
            } else {
                // —Ã—{‹­‰»Œ^
                if (_1520149 == 2) {
                    // •ÛŒ’{İ“üŠ‘OŒã–K–âw“±‰ÁZI‚P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6401");

                    // —Ã—{‹­‰»Œ^ˆÈŠO
                } else {
                    // •ÛŒ’{İ“üŠ‘OŒã–K–âw“±‰ÁZI‚Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6402");
                }
            }
            break;
        case 3:
            // —Ã—{Œ^ˆÈŠO‚Ìê‡‚ÍA]—ˆŒ^/İ‘î‹­‰»Œ^‚ğƒ`ƒFƒbƒN
            if (!isRyoyoType(_1520101)) {
                // İ‘î‹­‰»Œ^
                if (_1520143 == 2) {
                    // •ÛŒ’{İ“üŠ‘OŒã–K–âw“±‰ÁZII‚P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6403");//2015.04

                    // İ‘î‹­‰»Œ^ˆÈŠO
                } else {
                    // •ÛŒ’{İ“üŠ‘OŒã–K–âw“±‰ÁZII‚Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6404");//2015.04
                }

                // —Ã—{Œ^‚Ìê‡‚ÍA—Ã—{Œ^/—Ã—{‹­‰»Œ^‚ğƒ`ƒFƒbƒN
            } else {
                // —Ã—{‹­‰»Œ^
                if (_1520149 == 2) {
                    // •ÛŒ’{İ“üŠ‘OŒã–K–âw“±‰ÁZII‚P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6403");//2015.04

                    // —Ã—{‹­‰»Œ^ˆÈŠO
                } else {
                    // •ÛŒ’{İ“üŠ‘OŒã–K–âw“±‰ÁZII‚Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6404");//2015.04
                }
            }
        	break;
        }

        // ‘ŞŠ‘O–K–âw“±‰ÁZ
        if (_3020109 > 1) {

            // —Ã—{Œ^ˆÈŠO‚Ìê‡‚ÍA]—ˆŒ^/İ‘î‹­‰»Œ^‚ğƒ`ƒFƒbƒN
            if (!isRyoyoType(_1520101)) {
                // İ‘î‹­‰»Œ^
                if (_1520143 == 2) {
                    // •ÛŒ’{İ‘ŞŠ‘O–K–âw“±‰ÁZ‚P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6501");

                    // İ‘î‹­‰»Œ^ˆÈŠO
                } else {
                    // •ÛŒ’{İ‘ŞŠ‘O–K–âw“±‰ÁZ‚Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6506");
                }

                // —Ã—{Œ^‚Ìê‡‚ÍA—Ã—{Œ^/—Ã—{‹­‰»Œ^‚ğƒ`ƒFƒbƒN
            } else {
                // —Ã—{‹­‰»Œ^
                if (_1520149 == 2) {
                    // •ÛŒ’{İ‘ŞŠ‘O–K–âw“±‰ÁZ‚P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6501");

                    // —Ã—{‹­‰»Œ^ˆÈŠO
                } else {
                    // •ÛŒ’{İ‘ŞŠ‘O–K–âw“±‰ÁZ‚Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6506");
                }
            }
        }

        // ‘ŞŠŒã–K–âw“±‰ÁZ
        if (_3020110 > 1) {

            // —Ã—{Œ^ˆÈŠO‚Ìê‡‚ÍA]—ˆŒ^/İ‘î‹­‰»Œ^‚ğƒ`ƒFƒbƒN
            if (!isRyoyoType(_1520101)) {
                // İ‘î‹­‰»Œ^
                if (_1520143 == 2) {
                    // •ÛŒ’{İ‘ŞŠŒã–K–âw“±‰ÁZ‚P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6507");

                    // İ‘î‹­‰»Œ^ˆÈŠO
                } else {
                    // •ÛŒ’{İ‘ŞŠŒã–K–âw“±‰ÁZ‚Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6508");
                }

                // —Ã—{Œ^‚Ìê‡‚ÍA—Ã—{Œ^/—Ã—{‹­‰»Œ^‚ğƒ`ƒFƒbƒN
            } else {
                // —Ã—{‹­‰»Œ^
                if (_1520149 == 2) {
                    // •ÛŒ’{İ‘ŞŠŒã–K–âw“±‰ÁZ‚P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6507");

                    // —Ã—{‹­‰»Œ^ˆÈŠO
                } else {
                    // •ÛŒ’{İ‘ŞŠŒã–K–âw“±‰ÁZ‚Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6508");
                }
            }
        }

        // ‘ŞŠw“±‰ÁZ
        if (_3020105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6502");
        }

        // ‘ŞŠî•ñ’ñ‹Ÿ‰ÁZ
        if (_3020106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6504");
        }

        // ‘ŞŠ‘O˜AŒg‰ÁZ
        if (_3020107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6505");
        }

        // ˜Vl–K–âŠÅŒìw¦‰ÁZ
        if (_3020108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6503");
        }

        // ‰h—{ƒ}ƒlƒWƒƒ“ƒg‰ÁZ
        if (_1520111 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6273");
        }

        // ŒoŒûˆÚs‰ÁZ
        if (_1520112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6274");
        }

        // ŒoŒûˆÛ‰ÁZ
        if (_1520126 > 1) {
        	// ŒoŒûˆÛ‰ÁZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6280");
        }
        if (_1520151 > 1) {
        	// ˆÛ‰ÁZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6281");
        }
        

        // Œûo‹@”\ˆÛŠÇ—‘Ì§‰ÁZ
        if (_1510145 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6122");
        }

        // Œûo‹@”\ˆÛŠÇ—‰ÁZ
        if (_1520135 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6123");
        }

        // —Ã—{H‰ÁZ
        if (_1520113 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
        }

        // İ‘î•œ‹Ax‰‡‹@”\‰ÁZ
        if (_1520148 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6279");
        }

        // ‹Ù‹}¡—ÃŠÇ—‰ÁZ
        if (_1520109 > 1) {
            // —Ã—{Œ^ˆÈŠO
            if (!isRyoyoType(_1520101)) {
                // ‹Ù‹}¡—ÃŠÇ—‚P
                putSystemServiceCodeItem(sysSvcCdItems, "Z9000");

                // —Ã—{Œ^
            } else {
                // ‹Ù‹}¡—ÃŠÇ—‚Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6000");
            }
        }

        // Š’è¾Š³{İ—Ã—{”ï
        if (_1520145 > 1) {
            // —Ã—{Œ^ˆÈŠO
            if (!isRyoyoType(_1520101)) {
                // ‹Ù‹}¡—ÃŠÇ—‚P
                putSystemServiceCodeItem(sysSvcCdItems, "Z9100");

                // —Ã—{Œ^
            } else {
                // ‹Ù‹}¡—ÃŠÇ—‚Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6100");
            }
        }

        // ”F’mÇê–åƒPƒA‰ÁZ
        switch (_1520137) {
        case 2:
            // Z6133 •ÛŒ’{İ”F’mÇê–åƒPƒA‰ÁZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6133");
            break;
        case 3:
            // Z6134 •ÛŒ’{İ”F’mÇê–åƒPƒA‰ÁZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6134");
            break;
        }

        // ”F’mÇs“®ES—Çó‹Ù‹}‘Î‰‰ÁZ
        if (_1520146 > 1) {
            // —Ã—{Œ^ˆÈŠO
            if (!isRyoyoType(_1520101)) {
                // •ÛŒ’{İ”F’mÇ‹Ù‹}‘Î‰‰ÁZ‚P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6121");

                // —Ã—{Œ^
            } else {
                // •ÛŒ’{İ”F’mÇ‹Ù‹}‘Î‰‰ÁZ‚Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6004");
            }
        }

        // Z6135 •ÛŒ’{İ”F’mÇî•ñ’ñ‹Ÿ‰ÁZ
        if (_1520139 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6135");
        }

        // ’nˆæ˜AŒgf—ÃŒv‰æî•ñ’ñ‹Ÿ‰ÁZ
        if (_1520147 > 1) {

            // —Ã—{Œ^ˆÈŠO‚Ìê‡‚ÍA]—ˆŒ^/İ‘î‹­‰»Œ^‚ğƒ`ƒFƒbƒN
            if (!isRyoyoType(_1520101)) {
                // İ‘î‹­‰»Œ^
                if (_1520143 == 2) {
                    // •ÛŒ’{İ’nˆæ˜AŒgf—ÃŒv‰æ‰ÁZ‚P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6136");

                    // İ‘î‹­‰»Œ^ˆÈŠO
                } else {
                    // •ÛŒ’{İ’nˆæ˜AŒgf—ÃŒv‰æ‰ÁZ‚Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6137");
                }

                // —Ã—{Œ^‚Ìê‡‚ÍA—Ã—{Œ^/—Ã—{‹­‰»Œ^‚ğƒ`ƒFƒbƒN
            } else {
                // —Ã—{‹­‰»Œ^
                if (_1520149 == 2) {
                    // •ÛŒ’{İ’nˆæ˜AŒgf—ÃŒv‰æ‰ÁZ‚P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6136");

                    // —Ã—{‹­‰»Œ^ˆÈŠO
                } else {
                    // •ÛŒ’{İ’nˆæ˜AŒgf—ÃŒv‰æ‰ÁZ‚Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6137");
                }
            }
        }

        switch (_1520142) {
        case 5:
            // Z6107 •ÛŒ’{İƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZIƒC
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");//2015.04
            break;
        case 2:
            // Z6101 •ÛŒ’{İƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZIƒ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // Z6102 •ÛŒ’{İƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
            // Z6103 •ÛŒ’{İƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }

        // ‰îŒìEˆõˆ‹ö‰ü‘P‚ğ•Ô‹p
        switch (_17) {
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
            break;
        }

        // “Á’è“üŠÒƒ`ƒFƒbƒN‚ª‚Â‚¢‚Ä‚¢‚½ê‡‚ÍŒÂº‚Ì’PˆÊ”‚ğ’Ç‰Á
        if (!new Integer(1).equals(map.get("7")) && !"1".equals(map.get("7"))) {
            // H–’ñ‹Ÿ
            if (_1520120 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }
            // 2006/07/14 —Ã—{Œ^‘Î‰
            // ŠO”‘‰ÁZ‚Å‚ ‚Á‚½ê‡‰Šú‰»‚·‚é
            if (_1520107 > 1) {
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // ‘Øİ”ï --------
            putSystemServiceCodeItem(sysSvcCdItems,
                    getSystemServiceCodeOfRoom(byoshitsu));
        }// ƒ`ƒFƒbƒN‚ª‚Â‚¢‚Ä‚¢‚È‚¢ê‡‚Í‰½‚à•Ô‚³‚È‚¢

        // ŠO”‘‚ª‚ ‚è‚¾‚Á‚½ê‡‚Íˆê—¥ŠO”‘‚ÌƒR[ƒh‚ğ•Ô‚·
        if (_1520107 > 1) {
            // ŠO”‘‚à‚µ‚­‚Ís“I‘ŞŠ‚ğs‚Á‚Ä‚¢‚éê‡‚Í‰Šú‰»ˆ—‚ğs‚í‚È‚¢
            if ("1".equals(map.get("7")) || new Integer(1).equals(map.get("7"))) {
                // “à•”ƒT[ƒrƒXƒR[ƒh‚ğ‰Šú‰»
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // ŠO”‘‚É‚ ‚½‚éƒT[ƒrƒXƒR[ƒh‚ğ’Ç‰Á
            putSystemServiceCodeItem(sysSvcCdItems, "Z6300");

            // ‰îŒìEˆõˆ‹ö‰ü‘P‚ğ•Ô‹p
            switch (_17) {
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2015.04
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                break;
            }

        }

        return sysSvcCdItems;
    }

    public ArrayList<VRMap> getServiceCode(Map<String, String> map,
            ACDBManager dbm) {
        ArrayList<VRMap> al = super.getServiceCode(map, dbm);
        Map<String, Integer> mp = null;
        // “Á’è“üŠÒƒ`ƒFƒbƒN‚ª‚Â‚¢‚Ä‚È‚©‚Á‚½ê‡‚ÍH”ï‚ğã‘‚«‚¹‚¸‚É•Ô‚·
        //[ID:0000749][Shin Fujihara] 2012/10 edit begin 2012”N“x‘Î‰ “Á’è“üŠÒ‚Ì—š—ğŠÇ—‹@”\
//        if (new Integer(1).equals(map.get("7")) || "1".equals(map.get("7"))) {
//            // H”ï‚Í•K—v‚È‚¢‚½‚ßƒf[ƒ^‚ğÁ‚·
//            return al;
//        }
        if (ACCastUtilities.toInt(map.get("7"), 1) != 2) {
        	//H”ï‚Í•K—v‚È‚¢‚½‚ßƒf[ƒ^‚ğÁ‚·
        	return al;
        }
        //[ID:0000749][Shin Fujihara] 2012/10 edit end 2012”N“x‘Î‰ “Á’è“üŠÒ‚Ì—š—ğŠÇ—‹@”\

        // –‹ÆŠî•ñ‚Ìæ“¾
        VRList temp = new VRArrayList();

        try {
            temp = QkanCommon.getProviderServiceDetail(dbm,
                    ACCastUtilities.toString(map.get("PROVIDER_ID")),
                    ACCastUtilities.toInt(getSystemServiceKindDetail(), 0));
        } catch (Exception e) {
            return al;
        }

        VRMap providerInfo = (VRMap) temp.get(0);

        for (int i = 0; i < al.size(); i++) {
            mp = (Map<String, Integer>) al.get(i);

            String val = ACCastUtilities.toString(
                    mp.get("SYSTEM_SERVICE_CODE_ITEM"), "");
            if (SERVICE_CODE_SHOKUHI.equals(val)) {
                // H”ï‚ÌƒŒƒR[ƒh
                if (this._1520122 <= 0) {
                    // H”ï‚ª0‰~ˆÈ‰º‚Ìê‡
                    // ŠY“–ƒŒƒR[ƒh‚ğíœ‚·‚éB
                    al.remove(i);
                    // íœ‚µ‚½‚½‚ßƒCƒ“ƒfƒbƒNƒX‚ğ1‚Â–ß‚·B
                    i--;
                } else {
                    // H”ï‚ª0‰~ˆÈ‰º‚Å‚È‚¢ê‡
                    // H”ï‚ğ‹Æ–±‚©‚ç“n‚³‚ê‚½’l‚Åã‘‚«‚·‚éB
                    mp.put("SERVICE_UNIT", new Integer(this._1520122));
                }
            } else if (SERVICE_CODE_UNIT_ROOM.equals(val)) {
                // ƒ†ƒjƒbƒgŒ^ŒÂº‚ÌƒŒƒR[ƒh
                // ”ï—p’P‰¿‚ª0ˆÈ‰º‚Åİ’è‚³‚ê‚Ä‚¢‚éê‡A–ß‚è’l‚©‚çíœ
                // ƒ†ƒjƒbƒgŒ^ŒÂº‚Ì”ï—p’P‰¿‚ğæ“¾
                int unitRoom = ACCastUtilities.toInt(
                        providerInfo.get(this.PATH_UNIT_ROOM), 0);
                if (unitRoom <= 0) {
                    // ŠY“–ƒŒƒR[ƒh‚ğíœ‚·‚éB
                    al.remove(i);
                    // íœ‚µ‚½‚½‚ßƒCƒ“ƒfƒbƒNƒX‚ğ1‚Â–ß‚·B
                    i--;
                }
            } else if (SERVICE_CODE_UNIT_SEMI_ROOM.equals(val)) {
                // ƒ†ƒjƒbƒgŒ^€ŒÂº‚ÌƒŒƒR[ƒh
                // ”ï—p’P‰¿‚ª0ˆÈ‰º‚Åİ’è‚³‚ê‚Ä‚¢‚éê‡A–ß‚è’l‚©‚çíœ
                // ƒ†ƒjƒbƒgŒ^€ŒÂº‚Ì”ï—p’P‰¿‚ğæ“¾
                int unitSemiRoom = ACCastUtilities.toInt(
                        providerInfo.get(this.PATH_UNIT_SEMI_ROOM), 0);
                if (unitSemiRoom <= 0) {
                    // ŠY“–ƒŒƒR[ƒh‚ğíœ‚·‚éB
                    al.remove(i);
                    // íœ‚µ‚½‚½‚ßƒCƒ“ƒfƒbƒNƒX‚ğ1‚Â–ß‚·B
                    i--;
                }
            } else if (SERVICE_CODE_NORMAL_ROOM.equals(val)) {
                // ]—ˆŒ^ŒÂº‚ÌƒŒƒR[ƒh
                // ”ï—p’P‰¿‚ª0ˆÈ‰º‚Åİ’è‚³‚ê‚Ä‚¢‚éê‡A–ß‚è’l‚©‚çíœ
                // ]—ˆŒ^ŒÂº‚Ì”ï—p’P‰¿‚ğæ“¾
                int normalRoom = ACCastUtilities.toInt(
                        providerInfo.get(this.PATH_NORMAL_ROOM), 0);
                if (normalRoom <= 0) {
                    // ŠY“–ƒŒƒR[ƒh‚ğíœ‚·‚éB
                    al.remove(i);
                    // íœ‚µ‚½‚½‚ßƒCƒ“ƒfƒbƒNƒX‚ğ1‚Â–ß‚·B
                    i--;
                }
            } else if (SERVICE_CODE_TASHO_ROOM.equals(val)) {
                // ‘½°º‚ÌƒŒƒR[ƒh
                // ”ï—p’P‰¿‚ª0ˆÈ‰º‚Åİ’è‚³‚ê‚Ä‚¢‚éê‡A–ß‚è’l‚©‚çíœ
                // ‘½°º‚Ì”ï—p’P‰¿‚ğæ“¾
                int tashoRoom = ACCastUtilities.toInt(
                        providerInfo.get(this.PATH_TASHO_ROOM), 0);
                if (tashoRoom <= 0) {
                    // ŠY“–ƒŒƒR[ƒh‚ğíœ‚·‚éB
                    al.remove(i);
                    // íœ‚µ‚½‚½‚ßƒCƒ“ƒfƒbƒNƒX‚ğ1‚Â–ß‚·B
                    i--;
                }
            }
        }

        return al;
    }
}
