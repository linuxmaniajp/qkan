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
 * 短期入所療養介護(介護医療院)
 * 
 * @since V8.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_204211_201804 extends Qkan10011_ServiceUnitGetter {
    private int shokuhi = 0;

    private final String PATH_UNIT_ROOM = "20420120";
    private final String PATH_UNIT_SEMI_ROOM = "20420121";
    private final String PATH_NORMAL_ROOM = "20420122";
    private final String PATH_TASHO_ROOM = "20420123";

    public String getServiceName() {
        return "短期入所療養介護(介護医療院)";
    }

    public String getServiceCodeKind() {
        return "2A";
    }

    public String getSystemServiceKindDetail() {
        return "204211";
    }

    private boolean isHigaeriShort(int shisetsu) {
        return shisetsu == 7;
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================
        
        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));
        
        // 20420101 施設区分
        int _20420101 = getIntValue(map, "20420101");

        // 20420102 人員配置区分（I型）
        int _20420102 = getIntValue(map, "20420102");
        
        // 20420103 人員配置区分（II型）
        int _20420103 = getIntValue(map, "20420103");
        
        // 20420104	人員配置区分（特別型）
        int _20420104 = getIntValue(map, "20420104");
        
        // 20420105 病室区分(従来型)
        int _20420105 = getIntValue(map, "20420105");

        // 20420106 病室区分(ユニット型)
        int _20420106 = getIntValue(map, "20420106");

        // 病室区分
        int byoshitsu = 1;
        switch (_20420101) {
        case 1: // I型
        case 2: // II型
        case 3: // 特別型
            byoshitsu = convertByoshitsuKbn(_20420105, false);
            break;
        case 4: // ユニット型I型
        case 5: // ユニット型II型
        case 6: // ユニット型特別型
            byoshitsu = convertByoshitsuKbn(_20420106, true);
            break;
        case 7: // 日帰りショートステイ
            byoshitsu = getIntValue(map, "20420107");
            break;
        }

        // 20420108 時間区分
        int _20420108 = getIntValue(map, "20420108");
        
        // 20420109 ユニットケアの整備
        int _20420109 = getIntValue(map, "20420109");

        // 20420110 夜間勤務等看護加算
        int _20420110 = getIntValue(map, "20420110");

        // 20420111 療養環境減算（廊下）
        int _20420111 = getIntValue(map, "20420111");
        
        // 20420112 療養環境減算（療養室）
        int _20420112 = getIntValue(map, "20420112");
        
        // 20420113 夜間勤務条件基準
        int _20420113 = getIntValue(map, "20420113");
        
        // 20420114 人員減算
        int _20420114 = getIntValue(map, "20420114");

        // 20420115 認知症行動・心理症状緊急対応加算
        int _20420115 = getIntValue(map, "20420115", 1);

        // 20420116 緊急短期入所受入加算
        int _20420116 = getIntValue(map, "20420116", 1);

        // 20420117 若年性認知症利用者受入加算
        int _20420117 = getIntValue(map, "20420117", 1);

        // 6 送迎加算
        int _6 = getIntValue(map, "6");

        // 20420118 療養食加算
        int _20420118 = getIntValue(map, "20420118");

        // 20420119 緊急時治療管理
        int _20420119 = getIntValue(map, "20420119");

        // 20420120 認知症専門ケア加算
        int _20420120 = getIntValue(map, "20420120");

        // 20420121 重度認知症疾患療養体制加算
        int _20420121 = getIntValue(map, "20420121");

        // 20420122 サービス提供体制強化加算
        int _20420122 = getIntValue(map, "20420122", 1);

        // 20420123 食事提供
        int _20420123 = getIntValue(map, "20420123");

        // 20420124 食費
        this.shokuhi = getIntValue(map, "20420124");

        // 20420107 日帰りショート用病室区分
        int _20420107 = getIntValue(map, "20420107");
        
        
        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map, Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設区分
        sb.append(CODE_CHAR[_20420101]);

        // 人員配置区分（I型）
        if (_20420101 == 1 || _20420101 == 4 || _20420101 == 5) {
        	 sb.append(CODE_CHAR[_20420102]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // 人員配置区分(II型)
        if (_20420101 == 2) {
        	sb.append(CODE_CHAR[_20420103]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // 人員配置区分(特別型)
        if (_20420101 == 3 || _20420101 == 6) {
        	sb.append(CODE_CHAR[_20420104]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // 従来型個室/多床室
        sb.append(CODE_CHAR[_20420105]);
        
        // ユニット型個室/ユニット型個室的多床室
        sb.append(CODE_CHAR[_20420106]);
        
        // 要介護度
        if (isHigaeriShort(_20420101)) {
            // 日帰りショートの場合、要介護度は絡まない
            sb.append(DEFAULT_CHAR);
        } else {
            sb.append(CODE_CHAR[_1]);
        }

        // 時間区分
        sb.append(CODE_CHAR[_20420108]);

        // 夜間勤務条件基準
        sb.append(CODE_CHAR[_20420113]);
        
        // 人員減算
        sb.append(CODE_CHAR[_20420114]);
        
        // ユニットケアの整備
        switch (_20420101) {
        case 1: // I型
        case 2: // II型
        case 3: // 特別型
        case 7: // 日帰りショートステイ
            sb.append(DEFAULT_CHAR);
            break;
            
        //ユニット型
        case 4: // ユニット型I型
        case 5: // ユニット型II型
        case 6: // ユニット型特別型
            // 値を反転させる
            // 整備している場合
            if (_20420109 > 1)  {
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
        switch (_20420110) {
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
        if (_20420111 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6601");
        }
        
        // 療養環境減算（療養室）
        if (_20420112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6603");
        }

        // 認知症緊急対応加算
        if (_20420115 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6121");
        }
        
        // 緊急短期入所受入加算
        if (_20420116 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6277");
        }
        
        // 若年性認知症受入加算
        if (_20420117 > 1) {
            // 日帰りショートの場合
            if (isHigaeriShort(_20420101)) {
                // 若年性認知症受入加算２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6110");
            } else {
                // 若年性認知症受入加算１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
            }
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
        switch (_20420118) {
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
        if (_20420119 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6000");
        }

        // 認知症専門ケア加算
        switch (_20420120) {
        case 2:
            // 認知症専門ケア加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6133");
            break;
        case 3:
            // 認知症専門ケア加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6134");
            break;
        }
        
        // 重度認知症疾患療養体制加算
        switch (_20420121) {
        case 2:
        	if (_1 == 5 || _1 == 6) { // 要介護1,2
	            // 重度認知症疾患療養体制加算I１
	            putSystemServiceCodeItem(sysSvcCdItems, "Z6351");
        	} else if (_1 == 7 || _1 == 8 || _1 == 9) { // 要介護3,4,5
	            // 重度認知症疾患療養体制加算I２
	            putSystemServiceCodeItem(sysSvcCdItems, "Z6352");
        	}
            break;
        case 3:
        	if (_1 == 5 || _1 == 6) { // 要介護1,2
	            // 重度認知症疾患療養体制加算II１
	            putSystemServiceCodeItem(sysSvcCdItems, "Z6353");
        	} else if (_1 == 7 || _1 == 8 || _1 == 9) { // 要介護3,4,5
	            // 重度認知症疾患療養体制加算II２
	            putSystemServiceCodeItem(sysSvcCdItems, "Z6354");
        	}
            break;
        }
        
        // サービス提供体制加算
        switch (_20420122) {
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
            if (_20420123 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }
            // 滞在費 --------
            if (isHigaeriShort(_20420101)) {
                // 日帰りショートだった場合
                // 日帰りショート専用病室区分
                putSystemServiceCodeItem(sysSvcCdItems,
                        getSystemServiceCodeOfRoom(_20420107));
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
