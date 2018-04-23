package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 居宅療養管理指導
 * 
 * @since V7.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_13111_201804 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "居宅療養管理指導";
    }

    public String getServiceCodeKind() {
        return "31";
    }

    public String getSystemServiceKindDetail() {
        return "13111";
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

        // 12 中山間地域等でのサービス提供加算
        int _12 = getIntValue(map, "12", 1);   
        
        // 中山間地域等小規模事業所加算
        int _13 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);

        // 2 特別地域加算
        int _2 = getIntValue(map, "2");
        
        // 1310111 職員区分
        int _1310111 = getIntValue(map, "1310111");

        // 1310104 在総診
        int _1310104 = getIntValue(map, "1310104");

        // 1310110 がん末期
        int _1310110 = getIntValue(map, "1310110");

        // 1310105 特別薬剤
        int _1310105 = getIntValue(map, "1310105");

        // 1310112 看護職員区分
        int _1310112 = getIntValue(map, "1310112");

        // 16 所在地区分(旧）
        int _16 = getIntValue(map, "16");
        
        // 1310113 所在地区分
        int _1310113 = getIntValue(map, "1310113");

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 職員区分
        sb.append(CODE_CHAR[_1310111]);

        // 在総診
//        sb.append(CODE_CHAR[_1310104]);

        // 所在地区分
//        sb.append(CODE_CHAR[_16]);
        if (_1310111 == 7) {
        	// 職員区分が「看護職員」の場合
        	if (_16 == 2) {
        		sb.append("5"); // 同一建物
        	} else {
        		sb.append("4"); // 同一建物以外
        	}
        } else {
        	sb.append(CODE_CHAR[_1310113]);
        }

        // がん末期
        sb.append(CODE_CHAR[_1310110]);

        // 特別薬剤
        sb.append(CODE_CHAR[_1310105]);

        // 看護職員区分
        sb.append(CODE_CHAR[_1310112]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        // 特別地域加算
        if (_2 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8000");//2018.04
        }
        
        // 小規模事業所加算
        if (_13 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8100");//2018.04
        }
        
        // 中山間地域等提供加算
        if (_12 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8110");//2018.04
        }
        
        return sysSvcCdItems;
    }
}
