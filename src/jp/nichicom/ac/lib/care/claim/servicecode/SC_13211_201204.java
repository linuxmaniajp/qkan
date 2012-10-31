
package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 認知症対応型共同生活介護(短期利用以外)
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_13211_201204 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "認知症対応型共同生活介護(短期利用以外)";
    }

    public String getServiceCodeKind() {
        return "32";
    }

    public String getSystemServiceKindDetail() {
        return "13211 ";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================
        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1320106 夜間勤務条件基準 1-満たしている 2-満たしていない
        int _1320106 = getIntValue(map, "1320106");

        // 1320105 人員減算 1-なし 2-定員超過 3-介護従業員の不足
        int _1320105 = getIntValue(map, "1320105");

        // 1320104 初期加算 1-なし 2-あり
        int _1320104 = getIntValue(map, "1320104");

        // 1320107 医療連携体制加算 1-なし 2-あり
        int _1320107 = getIntValue(map, "1320107");

        // 1320108 夜間ケア加算
        int _1320108 = getIntValue(map, "1320108");

        // 1320109 若年性認知症利用者受入加算
        int _1320109 = getIntValue(map, "1320109");

        // 1320110 認知症専門ケア加算
        int _1320110 = getIntValue(map, "1320110");

        // 1320112 看取り介護加算
        int _1320112 = getIntValue(map, "1320112");

        // 1320113 退居時相談援助加算
        int _1320113 = getIntValue(map, "1320113");

        // 1320111 サービス提供体制強化加算
        int _1320111 = getIntValue(map, "1320111");

        // 1320114 施設等の区分
        int _1320114 = getIntValue(map, "1320114", 1);

        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);
        
        
        // 加算のみ(退院時共同指導加算対応)
        int _9 = getIntValue(map, "9");

        // 単独加算のみ---------------------------------------------------------------
        // 単独加算サービス
        if (_9 == 2) {
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            
            // 初期加算 1-なし 2-あり
            if (_1320104 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z1550");
            }
            
            // 6142 認知症対応型看取り介護加算
            switch(_1320112) {
            case 2:
                // 認知症対応型看取り介護加算１(死亡日以前4日以上30日以下)
                putSystemServiceCodeItem(sysSvcCdItems, "Z6142");
                break;
            case 3:
                // 認知症対応型看取り介護加算２(死亡日以前2日又は3日)
                putSystemServiceCodeItem(sysSvcCdItems, "Z6143");
                break;
            case 4:
                // 認知症対応型看取り介護加算３(死亡日)
                putSystemServiceCodeItem(sysSvcCdItems, "Z6144");
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

        

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設等の区分
        sb.append(CODE_CHAR[_1320114]);

        // 要介護度
        sb.append(CODE_CHAR[_1]);

        // 夜間勤務条件基準 1-満たしている 2-満たしていない
        sb.append(CODE_CHAR[_1320106]);

        // 人員減算 1-なし 2-定員超過 3-介護従業員の不足
        sb.append(CODE_CHAR[_1320105]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================

        // 6141 認知症対応型夜間ケア加算
        if (_1320108 > 1) {
            //施設区分により分岐
            switch (_1320114) {
            case 1: // I型
                putSystemServiceCodeItem(sysSvcCdItems, "Z6141");
                break;
            case 2: // II型
                putSystemServiceCodeItem(sysSvcCdItems, "Z6151");
                break;
            }
        }
        
        // 6109 認知症対応型若年性認知症受入加算
        if (_1320109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // 6142 認知症対応型看取り介護加算
        switch(_1320112) {
        case 2:
            // 認知症対応型看取り介護加算１(死亡日以前4日以上30日以下)
            putSystemServiceCodeItem(sysSvcCdItems, "Z6142");
            break;
        case 3:
            // 認知症対応型看取り介護加算２(死亡日以前2日又は3日)
            putSystemServiceCodeItem(sysSvcCdItems, "Z6143");
            break;
        case 4:
            // 認知症対応型看取り介護加算３(死亡日)
            putSystemServiceCodeItem(sysSvcCdItems, "Z6144");
            break;
        }
        
        // 初期加算 1-なし 2-あり
        if (_1320104 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z1550");
        }

        // 医療連携体制加算 1-なし 2-あり
        if (_1320107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z1600");
        }

        // 6502 認知症対応型退居時相談援助加算
        if (_1320113 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6502");
        }
        
        switch (_1320110) {
        case 2:
            // 6133 認知症対応型認知症専門ケア加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6133");
            break;
        case 3:
            // 6134 認知症対応型認知症専門ケア加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6134");
            break;
        }
        
        switch (_1320111) {
        case 2:
            // 6101 認知症対応サービス提供体制加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // 6102 認知症対応サービス提供体制加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
            // 6103 認知症対応サービス提供体制加算III
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
