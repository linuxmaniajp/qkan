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
 * 短期入所療養介護(療養病床を有する病院)
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_12311_201804 extends Qkan10011_ServiceUnitGetter {
    private int shokuhi = 0;

    private final String PATH_UNIT_ROOM = "1230114";
    private final String PATH_UNIT_SEMI_ROOM = "1230115";
    private final String PATH_NORMAL_ROOM = "1230116";
    private final String PATH_TASHO_ROOM = "1230117";

    public String getServiceName() {
        return "短期入所療養介護(療養病床を有する病院)";
    }

    public String getServiceCodeKind() {
        return "23";
    }

    public String getSystemServiceKindDetail() {
        return "12311";
    }

    private boolean isHigaeriShort(int shisetsu) {
        return shisetsu == 5;
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================
        // 1230101 施設区分
        int _1230101 = getIntValue(map, "1230101");

        // 1230102 人員配置区分
        int _1230102 = getIntValue(map, "1230102");
        
        // 1230122 人員配置区分（ユニット型病院療養型用）
        int _1230122 = getIntValue(map, "1230122");
        
        // 1230123	人員配置区分（病院経過型用）
        int _1230123 = getIntValue(map, "1230123");
        

        // 1230103 病室区分(従来型)
        int _1230103 = getIntValue(map, "1230103");

        // 1230104 病室区分(ユニット型)k
        int _1230104 = getIntValue(map, "1230104");

        // 病室区分
        int byoshitsu = 1;
        switch (_1230101) {
        case 1: // 病院療養型
        case 3: // 病院経過型
            byoshitsu = convertByoshitsuKbn(_1230103, false);
            break;
        case 2: // ユニット型病院療養型
        case 4: // ユニット型病院経過型
            byoshitsu = convertByoshitsuKbn(_1230104, true);
            break;
        case 5: // 日帰りショートステイ
            byoshitsu = getIntValue(map, "1230113");
            break;
        }

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1230149 人員減算
        int _1230149 = getIntValue(map, "1230149");

        // 1230111 ユニットケアの整備
        int _1230111 = getIntValue(map, "1230111");

        // 1230105 夜間勤務条件基準　1-基準型 2-減算型
        int _1230105 = getIntValue(map, "1230105");

        // 1230116 療養環境減算
        int _1230116 = getIntValue(map, "1230116");

        // 1230107 医師の配置基準
        int _1230107 = getIntValue(map, "1230107");

        // 6 送迎加算
        int _6 = getIntValue(map, "6");

        // 1230110 療養食加算
        int _1230110 = getIntValue(map, "1230110");

        // 1230150 食事提供
        int _1230150 = getIntValue(map, "1230150");

        // 1230153 食費
        this.shokuhi = getIntValue(map, "1230153");

        // 1230113 日帰りショート用病室区分
        int _1230113 = getIntValue(map, "1230113");

        // 1230117 時間区分
        int _1230117 = getIntValue(map, "1230117");

        // 1230120 認知症行動・心理症状緊急対応加算
        int _1230120 = getIntValue(map, "1230120", 1);

        // 1230114 若年性認知症利用者受入加算
        int _1230114 = getIntValue(map, "1230114", 1);

        // 1230115 サービス提供体制強化加算
        int _1230115 = getIntValue(map, "1230115", 1);

        // 1230121 緊急短期入所受入加算
        int _1230121 = getIntValue(map, "1230121", 1);
        
        // 1230124	認知症専門ケア加算
        int _1230124 = getIntValue(map, "1230124");
        
        // 1230125	夜間勤務等看護加算
        int _1230125 = getIntValue(map, "1230125");
        
        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map, Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設区分
        sb.append(CODE_CHAR[_1230101]);

        // 人員配置区分１
        if (_1230101 == 1) {
        	 sb.append(CODE_CHAR[_1230102]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // 人員配置区分２
        if (_1230101 == 2) {
        	sb.append(CODE_CHAR[_1230122]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // 人員配置区分３
        if (_1230101 == 3) {
        	sb.append(CODE_CHAR[_1230123]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // 従来型個室/多床室
        sb.append(CODE_CHAR[_1230103]);
        
        // ユニット型個室/ユニット型準個室
        sb.append(CODE_CHAR[_1230104]);
        
        // 要介護度
        if (isHigaeriShort(_1230101)) {
            // 日帰りショートの場合、要介護度は絡まない
            sb.append(DEFAULT_CHAR);
        } else {
            sb.append(CODE_CHAR[_1]);
        }

        // 時間区分
        sb.append(CODE_CHAR[_1230117]);

        // 人員減算
        sb.append(CODE_CHAR[_1230149]);
        
        // ユニットケアの整備
        switch (_1230101) {
        case 1: // 病院療養型
        case 3: // 病院経過型
        case 5: // 日帰りショートステイ
            sb.append(DEFAULT_CHAR);
            break;
            
        //ユニット型
        case 2: // ユニット型病院療養型
        case 4: // ユニット型病院経過型
            // 値を反転させる
            // 整備している場合
            if (_1230111 > 1)  {
                sb.append(DEFAULT_CHAR);
            // 未整備の場合
            } else {
                sb.append(CODE_CHAR[2]);
            }
            break;
        }
        

        // 夜間勤務条件基準
        sb.append(CODE_CHAR[_1230105]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        // 療養環境減算
        if (_1230116 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2601");
        }
        
        // 医師の配置基準
        if (_1230107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2700");
        }
        
        // 2706 病院療短認知症緊急対応加算
        if (_1230120 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2706");
        }
        
        // 緊急短期入所受入加算
        if (_1230121 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2777");
        }
        
        if (_1230114 > 1) {
            // 日帰りショートの場合
            if (isHigaeriShort(_1230101)) {
                // 2705 病院療短若年性認知症受入加算２
                putSystemServiceCodeItem(sysSvcCdItems, "Z2705");
            } else {
                // 2704 病院療短若年性認知症受入加算１
                putSystemServiceCodeItem(sysSvcCdItems, "Z2704");
            }
        }
        
        // 送迎加算
        switch (_6) {
        case 3: // 往復
            putSystemServiceCodeItem(sysSvcCdItems, "Z29202");
        case 2: // 片道
            putSystemServiceCodeItem(sysSvcCdItems, "Z29201");
            break;
        }
        
        // 1230125	夜間勤務等看護加算 //2018.04
        switch (_1230125) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2591");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2592");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2593");
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2594");
            break;
        }
        
        // 1230124	認知症専門ケア加算
        switch (_1230124) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2714");//2018.04
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2715");//2018.04
            break;
        }
        
        // 療養食加算
        switch (_1230110) {
        case 2:
            // ３回
            putSystemServiceCodeItem(sysSvcCdItems, "Z2775");
            putSystemServiceCodeItem(sysSvcCdItems, "Z2775");
            putSystemServiceCodeItem(sysSvcCdItems, "Z2775");
            break;
        case 3:
            // ２回
            putSystemServiceCodeItem(sysSvcCdItems, "Z2775");
            putSystemServiceCodeItem(sysSvcCdItems, "Z2775");
            break;
        case 4:
            // １回
            putSystemServiceCodeItem(sysSvcCdItems, "Z2775");
            break;
        }
        
        // 2707 病院療短サービス提供体制加算Iイ
        // 2701 病院療短サービス提供体制加算Iロ
        // 2702 病院療短サービス提供体制加算II
        // 2703 病院療短サービス提供体制加算III
        switch (_1230115) {
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2707");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2701");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2702");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2703");
            break;
        }
        
        
        // 介護職員処遇改善を返却
        switch(_17){
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2709");//2017.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2710");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2711");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2712");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2713");
            break;
        }

        // 特定入所者チェックがついていた場合は個室の単位数を追加
        if (!new Integer(1).equals(map.get("7")) && !"1".equals(map.get("7"))) {
            // 食事提供
            if (_1230150 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }
            // 滞在費 --------
            if (isHigaeriShort(_1230101)) {
                // 日帰りショートだった場合
                // 日帰りショート専用病室区分
                putSystemServiceCodeItem(sysSvcCdItems,
                        getSystemServiceCodeOfRoom(_1230113));
            } else {
                putSystemServiceCodeItem(sysSvcCdItems,
                        getSystemServiceCodeOfRoom(byoshitsu));
            }

        }// チェックがついていない場合は何も返さない

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
                if (this.shokuhi <= 0) {
                    // 食費が0円以下の場合
                    // 該当レコードを削除する。
                    al.remove(i);
                    // 削除したためインデックスを1つ戻す。
                    i--;
                } else {
                    // 食費が0円以下でない場合
                    // 食費を業務から渡された値で上書きする。
                    mp.put("SERVICE_UNIT", new Integer(this.shokuhi));
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
