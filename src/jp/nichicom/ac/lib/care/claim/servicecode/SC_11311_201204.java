package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 訪問看護(介護保険)
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_11311_201204 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "訪問看護(介護保険)";
    }

    public String getServiceCodeKind() {
        return "13";
    }

    public String getSystemServiceKindDetail() {
        return "11311";
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

        // 1130103 施設区分
        int _1130103 = getIntValue(map, "1130103");

        // 1130111 時間区分
        int _1130111 = getIntValue(map, "1130111");

        // 1130104 職員区分
        int _1130104 = getIntValue(map, "1130104");

        // 1130106 時間帯
        int _1130106 = getIntValue(map, "1130106");

        // 1130114 長時間訪問加算
        int _1130114 = getIntValue(map, "1130114", 1);

        // 1130112 訪問人数
        int _1130112 = getIntValue(map, "1130112");

        // 2 特別地域加算
        int _2 = getIntValue(map, "2");

        // 1130108 緊急時訪問看護加算
        int _1130108 = getIntValue(map, "1130108");

        // 1130122 緊急時訪問看護加算（定期巡回用）
        int _1130122 = getIntValue(map, "1130122");

        // 1130110 ターミナルケア加算
        int _1130110 = getIntValue(map, "1130110");

        // 13 中山間地域等における小規模事業所
        int _13 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);

        // 12 中山間地域等でのサービス提供加算
        int _12 = getIntValue(map, "12", 1);

        // 1130113 サービス提供体制強化加算
        int _1130113 = getIntValue(map, "1130113");

        // 1130115 2人目の訪問時間
        int _1130115 = getIntValue(map, "1130115", 1);

        // 1130116 特別管理加算
        int _1130116 = getIntValue(map, "1130116", 1);

        // 1130117 初回加算
        int _1130117 = getIntValue(map, "1130117", 1);

        // 1130118 退院時共同指導加算
        int _1130118 = getIntValue(map, "1130118", 1);

        // 1130119 看護・介護連携加算
        int _1130119 = getIntValue(map, "1130119", 1);

        // 16 同一建物居住者へのサービス提供
        int _16 = getIntValue(map, "16", 1);

        // 1130120 訪問看護特別指示減算
        int _1130120 = getIntValue(map, "1130120", 1);

        // 1130121 1日に2回を越えて実施
        int _1130121 = getIntValue(map, "1130121", 1);
        
        // 1130123 日割り
        int _1130123 = getIntValue(map, "1130123", 1);
        
        // 加算のみ(退院時共同指導加算対応)
        int _9 = getIntValue(map,"9");
        
        // 単独加算のみ---------------------------------------------------------------
        // 単独加算サービス
        if(_9 == 2){
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            // 退院時共同指導加算
            if (_1130118 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z4003");
            }
            
            return sysSvcCdItems;
        }
        

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設区分
        sb.append(CODE_CHAR[_1130103]);

        // 時間区分
        sb.append(CODE_CHAR[_1130111]);

        // 職員区分
        sb.append(CODE_CHAR[_1130104]);

        // 1日に2回を越えて実施
        sb.append(CODE_CHAR[_1130121]);

        // 同一建物居住者へのサービス提供
        sb.append(CODE_CHAR[_16]);

        // 時間帯
        // コードマスタにあわせ変換
        if (_1130106 == 3) {
            _1130106 = 2;
        } else if (_1130106 == 4) {
            _1130106 = 3;
        }
        sb.append(CODE_CHAR[_1130106]);

        // 訪問人数
        sb.append(CODE_CHAR[_1130112]);

        // 2人目の訪問時間
        sb.append(CODE_CHAR[_1130115]);

        // 長時間訪問看護加算
        sb.append(CODE_CHAR[_1130114]);

        // 要介護５の者の場合
        if (_1 == 9) {
            // かつ、施設区分が3-定期巡回の場合
            if (_1130103 == 3) {
                sb.append(CODE_CHAR[2]);
            } else {
                sb.append(DEFAULT_CHAR);
            }

        } else {
            sb.append(DEFAULT_CHAR);
        }
        
        // 日割りの場合
        switch (_1130103) {
        case 1: // 指定訪問看護ステーション
        case 2: // 病院又は診療所
            // 日割りコード無
            sb.append(DEFAULT_CHAR);
            break;
        case 3: // 定期巡回・随時対応型訪問介護看護
            sb.append(CODE_CHAR[_1130123]);
            break;
        }

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================

        // 訪問看護特別指示減算
        if (_1130120 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4100");
        }

        // 特別地域訪問看護加算
        if (_2 > 1) {
            // 施設区分を参照
            switch (_1130103) {
            // イ：指定訪問看護ステーションまたはロ：医療機関の場合
            case 1:
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z8000");
                break;

            // ハ：定期巡回・随時対応サービスの場合
            case 3:
                // 日割りチェックの有無を確認
                if (_1130123 == 1) {
                    // 特別地域訪問看護加算２
                    putSystemServiceCodeItem(sysSvcCdItems, "Z8001");
                } else {
                    // 特別地域訪問看護加算２日割
                    putSystemServiceCodeItem(sysSvcCdItems, "Z8002");
                }
                break;

            }
        }

        // 8100 訪問看護小規模事業所加算
        if (_13 > 1) {
            // 施設区分を参照
            switch (_1130103) {
            // イ：指定訪問看護ステーションまたはロ：医療機関の場合
            case 1:
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z8100");
                break;

            // ハ：定期巡回・随時対応サービスの場合
            case 3:
                // 日割りチェックの有無を確認
                if (_1130123 == 1) {
                    // 訪問看護小規模事業所加算２
                    putSystemServiceCodeItem(sysSvcCdItems, "Z8101");
                } else {
                    // 訪問看護小規模事業所加算２日割
                    putSystemServiceCodeItem(sysSvcCdItems, "Z8102");
                }
                break;

            }
        }

        // 8110 訪問看護中山間地域等提供加算
        if (_12 > 1) {
            // 施設区分を参照
            switch (_1130103) {
            // イ：指定訪問看護ステーションまたはロ：医療機関の場合
            case 1:
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
                break;

            // ハ：定期巡回・随時対応サービスの場合
            case 3:
                // 日割りチェックの有無を確認
                if (_1130123 == 1) {
                    // 訪問看護中山間地域等提供加算２
                    putSystemServiceCodeItem(sysSvcCdItems, "Z8111");
                } else {
                    // 訪問看護中山間地域等加算２日割
                    putSystemServiceCodeItem(sysSvcCdItems, "Z8112");
                }
                break;

            }
        }

        // 緊急時訪問看護加算
        if (_1130108 > 1) {
            // 施設区分確認
            switch (_1130103) {
            case 1:// 指定訪問看護ステーションだった場合
                putSystemServiceCodeItem(sysSvcCdItems, "Z3100");
                break;

            case 2:// 医療機関
                putSystemServiceCodeItem(sysSvcCdItems, "Z3200");
                break;
            }
        }

        // 緊急時訪問看護加算（定期巡回専用）
        if (_1130103 == 3) {
            switch (_1130122) {
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z3100");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z3200");
                break;
            }
        }

        // 特別管理加算
        switch (_1130116) {
        // 特別管理加算I
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4000");
            break;
        // 特別管理加算II
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4001");
            break;
        }

        // ターミナルケア加算
        if (_1130110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z7000");
        }

        // 初回加算
        if (_1130117 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4002");
        }

        // 退院時共同指導加算
        if (_1130118 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4003");
        }

        // 看護・介護連携加算
        if (_1130119 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4004");
        }

        // 6101 訪問看護サービス提供体制加算
        if (_1130113 > 1) {
            // 施設区分確認
            switch (_1130103) {
            case 1:// 指定訪問看護ステーションだった場合
            case 2:// 医療機関
                putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
                break;
            case 3: // 訪問看護サービス提供体制加算２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
                break;
            }
        }

        return sysSvcCdItems;
    }

}
