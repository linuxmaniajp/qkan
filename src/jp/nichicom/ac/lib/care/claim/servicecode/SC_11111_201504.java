/**
 * 
 */
package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 訪問介護
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_11111_201504 extends Qkan10011_ServiceUnitGetter {

    public String getServiceName() {
        return "訪問介護";
    }

    public String getServiceCodeKind() {
        return "11";
    }

    public String getSystemServiceKindDetail() {
        return "11111";
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

        // 1110101 訪問種別 1-身体介護 2-生活援助 3-身体生活 4-通院乗降介助
        int _1110101 = getIntValue(map, "1110101");

        // 1110104 身体時間
        int _1110104 = getIntValue(map, "1110104", 1);

        // 1110105 生活時間
        int _1110105 = getIntValue(map, "1110105", 1);

        // 1110107 訪問人数 1-1人 2-2人
        int _1110107 = getIntValue(map, "1110107");

        // 1110108 時間帯 1-通常 2-早朝 3-夜間 4-深夜
        int _1110108 = getIntValue(map, "1110108");

        // 1110109 特定事業所加算 1-なし 2-I型 3-II型 4-III型 5-IV型
        int _1110109 = getIntValue(map, "1110109");

        // 初回加算
        int _1110110 = getIntValue(map, "1110110", 1);

        // 緊急時訪問介護加算
        int _1110111 = getIntValue(map, "1110111", 1);

        // 中山間地域等でのサービス提供加算
        int _12 = getIntValue(map, "12", 1);

        // 中山間地域等小規模事業所加算
        int _13 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);

        // 2 特別地域加算
        int _2 = getIntValue(map, "2");

        // 1110113 サービス提供責任者の級職
        int _1110113 = getIntValue(map, "1110113", 1);

        // 1110112 生活機能向上連携加算
        int _1110112 = getIntValue(map, "1110112", 1);
        
        // 1110114	頻回の訪問として行う
        int _1110114 = getIntValue(map, "1110114", 1);

        // 16 同一建物居住者へのサービス提供
        int _16 = getIntValue(map, "16", 1);
        
        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map, Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 時間帯を値に応じてマスタに合わせ変換
        if (_1110108 == 3) {
            _1110108 = 2;
        } else if (_1110108 == 4) {
            _1110108 = 3;
        }

        switch (_1110101) {
        case 3:// 身体生活選択時
               // 特定事業所加算をチェックする。

            if (_1110105 > 3) {
                _1110105 = 3;
            }
            break;
        case 2:// 生活援助選択時
               // 一律３時間以上とみなす
            if (_1110105 > 3) {
                _1110105 = 3;
            }
            break;
        case 1:// 身体介護選択時
            break;
        }

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 訪問種別 1-身体介護 2-生活援助 3-身体生活 4-通院乗降介助
        sb.append(CODE_CHAR[_1110101]);

        // 身体時間
        sb.append(CODE_CHAR[_1110104]);

        // 生活時間
        sb.append(CODE_CHAR[_1110105]);

        // サービス提供責任者の級職
        sb.append(CODE_CHAR[_1110113]);

        // 訪問の必要性
        sb.append(CODE_CHAR[_16]);

        // 訪問人数 1-1人 2-2人
        sb.append(CODE_CHAR[_1110107]);

        // 時間帯 1-通常 2-早朝 3-夜間 4-深夜
        sb.append(CODE_CHAR[_1110108]);

        // 特定事業所加算 1-なし 2-I型 3-II型 4-III型 5-IV型
        sb.append(CODE_CHAR[_1110109]);
        
        // 	頻回の訪問として行う
        sb.append(CODE_CHAR[_1110114]); //2015.04
        

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================

        // 特別地域加算
        if (_2 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8000");
        }
        
        // 訪問介護小規模事業所加算
        if (_13 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8100");
        }
        
        // 訪問介護中山間地域等提供加算
        if (_12 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
        }
        
        // 緊急時訪問介護加算
        if (_1110111 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4000");
        }
        
        // 訪問介護初回加算
        if (_1110110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4001");
        }
        
        // 生活機能向上連携加算
        if (_1110112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4002");
        }
        
        // 介護職員処遇改善を返却
        switch(_17){
        case 5:
            // 訪問介護処遇改善加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6274");//2015.04
            break;
        case 2:
            // 訪問介護処遇改善加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6271");
            break;
        case 3:
            // 訪問介護処遇改善加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z6272");
            break;
        case 4:
            // 訪問介護処遇改善加算IV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6273");
            break;
        }

        return sysSvcCdItems;
    }
}
