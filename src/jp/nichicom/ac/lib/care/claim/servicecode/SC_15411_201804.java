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
 * ’nζ–§’…^‰ξμ•ƒ{έ
 * 
 * @since V7.0.0
 * @author Shinobu Hitaka
 * 
 */
public class SC_15411_201804 extends Qkan10011_ServiceUnitGetter {
    private int _1540121 = 0;

    private final String PATH_UNIT_ROOM = "1540121";
    private final String PATH_UNIT_SEMI_ROOM = "1540122";
    private final String PATH_NORMAL_ROOM = "1540123";
    private final String PATH_TASHO_ROOM = "1540124";

    private int byoshitsu = 0;

    public String getServiceName() {
        return "’nζ–§’…^‰ξμ•ƒ{έ";
    }

    public String getServiceCodeKind() {
        return "54";
    }

    public String getSystemServiceKindDetail() {
        return "15411 ";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // ƒpƒ‰ƒ[ƒ^’o
        // =========================================================================

        // 1540101 {έ‹ζ•ª 1-‰ξμ•ƒ{έ 3-ƒ†ƒjƒbƒg^‰ξμ•ƒ{έ
        int _1540101 = getIntValue(map, "1540101");

        // 1540102 o‰ί“I’nζ–§’…ƒT[ƒrƒX
        int _1540102 = getIntValue(map, "1540102");

        // 1540103 •aΊ‹ζ•ª(]—^) 1-]—^ΒΊ 2-‘½°Ί
        int _1540103 = getIntValue(map, "1540103");

        // 1540104 •aΊ‹ζ•ª(ƒ†ƒjƒbƒg^) 1-ƒ†ƒjƒbƒg^ΒΊ 2-ƒ†ƒjƒbƒg^€ΒΊ
        int _1540104 = getIntValue(map, "1540104");

        // •aΊ‚π”»’θ
        if (_1540101 > 1) {
            // ƒ†ƒjƒbƒg^
            byoshitsu = convertByoshitsuKbn(_1540104, true);
        } else {
            // ’Κν
            byoshitsu = convertByoshitsuKbn(_1540103, false);
        }

        // 1 —v‰ξμ“x
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1540107 –ιΤ‹Ξ–±πξ€ 1-–‚½‚µ‚Δ‚Ά‚ι 2-–‚½‚µ‚Δ‚Ά‚Θ‚Ά
        int _1540107 = getIntValue(map, "1540107");

        // 1540119 lυΈZ 1-‚Θ‚µ 2-’θυ’΄‰ί 3-ΕμE‰ξμEυ–”‚Ν‰ξμx‰‡κ–ευ•s‘«
        int _1540119 = getIntValue(map, "1540119");

        // 1540105 ƒ†ƒjƒbƒgƒPƒA‚Μ®”υ 1-–Ά®”υ 2-®”υ
        int _1540105 = getIntValue(map, "1540105");

        // 1540106 €ƒ†ƒjƒbƒgƒPƒA‰ΑZ 1-‚Θ‚µ 2-‚ ‚θ
        int _1540106 = getIntValue(map, "1540106");

        // 1540108 Β•Κ‹@”\P—ϋw“±‰ΑZ 1-‚Θ‚µ 2-‚ ‚θ
        int _1540108 = getIntValue(map, "1540108");

        // 1540109 γtν‹Ξ‰ΑZ 1-‚Θ‚µ 2-‚ ‚θ
        int _1540109 = getIntValue(map, "1540109");

        // 1540110 Έ_‰Θγw“±‰ΑZ 1-‚Θ‚µ 2-‚ ‚θ
        int _1540110 = getIntValue(map, "1540110");

        // 1540111 αQÒ¶x‰‡‘Μ§‰ΑZ
        int _1540111 = getIntValue(map, "1540111");

        // 1540123 g‘ΜS‘©”p~–Άΐ{ΈZ 1-‚Θ‚µ 2-‚ ‚θ
        int _1540123 = getIntValue(map, "1540123");

        // 1540112 O”‘‰ΑZ 1-‚Θ‚µ 2-‚ ‚θ
        int _1540112 = getIntValue(map, "1540112");

        // 1540113 ‰ϊ‰ΑZ 1-‚Θ‚µ 2-‚ ‚θ
        int _1540113 = getIntValue(map, "1540113");

        // 3020102 ‘ή‘’k‰‡•‰ΑZ
        int _3020102 = getIntValue(map, "3020102");

        // 3020103 ‘ή‘OAg‰ΑZ
        int _3020103 = getIntValue(map, "3020103");

        // 1540115 ‰h—{ƒ}ƒlƒWƒƒ“ƒg‰ΑZ 1-‚Θ‚µ 2-‚ ‚θ
        int _1540115 = getIntValue(map, "1540115");

        // 1540116 oϋΪs‰ΑZ 1-‚Θ‚µ 2-‚ ‚θ
        int _1540116 = getIntValue(map, "1540116");

        // 1540117 oϋΫ‰ΑZ‡T
        int _1540117 = getIntValue(map, "1540117");

        // 1540141 oϋΫ‰ΑZ‡U 2015.04
        int _1540141 = getIntValue(map, "1540141");

        // 1540118 —Γ—{H‰ΑZ
        int _1540118 = getIntValue(map, "1540118");
        
        // 1540142 Εζ‚θ‰ξμ‰ΑZ^
        int _1540142 = getIntValue(map, "1540142");

        // 1540134 Εζ‚θ‰ξμ‰ΑZ 1-‚Θ‚µ 2-€–S“ϊΘ‘O4“ϊΘγ30“ϊΘ‰Ί 3-€–S“ϊΘ‘O2“ϊ–”‚Ν3“ϊ 4-€–S“ϊ
        int _1540134 = getIntValue(map, "1540134");

        // 1540125 έ‘ξ•‹Ax‰‡‹@”\‰ΑZ 1-‚Θ‚µ 2-‚ ‚θ
        int _1540125 = getIntValue(map, "1540125");

        // 1540126 έ‘ξE“ό‘έ——p‰ΑZ 1-‚Θ‚µ 2-‚ ‚θ
        int _1540126 = getIntValue(map, "1540126");

        // 1540127 ¬‹K–Ν‹’“_W‡^{έ‰ΑZ 1-‚Θ‚µ 2-‚ ‚θ
        int _1540127 = getIntValue(map, "1540127");

        // 1540120 H–’ρ‹ 1-‚Θ‚µ 2-OH 3-’© 4-’‹ 5-–ι 6-’©’‹ 7-’‹–ι 8-–ι’©
        int _1540120 = getIntValue(map, "1540120");

        // 1540121 H”ο
        this._1540121 = getIntValue(map, "1540121");

        // 1540129 “ϊν¶p‘±x‰‡‰ΑZ
        int _1540129 = getIntValue(map, "1540129");

        // 1540137 Εμ‘Μ§‰ΑZ‡T
        int _1540137 = getIntValue(map, "1540137");

        // 1540138 Εμ‘Μ§‰ΑZ‡U
        int _1540138 = getIntValue(map, "1540138");

        // 1540131 –ι‹ΞEυ”z’u‰ΑZ
        int _1540131 = getIntValue(map, "1540131");

        // 1540132 α”N«”F’mΗ“όÒσ“ό‰ΑZ
        int _1540132 = getIntValue(map, "1540132");

        // 1540133 ϋo‰q¶Η—‰ΑZ
        int _1540133 = getIntValue(map, "1540133");

        // 1540135 ”F’mΗκ–εƒPƒA‰ΑZ
        int _1540135 = getIntValue(map, "1540135");

        // 1540136 ƒT[ƒrƒX’ρ‹‘Μ§‹­‰»‰ΑZ
        int _1540136 = getIntValue(map, "1540136");

        // 2006/05/15 —\–h‘Ξ‰
        // ’P“Ζ‰ΑZ
        int _9 = getIntValue(map, "9");

        // 3020109 ‘ή‘O–K–βw“±‰ΑZ
        int _3020109 = getIntValue(map, "3020109", 1);

        // 3020110 ‘ήγ–K–βw“±‰ΑZ
        int _3020110 = getIntValue(map, "3020110", 1);

        // 1540139 ”F’mΗs“®ES—Ησ‹Ω‹}‘Ξ‰‰ΑZ
        int _1540139 = getIntValue(map, "1540139", 1);
        
        // 1540140 ϋo‰q¶Η—‘Μ§‰ΑZ
        int _1540140 = getIntValue(map, "1540140", 1);

        // 1540143 ¶‹@”\όγAg‰ΑZ
        int _1540143 = getIntValue(map, "1540143", 1);
        
        // 1540144 O”‘έ‘ξƒT[ƒrƒX——p”ο—p
        int _1540144 = getIntValue(map, "1540144", 1);
        
        // 1540145 Δ“ό‰h—{Ag‰ΑZ
        int _1540145 = getIntValue(map, "1540145", 1);
        
        // 1540146 ’α‰h—{ƒƒXƒN‰ό‘P‰ΑZ
        int _1540146 = getIntValue(map, "1540146", 1);
        
        // 1540147 ”z’uγt‹Ω‹}‘Ξ‰‰ΑZ
        int _1540147 = getIntValue(map, "1540147", 1);
        
        // 1540148 εραƒ}ƒlƒWƒƒ“ƒg‰ΑZ
        int _1540148 = getIntValue(map, "1540148", 1);
        
        // 1540149 ”r‚Ή‚Βx‰‡‰ΑZ
        int _1540149 = getIntValue(map, "1540149", 1);
        
        // 17 ‰ξμEυ‹φ‰ό‘P‰ΑZ
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 2006/05/15 —\–h‘Ξ‰
        // ’P“Ζ‰ΑZ‚Μ‚έ---------------------------------------------------------------
        // ’P“Ζ‰ΑZƒT[ƒrƒX
        if (_9 == 2) {
            
            // ‘ήγ–K–βw“±‰ΑZ
            if (_3020110 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6504");
            }
            
            // Εμ‘Μ§‰ΑZ‚Μ•ΉZ’θ‚Ζ‡‚ν‚Ή‚ΔC³
            // Εζ‚θ‰ξμ‰ΑZ
            if (_1540142 == 2) {
                switch (_1540134) {
                case 2:
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6276");
                    break;
                case 3:
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6277");
                    break;
                case 4:
                    // 6283@’n•ƒ{έΕζ‚θ‰ξμ‰ΑZ‚R
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6283");
                    break;
                }
            } else if (_1540142 == 3) {
                switch (_1540134) {
                case 2:
                    // Εζ‚θ‰ξμ‰ΑZII‚P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6284");//2018.04
                    break;
                case 3:
                    // Εζ‚θ‰ξμ‰ΑZII‚Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6285");//2018.04
                    break;
                case 4:
                    // Εζ‚θ‰ξμ‰ΑZII‚R
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6286");//2018.04
                    break;
                }
            }
            
            // ‰ξμEυ‹φ‰ό‘P‚π•Τ‹p
            switch (_17) {
            case 6:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6110");//2017.04
                break;
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

        // “Ζ©ƒR[ƒh¶¬
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // {έ‹ζ•ª 1-‰ξμ•ƒ{έ 3-ƒ†ƒjƒbƒg^‰ξμ•ƒ{έ
        sb.append(CODE_CHAR[_1540101]);

        // o‰ί“I’nζ–§’…ƒT[ƒrƒX
        sb.append(CODE_CHAR[_1540102]);
        
        // •aΊ‹ζ•ª(]—^ΒΊ/‘½°Ί)
        sb.append(CODE_CHAR[_1540103]);
        
        // •aΊ‹ζ•ª(ƒ†ƒjƒbƒg^ΒΊ/ƒ†ƒjƒbƒg^€ΒΊ)
        sb.append(CODE_CHAR[_1540104]);
        
        // —v‰ξμ“x
        sb.append(CODE_CHAR[_1]);

        // –ιΤ‹Ξ–±πξ€ 1-–‚½‚µ‚Δ‚Ά‚ι 2-–‚½‚µ‚Δ‚Ά‚Θ‚Ά
        sb.append(CODE_CHAR[_1540107]);

        // lυΈZ 1-‚Θ‚µ 2-’θυ’΄‰ί 3-ΕμE‰ξμEυ–”‚Ν‰ξμx‰‡κ–ευ•s‘«
        sb.append(CODE_CHAR[_1540119]);

        // ƒ†ƒjƒbƒgƒPƒA‚Μ®”υ
        switch (_1540101) {
        case 1: //‰ξμ•ƒ{έ
            sb.append(DEFAULT_CHAR);
            break;
        case 2: //ƒ†ƒjƒbƒg^‰ξμ•ƒ{έ
            // 1-–Ά®”υ 2-®”υ
            if (_1540105 > 1) {
                sb.append(DEFAULT_CHAR);
            } else {
                sb.append(CODE_CHAR[2]);
            }
            break;
        }

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ‰ΑZ
        // ============================================================================
        
        // 6132@’n•ƒ{έ“ϊν¶p‘±x‰‡‰ΑZ
        if (_1540129 > 1) {
        	
            // {έ“™‚Μ‹ζ•ª
            switch (_1540101) {
            
            // ‰ξμ•ƒ{έ
            case 1:
                // 6132@’n•ƒ{έ“ϊν¶p‘±x‰‡‰ΑZ‚P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6132");//2015.04
                break;
                
            // ƒ†ƒjƒbƒg^‰ξμ•ƒ{έ
            case 2:
                // 6135@’n•ƒ{έ“ϊν¶p‘±x‰‡‰ΑZ‚Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6135");//2015.04
                break;
            }
        }
        
        // Εμ‘Μ§‰ΑZ‡T‚ª‘I‘π‚³‚κ‚Δ‚Ά‚ικ‡
        if (_1540137 > 1) {
            if (_1540102 == 2) {
                // 6114@’n•ƒ{έΕμ‘Μ§‰ΑZI‚Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6114");
            } else {
                // 6113@’n•ƒ{έΕμ‘Μ§‰ΑZI‚P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6113");
            }
        }
        // Εμ‘Μ§‰ΑZ‡U‚ª‘I‘π‚³‚κ‚Δ‚Ά‚ικ‡
        if (_1540138 > 1) {
            if (_1540102 == 2) {
                // 6116@’n•ƒ{έΕμ‘Μ§‰ΑZII‚Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6116");
            } else {
                // 6115@’n•ƒ{έΕμ‘Μ§‰ΑZII‚P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6115");
            }
        }
        
        // –ι‹ΞEυ”z’u‰ΑZ
        if (_1540131 == 2) {
            // {έ“™‚Μ‹ζ•ª
            switch (_1540101) {
            
            // ‰ξμ•ƒ{έ
            case 1:
                // o‰ί“I—v‰ξμ
                if (_1540102 == 2) {
                    // 6118@’n•ƒ{έ–ι‹ΞEυ”z’u‰ΑZI‚Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6118");
                } else {
                    // 6117@’n•ƒ{έ–ι‹ΞEυ”z’u‰ΑZI‚P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6117");
                }
                break;
                
            // ƒ†ƒjƒbƒg^‰ξμ•ƒ{έ
            case 2:
                // o‰ί“I—v‰ξμ
                if (_1540102 == 2) {
                    // 6120@’n•ƒ{έ–ι‹ΞEυ”z’u‰ΑZII‚Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6120");
                } else {
                    // 6119@’n•ƒ{έ–ι‹ΞEυ”z’u‰ΑZII‚P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6119");
                }
                break;
            }        	
        } else if (_1540131 == 3) {
            // {έ“™‚Μ‹ζ•ª
            switch (_1540101) {
            
            // ‰ξμ•ƒ{έ
            case 1:
                // o‰ί“I—v‰ξμ
                if (_1540102 == 2) {
                    // –ι‹ΞEυ”z’u‰ΑZIII‚Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6128");
                } else {
                    // –ι‹ΞEυ”z’u‰ΑZIII‚P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6127");
                }
                break;
                
            // ƒ†ƒjƒbƒg^‰ξμ•ƒ{έ
            case 2:
                // o‰ί“I—v‰ξμ
                if (_1540102 == 2) {
                    // –ι‹ΞEυ”z’u‰ΑZIV‚Q
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6130");
                } else {
                    // –ι‹ΞEυ”z’u‰ΑZIV‚P
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6129");
                }
                break;
            } 
        }

        
        // €ƒ†ƒjƒbƒgƒPƒA‰ΑZ 1-‚Θ‚µ 2-‚ ‚θ
        if (_1540106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6002");
        }
        
        // Β•Κ‹@”\P—ϋw“±‰ΑZ 1-‚Θ‚µ 2-‚ ‚θ
        if (_1540108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6003");
        }
        
        // 6109@’n•ƒ{έα”N«”F’mΗσ“ό‰ΑZ
        if (_1540132 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // γtν‹Ξ‰ΑZ 1-‚Θ‚µ 2-‚ ‚θ
        if (_1540109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");
        }
        
        // Έ_‰Θγw“±‰ΑZ 1-‚Θ‚µ 2-‚ ‚θ
        if (_1540110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6200");
        }
        
        // αQÒ¶x‰‡‘Μ§‰ΑZ
        switch (_1540111) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6250");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6251");//2018.04
            break;
        }
        
        // g‘ΜS‘©”p~–Άΐ{ΈZ 1-‚Θ‚µ 2-‚ ‚θ
        if (_1540123 > 1) {
            StringBuilder sb1 = new StringBuilder();
            // ƒvƒƒtƒBƒbƒNƒX
            sb1.append(SYSTEM_SERVICE_CODE_PREFIX_SK);
            // {έ‹ζ•ª 1-‰ξμ•ƒ{έ 3-ƒ†ƒjƒbƒg^‰ξμ•ƒ{έ
            sb1.append(CODE_CHAR[_1540101]);
            // o‰ί“I’nζ–§’…ƒT[ƒrƒX
            sb1.append(CODE_CHAR[_1540102]);            
            // •aΊ‹ζ•ª(]—^ΒΊ/‘½°Ί)
            sb1.append(CODE_CHAR[_1540103]);           
            // •aΊ‹ζ•ª(ƒ†ƒjƒbƒg^ΒΊ/ƒ†ƒjƒbƒg^ΒΊ“I‘½°Ί)
            sb1.append(CODE_CHAR[_1540104]);
            // —v‰ξμ“x
            sb1.append(CODE_CHAR[_1]);
            putSystemServiceCodeItem(sysSvcCdItems, sb1.toString());
        }
        
        // O”‘‰ΑZ 1-‚Θ‚µ 2-‚ ‚θ
        if (_1540112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6300");
        }
        
        // ‰ϊ‰ΑZ 1-‚Θ‚µ 2-‚ ‚θ
        if (_1540113 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6400");
        }
        
        // 3020109 ‘ή‘O–K–βw“±‰ΑZ
        if (_3020109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6501");
        }
        
        // 3020110 ‘ήγ–K–βw“±‰ΑZ
        if (_3020110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6504");
        }
        
        // ‘ή‘’k‰‡•‰ΑZ
        if (_3020102 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6502");
        }
        
        // ‘ή‘OAg‰ΑZ
        if (_3020103 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6503");
        }
        
        // ‰h—{ƒ}ƒlƒWƒƒ“ƒg‰ΑZ 1-‚Θ‚µ 2-‚ ‚θ
        if (_1540115 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6273");
        }
        
        // oϋΪs‰ΑZ 1-‚Θ‚µ 2-‚ ‚θ
        if (_1540116 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6274");
        }
        
        // oϋΫ‰ΑZ‡T^
        if (_1540117 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6281");
        }
        
        // oϋΫ‰ΑZ‡U^
        if (_1540141 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6282");
        }
        
        // ϋo‰q¶Η—‘Μ§‰ΑZ
        if (_1540140 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6122");
        }
        
        // ϋo‰q¶Η—‰ΑZ
        if (_1540133 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6123");
        }
        
        // —Γ—{H‰ΑZ
        switch (_1540118) {
        case 2:
            // ‚R‰ρ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
            break;
        case 3:
            // ‚Q‰ρ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
            break;
        case 4:
            // ‚P‰ρ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
            break;
        }
        
        // 1540143	¶‹@”\όγAg‰ΑZ
        if (_1540143 > 1) {
        	if (_1540108 > 1) { //Β•Κ‹@”\P—ϋw“±‰ΑZ‚πZ’θ‚µ‚Δ‚Ά‚ικ‡
        		putSystemServiceCodeItem(sysSvcCdItems, "Z4003"); //2018.04
        	} else {
        		putSystemServiceCodeItem(sysSvcCdItems, "Z4002"); //2018.04
        	}
        }
        
        // 1540144 O”‘έ‘ξƒT[ƒrƒX——p”ο—p
        if (_1540144 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6301");//2018.04
        }
        
        // 1540145 Δ“ό‰h—{Ag‰ΑZ
        if (_1540145 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6353");//2018.04
        }
        
        // 1540146 ’α‰h—{ƒƒXƒN‰ό‘P‰ΑZ
        if (_1540146 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6354");//2018.04
        }
        
        // 1540147 ”z’uγt‹Ω‹}‘Ξ‰‰ΑZ
        switch (_1540147) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6291");//2018.04
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6292");//2018.04
            break;
        }
        
        // 1540148 εραƒ}ƒlƒWƒƒ“ƒg‰ΑZ
        if (_1540148 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6356");//2018.04
        }
        
        // 1540149 ”r‚Ή‚Βx‰‡‰ΑZ
        if (_1540149 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6357");//2018.04
        }
        
        // Εζ‚θ‰ξμ‰ΑZ
        if (_1540142 == 2) {
            // Εζ‚θ‰ξμ‰ΑZ 1-‚Θ‚µ 2-€–S“ϊΘ‘O4“ϊΘγ30“ϊΘ‰Ί 3-€–S“ϊΘ‘O2“ϊ–”‚Ν3“ϊ 4-€–S“ϊ
            switch (_1540134) {
            case 2:
                // ’n•ƒ{έΕζ‚θ‰ξμ‰ΑZ‚P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6276");
                break;
            case 3:
                // ’n•ƒ{έΕζ‚θ‰ξμ‰ΑZ‚Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6277");
                break;
            case 4:
                // 6283@’n•ƒ{έΕζ‚θ‰ξμ‰ΑZ‚R
                putSystemServiceCodeItem(sysSvcCdItems, "Z6283");
                break;
            }
        } else if (_1540142 == 3) {
            // Εζ‚θ‰ξμ‰ΑZ 1-‚Θ‚µ 2-€–S“ϊΘ‘O4“ϊΘγ30“ϊΘ‰Ί 3-€–S“ϊΘ‘O2“ϊ–”‚Ν3“ϊ 4-€–S“ϊ
            switch (_1540134) {
            case 2:
                // Εζ‚θ‰ξμ‰ΑZII‚P
                putSystemServiceCodeItem(sysSvcCdItems, "Z6284");//2018.04
                break;
            case 3:
                // Εζ‚θ‰ξμ‰ΑZII‚Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z6285");//2018.04
                break;
            case 4:
                // Εζ‚θ‰ξμ‰ΑZII‚R
                putSystemServiceCodeItem(sysSvcCdItems, "Z6286");//2018.04
                break;
            }
        }
        

        
        // έ‘ξ•‹Ax‰‡‹@”\‰ΑZ 1-‚Θ‚µ 2-‚ ‚θ
        if (_1540125 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6278");
        }
        
        // έ‘ξE“ό‘έ——p‰ΑZ 1-‚Θ‚µ 2-‚ ‚θ
        if (_1540126 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6279");
        }
        
        // ¬‹K–Ν‹’“_W‡^{έ‰ΑZ 1-‚Θ‚µ 2-‚ ‚θ
        if (_1540127 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6280");
        }
        
        switch (_1540135) {
        case 2:
            // 6133@’n•ƒ{έ”F’mΗκ–εƒPƒA‰ΑZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6133");
            break;
        case 3:
            // 6134@’n•ƒ{έ”F’mΗκ–εƒPƒA‰ΑZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6134");
            break;
        }

        // 1540139 ”F’mΗs“®ES—Ησ‹Ω‹}‘Ξ‰‰ΑZ
        if (_1540139 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6121");
        }
        
        
        switch (_1540136) {
        case 5:
            // 6104@’n•ƒ{έƒT[ƒrƒX’ρ‹‘Μ§‰ΑZIƒC
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");//2015.04
            break;
        case 2:
            // 6101@’n•ƒ{έƒT[ƒrƒX’ρ‹‘Μ§‰ΑZIƒ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // 6102@’n•ƒ{έƒT[ƒrƒX’ρ‹‘Μ§‰ΑZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
            // 6103@’n•ƒ{έƒT[ƒrƒX’ρ‹‘Μ§‰ΑZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }


        // ‰ξμEυ‹φ‰ό‘P‚π•Τ‹p
        switch (_17) {
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6110");//2017.04
            break;
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

        // “Α’θ“όÒƒ`ƒFƒbƒN‚ª‚Β‚Ά‚Δ‚Ά‚½κ‡‚ΝΒΊ‚Μ’PΚ”‚π’Η‰Α
        if (!new Integer(1).equals(map.get("7")) && !"1".equals(map.get("7"))) {
            // H–’ρ‹ 1-‚Θ‚µ 2-OH 3-’© 4-’‹ 5-–ι 6-’©’‹ 7-’‹–ι 8-–ι’©
            if (_1540120 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }
            // 2018/03/01 [H30.4‰ό³‘Ξ‰][Yoichiro Kamei] mod - begin
            // O”‘‰ΑZ‚ ‚θ‚Ε‚ ‚ικ‡‰ϊ‰»
            // ‚ά‚½‚ΝO”‘έ‘ξƒT[ƒrƒX——p”ο—p‚ª‚ ‚θ‚Ύ‚Α‚½κ‡
//            if (_1540112 > 1) {
            if (_1540112 > 1 || _1540144 > 1) {
            // 2018/03/01 [H30.4‰ό³‘Ξ‰][Yoichiro Kamei] mod - end
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // ‘Ψέ”ο --------
            putSystemServiceCodeItem(sysSvcCdItems,
                    getSystemServiceCodeOfRoom(byoshitsu));
        }

        // O”‘‚ª‚ ‚θ‚Ύ‚Α‚½κ‡‚Νκ—¥O”‘‚ΜƒR[ƒh‚π•Τ‚·
        if (_1540112 > 1) {
            // “Α’θ“όÒ‚Ε‚ ‚ικ‡‚Ν‰ϊ‰»‚π‰ρ”π
            if (new Integer(1).equals(map.get("7")) || "1".equals(map.get("7"))) {
                // “ΰ•”ƒT[ƒrƒXƒR[ƒh‚π‰ϊ‰»
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // O”‘‚Ι‚ ‚½‚ιƒT[ƒrƒXƒR[ƒh‚π’Η‰Α
            putSystemServiceCodeItem(sysSvcCdItems, "Z6300");
            
            // ‰ξμEυ‹φ‰ό‘P‚π•Τ‹p
            switch (_17) {
            case 6:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6110");//2017.04
                break;
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
        
        // 2018/03/01 [H30.4‰ό³‘Ξ‰][Yoichiro Kamei] add - begin
        if (_1540144 > 1) {
            // “Α’θ“όÒ‚Ε‚ ‚ικ‡‚Ν‰ϊ‰»‚π‰ρ”π
            if (new Integer(1).equals(map.get("7")) || "1".equals(map.get("7"))) {
                // “ΰ•”ƒT[ƒrƒXƒR[ƒh‚π‰ϊ‰»
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // O”‘έ‘ξƒT[ƒrƒX——p”ο—p‚Ι‚ ‚½‚ιƒT[ƒrƒXƒR[ƒh‚π’Η‰Α
            putSystemServiceCodeItem(sysSvcCdItems, "Z6301");
            
            // ‰ξμEυ‹φ‰ό‘P‚π•Τ‹p
            switch (_17) {
            case 6:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6110");//2017.04
                break;
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
        // 2018/03/01 [H30.4‰ό³‘Ξ‰][Yoichiro Kamei] add - end

        return sysSvcCdItems;
    }

    public ArrayList<VRMap> getServiceCode(Map<String, String> map,
            ACDBManager dbm) {
        ArrayList<VRMap> al = super.getServiceCode(map, dbm);
        Map<String, Integer> mp = null;
        // “Α’θ“όÒƒ`ƒFƒbƒN‚ª‚Β‚Ά‚Δ‚Θ‚©‚Α‚½κ‡‚ΝH”ο‚πγ‘‚«‚Ή‚Έ‚Ι•Τ‚·
        //[ID:0000749][Shin Fujihara] 2012/10 edit begin 2012”N“x‘Ξ‰ “Α’θ“όÒ‚Μ——πΗ—‹@”\
//        if (new Integer(1).equals(map.get("7")) || "1".equals(map.get("7"))) {
//            // H”ο‚Ν•K—v‚Θ‚Ά‚½‚ίƒf[ƒ^‚πΑ‚·	
//            return al;
//        }
        if (ACCastUtilities.toInt(map.get("7"), 1) != 2) {
        	//H”ο‚Ν•K—v‚Θ‚Ά‚½‚ίƒf[ƒ^‚πΑ‚·
        	return al;
        }
        //[ID:0000749][Shin Fujihara] 2012/10 edit end 2012”N“x‘Ξ‰ “Α’θ“όÒ‚Μ——πΗ—‹@”\

        // –‹Ζξ•ρ‚Μζ“Ύ
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
                // H”ο‚ΜƒƒR[ƒh
                if (this._1540121 <= 0) {
                    // H”ο‚ª0‰~Θ‰Ί‚Μκ‡
                    // Y“–ƒƒR[ƒh‚πν‚·‚ιB
                    al.remove(i);
                    // ν‚µ‚½‚½‚ίƒCƒ“ƒfƒbƒNƒX‚π1‚Β–ί‚·B
                    i--;
                } else {
                    // H”ο‚ª0‰~Θ‰Ί‚Ε‚Θ‚Άκ‡
                    // H”ο‚π‹Ζ–±‚©‚η“n‚³‚κ‚½’l‚Εγ‘‚«‚·‚ιB
                    mp.put("SERVICE_UNIT", new Integer(this._1540121));
                }
            } else if (SERVICE_CODE_UNIT_ROOM.equals(val)) {
                // ƒ†ƒjƒbƒg^ΒΊ‚ΜƒƒR[ƒh
                // ”ο—p’P‰Ώ‚ª0Θ‰Ί‚Εέ’θ‚³‚κ‚Δ‚Ά‚ικ‡A–ί‚θ’l‚©‚ην
                // ƒ†ƒjƒbƒg^ΒΊ‚Μ”ο—p’P‰Ώ‚πζ“Ύ
                int unitRoom = ACCastUtilities.toInt(
                        providerInfo.get(this.PATH_UNIT_ROOM), 0);
                if (unitRoom <= 0) {
                    // Y“–ƒƒR[ƒh‚πν‚·‚ιB
                    al.remove(i);
                    // ν‚µ‚½‚½‚ίƒCƒ“ƒfƒbƒNƒX‚π1‚Β–ί‚·B
                    i--;
                }
            } else if (SERVICE_CODE_UNIT_SEMI_ROOM.equals(val)) {
                // ƒ†ƒjƒbƒg^€ΒΊ‚ΜƒƒR[ƒh
                // ”ο—p’P‰Ώ‚ª0Θ‰Ί‚Εέ’θ‚³‚κ‚Δ‚Ά‚ικ‡A–ί‚θ’l‚©‚ην
                // ƒ†ƒjƒbƒg^€ΒΊ‚Μ”ο—p’P‰Ώ‚πζ“Ύ
                int unitSemiRoom = ACCastUtilities.toInt(
                        providerInfo.get(this.PATH_UNIT_SEMI_ROOM), 0);
                if (unitSemiRoom <= 0) {
                    // Y“–ƒƒR[ƒh‚πν‚·‚ιB
                    al.remove(i);
                    // ν‚µ‚½‚½‚ίƒCƒ“ƒfƒbƒNƒX‚π1‚Β–ί‚·B
                    i--;
                }
            } else if (SERVICE_CODE_NORMAL_ROOM.equals(val)) {
                // ]—^ΒΊ‚ΜƒƒR[ƒh
                // ”ο—p’P‰Ώ‚ª0Θ‰Ί‚Εέ’θ‚³‚κ‚Δ‚Ά‚ικ‡A–ί‚θ’l‚©‚ην
                // ]—^ΒΊ‚Μ”ο—p’P‰Ώ‚πζ“Ύ
                int normalRoom = ACCastUtilities.toInt(
                        providerInfo.get(this.PATH_NORMAL_ROOM), 0);
                if (normalRoom <= 0) {
                    // Y“–ƒƒR[ƒh‚πν‚·‚ιB
                    al.remove(i);
                    // ν‚µ‚½‚½‚ίƒCƒ“ƒfƒbƒNƒX‚π1‚Β–ί‚·B
                    i--;
                }
            } else if (SERVICE_CODE_TASHO_ROOM.equals(val)) {
                // ‘½°Ί‚ΜƒƒR[ƒh
                // ”ο—p’P‰Ώ‚ª0Θ‰Ί‚Εέ’θ‚³‚κ‚Δ‚Ά‚ικ‡A–ί‚θ’l‚©‚ην
                // ‘½°Ί‚Μ”ο—p’P‰Ώ‚πζ“Ύ
                int tashoRoom = ACCastUtilities.toInt(
                        providerInfo.get(this.PATH_TASHO_ROOM), 0);
                if (tashoRoom <= 0) {
                    // Y“–ƒƒR[ƒh‚πν‚·‚ιB
                    al.remove(i);
                    // ν‚µ‚½‚½‚ίƒCƒ“ƒfƒbƒNƒX‚π1‚Β–ί‚·B
                    i--;
                }
            }
        }

        return al;
    }
}
