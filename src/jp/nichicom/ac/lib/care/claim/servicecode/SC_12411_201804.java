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
 * 介護予防短期入所生活介護
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_12411_201804 extends Qkan10011_ServiceUnitGetter {
    private int _1240110 = 0;

    private final String PATH_UNIT_ROOM = "1240112";
    private final String PATH_UNIT_SEMI_ROOM = "1240113";
    private final String PATH_NORMAL_ROOM = "1240114";
    private final String PATH_TASHO_ROOM = "1240115";

    public String getServiceName() {
        return "介護予防短期入所生活介護";
    }

    public String getServiceCodeKind() {
        return "24";
    }

    public String getSystemServiceKindDetail() {
        return "12411";
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

        // 1240101 施設等の区分　1-単独型 2-併設型 3-単独型ユニット型 4-併設型ユニット型
        int _1240101 = getIntValue(map, "1240101", 1);

        // 1240102 病室区分(従来型)　1-従来型個室 2-多床室
        // 1240103 病室区分(ユニット型)　1-ユニット型個室 2-ユニット型準個室
        // 変換→1-従来型個室 2-多床室 3-ユニット型個室 4-ユニット型準個室
        int byoshitsuKubun = 0;
        if (_1240101 > 2) {
            // ユニット型
            byoshitsuKubun = convertByoshitsuKbn(getIntValue(map, "1240103"),
                    true);
        } else {
            // 従来型
            byoshitsuKubun = convertByoshitsuKbn(getIntValue(map, "1240102"),
                    false);
        }

        // 1240104 夜間勤務条件基準　1-基準型 2-減算型
        int _1240104 = getIntValue(map, "1240104", 1);

        // 1240105 機能訓練体制加算　1-なし 2-あり
        int _1240105 = getIntValue(map, "1240105", 1);

        // 1240107 療養食加算
        int _1240107 = getIntValue(map, "1240107", 1);

        // 1240108 人員減算　1-なし 2-定員超過 3-看護・介護職員の不足
        int _1240108 = getIntValue(map, "1240108", 1);

        // 1240109 食事提供　1-なし 2-三食 3-朝 4-昼 5-夜 6-朝昼 7-昼夜 8-夜朝
        int _1240109 = getIntValue(map, "1240109", 1);

        // 1240110 食事費用
        this._1240110 = getIntValue(map, "1240110", 1);

        // 1240114 認知症行動・心理症状緊急対応加算
        int _1240114 = getIntValue(map, "1240114", 1);

        // 1240112 若年性認知症利用者受入加算
        int _1240112 = getIntValue(map, "1240112", 1);

        // 1240113 サービス提供体制強化加算
        int _1240113 = getIntValue(map, "1240113", 1);

        // 1240111 ユニットケアの整備　1-未整備 2-整備　※変換→1-整備 2-未整備
        int _1240111 = getIntValue(map, "1240111", 1);
        
        // 1240115	個別機能訓練加算
        int _1240115 = getIntValue(map, "1240115", 1);

        
        // 22 共生型
        int _22 = getIntValue(map, "22", 1);
        
        // 1240116 生活相談員配置等加算
        int _1240116 = getIntValue(map, "1240116");
        
        // 1240117 生活機能向上連携加算
        int _1240117 = getIntValue(map, "1240117");
        
        // 1240118 認知症専門ケア加算
        int _1240118 = getIntValue(map, "1240118");
        
        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設等の区分　1-単独型 2-併設型 3-単独型ユニット型 4-併設型ユニット型
        sb.append(CODE_CHAR[_1240101]);

        // 病室区分　変換→1-従来型個室 2-多床室 3-ユニット型個室 4-ユニット型準個室
        sb.append(CODE_CHAR[byoshitsuKubun]);

        // 要介護度
        sb.append(CODE_CHAR[_1]);

        // 夜間勤務条件基準　1-基準型 2-減算型
        sb.append(CODE_CHAR[_1240104]);

        // 人員減算　1-なし 2-定員超過 3-看護・介護職員の不足
        sb.append(CODE_CHAR[_1240108]);

        // ユニットケアの整備
        switch (_1240101) {
        case 1: //個室・多床室
        case 2:
            sb.append(DEFAULT_CHAR);
            break;
        case 3: //ユニット型
        case 4:
            // 1-未整備 2-整備
            if (_1240111 > 1) {
                sb.append(DEFAULT_CHAR);
            } else {
                sb.append(CODE_CHAR[2]);
            }
            break;
        }

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        // 送迎加算
        switch (_6) {
        case 3: // 往復
            putSystemServiceCodeItem(sysSvcCdItems, "Z92002");
        case 2: // 片道
            putSystemServiceCodeItem(sysSvcCdItems, "Z92001");
            break;
        }

        // 6004 予短期生活機能訓練体制加算
        if (_1240105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6004");
        }
        
        // 6121 予短期生活認知症緊急対応加算
        if (_1240114 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6121");
        }
        
        // 6109 予短期生活若年性認知症受入加算
        if (_1240112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // 療養食加算 2018.04
        switch (_1240107) {
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
        
        // 個別機能訓練加算
        if (_1240115 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6005");
        }
        
        // 共生型 //2018.04
        switch (_22) {
        case 10:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6368");
            break;
        }
        
        // 1240116 生活相談員配置等加算
        if (_1240116 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6350");//2018.04
        }
        
        // 1240117 生活機能向上連携加算
        if (_1240117 > 1) {
        	if (_1240115 > 1) { //個別機能訓練加算を算定している場合
        		putSystemServiceCodeItem(sysSvcCdItems, "Z4003"); //2018.04
        	} else {
        		putSystemServiceCodeItem(sysSvcCdItems, "Z4002"); //2018.04
        	}
        }
        
        // 1240118	認知症専門ケア加算
        switch (_1240118) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6133");//2018.04
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6134");//2018.04
            break;
        }

        switch (_1240113) {
        case 5:
            // 6101 予短期生活サービス提供体制加算Iイ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");
            break;
        case 2:
            // 6101 予短期生活サービス提供体制加算Iロ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // 6102 予短期生活サービス提供体制加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
            // 6103 予短期生活サービス提供体制加算III
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
            if (_1240109 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }
            // 滞在費 --------
            putSystemServiceCodeItem(sysSvcCdItems,
                    getSystemServiceCodeOfRoom(byoshitsuKubun));
        }

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
                if (this._1240110 <= 0) {
                    // 食費が0円以下の場合
                    // 該当レコードを削除する。
                    al.remove(i);
                    // 削除したためインデックスを1つ戻す。
                    i--;
                } else {
                    // 食費が0円以下でない場合
                    // 食費を業務から渡された値で上書きする。
                    mp.put("SERVICE_UNIT", new Integer(this._1240110));
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
