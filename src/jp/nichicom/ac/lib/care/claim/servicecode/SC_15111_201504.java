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
 * 介護福祉施設
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_15111_201504 extends Qkan10011_ServiceUnitGetter {
    private int _1510123 = 0;

    private final String PATH_UNIT_ROOM = "1510117";
    private final String PATH_UNIT_SEMI_ROOM = "1510118";
    private final String PATH_NORMAL_ROOM = "1510119";
    private final String PATH_TASHO_ROOM = "1510120";

    public String getServiceName() {
        return "介護福祉施設";
    }

    public String getServiceCodeKind() {
        return "51";
    }

    public String getSystemServiceKindDetail() {
        return "15111 ";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================
        // 1510101 施設区分
        int _1510101 = getIntValue(map, "1510101");

        // 8 旧措置入所者
        int _8 = getIntValue(map, "8");

        // 1510102 病室区分(従来型)
        int _1510102 = getIntValue(map, "1510102", 1);

        // 1510103 病室区分(ユニット型)
        int _1510103 = getIntValue(map, "1510103", 1);

        // 病室区分
        int byoshitsu = 1;
        switch (_1510101) {
        case 1:
        case 2:
            byoshitsu = convertByoshitsuKbn(_1510102, false);
            break;
        case 3:
        case 4:
            byoshitsu = convertByoshitsuKbn(_1510103, true);
            break;
        }

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 経過措置対応用に要支援１または要支援２だった場合は要介護１とみなす
        if (_1 == 3 || _1 == 4) {
            _1 = 5;
        }

        // 1510106 夜間勤務条件基準
        int _1510106 = getIntValue(map, "1510106");

        // 1510120 人員減算
        int _1510120 = getIntValue(map, "1510120");

        // 1510124 ユニットケアの整備
        int _1510124 = getIntValue(map, "1510124");

        // 1510125 準ユニットケア加算
        int _1510125 = getIntValue(map, "1510125");

        // 1510107 個別機能訓練指導加算
        int _1510107 = getIntValue(map, "1510107");

        // 1510108 医師常勤加算
        int _1510108 = getIntValue(map, "1510108");

        // 1510109 精神科医指導加算
        int _1510109 = getIntValue(map, "1510109");

        // 1510110 障害者生活援助員常勤加算
        int _1510110 = getIntValue(map, "1510110");

        // 1510128 身体拘束廃止未実施減算
        int _1510128 = getIntValue(map, "1510128");

        // 1510111 外泊加算
        int _1510111 = getIntValue(map, "1510111");

        // 1510112 初期加算
        int _1510112 = getIntValue(map, "1510112");

        // 3020102 退所時相談援助加算
        int _3020102 = getIntValue(map, "3020102");

        // 3020103 退所前連携加算
        int _3020103 = getIntValue(map, "3020103");

        // 1510114 栄養マネジメント加算
        int _1510114 = getIntValue(map, "1510114");

        // 1510115 経口移行加算
        int _1510115 = getIntValue(map, "1510115");

        // 1510126 経口維持加算I
        int _1510126 = getIntValue(map, "1510126");
        
        // 1510146 経口維持加算II
        int _1510146 = getIntValue(map, "1510146");

        // 1510116 療養食加算
        int _1510116 = getIntValue(map, "1510116");

        // 1510130 在宅復帰支援機能加算
        int _1510130 = getIntValue(map, "1510130");

        // 1510131 在宅・入所相互利用加算
        int _1510131 = getIntValue(map, "1510131");

        // 1510121 食事提供
        int _1510121 = getIntValue(map, "1510121");

        // 1510123 食費
        this._1510123 = getIntValue(map, "1510123");

        // 1510133 日常生活継続支援加算
        int _1510133 = getIntValue(map, "1510133");

        // 1510142 看護体制加算Ⅰ型
        int _1510142 = getIntValue(map, "1510142");

        // 1510143 看護体制加算Ⅱ型
        int _1510143 = getIntValue(map, "1510143");

        // 1510135 夜勤職員配置加算
        int _1510135 = getIntValue(map, "1510135");

        // 1510136 入所定員
        int _1510136 = getIntValue(map, "1510136");

        // 1510137 若年性認知症入所者受入加算
        int _1510137 = getIntValue(map, "1510137");

        // 1510138 口腔機能維持管理加算
        int _1510138 = getIntValue(map, "1510138");

        // 1510139 看取り介護加算
        int _1510139 = getIntValue(map, "1510139");

        // 1510140 認知症専門ケア加算
        int _1510140 = getIntValue(map, "1510140");

        // 1510141 サービス提供体制強化加算
        int _1510141 = getIntValue(map, "1510141");

        // 単独加算
        int _9 = getIntValue(map, "9");

        // 3020109 退所前訪問指導加算
        int _3020109 = getIntValue(map, "3020109", 1);

        // 3020110 退所後訪問指導加算
        int _3020110 = getIntValue(map, "3020110", 1);

        // 1510144 認知症行動・心理症状緊急対応加算
        int _1510144 = getIntValue(map, "1510144", 1);

        // 1510145 口腔機能維持管理体制加算
        int _1510145 = getIntValue(map, "1510145", 1);

        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 単独加算のみ---------------------------------------------------------------
        // 単独加算サービス
        if (_9 == 2) {
            // 看取り介護加算
            switch (_1510139) {
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6276");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6277");
                break;
            case 4:
                // 6283 福祉施設看取り介護加算３
                putSystemServiceCodeItem(sysSvcCdItems, "Z6283");
                break;
            }
            
            // 福祉施設退所後訪問相談援助加算
            if (_3020110 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6504");
            }

            // 介護職員処遇改善を返却
            switch (_17) {
            case 6:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6110");//2017.04
                break;
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2015.04
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

            return sysSvcCdItems;
        }

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設区分
        sb.append(CODE_CHAR[_1510101]);

        // 病室区分(従来型個室/多床室)
        sb.append(CODE_CHAR[_1510102]);

        // 旧措置入所者
        sb.append(CODE_CHAR[_8]);

        // 病室区分(ユニット型個室/ユニット型準個室)
        sb.append(CODE_CHAR[_1510103]);

        // 要介護度
        sb.append(CODE_CHAR[_1]);

        // 夜間勤務条件基準
        sb.append(CODE_CHAR[_1510106]);

        // 人員減算
        sb.append(CODE_CHAR[_1510120]);

        // ユニットケアの整備
        switch (_1510101) {
        case 1: // 個室・多床室
        case 2:
            sb.append(DEFAULT_CHAR);
            break;
        case 3: // ユニット型
        case 4:
            // 1-未整備 2-整備
            if (_1510124 > 1) {
                sb.append(DEFAULT_CHAR);
            } else {
                sb.append(CODE_CHAR[2]);
            }
            break;
        }

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        // Z6132 福祉施設日常生活継続支援加算
        if (_1510133 > 1) {
            // 施設区分による分岐
            switch (_1510101) {
            case 1:
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6132");
                break;
            case 3:
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6135");//2015.04
                break;
            }
        }

        // 福祉施設看護体制加算 I型
        if (_1510142 > 1) {
            // 入所定員で分岐
            switch (_1510136) {
            case 1: // 31人以上50人以下
                // Z6113 福祉施設看護体制加算I１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6113");
                break;
            case 2: // 30人又は51人以上
                // Z6114 福祉施設看護体制加算I２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6114");
                break;
            }
        }

        // 福祉施設看護体制加算 II型
        if (_1510143 > 1) {
            // 入所定員で分岐
            switch (_1510136) {
            case 1: // 31人以上50人以下
                // Z6115 福祉施設看護体制加算II１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6115");
                break;
            case 2: // 30人又は51人以上
                // Z6116 福祉施設看護体制加算II２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6116");
                break;
            }
        }

        // 夜勤職員配置加算
        if (_1510135 > 1) {
            // 施設区分による分岐
            switch (_1510101) {
            case 1:
            case 2:
                // 入所定員で分岐
                switch (_1510136) {
                case 1: // 31人以上50人以下
                    // Z6117 福祉施設夜勤職員配置加算I１
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6117");
                    break;
                case 2: // 30人又は51人以上
                    // Z6118 福祉施設夜勤職員配置加算I２
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6118");
                    break;
                }
                break;
            case 3:
            case 4:
                // 入所定員で分岐
                switch (_1510136) {
                case 1: // 31人以上50人以下
                    // Z6119 福祉施設夜勤職員配置加算II１
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6119");
                    break;
                case 2: // 30人又は51人以上
                    // Z6120 福祉施設夜勤職員配置加算II２
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6120");
                    break;
                }
                break;
            }

        }

        // 準ユニットケア加算
        if (_1510125 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6002");
        }

        // 個別機能訓練指導加算
        if (_1510107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6003");
        }

        // Z6109 福祉施設若年性認知症受入加算
        if (_1510137 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }

        // 医師常勤加算
        if (_1510108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");
        }

        // 精神科医指導加算
        if (_1510109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6200");
        }

        // 障害者生活援助員常勤加算
        if (_1510110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6250");
        }

        // 身体拘束廃止未実施減算
        if (_1510128 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6304");
        }

        // 外泊加算
        if (_1510111 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6300");
        }

        // 初期加算
        if (_1510112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6400");
        }

        // 退所前訪問相談援助加算
        if (_3020109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6501");
        }

        // 福祉施設退所後訪問相談援助加算
        if (_3020110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6504");
        }

        // 退所時相談援助加算
        if (_3020102 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6502");
        }

        // 退所前連携加算
        if (_3020103 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6503");
        }

        // 栄養マネジメント加算
        if (_1510114 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6273");
        }

        // 経口移行加算
        if (_1510115 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6274");
        }

        // 経口維持加算
        if (_1510126 > 1) {
        	// 福祉施設経口維持加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6280");
        }
        if (_1510146 > 1) {
        	// 福祉施設経口維持加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6281");
        }

        // 口腔機能維持管理体制加算
        if (_1510145 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6122");
        }

        // 口腔機能維持管理加算
        if (_1510138 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6123");
        }

        // 療養食加算
        if (_1510116 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
        }

        // 看取り介護加算
        switch (_1510139) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6276");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6277");
            break;
        case 4:
            // 6283 福祉施設看取り介護加算３
            putSystemServiceCodeItem(sysSvcCdItems, "Z6283");
            break;
        }

        // 在宅復帰支援機能加算
        if (_1510130 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6278");
        }

        // 在宅・入所相互利用加算
        if (_1510131 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6279");
        }

        // 認知症専門ケア加算
        switch (_1510140) {
        case 2:
            // Z6133 福祉施設認知症専門ケア加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6133");
            break;
        case 3:
            // Z6134 福祉施設認知症専門ケア加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6134");
            break;
        }

        // 認知症行動・心理症状緊急対応加算
        if (_1510144 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6121");
        }

        // 福祉施設サービス提供体制加算
        switch (_1510141) {
        case 5:
            // Z6107 福祉施設サービス提供体制加算Iイ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");//2015.04
            break;
        case 2:
            // Z6101 福祉施設サービス提供体制加算Iロ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // Z6102 福祉施設サービス提供体制加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
            // Z6103 福祉施設サービス提供体制加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }

        // 介護職員処遇改善を返却
        switch (_17) {
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6110");//2017.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2015.04
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
            if (_1510121 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }
            // 特定入所者で尚且つ外泊加算がありだった場合
            if (_1510111 > 1) {
                // 初期化する
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // 滞在費 --------
            putSystemServiceCodeItem(sysSvcCdItems,
                    getSystemServiceCodeOfRoom(byoshitsu));
        }// チェックがついていない場合は何も返さない

        // 外泊がありだった場合は一律外泊のコードを返す
        if (_1510111 > 1) {
            if (new Integer(1).equals(map.get("7")) || "1".equals(map.get("7"))) {
                // 内部サービスコードを初期化
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // 外泊にあたるサービスコードを追加
            putSystemServiceCodeItem(sysSvcCdItems, "Z6300");

            // 介護職員処遇改善を返却
            switch (_17) {
            case 6:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6110");//2017.04
                break;
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2015.04
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
                if (this._1510123 <= 0) {
                    // 食費が0円以下の場合
                    // 該当レコードを削除する。
                    al.remove(i);
                    // 削除したためインデックスを1つ戻す。
                    i--;
                } else {
                    // 食費が0円以下でない場合
                    // 食費を業務から渡された値で上書きする。
                    mp.put("SERVICE_UNIT", new Integer(this._1510123));
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
            } else if (SERVICE_CODE_NEW_TASHO_ROOM.equals(val)) {
                // 多床室（新）のレコード
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
