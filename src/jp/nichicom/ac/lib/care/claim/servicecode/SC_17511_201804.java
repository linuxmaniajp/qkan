package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 介護予防小規模多機能型居宅介護
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_17511_201804 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "介護予防小規模多機能型居宅介護(短期利用以外)";
    }

    public String getServiceCodeKind() {
        return "75";
    }

    public String getSystemServiceKindDetail() {
        return "17511";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1750101 初期加算　1-なし 2-あり
        int _1750101 = getIntValue(map, "1750101", 1);

        // 1750102 人員減算　1-なし 2-定員超過 3-看護・介護職員の不足
        int _1750102 = getIntValue(map, "1750102", 1);

        // 1750103 日割　1-日割でない 2-日割である
        int _1750103 = getIntValue(map, "1750103", 1);

        // 1750106 過小サービスに対する減算
        int _1750106 = getIntValue(map, "1750106", 1);


        // 1750108 サービス提供体制強化加算
        int _1750108 = getIntValue(map, "1750108", 1);
        
        // 1750110 総合マネジメント体制強化加算
        int _1750110 = getIntValue(map, "1750110");

        // 1750111 若年性認知症受入加算
        int _1750111 = getIntValue(map, "1750111");
        
        // 1750112 生活機能向上連携加算
        int _1750112 = getIntValue(map, "1750112");
        
        // 1750113 栄養スクリーニング加算
        int _1750113 = getIntValue(map, "1750113");
        
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
            if (_1750101 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6300");
            }
            
            // 介護職員処遇改善を返却
            switch (_17) {
            case 6:
                // 予小規模多機能処遇改善加算I
                putSystemServiceCodeItem(sysSvcCdItems, "Z6112");//2017.04
                break;
            case 5:
                // 予小規模多機能処遇改善加算II
                putSystemServiceCodeItem(sysSvcCdItems, "Z6110");//2015.04
                break;
            case 2:
                // 予小規模多機能処遇改善加算III
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
                break;
            case 3:
                // 予小規模多機能処遇改善加算IV
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                break;
            case 4:
                // 予小規模多機能処遇改善加算V
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
                break;
            }

            return sysSvcCdItems;
        }

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        
        // 同一建物居住者へのサービス提供
        sb.append(CODE_CHAR[_16]);		//2015.04
        
        // 要介護度
        sb.append(CODE_CHAR[_1]);

        // 人員減算　1-なし 2-定員超過 3-看護・介護職員の不足
        sb.append(CODE_CHAR[_1750102]);

        // 過小サービスに対する減算
        sb.append(CODE_CHAR[_1750106]);
        
        // 日割　1-日割でない 2-日割である
        sb.append(CODE_CHAR[_1750103]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================

        // 初期加算　1-なし 2-あり
        if (_1750101 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6300");
        }
        
        // 1750110	総合マネジメント体制強化加算
        if (_1750110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4010");//2015.04
        }
        
        // 1750111	若年性認知症受入加算
        if (_1750111 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");//2018.04
        }
        
        // 1750112	生活機能向上連携加算
        switch(_1750112) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4002");//2018.04
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4003");//2018.04
            break;
        }
        
        // 1750113	栄養スクリーニング加算
        if (_1750113 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6201");//2018.04
        }
        
        switch (_1750108) {
        case 5:
            // 6100　予小多機能型サービス提供体制加算Iイ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        case 2:
            // 6101　予小多機能サービス提供体制加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // 6102　予小多機能サービス提供体制加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
            // 6103　予小多機能サービス提供体制加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }
        
        // 介護職員処遇改善を返却
        switch (_17) {
        case 6:
            // 予小規模多機能処遇改善加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6112");//2017.04
            break;
        case 5:
            // 予小規模多機能処遇改善加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6110");//2015.04
            break;
        case 2:
            // 予小規模多機能処遇改善加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        case 3:
            // 予小規模多機能処遇改善加算IV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
            break;
        case 4:
            // 予小規模多機能処遇改善加算V
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
            break;
        }
        
        // 日割りなし
        if (_1750103 == 1) {
            // 中山間地域等でのサービス提供加算
            if (_12 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6310");//2015.04
            }
            
        } else {
            // 中山間地域等でのサービス提供加算
            if (_12 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6311");//2015.04
            }
        	
        }

        return sysSvcCdItems;
    }

}
