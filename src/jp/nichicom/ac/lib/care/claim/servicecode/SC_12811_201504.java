package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 地域密着型特定施設入居者生活介護（短期利用）
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_12811_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "地域密着型特定施設入居者生活介護(短期利用)";
    }

    public String getServiceCodeKind() {
        return "28";
    }

    public String getSystemServiceKindDetail() {
        return "12811";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1280101 人員減算
        int _1280101 = getIntValue(map, "1280101");

        // 1280102 夜間看護体制加算
        int _1280102 = getIntValue(map, "1280102");

        // 1280103 サービス提供体制強化加算 2015.04
        int _1280103 = getIntValue(map, "1280103", 1);

        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 独自コード生成
        // =========================================================================
        StringBuilder sb = new StringBuilder();

        // 要介護度
        sb.append(CODE_CHAR[_1]);
        // 人員減算
        sb.append(CODE_CHAR[_1280101]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // =========================================================================
        // 夜間看護体制加算
        if (_1280102 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2000");
        }

        // サービス提供体制加算
        switch (_1280103) {
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
        
        // 介護職員処遇改善を返却
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
