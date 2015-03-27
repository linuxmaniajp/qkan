package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 介護予防認知症対応型通所介護
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_17411_201504 extends Qkan10011_ServiceUnitGetter {

    public String getServiceName() {
        return "介護予防認知症対応型通所介護";
    }

    public String getServiceCodeKind() {
        return "74";
    }

    public String getSystemServiceKindDetail() {
        return "17411";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1740101 施設等の区分1　1-Ⅰ型 2-Ⅱ型
        int _1740101 = getIntValue(map, "1740101", 1);

        // 1740102 施設等の区分2　1-単独型 2-併設型
        int _1740102 = getIntValue(map, "1740102", 1);

        // 1740103 時間区分　1-2～3時間 2-3～4時間 3-4～6時間 4-6～8時間 5-8～9時間 6-9～10時間
        int _1740103 = getIntValue(map, "1740103", 1);

        // 1740104 人員減算　1-なし 2-定員超過 3-看護・介護職員の不足
        int _1740104 = getIntValue(map, "1740104", 1);

        // 1740105 入浴介助加算　1-なし 2-あり
        int _1740105 = getIntValue(map, "1740105", 1);

        // 1740106 個別機能訓練指導加算　1-なし 2-あり
        int _1740106 = getIntValue(map, "1740106", 1);

        // 1740107 栄養改善加算　1-なし 2-あり
        int _1740107 = getIntValue(map, "1740107", 1);

        // 1740108 口腔機能向上加算　1-なし 2-あり
        int _1740108 = getIntValue(map, "1740108", 1);

        // 1740109 若年性認知症利用者受入加算　1-なし 2-あり
        int _1740109 = getIntValue(map, "1740109", 1);

        // 1740110 サービス提供体制強化加算　1-なし 2-I型 3-II型
        int _1740110 = getIntValue(map, "1740110", 1);

        // 16 同一建物居住者へのサービス提供
        int _16 = getIntValue(map, "16", 1);
        
        // 18 送迎減算
        int _18 = getIntValue(map, "18");

        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設等の区分1　1-Ⅰ型 2-Ⅱ型
        sb.append(CODE_CHAR[_1740101]);

        // 施設等の区分2　1-単独型 2-併設型
        sb.append(CODE_CHAR[_1740102]);

        // 時間区分　1-2～3時間 2-3～4時間 3-4～6時間 4-6～8時間 5-8～9時間 6-9～10時間
        sb.append(CODE_CHAR[_1740103]);

        // 要介護度
        sb.append(CODE_CHAR[_1]);

        // 人員減算　1-なし 2-定員超過 3-看護・介護職員の不足あり
        sb.append(CODE_CHAR[_1740104]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================

        // 入浴介助加算　1-なし 2-あり
        if (_1740105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5301");
        }
        
        // 個別機能訓練指導加算　1-なし 2-あり
        if (_1740106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5050");
        }
        
        // 6109 予認通所介護若年性認知症受入加算
        if (_1740109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // 栄養改善加算　1-なし 2-あり
        if (_1740107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5606");
        }
        
        // 口腔機能向上加算　1-なし 2-あり
        if (_1740108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5607");
        }
        
        // 同一建物居住者へのサービス提供 1-なし 2-あり
        if (_16 > 1) {
            // 予認通所介護送迎減算
            putSystemServiceCodeItem(sysSvcCdItems, "Z5611");
        }
        
        // 送迎減算
        switch (_18) {
        case 3: // 往復
            putSystemServiceCodeItem(sysSvcCdItems, "Z56122");	//TODO:コード値確認
        case 2: // 片道
            putSystemServiceCodeItem(sysSvcCdItems, "Z56121");	//TODO:コード値確認
            break;
        }
        
        switch (_1740110) {
        case 4:
            // 6100 予認通介サービス提供体制加算Iイ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");	//TODO:コード値確認
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
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");	//TODO:コード値確認
            break;
        case 2:
            // 予認通所介護処遇改善加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        case 3:
            // 予認通所介護処遇改善加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        case 4:
            // 予認通所介護処遇改善加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
            break;
        }

        return sysSvcCdItems;
    }
}
