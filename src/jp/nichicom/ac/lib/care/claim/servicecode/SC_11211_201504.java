package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 訪問入浴介護
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_11211_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "訪問入浴介護";
    }

    public String getServiceCodeKind() {
        return "12";
    }

    public String getSystemServiceKindDetail() {
        return "11211";
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
            return new ArrayList<HashMap<String, String>>();
        }

        // 1120103 訪問者種別
        int _1120103 = getIntValue(map, "1120103");
        // 1120104 入浴介護区分
        int _1120104 = getIntValue(map, "1120104");
        // 2 特別地域加算
        int _2 = getIntValue(map, "2");
        // 13 中山間地域等における小規模事業所
        int _13 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);
        // 12 中山間地域等でのサービス提供加算
        int _12 = getIntValue(map, "12", 1);
        // 1120105 サービス提供体制強化加算
        int _1120105 = getIntValue(map, "1120105");
        // 16 同一建物居住者へのサービス提供
        int _16 = getIntValue(map, "16", 1);

        // 17 処遇改善加算
        int _17 = getIntValue(map, Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 訪問者種別
        sb.append(CODE_CHAR[_1120103]);
        // 入浴介護区分
        sb.append(CODE_CHAR[_1120104]);
        // 同一建物居住者へのサービス提供
        sb.append(CODE_CHAR[_16]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        // 特別地域加算
        if (_2 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8000");
        }

        // 訪問入浴小規模事業所加算
        if (_13 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8100");
        }

        // 訪問入浴中山間地域等提供加算
        if (_12 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
        }

        // 訪問入浴サービス提供体制加算
        switch (_1120105) {
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        }
        
        // 処遇改善加算
        switch(_17){
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        }

        return sysSvcCdItems;
    }

}
