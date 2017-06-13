package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * næ§^Êîì
 * 
 * @since V7.2.0
 * @author S.Hitaka
 * 
 */
public class SC_17811_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "næ§^Êîì";
    }

    public String getServiceCodeKind() {
        return "78";
    }

    public String getSystemServiceKindDetail() {
        return "17811";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // p[^o
        // =========================================================================
        // 1780101 {Ýæª
        int _1780101 = getIntValue(map, "1780101");

        // 1780102 Ôæª
        int _1780102 = getIntValue(map, "1780102");

        // 1780103 lõ¸Z
        int _1780103 = getIntValue(map, "1780103");

        // 1 vîìx
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 12 RÔnæÅÌT[rXñÁZ
        int _12 = getIntValue(map, "12", 1);

        // 1780104 üÁZ
        int _1780104 = getIntValue(map, "1780104");

        // 1780105 dxÒPAÌ§ÁZ
        int _1780105 = getIntValue(map, "1780105");

        // 1780106 ÂÊ@\Pûw±ÁZI^
        int _1780106 = getIntValue(map, "1780106");

        // 1780107 ÂÊ@\Pûw±ÁZII^
        int _1780107 = getIntValue(map, "1780107");

        // 1780108 FmÇÁZ
        int _1780108 = getIntValue(map, "1780108");

        // 1780109 áN«FmÇpÒóüÁZ
        int _1780109 = getIntValue(map, "1780109", 1);

        // 1780110 h{üPÁZ
        int _1780110 = getIntValue(map, "1780110");

        // 1780111 ûo@\üãÁZ
        int _1780111 = getIntValue(map, "1780111");

        // 1780112 ÂÊ}Ì§­»ÁZ
        int _1780112 = getIntValue(map, "1780112");

        // 1780113 üîÌ§­»ÁZ
        int _1780113 = getIntValue(map, "1780113");

        // 16 ¯ê¨ZÒÖÌT[rXñ
        int _16 = getIntValue(map, "16", 1);

        // 18 }¸Z
        int _18 = getIntValue(map, "18");

        // 1780114 T[rXñÌ§­»ÁZ
        int _1780114 = getIntValue(map, "1780114");

        // 17 îìEõöüPÁZ
        int _17 = getIntValue(map, Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // Æ©R[h¶¬
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // {Ýæª
        sb.append(CODE_CHAR[_1780101]);

        // Ôæª
        // Ã{ÊÌê
        if (_1780101 == 2) {
            sb.append(DEFAULT_CHAR);
            sb.append(CODE_CHAR[_1780102]);
        } else {
            sb.append(CODE_CHAR[_1780102]);
            sb.append(DEFAULT_CHAR);
        }

        // lõ¸Z
        sb.append(CODE_CHAR[_1780103]);

        // vîìx
        if (_1780101 == 2) {
            // Ã{ÊÌêAvîìxÍ³ÖW
            sb.append(Qkan10011_ServiceUnitGetter.DEFAULT_CHAR);
        } else {
            sb.append(CODE_CHAR[_1]);
        }

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ÁZ
        // ============================================================================
        // 8110 ÊîìRÔnæñÁZ
        if (_12 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
        }
        
        // üÁZ
        if (_1780104 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5301");
        }
        
        // dxÒPAÌ§ÁZ
        if (_1780105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5306");
        }
        
        // ÂÊ@\Pûw±ÁZI
        if (_1780106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5051");
        }
        
        // ÂÊ@\Pûw±ÁZII
        if (_1780107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5052");
        }
        
        // FmÇÁZ
        if (_1780108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5305");
        }
        
        // áN«FmÇpÒóüÁZ
        if (_1780109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // h{üPÁZ
        if (_1780110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5605");
        }
        
        // ûo@\üãÁZ
        if (_1780111 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5606");
        }
        
        // ÂÊ}Ì§­»ÁZ
        if (_1780112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5613");
        }
        
        // üîÌ§­»ÁZ
        if (_1780113 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5614");
        }
        
        // ¯ê¨ZÒÖÌT[rXñ
        if (_16 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5611");
        }
        
        // }¸Z
        switch (_18) {
        case 3: // 
            putSystemServiceCodeItem(sysSvcCdItems, "Z56122");
        case 2: // Ð¹
            putSystemServiceCodeItem(sysSvcCdItems, "Z56121");
            break;
        }
        
        
        // T[rXñÌ§ÁZ
        switch (_1780114) {
        // T[rXñÌ§ÁZIC
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");
            break;
        // T[rXñÌ§ÁZI
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        // T[rXñÌ§ÁZII
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        // T[rXñÌ§ÁZIII
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }
        
        // îìEõöüPðÔp
        switch(_17){
        // öüPÁZI
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2017.04
            break;
        // öüPÁZII
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");
            break;
        // öüPÁZIII
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        // öüPÁZIV
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
            break;
        // öüPÁZV
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
            break;
        }

        return sysSvcCdItems;
    }
}
