package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 訪問リハビリテーション
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_11411_201204 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "訪問リハビリテーション";
    }

    public String getServiceCodeKind() {
        return "14";
    }

    public String getSystemServiceKindDetail() {
        return "11411";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================
        
        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));
        // 明らかに要介護度がおかしい場合は空を返す
        switch(_1){
        case 1: // 自立
        case 3: // 要支援１
        case 4: // 要支援２
            return new ArrayList<HashMap<String, String>>();
        }
        
        // 1140103 施設区分
        int _1140103 = getIntValue(map, "1140103");

        // 1140106 短期集中リハビリテーション実施加算
        int _1140106 = getIntValue(map, "1140106");

        // 12 中山間地域等でのサービス提供加算
        int _12 = getIntValue(map, "12", 1);        
        
        // 1140107 サービス提供体制強化加算
        int _1140107 = getIntValue(map, "1140107" ,1);

        // 1140108 訪問介護連携加算
        int _1140108 = getIntValue(map, "1140108", 1);

        // 16 同一建物居住者へのサービス提供
        int _16 = getIntValue(map, "16", 1);

        // 加算のみ(退院時共同指導加算対応)
        int _9 = getIntValue(map,"9");
        
        
        // 単独加算のみ---------------------------------------------------------------
        // 単独加算サービス
        if(_9 == 2){
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            // 訪問介護連携加算
            if (_1140108 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z4000");
            }
            
            return sysSvcCdItems;
        }
        
        
        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設区分
        sb.append(CODE_CHAR[_1140103]);
        // 同一建物居住者へのサービス提供
        sb.append(CODE_CHAR[_16]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        
        // 8110 訪問リハ中山間地域等提供加算
        if (_12 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
        }
        
        // 短期集中リハビリテーション実施加算
        switch(_1140106) {
        // 短期集中加算１
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z5001");
            break;
        // 短期集中加算２
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z5002");
            break;
        }
        
        // 訪問介護連携加算
        if (_1140108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4000");
        }
        
        // 6101 訪問リハサービス提供体制加算
        if (_1140107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
        }
        
        
        return sysSvcCdItems;
    }

}
