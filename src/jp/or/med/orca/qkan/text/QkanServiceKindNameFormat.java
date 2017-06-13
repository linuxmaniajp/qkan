package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.Iterator;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;

/**
 * サービス種類コードを渡された場合、コードから名称に変換するフォーマットです。<br>
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Kazuyoshi Kamitsukasa
 * @version 1.0 2006/01/20
 * @see Format
 */
public class QkanServiceKindNameFormat extends Format {
    private static QkanServiceKindNameFormat singleton;
    private VRMap masterService;
// 2016/7/15 [Yoichiro Kamei] add - begin 総合事業対応
    private boolean initialized = false;
    private VRMap serviceMap = new VRHashMap();
// 2016/7/15 [Yoichiro Kamei] add - end
    
    /**
     * サービスマスタ を返します。
     * 
     * @return サービスマスタ
     */
    public VRMap getMasterService() {
        return masterService;
    }

    /**
     * サービスマスタ を設定します。
     * 
     * @param serviceMaster サービスマスタ
     */
    public void setMasterService(VRMap serviceMaster) {
        this.masterService = serviceMaster;
// 2016/7/15 [Yoichiro Kamei] add - begin 総合事業対応
        this.initialized = false;
// 2016/7/15 [Yoichiro Kamei] add - end
    }

    /**
     * コンストラクタです。
     */
    protected QkanServiceKindNameFormat() {
        super();
    }

    /**
     * インスタンスを返します。
     * 
     * @return インスタンス
     */
    public static QkanServiceKindNameFormat getInstance() {
        if (singleton == null) {
            singleton = new QkanServiceKindNameFormat();
        }
        return singleton;
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {
// 2016/7/15 [Yoichiro Kamei] mod - begin 総合事業対応
//        if (obj != null) {
//            if (getMasterService() != null) {
//                int val = ACCastUtilities.toInt(obj, 0) - 1000;
//                if (val > 0) {
//                    Iterator it = getMasterService().values().iterator();
//                    while (it.hasNext()) {
//                        Map row = (Map) it.next();
//                        if (ACCastUtilities.toInt(row.get("SERVICE_CODE_KIND"),
//                                0) == val) {
//                            // サービスの略称名に置換
//                            obj = row.get("SERVICE_KIND_NAME");
//                            if (obj != null) {
//                                toAppendTo.append(obj);
//                                break;
//                            }
//                        }
//                    }
//
//                }
//            }
//        }
        if (obj == null) {
            return toAppendTo;
        }
        
        //サービス種類コードからサービスマスタを引くためのマップを作成
        cleateServiceMap();
        
        
        int path = ACCastUtilities.toInt(obj, 0);
        String kind = "";
        switch (path) {
        // 総合事業 計画単位数のバインドパスからサービス種類コードに変換
        case 1101:
            kind = "A1";
            break;
        case 1105:
            kind = "A5";
            break;
        default:
        // 総合事業以外は、計画単位数のバインドパス - 1000の結果がサービス種類コードとなる
            int val = ACCastUtilities.toInt(obj, 0) - 1000;
            if (val > 0) {
                kind = String.valueOf(val);
            }
        }
        toAppendTo.append(getServiceName(kind));
// 2016/7/15 [Yoichiro Kamei] mod - end
        return toAppendTo;
    }

    
// 2016/7/15 [Yoichiro Kamei] add - begin 総合事業対応
    private synchronized void cleateServiceMap() {
        if (initialized) {
            //既にこのマップが作成されていたらなにもしない
            return;
        }
        if (masterService != null) {
            serviceMap.clear();
            Iterator it = masterService.values().iterator();
            while (it.hasNext()) {
                Map row = (Map) it.next();
                String kind = String.valueOf(row.get("SERVICE_CODE_KIND"));
                serviceMap.put(kind, row);
            }
        }
        initialized = true;
    }
    //サービス種類コードから名称を取得
    private String getServiceName(String serviceKind) {
        String result = "";
        Map row = (Map) this.serviceMap.get(serviceKind);
        if (row != null) {
            result = ACCastUtilities.toString(row.get("SERVICE_KIND_NAME"), "");
        }
        return result;
    }
// 2016/7/15 [Yoichiro Kamei] add - end
    
    public Object parseObject(String source, ParsePosition pos) {

        if (source == null)
            return null;

        String result = null;

        return result;
    }

}
