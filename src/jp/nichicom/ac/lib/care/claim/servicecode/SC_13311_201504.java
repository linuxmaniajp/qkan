package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.util.VRMap;

public class SC_13311_201504 extends Qkan10011_ServiceUnitGetter {
    private int baseUnit = 0;// 福祉用具単位用変数
    private int _1330107 = 0;// サービス種類確定用

    public String getServiceName() {
        return "特定施設入居者生活介護";
    }

    public String getServiceCodeKind() {
        return "33";
    }

    public String getSystemServiceKindDetail() {
        return "13311";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================

        // 1330105 施設区分
        int _1330105 = getIntValue(map, "1330105");

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1330104 人員減算
        int _1330104 = getIntValue(map, "1330104");

        // 1330103 個別機能訓練指導加算
        int _1330103 = getIntValue(map, "1330103", 1);

        // 1330106 夜間介護体制加算
        int _1330106 = getIntValue(map, "1330106", 1);

        // 1330124 医療機関連携加算
        int _1330124 = getIntValue(map, "1330124", 1);

        // 1330125 障害者等支援加算
        int _1330125 = getIntValue(map, "1330125", 1);

        // 1330107 外部サービス
        _1330107 = getIntValue(map, "1330107", 1);

        // 1330128 看取り介護加算
        int _1330128 = getIntValue(map, "1330128", 1);
        
        // 1330130 認知症専門ケア加算
        int _1330130 = getIntValue(map, "1330130", 1);
        
        // 1330131 サービス提供体制強化加算
        int _1330131 = getIntValue(map, "1330131", 1);

        // 単独加算
        int _9 = getIntValue(map, "9");
        
        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        
        // 単独加算のみ---------------------------------------------------------------
        // 単独加算サービス
        if (_9 == 2) {
            
            // 看取り介護加算
            switch (_1330128) {
            case 2: // 特定施設看取り介護加算１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6125");
                break;
            case 3: // 特定施設看取り介護加算２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6126");
                break;
            case 4: // 特定施設看取り介護加算３
                putSystemServiceCodeItem(sysSvcCdItems, "Z6127");
                break;
            }
            
            // 介護職員処遇改善を返却
            switch (_17) {
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6131");//2015.04
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6128");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6129");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6130");
                break;
            }

            return sysSvcCdItems;
        }
        
        // ===========================================================================
        // 基礎単位のみを返す
        // なしを選択した場合
        if (_1330107 == 9) {
            // 人員減算の値をチェック
            if (_1330104 == 2) {
                // 人員減算ありだった場合
                putSystemServiceCodeItem(sysSvcCdItems, "212");
            } else {
                // 人員減算なしだった場合
                putSystemServiceCodeItem(sysSvcCdItems, "211");
            }

            // 6124 特定施設障害者等支援加算
            if (_1330125 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6124");
            }

            // 認知症専門ケア加算
            switch (_1330130) {
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6133");//2015.04
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6134");//2015.04
                break;
            }
            
            // サービス提供体制加算
            switch (_1330131) {
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6101");//2015.04
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6102");//2015.04
                break;
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6103");//2015.04
                break;
            }
            
            // 介護職員処遇改善を返却
            switch (_17) {
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6131");//2015.04
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6128");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6129");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6130");
                break;
            }
            return sysSvcCdItems;

        }

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設区分
        sb.append(CODE_CHAR[_1330105]);

        if (_1330105 == 1) { // 特定施設入居者生活介護費
            // 要介護度
            sb.append(CODE_CHAR[_1]);

        } else { // 外部サービス利用型特定施設入居者生活介護費
            // 要介護度
            sb.append(DEFAULT_CHAR);

        }

        // 人員減算
        sb.append(CODE_CHAR[_1330104]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        // 6003 特定施設個別機能訓練加算
        if (_1330103 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6003");
        }

        // 夜間介護体制加算
        if (_1330106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z1160");
        }

        // 6123 特定施設医療機関連携加算
        if (_1330124 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6123");
        }

        // 看取り介護加算
        switch (_1330128) {
        case 2: // 特定施設看取り介護加算１
            putSystemServiceCodeItem(sysSvcCdItems, "Z6125");
            break;
        case 3: // 特定施設看取り介護加算２
            putSystemServiceCodeItem(sysSvcCdItems, "Z6126");
            break;
        case 4: // 特定施設看取り介護加算３
            putSystemServiceCodeItem(sysSvcCdItems, "Z6127");
            break;
        }

        // 認知症専門ケア加算
        switch (_1330130) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6133");//2015.04
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6134");//2015.04
            break;
        }
        
        // サービス提供体制加算
        switch (_1330131) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");//2015.04
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");//2015.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");//2015.04
            break;
        }
        
        // 6124 特定施設障害者等支援加算
        if (_1330125 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6124");
        }

        // 介護職員処遇改善を返却
        switch (_17) {
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6131");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6128");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6129");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6130");
            break;
        }

        // 外部サービス
        // ==================================================================
        if (_1330105 == 2) {
            switch (_1330107) {
            case 1: // 訪問介護
                getSystemServiceCodeItemHomonKaigo(map, sysSvcCdItems);
                break;
            case 2: // 訪問入浴介護
                getSystemServiceCodeItemHomonNyuyokuKaigo(map, sysSvcCdItems);
                break;
            case 3: // 訪問看護
                getSystemServiceCodeItemHomonKango(map, sysSvcCdItems);
                break;
            case 4: // 訪問リハビリテーション
                getSystemServiceCodeItemHomonReha(map, sysSvcCdItems);
                break;
            case 5: // 通所介護
                getSystemServiceCodeItemTushoKaigo(map, sysSvcCdItems);
                break;
            case 6: // 通所リハビリテーション
                getSystemServiceCodeItemTushoReha(map, sysSvcCdItems);
                break;
            case 7: // 福祉用具貸与
                getSystemServiceCodeItemFukushiYoguTaiyo(map, sysSvcCdItems);
                break;
            case 8: // 認知症対応型通所介護
                getSystemServiceCodeItemNinchishoTaiogataTushoKaigo(map,
                        sysSvcCdItems);
                break;
            }
        }

        return sysSvcCdItems;
    }

    /**
     * 外部サービス・訪問介護
     * 
     * @param map
     * @param sysSvcCdItems
     * @return
     */
    public ArrayList<HashMap<String, String>> getSystemServiceCodeItemHomonKaigo(
            Map<String, String> map,
            ArrayList<HashMap<String, String>> sysSvcCdItems) {
        // パラメータ抽出
        // =========================================================================
        // 1330105 施設区分
        int _1330105 = getIntValue(map, "1330105");

        // 1330107 外部サービス
        int _1330107 = getIntValue(map, "1330107");

        // 1330108 訪問介護-種別
        int _1330108 = getIntValue(map, "1330108");

        // 1330109 訪問介護-時間区分
        int _1330109 = getIntValue(map, "1330109");

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設区分
        sb.append(CODE_CHAR[_1330105]);

        // 外部サービス
        sb.append(CODE_CHAR[_1330107]);

        // 訪問介護-種別
        sb.append(CODE_CHAR[_1330108]);

        // 訪問介護-時間区分
        // 種別が通院等乗降介助だった場合
        // 時間区分を除外した形で返す
        if (_1330108 == 3) {
            sb.append(DEFAULT_CHAR);

        } else if (_1330108 == 2) {
            // 生活援助だった場合
            // 時間区分が1時間以上30分未満よりも大きい値を選択していた場合
            if (_1330109 > 6) {
                // 1時間15分以上(index:6)の選択とする
                sb.append(CODE_CHAR[6]);
            } else {
                // 追加する。
                sb.append(CODE_CHAR[_1330109]);
            }
        } else {
            sb.append(CODE_CHAR[_1330109]);
        }
        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        return sysSvcCdItems;
    }

    /**
     * 外部サービス・訪問入浴介護
     * 
     * @param map
     * @return
     */
    public ArrayList<HashMap<String, String>> getSystemServiceCodeItemHomonNyuyokuKaigo(
            Map<String, String> map,
            ArrayList<HashMap<String, String>> sysSvcCdItems) {
        // パラメータ抽出
        // =========================================================================
        // 1330105 施設区分
        int _1330105 = getIntValue(map, "1330105");

        // 1330107 外部サービス
        int _1330107 = getIntValue(map, "1330107");

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();
        // 施設区分
        sb.append(CODE_CHAR[_1330105]);

        // 外部サービス
        sb.append(CODE_CHAR[_1330107]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        return sysSvcCdItems;
    }

    /**
     * 外部サービス・訪問看護
     * 
     * @param map
     * @param sysSvcCdItems
     * @return
     */
    public ArrayList<HashMap<String, String>> getSystemServiceCodeItemHomonKango(
            Map<String, String> map,
            ArrayList<HashMap<String, String>> sysSvcCdItems) {
        // パラメータ抽出
        // =========================================================================
        // 1330105 施設区分
        int _1330105 = getIntValue(map, "1330105");

        // 1330107 外部サービス
        int _1330107 = getIntValue(map, "1330107");

        // 1330110 訪問看護-施設区分 1-訪問看護ステーション 2-病院又は診療所
        int _1330110 = getIntValue(map, "1330110");

        // 1330112 訪問看護-時間区分 1-30分未満 2-30分以上1時間未満
        int _1330112 = getIntValue(map, "1330112");

        // 1330111 訪問看護-職員区分 1-なし 2-PT、OT、ST
        int _1330111 = getIntValue(map, "1330111");

        // 1330129 1日に2回を越えて実施 1-なし 2-あり
        int _1330129 = getIntValue(map, "1330129");
        
        // 1330132 看護職員区分
        int _1330132 = getIntValue(map, "1330132", 1);//2015.04

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設区分
        sb.append(CODE_CHAR[_1330105]);

        // 外部サービス
        sb.append(CODE_CHAR[_1330107]);

        // 訪問看護-施設区分 1-訪問看護ステーション 2-病院又は診療所
        sb.append(CODE_CHAR[_1330110]);

        // 訪問看護-時間区分
        sb.append(CODE_CHAR[_1330112]);

        // 訪問看護-職員区分 1-なし 2-PT、OT、ST
        sb.append(CODE_CHAR[_1330111]);

        // 1日に2回を越えて実施 1-なし 2-あり
        sb.append(CODE_CHAR[_1330129]);
        
        // 訪問看護-看護職員区分　1-正看等 2-准看
        sb.append(CODE_CHAR[_1330132]); //2015.04

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        return sysSvcCdItems;
    }

    /**
     * 外部サービス・訪問リハ
     * 
     * @param map
     * @param sysSvcCdItems
     * @return
     */
    public ArrayList<HashMap<String, String>> getSystemServiceCodeItemHomonReha(
            Map<String, String> map,
            ArrayList<HashMap<String, String>> sysSvcCdItems) {
        // パラメータ抽出
        // =========================================================================
        // 1330105 施設区分
        int _1330105 = getIntValue(map, "1330105");

        // 1330107 外部サービス
        int _1330107 = getIntValue(map, "1330107");

        // 1330113 訪問リハ-施設区分
        int _1330113 = getIntValue(map, "1330113");

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設区分
        sb.append(CODE_CHAR[_1330105]);

        // 外部サービス
        sb.append(CODE_CHAR[_1330107]);

        // 訪問リハ-施設区分
        sb.append(CODE_CHAR[_1330113]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        return sysSvcCdItems;
    }

    /**
     * 通所介護
     * 
     * @param map
     * @param sysSvcCdItems
     * @return
     */
    public ArrayList<HashMap<String, String>> getSystemServiceCodeItemTushoKaigo(
            Map<String, String> map,
            ArrayList<HashMap<String, String>> sysSvcCdItems) {
        // パラメータ抽出
        // =========================================================================
        // 1330105 施設区分
        int _1330105 = getIntValue(map, "1330105");

        // 1330107 外部サービス
        int _1330107 = getIntValue(map, "1330107");

        // 1330126 通所介護-施設区分 1-小規模事業所 2-通常規模事業所 3-大規模事業所 I 4-大規模事業所 II 5-療養通所
        int _1330126 = getIntValue(map, "1330126");

        // 1330115 通所介護-時間区分
        int _1330115 = getIntValue(map, "1330115");

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設区分
        sb.append(CODE_CHAR[_1330105]);

        // 外部サービス
        sb.append(CODE_CHAR[_1330107]);

        // 通所介護-施設区分 1-小規模事業所 2-通常規模事業所 3-大規模事業所 I 4-大規模事業所 II 5-療養通所
        sb.append(CODE_CHAR[_1330126]);

        // 通所介護-時間区分
        // 療養通所の場合
        if (_1330126 == 5) {
            sb.append(DEFAULT_CHAR);
            sb.append(CODE_CHAR[_1330115]);
        } else {
            sb.append(CODE_CHAR[_1330115]);
            sb.append(DEFAULT_CHAR);
        }

        // 要介護度
        if (_1330126 == 5) {
            // 療養通所の場合、要介護度は絡まない
            sb.append(DEFAULT_CHAR);
        } else {
            sb.append(CODE_CHAR[_1]);
        }

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        return sysSvcCdItems;
    }

    /**
     * 通所リハ
     * 
     * @param map
     * @param sysSvcCdItems
     * @return
     */
    public ArrayList<HashMap<String, String>> getSystemServiceCodeItemTushoReha(
            Map<String, String> map,
            ArrayList<HashMap<String, String>> sysSvcCdItems) {
        // パラメータ抽出
        // =========================================================================
        // 1330105 施設区分
        int _1330105 = getIntValue(map, "1330105");

        // 1330107 外部サービス
        int _1330107 = getIntValue(map, "1330107");

        // 1330127 通所リハ-施設区分 1-通常規模事業所 2-大規模事業所 I 3-大規模事業所 II
        int _1330127 = getIntValue(map, "1330127");

        // 1330117 通所リハ-時間区分
        int _1330117 = getIntValue(map, "1330117");

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設区分
        sb.append(CODE_CHAR[_1330105]);

        // 外部サービス
        sb.append(CODE_CHAR[_1330107]);

        // 通所リハ-施設区分 1-通常規模事業所 2-大規模事業所 I 3-大規模事業所 II
        sb.append(CODE_CHAR[_1330127]);

        // 通所リハ-時間区分
        sb.append(CODE_CHAR[_1330117]);

        // 要介護度
        sb.append(CODE_CHAR[_1]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        return sysSvcCdItems;
    }

    /**
     * 外部サービス・福祉用具貸与
     * 
     * @param map
     * @param sysSvcCdItems
     * @return
     */
    public ArrayList<HashMap<String, String>> getSystemServiceCodeItemFukushiYoguTaiyo(
            Map<String, String> map,
            ArrayList<HashMap<String, String>> sysSvcCdItems) {
        // パラメータ抽出
        // =========================================================================
        // 1330105 施設区分
        int _1330105 = getIntValue(map, "1330105");

        // 1330107 外部サービス
        int _1330107 = getIntValue(map, "1330107");

        // 1330118 福祉用具貸与-用具
        int _1330118 = getIntValue(map, "1330118");

        try {
            baseUnit = getIntValue(map, "1330119");
        } catch (Exception ex) {
            // 入力制限漏れがあったモジュールで作成したデータへの例外対応
            ACMessageBox
                    .show("特定施設入居者生活介護の外部サービス利用型(福祉用具貸与)の単位数に数字以外が入力されています。"
                            + ACConstants.LINE_SEPARATOR
                            + "不正な単位数のデータは計算されません。");
            return sysSvcCdItems;
        }
        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設区分
        sb.append(CODE_CHAR[_1330105]);

        // 外部サービス
        sb.append(CODE_CHAR[_1330107]);

        // 福祉用具貸与-用具
        sb.append(CODE_CHAR[_1330118]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        return sysSvcCdItems;
    }

    /**
     * 外部サービス・認知症対応型通所介護
     * 
     * @param map
     * @param sysSvcCdItems
     * @return
     */
    public ArrayList<HashMap<String, String>> getSystemServiceCodeItemNinchishoTaiogataTushoKaigo(
            Map<String, String> map,
            ArrayList<HashMap<String, String>> sysSvcCdItems) {
        // パラメータ抽出
        // =========================================================================
        // 1330105 施設区分
        int _1330105 = getIntValue(map, "1330105");

        // 1330107 外部サービス
        int _1330107 = getIntValue(map, "1330107");

        // 1330121 施設等の区分　1-Ⅰ型 2-Ⅱ型
        int _1330121 = getIntValue(map, "1330121");

        // 1330122 区分　1-単独型 2-併設型
        int _1330122 = getIntValue(map, "1330122");

        // 1330123 時間区分　1-2～3時間 2-3～4時間 3-4～6時間 4-6～8時間
        int _1330123 = getIntValue(map, "1330123");

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設区分
        sb.append(CODE_CHAR[_1330105]);

        // 外部サービス
        sb.append(CODE_CHAR[_1330107]);

        // 施設等の区分　1-Ⅰ型 2-Ⅱ型
        sb.append(CODE_CHAR[_1330121]);

        // 区分　1-単独型 2-併設型
        sb.append(CODE_CHAR[_1330122]);

        // 時間区分　1-2～3時間 2-3～4時間 3-4～6時間 4-6～8時間
        sb.append(CODE_CHAR[_1330123]);

        // 要介護度
        sb.append(CODE_CHAR[_1]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        return sysSvcCdItems;
    }

    /**
     * 福祉用具の単位数を返す
     */
    public ArrayList<VRMap> getServiceCode(Map<String, String> map,
            ACDBManager dbm) {
        ArrayList<VRMap> al = super.getServiceCode(map, dbm);
        if (_1330107 == 7) {
            Map<String, Integer> mp = null;
            // 上書き用のレコードが存在した場合は上書きを行う。
            if (al.size() > 1) {
                mp = (Map<String, Integer>) al.get(al.size() - 1);
                mp.put("SERVICE_UNIT", new Integer(this.baseUnit));
            }
        }
        return al;
    }

}
