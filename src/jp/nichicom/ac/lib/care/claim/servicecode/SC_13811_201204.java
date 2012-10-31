package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 認知症対応型共同生活介護(短期利用)
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_13811_201204 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "認知症対応型共同生活介護(短期利用)";
    }

    public String getServiceCodeKind() {
        return "38";
    }

    public String getSystemServiceKindDetail() {
        return "13811 ";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================
        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1380102 夜間勤務条件基準 1-満たしている 2-満たしていない
        int _1380102 = getIntValue(map, "1380102");

        // 1380101 人員減算 1-なし 2-定員超過 3-介護従業員不足
        int _1380101 = getIntValue(map, "1380101");

        // 1380103 医療連携体制加算 1-なし 2-あり
        int _1380103 = getIntValue(map, "1380103");

        // 1380104 夜間ケア加算
        int _1380104 = getIntValue(map, "1380104");

        // 1380108 認知症行動・心理症状緊急対応加算
        int _1380108 = getIntValue(map, "1380108");

        // 1380105 若年性認知症利用者受入加算
        int _1380105 = getIntValue(map, "1380105");

        // 1380107 サービス提供体制強化加算
        int _1380107 = getIntValue(map, "1380107");

        // 1380110 施設等の区分
        int _1380110 = getIntValue(map, "1380110", 1);

        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設等の区分
        sb.append(CODE_CHAR[_1380110]);

        // 要介護度
        sb.append(CODE_CHAR[_1]);

        // 夜間勤務条件基準 1-満たしている 2-満たしていない
        sb.append(CODE_CHAR[_1380102]);

        // 人員減算 1-なし 2-定員超過 3-介護従業員不足
        sb.append(CODE_CHAR[_1380101]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        
        // 6141 短期共同生活夜間ケア加算
        if (_1380104 > 1) {
            // 施設区分で分岐
            switch (_1380110) {
            case 1: // I型
                // 短期共同生活夜間ケア加算I
                putSystemServiceCodeItem(sysSvcCdItems, "Z6141");
                break;
            case 2: // II型
                // 短期共同生活夜間ケア加算II
                putSystemServiceCodeItem(sysSvcCdItems, "Z6151");
                break;
            }
        }
        
        // 6121 短期共同生活認知症緊急対応加算
        if (_1380108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6121");
        }
        
        // 6109 短期共同生活若年性認知症受入加算
        if (_1380105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // 医療連携体制加算 1-なし 2-あり
        if (_1380103 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z1600");
        }
        

        switch (_1380107) {
        case 2:
            // 6101 短期共同サービス提供体制加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // 6102 短期共同サービス提供体制加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
            // 6103 短期共同サービス提供体制加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }

        // 介護職員処遇改善を返却
        switch (_17) {
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
