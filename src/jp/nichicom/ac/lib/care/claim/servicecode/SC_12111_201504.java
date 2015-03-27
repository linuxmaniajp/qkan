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
 * 短期入所生活介護
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_12111_201504 extends Qkan10011_ServiceUnitGetter {
    private int shokuhi = 0;

    private final String PATH_UNIT_ROOM = "1210112";
    private final String PATH_UNIT_SEMI_ROOM = "1210113";
    private final String PATH_NORMAL_ROOM = "1210114";
    private final String PATH_TASHO_ROOM = "1210115";

    public String getServiceName() {
        return "短期入所生活介護";
    }

    public String getServiceCodeKind() {
        return "21";
    }

    public String getSystemServiceKindDetail() {
        return "12111";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================
        // 1210101 施設区分
        int _1210101 = getIntValue(map, "1210101");

        // 1210103 病室区分(従来型個室、多床室)
        int _1210103 = getIntValue(map, "1210103");

        // 1210104 病室区分(ユニット型個室、ユニット型準個室)
        int _1210104 = getIntValue(map, "1210104");

        // 病室区分
        int byoshitsu = 1;
        switch (_1210101) {
        case 1:
        case 2:
            byoshitsu = convertByoshitsuKbn(_1210103, false);
            break;
        case 3:
        case 4:
            byoshitsu = convertByoshitsuKbn(_1210104, true);
            break;
        }

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1210105 夜間勤務条件基準
        int _1210105 = getIntValue(map, "1210105");

        // 1210110 人員減算
        int _1210110 = getIntValue(map, "1210110");

        // 1210115 ユニットケアの整備
        int _1210115 = getIntValue(map, "1210115");

        // 1210106 機能訓練体制加算
        int _1210106 = getIntValue(map, "1210106", 1);

        // 6 送迎加算
        int _6 = getIntValue(map, "6");

        // 1210109 療養食加算
        int _1210109 = getIntValue(map, "1210109");

        // 1210118 在宅中重度加算
        int _1210118 = getIntValue(map, "1210118");

        // 1210111 食事提供
        int _1210111 = getIntValue(map, "1210111");

        // 1210114 食費
        this.shokuhi = getIntValue(map, "1210114");

        // 1210121 夜勤職員配置加算
        int _1210121 = getIntValue(map, "1210121", 1);

        // 1210124 認知症行動・心理症状緊急対応加算
        int _1210124 = getIntValue(map, "1210124", 1);

        // 1210122 若年性認知症利用者受入加算
        int _1210122 = getIntValue(map, "1210122", 1);

        // 1210119 看護体制 I型
        int _1210119 = getIntValue(map, "1210119", 1);

        // 1210120 看護体制 II型
        int _1210120 = getIntValue(map, "1210120", 1);

        // 1210123 サービス提供体制強化加算
        int _1210123 = getIntValue(map, "1210123", 1);

        // 1210126 緊急短期入所受入加算
        int _1210126 = getIntValue(map, "1210126", 1);
        
        // 1210127 個別機能訓練加算
        int _1210127 = getIntValue(map, "1210127", 1);
        
        // 1210128 医療連携強化加算
        int _1210128 = getIntValue(map, "1210128", 1);
        
        // 1210129 長期利用者提供減算
        int _1210129 = getIntValue(map, "1210129", 1);
        
        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map, Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設区分
        sb.append(CODE_CHAR[_1210101]);

        // 従来型個室、多床室
        sb.append(CODE_CHAR[_1210103]);
        // ユニット型個室、ユニット型準個室
        sb.append(CODE_CHAR[_1210104]);

        // 要介護度
        sb.append(CODE_CHAR[_1]);

        // 夜間勤務条件基準
        sb.append(CODE_CHAR[_1210105]);

        // 人員減算
        sb.append(CODE_CHAR[_1210110]);

        // ユニットケアの未整備
        sb.append(CODE_CHAR[_1210115]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        // 6004 短期生活機能訓練体制加算
        if (_1210106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6004");
        }
        
        // 6113 短期生活看護体制加算I
        if (_1210119 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6113");
        }

        // 6115 短期生活看護体制加算II
        if (_1210120 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6115");
        }
        
        // 6117 短期生活夜勤職員配置加算I
        // 6119 短期生活夜勤職員配置加算II
        if (_1210121 > 1) {
            switch (_1210101) {
            case 1:// 単独型
            case 2:// 併設型
                putSystemServiceCodeItem(sysSvcCdItems, "Z6117");
                break;
            case 3:// 単独型ユニット
            case 4:// 併設型ユニット
                putSystemServiceCodeItem(sysSvcCdItems, "Z6119");
                break;
            }
        }
        
        // 6121 短期生活認知症緊急対応加算
        if (_1210124 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6121");
        }
        
        // 6109 短期生活若年性認知症受入加算
        if (_1210122 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // 送迎加算
        switch (_6) {
        case 3: // 往復
            putSystemServiceCodeItem(sysSvcCdItems, "Z92002");
        case 2: // 片道
            putSystemServiceCodeItem(sysSvcCdItems, "Z92001");
            break;
        }
        
        
        // 緊急短期入所受入加算
        if (_1210126 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6282");
        }
        
        // 療養食加算
        if (_1210109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
        }
        
        // 在宅中重度加算
        // 看護体制加算も考慮し加算を決定する。
        if (_1210118 > 1) {
            if (_1210119 == 2 && _1210120 == 2) {
                // 6279 短期生活在宅中重度者受入加算３
                putSystemServiceCodeItem(sysSvcCdItems, "Z6279");
            } else if (_1210119 == 2) {
                // 6277 短期生活在宅中重度者受入加算１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6277");
            } else if (_1210120 == 2) {
                // 6278 短期生活在宅中重度者受入加算２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6278");
            } else {
                // 6280 短期生活在宅中重度者受入加算４
                putSystemServiceCodeItem(sysSvcCdItems, "Z6280");
            }
        }
        
        // 1210127 個別機能訓練加算
        if (_1210127 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6005");//2015.04
        }
        
        // 1210128 医療連携強化加算
        if (_1210128 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6116");//2015.04
        }
        
        // 1210129 長期利用者提供減算
        if (_1210129 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6283");//2015.04
        }
        
        
        // 短期生活サービス提供体制加算
        switch (_1210123) {
        // 短期生活サービス提供体制加算Iイ
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        // 短期生活サービス提供体制加算Iロ
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        // 短期生活サービス提供体制加算II
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        // 短期生活サービス提供体制加算III
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }

        // 介護職員処遇改善を返却
        switch(_17){
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
        
        
        // 特定入所者チェックがついていた場合は個室の単位数を追加
        if (!new Integer(1).equals(map.get("7")) && !"1".equals(map.get("7"))) {
            // 食事提供
            if (_1210111 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }
            // 滞在費 --------
            putSystemServiceCodeItem(sysSvcCdItems,
                    getSystemServiceCodeOfRoom(byoshitsu));
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
