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
 * 介護医療院
 * 
 * @since V8.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_15511_201804 extends Qkan10011_ServiceUnitGetter {
    private int _1550137 = 0;

    private final String PATH_UNIT_ROOM = "1550122";
    private final String PATH_UNIT_SEMI_ROOM = "1550123";
    private final String PATH_NORMAL_ROOM = "1550124";
    private final String PATH_TASHO_ROOM = "1550125";

    public String getServiceName() {
        return "介護医療院";
    }

    public String getServiceCodeKind() {
        return "55";
    }

    public String getSystemServiceKindDetail() {
        return "15511";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================
        
        
        // 1550101 施設区分
        int _1550101 = getIntValue(map, "1550101");

        // 1550102 人員配置区分（I型）
        int _1550102 = getIntValue(map, "1550102", 1);
        
        // 1550103 人員配置区分（II型）
        int _1550103 = getIntValue(map, "1550103");
        
        // 1550104 人員配置区分（特別）
        int _1550104 = getIntValue(map, "1550104");
        

        // 1550105 病室区分(従来型)
        int _1550105 = getIntValue(map, "1550105");

        // 1550106 病室区分(ユニット型)
        int _1550106 = getIntValue(map, "1550106");

        // 病室区分
        int byoshitsu = 1;
        switch (_1550101) {
        case 1:
        case 2:
        case 3:
            byoshitsu = convertByoshitsuKbn(_1550105, false);
            break;
        case 4:
        case 5:
        case 6:
            byoshitsu = convertByoshitsuKbn(_1550106, true);
            break;
        }

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1550107 夜間勤務条件基準
        int _1550107 = getIntValue(map, "1550107");

        // 1550128 人員減算
        int _1550128 = getIntValue(map, "1550128");

        // 1550108 ユニットケアの整備
        int _1550108 = getIntValue(map, "1550108");
        
        // 1550109 身体拘束廃止未実施減算
        int _1550109 = getIntValue(map, "1550109");

        // 1550110 療養環境減算（廊下）
        int _1550110 = getIntValue(map, "1550110");
        
        // 1550111 療養環境減算（療養室）
        int _1550111 = getIntValue(map, "1550111");

        // 1550112 夜間勤務等看護加算
        int _1550112 = getIntValue(map, "1550112");

        // 1550113 若年性認知症患者受入加算
        int _1550113 = getIntValue(map, "1550113");

        // 1550114 外泊加算
        int _1550114 = getIntValue(map, "1550114");
        
        // 1550115 試行的退所サービス費
        int _1550115 = getIntValue(map, "1550115");

        // 1550116 他科受診加算
        int _1550116 = getIntValue(map, "1550116");

        // 1550117 初期加算
        int _1550117 = getIntValue(map, "1550117");
        
        // 1550118 再入所時栄養連携加算
        int _1550118 = getIntValue(map, "1550118");
        
        // 1550119 栄養マネジメント加算
        int _1550119 = getIntValue(map, "1550119");
        
        // 1550120 低栄養リスク改善加算
        int _1550120 = getIntValue(map, "1550120");
        
        // 1550121 経口移行加算
        int _1550121 = getIntValue(map, "1550121");

        // 1550122 経口維持加算I
        int _1550122 = getIntValue(map, "1550122");
        
        // 1550123 経口維持加算II
        int _1550123 = getIntValue(map, "1550123");
        
        // 1550124 口腔衛生管理体制加算
        int _1550124 = getIntValue(map, "1550124", 1);

        // 1550125 口腔衛生管理加算
        int _1550125 = getIntValue(map, "1550125");
        
        // 1550126 療養食加算
        int _1550126 = getIntValue(map, "1550126");
        
        // 1550127 在宅復帰支援機能加算
        int _1550127 = getIntValue(map, "1550127");
        
        // 3020109 退所(院)前訪問指導加算
        int _3020109 = getIntValue(map, "3020109", 1);

        // 3020110 退所(院)後訪問指導加算
        int _3020110 = getIntValue(map, "3020110", 1);
        
        // 3020105 退所時指導加算
        int _3020105 = getIntValue(map, "3020105");

        // 3020106 退所時情報提供加算
        int _3020106 = getIntValue(map, "3020106");

        // 3020107 退所前連携加算
        int _3020107 = getIntValue(map, "3020107");

        // 3020108 訪問看護指示加算
        int _3020108 = getIntValue(map, "3020108");

        // 1550129 緊急時治療管理
        int _1550129 = getIntValue(map, "1550129");

        // 1550130 認知症専門ケア加算
        int _1550130 = getIntValue(map, "1550130");

        // 1550131 認知症行動・心理症状緊急対応加算
        int _1550131 = getIntValue(map, "1550131", 1);
        
        // 1550132 重度認知症疾患療養体制加算
        int _1550132 = getIntValue(map, "1550132");
        
        // 1550133 移行定着支援加算
        int _1550133 = getIntValue(map, "1550133");
        
        // 1550134 排せつ支援加算
        int _1550134 = getIntValue(map, "1550134");
        
        // 1550135 サービス提供体制強化加算
        int _1550135 = getIntValue(map, "1550135");
        
        // 1550136 食事提供
        int _1550136 = getIntValue(map, "1550136");

        // 1550137 食費
        this._1550137 = getIntValue(map, "1550137");


        // 単独加算
        int _9 = getIntValue(map, "9");

        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 単独加算のみ---------------------------------------------------------------
        // 単独加算サービス
        if (_9 == 2) {

            // 退所(院)後訪問指導加算
            if (_3020110 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6507");
            }

            // 介護職員処遇改善を返却
            switch (_17) {
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

            return sysSvcCdItems;
        }

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設区分
        sb.append(CODE_CHAR[_1550101]);

        // 人員配置区分（I型）
        if (_1550101 == 1 || _1550101 == 4 || _1550101 == 5) {
        	 sb.append(CODE_CHAR[_1550102]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // 人員配置区分（II型）
        if (_1550101 == 2) {
        	sb.append(CODE_CHAR[_1550103]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // 人員配置区分（特別）
        if (_1550101 == 3 || _1550101 == 6) {
        	sb.append(CODE_CHAR[_1550104]);
        } else {
        	sb.append(DEFAULT_CHAR);
        }
        
        // 病室区分(従来型個室/)
        sb.append(CODE_CHAR[_1550105]);

        // 病室区分(ユニット型個室/ユニット型個室的多床室)
        sb.append(CODE_CHAR[_1550106]);

        // 要介護度
        sb.append(CODE_CHAR[_1]);

        // 夜間勤務条件基準
        sb.append(CODE_CHAR[_1550107]);

        // 人員減算
        sb.append(CODE_CHAR[_1550128]);

        // ユニットケアの整備
        switch (_1550101) {
        case 1: // 個室・多床室
        case 2:
        case 3:
            sb.append(DEFAULT_CHAR);
            break;
        case 4: // ユニット型
        case 5:
        case 6:
            // 1-未整備 2-整備
            if (_1550108 > 1) {
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
        if (_1550109 > 1) {
            StringBuilder sb1 = new StringBuilder();
            // プレフィックス
            sb1.append(SYSTEM_SERVICE_CODE_PREFIX_SK);
            // 施設区分
            sb1.append(CODE_CHAR[_1550101]);
            // 人員配置区分（I型）
            if (_1550101 == 1 || _1550101 == 4 || _1550101 == 5) {
            	 sb1.append(CODE_CHAR[_1550102]);
            } else {
            	sb1.append(DEFAULT_CHAR);
            }
            // 人員配置区分（II型）
            if (_1550101 == 2) {
            	sb1.append(CODE_CHAR[_1550103]);
            } else {
            	sb1.append(DEFAULT_CHAR);
            }
            // 人員配置区分（特別）
            if (_1550101 == 3 || _1550101 == 6) {
            	sb1.append(CODE_CHAR[_1550104]);
            } else {
            	sb1.append(DEFAULT_CHAR);
            }
            // 病室区分(従来型個室/多床室)
            sb1.append(CODE_CHAR[_1550105]);
            // 病室区分(ユニット型個室/ユニット型個室的多床室)
            sb1.append(CODE_CHAR[_1550106]);
            // 要介護度
            sb1.append(CODE_CHAR[_1]);
            putSystemServiceCodeItem(sysSvcCdItems, sb1.toString());
        }
        
        // 療養環境減算（廊下）
        switch (_1550110) {
        // 療養型療養環境減算１
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6601");
            break;
        }
        
        // 療養環境減算（療養室）
        switch (_1550111) {
        // 療養型療養環境減算２
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6603");
            break;
        }

        // 夜間勤務等看護加算
        switch (_1550112) {
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
        
        // 若年性認知症入所者受入加算
        if (_1550113 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }

        // 外泊加算
        if (_1550114 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6300");
        }

        // 他科受診加算
        if (_1550116 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6831");
        }

        // 初期加算
        if (_1550117 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6400");
        }

        // 再入所時栄養連携加算
        if (_1550118 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6453");
        }
        
        // 栄養マネジメント加算
        if (_1550119 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6273");
        }
                
        // 低栄養リスク改善加算
        if (_1550120 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6854");
        }

        // 経口移行加算
        if (_1550121 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6274");
        }
        
        // 経口維持加算
        if (_1550122 > 1) {
        	// 経口維持加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6280");
        }
        if (_1550123 > 1) {
        	// 経口維持加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6281");
        }
        
        // 口腔衛生管理体制加算
        if (_1550124 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6122");
        }
        
        // 口腔衛生管理加算
        if (_1550125 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6123");
        }
        
        // 療養食加算
        switch (_1550126) {
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
        
        // 在宅復帰支援機能加算
        if (_1550127 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6278");
        }
        
        
        // 退所(院)前訪問指導加算
        if (_3020109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6501");
        }

        // 退所(院)後訪問指導加算
        if (_3020110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6507");
        }

        // 退所時指導加算
        if (_3020105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6502");
        }

        // 退所時情報提供加算
        if (_3020106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6504");
        }

        // 退所前連携加算
        if (_3020107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6505");
        }

        // 訪問看護指示加算
        if (_3020108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6503");
        }

        // 緊急時治療管理
        if (_1550129 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6000");
        }

        switch (_1550130) {
        case 2:
            // 認知症専門ケア加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6133");
            break;
        case 3:
            // 認知症専門ケア加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6134");
            break;
        }

        // 認知症行動・心理症状緊急対応加算
        if (_1550131 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6121");
        }
        
        // 重度認知症疾患療養体制加算        
        switch (_1550132) {
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

        // 移行定着支援加算
        if (_1550133 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6451");
        }
        
        // 排せつ支援加算
        if (_1550134 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6357");
        }
        
        
        switch (_1550135) {
        case 5:
        	// サービス提供体制加算Iイ型
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");
            break;
        case 2:
            // サービス提供体制加算Iロ型
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
        switch (_17) {
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

            // 2006/07/14 療養型対応
            // 試行的退院サービスの場合は食費を算定
            if (_1550115 > 1) {
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }

            // 食事提供
            if (_1550136 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, SERVICE_CODE_SHOKUHI);
            }

            // 外泊加算
            if (_1550114 > 1) {
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // 滞在費 --------
            putSystemServiceCodeItem(sysSvcCdItems,
                    getSystemServiceCodeOfRoom(byoshitsu));
        }// チェックがついていない場合は何も返さない

        // 他科受診があった場合は一律他科受信のコードを返す
        // 念のため外泊より優先する。
        if (_1550116 > 1) {
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
                if (!"Z6273".equals(tempItem)
                        && !SERVICE_CODE_SHOKUHI.equals(tempItem)
                        && !SERVICE_CODE_NORMAL_ROOM.equals(tempItem)
                        && !SERVICE_CODE_TASHO_ROOM.equals(tempItem)
                        && !SERVICE_CODE_UNIT_ROOM.equals(tempItem)
                        && !SERVICE_CODE_UNIT_SEMI_ROOM.equals(tempItem)
                        && !"Z6274".equals(tempItem)
                        && !"Z6275".equals(tempItem)
                        && !"Z6280".equals(tempItem)
                        && !"Z6281".equals(tempItem)) {
                    sysSvcCdItems.remove(i);
                }
            }

            // 他科受診にあたるサービスコードを追加
            putSystemServiceCodeItem(sysSvcCdItems, "Z6831");

            // 介護職員処遇改善を返却
            switch (_17) {
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

            // 値を返す
            return sysSvcCdItems;

        }

        // 外泊がありだった場合は一律外泊のコードを返す
        if (_1550114 > 1) {
            // 特定入所者である場合はホテルコストを追加する
            if (new Integer(1).equals(map.get("7")) || "1".equals(map.get("7"))) {
                // 内部サービスコードを初期化
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // 外泊にあたるサービスコードを追加
            putSystemServiceCodeItem(sysSvcCdItems, "Z6300");

            // 介護職員処遇改善を返却
            switch (_17) {
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

            // 値を返す
            return sysSvcCdItems;
        }

        // 2006/07/05 療養型対応
        // 1530119 試行的退院サービス費
        // 試行的退院がありだった場合は一律試行的退院のコードを返す
        if (_1550115 > 1) {
            // 特定入所者である場合は初期化を行わない　※滞在費を返す必要があるため
            if ("1".equals(map.get("7")) || new Integer(1).equals(map.get("7"))) {
                // 内部サービスコードを初期化
                sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            }
            // 試行的退院にあたるコードを追加
            putSystemServiceCodeItem(sysSvcCdItems, "Z6358");

            // 介護職員処遇改善を返却
            switch (_17) {
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
                if (this._1550137 <= 0) {
                    // 食費が0円以下の場合
                    // 該当レコードを削除する。
                    al.remove(i);
                    // 削除したためインデックスを1つ戻す。
                    i--;
                } else {
                    // 食費が0円以下でない場合
                    // 食費を業務から渡された値で上書きする。
                    mp.put("SERVICE_UNIT", new Integer(this._1550137));
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
