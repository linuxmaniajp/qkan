package jp.nichicom.ac.lib.care.claim.servicecode;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * サービスコード取得クラス雛形
 */
// public class Qkan10011_ServiceUnitGetter {
public abstract class Qkan10011_ServiceUnitGetter {
    private Date sysYmd; // システム日付

    public final String[] CODE_CHAR = { "0", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
            "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
            "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
            "y", "z", "あ", "い", "う", "え", "お", "か", "き", "く", "け", "こ", "さ",
            "し", "す", "せ", "そ", "た", "ち", "つ", "て", "と", "な", "に", "ぬ", "ね",
            "の", "は", "ひ", "ふ", "へ", "ほ", "ま", "み", "む", "め", "も", "や", "ゆ",
            "よ", "ら", "り", "る", "れ", "ろ", "わ", "を", "ん" };

    // 共通KEY
    public static final String YOKAIGODO = "1";
    public static final String TOKUCHI_KASAN = "2";
    public static final String CHUSANKANCHIIKI_KASAN = "13";
    // [ID:0000682] 2012/01 start 介護職員処遇改善加算の追加処理 TODO
    public static final String SYOGUKAIZEN_KASAN = "17";
    // [ID:0000682] 2012/01 end

 // 2016/8/23 [Yoichiro Kamei] add - begin 総合事業対応
    public static  final String SJ_HOKENSHA_NO_BIND_PATH = "500";
    public static  final int SJ_SERVICE_CODE_BIND_PATH_ST = 501;
    public static  final int SJ_SERVICE_CODE_BIND_PATH_ED = 510;
 // 2016/8/23 [Yoichiro Kamei] add - end
    
    // サービスコード生成項目値 初期値
    public static final String DEFAULT_CHAR = "1";

    // 食費・居住費内部サービスコード
    public static final String SERVICE_CODE_SHOKUHI = "Y100";
    public static final String SERVICE_CODE_NORMAL_ROOM = "Y210";
    public static final String SERVICE_CODE_TASHO_ROOM = "Y220";
    public static final String SERVICE_CODE_UNIT_ROOM = "Y201";
    public static final String SERVICE_CODE_UNIT_SEMI_ROOM = "Y202";
    public static final String SERVICE_CODE_NEW_TASHO_ROOM = "Y220";

    // サービス名称取得
    abstract public String getServiceName();

    // サービス種類コード(2桁)取得
    abstract public String getServiceCodeKind();

    // システムサービス種類コード(5桁)取得
    abstract public String getSystemServiceKindDetail();

    // システムサービス項目コード取得
    abstract protected ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map);

    // システム日付設定
    public void setSysYmd(Date sysYmd) {
        this.sysYmd = sysYmd;
    }

    // システム日付取得
    public Date getSysYmd() {
        return sysYmd;
    }

    /**
     * map中のkeyのvalueを取得、int型の値として返す。 keyが存在しない場合、0を返す。
     * 
     * @param map
     * @param key
     * @return
     */
    protected int getIntValue(Map<String, String> map, String key) {
        if (map.get(key) != null) {
            return Integer.parseInt(String.valueOf(map.get(key)));
        } else {
            return 1;
        }
    }

    /**
     * map中のkeyのvalueを取得、int型の値として返す。 keyが存在しない場合、指定されたdefaultValueを返す。
     * 
     * @param map
     * @param key
     * @param defaultValue
     * @return
     */
    protected int getIntValue(Map<String, String> map, String key,
            int defaultValue) {
        if (map.get(key) != null) {
            return Integer.parseInt(String.valueOf(map.get(key)));
        } else {
            return defaultValue;
        }
    }

    /**
     * （値の反転が必要なくなったため今後は使用しない） map中のkeyのvalueを取得、int型の値として返す。 ユニットケアの整備専用。
     * 入力は「1:未整備、2:整備」、出力は「1:整備、2:未整備」である点に注意。 #画面項目と、サービスコード表とでは逆になっているため。
     * 
     * @param map
     * @param keyOfUnitCare ユニットケア整備(1:未整備, 2:整備)のKEY
     * @param isUnit false:従来型, true:ユニット型
     * @return ユニットケア未整備(0:関係なし/従来型, 1:整備, 2:未整備)
     */
    @Deprecated
    protected int getIntValueUnitCareSeibi(Map<String, String> map,
            String keyOfUnitCare, boolean isUnit) {
        return getIntValue(map, keyOfUnitCare, 1);
    }

    /**
     * 要介護度コードをサービスコード生成ロジック内の要介護度コードへ変換
     * 
     * @param yokaigodo
     * @return
     */
    protected int convertYokaigodo(int yokaigodo) {
        int systemYokaigodo = 0;

        switch (yokaigodo) {
        case 1: // 自立
            systemYokaigodo = 1;
            break;
            
// 2016/7/5 [Yoichiro Kamei] add - begin 総合事業対応
        case 6: // 事業対象者
            systemYokaigodo = 10;
            break;
// 2016/7/5 [Yoichiro Kamei] add - end
            
        case 11: // 経過的要介護
            systemYokaigodo = 2;
            break;

        case 12: // 要支援１
            systemYokaigodo = 3;
            break;

        case 13: // 要支援２
            systemYokaigodo = 4;
            break;

        case 21: // 要介護度１
            systemYokaigodo = 5;
            break;

        case 22: // 要介護度２
            systemYokaigodo = 6;
            break;

        case 23: // 要介護度３
            systemYokaigodo = 7;
            break;

        case 24: // 要介護度４
            systemYokaigodo = 8;
            break;

        case 25: // 要介護度５
            systemYokaigodo = 9;
            break;
        }

        return systemYokaigodo;
    }

    /**
     * SYSTEM_SERVICE_CODE_ITEM格納用のリストに値を追加する
     * 
     * @param sysSvcCdItems
     * @param sysSvcCdItem
     * @return
     */
    protected boolean putSystemServiceCodeItem(
            ArrayList<HashMap<String, String>> sysSvcCdItems,
            String sysSvcCdItem) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("SYSTEM_SERVICE_KIND_DETAIL", getSystemServiceKindDetail());
        map.put("SYSTEM_SERVICE_CODE_ITEM", sysSvcCdItem);
        sysSvcCdItems.add(map);
        return true;
    }

// 2016/8/23 [Yoichiro Kamei] add - begin 総合事業対応
    /**
     * SYSTEM_SERVICE_CODE_ITEM格納用のリストに値を追加する（総合事業の独自定率・独自定額に使用）
     * 
     * @param sysSvcCdItems システムサービス項目コードを格納するためのマップ
     * @param codes サービスに選択されたコード
     */
    protected void putSogoSystemServiceCodeItems(
            ArrayList<HashMap<String, String>> sysSvcCdItems,
            Map codes) {
        for (int key = SJ_SERVICE_CODE_BIND_PATH_ST; key <=SJ_SERVICE_CODE_BIND_PATH_ED; key++) {
            String value = ACCastUtilities.toString(codes.get(String.valueOf(key)), "");
            if ("".equals(value)) {
                break;
            }
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("SYSTEM_SERVICE_KIND_DETAIL", getSystemServiceKindDetail());
            map.put("SYSTEM_SERVICE_CODE_ITEM", value);
            sysSvcCdItems.add(map);
        }
    }
// 2016/8/23 [Yoichiro Kamei] add - end
    
    /**
     * SYSTEM_SERVICE_CODE_ITEMからサービスコードを取得する
     * 
     * @param map
     * @param dbm
     * @return
     */
    public ArrayList<VRMap> getServiceCode(Map<String, String> map,
            ACDBManager dbm) {
        ArrayList<VRMap> serviceCode = new ArrayList<VRMap>(); // サービスコード格納用
        ArrayList<HashMap<String, String>> systemServiceCodeItemList = getSystemServiceCodeItem(map); // 独自コード取得

        try {
            VRList data = new VRArrayList();

            // sysYMD
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            String sysYmdString = formatter.format(sysYmd);

            int limit = Qkan10011_ServiceCodeManager.getInstance()
                    .getServiceCodeCacheLimit();
            Map<String, VRList> cache = Qkan10011_ServiceCodeManager
                    .getInstance().getServiceCodeCache();
            for (int i = 0; i < systemServiceCodeItemList.size(); i++) {
                HashMap<String, String> systemServiceCodeMap = systemServiceCodeItemList
                        .get(i);
                String systemServiceCodeItem = systemServiceCodeMap.get(
                        "SYSTEM_SERVICE_CODE_ITEM").toString();
                String systemServiceCodeDetail = systemServiceCodeMap.get(
                        "SYSTEM_SERVICE_KIND_DETAIL").toString();
                
             // 2016/8/23 [Yoichiro Kamei] add - begin 総合事業対応
                if (QkanSjServiceCodeManager.teiritsuTeigakuCodes.contains(systemServiceCodeDetail)) {
                    VRMap ret = QkanSjServiceCodeManager.getSjServiceCodeByKey(dbm, systemServiceCodeItem, sysYmd);
                    if (!ret.isEmpty()) {
                        serviceCode.add(ret);
                        continue;
                    }
                }
             // 2016/8/23 [Yoichiro Kamei] add - end
                
                // String serviceValidStart =
                // systemServiceCodeMap.get("SERVICE_VALID_START").toString();

                // 「対象年月+SYSTEM_SERVICE_CODE_ITEM」をキーにキャッシュから探す。
                // String cacheKey = sysYmdString + systemServiceCodeItem;
                String cacheKey = systemServiceCodeItem + "-"
                        + systemServiceCodeDetail + "-" + sysYmdString;
                Object cacheVal = cache.get(cacheKey);
                if (cacheVal == null) {

                    // DBからデータを取得
                    // ====================================================================
                    StringBuilder sb = new StringBuilder();
                    sb.append(" SELECT");
                    sb.append(" SYSTEM_SERVICE_KIND_DETAIL");
                    sb.append(",SYSTEM_SERVICE_CODE_ITEM");
                    sb.append(",SERVICE_VALID_START");
                    sb.append(",SERVICE_VALID_END");
                    sb.append(",SERVICE_CODE_KIND");
                    sb.append(",SERVICE_CODE_ITEM");
                    sb.append(",SERVICE_NAME");
                    sb.append(",SERVICE_UNIT");
                    sb.append(",LIMIT_AMOUNT_OBJECT");
                    sb.append(",SERVICE_ADD_FLAG");
                    sb.append(",TOTAL_GROUPING_TYPE");
                    sb.append(",SERVICE_MAIN_FLAG");
                    sb.append(",ROOM_TYPE");
                    sb.append(",SERVICE_ADD_TYPE");
                    sb.append(",SERVICE_STAFF_UNIT");
                    sb.append(",SUMMARY_FLAG");
                    sb.append(",SUMMARY_MEMO");
                    sb.append(",CLASS_TYPE");
                    sb.append(",CODE_ID");
                    sb.append(",EDITABLE_FLAG");
                    sb.append(",LAST_TIME");
                    sb.append(" FROM");
                    sb.append(" M_SERVICE_CODE");
                    sb.append(" WHERE");
                    sb.append(" SYSTEM_SERVICE_KIND_DETAIL="
                            + getSystemServiceKindDetail());
                    sb.append(" AND SYSTEM_SERVICE_CODE_ITEM='"
                            + systemServiceCodeItem + "'");
                    sb.append(" AND SERVICE_VALID_START<='" + sysYmdString
                            + "'");
                    sb.append(" AND SERVICE_VALID_END>='" + sysYmdString + "'");
                    data = dbm.executeQuery(sb.toString());

                    if (cache.size() > limit) {
                        // キャッシュ限界を超えたらすべてクリア（大量件数対策）
                        cache.clear();
                    }
                    // キャッシュに格納
                    cache.put(cacheKey, data);
                } else {
                    // キャッシュした値を再利用
                    data = (VRList) cacheVal;
                }
                System.out.print(systemServiceCodeItem + " = ");
                if ((data != null) && (!data.isEmpty())) {
                    VRMap code = (VRMap) data.getData(0);
                    System.out.print(String.valueOf(code
                            .getData("SERVICE_CODE_KIND")));
                    System.out.print(" " + code.getData("SERVICE_CODE_ITEM"));
                    System.out.print(" " + code.getData("SERVICE_NAME"));
                    System.out.print(" " + code.getData("SERVICE_UNIT"));
                    switch (ACCastUtilities.toInt(code.get("SERVICE_ADD_FLAG"),
                            0)) {
                    case 1:
                        System.out.print("単位");
                        break;
                    case 2:
                        System.out.print("単位加算");
                        break;
                    case 3:
                        System.out.print("%加算");
                        break;
                    case 4:
                        System.out.print("単位減算");
                        break;
                    case 5:
                        System.out.print("%減算");
                        break;
                    case 8:
                        System.out.print("%加算");
                        break;
                    case 9:
                        System.out.print("円");
                        break;
                    default:
                        System.out.print("単位");
                        break;
                    }
                    System.out.print(" → ");

                }
                System.out.println(data);
                if (data.getDataSize() > 0) {
                    // 2016/8/23 [Yoichiro Kamei] mod - begin 総合事業対応
                    //serviceCode.add((VRMap) data.getData(0));
                    VRMap code = (VRMap) data.getData(0);
                    // 独自の場合
                    if (QkanSjServiceCodeManager.dokujiCodes.contains(systemServiceCodeDetail)) {
                        String insurerId = map.get(SJ_HOKENSHA_NO_BIND_PATH);
                        // 保険者番号をセット
                        code.put("INSURER_ID", insurerId);
                        // 上書き対象が％加算でなければ、単位数を上書き
                        if (!(ACCastUtilities.toInt(code.get("SERVICE_ADD_FLAG"), 0) == 3 //％加算(地域系加算)
                                || ACCastUtilities.toInt(code.get("SERVICE_ADD_FLAG"), 0) == 6 //％加算(対象に地域系加算を含む)
                                || ACCastUtilities.toInt(code.get("SERVICE_ADD_FLAG"), 0) == 8 //処遇改善加算
                            )) {
                            String itemCode = ACCastUtilities.toString(code.getData("SERVICE_CODE_ITEM"));
                            String sjKey = QkanSjServiceCodeManager.createSjServiceCodeKey(insurerId, systemServiceCodeDetail, itemCode);
                            VRMap ret = QkanSjServiceCodeManager.getSjServiceCodeByKey(dbm, sjKey, sysYmd);
                            int unit = ACCastUtilities.toInt(ret.get("SERVICE_UNIT"), 0);
                            if (unit != 0) {
                                code.put("SERVICE_UNIT", unit);
                            }
                        }
                    }
                    serviceCode.add(code);
                    // 2016/8/23 [Yoichiro Kamei] mod - end
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("-----------------------------");

        return serviceCode;
    }

    public static String getSystemServiceCodeOfRoom(int byoshitsu) {
        switch (byoshitsu) {
        case 1:
            // 従来型個室
            return SERVICE_CODE_NORMAL_ROOM;
        case 2:
            // 多床室
            return SERVICE_CODE_TASHO_ROOM;
        case 3:
            // ユニット型個室
            return SERVICE_CODE_UNIT_ROOM;
        case 4:
            // ユニット型準個室
            return SERVICE_CODE_UNIT_SEMI_ROOM;
        case 5:
            // 多床室（新）
            return SERVICE_CODE_NEW_TASHO_ROOM;
        }
        return null;
    }

    public static int convertByoshitsuKbn(int byoshitsu, boolean unitRoom) {
        if (unitRoom) {
            switch (byoshitsu) {
            case 1:
                // ユニット型個室
                return 3;
            case 2:
                // ユニット型準個室
                return 4;
            }
        } else {
            switch (byoshitsu) {
            case 1:
                // 従来型個室
                return 1;
            case 2:
                // 多床室
                return 2;
            case 3:
                // 多床室（新）
                return 5;
            }
        }
        return 1;
    }
}
