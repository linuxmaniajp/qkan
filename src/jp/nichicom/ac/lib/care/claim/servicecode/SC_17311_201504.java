package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 小規模多機能型居宅介護
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_17311_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "小規模多機能型居宅介護(短期利用以外)";
    }

    public String getServiceCodeKind() {
        return "73";
    }

    public String getSystemServiceKindDetail() {
        return "17311";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================
        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1730102 人員減算 1-なし 2-定員超過 3-介護従業員不足
        int _1730102 = getIntValue(map, "1730102");

        // 1730103 日割
        int _1730103 = getIntValue(map, "1730103");

        // 1730101 初期加算 1-なし 2-あり
        int _1730101 = getIntValue(map, "1730101");

        // 1730106 過小サービスに対する減算
        int _1730106 = getIntValue(map, "1730106");

        // 1730107 認知症加算
        int _1730107 = getIntValue(map, "1730107");

        // 1730108 看護職員配置加算
        int _1730108 = getIntValue(map, "1730108");

        // 1730110 サービス提供体制強化加算
        int _1730110 = getIntValue(map, "1730110");

        // 1730111 市町村独自加算
        int _1730111 = getIntValue(map, "1730111");
        
        // 1730113 看取り連携体制加算
        int _1730113 = getIntValue(map, "1730113");

        // 1730114 訪問体制強化加算
        int _1730114 = getIntValue(map, "1730114");
        
        // 1730115	総合マネジメント体制強化加算
        int _1730115 = getIntValue(map, "1730115");
        
        // 中山間地域等でのサービス提供加算
        int _12 = getIntValue(map, "12", 1);
        
        // 単独加算
        int _9 = getIntValue(map, "9");

        // 16 同一建物居住者へのサービス提供
        int _16 = getIntValue(map, "16", 1);

        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 単独加算のみ---------------------------------------------------------------
        // 単独加算サービス
        if (_9 == 2) {
            // 初期加算
            if (_1730101 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6300");
            }
            
            // 看取り連携体制加算
            if (_1730113 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z4000");//2015.04
            }

            // 介護職員処遇改善を返却
            switch (_17) {
            case 6:
                // 小規模多機能型処遇改善加算I日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z6112");//2017.04
                break;
            case 5:
                // 小規模多機能型処遇改善加算II日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z6110");//2015.04
                break;
            case 2:
                // 小規模多機能型処遇改善加算III日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
                break;
            case 3:
                // 小規模多機能型処遇改善加算IV日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                break;
            case 4:
                // 小規模多機能型処遇改善加算V日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
                break;
            }

            return sysSvcCdItems;
        }

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 同一建物居住者へのサービス提供
        sb.append(CODE_CHAR[_16]); //2015.04
        // 要介護度
        sb.append(CODE_CHAR[_1]);
        // 人員減算 1-なし 2-定員超過 3-介護従業員不足
        sb.append(CODE_CHAR[_1730102]);
        // 過小サービスに対する減算
        sb.append(CODE_CHAR[_1730106]);
        // 日割
        sb.append(CODE_CHAR[_1730103]);
        

        

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================

        // 初期加算 1-なし 2-あり
        if (_1730101 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6300");
        }

        switch (_1730107) {
        case 2:
            // 6128 小規模多機能型認知症加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6128");
            break;
        case 3:
            // 6129 小規模多機能型認知症加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6129");
            break;
        }

        switch (_1730108) {
        case 2:
            // 6137 小規模多機能型看護職員配置加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6137");
            break;
        case 3:
            // 6138 小規模多機能型看護職員配置加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6138");
            break;
        case 4:
        	// 6141 小規模多機能型看護職員配置加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z6141");//2015.04
            break;
        }

        // 1730113 看取り連携体制加算
        if (_1730113 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4000");//2015.04
        }

        // 1730114 訪問体制強化加算
        if (_1730114 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4005");//2015.04
        }

        // 1730115 総合マネジメント体制強化加算
        if (_1730115 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4010");//2015.04
        }
        
        
        switch (_1730110) {
        case 5:
            //  小多機能型サービス提供体制加算Iイ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        case 2:
            // 6101 小多機能型サービス提供体制加算Iロ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // 6102 小多機能型サービス提供体制加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
            // 6103 小多機能型サービス提供体制加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }

        // 介護職員処遇改善を返却
        switch (_17) {
        case 6:
            // 小規模多機能型処遇改善加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6112");//2017.04
            break;
        case 5:
            // 小規模多機能型処遇改善加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6110");//2015.04
            break;
        case 2:
            // 小規模多機能型処遇改善加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        case 3:
            // 小規模多機能型処遇改善加算IV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
            break;
        case 4:
            // 小規模多機能型処遇改善加算V
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
            break;
        }

        // 日割りの場合
        if (_1730103 == 2) {

            switch (_1730111) {
            case 2:
                // 小多機能市町村独自加算１日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7102");
                break;
            case 3:
                // 小多機能市町村独自加算２日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7104");
                break;
            case 4:
                // 小多機能市町村独自加算３日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7106");
                break;
            case 5:
                // 小多機能市町村独自加算４日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7108");
                break;
            case 6:
                // 小多機能市町村独自加算５日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7110");
                break;
            case 7:
                // 小多機能市町村独自加算６日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7112");
                break;
            case 8:
                // 小多機能市町村独自加算７日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7114");
                break;
            case 9:
                // 小多機能市町村独自加算８日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7116");
                break;
            case 10:
                // 小多機能市町村独自加算９日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7118");
                break;
            case 11:
                // 小多機能市町村独自加算１０日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7120");
                break;

            case 12:
                // 小規模多機能型市町村独自加算１１日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7122");
                break;
            case 13:
                // 小規模多機能型市町村独自加算１２日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7124");
                break;
            case 14:
                // 小規模多機能型市町村独自加算１３日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7126");
                break;
            case 15:
                // 小規模多機能型市町村独自加算１４日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7128");
                break;
            case 16:
                // 小規模多機能型市町村独自加算１５日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7130");
                break;
            case 17:
                // 小規模多機能型市町村独自加算１６日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7132");
                break;
            case 18:
                // 小規模多機能型市町村独自加算１７日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7134");
                break;
            case 19:
                // 小規模多機能型市町村独自加算１８日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7136");
                break;
            case 20:
                // 小規模多機能型市町村独自加算１９日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7138");
                break;
            case 21:
                // 小規模多機能型市町村独自加算２０日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7140");
                break;

            }
            
            // 中山間地域等でのサービス提供加算日割
            if (_12 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6311");//2015.04
            }
            
        } else {

            switch (_1730111) {
            case 2:
                // 小規模多機能型市町村独自加算１
                putSystemServiceCodeItem(sysSvcCdItems, "Z7101");
                break;
            case 3:
                // 小規模多機能型市町村独自加算２
                putSystemServiceCodeItem(sysSvcCdItems, "Z7103");
                break;
            case 4:
                // 小規模多機能型市町村独自加算３
                putSystemServiceCodeItem(sysSvcCdItems, "Z7105");
                break;
            case 5:
                // 小規模多機能型市町村独自加算４
                putSystemServiceCodeItem(sysSvcCdItems, "Z7107");
                break;
            case 6:
                // 小規模多機能型市町村独自加算５
                putSystemServiceCodeItem(sysSvcCdItems, "Z7109");
                break;
            case 7:
                // 小規模多機能型市町村独自加算６
                putSystemServiceCodeItem(sysSvcCdItems, "Z7111");
                break;
            case 8:
                // 小規模多機能型市町村独自加算７
                putSystemServiceCodeItem(sysSvcCdItems, "Z7113");
                break;
            case 9:
                // 小規模多機能型市町村独自加算８
                putSystemServiceCodeItem(sysSvcCdItems, "Z7115");
                break;
            case 10:
                // 小規模多機能型市町村独自加算９
                putSystemServiceCodeItem(sysSvcCdItems, "Z7117");
                break;
            case 11:
                // 小規模多機能型市町村独自加算１０
                putSystemServiceCodeItem(sysSvcCdItems, "Z7119");
                break;

            case 12:
                // 小規模多機能型市町村独自加算１１
                putSystemServiceCodeItem(sysSvcCdItems, "Z7121");
                break;
            case 13:
                // 小規模多機能型市町村独自加算１２
                putSystemServiceCodeItem(sysSvcCdItems, "Z7123");
                break;
            case 14:
                // 小規模多機能型市町村独自加算１３
                putSystemServiceCodeItem(sysSvcCdItems, "Z7125");
                break;
            case 15:
                // 小規模多機能型市町村独自加算１４
                putSystemServiceCodeItem(sysSvcCdItems, "Z7127");
                break;
            case 16:
                // 小規模多機能型市町村独自加算１５
                putSystemServiceCodeItem(sysSvcCdItems, "Z7129");
                break;
            case 17:
                // 小規模多機能型市町村独自加算１６
                putSystemServiceCodeItem(sysSvcCdItems, "Z7131");
                break;
            case 18:
                // 小規模多機能型市町村独自加算１７
                putSystemServiceCodeItem(sysSvcCdItems, "Z7133");
                break;
            case 19:
                // 小規模多機能型市町村独自加算１８
                putSystemServiceCodeItem(sysSvcCdItems, "Z7135");
                break;
            case 20:
                // 小規模多機能型市町村独自加算１９
                putSystemServiceCodeItem(sysSvcCdItems, "Z7137");
                break;
            case 21:
                // 小規模多機能型市町村独自加算２０
                putSystemServiceCodeItem(sysSvcCdItems, "Z7139");
                break;
            }
            
            // 中山間地域等でのサービス提供加算
            if (_12 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6310");//2015.04
            }

        }

        return sysSvcCdItems;
    }
}
