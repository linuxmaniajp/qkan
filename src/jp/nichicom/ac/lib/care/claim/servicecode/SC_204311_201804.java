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
 * 介護予防短期入所療養介護(介護医療院)
 * 
 * @since V8.0.0
 * @author Shinobu.Hitaka
 * 
 */
public class SC_204311_201804 extends Qkan10011_ServiceUnitGetter {
    private int shokuhi = 0;

    private final String PATH_UNIT_ROOM = "20430120";
    private final String PATH_UNIT_SEMI_ROOM = "20430121";
    private final String PATH_NORMAL_ROOM = "20430122";
    private final String PATH_TASHO_ROOM = "20430123";

    public String getServiceName() {
        return "介護予防短期入所療養介護(介護医療院)";
    }

    public String getServiceCodeKind() {
        return "2B";
    }

    public String getSystemServiceKindDetail() {
        return "204311";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================
        
        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));
        
        // 20430101 施設区分
        int _20430101 = getIntValue(map, "20430101");

        // 20430102 人員配置区分（I型）
        int _20430102 = getIntValue(map, "20430102");
        
        // 20430103 人員配置区分（II型）
        int _20430103 = getIntValue(map, "20430103");
        
        // 20430104	人員配置区分（特別型）
        int _20430104 = getIntValue(map, "20430104");
        
        // 20430105 病室区分(従来型)
        int _20430105 = getIntValue(map, "20430105");

        // 20430106 病室区分(ユニット型)
        int _20430106 = getIntValue(map, "20430106");

        // 病室区分
        int byoshitsu = 1;
        switch (_20430101) {
        case 1: // I型
        case 2: // II型
        case 3: // 特別型
            byoshitsu = convertByoshitsuKbn(_20430105, false);
            break;
        case 4: // ユニット型I型
        case 5: // ユニット型II型
        case 6: // ユニット型特別型
            byoshitsu = convertByoshitsuKbn(_20430106, true);
            break;
        }

        // 20430109 ユニットケアの整備
        int _20430109 = getIntValue(map, "20430109");

        // 20430110 夜間勤務等看護加算
        int _20430110 = getIntValue(map, "20430110");

        // 20430111 療養環境減算（廊下）
        int _20430111 = getIntValue(map, "20430111");
        
        // 20430112 療養環境減算（療養室）
        int _20430112 = getIntValue(map, "20430112");
        
        // 20430113 夜間勤務条件基準
        int _20430113 = getIntValue(map, "20430113");
        
        // 20430114 人員減算
        int _20430114 = getIntValue(map, "20430114");

        // 20430115 認知症行動・心理症状緊急対応加算
        int _20430115 = getIntValue(map, "20430115", 1);

        // 20430117 若年性認知症利用者受入加算
        int _20430117 = getIntValue(map, "20430117", 1);

        // 6 送迎加算
        int _6 = getIntValue(map, "6");

        // 20430118 療養食加算
        int _20430118 = getIntValue(map, "20430118");

        // 20430119 緊急時治療管理
        int _20430119 = getIntValue(map, "20430119");

        // 20430120 認知症専門ケア加算
        int _20430120 = getIntValue(map, "20430120");

        // 20430122 サービス提供体制強化加算
        int _20430122 = getIntValue(map, "20430122", 1);

        // 20430123 食事提供
        int _20430123 = getIntValue(map, "20430123");

        // 20430124 食費
        this.shokuhi = getIntValue(map, "20430124");

        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map, Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設区分
        sb.append(CODE_CHAR[_20430101]);

        // 人員配置区分（I型）
        if (_20430101 == 1 || _20430101 == 4 || _20430101 == 5) {
        	 sb.append(CODE_CHAR[_20430102]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // 人員配置区分(II型)
        if (_20430101 == 2) {
        	sb.append(CODE_CHAR[_20430103]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // 人員配置区分(特別型)
        if (_20430101 == 3 || _20430101 == 6) {
        	sb.append(CODE_CHAR[_20430104]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // 従来型個室/多床室
        sb.append(CODE_CHAR[_20430105]);
        
        // ユニット型個室/ユニット型個室的多床室
        sb.append(CODE_CHAR[_20430106]);
        
        // 要介護度
        sb.append(CODE_CHAR[_1]);

        // 夜間勤務条件基準
        sb.append(CODE_CHAR[_20430113]);
        
        // 人員減算
        sb.append(CODE_CHAR[_20430114]);
        
        // ユニットケアの整備
        switch (_20430101) {
        case 1: // I型
        case 2: // II型
        case 3: // 特別型
            sb.append(DEFAULT_CHAR);
            break;
            
        //ユニット型
        case 4: // ユニット型I型
        case 5: // ユニット型II型
        case 6: // ユニット型特別型
            // 値を反転させる
            // 整備している場合
            if (_20430109 > 1)  {
                sb.append(DEFAULT_CHAR);
            // 未整備の場合
            } else {
                sb.append(CODE_CHAR[2]);
            }
            break;
        }


        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());
        

        // 加算
        // ============================================================================
        
        // 夜間勤務等看護加算
        switch (_20430110) {
        case 2:
            // 夜間勤務等看護加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6371");
            break;
        case 3:
            // 夜間勤務等看護加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6372");
            break;
        case 4:
            // 夜間勤務等看護加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z6373");
            break;
        case 5:
        	// 夜間勤務等看護加算IV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6374");
            break;
        }
        
        
        // 療養環境減算（廊下）
        if (_20430111 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6601");
        }
        
        // 療養環境減算（療養室）
        if (_20430112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6603");
        }

        // 認知症緊急対応加算
        if (_20430115 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6121");
        }
        
        // 若年性認知症受入加算
        if (_20430117 > 1) {
            // 若年性認知症受入加算
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // 送迎加算
        switch (_6) {
        case 3: // 往復
            putSystemServiceCodeItem(sysSvcCdItems, "Z69202");
        case 2: // 片道
            putSystemServiceCodeItem(sysSvcCdItems, "Z69201");
            break;
        }
        
        // 療養食加算
        switch (_20430118) {
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
        
        // 緊急時治療管理
        if (_20430119 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6000");
        }

        // 認知症専門ケア加算
        switch (_20430120) {
        case 2:
            // 認知症専門ケア加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6133");
            break;
        case 3:
            // 認知症専門ケア加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6134");
            break;
        }
        
        // サービス提供体制加算
        switch (_20430122) {
        case 5:
        	// サービス提供体制加算Iイ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");
            break;
        case 2:
        	// サービス提供体制加算Iロ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
        	// サービス提供体制加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
        	// サービス提供体制加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }
        
        
        // 介護職員処遇改善を返却
        switch(_17){
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
            break;
        }

        // 特定入所者チェックがついていた場合は個室の単位数を追加
        if (!new Integer(1).equals(map.get("7")) && !"1".equals(map.get("7"))) {
            // 食事提供
            if (_20430123 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }
            // 滞在費 --------
            putSystemServiceCodeItem(sysSvcCdItems, getSystemServiceCodeOfRoom(byoshitsu));
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
