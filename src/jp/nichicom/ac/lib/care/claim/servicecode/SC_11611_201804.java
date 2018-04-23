package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 通所リハビリテーション
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_11611_201804 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "通所リハビリテーション";
    }

    public String getServiceCodeKind() {
        return "16";
    }

    public String getSystemServiceKindDetail() {
        return "11611";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================
        // 1160116 施設区分
        int _1160116 = getIntValue(map, "1160116" ,1);

        // 1160104 時間区分
        int _1160104 = getIntValue(map, "1160104" ,1);

        // 1160109 人員減算
        int _1160109 = getIntValue(map, "1160109" ,1);

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1160105 入浴加算
        int _1160105 = getIntValue(map, "1160105" ,1);

        // 1160111 リハビリテーション・マネジメント加算
        int _1160111 = getIntValue(map, "1160111" ,1);

        // 1160112 短期集中個別リハビリ実施加算
        int _1160112 = getIntValue(map, "1160112" ,1);

        // 1160114 栄養改善加算
        int _1160114 = getIntValue(map, "1160114" ,1);

        // 1160115 口腔機能向上加算
        int _1160115 = getIntValue(map, "1160115" ,1);
        
        
        // 1160119 理学療法士等体制強化加算
        int _1160119 = getIntValue(map, "1160119" , 1);
        
        // 1160120 認知症短期集中リハビリ実施加算I型
        int _1160120 = getIntValue(map, "1160120" , 1);
        
        // 1160121 若年性認知症利用者受入加算
        int _1160121 = getIntValue(map, "1160121" , 1);
        
        // 12 中山間地域等でのサービス提供加算
        int _12 = getIntValue(map, "12", 1);
        
        // 1160122 サービス提供体制強化加算
        int _1160122 = getIntValue(map, "1160122" ,1);
        
        // 1160123 重度療養管理加算
        int _1160123 = getIntValue(map, "1160123", 1);
        
        // 1160124 生活行為向上リハビリ実施加算　1-なし 2-3月以内 3-3月超6月以内
        int _1160124 = getIntValue(map, "1160124", 1);
        
        // 1160127 生活行為向上リハビリ後の継続減算　1-なし 2-あり
        int _1160127 = getIntValue(map, "1160127", 1);
        
        // 1160125 中重度者ケア体制加算 1-なし 2-あり
        int _1160125 = getIntValue(map, "1160125", 1);
        
        // 1160126 社会参加支援加算　1-なし 2-あり
        int _1160126 = getIntValue(map, "1160126", 1);

        
        // 1160128	リハビリテーション提供体制加算
        int _1160128 = getIntValue(map, "1160128");
        
        // 1160129	栄養スクリーニング加算
        int _1160129 = getIntValue(map, "1160129");

        // 16 同一建物居住者へのサービス提供
        int _16 = getIntValue(map, "16", 1);
        
        // 18 送迎減算
        int _18 = getIntValue(map, "18");
        
        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map, Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);
        
 
        // 訪問看護療養費領収書対応
        // 単独加算
        int _9 = getIntValue(map,"9");
 
        // 単独加算のみ---------------------------------------------------------------
        // 単独加算サービス
        if(_9 == 2){
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            
            if (_1160111 == 3) {
                // 通所リハマネジメント加算Ⅱ１
                putSystemServiceCodeItem(sysSvcCdItems, "Z5608");//2015.04
            } else if (_1160111 == 4) {
                // 通所リハマネジメント加算Ⅱ２
                putSystemServiceCodeItem(sysSvcCdItems, "Z5609");//2015.04
            } else if (_1160111 == 5) {
                // 通所リハマネジメント加算III1
                putSystemServiceCodeItem(sysSvcCdItems, "Z5615");//2018.04
            } else if (_1160111 == 6) {
                // 通所リハマネジメント加算III２
                putSystemServiceCodeItem(sysSvcCdItems, "Z5616");//2018.04
            } else if (_1160111 == 7) {
                // 通所リハマネジメント加算IV1
                putSystemServiceCodeItem(sysSvcCdItems, "Z5617");//2018.04
            } else if (_1160111 == 8) {
                // 通所リハマネジメント加算IV2
                putSystemServiceCodeItem(sysSvcCdItems, "Z5618");//2018.04
            }
            
            // 介護職員処遇改善を返却
            switch(_17){
            case 6:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6107");//2017.04
                break;
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");//2015.04
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
                break;
            }
            
            return sysSvcCdItems;
        }
        
        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();
        
        // 施設区分分解１ 通常規模、大規模事業所I、大規模事業所II
        int sisetuKubun1 = 1;
        switch (_1160116) {
        // 通常規模(病院・診療所)
        case 1:
        // 通常規模(老健施設)
        case 2:
        // 通常規模(介護医療院)
        case 7:
            sisetuKubun1 = 1;
            break;
        // 大規模I(病院・診療所)
        case 3:
        // 大規模I(老健施設)
        case 4:
        // 大規模I(介護医療院)
        case 8:
            sisetuKubun1 = 2;
            break;
        // 大規模II(病院・診療所)
        case 5:
        // 大規模II(老健施設)
        case 6:
        // 大規模II(介護医療院)
        case 9:
            sisetuKubun1 = 3;
            break;
        }
        
        // 施設区分分解２ 病院又は診療所、介護老人保健施設
        int sisetuKubun2 = 1;
        switch (_1160116) {
        // 通常規模(病院・診療所)
        case 1:
        // 大規模I(病院・診療所)
        case 3:
        // 大規模II(病院・診療所)
        case 5:
            sisetuKubun2 = 1;
            break;
        // 通常規模(老健施設)
        case 2:
        // 大規模I(老健施設)
        case 4:
        // 大規模II(老健施設)
        case 6:
            sisetuKubun2 = 2;
            break;
        // 通常規模(介護医療院)
        case 7:
        // 大規模I(介護医療院)
        case 8:
        // 大規模II(介護医療院)
        case 9:
            sisetuKubun2 = 3;
            break;
        }
        
        // 施設区分(規模)
        sb.append(CODE_CHAR[sisetuKubun1]);
        // 施設区分(形態)
        sb.append(CODE_CHAR[sisetuKubun2]);

        // 時間区分
        sb.append(CODE_CHAR[_1160104]);

        // 人員減算
        sb.append(CODE_CHAR[_1160109]);
        
        // 生活行為向上リハビリ後の継続減算 //2015.04
        sb.append(CODE_CHAR[_1160127]);
        
        // 要介護度
        sb.append(CODE_CHAR[_1]);
        


        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        // 6143 通所リハ理学療法士等体制強化加算
        if (_1160119 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6143");
        }
        
        // 8110 通所リハ中山間地域等提供加算
        if (_12 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
        }
        
        // 入浴加算
        if (_1160105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5301");
        }
        
        
        // リハビリテーション・マネジメント加算
        switch (_1160111) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z5601");
            break;
        case 3:
            // 通所リハマネジメント加算Ⅱ１
            putSystemServiceCodeItem(sysSvcCdItems, "Z5608");//2015.04
            break;
        case 4:
            // 通所リハマネジメント加算Ⅱ２
            putSystemServiceCodeItem(sysSvcCdItems, "Z5609");//2015.04
            break;
        case 5:
            // 通所リハマネジメント加算III１
            putSystemServiceCodeItem(sysSvcCdItems, "Z5615");//2018.04
            break;
        case 6:
            // 通所リハマネジメント加算III２
            putSystemServiceCodeItem(sysSvcCdItems, "Z5616");//2018.04
            break;
        case 7:
            // 通所リハマネジメント加算IV１
            putSystemServiceCodeItem(sysSvcCdItems, "Z5617");//2018.04
            break;
        case 8:
            // 通所リハマネジメント加算IV２
            putSystemServiceCodeItem(sysSvcCdItems, "Z5618");//2018.04
            break;
        }
        
        // 短期集中個別リハビリ実施加算
        if (_1160112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5613");//2015.04
        }
        
        
        // 6253 通所リハ認知症短期集中リハ加算
        switch (_1160120) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6253");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6254");//2015.04
            break;
        }
        
        // 1160124 生活行為向上リハビリ実施加算
        switch (_1160124) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6255");//2015.04
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6256");//2015.04
            break;
        }
        
        
        // 6109 通所リハ若年性認知症受入加算
        if (_1160121 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // 栄養改善加算
        if (_1160114 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5605");
        }
        
        // 口腔機能向上加算
        if (_1160115 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5606");
        }
        
        // 重度療養管理加算
        if (_1160123 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5610");
        }
        
        // 同一建物減算
        if (_16 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5611");
        }
        
        // 1160125 中重度者ケア体制加算
        if (_1160125 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5614");//2015.04
        }
        
        // 1160126 社会参加支援加算
        if (_1160126 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6110");//2015.04
        }
        
        // 1160128	リハビリテーション提供体制加算 //2018.04
        if (_1160128 > 1) {
        	if (_1160104 == 3) {
                // リハビリ提供体制加算１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6144");
            } else if (_1160104 == 4) {
                // リハビリ提供体制加算２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6145");
            } else if (_1160104 == 5) {
                // リハビリ提供体制加算３
                putSystemServiceCodeItem(sysSvcCdItems, "Z6146");
            } else if (_1160104 == 6) {
                // リハビリ提供体制加算４
                putSystemServiceCodeItem(sysSvcCdItems, "Z6147");
            } else if (_1160104 >= 7) {
                // リハビリ提供体制加算５
                putSystemServiceCodeItem(sysSvcCdItems, "Z6148");
            } 
        }
        
        // 1160129	栄養スクリーニング加算
        if (_1160129 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6201");//2018.04
        }

        
        // 送迎減算
        switch (_18) {
        case 3: // 往復
            putSystemServiceCodeItem(sysSvcCdItems, "Z56122");//2015.04
        case 2: // 片道
            putSystemServiceCodeItem(sysSvcCdItems, "Z56121");//2015.04
            break;
        }

        
        // 通所リハサービス提供体制加算
        switch (_1160122) {
        // 通所リハサービス提供体制加算Iイ
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        // 通所リハサービス提供体制加算Iロ
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        // 通所リハサービス提供体制加算II
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        }
        
        // 介護職員処遇改善を返却
        switch(_17){
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");//2017.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
            break;
        }
        
        return sysSvcCdItems;
    }
}
