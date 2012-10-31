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
 * 介護療養型医療施設(療養病床を有する病院)
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_15311_201204 extends Qkan10011_ServiceUnitGetter {
    private int _1530161 = 0;

    private final String PATH_UNIT_ROOM = "1530115";
    private final String PATH_UNIT_SEMI_ROOM = "1530116";
    private final String PATH_NORMAL_ROOM = "1530117";
    private final String PATH_TASHO_ROOM = "1530118";

    public String getServiceName() {
        return "介護療養型医療施設(療養病床を有する病院)";
    }

    public String getServiceCodeKind() {
        return "53";
    }

    public String getSystemServiceKindDetail() {
        return "15311";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================
        // 1530162 施設区分
        int _1530162 = getIntValue(map, "1530162");

        // 1530102 人員配置区分
        int _1530102 = getIntValue(map, "1530102", 1);

        // 1530103 病室区分(従来型)
        int _1530103 = getIntValue(map, "1530103");

        // 1530104 病室区分(ユニット型)
        int _1530104 = getIntValue(map, "1530104");

        // 病室区分
        int byoshitsu = 1;
        switch (_1530162) {
        case 1:
        case 3:
            byoshitsu = convertByoshitsuKbn(_1530103, false);
            break;
        case 2:
        case 4:
            byoshitsu = convertByoshitsuKbn(_1530104, true);
            break;
        }

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1530163 夜間勤務条件基準
        int _1530163 = getIntValue(map, "1530163");

        // 1530158 人員減算
        int _1530158 = getIntValue(map, "1530158");

        // 1530116 ユニットケアの整備
        int _1530116 = getIntValue(map, "1530116");

        // 1530168 療養環境減算
        int _1530168 = getIntValue(map, "1530168");

        // 1530107 医師の配置基準
        int _1530107 = getIntValue(map, "1530107");

        // 1530117 身体拘束廃止未実施減算
        int _1530117 = getIntValue(map, "1530117");

        // 1530108 外泊加算
        int _1530108 = getIntValue(map, "1530108");

        // 1530110 他科受診加算
        int _1530110 = getIntValue(map, "1530110");

        // 1530109 初期加算
        int _1530109 = getIntValue(map, "1530109");

        // 3020105 退所時指導加算
        int _3020105 = getIntValue(map, "3020105");

        // 3020106 退所時情報提供加算
        int _3020106 = getIntValue(map, "3020106");

        // 3020107 退所前連携加算
        int _3020107 = getIntValue(map, "3020107");

        // 3020108 老人訪問看護指示加算
        int _3020108 = getIntValue(map, "3020108");

        // 1530112 栄養マネジメント加算
        int _1530112 = getIntValue(map, "1530112");

        // 1530113 経口移行加算
        int _1530113 = getIntValue(map, "1530113");

        // 1530115 経口維持加算
        int _1530115 = getIntValue(map, "1530115");

        // 1530114 療養食加算
        int _1530114 = getIntValue(map, "1530114");

        // 1530118 在宅復帰支援機能加算
        int _1530118 = getIntValue(map, "1530118");

        // 1530159 食事提供
        int _1530159 = getIntValue(map, "1530159");

        // 1530161 食費
        this._1530161 = getIntValue(map, "1530161");

        // 1530119 試行的退院サービス費
        int _1530119 = getIntValue(map, "1530119");

        // 1530164 若年性認知症患者受入加算
        int _1530164 = getIntValue(map, "1530164");

        // 1530165 口腔機能維持管理加算
        int _1530165 = getIntValue(map, "1530165");

        // 1530166 認知症専門ケア加算
        int _1530166 = getIntValue(map, "1530166");

        // 1530167 サービス提供体制強化加算
        int _1530167 = getIntValue(map, "1530167");

        // 単独加算
        int _9 = getIntValue(map, "9");

        // 3020109 退所(院)前訪問指導加算
        int _3020109 = getIntValue(map, "3020109", 1);

        // 3020110 退所(院)後訪問指導加算
        int _3020110 = getIntValue(map, "3020110", 1);

        // 1530169 認知症行動・心理症状緊急対応加算
        int _1530169 = getIntValue(map, "1530169", 1);

        // 1530170 口腔機能維持管理体制加算
        int _1530170 = getIntValue(map, "1530170", 1);

        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 単独加算のみ---------------------------------------------------------------
        // 単独加算サービス
        if (_9 == 2) {

            // 退所(院)後訪問指導加算
            if (_3020110 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z2856");
            }

            // 介護職員処遇改善を返却
            switch (_17) {
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

            return sysSvcCdItems;
        }

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設区分
        sb.append(CODE_CHAR[_1530162]);

        // 人員配置区分
        sb.append(CODE_CHAR[_1530102]);

        // 病室区分(従来型個室/)
        sb.append(CODE_CHAR[_1530103]);

        // 病室区分(ユニット型個室/ユニット型準個室)
        sb.append(CODE_CHAR[_1530104]);

        // 要介護度
        sb.append(CODE_CHAR[_1]);

        // 夜間勤務条件基準
        sb.append(CODE_CHAR[_1530163]);

        // 人員減算
        sb.append(CODE_CHAR[_1530158]);

        // ユニットケアの整備
        switch (_1530162) {
        case 1: // 個室・多床室
        case 3:
            sb.append(DEFAULT_CHAR);
            break;
        case 2: // ユニット型
        case 4:
            // 1-未整備 2-整備
            if (_1530116 > 1) {
                sb.append(DEFAULT_CHAR);
            } else {
                sb.append(CODE_CHAR[2]);
            }
            break;
        }

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        // 療養環境減算
        switch (_1530168) {
        // 療養型療養環境減算
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2601");
            break;
        // 療養型療養環境減算III
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2603");
            break;
        }

        // 医師の配置基準
        if (_1530107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2700");
        }

        // Z2704 療養型若年性認知症受入加算
        if (_1530164 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2704");
        }

        // 身体拘束廃止未実施減算
        if (_1530117 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2834");
        }

        // 外泊加算
        if (_1530108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2830");
        }

        // 他科受診加算
        if (_1530110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2831");
        }

        // 初期加算
        if (_1530109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2840");
        }

        // 退所(院)前訪問指導加算
        if (_3020109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2851");
        }

        // 退所(院)後訪問指導加算
        if (_3020110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2856");
        }

        // 退所時指導加算
        if (_3020105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2852");
        }

        // 退所時情報提供加算
        if (_3020106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2854");
        }

        // 退所前連携加算
        if (_3020107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2855");
        }

        // 老人訪問看護指示加算
        if (_3020108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2853");
        }

        // 栄養マネジメント加算
        if (_1530112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2773");
        }

        // 経口移行加算
        if (_1530113 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2774");
        }

        // 経口維持加算
        switch (_1530115) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2780");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2781");
            break;
        }

        // Z2707 口腔機能維持管理体制加算
        if (_1530170 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2707");
        }

        // Z2710 療養型口腔機能維持管理加算
        if (_1530165 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2710");
        }

        // 療養食加算
        if (_1530114 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2775");
        }

        // 在宅復帰支援機能加算
        if (_1530118 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2778");
        }

        switch (_1530166) {
        case 2:
            // Z2708 療養型認知症専門ケア加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z2708");
            break;
        case 3:
            // Z2709 療養型認知症専門ケア加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z2709");
            break;
        }

        // 認知症行動・心理症状緊急対応加算
        if (_1530169 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2779");
        }

        switch (_1530167) {
        case 2:
            // Z2701 療養型サービス提供体制加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z2701");
            break;
        case 3:
            // Z2702 療養型サービス提供体制加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z2702");
            break;
        case 4:
            // Z2703 療養型サービス提供体制加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z2703");
            break;
        }

        // 介護職員処遇改善を返却
        switch (_17) {
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

            // 2006/07/14 療養型対応
            // 試行的退院サービスの場合は食費を算定
            if (_1530119 > 1) {
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }

            // 食事提供
            if (_1530159 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }

            // 外泊加算
            if (_1530108 > 1) {
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // 滞在費 --------
            putSystemServiceCodeItem(sysSvcCdItems,
                    getSystemServiceCodeOfRoom(byoshitsu));
        }// チェックがついていない場合は何も返さない

        // 他科受診があった場合は一律他科受信のコードを返す
        // 念のため外泊より優先する。
        if (_1530110 > 1) {
            // 内部サービスコードを初期化
            // 栄養マネジメント加算・栄養管理体制加算・食費・ホテルコスト以外は削除する。
            for (int i = sysSvcCdItems.size() - 1; i >= 0; i--) {
                Map<String, String> serviceMap = new HashMap<String, String>();
                // レコード取得
                serviceMap = sysSvcCdItems.get(i);
                // 算定可能なレコードである場合は削除しない
                // 他科受診加算算定時に削除対象外とする加算に、経口移行加算・療養食加算・経口維持加算を追加する。
                String tempItem = ACCastUtilities.toString(
                        serviceMap.get("SYSTEM_SERVICE_CODE_ITEM"), "");
                if (!"Z2773".equals(tempItem) && !"Z2771".equals(tempItem)
                        && !"Z2772".equals(tempItem)
                        && !SERVICE_CODE_SHOKUHI.equals(tempItem)
                        && !SERVICE_CODE_NORMAL_ROOM.equals(tempItem)
                        && !SERVICE_CODE_TASHO_ROOM.equals(tempItem)
                        && !SERVICE_CODE_UNIT_ROOM.equals(tempItem)
                        && !SERVICE_CODE_UNIT_SEMI_ROOM.equals(tempItem)
                        && !"Z2774".equals(tempItem)
                        && !"Z2775".equals(tempItem)
                        && !"Z2780".equals(tempItem)
                        && !"Z2781".equals(tempItem)) {
                    sysSvcCdItems.remove(i);
                }
            }

            // 他科受診にあたるサービスコードを追加
            putSystemServiceCodeItem(sysSvcCdItems, "Z2831");

            // 介護職員処遇改善を返却
            switch (_17) {
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

            // 値を返す
            return sysSvcCdItems;

        }

        // 外泊がありだった場合は一律外泊のコードを返す
        if (_1530108 > 1) {
            // 特定入所者である場合はホテルコストを追加する
            if (new Integer(1).equals(map.get("7")) || "1".equals(map.get("7"))) {
                // 内部サービスコードを初期化
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // 外泊にあたるサービスコードを追加
            putSystemServiceCodeItem(sysSvcCdItems, "Z2830");

            // 介護職員処遇改善を返却
            switch (_17) {
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

            // 値を返す
            return sysSvcCdItems;
        }

        // 2006/07/05 療養型対応
        // 1530119 試行的退院サービス費
        // 試行的退院がありだった場合は一律試行的退院のコードを返す
        if (_1530119 > 1) {
            // 特定入所者である場合は初期化を行わない　※滞在費を返す必要があるため
            if ("1".equals(map.get("7")) || new Integer(1).equals(map.get("7"))) {
                // 内部サービスコードを初期化
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // 試行的退院にあたるコードを追加
            putSystemServiceCodeItem(sysSvcCdItems, "Z5258");

            // 介護職員処遇改善を返却
            switch (_17) {
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
                if (this._1530161 <= 0) {
                    // 食費が0円以下の場合
                    // 該当レコードを削除する。
                    al.remove(i);
                    // 削除したためインデックスを1つ戻す。
                    i--;
                } else {
                    // 食費が0円以下でない場合
                    // 食費を業務から渡された値で上書きする。
                    mp.put("SERVICE_UNIT", new Integer(this._1530161));
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
