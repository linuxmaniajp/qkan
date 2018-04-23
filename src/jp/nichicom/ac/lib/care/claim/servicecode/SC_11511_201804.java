package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 通所介護
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_11511_201804 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "通所介護";
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

        // パラメータ抽出
        // =========================================================================
        // 1150113 施設区分
        int _1150113 = getIntValue(map, "1150113");

        // 1150104 時間区分
        int _1150104 = getIntValue(map, "1150104");

        // 1150108 人員減算
        int _1150108 = getIntValue(map, "1150108");

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1150119 個別機能訓練指導加算I型
        int _1150119 = getIntValue(map, "1150119");
        
        // 1150120 個別機能訓練指導加算II型
        int _1150120 = getIntValue(map, "1150120");

        // 1150106 入浴加算
        int _1150106 = getIntValue(map, "1150106");

        // 1150115 若年性認知症利用者受入加算
        int _1150115 = getIntValue(map, "1150115", 1);

        // 1150116 栄養改善加算
        int _1150116 = getIntValue(map, "1150116");

        // 1150112 口腔機能向上加算
        int _1150112 = getIntValue(map, "1150112");

        // 12 中山間地域等でのサービス提供加算
        int _12 = getIntValue(map, "12", 1);

        // 1150117 サービス提供体制強化加算
        int _1150117 = getIntValue(map, "1150117");
        
        // 1150121	認知症加算
        int _1150121 = getIntValue(map, "1150121");
        
        // 1150122	中重度者ケア体制加算
        int _1150122 = getIntValue(map, "1150122");
        
        // 1150123	個別送迎体制強化加算
        int _1150123 = getIntValue(map, "1150123");
        
        // 1150124	入浴介助体制強化加算
        int _1150124 = getIntValue(map, "1150124");

        // 16 同一建物居住者へのサービス提供
        int _16 = getIntValue(map, "16", 1);
        
        // 18 送迎減算
        int _18 = getIntValue(map, "18");

        // 22 共生型
        int _22 = getIntValue(map, "22", 1);
        
        // 1150126	生活機能向上連携加算
        int _1150126 = getIntValue(map, "1150126");
        
        // 1150127	ADL維持等加算
        int _1150127 = getIntValue(map, "1150127");
        
        // 1150128	栄養スクリーニング加算
        int _1150128 = getIntValue(map, "1150128");
        
        // 1150125	生活相談員配置等加算
        int _1150125 = getIntValue(map, "1150125");
        
        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map, Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設区分
        sb.append(CODE_CHAR[_1150113]);

        // 時間区分
        sb.append(CODE_CHAR[_1150104]);

        // 人員減算
        sb.append(CODE_CHAR[_1150108]);

        // 要介護度
        sb.append(CODE_CHAR[_1]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        // 8110 通所介護中山間地域等提供加算
        if (_12 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
        }
        
        // 入浴加算
        if (_1150106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5301");
        }
        
        // 個別機能訓練指導加算I
        if (_1150119 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5051");
        }
        
        // 個別機能訓練指導加算II
        if (_1150120 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5052");
        }
        
        // 若年性認知症利用者受入加算
        if (_1150115 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // 栄養改善加算
        if (_1150116 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5605");
        }
        
        // 口腔機能向上加算
        if (_1150112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5606");
        }
        
        // 同一建物居住者へのサービス提供
        if (_16 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5611");
        }
        
        // 1150121	認知症加算
        if (_1150121 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5305"); //2015.04
        }
        
        // 1150122	中重度者ケア体制加算
        if (_1150122 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5306"); //2015.04
        }
        
        // 1150123	個別送迎体制強化加算
        if (_1150123 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5613"); //2015.04
        }
        
        // 1150124	入浴介助体制強化加算
        if (_1150124 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5614"); //2015.04
        }
        

        // 1150126	生活機能向上連携加算
        if (_1150126 > 1) {
        	if (_1150119 > 1 || _1150120 > 1) { //個別機能訓練指導加算を算定している場合
        		putSystemServiceCodeItem(sysSvcCdItems, "Z4003"); //2018.04
        	} else {
        		putSystemServiceCodeItem(sysSvcCdItems, "Z4002"); //2018.04
        	}
        }
        
        // 1150127	ADL維持等加算
        switch (_1150127) {
        case 2: // I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6340"); //2018.04
            break;
        case 3: // II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6341"); //2018.04
            break;
        }
        
        // 1150128	栄養スクリーニング加算
        if (_1150128 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6201"); //2018.04
        }
        
        // 1150125	生活相談員配置等加算
        if (_1150125 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6350"); //2018.04
        }
        
        
        // 送迎減算
        switch (_18) {
        case 3: // 往復
            putSystemServiceCodeItem(sysSvcCdItems, "Z56122"); //2015.04
        case 2: // 片道
            putSystemServiceCodeItem(sysSvcCdItems, "Z56121"); //2015.04
            break;
        }
        
        
        // 通所介護サービス提供体制加算
        switch (_1150117) {
        // 6101 通所介護サービス提供体制加算Iイ
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100"); //2015.04
            break;
        // 6101 通所介護サービス提供体制加算Iロ
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        // 6102 通所介護サービス提供体制加算II
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        // 6103 通所介護サービス提供体制加算III
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }
        
        // 共生型 //2018.04
        switch (_22) {
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6364");
            break;
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6365");
            break;
        case 7:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6366");
            break;
        case 8:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6367");
            break;
        }
        
        // 介護職員処遇改善を返却
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
