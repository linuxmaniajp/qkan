package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 介護予防訪問リハビリテーション
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_16411_201804 extends Qkan10011_ServiceUnitGetter {
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
        case 10: // 事業対象者
            return new ArrayList<HashMap<String, String>>();
        }

        // 1640101 施設等の区分　1-病院又は診療所 2-介護老人保健施設 3-介護医療院
        int _1640101 = getIntValue(map, "1640101", 1);

        // 1640103 短期集中個別リハビリテーション実施加算　1-なし 2-あり
        int _1640103 = getIntValue(map, "1640103", 1);

        // 12 中山間地域等でのサービス提供加算
        int _12 = getIntValue(map, "12", 1);

        // 13 中山間地域等小規模事業所加算
        int _13 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);

        // 2 特別地域加算
        int _2 = getIntValue(map, "2");
        
        // 1640107 計画診療未実施減算
        int _1640107 = getIntValue(map, "1640107");
        
        // 23 同一建物減算
        int _23 = getIntValue(map, "23", 1);

        // リハビリテーション・マネジメント加算
        int _1640102 = getIntValue(map, "1640102");
        
        // 1640104 サービス提供体制強化加算
        int _1640104 = getIntValue(map, "1640104", 1);

        // 1640108 事業所評価加算
        int _1640108 = getIntValue(map, "1640108", 1);
        
        
        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設等の区分　1-病院又は診療所 2-介護老人保健施設 3-介護医療院
        sb.append(CODE_CHAR[_1640101]);
        
        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================

        // 2 特別地域加算
        if (_2 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8000");//2018.04
        }
        
        // 13 訪問介護小規模事業所加算
        if (_13 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8100");//2018.04
        }
        
        // 8110 予防訪問リハ中山間地域等提供加算
        if (_12 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
        }
        
        // 5001 短期集中個別リハビリテーション実施加算
        if (_1640103 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5001");
        }

        // 5005 事業所評価加算
        if (_1640108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5005");//2018.04
        }

        // 6101 予防訪問リハサービス提供体制加算
        if (_1640104 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
        }
        
        // 同一建物減算 //2018.04
        switch (_23) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4111");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4112");
            break;
        }
        
        // 5010 計画診療未実施減算
        if (_1640107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5010");//2018.04
        }
        
        // 5615 リハビリテーション・マネジメント加算
        if (_1640102 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5615");//2018.04
        }
        

        return sysSvcCdItems;
    }

}
