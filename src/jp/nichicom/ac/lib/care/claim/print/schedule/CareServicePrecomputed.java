package jp.nichicom.ac.lib.care.claim.print.schedule;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.bridge.sql.BridgeFirebirdDBManager;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;

/**
 * 特定診療費の合算単位数を求める
 * <p>
 * Copyright (c) 2012 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Shin Fujihara
 * @version 1.0 2012/02/01
 */
public class CareServicePrecomputed {
    
    
    private ACDBManager db;
    
    private Map<String, String> ryoyoMap = null;
    private Map<String, String> shinryoMap = null;
    // [H30.4改正対応][Yoichiro Kamei] 2018/3/13 add - begin
    private Map<String, String> tokubetuShinryoMap = null;
    // [H30.4改正対応][Yoichiro Kamei] 2018/3/13 add - end
    private Map<String, Integer> clinicUnit = null;
    // [ID:0000415][Masahiko.Higuchi] add - begin 特定入所者の履歴管理機能
    private Map<String, String> clinicName = null;
    private Map<String, Map> diagnosisDateMap = null;
    // [ID:0000415][Masahiko.Higuchi] add - end


	/**
     * 全サービスを走査し、事前計算を行う。<br/>
     * 事前計算を行う項目は、利用者負担額、特定診療費・特別療養費・特別診療費<br/>
     * 利用者負担額は、第三引数のMapに[事業所番号]-[システム内サービス種類コード]をキーにInteger型で設定<br/>
     * 特定診療費・特別療養費・特別診療費は、第四引数のMapに[事業所番号]-[システム内サービス種類コード]をキーにInteger型で設定<br/>
     * @param db ACDBManager
     * @param serviceList 解析対象のサービスmapを含むlist
     * @param regulationMap 利用者負担額を設定するMap
     * @param diagnosisMap 特定診療費・特別療養費・特別診療費を設定するMap
     * @throws Exception
     */
    public void setPrecomputedResult(ACDBManager db, List serviceList,
            Map<String, Integer> regulationMap, Map<String, Integer> diagnosisMap) throws Exception {
        
        this.db = db;
        
        VRMap row = null;
        
        // [ID:0000415][Masahiko.Higuchi] add - begin 特定入所者の履歴管理機能
        VRArrayList clinicDateList = new VRArrayList();
        Map clinicMap = new VRHashMap();
        diagnosisDateMap = new VRHashMap();
        // [ID:0000415][Masahiko.Higuchi] add - end
        
        Map<String, String> codeMap = null;
        Set<String> ryoyo = createRyoyoSet();
        Set<String> shinryo = createShinryoSet();
        // [H30.4改正対応][Yoichiro Kamei] 2018/3/13 add - begin
        Set<String> tokubetuShinryo = createTokubetuShinryoSet();
        // [H30.4改正対応][Yoichiro Kamei] 2018/3/13 add - end
        
        String systemServiceKindDetail;
        int count = serviceList.size();
        
        for (int i = 0; i < count; i++) {
            row = (VRMap)serviceList.get(i);
            
            //外泊ならスキップ
            if (CareServiceCommon.isGaihaku(row) == 2){
                continue;
            }
            //30日超であればスキップ
            if(ACCastUtilities.toInt(row.get("5"),0) == 2){
                continue;
            }
            
            
            //サービス種類を取得
            systemServiceKindDetail = ACCastUtilities.toString(row.get("SYSTEM_SERVICE_KIND_DETAIL"));
            //Mapに格納するキーを作成
            String key = ACCastUtilities.toString(row.get("PROVIDER_ID")) + "-" + systemServiceKindDetail;
            
            //自己負担額確認
            if (row.containsKey("REGULATION_RATE")) {
                int selfpay = ACCastUtilities.toInt(row.get("REGULATION_RATE"), 0);
                
                if (0 < selfpay) {
                    if (regulationMap.containsKey(key)) {
                        regulationMap.put(key, new Integer(regulationMap.get(key).intValue() + selfpay));
                    } else {
                        regulationMap.put(key, new Integer(selfpay));
                    }
                }
            }
            
            
            
            //特別療養費
            if (ryoyo.contains(systemServiceKindDetail)) {
                codeMap = getRyoyoMap();
                
            //特定診療費
            } else if (shinryo.contains(systemServiceKindDetail)) {
                codeMap = getShinryoMap();
            // [H30.4改正対応][Yoichiro Kamei] 2018/3/13 add - begin
            } else if (tokubetuShinryo.contains(systemServiceKindDetail)) {
                codeMap = getTokubetuShinryoMap();
            // [H30.4改正対応][Yoichiro Kamei] 2018/3/13 add - end
                
            //対象外
            } else {
                continue;
            }
            
            int unit = getTotalUnit(row, codeMap);
            if (unit == 0) {
                continue;
            }
            
            // [ID:0000415][Masahiko.Higuchi] add - begin 特定入所者の履歴管理機能
            Map<String, Map> nameResult = getTotalName(row, codeMap);
            ArrayList<Map> clinicDateAll = new ArrayList<Map>();
            
            if(diagnosisDateMap.containsKey(key)) {
            	clinicMap = diagnosisDateMap.get(key);
            } else {
            	clinicMap = new VRHashMap();
            }
            
            // 名前をキーとして日付を解析
            for(Entry<String, Map> nameEntry : nameResult.entrySet()) {

            	if(clinicMap.containsKey(nameEntry.getKey())) {
            		// 既存
            		clinicDateAll = (ArrayList<Map>)clinicMap.get(nameEntry.getKey());
            		clinicDateAll.add(nameEntry.getValue());
            		clinicMap.put(nameEntry.getKey(), clinicDateAll);
            	} else {
            		// 新規
            		clinicDateAll = new ArrayList<Map>();
            		clinicDateAll.add(nameEntry.getValue());
            		clinicMap.put(nameEntry.getKey(), clinicDateAll);
            	}
            	
            }
            
            diagnosisDateMap.put(key, clinicMap);
            // [ID:0000415][Masahiko.Higuchi] add - end            
            
            if (diagnosisMap.containsKey(key)) {
                diagnosisMap.put(key, new Integer(diagnosisMap.get(key).intValue() + unit));
            } else {
                diagnosisMap.put(key, new Integer(unit));
            }
            
        }
        
    }
    
    
    // 設定されている特定診療費・特別療養費の合算を取得
    private int getTotalUnit(VRMap row, Map<String, String> codeMap) throws Exception {
        
        int unit = 0;
        
        for (Entry<String, String> code : codeMap.entrySet()) {
            
            if (!row.containsKey(code.getKey())){
                continue;
            }
            
            unit += getUnit(row, code.getValue(), ACCastUtilities.toInt(row.get(code.getKey()), 0));
            
        }
        
        return unit;
    }
    
    
    // 設定されている特定診療費・特別療養費の合算を取得
    private int getUnit(VRMap row, String code, int count) throws Exception {

        if (count == 0) {
            return 0;
        }
        
        if (clinicUnit == null) {
            clinicUnit = getClinicUnit(row);
        }
        
        
        if (!clinicUnit.containsKey(code)) {
            return 0;
        }
        
        return clinicUnit.get(code).intValue() * count;
    }
    
    
    // データベースから、特定診療費・特別療養費の単位数単価を取得
    private Map<String, Integer> getClinicUnit(Map row) throws Exception {
        
        
        Date targetDate = ACCastUtilities.toDate(row.get("SERVICE_DATE"));
        Date targetDateStart = ACDateUtilities.toFirstDayOfMonth(targetDate);
        Date targetDateEnd = ACDateUtilities.toLastDayOfMonth(targetDate);
        
        StringBuilder sql = new StringBuilder();
        
        sql.append("SELECT");
        sql.append(" SPECIAL_CLINIC_TYPE || '-' || RECORD_TYPE AS CODE,");
        sql.append(" SPECIAL_CLINIC_UNIT");
        sql.append(" FROM");
        sql.append(" M_SPECIAL_CLINIC");
        sql.append(" WHERE");
        sql.append(" (SPECIAL_CLINIC_VALID_START <= '");
        sql.append(VRDateParser.format(targetDateEnd,"yyyy/MM/dd"));
        sql.append("') AND (SPECIAL_CLINIC_VALID_END >= '");
        sql.append(VRDateParser.format(targetDateStart,"yyyy/MM/dd"));
        sql.append("')");
        
        List list = db.executeQuery(sql.toString());
        Map<String, Integer> result = new HashMap<String, Integer>();
        
        for (int i = 0; i < list.size(); i++) {
            Map m = (Map)list.get(i);
            result.put(ACCastUtilities.toString(m.get("CODE")), ACCastUtilities.toInteger(m.get("SPECIAL_CLINIC_UNIT")));
        }
        
        
        return result;
    }
    
    /**
     * 特定診療費・特別療養費の名前を取得します。
     * @param row
     * @return
     * @throws Exception
     * @since V6.1.2
     */
    private Map<String, String> getClinicName(Map row) throws Exception {
        
        
        Date targetDate = ACCastUtilities.toDate(row.get("SERVICE_DATE"));
        Date targetDateStart = ACDateUtilities.toFirstDayOfMonth(targetDate);
        Date targetDateEnd = ACDateUtilities.toLastDayOfMonth(targetDate);
        
        StringBuilder sql = new StringBuilder();
        
        sql.append("SELECT");
        sql.append(" SPECIAL_CLINIC_TYPE || '-' || RECORD_TYPE AS CODE,");
        sql.append(" SPECIAL_CLINIC_NAME");
        sql.append(" FROM");
        sql.append(" M_SPECIAL_CLINIC");
        sql.append(" WHERE");
        sql.append(" (SPECIAL_CLINIC_VALID_START <= '");
        sql.append(VRDateParser.format(targetDateEnd,"yyyy/MM/dd"));
        sql.append("') AND (SPECIAL_CLINIC_VALID_END >= '");
        sql.append(VRDateParser.format(targetDateStart,"yyyy/MM/dd"));
        sql.append("')");
        
        List list = db.executeQuery(sql.toString());
        Map<String, String> result = new HashMap<String, String>();
        
        for (int i = 0; i < list.size(); i++) {
            Map m = (Map)list.get(i);
            result.put(ACCastUtilities.toString(m.get("CODE")), ACCastUtilities.toString(m.get("SPECIAL_CLINIC_NAME")));
        }
        
        
        return result;
    }
    
    // 設定されている特定診療費・特別療養費の合算を取得
    private String getName(VRMap row, String code, String name) throws Exception {

        if ("".equals(name)) {
            return "";
        }
        
        if (clinicName == null) {
        	clinicName = getClinicName(row);
        }
        
        
        if (!clinicName.containsKey(code)) {
            return "";
        }
        
        return clinicName.get(code).toString();
    }
    
    /**
     * 特定診療費・特別療養費の名称と設定日を取得
     * 
     * @param row
     * @param codeMap
     * @return
     * @throws Exception
     * @since V6.1.2
     */
    private Map getTotalName(VRMap row, Map<String, String> codeMap) throws Exception {
        
        String name = "";
        VRMap map = new VRHashMap();
        VRMap inMap = new VRHashMap();

        
        for (Entry<String, String> code : codeMap.entrySet()) {
            
            if (!row.containsKey(code.getKey())){
                continue;
            }
            
            // サービス名称をキーにして日付を退避する
            name = getName(row, code.getValue(), ACCastUtilities.toString(row.get(code.getKey()), ""));
            inMap = new VRHashMap();
            
        	// 名前・日付・回数を設定
        	inMap.setData("NAME",name);
        	inMap.setData("SERVICE_DATE",row.getData("SERVICE_DATE"));
        	inMap.setData("COUNT",ACCastUtilities.toInt(row.get(code.getKey()), 0));
        	
        	map.setData(code.getKey(),inMap);
            
        }
        
        return map;
    }
    

    private Map<String, String> getRyoyoMap() {
        
        if (ryoyoMap != null) {
            return ryoyoMap;
        }
        
        
        ryoyoMap = new HashMap<String, String>();
        
        ryoyoMap.put("3010101", "01-2"); //感染対策指導管理
        ryoyoMap.put("3010105", "02-2"); //特定施設管理
        ryoyoMap.put("3010106", "03-2"); //特定施設管理個室加算
        ryoyoMap.put("3010107", "04-2"); //特定施設管理２人部屋加算
        ryoyoMap.put("3010144", "05-2"); //初期入所診療管理
        ryoyoMap.put("3010108", "06-2"); //重症皮膚潰瘍管理指導
        ryoyoMap.put("3010110", "09-2"); //薬剤管理指導
        ryoyoMap.put("3010111", "10-2"); //特別薬剤管理指導加算
        ryoyoMap.put("3010145", "11-2"); //医学情報提供
        ryoyoMap.put("3010136", "31-2"); //摂食機能療法
        ryoyoMap.put("3010137", "32-2"); //精神科作業療法
        ryoyoMap.put("3010149", "33-2"); //認知症性老人入所精神療法
        ryoyoMap.put("3010102", "34-2"); //褥瘡対策指導管理
        ryoyoMap.put("3010104", "35-2"); //重要療養管理
        ryoyoMap.put("3010147", "39-2"); //言語聴覚療法
        ryoyoMap.put("3010148", "47-2"); //言語聴覚療法(減算
        ryoyoMap.put("3010141", "50-2"); //言語聴覚療法リハビリ体制強化加算
        ryoyoMap.put("3010146", "53-2"); //リハビリテーション指導管理
        
        return ryoyoMap;
    }
    
    private Map<String, String> getShinryoMap() {
        
        if (shinryoMap != null) {
            return shinryoMap;
        }
        
        
        shinryoMap = new HashMap<String, String>();
        
        shinryoMap.put("3010101", "01-1"); //感染対策指導管理
        shinryoMap.put("3010102", "34-1"); //褥瘡対策指導管理
        shinryoMap.put("3010103", "05-1"); //初期入院診療管理
        shinryoMap.put("3010104", "35-1"); //重要療養管理
        shinryoMap.put("3010105", "02-1"); //特定施設管理
        shinryoMap.put("3010106", "03-1"); //特定施設管理個室加算
        shinryoMap.put("3010107", "04-1"); //特定施設管理２人部屋加算
        shinryoMap.put("3010108", "06-1"); //重症皮膚潰瘍管理指導
        shinryoMap.put("3010110", "09-1"); //薬剤管理指導
        shinryoMap.put("3010111", "10-1"); //特別薬剤管理指導加算
        shinryoMap.put("3010112", "11-1"); //医学情報提供(Ⅰ
        shinryoMap.put("3010113", "12-1"); //医学情報提供(Ⅱ
        shinryoMap.put("3010114", "14-1"); //理学療法(Ⅰ
        shinryoMap.put("3010115", "16-1"); //理学療法(Ⅱ
        shinryoMap.put("3010116", "18-1"); //理学療法(Ⅲ
        shinryoMap.put("3010117", "19-1"); //理学療法(Ⅳ
        shinryoMap.put("3010118", "40-1"); //理学療法(Ⅰ
        shinryoMap.put("3010119", "41-1"); //理学療法(Ⅱ
        shinryoMap.put("3010120", "42-1"); //理学療法(Ⅲ
        shinryoMap.put("3010121", "43-1"); //理学療法(Ⅳ
        shinryoMap.put("3010122", "36-1"); //理学療法日常生活活動訓練加算回数-0・1・2・3
        shinryoMap.put("3010123", "20-1"); //理学療法リハビリ計画加算
        shinryoMap.put("3010124", "22-1"); //理学療法日常動作訓練指導加算
        shinryoMap.put("3010125", "23-1"); //作業療法(Ⅰ
        shinryoMap.put("3010126", "25-1"); //作業療法(Ⅱ
        shinryoMap.put("3010127", "44-1"); //作業療法(Ⅰ
        shinryoMap.put("3010128", "45-1"); //作業療法(Ⅱ
        shinryoMap.put("3010129", "37-1"); //作業療法日常生活活動訓練加算回数-0・1・2・3
        shinryoMap.put("3010130", "27-1"); //作業療法リハビリ計画加算
        shinryoMap.put("3010131", "29-1"); //作業療法日常動作訓練指導加算
        shinryoMap.put("3010132", "38-1"); //言語聴覚療法(Ⅰ
        shinryoMap.put("3010133", "39-1"); //言語聴覚療法(Ⅱ
        shinryoMap.put("3010134", "46-1"); //言語聴覚療法(Ⅰ
        shinryoMap.put("3010135", "47-1"); //言語聴覚療法(Ⅱ
        shinryoMap.put("3010136", "31-1"); //摂食機能療法
        shinryoMap.put("3010137", "32-1"); //精神科作業療法
        shinryoMap.put("3010138", "33-1"); //認知症性老人入院精神療法
        shinryoMap.put("3010139", "48-1"); //理学療法リハビリ体制強化加算
        shinryoMap.put("3010140", "49-1"); //作業療法リハビリ体制強化加算
        shinryoMap.put("3010141", "50-1"); //言語聴覚療法リハビリ体制強化加算
        shinryoMap.put("3010142", "51-1"); //リハビリマネジメント加算
        shinryoMap.put("3010143", "52-1"); //短期集中リハビリ加算
        shinryoMap.put("3010150", "54-1"); //集団コミュニケーション療法
        shinryoMap.put("3010151", "55-1"); //認知症短期集中リハビリ加算
       
        return shinryoMap;

    }
    
    
    // [H30.4改正対応][Yoichiro Kamei] 2018/3/13 add - begin
    private Map<String, String> getTokubetuShinryoMap() {
        
        if (tokubetuShinryoMap != null) {
            return tokubetuShinryoMap;
        }
        
        
        tokubetuShinryoMap = new HashMap<String, String>();
        
        tokubetuShinryoMap.put("3010101", "01-3"); //感染対策指導管理
        tokubetuShinryoMap.put("3010102", "34-3"); //褥瘡管理
        tokubetuShinryoMap.put("3010103", "05-3"); //初期入所診療管理
        tokubetuShinryoMap.put("3010104", "35-3"); //重要療養管理
        tokubetuShinryoMap.put("3010105", "02-3"); //特定施設管理
        tokubetuShinryoMap.put("3010106", "03-3"); //特定施設管理個室加算
        tokubetuShinryoMap.put("3010107", "04-3"); //特定施設管理２人部屋加算
        tokubetuShinryoMap.put("3010108", "06-3"); //重症皮膚潰瘍管理指導
        tokubetuShinryoMap.put("3010110", "09-3"); //薬剤管理指導
        tokubetuShinryoMap.put("3010111", "10-3"); //特別薬剤管理指導加算
        tokubetuShinryoMap.put("3010112", "11-3"); //医学情報提供(Ⅰ
        tokubetuShinryoMap.put("3010113", "12-3"); //医学情報提供(Ⅱ
        tokubetuShinryoMap.put("3010114", "14-3"); //理学療法(Ⅰ
        tokubetuShinryoMap.put("3010115", "16-3"); //理学療法(Ⅱ
        tokubetuShinryoMap.put("3010116", "18-3"); //理学療法(Ⅲ
        tokubetuShinryoMap.put("3010117", "19-3"); //理学療法(Ⅳ
        tokubetuShinryoMap.put("3010118", "40-3"); //理学療法(Ⅰ
        tokubetuShinryoMap.put("3010119", "41-3"); //理学療法(Ⅱ
        tokubetuShinryoMap.put("3010120", "42-3"); //理学療法(Ⅲ
        tokubetuShinryoMap.put("3010121", "43-3"); //理学療法(Ⅳ
        tokubetuShinryoMap.put("3010122", "36-3"); //理学療法日常生活活動訓練加算回数-0・1・2・3
        tokubetuShinryoMap.put("3010123", "20-3"); //理学療法リハビリ計画加算
        tokubetuShinryoMap.put("3010124", "22-3"); //理学療法日常動作訓練指導加算
        tokubetuShinryoMap.put("3010125", "23-3"); //作業療法(Ⅰ
        tokubetuShinryoMap.put("3010126", "25-3"); //作業療法(Ⅱ
        tokubetuShinryoMap.put("3010127", "44-3"); //作業療法(Ⅰ
        tokubetuShinryoMap.put("3010128", "45-3"); //作業療法(Ⅱ
        tokubetuShinryoMap.put("3010129", "37-3"); //作業療法日常生活活動訓練加算回数-0・1・2・3
        tokubetuShinryoMap.put("3010130", "27-3"); //作業療法リハビリ計画加算
        tokubetuShinryoMap.put("3010131", "29-3"); //作業療法日常動作訓練指導加算
        tokubetuShinryoMap.put("3010132", "38-3"); //言語聴覚療法(Ⅰ
        tokubetuShinryoMap.put("3010133", "39-3"); //言語聴覚療法(Ⅱ
        tokubetuShinryoMap.put("3010134", "46-3"); //言語聴覚療法(Ⅰ
        tokubetuShinryoMap.put("3010135", "47-3"); //言語聴覚療法(Ⅱ
        tokubetuShinryoMap.put("3010136", "31-3"); //摂食機能療法
        tokubetuShinryoMap.put("3010137", "32-3"); //精神科作業療法
        tokubetuShinryoMap.put("3010138", "33-3"); //認知症入所精神療法
        tokubetuShinryoMap.put("3010139", "48-3"); //理学療法リハビリ体制強化加算
        tokubetuShinryoMap.put("3010140", "49-3"); //作業療法リハビリ体制強化加算
        tokubetuShinryoMap.put("3010141", "50-3"); //言語聴覚療法リハビリ体制強化加算
        tokubetuShinryoMap.put("3010142", "51-3"); //リハビリマネジメント加算
        tokubetuShinryoMap.put("3010143", "52-3"); //短期集中リハビリ加算
        tokubetuShinryoMap.put("3010150", "54-3"); //集団コミュニケーション療法
        tokubetuShinryoMap.put("3010151", "55-3"); //認知症短期集中リハビリ加算
       
        return tokubetuShinryoMap;

    }
    // [H30.4改正対応][Yoichiro Kamei] 2018/3/13 add - end
    
    
    
    
    //特別療養費のコードセットを作成
    private Set<String> createRyoyoSet() {
        Set<String> set = new HashSet<String>();
        
        //短期入所療養介護（老健）
        set.add("12211");
        //予防短期入所療養介護（老健）
        set.add("12511");
        //介護老人保健施設
        set.add("15211");
        
        return set;
    }
    
    //特定診療費のコードセットを作成
    private Set<String> createShinryoSet() {
        Set<String> set = new HashSet<String>();
        
        //短期入所療養介護（病院）
        set.add("12311");
        //短期入所療養介護（診療所）
        set.add("12312");
        //短期入所療養介護（認知症）
        set.add("12313");
        //予防短期入所療養介護（病院）
        set.add("12611");
        //予防短期入所療養介護（診療所）
        set.add("12612");
        //予防短期入所療養介護（認知症）
        set.add("12613");
        //介護療養型医療施設（病院）
        set.add("15311");
        //介護療養型医療施設（診療所）
        set.add("15312");
        //介護療養型医療施設（認知症）
        set.add("15313");
        
        return set;
    }
    
    // [H30.4改正対応][Yoichiro Kamei] 2018/3/13 add - begin
    //特別診療費のコードセットを作成
    private Set<String> createTokubetuShinryoSet() {
        Set<String> set = new HashSet<String>();
        
        //介護医療院
        set.add("15511");
        //短期入所療養介護(介護医療院)
        set.add("204211");
        //介護予防短期入所療養介護(介護医療院)
        set.add("204311");
        
        return set;
    }
    // [H30.4改正対応][Yoichiro Kamei] 2018/3/13 add - end
    
    /**
     * 解析後の特定診療費・特別療養費の設定リストを取得します。
     * 
     * @return
     */
    public Map<String, Map> getDiagnosisDateMap() {
    	if(diagnosisDateMap == null) {
    		return new VRHashMap();
    	}
		return diagnosisDateMap;
	}
    
    
    //テストコード
    public static void main(String[] args) throws Exception {
        
        String server = "172.23.25.91";
        int port = 3050;
        String userName = "SYSDBA";
        String pass = "masterkey";
        String path = "C:\\database\\qkan.fdb";
        int loginTimeOut = 1;
        int maxPoolSize = 500;
        String charSet = "MS932";
        String encoding = "SJIS_0208";
        
        CareServicePrecomputed t = new CareServicePrecomputed();
        BridgeFirebirdDBManager fdb = new BridgeFirebirdDBManager(server, port, userName, pass, path, loginTimeOut, maxPoolSize, charSet, encoding);
        
        
        VRList serviceList = QkanCommon.getServiceDetail(
                fdb, 9, ACCastUtilities.toDate("20120401"),
                QkanConstants.SERVICE_USE_TYPE_RESULT_MONTHLY_DAY.intValue());
        
        Map<String, Integer> u = new HashMap<String, Integer>();
        Map<String, Integer> d = new HashMap<String, Integer>();
        
        t.setPrecomputedResult(fdb, serviceList, u, d);
        
        System.out.println("--------------------");
        for (Entry<String, Integer> key: u.entrySet()) {
            System.out.println(key.getKey());
            System.out.println(key.getValue());
        }
        System.out.println("--------------------");
        for (Entry<String, Integer> key: d.entrySet()) {
            System.out.println(key.getKey());
            System.out.println(key.getValue());
        }
        System.out.println("--------------------");
    }
    
    
}
