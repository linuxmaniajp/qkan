package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jp.nichicom.ac.core.ACDBManagerCreatable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * サービスコード生成ロジック
 */
public class Qkan10011_ServiceCodeManager {
                                           
    private static Qkan10011_ServiceCodeManager singleton;

    public static Qkan10011_ServiceCodeManager getInstance() {
        if (singleton == null) {
            singleton = new Qkan10011_ServiceCodeManager();
        }

        return singleton;
    }

    private int serviceCodeCacheLimit = 1000;
    private HashMap<String, VRList> serviceCodeCache = new HashMap<String, VRList>();
    private HashMap<String, Object> unitGetterCache = new HashMap<String, Object>();
    private ACDBManager dbManager = null;

    /**
     * ACDBManagerを返却します。
     * 
     * @return dbManager
     */
    public ACDBManager getDBManager() throws Exception {
        if (dbManager == null) {
            dbManager = ((ACDBManagerCreatable) ACFrame.getInstance()
                    .getFrameEventProcesser()).createDBManager();
        }
        return dbManager;
    }

    public Qkan10011_ServiceUnitGetter getService(String serviceCodeKind,
            Date targetDate) {

        try {
            Object obj = unitGetterCache.get(serviceCodeKind);
            if (obj == null) {
                obj = getUnitGetter(Integer.parseInt(serviceCodeKind),
                        targetDate);
            }
            return (Qkan10011_ServiceUnitGetter) obj;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    protected Qkan10011_ServiceCodeManager() {
    }

    public String getServiceName() {
        return "";
    }

    public String getServiceName(String serviceCodeKind, Date targetDate) {
        try {
            Object obj = unitGetterCache.get(serviceCodeKind);
            if (obj == null) {
                obj = getUnitGetter(Integer.parseInt(serviceCodeKind),
                        targetDate);
            }
            return ((Qkan10011_ServiceUnitGetter) obj).getServiceName();
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public String getServiceCodeKind() {
        return "";
    }

    public String getServiceCodeKind(String serviceCodeKind, Date targetDate) {
        try {
            Object obj = unitGetterCache.get(serviceCodeKind);
            if (obj == null) {

                obj = getUnitGetter(Integer.parseInt(serviceCodeKind),
                        targetDate);
            }
            return ((Qkan10011_ServiceUnitGetter) obj).getServiceCodeKind();
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public String getSystemServiceKindDetail() {
        return "";

    }

    public String getSystemServiceKindDetail(String serviceCodeKind,
            Date targetDate) {
        try {
            Object obj = unitGetterCache.get(serviceCodeKind);
            if (obj == null) {
                obj = getUnitGetter(Integer.parseInt(serviceCodeKind),
                        targetDate);
            }
            return ((Qkan10011_ServiceUnitGetter) obj)
                    .getSystemServiceKindDetail();
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    protected ArrayList getSystemServiceCodeItem(Map map) {
        return new ArrayList();
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            String serviceCodeKind, HashMap<String, String> map, Date targetDate) {
        try {
            Object obj = unitGetterCache.get(serviceCodeKind);
            if (obj == null) {
                obj = getUnitGetter(Integer.parseInt(serviceCodeKind),
                        targetDate);
            }
            return ((Qkan10011_ServiceUnitGetter) obj)
                    .getSystemServiceCodeItem(map);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ArrayList<HashMap<String, String>>();
    }

    /**
     * サービスコード集合を返します。
     * 
     * @param systemServiceKindDetail
     *            サービス種類コード
     * @param map
     *            算定項目
     * @param targetDate
     *            対象年月（有効期間のキー）
     * @param dbm
     *            DBマネージャ
     * @return サービスコード集合
     */
    public ArrayList<VRMap> getServiceCode(String systemServiceKindDetail,
            HashMap<String, String> map, Date targetDate, ACDBManager dbm) {
        try {
            Qkan10011_ServiceUnitGetter ug = getUnitGetter(
                    Integer.parseInt(systemServiceKindDetail), targetDate);
            if (ug == null) {
                return new ArrayList<VRMap>();
            }
            ug.setSysYmd(targetDate);
            return ug.getServiceCode(map, dbm);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<VRMap>();
        }
    }

    /**
     * サービスコード生成ロジッククラスを取得します。
     * 
     * @param serviceTypeCode
     * @param targetDate
     * @return
     */
    @SuppressWarnings("unchecked")
    private Qkan10011_ServiceUnitGetter getUnitGetter(int serviceTypeCode,
            Date targetDate) {

        Qkan10011_ServiceUnitGetter unitGetter = null;
        StringBuilder sb = new StringBuilder();
        String serviceTypeCodeVal = "";
        Class<Qkan10011_ServiceUnitGetter> serviceClass = null;

        try {
            serviceTypeCodeVal = ACCastUtilities.toString(serviceTypeCode);

            // クラス名を構築する
            sb.append("jp.nichicom.ac.lib.care.claim.servicecode.");
            sb.append("SC_");
            sb.append(serviceTypeCodeVal);
            sb.append("_");
            sb.append(QkanCommon.getServiceLowVersion(serviceTypeCodeVal,
                    targetDate, getDBManager()));
            // クラス生成
            serviceClass = (Class<Qkan10011_ServiceUnitGetter>) Class
                    .forName(sb.toString());

            if (serviceClass != null) {
                unitGetter = (Qkan10011_ServiceUnitGetter) serviceClass
                        .newInstance();
            }

        } catch (ClassNotFoundException e) { // by Class.forName
            // 指定した名称のクラス存在しなかった場合
            e.printStackTrace();

        } catch (InstantiationException e) { // by newInstance()
            // インスタンス作成不可の場合（パラメータなしのコンストラクタ存在しない場合 - new Xxxx()でエラーの場合）
            e.printStackTrace();

        } catch (IllegalAccessException e) { // by newInstance()
            // 権限はないとき
            e.printStackTrace();

        } catch (Exception e) {
            // 例外エラー

        }

        return unitGetter;
    }

    /**
     * サービスコードのキャッシュをクリアします。
     */
    public void clearServiceCodeCache() {
        getServiceCodeCache().clear();
    }

    /**
     * サービスコードのキャッシュマップ を返します。
     * 
     * @return サービスコードのキャッシュマップ
     */
    public HashMap<String, VRList> getServiceCodeCache() {
        return serviceCodeCache;
    }

    /**
     * サービスコードのキャッシュマップ を設定します。
     * 
     * @param serviceCodeCache
     *            サービスコードのキャッシュマップ
     */
    protected void setServiceCodeCache(HashMap<String, VRList> serviceCodeCache) {
        this.serviceCodeCache = serviceCodeCache;
    }

    /**
     * サービスコードのキャッシュ限界数 を返します。
     * 
     * @return サービスコードのキャッシュ限界数
     */
    public int getServiceCodeCacheLimit() {
        return serviceCodeCacheLimit;
    }

    /**
     * サービスコードのキャッシュ限界数 を設定します。
     * 
     * @param serviceCodeCacheLimit
     *            サービスコードのキャッシュ限界数
     */
    public void setServiceCodeCacheLimit(int serviceCodeCacheLimit) {
        this.serviceCodeCacheLimit = serviceCodeCacheLimit;
    }
}
