package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * 
 * サービス解析・逆生成用の共通メソッド群です。
 * 
 * QkanValidServiceCommonです。
 * <p>
 * Copyright (c) 2007 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Masahiko Higuchi
 * @version 1.0 2007/12/19
 * @since version 5.4.1
 */
public class QkanValidServiceCommon{    


    /**
     * 適切なサービスを解析して生成します。
     * 
     * @param addType 処理モード
     * @param dbm
     * @param targetDate 対象年月
     * @param serviceList 解析対象サービス群
     * @param patientID 利用者ID
     * @return
     * @throws Exception
     */
    public VRList createValidService(ACDBManager dbm, Date targetDate,
            VRList serviceList, int patientID) throws Exception {
        
        VRList patientInsureInfoHistory = null;
        // 要介護認定履歴の取得
        patientInsureInfoHistory = QkanCommon.getPatientInsureInfoHistory(dbm,
                targetDate, patientID);
        // 当月内に複数履歴存在しない場合は処理終了
        if (patientInsureInfoHistory.size() <= 1) {
            return serviceList;
        }
        
        // ------------------- ここから変更 -----------------------
        
        int jyotaiCodeBefore = 0;
        boolean isCreate = false;
        //要介護認定履歴
        int historyPatterns[] = new int[patientInsureInfoHistory.size()];
        Integer changeMode = null;
        
        for(int i =0;i<patientInsureInfoHistory.size();i++){
            // 履歴を取得する
            VRMap history = (VRMap)patientInsureInfoHistory.getData(i);
            int jyotaiCode = ACCastUtilities.toInt(history.getData("JOTAI_CODE"), 0);
            
            // 履歴の変化状態をチェックする。(初回は捨てる)
            if(isCreateValidService(jyotaiCodeBefore, jyotaiCode)){
                changeMode = getPatientInsurerChangeMode(jyotaiCodeBefore, jyotaiCode);
                // 解析開始
                isCreate = true;
            }
            
            jyotaiCodeBefore = jyotaiCode;
            
            
            // 認定期間を変換
            Date dayStart = ACCastUtilities.toDate(history.getData("INSURE_VALID_START"));
            Date dayEnd = ACCastUtilities.toDate(history.getData("INSURE_VALID_END"));
            
            int start = 0;
            int end = 0;
            historyPatterns[i] = 0;
            
            // 開始日が同月であれば、開始日は認定履歴開始日
            if (ACDateUtilities.getDifferenceOnMonth(targetDate, dayStart) == 0){
                start = ACDateUtilities.getDayOfMonth(dayStart);
            } else {
                // 上記以外は月初
                start = ACDateUtilities.getFirstDayOfMonth(targetDate);
            }
            
            // 終了日が同月であれば、終了日を変更
            if (ACDateUtilities.getDifferenceOnMonth(targetDate, dayEnd) == 0){
                end = ACDateUtilities.getDayOfMonth(dayEnd);
            } else {
                // 上記以外は月末
                end = ACDateUtilities.getLastDayOfMonth(targetDate);
            }
            
            for (int j = start-1; j < end; j++) {
                historyPatterns[i] += (1 << j);
            }
        }
        
        // 履歴状態で解析対象外は終了
        if(!isCreate) return serviceList;
        
        
        
        // 参照関係のないデータを作成する
        VRList cloneServiceList = deepCopyVRList(serviceList);
        // サービスを一旦ソートする
        Collections.sort(cloneServiceList, new DateComparator());
        
        //施設系のサービスを提供した日
        int facilityOfferPattern = 0;
        
        //施設系のサービスを提供した日を探し、覚えておく
        for (int i = 0; i < cloneServiceList.size(); i++) {
            
            VRMap service = (VRMap)cloneServiceList.get(i);
            
            //施設系のサービス提供日である場合
            if (CareServiceCommon.isFacility(service)
                    || CareServiceCommon.isLifeCare(service)
                    || CareServiceCommon.isShortStay(service)) {
                
                Date serviceDate = ACCastUtilities.toDate(service.get("SERVICE_DATE"));
                int day = ACDateUtilities.getDayOfMonth(serviceDate) - 1;
                facilityOfferPattern |= (1 << day);
            }
            
        }
        
        
        // 対象年月の設定
        QkanValidServiceManager.getInstance().setSysYmd(targetDate);
        // 要介護度変更のパターン登録
        QkanValidServiceManager.getInstance().setHistoryPatterns(historyPatterns);
        // 施設系サービスの提供日設定
        QkanValidServiceManager.getInstance().setFacilityOfferPattern(facilityOfferPattern);
        // 要介護度変化パターン
        QkanValidServiceManager.getInstance().setChangeMode(changeMode);
        
        // 提供サービス分ループ
        for (int i = 0; i < cloneServiceList.size(); i++) {
            
            VRMap service = (VRMap)cloneServiceList.get(i);
            
            // リストから削除すべきかチェック
            if (QkanValidServiceManager.getInstance().checkDeleteService(service)) {
                // 削除対象であれば、リストから抜く
                cloneServiceList.remove(i);
                i--;
            }
        }
        
        
        // 解析後の日割りデータを投入
        cloneServiceList.addAll(QkanValidServiceManager.getInstance().getProRatedList());
        
        
        return cloneServiceList;
        
    }
    
    
 
    /**
     * ディープコピーを行います。
     * データ群内にVRMap、VRListが存在する場合は、潜ってコピーします。
     * 
     * @param コピー対象のレコード群
     * @return
     * @throws Exception
     */
    public static VRList deepCopyVRList(VRList copyTarget) throws Exception{
        
        VRList deepCopyList = new VRArrayList();
        
        for(int i=0; i < copyTarget.size();i++){
            Object obj = copyTarget.getData(i);
            // インスタンスによる処理分岐
            if(obj instanceof VRMap){
                // VRList ⇒ VRMap の場合
                // ディープコピーのマップ版を使用する
                deepCopyList.add(deepCopyVRMap((VRMap)obj));
            }else if(obj instanceof VRList){
                // VRList ⇒ VRLst の場合
                // 再帰処理を行う
                deepCopyList.add(deepCopyVRList((VRList)obj));
            }else{
                // 何も変更無しで格納する
                deepCopyList.add(obj);
                
            }
        }        
        return deepCopyList;
    }
    
    /**
     * ディープコピーを行います。
     * データ群内にVRMap、VRListが存在する場合は、潜ってコピーします。
     * 
     * @param コピー対象のレコード
     * @return
     * @throws Exception
     */
    public static VRMap deepCopyVRMap(VRMap copyTarget) throws Exception{
        VRMap deepCopyResult = new VRHashMap();
        
        Set setKey = copyTarget.keySet();
        Iterator it = setKey.iterator();
        
        while(it.hasNext()){
            // キーを取り出す
            String key = ACCastUtilities.toString(it.next());
            Object obj = copyTarget.get(key);
            // インスタンスによる処理分岐
            if(obj instanceof VRList){
                // VRListの解析版
                deepCopyResult.setData(key,deepCopyVRList((VRList)obj));
            }else if (obj instanceof VRMap){
                // 再帰処理
                deepCopyResult.setData(key,deepCopyVRMap((VRMap)obj));
            }else{
                // コピーする
                deepCopyResult.setData(key,copyTarget.get(key));
            }
        }
        
        return deepCopyResult;
        
    }
    
    /**
     * 要介護認定履歴の変化状態を取得します。
     * 
     * @param beforeHistoryCode
     * @param afterHistoryCode
     * @return
     * @throws Exception
     */
    public Integer getPatientInsurerChangeMode(int beforeHistoryCode,
            int afterHistoryCode) throws Exception {
        // 存在しないコードはリターン
        if(beforeHistoryCode == 0 || afterHistoryCode==0){
            return new Integer(0);
        }

        // 2履歴目
        switch (beforeHistoryCode) {
        case 12: // 要支援１
        case 13: // 要支援２

            switch (afterHistoryCode) {
            case 12: // 要支援１
            case 13: // 要支援２
                // 要支援→要支援
                return QkanValidServiceManager.YOSHIEN_TO_YOSHIEN;
                
            case 11:// 経過的要介護
            case 21:// 要介護
            case 22:
            case 23:
            case 24:
            case 25:
                // 要支援→要介護
                return QkanValidServiceManager.YOSHIEN_TO_YOKAIGO;
                
            default:
                return new Integer(0);
            }
            
        case 11:// 経過的要介護
        case 21:// 要介護
        case 22:
        case 23:
        case 24:
        case 25:

            switch (afterHistoryCode) {
            case 12: // 要支援１
            case 13: // 要支援２
                // 要介護→要支援
                return QkanValidServiceManager.YOKAIGO_TO_YOSHIEN;

            case 11:// 経過的要介護
            case 21:// 要介護
            case 22:
            case 23:
            case 24:
            case 25:
                // 要介護→要介護
                return QkanValidServiceManager.YOKAIGO_TO_YOKAIGO;
                
            default:

                return new Integer(0);
            }

        default:
            return new Integer(0);
            
        }

    }
    /**
     * 定額報酬サービスの日割変換が可能であるか。
     * 
     * @return
     * @throws Exception
     */
    public boolean isCreateValidService(int beforeHistoryCode ,int afterHistoryCode) throws Exception{
        // 解析後の履歴を取得
        Integer result = getPatientInsurerChangeMode(beforeHistoryCode,afterHistoryCode);
        
        // 要介護⇒要支援
        if(QkanValidServiceManager.YOKAIGO_TO_YOSHIEN.equals(result)){
            return true;
        }
        // 要支援⇒要介護
        if(QkanValidServiceManager.YOSHIEN_TO_YOKAIGO.equals(result)){
            return true;
        }
        
        return false;
    }
    
    
    /**
     * 日付で実績をソートする。
     */
    private class DateComparator implements java.util.Comparator<Map<String, Object>> {
        public int compare(Map<String, Object> object1, Map<String, Object> object2) {
            // 日付で並び替えるクラス
            Date date1 = ACCastUtilities.toDate(object1.get("SERVICE_DATE"), null);
            Date date2 = ACCastUtilities.toDate(object2.get("SERVICE_DATE"), null);
            if(date1==null){
                if(date2==null){
                    return 0;
                }
                return -1;
            }else if(date2==null){
                return 1;
            }
            return date1.compareTo(date2);
        }
    }
    

}
