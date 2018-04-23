package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 特定施設入居者生活介護（短期利用）
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_12711_201804 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "特定施設入居者生活介護(短期利用)";
    }

    public String getServiceCodeKind() {
        return "27";
    }

    public String getSystemServiceKindDetail() {
        return "12711";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================
        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));
        
        // 1270101 人員減算
        int _1270101 = getIntValue(map, "1270101");

        // 1270102 夜間看護体制加算
        int _1270102 = getIntValue(map, "1270102");
        
        // 1270104 若年性認知症受入加算
        int _1270104 = getIntValue(map, "1270104");        
        
        // 1270103 サービス提供体制強化加算
        int _1270103 = getIntValue(map, "1270103", 1);

        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 独自コード生成
        // =========================================================================
        StringBuilder sb = new StringBuilder();
        
        // 要介護度
        sb.append(CODE_CHAR[_1]);

        // 人員減算
        sb.append(CODE_CHAR[_1270101]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // =========================================================================
        // 夜間看護体制加算
        if (_1270102 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z1160");
        }
        
        // 1270104 若年性認知症受入加算
        if (_1270104 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");//2018.04
        }
        
        // サービス提供体制加算
        switch (_1270103) {
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
