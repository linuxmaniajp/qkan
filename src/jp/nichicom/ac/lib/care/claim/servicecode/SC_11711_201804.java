package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.vr.util.VRMap;

/**
 * 福祉用具貸与
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_11711_201804 extends Qkan10011_ServiceUnitGetter {
    private int baseUnit = 0; // 基本分の単位数
    private int tokuchiKasan = 0; // 加算分の単位数
    private int chusankanJigyosyoKasan = 0; // 加算分の単位数
    private int chusankanServiceKasan = 0; // 加算分の単位数
    private boolean isTokuchi = false; // 入力項目を特定するフラグ
    private boolean isChusankan = false; // 入力項目を特定するフラグ
    private boolean isChusankanService = false; // 入力項目を特定するフラグ
    

    public String getServiceName() {
        return "福祉用具貸与";
    }

    public String getServiceCodeKind() {
        return "17";
    }

    public String getSystemServiceKindDetail() {
        return "11711 ";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================
        
        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));
        // 明らかに要介護度がおかしい場合は空を返す
        switch(_1){
        case 1: // 自立
        case 3: // 要支援１
        case 4: // 要支援２
        case 10: // 事業対象者
            return new ArrayList<HashMap<String, String>>();
        }
        
        // 1170103 特地加算
        int _1170103 = getIntValue(map, "1170103", 0);

        // 1170101 用具
        int _1170101 = getIntValue(map, "1170101");
        
        // 1170105 中山間地域等小規模事業所加算
        int _1170105 = getIntValue(map, "1170105", 0);
        
        // 1170106 中山間地域等でのサービス提供加算
        int _1170106 = getIntValue(map, "1170106", 0);

        // 1170102 単位数
        this.baseUnit = getIntValue(map, "1170102", 0);

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 特地加算
        sb.append(CODE_CHAR[1]);

        // 用具
        sb.append(CODE_CHAR[_1170101]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        if (_1170103 > 0) {
            // 特地加算
            sb = new StringBuilder();
            sb.append(CODE_CHAR[2]);
            // 用具
            sb.append(CODE_CHAR[_1170101]);
            this.tokuchiKasan = _1170103; // 加算分の単位数退避
            putSystemServiceCodeItem(sysSvcCdItems, sb.toString()); // リストに追加
            // フラグ退避
            this.isTokuchi = true;
        }
        
        if (_1170105 > 0) {
            // 中山間地域等小規模事業所加算
            sb = new StringBuilder();
            sb.append(CODE_CHAR[3]);
            // 用具
            sb.append(CODE_CHAR[_1170101]);
            // 加算分の単位数退避
            this.chusankanJigyosyoKasan = _1170105;
            // リストに追加
            putSystemServiceCodeItem(sysSvcCdItems, sb.toString());
            // フラグ退避
            this.isChusankan = true;
        }
        
        if (_1170106 > 0) {
            // 中山間地域等でのサービス提供加算
            sb = new StringBuilder();
            sb.append(CODE_CHAR[4]);
            // 用具
            sb.append(CODE_CHAR[_1170101]);
            // 加算分の単位数退避
            this.chusankanServiceKasan = _1170106;
            // リストに追加
            putSystemServiceCodeItem(sysSvcCdItems, sb.toString());
            // フラグ退避
            this.isChusankanService = true;
        }

        return sysSvcCdItems;
    }


    public ArrayList<VRMap> getServiceCode(Map<String, String> map, ACDBManager dbm) {
        ArrayList<VRMap> al = super.getServiceCode(map, dbm);
        Map<String, Integer> mp = null;
        int addCount = 0;
        // ※サービスコードの生成の都合上、順番を厳密に維持する点に注意 
        
        switch (al.size()) {
        case 1: // 本体分の1コードのみ
            mp = (Map<String, Integer>) al.get(addCount);
            mp.put("SERVICE_UNIT", new Integer(this.baseUnit));
            break;

        case 2: // 本体＋加算の計2コード
            mp = (Map<String, Integer>) al.get(addCount);
            mp.put("SERVICE_UNIT", new Integer(this.baseUnit));
            addCount++;
            // 特別地域
            if(isTokuchi && (addCount < 2)) {
                mp = (Map<String, Integer>) al.get(addCount);
                mp.put("SERVICE_UNIT", new Integer(this.tokuchiKasan));
                addCount++;                
            }
            // 中山間地域等小規模事業所
            if(isChusankan && (addCount < 2)) {
                mp = (Map<String, Integer>) al.get(addCount);
                mp.put("SERVICE_UNIT", new Integer(this.chusankanJigyosyoKasan));
                addCount++;                
            }
            // 中山間地域等におけるサービス提供
            if(isChusankanService && (addCount < 2)) {
                mp = (Map<String, Integer>) al.get(addCount);
                mp.put("SERVICE_UNIT", new Integer(this.chusankanServiceKasan));
                addCount++;                
            }
            break;
        case 3:
            mp = (Map<String, Integer>) al.get(addCount);
            mp.put("SERVICE_UNIT", new Integer(this.baseUnit));
            addCount++;
            // 特別地域
            if(isTokuchi && (addCount < 3)) {
                mp = (Map<String, Integer>) al.get(addCount);
                mp.put("SERVICE_UNIT", new Integer(this.tokuchiKasan));
                addCount++;                
            }
            // 中山間地域等小規模事業所
            if(isChusankan && (addCount < 3)) {
                mp = (Map<String, Integer>) al.get(addCount);
                mp.put("SERVICE_UNIT", new Integer(this.chusankanJigyosyoKasan));
                addCount++;                
            }
            // 中山間地域等におけるサービス提供
            if(isChusankanService && (addCount < 3)) {
                mp = (Map<String, Integer>) al.get(addCount);
                mp.put("SERVICE_UNIT", new Integer(this.chusankanServiceKasan));
                addCount++;                
            }
            break;
        case 4:
            mp = (Map<String, Integer>) al.get(addCount);
            mp.put("SERVICE_UNIT", new Integer(this.baseUnit));
            addCount++;
            // 特別地域
            if(isTokuchi && (addCount < 4)) {
                mp = (Map<String, Integer>) al.get(addCount);
                mp.put("SERVICE_UNIT", new Integer(this.tokuchiKasan));
                addCount++;                
            }
            // 中山間地域等小規模事業所
            if(isChusankan && (addCount < 4)) {
                mp = (Map<String, Integer>) al.get(addCount);
                mp.put("SERVICE_UNIT", new Integer(this.chusankanJigyosyoKasan));
                addCount++;                
            }
            // 中山間地域等におけるサービス提供
            if(isChusankanService && (addCount < 4)) {
                mp = (Map<String, Integer>) al.get(addCount);
                mp.put("SERVICE_UNIT", new Integer(this.chusankanServiceKasan));
                addCount++;                
            }
            break;
        }

        return al;
    }

}
