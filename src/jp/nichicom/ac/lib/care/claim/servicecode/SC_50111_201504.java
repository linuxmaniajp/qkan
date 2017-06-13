package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 訪問型サービス(みなし)
 * 
 * @since V7.2.1
 * @author Yoichiro.Kamei
 * 
 */
public class SC_50111_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "訪問型サービス(みなし)";
    }

    public String getServiceCodeKind() {
        return "A1";
    }

    public String getSystemServiceKindDetail() {
        return "50111";
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
            return new ArrayList<HashMap<String, String>>();
        }

        // 5010101 訪問介護費　1-�T型 2-�U型 3-�V型 4-�W型 5-�X型 6-�Y型 7-短時間型
        int _5010101 = getIntValue(map, "5010101", 1);

        // 5010102 サービス提供責任者の級職　1-初任以外 2-初任
        int _5010102 = getIntValue(map, "5010102", 1);

        // 5010103 日割　1-日割でない 2-日割である
        int _5010103 = getIntValue(map, "5010103", 1);

        // 2 特別地域加算
        int _2 = getIntValue(map, "2");

        // 中山間地域等でのサービス提供加算
        int _12 = getIntValue(map, "12", 1);

        // 中山間地域等小規模事業所加算
        int _13 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);

        // 5010104 初回加算
        int _5010104 = getIntValue(map, "5010104", 1);

        // 5010105 生活機能向上連携加算
        int _5010105 = getIntValue(map, "5010105", 1);

        // 16 同一建物居住者へのサービス提供
        int _16 = getIntValue(map, "16", 1);
        
        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 訪問介護費　1-�T型 2-�U型 3-�V型 4-�W型 5-�X型 6-�Y型 7-短時間型
        sb.append(CODE_CHAR[_5010101]);

        // 要介護度
        sb.append(CODE_CHAR[_1]);

        // サービス提供責任者の級職　1-初任以外 2-初任
        sb.append(CODE_CHAR[_5010102]);

        // 同一建物居住者へのサービス提供
        sb.append(CODE_CHAR[_16]);

        // 日割　1-日割でない 2-日割である
        sb.append(CODE_CHAR[_5010103]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        
        // 初回加算
        if (_5010104 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4001");
        }

        // 生活機能向上連携加算
        if (_5010105 > 1) {
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
            putSystemServiceCodeItem(sysSvcCdItems, "Z6270");
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
        
        
        // 日割りなしの場合
        if (_5010103 == 1) {
            
        	
        	// 月単位サービスの場合
        	if (_5010101 < 4) {
        		
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
                
            // 回数単位サービスの場合
        	} else {
        		
                // 特別地域加算
                if (_2 > 1) {
                    putSystemServiceCodeItem(sysSvcCdItems, "Z8002");
                }
                
                // 中山間地域等小規模事業所加算
                if (_13 > 1) {
                    // 8100 予防訪問介護小規模事業所加算
                    putSystemServiceCodeItem(sysSvcCdItems, "Z8102");
                }
                
                // 中山間地域等でのサービス提供加算
                if (_12 > 1) {
                    // 8110 予防訪問介護中山間地域等提供加算
                    putSystemServiceCodeItem(sysSvcCdItems, "Z8112");
                }
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
