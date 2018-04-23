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
 * 短期入所療養介護(老人性認知症疾患療養病棟を有する病院)
 * 
 * @since V7.0.0
 * @author Yoiciro.Kamei
 * 
 */
public class SC_12313_201804 extends Qkan10011_ServiceUnitGetter {
    private int shokuhi = 0;

    private final String PATH_UNIT_ROOM = "1230311";
    private final String PATH_UNIT_SEMI_ROOM = "1230312";
    private final String PATH_NORMAL_ROOM = "1230313";
    private final String PATH_TASHO_ROOM = "1230314";

    public String getServiceName() {
        return "短期入所療養介護(老人性認知症疾患療養病棟を有する病院)";
    }

    public String getServiceCodeKind() {
        return "23";
    }

    public String getSystemServiceKindDetail() {
        return "12313";
    }

    private boolean isHigaeriShort(int shisetsu) {
        return shisetsu == 4;
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================
        // 1230301 施設区分
        int _1230301 = getIntValue(map, "1230301");

        // 1230308 病院区分
        int _1230308 = getIntValue(map, "1230308");

        // 1230302 人員配置区分
        int _1230302 = getIntValue(map, "1230302");

        // 1230303 病室区分(従来型)
        int _1230303 = getIntValue(map, "1230303");

        // 1230304 病室区分(ユニット型)
        int _1230304 = getIntValue(map, "1230304");

        // 病室区分
        int byoshitsu = 1;
        switch (_1230301) {
        case 1: // 認知症疾患型
        case 3: // 経過型
            byoshitsu = convertByoshitsuKbn(_1230303, false);
            break;
        case 2: // ユニット型認知症疾患型
            byoshitsu = convertByoshitsuKbn(_1230304, true);
            break;
        case 4: // 日帰りショートステイ
            byoshitsu = getIntValue(map, "1230311");
            break;
        }

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1230346 人員減算
        int _1230346 = getIntValue(map, "1230346");

        // 1230309 ユニットケアの整備
        int _1230309 = getIntValue(map, "1230309");

        // 6 送迎加算
        int _6 = getIntValue(map, "6");

        // 1230307 療養食加算
        int _1230307 = getIntValue(map, "1230307");

        // 1230347 食事提供
        int _1230347 = getIntValue(map, "1230347");

        // 1230350 食費
        this.shokuhi = getIntValue(map, "1230350");

        // 1230311 日帰りショート用病室区分
        int _1230311 = getIntValue(map, "1230311");

        // 1230352 時間区分
        int _1230352 = getIntValue(map, "1230352");

        // 1230351 サービス提供体制強化加算
        int _1230351 = getIntValue(map, "1230351");

        // 1230312 緊急短期入所受入加算
        int _1230312 = getIntValue(map, "1230312", 1);
        
        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map, Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設区分
        sb.append(CODE_CHAR[_1230301]);

        // 病院区分
        sb.append(CODE_CHAR[_1230308]);

        // 人員配置区分
        sb.append(CODE_CHAR[_1230302]);
        
        // 従来型個室/多床室
        sb.append(CODE_CHAR[_1230303]);
        
        // ユニット型個室/ユニット型準個室
        sb.append(CODE_CHAR[_1230304]);

        // 時間区分
        sb.append(CODE_CHAR[_1230352]);

        // 要介護度
        if (isHigaeriShort(_1230301)) {
            // 日帰りショートの場合、要介護度は絡まない
            sb.append(DEFAULT_CHAR);
        } else {
            sb.append(CODE_CHAR[_1]);
        }

        // 人員減算
        sb.append(CODE_CHAR[_1230346]);

        // ユニットケアの整備
        switch (_1230301) {
        //診療所、日帰りショート
        case 1: // 認知症疾患型
        case 3: // 経過型
        case 4: // 日帰りショートステイ
            sb.append(DEFAULT_CHAR);
            break;
            
        //ユニット型
        case 2:
            // 値を反転させる
            // 整備している場合
            if (_1230309 > 1)  {
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
        // 緊急短期入所受入加算
        if (_1230312 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4751");
        }
        
        // 送迎加算
        switch (_6) {
        case 3: // 往復
            putSystemServiceCodeItem(sysSvcCdItems, "Z49202");
        case 2: // 片道
            putSystemServiceCodeItem(sysSvcCdItems, "Z49201");
            break;
        }

        // 療養食加算
        switch (_1230307) {
        case 2:
            // ３回
            putSystemServiceCodeItem(sysSvcCdItems, "Z4775");
            putSystemServiceCodeItem(sysSvcCdItems, "Z4775");
            putSystemServiceCodeItem(sysSvcCdItems, "Z4775");
            break;
        case 3:
            // ２回
            putSystemServiceCodeItem(sysSvcCdItems, "Z4775");
            putSystemServiceCodeItem(sysSvcCdItems, "Z4775");
            break;
        case 4:
            // １回
            putSystemServiceCodeItem(sysSvcCdItems, "Z4775");
            break;
        }
        
        // 認知症短期サービス提供体制加算
        switch (_1230351) {
        case 5:
            // 4700 認知症短期サービス提供体制加算Iイ
            putSystemServiceCodeItem(sysSvcCdItems, "Z4700");//2015.04
            break;
        case 2:
            // 4701 認知症短期サービス提供体制加算Iロ
            putSystemServiceCodeItem(sysSvcCdItems, "Z4701");
            break;
        case 3:
            // 4702 認知症短期サービス提供体制加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z4702");
            break;
        case 4:
            // 4703 認知症短期サービス提供体制加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z4703");
            break;
        }
        
        // 介護職員処遇改善を返却
        switch(_17){
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4709");//2017.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4710");//2015.04
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
            if (_1230347 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }
            // 滞在費 --------
            if (isHigaeriShort(_1230301)) {
                // 日帰りショートだった場合
                // 日帰りショート専用病室区分
                putSystemServiceCodeItem(sysSvcCdItems,
                        getSystemServiceCodeOfRoom(_1230311));
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
