
package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 介護予防居宅療養管理指導
 * 
 * @since V7.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_13411_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "介護予防居宅療養管理指導";
    }

    public String getServiceCodeKind() {
        return "34";
    }

    public String getSystemServiceKindDetail() {
        return "13411";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(Map<String, String> map) {
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

        // 1340108 担当者区分　1-医師 2-歯科医師 3-薬剤師(医療機関) 4-薬剤師(薬局) 5-管理栄養士 6-歯科衛生士等
        // 7-看護師
        int _1340108 = getIntValue(map, "1340108", 1);

        // 1340102 在宅時医学総合管理料　1-なし 2-あり
        int _1340102 = getIntValue(map, "1340102", 1);

        // 1340103 特別薬剤　1-なし 2-あり
        int _1340103 = getIntValue(map, "1340103", 1);

        // 1340107 がん末期　1-がん末期でない 2-がん末期でない
        int _1340107 = getIntValue(map, "1340107", 1);

        // 1340109 看護職員区分 1-正看等 2-准看
        int _1340109 = getIntValue(map, "1340109", 1);

        // 16 所在地区分
        int _16 = getIntValue(map, "16", 1);


        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 担当者区分　1-医師 2-歯科医師 3-薬剤師(医療機関) 4-薬剤師(薬局) 5-管理栄養士 6-歯科衛生士等 7-看護師
        sb.append(CODE_CHAR[_1340108]);

        // 在宅時医学総合管理料　1-なし 2-あり
        sb.append(CODE_CHAR[_1340102]);

        // 所在地区分
        sb.append(CODE_CHAR[_16]);

        // がん末期　1-がん末期でない 2-がん末期でない
        sb.append(CODE_CHAR[_1340107]);

        // 特別薬剤　1-なし 2-あり
        sb.append(CODE_CHAR[_1340103]);

        // 看護職員区分
        sb.append(CODE_CHAR[_1340109]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================

        return sysSvcCdItems;
    }
}
