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
 * 介護予防短期入所療養介護(療養病床を有する病院)
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_12611_201504 extends Qkan10011_ServiceUnitGetter {
    private int _1260112 = 0;

    private final String PATH_UNIT_ROOM = "1260114";
    private final String PATH_UNIT_SEMI_ROOM = "1260115";
    private final String PATH_NORMAL_ROOM = "1260116";
    private final String PATH_TASHO_ROOM = "1260117";

    public String getServiceName() {
        return "介護予防短期入所療養介護(療養病床を有する病院)";
    }

    public String getServiceCodeKind() {
        return "26";
    }

    public String getSystemServiceKindDetail() {
        return "12611";
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

        // 1260101 施設等の区分　1-病院 2-ユニット型病院 3-経過型 4-ユニット型経過型
        int _1260101 = getIntValue(map, "1260101", 1);

        // 1260102 人員配置区分
        int _1260102 = getIntValue(map, "1260102", 1);

        // 1260118 人員配置区分（ユニット型病院療養型用）
        int _1260118 = getIntValue(map, "1260118");

        // 1260119 人員配置区分（病院経過型用）
        int _1260119 = getIntValue(map, "1260119");
        
        // 1260103 病室区分(従来型)　1-従来型個室 2-多床室
        // 1260104 病室区分(ユニット型)　1-ユニット型個室 2-ユニット型準個室
        // 変換→1-従来型個室 2-多床室 3-ユニット型個室 4-ユニット型準個室
        int byoshitsuKubun = 0;
        switch (_1260101) {
        case 1: // 病院
        case 3: // 経過型
            // 従来型
            byoshitsuKubun = convertByoshitsuKbn(getIntValue(map, "1260103"), false);
            break;
        case 2: // ユニット型病院
        case 4: // ユニット型経過型
            // ユニット型
            byoshitsuKubun = convertByoshitsuKbn(getIntValue(map, "1260104"), true);
            break;
        }

        // 1260105 夜間勤務条件基準　1-基準型 2-加算型Ⅰ 3-加算型Ⅱ 4-加算型Ⅲ 5-減算型
        int _1260105 = getIntValue(map, "1260105", 1);

        // 1260116 療養環境減算　1-基準型 2-減算型Ⅰ 4-減算型Ⅲ
        int _1260116 = getIntValue(map, "1260116", 1);

        // 1260107 医師の配置基準　1-基準 2-医療法施行規則第49条適用
        int _1260107 = getIntValue(map, "1260107", 1);

        // 1260109 療養食加算　1-なし 2-あり
        int _1260109 = getIntValue(map, "1260109", 1);

        // 1260110 人員減算　1-なし 2-定員超過 3-看護・介護職員の不足 4-正看比率が20%未満 5-僻地届出有 6-僻地届出無
        int _1260110 = getIntValue(map, "1260110", 1);

        // 1260111 食事提供　1-なし 2-三食 3-朝 4-昼 5-夜 6-朝昼 7-昼夜 8-夜朝
        int _1260111 = getIntValue(map, "1260111", 1);

        // 1260112 食事費用
        this._1260112 = getIntValue(map, "1260112");

        // 1260113 ユニットケアの整備　1-未整備 2-整備
        int _1260113 = getIntValue(map, "1260113");

        // 1260117 認知症行動・心理症状緊急対応加算
        int _1260117 = getIntValue(map, "1260117");

        // 1260114 若年性認知症利用者受入加算
        int _1260114 = getIntValue(map, "1260114");

        // 1260115 サービス提供体制強化加算
        int _1260115 = getIntValue(map, "1260115");

        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設等の区分　1-病院 2-ユニット型病院 3-経過型 4-ユニット型経過型
        sb.append(CODE_CHAR[_1260101]);

        // 人員配置区分　1-Ⅰ型 2-Ⅱ型 3-Ⅲ型
        // 人員配置区分１
        if (_1260101 == 1) {
        	 sb.append(CODE_CHAR[_1260102]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // 人員配置区分２
        if (_1260101 == 2) {
        	sb.append(CODE_CHAR[_1260118]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // 人員配置区分３
        if (_1260101 == 3) {
        	sb.append(CODE_CHAR[_1260119]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // 病室区分　変換→1-従来型個室 2-多床室 3-ユニット型個室 4-ユニット型準個室
        sb.append(CODE_CHAR[byoshitsuKubun]);

        // 要介護度
        sb.append(CODE_CHAR[_1]);

        // 夜間勤務条件基準　1-基準型 2-加算型Ⅰ 3-加算型Ⅱ 4-加算型Ⅲ 5-減算型
        sb.append(CODE_CHAR[_1260105]);

        // 人員減算　1-なし 2-定員超過 3-看護・介護職員の不足 4-正看比率が20%未満 5-僻地届出有 6-僻地届出無
        sb.append(CODE_CHAR[_1260110]);

        // ユニットケアの整備　変換→1-整備 2-未整備
        switch (_1260101) {
        case 1: // 病院
        case 3: // 経過型
            sb.append(DEFAULT_CHAR);
            break;
        case 2: // ユニット型病院
        case 4: // ユニット型経過型
            // 1-未整備 2-整備
            if (_1260113 > 1) {
                sb.append(DEFAULT_CHAR);
            } else {
                sb.append(CODE_CHAR[2]);
            }
            break;
        }

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        
        // 療養環境減算　1-基準型 2-減算型Ⅰ 4-減算型Ⅲ
        switch (_1260116) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2601");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2603");
            break;
        }
        
        // 医師の配置基準　1-基準 2-医療法施行規則第49条適用
        if (_1260107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2700");
        }
        
        // 2706 予病院療短認知症緊急対応加算
        if (_1260117 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2706");
        }
        
        // 2704 予病院療短若年性認知症受入加算
        if (_1260114 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2704");
        }
        
        // 送迎加算
        switch (_6) {
        case 3: // 往復
            putSystemServiceCodeItem(sysSvcCdItems, "Z29202");
        case 2: // 片道
            putSystemServiceCodeItem(sysSvcCdItems, "Z29201");
            break;
        }
        
        // 療養食加算　1-なし 2-あり
        if (_1260109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2775");
        }
        
        switch (_1260115) {
        case 5:
            // 2705 予病院療短サービス提供体制加算Iイ
            putSystemServiceCodeItem(sysSvcCdItems, "Z2705");//TODO:コード値確認
            break;
        case 2:
            // 2701 予病院療短サービス提供体制加算Iロ
            putSystemServiceCodeItem(sysSvcCdItems, "Z2701");
            break;
        case 3:
            // 2702 予病院療短サービス提供体制加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z2702");
            break;
        case 4:
            // 2703 予病院療短サービス提供体制加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z2703");
            break;
        }

        // 介護職員処遇改善を返却
        switch (_17) {
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z2710");//TODO:コード値確認
            break;
        case 2:
            // 予病院療短処遇改善加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z2711");
            break;
        case 3:
            // 予病院療短処遇改善加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z2712");
            break;
        case 4:
            // 予病院療短処遇改善加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z2713");
            break;
        }

        // 特定入所者
        if (!new Integer(1).equals(map.get("7")) && !"1".equals(map.get("7"))) {
            // 食事提供
            if (_1260111 > 1) {
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
                if (this._1260112 <= 0) {
                    // 食費が0円以下の場合
                    // 該当レコードを削除する。
                    al.remove(i);
                    // 削除したためインデックスを1つ戻す。
                    i--;
                } else {
                    // 食費が0円以下でない場合
                    // 食費を業務から渡された値で上書きする。
                    mp.put("SERVICE_UNIT", new Integer(this._1260112));
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
