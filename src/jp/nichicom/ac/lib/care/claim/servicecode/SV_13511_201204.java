package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.util.VRMap;

/**
 * 
 * サービスパネルデータ逆生成クラスです。
 * <p>
 * サービス：介護予防特定施設入居者生活介護
 * </p>
 * QkanValid13511_YobouTokuteiです。
 * <p>
 * Copyright (c) 2007 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Masahiko.Higuchi
 * @version 1.0 2008/01/11
 * @since version 5.4.1
 */
public class SV_13511_201204 extends AbstractQkanValidServiceGetter {
    
    // 訪問介護(1)、通所介護(5)、通所リハ(6)
    private Map<String, VRMap> panelDatas = new HashMap<String, VRMap>();


    // パネルに日割りチェックがついているかチェック
    protected boolean checkDeleteService(VRMap service) throws Exception {
        
        // 外部サービス利用型が選択されていない場合は処理終了
        if (ACCastUtilities.toInt(service.get("1350101"), 0) != 2) {
            return false;
        }
        
        
        String hiwariBindPath = "";
        String offerBindPath = "";
        String _1350104 = ACCastUtilities.toString(service.get("1350104"), "");
        
        // 日割りのある外部サービスを提供しているかチェック
        switch (ACCastUtilities.toInt(_1350104, 0)) {
        case 1: // 訪問介護(日割：1350106、提供日：1350129)
            hiwariBindPath = "1350106";
            offerBindPath = "1350129";
            break;
            
        case 5: // 通所介護(日割：1350111、提供日：1350130)
            hiwariBindPath = "1350111";
            offerBindPath = "1350130";
            break;
            
        case 6: // 通所リハ(日割：1350115、提供日：1350131)
            hiwariBindPath = "1350115";
            offerBindPath = "1350131";
            break;
            
        default:
            return false;
        }
        
        VRMap panelData = null;
        if (panelDatas.containsKey(_1350104)) {
            panelData = panelDatas.get(_1350104);
            
        } else {
            panelData = createBaseMap(service, hiwariBindPath, offerBindPath);
            // 認定期間外に置かれたサービスであれば放置
            if (panelData == null) {
                return false;
            }
            panelDatas.put(_1350104, panelData);
        }
        
        
        //共食いを避けるため、施設提供パターンから除外
        deleteFacilityOffer(service);
        
        // パネルで既に日割りのチェックがついていたら、素材の良さを生かす
        if (ACCastUtilities.toInt(service.get(hiwariBindPath), 1) > 1) {
            // コピー対象の日付から削除
            deleteHistory(panelData, service);
            // リストからデータを削除しない
            return false;
        }
        
        
        // せっかくおいてもらっているので、提供日として生かす
        addOffer(panelData, service);
        
        // 日割りなしで置いてある場合は、リストから削除
        return true;
    }
    
    // 自動日割り展開データ作成
    protected List<VRMap> getProRatedList() throws Exception {
        List<VRMap> list = new ArrayList<VRMap>();
        
        for (Entry<String, VRMap> entry : panelDatas.entrySet()) {
            list.addAll(createProRatedList(entry.getValue()));
        }
        
        return list;
    }
    

}
