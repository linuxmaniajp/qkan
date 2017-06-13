package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 複合型サービス（看護小規模多機能型居宅介護・短期利用）
 * 
 * @since V7.0.0
 * @author Shinobu Hitaka
 * 
 */
public class SC_17911_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "複合型サービス(看護小規模多機能型居宅介護・短期利用)";
    }

    public String getServiceCodeKind() {
        return "79";
    }

    public String getSystemServiceKindDetail() {
        return "17911";
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
        case 3: // 要支援１
        case 4: // 要支援２
        case 10: // 事業対象者
            return new ArrayList<HashMap<String, String>>();
        }

        // 1790101 人員減算
        int _1790101 = getIntValue(map, "1790101", 1);

        // 1790102 サービス提供体制強化加算
        int _1790102 = getIntValue(map, "1790102", 1);

        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 単独加算のみ---------------------------------------------------------------
        // なし

        // 独自コード生成
        // =========================================================================
        StringBuilder sb = new StringBuilder();

        // 要介護度
        sb.append(CODE_CHAR[_1]);
        
        // 人員減算
        sb.append(CODE_CHAR[_1790101]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());
        

        // 加算
        // =========================================================================

        // 1790102 サービス提供体制強化加算
        switch (_1790102) {
        case 5:
            // 複合型サービス（看護小規模多機能型居宅介護・短期利用）提供体制加算Iイ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6111");//2015.04
            break;
        case 2:
            // 複合型サービス（看護小規模多機能型居宅介護・短期利用）提供体制加算Iロ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");//2015.04
            break;
        case 3:
            // 複合型サービス（看護小規模多機能型居宅介護・短期利用）提供体制加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");//2015.04
            break;
        case 4:
            // 複合型サービス（看護小規模多機能型居宅介護・短期利用）提供体制加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");//2015.04
            break;
        }

        // 介護職員処遇改善を返却
        switch (_17) {
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6114");//2017.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6112");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");//2015.04
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");//2015.04
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2015.04
            break;
        }

        return sysSvcCdItems;
    }
}
