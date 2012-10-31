package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import jp.nichicom.ac.core.ACDBManagerCreatable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * <p>
 * サービスパネルデータ逆生成クラス管理用のクラスです。
 * </p>
 * QkanValidServiceManagerです。
 * <p>
 * Copyright (c) 2007 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Masahiko Higuchi
 * @version 1.0 2008/01/11
 * @since version 5.4.1
 */
public class QkanValidServiceManager {

    private static QkanValidServiceManager singleton;

    // システム日付
    private Date sysYmd;

    // 要支援→要介護
    public static final Integer YOSHIEN_TO_YOKAIGO = new Integer(1020);
    // 要介護→要介護
    public static final Integer YOKAIGO_TO_YOKAIGO = new Integer(2020);
    // 要介護→要支援
    public static final Integer YOKAIGO_TO_YOSHIEN = new Integer(2010);
    // 要支援→要支援
    public static final Integer YOSHIEN_TO_YOSHIEN = new Integer(1010);
    
    
    private Map<String, AbstractQkanValidServiceGetter> validService = null;
    
    private int[] historyPatterns;
    private int facilityOfferPattern;
    private Integer changeMode;

    /**
     * 解析対象の年月
     * @param sysYmd
     */
    public void setSysYmd(Date sysYmd) {
        this.sysYmd = sysYmd;
        
        // このタイミングでキャッシュを初期化
        validService = new HashMap<String, AbstractQkanValidServiceGetter>();
    }
    
    /**
     * 要介護認定履歴変化のパターン登録
     * @param historyPattern
     */
    public void setHistoryPatterns(int[] historyPatterns) {
        this.historyPatterns = historyPatterns;
    }
    
    /**
     * 施設系サービス提供日のパターン登録
     * @param facilityOfferPattern
     */
    public void setFacilityOfferPattern(int facilityOfferPattern) {
        this.facilityOfferPattern = facilityOfferPattern;
    }
    
    /**
     * 要介護度の変化パターン
     * @param changeMode
     */
    public void setChangeMode(Integer changeMode) {
        this.changeMode = changeMode;
    }

    /**
     * ダミーサービスコード生成クラスを取得します。
     * 
     * @return
     */
    public static QkanValidServiceManager getInstance() {
        if (singleton == null) {
            singleton = new QkanValidServiceManager();
        }

        return singleton;
    }
    
    
    /**
     * 日割りにすべきなのに、日割りとなっていないサービスであるか
     * @param service パネルデータ
     * @return true:リストから削除 false:リストに保持
     * @throws Exception
     */
    public boolean checkDeleteService(VRMap service) throws Exception {
        
        String serviceKindDetail = ACCastUtilities.toString(service.get("SYSTEM_SERVICE_KIND_DETAIL"), "");
        String providerId = ACCastUtilities.toString(service.get("PROVIDER_ID"), "");
        
        // 事業所番号 - サービス種類をキーとする
        String key = providerId + "-" + serviceKindDetail;
        AbstractQkanValidServiceGetter getter = null;
        
        if (validService.containsKey(key)) {
            getter = validService.get(key);
            
        } else {
            getter = getValidServiceGetter(serviceKindDetail, sysYmd);
            if (getter == null) {
                return false;
            }
            
            // 認定履歴のパターンを設定
            getter.setHistoryPatterns(historyPatterns, facilityOfferPattern);
            validService.put(key, getter);
        }
        
        // 日割り展開を行うべき要介護変化でない場合は、処理をキャンセル
        if (!getter.isValidDataCreateService(changeMode)) {
            return false;
        }
        
        return getter.checkDeleteService(service);
    }
    
    
    /**
     * 自動日割り展開したデータリストを返す
     * @return
     * @throws Exception
     */
    public VRList getProRatedList() throws Exception {
        
        VRList list = new VRArrayList();
        
        for (Entry<String, AbstractQkanValidServiceGetter> entry : validService.entrySet()) {
            list.addAll(entry.getValue().getProRatedList());
        }
        
        return list;
    }

    
    
    /**
     * 内部システムサービス種類コードに応じてダミー変換用のマネージャーを生成します。
     * 
     * @param serviceTypeCode
     * @param targetDate
     * @return
     * 
     */
    private AbstractQkanValidServiceGetter getValidServiceGetter(String systemServiceCodeKind, Date targetDate) {
        AbstractQkanValidServiceGetter serviceGetter = null;

        StringBuilder sb = new StringBuilder();
        Class<AbstractQkanValidServiceGetter> svClass = null;

        try {
            // 年度に対応したクラスを文字列から生成する
            sb.append("jp.nichicom.ac.lib.care.claim.servicecode.");
            sb.append("SV_");
            sb.append(systemServiceCodeKind);
            sb.append("_");
            sb.append(QkanCommon.getServiceLowVersion(systemServiceCodeKind,
                    targetDate, ((ACDBManagerCreatable) ACFrame.getInstance()
                            .getFrameEventProcesser()).createDBManager()));
            // クラス生成
            svClass = (Class<AbstractQkanValidServiceGetter>) Class.forName(sb
                    .toString());

            if (svClass != null) {
                serviceGetter = (AbstractQkanValidServiceGetter) svClass
                        .newInstance();
            }

        } catch (ClassNotFoundException e) { // by Class.forName
            // 指定した名称のクラス存在しなかった場合
            //e.printStackTrace();
            serviceGetter = null;

        } catch (InstantiationException e) { // by newInstance()
            // インスタンス作成不可の場合（パラメータなしのコンストラクタ存在しない場合 - new Xxxx()でエラーの場合）
            e.printStackTrace();

        } catch (IllegalAccessException e) { // by newInstance()
            // 権限はないとき
            e.printStackTrace();

        } catch (Exception e) {
            // 例外エラー

        }

        return serviceGetter;
    }
    
    
}
