package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.util.VRMap;

/**
 * 介護予防特定施設入居者生活介護
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_13511_201204 extends Qkan10011_ServiceUnitGetter {
    private int _1350101 = 0;// 施設等の区分
    private int _1 = 0;// 要介護度
    private int baseUnit = 0;// 福祉用具単位用変数
    private int _1350104 = 0;// サービス種類確定用

    public String getServiceName() {
        return "介護予防特定施設入居者生活介護";
    }

    public String getServiceCodeKind() {
        return "35";
    }

    public String getSystemServiceKindDetail() {
        return "13511";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================

        // 1350101 施設等の区分　1-特定施設入居者 2-外部サービス利用型
        _1350101 = getIntValue(map, "1350101", 1);

        // 1350102 個別機能訓練指導加算　1-なし 2-あり
        int _1350102 = getIntValue(map, "1350102", 1);

        // 1350103 人員減算　1-なし 2-看護・介護職員の不足
        int _1350103 = getIntValue(map, "1350103", 1);

        // 1350104 外部サービス　1-訪問介護 2-訪問入浴介護 3-訪問看護 4-訪問リハ 5-通所介護 6-通所リハ 7-福祉用具貸与
        // 8-認知症対応型通所介護
        _1350104 = getIntValue(map, "1350104", 1);

        // 1 要介護度
        _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1350127 医療機関連携加算
        int _1350127 = getIntValue(map, "1350127", 1);

        // 1350128 障害者等支援加算
        int _1350128 = getIntValue(map, "1350128", 1);

        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);
        
        // ===========================================================================
        // 基礎単位のみを返す
        // なしを選択した場合
        if (_1350104 == 9) {
            // 人員減算の値をチェック
            if (_1350103 == 2) {
                // 人員減算ありだった場合
                putSystemServiceCodeItem(sysSvcCdItems, "212");
            } else {
                // 人員減算なしだった場合
                putSystemServiceCodeItem(sysSvcCdItems, "211");
            }

            // 6124 予防特定施設障害者等支援加算
            if (_1350128 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6124");
            }
            
            // 介護職員処遇改善を返却
            switch (_17) {
            case 2:
                // 予防特定施設処遇改善加算I
                putSystemServiceCodeItem(sysSvcCdItems, "Z6128");
                break;
            case 3:
                // 予防特定施設処遇改善加算II
                putSystemServiceCodeItem(sysSvcCdItems, "Z6129");
                break;
            case 4:
                // 予防特定施設処遇改善加算III
                putSystemServiceCodeItem(sysSvcCdItems, "Z6130");
                break;
            }
            
            return sysSvcCdItems;
        }

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設等の区分　1-特定施設入居者 2-外部サービス利用型
        sb.append(CODE_CHAR[_1350101]);

        if (_1350101 == 1) { // 特定施設入居者生活介護費
            // 要介護度
            sb.append(CODE_CHAR[_1]);
            
        } else { // 外部サービス利用型特定施設入居者生活介護費
            // 要介護度
            sb.append(DEFAULT_CHAR);
            
        }

        // 人員減算　1-なし 2-看護・介護職員の不足
        sb.append(CODE_CHAR[_1350103]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        
        // 6003 予防特定施設個別機能訓練加算
        if (_1350102 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6003");
        }
        
        // 6123 予防特定施設医療機関連携加算
        if (_1350127 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6123");
        }
        
        // 6124 予防特定施設障害者等支援加算
        if (_1350128 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6124");
        }
        
        // 介護職員処遇改善を返却
        switch (_17) {
        case 2:
            // 予防特定施設処遇改善加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6128");
            break;
        case 3:
            // 予防特定施設処遇改善加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6129");
            break;
        case 4:
            // 予防特定施設処遇改善加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z6130");
            break;
        }

        // 外部サービス
        // ============================================================================
        // 外部サービス　1-訪問介護 2-訪問入浴介護 3-訪問看護 4-訪問リハ 5-通所介護 6-通所リハ 7-福祉用具貸与
        // 8-認知症対応型通所介護
        if (_1350101 == 2) {
            switch (_1350104) {
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

        // 1350105 訪問介護-種別　1-Ⅰ型 2-Ⅱ型 3-Ⅲ型
        int _1350105 = getIntValue(map, "1350105", 1);

        // 1350106 訪問介護-日割　1-日割でない 2-日割である
        int _1350106 = getIntValue(map, "1350106", 1);

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設等の区分
        sb.append(CODE_CHAR[_1350101]);

        // 外部サービス種類
        sb.append(CODE_CHAR[_1350104]);

        // 訪問介護-種別　1-Ⅰ型 2-Ⅱ型 3-Ⅲ型
        sb.append(CODE_CHAR[_1350105]);

        // 訪問介護-日割　1-日割でない 2-日割である
        sb.append(CODE_CHAR[_1350106]);

        // 要介護度
        sb.append(CODE_CHAR[_1]);

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

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設等の区分
        sb.append(CODE_CHAR[_1350101]);

        // 外部サービス種類
        sb.append(CODE_CHAR[_1350104]);

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

        // 1350107 訪問看護-施設等の区分　1-訪問看護ステーション 2-病院又は診療所
        int _1350107 = getIntValue(map, "1350107", 1);

        // 1350108 訪問看護-職員区分　1-なし 2-PT、OT、ST
        int _1350108 = getIntValue(map, "1350108", 1);

        // 1350109 訪問看護-時間区分　1-20分未満 2-30分未満 3-30分以上1時間未満
        // 4-1時間以上1時間30分未満（1-30分未満 2-30分以上1時間未満）
        int _1350109 = getIntValue(map, "1350109", 1);
        
        // 1350132 1日に2回を越えて実施 1-なし 2-あり
        int _1350132 = getIntValue(map, "1350132", 1);

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設等の区分
        sb.append(CODE_CHAR[_1350101]);

        // 外部サービス
        sb.append(CODE_CHAR[_1350104]);

        // 訪問看護-施設等の区分　1-訪問看護ステーション 2-病院又は診療所
        sb.append(CODE_CHAR[_1350107]);

        // 訪問看護-職員区分　1-なし 2-PT、OT、ST
        sb.append(CODE_CHAR[_1350108]);

        // 訪問看護-時間区分　1-20分未満 2-30分未満 3-30分以上1時間未満 4-1時間以上1時間30分未満（1-30分未満
        // 2-30分以上1時間未満）
        sb.append(CODE_CHAR[_1350109]);
        
        // 1日に2回を越えて実施
        sb.append(CODE_CHAR[_1350132]);

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

        // 1350110 訪問リハ-施設等の区分　1-病院又は診療所 2-介護老人保健施設
        int _1350110 = getIntValue(map, "1350110", 1);

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設等の区分
        sb.append(CODE_CHAR[_1350101]);

        // 外部サービス
        sb.append(CODE_CHAR[_1350104]);

        // 訪問リハ-施設等の区分　1-病院又は診療所 2-介護老人保健施設
        sb.append(CODE_CHAR[_1350110]);

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

        // 1350111 通所介護-日割　1-日割でない 2-日割である
        int _1350111 = getIntValue(map, "1350111", 1);

        // 1350112 通所介護-運動機能向上加算　1-なし 2-あり
        int _1350112 = getIntValue(map, "1350112", 1);

        // 1350113 通所介護-栄養改善加算　1-なし 2-あり
        int _1350113 = getIntValue(map, "1350113", 1);

        // 1350114 通所介護-口腔機能向上加算　1-なし 2-あり
        int _1350114 = getIntValue(map, "1350114", 1);

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設区分
        sb.append(CODE_CHAR[_1350101]);

        // 外部サービス
        sb.append(CODE_CHAR[_1350104]);

        // 要介護度
        sb.append(CODE_CHAR[_1]);

        // 通所介護-日割　1-日割でない 2-日割である
        sb.append(CODE_CHAR[_1350111]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ===========================================================================
        
        // [運動機能向上加算][栄養改善加算][口腔機能向上加算]の3桁の数値に変換
        int addParam = (_1350112 * 100) + (_1350113 * 10) + _1350114;
        
        switch(addParam) {
        // 運動器機能向上加算
        case 211:
            // 予防外部通所介護運動器加算
            putSystemServiceCodeItem(sysSvcCdItems, "Z1722");
            break;
        // 栄養改善加算
        case 121:
            // 予防外部通所介護栄養改善加算
            putSystemServiceCodeItem(sysSvcCdItems, "Z1723");
            break;
        // 口腔機能向上加算
        case 112:
            // 予防外部通所介護口腔機能加算
            putSystemServiceCodeItem(sysSvcCdItems, "Z1724");
            break;
        // 運動器機能向上加算 + 栄養改善加算
        case 221:
            // 予防外部通介複数サービス加算I１
            putSystemServiceCodeItem(sysSvcCdItems, "Z1725");
            break;
        // 運動器機能向上加算 + 口腔機能向上加算
        case 212:
            // 予防外部通介複数サービス加算I２
            putSystemServiceCodeItem(sysSvcCdItems, "Z1726");
            break;
        // 栄養改善加算 + 口腔機能向上加算
        case 122:
            // 予防外部通介複数サービス加算I３
            putSystemServiceCodeItem(sysSvcCdItems, "Z1727");
            break;
        // 運動器機能向上加算 + 栄養改善加算 + 口腔機能向上加算
        case 222:
            // 予防外部通介複数サービス加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z1728");
            break;
        }
        
        
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

        // 1350115 通所リハ-日割　1-日割でない 2-日割である
        int _1350115 = getIntValue(map, "1350115", 1);

        // 1350116 通所リハ-運動機能向上加算　1-なし 2-あり
        int _1350116 = getIntValue(map, "1350116", 1);

        // 1350117 通所リハ-栄養改善加算　1-なし 2-あり
        int _1350117 = getIntValue(map, "1350117", 1);

        // 1350118 通所リハ-口腔機能向上加算　1-なし 2-あり
        int _1350118 = getIntValue(map, "1350118", 1);
        
        // 1350133 施設等の区分 1-病院又は診療所 2-介護老人保健施設
        int _1350133 = getIntValue(map, "1350133", 1);

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設等の区分
        sb.append(CODE_CHAR[_1350101]);

        // 外部サービス
        sb.append(CODE_CHAR[_1350104]);
        
        // 施設等の区分
        sb.append(CODE_CHAR[_1350133]);

        // 要介護度
        sb.append(CODE_CHAR[_1]);

        // 通所リハ-日割　1-日割でない 2-日割である
        sb.append(CODE_CHAR[_1350115]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ===========================================================================
        // [運動機能向上加算][栄養改善加算][口腔機能向上加算]の3桁の数値に変換
        int addParam = (_1350116 * 100) + (_1350117 * 10) + _1350118;
        
        switch(addParam) {
        // 運動器機能向上加算
        case 211:
            // 予防外部通所介護運動器加算
            putSystemServiceCodeItem(sysSvcCdItems, "Z1821");
            break;
        // 栄養改善加算
        case 121:
            // 予防外部通所介護栄養改善加算
            putSystemServiceCodeItem(sysSvcCdItems, "Z1822");
            break;
        // 口腔機能向上加算
        case 112:
            // 予防外部通所介護口腔機能加算
            putSystemServiceCodeItem(sysSvcCdItems, "Z1823");
            break;
        // 運動器機能向上加算 + 栄養改善加算
        case 221:
            // 予防外部通介複数サービス加算I１
            putSystemServiceCodeItem(sysSvcCdItems, "Z1824");
            break;
        // 運動器機能向上加算 + 口腔機能向上加算
        case 212:
            // 予防外部通介複数サービス加算I２
            putSystemServiceCodeItem(sysSvcCdItems, "Z1825");
            break;
        // 栄養改善加算 + 口腔機能向上加算
        case 122:
            // 予防外部通介複数サービス加算I３
            putSystemServiceCodeItem(sysSvcCdItems, "Z1826");
            break;
        // 運動器機能向上加算 + 栄養改善加算 + 口腔機能向上加算
        case 222:
            // 予防外部通介複数サービス加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z1827");
            break;
        }

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

        // 1350119 福祉用具貸与-用具
        int yoguYogu = getIntValue(map, "1350119", 1);

        // 1350120 福祉用具貸与-単位数
        try {
            baseUnit = getIntValue(map, "1350120");
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

        // 施設等の区分
        sb.append(CODE_CHAR[_1350101]);

        // 外部サービス種類
        sb.append(CODE_CHAR[_1350104]);

        // 福祉用具貸与-用具
        sb.append(CODE_CHAR[yoguYogu]);

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

        // 1350121 認知症対応型通所介護-施設等の区分1　1-Ⅰ型 2-Ⅱ型
        int _1350121 = getIntValue(map, "1350121", 1);

        // 1350122 認知症対応型通所介護-施設等の区分2　1-単独型 2-併設型
        int _1350122 = getIntValue(map, "1350122", 1);

        // 1350123 認知症対応型通所介護-時間区分　1-2～3時間 2-3～4時間 3-4～6時間 4-6～8時間
        int _1350123 = getIntValue(map, "1350123", 1);

        // 1350124 認知症対応型通所介護-個別機能訓練加算　1-なし 2-あり
        int _1350124 = getIntValue(map, "1350124", 1);

        // 1350125 認知症対応型通所介護-栄養改善加算　1-なし 2-あり
        int _1350125 = getIntValue(map, "1350125", 1);

        // 1350126 認知症対応型通所介護-口腔機能向上加算　1-なし 2-あり
        int _1350126 = getIntValue(map, "1350126", 1);

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設等の区分
        sb.append(CODE_CHAR[_1350101]);

        // 外部サービス種類
        sb.append(CODE_CHAR[_1350104]);

        // 認知症対応型通所介護-施設等の区分1　1-Ⅰ型 2-Ⅱ型
        sb.append(CODE_CHAR[_1350121]);

        // 認知症対応型通所介護-施設等の区分2　1-単独型 2-併設型
        sb.append(CODE_CHAR[_1350122]);

        // 認知症対応型通所介護-時間区分　1-2～3時間 2-3～4時間 3-4～6時間 4-6～8時間
        sb.append(CODE_CHAR[_1350123]);

        // 要介護度
        sb.append(CODE_CHAR[_1]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ===========================================================================

        // 認知症対応型通所介護-個別機能訓練加算　1-なし 2-あり
        if (_1350124 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2141");
        }

        // 認知症対応型通所介護-栄養改善加算　1-なし 2-あり
        if (_1350125 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2142");
        }

        // 認知症対応型通所介護-口腔機能向上加算　1-なし 2-あり
        if (_1350126 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2143");
        }
        
        return sysSvcCdItems;
    }

    /**
     * 福祉用具の単位数を返す
     */
    public ArrayList<VRMap> getServiceCode(Map<String, String> map,
            ACDBManager dbm) {
        ArrayList<VRMap> al = super.getServiceCode(map, dbm);
        if (_1350104 == 7) {
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
