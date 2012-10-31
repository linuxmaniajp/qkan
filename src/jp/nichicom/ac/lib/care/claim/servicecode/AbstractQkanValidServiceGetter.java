package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;

/**
 * 
 * AbstractQkanValidServiceGetterです。
 * <p>
 * Copyright (c) 2007 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Masahiko Higuchi
 * @version 1.0 2007/12/19
 * @since version 5.4.1
 */
public abstract class AbstractQkanValidServiceGetter {
    
    private static String HISTORY_PATTERN = "__HISTORY_PATTERN__";
    private static String OFFER_PATTERN = "__OFFER_PATTERN__";
    private static String OFFER_BIND_PATH = "__OFFER_BIND_PATH__";
    
    private int[] historyPatterns;
    private int facilityOfferPattern;
    
    public void setHistoryPatterns(int[] historyPatterns, int facilityOfferPattern) {
        this.historyPatterns = historyPatterns;
        this.facilityOfferPattern = facilityOfferPattern;
    }
    
    protected int getHistoryPattern(VRMap service) throws Exception {
        
        int target = getTarget(service);
        
        for (int i = 0; i < historyPatterns.length; i++) {
            // パターンにマッチする列を返却
            if ((historyPatterns[i] & target) == target) {
                return historyPatterns[i];
            }
        }
        
        // 見つかれなければ、認定期間外に置かれたサービス
        return 0;
    }
    
    protected VRMap createBaseMap(VRMap service, String hiwariBindPath, String offerBindPath) throws Exception {
        
        int history = getHistoryPattern(service);
        // 認定期間外に置かれたサービスであれば放置
        if (history == 0) {
            return null;
        }
        
        VRMap panelData = QkanValidServiceCommon.deepCopyVRMap(service);
        // 日割りチェックをON
        VRBindPathParser.set(hiwariBindPath, panelData, new Integer(2));
        // 提供日チェックをOFF
        VRBindPathParser.set(offerBindPath, panelData, new Integer(1));
        // 利用者負担額を0に
        VRBindPathParser.set("REGULATION_RATE", panelData, new Integer(0));
        // 該当の提供日を入れておく
        VRBindPathParser.set(HISTORY_PATTERN, panelData, new Integer(history));
        // 実提供日解析用
        VRBindPathParser.set(OFFER_PATTERN, panelData, new Integer(0));
        // 提供日チェックのバインドパスを覚えておく
        VRBindPathParser.set(OFFER_BIND_PATH, panelData, offerBindPath);
        
        return panelData;
    }
    
    
    protected List<VRMap> createProRatedList(VRMap panelData) throws Exception {
        
        List<VRMap> list = new ArrayList<VRMap>();
        
        if (panelData == null) {
            return list;
        }
        
        
        int history = ACCastUtilities.toInt(panelData.get(HISTORY_PATTERN));
        int offer = ACCastUtilities.toInt(panelData.get(OFFER_PATTERN));
        String offerBindPath = ACCastUtilities.toString(panelData.get(OFFER_BIND_PATH));
        
        panelData.remove(HISTORY_PATTERN);
        panelData.remove(OFFER_PATTERN);
        panelData.remove(OFFER_BIND_PATH);
        
        
        if (history == 0) {
            return list;
        }
        
        for (int i = 0; i < 31; i++) {
            
            // 施設系サービスを提供していたら、自動展開をキャンセル
            if (((facilityOfferPattern >> i) & 1) == 1) {
                continue;
            } 
            
            // 日割り展開範囲内であるか確認
            if (((history >> i) & 1) != 1) {
                continue;
            }
            
            // ダミーデータが必要な場合日割りデータ用のコピーを取得
            VRMap service = QkanValidServiceCommon.deepCopyVRMap(panelData);
            
            // 日付を該当日に変更
            Date serviceDate = ACCastUtilities.toDate(service.get("SERVICE_DATE"));
            VRBindPathParser.set("SERVICE_DATE", service, ACDateUtilities.setDayOfMonth(serviceDate, i + 1));
            
            // 日割りでは無い状態でパネルが配置されていた場合は、DUMMYフラグを付けない(提供日扱い)
            // プログラム内で生成した場合は、DUMMYフラグを付ける
            if (((offer >> i) & 1) != 1) {
                VRBindPathParser.set("DUMMY", service, new Boolean(true));
            } else {
                //提供日として扱うので、提供日チェックをONにする
                VRBindPathParser.set(offerBindPath, service, new Integer(2));
            }
            list.add(service);
        }
        
        return list;
    }
    
    
    protected void deleteHistory(VRMap dummy, VRMap service) throws Exception {
        
        int history = ACCastUtilities.toInt(dummy.get(HISTORY_PATTERN), 0);
        int target = getTarget(service);
        
        // 指定位置のフラグを確認
        if ((history & target) == target) {
            history ^= target;
        }
        
        VRBindPathParser.set(HISTORY_PATTERN, dummy, new Integer(history));
        
    }
    
    protected void deleteFacilityOffer(VRMap service) throws Exception {
        int target = getTarget(service);
        // 指定位置のフラグをOFFに
        if ((facilityOfferPattern  & target) == target) {
            facilityOfferPattern ^= target;
        }
    }
    
    
    protected void addOffer(VRMap dummy, VRMap service) throws Exception {
        
        int offer = ACCastUtilities.toInt(dummy.get(OFFER_PATTERN), 0);
        int target = getTarget(service);
        
        VRBindPathParser.set(OFFER_PATTERN, dummy, new Integer(offer | target));
        
    }
    
    private int getTarget(VRMap service) throws Exception {
        Date serviceDate = ACCastUtilities.toDate(service.get("SERVICE_DATE"));
        int targetDay = ACDateUtilities.getDayOfMonth(serviceDate) - 1;
        return (1 << targetDay);
    }
    
    // 日割り自動展開の対象とするか
    protected boolean isValidDataCreateService(Integer changeMode) {
        return true;
    }
    
    abstract protected boolean checkDeleteService(VRMap service) throws Exception;
    
    abstract protected List<VRMap> getProRatedList() throws Exception;
    
}
