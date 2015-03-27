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
 * 地域密着型介護福祉施設
 * 
 * @since V7.0.0
 * @author Shinobu Hitaka
 * 
 */
public class SC_15411_201504 extends Qkan10011_ServiceUnitGetter {
    private int _1540121 = 0;

    private final String PATH_UNIT_ROOM = "1540121";
    private final String PATH_UNIT_SEMI_ROOM = "1540122";
    private final String PATH_NORMAL_ROOM = "1540123";
    private final String PATH_TASHO_ROOM = "1540124";

    private int byoshitsu = 0;

    public String getServiceName() {
        return "地域密着型介護福祉施設";
    }

    public String getServiceCodeKind() {
        return "54";
    }

    public String getSystemServiceKindDetail() {
        return "15411 ";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================

        // 1540101 施設区分 1-介護福祉施設 3-ユニット型介護福祉施設
        int _1540101 = getIntValue(map, "1540101");

        // 1540102 経過的地域密着サービス
        int _1540102 = getIntValue(map, "1540102");

        // 1540128 旧措置入所者区分
        int _8 = getIntValue(map, "8");

        // 1540103 病室区分(従来型) 1-従来型個室 2-多床室
        int _1540103 = getIntValue(map, "1540103");

        // 1540104 病室区分(ユニット型) 1-ユニット型個室 2-ユニット型準個室
        int _1540104 = getIntValue(map, "1540104");

        // 病室を判定
        if (_1540101 > 1) {
            // ユニット型
            byoshitsu = convertByoshitsuKbn(_1540104, true);
        } else {
            // 通常
            byoshitsu = convertByoshitsuKbn(_1540103, false);
        }

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1540107 夜間勤務条件基準 1-満たしている 2-満たしていない
        int _1540107 = getIntValue(map, "1540107");

        // 1540119 人員減算 1-なし 2-定員超過 3-看護・介護職員又は介護支援専門員不足
        int _1540119 = getIntValue(map, "1540119");

        // 1540105 ユニットケアの整備 1-未整備 2-整備
        int _1540105 = getIntValue(map, "1540105");

        // 1540106 準ユニットケア加算 1-なし 2-あり
        int _1540106 = getIntValue(map, "1540106");

        // 1540108 個別機能訓練指導加算 1-なし 2-あり
        int _1540108 = getIntValue(map, "1540108");

        // 1540109 医師常勤加算 1-なし 2-あり
        int _1540109 = getIntValue(map, "1540109");

        // 1540110 精神科医指導加算 1-なし 2-あり
        int _1540110 = getIntValue(map, "1540110");

        // 1540111 障害者生活援助員常勤加算 1-なし 2-あり
        int _1540111 = getIntValue(map, "1540111");

        // 1540123 身体拘束廃止未実施減算 1-なし 2-あり
        int _1540123 = getIntValue(map, "1540123");

        // 1540112 外泊加算 1-なし 2-あり
        int _1540112 = getIntValue(map, "1540112");

        // 1540113 初期加算 1-なし 2-あり
        int _1540113 = getIntValue(map, "1540113");

        // 3020102 退所時相談援助加算
        int _3020102 = getIntValue(map, "3020102");

        // 3020103 退所前連携加算
        int _3020103 = getIntValue(map, "3020103");

        // 1540115 栄養マネジメント加算 1-なし 2-あり
        int _1540115 = getIntValue(map, "1540115");

        // 1540116 経口移行加算 1-なし 2-あり
        int _1540116 = getIntValue(map, "1540116");

        // 1540117 経口維持加算Ⅰ
        int _1540117 = getIntValue(map, "1540117");

        // 1540141 経口維持加算Ⅱ 2015.04
        int _1540141 = getIntValue(map, "1540141");

        // 1540118 療養食加算 1-なし 2-あり
        int _1540118 = getIntValue(map, "1540118");

        // 1540134 看取り介護加算 1-なし 2-死亡日以前4日以上30日以下 3-死亡日以前2日又は3日 4-死亡日
        int _1540134 = getIntValue(map, "1540134");

        // 1540125 在宅復帰支援機能加算 1-なし 2-あり
        int _1540125 = getIntValue(map, "1540125");

        // 1540126 在宅・入所相互利用加算 1-なし 2-あり
        int _1540126 = getIntValue(map, "1540126");

        // 1540127 小規模拠点集合型施設加算 1-なし 2-あり
        int _1540127 = getIntValue(map, "1540127");

        // 1540120 食事提供 1-なし 2-三食 3-朝 4-昼 5-夜 6-朝昼 7-昼夜 8-夜朝
        int _1540120 = getIntValue(map, "1540120");

        // 1540121 食費
        this._1540121 = getIntValue(map, "1540121");

        // 1540129 日常生活継続支援加算
        int _1540129 = getIntValue(map, "1540129");

        // 1540137 看護体制加算Ⅰ
        int _1540137 = getIntValue(map, "1540137");

        // 1540138 看護体制加算Ⅱ
        int _1540138 = getIntValue(map, "1540138");

        // 1540131 夜勤職員配置加算
        int _1540131 = getIntValue(map, "1540131");

        // 1540132 若年性認知症入所者受入加算
        int _1540132 = getIntValue(map, "1540132");

        // 1540133 口腔衛生管理加算
        int _1540133 = getIntValue(map, "1540133");

        // 1540135 認知症専門ケア加算
        int _1540135 = getIntValue(map, "1540135");

        // 1540136 サービス提供体制強化加算
        int _1540136 = getIntValue(map, "1540136");

        // 2006/05/15 予防時対応
        // 単独加算
        int _9 = getIntValue(map, "9");

        // 3020109 退所前訪問指導加算
        int _3020109 = getIntValue(map, "3020109", 1);

        // 3020110 退所後訪問指導加算
        int _3020110 = getIntValue(map, "3020110", 1);

        // 1540139 認知症行動・心理症状緊急対応加算
        int _1540139 = getIntValue(map, "1540139", 1);
        
        // 1540140 口腔衛生管理体制加算
        int _1540140 = getIntValue(map, "1540140", 1);

        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 2006/05/15 予防時対応
        // 単独加算のみ---------------------------------------------------------------
        // 単独加算サービス
        if (_9 == 2) {
            
            // 退所後訪問指導加算
            if (_3020110 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6504");
            }
            
            // 看護体制加算の併算定と合わせて修正
            // 看取り介護加算
            switch (_1540134) {
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6276");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6277");
                break;
            case 4:
                // 6283　地福祉施設看取り介護加算３
                putSystemServiceCodeItem(sysSvcCdItems, "Z6283");
                break;
            }
            
            // 介護職員処遇改善を返却
            switch (_17) {
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

        // 施設区分 1-介護福祉施設 3-ユニット型介護福祉施設
        sb.append(CODE_CHAR[_1540101]);

        // 経過的地域密着サービス
        sb.append(CODE_CHAR[_1540102]);

        // 旧措置入所者区分
        sb.append(CODE_CHAR[_8]);
        
        // 病室区分(従来型個室/多床室)
        sb.append(CODE_CHAR[_1540103]);
        
        // 病室区分(ユニット型個室/ユニット型準個室)
        sb.append(CODE_CHAR[_1540104]);
        
        // 要介護度
        sb.append(CODE_CHAR[_1]);

        // 夜間勤務条件基準 1-満たしている 2-満たしていない
        sb.append(CODE_CHAR[_1540107]);

        // 人員減算 1-なし 2-定員超過 3-看護・介護職員又は介護支援専門員不足
        sb.append(CODE_CHAR[_1540119]);

        // ユニットケアの整備
        switch (_1540101) {
        case 1: //介護福祉施設
            sb.append(DEFAULT_CHAR);
            break;
        case 2: //ユニット型介護福祉施設
            // 1-未整備 2-整備
            if (_1540105 > 1) {
                sb.append(DEFAULT_CHAR);
            } else {
                sb.append(CODE_CHAR[2]);
            }
            break;
        }

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        
        // 6132　地福祉施設日常生活継続支援加算
        if (_1540129 > 1) {
        	
            // 施設等の区分
            switch (_1540101) {
            
            // 介護福祉施設
            case 1:
                // 6132　地福祉施設日常生活継続支援加算１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6132");//2015.04
                break;
                
            // ユニット型介護福祉施設
            case 2:
                // 6135　地福祉施設日常生活継続支援加算２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6135");//2015.04
                break;
            }
        }
        
        // 看護体制加算Ⅰが選択されている場合
        if (_1540137 > 1) {
            if (_1540102 == 2) {
                // 6114　地福祉施設看護体制加算I２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6114");
            } else {
                // 6113　地福祉施設看護体制加算I１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6113");
            }
        }
        // 看護体制加算Ⅱが選択されている場合
        if (_1540138 > 1) {
            if (_1540102 == 2) {
                // 6116　地福祉施設看護体制加算II２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6116");
            } else {
                // 6115　地福祉施設看護体制加算II１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6115");
            }
        }
        
        // 夜勤職員配置加算
        if (_1540131 > 1) {
            
            // 施設等の区分
            switch (_1540101) {
            
            // 介護福祉施設
            case 1:
                // 経過的要介護
                if (_1540102 == 2) {
                    // 6118　地福祉施設夜勤職員配置加算I２
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6118");
                } else {
                    // 6117　地福祉施設夜勤職員配置加算I１
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6117");
                }
                break;
                
            // ユニット型介護福祉施設
            case 2:
                // 経過的要介護
                if (_1540102 == 2) {
                    // 6120　地福祉施設夜勤職員配置加算II２
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6120");
                } else {
                    // 6119　地福祉施設夜勤職員配置加算II１
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6119");
                }
                break;
            }
        }
        
        // 準ユニットケア加算 1-なし 2-あり
        if (_1540106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6002");
        }
        
        // 個別機能訓練指導加算 1-なし 2-あり
        if (_1540108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6003");
        }
        
        // 6109　地福祉施設若年性認知症受入加算
        if (_1540132 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // 医師常勤加算 1-なし 2-あり
        if (_1540109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");
        }
        
        // 精神科医指導加算 1-なし 2-あり
        if (_1540110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6200");
        }
        
        // 障害者生活援助員常勤加算 1-なし 2-あり
        if (_1540111 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6250");
        }
        
        // 身体拘束廃止未実施減算 1-なし 2-あり
        if (_1540123 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6304");
        }
        
        // 外泊加算 1-なし 2-あり
        if (_1540112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6300");
        }
        
        // 初期加算 1-なし 2-あり
        if (_1540113 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6400");
        }
        
        // 3020109 退所前訪問指導加算
        if (_3020109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6501");
        }
        
        // 3020110 退所後訪問指導加算
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
        
        // 栄養マネジメント加算 1-なし 2-あり
        if (_1540115 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6273");
        }
        
        // 経口移行加算 1-なし 2-あり
        if (_1540116 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6274");
        }
        
        // 経口維持加算Ⅰ型
        if (_1540117 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6281");
        }
        
        // 経口維持加算Ⅱ型
        if (_1540141 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6282");
        }
        
        // 口腔衛生管理体制加算
        if (_1540140 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6122");
        }
        
        // 口腔衛生管理加算
        if (_1540133 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6123");
        }
        
        // 療養食加算 1-なし 2-あり
        if (_1540118 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6275");
        }
        
        // 看取り介護加算 1-なし 2-死亡日以前4日以上30日以下 3-死亡日以前2日又は3日 4-死亡日
        switch (_1540134) {
        case 2:
            // 地福祉施設看取り介護加算１
            putSystemServiceCodeItem(sysSvcCdItems, "Z6276");
            break;
        case 3:
            // 地福祉施設看取り介護加算２
            putSystemServiceCodeItem(sysSvcCdItems, "Z6277");
            break;
        case 4:
            // 6283　地福祉施設看取り介護加算３
            putSystemServiceCodeItem(sysSvcCdItems, "Z6283");
            break;
        }
        
        // 在宅復帰支援機能加算 1-なし 2-あり
        if (_1540125 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6278");
        }
        
        // 在宅・入所相互利用加算 1-なし 2-あり
        if (_1540126 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6279");
        }
        
        // 小規模拠点集合型施設加算 1-なし 2-あり
        if (_1540127 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6280");
        }
        
        switch (_1540135) {
        case 2:
            // 6133　地福祉施設認知症専門ケア加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6133");
            break;
        case 3:
            // 6134　地福祉施設認知症専門ケア加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6134");
            break;
        }

        // 1540139 認知症行動・心理症状緊急対応加算
        if (_1540139 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6121");
        }
        
        
        switch (_1540136) {
        case 5:
            // 6104　地福祉施設サービス提供体制加算Iイ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");//2015.04
            break;
        case 2:
            // 6101　地福祉施設サービス提供体制加算Iロ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // 6102　地福祉施設サービス提供体制加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
            // 6103　地福祉施設サービス提供体制加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }


        // 介護職員処遇改善を返却
        switch (_17) {
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
            // 食事提供 1-なし 2-三食 3-朝 4-昼 5-夜 6-朝昼 7-昼夜 8-夜朝
            if (_1540120 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }
            // 外泊加算ありである場合初期化
            if (_1540112 > 1) {
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // 滞在費 --------
            putSystemServiceCodeItem(sysSvcCdItems,
                    getSystemServiceCodeOfRoom(byoshitsu));
        }

        // 外泊がありだった場合は一律外泊のコードを返す
        if (_1540112 > 1) {
            // 特定入所者である場合は初期化を回避
            if (new Integer(1).equals(map.get("7")) || "1".equals(map.get("7"))) {
                // 内部サービスコードを初期化
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // 外泊にあたるサービスコードを追加
            putSystemServiceCodeItem(sysSvcCdItems, "Z6300");
            
            // 介護職員処遇改善を返却
            switch (_17) {
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
                if (this._1540121 <= 0) {
                    // 食費が0円以下の場合
                    // 該当レコードを削除する。
                    al.remove(i);
                    // 削除したためインデックスを1つ戻す。
                    i--;
                } else {
                    // 食費が0円以下でない場合
                    // 食費を業務から渡された値で上書きする。
                    mp.put("SERVICE_UNIT", new Integer(this._1540121));
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
