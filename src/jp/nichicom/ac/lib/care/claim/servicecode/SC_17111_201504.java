package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * –éŠÔ‘Î‰Œ^–K–â‰îŒì
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_17111_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "–éŠÔ‘Î‰Œ^–K–â‰îŒì";
    }

    public String getServiceCodeKind() {
        return "71";
    }

    public String getSystemServiceKindDetail() {
        return "17111";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // ƒpƒ‰ƒ[ƒ^’Šo
        // =========================================================================
        // 1710101 {İ‹æ•ª
        int _1710101 = getIntValue(map, "1710101", 1);

        // 1710102 ƒT[ƒrƒX‹æ•ª
        int _1710102 = getIntValue(map, "1710102", 1);

        // 1710104 ‘Î‰l”
        int _1710104 = getIntValue(map, "1710104", 1);

        // 1710106 “úŠ„
        int _1710106 = getIntValue(map, "1710106", 1);

        // 1710107 24ŠÔ’Ê•ñ‘Î‰‰ÁZ
        int _1710107 = getIntValue(map, "1710107", 1);

        // 1710108 ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‹­‰»‰ÁZ
        int _1710108 = getIntValue(map, "1710108", 1);

        // 1710109 Šî–{–éŠÔ–K–â I s’¬‘º“Æ©‰ÁZ
        int _1710109 = getIntValue(map, "1710109", 1);

        // 1710110 –éŠÔ–K–â‰îŒì II s’¬‘º“Æ©‰ÁZ
        int _1710110 = getIntValue(map, "1710110", 1);

        // Z’è‹æ•ª@1-’Êí 2-‰ÁZ‚Ì‚İ 3-Šî–{‚Ì‚İ
        int _9 = getIntValue(map, "9", 1);

        // 1710111 –K–â‚Ì•K—v«
        int _1710111 = getIntValue(map, "1710111", 1);

        // 17 ‰îŒìEˆõˆ‹ö‰ü‘P‰ÁZ
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // ‹¤’ÊŒn‚Ì‰ÁZ€–Ú
        // =========================================================================
        // 6136 –éŠÔ–K–â‰îŒì‚Q‚SŠÔ’Ê•ñ‘Î‰‰ÁZ
        if (_1710107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6136");
        }
        
        switch (_1710108) {
        case 4:
            // 6101 –éŠÔ–K–âƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡TƒC
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        case 2:
            // 6101 –éŠÔ–K–âƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡Tƒ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 5:
            // 6101 –éŠÔ–K–âƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡UƒC
            putSystemServiceCodeItem(sysSvcCdItems, "Z6110");//2015.04
            break;
        case 3:
            // 6102 –éŠÔ–K–âƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡Uƒ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        }
        
        // ‰îŒìEˆõˆ‹ö‰ü‘P‚ğ•Ô‹p
        switch (_17) {
        case 6:
            // –éŠÔ–K–â‰îŒìˆ‹ö‰ü‘P‰ÁZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6111");//2017.04
            break;
        case 5:
            // –éŠÔ–K–â‰îŒìˆ‹ö‰ü‘P‰ÁZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");//2015.04
            break;
        case 2:
            // –éŠÔ–K–â‰îŒìˆ‹ö‰ü‘P‰ÁZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        case 3:
            // –éŠÔ–K–â‰îŒìˆ‹ö‰ü‘P‰ÁZIV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
            break;
        case 4:
            // –éŠÔ–K–â‰îŒìˆ‹ö‰ü‘P‰ÁZV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");
            break;
        }
        
        
        // “úŠ„‚è‘I‘ğ
        if (_1710106 == 2) {
            
            // Šî–{–éŠÔ–K–â‡Ts’¬‘º“Æ©‰ÁZ
            switch (_1710109) {
            case 1:
                break;
            case 2:
                // Šî–{–éŠÔ–K–â‡Ts’¬‘º“Æ©‰ÁZ‚P“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7202");
                break;
            case 3:
                // Šî–{–éŠÔ–K–â‡Ts’¬‘º“Æ©‰ÁZ‚Q“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7204");
                break;
            case 4:
                // Šî–{–éŠÔ–K–â‡Ts’¬‘º“Æ©‰ÁZ‚R“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7206");
                break;
            case 5:
                // Šî–{–éŠÔ–K–â‡Ts’¬‘º“Æ©‰ÁZ‚S“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7208");
                break;
            case 6:
                // Šî–{–éŠÔ–K–â‡Ts’¬‘º“Æ©‰ÁZ‚T“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7210");
                break;
            case 7:
                // Šî–{–éŠÔ–K–â‡Ts’¬‘º“Æ©‰ÁZ‚U“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7212");
                break;
            }
            
            
            // –éŠÔ–K–â‡Us’¬‘º“Æ©‰ÁZ
            switch (_1710110) {
            case 1:
                break;
            case 2:
                // –éŠÔ–K–â‡Us’¬‘º“Æ©‰ÁZ‚P“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7302");
                break;
            case 3:
                // –éŠÔ–K–â‡Us’¬‘º“Æ©‰ÁZ‚Q“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7304");
                break;
            case 4:
                // –éŠÔ–K–â‡Us’¬‘º“Æ©‰ÁZ‚R“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7306");
                break;
            case 5:
                // –éŠÔ–K–â‡Us’¬‘º“Æ©‰ÁZ‚S“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7308");
                break;
            case 6:
                // –éŠÔ–K–â‡Us’¬‘º“Æ©‰ÁZ‚T“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7310");
                break;
            case 7:
                // –éŠÔ–K–â‡Us’¬‘º“Æ©‰ÁZ‚U“úŠ„
                putSystemServiceCodeItem(sysSvcCdItems, "Z7312");
                break;
            }

            
        // “úŠ„‚èˆÈŠO‚Ì’Êí
        } else {
            
            // Šî–{–éŠÔ–K–â‡Ts’¬‘º“Æ©‰ÁZ
            switch (_1710109) {
            case 1:
                break;
            case 2:
                // Šî–{–éŠÔ–K–â‡Ts’¬‘º“Æ©‰ÁZ‚P
                putSystemServiceCodeItem(sysSvcCdItems, "Z7201");
                break;
            case 3:
                // Šî–{–éŠÔ–K–â‡Ts’¬‘º“Æ©‰ÁZ‚Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z7203");
                break;
            case 4:
                // Šî–{–éŠÔ–K–â‡Ts’¬‘º“Æ©‰ÁZ‚R
                putSystemServiceCodeItem(sysSvcCdItems, "Z7205");
                break;
            case 5:
                // Šî–{–éŠÔ–K–â‡Ts’¬‘º“Æ©‰ÁZ‚S
                putSystemServiceCodeItem(sysSvcCdItems, "Z7207");
                break;
            case 6:
                // Šî–{–éŠÔ–K–â‡Ts’¬‘º“Æ©‰ÁZ‚T
                putSystemServiceCodeItem(sysSvcCdItems, "Z7209");
                break;
            case 7:
                // Šî–{–éŠÔ–K–â‡Ts’¬‘º“Æ©‰ÁZ‚U
                putSystemServiceCodeItem(sysSvcCdItems, "Z7211");
                break;
            }
            
            
            //  –éŠÔ–K–â‰îŒì‡Us’¬‘º“Æ©‰ÁZ
            switch (_1710110) {
            case 1:
                break;
            case 2:
                // –éŠÔ–K–â‰îŒì‡Us’¬‘º“Æ©‰ÁZ‚P
                putSystemServiceCodeItem(sysSvcCdItems, "Z7301");
                break;
            case 3:
                // –éŠÔ–K–â‰îŒì‡Us’¬‘º“Æ©‰ÁZ‚Q
                putSystemServiceCodeItem(sysSvcCdItems, "Z7303");
                break;
            case 4:
                // –éŠÔ–K–â‰îŒì‡Us’¬‘º“Æ©‰ÁZ‚R
                putSystemServiceCodeItem(sysSvcCdItems, "Z7305");
                break;
            case 5:
                // –éŠÔ–K–â‰îŒì‡Us’¬‘º“Æ©‰ÁZ‚S
                putSystemServiceCodeItem(sysSvcCdItems, "Z7307");
                break;
            case 6:
                // –éŠÔ–K–â‰îŒì‡Us’¬‘º“Æ©‰ÁZ‚T
                putSystemServiceCodeItem(sysSvcCdItems, "Z7309");
                break;
            case 7:
                // –éŠÔ–K–â‰îŒì‡Us’¬‘º“Æ©‰ÁZ‚U
                putSystemServiceCodeItem(sysSvcCdItems, "Z7311");
                break;
            }
        }
        

        // “Æ©ƒR[ƒh¶¬
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        if (_1710101 == 1) {
            // Šî–{•ª
            sb.append(CODE_CHAR[_1710101]); // {İ‹æ•ª
            sb.append(DEFAULT_CHAR); // ƒT[ƒrƒX‹æ•ª
            sb.append(DEFAULT_CHAR); // ‘Î‰l”
            sb.append(DEFAULT_CHAR); // –K–â‚Ì•K—v«
            sb.append(CODE_CHAR[_1710106]); // “úŠ„
            sb.append(CODE_CHAR[2]); // Šî–{‹æ•ª
            putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

            // ==================================
            // ‰ÁZ•”•ª
            // ==================================
            // Z’è‹æ•ª‚ªu3-Šî–{‚Ì‚İv‚Ìê‡‚ÍƒXƒLƒbƒv‚·‚é
            if (_9 != 3) {

                // u’èŠú„‰ñvu–K–â‡Tvu–K–â‡Uv‚ÌƒR[ƒh‚ğ
                // ‰ñ”•ª‚¾‚¯ƒR[ƒh‚ğ’Ç‰Á‚·‚éB
                sb = new StringBuilder();
                sb.append(CODE_CHAR[_1710101]); // {İ‹æ•ª
                sb.append(CODE_CHAR[_1710102]); // ƒT[ƒrƒX‹æ•ª
                sb.append(CODE_CHAR[_1710104]); // ‘Î‰l”
                sb.append(CODE_CHAR[_1710111]); // –K–â‚Ì•K—v«
                sb.append(DEFAULT_CHAR); // “úŠ„
                sb.append(DEFAULT_CHAR); // Šî–{‹æ•ª
                putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

            }
        } else {
            sb.append(CODE_CHAR[_1710101]); // {İ‹æ•ª
            sb.append(CODE_CHAR[_1710102]); // ƒT[ƒrƒX‹æ•ª
            sb.append(CODE_CHAR[_1710104]); // ‘Î‰l”
            sb.append(CODE_CHAR[_1710111]); // –K–â‚Ì•K—v«
            sb.append(CODE_CHAR[_1710106]); // “úŠ„
            sb.append(DEFAULT_CHAR); // Šî–{‹æ•ª
            putSystemServiceCodeItem(sysSvcCdItems, sb.toString());
        }

        return sysSvcCdItems;
    }
}
