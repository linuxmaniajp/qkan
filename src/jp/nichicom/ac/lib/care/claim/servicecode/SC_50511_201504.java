package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 通所型サービス(みなし)
 * 
 * @since V7.2.1
 * @author Yoichiro.Kamei
 * 
 */
public class SC_50511_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "通所型サービス(みなし)";
    }

    public String getServiceCodeKind() {
        return "A5";
    }

    public String getSystemServiceKindDetail() {
        return "50511";
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
        case 2: // 経過的要介護
        case 5: // 要介護１
        case 6: // 要介護２
        case 7: // 要介護３
        case 8: // 要介護４
        case 9: // 要介護５
            return new ArrayList<HashMap<String, String>>();
        }
        
        // 通所型サービス費　1-１ 2-２
        int _5050101 = getIntValue(map, "5050101", 1);
        
        // 事業対象者ではないとき、要介護度によって通所型サービスを決定
        if (_1 == 3) {
            // 要支援１の場合
        	_5050101 = 1; //通所型サービス１
        } else if (_1 == 4) {
            // 要支援２の場合
        	_5050101 = 2; //通所型サービス２
        }
        
        // 回数　1-回数でない 2-回数である
        int _5050102 = getIntValue(map, "5050102", 1);
        
        // 5050103 人員減算　1-なし 2-定員超過 3-看護・介護職員が欠員
        int _5050103 = getIntValue(map, "5050103", 1);

        // 5050104 日割　1-日割でない 2-日割である
        int _5050104 = getIntValue(map, "5050104", 1);

        // 5050105 生活機能向上グループ活動加算　1-なし 2-あり
        int _5050105 = getIntValue(map, "5050105", 1);

        // 5050106 運動器機能向上加算　1-なし 2-あり
        int _5050106 = getIntValue(map, "5050106", 1);

        // 5050107 栄養改善加算　1-なし 2-あり
        int _5050107 = getIntValue(map, "5050107", 1);

        // 5050108 口腔機能向上加算　1-なし 2-あり
        int _5050108 = getIntValue(map, "5050108", 1);

        // 5050109 事業所評価加算　1-なし 2-あり
        int _5050109 = getIntValue(map, "5050109", 1);

        // 5050110 若年性認知症利用者受入加算
        int _5050110 = getIntValue(map, "5050110", 1);

        // 中山間地域等でのサービス提供加算
        int _12 = getIntValue(map, "12", 1);

        // 5050111 サービス提供体制強化加算
        int _5050111 = getIntValue(map, "5050111");

        // 16 同一建物居住者へのサービス提供
        int _16 = getIntValue(map, "16", 1);

        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);
        
        // [ID:0000746][Masahiko.Higuchi] 2012/06/20 add - begin  加算のみ対応
        // 加算のみ(運動機器・栄養改善・口腔機能向上)
        int _9 = getIntValue(map,"9");

        // 単独加算のみ---------------------------------------------------------------
        // 単独加算サービス
        if(_9 == 2){
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            // 5050106 運動器機能向上加算　1-なし 2-あり
            if (_5050106 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z5002");
            }
            
            // 5050107 栄養改善加算　1-なし 2-あり
            if (_5050107 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z5003");
            }
            
            // 5050108 口腔機能向上加算　1-なし 2-あり
            if (_5050108 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z5004");
            }
            
            // 介護職員処遇改善を返却
            switch (_17) {
            case 5:
                // 通所型サービス処遇改善加算I
                putSystemServiceCodeItem(sysSvcCdItems, "Z6110");
                break;
            case 2:
                // 通所型サービス処遇改善加算I
                putSystemServiceCodeItem(sysSvcCdItems, "Z6111");
                break;
            case 3:
                // 通所型サービス処遇改善加算II
                putSystemServiceCodeItem(sysSvcCdItems, "Z6113");
                break;
            case 4:
                // 通所型サービス処遇改善加算III
                putSystemServiceCodeItem(sysSvcCdItems, "Z6115");
                break;
            }
            
            return sysSvcCdItems;
        }
        // [ID:0000746][Masahiko.Higuchi] 2012/06/20 add - end

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 通所型サービス費
        sb.append(CODE_CHAR[_5050101]);
        
        // 要介護度
        sb.append(CODE_CHAR[_1]);
        
        // 回数
        sb.append(CODE_CHAR[_5050102]);

        // 人員減算　1-なし 2-定員超過 3-看護・介護職員が欠員
        sb.append(CODE_CHAR[_5050103]);

        // 日割　1-日割でない 2-日割である
        sb.append(CODE_CHAR[_5050104]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        
        // 6109 通所型サービス若年性認知症受入加算
        if (_5050110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // 同一建物居住者へのサービス提供がありの場合
        if (_16 > 1) {
            
            // 通所型サービス費で分岐
            switch(_5050101) {
            // 通所型サービス１
            case 1:
                // 通所型サービス同一建物減算１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
                break;
            // 通所型サービス２
            case 2:
                // 通所型サービス同一建物減算２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                break;
            }
            
        }
        
        // 生活機能向上グループ活動加算　1-なし 2-あり
        if (_5050105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5010");
        }
        
        // 運動器機能向上加算、栄養改善加算、口腔機能向上加算の例外処理
        // 
        // [運動器機能向上加算のフラグ][栄養改善加算のフラグ][口腔機能向上加算のフラグ]
        // という並びの3桁の数値を作成して分岐（フラグは 1-なし 2-あり）
        int addParam = (_5050106 * 100) + (_5050107 * 10) + _5050108;
        
        switch(addParam) {
        // 運動器機能向上加算
        case 211:
            // 通所型サービス運動器機能向上加算
            putSystemServiceCodeItem(sysSvcCdItems, "Z5002");
            break;
        // 栄養改善加算
        case 121:
            // 通所型サービス栄養改善加算
            putSystemServiceCodeItem(sysSvcCdItems, "Z5003");
            break;
        // 口腔機能向上加算
        case 112:
            // 通所型サービス口腔機能向上加算
            putSystemServiceCodeItem(sysSvcCdItems, "Z5004");
            break;
        // 運動器機能向上加算 + 栄養改善加算
        case 221:
            // 通所型複数サービス実施加算I１
            putSystemServiceCodeItem(sysSvcCdItems, "Z5006");
            break;
        // 運動器機能向上加算 + 口腔機能向上加算
        case 212:
            // 通所型複数サービス実施加算I２
            putSystemServiceCodeItem(sysSvcCdItems, "Z5007");
            break;
        // 栄養改善加算 + 口腔機能向上加算
        case 122:
            // 通所型複数サービス実施加算I３
            putSystemServiceCodeItem(sysSvcCdItems, "Z5008");
            break;
        // 運動器機能向上加算 + 栄養改善加算 + 口腔機能向上加算
        case 222:
            // 通所型複数サービス実施加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z5009");
            break;
        }
        
        // 事業所評価加算　1-なし 2-あり
        if (_5050109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5005");
        }
        
        switch (_5050111) {
        case 4:
            if (_5050101 == 1) {
                // 通所型サービス１の場合
                // 6101 通所型サービス提供体制加算Iイ１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6107");
            } else if (_5050101 == 2) {
                // 通所型サービス２の場合
                // 6102 通所型サービス提供体制加算Iイ２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
            }
            break;
        case 2:
            if (_5050101 == 1) {
                // 通所型サービス１の場合
                // 6101 通所型サービス提供体制加算Iロ１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            } else if (_5050101 == 2) {
                // 通所型サービス２の場合
                // 6102 通所型サービス提供体制加算Iロ２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            }
            break;
        case 3:
            if (_5050101 == 1) {
                // 通所型サービス１の場合
                // 6103 通所型サービス提供体制加算II１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            } else if (_5050101 == 2) {
                // 通所型サービス２の場合
                // 6104 通所型サービス提供体制加算II２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            }
            break;
        }
        
        
        // 介護職員処遇改善を返却
        switch (_17) {
        case 5:
            // 通所型サービス処遇改善加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6110");
            break;
        case 2:
            // 通所型サービス処遇改善加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6111");
            break;
        case 3:
            // 通所型サービス処遇改善加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6113");
            break;
        case 4:
            // 通所型サービス処遇改善加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z6115");
            break;
        }
        
        
        // 日割りではない場合
        if (_5050104 == 1) {
            
            // 月単位サービスの場合
            if (_5050102 == 1) {
                // 8110 通所型サービス中山間地域等提供加算
                if (_12 > 1) {
                    putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
                }
                
            // 回数単位サービスの場合
            } else if (_5050102 == 2) {
                // 8112 通所型サービス中山間地域等加算回数
                if (_12 > 1) {
                    putSystemServiceCodeItem(sysSvcCdItems, "Z8112");
                }
            }
            
        // 日割りの場合
        } else {
            
            // 8111 通所型サービス中山間地域等加算日割
            if (_12 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z8111");
            }
        }

        return sysSvcCdItems;
    }

}
