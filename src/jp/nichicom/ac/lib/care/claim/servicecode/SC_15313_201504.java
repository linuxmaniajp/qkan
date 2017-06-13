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
 * 介護療養型医療施設(老人性認知症疾患療養病棟を有する病院)
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_15313_201504 extends Qkan10011_ServiceUnitGetter {
    private int _1530358 = 0;

    private final String PATH_UNIT_ROOM = "1530312";
    private final String PATH_UNIT_SEMI_ROOM = "1530313";
    private final String PATH_NORMAL_ROOM = "1530314";
    private final String PATH_TASHO_ROOM = "1530315";

    public String getServiceName() {
        return "介護療養型医療施設(老人性認知症疾患療養病棟を有する病院)";
    }

    public String getServiceCodeKind() {
        return "53";
    }

    public String getSystemServiceKindDetail() {
        return "15313";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================
        // 1530301 施設区分
        int _1530301 = getIntValue(map, "1530301");

        // 1530316 病院区分
        int _1530316 = getIntValue(map, "1530316");

        // 1530302 人員配置区分
        int _1530302 = getIntValue(map, "1530302");

        // 1530303 病室区分(従来型)
        int _1530303 = getIntValue(map, "1530303");

        // 1530304 病室区分(ユニット型)
        int _1530304 = getIntValue(map, "1530304");

        // 病室区分
        int byoshitsu = 1;
        switch (_1530301) {
        case 1:
        case 3:
            byoshitsu = convertByoshitsuKbn(_1530303, false);
            break;
        case 2:
            byoshitsu = convertByoshitsuKbn(_1530304, true);
            break;
        }

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1530355 人員減算
        int _1530355 = getIntValue(map, "1530355");

        // 1530313 ユニットケアの整備
        int _1530313 = getIntValue(map, "1530313");

        // 1530314 身体拘束廃止未実施減算
        int _1530314 = getIntValue(map, "1530314");

        // 1530305 外泊加算
        int _1530305 = getIntValue(map, "1530305");

        // 1530307 他科受診加算
        int _1530307 = getIntValue(map, "1530307");

        // 1530306 初期加算
        int _1530306 = getIntValue(map, "1530306");

        // 3020105 退所時指導加算
        int _3020105 = getIntValue(map, "3020105");

        // 3020106 退所時情報提供加算
        int _3020106 = getIntValue(map, "3020106");

        // 3020107 退所前連携加算
        int _3020107 = getIntValue(map, "3020107");

        // 3020108 老人訪問看護指示加算
        int _3020108 = getIntValue(map, "3020108");

        // 1530309 栄養マネジメント加算
        int _1530309 = getIntValue(map, "1530309");

        // 1530310 経口移行加算
        int _1530310 = getIntValue(map, "1530310");

        // 1530312 経口維持加算I
        int _1530312 = getIntValue(map, "1530312");
        
        // 1530317 経口維持加算II
        int _1530317 = getIntValue(map, "1530317");

        // 1530311 療養食加算
        int _1530311 = getIntValue(map, "1530311");

        // 1530315 在宅復帰支援機能加算
        int _1530315 = getIntValue(map, "1530315");

        // 1530356 食事提供
        int _1530356 = getIntValue(map, "1530356");

        // 1530358 食費
        this._1530358 = getIntValue(map, "1530358");

        // 1530359 口腔機能維持管理加算
        int _1530359 = getIntValue(map, "1530359");

        // 1530360 サービス提供体制強化加算
        int _1530360 = getIntValue(map, "1530360");
        
        // 1530361 口腔機能維持管理体制加算
        int _1530361 = getIntValue(map, "1530361");

        // 3020109 退所(院)前訪問指導加算
        int _3020109 = getIntValue(map, "3020109", 1);

        // 3020110 退所(院)後訪問指導加算
        int _3020110 = getIntValue(map, "3020110", 1);

        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 単独加算
        int _9 = getIntValue(map, "9");

        // 単独加算のみ---------------------------------------------------------------
        // 単独加算サービス
        if (_9 == 2) {

            // 退所(院)後訪問指導加算
            if (_3020110 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z4856");
            }
            
            // 介護職員処遇改善を返却
            switch (_17) {
            case 6:
                putSystemServiceCodeItem(sysSvcCdItems, "Z4715");//2017.04
                break;
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z4714");//2015.04
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z4711");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z4712");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z4713");
                break;
            }
            
            return sysSvcCdItems;
        }

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設区分
        sb.append(CODE_CHAR[_1530301]);

        // 病院区分(大学/一般病院)
        sb.append(CODE_CHAR[_1530316]);

        // 人員配置区分
        sb.append(CODE_CHAR[_1530302]);

        // 病室区分(従来型個室/多床室)
        sb.append(CODE_CHAR[_1530303]);
        
        // 病室区分(ユニット型個室/ユニット型準個室)
        sb.append(CODE_CHAR[_1530304]);
        
        // 要介護度
        sb.append(CODE_CHAR[_1]);

        // 人員減算
        sb.append(CODE_CHAR[_1530355]);

        // ユニットケアの整備
        switch (_1530301) {
        case 1: //認知症疾患型
        case 3: //経過型
            sb.append(DEFAULT_CHAR);
            break;
        case 2: //ユニット型
            if (_1530313 > 1) {
                sb.append(DEFAULT_CHAR);
            } else {
                sb.append(CODE_CHAR[2]);
            }
            break;
        }

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        // 身体拘束廃止未実施減算
        if (_1530314 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4834");
        }
        
        // 外泊加算
        if (_1530305 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4830");
        }
        
        // 他科受診加算
        if (_1530307 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4831");
        }
        
        // 初期加算
        if (_1530306 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4840");
        }
        
        // 退所(院)前訪問指導加算
        if (_3020109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4851");
        }
        
        // 退所(院)後訪問指導加算
        if (_3020110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4856");
        }
        
        // 退所時指導加算
        if (_3020105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4852");
        }
        
        // 退所時情報提供加算
        if (_3020106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4854");
        }
        
        // 退所前連携加算
        if (_3020107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4855");
        }
        
        // 老人訪問看護指示加算
        if (_3020108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4853");
        }
        
        // 栄養マネジメント加算
        if (_1530309 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4773");
        }
        
        // 経口移行加算
        if (_1530310 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4774");
        }
        
        // 経口維持加算
        if (_1530312 > 1) {
            // 経口維持加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z4780");
        }
        if (_1530317 > 1) {
            // 経口維持加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z4781");
        }
        
        // 口腔機能維持管理体制加算
        if (_1530361 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4707");
        }
        
        // 口腔機能維持管理加算
        if (_1530359 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4710");
        }
        
        // 療養食加算
        if (_1530311 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4775");
        }
        
        // 在宅復帰支援機能加算
        if (_1530315 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4778");
        }
        
        switch (_1530360) {
        case 5:
            // Z4705 認知症型サービス提供体制加算Iイ
            putSystemServiceCodeItem(sysSvcCdItems, "Z4705");//2015.04
            break;
        case 2:
            // Z4701 認知症型サービス提供体制加算Iロ
            putSystemServiceCodeItem(sysSvcCdItems, "Z4701");
            break;
        case 3:
            // Z4702 認知症型サービス提供体制加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z4702");
            break;
        case 4:
            // Z4703 認知症型サービス提供体制加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z4703");
            break;
        }

        // 介護職員処遇改善を返却
        switch (_17) {
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4715");//2017.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4714");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4711");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4712");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4713");
            break;
        }

        // 特定入所者チェックがついていた場合は個室の単位数を追加
        if (!new Integer(1).equals(map.get("7")) && !"1".equals(map.get("7"))) {
            // 食事提供
            if (_1530356 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }
            // 外泊である場合は初期化する
            if (_1530305 > 1) {
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // 滞在費 --------
            putSystemServiceCodeItem(sysSvcCdItems,
                    getSystemServiceCodeOfRoom(byoshitsu));
        }// チェックがついていない場合は何も返さない

        // 他科受信があった場合は一律他科受信のコードを返す
        // 念のため外泊より優先する。
        if (_1530307 > 1) {
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
                if (!"Z4771".equals(tempItem) && !"Z4772".equals(tempItem)
                        && !"Z4773".equals(tempItem)
                        && !SERVICE_CODE_SHOKUHI.equals(tempItem)
                        && !SERVICE_CODE_NORMAL_ROOM.equals(tempItem)
                        && !SERVICE_CODE_TASHO_ROOM.equals(tempItem)
                        && !SERVICE_CODE_UNIT_ROOM.equals(tempItem)
                        && !SERVICE_CODE_UNIT_SEMI_ROOM.equals(tempItem)
                        && !"Z4774".equals(tempItem)
                        && !"Z4775".equals(tempItem)
                        && !"Z4780".equals(tempItem)
                        && !"Z4781".equals(tempItem)) {
                    sysSvcCdItems.remove(i);
                }
            }

            // 他科受信にあたるサービスコードを追加
            putSystemServiceCodeItem(sysSvcCdItems, "Z4831");
            
            // 介護職員処遇改善を返却
            switch (_17) {
            case 6:
                putSystemServiceCodeItem(sysSvcCdItems, "Z4715");//2017.04
                break;
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z4714");//2015.04
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z4711");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z4712");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z4713");
                break;
            }
            
            // 値を返す
            return sysSvcCdItems;

        }

        // 外泊がありだった場合は一律外泊のコードを返す
        if (_1530305 > 1) {
            // 特定施設入所以外の場合は初期化処理
            if (new Integer(1).equals(map.get("7")) || "1".equals(map.get("7"))) {
                // 内部サービスコードを初期化
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // 外泊にあたるサービスコードを追加
            putSystemServiceCodeItem(sysSvcCdItems, "Z4830");
            
            // 介護職員処遇改善を返却
            switch (_17) {
            case 6:
                putSystemServiceCodeItem(sysSvcCdItems, "Z4715");//2017.04
                break;
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z4714");//2015.04
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z4711");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z4712");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z4713");
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
                if (this._1530358 <= 0) {
                    // 食費が0円以下の場合
                    // 該当レコードを削除する。
                    al.remove(i);
                    // 削除したためインデックスを1つ戻す。
                    i--;
                } else {
                    // 食費が0円以下でない場合
                    // 食費を業務から渡された値で上書きする。
                    mp.put("SERVICE_UNIT", new Integer(this._1530358));
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
