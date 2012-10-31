package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.List;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.util.VRMap;

/**
 * 
 * AbstractQkanValidServiceDefaultGetterです。
 * <p>
 * Copyright (c) 2007 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Masahiko Higuchi
 * @version 1.0 2007/12/19
 * @since version 5.4.1
 */
public abstract class AbstractQkanValidServiceDefaultGetter extends AbstractQkanValidServiceGetter {
    
    private VRMap panelData = null;
    
    // パネルに日割りチェックがついているかチェック
    @Override
    protected boolean checkDeleteService(VRMap service) throws Exception {
        
        // カレンダーの最初に置かれたデータであれば退避
        if (panelData == null) {
            
            panelData = createBaseMap(service, getHiwariBindPath(), getOfferBindPath());
            
            // データが取得できなかった場合は、認定期間外のデータ
            if (panelData == null) {
                return false;
            }
        }
        
        // パネルで既に日割りのチェックがついていたら、素材の良さを生かす
        if (ACCastUtilities.toInt(service.get(getHiwariBindPath()), 1) > 1) {
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
    @Override
    protected List<VRMap> getProRatedList() throws Exception {
        return createProRatedList(panelData);
    }
    
    // パネルの提供日チェックのバインドパス
    protected String getOfferBindPath() {
        return "15";
    }
    
    abstract protected String getHiwariBindPath();
    
}
