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
 * 短期入所療養介護(老健)
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_12211_201204 extends Qkan10011_ServiceUnitGetter {
    private int shokuhi = 0;

    private final String PATH_UNIT_ROOM = "1220113";
    private final String PATH_UNIT_SEMI_ROOM = "1220114";
    private final String PATH_NORMAL_ROOM = "1220115";
    private final String PATH_TASHO_ROOM = "1220116";

    public String getServiceName() {
        return "短期入所療養介護(老健)";
    }

    public String getServiceCodeKind() {
        return "22";
    }

    public String getSystemServiceKindDetail() {
        return "12211";
    }

    private boolean isHigaeriShort(int shisetsu) {
        return shisetsu == 7;
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================
        // 1220101 施設区分
        int _1220101 = getIntValue(map, "1220101");

        // 1220102 病室区分(従来型)
        int _1220102 = getIntValue(map, "1220102");

        // 1220103 病室区分(ユニット型)
        int _1220103 = getIntValue(map, "1220103");

        // 病室区分
        int byoshitsu = 1;
        switch (_1220101) {
        //従来型
        case 1:
        case 3:
        case 5:
            byoshitsu = convertByoshitsuKbn(_1220102, false);
            break;
            
        //ユニット型
        case 2:
        case 4:
        case 6:
            byoshitsu = convertByoshitsuKbn(_1220103, true);
            break;
            
        //
        case 7:
            byoshitsu = getIntValue(map, "1220119", 0);
            break;
        }

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1220104 夜間勤務条件基準
        int _1220104 = getIntValue(map, "1220104");

        // 1220111 人員減算
        int _1220111 = getIntValue(map, "1220111");

        // 1220117 ユニットケアの整備
        int _1220117 = getIntValue(map, "1220117");

        // 1220105 リハビリ機能強化加算
        int _1220105 = getIntValue(map, "1220105", 1);

        // 1220116 認知症ケア加算
        int _1220116 = getIntValue(map, "1220116", 1);

        // 6 送迎加算
        int _6 = getIntValue(map, "6");

        // 1220121 療養体制維持特別加算
        int _1220121 = getIntValue(map, "1220121");

        // 1220110 療養食加算
        int _1220110 = getIntValue(map, "1220110");

        // 1220108 緊急時治療管理加算
        int _1220108 = getIntValue(map, "1220108");

        // 1220112 食事提供
        int _1220112 = getIntValue(map, "1220112");

        // 1210114 食費
        this.shokuhi = getIntValue(map, "1220115");

        // 1220119 日帰りショート用病室区分
        int _1220119 = getIntValue(map, "1220119");

        // 1220125 時間区分
        int _1220125 = getIntValue(map, "1220125");

        // 1220122 夜勤職員配置加算
        int _1220122 = getIntValue(map, "1220122");

        // 1220126 個別リハビリ実施加算
        int _1220126 = getIntValue(map, "1220126");

        // 1220127 認知症行動・心理症状緊急対応加算
        int _1220127 = getIntValue(map, "1220127");

        // 1220123 若年性認知症利用者受入加算
        int _1220123 = getIntValue(map, "1220123");

        // 1220124 サービス提供体制強化加算
        int _1220124 = getIntValue(map, "1220124", 1);

        // 1220130 緊急短期入所受入加算
        int _1220130 = getIntValue(map, "1220130", 1);

        // 1220129 重度療養管理加算
        int _1220129 = getIntValue(map, "1220129", 1);
        
        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map, Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);
        
        // 1520143 人員配置区分
        int _1220131 = getIntValue(map, "1220131", 1);
        
        // 1520149 人員配置区分（療養型）
        int _1220132 = getIntValue(map, "1220132", 1);
        

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設区分
        sb.append(CODE_CHAR[_1220101]);
        
        // 従来型/在宅強化型
        sb.append(CODE_CHAR[_1220131]);
        
        // 療養型/療養強化型
        sb.append(CODE_CHAR[_1220132]);
        
        // 従来型個室/多床室
        sb.append(CODE_CHAR[_1220102]);
        
        // ユニット型個室/ユニット型準個室
        sb.append(CODE_CHAR[_1220103]);
        
        // 要介護度
        if (isHigaeriShort(_1220101)) {
            // 日帰りショートの場合、要介護度は絡まない
            sb.append(DEFAULT_CHAR);
        } else {
            sb.append(CODE_CHAR[_1]);
        }
        
        // 夜間勤務条件基準
        sb.append(CODE_CHAR[_1220104]);
        
        // 人員減算
        sb.append(CODE_CHAR[_1220111]);
        
        // ユニットケアの整備
        switch (_1220101) {
        //従来型、日帰りショート
        case 1:
        case 3:
        case 5:
        case 7:
            sb.append(DEFAULT_CHAR);
            break;
            
        //ユニット型
        case 2:
        case 4:
        case 6:
            // 値を反転させる
            // 整備している場合
            if (_1220117 > 1)  {
                sb.append(DEFAULT_CHAR);
            // 未整備の場合
            } else {
                sb.append(CODE_CHAR[2]);
            }
            break;
        }
        
        
        // 時間区分
        sb.append(CODE_CHAR[_1220125]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        // 6117 老短夜勤職員配置加算
        if (_1220122 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6117");
        }
        
        // 6250 老短リハビリ機能強化加算
        if (_1220105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6250");
        }
        
        // 6111 老短個別リハビリ加算
        if (_1220126 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6111");
        }
        
        // 6254 老短認知症ケア加算
        if (_1220116 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6254");
        }
        
        // 6121 老短認知症緊急対応加算
        if (_1220127 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6121");
        }
        
        // 緊急短期入所受入加算
        if (_1220130 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6277");
        }
        
        // 老短若年性認知症受入加算
        if (_1220123 > 1) {
            if (isHigaeriShort(_1220101)) {
                // 6110 老短若年性認知症受入加算２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6110");
            } else {
                // 6109 老短若年性認知症受入加算１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
            }
        }
        
        // 重度療養管理加算
        if (_1220129 > 1) {
            if (isHigaeriShort(_1220101)) {
                // 6279 老短重度療養管理加算２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6279");
            } else {
                // 6278 老短重度療養管理加算１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6278");
            }
        }
        
        // 送迎加算
        switch (_6) {
        case 3: // 往復
            putSystemServiceCodeItem(sysSvcCdItems, "Z19202");
        case 2: // 片道
            putSystemServiceCodeItem(sysSvcCdItems, "Z19201");
            break;
        }
        
        // 療養体制維持特別加算
        if (_1220121 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6601");
        }
        
        // 療養食加算
        if (_1220110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
        }
        
        // 緊急時治療管理加算
        if (_1220108 > 1) {
            
            switch (_1220101) {
            // 療養型老健以外の場合
            case 1: //介護老人保健施設（I）
            case 2: //ユニット型介護老人保健施設（I）
            case 7: //日帰りショートステイ
                putSystemServiceCodeItem(sysSvcCdItems, "Z9000");
                break;
                
           // 療養型老健の場合
            case 3: //介護老人保健施設（II）
            case 4: //ユニット型介護老人保健施設（II）
            case 5: //介護老人保健施設（III）
            case 6: //ユニット型介護老人保健施設（III）
                putSystemServiceCodeItem(sysSvcCdItems, "Z6000");
                break;
            }
        }
        
        // 老短サービス提供体制加算
        switch(_1220124) {
        // 老短サービス提供体制加算I
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        // 老短サービス提供体制加算II
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        // 老短サービス提供体制加算III
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }
        
        // 処遇改善を無理やり混ぜる
        switch(_17){
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
            if (_1220112 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }
            // 滞在費 --------
            if (isHigaeriShort(_1220101)) {
                // 日帰りショート選択時
                // 日帰りショート専用病室区分
                putSystemServiceCodeItem(sysSvcCdItems,
                        getSystemServiceCodeOfRoom(_1220119));
            } else {
                putSystemServiceCodeItem(sysSvcCdItems,
                        getSystemServiceCodeOfRoom(byoshitsu));
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
