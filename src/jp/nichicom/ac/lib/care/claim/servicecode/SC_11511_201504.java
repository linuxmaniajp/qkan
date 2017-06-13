package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Êîì
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_11511_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "Êîì";
    }

    public String getServiceCodeKind() {
        return "15";
    }

    public String getSystemServiceKindDetail() {
        return "11511";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // p[^o
        // =========================================================================
        // 1150113 {Ýæª
        int _1150113 = getIntValue(map, "1150113");

        // 1150104 Ôæª
        int _1150104 = getIntValue(map, "1150104");

        // 1150108 lõ¸Z
        int _1150108 = getIntValue(map, "1150108");

        // 1 vîìx
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1150119 ÂÊ@\Pûw±ÁZI^
        int _1150119 = getIntValue(map, "1150119");
        
        // 1150120 ÂÊ@\Pûw±ÁZII^
        int _1150120 = getIntValue(map, "1150120");

        // 1150106 üÁZ
        int _1150106 = getIntValue(map, "1150106");

        // 1150115 áN«FmÇpÒóüÁZ
        int _1150115 = getIntValue(map, "1150115", 1);

        // 1150116 h{üPÁZ
        int _1150116 = getIntValue(map, "1150116");

        // 1150112 ûo@\üãÁZ
        int _1150112 = getIntValue(map, "1150112");

        // 12 RÔnæÅÌT[rXñÁZ
        int _12 = getIntValue(map, "12", 1);

        // 1150117 T[rXñÌ§­»ÁZ
        int _1150117 = getIntValue(map, "1150117");
        
        // 1150121	FmÇÁZ
        int _1150121 = getIntValue(map, "1150121");
        
        // 1150122	dxÒPAÌ§ÁZ
        int _1150122 = getIntValue(map, "1150122");
        
        // 1150123	ÂÊ}Ì§­»ÁZ
        int _1150123 = getIntValue(map, "1150123");
        
        // 1150124	üîÌ§­»ÁZ
        int _1150124 = getIntValue(map, "1150124");

        // 16 ¯ê¨ZÒÖÌT[rXñ
        int _16 = getIntValue(map, "16", 1);
        
        // 18 }¸Z
        int _18 = getIntValue(map, "18");
        
        // 17 îìEõöüPÁZ
        int _17 = getIntValue(map, Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // Æ©R[h¶¬
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // {Ýæª
        sb.append(CODE_CHAR[_1150113]);

        // Ôæª
        // Ã{ÊÌê
        if (_1150113 == 5) {
            sb.append(DEFAULT_CHAR);
            sb.append(CODE_CHAR[_1150104]);
        } else {
            sb.append(CODE_CHAR[_1150104]);
            sb.append(DEFAULT_CHAR);
        }

        // lõ¸Z
        sb.append(CODE_CHAR[_1150108]);

        // vîìx
        if (_1150113 == 5) {
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
        if (_1150106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5301");
        }
        
        // ÂÊ@\Pûw±ÁZI
        if (_1150119 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5051");
        }
        
        // ÂÊ@\Pûw±ÁZII
        if (_1150120 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5052");
        }
        
        // áN«FmÇpÒóüÁZ
        if (_1150115 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // h{üPÁZ
        if (_1150116 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5605");
        }
        
        // ûo@\üãÁZ
        if (_1150112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5606");
        }
        
        // ¯ê¨ZÒÖÌT[rXñ
        if (_16 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5611");
        }
        
        // 1150121	FmÇÁZ
        if (_1150121 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5305"); //2015.04
        }
        
        // 1150122	dxÒPAÌ§ÁZ
        if (_1150122 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5306"); //2015.04
        }
        
        // 1150123	ÂÊ}Ì§­»ÁZ
        if (_1150123 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5613"); //2015.04
        }
        
        // 1150124	üîÌ§­»ÁZ
        if (_1150124 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5614"); //2015.04
        }
        
        // }¸Z
        switch (_18) {
        case 3: // 
            putSystemServiceCodeItem(sysSvcCdItems, "Z56122"); //2015.04
        case 2: // Ð¹
            putSystemServiceCodeItem(sysSvcCdItems, "Z56121"); //2015.04
            break;
        }
        
        
        // ÊîìT[rXñÌ§ÁZ
        switch (_1150117) {
        // 6101 ÊîìT[rXñÌ§ÁZIC
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100"); //2015.04
            break;
        // 6101 ÊîìT[rXñÌ§ÁZI
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        // 6102 ÊîìT[rXñÌ§ÁZII
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        // 6103 ÊîìT[rXñÌ§ÁZIII
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }
        
        // îìEõöüPðÔp
        switch(_17){
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");	//2017.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");	//2015.04
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
}
