package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 介護予防認知症対応型共同生活介護(短期利用)
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_13911_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "介護予防認知症対応型共同生活介護(短期利用)";
    }

    public String getServiceCodeKind() {
        return "39";
    }

    public String getSystemServiceKindDetail() {
        return "13911";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1390101 人員減算　1-なし 2-定員超過 3-介護従業員の不足
        int _1390101 = getIntValue(map, "1390101", 1);

        // 1390102 夜間勤務条件基準　1-満たしている 2-満たしていない
        int _1390102 = getIntValue(map, "1390102", 1);

        // 1390103 夜間支援体制加算
        int _1390103 = getIntValue(map, "1390103", 1);

        // 1390107 認知症行動・心理症状緊急対応加算
        int _1390107 = getIntValue(map, "1390107", 1);

        // 1390104 若年性認知症利用者受入加算
        int _1390104 = getIntValue(map, "1390104", 1);

        // 1390106 サービス提供体制強化加算
        int _1390106 = getIntValue(map, "1390106", 1);

        // 1390109 施設等の区分
        int _1390109 = getIntValue(map, "1390109", 1);

        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設等の区分
        sb.append(CODE_CHAR[_1390109]);

        // 要介護度
        sb.append(CODE_CHAR[_1]);

        // 夜間勤務条件基準　1-満たしている 2-満たしていない
        sb.append(CODE_CHAR[_1390102]);

        // 人員減算　1-なし 2-定員超過 3-介護従業員の不足
        sb.append(CODE_CHAR[_1390101]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        // 6161 予認知症対応夜間支援体制加算
        if (_1390103 > 1) {
            //施設区分により分岐
            switch (_1390109) {
            case 1: // I型
                putSystemServiceCodeItem(sysSvcCdItems, "Z6161");//TODO:コード値確認
                break;
            case 2: // II型
                putSystemServiceCodeItem(sysSvcCdItems, "Z6171");//TODO:コード値確認
                break;
            }
        }
        
        // 6121 予短期共同認知症緊急対応加算
        if (_1390107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6121");
        }
        
        // 6109 予認知症対応若年性認知症受入加算
        if (_1390104 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        switch (_1390106) {
        case 5:
            // 6100 予認知対応サービス提供体制加算Iイ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//TODO:コード値確認
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
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");//TODO:コード値確認
            break;
        case 2:
            // 予短期共同生活処遇改善加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        case 3:
            // 予短期共同生活処遇改善加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
            break;
        case 4:
            // 予短期共同生活処遇改善加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
            break;
        }

        return sysSvcCdItems;
    }
}
