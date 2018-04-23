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
 * 介護予防短期入所療養介護(老健)
 * 
 * @since V7.0.0
 * @author Kamei.Yoichiro
 * 
 */
public class SC_12511_201804 extends Qkan10011_ServiceUnitGetter {
    private int _1250111 = 0;

    private final String PATH_UNIT_ROOM = "1250112";
    private final String PATH_UNIT_SEMI_ROOM = "1250113";
    private final String PATH_NORMAL_ROOM = "1250114";
    private final String PATH_TASHO_ROOM = "1250115";

    public String getServiceName() {
        return "介護予防短期入所療養介護(老健)";
    }

    public String getServiceCodeKind() {
        return "25";
    }

    public String getSystemServiceKindDetail() {
        return "12511";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 6 送迎加算
        int _6 = getIntValue(map, "6");

        // 1250101 施設等の区分
        // 1-介護老人保健施設（I） 2-ユニット型介護老人保健施設（I） 3-介護老人保健施設（II）
        // 4-ユニット型介護老人保健施設（II） 5-介護老人保健施設（III） 6-ユニット型介護老人保健施設（III）
        int _1250101 = getIntValue(map, "1250101", 1);

        // 1250102 病室区分(従来型)　1-従来型個室 2-多床室
        int _1250102 = getIntValue(map, "1250102", 1);
        
        // 1250103 病室区分(ユニット型)　1-ユニット型個室 2-ユニット型準個室
        int _1250103 = getIntValue(map, "1250103", 1);
        
        // 変換
        int byoshitsuKubun = 0;
        switch (_1250101) {
        case 1: // 1-介護老人保健施設（I）
        case 3: // 3-介護老人保健施設（II）
        case 5: // 5-介護老人保健施設（III）
        case 7: // 5-介護老人保健施設（IV）2018.04
            // 従来型
            byoshitsuKubun = convertByoshitsuKbn(_1250102, false);
            break;
        case 2: // 2-ユニット型介護老人保健施設（I）
        case 4: // 4-ユニット型介護老人保健施設（II）
        case 6: // 6-ユニット型介護老人保健施設（III）
        case 8: // 6-ユニット型介護老人保健施設（IV）2018.04
            // ユニット型
            byoshitsuKubun = convertByoshitsuKbn(_1250103, true);
            break;
        }
        
        // 1250104 夜間勤務条件基準　1-基準型 2-減算型
        int _1250104 = getIntValue(map, "1250104", 1);

        // 1250106 緊急時治療管理加算　1-なし 2-あり
        int _1250106 = getIntValue(map, "1250106", 1);

        // 1250114　療養体制維持特別加算I
        int _1250114 = getIntValue(map, "1250114", 1);

        // 1250126 療養体制維持特別加算II 2018.04
        int _1250126 = getIntValue(map, "1250126");

        // 1250108 療養食加算
        int _1250108 = getIntValue(map, "1250108", 1);

        // 1250109 人員減算　1-なし 2-定員超過 3-看護・介護職員又は医師・PT・OTの不足
        int _1250109 = getIntValue(map, "1250109", 1);

        // 1250110 食事提供　1-なし 2-三食 3-朝 4-昼 5-夜 6-朝昼 7-昼夜 8-夜朝
        int _1250110 = getIntValue(map, "1250110", 1);

        // 1250111 食事費用
        this._1250111 = getIntValue(map, "1250111");

        // 1250120 夜勤職員配置加算
        int _1250120 = getIntValue(map, "1250120");

        // 1250121 個別リハビリ実施加算
        int _1250121 = getIntValue(map, "1250121");

        // 1250122 認知症行動・心理症状緊急対応加算
        int _1250122 = getIntValue(map, "1250122");

        // 1250123 若年性認知症利用者受入加算
        int _1250123 = getIntValue(map, "1250123");

        // 1250117 サービス提供体制強化加算
        int _1250117 = getIntValue(map, "1250117");

        // 1250112 ユニットケアの整備　1-未整備 2-整備
        int _1250112 = getIntValue(map, "1250112", 1);
        
        // 1250124 人員配置区分 1-基本型 2-在宅強化型
        int _1250124 = getIntValue(map, "1250124", 1);
        
        // 1250127 在宅復帰・在宅療養支援機能加算 2018.04
        int _1250127 = getIntValue(map, "1250127");
        
        // 1250128 認知症専門ケア加算 2018.04
        int _1250128 = getIntValue(map, "1250128");

        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設等の区分
        sb.append(CODE_CHAR[_1250101]);
        
        // 病室区分(従来型個室、多床室)
        sb.append(CODE_CHAR[_1250102]);
        
        // 病室区分(ユニット型個室、ユニット型準個室)
        sb.append(CODE_CHAR[_1250103]);
        
        // 人員配置区分
        sb.append(CODE_CHAR[_1250124]);
        
        // 要介護度
        sb.append(CODE_CHAR[_1]);
        
        // 夜間勤務条件基準　1-基準型 2-減算型
        sb.append(CODE_CHAR[_1250104]);

        // 人員減算　1-なし 2-定員超過 3-看護・介護職員又は医師・PT・OTの不足
        sb.append(CODE_CHAR[_1250109]);

        // ユニットケアの整備
        switch (_1250101) {
        case 1: // 1-介護老人保健施設（I）
        case 3: // 3-介護老人保健施設（II）
        case 5: // 5-介護老人保健施設（III）
        case 7: // 7-介護老人保健施設（IV）
            // 従来型
            sb.append(DEFAULT_CHAR);
            break;
        case 2: // 2-ユニット型介護老人保健施設（I）
        case 4: // 4-ユニット型介護老人保健施設（II）
        case 6: // 6-ユニット型介護老人保健施設（III）
        case 8: // 8-ユニット型介護老人保健施設（IV）
            // ユニット型
            // 1-未整備 2-整備
            if (_1250112 > 1) {
                sb.append(DEFAULT_CHAR);
            } else {
                sb.append(CODE_CHAR[2]);
            }
            break;
        }

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        
        // 6117 予老短夜勤職員配置加算
        if (_1250120 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6117");
        }
        
        
        // 6111 予老短個別リハビリ加算
        if (_1250121 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6111");
        }
        
        // 6121 予老短認知症緊急対応加算
        if (_1250122 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6121");
        }
        
        // 6109 予老短若年性認知症受入加算
        if (_1250123 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // 送迎加算
        switch (_6) {
        case 3: // 往復
            putSystemServiceCodeItem(sysSvcCdItems, "Z19202");
        case 2: // 片道
            putSystemServiceCodeItem(sysSvcCdItems, "Z19201");
            break;
        }
        
        // 療養体制維持特別加算I
        if (_1250114 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6601");
        }
        
        // 療養体制維持特別加算II
        if (_1250126 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6602");//2018.04
        }
        
        // 1250127	在宅復帰・在宅療養支援機能加算
        if (_1250127 > 1) {
            switch (_1250124) { // 人員配置区分
            case 1: // 基本型
                putSystemServiceCodeItem(sysSvcCdItems, "Z6280");//2018.04
                break;
            case 2: // 在宅強化型
                putSystemServiceCodeItem(sysSvcCdItems, "Z6281");//2018.04
                break;
            }
        }        
        
        // 1250128	認知症専門ケア加算
        switch (_1250128) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6133");//2018.04
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6134");//2018.04
            break;
        }
        
        // 療養食加算
        switch (_1250108) {
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
        // 緊急時治療管理加算　1-なし 2-あり
        if (_1250106 > 1) {
            
            //施設区分で分岐
            switch(_1250101) {
            //療養型以外
            case 1: // 1-介護老人保健施設（I）
            case 2: // 2-ユニット型介護老人保健施設（I）
            case 7: // 1-介護老人保健施設（IV）
            case 8: // 2-ユニット型介護老人保健施設（IV）
                // 予老短緊急時治療管理１
                putSystemServiceCodeItem(sysSvcCdItems, "Z9000");
                break;

            //療養型
            case 3: // 3-介護老人保健施設（II）
            case 4: // 4-ユニット型介護老人保健施設（II）
            case 5: // 5-介護老人保健施設（III）
            case 6: // 6-ユニット型介護老人保健施設（III）
                // 予老短緊急時治療管理２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6000");
                break;
            }
            
        }
        
        switch (_1250117) {
        case 5:
            // 6100 予老短サービス提供体制加算Iイ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");
            break;
        case 2:
            // 6101 予老短サービス提供体制加算Iロ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // 6102 予老短サービス提供体制加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
            // 6103 予老短サービス提供体制加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }
        
        // 介護職員処遇改善を返却
        switch (_17) {
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2017.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");//2015.04
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
        

        // 特定入所者
        if (!new Integer(1).equals(map.get("7")) && !"1".equals(map.get("7"))) {
            // 食事提供
            if (_1250110 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }
            // 滞在費 --------
            putSystemServiceCodeItem(sysSvcCdItems,
                    getSystemServiceCodeOfRoom(byoshitsuKubun));
        }

        return sysSvcCdItems;
    }

    public ArrayList getServiceCode(Map map, ACDBManager dbm) {
        ArrayList al = super.getServiceCode(map, dbm);
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
                if (this._1250111 <= 0) {
                    // 食費が0円以下の場合
                    // 該当レコードを削除する。
                    al.remove(i);
                    // 削除したためインデックスを1つ戻す。
                    i--;
                } else {
                    // 食費が0円以下でない場合
                    // 食費を業務から渡された値で上書きする。
                    mp.put("SERVICE_UNIT", new Integer(this._1250111));
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
