package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SC_17211_201504 extends Qkan10011_ServiceUnitGetter {

    public String getServiceName() {
        return "認知症対応型通所介護";
    }

    public String getServiceCodeKind() {
        return "72";
    }

    public String getSystemServiceKindDetail() {
        return "17211";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1720101 施設区分
        int _1720101 = getIntValue(map, "1720101");

        // 1720102 区分
        int _1720102 = getIntValue(map, "1720102");

        // 1720103 時間区分
        int _1720103 = getIntValue(map, "1720103");

        // 1720104 人員減算
        int _1720104 = getIntValue(map, "1720104");

        // 1720107 個別機能訓練指導加算
        int _1720107 = getIntValue(map, "1720107");

        // 1720106 入浴介助加算
        int _1720106 = getIntValue(map, "1720106");

        // 1720105 栄養改善加算
        int _1720105 = getIntValue(map, "1720105");

        // 1720108 口腔機能向上加算
        int _1720108 = getIntValue(map, "1720108");

        // 1720109 若年性認知症利用者受入加算
        int _1720109 = getIntValue(map, "1720109");

        // 1720110 サービス提供体制強化加算
        int _1720110 = getIntValue(map, "1720110");

        // 16 同一建物居住者へのサービス提供
        int _16 = getIntValue(map, "16");
        
        // 18 送迎減算
        int _18 = getIntValue(map, "18");

        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設区分
        sb.append(CODE_CHAR[_1720101]);

        // 区分
        sb.append(CODE_CHAR[_1720102]);

        // 時間区分
        sb.append(CODE_CHAR[_1720103]);

        // 人員減算
        sb.append(CODE_CHAR[_1720104]);

        // 要介護度
        sb.append(CODE_CHAR[_1]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================

        // 入浴介助加算
        if (_1720106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5301");
        }
        
        // 個別機能訓練指導加算
        if (_1720107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5050");
        }
        
        // 6109 予認通所介護若年性認知症受入加算
        if (_1720109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }

        // 栄養改善加算
        if (_1720105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5606");
        }
        
        // 口腔機能向上加算
        if (_1720108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5607");
        }

        // 認知通所介護送迎減算(同一建物居住者へのサービス提供)
        if (_16 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5611");
        }

        // 送迎減算
        switch (_18) {
        case 3: // 往復
            putSystemServiceCodeItem(sysSvcCdItems, "Z56122");//2015.04
        case 2: // 片道
            putSystemServiceCodeItem(sysSvcCdItems, "Z56121");//2015.04
            break;
        }
        
        switch (_1720110) {
        case 4:
            // 6100 予認通介サービス提供体制加算Iイ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        case 2:
            // 6101 予認通介サービス提供体制加算Iロ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // 6102 予認通介サービス提供体制加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        }

        // 介護職員処遇改善を返却
        switch (_17) {
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");//2017.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
            break;
        }

        return sysSvcCdItems;
    }

}
