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
 * 短期入所療養介護(療養病床を有する診療所)
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_12312_201504 extends Qkan10011_ServiceUnitGetter {
    private int shokuhi = 0;

    private final String PATH_UNIT_ROOM = "1230212";
    private final String PATH_UNIT_SEMI_ROOM = "1230213";
    private final String PATH_NORMAL_ROOM = "1230214";
    private final String PATH_TASHO_ROOM = "1230215";

    public String getServiceName() {
        return "短期入所療養介護(療養病床を有する診療所)";
    }

    public String getServiceCodeKind() {
        return "23";
    }

    public String getSystemServiceKindDetail() {
        return "12312";
    }

    private boolean isHigaeriShort(int shisetsu) {
        return shisetsu == 3;
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================

        // 1230201 施設区分
        int _1230201 = getIntValue(map, "1230201");

        // 1230202 人員配置区分
        int _1230202 = getIntValue(map, "1230202");

        // 1230214	人員配置区分（ユニット型診療所型用）
        int _1230214 = getIntValue(map, "1230214");
        
        // 1230203 病室区分(従来型)
        int _1230203 = getIntValue(map, "1230203");

        // 1230204 病室区分(ユニット型)
        int _1230204 = getIntValue(map, "1230204");

        // 病室区分
        int byoshitsu = 1;
        switch (_1230201) {
        case 1:
            byoshitsu = convertByoshitsuKbn(_1230203, false);
            break;
        case 2:
            byoshitsu = convertByoshitsuKbn(_1230204, true);
            break;
        }

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1230209 人員減算
        int _1230209 = getIntValue(map, "1230209");

        // 1230210 ユニットケアの整備
        int _1230210 = getIntValue(map, "1230210");

        // 1230254 療養環境減算
        int _1230254 = getIntValue(map, "1230254");

        // 6 送迎加算
        int _6 = getIntValue(map, "6");

        // 1230208 療養食加算
        int _1230208 = getIntValue(map, "1230208");

        // 1230249 食事提供
        int _1230249 = getIntValue(map, "1230249");

        // 1230251 食費
        this.shokuhi = getIntValue(map, "1230251");

        // 1230212 日帰りショート用病室区分
        int _1230212 = getIntValue(map, "1230212");

        // 1230252 設備基準減算
        int _1230252 = getIntValue(map, "1230252");

        // 1230255 時間区分
        int _1230255 = getIntValue(map, "1230255", 1);

        // 1230256 認知症行動・心理症状緊急対応加算
        int _1230256 = getIntValue(map, "1230256", 1);

        // 1230257 若年性認知症利用者受入加算
        int _1230257 = getIntValue(map, "1230257", 1);

        // 1230253 サービス提供体制強化加算
        int _1230253 = getIntValue(map, "1230253", 1);

        // 1230213 緊急短期入所受入加算
        int _1230213 = getIntValue(map, "1230213", 1);
        
        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map, Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設区分
        sb.append(CODE_CHAR[_1230201]);
        
        // 人員配置区分１
        if (_1230201 == 1) {
        	 sb.append(CODE_CHAR[_1230202]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // 人員配置区分２
        if (_1230201 == 2) {
        	sb.append(CODE_CHAR[_1230214]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // 従来型個室/多床室
        sb.append(CODE_CHAR[_1230203]);
        // ユニット型個室/ユニット型準個室
        sb.append(CODE_CHAR[_1230204]);

        // 時間区分
        sb.append(CODE_CHAR[_1230255]);
        
        // 要介護度
        if (isHigaeriShort(_1230201)) {
            // 日帰りショートの場合、要介護度は絡まない
            sb.append(DEFAULT_CHAR);
        } else {
            sb.append(CODE_CHAR[_1]);
        }

        // 人員減算
        sb.append(CODE_CHAR[_1230209]);

        // ユニットケアの整備
        switch (_1230201) {
        //診療所、日帰りショート
        case 1:
        case 3:
            sb.append(DEFAULT_CHAR);
            break;
            
        //ユニット型
        case 2:
            // 値を反転させる
            // 整備している場合
            if (_1230210 > 1)  {
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
        // 設備基準減算
        switch (_1230252) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z3600");
            break;
        }
        // 療養環境減算
        switch (_1230254) {
        // 療養環境減算のⅠ型は廃止されⅡ型のみ生成可能とする
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z3602");
            break;
        }
        
        // 3706 診療所短期認知症緊急対応加算
        if (_1230256 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3706");
        }
        
        // 緊急短期入所受入加算
        if (_1230213 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3751");
        }
        
        if (_1230257 > 1) {
            if (isHigaeriShort(_1230201)) {
                // 3705 診療所短期若年性認知症受入加算２
                putSystemServiceCodeItem(sysSvcCdItems, "Z3705");
            } else {
                // 3704 診療所短期若年性認知症受入加算１
                putSystemServiceCodeItem(sysSvcCdItems, "Z3704");
            }
        }
        
        // 送迎加算
        switch (_6) {
        case 3: // 往復
            putSystemServiceCodeItem(sysSvcCdItems, "Z39202");
        case 2: // 片道
            putSystemServiceCodeItem(sysSvcCdItems, "Z39201");
            break;
        }
        
        // 療養食加算
        if (_1230208 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3775");
        }
        
        // 診療所短期サービス提供体制加算
        switch (_1230253) {
        case 5:
            // 3707 診療所短期サービス提供体制加算Iイ
            putSystemServiceCodeItem(sysSvcCdItems, "Z3700");
            break;
        case 2:
            // 3701 診療所短期サービス提供体制加算Iロ
            putSystemServiceCodeItem(sysSvcCdItems, "Z3701");
            break;
        case 3:
            // 3702 診療所短期サービス提供体制加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z3702");
            break;
        case 4:
            // 3703 診療所短期サービス提供体制加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z3703");
            break;
        }
        
        // 介護職員処遇改善を返却
        switch(_17){
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z3709");//2017.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z3710");//2015.04
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
            if (_1230249 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }
            // 滞在費 --------
            if (isHigaeriShort(_1230201)) {
                // 日帰りショートだった場合
                // 日帰りショート専用病室区分
                putSystemServiceCodeItem(sysSvcCdItems,
                        getSystemServiceCodeOfRoom(_1230212));
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
