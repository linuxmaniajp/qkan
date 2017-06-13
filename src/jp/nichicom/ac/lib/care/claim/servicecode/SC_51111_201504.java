package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * その他の生活支援サービス（見守り／定率）
 * 
 * @since V7.3.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_51111_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "その他の生活支援サービス（見守り／定率）";
    }

    public String getServiceCodeKind() {
        return "AB";
    }

    public String getSystemServiceKindDetail() {
        return "51111";
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
        
        putSogoSystemServiceCodeItems(sysSvcCdItems, map);
        
        return sysSvcCdItems;
    }
}
