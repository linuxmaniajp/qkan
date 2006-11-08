package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.util.VRMap;

/**
 * システムサービス種類コードを渡された場合、コードから名称に変換するフォーマットです。<br>
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Kazuyoshi Kamitsukasa
 * @version 1.0 2006/01/20
 * @see Format
 */
public class QkanServiceAbbreviationFormat extends Format{
    private static QkanServiceAbbreviationFormat singleton;
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
    protected QkanServiceAbbreviationFormat() {
        super();
    }

    /**
     * インスタンスを返します。
     * 
     * @return インスタンス
     */
    public static QkanServiceAbbreviationFormat getInstance() {
        if (singleton == null) {
            singleton = new QkanServiceAbbreviationFormat();
        }
        return singleton;
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {

        if (obj != null){
            if (getMasterService() != null) {
                Object service = getMasterService().get(
                        ACCastUtilities.toInteger(obj, 0));
                if (service instanceof Map) {
                    // サービスの略称名に置換
                    obj = ((Map) service).get("SERVICE_ABBREVIATION");
                    if (obj != null) {
                        toAppendTo.append(obj);
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

        // システムサービス種類コードの判定を行う。
        // 11101-訪問介護
        if ("訪問介護".equals(source)) {
            result = "11101";
            // 11201-訪問入浴介護
        } else if ("訪問入浴介護".equals(source)) {
            result = "11201";
            // 11301-訪問看護(介護保険)
        } else if ("訪問看護(介護保険)".equals(source) || "訪問看護（介護保険）".equals(source)) {
            result = "11301";
            // 20101-訪問看護(医療保険)
        } else if ("訪問看護(医療保険)".equals(source) || "訪問看護（医療保険）".equals(source)) {
            result = "20101";
            // 11401-訪問リハ
        } else if ("訪問リハ".equals(source)) {
            result = "11401";
            // 11501-通所介護
        } else if ("通所介護".equals(source)) {
            result = "11501";
            // 11601-通所リハ
        } else if ("通所リハ".equals(source)) {
            result = "11601";
            // 11701-福祉用具貸与
        } else if ("福祉用具貸与".equals(source)) {
            result = "11701";
            // 12101-短期入所生活介護
        } else if ("短期入所生活介護".equals(source)) {
            result = "12101";
            // 12201-短期入所療養介護(老健施設)
        } else if ("短期入所療養介護(老健施設)".equals(source) || "短期入所療養介護（老健施設）".equals(source)) {
            result = "12201";
            // 12301-短期入所療養介護(病院療養型)
        } else if ("短期入所療養介護(病院療養型)".equals(source) || "短期入所療養介護（病院療養型）".equals(source)) {
            result = "12301";
            // 12302-短期入所療養介護(診療所療養型)
        } else if ("短期入所療養介護(診療所療養型)".equals(source) || "短期入所療養介護（診療所療養型）".equals(source)) {
            result = "12302";
            // 12303-短期入所療養介護(認知症疾患型)
        } else if ("短期入所療養介護(認知症疾患型)".equals(source) || "短期入所療養介護（認知症疾患型）".equals(source)) {
            result = "12303";
            // 12304-短期入所療養介護(基準適合診療所型)
        } else if ("短期入所療養介護(基準適合診療所型)".equals(source) || "短期入所療養介護（基準適合診療所型）".equals(source)) {
            result = "12304";
            // 13101-居宅療養管理指導
        } else if ("居宅療養管理指導".equals(source)) {
            result = "13101";
            // 13201-認知症対応型共同生活介護
        } else if ("認知症対応型共同生活介護".equals(source)) {
            result = "13201";
            // 13301-特定施設入所者生活介護
        } else if ("特定施設入所者生活介護".equals(source)) {
            result = "13301";
            // 14301-居宅介護支援
        } else if ("居宅介護支援".equals(source)) {
            result = "14301";
            // 15101-介護老人福祉施設
        } else if ("介護老人福祉施設".equals(source)) {
            result = "15101";
            // 15201-介護老人保健施設
        } else if ("介護老人保健施設".equals(source)) {
            result = "15201";
            // 15301-介護療養型医療施設(療養型病院)
        } else if ("介護療養型医療施設(療養型病院)".equals(source) || "介護療養型医療施設（療養型病院）".equals(source)) {
            result = "15301";
            // 15302-介護療養型医療施設(診療所型)
        } else if ("介護療養型医療施設(診療所型)".equals(source) || "介護療養型医療施設（診療所型）".equals(source)) {
            result = "15302";
            // 15303-介護療養型医療施設(認知症疾患型)
        } else if ("介護療養型医療施設(認知症疾患型)".equals(source) || "介護療養型医療施設（認知症疾患型）".equals(source)) {
            result = "15303";
            // 90101-その他
        } else if ("その他".equals(source)) {
            result = "90101";
            // 90201-主な日常生活上の活動
        } else if ("主な日常生活上の活動".equals(source)) {
            result = "90201";
        }

        return result;
    }

}
