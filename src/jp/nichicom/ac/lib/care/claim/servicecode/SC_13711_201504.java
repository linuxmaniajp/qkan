package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 介護予防認知症対応型共同生活介護(短期利用以外)
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_13711_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "介護予防認知症対応型共同生活介護(短期利用以外)";
    }

    public String getServiceCodeKind() {
        return "37";
    }

    public String getSystemServiceKindDetail() {
        return "13711";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1370101 初期加算　1-なし 2-あり
        int _1370101 = getIntValue(map, "1370101", 1);

        // 1370102 人員減算　1-なし 2-定員超過 3-介護従業員の不足
        int _1370102 = getIntValue(map, "1370102", 1);

        // 1370103 夜間勤務条件基準　1-満たしている 2-満たしていない
        int _1370103 = getIntValue(map, "1370103", 1);

        // 1370104 夜間支援体制加算
        int _1370104 = getIntValue(map, "1370104", 1);

        // 1370105 若年性認知症利用者受入加算
        int _1370105 = getIntValue(map, "1370105", 1);

        // 1370106 認知症専門ケア加算
        int _1370106 = getIntValue(map, "1370106", 1);

        // 1370108 退居時相談援助加算
        int _1370108 = getIntValue(map, "1370108", 1);

        // 1370107 サービス提供体制強化加算
        int _1370107 = getIntValue(map, "1370107", 1);

        // 1370109 施設等の区分
        int _1370109 = getIntValue(map, "1370109", 1);

        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        
        // 加算のみ(退院時共同指導加算対応)
        int _9 = getIntValue(map, "9");
        
        // 単独加算のみ---------------------------------------------------------------
        // 単独加算サービス
        if (_9 == 2) {
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            
            // 初期加算　1-なし 2-あり
            if (_1370101 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z1550");
            }

            // 予認知症対応退居時相談援助加算 2015.04 一応足した
            if (_1370108 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6502");
            }
            
            // 介護職員処遇改善を返却
            switch (_17) {
            case 6:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2017.04
                break;
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6107");//2015.04
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
        
        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設等の区分
        sb.append(CODE_CHAR[_1370109]);

        // 要介護度
        sb.append(CODE_CHAR[_1]);

        // 夜間勤務条件基準　1-満たしている 2-満たしていない
        sb.append(CODE_CHAR[_1370103]);

        // 人員減算　1-なし 2-定員超過 3-介護従業員の不足
        sb.append(CODE_CHAR[_1370102]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================

        // 予認知症対応夜間支援体制加算
        if (_1370104 > 1) {
            //施設区分により分岐
            switch (_1370109) {
            case 1: // I型
                putSystemServiceCodeItem(sysSvcCdItems, "Z6161");//2015.04
                break;
            case 2: // II型
                putSystemServiceCodeItem(sysSvcCdItems, "Z6171");//2015.04
                break;
            }
        }
        
        // 6109 予認知症対応若年性認知症受入加算
        if (_1370105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // 初期加算　1-なし 2-あり
        if (_1370101 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z1550");
        }
        
        // 6502 予認知症対応退居時相談援助加算
        if (_1370108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6502");
        }
        
        switch (_1370106) {
        case 2:
            // 6133 予認知症対応認知症専門ケア加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6133");
            break;
        case 3:
            // 6134 予認知症対応認知症専門ケア加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6134");
            break;
        }
        
        switch (_1370107) {
        case 5:
            // 6100 予認知対応サービス提供体制加算Iイ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        case 2:
            // 6101 予認知対応サービス提供体制加算Iロ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // 6102 予認知対応サービス提供体制加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
            // 6103 予認知対応サービス提供体制加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }
        
        // 介護職員処遇改善を返却
        switch (_17) {
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2017.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");//2015.04
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
