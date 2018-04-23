package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 小規模多機能型居宅介護
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_16811_201804 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "小規模多機能型居宅介護(短期利用)";
    }

    public String getServiceCodeKind() {
        return "68";
    }

    public String getSystemServiceKindDetail() {
        return "16811";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================
        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1680101 人員減算 1-なし 2-定員超過 3-介護従業員不足
        int _1680101 = getIntValue(map, "1680101");

        // 1680102 サービス提供体制強化加算
        int _1680102 = getIntValue(map, "1680102");

        // 1680104 生活機能向上連携加算
        int _1680104 = getIntValue(map, "1680104", 1);
        
        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);



        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();


        // 要介護度
        sb.append(CODE_CHAR[_1]);
        // 人員減算 1-なし 2-定員超過 3-介護従業員不足
        sb.append(CODE_CHAR[_1680101]);

        

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        
        // 1680104 生活機能向上連携加算
        switch(_1680104) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4002");//2018.04
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4003");//2018.04
            break;
        }
        
        switch (_1680102) {
        case 5:
            //  小多機能型サービス提供体制加算Iイ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        case 2:
            // 6101 小多機能型サービス提供体制加算Iロ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");//2015.04
            break;
        case 3:
            // 6102 小多機能型サービス提供体制加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");//2015.04
            break;
        case 4:
            // 6103 小多機能型サービス提供体制加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");//2015.04
            break;
        }

        // 介護職員処遇改善を返却
        switch (_17) {
        case 6:
            // 小規模多機能型処遇改善加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6112");//2017.04
            break;
        case 5:
            // 小規模多機能型処遇改善加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6110");//2015.04
            break;
        case 2:
            // 小規模多機能型処遇改善加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");//2015.04
            break;
        case 3:
            // 小規模多機能型処遇改善加算IV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");//2015.04
            break;
        case 4:
            // 小規模多機能型処遇改善加算V
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2015.04
            break;
        }

        return sysSvcCdItems;
    }
}
