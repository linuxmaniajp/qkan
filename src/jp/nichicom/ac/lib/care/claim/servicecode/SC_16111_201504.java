package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 介護予防訪問介護
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_16111_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "介護予防訪問介護";
    }

    public String getServiceCodeKind() {
        return "61";
    }

    public String getSystemServiceKindDetail() {
        return "16111";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================

        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 明らかに要介護度がおかしい場合は空を返す
        switch (_1) {
        case 1: // 自立
        case 2: // 経過的要介護
        case 5: // 要介護１
        case 6: // 要介護２
        case 7: // 要介護３
        case 8: // 要介護４
        case 9: // 要介護５
        case 10: // 事業対象者
            return new ArrayList<HashMap<String, String>>();
        }

        // 1610101 訪問介護費　1-�T型 2-�U型 3-�V型
        int _1610101 = getIntValue(map, "1610101", 1);

        // 1610102 訪問者の級職　1-2級以外 2-2級
        int _1610102 = getIntValue(map, "1610102", 1);

        // 1610103 日割　1-日割でない 2-日割である
        int _1610103 = getIntValue(map, "1610103", 1);

        // 2 特別地域加算
        int _2 = getIntValue(map, "2");

        // 中山間地域等でのサービス提供加算
        int _12 = getIntValue(map, "12", 1);

        // 中山間地域等小規模事業所加算
        int _13 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);

        // 1610104 初回加算
        int _1610104 = getIntValue(map, "1610104", 1);

        // 1610105 暮らしの機能向上加算
        int _1610105 = getIntValue(map, "1610105", 1);

        // 16 同一建物居住者へのサービス提供
        int _16 = getIntValue(map, "16", 1);
        
        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 訪問介護費　1-�T型 2-�U型 3-�V型
        sb.append(CODE_CHAR[_1610101]);

        // 要介護度
        sb.append(CODE_CHAR[_1]);

        // サービス提供責任者の級職　1-2級以外 2-2級
        sb.append(CODE_CHAR[_1610102]);

        // 訪問の必要性
        sb.append(CODE_CHAR[_16]);

        // 日割　1-日割でない 2-日割である
        sb.append(CODE_CHAR[_1610103]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        
        // 4001 予防訪問介護初回加算
        if (_1610104 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4001");
        }

        // 1610105 生活機能向上連携加算
        if (_1610105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4002");
        }
        
        
        // 介護職員処遇改善を返却
        switch (_17) {
        case 6:
            // 処遇改善加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6269");//2017.04
            break;
        case 5:
            // 処遇改善加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6270");//2015.04
            break;
        case 2:
        	// 処遇改善加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z6271");
            break;
        case 3:
        	// 処遇改善加算IV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6273");
            break;
        case 4:
        	// 処遇改善加算V
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
            break;
        }
        
        
        // 日割りなしの月単位請求
        if (_1610103 == 1) {
            
            // 特別地域加算
            if (_2 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z8000");
            }
            
            // 中山間地域等小規模事業所加算
            if (_13 > 1) {
                // 8100 予防訪問介護小規模事業所加算
                putSystemServiceCodeItem(sysSvcCdItems, "Z8100");
            }
            
            // 中山間地域等でのサービス提供加算
            if (_12 > 1) {
                // 8110 予防訪問介護中山間地域等提供加算
                putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
            }
            
            
        // 日割りの場合
        } else {
            // 特別地域加算
            if (_2 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z8001");
            }
            
            // 中山間地域等小規模事業所加算
            if (_13 > 1) {
                // 8101 予防訪問介護小規模事業所加算日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z8101");
            }
            
            // 中山間地域等でのサービス提供加算
            if (_12 > 1) {
                // 8111 予防訪問介護中山間地域等加算日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z8111");
            }
            
        }
        
        
        return sysSvcCdItems;
    }
}
