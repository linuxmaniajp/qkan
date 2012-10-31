package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 介護予防訪問リハビリテーション
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_16411_201204 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "介護予防訪問リハビリテーション";
    }

    public String getServiceCodeKind() {
        return "64";
    }

    public String getSystemServiceKindDetail() {
        return "16411";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================

        // 1 要介護度
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

        // 1640101 施設等の区分　1-病院又は診療所 2-介護老人保健施設
        int _1640101 = getIntValue(map, "1640101", 1);

        // 1640103 短期集中リハビリ実施加算　1-なし 2-あり
        int _1640103 = getIntValue(map, "1640103", 1);

        // 中山間地域等でのサービス提供加算
        int _12 = getIntValue(map, "12", 1);

        // 1640104 サービス提供体制強化加算
        int _1640104 = getIntValue(map, "1640104");

        // 1640105 訪問介護連携加算
        int _1640105 = getIntValue(map, "1640105", 1);
        
        // 16 同一建物居住者へのサービス提供
        int _16 = getIntValue(map, "16", 1);
        
        // 加算のみ(退院時共同指導加算対応)
        int _9 = getIntValue(map,"9");
        
        // 単独加算のみ---------------------------------------------------------------
        // 単独加算サービス
        if(_9 == 2){
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            // 訪問介護連携加算
            if (_1640105 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z4000");
            }
            
            return sysSvcCdItems;
        }
        
        
        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設等の区分　1-病院又は診療所 2-介護老人保健施設
        sb.append(CODE_CHAR[_1640101]);
        
        // 訪問の必要性
        sb.append(CODE_CHAR[_16]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================

        // 8110 予防訪問リハ中山間地域等提供加算
        if (_12 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
        }
        
        // 短期集中リハビリ実施加算　1-なし 2-あり
        if (_1640103 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5001");
        }

        // 訪問介護連携加算
        if (_1640105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4000");
        }

        // 6101 予防訪問リハサービス提供体制加算
        if (_1640104 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
        }
        

        return sysSvcCdItems;
    }

}
