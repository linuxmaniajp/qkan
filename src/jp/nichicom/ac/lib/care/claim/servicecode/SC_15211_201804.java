package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * 介護保健施設
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_15211_201804 extends Qkan10011_ServiceUnitGetter {
    private int _1520122 = 0;

    private final String PATH_UNIT_ROOM = "1520114";
    private final String PATH_UNIT_SEMI_ROOM = "1520115";
    private final String PATH_NORMAL_ROOM = "1520116";
    private final String PATH_TASHO_ROOM = "1520117";

    public String getServiceName() {
        return "介護保健施設";
    }

    public String getServiceCodeKind() {
        return "52";
    }

    public String getSystemServiceKindDetail() {
        return "15211";
    }

    private boolean isRyoyoType(int _1520101) {
        boolean ret = true;
        switch (_1520101) {
        case 1: // 介護老人保健施設（I）
        case 2: // ユニット型介護老人保健施設（I）
            ret = false;
            break;
        }
        return ret;
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================
        // 1520101 施設区分
        int _1520101 = getIntValue(map, "1520101");

        // 1520102 病室区分(従来型)
        int _1520102 = getIntValue(map, "1520102");

        // 1520103 病室区分(ユニット型)
        int _1520103 = getIntValue(map, "1520103");

        // 病室区分
        int byoshitsu = 1;
        switch (_1520101) {
        case 1:
        case 3:
        case 5:
        case 7:
            byoshitsu = convertByoshitsuKbn(_1520102, false);
            break;
        case 2:
        case 4:
        case 6:
        case 8:
            byoshitsu = convertByoshitsuKbn(_1520103, true);
            break;
        }

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 経過措置対応用に要支援１または要支援２だった場合は要介護１とみなす
        if (_1 == 3 || _1 == 4) {
            _1 = 5;
        }

        // 1520104 夜間勤務条件基準
        int _1520104 = getIntValue(map, "1520104");

        // 1520119 人員減算
        int _1520119 = getIntValue(map, "1520119");

        // 1520127 ユニットケアの整備
        int _1520127 = getIntValue(map, "1520127");

        // 1520124 短期集中リハビリテーション加算
        int _1520124 = getIntValue(map, "1520124");

        // 1520125 認知症高齢者
        int _1520125 = getIntValue(map, "1520125");

        // 1520128 意思疎通困難等ケア加算
        int _1520128 = getIntValue(map, "1520128");

        // 1520130 身体拘束廃止未実施減算
        int _1520130 = getIntValue(map, "1520130");

        // 1520107 外泊加算
        int _1520107 = getIntValue(map, "1520107");

        // 1520108 初期加算
        int _1520108 = getIntValue(map, "1520108");

        // 3020105 退所時指導加算
        int _3020105 = getIntValue(map, "3020105");

        // 3020106 退所時情報提供加算
        int _3020106 = getIntValue(map, "3020106");

        // 3020107 退所前連携加算
        int _3020107 = getIntValue(map, "3020107");

        // 3020108 老人訪問看護指示加算
        int _3020108 = getIntValue(map, "3020108");

        // 1520111 栄養マネジメント加算
        int _1520111 = getIntValue(map, "1520111");

        // 1520112 経口移行加算
        int _1520112 = getIntValue(map, "1520112");

        // 1520126 経口維持加算I
        int _1520126 = getIntValue(map, "1520126");
        
        // 1520151 経口維持加算II
        int _1520151 = getIntValue(map, "1520151");

        // 1520134 療養体制維持特別加算I
        int _1520134 = getIntValue(map, "1520134");
        
        // 1520152 療養体制維持特別加算II
        int _1520152 = getIntValue(map, "1520152");

        // 1520113 療養食加算
        int _1520113 = getIntValue(map, "1520113");

        // 1520133 ターミナルケア加算
        int _1520141 = getIntValue(map, "1520141");

        // 1520109 緊急時治療管理加算
        int _1520109 = getIntValue(map, "1520109");

        // 1520120 食事提供
        int _1520120 = getIntValue(map, "1520120");

        // 1520122 食費
        this._1520122 = getIntValue(map, "1520122");

        // 1520135 口腔機能維持管理加算
        int _1520135 = getIntValue(map, "1520135");

        // 1520136 夜勤職員配置加算
        int _1520136 = getIntValue(map, "1520136");

        // 1520137 認知症専門ケア加算
        int _1520137 = getIntValue(map, "1520137");

        // 1520138 若年性認知症入所者受入加算
        int _1520138 = getIntValue(map, "1520138");

        // 1520139 認知症情報提供加算
        int _1520139 = getIntValue(map, "1520139");

        // 1520142 サービス提供体制強化加算
        int _1520142 = getIntValue(map, "1520142");

        // 単独加算
        int _9 = getIntValue(map, "9");

        // 1520143 人員配置区分
        int _1520143 = getIntValue(map, "1520143", 1);

        // 3020109 退所(院)前訪問指導加算
        int _3020109 = getIntValue(map, "3020109", 1);

        // 3020110 退所(院)後訪問指導加算
        int _3020110 = getIntValue(map, "3020110", 1);

        // 1520146 認知症行動・心理症状緊急対応加算
        int _1520146 = getIntValue(map, "1520146", 1);

        // 1520144 入所前後訪問指導加算
        int _1520144 = getIntValue(map, "1520144", 1);

        // 1520145 所定疾患施設療養費
        int _1520145 = getIntValue(map, "1520145", 1);

        // 1520147 地域連携診療計画情報提供加算
        int _1520147 = getIntValue(map, "1520147", 1);

        // 1520140 在宅復帰在宅療養支援加算
        int _1520140 = getIntValue(map, "1520140", 1);

        // 1510145 口腔機能維持管理体制加算
        int _1510145 = getIntValue(map, "1510145", 1);

        // 1520148 在宅復帰支援機能加算
        int _1520148 = getIntValue(map, "1520148", 1);

        // 1520153 外泊時在宅サービス利用費用
        int _1520153 = getIntValue(map, "1520153", 1);
        
        // 1520154 再入所時栄養連携加算
        int _1520154 = getIntValue(map, "1520154", 1);
        
        // 1520155 低栄養リスク改善加算
        int _1520155 = getIntValue(map, "1520155", 1);
        
        // 1520156 かかりつけ医連携調整加算
        int _1520156 = getIntValue(map, "1520156", 1);
        
        // 1520157 褥瘡マネジメント加算
        int _1520157 = getIntValue(map, "1520157", 1);
        
        // 1520158 排せつ支援加算
        int _1520158 = getIntValue(map, "1520158", 1);
        
        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 単独加算のみ---------------------------------------------------------------
        // 単独加算サービス
        if (_9 == 2) {

            // 退所後訪問指導加算
            if (_3020110 > 1) {

                // 在宅強化型
                if (_1520143 == 2) {
                    // 保健施設退所後訪問指導加算１
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6507");

                    // 在宅強化型以外
                } else {
                    // 保健施設退所後訪問指導加算２
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6508");
                }
            }

            // ターミナルケア加算
            switch (_1520141) {
            // 死亡日以前4日以上30日以下
            case 2:
                // 療養型以外
                if (!isRyoyoType(_1520101)) {
                    // 保健施設ターミナルケア加算１１
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6600");

                    // 療養型
                } else {
                    // 保健施設ターミナルケア加算１２
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6001");
                }
                break;

            // 死亡日以前2日又は3日
            case 3:
                // 療養型以外
                if (!isRyoyoType(_1520101)) {
                    // 保健施設ターミナルケア加算２１
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6602");

                    // 療養型
                } else {
                    // 保健施設ターミナルケア加算２２
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6002");
                }
                break;

            // 死亡日
            case 4:
                // 療養型以外
                if (!isRyoyoType(_1520101)) {
                    // 保健施設ターミナルケア加算３１
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6603");

                    // 療養型
                } else {
                    // 保健施設ターミナルケア加算３２
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6003");
                }
                break;
            }

            // 介護職員処遇改善を返却
            switch (_17) {
            case 6:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6111");//2017.04
                break;
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2015.04
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                break;
            }

            return sysSvcCdItems;
        }

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設区分
        sb.append(CODE_CHAR[_1520101]);

        // 病室区分(従来型個室/多床室)
        sb.append(CODE_CHAR[_1520102]);

        // 病室区分(ユニット型個室/ユニット型準個室)
        sb.append(CODE_CHAR[_1520103]);

        // 人員配置区分(従来型/在宅強化型)
        sb.append(CODE_CHAR[_1520143]);

        // 要介護度
        sb.append(CODE_CHAR[_1]);

        // 夜間勤務条件基準
        sb.append(CODE_CHAR[_1520104]);

        // 人員減算
        sb.append(CODE_CHAR[_1520119]);

        // ユニットケアの整備
        switch (_1520101) {
        case 1: // 個室・多床室
        case 3:
        case 5:
        case 7:
            sb.append(DEFAULT_CHAR);
            break;
        case 2: // ユニット型
        case 4:
        case 6:
        case 8:
            // 1-未整備 2-整備
            if (_1520127 > 1) {
                sb.append(DEFAULT_CHAR);
            } else {
                sb.append(CODE_CHAR[2]);
            }
            break;
        }

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================

        // Z6117 保健施設夜勤職員配置加算
        if (_1520136 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6117");
        }

        // 短期集中リハビリテーション加算
        if (_1520124 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6252");
        }

        // 認知症高齢者(認知症短期集中リハ加算)
        if (_1520125 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6253");
        }

        // 認知症ケア加算
        if (_1520128 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6254");
        }

        // Z6109 保健施設若年性認知症受入加算
        if (_1520138 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }

        // 1520140	在宅復帰・在宅療養支援機能加算
        if (_1520140 > 1) {
            switch (_1520143) { // 人員配置区分
            case 1: // 基本型
                putSystemServiceCodeItem(sysSvcCdItems, "Z6110");
                break;
            case 2: // 在宅強化型
                putSystemServiceCodeItem(sysSvcCdItems, "Z6112");//2018.04
                break;
            }
        }  

        // 身体拘束廃止未実施減算
        if (_1520130 > 1) {
            StringBuilder sb1 = new StringBuilder();
            // プレフィックス
            sb1.append(SYSTEM_SERVICE_CODE_PREFIX_SK);
            // 施設区分
            sb1.append(CODE_CHAR[_1520101]);
            // 病室区分(従来型個室/多床室)
            sb1.append(CODE_CHAR[_1520102]);
            // 病室区分(ユニット型個室/ユニット型個室的多床室)
            sb1.append(CODE_CHAR[_1520103]);
            // 人員配置区分(従来型/在宅強化型)
            sb1.append(CODE_CHAR[_1520143]);
            // 要介護度
            sb1.append(CODE_CHAR[_1]);
            putSystemServiceCodeItem(sysSvcCdItems, sb1.toString());
        }

        // 外泊加算
        if (_1520107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6300");
        }

        // ターミナルケア加算
        switch (_1520141) {
        // 死亡日以前4日以上30日以下
        case 2:
            // 療養型以外
            if (!isRyoyoType(_1520101)) {
                // 保健施設ターミナルケア加算１１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6600");

                // 療養型
            } else {
                // 保健施設ターミナルケア加算１２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6001");
            }
            break;

        // 死亡日以前2日又は3日
        case 3:
            // 療養型以外
            if (!isRyoyoType(_1520101)) {
                // 保健施設ターミナルケア加算２１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6602");

                // 療養型
            } else {
                // 保健施設ターミナルケア加算２２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6002");
            }
            break;

        // 死亡日
        case 4:
            // 療養型以外
            if (!isRyoyoType(_1520101)) {
                // 保健施設ターミナルケア加算３１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6603");

                // 療養型
            } else {
                // 保健施設ターミナルケア加算３２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6003");
            }
            break;
        }

        // 療養体制維持特別加算I
        if (_1520134 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6601");
        }

        // 1520152 療養体制維持特別加算II
        if (_1520152 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6604");//2018.04
        }
        
        
        // 初期加算
        if (_1520108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6400");
        }

        // 入所前後訪問指導加算
        switch(_1520144) {
        case 2:
            // 在宅強化型
            if (_1520143 == 2) {
                // 保健施設入所前後訪問指導加算I１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6401");

                // 在宅強化型以外
            } else {
                // 保健施設入所前後訪問指導加算I２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6402");
            }
            break;
        case 3:
            // 在宅強化型
            if (_1520143 == 2) {
                // 保健施設入所前後訪問指導加算II１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6403");//2015.04

                // 在宅強化型以外
            } else {
                // 保健施設入所前後訪問指導加算II２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6404");//2015.04
            }
        	break;
        }

        // 退所前訪問指導加算
        if (_3020109 > 1) {

            // 在宅強化型
            if (_1520143 == 2) {
                // 保健施設退所前訪問指導加算１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6501");

                // 在宅強化型以外
            } else {
                // 保健施設退所前訪問指導加算２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6506");
            }
        }

        // 退所後訪問指導加算
        if (_3020110 > 1) {

            // 在宅強化型
            if (_1520143 == 2) {
                // 保健施設退所後訪問指導加算１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6507");

                // 在宅強化型以外
            } else {
                // 保健施設退所後訪問指導加算２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6508");
            }
        }

        // 退所時指導加算
        if (_3020105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6502");
        }

        // 退所時情報提供加算
        if (_3020106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6504");
        }

        // 退所前連携加算
        if (_3020107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6505");
        }

        // 老人訪問看護指示加算
        if (_3020108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6503");
        }

        // 栄養マネジメント加算
        if (_1520111 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6273");
        }

        // 経口移行加算
        if (_1520112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6274");
        }

        // 経口維持加算
        if (_1520126 > 1) {
        	// 経口維持加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6280");
        }
        if (_1520151 > 1) {
        	// 維持加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6281");
        }
        

        // 口腔機能維持管理体制加算
        if (_1510145 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6122");
        }

        // 口腔機能維持管理加算
        if (_1520135 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6123");
        }

        // 療養食加算
        switch (_1520113) {
        case 2:
            // ３回
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
            break;
        case 3:
            // ２回
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
            break;
        case 4:
            // １回
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
            break;
        }

        // 1520153 外泊時在宅サービス利用費用
        if (_1520153 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6302");//2018.04
        }
        
        // 1520154 再入所時栄養連携加算
        if (_1520154 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6353");//2018.04
        }
        
        // 1520155 低栄養リスク改善加算
        if (_1520155 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6354");//2018.04
        }
        
        // 1520156 かかりつけ医連携調整加算
        if (_1520156 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6355");//2018.04
        }
        
        // 1520157 褥瘡マネジメント加算
        if (_1520157 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6356");//2018.04
        }
        
        // 1520158 排せつ支援加算
        if (_1520158 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6357");//2018.04
        }
        
        // 在宅復帰支援機能加算
        if (_1520148 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6279");
        }

        // 緊急時治療管理加算
        if (_1520109 > 1) {
            // 療養型以外
            if (!isRyoyoType(_1520101)) {
                // 緊急時治療管理１
                putSystemServiceCodeItem(sysSvcCdItems, "Z9000");

                // 療養型
            } else {
                // 緊急時治療管理２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6000");
            }
        }

        // 所定疾患施設療養費
        switch (_1520145) {
        case 2:
            // 所定疾患施設療養費I
            putSystemServiceCodeItem(sysSvcCdItems, "Z9100");
            break;
        case 3:
            // 所定疾患施設療養費II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");
            break;
        }

        // 認知症専門ケア加算
        switch (_1520137) {
        case 2:
            // Z6133 保健施設認知症専門ケア加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6133");
            break;
        case 3:
            // Z6134 保健施設認知症専門ケア加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6134");
            break;
        }

        // 認知症行動・心理症状緊急対応加算
        if (_1520146 > 1) {
            // 療養型以外
            if (!isRyoyoType(_1520101)) {
                // 保健施設認知症緊急対応加算１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6121");

                // 療養型
            } else {
                // 保健施設認知症緊急対応加算２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6004");
            }
        }

        // Z6135 保健施設認知症情報提供加算
        if (_1520139 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6135");
        }

        // 地域連携診療計画情報提供加算
        if (_1520147 > 1) {

            // 在宅強化型
            if (_1520143 == 2) {
                // 保健施設地域連携診療計画加算１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6136");

                // 在宅強化型以外
            } else {
                // 保健施設地域連携診療計画加算２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6137");
            }
        }

        switch (_1520142) {
        case 5:
            // Z6107 保健施設サービス提供体制加算Iイ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");//2015.04
            break;
        case 2:
            // Z6101 保健施設サービス提供体制加算Iロ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // Z6102 保健施設サービス提供体制加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
            // Z6103 保健施設サービス提供体制加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }

        // 介護職員処遇改善を返却
        switch (_17) {
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6111");//2017.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
            break;
        }

        // 特定入所者チェックがついていた場合は個室の単位数を追加
        if (!new Integer(1).equals(map.get("7")) && !"1".equals(map.get("7"))) {
            // 食事提供
            if (_1520120 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }
            // 2006/07/14 療養型対応
            // 2018/03/01 [H30.4改正対応][Yoichiro Kamei] mod - begin
            // 外泊加算であった場合初期化する
//            if (_1520107 > 1) {
            // 外泊加算、または外泊時在宅サービス利用費用であった場合初期化する
            if (_1520107 > 1 || _1520153 > 1) {
            // 2018/03/01 [H30.4改正対応][Yoichiro Kamei] mod - end
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // 滞在費 --------
            putSystemServiceCodeItem(sysSvcCdItems,
                    getSystemServiceCodeOfRoom(byoshitsu));
        }// チェックがついていない場合は何も返さない

        // 外泊がありだった場合は一律外泊のコードを返す
        if (_1520107 > 1) {
            // 外泊もしくは試行的退所を行っている場合は初期化処理を行わない
            if ("1".equals(map.get("7")) || new Integer(1).equals(map.get("7"))) {
                // 内部サービスコードを初期化
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // 外泊にあたるサービスコードを追加
            putSystemServiceCodeItem(sysSvcCdItems, "Z6300");

            // 介護職員処遇改善を返却
            switch (_17) {
            case 6:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6111");//2017.04
                break;
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2015.04
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                break;
            }

        }
        
        // 2018/03/01 [H30.4改正対応][Yoichiro Kamei] add - begin
        // 外泊時在宅サービス利用費用がありだった場合は一律外泊時在宅サービス利用費用のコードを返す
        if (_1520153 > 1) {
            // 外泊もしくは試行的退所を行っている場合は初期化処理を行わない
            if ("1".equals(map.get("7")) || new Integer(1).equals(map.get("7"))) {
                // 内部サービスコードを初期化
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // 外泊時在宅サービス利用費用にあたるサービスコードを追加
            putSystemServiceCodeItem(sysSvcCdItems, "Z6302");

            // 介護職員処遇改善を返却
            switch (_17) {
            case 6:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6111");//2017.04
                break;
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2015.04
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                break;
            }

        }
        // 2018/03/01 [H30.4改正対応][Yoichiro Kamei] add - end

        return sysSvcCdItems;
    }

    public ArrayList<VRMap> getServiceCode(Map<String, String> map,
            ACDBManager dbm) {
        ArrayList<VRMap> al = super.getServiceCode(map, dbm);
        Map<String, Integer> mp = null;
        // 特定入所者チェックがついてなかった場合は食費を上書きせずに返す
        //[ID:0000749][Shin Fujihara] 2012/10 edit begin 2012年度対応 特定入所者の履歴管理機能
//        if (new Integer(1).equals(map.get("7")) || "1".equals(map.get("7"))) {
//            // 食費は必要ないためデータを消す
//            return al;
//        }
        if (ACCastUtilities.toInt(map.get("7"), 1) != 2) {
        	//食費は必要ないためデータを消す
        	return al;
        }
        //[ID:0000749][Shin Fujihara] 2012/10 edit end 2012年度対応 特定入所者の履歴管理機能

        // 事業所情報の取得
        VRList temp = new VRArrayList();

        try {
            temp = QkanCommon.getProviderServiceDetail(dbm,
                    ACCastUtilities.toString(map.get("PROVIDER_ID")),
                    ACCastUtilities.toInt(getSystemServiceKindDetail(), 0));
        } catch (Exception e) {
            return al;
        }

        VRMap providerInfo = (VRMap) temp.get(0);

        for (int i = 0; i < al.size(); i++) {
            mp = (Map<String, Integer>) al.get(i);

            String val = ACCastUtilities.toString(
                    mp.get("SYSTEM_SERVICE_CODE_ITEM"), "");
            if (SERVICE_CODE_SHOKUHI.equals(val)) {
                // 食費のレコード
                if (this._1520122 <= 0) {
                    // 食費が0円以下の場合
                    // 該当レコードを削除する。
                    al.remove(i);
                    // 削除したためインデックスを1つ戻す。
                    i--;
                } else {
                    // 食費が0円以下でない場合
                    // 食費を業務から渡された値で上書きする。
                    mp.put("SERVICE_UNIT", new Integer(this._1520122));
                }
            } else if (SERVICE_CODE_UNIT_ROOM.equals(val)) {
                // ユニット型個室のレコード
                // 費用単価が0以下で設定されている場合、戻り値から削除
                // ユニット型個室の費用単価を取得
                int unitRoom = ACCastUtilities.toInt(
                        providerInfo.get(this.PATH_UNIT_ROOM), 0);
                if (unitRoom <= 0) {
                    // 該当レコードを削除する。
                    al.remove(i);
                    // 削除したためインデックスを1つ戻す。
                    i--;
                }
            } else if (SERVICE_CODE_UNIT_SEMI_ROOM.equals(val)) {
                // ユニット型準個室のレコード
                // 費用単価が0以下で設定されている場合、戻り値から削除
                // ユニット型準個室の費用単価を取得
                int unitSemiRoom = ACCastUtilities.toInt(
                        providerInfo.get(this.PATH_UNIT_SEMI_ROOM), 0);
                if (unitSemiRoom <= 0) {
                    // 該当レコードを削除する。
                    al.remove(i);
                    // 削除したためインデックスを1つ戻す。
                    i--;
                }
            } else if (SERVICE_CODE_NORMAL_ROOM.equals(val)) {
                // 従来型個室のレコード
                // 費用単価が0以下で設定されている場合、戻り値から削除
                // 従来型個室の費用単価を取得
                int normalRoom = ACCastUtilities.toInt(
                        providerInfo.get(this.PATH_NORMAL_ROOM), 0);
                if (normalRoom <= 0) {
                    // 該当レコードを削除する。
                    al.remove(i);
                    // 削除したためインデックスを1つ戻す。
                    i--;
                }
            } else if (SERVICE_CODE_TASHO_ROOM.equals(val)) {
                // 多床室のレコード
                // 費用単価が0以下で設定されている場合、戻り値から削除
                // 多床室の費用単価を取得
                int tashoRoom = ACCastUtilities.toInt(
                        providerInfo.get(this.PATH_TASHO_ROOM), 0);
                if (tashoRoom <= 0) {
                    // 該当レコードを削除する。
                    al.remove(i);
                    // 削除したためインデックスを1つ戻す。
                    i--;
                }
            }
        }

        return al;
    }
}
