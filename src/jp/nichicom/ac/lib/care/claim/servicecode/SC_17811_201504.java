package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 地域密着型通所介護
 * 
 * @since V7.2.0
 * @author S.Hitaka
 * 
 */
public class SC_17811_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "地域密着型通所介護";
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

        // パラメータ抽出
        // =========================================================================
        // 1780101 施設区分
        int _1780101 = getIntValue(map, "1780101");

        // 1780102 時間区分
        int _1780102 = getIntValue(map, "1780102");

        // 1780103 人員減算
        int _1780103 = getIntValue(map, "1780103");

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 12 中山間地域等でのサービス提供加算
        int _12 = getIntValue(map, "12", 1);

        // 1780104 入浴加算
        int _1780104 = getIntValue(map, "1780104");

        // 1780105 中重度者ケア体制加算
        int _1780105 = getIntValue(map, "1780105");

        // 1780106 個別機能訓練指導加算I型
        int _1780106 = getIntValue(map, "1780106");

        // 1780107 個別機能訓練指導加算II型
        int _1780107 = getIntValue(map, "1780107");

        // 1780108 認知症加算
        int _1780108 = getIntValue(map, "1780108");

        // 1780109 若年性認知症利用者受入加算
        int _1780109 = getIntValue(map, "1780109", 1);

        // 1780110 栄養改善加算
        int _1780110 = getIntValue(map, "1780110");

        // 1780111 口腔機能向上加算
        int _1780111 = getIntValue(map, "1780111");

        // 1780112 個別送迎体制強化加算
        int _1780112 = getIntValue(map, "1780112");

        // 1780113 入浴介助体制強化加算
        int _1780113 = getIntValue(map, "1780113");

        // 16 同一建物居住者へのサービス提供
        int _16 = getIntValue(map, "16", 1);

        // 18 送迎減算
        int _18 = getIntValue(map, "18");

        // 1780114 サービス提供体制強化加算
        int _1780114 = getIntValue(map, "1780114");

        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map, Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設区分
        sb.append(CODE_CHAR[_1780101]);

        // 時間区分
        // 療養通所の場合
        if (_1780101 == 2) {
            sb.append(DEFAULT_CHAR);
            sb.append(CODE_CHAR[_1780102]);
        } else {
            sb.append(CODE_CHAR[_1780102]);
            sb.append(DEFAULT_CHAR);
        }

        // 人員減算
        sb.append(CODE_CHAR[_1780103]);

        // 要介護度
        if (_1780101 == 2) {
            // 療養通所の場合、要介護度は無関係
            sb.append(Qkan10011_ServiceUnitGetter.DEFAULT_CHAR);
        } else {
            sb.append(CODE_CHAR[_1]);
        }

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        // 8110 通所介護中山間地域等提供加算
        if (_12 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
        }
        
        // 入浴加算
        if (_1780104 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5301");
        }
        
        // 中重度者ケア体制加算
        if (_1780105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5306");
        }
        
        // 個別機能訓練指導加算I
        if (_1780106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5051");
        }
        
        // 個別機能訓練指導加算II
        if (_1780107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5052");
        }
        
        // 認知症加算
        if (_1780108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5305");
        }
        
        // 若年性認知症利用者受入加算
        if (_1780109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // 栄養改善加算
        if (_1780110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5605");
        }
        
        // 口腔機能向上加算
        if (_1780111 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5606");
        }
        
        // 個別送迎体制強化加算
        if (_1780112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5613");
        }
        
        // 入浴介助体制強化加算
        if (_1780113 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5614");
        }
        
        // 同一建物居住者へのサービス提供
        if (_16 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5611");
        }
        
        // 送迎減算
        switch (_18) {
        case 3: // 往復
            putSystemServiceCodeItem(sysSvcCdItems, "Z56122");
        case 2: // 片道
            putSystemServiceCodeItem(sysSvcCdItems, "Z56121");
            break;
        }
        
        
        // サービス提供体制加算
        switch (_1780114) {
        // サービス提供体制加算Iイ
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");
            break;
        // サービス提供体制加算Iロ
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        // サービス提供体制加算II
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        // サービス提供体制加算III
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }
        
        // 介護職員処遇改善を返却
        switch(_17){
        // 処遇改善加算I
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2017.04
            break;
        // 処遇改善加算II
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");
            break;
        // 処遇改善加算III
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        // 処遇改善加算IV
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
            break;
        // 処遇改善加算V
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
            break;
        }

        return sysSvcCdItems;
    }
}
