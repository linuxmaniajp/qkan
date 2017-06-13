package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SC_16211_201504 extends Qkan10011_ServiceUnitGetter {

    public String getServiceName() {
        return "介護予防訪問入浴介護";
    }

    public String getServiceCodeKind() {
        return "62";
    }

    public String getSystemServiceKindDetail() {
        return "16211";
    }

    protected ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
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

        // 1620101 訪問者の人数　1-看護職員1人及び介護職員1人 2-介護職員2人
        int _1620101 = getIntValue(map, "1620101", 1);

        // 1620102 入浴介護区分　1-なし 2-部分浴・清拭のみ
        int _1620102 = getIntValue(map, "1620102", 1);

        // 2 特別地域加算
        int _2 = getIntValue(map, "2");

        // 中山間地域等でのサービス提供加算
        int _12 = getIntValue(map, "12", 1);

        // 中山間地域等小規模事業所加算
        int chusankantiikiJigyosyo = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);

        // 1620103 サービス提供体制強化加算
        int _1620103 = getIntValue(map, "1620103");

        // 16 訪問の必要性
        int _16 = getIntValue(map, "16", 1);

        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 訪問者の人数　1-看護職員1人及び介護職員1人 2-介護職員2人
        sb.append(CODE_CHAR[_1620101]);

        // 入浴介護区分　1-なし 2-部分浴・清拭のみ
        sb.append(CODE_CHAR[_1620102]);

        // 訪問の必要性
        sb.append(CODE_CHAR[_16]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        // 特別地域加算
        if (_2 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8000");
        }

        // 8100 予防訪問入浴小規模事業所加算
        if (chusankantiikiJigyosyo > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8100");
        }

        // 8110 予防訪問入浴中山間地域等提供加算
        if (_12 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
        }

        // 6101 予防訪問入浴サービス提供体制加算
        switch (_1620103) {
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//TODO:コード値確認
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");//TODO:コード値確認
            break;
        }

        // 介護職員処遇改善を返却
        switch (_17) {
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");//TODO:コード値確認
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
