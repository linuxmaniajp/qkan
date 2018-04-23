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
 * 介護予防短期入所療養介護(療養病床を有する診療所)
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_12612_201804 extends Qkan10011_ServiceUnitGetter {
    private int _1260210 = 0;

    private final String PATH_UNIT_ROOM = "1260211";
    private final String PATH_UNIT_SEMI_ROOM = "1260212";
    private final String PATH_NORMAL_ROOM = "1260213";
    private final String PATH_TASHO_ROOM = "1260214";

    public String getServiceName() {
        return "介護予防短期入所療養介護(療養病床を有する診療所)";
    }

    public String getServiceCodeKind() {
        return "26";
    }

    public String getSystemServiceKindDetail() {
        return "12612";
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

        // 1260201 施設等の区分　1-診療所 2-ユニット型診療所
        int _1260201 = getIntValue(map, "1260201", 1);

        // 1260202 人員配置区分　1-Ⅰ型 2-Ⅱ型
        int _1260202 = getIntValue(map, "1260202", 1);
        
        // 1260217 人員配置区分（ユニット型診療所型用）
        int _1260217 = getIntValue(map, "1260217");

        // 1260203 病室区分(従来型)　1-従来型個室 2-多床室
        // 1260204 病室区分(ユニット型)　1-ユニット型個室 2-ユニット型準個室
        // 変換→1-従来型個室 2-多床室 3-ユニット型個室 4-ユニット型準個室
        int byoshitsuKubun = 0;
        switch (_1260201) {
        case 1: // 診療所
            byoshitsuKubun = convertByoshitsuKbn(getIntValue(map, "1260203"), false);
            break;
        case 2: // ユニット型診療所
            byoshitsuKubun = convertByoshitsuKbn(getIntValue(map, "1260204"), true);
            break;
        }

        // 1260207 療養食加算
        int _1260207 = getIntValue(map, "1260207", 1);

        // 1260208 人員減算　1-なし 2-定員超過
        int _1260208 = getIntValue(map, "1260208", 1);

        // 1260209 食事提供　1-なし 2-三食 3-朝 4-昼 5-夜 6-朝昼 7-昼夜 8-夜朝
        int _1260209 = getIntValue(map, "1260209", 1);

        // 1260210 食事費用
        this._1260210 = getIntValue(map, "1260210");

        // 1260212 設備基準減算 1-基準型 2-減算型
        int _1260212 = getIntValue(map, "1260212", 1);

        // 1260211 ユニットケアの整備　1-未整備 2-整備
        int _1260211 = getIntValue(map, "1260211", 1);

        // 1260216 認知症行動・心理症状緊急対応加算
        int _1260216 = getIntValue(map, "1260216", 1);

        // 1260213 若年性認知症利用者受入加算
        int _1260213 = getIntValue(map, "1260213", 1);

        // 1260214 サービス提供体制強化加算
        int _1260214 = getIntValue(map, "1260214", 1);

        // 1260219 認知症専門ケア加算
        int _1260219 = getIntValue(map, "1260219");
        
        // 1260218 食堂の有無
        int _1260218 = getIntValue(map, "1260218");
        
        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設等の区分　1-診療所 2-ユニット型診療所
        sb.append(CODE_CHAR[_1260201]);
        
        // 人員配置区分１
        if (_1260201 == 1) {
        	 sb.append(CODE_CHAR[_1260202]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // 人員配置区分２
        if (_1260201 == 2) {
        	sb.append(CODE_CHAR[_1260217]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        

        // 病室区分　変換→1-従来型個室 2-多床室 3-ユニット型個室 4-ユニット型準個室
        sb.append(CODE_CHAR[byoshitsuKubun]);

        // 要介護度
        sb.append(CODE_CHAR[_1]);

        // 人員減算　1-なし 2-定員超過
        sb.append(CODE_CHAR[_1260208]);

        // ユニットケアの整備　変換→1-整備 2-未整備
        switch (_1260201) {
        case 1: // 診療所
            sb.append(DEFAULT_CHAR);
            break;
        case 2: // ユニット型診療所
            // 1-未整備 2-整備
            if (_1260211 > 1) {
                sb.append(DEFAULT_CHAR);
            } else {
                sb.append(CODE_CHAR[2]);
            }
            break;
        }
        
        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        
        // 設備基準減算 1-基準型 2-減算型
        if (_1260212 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3600");
        }
        
        // 3706 予診療所短期認知症緊急対応加算
        if (_1260216 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3706");
        }
        
        // 3704 予診療所短期若年性認知症受入加算
        if (_1260213 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3704");
        }
        
        // 送迎加算
        switch (_6) {
        case 3: // 往復
            putSystemServiceCodeItem(sysSvcCdItems, "Z39202");
        case 2: // 片道
            putSystemServiceCodeItem(sysSvcCdItems, "Z39201");
            break;
        }
        
        // 認知症専門ケア加算
        switch (_1260219) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6135");//2018.04
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6136");//2018.04
            break;
        }
        
        // 療養食加算
        switch (_1260207) {
        case 2:
            // ３回
            putSystemServiceCodeItem(sysSvcCdItems, "Z3775");
            putSystemServiceCodeItem(sysSvcCdItems, "Z3775");
            putSystemServiceCodeItem(sysSvcCdItems, "Z3775");
            break;
        case 3:
            // ２回
            putSystemServiceCodeItem(sysSvcCdItems, "Z3775");
            putSystemServiceCodeItem(sysSvcCdItems, "Z3775");
            break;
        case 4:
            // １回
            putSystemServiceCodeItem(sysSvcCdItems, "Z3775");
            break;
        }
        
        // 食堂の有無
        if (_1260218 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3610");//2018.04
        }
        
        switch (_1260214) {
        case 5:
            // 3700 予診療短期サービス提供体制加算Iイ
            putSystemServiceCodeItem(sysSvcCdItems, "Z3700");//2015.04
            break;
        case 2:
            // 3701 予診療短期サービス提供体制加算Iロ
            putSystemServiceCodeItem(sysSvcCdItems, "Z3701");
            break;
        case 3:
            // 3702 予診療短期サービス提供体制加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z3702");
            break;
        case 4:
            // 3703 予診療短期サービス提供体制加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z3703");
            break;
        }

        // 介護職員処遇改善を返却
        switch (_17) {
        case 6:
            // 予診療所短期処遇改善加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z3709");//2017.04
            break;
        case 5:
            // 予診療所短期処遇改善加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z3710");//2015.04
            break;
        case 2:
            // 予診療所短期処遇改善加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z3711");
            break;
        case 3:
            // 予診療所短期処遇改善加算IV
            putSystemServiceCodeItem(sysSvcCdItems, "Z3712");
            break;
        case 4:
            // 予診療所短期処遇改善加算V
            putSystemServiceCodeItem(sysSvcCdItems, "Z3713");
            break;
        }

        // 特定入所者
        if (!new Integer(1).equals(map.get("7")) && !"1".equals(map.get("7"))) {
            // 食事提供
            if (_1260209 > 1) {
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
                if (this._1260210 <= 0) {
                    // 食費が0円以下の場合
                    // 該当レコードを削除する。
                    al.remove(i);
                    // 削除したためインデックスを1つ戻す。
                    i--;
                } else {
                    // 食費が0円以下でない場合
                    // 食費を業務から渡された値で上書きする。
                    mp.put("SERVICE_UNIT", new Integer(this._1260210));
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
