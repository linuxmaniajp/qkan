/**
 * 
 */
package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 定期巡回・随時対応型訪問介護看護費
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_17611_201504 extends Qkan10011_ServiceUnitGetter {

    public String getServiceName() {
        return "定期巡回・随時対応問介護";
    }

    public String getServiceCodeKind() {
        return "76";
    }

    public String getSystemServiceKindDetail() {
        return "17611";
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

        // 1760101 サービス提供
        int _1760101 = getIntValue(map, "1760101", 1);

        // 1760102 訪問看護サービスの提供
        int _1760102 = getIntValue(map, "1760102", 1);

        // 1760103 看護職員区分
        int _1760103 = getIntValue(map, "1760103", 1);

        // 1760104 初期加算
        int _1760104 = getIntValue(map, "1760104", 1);

        // 1760105 緊急時訪問看護加算
        int _1760105 = getIntValue(map, "1760105", 1);

        // 1760106 特別管理加算
        int _1760106 = getIntValue(map, "1760106", 1);

        // 3020111 退院時共同指導加算
        int _3020111 = getIntValue(map, "3020111", 1);

        // 1760107 ターミナルケア加算
        int _1760107 = getIntValue(map, "1760107", 1);

        // 1760108 サービス提供体制強化加算
        int _1760108 = getIntValue(map, "1760108", 1);
        
        // 1760109 定期巡回市町村独自加算
        int _1760109 = getIntValue(map, "1760109", 1);
        
        // 1760110 通所利用減算
        int _1760110 = getIntValue(map, "1760110", 1);
        
        // 1760111 日割
        int _1760111 = getIntValue(map, "1760111", 1);
        
        // 1760112 総合マネジメント体制強化加算
        int _1760112 = getIntValue(map, "1760112", 1);

        // 12 中山間地域等でのサービス提供加算
        int _12 = getIntValue(map, "12", 1);

        // 13 中山間地域等小規模事業所加算
        int _13 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);

        // 2 特定地域加算
        int _2 = getIntValue(map, "2", 1);
        
        // 16 集合住宅に居住する利用者の減算
        int _16 = getIntValue(map, "16", 1);

        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 加算のみ(退院時共同指導加算対応)
        int _9 = getIntValue(map,"9");
        
        // 単独加算のみ---------------------------------------------------------------
        // 単独加算サービス
        if(_9 == 2){
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            // 3020111 退院時共同指導加算
            if (_3020111 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z4003");
            }

            // 1760107 ターミナルケア加算
            if (_1760107 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6100");
            }
            
            // [ID:0000768][Masahiko.Higuchi] add - begin 初期加算の加算のみ対応
            // 1760104 初期加算
            if (_1760104 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z4002");
            }
            // [ID:0000768][Masahiko.Higuchi] add - end

            // 介護職員処遇改善を返却
            switch (_17) {
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6112");//2015.04
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
                break;
            }
            
            return sysSvcCdItems;
        }
        
        
        // 独自コード生成
        // =========================================================================
        StringBuilder sb = new StringBuilder();

        // 1760101 サービス提供
        sb.append(CODE_CHAR[_1760101]);
        // 1760102 訪問看護指示書の提供
        sb.append(CODE_CHAR[_1760102]);
        // 1 要介護度
        sb.append(CODE_CHAR[_1]);
        // 1760103 看護職員区分
        sb.append(CODE_CHAR[_1760103]);
        // 日割り
        sb.append(CODE_CHAR[_1760111]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // =========================================================================
        
        // 1760110 通所利用減算
        if (_1760110 > 1) {
            
            // イ(2)[一体型定期巡回、訪問看護サービス提供あり]
            if ((_1760101 == 1) && (_1760102 == 2)) {
                
                // 要介護度分岐
                switch (_1) {
                case 5: // 要介護度１
                    // 定期巡回通所利用減算２１
                    putSystemServiceCodeItem(sysSvcCdItems, "Z4106");
                    break;

                case 6: // 要介護度２
                    // 定期巡回通所利用減算２２
                    putSystemServiceCodeItem(sysSvcCdItems, "Z4107");
                    break;

                case 7: // 要介護度３
                    // 定期巡回通所利用減算２３
                    putSystemServiceCodeItem(sysSvcCdItems, "Z4108");
                    break;

                case 8: // 要介護度４
                    // 定期巡回通所利用減算２４
                    putSystemServiceCodeItem(sysSvcCdItems, "Z4109");
                    break;

                case 9: // 要介護度５
                    // 定期巡回通所利用減算２５
                    putSystemServiceCodeItem(sysSvcCdItems, "Z4110");
                    break;
                }
                
                
            // イ(1)[一体型定期巡回、訪問看護サービス提供なし]、または連携型定期巡回
            } else {
                
                // 要介護度分岐
                switch (_1) {
                case 5: // 要介護度１
                    // 定期巡回通所利用減算１１
                    putSystemServiceCodeItem(sysSvcCdItems, "Z4101");
                    break;

                case 6: // 要介護度２
                    // 定期巡回通所利用減算１２
                    putSystemServiceCodeItem(sysSvcCdItems, "Z4102");
                    break;

                case 7: // 要介護度３
                    // 定期巡回通所利用減算１３
                    putSystemServiceCodeItem(sysSvcCdItems, "Z4103");
                    break;

                case 8: // 要介護度４
                    // 定期巡回通所利用減算１４
                    putSystemServiceCodeItem(sysSvcCdItems, "Z4104");
                    break;

                case 9: // 要介護度５
                    // 定期巡回通所利用減算１５
                    putSystemServiceCodeItem(sysSvcCdItems, "Z4105");
                    break;
                }
            }
            
        }
        
        // 1760105 緊急時訪問看護加算
        if (_1760105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3100");
        }
        
        // 1760106 特別管理加算
        switch(_1760106) {
        // 定期巡回特別管理加算I
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4000");
            break;
            
        // 定期巡回特別管理加算II
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4001");
            break;
        }
        
        // 1760107 ターミナルケア加算
        if (_1760107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");
        }
        
        // 1760104 初期加算
        if (_1760104 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4002");
        }
        
        // 3020111 退院時共同指導加算
        if (_3020111 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4003");
        }
        
        // 1760112 総合マネジメント体制強化加算
        if (_1760112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4010");//2015.04
        }
        
        
        // 1760108 サービス提供体制強化加算
        switch(_1760108) {
        // 定期巡回サービス提供体制加算Iイ
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6111");//2015.04
            break;
        // 定期巡回サービス提供体制加算Iロ
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
            
        // 定期巡回サービス提供体制加算II
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
            
        // 定期巡回サービス提供体制加算III
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }
        
        
        // 介護職員処遇改善を返却
        switch (_17) {
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6112");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
            break;
        }
        
        // 日割りなし
        if (_1760111 == 1) {
        
            // 同一建物減算
            if (_16 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z4111");//2015.04
            }
            
            // 定期巡回特別地域訪問看護加算
            if (_2 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z8000");
            }
            
            // 定期巡回小規模事業所加算
            if (_13 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z8100");
            }
            
            // 中山間地域等でのサービス提供加算
            if (_12 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
            }
            
            
            // 定期巡回市町村独自加算 １～１０(コード的には2～11)
            switch(_1760109) {
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7101");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7103");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7105");
                break;
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7107");
                break;
            case 6:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7109");
                break;
            case 7:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7111");
                break;
            case 8:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7113");
                break;
            case 9:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7115");
                break;
            case 10:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7117");
                break;
            case 11:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7119");
                break;
            }
        
        
        // 日割りあり
        } else {
            
            // 同一建物減算日割
            if (_16 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z4112");//2015.04
            }
            
            // 特別地域訪問看護加算日割
            if (_2 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z8001");
            }
            
            // 小規模事業所加算日割
            if (_13 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z8101");
            }
            
            // 中山間地域等提供加算日割
            if (_12 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z8111");
            }
            
            // 定期巡回市町村独自加算 １～１０(コード的には2～11)
            switch(_1760109) {
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7102");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7104");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7106");
                break;
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7108");
                break;
            case 6:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7110");
                break;
            case 7:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7112");
                break;
            case 8:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7114");
                break;
            case 9:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7116");
                break;
            case 10:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7118");
                break;
            case 11:
                putSystemServiceCodeItem(sysSvcCdItems, "Z7120");
                break;
            }
        }
        
        
        return sysSvcCdItems;
    }
}
