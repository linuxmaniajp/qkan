package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.Iterator;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
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

        if (obj != null) {
            if (getMasterService() != null) {
                int val = ACCastUtilities.toInt(obj, 0) - 1000;
                if (val > 0) {
                    Iterator it = getMasterService().values().iterator();
                    while (it.hasNext()) {
                        Map row = (Map) it.next();
                        if (ACCastUtilities.toInt(row.get("SERVICE_CODE_KIND"),
                                0) == val) {
                            // サービスの略称名に置換
                            obj = row.get("SERVICE_KIND_NAME");
                            if (obj != null) {
                                toAppendTo.append(obj);
                                break;
                            }
                        }
                    }

                }
            }
        }
        return toAppendTo;
    }

    public Object parseObject(String source, ParsePosition pos) {

        if (source == null)
            return null;

        String result = null;

        return result;
    }

}
