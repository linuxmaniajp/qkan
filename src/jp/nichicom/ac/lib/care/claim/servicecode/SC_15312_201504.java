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
 * 介護療養型医療施設(療養病床を有する診療所)
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_15312_201504 extends Qkan10011_ServiceUnitGetter {
    private int _1530259 = 0;

    private final String PATH_UNIT_ROOM = "1530213";
    private final String PATH_UNIT_SEMI_ROOM = "1530214";
    private final String PATH_NORMAL_ROOM = "1530215";
    private final String PATH_TASHO_ROOM = "1530216";

    public String getServiceName() {
        return "介護療養型医療施設(療養病床を有する診療所)";
    }

    public String getServiceCodeKind() {
        return "53";
    }

    public String getSystemServiceKindDetail() {
        return "15312";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================
        // 1530201 施設区分
        int _1530201 = getIntValue(map, "1530201");

        // 1530202 人員配置区分
        int _1530202 = getIntValue(map, "1530202");
        
        // 1530218 人員配置区分（ユニット型病院療養型用）
        int _1530218 = getIntValue(map, "1530218");

        // 1530203 病室区分(従来型)
        int _1530203 = getIntValue(map, "1530203");

        // 1530204 病室区分(ユニット型)
        int _1530204 = getIntValue(map, "1530204");

        // 病室区分
        int byoshitsu = 1;
        switch (_1530201) {
        case 1:
            byoshitsu = convertByoshitsuKbn(_1530203, false);
            break;
        case 2:
            byoshitsu = convertByoshitsuKbn(_1530204, true);
            break;
        }

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1530256 人員減算
        int _1530256 = getIntValue(map, "1530256");

        // 1530214 ユニットケアの整備
        int _1530214 = getIntValue(map, "1530214");

        // 1530205 療養環境減算
        int _1530205 = getIntValue(map, "1530205");

        // 1530215 身体拘束廃止未実施減算
        int _1530215 = getIntValue(map, "1530215");

        // 1530206 外泊加算
        int _1530206 = getIntValue(map, "1530206");

        // 1530208 他科受診加算
        int _1530208 = getIntValue(map, "1530208");

        // 1530207 初期加算
        int _1530207 = getIntValue(map, "1530207");

        // 3020105 退所時指導加算
        int _3020105 = getIntValue(map, "3020105");

        // 3020106 退所時情報提供加算
        int _3020106 = getIntValue(map, "3020106");

        // 3020107 退所前連携加算
        int _3020107 = getIntValue(map, "3020107");

        // 3020108 老人訪問看護指示加算
        int _3020108 = getIntValue(map, "3020108");

        // 1530210 栄養マネジメント加算
        int _1530210 = getIntValue(map, "1530210");

        // 1530211 経口移行加算
        int _1530211 = getIntValue(map, "1530211");

        // 1530213 経口維持加算I
        int _1530213 = getIntValue(map, "1530213");
        
        // 1530217 経口維持加算II
        int _1530217 = getIntValue(map, "1530217");

        // 1530212 療養食加算
        int _1530212 = getIntValue(map, "1530212");

        // 1530216 在宅復帰支援機能加算
        int _1530216 = getIntValue(map, "1530216");

        // 1530257 食事提供
        int _1530257 = getIntValue(map, "1530257");

        // 1530259 食費
        this._1530259 = getIntValue(map, "1530259");

        // 1530260 設備基準減算 1-基準型 2-減算型
        int _1530260 = getIntValue(map, "1530260", 1);

        // 1530261 口腔機能維持管理加算
        int _1530261 = getIntValue(map, "1530261", 1);

        // 1530262 若年性認知症患者受入加算
        int _1530262 = getIntValue(map, "1530262", 1);

        // 1530263 認知症専門ケア加算
        int _1530263 = getIntValue(map, "1530263", 1);

        // 1530264 サービス提供体制強化加算
        int _1530264 = getIntValue(map, "1530264", 1);

        // 単独加算
        int _9 = getIntValue(map, "9");

        // 3020109 退所(院)前訪問指導加算
        int _3020109 = getIntValue(map, "3020109", 1);

        // 3020110 退所(院)後訪問指導加算
        int _3020110 = getIntValue(map, "3020110", 1);

        // 1530265 認知症行動・心理症状緊急対応加算
        int _1530265 = getIntValue(map, "1530265", 1);

        // 1530266 口腔機能維持管理体制加算
        int _1530266 = getIntValue(map, "1530266", 1);

        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 単独加算のみ---------------------------------------------------------------
        // 単独加算サービス
        if (_9 == 2) {

            // 退所(院)後訪問指導加算
            if (_3020110 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z3856");
            }

            // 介護職員処遇改善を返却
            switch (_17) {
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z3714");//2015.04
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z3711");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z3712");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z3713");
                break;
            }

            return sysSvcCdItems;
        }
        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設区分
        sb.append(CODE_CHAR[_1530201]);

        // 人員配置区分１
        if (_1530201 == 1) {
        	 sb.append(CODE_CHAR[_1530202]);
        } else {
            sb.append(DEFAULT_CHAR);
        }
        
        // 人員配置区分２
        if (_1530201 == 2) {
        	sb.append(CODE_CHAR[_1530218]);
        } else {
            sb.append(DEFAULT_CHAR);
        }

        // 病室区分(従来型個室/多床室)
        sb.append(CODE_CHAR[_1530203]);

        // 病院区分(ユニット型個室/ユニット型準個室)
        sb.append(CODE_CHAR[_1530204]);

        // 要介護度
        sb.append(CODE_CHAR[_1]);

        // 人員減算
        sb.append(CODE_CHAR[_1530256]);

        // ユニットケアの整備
        switch (_1530201) {
        case 1: // 診療所
            sb.append(DEFAULT_CHAR);
            break;
        case 2: // ユニット型
            if (_1530214 > 1) {
                sb.append(DEFAULT_CHAR);
            } else {
                sb.append(CODE_CHAR[2]);
            }
            break;
        }

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        // 設備基準減算
        if (_1530260 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3600");
        }

        // 療養環境減算
        if (_1530205 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3602");
        }

        // Z3704 診療所型若年性認知症受入加算
        if (_1530262 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3704");
        }

        // 身体拘束廃止未実施減算
        if (_1530215 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3834");
        }

        // 外泊加算
        if (_1530206 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3830");
        }

        // 他科受診加算
        if (_1530208 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3831");
        }

        // 初期加算
        if (_1530207 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3840");
        }

        // 退所(院)前訪問指導加算
        if (_3020109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3851");
        }

        // 退所(院)後訪問指導加算
        if (_3020110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3856");
        }

        // 退所時指導加算
        if (_3020105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3852");
        }

        // 退所時情報提供加算
        if (_3020106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3854");
        }

        // 退所前連携加算
        if (_3020107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3855");
        }

        // 老人訪問看護指示加算
        if (_3020108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3853");
        }

        // 栄養マネジメント加算
        if (_1530210 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3773");
        }

        // 経口移行加算
        if (_1530211 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3774");
        }

        // 経口維持加算
        if (_1530213 > 1) {
            // 経口維持加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z3780");
        }
        if (_1530217 > 1) {
            // 経口維持加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z3781");
        }
        
        // Z3707 口腔機能維持管理体制加算
        if (_1530266 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3707");
        }

        // Z3710 口腔機能維持管理加算
        if (_1530261 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3710");
        }

        // 療養食加算
        if (_1530212 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3775");
        }

        // 在宅復帰支援機能加算
        if (_1530216 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3778");
        }

        switch (_1530263) {
        case 2:
            // Z3708 診療所型認知症専門ケア加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z3708");
            break;
        case 3:
            // Z3709 診療所型認知症専門ケア加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z3709");
            break;
        }

        // 認知症行動・心理症状緊急対応加算
        if (_1530265 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3779");
        }

        switch (_1530264) {
        case 5:
            // Z3705 診療所型サービス提供体制加算Iイ
            putSystemServiceCodeItem(sysSvcCdItems, "Z3705");//2015.04
            break;
        case 2:
            // Z3701 診療所型サービス提供体制加算Iロ
            putSystemServiceCodeItem(sysSvcCdItems, "Z3701");
            break;
        case 3:
            // Z3702 診療所型サービス提供体制加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z3702");
            break;
        case 4:
            // Z3703 診療所型サービス提供体制加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z3703");
            break;
        }

        // 介護職員処遇改善を返却
        switch (_17) {
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z3714");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z3711");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z3712");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z3713");
            break;
        }

        // 特定入所者チェックがついていた場合は個室の単位数を追加
        if (!new Integer(1).equals(map.get("7")) && !"1".equals(map.get("7"))) {
            // 食事提供
            if (_1530257 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }
            // 外泊加算だった場合は初期化する
            if (_1530206 > 1) {
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // 滞在費 --------
            putSystemServiceCodeItem(sysSvcCdItems,
                    getSystemServiceCodeOfRoom(byoshitsu));
        }// チェックがついていない場合は何も返さない

        // 他科受信があった場合は一律他科受信のコードを返す
        // 念のため外泊より優先する。
        if (_1530208 > 1) {
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
                if (!"Z3771".equals(tempItem) && !"Z3772".equals(tempItem)
                        && !"Z3773".equals(tempItem)
                        && !SERVICE_CODE_SHOKUHI.equals(tempItem)
                        && !SERVICE_CODE_NORMAL_ROOM.equals(tempItem)
                        && !SERVICE_CODE_TASHO_ROOM.equals(tempItem)
                        && !SERVICE_CODE_UNIT_ROOM.equals(tempItem)
                        && !SERVICE_CODE_UNIT_SEMI_ROOM.equals(tempItem)
                        && !"Z3774".equals(tempItem)
                        && !"Z3775".equals(tempItem)
                        && !"Z3780".equals(tempItem)
                        && !"Z3781".equals(tempItem)) {
                    sysSvcCdItems.remove(i);
                }
            }

            // 他科受信にあたるサービスコードを追加
            putSystemServiceCodeItem(sysSvcCdItems, "Z3831");

            // 介護職員処遇改善を返却
            switch (_17) {
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z3714");//2015.04
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z3711");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z3712");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z3713");
                break;
            }

            // 値を返す
            return sysSvcCdItems;

        }

        // 外泊がありだった場合は一律外泊のコードを返す
        if (_1530206 > 1) {
            // 特定施設入所以外の場合は初期化処理
            if (new Integer(1).equals(map.get("7")) || "1".equals(map.get("7"))) {
                // 内部サービスコードを初期化
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // 外泊にあたるサービスコードを追加
            putSystemServiceCodeItem(sysSvcCdItems, "Z3830");

            // 介護職員処遇改善を返却
            switch (_17) {
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z3714");//2015.04
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z3711");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z3712");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z3713");
                break;
            }

            // 値を返す
            return sysSvcCdItems;
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
                if (this._1530259 <= 0) {
                    // 食費が0円以下の場合
                    // 該当レコードを削除する。
                    al.remove(i);
                    // 削除したためインデックスを1つ戻す。
                    i--;
                } else {
                    // 食費が0円以下でない場合
                    // 食費を業務から渡された値で上書きする。
                    mp.put("SERVICE_UNIT", new Integer(this._1530259));
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
